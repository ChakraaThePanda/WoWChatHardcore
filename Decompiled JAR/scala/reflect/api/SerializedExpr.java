/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import java.io.ObjectStreamException;
import scala.Serializable;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Exprs;
import scala.reflect.api.JavaUniverse;
import scala.reflect.api.Mirror;
import scala.reflect.api.TreeCreator;
import scala.reflect.api.TypeTags;
import scala.reflect.runtime.package$;

@ScalaSignature(bytes="\u0006\u000194Q!\u0003\u0006\u0001\u001dAA\u0001\u0002\u0007\u0001\u0003\u0002\u0004%\tA\u0007\u0005\t?\u0001\u0011\t\u0019!C\u0001A!Aa\u0005\u0001B\u0001B\u0003&1\u0004\u0003\u0005(\u0001\t\u0005\r\u0011\"\u0001)\u0011!i\u0005A!a\u0001\n\u0003q\u0005\u0002C#\u0001\u0005\u0003\u0005\u000b\u0015B\u0015\t\u000bA\u0003A\u0011A)\t\u000be\u0003A\u0011\u0002.\u0003\u001dM+'/[1mSj,G-\u0012=qe*\u00111\u0002D\u0001\u0004CBL'BA\u0007\u000f\u0003\u001d\u0011XM\u001a7fGRT\u0011aD\u0001\u0006g\u000e\fG.Y\n\u0004\u0001E)\u0002C\u0001\n\u0014\u001b\u0005q\u0011B\u0001\u000b\u000f\u0005\u0019\te.\u001f*fMB\u0011!CF\u0005\u0003/9\u0011AbU3sS\u0006d\u0017N_1cY\u0016\fQ\u0001\u001e:fK\u000e\u001c\u0001!F\u0001\u001c!\taR$D\u0001\u000b\u0013\tq\"BA\u0006Ue\u0016,7I]3bi>\u0014\u0018!\u0003;sK\u0016\u001cw\fJ3r)\t\tC\u0005\u0005\u0002\u0013E%\u00111E\u0004\u0002\u0005+:LG\u000fC\u0004&\u0005\u0005\u0005\t\u0019A\u000e\u0002\u0007a$\u0013'\u0001\u0004ue\u0016,7\rI\u0001\u0004i\u0006<W#A\u00151\u0005)\u001a\u0005cA\u0016>\u0003:\u0011AF\u000f\b\u0003[]r!AL\u001b\u000f\u0005=\"dB\u0001\u00194\u001b\u0005\t$B\u0001\u001a\u001a\u0003\u0019a$o\\8u}%\tq\"\u0003\u0002\u000e\u001d%\u0011a\u0007D\u0001\beVtG/[7f\u0013\tA\u0014(A\u0004qC\u000e\\\u0017mZ3\u000b\u0005Yb\u0011BA\u001e=\u0003!)h.\u001b<feN,'B\u0001\u001d:\u0013\tqtHA\u0006XK\u0006\\G+\u001f9f)\u0006<\u0017B\u0001!\u000b\u0005!!\u0016\u0010]3UC\u001e\u001c\bC\u0001\"D\u0019\u0001!\u0011\u0002\u0012\u0004\u0002\u0002\u0003\u0005)\u0011\u0001$\u0003\u0007}#S'\u0001\u0003uC\u001e\u0004\u0013CA$K!\t\u0011\u0002*\u0003\u0002J\u001d\t9aj\u001c;iS:<\u0007C\u0001\nL\u0013\taeBA\u0002B]f\fq\u0001^1h?\u0012*\u0017\u000f\u0006\u0002\"\u001f\"9Q%BA\u0001\u0002\u0004I\u0013A\u0002\u001fj]&$h\bF\u0002S'R\u0003\"\u0001\b\u0001\t\u000ba9\u0001\u0019A\u000e\t\u000b\u001d:\u0001\u0019A+1\u0005YC\u0006cA\u0016>/B\u0011!\t\u0017\u0003\n\tR\u000b\t\u0011!A\u0003\u0002\u0019\u000b1B]3bIJ+7o\u001c7wKR\t\u0011\u0003K\u0002\t9\u001e\u00042AE/`\u0013\tqfB\u0001\u0004uQJ|wo\u001d\t\u0003A\u0016l\u0011!\u0019\u0006\u0003E\u000e\f!![8\u000b\u0003\u0011\fAA[1wC&\u0011a-\u0019\u0002\u0016\u001f\nTWm\u0019;TiJ,\u0017-\\#yG\u0016\u0004H/[8oG\u0005y\u0006\u0006\u0002\u0001jY6\u0004\"A\u00056\n\u0005-t!\u0001E*fe&\fGNV3sg&|g.V%E\u0003\u00151\u0018\r\\;f=\u0005\t\u0001")
public class SerializedExpr
implements Serializable {
    public static final long serialVersionUID = 1L;
    private TreeCreator treec;
    private TypeTags.WeakTypeTag<?> tag;

    public TreeCreator treec() {
        return this.treec;
    }

    public void treec_$eq(TreeCreator x$1) {
        this.treec = x$1;
    }

    public TypeTags.WeakTypeTag<?> tag() {
        return this.tag;
    }

    public void tag_$eq(TypeTags.WeakTypeTag<?> x$1) {
        this.tag = x$1;
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
        return ((Exprs)((Object)package$.MODULE$.universe())).Expr().apply((Mirror)((Object)m), this.treec(), this.tag().in((Mirror)((Object)m)));
    }

    public SerializedExpr(TreeCreator treec, TypeTags.WeakTypeTag<?> tag) {
        this.treec = treec;
        this.tag = tag;
    }
}

