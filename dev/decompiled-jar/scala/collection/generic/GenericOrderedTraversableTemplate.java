/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.Traversable;
import scala.collection.generic.GenericOrderedCompanion;
import scala.collection.generic.HasNewBuilder;
import scala.collection.mutable.Builder;
import scala.math.Ordering;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001m3q!\u0002\u0004\u0011\u0002\u0007\u0005Q\u0002C\u00039\u0001\u0011\u0005\u0011\bC\u0004>\u0001\t\u0007k1\u0003 \t\u000b\u0019\u0003a\u0011A$\t\u000b1\u0003A\u0011A'\u0003C\u001d+g.\u001a:jG>\u0013H-\u001a:fIR\u0013\u0018M^3sg\u0006\u0014G.\u001a+f[Bd\u0017\r^3\u000b\u0005\u001dA\u0011aB4f]\u0016\u0014\u0018n\u0019\u0006\u0003\u0013)\t!bY8mY\u0016\u001cG/[8o\u0015\u0005Y\u0011!B:dC2\f7\u0001A\u000b\u0004\u001de!3c\u0001\u0001\u0010'A\u0011\u0001#E\u0007\u0002\u0015%\u0011!C\u0003\u0002\u0007\u0003:L(+\u001a4\u0011\tQ)rCI\u0007\u0002\r%\u0011aC\u0002\u0002\u000e\u0011\u0006\u001ch*Z<Ck&dG-\u001a:\u0011\u0005aIB\u0002\u0001\u0003\u00075\u0001!)\u0019A\u000e\u0003\u0003\u0005\u000b\"\u0001H\u0010\u0011\u0005Ai\u0012B\u0001\u0010\u000b\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"\u0001\u0005\u0011\n\u0005\u0005R!aA!os*\u00121e\f\t\u00041\u0011:BAB\u0013\u0001\t\u000b\u0007aE\u0001\u0002D\u0007V\u0011q%L\t\u00039!\u00022!\u000b\u0016-\u001b\u0005A\u0011BA\u0016\t\u0005-!&/\u0019<feN\f'\r\\3\u0011\u0005aiC!\u0002\u0018%\u0005\u0004Y\"!\u0001-,\u0003A\u0002\"!\r\u001c\u000e\u0003IR!a\r\u001b\u0002\u0013Ut7\r[3dW\u0016$'BA\u001b\u000b\u0003)\tgN\\8uCRLwN\\\u0005\u0003oI\u0012\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u0003\u0019!\u0013N\\5uIQ\t!\b\u0005\u0002\u0011w%\u0011AH\u0003\u0002\u0005+:LG/A\u0002pe\u0012,\u0012a\u0010\t\u0004\u0001\u000e;bB\u0001\tB\u0013\t\u0011%\"A\u0004qC\u000e\\\u0017mZ3\n\u0005\u0011+%\u0001C(sI\u0016\u0014\u0018N\\4\u000b\u0005\tS\u0011\u0001E8sI\u0016\u0014X\rZ\"p[B\fg.[8o+\u0005A\u0005c\u0001\u000bJ\u0017&\u0011!J\u0002\u0002\u0018\u000f\u0016tWM]5d\u001fJ$WM]3e\u0007>l\u0007/\u00198j_:\u0004\"\u0001\u0007\u0013\u0002+\u001d,g.\u001a:jG>\u0013H-\u001a:fI\n+\u0018\u000e\u001c3feV\u0011aJ\u0016\u000b\u0003\u001ff\u0003B\u0001U*V16\t\u0011K\u0003\u0002S\u0011\u00059Q.\u001e;bE2,\u0017B\u0001+R\u0005\u001d\u0011U/\u001b7eKJ\u0004\"\u0001\u0007,\u0005\u000b]#!\u0019A\u000e\u0003\u0003\t\u00032\u0001\u0007\u0013V\u0011\u0015iD\u0001q\u0001[!\r\u00015)\u0016")
public interface GenericOrderedTraversableTemplate<A, CC extends Traversable<Object>>
extends HasNewBuilder<A, CC> {
    public Ordering<A> ord();

    public GenericOrderedCompanion<CC> orderedCompanion();

    public static /* synthetic */ Builder genericOrderedBuilder$(GenericOrderedTraversableTemplate $this, Ordering ord) {
        return $this.genericOrderedBuilder(ord);
    }

    default public <B> Builder<B, CC> genericOrderedBuilder(Ordering<B> ord) {
        return this.orderedCompanion().newBuilder(ord);
    }

    public static void $init$(GenericOrderedTraversableTemplate $this) {
    }
}

