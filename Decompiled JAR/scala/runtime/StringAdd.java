/*
 * Decompiled with CFR 0.152.
 */
package scala.runtime;

import scala.reflect.ScalaSignature;
import scala.runtime.StringAdd$;

@ScalaSignature(bytes="\u0006\u0001\r4A!\u0004\b\u0003'!A\u0001\u0004\u0001BC\u0002\u0013\u0005\u0011\u0004\u0003\u0005\u001e\u0001\t\u0005\t\u0015!\u0003\u001b\u0011\u0015q\u0002\u0001\"\u0001 \u0011\u0015\u0019\u0003\u0001\"\u0001%\u0011\u001dI\u0004!!A\u0005BiBqA\u0010\u0001\u0002\u0002\u0013\u0005shB\u0004N\u001d\u0005\u0005\t\u0012\u0001(\u0007\u000f5q\u0011\u0011!E\u0001\u001f\")a\u0004\u0003C\u0001'\")A\u000b\u0003C\u0003+\"9!\fCA\u0001\n\u000bY\u0006bB/\t\u0003\u0003%)A\u0018\u0002\n'R\u0014\u0018N\\4BI\u0012T!a\u0004\t\u0002\u000fI,h\u000e^5nK*\t\u0011#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u0001!\u0002CA\u000b\u0017\u001b\u0005\u0001\u0012BA\f\u0011\u0005\u0019\te.\u001f,bY\u0006!1/\u001a7g+\u0005Q\u0002CA\u000b\u001c\u0013\ta\u0002CA\u0002B]f\fQa]3mM\u0002\na\u0001P5oSRtDC\u0001\u0011#!\t\t\u0003!D\u0001\u000f\u0011\u0015A2\u00011\u0001\u001b\u0003\u0015!\u0003\u000f\\;t)\t)S\u0006\u0005\u0002'W5\tqE\u0003\u0002)S\u0005!A.\u00198h\u0015\u0005Q\u0013\u0001\u00026bm\u0006L!\u0001L\u0014\u0003\rM#(/\u001b8h\u0011\u0015qC\u00011\u00010\u0003\u0015yG\u000f[3s!\t\u0001tG\u0004\u00022kA\u0011!\u0007E\u0007\u0002g)\u0011AGE\u0001\u0007yI|w\u000e\u001e \n\u0005Y\u0002\u0012A\u0002)sK\u0012,g-\u0003\u0002-q)\u0011a\u0007E\u0001\tQ\u0006\u001c\bnQ8eKR\t1\b\u0005\u0002\u0016y%\u0011Q\b\u0005\u0002\u0004\u0013:$\u0018AB3rk\u0006d7\u000f\u0006\u0002A\u0007B\u0011Q#Q\u0005\u0003\u0005B\u0011qAQ8pY\u0016\fg\u000eC\u0004E\r\u0005\u0005\t\u0019\u0001\u000e\u0002\u0007a$\u0013\u0007\u000b\u0003\u0001\r&[\u0005CA\u000bH\u0013\tA\u0005C\u0001\u0006eKB\u0014XmY1uK\u0012\f\u0013AS\u0001\u0015kN,\u0007\u0005\u0015:fI\u00164gf\u0015;sS:<\u0017\t\u001a3\"\u00031\u000baA\r\u00182c9\u0002\u0014!C*ue&tw-\u00113e!\t\t\u0003b\u0005\u0002\t!B\u0011Q#U\u0005\u0003%B\u0011a!\u00118z%\u00164G#\u0001(\u0002\u001f\u0011\u0002H.^:%Kb$XM\\:j_:$\"A\u0016-\u0015\u0005\u0015:\u0006\"\u0002\u0018\u000b\u0001\u0004y\u0003\"B-\u000b\u0001\u0004\u0001\u0013!\u0002\u0013uQ&\u001c\u0018A\u00055bg\"\u001cu\u000eZ3%Kb$XM\\:j_:$\"A\u000f/\t\u000be[\u0001\u0019\u0001\u0011\u0002!\u0015\fX/\u00197tI\u0015DH/\u001a8tS>tGCA0b)\t\u0001\u0005\rC\u0004E\u0019\u0005\u0005\t\u0019\u0001\u000e\t\u000bec\u0001\u0019\u0001\u0011)\t!1\u0015j\u0013")
public final class StringAdd {
    private final Object self;

    public static boolean equals$extension(Object object, Object object2) {
        return StringAdd$.MODULE$.equals$extension(object, object2);
    }

    public static int hashCode$extension(Object object) {
        return StringAdd$.MODULE$.hashCode$extension(object);
    }

    public static String $plus$extension(Object object, String string) {
        return StringAdd$.MODULE$.$plus$extension(object, string);
    }

    public Object self() {
        return this.self;
    }

    public String $plus(String other) {
        return StringAdd$.MODULE$.$plus$extension(this.self(), other);
    }

    public int hashCode() {
        return StringAdd$.MODULE$.hashCode$extension(this.self());
    }

    public boolean equals(Object x$1) {
        return StringAdd$.MODULE$.equals$extension(this.self(), x$1);
    }

    public StringAdd(Object self) {
        this.self = self;
    }
}

