/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.math.Ordered;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.NoPhase$;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005c!\u0002\u0015*\u0003\u0003\u0001\u0004\u0002\u0003 \u0001\u0005\u000b\u0007I\u0011A \t\u0011\u0001\u0003!\u0011!Q\u0001\nqBQ!\u0011\u0001\u0005\u0002\t+A\u0001\u0012\u0001\u0001\u000b\"9\u0001\n\u0001b\u0001\n\u0003I\u0005B\u0002'\u0001A\u0003%!\nC\u0003N\u0001\u0011\u0005a\nC\u0003S\u0001\u0011\u0005a\nC\u0004T\u0001\t\u0007I\u0011\u0001(\t\rQ\u0003\u0001\u0015!\u0003P\u0011\u0015)\u0006\u0001\"\u0001O\u0011\u001d1\u0006\u00011A\u0005\n}Bqa\u0016\u0001A\u0002\u0013%\u0001\f\u0003\u0004_\u0001\u0001\u0006K\u0001\u0010\u0005\u0006?\u0002!\ta\u0010\u0005\u0006A\u0002!\t!\u0019\u0005\u0006K\u0002!\tA\u001a\u0005\u0006[\u00021\tA\u001c\u0005\u0006u\u0002!\tA\u001c\u0005\u0006w\u0002!\t!\u0019\u0005\by\u0002\u0001\r\u0011\"\u0003b\u0011\u001di\b\u00011A\u0005\nyDq!!\u0001\u0001A\u0003&!\rC\u0004\u0002\u0004\u0001!\t\"!\u0002\t\r\u0005-\u0001\u0001\"\u0002b\u0011!\ti\u0001\u0001b\u0001\n\u000b\t\u0007bBA\b\u0001\u0001\u0006iA\u0019\u0005\t\u0003#\u0001!\u0019!C\u0003C\"9\u00111\u0003\u0001!\u0002\u001b\u0011\u0007\u0002CA\u000b\u0001\t\u0007IQA1\t\u000f\u0005]\u0001\u0001)A\u0007E\"A\u0011\u0011\u0004\u0001C\u0002\u0013\u0015\u0011\rC\u0004\u0002\u001c\u0001\u0001\u000bQ\u00022\t\r\u0005u\u0001\u0001\"\u0001b\u0011\u001d\ty\u0002\u0001D\u0001\u0003CAq!a\t\u0001\t\u0003\n)\u0003C\u0004\u0002(\u0001!\t%!\u000b\t\u000f\u0005-\u0002\u0001\"\u0011\u0002.!9\u0011\u0011\b\u0001\u0005B\u0005m\"!\u0002)iCN,'B\u0001\u0016,\u0003!Ig\u000e^3s]\u0006d'B\u0001\u0017.\u0003\u001d\u0011XM\u001a7fGRT\u0011AL\u0001\u0006g\u000e\fG.Y\u0002\u0001'\r\u0001\u0011'\u000e\t\u0003eMj\u0011!L\u0005\u0003i5\u0012a!\u00118z%\u00164\u0007c\u0001\u001c:y9\u0011!gN\u0005\u0003q5\nq\u0001]1dW\u0006<W-\u0003\u0002;w\t9qJ\u001d3fe\u0016$'B\u0001\u001d.!\ti\u0004!D\u0001*\u0003\u0011\u0001(/\u001a<\u0016\u0003q\nQ\u0001\u001d:fm\u0002\na\u0001P5oSRtDC\u0001\u001fD\u0011\u0015q4\u00011\u0001=\u0005\tIE\r\u0005\u00023\r&\u0011q)\f\u0002\u0004\u0013:$\u0018AA5e+\u0005Q\u0005CA&\u0005\u001b\u0005\u0001\u0011aA5eA\u0005Ia.\u001a=u\r2\fwm]\u000b\u0002\u001fB\u0011!\u0007U\u0005\u0003#6\u0012A\u0001T8oO\u0006Aa.Z<GY\u0006<7/A\u0003g[\u0006\u001c8.\u0001\u0004g[\u0006\u001c8\u000eI\u0001\tM2\fw-T1tW\u0006\u0011a\u000e_\u0001\u0007]b|F%Z9\u0015\u0005ec\u0006C\u0001\u001a[\u0013\tYVF\u0001\u0003V]&$\bbB/\u000e\u0003\u0003\u0005\r\u0001P\u0001\u0004q\u0012\n\u0014a\u00018yA\u0005!a.\u001a=u\u0003\u001dA\u0017m\u001d(fqR,\u0012A\u0019\t\u0003e\rL!\u0001Z\u0017\u0003\u000f\t{w\u000e\\3b]\u0006A\u0011\u000e^3sCR|'/F\u0001h!\rA7\u000eP\u0007\u0002S*\u0011!.L\u0001\u000bG>dG.Z2uS>t\u0017B\u00017j\u0005!IE/\u001a:bi>\u0014\u0018\u0001\u00028b[\u0016,\u0012a\u001c\t\u0003a^t!!];\u0011\u0005IlS\"A:\u000b\u0005Q|\u0013A\u0002\u001fs_>$h(\u0003\u0002w[\u00051\u0001K]3eK\u001aL!\u0001_=\u0003\rM#(/\u001b8h\u0015\t1X&A\u0006eKN\u001c'/\u001b9uS>t\u0017!C2iK\u000e\\\u0017M\u00197f\u00031yVM]1tK\u0012$\u0016\u0010]3t\u0003AyVM]1tK\u0012$\u0016\u0010]3t?\u0012*\u0017\u000f\u0006\u0002Z\u007f\"9QLFA\u0001\u0002\u0004\u0011\u0017!D0fe\u0006\u001cX\r\u001a+za\u0016\u001c\b%A\bfe\u0006\u001cX\r\u001a+za\u0016\u001cx\fJ3r)\rI\u0016q\u0001\u0005\u0007\u0003\u0013A\u0002\u0019\u00012\u0002\u000bY\fG.^3\u0002\u0017\u0015\u0014\u0018m]3e)f\u0004Xm]\u0001\fM2\fGo\u00117bgN,7/\u0001\u0007gY\u0006$8\t\\1tg\u0016\u001c\b%A\u0006ta\u0016\u001c\u0017.\u00197ju\u0016$\u0017\u0001D:qK\u000eL\u0017\r\\5{K\u0012\u0004\u0013A\u0003:fM\u000eCWmY6fI\u0006Y!/\u001a4DQ\u0016\u001c7.\u001a3!\u00035\t7o]5h]N4\u0015.\u001a7eg\u0006q\u0011m]:jO:\u001ch)[3mIN\u0004\u0013aD6fKB\u001cH+\u001f9f!\u0006\u0014\u0018-\\:\u0002\u0007I,h\u000eF\u0001Z\u0003!!xn\u0015;sS:<G#A8\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012!R\u0001\u0007KF,\u0018\r\\:\u0015\u0007\t\fy\u0003C\u0004\u00022\u0019\u0002\r!a\r\u0002\u000b=$\b.\u001a:\u0011\u0007I\n)$C\u0002\u000285\u00121!\u00118z\u0003\u001d\u0019w.\u001c9be\u0016$2ASA\u001f\u0011\u0019\tyd\na\u0001y\u0005!A\u000f[1u\u0001")
public abstract class Phase
implements Ordered<Phase> {
    private final Phase prev;
    private final int id;
    private final long fmask;
    private Phase nx;
    private boolean _erasedTypes;
    private final boolean flatClasses;
    private final boolean specialized;
    private final boolean refChecked;
    private final boolean assignsFields;

    @Override
    public boolean $less(Object that) {
        return Ordered.$less$(this, that);
    }

    @Override
    public boolean $greater(Object that) {
        return Ordered.$greater$(this, that);
    }

    @Override
    public boolean $less$eq(Object that) {
        return Ordered.$less$eq$(this, that);
    }

    @Override
    public boolean $greater$eq(Object that) {
        return Ordered.$greater$eq$(this, that);
    }

    @Override
    public int compareTo(Object that) {
        return Ordered.compareTo$(this, that);
    }

    public Phase prev() {
        return this.prev;
    }

    public int id() {
        return this.id;
    }

    public long nextFlags() {
        return 0L;
    }

    public long newFlags() {
        return 0L;
    }

    public long fmask() {
        return this.fmask;
    }

    public long flagMask() {
        return this.fmask();
    }

    private Phase nx() {
        return this.nx;
    }

    private void nx_$eq(Phase x$1) {
        this.nx = x$1;
    }

    public Phase next() {
        if (this.nx() == NoPhase$.MODULE$) {
            return this;
        }
        return this.nx();
    }

    public boolean hasNext() {
        Phase phase = this.next();
        return phase == null || !((Object)phase).equals(this);
    }

    /*
     * WARNING - void declaration
     */
    public Iterator<Phase> iterator() {
        void iterate_f;
        Function1<Phase, Phase> & java.io.Serializable & Serializable intersect = (Function1<Phase, Phase> & java.io.Serializable & Serializable)x$1 -> x$1.nx();
        if (package$.MODULE$.Iterator() == null) {
            throw null;
        }
        return new AbstractIterator<T>(this, (Function1)iterate_f){
            private boolean first;
            private T acc;
            private final Function1 f$2;

            public boolean hasNext() {
                return true;
            }

            public T next() {
                if (this.first) {
                    this.first = false;
                } else {
                    this.acc = this.f$2.apply(this.acc);
                }
                return this.acc;
            }
            {
                this.f$2 = f$2;
                this.first = true;
                this.acc = start$2;
            }
        }.takeWhile((Function1<Phase, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToBoolean(Phase.$anonfun$iterator$2(x$2)));
    }

    public abstract String name();

    public String description() {
        return this.name();
    }

    public boolean checkable() {
        return true;
    }

    private boolean _erasedTypes() {
        return this._erasedTypes;
    }

    private void _erasedTypes_$eq(boolean x$1) {
        this._erasedTypes = x$1;
    }

    public void erasedTypes_$eq(boolean value) {
        this._erasedTypes_$eq(value);
    }

    public final boolean erasedTypes() {
        return this._erasedTypes();
    }

    public final boolean flatClasses() {
        return this.flatClasses;
    }

    public final boolean specialized() {
        return this.specialized;
    }

    public final boolean refChecked() {
        return this.refChecked;
    }

    public final boolean assignsFields() {
        return this.assignsFields;
    }

    public boolean keepsTypeParams() {
        return true;
    }

    public abstract void run();

    public String toString() {
        return this.name();
    }

    public int hashCode() {
        return this.id() + Statics.anyHash(this.name());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object other) {
        if (!(other instanceof Phase)) return false;
        Phase phase = (Phase)other;
        if (this.id() != phase.id()) return false;
        String string = this.name();
        String string2 = phase.name();
        if (string != null) {
            if (!string.equals(string2)) return false;
            return true;
        }
        if (string2 == null) return true;
        return false;
    }

    @Override
    public int compare(Phase that) {
        int n = this.id();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new RichInt(n).compare(BoxesRunTime.boxToInteger(that.id()));
    }

    public static final /* synthetic */ boolean $anonfun$iterator$2(Phase x$2) {
        return x$2 != NoPhase$.MODULE$;
    }

    /*
     * Unable to fully structure code
     */
    public Phase(Phase prev) {
        this.prev = prev;
        super();
        Ordered.$init$(this);
        if (prev != null && prev != NoPhase$.MODULE$) {
            prev.nx_$eq(this);
        }
        this.id = prev == null ? 0 : prev.id() + 1;
        this.fmask = prev == null ? 0x7FFFFFFFFFFFFL : prev.flagMask() | prev.nextFlags() | this.newFlags();
        this.nx = NoPhase$.MODULE$;
        if (prev == null || prev == NoPhase$.MODULE$) ** GOTO lbl-1000
        v0 = prev.name();
        var2_2 = "erasure";
        if (v0 != null && v0.equals(var2_2) || prev.erasedTypes()) {
            v1 = true;
        } else lbl-1000:
        // 2 sources

        {
            v1 = this._erasedTypes = false;
        }
        if (prev == null || prev == NoPhase$.MODULE$) ** GOTO lbl-1000
        v2 = prev.name();
        var3_3 = "flatten";
        if (v2 != null && v2.equals(var3_3) || prev.flatClasses()) {
            v3 = true;
        } else lbl-1000:
        // 2 sources

        {
            v3 = this.flatClasses = false;
        }
        if (prev == null || prev == NoPhase$.MODULE$) ** GOTO lbl-1000
        v4 = prev.name();
        var4_4 = "specialize";
        if (v4 != null && v4.equals(var4_4) || prev.specialized()) {
            v5 = true;
        } else lbl-1000:
        // 2 sources

        {
            v5 = this.specialized = false;
        }
        if (prev == null || prev == NoPhase$.MODULE$) ** GOTO lbl-1000
        v6 = prev.name();
        var5_5 = "refchecks";
        if (v6 != null && v6.equals(var5_5) || prev.refChecked()) {
            v7 = true;
        } else lbl-1000:
        // 2 sources

        {
            v7 = this.refChecked = false;
        }
        if (prev == null || prev == NoPhase$.MODULE$) ** GOTO lbl-1000
        v8 = prev.name();
        var6_6 = "fields";
        if (v8 != null && v8.equals(var6_6) || prev.assignsFields()) {
            v9 = true;
        } else lbl-1000:
        // 2 sources

        {
            v9 = false;
        }
        this.assignsFields = v9;
    }
}

