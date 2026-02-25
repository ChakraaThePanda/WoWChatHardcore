/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Tuple2;
import scala.collection.generic.GenericParMapCompanion;
import scala.collection.generic.GenericParTemplate;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.collection.parallel.ParMap;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001a3q!\u0002\u0004\u0011\u0002\u0007\u0005Q\u0002C\u0003/\u0001\u0011\u0005q\u0006\u0003\u00044\u0001\u0001&\t\u0006\u000e\u0005\u0006\r\u00021\ta\u0012\u0005\u0006\u0019\u0002!\t!\u0014\u0002\u0016\u000f\u0016tWM]5d!\u0006\u0014X*\u00199UK6\u0004H.\u0019;f\u0015\t9\u0001\"A\u0004hK:,'/[2\u000b\u0005%Q\u0011AC2pY2,7\r^5p]*\t1\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\t9ab%O\n\u0004\u0001=\u0019\u0002C\u0001\t\u0012\u001b\u0005Q\u0011B\u0001\n\u000b\u0005\u0019\te.\u001f*fMB!A#F\f)\u001b\u00051\u0011B\u0001\f\u0007\u0005I9UM\\3sS\u000e\u0004\u0016M\u001d+f[Bd\u0017\r^3\u0011\tAA\"$J\u0005\u00033)\u0011a\u0001V;qY\u0016\u0014\u0004CA\u000e\u001d\u0019\u0001!Q!\b\u0001C\u0002y\u0011\u0011aS\t\u0003?\t\u0002\"\u0001\u0005\u0011\n\u0005\u0005R!a\u0002(pi\"Lgn\u001a\t\u0003!\rJ!\u0001\n\u0006\u0003\u0007\u0005s\u0017\u0010\u0005\u0002\u001cM\u00111q\u0005\u0001CC\u0002y\u0011\u0011A\u0016\t\u0003S1j\u0011A\u000b\u0006\u0003W!\t\u0001\u0002]1sC2dW\r\\\u0005\u0003[)\u00121\u0002U1s\u0013R,'/\u00192mK\u00061A%\u001b8ji\u0012\"\u0012\u0001\r\t\u0003!EJ!A\r\u0006\u0003\tUs\u0017\u000e^\u0001\f]\u0016<8i\\7cS:,'/F\u00016!\u0011Icg\u0006\u001d\n\u0005]R#\u0001C\"p[\nLg.\u001a:\u0011\tmI$$\n\u0003\u0007u\u0001!)\u0019A\u001e\u0003\u0005\r\u001bUc\u0001\u001fB\tF\u0011q$\u0010\t\u0005Sy\u00025)\u0003\u0002@U\t1\u0001+\u0019:NCB\u0004\"aG!\u0005\u000b\tK$\u0019\u0001\u0010\u0003\u0003a\u0003\"a\u0007#\u0005\u000b\u0015K$\u0019\u0001\u0010\u0003\u0003e\u000bA\"\\1q\u0007>l\u0007/\u00198j_:,\u0012\u0001\u0013\t\u0004)%[\u0015B\u0001&\u0007\u0005Y9UM\\3sS\u000e\u0004\u0016M]'ba\u000e{W\u000e]1oS>t\u0007CA\u000e:\u0003I9WM\\3sS\u000el\u0015\r]\"p[\nLg.\u001a:\u0016\u00079\u0013V+F\u0001P!\u0011Ic\u0007U,\u0011\tAA\u0012\u000b\u0016\t\u00037I#Qa\u0015\u0003C\u0002y\u0011\u0011\u0001\u0015\t\u00037U#QA\u0016\u0003C\u0002y\u0011\u0011!\u0015\t\u00057e\nF\u000b")
public interface GenericParMapTemplate<K, V, CC extends ParMap<Object, Object>>
extends GenericParTemplate<Tuple2<K, V>, ParIterable> {
    public static /* synthetic */ Combiner newCombiner$(GenericParMapTemplate $this) {
        return $this.newCombiner();
    }

    @Override
    default public Combiner<Tuple2<K, V>, CC> newCombiner() {
        return this.mapCompanion().newCombiner();
    }

    public GenericParMapCompanion<CC> mapCompanion();

    public static /* synthetic */ Combiner genericMapCombiner$(GenericParMapTemplate $this) {
        return $this.genericMapCombiner();
    }

    default public <P, Q> Combiner<Tuple2<P, Q>, CC> genericMapCombiner() {
        return this.mapCompanion().newCombiner();
    }

    public static void $init$(GenericParMapTemplate $this) {
    }
}

