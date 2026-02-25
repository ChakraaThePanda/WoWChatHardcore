/*
 * Decompiled with CFR 0.152.
 */
package scala.sys;

import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.sys.BooleanProp$;
import scala.sys.Prop;
import scala.sys.PropImpl;

@ScalaSignature(bytes="\u0006\u0001\u0005\rdaB\u0015+!\u0003\r\na\f\u0005\u0006w\u00011\t\u0001\u0010\u0005\u0006{\u00011\tA\u0010\u0005\u0006\u0005\u00021\tA\u0010\u0005\u0006\u0007\u00021\tAP\u0004\u0006\t*B\t!\u0012\u0004\u0006S)B\tA\u0012\u0005\u0006\u000f\u001a!\t\u0001\u0013\u0004\u0006\u0013\u001a\u0001!F\u0013\u0005\n\u001f\"\u0011\t\u0011)A\u0005!nC\u0001\u0002\u0018\u0005\u0003\u0002\u0003\u0006I!\u0018\u0005\u0006\u000f\"!\t\u0001\u0019\u0005\u0006K\"!\tE\u001a\u0005\u0006{!!\tA\u0010\u0005\u0006\u0005\"!\tA\u0010\u0005\u0006\u0007\"!\tA\u0010\u0004\u0006e\u001a\u0001!f\u001d\u0005\t\u001fB\u0011)\u0019!C\u0001i\"AQ\u000f\u0005B\u0001B\u0003%\u0001\u000b\u0003\u0005<!\t\u0015\r\u0011\"\u0001=\u0011!1\bC!A!\u0002\u0013A\u0004\"B$\u0011\t\u00039\bbB>\u0011\u0005\u0004%\t\u0001\u0010\u0005\u0007yB\u0001\u000b\u0011\u0002\u001d\t\u000bu\u0004B\u0011\u0001@\t\r\u0015\u0004B\u0011AA\b\u0011\u0019\tI\u0002\u0005C\u0001i\"I\u00111\u0004\tC\u0002\u0013\u0005\u0011Q\u0004\u0005\b\u0003?\u0001\u0002\u0015!\u0003@\u0011!i\u0004C1A\u0005\u0002\u0005u\u0001bBA\u0011!\u0001\u0006Ia\u0010\u0005\t\u0005B\u0011\r\u0011\"\u0001\u0002\u001e!9\u00111\u0005\t!\u0002\u0013y\u0004\u0002C\"\u0011\u0005\u0004%\t!!\b\t\u000f\u0005\u0015\u0002\u0003)A\u0005\u007f!9\u0011q\u0005\t\u0005\u0002\u0005%\u0002BBA\u0019!\u0011EA\bC\u0004\u00024\u0019!\t!!\u000e\t\u000f\u0005\u001dc\u0001\"\u0001\u0002J!9\u0011\u0011\u000b\u0004\u0005\u0002\u0005M\u0003bBA.\r\u0011\r\u0011Q\f\u0002\f\u0005>|G.Z1o!J|\u0007O\u0003\u0002,Y\u0005\u00191/_:\u000b\u00035\nQa]2bY\u0006\u001c\u0001aE\u0002\u0001aQ\u0002\"!\r\u001a\u000e\u00031J!a\r\u0017\u0003\r\u0005s\u0017PU3g!\r)d\u0007O\u0007\u0002U%\u0011qG\u000b\u0002\u0005!J|\u0007\u000f\u0005\u00022s%\u0011!\b\f\u0002\b\u0005>|G.Z1o\u0003\u00151\u0018\r\\;f+\u0005A\u0014AB3oC\ndW\rF\u0001@!\t\t\u0004)\u0003\u0002BY\t!QK\\5u\u0003\u001d!\u0017n]1cY\u0016\fa\u0001^8hO2,\u0017a\u0003\"p_2,\u0017M\u001c)s_B\u0004\"!\u000e\u0004\u0014\u0005\u0019\u0001\u0014A\u0002\u001fj]&$h\bF\u0001F\u0005=\u0011un\u001c7fC:\u0004&o\u001c9J[Bd7c\u0001\u0005L\u001dB\u0019Q\u0007\u0014\u001d\n\u00055S#\u0001\u0003)s_BLU\u000e\u001d7\u0011\u0005U\u0002\u0011aA6fsB\u0011\u0011\u000b\u0017\b\u0003%Z\u0003\"a\u0015\u0017\u000e\u0003QS!!\u0016\u0018\u0002\rq\u0012xn\u001c;?\u0013\t9F&\u0001\u0004Qe\u0016$WMZ\u0005\u00033j\u0013aa\u0015;sS:<'BA,-\u0013\tyE*A\u0004wC2,XM\u00128\u0011\tEr\u0006\u000bO\u0005\u0003?2\u0012\u0011BR;oGRLwN\\\u0019\u0015\u0007\u0005\u001cG\r\u0005\u0002c\u00115\ta\u0001C\u0003P\u0017\u0001\u0007\u0001\u000bC\u0003]\u0017\u0001\u0007Q,\u0001\u0005tKR4\u0016\r\\;f+\t9G\u000e\u0006\u00029Q\")\u0011\u000e\u0004a\u0001U\u0006Aa.Z<WC2,X\r\u0005\u0002lY2\u0001A!B7\r\u0005\u0004q'A\u0001+2#\tAt\u000e\u0005\u00022a&\u0011\u0011\u000f\f\u0002\u0004\u0003:L(\u0001D\"p]N$\u0018M\u001c;J[Bd7c\u0001\t1\u001dV\t\u0001+\u0001\u0003lKf\u0004\u0013A\u0002<bYV,\u0007\u0005F\u0002ysj\u0004\"A\u0019\t\t\u000b=+\u0002\u0019\u0001)\t\u000bm*\u0002\u0019\u0001\u001d\u0002\u000b%\u001c8+\u001a;\u0002\r%\u001c8+\u001a;!\u0003\r\u0019X\r\u001e\u000b\u0004\u007f\u00065\u0001\u0003BA\u0001\u0003\u0017i!!a\u0001\u000b\t\u0005\u0015\u0011qA\u0001\u0005Y\u0006twM\u0003\u0002\u0002\n\u0005!!.\u0019<b\u0013\rI\u00161\u0001\u0005\u0006Sb\u0001\r\u0001U\u000b\u0005\u0003#\t9\u0002F\u00029\u0003'Aa![\rA\u0002\u0005U\u0001cA6\u0002\u0018\u0011)Q.\u0007b\u0001]\u0006\u0019q-\u001a;\u0002\u000b\rdW-\u0019:\u0016\u0003}\naa\u00197fCJ\u0004\u0013aB3oC\ndW\rI\u0001\tI&\u001c\u0018M\u00197fA\u00059Ao\\4hY\u0016\u0004\u0013AB8qi&|g.\u0006\u0002\u0002,A!\u0011'!\f9\u0013\r\ty\u0003\f\u0002\u0007\u001fB$\u0018n\u001c8\u0002\ti,'o\\\u0001\fm\u0006dW/Z%t)J,X-\u0006\u0003\u00028\u0005mBc\u0001(\u0002:!)q*\na\u0001!\u00129\u0011QH\u0013C\u0002\u0005}\"!\u0001+\u0012\u0007\u0005\u0005s\u000eE\u00022\u0003\u0007J1!!\u0012-\u0005\u001dqu\u000e\u001e5j]\u001e\f\u0011b[3z\u000bbL7\u000f^:\u0016\t\u0005-\u0013q\n\u000b\u0004\u001d\u00065\u0003\"B('\u0001\u0004\u0001FaBA\u001fM\t\u0007\u0011qH\u0001\tG>t7\u000f^1oiR)a*!\u0016\u0002X!)qj\na\u0001!\"1\u0011\u0011L\u0014A\u0002a\nA![:P]\u0006!\"m\\8mK\u0006t\u0007K]8q\u0003N\u0014un\u001c7fC:$2\u0001OA0\u0011\u0019\t\t\u0007\u000ba\u0001\u001d\u0006\t!\r")
public interface BooleanProp
extends Prop<Object> {
    public static boolean booleanPropAsBoolean(BooleanProp booleanProp) {
        return BooleanProp$.MODULE$.booleanPropAsBoolean(booleanProp);
    }

    public static BooleanProp constant(String string, boolean bl) {
        return BooleanProp$.MODULE$.constant(string, bl);
    }

    public static <T> BooleanProp keyExists(String string) {
        return BooleanProp$.MODULE$.keyExists(string);
    }

    public static <T> BooleanProp valueIsTrue(String string) {
        return BooleanProp$.MODULE$.valueIsTrue(string);
    }

    @Override
    public boolean value();

    public void enable();

    public void disable();

    public void toggle();

    public static class BooleanPropImpl
    extends PropImpl<Object>
    implements BooleanProp {
        /*
         * WARNING - void declaration
         */
        @Override
        public <T1> boolean setValue(T1 newValue) {
            boolean bl;
            if (newValue instanceof Boolean && !BoxesRunTime.unboxToBoolean(newValue)) {
                void var3_2;
                boolean old = BoxesRunTime.unboxToBoolean(this.value());
                this.clear();
                bl = var3_2;
            } else {
                bl = BoxesRunTime.unboxToBoolean(super.setValue(newValue));
            }
            return bl;
        }

        @Override
        public void enable() {
            this.setValue((T1)BoxesRunTime.boxToBoolean(true));
        }

        @Override
        public void disable() {
            this.clear();
        }

        @Override
        public void toggle() {
            if (BoxesRunTime.unboxToBoolean(this.value())) {
                this.disable();
                return;
            }
            this.enable();
        }

        public BooleanPropImpl(String key, Function1<String, Object> valueFn) {
            super(key, valueFn);
        }
    }

    public static class ConstantImpl
    implements BooleanProp {
        private final String key;
        private final boolean value;
        private final boolean isSet;
        private final BoxedUnit clear;
        private final BoxedUnit enable;
        private final BoxedUnit disable;
        private final BoxedUnit toggle;

        @Override
        public String key() {
            return this.key;
        }

        @Override
        public boolean value() {
            return this.value;
        }

        @Override
        public boolean isSet() {
            return this.isSet;
        }

        @Override
        public String set(String newValue) {
            return String.valueOf(BoxesRunTime.boxToBoolean(this.value()));
        }

        @Override
        public <T1> boolean setValue(T1 newValue) {
            return this.value();
        }

        @Override
        public String get() {
            return String.valueOf(BoxesRunTime.boxToBoolean(this.value()));
        }

        @Override
        public void clear() {
        }

        @Override
        public void enable() {
        }

        @Override
        public void disable() {
        }

        @Override
        public void toggle() {
        }

        @Override
        public Option<Object> option() {
            if (this.isSet()) {
                return new Some<Object>(BoxesRunTime.boxToBoolean(this.value()));
            }
            return None$.MODULE$;
        }

        @Override
        public boolean zero() {
            return false;
        }

        public ConstantImpl(String key, boolean value) {
            this.key = key;
            this.value = value;
            this.isSet = value;
            this.clear = BoxedUnit.UNIT;
            this.enable = BoxedUnit.UNIT;
            this.disable = BoxedUnit.UNIT;
            this.toggle = BoxedUnit.UNIT;
        }
    }
}

