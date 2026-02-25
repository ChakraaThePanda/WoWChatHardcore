/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import scala.reflect.ScalaSignature;
import scala.reflect.api.Names;

@ScalaSignature(bytes="\u0006\u0001Q4\u0001\"\u0006\f\u0011\u0002\u0007\u0005Q\u0004\u001d\u0005\u0006E\u0001!\ta\t\u0005\bO\u0001\u0011\rQ\"\u0001)\u0011\u001dy\u0006A1A\u0007\u0002!Bq\u0001\u0019\u0001C\u0002\u001b\u0005\u0011\rC\u0004p\u0001\t\u0007i\u0011A1\u0007\u000f9\u0002\u0001\u0013aI\u0001_\u0011)\u0001G\u0002B\u0001c!9!H\u0002b\u0001\u000e\u0003Y\u0004b\u0002 \u0007\u0005\u00045\ta\u000f\u0005\b\u007f\u0019\u0011\rQ\"\u0001<\u0011\u001d\u0001eA1A\u0007\u0002m2qa\u000b\u0001\u0011\u0002G\u0005A&\u0002\u00031\u0019\u0001\t\u0005b\u0002#\r\u0005\u00045\t!\u0012\u0005\b\u00112\u0011\rQ\"\u0001F\u0011\u001dIEB1A\u0007\u0002\u0015CqA\u0013\u0007C\u0002\u001b\u00051JB\u0004d\u0001A\u0005\u0019\u0013\u00013\u0006\tA\u0012\u0002!\u001a\u0005\bQJ\u0011\rQ\"\u0001j\u00055\u0019F/\u00198eCJ$g*Y7fg*\u0011q\u0003G\u0001\u0004CBL'BA\r\u001b\u0003\u001d\u0011XM\u001a7fGRT\u0011aG\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001a\u0004\u0005\u0002 A5\t!$\u0003\u0002\"5\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$C#\u0001\u0013\u0011\u0005})\u0013B\u0001\u0014\u001b\u0005\u0011)f.\u001b;\u0002\u00079lW-F\u0001*!\tQC\"D\u0001\u0001\u00051!VM]7OC6,7/\u00119j'\raa$\f\t\u0003U\u0019\u0011\u0001BT1nKN\f\u0005/[\n\u0003\ry\u0011\u0001BT1nKRK\b/Z\t\u0003eU\u0002\"aH\u001a\n\u0005QR\"\u0001\u0002(vY2\u0004\"A\u000b\u001c\n\u0005]B$\u0001\u0002(b[\u0016L!!\u000f\f\u0003\u000b9\u000bW.Z:\u0002\u0011]KE\nR\"B%\u0012+\u0012\u0001\u0010\t\u0003{\u001di\u0011AB\u0001\u0006\u000b6\u0003F+W\u0001\u0006\u000bJ\u0013vJU\u0001\b!\u0006\u001b5*Q$F!\tQ#)\u0003\u0002Dq\tAA+\u001a:n\u001d\u0006lW-A\u0006D\u001f:\u001bFKU+D)>\u0013V#\u0001$\u0011\u0005\u001dkQ\"\u0001\u0007\u0002\u000fI{u\n\u0016)L\u000f\u0006\u0011R)\u0014)U3~\u0003\u0016iQ&B\u000f\u0016{f*Q'F\u0003MaujQ!M?N+fIR%Y?N#&+\u0013(H+\u0005a\u0005CA'U\u001d\tq%\u000b\u0005\u0002P55\t\u0001K\u0003\u0002R9\u00051AH]8pizJ!a\u0015\u000e\u0002\rA\u0013X\rZ3g\u0013\t)fK\u0001\u0004TiJLgn\u001a\u0006\u0003'jACA\u0001-\\;B\u0011q$W\u0005\u00035j\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005a\u0016aF;tK\u0002\u0002G/\u001a:n\u001d\u0006lWm\u001d1!S:\u001cH/Z1eC\u0005q\u0016A\u0002\u001a/cEr\u0003'A\u0005uKJlg*Y7fg\u0006)A\u000f\u001d8nKV\t!\r\u0005\u0002+%\taA+\u001f9f\u001d\u0006lWm]!qSN\u0019!CH\u0017\u0011\u0005)2\u0017BA49\u0005!!\u0016\u0010]3OC6,\u0017!D,J\u0019\u0012\u001b\u0015I\u0015#`'R\u000b%+F\u0001k!\tY7#D\u0001\u0013Q\u0011!\u0001,\\/\"\u00039\fq#^:fA\u0001$\u0018\u0010]3OC6,7\u000f\u0019\u0011j]N$X-\u00193\u0002\u0013QL\b/\u001a(b[\u0016\u001c\bCA9s\u001b\u00051\u0012BA:\u0017\u0005!)f.\u001b<feN,\u0007")
public interface StandardNames {
    public TermNamesApi nme();

    public TermNamesApi termNames();

    public TypeNamesApi tpnme();

    public TypeNamesApi typeNames();

    public static void $init$(StandardNames $this) {
    }

    public interface NamesApi {
        public Names.NameApi WILDCARD();

        public Names.NameApi EMPTY();

        public Names.NameApi ERROR();

        public Names.NameApi PACKAGE();
    }

    public interface TermNamesApi
    extends NamesApi {
        public Names.TermNameApi CONSTRUCTOR();

        public Names.TermNameApi ROOTPKG();

        public Names.TermNameApi EMPTY_PACKAGE_NAME();

        public String LOCAL_SUFFIX_STRING();
    }

    public interface TypeNamesApi
    extends NamesApi {
        public Names.TypeNameApi WILDCARD_STAR();
    }
}

