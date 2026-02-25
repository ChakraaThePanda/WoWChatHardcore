/*
 * Decompiled with CFR 0.152.
 */
package wowchat.discord;

import net.dv8tion.jda.api.JDA;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;
import scala.util.matching.Regex;
import wowchat.discord.MessageResolverCataclysm;

@ScalaSignature(bytes="\u0006\u0001\u00113Aa\u0002\u0005\u0001\u001b!A!\u0003\u0001B\u0001B\u0003%1\u0003C\u0003\u001f\u0001\u0011\u0005q\u0004C\u0004#\u0001\t\u0007I\u0011K\u0012\t\r\u0001\u0003\u0001\u0015!\u0003%\u0011\u001d\t\u0005A1A\u0005R\tCaa\u0011\u0001!\u0002\u0013\u0001$AE'fgN\fw-\u001a*fg>dg/\u001a:N_BS!!\u0003\u0006\u0002\u000f\u0011L7oY8sI*\t1\"A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M\u0011\u0001A\u0004\t\u0003\u001fAi\u0011\u0001C\u0005\u0003#!\u0011\u0001$T3tg\u0006<WMU3t_24XM]\"bi\u0006\u001cG._:n\u0003\rQG-\u0019\t\u0003)qi\u0011!\u0006\u0006\u0003-]\t1!\u00199j\u0015\t\u0011\u0002D\u0003\u0002\u001a5\u00059AM\u001e\u001duS>t'\"A\u000e\u0002\u00079,G/\u0003\u0002\u001e+\t\u0019!\nR!\u0002\rqJg.\u001b;?)\t\u0001\u0013\u0005\u0005\u0002\u0010\u0001!)!C\u0001a\u0001'\u0005YA.\u001b8l%\u0016<W\r_3t+\u0005!\u0003cA\u0013+Y5\taE\u0003\u0002(Q\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003%\nQa]2bY\u0006L!a\u000b\u0014\u0003\u0007M+\u0017\u000f\u0005\u0003.]ABT\"\u0001\u0015\n\u0005=B#A\u0002+va2,'\u0007\u0005\u00022m5\t!G\u0003\u00024i\u0005!A.\u00198h\u0015\u0005)\u0014\u0001\u00026bm\u0006L!a\u000e\u001a\u0003\rM#(/\u001b8h!\tId(D\u0001;\u0015\tYD(\u0001\u0005nCR\u001c\u0007.\u001b8h\u0015\ti\u0004&\u0001\u0003vi&d\u0017BA ;\u0005\u0015\u0011VmZ3y\u00031a\u0017N\\6SK\u001e,\u00070Z:!\u0003=!WMZ1vYRd\u0015N\\6TSR,W#\u0001\u0019\u0002!\u0011,g-Y;mi2Kgn[*ji\u0016\u0004\u0003")
public class MessageResolverMoP
extends MessageResolverCataclysm {
    private final Seq<Tuple2<String, Regex>> linkRegexes = new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("item"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hitem:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("spell"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|(?:Hspell|Henchant|Htalent)?:(\\d+).*?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("quest"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hquest:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("achievement"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hachievement:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("spell"), new StringOps(Predef$.MODULE$.augmentString("\\|Htrade:.+?:(\\d+):.+?\\|h\\[(.+?)]\\|h")).r())), Nil$.MODULE$)))));
    private final String defaultLinkSite;

    @Override
    public Seq<Tuple2<String, Regex>> linkRegexes() {
        return this.linkRegexes;
    }

    @Override
    public String defaultLinkSite() {
        return this.defaultLinkSite;
    }

    public MessageResolverMoP(JDA jda) {
        super(jda);
        this.defaultLinkSite = "http://mop-shoot.tauri.hu";
    }
}

