/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.GenIterable;
import scala.collection.GenSet;
import scala.collection.GenSetLike;
import scala.collection.GenTraversable;
import scala.collection.GenTraversableOnce;
import scala.collection.Iterable;
import scala.collection.IterableLike;
import scala.collection.IterableView;
import scala.collection.Iterator;
import scala.collection.Parallel;
import scala.collection.Parallelizable;
import scala.collection.Seq;
import scala.collection.Set;
import scala.collection.SetLike;
import scala.collection.SortedSetLike;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.generic.CanBuildFrom;
import scala.collection.generic.FilterMonadic;
import scala.collection.generic.GenericCompanion;
import scala.collection.generic.GenericSetTemplate;
import scala.collection.generic.GenericTraversableTemplate;
import scala.collection.generic.Growable;
import scala.collection.generic.Sorted;
import scala.collection.generic.SortedSetFactory;
import scala.collection.generic.Subtractable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.RedBlackTree;
import scala.collection.immutable.RedBlackTree$;
import scala.collection.immutable.SortedSet;
import scala.collection.immutable.SortedSet$;
import scala.collection.immutable.Stream;
import scala.collection.immutable.Traversable;
import scala.collection.immutable.TreeSet$;
import scala.collection.immutable.Vector;
import scala.collection.mutable.Buffer;
import scala.collection.mutable.Builder;
import scala.collection.mutable.StringBuilder;
import scala.collection.package;
import scala.collection.parallel.Combiner;
import scala.collection.parallel.immutable.ParSet;
import scala.math.Numeric;
import scala.math.Ordering;
import scala.math.package$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\rer!B\"E\u0011\u0003Ye!B'E\u0011\u0003q\u0005bBA\u0007\u0003\u0011\u0005!1\u0017\u0005\b\u0005k\u000bA1\u0001B\\\u0011\u001d\u0011\t.\u0001C!\u0005'Dq!!6\u0002\t\u0003\u0011\u0019O\u0002\u0004\u0003r\u0006!!1\u001f\u0005\ny\u001a\u0011)\u0019!C\u0002\u0005\u007fD!\"a\u0003\u0007\u0005\u0003\u0005\u000b\u0011BB\u0001\u0011\u001d\tiA\u0002C\u0001\u0007\u0007)Q!\u001f\u0004\u0001\u0007\u001bAqA\u001d\u0004!B\u0013\u0019y\u0001C\u0004\u0004\u0014\u0019!\te!\u0006\t\u000f\rea\u0001\"\u0011\u0004\u001c!91q\u0005\u0004\u0005B\r%\u0002bBB\u0016\r\u0011\u00053Q\u0006\u0005\n\u0007_\t\u0011\u0011!C\u0005\u0007c1A!\u0014#\u0003-\"I!/\u0005BC\u0002\u0013\u0005Ai\u001d\u0005\twF\u0011\t\u0011)A\u0005i\"AA0\u0005BC\u0002\u0013\rQ\u0010C\u0005\u0002\fE\u0011\t\u0011)A\u0005}\"A\u0011QB\t\u0005\u0002\u0011\u000by\u0001C\u0004\u0002\u0018E!\t%!\u0007\t\u000f\u0005-\u0012\u0003\"\u0011\u0002.!9\u0011QG\t\u0005B\u0005]\u0002bBA\u001d#\u0011\u0005\u00131\b\u0005\b\u0003\u0007\nB\u0011IA\u001c\u0011\u001d\t)%\u0005C!\u0003wAq!a\u0012\u0012\t\u0003\nI\u0005C\u0004\u0002LE!\t%!\u0013\t\u000f\u00055\u0013\u0003\"\u0011\u0002P!9\u0011\u0011M\t\u0005B\u0005\r\u0004bBA8#\u0011\u0005\u0013\u0011\u000f\u0005\b\u0003o\nB\u0011IA=\u0011\u001d\ti(\u0005C!\u0003\u007fBq!!#\u0012\t\u0003\nY\tC\u0004\u0002\u0010F!\t%!%\t\u000f\u0005U\u0015\u0003\"\u0011\u0002\u0018\"A\u0011\u0011U\t!\n\u0013\t\u0019\u000bC\u0004\u00026F!\t%a.\t\u000f\u0005m\u0016\u0003\"\u0011\u0002>\"9\u0011\u0011Y\t\u0005B\u0005\r\u0007bBA\u0007#\u0011\u0005\u0011q\u0019\u0005\b\u0003\u001b\fB\u0011BAh\u0011\u001d\t).\u0005C!\u0003\u0013Bq!a6\u0012\t\u0003\tI\u000eC\u0004\u0002`F!\t!!9\t\u000f\u0005\u0015\u0018\u0003\"\u0001\u0002h\"9\u00111^\t\u0005\u0002\u00055\bbBAy#\u0011\u0005\u00111\u001f\u0005\b\u0003w\fB\u0011IA\u007f\u0011\u001d\u0011\u0019!\u0005C!\u0005\u000bAqAa\u0007\u0012\t\u0003\u0012i\u0002C\u0004\u0003$E!\tE!\n\t\u000f\u0005\r\u0015\u0003\"\u0011\u0003,!9!qF\t\u0005B\tE\u0002bBAD#\u0011\u0005#Q\u0007\u0005\b\u0005s\tB\u0011IA\u001c\u0011\u001d\u0011Y$\u0005C!\u0003oAqA!\u0010\u0012\t\u0013\u0011y\u0004\u0003\u0005\u0003`E!\tA\u0012B1\u0011!\u00119'\u0005C\u0001\u0011\n%\u0004\u0002\u0003BE#\u0011\u0005aIa#\t\u0011\t=\u0015\u0003\"\u0011I\u0005#CqA!'\u0012\t\u0003\u0012Y\nC\u0004\u0003 F!\tE!)\u0002\u000fQ\u0013X-Z*fi*\u0011QIR\u0001\nS6lW\u000f^1cY\u0016T!a\u0012%\u0002\u0015\r|G\u000e\\3di&|gNC\u0001J\u0003\u0015\u00198-\u00197b\u0007\u0001\u0001\"\u0001T\u0001\u000e\u0003\u0011\u0013q\u0001\u0016:fKN+GoE\u0002\u0002\u001f>\u00042\u0001U*V\u001b\u0005\t&B\u0001*G\u0003\u001d9WM\\3sS\u000eL!\u0001V)\u00033%kW.\u001e;bE2,7k\u001c:uK\u0012\u001cV\r\u001e$bGR|'/\u001f\t\u0003\u0019F)\"aV1\u0014\u000bEAFL[8\u0011\u0005eSV\"\u0001%\n\u0005mC%AB!osJ+g\rE\u0002M;~K!A\u0018#\u0003\u0013M{'\u000f^3e'\u0016$\bC\u00011b\u0019\u0001!QAY\tC\u0002\r\u0014\u0011!Q\t\u0003I\u001e\u0004\"!W3\n\u0005\u0019D%a\u0002(pi\"Lgn\u001a\t\u00033\"L!!\u001b%\u0003\u0007\u0005s\u0017\u0010\u0005\u0003lY~sW\"\u0001$\n\u000554%!D*peR,GmU3u\u0019&\\W\rE\u0002M#}\u0003\"!\u00179\n\u0005ED%\u0001D*fe&\fG.\u001b>bE2,\u0017\u0001\u0002;sK\u0016,\u0012\u0001\u001e\t\u0005kb|vM\u0004\u0002Mm&\u0011q\u000fR\u0001\r%\u0016$'\t\\1dWR\u0013X-Z\u0005\u0003sj\u0014A\u0001\u0016:fK*\u0011q\u000fR\u0001\u0006iJ,W\rI\u0001\t_J$WM]5oOV\ta\u0010\u0005\u0003\u0000\u0003\u000byfbA-\u0002\u0002%\u0019\u00111\u0001%\u0002\u000fA\f7m[1hK&!\u0011qAA\u0005\u0005!y%\u000fZ3sS:<'bAA\u0002\u0011\u0006IqN\u001d3fe&tw\rI\u0001\u0007y%t\u0017\u000e\u001e \u0015\t\u0005E\u0011Q\u0003\u000b\u0004]\u0006M\u0001\"\u0002?\u0017\u0001\bq\b\"\u0002:\u0017\u0001\u0004!\u0018\u0001D:ue&tw\r\u0015:fM&DXCAA\u000e!\u0011\ti\"a\n\u000e\u0005\u0005}!\u0002BA\u0011\u0003G\tA\u0001\\1oO*\u0011\u0011QE\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002*\u0005}!AB*ue&tw-\u0001\u0003tSj,WCAA\u0018!\rI\u0016\u0011G\u0005\u0004\u0003gA%aA%oi\u0006!\u0001.Z1e+\u0005y\u0016A\u00035fC\u0012|\u0005\u000f^5p]V\u0011\u0011Q\b\t\u00053\u0006}r,C\u0002\u0002B!\u0013aa\u00149uS>t\u0017\u0001\u00027bgR\f!\u0002\\1ti>\u0003H/[8o\u0003\u0011!\u0018-\u001b7\u0016\u00039\fA!\u001b8ji\u0006\u0019Q.\u001b8\u0016\t\u0005E\u00131\f\u000b\u0004?\u0006M\u0003bBA+?\u0001\u000f\u0011qK\u0001\u0004_J$\u0007#B@\u0002\u0006\u0005e\u0003c\u00011\u0002\\\u00119\u0011QL\u0010C\u0002\u0005}#AA!2#\tyv-A\u0002nCb,B!!\u001a\u0002nQ\u0019q,a\u001a\t\u000f\u0005U\u0003\u0005q\u0001\u0002jA)q0!\u0002\u0002lA\u0019\u0001-!\u001c\u0005\u000f\u0005u\u0003E1\u0001\u0002`\u0005!AM]8q)\rq\u00171\u000f\u0005\b\u0003k\n\u0003\u0019AA\u0018\u0003\u0005q\u0017\u0001\u0002;bW\u0016$2A\\A>\u0011\u001d\t)H\ta\u0001\u0003_\tQa\u001d7jG\u0016$RA\\AA\u0003\u000bCq!a!$\u0001\u0004\ty#\u0001\u0003ge>l\u0007bBADG\u0001\u0007\u0011qF\u0001\u0006k:$\u0018\u000e\\\u0001\nIJ|\u0007OU5hQR$2A\\AG\u0011\u001d\t)\b\na\u0001\u0003_\t\u0011\u0002^1lKJKw\r\u001b;\u0015\u00079\f\u0019\nC\u0004\u0002v\u0015\u0002\r!a\f\u0002\u000fM\u0004H.\u001b;BiR!\u0011\u0011TAP!\u0015I\u00161\u00148o\u0013\r\ti\n\u0013\u0002\u0007)V\u0004H.\u001a\u001a\t\u000f\u0005Ud\u00051\u0001\u00020\u0005Q1m\\;oi^C\u0017\u000e\\3\u0015\t\u0005=\u0012Q\u0015\u0005\b\u0003O;\u0003\u0019AAU\u0003\u0005\u0001\bCB-\u0002,~\u000by+C\u0002\u0002.\"\u0013\u0011BR;oGRLwN\\\u0019\u0011\u0007e\u000b\t,C\u0002\u00024\"\u0013qAQ8pY\u0016\fg.A\u0005ee>\u0004x\u000b[5mKR\u0019a.!/\t\u000f\u0005\u001d\u0006\u00061\u0001\u0002*\u0006IA/Y6f/\"LG.\u001a\u000b\u0004]\u0006}\u0006bBATS\u0001\u0007\u0011\u0011V\u0001\u0005gB\fg\u000e\u0006\u0003\u0002\u001a\u0006\u0015\u0007bBATU\u0001\u0007\u0011\u0011\u0016\u000b\u0003\u0003\u0013$2A\\Af\u0011\u0015a8\u0006q\u0001\u007f\u00031qWm^*fi>\u00138+\u001a7g)\rq\u0017\u0011\u001b\u0005\u0007\u0003'd\u0003\u0019\u0001;\u0002\u0003Q\fQ!Z7qif\fQ\u0001\n9mkN$2A\\An\u0011\u0019\tiN\fa\u0001?\u0006!Q\r\\3n\u0003\u0019Ign]3siR\u0019a.a9\t\r\u0005uw\u00061\u0001`\u0003\u0019!S.\u001b8vgR\u0019a.!;\t\r\u0005u\u0007\u00071\u0001`\u0003!\u0019wN\u001c;bS:\u001cH\u0003BAX\u0003_Da!!82\u0001\u0004y\u0016\u0001C5uKJ\fGo\u001c:\u0016\u0005\u0005U\b\u0003B6\u0002x~K1!!?G\u0005!IE/\u001a:bi>\u0014\u0018\u0001E6fsNLE/\u001a:bi>\u0014hI]8n)\u0011\t)0a@\t\r\t\u00051\u00071\u0001`\u0003\u0015\u0019H/\u0019:u\u0003\u001d1wN]3bG\",BAa\u0002\u0003\u0018Q!!\u0011\u0002B\b!\rI&1B\u0005\u0004\u0005\u001bA%\u0001B+oSRDqA!\u00055\u0001\u0004\u0011\u0019\"A\u0001g!\u0019I\u00161V0\u0003\u0016A\u0019\u0001Ma\u0006\u0005\r\teAG1\u0001d\u0005\u0005)\u0016!\u0003:b]\u001e,\u0017*\u001c9m)\u0015q'q\u0004B\u0011\u0011\u001d\t\u0019)\u000ea\u0001\u0003{Aq!a\"6\u0001\u0004\ti$A\u0003sC:<W\rF\u0003o\u0005O\u0011I\u0003\u0003\u0004\u0002\u0004Z\u0002\ra\u0018\u0005\u0007\u0003\u000f3\u0004\u0019A0\u0015\u00079\u0014i\u0003\u0003\u0004\u0002\u0004^\u0002\raX\u0001\u0003i>$2A\u001cB\u001a\u0011\u0019\u0011y\u0003\u000fa\u0001?R\u0019aNa\u000e\t\r\u0005\u001d\u0015\b1\u0001`\u0003!1\u0017N]:u\u0017\u0016L\u0018a\u00027bgR\\U-_\u0001\bg\u0006lWm\u0011\"G)\u0011\tyK!\u0011\t\u000f\t\rC\b1\u0001\u0003F\u0005\u0011!M\u001a\u0019\t\u0005\u000f\u0012yE!\u0016\u0003\\AI\u0001K!\u0013\u0003N\tM#\u0011L\u0005\u0004\u0005\u0017\n&\u0001D\"b]\n+\u0018\u000e\u001c3Ge>l\u0007c\u00011\u0003P\u0011Y!\u0011\u000bB!\u0003\u0003\u0005\tQ!\u0001d\u0005\ryF%\r\t\u0004A\nUCa\u0003B,\u0005\u0003\n\t\u0011!A\u0003\u0002\r\u00141a\u0018\u00133!\r\u0001'1\f\u0003\f\u0005;\u0012\t%!A\u0001\u0002\u000b\u00051MA\u0002`IM\n\u0011#\u00193e\u00032dGK]3f'\u0016$\u0018*\u001c9m)\rq'1\r\u0005\u0007\u0005Kj\u0004\u0019\u00018\u0002\u0005Q\u001c\u0018AC1eI\u0006cG.S7qYV1!1\u000eB>\u0005c\"BA!\u001c\u0003\u0000Q!!q\u000eB;!\r\u0001'\u0011\u000f\u0003\u0007\u0005gr$\u0019A2\u0003\tQC\u0017\r\u001e\u0005\b\u0005\u0007r\u00049\u0001B<!!\u0001&\u0011\n8\u0003z\t=\u0004c\u00011\u0003|\u00119!Q\u0010 C\u0002\u0005}#!\u0001\"\t\u000f\t\u0005e\b1\u0001\u0003\u0004\u0006!A\u000f[1u!\u0015Y'Q\u0011B=\u0013\r\u00119I\u0012\u0002\u0013\u000f\u0016tGK]1wKJ\u001c\u0018M\u00197f\u001f:\u001cW-A\u0005sK6|g/Z!mYR\u0019aN!$\t\r\t\u0015t\b1\u0001o\u0003)1\u0017\u000e\u001c;fe&k\u0007\u000f\u001c\u000b\u0006]\nM%Q\u0013\u0005\b\u0005#\u0001\u0005\u0019AAU\u0011\u001d\u00119\n\u0011a\u0001\u0003_\u000b\u0011\"[:GY&\u0004\b/\u001a3\u0002\u0013A\f'\u000f^5uS>tG\u0003BAM\u0005;Cq!a*B\u0001\u0004\tI+\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0003_\u0013\u0019\u000b\u0003\u0004\u0003&\n\u0003\raZ\u0001\u0004_\nT\u0007fB\t\u0003*\n=&\u0011\u0017\t\u00043\n-\u0016b\u0001BW\u0011\n\u00012+\u001a:jC24VM]:j_:,\u0016\nR\u0001\u0006m\u0006dW/\u001a\u0010\tc_)\u0006\u0005OnY\u0017Q\t1*A\bj[Bd\u0017nY5u\u0005VLG\u000eZ3s+\u0011\u0011IL!3\u0015\t\tm&Q\u001a\t\t\u0005{\u0013\u0019Ma2\u0003L6\u0011!q\u0018\u0006\u0004\u0005\u00034\u0015aB7vi\u0006\u0014G.Z\u0005\u0005\u0005\u000b\u0014yLA\u0004Ck&dG-\u001a:\u0011\u0007\u0001\u0014I\rB\u0003c\u0007\t\u00071\r\u0005\u0003M#\t\u001d\u0007B\u0002?\u0004\u0001\b\u0011y\rE\u0003\u0000\u0003\u000b\u00119-\u0001\u0006oK^\u0014U/\u001b7eKJ,BA!6\u0003\\R!!q\u001bBp!!\u0011iLa1\u0003Z\nu\u0007c\u00011\u0003\\\u0012)!\r\u0002b\u0001GB!A*\u0005Bm\u0011\u0019aH\u0001q\u0001\u0003bB)q0!\u0002\u0003ZV!!Q\u001dBv)\u0011\u00119O!<\u0011\t1\u000b\"\u0011\u001e\t\u0004A\n-H!\u00022\u0006\u0005\u0004\u0019\u0007B\u0002?\u0006\u0001\b\u0011y\u000fE\u0003\u0000\u0003\u000b\u0011IO\u0001\bUe\u0016,7+\u001a;Ck&dG-\u001a:\u0016\t\tU(1`\n\u0005\ra\u00139\u0010\u0005\u0005\u0003>\n\r'\u0011 B\u007f!\r\u0001'1 \u0003\u0006E\u001a\u0011\ra\u0019\t\u0005\u0019F\u0011I0\u0006\u0002\u0004\u0002A)q0!\u0002\u0003zR\u00111Q\u0001\u000b\u0005\u0007\u000f\u0019Y\u0001E\u0003\u0004\n\u0019\u0011I0D\u0001\u0002\u0011\u0019a\u0018\u0002q\u0001\u0004\u0002A)Q\u000f\u001fB}OB\u00191\u0011\u0003\u0006\u000e\u0003\u0019\t\u0001\u0002\n9mkN$S-\u001d\u000b\u0005\u0007#\u00199\u0002C\u0004\u0002^2\u0001\rA!?\u0002\u001b\u0011\u0002H.^:%a2,8\u000fJ3r)\u0011\u0019\tb!\b\t\u000f\r}Q\u00021\u0001\u0004\"\u0005\u0011\u0001p\u001d\t\u0006W\u000e\r\"\u0011`\u0005\u0004\u0007K1%a\u0004+sCZ,'o]1cY\u0016|enY3\u0002\u000b\rdW-\u0019:\u0015\u0005\t%\u0011A\u0002:fgVdG\u000f\u0006\u0002\u0003~\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0019\u0019\u0004\u0005\u0003\u0002\u001e\rU\u0012\u0002BB\u001c\u0003?\u0011aa\u00142kK\u000e$\b")
public final class TreeSet<A>
implements SortedSet<A>,
Serializable {
    public static final long serialVersionUID = -5685982407650748405L;
    private final RedBlackTree.Tree<A, Object> tree;
    private final Ordering<A> ordering;

    public static <A> Builder<A, TreeSet<A>> implicitBuilder(Ordering<A> ordering) {
        return TreeSet$.MODULE$.implicitBuilder(ordering);
    }

    public static <A> CanBuildFrom<TreeSet<?>, A, TreeSet<A>> newCanBuildFrom(Ordering<A> ordering) {
        return TreeSet$.MODULE$.newCanBuildFrom(ordering);
    }

    @Override
    public /* synthetic */ boolean scala$collection$immutable$SortedSet$$super$equals(Object that) {
        return GenSetLike.equals$(this, that);
    }

    @Override
    public /* synthetic */ boolean scala$collection$SortedSetLike$$super$subsetOf(GenSet that) {
        return GenSetLike.subsetOf$(this, that);
    }

    @Override
    public scala.collection.SortedSet keySet() {
        return SortedSetLike.keySet$(this);
    }

    @Override
    public boolean subsetOf(GenSet<A> that) {
        return SortedSetLike.subsetOf$(this, that);
    }

    @Override
    public Iterator<A> iteratorFrom(A start) {
        return SortedSetLike.iteratorFrom$(this, start);
    }

    @Override
    public int compare(A k0, A k1) {
        return Sorted.compare$(this, k0, k1);
    }

    @Override
    public boolean hasAll(Iterator<A> j) {
        return Sorted.hasAll$(this, j);
    }

    @Override
    public GenericCompanion<scala.collection.immutable.Set> companion() {
        return scala.collection.immutable.Set.companion$(this);
    }

    @Override
    public <B> scala.collection.immutable.Set<B> toSet() {
        return scala.collection.immutable.Set.toSet$(this);
    }

    @Override
    public scala.collection.immutable.Set<A> seq() {
        return scala.collection.immutable.Set.seq$(this);
    }

    @Override
    public Combiner<A, ParSet<A>> parCombiner() {
        return scala.collection.immutable.Set.parCombiner$(this);
    }

    @Override
    public /* synthetic */ Object scala$collection$SetLike$$super$map(Function1 f, CanBuildFrom bf) {
        return TraversableLike.map$(this, f, bf);
    }

    @Override
    public Builder<A, TreeSet<A>> newBuilder() {
        return SetLike.newBuilder$(this);
    }

    @Override
    public Seq<A> toSeq() {
        return SetLike.toSeq$(this);
    }

    @Override
    public <A1> Buffer<A1> toBuffer() {
        return SetLike.toBuffer$(this);
    }

    @Override
    public <B, That> That map(Function1<A, B> f, CanBuildFrom<TreeSet<A>, B, That> bf) {
        return (That)SetLike.map$(this, f, bf);
    }

    @Override
    public Set $plus(Object elem1, Object elem2, Seq elems) {
        return SetLike.$plus$(this, elem1, elem2, elems);
    }

    @Override
    public Set $plus$plus(GenTraversableOnce elems) {
        return SetLike.$plus$plus$(this, elems);
    }

    @Override
    public boolean isEmpty() {
        return SetLike.isEmpty$(this);
    }

    @Override
    public Set union(GenSet that) {
        return SetLike.union$(this, that);
    }

    @Override
    public Set diff(GenSet that) {
        return SetLike.diff$(this, that);
    }

    @Override
    public Iterator<TreeSet<A>> subsets(int len) {
        return SetLike.subsets$(this, len);
    }

    @Override
    public Iterator<TreeSet<A>> subsets() {
        return SetLike.subsets$(this);
    }

    @Override
    public String toString() {
        return SetLike.toString$(this);
    }

    @Override
    public Subtractable $minus(Object elem1, Object elem2, Seq elems) {
        return Subtractable.$minus$(this, elem1, elem2, elems);
    }

    @Override
    public Subtractable $minus$minus(GenTraversableOnce xs) {
        return Subtractable.$minus$minus$(this, xs);
    }

    @Override
    public boolean apply(A elem) {
        return GenSetLike.apply$(this, elem);
    }

    @Override
    public Object intersect(GenSet that) {
        return GenSetLike.intersect$(this, that);
    }

    @Override
    public Object $amp(GenSet that) {
        return GenSetLike.$amp$(this, that);
    }

    @Override
    public Object $bar(GenSet that) {
        return GenSetLike.$bar$(this, that);
    }

    @Override
    public Object $amp$tilde(GenSet that) {
        return GenSetLike.$amp$tilde$(this, that);
    }

    @Override
    public int hashCode() {
        return GenSetLike.hashCode$(this);
    }

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
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, Object> compose(Function1<A, A> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public <A> Function1<A, A> andThen(Function1<Object, A> g) {
        return Function1.andThen$(this, g);
    }

    @Override
    public Iterable<A> thisCollection() {
        return IterableLike.thisCollection$(this);
    }

    @Override
    public Iterable toCollection(Object repr) {
        return IterableLike.toCollection$(this, repr);
    }

    @Override
    public boolean forall(Function1<A, Object> p) {
        return IterableLike.forall$(this, p);
    }

    @Override
    public boolean exists(Function1<A, Object> p) {
        return IterableLike.exists$(this, p);
    }

    @Override
    public Option<A> find(Function1<A, Object> p) {
        return IterableLike.find$(this, p);
    }

    @Override
    public <B> B foldRight(B z, Function2<A, B, B> op) {
        return (B)IterableLike.foldRight$(this, z, op);
    }

    @Override
    public <B> B reduceRight(Function2<A, B, B> op) {
        return (B)IterableLike.reduceRight$(this, op);
    }

    @Override
    public Iterable<A> toIterable() {
        return IterableLike.toIterable$(this);
    }

    @Override
    public Iterator<A> toIterator() {
        return IterableLike.toIterator$(this);
    }

    @Override
    public Iterator<TreeSet<A>> grouped(int size) {
        return IterableLike.grouped$(this, size);
    }

    @Override
    public Iterator<TreeSet<A>> sliding(int size) {
        return IterableLike.sliding$(this, size);
    }

    @Override
    public Iterator<TreeSet<A>> sliding(int size, int step) {
        return IterableLike.sliding$(this, size, step);
    }

    @Override
    public <B> void copyToArray(Object xs, int start, int len) {
        IterableLike.copyToArray$(this, xs, start, len);
    }

    @Override
    public <A1, B, That> That zip(GenIterable<B> that, CanBuildFrom<TreeSet<A>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zip$(this, that, bf);
    }

    @Override
    public <B, A1, That> That zipAll(GenIterable<B> that, A1 thisElem, B thatElem, CanBuildFrom<TreeSet<A>, Tuple2<A1, B>, That> bf) {
        return (That)IterableLike.zipAll$(this, that, thisElem, thatElem, bf);
    }

    @Override
    public <A1, That> That zipWithIndex(CanBuildFrom<TreeSet<A>, Tuple2<A1, Object>, That> bf) {
        return (That)IterableLike.zipWithIndex$(this, bf);
    }

    @Override
    public <B> boolean sameElements(GenIterable<B> that) {
        return IterableLike.sameElements$(this, that);
    }

    @Override
    public Stream<A> toStream() {
        return IterableLike.toStream$(this);
    }

    @Override
    public boolean canEqual(Object that) {
        return IterableLike.canEqual$(this, that);
    }

    @Override
    public IterableView<A, TreeSet<A>> view() {
        return IterableLike.view$(this);
    }

    @Override
    public IterableView<A, TreeSet<A>> view(int from, int until) {
        return IterableLike.view$(this, from, until);
    }

    @Override
    public <B> Builder<B, scala.collection.immutable.Set<B>> genericBuilder() {
        return GenericTraversableTemplate.genericBuilder$(this);
    }

    @Override
    public <A1, A2> Tuple2<scala.collection.immutable.Set<A1>, scala.collection.immutable.Set<A2>> unzip(Function1<A, Tuple2<A1, A2>> asPair) {
        return GenericTraversableTemplate.unzip$(this, asPair);
    }

    @Override
    public <A1, A2, A3> Tuple3<scala.collection.immutable.Set<A1>, scala.collection.immutable.Set<A2>, scala.collection.immutable.Set<A3>> unzip3(Function1<A, Tuple3<A1, A2, A3>> asTriple) {
        return GenericTraversableTemplate.unzip3$(this, asTriple);
    }

    @Override
    public GenTraversable flatten(Function1 asTraversable) {
        return GenericTraversableTemplate.flatten$(this, asTraversable);
    }

    @Override
    public GenTraversable transpose(Function1 asTraversable) {
        return GenericTraversableTemplate.transpose$(this, asTraversable);
    }

    @Override
    public Object repr() {
        return TraversableLike.repr$(this);
    }

    @Override
    public final boolean isTraversableAgain() {
        return TraversableLike.isTraversableAgain$(this);
    }

    @Override
    public boolean hasDefiniteSize() {
        return TraversableLike.hasDefiniteSize$(this);
    }

    @Override
    public <B, That> That $plus$plus(GenTraversableOnce<B> that, CanBuildFrom<TreeSet<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$(this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(TraversableOnce<B> that, CanBuildFrom<TreeSet<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That $plus$plus$colon(scala.collection.Traversable<B> that, CanBuildFrom<TreeSet<A>, B, That> bf) {
        return (That)TraversableLike.$plus$plus$colon$((TraversableLike)this, that, bf);
    }

    @Override
    public <B, That> That flatMap(Function1<A, GenTraversableOnce<B>> f, CanBuildFrom<TreeSet<A>, B, That> bf) {
        return (That)TraversableLike.flatMap$(this, f, bf);
    }

    @Override
    public Object filter(Function1 p) {
        return TraversableLike.filter$(this, p);
    }

    @Override
    public Object filterNot(Function1 p) {
        return TraversableLike.filterNot$(this, p);
    }

    @Override
    public <B, That> That collect(PartialFunction<A, B> pf, CanBuildFrom<TreeSet<A>, B, That> bf) {
        return (That)TraversableLike.collect$(this, pf, bf);
    }

    @Override
    public <K> Map<K, TreeSet<A>> groupBy(Function1<A, K> f) {
        return TraversableLike.groupBy$(this, f);
    }

    @Override
    public <B, That> That scan(B z, Function2<B, B, B> op, CanBuildFrom<TreeSet<A>, B, That> cbf) {
        return (That)TraversableLike.scan$(this, z, op, cbf);
    }

    @Override
    public <B, That> That scanLeft(B z, Function2<B, A, B> op, CanBuildFrom<TreeSet<A>, B, That> bf) {
        return (That)TraversableLike.scanLeft$(this, z, op, bf);
    }

    @Override
    public <B, That> That scanRight(B z, Function2<A, B, B> op, CanBuildFrom<TreeSet<A>, B, That> bf) {
        return (That)TraversableLike.scanRight$(this, z, op, bf);
    }

    @Override
    public Object sliceWithKnownDelta(int from, int until, int delta) {
        return TraversableLike.sliceWithKnownDelta$(this, from, until, delta);
    }

    @Override
    public Object sliceWithKnownBound(int from, int until) {
        return TraversableLike.sliceWithKnownBound$(this, from, until);
    }

    @Override
    public Iterator<TreeSet<A>> tails() {
        return TraversableLike.tails$(this);
    }

    @Override
    public Iterator<TreeSet<A>> inits() {
        return TraversableLike.inits$(this);
    }

    @Override
    public scala.collection.Traversable<A> toTraversable() {
        return TraversableLike.toTraversable$(this);
    }

    @Override
    public <Col> Col to(CanBuildFrom<Nothing$, A, Col> cbf) {
        return (Col)TraversableLike.to$(this, cbf);
    }

    @Override
    public FilterMonadic<A, TreeSet<A>> withFilter(Function1<A, Object> p) {
        return TraversableLike.withFilter$(this, p);
    }

    @Override
    public Parallel par() {
        return Parallelizable.par$(this);
    }

    @Override
    public List<A> reversed() {
        return TraversableOnce.reversed$(this);
    }

    @Override
    public boolean nonEmpty() {
        return TraversableOnce.nonEmpty$(this);
    }

    @Override
    public int count(Function1<A, Object> p) {
        return TraversableOnce.count$(this, p);
    }

    @Override
    public <B> Option<B> collectFirst(PartialFunction<A, B> pf) {
        return TraversableOnce.collectFirst$(this, pf);
    }

    @Override
    public <B> B $div$colon(B z, Function2<B, A, B> op) {
        return (B)TraversableOnce.$div$colon$(this, z, op);
    }

    @Override
    public <B> B $colon$bslash(B z, Function2<A, B, B> op) {
        return (B)TraversableOnce.$colon$bslash$(this, z, op);
    }

    @Override
    public <B> B foldLeft(B z, Function2<B, A, B> op) {
        return (B)TraversableOnce.foldLeft$(this, z, op);
    }

    @Override
    public <B> B reduceLeft(Function2<B, A, B> op) {
        return (B)TraversableOnce.reduceLeft$(this, op);
    }

    @Override
    public <B> Option<B> reduceLeftOption(Function2<B, A, B> op) {
        return TraversableOnce.reduceLeftOption$(this, op);
    }

    @Override
    public <B> Option<B> reduceRightOption(Function2<A, B, B> op) {
        return TraversableOnce.reduceRightOption$(this, op);
    }

    @Override
    public <A1> A1 reduce(Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.reduce$(this, op);
    }

    @Override
    public <A1> Option<A1> reduceOption(Function2<A1, A1, A1> op) {
        return TraversableOnce.reduceOption$(this, op);
    }

    @Override
    public <A1> A1 fold(A1 z, Function2<A1, A1, A1> op) {
        return (A1)TraversableOnce.fold$(this, z, op);
    }

    @Override
    public <B> B aggregate(Function0<B> z, Function2<B, A, B> seqop, Function2<B, B, B> combop) {
        return (B)TraversableOnce.aggregate$(this, z, seqop, combop);
    }

    @Override
    public <B> B sum(Numeric<B> num) {
        return (B)TraversableOnce.sum$(this, num);
    }

    @Override
    public <B> B product(Numeric<B> num) {
        return (B)TraversableOnce.product$(this, num);
    }

    @Override
    public <B> A maxBy(Function1<A, B> f, Ordering<B> cmp) {
        return (A)TraversableOnce.maxBy$(this, f, cmp);
    }

    @Override
    public <B> A minBy(Function1<A, B> f, Ordering<B> cmp) {
        return (A)TraversableOnce.minBy$(this, f, cmp);
    }

    @Override
    public <B> void copyToBuffer(Buffer<B> dest) {
        TraversableOnce.copyToBuffer$(this, dest);
    }

    @Override
    public <B> void copyToArray(Object xs, int start) {
        TraversableOnce.copyToArray$(this, xs, start);
    }

    @Override
    public <B> void copyToArray(Object xs) {
        TraversableOnce.copyToArray$(this, xs);
    }

    @Override
    public <B> Object toArray(ClassTag<B> evidence$1) {
        return TraversableOnce.toArray$(this, evidence$1);
    }

    @Override
    public List<A> toList() {
        return TraversableOnce.toList$(this);
    }

    @Override
    public IndexedSeq<A> toIndexedSeq() {
        return TraversableOnce.toIndexedSeq$(this);
    }

    @Override
    public Vector<A> toVector() {
        return TraversableOnce.toVector$(this);
    }

    @Override
    public <T, U> Map<T, U> toMap(Predef$.less.colon.less<A, Tuple2<T, U>> ev) {
        return TraversableOnce.toMap$(this, ev);
    }

    @Override
    public String mkString(String start, String sep, String end) {
        return TraversableOnce.mkString$(this, start, sep, end);
    }

    @Override
    public String mkString(String sep) {
        return TraversableOnce.mkString$(this, sep);
    }

    @Override
    public String mkString() {
        return TraversableOnce.mkString$(this);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String start, String sep, String end) {
        return TraversableOnce.addString$(this, b, start, sep, end);
    }

    @Override
    public StringBuilder addString(StringBuilder b, String sep) {
        return TraversableOnce.addString$(this, b, sep);
    }

    @Override
    public StringBuilder addString(StringBuilder b) {
        return TraversableOnce.addString$(this, b);
    }

    @Override
    public int sizeHintIfCheap() {
        return GenTraversableOnce.sizeHintIfCheap$(this);
    }

    public RedBlackTree.Tree<A, Object> tree() {
        return this.tree;
    }

    @Override
    public Ordering<A> ordering() {
        return this.ordering;
    }

    @Override
    public String stringPrefix() {
        return "TreeSet";
    }

    @Override
    public int size() {
        return RedBlackTree$.MODULE$.count(this.tree());
    }

    @Override
    public A head() {
        return RedBlackTree$.MODULE$.smallest(this.tree()).key();
    }

    @Override
    public Option<A> headOption() {
        if (RedBlackTree$.MODULE$.isEmpty(this.tree())) {
            return None$.MODULE$;
        }
        return new Some<A>(this.head());
    }

    @Override
    public A last() {
        return RedBlackTree$.MODULE$.greatest(this.tree()).key();
    }

    @Override
    public Option<A> lastOption() {
        if (RedBlackTree$.MODULE$.isEmpty(this.tree())) {
            return None$.MODULE$;
        }
        return new Some<A>(this.last());
    }

    @Override
    public TreeSet<A> tail() {
        return new TreeSet<A>(RedBlackTree$.MODULE$.delete(this.tree(), this.firstKey(), this.ordering()), this.ordering());
    }

    @Override
    public TreeSet<A> init() {
        return new TreeSet<A>(RedBlackTree$.MODULE$.delete(this.tree(), this.lastKey(), this.ordering()), this.ordering());
    }

    @Override
    public <A1> A min(Ordering<A1> ord) {
        if (ord == this.ordering() && this.nonEmpty()) {
            return this.head();
        }
        return (A)TraversableOnce.min$(this, ord);
    }

    @Override
    public <A1> A max(Ordering<A1> ord) {
        if (ord == this.ordering() && this.nonEmpty()) {
            return this.last();
        }
        return (A)TraversableOnce.max$(this, ord);
    }

    @Override
    public TreeSet<A> drop(int n) {
        if (n <= 0) {
            return this;
        }
        if (n >= this.size()) {
            return this.empty();
        }
        return this.newSetOrSelf(RedBlackTree$.MODULE$.drop(this.tree(), n, this.ordering()));
    }

    @Override
    public TreeSet<A> take(int n) {
        if (n <= 0) {
            return this.empty();
        }
        if (n >= this.size()) {
            return this;
        }
        return this.newSetOrSelf(RedBlackTree$.MODULE$.take(this.tree(), n, this.ordering()));
    }

    @Override
    public TreeSet<A> slice(int from, int until) {
        if (until <= from) {
            return this.empty();
        }
        if (from <= 0) {
            return this.take(until);
        }
        if (until >= this.size()) {
            return this.drop(from);
        }
        return this.newSetOrSelf(RedBlackTree$.MODULE$.slice(this.tree(), from, until, this.ordering()));
    }

    @Override
    public TreeSet<A> dropRight(int n) {
        return this.take(this.size() - package$.MODULE$.max(n, 0));
    }

    @Override
    public TreeSet<A> takeRight(int n) {
        return this.drop(this.size() - package$.MODULE$.max(n, 0));
    }

    @Override
    public Tuple2<TreeSet<A>, TreeSet<A>> splitAt(int n) {
        return new Tuple2<Object, Object>(this.take(n), this.drop(n));
    }

    /*
     * WARNING - void declaration
     */
    private int countWhile(Function1<A, Object> p) {
        void var2_2;
        int result2 = 0;
        Iterator<A> it = this.iterator();
        while (it.hasNext() && BoxesRunTime.unboxToBoolean(p.apply(it.next()))) {
            ++result2;
        }
        return (int)var2_2;
    }

    @Override
    public TreeSet<A> dropWhile(Function1<A, Object> p) {
        return this.drop(this.countWhile(p));
    }

    @Override
    public TreeSet<A> takeWhile(Function1<A, Object> p) {
        return this.take(this.countWhile(p));
    }

    @Override
    public Tuple2<TreeSet<A>, TreeSet<A>> span(Function1<A, Object> p) {
        return this.splitAt(this.countWhile(p));
    }

    private TreeSet<A> newSetOrSelf(RedBlackTree.Tree<A, Object> t) {
        if (t == this.tree()) {
            return this;
        }
        return new TreeSet<A>(t, this.ordering());
    }

    @Override
    public TreeSet<A> empty() {
        return this.newSetOrSelf(null);
    }

    @Override
    public TreeSet<A> $plus(A elem) {
        return this.newSetOrSelf(RedBlackTree$.MODULE$.update(this.tree(), elem, BoxedUnit.UNIT, false, this.ordering()));
    }

    public TreeSet<A> insert(A elem) {
        Predef$.MODULE$.assert(!RedBlackTree$.MODULE$.contains(this.tree(), elem, this.ordering()));
        return this.newSetOrSelf(RedBlackTree$.MODULE$.update(this.tree(), elem, BoxedUnit.UNIT, false, this.ordering()));
    }

    @Override
    public TreeSet<A> $minus(A elem) {
        if (!RedBlackTree$.MODULE$.contains(this.tree(), elem, this.ordering())) {
            return this;
        }
        return this.newSetOrSelf(RedBlackTree$.MODULE$.delete(this.tree(), elem, this.ordering()));
    }

    @Override
    public boolean contains(A elem) {
        return RedBlackTree$.MODULE$.contains(this.tree(), elem, this.ordering());
    }

    @Override
    public Iterator<A> iterator() {
        return RedBlackTree$.MODULE$.keysIterator(this.tree(), RedBlackTree$.MODULE$.keysIterator$default$2(), this.ordering());
    }

    @Override
    public Iterator<A> keysIteratorFrom(A start) {
        return RedBlackTree$.MODULE$.keysIterator(this.tree(), new Some<A>(start), this.ordering());
    }

    @Override
    public <U> void foreach(Function1<A, U> f) {
        RedBlackTree$.MODULE$.foreachKey(this.tree(), f);
    }

    @Override
    public TreeSet<A> rangeImpl(Option<A> from, Option<A> until) {
        return this.newSetOrSelf(RedBlackTree$.MODULE$.rangeImpl(this.tree(), from, until, this.ordering()));
    }

    @Override
    public TreeSet<A> range(A from, A until) {
        return this.newSetOrSelf(RedBlackTree$.MODULE$.range(this.tree(), from, until, this.ordering()));
    }

    @Override
    public TreeSet<A> from(A from) {
        return this.newSetOrSelf(RedBlackTree$.MODULE$.from(this.tree(), from, this.ordering()));
    }

    @Override
    public TreeSet<A> to(A to) {
        return this.newSetOrSelf(RedBlackTree$.MODULE$.to(this.tree(), to, this.ordering()));
    }

    @Override
    public TreeSet<A> until(A until) {
        return this.newSetOrSelf(RedBlackTree$.MODULE$.until(this.tree(), until, this.ordering()));
    }

    @Override
    public A firstKey() {
        return this.head();
    }

    @Override
    public A lastKey() {
        return this.last();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean sameCBF(CanBuildFrom<?, ?, ?> bf2) {
        while (true) {
            if (bf2 instanceof SortedSetFactory.SortedSetCanBuildFrom) {
                SortedSetFactory.SortedSetCanBuildFrom sortedSetCanBuildFrom = (SortedSetFactory.SortedSetCanBuildFrom)bf2;
                SortedSetFactory factory2 = sortedSetCanBuildFrom.factory();
                if (factory2 != TreeSet$.MODULE$ && factory2 != SortedSet$.MODULE$) {
                    if (factory2 != scala.collection.SortedSet$.MODULE$) return false;
                }
                Ordering ordering = sortedSetCanBuildFrom.ordering();
                Ordering<A> ordering2 = this.ordering();
                if (ordering != null) {
                    if (!ordering.equals(ordering2)) return false;
                    return true;
                }
                if (ordering2 == null) return true;
                return false;
            }
            if (!(bf2 instanceof package.WrappedCanBuildFrom)) return false;
            CanBuildFrom bf2 = ((package.WrappedCanBuildFrom)bf2).wrapped();
        }
    }

    public TreeSet<A> addAllTreeSetImpl(TreeSet<A> ts) {
        Ordering<A> ordering = this.ordering();
        Ordering<A> ordering2 = ts.ordering();
        Predef$.MODULE$.assert(!(ordering != null ? !ordering.equals(ordering2) : ordering2 != null));
        return this.newSetOrSelf(RedBlackTree$.MODULE$.union(this.tree(), ts.tree(), this.ordering()));
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public <B, That> That addAllImpl(GenTraversableOnce<B> that, CanBuildFrom<TreeSet<A>, B, That> bf) {
        void var3_6;
        if (that instanceof TreeSet) {
            TreeSet treeSet = (TreeSet)that;
            if (this.sameCBF(bf)) {
                TreeSet<A> treeSet2 = this.newSetOrSelf(RedBlackTree$.MODULE$.union(this.tree(), treeSet.tree(), this.ordering()));
                return var3_6;
            }
        }
        Builder<B, That> b = bf.apply((TreeSet<A>)this.repr());
        b.$plus$plus$eq(this.thisCollection());
        b.$plus$plus$eq(that.seq());
        That That = b.result();
        return var3_6;
    }

    public TreeSet<A> removeAll(TreeSet<A> ts) {
        Ordering<A> ordering = this.ordering();
        Ordering<A> ordering2 = ts.ordering();
        Predef$.MODULE$.assert(!(ordering != null ? !ordering.equals(ordering2) : ordering2 != null));
        return this.newSetOrSelf(RedBlackTree$.MODULE$.difference(this.tree(), ts.tree(), this.ordering()));
    }

    @Override
    public TreeSet<A> filterImpl(Function1<A, Object> f, boolean isFlipped) {
        return this.newSetOrSelf(RedBlackTree$.MODULE$.filterKeys(this.tree(), f, isFlipped));
    }

    @Override
    public Tuple2<TreeSet<A>, TreeSet<A>> partition(Function1<A, Object> p) {
        Tuple2<RedBlackTree.Tree<A, Object>, RedBlackTree.Tree<A, Object>> tuple2 = RedBlackTree$.MODULE$.partitionKeys(this.tree(), p);
        if (tuple2 == null) {
            throw new MatchError((Object)null);
        }
        RedBlackTree.Tree<A, Object> tree = tuple2._1();
        RedBlackTree.Tree<A, Object> tree2 = tuple2._2();
        RedBlackTree.Tree<A, Object> l = tree;
        RedBlackTree.Tree<A, Object> r = tree2;
        return new Tuple2<TreeSet<A>, TreeSet<A>>(this.newSetOrSelf(l), this.newSetOrSelf(r));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeSet)) return SortedSet.equals$(this, obj);
        TreeSet treeSet = (TreeSet)obj;
        Ordering<A> ordering = this.ordering();
        Ordering<A> ordering2 = treeSet.ordering();
        if (ordering != null) {
            if (!ordering.equals(ordering2)) return SortedSet.equals$(this, obj);
            return RedBlackTree$.MODULE$.keysEqual(this.tree(), treeSet.tree(), this.ordering());
        }
        if (ordering2 == null) return RedBlackTree$.MODULE$.keysEqual(this.tree(), treeSet.tree(), this.ordering());
        return SortedSet.equals$(this, obj);
    }

    public TreeSet(RedBlackTree.Tree<A, Object> tree, Ordering<A> ordering) {
        this.tree = tree;
        this.ordering = ordering;
        GenTraversableOnce.$init$(this);
        TraversableOnce.$init$(this);
        Parallelizable.$init$(this);
        TraversableLike.$init$(this);
        GenericTraversableTemplate.$init$(this);
        GenTraversable.$init$(this);
        scala.collection.Traversable.$init$(this);
        Traversable.$init$(this);
        GenIterable.$init$(this);
        IterableLike.$init$(this);
        Iterable.$init$(this);
        scala.collection.immutable.Iterable.$init$(this);
        GenSetLike.$init$(this);
        GenericSetTemplate.$init$(this);
        GenSet.$init$(this);
        Subtractable.$init$(this);
        SetLike.$init$(this);
        Set.$init$(this);
        scala.collection.immutable.Set.$init$(this);
        Sorted.$init$(this);
        SortedSetLike.$init$(this);
        scala.collection.SortedSet.$init$(this);
        SortedSet.$init$(this);
        if (ordering == null) {
            throw new NullPointerException("ordering must not be null");
        }
    }

    public TreeSet(Ordering<A> ordering) {
        this(null, ordering);
    }

    public static class TreeSetBuilder<A>
    implements Builder<A, TreeSet<A>> {
        private final Ordering<A> ordering;
        private RedBlackTree.Tree<A, Object> tree;

        @Override
        public void sizeHint(int size) {
            Builder.sizeHint$((Builder)this, size);
        }

        @Override
        public void sizeHint(TraversableLike<?, ?> coll) {
            Builder.sizeHint$((Builder)this, coll);
        }

        @Override
        public void sizeHint(TraversableLike<?, ?> coll, int delta) {
            Builder.sizeHint$(this, coll, delta);
        }

        @Override
        public void sizeHintBounded(int size, TraversableLike<?, ?> boundingColl) {
            Builder.sizeHintBounded$(this, size, boundingColl);
        }

        @Override
        public <NewTo> Builder<A, NewTo> mapResult(Function1<TreeSet<A>, NewTo> f) {
            return Builder.mapResult$(this, f);
        }

        @Override
        public Growable<A> $plus$eq(A elem1, A elem2, Seq<A> elems) {
            return Growable.$plus$eq$(this, elem1, elem2, elems);
        }

        public Ordering<A> ordering() {
            return this.ordering;
        }

        @Override
        public TreeSetBuilder<A> $plus$eq(A elem) {
            this.tree = RedBlackTree$.MODULE$.update(this.tree, elem, BoxedUnit.UNIT, false, this.ordering());
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public TreeSetBuilder<A> $plus$plus$eq(TraversableOnce<A> xs) {
            if (xs instanceof TreeSet) {
                TreeSet treeSet = (TreeSet)xs;
                Ordering ordering = treeSet.ordering();
                Ordering<A> ordering2 = this.ordering();
                if (!(ordering != null ? !ordering.equals(ordering2) : ordering2 != null)) {
                    this.tree = RedBlackTree$.MODULE$.union(this.tree, treeSet.tree(), this.ordering());
                    return this;
                }
            }
            Growable.$plus$plus$eq$(this, xs);
            return this;
        }

        @Override
        public void clear() {
            this.tree = null;
        }

        @Override
        public TreeSet<A> result() {
            return new TreeSet<A>(this.tree, this.ordering());
        }

        public TreeSetBuilder(Ordering<A> ordering) {
            this.ordering = ordering;
            Growable.$init$(this);
            Builder.$init$(this);
            this.tree = null;
        }
    }
}

