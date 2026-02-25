/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Predef$;
import scala.Serializable;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.Statistics;
import scala.runtime.java8.JFunction0$mcI$sp;

@ScalaSignature(bytes="\u0006\u000112\u0001\u0002B\u0003\u0011\u0002\u0007\u0005A\"\n\u0005\u0006#\u0001!\tA\u0005\u0005\b-\u0001\u0011\r\u0011\"\u0001\u0018\u0011\u001d\u0001\u0003A1A\u0005\u0002\u0005\u0012!bU2pa\u0016\u001cF/\u0019;t\u0015\t1q!\u0001\u0005j]R,'O\\1m\u0015\tA\u0011\"A\u0004sK\u001adWm\u0019;\u000b\u0003)\tQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001\u001bA\u0011abD\u0007\u0002\u0013%\u0011\u0001#\u0003\u0002\u0007\u0003:L(+\u001a4\u0002\r\u0011Jg.\u001b;%)\u0005\u0019\u0002C\u0001\b\u0015\u0013\t)\u0012B\u0001\u0003V]&$\u0018AD:d_B,7i\\;oiZKWm^\u000b\u00021A\u0011\u0011DG\u0007\u0002\u0001%\u00111\u0004\b\u0002\u0005-&,w/\u0003\u0002\u001e=\tQ1\u000b^1uSN$\u0018nY:\u000b\u0005})\u0011\u0001B;uS2\f1c]2pa\u0016\u0004v\u000e];mCRLwN\u001c+j[\u0016,\u0012A\t\t\u00033\rJ!\u0001\n\u000f\u0003\u000bQKW.\u001a:\u0013\u0007\u0019B#F\u0002\u0003(\u0001\u0001)#\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004CA\u0015\u0001\u001b\u0005)\u0001CA\u0016\u001d\u001b\u0005q\u0002")
public interface ScopeStats {
    public void scala$reflect$internal$ScopeStats$_setter_$scopeCountView_$eq(Statistics.View var1);

    public void scala$reflect$internal$ScopeStats$_setter_$scopePopulationTime_$eq(Statistics.Timer var1);

    public Statistics.View scopeCountView();

    public Statistics.Timer scopePopulationTime();

    public static void $init$(ScopeStats $this) {
        $this.scala$reflect$internal$ScopeStats$_setter_$scopeCountView_$eq(((Statistics)((Object)$this)).newView("#created scopes", Predef$.MODULE$.wrapRefArray((Object[])new String[0]), (JFunction0$mcI$sp & Serializable)() -> ((Statistics)((Object)$this)).symbolTable().scopeCount()));
        $this.scala$reflect$internal$ScopeStats$_setter_$scopePopulationTime_$eq(((Statistics)((Object)$this)).newTimer("time spent in scope population", Predef$.MODULE$.wrapRefArray((Object[])new String[0])));
    }
}

