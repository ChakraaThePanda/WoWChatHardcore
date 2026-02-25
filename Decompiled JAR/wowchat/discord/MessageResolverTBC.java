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
import wowchat.discord.MessageResolver;

@ScalaSignature(bytes="\u0006\u0001\u00113Aa\u0002\u0005\u0001\u001b!A!\u0003\u0001B\u0001B\u0003%1\u0003C\u0003\u001f\u0001\u0011\u0005q\u0004C\u0004#\u0001\t\u0007I\u0011K\u0012\t\r\u0001\u0003\u0001\u0015!\u0003%\u0011\u001d\t\u0005A1A\u0005R\tCaa\u0011\u0001!\u0002\u0013\u0001$AE'fgN\fw-\u001a*fg>dg/\u001a:U\u0005\u000eS!!\u0003\u0006\u0002\u000f\u0011L7oY8sI*\t1\"A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M\u0011\u0001A\u0004\t\u0003\u001fAi\u0011\u0001C\u0005\u0003#!\u0011q\"T3tg\u0006<WMU3t_24XM]\u0001\u0004U\u0012\f\u0007C\u0001\u000b\u001d\u001b\u0005)\"B\u0001\f\u0018\u0003\r\t\u0007/\u001b\u0006\u0003%aQ!!\u0007\u000e\u0002\u000f\u00114\b\b^5p]*\t1$A\u0002oKRL!!H\u000b\u0003\u0007)#\u0015)\u0001\u0004=S:LGO\u0010\u000b\u0003A\u0005\u0002\"a\u0004\u0001\t\u000bI\u0011\u0001\u0019A\n\u0002\u00171Lgn\u001b*fO\u0016DXm]\u000b\u0002IA\u0019QE\u000b\u0017\u000e\u0003\u0019R!a\n\u0015\u0002\u0015\r|G\u000e\\3di&|gNC\u0001*\u0003\u0015\u00198-\u00197b\u0013\tYcEA\u0002TKF\u0004B!\f\u00181q5\t\u0001&\u0003\u00020Q\t1A+\u001e9mKJ\u0002\"!\r\u001c\u000e\u0003IR!a\r\u001b\u0002\t1\fgn\u001a\u0006\u0002k\u0005!!.\u0019<b\u0013\t9$G\u0001\u0004TiJLgn\u001a\t\u0003syj\u0011A\u000f\u0006\u0003wq\n\u0001\"\\1uG\"Lgn\u001a\u0006\u0003{!\nA!\u001e;jY&\u0011qH\u000f\u0002\u0006%\u0016<W\r_\u0001\rY&t7NU3hKb,7\u000fI\u0001\u0010I\u00164\u0017-\u001e7u\u0019&t7nU5uKV\t\u0001'\u0001\teK\u001a\fW\u000f\u001c;MS:\\7+\u001b;fA\u0001")
public class MessageResolverTBC
extends MessageResolver {
    private final Seq<Tuple2<String, Regex>> linkRegexes = new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("item"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hitem:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("spell"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|(?:Hspell|Henchant|Htalent)?:(\\d+).*?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("quest"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hquest:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), Nil$.MODULE$)));
    private final String defaultLinkSite;

    @Override
    public Seq<Tuple2<String, Regex>> linkRegexes() {
        return this.linkRegexes;
    }

    @Override
    public String defaultLinkSite() {
        return this.defaultLinkSite;
    }

    public MessageResolverTBC(JDA jda) {
        super(jda);
        this.defaultLinkSite = "http://tbc-twinhead.twinstar.cz";
    }
}

