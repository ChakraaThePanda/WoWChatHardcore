/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import java.io.ObjectStreamException;
import scala.Serializable;
import scala.reflect.ScalaSignature;
import scala.reflect.api.JavaUniverse;
import scala.reflect.api.Mirror;
import scala.reflect.api.TypeCreator;
import scala.reflect.api.TypeTags;
import scala.reflect.runtime.package$;

@ScalaSignature(bytes="\u0006\u0001)3Q!\u0003\u0006\u0001\u001dAA\u0001\u0002\u0007\u0001\u0003\u0002\u0004%\tA\u0007\u0005\t?\u0001\u0011\t\u0019!C\u0001A!Aa\u0005\u0001B\u0001B\u0003&1\u0004\u0003\u0005(\u0001\t\u0005\r\u0011\"\u0001)\u0011!a\u0003A!a\u0001\n\u0003i\u0003\u0002C\u0018\u0001\u0005\u0003\u0005\u000b\u0015B\u0015\t\u000bA\u0002A\u0011A\u0019\t\u000bU\u0002A\u0011\u0002\u001c\u0003#M+'/[1mSj,G\rV=qKR\u000bwM\u0003\u0002\f\u0019\u0005\u0019\u0011\r]5\u000b\u00055q\u0011a\u0002:fM2,7\r\u001e\u0006\u0002\u001f\u0005)1oY1mCN\u0019\u0001!E\u000b\u0011\u0005I\u0019R\"\u0001\b\n\u0005Qq!AB!osJ+g\r\u0005\u0002\u0013-%\u0011qC\u0004\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0005iB,7m\u0001\u0001\u0016\u0003m\u0001\"\u0001H\u000f\u000e\u0003)I!A\b\u0006\u0003\u0017QK\b/Z\"sK\u0006$xN]\u0001\tiB,7m\u0018\u0013fcR\u0011\u0011\u0005\n\t\u0003%\tJ!a\t\b\u0003\tUs\u0017\u000e\u001e\u0005\bK\t\t\t\u00111\u0001\u001c\u0003\rAH%M\u0001\u0006iB,7\rI\u0001\tG>t7M]3uKV\t\u0011\u0006\u0005\u0002\u0013U%\u00111F\u0004\u0002\b\u0005>|G.Z1o\u00031\u0019wN\\2sKR,w\fJ3r)\t\tc\u0006C\u0004&\u000b\u0005\u0005\t\u0019A\u0015\u0002\u0013\r|gn\u0019:fi\u0016\u0004\u0013A\u0002\u001fj]&$h\bF\u00023gQ\u0002\"\u0001\b\u0001\t\u000ba9\u0001\u0019A\u000e\t\u000b\u001d:\u0001\u0019A\u0015\u0002\u0017I,\u0017\r\u001a*fg>dg/\u001a\u000b\u0002#!\u001a\u0001\u0002O\"\u0011\u0007II4(\u0003\u0002;\u001d\t1A\u000f\u001b:poN\u0004\"\u0001P!\u000e\u0003uR!AP \u0002\u0005%|'\"\u0001!\u0002\t)\fg/Y\u0005\u0003\u0005v\u0012Qc\u00142kK\u000e$8\u000b\u001e:fC6,\u0005pY3qi&|gnI\u0001<Q\u0011\u0001Q\tS%\u0011\u0005I1\u0015BA$\u000f\u0005A\u0019VM]5bYZ+'o]5p]VKE)A\u0003wC2,XMH\u0001\u0002\u0001")
public class SerializedTypeTag
implements Serializable {
    public static final long serialVersionUID = 1L;
    private TypeCreator tpec;
    private boolean concrete;

    public TypeCreator tpec() {
        return this.tpec;
    }

    public void tpec_$eq(TypeCreator x$1) {
        this.tpec = x$1;
    }

    public boolean concrete() {
        return this.concrete;
    }

    public void concrete_$eq(boolean x$1) {
        this.concrete = x$1;
    }

    private Object readResolve() throws ObjectStreamException {
        ClassLoader classLoader;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        catch (SecurityException securityException) {
            classLoader = null;
        }
        ClassLoader loader = classLoader;
        JavaUniverse.JavaMirror m = package$.MODULE$.universe().runtimeMirror(loader);
        if (this.concrete()) {
            return ((TypeTags)((Object)package$.MODULE$.universe())).TypeTag().apply((Mirror)((Object)m), this.tpec());
        }
        return ((TypeTags)((Object)package$.MODULE$.universe())).WeakTypeTag().apply((Mirror)((Object)m), this.tpec());
    }

    public SerializedTypeTag(TypeCreator tpec, boolean concrete) {
        this.tpec = tpec;
        this.concrete = concrete;
    }
}

