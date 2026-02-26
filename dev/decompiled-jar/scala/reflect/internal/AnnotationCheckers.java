/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.Serializable;
import scala.collection.LinearSeqOptimized;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005%e!C\r\u001b!\u0003\r\t!IAB\u0011\u00151\u0003\u0001\"\u0001(\r\u001dY\u0003\u0001%A\u0002\u00021BQA\n\u0002\u0005\u0002\u001dBQ!\f\u0002\u0005\u00029BQA\r\u0002\u0007\u0002MBQA\u0010\u0002\u0005\u0002}BQa\u0013\u0002\u0005\u00021CQa\u0014\u0002\u0005\u0002ACQ!\u0019\u0002\u0005\u0002\tDQ\u0001\u001e\u0002\u0005\u0002UDq!!\u0002\u0003\t\u0003\t9\u0001C\u0004\u0002\u0016\t!\t!a\u0006\t\u0013\u00055\u0002\u00011A\u0005\n\u0005=\u0002\"CA\u001b\u0001\u0001\u0007I\u0011BA\u001c\u0011\u001d\ti\u0004\u0001C\u0001\u0003\u007fAa!!\u0012\u0001\t\u00039\u0003B\u0002\u001a\u0001\t\u0003\t9\u0005\u0003\u0004?\u0001\u0011\u0005\u0011\u0011\u000b\u0005\u0007\u0017\u0002!\t!a\u0016\t\r=\u0003A\u0011AA/\u0011\u0019\t\u0007\u0001\"\u0001\u0002f!1A\u000f\u0001C\u0001\u0003WBq!!\u0002\u0001\t\u0003\t\u0019\bC\u0004\u0002\u0016\u0001!\t!a\u001f\u0003%\u0005sgn\u001c;bi&|gn\u00115fG.,'o\u001d\u0006\u00037q\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u0003;y\tqA]3gY\u0016\u001cGOC\u0001 \u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001\u0001\u0012\u0011\u0005\r\"S\"\u0001\u0010\n\u0005\u0015r\"AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u0002QA\u00111%K\u0005\u0003Uy\u0011A!\u00168ji\n\t\u0012I\u001c8pi\u0006$\u0018n\u001c8DQ\u0016\u001c7.\u001a:\u0014\u0005\t\u0011\u0013\u0001C5t\u0003\u000e$\u0018N^3\u0015\u0003=\u0002\"a\t\u0019\n\u0005Er\"a\u0002\"p_2,\u0017M\\\u0001\u0013C:tw\u000e^1uS>t7oQ8oM>\u0014X\u000eF\u00020iqBQ!N\u0003A\u0002Y\nA\u0001\u001e9fcA\u0011q\u0007O\u0007\u0002\u0001%\u0011\u0011H\u000f\u0002\u0005)f\u0004X-\u0003\u0002<5\t)A+\u001f9fg\")Q(\u0002a\u0001m\u0005!A\u000f]33\u00039\tgN\\8uCRLwN\\:Mk\n$2A\u000e!C\u0011\u0015\te\u00011\u00017\u0003\t!\b\u000fC\u0003D\r\u0001\u0007A)\u0001\u0002ugB\u0019Q\t\u0013\u001c\u000f\u0005\r2\u0015BA$\u001f\u0003\u001d\u0001\u0018mY6bO\u0016L!!\u0013&\u0003\t1K7\u000f\u001e\u0006\u0003\u000fz\ta\"\u00198o_R\fG/[8og\u001ec'\rF\u00027\u001b:CQ!Q\u0004A\u0002YBQaQ\u0004A\u0002\u0011\u000b\u0001$\u00193baR\u0014u.\u001e8egR{\u0017I\u001c8pi\u0006$\u0018n\u001c8t)\u0011\tVkV0\u0011\u0007\u0015C%\u000b\u0005\u00028'&\u0011AK\u000f\u0002\u000b)f\u0004XMQ8v]\u0012\u001c\b\"\u0002,\t\u0001\u0004\t\u0016A\u00022pk:$7\u000fC\u0003Y\u0011\u0001\u0007\u0011,A\u0004ua\u0006\u0014\u0018-\\:\u0011\u0007\u0015C%\f\u0005\u000287&\u0011A,\u0018\u0002\u0007'fl'm\u001c7\n\u0005yS\"aB*z[\n|Gn\u001d\u0005\u0006A\"\u0001\r\u0001R\u0001\u0006i\u0006\u0014xm]\u0001\u000fC\u0012$\u0017I\u001c8pi\u0006$\u0018n\u001c8t)\r14M\u001b\u0005\u0006I&\u0001\r!Z\u0001\u0005iJ,W\r\u0005\u00028M&\u0011q\r\u001b\u0002\u0005)J,W-\u0003\u0002j5\t)AK]3fg\")1.\u0003a\u0001m\u0005\u0019A\u000f]3)\t%i\u0007O\u001d\t\u0003G9L!a\u001c\u0010\u0003)\u0011,\u0007O]3dCR,Gm\u0014<feJLG-\u001b8hC\u0005\t\u0018!L2sK\u0006$X\rI1oA\u0005s\u0017\r\\={KJ\u0004F.^4j]\u0002\ng\u000e\u001a\u0011vg\u0016\u0004\u0003\u000f\\;hS:\u001cH+\u001f9fI\u0006\n1/\u0001\u00043]E\u0002d&M\u0001\u0014G\u0006t\u0017\tZ1qi\u0006sgn\u001c;bi&|gn\u001d\u000b\u0005_Y<X\u0010C\u0003e\u0015\u0001\u0007Q\rC\u0003y\u0015\u0001\u0007\u00110\u0001\u0003n_\u0012,\u0007C\u0001>|\u001b\u0005Q\u0012B\u0001?\u001b\u0005\u0011iu\u000eZ3\t\u000byT\u0001\u0019\u0001\u001c\u0002\u0005A$\b&\u0002\u0006n\u0003\u0003\u0011\u0018EAA\u0002\u0003Q\u001a'/Z1uK\u0002\ng\u000eI!oC2L(0\u001a:QYV<\u0017N\u001c\u0011b]\u0012\u0004So]3!G\u0006t\u0017\tZ1qi\u0006sgn\u001c;bi&|gn]\u0001\u0011C\u0012\f\u0007\u000f^!o]>$\u0018\r^5p]N$r!ZA\u0005\u0003\u0017\ti\u0001C\u0003e\u0017\u0001\u0007Q\rC\u0003y\u0017\u0001\u0007\u0011\u0010C\u0003\u007f\u0017\u0001\u0007a\u0007K\u0003\f[\u0006E!/\t\u0002\u0002\u0014\u0005\t4M]3bi\u0016\u0004\u0013M\u001c\u0011B]\u0006d\u0017P_3s!2,x-\u001b8!C:$\u0007%^:fA\u0005$\u0017\r\u001d;B]:|G/\u0019;j_:\u001c\u0018!E1eCB$H+\u001f9f\u001f\u001a\u0014V\r^;s]R9a'!\u0007\u0002\u001c\u0005u\u0001\"\u00023\r\u0001\u0004)\u0007\"\u0002@\r\u0001\u00041\u0004\u0002CA\u0010\u0019\u0011\u0005\r!!\t\u0002\u000f\u0011,g-Y;miB!1%a\t7\u0013\r\t)C\b\u0002\ty\tLh.Y7f}!*A\"\\A\u0015e\u0006\u0012\u00111F\u0001\u0002d\r\u0013X-\u0019;fA\u0005t\u0007%\u00118bYfTXM\u001d)mk\u001eLg\u000eI1oI\u0002*8/\u001a\u0011qYV<\u0017N\\:UsB,GMU3ukJtg\u0006\t(pi\u0016T\u0004\u0005\u001e5fA\u001d\"(/Z3(A\u0005\u0014x-^7f]R\u0004\u0003.\u001a:fA%\u001c(\u0002\u001e5fA\u001d*\u0007\u0010\u001d:(A=4\u0007%\u0019\u0011SKR,(O\u001c\u0011ue\u0016,7\bI\u0014qYV<\u0017N\\:UsB,GMU3ukJtw\u0005\t;bW\u0016\u001c\b\u0005\u001e5fAI+G/\u001e:oAQ\u0014X-\u001a\u0011jiN,GN\u001a\u0011bg\u0002\n'oZ;nK:$\u0018AE1o]>$\u0018\r^5p]\u000eCWmY6feN,\"!!\r\u0011\t\u0015C\u00151\u0007\t\u0003o\t\ta#\u00198o_R\fG/[8o\u0007\",7m[3sg~#S-\u001d\u000b\u0004Q\u0005e\u0002\"CA\u001e\u001d\u0005\u0005\t\u0019AA\u0019\u0003\rAH%M\u0001\u0015C\u0012$\u0017I\u001c8pi\u0006$\u0018n\u001c8DQ\u0016\u001c7.\u001a:\u0015\u0007!\n\t\u0005C\u0004\u0002D=\u0001\r!a\r\u0002\u000f\rDWmY6fe\u0006Y\"/Z7pm\u0016\fE\u000e\\!o]>$\u0018\r^5p]\u000eCWmY6feN$RaLA%\u0003\u001bBa!a\u0013\u0012\u0001\u00041\u0014a\u0001;qc!1\u0011qJ\tA\u0002Y\n1\u0001\u001e93)\u00151\u00141KA+\u0011\u0015Y'\u00031\u00017\u0011\u0015\u0019%\u00031\u0001E)\u00151\u0014\u0011LA.\u0011\u0015Y7\u00031\u00017\u0011\u0015\u00195\u00031\u0001E)\u001d\t\u0016qLA1\u0003GBQA\u0016\u000bA\u0002ECQ\u0001\u0017\u000bA\u0002eCQ\u0001\u0019\u000bA\u0002\u0011#RANA4\u0003SBQ\u0001Z\u000bA\u0002\u0015DQa[\u000bA\u0002Y\"raLA7\u0003_\n\t\bC\u0003e-\u0001\u0007Q\rC\u0003y-\u0001\u0007\u0011\u0010C\u0003\u007f-\u0001\u0007a\u0007F\u0004f\u0003k\n9(!\u001f\t\u000b\u0011<\u0002\u0019A3\t\u000ba<\u0002\u0019A=\t\u000by<\u0002\u0019\u0001\u001c\u0015\u000fY\ni(a \u0002\u0002\")A\r\u0007a\u0001K\")a\u0010\u0007a\u0001m!A\u0011q\u0004\r\u0005\u0002\u0004\t\t\u0003E\u0002{\u0003\u000bK1!a\"\u001b\u0005-\u0019\u00160\u001c2pYR\u000b'\r\\3")
public interface AnnotationCheckers {
    public List<AnnotationChecker> scala$reflect$internal$AnnotationCheckers$$annotationCheckers();

    public void scala$reflect$internal$AnnotationCheckers$$annotationCheckers_$eq(List<AnnotationChecker> var1);

    public static /* synthetic */ void addAnnotationChecker$(AnnotationCheckers $this, AnnotationChecker checker) {
        $this.addAnnotationChecker(checker);
    }

    default public void addAnnotationChecker(AnnotationChecker checker) {
        if (!this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().contains(checker)) {
            this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers_$eq(this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().$colon$colon(checker));
        }
    }

    public static /* synthetic */ void removeAllAnnotationCheckers$(AnnotationCheckers $this) {
        $this.removeAllAnnotationCheckers();
    }

    default public void removeAllAnnotationCheckers() {
        this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers_$eq(Nil$.MODULE$);
    }

    public static /* synthetic */ boolean annotationsConform$(AnnotationCheckers $this, Types.Type tp1, Types.Type tp2) {
        return $this.annotationsConform(tp1, tp2);
    }

    default public boolean annotationsConform(Types.Type tp1, Types.Type tp2) {
        boolean bl;
        block4: {
            if (this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().isEmpty() || tp1.annotations().isEmpty() && tp2.annotations().isEmpty()) {
                return true;
            }
            List<AnnotationChecker> list = this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers();
            if (list == null) {
                throw null;
            }
            LinearSeqOptimized forall_these = list;
            while (!forall_these.isEmpty()) {
                AnnotationChecker annotationChecker = (AnnotationChecker)forall_these.head();
                if (!AnnotationCheckers.$anonfun$annotationsConform$1(tp1, tp2, annotationChecker)) {
                    bl = false;
                    break block4;
                }
                forall_these = (LinearSeqOptimized)forall_these.tail();
            }
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ Types.Type annotationsLub$(AnnotationCheckers $this, Types.Type tpe, List ts) {
        return $this.annotationsLub(tpe, ts);
    }

    /*
     * WARNING - void declaration
     */
    default public Types.Type annotationsLub(Types.Type tpe, List<Types.Type> ts) {
        void var4_4;
        if (this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().isEmpty()) {
            return tpe;
        }
        List<AnnotationChecker> list = this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers();
        if (list == null) {
            throw null;
        }
        List<AnnotationChecker> foldLeft_this = list;
        Types.Type foldLeft_acc = tpe;
        LinearSeqOptimized foldLeft_these = foldLeft_this;
        while (!foldLeft_these.isEmpty()) {
            AnnotationChecker annotationChecker = (AnnotationChecker)foldLeft_these.head();
            Types.Type type = foldLeft_acc;
            foldLeft_acc = AnnotationCheckers.$anonfun$annotationsLub$1(ts, type, annotationChecker);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return var4_4;
    }

    public static /* synthetic */ Types.Type annotationsGlb$(AnnotationCheckers $this, Types.Type tpe, List ts) {
        return $this.annotationsGlb(tpe, ts);
    }

    /*
     * WARNING - void declaration
     */
    default public Types.Type annotationsGlb(Types.Type tpe, List<Types.Type> ts) {
        void var4_4;
        if (this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().isEmpty()) {
            return tpe;
        }
        List<AnnotationChecker> list = this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers();
        if (list == null) {
            throw null;
        }
        List<AnnotationChecker> foldLeft_this = list;
        Types.Type foldLeft_acc = tpe;
        LinearSeqOptimized foldLeft_these = foldLeft_this;
        while (!foldLeft_these.isEmpty()) {
            AnnotationChecker annotationChecker = (AnnotationChecker)foldLeft_these.head();
            Types.Type type = foldLeft_acc;
            foldLeft_acc = AnnotationCheckers.$anonfun$annotationsGlb$1(ts, type, annotationChecker);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return var4_4;
    }

    public static /* synthetic */ List adaptBoundsToAnnotations$(AnnotationCheckers $this, List bounds, List tparams, List targs) {
        return $this.adaptBoundsToAnnotations(bounds, tparams, targs);
    }

    /*
     * WARNING - void declaration
     */
    default public List<Types.TypeBounds> adaptBoundsToAnnotations(List<Types.TypeBounds> bounds, List<Symbols.Symbol> tparams, List<Types.Type> targs) {
        void var5_5;
        if (this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().isEmpty()) {
            return bounds;
        }
        List<AnnotationChecker> list = this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers();
        if (list == null) {
            throw null;
        }
        List<AnnotationChecker> foldLeft_this = list;
        List foldLeft_acc = bounds;
        LinearSeqOptimized foldLeft_these = foldLeft_this;
        while (!foldLeft_these.isEmpty()) {
            AnnotationChecker annotationChecker = (AnnotationChecker)foldLeft_these.head();
            List list2 = foldLeft_acc;
            foldLeft_acc = AnnotationCheckers.$anonfun$adaptBoundsToAnnotations$1(tparams, targs, list2, annotationChecker);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return var5_5;
    }

    public static /* synthetic */ Types.Type addAnnotations$(AnnotationCheckers $this, Trees.Tree tree, Types.Type tpe) {
        return $this.addAnnotations(tree, tpe);
    }

    /*
     * WARNING - void declaration
     */
    default public Types.Type addAnnotations(Trees.Tree tree, Types.Type tpe) {
        void var4_4;
        if (this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().isEmpty()) {
            return tpe;
        }
        List<AnnotationChecker> list = this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers();
        if (list == null) {
            throw null;
        }
        List<AnnotationChecker> foldLeft_this = list;
        Types.Type foldLeft_acc = tpe;
        LinearSeqOptimized foldLeft_these = foldLeft_this;
        while (!foldLeft_these.isEmpty()) {
            AnnotationChecker annotationChecker = (AnnotationChecker)foldLeft_these.head();
            Types.Type type = foldLeft_acc;
            foldLeft_acc = AnnotationCheckers.$anonfun$addAnnotations$1(tree, type, annotationChecker);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return var4_4;
    }

    public static /* synthetic */ boolean canAdaptAnnotations$(AnnotationCheckers $this, Trees.Tree tree, int mode, Types.Type pt) {
        return $this.canAdaptAnnotations(tree, mode, pt);
    }

    default public boolean canAdaptAnnotations(Trees.Tree tree, int mode, Types.Type pt) {
        boolean bl;
        block4: {
            if (this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().isEmpty()) {
                return false;
            }
            List<AnnotationChecker> list = this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers();
            if (list == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = list;
            while (!exists_these.isEmpty()) {
                AnnotationChecker annotationChecker = (AnnotationChecker)exists_these.head();
                if (AnnotationCheckers.$anonfun$canAdaptAnnotations$1(tree, mode, pt, annotationChecker)) {
                    bl = true;
                    break block4;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return bl;
    }

    public static /* synthetic */ Trees.Tree adaptAnnotations$(AnnotationCheckers $this, Trees.Tree tree, int mode, Types.Type pt) {
        return $this.adaptAnnotations(tree, mode, pt);
    }

    /*
     * WARNING - void declaration
     */
    default public Trees.Tree adaptAnnotations(Trees.Tree tree, int mode, Types.Type pt) {
        void var5_5;
        if (this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().isEmpty()) {
            return tree;
        }
        List<AnnotationChecker> list = this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers();
        if (list == null) {
            throw null;
        }
        List<AnnotationChecker> foldLeft_this = list;
        Trees.Tree foldLeft_acc = tree;
        LinearSeqOptimized foldLeft_these = foldLeft_this;
        while (!foldLeft_these.isEmpty()) {
            AnnotationChecker annotationChecker = (AnnotationChecker)foldLeft_these.head();
            Trees.Tree tree2 = foldLeft_acc;
            foldLeft_acc = AnnotationCheckers.$anonfun$adaptAnnotations$1(mode, pt, tree2, annotationChecker);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return var5_5;
    }

    public static /* synthetic */ Types.Type adaptTypeOfReturn$(AnnotationCheckers $this, Trees.Tree tree, Types.Type pt, Function0 function0) {
        return $this.adaptTypeOfReturn(tree, pt, function0);
    }

    /*
     * WARNING - void declaration
     */
    default public Types.Type adaptTypeOfReturn(Trees.Tree tree, Types.Type pt, Function0<Types.Type> function0) {
        void var6_6;
        void foldLeft_z;
        if (this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers().isEmpty()) {
            return function0.apply();
        }
        List<AnnotationChecker> list = this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers();
        Types.Type type = function0.apply();
        if (list == null) {
            throw null;
        }
        List<AnnotationChecker> foldLeft_this = list;
        Types.Type foldLeft_acc = foldLeft_z;
        LinearSeqOptimized foldLeft_these = foldLeft_this;
        while (!foldLeft_these.isEmpty()) {
            AnnotationChecker annotationChecker = (AnnotationChecker)foldLeft_these.head();
            Types.Type type2 = foldLeft_acc;
            foldLeft_acc = AnnotationCheckers.$anonfun$adaptTypeOfReturn$1(tree, pt, type2, annotationChecker);
            foldLeft_these = (LinearSeqOptimized)foldLeft_these.tail();
        }
        return (Types.Type)var6_6;
    }

    public static /* synthetic */ boolean $anonfun$annotationsConform$1(Types.Type tp1$1, Types.Type tp2$1, AnnotationChecker checker) {
        return !checker.isActive() || checker.annotationsConform(tp1$1, tp2$1);
    }

    public static /* synthetic */ Types.Type $anonfun$annotationsLub$1(List ts$1, Types.Type tpe, AnnotationChecker checker) {
        if (!checker.isActive()) {
            return tpe;
        }
        return checker.annotationsLub(tpe, ts$1);
    }

    public static /* synthetic */ Types.Type $anonfun$annotationsGlb$1(List ts$2, Types.Type tpe, AnnotationChecker checker) {
        if (!checker.isActive()) {
            return tpe;
        }
        return checker.annotationsGlb(tpe, ts$2);
    }

    public static /* synthetic */ List $anonfun$adaptBoundsToAnnotations$1(List tparams$1, List targs$1, List bounds, AnnotationChecker checker) {
        if (!checker.isActive()) {
            return bounds;
        }
        return checker.adaptBoundsToAnnotations(bounds, tparams$1, targs$1);
    }

    public static /* synthetic */ Types.Type $anonfun$addAnnotations$1(Trees.Tree tree$1, Types.Type tpe, AnnotationChecker checker) {
        if (!checker.isActive()) {
            return tpe;
        }
        return checker.addAnnotations(tree$1, tpe);
    }

    public static /* synthetic */ boolean $anonfun$canAdaptAnnotations$1(Trees.Tree tree$2, int mode$1, Types.Type pt$1, AnnotationChecker checker) {
        return checker.isActive() && checker.canAdaptAnnotations(tree$2, mode$1, pt$1);
    }

    public static /* synthetic */ Trees.Tree $anonfun$adaptAnnotations$1(int mode$2, Types.Type pt$2, Trees.Tree tree, AnnotationChecker checker) {
        if (!checker.isActive()) {
            return tree;
        }
        return checker.adaptAnnotations(tree, mode$2, pt$2);
    }

    public static /* synthetic */ Types.Type $anonfun$adaptTypeOfReturn$1(Trees.Tree tree$3, Types.Type pt$3, Types.Type tpe, AnnotationChecker checker) {
        if (!checker.isActive()) {
            return tpe;
        }
        return checker.adaptTypeOfReturn(tree$3, pt$3, (Function0<Types.Type> & java.io.Serializable & Serializable)() -> tpe);
    }

    public static void $init$(AnnotationCheckers $this) {
        $this.scala$reflect$internal$AnnotationCheckers$$annotationCheckers_$eq(Nil$.MODULE$);
    }

    public static /* synthetic */ Object $anonfun$annotationsConform$1$adapted(Types.Type tp1$1, Types.Type tp2$1, AnnotationChecker checker) {
        return BoxesRunTime.boxToBoolean(AnnotationCheckers.$anonfun$annotationsConform$1(tp1$1, tp2$1, checker));
    }

    public static /* synthetic */ Object $anonfun$canAdaptAnnotations$1$adapted(Trees.Tree tree$2, int mode$1, Types.Type pt$1, AnnotationChecker checker) {
        return BoxesRunTime.boxToBoolean(AnnotationCheckers.$anonfun$canAdaptAnnotations$1(tree$2, mode$1, pt$1, checker));
    }

    public interface AnnotationChecker {
        public static /* synthetic */ boolean isActive$(AnnotationChecker $this) {
            return $this.isActive();
        }

        default public boolean isActive() {
            return true;
        }

        public boolean annotationsConform(Types.Type var1, Types.Type var2);

        public static /* synthetic */ Types.Type annotationsLub$(AnnotationChecker $this, Types.Type tp, List ts) {
            return $this.annotationsLub(tp, ts);
        }

        default public Types.Type annotationsLub(Types.Type tp, List<Types.Type> ts) {
            return tp;
        }

        public static /* synthetic */ Types.Type annotationsGlb$(AnnotationChecker $this, Types.Type tp, List ts) {
            return $this.annotationsGlb(tp, ts);
        }

        default public Types.Type annotationsGlb(Types.Type tp, List<Types.Type> ts) {
            return tp;
        }

        public static /* synthetic */ List adaptBoundsToAnnotations$(AnnotationChecker $this, List bounds, List tparams, List targs) {
            return $this.adaptBoundsToAnnotations(bounds, tparams, targs);
        }

        default public List<Types.TypeBounds> adaptBoundsToAnnotations(List<Types.TypeBounds> bounds, List<Symbols.Symbol> tparams, List<Types.Type> targs) {
            return bounds;
        }

        public static /* synthetic */ Types.Type addAnnotations$(AnnotationChecker $this, Trees.Tree tree, Types.Type tpe) {
            return $this.addAnnotations(tree, tpe);
        }

        default public Types.Type addAnnotations(Trees.Tree tree, Types.Type tpe) {
            return tpe;
        }

        public static /* synthetic */ boolean canAdaptAnnotations$(AnnotationChecker $this, Trees.Tree tree, int mode, Types.Type pt) {
            return $this.canAdaptAnnotations(tree, mode, pt);
        }

        default public boolean canAdaptAnnotations(Trees.Tree tree, int mode, Types.Type pt) {
            return false;
        }

        public static /* synthetic */ Trees.Tree adaptAnnotations$(AnnotationChecker $this, Trees.Tree tree, int mode, Types.Type pt) {
            return $this.adaptAnnotations(tree, mode, pt);
        }

        default public Trees.Tree adaptAnnotations(Trees.Tree tree, int mode, Types.Type pt) {
            return tree;
        }

        public static /* synthetic */ Types.Type adaptTypeOfReturn$(AnnotationChecker $this, Trees.Tree tree, Types.Type pt, Function0 function0) {
            return $this.adaptTypeOfReturn(tree, pt, function0);
        }

        default public Types.Type adaptTypeOfReturn(Trees.Tree tree, Types.Type pt, Function0<Types.Type> function0) {
            return function0.apply();
        }

        public /* synthetic */ AnnotationCheckers scala$reflect$internal$AnnotationCheckers$AnnotationChecker$$$outer();

        public static void $init$(AnnotationChecker $this) {
        }
    }
}

