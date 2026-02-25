/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.io.File;
import java.io.Reader;
import scala.Function1;
import scala.Function3;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractSeq;
import scala.collection.IndexedSeq;
import scala.collection.IndexedSeqLike;
import scala.collection.Iterator;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.Page;
import scala.collection.immutable.PagedSeq$;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.StringBuilder;
import scala.io.Source;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0005ux!B\u0012%\u0011\u0003Yc!B\u0017%\u0011\u0003q\u0003\"B\u001a\u0002\t\u0003!\u0004bB\u001b\u0002\u0005\u0004%)A\u000e\u0005\u0007s\u0005\u0001\u000bQB\u001c\t\u000bi\nA\u0011A\u001e\t\u000f\u0005E\u0014\u0001\"\u0001\u0002t!9\u0011QR\u0001\u0005\u0002\u0005=\u0005bBAG\u0003\u0011\u0005\u0011\u0011\u0017\u0005\b\u0003o\u000bA\u0011AA]\u0011\u001d\t9,\u0001C\u0001\u0003{Cq!!1\u0002\t\u0003\t\u0019\rC\u0004\u0002T\u0006!\t!!6\t\u000f\u0005M\u0017\u0001\"\u0001\u0002`\"9\u00111]\u0001\u0005\u0002\u0005\u0015h\u0001B\u0017%\u0001}B\u0001bU\b\u0003\u0002\u0003\u0006I\u0001\u0016\u0005\t;>\u0011\t\u0011)A\u0005=\"A\u0011m\u0004B\u0001B\u0003%!\f\u0003\u0005c\u001f\t\u0005\t\u0015!\u0003[\u0011!\u0019wBaA!\u0002\u0017!\u0007\"B\u001a\u0010\t#Q\u0007\"B\u001a\u0010\t\u0003\u0011\bbB<\u0010\u0001\u0004%I\u0001\u001f\u0005\bs>\u0001\r\u0011\"\u0003{\u0011\u001d\t\ta\u0004Q!\nyCa!a\u0001\u0010\t\u0013A\bbBA\u0003\u001f\u0011%\u0011q\u0001\u0005\b\u0003\u0013yA\u0011BA\u0006\u0011\u001d\t\tb\u0004C\u0001\u0003'Aq!!\u0006\u0010\t\u0003\t9\u0002C\u0004\u0002\u001e=!\t%a\b\t\u000f\u0005%r\u0002\"\u0011\u0002,!9\u0011\u0011F\b\u0005\u0002\u0005U\u0002bBA\u001d\u001f\u0011\u0005\u00131H\u0001\t!\u0006<W\rZ*fc*\u0011QEJ\u0001\nS6lW\u000f^1cY\u0016T!a\n\u0015\u0002\u0015\r|G\u000e\\3di&|gNC\u0001*\u0003\u0015\u00198-\u00197b\u0007\u0001\u0001\"\u0001L\u0001\u000e\u0003\u0011\u0012\u0001\u0002U1hK\u0012\u001cV-]\n\u0003\u0003=\u0002\"\u0001M\u0019\u000e\u0003!J!A\r\u0015\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\t1&A\bV]\u0012,G/\u001a:nS:,G-\u00128e+\u00059t\"\u0001\u001d\u001e\t}|\u0000\u0000\u0000\u0001\u0011+:$W\r^3s[&tW\rZ#oI\u0002\nAB\u001a:p[&#XM]1u_J,2\u0001PA0)\ri\u0014q\r\u000b\u0004}\u0005\u0005\u0004\u0003\u0002\u0017\u0010\u0003;*\"\u0001Q$\u0014\u0007=\t\u0005\u000bE\u0002C\u0007\u0016k\u0011AJ\u0005\u0003\t\u001a\u00121\"\u00112tiJ\f7\r^*fcB\u0011ai\u0012\u0007\u0001\t\u0015AuB1\u0001J\u0005\u0005!\u0016C\u0001&N!\t\u00014*\u0003\u0002MQ\t9aj\u001c;iS:<\u0007C\u0001\u0019O\u0013\ty\u0005FA\u0002B]f\u00042AQ)F\u0013\t\u0011fE\u0001\u0006J]\u0012,\u00070\u001a3TKF\fA!\\8sKB1\u0001'V,[5jK!A\u0016\u0015\u0003\u0013\u0019+hn\u0019;j_:\u001c\u0004c\u0001\u0019Y\u000b&\u0011\u0011\f\u000b\u0002\u0006\u0003J\u0014\u0018-\u001f\t\u0003amK!\u0001\u0018\u0015\u0003\u0007%sG/\u0001\u0004gSJ\u001cH/\r\t\u0004Y}+\u0015B\u00011%\u0005\u0011\u0001\u0016mZ3\u0002\u000bM$\u0018M\u001d;\u0002\u0007\u0015tG-\u0001\u0006fm&$WM\\2fIM\u00022!\u001a5F\u001b\u00051'BA4)\u0003\u001d\u0011XM\u001a7fGRL!!\u001b4\u0003\u0011\rc\u0017m]:UC\u001e$Ra\u001b8paF$\"\u0001\\7\u0011\u00071zQ\tC\u0003d+\u0001\u000fA\rC\u0003T+\u0001\u0007A\u000bC\u0003^+\u0001\u0007a\fC\u0003b+\u0001\u0007!\fC\u0003c+\u0001\u0007!\f\u0006\u0002tmR\u0011A\u000e\u001e\u0005\bkZ\t\t\u0011q\u0001e\u0003))g/\u001b3f]\u000e,G\u0005\u000e\u0005\u0006'Z\u0001\r\u0001V\u0001\bGV\u0014(/\u001a8u+\u0005q\u0016aC2veJ,g\u000e^0%KF$\"a\u001f@\u0011\u0005Ab\u0018BA?)\u0005\u0011)f.\u001b;\t\u000f}D\u0012\u0011!a\u0001=\u0006\u0019\u0001\u0010J\u0019\u0002\u0011\r,(O]3oi\u0002\na\u0001\\1uKN$\u0018aB1eI6{'/\u001a\u000b\u0002=\u0006!\u0001/Y4f)\rq\u0016Q\u0002\u0005\u0007\u0003\u001fa\u0002\u0019\u0001.\u0002\u0011\u0005\u00147/\u001b8eKb\fa\u0001\\3oORDW#\u0001.\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0007\u0015\u000bI\u0002\u0003\u0004\u0002\u001cy\u0001\rAW\u0001\u0006S:$W\r_\u0001\fSN$UMZ5oK\u0012\fE\u000f\u0006\u0003\u0002\"\u0005\u001d\u0002c\u0001\u0019\u0002$%\u0019\u0011Q\u0005\u0015\u0003\u000f\t{w\u000e\\3b]\"1\u00111D\u0010A\u0002i\u000bQa\u001d7jG\u0016$R\u0001\\A\u0017\u0003cAa!a\f!\u0001\u0004Q\u0016AB0ti\u0006\u0014H\u000f\u0003\u0004\u00024\u0001\u0002\rAW\u0001\u0005?\u0016tG\rF\u0002m\u0003oAQ!Y\u0011A\u0002i\u000b\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0003{\u0001B!a\u0010\u0002J5\u0011\u0011\u0011\t\u0006\u0005\u0003\u0007\n)%\u0001\u0003mC:<'BAA$\u0003\u0011Q\u0017M^1\n\t\u0005-\u0013\u0011\t\u0002\u0007'R\u0014\u0018N\\4)\u000f=\ty%!\u0016\u0002ZA\u0019\u0001'!\u0015\n\u0007\u0005M\u0003F\u0001\u0006eKB\u0014XmY1uK\u0012\f#!a\u0016\u0002\u007fQD\u0017n\u001d\u0011dY\u0006\u001c8\u000fI<jY2\u0004#-\u001a\u0011n_Z,G\r\t;pAQDW\rI:dC2\fW\u0006]1sg\u0016\u0014XfY8nE&t\u0017\r^8sg\u0002jw\u000eZ;mK\u0006\u0012\u00111L\u0001\u0007e9\n\u0014G\f\u001d\u0011\u0007\u0019\u000by\u0006B\u0003I\u000b\t\u0007\u0011\nC\u0005\u0002d\u0015\t\t\u0011q\u0001\u0002f\u0005QQM^5eK:\u001cW\rJ\u0019\u0011\t\u0015D\u0017Q\f\u0005\b\u0003S*\u0001\u0019AA6\u0003\u0019\u0019x.\u001e:dKB)!)!\u001c\u0002^%\u0019\u0011q\u000e\u0014\u0003\u0011%#XM]1u_J\fAB\u001a:p[&#XM]1cY\u0016,B!!\u001e\u0002~Q!\u0011qOAC)\u0011\tI(a \u0011\t1z\u00111\u0010\t\u0004\r\u0006uD!\u0002%\u0007\u0005\u0004I\u0005\"CAA\r\u0005\u0005\t9AAB\u0003))g/\u001b3f]\u000e,GE\r\t\u0005K\"\fY\bC\u0004\u0002j\u0019\u0001\r!a\"\u0011\u000b1\nI)a\u001f\n\u0007\u0005-EE\u0001\u0005Ji\u0016\u0014\u0018M\u00197f\u0003-1'o\\7TiJLgnZ:\u0015\t\u0005E\u0015\u0011\u0014\t\u0005Y=\t\u0019\nE\u00021\u0003+K1!a&)\u0005\u0011\u0019\u0005.\u0019:\t\u000f\u0005%t\u00011\u0001\u0002\u001cB)!)!\u001c\u0002\u001eB!\u0011qTAW\u001d\u0011\t\t+!+\u0011\u0007\u0005\r\u0006&\u0004\u0002\u0002&*\u0019\u0011q\u0015\u0016\u0002\rq\u0012xn\u001c;?\u0013\r\tY\u000bK\u0001\u0007!J,G-\u001a4\n\t\u0005-\u0013q\u0016\u0006\u0004\u0003WCC\u0003BAI\u0003gCq!!\u001b\t\u0001\u0004\t)\fE\u0003-\u0003\u0013\u000bi*A\u0005ge>lG*\u001b8fgR!\u0011\u0011SA^\u0011\u001d\tI'\u0003a\u0001\u00037#B!!%\u0002@\"9\u0011\u0011\u000e\u0006A\u0002\u0005U\u0016A\u00034s_6\u0014V-\u00193feR!\u0011\u0011SAc\u0011\u001d\tIg\u0003a\u0001\u0003\u000f\u0004B!!3\u0002P6\u0011\u00111\u001a\u0006\u0005\u0003\u001b\f)%\u0001\u0002j_&!\u0011\u0011[Af\u0005\u0019\u0011V-\u00193fe\u0006AaM]8n\r&dW\r\u0006\u0003\u0002\u0012\u0006]\u0007bBA5\u0019\u0001\u0007\u0011\u0011\u001c\t\u0005\u0003\u0013\fY.\u0003\u0003\u0002^\u0006-'\u0001\u0002$jY\u0016$B!!%\u0002b\"9\u0011\u0011N\u0007A\u0002\u0005u\u0015A\u00034s_6\u001cv.\u001e:dKR!\u0011\u0011SAt\u0011\u001d\tIG\u0004a\u0001\u0003S\u0004B!a;\u0002p6\u0011\u0011Q\u001e\u0006\u0004\u0003\u001bD\u0013\u0002BAy\u0003[\u0014aaU8ve\u000e,\u0007fB\u0001\u0002P\u0005U\u0018\u0011L\u0011\u0003\u0003o\f\u0001\t\u001e5jg\u0002z'M[3di\u0002:\u0018\u000e\u001c7!E\u0016\u0004Sn\u001c<fI\u0002\"x\u000e\t;iK\u0002\u001a8-\u00197b[A\f'o]3s[\r|WNY5oCR|'o\u001d\u0011n_\u0012,H.\u001a\u0015\b\u0003\u0005=\u0013QKA-Q\u001d\u0001\u0011qJA{\u00033\u0002")
public class PagedSeq<T>
extends AbstractSeq<T>
implements IndexedSeq<T> {
    private final Function3<Object, Object, Object, Object> more;
    private final Page<T> first1;
    private final int start;
    private final int end;
    private final ClassTag<T> evidence$3;
    private Page<T> current;

    public static PagedSeq<Object> fromSource(Source source2) {
        return PagedSeq$.MODULE$.fromSource(source2);
    }

    public static PagedSeq<Object> fromFile(String string) {
        return PagedSeq$.MODULE$.fromFile(string);
    }

    public static PagedSeq<Object> fromFile(File file) {
        return PagedSeq$.MODULE$.fromFile(file);
    }

    public static PagedSeq<Object> fromReader(Reader reader) {
        return PagedSeq$.MODULE$.fromReader(reader);
    }

    public static PagedSeq<Object> fromLines(Iterable<String> iterable) {
        return PagedSeq$.MODULE$.fromLines(iterable);
    }

    public static PagedSeq<Object> fromLines(Iterator<String> iterator2) {
        return PagedSeq$.MODULE$.fromLines(iterator2);
    }

    public static PagedSeq<Object> fromStrings(Iterable<String> iterable) {
        return PagedSeq$.MODULE$.fromStrings(iterable);
    }

    public static PagedSeq<Object> fromStrings(Iterator<String> iterator2) {
        return PagedSeq$.MODULE$.fromStrings(iterator2);
    }

    public static <T> PagedSeq<T> fromIterable(Iterable<T> iterable, ClassTag<T> classTag) {
        return PagedSeq$.MODULE$.fromIterable(iterable, classTag);
    }

    public static <T> PagedSeq<T> fromIterator(Iterator<T> iterator2, ClassTag<T> classTag) {
        return PagedSeq$.MODULE$.fromIterator(iterator2, classTag);
    }

    public static int UndeterminedEnd() {
        return PagedSeq$.MODULE$.UndeterminedEnd();
    }

    @Override
    public GenericCompanion<IndexedSeq> companion() {
        return IndexedSeq.companion$(this);
    }

    @Override
    public IndexedSeq<T> seq() {
        return IndexedSeq.seq$(this);
    }

    @Override
    public int hashCode() {
        return IndexedSeqLike.hashCode$(this);
    }

    @Override
    public IndexedSeq<T> thisCollection() {
        return IndexedSeqLike.thisCollection$(this);
    }

    @Override
    public IndexedSeq toCollection(Object repr) {
        return IndexedSeqLike.toCollection$(this, repr);
    }

    @Override
    public Iterator<T> iterator() {
        return IndexedSeqLike.iterator$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return IndexedSeqLike.toBuffer$(this);
    }

    @Override
    public int sizeHintIfCheap() {
        return IndexedSeqLike.sizeHintIfCheap$(this);
    }

    private Page<T> current() {
        return this.current;
    }

    private void current_$eq(Page<T> x$1) {
        this.current = x$1;
    }

    private Page<T> latest() {
        return this.first1.latest();
    }

    private Page<T> addMore() {
        return this.latest().addMore(this.more);
    }

    private Page<T> page(int absindex) {
        if (absindex < this.current().start()) {
            this.current_$eq(this.first1);
        }
        while (absindex >= this.current().end() && this.current().next() != null) {
            this.current_$eq(this.current().next());
        }
        while (absindex >= this.current().end() && !this.current().isLast()) {
            this.current_$eq(this.addMore());
        }
        return this.current();
    }

    @Override
    public int length() {
        while (!this.latest().isLast() && this.latest().end() < this.end) {
            this.addMore();
        }
        int n = this.latest().end();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return RichInt$.MODULE$.min$extension(n, this.end) - this.start;
    }

    @Override
    public T apply(int index) {
        if (this.isDefinedAt(index)) {
            return this.page(index + this.start).apply(index + this.start);
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(index)).toString());
    }

    @Override
    public boolean isDefinedAt(int index) {
        int absidx;
        return index >= 0 && index < this.end - this.start && (absidx = index + this.start) >= 0 && absidx < this.page(absidx).end();
    }

    @Override
    public PagedSeq<T> slice(int _start, int _end) {
        this.page(this.start);
        int s = this.start + _start;
        int e = _end == Integer.MAX_VALUE ? _end : this.start + _end;
        Page<T> f = this.first1;
        while (f.end() <= s && !f.isLast()) {
            if (f.next() == null) {
                f = f.addMore(this.more);
                continue;
            }
            f = f.next();
        }
        return new PagedSeq<T>(this.more, f, s, e, this.evidence$3);
    }

    public PagedSeq<T> slice(int start) {
        return this.slice(start, Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        this.iterator().foreach((Function1<Object, StringBuilder> & java.io.Serializable & Serializable)ch -> buf.append(ch));
        return buf.toString();
    }

    public PagedSeq(Function3<Object, Object, Object, Object> more, Page<T> first1, int start, int end, ClassTag<T> evidence$3) {
        this.more = more;
        this.first1 = first1;
        this.start = start;
        this.end = end;
        this.evidence$3 = evidence$3;
        IndexedSeqLike.$init$(this);
        IndexedSeq.$init$(this);
        this.current = first1;
    }

    public PagedSeq(Function3<Object, Object, Object, Object> more, ClassTag<T> evidence$4) {
        this(more, new Page<T>(0, evidence$4), 0, Integer.MAX_VALUE, evidence$4);
    }
}

