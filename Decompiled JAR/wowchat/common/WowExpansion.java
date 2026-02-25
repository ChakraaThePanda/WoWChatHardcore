/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;
import scala.Enumeration$ValueOrdering$;
import scala.Enumeration$ValueSet$;
import scala.reflect.ScalaSignature;
import wowchat.common.WowExpansion$;

@ScalaSignature(bytes="\u0006\u0001\u0001;Qa\u0004\t\t\u0002U1Qa\u0006\t\t\u0002aAQaH\u0001\u0005\u0002\u0001*AaF\u0001\u0001C!9Q%\u0001b\u0001\n\u00031\u0003BB\u0014\u0002A\u0003%\u0011\u0005C\u0004)\u0003\t\u0007I\u0011\u0001\u0014\t\r%\n\u0001\u0015!\u0003\"\u0011\u001dQ\u0013A1A\u0005\u0002\u0019BaaK\u0001!\u0002\u0013\t\u0003b\u0002\u0017\u0002\u0005\u0004%\tA\n\u0005\u0007[\u0005\u0001\u000b\u0011B\u0011\t\u000f9\n!\u0019!C\u0001M!1q&\u0001Q\u0001\n\u0005BQ\u0001M\u0001\u0005\u0002E\nAbV8x\u000bb\u0004\u0018M\\:j_:T!!\u0005\n\u0002\r\r|W.\\8o\u0015\u0005\u0019\u0012aB<po\u000eD\u0017\r^\u0002\u0001!\t1\u0012!D\u0001\u0011\u000519vn^#ya\u0006t7/[8o'\t\t\u0011\u0004\u0005\u0002\u001b;5\t1DC\u0001\u001d\u0003\u0015\u00198-\u00197b\u0013\tq2DA\u0006F]VlWM]1uS>t\u0017A\u0002\u001fj]&$h\bF\u0001\u0016!\t\u00113%D\u0001\u0002\u0013\t!SDA\u0003WC2,X-A\u0004WC:LG\u000e\\1\u0016\u0003\u0005\n\u0001BV1oS2d\u0017\rI\u0001\u0004)\n\u001b\u0015\u0001\u0002+C\u0007\u0002\nQaV8u\u0019.\u000baaV8u\u0019.\u0003\u0013!C\"bi\u0006\u001cG._:n\u0003)\u0019\u0015\r^1dYf\u001cX\u000eI\u0001\u0004\u001b>\u0004\u0016\u0001B'p!\u0002\nqA^1mk\u0016|e\r\u0006\u00023gA\u0011!e\u0001\u0005\u0006i9\u0001\r!N\u0001\bm\u0016\u00148/[8o!\t1TH\u0004\u00028wA\u0011\u0001hG\u0007\u0002s)\u0011!\bF\u0001\u0007yI|w\u000e\u001e \n\u0005qZ\u0012A\u0002)sK\u0012,g-\u0003\u0002?\u007f\t11\u000b\u001e:j]\u001eT!\u0001P\u000e")
public final class WowExpansion {
    public static Enumeration.Value valueOf(String string) {
        return WowExpansion$.MODULE$.valueOf(string);
    }

    public static Enumeration.Value MoP() {
        return WowExpansion$.MODULE$.MoP();
    }

    public static Enumeration.Value Cataclysm() {
        return WowExpansion$.MODULE$.Cataclysm();
    }

    public static Enumeration.Value WotLK() {
        return WowExpansion$.MODULE$.WotLK();
    }

    public static Enumeration.Value TBC() {
        return WowExpansion$.MODULE$.TBC();
    }

    public static Enumeration.Value Vanilla() {
        return WowExpansion$.MODULE$.Vanilla();
    }

    public static Enumeration$ValueSet$ ValueSet() {
        return WowExpansion$.MODULE$.ValueSet();
    }

    public static Enumeration$ValueOrdering$ ValueOrdering() {
        return WowExpansion$.MODULE$.ValueOrdering();
    }

    public static Enumeration.Value withName(String string) {
        return WowExpansion$.MODULE$.withName(string);
    }

    public static Enumeration.Value apply(int n) {
        return WowExpansion$.MODULE$.apply(n);
    }

    public static int maxId() {
        return WowExpansion$.MODULE$.maxId();
    }

    public static Enumeration.ValueSet values() {
        return WowExpansion$.MODULE$.values();
    }

    public static String toString() {
        return WowExpansion$.MODULE$.toString();
    }
}

