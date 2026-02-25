/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001]3q\u0001B\u0003\u0011\u0002\u0007\u0005\u0001\u0002C\u0003\u000f\u0001\u0011\u0005q\u0002C\u0003\u0014\u0001\u0019\u0005A\u0003C\u0003N\u0001\u0011\u0005cJA\u0005Gk:\u001cG/[8oa)\ta!A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0005%92C\u0001\u0001\u000b!\tYA\"D\u0001\u0006\u0013\tiQA\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003A\u0001\"aC\t\n\u0005I)!\u0001B+oSR\fQ!\u00199qYf$\u0012!\u0006\t\u0003-]a\u0001\u0001B\u0005\u0019\u0001\u0001\u0006\t\u0011\"b\u00013\t\t!+\u0005\u0002\u001b;A\u00111bG\u0005\u00039\u0015\u0011qAT8uQ&tw\r\u0005\u0002\f=%\u0011q$\u0002\u0002\u0004\u0003:L\bfA\f\"IA\u00111BI\u0005\u0003G\u0015\u00111b\u001d9fG&\fG.\u001b>fIF*1%\n&M\u0017B\u0019a%\u000b\u0017\u000f\u0005-9\u0013B\u0001\u0015\u0006\u00035\u0019\u0006/Z2jC2L'0\u00192mK&\u0011!f\u000b\u0002\u0006\u000fJ|W\u000f\u001d\u0006\u0003Q\u0015\u00012bC\u00170eUB4HP!E\u000f&\u0011a&\u0002\u0002\u0007)V\u0004H.Z\u001d\u000f\u0005-\u0001\u0014BA\u0019\u0006\u0003\u0011\u0011\u0015\u0010^3\u000f\u0005-\u0019\u0014B\u0001\u001b\u0006\u0003\u0015\u0019\u0006n\u001c:u\u001d\tYa'\u0003\u00028\u000b\u0005\u0019\u0011J\u001c;\u000f\u0005-I\u0014B\u0001\u001e\u0006\u0003\u0011auN\\4\u000f\u0005-a\u0014BA\u001f\u0006\u0003\u0011\u0019\u0005.\u0019:\u000f\u0005-y\u0014B\u0001!\u0006\u0003\u00151En\\1u\u001d\tY!)\u0003\u0002D\u000b\u00051Ai\\;cY\u0016t!aC#\n\u0005\u0019+\u0011a\u0002\"p_2,\u0017M\u001c\b\u0003\u0017!K!!S\u0003\u0002\tUs\u0017\u000e^\u0005\u0003\u0017.\n!\u0002\u0015:j[&$\u0018N^3tc\u0011!ce\n\u0015\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012a\u0014\t\u0003!Vk\u0011!\u0015\u0006\u0003%N\u000bA\u0001\\1oO*\tA+\u0001\u0003kCZ\f\u0017B\u0001,R\u0005\u0019\u0019FO]5oO\u0002")
public interface Function0<R> {
    public R apply();

    public static /* synthetic */ String toString$(Function0 $this) {
        return $this.toString();
    }

    default public String toString() {
        return "<function0>";
    }

    public static /* synthetic */ boolean apply$mcZ$sp$(Function0 $this) {
        return $this.apply$mcZ$sp();
    }

    default public boolean apply$mcZ$sp() {
        return BoxesRunTime.unboxToBoolean(this.apply());
    }

    public static /* synthetic */ byte apply$mcB$sp$(Function0 $this) {
        return $this.apply$mcB$sp();
    }

    default public byte apply$mcB$sp() {
        return BoxesRunTime.unboxToByte(this.apply());
    }

    public static /* synthetic */ char apply$mcC$sp$(Function0 $this) {
        return $this.apply$mcC$sp();
    }

    default public char apply$mcC$sp() {
        return BoxesRunTime.unboxToChar(this.apply());
    }

    public static /* synthetic */ double apply$mcD$sp$(Function0 $this) {
        return $this.apply$mcD$sp();
    }

    default public double apply$mcD$sp() {
        return BoxesRunTime.unboxToDouble(this.apply());
    }

    public static /* synthetic */ float apply$mcF$sp$(Function0 $this) {
        return $this.apply$mcF$sp();
    }

    default public float apply$mcF$sp() {
        return BoxesRunTime.unboxToFloat(this.apply());
    }

    public static /* synthetic */ int apply$mcI$sp$(Function0 $this) {
        return $this.apply$mcI$sp();
    }

    default public int apply$mcI$sp() {
        return BoxesRunTime.unboxToInt(this.apply());
    }

    public static /* synthetic */ long apply$mcJ$sp$(Function0 $this) {
        return $this.apply$mcJ$sp();
    }

    default public long apply$mcJ$sp() {
        return BoxesRunTime.unboxToLong(this.apply());
    }

    public static /* synthetic */ short apply$mcS$sp$(Function0 $this) {
        return $this.apply$mcS$sp();
    }

    default public short apply$mcS$sp() {
        return BoxesRunTime.unboxToShort(this.apply());
    }

    public static /* synthetic */ void apply$mcV$sp$(Function0 $this) {
        $this.apply$mcV$sp();
    }

    default public void apply$mcV$sp() {
        this.apply();
    }

    public static void $init$(Function0 $this) {
    }
}

