/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00193qa\u0003\u0007\u0011\u0002\u0007\u0005q\u0002C\u0003\u0015\u0001\u0011\u0005Q\u0003C\u0003\u001a\u0001\u0019\u0005!\u0004C\u0003\u001c\u0001\u0011\u0005C\u0004C\u0003!\u0001\u0011\u0005\u0013\u0005C\u0003(\u0001\u0011\u0005\u0003fB\u00032\u0019!\u0005!GB\u0003\f\u0019!\u00051\u0007C\u00038\u000f\u0011\u0005\u0001HB\u0004:\u000fA\u0005\u0019\u0013\u0001\u001e\t\u000beIa\u0011A\u001f\u0003\u000bA\u0013x\u000e_=\u000b\u00035\tQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001!A\u0011\u0011CE\u0007\u0002\u0019%\u00111\u0003\u0004\u0002\u0004\u0003:L\u0018A\u0002\u0013j]&$H\u0005F\u0001\u0017!\t\tr#\u0003\u0002\u0019\u0019\t!QK\\5u\u0003\u0011\u0019X\r\u001c4\u0016\u0003A\t\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0002;A\u0011\u0011CH\u0005\u0003?1\u00111!\u00138u\u0003\u0019)\u0017/^1mgR\u0011!%\n\t\u0003#\rJ!\u0001\n\u0007\u0003\u000f\t{w\u000e\\3b]\")a\u0005\u0002a\u0001!\u0005!A\u000f[1u\u0003!!xn\u0015;sS:<G#A\u0015\u0011\u0005)zS\"A\u0016\u000b\u00051j\u0013\u0001\u00027b]\u001eT\u0011AL\u0001\u0005U\u00064\u0018-\u0003\u00021W\t11\u000b\u001e:j]\u001e\fQ\u0001\u0015:pqf\u0004\"!E\u0004\u0014\u0005\u001d!\u0004CA\t6\u0013\t1DB\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0015\u0003I\u0012Q\u0001V=qK\u0012,\"a\u000f!\u0014\u0007%\u0001B\b\u0005\u0002\u0012\u0001U\ta\b\u0005\u0002@\u00012\u0001A!B!\n\u0005\u0004\u0011%!\u0001+\u0012\u0005\r\u0003\u0002CA\tE\u0013\t)EBA\u0004O_RD\u0017N\\4")
public interface Proxy {
    public Object self();

    public static /* synthetic */ int hashCode$(Proxy $this) {
        return $this.hashCode();
    }

    default public int hashCode() {
        return this.self().hashCode();
    }

    public static /* synthetic */ boolean equals$(Proxy $this, Object that) {
        return $this.equals(that);
    }

    default public boolean equals(Object that) {
        boolean bl = that == null ? false : that == this || that == this.self() || that.equals(this.self());
        return bl;
    }

    public static /* synthetic */ String toString$(Proxy $this) {
        return $this.toString();
    }

    default public String toString() {
        return String.valueOf(this.self());
    }

    public static void $init$(Proxy $this) {
    }

    public static interface Typed<T>
    extends Proxy {
        public T self();
    }
}

