/*
 * Decompiled with CFR 0.152.
 */
package wowchat.discord;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import scala.Option;
import scala.collection.Iterator;
import scala.collection.mutable.Map;
import wowchat.common.Global$;
import wowchat.discord.Discord;
import wowchat.game.GameCommandHandler;
import wowchat.game.GamePacketHandler;
import wowchat.game.GuildMember;

public final class GuildOnlineListPublisher {
    private static final String MARKER = "\u200b\u200b\u200b\u200b\u200b\u200b\u200b\u200b\u200b\u200b";
    private static volatile boolean started = false;
    private static volatile long channelId = 0L;
    private static volatile int updateMinutes = 5;
    private static volatile String messageId = null;
    private static volatile String lastPayload = null;
    private static volatile Set<String> ignoreLower = Collections.emptySet();
    private static ScheduledExecutorService scheduler;

    private GuildOnlineListPublisher() {
    }

    public static synchronized void init() {
        if (started) {
            return;
        }
        started = true;
        GuildOnlineListPublisher.loadConfig();
        if (channelId <= 0L) {
            return;
        }
        scheduler = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory("wowchat-online-list"));
        long l = 30L;
        long l2 = (long)Math.max(1, updateMinutes) * 60L;
        scheduler.scheduleAtFixedRate(new Runnable(){

            @Override
            public void run() {
                try {
                    GuildOnlineListPublisher.tick();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }, l, l2, TimeUnit.SECONDS);
    }

    private static void loadConfig() {
        try {
            String string = System.getProperty("wowchat.configFile", "wowchat.conf");
            Config config = ConfigFactory.parseFile(new File(string)).resolve();
            try {
                channelId = config.getLong("guildOnlineListChannelId");
            }
            catch (ConfigException.WrongType wrongType) {
                try {
                    channelId = Long.parseLong(config.getString("guildOnlineListChannelId").trim());
                }
                catch (Throwable throwable) {
                    channelId = 0L;
                }
            }
            catch (ConfigException.Missing missing) {
                channelId = 0L;
            }
            try {
                updateMinutes = config.getInt("guildOnlineListUpdateMinutes");
            }
            catch (ConfigException configException) {
                updateMinutes = 5;
            }
            if (updateMinutes < 1) {
                updateMinutes = 1;
            }
            HashSet<String> hashSet = new HashSet<String>();
            try {
                List<String> list;
                if (config.hasPath("guildOnlineListIgnore") && (list = config.getStringList("guildOnlineListIgnore")) != null) {
                    for (String string2 : list) {
                        String string3;
                        if (string2 == null || (string3 = string2.trim()).isEmpty()) continue;
                        hashSet.add(string3.toLowerCase(Locale.ROOT));
                    }
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            ignoreLower = hashSet.isEmpty() ? Collections.emptySet() : Collections.unmodifiableSet(hashSet);
        }
        catch (Throwable throwable) {
            channelId = 0L;
            updateMinutes = 5;
            ignoreLower = Collections.emptySet();
        }
    }

    private static void tick() {
        String string;
        Discord discord = Global$.MODULE$.discord();
        JDA jDA = GuildOnlineListPublisher.extractJda(discord);
        if (jDA == null) {
            return;
        }
        TextChannel textChannel = jDA.getTextChannelById(channelId);
        if (textChannel == null) {
            return;
        }
        List<String> list = GuildOnlineListPublisher.getOnlineNames();
        list.sort(String.CASE_INSENSITIVE_ORDER);
        String string2 = string = list.isEmpty() ? "No Guildies Online" : String.join((CharSequence)"\n", list);
        if (messageId == null) {
            messageId = GuildOnlineListPublisher.findExistingMessageId(textChannel);
        }
        if (Objects.equals(string, lastPayload) && messageId != null) {
            boolean bl = true;
            try {
                textChannel.retrieveMessageById(messageId).complete();
            }
            catch (Throwable throwable) {
                bl = false;
            }
            if (bl) {
                return;
            }
            messageId = null;
        }
        String string3 = string + MARKER;
        if (messageId == null) {
            Message message = (Message)textChannel.sendMessage(string3).complete();
            messageId = message.getId();
            lastPayload = string;
            return;
        }
        try {
            textChannel.editMessageById(messageId, (CharSequence)string3).complete();
            lastPayload = string;
        }
        catch (Throwable throwable) {
            messageId = null;
            try {
                Message message = (Message)textChannel.sendMessage(string3).complete();
                messageId = message.getId();
                lastPayload = string;
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
        }
    }

    private static List<String> getOnlineNames() {
        try {
            Option<GameCommandHandler> option = Global$.MODULE$.game();
            if (option == null || option.isEmpty()) {
                return Collections.emptyList();
            }
            GameCommandHandler gameCommandHandler = option.get();
            if (!(gameCommandHandler instanceof GamePacketHandler)) {
                return Collections.emptyList();
            }
            GamePacketHandler gamePacketHandler = (GamePacketHandler)gameCommandHandler;
            Map<Object, GuildMember> map = gamePacketHandler.guildRoster();
            if (map == null) {
                return Collections.emptyList();
            }
            ArrayList<String> arrayList = new ArrayList<String>();
            Iterator iterator2 = map.valuesIterator();
            while (iterator2.hasNext()) {
                String string;
                String string2;
                String string3;
                GuildMember guildMember;
                Object v = iterator2.next();
                if (!(v instanceof GuildMember) || (guildMember = (GuildMember)v) == null || !guildMember.isOnline() || (string3 = guildMember.name()) == null || (string2 = string3.trim()).isEmpty() || ignoreLower != null && !ignoreLower.isEmpty() && ignoreLower.contains(string = string2.toLowerCase(Locale.ROOT))) continue;
                arrayList.add(string2);
            }
            return arrayList;
        }
        catch (Throwable throwable) {
            return Collections.emptyList();
        }
    }

    private static String findExistingMessageId(TextChannel textChannel) {
        try {
            List<Message> list = textChannel.getHistory().retrievePast(100).complete();
            if (list == null) {
                return null;
            }
            for (Message message : list) {
                String string;
                User user;
                if (message == null || (user = message.getAuthor()) == null || !user.isBot() || (string = message.getContentRaw()) == null || !string.endsWith(MARKER)) continue;
                return message.getId();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return null;
    }

    private static JDA extractJda(Discord discord) {
        try {
            Field[] fieldArray;
            if (discord == null) {
                return null;
            }
            for (Field field2 : fieldArray = discord.getClass().getDeclaredFields()) {
                if (!JDA.class.isAssignableFrom(field2.getType())) continue;
                field2.setAccessible(true);
                Object object = field2.get(discord);
                if (!(object instanceof JDA)) continue;
                return (JDA)object;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return null;
    }

    public static final class DaemonThreadFactory
    implements ThreadFactory {
        private static final AtomicInteger IDX = new AtomicInteger(1);
        private final String prefix;

        public DaemonThreadFactory(String string) {
            this.prefix = string == null || string.trim().isEmpty() ? "wowchat" : string.trim();
        }

        public DaemonThreadFactory() {
            this("wowchat");
        }

        @Override
        public Thread newThread(Runnable runnable2) {
            Thread thread2 = new Thread(runnable2);
            thread2.setDaemon(true);
            thread2.setName(this.prefix + "-" + IDX.getAndIncrement());
            return thread2;
        }
    }
}

