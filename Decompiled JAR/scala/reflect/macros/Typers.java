/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Position;
import scala.reflect.api.Trees;
import scala.reflect.api.Types;
import scala.reflect.macros.Enclosures;
import scala.reflect.macros.TypecheckException$;
import scala.reflect.macros.blackbox.Context;

@ScalaSignature(bytes="\u0006\u0001\u0005\u001de\u0001\u0003\u0010 !\u0003\r\tAJ\u001d\t\u000b-\u0002A\u0011\u0001\u0017\t\u000bA\u0002a\u0011A\u0019\u0005\u000b}\u0002!\u0011\u0001!\t\u000f\u001d\u0003!\u0019!D\u0001\u0011\"91\n\u0001b\u0001\u000e\u0003A\u0005b\u0002'\u0001\u0005\u00045\t\u0001S\u0003\u0005\u001b\u0002\u0001a\nC\u0004R\u0001\t\u0007I\u0011\u0001*\t\u000by\u0003A\u0011A0\t\u000fu\u0004\u0011\u0013!C\u0001}\"I\u00111\u0003\u0001\u0012\u0002\u0013\u0005\u0011Q\u0003\u0005\n\u00033\u0001\u0011\u0013!C\u0001\u0003+A\u0011\"a\u0007\u0001#\u0003%\t!!\u0006\t\u000f\u0005u\u0001A\"\u0001\u0002 !I\u0011q\u0006\u0001\u0012\u0002\u0013\u0005\u0011\u0011\u0007\u0005\t\u0003k\u0001\u0011\u0013!C\u0001}\"I\u0011q\u0007\u0001\u0012\u0002\u0013\u0005\u0011Q\u0003\u0005\n\u0003s\u0001\u0011\u0013!C\u0001\u0003+A\u0011\"a\u000f\u0001#\u0003%\t!!\u0006\t\u000f\u0005u\u0002A\"\u0001\u0002@!I\u0011\u0011\u000b\u0001\u0012\u0002\u0013\u0005\u0011Q\u0003\u0005\n\u0003'\u0002\u0011\u0013!C\u0001\u0003+A\u0011\"!\u0016\u0001#\u0003%\t!a\u0016\t\u000f\u0005m\u0003A\"\u0001\u0002^!I\u0011q\u000e\u0001\u0012\u0002\u0013\u0005\u0011Q\u0003\u0005\n\u0003c\u0002\u0011\u0013!C\u0001\u0003+A\u0011\"a\u001d\u0001#\u0003%\t!a\u0016\t\u000f\u0005U\u0004A\"\u0001\u0002x!9\u0011\u0011\u0011\u0001\u0007\u0002\u0005\r%A\u0002+za\u0016\u00148O\u0003\u0002!C\u00051Q.Y2s_NT!AI\u0012\u0002\u000fI,g\r\\3di*\tA%A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u00019\u0003C\u0001\u0015*\u001b\u0005\u0019\u0013B\u0001\u0016$\u0005\u0019\te.\u001f*fM\u00061A%\u001b8ji\u0012\"\u0012!\f\t\u0003Q9J!aL\u0012\u0003\tUs\u0017\u000e^\u0001\u000b_B,g.T1de>\u001cX#\u0001\u001a\u0011\u0007M2\u0014H\u0004\u0002)i%\u0011QgI\u0001\ba\u0006\u001c7.Y4f\u0013\t9\u0004H\u0001\u0003MSN$(BA\u001b$!\tQT(D\u0001<\u0015\tat$\u0001\u0005cY\u0006\u001c7NY8y\u0013\tq4HA\u0004D_:$X\r\u001f;\u0003\u001bQK\b/Z2iK\u000e\\Wj\u001c3f#\t\tE\t\u0005\u0002)\u0005&\u00111i\t\u0002\b\u001d>$\b.\u001b8h!\tAS)\u0003\u0002GG\t\u0019\u0011I\\=\u0002\u0011Q+%+T7pI\u0016,\u0012!\u0013\t\u0003\u0015\u000ei\u0011\u0001A\u0001\t)f\u0003V)\\8eK\u0006Y\u0001+\u0011+U\u000bJsUn\u001c3f\u0005I!\u0016\u0010]3dQ\u0016\u001c7.\u0012=dKB$\u0018n\u001c8\u0011\u0005=\u0003V\"A\u0010\n\u00055{\u0012A\u0005+za\u0016\u001c\u0007.Z2l\u000bb\u001cW\r\u001d;j_:,\u0012a\u0015\b\u0003)vs!!\u0016/\u000f\u0005Y[fBA,[\u001b\u0005A&BA-&\u0003\u0019a$o\\8u}%\tA%\u0003\u0002#G%\u0011\u0001%I\u0005\u0003#~\t\u0011\u0002^=qK\u000eCWmY6\u0015\r\u0001,w\r\\9t!\tQ\u0015-\u0003\u0002cG\n!AK]3f\u0013\t!wDA\u0004BY&\f7/Z:\t\u000b\u0019L\u0001\u0019\u00011\u0002\tQ\u0014X-\u001a\u0005\bQ&\u0001\n\u00111\u0001j\u0003\t\u0001H\u000f\u0005\u0002KU&\u00111n\u0019\u0002\u0005)f\u0004X\rC\u0004n\u0013A\u0005\t\u0019\u00018\u0002\rMLG.\u001a8u!\tAs.\u0003\u0002qG\t9!i\\8mK\u0006t\u0007b\u0002:\n!\u0003\u0005\rA\\\u0001\u001ao&$\b.S7qY&\u001c\u0017\u000e\u001e,jK^\u001cH)[:bE2,G\rC\u0004u\u0013A\u0005\t\u0019\u00018\u0002%]LG\u000f['bGJ|7\u000fR5tC\ndW\r\u001a\u0015\u0005\u0013YL8\u0010\u0005\u0002)o&\u0011\u0001p\t\u0002\u000bI\u0016\u0004(/Z2bi\u0016$\u0017%\u0001>\u00023U\u001cX\r\t1d]QL\b/Z2iK\u000e\\\u0007\rI5ogR,\u0017\rZ\u0011\u0002y\u00061!GL\u00192]A\n1\u0003^=qK\u000eCWmY6%I\u00164\u0017-\u001e7uII*\u0012a \u0016\u0004S\u0006\u00051FAA\u0002!\u0011\t)!a\u0004\u000e\u0005\u0005\u001d!\u0002BA\u0005\u0003\u0017\t\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0007\u000551%\u0001\u0006b]:|G/\u0019;j_:LA!!\u0005\u0002\b\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002'QL\b/Z\"iK\u000e\\G\u0005Z3gCVdG\u000fJ\u001a\u0016\u0005\u0005]!f\u00018\u0002\u0002\u0005\u0019B/\u001f9f\u0007\",7m\u001b\u0013eK\u001a\fW\u000f\u001c;%i\u0005\u0019B/\u001f9f\u0007\",7m\u001b\u0013eK\u001a\fW\u000f\u001c;%k\u0005IA/\u001f9fG\",7m\u001b\u000b\u000eA\u0006\u0005\u00121EA\u0014\u0003S\tY#!\f\t\u000b\u0019t\u0001\u0019\u00011\t\u0011\u0005\u0015b\u0002%AA\u0002%\u000bA!\\8eK\"9\u0001N\u0004I\u0001\u0002\u0004I\u0007bB7\u000f!\u0003\u0005\rA\u001c\u0005\be:\u0001\n\u00111\u0001o\u0011\u001d!h\u0002%AA\u00029\f1\u0003^=qK\u000eDWmY6%I\u00164\u0017-\u001e7uII*\"!a\r+\u0007%\u000b\t!A\nusB,7\r[3dW\u0012\"WMZ1vYR$3'A\nusB,7\r[3dW\u0012\"WMZ1vYR$C'A\nusB,7\r[3dW\u0012\"WMZ1vYR$S'A\nusB,7\r[3dW\u0012\"WMZ1vYR$c'\u0001\nj]\u001a,'/S7qY&\u001c\u0017\u000e\u001e,bYV,G#\u00031\u0002B\u0005\r\u0013QIA$\u0011\u0015AG\u00031\u0001j\u0011\u001diG\u0003%AA\u00029Dq\u0001\u001e\u000b\u0011\u0002\u0003\u0007a\u000eC\u0005\u0002JQ\u0001\n\u00111\u0001\u0002L\u0005\u0019\u0001o\\:\u0011\u0007)\u000bi%C\u0002\u0002P\r\u0014\u0001\u0002U8tSRLwN\\\u0001\u001dS:4WM]%na2L7-\u001b;WC2,X\r\n3fM\u0006,H\u000e\u001e\u00133\u0003qIgNZ3s\u00136\u0004H.[2jiZ\u000bG.^3%I\u00164\u0017-\u001e7uIM\nA$\u001b8gKJLU\u000e\u001d7jG&$h+\u00197vK\u0012\"WMZ1vYR$C'\u0006\u0002\u0002Z)\"\u00111JA\u0001\u0003EIgNZ3s\u00136\u0004H.[2jiZKWm\u001e\u000b\u000eA\u0006}\u0013\u0011MA3\u0003S\nY'!\u001c\t\u000b\u0019D\u0002\u0019\u00011\t\r\u0005\r\u0004\u00041\u0001j\u0003\u00111'o\\7\t\r\u0005\u001d\u0004\u00041\u0001j\u0003\t!x\u000eC\u0004n1A\u0005\t\u0019\u00018\t\u000fQD\u0002\u0013!a\u0001]\"I\u0011\u0011\n\r\u0011\u0002\u0003\u0007\u00111J\u0001\u001cS:4WM]%na2L7-\u001b;WS\u0016<H\u0005Z3gCVdG\u000f\n\u001b\u00027%tg-\u001a:J[Bd\u0017nY5u-&,w\u000f\n3fM\u0006,H\u000e\u001e\u00136\u0003mIgNZ3s\u00136\u0004H.[2jiZKWm\u001e\u0013eK\u001a\fW\u000f\u001c;%m\u0005y!/Z:fi2{7-\u00197BiR\u00148\u000fF\u0002a\u0003sBQA\u001a\u000fA\u0002\u0001DS\u0001\b<\u0002~m\f#!a \u00027U\u001cX\r\t1d]UtG/\u001f9fG\",7m\u001b1!S:\u001cH/Z1e\u0003-)h\u000e^=qK\u000eDWmY6\u0015\u0007\u0001\f)\tC\u0003g;\u0001\u0007\u0001\r")
public interface Typers {
    public void scala$reflect$macros$Typers$_setter_$TypecheckException_$eq(TypecheckException$ var1);

    public List<Context> openMacros();

    public Object TERMmode();

    public Object TYPEmode();

    public Object PATTERNmode();

    public TypecheckException$ TypecheckException();

    public static /* synthetic */ Trees.TreeApi typeCheck$(Typers $this, Trees.TreeApi tree, Types.TypeApi pt, boolean silent, boolean withImplicitViewsDisabled, boolean withMacrosDisabled) {
        return $this.typeCheck(tree, pt, silent, withImplicitViewsDisabled, withMacrosDisabled);
    }

    default public Trees.TreeApi typeCheck(Trees.TreeApi tree, Types.TypeApi pt, boolean silent, boolean withImplicitViewsDisabled, boolean withMacrosDisabled) {
        return this.typecheck(tree, this.TERMmode(), pt, silent, withImplicitViewsDisabled, withMacrosDisabled);
    }

    public static /* synthetic */ Types.TypeApi typeCheck$default$2$(Typers $this) {
        return $this.typeCheck$default$2();
    }

    default public Types.TypeApi typeCheck$default$2() {
        return ((Context)this).universe().WildcardType();
    }

    public static /* synthetic */ boolean typeCheck$default$3$(Typers $this) {
        return $this.typeCheck$default$3();
    }

    default public boolean typeCheck$default$3() {
        return false;
    }

    public static /* synthetic */ boolean typeCheck$default$4$(Typers $this) {
        return $this.typeCheck$default$4();
    }

    default public boolean typeCheck$default$4() {
        return false;
    }

    public static /* synthetic */ boolean typeCheck$default$5$(Typers $this) {
        return $this.typeCheck$default$5();
    }

    default public boolean typeCheck$default$5() {
        return false;
    }

    public Trees.TreeApi typecheck(Trees.TreeApi var1, Object var2, Types.TypeApi var3, boolean var4, boolean var5, boolean var6);

    public static /* synthetic */ Object typecheck$default$2$(Typers $this) {
        return $this.typecheck$default$2();
    }

    default public Object typecheck$default$2() {
        return this.TERMmode();
    }

    public static /* synthetic */ Types.TypeApi typecheck$default$3$(Typers $this) {
        return $this.typecheck$default$3();
    }

    default public Types.TypeApi typecheck$default$3() {
        return ((Context)this).universe().WildcardType();
    }

    public static /* synthetic */ boolean typecheck$default$4$(Typers $this) {
        return $this.typecheck$default$4();
    }

    default public boolean typecheck$default$4() {
        return false;
    }

    public static /* synthetic */ boolean typecheck$default$5$(Typers $this) {
        return $this.typecheck$default$5();
    }

    default public boolean typecheck$default$5() {
        return false;
    }

    public static /* synthetic */ boolean typecheck$default$6$(Typers $this) {
        return $this.typecheck$default$6();
    }

    default public boolean typecheck$default$6() {
        return false;
    }

    public Trees.TreeApi inferImplicitValue(Types.TypeApi var1, boolean var2, boolean var3, Position var4);

    public static /* synthetic */ boolean inferImplicitValue$default$2$(Typers $this) {
        return $this.inferImplicitValue$default$2();
    }

    default public boolean inferImplicitValue$default$2() {
        return true;
    }

    public static /* synthetic */ boolean inferImplicitValue$default$3$(Typers $this) {
        return $this.inferImplicitValue$default$3();
    }

    default public boolean inferImplicitValue$default$3() {
        return false;
    }

    public static /* synthetic */ Position inferImplicitValue$default$4$(Typers $this) {
        return $this.inferImplicitValue$default$4();
    }

    default public Position inferImplicitValue$default$4() {
        return ((Enclosures)((Object)this)).enclosingPosition();
    }

    public Trees.TreeApi inferImplicitView(Trees.TreeApi var1, Types.TypeApi var2, Types.TypeApi var3, boolean var4, boolean var5, Position var6);

    public static /* synthetic */ boolean inferImplicitView$default$4$(Typers $this) {
        return $this.inferImplicitView$default$4();
    }

    default public boolean inferImplicitView$default$4() {
        return true;
    }

    public static /* synthetic */ boolean inferImplicitView$default$5$(Typers $this) {
        return $this.inferImplicitView$default$5();
    }

    default public boolean inferImplicitView$default$5() {
        return false;
    }

    public static /* synthetic */ Position inferImplicitView$default$6$(Typers $this) {
        return $this.inferImplicitView$default$6();
    }

    default public Position inferImplicitView$default$6() {
        return ((Enclosures)((Object)this)).enclosingPosition();
    }

    public Trees.TreeApi resetLocalAttrs(Trees.TreeApi var1);

    public Trees.TreeApi untypecheck(Trees.TreeApi var1);

    public static void $init$(Typers $this) {
        $this.scala$reflect$macros$Typers$_setter_$TypecheckException_$eq(TypecheckException$.MODULE$);
    }
}

