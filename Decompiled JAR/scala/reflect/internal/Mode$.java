/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function1;
import scala.MatchError;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.math.Ordering;
import scala.math.Ordering$String$;
import scala.reflect.internal.Mode;
import scala.runtime.BoxesRunTime;

public final class Mode$ {
    public static Mode$ MODULE$;
    private final int NOmode;
    private final int EXPRmode;
    private final int PATTERNmode;
    private final int TYPEmode;
    private final int SCCmode;
    private final int FUNmode;
    private final int POLYmode;
    private final int QUALmode;
    private final int TAPPmode;
    private final int LHSmode;
    private final int BYVALmode;
    private final int TYPEPATmode;
    private final int StickyModes;
    private final int StickyModesForFun;
    private final int MonoQualifierModes;
    private final int PolyQualifierModes;
    private final int OperatorModes;
    private final Map<Mode, String> modeNameMap;

    static {
        new Mode$();
    }

    private int liftIntBitsToMode(int bits) {
        return this.apply(bits);
    }

    public int apply(int bits) {
        return bits;
    }

    public final int NOmode() {
        return this.NOmode;
    }

    public final int EXPRmode() {
        return this.EXPRmode;
    }

    public final int PATTERNmode() {
        return this.PATTERNmode;
    }

    public final int TYPEmode() {
        return this.TYPEmode;
    }

    public final int SCCmode() {
        return this.SCCmode;
    }

    public final int FUNmode() {
        return this.FUNmode;
    }

    public final int POLYmode() {
        return this.POLYmode;
    }

    public final int QUALmode() {
        return this.QUALmode;
    }

    public final int TAPPmode() {
        return this.TAPPmode;
    }

    public final int LHSmode() {
        return this.LHSmode;
    }

    public final int BYVALmode() {
        return this.BYVALmode;
    }

    public final int TYPEPATmode() {
        return this.TYPEPATmode;
    }

    private int StickyModes() {
        return this.StickyModes;
    }

    private int StickyModesForFun() {
        return this.StickyModesForFun;
    }

    public final int MonoQualifierModes() {
        return this.MonoQualifierModes;
    }

    public final int PolyQualifierModes() {
        return this.PolyQualifierModes;
    }

    public final int OperatorModes() {
        return this.OperatorModes;
    }

    private Map<Mode, String> modeNameMap() {
        return this.modeNameMap;
    }

    public final int $amp$extension(int $this, int other) {
        return $this & other;
    }

    public final int $bar$extension(int $this, int other) {
        return $this | other;
    }

    public final int $amp$tilde$extension(int $this, int other) {
        return $this & ~other;
    }

    public final int onlyTypePat$extension(int $this) {
        return this.$amp$extension($this, this.TYPEPATmode());
    }

    public final int onlySticky$extension(int $this) {
        return this.$amp$extension($this, this.StickyModes());
    }

    public final int forFunMode$extension(int $this) {
        return this.$bar$extension(this.$bar$extension(this.$bar$extension(this.$amp$extension($this, this.StickyModesForFun()), this.FUNmode()), this.POLYmode()), this.BYVALmode());
    }

    public final int forTypeMode$extension(int $this) {
        if (this.typingPatternOrTypePat$extension($this)) {
            return this.$bar$extension(this.TYPEmode(), this.TYPEPATmode());
        }
        return this.TYPEmode();
    }

    public final boolean inAll$extension(int $this, int required) {
        return this.$amp$extension($this, required) == required;
    }

    public final boolean inAny$extension(int $this, int required) {
        return this.$amp$extension($this, required) != this.NOmode();
    }

    public final boolean inNone$extension(int $this, int prohibited) {
        return this.$amp$extension($this, prohibited) == this.NOmode();
    }

    public final boolean in$extension(int $this, int all, int none) {
        return this.inAll$extension($this, all) && this.inNone$extension($this, none);
    }

    public final int in$default$1$extension(int $this) {
        return this.NOmode();
    }

    public final int in$default$2$extension(int $this) {
        return this.NOmode();
    }

    public final boolean inByValMode$extension(int $this) {
        return this.inAll$extension($this, this.BYVALmode());
    }

    public final boolean inExprMode$extension(int $this) {
        return this.inAll$extension($this, this.EXPRmode());
    }

    public final boolean inFunMode$extension(int $this) {
        return this.inAll$extension($this, this.FUNmode());
    }

    public final boolean inPatternMode$extension(int $this) {
        return this.inAll$extension($this, this.PATTERNmode());
    }

    public final boolean inPolyMode$extension(int $this) {
        return this.inAll$extension($this, this.POLYmode());
    }

    public final boolean inQualMode$extension(int $this) {
        return this.inAll$extension($this, this.QUALmode());
    }

    public final boolean inSccMode$extension(int $this) {
        return this.inAll$extension($this, this.SCCmode());
    }

    public final boolean inTappMode$extension(int $this) {
        return this.inAll$extension($this, this.TAPPmode());
    }

    public final boolean inTypeMode$extension(int $this) {
        return this.inAll$extension($this, this.TYPEmode());
    }

    public final boolean typingExprByValue$extension(int $this) {
        return this.inAll$extension($this, this.$bar$extension(this.EXPRmode(), this.BYVALmode()));
    }

    public final boolean typingExprFun$extension(int $this) {
        return this.inAll$extension($this, this.$bar$extension(this.EXPRmode(), this.FUNmode()));
    }

    public final boolean typingExprNotFun$extension(int $this) {
        return this.in$extension($this, this.EXPRmode(), this.FUNmode());
    }

    public final boolean typingExprNotFunNotLhs$extension(int $this) {
        return this.in$extension($this, this.EXPRmode(), this.$bar$extension(this.FUNmode(), this.LHSmode()));
    }

    public final boolean typingExprNotLhs$extension(int $this) {
        return this.in$extension($this, this.EXPRmode(), this.LHSmode());
    }

    public final boolean typingExprNotValue$extension(int $this) {
        return this.in$extension($this, this.EXPRmode(), this.BYVALmode());
    }

    public final boolean typingMonoExprByValue$extension(int $this) {
        return this.in$extension($this, this.$bar$extension(this.EXPRmode(), this.BYVALmode()), this.POLYmode());
    }

    public final boolean typingConstructorPattern$extension(int $this) {
        return this.inAll$extension($this, this.$bar$extension(this.PATTERNmode(), this.FUNmode()));
    }

    public final boolean typingPatternNotConstructor$extension(int $this) {
        return this.in$extension($this, this.PATTERNmode(), this.FUNmode());
    }

    public final boolean typingPatternOrTypePat$extension(int $this) {
        return this.inAny$extension($this, this.$bar$extension(this.PATTERNmode(), this.TYPEPATmode()));
    }

    public final String toString$extension(int $this) {
        if ($this == this.NOmode()) {
            return "NOmode";
        }
        return ((TraversableOnce)this.modeNameMap().filterKeys((Function1<Object, Object> & java.io.Serializable & Serializable)required -> BoxesRunTime.boxToBoolean(Mode$.MODULE$.inAll$extension($this, ((Mode)required).bits()))).values().toList().sorted((Ordering)Ordering$String$.MODULE$)).mkString("-");
    }

    public final int hashCode$extension(int $this) {
        return Integer.hashCode($this);
    }

    public final boolean equals$extension(int $this, Object x$1) {
        int n;
        boolean bl = x$1 instanceof Mode;
        return bl && $this == (n = ((Mode)x$1).bits());
    }

    /*
     * WARNING - void declaration
     */
    private Mode$() {
        void $minus$greater$extension_y;
        void $minus$greater$extension_$this;
        void $minus$greater$extension_y2;
        void $minus$greater$extension_$this2;
        void $minus$greater$extension_y3;
        void $minus$greater$extension_$this3;
        void $minus$greater$extension_y4;
        void $minus$greater$extension_$this4;
        void $minus$greater$extension_y5;
        void $minus$greater$extension_$this5;
        void $minus$greater$extension_y6;
        void $minus$greater$extension_$this6;
        void $minus$greater$extension_y7;
        void $minus$greater$extension_$this7;
        void $minus$greater$extension_y8;
        void $minus$greater$extension_$this8;
        void $minus$greater$extension_y9;
        void $minus$greater$extension_$this9;
        void $minus$greater$extension_y10;
        void $minus$greater$extension_$this10;
        void $minus$greater$extension_y11;
        void $minus$greater$extension_$this11;
        void $minus$greater$extension_y12;
        void $minus$greater$extension_$this12;
        void $minus$greater$extension_y13;
        void $minus$greater$extension_$this13;
        void $minus$greater$extension_y14;
        void $minus$greater$extension_$this14;
        void $minus$greater$extension_y15;
        void $minus$greater$extension_$this15;
        void $minus$greater$extension_y16;
        void $minus$greater$extension_$this16;
        void $minus$greater$extension_y17;
        void $minus$greater$extension_$this17;
        MODULE$ = this;
        this.NOmode = this.liftIntBitsToMode(0);
        this.EXPRmode = this.liftIntBitsToMode(1);
        this.PATTERNmode = this.liftIntBitsToMode(2);
        this.TYPEmode = this.liftIntBitsToMode(4);
        this.SCCmode = this.liftIntBitsToMode(8);
        this.FUNmode = this.liftIntBitsToMode(16);
        this.POLYmode = this.liftIntBitsToMode(32);
        this.QUALmode = this.liftIntBitsToMode(64);
        this.TAPPmode = this.liftIntBitsToMode(128);
        this.LHSmode = this.liftIntBitsToMode(1024);
        this.BYVALmode = this.liftIntBitsToMode(32768);
        this.TYPEPATmode = this.liftIntBitsToMode(65536);
        this.StickyModes = this.$bar$extension(this.$bar$extension(this.EXPRmode(), this.PATTERNmode()), this.TYPEmode());
        this.StickyModesForFun = this.$bar$extension(this.StickyModes(), this.SCCmode());
        this.MonoQualifierModes = this.$bar$extension(this.EXPRmode(), this.QUALmode());
        this.PolyQualifierModes = this.$bar$extension(this.$bar$extension(this.EXPRmode(), this.QUALmode()), this.POLYmode());
        this.OperatorModes = this.$bar$extension(this.$bar$extension(this.$bar$extension(this.EXPRmode(), this.POLYmode()), this.TAPPmode()), this.FUNmode());
        Tuple2[] tuple2Array = new Tuple2[17];
        String string = "EXPRmode";
        Integer n = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(1));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[0] = new Tuple2<void, void>($minus$greater$extension_$this17, $minus$greater$extension_y17);
        String string2 = "PATTERNmode";
        Integer n2 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(2));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[1] = new Tuple2<void, void>($minus$greater$extension_$this16, $minus$greater$extension_y16);
        String string3 = "TYPEmode";
        Integer n3 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(4));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[2] = new Tuple2<void, void>($minus$greater$extension_$this15, $minus$greater$extension_y15);
        String string4 = "SCCmode";
        Integer n4 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(8));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[3] = new Tuple2<void, void>($minus$greater$extension_$this14, $minus$greater$extension_y14);
        String string5 = "FUNmode";
        Integer n5 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(16));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[4] = new Tuple2<void, void>($minus$greater$extension_$this13, $minus$greater$extension_y13);
        String string6 = "POLYmode";
        Integer n6 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(32));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[5] = new Tuple2<void, void>($minus$greater$extension_$this12, $minus$greater$extension_y12);
        String string7 = "QUALmode";
        Integer n7 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(64));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[6] = new Tuple2<void, void>($minus$greater$extension_$this11, $minus$greater$extension_y11);
        String string8 = "TAPPmode";
        Integer n8 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(128));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[7] = new Tuple2<void, void>($minus$greater$extension_$this10, $minus$greater$extension_y10);
        String string9 = "<>";
        Integer n9 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(256));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[8] = new Tuple2<void, void>($minus$greater$extension_$this9, $minus$greater$extension_y9);
        String string10 = "<>";
        Integer n10 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(512));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[9] = new Tuple2<void, void>($minus$greater$extension_$this8, $minus$greater$extension_y8);
        String string11 = "LHSmode";
        Integer n11 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(1024));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[10] = new Tuple2<void, void>($minus$greater$extension_$this7, $minus$greater$extension_y7);
        String string12 = "<>";
        Integer n12 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(2048));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[11] = new Tuple2<void, void>($minus$greater$extension_$this6, $minus$greater$extension_y6);
        String string13 = "<>";
        Integer n13 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(4096));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[12] = new Tuple2<void, void>($minus$greater$extension_$this5, $minus$greater$extension_y5);
        String string14 = "<>";
        Integer n14 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(8192));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[13] = new Tuple2<void, void>($minus$greater$extension_$this4, $minus$greater$extension_y4);
        String string15 = "<>";
        Integer n15 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(16384));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[14] = new Tuple2<void, void>($minus$greater$extension_$this3, $minus$greater$extension_y3);
        String string16 = "BYVALmode";
        Integer n16 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(32768));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[15] = new Tuple2<void, void>($minus$greater$extension_$this2, $minus$greater$extension_y2);
        String string17 = "TYPEPATmode";
        Integer n17 = Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(65536));
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[16] = new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y);
        this.modeNameMap = ((TraversableLike)Predef$.MODULE$.Map().apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array))).map((Function1<Tuple2, Tuple2> & java.io.Serializable & Serializable)x0$1 -> {
            void $minus$greater$extension_$this;
            String v;
            if (x0$1 != null) {
                int k = x0$1._1$mcI$sp();
                v = (String)x0$1._2();
                Mode mode = Predef$.MODULE$.ArrowAssoc(new Mode(MODULE$.apply(k)));
                if (Predef$ArrowAssoc$.MODULE$ == null) {
                    throw null;
                }
            } else {
                throw new MatchError((Object)null);
            }
            Tuple2<void, String> tuple2 = new Tuple2<void, String>($minus$greater$extension_$this, v);
            return tuple2;
        }, Map$.MODULE$.canBuildFrom());
    }
}

