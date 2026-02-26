/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Function2;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.mutable.AbstractMap;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.HashTable$;
import scala.collection.mutable.OpenHashMap$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.Statics;
import scala.sys.package$;

@ScalaSignature(bytes="\u0006\u0001\tms!\u0002\u001c8\u0011\u0003qd!\u0002!8\u0011\u0003\t\u0005\"\u0002$\u0002\t\u00039\u0005\"\u0002%\u0002\t\u0003I\u0005bBA\u0017\u0003\u0011\u0005!Q\n\u0004\u0005_\u00061\u0001\u000f\u0003\u0005s\u000b\t\u0005\r\u0011\"\u0001t\u0011!1XA!a\u0001\n\u00039\b\u0002C?\u0006\u0005\u0003\u0005\u000b\u0015\u0002;\t\u0011y,!\u00111A\u0005\u0002}D!\"!\u0001\u0006\u0005\u0003\u0007I\u0011AA\u0002\u0011%\t9!\u0002B\u0001B\u0003&q\r\u0003\u0006\u0002\n\u0015\u0011\t\u0019!C\u0001\u0003\u0017A!\"a\u0006\u0006\u0005\u0003\u0007I\u0011AA\r\u0011)\ti\"\u0002B\u0001B\u0003&\u0011Q\u0002\u0005\u0007\r\u0016!\t!a\b\u0007\t\u0001;\u0004\u0001\u0014\u0005\tMB\u0011\t\u0011)A\u0005O\")a\t\u0005C\u0001U\u0016!A\u000e\u0005\u0003n\u0011\u00191\u0005\u0003\"\u0001\u0002,!9\u0011Q\u0006\t\u0005B\u0005=\u0002bBA\u0019!\u0001\u0006Ia\u001a\u0005\t\u0003g\u0001\u0002\u0019!C\u0005\u007f\"I\u0011Q\u0007\tA\u0002\u0013%\u0011q\u0007\u0005\b\u0003w\u0001\u0002\u0015)\u0003h\u0011!\ti\u0004\u0005Q!\n\u0005}\u0002\u0002CA%!\u0001\u0007I\u0011B@\t\u0013\u0005-\u0003\u00031A\u0005\n\u00055\u0003bBA)!\u0001\u0006Ka\u001a\u0005\u000e\u0003'\u0002B\u0011!A\u0003\u0002\u0003\u0007I\u0011B@\t\u001d\u0005U\u0003\u0003\"A\u0001\u0006\u0003\u0005\r\u0011\"\u0003\u0002X!Q\u00111\f\t\u0003\u0002\u0003\u0005\u000b\u0015B4\t\u000f\u0005u\u0003\u0003)Q\u0005O\"1\u0011q\f\t\u0005B}Da\"!\u0019\u0011\t\u0003\u0005)\u0011!A!\n\u0013\t\u0019\u0007C\u0004\u0002jA!\t\"a\u001b\t\u0011\u0005=\u0004\u0003)C\u0005\u0003cB\u0001\"a\u001d\u0011A\u0013%\u0011Q\u000f\u0005\b\u0003w\u0002B\u0011IA?\u0011\u001d\t\u0019\t\u0005C\u0001\u0003\u000bCq!!)\u0011\t\u0003\t\u0019\u000bC\u0004\u0002.B!\t%a,\t\u000f\u00055\u0006\u0003\"\u0003\u00028\"A\u0011q\u0018\t!\n\u0013\t\t\rC\u0004\u0002PB!\t%!5\t\u000f\u0005U\u0007\u0003\"\u0001\u0002X\"9\u00111\u001c\t\u0005\u0002\u0005u\u0007bBAt!\u0011\u0005\u00131\u0006\u0005\b\u0003S\u0004B\u0011IAv\u0011!\ty\u0010\u0005Q\u0005\n\t\u0005\u0001b\u0002B\u0004!\u0011\u0005#\u0011\u0002\u0005\b\u0005'\u0001B\u0011\tB\u000b\u0011\u001d\u0011\t\u0003\u0005C!\u0005G\t1b\u00149f]\"\u000b7\u000f['ba*\u0011\u0001(O\u0001\b[V$\u0018M\u00197f\u0015\tQ4(\u0001\u0006d_2dWm\u0019;j_:T\u0011\u0001P\u0001\u0006g\u000e\fG.Y\u0002\u0001!\ty\u0014!D\u00018\u0005-y\u0005/\u001a8ICNDW*\u00199\u0014\u0005\u0005\u0011\u0005CA\"E\u001b\u0005Y\u0014BA#<\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012AP\u0001\u0006CB\u0004H._\u000b\u0006\u0015\n]\"Q\b\u000b\u0004\u0017\n\u0005\u0003CB \u0011\u0005k\u0011Y$F\u0002N'v\u001bB\u0001\u0005(`EB!qhT)]\u0013\t\u0001vGA\u0006BEN$(/Y2u\u001b\u0006\u0004\bC\u0001*T\u0019\u0001!Q\u0001\u0016\tC\u0002U\u00131aS3z#\t1\u0016\f\u0005\u0002D/&\u0011\u0001l\u000f\u0002\b\u001d>$\b.\u001b8h!\t\u0019%,\u0003\u0002\\w\t\u0019\u0011I\\=\u0011\u0005IkF!\u00020\u0011\u0005\u0004)&!\u0002,bYV,\u0007\u0003B a#rK!!Y\u001c\u0003\u00075\u000b\u0007\u000fE\u0003@GFcV-\u0003\u0002eo\t9Q*\u00199MS.,\u0007\u0003B \u0011#r\u000b1\"\u001b8ji&\fGnU5{KB\u00111\t[\u0005\u0003Sn\u00121!\u00138u)\t)7\u000eC\u0003g%\u0001\u0007qMA\u0003F]R\u0014\u0018\u0010\u0005\u0003o\u000bEcfBA \u0001\u0005%y\u0005/\u001a8F]R\u0014\u00180\u0006\u0003rk\u0006U1CA\u0003C\u0003\rYW-_\u000b\u0002iB\u0011!+\u001e\u0003\u0006)\u0016\u0011\r!V\u0001\bW\u0016Lx\fJ3r)\tA8\u0010\u0005\u0002Ds&\u0011!p\u000f\u0002\u0005+:LG\u000fC\u0004}\u000f\u0005\u0005\t\u0019\u0001;\u0002\u0007a$\u0013'\u0001\u0003lKf\u0004\u0013\u0001\u00025bg\",\u0012aZ\u0001\tQ\u0006\u001c\bn\u0018\u0013fcR\u0019\u00010!\u0002\t\u000fqT\u0011\u0011!a\u0001O\u0006)\u0001.Y:iA\u0005)a/\u00197vKV\u0011\u0011Q\u0002\t\u0006\u0007\u0006=\u00111C\u0005\u0004\u0003#Y$AB(qi&|g\u000eE\u0002S\u0003+!QAX\u0003C\u0002U\u000b\u0011B^1mk\u0016|F%Z9\u0015\u0007a\fY\u0002\u0003\u0005}\u001b\u0005\u0005\t\u0019AA\u0007\u0003\u00191\u0018\r\\;fAQA\u0011\u0011EA\u0013\u0003O\tI\u0003\u0005\u0004\u0002$\u0015!\u00181C\u0007\u0002\u0003!)!o\u0004a\u0001i\")ap\u0004a\u0001O\"9\u0011\u0011B\bA\u0002\u00055A#A3\u0002\u000b\u0015l\u0007\u000f^=\u0016\u0003\u0015\f\u0011#Y2uk\u0006d\u0017J\\5uS\u0006d7+\u001b>f\u0003\u0011i\u0017m]6\u0002\u00115\f7o[0%KF$2\u0001_A\u001d\u0011\u001da\b$!AA\u0002\u001d\fQ!\\1tW\u0002\nQ\u0001^1cY\u0016\u0004RaQA!\u0003\u000bJ1!a\u0011<\u0005\u0015\t%O]1z!\r\t9eE\u0007\u0002!\u0005)ql]5{K\u0006Iql]5{K~#S-\u001d\u000b\u0004q\u0006=\u0003b\u0002?\u001d\u0003\u0003\u0005\raZ\u0001\u0007?NL'0\u001a\u0011\u0002[M\u001c\u0017\r\\1%G>dG.Z2uS>tG%\\;uC\ndW\rJ(qK:D\u0015m\u001d5NCB$C\u0005Z3mKR,G-A\u0019tG\u0006d\u0017\rJ2pY2,7\r^5p]\u0012jW\u000f^1cY\u0016$s\n]3o\u0011\u0006\u001c\b.T1qI\u0011\"W\r\\3uK\u0012|F%Z9\u0015\u0007a\fI\u0006C\u0004}?\u0005\u0005\t\u0019A4\u0002]M\u001c\u0017\r\\1%G>dG.Z2uS>tG%\\;uC\ndW\rJ(qK:D\u0015m\u001d5NCB$C\u0005Z3mKR,G\rI\u0001\t[>$7i\\;oi\u0006!1/\u001b>f\u00039\u001a8-\u00197bI\r|G\u000e\\3di&|g\u000eJ7vi\u0006\u0014G.\u001a\u0013Pa\u0016t\u0007*Y:i\u001b\u0006\u0004H\u0005J:ju\u0016|F%Z9\u0015\u0007a\f)\u0007\u0003\u0004\u0002h\r\u0002\raZ\u0001\u0002g\u00061\u0001.Y:i\u001f\u001a$2aZA7\u0011\u0015\u0011H\u00051\u0001R\u0003%9'o\\<UC\ndW\rF\u0001y\u0003%1\u0017N\u001c3J]\u0012,\u0007\u0010F\u0003h\u0003o\nI\bC\u0003sM\u0001\u0007\u0011\u000bC\u0003\u007fM\u0001\u0007q-\u0001\u0004va\u0012\fG/\u001a\u000b\u0006q\u0006}\u0014\u0011\u0011\u0005\u0006e\u001e\u0002\r!\u0015\u0005\u0007\u0003\u00139\u0003\u0019\u0001/\u0002\u0011\u0011\u0002H.^:%KF$B!a\u0012\u0002\b\"9\u0011\u0011\u0012\u0015A\u0002\u0005-\u0015AA6w!\u0015\u0019\u0015QR)]\u0013\r\tyi\u000f\u0002\u0007)V\u0004H.\u001a\u001a)\u000f!\n\u0019*!'\u0002\u001eB\u00191)!&\n\u0007\u0005]5H\u0001\u000beKB\u0014XmY1uK\u0012|e/\u001a:sS\u0012LgnZ\u0011\u0003\u00037\u000baiK\u001f!g\"|W\u000f\u001c3!]>$\bEY3!_Z,'O]5eI\u0016t\u0007%\u001b8!_J$WM\u001d\u0011u_\u0002j\u0017-\u001b8uC&t\u0007eY8og&\u001cH/\u001a8ds\u0002:\u0018\u000e\u001e5!aV$h&\t\u0002\u0002 \u00061!GL\u00192]A\n\u0011\u0002J7j]V\u001cH%Z9\u0015\t\u0005\u001d\u0013Q\u0015\u0005\u0006e&\u0002\r!\u0015\u0015\bS\u0005M\u0015\u0011VAOC\t\tY+A%.{\u0001\u001a\bn\\;mI\u0002rw\u000e\u001e\u0011cK\u0002zg/\u001a:sS\u0012$WM\u001c\u0011j]\u0002z'\u000fZ3sAQ|\u0007%\\1j]R\f\u0017N\u001c\u0011d_:\u001c\u0018n\u001d;f]\u000eL\be^5uQ\u0002\u0012X-\\8wK:\n1\u0001];u)\u0019\t\t,a-\u00026B!1)a\u0004]\u0011\u0015\u0011(\u00061\u0001R\u0011\u0019\tIA\u000ba\u00019RA\u0011\u0011WA]\u0003w\u000bi\fC\u0003sW\u0001\u0007\u0011\u000bC\u0003\u007fW\u0001\u0007q\r\u0003\u0004\u0002\n-\u0002\r\u0001X\u0001\u000bI\u0016dW\r^3TY>$Hc\u0001=\u0002D\"9\u0011Q\u0019\u0017A\u0002\u0005\u0015\u0013!B3oiJL\bf\u0001\u0017\u0002JB\u00191)a3\n\u0007\u000557H\u0001\u0004j]2Lg.Z\u0001\u0007e\u0016lwN^3\u0015\t\u0005E\u00161\u001b\u0005\u0006e6\u0002\r!U\u0001\u0004O\u0016$H\u0003BAY\u00033DQA\u001d\u0018A\u0002E\u000b\u0001\"\u001b;fe\u0006$xN]\u000b\u0003\u0003?\u0004b!!9\u0002d\u0006-U\"A\u001d\n\u0007\u0005\u0015\u0018H\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003\u0015\u0019Gn\u001c8f\u0003\u001d1wN]3bG\",B!!<\u0002|R\u0019\u00010a<\t\u000f\u0005E\u0018\u00071\u0001\u0002t\u0006\ta\rE\u0004D\u0003k\fY)!?\n\u0007\u0005]8HA\u0005Gk:\u001cG/[8ocA\u0019!+a?\u0005\r\u0005u\u0018G1\u0001V\u0005\u0005)\u0016!\u00064pe\u0016\f7\r[+oI\u0016dW\r^3e\u000b:$(/\u001f\u000b\u0004q\n\r\u0001bBAye\u0001\u0007!Q\u0001\t\u0007\u0007\u0006U\u0018Q\t=\u0002\u0013Q\u0014\u0018M\\:g_JlG\u0003BA$\u0005\u0017Aq!!=4\u0001\u0004\u0011i\u0001\u0005\u0004D\u0005\u001f\tF\fX\u0005\u0004\u0005#Y$!\u0003$v]\u000e$\u0018n\u001c83\u0003\u0019\u0011X\r^1j]R!\u0011q\tB\f\u0011\u001d\t\t\u0010\u000ea\u0001\u00053\u0001ra\u0011B\b#r\u0013Y\u0002E\u0002D\u0005;I1Aa\b<\u0005\u001d\u0011un\u001c7fC:\fAb\u001d;sS:<\u0007K]3gSb,\"A!\n\u0011\t\t\u001d\"\u0011G\u0007\u0003\u0005SQAAa\u000b\u0003.\u0005!A.\u00198h\u0015\t\u0011y#\u0001\u0003kCZ\f\u0017\u0002\u0002B\u001a\u0005S\u0011aa\u0015;sS:<\u0007c\u0001*\u00038\u00111!\u0011H\u0002C\u0002U\u0013\u0011a\u0013\t\u0004%\nuBA\u0002B \u0007\t\u0007QKA\u0001W\u0011\u001d\u0011\u0019e\u0001a\u0001\u0005\u000b\nQ!\u001a7f[N\u0004Ra\u0011B$\u0005\u0017J1A!\u0013<\u0005)a$/\u001a9fCR,GM\u0010\t\b\u0007\u00065%Q\u0007B\u001e+\u0019\u0011yE!\u0016\u0003ZU\u0011!\u0011\u000b\t\u0007\u007fA\u0011\u0019Fa\u0016\u0011\u0007I\u0013)\u0006\u0002\u0004\u0003:\u0011\u0011\r!\u0016\t\u0004%\neCA\u0002B \t\t\u0007Q\u000b")
public class OpenHashMap<Key, Value>
extends AbstractMap<Key, Value> {
    private final int actualInitialSize;
    private int scala$collection$mutable$OpenHashMap$$mask;
    public OpenEntry<Key, Value>[] scala$collection$mutable$OpenHashMap$$table;
    private int _size;
    private int scala$collection$mutable$OpenHashMap$$deleted;
    public int scala$collection$mutable$OpenHashMap$$modCount;

    @Override
    public OpenHashMap<Key, Value> empty() {
        return OpenHashMap$.MODULE$.empty();
    }

    public int scala$collection$mutable$OpenHashMap$$mask() {
        return this.scala$collection$mutable$OpenHashMap$$mask;
    }

    private void scala$collection$mutable$OpenHashMap$$mask_$eq(int x$1) {
        this.scala$collection$mutable$OpenHashMap$$mask = x$1;
    }

    private int _size() {
        return this._size;
    }

    private void _size_$eq(int x$1) {
        this._size = x$1;
    }

    public int scala$collection$mutable$OpenHashMap$$deleted() {
        return this.scala$collection$mutable$OpenHashMap$$deleted;
    }

    public void scala$collection$mutable$OpenHashMap$$deleted_$eq(int x$1) {
        this.scala$collection$mutable$OpenHashMap$$deleted = x$1;
    }

    @Override
    public int size() {
        return this._size();
    }

    public void scala$collection$mutable$OpenHashMap$$size_$eq(int s) {
        this._size_$eq(s);
    }

    public int hashOf(Key key) {
        int h = Statics.anyHash(key);
        h ^= h >>> 20 ^ h >>> 12;
        return h ^ h >>> 7 ^ h >>> 4;
    }

    private void growTable() {
        int oldSize = this.scala$collection$mutable$OpenHashMap$$mask() + 1;
        int newSize = 4 * oldSize;
        OpenEntry<Key, Value>[] oldTable = this.scala$collection$mutable$OpenHashMap$$table;
        this.scala$collection$mutable$OpenHashMap$$table = new OpenEntry[newSize];
        this.scala$collection$mutable$OpenHashMap$$mask_$eq(newSize - 1);
        ArrayOps.ofRef<Object> foreach_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])oldTable));
        int foreach_len = foreach_this.length();
        for (int foreach_i = 0; foreach_i < foreach_len; ++foreach_i) {
            OpenEntry openEntry = (OpenEntry)foreach_this.apply(foreach_i);
            OpenHashMap.$anonfun$growTable$1$adapted(this, openEntry);
        }
        this.scala$collection$mutable$OpenHashMap$$deleted_$eq(0);
    }

    private int findIndex(Key key, int hash) {
        int index = hash & this.scala$collection$mutable$OpenHashMap$$mask();
        int j = 0;
        int firstDeletedIndex = -1;
        OpenEntry<Key, Value> entry = this.scala$collection$mutable$OpenHashMap$$table[index];
        while (entry != null) {
            if (entry.hash() == hash && BoxesRunTime.equals(entry.key(), key)) {
                Option<Value> option = entry.value();
                None$ none$ = None$.MODULE$;
                if (option == null ? none$ != null : !option.equals(none$)) {
                    return index;
                }
            }
            if (firstDeletedIndex == -1) {
                Option<Value> option = entry.value();
                None$ none$ = None$.MODULE$;
                if (!(option != null ? !option.equals(none$) : none$ != null)) {
                    firstDeletedIndex = index;
                }
            }
            index = index + ++j & this.scala$collection$mutable$OpenHashMap$$mask();
            entry = this.scala$collection$mutable$OpenHashMap$$table[index];
        }
        if (firstDeletedIndex == -1) {
            return index;
        }
        return firstDeletedIndex;
    }

    @Override
    public void update(Key key, Value value) {
        this.put(key, value);
    }

    @Override
    public OpenHashMap<Key, Value> $plus$eq(Tuple2<Key, Value> kv) {
        this.put(kv._1(), kv._2());
        return this;
    }

    public OpenHashMap<Key, Value> $minus$eq(Key key) {
        this.remove(key);
        return this;
    }

    @Override
    public Option<Value> put(Key key, Value value) {
        return this.put(key, this.hashOf(key), value);
    }

    private Option<Value> put(Key key, int hash, Value value) {
        int index;
        OpenEntry<Key, Value> entry;
        if (2 * (this.size() + this.scala$collection$mutable$OpenHashMap$$deleted()) > this.scala$collection$mutable$OpenHashMap$$mask()) {
            this.growTable();
        }
        if ((entry = this.scala$collection$mutable$OpenHashMap$$table[index = this.findIndex(key, hash)]) == null) {
            this.scala$collection$mutable$OpenHashMap$$table[index] = new OpenEntry<Key, Value>(key, hash, new Some<Value>(value));
            ++this.scala$collection$mutable$OpenHashMap$$modCount;
            this.scala$collection$mutable$OpenHashMap$$size_$eq(this.size() + 1);
            return None$.MODULE$;
        }
        Option<Value> res = entry.value();
        Option<Value> option = entry.value();
        None$ none$ = None$.MODULE$;
        if (!(option != null ? !option.equals(none$) : none$ != null)) {
            entry.key_$eq(key);
            entry.hash_$eq(hash);
            this.scala$collection$mutable$OpenHashMap$$size_$eq(this.size() + 1);
            this.scala$collection$mutable$OpenHashMap$$deleted_$eq(this.scala$collection$mutable$OpenHashMap$$deleted() - 1);
            ++this.scala$collection$mutable$OpenHashMap$$modCount;
        }
        entry.value_$eq(new Some<Value>(value));
        return res;
    }

    private void deleteSlot(OpenEntry<Key, Value> entry) {
        entry.key_$eq(null);
        entry.hash_$eq(0);
        entry.value_$eq(None$.MODULE$);
        this.scala$collection$mutable$OpenHashMap$$size_$eq(this.size() - 1);
        this.scala$collection$mutable$OpenHashMap$$deleted_$eq(this.scala$collection$mutable$OpenHashMap$$deleted() + 1);
    }

    @Override
    public Option<Value> remove(Key key) {
        OpenEntry<Key, Nothing$> entry = this.scala$collection$mutable$OpenHashMap$$table[this.findIndex(key, this.hashOf(key))];
        if (entry != null) {
            Option<Value> option = entry.value();
            None$ none$ = None$.MODULE$;
            if (option == null ? none$ != null : !option.equals(none$)) {
                Option<Value> res = entry.value();
                entry.key_$eq(null);
                entry.hash_$eq(0);
                entry.value_$eq(None$.MODULE$);
                this.scala$collection$mutable$OpenHashMap$$size_$eq(this.size() - 1);
                this.scala$collection$mutable$OpenHashMap$$deleted_$eq(this.scala$collection$mutable$OpenHashMap$$deleted() + 1);
                return res;
            }
        }
        return None$.MODULE$;
    }

    @Override
    public Option<Value> get(Key key) {
        int hash = this.hashOf(key);
        int index = hash & this.scala$collection$mutable$OpenHashMap$$mask();
        OpenEntry<Key, Value> entry = this.scala$collection$mutable$OpenHashMap$$table[index];
        int j = 0;
        while (entry != null) {
            if (entry.hash() == hash && BoxesRunTime.equals(entry.key(), key)) {
                return entry.value();
            }
            index = index + ++j & this.scala$collection$mutable$OpenHashMap$$mask();
            entry = this.scala$collection$mutable$OpenHashMap$$table[index];
        }
        return None$.MODULE$;
    }

    @Override
    public Iterator<Tuple2<Key, Value>> iterator() {
        return new AbstractIterator<Tuple2<Key, Value>>(this){
            private int index;
            private final int initialModCount;
            private final /* synthetic */ OpenHashMap $outer;

            private int index() {
                return this.index;
            }

            private void index_$eq(int x$1) {
                this.index = x$1;
            }

            private int initialModCount() {
                return this.initialModCount;
            }

            private void advance() {
                if (this.initialModCount() != this.$outer.scala$collection$mutable$OpenHashMap$$modCount) {
                    throw package$.MODULE$.error("Concurrent modification");
                }
                while (this.index() <= this.$outer.scala$collection$mutable$OpenHashMap$$mask()) {
                    if (this.$outer.scala$collection$mutable$OpenHashMap$$table[this.index()] != null) {
                        Option<Value> option = this.$outer.scala$collection$mutable$OpenHashMap$$table[this.index()].value();
                        None$ none$ = None$.MODULE$;
                        if (option == null) {
                            if (none$ != null) {
                                return;
                            }
                        } else if (!option.equals(none$)) break;
                    }
                    this.index_$eq(this.index() + 1);
                }
            }

            public boolean hasNext() {
                this.advance();
                return this.index() <= this.$outer.scala$collection$mutable$OpenHashMap$$mask();
            }

            public Tuple2<Key, Value> next() {
                this.advance();
                OpenEntry<Key, Value> result2 = this.$outer.scala$collection$mutable$OpenHashMap$$table[this.index()];
                this.index_$eq(this.index() + 1);
                return new Tuple2<Key, Value>(result2.key(), result2.value().get());
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.index = 0;
                this.initialModCount = $outer.scala$collection$mutable$OpenHashMap$$modCount;
            }
        };
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public OpenHashMap<Key, Value> clone() {
        void var1_1;
        OpenHashMap it = new OpenHashMap();
        Function1<OpenEntry, Object> & java.io.Serializable & Serializable foreachUndeletedEntry_f = (Function1<OpenEntry, Object> & java.io.Serializable & Serializable)entry -> {
            it.put(entry.key(), entry.hash(), entry.value().get());
            return BoxedUnit.UNIT;
        };
        ArrayOps.ofRef<Object> foreachUndeletedEntry_foreach_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$collection$mutable$OpenHashMap$$table));
        int foreachUndeletedEntry_foreach_len = foreachUndeletedEntry_foreach_this.length();
        for (int foreachUndeletedEntry_foreach_i = 0; foreachUndeletedEntry_foreach_i < foreachUndeletedEntry_foreach_len; ++foreachUndeletedEntry_foreach_i) {
            OpenEntry openEntry = (OpenEntry)foreachUndeletedEntry_foreach_this.apply(foreachUndeletedEntry_foreach_i);
            OpenHashMap.$anonfun$foreachUndeletedEntry$1$adapted(foreachUndeletedEntry_f, openEntry);
        }
        return var1_1;
    }

    @Override
    public <U> void foreach(Function1<Tuple2<Key, Value>, U> f) {
        int startModCount = this.scala$collection$mutable$OpenHashMap$$modCount;
        Function1<OpenEntry, Object> & java.io.Serializable & Serializable foreachUndeletedEntry_f = (Function1<OpenEntry, Object> & java.io.Serializable & Serializable)entry -> {
            if ($this.scala$collection$mutable$OpenHashMap$$modCount != startModCount) {
                throw package$.MODULE$.error("Concurrent Modification");
            }
            f.apply(new Tuple2(entry.key(), entry.value().get()));
            return BoxedUnit.UNIT;
        };
        ArrayOps.ofRef<Object> foreachUndeletedEntry_foreach_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$collection$mutable$OpenHashMap$$table));
        int foreachUndeletedEntry_foreach_len = foreachUndeletedEntry_foreach_this.length();
        for (int foreachUndeletedEntry_foreach_i = 0; foreachUndeletedEntry_foreach_i < foreachUndeletedEntry_foreach_len; ++foreachUndeletedEntry_foreach_i) {
            OpenEntry openEntry = (OpenEntry)foreachUndeletedEntry_foreach_this.apply(foreachUndeletedEntry_foreach_i);
            OpenHashMap.$anonfun$foreachUndeletedEntry$1$adapted(foreachUndeletedEntry_f, openEntry);
        }
    }

    private void foreachUndeletedEntry(Function1<OpenEntry<Key, Value>, BoxedUnit> f) {
        ArrayOps.ofRef<Object> foreach_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$collection$mutable$OpenHashMap$$table));
        int foreach_len = foreach_this.length();
        for (int foreach_i = 0; foreach_i < foreach_len; ++foreach_i) {
            OpenEntry openEntry = (OpenEntry)foreach_this.apply(foreach_i);
            OpenHashMap.$anonfun$foreachUndeletedEntry$1$adapted(f, openEntry);
        }
    }

    public OpenHashMap<Key, Value> transform(Function2<Key, Value, Value> f) {
        Function1<OpenEntry, Object> & java.io.Serializable & Serializable foreachUndeletedEntry_f = (Function1<OpenEntry, Object> & java.io.Serializable & Serializable)entry -> {
            entry.value_$eq(new Some(f.apply(entry.key(), entry.value().get())));
            return BoxedUnit.UNIT;
        };
        ArrayOps.ofRef<Object> foreachUndeletedEntry_foreach_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$collection$mutable$OpenHashMap$$table));
        int foreachUndeletedEntry_foreach_len = foreachUndeletedEntry_foreach_this.length();
        for (int foreachUndeletedEntry_foreach_i = 0; foreachUndeletedEntry_foreach_i < foreachUndeletedEntry_foreach_len; ++foreachUndeletedEntry_foreach_i) {
            OpenEntry openEntry = (OpenEntry)foreachUndeletedEntry_foreach_this.apply(foreachUndeletedEntry_foreach_i);
            OpenHashMap.$anonfun$foreachUndeletedEntry$1$adapted(foreachUndeletedEntry_f, openEntry);
        }
        return this;
    }

    public OpenHashMap<Key, Value> retain(Function2<Key, Value, Object> f) {
        Function1<OpenEntry, Object> & java.io.Serializable & Serializable foreachUndeletedEntry_f = (Function1<OpenEntry, Object> & java.io.Serializable & Serializable)entry -> {
            OpenHashMap.$anonfun$retain$1(this, f, entry);
            return BoxedUnit.UNIT;
        };
        ArrayOps.ofRef<Object> foreachUndeletedEntry_foreach_this = new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.scala$collection$mutable$OpenHashMap$$table));
        int foreachUndeletedEntry_foreach_len = foreachUndeletedEntry_foreach_this.length();
        for (int foreachUndeletedEntry_foreach_i = 0; foreachUndeletedEntry_foreach_i < foreachUndeletedEntry_foreach_len; ++foreachUndeletedEntry_foreach_i) {
            OpenEntry openEntry = (OpenEntry)foreachUndeletedEntry_foreach_this.apply(foreachUndeletedEntry_foreach_i);
            OpenHashMap.$anonfun$foreachUndeletedEntry$1$adapted(foreachUndeletedEntry_f, openEntry);
        }
        return this;
    }

    @Override
    public String stringPrefix() {
        return "OpenHashMap";
    }

    public static final /* synthetic */ void $anonfun$growTable$1(OpenHashMap $this, OpenEntry entry) {
        if (entry != null) {
            Option option = entry.value();
            None$ none$ = None$.MODULE$;
            if (option == null ? none$ != null : !option.equals(none$)) {
                $this.scala$collection$mutable$OpenHashMap$$table[$this.findIndex(entry.key(), (int)entry.hash())] = entry;
            }
        }
    }

    public static final /* synthetic */ void $anonfun$foreach$1(OpenHashMap $this, int startModCount$1, Function1 f$1, OpenEntry entry) {
        if ($this.scala$collection$mutable$OpenHashMap$$modCount != startModCount$1) {
            throw package$.MODULE$.error("Concurrent Modification");
        }
        f$1.apply(new Tuple2(entry.key(), entry.value().get()));
    }

    public static final /* synthetic */ void $anonfun$foreachUndeletedEntry$1(Function1 f$2, OpenEntry entry) {
        if (entry != null) {
            Option option = entry.value();
            None$ none$ = None$.MODULE$;
            if (option == null ? none$ != null : !option.equals(none$)) {
                f$2.apply(entry);
            }
        }
    }

    public static final /* synthetic */ void $anonfun$transform$1(Function2 f$3, OpenEntry entry) {
        entry.value_$eq(new Some(f$3.apply(entry.key(), entry.value().get())));
    }

    public static final /* synthetic */ void $anonfun$retain$1(OpenHashMap $this, Function2 f$4, OpenEntry entry) {
        if (!BoxesRunTime.unboxToBoolean(f$4.apply(entry.key(), entry.value().get()))) {
            entry.key_$eq(null);
            entry.hash_$eq(0);
            entry.value_$eq(None$.MODULE$);
            $this.scala$collection$mutable$OpenHashMap$$size_$eq($this.size() - 1);
            $this.scala$collection$mutable$OpenHashMap$$deleted_$eq($this.scala$collection$mutable$OpenHashMap$$deleted() + 1);
            return;
        }
    }

    public OpenHashMap(int initialSize) {
        this.actualInitialSize = HashTable$.MODULE$.nextPositivePowerOfTwo(initialSize);
        this.scala$collection$mutable$OpenHashMap$$mask = this.actualInitialSize - 1;
        this.scala$collection$mutable$OpenHashMap$$table = new OpenEntry[this.actualInitialSize];
        this._size = 0;
        this.scala$collection$mutable$OpenHashMap$$deleted = 0;
        this.scala$collection$mutable$OpenHashMap$$modCount = 0;
    }

    public OpenHashMap() {
        this(8);
    }

    public static final /* synthetic */ Object $anonfun$growTable$1$adapted(OpenHashMap $this, OpenEntry entry) {
        OpenHashMap.$anonfun$growTable$1($this, entry);
        return BoxedUnit.UNIT;
    }

    public static final /* synthetic */ Object $anonfun$foreachUndeletedEntry$1$adapted(Function1 f$2, OpenEntry entry) {
        if (entry != null) {
            Option option = entry.value();
            None$ none$ = None$.MODULE$;
            if (option == null ? none$ != null : !option.equals(none$)) {
                f$2.apply(entry);
            }
        }
        return BoxedUnit.UNIT;
    }

    public static final class OpenEntry<Key, Value> {
        private Key key;
        private int hash;
        private Option<Value> value;

        public Key key() {
            return this.key;
        }

        public void key_$eq(Key x$1) {
            this.key = x$1;
        }

        public int hash() {
            return this.hash;
        }

        public void hash_$eq(int x$1) {
            this.hash = x$1;
        }

        public Option<Value> value() {
            return this.value;
        }

        public void value_$eq(Option<Value> x$1) {
            this.value = x$1;
        }

        public OpenEntry(Key key, int hash, Option<Value> value) {
            this.key = key;
            this.hash = hash;
            this.value = value;
        }
    }
}

