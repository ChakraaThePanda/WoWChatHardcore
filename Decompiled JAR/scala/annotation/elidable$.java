/*
 * Decompiled with CFR 0.152.
 */
package scala.annotation;

import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Tuple2;
import scala.collection.immutable.Map;
import scala.runtime.BoxesRunTime;

public final class elidable$ {
    public static elidable$ MODULE$;
    private final Map<String, Object> byName;

    static {
        new elidable$();
    }

    public final int ALL() {
        return Integer.MIN_VALUE;
    }

    public final int FINEST() {
        return 300;
    }

    public final int FINER() {
        return 400;
    }

    public final int FINE() {
        return 500;
    }

    public final int CONFIG() {
        return 700;
    }

    public final int INFO() {
        return 800;
    }

    public final int WARNING() {
        return 900;
    }

    public final int SEVERE() {
        return 1000;
    }

    public final int OFF() {
        return Integer.MAX_VALUE;
    }

    public final int MAXIMUM() {
        return Integer.MAX_VALUE;
    }

    public final int MINIMUM() {
        return Integer.MIN_VALUE;
    }

    public final int ASSERTION() {
        return 2000;
    }

    public Map<String, Object> byName() {
        return this.byName;
    }

    /*
     * WARNING - void declaration
     */
    private elidable$() {
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
        MODULE$ = this;
        Tuple2[] tuple2Array = new Tuple2[12];
        Integer n = BoxesRunTime.boxToInteger(300);
        String string = Predef$.MODULE$.ArrowAssoc("FINEST");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[0] = new Tuple2<void, void>($minus$greater$extension_$this12, $minus$greater$extension_y12);
        Integer n2 = BoxesRunTime.boxToInteger(400);
        String string2 = Predef$.MODULE$.ArrowAssoc("FINER");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[1] = new Tuple2<void, void>($minus$greater$extension_$this11, $minus$greater$extension_y11);
        Integer n3 = BoxesRunTime.boxToInteger(500);
        String string3 = Predef$.MODULE$.ArrowAssoc("FINE");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[2] = new Tuple2<void, void>($minus$greater$extension_$this10, $minus$greater$extension_y10);
        Integer n4 = BoxesRunTime.boxToInteger(700);
        String string4 = Predef$.MODULE$.ArrowAssoc("CONFIG");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[3] = new Tuple2<void, void>($minus$greater$extension_$this9, $minus$greater$extension_y9);
        Integer n5 = BoxesRunTime.boxToInteger(800);
        String string5 = Predef$.MODULE$.ArrowAssoc("INFO");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[4] = new Tuple2<void, void>($minus$greater$extension_$this8, $minus$greater$extension_y8);
        Integer n6 = BoxesRunTime.boxToInteger(900);
        String string6 = Predef$.MODULE$.ArrowAssoc("WARNING");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[5] = new Tuple2<void, void>($minus$greater$extension_$this7, $minus$greater$extension_y7);
        Integer n7 = BoxesRunTime.boxToInteger(1000);
        String string7 = Predef$.MODULE$.ArrowAssoc("SEVERE");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[6] = new Tuple2<void, void>($minus$greater$extension_$this6, $minus$greater$extension_y6);
        Integer n8 = BoxesRunTime.boxToInteger(2000);
        String string8 = Predef$.MODULE$.ArrowAssoc("ASSERTION");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[7] = new Tuple2<void, void>($minus$greater$extension_$this5, $minus$greater$extension_y5);
        Integer n9 = BoxesRunTime.boxToInteger(Integer.MIN_VALUE);
        String string9 = Predef$.MODULE$.ArrowAssoc("ALL");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[8] = new Tuple2<void, void>($minus$greater$extension_$this4, $minus$greater$extension_y4);
        Integer n10 = BoxesRunTime.boxToInteger(Integer.MAX_VALUE);
        String string10 = Predef$.MODULE$.ArrowAssoc("OFF");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[9] = new Tuple2<void, void>($minus$greater$extension_$this3, $minus$greater$extension_y3);
        Integer n11 = BoxesRunTime.boxToInteger(Integer.MAX_VALUE);
        String string11 = Predef$.MODULE$.ArrowAssoc("MAXIMUM");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[10] = new Tuple2<void, void>($minus$greater$extension_$this2, $minus$greater$extension_y2);
        Integer n12 = BoxesRunTime.boxToInteger(Integer.MIN_VALUE);
        String string12 = Predef$.MODULE$.ArrowAssoc("MINIMUM");
        if (Predef$ArrowAssoc$.MODULE$ == null) {
            throw null;
        }
        tuple2Array[11] = new Tuple2<void, void>($minus$greater$extension_$this, $minus$greater$extension_y);
        this.byName = (Map)Predef$.MODULE$.Map().apply(Predef$.MODULE$.wrapRefArray((Object[])tuple2Array));
    }
}

