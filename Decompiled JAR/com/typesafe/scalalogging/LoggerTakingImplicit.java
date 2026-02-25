/*
 * Decompiled with CFR 0.152.
 */
package com.typesafe.scalalogging;

import com.typesafe.scalalogging.CanLog;
import com.typesafe.scalalogging.LoggerTakingImplicitImpl;
import org.slf4j.Logger;
import scala.Serializable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t3AAB\u0004\u0001\u001d!AQ\u0005\u0001BC\u0002\u0013\u0005a\u0005\u0003\u00050\u0001\t\u0005\t\u0015!\u0003(\u0011!\u0001\u0004A!b\u0001\n\u0007\t\u0004\u0002C\u001b\u0001\u0005\u0003\u0005\u000b\u0011\u0002\u001a\t\rY\u0002A\u0011A\u00048\u0005QaunZ4feR\u000b7.\u001b8h\u00136\u0004H.[2ji*\u0011\u0001\"C\u0001\rg\u000e\fG.\u00197pO\u001eLgn\u001a\u0006\u0003\u0015-\t\u0001\u0002^=qKN\fg-\u001a\u0006\u0002\u0019\u0005\u00191m\\7\u0004\u0001U\u0011qBF\n\u0004\u0001A\u0011\u0003cA\t\u0013)5\tq!\u0003\u0002\u0014\u000f\tABj\\4hKJ$\u0016m[5oO&k\u0007\u000f\\5dSRLU\u000e\u001d7\u0011\u0005U1B\u0002\u0001\u0003\u0006/\u0001\u0011\r\u0001\u0007\u0002\u0002\u0003F\u0011\u0011d\b\t\u00035ui\u0011a\u0007\u0006\u00029\u0005)1oY1mC&\u0011ad\u0007\u0002\b\u001d>$\b.\u001b8h!\tQ\u0002%\u0003\u0002\"7\t\u0019\u0011I\\=\u0011\u0005i\u0019\u0013B\u0001\u0013\u001c\u00051\u0019VM]5bY&T\u0018M\u00197f\u0003))h\u000eZ3sYfLgnZ\u000b\u0002OA\u0011\u0001&L\u0007\u0002S)\u0011!fK\u0001\u0006g24GG\u001b\u0006\u0002Y\u0005\u0019qN]4\n\u00059J#A\u0002'pO\u001e,'/A\u0006v]\u0012,'\u000f\\=j]\u001e\u0004\u0013\u0001C2b]2{w-\u0012<\u0016\u0003I\u00022!E\u001a\u0015\u0013\t!tA\u0001\u0004DC:dunZ\u0001\nG\u0006tGj\\4Fm\u0002\na\u0001P5oSRtDC\u0001\u001d<)\tI$\bE\u0002\u0012\u0001QAQ\u0001M\u0003A\u0004IBQ!J\u0003A\u0002\u001dBC\u0001A\u001fA\u0003B\u0011!DP\u0005\u0003\u007fm\u0011\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u0002\u000bY\fG.^3\u001f\te\u0002\"2?")
public class LoggerTakingImplicit<A>
extends LoggerTakingImplicitImpl<A>
implements Serializable {
    public static final long serialVersionUID = 957385465L;
    private final Logger underlying;
    private final CanLog<A> canLogEv;

    public Logger underlying() {
        return this.underlying;
    }

    public CanLog<A> canLogEv() {
        return this.canLogEv;
    }

    public LoggerTakingImplicit(Logger underlying, CanLog<A> canLogEv) {
        this.underlying = underlying;
        this.canLogEv = canLogEv;
    }
}

