/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.GenTraversableLike;
import scala.collection.Iterator;
import scala.collection.generic.CanBuildFrom;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000194qAB\u0004\u0011\u0002G\u0005A\u0002C\u0003\"\u0001\u0019\u0005!\u0005C\u0003'\u0001\u0019\u0005q\u0005C\u00036\u0001\u0019\u0005a\u0007C\u0003O\u0001\u0019\u0005q\nC\u0003\\\u0001\u0019\u0005ALA\bHK:LE/\u001a:bE2,G*[6f\u0015\tA\u0011\"\u0001\u0006d_2dWm\u0019;j_:T\u0011AC\u0001\u0006g\u000e\fG.Y\u0002\u0001+\ri\u0001dH\n\u0004\u00019\u0011\u0002CA\b\u0011\u001b\u0005I\u0011BA\t\n\u0005\r\te.\u001f\t\u0005'Q1b$D\u0001\b\u0013\t)rA\u0001\nHK:$&/\u0019<feN\f'\r\\3MS.,\u0007CA\f\u0019\u0019\u0001!a!\u0007\u0001\u0005\u0006\u0004Q\"!A!\u0012\u0005mq\u0001CA\b\u001d\u0013\ti\u0012BA\u0004O_RD\u0017N\\4\u0011\u0005]yBA\u0002\u0011\u0001\t\u000b\u0007!D\u0001\u0003SKB\u0014\u0018\u0001C5uKJ\fGo\u001c:\u0016\u0003\r\u00022a\u0005\u0013\u0017\u0013\t)sA\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u00031\u0019\u0018-\\3FY\u0016lWM\u001c;t+\tA#\u0007\u0006\u0002*YA\u0011qBK\u0005\u0003W%\u0011qAQ8pY\u0016\fg\u000eC\u0003.\u0005\u0001\u0007a&\u0001\u0003uQ\u0006$\bcA\n0c%\u0011\u0001g\u0002\u0002\f\u000f\u0016t\u0017\n^3sC\ndW\r\u0005\u0002\u0018e\u0011)1G\u0001b\u0001i\t\u0011\u0011)M\t\u0003-9\t1A_5q+\u00119\u0004J\u0013\u001e\u0015\u0005abECA\u001d=!\t9\"\bB\u0003<\u0007\t\u0007!D\u0001\u0003UQ\u0006$\b\"B\u001f\u0004\u0001\bq\u0014A\u00012g!\u0015y$I\b#:\u001b\u0005\u0001%BA!\b\u0003\u001d9WM\\3sS\u000eL!a\u0011!\u0003\u0019\r\u000bgNQ;jY\u00124%o\\7\u0011\t=)u)S\u0005\u0003\r&\u0011a\u0001V;qY\u0016\u0014\u0004CA\fI\t\u0015\u00194A1\u00015!\t9\"\nB\u0003L\u0007\t\u0007!DA\u0001C\u0011\u0015i3\u00011\u0001N!\r\u0019r&S\u0001\ru&\u0004x+\u001b;i\u0013:$W\r_\u000b\u0004!^\u0013FCA)T!\t9\"\u000bB\u0003<\t\t\u0007!\u0004C\u0003>\t\u0001\u000fA\u000bE\u0003@\u0005z)\u0016\u000b\u0005\u0003\u0010\u000bZC\u0006CA\fX\t\u0015\u0019DA1\u00015!\ty\u0011,\u0003\u0002[\u0013\t\u0019\u0011J\u001c;\u0002\riL\u0007/\u00117m+\u0011iv-\u001a1\u0015\tyC'\u000e\u001c\u000b\u0003?\u0006\u0004\"a\u00061\u0005\u000bm*!\u0019\u0001\u000e\t\u000bu*\u00019\u00012\u0011\u000b}\u0012edY0\u0011\t=)EM\u001a\t\u0003/\u0015$QaM\u0003C\u0002Q\u0002\"aF4\u0005\u000b-+!\u0019\u0001\u000e\t\u000b5*\u0001\u0019A5\u0011\u0007Myc\rC\u0003l\u000b\u0001\u0007A-\u0001\u0005uQ&\u001cX\t\\3n\u0011\u0015iW\u00011\u0001g\u0003!!\b.\u0019;FY\u0016l\u0007")
public interface GenIterableLike<A, Repr>
extends GenTraversableLike<A, Repr> {
    public Iterator<A> iterator();

    public <A1> boolean sameElements(GenIterable<A1> var1);

    public <A1, B, That> That zip(GenIterable<B> var1, CanBuildFrom<Repr, Tuple2<A1, B>, That> var2);

    public <A1, That> That zipWithIndex(CanBuildFrom<Repr, Tuple2<A1, Object>, That> var1);

    public <B, A1, That> That zipAll(GenIterable<B> var1, A1 var2, B var3, CanBuildFrom<Repr, Tuple2<A1, B>, That> var4);
}

