/*
 * Decompiled with CFR 0.152.
 */
package wowchat.discord;

import java.io.Serializable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.RichCustomEmoji;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Tuple2;
import scala.collection.GenTraversable;
import scala.collection.JavaConverters$;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Buffer$;
import scala.collection.mutable.Set;
import scala.collection.mutable.Set$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.util.matching.Regex;
import wowchat.common.Global$;
import wowchat.discord.MessageResolver$;
import wowchat.game.GameResources$;

@ScalaSignature(bytes="\u0006\u0001\u0005}r!B\n\u0015\u0011\u0003Ib!B\u000e\u0015\u0011\u0003a\u0002\"B\u0012\u0002\t\u0003!\u0003\"B\u0013\u0002\t\u00031c\u0001B\u000e\u0015\u0001!B\u0001\"\u000b\u0003\u0003\u0002\u0003\u0006IA\u000b\u0005\u0006G\u0011!\t!\u000e\u0005\bo\u0011\u0011\r\u0011\"\u00059\u0011\u0019\u0011F\u0001)A\u0005s!91\u000b\u0002b\u0001\n#!\u0006BB+\u0005A\u0003%!\tC\u0004W\t\t\u0007I\u0011\u0002+\t\r]#\u0001\u0015!\u0003C\u0011\u0015AF\u0001\"\u0001Z\u0011\u00151G\u0001\"\u0001h\u0011\u0015iG\u0001\"\u0001o\u0011\u0015\u0001H\u0001\"\u0001r\u0011\u001d\ty\u0001\u0002C\u0005\u0003#Aq!a\u000e\u0005\t\u0003\tI$A\bNKN\u001c\u0018mZ3SKN|GN^3s\u0015\t)b#A\u0004eSN\u001cwN\u001d3\u000b\u0003]\tqa^8xG\"\fGo\u0001\u0001\u0011\u0005i\tQ\"\u0001\u000b\u0003\u001f5+7o]1hKJ+7o\u001c7wKJ\u001c\"!A\u000f\u0011\u0005y\tS\"A\u0010\u000b\u0003\u0001\nQa]2bY\u0006L!AI\u0010\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\t\u0011$A\u0003baBd\u0017\u0010F\u0002(\u0003{\u0001\"A\u0007\u0003\u0014\u0005\u0011i\u0012a\u00016eCB\u00111fM\u0007\u0002Y)\u0011QFL\u0001\u0004CBL'BA\u00150\u0015\t\u0001\u0014'A\u0004emb\"\u0018n\u001c8\u000b\u0003I\n1A\\3u\u0013\t!DFA\u0002K\t\u0006#\"a\n\u001c\t\u000b%2\u0001\u0019\u0001\u0016\u0002\u00171Lgn\u001b*fO\u0016DXm]\u000b\u0002sA\u0019!(P \u000e\u0003mR!\u0001P\u0010\u0002\u0015\r|G\u000e\\3di&|g.\u0003\u0002?w\t\u00191+Z9\u0011\ty\u0001%IS\u0005\u0003\u0003~\u0011a\u0001V;qY\u0016\u0014\u0004CA\"I\u001b\u0005!%BA#G\u0003\u0011a\u0017M\\4\u000b\u0003\u001d\u000bAA[1wC&\u0011\u0011\n\u0012\u0002\u0007'R\u0014\u0018N\\4\u0011\u0005-\u0003V\"\u0001'\u000b\u00055s\u0015\u0001C7bi\u000eD\u0017N\\4\u000b\u0005={\u0012\u0001B;uS2L!!\u0015'\u0003\u000bI+w-\u001a=\u0002\u00191Lgn\u001b*fO\u0016DXm\u001d\u0011\u0002\u001f\u0011,g-Y;mi2Kgn[*ji\u0016,\u0012AQ\u0001\u0011I\u00164\u0017-\u001e7u\u0019&t7nU5uK\u0002\n\u0001\u0002\\5oWNKG/Z\u0001\nY&t7nU5uK\u0002\nAB]3t_24X\rT5oWN$\"A\u00173\u0011\u0005m\u0013gB\u0001/a!\tiv$D\u0001_\u0015\ty\u0006$\u0001\u0004=e>|GOP\u0005\u0003C~\ta\u0001\u0015:fI\u00164\u0017BA%d\u0015\t\tw\u0004C\u0003f\u001b\u0001\u0007!,A\u0004nKN\u001c\u0018mZ3\u0002)I,7o\u001c7wK\u0006\u001b\u0007.[3wK6,g\u000e^%e)\tQ\u0006\u000eC\u0003j\u001d\u0001\u0007!.A\u0007bG\"LWM^3nK:$\u0018\n\u001a\t\u0003=-L!\u0001\\\u0010\u0003\u0007%sG/\u0001\ttiJL\u0007oQ8m_J\u001cu\u000eZ5oOR\u0011!l\u001c\u0005\u0006K>\u0001\rAW\u0001\fe\u0016\u001cx\u000e\u001c<f)\u0006<7\u000f\u0006\u0003[ez|\b\"B:\u0011\u0001\u0004!\u0018A\u00043jg\u000e|'\u000fZ\"iC:tW\r\u001c\t\u0003krl\u0011A\u001e\u0006\u0003ob\f\u0001bY8oGJ,G/\u001a\u0006\u0003sj\fqa\u00195b]:,GN\u0003\u0002|Y\u0005AQM\u001c;ji&,7/\u0003\u0002~m\nYA+\u001a=u\u0007\"\fgN\\3m\u0011\u0015)\u0007\u00031\u0001[\u0011\u001d\t\t\u0001\u0005a\u0001\u0003\u0007\tqa\u001c8FeJ|'\u000f\u0005\u0004\u001f\u0003\u000bQ\u0016\u0011B\u0005\u0004\u0003\u000fy\"!\u0003$v]\u000e$\u0018n\u001c82!\rq\u00121B\u0005\u0004\u0003\u001by\"\u0001B+oSR\f\u0011C]3t_24X\rV1h\u001b\u0006$8\r[3s)!\t\u0019\"!\n\u0002*\u00055\u0002CBA\u000b\u0003?\t\u0019C\u0004\u0003\u0002\u0018\u0005mabA/\u0002\u001a%\t\u0001%C\u0002\u0002\u001e}\tq\u0001]1dW\u0006<W-C\u0002?\u0003CQ1!!\b !\u0011q\u0002I\u0017.\t\u000f\u0005\u001d\u0012\u00031\u0001\u0002\u0014\u0005)a.Y7fg\"1\u00111F\tA\u0002i\u000b1\u0001^1h\u0011\u001d\ty#\u0005a\u0001\u0003c\ta![:S_2,\u0007c\u0001\u0010\u00024%\u0019\u0011QG\u0010\u0003\u000f\t{w\u000e\\3b]\u0006i!/Z:pYZ,W)\\8kSN$2AWA\u001e\u0011\u0015)'\u00031\u0001[\u0011\u0015I3\u00011\u0001+\u0001")
public class MessageResolver {
    private final JDA jda;
    private final Seq<Tuple2<String, Regex>> linkRegexes;
    private final String defaultLinkSite;
    private final String linkSite;

    public static MessageResolver apply(JDA jDA) {
        return MessageResolver$.MODULE$.apply(jDA);
    }

    public Seq<Tuple2<String, Regex>> linkRegexes() {
        return this.linkRegexes;
    }

    public String defaultLinkSite() {
        return this.defaultLinkSite;
    }

    private String linkSite() {
        return this.linkSite;
    }

    public String resolveLinks(String message) {
        return this.linkRegexes().foldLeft(message, (Function2<String, Tuple2, String> & Serializable & scala.Serializable)(x0$1, x1$1) -> {
            Tuple2 tuple2;
            String result2;
            block3: {
                Tuple2<String, Tuple2> tuple22;
                block2: {
                    tuple22 = new Tuple2<String, Tuple2>((String)x0$1, (Tuple2)x1$1);
                    if (tuple22 == null) break block2;
                    result2 = tuple22._1();
                    tuple2 = tuple22._2();
                    if (tuple2 != null) break block3;
                }
                throw new MatchError(tuple22);
            }
            String classicDbKey = (String)tuple2._1();
            Regex regex = (Regex)tuple2._2();
            String string = regex.replaceAllIn((CharSequence)result2, (Function1<Regex.Match, String> & Serializable & scala.Serializable)m -> new StringBuilder(8).append("[[").append(m.group(2)).append("]](").append(this.linkSite()).append("?").append(classicDbKey).append("=").append(m.group(1)).append(")").toString());
            return string;
        });
    }

    public String resolveAchievementId(int achievementId) {
        Object name = GameResources$.MODULE$.ACHIEVEMENT().getOrElse(BoxesRunTime.boxToInteger(achievementId), (JFunction0$mcI$sp & scala.Serializable)() -> achievementId);
        return new StringBuilder(19).append("[[").append(name).append("]](").append(this.linkSite()).append("?achievement=").append(achievementId).append(")").toString();
    }

    public String stripColorCoding(String message) {
        String hex = "\\|c[0-9a-fA-F]{8}";
        Regex pass1 = new StringOps(Predef$.MODULE$.augmentString(new StringBuilder(8).append(hex).append("(.*?)\\|r").toString())).r();
        Regex pass2 = new StringOps(Predef$.MODULE$.augmentString(hex)).r();
        return pass2.replaceAllIn((CharSequence)pass1.replaceAllIn((CharSequence)message.replace("$", "\\$"), (Function1<Regex.Match, String> & Serializable & scala.Serializable)x$1 -> x$1.group(1)), "");
    }

    public String resolveTags(TextChannel discordChannel, String message, Function1<String, BoxedUnit> onError2) {
        Seq regexes = ((TraversableLike)new $colon$colon<Nothing$>((Nothing$)((Object)"\"@(.+?)\""), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)"@([\\w]+)"), Nil$.MODULE$))).map((Function1<String, Regex> & Serializable & scala.Serializable)x$2 -> new StringOps(Predef$.MODULE$.augmentString((String)x$2)).r(), Seq$.MODULE$.canBuildFrom());
        Buffer scalaMembers = (Buffer)((TraversableLike)JavaConverters$.MODULE$.asScalaBufferConverter(discordChannel.getMembers()).asScala()).filterNot((Function1<Member, Object> & Serializable & scala.Serializable)x$3 -> BoxesRunTime.boxToBoolean(MessageResolver.$anonfun$resolveTags$2(this, x$3)));
        Buffer effectiveNames = scalaMembers.map((Function1<Member, Tuple2> & Serializable & scala.Serializable)member -> Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(member.getEffectiveName()), member.getUser().getId()), Buffer$.MODULE$.canBuildFrom());
        Buffer userNames = scalaMembers.map((Function1<Member, Tuple2> & Serializable & scala.Serializable)member -> {
            User user = member.getUser();
            return Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(new StringBuilder(1).append(user.getName()).append("#").append(user.getDiscriminator()).toString()), user.getId());
        }, Buffer$.MODULE$.canBuildFrom());
        Buffer roleNames = ((TraversableLike)((TraversableLike)JavaConverters$.MODULE$.asScalaBufferConverter(this.jda.getRoles()).asScala()).filterNot((Function1<Role, Object> & Serializable & scala.Serializable)x$4 -> BoxesRunTime.boxToBoolean(MessageResolver.$anonfun$resolveTags$5(x$4)))).map((Function1<Role, Tuple2> & Serializable & scala.Serializable)role -> Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(role.getName()), role.getId()), Buffer$.MODULE$.canBuildFrom());
        return regexes.foldLeft(message, (Function2<String, Regex, String> & Serializable & scala.Serializable)(x0$1, x1$1) -> {
            Tuple2<String, Regex> tuple2 = new Tuple2<String, Regex>((String)x0$1, (Regex)x1$1);
            if (tuple2 == null) {
                throw new MatchError(tuple2);
            }
            String result2 = tuple2._1();
            Regex regex = tuple2._2();
            String string = regex.replaceAllIn((CharSequence)result2, (Function1<Regex.Match, String> & Serializable & scala.Serializable)m -> {
                String string;
                String tag = m.group(1);
                Seq matches = ((TraversableOnce)new $colon$colon<Nothing$>((Nothing$)((Object)effectiveNames), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)userNames), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)roleNames), Nil$.MODULE$)))).foldLeft(Nil$.MODULE$, (Function2<Seq, Buffer, Seq> & Serializable & scala.Serializable)(x0$2, x1$2) -> {
                    Buffer members;
                    Tuple2<Seq, Buffer> tuple2 = new Tuple2<Seq, Buffer>((Seq)x0$2, (Buffer)x1$2);
                    if (tuple2 == null) {
                        throw new MatchError(tuple2);
                    }
                    Seq result2 = tuple2._1();
                    Buffer buffer = members = tuple2._2();
                    Buffer buffer2 = roleNames;
                    Seq resolvedTags = this.resolveTagMatcher(members, tag, !(buffer != null ? !buffer.equals(buffer2) : buffer2 != null));
                    Seq seq = result2.isEmpty() ? resolvedTags : (result2.size() == 1 ? result2 : result2.$plus$plus(resolvedTags, Seq$.MODULE$.canBuildFrom()));
                    return seq;
                });
                if (matches.size() == 1) {
                    string = new StringBuilder(3).append("<@").append(((Tuple2)matches.head())._2()).append(">").toString();
                } else if (matches.size() > 1 && matches.size() < 5) {
                    onError2.apply(new StringBuilder(76).append("Your tag @").append(tag).append(" matches multiple channel members: ").append(((TraversableOnce)matches.map((Function1<Tuple2, String> & Serializable & scala.Serializable)x$5 -> (String)x$5._1(), Seq$.MODULE$.canBuildFrom())).mkString(", ")).append(". Be more specific in your tag!").toString());
                    string = m.group(0);
                } else if (matches.size() >= 5) {
                    onError2.apply(new StringBuilder(74).append("Your tag @").append(tag).append(" matches too many channel members. Be more specific in your tag!").toString());
                    string = m.group(0);
                } else {
                    string = m.group(0);
                }
                return string;
            });
            return string;
        });
    }

    private Seq<Tuple2<String, String>> resolveTagMatcher(Seq<Tuple2<String, String>> names, String tag, boolean isRole) {
        String lTag;
        String string = lTag = tag.toLowerCase();
        String string2 = "here";
        if (!(string != null ? !string.equals(string2) : string2 != null)) {
            return Nil$.MODULE$;
        }
        Seq matchesInitial = (Seq)names.filter((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$1 -> BoxesRunTime.boxToBoolean(MessageResolver.$anonfun$resolveTagMatcher$1(lTag, x0$1)));
        return ((TraversableLike)(matchesInitial.size() > 1 && !lTag.contains(" ") ? matchesInitial.find((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$2 -> BoxesRunTime.boxToBoolean(MessageResolver.$anonfun$resolveTagMatcher$2(lTag, x0$2))).fold((Function0<Seq> & Serializable & scala.Serializable)() -> {
            Seq namesWithMatchedWord = (Seq)matchesInitial.filter((Function1<Tuple2, Object> & Serializable & scala.Serializable)x0$3 -> BoxesRunTime.boxToBoolean(MessageResolver.$anonfun$resolveTagMatcher$4(lTag, x0$3)));
            return namesWithMatchedWord.nonEmpty() ? namesWithMatchedWord : matchesInitial;
        }, (Function1<Tuple2, List> & Serializable & scala.Serializable)x$6 -> {
            Tuple2 tuple2 = x$6;
            return Nil$.MODULE$.$colon$colon(tuple2);
        }) : matchesInitial)).map((Function1<Tuple2, Tuple2> & Serializable & scala.Serializable)x0$4 -> {
            Tuple2 tuple2 = x0$4;
            if (tuple2 == null) {
                throw new MatchError(tuple2);
            }
            String name = (String)tuple2._1();
            String id = (String)tuple2._2();
            Tuple2<String, String> tuple22 = Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(name), isRole ? new StringBuilder(1).append("&").append(id).toString() : id);
            return tuple22;
        }, Seq$.MODULE$.canBuildFrom());
    }

    public String resolveEmojis(String message) {
        Regex regex = new StringOps(Predef$.MODULE$.augmentString("(?<=:).*?(?=:)")).r();
        Map emojiMap = ((TraversableOnce)((TraversableLike)JavaConverters$.MODULE$.asScalaBufferConverter(this.jda.getEmojis()).asScala()).map((Function1<RichCustomEmoji, Tuple2> & Serializable & scala.Serializable)emote -> Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(emote.getName().toLowerCase()), emote.getId()), Buffer$.MODULE$.canBuildFrom())).toMap(Predef$.MODULE$.$conforms());
        GenTraversable alreadyResolved = Set$.MODULE$.empty();
        return regex.findAllIn(message).foldLeft(message, (arg_0, arg_1) -> MessageResolver.$anonfun$resolveEmojis$2((Set)alreadyResolved, emojiMap, arg_0, arg_1));
    }

    public static final /* synthetic */ boolean $anonfun$resolveTags$2(MessageResolver $this, Member x$3) {
        return x$3.getUser().getIdLong() == $this.jda.getSelfUser().getIdLong();
    }

    public static final /* synthetic */ boolean $anonfun$resolveTags$5(Role x$4) {
        String string = x$4.getName();
        String string2 = "@everyone";
        return !(string != null ? !string.equals(string2) : string2 != null);
    }

    public static final /* synthetic */ boolean $anonfun$resolveTagMatcher$1(String lTag$1, Tuple2 x0$1) {
        Tuple2 tuple2 = x0$1;
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        String name = (String)tuple2._1();
        boolean bl = name.toLowerCase().contains(lTag$1);
        return bl;
    }

    public static final /* synthetic */ boolean $anonfun$resolveTagMatcher$2(String lTag$1, Tuple2 x0$2) {
        Tuple2 tuple2 = x0$2;
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        String name = (String)tuple2._1();
        String string = name.toLowerCase();
        String string2 = lTag$1;
        boolean bl = !(string != null ? !string.equals(string2) : string2 != null);
        return bl;
    }

    public static final /* synthetic */ boolean $anonfun$resolveTagMatcher$4(String lTag$1, Tuple2 x0$3) {
        Tuple2 tuple2 = x0$3;
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        String name = (String)tuple2._1();
        boolean bl = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])name.toLowerCase().split("\\W+"))).contains(lTag$1);
        return bl;
    }

    public static final /* synthetic */ String $anonfun$resolveEmojis$2(Set alreadyResolved$1, Map emojiMap$1, String x0$1, String x1$1) {
        Tuple2<String, String> tuple2 = new Tuple2<String, String>(x0$1, x1$1);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        String result2 = tuple2._1();
        String possibleEmoji = tuple2._2();
        String lPossibleEmoji = possibleEmoji.toLowerCase();
        String string = alreadyResolved$1.apply(lPossibleEmoji) ? result2 : (String)emojiMap$1.get(lPossibleEmoji).fold((Function0<String> & Serializable & scala.Serializable)() -> result2, (Function1<String, String> & Serializable & scala.Serializable)id -> {
            alreadyResolved$1.$plus$eq(lPossibleEmoji);
            return result2.replace(new StringBuilder(2).append(":").append(possibleEmoji).append(":").toString(), new StringBuilder(4).append("<:").append(possibleEmoji).append(":").append((String)id).append(">").toString());
        });
        return string;
    }

    public MessageResolver(JDA jda) {
        this.jda = jda;
        this.linkRegexes = new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("item"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hitem:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("spell"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|(?:Hspell|Henchant)?:(\\d+).*?\\|h\\[(.+?)]\\|h\\|r")).r())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc("quest"), new StringOps(Predef$.MODULE$.augmentString("\\|.+?\\|Hquest:(\\d+):.+?\\|h\\[(.+?)]\\|h\\|r")).r())), Nil$.MODULE$)));
        this.defaultLinkSite = "http://classicdb.ch";
        this.linkSite = (String)Global$.MODULE$.config().discord().itemDatabase().fold((Function0<String> & Serializable & scala.Serializable)() -> this.defaultLinkSite(), (Function1<String, String> & Serializable & scala.Serializable)itemDatabase -> {
            String string = itemDatabase;
            String string2 = "";
            return (string == null ? string2 != null : !string.equals(string2)) ? itemDatabase : this.defaultLinkSite();
        });
    }
}

