/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableProxyLike;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.collection.MapLike;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.mutable.StringBuilder;
import scala.reflect.ScalaSignature;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u0005\u0005ha\u0002\r\u001a!\u0003\r\tA\b\u0005\u0006\r\u0002!\ta\u0012\u0005\u0006\u0017\u0002!\t\u0005\u0014\u0005\u0006%\u0002!\te\u0015\u0005\u0006/\u0002!\t\u0005\u0017\u0005\u0006E\u0002!\te\u0019\u0005\u0006K\u0002!\tE\u001a\u0005\u0006U\u0002!\te\u001b\u0005\u0006k\u0002!\tE\u001e\u0005\u0006q\u0002!\t%\u001f\u0005\u0006w\u0002!\t\u0005 \u0005\u0006}\u0002!\te \u0005\b\u0003\u000f\u0001A\u0011IA\u0005\u0011\u001d\ti\u0001\u0001C!\u0003\u001fAq!a\u0006\u0001\t\u0003\nI\u0002C\u0004\u0002\u001e\u0001!\t%a\b\t\rE\u0004A\u0011IA\u0012\u0011\u001d\t9\u0003\u0001C!\u0003SAq!!\u000e\u0001\t\u0003\n9\u0004C\u0004\u0002J\u0001!\t%a\u0013\t\r]\u0003A\u0011IA.\u0011\u001d\tI\b\u0001C!\u0003wBq!!%\u0001\t\u0003\n\u0019\nC\u0004\u0002\u001a\u0002!\t%a'\u0003\u00195\u000b\u0007\u000f\u0015:pqfd\u0015n[3\u000b\u0005iY\u0012AC2pY2,7\r^5p]*\tA$A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\t}QCgN\n\u0005\u0001\u0001\"\u0003\t\u0005\u0002\"E5\t1$\u0003\u0002$7\t1\u0011I\\=SK\u001a\u0004R!\n\u0014)gYj\u0011!G\u0005\u0003Oe\u0011q!T1q\u0019&\\W\r\u0005\u0002*U1\u0001A!B\u0016\u0001\u0005\u0004a#!A!\u0012\u00055\u0002\u0004CA\u0011/\u0013\ty3DA\u0004O_RD\u0017N\\4\u0011\u0005\u0005\n\u0014B\u0001\u001a\u001c\u0005\r\te.\u001f\t\u0003SQ\"a!\u000e\u0001\u0005\u0006\u0004a#!\u0001\"\u0011\u0005%:DA\u0002\u001d\u0001\t\u000b\u0007\u0011H\u0001\u0003UQ&\u001c\u0018CA\u0017;%\rYD%\u0010\u0004\u0005y\u0001\u0001!H\u0001\u0007=e\u00164\u0017N\\3nK:$h\b\u0005\u0003&}!\u001a\u0014BA \u001a\u0005\ri\u0015\r\u001d\t\u0005K\u0005\u001be'\u0003\u0002C3\t\t\u0012\n^3sC\ndW\r\u0015:pqfd\u0015n[3\u0011\t\u0005\"\u0005fM\u0005\u0003\u000bn\u0011a\u0001V;qY\u0016\u0014\u0014A\u0002\u0013j]&$H\u0005F\u0001I!\t\t\u0013*\u0003\u0002K7\t!QK\\5u\u0003\r9W\r\u001e\u000b\u0003\u001bB\u00032!\t(4\u0013\ty5D\u0001\u0004PaRLwN\u001c\u0005\u0006#\n\u0001\r\u0001K\u0001\u0004W\u0016L\u0018\u0001C5uKJ\fGo\u001c:\u0016\u0003Q\u00032!J+D\u0013\t1\u0016D\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003\u0015!\u0003\u000f\\;t+\tIF\f\u0006\u0002[?B!QE\u0010\u0015\\!\tIC\fB\u0003^\t\t\u0007aL\u0001\u0002CcE\u00111\u0007\r\u0005\u0006A\u0012\u0001\r!Y\u0001\u0003WZ\u0004B!\t#)7\u00061A%\\5okN$\"A\u000e3\t\u000bE+\u0001\u0019\u0001\u0015\u0002\u000f%\u001cX)\u001c9usV\tq\r\u0005\u0002\"Q&\u0011\u0011n\u0007\u0002\b\u0005>|G.Z1o\u0003%9W\r^(s\u000b2\u001cX-\u0006\u0002m]R\u0019Qn\u001c9\u0011\u0005%rG!B/\b\u0005\u0004q\u0006\"B)\b\u0001\u0004A\u0003BB9\b\t\u0003\u0007!/A\u0004eK\u001a\fW\u000f\u001c;\u0011\u0007\u0005\u001aX.\u0003\u0002u7\tAAHY=oC6,g(A\u0003baBd\u0017\u0010\u0006\u00024o\")\u0011\u000b\u0003a\u0001Q\u0005A1m\u001c8uC&t7\u000f\u0006\u0002hu\")\u0011+\u0003a\u0001Q\u0005Y\u0011n\u001d#fM&tW\rZ!u)\t9W\u0010C\u0003R\u0015\u0001\u0007\u0001&\u0001\u0004lKf\u001cV\r^\u000b\u0003\u0003\u0003\u0001B!JA\u0002Q%\u0019\u0011QA\r\u0003\u0007M+G/\u0001\u0007lKf\u001c\u0018\n^3sCR|'/\u0006\u0002\u0002\fA\u0019Q%\u0016\u0015\u0002\t-,\u0017p]\u000b\u0003\u0003#\u0001B!JA\nQ%\u0019\u0011QC\r\u0003\u0011%#XM]1cY\u0016\faA^1mk\u0016\u001cXCAA\u000e!\u0011)\u00131C\u001a\u0002\u001dY\fG.^3t\u0013R,'/\u0019;peV\u0011\u0011\u0011\u0005\t\u0004KU\u001bDcA\u001a\u0002&!)\u0011\u000b\u0005a\u0001Q\u0005Qa-\u001b7uKJ\\U-_:\u0015\u0007u\nY\u0003C\u0004\u0002.E\u0001\r!a\f\u0002\u0003A\u0004R!IA\u0019Q\u001dL1!a\r\u001c\u0005%1UO\\2uS>t\u0017'A\u0005nCB4\u0016\r\\;fgV!\u0011\u0011HA )\u0011\tY$a\u0011\u0011\u000b\u0015r\u0004&!\u0010\u0011\u0007%\ny\u0004\u0002\u0004\u0002BI\u0011\r\u0001\f\u0002\u0002\u0007\"9\u0011Q\t\nA\u0002\u0005\u001d\u0013!\u00014\u0011\r\u0005\n\tdMA\u001f\u0003\u001d)\b\u000fZ1uK\u0012,B!!\u0014\u0002TQ1\u0011qJA+\u0003/\u0002R!\n )\u0003#\u00022!KA*\t\u0015i6C1\u0001_\u0011\u0015\t6\u00031\u0001)\u0011\u001d\tIf\u0005a\u0001\u0003#\nQA^1mk\u0016,B!!\u0018\u0002dQA\u0011qLA3\u0003W\ny\u0007E\u0003&}!\n\t\u0007E\u0002*\u0003G\"Q!\u0018\u000bC\u0002yCq!a\u001a\u0015\u0001\u0004\tI'A\u0002lmF\u0002R!\t#)\u0003CBq!!\u001c\u0015\u0001\u0004\tI'A\u0002lmJBq!!\u001d\u0015\u0001\u0004\t\u0019(A\u0002lmN\u0004R!IA;\u0003SJ1!a\u001e\u001c\u0005)a$/\u001a9fCR,GMP\u0001\u000bIAdWo\u001d\u0013qYV\u001cX\u0003BA?\u0003\u0007#B!a \u0002\u0006B)QE\u0010\u0015\u0002\u0002B\u0019\u0011&a!\u0005\u000bu+\"\u0019\u00010\t\u000f\u0005\u001dU\u00031\u0001\u0002\n\u0006\u0011\u0001p\u001d\t\u0006K\u0005-\u0015qR\u0005\u0004\u0003\u001bK\"AE$f]R\u0013\u0018M^3sg\u0006\u0014G.Z(oG\u0016\u0004R!\t#)\u0003\u0003\u000b\u0011BZ5mi\u0016\u0014hj\u001c;\u0015\u0007Y\n)\nC\u0004\u0002.Y\u0001\r!a&\u0011\u000b\u0005\n\tdQ4\u0002\u0013\u0005$Gm\u0015;sS:<GCCAO\u0003W\u000by+!3\u0002NB!\u0011qTAS\u001d\r\t\u0013\u0011U\u0005\u0004\u0003G[\u0012a\u00029bG.\fw-Z\u0005\u0005\u0003O\u000bIKA\u0007TiJLgn\u001a\"vS2$WM\u001d\u0006\u0004\u0003G[\u0002bBAW/\u0001\u0007\u0011QT\u0001\u0002E\"9\u0011\u0011W\fA\u0002\u0005M\u0016!B:uCJ$\b\u0003BA[\u0003\u0007tA!a.\u0002@B\u0019\u0011\u0011X\u000e\u000e\u0005\u0005m&bAA_;\u00051AH]8pizJ1!!1\u001c\u0003\u0019\u0001&/\u001a3fM&!\u0011QYAd\u0005\u0019\u0019FO]5oO*\u0019\u0011\u0011Y\u000e\t\u000f\u0005-w\u00031\u0001\u00024\u0006\u00191/\u001a9\t\u000f\u0005=w\u00031\u0001\u00024\u0006\u0019QM\u001c3)\u000f\u0001\t\u0019.!7\u0002^B\u0019\u0011%!6\n\u0007\u0005]7D\u0001\u0006eKB\u0014XmY1uK\u0012\f#!a7\u0002\tB\u0014x\u000e_=j]\u001e\u0004\u0013n\u001d\u0011eKB\u0014XmY1uK\u0012\u0004C-^3!i>\u0004C.Y2lA=4\u0007%^:fA\u0005tG\rI2p[BLG.\u001a:.Y\u00164X\r\u001c\u0011tkB\u0004xN\u001d;\"\u0005\u0005}\u0017A\u0002\u001a/cEr\u0003\u0007")
public interface MapProxyLike<A, B, This extends MapLike<A, B, This> & Map<A, B>>
extends MapLike<A, B, This>,
IterableProxyLike<Tuple2<A, B>, This> {
    public static /* synthetic */ Option get$(MapProxyLike $this, Object key) {
        return $this.get((A)key);
    }

    @Override
    default public Option<B> get(A key) {
        return ((MapLike)this.self()).get(key);
    }

    public static /* synthetic */ Iterator iterator$(MapProxyLike $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<Tuple2<A, B>> iterator() {
        return ((MapLike)this.self()).iterator();
    }

    public static /* synthetic */ Map $plus$(MapProxyLike $this, Tuple2 kv) {
        return $this.$plus(kv);
    }

    @Override
    default public <B1> Map<A, B1> $plus(Tuple2<A, B1> kv) {
        return ((MapLike)this.self()).$plus(kv);
    }

    public static /* synthetic */ Map $minus$(MapProxyLike $this, Object key) {
        return $this.$minus((A)key);
    }

    @Override
    default public This $minus(A key) {
        return ((MapLike)this.self()).$minus(key);
    }

    public static /* synthetic */ boolean isEmpty$(MapProxyLike $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        return ((MapLike)this.self()).isEmpty();
    }

    public static /* synthetic */ Object getOrElse$(MapProxyLike $this, Object key, Function0 function0) {
        return $this.getOrElse((A)key, function0);
    }

    @Override
    default public <B1> B1 getOrElse(A key, Function0<B1> function0) {
        return ((MapLike)this.self()).getOrElse(key, function0);
    }

    public static /* synthetic */ Object apply$(MapProxyLike $this, Object key) {
        return $this.apply((A)key);
    }

    @Override
    default public B apply(A key) {
        return (B)((MapLike)this.self()).apply(key);
    }

    public static /* synthetic */ boolean contains$(MapProxyLike $this, Object key) {
        return $this.contains((A)key);
    }

    @Override
    default public boolean contains(A key) {
        return ((MapLike)this.self()).contains(key);
    }

    public static /* synthetic */ boolean isDefinedAt$(MapProxyLike $this, Object key) {
        return $this.isDefinedAt((A)key);
    }

    @Override
    default public boolean isDefinedAt(A key) {
        return ((MapLike)this.self()).isDefinedAt(key);
    }

    public static /* synthetic */ Set keySet$(MapProxyLike $this) {
        return $this.keySet();
    }

    @Override
    default public Set<A> keySet() {
        return ((MapLike)this.self()).keySet();
    }

    public static /* synthetic */ Iterator keysIterator$(MapProxyLike $this) {
        return $this.keysIterator();
    }

    @Override
    default public Iterator<A> keysIterator() {
        return ((MapLike)this.self()).keysIterator();
    }

    public static /* synthetic */ Iterable keys$(MapProxyLike $this) {
        return $this.keys();
    }

    @Override
    default public Iterable<A> keys() {
        return ((MapLike)this.self()).keys();
    }

    public static /* synthetic */ Iterable values$(MapProxyLike $this) {
        return $this.values();
    }

    @Override
    default public Iterable<B> values() {
        return ((MapLike)this.self()).values();
    }

    public static /* synthetic */ Iterator valuesIterator$(MapProxyLike $this) {
        return $this.valuesIterator();
    }

    @Override
    default public Iterator<B> valuesIterator() {
        return ((MapLike)this.self()).valuesIterator();
    }

    public static /* synthetic */ Object default$(MapProxyLike $this, Object key) {
        return $this.default((A)key);
    }

    @Override
    default public B default(A key) {
        return (B)((MapLike)this.self()).default(key);
    }

    public static /* synthetic */ Map filterKeys$(MapProxyLike $this, Function1 p) {
        return $this.filterKeys(p);
    }

    @Override
    default public Map<A, B> filterKeys(Function1<A, Object> p) {
        return ((MapLike)this.self()).filterKeys(p);
    }

    public static /* synthetic */ Map mapValues$(MapProxyLike $this, Function1 f) {
        return $this.mapValues(f);
    }

    @Override
    default public <C> Map<A, C> mapValues(Function1<B, C> f) {
        return ((MapLike)this.self()).mapValues(f);
    }

    public static /* synthetic */ Map updated$(MapProxyLike $this, Object key, Object value) {
        return $this.updated((A)key, (B1)value);
    }

    @Override
    default public <B1> Map<A, B1> updated(A key, B1 value) {
        return ((MapLike)this.self()).updated(key, value);
    }

    public static /* synthetic */ Map $plus$(MapProxyLike $this, Tuple2 kv1, Tuple2 kv2, Seq kvs) {
        return $this.$plus(kv1, kv2, kvs);
    }

    @Override
    default public <B1> Map<A, B1> $plus(Tuple2<A, B1> kv1, Tuple2<A, B1> kv2, Seq<Tuple2<A, B1>> kvs) {
        return ((MapLike)this.self()).$plus(kv1, kv2, kvs);
    }

    public static /* synthetic */ Map $plus$plus$(MapProxyLike $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    @Override
    default public <B1> Map<A, B1> $plus$plus(GenTraversableOnce<Tuple2<A, B1>> xs) {
        return ((MapLike)this.self()).$plus$plus(xs);
    }

    public static /* synthetic */ Map filterNot$(MapProxyLike $this, Function1 p) {
        return $this.filterNot(p);
    }

    @Override
    default public This filterNot(Function1<Tuple2<A, B>, Object> p) {
        return ((MapLike)this.self()).filterNot(p);
    }

    public static /* synthetic */ StringBuilder addString$(MapProxyLike $this, StringBuilder b, String start, String sep, String end) {
        return $this.addString(b, start, sep, end);
    }

    @Override
    default public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return ((MapLike)this.self()).addString(b, start, sep, end);
    }

    public static void $init$(MapProxyLike $this) {
    }
}

