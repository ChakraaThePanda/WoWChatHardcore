/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import java.util.stream.IntStream;
import scala.collection.IndexedSeq;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001A3A\u0001C\u0005\u0003\u001d!A!\u0004\u0001BC\u0002\u0013\u00051\u0004\u0003\u0005'\u0001\t\u0005\t\u0015!\u0003\u001d\u0011\u00159\u0003\u0001\"\u0001)\u0011\u0015a\u0003\u0001\"\u0001.\u0011\u0015\t\u0004\u0001\"\u00013\u0011\u0015)\u0004\u0001\"\u00017\u0011\u0015Y\u0004\u0001\"\u0011=\u0005=\u0019V-]\"iCJ\u001cV-];f]\u000e,'B\u0001\u0006\f\u0003\u001d\u0011XO\u001c;j[\u0016T\u0011\u0001D\u0001\u0006g\u000e\fG.Y\u0002\u0001'\r\u0001qb\u0006\t\u0003!Ui\u0011!\u0005\u0006\u0003%M\tA\u0001\\1oO*\tA#\u0001\u0003kCZ\f\u0017B\u0001\f\u0012\u0005\u0019y%M[3diB\u0011\u0001\u0003G\u0005\u00033E\u0011Ab\u00115beN+\u0017/^3oG\u0016\f!\u0001_:\u0016\u0003q\u00012!\b\u0011#\u001b\u0005q\"BA\u0010\f\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0003Cy\u0011!\"\u00138eKb,GmU3r!\t\u0019C%D\u0001\f\u0013\t)3B\u0001\u0003DQ\u0006\u0014\u0018a\u0001=tA\u00051A(\u001b8jiz\"\"!K\u0016\u0011\u0005)\u0002Q\"A\u0005\t\u000bi\u0019\u0001\u0019\u0001\u000f\u0002\r1,gn\u001a;i)\u0005q\u0003CA\u00120\u0013\t\u00014BA\u0002J]R\faa\u00195be\u0006#HC\u0001\u00124\u0011\u0015!T\u00011\u0001/\u0003\u0015Ig\u000eZ3y\u0003-\u0019XOY*fcV,gnY3\u0015\u0007]9\u0014\bC\u00039\r\u0001\u0007a&A\u0003ti\u0006\u0014H\u000fC\u0003;\r\u0001\u0007a&A\u0002f]\u0012\f\u0001\u0002^8TiJLgn\u001a\u000b\u0002{A\u0011a(\u0012\b\u0003\u007f\r\u0003\"\u0001Q\u0006\u000e\u0003\u0005S!AQ\u0007\u0002\rq\u0012xn\u001c;?\u0013\t!5\"\u0001\u0004Qe\u0016$WMZ\u0005\u0003\r\u001e\u0013aa\u0015;sS:<'B\u0001#\fQ\u0011\u0001\u0011\n\u0014(\u0011\u0005\rR\u0015BA&\f\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0002\u001b\u0006QRo]3!!J,G-\u001a4/'\u0016\f8\t[1s'\u0016\fX/\u001a8dK\u0006\nq*\u0001\u00043]E\nd\u0006\r")
public final class SeqCharSequence
implements CharSequence {
    private final IndexedSeq<Object> xs;

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }

    public IndexedSeq<Object> xs() {
        return this.xs;
    }

    @Override
    public int length() {
        return this.xs().length();
    }

    @Override
    public char charAt(int index) {
        return BoxesRunTime.unboxToChar(this.xs().apply(index));
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new SeqCharSequence((IndexedSeq)this.xs().slice(start, end));
    }

    @Override
    public String toString() {
        return this.xs().mkString("");
    }

    public SeqCharSequence(IndexedSeq<Object> xs) {
        this.xs = xs;
    }
}

