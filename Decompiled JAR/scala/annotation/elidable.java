/*
 * Decompiled with CFR 0.152.
 */
package scala.annotation;

import scala.annotation.Annotation;
import scala.annotation.StaticAnnotation;
import scala.annotation.elidable$;
import scala.collection.immutable.Map;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005Ea\u0001B\u0011#\u0005\u001dB\u0001b\f\u0001\u0003\u0006\u0004%)\u0001\r\u0005\tk\u0001\u0011\t\u0011)A\u0007c!)a\u0007\u0001C\u0001o\u001d)!H\tE\u0001w\u0019)\u0011E\tE\u0001y!)a'\u0002C\u0001\u0001\"9\u0011)\u0002b\u0001\n\u000b\u0011\u0005BB#\u0006A\u000351\tC\u0004G\u000b\t\u0007IQA$\t\r)+\u0001\u0015!\u0004I\u0011\u001dYUA1A\u0005\u00061CaaT\u0003!\u0002\u001bi\u0005b\u0002)\u0006\u0005\u0004%)!\u0015\u0005\u0007)\u0016\u0001\u000bQ\u0002*\t\u000fU+!\u0019!C\u0003-\"1\u0011,\u0002Q\u0001\u000e]CqAW\u0003C\u0002\u0013\u00151\f\u0003\u0004_\u000b\u0001\u0006i\u0001\u0018\u0005\b?\u0016\u0011\r\u0011\"\u0002a\u0011\u0019\u0019W\u0001)A\u0007C\"9A-\u0002b\u0001\n\u000b)\u0007B\u00025\u0006A\u00035a\rC\u0004j\u000b\t\u0007IQ\u00016\t\r5,\u0001\u0015!\u0004l\u0011\u001dqWA1A\u0005\u0006)Daa\\\u0003!\u0002\u001bY\u0007b\u00029\u0006\u0005\u0004%)A\u0011\u0005\u0007c\u0016\u0001\u000bQB\"\t\u000fI,!\u0019!C\u0003g\"1a/\u0002Q\u0001\u000eQDqa^\u0003C\u0002\u0013\u0005\u0001\u0010C\u0004\u0002\u0010\u0015\u0001\u000b\u0011B=\u0003\u0011\u0015d\u0017\u000eZ1cY\u0016T!a\t\u0013\u0002\u0015\u0005tgn\u001c;bi&|gNC\u0001&\u0003\u0015\u00198-\u00197b\u0007\u0001\u00192\u0001\u0001\u0015-!\tI#&D\u0001#\u0013\tY#E\u0001\u0006B]:|G/\u0019;j_:\u0004\"!K\u0017\n\u00059\u0012#\u0001E*uCRL7-\u00118o_R\fG/[8o\u0003\u0015aWM^3m+\u0005\t\u0004C\u0001\u001a4\u001b\u0005!\u0013B\u0001\u001b%\u0005\rIe\u000e^\u0001\u0007Y\u00164X\r\u001c\u0011\u0002\rqJg.\u001b;?)\tA\u0014\b\u0005\u0002*\u0001!)qf\u0001a\u0001c\u0005AQ\r\\5eC\ndW\r\u0005\u0002*\u000bM\u0011Q!\u0010\t\u0003eyJ!a\u0010\u0013\u0003\r\u0005s\u0017PU3g)\u0005Y\u0014aA!M\u0019V\t1iD\u0001E;\u0011\u0001\t\u0001\u0001\u0001\u0002\t\u0005cE\nI\u0001\u0007\r&sUi\u0015+\u0016\u0003!{\u0011!S\u000f\u0003\u00031\nqAR%O\u000bN#\u0006%A\u0003G\u0013:+%+F\u0001N\u001f\u0005qUDA\u0001\u0011\u0004\u00191\u0015JT#SA\u0005!a)\u0013(F+\u0005\u0011v\"A*\u001e\u0005\u0005! !\u0002$J\u001d\u0016\u0003\u0013AB\"P\u001d\u001aKu)F\u0001X\u001f\u0005AVD\u0001\u0002=\u0004\u001d\u0019uJ\u0014$J\u000f\u0002\nA!\u0013(G\u001fV\tAlD\u0001^;\t\u0019\u0001%A\u0003J\u001d\u001a{\u0005%A\u0004X\u0003Js\u0015JT$\u0016\u0003\u0005|\u0011AY\u000f\u0003\u0007\u0011\r\u0001bV!S\u001d&su\tI\u0001\u0007'\u00163VIU#\u0016\u0003\u0019|\u0011aZ\u000f\u0003\u0007!\u0010qaU#W\u000bJ+\u0005%A\u0002P\r\u001a+\u0012a[\b\u0002Yv!qp\u0000\u0000\u0000\u0004\u0011yeI\u0012\u0011\u0002\u000f5\u000b\u0005,S'V\u001b\u0006AQ*\u0011-J\u001bVk\u0005%A\u0004N\u0013:KU*V'\u0002\u00115Ke*S'V\u001b\u0002\n\u0011\"Q*T\u000bJ#\u0016j\u0014(\u0016\u0003Q|\u0011!^\u000f\u0003\u000fA\u000f!\"Q*T\u000bJ#\u0016j\u0014(!\u0003\u0019\u0011\u0017PT1nKV\t\u0011\u0010\u0005\u0004{\u0003\u0007\tI!\r\b\u0003w~\u0004\"\u0001 \u0013\u000e\u0003uT!A \u0014\u0002\rq\u0012xn\u001c;?\u0013\r\t\t\u0001J\u0001\u0007!J,G-\u001a4\n\t\u0005\u0015\u0011q\u0001\u0002\u0004\u001b\u0006\u0004(bAA\u0001IA\u0019!0a\u0003\n\t\u00055\u0011q\u0001\u0002\u0007'R\u0014\u0018N\\4\u0002\u000f\tLh*Y7fA\u0001")
public final class elidable
extends Annotation
implements StaticAnnotation {
    private final int level;

    public static Map<String, Object> byName() {
        return elidable$.MODULE$.byName();
    }

    public static int ASSERTION() {
        return elidable$.MODULE$.ASSERTION();
    }

    public static int MINIMUM() {
        return elidable$.MODULE$.MINIMUM();
    }

    public static int MAXIMUM() {
        return elidable$.MODULE$.MAXIMUM();
    }

    public static int OFF() {
        return elidable$.MODULE$.OFF();
    }

    public static int SEVERE() {
        return elidable$.MODULE$.SEVERE();
    }

    public static int WARNING() {
        return elidable$.MODULE$.WARNING();
    }

    public static int INFO() {
        return elidable$.MODULE$.INFO();
    }

    public static int CONFIG() {
        return elidable$.MODULE$.CONFIG();
    }

    public static int FINE() {
        return elidable$.MODULE$.FINE();
    }

    public static int FINER() {
        return elidable$.MODULE$.FINER();
    }

    public static int FINEST() {
        return elidable$.MODULE$.FINEST();
    }

    public static int ALL() {
        return elidable$.MODULE$.ALL();
    }

    public final int level() {
        return this.level;
    }

    public elidable(int level) {
        this.level = level;
    }
}

