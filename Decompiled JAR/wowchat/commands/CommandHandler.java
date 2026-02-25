/*
 * Decompiled with CFR 0.152.
 */
package wowchat.commands;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import scala.Function1;
import scala.Option;
import scala.collection.Iterable;
import scala.collection.mutable.Map;
import scala.reflect.ScalaSignature;
import wowchat.commands.CommandHandler$;
import wowchat.commands.WhoRequest;
import wowchat.commands.WhoResponse;
import wowchat.game.GuildInfo;
import wowchat.game.GuildMember;

@ScalaSignature(bytes="\u0006\u0001\u0005=r!\u0002\u0007\u000e\u0011\u0003\u0011b!\u0002\u000b\u000e\u0011\u0003)\u0002\"\u0002\u0014\u0002\t\u00039\u0003b\u0002\u0015\u0002\u0005\u0004%I!\u000b\u0005\u0007e\u0005\u0001\u000b\u0011\u0002\u0016\t\u000fM\n!\u0019!C\u0005S!1A'\u0001Q\u0001\n)B\u0011\"N\u0001A\u0002\u0003\u0007I\u0011\u0001\u001c\t\u0013i\n\u0001\u0019!a\u0001\n\u0003Y\u0004\"C!\u0002\u0001\u0004\u0005\t\u0015)\u00038\u0011\u0015\u0011\u0015\u0001\"\u0001D\u0011\u00159\u0017\u0001\"\u0001i\u00039\u0019u.\\7b]\u0012D\u0015M\u001c3mKJT!AD\b\u0002\u0011\r|W.\\1oINT\u0011\u0001E\u0001\bo><8\r[1u\u0007\u0001\u0001\"aE\u0001\u000e\u00035\u0011abQ8n[\u0006tG\rS1oI2,'oE\u0002\u0002-q\u0001\"a\u0006\u000e\u000e\u0003aQ\u0011!G\u0001\u0006g\u000e\fG.Y\u0005\u00037a\u0011a!\u00118z%\u00164\u0007CA\u000f%\u001b\u0005q\"BA\u0010!\u00031\u00198-\u00197bY><w-\u001b8h\u0015\t\t#%\u0001\u0005usB,7/\u00194f\u0015\u0005\u0019\u0013aA2p[&\u0011QE\b\u0002\u000e'R\u0014\u0018n\u0019;M_\u001e<\u0017N\\4\u0002\rqJg.\u001b;?)\u0005\u0011\u0012A\u0003(P)~{e\nT%O\u000bV\t!\u0006\u0005\u0002,a5\tAF\u0003\u0002.]\u0005!A.\u00198h\u0015\u0005y\u0013\u0001\u00026bm\u0006L!!\r\u0017\u0003\rM#(/\u001b8h\u0003-qu\nV0P\u001d2Ke*\u0012\u0011\u0002\u000fQ\u0014\u0018nZ4fe\u0006AAO]5hO\u0016\u0014\b%\u0001\u0006xQ>\u0014V-];fgR,\u0012a\u000e\t\u0003'aJ!!O\u0007\u0003\u0015]CwNU3rk\u0016\u001cH/\u0001\bxQ>\u0014V-];fgR|F%Z9\u0015\u0005qz\u0004CA\f>\u0013\tq\u0004D\u0001\u0003V]&$\bb\u0002!\t\u0003\u0003\u0005\raN\u0001\u0004q\u0012\n\u0014aC<i_J+\u0017/^3ti\u0002\nQ!\u00199qYf$2\u0001R$\\!\t9R)\u0003\u0002G1\t9!i\\8mK\u0006t\u0007\"\u0002%\u000b\u0001\u0004I\u0015a\u00034s_6\u001c\u0005.\u00198oK2\u0004\"AS-\u000e\u0003-S!\u0001T'\u0002\u00135LG\r\u001a7f[\u0006t'B\u0001(P\u0003\u001d\u0019\u0007.\u00198oK2T!\u0001U)\u0002\u0011\u0015tG/\u001b;jKNT!AU*\u0002\u0007\u0005\u0004\u0018N\u0003\u0002U+\u0006\u0019!\u000eZ1\u000b\u0005Y;\u0016a\u00023wqQLwN\u001c\u0006\u00021\u0006\u0019a.\u001a;\n\u0005i[%AD'fgN\fw-Z\"iC:tW\r\u001c\u0005\u00069*\u0001\r!X\u0001\b[\u0016\u001c8/Y4f!\tqVM\u0004\u0002`GB\u0011\u0001\rG\u0007\u0002C*\u0011!-E\u0001\u0007yI|w\u000e\u001e \n\u0005\u0011D\u0012A\u0002)sK\u0012,g-\u0003\u00022M*\u0011A\rG\u0001\u0012Q\u0006tG\r\\3XQ>\u0014Vm\u001d9p]N,GcB5su\u0006\u0015\u0011Q\u0005\t\u0004U>lfBA6n\u001d\t\u0001G.C\u0001\u001a\u0013\tq\u0007$A\u0004qC\u000e\\\u0017mZ3\n\u0005A\f(\u0001C%uKJ\f'\r\\3\u000b\u00059D\u0002\"B:\f\u0001\u0004!\u0018aC<i_J+7\u000f]8og\u0016\u00042aF;x\u0013\t1\bD\u0001\u0004PaRLwN\u001c\t\u0003'aL!!_\u0007\u0003\u0017]CwNU3ta>t7/\u001a\u0005\u0006w.\u0001\r\u0001`\u0001\nOVLG\u000eZ%oM>\u00042!`A\u0001\u001b\u0005q(BA@\u0010\u0003\u00119\u0017-\\3\n\u0007\u0005\raPA\u0005Hk&dG-\u00138g_\"9\u0011qA\u0006A\u0002\u0005%\u0011aC4vS2$'k\\:uKJ\u0004\u0002\"a\u0003\u0002\u0016\u0005e\u0011qD\u0007\u0003\u0003\u001bQA!a\u0004\u0002\u0012\u00059Q.\u001e;bE2,'bAA\n1\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\t\u0005]\u0011Q\u0002\u0002\u0004\u001b\u0006\u0004\bcA\f\u0002\u001c%\u0019\u0011Q\u0004\r\u0003\t1{gn\u001a\t\u0004{\u0006\u0005\u0012bAA\u0012}\nYq)^5mI6+WNY3s\u0011\u001d\t9c\u0003a\u0001\u0003S\tacZ;jY\u0012\u0014vn\u001d;fe6\u000bGo\u00195fe\u001a+hn\u0019\t\u0007/\u0005-\u0012q\u0004#\n\u0007\u00055\u0002DA\u0005Gk:\u001cG/[8oc\u0001")
public final class CommandHandler {
    public static Iterable<String> handleWhoResponse(Option<WhoResponse> option, GuildInfo guildInfo, Map<Object, GuildMember> map, Function1<GuildMember, Object> function1) {
        return CommandHandler$.MODULE$.handleWhoResponse(option, guildInfo, map, function1);
    }

    public static boolean apply(MessageChannel messageChannel, String string) {
        return CommandHandler$.MODULE$.apply(messageChannel, string);
    }

    public static void whoRequest_$eq(WhoRequest whoRequest) {
        CommandHandler$.MODULE$.whoRequest_$eq(whoRequest);
    }

    public static WhoRequest whoRequest() {
        return CommandHandler$.MODULE$.whoRequest();
    }
}

