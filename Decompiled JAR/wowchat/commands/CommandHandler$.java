/*
 * Decompiled with CFR 0.152.
 */
package wowchat.commands;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.util.AttributeKey;
import java.io.Serializable;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.collection.Iterable;
import scala.collection.Iterable$;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.Map;
import scala.runtime.BoxesRunTime;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.NonLocalReturnControl$mcZ$sp;
import scala.runtime.Nothing$;
import scala.util.Try$;
import wowchat.commands.CommandHandler$;
import wowchat.commands.WhoRequest;
import wowchat.commands.WhoResponse;
import wowchat.common.Global$;
import wowchat.game.GameCommandHandler;
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
import wowchat.game.GameResources$;
import wowchat.game.GuildInfo;
import wowchat.game.GuildMember;

public final class CommandHandler$
implements StrictLogging {
    public static CommandHandler$ MODULE$;
    private final String NOT_ONLINE;
    private final String trigger;
    private WhoRequest whoRequest;
    private final Logger logger;

    static {
        new CommandHandler$();
    }

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    private String NOT_ONLINE() {
        return this.NOT_ONLINE;
    }

    private String trigger() {
        return this.trigger;
    }

    public WhoRequest whoRequest() {
        return this.whoRequest;
    }

    public void whoRequest_$eq(WhoRequest x$1) {
        this.whoRequest = x$1;
    }

    public boolean apply(MessageChannel fromChannel, String message) {
        boolean bl;
        Object object = new Object();
        try {
            if (!message.startsWith(this.trigger())) {
                return false;
            }
            String[] splt = message.substring(this.trigger().length()).split(" ");
            String possibleCommand = splt[0].toLowerCase();
            None$ arguments = splt.length > 1 && splt[1].length() <= 16 ? new Some<String>(splt[1]) : None$.MODULE$;
            bl = BoxesRunTime.unboxToBoolean(Try$.MODULE$.apply((Function0<Option> & Serializable & scala.Serializable)() -> {
                Option option;
                String string = possibleCommand;
                boolean bl = "who".equals(string) ? true : "online".equals(string);
                if (bl) {
                    option = (Option)Global$.MODULE$.game().fold((Function0<Nothing$> & Serializable & scala.Serializable)() -> {
                        fromChannel.sendMessage(MODULE$.NOT_ONLINE()).queue();
                        throw new NonLocalReturnControl$mcZ$sp(object, true);
                    }, (Function1<GameCommandHandler, Option> & Serializable & scala.Serializable)game -> {
                        void var3_3;
                        block0: {
                            Option<String> whoSucceeded = game.handleWho(arguments);
                            if (!arguments.isDefined()) break block0;
                            MODULE$.whoRequest_$eq(new WhoRequest(fromChannel, (String)arguments.get()));
                        }
                        return var3_3;
                    });
                } else if ("gmotd".equals(string)) {
                    option = (Option)Global$.MODULE$.game().fold((Function0<Nothing$> & Serializable & scala.Serializable)() -> {
                        fromChannel.sendMessage(MODULE$.NOT_ONLINE()).queue();
                        throw new NonLocalReturnControl$mcZ$sp(object, true);
                    }, (Function1<GameCommandHandler, Option> & Serializable & scala.Serializable)x$1 -> x$1.handleGmotd());
                } else {
                    throw new MatchError((Object)string);
                }
                return option;
            }).fold((Function1<Throwable, Object> & Serializable & scala.Serializable)throwable -> BoxesRunTime.boxToBoolean(CommandHandler$.$anonfun$apply$6(throwable)), (Function1<Option, Object> & Serializable & scala.Serializable)opt -> BoxesRunTime.boxToBoolean(CommandHandler$.$anonfun$apply$7(fromChannel, opt))));
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                bl = ex.value$mcZ$sp();
            }
            throw ex;
        }
        return bl;
    }

    public Iterable<String> handleWhoResponse(Option<WhoResponse> whoResponse, GuildInfo guildInfo, Map<Object, GuildMember> guildRoster, Function1<GuildMember, Object> guildRosterMatcherFunc) {
        return (Iterable)whoResponse.map((Function1<WhoResponse, Seq> & Serializable & scala.Serializable)r -> new $colon$colon<Nothing$>((Nothing$)((Object)new StringBuilder(28).append(r.playerName()).append(" ").append((Object)(new StringOps(Predef$.MODULE$.augmentString(r.guildName())).nonEmpty() ? new StringBuilder(3).append("<").append(r.guildName()).append("> ").toString() : "")).append("is a level ").append(r.lvl()).append(r.gender().fold((Function0<String> & Serializable & scala.Serializable)() -> " ", (Function1<String, String> & Serializable & scala.Serializable)g -> new StringBuilder(2).append(" ").append((String)g).append(" ").toString())).append(r.race()).append(" ").append(r.cls()).append(" currently in ").append(r.zone()).append(".").toString()), Nil$.MODULE$)).getOrElse((Function0<Iterable> & Serializable & scala.Serializable)() -> ((TraversableLike)guildRoster.values().filter(guildRosterMatcherFunc)).map((Function1<GuildMember, String> & Serializable & scala.Serializable)guildMember -> {
            String hoursStr;
            String cls = new GamePackets(){
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

                public AttributeKey<GameHeaderCrypt> CRYPT() {
                    return this.CRYPT;
                }

                public int CMSG_CHAR_ENUM() {
                    return this.CMSG_CHAR_ENUM;
                }

                public int SMSG_CHAR_ENUM() {
                    return this.SMSG_CHAR_ENUM;
                }

                public int CMSG_PLAYER_LOGIN() {
                    return this.CMSG_PLAYER_LOGIN;
                }

                public int CMSG_LOGOUT_REQUEST() {
                    return this.CMSG_LOGOUT_REQUEST;
                }

                public int CMSG_NAME_QUERY() {
                    return this.CMSG_NAME_QUERY;
                }

                public int SMSG_NAME_QUERY() {
                    return this.SMSG_NAME_QUERY;
                }

                public int CMSG_GUILD_QUERY() {
                    return this.CMSG_GUILD_QUERY;
                }

                public int SMSG_GUILD_QUERY() {
                    return this.SMSG_GUILD_QUERY;
                }

                public int CMSG_WHO() {
                    return this.CMSG_WHO;
                }

                public int SMSG_WHO() {
                    return this.SMSG_WHO;
                }

                public int CMSG_GUILD_ROSTER() {
                    return this.CMSG_GUILD_ROSTER;
                }

                public int SMSG_GUILD_ROSTER() {
                    return this.SMSG_GUILD_ROSTER;
                }

                public int SMSG_GUILD_EVENT() {
                    return this.SMSG_GUILD_EVENT;
                }

                public int CMSG_MESSAGECHAT() {
                    return this.CMSG_MESSAGECHAT;
                }

                public int SMSG_MESSAGECHAT() {
                    return this.SMSG_MESSAGECHAT;
                }

                public int CMSG_JOIN_CHANNEL() {
                    return this.CMSG_JOIN_CHANNEL;
                }

                public int SMSG_CHANNEL_NOTIFY() {
                    return this.SMSG_CHANNEL_NOTIFY;
                }

                public int SMSG_NOTIFICATION() {
                    return this.SMSG_NOTIFICATION;
                }

                public int CMSG_PING() {
                    return this.CMSG_PING;
                }

                public int SMSG_AUTH_CHALLENGE() {
                    return this.SMSG_AUTH_CHALLENGE;
                }

                public int CMSG_AUTH_CHALLENGE() {
                    return this.CMSG_AUTH_CHALLENGE;
                }

                public int SMSG_AUTH_RESPONSE() {
                    return this.SMSG_AUTH_RESPONSE;
                }

                public int SMSG_LOGIN_VERIFY_WORLD() {
                    return this.SMSG_LOGIN_VERIFY_WORLD;
                }

                public int SMSG_SERVER_MESSAGE() {
                    return this.SMSG_SERVER_MESSAGE;
                }

                public int SMSG_WARDEN_DATA() {
                    return this.SMSG_WARDEN_DATA;
                }

                public int CMSG_WARDEN_DATA() {
                    return this.CMSG_WARDEN_DATA;
                }

                public int SMSG_INVALIDATE_PLAYER() {
                    return this.SMSG_INVALIDATE_PLAYER;
                }

                public int SMSG_TIME_SYNC_REQ() {
                    return this.SMSG_TIME_SYNC_REQ;
                }

                public int CMSG_TIME_SYNC_RESP() {
                    return this.CMSG_TIME_SYNC_RESP;
                }

                public GamePackets$ChatEvents$ ChatEvents() {
                    if (this.ChatEvents$module == null) {
                        this.ChatEvents$lzycompute$1();
                    }
                    return this.ChatEvents$module;
                }

                public GamePackets$GuildEvents$ GuildEvents() {
                    if (this.GuildEvents$module == null) {
                        this.GuildEvents$lzycompute$1();
                    }
                    return this.GuildEvents$module;
                }

                public GamePackets$Races$ Races() {
                    if (this.Races$module == null) {
                        this.Races$lzycompute$1();
                    }
                    return this.Races$module;
                }

                public GamePackets$Classes$ Classes() {
                    if (this.Classes$module == null) {
                        this.Classes$lzycompute$1();
                    }
                    return this.Classes$module;
                }

                public GamePackets$Genders$ Genders() {
                    if (this.Genders$module == null) {
                        this.Genders$lzycompute$1();
                    }
                    return this.Genders$module;
                }

                public GamePackets$AuthResponseCodes$ AuthResponseCodes() {
                    if (this.AuthResponseCodes$module == null) {
                        this.AuthResponseCodes$lzycompute$1();
                    }
                    return this.AuthResponseCodes$module;
                }

                public GamePackets$ChatNotify$ ChatNotify() {
                    if (this.ChatNotify$module == null) {
                        this.ChatNotify$lzycompute$1();
                    }
                    return this.ChatNotify$module;
                }

                public GamePackets$ServerMessageType$ ServerMessageType() {
                    if (this.ServerMessageType$module == null) {
                        this.ServerMessageType$lzycompute$1();
                    }
                    return this.ServerMessageType$module;
                }

                public GamePackets$ChatChannelIds$ ChatChannelIds() {
                    if (this.ChatChannelIds$module == null) {
                        this.ChatChannelIds$lzycompute$1();
                    }
                    return this.ChatChannelIds$module;
                }

                public void wowchat$game$GamePackets$_setter_$CRYPT_$eq(AttributeKey<GameHeaderCrypt> x$1) {
                    this.CRYPT = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_CHAR_ENUM_$eq(int x$1) {
                    this.CMSG_CHAR_ENUM = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_CHAR_ENUM_$eq(int x$1) {
                    this.SMSG_CHAR_ENUM = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_PLAYER_LOGIN_$eq(int x$1) {
                    this.CMSG_PLAYER_LOGIN = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_LOGOUT_REQUEST_$eq(int x$1) {
                    this.CMSG_LOGOUT_REQUEST = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_NAME_QUERY_$eq(int x$1) {
                    this.CMSG_NAME_QUERY = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_NAME_QUERY_$eq(int x$1) {
                    this.SMSG_NAME_QUERY = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_GUILD_QUERY_$eq(int x$1) {
                    this.CMSG_GUILD_QUERY = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_QUERY_$eq(int x$1) {
                    this.SMSG_GUILD_QUERY = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_WHO_$eq(int x$1) {
                    this.CMSG_WHO = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_WHO_$eq(int x$1) {
                    this.SMSG_WHO = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_GUILD_ROSTER_$eq(int x$1) {
                    this.CMSG_GUILD_ROSTER = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_ROSTER_$eq(int x$1) {
                    this.SMSG_GUILD_ROSTER = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_GUILD_EVENT_$eq(int x$1) {
                    this.SMSG_GUILD_EVENT = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_MESSAGECHAT_$eq(int x$1) {
                    this.CMSG_MESSAGECHAT = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_MESSAGECHAT_$eq(int x$1) {
                    this.SMSG_MESSAGECHAT = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_JOIN_CHANNEL_$eq(int x$1) {
                    this.CMSG_JOIN_CHANNEL = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_CHANNEL_NOTIFY_$eq(int x$1) {
                    this.SMSG_CHANNEL_NOTIFY = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_NOTIFICATION_$eq(int x$1) {
                    this.SMSG_NOTIFICATION = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_PING_$eq(int x$1) {
                    this.CMSG_PING = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_AUTH_CHALLENGE_$eq(int x$1) {
                    this.SMSG_AUTH_CHALLENGE = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_AUTH_CHALLENGE_$eq(int x$1) {
                    this.CMSG_AUTH_CHALLENGE = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_AUTH_RESPONSE_$eq(int x$1) {
                    this.SMSG_AUTH_RESPONSE = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_LOGIN_VERIFY_WORLD_$eq(int x$1) {
                    this.SMSG_LOGIN_VERIFY_WORLD = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_SERVER_MESSAGE_$eq(int x$1) {
                    this.SMSG_SERVER_MESSAGE = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_WARDEN_DATA_$eq(int x$1) {
                    this.SMSG_WARDEN_DATA = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_WARDEN_DATA_$eq(int x$1) {
                    this.CMSG_WARDEN_DATA = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_INVALIDATE_PLAYER_$eq(int x$1) {
                    this.SMSG_INVALIDATE_PLAYER = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$SMSG_TIME_SYNC_REQ_$eq(int x$1) {
                    this.SMSG_TIME_SYNC_REQ = x$1;
                }

                public void wowchat$game$GamePackets$_setter_$CMSG_TIME_SYNC_RESP_$eq(int x$1) {
                    this.CMSG_TIME_SYNC_RESP = x$1;
                }

                private final void ChatEvents$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.ChatEvents$module == null) {
                            this.ChatEvents$module = new GamePackets$ChatEvents$(this);
                        }
                    }
                }

                private final void GuildEvents$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.GuildEvents$module == null) {
                            this.GuildEvents$module = new GamePackets$GuildEvents$(this);
                        }
                    }
                }

                private final void Races$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.Races$module == null) {
                            this.Races$module = new GamePackets$Races$(this);
                        }
                    }
                }

                private final void Classes$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.Classes$module == null) {
                            this.Classes$module = new GamePackets$Classes$(this);
                        }
                    }
                }

                private final void Genders$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.Genders$module == null) {
                            this.Genders$module = new GamePackets$Genders$(this);
                        }
                    }
                }

                private final void AuthResponseCodes$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.AuthResponseCodes$module == null) {
                            this.AuthResponseCodes$module = new GamePackets$AuthResponseCodes$(this);
                        }
                    }
                }

                private final void ChatNotify$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.ChatNotify$module == null) {
                            this.ChatNotify$module = new GamePackets$ChatNotify$(this);
                        }
                    }
                }

                private final void ServerMessageType$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.ServerMessageType$module == null) {
                            this.ServerMessageType$module = new GamePackets$ServerMessageType$(this);
                        }
                    }
                }

                private final void ChatChannelIds$lzycompute$1() {
                    anon.1 var1_1 = this;
                    synchronized (var1_1) {
                        if (this.ChatChannelIds$module == null) {
                            this.ChatChannelIds$module = new GamePackets$ChatChannelIds$(this);
                        }
                    }
                }
                {
                    GamePackets.$init$(this);
                }
            }.Classes().valueOf(guildMember.charClass());
            int days = (int)guildMember.lastLogoff();
            int hours = (int)(guildMember.lastLogoff() * (float)24 % (float)24);
            int minutes = (int)(guildMember.lastLogoff() * (float)24 * (float)60 % (float)60);
            String minutesStr = new StringBuilder(8).append(" ").append(minutes).append(" minute").append((Object)(minutes != 1 ? "s" : "")).toString();
            String string = hours > 0 ? new StringBuilder(7).append(" ").append(hours).append(" hour").append((Object)(hours != 1 ? "s" : "")).append(",").toString() : (hoursStr = "");
            String daysStr = days > 0 ? new StringBuilder(6).append(" ").append(days).append(" day").append((Object)(days != 1 ? "s" : "")).append(",").toString() : "";
            String guildNameStr = guildInfo != null ? new StringBuilder(3).append(" <").append(guildInfo.name()).append(">").toString() : "";
            return new StringBuilder(51).append(guildMember.name()).append(guildNameStr).append(" is a level ").append(guildMember.level()).append(" ").append(cls).append(" currently offline. ").append("Last seen").append(daysStr).append(hoursStr).append(minutesStr).append(" ago in ").append(GameResources$.MODULE$.AREA().getOrElse(BoxesRunTime.boxToInteger(guildMember.zoneId()), (Function0<String> & Serializable & scala.Serializable)() -> "Unknown Zone")).append(".").toString();
        }, Iterable$.MODULE$.canBuildFrom()));
    }

    public static final /* synthetic */ boolean $anonfun$apply$6(Throwable throwable) {
        return false;
    }

    public static final /* synthetic */ boolean $anonfun$apply$7(MessageChannel fromChannel$1, Option opt) {
        block0: {
            if (!opt.isDefined()) break block0;
            fromChannel$1.sendMessage((CharSequence)opt.get()).queue();
        }
        return true;
    }

    private CommandHandler$() {
        MODULE$ = this;
        StrictLogging.$init$(this);
        this.NOT_ONLINE = "Bot is not online.";
        this.trigger = "?";
    }
}

