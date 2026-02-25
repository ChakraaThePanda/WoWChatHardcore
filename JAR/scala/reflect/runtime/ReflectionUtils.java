/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import scala.Function1;
import scala.Option;
import scala.Option$;
import scala.PartialFunction;
import scala.reflect.ScalaSignature;
import scala.reflect.io.AbstractFile;
import scala.reflect.runtime.ReflectionUtils$;

@ScalaSignature(bytes="\u0006\u0001\u0005ew!\u0002\u0010 \u0011\u00031c!\u0002\u0015 \u0011\u0003I\u0003\"\u0002\u0018\u0002\t\u0003y\u0003\"\u0002\u0019\u0002\t\u0003\t\u0004\"B\u001e\u0002\t\u0003a\u0004\"\u0002(\u0002\t\u0003y\u0005\"B3\u0002\t\u00031\u0007\"B3\u0002\t\u0003Q\u0007\"\u0002;\u0002\t\u0003)x!B=\u0002\u0011\u0003Qh!\u0002?\u0002\u0011\u0003i\b\"\u0002\u0018\u000b\t\u0003q\bBB@\u000b\t\u0003\t\tA\u0002\u0004\u0002\u001a\u0005\u0001\u00111\u0004\u0005\u000b\u0003?i!\u0011!Q\u0001\n\u0005\u0005\u0002B\u0002\u0018\u000e\t\u0003\t)\u0004\u0003\u0004\u0000\u001b\u0011\u0005\u0011QI\u0004\b\u00033\n\u0001\u0012AA.\r\u001d\ti&\u0001E\u0001\u0003?BaA\f\n\u0005\u0002\u00055taBA8\u0003!\u0005\u0011\u0011\u000f\u0004\b\u0003g\n\u0001\u0012AA;\u0011\u0019qS\u0003\"\u0001\u0002\u0012\u001e9\u00111S\u0001\t\u0002\u0005UeaBAL\u0003!\u0005\u0011\u0011\u0014\u0005\u0007]a!\t!!+\b\u000f\u0005-\u0016\u0001#\u0001\u0002.\u001a9\u0011qV\u0001\t\u0002\u0005E\u0006B\u0002\u0018\u001c\t\u0003\tY\fC\u0004\u0002>\u0006!\t!a0\u0002\u001fI+g\r\\3di&|g.\u0016;jYNT!\u0001I\u0011\u0002\u000fI,h\u000e^5nK*\u0011!eI\u0001\be\u00164G.Z2u\u0015\u0005!\u0013!B:dC2\f7\u0001\u0001\t\u0003O\u0005i\u0011a\b\u0002\u0010%\u00164G.Z2uS>tW\u000b^5mgN\u0011\u0011A\u000b\t\u0003W1j\u0011aI\u0005\u0003[\r\u0012a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u0001'\u0003=)hn\u001e:baRC'o\\<bE2,GC\u0001\u001a:!\t\u0019dG\u0004\u0002,i%\u0011QgI\u0001\ba\u0006\u001c7.Y4f\u0013\t9\u0004HA\u0005UQJ|w/\u00192mK*\u0011Qg\t\u0005\u0006u\r\u0001\rAM\u0001\u0002q\u0006iQO\\<sCBD\u0015M\u001c3mKJ,\"!P\"\u0015\u0005yb\u0005\u0003B\u0016@e\u0005K!\u0001Q\u0012\u0003\u001fA\u000b'\u000f^5bY\u001a+hn\u0019;j_:\u0004\"AQ\"\r\u0001\u0011)A\t\u0002b\u0001\u000b\n\tA+\u0005\u0002G\u0013B\u00111fR\u0005\u0003\u0011\u000e\u0012qAT8uQ&tw\r\u0005\u0002,\u0015&\u00111j\t\u0002\u0004\u0003:L\b\"B'\u0005\u0001\u0004q\u0014A\u00019g\u0003\u0011\u0019\bn\\<\u0015\u0005A[\u0006CA)Y\u001d\t\u0011f\u000b\u0005\u0002TG5\tAK\u0003\u0002VK\u00051AH]8pizJ!aV\u0012\u0002\rA\u0013X\rZ3g\u0013\tI&L\u0001\u0004TiJLgn\u001a\u0006\u0003/\u000eBQ\u0001X\u0003A\u0002u\u000b!a\u00197\u0011\u0005y\u001bW\"A0\u000b\u0005\u0001\f\u0017\u0001\u00027b]\u001eT\u0011AY\u0001\u0005U\u00064\u0018-\u0003\u0002e?\nY1\t\\1tg2{\u0017\rZ3s\u0003]\u0019H/\u0019;jGNKgn\u001a7fi>t\u0017J\\:uC:\u001cW\rF\u0002+O\"DQ\u0001\u0018\u0004A\u0002uCQ!\u001b\u0004A\u0002A\u000b\u0011b\u00197bgNt\u0015-\\3\u0015\u0005)Z\u0007\"\u00027\b\u0001\u0004i\u0017!B2mCjT\bG\u00018s!\r\tv.]\u0005\u0003aj\u0013Qa\u00117bgN\u0004\"A\u0011:\u0005\u0013M\\\u0017\u0011!A\u0001\u0006\u0003)%aA0%e\u00051\u0012N\u001c8feNKgn\u001a7fi>t\u0017J\\:uC:\u001cW\rF\u0002+mbDQa\u001e\u0005A\u0002)\nQa\\;uKJDQ!\u001b\u0005A\u0002A\u000b\u0001\u0003\u0015:j[&$\u0018N^3Pe\u0006\u0013(/Y=\u0011\u0005mTQ\"A\u0001\u0003!A\u0013\u0018.\\5uSZ,wJ]!se\u0006L8C\u0001\u0006+)\u0005Q\u0018aB;oCB\u0004H.\u001f\u000b\u0005\u0003\u0007\tI\u0001E\u0002,\u0003\u000bI1!a\u0002$\u0005\u001d\u0011un\u001c7fC:Dq!a\u0003\r\u0001\u0004\ti!\u0001\u0004kG2\f'P\u001f\u0019\u0005\u0003\u001f\t)\u0002E\u0003_\u0003#\t\u0019\"\u0003\u0002q?B\u0019!)!\u0006\u0005\u0017\u0005]\u0011\u0011BA\u0001\u0002\u0003\u0015\t!\u0012\u0002\u0004?\u0012\"$AC#oG2|7/\u001a3J]V!\u0011QDA\u001a'\ti!&A\u0005f]\u000edwn];sKB91&a\t\u0002(\u0005E\u0012bAA\u0013G\tIa)\u001e8di&|g.\r\u0019\u0005\u0003S\ti\u0003E\u0003_\u0003#\tY\u0003E\u0002C\u0003[!!\"a\f\u000f\u0003\u0003\u0005\tQ!\u0001F\u0005\ryF%\u000e\t\u0004\u0005\u0006MB!\u0002#\u000e\u0005\u0004)E\u0003BA\u001c\u0003s\u0001Ba_\u0007\u00022!9\u0011qD\bA\u0002\u0005m\u0002cB\u0016\u0002$\u0005u\u0012\u0011\u0007\u0019\u0005\u0003\u007f\t\u0019\u0005E\u0003_\u0003#\t\t\u0005E\u0002C\u0003\u0007\"1\"a\f\u0002:\u0005\u0005\t\u0011!B\u0001\u000bR!\u0011qIA'!\u0015Y\u0013\u0011JA\u0019\u0013\r\tYe\t\u0002\u0007\u001fB$\u0018n\u001c8\t\u000f\u0005-\u0001\u00031\u0001\u0002PA\"\u0011\u0011KA+!\u0015q\u0016\u0011CA*!\r\u0011\u0015Q\u000b\u0003\f\u0003/\ni%!A\u0001\u0002\u000b\u0005QIA\u0002`IY\n\u0001#\u00128dY>\u001cX\rZ%o\u001b\u0016$\bn\u001c3\u0011\u0005m\u0014\"\u0001E#oG2|7/\u001a3J]6+G\u000f[8e'\r\u0011\u0012\u0011\r\t\u0005w6\t\u0019\u0007\u0005\u0003\u0002f\u0005%TBAA4\u0015\t\u0011s,\u0003\u0003\u0002l\u0005\u001d$AB'fi\"|G\r\u0006\u0002\u0002\\\u0005)RI\\2m_N,G-\u00138D_:\u001cHO];di>\u0014\bCA>\u0016\u0005U)en\u00197pg\u0016$\u0017J\\\"p]N$(/^2u_J\u001c2!FA<!\u0011YX\"!\u001f1\t\u0005m\u00141\u0011\t\u0007\u0003K\ni(!!\n\t\u0005}\u0014q\r\u0002\f\u0007>t7\u000f\u001e:vGR|'\u000fE\u0002C\u0003\u0007#1\"!\"\u0002\b\u0006\u0005\t\u0011!B\u0001\u000b\n\u0011q\b\r\u0005\u000b\u0003\u0013\u000bY)!A\u0001\u0002\u0005=\u0015\u0001\u0003\u0013b]>tg-\u001e8\t\r\u00055\u0015\u0001AAH\u0003]aDn\\2bY\u0002\u0012VM\u001a7fGRLwN\\+uS2\u001chh\u0003\u0001\u0015\u0005\u0005E\u0014aD#oG2|7/\u001a3J]\u000ec\u0017m]:\u0011\u0005mD\"aD#oG2|7/\u001a3J]\u000ec\u0017m]:\u0014\u0007a\tY\n\u0005\u0003|\u001b\u0005u\u0005\u0007BAP\u0003G\u0003RAXA\t\u0003C\u00032AQAR\t-\t))!*\u0002\u0002\u0003\u0005)\u0011A#\t\u0015\u0005%\u0015qUA\u0001\u0002\u0003\ty\t\u0003\u0004\u0002\u000e\u0006\u0001\u0011q\u0012\u000b\u0003\u0003+\u000b\u0011#\u00128dY>\u001cX\rZ%o!\u0006\u001c7.Y4f!\tY8DA\tF]\u000edwn]3e\u0013:\u0004\u0016mY6bO\u0016\u001c2aGAZ!\u0011YX\"!.\u0011\u0007y\u000b9,C\u0002\u0002:~\u0013q\u0001U1dW\u0006<W\r\u0006\u0002\u0002.\u0006q\u0011m]:pG&\fG/\u001a3GS2,G\u0003BAa\u0003\u001b\u0004B!a1\u0002J6\u0011\u0011Q\u0019\u0006\u0004\u0003\u000f\f\u0013AA5p\u0013\u0011\tY-!2\u0003\u0019\u0005\u00137\u000f\u001e:bGR4\u0015\u000e\\3\t\r1l\u0002\u0019AAha\u0011\t\t.!6\u0011\tE{\u00171\u001b\t\u0004\u0005\u0006UGaCAl\u0003\u001b\f\t\u0011!A\u0003\u0002\u0015\u00131a\u0018\u00138\u0001")
public final class ReflectionUtils {
    public static AbstractFile associatedFile(Class<?> clazz) {
        return ReflectionUtils$.MODULE$.associatedFile(clazz);
    }

    public static Object innerSingletonInstance(Object object, String string) {
        return ReflectionUtils$.MODULE$.innerSingletonInstance(object, string);
    }

    public static Object staticSingletonInstance(Class<?> clazz) {
        return ReflectionUtils$.MODULE$.staticSingletonInstance(clazz);
    }

    public static Object staticSingletonInstance(ClassLoader classLoader, String string) {
        return ReflectionUtils$.MODULE$.staticSingletonInstance(classLoader, string);
    }

    public static String show(ClassLoader classLoader) {
        return ReflectionUtils$.MODULE$.show(classLoader);
    }

    public static <T> PartialFunction<Throwable, T> unwrapHandler(PartialFunction<Throwable, T> partialFunction) {
        return ReflectionUtils$.MODULE$.unwrapHandler(partialFunction);
    }

    public static Throwable unwrapThrowable(Throwable throwable) {
        return ReflectionUtils$.MODULE$.unwrapThrowable(throwable);
    }

    public static class EnclosedIn<T> {
        private final Function1<Class<?>, T> enclosure;

        public Option<T> unapply(Class<?> jclazz) {
            return Option$.MODULE$.apply(this.enclosure.apply(jclazz));
        }

        public EnclosedIn(Function1<Class<?>, T> enclosure) {
            this.enclosure = enclosure;
        }
    }
}

