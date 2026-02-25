/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.PartialFunction;
import scala.Tuple2;
import scala.collection.GenMap;
import scala.collection.GenTraversableOnce;
import scala.collection.Parallelizable;
import scala.collection.generic.CanBuildFrom;
import scala.collection.parallel.ParIterable;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\tuba\u0002\u0010 !\u0003\r\n\u0001\n\u0005\u0006\u007f\u00011\t\u0001\u0011\u0005\u0006\t\u00021\t!\u0012\u0005\u0006\u0013\u00021\tA\u0013\u0005\u0006\u0017\u00021\t\u0001\u0014\u0005\u0006!\u00021\t!\u0015\u0005\u0006+\u00021\t\u0001\u0011\u0005\u0006-\u00021\tA\u0013\u0005\u0006/\u00021\t\u0001\u0014\u0005\u00061\u00021\t\u0001\u0011\u0005\u00063\u00021\tA\u0017\u0005\u0006i\u00021\t!\u001e\u0005\b\u0003\u000f\u0001a\u0011AA\u0005\u0011\u001d\tI\u0004\u0001D\u0001\u0003wAq!!\u0016\u0001\r\u0003\t9\u0006C\u0004\u0002n\u00011\t!a\u001c\t\u000f\u0005-\u0005A\"\u0001\u0002\u000e\"9\u0011Q\u0015\u0001\u0007\u0002\u0005\u001d\u0006bBA`\u0001\u0019\u0005\u0011\u0011\u0019\u0005\b\u0003\u0013\u0004a\u0011AAf\u0011\u001d\ty\r\u0001D\u0001\u0003#Dq!a7\u0001\r\u0003\ti\u000eC\u0004\u0002r\u00021\t!a=\t\u000f\u0005e\bA\"\u0001\u0002|\"9\u0011q \u0001\u0007\u0002\t\u0005\u0001b\u0002B\u0006\u0001\u0019\u0005!Q\u0002\u0005\b\u0005#\u0001a\u0011\u0001B\n\u0011\u001d\u00119\u0002\u0001D\u0001\u00053AqA!\b\u0001\r\u0003\u0011y\u0002C\u0004\u0003$\u00011\tA!\n\u0003%\u001d+g\u000e\u0016:bm\u0016\u00148/\u00192mK2K7.\u001a\u0006\u0003A\u0005\n!bY8mY\u0016\u001cG/[8o\u0015\u0005\u0011\u0013!B:dC2\f7\u0001A\u000b\u0004KA\u00125\u0003\u0002\u0001'UY\u0002\"a\n\u0015\u000e\u0003\u0005J!!K\u0011\u0003\u0007\u0005s\u0017\u0010E\u0002,Y9j\u0011aH\u0005\u0003[}\u0011!cR3o)J\fg/\u001a:tC\ndWm\u00148dKB\u0011q\u0006\r\u0007\u0001\t\u0019\t\u0004\u0001\"b\u0001e\t\t\u0011)\u0005\u00024MA\u0011q\u0005N\u0005\u0003k\u0005\u0012qAT8uQ&tw\r\u0005\u0003,o9J\u0014B\u0001\u001d \u00059\u0001\u0016M]1mY\u0016d\u0017N_1cY\u0016\u00042AO\u001f/\u001b\u0005Y$B\u0001\u001f \u0003!\u0001\u0018M]1mY\u0016d\u0017B\u0001 <\u0005-\u0001\u0016M]%uKJ\f'\r\\3\u0002\tI,\u0007O]\u000b\u0002\u0003B\u0011qF\u0011\u0003\u0007\u0007\u0002!)\u0019\u0001\u001a\u0003\tI+\u0007O]\u0001\u0005g&TX-F\u0001G!\t9s)\u0003\u0002IC\t\u0019\u0011J\u001c;\u0002\t!,\u0017\rZ\u000b\u0002]\u0005Q\u0001.Z1e\u001fB$\u0018n\u001c8\u0016\u00035\u00032a\n(/\u0013\ty\u0015E\u0001\u0004PaRLwN\\\u0001\u0013SN$&/\u0019<feN\f'\r\\3BO\u0006Lg.F\u0001S!\t93+\u0003\u0002UC\t9!i\\8mK\u0006t\u0017\u0001\u0002;bS2\fA\u0001\\1ti\u0006QA.Y:u\u001fB$\u0018n\u001c8\u0002\t%t\u0017\u000e^\u0001\u0005g\u000e\fg.F\u0002\\U~#\"\u0001\u0018:\u0015\u0005ukGC\u00010b!\tys\fB\u0003a\u0015\t\u0007!G\u0001\u0003UQ\u0006$\b\"\u00022\u000b\u0001\b\u0019\u0017aA2cMB)AmZ!j=6\tQM\u0003\u0002g?\u00059q-\u001a8fe&\u001c\u0017B\u00015f\u00051\u0019\u0015M\u001c\"vS2$gI]8n!\ty#\u000eB\u0003l\u0015\t\u0007ANA\u0001C#\tqc\u0005C\u0003o\u0015\u0001\u0007q.\u0001\u0002paB)q\u0005]5jS&\u0011\u0011/\t\u0002\n\rVt7\r^5p]JBQa\u001d\u0006A\u0002%\f\u0011A_\u0001\tg\u000e\fg\u000eT3giV\u0019ao >\u0015\u0007]\f)\u0001F\u0002y\u0003\u0003!\"!_>\u0011\u0005=RH!\u00021\f\u0005\u0004\u0011\u0004\"\u0002?\f\u0001\bi\u0018A\u00012g!\u0015!w-\u0011@z!\tys\u0010B\u0003l\u0017\t\u0007!\u0007\u0003\u0004o\u0017\u0001\u0007\u00111\u0001\t\u0006OAthF \u0005\u0006g.\u0001\rA`\u0001\ng\u000e\fgNU5hQR,b!a\u0003\u0002\u001c\u0005MA\u0003BA\u0007\u0003C!B!a\u0004\u0002\u001eQ!\u0011\u0011CA\u000b!\ry\u00131\u0003\u0003\u0006A2\u0011\rA\r\u0005\u0007y2\u0001\u001d!a\u0006\u0011\u000f\u0011<\u0017)!\u0007\u0002\u0012A\u0019q&a\u0007\u0005\u000b-d!\u0019\u0001\u001a\t\r9d\u0001\u0019AA\u0010!\u001d9\u0003OLA\r\u00033Aaa\u001d\u0007A\u0002\u0005e\u0001f\u0002\u0007\u0002&\u0005E\u0012Q\u0007\t\u0005\u0003O\ti#\u0004\u0002\u0002*)\u0019\u00111F\u0011\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u00020\u0005%\"!C7jOJ\fG/[8oC\t\t\u0019$\u00015UQ\u0016\u0004#-\u001a5bm&|'\u000fI8gA\u0001\u001c8-\u00198SS\u001eDG\u000f\u0019\u0011iCN\u00043\r[1oO\u0016$g\u0006\t+iK\u0002\u0002(/\u001a<j_V\u001c\bEY3iCZLwN\u001d\u0011dC:\u0004#-\u001a\u0011sKB\u0014x\u000eZ;dK\u0012\u0004s/\u001b;iAM\u001c\u0017M\u001c*jO\"$hF]3wKJ\u001cXML\u0011\u0003\u0003o\tQA\r\u0018:]A\nqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0002>\u0005EC\u0003BA \u0003\u000b\u00022aJA!\u0013\r\t\u0019%\t\u0002\u0005+:LG\u000fC\u0004\u0002H5\u0001\r!!\u0013\u0002\u0003\u0019\u0004baJA&]\u0005=\u0013bAA'C\tIa)\u001e8di&|g.\r\t\u0004_\u0005ECABA*\u001b\t\u0007!GA\u0001V\u0003\ri\u0017\r]\u000b\u0007\u00033\n9'a\u0018\u0015\t\u0005m\u0013\u0011\u000e\u000b\u0005\u0003;\n\t\u0007E\u00020\u0003?\"Q\u0001\u0019\bC\u0002IBa\u0001 \bA\u0004\u0005\r\u0004c\u00023h\u0003\u0006\u0015\u0014Q\f\t\u0004_\u0005\u001dD!B6\u000f\u0005\u0004\u0011\u0004bBA$\u001d\u0001\u0007\u00111\u000e\t\u0007O\u0005-c&!\u001a\u0002\u000f\r|G\u000e\\3diV1\u0011\u0011OA@\u0003o\"B!a\u001d\u0002\u0002R!\u0011QOA=!\ry\u0013q\u000f\u0003\u0006A>\u0011\rA\r\u0005\u0007y>\u0001\u001d!a\u001f\u0011\u000f\u0011<\u0017)! \u0002vA\u0019q&a \u0005\u000b-|!\u0019\u0001\u001a\t\u000f\u0005\ru\u00021\u0001\u0002\u0006\u0006\u0011\u0001O\u001a\t\u0007O\u0005\u001de&! \n\u0007\u0005%\u0015EA\bQCJ$\u0018.\u00197Gk:\u001cG/[8o\u0003\u001d1G.\u0019;NCB,b!a$\u0002\u001e\u0006UE\u0003BAI\u0003?#B!a%\u0002\u0018B\u0019q&!&\u0005\u000b\u0001\u0004\"\u0019\u0001\u001a\t\rq\u0004\u00029AAM!\u001d!w-QAN\u0003'\u00032aLAO\t\u0015Y\u0007C1\u00013\u0011\u001d\t9\u0005\u0005a\u0001\u0003C\u0003baJA&]\u0005\r\u0006\u0003B\u0016-\u00037\u000b!\u0002\n9mkN$\u0003\u000f\\;t+\u0019\tI+a.\u00020R!\u00111VA])\u0011\ti+!-\u0011\u0007=\ny\u000bB\u0003a#\t\u0007!\u0007\u0003\u0004}#\u0001\u000f\u00111\u0017\t\bI\u001e\f\u0015QWAW!\ry\u0013q\u0017\u0003\u0006WF\u0011\r\u0001\u001c\u0005\b\u0003w\u000b\u0002\u0019AA_\u0003\u0011!\b.\u0019;\u0011\t-b\u0013QW\u0001\u0007M&dG/\u001a:\u0015\u0007\u0005\u000b\u0019\rC\u0004\u0002FJ\u0001\r!a2\u0002\tA\u0014X\r\u001a\t\u0006O\u0005-cFU\u0001\nM&dG/\u001a:O_R$2!QAg\u0011\u001d\t)m\u0005a\u0001\u0003\u000f\f\u0011\u0002]1si&$\u0018n\u001c8\u0015\t\u0005M\u0017\u0011\u001c\t\u0006O\u0005U\u0017)Q\u0005\u0004\u0003/\f#A\u0002+va2,'\u0007C\u0004\u0002FR\u0001\r!a2\u0002\u000f\u001d\u0014x.\u001e9CsV!\u0011q\\Au)\u0011\t\t/!<\u0011\r-\n\u0019/a:B\u0013\r\t)o\b\u0002\u0007\u000f\u0016tW*\u00199\u0011\u0007=\nI\u000f\u0002\u0004\u0002lV\u0011\rA\r\u0002\u0002\u0017\"9\u0011qI\u000bA\u0002\u0005=\bCB\u0014\u0002L9\n9/\u0001\u0003uC.,GcA!\u0002v\"1\u0011q\u001f\fA\u0002\u0019\u000b\u0011A\\\u0001\u0005IJ|\u0007\u000fF\u0002B\u0003{Da!a>\u0018\u0001\u00041\u0015!B:mS\u000e,G#B!\u0003\u0004\t\u001d\u0001B\u0002B\u00031\u0001\u0007a)\u0001\u0005v]\u000e|fM]8n\u0011\u0019\u0011I\u0001\u0007a\u0001\r\u0006IQO\\2`k:$\u0018\u000e\\\u0001\bgBd\u0017\u000e^!u)\u0011\t\u0019Na\u0004\t\r\u0005]\u0018\u00041\u0001G\u0003%!\u0018m[3XQ&dW\rF\u0002B\u0005+Aq!!2\u001b\u0001\u0004\t9-\u0001\u0003ta\u0006tG\u0003BAj\u00057Aq!!2\u001c\u0001\u0004\t9-A\u0005ee>\u0004x\u000b[5mKR\u0019\u0011I!\t\t\u000f\u0005\u0015G\u00041\u0001\u0002H\u0006a1\u000f\u001e:j]\u001e\u0004&/\u001a4jqV\u0011!q\u0005\t\u0005\u0005S\u00119D\u0004\u0003\u0003,\tM\u0002c\u0001B\u0017C5\u0011!q\u0006\u0006\u0004\u0005c\u0019\u0013A\u0002\u001fs_>$h(C\u0002\u00036\u0005\na\u0001\u0015:fI\u00164\u0017\u0002\u0002B\u001d\u0005w\u0011aa\u0015;sS:<'b\u0001B\u001bC\u0001")
public interface GenTraversableLike<A, Repr>
extends GenTraversableOnce<A>,
Parallelizable<A, ParIterable<A>> {
    public Repr repr();

    @Override
    public int size();

    public A head();

    public Option<A> headOption();

    @Override
    public boolean isTraversableAgain();

    public Repr tail();

    public A last();

    public Option<A> lastOption();

    public Repr init();

    public <B, That> That scan(B var1, Function2<B, B, B> var2, CanBuildFrom<Repr, B, That> var3);

    public <B, That> That scanLeft(B var1, Function2<B, A, B> var2, CanBuildFrom<Repr, B, That> var3);

    public <B, That> That scanRight(B var1, Function2<A, B, B> var2, CanBuildFrom<Repr, B, That> var3);

    @Override
    public <U> void foreach(Function1<A, U> var1);

    public <B, That> That map(Function1<A, B> var1, CanBuildFrom<Repr, B, That> var2);

    public <B, That> That collect(PartialFunction<A, B> var1, CanBuildFrom<Repr, B, That> var2);

    public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> var1, CanBuildFrom<Repr, B, That> var2);

    public <B, That> That $plus$plus(GenTraversableOnce<B> var1, CanBuildFrom<Repr, B, That> var2);

    public Repr filter(Function1<A, Object> var1);

    public Repr filterNot(Function1<A, Object> var1);

    public Tuple2<Repr, Repr> partition(Function1<A, Object> var1);

    public <K> GenMap<K, Repr> groupBy(Function1<A, K> var1);

    public Repr take(int var1);

    public Repr drop(int var1);

    public Repr slice(int var1, int var2);

    public Tuple2<Repr, Repr> splitAt(int var1);

    public Repr takeWhile(Function1<A, Object> var1);

    public Tuple2<Repr, Repr> span(Function1<A, Object> var1);

    public Repr dropWhile(Function1<A, Object> var1);

    public String stringPrefix();
}

