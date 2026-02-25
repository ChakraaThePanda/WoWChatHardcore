/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.Function1;
import scala.Serializable;
import scala.Some;
import scala.collection.LinearSeqOptimized;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.math.Ordering;
import scala.math.PartialOrdering;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Trees;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Positions$worker$1$;
import scala.reflect.internal.Reporting;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Trees;
import scala.reflect.internal.util.NoPosition$;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.Position$;
import scala.reflect.internal.util.ReusableInstance;
import scala.reflect.internal.util.SourceFile;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.LazyRef;

@ScalaSignature(bytes="\u0006\u0001\t5f!\u0003!B!\u0003\r\t\u0001\u0013BS\u0011\u0015\u0011\u0006\u0001\"\u0001T\u000b\u00119\u0006\u0001\u0001-\t\u000fu\u0003!\u0019!C\u0001=\"9A\u000e\u0001b\u0001\n\u0007i\u0007\"\u0002;\u0001\t\u0003)\b\"B=\u0001\t\u0003Q\bBB=\u0001\t\u0003\t9B\u0002\u0004\u0002\"\u00011\u00111\u0005\u0005\b\u0003WAA\u0011AA\u0017\u0011-\t\t\u0004\u0003a\u0001\u0002\u0003\u0006K!a\r\t\u0017\u0005e\u0002\u00021A\u0001B\u0003&\u00111\u0007\u0005\u0007\u0003wAA\u0011A*\t\u000f\u0005u\u0002\u0002\"\u0001\u0002@!9\u0011Q\t\u0005\u0005B\u0005\u001d\u0003BB=\u0001\t\u0003\ti\u0005C\u0004\u0002R\u0001!\t!a\u0015\t\u000f\u0005E\u0003\u0001\"\u0001\u0002^!9\u0011Q\r\u0001\u0005\u0002\u0005\u001ddaBA@\u0001\u0005\u0005\u0011\u0011\u0011\u0005\b\u0003W\u0019B\u0011AAF\u0011\u001d\tyi\u0005C!\u0003#Cq!!(\u0014\t\u0003\ny\nC\u0004\u0002$N1\t!!*\t\u000f\u0005\u00153\u0003\"\u0001\u0002,\"A\u0011q\u0016\u0001!\n\u0013\t\t\f\u0003\u0005\u0002J\u0002\u0001K\u0011BAf\u0011%\t\t\u000f\u0001b\u0001\n\u0013\t\u0019\u000fC\u0004\u0002l\u0002!\t!!<\t\u000f\u0005E\b\u0001\"\u0003\u0002t\"I\u0011Q \u0001C\u0002\u0013%\u0011q \u0004\u0007\u0005\u0013\u0001aAa\u0003\t\u000f\u0005-r\u0004\"\u0001\u0003\u000e!A!qB\u0010!\u0002\u0013\ty\u0003\u0003\u0006\u0002x~\u0001\r\u0011!Q!\nIDqA!\u0005 \t\u0003\u0011\u0019\u0002C\u0004\u0002F}!\tA!\u0007\u0007\r\tu\u0001\u0001\u0001B\u0010\u0011)\ty.\nB\u0001B\u0003%\u0011q\u0017\u0005\b\u0003W)C\u0011\u0001B\u0014\r\u0019\u0011i\u0003\u0001\u0001\u00030!I\u0011q\u001f\u0015\u0003\u0002\u0003\u0006IA\u001d\u0005\b\u0003WAC\u0011\u0001B\u0019\u0011-\u00119\u0004\u000ba\u0001\u0002\u0004%\tA!\u000f\t\u0017\tm\u0002\u00061AA\u0002\u0013\u0005!Q\b\u0005\f\u0005\u0007B\u0003\u0019!A!B\u0013\ti\u0001C\u0004\u0003F!\"\tAa\u0012\t\u000f\t5\u0003\u0006\"\u0005\u0003P!9\u0011Q\u0014\u0015\u0005B\tMcA\u0002B,\u0001\u0001\u0011I\u0006C\u0005\u0002xF\u0012\t\u0011)A\u0005e\"9\u00111F\u0019\u0005\u0002\tm\u0003b\u0002B'c\u0011E#\u0011\r\u0004\n\u0005K\u0002\u0001\u0013aI\u0001\u0005OB\u0011\"a>6\u0001\u00045\tA!\u001b\t\u0013\t-T\u00071A\u0007\u0002\t5\u0004B\u0003B9\u0001!\u0015\r\u0015\"\u0005\u0003t\u00191!q\u000f\u0001\t\u0005sBq!a\u000b:\t\u0003\u0011Y\bC\u0006\u0002xf\u0002\r\u00111A\u0005\u0002\t%\u0004b\u0003B6s\u0001\u0007\t\u0019!C\u0001\u0005\u007fB!Ba!:\u0001\u0004\u0005\t\u0015)\u0003s\u0011\u001d\ti*\u000fC!\u0005\u000bCqA!#\u0001\t\u0003\u0011YIA\u0005Q_NLG/[8og*\u0011!iQ\u0001\tS:$XM\u001d8bY*\u0011A)R\u0001\be\u00164G.Z2u\u0015\u00051\u0015!B:dC2\f7\u0001A\n\u0004\u0001%k\u0005C\u0001&L\u001b\u0005)\u0015B\u0001'F\u0005\u0019\te.\u001f*fMB\u0011a*U\u0007\u0002\u001f*\u0011\u0001kQ\u0001\u0004CBL\u0017B\u0001!P\u0003\u0019!\u0013N\\5uIQ\tA\u000b\u0005\u0002K+&\u0011a+\u0012\u0002\u0005+:LGO\u0001\u0005Q_NLG/[8o!\tIF,D\u0001[\u0015\tY\u0016)\u0001\u0003vi&d\u0017BA,[\u0003)qu\u000eU8tSRLwN\\\u000b\u0002?:\u0011\u0001m\u001b\b\u0003C*t!AY5\u000f\u0005\rDgB\u00013h\u001b\u0005)'B\u00014H\u0003\u0019a$o\\8u}%\ta)\u0003\u0002E\u000b&\u0011!iQ\u0005\u00037\u0006K!!\u0018.\u0002\u0017A{7/\u001b;j_:$\u0016mZ\u000b\u0002]B\u0019q\u000e\u001d:\u000e\u0003\rK!!]\"\u0003\u0011\rc\u0017m]:UC\u001e\u0004\"a\u001d\u0002\u000e\u0003\u0001\t!#^:f\u001f\u001a47/\u001a;Q_NLG/[8ogV\ta\u000f\u0005\u0002Ko&\u0011\u00010\u0012\u0002\b\u0005>|G.Z1o\u0003-9(/\u00199qS:<\u0007k\\:\u0015\u0007I\\X\u0010C\u0003}\r\u0001\u0007!/A\u0004eK\u001a\fW\u000f\u001c;\t\u000by4\u0001\u0019A@\u0002\u000bQ\u0014X-Z:\u0011\r\u0005\u0005\u0011qAA\u0007\u001d\rQ\u00151A\u0005\u0004\u0003\u000b)\u0015a\u00029bG.\fw-Z\u0005\u0005\u0003\u0013\tYA\u0001\u0003MSN$(bAA\u0003\u000bB\u00191/a\u0004\n\t\u0005E\u00111\u0003\u0002\u0005)J,W-C\u0002\u0002\u0016\u0005\u0013Q\u0001\u0016:fKN$rA]A\r\u00037\ti\u0002C\u0003}\u000f\u0001\u0007!\u000fC\u0003\u007f\u000f\u0001\u0007q\u0010\u0003\u0004\u0002 \u001d\u0001\rA^\u0001\u0006M>\u001cWo\u001d\u0002\u0017/J\f\u0007\u000f]5oOB{7/Q2dk6,H.\u0019;peN!\u0001\"SA\u0013!\u0019Q\u0015qEA\u0007m&\u0019\u0011\u0011F#\u0003\u0013\u0019+hn\u0019;j_:\f\u0014A\u0002\u001fj]&$h\b\u0006\u0002\u00020A\u00111\u000fC\u0001\u0004[&t\u0007c\u0001&\u00026%\u0019\u0011qG#\u0003\u0007%sG/A\u0002nCb\fQA]3tKR\faA]3tk2$H#\u0002:\u0002B\u0005\r\u0003\"\u0002?\u000e\u0001\u0004\u0011\bBBA\u0010\u001b\u0001\u0007a/A\u0003baBd\u0017\u0010F\u0002w\u0003\u0013Bq!a\u0013\u000f\u0001\u0004\ti!\u0001\u0002wcQ\u0019!/a\u0014\t\u000by|\u0001\u0019A@\u0002)\u0015t7/\u001e:f\u001d>twJ^3sY\u0006\u0004\b/\u001b8h)\u0015!\u0016QKA-\u0011\u001d\t9\u0006\u0005a\u0001\u0003\u001b\tA\u0001\u001e:fK\"1\u00111\f\tA\u0002}\faa\u001c;iKJ\u001cHc\u0002+\u0002`\u0005\u0005\u00141\r\u0005\b\u0003/\n\u0002\u0019AA\u0007\u0011\u0019\tY&\u0005a\u0001\u007f\"1\u0011qD\tA\u0002Y\f\u0001B]1oO\u0016\u0004vn\u001d\u000b\ne\u0006%\u00141OA<\u0003wBq!a\u001b\u0013\u0001\u0004\ti'\u0001\u0004t_V\u00148-\u001a\t\u00043\u0006=\u0014bAA95\nQ1k\\;sG\u00164\u0015\u000e\\3\t\u000f\u0005U$\u00031\u0001\u00024\u0005)1\u000f^1si\"9\u0011\u0011\u0010\nA\u0002\u0005M\u0012!\u00029pS:$\bbBA?%\u0001\u0007\u00111G\u0001\u0004K:$'AH\"iS2$7k\u001c7jI\u0012+7oY3oI\u0006tGo]\"pY2,7\r^8s'\r\u0019\u00121\u0011\t\u0004g\u0006\u0015\u0015\u0002BAD\u0003\u0013\u0013\u0011\u0002\u0016:bm\u0016\u00148/\u001a:\n\u0007\u0005Uq\n\u0006\u0002\u0002\u000eB\u00111oE\u0001\u0012iJ\fg/\u001a:tK6{G-\u001b4jKJ\u001cHc\u0001+\u0002\u0014\"9\u0011QS\u000bA\u0002\u0005]\u0015\u0001B7pIN\u00042a]AM\u0013\u0011\tY*a\u0005\u0003\u00135{G-\u001b4jKJ\u001c\u0018\u0001\u0003;sCZ,'o]3\u0015\u0007Q\u000b\t\u000bC\u0004\u0002XY\u0001\r!!\u0004\u0002%Q\u0014\u0018M^3sg\u0016\u001cv\u000e\\5e\u0007\"LG\u000e\u001a\u000b\u0004)\u0006\u001d\u0006bBAU/\u0001\u0007\u0011QB\u0001\u0002iR\u0019A+!,\t\u000f\u0005%\u0006\u00041\u0001\u0002\u000e\u0005Q!/\u001a9peR$&/Z3\u0015\u000bQ\u000b\u0019,a2\t\u000f\u0005U\u0016\u00041\u0001\u00028\u00061\u0001O]3gSb\u0004B!!/\u0002B:!\u00111XA_!\t!W)C\u0002\u0002@\u0016\u000ba\u0001\u0015:fI\u00164\u0017\u0002BAb\u0003\u000b\u0014aa\u0015;sS:<'bAA`\u000b\"9\u0011qK\rA\u0002\u00055\u0011!\u00049pg&$\u0018n\u001c8FeJ|'\u000f\u0006\u0004\u0002N\u0006e\u0017Q\u001c\u000b\u0004)\u0006=\u0007\u0002CAi5\u0011\u0005\r!a5\u0002\t\t|G-\u001f\t\u0005\u0015\u0006UG+C\u0002\u0002X\u0016\u0013\u0001\u0002\u00102z]\u0006lWM\u0010\u0005\b\u00037T\u0002\u0019AA\u0007\u0003\u001d!x\u000e\u001d+sK\u0016Dq!a8\u001b\u0001\u0004\t9,A\u0002ng\u001e\f\u0001\u0003]8t'R\f'\u000f^(sI\u0016\u0014\u0018N\\4\u0016\u0005\u0005\u0015\bCBA\u0001\u0003O\fi!\u0003\u0003\u0002j\u0006-!\u0001C(sI\u0016\u0014\u0018N\\4\u0002#Y\fG.\u001b3bi\u0016\u0004vn]5uS>t7\u000fF\u0002U\u0003_Dq!a\u0016\u001d\u0001\u0004\ti!\u0001\btKR\u001c\u0005.\u001b7ee\u0016t\u0007k\\:\u0015\u000bQ\u000b)0!?\t\r\u0005]X\u00041\u0001s\u0003\r\u0001xn\u001d\u0005\b\u0003wl\u0002\u0019AA\u0007\u0003\u0019\u0001\u0018M]3oi\u0006I2/\u001a;DQ&dGM]3o!>\u001c\u0018iY2v[Vd\u0017\r^8s+\t\u0011\t\u0001E\u0003Z\u0005\u0007\u00119!C\u0002\u0003\u0006i\u0013\u0001CU3vg\u0006\u0014G.Z%ogR\fgnY3\u0011\u0005M|\"!G*fi\u000eC\u0017\u000e\u001c3sK:\u0004vn]!dGVlW\u000f\\1u_J\u001cBaH%\u0002&Q\u0011!qA\u0001\u0017oJ\f\u0007\u000f]5oOB{7/Q2dk6,H.\u0019;pe\u0006\u00191/\u001a;\u0015\u000bQ\u0013)Ba\u0006\t\r\u0005]8\u00051\u0001s\u0011\u001d\tYp\ta\u0001\u0003\u001b!2A\u001eB\u000e\u0011\u001d\t9\u0006\na\u0001\u0003\u001b\u0011\u0011CV1mS\u0012\fG/Z#yG\u0016\u0004H/[8o'\r)#\u0011\u0005\t\u0005\u0003\u0003\u0011\u0019#\u0003\u0003\u0003&\u0005-!!C#yG\u0016\u0004H/[8o)\u0011\u0011ICa\u000b\u0011\u0005M,\u0003bBApO\u0001\u0007\u0011q\u0017\u0002\b\u0019>\u001c\u0017\r^8s'\rA\u00131\u0011\u000b\u0005\u0005g\u0011)\u0004\u0005\u0002tQ!1\u0011q\u001f\u0016A\u0002I\fA\u0001\\1tiV\u0011\u0011QB\u0001\tY\u0006\u001cHo\u0018\u0013fcR\u0019AKa\u0010\t\u0013\t\u0005C&!AA\u0002\u00055\u0011a\u0001=%c\u0005)A.Y:uA\u0005AAn\\2bi\u0016Le\u000e\u0006\u0003\u0002\u000e\t%\u0003b\u0002B&]\u0001\u0007\u0011QB\u0001\u0005e>|G/\u0001\u0006jg\u0016c\u0017nZ5cY\u0016$2A\u001eB)\u0011\u001d\tIk\fa\u0001\u0003\u001b!2\u0001\u0016B+\u0011\u001d\tI\u000b\ra\u0001\u0003\u001b\u0011A\u0002V=qK\u0012dunY1u_J\u001c2!\rB\u001a)\u0011\u0011iFa\u0018\u0011\u0005M\f\u0004BBA|g\u0001\u0007!\u000fF\u0002w\u0005GBq!!+5\u0001\u0004\tiAA\u0006Q_N\f5o]5h]\u0016\u00148cA\u001b\u0002\u0004V\t!/A\u0004q_N|F%Z9\u0015\u0007Q\u0013y\u0007\u0003\u0005\u0003B]\n\t\u00111\u0001s\u0003-\u0001xn]!tg&<g.\u001a:\u0016\u0005\tU\u0004CA:6\u0005I!UMZ1vYR\u0004vn]!tg&<g.\u001a:\u0014\u000be\n\u0019I!\u001e\u0015\u0005\tu\u0004CA::)\r!&\u0011\u0011\u0005\t\u0005\u0003b\u0014\u0011!a\u0001e\u0006!\u0001o\\:!)\r!&q\u0011\u0005\b\u0003Ss\u0004\u0019AA\u0007\u0003\u0015\tG\u000fU8t+\u0011\u0011iI!&\u0015\t\t=%1\u0015\u000b\u0005\u0005#\u0013\t\u000b\u0005\u0003\u0003\u0014\nUE\u0002\u0001\u0003\b\u0005/{$\u0019\u0001BM\u0005\u0005!\u0016\u0003\u0002BN\u0003\u001b\u00012A\u0013BO\u0013\r\u0011y*\u0012\u0002\b\u001d>$\b.\u001b8h\u0011\u001d\t9f\u0010a\u0001\u0005#Ca!a>@\u0001\u0004\u0011\b\u0003\u0002BT\u0005Sk\u0011!Q\u0005\u0004\u0005W\u000b%aC*z[\n|G\u000eV1cY\u0016\u0004")
public interface Positions
extends scala.reflect.api.Positions {
    public void scala$reflect$internal$Positions$_setter_$NoPosition_$eq(NoPosition$ var1);

    public void scala$reflect$internal$Positions$_setter_$PositionTag_$eq(ClassTag<Position> var1);

    public void scala$reflect$internal$Positions$_setter_$scala$reflect$internal$Positions$$posStartOrdering_$eq(Ordering<Trees.Tree> var1);

    public void scala$reflect$internal$Positions$_setter_$scala$reflect$internal$Positions$$setChildrenPosAccumulator_$eq(ReusableInstance<SetChildrenPosAccumulator> var1);

    @Override
    public NoPosition$ NoPosition();

    public ClassTag<Position> PositionTag();

    public static /* synthetic */ boolean useOffsetPositions$(Positions $this) {
        return $this.useOffsetPositions();
    }

    default public boolean useOffsetPositions() {
        return true;
    }

    public static /* synthetic */ Position wrappingPos$(Positions $this, Position position, List trees) {
        return $this.wrappingPos(position, trees);
    }

    default public Position wrappingPos(Position position, List<Trees.Tree> trees) {
        return this.wrappingPos(position, trees, true);
    }

    public static /* synthetic */ Position wrappingPos$(Positions $this, Position position, List trees, boolean focus) {
        return $this.wrappingPos(position, trees, focus);
    }

    default public Position wrappingPos(Position position, List<Trees.Tree> trees, boolean focus) {
        if (this.useOffsetPositions()) {
            return position;
        }
        WrappingPosAccumulator accum = new WrappingPosAccumulator((SymbolTable)this);
        for (List rest = trees; rest != Nil$.MODULE$; rest = (List)rest.tail()) {
            Trees.Tree head = rest.head();
            accum.apply(head);
        }
        return accum.result(position, focus);
    }

    public static /* synthetic */ Position wrappingPos$(Positions $this, List trees) {
        return $this.wrappingPos(trees);
    }

    default public Position wrappingPos(List<Trees.Tree> trees) {
        Position headpos = trees.head().pos();
        if (this.useOffsetPositions() || !headpos.isDefined()) {
            return headpos;
        }
        return this.wrappingPos(headpos, trees);
    }

    public static /* synthetic */ void ensureNonOverlapping$(Positions $this, Trees.Tree tree, List others) {
        $this.ensureNonOverlapping(tree, others);
    }

    default public void ensureNonOverlapping(Trees.Tree tree, List<Trees.Tree> others) {
        this.ensureNonOverlapping(tree, others, true);
    }

    public static /* synthetic */ void ensureNonOverlapping$(Positions $this, Trees.Tree tree, List others, boolean focus) {
        $this.ensureNonOverlapping(tree, others, focus);
    }

    default public void ensureNonOverlapping(Trees.Tree tree, List<Trees.Tree> others, boolean focus) {
        if (this.useOffsetPositions()) {
            return;
        }
        Position treePos = tree.pos();
        if (Positions.isOverlapping$1(treePos, others)) {
            List children = tree.children();
            if (children == null) {
                throw null;
            }
            List foreach_these = children;
            while (!foreach_these.isEmpty()) {
                Trees.Tree tree2 = foreach_these.head();
                this.ensureNonOverlapping(tree2, others, focus);
                foreach_these = (List)foreach_these.tail();
            }
            if (treePos.isOpaqueRange()) {
                Position wpos = this.wrappingPos(treePos, children, focus);
                tree.setPos(Positions.isOverlapping$1(wpos, others) ? treePos.makeTransparent() : wpos);
                return;
            }
        }
    }

    public static /* synthetic */ Position rangePos$(Positions $this, SourceFile source2, int start, int point, int end) {
        return $this.rangePos(source2, start, point, end);
    }

    default public Position rangePos(SourceFile source2, int start, int point, int end) {
        if (this.useOffsetPositions()) {
            return Position$.MODULE$.offset(source2, point);
        }
        return Position$.MODULE$.range(source2, start, point, end);
    }

    public static /* synthetic */ void scala$reflect$internal$Positions$$reportTree$(Positions $this, String prefix, Trees.Tree tree) {
        $this.scala$reflect$internal$Positions$$reportTree(prefix, tree);
    }

    default public void scala$reflect$internal$Positions$$reportTree(String prefix, Trees.Tree tree) {
        String source2 = tree.pos().isDefined() ? tree.pos().source() : "";
        ((Reporting)((Object)this)).inform(new StringBuilder(24).append("== ").append(prefix).append(" tree [").append(tree.id()).append("] of type ").append(tree.productPrefix()).append(" at ").append(tree.pos().show()).append((Object)source2).toString());
        ((Reporting)((Object)this)).inform("");
        ((Reporting)((Object)this)).inform(((Trees)((Object)this)).treeStatus(tree, ((Trees)((Object)this)).treeStatus$default$2()));
        ((Reporting)((Object)this)).inform("");
    }

    public static /* synthetic */ void scala$reflect$internal$Positions$$positionError$(Positions $this, Trees.Tree topTree, String msg, Function0 body) {
        $this.scala$reflect$internal$Positions$$positionError(topTree, msg, body);
    }

    default public void scala$reflect$internal$Positions$$positionError(Trees.Tree topTree, String msg, Function0<BoxedUnit> body) {
        ((Reporting)((Object)this)).inform(new StringBuilder(23).append("======= Position error\n").append(msg).toString());
        body.apply$mcV$sp();
        ((Reporting)((Object)this)).inform(new StringBuilder(19).append("\nWhile validating #").append(topTree.id()).toString());
        ((Reporting)((Object)this)).inform(((Trees)((Object)this)).treeStatus(topTree, ((Trees)((Object)this)).treeStatus$default$2()));
        ((Reporting)((Object)this)).inform("\nChildren:");
        List list = topTree.children();
        if (list == null) {
            throw null;
        }
        List foreach_these = list;
        while (!foreach_these.isEmpty()) {
            Trees.Tree tree = foreach_these.head();
            Positions.$anonfun$positionError$1(this, topTree, tree);
            foreach_these = (List)foreach_these.tail();
        }
        ((Reporting)((Object)this)).inform("=======");
        throw new ValidateException((SymbolTable)this, msg);
    }

    public Ordering<Trees.Tree> scala$reflect$internal$Positions$$posStartOrdering();

    public static /* synthetic */ void validatePositions$(Positions $this, Trees.Tree tree) {
        $this.validatePositions(tree);
    }

    default public void validatePositions(Trees.Tree tree) {
        if (!this.useOffsetPositions()) {
            LazyRef worker$module = new LazyRef();
            this.worker$2(worker$module, tree).loop(tree, tree);
        }
    }

    private void setChildrenPos(Position pos, Trees.Tree parent) {
        block7: {
            try {
                ReusableInstance<SetChildrenPosAccumulator> reusableInstance = this.scala$reflect$internal$Positions$$setChildrenPosAccumulator();
                if (reusableInstance == null) {
                    throw null;
                }
                ReusableInstance<SetChildrenPosAccumulator> using_this = reusableInstance;
                if (!using_this.scala$reflect$internal$util$ReusableInstance$$enabled || using_this.scala$reflect$internal$util$ReusableInstance$$taken()) {
                    SetChildrenPosAccumulator setChildrenPosAccumulator = (SetChildrenPosAccumulator)using_this.scala$reflect$internal$util$ReusableInstance$$make.apply();
                    setChildrenPosAccumulator.set(pos, parent);
                    break block7;
                }
                try {
                    using_this.scala$reflect$internal$util$ReusableInstance$$taken_$eq(true);
                    SetChildrenPosAccumulator setChildrenPosAccumulator = using_this.scala$reflect$internal$util$ReusableInstance$$cached();
                    setChildrenPosAccumulator.set(pos, parent);
                }
                finally {
                    using_this.scala$reflect$internal$util$ReusableInstance$$taken_$eq(false);
                }
            }
            catch (Exception ex) {
                ((Reporting)((Object)this)).inform(new StringBuilder(33).append("error while set children pos ").append(pos).append(" of ").append(parent.children()).toString());
                throw ex;
            }
        }
    }

    public ReusableInstance<SetChildrenPosAccumulator> scala$reflect$internal$Positions$$setChildrenPosAccumulator();

    public static /* synthetic */ PosAssigner posAssigner$(Positions $this) {
        return $this.posAssigner();
    }

    default public PosAssigner posAssigner() {
        return new DefaultPosAssigner((SymbolTable)this);
    }

    public static /* synthetic */ Trees.Tree atPos$(Positions $this, Position pos, Trees.Tree tree) {
        return $this.atPos(pos, tree);
    }

    default public <T extends Trees.Tree> T atPos(Position pos, T tree) {
        if (this.useOffsetPositions() || !pos.isOpaqueRange()) {
            this.posAssigner().pos_$eq(pos);
            ((Trees.Traverser)((Object)this.posAssigner())).traverse(tree);
            return tree;
        }
        if (!tree.isEmpty() && tree.canHaveAttrs()) {
            Position position = tree.pos();
            NoPosition$ noPosition$ = this.NoPosition();
            if (!(position != null ? !position.equals(noPosition$) : noPosition$ != null)) {
                tree.setPos(pos);
                Trees.Tree tree2 = tree.onlyChild();
                if (((Object)((Trees)((Object)this)).EmptyTree()).equals(tree2)) {
                    this.setChildrenPos(pos, tree);
                } else {
                    this.atPos(pos, tree2);
                }
            }
        }
        return tree;
    }

    private static boolean isOverlapping$1(Position pos, List others$1) {
        if (pos.isRange()) {
            boolean bl;
            block5: {
                if (others$1 == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = others$1;
                while (!exists_these.isEmpty()) {
                    Trees.Tree tree = (Trees.Tree)exists_these.head();
                    if (pos.overlaps(tree.pos())) {
                        bl = true;
                        break block5;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void $anonfun$positionError$1(Positions $this, Trees.Tree topTree$1, Trees.Tree t) {
        ((Reporting)((Object)$this)).inform(new StringBuilder(2).append("  ").append(((Trees)((Object)$this)).treeStatus(t, topTree$1)).toString());
    }

    private /* synthetic */ Positions$worker$1$ worker$lzycompute$1(LazyRef worker$module$1, Trees.Tree tree$1) {
        synchronized (worker$module$1) {
            Positions$worker$1$ positions$worker$1$ = worker$module$1.initialized() ? (Positions$worker$1$)worker$module$1.value() : worker$module$1.initialize(new Positions$worker$1$((SymbolTable)this, tree$1));
            return positions$worker$1$;
        }
    }

    private Positions$worker$1$ worker$2(LazyRef worker$module$1, Trees.Tree tree$1) {
        if (worker$module$1.initialized()) {
            return (Positions$worker$1$)worker$module$1.value();
        }
        return this.worker$lzycompute$1(worker$module$1, tree$1);
    }

    public static void $init$(Positions $this) {
        $this.scala$reflect$internal$Positions$_setter_$NoPosition_$eq(NoPosition$.MODULE$);
        $this.scala$reflect$internal$Positions$_setter_$PositionTag_$eq(ClassTag$.MODULE$.apply(Position.class));
        $this.scala$reflect$internal$Positions$_setter_$scala$reflect$internal$Positions$$posStartOrdering_$eq(new Ordering<Trees.Tree>((SymbolTable)$this){
            private final /* synthetic */ SymbolTable $outer;

            public Some tryCompare(Object x, Object y) {
                return Ordering.tryCompare$(this, x, y);
            }

            public boolean lteq(Object x, Object y) {
                return Ordering.lteq$(this, x, y);
            }

            public boolean gteq(Object x, Object y) {
                return Ordering.gteq$(this, x, y);
            }

            public boolean lt(Object x, Object y) {
                return Ordering.lt$(this, x, y);
            }

            public boolean gt(Object x, Object y) {
                return Ordering.gt$(this, x, y);
            }

            public boolean equiv(Object x, Object y) {
                return Ordering.equiv$(this, x, y);
            }

            public Object max(Object x, Object y) {
                return Ordering.max$(this, x, y);
            }

            public Object min(Object x, Object y) {
                return Ordering.min$(this, x, y);
            }

            public Ordering<Trees.Tree> reverse() {
                return Ordering.reverse$(this);
            }

            public <U> Ordering<U> on(Function1<U, Trees.Tree> f) {
                return Ordering.on$(this, f);
            }

            public Ordering.Ops mkOrderingOps(Object lhs) {
                return Ordering.mkOrderingOps$(this, lhs);
            }

            public int compare(Trees.Tree x, Trees.Tree y) {
                Position posOf$1_pos = x.pos();
                int n = posOf$1_pos == this.$outer.NoPosition() ? Integer.MIN_VALUE : posOf$1_pos.start();
                Position posOf$1_pos2 = y.pos();
                return Integer.compare(n, posOf$1_pos2 == this.$outer.NoPosition() ? Integer.MIN_VALUE : posOf$1_pos2.start());
            }

            private final int posOf$1(Trees.Tree t) {
                Position pos = t.pos();
                if (pos == this.$outer.NoPosition()) {
                    return Integer.MIN_VALUE;
                }
                return pos.start();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                PartialOrdering.$init$(this);
                Ordering.$init$(this);
            }
        });
        $this.scala$reflect$internal$Positions$_setter_$scala$reflect$internal$Positions$$setChildrenPosAccumulator_$eq(new ReusableInstance<SetChildrenPosAccumulator>((Function0<SetChildrenPosAccumulator> & java.io.Serializable & Serializable)() -> new SetChildrenPosAccumulator((SymbolTable)$this), ((SymbolTable)$this).isCompilerUniverse()));
    }

    public static /* synthetic */ Object $anonfun$ensureNonOverlapping$2$adapted(Positions $this, List others$1, boolean focus$1, Trees.Tree x$2) {
        $this.ensureNonOverlapping(x$2, others$1, focus$1);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$positionError$1$adapted(Positions $this, Trees.Tree topTree$1, Trees.Tree t) {
        Positions.$anonfun$positionError$1($this, topTree$1, t);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$setChildrenPos$1$adapted(Position pos$2, Trees.Tree parent$1, SetChildrenPosAccumulator x$3) {
        x$3.set(pos$2, parent$1);
        return BoxedUnit.UNIT;
    }

    public static /* synthetic */ Object $anonfun$ensureNonOverlapping$1$adapted(Position pos$1, Trees.Tree x$1) {
        return BoxesRunTime.boxToBoolean(pos$1.overlaps(x$1.pos()));
    }

    public static abstract class ChildSolidDescendantsCollector
    extends Trees.Traverser {
        public final /* synthetic */ SymbolTable $outer;

        public void traverseModifiers(Trees.Modifiers mods) {
        }

        public void traverse(Trees.Tree tree) {
            if (tree != this.scala$reflect$internal$Positions$ChildSolidDescendantsCollector$$$outer().EmptyTree()) {
                if (tree.pos().isTransparent()) {
                    super.traverse(tree);
                    return;
                }
                this.traverseSolidChild(tree);
            }
        }

        public abstract void traverseSolidChild(Trees.Tree var1);

        public void apply(Trees.Tree t) {
            super.traverse(t);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Positions$ChildSolidDescendantsCollector$$$outer() {
            return this.$outer;
        }

        public ChildSolidDescendantsCollector(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super($outer);
        }
    }

    public static class DefaultPosAssigner
    extends Trees.Traverser
    implements PosAssigner {
        private Position pos;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public Position pos() {
            return this.pos;
        }

        @Override
        public void pos_$eq(Position x$1) {
            this.pos = x$1;
        }

        public void traverse(Trees.Tree t) {
            block5: {
                block7: {
                    NoPosition$ noPosition$;
                    Position position;
                    block6: {
                        if (!t.canHaveAttrs()) break block5;
                        position = t.pos();
                        noPosition$ = this.scala$reflect$internal$Positions$DefaultPosAssigner$$$outer().NoPosition();
                        if (position != null) break block6;
                        if (noPosition$ != null) {
                            return;
                        }
                        break block7;
                    }
                    if (!position.equals(noPosition$)) break block5;
                }
                t.setPos(this.pos());
                super.traverse(t);
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Positions$DefaultPosAssigner$$$outer() {
            return this.$outer;
        }

        public DefaultPosAssigner(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super($outer);
        }
    }

    public class Locator
    extends Trees.Traverser {
        private final Position pos;
        private Trees.Tree last;
        public final /* synthetic */ SymbolTable $outer;

        public Trees.Tree last() {
            return this.last;
        }

        public void last_$eq(Trees.Tree x$1) {
            this.last = x$1;
        }

        public Trees.Tree locateIn(Trees.Tree root) {
            this.last_$eq(this.scala$reflect$internal$Positions$Locator$$$outer().EmptyTree());
            this.traverse(root);
            return this.last();
        }

        public boolean isEligible(Trees.Tree t) {
            return !t.pos().isTransparent();
        }

        public void traverse(Trees.Tree t) {
            Trees.TypeTree typeTree;
            if (t instanceof Trees.TypeTree && (typeTree = (Trees.TypeTree)t).original() != null && typeTree.pos().includes(typeTree.original().pos())) {
                this.traverse(typeTree.original());
                return;
            }
            if (t.pos().includes(this.pos)) {
                if (this.isEligible(t)) {
                    this.last_$eq(t);
                }
                super.traverse(t);
                return;
            }
            if (t instanceof Trees.MemberDef) {
                Trees.MemberDef memberDef = (Trees.MemberDef)t;
                List<Trees.TreeApi> list = memberDef.mods().annotations();
                List<Trees.TreeApi> list2 = ((Object)Nil$.MODULE$).equals(list) && memberDef.symbol() != null ? memberDef.symbol().annotations().map((Function1<AnnotationInfos.AnnotationInfo, Trees.Tree> & java.io.Serializable & Serializable)x$4 -> x$4.original(), List$.MODULE$.canBuildFrom()) : list;
                this.traverseTrees(list2);
                return;
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Positions$Locator$$$outer() {
            return this.$outer;
        }

        public Locator(SymbolTable $outer, Position pos) {
            this.pos = pos;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super($outer);
        }
    }

    public interface PosAssigner {
        public Position pos();

        public void pos_$eq(Position var1);
    }

    private static final class SetChildrenPosAccumulator
    implements Function1<Trees.Tree, Object> {
        private final WrappingPosAccumulator wrappingPosAccumulator;
        private Position pos;
        private final /* synthetic */ SymbolTable $outer;

        @Override
        public boolean apply$mcZD$sp(double v1) {
            return Function1.apply$mcZD$sp$(this, v1);
        }

        @Override
        public double apply$mcDD$sp(double v1) {
            return Function1.apply$mcDD$sp$(this, v1);
        }

        @Override
        public float apply$mcFD$sp(double v1) {
            return Function1.apply$mcFD$sp$(this, v1);
        }

        @Override
        public int apply$mcID$sp(double v1) {
            return Function1.apply$mcID$sp$(this, v1);
        }

        @Override
        public long apply$mcJD$sp(double v1) {
            return Function1.apply$mcJD$sp$(this, v1);
        }

        @Override
        public void apply$mcVD$sp(double v1) {
            Function1.apply$mcVD$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZF$sp(float v1) {
            return Function1.apply$mcZF$sp$(this, v1);
        }

        @Override
        public double apply$mcDF$sp(float v1) {
            return Function1.apply$mcDF$sp$(this, v1);
        }

        @Override
        public float apply$mcFF$sp(float v1) {
            return Function1.apply$mcFF$sp$(this, v1);
        }

        @Override
        public int apply$mcIF$sp(float v1) {
            return Function1.apply$mcIF$sp$(this, v1);
        }

        @Override
        public long apply$mcJF$sp(float v1) {
            return Function1.apply$mcJF$sp$(this, v1);
        }

        @Override
        public void apply$mcVF$sp(float v1) {
            Function1.apply$mcVF$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZI$sp(int v1) {
            return Function1.apply$mcZI$sp$(this, v1);
        }

        @Override
        public double apply$mcDI$sp(int v1) {
            return Function1.apply$mcDI$sp$(this, v1);
        }

        @Override
        public float apply$mcFI$sp(int v1) {
            return Function1.apply$mcFI$sp$(this, v1);
        }

        @Override
        public int apply$mcII$sp(int v1) {
            return Function1.apply$mcII$sp$(this, v1);
        }

        @Override
        public long apply$mcJI$sp(int v1) {
            return Function1.apply$mcJI$sp$(this, v1);
        }

        @Override
        public void apply$mcVI$sp(int v1) {
            Function1.apply$mcVI$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZJ$sp(long v1) {
            return Function1.apply$mcZJ$sp$(this, v1);
        }

        @Override
        public double apply$mcDJ$sp(long v1) {
            return Function1.apply$mcDJ$sp$(this, v1);
        }

        @Override
        public float apply$mcFJ$sp(long v1) {
            return Function1.apply$mcFJ$sp$(this, v1);
        }

        @Override
        public int apply$mcIJ$sp(long v1) {
            return Function1.apply$mcIJ$sp$(this, v1);
        }

        @Override
        public long apply$mcJJ$sp(long v1) {
            return Function1.apply$mcJJ$sp$(this, v1);
        }

        @Override
        public void apply$mcVJ$sp(long v1) {
            Function1.apply$mcVJ$sp$(this, v1);
        }

        @Override
        public <A> Function1<A, Object> compose(Function1<A, Trees.Tree> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public <A> Function1<Trees.Tree, A> andThen(Function1<Object, A> g) {
            return Function1.andThen$(this, g);
        }

        @Override
        public String toString() {
            return Function1.toString$(this);
        }

        public void set(Position pos, Trees.Tree parent) {
            this.wrappingPosAccumulator.reset();
            this.pos = pos;
            try {
                parent.foreachChild(this);
            }
            finally {
                this.pos = null;
            }
        }

        @Override
        public boolean apply(Trees.Tree tree) {
            this.wrappingPosAccumulator.reset();
            if (!tree.isEmpty() && tree.canHaveAttrs()) {
                Position position = tree.pos();
                NoPosition$ noPosition$ = this.$outer.NoPosition();
                if (!(position != null ? !position.equals(noPosition$) : noPosition$ != null)) {
                    tree.foreachChild(this);
                    tree.foreachChild(this.wrappingPosAccumulator);
                    Position wrappingPos = this.wrappingPosAccumulator.result(this.pos, true);
                    tree.setPos(wrappingPos);
                }
            }
            return true;
        }

        public SetChildrenPosAccumulator(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            this.wrappingPosAccumulator = new WrappingPosAccumulator($outer);
        }
    }

    public class TypedLocator
    extends Locator {
        @Override
        public boolean isEligible(Trees.Tree t) {
            return super.isEligible(t) && t.tpe() != null;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$Positions$TypedLocator$$$outer() {
            return this.$outer;
        }

        public TypedLocator(SymbolTable $outer, Position pos) {
            super($outer, pos);
        }
    }

    public static class ValidateException
    extends Exception {
        public final /* synthetic */ SymbolTable $outer;

        public /* synthetic */ SymbolTable scala$reflect$internal$Positions$ValidateException$$$outer() {
            return this.$outer;
        }

        public ValidateException(SymbolTable $outer, String msg) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            super(msg);
        }
    }

    private final class WrappingPosAccumulator
    implements Function1<Trees.Tree, Object> {
        private int min;
        private int max;

        @Override
        public boolean apply$mcZD$sp(double v1) {
            return Function1.apply$mcZD$sp$(this, v1);
        }

        @Override
        public double apply$mcDD$sp(double v1) {
            return Function1.apply$mcDD$sp$(this, v1);
        }

        @Override
        public float apply$mcFD$sp(double v1) {
            return Function1.apply$mcFD$sp$(this, v1);
        }

        @Override
        public int apply$mcID$sp(double v1) {
            return Function1.apply$mcID$sp$(this, v1);
        }

        @Override
        public long apply$mcJD$sp(double v1) {
            return Function1.apply$mcJD$sp$(this, v1);
        }

        @Override
        public void apply$mcVD$sp(double v1) {
            Function1.apply$mcVD$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZF$sp(float v1) {
            return Function1.apply$mcZF$sp$(this, v1);
        }

        @Override
        public double apply$mcDF$sp(float v1) {
            return Function1.apply$mcDF$sp$(this, v1);
        }

        @Override
        public float apply$mcFF$sp(float v1) {
            return Function1.apply$mcFF$sp$(this, v1);
        }

        @Override
        public int apply$mcIF$sp(float v1) {
            return Function1.apply$mcIF$sp$(this, v1);
        }

        @Override
        public long apply$mcJF$sp(float v1) {
            return Function1.apply$mcJF$sp$(this, v1);
        }

        @Override
        public void apply$mcVF$sp(float v1) {
            Function1.apply$mcVF$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZI$sp(int v1) {
            return Function1.apply$mcZI$sp$(this, v1);
        }

        @Override
        public double apply$mcDI$sp(int v1) {
            return Function1.apply$mcDI$sp$(this, v1);
        }

        @Override
        public float apply$mcFI$sp(int v1) {
            return Function1.apply$mcFI$sp$(this, v1);
        }

        @Override
        public int apply$mcII$sp(int v1) {
            return Function1.apply$mcII$sp$(this, v1);
        }

        @Override
        public long apply$mcJI$sp(int v1) {
            return Function1.apply$mcJI$sp$(this, v1);
        }

        @Override
        public void apply$mcVI$sp(int v1) {
            Function1.apply$mcVI$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZJ$sp(long v1) {
            return Function1.apply$mcZJ$sp$(this, v1);
        }

        @Override
        public double apply$mcDJ$sp(long v1) {
            return Function1.apply$mcDJ$sp$(this, v1);
        }

        @Override
        public float apply$mcFJ$sp(long v1) {
            return Function1.apply$mcFJ$sp$(this, v1);
        }

        @Override
        public int apply$mcIJ$sp(long v1) {
            return Function1.apply$mcIJ$sp$(this, v1);
        }

        @Override
        public long apply$mcJJ$sp(long v1) {
            return Function1.apply$mcJJ$sp$(this, v1);
        }

        @Override
        public void apply$mcVJ$sp(long v1) {
            Function1.apply$mcVJ$sp$(this, v1);
        }

        @Override
        public <A> Function1<A, Object> compose(Function1<A, Trees.Tree> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public <A> Function1<Trees.Tree, A> andThen(Function1<Object, A> g) {
            return Function1.andThen$(this, g);
        }

        @Override
        public String toString() {
            return Function1.toString$(this);
        }

        public void reset() {
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
        }

        public Position result(Position position, boolean focus) {
            if (this.min > this.max) {
                if (focus) {
                    return position.focus();
                }
                return position;
            }
            return Position$.MODULE$.range(position.source(), this.min, position.point(), this.max);
        }

        @Override
        public boolean apply(Trees.Tree v1) {
            Position pos = v1.pos();
            if (pos.isRange()) {
                this.min = Math.min(this.min, pos.start());
                this.max = Math.max(this.max, pos.end());
            }
            return true;
        }

        public WrappingPosAccumulator(SymbolTable $outer) {
            this.reset();
        }
    }
}

