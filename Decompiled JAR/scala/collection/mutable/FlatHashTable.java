/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.immutable.Range;
import scala.collection.mutable.ArrayOps;
import scala.collection.mutable.FlatHashTable$;
import scala.collection.mutable.FlatHashTable$NullSentinel$;
import scala.collection.mutable.HashTable$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt$;
import scala.util.Random;
import scala.util.hashing.package$;

@ScalaSignature(bytes="\u0006\u0001\t=gaB)S!\u0003\r\t!\u0017\u0005\b\u0003\u007f\u0002A\u0011AAA\u0011\u001d\t\t\f\u0001C\u0007\u0003gC!\"a\b\u0001\u0001\u0004%\t\u0001VA\t\u0011)\t\u0019\r\u0001a\u0001\n\u0003!\u0016Q\u0019\u0005\n\u0003g\u0001\u0001\u0019!C\t\u0003kA\u0011\"!4\u0001\u0001\u0004%\t\"a4\t\u0013\u0005}\u0002\u00011A\u0005\u0012\u0005E\u0001\"CAk\u0001\u0001\u0007I\u0011CAl\u0011%\t\u0019\u0005\u0001a\u0001\n#\t\t\u0002C\u0005\u0002^\u0002\u0001\r\u0011\"\u0005\u0002`\"I\u00111\n\u0001A\u0002\u0013E\u0011Q\n\u0005\n\u0003K\u0004\u0001\u0019!C\t\u0003OD\u0011\"a\u0012\u0001\u0001\u0004%\t\"!\u0005\t\u0013\u00055\b\u00011A\u0005\u0012\u0005=\bbBAz\u0001\u0011E\u0011Q\u001f\u0005\b\u0003w\u0004A\u0011AA\t\u0011\u001d\ti\u0010\u0001C\u0005\u0003#Aq!a@\u0001\t#\t\t\u0002C\u0004\u0003\u0002\u0001!\t\"!\u0005\t\u0011\t\r\u0001\u0001\"\u0001U\u0005\u000bA\u0001B!\t\u0001\t\u0003!&1\u0005\u0005\b\u0005_\u0001A\u0011\u0003B\u0019\u0011\u001d\u0011Y\u0005\u0001C\t\u0005\u001bBqAa\u0015\u0001\t\u0013\u0011)\u0006C\u0004\u0003Z\u0001!\tBa\u0017\t\u000f\t}\u0003\u0001\"\u0005\u0003b!9!q\r\u0001\u0005\u0012\t%\u0004b\u0002B7\u0001\u0011E!q\u000e\u0005\b\u0005s\u0002A\u0011BAA\u0011\u001d\u0011Y\b\u0001C\u0005\u0003\u0003CqA! \u0001\t#\u0011y\bC\u0004\u0003\b\u0002!\tB!#\t\u000f\t=\u0005\u0001\"\u0005\u0003\u0012\"A!\u0011\u0014\u0001\u0005\u0006Q\u000b\t\u0002C\u0004\u0003\u001c\u0002!\tB!(\t\u000f\t\r\u0006\u0001\"\u0005\u0003&\"9!1\u0016\u0001\u0005\u0012\u0005\u0005\u0005\u0002\u0003BX\u0001\u0011\u0005A+!!\t\u0011\tE\u0006\u0001\"\u0001U\u0003\u0003CqAa-\u0001\t#\t\t\tC\u0004\u00036\u0002!\t\"a-\t\u000f\t]\u0006\u0001\"\u0005\u00024\"9!\u0011\u0018\u0001\u0005\u0016\tm\u0006b\u0002B`\u0001\u0011E\u0011\u0011\u0011\u0005\t\u0005\u0003\u0004A\u0011\u0001+\u0003D\"9!q\u0019\u0001\u0005\u0012\t%wA\u00022S\u0011\u0003!6M\u0002\u0004R%\"\u0005A\u000b\u001a\u0005\u0006KB\"\tA\u001a\u0005\u0006OB\")\u0001[\u0004\u0006oBBI\u0001\u001f\u0004\u0006uBBIa\u001f\u0005\u0006KR\"\t\u0001 \u0005\u0006{R\"\tE \u0005\b\u0003\u000b!D\u0011IA\u0004\u0011\u001d\ty\u0001\rC\u0001\u0003#Aq!a\u00051\t\u000b\t\t\u0002C\u0004\u0002\u0016A\"\t!a\u0006\t\u000f\u0005\u0005\u0002\u0007\"\u0001\u0002$\u00191\u0011\u0011\u0006\u0019\u0001\u0003WA!\"a\f=\u0005\u000b\u0007I\u0011AA\t\u0011%\t\t\u0004\u0010B\u0001B\u0003%q\u0010\u0003\u0006\u00024q\u0012)\u0019!C\u0001\u0003kA!\"!\u0010=\u0005\u0003\u0005\u000b\u0011BA\u001c\u0011)\ty\u0004\u0010BC\u0002\u0013\u0005\u0011\u0011\u0003\u0005\n\u0003\u0003b$\u0011!Q\u0001\n}D!\"a\u0011=\u0005\u000b\u0007I\u0011AA\t\u0011%\t)\u0005\u0010B\u0001B\u0003%q\u0010\u0003\u0006\u0002Hq\u0012)\u0019!C\u0001\u0003#A\u0011\"!\u0013=\u0005\u0003\u0005\u000b\u0011B@\t\u0015\u0005-CH!b\u0001\n\u0003\ti\u0005\u0003\u0006\u0002Rq\u0012\t\u0011)A\u0005\u0003\u001fBa!\u001a\u001f\u0005\u0002\u0005Mc!CA=aA\u0005\u0019\u0011AA>\u0011\u001d\tyH\u0013C\u0001\u0003\u0003Cq!!#K\t+\t\t\u0002C\u0004\u0002\f*#)\"!\u0005\t\u000f\u00055%\n\"\u0006\u0002\u0010\"9\u0011\u0011\u0014&\u0005\u0016\u0005m\u0005bBAS\u0015\u0012U\u0011q\u0015\u0002\u000e\r2\fG\u000fS1tQR\u000b'\r\\3\u000b\u0005M#\u0016aB7vi\u0006\u0014G.\u001a\u0006\u0003+Z\u000b!bY8mY\u0016\u001cG/[8o\u0015\u00059\u0016!B:dC2\f7\u0001A\u000b\u00045\u0006=6c\u0001\u0001\\?B\u0011A,X\u0007\u0002-&\u0011aL\u0016\u0002\u0007\u0003:L(+\u001a4\u0011\t\u0001T\u0015Q\u0016\b\u0003C>j\u0011AU\u0001\u000e\r2\fG\u000fS1tQR\u000b'\r\\3\u0011\u0005\u0005\u00044C\u0001\u0019\\\u0003\u0019a\u0014N\\5u}Q\t1-A\u0007tK\u0016$w)\u001a8fe\u0006$xN]\u000b\u0002SB\u0019!n\\9\u000e\u0003-T!\u0001\\7\u0002\t1\fgn\u001a\u0006\u0002]\u0006!!.\u0019<b\u0013\t\u00018NA\u0006UQJ,\u0017\r\u001a'pG\u0006d\u0007C\u0001:v\u001b\u0005\u0019(B\u0001;W\u0003\u0011)H/\u001b7\n\u0005Y\u001c(A\u0002*b]\u0012|W.\u0001\u0007Ok2d7+\u001a8uS:,G\u000e\u0005\u0002zi5\t\u0001G\u0001\u0007Ok2d7+\u001a8uS:,Gn\u0005\u000257R\t\u00010\u0001\u0005iCND7i\u001c3f)\u0005y\bc\u0001/\u0002\u0002%\u0019\u00111\u0001,\u0003\u0007%sG/\u0001\u0005u_N#(/\u001b8h)\t\tI\u0001E\u0002k\u0003\u0017I1!!\u0004l\u0005\u0019\u0019FO]5oO\u0006\tB-\u001a4bk2$Hj\\1e\r\u0006\u001cGo\u001c:\u0016\u0003}\fq\u0002\\8bI\u001a\u000b7\r^8s\t\u0016tW/\\\u0001\u0011g&TXMR8s)\"\u0014Xm\u001d5pY\u0012$Ra`A\r\u0003;Aa!a\u0007;\u0001\u0004y\u0018\u0001B:ju\u0016Da!a\b;\u0001\u0004y\u0018aC0m_\u0006$g)Y2u_J\fAB\\3x)\"\u0014Xm\u001d5pY\u0012$Ra`A\u0013\u0003OAa!a\b<\u0001\u0004y\bBBA\u000ew\u0001\u0007qP\u0001\u0005D_:$XM\u001c;t+\u0011\ti#a\u0017\u0014\u0005qZ\u0016A\u00037pC\u00124\u0015m\u0019;pe\u0006YAn\\1e\r\u0006\u001cGo\u001c:!\u0003\u0015!\u0018M\u00197f+\t\t9\u0004\u0005\u0003]\u0003sY\u0016bAA\u001e-\n)\u0011I\u001d:bs\u00061A/\u00192mK\u0002\n\u0011\u0002^1cY\u0016\u001c\u0016N_3\u0002\u0015Q\f'\r\\3TSj,\u0007%A\u0005uQJ,7\u000f[8mI\u0006QA\u000f\u001b:fg\"|G\u000e\u001a\u0011\u0002\u0013M,W\r\u001a<bYV,\u0017AC:fK\u00124\u0018\r\\;fA\u000591/\u001b>f[\u0006\u0004XCAA(!\u0011a\u0016\u0011H@\u0002\u0011ML'0Z7ba\u0002\"b\"!\u0016\u0002n\u0005=\u0014\u0011OA:\u0003k\n9\b\u0005\u0003zy\u0005]\u0003\u0003BA-\u00037b\u0001\u0001B\u0004\u0002^q\u0012\r!a\u0018\u0003\u0003\u0005\u000bB!!\u0019\u0002hA\u0019A,a\u0019\n\u0007\u0005\u0015dKA\u0004O_RD\u0017N\\4\u0011\u0007q\u000bI'C\u0002\u0002lY\u00131!\u00118z\u0011\u0019\ty#\u0013a\u0001\u007f\"9\u00111G%A\u0002\u0005]\u0002BBA \u0013\u0002\u0007q\u0010\u0003\u0004\u0002D%\u0003\ra \u0005\u0007\u0003\u000fJ\u0005\u0019A@\t\u000f\u0005-\u0013\n1\u0001\u0002P\tI\u0001*Y:i+RLGn]\u000b\u0005\u0003{\n\u0019k\u0005\u0002K7\u00061A%\u001b8ji\u0012\"\"!a!\u0011\u0007q\u000b))C\u0002\u0002\bZ\u0013A!\u00168ji\u0006!2/\u001b>f\u001b\u0006\u0004()^2lKR\u0014\u0015\u000e^*ju\u0016\f\u0011c]5{K6\u000b\u0007OQ;dW\u0016$8+\u001b>f\u0003\u001dIW\u000e\u001d:pm\u0016$Ra`AI\u0003+Ca!a%O\u0001\u0004y\u0018!\u00025d_\u0012,\u0007BBAL\u001d\u0002\u0007q0\u0001\u0003tK\u0016$\u0017aC3mK6$v.\u00128uef$2aWAO\u0011\u001d\tyj\u0014a\u0001\u0003C\u000bA!\u001a7f[B!\u0011\u0011LAR\t\u001d\tiF\u0013b\u0001\u0003?\n1\"\u001a8uef$v.\u00127f[R!\u0011\u0011UAU\u0011\u0019\tY\u000b\u0015a\u00017\u0006)QM\u001c;ssB!\u0011\u0011LAX\t\u001d\ti\u0006\u0001b\u0001\u0003?\n!\u0002^1cY\u0016$UMY;h+\t\t)\fE\u0002]\u0003oK1!!/W\u0005\u001d\u0011un\u001c7fC:D3aAA_!\ra\u0016qX\u0005\u0004\u0003\u00034&!\u0003;sC:\u001c\u0018.\u001a8u\u0003=yFn\\1e\r\u0006\u001cGo\u001c:`I\u0015\fH\u0003BAB\u0003\u000fD\u0001\"!3\u0005\u0003\u0003\u0005\ra`\u0001\u0004q\u0012\n\u0004fA\u0003\u0002>\u0006IA/\u00192mK~#S-\u001d\u000b\u0005\u0003\u0007\u000b\t\u000eC\u0005\u0002J\u001a\t\t\u00111\u0001\u00028!\u001aq!!0\u0002\u001bQ\f'\r\\3TSj,w\fJ3r)\u0011\t\u0019)!7\t\u0011\u0005%\u0007\"!AA\u0002}D3!CA_\u00035!\bN]3tQ>dGm\u0018\u0013fcR!\u00111QAq\u0011!\tIMCA\u0001\u0002\u0004y\bfA\u0006\u0002>\u0006Y1/\u001b>f[\u0006\u0004x\fJ3r)\u0011\t\u0019)!;\t\u0013\u0005%G\"!AA\u0002\u0005=\u0003fA\u0007\u0002>\u0006i1/Z3em\u0006dW/Z0%KF$B!a!\u0002r\"A\u0011\u0011\u001a\b\u0002\u0002\u0003\u0007q0\u0001\u0005dCB\f7-\u001b;z)\ry\u0018q\u001f\u0005\u0007\u0003s|\u0001\u0019A@\u0002\u0019\u0015D\b/Z2uK\u0012\u001c\u0016N_3\u0002\u0017%t\u0017\u000e^5bYNK'0Z\u0001\u0010S:LG/[1m\u0007\u0006\u0004\u0018mY5us\u0006Q!/\u00198e_6\u001cV-\u001a3\u0002\u001bQ\f'\r\\3TSj,7+Z3e\u0003\u0011Ig.\u001b;\u0015\r\u0005\r%q\u0001B\f\u0011\u001d\u0011I\u0001\u0006a\u0001\u0005\u0017\t!!\u001b8\u0011\t\t5!1C\u0007\u0003\u0005\u001fQ1A!\u0005n\u0003\tIw.\u0003\u0003\u0003\u0016\t=!!E(cU\u0016\u001cG/\u00138qkR\u001cFO]3b[\"9!\u0011\u0004\u000bA\u0002\tm\u0011!\u00014\u0011\u000fq\u0013i\"!,\u0002\u0004&\u0019!q\u0004,\u0003\u0013\u0019+hn\u0019;j_:\f\u0014aC:fe&\fG.\u001b>f)>$B!a!\u0003&!9!qE\u000bA\u0002\t%\u0012aA8viB!!Q\u0002B\u0016\u0013\u0011\u0011iCa\u0004\u0003%=\u0013'.Z2u\u001fV$\b/\u001e;TiJ,\u0017-\\\u0001\nM&tG-\u00128uef$BAa\r\u0003:A)AL!\u000e\u0002.&\u0019!q\u0007,\u0003\r=\u0003H/[8o\u0011\u001d\tyJ\u0006a\u0001\u0003[CsA\u0006B\u001f\u0005\u0007\u00129\u0005E\u0002]\u0005\u007fI1A!\u0011W\u0005Q!W\r\u001d:fG\u0006$X\rZ(wKJ\u0014\u0018\u000eZ5oO\u0006\u0012!QI\u0001K\u0013:$XM\u001d8bY\u0002JW\u000e\u001d7f[\u0016tG/\u0019;j_:\u0004Cm\\3tA9|G\u000fI1e[&$\be]3og&\u0014G.\u001a\u0011pm\u0016\u0014(/\u001b3j]\u001e\u0004sN\u001a\u0011uQ&\u001c\b%\\3uQ>$g&\t\u0002\u0003J\u00051!GL\u00192]A\nAbY8oi\u0006Lgn]#mK6$B!!.\u0003P!9\u0011qT\fA\u0002\u00055\u0006fB\f\u0003>\t\r#qI\u0001\rM&tG-\u00127f[&k\u0007\u000f\u001c\u000b\u00047\n]\u0003bBAP1\u0001\u0007\u0011QV\u0001\bC\u0012$W\t\\3n)\u0011\t)L!\u0018\t\u000f\u0005}\u0015\u00041\u0001\u0002.\u0006A\u0011\r\u001a3F]R\u0014\u0018\u0010\u0006\u0003\u00026\n\r\u0004B\u0002B35\u0001\u00071,\u0001\u0005oK^,e\u000e\u001e:z\u0003)\u0011X-\\8wK\u0016cW-\u001c\u000b\u0005\u0003k\u0013Y\u0007C\u0004\u0002 n\u0001\r!!,\u0002\u0011%$XM]1u_J,\"A!\u001d\u0011\r\tM$QOAW\u001b\u0005!\u0016b\u0001B<)\nA\u0011\n^3sCR|'/A\u0005he><H+\u00192mK\u0006y1\r[3dW\u000e{gn]5ti\u0016tG/\u0001\u0007o]NK'0Z'ba\u0006#G\r\u0006\u0003\u0002\u0004\n\u0005\u0005B\u0002BB?\u0001\u0007q0A\u0001iQ\u001dy\"Q\bB\"\u0005\u000f\nqB\u001c8TSj,W*\u00199SK6|g/\u001a\u000b\u0005\u0003\u0007\u0013Y\t\u0003\u0004\u0003\u0004\u0002\u0002\ra \u0015\bA\tu\"1\tB$\u00039qgnU5{K6\u000b\u0007OU3tKR$B!a!\u0003\u0014\"1!QS\u0011A\u0002}\f1\u0002^1cY\u0016dUM\\4uQ\":\u0011E!\u0010\u0003D\t\u001d\u0013a\u0005;pi\u0006d7+\u001b>f\u001b\u0006\u0004()^2lKR\u001c\u0018aD2bY\u000e\u001c\u0016N_3NCB\u001c\u0016N_3\u0015\u0007}\u0014y\n\u0003\u0004\u0003\u0016\u000e\u0002\ra \u0015\bG\tu\"1\tB$\u0003-\u0019\u0018N_3NCBLe.\u001b;\u0015\t\u0005\r%q\u0015\u0005\u0007\u0005+#\u0003\u0019A@)\u000f\u0011\u0012iDa\u0011\u0003H\u0005)2/\u001b>f\u001b\u0006\u0004\u0018J\\5u\u0003:$'+\u001a2vS2$\u0007fB\u0013\u0003>\t\r#qI\u0001\raJLg\u000e^*ju\u0016l\u0015\r]\u0001\u000eaJLg\u000e^\"p]R,g\u000e^:\u0002\u001dML'0Z'ba\u0012K7/\u00192mK\u0006\u0001\u0012n]*ju\u0016l\u0015\r\u001d#fM&tW\rZ\u0001\u0012C2<\u0018-_:J]&$8+\u001b>f\u001b\u0006\u0004\u0018!B5oI\u0016DHcA@\u0003>\"1\u00111S\u0016A\u0002}\f!b\u00197fCJ$\u0016M\u00197f\u0003EA\u0017m\u001d5UC\ndWmQ8oi\u0016tGo]\u000b\u0003\u0005\u000b\u0004B\u0001\u0019\u001f\u0002.\u0006\u0001\u0012N\\5u/&$\bnQ8oi\u0016tGo\u001d\u000b\u0005\u0003\u0007\u0013Y\rC\u0004\u0003N:\u0002\rA!2\u0002\u0003\r\u0004")
public interface FlatHashTable<A>
extends HashUtils<A> {
    public static int newThreshold(int n, int n2) {
        return FlatHashTable$.MODULE$.newThreshold(n, n2);
    }

    public static int sizeForThreshold(int n, int n2) {
        return FlatHashTable$.MODULE$.sizeForThreshold(n, n2);
    }

    public static int loadFactorDenum() {
        return FlatHashTable$.MODULE$.loadFactorDenum();
    }

    public static int defaultLoadFactor() {
        return FlatHashTable$.MODULE$.defaultLoadFactor();
    }

    public static ThreadLocal<Random> seedGenerator() {
        return FlatHashTable$.MODULE$.seedGenerator();
    }

    private boolean tableDebug() {
        return false;
    }

    public int _loadFactor();

    public void _loadFactor_$eq(int var1);

    public Object[] table();

    public void table_$eq(Object[] var1);

    public int tableSize();

    public void tableSize_$eq(int var1);

    public int threshold();

    public void threshold_$eq(int var1);

    public int[] sizemap();

    public void sizemap_$eq(int[] var1);

    public int seedvalue();

    public void seedvalue_$eq(int var1);

    public static /* synthetic */ int capacity$(FlatHashTable $this, int expectedSize) {
        return $this.capacity(expectedSize);
    }

    default public int capacity(int expectedSize) {
        return HashTable$.MODULE$.nextPositivePowerOfTwo(expectedSize);
    }

    public static /* synthetic */ int initialSize$(FlatHashTable $this) {
        return $this.initialSize();
    }

    default public int initialSize() {
        return 32;
    }

    private int initialCapacity() {
        return this.capacity(this.initialSize());
    }

    public static /* synthetic */ int randomSeed$(FlatHashTable $this) {
        return $this.randomSeed();
    }

    default public int randomSeed() {
        return FlatHashTable$.MODULE$.seedGenerator().get().nextInt();
    }

    public static /* synthetic */ int tableSizeSeed$(FlatHashTable $this) {
        return $this.tableSizeSeed();
    }

    default public int tableSizeSeed() {
        return Integer.bitCount(this.table().length - 1);
    }

    public static /* synthetic */ void init$(FlatHashTable $this, ObjectInputStream in, Function1 f) {
        $this.init(in, f);
    }

    default public void init(ObjectInputStream in, Function1<A, BoxedUnit> f) {
        in.defaultReadObject();
        this._loadFactor_$eq(in.readInt());
        Predef$.MODULE$.assert(this._loadFactor() > 0);
        int size = in.readInt();
        this.tableSize_$eq(0);
        Predef$.MODULE$.assert(size >= 0);
        this.table_$eq(new Object[this.capacity(FlatHashTable$.MODULE$.sizeForThreshold(size, this._loadFactor()))]);
        this.threshold_$eq(FlatHashTable$.MODULE$.newThreshold(this._loadFactor(), this.table().length));
        this.seedvalue_$eq(in.readInt());
        if (in.readBoolean()) {
            this.sizeMapInit(this.table().length);
        } else {
            this.sizemap_$eq(null);
        }
        for (int index = 0; index < size; ++index) {
            Object elem = this.entryToElem(in.readObject());
            f.apply(elem);
            this.addElem(elem);
        }
    }

    public static /* synthetic */ void serializeTo$(FlatHashTable $this, ObjectOutputStream out) {
        $this.serializeTo(out);
    }

    default public void serializeTo(ObjectOutputStream out) {
        out.defaultWriteObject();
        out.writeInt(this._loadFactor());
        out.writeInt(this.tableSize());
        out.writeInt(this.seedvalue());
        out.writeBoolean(this.isSizeMapDefined());
        this.iterator().foreach((Function1<Object, Object> & java.io.Serializable & Serializable)x$1 -> {
            out.writeObject(x$1);
            return BoxedUnit.UNIT;
        });
    }

    public static /* synthetic */ Option findEntry$(FlatHashTable $this, Object elem) {
        return $this.findEntry(elem);
    }

    default public Option<A> findEntry(A elem) {
        Object object = this.findElemImpl(elem);
        Option option = object == null ? None$.MODULE$ : new Some(this.entryToElem(object));
        return option;
    }

    public static /* synthetic */ boolean containsElem$(FlatHashTable $this, Object elem) {
        return $this.containsElem(elem);
    }

    default public boolean containsElem(A elem) {
        return this.findElemImpl(elem) != null;
    }

    private Object findElemImpl(A elem) {
        Object searchEntry = this.elemToEntry(elem);
        int h = this.index(searchEntry.hashCode());
        Object curEntry = this.table()[h];
        while (curEntry != null && !BoxesRunTime.equals(curEntry, searchEntry)) {
            h = (h + 1) % this.table().length;
            curEntry = this.table()[h];
        }
        return curEntry;
    }

    public static /* synthetic */ boolean addElem$(FlatHashTable $this, Object elem) {
        return $this.addElem(elem);
    }

    default public boolean addElem(A elem) {
        return this.addEntry(this.elemToEntry(elem));
    }

    public static /* synthetic */ boolean addEntry$(FlatHashTable $this, Object newEntry) {
        return $this.addEntry(newEntry);
    }

    default public boolean addEntry(Object newEntry) {
        int h = this.index(newEntry.hashCode());
        Object curEntry = this.table()[h];
        while (curEntry != null) {
            if (BoxesRunTime.equals(curEntry, newEntry)) {
                return false;
            }
            h = (h + 1) % this.table().length;
            curEntry = this.table()[h];
        }
        this.table()[h] = newEntry;
        this.tableSize_$eq(this.tableSize() + 1);
        this.nnSizeMapAdd(h);
        if (this.tableSize() >= this.threshold()) {
            this.growTable();
        }
        return true;
    }

    public static /* synthetic */ boolean removeElem$(FlatHashTable $this, Object elem) {
        return $this.removeElem(elem);
    }

    default public boolean removeElem(A elem) {
        if (this.tableDebug()) {
            this.checkConsistent();
        }
        Object removalEntry = this.elemToEntry(elem);
        int h = this.index(removalEntry.hashCode());
        Object curEntry = this.table()[h];
        while (curEntry != null) {
            if (BoxesRunTime.equals(curEntry, removalEntry)) {
                int h0 = h;
                int h1 = (h + 1) % this.table().length;
                while (this.table()[h1] != null) {
                    int h2 = this.index(this.table()[h1].hashCode());
                    if (h2 != h1 && this.precedes$1(h2, h0)) {
                        this.table()[h0] = this.table()[h1];
                        h0 = h1;
                    }
                    h1 = (h1 + 1) % this.table().length;
                }
                this.table()[h0] = null;
                this.tableSize_$eq(this.tableSize() - 1);
                this.nnSizeMapRemove(h0);
                if (this.tableDebug()) {
                    this.checkConsistent();
                }
                return true;
            }
            h = (h + 1) % this.table().length;
            curEntry = this.table()[h];
        }
        return false;
    }

    public static /* synthetic */ Iterator iterator$(FlatHashTable $this) {
        return $this.iterator();
    }

    default public Iterator<A> iterator() {
        return new AbstractIterator<A>(this){
            private int i;
            private final /* synthetic */ FlatHashTable $outer;

            private int i() {
                return this.i;
            }

            private void i_$eq(int x$1) {
                this.i = x$1;
            }

            public boolean hasNext() {
                while (this.i() < this.$outer.table().length && this.$outer.table()[this.i()] == null) {
                    this.i_$eq(this.i() + 1);
                }
                return this.i() < this.$outer.table().length;
            }

            public A next() {
                if (this.hasNext()) {
                    this.i_$eq(this.i() + 1);
                    return this.$outer.entryToElem(this.$outer.table()[this.i() - 1]);
                }
                return (A)Iterator$.MODULE$.empty().next();
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                this.i = 0;
            }
        };
    }

    private void growTable() {
        Object[] oldtable = this.table();
        this.table_$eq(new Object[this.table().length * 2]);
        this.tableSize_$eq(0);
        this.nnSizeMapReset(this.table().length);
        this.seedvalue_$eq(this.tableSizeSeed());
        this.threshold_$eq(FlatHashTable$.MODULE$.newThreshold(this._loadFactor(), this.table().length));
        for (int i = 0; i < oldtable.length; ++i) {
            Object entry = oldtable[i];
            if (entry == null) continue;
            this.addEntry(entry);
        }
        if (this.tableDebug()) {
            this.checkConsistent();
        }
    }

    private void checkConsistent() {
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range range = RichInt$.MODULE$.until$extension0(n, this.table().length);
        if (range == null) {
            throw null;
        }
        Range foreach$mVc$sp_this = range;
        if (!foreach$mVc$sp_this.isEmpty()) {
            int foreach$mVc$sp_i = foreach$mVc$sp_this.start();
            while (true) {
                FlatHashTable.$anonfun$checkConsistent$1(this, foreach$mVc$sp_i);
                if (foreach$mVc$sp_i == foreach$mVc$sp_this.scala$collection$immutable$Range$$lastElement()) break;
                foreach$mVc$sp_i += foreach$mVc$sp_this.step();
            }
        }
    }

    public static /* synthetic */ void nnSizeMapAdd$(FlatHashTable $this, int h) {
        $this.nnSizeMapAdd(h);
    }

    default public void nnSizeMapAdd(int h) {
        if (this.sizemap() != null) {
            int p = h >> this.sizeMapBucketBitSize();
            int[] nArray = this.sizemap();
            nArray[p] = nArray[p] + 1;
        }
    }

    public static /* synthetic */ void nnSizeMapRemove$(FlatHashTable $this, int h) {
        $this.nnSizeMapRemove(h);
    }

    default public void nnSizeMapRemove(int h) {
        if (this.sizemap() != null) {
            int[] nArray = this.sizemap();
            int n = h >> this.sizeMapBucketBitSize();
            nArray[n] = nArray[n] - 1;
        }
    }

    public static /* synthetic */ void nnSizeMapReset$(FlatHashTable $this, int tableLength) {
        $this.nnSizeMapReset(tableLength);
    }

    default public void nnSizeMapReset(int tableLength) {
        if (this.sizemap() != null) {
            int nsize = this.calcSizeMapSize(tableLength);
            if (this.sizemap().length != nsize) {
                this.sizemap_$eq(new int[nsize]);
                return;
            }
            Arrays.fill(this.sizemap(), 0);
        }
    }

    public static /* synthetic */ int totalSizeMapBuckets$(FlatHashTable $this) {
        return $this.totalSizeMapBuckets();
    }

    default public int totalSizeMapBuckets() {
        return (this.table().length - 1) / this.sizeMapBucketSize() + 1;
    }

    public static /* synthetic */ int calcSizeMapSize$(FlatHashTable $this, int tableLength) {
        return $this.calcSizeMapSize(tableLength);
    }

    default public int calcSizeMapSize(int tableLength) {
        return (tableLength >> this.sizeMapBucketBitSize()) + 1;
    }

    public static /* synthetic */ void sizeMapInit$(FlatHashTable $this, int tableLength) {
        $this.sizeMapInit(tableLength);
    }

    default public void sizeMapInit(int tableLength) {
        this.sizemap_$eq(new int[this.calcSizeMapSize(tableLength)]);
    }

    public static /* synthetic */ void sizeMapInitAndRebuild$(FlatHashTable $this) {
        $this.sizeMapInitAndRebuild();
    }

    default public void sizeMapInitAndRebuild() {
        this.sizeMapInit(this.table().length);
        int totalbuckets = this.totalSizeMapBuckets();
        int tableidx = 0;
        Object[] tbl = this.table();
        int n = this.sizeMapBucketSize();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        int tableuntil = RichInt$.MODULE$.min$extension(n, tbl.length);
        for (int bucketidx = 0; bucketidx < totalbuckets; ++bucketidx) {
            int currbucketsz = 0;
            while (tableidx < tableuntil) {
                if (tbl[tableidx] != null) {
                    ++currbucketsz;
                }
                ++tableidx;
            }
            this.sizemap()[bucketidx] = currbucketsz;
            tableuntil += this.sizeMapBucketSize();
        }
    }

    public static /* synthetic */ void printSizeMap$(FlatHashTable $this) {
        $this.printSizeMap();
    }

    default public void printSizeMap() {
        Predef$.MODULE$.println(new ArrayOps.ofInt(Predef$.MODULE$.intArrayOps(this.sizemap())).mkString("szmap: [", ", ", "]"));
    }

    public static /* synthetic */ void printContents$(FlatHashTable $this) {
        $this.printContents();
    }

    default public void printContents() {
        Predef$.MODULE$.println(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps(this.table())).mkString("[", ", ", "]"));
    }

    public static /* synthetic */ void sizeMapDisable$(FlatHashTable $this) {
        $this.sizeMapDisable();
    }

    default public void sizeMapDisable() {
        this.sizemap_$eq(null);
    }

    public static /* synthetic */ boolean isSizeMapDefined$(FlatHashTable $this) {
        return $this.isSizeMapDefined();
    }

    default public boolean isSizeMapDefined() {
        return this.sizemap() != null;
    }

    public static /* synthetic */ boolean alwaysInitSizeMap$(FlatHashTable $this) {
        return $this.alwaysInitSizeMap();
    }

    default public boolean alwaysInitSizeMap() {
        return false;
    }

    public static /* synthetic */ int index$(FlatHashTable $this, int hcode) {
        return $this.index(hcode);
    }

    default public int index(int hcode) {
        int improved = this.improve(hcode, this.seedvalue());
        int ones = this.table().length - 1;
        return improved >>> 32 - Integer.bitCount(ones) & ones;
    }

    public static /* synthetic */ void clearTable$(FlatHashTable $this) {
        $this.clearTable();
    }

    default public void clearTable() {
        for (int i = this.table().length - 1; i >= 0; --i) {
            this.table()[i] = null;
        }
        this.tableSize_$eq(0);
        this.nnSizeMapReset(this.table().length);
    }

    public static /* synthetic */ Contents hashTableContents$(FlatHashTable $this) {
        return $this.hashTableContents();
    }

    default public Contents<A> hashTableContents() {
        return new Contents(this._loadFactor(), this.table(), this.tableSize(), this.threshold(), this.seedvalue(), this.sizemap());
    }

    public static /* synthetic */ void initWithContents$(FlatHashTable $this, Contents c) {
        $this.initWithContents(c);
    }

    default public void initWithContents(Contents<A> c) {
        if (c != null) {
            this._loadFactor_$eq(c.loadFactor());
            this.table_$eq(c.table());
            this.tableSize_$eq(c.tableSize());
            this.threshold_$eq(c.threshold());
            this.seedvalue_$eq(c.seedvalue());
            this.sizemap_$eq(c.sizemap());
        }
        if (this.alwaysInitSizeMap() && this.sizemap() == null) {
            this.sizeMapInitAndRebuild();
        }
    }

    private boolean precedes$1(int i, int j) {
        int d = this.table().length >> 1;
        if (i <= j) {
            return j - i < d;
        }
        return i - j > d;
    }

    public static /* synthetic */ String $anonfun$checkConsistent$2(FlatHashTable $this, int i$1) {
        return new StringBuilder(2).append(i$1).append(" ").append($this.table()[i$1]).append(" ").append(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps($this.table())).mkString()).toString();
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ void $anonfun$checkConsistent$1(FlatHashTable $this, int i) {
        if ($this.table()[i] != null && !$this.containsElem($this.entryToElem($this.table()[i]))) {
            void assert_assertion;
            boolean bl = false;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)FlatHashTable.$anonfun$checkConsistent$2($this, i)).toString());
            }
        }
    }

    public static void $init$(FlatHashTable $this) {
        $this._loadFactor_$eq(FlatHashTable$.MODULE$.defaultLoadFactor());
        $this.table_$eq(new Object[$this.initialCapacity()]);
        $this.tableSize_$eq(0);
        $this.threshold_$eq(FlatHashTable$.MODULE$.newThreshold($this._loadFactor(), $this.initialCapacity()));
        $this.sizemap_$eq(null);
        $this.seedvalue_$eq($this.tableSizeSeed());
    }

    public static class Contents<A> {
        private final int loadFactor;
        private final Object[] table;
        private final int tableSize;
        private final int threshold;
        private final int seedvalue;
        private final int[] sizemap;

        public int loadFactor() {
            return this.loadFactor;
        }

        public Object[] table() {
            return this.table;
        }

        public int tableSize() {
            return this.tableSize;
        }

        public int threshold() {
            return this.threshold;
        }

        public int seedvalue() {
            return this.seedvalue;
        }

        public int[] sizemap() {
            return this.sizemap;
        }

        public Contents(int loadFactor, Object[] table, int tableSize, int threshold, int seedvalue, int[] sizemap) {
            this.loadFactor = loadFactor;
            this.table = table;
            this.tableSize = tableSize;
            this.threshold = threshold;
            this.seedvalue = seedvalue;
            this.sizemap = sizemap;
        }
    }

    public static interface HashUtils<A> {
        public static /* synthetic */ int sizeMapBucketBitSize$(HashUtils $this) {
            return $this.sizeMapBucketBitSize();
        }

        default public int sizeMapBucketBitSize() {
            return 5;
        }

        public static /* synthetic */ int sizeMapBucketSize$(HashUtils $this) {
            return $this.sizeMapBucketSize();
        }

        default public int sizeMapBucketSize() {
            return 1 << this.sizeMapBucketBitSize();
        }

        public static /* synthetic */ int improve$(HashUtils $this, int hcode, int seed) {
            return $this.improve(hcode, seed);
        }

        default public int improve(int hcode, int seed) {
            return Integer.rotateRight(package$.MODULE$.byteswap32(hcode), seed);
        }

        public static /* synthetic */ Object elemToEntry$(HashUtils $this, Object elem) {
            return $this.elemToEntry(elem);
        }

        default public Object elemToEntry(A elem) {
            if (elem == null) {
                return FlatHashTable$NullSentinel$.MODULE$;
            }
            return elem;
        }

        public static /* synthetic */ Object entryToElem$(HashUtils $this, Object entry) {
            return $this.entryToElem(entry);
        }

        default public A entryToElem(Object entry) {
            if (entry == FlatHashTable$NullSentinel$.MODULE$) {
                return null;
            }
            return (A)entry;
        }

        public static void $init$(HashUtils $this) {
        }
    }
}

