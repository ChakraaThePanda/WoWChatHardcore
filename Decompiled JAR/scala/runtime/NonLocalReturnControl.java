/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.util.control.ControlThrowable;
import scala.util.control.NoStackTrace;

@ScalaSignature(bytes="\u0006\u0001}2Aa\u0002\u0005\u0001\u001b!Aq\u0004\u0001BC\u0002\u0013\u0005\u0001\u0005\u0003\u0005%\u0001\t\u0005\t\u0015!\u0003\"\u0011!)\u0003A!b\u0001\n\u00031\u0003\u0002\u0003\u001c\u0001\u0005\u0003\u0005\u000b\u0011B\u0014\t\u000b]\u0002A\u0011\u0001\u001d\t\u000bu\u0002AQ\t \u0003+9{g\u000eT8dC2\u0014V\r^;s]\u000e{g\u000e\u001e:pY*\u0011\u0011BC\u0001\beVtG/[7f\u0015\u0005Y\u0011!B:dC2\f7\u0001A\u000b\u0003\u001d%\u001a2\u0001A\b\u0018!\t\u0001BC\u0004\u0002\u0012%5\t!\"\u0003\u0002\u0014\u0015\u00059\u0001/Y2lC\u001e,\u0017BA\u000b\u0017\u0005%!\u0006N]8xC\ndWM\u0003\u0002\u0014\u0015A\u0011\u0001$H\u0007\u00023)\u0011!dG\u0001\bG>tGO]8m\u0015\ta\"\"\u0001\u0003vi&d\u0017B\u0001\u0010\u001a\u0005A\u0019uN\u001c;s_2$\u0006N]8xC\ndW-A\u0002lKf,\u0012!\t\t\u0003#\tJ!a\t\u0006\u0003\r\u0005s\u0017PU3g\u0003\u0011YW-\u001f\u0011\u0002\u000bY\fG.^3\u0016\u0003\u001d\u0002\"\u0001K\u0015\r\u0001\u0011I!\u0006\u0001Q\u0001\u0002\u0003\u0015\ra\u000b\u0002\u0002)F\u0011Af\f\t\u0003#5J!A\f\u0006\u0003\u000f9{G\u000f[5oOB\u0011\u0011\u0003M\u0005\u0003c)\u00111!\u00118zQ\tI3\u0007\u0005\u0002\u0012i%\u0011QG\u0003\u0002\fgB,7-[1mSj,G-\u0001\u0004wC2,X\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0007eZD\bE\u0002;\u0001\u001dj\u0011\u0001\u0003\u0005\u0006?\u0015\u0001\r!\t\u0005\u0006K\u0015\u0001\raJ\u0001\u0011M&dG.\u00138Ti\u0006\u001c7\u000e\u0016:bG\u0016$\u0012a\u0004")
public class NonLocalReturnControl<T>
extends Throwable
implements ControlThrowable {
    private final Object key;
    public final T value;

    @Override
    public /* synthetic */ Throwable scala$util$control$NoStackTrace$$super$fillInStackTrace() {
        return super.fillInStackTrace();
    }

    public Object key() {
        return this.key;
    }

    public T value() {
        return this.value;
    }

    @Override
    public final Throwable fillInStackTrace() {
        return this;
    }

    public boolean value$mcZ$sp() {
        return BoxesRunTime.unboxToBoolean(this.value());
    }

    public byte value$mcB$sp() {
        return BoxesRunTime.unboxToByte(this.value());
    }

    public char value$mcC$sp() {
        return BoxesRunTime.unboxToChar(this.value());
    }

    public double value$mcD$sp() {
        return BoxesRunTime.unboxToDouble(this.value());
    }

    public float value$mcF$sp() {
        return BoxesRunTime.unboxToFloat(this.value());
    }

    public int value$mcI$sp() {
        return BoxesRunTime.unboxToInt(this.value());
    }

    public long value$mcJ$sp() {
        return BoxesRunTime.unboxToLong(this.value());
    }

    public short value$mcS$sp() {
        return BoxesRunTime.unboxToShort(this.value());
    }

    public void value$mcV$sp() {
        this.value();
    }

    public boolean specInstance$() {
        return false;
    }

    public NonLocalReturnControl(Object key, T value) {
        this.key = key;
        this.value = value;
        NoStackTrace.$init$(this);
    }
}

