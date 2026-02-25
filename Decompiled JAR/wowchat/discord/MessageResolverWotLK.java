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
import wowchat.discord.MessageResolverTBC;

@ScalaSignature(bytes="\u0006\u0001\u00113Aa\u0002\u0005\u0001\u001b!A!\u0003\u0001B\u0001B\u0003%1\u0003C\u0003\u001f\u0001\u0011\u0005q\u0004C\u0004#\u0001\t\u0007I\u0011K\u0012\t\r\u0001\u0003\u0001\u0015!\u0003%\u0011\u001d\t\u0005A1A\u0005R\tCaa\u0011\u0001!\u0002\u0013\u0001$\u0001F'fgN\fw-\u001a*fg>dg/\u001a:X_Rd5J\u0003\u0002\n\u0015\u00059A-[:d_J$'\"A\u0006\u0002\u000f]|wo\u00195bi\u000e\u00011C\u0001\u0001\u000f!\ty\u0001#D\u0001\t\u0013\t\t\u0002B\u0001\nNKN\u001c\u0018mZ3SKN|GN^3s)\n\u001b\u0015a\u00016eCB\u0011A\u0003H\u0007\u0002+)\u0011acF\u0001\u0004CBL'B\u0001\n\u0019\u0015\tI\"$A\u0004emb\"\u0018n\u001c8\u000b\u0003m\t1A\\3u\u0013\tiRCA\u0002K\t\u0006\u000ba\u0001P5oSRtDC\u0001\u0011\"!\ty\u0001\u0001C\u0003\u0013\u0005\u0001\u00071#A\u0006mS:\\'+Z4fq\u0016\u001cX#\u0001\u0013\u0011\u0007\u0015RC&D\u0001'\u0015\t9\u0003&\u0001\u0006d_2dWm\u0019;j_:T\u0011!K\u0001\u0006g\u000e\fG.Y\u0005\u0003W\u0019\u00121aU3r!\u0011ic\u0006\r\u001d\u000e\u0003!J!a\f\u0015\u0003\rQ+\b\u000f\\33!\t\td'D\u00013\u0015\t\u0019D'\u0001\u0003mC:<'\"A\u001b\u0002\t)\fg/Y\u0005\u0003oI\u0012aa\u0015;sS:<\u0007CA\u001d?\u001b\u0005Q$BA\u001e=\u0003!i\u0017\r^2iS:<'BA\u001f)\u0003\u0011)H/\u001b7\n\u0005}R$!\u0002*fO\u0016D\u0018\u0001\u00047j].\u0014VmZ3yKN\u0004\u0013a\u00043fM\u0006,H\u000e\u001e'j].\u001c\u0016\u000e^3\u0016\u0003A\n\u0001\u0003Z3gCVdG\u000fT5oWNKG/\u001a\u0011")
public class MessageResolverWotLK
extends MessageResolverTBC {
    private final Seq<Tuple2<String, Regex>> linkRegexes = new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("item"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hitem:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("spell"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|(?:Hspell|Henchant|Htalent)?:(\\d+).*?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("quest"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hquest:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("achievement"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hachievement:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("spell"), new StringOps(Predef$.MODULE$.augmentString("\\|Htrade:(\\d+):.+?\\|h\\[(.+?)]\\|h")).r())), Nil$.MODULE$)))));
    private final String defaultLinkSite;

    @Override
    public Seq<Tuple2<String, Regex>> linkRegexes() {
        return this.linkRegexes;
    }

    @Override
    public String defaultLinkSite() {
        return this.defaultLinkSite;
    }

    public MessageResolverWotLK(JDA jda) {
        super(jda);
        this.defaultLinkSite = "http://wotlk-twinhead.twinstar.cz";
    }
}

