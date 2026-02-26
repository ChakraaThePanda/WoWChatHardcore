/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.None$;
import scala.Option;
import scala.Some;
import scala.Tuple2;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.InternalPositionImpl;
import scala.reflect.internal.util.Position;
import scala.reflect.internal.util.SourceFile;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001M4\u0011b\u0003\u0007\u0011\u0002\u0007\u0005A\u0002F\u0019\t\u000be\u0001A\u0011A\u000e\t\u000b}\u0001A\u0011\u0001\u0011\t\u000b=\u0002A\u0011\u0001\u0019\t\u000bi\u0002A\u0011A\u001e\t\u000b}\u0002A\u0011\u0001!\t\u000b=\u0003A\u0011\u0001)\t\u000be\u0003A\u0011\u0001.\t\u000b\r\u0004A\u0011\u00013\t\u000b-\u0004A\u0011A\u001e\t\u000b=\u0004A\u0011A\u001e\u0003%\u0011+\u0007O]3dCR,G\rU8tSRLwN\u001c\u0006\u0003\u001b9\tA!\u001e;jY*\u0011q\u0002E\u0001\tS:$XM\u001d8bY*\u0011\u0011CE\u0001\be\u00164G.Z2u\u0015\u0005\u0019\u0012!B:dC2\f7C\u0001\u0001\u0016!\t1r#D\u0001\u0013\u0013\tA\"C\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0004\u0001Q\tA\u0004\u0005\u0002\u0017;%\u0011aD\u0005\u0002\u0005+:LG/\u0001\u0004pM\u001a\u001cX\r^\u000b\u0002CA\u0019aC\t\u0013\n\u0005\r\u0012\"AB(qi&|g\u000e\u0005\u0002\u0017K%\u0011aE\u0005\u0002\u0004\u0013:$\b\u0006\u0002\u0002)W5\u0002\"AF\u0015\n\u0005)\u0012\"A\u00033faJ,7-\u0019;fI\u0006\nA&A\u0006vg\u0016\u0004\u0003\r]8j]R\u0004\u0017%\u0001\u0018\u0002\u000bIr\u0013H\f\u0019\u0002\u0019Q|7+\u001b8hY\u0016d\u0015N\\3\u0016\u0003E\u0002\"AM\u001a\u000e\u00031I!\u0001\u000e\u0007\u0003\u0011A{7/\u001b;j_:DCa\u0001\u00157q\u0005\nq'A\u0006vg\u0016\u0004\u0003MZ8dkN\u0004\u0017%A\u001d\u0002\rIr\u0013'\r\u00181\u0003!\u0019\u0018MZ3MS:,W#\u0001\u0013)\t\u0011AS\bO\u0011\u0002}\u0005QQo]3!A2Lg.\u001a1\u0002\u0013\u0011\u0014wm\u0015;sS:<W#A!\u0011\u0005\tKeBA\"H!\t!%#D\u0001F\u0015\t1%$\u0001\u0004=e>|GOP\u0005\u0003\u0011J\ta\u0001\u0015:fI\u00164\u0017B\u0001&L\u0005\u0019\u0019FO]5oO*\u0011\u0001J\u0005\u0015\u0005\u000b!j\u0005(I\u0001O\u0003=)8/\u001a\u0011ag\"|w\u000fR3ck\u001e\u0004\u0017\u0001E5o+2$\u0018.\\1uKN{WO]2f)\t\t\u0014\u000bC\u0003S\r\u0001\u00071+\u0001\u0004t_V\u00148-\u001a\t\u0003eQK!!\u0016\u0007\u0003\u0015M{WO]2f\r&dW\r\u000b\u0003\u0007Q]C\u0014%\u0001-\u0002'U\u001cX\r\t1gS:\fG\u000eU8tSRLwN\u001c1\u0002\u001b1Lg.Z,ji\"\u001c\u0015M]1u)\tYf\f\u0005\u0003\u00179\u0006\u000b\u0015BA/\u0013\u0005\u0019!V\u000f\u001d7fe!)ql\u0002a\u0001I\u0005AQ.\u0019=XS\u0012$\b\u000e\u000b\u0003\bQ\u0005D\u0014%\u00012\u0002\u001fU\u001cX\r\t1mS:,7)\u0019:fi\u0002\f!b^5uQN{WO]2f)\r\tTM\u001a\u0005\u0006%\"\u0001\ra\u0015\u0005\u0006O\"\u0001\r\u0001J\u0001\u0006g\"Lg\r\u001e\u0015\u0005\u0011!J\u0007(I\u0001k\u0003!*8/\u001a\u0011ao&$\bnU8ve\u000e,\u0007f]8ve\u000e,\u0017\u0006\u0019\u0011b]\u0012\u0004\u0003m^5uQNC\u0017N\u001a;a\u00031\u0019H/\u0019:u\u001fJ\u0004v.\u001b8uQ\u0011I\u0001&\u001c\u001d\"\u00039\f1#^:fA\u0001\u001cH/\u0019:uA\u0002Jgn\u001d;fC\u0012\f!\"\u001a8e\u001fJ\u0004v.\u001b8uQ\u0011Q\u0001&\u001d\u001d\"\u0003I\f\u0011#^:fA\u0001,g\u000e\u001a1!S:\u001cH/Z1e\u0001")
public interface DeprecatedPosition {
    public static /* synthetic */ Option offset$(DeprecatedPosition $this) {
        return $this.offset();
    }

    default public Option<Object> offset() {
        if (((Position)this).isDefined()) {
            return new Some<Object>(BoxesRunTime.boxToInteger(((Position)this).point()));
        }
        return None$.MODULE$;
    }

    public static /* synthetic */ Position toSingleLine$(DeprecatedPosition $this) {
        return $this.toSingleLine();
    }

    default public Position toSingleLine() {
        return (Position)this;
    }

    public static /* synthetic */ int safeLine$(DeprecatedPosition $this) {
        return $this.safeLine();
    }

    default public int safeLine() {
        return ((InternalPositionImpl)((Object)this)).line();
    }

    public static /* synthetic */ String dbgString$(DeprecatedPosition $this) {
        return $this.dbgString();
    }

    default public String dbgString() {
        return ((InternalPositionImpl)((Object)this)).showDebug();
    }

    public static /* synthetic */ Position inUltimateSource$(DeprecatedPosition $this, SourceFile source2) {
        return $this.inUltimateSource(source2);
    }

    default public Position inUltimateSource(SourceFile source2) {
        return source2.positionInUltimateSource((Position)this);
    }

    public static /* synthetic */ Tuple2 lineWithCarat$(DeprecatedPosition $this, int maxWidth) {
        return $this.lineWithCarat(maxWidth);
    }

    default public Tuple2<String, String> lineWithCarat(int maxWidth) {
        return new Tuple2<String, String>("", "");
    }

    public static /* synthetic */ Position withSource$(DeprecatedPosition $this, SourceFile source2, int shift) {
        return $this.withSource(source2, shift);
    }

    default public Position withSource(SourceFile source2, int shift) {
        return ((InternalPositionImpl)((Object)this)).withSource(source2).withShift(shift);
    }

    public static /* synthetic */ int startOrPoint$(DeprecatedPosition $this) {
        return $this.startOrPoint();
    }

    default public int startOrPoint() {
        if (((Position)this).isRange()) {
            return ((Position)this).start();
        }
        return ((Position)this).point();
    }

    public static /* synthetic */ int endOrPoint$(DeprecatedPosition $this) {
        return $this.endOrPoint();
    }

    default public int endOrPoint() {
        if (((Position)this).isRange()) {
            return ((Position)this).end();
        }
        return ((Position)this).point();
    }

    public static void $init$(DeprecatedPosition $this) {
    }
}

