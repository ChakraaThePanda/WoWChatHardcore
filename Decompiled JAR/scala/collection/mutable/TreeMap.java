/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.AbstractSortedMap;
import scala.collection.mutable.Builder;
import scala.collection.mutable.MapLike;
import scala.collection.mutable.RedBlackTree;
import scala.collection.mutable.RedBlackTree$;
import scala.collection.mutable.RedBlackTree$Tree$;
import scala.collection.mutable.TreeMap$;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\tUu!\u0002\u001f>\u0011\u0003!e!\u0002$>\u0011\u00039\u0005bBA\u0004\u0003\u0011\u0005!q\n\u0005\b\u00033\tA\u0011\u0001B)\u0011\u001d\u0011\u0019'\u0001C\u0002\u0005KB\u0011Ba#\u0002\u0003\u0003%IA!$\u0007\t\u0019k\u0004c\u0014\u0005\tc\u001a\u0011\t\u0011)A\u0005e\"A\u0011P\u0002BC\u0002\u0013\r!\u0010C\u0005\u0002\u0006\u0019\u0011\t\u0011)A\u0005w\"9\u0011q\u0001\u0004\u0005\n\u0005%\u0001bBA\u0004\r\u0011\u0005\u0011\u0011\u0003\u0005\b\u000331A\u0011IA\u000e\u0011!\tiB\u0002Q\u0005R\u0005}\u0001bBA\u0017\r\u0011\u0005\u0011q\u0006\u0005\b\u0003\u007f1A\u0011AA!\u0011\u001d\tIE\u0002C\u0001\u0003\u0017Bq!!\u0015\u0007\t\u0003\t\u0019\u0006C\u0004\u0002Z\u0019!\t!a\u0017\t\u000f\u0005\rd\u0001\"\u0001\u0002f!9\u00111\u000e\u0004\u0005\u0002\u00055\u0004bBA:\r\u0011\u0005\u0011Q\u000f\u0005\b\u0003w2A\u0011IA?\u0011\u001d\t)I\u0002C!\u0003\u000fCq!a$\u0007\t\u0003\n\t\nC\u0004\u0002\u0016\u001a!\t%a&\t\u000f\u0005ee\u0001\"\u0011\u0002\u001c\"9\u0011q\u0014\u0004\u0005B\u0005]\u0005bBAQ\r\u0011\u0005\u00131\u0014\u0005\b\u0003G3A\u0011IAS\u0011\u001d\t9K\u0002C!\u0003SCq!a+\u0007\t\u0003\ni\u000bC\u0004\u0002H\u001a!\t%!3\t\u000f\u0005Mg\u0001\"\u0011\u0002V\"9\u0011q\u001b\u0004\u0005B\u0005eg\u0001CAv\r\u0001\u0006i!!<\t\u0015\u0005M2E!A!\u0002\u0013\t)\u0004\u0003\u0006\u0002>\r\u0012\t\u0011)A\u0005\u0003kAq!a\u0002$\t\u0003\ty\u000f\u0003\u0005\u0002x\u000e\u0002K\u0011BA}\u0011!\typ\tQ\u0005\n\t\u0005\u0001\u0002\u0003B\u0004G\u0001&IA!\u0003\t\u000f\u000552\u0005\"\u0011\u0003\u000e!9\u0011\u0011K\u0012\u0005B\tM\u0001bBA-G\u0011\u0005\u00131\f\u0005\b\u0003G\u001aC\u0011\tB\f\u0011\u001d\tYg\tC!\u00057Aq!a\u001d$\t\u0003\u0012y\u0002C\u0004\u0002|\r\"\t%! \t\u000f\u0005\u00155\u0005\"\u0011\u0002\b\"9\u0011qR\u0012\u0005B\t\r\u0002bBAKG\u0011\u0005\u0013q\u0013\u0005\b\u00033\u001bC\u0011IAN\u0011\u001d\tyj\tC!\u0003/Cq!!)$\t\u0003\nY\nC\u0004\u0002,\u000e\"\tEa\n\t\u000f\u0005\u001d7\u0005\"\u0011\u00034!9\u0011qU\u0012\u0005B\u0005%\u0006bBARG\u0011\u0005\u0013Q\u0015\u0005\b\u0005s\u0019C\u0011\tB\u001e\u0003\u001d!&/Z3NCBT!AP \u0002\u000f5,H/\u00192mK*\u0011\u0001)Q\u0001\u000bG>dG.Z2uS>t'\"\u0001\"\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001A\u0011Q)A\u0007\u0002{\t9AK]3f\u001b\u0006\u00048cA\u0001I]B\u0019\u0011\n\u0014(\u000e\u0003)S!aS \u0002\u000f\u001d,g.\u001a:jG&\u0011QJ\u0013\u0002\u0018\u001bV$\u0018M\u00197f'>\u0014H/\u001a3NCB4\u0015m\u0019;pef\u0004\"!\u0012\u0004\u0016\u0007A3\u0016m\u0005\u0004\u0007#\u000e4'N\u001c\t\u0005\u000bJ#\u0006-\u0003\u0002T{\t\t\u0012IY:ue\u0006\u001cGoU8si\u0016$W*\u00199\u0011\u0005U3F\u0002\u0001\u0003\u0006/\u001a\u0011\r\u0001\u0017\u0002\u0002\u0003F\u0011\u0011,\u0018\t\u00035nk\u0011!Q\u0005\u00039\u0006\u0013qAT8uQ&tw\r\u0005\u0002[=&\u0011q,\u0011\u0002\u0004\u0003:L\bCA+b\t\u0015\u0011gA1\u0001Y\u0005\u0005\u0011\u0005\u0003B#e)\u0002L!!Z\u001f\u0003\u0013M{'\u000f^3e\u001b\u0006\u0004\b#B#h)\u0002L\u0017B\u00015>\u0005\u001di\u0015\r\u001d'jW\u0016\u0004B!\u0012\u0004UAB)1\u000e\u001c+aS6\tq(\u0003\u0002n\u007f\ti1k\u001c:uK\u0012l\u0015\r\u001d'jW\u0016\u0004\"AW8\n\u0005A\f%\u0001D*fe&\fG.\u001b>bE2,\u0017\u0001\u0002;sK\u0016\u0004Ba\u001d<UA:\u0011Q\t^\u0005\u0003kv\nABU3e\u00052\f7m\u001b+sK\u0016L!a\u001e=\u0003\tQ\u0013X-\u001a\u0006\u0003kv\n\u0001b\u001c:eKJLgnZ\u000b\u0002wB\u0019Ap +\u000f\u0005ik\u0018B\u0001@B\u0003\u001d\u0001\u0018mY6bO\u0016LA!!\u0001\u0002\u0004\tAqJ\u001d3fe&twM\u0003\u0002\u007f\u0003\u0006IqN\u001d3fe&tw\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\t\u0005-\u0011q\u0002\u000b\u0004S\u00065\u0001\"B=\u000b\u0001\bY\b\"B9\u000b\u0001\u0004\u0011HCAA\n)\rI\u0017Q\u0003\u0005\u0007\u0003/Y\u00019A>\u0002\u0007=\u0014H-A\u0003f[B$\u00180F\u0001j\u0003)qWm\u001e\"vS2$WM]\u000b\u0003\u0003C\u0001b!RA\u0012\u0003OI\u0017bAA\u0013{\t9!)^5mI\u0016\u0014\b#\u0002.\u0002*Q\u0003\u0017bAA\u0016\u0003\n1A+\u001e9mKJ\n\u0011B]1oO\u0016LU\u000e\u001d7\u0015\u000b%\f\t$a\u000f\t\u000f\u0005Mb\u00021\u0001\u00026\u0005!aM]8n!\u0011Q\u0016q\u0007+\n\u0007\u0005e\u0012I\u0001\u0004PaRLwN\u001c\u0005\b\u0003{q\u0001\u0019AA\u001b\u0003\u0015)h\u000e^5m\u0003%!S.\u001b8vg\u0012*\u0017\u000f\u0006\u0003\u0002D\u0005\u0015S\"\u0001\u0004\t\r\u0005\u001ds\u00021\u0001U\u0003\rYW-_\u0001\tIAdWo\u001d\u0013fcR!\u00111IA'\u0011\u001d\ty\u0005\u0005a\u0001\u0003O\t!a\u001b<\u0002\u0007\u001d,G\u000f\u0006\u0003\u0002V\u0005]\u0003\u0003\u0002.\u00028\u0001Da!a\u0012\u0012\u0001\u0004!\u0016\u0001C5uKJ\fGo\u001c:\u0016\u0005\u0005u\u0003#B6\u0002`\u0005\u001d\u0012bAA1\u007f\tA\u0011\n^3sCR|'/\u0001\u0007ji\u0016\u0014\u0018\r^8s\rJ|W\u000e\u0006\u0003\u0002^\u0005\u001d\u0004BBA5'\u0001\u0007A+A\u0003ti\u0006\u0014H/\u0001\tlKf\u001c\u0018\n^3sCR|'O\u0012:p[R!\u0011qNA9!\u0011Y\u0017q\f+\t\r\u0005%D\u00031\u0001U\u0003I1\u0018\r\\;fg&#XM]1u_J4%o\\7\u0015\t\u0005]\u0014\u0011\u0010\t\u0005W\u0006}\u0003\r\u0003\u0004\u0002jU\u0001\r\u0001V\u0001\u0005g&TX-\u0006\u0002\u0002\u0000A\u0019!,!!\n\u0007\u0005\r\u0015IA\u0002J]R\fq![:F[B$\u00180\u0006\u0002\u0002\nB\u0019!,a#\n\u0007\u00055\u0015IA\u0004C_>dW-\u00198\u0002\u0011\r|g\u000e^1j]N$B!!#\u0002\u0014\"1\u0011q\t\rA\u0002Q\u000bA\u0001[3bIV\u0011\u0011qE\u0001\u000bQ\u0016\fGm\u00149uS>tWCAAO!\u0015Q\u0016qGA\u0014\u0003\u0011a\u0017m\u001d;\u0002\u00151\f7\u000f^(qi&|g.\u0001\u0007lKf\u001c\u0018\n^3sCR|'/\u0006\u0002\u0002p\u0005qa/\u00197vKNLE/\u001a:bi>\u0014XCAA<\u0003\u001d1wN]3bG\",B!a,\u0002DR!\u0011\u0011WA\\!\rQ\u00161W\u0005\u0004\u0003k\u000b%\u0001B+oSRDq!!/ \u0001\u0004\tY,A\u0001g!\u001dQ\u0016QXA\u0014\u0003\u0003L1!a0B\u0005%1UO\\2uS>t\u0017\u0007E\u0002V\u0003\u0007$a!!2 \u0005\u0004A&!A+\u0002\u0013Q\u0014\u0018M\\:g_JlG\u0003BA\"\u0003\u0017Dq!!/!\u0001\u0004\ti\r\u0005\u0004[\u0003\u001f$\u0006\rY\u0005\u0004\u0003#\f%!\u0003$v]\u000e$\u0018n\u001c83\u0003\u0015\u0019G.Z1s)\t\t\t,\u0001\u0007tiJLgn\u001a)sK\u001aL\u00070\u0006\u0002\u0002\\B!\u0011Q\\At\u001b\t\tyN\u0003\u0003\u0002b\u0006\r\u0018\u0001\u00027b]\u001eT!!!:\u0002\t)\fg/Y\u0005\u0005\u0003S\fyN\u0001\u0004TiJLgn\u001a\u0002\f)J,W-T1q-&,wo\u0005\u0002$SR1\u0011\u0011_Az\u0003k\u00042!a\u0011$\u0011\u001d\t\u0019D\na\u0001\u0003kAq!!\u0010'\u0001\u0004\t)$\u0001\bqS\u000e\\Gj\\<fe\n{WO\u001c3\u0015\t\u0005U\u00121 \u0005\b\u0003{<\u0003\u0019AA\u001b\u0003\u001dqWm\u001e$s_6\fa\u0002]5dWV\u0003\b/\u001a:C_VtG\r\u0006\u0003\u00026\t\r\u0001b\u0002B\u0003Q\u0001\u0007\u0011QG\u0001\t]\u0016<XK\u001c;jY\u0006\u0011\u0012n]%og&$WMV5fo\n{WO\u001c3t)\u0011\tIIa\u0003\t\r\u0005\u001d\u0013\u00061\u0001U)\u0015I'q\u0002B\t\u0011\u001d\t\u0019D\u000ba\u0001\u0003kAq!!\u0010+\u0001\u0004\t)\u0004\u0006\u0003\u0002V\tU\u0001BBA$W\u0001\u0007A\u000b\u0006\u0003\u0002^\te\u0001BBA5[\u0001\u0007A\u000b\u0006\u0003\u0002p\tu\u0001BBA5]\u0001\u0007A\u000b\u0006\u0003\u0002x\t\u0005\u0002BBA5_\u0001\u0007A\u000b\u0006\u0003\u0002\n\n\u0015\u0002BBA$e\u0001\u0007A+\u0006\u0003\u0003*\tEB\u0003BAY\u0005WAq!!/8\u0001\u0004\u0011i\u0003E\u0004[\u0003{\u000b9Ca\f\u0011\u0007U\u0013\t\u0004\u0002\u0004\u0002F^\u0012\r\u0001\u0017\u000b\u0005\u0005k\u00119$D\u0001$\u0011\u001d\tI\f\u000fa\u0001\u0003\u001b\fQa\u00197p]\u0016$\u0012!\u001b\u0015\bG\t}\"Q\tB$!\rQ&\u0011I\u0005\u0004\u0005\u0007\n%\u0001E*fe&\fGNV3sg&|g.V%E\u0003\u00151\u0018\r\\;f=!qB:\u0003OL\u000bSc\u0014F\u0001\u0004$Q\u001d1!q\bB#\u0005\u001br\u0002\u00028?)\\Y.@\u0014=\u000b\u0002\tV1!1\u000bB-\u0005;\"BA!\u0016\u0003`A1QI\u0002B,\u00057\u00022!\u0016B-\t\u001596A1\u0001Y!\r)&Q\f\u0003\u0006E\u000e\u0011\r\u0001\u0017\u0005\b\u0003/\u0019\u00019\u0001B1!\u0011axPa\u0016\u0002\u0019\r\fgNQ;jY\u00124%o\\7\u0016\r\t\u001d$q\u0010BB)\u0011\u0011IGa\"\u0011\u0013%\u0013YGa\u001c\u0003|\t\u0015\u0015b\u0001B7\u0015\na1)\u00198Ck&dGM\u0012:p[B!!\u0011\u000fB:\u001b\u0005\t\u0011\u0002\u0002B;\u0005o\u0012AaQ8mY&\u0019!\u0011\u0010&\u0003!M{'\u000f^3e\u001b\u0006\u0004h)Y2u_JL\bc\u0002.\u0002*\tu$\u0011\u0011\t\u0004+\n}D!B,\u0005\u0005\u0004A\u0006cA+\u0003\u0004\u0012)!\r\u0002b\u00011B1QI\u0002B?\u0005\u0003Cq!a\u0006\u0005\u0001\b\u0011I\t\u0005\u0003}\u007f\nu\u0014a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"Aa$\u0011\t\u0005u'\u0011S\u0005\u0005\u0005'\u000byN\u0001\u0004PE*,7\r\u001e")
public class TreeMap<A, B>
extends AbstractSortedMap<A, B>
implements Serializable {
    public static final long serialVersionUID = -2558985573956740112L;
    public final RedBlackTree.Tree<A, B> scala$collection$mutable$TreeMap$$tree;
    private final Ordering<A> ordering;

    public static <A, B> CanBuildFrom<TreeMap<?, ?>, Tuple2<A, B>, TreeMap<A, B>> canBuildFrom(Ordering<A> ordering) {
        return TreeMap$.MODULE$.canBuildFrom(ordering);
    }

    @Override
    public Ordering<A> ordering() {
        return this.ordering;
    }

    @Override
    public TreeMap<A, B> empty() {
        return TreeMap$.MODULE$.empty((Ordering)this.ordering());
    }

    @Override
    public Builder<Tuple2<A, B>, TreeMap<A, B>> newBuilder() {
        return TreeMap$.MODULE$.newBuilder(this.ordering());
    }

    @Override
    public TreeMap<A, B> rangeImpl(Option<A> from, Option<A> until) {
        return new TreeMapView(this, from, until);
    }

    public TreeMap<A, B> $minus$eq(A key) {
        RedBlackTree$.MODULE$.delete(this.scala$collection$mutable$TreeMap$$tree, key, this.ordering());
        return this;
    }

    @Override
    public TreeMap<A, B> $plus$eq(Tuple2<A, B> kv) {
        RedBlackTree$.MODULE$.insert(this.scala$collection$mutable$TreeMap$$tree, kv._1(), kv._2(), this.ordering());
        return this;
    }

    @Override
    public Option<B> get(A key) {
        return RedBlackTree$.MODULE$.get(this.scala$collection$mutable$TreeMap$$tree, key, this.ordering());
    }

    @Override
    public Iterator<Tuple2<A, B>> iterator() {
        return RedBlackTree$.MODULE$.iterator(this.scala$collection$mutable$TreeMap$$tree, RedBlackTree$.MODULE$.iterator$default$2(), RedBlackTree$.MODULE$.iterator$default$3(), this.ordering());
    }

    @Override
    public Iterator<Tuple2<A, B>> iteratorFrom(A start) {
        return RedBlackTree$.MODULE$.iterator(this.scala$collection$mutable$TreeMap$$tree, new Some<A>(start), RedBlackTree$.MODULE$.iterator$default$3(), this.ordering());
    }

    @Override
    public Iterator<A> keysIteratorFrom(A start) {
        return RedBlackTree$.MODULE$.keysIterator(this.scala$collection$mutable$TreeMap$$tree, new Some<A>(start), RedBlackTree$.MODULE$.keysIterator$default$3(), this.ordering());
    }

    @Override
    public Iterator<B> valuesIteratorFrom(A start) {
        return RedBlackTree$.MODULE$.valuesIterator(this.scala$collection$mutable$TreeMap$$tree, new Some<A>(start), RedBlackTree$.MODULE$.valuesIterator$default$3(), this.ordering());
    }

    @Override
    public int size() {
        return RedBlackTree$.MODULE$.size(this.scala$collection$mutable$TreeMap$$tree);
    }

    @Override
    public boolean isEmpty() {
        return RedBlackTree$.MODULE$.isEmpty(this.scala$collection$mutable$TreeMap$$tree);
    }

    @Override
    public boolean contains(A key) {
        return RedBlackTree$.MODULE$.contains(this.scala$collection$mutable$TreeMap$$tree, key, this.ordering());
    }

    @Override
    public Tuple2<A, B> head() {
        return RedBlackTree$.MODULE$.min(this.scala$collection$mutable$TreeMap$$tree).get();
    }

    @Override
    public Option<Tuple2<A, B>> headOption() {
        return RedBlackTree$.MODULE$.min(this.scala$collection$mutable$TreeMap$$tree);
    }

    @Override
    public Tuple2<A, B> last() {
        return RedBlackTree$.MODULE$.max(this.scala$collection$mutable$TreeMap$$tree).get();
    }

    @Override
    public Option<Tuple2<A, B>> lastOption() {
        return RedBlackTree$.MODULE$.max(this.scala$collection$mutable$TreeMap$$tree);
    }

    @Override
    public Iterator<A> keysIterator() {
        return RedBlackTree$.MODULE$.keysIterator(this.scala$collection$mutable$TreeMap$$tree, RedBlackTree$.MODULE$.keysIterator$default$2(), RedBlackTree$.MODULE$.keysIterator$default$3(), this.ordering());
    }

    @Override
    public Iterator<B> valuesIterator() {
        return RedBlackTree$.MODULE$.valuesIterator(this.scala$collection$mutable$TreeMap$$tree, RedBlackTree$.MODULE$.valuesIterator$default$2(), RedBlackTree$.MODULE$.valuesIterator$default$3(), this.ordering());
    }

    @Override
    public <U> void foreach(Function1<Tuple2<A, B>, U> f) {
        RedBlackTree$.MODULE$.foreach(this.scala$collection$mutable$TreeMap$$tree, f);
    }

    public TreeMap<A, B> transform(Function2<A, B, B> f) {
        RedBlackTree$.MODULE$.transform(this.scala$collection$mutable$TreeMap$$tree, f);
        return this;
    }

    @Override
    public void clear() {
        RedBlackTree$.MODULE$.clear(this.scala$collection$mutable$TreeMap$$tree);
    }

    @Override
    public String stringPrefix() {
        return "TreeMap";
    }

    public TreeMap(RedBlackTree.Tree<A, B> tree, Ordering<A> ordering) {
        this.scala$collection$mutable$TreeMap$$tree = tree;
        this.ordering = ordering;
    }

    public TreeMap(Ordering<A> ord) {
        this(RedBlackTree$Tree$.MODULE$.empty(), ord);
    }

    public final class TreeMapView
    extends TreeMap<A, B> {
        public static final long serialVersionUID = 2219159283273389116L;
        private final Option<A> from;
        private final Option<A> until;
        private final /* synthetic */ TreeMap $outer;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private Option<A> pickLowerBound(Option<A> newFrom) {
            Option option;
            Option option2;
            Option option3 = option2 = this.from;
            Option option4 = newFrom;
            if (option3 instanceof Some) {
                Object fr = ((Some)option3).value();
                if (option4 instanceof Some) {
                    Object newFr = ((Some)option4).value();
                    return new Some(this.ordering().max(fr, newFr));
                }
            }
            if (!None$.MODULE$.equals(option = option2)) return this.from;
            return newFrom;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private Option<A> pickUpperBound(Option<A> newUntil) {
            Option option;
            Option option2;
            Option option3 = option2 = this.until;
            Option option4 = newUntil;
            if (option3 instanceof Some) {
                Object unt = ((Some)option3).value();
                if (option4 instanceof Some) {
                    Object newUnt = ((Some)option4).value();
                    return new Some(this.ordering().min(unt, newUnt));
                }
            }
            if (!None$.MODULE$.equals(option = option2)) return this.until;
            return newUntil;
        }

        private boolean isInsideViewBounds(A key) {
            boolean beforeUntil;
            boolean afterFrom = this.from.isEmpty() || this.ordering().compare(this.from.get(), key) <= 0;
            boolean bl = beforeUntil = this.until.isEmpty() || this.ordering().compare(key, this.until.get()) < 0;
            return afterFrom && beforeUntil;
        }

        @Override
        public TreeMap<A, B> rangeImpl(Option<A> from, Option<A> until) {
            return new TreeMapView(this.$outer, this.pickLowerBound(from), this.pickUpperBound(until));
        }

        @Override
        public Option<B> get(A key) {
            if (this.isInsideViewBounds(key)) {
                return RedBlackTree$.MODULE$.get(this.$outer.scala$collection$mutable$TreeMap$$tree, key, this.ordering());
            }
            return None$.MODULE$;
        }

        @Override
        public Iterator<Tuple2<A, B>> iterator() {
            return RedBlackTree$.MODULE$.iterator(this.$outer.scala$collection$mutable$TreeMap$$tree, this.from, this.until, this.ordering());
        }

        @Override
        public Iterator<Tuple2<A, B>> iteratorFrom(A start) {
            return RedBlackTree$.MODULE$.iterator(this.$outer.scala$collection$mutable$TreeMap$$tree, this.pickLowerBound(new Some(start)), this.until, this.ordering());
        }

        @Override
        public Iterator<A> keysIteratorFrom(A start) {
            return RedBlackTree$.MODULE$.keysIterator(this.$outer.scala$collection$mutable$TreeMap$$tree, this.pickLowerBound(new Some(start)), this.until, this.ordering());
        }

        @Override
        public Iterator<B> valuesIteratorFrom(A start) {
            return RedBlackTree$.MODULE$.valuesIterator(this.$outer.scala$collection$mutable$TreeMap$$tree, this.pickLowerBound(new Some(start)), this.until, this.ordering());
        }

        @Override
        public int size() {
            return this.iterator().length();
        }

        @Override
        public boolean isEmpty() {
            return !this.iterator().hasNext();
        }

        @Override
        public boolean contains(A key) {
            return this.isInsideViewBounds(key) && RedBlackTree$.MODULE$.contains(this.$outer.scala$collection$mutable$TreeMap$$tree, key, this.ordering());
        }

        @Override
        public Tuple2<A, B> head() {
            return this.headOption().get();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Option<Tuple2<A, B>> headOption() {
            None$ entry = this.from.isDefined() ? RedBlackTree$.MODULE$.minAfter(this.$outer.scala$collection$mutable$TreeMap$$tree, this.from.get(), this.ordering()) : RedBlackTree$.MODULE$.min(this.$outer.scala$collection$mutable$TreeMap$$tree);
            Option option = this.until;
            None$ none$ = entry;
            Option option2 = option;
            if (!(none$ instanceof Some)) return entry;
            Tuple2 e = (Tuple2)((Some)((Object)none$)).value();
            if (!(option2 instanceof Some)) return entry;
            Object unt = ((Some)option2).value();
            if (this.ordering().compare(e._1(), unt) < 0) return entry;
            return None$.MODULE$;
        }

        @Override
        public Tuple2<A, B> last() {
            return this.lastOption().get();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public Option<Tuple2<A, B>> lastOption() {
            None$ entry = this.until.isDefined() ? RedBlackTree$.MODULE$.maxBefore(this.$outer.scala$collection$mutable$TreeMap$$tree, this.until.get(), this.ordering()) : RedBlackTree$.MODULE$.max(this.$outer.scala$collection$mutable$TreeMap$$tree);
            Option option = this.from;
            None$ none$ = entry;
            Option option2 = option;
            if (!(none$ instanceof Some)) return entry;
            Tuple2 e = (Tuple2)((Some)((Object)none$)).value();
            if (!(option2 instanceof Some)) return entry;
            Object fr = ((Some)option2).value();
            if (this.ordering().compare(e._1(), fr) >= 0) return entry;
            return None$.MODULE$;
        }

        @Override
        public <U> void foreach(Function1<Tuple2<A, B>, U> f) {
            this.iterator().foreach(f);
        }

        public TreeMapView transform(Function2<A, B, B> f) {
            this.iterator().foreach((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A x0$1) -> {
                TreeMapView.$anonfun$transform$1(this, f, x0$1);
                return BoxedUnit.UNIT;
            });
            return this;
        }

        @Override
        public Iterator<B> valuesIterator() {
            return RedBlackTree$.MODULE$.valuesIterator(this.$outer.scala$collection$mutable$TreeMap$$tree, this.from, this.until, this.ordering());
        }

        @Override
        public Iterator<A> keysIterator() {
            return RedBlackTree$.MODULE$.keysIterator(this.$outer.scala$collection$mutable$TreeMap$$tree, this.from, this.until, this.ordering());
        }

        @Override
        public TreeMap<A, B> clone() {
            return ((TreeMap)MapLike.clone$(this)).rangeImpl(this.from, this.until);
        }

        public static final /* synthetic */ void $anonfun$transform$1(TreeMapView $this, Function2 f$1, Tuple2 x0$1) {
            if (x0$1 != null) {
                Object key = x0$1._1();
                Object value = x0$1._2();
                $this.update(key, f$1.apply(key, value));
                return;
            }
            throw new MatchError((Object)null);
        }

        public TreeMapView(TreeMap $outer, Option<A> from, Option<A> until) {
            this.from = from;
            this.until = until;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super($outer.scala$collection$mutable$TreeMap$$tree, $outer.ordering());
        }
    }
}

