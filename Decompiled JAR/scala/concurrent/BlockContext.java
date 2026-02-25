/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent;

import scala.Function0;
import scala.concurrent.BlockContext$;
import scala.concurrent.CanAwait;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00014qAD\b\u0011\u0002G\u0005A\u0003C\u0003\u001a\u0001\u0019\u0005!dB\u00034\u001f!\u0005AGB\u0003\u000f\u001f!\u0005Q\u0007C\u00037\u0007\u0011\u0005qgB\u00039\u0007!%\u0011HB\u0003<\u0007!%A\bC\u00037\r\u0011\u0005a\bC\u0003\u001a\r\u0011\u0005s\bC\u0003H\u0007\u0011\u0005\u0001\nC\u0004J\u0007\t\u0007I\u0011\u0002&\t\rM\u001b\u0001\u0015!\u0003L\u0011\u0015!6\u0001\"\u0001I\u0011\u0015)6\u0001\"\u0001W\u00051\u0011En\\2l\u0007>tG/\u001a=u\u0015\t\u0001\u0012#\u0001\u0006d_:\u001cWO\u001d:f]RT\u0011AE\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001Q\u0003\u0005\u0002\u0017/5\t\u0011#\u0003\u0002\u0019#\t1\u0011I\\=SK\u001a\fqA\u00197pG.|e.\u0006\u0002\u001c?Q\u0011AD\f\u000b\u0003;!\u0002\"AH\u0010\r\u0001\u0011)\u0001%\u0001b\u0001C\t\tA+\u0005\u0002#KA\u0011acI\u0005\u0003IE\u0011qAT8uQ&tw\r\u0005\u0002\u0017M%\u0011q%\u0005\u0002\u0004\u0003:L\b\"B\u0015\u0002\u0001\bQ\u0013A\u00039fe6L7o]5p]B\u00111\u0006L\u0007\u0002\u001f%\u0011Qf\u0004\u0002\t\u0007\u0006t\u0017i^1ji\"1q&\u0001CA\u0002A\nQ\u0001\u001e5v].\u00042AF\u0019\u001e\u0013\t\u0011\u0014C\u0001\u0005=Eft\u0017-\\3?\u00031\u0011En\\2l\u0007>tG/\u001a=u!\tY3a\u0005\u0002\u0004+\u00051A(\u001b8jiz\"\u0012\u0001N\u0001\u0014\t\u00164\u0017-\u001e7u\u00052|7m[\"p]R,\u0007\u0010\u001e\t\u0003u\u0019i\u0011a\u0001\u0002\u0014\t\u00164\u0017-\u001e7u\u00052|7m[\"p]R,\u0007\u0010^\n\u0004\rUi\u0004CA\u0016\u0001)\u0005ITC\u0001!D)\t\tU\t\u0006\u0002C\tB\u0011ad\u0011\u0003\u0006A!\u0011\r!\t\u0005\u0006S!\u0001\u001dA\u000b\u0005\u0007_!!\t\u0019\u0001$\u0011\u0007Y\t$)A\neK\u001a\fW\u000f\u001c;CY>\u001c7nQ8oi\u0016DH/F\u0001>\u00031\u0019wN\u001c;fqRdunY1m+\u0005Y\u0005c\u0001'R{5\tQJ\u0003\u0002O\u001f\u0006!A.\u00198h\u0015\u0005\u0001\u0016\u0001\u00026bm\u0006L!AU'\u0003\u0017QC'/Z1e\u0019>\u001c\u0017\r\\\u0001\u000eG>tG/\u001a=u\u0019>\u001c\u0017\r\u001c\u0011\u0002\u000f\r,(O]3oi\u0006\u0001r/\u001b;i\u00052|7m[\"p]R,\u0007\u0010^\u000b\u0003/j#\"\u0001\u00170\u0015\u0005e[\u0006C\u0001\u0010[\t\u0015\u0001SB1\u0001\"\u0011\u0019aV\u0002\"a\u0001;\u0006!!m\u001c3z!\r1\u0012'\u0017\u0005\u0006?6\u0001\r!P\u0001\rE2|7m[\"p]R,\u0007\u0010\u001e")
public interface BlockContext {
    public static <T> T withBlockContext(BlockContext blockContext, Function0<T> function0) {
        return BlockContext$.MODULE$.withBlockContext(blockContext, function0);
    }

    public static BlockContext current() {
        return BlockContext$.MODULE$.current();
    }

    public static BlockContext defaultBlockContext() {
        return BlockContext$.MODULE$.defaultBlockContext();
    }

    public <T> T blockOn(Function0<T> var1, CanAwait var2);
}

