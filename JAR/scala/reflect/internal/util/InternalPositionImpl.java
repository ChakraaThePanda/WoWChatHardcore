/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.Function2;
import scala.Predef$;
import scala.Serializable;
import scala.collection.IndexedSeqOptimized;
import scala.collection.Seq;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.StringBuilder;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.FakePos;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.NoSourceFile$;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.Position$;
import scala.reflect.internal.util.SourceFile;
import scala.reflect.io.AbstractFile;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005h!C\u001b7!\u0003\r\tA\u000e n\u0011\u0015\u0019\u0005\u0001\"\u0001F\u0011\u0015I\u0005A\"\u0001K\u0011\u0015q\u0005A\"\u0001K\u0011\u0015y\u0005A\"\u0001Q\u0011\u0015)\u0006A\"\u0001W\u0011\u0015Q\u0006A\"\u0001W\u0011\u0015Y\u0006A\"\u0001W\u0011\u0015a\u0006\u0001\"\u0001^\u0011\u0015!\u0007\u0001\"\u0001K\u0011\u0015)\u0007\u0001\"\u0001K\u0011\u00151\u0007\u0001\"\u0001K\u0011\u00159\u0007\u0001\"\u0001i\u0011\u0015Y\u0007\u0001\"\u0001m\u0011\u0015q\u0007\u0001\"\u0001p\u0011\u0015\t\b\u0001\"\u0001s\u0011\u0015!\b\u0001\"\u0001v\u0011\u00159\b\u0001\"\u0001y\u0011\u0015Q\b\u0001\"\u0001|\u0011\u0015q\b\u0001\"\u0001m\u0011\u0015y\b\u0001\"\u0001m\u0011\u0019\t\t\u0001\u0001C\u0001Y\"9\u00111\u0001\u0001\u0005\u0002\u0005\u0015\u0001bBA\u0002\u0001\u0011\u0005\u0011Q\u0003\u0005\b\u00033\u0001A\u0011AA\u000e\u0011\u001d\ty\u0002\u0001C\u0001\u0003CAq!!\n\u0001\t\u0003\t9\u0003C\u0004\u0002,\u0001!\t!!\f\t\u000f\u0005M\u0002\u0001\"\u0001\u00026!9\u0011\u0011\b\u0001\u0005\u0002\u0005m\u0002bBA \u0001\u0011\u0005\u0011\u0011\t\u0005\b\u0003\u000b\u0002A\u0011AA$\u0011\u001d\tY\u0005\u0001C\u0001\u0003\u001bBq!!\u0015\u0001\t\u0003\t\u0019\u0006\u0003\u0004\u0002X\u0001!\tA\u0016\u0005\u0007\u00033\u0002A\u0011\u0001,\t\u000f\u0005m\u0003\u0001\"\u0001\u0002^!9\u0011Q\u000f\u0001\u0005\u0002\u0005u\u0003bBA<\u0001\u0011\u0005\u0011Q\f\u0005\b\u0003\u0013\u0003A\u0011AAF\u0011\u001d\t\t\n\u0001C\u0001\u0003;Bq!a%\u0001\t\u0003\ti\u0006C\u0004\u0002\u0016\u0002!\t!a&\t\u000f\u0005m\u0005\u0001\"\u0003\u0002\u001e\"9\u0011\u0011\u0015\u0001\u0005\n\u0005\r\u0006\"CAW\u0001E\u0005I\u0011BAX\u0011%\t)\rAI\u0001\n\u0013\t9\rC\u0005\u0002L\u0002\t\n\u0011\"\u0003\u0002H\"I\u0011Q\u001a\u0001\u0012\u0002\u0013%\u0011q\u0019\u0005\b\u0003\u001f\u0004A\u0011BAi\u0011\u0019\t\u0019\u000e\u0001C\u0005\u0015\"9\u0011Q\u001b\u0001\u0005\n\u0005]\u0007bBAn\u0001\u0011%\u0011Q\u001c\u0002\u0015\u0013:$XM\u001d8bYB{7/\u001b;j_:LU\u000e\u001d7\u000b\u0005]B\u0014\u0001B;uS2T!!\u000f\u001e\u0002\u0011%tG/\u001a:oC2T!a\u000f\u001f\u0002\u000fI,g\r\\3di*\tQ(A\u0003tG\u0006d\u0017m\u0005\u0002\u0001\u007fA\u0011\u0001)Q\u0007\u0002y%\u0011!\t\u0010\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%\u0007\u0001!\u0012A\u0012\t\u0003\u0001\u001eK!\u0001\u0013\u001f\u0003\tUs\u0017\u000e^\u0001\nSN$UMZ5oK\u0012,\u0012a\u0013\t\u0003\u00012K!!\u0014\u001f\u0003\u000f\t{w\u000e\\3b]\u00069\u0011n\u001d*b]\u001e,\u0017AB:pkJ\u001cW-F\u0001R!\t\u00116+D\u00017\u0013\t!fG\u0001\u0006T_V\u00148-\u001a$jY\u0016\fQa\u001d;beR,\u0012a\u0016\t\u0003\u0001bK!!\u0017\u001f\u0003\u0007%sG/A\u0003q_&tG/A\u0002f]\u0012\fQBZ5oC2\u0004vn]5uS>tW#\u00010\u0011\u0005}\u0003W\"\u0001\u0001\n\u0005\u0005\u0014'a\u0001)pg&\u00111M\u000e\u0002\t!>\u001c\u0018\u000e^5p]\u0006i\u0011n\u001d+sC:\u001c\b/\u0019:f]R\f\u0001\"[:PM\u001a\u001cX\r^\u0001\u000eSN|\u0005/Y9vKJ\u000bgnZ3\u0002\u0017A|\u0017N\u001c;Pe\u0016c7/\u001a\u000b\u0003/&DQA\u001b\u0007A\u0002]\u000b1!\u00197u\u0003=i\u0017m[3Ue\u0006t7\u000f]1sK:$X#A7\u0011\u0005I\u0013\u0017!C<ji\"\u001cF/\u0019:u)\ti\u0007\u000fC\u0003V\u001d\u0001\u0007q+A\u0005xSRD\u0007k\\5oiR\u0011Qn\u001d\u0005\u00065>\u0001\raV\u0001\bo&$\b.\u00128e)\tig\u000fC\u0003\\!\u0001\u0007q+\u0001\u0006xSRD7k\\;sG\u0016$\"!\\=\t\u000b=\u000b\u0002\u0019A)\u0002\u0013]LG\u000f[*iS\u001a$HCA7}\u0011\u0015i(\u00031\u0001X\u0003\u0015\u0019\b.\u001b4u\u0003)1wnY;t'R\f'\u000f^\u0001\u0006M>\u001cWo]\u0001\tM>\u001cWo]#oI\u0006!AEY1s)\u0015i\u0017qAA\u0006\u0011\u0019\tIA\u0006a\u0001[\u0006!A\u000f[1u\u0011\u001d\tiA\u0006a\u0001\u0003\u001f\tQ\u0001]8tKN\u0004B\u0001QA\t[&\u0019\u00111\u0003\u001f\u0003\u0015q\u0012X\r]3bi\u0016$g\bF\u0002n\u0003/Aa!!\u0003\u0018\u0001\u0004i\u0017a\u0001\u0013vaR\u0019Q.!\b\t\u000biC\u0002\u0019A,\u0002\u000f\u0011\u0012\u0017M\u001d\u0013vaR\u0019Q.a\t\t\r\u0005%\u0011\u00041\u0001n\u0003\u001d!S\u000f\u001d\u0013cCJ$2!\\A\u0015\u0011\u0019\tIA\u0007a\u0001[\u0006)QO\\5p]R\u0019Q.a\f\t\r\u0005E2\u00041\u0001n\u0003\r\u0001xn]\u0001\tS:\u001cG.\u001e3fgR\u00191*a\u000e\t\r\u0005EB\u00041\u0001n\u0003A\u0001(o\u001c9fe2L\u0018J\\2mk\u0012,7\u000fF\u0002L\u0003{Aa!!\r\u001e\u0001\u0004i\u0017\u0001\u00039sK\u000e,G-Z:\u0015\u0007-\u000b\u0019\u0005\u0003\u0004\u00022y\u0001\r!\\\u0001\u0011aJ|\u0007/\u001a:msB\u0013XmY3eKN$2aSA%\u0011\u0019\t\td\ba\u0001[\u0006I1/Y7f%\u0006tw-\u001a\u000b\u0004\u0017\u0006=\u0003BBA\u0019A\u0001\u0007Q.\u0001\u0005pm\u0016\u0014H.\u00199t)\rY\u0015Q\u000b\u0005\u0007\u0003c\t\u0003\u0019A7\u0002\t1Lg.Z\u0001\u0007G>dW/\u001c8\u0002\u00171Lg.Z\"p]R,g\u000e^\u000b\u0003\u0003?\u0002B!!\u0019\u0002p9!\u00111MA6!\r\t)\u0007P\u0007\u0003\u0003OR1!!\u001bE\u0003\u0019a$o\\8u}%\u0019\u0011Q\u000e\u001f\u0002\rA\u0013X\rZ3g\u0013\u0011\t\t(a\u001d\u0003\rM#(/\u001b8h\u0015\r\ti\u0007P\u0001\nY&tWmQ1sKR\f\u0011\u0002\\5oK\u000e\u000b'/\u0019;)\u000f\u0019\nY(!!\u0002\u0006B\u0019\u0001)! \n\u0007\u0005}DH\u0001\u0006eKB\u0014XmY1uK\u0012\f#!a!\u0002\u001fU\u001cX\r\t1mS:,7)\u0019:fi\u0002\f#!a\"\u0002\rIr\u0013'\r\u00181\u0003%\u0019\bn\\<FeJ|'\u000f\u0006\u0003\u0002`\u00055\u0005bBAHO\u0001\u0007\u0011qL\u0001\u0004[N<\u0017!C:i_^$UMY;h\u0003\u0011\u0019\bn\\<\u0002\u0017M\fW.\u001a)pS:$\u0018i\u001d\u000b\u0004\u0017\u0006e\u0005BBA\u0005U\u0001\u0007Q.\u0001\u0005bg>3gm]3u)\ri\u0017q\u0014\u0005\u00065.\u0002\raV\u0001\nG>\u0004\u0018PU1oO\u0016$\u0012\"\\AS\u0003O\u000bI+a+\t\u000f=c\u0003\u0013!a\u0001#\"9Q\u000b\fI\u0001\u0002\u00049\u0006b\u0002.-!\u0003\u0005\ra\u0016\u0005\b72\u0002\n\u00111\u0001X\u0003M\u0019w\u000e]=SC:<W\r\n3fM\u0006,H\u000e\u001e\u00132+\t\t\tLK\u0002R\u0003g[#!!.\u0011\t\u0005]\u0016\u0011Y\u0007\u0003\u0003sSA!a/\u0002>\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0004\u0003\u007fc\u0014AC1o]>$\u0018\r^5p]&!\u00111YA]\u0005E)hn\u00195fG.,GMV1sS\u0006t7-Z\u0001\u0014G>\u0004\u0018PU1oO\u0016$C-\u001a4bk2$HEM\u000b\u0003\u0003\u0013T3aVAZ\u0003M\u0019w\u000e]=SC:<W\r\n3fM\u0006,H\u000e\u001e\u00134\u0003M\u0019w\u000e]=SC:<W\r\n3fM\u0006,H\u000e\u001e\u00135\u0003=\u0019\u0017\r\\2vY\u0006$XmQ8mk6tG#A,\u0002\u0013!\f7oU8ve\u000e,\u0017A\u00032pi\"\u0014\u0016M\\4fgR\u00191*!7\t\r\u0005%1\u00071\u0001n\u0003-\u0011w\u000e\u001e5EK\u001aLg.\u001a3\u0015\u0007-\u000by\u000e\u0003\u0004\u0002\nQ\u0002\r!\u001c")
public interface InternalPositionImpl {
    public boolean isDefined();

    public boolean isRange();

    public SourceFile source();

    public int start();

    public int point();

    public int end();

    public static /* synthetic */ Position finalPosition$(InternalPositionImpl $this) {
        return $this.finalPosition();
    }

    default public Position finalPosition() {
        return ((Position)this).source().positionInUltimateSource((Position)this);
    }

    public static /* synthetic */ boolean isTransparent$(InternalPositionImpl $this) {
        return $this.isTransparent();
    }

    default public boolean isTransparent() {
        return false;
    }

    public static /* synthetic */ boolean isOffset$(InternalPositionImpl $this) {
        return $this.isOffset();
    }

    default public boolean isOffset() {
        return ((Position)this).isDefined() && !((Position)this).isRange();
    }

    public static /* synthetic */ boolean isOpaqueRange$(InternalPositionImpl $this) {
        return $this.isOpaqueRange();
    }

    default public boolean isOpaqueRange() {
        return ((Position)this).isRange() && !this.isTransparent();
    }

    public static /* synthetic */ int pointOrElse$(InternalPositionImpl $this, int alt) {
        return $this.pointOrElse(alt);
    }

    default public int pointOrElse(int alt) {
        if (((Position)this).isDefined()) {
            return ((Position)this).point();
        }
        return alt;
    }

    public static /* synthetic */ Position makeTransparent$(InternalPositionImpl $this) {
        return $this.makeTransparent();
    }

    default public Position makeTransparent() {
        if (this.isOpaqueRange()) {
            return Position$.MODULE$.transparent(((Position)this).source(), ((Position)this).start(), ((Position)this).point(), ((Position)this).end());
        }
        return (Position)this;
    }

    public static /* synthetic */ Position withStart$(InternalPositionImpl $this, int start) {
        return $this.withStart(start);
    }

    default public Position withStart(int start) {
        SourceFile x$2 = this.copyRange$default$1();
        int x$3 = this.copyRange$default$3();
        int x$4 = this.copyRange$default$4();
        return this.copyRange(x$2, start, x$3, x$4);
    }

    public static /* synthetic */ Position withPoint$(InternalPositionImpl $this, int point) {
        return $this.withPoint(point);
    }

    default public Position withPoint(int point) {
        if (((Position)this).isRange()) {
            SourceFile x$2 = this.copyRange$default$1();
            int x$3 = this.copyRange$default$2();
            int x$4 = this.copyRange$default$4();
            return this.copyRange(x$2, x$3, point, x$4);
        }
        return Position$.MODULE$.offset(((Position)this).source(), point);
    }

    public static /* synthetic */ Position withEnd$(InternalPositionImpl $this, int end) {
        return $this.withEnd(end);
    }

    default public Position withEnd(int end) {
        SourceFile x$2 = this.copyRange$default$1();
        int x$3 = this.copyRange$default$2();
        int x$4 = this.copyRange$default$3();
        return this.copyRange(x$2, x$3, x$4, end);
    }

    public static /* synthetic */ Position withSource$(InternalPositionImpl $this, SourceFile source2) {
        return $this.withSource(source2);
    }

    default public Position withSource(SourceFile source2) {
        return this.copyRange(source2, this.copyRange$default$2(), this.copyRange$default$3(), this.copyRange$default$4());
    }

    public static /* synthetic */ Position withShift$(InternalPositionImpl $this, int shift) {
        return $this.withShift(shift);
    }

    default public Position withShift(int shift) {
        return Position$.MODULE$.range(((Position)this).source(), ((Position)this).start() + shift, ((Position)this).point() + shift, ((Position)this).end() + shift);
    }

    public static /* synthetic */ Position focusStart$(InternalPositionImpl $this) {
        return $this.focusStart();
    }

    default public Position focusStart() {
        if (((Position)this).isRange()) {
            return this.asOffset(((Position)this).start());
        }
        return (Position)this;
    }

    public static /* synthetic */ Position focus$(InternalPositionImpl $this) {
        return $this.focus();
    }

    default public Position focus() {
        if (((Position)this).isRange()) {
            return this.asOffset(((Position)this).point());
        }
        return (Position)this;
    }

    public static /* synthetic */ Position focusEnd$(InternalPositionImpl $this) {
        return $this.focusEnd();
    }

    default public Position focusEnd() {
        if (((Position)this).isRange()) {
            return this.asOffset(((Position)this).end());
        }
        return (Position)this;
    }

    public static /* synthetic */ Position $bar$(InternalPositionImpl $this, Position that, Seq poses) {
        return $this.$bar(that, poses);
    }

    default public Position $bar(Position that, Seq<Position> poses) {
        return poses.foldLeft(this.$bar(that), (Function2<Position, Position, Position> & java.io.Serializable & Serializable)(x$1, x$2) -> x$1.$bar((Position)x$2));
    }

    public static /* synthetic */ Position $bar$(InternalPositionImpl $this, Position that) {
        return $this.$bar(that);
    }

    default public Position $bar(Position that) {
        return this.union(that);
    }

    public static /* synthetic */ Position $up$(InternalPositionImpl $this, int point) {
        return $this.$up(point);
    }

    default public Position $up(int point) {
        return this.withPoint(point);
    }

    public static /* synthetic */ Position $bar$up$(InternalPositionImpl $this, Position that) {
        return $this.$bar$up(that);
    }

    default public Position $bar$up(Position that) {
        return this.$bar(that).$up(that.point());
    }

    public static /* synthetic */ Position $up$bar$(InternalPositionImpl $this, Position that) {
        return $this.$up$bar(that);
    }

    default public Position $up$bar(Position that) {
        return this.$bar(that).$up(((Position)this).point());
    }

    public static /* synthetic */ Position union$(InternalPositionImpl $this, Position pos) {
        return $this.union(pos);
    }

    default public Position union(Position pos) {
        if (!pos.isRange()) {
            return (Position)this;
        }
        if (((Position)this).isRange()) {
            int n = ((Position)this).start();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            int x$1 = RichInt$.MODULE$.min$extension(n, pos.start());
            int n2 = ((Position)this).end();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            int x$2 = RichInt$.MODULE$.max$extension(n2, pos.end());
            SourceFile x$3 = this.copyRange$default$1();
            int x$4 = this.copyRange$default$3();
            return this.copyRange(x$3, x$1, x$4, x$2);
        }
        return pos;
    }

    public static /* synthetic */ boolean includes$(InternalPositionImpl $this, Position pos) {
        return $this.includes(pos);
    }

    default public boolean includes(Position pos) {
        return ((Position)this).isRange() && pos.isDefined() && ((Position)this).start() <= pos.start() && pos.end() <= ((Position)this).end();
    }

    public static /* synthetic */ boolean properlyIncludes$(InternalPositionImpl $this, Position pos) {
        return $this.properlyIncludes(pos);
    }

    default public boolean properlyIncludes(Position pos) {
        return this.includes(pos) && (((Position)this).start() < pos.start() || pos.end() < ((Position)this).end());
    }

    public static /* synthetic */ boolean precedes$(InternalPositionImpl $this, Position pos) {
        return $this.precedes(pos);
    }

    default public boolean precedes(Position pos) {
        return this.bothDefined(pos) && ((Position)this).end() <= pos.start();
    }

    public static /* synthetic */ boolean properlyPrecedes$(InternalPositionImpl $this, Position pos) {
        return $this.properlyPrecedes(pos);
    }

    default public boolean properlyPrecedes(Position pos) {
        return this.bothDefined(pos) && ((Position)this).end() < pos.start();
    }

    public static /* synthetic */ boolean sameRange$(InternalPositionImpl $this, Position pos) {
        return $this.sameRange(pos);
    }

    default public boolean sameRange(Position pos) {
        return this.bothRanges(pos) && ((Position)this).start() == pos.start() && ((Position)this).end() == pos.end();
    }

    public static /* synthetic */ boolean overlaps$(InternalPositionImpl $this, Position pos) {
        return $this.overlaps(pos);
    }

    default public boolean overlaps(Position pos) {
        return this.bothRanges(pos) && ((Position)this).start() < pos.end() && pos.start() < ((Position)this).end();
    }

    public static /* synthetic */ int line$(InternalPositionImpl $this) {
        return $this.line();
    }

    default public int line() {
        if (this.hasSource()) {
            return ((Position)this).source().offsetToLine(((Position)this).point()) + 1;
        }
        return 0;
    }

    public static /* synthetic */ int column$(InternalPositionImpl $this) {
        return $this.column();
    }

    default public int column() {
        if (this.hasSource()) {
            return this.calculateColumn();
        }
        return 0;
    }

    public static /* synthetic */ String lineContent$(InternalPositionImpl $this) {
        return $this.lineContent();
    }

    default public String lineContent() {
        if (this.hasSource()) {
            return ((Position)this).source().lineToString(this.line() - 1);
        }
        return "";
    }

    public static /* synthetic */ String lineCaret$(InternalPositionImpl $this) {
        return $this.lineCaret();
    }

    default public String lineCaret() {
        if (this.hasSource()) {
            String string = " ";
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new java.lang.StringBuilder(1).append(new StringOps(string).$times(this.column() - 1)).append("^").toString();
        }
        return "";
    }

    public static /* synthetic */ String lineCarat$(InternalPositionImpl $this) {
        return $this.lineCarat();
    }

    default public String lineCarat() {
        return this.lineCaret();
    }

    public static /* synthetic */ String showError$(InternalPositionImpl $this, String msg) {
        return $this.showError(msg);
    }

    default public String showError(String msg) {
        String string;
        Position position = this.finalPosition();
        if (position instanceof FakePos) {
            String fmsg = ((FakePos)position).msg();
            string = new java.lang.StringBuilder(1).append(fmsg).append(" ").append(msg).toString();
        } else {
            string = NoPosition$.MODULE$.equals(position) ? msg : InternalPositionImpl.errorAt$1(position, msg);
        }
        return string;
    }

    public static /* synthetic */ String showDebug$(InternalPositionImpl $this) {
        return $this.showDebug();
    }

    default public String showDebug() {
        return this.toString();
    }

    public static /* synthetic */ String show$(InternalPositionImpl $this) {
        return $this.show();
    }

    default public String show() {
        if (this.isOpaqueRange()) {
            return new java.lang.StringBuilder(3).append("[").append(((Position)this).start()).append(":").append(((Position)this).end()).append("]").toString();
        }
        if (this.isTransparent()) {
            return new java.lang.StringBuilder(3).append("<").append(((Position)this).start()).append(":").append(((Position)this).end()).append(">").toString();
        }
        if (((Position)this).isDefined()) {
            return new java.lang.StringBuilder(2).append("[").append(((Position)this).point()).append("]").toString();
        }
        return "[NoPosition]";
    }

    public static /* synthetic */ boolean samePointAs$(InternalPositionImpl $this, Position that) {
        return $this.samePointAs(that);
    }

    default public boolean samePointAs(Position that) {
        if (that.isDefined() && ((Position)this).point() == that.point()) {
            AbstractFile abstractFile = ((Position)this).source().file();
            AbstractFile abstractFile2 = that.source().file();
            if (!(abstractFile != null ? !abstractFile.equals(abstractFile2) : abstractFile2 != null)) {
                return true;
            }
        }
        return false;
    }

    private Position asOffset(int point) {
        return Position$.MODULE$.offset(((Position)this).source(), point);
    }

    private Position copyRange(SourceFile source2, int start, int point, int end) {
        return Position$.MODULE$.range(source2, start, point, end);
    }

    private SourceFile copyRange$default$1() {
        return ((Position)this).source();
    }

    private int copyRange$default$2() {
        return ((Position)this).start();
    }

    private int copyRange$default$3() {
        return ((Position)this).point();
    }

    private int copyRange$default$4() {
        return ((Position)this).end();
    }

    private int calculateColumn() {
        int col = 0;
        for (int idx = ((Position)this).source().lineToOffset(((Position)this).source().offsetToLine(((Position)this).point())); idx != ((Position)this).point(); ++idx) {
            col += ((Position)this).source().content()[idx] == '\t' ? Position$.MODULE$.tabInc() - col % Position$.MODULE$.tabInc() : 1;
        }
        return col + 1;
    }

    private boolean hasSource() {
        return ((Position)this).source() != NoSourceFile$.MODULE$;
    }

    private boolean bothRanges(Position that) {
        return ((Position)this).isRange() && that.isRange();
    }

    private boolean bothDefined(Position that) {
        return ((Position)this).isDefined() && that.isDefined();
    }

    private static String u$1(int c) {
        return new StringOps("\\u%04x").format(Predef$.MODULE$.genericWrapArray(new Object[]{BoxesRunTime.boxToInteger(c)}));
    }

    private static boolean uable$1(int c) {
        return c < 32 && c != 9 || c == 127;
    }

    private static String escaped$1(String s) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (IndexedSeqOptimized.exists$(new StringOps(s), (Function1<Object, Object> & java.io.Serializable & Serializable)c -> BoxesRunTime.boxToBoolean(InternalPositionImpl.uable$1(BoxesRunTime.unboxToChar(c))))) {
            StringBuilder sb = new StringBuilder();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            StringOps foreach_this = new StringOps(s);
            int foreach_len = foreach_this.length();
            for (int foreach_i = 0; foreach_i < foreach_len; ++foreach_i) {
                Object a = foreach_this.apply(foreach_i);
                sb.append(InternalPositionImpl.uable$1(BoxesRunTime.unboxToChar(a)) ? InternalPositionImpl.u$1(BoxesRunTime.unboxToChar(a)) : BoxesRunTime.boxToCharacter(BoxesRunTime.unboxToChar(a)));
            }
            return sb.toString();
        }
        return s;
    }

    private static int where$1(Position p$1) {
        return p$1.line();
    }

    private static String content$1(Position p$1) {
        return InternalPositionImpl.escaped$1(p$1.lineContent());
    }

    private static String indicator$1(Position p$1) {
        return p$1.lineCaret();
    }

    private static String errorAt$1(Position p, String msg$1) {
        Integer arg$macro$1 = BoxesRunTime.boxToInteger(InternalPositionImpl.where$1(p));
        String arg$macro$3 = InternalPositionImpl.content$1(p);
        String arg$macro$4 = InternalPositionImpl.indicator$1(p);
        return new StringOps("%s: %s%n%s%n%s").format(Predef$.MODULE$.genericWrapArray(new Object[]{arg$macro$1, msg$1, arg$macro$3, arg$macro$4}));
    }

    public static void $init$(InternalPositionImpl $this) {
    }

    public static /* synthetic */ StringBuilder $anonfun$showError$2$adapted(StringBuilder sb$1, Object c) {
        return sb$1.append(InternalPositionImpl.uable$1(BoxesRunTime.unboxToChar(c)) ? InternalPositionImpl.u$1(BoxesRunTime.unboxToChar(c)) : BoxesRunTime.boxToCharacter(BoxesRunTime.unboxToChar(c)));
    }
}

