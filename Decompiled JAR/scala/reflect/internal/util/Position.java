/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Option;
import scala.Tuple2;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.util.DeprecatedPosition;
import scala.reflect.internal.util.InternalPositionImpl;
import scala.reflect.internal.util.NoSourceFile$;
import scala.reflect.internal.util.Position$;
import scala.reflect.internal.util.SourceFile;
import scala.reflect.macros.Attachments;
import scala.reflect.macros.EmptyAttachments;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0005-b\u0001\u0002\f\u0018\u0001\u0001BQa\r\u0001\u0005\u0002Q*AA\u000e\u0001\u0001k!)q\u0007\u0001C\u0001q!)\u0011\b\u0001C\u0001u!)a\t\u0001C\t\u000f\")\u0011\f\u0001C\u00015\")a\f\u0001C\u00015\")q\f\u0001C\u0001A\")A\r\u0001C\u0001K\")\u0011\u000e\u0001C\u0001K\")!\u000e\u0001C\u0001K\u001e)1n\u0006E\u0001Y\u001a)ac\u0006E\u0001[\")1'\u0004C\u0001c\"9!/\u0004b\u0001\n\u0003)\u0007BB:\u000eA\u0003%a\rC\u0003u\u001b\u0011%Q\u000fC\u0003~\u001b\u0011\u0005a\u0010C\u0004\u0002\f5!\t!!\u0004\t\u000f\u0005MQ\u0002\"\u0001\u0002\u0016!9\u0011qD\u0007\u0005\u0002\u0005\u0005\"\u0001\u0003)pg&$\u0018n\u001c8\u000b\u0005aI\u0012\u0001B;uS2T!AG\u000e\u0002\u0011%tG/\u001a:oC2T!\u0001H\u000f\u0002\u000fI,g\r\\3di*\ta$A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u000b\u0001\ts\u0005\f\u0019\u0011\u0005\t*S\"A\u0012\u000b\u0005\u0011Z\u0012AB7bGJ|7/\u0003\u0002'G\t\u0001R)\u001c9us\u0006#H/Y2i[\u0016tGo\u001d\t\u0003Q-j\u0011!\u000b\u0006\u0003Um\t1!\u00199j\u0013\t1\u0012\u0006\u0005\u0002.]5\tq#\u0003\u00020/\t!\u0012J\u001c;fe:\fG\u000eU8tSRLwN\\%na2\u0004\"!L\u0019\n\u0005I:\"A\u0005#faJ,7-\u0019;fIB{7/\u001b;j_:\fa\u0001P5oSRtD#A\u001b\u0011\u00055\u0002!a\u0001)pg\u0006\u0019\u0001o\\:\u0016\u0003U\nqa^5uQB{7\u000f\u0006\u0002<\tJ\u0011AH\u0010\u0004\u0005{\u0001\u00011H\u0001\u0007=e\u00164\u0017N\\3nK:$h\b\u0005\u0002#\u007f%\u0011\u0001i\t\u0002\f\u0003R$\u0018m\u00195nK:$8/\u0002\u00037y\u0001\u0012\u0005CA\"\u0003\u001b\u0005\u0001\u0001\"B#\u0005\u0001\u0004)\u0014A\u00028foB{7/\u0001\u0003gC&dGC\u0001%M!\tI%*D\u0001\u001e\u0013\tYUDA\u0004O_RD\u0017N\\4\t\u000b5+\u0001\u0019\u0001(\u0002\t]D\u0017\r\u001e\t\u0003\u001fZs!\u0001\u0015+\u0011\u0005EkR\"\u0001*\u000b\u0005M{\u0012A\u0002\u001fs_>$h(\u0003\u0002V;\u00051\u0001K]3eK\u001aL!a\u0016-\u0003\rM#(/\u001b8h\u0015\t)V$A\u0005jg\u0012+g-\u001b8fIV\t1\f\u0005\u0002J9&\u0011Q,\b\u0002\b\u0005>|G.Z1o\u0003\u001dI7OU1oO\u0016\faa]8ve\u000e,W#A1\u0011\u00055\u0012\u0017BA2\u0018\u0005)\u0019v.\u001e:dK\u001aKG.Z\u0001\u0006gR\f'\u000f^\u000b\u0002MB\u0011\u0011jZ\u0005\u0003Qv\u00111!\u00138u\u0003\u0015\u0001x.\u001b8u\u0003\r)g\u000eZ\u0001\t!>\u001c\u0018\u000e^5p]B\u0011Q&D\n\u0003\u001b9\u0004\"!S8\n\u0005Al\"AB!osJ+g\rF\u0001m\u0003\u0019!\u0018MY%oG\u00069A/\u00192J]\u000e\u0004\u0013\u0001\u0003<bY&$\u0017\r^3\u0016\u0005YLHCA<}!\tA\u0018\u0010\u0004\u0001\u0005\u000bi\f\"\u0019A>\u0003\u0003Q\u000b\"\u0001S\u001b\t\u000b]\n\u0002\u0019A<\u0002\u001b\u0019|'/\\1u\u001b\u0016\u001c8/Y4f)\u0019qu0a\u0001\u0002\b!1\u0011\u0011\u0001\nA\u0002U\nQ\u0001]8t\u0013:Da!!\u0002\u0013\u0001\u0004q\u0015aA7tO\"1\u0011\u0011\u0002\nA\u0002m\u000b1b\u001d5peR,gNR5mK\u00061qN\u001a4tKR$R!NA\b\u0003#AQaX\nA\u0002\u0005DQ![\nA\u0002\u0019\fQA]1oO\u0016$\u0012\"NA\f\u00033\tY\"!\b\t\u000b}#\u0002\u0019A1\t\u000b\u0011$\u0002\u0019\u00014\t\u000b%$\u0002\u0019\u00014\t\u000b)$\u0002\u0019\u00014\u0002\u0017Q\u0014\u0018M\\:qCJ,g\u000e\u001e\u000b\nk\u0005\r\u0012QEA\u0014\u0003SAQaX\u000bA\u0002\u0005DQ\u0001Z\u000bA\u0002\u0019DQ![\u000bA\u0002\u0019DQA[\u000bA\u0002\u0019\u0004")
public class Position
extends EmptyAttachments
implements scala.reflect.api.Position,
InternalPositionImpl,
DeprecatedPosition {
    public static Position transparent(SourceFile sourceFile, int n, int n2, int n3) {
        return Position$.MODULE$.transparent(sourceFile, n, n2, n3);
    }

    public static Position range(SourceFile sourceFile, int n, int n2, int n3) {
        return Position$.MODULE$.range(sourceFile, n, n2, n3);
    }

    public static String formatMessage(Position position, String string, boolean bl) {
        return Position$.MODULE$.formatMessage(position, string, bl);
    }

    public static int tabInc() {
        return Position$.MODULE$.tabInc();
    }

    @Override
    public Option<Object> offset() {
        return DeprecatedPosition.offset$(this);
    }

    @Override
    public Position toSingleLine() {
        return DeprecatedPosition.toSingleLine$(this);
    }

    @Override
    public int safeLine() {
        return DeprecatedPosition.safeLine$(this);
    }

    @Override
    public String dbgString() {
        return DeprecatedPosition.dbgString$(this);
    }

    @Override
    public Position inUltimateSource(SourceFile source2) {
        return DeprecatedPosition.inUltimateSource$(this, source2);
    }

    @Override
    public Tuple2<String, String> lineWithCarat(int maxWidth) {
        return DeprecatedPosition.lineWithCarat$(this, maxWidth);
    }

    @Override
    public Position withSource(SourceFile source2, int shift) {
        return DeprecatedPosition.withSource$(this, source2, shift);
    }

    @Override
    public int startOrPoint() {
        return DeprecatedPosition.startOrPoint$(this);
    }

    @Override
    public int endOrPoint() {
        return DeprecatedPosition.endOrPoint$(this);
    }

    @Override
    public Position finalPosition() {
        return InternalPositionImpl.finalPosition$(this);
    }

    @Override
    public boolean isTransparent() {
        return InternalPositionImpl.isTransparent$(this);
    }

    @Override
    public boolean isOffset() {
        return InternalPositionImpl.isOffset$(this);
    }

    @Override
    public boolean isOpaqueRange() {
        return InternalPositionImpl.isOpaqueRange$(this);
    }

    @Override
    public int pointOrElse(int alt) {
        return InternalPositionImpl.pointOrElse$(this, alt);
    }

    @Override
    public Position makeTransparent() {
        return InternalPositionImpl.makeTransparent$(this);
    }

    @Override
    public Position withStart(int start) {
        return InternalPositionImpl.withStart$(this, start);
    }

    @Override
    public Position withPoint(int point) {
        return InternalPositionImpl.withPoint$(this, point);
    }

    @Override
    public Position withEnd(int end) {
        return InternalPositionImpl.withEnd$(this, end);
    }

    @Override
    public Position withSource(SourceFile source2) {
        return InternalPositionImpl.withSource$(this, source2);
    }

    @Override
    public Position withShift(int shift) {
        return InternalPositionImpl.withShift$(this, shift);
    }

    @Override
    public Position focusStart() {
        return InternalPositionImpl.focusStart$(this);
    }

    @Override
    public Position focus() {
        return InternalPositionImpl.focus$(this);
    }

    @Override
    public Position focusEnd() {
        return InternalPositionImpl.focusEnd$(this);
    }

    @Override
    public Position $bar(Position that, Seq<Position> poses) {
        return InternalPositionImpl.$bar$(this, that, poses);
    }

    @Override
    public Position $bar(Position that) {
        return InternalPositionImpl.$bar$(this, that);
    }

    @Override
    public Position $up(int point) {
        return InternalPositionImpl.$up$(this, point);
    }

    @Override
    public Position $bar$up(Position that) {
        return InternalPositionImpl.$bar$up$(this, that);
    }

    @Override
    public Position $up$bar(Position that) {
        return InternalPositionImpl.$up$bar$(this, that);
    }

    @Override
    public Position union(Position pos) {
        return InternalPositionImpl.union$(this, pos);
    }

    @Override
    public boolean includes(Position pos) {
        return InternalPositionImpl.includes$(this, pos);
    }

    @Override
    public boolean properlyIncludes(Position pos) {
        return InternalPositionImpl.properlyIncludes$(this, pos);
    }

    @Override
    public boolean precedes(Position pos) {
        return InternalPositionImpl.precedes$(this, pos);
    }

    @Override
    public boolean properlyPrecedes(Position pos) {
        return InternalPositionImpl.properlyPrecedes$(this, pos);
    }

    @Override
    public boolean sameRange(Position pos) {
        return InternalPositionImpl.sameRange$(this, pos);
    }

    @Override
    public boolean overlaps(Position pos) {
        return InternalPositionImpl.overlaps$(this, pos);
    }

    @Override
    public int line() {
        return InternalPositionImpl.line$(this);
    }

    @Override
    public int column() {
        return InternalPositionImpl.column$(this);
    }

    @Override
    public String lineContent() {
        return InternalPositionImpl.lineContent$(this);
    }

    @Override
    public String lineCaret() {
        return InternalPositionImpl.lineCaret$(this);
    }

    @Override
    public String lineCarat() {
        return InternalPositionImpl.lineCarat$(this);
    }

    @Override
    public String showError(String msg) {
        return InternalPositionImpl.showError$(this, msg);
    }

    @Override
    public String showDebug() {
        return InternalPositionImpl.showDebug$(this);
    }

    @Override
    public String show() {
        return InternalPositionImpl.show$(this);
    }

    @Override
    public boolean samePointAs(Position that) {
        return InternalPositionImpl.samePointAs$(this, that);
    }

    @Override
    public Position pos() {
        return this;
    }

    public Attachments withPos(Position newPos) {
        return newPos;
    }

    public Nothing$ fail(String what) {
        throw new UnsupportedOperationException(new StringBuilder(13).append("Position.").append(what).append(" on ").append(this).toString());
    }

    @Override
    public boolean isDefined() {
        return false;
    }

    @Override
    public boolean isRange() {
        return false;
    }

    @Override
    public SourceFile source() {
        return NoSourceFile$.MODULE$;
    }

    @Override
    public int start() {
        throw this.fail("start");
    }

    @Override
    public int point() {
        throw this.fail("point");
    }

    @Override
    public int end() {
        throw this.fail("end");
    }

    public Position() {
        InternalPositionImpl.$init$(this);
        DeprecatedPosition.$init$(this);
    }
}

