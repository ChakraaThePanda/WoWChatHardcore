/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import io.netty.channel.EventLoopGroup;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import scala.Option;
import scala.Tuple2;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.Set;
import scala.reflect.ScalaSignature;
import wowchat.common.DiscordChannelConfig;
import wowchat.common.Global$;
import wowchat.common.WowChannelConfig;
import wowchat.common.WowChatConfig;
import wowchat.discord.Discord;
import wowchat.game.GameCommandHandler;

@ScalaSignature(bytes="\u0006\u0001\u0005us!\u0002\f\u0018\u0011\u0003ab!\u0002\u0010\u0018\u0011\u0003y\u0002\"\u0002\u0014\u0002\t\u00039\u0003\"\u0003\u0015\u0002\u0001\u0004\u0005\r\u0011\"\u0001*\u0011%!\u0014\u00011AA\u0002\u0013\u0005Q\u0007C\u0005<\u0003\u0001\u0007\t\u0011)Q\u0005U!IA(\u0001a\u0001\u0002\u0004%\t!\u0010\u0005\n\u0003\u0006\u0001\r\u00111A\u0005\u0002\tC\u0011\u0002R\u0001A\u0002\u0003\u0005\u000b\u0015\u0002 \t\u0013\u0015\u000b\u0001\u0019!a\u0001\n\u00031\u0005\"\u0003'\u0002\u0001\u0004\u0005\r\u0011\"\u0001N\u0011%y\u0015\u00011A\u0001B\u0003&q\tC\u0004Q\u0003\u0001\u0007I\u0011A)\t\u000fi\u000b\u0001\u0019!C\u00017\"1Q,\u0001Q!\nICqAX\u0001C\u0002\u0013\u0005q\f\u0003\u0004d\u0003\u0001\u0006I\u0001\u0019\u0005\n\u0003\u0003\t!\u0019!C\u0001\u0003\u0007A\u0001\"!\u0003\u0002A\u0003%\u0011Q\u0001\u0005\n\u0003\u0013\n!\u0019!C\u0001\u0003\u0017B\u0001\"!\u0015\u0002A\u0003%\u0011Q\n\u0005\b\u00033\nA\u0011AA.\u0003\u00199En\u001c2bY*\u0011\u0001$G\u0001\u0007G>lWn\u001c8\u000b\u0003i\tqa^8xG\"\fGo\u0001\u0001\u0011\u0005u\tQ\"A\f\u0003\r\u001dcwNY1m'\t\t\u0001\u0005\u0005\u0002\"I5\t!EC\u0001$\u0003\u0015\u00198-\u00197b\u0013\t)#E\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003q\tQa\u001a:pkB,\u0012A\u000b\t\u0003WIj\u0011\u0001\f\u0006\u0003[9\nqa\u00195b]:,GN\u0003\u00020a\u0005)a.\u001a;us*\t\u0011'\u0001\u0002j_&\u00111\u0007\f\u0002\u000f\u000bZ,g\u000e\u001e'p_B<%o\\;q\u0003%9'o\\;q?\u0012*\u0017\u000f\u0006\u00027sA\u0011\u0011eN\u0005\u0003q\t\u0012A!\u00168ji\"9!\bBA\u0001\u0002\u0004Q\u0013a\u0001=%c\u00051qM]8va\u0002\naaY8oM&<W#\u0001 \u0011\u0005uy\u0014B\u0001!\u0018\u000559vn^\"iCR\u001cuN\u001c4jO\u0006Q1m\u001c8gS\u001e|F%Z9\u0015\u0005Y\u001a\u0005b\u0002\u001e\b\u0003\u0003\u0005\rAP\u0001\bG>tg-[4!\u0003\u001d!\u0017n]2pe\u0012,\u0012a\u0012\t\u0003\u0011*k\u0011!\u0013\u0006\u0003\u000bfI!aS%\u0003\u000f\u0011K7oY8sI\u0006YA-[:d_J$w\fJ3r)\t1d\nC\u0004;\u0015\u0005\u0005\t\u0019A$\u0002\u0011\u0011L7oY8sI\u0002\nAaZ1nKV\t!\u000bE\u0002\"'VK!\u0001\u0016\u0012\u0003\r=\u0003H/[8o!\t1\u0006,D\u0001X\u0015\t\u0001\u0016$\u0003\u0002Z/\n\u0011r)Y7f\u0007>lW.\u00198e\u0011\u0006tG\r\\3s\u0003!9\u0017-\\3`I\u0015\fHC\u0001\u001c]\u0011\u001dQT\"!AA\u0002I\u000bQaZ1nK\u0002\nA\u0002Z5tG>\u0014H\rV8X_^,\u0012\u0001\u0019\n\u0004C\u0012lh\u0001\u00022\u0011\u0001\u0001\u0014A\u0002\u0010:fM&tW-\\3oiz\nQ\u0002Z5tG>\u0014H\rV8X_^\u0004\u0003\u0003B3kY^l\u0011A\u001a\u0006\u0003O\"\fq!\\;uC\ndWM\u0003\u0002jE\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005-4'a\u0002%bg\"l\u0015\r\u001d\t\u0003[Rt!A\u001c:\u0011\u0005=\u0014S\"\u00019\u000b\u0005E\\\u0012A\u0002\u001fs_>$h(\u0003\u0002tE\u00051\u0001K]3eK\u001aL!!\u001e<\u0003\rM#(/\u001b8h\u0015\t\u0019(\u0005E\u0002fqjL!!\u001f4\u0003\u0007M+G\u000f\u0005\u0002\u001ew&\u0011Ap\u0006\u0002\u0011/><8\t[1o]\u0016d7i\u001c8gS\u001e\u0004B!\u001a@mu&\u0011qP\u001a\u0002\t\u001bVdG/['ba\u0006aqo\\<U_\u0012K7oY8sIV\u0011\u0011Q\u0001\n\u0007\u0003\u000f\tY!a\u0012\u0007\u000b\t\u0014\u0002!!\u0002\u0002\u001b]|w\u000fV8ESN\u001cwN\u001d3!!\u0019)'.!\u0004\u0002\u001cA9\u0011%a\u0004\u0002\u0014\u0005e\u0011bAA\tE\t1A+\u001e9mKJ\u00022!IA\u000b\u0013\r\t9B\t\u0002\u0005\u0005f$X\rE\u0002\"'2\u0004B!\u001a=\u0002\u001eA9\u0011%a\u0004\u0002 \u0005\u0005\u0003\u0003BA\u0011\u0003{i!!a\t\u000b\t\u0005\u0015\u0012qE\u0001\tG>t7M]3uK*\u0019Q&!\u000b\u000b\t\u0005-\u0012QF\u0001\tK:$\u0018\u000e^5fg*!\u0011qFA\u0019\u0003\r\t\u0007/\u001b\u0006\u0005\u0003g\t)$A\u0002kI\u0006TA!a\u000e\u0002:\u00059AM\u001e\u001duS>t'BAA\u001e\u0003\rqW\r^\u0005\u0005\u0003\u007f\t\u0019CA\u0006UKb$8\t[1o]\u0016d\u0007cA\u000f\u0002D%\u0019\u0011QI\f\u0003)\u0011K7oY8sI\u000eC\u0017M\u001c8fY\u000e{gNZ5h!\u0019)g0!\u0004\u0002\u001e\u0005!r-^5mI\u00163XM\u001c;t)>$\u0015n]2pe\u0012,\"!!\u0014\u0013\r\u0005=\u00131KA,\r\u0015\u0011G\u0003AA'\u0003U9W/\u001b7e\u000bZ,g\u000e^:U_\u0012K7oY8sI\u0002\u0002R!\u001a6m\u0003+\u0002B!\u001a=\u0002 A)QM 7\u0002 \u00059q-\u001a;US6,W#\u00017")
public final class Global {
    public static String getTime() {
        return Global$.MODULE$.getTime();
    }

    public static HashMap<String, Set<TextChannel>> guildEventsToDiscord() {
        return Global$.MODULE$.guildEventsToDiscord();
    }

    public static HashMap<Tuple2<Object, Option<String>>, Set<Tuple2<TextChannel, DiscordChannelConfig>>> wowToDiscord() {
        return Global$.MODULE$.wowToDiscord();
    }

    public static HashMap<String, Set<WowChannelConfig>> discordToWow() {
        return Global$.MODULE$.discordToWow();
    }

    public static void game_$eq(Option<GameCommandHandler> option) {
        Global$.MODULE$.game_$eq(option);
    }

    public static Option<GameCommandHandler> game() {
        return Global$.MODULE$.game();
    }

    public static void discord_$eq(Discord discord) {
        Global$.MODULE$.discord_$eq(discord);
    }

    public static Discord discord() {
        return Global$.MODULE$.discord();
    }

    public static void config_$eq(WowChatConfig wowChatConfig) {
        Global$.MODULE$.config_$eq(wowChatConfig);
    }

    public static WowChatConfig config() {
        return Global$.MODULE$.config();
    }

    public static void group_$eq(EventLoopGroup eventLoopGroup) {
        Global$.MODULE$.group_$eq(eventLoopGroup);
    }

    public static EventLoopGroup group() {
        return Global$.MODULE$.group();
    }
}

