/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.Parallel;
import scala.collection.generic.CanBuildFrom;
import scala.collection.parallel.Combiner;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001U2qa\u0001\u0003\u0011\u0002G\u00051\u0002C\u0003+\u0001\u0019\u00051\u0006C\u0003+\u0001\u0019\u0005AG\u0001\bDC:\u001cu.\u001c2j]\u00164%o\\7\u000b\u0005\u00151\u0011aB4f]\u0016\u0014\u0018n\u0019\u0006\u0003\u000f!\t!bY8mY\u0016\u001cG/[8o\u0015\u0005I\u0011!B:dC2\f7\u0001A\u000b\u0005\u0019]\tCe\u0005\u0003\u0001\u001bE1\u0003C\u0001\b\u0010\u001b\u0005A\u0011B\u0001\t\t\u0005\u0019\te.\u001f*fMB)!cE\u000b!G5\tA!\u0003\u0002\u0015\t\ta1)\u00198Ck&dGM\u0012:p[B\u0011ac\u0006\u0007\u0001\t\u0019A\u0002\u0001#b\u00013\t!aI]8n#\tQR\u0004\u0005\u0002\u000f7%\u0011A\u0004\u0003\u0002\b\u001d>$\b.\u001b8h!\tqa$\u0003\u0002 \u0011\t\u0019\u0011I\\=\u0011\u0005Y\tCA\u0002\u0012\u0001\u0011\u000b\u0007\u0011D\u0001\u0003FY\u0016l\u0007C\u0001\f%\t\u0019)\u0003\u0001\"b\u00013\t\u0011Ak\u001c\t\u0003O!j\u0011AB\u0005\u0003S\u0019\u0011\u0001\u0002U1sC2dW\r\\\u0001\u0006CB\u0004H.\u001f\u000b\u0003YI\u0002B!\f\u0019!G5\taF\u0003\u00020\r\u0005A\u0001/\u0019:bY2,G.\u0003\u00022]\tA1i\\7cS:,'\u000fC\u00034\u0003\u0001\u0007Q#\u0001\u0003ge>lG#\u0001\u0017")
public interface CanCombineFrom<From, Elem, To>
extends CanBuildFrom<From, Elem, To>,
Parallel {
    @Override
    public Combiner<Elem, To> apply(From var1);

    @Override
    public Combiner<Elem, To> apply();
}

