/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.parallel.mutable;

import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.mutable.Cloneable;
import scala.collection.mutable.Set;
import scala.collection.mutable.SetLike;
import scala.collection.parallel.mutable.ParSet;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u001d4qa\u0002\u0005\u0011\u0002\u0007\u0005\u0011\u0003C\u0003S\u0001\u0011\u00051\u000bC\u0003X\u0001\u0019\u0005\u0003\fC\u0003Z\u0001\u0019\u0005!\fC\u0003_\u0001\u0019\u0005q\fC\u0003b\u0001\u0011\u0005!\rC\u0003e\u0001\u0011\u0005QM\u0001\u0006QCJ\u001cV\r\u001e'jW\u0016T!!\u0003\u0006\u0002\u000f5,H/\u00192mK*\u00111\u0002D\u0001\ta\u0006\u0014\u0018\r\u001c7fY*\u0011QBD\u0001\u000bG>dG.Z2uS>t'\"A\b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U!!#H\u00141'!\u00011c\u0006!E\r2{\u0005C\u0001\u000b\u0016\u001b\u0005q\u0011B\u0001\f\u000f\u0005\u0019\te.\u001f*fMB!\u0001$G\u000e'\u001b\u0005a\u0011B\u0001\u000e\r\u0005)9UM\\*fi2K7.\u001a\t\u00039ua\u0001\u0001B\u0003\u001f\u0001\t\u0007qDA\u0001U#\t\u00013\u0005\u0005\u0002\u0015C%\u0011!E\u0004\u0002\b\u001d>$\b.\u001b8h!\t!B%\u0003\u0002&\u001d\t\u0019\u0011I\\=\u0011\u0005q9CA\u0002\u0015\u0001\t\u000b\u0007\u0011F\u0001\u0003SKB\u0014\u0018C\u0001\u0011+%\rYS&\u0010\u0004\u0005Y\u0001\u0001!F\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0003/\u0001m1s&D\u0001\t!\ta\u0002\u0007\u0002\u00042\u0001\u0011\u0015\rA\r\u0002\u000b'\u0016\fX/\u001a8uS\u0006d\u0017C\u0001\u00114%\r!TG\u000f\u0004\u0005Y\u0001\u00011\u0007E\u00027qmi\u0011a\u000e\u0006\u0003\u00131I!!O\u001c\u0003\u0007M+G\u000f\u0005\u00037wmy\u0013B\u0001\u001f8\u0005\u001d\u0019V\r\u001e'jW\u0016\u00042A\f \u001c\u0013\ty\u0004B\u0001\u0004QCJ\u001cV\r\u001e\t\u0006\u0003\n[beL\u0007\u0002\u0015%\u00111I\u0003\u0002\u0010!\u0006\u0014\u0018\n^3sC\ndW\rT5lKB)\u0011)R\u000e'_%\u0011qA\u0003\t\u0004\u000f*[R\"\u0001%\u000b\u0005%c\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003\u0017\"\u0013\u0001b\u0012:po\u0006\u0014G.\u001a\t\u0004\u000f6[\u0012B\u0001(I\u0005)\u0019\u0006N]5oW\u0006\u0014G.\u001a\t\u0004mA3\u0013BA)8\u0005%\u0019En\u001c8fC\ndW-\u0001\u0004%S:LG\u000f\n\u000b\u0002)B\u0011A#V\u0005\u0003-:\u0011A!\u00168ji\u0006)Q-\u001c9usV\ta%\u0001\u0005%a2,8\u000fJ3r)\tYF,D\u0001\u0001\u0011\u0015i6\u00011\u0001\u001c\u0003\u0011)G.Z7\u0002\u0013\u0011j\u0017N\\;tI\u0015\fHCA.a\u0011\u0015iF\u00011\u0001\u001c\u0003\u0015!\u0003\u000f\\;t)\t13\rC\u0003^\u000b\u0001\u00071$\u0001\u0004%[&tWo\u001d\u000b\u0003M\u0019DQ!\u0018\u0004A\u0002m\u0001")
public interface ParSetLike<T, Repr extends ParSetLike<T, Repr, Sequential> & ParSet<T>, Sequential extends Set<T> & SetLike<T, Sequential>>
extends scala.collection.parallel.ParSetLike<T, Repr, Sequential>,
Growable<T>,
Shrinkable<T>,
Cloneable<Repr> {
    @Override
    public Repr empty();

    public ParSetLike<T, Repr, Sequential> $plus$eq(T var1);

    public ParSetLike<T, Repr, Sequential> $minus$eq(T var1);

    public static /* synthetic */ ParSet $plus$(ParSetLike $this, Object elem) {
        return $this.$plus((T)elem);
    }

    @Override
    default public Repr $plus(T elem) {
        return (Repr)((ParSet)((ParSetLike)this.clone()).$plus$eq(elem));
    }

    public static /* synthetic */ ParSet $minus$(ParSetLike $this, Object elem) {
        return $this.$minus((T)elem);
    }

    @Override
    default public Repr $minus(T elem) {
        return (Repr)((ParSet)((ParSetLike)this.clone()).$minus$eq(elem));
    }

    public static void $init$(ParSetLike $this) {
    }
}

