/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import scala.Option;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005McaB\u0010!!\u0003\r\ta\n\u0005\u0006Y\u0001!\t!\f\u0005\u0006c\u0001!\u0019A\r\u0005\u0006{\u0002!\u0019A \u0003\u0006\u0003\u0002\u0011\tA\u0011\u0003\u0006+\u0002\u0011\tA\u0016\u0004\b5\u0002\u0001\n1%\u0001\\\t\u0015)\u0004A!\u00017\r\u001dq\u0004\u0001%A\u0012\u0002}2QA\u0012\u0001\u0002\u0002\u001dCQ\u0001S\u0005\u0005\u0002%CQAS\u0005\u0007\u0002-CQaT\u0005\u0007\u0002-CQ\u0001U\u0005\u0007\u0002ECQAU\u0005\u0007\u0002MCQ\u0001X\u0005\u0007\u0002uCQ!]\u0005\u0007\u0002uCQ!^\u0005\u0007\u0002YDQa^\u0005\u0007\u0002YDq!a\u0002\u0001\r\u0003\tI\u0001C\u0004\u0002\u0014\u00011\t!!\u0006\t\u0013\u0005}\u0001A1A\u0007\u0002\u0005\u0005baBA\u0013\u0001\u0005\u0005\u0011q\u0005\u0005\u0007\u0011Z!\t!!\u000b\t\u000f\u0005-bC\"\u0001\u0002.!9\u0011\u0011\u0007\f\u0007\u0002\u0005M\u0002\"CA \u0001\t\u0007i\u0011AA!\r\u001d\t)\u0005AA\u0001\u0003\u000fBa\u0001S\u000e\u0005\u0002\u0005%\u0003bBA\u00167\u0019\u0005\u00111\n\u0005\b\u0003cYb\u0011AA(\u0005\u0015q\u0015-\\3t\u0015\t\t#%A\u0002ba&T!a\t\u0013\u0002\u000fI,g\r\\3di*\tQ%A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001A\u0003CA\u0015+\u001b\u0005!\u0013BA\u0016%\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012A\f\t\u0003S=J!\u0001\r\u0013\u0003\tUs\u0017\u000e^\u0001\u0011gR\u0014\u0018N\\4U_R+'/\u001c(b[\u0016$\"a\r=\u0011\u0005Q:Q\"\u0001\u0001\u0003\u0011Q+'/\u001c(b[\u0016\f\"a\u000e\u001e\u0011\u0005%B\u0014BA\u001d%\u0005\u0011qU\u000f\u001c7\u0013\u0007mj\u0004I\u0002\u0003=\u0001\u0001Q$\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004C\u0001\u001b\t\u0005-!VM]7OC6,\u0017\t]5\u0014\u0005!A\u0003C\u0001\u001b\u0005\u0005\u0011q\u0015-\\3\u0012\u0005]\u001a%c\u0001#)\u000b\u001a!A\b\u0001\u0001D!\t!\u0014BA\u0004OC6,\u0017\t]5\u0014\u0005%A\u0013A\u0002\u001fj]&$h\bF\u0001F\u0003)I7\u000fV3s[:\u000bW.Z\u000b\u0002\u0019B\u0011\u0011&T\u0005\u0003\u001d\u0012\u0012qAQ8pY\u0016\fg.\u0001\u0006jgRK\b/\u001a(b[\u0016\f!\u0002^8UKJlg*Y7f+\u0005\u0019\u0014A\u0003;p)f\u0004XMT1nKV\tA\u000b\u0005\u00025\u000b\tAA+\u001f9f\u001d\u0006lW-\u0005\u00028/J\u0019\u0001,\u0017!\u0007\tq\u0002\u0001a\u0016\t\u0003i\u0019\u00111\u0002V=qK:\u000bW.Z!qSN\u0011a\u0001K\u0001\bI\u0016\u001cw\u000eZ3e+\u0005q\u0006CA0g\u001d\t\u0001G\r\u0005\u0002bI5\t!M\u0003\u0002dM\u00051AH]8pizJ!!\u001a\u0013\u0002\rA\u0013X\rZ3g\u0013\t9\u0007N\u0001\u0004TiJLgn\u001a\u0006\u0003K\u0012BCa\u00046n_B\u0011\u0011f[\u0005\u0003Y\u0012\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005q\u0017AI;tK\u0002\u0002G-Z2pI\u0016$g*Y7f]Q|7\u000b\u001e:j]\u001e\u0004\u0007%\u001b8ti\u0016\fG-I\u0001q\u0003\u0019\u0011d&M\u0019/a\u00059QM\\2pI\u0016$\u0007\u0006\u0002\tkg>\f\u0013\u0001^\u0001#kN,\u0007\u0005Y3oG>$W\r\u001a(b[\u0016tCo\\*ue&tw\r\u0019\u0011j]N$X-\u00193\u0002\u0017\u0011,7m\u001c3fI:\u000bW.Z\u000b\u0002\u0001\u0006YQM\\2pI\u0016$g*Y7f\u0011\u0015I(\u00011\u0001_\u0003\u0005\u0019\b\u0006\u0002\u0002kw>\f\u0013\u0001`\u0001#kN,\u0007%\u001a=qY&\u001c\u0017\u000e\u001e\u0011a)\u0016\u0014XNT1nK\"\u001a\u0018\u0006\u0019\u0011j]N$X-\u00193\u0002!M$(/\u001b8h)>$\u0016\u0010]3OC6,GC\u0001+\u0000\u0011\u0015I8\u00011\u0001_Q\u0015\u0019!.a\u0001pC\t\t)!\u0001\u0012vg\u0016\u0004S\r\u001f9mS\u000eLG\u000f\t1UsB,g*Y7fQML\u0003\rI5ogR,\u0017\rZ\u0001\f]\u0016<H+\u001a:n\u001d\u0006lW\rF\u00024\u0003\u0017AQ!_\nA\u0002yCSa\u00056\u0002\u0010=\f#!!\u0005\u0002)U\u001cX\r\t+fe6t\u0015-\\3!S:\u001cH/Z1e\u0003-qWm\u001e+za\u0016t\u0015-\\3\u0015\u0007Q\u000b9\u0002C\u0003z)\u0001\u0007a\fK\u0003\u0015U\u0006mq.\t\u0002\u0002\u001e\u0005!Ro]3!)f\u0004XMT1nK\u0002Jgn\u001d;fC\u0012\f\u0001\u0002V3s[:\u000bW.Z\u000b\u0003\u0003G\u0001\"\u0001\u000e\f\u0003#Q+'/\u001c(b[\u0016,\u0005\u0010\u001e:bGR|'o\u0005\u0002\u0017QQ\u0011\u00111E\u0001\u0006CB\u0004H.\u001f\u000b\u0004g\u0005=\u0002\"B=\u0019\u0001\u0004q\u0016aB;oCB\u0004H.\u001f\u000b\u0005\u0003k\tY\u0004\u0005\u0003*\u0003oq\u0016bAA\u001dI\t1q\n\u001d;j_:Da!!\u0010\u001a\u0001\u0004\u0019\u0014\u0001\u00028b[\u0016\f\u0001\u0002V=qK:\u000bW.Z\u000b\u0003\u0003\u0007\u0002\"\u0001N\u000e\u0003#QK\b/\u001a(b[\u0016,\u0005\u0010\u001e:bGR|'o\u0005\u0002\u001cQQ\u0011\u00111\t\u000b\u0004)\u00065\u0003\"B=\u001e\u0001\u0004qF\u0003BA\u001b\u0003#Ba!!\u0010\u001f\u0001\u0004!\u0006")
public interface Names {
    public static /* synthetic */ TermNameApi stringToTermName$(Names $this, String s) {
        return $this.stringToTermName(s);
    }

    default public TermNameApi stringToTermName(String s) {
        return this.TermName().apply(s);
    }

    public static /* synthetic */ TypeNameApi stringToTypeName$(Names $this, String s) {
        return $this.stringToTypeName(s);
    }

    default public TypeNameApi stringToTypeName(String s) {
        return this.TypeName().apply(s);
    }

    public TermNameApi newTermName(String var1);

    public TypeNameApi newTypeName(String var1);

    public TermNameExtractor TermName();

    public TypeNameExtractor TypeName();

    public static void $init$(Names $this) {
    }

    public abstract class NameApi {
        public abstract boolean isTermName();

        public abstract boolean isTypeName();

        public abstract TermNameApi toTermName();

        public abstract TypeNameApi toTypeName();

        public abstract String decoded();

        public abstract String encoded();

        public abstract NameApi decodedName();

        public abstract NameApi encodedName();

        public /* synthetic */ Names scala$reflect$api$Names$NameApi$$$outer() {
            return Names.this;
        }

        public NameApi() {
            if (Names.this == null) {
                throw null;
            }
        }
    }

    public interface TermNameApi {
    }

    public abstract class TermNameExtractor {
        public abstract TermNameApi apply(String var1);

        public abstract Option<String> unapply(TermNameApi var1);

        public /* synthetic */ Names scala$reflect$api$Names$TermNameExtractor$$$outer() {
            return Names.this;
        }

        public TermNameExtractor() {
            if (Names.this == null) {
                throw null;
            }
        }
    }

    public interface TypeNameApi {
    }

    public abstract class TypeNameExtractor {
        public abstract TypeNameApi apply(String var1);

        public abstract Option<String> unapply(TypeNameApi var1);

        public /* synthetic */ Names scala$reflect$api$Names$TypeNameExtractor$$$outer() {
            return Names.this;
        }

        public TypeNameExtractor() {
            if (Names.this == null) {
                throw null;
            }
        }
    }
}

