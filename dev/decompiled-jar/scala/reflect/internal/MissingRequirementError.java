/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Option;
import scala.Predef$;
import scala.collection.immutable.StringOps;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.FatalError;
import scala.reflect.internal.MissingRequirementError$;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001y3A!\u0004\b\u0001+!I!\u0004\u0001B\u0001B\u0003%1D\n\u0005\u0006O\u0001!I\u0001\u000b\u0005\u0006W\u0001!\t\u0001L\u0004\u0006[9A\tA\f\u0004\u0006\u001b9A\ta\f\u0005\u0006O\u0015!\ta\u000e\u0005\bq\u0015\u0011\r\u0011\"\u0003:\u0011\u0019\tU\u0001)A\u0005u!)!)\u0002C\u0001\u0007\")\u0001*\u0002C\u0001\u0013\")1*\u0002C\u0001\u0019\"9\u0011,BA\u0001\n\u0013Q&aF'jgNLgn\u001a*fcVL'/Z7f]R,%O]8s\u0015\ty\u0001#\u0001\u0005j]R,'O\\1m\u0015\t\t\"#A\u0004sK\u001adWm\u0019;\u000b\u0003M\tQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001-A\u0011q\u0003G\u0007\u0002\u001d%\u0011\u0011D\u0004\u0002\u000b\r\u0006$\u0018\r\\#se>\u0014\u0018aA7tOB\u0011Ad\t\b\u0003;\u0005\u0002\"A\b\n\u000e\u0003}Q!\u0001\t\u000b\u0002\rq\u0012xn\u001c;?\u0013\t\u0011##\u0001\u0004Qe\u0016$WMZ\u0005\u0003I\u0015\u0012aa\u0015;sS:<'B\u0001\u0012\u0013\u0013\tQ\u0002$\u0001\u0004=S:LGO\u0010\u000b\u0003S)\u0002\"a\u0006\u0001\t\u000bi\u0011\u0001\u0019A\u000e\u0002\u0007I,\u0017/F\u0001\u001c\u0003]i\u0015n]:j]\u001e\u0014V-];je\u0016lWM\u001c;FeJ|'\u000f\u0005\u0002\u0018\u000bM\u0019Q\u0001\r\u001b\u0011\u0005E\u0012T\"\u0001\n\n\u0005M\u0012\"AB!osJ+g\r\u0005\u00022k%\u0011aG\u0005\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.\u001a\u000b\u0002]\u000511/\u001e4gSb,\u0012A\u000f\t\u0003w\u0001k\u0011\u0001\u0010\u0006\u0003{y\nA\u0001\\1oO*\tq(\u0001\u0003kCZ\f\u0017B\u0001\u0013=\u0003\u001d\u0019XO\u001a4jq\u0002\naa]5h]\u0006dGC\u0001#H!\t\tT)\u0003\u0002G%\t9aj\u001c;iS:<\u0007\"\u0002\u000e\n\u0001\u0004Y\u0012\u0001\u00038pi\u001a{WO\u001c3\u0015\u0005\u0011S\u0005\"B\u0016\u000b\u0001\u0004Y\u0012aB;oCB\u0004H.\u001f\u000b\u0003\u001bB\u00032!\r(\u001c\u0013\ty%C\u0001\u0004PaRLwN\u001c\u0005\u0006#.\u0001\rAU\u0001\u0002qB\u00111K\u0016\b\u0003cQK!!\u0016\n\u0002\u000fA\f7m[1hK&\u0011q\u000b\u0017\u0002\n)\"\u0014xn^1cY\u0016T!!\u0016\n\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u00027B\u00111\bX\u0005\u0003;r\u0012aa\u00142kK\u000e$\b")
public class MissingRequirementError
extends FatalError {
    public static Option<String> unapply(Throwable throwable) {
        return MissingRequirementError$.MODULE$.unapply(throwable);
    }

    public static Nothing$ notFound(String string) {
        return MissingRequirementError$.MODULE$.notFound(string);
    }

    public static Nothing$ signal(String string) {
        return MissingRequirementError$.MODULE$.signal(string);
    }

    public String req() {
        if (super.msg().endsWith(MissingRequirementError$.MODULE$.scala$reflect$internal$MissingRequirementError$$suffix())) {
            String string = super.msg();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return (String)new StringOps(string).dropRight(MissingRequirementError$.MODULE$.scala$reflect$internal$MissingRequirementError$$suffix().length());
        }
        return super.msg();
    }

    public MissingRequirementError(String msg) {
        super(msg);
    }
}

