/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.annotations.Incubating;
import net.dv8tion.jda.annotations.ReplaceWith;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ApplicationInfo;
import net.dv8tion.jda.api.entities.Entitlement;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.RoleConnectionMetadata;
import net.dv8tion.jda.api.entities.ScheduledEvent;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.Webhook;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.attribute.IGuildChannelContainer;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.entities.emoji.ApplicationEmoji;
import net.dv8tion.jda.api.entities.emoji.RichCustomEmoji;
import net.dv8tion.jda.api.entities.sticker.StickerPack;
import net.dv8tion.jda.api.entities.sticker.StickerSnowflake;
import net.dv8tion.jda.api.entities.sticker.StickerUnion;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.IEventManager;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.managers.ApplicationManager;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.managers.DirectAudioController;
import net.dv8tion.jda.api.managers.Presence;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import net.dv8tion.jda.api.requests.restaction.CacheRestAction;
import net.dv8tion.jda.api.requests.restaction.CommandCreateAction;
import net.dv8tion.jda.api.requests.restaction.CommandEditAction;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.requests.restaction.GuildAction;
import net.dv8tion.jda.api.requests.restaction.TestEntitlementCreateAction;
import net.dv8tion.jda.api.requests.restaction.pagination.EntitlementPaginationAction;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.api.utils.Once;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.api.utils.cache.CacheView;
import net.dv8tion.jda.api.utils.cache.SnowflakeCacheView;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import net.dv8tion.jda.internal.requests.CompletedRestAction;
import net.dv8tion.jda.internal.requests.RestActionImpl;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.EntityString;
import net.dv8tion.jda.internal.utils.Helpers;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.Unmodifiable;

public interface JDA
extends IGuildChannelContainer<Channel> {
    @Nonnull
    public Status getStatus();

    @Nonnull
    public EnumSet<GatewayIntent> getGatewayIntents();

    @Nonnull
    public EnumSet<CacheFlag> getCacheFlags();

    public boolean unloadUser(long var1);

    public long getGatewayPing();

    @Nonnull
    @CheckReturnValue
    default public RestAction<Long> getRestPing() {
        AtomicLong time = new AtomicLong();
        Route.CompiledRoute route = Route.Self.GET_SELF.compile(new String[0]);
        RestActionImpl<Long> action = new RestActionImpl<Long>(this, route, (response, request) -> System.currentTimeMillis() - time.get());
        action.setCheck(() -> {
            time.set(System.currentTimeMillis());
            return true;
        });
        return action;
    }

    @Nonnull
    default public JDA awaitStatus(@Nonnull Status status) throws InterruptedException {
        return this.awaitStatus(status, new Status[0]);
    }

    @Nonnull
    public JDA awaitStatus(@Nonnull Status var1, Status ... var2) throws InterruptedException;

    @Nonnull
    default public JDA awaitReady() throws InterruptedException {
        return this.awaitStatus(Status.CONNECTED);
    }

    @CheckReturnValue
    public boolean awaitShutdown(long var1, @Nonnull TimeUnit var3) throws InterruptedException;

    @CheckReturnValue
    default public boolean awaitShutdown(@Nonnull Duration timeout2) throws InterruptedException {
        Checks.notNull(timeout2, "Timeout");
        return this.awaitShutdown(timeout2.toMillis(), TimeUnit.MILLISECONDS);
    }

    default public boolean awaitShutdown() throws InterruptedException {
        return this.awaitShutdown(0L, TimeUnit.MILLISECONDS);
    }

    public int cancelRequests();

    @Nonnull
    public ScheduledExecutorService getRateLimitPool();

    @Nonnull
    public ScheduledExecutorService getGatewayPool();

    @Nonnull
    public ExecutorService getCallbackPool();

    @Nonnull
    public OkHttpClient getHttpClient();

    @Nonnull
    public DirectAudioController getDirectAudioController();

    public void setEventManager(@Nullable IEventManager var1);

    public void addEventListener(Object ... var1);

    public void removeEventListener(Object ... var1);

    @Nonnull
    public List<Object> getRegisteredListeners();

    @Nonnull
    @CheckReturnValue
    public <E extends GenericEvent> Once.Builder<E> listenOnce(@Nonnull Class<E> var1);

    @Nonnull
    @CheckReturnValue
    default public RestAction<List<Command>> retrieveCommands() {
        return this.retrieveCommands(false);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<Command>> retrieveCommands(boolean var1);

    @Nonnull
    @CheckReturnValue
    public RestAction<Command> retrieveCommandById(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    default public RestAction<Command> retrieveCommandById(long id) {
        return this.retrieveCommandById(Long.toUnsignedString(id));
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Command> upsertCommand(@Nonnull CommandData var1);

    @Nonnull
    @CheckReturnValue
    default public CommandCreateAction upsertCommand(@Nonnull String name, @Nonnull String description) {
        return (CommandCreateAction)this.upsertCommand(new CommandDataImpl(name, description));
    }

    @Nonnull
    @CheckReturnValue
    public CommandListUpdateAction updateCommands();

    @Nonnull
    @CheckReturnValue
    @Deprecated
    @ReplaceWith(value="editCommandById(Command.Type, id)")
    default public CommandEditAction editCommandById(@Nonnull String id) {
        return this.editCommandById(Command.Type.SLASH, id);
    }

    @Nonnull
    @CheckReturnValue
    @Deprecated
    @ReplaceWith(value="editCommandById(Command.Type, id)")
    default public CommandEditAction editCommandById(long id) {
        return this.editCommandById(Long.toUnsignedString(id));
    }

    @Nonnull
    @CheckReturnValue
    public CommandEditAction editCommandById(@Nonnull Command.Type var1, @Nonnull String var2);

    @Nonnull
    @CheckReturnValue
    default public CommandEditAction editCommandById(@Nonnull Command.Type type, long id) {
        return this.editCommandById(type, Long.toUnsignedString(id));
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> deleteCommandById(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    default public RestAction<Void> deleteCommandById(long commandId) {
        return this.deleteCommandById(Long.toUnsignedString(commandId));
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<List<RoleConnectionMetadata>> retrieveRoleConnectionMetadata();

    @Nonnull
    @CheckReturnValue
    public RestAction<List<RoleConnectionMetadata>> updateRoleConnectionMetadata(@Nonnull Collection<? extends RoleConnectionMetadata> var1);

    @Nonnull
    @CheckReturnValue
    public GuildAction createGuild(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> createGuildFromTemplate(@Nonnull String var1, @Nonnull String var2, @Nullable Icon var3);

    @Nonnull
    public CacheView<AudioManager> getAudioManagerCache();

    @Nonnull
    default public @Unmodifiable List<AudioManager> getAudioManagers() {
        return this.getAudioManagerCache().asList();
    }

    @Nonnull
    public SnowflakeCacheView<User> getUserCache();

    @Nonnull
    default public @Unmodifiable List<User> getUsers() {
        return this.getUserCache().asList();
    }

    @Nullable
    default public User getUserById(@Nonnull String id) {
        return this.getUserCache().getElementById(id);
    }

    @Nullable
    default public User getUserById(long id) {
        return this.getUserCache().getElementById(id);
    }

    @Nullable
    default public User getUserByTag(@Nonnull String tag) {
        Checks.notNull(tag, "Tag");
        Matcher matcher = User.USER_TAG.matcher(tag);
        Checks.check(matcher.matches(), "Invalid tag format!");
        String username = matcher.group(1);
        String discriminator = matcher.group(2);
        return this.getUserByTag(username, discriminator);
    }

    @Nullable
    default public User getUserByTag(@Nonnull String username, @Nullable String discriminator) {
        Checks.inRange(username, 2, 32, "Username");
        Checks.check(discriminator == null || discriminator.length() == 4 && Helpers.isNumeric(discriminator), "Invalid format for discriminator! Provided: %s", (Object)discriminator);
        String actualDiscriminator = discriminator == null ? "0000" : discriminator;
        return this.getUserCache().applyStream(stream -> stream.filter(it -> it.getDiscriminator().equals(actualDiscriminator)).filter(it -> it.getName().equals(username)).findFirst().orElse(null));
    }

    @Nonnull
    @Incubating
    default public @Unmodifiable List<User> getUsersByName(@Nonnull String name, boolean ignoreCase) {
        return this.getUserCache().getElementsByName(name, ignoreCase);
    }

    @Nonnull
    public @Unmodifiable List<Guild> getMutualGuilds(User ... var1);

    @Nonnull
    public @Unmodifiable List<Guild> getMutualGuilds(@Nonnull Collection<User> var1);

    @Nonnull
    @CheckReturnValue
    default public CacheRestAction<User> retrieveUserById(@Nonnull String id) {
        return this.retrieveUserById(MiscUtil.parseSnowflake(id));
    }

    @Nonnull
    @CheckReturnValue
    public CacheRestAction<User> retrieveUserById(long var1);

    @Nonnull
    public SnowflakeCacheView<Guild> getGuildCache();

    @Nonnull
    default public @Unmodifiable List<Guild> getGuilds() {
        return this.getGuildCache().asList();
    }

    @Nullable
    default public Guild getGuildById(@Nonnull String id) {
        return this.getGuildCache().getElementById(id);
    }

    @Nullable
    default public Guild getGuildById(long id) {
        return this.getGuildCache().getElementById(id);
    }

    @Nonnull
    default public @Unmodifiable List<Guild> getGuildsByName(@Nonnull String name, boolean ignoreCase) {
        return this.getGuildCache().getElementsByName(name, ignoreCase);
    }

    @Nonnull
    public Set<String> getUnavailableGuilds();

    public boolean isUnavailable(long var1);

    @Nonnull
    public SnowflakeCacheView<Role> getRoleCache();

    @Nonnull
    default public @Unmodifiable List<Role> getRoles() {
        return this.getRoleCache().asList();
    }

    @Nullable
    default public Role getRoleById(@Nonnull String id) {
        return this.getRoleCache().getElementById(id);
    }

    @Nullable
    default public Role getRoleById(long id) {
        return this.getRoleCache().getElementById(id);
    }

    @Nonnull
    default public @Unmodifiable List<Role> getRolesByName(@Nonnull String name, boolean ignoreCase) {
        return this.getRoleCache().getElementsByName(name, ignoreCase);
    }

    @Nonnull
    public SnowflakeCacheView<ScheduledEvent> getScheduledEventCache();

    @Nonnull
    default public @Unmodifiable List<ScheduledEvent> getScheduledEvents() {
        return this.getScheduledEventCache().asList();
    }

    @Nullable
    default public ScheduledEvent getScheduledEventById(@Nonnull String id) {
        return this.getScheduledEventCache().getElementById(id);
    }

    @Nullable
    default public ScheduledEvent getScheduledEventById(long id) {
        return this.getScheduledEventCache().getElementById(id);
    }

    @Nonnull
    default public @Unmodifiable List<ScheduledEvent> getScheduledEventsByName(@Nonnull String name, boolean ignoreCase) {
        return this.getScheduledEventCache().getElementsByName(name, ignoreCase);
    }

    @Nonnull
    public SnowflakeCacheView<PrivateChannel> getPrivateChannelCache();

    @Nonnull
    default public @Unmodifiable List<PrivateChannel> getPrivateChannels() {
        return this.getPrivateChannelCache().asList();
    }

    @Nullable
    default public PrivateChannel getPrivateChannelById(@Nonnull String id) {
        return this.getPrivateChannelCache().getElementById(id);
    }

    @Nullable
    default public PrivateChannel getPrivateChannelById(long id) {
        return this.getPrivateChannelCache().getElementById(id);
    }

    @Nonnull
    @CheckReturnValue
    public CacheRestAction<PrivateChannel> openPrivateChannelById(long var1);

    @Nonnull
    @CheckReturnValue
    default public CacheRestAction<PrivateChannel> openPrivateChannelById(@Nonnull String userId) {
        return this.openPrivateChannelById(MiscUtil.parseSnowflake(userId));
    }

    @Nonnull
    public SnowflakeCacheView<RichCustomEmoji> getEmojiCache();

    @Nonnull
    default public @Unmodifiable List<RichCustomEmoji> getEmojis() {
        return this.getEmojiCache().asList();
    }

    @Nullable
    default public RichCustomEmoji getEmojiById(@Nonnull String id) {
        return this.getEmojiCache().getElementById(id);
    }

    @Nullable
    default public RichCustomEmoji getEmojiById(long id) {
        return this.getEmojiCache().getElementById(id);
    }

    @Nonnull
    default public @Unmodifiable List<RichCustomEmoji> getEmojisByName(@Nonnull String name, boolean ignoreCase) {
        return this.getEmojiCache().getElementsByName(name, ignoreCase);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<ApplicationEmoji> createApplicationEmoji(@Nonnull String var1, @Nonnull Icon var2);

    @Nonnull
    @CheckReturnValue
    public RestAction<List<ApplicationEmoji>> retrieveApplicationEmojis();

    @Nonnull
    @CheckReturnValue
    default public RestAction<ApplicationEmoji> retrieveApplicationEmojiById(long emojiId) {
        return this.retrieveApplicationEmojiById(Long.toUnsignedString(emojiId));
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<ApplicationEmoji> retrieveApplicationEmojiById(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    public RestAction<StickerUnion> retrieveSticker(@Nonnull StickerSnowflake var1);

    @Nonnull
    @CheckReturnValue
    public RestAction<@Unmodifiable List<StickerPack>> retrieveNitroStickerPacks();

    @Nonnull
    public IEventManager getEventManager();

    @Nonnull
    public SelfUser getSelfUser();

    @Nonnull
    public Presence getPresence();

    @Nonnull
    public ShardInfo getShardInfo();

    @Nonnull
    public String getToken();

    public long getResponseTotal();

    public int getMaxReconnectDelay();

    public void setAutoReconnect(boolean var1);

    public void setRequestTimeoutRetry(boolean var1);

    public boolean isAutoReconnect();

    public boolean isBulkDeleteSplittingEnabled();

    public void shutdown();

    public void shutdownNow();

    @Nonnull
    @CheckReturnValue
    public RestAction<ApplicationInfo> retrieveApplicationInfo();

    @Nonnull
    @CheckReturnValue
    public EntitlementPaginationAction retrieveEntitlements();

    @Nonnull
    @CheckReturnValue
    default public RestAction<Entitlement> retrieveEntitlementById(@Nonnull String entitlementId) {
        return this.retrieveEntitlementById(MiscUtil.parseSnowflake(entitlementId));
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Entitlement> retrieveEntitlementById(long var1);

    @Nonnull
    @CheckReturnValue
    default public TestEntitlementCreateAction createTestEntitlement(@Nonnull String skuId, @Nonnull String ownerId, @Nonnull TestEntitlementCreateAction.OwnerType ownerType) {
        return this.createTestEntitlement(MiscUtil.parseSnowflake(skuId), MiscUtil.parseSnowflake(ownerId), ownerType);
    }

    @Nonnull
    @CheckReturnValue
    public TestEntitlementCreateAction createTestEntitlement(long var1, long var3, @Nonnull TestEntitlementCreateAction.OwnerType var5);

    @Nonnull
    @CheckReturnValue
    default public RestAction<Void> deleteTestEntitlement(@Nonnull String entitlementId) {
        return this.deleteTestEntitlement(MiscUtil.parseSnowflake(entitlementId));
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> deleteTestEntitlement(long var1);

    @Nonnull
    default public JDA setRequiredScopes(String ... scopes) {
        Checks.noneNull(scopes, "Scopes");
        return this.setRequiredScopes(Arrays.asList(scopes));
    }

    @Nonnull
    public JDA setRequiredScopes(@Nonnull Collection<String> var1);

    @Nonnull
    public String getInviteUrl(Permission ... var1);

    @Nonnull
    public String getInviteUrl(@Nullable Collection<Permission> var1);

    @Nullable
    public ShardManager getShardManager();

    @Nonnull
    @CheckReturnValue
    public RestAction<Webhook> retrieveWebhookById(@Nonnull String var1);

    @Nonnull
    @CheckReturnValue
    default public RestAction<Webhook> retrieveWebhookById(long webhookId) {
        return this.retrieveWebhookById(Long.toUnsignedString(webhookId));
    }

    @Nonnull
    @CheckReturnValue
    default public AuditableRestAction<Integer> installAuxiliaryPort() {
        int port = ThreadLocalRandom.current().nextInt();
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            }
            catch (IOException | URISyntaxException e) {
                throw new IllegalStateException("No port available");
            }
        } else {
            throw new IllegalStateException("No port available");
        }
        return new CompletedRestAction<Integer>(this, port);
    }

    @Nonnull
    @CheckReturnValue
    public ApplicationManager getApplicationManager();

    public static enum Status {
        INITIALIZING(true),
        INITIALIZED(true),
        LOGGING_IN(true),
        CONNECTING_TO_WEBSOCKET(true),
        IDENTIFYING_SESSION(true),
        AWAITING_LOGIN_CONFIRMATION(true),
        LOADING_SUBSYSTEMS(true),
        CONNECTED(true),
        DISCONNECTED,
        RECONNECT_QUEUED,
        WAITING_TO_RECONNECT,
        ATTEMPTING_TO_RECONNECT,
        SHUTTING_DOWN,
        SHUTDOWN,
        FAILED_TO_LOGIN;

        private final boolean isInit;

        private Status(boolean isInit) {
            this.isInit = isInit;
        }

        private Status() {
            this.isInit = false;
        }

        public boolean isInit() {
            return this.isInit;
        }
    }

    public static class ShardInfo {
        public static final ShardInfo SINGLE = new ShardInfo(0, 1);
        int shardId;
        int shardTotal;

        public ShardInfo(int shardId, int shardTotal) {
            this.shardId = shardId;
            this.shardTotal = shardTotal;
        }

        public int getShardId() {
            return this.shardId;
        }

        public int getShardTotal() {
            return this.shardTotal;
        }

        @Nonnull
        public String getShardString() {
            return "[" + this.shardId + " / " + this.shardTotal + "]";
        }

        @Nonnull
        public String toString() {
            return new EntityString(this).addMetadata("currentShard", this.getShardString()).addMetadata("totalShards", this.getShardTotal()).toString();
        }

        public boolean equals(Object o) {
            if (!(o instanceof ShardInfo)) {
                return false;
            }
            ShardInfo oInfo = (ShardInfo)o;
            return this.shardId == oInfo.getShardId() && this.shardTotal == oInfo.getShardTotal();
        }
    }
}

