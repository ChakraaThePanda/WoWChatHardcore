/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Predef$;
import scala.Serializable;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.Traversable;
import scala.collection.TraversableOnce;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Shrinkable;
import scala.collection.generic.Subtractable;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.SeqLike;
import scala.collection.script.End$;
import scala.collection.script.Include;
import scala.collection.script.Index;
import scala.collection.script.Location;
import scala.collection.script.Message;
import scala.collection.script.NoLo$;
import scala.collection.script.Remove;
import scala.collection.script.Reset;
import scala.collection.script.Script;
import scala.collection.script.Scriptable;
import scala.collection.script.Start$;
import scala.collection.script.Update;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;

@ScalaSignature(bytes="\u0006\u0001\u0005Ug\u0001C\u000e\u001d!\u0003\r\ta\t$\t\u000ba\u0003A\u0011A-\t\u000bu\u0003a\u0011\u00010\t\u000b\u0011\u0004a\u0011A3\t\u000b%\u0004a\u0011\u00016\t\u000b-\u0004a\u0011\u00017\t\u000bA\u0004a\u0011A-\t\u000bE\u0004a\u0011\u0001:\t\u000bQ\u0004a\u0011A;\t\u000bu\u0004a\u0011\u0001@\t\ru\u0004A\u0011AA\u0001\u0011\u001d\tI\u0001\u0001C\u0001\u0003\u0017Aq!!\u0005\u0001\t\u0003\t\u0019\u0002C\u0004\u0002 \u0001!\t!!\t\t\u000f\u0005-\u0002\u0001\"\u0001\u0002.!9\u0011\u0011\u0007\u0001\u0005\u0002\u0005M\u0002bBA\u001c\u0001\u0011\u0005\u0011\u0011\b\u0005\b\u0003{\u0001A\u0011AA \u0011\u001d\t)\u0005\u0001C\u0001\u0003\u000fBq!a\u0013\u0001\t\u0003\ti\u0005C\u0004\u0002R\u0001!\t!a\u0015\t\u000f\u0005=\u0004\u0001\"\u0011\u0002r!9\u0011\u0011\u0012\u0001\u0005\u0002\u0005-\u0005bBAV\u0001\u0011\u0005\u0013Q\u0016\u0005\b\u0003W\u0003A\u0011IA\\\u0011\u001d\t)\r\u0001C!\u0003\u000fDq!!5\u0001\t\u0003\n\u0019N\u0001\u0006Ck\u001a4WM\u001d'jW\u0016T!!\b\u0010\u0002\u000f5,H/\u00192mK*\u0011q\u0004I\u0001\u000bG>dG.Z2uS>t'\"A\u0011\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001U\u0019A%M$\u0014\u0011\u0001)\u0013FO\u001fD%V\u0003\"AJ\u0014\u000e\u0003\u0001J!\u0001\u000b\u0011\u0003\r\u0005s\u0017PU3g!\rQSfL\u0007\u0002W)\u0011AFH\u0001\bO\u0016tWM]5d\u0013\tq3F\u0001\u0005He><\u0018M\u00197f!\t\u0001\u0014\u0007\u0004\u0001\u0005\u000bI\u0002!\u0019A\u001a\u0003\u0003\u0005\u000b\"\u0001N\u001c\u0011\u0005\u0019*\u0014B\u0001\u001c!\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"A\n\u001d\n\u0005e\u0002#aA!osB\u0019!fO\u0018\n\u0005qZ#AC*ie&t7.\u00192mKB\u0019a(Q\u0018\u000e\u0003}R!\u0001\u0011\u0010\u0002\rM\u001c'/\u001b9u\u0013\t\u0011uH\u0001\u0006TGJL\u0007\u000f^1cY\u0016\u0004BA\u000b#0\r&\u0011Qi\u000b\u0002\r'V\u0014GO]1di\u0006\u0014G.\u001a\t\u0003a\u001d#a\u0001\u0013\u0001\u0005\u0006\u0004I%\u0001\u0002+iSN\f\"\u0001\u000e&\u0013\u0007-kuJ\u0002\u0003M\u0001\u0001Q%\u0001\u0004\u001fsK\u001aLg.Z7f]Rt\u0004\u0003\u0002(\u0001_\u0019k\u0011\u0001\b\t\u0004\u001dB{\u0013BA)\u001d\u0005\u0019\u0011UO\u001a4feB!ajU\u0018G\u0013\t!FDA\u0004TKFd\u0015n[3\u0011\u0005\u00192\u0016BA,!\u0005%\u0019En\u001c8fC\ndW-\u0001\u0004%S:LG\u000f\n\u000b\u00025B\u0011aeW\u0005\u00039\u0002\u0012A!\u00168ji\u0006)\u0011\r\u001d9msR\u0011qf\u0018\u0005\u0006A\n\u0001\r!Y\u0001\u0002]B\u0011aEY\u0005\u0003G\u0002\u00121!\u00138u\u0003\u0019)\b\u000fZ1uKR\u0019!LZ4\t\u000b\u0001\u001c\u0001\u0019A1\t\u000b!\u001c\u0001\u0019A\u0018\u0002\u000f9,w/\u001a7f[\u00061A.\u001a8hi\",\u0012!Y\u0001\tIAdWo\u001d\u0013fcR\u0011QN\\\u0007\u0002\u0001!)q.\u0002a\u0001_\u0005!Q\r\\3n\u0003\u0015\u0019G.Z1s\u00039!\u0003\u000f\\;tI\u0015\fHeY8m_:$\"!\\:\t\u000b=<\u0001\u0019A\u0018\u0002\u0013%t7/\u001a:u\u00032dGc\u0001.wo\")\u0001\r\u0003a\u0001C\")\u0001\u0010\u0003a\u0001s\u0006)Q\r\\3ngB\u0019!p_\u0018\u000e\u0003yI!\u0001 \u0010\u0003\u0017Q\u0013\u0018M^3sg\u0006\u0014G.Z\u0001\u0007e\u0016lwN^3\u0015\u0005=z\b\"\u00021\n\u0001\u0004\tG#\u0002.\u0002\u0004\u0005\u0015\u0001\"\u00021\u000b\u0001\u0004\t\u0007BBA\u0004\u0015\u0001\u0007\u0011-A\u0003d_VtG/A\u0005%[&tWo\u001d\u0013fcR\u0019Q.!\u0004\t\r\u0005=1\u00021\u00010\u0003\u0005A\u0018a\u0005\u0013qYV\u001cH\u0005\u001d7vg\u0012*\u0017\u000fJ2pY>tGcA7\u0002\u0016!9\u0011q\u0003\u0007A\u0002\u0005e\u0011A\u0001=t!\u0011Q\u00181D\u0018\n\u0007\u0005uaDA\bUe\u00064XM]:bE2,wJ\\2f\u0003\u0019\t\u0007\u000f]3oIR\u0019!,a\t\t\ral\u0001\u0019AA\u0013!\u00111\u0013qE\u0018\n\u0007\u0005%\u0002E\u0001\u0006=e\u0016\u0004X-\u0019;fIz\n\u0011\"\u00199qK:$\u0017\t\u001c7\u0015\u0007i\u000by\u0003C\u0004\u0002\u00189\u0001\r!!\u0007\u0002\u000fA\u0014X\r]3oIR\u0019!,!\u000e\t\ra|\u0001\u0019AA\u0013\u0003)\u0001(/\u001a9f]\u0012\fE\u000e\u001c\u000b\u00045\u0006m\u0002bBA\f!\u0001\u0007\u0011\u0011D\u0001\u0007S:\u001cXM\u001d;\u0015\u000bi\u000b\t%a\u0011\t\u000b\u0001\f\u0002\u0019A1\t\ra\f\u0002\u0019AA\u0013\u0003%!(/[7Ti\u0006\u0014H\u000fF\u0002[\u0003\u0013BQ\u0001\u0019\nA\u0002\u0005\fq\u0001\u001e:j[\u0016sG\rF\u0002[\u0003\u001fBQ\u0001Y\nA\u0002\u0005\f!\u0002\n7fgN$C.Z:t)\rQ\u0016Q\u000b\u0005\b\u0003/\"\u0002\u0019AA-\u0003\r\u0019W\u000e\u001a\t\u0005}\u0005ms&C\u0002\u0002^}\u0012q!T3tg\u0006<W\rK\u0004\u0015\u0003C\n9'a\u001b\u0011\u0007\u0019\n\u0019'C\u0002\u0002f\u0001\u0012!\u0002Z3qe\u0016\u001c\u0017\r^3eC\t\tI'A\ftGJL\u0007\u000f^5oO\u0002J7\u000f\t3faJ,7-\u0019;fI\u0006\u0012\u0011QN\u0001\u0007e9\n\u0014G\f\u0019\u0002\u0019M$(/\u001b8h!J,g-\u001b=\u0016\u0005\u0005M\u0004\u0003BA;\u0003\u0007sA!a\u001e\u0002\u0000A\u0019\u0011\u0011\u0010\u0011\u000e\u0005\u0005m$bAA?E\u00051AH]8pizJ1!!!!\u0003\u0019\u0001&/\u001a3fM&!\u0011QQAD\u0005\u0019\u0019FO]5oO*\u0019\u0011\u0011\u0011\u0011\u0002\u0015\u0011\u0002H.^:%a2,8\u000fF\u0002G\u0003\u001bCq!a\u0006\u0017\u0001\u0004\ty\t\u0005\u0003{\u0003#{\u0013bAAJ=\t\u0011r)\u001a8Ue\u00064XM]:bE2,wJ\\2fQ\u001d1\u0012qSAR\u0003O\u0003B!!'\u0002 6\u0011\u00111\u0014\u0006\u0004\u0003;\u0003\u0013AC1o]>$\u0018\r^5p]&!\u0011\u0011UAN\u0005%i\u0017n\u001a:bi&|g.\t\u0002\u0002&\u00061\u0007mK\u0016aA\r\u0014X-\u0019;fg\u0002\n\u0007E\\3xA\t,hMZ3s]\u0001*6/\u001a\u0011aW-j\u0004\r\t;pA\u0005$G\rI1oA\u0015dW-\\3oi\u00022'o\\7!i\"L7\u000f\t2vM\u001a,'\u000fI1oI\u0002\u0012X\r^;s]\u0002\"\b.\u0019;!EV4g-\u001a:!SR\u001cX\r\u001c4/C\t\tI+A\u00033]ar\u0003'\u0001\u0004%[&tWo\u001d\u000b\u0004\r\u0006=\u0006\"B8\u0018\u0001\u0004y\u0003fB\f\u0002\u0018\u0006M\u0016qU\u0011\u0003\u0003k\u000bq\rY\u0017aA\r\u0014X-\u0019;fg\u0002\n\u0007E\\3xA\t,hMZ3s]\u0001*6/\u001a\u0011a[u\u0002\u0007\u0005^8!e\u0016lwN^3!C:\u0004S\r\\3nK:$\bE\u001a:p[\u0002\"\b.[:!EV4g-\u001a:!C:$\u0007E]3ukJt\u0007\u0005\u001e5bi\u0002\u0012WO\u001a4fe\u0002JGo]3mM:\"rARA]\u0003{\u000b\t\r\u0003\u0004\u0002<b\u0001\raL\u0001\u0006K2,W.\r\u0005\u0007\u0003\u007fC\u0002\u0019A\u0018\u0002\u000b\u0015dW-\u001c\u001a\t\raD\u0002\u0019AA\u0013Q\u001dA\u0012qSAZ\u0003O\u000bA\u0002J7j]V\u001cH%\\5okN$2ARAe\u0011\u001d\t9\"\u0007a\u0001\u0003\u001fCs!GAL\u0003\u001b\f9+\t\u0002\u0002P\u0006I\u0007-L\u0017aA\r\u0014X-\u0019;fg\u0002\n\u0007E\\3xA\t,hMZ3s]\u0001*6/\u001a\u0011a[5j\u0004\r\t;pAI,Wn\u001c<fA\u0005t\u0007%\u001a7f[\u0016tG\u000f\t4s_6\u0004C\u000f[5tA\t,hMZ3sA\u0005tG\r\t:fiV\u0014h\u000e\t;iCR\u0004#-\u001e4gKJ\u0004\u0013\u000e^:fY\u001at\u0013!B2m_:,G#\u0001$")
public interface BufferLike<A, This extends BufferLike<A, This> & Buffer<A>>
extends Growable<A>,
Shrinkable<A>,
Scriptable<A>,
Subtractable<A, This>,
SeqLike<A, This> {
    @Override
    public A apply(int var1);

    @Override
    public void update(int var1, A var2);

    @Override
    public int length();

    public This $plus$eq(A var1);

    @Override
    public void clear();

    public This $plus$eq$colon(A var1);

    public void insertAll(int var1, Traversable<A> var2);

    public A remove(int var1);

    public static /* synthetic */ void remove$(BufferLike $this, int n, int count) {
        $this.remove(n, count);
    }

    default public void remove(int n, int count) {
        if (count < 0) {
            throw new IllegalArgumentException(new StringBuilder(38).append("removing negative number of elements: ").append(((Object)BoxesRunTime.boxToInteger(count)).toString()).toString());
        }
        int n2 = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        RichInt$.MODULE$.until$extension0(n2, count).foreach((Function1<Object, Object> & java.io.Serializable & Serializable)(Object i) -> this.remove(n));
    }

    public static /* synthetic */ Buffer $minus$eq$(BufferLike $this, Object x) {
        return $this.$minus$eq(x);
    }

    default public This $minus$eq(A x) {
        int i = this.indexOf(x);
        if (i != -1) {
            this.remove(i);
        }
        return (This)((Buffer)this);
    }

    public static /* synthetic */ Buffer $plus$plus$eq$colon$(BufferLike $this, TraversableOnce xs) {
        return $this.$plus$plus$eq$colon(xs);
    }

    default public This $plus$plus$eq$colon(TraversableOnce<A> xs) {
        this.insertAll(0, xs.toTraversable());
        return (This)((Buffer)this);
    }

    public static /* synthetic */ void append$(BufferLike $this, Seq elems) {
        $this.append(elems);
    }

    default public void append(Seq<A> elems) {
        this.appendAll(elems);
    }

    public static /* synthetic */ void appendAll$(BufferLike $this, TraversableOnce xs) {
        $this.appendAll(xs);
    }

    default public void appendAll(TraversableOnce<A> xs) {
        this.$plus$plus$eq(xs);
    }

    public static /* synthetic */ void prepend$(BufferLike $this, Seq elems) {
        $this.prepend(elems);
    }

    default public void prepend(Seq<A> elems) {
        this.prependAll(elems);
    }

    public static /* synthetic */ void prependAll$(BufferLike $this, TraversableOnce xs) {
        $this.prependAll(xs);
    }

    default public void prependAll(TraversableOnce<A> xs) {
        this.$plus$plus$eq$colon(xs);
    }

    public static /* synthetic */ void insert$(BufferLike $this, int n, Seq elems) {
        $this.insert(n, elems);
    }

    default public void insert(int n, Seq<A> elems) {
        this.insertAll(n, elems);
    }

    public static /* synthetic */ void trimStart$(BufferLike $this, int n) {
        $this.trimStart(n);
    }

    default public void trimStart(int n) {
        this.remove(0, n);
    }

    public static /* synthetic */ void trimEnd$(BufferLike $this, int n) {
        $this.trimEnd(n);
    }

    default public void trimEnd(int n) {
        int n2 = this.length() - n;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        this.remove(RichInt$.MODULE$.max$extension(n2, 0), n);
    }

    public static /* synthetic */ void $less$less$(BufferLike $this, Message cmd) {
        $this.$less$less(cmd);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    default public void $less$less(Message<A> cmd2) {
        boolean bl = false;
        Include include = null;
        boolean bl2 = false;
        Update update = null;
        boolean bl3 = false;
        Remove remove = null;
        if (cmd2 instanceof Include) {
            bl = true;
            include = (Include)cmd2;
            Location location = include.location();
            Object x = include.elem();
            if (Start$.MODULE$.equals(location)) {
                this.prepend(Predef$.MODULE$.genericWrapArray(new Object[]{x}));
                return;
            }
        }
        if (bl) {
            Location location = include.location();
            Object x = include.elem();
            if (End$.MODULE$.equals(location)) {
                this.append(Predef$.MODULE$.genericWrapArray(new Object[]{x}));
                return;
            }
        }
        if (bl) {
            Location location = include.location();
            Object x = include.elem();
            if (location instanceof Index) {
                int n = ((Index)location).n();
                this.insert(n, Predef$.MODULE$.genericWrapArray(new Object[]{x}));
                return;
            }
        }
        if (bl) {
            Location location = include.location();
            Object x = include.elem();
            if (NoLo$.MODULE$.equals(location)) {
                this.$plus$eq(x);
                return;
            }
        }
        if (cmd2 instanceof Update) {
            bl2 = true;
            update = (Update)cmd2;
            Location location = update.location();
            Object x = update.elem();
            if (Start$.MODULE$.equals(location)) {
                this.update(0, x);
                return;
            }
        }
        if (bl2) {
            Location location = update.location();
            Object x = update.elem();
            if (End$.MODULE$.equals(location)) {
                this.update(this.length() - 1, x);
                return;
            }
        }
        if (bl2) {
            Location location = update.location();
            Object x = update.elem();
            if (location instanceof Index) {
                int n = ((Index)location).n();
                this.update(n, x);
                return;
            }
        }
        if (cmd2 instanceof Remove) {
            bl3 = true;
            remove = (Remove)cmd2;
            Location location = remove.location();
            Object x = remove.elem();
            if (Start$.MODULE$.equals(location)) {
                if (!BoxesRunTime.equals(((Function1)((Object)this)).apply(BoxesRunTime.boxToInteger(0)), x)) return;
                this.remove(0);
                return;
            }
        }
        if (bl3) {
            Location location = remove.location();
            Object x = remove.elem();
            if (End$.MODULE$.equals(location)) {
                if (!BoxesRunTime.equals(((Function1)((Object)this)).apply(BoxesRunTime.boxToInteger(this.length() - 1)), x)) return;
                this.remove(this.length() - 1);
                return;
            }
        }
        if (bl3) {
            Location location = remove.location();
            Object x = remove.elem();
            if (location instanceof Index) {
                int n = ((Index)location).n();
                if (!BoxesRunTime.equals(((Function1)((Object)this)).apply(BoxesRunTime.boxToInteger(n)), x)) return;
                this.remove(n);
                return;
            }
        }
        if (bl3) {
            Location location = remove.location();
            Object x = remove.elem();
            if (NoLo$.MODULE$.equals(location)) {
                this.$minus$eq(x);
                return;
            }
        }
        if (cmd2 instanceof Reset) {
            this.clear();
            return;
        }
        if (!(cmd2 instanceof Script)) throw new UnsupportedOperationException(new StringBuilder(23).append("message ").append(cmd2).append(" not understood").toString());
        ((Script)cmd2).iterator().foreach((Function1<Message, Object> & java.io.Serializable & Serializable)cmd -> {
            this.$less$less(cmd);
            return BoxedUnit.UNIT;
        });
    }

    public static /* synthetic */ String stringPrefix$(BufferLike $this) {
        return $this.stringPrefix();
    }

    @Override
    default public String stringPrefix() {
        return "Buffer";
    }

    public static /* synthetic */ Buffer $plus$plus$(BufferLike $this, GenTraversableOnce xs) {
        return $this.$plus$plus(xs);
    }

    default public This $plus$plus(GenTraversableOnce<A> xs) {
        return (This)((Buffer)this.clone().$plus$plus$eq(xs.seq()));
    }

    public static /* synthetic */ Buffer $minus$(BufferLike $this, Object elem) {
        return $this.$minus(elem);
    }

    @Override
    default public This $minus(A elem) {
        return this.clone().$minus$eq(elem);
    }

    public static /* synthetic */ Buffer $minus$(BufferLike $this, Object elem1, Object elem2, Seq elems) {
        return $this.$minus(elem1, elem2, elems);
    }

    @Override
    default public This $minus(A elem1, A elem2, Seq<A> elems) {
        return (This)((Buffer)this.clone().$minus$eq(elem1).$minus$eq(elem2).$minus$minus$eq(elems));
    }

    public static /* synthetic */ Buffer $minus$minus$(BufferLike $this, GenTraversableOnce xs) {
        return $this.$minus$minus(xs);
    }

    @Override
    default public This $minus$minus(GenTraversableOnce<A> xs) {
        return (This)((Buffer)this.clone().$minus$minus$eq(xs.seq()));
    }

    public static /* synthetic */ Buffer clone$(BufferLike $this) {
        return $this.clone();
    }

    @Override
    default public This clone() {
        Builder bf = ((GenericTraversableTemplate)((Object)this)).newBuilder();
        bf.$plus$plus$eq(this);
        return (This)((Buffer)bf.result());
    }

    public static void $init$(BufferLike $this) {
    }
}

