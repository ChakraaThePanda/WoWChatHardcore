/*
 * Decompiled with CFR 0.152.
 */
package scala.sys;

import scala.Function0;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.sys.ShutdownHookThread$;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001=3A\u0001D\u0007\u0001%!A1\u0004\u0001B\u0001B\u0003%A\u0004C\u0003(\u0001\u0011%\u0001\u0006C\u0003-\u0001\u0011\u0005QfB\u00033\u001b!\u00051GB\u0003\r\u001b!\u0005A\u0007C\u0003(\u000b\u0011\u0005\u0001\bC\u0004:\u000b\u0001\u0007I\u0011\u0002\u001e\t\u000fy*\u0001\u0019!C\u0005\u007f!1Q)\u0002Q!\nmBQAR\u0003\u0005\n\u001dCQ\u0001S\u0003\u0005\u0002%\u0013!c\u00155vi\u0012|wO\u001c%p_.$\u0006N]3bI*\u0011abD\u0001\u0004gf\u001c(\"\u0001\t\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001a\u0005\t\u0003)ei\u0011!\u0006\u0006\u0003-]\tA\u0001\\1oO*\t\u0001$\u0001\u0003kCZ\f\u0017B\u0001\u000e\u0016\u0005\u0019!\u0006N]3bI\u0006!a.Y7f!\tiBE\u0004\u0002\u001fEA\u0011qdD\u0007\u0002A)\u0011\u0011%E\u0001\u0007yI|w\u000e\u001e \n\u0005\rz\u0011A\u0002)sK\u0012,g-\u0003\u0002&M\t11\u000b\u001e:j]\u001eT!aI\b\u0002\rqJg.\u001b;?)\tI3\u0006\u0005\u0002+\u00015\tQ\u0002C\u0003\u001c\u0005\u0001\u0007A$\u0001\u0004sK6|g/\u001a\u000b\u0002]A\u0011q\u0006M\u0007\u0002\u001f%\u0011\u0011g\u0004\u0002\b\u0005>|G.Z1o\u0003I\u0019\u0006.\u001e;e_^t\u0007j\\8l)\"\u0014X-\u00193\u0011\u0005)*1CA\u00036!\tyc'\u0003\u00028\u001f\t1\u0011I\\=SK\u001a$\u0012aM\u0001\u000eQ>|7NT1nK\u000e{WO\u001c;\u0016\u0003m\u0002\"a\f\u001f\n\u0005uz!aA%oi\u0006\t\u0002n\\8l\u001d\u0006lWmQ8v]R|F%Z9\u0015\u0005\u0001\u001b\u0005CA\u0018B\u0013\t\u0011uB\u0001\u0003V]&$\bb\u0002#\t\u0003\u0003\u0005\raO\u0001\u0004q\u0012\n\u0014A\u00045p_.t\u0015-\\3D_VtG\u000fI\u0001\tQ>|7NT1nKR\tA$A\u0003baBd\u0017\u0010\u0006\u0002*\u0015\"11j\u0003CA\u00021\u000bAAY8esB\u0019q&\u0014!\n\u00059{!\u0001\u0003\u001fcs:\fW.\u001a ")
public class ShutdownHookThread
extends Thread {
    /*
     * WARNING - void declaration
     */
    public static ShutdownHookThread apply(Function0<BoxedUnit> function0) {
        void var1_1;
        if (ShutdownHookThread$.MODULE$ == null) {
            throw null;
        }
        ShutdownHookThread apply_t = new ShutdownHookThread(function0){
            private final Function0 body$1;

            public void run() {
                this.body$1.apply$mcV$sp();
            }
            {
                this.body$1 = body$1;
                super(ShutdownHookThread$.MODULE$.scala$sys$ShutdownHookThread$$hookName());
            }
        };
        package$.MODULE$.runtime().addShutdownHook(apply_t);
        return var1_1;
    }

    public boolean remove() {
        return package$.MODULE$.runtime().removeShutdownHook(this);
    }

    public ShutdownHookThread(String name) {
        super(name);
    }
}

