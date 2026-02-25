/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Tuple2;
import scala.collection.convert.Wrappers;
import scala.collection.convert.Wrappers$;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.WeakHashMap$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001A4AAC\u0006\u0001%!)Q\u0007\u0001C\u0001m!)q\u0007\u0001C!q\u001d)\u0011h\u0003E\u0001u\u0019)!b\u0003E\u0001w!)Q\u0007\u0002C\u0001\r\")q\t\u0002C\u0002\u0011\"11\f\u0002Q\u0001\nqCQa\u000e\u0003\u0005\u0002}CqA\u001a\u0003\u0002\u0002\u0013%qMA\u0006XK\u0006\\\u0007*Y:i\u001b\u0006\u0004(B\u0001\u0007\u000e\u0003\u001diW\u000f^1cY\u0016T!AD\b\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\u0011\u0003\u0015\u00198-\u00197b\u0007\u0001)2aE\u0012/'\r\u0001A\u0003\r\t\u0005+u\tSF\u0004\u0002\u001759\u0011q\u0003G\u0007\u0002\u001b%\u0011\u0011$D\u0001\bG>tg/\u001a:u\u0013\tYB$\u0001\u0005Xe\u0006\u0004\b/\u001a:t\u0015\tIR\"\u0003\u0002\u001f?\tY!*T1q/J\f\u0007\u000f]3s\u0013\t\u0001CD\u0001\u0005Xe\u0006\u0004\b/\u001a:t!\t\u00113\u0005\u0004\u0001\u0005\u000b\u0011\u0002!\u0019A\u0013\u0003\u0003\u0005\u000b\"A\n\u0016\u0011\u0005\u001dBS\"A\b\n\u0005%z!a\u0002(pi\"Lgn\u001a\t\u0003O-J!\u0001L\b\u0003\u0007\u0005s\u0017\u0010\u0005\u0002#]\u0011)q\u0006\u0001b\u0001K\t\t!\tE\u0003\u0016c\u0005j3'\u0003\u00023?\ty!*T1q/J\f\u0007\u000f]3s\u0019&\\W\r\u0005\u00035\u0001\u0005jS\"A\u0006\u0002\rqJg.\u001b;?)\u0005\u0019\u0014!B3naRLX#A\u001a\u0002\u0017]+\u0017m\u001b%bg\"l\u0015\r\u001d\t\u0003i\u0011\u00192\u0001\u0002\u001fD!\ri\u0004IQ\u0007\u0002})\u0011q(D\u0001\bO\u0016tWM]5d\u0013\t\teHA\tNkR\f'\r\\3NCB4\u0015m\u0019;pef\u0004\"\u0001\u000e\u0001\u0011\u0005\u001d\"\u0015BA#\u0010\u00051\u0019VM]5bY&T\u0018M\u00197f)\u0005Q\u0014\u0001D2b]\n+\u0018\u000e\u001c3Ge>lWcA%X3V\t!\nE\u0003>\u00176\u001b&,\u0003\u0002M}\ta1)\u00198Ck&dGM\u0012:p[B\u0011ajT\u0007\u0002\t%\u0011\u0001+\u0015\u0002\u0005\u0007>dG.\u0003\u0002S}\tiq)\u001a8NCB4\u0015m\u0019;pef\u0004Ba\n+W1&\u0011Qk\u0004\u0002\u0007)V\u0004H.\u001a\u001a\u0011\u0005\t:F!\u0002\u0013\u0007\u0005\u0004)\u0003C\u0001\u0012Z\t\u0015ycA1\u0001&!\u0011!\u0004A\u0016-\u0002\u0017I+Wo]1cY\u0016\u001c%I\u0012\t\u0005\u001dv3c%\u0003\u0002_#\nyQ*\u00199DC:\u0014U/\u001b7e\rJ|W.F\u0002aG\u0016,\u0012!\u0019\t\u0005i\u0001\u0011G\r\u0005\u0002#G\u0012)A\u0005\u0003b\u0001KA\u0011!%\u001a\u0003\u0006_!\u0011\r!J\u0001\fe\u0016\fGMU3t_24X\rF\u0001i!\tIg.D\u0001k\u0015\tYG.\u0001\u0003mC:<'\"A7\u0002\t)\fg/Y\u0005\u0003_*\u0014aa\u00142kK\u000e$\b")
public class WeakHashMap<A, B>
extends Wrappers.JMapWrapper<A, B> {
    public static <A, B> CanBuildFrom<WeakHashMap<?, ?>, Tuple2<A, B>, WeakHashMap<A, B>> canBuildFrom() {
        return WeakHashMap$.MODULE$.canBuildFrom();
    }

    @Override
    public WeakHashMap<A, B> empty() {
        return new WeakHashMap<A, B>();
    }

    public WeakHashMap() {
        super(Wrappers$.MODULE$, new java.util.WeakHashMap());
    }
}

