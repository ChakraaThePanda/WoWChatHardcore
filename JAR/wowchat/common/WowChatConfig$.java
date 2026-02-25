/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigObject;
import io.netty.util.AttributeKey;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import scala.Enumeration;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Some;
import scala.Tuple2;
import scala.Tuple5;
import scala.collection.JavaConverters$;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer$;
import scala.reflect.api.JavaUniverse;
import scala.reflect.api.Mirror;
import scala.reflect.api.TypeCreator;
import scala.reflect.api.TypeTags;
import scala.reflect.api.Types;
import scala.reflect.api.Universe;
import scala.reflect.runtime.package$;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichChar$;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction0$mcZ$sp;
import wowchat.common.ChannelConfig;
import wowchat.common.ChatDirection$;
import wowchat.common.DiscordChannelConfig;
import wowchat.common.DiscordConfig;
import wowchat.common.FiltersConfig;
import wowchat.common.Global$;
import wowchat.common.GuildConfig;
import wowchat.common.GuildNotificationConfig;
import wowchat.common.Platform$;
import wowchat.common.RealmListConfig;
import wowchat.common.Wow;
import wowchat.common.WowChannelConfig;
import wowchat.common.WowChatConfig;
import wowchat.common.WowChatConfig$;
import wowchat.common.WowExpansion$;
import wowchat.game.GameHeaderCrypt;
import wowchat.game.GamePackets;
import wowchat.game.GamePackets$AuthResponseCodes$;
import wowchat.game.GamePackets$ChatChannelIds$;
import wowchat.game.GamePackets$ChatEvents$;
import wowchat.game.GamePackets$ChatNotify$;
import wowchat.game.GamePackets$Classes$;
import wowchat.game.GamePackets$Genders$;
import wowchat.game.GamePackets$GuildEvents$;
import wowchat.game.GamePackets$Races$;
import wowchat.game.GamePackets$ServerMessageType$;

public final class WowChatConfig$
implements GamePackets,
scala.Serializable {
    public static WowChatConfig$ MODULE$;
    private String getVersion;
    private Enumeration.Value getExpansion;
    private int buildFromVersion;
    private int getRealmBuild;
    private int getGameBuild;
    private String version;
    private Enumeration.Value expansion;
    private final AttributeKey<GameHeaderCrypt> CRYPT;
    private final int CMSG_CHAR_ENUM;
    private final int SMSG_CHAR_ENUM;
    private final int CMSG_PLAYER_LOGIN;
    private final int CMSG_LOGOUT_REQUEST;
    private final int CMSG_NAME_QUERY;
    private final int SMSG_NAME_QUERY;
    private final int CMSG_GUILD_QUERY;
    private final int SMSG_GUILD_QUERY;
    private final int CMSG_WHO;
    private final int SMSG_WHO;
    private final int CMSG_GUILD_ROSTER;
    private final int SMSG_GUILD_ROSTER;
    private final int SMSG_GUILD_EVENT;
    private final int CMSG_MESSAGECHAT;
    private final int SMSG_MESSAGECHAT;
    private final int CMSG_JOIN_CHANNEL;
    private final int SMSG_CHANNEL_NOTIFY;
    private final int SMSG_NOTIFICATION;
    private final int CMSG_PING;
    private final int SMSG_AUTH_CHALLENGE;
    private final int CMSG_AUTH_CHALLENGE;
    private final int SMSG_AUTH_RESPONSE;
    private final int SMSG_LOGIN_VERIFY_WORLD;
    private final int SMSG_SERVER_MESSAGE;
    private final int SMSG_WARDEN_DATA;
    private final int CMSG_WARDEN_DATA;
    private final int SMSG_INVALIDATE_PLAYER;
    private final int SMSG_TIME_SYNC_REQ;
    private final int CMSG_TIME_SYNC_RESP;
    private volatile GamePackets$ChatEvents$ ChatEvents$module;
    private volatile GamePackets$GuildEvents$ GuildEvents$module;
    private volatile GamePackets$Races$ Races$module;
    private volatile GamePackets$Classes$ Classes$module;
    private volatile GamePackets$Genders$ Genders$module;
    private volatile GamePackets$AuthResponseCodes$ AuthResponseCodes$module;
    private volatile GamePackets$ChatNotify$ ChatNotify$module;
    private volatile GamePackets$ServerMessageType$ ServerMessageType$module;
    private volatile GamePackets$ChatChannelIds$ ChatChannelIds$module;
    private volatile byte bitmap$0;

    static {
        new WowChatConfig$();
    }

    @Override
    public AttributeKey<GameHeaderCrypt> CRYPT() {
        return this.CRYPT;
    }

    @Override
    public int CMSG_CHAR_ENUM() {
        return this.CMSG_CHAR_ENUM;
    }

    @Override
    public int SMSG_CHAR_ENUM() {
        return this.SMSG_CHAR_ENUM;
    }

    @Override
    public int CMSG_PLAYER_LOGIN() {
        return this.CMSG_PLAYER_LOGIN;
    }

    @Override
    public int CMSG_LOGOUT_REQUEST() {
        return this.CMSG_LOGOUT_REQUEST;
    }

    @Override
    public int CMSG_NAME_QUERY() {
        return this.CMSG_NAME_QUERY;
    }

    @Override
    public int SMSG_NAME_QUERY() {
        return this.SMSG_NAME_QUERY;
    }

    @Override
    public int CMSG_GUILD_QUERY() {
        return this.CMSG_GUILD_QUERY;
    }

    @Override
    public int SMSG_GUILD_QUERY() {
        return this.SMSG_GUILD_QUERY;
    }

    @Override
    public int CMSG_WHO() {
        return this.CMSG_WHO;
    }

    @Override
    public int SMSG_WHO() {
        return this.SMSG_WHO;
    }

    @Override
    public int CMSG_GUILD_ROSTER() {
        return this.CMSG_GUILD_ROSTER;
    }

    @Override
    public int SMSG_GUILD_ROSTER() {
        return this.SMSG_GUILD_ROSTER;
    }

    @Override
    public int SMSG_GUILD_EVENT() {
        return this.SMSG_GUILD_EVENT;
    }

    @Override
    public int CMSG_MESSAGECHAT() {
        return this.CMSG_MESSAGECHAT;
    }

    @Override
    public int SMSG_MESSAGECHAT() {
        return this.SMSG_MESSAGECHAT;
    }

    @Override
    public int CMSG_JOIN_CHANNEL() {
        return this.CMSG_JOIN_CHANNEL;
    }

    @Override
    public int SMSG_CHANNEL_NOTIFY() {
        return this.SMSG_CHANNEL_NOTIFY;
    }

    @Override
    public int SMSG_NOTIFICATION() {
        return this.SMSG_NOTIFICATION;
    }

    @Override
    public int CMSG_PING() {
        return this.CMSG_PING;
    }

    @Override
    public int SMSG_AUTH_CHALLENGE() {
        return this.SMSG_AUTH_CHALLENGE;
    }

    @Override
    public int CMSG_AUTH_CHALLENGE() {
        return this.CMSG_AUTH_CHALLENGE;
    }

    @Override
    public int SMSG_AUTH_RESPONSE() {
        return this.SMSG_AUTH_RESPONSE;
    }

    @Override
    public int SMSG_LOGIN_VERIFY_WORLD() {
        return this.SMSG_LOGIN_VERIFY_WORLD;
    }

    @Override
    public int SMSG_SERVER_MESSAGE() {
        return this.SMSG_SERVER_MESSAGE;
    }

    @Override
    public int SMSG_WARDEN_DATA() {
        return this.SMSG_WARDEN_DATA;
    }

    @Override
    public int CMSG_WARDEN_DATA() {
        return this.CMSG_WARDEN_DATA;
    }

    @Override
    public int SMSG_INVALIDATE_PLAYER() {
        return this.SMSG_INVALIDATE_PLAYER;
    }

    @Override
    public int SMSG_TIME_SYNC_REQ() {
        return this.SMSG_TIME_SYNC_REQ;
    }

    @Override
    public int CMSG_TIME_SYNC_RESP() {
        return this.CMSG_TIME_SYNC_RESP;
    }

    @Override
    public GamePackets$ChatEvents$ ChatEvents() {
        if (this.ChatEvents$module == null) {
            this.ChatEvents$lzycompute$1();
        }
        return this.ChatEvents$module;
    }

    @Override
    public GamePackets$GuildEvents$ GuildEvents() {
        if (this.GuildEvents$module == null) {
            this.GuildEvents$lzycompute$1();
        }
        return this.GuildEvents$module;
    }

    @Override
    public GamePackets$Races$ Races() {
        if (this.Races$module == null) {
            this.Races$lzycompute$1();
        }
        return this.Races$module;
    }

    @Override
    public GamePackets$Classes$ Classes() {
        if (this.Classes$module == null) {
            this.Classes$lzycompute$1();
        }
        return this.Classes$module;
    }

    @Override
    public GamePackets$Genders$ Genders() {
        if (this.Genders$module == null) {
            this.Genders$lzycompute$1();
        }
        return this.Genders$module;
    }

    @Override
    public GamePackets$AuthResponseCodes$ AuthResponseCodes() {
        if (this.AuthResponseCodes$module == null) {
            this.AuthResponseCodes$lzycompute$1();
        }
        return this.AuthResponseCodes$module;
    }

    @Override
    public GamePackets$ChatNotify$ ChatNotify() {
        if (this.ChatNotify$module == null) {
            this.ChatNotify$lzycompute$1();
        }
        return this.ChatNotify$module;
    }

    @Override
    public GamePackets$ServerMessageType$ ServerMessageType() {
        if (this.ServerMessageType$module == null) {
            this.ServerMessageType$lzycompute$1();
        }
        return this.ServerMessageType$module;
    }

    @Override
    public GamePackets$ChatChannelIds$ ChatChannelIds() {
        if (this.ChatChannelIds$module == null) {
            this.ChatChannelIds$lzycompute$1();
        }
        return this.ChatChannelIds$module;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CRYPT_$eq(AttributeKey<GameHeaderCrypt> x$1) {
        this.CRYPT = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_CHAR_ENUM_$eq(int x$1) {
        this.CMSG_CHAR_ENUM = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_CHAR_ENUM_$eq(int x$1) {
        this.SMSG_CHAR_ENUM = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_PLAYER_LOGIN_$eq(int x$1) {
        this.CMSG_PLAYER_LOGIN = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_LOGOUT_REQUEST_$eq(int x$1) {
        this.CMSG_LOGOUT_REQUEST = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_NAME_QUERY_$eq(int x$1) {
        this.CMSG_NAME_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_NAME_QUERY_$eq(int x$1) {
        this.SMSG_NAME_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_GUILD_QUERY_$eq(int x$1) {
        this.CMSG_GUILD_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_QUERY_$eq(int x$1) {
        this.SMSG_GUILD_QUERY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_WHO_$eq(int x$1) {
        this.CMSG_WHO = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_WHO_$eq(int x$1) {
        this.SMSG_WHO = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_GUILD_ROSTER_$eq(int x$1) {
        this.CMSG_GUILD_ROSTER = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_ROSTER_$eq(int x$1) {
        this.SMSG_GUILD_ROSTER = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_EVENT_$eq(int x$1) {
        this.SMSG_GUILD_EVENT = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_MESSAGECHAT_$eq(int x$1) {
        this.CMSG_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_MESSAGECHAT_$eq(int x$1) {
        this.SMSG_MESSAGECHAT = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_JOIN_CHANNEL_$eq(int x$1) {
        this.CMSG_JOIN_CHANNEL = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_CHANNEL_NOTIFY_$eq(int x$1) {
        this.SMSG_CHANNEL_NOTIFY = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_NOTIFICATION_$eq(int x$1) {
        this.SMSG_NOTIFICATION = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_PING_$eq(int x$1) {
        this.CMSG_PING = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_AUTH_CHALLENGE_$eq(int x$1) {
        this.SMSG_AUTH_CHALLENGE = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_AUTH_CHALLENGE_$eq(int x$1) {
        this.CMSG_AUTH_CHALLENGE = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_AUTH_RESPONSE_$eq(int x$1) {
        this.SMSG_AUTH_RESPONSE = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_LOGIN_VERIFY_WORLD_$eq(int x$1) {
        this.SMSG_LOGIN_VERIFY_WORLD = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_SERVER_MESSAGE_$eq(int x$1) {
        this.SMSG_SERVER_MESSAGE = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_WARDEN_DATA_$eq(int x$1) {
        this.SMSG_WARDEN_DATA = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_WARDEN_DATA_$eq(int x$1) {
        this.CMSG_WARDEN_DATA = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_INVALIDATE_PLAYER_$eq(int x$1) {
        this.SMSG_INVALIDATE_PLAYER = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$SMSG_TIME_SYNC_REQ_$eq(int x$1) {
        this.SMSG_TIME_SYNC_REQ = x$1;
    }

    @Override
    public void wowchat$game$GamePackets$_setter_$CMSG_TIME_SYNC_RESP_$eq(int x$1) {
        this.CMSG_TIME_SYNC_RESP = x$1;
    }

    private String version() {
        return this.version;
    }

    private void version_$eq(String x$1) {
        this.version = x$1;
    }

    private Enumeration.Value expansion() {
        return this.expansion;
    }

    private void expansion_$eq(Enumeration.Value x$1) {
        this.expansion = x$1;
    }

    public WowChatConfig apply(String confFile) {
        File file = new File(confFile);
        Config config = (file.exists() ? ConfigFactory.parseFile(file) : ConfigFactory.load(confFile)).resolve();
        Config discordConf = config.getConfig("discord");
        Config wowConf = config.getConfig("wow");
        Option<Config> guildConf = this.getConfigOpt(config, "guild");
        Config channelsConf = config.getConfig("chat");
        Option<Config> filtersConf = this.getConfigOpt(config, "filters");
        this.version_$eq((String)this.getOpt(wowConf, "version", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Nothing()).getOrElse((Function0<String> & Serializable & scala.Serializable)() -> "1.12.1"));
        this.expansion_$eq(WowExpansion$.MODULE$.valueOf(this.version()));
        JavaUniverse $u = package$.MODULE$.universe();
        JavaUniverse.JavaMirror $m = package$.MODULE$.universe().runtimeMirror(this.getClass().getClassLoader());
        JavaUniverse $u2 = package$.MODULE$.universe();
        JavaUniverse.JavaMirror $m2 = package$.MODULE$.universe().runtimeMirror(this.getClass().getClassLoader());
        JavaUniverse $u3 = package$.MODULE$.universe();
        JavaUniverse.JavaMirror $m3 = package$.MODULE$.universe().runtimeMirror(this.getClass().getClassLoader());
        JavaUniverse $u4 = package$.MODULE$.universe();
        JavaUniverse.JavaMirror $m4 = package$.MODULE$.universe().runtimeMirror(this.getClass().getClassLoader());
        JavaUniverse $u5 = package$.MODULE$.universe();
        JavaUniverse.JavaMirror $m5 = package$.MODULE$.universe().runtimeMirror(this.getClass().getClassLoader());
        public final class Wowchat_common_WowChatConfig$$typecreator1$1
        extends TypeCreator {
            public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                U $u = $m$untyped.universe();
                Mirror<U> $m = $m$untyped;
                return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().ThisType($m.staticPackage("java.util").asModule().moduleClass()), $m.staticClass("java.util.List"), new $colon$colon<Nothing$>((Nothing$)((Object)$u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$)), Nil$.MODULE$));
            }

            public Wowchat_common_WowChatConfig$$typecreator1$1() {
            }
        }
        public final class Wowchat_common_WowChatConfig$$typecreator2$1
        extends TypeCreator {
            public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                U $u = $m$untyped.universe();
                Mirror<U> $m = $m$untyped;
                return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().ThisType($m.staticPackage("java.util").asModule().moduleClass()), $m.staticClass("java.util.List"), new $colon$colon<Nothing$>((Nothing$)((Object)$u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$)), Nil$.MODULE$));
            }

            public Wowchat_common_WowChatConfig$$typecreator2$1() {
            }
        }
        public final class Wowchat_common_WowChatConfig$$typecreator3$1
        extends TypeCreator {
            public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                U $u = $m$untyped.universe();
                Mirror<U> $m = $m$untyped;
                return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$);
            }

            public Wowchat_common_WowChatConfig$$typecreator3$1() {
            }
        }
        public final class Wowchat_common_WowChatConfig$$typecreator4$1
        extends TypeCreator {
            public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                U $u = $m$untyped.universe();
                Mirror<U> $m = $m$untyped;
                return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$);
            }

            public Wowchat_common_WowChatConfig$$typecreator4$1() {
            }
        }
        public final class Wowchat_common_WowChatConfig$$typecreator5$1
        extends TypeCreator {
            public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                U $u = $m$untyped.universe();
                Mirror<U> $m = $m$untyped;
                return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$);
            }

            public Wowchat_common_WowChatConfig$$typecreator5$1() {
            }
        }
        return new WowChatConfig(new DiscordConfig(discordConf.getString("token"), BoxesRunTime.unboxToBoolean(this.getOpt(discordConf, "enable_dot_commands", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Boolean()).getOrElse((JFunction0$mcZ$sp & scala.Serializable)() -> true)), ((TraversableOnce)((TraversableLike)JavaConverters$.MODULE$.asScalaBufferConverter((List)this.getOpt(discordConf, "dot_commands_whitelist", ((TypeTags)((Object)$u)).TypeTag().apply((Mirror)((Object)$m), new Wowchat_common_WowChatConfig$$typecreator1$1())).getOrElse((Function0<ArrayList> & Serializable & scala.Serializable)() -> new ArrayList())).asScala()).map((Function1<String, String> & Serializable & scala.Serializable)x$1 -> x$1.toLowerCase(), Buffer$.MODULE$.canBuildFrom())).toSet(), ((TraversableOnce)((TraversableLike)JavaConverters$.MODULE$.asScalaBufferConverter((List)this.getOpt(discordConf, "enable_commands_channels", ((TypeTags)((Object)$u2)).TypeTag().apply((Mirror)((Object)$m2), new Wowchat_common_WowChatConfig$$typecreator2$1())).getOrElse((Function0<ArrayList> & Serializable & scala.Serializable)() -> new ArrayList())).asScala()).map((Function1<String, String> & Serializable & scala.Serializable)x$2 -> x$2.toLowerCase(), Buffer$.MODULE$.canBuildFrom())).toSet(), BoxesRunTime.unboxToBoolean(this.getOpt(discordConf, "enable_tag_failed_notifications", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Boolean()).getOrElse((JFunction0$mcZ$sp & scala.Serializable)() -> true)), this.getOpt(discordConf, "item_database", ((TypeTags)((Object)$u3)).TypeTag().apply((Mirror)((Object)$m3), new Wowchat_common_WowChatConfig$$typecreator3$1()))), new Wow((String)this.getOpt(wowConf, "locale", ((TypeTags)((Object)$u4)).TypeTag().apply((Mirror)((Object)$m4), new Wowchat_common_WowChatConfig$$typecreator4$1())).getOrElse((Function0<String> & Serializable & scala.Serializable)() -> "enUS"), Platform$.MODULE$.valueOf((String)this.getOpt(wowConf, "platform", ((TypeTags)((Object)$u5)).TypeTag().apply((Mirror)((Object)$m5), new Wowchat_common_WowChatConfig$$typecreator5$1())).getOrElse((Function0<String> & Serializable & scala.Serializable)() -> "Mac")), this.getOpt(wowConf, "realm_build", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Int()).orElse((Function0<Option> & Serializable & scala.Serializable)() -> MODULE$.getOpt(wowConf, "build", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Int())), this.getOpt(wowConf, "game_build", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Int()).orElse((Function0<Option> & Serializable & scala.Serializable)() -> MODULE$.getOpt(wowConf, "build", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Int())), this.parseRealmlist(wowConf), this.convertToUpper(wowConf.getString("account")), wowConf.getString("password"), wowConf.getString("character"), BoxesRunTime.unboxToBoolean(this.getOpt(wowConf, "enable_server_motd", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Boolean()).getOrElse((JFunction0$mcZ$sp & scala.Serializable)() -> true))), this.parseGuildConfig(guildConf), this.parseChannels(channelsConf), this.parseFilters(filtersConf));
    }

    private String getVersion$lzycompute() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                this.getVersion = this.version();
                this.bitmap$0 = (byte)(this.bitmap$0 | 1);
            }
        }
        return this.getVersion;
    }

    public String getVersion() {
        return (byte)(this.bitmap$0 & 1) == 0 ? this.getVersion$lzycompute() : this.getVersion;
    }

    private Enumeration.Value getExpansion$lzycompute() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                this.getExpansion = this.expansion();
                this.bitmap$0 = (byte)(this.bitmap$0 | 2);
            }
        }
        this.expansion = null;
        return this.getExpansion;
    }

    public Enumeration.Value getExpansion() {
        return (byte)(this.bitmap$0 & 2) == 0 ? this.getExpansion$lzycompute() : this.getExpansion;
    }

    private int buildFromVersion$lzycompute() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if ((byte)(this.bitmap$0 & 4) == 0) {
                int n;
                String string = this.version();
                if ("1.6.1".equals(string)) {
                    n = 4544;
                } else if ("1.6.2".equals(string)) {
                    n = 4565;
                } else if ("1.6.3".equals(string)) {
                    n = 4620;
                } else if ("1.7.1".equals(string)) {
                    n = 4695;
                } else if ("1.8.4".equals(string)) {
                    n = 4878;
                } else if ("1.9.4".equals(string)) {
                    n = 5086;
                } else if ("1.10.2".equals(string)) {
                    n = 5302;
                } else if ("1.11.2".equals(string)) {
                    n = 5464;
                } else if ("1.12.1".equals(string)) {
                    n = 5875;
                } else if ("1.12.2".equals(string)) {
                    n = 6005;
                } else if ("1.12.3".equals(string)) {
                    n = 6141;
                } else if ("2.4.3".equals(string)) {
                    n = 8606;
                } else if ("3.2.2".equals(string)) {
                    n = 10505;
                } else if ("3.3.0".equals(string)) {
                    n = 11159;
                } else if ("3.3.2".equals(string)) {
                    n = 11403;
                } else if ("3.3.3".equals(string)) {
                    n = 11723;
                } else if ("3.3.5".equals(string)) {
                    n = 12340;
                } else if ("4.3.4".equals(string)) {
                    n = 15595;
                } else if ("5.4.8".equals(string)) {
                    n = 18414;
                } else {
                    throw new IllegalArgumentException(new StringBuilder(21).append("Build ").append(this.version()).append(" not supported!").toString());
                }
                this.buildFromVersion = n;
                this.bitmap$0 = (byte)(this.bitmap$0 | 4);
            }
        }
        return this.buildFromVersion;
    }

    private int buildFromVersion() {
        return (byte)(this.bitmap$0 & 4) == 0 ? this.buildFromVersion$lzycompute() : this.buildFromVersion;
    }

    private int getRealmBuild$lzycompute() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if ((byte)(this.bitmap$0 & 8) == 0) {
                this.getRealmBuild = BoxesRunTime.unboxToInt(Global$.MODULE$.config().wow().realmBuild().getOrElse((JFunction0$mcI$sp & scala.Serializable)() -> MODULE$.buildFromVersion()));
                this.bitmap$0 = (byte)(this.bitmap$0 | 8);
            }
        }
        return this.getRealmBuild;
    }

    public int getRealmBuild() {
        return (byte)(this.bitmap$0 & 8) == 0 ? this.getRealmBuild$lzycompute() : this.getRealmBuild;
    }

    private int getGameBuild$lzycompute() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if ((byte)(this.bitmap$0 & 0x10) == 0) {
                this.getGameBuild = BoxesRunTime.unboxToInt(Global$.MODULE$.config().wow().gameBuild().getOrElse((JFunction0$mcI$sp & scala.Serializable)() -> MODULE$.buildFromVersion()));
                this.bitmap$0 = (byte)(this.bitmap$0 | 0x10);
            }
        }
        return this.getGameBuild;
    }

    public int getGameBuild() {
        return (byte)(this.bitmap$0 & 0x10) == 0 ? this.getGameBuild$lzycompute() : this.getGameBuild;
    }

    private byte[] convertToUpper(String account) {
        return new StringOps(Predef$.MODULE$.augmentString(account)).map((Function1<Object, Object> & Serializable & scala.Serializable)c -> BoxesRunTime.boxToCharacter(WowChatConfig$.$anonfun$convertToUpper$1(BoxesRunTime.unboxToChar(c))), Predef$.MODULE$.StringCanBuildFrom()).getBytes("UTF-8");
    }

    private RealmListConfig parseRealmlist(Config wowConf) {
        Tuple2<Object, Integer> tuple2;
        String realmlist = wowConf.getString("realmlist");
        String[] splt = realmlist.split(":", 2);
        Tuple2<Object, Integer> tuple22 = tuple2 = splt.length == 1 ? new Tuple2<Object, Integer>(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])splt)).head(), BoxesRunTime.boxToInteger(3724)) : new Tuple2<Object, Integer>(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])splt)).head(), BoxesRunTime.boxToInteger(new StringOps(Predef$.MODULE$.augmentString(splt[1])).toInt()));
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        String host = (String)tuple2._1();
        int port = tuple2._2$mcI$sp();
        Tuple2<String, Integer> tuple23 = new Tuple2<String, Integer>(host, BoxesRunTime.boxToInteger(port));
        Tuple2<String, Integer> tuple24 = tuple23;
        String host2 = tuple24._1();
        int port2 = tuple24._2$mcI$sp();
        return new RealmListConfig(wowConf.getString("realm"), host2, port2);
    }

    private GuildConfig parseGuildConfig(Option<Config> guildConf2) {
        Map defaults = (Map)Predef$.MODULE$.Map().apply(Predef$.MODULE$.wrapRefArray((Object[])new Tuple2[]{Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("promoted"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(true), "`[%user] has promoted [%target] to [%rank].`")), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("demoted"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(true), "`[%user] has demoted [%target] to [%rank].`")), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("online"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(false), "`[%user] has come online.`")), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("offline"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(false), "`[%user] has gone offline.`")), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("joined"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(true), "`[%user] has joined the guild.`")), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("left"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(true), "`[%user] has left the guild.`")), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("removed"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(true), "`[%target] has been kicked out of the guild by [%user].`")), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("motd"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(true), "`Guild Message of the Day: %message`")), Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("achievement"), new Tuple2<Boolean, String>(BoxesRunTime.boxToBoolean(true), "%user has earned the achievement %achievement!"))}));
        return (GuildConfig)guildConf2.fold((Function0<GuildConfig> & Serializable & scala.Serializable)() -> new GuildConfig(defaults.mapValues((Function1<Tuple2, GuildNotificationConfig> & Serializable & scala.Serializable)x0$1 -> {
            Tuple2 tuple2 = x0$1;
            if (tuple2 == null) {
                throw new MatchError(tuple2);
            }
            boolean enabled = tuple2._1$mcZ$sp();
            String format = (String)tuple2._2();
            GuildNotificationConfig guildNotificationConfig = new GuildNotificationConfig(enabled, format, None$.MODULE$);
            return guildNotificationConfig;
        })), (Function1<Config, GuildConfig> & Serializable & scala.Serializable)guildConf -> new GuildConfig(defaults.keysIterator().map((Function1<String, Tuple2> & Serializable & scala.Serializable)key -> {
            Option<Config> conf2 = MODULE$.getConfigOpt((Config)guildConf, (String)key);
            Tuple2 tuple2 = (Tuple2)defaults.apply(key);
            return Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(key), conf2.fold((Function0<GuildNotificationConfig> & Serializable & scala.Serializable)() -> new GuildNotificationConfig(tuple2._1$mcZ$sp(), (String)tuple2._2(), None$.MODULE$), (Function1<Config, GuildNotificationConfig> & Serializable & scala.Serializable)conf -> {
                JavaUniverse $u = package$.MODULE$.universe();
                JavaUniverse.JavaMirror $m = package$.MODULE$.universe().runtimeMirror(MODULE$.getClass().getClassLoader());
                JavaUniverse $u2 = package$.MODULE$.universe();
                JavaUniverse.JavaMirror $m2 = package$.MODULE$.universe().runtimeMirror(MODULE$.getClass().getClassLoader());
                public final class Wowchat_common_WowChatConfig$$typecreator1$2
                extends TypeCreator {
                    public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                        U $u = $m$untyped.universe();
                        Mirror<U> $m = $m$untyped;
                        return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$);
                    }

                    public Wowchat_common_WowChatConfig$$typecreator1$2() {
                    }
                }
                public final class Wowchat_common_WowChatConfig$$typecreator2$2
                extends TypeCreator {
                    public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                        U $u = $m$untyped.universe();
                        Mirror<U> $m = $m$untyped;
                        return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$);
                    }

                    public Wowchat_common_WowChatConfig$$typecreator2$2() {
                    }
                }
                return new GuildNotificationConfig(BoxesRunTime.unboxToBoolean(MODULE$.getOpt((Config)conf, "enabled", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Boolean()).getOrElse((JFunction0$mcZ$sp & scala.Serializable)() -> tuple2._1$mcZ$sp())), (String)MODULE$.getOpt((Config)conf, "format", ((TypeTags)((Object)$u)).TypeTag().apply((Mirror)((Object)$m), new Wowchat_common_WowChatConfig$$typecreator1$2())).getOrElse((Function0<String> & Serializable & scala.Serializable)() -> (String)tuple2._2()), MODULE$.getOpt((Config)conf, "channel", ((TypeTags)((Object)$u2)).TypeTag().apply((Mirror)((Object)$m2), new Wowchat_common_WowChatConfig$$typecreator2$2())));
            }));
        }).toMap(Predef$.MODULE$.$conforms())));
    }

    private Seq<ChannelConfig> parseChannels(Config channelsConf) {
        return ((TraversableLike)((TraversableLike)JavaConverters$.MODULE$.asScalaBufferConverter(channelsConf.getObjectList("channels")).asScala()).map((Function1<ConfigObject, Config> & Serializable & scala.Serializable)x$4 -> x$4.toConfig(), Buffer$.MODULE$.canBuildFrom())).map((Function1<Config, ChannelConfig> & Serializable & scala.Serializable)channel -> {
            JavaUniverse $u = package$.MODULE$.universe();
            JavaUniverse.JavaMirror $m = package$.MODULE$.universe().runtimeMirror(MODULE$.getClass().getClassLoader());
            public final class Wowchat_common_WowChatConfig$$typecreator1$3
            extends TypeCreator {
                public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                    U $u = $m$untyped.universe();
                    Mirror<U> $m = $m$untyped;
                    return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$);
                }

                public Wowchat_common_WowChatConfig$$typecreator1$3() {
                }
            }
            Option<String> wowChannel = MODULE$.getOpt((Config)channel, "wow.channel", ((TypeTags)((Object)$u)).TypeTag().apply((Mirror)((Object)$m), new Wowchat_common_WowChatConfig$$typecreator1$3()));
            JavaUniverse $u2 = package$.MODULE$.universe();
            JavaUniverse.JavaMirror $m2 = package$.MODULE$.universe().runtimeMirror(MODULE$.getClass().getClassLoader());
            public final class Wowchat_common_WowChatConfig$$typecreator2$3
            extends TypeCreator {
                public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                    U $u = $m$untyped.universe();
                    Mirror<U> $m = $m$untyped;
                    return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$);
                }

                public Wowchat_common_WowChatConfig$$typecreator2$3() {
                }
            }
            return new ChannelConfig(ChatDirection$.MODULE$.withName(channel.getString("direction")), new WowChannelConfig(MODULE$.getOpt((Config)channel, "wow.id", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Int()), MODULE$.ChatEvents().parse(channel.getString("wow.type")), wowChannel, (String)MODULE$.getOpt((Config)channel, "wow.format", ((TypeTags)((Object)$u2)).TypeTag().apply((Mirror)((Object)$m2), new Wowchat_common_WowChatConfig$$typecreator2$3())).getOrElse((Function0<String> & Serializable & scala.Serializable)() -> ""), MODULE$.parseFilters(MODULE$.getConfigOpt((Config)channel, "wow.filters"))), new DiscordChannelConfig(channel.getString("discord.channel"), channel.getString("discord.format"), MODULE$.parseFilters(MODULE$.getConfigOpt((Config)channel, "discord.filters"))));
        }, Buffer$.MODULE$.canBuildFrom());
    }

    private Option<FiltersConfig> parseFilters(Option<Config> filtersConf) {
        return filtersConf.map((Function1<Config, FiltersConfig> & Serializable & scala.Serializable)config -> {
            JavaUniverse $u = package$.MODULE$.universe();
            JavaUniverse.JavaMirror $m = package$.MODULE$.universe().runtimeMirror(MODULE$.getClass().getClassLoader());
            public final class Wowchat_common_WowChatConfig$$typecreator1$4
            extends TypeCreator {
                public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                    U $u = $m$untyped.universe();
                    Mirror<U> $m = $m$untyped;
                    return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().ThisType($m.staticPackage("java.util").asModule().moduleClass()), $m.staticClass("java.util.List"), new $colon$colon<Nothing$>((Nothing$)((Object)$u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$)), Nil$.MODULE$));
                }

                public Wowchat_common_WowChatConfig$$typecreator1$4() {
                }
            }
            return new FiltersConfig(BoxesRunTime.unboxToBoolean(MODULE$.getOpt((Config)config, "enabled", ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Boolean()).getOrElse((JFunction0$mcZ$sp & scala.Serializable)() -> false)), JavaConverters$.MODULE$.asScalaBufferConverter((List)MODULE$.getOpt((Config)config, "patterns", ((TypeTags)((Object)$u)).TypeTag().apply((Mirror)((Object)$m), new Wowchat_common_WowChatConfig$$typecreator1$4())).getOrElse((Function0<ArrayList> & Serializable & scala.Serializable)() -> new ArrayList())).asScala());
        });
    }

    private Option<Config> getConfigOpt(Config cfg, String path) {
        return cfg.hasPath(path) ? new Some<Config>(cfg.getConfig(path)) : None$.MODULE$;
    }

    private <T> Option<T> getOpt(Config cfg, String path, TypeTags.TypeTag<T> evidence$1) {
        Option option;
        if (cfg.hasPath(path)) {
            Object object;
            if (((TypeTags)((Object)package$.MODULE$.universe())).typeOf(evidence$1).$eq$colon$eq(((TypeTags)((Object)package$.MODULE$.universe())).typeOf(((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().Boolean()))) {
                String string = cfg.getString(path).toLowerCase();
                boolean bl = "true".equals(string) ? true : ("1".equals(string) ? true : ("y".equals(string) ? true : "yes".equals(string)));
                boolean bl2 = bl;
                object = BoxesRunTime.boxToBoolean(bl2);
            } else {
                JavaUniverse $u = package$.MODULE$.universe();
                JavaUniverse.JavaMirror $m = package$.MODULE$.universe().runtimeMirror(this.getClass().getClassLoader());
                public final class Wowchat_common_WowChatConfig$$typecreator1$5
                extends TypeCreator {
                    public <U extends Universe> Types.TypeApi apply(Mirror<U> $m$untyped) {
                        U $u = $m$untyped.universe();
                        Mirror<U> $m = $m$untyped;
                        return $u.internal().reificationSupport().TypeRef($u.internal().reificationSupport().SingleType($m.staticPackage("scala").asModule().moduleClass().asType().toTypeConstructor(), $m.staticModule("scala.Predef")), $u.internal().reificationSupport().selectType($m.staticModule("scala.Predef").asModule().moduleClass(), "String"), Nil$.MODULE$);
                    }

                    public Wowchat_common_WowChatConfig$$typecreator1$5() {
                    }
                }
                object = ((TypeTags)((Object)package$.MODULE$.universe())).typeOf(evidence$1).$eq$colon$eq(((TypeTags)((Object)package$.MODULE$.universe())).typeOf(((TypeTags)((Object)$u)).TypeTag().apply((Mirror)((Object)$m), new Wowchat_common_WowChatConfig$$typecreator1$5()))) ? cfg.getString(path) : cfg.getAnyRef(path);
            }
            option = new Some<Boolean>((Boolean)object);
        } else {
            option = None$.MODULE$;
        }
        return option;
    }

    public WowChatConfig apply(DiscordConfig discord, Wow wow, GuildConfig guildConfig, Seq<ChannelConfig> channels, Option<FiltersConfig> filters) {
        return new WowChatConfig(discord, wow, guildConfig, channels, filters);
    }

    public Option<Tuple5<DiscordConfig, Wow, GuildConfig, Seq<ChannelConfig>, Option<FiltersConfig>>> unapply(WowChatConfig x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple5<DiscordConfig, Wow, GuildConfig, Seq<ChannelConfig>, Option<FiltersConfig>>>(new Tuple5<DiscordConfig, Wow, GuildConfig, Seq<ChannelConfig>, Option<FiltersConfig>>(x$0.discord(), x$0.wow(), x$0.guildConfig(), x$0.channels(), x$0.filters()));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private final void ChatEvents$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.ChatEvents$module == null) {
                this.ChatEvents$module = new GamePackets$ChatEvents$(this);
            }
        }
    }

    private final void GuildEvents$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.GuildEvents$module == null) {
                this.GuildEvents$module = new GamePackets$GuildEvents$(this);
            }
        }
    }

    private final void Races$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.Races$module == null) {
                this.Races$module = new GamePackets$Races$(this);
            }
        }
    }

    private final void Classes$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.Classes$module == null) {
                this.Classes$module = new GamePackets$Classes$(this);
            }
        }
    }

    private final void Genders$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.Genders$module == null) {
                this.Genders$module = new GamePackets$Genders$(this);
            }
        }
    }

    private final void AuthResponseCodes$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.AuthResponseCodes$module == null) {
                this.AuthResponseCodes$module = new GamePackets$AuthResponseCodes$(this);
            }
        }
    }

    private final void ChatNotify$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.ChatNotify$module == null) {
                this.ChatNotify$module = new GamePackets$ChatNotify$(this);
            }
        }
    }

    private final void ServerMessageType$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.ServerMessageType$module == null) {
                this.ServerMessageType$module = new GamePackets$ServerMessageType$(this);
            }
        }
    }

    private final void ChatChannelIds$lzycompute$1() {
        WowChatConfig$ wowChatConfig$ = this;
        synchronized (wowChatConfig$) {
            if (this.ChatChannelIds$module == null) {
                this.ChatChannelIds$module = new GamePackets$ChatChannelIds$(this);
            }
        }
    }

    public static final /* synthetic */ char $anonfun$convertToUpper$1(char c) {
        return c >= 'a' && c <= 'z' ? RichChar$.MODULE$.toUpper$extension(Predef$.MODULE$.charWrapper(c)) : c;
    }

    private WowChatConfig$() {
        MODULE$ = this;
        GamePackets.$init$(this);
    }
}

