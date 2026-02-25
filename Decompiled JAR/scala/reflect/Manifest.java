/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import scala.Predef$;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.package$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001e3qa\u0002\u0005\u0011\u0002\u0007\u0005Q\u0002C\u0003*\u0001\u0011\u0005!\u0006C\u0003/\u0001\u0011\u0005s\u0006C\u0003<\u0001\u0011\u0005C\bC\u0003B\u0001\u0011\u0005#\tC\u0003I\u0001\u0011\u0005\u0013\nC\u0003L\u0001\u0011\u0005CJ\u0001\u0005NC:Lg-Z:u\u0015\tI!\"A\u0004sK\u001adWm\u0019;\u000b\u0003-\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u000f;M!\u0001aD\n'!\t\u0001\u0012#D\u0001\u000b\u0013\t\u0011\"B\u0001\u0004B]f\u0014VM\u001a\t\u0004)aYbBA\u000b\u0017\u001b\u0005A\u0011BA\f\t\u0003\u001d\u0001\u0018mY6bO\u0016L!!\u0007\u000e\u0003\u001b\rc\u0017m]:NC:Lg-Z:u\u0015\t9\u0002\u0002\u0005\u0002\u001d;1\u0001A!\u0002\u0010\u0001\u0005\u0004y\"!\u0001+\u0012\u0005\u0001\u001a\u0003C\u0001\t\"\u0013\t\u0011#BA\u0004O_RD\u0017N\\4\u0011\u0005A!\u0013BA\u0013\u000b\u0005\r\te.\u001f\t\u0003!\u001dJ!\u0001\u000b\u0006\u0003\r\u0015\u000bX/\u00197t\u0003\u0019!\u0013N\\5uIQ\t1\u0006\u0005\u0002\u0011Y%\u0011QF\u0003\u0002\u0005+:LG/A\u0007usB,\u0017I]4v[\u0016tGo]\u000b\u0002aA\u0019\u0011g\r\u001c\u000f\u0005A\u0011\u0014BA\f\u000b\u0013\t!TG\u0001\u0003MSN$(BA\f\u000ba\t9\u0014\bE\u0002\u0016\u0001a\u0002\"\u0001H\u001d\u0005\u0013i\u0012\u0011\u0011!A\u0001\u0006\u0003y\"aA0%c\u0005i\u0011M\u001d:bs6\u000bg.\u001b4fgR,\u0012!\u0010\t\u0004+\u0001q\u0004c\u0001\t@7%\u0011\u0001I\u0003\u0002\u0006\u0003J\u0014\u0018-_\u0001\tG\u0006tW)];bYR\u00111I\u0012\t\u0003!\u0011K!!\u0012\u0006\u0003\u000f\t{w\u000e\\3b]\")q\t\u0002a\u0001G\u0005!A\u000f[1u\u0003\u0019)\u0017/^1mgR\u00111I\u0013\u0005\u0006\u000f\u0016\u0001\raI\u0001\tQ\u0006\u001c\bnQ8eKR\tQ\n\u0005\u0002\u0011\u001d&\u0011qJ\u0003\u0002\u0004\u0013:$\bf\u0001\u0001R/B\u0011!+V\u0007\u0002'*\u0011AKC\u0001\u000bC:tw\u000e^1uS>t\u0017B\u0001,T\u0005AIW\u000e\u001d7jG&$hj\u001c;G_VtG-I\u0001Y\u0003}qu\u000eI'b]&4Wm\u001d;!CZ\f\u0017\u000e\\1cY\u0016\u0004cm\u001c:!Im$VP\f")
public interface Manifest<T>
extends ClassTag<T> {
    public static /* synthetic */ List typeArguments$(Manifest $this) {
        return $this.typeArguments();
    }

    @Override
    default public List<Manifest<?>> typeArguments() {
        return Nil$.MODULE$;
    }

    public static /* synthetic */ Manifest arrayManifest$(Manifest $this) {
        return $this.arrayManifest();
    }

    default public Manifest<Object> arrayManifest() {
        return package$.MODULE$.Manifest().classType(this.arrayClass(this.runtimeClass()), this, Predef$.MODULE$.wrapRefArray((Object[])new Manifest[0]));
    }

    public static /* synthetic */ boolean canEqual$(Manifest $this, Object that) {
        return $this.canEqual(that);
    }

    @Override
    default public boolean canEqual(Object that) {
        boolean bl = that instanceof Manifest;
        return bl;
    }

    public static /* synthetic */ boolean equals$(Manifest $this, Object that) {
        return $this.equals(that);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    default public boolean equals(Object that) {
        if (!(that instanceof Manifest)) return false;
        Manifest manifest = (Manifest)that;
        if (!manifest.canEqual(this)) return false;
        Class<?> clazz = this.runtimeClass();
        Class<?> clazz2 = manifest.runtimeClass();
        if (clazz == null) {
            if (clazz2 != null) {
                return false;
            }
        } else if (!clazz.equals(clazz2)) return false;
        if (!this.$less$colon$less(manifest)) return false;
        if (!manifest.$less$colon$less(this)) return false;
        return true;
    }

    public static /* synthetic */ int hashCode$(Manifest $this) {
        return $this.hashCode();
    }

    @Override
    default public int hashCode() {
        return Statics.anyHash(this.runtimeClass());
    }

    public static void $init$(Manifest $this) {
    }
}

