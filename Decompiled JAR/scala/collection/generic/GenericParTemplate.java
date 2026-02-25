/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericParCompanion;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.HasNewCombiner;
import scala.collection.mutable.Builder;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.ParIterable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000114qa\u0002\u0005\u0011\u0002\u0007\u0005q\u0002C\u0003A\u0001\u0011\u0005\u0011\tC\u0003F\u0001\u0019\u0005a\t\u0003\u0004Q\u0001\u0001&\t&\u0015\u0005\u00071\u0002\u0001K\u0011K-\t\u000bu\u0003A\u0011\t0\t\u000b\u0015\u0004A\u0011\u00014\u0003%\u001d+g.\u001a:jGB\u000b'\u000fV3na2\fG/\u001a\u0006\u0003\u0013)\tqaZ3oKJL7M\u0003\u0002\f\u0019\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u00035\tQa]2bY\u0006\u001c\u0001!F\u0002\u00117\u0015\u001aB\u0001A\t\u0016eA\u0011!cE\u0007\u0002\u0019%\u0011A\u0003\u0004\u0002\u0007\u0003:L(+\u001a4\u0011\tY9\u0012\u0004J\u0007\u0002\u0011%\u0011\u0001\u0004\u0003\u0002\u001b\u000f\u0016tWM]5d)J\fg/\u001a:tC\ndW\rV3na2\fG/\u001a\t\u00035ma\u0001\u0001\u0002\u0004\u001d\u0001\u0011\u0015\r!\b\u0002\u0002\u0003F\u0011a$\t\t\u0003%}I!\u0001\t\u0007\u0003\u000f9{G\u000f[5oOB\u0011!CI\u0005\u0003G1\u00111!\u00118z!\tQR\u0005\u0002\u0004'\u0001\u0011\u0015\ra\n\u0002\u0003\u0007\u000e+\"\u0001\u000b\u0019\u0012\u0005yI\u0003c\u0001\u0016._5\t1F\u0003\u0002-\u0015\u0005A\u0001/\u0019:bY2,G.\u0003\u0002/W\tY\u0001+\u0019:Ji\u0016\u0014\u0018M\u00197f!\tQ\u0002\u0007B\u00032K\t\u0007QDA\u0001Y!\u001112'G\u001b\n\u0005QB!A\u0004%bg:+woQ8nE&tWM\u001d\u0016\u0003m]\u00022AG\u0013\u001aW\u0005A\u0004CA\u001d?\u001b\u0005Q$BA\u001e=\u0003%)hn\u00195fG.,GM\u0003\u0002>\u0019\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005}R$!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u00061A%\u001b8ji\u0012\"\u0012A\u0011\t\u0003%\rK!\u0001\u0012\u0007\u0003\tUs\u0017\u000e^\u0001\nG>l\u0007/\u00198j_:,\u0012a\u0012\n\u0004\u0011*ke\u0001B%\u0001\u0001\u001d\u0013A\u0002\u0010:fM&tW-\\3oiz\u00022AF&%\u0013\ta\u0005B\u0001\tHK:,'/[2D_6\u0004\u0018M\\5p]B\u0019aC\u0014\u0013\n\u0005=C!aE$f]\u0016\u0014\u0018n\u0019)be\u000e{W\u000e]1oS>t\u0017A\u00038fo\n+\u0018\u000e\u001c3feV\t!\u000b\u0005\u0003T-f1T\"\u0001+\u000b\u0005US\u0011aB7vi\u0006\u0014G.Z\u0005\u0003/R\u0013qAQ;jY\u0012,'/A\u0006oK^\u001cu.\u001c2j]\u0016\u0014X#\u0001.\u0011\t)Z\u0016DN\u0005\u00039.\u0012\u0001bQ8nE&tWM]\u0001\u000fO\u0016tWM]5d\u0005VLG\u000eZ3s+\ty&-F\u0001a!\u0011Q3,\u00193\u0011\u0005i\u0011G!B2\u0006\u0005\u0004i\"!\u0001\"\u0011\u0007i)\u0013-A\bhK:,'/[2D_6\u0014\u0017N\\3s+\t9'.F\u0001i!\u0011Q3,[6\u0011\u0005iQG!B2\u0007\u0005\u0004i\u0002c\u0001\u000e&S\u0002")
public interface GenericParTemplate<A, CC extends ParIterable<Object>>
extends GenericTraversableTemplate<A, CC>,
HasNewCombiner<A, CC> {
    @Override
    public GenericCompanion<CC> companion();

    public static /* synthetic */ Builder newBuilder$(GenericParTemplate $this) {
        return $this.newBuilder();
    }

    @Override
    default public Builder<A, CC> newBuilder() {
        return this.newCombiner();
    }

    public static /* synthetic */ Combiner newCombiner$(GenericParTemplate $this) {
        return $this.newCombiner();
    }

    @Override
    default public Combiner<A, CC> newCombiner() {
        return ((GenericParCompanion)((Object)this.companion())).newCombiner();
    }

    public static /* synthetic */ Combiner genericBuilder$(GenericParTemplate $this) {
        return $this.genericBuilder();
    }

    @Override
    default public <B> Combiner<B, CC> genericBuilder() {
        return this.genericCombiner();
    }

    public static /* synthetic */ Combiner genericCombiner$(GenericParTemplate $this) {
        return $this.genericCombiner();
    }

    default public <B> Combiner<B, CC> genericCombiner() {
        return ((GenericParCompanion)((Object)this.companion())).newCombiner();
    }

    public static void $init$(GenericParTemplate $this) {
    }
}

