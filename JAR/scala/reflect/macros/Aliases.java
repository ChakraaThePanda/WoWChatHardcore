/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.reflect.ScalaSignature;
import scala.reflect.api.Exprs;
import scala.reflect.api.Exprs$Expr$;
import scala.reflect.api.Symbols;
import scala.reflect.api.Trees;
import scala.reflect.api.TypeTags;
import scala.reflect.api.TypeTags$TypeTag$;
import scala.reflect.api.TypeTags$WeakTypeTag$;
import scala.reflect.api.Types;
import scala.reflect.macros.blackbox.Context;

@ScalaSignature(bytes="\u0006\u0001\u0005}f!C\u000e\u001d!\u0003\r\taIA^\u0011\u0015A\u0003\u0001\"\u0001*\u000b\u0011i\u0003\u0001\u0001\u0018\u0006\tq\u0002\u0001!P\u0003\u0005\u0003\u0002\u0001!)\u0002\u0003G\u0001\u00019U\u0001B%\u0001\u0001)+A\u0001\u0014\u0001\u0001\u001b\u0016!\u0011\u000b\u0001\u0001S\u000b\u00111\u0006\u0001A,\u0006\tm\u0003\u0001\u0001X\u0003\u0005=\u0002\u0001q,\u0002\u0003l\u0001\u0001aW\u0001B8\u0001\u0001AD\u0011\"!\u0001\u0001\u0005\u0004%\t!a\u0001\t\u000f\u0005\u0005\u0001A\"\u0001\u0002\n\u00151\u00111\u0004\u0001\u0001\u0003;)a!!\r\u0001\u0001\u0005M\u0002\"CA\u001f\u0001\t\u0007I\u0011AA \u0011%\t)\u0005\u0001b\u0001\n\u0003\t9\u0005C\u0004\u0002>\u00011\t!!\u0014\t\u000f\u0005\u0015\u0003A\"\u0001\u0002^!9\u0011\u0011\u000e\u0001\u0005\u0002\u0005-\u0004bBA=\u0001\u0011\u0005\u00111\u0010\u0005\b\u0003\u0013\u0003A\u0011AAF\u0011\u001d\t9\n\u0001C\u0001\u00033Cq!!*\u0001\t\u0003\t9KA\u0004BY&\f7/Z:\u000b\u0005uq\u0012AB7bGJ|7O\u0003\u0002 A\u00059!/\u001a4mK\u000e$(\"A\u0011\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001\u0001\n\t\u0003K\u0019j\u0011\u0001I\u0005\u0003O\u0001\u0012a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001+!\t)3&\u0003\u0002-A\t!QK\\5u\u0005\u0019\u0019\u00160\u001c2pYB\u0011qf\u000e\b\u0003aEj\u0011\u0001A\u0005\u0003eM\n\u0001\"\u001e8jm\u0016\u00148/Z\u0005\u0003iU\u0012qaQ8oi\u0016DHO\u0003\u000279\u0005A!\r\\1dW\n|\u00070\u0003\u0002.q%\u0011\u0011H\u000f\u0002\b'fl'm\u001c7t\u0015\tYd$A\u0002ba&\u0014A\u0001V=qKB\u0011qFP\u0005\u0003y}J!\u0001\u0011\u001e\u0003\u000bQK\b/Z:\u0003\t9\u000bW.\u001a\t\u0003_\rK!!\u0011#\n\u0005\u0015S$!\u0002(b[\u0016\u001c(\u0001\u0003+fe6t\u0015-\\3\u0011\u0005=B\u0015B\u0001$E\u0005!!\u0016\u0010]3OC6,\u0007CA\u0018L\u0013\tIEI\u0001\u0003Ue\u0016,\u0007CA\u0018O\u0013\tau*\u0003\u0002Qu\t)AK]3fg\nA\u0001k\\:ji&|g\u000e\u0005\u00020'&\u0011\u0011\u000bV\u0005\u0003+j\u0012\u0011\u0002U8tSRLwN\\:\u0003\u000bM\u001bw\u000e]3\u0011\u0005=B\u0016B\u0001,Z\u0013\tQ&H\u0001\u0004TG>\u0004Xm\u001d\u0002\n\u001b>$\u0017NZ5feN\u0004\"aL/\n\u0005m{%a\u0001*v]B\u0011q\u0006Y\u0005\u0003=\u0006L!A\u0019\u000f\u0003\u0011Us\u0017N^3sg\u0016DCa\u00033hSB\u0011Q%Z\u0005\u0003M\u0002\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005A\u0017\u0001W2/K:\u001cGn\\:j]\u001e$&/Z3.gRLH.\u001a\u0011B!&\u001b\b%\u0019:fA9|w\u000f\t3faJ,7-\u0019;fIn\u00023m\u001c8tk2$\b\u0005\u001e5fAM\u001c\u0017\r\\1e_\u000e\u0004cm\u001c:![>\u0014X\rI5oM>\u0014X.\u0019;j_:\f\u0013A[\u0001\u0007e9\n\u0014G\f\u0019\u0003\u001f\r{W\u000e]5mCRLwN\\+oSR\u0004\"aL7\n\u0005-\f\u0007\u0006\u0002\u0007eO&\u0014A!\u0012=qeV\u0011\u0011o\u001e\t\u0004_I,\u0018BA8t\u0013\t!(HA\u0003FqB\u00148\u000f\u0005\u0002wo2\u0001AA\u0002=\u000e\t\u000b\u0007\u0011PA\u0001U#\tQX\u0010\u0005\u0002&w&\u0011A\u0010\t\u0002\b\u001d>$\b.\u001b8h!\t)c0\u0003\u0002\u0000A\t\u0019\u0011I\\=\u0002\t\u0015C\bO]\u000b\u0003\u0003\u000bq1aLA\u0004\u0013\r\t\ta]\u000b\u0005\u0003\u0017\t\u0019\u0002\u0006\u0003\u0002\u000e\u0005-B\u0003BA\b\u0003+\u0001B\u0001M\u0007\u0002\u0012A\u0019a/a\u0005\u0005\u000ba|!\u0019A=\t\u0013\u0005]q\"!AA\u0004\u0005e\u0011AC3wS\u0012,gnY3%cA!\u0001\u0007EA\t\u0005-9V-Y6UsB,G+Y4\u0016\t\u0005}\u0011\u0011\u0006\t\u0006_\u0005\u0005\u0012qE\u0005\u0005\u00037\t\u0019#C\u0002\u0002&i\u0012\u0001\u0002V=qKR\u000bwm\u001d\t\u0004m\u0006%B!\u0002=\u0011\u0005\u0004I\bbBA\u0017\u001f\u0001\u0007\u0011qF\u0001\u0005iJ,W\r\u0005\u00021\u000f\t9A+\u001f9f)\u0006<W\u0003BA\u001b\u0003w\u0001RaLA\u001c\u0003sIA!!\r\u0002$A\u0019a/a\u000f\u0005\u000ba\f\"\u0019A=\u0002\u0017]+\u0017m\u001b+za\u0016$\u0016mZ\u000b\u0003\u0003\u0003r1aLA\"\u0013\u0011\ti$a\t\u0002\u000fQK\b/\u001a+bOV\u0011\u0011\u0011\n\b\u0004_\u0005-\u0013\u0002BA#\u0003G)B!a\u0014\u0002VQ!\u0011\u0011KA,!\u0011\u0001\u0004#a\u0015\u0011\u0007Y\f)\u0006B\u0003y)\t\u0007\u0011\u0010C\u0004\u0002ZQ\u0001\r!a\u0017\u0002\u0007Q\u0004X\r\u0005\u00021\u0007U!\u0011qLA3)\u0011\t\t'a\u001a\u0011\tA\n\u00121\r\t\u0004m\u0006\u0015D!\u0002=\u0016\u0005\u0004I\bbBA-+\u0001\u0007\u00111L\u0001\fo\u0016\f7\u000eV=qKR\u000bw-\u0006\u0003\u0002n\u0005MD\u0003BA8\u0003k\u0002B\u0001\r\t\u0002rA\u0019a/a\u001d\u0005\u000ba4\"\u0019A=\t\u000f\u0005]d\u0003q\u0001\u0002p\u0005)\u0011\r\u001e;bO\u00069A/\u001f9f)\u0006<W\u0003BA?\u0003\u0007#B!a \u0002\u0006B!\u0001'EAA!\r1\u00181\u0011\u0003\u0006q^\u0011\r!\u001f\u0005\b\u0003\u000f;\u00029AA@\u0003\u0011!H/Y4\u0002\u0015],\u0017m\u001b+za\u0016|e-\u0006\u0003\u0002\u000e\u0006UE\u0003BA.\u0003\u001fCq!a\u001e\u0019\u0001\b\t\t\n\u0005\u00031!\u0005M\u0005c\u0001<\u0002\u0016\u0012)\u0001\u0010\u0007b\u0001s\u00061A/\u001f9f\u001f\u001a,B!a'\u0002$R!\u00111LAO\u0011\u001d\t9)\u0007a\u0002\u0003?\u0003B\u0001M\t\u0002\"B\u0019a/a)\u0005\u000baL\"\u0019A=\u0002\u0011MLXNY8m\u001f\u001a,B!!+\u0002:R!\u00111VAY!\ry\u0013QV\u0005\u0004\u0003_C$A\u0003+za\u0016\u001c\u00160\u001c2pY\"I\u00111\u0017\u000e\u0002\u0002\u0003\u000f\u0011QW\u0001\u000bKZLG-\u001a8dK\u0012\u0012\u0004\u0003\u0002\u0019\u0011\u0003o\u00032A^A]\t\u0015A(D1\u0001z!\r\tilM\u0007\u0002k\u0001")
public interface Aliases {
    public void scala$reflect$macros$Aliases$_setter_$Expr_$eq(Exprs$Expr$ var1);

    public void scala$reflect$macros$Aliases$_setter_$WeakTypeTag_$eq(TypeTags$WeakTypeTag$ var1);

    public void scala$reflect$macros$Aliases$_setter_$TypeTag_$eq(TypeTags$TypeTag$ var1);

    public Exprs$Expr$ Expr();

    public <T> Exprs.Expr<T> Expr(Trees.TreeApi var1, TypeTags.WeakTypeTag<T> var2);

    public TypeTags$WeakTypeTag$ WeakTypeTag();

    public TypeTags$TypeTag$ TypeTag();

    public <T> TypeTags.WeakTypeTag<T> WeakTypeTag(Types.TypeApi var1);

    public <T> TypeTags.TypeTag<T> TypeTag(Types.TypeApi var1);

    public static /* synthetic */ TypeTags.WeakTypeTag weakTypeTag$(Aliases $this, TypeTags.WeakTypeTag attag) {
        return $this.weakTypeTag(attag);
    }

    default public <T> TypeTags.WeakTypeTag<T> weakTypeTag(TypeTags.WeakTypeTag<T> attag) {
        return attag;
    }

    public static /* synthetic */ TypeTags.TypeTag typeTag$(Aliases $this, TypeTags.TypeTag ttag) {
        return $this.typeTag(ttag);
    }

    default public <T> TypeTags.TypeTag<T> typeTag(TypeTags.TypeTag<T> ttag) {
        return ttag;
    }

    public static /* synthetic */ Types.TypeApi weakTypeOf$(Aliases $this, TypeTags.WeakTypeTag attag) {
        return $this.weakTypeOf(attag);
    }

    default public <T> Types.TypeApi weakTypeOf(TypeTags.WeakTypeTag<T> attag) {
        return attag.tpe();
    }

    public static /* synthetic */ Types.TypeApi typeOf$(Aliases $this, TypeTags.TypeTag ttag) {
        return $this.typeOf(ttag);
    }

    default public <T> Types.TypeApi typeOf(TypeTags.TypeTag<T> ttag) {
        return ttag.tpe();
    }

    public static /* synthetic */ Symbols.TypeSymbolApi symbolOf$(Aliases $this, TypeTags.WeakTypeTag evidence$2) {
        return $this.symbolOf(evidence$2);
    }

    default public <T> Symbols.TypeSymbolApi symbolOf(TypeTags.WeakTypeTag<T> evidence$2) {
        return ((Context)this).universe().symbolOf(evidence$2);
    }

    public static void $init$(Aliases $this) {
        $this.scala$reflect$macros$Aliases$_setter_$Expr_$eq(((Context)$this).universe().Expr());
        $this.scala$reflect$macros$Aliases$_setter_$WeakTypeTag_$eq(((Context)$this).universe().WeakTypeTag());
        $this.scala$reflect$macros$Aliases$_setter_$TypeTag_$eq(((Context)$this).universe().TypeTag());
    }
}

