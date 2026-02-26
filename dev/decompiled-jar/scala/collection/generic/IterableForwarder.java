/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.GenIterable;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.generic.TraversableForwarder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001%3q!\u0002\u0004\u0011\u0002\u0007\u0005Q\u0002C\u0003'\u0001\u0011\u0005q\u0005C\u0003,\u0001\u0019EA\u0006C\u0003.\u0001\u0011\u0005c\u0006C\u00033\u0001\u0011\u00053GA\tJi\u0016\u0014\u0018M\u00197f\r>\u0014x/\u0019:eKJT!a\u0002\u0005\u0002\u000f\u001d,g.\u001a:jG*\u0011\u0011BC\u0001\u000bG>dG.Z2uS>t'\"A\u0006\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011a\"G\n\u0005\u0001=\u0019\"\u0005\u0005\u0002\u0011#5\t!\"\u0003\u0002\u0013\u0015\t1\u0011I\\=SK\u001a\u00042\u0001F\u000b\u0018\u001b\u0005A\u0011B\u0001\f\t\u0005!IE/\u001a:bE2,\u0007C\u0001\r\u001a\u0019\u0001!aA\u0007\u0001\u0005\u0006\u0004Y\"!A!\u0012\u0005qy\u0002C\u0001\t\u001e\u0013\tq\"BA\u0004O_RD\u0017N\\4\u0011\u0005A\u0001\u0013BA\u0011\u000b\u0005\r\te.\u001f\t\u0004G\u0011:R\"\u0001\u0004\n\u0005\u00152!\u0001\u0006+sCZ,'o]1cY\u00164uN]<be\u0012,'/\u0001\u0004%S:LG\u000f\n\u000b\u0002QA\u0011\u0001#K\u0005\u0003U)\u0011A!\u00168ji\u0006QQO\u001c3fe2L\u0018N\\4\u0016\u0003M\t\u0001\"\u001b;fe\u0006$xN]\u000b\u0002_A\u0019A\u0003M\f\n\u0005EB!\u0001C%uKJ\fGo\u001c:\u0002\u0019M\fW.Z#mK6,g\u000e^:\u0016\u0005QrDCA\u001b9!\t\u0001b'\u0003\u00028\u0015\t9!i\\8mK\u0006t\u0007\"B\u001d\u0005\u0001\u0004Q\u0014\u0001\u0002;iCR\u00042\u0001F\u001e>\u0013\ta\u0004BA\u0006HK:LE/\u001a:bE2,\u0007C\u0001\r?\t\u0015yDA1\u0001A\u0005\u0005\u0011\u0015CA\f Q\u0011\u0001!)R$\u0011\u0005A\u0019\u0015B\u0001#\u000b\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0002\r\u0006Qfm\u001c:xCJ$\u0017N\\4!SN\u0004\u0013N\u001c5fe\u0016tG\u000f\\=!k:\u0014X\r\\5bE2,\u0007e]5oG\u0016\u0004\u0013\u000e\u001e\u0011jg\u0002rw\u000e\u001e\u0011bkR|W.\u0019;fI\u0002\ng\u000e\u001a\u0011nKRDw\u000eZ:!G\u0006t\u0007EY3!M>\u0014xm\u001c;uK:\f\u0013\u0001S\u0001\u0007e9\n\u0014G\f\u0019")
public interface IterableForwarder<A>
extends Iterable<A>,
TraversableForwarder<A> {
    @Override
    public Iterable<A> underlying();

    public static /* synthetic */ Iterator iterator$(IterableForwarder $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<A> iterator() {
        return this.underlying().iterator();
    }

    public static /* synthetic */ boolean sameElements$(IterableForwarder $this, GenIterable that) {
        return $this.sameElements(that);
    }

    @Override
    default public <B> boolean sameElements(GenIterable<B> that) {
        return this.underlying().sameElements(that);
    }

    public static void $init$(IterableForwarder $this) {
    }
}

