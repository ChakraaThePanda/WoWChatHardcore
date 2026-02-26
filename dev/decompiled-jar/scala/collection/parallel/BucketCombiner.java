/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel;

import scala.Function1;
import scala.collection.Seq;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.Growable;
import scala.collection.mutable.Builder;
import scala.collection.mutable.UnrolledBuffer;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.TaskSupport;
import scala.reflect.ScalaSignature;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\u0005-aAB\b\u0011\u0003\u0003\u0001b\u0003\u0003\u00050\u0001\t\u0015\r\u0011\"\u00031\u0011!!\u0004A!A!\u0002\u0013\t\u0004\"B\u001b\u0001\t\u00031\u0004b\u0002!\u0001\u0001\u0004%\t\"\u0011\u0005\b+\u0002\u0001\r\u0011\"\u0005W\u0011\u0019a\u0006\u0001)Q\u0005\u0005\"9Q\f\u0001a\u0001\n#\u0001\u0004b\u00020\u0001\u0001\u0004%\tb\u0018\u0005\u0007C\u0002\u0001\u000b\u0015B\u0019\t\u000b\t\u0004A\u0011\u0001\u0019\t\u000b\r\u0004A\u0011\u00013\t\u000b\u0015\u0004A\u0011\u00014\t\u000bM\u0004A\u0011\u0001;\t\u000bq\u0004A\u0011A?\u0003\u001d\t+8m[3u\u0007>l'-\u001b8fe*\u0011\u0011CE\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u00111\u0003F\u0001\u000bG>dG.Z2uS>t'\"A\u000b\u0002\u000bM\u001c\u0017\r\\1\u0016\u000b]\u0011S&\u000f\u001f\u0014\u0007\u0001AB\u0004\u0005\u0002\u001a55\tA#\u0003\u0002\u001c)\t1\u0011I\\=SK\u001a\u0004B!\b\u0010!Y5\t\u0001#\u0003\u0002 !\tA1i\\7cS:,'\u000f\u0005\u0002\"E1\u0001AAB\u0012\u0001\u0011\u000b\u0007QE\u0001\u0003FY\u0016l7\u0001A\t\u0003M%\u0002\"!G\u0014\n\u0005!\"\"a\u0002(pi\"Lgn\u001a\t\u00033)J!a\u000b\u000b\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\"[\u00111a\u0006\u0001CC\u0002\u0015\u0012!\u0001V8\u0002\u0019\t,8m[3u]Vl'-\u001a:\u0016\u0003E\u0002\"!\u0007\u001a\n\u0005M\"\"aA%oi\u0006i!-^2lKRtW/\u001c2fe\u0002\na\u0001P5oSRtDCA\u001c@!\u0019i\u0002\u0001\t\u00179wA\u0011\u0011%\u000f\u0003\u0006u\u0001\u0011\r!\n\u0002\u0005\u0005V\u001c7\u000e\u0005\u0002\"y\u00111Q\b\u0001CC\u0002y\u0012AbQ8nE&tWM\u001d+za\u0016\f\"AJ\u001c\t\u000b=\u001a\u0001\u0019A\u0019\u0002\u000f\t,8m[3ugV\t!I\u000b\u0002D\u0019B\u0019\u0011\u0004\u0012$\n\u0005\u0015#\"!B!se\u0006L\bcA$Kq5\t\u0001J\u0003\u0002J%\u00059Q.\u001e;bE2,\u0017BA&I\u00059)fN]8mY\u0016$')\u001e4gKJ\\\u0013!\u0014\t\u0003\u001dNk\u0011a\u0014\u0006\u0003!F\u000b\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0005I#\u0012AC1o]>$\u0018\r^5p]&\u0011Ak\u0014\u0002\u0012k:\u001c\u0007.Z2lK\u00124\u0016M]5b]\u000e,\u0017a\u00032vG.,Go]0%KF$\"a\u0016.\u0011\u0005eA\u0016BA-\u0015\u0005\u0011)f.\u001b;\t\u000fm+\u0011\u0011!a\u0001\u0005\u0006\u0019\u0001\u0010J\u0019\u0002\u0011\t,8m[3ug\u0002\n!a\u001d>\u0002\rMTx\fJ3r)\t9\u0006\rC\u0004\\\u0011\u0005\u0005\t\u0019A\u0019\u0002\u0007MT\b%\u0001\u0003tSj,\u0017!B2mK\u0006\u0014H#A,\u0002\u001b\t,gm\u001c:f\u0007>l'-\u001b8f+\r9G\u000e\u001d\u000b\u0003/\"DQ!\u001b\u0007A\u0002)\fQa\u001c;iKJ\u0004B!\b\u0010l_B\u0011\u0011\u0005\u001c\u0003\u0006[2\u0011\rA\u001c\u0002\u0002\u001dF\u0011a\u0005\t\t\u0003CA$Q!\u001d\u0007C\u0002I\u0014QAT3x)>\f\"\u0001L\u0015\u0002\u0019\u00054G/\u001a:D_6\u0014\u0017N\\3\u0016\u0007UL8\u0010\u0006\u0002Xm\")\u0011.\u0004a\u0001oB!QD\b={!\t\t\u0013\u0010B\u0003n\u001b\t\u0007a\u000e\u0005\u0002\"w\u0012)\u0011/\u0004b\u0001e\u000691m\\7cS:,W#\u0002@\u0002\u0004\u0005\u001dAcA@\u0002\nA1QDHA\u0001\u0003\u000b\u00012!IA\u0002\t\u0015igB1\u0001o!\r\t\u0013q\u0001\u0003\u0006c:\u0011\rA\u001d\u0005\u0006S:\u0001\ra ")
public abstract class BucketCombiner<Elem, To, Buck, CombinerType extends BucketCombiner<Elem, To, Buck, CombinerType>>
implements Combiner<Elem, To> {
    private final int bucketnumber;
    private UnrolledBuffer<Buck>[] buckets;
    private int sz;
    private volatile transient TaskSupport _combinerTaskSupport;

    @Override
    public TaskSupport combinerTaskSupport() {
        return Combiner.combinerTaskSupport$(this);
    }

    @Override
    public void combinerTaskSupport_$eq(TaskSupport cts) {
        Combiner.combinerTaskSupport_$eq$(this, cts);
    }

    @Override
    public boolean canBeShared() {
        return Combiner.canBeShared$(this);
    }

    @Override
    public To resultWithTaskSupport() {
        return (To)Combiner.resultWithTaskSupport$(this);
    }

    @Override
    public void sizeHint(int size) {
        Builder.sizeHint$((Builder)this, size);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll) {
        Builder.sizeHint$((Builder)this, coll);
    }

    @Override
    public void sizeHint(TraversableLike<?, ?> coll, int delta) {
        Builder.sizeHint$(this, coll, delta);
    }

    @Override
    public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
        Builder.sizeHintBounded$(this, size, boundingColl);
    }

    @Override
    public <NewTo> Builder<Elem, NewTo> mapResult(Function1<To, NewTo> f) {
        return Builder.mapResult$(this, f);
    }

    @Override
    public Growable<Elem> $plus$eq(Elem elem1, Elem elem2, Seq<Elem> elems) {
        return Growable.$plus$eq$(this, elem1, elem2, elems);
    }

    @Override
    public Growable<Elem> $plus$plus$eq(TraversableOnce<Elem> xs) {
        return Growable.$plus$plus$eq$(this, xs);
    }

    @Override
    public TaskSupport _combinerTaskSupport() {
        return this._combinerTaskSupport;
    }

    @Override
    public void _combinerTaskSupport_$eq(TaskSupport x$1) {
        this._combinerTaskSupport = x$1;
    }

    private int bucketnumber() {
        return this.bucketnumber;
    }

    public UnrolledBuffer<Buck>[] buckets() {
        return this.buckets;
    }

    public void buckets_$eq(UnrolledBuffer<Buck>[] x$1) {
        this.buckets = x$1;
    }

    public int sz() {
        return this.sz;
    }

    public void sz_$eq(int x$1) {
        this.sz = x$1;
    }

    @Override
    public int size() {
        return this.sz();
    }

    @Override
    public void clear() {
        this.buckets_$eq(new UnrolledBuffer[this.bucketnumber()]);
        this.sz_$eq(0);
    }

    public <N extends Elem, NewTo> void beforeCombine(Combiner<N, NewTo> other) {
    }

    public <N extends Elem, NewTo> void afterCombine(Combiner<N, NewTo> other) {
    }

    @Override
    public <N extends Elem, NewTo> Combiner<N, NewTo> combine(Combiner<N, NewTo> other) {
        BucketCombiner that;
        if (this == other) {
            return this;
        }
        if (other instanceof BucketCombiner) {
            this.beforeCombine(other);
            that = (BucketCombiner)other;
            for (int i = 0; i < this.bucketnumber(); ++i) {
                if (this.buckets()[i] == null) {
                    this.buckets()[i] = that.buckets()[i];
                    continue;
                }
                if (that.buckets()[i] == null) continue;
                this.buckets()[i].concat(that.buckets()[i]);
            }
        } else {
            throw package$.MODULE$.error("Unexpected combiner type.");
        }
        this.sz_$eq(this.sz() + that.size());
        this.afterCombine(other);
        return this;
    }

    public BucketCombiner(int bucketnumber) {
        this.bucketnumber = bucketnumber;
        Growable.$init$(this);
        Builder.$init$(this);
        Combiner.$init$(this);
        this.buckets = new UnrolledBuffer[bucketnumber];
        this.sz = 0;
    }
}

