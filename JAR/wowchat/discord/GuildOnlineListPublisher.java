/*
 * GuildOnlineListPublisher.java — hardened version.
 *
 * CHANGES FROM ORIGINAL GPT VERSION:
 *
 * 1. JDA extraction via reflection made robust:
 *    The original used raw reflection with no logging if it failed, so the feature
 *    would silently stop working. Now: reflection result is cached after first success,
 *    failures are logged clearly, and the scheduler keeps retrying rather than dying.
 *
 * 2. Scheduler is properly named and isolated:
 *    The original DaemonThreadFactory was fine but the scheduler could swallow
 *    exceptions silently. Now we log any unexpected error in tick() clearly.
 *
 * 3. Config loading is more defensive:
 *    channelId parsing is cleaner with a single try/catch pattern.
 *
 * 4. Message marker changed to a single recognizable invisible char sequence.
 *    Functionally identical to original but easier to reason about.
 *
 * 5. No logic changes to the core update/edit/find cycle — that part was correct.
 *
 * NOTE ON THE REFLECTION HACK:
 *    The JDA field in Discord.java is private with no public accessor. Since we're
 *    working with a decompiled JAR and can't modify Discord.java directly, reflection
 *    is the correct workaround here. We cache the result so reflection only runs once.
 */
package wowchat.discord;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import scala.Option;
import scala.collection.Iterator;
import scala.collection.mutable.Map;
import wowchat.common.Global$;
import wowchat.game.GameCommandHandler;
import wowchat.game.GamePacketHandler;
import wowchat.game.GuildMember;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public final class GuildOnlineListPublisher {

    /**
     * Invisible Unicode marker appended to our message so we can identify it
     * in channel history without affecting visible content.
     * 10 zero-width spaces — same as original.
     */
    private static final String MARKER = "\u200b\u200b\u200b\u200b\u200b\u200b\u200b\u200b\u200b\u200b";

    // Config values — loaded once at init()
    private static volatile long    channelId     = 0L;
    private static volatile int     updateMinutes = 5;
    private static volatile Set<String> ignoreLower = Collections.emptySet();

    // Runtime state
    private static volatile boolean started     = false;
    private static volatile String  messageId   = null;
    private static volatile String  lastPayload = null;

    // Cached JDA reference — extracted once via reflection, reused forever after
    // NOTE: If this is null after the first successful extraction it means something
    // is seriously wrong with the Discord class structure.
    private static volatile JDA cachedJda = null;

    private static ScheduledExecutorService scheduler;

    private GuildOnlineListPublisher() {}

    // -------------------------------------------------------------------------
    // Init — called once from WoWChat.main()
    // -------------------------------------------------------------------------

    public static synchronized void init() {
        if (started) return;
        started = true;

        loadConfig();

        if (channelId <= 0L) {
            // No channel configured — feature disabled, nothing to do
            return;
        }

        System.out.println("[GuildOnlineList] Initializing. Channel ID: " + channelId
            + ", update interval: " + updateMinutes + " min.");

        scheduler = Executors.newSingleThreadScheduledExecutor(
            new DaemonThreadFactory("wowchat-online-list"));

        long initialDelaySec = 30L;
        long periodSec       = Math.max(1, updateMinutes) * 60L;

        scheduler.scheduleAtFixedRate(() -> {
            try {
                tick();
            } catch (Throwable t) {
                // Log but do NOT let the exception kill the scheduled task
                System.err.println("[GuildOnlineList] Unexpected error in update tick: " + t.getMessage());
            }
        }, initialDelaySec, periodSec, TimeUnit.SECONDS);
    }

    // -------------------------------------------------------------------------
    // Main update tick
    // -------------------------------------------------------------------------

    private static void tick() {
        JDA jda = getJda();
        if (jda == null) {
            // Not ready yet (Discord not fully connected), skip this tick
            return;
        }

        TextChannel channel = jda.getTextChannelById(channelId);
        if (channel == null) {
            System.err.println("[GuildOnlineList] Could not find text channel with ID " + channelId
                + ". Check your guildOnlineListChannelId config value.");
            return;
        }

        // Build the sorted list of online member names
        List<String> onlineNames = getOnlineNames();
        Collections.sort(onlineNames, String.CASE_INSENSITIVE_ORDER);

        String payload = onlineNames.isEmpty() ? "No Guildies Online" : String.join("\n", onlineNames);

        // Find our existing message if we don't have its ID cached
        if (messageId == null) {
            messageId = findExistingMessageId(channel);
        }

        // Skip the API call if nothing changed and message still exists
        if (payload.equals(lastPayload) && messageId != null) {
            boolean stillExists = true;
            try {
                channel.retrieveMessageById(messageId).complete();
            } catch (Throwable t) {
                stillExists = false;
            }
            if (stillExists) return;
            messageId = null; // Message was deleted — will recreate below
        }

        String fullContent = payload + MARKER;

        if (messageId == null) {
            // Post a new message
            try {
                Message sent = channel.sendMessage(fullContent).complete();
                messageId   = sent.getId();
                lastPayload = payload;
            } catch (Throwable t) {
                System.err.println("[GuildOnlineList] Failed to send message: " + t.getMessage());
            }
        } else {
            // Edit the existing message
            try {
                channel.editMessageById(messageId, fullContent).complete();
                lastPayload = payload;
            } catch (Throwable t) {
                // Message may have been deleted — reset and retry next tick
                System.err.println("[GuildOnlineList] Failed to edit message (will retry): " + t.getMessage());
                messageId   = null;
                lastPayload = null;
            }
        }
    }

    // -------------------------------------------------------------------------
    // Get list of online guild member names (excluding ignored names)
    // -------------------------------------------------------------------------

    private static List<String> getOnlineNames() {
        try {
            Option<GameCommandHandler> gameOpt = Global$.MODULE$.game();
            if (gameOpt == null || gameOpt.isEmpty()) return Collections.emptyList();

            GameCommandHandler handler = gameOpt.get();
            if (!(handler instanceof GamePacketHandler)) return Collections.emptyList();

            Map<Object, GuildMember> roster = ((GamePacketHandler) handler).guildRoster();
            if (roster == null) return Collections.emptyList();

            List<String> result = new ArrayList<>();
            Iterator<GuildMember> it = roster.valuesIterator();

            while (it.hasNext()) {
                Object val = it.next();
                if (!(val instanceof GuildMember)) continue;

                GuildMember member = (GuildMember) val;
                if (!member.isOnline()) continue;

                String name = member.name();
                if (name == null || name.trim().isEmpty()) continue;

                String trimmed = name.trim();
                if (!ignoreLower.isEmpty()
                        && ignoreLower.contains(trimmed.toLowerCase(Locale.ROOT))) continue;

                result.add(trimmed);
            }

            return result;
        } catch (Throwable t) {
            System.err.println("[GuildOnlineList] Error reading guild roster: " + t.getMessage());
            return Collections.emptyList();
        }
    }

    // -------------------------------------------------------------------------
    // Find our previously posted message in channel history
    // -------------------------------------------------------------------------

    private static String findExistingMessageId(TextChannel channel) {
        try {
            List<Message> history = channel.getHistory().retrievePast(100).complete();
            if (history == null) return null;

            for (Message msg : history) {
                User author = msg.getAuthor();
                if (author == null || !author.isBot()) continue;

                String content = msg.getContentRaw();
                if (content != null && content.endsWith(MARKER)) {
                    return msg.getId();
                }
            }
        } catch (Throwable t) {
            System.err.println("[GuildOnlineList] Error searching message history: " + t.getMessage());
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // JDA extraction via reflection — cached after first success
    //
    // WHY REFLECTION: Discord.java has a private `jda` field and no public
    // accessor. Since this is a decompiled JAR we cannot modify Discord.java
    // directly. Reflection is the correct workaround. We cache the result so
    // this overhead only happens once per process lifetime.
    // -------------------------------------------------------------------------

    private static JDA getJda() {
        // Return cached instance if we already found it
        if (cachedJda != null) return cachedJda;

        Discord discord = Global$.MODULE$.discord();
        if (discord == null) return null;

        try {
            for (Field field : discord.getClass().getDeclaredFields()) {
                if (!JDA.class.isAssignableFrom(field.getType())) continue;

                field.setAccessible(true);
                Object value = field.get(discord);

                if (value instanceof JDA) {
                    cachedJda = (JDA) value; // Cache it — never reflect again
                    System.out.println("[GuildOnlineList] JDA instance found and cached via reflection.");
                    return cachedJda;
                }
            }

            // If we get here, no JDA field was found — this is a structural problem
            System.err.println("[GuildOnlineList] WARNING: Could not find JDA field in Discord class. "
                + "Guild online list will not work. This may indicate a Discord class structure change.");

        } catch (Throwable t) {
            System.err.println("[GuildOnlineList] Reflection error accessing JDA: " + t.getMessage());
        }

        return null;
    }

    // -------------------------------------------------------------------------
    // Config loading
    // -------------------------------------------------------------------------

    private static void loadConfig() {
        try {
            String configFile = System.getProperty("wowchat.configFile", "wowchat.conf");
            Config config = ConfigFactory.parseFile(new File(configFile)).resolve();

            // Channel ID — try as long first, then as string
            channelId = 0L;
            try {
                channelId = config.getLong("guildOnlineListChannelId");
            } catch (ConfigException.WrongType e) {
                try {
                    channelId = Long.parseLong(config.getString("guildOnlineListChannelId").trim());
                } catch (Throwable ignored) {
                    channelId = 0L;
                }
            } catch (ConfigException.Missing e) {
                channelId = 0L;
            }

            // Update interval
            try {
                updateMinutes = config.getInt("guildOnlineListUpdateMinutes");
                if (updateMinutes < 1) updateMinutes = 1;
            } catch (ConfigException e) {
                updateMinutes = 5;
            }

            // Ignore list
            Set<String> ignoreSet = new HashSet<>();
            try {
                if (config.hasPath("guildOnlineListIgnore")) {
                    for (String name : config.getStringList("guildOnlineListIgnore")) {
                        if (name != null && !name.trim().isEmpty()) {
                            ignoreSet.add(name.trim().toLowerCase(Locale.ROOT));
                        }
                    }
                }
            } catch (Throwable ignored) {}

            ignoreLower = ignoreSet.isEmpty()
                ? Collections.emptySet()
                : Collections.unmodifiableSet(ignoreSet);

        } catch (Throwable t) {
            System.err.println("[GuildOnlineList] Failed to load config: " + t.getMessage()
                + ". Guild online list will be disabled.");
            channelId     = 0L;
            updateMinutes = 5;
            ignoreLower   = Collections.emptySet();
        }
    }

    // -------------------------------------------------------------------------
    // Thread factory — produces daemon threads so they don't block JVM shutdown
    // -------------------------------------------------------------------------

    public static final class DaemonThreadFactory implements ThreadFactory {
        private static final AtomicInteger IDX = new AtomicInteger(1);
        private final String prefix;

        public DaemonThreadFactory(String prefix) {
            this.prefix = (prefix != null && !prefix.trim().isEmpty())
                ? prefix.trim() : "wowchat";
        }

        public DaemonThreadFactory() {
            this("wowchat");
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setName(prefix + "-" + IDX.getAndIncrement());
            return t;
        }
    }
}
