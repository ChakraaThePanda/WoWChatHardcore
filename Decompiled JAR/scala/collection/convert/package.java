/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.convert;

import scala.collection.JavaConverters$;
import scala.collection.convert.DecorateAsJava;
import scala.collection.convert.DecorateAsScala;
import scala.collection.convert.WrapAsJava;
import scala.collection.convert.WrapAsScala;
import scala.collection.convert.package$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u001d<Qa\u0004\t\t\u0002]1Q!\u0007\t\t\u0002iAQaH\u0001\u0005\u0002\u0001Bq!I\u0001C\u0002\u0013\u0005!\u0005\u0003\u0004'\u0003\u0001\u0006Ia\t\u0005\bg\u0005\u0011\r\u0011\"\u00015\u0011\u00199\u0014\u0001)A\u0005k!9Q(\u0001b\u0001\n\u0003q\u0004B\u0002#\u0002A\u0003%q\bC\u0004G\u0003\t\u0007I\u0011A$\t\r)\u000b\u0001\u0015!\u0003I\u0011\u001d\u0011\u0016A1A\u0005\u0002MCaAV\u0001!\u0002\u0013!\u0006b\u00020\u0002\u0005\u0004%\ta\u0018\u0005\u0007E\u0006\u0001\u000b\u0011\u00021\u0002\u000fA\f7m[1hK*\u0011\u0011CE\u0001\bG>tg/\u001a:u\u0015\t\u0019B#\u0001\u0006d_2dWm\u0019;j_:T\u0011!F\u0001\u0006g\u000e\fG.Y\u0002\u0001!\tA\u0012!D\u0001\u0011\u0005\u001d\u0001\u0018mY6bO\u0016\u001c\"!A\u000e\u0011\u0005qiR\"\u0001\u000b\n\u0005y!\"AB!osJ+g-\u0001\u0004=S:LGO\u0010\u000b\u0002/\u0005qA-Z2pe\u0006$X-Q:KCZ\fW#A\u0012\u0013\u0007\u0011ZrF\u0002\u0003&\t\u0001\u0019#\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0014a\u00043fG>\u0014\u0018\r^3Bg*\u000bg/\u0019\u0011)\t\u0011A3&\f\t\u00039%J!A\u000b\u000b\u0003\u0015\u0011,\u0007O]3dCR,G-I\u0001-\u0003I)8/\u001a\u0011KCZ\f7i\u001c8wKJ$XM]:\"\u00039\naA\r\u00182e9\u0002\u0004C\u0001\r1\u0013\t\t\u0004C\u0001\bEK\u000e|'/\u0019;f\u0003NT\u0015M^1)\t\rA3&L\u0001\u0010I\u0016\u001cwN]1uK\u0006\u001b8kY1mCV\tQGE\u000277e2A!\n\u0004\u0001k\u0005\u0001B-Z2pe\u0006$X-Q:TG\u0006d\u0017\r\t\u0015\u0005\r!ZS\u0006\u0005\u0002\u0019u%\u00111\b\u0005\u0002\u0010\t\u0016\u001cwN]1uK\u0006\u001b8kY1mC\"\"Q\u0001K\u0016.\u0003-!WmY8sCR,\u0017\t\u001c7\u0016\u0003}r!\u0001Q!\u000e\u0003II!A\u0011\n\u0002\u001d)\u000bg/Y\"p]Z,'\u000f^3sg\"\"q\u0001K\u0016.\u00031!WmY8sCR,\u0017\t\u001c7!Q\u0011A\u0001fK\u0017\u0002\u0015]\u0014\u0018\r]!t\u0015\u00064\u0018-F\u0001I%\rI5D\u0014\u0004\u0005K)\u0001\u0001*A\u0006xe\u0006\u0004\u0018i\u001d&bm\u0006\u0004\u0003\u0006\u0002\u0006)\u00196\n\u0013!T\u00019kN,\u0007ES1wC\u000e{gN^3si\u0016\u00148\u000fI8sA\r|gn]5eKJ\u0004\u0013*\u001c9mS\u000eLGoQ8om\u0016\u00148/[8ogR{'*\u0019<b!\tAr*\u0003\u0002Q!\tQqK]1q\u0003NT\u0015M^1)\t%AC*L\u0001\foJ\f\u0007/Q:TG\u0006d\u0017-F\u0001U%\r)6D\u0017\u0004\u0005K1\u0001A+\u0001\u0007xe\u0006\u0004\u0018i]*dC2\f\u0007\u0005\u000b\u0003\rQak\u0013%A-\u0002sU\u001cX\r\t&bm\u0006\u001cuN\u001c<feR,'o\u001d\u0011pe\u0002\u001awN\\:jI\u0016\u0014\b%S7qY&\u001c\u0017\u000e^\"p]Z,'o]5p]N$vnU2bY\u0006\u0004\"\u0001G.\n\u0005q\u0003\"aC,sCB\f5oU2bY\u0006DCa\u0003\u0015Y[\u00059qO]1q\u00032dW#\u00011\u0013\t\u0005\\bJ\u0017\u0004\u0005K9\u0001\u0001-\u0001\u0005xe\u0006\u0004\u0018\t\u001c7!Q\u0011q\u0001\u0006Z\u0017\"\u0003\u0015\f!'^:fA)\u000bg/Y\"p]Z,'\u000f^3sg\u0002z'\u000fI2p]NLG-\u001a:!\u00136\u0004H.[2ji\u000e{gN^3sg&|gn\u001d\u0015\u0005\u001b!\"W\u0006")
public final class package {
    public static WrapAsJava wrapAll() {
        return package$.MODULE$.wrapAll();
    }

    public static WrapAsScala wrapAsScala() {
        return package$.MODULE$.wrapAsScala();
    }

    public static WrapAsJava wrapAsJava() {
        return package$.MODULE$.wrapAsJava();
    }

    public static JavaConverters$ decorateAll() {
        return package$.MODULE$.decorateAll();
    }

    public static DecorateAsScala decorateAsScala() {
        return package$.MODULE$.decorateAsScala();
    }

    public static DecorateAsJava decorateAsJava() {
        return package$.MODULE$.decorateAsJava();
    }
}

