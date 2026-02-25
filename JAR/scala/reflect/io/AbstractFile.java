/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Function3;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.Tuple4;
import scala.collection.GenIterable;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Set;
import scala.collection.immutable.Stream;
import scala.collection.immutable.StringOps;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.io.AbstractFile$;
import scala.reflect.io.File;
import scala.reflect.io.Path;
import scala.reflect.io.Path$;
import scala.reflect.io.PlainFile;
import scala.runtime.BoxesRunTime;
import scala.runtime.IntRef;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\t\u0005q!B\u00181\u0011\u00039d!B\u001d1\u0011\u0003Q\u0004\"B \u0002\t\u0003\u0001\u0005\"B!\u0002\t\u0003\u0011\u0005BB!\u0002\t\u0003\t9\u000e\u0003\u0004B\u0003\u0011\u0005\u0011\u0011\u001d\u0005\b\u0003S\fA\u0011AAv\u0011\u001d\tI/\u0001C\u0001\u0003_Dq!a=\u0002\t\u0003\t)\u0010C\u0004\u0002|\u0006!\t!!@\u0007\u000be\u0002\u0014\u0011\u0001#\t\u000b}RA\u0011\u0001'\t\u000b5Sa\u0011\u0001(\t\u000biSa\u0011\u0001(\t\u000bmSA\u0011\u0001(\t\u000bqSA\u0011A/\t\u0011\rT\u0001R1A\u0005\n9CQ\u0001\u001a\u0006\u0007\u0002\u0015DQA\u001a\u0006\u0007\u0002\u0015DQa\u001a\u0006\u0007\u0002!DQ\u0001\u001d\u0006\u0005\u0002EDQ!\u001e\u0006\u0005\u0002YDQa\u001e\u0006\u0005\u0002YDQ\u0001\u001f\u0006\u0007\u0002eDQ! \u0006\u0007\u0002eDQA \u0006\u0007\u0002YDQa \u0006\u0005\u0002YDq!!\u0001\u000b\r\u0003\t\u0019\u0001C\u0004\u0002\f)1\t!!\u0004\t\u000f\u0005U!B\"\u0001\u0002\u0018!9\u0011q\u0004\u0006\u0005\u0002\u0005\u0005\u0002bBA\u0015\u0015\u0011\u0005\u00111\u0006\u0005\b\u0003kQA\u0011AA\u001c\u0011\u001d\t)E\u0003C\u0001\u0003\u000fBq!!\u001a\u000b\t\u0003\t9\u0007C\u0004\u0002t)!\t!a\u001a\t\u000f\u0005U$B\"\u0001\u0002x!9\u0011q\u0010\u0006\u0007\u0002\u0005\u0005\u0005bBAE\u0015\u0019\u0005\u00111\u0012\u0005\b\u0003#SA\u0011AAJ\u0011\u001d\tIJ\u0003C\u0005\u00037Cq!a+\u000b\t\u0013\ti\u000bC\u0004\u00026*!\t!a.\t\u000f\u0005m&\u0002\"\u0001\u0002>\"9\u0011\u0011\u0019\u0006\u0005\u0012\u0005\r\u0007bBAa\u0015\u0011E\u00111\u001a\u0005\b\u0003#TA\u0011IAj\u00031\t%m\u001d;sC\u000e$h)\u001b7f\u0015\t\t$'\u0001\u0002j_*\u00111\u0007N\u0001\be\u00164G.Z2u\u0015\u0005)\u0014!B:dC2\f7\u0001\u0001\t\u0003q\u0005i\u0011\u0001\r\u0002\r\u0003\n\u001cHO]1di\u001aKG.Z\n\u0003\u0003m\u0002\"\u0001P\u001f\u000e\u0003QJ!A\u0010\u001b\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\tq'A\u0004hKR4\u0015\u000e\\3\u0015\u0007\r\u000b)\u000e\u0005\u00029\u0015M\u0019!bO#\u0011\u0007\u0019K5I\u0004\u0002=\u000f&\u0011\u0001\nN\u0001\ba\u0006\u001c7.Y4f\u0013\tQ5J\u0001\u0005Ji\u0016\u0014\u0018M\u00197f\u0015\tAE\u0007F\u0001D\u0003\u0011q\u0017-\\3\u0016\u0003=\u0003\"\u0001U,\u000f\u0005E+\u0006C\u0001*5\u001b\u0005\u0019&B\u0001+7\u0003\u0019a$o\\8u}%\u0011a\u000bN\u0001\u0007!J,G-\u001a4\n\u0005aK&AB*ue&twM\u0003\u0002Wi\u0005!\u0001/\u0019;i\u00035\u0019\u0017M\\8oS\u000e\fG\u000eU1uQ\u0006a\u0001.Y:FqR,gn]5p]R\u0011a,\u0019\t\u0003y}K!\u0001\u0019\u001b\u0003\u000f\t{w\u000e\\3b]\")!m\u0004a\u0001\u001f\u0006)q\u000e\u001e5fe\u0006IQ\r\u001f;f]NLwN\\\u0001\tC\n\u001cx\u000e\\;uKV\t1)A\u0005d_:$\u0018-\u001b8fe\u0006!a-\u001b7f+\u0005I\u0007C\u00016o\u001b\u0005Y'BA\u0019m\u0015\u0005i\u0017\u0001\u00026bm\u0006L!a\\6\u0003\t\u0019KG.Z\u0001\u0011k:$WM\u001d7zS:<7k\\;sG\u0016,\u0012A\u001d\t\u0004yM\u001c\u0015B\u0001;5\u0005\u0019y\u0005\u000f^5p]\u00061Q\r_5tiN,\u0012AX\u0001\u0011SN\u001cE.Y:t\u0007>tG/Y5oKJ\faa\u0019:fCR,G#\u0001>\u0011\u0005qZ\u0018B\u0001?5\u0005\u0011)f.\u001b;\u0002\r\u0011,G.\u001a;f\u0003-I7\u000fR5sK\u000e$xN]=\u0002\u0013%\u001ch+\u001b:uk\u0006d\u0017\u0001\u00047bgRlu\u000eZ5gS\u0016$WCAA\u0003!\ra\u0014qA\u0005\u0004\u0003\u0013!$\u0001\u0002'p]\u001e\fQ!\u001b8qkR,\"!a\u0004\u0011\u0007)\f\t\"C\u0002\u0002\u0014-\u00141\"\u00138qkR\u001cFO]3b[\u00061q.\u001e;qkR,\"!!\u0007\u0011\u0007)\fY\"C\u0002\u0002\u001e-\u0014AbT;uaV$8\u000b\u001e:fC6\faBY;gM\u0016\u0014X\rZ(viB,H/\u0006\u0002\u0002$A\u0019!.!\n\n\u0007\u0005\u001d2N\u0001\u000bCk\u001a4WM]3e\u001fV$\b/\u001e;TiJ,\u0017-\\\u0001\u000bg&TXm\u00149uS>tWCAA\u0017!\u0011a4/a\f\u0011\u0007q\n\t$C\u0002\u00024Q\u00121!\u00138u\u0003\u0015!x.\u0016*M+\t\tI\u0004\u0005\u0003\u0002<\u0005\u0005SBAA\u001f\u0015\r\ty\u0004\\\u0001\u0004]\u0016$\u0018\u0002BA\"\u0003{\u00111!\u0016*M\u0003-!xn\u00115be\u0006\u0013(/Y=\u0016\u0005\u0005%\u0003#\u0002\u001f\u0002L\u0005=\u0013bAA'i\t)\u0011I\u001d:bsB\u0019A(!\u0015\n\u0007\u0005MCG\u0001\u0003DQ\u0006\u0014\b&B\u0011\u0002X\u0005\r\u0004#\u0002\u001f\u0002Z\u0005u\u0013bAA.i\t1A\u000f\u001b:poN\u00042A[A0\u0013\r\t\tg\u001b\u0002\f\u0013>+\u0005pY3qi&|gn\t\u0002\u0002^\u0005YAo\u001c\"zi\u0016\f%O]1z+\t\tI\u0007E\u0003=\u0003\u0017\nY\u0007E\u0002=\u0003[J1!a\u001c5\u0005\u0011\u0011\u0015\u0010^3)\u000b\t\n9&a\u0019\u0002#Ut7/\u00194f)>\u0014\u0015\u0010^3BeJ\f\u00170\u0001\u0005ji\u0016\u0014\u0018\r^8s+\t\tI\b\u0005\u0003G\u0003w\u001a\u0015bAA?\u0017\nA\u0011\n^3sCR|'/\u0001\u0006m_>\\W\u000f\u001d(b[\u0016$RaQAB\u0003\u000bCQ!T\u0013A\u0002=Ca!a\"&\u0001\u0004q\u0016!\u00033je\u0016\u001cGo\u001c:z\u0003Mawn\\6va:\u000bW.Z+oG\",7m[3e)\u0015\u0019\u0015QRAH\u0011\u0015ie\u00051\u0001P\u0011\u0019\t9I\na\u0001=\u0006\u0019Bn\\8lkB\u0004\u0016\r\u001e5V]\u000eDWmY6fIR)1)!&\u0002\u0018\")!l\na\u0001\u001f\"1\u0011qQ\u0014A\u0002y\u000ba\u0001\\8pWV\u0004HcB\"\u0002\u001e\u0006\u0015\u0016\u0011\u0016\u0005\u0007\u0003\"\u0002\r!a(\u0011\u000fq\n\tkQ(_\u0007&\u0019\u00111\u0015\u001b\u0003\u0013\u0019+hn\u0019;j_:\u001c\u0004BBATQ\u0001\u0007q*A\u0003qCRD\u0007\u0007\u0003\u0004\u0002\b\"\u0002\rAX\u0001\u0018M&dWm\u0014:Tk\n$\u0017N]3di>\u0014\u0018PT1nK\u0012$RaQAX\u0003cCQ!T\u0015A\u0002=Ca!a-*\u0001\u0004q\u0016!B5t\t&\u0014\u0018!\u00034jY\u0016t\u0015-\\3e)\r\u0019\u0015\u0011\u0018\u0005\u0006\u001b*\u0002\raT\u0001\u0012gV\u0014G-\u001b:fGR|'/\u001f(b[\u0016$GcA\"\u0002@\")Qj\u000ba\u0001\u001f\u0006YQO\\:vaB|'\u000f^3e)\t\t)\rE\u0002=\u0003\u000fL1!!35\u0005\u001dqu\u000e\u001e5j]\u001e$B!!2\u0002N\"1\u0011qZ\u0017A\u0002=\u000b1!\\:h\u0003!!xn\u0015;sS:<G#A(\t\u000bi\u001b\u0001\u0019A(\u0015\u0007\r\u000bI\u000e\u0003\u0004[\t\u0001\u0007\u00111\u001c\t\u0004q\u0005u\u0017bAApa\t!\u0001+\u0019;i)\r\u0019\u00151\u001d\u0005\u0007O\u0016\u0001\r!!:\u0011\u0007a\n9/\u0003\u0002pa\u0005aq-\u001a;ESJ,7\r^8ssR\u00191)!<\t\ri3\u0001\u0019AAn)\r\u0019\u0015\u0011\u001f\u0005\u0007O\u001e\u0001\r!!:\u0002\r\u001d,G/\u0016*M)\r\u0019\u0015q\u001f\u0005\b\u0003sD\u0001\u0019AA\u001d\u0003\r)(\u000f\\\u0001\rO\u0016$(+Z:pkJ\u001cWm\u001d\u000b\u0004\u0007\u0006}\bbBA}\u0013\u0001\u0007\u0011\u0011\b")
public abstract class AbstractFile
implements Iterable<AbstractFile> {
    private String extension;
    private volatile boolean bitmap$0;

    public static AbstractFile getResources(URL uRL) {
        return AbstractFile$.MODULE$.getResources(uRL);
    }

    public static AbstractFile getURL(URL uRL) {
        return AbstractFile$.MODULE$.getURL(uRL);
    }

    public static AbstractFile getDirectory(File file) {
        return AbstractFile$.MODULE$.getDirectory(file);
    }

    public static AbstractFile getDirectory(Path path) {
        return AbstractFile$.MODULE$.getDirectory(path);
    }

    public static AbstractFile getFile(File file) {
        return AbstractFile$.MODULE$.getFile(file);
    }

    public static AbstractFile getFile(Path path) {
        return AbstractFile$.MODULE$.getFile(path);
    }

    public static AbstractFile getFile(String string) {
        return AbstractFile$.MODULE$.getFile(string);
    }

    @Override
    public GenericCompanion<Iterable> companion() {
        return Iterable.companion$(this);
    }

    @Override
    public Iterable<AbstractFile> seq() {
        return Iterable.seq$(this);
    }

    @Override
    public Iterable<AbstractFile> thisCollection() {
        return IterableLike.thisCollection$(this);
    }

    @Override
    public Iterable toCollection(Object repr) {
        return IterableLike.toCollection$(this, repr);
    }

    @Override
    public <U> void foreach(Function1<AbstractFile, U> f) {
        IterableLike.foreach$(this, f);
    }

    @Override
    public boolean forall(Function1<AbstractFile, Object> p) {
        return IterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<AbstractFile, Object> p) {
        return IterableLike.exists$(this, p);
    }

    @Override
    public Option<AbstractFile> find(Function1<AbstractFile, Object> p) {
        return IterableLike.find$(this, p);
    }

    @Override
    public boolean isEmpty() {
        return IterableLike.isEmpty$(this);
    }

    @Override
    public <B> B foldRight(B z, Function2<AbstractFile, B, B> op) {
        return (B)IterableLike.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceRight(Function2<AbstractFile, B, B> op) {
        return (B)IterableLike.reduceRight$(this, op);
    }

    @Override
    public Iterable<AbstractFile> toIterable() {
        return IterableLike.toIterable$(this);
    }

    @Override
    public Iterator<AbstractFile> toIterator() {
        return IterableLike.toIterator$(this);
    }

    @Override
    public Object head() {
        return IterableLike.head$(this);
    }

    @Override
    public Object slice(int from, int until) {
        return IterableLike.slice$(this, from, until);
    }

    @Override
    public Object take(int n) {
        return IterableLike.take$(this, n);
    }

    @Override
    public Object drop(int n) {
        return IterableLike.drop$(this, n);
    }

    @Override
    public Object takeWhile(Function1 p) {
        return IterableLike.takeWhile$(this, p);
    }

    @Override
    public Iterator<Iterable<AbstractFile>> grouped(int size) {
        return IterableLike.grouped$(this, size);
    }

    @Override
    public Iterator<Iterable<AbstractFile>> sliding(int size) {
        return IterableLike.sliding$(this, size);
    }

    @Override
    public Iterator<Iterable<AbstractFile>> sliding(int size, int step) {
        return IterableLike.sliding$(this, size, step);
    }

    @Override
    public Object takeRight(int n) {
        return IterableLike.takeRight$(this, n);
    }

    @Override
    public Object dropRight(int n) {
        return IterableLike.dropRight$(this, n);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        IterableLike.copyToArray$(this, xs, start, len);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<Iterable<AbstractFile>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zip$(this, that, bf);
    }

    @Override
    public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<Iterable<AbstractFile>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<Iterable<AbstractFile>, Tuple2<A1, Object>, That> bf) {
        return (That)IterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public Stream<AbstractFile> toStream() {
        return IterableLike.toStream$(this);
    }

    @Override
    public boolean canEqual(Object that) {
        return IterableLike.canEqual$(this, that);
    }

    @Override
    public IterableView<AbstractFile, Iterable<AbstractFile>> view() {
        return IterableLike.view$(this);
    }

    @Override
    public IterableView<AbstractFile, Iterable<AbstractFile>> view(int from, int until) {
        return IterableLike.view$(this, from, until);
    }

    @Override
    public Builder<AbstractFile, Iterable<AbstractFile>> newBuilder() {
        return GenericTraversableTemplate.newBuilder$(this);
    }

    @Override
    public <B> Builder<B, Iterable<B>> genericBuilder() {
        return GenericTraversableTemplate.genericBuilder$(this);
    }

    @Override
    public <A1, A2> Tuple2<Iterable<A1>, Iterable<A2>> unzip(Function1<AbstractFile, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<Iterable<A1>, Iterable<A2>, Iterable<A3>> unzip3(Function1<AbstractFile, Tuple3<A1, A2, A3>> asTriple) {
        return GenericTraversableTemplate.unzip3$(this, asTriple);
    }

    @Override
    public GenTraversable flatten(Function1 asTraversable) {
        return GenericTraversableTemplate.flatten$(this, asTraversable);
    }

    @Override
    public GenTraversable transpose(Function1 asTraversable) {
        return GenericTraversableTemplate.transpose$(this, asTraversable);
    }

    @Override
    public Object repr() {
        return TraversableLike.repr$(this);
    }

    @Override
    public final boolean isTraversableAgain() {
        return TraversableLike.isTraversableAgain$(this);
    }

    @Override
    public Combiner<AbstractFile, ParIterable<AbstractFile>> parCombiner() {
        return TraversableLike.parCombiner$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return TraversableLike.hasDefiniteSize$(this);
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<Iterable<AbstractFile>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<Iterable<AbstractFile>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(Traversable<B> that, CanBuildFrom<Iterable<AbstractFile>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That map(Function1<AbstractFile, B> f, CanBuildFrom<Iterable<AbstractFile>, B, That> bf) {
        return (That)TraversableLike.map$(this, f, bf);
    }

    @Override
    public <B, That> That flatMap(Function1<AbstractFile, GenTraversableOnce<B>> f, CanBuildFrom<Iterable<AbstractFile>, B, That> bf) {
        return (That)TraversableLike.flatMap$(this, f, bf);
    }

    @Override
    public Object filterImpl(Function1 p, boolean isFlipped) {
        return TraversableLike.filterImpl$(this, p, isFlipped);
    }

    @Override
    public Object filter(Function1 p) {
        return TraversableLike.filter$(this, p);
    }

    @Override
    public Object filterNot(Function1 p) {
        return TraversableLike.filterNot$(this, p);
    }

    @Override
    public <B, That> That collect(PartialFunction<AbstractFile, B> pf, CanBuildFrom<Iterable<AbstractFile>, B, That> bf) {
        return (That)TraversableLike.collect$(this, pf, bf);
    }

    @Override
    public Tuple2<Iterable<AbstractFile>, Iterable<AbstractFile>> partition(Function1<AbstractFile, Object> p) {
        return TraversableLike.partition$(this, p);
    }

    @Override
    public <K> Map<K, Iterable<AbstractFile>> groupBy(Function1<AbstractFile, K> f) {
        return TraversableLike.groupBy$(this, f);
    }

    @Override
    public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<Iterable<AbstractFile>, B, That> cbf) {
        return (That)TraversableLike.scan$(this, z, op, cbf);
    }

    @Override
    public <B, That> That scanLeft(B z, Function2<B, AbstractFile, B> op, CanBuildFrom<Iterable<AbstractFile>, B, That> bf) {
        return (That)TraversableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <B, That> That scanRight(B z, Function2<AbstractFile, B, B> op, CanBuildFrom<Iterable<AbstractFile>, B, That> bf) {
        return (That)TraversableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public Option<AbstractFile> headOption() {
        return TraversableLike.headOption$(this);
    }

    @Override
    public Object tail() {
        return TraversableLike.tail$(this);
    }

    @Override
    public Object last() {
        return TraversableLike.last$(this);
    }

    @Override
    public Option<AbstractFile> lastOption() {
        return TraversableLike.lastOption$(this);
    }

    @Override
    public Object init() {
        return TraversableLike.init$(this);
    }

    @Override
    public Object sliceWithKnownDelta(int from, int until, int delta) {
        return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
    }

    @Override
    public Object sliceWithKnownBound(int from, int until) {
        return TraversableLike.sliceWithKnownBound$(this, from, until);
    }

    @Override
    public Object dropWhile(Function1 p) {
        return TraversableLike.dropWhile$(this, p);
    }

    @Override
    public Tuple2<Iterable<AbstractFile>, Iterable<AbstractFile>> span(Function1<AbstractFile, Object> p) {
        return TraversableLike.span$(this, p);
    }

    @Override
    public Tuple2<Iterable<AbstractFile>, Iterable<AbstractFile>> splitAt(int n) {
        return TraversableLike.splitAt$(this, n);
    }

    @Override
    public Iterator<Iterable<AbstractFile>> tails() {
        return TraversableLike.tails$(this);
    }

    @Override
    public Iterator<Iterable<AbstractFile>> inits() {
        return TraversableLike.inits$(this);
    }

    @Override
    public Traversable<AbstractFile> toTraversable() {
        return TraversableLike.toTraversable$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, AbstractFile, Col> cbf) {
        return (Col)TraversableLike.to$(this, cbf);
    }

    @Override
    public String stringPrefix() {
        return TraversableLike.stringPrefix$(this);
    }

    @Override
    public FilterMonadic<AbstractFile, Iterable<AbstractFile>> withFilter(Function1<AbstractFile, Object> p) {
        return TraversableLike.withFilter$(this, p);
    }

    @Override
    public Parallel par() {
        return Parallelizable.par$(this);
    }

    @Override
    public List<AbstractFile> reversed() {
        return TraversableOnce.reversed$(this);
    }

    @Override
    public int size() {
        return TraversableOnce.size$(this);
    }

    @Override
    public boolean nonEmpty() {
        return TraversableOnce.nonEmpty$(this);
    }

    @Override
    public int count(Function1<AbstractFile, Object> p) {
        return TraversableOnce.count$(this, p);
    }

    @Override
    public <B> Option<B> collectFirst(PartialFunction<AbstractFile, B> pf) {
        return TraversableOnce.collectFirst$(this, pf);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, AbstractFile, B> op) {
        return (B)TraversableOnce.$div$colon$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<AbstractFile, B, B> op) {
        return (B)TraversableOnce.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, AbstractFile, B> op) {
        return (B)TraversableOnce.foldLeft$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, AbstractFile, B> op) {
        return (B)TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, AbstractFile, B> op) {
        return TraversableOnce.reduceLeftOption$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<AbstractFile, B, B> op) {
        return TraversableOnce.reduceRightOption$(this, op);
    }

    @Override
    public <A1> A1 reduce(Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.reduce$(this, op);
    }

    @Override
    public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
        return TraversableOnce.reduceOption$(this, op);
    }

    @Override
    public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.fold$(this, z, op);
    }

    @Override
    public <B> B aggregate(Function0<B> z, Function2<B, AbstractFile, B> seqop, Function2<B, B, B> combop) {
        return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <B> B sum(Numeric<B> num) {
        return (B)TraversableOnce.sum$(this, num);
    }

    @Override
    public <B> B product(Numeric<B> num) {
        return (B)TraversableOnce.product$(this, num);
    }

    @Override
    public Object min(Ordering cmp) {
        return TraversableOnce.min$(this, cmp);
    }

    @Override
    public Object max(Ordering cmp) {
        return TraversableOnce.max$(this, cmp);
    }

    @Override
    public Object maxBy(Function1 f, Ordering cmp) {
        return TraversableOnce.maxBy$(this, f, cmp);
    }

    @Override
    public Object minBy(Function1 f, Ordering cmp) {
        return TraversableOnce.minBy$(this, f, cmp);
    }

    @Override
    public <B> void copyToBuffer(Buffer<B> dest) {
        TraversableOnce.copyToBuffer$(this, dest);
    }

    @Override
    public <B> void copyToArray(Object xs, int start) {
        TraversableOnce.copyToArray$(this, xs, start);
    }

    @Override
    public <B> void copyToArray(Object xs) {
        TraversableOnce.copyToArray$(this, xs);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return TraversableOnce.toArray$(this, evidence$1);
    }

    @Override
    public List<AbstractFile> toList() {
        return TraversableOnce.toList$(this);
    }

    @Override
    public Seq<AbstractFile> toSeq() {
        return TraversableOnce.toSeq$(this);
    }

    @Override
    public IndexedSeq<AbstractFile> toIndexedSeq() {
        return TraversableOnce.toIndexedSeq$(this);
    }

    @Override
    public <B> Buffer<B> toBuffer() {
        return TraversableOnce.toBuffer$(this);
    }

    @Override
    public <B> Set<B> toSet() {
        return TraversableOnce.toSet$(this);
    }

    @Override
    public Vector<AbstractFile> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public <T, U> Map<T, U> toMap(Predef$.less.colon.less<AbstractFile, Tuple2<T, U>> ev) {
        return TraversableOnce.toMap$(this, ev);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return TraversableOnce.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return TraversableOnce.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return TraversableOnce.mkString$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return TraversableOnce.addString$(this, b, start, sep, end);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String sep) {
        return TraversableOnce.addString$(this, b, sep);
    }

    @Override
    public StringBuilder addString(StringBuilder b) {
        return TraversableOnce.addString$(this, b);
    }

    @Override
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    public abstract String name();

    public abstract String path();

    public String canonicalPath() {
        if (this.file() == null) {
            return this.path();
        }
        return this.file().getCanonicalPath();
    }

    public boolean hasExtension(String other) {
        String string = this.extension();
        String string2 = other.toLowerCase();
        return !(string != null ? !string.equals(string2) : string2 != null);
    }

    private String extension$lzycompute() {
        synchronized (this) {
            if (!this.bitmap$0) {
                this.extension = Path$.MODULE$.extension(this.name());
                this.bitmap$0 = true;
            }
        }
        return this.extension;
    }

    private String extension() {
        if (!this.bitmap$0) {
            return this.extension$lzycompute();
        }
        return this.extension;
    }

    public abstract AbstractFile absolute();

    public abstract AbstractFile container();

    public abstract java.io.File file();

    public Option<AbstractFile> underlyingSource() {
        return None$.MODULE$;
    }

    public boolean exists() {
        return this.file() == null || this.file().exists();
    }

    public boolean isClassContainer() {
        block3: {
            block2: {
                if (this.isDirectory()) break block2;
                if (this.file() == null) break block3;
                String string = this.extension();
                String string2 = "jar";
                if (string != null && string.equals(string2)) break block2;
                String string3 = this.extension();
                String string4 = "zip";
                if (string3 == null || !string3.equals(string4)) break block3;
            }
            return true;
        }
        return false;
    }

    public abstract void create();

    public abstract void delete();

    public abstract boolean isDirectory();

    public boolean isVirtual() {
        return false;
    }

    public abstract long lastModified();

    public abstract InputStream input();

    public abstract OutputStream output();

    public BufferedOutputStream bufferedOutput() {
        return new BufferedOutputStream(this.output());
    }

    public Option<Object> sizeOption() {
        return None$.MODULE$;
    }

    public URL toURL() {
        if (this.file() == null) {
            return null;
        }
        return this.file().toURI().toURL();
    }

    public char[] toCharArray() throws IOException {
        return new String(this.toByteArray()).toCharArray();
    }

    public byte[] toByteArray() throws IOException {
        byte[] byArray;
        InputStream in = this.input();
        Option<Object> option = this.sizeOption();
        if (option instanceof Some) {
            int res;
            int size;
            byte[] arr = new byte[size];
            for (int rest = size = BoxesRunTime.unboxToInt(((Some)option).value()); rest > 0; rest -= res) {
                res = in.read(arr, arr.length - rest, rest);
                if (res != -1) continue;
                throw new IOException("read error");
            }
            in.close();
            byArray = arr;
        } else if (None$.MODULE$.equals(option)) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int c = in.read();
            while (c != -1) {
                out.write(c);
                c = in.read();
            }
            in.close();
            byArray = out.toByteArray();
        } else {
            throw new MatchError(option);
        }
        return byArray;
    }

    public byte[] unsafeToByteArray() {
        return this.toByteArray();
    }

    @Override
    public abstract Iterator<AbstractFile> iterator();

    public abstract AbstractFile lookupName(String var1, boolean var2);

    public abstract AbstractFile lookupNameUnchecked(String var1, boolean var2);

    /*
     * Unable to fully structure code
     */
    public AbstractFile lookupPathUnchecked(String path, boolean directory) {
        lookup_separator = java.io.File.separatorChar;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToChar(new StringOps(path).last()) == lookup_separator) {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            v0 = (String)new StringOps(path).dropRight(1);
        } else {
            v0 = path;
        }
        lookup_path = v0;
        lookup_length = lookup_path.length();
        if (lookup_length <= 0) ** GOTO lbl-1000
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToChar(new StringOps(lookup_path).last()) != lookup_separator) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = var10_6 = false;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (lookup_assert_assertion == false) {
            throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append((Object)AbstractFile.$anonfun$lookup$1(lookup_path)).toString());
        }
        lookup_file = this;
        lookup_start = IntRef.create(0);
        while (true) {
            v2 = var11_11 = (lookup_index = lookup_path.indexOf(lookup_separator, lookup_start.elem)) < 0 || lookup_start.elem < lookup_index;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (lookup_assert_assertion == false) {
                throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append(AbstractFile.$anonfun$lookup$2(lookup_path, directory, lookup_start, lookup_index)).toString());
            }
            lookup_name = lookup_path.substring(lookup_start.elem, lookup_index < 0 ? lookup_length : lookup_index);
            if ((lookup_file = AbstractFile.$anonfun$lookupPathUnchecked$1(lookup_file, lookup_name, lookup_index < 0 ? directory : true)) == null || lookup_index < 0) break;
            lookup_start.elem = lookup_index + 1;
        }
        return var6_7;
    }

    /*
     * Unable to fully structure code
     */
    private AbstractFile lookup(Function3<AbstractFile, String, Object, AbstractFile> getFile, String path0, boolean directory) {
        separator = java.io.File.separatorChar;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToChar(new StringOps(path0).last()) == separator) {
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            v0 = (String)new StringOps(path0).dropRight(1);
        } else {
            v0 = path0;
        }
        path = v0;
        length = path.length();
        if (length <= 0) ** GOTO lbl-1000
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToChar(new StringOps(path).last()) != separator) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = var11_7 = false;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append((Object)AbstractFile.$anonfun$lookup$1(path)).toString());
        }
        file = this;
        start = IntRef.create(0);
        while (true) {
            v2 = var12_12 = (index = path.indexOf(separator, start.elem)) < 0 || start.elem < index;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append(AbstractFile.$anonfun$lookup$2(path, directory, start, index)).toString());
            }
            name = path.substring(start.elem, index < 0 ? length : index);
            if ((file = getFile.apply(file, name, index < 0 ? BoxesRunTime.boxToBoolean(directory) : BoxesRunTime.boxToBoolean(true))) == null || index < 0) {
                return file;
            }
            start.elem = index + 1;
        }
    }

    private AbstractFile fileOrSubdirectoryNamed(String name, boolean isDir) {
        AbstractFile lookup = this.lookupName(name, isDir);
        if (lookup != null) {
            return lookup;
        }
        java.io.File jfile = new java.io.File(this.file(), name);
        if (isDir) {
            jfile.mkdirs();
        } else {
            jfile.createNewFile();
        }
        return new PlainFile(Path$.MODULE$.jfile2path(jfile));
    }

    /*
     * WARNING - void declaration
     */
    public AbstractFile fileNamed(String name) {
        void assert_assertion;
        boolean bl = this.isDirectory();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append((Object)AbstractFile.$anonfun$fileNamed$1(this, name)).toString());
        }
        return this.fileOrSubdirectoryNamed(name, false);
    }

    /*
     * WARNING - void declaration
     */
    public AbstractFile subdirectoryNamed(String name) {
        void assert_assertion;
        boolean bl = this.isDirectory();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new java.lang.StringBuilder(18).append("assertion failed: ").append((Object)AbstractFile.$anonfun$subdirectoryNamed$1(this, name)).toString());
        }
        return this.fileOrSubdirectoryNamed(name, true);
    }

    public Nothing$ unsupported() {
        return this.unsupported(null);
    }

    public Nothing$ unsupported(String msg) {
        throw new UnsupportedOperationException(msg);
    }

    @Override
    public String toString() {
        return this.path();
    }

    public static final /* synthetic */ String $anonfun$lookup$1(String path$1) {
        return path$1;
    }

    public static final /* synthetic */ Tuple4 $anonfun$lookup$2(String path$1, boolean directory$1, IntRef start$1, int index$1) {
        return new Tuple4<String, Boolean, Integer, Integer>(path$1, BoxesRunTime.boxToBoolean(directory$1), BoxesRunTime.boxToInteger(start$1.elem), BoxesRunTime.boxToInteger(index$1));
    }

    public static final /* synthetic */ String $anonfun$fileNamed$1(AbstractFile $this, String name$1) {
        String string = "Tried to find '%s' in '%s' but it is not a directory";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{name$1, $this.path()}));
    }

    public static final /* synthetic */ String $anonfun$subdirectoryNamed$1(AbstractFile $this, String name$2) {
        String string = "Tried to find '%s' in '%s' but it is not a directory";
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new StringOps(string).format(Predef$.MODULE$.genericWrapArray(new Object[]{name$2, $this.path()}));
    }

    public AbstractFile() {
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        TraversableLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        Traversable.$init$(this);
        GenIterable.$init$(this);
        IterableLike.$init$(this);
        Iterable.$init$(this);
    }

    public static final /* synthetic */ AbstractFile $anonfun$lookupPathUnchecked$1$adapted(AbstractFile f, String p, Object dir) {
        return f.lookupNameUnchecked(p, BoxesRunTime.unboxToBoolean(dir));
    }
}

