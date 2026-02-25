/*
 * Decompiled with CFR 0.152.
 */
package wowchat.discord;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import com.vdurmont.emoji.EmojiParser;
import io.netty.util.AttributeKey;
import java.io.Serializable;
import java.lang.invoke.LambdaMetafactory;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageType;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.StatusChangeEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ShutdownEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.CloseCode;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Option$;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.JavaConverters$;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.SeqLike;
import scala.collection.SetLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.ArrayBuffer$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Buffer$;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.MultiMap;
import scala.collection.mutable.Set;
import scala.collection.mutable.Set$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.java8.JFunction0$mcV$sp;
import wowchat.commands.CommandHandler$;
import wowchat.common.ChannelConfig;
import wowchat.common.ChatDirection$;
import wowchat.common.CommonConnectionCallback;
import wowchat.common.DiscordChannelConfig;
import wowchat.common.DiscordConfig;
import wowchat.common.FiltersConfig;
import wowchat.common.Global$;
import wowchat.common.GuildNotificationConfig;
import wowchat.common.WowChannelConfig;
import wowchat.discord.MessageResolver;
import wowchat.discord.MessageResolver$;
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

@ScalaSignature(bytes="\u0006\u0001\u0005\u0015h\u0001\u0002\u000e\u001c\u0001\u0001B\u0001b\u0010\u0001\u0003\u0002\u0003\u0006I\u0001\u0011\u0005\u0006\r\u0002!\ta\u0012\u0005\bQ\u0001\u0011\r\u0011\"\u0003L\u0011\u0019\u0001\u0006\u0001)A\u0005\u0019\"9\u0011\u000b\u0001b\u0001\n\u0013\u0011\u0006B\u0002,\u0001A\u0003%1\u000bC\u0004X\u0001\u0001\u0007I\u0011\u0002-\t\u000f\u0015\u0004\u0001\u0019!C\u0005M\"1A\u000e\u0001Q!\neCq!\u001c\u0001A\u0002\u0013%a\u000eC\u0004s\u0001\u0001\u0007I\u0011B:\t\rU\u0004\u0001\u0015)\u0003p\u0011\u00151\b\u0001\"\u0001x\u0011\u001d\t\t\u0004\u0001C\u0001\u0003gAq!a\u000e\u0001\t\u0003\tI\u0004C\u0004\u0002>\u0001!\t!a\u0010\t\u000f\u0005]\u0003\u0001\"\u0001\u0002Z!9\u0011\u0011\r\u0001\u0005\u0002\u0005\r\u0004bBA:\u0001\u0011\u0005\u0013Q\u000f\u0005\b\u0003\u000f\u0003A\u0011IAE\u0011\u001d\tI\n\u0001C!\u00037Cq!!+\u0001\t\u0003\tY\u000bC\u0004\u00020\u0002!\t!!-\t\u000f\u0005\u0005\u0007\u0001\"\u0001\u0002D\"9\u0011q\u0019\u0001\u0005\u0002\u0005%'a\u0002#jg\u000e|'\u000f\u001a\u0006\u00039u\tq\u0001Z5tG>\u0014HMC\u0001\u001f\u0003\u001d9xn^2iCR\u001c\u0001a\u0005\u0003\u0001C=*\u0004C\u0001\u0012.\u001b\u0005\u0019#B\u0001\u0013&\u0003\u0015Awn\\6t\u0015\t1s%A\u0002ba&T!\u0001K\u0015\u0002\u0007)$\u0017M\u0003\u0002+W\u00059AM\u001e\u001duS>t'\"\u0001\u0017\u0002\u00079,G/\u0003\u0002/G\tyA*[:uK:,'/\u00113baR,'\u000f\u0005\u00021g5\t\u0011G\u0003\u00023;\u0005!q-Y7f\u0013\t!\u0014GA\u0006HC6,\u0007+Y2lKR\u001c\bC\u0001\u001c>\u001b\u00059$B\u0001\u001d:\u00031\u00198-\u00197bY><w-\u001b8h\u0015\tQ4(\u0001\u0005usB,7/\u00194f\u0015\u0005a\u0014aA2p[&\u0011ah\u000e\u0002\u000e'R\u0014\u0018n\u0019;M_\u001e<\u0017N\\4\u00023\u0011L7oY8sI\u000e{gN\\3di&|gnQ1mY\n\f7m\u001b\t\u0003\u0003\u0012k\u0011A\u0011\u0006\u0003\u0007v\taaY8n[>t\u0017BA#C\u0005a\u0019u.\\7p]\u000e{gN\\3di&|gnQ1mY\n\f7m[\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0005!S\u0005CA%\u0001\u001b\u0005Y\u0002\"B \u0003\u0001\u0004\u0001U#\u0001'\u0011\u00055sU\"A\u0013\n\u0005=+#a\u0001&E\u0003\u0006!!\u000eZ1!\u0003=iWm]:bO\u0016\u0014Vm]8mm\u0016\u0014X#A*\u0011\u0005%#\u0016BA+\u001c\u0005=iUm]:bO\u0016\u0014Vm]8mm\u0016\u0014\u0018\u0001E7fgN\fw-\u001a*fg>dg/\u001a:!\u0003)a\u0017m\u001d;Ti\u0006$Xo]\u000b\u00023B\u0019!,X0\u000e\u0003mS\u0011\u0001X\u0001\u0006g\u000e\fG.Y\u0005\u0003=n\u0013aa\u00149uS>t\u0007C\u00011d\u001b\u0005\t'B\u00012&\u0003!)g\u000e^5uS\u0016\u001c\u0018B\u00013b\u0005!\t5\r^5wSRL\u0018A\u00047bgR\u001cF/\u0019;vg~#S-\u001d\u000b\u0003O*\u0004\"A\u00175\n\u0005%\\&\u0001B+oSRDqa\u001b\u0005\u0002\u0002\u0003\u0007\u0011,A\u0002yIE\n1\u0002\\1tiN#\u0018\r^;tA\u0005aa-\u001b:ti\u000e{gN\\3diV\tq\u000e\u0005\u0002[a&\u0011\u0011o\u0017\u0002\b\u0005>|G.Z1o\u0003A1\u0017N]:u\u0007>tg.Z2u?\u0012*\u0017\u000f\u0006\u0002hi\"91nCA\u0001\u0002\u0004y\u0017!\u00044jeN$8i\u001c8oK\u000e$\b%\u0001\u0007dQ\u0006tw-Z*uCR,8\u000f\u0006\u0003hq\u0006u\u0001\"B=\u000e\u0001\u0004Q\u0018\u0001C4b[\u0016$\u0016\u0010]3\u0011\u0007m\f9BD\u0002}\u0003'q1!`A\t\u001d\rq\u0018q\u0002\b\u0004\u007f\u00065a\u0002BA\u0001\u0003\u0017qA!a\u0001\u0002\n5\u0011\u0011Q\u0001\u0006\u0004\u0003\u000fy\u0012A\u0002\u001fs_>$h(C\u0001-\u0013\tQ3&\u0003\u0002)S%\u0011aeJ\u0005\u0003E\u0016J1!!\u0006b\u0003!\t5\r^5wSRL\u0018\u0002BA\r\u00037\u0011A\"Q2uSZLG/\u001f+za\u0016T1!!\u0006b\u0011\u001d\ty\"\u0004a\u0001\u0003C\tq!\\3tg\u0006<W\r\u0005\u0003\u0002$\u0005-b\u0002BA\u0013\u0003O\u00012!a\u0001\\\u0013\r\tIcW\u0001\u0007!J,G-\u001a4\n\t\u00055\u0012q\u0006\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005%2,A\tdQ\u0006tw-Z$vS2$7\u000b^1ukN$2aZA\u001b\u0011\u001d\tyB\u0004a\u0001\u0003C\t\u0011c\u00195b]\u001e,'+Z1m[N#\u0018\r^;t)\r9\u00171\b\u0005\b\u0003?y\u0001\u0019AA\u0011\u0003I\u0019XM\u001c3NKN\u001c\u0018mZ3Ge>lwk\\<\u0015\u0013\u001d\f\t%a\u0012\u0002J\u0005M\u0003bBA\"!\u0001\u0007\u0011QI\u0001\u0005MJ|W\u000e\u0005\u0003[;\u0006\u0005\u0002bBA\u0010!\u0001\u0007\u0011\u0011\u0005\u0005\b\u0003\u0017\u0002\u0002\u0019AA'\u0003\u001d9xn\u001e+za\u0016\u00042AWA(\u0013\r\t\tf\u0017\u0002\u0005\u0005f$X\rC\u0004\u0002VA\u0001\r!!\u0012\u0002\u0015]|wo\u00115b]:,G.A\u000btK:$w)^5mI:{G/\u001b4jG\u0006$\u0018n\u001c8\u0015\u000b\u001d\fY&a\u0018\t\u000f\u0005u\u0013\u00031\u0001\u0002\"\u0005AQM^3oi.+\u0017\u0010C\u0004\u0002 E\u0001\r!!\t\u00027M,g\u000eZ!dQ&,g/Z7f]Rtu\u000e^5gS\u000e\fG/[8o)\u00159\u0017QMA5\u0011\u001d\t9G\u0005a\u0001\u0003C\tAA\\1nK\"9\u00111\u000e\nA\u0002\u00055\u0014!D1dQ&,g/Z7f]RLE\rE\u0002[\u0003_J1!!\u001d\\\u0005\rIe\u000e^\u0001\u000f_:\u001cF/\u0019;vg\u000eC\u0017M\\4f)\r9\u0017q\u000f\u0005\b\u0003s\u001a\u0002\u0019AA>\u0003\u0015)g/\u001a8u!\u0011\ti(a!\u000e\u0005\u0005}$bAAAK\u00051QM^3oiNLA!!\"\u0002\u0000\t\t2\u000b^1ukN\u001c\u0005.\u00198hK\u00163XM\u001c;\u0002\u0015=t7\u000b[;uI><h\u000eF\u0002h\u0003\u0017Cq!!\u001f\u0015\u0001\u0004\ti\t\u0005\u0003\u0002\u0010\u0006UUBAAI\u0015\u0011\t\u0019*a \u0002\u000fM,7o]5p]&!\u0011qSAI\u00055\u0019\u0006.\u001e;e_^tWI^3oi\u0006\trN\\'fgN\fw-\u001a*fG\u0016Lg/\u001a3\u0015\u0007\u001d\fi\nC\u0004\u0002zU\u0001\r!a(\u0011\t\u0005\u0005\u0016QU\u0007\u0003\u0003GSA!a\b\u0002\u0000%!\u0011qUAR\u0005QiUm]:bO\u0016\u0014VmY3jm\u0016$WI^3oi\u0006\u00112\u000f[8vY\u0012\u001cVM\u001c3ESJ,7\r\u001e7z)\ry\u0017Q\u0016\u0005\b\u0003?1\u0002\u0019AA\u0011\u00031\u0019\bn\\;mI\u001aKG\u000e^3s)\u0015y\u00171WA`\u0011\u001d\t)l\u0006a\u0001\u0003o\u000bQBZ5mi\u0016\u00148oQ8oM&<\u0007\u0003\u0002.^\u0003s\u00032!QA^\u0013\r\tiL\u0011\u0002\u000e\r&dG/\u001a:t\u0007>tg-[4\t\u000f\u0005}q\u00031\u0001\u0002\"\u0005y1/\u00198ji&TX-T3tg\u0006<W\r\u0006\u0003\u0002\"\u0005\u0015\u0007bBA\u00101\u0001\u0007\u0011\u0011E\u0001\u000fgBd\u0017\u000e^+q\u001b\u0016\u001c8/Y4f)!\tY-!8\u0002b\u0006\r\bCBAg\u0003/\f\tC\u0004\u0003\u0002P\u0006Mg\u0002BA\u0002\u0003#L\u0011\u0001X\u0005\u0004\u0003+\\\u0016a\u00029bG.\fw-Z\u0005\u0005\u00033\fYNA\u0002TKFT1!!6\\\u0011\u001d\ty.\u0007a\u0001\u0003C\taAZ8s[\u0006$\bbBA43\u0001\u0007\u0011\u0011\u0005\u0005\b\u0003?I\u0002\u0019AA\u0011\u0001")
public class Discord
extends ListenerAdapter
implements GamePackets,
StrictLogging {
    private final CommonConnectionCallback discordConnectionCallback;
    private final JDA jda;
    private final MessageResolver messageResolver;
    private Option<Activity> lastStatus;
    private boolean firstConnect;
    private final Logger logger;
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

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
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

    private JDA jda() {
        return this.jda;
    }

    private MessageResolver messageResolver() {
        return this.messageResolver;
    }

    private Option<Activity> lastStatus() {
        return this.lastStatus;
    }

    private void lastStatus_$eq(Option<Activity> x$1) {
        this.lastStatus = x$1;
    }

    private boolean firstConnect() {
        return this.firstConnect;
    }

    private void firstConnect_$eq(boolean x$1) {
        this.firstConnect = x$1;
    }

    public void changeStatus(Activity.ActivityType gameType, String message) {
        this.lastStatus_$eq(new Some<Activity>(Activity.of(gameType, message)));
        this.jda().getPresence().setActivity(this.lastStatus().get());
    }

    public void changeGuildStatus(String message) {
        this.changeStatus(Activity.ActivityType.WATCHING, message);
    }

    public void changeRealmStatus(String message) {
        this.changeStatus(Activity.ActivityType.CUSTOM_STATUS, message);
    }

    public void sendMessageFromWow(Option<String> from, String message, byte wowType, Option<String> wowChannel) {
        Global$.MODULE$.wowToDiscord().get(new Tuple2(BoxesRunTime.boxToByte(wowType), wowChannel.map((Function1<String, String> & Serializable & scala.Serializable)x$1 -> x$1.toLowerCase()))).foreach((Function1<Set, Object> & Serializable & scala.Serializable)discordChannels -> {
            Discord.$anonfun$sendMessageFromWow$2(this, message, from, wowChannel, discordChannels);
            return BoxedUnit.UNIT;
        });
    }

    public void sendGuildNotification(String eventKey, String message) {
        ((IterableLike)Global$.MODULE$.guildEventsToDiscord().getOrElse(eventKey, (Function0<Set> & Serializable & scala.Serializable)() -> ((SetLike)Global$.MODULE$.wowToDiscord().getOrElse(new Tuple2<Byte, None$>(BoxesRunTime.boxToByte(this.ChatEvents().CHAT_MSG_GUILD()), None$.MODULE$), (Function0<Set> & Serializable & scala.Serializable)() -> Set$.MODULE$.empty())).map((Function1<Tuple2, TextChannel> & Serializable & scala.Serializable)x$5 -> (TextChannel)x$5._1(), Set$.MODULE$.canBuildFrom()))).foreach((Function1<TextChannel, Object> & Serializable & scala.Serializable)channel -> {
            Discord.$anonfun$sendGuildNotification$4(this, message, channel);
            return BoxedUnit.UNIT;
        });
    }

    public void sendAchievementNotification(String name, int achievementId) {
        GuildNotificationConfig notificationConfig = (GuildNotificationConfig)Global$.MODULE$.config().guildConfig().notificationConfigs().apply("achievement");
        if (!notificationConfig.enabled()) {
            return;
        }
        Global$.MODULE$.wowToDiscord().get(new Tuple2<Byte, None$>(BoxesRunTime.boxToByte(this.ChatEvents().CHAT_MSG_GUILD()), None$.MODULE$)).foreach((Function1<Set, Object> & Serializable & scala.Serializable)x$6 -> {
            x$6.foreach((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$1 -> {
                Discord.$anonfun$sendAchievementNotification$2($this, notificationConfig$1, name$1, achievementId$1, x0$1);
                return BoxedUnit.UNIT;
            });
            return BoxedUnit.UNIT;
        });
    }

    @Override
    public void onStatusChange(StatusChangeEvent event) {
        JDA.Status status = event.getNewStatus();
        if (((Object)((Object)JDA.Status.CONNECTED)).equals((Object)status)) {
            BoxedUnit boxedUnit;
            this.lastStatus().foreach((Function1<Activity, Object> & Serializable & scala.Serializable)game -> {
                this.changeStatus(game.getType(), game.getName());
                return BoxedUnit.UNIT;
            });
            Global$.MODULE$.discordToWow().clear();
            Global$.MODULE$.wowToDiscord().clear();
            Global$.MODULE$.guildEventsToDiscord().clear();
            Seq configChannels = Global$.MODULE$.config().channels().map((Function1<ChannelConfig, Tuple2> & Serializable & scala.Serializable)channelConfig -> Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(channelConfig.discord().channel().toLowerCase()), channelConfig), Seq$.MODULE$.canBuildFrom());
            Seq configChannelsNames = configChannels.map((Function1<Tuple2, String> & Serializable & scala.Serializable)x$7 -> (String)x$7._1(), Seq$.MODULE$.canBuildFrom());
            Buffer<TextChannel> discordTextChannels = JavaConverters$.MODULE$.asScalaBufferConverter(event.getEntity().getTextChannels()).asScala();
            Buffer eligibleDiscordChannels = (Buffer)discordTextChannels.filter((Function1<TextChannel, Object> & Serializable & scala.Serializable)channel -> BoxesRunTime.boxToBoolean(Discord.$anonfun$onStatusChange$4(configChannelsNames, channel)));
            eligibleDiscordChannels.foreach((Function1<TextChannel, Object> & Serializable & scala.Serializable)channel -> {
                Discord.$anonfun$onStatusChange$5(configChannels, channel);
                return BoxedUnit.UNIT;
            });
            Map guildEventChannels = ((TraversableLike)Global$.MODULE$.config().guildConfig().notificationConfigs().filter((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$3 -> BoxesRunTime.boxToBoolean(Discord.$anonfun$onStatusChange$9(x0$3)))).flatMap((Function1<Tuple2, Iterable> & Serializable & scala.Serializable)x0$4 -> {
                Tuple2 tuple2 = x0$4;
                if (tuple2 == null) {
                    throw new MatchError(tuple2);
                }
                String key = (String)tuple2._1();
                GuildNotificationConfig notificationConfig = (GuildNotificationConfig)tuple2._2();
                Iterable iterable = Option$.MODULE$.option2Iterable(notificationConfig.channel().map((Function1<String, Tuple2> & Serializable & scala.Serializable)x$9 -> Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(key), x$9)));
                return iterable;
            }, Map$.MODULE$.canBuildFrom());
            discordTextChannels.foreach((Function1<TextChannel, Object> & Serializable & scala.Serializable)channel -> {
                Discord.$anonfun$onStatusChange$12(guildEventChannels, channel);
                return BoxedUnit.UNIT;
            });
            if (Global$.MODULE$.discordToWow().nonEmpty() || Global$.MODULE$.wowToDiscord().nonEmpty()) {
                if (this.firstConnect()) {
                    this.discordConnectionCallback.connected();
                    this.firstConnect_$eq(false);
                    boxedUnit = BoxedUnit.UNIT;
                } else {
                    this.discordConnectionCallback.reconnected();
                    boxedUnit = BoxedUnit.UNIT;
                }
            } else if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("No discord channels configured!");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit2 = boxedUnit;
        } else if (((Object)((Object)JDA.Status.DISCONNECTED)).equals((Object)status)) {
            this.discordConnectionCallback.disconnected();
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        } else {
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        }
    }

    @Override
    public void onShutdown(ShutdownEvent event) {
        CloseCode closeCode = event.getCloseCode();
        if (((Object)((Object)CloseCode.DISALLOWED_INTENTS)).equals((Object)closeCode)) {
            BoxedUnit boxedUnit;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Per new Discord rules, you must check the PRESENCE INTENT, SERVER MEMBERS INTENT, and MESSAGE CONTENT INTENT boxes under \"Privileged Gateway Intents\" for this bot in the developer portal. You can find more info at https://discord.com/developers/docs/topics/gateway#privileged-intents");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            BoxedUnit boxedUnit2 = boxedUnit;
        } else {
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        block10: {
            BoxedUnit boxedUnit;
            BoxedUnit boxedUnit2;
            MessageType messageType;
            if (event.getAuthor().getIdLong() == this.jda().getSelfUser().getIdLong()) {
                return;
            }
            ChannelType channelType = event.getChannelType();
            ChannelType channelType2 = ChannelType.TEXT;
            if (channelType == null ? channelType2 != null : !((Object)((Object)channelType)).equals((Object)channelType2)) {
                return;
            }
            MessageType messageType2 = messageType = event.getMessage().getType();
            MessageType messageType3 = MessageType.DEFAULT;
            if (messageType2 == null ? messageType3 != null : !((Object)((Object)messageType2)).equals((Object)messageType3)) {
                MessageType messageType4 = messageType;
                MessageType messageType5 = MessageType.INLINE_REPLY;
                if (messageType4 == null ? messageType5 != null : !((Object)((Object)messageType4)).equals((Object)messageType5)) {
                    return;
                }
            }
            MessageChannelUnion channel = event.getChannel();
            String channelId = channel.getId();
            String channelName = event.getChannel().getName().toLowerCase();
            String effectiveName = event.getMember().getEffectiveName();
            String string = this.sanitizeMessage(event.getMessage().getContentDisplay());
            String message = ((TraversableOnce)((TraversableLike)((SeqLike)((TraversableLike)JavaConverters$.MODULE$.asScalaBufferConverter(event.getMessage().getAttachments()).asScala()).map((Function1<Message.Attachment, String> & Serializable & scala.Serializable)x$10 -> x$10.getUrl(), Buffer$.MODULE$.canBuildFrom())).$plus$colon(string, Buffer$.MODULE$.canBuildFrom())).filter((Function1<String, Object> & Serializable & scala.Serializable)x$12 -> BoxesRunTime.boxToBoolean(Discord.$anonfun$onMessageReceived$2(x$12)))).mkString(" ");
            scala.collection.immutable.Set<String> enableCommandsChannels = Global$.MODULE$.config().discord().enableCommandsChannels();
            if (this.logger().underlying().isDebugEnabled()) {
                this.logger().underlying().debug("RECV DISCORD MESSAGE: [{}] [{}]: {}", channel.getName(), effectiveName, message);
                boxedUnit2 = BoxedUnit.UNIT;
            } else {
                boxedUnit2 = BoxedUnit.UNIT;
            }
            if (message.isEmpty()) {
                if (this.logger().underlying().isErrorEnabled()) {
                    this.logger().underlying().error("Received a message in channel {} but the content was empty. You likely forgot to enable MESSAGE CONTENT INTENT for your bot in the Discord Developers portal.", new Object[]{channel.getName()});
                    boxedUnit = BoxedUnit.UNIT;
                } else {
                    boxedUnit = BoxedUnit.UNIT;
                }
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            if ((!enableCommandsChannels.nonEmpty() || enableCommandsChannels.contains(channelName)) && CommandHandler$.MODULE$.apply(channel, message)) break block10;
            ((Option)Global$.MODULE$.discordToWow().get(channelName).fold((Function0<Option> & Serializable & scala.Serializable)() -> Global$.MODULE$.discordToWow().get(channelId), (Function1<Set, Some> & Serializable & scala.Serializable)x$13 -> new Some<Set>((Set)x$13))).foreach((Function1<Set, Object> & Serializable & scala.Serializable)x$14 -> {
                x$14.foreach((Function1<WowChannelConfig, Object> & Serializable & scala.Serializable)channelConfig -> {
                    Discord.$anonfun$onMessageReceived$6($this, message$3, effectiveName$1, channelConfig);
                    return BoxedUnit.UNIT;
                });
                return BoxedUnit.UNIT;
            });
        }
    }

    public boolean shouldSendDirectly(String message) {
        DiscordConfig discordConf = Global$.MODULE$.config().discord();
        String trimmed = ((String)new StringOps(Predef$.MODULE$.augmentString(message)).drop(1)).toLowerCase();
        return message.startsWith(".") && discordConf.enableDotCommands() && (discordConf.dotCommandsWhitelist().isEmpty() || discordConf.dotCommandsWhitelist().contains(trimmed) || !discordConf.dotCommandsWhitelist().forall((Function1<String, Object> & Serializable & scala.Serializable)item -> BoxesRunTime.boxToBoolean(Discord.$anonfun$shouldSendDirectly$1(trimmed, item))));
    }

    public boolean shouldFilter(Option<FiltersConfig> filtersConfig, String message) {
        return ((Option)filtersConfig.fold((Function0<Option> & Serializable & scala.Serializable)() -> Global$.MODULE$.config().filters(), (Function1<FiltersConfig, Some> & Serializable & scala.Serializable)x$15 -> new Some<FiltersConfig>((FiltersConfig)x$15))).exists((Function1<FiltersConfig, Object> & Serializable & scala.Serializable)filters -> BoxesRunTime.boxToBoolean(Discord.$anonfun$shouldFilter$3(message, filters)));
    }

    public String sanitizeMessage(String message) {
        return EmojiParser.parseToAliases(message, EmojiParser.FitzpatrickAction.REMOVE);
    }

    public Seq<String> splitUpMessage(String format, String name, String message2) {
        ArrayBuffer retArr = (ArrayBuffer)ArrayBuffer$.MODULE$.empty();
        int maxTmpLen = 255 - format.replace("%time", Global$.MODULE$.getTime()).replace("%user", name).replace("%message", "").length();
        String tmp = message2;
        while (tmp.length() > maxTmpLen) {
            String string;
            String subStr = tmp.substring(0, maxTmpLen);
            int spaceIndex = subStr.lastIndexOf(32);
            if (spaceIndex == -1) {
                retArr.$plus$eq(subStr);
                string = tmp.substring(maxTmpLen);
            } else {
                retArr.$plus$eq(subStr.substring(0, spaceIndex));
                string = tmp.substring(spaceIndex + 1);
            }
            tmp = string;
        }
        Object object = new StringOps(Predef$.MODULE$.augmentString(tmp)).nonEmpty() ? retArr.$plus$eq(tmp) : BoxedUnit.UNIT;
        return retArr.map((Function1<String, String> & Serializable & scala.Serializable)message -> {
            void var3_3;
            String formatted = format.replace("%time", Global$.MODULE$.getTime()).replace("%user", name).replace("%message", (CharSequence)message);
            return formatted.startsWith(".") ? new StringBuilder(1).append(" ").append(formatted).toString() : var3_3;
        }, ArrayBuffer$.MODULE$.canBuildFrom());
    }

    private final void ChatEvents$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.ChatEvents$module == null) {
                this.ChatEvents$module = new GamePackets$ChatEvents$(this);
            }
        }
    }

    private final void GuildEvents$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.GuildEvents$module == null) {
                this.GuildEvents$module = new GamePackets$GuildEvents$(this);
            }
        }
    }

    private final void Races$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.Races$module == null) {
                this.Races$module = new GamePackets$Races$(this);
            }
        }
    }

    private final void Classes$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.Classes$module == null) {
                this.Classes$module = new GamePackets$Classes$(this);
            }
        }
    }

    private final void Genders$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.Genders$module == null) {
                this.Genders$module = new GamePackets$Genders$(this);
            }
        }
    }

    private final void AuthResponseCodes$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.AuthResponseCodes$module == null) {
                this.AuthResponseCodes$module = new GamePackets$AuthResponseCodes$(this);
            }
        }
    }

    private final void ChatNotify$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.ChatNotify$module == null) {
                this.ChatNotify$module = new GamePackets$ChatNotify$(this);
            }
        }
    }

    private final void ServerMessageType$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.ServerMessageType$module == null) {
                this.ServerMessageType$module = new GamePackets$ServerMessageType$(this);
            }
        }
    }

    private final void ChatChannelIds$lzycompute$1() {
        Discord discord = this;
        synchronized (discord) {
            if (this.ChatChannelIds$module == null) {
                this.ChatChannelIds$module = new GamePackets$ChatChannelIds$(this);
            }
        }
    }

    public static final /* synthetic */ void $anonfun$sendMessageFromWow$9(Discord $this, Option from$1, TextChannel channel$1, String error) {
        Global$.MODULE$.game().foreach((Function1<GameCommandHandler, Object> & Serializable & scala.Serializable)x$4 -> {
            x$4.sendMessageToWow($this.ChatEvents().CHAT_MSG_WHISPER(), error, from$1);
            return BoxedUnit.UNIT;
        });
        channel$1.sendMessage(error).queue();
    }

    public static final /* synthetic */ void $anonfun$sendMessageFromWow$3(Discord $this, Option from$1, String parsedLinks$1, Option wowChannel$1, Tuple2 x0$1) {
        BoxedUnit boxedUnit;
        Tuple2 tuple2 = x0$1;
        if (tuple2 != null) {
            BoxedUnit boxedUnit2;
            TextChannel channel = (TextChannel)tuple2._1();
            DiscordChannelConfig channelConfig = (DiscordChannelConfig)tuple2._2();
            ArrayBuffer errors = (ArrayBuffer)ArrayBuffer$.MODULE$.empty();
            String parsedResolvedTags = ((String)from$1.map((Function1<String, String> & Serializable & scala.Serializable)x$2 -> $this.messageResolver().resolveTags(channel, parsedLinks$1.replace("{?", ""), (Function1<String, BoxedUnit>)(Function1<String, Object> & Serializable & scala.Serializable)x$3 -> {
                errors.$plus$eq(x$3);
                return BoxedUnit.UNIT;
            })).getOrElse((Function0<String> & Serializable & scala.Serializable)() -> parsedLinks$1)).replace("`", "\\`").replace("*", "\\*").replace("_", "\\_").replace("~", "\\~");
            String formatted = channelConfig.format().replace("%time", Global$.MODULE$.getTime()).replace("%user", (CharSequence)from$1.getOrElse((Function0<String> & Serializable & scala.Serializable)() -> "")).replace("%message", parsedResolvedTags).replace("%target", (CharSequence)wowChannel$1.getOrElse((Function0<String> & Serializable & scala.Serializable)() -> ""));
            boolean filter = $this.shouldFilter(channelConfig.filters(), formatted);
            if ($this.logger().underlying().isInfoEnabled()) {
                $this.logger().underlying().info("{}WoW->Discord({}) {}", filter ? "FILTERED " : "", channel.getName(), formatted);
                boxedUnit2 = BoxedUnit.UNIT;
            } else {
                boxedUnit2 = BoxedUnit.UNIT;
            }
            if (!filter) {
                channel.sendMessage(formatted).queue();
            }
            if (Global$.MODULE$.config().discord().enableTagFailedNotifications()) {
                errors.foreach((Function1<String, Object> & Serializable & scala.Serializable)error -> {
                    Discord.$anonfun$sendMessageFromWow$9($this, from$1, channel, error);
                    return BoxedUnit.UNIT;
                });
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
        } else {
            throw new MatchError(tuple2);
        }
        BoxedUnit boxedUnit3 = boxedUnit;
    }

    public static final /* synthetic */ void $anonfun$sendMessageFromWow$2(Discord $this, String message$1, Option from$1, Option wowChannel$1, Set discordChannels) {
        String parsedLinks = $this.messageResolver().resolveEmojis($this.messageResolver().stripColorCoding($this.messageResolver().resolveLinks(message$1)));
        discordChannels.foreach((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$1 -> {
            Discord.$anonfun$sendMessageFromWow$3($this, from$1, parsedLinks, wowChannel$1, x0$1);
            return BoxedUnit.UNIT;
        });
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ void $anonfun$sendGuildNotification$4(Discord discord, String string, TextChannel textChannel) {
        BoxedUnit boxedUnit;
        void message$2;
        void channel;
        Discord $this;
        if (discord.shouldFilter(Global$.MODULE$.config().filters(), string)) {
            return;
        }
        if ($this.logger().underlying().isInfoEnabled()) {
            $this.logger().underlying().info("WoW->Discord({}) {}", new Object[]{channel.getName(), message$2});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        channel.sendMessage((CharSequence)message$2).queue();
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ void $anonfun$sendAchievementNotification$2(Discord $this, GuildNotificationConfig notificationConfig$1, String name$1, int achievementId$1, Tuple2 x0$1) {
        void formatted;
        TextChannel discordChannel;
        Tuple2 tuple2 = x0$1;
        if (tuple2 != null) {
            discordChannel = (TextChannel)tuple2._1();
            String string = notificationConfig$1.format().replace("%time", Global$.MODULE$.getTime()).replace("%user", name$1).replace("%achievement", $this.messageResolver().resolveAchievementId(achievementId$1));
            if ($this.shouldFilter(Global$.MODULE$.config().filters(), string)) {
                return;
            }
        } else {
            throw new MatchError(tuple2);
        }
        discordChannel.sendMessage((CharSequence)formatted).queue();
        BoxedUnit boxedUnit = BoxedUnit.UNIT;
    }

    public static final /* synthetic */ boolean $anonfun$onStatusChange$4(Seq configChannelsNames$1, TextChannel channel) {
        return configChannelsNames$1.contains(channel.getName().toLowerCase()) || configChannelsNames$1.contains(channel.getId());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ boolean $anonfun$onStatusChange$6(TextChannel channel$2, Tuple2 x0$1) {
        Tuple2 tuple2 = x0$1;
        if (tuple2 == null) throw new MatchError(tuple2);
        String name = (String)tuple2._1();
        if (name.equalsIgnoreCase(channel$2.getName())) return true;
        String string = name;
        String string2 = channel$2.getId();
        if (string != null) {
            if (!string.equals(string2)) return false;
            return true;
        }
        if (string2 == null) return true;
        return false;
    }

    public static final /* synthetic */ String $anonfun$onStatusChange$8(String x$8) {
        return x$8.toLowerCase();
    }

    /*
     * Unable to fully structure code
     */
    public static final /* synthetic */ Object $anonfun$onStatusChange$7(TextChannel channel$2, Tuple2 x0$2) {
        block5: {
            block4: {
                var3_2 = x0$2;
                if (var3_2 == null) break block4;
                name = (String)var3_2._1();
                channelConfig = (ChannelConfig)var3_2._2();
                v0 = channelConfig.chatDirection();
                var6_5 = ChatDirection$.MODULE$.both();
                if (!(v0 == null ? var6_5 != null : v0.equals(var6_5) == false)) ** GOTO lbl-1000
                v1 = channelConfig.chatDirection();
                var7_6 = ChatDirection$.MODULE$.discord_to_wow();
                if (!(v1 != null ? v1.equals(var7_6) == false : var7_6 != null)) lbl-1000:
                // 2 sources

                {
                    v2 = ((MultiMap)Global$.MODULE$.discordToWow()).addBinding(name.toLowerCase(), channelConfig.wow());
                } else {
                    v2 = BoxedUnit.UNIT;
                }
                v3 = channelConfig.chatDirection();
                var8_7 = ChatDirection$.MODULE$.both();
                if (!(v3 == null ? var8_7 != null : v3.equals(var8_7) == false)) ** GOTO lbl-1000
                v4 = channelConfig.chatDirection();
                var9_8 = ChatDirection$.MODULE$.wow_to_discord();
                if (!(v4 != null ? v4.equals(var9_8) == false : var9_8 != null)) lbl-1000:
                // 2 sources

                {
                    v5 = ((MultiMap)Global$.MODULE$.wowToDiscord()).addBinding(new Tuple2<Byte, Option<B>>(BoxesRunTime.boxToByte(channelConfig.wow().tp()), channelConfig.wow().channel().map((Function1<String, String> & Serializable & scala.Serializable)LambdaMetafactory.altMetafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, $anonfun$onStatusChange$8(java.lang.String ), (Ljava/lang/String;)Ljava/lang/String;)())), new Tuple2<TextChannel, DiscordChannelConfig>(channel$2, channelConfig.discord()));
                } else {
                    v5 = BoxedUnit.UNIT;
                }
                break block5;
            }
            throw new MatchError(var3_2);
        }
        var2_9 = v5;
        return var2_9;
    }

    public static final /* synthetic */ void $anonfun$onStatusChange$5(Seq configChannels$1, TextChannel channel) {
        ((IterableLike)configChannels$1.filter((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$1 -> BoxesRunTime.boxToBoolean(Discord.$anonfun$onStatusChange$6(channel, x0$1)))).foreach(arg_0 -> Discord.$anonfun$onStatusChange$7(channel, arg_0));
    }

    public static final /* synthetic */ boolean $anonfun$onStatusChange$9(Tuple2 x0$3) {
        Tuple2 tuple2 = x0$3;
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        GuildNotificationConfig notificationConfig = (GuildNotificationConfig)tuple2._2();
        boolean bl = notificationConfig.enabled();
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ boolean $anonfun$onStatusChange$13(TextChannel channel$3, Tuple2 x0$5) {
        Tuple2 tuple2 = x0$5;
        if (tuple2 == null) throw new MatchError(tuple2);
        String name = (String)tuple2._2();
        if (name.equalsIgnoreCase(channel$3.getName())) return true;
        String string = name;
        String string2 = channel$3.getId();
        if (string != null) {
            if (!string.equals(string2)) return false;
            return true;
        }
        if (string2 == null) return true;
        return false;
    }

    public static final /* synthetic */ void $anonfun$onStatusChange$12(Map guildEventChannels$1, TextChannel channel) {
        ((IterableLike)guildEventChannels$1.filter((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$5 -> BoxesRunTime.boxToBoolean(Discord.$anonfun$onStatusChange$13(channel, x0$5)))).foreach((Function1<Tuple2, HashMap> & Serializable & scala.Serializable)x0$6 -> {
            Tuple2 tuple2 = x0$6;
            if (tuple2 == null) {
                throw new MatchError(tuple2);
            }
            String notificationKey = (String)tuple2._1();
            HashMap hashMap = (HashMap)((Object)((MultiMap)((Object)Global$.MODULE$.guildEventsToDiscord())).addBinding(notificationKey, channel));
            return hashMap;
        });
    }

    public static final /* synthetic */ boolean $anonfun$onMessageReceived$2(String x$12) {
        return new StringOps(Predef$.MODULE$.augmentString(x$12)).nonEmpty();
    }

    public static final /* synthetic */ void $anonfun$onMessageReceived$7(Discord $this, WowChannelConfig channelConfig$1, String finalMessage) {
        block2: {
            BoxedUnit boxedUnit;
            boolean filter = $this.shouldFilter(channelConfig$1.filters(), finalMessage);
            if ($this.logger().underlying().isInfoEnabled()) {
                $this.logger().underlying().info("{}Discord->WoW({}) {}", filter ? "FILTERED " : "", channelConfig$1.channel().getOrElse((Function0<String> & Serializable & scala.Serializable)() -> $this.ChatEvents().valueOf(channelConfig$1.tp())), finalMessage);
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            if (filter) break block2;
            Global$.MODULE$.game().fold((JFunction0$mcV$sp & scala.Serializable)() -> {
                BoxedUnit boxedUnit;
                if ($this.logger().underlying().isErrorEnabled()) {
                    $this.logger().underlying().error("Cannot send message! Not connected to WoW!");
                    boxedUnit = BoxedUnit.UNIT;
                } else {
                    boxedUnit = BoxedUnit.UNIT;
                }
            }, (Function1<GameCommandHandler, Object> & Serializable & scala.Serializable)handler -> {
                handler.sendMessageToWow(channelConfig$1.tp(), finalMessage, channelConfig$1.channel());
                return BoxedUnit.UNIT;
            });
        }
    }

    public static final /* synthetic */ void $anonfun$onMessageReceived$6(Discord $this, String message$3, String effectiveName$1, WowChannelConfig channelConfig) {
        Seq<String> finalMessages = $this.shouldSendDirectly(message$3) ? (Seq<String>)new $colon$colon<Nothing$>((Nothing$)((Object)message$3), Nil$.MODULE$) : $this.splitUpMessage(channelConfig.format(), effectiveName$1, message$3);
        finalMessages.foreach((Function1<String, Object> & Serializable & scala.Serializable)finalMessage -> {
            Discord.$anonfun$onMessageReceived$7($this, channelConfig, finalMessage);
            return BoxedUnit.UNIT;
        });
    }

    public static final /* synthetic */ boolean $anonfun$shouldSendDirectly$1(String trimmed$1, String item) {
        return item.endsWith("*") ? !trimmed$1.startsWith(((String)new StringOps(Predef$.MODULE$.augmentString(item)).dropRight(1)).toLowerCase()) : true;
    }

    public static final /* synthetic */ boolean $anonfun$shouldFilter$3(String message$4, FiltersConfig filters) {
        return filters.enabled() && filters.patterns().exists((Function1<String, Object> & Serializable & scala.Serializable)x$1 -> BoxesRunTime.boxToBoolean(message$4.matches(x$1)));
    }

    public Discord(CommonConnectionCallback discordConnectionCallback) {
        this.discordConnectionCallback = discordConnectionCallback;
        GamePackets.$init$(this);
        StrictLogging.$init$(this);
        this.jda = JDABuilder.createDefault(Global$.MODULE$.config().discord().token(), GatewayIntent.GUILD_EXPRESSIONS, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.MESSAGE_CONTENT).setMemberCachePolicy(MemberCachePolicy.ALL).disableCache(CacheFlag.SCHEDULED_EVENTS, CacheFlag.VOICE_STATE).addEventListeners(this).build();
        this.messageResolver = MessageResolver$.MODULE$.apply(this.jda());
        this.lastStatus = None$.MODULE$;
        this.firstConnect = true;
    }
}

