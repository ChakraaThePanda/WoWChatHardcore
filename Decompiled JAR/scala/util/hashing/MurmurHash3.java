/*
 * Decompiled with CFR 0.152.
 */
package scala.util.hashing;

import scala.Product;
import scala.collection.Map;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.TraversableOnce;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.LazyRef;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;
import scala.util.hashing.Hashing;
import scala.util.hashing.MurmurHash3$;
import scala.util.hashing.MurmurHash3$hasher$1$;
import scala.util.hashing.MurmurHash3$hasher$3$;

@ScalaSignature(bytes="\u0006\u0001\t\u001df!\u0002\u001d:\u0001ez\u0004\"\u0002#\u0001\t\u00031\u0005\"B%\u0001\t\u000bQ\u0005\"\u0002*\u0001\t\u000b\u0019\u0006\"\u0002,\u0001\t\u000b9\u0006\"B.\u0001\t\u001ba\u0006B\u00020\u0001\t\u0003it\fC\u0003j\u0001\u0011\u0015!\u000eC\u0003q\u0001\u0011\u0015\u0011\u000fC\u0004\u0002\u0002\u0001!)!a\u0001\t\u000f\u0005e\u0001\u0001\"\u0002\u0002\u001c!9\u0011\u0011\u0005\u0001\u0005\u0006\u0005\r\u0002bBA&\u0001\u0011\u0015\u0011Q\n\u0005\b\u00037\u0002AQAA/\u000f\u001d\tY(\u000fE\u0001\u0003{2a\u0001O\u001d\t\u0002\u0005}\u0004B\u0002#\u0010\t\u0003\t\t\tC\u0005\u0002\u0004>\u0011\r\u0011\"\u0002\u0002\u0006\"A\u00111R\b!\u0002\u001b\t9\tC\u0005\u0002\u000e>\u0011\r\u0011\"\u0002\u0002\u0010\"A\u0011QS\b!\u0002\u001b\t\t\nC\u0005\u0002\u0018>\u0011\r\u0011\"\u0002\u0002\u001a\"A\u0011qT\b!\u0002\u001b\tY\nC\u0005\u0002\">\u0011\r\u0011\"\u0002\u0002$\"A\u0011\u0011V\b!\u0002\u001b\t)\u000bC\u0005\u0002,>\u0011\r\u0011\"\u0002\u0002.\"A\u00111W\b!\u0002\u001b\ty\u000bC\u0005\u00026>\u0011\r\u0011\"\u0002\u00028\"9\u0011\u0011X\b!\u0002\u001bY\u0005\"CA^\u001f\t\u0007IQAA\\\u0011\u001d\til\u0004Q\u0001\u000e-C\u0011\"a0\u0010\u0005\u0004%)!a.\t\u000f\u0005\u0005w\u0002)A\u0007\u0017\"9\u0011\u0011E\b\u0005\u0002\u0005\r\u0007bBA&\u001f\u0011\u0005\u0011\u0011\u001b\u0005\b\u00033yA\u0011AAk\u0011\u001dqv\u0002\"\u0001>\u00033Da![\b\u0005\u0002\u0005}\u0007B\u00029\u0010\t\u0003\t\u0019\u000fC\u0004\u0002\u0002=!\t!a:\t\u0011\u0005-x\u0002\"\u0001>\u0003[D\u0001\"a?\u0010\t\u0003i\u0014Q \u0005\b\u0005\u0003yA\u0011\u0001B\u0002\u0011\u001d\u00119b\u0004C\u0001\u00053AqA!\r\u0010\t\u0003\u0011\u0019\u0004\u0003\u0006\u0003F=\u0011\r\u0011\"\u0001>\u0003oCqAa\u0012\u0010A\u0003%1J\u0002\u0004\u0003J=\u0001!1\n\u0005\u0007\t>\"\tA!\u0018\t\r={C\u0011\u0001B2\u0011\u001d\u00119g\u0004C\u0001\u0005SBqA!\u001e\u0010\t\u0003\u00119\bC\u0004\u0003\u0002>!\tAa!\t\u000f\t-u\u0002\"\u0001\u0003\u000e\"9!QS\b\u0005\u0002\t]\u0005b\u0002BP\u001f\u0011\u0005!\u0011\u0015\u0002\f\u001bV\u0014X.\u001e:ICND7G\u0003\u0002;w\u00059\u0001.Y:iS:<'B\u0001\u001f>\u0003\u0011)H/\u001b7\u000b\u0003y\nQa]2bY\u0006\u001c\"\u0001\u0001!\u0011\u0005\u0005\u0013U\"A\u001f\n\u0005\rk$AB!osJ+g-\u0001\u0004=S:LGOP\u0002\u0001)\u00059\u0005C\u0001%\u0001\u001b\u0005I\u0014aA7jqR\u00191J\u0014)\u0011\u0005\u0005c\u0015BA'>\u0005\rIe\u000e\u001e\u0005\u0006\u001f\n\u0001\raS\u0001\u0005Q\u0006\u001c\b\u000eC\u0003R\u0005\u0001\u00071*\u0001\u0003eCR\f\u0017aB7jq2\u000b7\u000f\u001e\u000b\u0004\u0017R+\u0006\"B(\u0004\u0001\u0004Y\u0005\"B)\u0004\u0001\u0004Y\u0015\u0001\u00044j]\u0006d\u0017N_3ICNDGcA&Y3\")q\n\u0002a\u0001\u0017\")!\f\u0002a\u0001\u0017\u00061A.\u001a8hi\"\f\u0011\"\u0019<bY\u0006t7\r[3\u0015\u0005-k\u0006\"B(\u0006\u0001\u0004Y\u0015\u0001\u00049s_\u0012,8\r\u001e\u001aICNDG\u0003B&aK\u001eDQ!\u0019\u0004A\u0002\t\f\u0011\u0001\u001f\t\u0003\u0003\u000eL!\u0001Z\u001f\u0003\u0007\u0005s\u0017\u0010C\u0003g\r\u0001\u0007!-A\u0001z\u0011\u0015Ag\u00011\u0001L\u0003\u0011\u0019X-\u001a3\u0002\u0017A\u0014x\u000eZ;di\"\u000b7\u000f\u001b\u000b\u0004\u0017.|\u0007\"B1\b\u0001\u0004a\u0007CA!n\u0013\tqWHA\u0004Qe>$Wo\u0019;\t\u000b!<\u0001\u0019A&\u0002\u0015M$(/\u001b8h\u0011\u0006\u001c\b\u000eF\u0002Le~DQa\u001d\u0005A\u0002Q\f1a\u001d;s!\t)HP\u0004\u0002wuB\u0011q/P\u0007\u0002q*\u0011\u00110R\u0001\u0007yI|w\u000e\u001e \n\u0005ml\u0014A\u0002)sK\u0012,g-\u0003\u0002~}\n11\u000b\u001e:j]\u001eT!a_\u001f\t\u000b!D\u0001\u0019A&\u0002\u001bUtwN\u001d3fe\u0016$\u0007*Y:i)\u0015Y\u0015QAA\f\u0011\u001d\t9!\u0003a\u0001\u0003\u0013\t!\u0001_:\u0011\u000b\u0005-\u0011\u0011\u00032\u000f\u0007\u0005\u000bi!C\u0002\u0002\u0010u\nq\u0001]1dW\u0006<W-\u0003\u0003\u0002\u0014\u0005U!a\u0004+sCZ,'o]1cY\u0016|enY3\u000b\u0007\u0005=Q\bC\u0003i\u0013\u0001\u00071*A\u0006pe\u0012,'/\u001a3ICNDG#B&\u0002\u001e\u0005}\u0001bBA\u0004\u0015\u0001\u0007\u0011\u0011\u0002\u0005\u0006Q*\u0001\raS\u0001\nCJ\u0014\u0018-\u001f%bg\",B!!\n\u00026Q)1*a\n\u0002J!9\u0011\u0011F\u0006A\u0002\u0005-\u0012!A1\u0011\u000b\u0005\u000bi#!\r\n\u0007\u0005=RHA\u0003BeJ\f\u0017\u0010\u0005\u0003\u00024\u0005UB\u0002\u0001\u0003\f\u0003oY\u0001\u0015!A\u0001\u0006\u0004\tIDA\u0001U#\r\tYD\u0019\t\u0004\u0003\u0006u\u0012bAA {\t9aj\u001c;iS:<\u0007\u0006BA\u001b\u0003\u0007\u00022!QA#\u0013\r\t9%\u0010\u0002\fgB,7-[1mSj,G\rC\u0003i\u0017\u0001\u00071*A\u0005csR,7\u000fS1tQR)1*a\u0014\u0002Z!1\u0011\u000b\u0004a\u0001\u0003#\u0002R!QA\u0017\u0003'\u00022!QA+\u0013\r\t9&\u0010\u0002\u0005\u0005f$X\rC\u0003i\u0019\u0001\u00071*\u0001\u0005mSN$\b*Y:i)\u0015Y\u0015qLA=\u0011\u001d\t9!\u0004a\u0001\u0003C\u0002D!a\u0019\u0002vA1\u0011QMA8\u0003gj!!a\u001a\u000b\t\u0005%\u00141N\u0001\nS6lW\u000f^1cY\u0016T1!!\u001c>\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0003c\n9G\u0001\u0003MSN$\b\u0003BA\u001a\u0003k\"A\"a\u001e\u0002`\u0005\u0005\t\u0011!B\u0001\u0003s\u00111a\u0018\u00132\u0011\u0015AW\u00021\u0001L\u0003-iUO]7ve\"\u000b7\u000f[\u001a\u0011\u0005!{1CA\bH)\t\ti(A\u0005beJ\f\u0017pU3fIV\u0011\u0011qQ\b\u0003\u0003\u0013kB\u0001P\u0004KC\u0006Q\u0011M\u001d:bsN+W\r\u001a\u0011\u0002\u0015M$(/\u001b8h'\u0016,G-\u0006\u0002\u0002\u0012>\u0011\u00111S\u000f\u0005o,\u007f(;A\u0006tiJLgnZ*fK\u0012\u0004\u0013a\u00039s_\u0012,8\r^*fK\u0012,\"!a'\u0010\u0005\u0005uU\u0004\u0002f\u007fv{\u000eA\u0002\u001d:pIV\u001cGoU3fI\u0002\nQb]=n[\u0016$(/[2TK\u0016$WCAAS\u001f\t\t9+\b\u00036&_x\u001bAD:z[6,GO]5d'\u0016,G\rI\u0001\u0010iJ\fg/\u001a:tC\ndWmU3fIV\u0011\u0011qV\b\u0003\u0003ckBa:\u001e\f,\u0005\u0001BO]1wKJ\u001c\u0018M\u00197f'\u0016,G\rI\u0001\bg\u0016\f8+Z3e+\u0005Y\u0015\u0001C:fcN+W\r\u001a\u0011\u0002\u000f5\f\u0007oU3fI\u0006AQ.\u00199TK\u0016$\u0007%A\u0004tKR\u001cV-\u001a3\u0002\u0011M,GoU3fI\u0002*B!!2\u0002NR\u00191*a2\t\u000f\u0005%\u0012\u00051\u0001\u0002JB)\u0011)!\f\u0002LB!\u00111GAg\t-\t9$\tQ\u0001\u0002\u0003\u0015\r!!\u000f)\t\u00055\u00171\t\u000b\u0004\u0017\u0006M\u0007BB)#\u0001\u0004\t\t\u0006F\u0002L\u0003/Dq!a\u0002$\u0001\u0004\tI\u0001F\u0003L\u00037\fi\u000eC\u0003bI\u0001\u0007!\rC\u0003gI\u0001\u0007!\rF\u0002L\u0003CDQ!Y\u0013A\u00021$2aSAs\u0011\u0015\tg\u00051\u0001u)\rY\u0015\u0011\u001e\u0005\b\u0003\u000f9\u0003\u0019AA\u0005\u0003A9(/\u00199qK\u0012\f%O]1z\u0011\u0006\u001c\b.\u0006\u0003\u0002p\u0006]HcA&\u0002r\"9\u0011\u0011\u0006\u0015A\u0002\u0005M\b#B!\u0002.\u0005U\b\u0003BA\u001a\u0003o$1\"a\u000e)A\u0003\u0005\tQ1\u0001\u0002:!\"\u0011q_A\"\u0003A9(/\u00199qK\u0012\u0014\u0015\u0010^3t\u0011\u0006\u001c\b\u000eF\u0002L\u0003\u007fDa!U\u0015A\u0002\u0005E\u0013aB:fc\"\u000b7\u000f\u001b\u000b\u0004\u0017\n\u0015\u0001bBA\u0004U\u0001\u0007!q\u0001\u0019\u0005\u0005\u0013\u0011\u0019\u0002\u0005\u0004\u0003\f\t5!\u0011C\u0007\u0003\u0003WJAAa\u0004\u0002l\t\u00191+Z9\u0011\t\u0005M\"1\u0003\u0003\r\u0005+\u0011)!!A\u0001\u0002\u000b\u0005\u0011\u0011\b\u0002\u0004?\u0012\u0012\u0014aB7ba\"\u000b7\u000f\u001b\u000b\u0004\u0017\nm\u0001bBA\u0004W\u0001\u0007!Q\u0004\u0019\u0007\u0005?\u00119C!\f\u0011\u0011\t-!\u0011\u0005B\u0013\u0005WIAAa\t\u0002l\t\u0019Q*\u00199\u0011\t\u0005M\"q\u0005\u0003\r\u0005S\u0011Y\"!A\u0001\u0002\u000b\u0005\u0011\u0011\b\u0002\u0004?\u0012\u001a\u0004\u0003BA\u001a\u0005[!ABa\f\u0003\u001c\u0005\u0005\t\u0011!B\u0001\u0003s\u00111a\u0018\u00135\u0003\u001d\u0019X\r\u001e%bg\"$2a\u0013B\u001b\u0011\u001d\t9\u0001\fa\u0001\u0005o\u0001DA!\u000f\u0003BA1!1\u0002B\u001e\u0005\u007fIAA!\u0010\u0002l\t\u00191+\u001a;\u0011\t\u0005M\"\u0011\t\u0003\r\u0005\u0007\u0012)$!A\u0001\u0002\u000b\u0005\u0011\u0011\b\u0002\u0004?\u0012*\u0014\u0001D3naRLX*\u00199ICND\u0017!D3naRLX*\u00199ICND\u0007E\u0001\u0007BeJ\f\u0017\u0010S1tQ&tw-\u0006\u0003\u0003N\te3\u0003B\u0018A\u0005\u001f\u0002R\u0001\u0013B)\u0005+J1Aa\u0015:\u0005\u001dA\u0015m\u001d5j]\u001e\u0004R!QA\u0017\u0005/\u0002B!a\r\u0003Z\u0011Y\u0011qG\u0018!\u0002\u0003\u0005)\u0019AA\u001dQ\u0011\u0011I&a\u0011\u0015\u0005\t}\u0003#\u0002B1_\t]S\"A\b\u0015\u0007-\u0013)\u0007C\u0004\u0002*E\u0002\rA!\u0016\u0002\u0019\u0005\u0014(/Y=ICND\u0017N\\4\u0016\t\t-$\u0011O\u000b\u0003\u0005[\u0002RA!\u00190\u0005_\u0002B!a\r\u0003r\u0011Y\u0011q\u0007\u001a!\u0002\u0003\u0005)\u0019AA\u001dQ\u0011\u0011\t(a\u0011\u0002\u0019\tLH/Z:ICND\u0017N\\4\u0016\u0005\te$#\u0002B>\u0001\n}dA\u0002B?g\u0001\u0011IH\u0001\u0007=e\u00164\u0017N\\3nK:$h\bE\u0003I\u0005#\n\t&\u0001\bpe\u0012,'/\u001a3ICND\u0017N\\4\u0016\u0005\t\u0015%#\u0002BD\u0001\n%eA\u0002B?i\u0001\u0011)\tE\u0003I\u0005#\nI!\u0001\bqe>$Wo\u0019;ICND\u0017N\\4\u0016\u0005\t=%#\u0002BI\u0001\nMeA\u0002B?k\u0001\u0011y\t\u0005\u0003I\u0005#b\u0017!D:ue&tw\rS1tQ&tw-\u0006\u0002\u0003\u001aJ)!1\u0014!\u0003\u001e\u001a1!Q\u0010\u001c\u0001\u00053\u0003B\u0001\u0013B)i\u0006\u0001RO\\8sI\u0016\u0014X\r\u001a%bg\"LgnZ\u000b\u0003\u0005G\u0013RA!*A\u0005\u00133aA! 8\u0001\t\r\u0006")
public class MurmurHash3 {
    public static Hashing<TraversableOnce<Object>> unorderedHashing() {
        return MurmurHash3$.MODULE$.unorderedHashing();
    }

    public static Hashing<String> stringHashing() {
        return MurmurHash3$.MODULE$.stringHashing();
    }

    public static Hashing<Product> productHashing() {
        return MurmurHash3$.MODULE$.productHashing();
    }

    public static Hashing<TraversableOnce<Object>> orderedHashing() {
        return MurmurHash3$.MODULE$.orderedHashing();
    }

    public static Hashing<byte[]> bytesHashing() {
        return MurmurHash3$.MODULE$.bytesHashing();
    }

    public static <T> ArrayHashing<T> arrayHashing() {
        return MurmurHash3$.MODULE$.arrayHashing();
    }

    public static int setHash(Set<?> set) {
        return MurmurHash3$.MODULE$.setHash(set);
    }

    public static int mapHash(Map<?, ?> map) {
        return MurmurHash3$.MODULE$.mapHash(map);
    }

    public static int seqHash(Seq<?> seq) {
        return MurmurHash3$.MODULE$.seqHash(seq);
    }

    public static int setSeed() {
        return MurmurHash3$.MODULE$.setSeed();
    }

    public static int mapSeed() {
        return MurmurHash3$.MODULE$.mapSeed();
    }

    public static int seqSeed() {
        return MurmurHash3$.MODULE$.seqSeed();
    }

    public static int traversableSeed() {
        return MurmurHash3$.MODULE$.traversableSeed();
    }

    public static int symmetricSeed() {
        return MurmurHash3$.MODULE$.symmetricSeed();
    }

    public static int productSeed() {
        return MurmurHash3$.MODULE$.productSeed();
    }

    public static int stringSeed() {
        return MurmurHash3$.MODULE$.stringSeed();
    }

    public static int arraySeed() {
        return MurmurHash3$.MODULE$.arraySeed();
    }

    public final int mix(int hash, int data) {
        return Integer.rotateLeft(this.mixLast(hash, data), 13) * 5 + -430675100;
    }

    public final int mixLast(int hash, int data) {
        int k = data * -862048943;
        k = Integer.rotateLeft(k, 15);
        return hash ^ (k *= 461845907);
    }

    public final int finalizeHash(int hash, int length) {
        return this.avalanche(hash ^ length);
    }

    /*
     * WARNING - void declaration
     */
    private final int avalanche(int hash) {
        void var2_2;
        int h = hash ^ hash >>> 16;
        h *= -2048144789;
        h ^= h >>> 13;
        h *= -1028477387;
        h ^= h >>> 16;
        return (int)var2_2;
    }

    public int product2Hash(Object x, Object y, int seed) {
        int h = this.mix(seed, Statics.anyHash(x));
        h = this.mix(h, Statics.anyHash(y));
        return this.finalizeHash(h, 2);
    }

    public final int productHash(Product x, int seed) {
        int arr = x.productArity();
        if (arr == 0) {
            return x.productPrefix().hashCode();
        }
        int h = seed;
        for (int i = 0; i < arr; ++i) {
            h = this.mix(h, Statics.anyHash(x.productElement(i)));
        }
        return this.finalizeHash(h, arr);
    }

    public final int stringHash(String str, int seed) {
        int h = seed;
        int i = 0;
        while (i + 1 < str.length()) {
            int data = (str.charAt(i) << 16) + str.charAt(i + 1);
            h = this.mix(h, data);
            i += 2;
        }
        if (i < str.length()) {
            h = this.mixLast(h, str.charAt(i));
        }
        return this.finalizeHash(h, str.length());
    }

    public final int unorderedHash(TraversableOnce<Object> xs, int seed) {
        if (xs.isEmpty()) {
            int h = this.mix(seed, 0);
            h = this.mix(h, 0);
            h = this.mixLast(h, 1);
            return this.finalizeHash(h, 0);
        }
        LazyRef hasher$module = new LazyRef();
        xs.foreach(this.hasher$2(hasher$module));
        int h = this.mix(seed, this.hasher$2(hasher$module).a());
        h = this.mix(h, this.hasher$2(hasher$module).b());
        h = this.mixLast(h, this.hasher$2(hasher$module).c());
        return this.finalizeHash(h, this.hasher$2(hasher$module).n());
    }

    public final int orderedHash(TraversableOnce<Object> xs, int seed) {
        if (xs.isEmpty()) {
            return this.finalizeHash(seed, 0);
        }
        LazyRef hasher$module = new LazyRef();
        xs.foreach(this.hasher$4(hasher$module, seed));
        return this.finalizeHash(this.hasher$4(hasher$module, seed).h(), this.hasher$4(hasher$module, seed).n());
    }

    public final <T> int arrayHash(Object a, int seed) {
        int h = seed;
        for (int i = 0; i < ScalaRunTime$.MODULE$.array_length(a); ++i) {
            h = this.mix(h, Statics.anyHash(ScalaRunTime$.MODULE$.array_apply(a, i)));
        }
        return this.finalizeHash(h, ScalaRunTime$.MODULE$.array_length(a));
    }

    public final int bytesHash(byte[] data, int seed) {
        int len;
        int h = seed;
        int i = 0;
        for (len = data.length; len >= 4; len -= 4) {
            int k = data[i + 0] & 0xFF;
            k |= (data[i + 1] & 0xFF) << 8;
            k |= (data[i + 2] & 0xFF) << 16;
            h = this.mix(h, k |= (data[i + 3] & 0xFF) << 24);
            i += 4;
        }
        int k = 0;
        if (len == 3) {
            k ^= (data[i + 2] & 0xFF) << 16;
        }
        if (len >= 2) {
            k ^= (data[i + 1] & 0xFF) << 8;
        }
        if (len >= 1) {
            h = this.mixLast(h, k ^= data[i + 0] & 0xFF);
        }
        return this.finalizeHash(h, data.length);
    }

    public final int listHash(List<?> xs, int seed) {
        int n = 0;
        int h = seed;
        List elems = xs;
        while (!elems.isEmpty()) {
            Object head = elems.head();
            List tail = (List)elems.tail();
            h = this.mix(h, Statics.anyHash(head));
            ++n;
            elems = tail;
        }
        return this.finalizeHash(h, n);
    }

    public final int arrayHash$mZc$sp(boolean[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, a[i] ? 1231 : 1237);
        }
        return this.finalizeHash(h, a.length);
    }

    public final int arrayHash$mBc$sp(byte[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, a[i]);
        }
        return this.finalizeHash(h, a.length);
    }

    public final int arrayHash$mCc$sp(char[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, a[i]);
        }
        return this.finalizeHash(h, a.length);
    }

    public final int arrayHash$mDc$sp(double[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, Statics.doubleHash(a[i]));
        }
        return this.finalizeHash(h, a.length);
    }

    public final int arrayHash$mFc$sp(float[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, Statics.floatHash(a[i]));
        }
        return this.finalizeHash(h, a.length);
    }

    public final int arrayHash$mIc$sp(int[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, a[i]);
        }
        return this.finalizeHash(h, a.length);
    }

    public final int arrayHash$mJc$sp(long[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, Statics.longHash(a[i]));
        }
        return this.finalizeHash(h, a.length);
    }

    public final int arrayHash$mSc$sp(short[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, a[i]);
        }
        return this.finalizeHash(h, a.length);
    }

    public final int arrayHash$mVc$sp(BoxedUnit[] a, int seed) {
        int h = seed;
        for (int i = 0; i < a.length; ++i) {
            h = this.mix(h, 0);
        }
        return this.finalizeHash(h, a.length);
    }

    private static final /* synthetic */ MurmurHash3$hasher$1$ hasher$lzycompute$1(LazyRef hasher$module$1) {
        synchronized (hasher$module$1) {
            MurmurHash3$hasher$1$ murmurHash3$hasher$1$ = hasher$module$1.initialized() ? (MurmurHash3$hasher$1$)hasher$module$1.value() : hasher$module$1.initialize(new MurmurHash3$hasher$1$(null));
            return murmurHash3$hasher$1$;
        }
    }

    private final MurmurHash3$hasher$1$ hasher$2(LazyRef hasher$module$1) {
        if (hasher$module$1.initialized()) {
            return (MurmurHash3$hasher$1$)hasher$module$1.value();
        }
        return MurmurHash3.hasher$lzycompute$1(hasher$module$1);
    }

    private final /* synthetic */ MurmurHash3$hasher$3$ hasher$lzycompute$2(LazyRef hasher$module$2, int seed$1) {
        synchronized (hasher$module$2) {
            MurmurHash3$hasher$3$ murmurHash3$hasher$3$ = hasher$module$2.initialized() ? (MurmurHash3$hasher$3$)hasher$module$2.value() : hasher$module$2.initialize(new MurmurHash3$hasher$3$(this, seed$1));
            return murmurHash3$hasher$3$;
        }
    }

    private final MurmurHash3$hasher$3$ hasher$4(LazyRef hasher$module$2, int seed$1) {
        if (hasher$module$2.initialized()) {
            return (MurmurHash3$hasher$3$)hasher$module$2.value();
        }
        return this.hasher$lzycompute$2(hasher$module$2, seed$1);
    }

    public static class ArrayHashing<T>
    implements Hashing<Object> {
        @Override
        public int hash(Object a) {
            return MurmurHash3$.MODULE$.arrayHash(a);
        }

        public int hash$mcZ$sp(boolean[] a) {
            return this.hash(a);
        }

        public int hash$mcB$sp(byte[] a) {
            return this.hash(a);
        }

        public int hash$mcC$sp(char[] a) {
            return this.hash(a);
        }

        public int hash$mcD$sp(double[] a) {
            return this.hash(a);
        }

        public int hash$mcF$sp(float[] a) {
            return this.hash(a);
        }

        public int hash$mcI$sp(int[] a) {
            return this.hash(a);
        }

        public int hash$mcJ$sp(long[] a) {
            return this.hash(a);
        }

        public int hash$mcS$sp(short[] a) {
            return this.hash(a);
        }

        public int hash$mcV$sp(BoxedUnit[] a) {
            return this.hash(a);
        }
    }
}

