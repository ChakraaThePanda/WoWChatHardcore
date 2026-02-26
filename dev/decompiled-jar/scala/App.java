/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Console$;
import scala.DelayedInit;
import scala.Function0;
import scala.Function1;
import scala.Serializable;
import scala.collection.mutable.ListBuffer;
import scala.compat.Platform$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.util.Properties$;

@ScalaSignature(bytes="\u0006\u0001}3q!\u0003\u0006\u0011\u0002\u0007\u0005Q\u0002C\u0003\u0016\u0001\u0011\u0005a\u0003C\u0004\u001b\u0001\t\u0007I\u0011A\u000e\t\u000b\u001d\u0002A\u0011\u0003\u0015\t\u0013i\u0002\u0001\u0019!a\u0001\n\u0013A\u0003\"C\u001e\u0001\u0001\u0004\u0005\r\u0011\"\u0003=\u0011\u001dy\u0004A1A\u0005\n\u0001CQ\u0001\u0014\u0001\u0005B5CQ!\u0017\u0001\u0005\u0002i\u00131!\u00119q\u0015\u0005Y\u0011!B:dC2\f7\u0001A\n\u0004\u00019\u0011\u0002CA\b\u0011\u001b\u0005Q\u0011BA\t\u000b\u0005\u0019\te.\u001f*fMB\u0011qbE\u0005\u0003))\u00111\u0002R3mCf,G-\u00138ji\u00061A%\u001b8ji\u0012\"\u0012a\u0006\t\u0003\u001faI!!\u0007\u0006\u0003\tUs\u0017\u000e^\u0001\u000fKb,7-\u001e;j_:\u001cF/\u0019:u+\u0005a\u0002CA\b\u001e\u0013\tq\"B\u0001\u0003M_:<\u0007\u0006\u0002\u0002!G\u0015\u0002\"aD\u0011\n\u0005\tR!\u0001\u00063faJ,7-\u0019;fI>3XM\u001d:jI&tw-I\u0001%\u0003\u001d*\u00070Z2vi&|gn\u0015;beR\u00043\u000f[8vY\u0012\u0004cn\u001c;!E\u0016\u0004sN^3se&$G-\u001a8\"\u0003\u0019\naA\r\u00182c9\u0002\u0014\u0001B1sON,\u0012!\u000b\t\u0004\u001f)b\u0013BA\u0016\u000b\u0005\u0015\t%O]1z!\tiCG\u0004\u0002/eA\u0011qFC\u0007\u0002a)\u0011\u0011\u0007D\u0001\u0007yI|w\u000e\u001e \n\u0005MR\u0011A\u0002)sK\u0012,g-\u0003\u00026m\t11\u000b\u001e:j]\u001eT!a\r\u0006)\t\r\u0001\u0003(J\u0011\u0002s\u0005i\u0012M]4tAMDw.\u001e7eA9|G\u000f\t2fA=4XM\u001d:jI\u0012,g.A\u0003`CJ<7/A\u0005`CJ<7o\u0018\u0013fcR\u0011q#\u0010\u0005\b}\u0015\t\t\u00111\u0001*\u0003\rAH%M\u0001\tS:LGoQ8eKV\t\u0011\tE\u0002C\u000f&k\u0011a\u0011\u0006\u0003\t\u0016\u000bq!\\;uC\ndWM\u0003\u0002G\u0015\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005!\u001b%A\u0003'jgR\u0014UO\u001a4feB\u0019qBS\f\n\u0005-S!!\u0003$v]\u000e$\u0018n\u001c81\u0003-!W\r\\1zK\u0012Le.\u001b;\u0015\u0005]q\u0005BB(\b\t\u0003\u0007\u0001+\u0001\u0003c_\u0012L\bcA\bR/%\u0011!K\u0003\u0002\ty\tLh.Y7f}!\"q\u0001V,&!\tyQ+\u0003\u0002W\u0015\tQA-\u001a9sK\u000e\fG/\u001a3\"\u0003a\u000b\u0001\u0006\u001e5fA\u0011,G.Y=fI&s\u0017\u000e\u001e\u0011nK\u000eD\u0017M\\5t[\u0002:\u0018\u000e\u001c7!I&\u001c\u0018\r\u001d9fCJ\fA!\\1j]R\u0011qc\u0017\u0005\u0006O!\u0001\r!\u000b\u0015\u0005\u0011\u0001jV%I\u0001_\u0003ui\u0017-\u001b8!g\"|W\u000f\u001c3!]>$\bEY3!_Z,'O]5eI\u0016t\u0007")
public interface App
extends DelayedInit {
    public void scala$App$_setter_$executionStart_$eq(long var1);

    public void scala$App$_setter_$scala$App$$initCode_$eq(ListBuffer<Function0<BoxedUnit>> var1);

    public long executionStart();

    public static /* synthetic */ String[] args$(App $this) {
        return $this.args();
    }

    default public String[] args() {
        return this.scala$App$$_args();
    }

    public String[] scala$App$$_args();

    public void scala$App$$_args_$eq(String[] var1);

    public ListBuffer<Function0<BoxedUnit>> scala$App$$initCode();

    public static /* synthetic */ void delayedInit$(App $this, Function0 body) {
        $this.delayedInit(body);
    }

    @Override
    default public void delayedInit(Function0<BoxedUnit> body) {
        this.scala$App$$initCode().$plus$eq((Object)body);
    }

    public static /* synthetic */ void main$(App $this, String[] args2) {
        $this.main(args2);
    }

    /*
     * WARNING - void declaration
     */
    default public void main(String[] args2) {
        void foreach_f;
        this.scala$App$$_args_$eq(args2);
        ListBuffer<Function0<BoxedUnit>> listBuffer = this.scala$App$$initCode();
        Function1<Function0, Object> & java.io.Serializable & Serializable intersect = (Function1<Function0, Object> & java.io.Serializable & Serializable)proc -> {
            proc.apply$mcV$sp();
            return BoxedUnit.UNIT;
        };
        if (listBuffer == null) {
            throw null;
        }
        listBuffer.underlying().foreach(foreach_f);
        if (Properties$.MODULE$.propIsSet("scala.time")) {
            if (Platform$.MODULE$ == null) {
                throw null;
            }
            long total = System.currentTimeMillis() - this.executionStart();
            Console$.MODULE$.println(new StringBuilder(10).append("[total ").append(total).append("ms]").toString());
        }
    }

    public static /* synthetic */ void $anonfun$main$1(Function0 proc) {
        proc.apply$mcV$sp();
    }

    public static void $init$(App $this) {
        if (Platform$.MODULE$ == null) {
            throw null;
        }
        $this.scala$App$_setter_$executionStart_$eq(System.currentTimeMillis());
        $this.scala$App$_setter_$scala$App$$initCode_$eq(new ListBuffer<Function0<BoxedUnit>>());
    }
}

