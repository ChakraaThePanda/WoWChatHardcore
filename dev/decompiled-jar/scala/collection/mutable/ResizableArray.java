/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.Function4;
import scala.Function5;
import scala.Predef$;
import scala.Some;
import scala.collection.GenTraversable;
import scala.collection.Seq;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.GenTraversableFactory;
import scala.collection.generic.GenericCompanion;
import scala.collection.mutable.Builder;
import scala.collection.mutable.IndexedSeq;
import scala.collection.mutable.IndexedSeqOptimized;
import scala.collection.mutable.ResizableArray$;
import scala.compat.Platform$;
import scala.math.Integral;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005}ca\u0002\f\u0018!\u0003\r\tA\b\u0005\u0006}\u0001!\ta\u0010\u0005\u0006\u0007\u0002!\t\u0005\u0012\u0005\u0006\u0011\u0002!\t\"\u0013\u0005\b\u001b\u0002\u0001\r\u0011\"\u0005O\u0011\u001d\u0011\u0006\u00011A\u0005\u0012MCqA\u0016\u0001A\u0002\u0013E\u0011\nC\u0004X\u0001\u0001\u0007I\u0011\u0003-\t\u000bi\u0003A\u0011A%\t\u000bm\u0003A\u0011\u0001/\t\u000b}\u0003A\u0011\u00011\t\u000b\u0011\u0004A\u0011I3\t\u000b=\u0004A\u0011\t9\t\u000bu\u0004A\u0011\u0001@\t\u000f\u0005\r\u0001\u0001\"\u0005\u0002\u0006!9\u00111\u0002\u0001\u0005\u0012\u00055\u0001bBA\f\u0001\u0011E\u0011\u0011D\u0004\b\u0003G9\u0002\u0012AA\u0013\r\u00191r\u0003#\u0001\u0002(!9\u0011q\u0006\n\u0005\u0002\u0005E\u0002bBA\u001a%\u0011\r\u0011Q\u0007\u0005\b\u0003\u001b\u0012B\u0011AA(\u00059\u0011Vm]5{C\ndW-\u0011:sCfT!\u0001G\r\u0002\u000f5,H/\u00192mK*\u0011!dG\u0001\u000bG>dG.Z2uS>t'\"\u0001\u000f\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0011qDK\n\u0006\u0001\u0001\"3G\u000f\t\u0003C\tj\u0011aG\u0005\u0003Gm\u0011a!\u00118z%\u00164\u0007cA\u0013'Q5\tq#\u0003\u0002(/\tQ\u0011J\u001c3fq\u0016$7+Z9\u0011\u0005%RC\u0002\u0001\u0003\u0006W\u0001\u0011\r\u0001\f\u0002\u0002\u0003F\u0011Q\u0006\r\t\u0003C9J!aL\u000e\u0003\u000f9{G\u000f[5oOB\u0011\u0011%M\u0005\u0003em\u00111!\u00118z!\u0011!t\u0007K\u001d\u000e\u0003UR!AN\r\u0002\u000f\u001d,g.\u001a:jG&\u0011\u0001(\u000e\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u0003K\u0001\u0001B!J\u001e){%\u0011Ah\u0006\u0002\u0014\u0013:$W\r_3e'\u0016\fx\n\u001d;j[&TX\r\u001a\t\u0004K\u0001A\u0013A\u0002\u0013j]&$H\u0005F\u0001A!\t\t\u0013)\u0003\u0002C7\t!QK\\5u\u0003%\u0019w.\u001c9b]&|g.F\u0001F!\r!d)O\u0005\u0003\u000fV\u0012\u0001cR3oKJL7mQ8na\u0006t\u0017n\u001c8\u0002\u0017%t\u0017\u000e^5bYNK'0Z\u000b\u0002\u0015B\u0011\u0011eS\u0005\u0003\u0019n\u00111!\u00138u\u0003\u0015\t'O]1z+\u0005y\u0005cA\u0011QA%\u0011\u0011k\u0007\u0002\u0006\u0003J\u0014\u0018-_\u0001\nCJ\u0014\u0018-_0%KF$\"\u0001\u0011+\t\u000fU+\u0011\u0011!a\u0001\u001f\u0006\u0019\u0001\u0010J\u0019\u0002\u000bML'0\u001a\u0019\u0002\u0013ML'0\u001a\u0019`I\u0015\fHC\u0001!Z\u0011\u001d)v!!AA\u0002)\u000ba\u0001\\3oORD\u0017!B1qa2LHC\u0001\u0015^\u0011\u0015q\u0016\u00021\u0001K\u0003\rIG\r_\u0001\u0007kB$\u0017\r^3\u0015\u0007\u0001\u000b'\rC\u0003_\u0015\u0001\u0007!\nC\u0003d\u0015\u0001\u0007\u0001&\u0001\u0003fY\u0016l\u0017a\u00024pe\u0016\f7\r[\u000b\u0003M6$\"\u0001Q4\t\u000b!\\\u0001\u0019A5\u0002\u0003\u0019\u0004B!\t6)Y&\u00111n\u0007\u0002\n\rVt7\r^5p]F\u0002\"!K7\u0005\u000b9\\!\u0019\u0001\u0017\u0003\u0003U\u000b1bY8qsR{\u0017I\u001d:bsV\u0011\u0011O\u001e\u000b\u0005\u0001JL8\u0010C\u0003t\u0019\u0001\u0007A/\u0001\u0002ygB\u0019\u0011\u0005U;\u0011\u0005%2H!B<\r\u0005\u0004A(!\u0001\"\u0012\u0005!\u0002\u0004\"\u0002>\r\u0001\u0004Q\u0015!B:uCJ$\b\"\u0002?\r\u0001\u0004Q\u0015a\u00017f]\u0006a!/\u001a3vG\u0016$vnU5{KR\u0011\u0001i \u0005\u0007\u0003\u0003i\u0001\u0019\u0001&\u0002\u0005MT\u0018AC3ogV\u0014XmU5{KR\u0019\u0001)a\u0002\t\r\u0005%a\u00021\u0001K\u0003\u0005q\u0017\u0001B:xCB$R\u0001QA\b\u0003'Aa!!\u0005\u0010\u0001\u0004Q\u0015!A1\t\r\u0005Uq\u00021\u0001K\u0003\u0005\u0011\u0017\u0001B2paf$r\u0001QA\u000e\u0003?\t\t\u0003\u0003\u0004\u0002\u001eA\u0001\rAS\u0001\u0002[\"1\u0011\u0011\u0002\tA\u0002)CQ\u0001 \tA\u0002)\u000baBU3tSj\f'\r\\3BeJ\f\u0017\u0010\u0005\u0002&%M\u0019!#!\u000b\u0011\tQ\nY#O\u0005\u0004\u0003[)$AC*fc\u001a\u000b7\r^8ss\u00061A(\u001b8jiz\"\"!!\n\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\t\u0005]\u0012\u0011J\u000b\u0003\u0003s\u0001\u0012\u0002NA\u001e\u0003\u007f\t9%a\u0013\n\u0007\u0005uRG\u0001\u0007DC:\u0014U/\u001b7e\rJ|W\u000e\u0005\u0003\u0002B\u0005\rS\"\u0001\n\n\u0007\u0005\u0015cI\u0001\u0003D_2d\u0007cA\u0015\u0002J\u0011)1\u0006\u0006b\u0001YA!Q\u0005AA$\u0003)qWm\u001e\"vS2$WM]\u000b\u0005\u0003#\nY&\u0006\u0002\u0002TA9Q%!\u0016\u0002Z\u0005u\u0013bAA,/\t9!)^5mI\u0016\u0014\bcA\u0015\u0002\\\u0011)1&\u0006b\u0001YA!Q\u0005AA-\u0001")
public interface ResizableArray<A>
extends IndexedSeq<A>,
IndexedSeqOptimized<A, ResizableArray<A>> {
    public static <A> CanBuildFrom<ResizableArray<?>, A, ResizableArray<A>> canBuildFrom() {
        return ResizableArray$.MODULE$.canBuildFrom();
    }

    public static Some unapplySeq(Seq seq) {
        return ResizableArray$.MODULE$.unapplySeq(seq);
    }

    public static GenTraversable iterate(Object object, int n, Function1 function1) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        Builder iterate_b = ((GenericCompanion)resizableArray$).newBuilder();
        if (n > 0) {
            iterate_b.sizeHint(n);
            Object iterate_acc = object;
            iterate_b.$plus$eq(object);
            for (int iterate_i = 1; iterate_i < n; ++iterate_i) {
                iterate_acc = function1.apply(iterate_acc);
                iterate_b.$plus$eq(iterate_acc);
            }
        }
        return (GenTraversable)iterate_b.result();
    }

    public static GenTraversable range(Object object, Object object2, Object object3, Integral integral) {
        return ResizableArray$.MODULE$.range(object, object2, object3, integral);
    }

    public static GenTraversable range(Object object, Object object2, Integral integral) {
        return ResizableArray$.MODULE$.range(object, object2, integral);
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, int n5, Function5 function5) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        ResizableArray$ tabulate_this = resizableArray$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$7$adapted(tabulate_this, n2, n3, n4, n5, function5, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, int n4, Function4 function4) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        ResizableArray$ tabulate_this = resizableArray$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$5$adapted(tabulate_this, n2, n3, n4, function4, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, int n3, Function3 function3) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        ResizableArray$ tabulate_this = resizableArray$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$3$adapted(tabulate_this, n2, n3, function3, arg_0));
    }

    public static GenTraversable tabulate(int n, int n2, Function2 function2) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        ResizableArray$ tabulate_this = resizableArray$;
        return tabulate_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$tabulate$1$adapted(tabulate_this, n2, function2, arg_0));
    }

    public static GenTraversable tabulate(int n, Function1 function1) {
        return ResizableArray$.MODULE$.tabulate(n, function1);
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, int n5, Function0 function0) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        ResizableArray$ fill_this = resizableArray$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$4$adapted(fill_this, n2, n3, n4, n5, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, int n4, Function0 function0) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        ResizableArray$ fill_this = resizableArray$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$3$adapted(fill_this, n2, n3, n4, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, int n3, Function0 function0) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        ResizableArray$ fill_this = resizableArray$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$2$adapted(fill_this, n2, n3, function0, arg_0));
    }

    public static GenTraversable fill(int n, int n2, Function0 function0) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        ResizableArray$ fill_this = resizableArray$;
        return fill_this.tabulate(n, arg_0 -> GenTraversableFactory.$anonfun$fill$1$adapted(fill_this, n2, function0, arg_0));
    }

    public static GenTraversable fill(int n, Function0 function0) {
        ResizableArray$ resizableArray$ = ResizableArray$.MODULE$;
        if (resizableArray$ == null) {
            throw null;
        }
        Builder fill_b = ((GenericCompanion)resizableArray$).newBuilder();
        fill_b.sizeHint(n);
        for (int fill_i = 0; fill_i < n; ++fill_i) {
            fill_b.$plus$eq(function0.apply());
        }
        return (GenTraversable)fill_b.result();
    }

    public static GenTraversable concat(Seq seq) {
        return ResizableArray$.MODULE$.concat(seq);
    }

    public static GenTraversableFactory.GenericCanBuildFrom<Nothing$> ReusableCBF() {
        return ResizableArray$.MODULE$.ReusableCBF();
    }

    public static GenTraversable empty() {
        return ResizableArray$.MODULE$.empty();
    }

    public static /* synthetic */ GenericCompanion companion$(ResizableArray $this) {
        return $this.companion();
    }

    @Override
    default public GenericCompanion<ResizableArray> companion() {
        return ResizableArray$.MODULE$;
    }

    public static /* synthetic */ int initialSize$(ResizableArray $this) {
        return $this.initialSize();
    }

    default public int initialSize() {
        return 16;
    }

    public Object[] array();

    public void array_$eq(Object[] var1);

    public int size0();

    public void size0_$eq(int var1);

    public static /* synthetic */ int length$(ResizableArray $this) {
        return $this.length();
    }

    @Override
    default public int length() {
        return this.size0();
    }

    public static /* synthetic */ Object apply$(ResizableArray $this, int idx) {
        return $this.apply(idx);
    }

    @Override
    default public A apply(int idx) {
        if (idx >= this.size0()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }
        return (A)this.array()[idx];
    }

    public static /* synthetic */ void update$(ResizableArray $this, int idx, Object elem) {
        $this.update(idx, elem);
    }

    @Override
    default public void update(int idx, A elem) {
        if (idx >= this.size0()) {
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(idx)).toString());
        }
        this.array()[idx] = elem;
    }

    public static /* synthetic */ void foreach$(ResizableArray $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<A, U> f) {
        int top = this.size();
        for (int i = 0; i < top; ++i) {
            f.apply(this.array()[i]);
        }
    }

    public static /* synthetic */ void copyToArray$(ResizableArray $this, Object xs, int start, int len) {
        $this.copyToArray(xs, start, len);
    }

    @Override
    default public <B> void copyToArray(Object xs, int start, int len) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int n = RichInt$.MODULE$.min$extension(len, ScalaRunTime$.MODULE$.array_length(xs) - start);
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int len1 = RichInt$.MODULE$.min$extension(n, this.length());
        if (len1 > 0) {
            Array$.MODULE$.copy(this.array(), 0, xs, start, len1);
        }
    }

    public static /* synthetic */ void reduceToSize$(ResizableArray $this, int sz) {
        $this.reduceToSize(sz);
    }

    default public void reduceToSize(int sz) {
        Predef$.MODULE$.require(sz <= this.size0());
        while (this.size0() > sz) {
            this.size0_$eq(this.size0() - 1);
            this.array()[this.size0()] = null;
        }
    }

    public static /* synthetic */ void ensureSize$(ResizableArray $this, int n) {
        $this.ensureSize(n);
    }

    default public void ensureSize(int n) {
        long arrayLength = this.array().length;
        if ((long)n > arrayLength) {
            long newSize;
            for (newSize = arrayLength * 2L; (long)n > newSize; newSize *= 2L) {
            }
            if (newSize > Integer.MAX_VALUE) {
                newSize = Integer.MAX_VALUE;
            }
            Object[] newArray = new Object[(int)newSize];
            System.arraycopy(this.array(), 0, newArray, 0, this.size0());
            this.array_$eq(newArray);
        }
    }

    public static /* synthetic */ void swap$(ResizableArray $this, int a, int b) {
        $this.swap(a, b);
    }

    default public void swap(int a, int b) {
        Object h = this.array()[a];
        this.array()[a] = this.array()[b];
        this.array()[b] = h;
    }

    public static /* synthetic */ void copy$(ResizableArray $this, int m, int n, int len) {
        $this.copy(m, n, len);
    }

    /*
     * WARNING - void declaration
     */
    default public void copy(int m, int n, int len) {
        void arraycopy_dest;
        void arraycopy_src;
        Object[] objectArray = this.array();
        Object[] objectArray2 = this.array();
        if (Platform$.MODULE$ == null) {
            throw null;
        }
        System.arraycopy(arraycopy_src, m, arraycopy_dest, n, len);
    }

    public static void $init$(ResizableArray $this) {
        $this.array_$eq(new Object[package$.MODULE$.max($this.initialSize(), 1)]);
        $this.size0_$eq(0);
    }
}

