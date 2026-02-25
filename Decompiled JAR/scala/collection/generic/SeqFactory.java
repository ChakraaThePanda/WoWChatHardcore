/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Some;
import scala.collection.Seq;
import scala.collection.generic.GenSeqFactory;
import scala.collection.generic.TraversableFactory;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001y2Qa\u0001\u0003\u0002\u0002-AQa\f\u0001\u0005\u0002ABQA\r\u0001\u0005\u0002M\u0012!bU3r\r\u0006\u001cGo\u001c:z\u0015\t)a!A\u0004hK:,'/[2\u000b\u0005\u001dA\u0011AC2pY2,7\r^5p]*\t\u0011\"A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u00051\u00192c\u0001\u0001\u000eYA\u0019abD\t\u000e\u0003\u0011I!\u0001\u0005\u0003\u0003\u001b\u001d+gnU3r\r\u0006\u001cGo\u001c:z!\t\u00112\u0003\u0004\u0001\u0005\u000bQ\u0001!\u0019A\u000b\u0003\u0005\r\u001bUC\u0001\f$#\t92\u0004\u0005\u0002\u001935\t\u0001\"\u0003\u0002\u001b\u0011\t9aj\u001c;iS:<'c\u0001\u000f\u001fS\u0019!Q\u0004\u0001\u0001\u001c\u00051a$/\u001a4j]\u0016lWM\u001c;?!\ry\u0002EI\u0007\u0002\r%\u0011\u0011E\u0002\u0002\u0004'\u0016\f\bC\u0001\n$\t\u0015!3C1\u0001&\u0005\u0005A\u0016CA\f'!\tAr%\u0003\u0002)\u0011\t\u0019\u0011I\\=\u0011\t9Q#%E\u0005\u0003W\u0011\u0011!dR3oKJL7\r\u0016:bm\u0016\u00148/\u00192mKR+W\u000e\u001d7bi\u0016\u00042AD\u0017\u0012\u0013\tqCA\u0001\nUe\u00064XM]:bE2,g)Y2u_JL\u0018A\u0002\u001fj]&$h\bF\u00012!\rq\u0001!E\u0001\u000bk:\f\u0007\u000f\u001d7z'\u0016\fXC\u0001\u001b;)\t)D\bE\u0002\u0019maJ!a\u000e\u0005\u0003\tM{W.\u001a\t\u0004%MI\u0004C\u0001\n;\t\u0015Y$A1\u0001&\u0005\u0005\t\u0005\"B\u001f\u0003\u0001\u0004A\u0014!\u0001=")
public abstract class SeqFactory<CC extends Seq<Object>>
extends GenSeqFactory<CC>
implements TraversableFactory<CC> {
    public <A> Some<CC> unapplySeq(CC x) {
        return new Some<CC>(x);
    }
}

