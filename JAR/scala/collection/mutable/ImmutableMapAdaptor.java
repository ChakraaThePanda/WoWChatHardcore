/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Function2;
import scala.Option;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.collection.Set;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.collection.mutable.AbstractMap;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005ee\u0001B\r\u001b\u0001\u0005B\u0001\u0002\u0010\u0001\u0003\u0002\u0004%\t\"\u0010\u0005\t\u0007\u0002\u0011\t\u0019!C\t\t\"A!\n\u0001B\u0001B\u0003&a\bC\u0003L\u0001\u0011\u0005A\nC\u0003P\u0001\u0011\u0005\u0003\u000bC\u0003U\u0001\u0011\u0005Q\u000bC\u0003\\\u0001\u0011\u0005C\fC\u0003a\u0001\u0011\u0005\u0013\rC\u0003d\u0001\u0011\u0005C\rC\u0003g\u0001\u0011\u0005s\rC\u0003j\u0001\u0011\u0005#\u000eC\u0003p\u0001\u0011\u0005\u0003\u000fC\u0003u\u0001\u0011\u0005S\u000fC\u0004\u0002\n\u0001!\t%a\u0003\t\u000f\u0005=\u0001\u0001\"\u0011\u0002\u0012!9\u00111\u0004\u0001\u0005\u0002\u0005u\u0001bBA\u0014\u0001\u0011\u0005\u0013\u0011\u0006\u0005\b\u0003s\u0001A\u0011IA\u001e\u0011\u001d\t\u0019\u0005\u0001C\u0001\u0003\u000bBq!a\u0013\u0001\t\u0003\ti\u0005C\u0004\u0002T\u0001!\t%!\u0016\t\u000f\u0005]\u0003\u0001\"\u0011\u0002Z!9\u0011Q\r\u0001\u0005B\u0005\u001d\u0004bBA8\u0001\u0011\u0005\u0013\u0011\u000f\u0002\u0014\u00136lW\u000f^1cY\u0016l\u0015\r]!eCB$xN\u001d\u0006\u00037q\tq!\\;uC\ndWM\u0003\u0002\u001e=\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003}\tQa]2bY\u0006\u001c\u0001!F\u0002#SQ\u001aB\u0001A\u00127sA!A%J\u00144\u001b\u0005Q\u0012B\u0001\u0014\u001b\u0005-\t%m\u001d;sC\u000e$X*\u00199\u0011\u0005!JC\u0002\u0001\u0003\u0006U\u0001\u0011\ra\u000b\u0002\u0002\u0003F\u0011A\u0006\r\t\u0003[9j\u0011AH\u0005\u0003_y\u0011qAT8uQ&tw\r\u0005\u0002.c%\u0011!G\b\u0002\u0004\u0003:L\bC\u0001\u00155\t\u0015)\u0004A1\u0001,\u0005\u0005\u0011\u0005\u0003\u0002\u00138OMJ!\u0001\u000f\u000e\u0003\u00075\u000b\u0007\u000f\u0005\u0002.u%\u00111H\b\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0005S6\f\u0007/F\u0001?!\u0011y$iJ\u001a\u000e\u0003\u0001S!!\u0011\u000f\u0002\u0013%lW.\u001e;bE2,\u0017B\u0001\u001dA\u0003!IW.\u00199`I\u0015\fHCA#I!\tic)\u0003\u0002H=\t!QK\\5u\u0011\u001dI%!!AA\u0002y\n1\u0001\u001f\u00132\u0003\u0015IW.\u00199!\u0003\u0019a\u0014N\\5u}Q\u0011QJ\u0014\t\u0005I\u000193\u0007C\u0003=\t\u0001\u0007a(\u0001\u0003tSj,W#A)\u0011\u00055\u0012\u0016BA*\u001f\u0005\rIe\u000e^\u0001\u0004O\u0016$HC\u0001,Z!\riskM\u0005\u00031z\u0011aa\u00149uS>t\u0007\"\u0002.\u0007\u0001\u00049\u0013aA6fs\u00069\u0011n]#naRLX#A/\u0011\u00055r\u0016BA0\u001f\u0005\u001d\u0011un\u001c7fC:\fQ!\u00199qYf$\"a\r2\t\u000biC\u0001\u0019A\u0014\u0002\u0011\r|g\u000e^1j]N$\"!X3\t\u000biK\u0001\u0019A\u0014\u0002\u0017%\u001cH)\u001a4j]\u0016$\u0017\t\u001e\u000b\u0003;\"DQA\u0017\u0006A\u0002\u001d\naa[3z'\u0016$X#A6\u0011\u00071lw%D\u0001\u001d\u0013\tqGDA\u0002TKR\fAb[3zg&#XM]1u_J,\u0012!\u001d\t\u0004YJ<\u0013BA:\u001d\u0005!IE/\u001a:bi>\u0014\u0018\u0001B6fsN,\u0012A\u001e\t\u0004Y^<\u0013B\u0001=\u001d\u0005!IE/\u001a:bE2,\u0007FB\u0007{\u0003\u0003\t)\u0001\u0005\u0002|}6\tAP\u0003\u0002~=\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005}d(!C7jOJ\fG/[8oC\t\t\u0019!A\u001aaW\u0016L8\u000f\u0019\u0011sKR,(O\\:!\u0013R,'/\u00192mKn\u000bU\f\t:bi\",'\u000f\t;iC:\u0004\u0013\n^3sCR|'oW!^]\u0005\u0012\u0011qA\u0001\u0006e9Bd\u0006M\u0001\u000fm\u0006dW/Z:Ji\u0016\u0014\u0018\r^8s+\t\ti\u0001E\u0002meN\naA^1mk\u0016\u001cXCAA\n!\rawo\r\u0015\u0007\u001fi\f9\"!\u0002\"\u0005\u0005e\u0011!\u000e1wC2,Xm\u001d1!e\u0016$XO\u001d8tA%#XM]1cY\u0016\\&)\u0018\u0011sCRDWM\u001d\u0011uQ\u0006t\u0007%\u0013;fe\u0006$xN].C;:\n\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0003?\u0001B\u0001\u001c:\u0002\"A)Q&a\t(g%\u0019\u0011Q\u0005\u0010\u0003\rQ+\b\u000f\\33\u0003\u0019!x\u000eT5tiV\u0011\u00111\u0006\t\u0007\u0003[\t\u0019$!\t\u000f\u00075\ny#C\u0002\u00022y\tq\u0001]1dW\u0006<W-\u0003\u0003\u00026\u0005]\"\u0001\u0002'jgRT1!!\r\u001f\u0003\u0019)\b\u000fZ1uKR)Q)!\u0010\u0002@!)!L\u0005a\u0001O!1\u0011\u0011\t\nA\u0002M\nQA^1mk\u0016\f\u0011\u0002J7j]V\u001cH%Z9\u0015\t\u0005\u001d\u0013\u0011J\u0007\u0002\u0001!)!l\u0005a\u0001O\u0005AA\u0005\u001d7vg\u0012*\u0017\u000f\u0006\u0003\u0002H\u0005=\u0003bBA))\u0001\u0007\u0011\u0011E\u0001\u0003WZ\fQa\u00197fCJ$\u0012!R\u0001\niJ\fgn\u001d4pe6$B!a\u0012\u0002\\!9\u0011Q\f\fA\u0002\u0005}\u0013!\u00014\u0011\r5\n\tgJ\u001a4\u0013\r\t\u0019G\b\u0002\n\rVt7\r^5p]J\naA]3uC&tG\u0003BA$\u0003SBq!a\u001b\u0018\u0001\u0004\ti'A\u0001q!\u0019i\u0013\u0011M\u00144;\u0006AAo\\*ue&tw\r\u0006\u0002\u0002tA!\u0011QOAB\u001d\u0011\t9(a \u0011\u0007\u0005ed$\u0004\u0002\u0002|)\u0019\u0011Q\u0010\u0011\u0002\rq\u0012xn\u001c;?\u0013\r\t\tIH\u0001\u0007!J,G-\u001a4\n\t\u0005\u0015\u0015q\u0011\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005\u0005e\u0004K\u0004\u0001\u0003\u0017\u000b\t*!&\u0011\u00075\ni)C\u0002\u0002\u0010z\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\t\u0019*\u0001#bI\u0006\u0004Ho\u001c:tA\u0005\u0014X\rI5oQ\u0016\u0014XM\u001c;ms\u0002*hN]3mS\u0006\u0014G.\u001a\u0011b]\u0012\u0004\u0003O]8oK\u0002\"x\u000e\t9fe\u001a|'/\\1oG\u0016\u0004\u0003O]8cY\u0016l7/\t\u0002\u0002\u0018\u00061!GL\u00192]A\u0002")
public class ImmutableMapAdaptor<A, B>
extends AbstractMap<A, B>
implements Serializable {
    private Map<A, B> imap;

    public Map<A, B> imap() {
        return this.imap;
    }

    public void imap_$eq(Map<A, B> x$1) {
        this.imap = x$1;
    }

    @Override
    public int size() {
        return this.imap().size();
    }

    @Override
    public Option<B> get(A key) {
        return this.imap().get(key);
    }

    @Override
    public boolean isEmpty() {
        return this.imap().isEmpty();
    }

    @Override
    public B apply(A key) {
        return (B)this.imap().apply(key);
    }

    @Override
    public boolean contains(A key) {
        return this.imap().contains(key);
    }

    @Override
    public boolean isDefinedAt(A key) {
        return this.imap().isDefinedAt(key);
    }

    @Override
    public Set<A> keySet() {
        return this.imap().keySet();
    }

    @Override
    public Iterator<A> keysIterator() {
        return this.imap().keysIterator();
    }

    @Override
    public Iterable<A> keys() {
        return this.imap().keys();
    }

    @Override
    public Iterator<B> valuesIterator() {
        return this.imap().valuesIterator();
    }

    @Override
    public Iterable<B> values() {
        return this.imap().values();
    }

    @Override
    public Iterator<Tuple2<A, B>> iterator() {
        return this.imap().iterator();
    }

    @Override
    public List<Tuple2<A, B>> toList() {
        return this.imap().toList();
    }

    @Override
    public void update(A key, B value) {
        this.imap_$eq(this.imap().updated(key, value));
    }

    public ImmutableMapAdaptor<A, B> $minus$eq(A key) {
        this.imap_$eq((Map)this.imap().$minus(key));
        return this;
    }

    @Override
    public ImmutableMapAdaptor<A, B> $plus$eq(Tuple2<A, B> kv) {
        this.imap_$eq(this.imap().$plus(kv));
        return this;
    }

    @Override
    public void clear() {
        this.imap_$eq(this.imap().empty());
    }

    public ImmutableMapAdaptor<A, B> transform(Function2<A, B, B> f) {
        this.imap_$eq(this.imap().transform(f, Map$.MODULE$.canBuildFrom()));
        return this;
    }

    public ImmutableMapAdaptor<A, B> retain(Function2<A, B, Object> p) {
        this.imap_$eq((Map)this.imap().filter((Function1<Tuple2, Object> & java.io.Serializable & Serializable)(A xy) -> BoxesRunTime.boxToBoolean(ImmutableMapAdaptor.$anonfun$retain$1(p, xy))));
        return this;
    }

    @Override
    public String toString() {
        return this.imap().toString();
    }

    public static final /* synthetic */ boolean $anonfun$retain$1(Function2 p$1, Tuple2 xy) {
        return BoxesRunTime.unboxToBoolean(p$1.apply(xy._1(), xy._2()));
    }

    public ImmutableMapAdaptor(Map<A, B> imap) {
        this.imap = imap;
    }
}

