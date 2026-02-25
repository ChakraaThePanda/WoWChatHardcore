/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.concurrent;

import scala.Function0;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001A3qa\u0002\u0005\u0011\u0002\u0007\u0005q\u0002C\u0003)\u0001\u0011\u0005\u0011\u0006C\u0003.\u0001\u0019\u0005a\u0006C\u00037\u0001\u0019\u0005q\u0007C\u0003>\u0001\u0019\u0005a\bC\u0003>\u0001\u0019\u0005A\tC\u0003H\u0001\u0011\u0005\u0003JA\u0002NCBT!!\u0003\u0006\u0002\u0015\r|gnY;se\u0016tGO\u0003\u0002\f\u0019\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u00035\tQa]2bY\u0006\u001c\u0001!F\u0002\u00119\u0019\u001a2\u0001A\t\u0016!\t\u00112#D\u0001\r\u0013\t!BB\u0001\u0004B]f\u0014VM\u001a\t\u0005-eQR%D\u0001\u0018\u0015\tA\"\"A\u0004nkR\f'\r\\3\n\u0005\u001d9\u0002CA\u000e\u001d\u0019\u0001!Q!\b\u0001C\u0002y\u0011\u0011!Q\t\u0003?\t\u0002\"A\u0005\u0011\n\u0005\u0005b!a\u0002(pi\"Lgn\u001a\t\u0003%\rJ!\u0001\n\u0007\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\u001cM\u0011)q\u0005\u0001b\u0001=\t\t!)\u0001\u0004%S:LG\u000f\n\u000b\u0002UA\u0011!cK\u0005\u0003Y1\u0011A!\u00168ji\u0006Y\u0001/\u001e;JM\u0006\u00137/\u001a8u)\ry#\u0007\u000e\t\u0004%A*\u0013BA\u0019\r\u0005\u0019y\u0005\u000f^5p]\")1G\u0001a\u00015\u0005\t1\u000eC\u00036\u0005\u0001\u0007Q%A\u0001w\u0003\u0019\u0011X-\\8wKR\u0019\u0001h\u000f\u001f\u0011\u0005II\u0014B\u0001\u001e\r\u0005\u001d\u0011un\u001c7fC:DQaM\u0002A\u0002iAQ!N\u0002A\u0002\u0015\nqA]3qY\u0006\u001cW\r\u0006\u00039\u007f\u0001\u0013\u0005\"B\u001a\u0005\u0001\u0004Q\u0002\"B!\u0005\u0001\u0004)\u0013\u0001C8mIZ\fG.^3\t\u000b\r#\u0001\u0019A\u0013\u0002\u00119,wO^1mk\u0016$2aL#G\u0011\u0015\u0019T\u00011\u0001\u001b\u0011\u0015)T\u00011\u0001&\u0003=9W\r^(s\u000b2\u001cX-\u00169eCR,GcA\u0013J\u0017\")!J\u0002a\u00015\u0005\u00191.Z=\t\r13A\u00111\u0001N\u0003\ty\u0007\u000fE\u0002\u0013\u001d\u0016J!a\u0014\u0007\u0003\u0011q\u0012\u0017P\\1nKz\u0002")
public interface Map<A, B>
extends scala.collection.mutable.Map<A, B> {
    public Option<B> putIfAbsent(A var1, B var2);

    public boolean remove(A var1, B var2);

    public boolean replace(A var1, B var2, B var3);

    public Option<B> replace(A var1, B var2);

    public static /* synthetic */ Object getOrElseUpdate$(Map $this, Object key, Function0 op) {
        return $this.getOrElseUpdate((A)key, op);
    }

    @Override
    default public B getOrElseUpdate(A key, Function0<B> op) {
        Object a;
        Option option = this.get(key);
        if (option instanceof Some) {
            a = ((Some)option).value();
        } else if (None$.MODULE$.equals(option)) {
            Object object;
            B v = op.apply();
            Option<B> option2 = this.putIfAbsent(key, v);
            if (option2 instanceof Some) {
                object = ((Some)option2).value();
            } else if (None$.MODULE$.equals(option2)) {
                object = v;
            } else {
                throw new MatchError(option2);
            }
            a = object;
        } else {
            throw new MatchError(option);
        }
        return (B)a;
    }

    public static void $init$(Map $this) {
    }
}

