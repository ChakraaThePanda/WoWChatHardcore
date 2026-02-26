/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Tuple2;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Set;
import scala.collection.mutable.Map;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\t\u001dda\u0002\u00192!\u0003\r\t\u0001\u000f\u0005\u0006!\u0002!\t!\u0015\u0005\u0007+\u0002\u0001J\u0011\u0001,\t\rq\u0003\u0001\u0013\"\u0001^\u0011\u0019)\u0007\u0001%C\u0001M\"1!\u000e\u0001I\u0005\u0002-DQ!\u001c\u0001\u0005B9DQA\u001d\u0001\u0005BMDQa\u001e\u0001\u0005BaDQa\u001f\u0001\u0005BqDQA \u0001\u0005BECaa \u0001\u0005B\u0005\u0005\u0001bBA\b\u0001\u0011\u0005\u0013\u0011\u0003\u0005\b\u0003;\u0001A\u0011IA\u0010\u0011\u001d\ti\u0003\u0001C!\u0003_Aq!!\u0014\u0001\t\u0003\ny\u0005C\u0004\u0002T\u0001!\t%!\u0016\t\u000f\u0005\u0005\u0004\u0001\"\u0011\u0002d!9\u0011Q\u000f\u0001\u0005B\u0005]\u0004bBA>\u0001\u0011\u0005\u0013Q\u0010\u0005\b\u0003\u000b\u0003A\u0011IAD\u0011\u001d\t\t\n\u0001C!\u0003'Cq!a&\u0001\t\u0003\nI\nC\u0004\u0002\u001c\u0002!\t%!(\t\u000f\u0005\u0005\u0006\u0001\"\u0011\u0002$\"q\u0011q\u0015\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002*\u00065\u0006\"DAZ\u0001A\u0005\u0019\u0011!A\u0005\nu\u000b)\f\u0003\b\u00028\u0002\u0001\n1!A\u0001\n\u0013\tI,!0\t\u001d\u0005\u0005\u0007\u0001%A\u0002\u0002\u0003%I!a1\u0002H\"i\u0011\u0011\u001a\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003o\u0003\u0017Da\"!5\u0001!\u0003\r\t\u0011!C\u0005\u0003'\fI\u000e\u0003\b\u0002\\\u0002\u0001\n1!A\u0001\n\u0013\ti.a9\t\u001d\u0005\u0015\b\u0001%A\u0002\u0002\u0003%I!a:\u0002l\"i\u0011Q\u001e\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003R\u0003_Da\"!=\u0001!\u0003\r\t\u0011!C\u0005\u0003g\fY\u0010\u0003\b\u0002~\u0002\u0001\n1!A\u0001\n\u0013\tyPa\u0001\t\u001d\t\u0015\u0001\u0001%A\u0002\u0002\u0003%IAa\u0002\u0003\f!q!Q\u0002\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u00020\t=\u0001B\u0004B\t\u0001A\u0005\u0019\u0011!A\u0005\n\u0005=#1\u0003\u0005\u000f\u0005+\u0001\u0001\u0013aA\u0001\u0002\u0013%!q\u0003B\r\u00119\u0011Y\u0002\u0001I\u0001\u0004\u0003\u0005I\u0011\u0002B\u000f\u0005SAaBa\f\u0001!\u0003\r\t\u0011!C\u0005\u0005c\u0011)\u0004\u0003\b\u00038\u0001\u0001\n1!A\u0001\n\u0013\tiH!\u000f\t\u001d\tm\u0002\u0001%A\u0002\u0002\u0003%I!a\"\u0003>!q!q\b\u0001\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002\u0014\n\u0005\u0003B\u0004B\"\u0001A\u0005\u0019\u0011!A\u0005\n\u0005e%Q\t\u0005\u000f\u0005\u000f\u0002\u0001\u0013aA\u0001\u0002\u0013%!\u0011\nB'\u00119\u0011y\u0005\u0001I\u0001\u0004\u0003\u0005I\u0011\u0002B)\u0005+\u0012qbU=oG\"\u0014xN\\5{K\u0012l\u0015\r\u001d\u0006\u0003eM\nq!\\;uC\ndWM\u0003\u00025k\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003Y\nQa]2bY\u0006\u001c\u0001!F\u0002:\t:\u001b2\u0001\u0001\u001e?!\tYD(D\u00016\u0013\tiTG\u0001\u0004B]f\u0014VM\u001a\t\u0005\u007f\u0001\u0013U*D\u00012\u0013\t\t\u0015GA\u0002NCB\u0004\"a\u0011#\r\u0001\u0011)Q\t\u0001b\u0001\r\n\t\u0011)\u0005\u0002H\u0015B\u00111\bS\u0005\u0003\u0013V\u0012qAT8uQ&tw\r\u0005\u0002<\u0017&\u0011A*\u000e\u0002\u0004\u0003:L\bCA\"O\t\u0015y\u0005A1\u0001G\u0005\u0005\u0011\u0015A\u0002\u0013j]&$H\u0005F\u0001S!\tY4+\u0003\u0002Uk\t!QK\\5u\u0003\r9W\r\u001e\u000b\u0003/j\u00032a\u000f-N\u0013\tIVG\u0001\u0004PaRLwN\u001c\u0005\u00067\n\u0001\rAQ\u0001\u0004W\u0016L\u0018\u0001C5uKJ\fGo\u001c:\u0016\u0003y\u00032a\u00181c\u001b\u0005\u0019\u0014BA14\u0005!IE/\u001a:bi>\u0014\b\u0003B\u001ed\u00056K!\u0001Z\u001b\u0003\rQ+\b\u000f\\33\u0003!!\u0003\u000f\\;tI\u0015\fHCA4i\u001b\u0005\u0001\u0001\"B5\u0005\u0001\u0004\u0011\u0017AA6w\u0003%!S.\u001b8vg\u0012*\u0017\u000f\u0006\u0002hY\")1,\u0002a\u0001\u0005\u0006!1/\u001b>f+\u0005y\u0007CA\u001eq\u0013\t\tXGA\u0002J]R\f1\u0001];u)\r9F/\u001e\u0005\u00067\u001e\u0001\rA\u0011\u0005\u0006m\u001e\u0001\r!T\u0001\u0006m\u0006dW/Z\u0001\u0007kB$\u0017\r^3\u0015\u0007IK(\u0010C\u0003\\\u0011\u0001\u0007!\tC\u0003w\u0011\u0001\u0007Q*\u0001\u0004sK6|g/\u001a\u000b\u0003/vDQaW\u0005A\u0002\t\u000bQa\u00197fCJ\fqbZ3u\u001fJ,En]3Va\u0012\fG/\u001a\u000b\u0006\u001b\u0006\r\u0011Q\u0001\u0005\u00067.\u0001\rA\u0011\u0005\t\u0003\u000fYA\u00111\u0001\u0002\n\u00059A-\u001a4bk2$\b\u0003B\u001e\u0002\f5K1!!\u00046\u0005!a$-\u001f8b[\u0016t\u0014!\u0003;sC:\u001chm\u001c:n)\r9\u00171\u0003\u0005\b\u0003+a\u0001\u0019AA\f\u0003\u00051\u0007CB\u001e\u0002\u001a\tkU*C\u0002\u0002\u001cU\u0012\u0011BR;oGRLwN\u001c\u001a\u0002\rI,G/Y5o)\r9\u0017\u0011\u0005\u0005\b\u0003Gi\u0001\u0019AA\u0013\u0003\u0005\u0001\bcB\u001e\u0002\u001a\tk\u0015q\u0005\t\u0004w\u0005%\u0012bAA\u0016k\t9!i\\8mK\u0006t\u0017A\u0002<bYV,7/\u0006\u0002\u00022A!q,a\rN\u0013\r\t)d\r\u0002\t\u0013R,'/\u00192mK\":a\"!\u000f\u0002F\u0005%\u0003\u0003BA\u001e\u0003\u0003j!!!\u0010\u000b\u0007\u0005}R'\u0001\u0006b]:|G/\u0019;j_:LA!a\u0011\u0002>\tIQ.[4sCRLwN\\\u0011\u0003\u0003\u000f\n\u0011\b\u0019<bYV,7\u000f\u0019\u0011sKR,(O\\:!A&#XM]1cY\u0016\\&)\u00181!e\u0006$\b.\u001a:!i\"\fg\u000e\t1Ji\u0016\u0014\u0018\r^8s7\nk\u0006ML\u0011\u0003\u0003\u0017\nQA\r\u00189]A\naB^1mk\u0016\u001c\u0018\n^3sCR|'/\u0006\u0002\u0002RA\u0019q\fY'\u0002\u000b\rdwN\\3\u0015\u0005\u0005]\u0003cA4\u0002Z%!\u00111LA/\u0005\u0011\u0019V\r\u001c4\n\u0007\u0005}3GA\bUe\u00064XM]:bE2,G*[6f\u0003\u001d1wN]3bG\",B!!\u001a\u0002rQ\u0019!+a\u001a\t\u000f\u0005U\u0011\u00031\u0001\u0002jA11(a\u001bc\u0003_J1!!\u001c6\u0005%1UO\\2uS>t\u0017\u0007E\u0002D\u0003c\"a!a\u001d\u0012\u0005\u00041%!A+\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u00075\u000bI\bC\u0003\\%\u0001\u0007!)\u0001\u0004lKf\u001cV\r^\u000b\u0003\u0003\u007f\u0002BaXAA\u0005&\u0019\u00111Q\u001a\u0003\u0007M+G/\u0001\u0003lKf\u001cXCAAE!\u0011y\u00161\u0007\")\u000fQ\tI$!$\u0002J\u0005\u0012\u0011qR\u00018A.,\u0017p\u001d1!e\u0016$XO\u001d8tA\u0001LE/\u001a:bE2,7,Q/aAI\fG\u000f[3sAQD\u0017M\u001c\u0011a\u0013R,'/\u0019;pen\u000bU\f\u0019\u0018\u0002\u0019-,\u0017p]%uKJ\fGo\u001c:\u0016\u0005\u0005U\u0005cA0a\u0005\u00069\u0011n]#naRLXCAA\u0014\u0003!\u0019wN\u001c;bS:\u001cH\u0003BA\u0014\u0003?CQaW\fA\u0002\t\u000b1\"[:EK\u001aLg.\u001a3BiR!\u0011qEAS\u0011\u0015Y\u0006\u00041\u0001C\u0003%\u0019X\u000f]3sI\u001d,G\u000fF\u0002X\u0003WCQaW\rA\u0002\tK1!VAX\u0013\r\t\tl\r\u0002\b\u001b\u0006\u0004H*[6f\u00039\u0019X\u000f]3sI%$XM]1u_JL1\u0001XAX\u00039\u0019X\u000f]3sI\u0011\u0002H.^:%KF$2aZA^\u0011\u0015I7\u00041\u0001c\u0013\r)\u0017qX\u0005\u0004\u0003c\u000b\u0014aD:va\u0016\u0014H\u0005J7j]V\u001cH%Z9\u0015\u0007\u001d\f)\rC\u0003\\9\u0001\u0007!)C\u0002k\u0003\u007f\u000b!b];qKJ$3/\u001b>f\u0013\ri\u0017QZ\u0005\u0004\u0003\u001f\u001c$a\u0004+sCZ,'o]1cY\u0016|enY3\u0002\u0013M,\b/\u001a:%aV$H#B,\u0002V\u0006]\u0007\"B.\u001f\u0001\u0004\u0011\u0005\"\u0002<\u001f\u0001\u0004i\u0015b\u0001:\u0002@\u0006a1/\u001e9fe\u0012*\b\u000fZ1uKR)!+a8\u0002b\")1l\ba\u0001\u0005\")ao\ba\u0001\u001b&\u0019q/a0\u0002\u0019M,\b/\u001a:%e\u0016lwN^3\u0015\u0007]\u000bI\u000fC\u0003\\A\u0001\u0007!)C\u0002|\u0003\u007f\u000b1b];qKJ$3\r\\3be&\u0019a0a0\u0002+M,\b/\u001a:%O\u0016$xJ]#mg\u0016,\u0006\u000fZ1uKR)Q*!>\u0002x\")1L\ta\u0001\u0005\"A\u0011\u0011 \u0012\u0005\u0002\u0004\tI!\u0001\u0002pa&\u0019q0a0\u0002\u001fM,\b/\u001a:%iJ\fgn\u001d4pe6$2a\u001aB\u0001\u0011\u001d\t)b\ta\u0001\u0003/IA!a\u0004\u0002@\u0006a1/\u001e9fe\u0012\u0012X\r^1j]R\u0019qM!\u0003\t\u000f\u0005\rB\u00051\u0001\u0002&%!\u0011QDA`\u00031\u0019X\u000f]3sIY\fG.^3t\u0013\u0011\ti#a,\u0002)M,\b/\u001a:%m\u0006dW/Z:Ji\u0016\u0014\u0018\r^8s\u0013\u0011\ti%a,\u0002\u0017M,\b/\u001a:%G2|g.\u001a\u000b\u0002}%!\u00111KA`\u00035\u0019X\u000f]3sI\u0019|'/Z1dQV!!q\u0004B\u0014)\r\u0011&\u0011\u0005\u0005\b\u0003+A\u0003\u0019\u0001B\u0012!\u0019Y\u00141\u000e2\u0003&A\u00191Ia\n\u0005\r\u0005M\u0004F1\u0001G\u0013\u0011\t\tGa\u000b\n\u0007\t52G\u0001\u0007Ji\u0016\u0014\u0018M\u00197f\u0019&\\W-A\u0006tkB,'\u000fJ1qa2LHcA'\u00034!)1,\u000ba\u0001\u0005&!\u0011QOAX\u00031\u0019X\u000f]3sI-,\u0017pU3u\u0013\u0011\tY(a,\u0002\u0015M,\b/\u001a:%W\u0016L8/\u0003\u0003\u0002\u0006\u0006=\u0016AE:va\u0016\u0014He[3zg&#XM]1u_JLA!!%\u00020\u0006i1/\u001e9fe\u0012J7/R7qifLA!a&\u00020\u0006q1/\u001e9fe\u0012\u001awN\u001c;bS:\u001cH\u0003BA\u0014\u0005\u0017BQa\u0017\u0018A\u0002\tKA!a'\u00020\u0006\t2/\u001e9fe\u0012J7\u000fR3gS:,G-\u0011;\u0015\t\u0005\u001d\"1\u000b\u0005\u00067>\u0002\rAQ\u0005\u0005\u0003C\u000by\u000bK\u0004\u0001\u00053\u0012yFa\u0019\u0011\u0007m\u0012Y&C\u0002\u0003^U\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\u0011\t'AA\f'ft7\r\u001b:p]&T\u0018\r^5p]\u00022\u0018.\u0019\u0011ue\u0006LGo\u001d\u0011jg\u0002\"W\r\u001d:fG\u0006$X\r\u001a\u0011bg\u0002JG\u000fI5tA%t\u0007.\u001a:f]Rd\u0017\u0010I;oe\u0016d\u0017.\u00192mK:\u00023i\u001c8tS\u0012,'\u000f\t6bm\u0006tS\u000f^5m]\r|gnY;se\u0016tGOL\"p]\u000e,(O]3oi\"\u000b7\u000f['ba\u0002\n7\u000fI1oA\u0005dG/\u001a:oCRLg/\u001a\u0018\"\u0005\t\u0015\u0014A\u0002\u001a/cEr\u0003\u0007")
public interface SynchronizedMap<A, B>
extends Map<A, B> {
    public /* synthetic */ Option scala$collection$mutable$SynchronizedMap$$super$get(Object var1);

    public /* synthetic */ Iterator scala$collection$mutable$SynchronizedMap$$super$iterator();

    public /* synthetic */ SynchronizedMap scala$collection$mutable$SynchronizedMap$$super$$plus$eq(Tuple2 var1);

    public /* synthetic */ SynchronizedMap scala$collection$mutable$SynchronizedMap$$super$$minus$eq(Object var1);

    public /* synthetic */ int scala$collection$mutable$SynchronizedMap$$super$size();

    public /* synthetic */ Option scala$collection$mutable$SynchronizedMap$$super$put(Object var1, Object var2);

    public /* synthetic */ void scala$collection$mutable$SynchronizedMap$$super$update(Object var1, Object var2);

    public /* synthetic */ Option scala$collection$mutable$SynchronizedMap$$super$remove(Object var1);

    public /* synthetic */ void scala$collection$mutable$SynchronizedMap$$super$clear();

    public /* synthetic */ Object scala$collection$mutable$SynchronizedMap$$super$getOrElseUpdate(Object var1, Function0 var2);

    public /* synthetic */ SynchronizedMap scala$collection$mutable$SynchronizedMap$$super$transform(Function2 var1);

    public /* synthetic */ SynchronizedMap scala$collection$mutable$SynchronizedMap$$super$retain(Function2 var1);

    public /* synthetic */ Iterable scala$collection$mutable$SynchronizedMap$$super$values();

    public /* synthetic */ Iterator scala$collection$mutable$SynchronizedMap$$super$valuesIterator();

    public /* synthetic */ Map scala$collection$mutable$SynchronizedMap$$super$clone();

    public /* synthetic */ void scala$collection$mutable$SynchronizedMap$$super$foreach(Function1 var1);

    public /* synthetic */ Object scala$collection$mutable$SynchronizedMap$$super$apply(Object var1);

    public /* synthetic */ Set scala$collection$mutable$SynchronizedMap$$super$keySet();

    public /* synthetic */ Iterable scala$collection$mutable$SynchronizedMap$$super$keys();

    public /* synthetic */ Iterator scala$collection$mutable$SynchronizedMap$$super$keysIterator();

    public /* synthetic */ boolean scala$collection$mutable$SynchronizedMap$$super$isEmpty();

    public /* synthetic */ boolean scala$collection$mutable$SynchronizedMap$$super$contains(Object var1);

    public /* synthetic */ boolean scala$collection$mutable$SynchronizedMap$$super$isDefinedAt(Object var1);

    public static /* synthetic */ Option get$(SynchronizedMap $this, Object key) {
        return $this.get((A)key);
    }

    @Override
    default public Option<B> get(A key) {
        synchronized (this) {
            Option option = this.scala$collection$mutable$SynchronizedMap$$super$get(key);
            return option;
        }
    }

    public static /* synthetic */ Iterator iterator$(SynchronizedMap $this) {
        return $this.iterator();
    }

    @Override
    default public Iterator<Tuple2<A, B>> iterator() {
        synchronized (this) {
            Iterator iterator2 = this.scala$collection$mutable$SynchronizedMap$$super$iterator();
            return iterator2;
        }
    }

    public static /* synthetic */ SynchronizedMap $plus$eq$(SynchronizedMap $this, Tuple2 kv) {
        return $this.$plus$eq(kv);
    }

    @Override
    default public SynchronizedMap<A, B> $plus$eq(Tuple2<A, B> kv) {
        synchronized (this) {
            SynchronizedMap synchronizedMap = this.scala$collection$mutable$SynchronizedMap$$super$$plus$eq(kv);
            return synchronizedMap;
        }
    }

    public static /* synthetic */ SynchronizedMap $minus$eq$(SynchronizedMap $this, Object key) {
        return $this.$minus$eq((A)key);
    }

    default public SynchronizedMap<A, B> $minus$eq(A key) {
        synchronized (this) {
            SynchronizedMap synchronizedMap = this.scala$collection$mutable$SynchronizedMap$$super$$minus$eq(key);
            return synchronizedMap;
        }
    }

    public static /* synthetic */ int size$(SynchronizedMap $this) {
        return $this.size();
    }

    @Override
    default public int size() {
        synchronized (this) {
            int n = this.scala$collection$mutable$SynchronizedMap$$super$size();
            return n;
        }
    }

    public static /* synthetic */ Option put$(SynchronizedMap $this, Object key, Object value) {
        return $this.put((A)key, (B)value);
    }

    @Override
    default public Option<B> put(A key, B value) {
        synchronized (this) {
            Option option = this.scala$collection$mutable$SynchronizedMap$$super$put(key, value);
            return option;
        }
    }

    public static /* synthetic */ void update$(SynchronizedMap $this, Object key, Object value) {
        $this.update((A)key, (B)value);
    }

    @Override
    default public void update(A key, B value) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedMap$$super$update(key, value);
            return;
        }
    }

    public static /* synthetic */ Option remove$(SynchronizedMap $this, Object key) {
        return $this.remove((A)key);
    }

    @Override
    default public Option<B> remove(A key) {
        synchronized (this) {
            Option option = this.scala$collection$mutable$SynchronizedMap$$super$remove(key);
            return option;
        }
    }

    public static /* synthetic */ void clear$(SynchronizedMap $this) {
        $this.clear();
    }

    @Override
    default public void clear() {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedMap$$super$clear();
            return;
        }
    }

    public static /* synthetic */ Object getOrElseUpdate$(SynchronizedMap $this, Object key, Function0 function0) {
        return $this.getOrElseUpdate((A)key, function0);
    }

    @Override
    default public B getOrElseUpdate(A key, Function0<B> function0) {
        synchronized (this) {
            Object object = this.scala$collection$mutable$SynchronizedMap$$super$getOrElseUpdate(key, function0);
            return (B)object;
        }
    }

    public static /* synthetic */ SynchronizedMap transform$(SynchronizedMap $this, Function2 f) {
        return $this.transform(f);
    }

    default public SynchronizedMap<A, B> transform(Function2<A, B, B> f) {
        synchronized (this) {
            SynchronizedMap synchronizedMap = this.scala$collection$mutable$SynchronizedMap$$super$transform(f);
            return synchronizedMap;
        }
    }

    public static /* synthetic */ SynchronizedMap retain$(SynchronizedMap $this, Function2 p) {
        return $this.retain(p);
    }

    default public SynchronizedMap<A, B> retain(Function2<A, B, Object> p) {
        synchronized (this) {
            SynchronizedMap synchronizedMap = this.scala$collection$mutable$SynchronizedMap$$super$retain(p);
            return synchronizedMap;
        }
    }

    public static /* synthetic */ Iterable values$(SynchronizedMap $this) {
        return $this.values();
    }

    @Override
    default public Iterable<B> values() {
        synchronized (this) {
            Iterable iterable = this.scala$collection$mutable$SynchronizedMap$$super$values();
            return iterable;
        }
    }

    public static /* synthetic */ Iterator valuesIterator$(SynchronizedMap $this) {
        return $this.valuesIterator();
    }

    @Override
    default public Iterator<B> valuesIterator() {
        synchronized (this) {
            Iterator iterator2 = this.scala$collection$mutable$SynchronizedMap$$super$valuesIterator();
            return iterator2;
        }
    }

    public static /* synthetic */ Map clone$(SynchronizedMap $this) {
        return $this.clone();
    }

    @Override
    default public Map<A, B> clone() {
        synchronized (this) {
            Map map = this.scala$collection$mutable$SynchronizedMap$$super$clone();
            return map;
        }
    }

    public static /* synthetic */ void foreach$(SynchronizedMap $this, Function1 f) {
        $this.foreach(f);
    }

    @Override
    default public <U> void foreach(Function1<Tuple2<A, B>, U> f) {
        synchronized (this) {
            this.scala$collection$mutable$SynchronizedMap$$super$foreach(f);
            return;
        }
    }

    public static /* synthetic */ Object apply$(SynchronizedMap $this, Object key) {
        return $this.apply((A)key);
    }

    @Override
    default public B apply(A key) {
        synchronized (this) {
            Object object = this.scala$collection$mutable$SynchronizedMap$$super$apply(key);
            return (B)object;
        }
    }

    public static /* synthetic */ Set keySet$(SynchronizedMap $this) {
        return $this.keySet();
    }

    @Override
    default public Set<A> keySet() {
        synchronized (this) {
            Set set = this.scala$collection$mutable$SynchronizedMap$$super$keySet();
            return set;
        }
    }

    public static /* synthetic */ Iterable keys$(SynchronizedMap $this) {
        return $this.keys();
    }

    @Override
    default public Iterable<A> keys() {
        synchronized (this) {
            Iterable iterable = this.scala$collection$mutable$SynchronizedMap$$super$keys();
            return iterable;
        }
    }

    public static /* synthetic */ Iterator keysIterator$(SynchronizedMap $this) {
        return $this.keysIterator();
    }

    @Override
    default public Iterator<A> keysIterator() {
        synchronized (this) {
            Iterator iterator2 = this.scala$collection$mutable$SynchronizedMap$$super$keysIterator();
            return iterator2;
        }
    }

    public static /* synthetic */ boolean isEmpty$(SynchronizedMap $this) {
        return $this.isEmpty();
    }

    @Override
    default public boolean isEmpty() {
        synchronized (this) {
            boolean bl = this.scala$collection$mutable$SynchronizedMap$$super$isEmpty();
            return bl;
        }
    }

    public static /* synthetic */ boolean contains$(SynchronizedMap $this, Object key) {
        return $this.contains((A)key);
    }

    @Override
    default public boolean contains(A key) {
        synchronized (this) {
            boolean bl = this.scala$collection$mutable$SynchronizedMap$$super$contains(key);
            return bl;
        }
    }

    public static /* synthetic */ boolean isDefinedAt$(SynchronizedMap $this, Object key) {
        return $this.isDefinedAt((A)key);
    }

    @Override
    default public boolean isDefinedAt(A key) {
        synchronized (this) {
            boolean bl = this.scala$collection$mutable$SynchronizedMap$$super$isDefinedAt(key);
            return bl;
        }
    }

    public static void $init$(SynchronizedMap $this) {
    }
}

