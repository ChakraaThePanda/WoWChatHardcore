/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.Equals;
import scala.Function0;
import scala.Function1;
import scala.Option;
import scala.Tuple2;
import scala.collection.GenIterable;
import scala.collection.GenIterableLike;
import scala.collection.GenMap;
import scala.collection.GenSet;
import scala.collection.Iterator;
import scala.collection.Map;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.util.hashing.MurmurHash3$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u0001\u0005uca\u0002\u000b\u0016!\u0003\r\tA\u0007\u0005\u0006\t\u0002!\t!\u0012\u0005\u0006\u0013\u00021\tA\u0013\u0005\u0006\u001b\u00021\tA\u0014\u0005\u0006'\u00021\t\u0001\u0016\u0005\u0006-\u00021\ta\u0016\u0005\u00067\u00021\t\u0001\u0018\u0005\u0006Q\u00021\t!\u001b\u0005\u0006W\u0002!\t\u0005\u001c\u0005\u0006a\u00021\t!\u001d\u0005\u0006u\u00021\ta\u001f\u0005\b\u0003\u0003\u0001a\u0011AA\u0002\u0011\u001d\t9\u0001\u0001D\u0001\u0003\u0013Aq!!\u0005\u0001\r\u0003\t\u0019\u0002C\u0004\u0002\u001c\u00011\t!!\b\t\u000f\u0005\u0005\u0002A\"\u0001\u0002$!9\u00111\u0006\u0001\u0007\u0002\u00055\u0002bBA\u0019\u0001\u0019\u0005\u00111\u0007\u0005\b\u0003\u0003\u0002a\u0011AA\"\u0011\u001d\t)\u0006\u0001C!\u0003/\u0012!bR3o\u001b\u0006\u0004H*[6f\u0015\t1r#\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001G\u0001\u0006g\u000e\fG.Y\u0002\u0001+\u0011Y\u0012f\r\u001c\u0014\u000b\u0001a\u0002\u0005O\u001e\u0011\u0005uqR\"A\f\n\u0005}9\"AB!osJ+g\r\u0005\u0003\"E\u0011*T\"A\u000b\n\u0005\r*\"aD$f]&#XM]1cY\u0016d\u0015n[3\u0011\tu)sEM\u0005\u0003M]\u0011a\u0001V;qY\u0016\u0014\u0004C\u0001\u0015*\u0019\u0001!QA\u000b\u0001C\u0002-\u0012\u0011aS\t\u0003Y=\u0002\"!H\u0017\n\u00059:\"a\u0002(pi\"Lgn\u001a\t\u0003;AJ!!M\f\u0003\u0007\u0005s\u0017\u0010\u0005\u0002)g\u00111A\u0007\u0001CC\u0002-\u0012\u0011A\u0016\t\u0003QY\"aa\u000e\u0001\u0005\u0006\u0004Y#\u0001\u0002*faJ\u0004\"!H\u001d\n\u0005i:\"AB#rk\u0006d7\u000f\u0005\u0003\"y\u0011r\u0014BA\u001f\u0016\u00059\u0001\u0016M]1mY\u0016d\u0017N_1cY\u0016\u0004Ba\u0010\"(e5\t\u0001I\u0003\u0002B+\u0005A\u0001/\u0019:bY2,G.\u0003\u0002D\u0001\n1\u0001+\u0019:NCB\fa\u0001J5oSR$C#\u0001$\u0011\u0005u9\u0015B\u0001%\u0018\u0005\u0011)f.\u001b;\u0002\u000f\u0011,g-Y;miR\u0011!g\u0013\u0005\u0006\u0019\n\u0001\raJ\u0001\u0004W\u0016L\u0018aA4fiR\u0011qJ\u0015\t\u0004;A\u0013\u0014BA)\u0018\u0005\u0019y\u0005\u000f^5p]\")Aj\u0001a\u0001O\u0005)\u0011\r\u001d9msR\u0011!'\u0016\u0005\u0006\u0019\u0012\u0001\raJ\u0001\u0004g\u0016\fX#\u0001-\u0011\t\u0005JvEM\u0005\u00035V\u00111!T1q\u0003\u0015!\u0003\u000f\\;t+\ti&\r\u0006\u0002_KB!\u0011eX\u0014b\u0013\t\u0001WC\u0001\u0004HK:l\u0015\r\u001d\t\u0003Q\t$Qa\u0019\u0004C\u0002\u0011\u0014!AV\u0019\u0012\u0005Iz\u0003\"\u00024\u0007\u0001\u00049\u0017AA6w!\u0011iReJ1\u0002\r\u0011j\u0017N\\;t)\t)$\u000eC\u0003M\u000f\u0001\u0007q%\u0001\u0005iCND7i\u001c3f)\u0005i\u0007CA\u000fo\u0013\tywCA\u0002J]R\f\u0011bZ3u\u001fJ,En]3\u0016\u0005I$HcA:vmB\u0011\u0001\u0006\u001e\u0003\u0006G&\u0011\r\u0001\u001a\u0005\u0006\u0019&\u0001\ra\n\u0005\u0007\u0013&!\t\u0019A<\u0011\u0007uA8/\u0003\u0002z/\tAAHY=oC6,g(\u0001\u0005d_:$\u0018-\u001b8t)\tax\u0010\u0005\u0002\u001e{&\u0011ap\u0006\u0002\b\u0005>|G.Z1o\u0011\u0015a%\u00021\u0001(\u0003-I7\u000fR3gS:,G-\u0011;\u0015\u0007q\f)\u0001C\u0003M\u0017\u0001\u0007q%\u0001\u0004lKf\u001cV\r^\u000b\u0003\u0003\u0017\u0001B!IA\u0007O%\u0019\u0011qB\u000b\u0003\r\u001d+gnU3u\u0003\u0011YW-_:\u0016\u0005\u0005U\u0001\u0003B\u0011\u0002\u0018\u001dJ1!!\u0007\u0016\u0005-9UM\\%uKJ\f'\r\\3\u0002\rY\fG.^3t+\t\ty\u0002\u0005\u0003\"\u0003/\u0011\u0014\u0001D6fsNLE/\u001a:bi>\u0014XCAA\u0013!\u0011\t\u0013qE\u0014\n\u0007\u0005%RC\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u000391\u0018\r\\;fg&#XM]1u_J,\"!a\f\u0011\t\u0005\n9CM\u0001\u000bM&dG/\u001a:LKf\u001cH\u0003BA\u001b\u0003o\u0001B!I0(e!9\u0011\u0011H\tA\u0002\u0005m\u0012!\u00019\u0011\u000bu\tid\n?\n\u0007\u0005}rCA\u0005Gk:\u001cG/[8oc\u0005IQ.\u00199WC2,Xm]\u000b\u0005\u0003\u000b\nY\u0005\u0006\u0003\u0002H\u0005=\u0003#B\u0011`O\u0005%\u0003c\u0001\u0015\u0002L\u00111\u0011Q\n\nC\u0002-\u0012\u0011a\u0016\u0005\b\u0003#\u0012\u0002\u0019AA*\u0003\u00051\u0007CB\u000f\u0002>I\nI%\u0001\u0004fcV\fGn\u001d\u000b\u0004y\u0006e\u0003BBA.'\u0001\u0007q&\u0001\u0003uQ\u0006$\b")
public interface GenMapLike<K, V, Repr>
extends GenIterableLike<Tuple2<K, V>, Repr>,
Equals {
    public V default(K var1);

    public Option<V> get(K var1);

    public V apply(K var1);

    public Map<K, V> seq();

    public <V1> GenMap<K, V1> $plus(Tuple2<K, V1> var1);

    public Repr $minus(K var1);

    public static /* synthetic */ int hashCode$(GenMapLike $this) {
        return $this.hashCode();
    }

    default public int hashCode() {
        return MurmurHash3$.MODULE$.mapHash(this.seq());
    }

    public <V1> V1 getOrElse(K var1, Function0<V1> var2);

    public boolean contains(K var1);

    public boolean isDefinedAt(K var1);

    public GenSet<K> keySet();

    public GenIterable<K> keys();

    public GenIterable<V> values();

    public Iterator<K> keysIterator();

    public Iterator<V> valuesIterator();

    public GenMap<K, V> filterKeys(Function1<K, Object> var1);

    public <W> GenMap<K, W> mapValues(Function1<V, W> var1);

    public static /* synthetic */ boolean equals$(GenMapLike $this, Object that) {
        return $this.equals(that);
    }

    @Override
    default public boolean equals(Object that) {
        GenMap genMap;
        boolean bl = that instanceof GenMap ? this == (genMap = (GenMap)that) || genMap.canEqual(this) && this.size() == genMap.size() && this.liftedTree1$1(genMap) : false;
        return bl;
    }

    private /* synthetic */ boolean liftedTree1$1(GenMap x2$1) {
        try {
            Function0 checker = new Function0<V>(null, x2$1){
                private final GenMap x2$1;

                public boolean apply$mcZ$sp() {
                    return Function0.apply$mcZ$sp$(this);
                }

                public byte apply$mcB$sp() {
                    return Function0.apply$mcB$sp$(this);
                }

                public char apply$mcC$sp() {
                    return Function0.apply$mcC$sp$(this);
                }

                public double apply$mcD$sp() {
                    return Function0.apply$mcD$sp$(this);
                }

                public float apply$mcF$sp() {
                    return Function0.apply$mcF$sp$(this);
                }

                public int apply$mcI$sp() {
                    return Function0.apply$mcI$sp$(this);
                }

                public long apply$mcJ$sp() {
                    return Function0.apply$mcJ$sp$(this);
                }

                public short apply$mcS$sp() {
                    return Function0.apply$mcS$sp$(this);
                }

                public void apply$mcV$sp() {
                    Function0.apply$mcV$sp$(this);
                }

                public String toString() {
                    return Function0.toString$(this);
                }

                public boolean apply(Tuple2<K, V> kv) {
                    V1 v2 = this.x2$1.getOrElse(kv._1(), this);
                    return v2 != this && BoxesRunTime.equals(v2, kv._2());
                }

                public V apply() {
                    return (V)this;
                }
                {
                    this.x2$1 = x2$1;
                }
            };
            return this.forall(checker);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public static void $init$(GenMapLike $this) {
    }
}

