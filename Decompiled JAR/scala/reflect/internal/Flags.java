/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Array$;
import scala.Function1;
import scala.Function1$mcJJ$sp;
import scala.Predef$;
import scala.Serializable;
import scala.Tuple2;
import scala.Tuple2$mcJJ$sp;
import scala.collection.GenTraversableOnce;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Range;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.ModifierFlags;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.java8.JFunction1$mcJI$sp;
import scala.runtime.java8.JFunction1$mcJJ$sp;
import scala.runtime.java8.JFunction1$mcZJ$sp;
import scala.runtime.java8.JFunction2$mcJJJ$sp;

@ScalaSignature(bytes="\u0006\u0001\u0011\u0015haBA-\u00037\u0002\u0011\u0011\u000e\u0005\b\u0003g\u0002A\u0011AA;\u0011%\tI\b\u0001b\u0001\n\u000b\tY\b\u0003\u0005\u0002\u0002\u0002\u0001\u000bQBA?\u0011%\t\u0019\t\u0001b\u0001\n\u000b\t)\t\u0003\u0005\u0002\f\u0002\u0001\u000bQBAD\u0011%\ti\t\u0001b\u0001\n\u000b\ty\t\u0003\u0005\u0002\u0016\u0002\u0001\u000bQBAI\u0011%\t9\n\u0001b\u0001\n\u000b\tI\n\u0003\u0005\u0002 \u0002\u0001\u000bQBAN\u0011%\t\t\u000b\u0001b\u0001\n\u000b\t\u0019\u000b\u0003\u0005\u0002*\u0002\u0001\u000bQBAS\u0011%\tY\u000b\u0001b\u0001\n\u000b\t\u0019\u000b\u0003\u0005\u0002.\u0002\u0001\u000bQBAS\u0011%\ty\u000b\u0001b\u0001\n\u000b\t\t\f\u0003\u0005\u00028\u0002\u0001\u000bQBAZ\u0011%\tI\f\u0001b\u0001\n\u000b\tY\f\u0003\u0005\u0002B\u0002\u0001\u000bQBA_\u0011%\t\u0019\r\u0001b\u0001\n\u000b\t)\r\u0003\u0005\u0002L\u0002\u0001\u000bQBAd\u0011%\ti\r\u0001b\u0001\n\u000b\ty\r\u0003\u0005\u0002V\u0002\u0001\u000bQBAi\u0011%\t9\u000e\u0001b\u0001\n\u000b\tI\u000e\u0003\u0005\u0002`\u0002\u0001\u000bQBAn\u0011%\t\t\u000f\u0001b\u0001\n\u000b\t\u0019\u000f\u0003\u0005\u0002j\u0002\u0001\u000bQBAs\u0011%\tY\u000f\u0001b\u0001\n\u000b\ti\u000f\u0003\u0005\u0002t\u0002\u0001\u000bQBAx\u0011%\t)\u0010\u0001b\u0001\n\u000b\t9\u0010\u0003\u0005\u0002~\u0002\u0001\u000bQBA}\u0011%\ty\u0010\u0001b\u0001\n\u000b\u0011\t\u0001\u0003\u0005\u0003\b\u0001\u0001\u000bQ\u0002B\u0002\u0011%\u0011I\u0001\u0001b\u0001\n\u000b\u0011Y\u0001\u0003\u0005\u0003\u0012\u0001\u0001\u000bQ\u0002B\u0007\u0011%\u0011\u0019\u0002\u0001b\u0001\n\u000b\u0011Y\u0001\u0003\u0005\u0003\u0016\u0001\u0001\u000bQ\u0002B\u0007\u0011%\u00119\u0002\u0001b\u0001\n\u000b\u0011I\u0002\u0003\u0005\u0003 \u0001\u0001\u000bQ\u0002B\u000e\u0011%\u0011\t\u0003\u0001b\u0001\n\u000b\u0011\u0019\u0003\u0003\u0005\u0003*\u0001\u0001\u000bQ\u0002B\u0013\u0011%\u0011Y\u0003\u0001b\u0001\n\u000b\u0011i\u0003\u0003\u0005\u00034\u0001\u0001\u000bQ\u0002B\u0018\u0011%\u0011)\u0004\u0001b\u0001\n\u000b\u00119\u0004\u0003\u0005\u0003>\u0001\u0001\u000bQ\u0002B\u001d\u0011%\u0011y\u0004\u0001b\u0001\n\u000b\u0011\t\u0005\u0003\u0005\u0003H\u0001\u0001\u000bQ\u0002B\"\u0011%\u0011I\u0005\u0001b\u0001\n\u000b\u0011Y\u0005\u0003\u0005\u0003R\u0001\u0001\u000bQ\u0002B'\u0011%\u0011\u0019\u0006\u0001b\u0001\n\u000b\u0011)\u0006\u0003\u0005\u0003\\\u0001\u0001\u000bQ\u0002B,\u0011%\u0011i\u0006\u0001b\u0001\n\u000b\u0011y\u0006\u0003\u0005\u0003f\u0001\u0001\u000bQ\u0002B1\u0011%\u00119\u0007\u0001b\u0001\n\u000b\u0011I\u0007\u0003\u0005\u0003p\u0001\u0001\u000bQ\u0002B6\u0011%\u0011\t\b\u0001b\u0001\n\u000b\u0011\u0019\b\u0003\u0005\u0003z\u0001\u0001\u000bQ\u0002B;\u0011%\u0011Y\b\u0001b\u0001\n\u000b\u0011i\b\u0003\u0005\u0003\u0004\u0002\u0001\u000bQ\u0002B@\u0011%\u0011)\t\u0001b\u0001\n\u000b\u00119\t\u0003\u0005\u0003\u000e\u0002\u0001\u000bQ\u0002BE\u0011%\u0011y\t\u0001b\u0001\n\u000b\u0011\t\n\u0003\u0005\u0003\u0018\u0002\u0001\u000bQ\u0002BJ\u0011%\u0011I\n\u0001b\u0001\n\u000b\u0011Y\n\u0003\u0005\u0003\"\u0002\u0001\u000bQ\u0002BO\u0011%\u0011\u0019\u000b\u0001b\u0001\n\u000b\u0011)\u000b\u0003\u0005\u0003,\u0002\u0001\u000bQ\u0002BT\u0011%\u0011i\u000b\u0001b\u0001\n\u000b\u0011y\u000b\u0003\u0005\u00036\u0002\u0001\u000bQ\u0002BY\u0011%\u00119\f\u0001b\u0001\n\u000b\u0011I\f\u0003\u0005\u0003@\u0002\u0001\u000bQ\u0002B^\u0011%\u0011\t\r\u0001b\u0001\n\u000b\u0011\u0019\r\u0003\u0005\u0003N\u0002\u0001\u000bQ\u0002Bc\u0011%\u0011y\r\u0001b\u0001\n\u000b\u0011\u0019\r\u0003\u0005\u0003R\u0002\u0001\u000bQ\u0002Bc\u0011%\u0011\u0019\u000e\u0001b\u0001\n\u000b\u0011)\u000e\u0003\u0005\u0003\\\u0002\u0001\u000bQ\u0002Bl\u0011%\u0011i\u000e\u0001b\u0001\n\u000b\u0011y\u000e\u0003\u0005\u0003f\u0002\u0001\u000bQ\u0002Bq\u0011%\u00119\u000f\u0001b\u0001\n\u000b\t)\t\u0003\u0005\u0003j\u0002\u0001\u000bQBAD\u0011%\u0011Y\u000f\u0001b\u0001\n\u000b\u0011i\u000f\u0003\u0005\u0003t\u0002\u0001\u000bQ\u0002Bx\u0011%\u0011)\u0010\u0001b\u0001\n\u000b\u00119\u0010\u0003\u0005\u0003~\u0002\u0001\u000bQ\u0002B}\u0011%\u0011y\u0010\u0001b\u0001\n\u000b\u0019\t\u0001\u0003\u0005\u0004\b\u0001\u0001\u000bQBB\u0002\u0011%\u0019I\u0001\u0001b\u0001\n\u000b\u0019Y\u0001\u0003\u0005\u0004\u0012\u0001\u0001\u000bQBB\u0007\u0011%\u0019\u0019\u0002\u0001b\u0001\n\u000b\u0019)\u0002\u0003\u0005\u0004\u001c\u0001\u0001\u000bQBB\f\u0011%\u0019i\u0002\u0001b\u0001\n\u000b\u0011\u0019\r\u0003\u0005\u0004 \u0001\u0001\u000bQ\u0002Bc\u0011%\u0019\t\u0003\u0001b\u0001\n\u000b\u0011\u0019\r\u0003\u0005\u0004$\u0001\u0001\u000bQ\u0002Bc\u0011%\u0019)\u0003\u0001b\u0001\n\u000b\u00199\u0003\u0003\u0005\u0004.\u0001\u0001\u000bQBB\u0015\u0011%\u0019y\u0003\u0001b\u0001\n\u000b\u0019\t\u0004\u0003\u0005\u00048\u0001\u0001\u000bQBB\u001a\u0011%\u0019I\u0004\u0001b\u0001\n\u000b\u0019Y\u0004\u0003\u0005\u0004B\u0001\u0001\u000bQBB\u001f\u0011%\u0019\u0019\u0005\u0001b\u0001\n\u000b\u0019)\u0005\u0003\u0005\u0004L\u0001\u0001\u000bQBB$\u0011%\u0019i\u0005\u0001b\u0001\n\u000b\u0019y\u0005\u0003\u0005\u0004V\u0001\u0001\u000bQBB)\u0011%\u00199\u0006\u0001b\u0001\n\u000b\u0019I\u0006\u0003\u0005\u0004`\u0001\u0001\u000bQBB.\u0011%\u0019\t\u0007\u0001b\u0001\n\u000b\u0019\u0019\u0007\u0003\u0005\u0004j\u0001\u0001\u000bQBB3\u0011%\u0019Y\u0007\u0001b\u0001\n\u000b\u0019i\u0007\u0003\u0005\u0004t\u0001\u0001\u000bQBB8\u0011%\u0019)\b\u0001b\u0001\n\u000b\u0011\u0019\r\u0003\u0005\u0004x\u0001\u0001\u000bQ\u0002Bc\u0011%\u0019I\b\u0001b\u0001\n\u000b\u0011\u0019\r\u0003\u0005\u0004|\u0001\u0001\u000bQ\u0002Bc\u0011\u001d\u0019i\b\u0001C\u0001\u0007\u007fBqa!\"\u0001\t\u0003\u00199\tC\u0004\u0004\u000e\u0002!\taa$\t\u0013\rM\u0005A1A\u0005\u000e\rU\u0005\u0002CBN\u0001\u0001\u0006iaa&\t\u0013\ru\u0005A1A\u0005\u000e\r}\u0005\u0002CBS\u0001\u0001\u0006ia!)\t\u0013\r\u001d\u0006A1A\u0005\u000e\r%\u0006\u0002CBX\u0001\u0001\u0006iaa+\t\u0013\rE\u0006A1A\u0005\u000e\rM\u0006\u0002CB]\u0001\u0001\u0006ia!.\t\u0013\rm\u0006A1A\u0005\u000e\ru\u0006\u0002CBb\u0001\u0001\u0006iaa0\t\u0013\r\u0015\u0007A1A\u0005\u000e\r\u001d\u0007\u0002CBg\u0001\u0001\u0006ia!3\t\u0013\r=\u0007A1A\u0005\u000e\u0005m\u0004\u0002CBi\u0001\u0001\u0006i!! \t\u0013\rM\u0007A1A\u0005\u000e\rU\u0007\u0002CBn\u0001\u0001\u0006iaa6\t\u0013\ru\u0007A1A\u0005\u000e\u0005\u0015\u0005\u0002CBp\u0001\u0001\u0006i!a\"\t\u0013\r\u0005\bA1A\u0005\u000e\r\r\b\u0002CBu\u0001\u0001\u0006ia!:\t\u0013\r-\bA1A\u0005\u000e\r5\b\u0002CBz\u0001\u0001\u0006iaa<\t\u0013\rU\bA1A\u0005\u000e\r]\b\u0002CB\u007f\u0001\u0001\u0006ia!?\t\u0013\r}\bA1A\u0005\u000e\u0011\u0005\u0001\u0002\u0003C\u0004\u0001\u0001\u0006i\u0001b\u0001\t\u000f\u0011%\u0001\u0001\"\u0003\u0005\f!IA\u0011\u0004\u0001C\u0002\u0013%A1\u0004\u0005\t\t?\u0001\u0001\u0015!\u0003\u0005\u001e!IA\u0011\u0005\u0001C\u0002\u0013%A1\u0004\u0005\t\tG\u0001\u0001\u0015!\u0003\u0005\u001e\u00191AQ\u0005\u0001\u0005\tOA1\u0002\"\u000e\u0002*\t\u0005\t\u0015!\u0003\u0005\u001e!YAqGA\u0015\u0005\u0003\u0005\u000b\u0011\u0002C\u000f\u0011!\t\u0019(!\u000b\u0005\u0002\u0011e\u0002B\u0003C\"\u0003S\u0011\r\u0011\"\u0001\u0003D\"IAQIA\u0015A\u0003%!Q\u0019\u0005\t\t\u000f\nI\u0003\"\u0001\u0005J!IAq\n\u0001C\u0002\u0013\u0005A\u0011\u000b\u0005\t\t'\u0002\u0001\u0015!\u0003\u00050!IAQ\u000b\u0001C\u0002\u0013\u0005A\u0011\u000b\u0005\t\t/\u0002\u0001\u0015!\u0003\u00050!9A\u0011\f\u0001\u0005B\u0011m\u0003b\u0002CC\u0001\u0011%Aq\u0011\u0005\n\t;\u0003A\u0011AA2\t?C\u0011\u0002\"(\u0001\t\u0003\t\u0019\u0007\".\t\u0013\u0011m\u0006A1A\u0005\u0006\u0011u\u0006\u0002\u0003Cb\u0001\u0001\u0006i\u0001b0\t\u0013\u0011\u0015\u0007A1A\u0005\u0006\u0011\u001d\u0007\u0002\u0003Cl\u0001\u0001\u0006i\u0001\"3\t\u0013\u0011e\u0007A1A\u0005\u0006\u0011m\u0001\u0002\u0003Cn\u0001\u0001\u0006i\u0001\"\b\b\u0011\u0011u\u00171\fE\u0001\t?4\u0001\"!\u0017\u0002\\!\u0005A\u0011\u001d\u0005\t\u0003g\n)\u0006\"\u0001\u0005d\n)a\t\\1hg*!\u0011QLA0\u0003!Ig\u000e^3s]\u0006d'\u0002BA1\u0003G\nqA]3gY\u0016\u001cGO\u0003\u0002\u0002f\u0005)1oY1mC\u000e\u00011c\u0001\u0001\u0002lA!\u0011QNA8\u001b\t\tY&\u0003\u0003\u0002r\u0005m#!D'pI&4\u0017.\u001a:GY\u0006<7/\u0001\u0004=S:LGO\u0010\u000b\u0003\u0003o\u00022!!\u001c\u0001\u0003\u0019iU\t\u0016%P\tV\u0011\u0011QP\b\u0003\u0003\u007fj\u0012\u0001Q\u0001\b\u001b\u0016#\u0006j\u0014#!\u0003\u0019iu\nR+M\u000bV\u0011\u0011qQ\b\u0003\u0003\u0013k\"!\u0001\u0001\u0002\u000f5{E)\u0016'FA\u00059\u0001+Q\"L\u0003\u001e+UCAAI\u001f\t\t\u0019*\b\u0002A\u0001\u0005A\u0001+Q\"L\u0003\u001e+\u0005%\u0001\u0005D\u0003B#VKU#E+\t\tYj\u0004\u0002\u0002\u001ev\u0019\u0011\u0001\u0001\u0001\u0002\u0013\r\u000b\u0005\u000bV+S\u000b\u0012\u0003\u0013!\u0002'B\u0005\u0016cUCAAS\u001f\t\t9+H\u0002\u0003\u0001\u0001\ta\u0001T!C\u000b2\u0003\u0013!D%O\u0007>s5\u000b\u0016*V\u0007R{%+\u0001\bJ\u001d\u000e{ej\u0015+S+\u000e#vJ\u0015\u0011\u0002\u0013MKf\n\u0016%F)&\u001bUCAAZ\u001f\t\t),H\u0002!\u0001\u0001\t!bU-O)\"+E+S\"!\u0003\u0019\u0019F+\u0011\"M\u000bV\u0011\u0011QX\b\u0003\u0003\u007fk2\u0001\u0011\u0001\u0001\u0003\u001d\u0019F+\u0011\"M\u000b\u0002\naA\u0011*J\t\u001e+UCAAd\u001f\t\tI-\b\u0003\u0005\u0001\u0001\u0001\u0011a\u0002\"S\u0013\u0012;U\tI\u0001\t\u0003\u000e\u001bUiU*P%V\u0011\u0011\u0011[\b\u0003\u0003'lB\u0001\u0003\u0001\u0001\u0001\u0005I\u0011iQ\"F'N{%\u000bI\u0001\u000e'V\u0003VIU!D\u0007\u0016\u001b6k\u0014*\u0016\u0005\u0005mwBAAo;\u0011\u0001\u0002\u0001\u0001\u0001\u0002\u001dM+\u0006+\u0012*B\u0007\u000e+5kU(SA\u0005IQj\u0014#V\u0019\u00163\u0016IU\u000b\u0003\u0003K|!!a:\u001e\t\u0001\u0003\u0001\u0001A\u0001\u000b\u001b>#U\u000bT#W\u0003J\u0003\u0013\u0001C%T?\u0016\u0013&k\u0014*\u0016\u0005\u0005=xBAAy=\u0015\t\u0001\u0001\u0001\u0001\u0001\u0003%I5kX#S%>\u0013\u0006%\u0001\u0006P-\u0016\u0013FjT!E\u000b\u0012+\"!!?\u0010\u0005\u0005mh$\u0002\u0002\u0001\u0001\u0001\u0001\u0011aC(W\u000bJcu*\u0011#F\t\u0002\na\u0001T%G)\u0016#UC\u0001B\u0002\u001f\t\u0011)AH\u0003\u0005\u0001\u0001\u0001\u0001!A\u0004M\u0013\u001a#V\t\u0012\u0011\u0002\u000f5K\u0005,\u0012#J\u001dV\u0011!QB\b\u0003\u0005\u001fqR\u0001\u0003\u0001\u0001\u0001\u0001\t\u0001\"T%Y\u000b\u0012Ke\nI\u0001\f\u000bbK5\u000bV#O)&\u000bE*\u0001\u0007F1&\u001bF+\u0012(U\u0013\u0006c\u0005%\u0001\u0007F1B\u000be\nR#E\u001d\u0006kU)\u0006\u0002\u0003\u001c=\u0011!Q\u0004\u0010\u0006!\u0001\u0001\u0001\u0001A\u0001\u000e\u000bb\u0003\u0016I\u0014#F\t:\u000bU*\u0012\u0011\u0002\u0015Q\u0013\u0016IT*`\r2\u000bu)\u0006\u0002\u0003&=\u0011!q\u0005\u0010\u0006\u0001\u0002\u0001\u0001\u0001A\u0001\f)J\u000bejU0G\u0019\u0006;\u0005%\u0001\u0004M\u001f\u000e[U\tR\u000b\u0003\u0005_y!A!\r\u001f\r\u0001\u0001\t\u0001\u0001\u0001\u0001\u0003\u001daujQ&F\t\u0002\n1b\u0015)F\u0007&\u000bE*\u0013.F\tV\u0011!\u0011H\b\u0003\u0005wqb!\u0001\u0001\u0001\u0001\u0001\u0001\u0011\u0001D*Q\u000b\u000eK\u0015\tT%[\u000b\u0012\u0003\u0013a\u0002,C%&#u)R\u000b\u0003\u0005\u0007z!A!\u0012\u001f\r\u0011\u0001\u0001\u0001\u0001\u0001\u0001\u0003!1&IU%E\u000f\u0016\u0003\u0013a\u0002,B%\u0006\u0013viU\u000b\u0003\u0005\u001bz!Aa\u0014\u001f\r!\u0001\u0001\u0001\u0001\u0001\u0001\u0003!1\u0016IU!S\u000fN\u0003\u0013\u0001\u0004+S\u0013\u0016#5iT(L\u0013:;UC\u0001B,\u001f\t\u0011IF\b\u0004\u0011\u0001\u0001\u0001\u0001\u0001A\u0001\u000e)JKU\tR\"P\u001f.Kej\u0012\u0011\u0002\u0019MKfj\u0011%S\u001f:K%,\u0012#\u0016\u0005\t\u0005tB\u0001B2=\u0019\u0001\u0003\u0001\u0001\u0001\u0001\u0001\u0005i1+\u0017(D\u0011J{e*\u0013.F\t\u0002\n1dU-O)\"+5+\u0013.F?&k\u0005\u000bT0J\u001d~\u001bVKQ\"M\u0003N\u001bVC\u0001B6\u001f\t\u0011iGH\u0004\u0005\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u00029MKf\n\u0016%F'&SViX%N!2{\u0016JT0T+\n\u001bE*Q*TA\u0005Ya*R#E'~#&+R#T+\t\u0011)h\u0004\u0002\u0003xyA\u0001\u0002\u0001\u0001\u0001\u0001\u0001\u0001\u0001!\u0001\u0007O\u000b\u0016#5k\u0018+S\u000b\u0016\u001b\u0006%\u0001\u0007J]&$\u0018.\u00197GY\u0006<7/\u0006\u0002\u0003\u0000=\u0011!\u0011\u0011\u0010\b\u000f}\u0000\u0000\u0000\u0000\u0000\u0000\u00045Ie.\u001b;jC24E.Y4tA\u0005IA*\u0019;f\r2\fwm]\u000b\u0003\u0005\u0013{!Aa#\u001f\u0011\u0001A\u0010\u0001\u0001\u0001\u0001\u0001\u0001\t!\u0002T1uK\u001ac\u0017mZ:!\u0003%\te\u000e^5GY\u0006<7/\u0006\u0002\u0003\u0014>\u0011!Q\u0013\u0010\t\u000f\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005Q\u0011I\u001c;j\r2\fwm\u001d\u0011\u0002\u00131\u000bG/Z*iS\u001a$XC\u0001BO\u001f\t\u0011y*H\u00010\u0003)a\u0015\r^3TQ&4G\u000fI\u0001\n\u0003:$\u0018n\u00155jMR,\"Aa*\u0010\u0005\t%V$\u0001\u001d\u0002\u0015\u0005sG/[*iS\u001a$\b%A\u000bQQ\u0006\u001cX-\u00138eKB,g\u000eZ3oi\u001ac\u0017mZ:\u0016\u0005\tEvB\u0001BZ=!A\u0000a\u0000\u0000\u0000\u0000|H\u0011A\u0006)iCN,\u0017J\u001c3fa\u0016tG-\u001a8u\r2\fwm\u001d\u0011\u0002'=3XM\u001d7pC\u0012,GM\u00127bONl\u0015m]6\u0016\u0005\tmvB\u0001B_=\u0015A!a\u0001\u0001\u0001\u0003Qye/\u001a:m_\u0006$W\r\u001a$mC\u001e\u001cX*Y:lA\u0005Qan\u001c;Q%&3\u0016\tV#\u0016\u0005\t\u0015\u0007\u0003\u0002Bd\u0005\u0013l!!a\u0019\n\t\t-\u00171\r\u0002\u0005\u0019>tw-A\u0006o_R\u0004&+\u0013,B)\u0016\u0003\u0013\u0001\u00048piB\u0013v\nV#D)\u0016#\u0015!\u00048piB\u0013v\nV#D)\u0016#\u0005%\u0001\u0005BY24E.Y4t+\t\u00119n\u0004\u0002\u0003Zz\tq@A\u0005BY24E.Y4tA\u0005a\u0001+Y2lC\u001e,g\t\\1hgV\u0011!\u0011]\b\u0003\u0005Gl2\u0001E!!\u00035\u0001\u0016mY6bO\u00164E.Y4tA\u0005YQj\u001c3vY\u00164E.Y4t\u00031iu\u000eZ;mK\u001ac\u0017mZ:!\u00035)\u0005\u0010\u001d7jG&$h\t\\1hgV\u0011!q^\b\u0003\u0005ctr\u0001\u0001A\u0001\u0001\u0013qq&\u0001\bFqBd\u0017nY5u\r2\fwm\u001d\u0011\u0002\u0017\t\u0013\u0018\u000eZ4f\r2\fwm]\u000b\u0003\u0005s|!Aa?\u001f\r\u0011\u0001A\u0001\u0001\u0001\u0001\u00031\u0011%/\u001b3hK\u001ac\u0017mZ:!\u0003U\u0011%/\u001b3hK\u0006sG\r\u0015:jm\u0006$XM\u00127bON,\"aa\u0001\u0010\u0005\r\u0015aD\u0002\u0003\u0001\t\u0001\u0001A!\u0001\fCe&$w-Z!oIB\u0013\u0018N^1uK\u001ac\u0017mZ:!\u00039\u0001&/\u001b8uC\ndWM\u00127bON,\"a!\u0004\u0010\u0005\r=a\u0004\u0003\u0005\u0005K\u0004iL^d\u0018\u0002\u001fA\u0013\u0018N\u001c;bE2,g\t\\1hg\u0002\n!BR5fY\u00124E.Y4t+\t\u00199b\u0004\u0002\u0004\u001ay1!\u0001IQ\u0001\"\u0001\n1BR5fY\u00124E.Y4tA\u0005Yq)\u001a;uKJ4E.Y4t\u000319U\r\u001e;fe\u001ac\u0017mZ:!\u0003-\u0019V\r\u001e;fe\u001ac\u0017mZ:\u0002\u0019M+G\u000f^3s\r2\fwm\u001d\u0011\u0002%\u0011+g-Y;mi\u001e+G\u000f^3s\r2\fwm]\u000b\u0003\u0007Sy!aa\u000b\u001e\t\u0001\u0002\u0001!J\u0001\u0014\t\u00164\u0017-\u001e7u\u000f\u0016$H/\u001a:GY\u0006<7\u000fI\u0001\u0014-\u0006dW/\u001a)be\u0006lW\r^3s\r2\fwm]\u000b\u0003\u0007gy!a!\u000e\u001e\t\t\t'\u0001A\u0001\u0015-\u0006dW/\u001a)be\u0006lW\r^3s\r2\fwm\u001d\u0011\u0002#\t+\u0017M\u001c)s_B,'\u000f^=GY\u0006<7/\u0006\u0002\u0004>=\u00111qH\u000f\u0005\u0001\u0001\u0005!#\u0001\nCK\u0006t\u0007K]8qKJ$\u0018P\u00127bON\u0004\u0013!\u0004,be&\fgnY3GY\u0006<7/\u0006\u0002\u0004H=\u00111\u0011J\u000f\u0004\u0007\u0001\u0001\u0011A\u0004,be&\fgnY3GY\u0006<7\u000fI\u0001\f\u0007>t7\u000f\u001e:GY\u0006<7/\u0006\u0002\u0004R=\u001111K\u000f\u0004!\u0001\u0001\u0011\u0001D\"p]N$(O\u00127bON\u0004\u0013AE'pIVdW\rV8DY\u0006\u001c8O\u00127bON,\"aa\u0017\u0010\u0005\ruSd\u0001\u001dJK\u0005\u0019Rj\u001c3vY\u0016$vn\u00117bgN4E.Y4tA\u0005ya+\u00197jI\u0006c\u0017.Y:GY\u0006<7/\u0006\u0002\u0004f=\u00111q\r\u0010\u0007\u0003!\u0001\u0004\u0001\u0001\u0001\u0002!Y\u000bG.\u001b3BY&\f7O\u00127bON\u0004\u0013a\u0004$mC\u001e\u001chj\u001c;QS\u000e\\G.\u001a3\u0016\u0005\r=tBAB9=\u0019\u0001r\u0019\u0001\u0001\u0001\u0001\u0005\u0001b\t\\1hg:{G\u000fU5dW2,G\rI\u0001\r!&\u001c7\u000e\\3e\r2\fwm]\u0001\u000e!&\u001c7\u000e\\3e\r2\fwm\u001d\u0011\u0002)Q{\u0007\u000fT3wK2\u0004\u0016nY6mK\u00124E.Y4t\u0003U!v\u000e\u001d'fm\u0016d\u0007+[2lY\u0016$g\t\\1hg\u0002\n\u0011\u0004]1sC64E.Y4t)>$UMZ1vYR<U\r\u001e;feR!!QYBA\u0011\u001d\u0019\u0019I\u001da\u0001\u0005\u000b\f!\u0002]1sC64E.Y4t\u0003-9W\r\u001e;fe\u001ac\u0017mZ:\u0015\t\t\u00157\u0011\u0012\u0005\b\u0007\u0017\u001b\b\u0019\u0001Bc\u0003)1\u0017.\u001a7e\r2\fwm]\u0001\fg\u0016$H/\u001a:GY\u0006<7\u000f\u0006\u0003\u0003F\u000eE\u0005bBBFi\u0002\u0007!QY\u0001\r\u00136\u0003F*S\"J)~\u00036\nT\u000b\u0003\u0007/{!a!'\u001e\u0003\u0005\tQ\"S'Q\u0019&\u001b\u0015\nV0Q\u00172\u0003\u0013!\u0003$J\u001d\u0006cu\fU&M+\t\u0019\tk\u0004\u0002\u0004$v\t!!\u0001\u0006G\u0013:\u000bEj\u0018)L\u0019\u0002\n1\u0002\u0015*J-\u0006#Vi\u0018)L\u0019V\u001111V\b\u0003\u0007[k\u0012\u0001B\u0001\r!JKe+\u0011+F?B[E\nI\u0001\u000e!J{E+R\"U\u000b\u0012{\u0006k\u0013'\u0016\u0005\rUvBAB\\;\u0005A\u0011A\u0004)S\u001fR+5\tV#E?B[E\nI\u0001\u000b'\u0016\u000bE*\u0012#`!.cUCAB`\u001f\t\u0019\t-H\u0001\u0011\u0003-\u0019V)\u0011'F\t~\u00036\n\u0014\u0011\u0002\u0019=3VI\u0015*J\t\u0016{\u0006k\u0013'\u0016\u0005\r%wBABf;\u0005\u0001\u0013!D(W\u000bJ\u0013\u0016\nR#`!.c\u0005%\u0001\u0005D\u0003N+u\fU&M\u0003%\u0019\u0015iU#`!.c\u0005%\u0001\u0007B\u0005N#&+Q\"U?B[E*\u0006\u0002\u0004X>\u00111\u0011\\\u000f\u0003\u0001\u0001\rQ\"\u0011\"T)J\u000b5\tV0Q\u00172\u0003\u0013\u0001\u0004#F\r\u0016\u0013&+\u0012#`!.c\u0015!\u0004#F\r\u0016\u0013&+\u0012#`!.c\u0005%\u0001\u0006N\u000bRCu\nR0Q\u00172+\"a!:\u0010\u0005\r\u001dXD\u0001\u0002\u0001\u0003-iU\t\u0016%P\t~\u00036\n\u0014\u0011\u0002\u00155{E)\u0016'F?B[E*\u0006\u0002\u0004p>\u00111\u0011_\u000f\u0003\t\u0001\t1\"T(E+2+u\fU&MA\u0005i\u0011J\u0014+F%\u001a\u000b5)R0Q\u00172+\"a!?\u0010\u0005\rmXD\u0001\u0005\u0001\u00039Ie\nV#S\r\u0006\u001bUi\u0018)L\u0019\u0002\n\u0001\u0002U&M?6\u000b5kS\u000b\u0003\t\u0007y!\u0001\"\u0002\u001e\u0005=y !\u0003)L\u0019~k\u0015iU&!\u0003a\u0011\u0018m\u001e)jG.dW\rZ\"peJ,7\u000f]8oI\u0016t7-Z\u000b\u0003\t\u001b\u0001bAa2\u0005\u0010\u0011M\u0011\u0002\u0002C\t\u0003G\u0012Q!\u0011:sCf\u0004\u0002Ba2\u0005\u0016\t\u0015'QY\u0005\u0005\t/\t\u0019G\u0001\u0004UkBdWMM\u0001\u000f[\u0006\u0004\b/\u001a3SC^4E.Y4t+\t!i\u0002\u0005\u0004\u0003H\u0012=!QY\u0001\u0010[\u0006\u0004\b/\u001a3SC^4E.Y4tA\u0005\u0011R.\u00199qK\u0012\u0004\u0016nY6mK\u00124E.Y4t\u0003Mi\u0017\r\u001d9fIBK7m\u001b7fI\u001ac\u0017mZ:!\u0005!i\u0015\r\u001d$mC\u001e\u001c8CBA\u0015\tS!y\u0003\u0005\u0003\u0003H\u0012-\u0012\u0002\u0002C\u0017\u0003G\u0012a!\u00118z%\u00164\u0007\u0003\u0003Bd\tc\u0011)M!2\n\t\u0011M\u00121\r\u0002\n\rVt7\r^5p]F\nAA\u001a:p[\u0006\u0011Ao\u001c\u000b\u0007\tw!y\u0004\"\u0011\u0011\t\u0011u\u0012\u0011F\u0007\u0002\u0001!AAQGA\u0018\u0001\u0004!i\u0002\u0003\u0005\u00058\u0005=\u0002\u0019\u0001C\u000f\u0003\u001d1'o\\7TKR\f\u0001B\u001a:p[N+G\u000fI\u0001\u0006CB\u0004H.\u001f\u000b\u0005\u0005\u000b$Y\u0005\u0003\u0005\u0005N\u0005U\u0002\u0019\u0001Bc\u0003\u00151G.Y4t\u0003E\u0011\u0018m\u001e+p!&\u001c7\u000e\\3e\r2\fwm]\u000b\u0003\t_\t!C]1x)>\u0004\u0016nY6mK\u00124E.Y4tA\u0005\t\u0002/[2lY\u0016$Gk\u001c*bo\u001ac\u0017mZ:\u0002%AL7m\u001b7fIR{'+Y<GY\u0006<7\u000fI\u0001\rM2\fw\rV8TiJLgn\u001a\u000b\u0005\t;\"\u0019\b\u0005\u0003\u0005`\u00115d\u0002\u0002C1\tS\u0002B\u0001b\u0019\u0002d5\u0011AQ\r\u0006\u0005\tO\n9'\u0001\u0004=e>|GOP\u0005\u0005\tW\n\u0019'\u0001\u0004Qe\u0016$WMZ\u0005\u0005\t_\"\tH\u0001\u0004TiJLgn\u001a\u0006\u0005\tW\n\u0019\u0007\u0003\u0005\u0005v\u0005}\u0002\u0019\u0001Bc\u0003\u00111G.Y4)\t\u0005}B\u0011\u0010\t\u0005\tw\"\t)\u0004\u0002\u0005~)!AqPA2\u0003)\tgN\\8uCRLwN\\\u0005\u0005\t\u0007#iH\u0001\u0004to&$8\r[\u0001\rC\u000e\u001cWm]:TiJLgn\u001a\u000b\u0007\t\u0013#9\n\"'\u0011\t\u0011-EQS\u0007\u0003\t\u001bSA\u0001b$\u0005\u0012\u0006!A.\u00198h\u0015\t!\u0019*\u0001\u0003kCZ\f\u0017\u0002\u0002C8\t\u001bC\u0001\u0002\"\u0014\u0002B\u0001\u0007!Q\u0019\u0005\t\t7\u000b\t\u00051\u0001\u0005^\u0005i\u0001O]5wCR,w+\u001b;iS:\fQB\u001a7bON$vn\u0015;sS:<GC\u0002C/\tC#\u0019\u000b\u0003\u0005\u0005N\u0005\r\u0003\u0019\u0001Bc\u0011!!Y*a\u0011A\u0002\u0011u\u0003\u0006CA\"\tO#i\u000b\"-\u0011\t\t\u001dG\u0011V\u0005\u0005\tW\u000b\u0019G\u0001\u0006eKB\u0014XmY1uK\u0012\f#\u0001b,\u0002UU\u001cX\r\t4mC\u001e\u001cFO]5oO\u0002zg\u000e\t;iK\u00022G.Y4.G\u0006\u0014(/_5oO\u0002jW-\u001c2fe\u0006\u0012A1W\u0001\u0007e9\n\u0004G\f\u0019\u0015\t\u0011uCq\u0017\u0005\t\t\u001b\n)\u00051\u0001\u0003F\"B\u0011Q\tCT\t[#\t,\u0001\bNCb\u0014\u0015\u000e\u001e)pg&$\u0018n\u001c8\u0016\u0005\u0011}vB\u0001Ca;\u0005q\u0014aD'bq\nKG\u000fU8tSRLwN\u001c\u0011\u0002!AL7m\u001b7fI2K7\u000f^(sI\u0016\u0014XC\u0001Ce!\u0019!Y\r\"5\u0003F:!!q\u0019Cg\u0013\u0011!y-a\u0019\u0002\u000fA\f7m[1hK&!A1\u001bCk\u0005\u0011a\u0015n\u001d;\u000b\t\u0011=\u00171M\u0001\u0012a&\u001c7\u000e\\3e\u0019&\u001cHo\u0014:eKJ\u0004\u0013a\u0005:bo\u001ac\u0017m\u001a)jG.dW\rZ(sI\u0016\u0014\u0018\u0001\u0006:bo\u001ac\u0017m\u001a)jG.dW\rZ(sI\u0016\u0014\b%A\u0003GY\u0006<7\u000f\u0005\u0003\u0002n\u0005U3\u0003BA+\u0003o\"\"\u0001b8")
public class Flags
extends ModifierFlags {
    private final long notPRIVATE;
    private final long notPROTECTED;
    private final long GetterFlags;
    private final long SetterFlags;
    private final long PickledFlags;
    private final long TopLevelPickledFlags;
    private final long[] mappedRawFlags;
    private final long[] mappedPickledFlags;
    private final Function1<Object, Object> rawToPickledFlags;
    private final Function1<Object, Object> pickledToRawFlags;
    private final List<Object> pickledListOrder;
    private final long[] rawFlagPickledOrder;

    public final int METHOD() {
        return 64;
    }

    public final int MODULE() {
        return 256;
    }

    public final int PACKAGE() {
        return 16384;
    }

    public final int CAPTURED() {
        return 65536;
    }

    public final int LABEL() {
        return 131072;
    }

    public final int INCONSTRUCTOR() {
        return 131072;
    }

    public final int SYNTHETIC() {
        return 0x200000;
    }

    public final int STABLE() {
        return 0x400000;
    }

    public final int BRIDGE() {
        return 0x4000000;
    }

    public final int ACCESSOR() {
        return 0x8000000;
    }

    public final int SUPERACCESSOR() {
        return 0x10000000;
    }

    public final int MODULEVAR() {
        return 0x40000000;
    }

    public final long IS_ERROR() {
        return 0x100000000L;
    }

    public final long OVERLOADED() {
        return 0x200000000L;
    }

    public final long LIFTED() {
        return 0x400000000L;
    }

    public final long MIXEDIN() {
        return 0x800000000L;
    }

    public final long EXISTENTIAL() {
        return 0x800000000L;
    }

    public final long EXPANDEDNAME() {
        return 0x1000000000L;
    }

    public final long TRANS_FLAG() {
        return 0x4000000000L;
    }

    public final long LOCKED() {
        return 0x8000000000L;
    }

    public final long SPECIALIZED() {
        return 0x10000000000L;
    }

    public final long VBRIDGE() {
        return 0x40000000000L;
    }

    public final long VARARGS() {
        return 0x80000000000L;
    }

    public final long TRIEDCOOKING() {
        return 0x100000000000L;
    }

    public final long SYNCHRONIZED() {
        return 0x200000000000L;
    }

    public final long SYNTHESIZE_IMPL_IN_SUBCLASS() {
        return 0x4000000000000L;
    }

    public final long NEEDS_TREES() {
        return 0x800000000000000L;
    }

    public final long InitialFlags() {
        return 0x7FFFFFFFFFFFFL;
    }

    public final long LateFlags() {
        return 0xF8000000000000L;
    }

    public final long AntiFlags() {
        return 0x700000000000000L;
    }

    public final int LateShift() {
        return 47;
    }

    public final int AntiShift() {
        return 56;
    }

    public final long PhaseIndependentFlags() {
        return -574208952489738744L;
    }

    public final long OverloadedFlagsMask() {
        return 34393489408L;
    }

    public final long notPRIVATE() {
        return this.notPRIVATE;
    }

    public final long notPROTECTED() {
        return this.notPROTECTED;
    }

    public final long AllFlags() {
        return -1L;
    }

    public final int PackageFlags() {
        return 1065248;
    }

    public final int ModuleFlags() {
        return 256;
    }

    public final long ExplicitFlags() {
        return 140739636104751L;
    }

    public final long BridgeFlags() {
        return 0x40004000000L;
    }

    public final long BridgeAndPrivateFlags() {
        return 0x40004000004L;
    }

    public final long PrintableFlags() {
        return 577838443559423535L;
    }

    public final long FieldFlags() {
        return 2339171733536L;
    }

    public final long GetterFlags() {
        return this.GetterFlags;
    }

    public final long SetterFlags() {
        return this.SetterFlags;
    }

    public final int DefaultGetterFlags() {
        return 0x20000025;
    }

    public final int ValueParameterFlags() {
        return 39911936;
    }

    public final int BeanPropertyFlags() {
        return 8388626;
    }

    public final int VarianceFlags() {
        return 196608;
    }

    public final int ConstrFlags() {
        return 0x100000;
    }

    public final int ModuleToClassFlags() {
        return 3688741;
    }

    public final long ValidAliasFlags() {
        return 1134676672512L;
    }

    public final long FlagsNotPickled() {
        return 18446884536320L;
    }

    public final long PickledFlags() {
        return this.PickledFlags;
    }

    public final long TopLevelPickledFlags() {
        return this.TopLevelPickledFlags;
    }

    public long paramFlagsToDefaultGetter(long paramFlags) {
        return paramFlags & 0x20000025L | 0x200000L | 0x40L | 0x2000000L;
    }

    public long getterFlags(long fieldFlags) {
        return 0x8000000L + ((fieldFlags & 0x1000L) != 0L ? fieldFlags & (long)(~4096) & (0x2000000000L ^ 0xFFFFFFFFFFFFFFFFL) : fieldFlags & (0x2000000000L ^ 0xFFFFFFFFFFFFFFFFL) | 0x400000L);
    }

    public long setterFlags(long fieldFlags) {
        return this.getterFlags(fieldFlags) & (long)(~0x400000) & (long)(~0x1000000);
    }

    private final int IMPLICIT_PKL() {
        return 1;
    }

    private final int FINAL_PKL() {
        return 2;
    }

    private final int PRIVATE_PKL() {
        return 4;
    }

    private final int PROTECTED_PKL() {
        return 8;
    }

    private final int SEALED_PKL() {
        return 16;
    }

    private final int OVERRIDE_PKL() {
        return 32;
    }

    private final int CASE_PKL() {
        return 64;
    }

    private final int ABSTRACT_PKL() {
        return 128;
    }

    private final int DEFERRED_PKL() {
        return 256;
    }

    private final int METHOD_PKL() {
        return 512;
    }

    private final int MODULE_PKL() {
        return 1024;
    }

    private final int INTERFACE_PKL() {
        return 2048;
    }

    private final int PKL_MASK() {
        return 4095;
    }

    private Tuple2<Object, Object>[] rawPickledCorrespondence() {
        return (Tuple2[])((Object[])new Tuple2[]{new Tuple2$mcJJ$sp(64L, 512L), new Tuple2$mcJJ$sp(4L, 4L), new Tuple2$mcJJ$sp(32L, 2L), new Tuple2$mcJJ$sp(1L, 8L), new Tuple2$mcJJ$sp(2048L, 64L), new Tuple2$mcJJ$sp(16L, 256L), new Tuple2$mcJJ$sp(256L, 1024L), new Tuple2$mcJJ$sp(2L, 32L), new Tuple2$mcJJ$sp(128L, 2048L), new Tuple2$mcJJ$sp(512L, 1L), new Tuple2$mcJJ$sp(1024L, 16L), new Tuple2$mcJJ$sp(8L, 128L)});
    }

    private long[] mappedRawFlags() {
        return this.mappedRawFlags;
    }

    private long[] mappedPickledFlags() {
        return this.mappedPickledFlags;
    }

    public Function1<Object, Object> rawToPickledFlags() {
        return this.rawToPickledFlags;
    }

    public Function1<Object, Object> pickledToRawFlags() {
        return this.pickledToRawFlags;
    }

    @Override
    public String flagToString(long flag) {
        String string = 1L == flag ? "protected" : (2L == flag ? "override" : (4L == flag ? "private" : (8L == flag ? "abstract" : (16L == flag ? "<deferred>" : (32L == flag ? "final" : (64L == flag ? "<method>" : (128L == flag ? "<interface>" : (256L == flag ? "<module>" : (512L == flag ? "implicit" : (1024L == flag ? "sealed" : (2048L == flag ? "case" : (4096L == flag ? "<mutable>" : (8192L == flag ? "<param>" : (16384L == flag ? "<package>" : (32768L == flag ? "<macro>" : (65536L == flag ? "<bynameparam/captured/covariant>" : (131072L == flag ? "<contravariant/inconstructor/label>" : (262144L == flag ? "absoverride" : (524288L == flag ? "<local>" : (0x100000L == flag ? "<java>" : (0x200000L == flag ? "<synthetic>" : (0x400000L == flag ? "<stable>" : (0x800000L == flag ? "<static>" : (0x1000000L == flag ? "<caseaccessor>" : (0x2000000L == flag ? "<defaultparam/trait>" : (0x4000000L == flag ? "<bridge>" : (0x8000000L == flag ? "<accessor>" : (0x10000000L == flag ? "<superaccessor>" : (0x20000000L == flag ? "<paramaccessor>" : (0x40000000L == flag ? "<modulevar>" : (0x80000000L == flag ? "lazy" : (0x100000000L == flag ? "<is_error>" : (0x200000000L == flag ? "<overloaded>" : (0x400000000L == flag ? "<lifted>" : (0x800000000L == flag ? "<existential/mixedin>" : (0x1000000000L == flag ? "<expandedname>" : (0x2000000000L == flag ? "<presuper>" : (0x4000000000L == flag ? "<trans_flag>" : (0x8000000000L == flag ? "<locked>" : (0x10000000000L == flag ? "<specialized>" : (0x20000000000L == flag ? "<defaultinit>" : (0x40000000000L == flag ? "<vbridge>" : (0x80000000000L == flag ? "<varargs>" : (0x100000000000L == flag ? "<triedcooking>" : (0x200000000000L == flag ? "<synchronized>" : (0x400000000000L == flag ? "<artifact>" : (0x800000000000L == flag ? "<defaultmethod>" : (0x1000000000000L == flag ? "<enum>" : (0x2000000000000L == flag ? "<annotation>" : (0x4000000000000L == flag ? "<sub_synth>" : (0x8000000000000L == flag ? "<latedeferred>" : (0x10000000000000L == flag ? "<latefinal>" : (0x20000000000000L == flag ? "<latemethod>" : (0x40000000000000L == flag ? "" : (0x80000000000000L == flag ? "<latemodule>" : (this.notPROTECTED() == flag ? "<notprotected>" : (0x200000000000000L == flag ? "<notoverride>" : (this.notPRIVATE() == flag ? "<notprivate>" : (0x800000000000000L == flag ? "<needs_trees>" : (0x1000000000000000L == flag ? "" : (0x2000000000000000L == flag ? "" : (0x4000000000000000L == flag ? "" : (Long.MIN_VALUE == flag ? "" : "")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
        return string;
    }

    private String accessString(long flags, String privateWithin) {
        String string = privateWithin;
        String string2 = "";
        if (string != null && string.equals(string2)) {
            if ((flags & 0x80004L) == 524292L) {
                return "private[this]";
            }
            if ((flags & 0x80001L) == 524289L) {
                return "protected[this]";
            }
            if ((flags & 4L) != 0L) {
                return "private";
            }
            if ((flags & 1L) != 0L) {
                return "protected";
            }
            return "";
        }
        if ((flags & 1L) != 0L) {
            return new StringBuilder(11).append("protected[").append(privateWithin).append("]").toString();
        }
        return new StringBuilder(9).append("private[").append(privateWithin).append("]").toString();
    }

    public String flagsToString(long flags, String privateWithin) {
        String access = this.accessString(flags, privateWithin);
        String nonAccess = this.flagsToString(flags & (long)(~524293));
        return ((TraversableOnce)new $colon$colon<Nothing$>((Nothing$)((Object)nonAccess), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)access), Nil$.MODULE$)).filterImpl((Function1<String, Object> & java.io.Serializable & Serializable)x$6 -> BoxesRunTime.boxToBoolean(Flags.$anonfun$flagsToString$1(x$6)), true)).mkString(" ");
    }

    public String flagsToString(long flags) {
        if (flags == 0L) {
            return "";
        }
        scala.collection.mutable.StringBuilder sb = null;
        for (int i = 0; i <= 62; ++i) {
            String s;
            long mask = this.rawFlagPickledOrder()[i];
            if ((flags & mask) == 0L || (s = this.flagToString(mask)).length() <= 0) continue;
            if (sb == null) {
                sb = new scala.collection.mutable.StringBuilder().append(s);
                continue;
            }
            if (sb.length() == 0) {
                sb.append(s);
                continue;
            }
            sb.append(" ").append(s);
        }
        if (sb == null) {
            return "";
        }
        return sb.toString();
    }

    public final int MaxBitPosition() {
        return 62;
    }

    public final List<Object> pickledListOrder() {
        return this.pickledListOrder;
    }

    public final long[] rawFlagPickledOrder() {
        return this.rawFlagPickledOrder;
    }

    public static final /* synthetic */ boolean $anonfun$flagsToString$1(String x$6) {
        String string = x$6;
        String string2 = "";
        return string != null && string.equals(string2);
    }

    /*
     * WARNING - void declaration
     */
    public Flags() {
        void map_bf;
        void map_f;
        void assert_assertion;
        Predef$.MODULE$.assert(-574208952489738744L == (0xFFFFFFFFFFFFFFFFL & (0xF8000000000000L ^ 0xFFFFFFFFFFFFFFFFL) & (0x700000000000000L ^ 0xFFFFFFFFFFFFFFFFL) & (0x1F0L ^ 0xFFFFFFFFFFFFFFFFL) & (7L ^ 0xFFFFFFFFFFFFFFFFL)));
        this.notPRIVATE = 4L << 56;
        this.notPROTECTED = 1L << 56;
        this.GetterFlags = 0x2000001000L ^ 0xFFFFFFFFFFFFFFFFL;
        this.SetterFlags = 0x2001401200L ^ 0xFFFFFFFFFFFFFFFFL;
        boolean bl = true;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (assert_assertion == false) {
            throw new AssertionError((Object)new StringBuilder(18).append("assertion failed: ").append((Object)this.flagsToString(0L)).toString());
        }
        this.PickledFlags = 0x7FFFFFFFFFFFFL & (0x10C700000000L ^ 0xFFFFFFFFFFFFFFFFL) | this.notPRIVATE();
        this.TopLevelPickledFlags = this.PickledFlags() & (0x800006140L ^ 0xFFFFFFFFFFFFFFFFL);
        this.mappedRawFlags = (long[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.rawPickledCorrespondence())), (Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToLong(x$1._1$mcJ$sp()), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Long()));
        this.mappedPickledFlags = (long[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.rawPickledCorrespondence())), (Function1<Tuple2, Object> & java.io.Serializable & Serializable)x$2 -> BoxesRunTime.boxToLong(x$2._2$mcJ$sp()), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Long()));
        this.rawToPickledFlags = new MapFlags(this, this.mappedRawFlags(), this.mappedPickledFlags());
        this.pickledToRawFlags = new MapFlags(this, this.mappedPickledFlags(), this.mappedRawFlags());
        int n = 0;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        Range.Inclusive inclusive = RichInt$.MODULE$.to$extension0(n, 62);
        CanBuildFrom canBuildFrom = IndexedSeq$.MODULE$.canBuildFrom();
        JFunction1$mcJI$sp & Serializable intersect = (JFunction1$mcJI$sp & Serializable)x$7 -> 1L << x$7;
        if (inclusive == null) {
            throw null;
        }
        IndexedSeq all = (IndexedSeq)TraversableLike.map$(inclusive, (Function1)map_f, (CanBuildFrom)map_bf);
        long[] front = (long[])TraversableLike.map$(new ArrayOps.ofLong(Predef$.MODULE$.longArrayOps(this.mappedRawFlags())), (JFunction1$mcJJ$sp & Serializable)x$8 -> x$8, Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.Long()));
        this.pickledListOrder = new ArrayOps.ofLong(Predef$.MODULE$.longArrayOps(front)).toList().$plus$plus((GenTraversableOnce)all.filterNot((JFunction1$mcZJ$sp & Serializable)x$9 -> new ArrayOps.ofLong(Predef$.MODULE$.longArrayOps(front)).contains(BoxesRunTime.boxToLong(x$9))), List$.MODULE$.canBuildFrom());
        this.rawFlagPickledOrder = (long[])this.pickledListOrder().toArray(ClassTag$.MODULE$.Long());
    }

    private class MapFlags
    implements Function1$mcJJ$sp {
        public final long[] scala$reflect$internal$Flags$MapFlags$$from;
        public final long[] scala$reflect$internal$Flags$MapFlags$$to;
        private final long fromSet;
        public final /* synthetic */ Flags $outer;

        @Override
        public boolean apply$mcZD$sp(double v1) {
            return Function1.apply$mcZD$sp$(this, v1);
        }

        @Override
        public double apply$mcDD$sp(double v1) {
            return Function1.apply$mcDD$sp$(this, v1);
        }

        @Override
        public float apply$mcFD$sp(double v1) {
            return Function1.apply$mcFD$sp$(this, v1);
        }

        @Override
        public int apply$mcID$sp(double v1) {
            return Function1.apply$mcID$sp$(this, v1);
        }

        @Override
        public long apply$mcJD$sp(double v1) {
            return Function1.apply$mcJD$sp$(this, v1);
        }

        @Override
        public void apply$mcVD$sp(double v1) {
            Function1.apply$mcVD$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZF$sp(float v1) {
            return Function1.apply$mcZF$sp$(this, v1);
        }

        @Override
        public double apply$mcDF$sp(float v1) {
            return Function1.apply$mcDF$sp$(this, v1);
        }

        @Override
        public float apply$mcFF$sp(float v1) {
            return Function1.apply$mcFF$sp$(this, v1);
        }

        @Override
        public int apply$mcIF$sp(float v1) {
            return Function1.apply$mcIF$sp$(this, v1);
        }

        @Override
        public long apply$mcJF$sp(float v1) {
            return Function1.apply$mcJF$sp$(this, v1);
        }

        @Override
        public void apply$mcVF$sp(float v1) {
            Function1.apply$mcVF$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZI$sp(int v1) {
            return Function1.apply$mcZI$sp$(this, v1);
        }

        @Override
        public double apply$mcDI$sp(int v1) {
            return Function1.apply$mcDI$sp$(this, v1);
        }

        @Override
        public float apply$mcFI$sp(int v1) {
            return Function1.apply$mcFI$sp$(this, v1);
        }

        @Override
        public int apply$mcII$sp(int v1) {
            return Function1.apply$mcII$sp$(this, v1);
        }

        @Override
        public long apply$mcJI$sp(int v1) {
            return Function1.apply$mcJI$sp$(this, v1);
        }

        @Override
        public void apply$mcVI$sp(int v1) {
            Function1.apply$mcVI$sp$(this, v1);
        }

        @Override
        public boolean apply$mcZJ$sp(long v1) {
            return Function1.apply$mcZJ$sp$(this, v1);
        }

        @Override
        public double apply$mcDJ$sp(long v1) {
            return Function1.apply$mcDJ$sp$(this, v1);
        }

        @Override
        public float apply$mcFJ$sp(long v1) {
            return Function1.apply$mcFJ$sp$(this, v1);
        }

        @Override
        public int apply$mcIJ$sp(long v1) {
            return Function1.apply$mcIJ$sp$(this, v1);
        }

        @Override
        public void apply$mcVJ$sp(long v1) {
            Function1.apply$mcVJ$sp$(this, v1);
        }

        @Override
        public <A> Function1<A, Object> compose(Function1<A, Object> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public <A> Function1<Object, A> andThen(Function1<Object, A> g) {
            return Function1.andThen$(this, g);
        }

        @Override
        public String toString() {
            return Function1.toString$(this);
        }

        public long fromSet() {
            return this.fromSet;
        }

        @Override
        public long apply(long flags) {
            return this.apply$mcJJ$sp(flags);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public long apply$mcJJ$sp(long flags) {
            void var3_2;
            long result2 = flags & (this.fromSet() ^ 0xFFFFFFFFFFFFFFFFL);
            long tobeMapped = flags & this.fromSet();
            int i = 0;
            while (tobeMapped != 0L) {
                if ((tobeMapped & this.scala$reflect$internal$Flags$MapFlags$$from[i]) != 0L) {
                    result2 |= this.scala$reflect$internal$Flags$MapFlags$$to[i];
                    tobeMapped &= this.scala$reflect$internal$Flags$MapFlags$$from[i] ^ 0xFFFFFFFFFFFFFFFFL;
                }
                ++i;
            }
            return (long)var3_2;
        }

        public /* synthetic */ Flags scala$reflect$internal$Flags$MapFlags$$$outer() {
            return this.$outer;
        }

        public MapFlags(Flags $outer, long[] from, long[] to) {
            this.scala$reflect$internal$Flags$MapFlags$$from = from;
            this.scala$reflect$internal$Flags$MapFlags$$to = to;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            long l = 0L;
            this.fromSet = BoxesRunTime.unboxToLong(new ArrayOps.ofLong(Predef$.MODULE$.longArrayOps(from)).foldLeft(BoxesRunTime.boxToLong(l), (JFunction2$mcJJJ$sp & Serializable)(x$4, x$5) -> x$4 | x$5));
        }
    }
}

