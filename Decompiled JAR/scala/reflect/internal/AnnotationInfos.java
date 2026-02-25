/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Array$;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Predef$any2stringadd$;
import scala.Product;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.LinearSeqOptimized;
import scala.collection.TraversableLike;
import scala.collection.TraversableOnce;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.ListMap;
import scala.collection.immutable.ListMap$;
import scala.collection.immutable.Nil$;
import scala.collection.mutable.ArrayOps;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Annotations;
import scala.reflect.api.Trees;
import scala.reflect.internal.AnnotationInfos$Annotation$;
import scala.reflect.internal.AnnotationInfos$AnnotationInfo$;
import scala.reflect.internal.AnnotationInfos$ArrayAnnotArg$;
import scala.reflect.internal.AnnotationInfos$LiteralAnnotArg$;
import scala.reflect.internal.AnnotationInfos$NestedAnnotArg$;
import scala.reflect.internal.AnnotationInfos$ScalaSigBytes$;
import scala.reflect.internal.AnnotationInfos$ThrownException$;
import scala.reflect.internal.AnnotationInfos$UnmappableAnnotArg$;
import scala.reflect.internal.AnnotationInfos$UnmappableAnnotation$;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Definitions;
import scala.reflect.internal.Names;
import scala.reflect.internal.StdNames;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Types;
import scala.reflect.internal.pickling.ByteCodecs$;
import scala.reflect.internal.util.Position;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.Statics;

@ScalaSignature(bytes="\u0006\u0001\u0019\u001de\u0001DA\\\u0003s\u0003\n1!\u0001\u0002H\u001a}\u0004bBAo\u0001\u0011\u0005\u0011q\u001c\u0004\n\u0003O\u0004\u0001\u0013aA\u0001\u0003SDq!!8\u0003\t\u0003\ty\u000eC\u0004\u0002n\n1\t!a<\t\u000f\u0011m$A\"\u0001\u0005~!9A1\u0013\u0002\u0007\u0002\u0011U\u0005b\u0002CM\u0005\u0019\u0005A1\u0014\u0005\b\tC\u0013a\u0011\u0001CR\u0011\u001d!)K\u0001C\u0001\tOCq\u0001b+\u0003\t\u0003!i\u000bC\u0004\u00054\n!\t\u0001\".\t\u000f\u0011m&\u0001\"\u0001\u0005>\"9A1\u0019\u0002\u0005\u0002\u0011\u0015\u0007b\u0002Ce\u0005\u0011\u0015A1\u001a\u0005\b\t#\u0014A\u0011\u0002Cj\r\u001d\u00119\u0005AA\u0011\u0005\u0013BqA!\u0004\u0011\t\u0003\u00119\u0006C\u0005\u0005f\u0002\u0011\r\u0011b\u0001\u0005h\u001e9A\u0011\u001f\u0001\t\u0002\u000e\u001dfaBBQ\u0001!\u000551\u0015\u0005\b\u0005\u001b!B\u0011ABS\u0011%\u0011\u0019\fFA\u0001\n\u0003\u0012)\fC\u0005\u0003FR\t\t\u0011\"\u0001\u0003H\"I!q\u001a\u000b\u0002\u0002\u0013\u00051\u0011\u0016\u0005\n\u0005;$\u0012\u0011!C!\u0005?D\u0011B!<\u0015\u0003\u0003%\ta!,\t\u0013\teH#!A\u0005B\tm\b\"\u0003B>)\u0005\u0005I\u0011IB(\r\u0019\u0019\u0019\u0001\u0001!\u0004\u0006!Q1QB\u000f\u0003\u0016\u0004%\taa\u0004\t\u0015\rmQD!E!\u0002\u0013\u0019\t\u0002C\u0004\u0003\u000eu!\ta!\b\t\u000f\r\rR\u0004\"\u0001\u0004\u0010!9!1P\u000f\u0005B\tu\u0004\"\u0003BK;\u0005\u0005I\u0011AB\u0013\u0011%\u0011Y*HI\u0001\n\u0003\u0019I\u0003C\u0005\u00034v\t\t\u0011\"\u0011\u00036\"I!QY\u000f\u0002\u0002\u0013\u0005!q\u0019\u0005\n\u0005\u001fl\u0012\u0011!C\u0001\u0007[A\u0011B!8\u001e\u0003\u0003%\tEa8\t\u0013\t5X$!A\u0005\u0002\rE\u0002\"\u0003B};\u0005\u0005I\u0011\tB~\u0011%\u0011i0HA\u0001\n\u0003\u001a)dB\u0004\u0005t\u0002A\t\u0001\">\u0007\u000f\r\r\u0001\u0001#\u0001\u0005x\"9!QB\u0017\u0005\u0002\u0011}\b\"CC\u0001[\u0005\u0005I\u0011QC\u0002\u0011%)9!LA\u0001\n\u0003+IA\u0002\u0004\u0003\\\u0001\u0001%Q\f\u0005\u000b\u0005?\t$Q3A\u0005\u0002\t-\u0004B\u0003B:c\tE\t\u0015!\u0003\u0003n!9!QB\u0019\u0005\u0002\tU\u0004b\u0002B>c\u0011\u0005#Q\u0010\u0005\n\u0005+\u000b\u0014\u0011!C\u0001\u0005/C\u0011Ba'2#\u0003%\tA!(\t\u0013\tM\u0016'!A\u0005B\tU\u0006\"\u0003Bcc\u0005\u0005I\u0011\u0001Bd\u0011%\u0011y-MA\u0001\n\u0003\u0011\t\u000eC\u0005\u0003^F\n\t\u0011\"\u0011\u0003`\"I!Q^\u0019\u0002\u0002\u0013\u0005!q\u001e\u0005\n\u0005s\f\u0014\u0011!C!\u0005wD\u0011B!@2\u0003\u0003%\tEa@\b\u000f\u0015=\u0001\u0001#\u0001\u0006\u0012\u00199!1\f\u0001\t\u0002\u0015M\u0001b\u0002B\u0007\u0001\u0012\u0005Q1\u0004\u0005\n\u000b\u0003\u0001\u0015\u0011!CA\u000b;A\u0011\"b\u0002A\u0003\u0003%\t)\"\t\u0007\r\re\u0002\u0001QB\u001e\u0011)\u0019\u0019\u0005\u0012BK\u0002\u0013\u00051Q\t\u0005\u000b\u0007\u000f\"%\u0011#Q\u0001\n\u0005}\bb\u0002B\u0007\t\u0012\u00051\u0011\n\u0005\b\u0005[#E\u0011AB#\u0011\u001d\u0011Y\b\u0012C!\u0007\u001fB\u0011B!&E\u0003\u0003%\ta!\u0015\t\u0013\tmE)%A\u0005\u0002\rU\u0003\"\u0003BZ\t\u0006\u0005I\u0011\tB[\u0011%\u0011)\rRA\u0001\n\u0003\u00119\rC\u0005\u0003P\u0012\u000b\t\u0011\"\u0001\u0004Z!I!Q\u001c#\u0002\u0002\u0013\u0005#q\u001c\u0005\n\u0005[$\u0015\u0011!C\u0001\u0007;B\u0011B!?E\u0003\u0003%\tEa?\t\u0013\tuH)!A\u0005B\r\u0005taBC\u0014\u0001!\u0005Q\u0011\u0006\u0004\b\u0007s\u0001\u0001\u0012AC\u0016\u0011\u001d\u0011i\u0001\u0016C\u0001\u000bgA\u0011\"\"\u0001U\u0003\u0003%\t)\"\u000e\t\u0013\u0015\u001dA+!A\u0005\u0002\u0016eRABC\u001f\u0001\u0001\u0011)%\u0002\u0004\u0006@\u0001\u00011q\u0004\u0005\n\u000b\u0003\u0002!\u0019!C\u0001\u000b\u0007B\u0011\"b\u0012\u0001\u0005\u0004%\u0019!\"\u0013\u0006\r\u00155\u0003\u0001\u0001B<\u0011%)y\u0005\u0001b\u0001\n\u0003)\t\u0006C\u0005\u0006V\u0001\u0011\r\u0011b\u0001\u0006X\u00151Q1\f\u0001\u0001\u0007\u0017B\u0011\"\"\u0018\u0001\u0005\u0004%\t!b\u0018\t\u0013\u0015\r\u0004A1A\u0005\u0004\u0015\u0015dABB3\u0001\u0001\u001b9\u0007\u0003\u0006\u0004j\t\u0014)\u001a!C\u0001\u0007WB!b!\u001ec\u0005#\u0005\u000b\u0011BB7\u0011\u001d\u0011iA\u0019C\u0001\u0007oBqAa\u001fc\t\u0003\u0012i\b\u0003\u0006\u0004~\tD)\u0019!C\u0001\u0007WBqaa c\t\u0003\u0019\t\tC\u0004\u0004\u0004\n$\tAa\u0005\t\u000f\r\u0015%\r\"\u0003\u0004\b\"I!Q\u00132\u0002\u0002\u0013\u00051Q\u0012\u0005\n\u00057\u0013\u0017\u0013!C\u0001\u0007#C\u0011Ba-c\u0003\u0003%\tE!.\t\u0013\t\u0015'-!A\u0005\u0002\t\u001d\u0007\"\u0003BhE\u0006\u0005I\u0011ABK\u0011%\u0011iNYA\u0001\n\u0003\u0012y\u000eC\u0005\u0003n\n\f\t\u0011\"\u0001\u0004\u001a\"I!\u0011 2\u0002\u0002\u0013\u0005#1 \u0005\n\u0005{\u0014\u0017\u0011!C!\u0007;;\u0011\"\"\u001b\u0001\u0003\u0003E\t!b\u001b\u0007\u0013\r\u0015\u0004!!A\t\u0002\u00155\u0004b\u0002B\u0007k\u0012\u0005Q1\u0010\u0005\n\u0005w*\u0018\u0011!C#\u0007\u001fB\u0011\"\"\u0001v\u0003\u0003%\t)\" \t\u0013\u0015\u001dQ/!A\u0005\u0002\u0016\u0005uaBCD\u0001!\u0005Q\u0011\u0012\u0004\b\u0005\u0007\u0001\u0001\u0012ACF\u0011\u001d\u0011ia\u001fC\u0001\u000b\u001bCq!b$|\t\u0003)\t\nC\u0004\u0006\u0016n$\t!b&\t\u000f\u0015U5\u0010\"\u0001\u0006@\"9Q\u0011A>\u0005\u0002\u0015]\u0007bBC\u0004w\u0012\u0005Qq\u001c\u0005\b\u000b[\\H\u0011ACx\r\u0019)y\u0010\u0001\u0001\u0007\u0002!Y!\u0011CA\u0004\u0005\u000b\u0007I\u0011\u0001B\n\u0011-1\u0019!a\u0002\u0003\u0002\u0003\u0006IA!\u0006\t\u0017\t}\u0011q\u0001BC\u0002\u0013\u0005!\u0011\u0005\u0005\f\u0005g\n9A!A!\u0002\u0013\u0011\u0019\u0003C\u0006\u00030\u0005\u001d!Q1A\u0005\u0002\tE\u0002b\u0003D\u0003\u0003\u000f\u0011\t\u0011)A\u0005\u0005gA\u0001B!\u0004\u0002\b\u0011\u0005aq\u0001\u0005\u000b\r#\t9\u00011A\u0005\n\r\u001d\u0007B\u0003D\n\u0003\u000f\u0001\r\u0011\"\u0003\u0007\u0016!Ia\u0011DA\u0004A\u0003&!Q\u0005\u0005\t\u0007\u000b\f9\u0001\"\u0001\u0004H\"A1\u0011ZA\u0004\t\u00031Y\u0002\u0003\u0005\u0003|\u0005\u001dA\u0011\tB?\u0011%1\t\u0003\u0001C\u0001\u0003\u00034\u0019C\u0002\u0004\u0006\u001c\u0002\u0001QQ\u0014\u0005\f\u000b?\u000b)C!A%\u0002\u0013)\t\u000b\u0003\u0005\u0003\u000e\u0005\u0015B\u0011ACT\u0011))Y+!\nA\u0002\u0013%1\u0011\u0011\u0005\u000b\u000b[\u000b)\u00031A\u0005\n\u0015=\u0006\"CCZ\u0003K\u0001\u000b\u0015\u0002By\u0011-)),!\n\t\u0006\u0004%Ia!\u0012\t\u0011\tE\u0011Q\u0005C\u0001\u0005'A\u0001Ba\b\u0002&\u0011\u0005!\u0011\u0005\u0005\t\u0005_\t)\u0003\"\u0001\u00032!A1QYA\u0013\t\u0003\u00199\r\u0003\u0005\u0004J\u0006\u0015B\u0011AC\\\u0011!\u0011Y(!\n\u0005B\r=\u0003\u0002CBv\u0003K!\tea6\t\u0011\rM\u0018Q\u0005C!\u0003?4a!b1\u0001\u0005\u0015\u0015\u0007b\u0003C\u0017\u0003\u0007\u0012\t\u0011*A\u0005\u000b\u000fD1\"b(\u0002D\t\u0005I\u0015!\u0003\u0006\"\"A!QBA\"\t\u0003)I\rC\u0006\u0006P\u0006\r\u0003R1Q\u0005\n\r]\b\u0002CB{\u0003\u0007\"\tea>\u0007\u000f\t\r\u0001!!\u0001\u0003\u0006!A!QBA(\t\u0003\u0011y\u0001\u0003\u0005\u0003\u0012\u0005=c\u0011\u0001B\n\u0011!\u0011y\"a\u0014\u0007\u0002\t\u0005\u0002\u0002\u0003B\u0018\u0003\u001f2\tA!\r\t\u0011\rE\u0016q\nC\u0001\u0005'A\u0001ba-\u0002P\u0011\u0005!\u0011\u0005\u0005\t\u0007k\u000by\u0005\"\u0001\u00048\"A1QYA(\r\u0003\u00199\r\u0003\u0005\u0004J\u0006=c\u0011ABf\u0011-\u0019\u0019.a\u0014\t\u0006\u0004%\ta!!\t\u0015\rU\u0017q\na\u0001\n\u0013\u00199\u000e\u0003\u0006\u0004d\u0006=\u0003\u0019!C\u0005\u0007KD\u0011b!;\u0002P\u0001\u0006Ka!7\t\u0011\r-\u0018q\nC\u0001\u0007/D\u0001b!<\u0002P\u0011\u00051q\u001e\u0005\t\u0007g\fy\u0005\"\u0001\u0002`\"A1Q_A(\t\u0003\u00199\u0010\u0003\u0005\u0005\u0004\u0005=C\u0011AAx\u0011!!)!a\u0014\u0005\u0002\u0011\u001d\u0001\u0002\u0003C\u0007\u0003\u001f\"\t\u0001b\u0004\t\u0011\u0011U\u0011q\nC\u0001\t/A\u0001\u0002b\t\u0002P\u0011\u00051\u0011\u0011\u0005\t\tK\ty\u0005\"\u0001\u0004\u0002\"AAqEA(\t\u0003!I\u0003\u0003\u0005\u00050\u0005=C\u0011\u0001C\u0019\u0011!!i$a\u0014\u0005\u0002\u0011}\u0002\u0002\u0003C#\u0003\u001f\"\t\u0001b\u0012\t\u0011\u00115\u0013q\nC\u0001\t\u001fB\u0001\u0002b\u0017\u0002P\u0011\u0005AQ\f\u0005\t\tG\ny\u0005\"\u0001\u0005f!AA1NA(\t\u0003!i\u0007\u0003\u0005\u0003z\u0006=C\u0011\tB~\u0011!\u0011i0a\u0014\u0005B\u0011UTA\u0002D\u0014\u0001\u0001\typB\u0004\u0007*\u0001A\tAb\u000b\u0007\u000f\u0019\u001d\u0002\u0001#\u0001\u0007.!A!QBAL\t\u00031)\u0004\u0003\u0005\u0006\u0002\u0005]E\u0011\u0001D\u001c\u0011!)9!a&\u0005\u0002\u0019\u0005\u0003\"\u0003D%\u0001\t\u0007I1\u0001D&\u0011%1y\u0005\u0001C\t\u0003\u00034\t\u0006C\u0005\u0007V\u0001!\t\"!1\u0007X\u001d9aQ\f\u0001\t\u0002\u0019}ca\u0002D1\u0001!\u0005a1\r\u0005\t\u0005\u001b\t9\u000b\"\u0001\u0007f\u00191aq\r\u0001\u0001\rSB\u0001B!\u0004\u0002,\u0012\u0005a1N\u0004\b\r_\u0002\u0001\u0012\u0001D9\r\u001d1\u0019\b\u0001E\u0001\rkB\u0001B!\u0004\u00022\u0012\u0005aq\u000f\u0005\t\u000b\u000f\t\t\f\"\u0001\u0007z\ty\u0011I\u001c8pi\u0006$\u0018n\u001c8J]\u001a|7O\u0003\u0003\u0002<\u0006u\u0016\u0001C5oi\u0016\u0014h.\u00197\u000b\t\u0005}\u0016\u0011Y\u0001\be\u00164G.Z2u\u0015\t\t\u0019-A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u000b\u0001\tI-!5\u0011\t\u0005-\u0017QZ\u0007\u0003\u0003\u0003LA!a4\u0002B\n1\u0011I\\=SK\u001a\u0004B!a5\u0002Z6\u0011\u0011Q\u001b\u0006\u0005\u0003/\fi,A\u0002ba&LA!a7\u0002V\nY\u0011I\u001c8pi\u0006$\u0018n\u001c8t\u0003\u0019!\u0013N\\5uIQ\u0011\u0011\u0011\u001d\t\u0005\u0003\u0017\f\u0019/\u0003\u0003\u0002f\u0006\u0005'\u0001B+oSR\u00141\"\u00118o_R\fG/\u00192mKV!\u00111\u001eCB'\r\u0011\u0011\u0011Z\u0001\fC:tw\u000e^1uS>t7/\u0006\u0002\u0002rB1\u00111_A}\u0003\u007ftA!a3\u0002v&!\u0011q_Aa\u0003\u001d\u0001\u0018mY6bO\u0016LA!a?\u0002~\n!A*[:u\u0015\u0011\t90!1\u0011\t\t\u0005\u0011qJ\u0007\u0002\u0001\tq\u0011I\u001c8pi\u0006$\u0018n\u001c8J]\u001a|7CBA(\u0003\u0013\u00149\u0001\u0005\u0003\u0003\u0002\t%\u0011\u0002\u0002B\u0006\u00033\u0014Q\"\u00118o_R\fG/[8o\u0003BL\u0017A\u0002\u001fj]&$h\b\u0006\u0002\u0002\u0000\u0006\u0019\u0011\r\u001e9\u0016\u0005\tU\u0001\u0003\u0002B\u0001\u0005/IAA!\u0007\u0003\u001c\t!A+\u001f9f\u0013\u0011\u0011i\"!/\u0003\u000bQK\b/Z:\u0002\t\u0005\u0014xm]\u000b\u0003\u0005G\u0001b!a=\u0002z\n\u0015\u0002\u0003\u0002B\u0001\u0005OIAA!\u000b\u0003,\t!AK]3f\u0013\u0011\u0011i#!/\u0003\u000bQ\u0013X-Z:\u0002\r\u0005\u001c8o\\2t+\t\u0011\u0019\u0004\u0005\u0004\u0002t\u0006e(Q\u0007\t\t\u0003\u0017\u00149Da\u000f\u0003F%!!\u0011HAa\u0005\u0019!V\u000f\u001d7feA!!\u0011\u0001B\u001f\u0013\u0011\u0011yD!\u0011\u0003\t9\u000bW.Z\u0005\u0005\u0005\u0007\nILA\u0003OC6,7\u000fE\u0002\u0003\u0002A\u0011\u0011c\u00117bgN4\u0017\u000e\\3B]:|G/\u0011:h'\u001d\u0001\u0012\u0011\u001aB&\u0005#\u0002B!a3\u0003N%!!qJAa\u0005\u001d\u0001&o\u001c3vGR\u0004BA!\u0001\u0003T%!!QKAm\u0005=Q\u0015M^1Be\u001e,X.\u001a8u\u0003BLGC\u0001B#S\u0019\u0001\u0012'\b#c)\ti\u0011I\u001d:bs\u0006sgn\u001c;Be\u001e\u001c\u0012\"\rB#\u0005?\u0012YE!\u001a\u0011\t\t\u0005!\u0011M\u0005\u0005\u0005G\nIN\u0001\tBeJ\f\u00170\u0011:hk6,g\u000e^!qSB!\u00111\u001aB4\u0013\u0011\u0011I'!1\u0003\u0019M+'/[1mSj\f'\r\\3\u0016\u0005\t5\u0004CBAf\u0005_\u0012)%\u0003\u0003\u0003r\u0005\u0005'!B!se\u0006L\u0018!B1sON\u0004C\u0003\u0002B<\u0005s\u00022A!\u00012\u0011\u001d\u0011y\u0002\u000ea\u0001\u0005[\n\u0001\u0002^8TiJLgn\u001a\u000b\u0003\u0005\u007f\u0002BA!!\u0003\u0010:!!1\u0011BF!\u0011\u0011))!1\u000e\u0005\t\u001d%\u0002\u0002BE\u0003\u000b\fa\u0001\u0010:p_Rt\u0014\u0002\u0002BG\u0003\u0003\fa\u0001\u0015:fI\u00164\u0017\u0002\u0002BI\u0005'\u0013aa\u0015;sS:<'\u0002\u0002BG\u0003\u0003\fAaY8qsR!!q\u000fBM\u0011%\u0011yB\u000eI\u0001\u0002\u0004\u0011i'\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0005\t}%\u0006\u0002B7\u0005C[#Aa)\u0011\t\t\u0015&qV\u0007\u0003\u0005OSAA!+\u0003,\u0006IQO\\2iK\u000e\\W\r\u001a\u0006\u0005\u0005[\u000b\t-\u0001\u0006b]:|G/\u0019;j_:LAA!-\u0003(\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\t\u00119\f\u0005\u0003\u0003:\n\rWB\u0001B^\u0015\u0011\u0011iLa0\u0002\t1\fgn\u001a\u0006\u0003\u0005\u0003\fAA[1wC&!!\u0011\u0013B^\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\t\u0011I\r\u0005\u0003\u0002L\n-\u0017\u0002\u0002Bg\u0003\u0003\u00141!\u00138u\u00039\u0001(o\u001c3vGR,E.Z7f]R$BAa5\u0003ZB!\u00111\u001aBk\u0013\u0011\u00119.!1\u0003\u0007\u0005s\u0017\u0010C\u0005\u0003\\j\n\t\u00111\u0001\u0003J\u0006\u0019\u0001\u0010J\u0019\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\"A!9\u0011\r\t\r(\u0011\u001eBj\u001b\t\u0011)O\u0003\u0003\u0003h\u0006\u0005\u0017AC2pY2,7\r^5p]&!!1\u001eBs\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\t\tE(q\u001f\t\u0005\u0003\u0017\u0014\u00190\u0003\u0003\u0003v\u0006\u0005'a\u0002\"p_2,\u0017M\u001c\u0005\n\u00057d\u0014\u0011!a\u0001\u0005'\f\u0001\u0002[1tQ\u000e{G-\u001a\u000b\u0003\u0005\u0013\fa!Z9vC2\u001cH\u0003\u0002By\u0007\u0003A\u0011Ba7?\u0003\u0003\u0005\rAa5\u0003\u001f1KG/\u001a:bY\u0006sgn\u001c;Be\u001e\u001c\u0012\"\bB#\u0007\u000f\u0011YE!\u001a\u0011\t\t\u00051\u0011B\u0005\u0005\u0007\u0017\tIN\u0001\nMSR,'/\u00197Be\u001e,X.\u001a8u\u0003BL\u0017!B2p]N$XCAB\t!\u0011\u0011\taa\u0005\n\t\rU1q\u0003\u0002\t\u0007>t7\u000f^1oi&!1\u0011DA]\u0005%\u0019uN\\:uC:$8/\u0001\u0004d_:\u001cH\u000f\t\u000b\u0005\u0007?\u0019\t\u0003E\u0002\u0003\u0002uAqa!\u0004!\u0001\u0004\u0019\t\"A\u0003wC2,X\r\u0006\u0003\u0004 \r\u001d\u0002\"CB\u0007GA\u0005\t\u0019AB\t+\t\u0019YC\u000b\u0003\u0004\u0012\t\u0005F\u0003\u0002Bj\u0007_A\u0011Ba7(\u0003\u0003\u0005\rA!3\u0015\t\tE81\u0007\u0005\n\u00057L\u0013\u0011!a\u0001\u0005'$BA!=\u00048!I!1\\\u0016\u0002\u0002\u0003\u0007!1\u001b\u0002\u000f\u001d\u0016\u001cH/\u001a3B]:|G/\u0011:h'%!%QIB\u001f\u0005\u0017\u0012)\u0007\u0005\u0003\u0003\u0002\r}\u0012\u0002BB!\u00033\u0014\u0011CT3ti\u0016$\u0017I]4v[\u0016tG/\u00119j\u0003\u001d\tgN\\%oM>,\"!a@\u0002\u0011\u0005tg.\u00138g_\u0002\"Baa\u0013\u0004NA\u0019!\u0011\u0001#\t\u000f\r\rs\t1\u0001\u0002\u0000R\u0011!q\u0017\u000b\u0005\u0007\u0017\u001a\u0019\u0006C\u0005\u0004D)\u0003\n\u00111\u0001\u0002\u0000V\u00111q\u000b\u0016\u0005\u0003\u007f\u0014\t\u000b\u0006\u0003\u0003T\u000em\u0003\"\u0003Bn\u001d\u0006\u0005\t\u0019\u0001Be)\u0011\u0011\tpa\u0018\t\u0013\tm\u0007+!AA\u0002\tMG\u0003\u0002By\u0007GB\u0011Ba7S\u0003\u0003\u0005\rAa5\u0003\u001bM\u001b\u0017\r\\1TS\u001e\u0014\u0015\u0010^3t'\u001d\u0011'Q\tB&\u0005K\nQAY=uKN,\"a!\u001c\u0011\r\u0005-'qNB8!\u0011\tYm!\u001d\n\t\rM\u0014\u0011\u0019\u0002\u0005\u0005f$X-\u0001\u0004csR,7\u000f\t\u000b\u0005\u0007s\u001aY\bE\u0002\u0003\u0002\tDqa!\u001bf\u0001\u0004\u0019i'\u0001\ntKZ,gNQ5ug6\u000b\u0017PQ3[KJ|\u0017a\u00044jiNLen\u00148f'R\u0014\u0018N\\4\u0016\u0005\tE\u0018\u0001C:jO\u0006sgn\u001c;\u0002+5\f\u0007\u000fV8OKb$Xj\u001c3TKZ,gNQ5ugR!1QNBE\u0011\u001d\u0019YI\u001ba\u0001\u0007[\n1a\u001d:d)\u0011\u0019Iha$\t\u0013\r%4\u000e%AA\u0002\r5TCABJU\u0011\u0019iG!)\u0015\t\tM7q\u0013\u0005\n\u00057|\u0017\u0011!a\u0001\u0005\u0013$BA!=\u0004\u001c\"I!1\\9\u0002\u0002\u0003\u0007!1\u001b\u000b\u0005\u0005c\u001cy\nC\u0005\u0003\\N\f\t\u00111\u0001\u0003T\n\u0011RK\\7baB\f'\r\\3B]:|G/\u0011:h'\u001d!\"Q\tB&\u0005K\"\"aa*\u0011\u0007\t\u0005A\u0003\u0006\u0003\u0003T\u000e-\u0006\"\u0003Bn1\u0005\u0005\t\u0019\u0001Be)\u0011\u0011\tpa,\t\u0013\tm'$!AA\u0002\tM\u0017a\u0001;qK\u0006I1oY1mC\u0006\u0013xm]\u0001\tU\u00064\u0018-\u0011:hgV\u00111\u0011\u0018\t\t\u0007w\u001b\tMa\u000f\u0003F5\u00111Q\u0018\u0006\u0005\u0007\u007f\u0013)/A\u0005j[6,H/\u00192mK&!11YB_\u0005\u001da\u0015n\u001d;NCB\f\u0001b\u001c:jO&t\u0017\r\\\u000b\u0003\u0005K\t1b]3u\u001fJLw-\u001b8bYR!1QZBh\u001b\t\ty\u0005\u0003\u0005\u0004R\u0006\u0005\u0004\u0019\u0001B\u0013\u0003\u0005!\u0018!C5t)JLg/[1m\u0003\u0019\u0011\u0018m\u001e9pgV\u00111\u0011\u001c\t\u0005\u0005\u0003\u0019Y.\u0003\u0003\u0004^\u000e}'\u0001\u0003)pg&$\u0018n\u001c8\n\t\r\u0005\u0018\u0011\u0018\u0002\n!>\u001c\u0018\u000e^5p]N\f!B]1xa>\u001cx\fJ3r)\u0011\t\toa:\t\u0015\tm\u0017qMA\u0001\u0002\u0004\u0019I.A\u0004sC^\u0004xn\u001d\u0011\u0002\u0007A|7/\u0001\u0004tKR\u0004vn\u001d\u000b\u0005\u0007\u001b\u001c\t\u0010\u0003\u0005\u0004l\u00065\u0004\u0019ABm\u00031\u0019w.\u001c9mKR,\u0017J\u001c4p\u0003\u0019\u0019\u00180\u001c2pYV\u00111\u0011 \t\u0005\u0005\u0003\u0019Y0\u0003\u0003\u0004~\u000e}(AB*z[\n|G.\u0003\u0003\u0005\u0002\u0005e&aB*z[\n|Gn]\u0001\u0010[\u0016$\u0018-\u00118o_R\fG/[8og\u0006qA-\u001a4bk2$H+\u0019:hKR\u001cXC\u0001C\u0005!\u0019\u0019Y\fb\u0003\u0004z&!\u00111`B_\u0003\u001di\u0017\r^2iKN$BA!=\u0005\u0012!AA1CA<\u0001\u0004\u0019I0A\u0003dY\u0006T(0A\u0006iCN\f%oZ,iS\u000eDG\u0003\u0002By\t3A\u0001\u0002b\u0007\u0002z\u0001\u0007AQD\u0001\u0002aBA\u00111\u001aC\u0010\u0005K\u0011\t0\u0003\u0003\u0005\"\u0005\u0005'!\u0003$v]\u000e$\u0018n\u001c82\u0003-I7/\u0012:s_:,w.^:\u0002\u0011%\u001c8\u000b^1uS\u000e\f!B]3ggNKXNY8m)\u0011\u0011\t\u0010b\u000b\t\u0011\u00115\u0012q\u0010a\u0001\u0007s\f1a]=n\u0003%\u0019HO]5oO\u0006\u0013x\r\u0006\u0003\u00054\u0011e\u0002CBAf\tk\u0011y(\u0003\u0003\u00058\u0005\u0005'AB(qi&|g\u000e\u0003\u0005\u0005<\u0005\u0005\u0005\u0019\u0001Be\u0003\u0015Ig\u000eZ3y\u0003\u0019Ig\u000e^!sOR!A\u0011\tC\"!\u0019\tY\r\"\u000e\u0003J\"AA1HAB\u0001\u0004\u0011I-\u0001\u0006c_>dW-\u00198Be\u001e$B\u0001\"\u0013\u0005LA1\u00111\u001aC\u001b\u0005cD\u0001\u0002b\u000f\u0002\u0006\u0002\u0007!\u0011Z\u0001\ngfl'm\u001c7Be\u001e$B\u0001\"\u0015\u0005ZA1\u00111\u001aC\u001b\t'\u0002BA!\u0001\u0005V%!Aq\u000bB!\u0005!!VM]7OC6,\u0007\u0002\u0003C\u001e\u0003\u000f\u0003\rA!3\u0002\u001f\r|gn\u001d;b]R\fE/\u00138eKb$B\u0001b\u0018\u0005bA1\u00111\u001aC\u001b\u0007#A\u0001\u0002b\u000f\u0002\n\u0002\u0007!\u0011Z\u0001\u000bCJ<\u0017\t^%oI\u0016DH\u0003\u0002C4\tS\u0002b!a3\u00056\t\u0015\u0002\u0002\u0003C\u001e\u0003\u0017\u0003\rA!3\u0002\u001bQ\u0014\u0018M\\:g_Jl\u0017I]4t)\u0011\ty\u0010b\u001c\t\u0011\u0011E\u0014Q\u0012a\u0001\tg\n\u0011A\u001a\t\t\u0003\u0017$yBa\t\u0003$Q!!\u0011\u001fC<\u0011!!I(!%A\u0002\tM\u0017!B8uQ\u0016\u0014\u0018AD:fi\u0006sgn\u001c;bi&|gn\u001d\u000b\u0005\t\u007f\"y\t\u0005\u0003\u0005\u0002\u0012\rE\u0002\u0001\u0003\b\t\u000b\u0013!\u0019\u0001CD\u0005\u0011\u0019V\r\u001c4\u0012\t\u0011%%1\u001b\t\u0005\u0003\u0017$Y)\u0003\u0003\u0005\u000e\u0006\u0005'a\u0002(pi\"Lgn\u001a\u0005\b\t#+\u0001\u0019AAy\u0003\u0019\tgN\\8ug\u0006yq/\u001b;i\u0003:tw\u000e^1uS>t7\u000f\u0006\u0003\u0005\u0000\u0011]\u0005b\u0002CI\r\u0001\u0007\u0011\u0011_\u0001\u0012M&dG/\u001a:B]:|G/\u0019;j_:\u001cH\u0003\u0002C@\t;Cq\u0001b\u0007\b\u0001\u0004!y\n\u0005\u0005\u0002L\u0012}\u0011q By\u0003I9\u0018\u000e\u001e5pkR\feN\\8uCRLwN\\:\u0016\u0005\u0011}\u0014!E:uCRL7-\u00118o_R\fG/[8ogV\u0011A\u0011\u0016\t\u0007\u0007w#Y!a@\u0002'\u0005$G\r\u00165s_^\u001c\u0018I\u001c8pi\u0006$\u0018n\u001c8\u0015\t\u0011}Dq\u0016\u0005\b\tcS\u0001\u0019AB}\u00031!\bN]8xC\ndWmU=n\u00035A\u0017m]!o]>$\u0018\r^5p]R!!\u0011\u001fC\\\u0011\u001d!Il\u0003a\u0001\u0007s\f1a\u00197t\u000359W\r^!o]>$\u0018\r^5p]R!Aq\u0018Ca!\u0019\tY\r\"\u000e\u0002\u0000\"9A\u0011\u0018\u0007A\u0002\re\u0018\u0001\u0005:f[>4X-\u00118o_R\fG/[8o)\u0011!y\bb2\t\u000f\u0011eV\u00021\u0001\u0004z\u0006qq/\u001b;i\u0003:tw\u000e^1uS>tG\u0003\u0002C@\t\u001bDq\u0001b4\u000f\u0001\u0004\ty0A\u0003b]:|G/\u0001\u000bee>\u0004x\n\u001e5fe\u0006sgn\u001c;bi&|gn\u001d\u000b\u0007\u0003c$)\u000e\"7\t\u000f\u0011]w\u00021\u0001\u0002r\u0006!\u0011M\u001c8t\u0011\u001d!Il\u0004a\u0001\u0007sD3a\u0004Co!\u0011!y\u000e\"9\u000e\u0005\t-\u0016\u0002\u0002Cr\u0005W\u0013q\u0001^1jYJ,7-A\bKCZ\f\u0017I]4v[\u0016tG\u000fV1h+\t!I\u000f\u0005\u0004\u0005l\u00125(QI\u0007\u0003\u0003{KA\u0001b<\u0002>\nA1\t\\1tgR\u000bw-\u0001\nV]6\f\u0007\u000f]1cY\u0016\feN\\8u\u0003J<\u0017a\u0004'ji\u0016\u0014\u0018\r\\!o]>$\u0018I]4\u0011\u0007\t\u0005QfE\u0003.\ts\u0014)\u0007\u0005\u0003\u0003\u0002\u0011m\u0018\u0002\u0002C\u007f\u00033\u0014\u0001\u0004T5uKJ\fG.\u0011:hk6,g\u000e^#yiJ\f7\r^8s)\t!)0A\u0003baBd\u0017\u0010\u0006\u0003\u0004 \u0015\u0015\u0001bBB\u0007_\u0001\u00071\u0011C\u0001\bk:\f\u0007\u000f\u001d7z)\u0011!y&b\u0003\t\u0013\u00155\u0001'!AA\u0002\r}\u0011a\u0001=%a\u0005i\u0011I\u001d:bs\u0006sgn\u001c;Be\u001e\u00042A!\u0001A'\u0015\u0001UQ\u0003B3!\u0011\u0011\t!b\u0006\n\t\u0015e\u0011\u0011\u001c\u0002\u0017\u0003J\u0014\u0018-_!sOVlWM\u001c;FqR\u0014\u0018m\u0019;peR\u0011Q\u0011\u0003\u000b\u0005\u0005o*y\u0002C\u0004\u0003 \t\u0003\rA!\u001c\u0015\t\u0015\rRQ\u0005\t\u0007\u0003\u0017$)D!\u001c\t\u0013\u001551)!AA\u0002\t]\u0014A\u0004(fgR,G-\u00118o_R\f%o\u001a\t\u0004\u0005\u0003!6#\u0002+\u0006.\t\u0015\u0004\u0003\u0002B\u0001\u000b_IA!\"\r\u0002Z\n9b*Z:uK\u0012\f%oZ;nK:$X\t\u001f;sC\u000e$xN\u001d\u000b\u0003\u000bS!Baa\u0013\u00068!911\t,A\u0002\u0005}H\u0003\u0002C`\u000bwA\u0011\"\"\u0004X\u0003\u0003\u0005\raa\u0013\u0003\u0019)\u000bg/Y!sOVlWM\u001c;\u0003\u001f1KG/\u001a:bY\u0006\u0013x-^7f]R\fq\u0002T5uKJ\fG.\u0011:hk6,g\u000e^\u000b\u0003\u000b\u000br1A!\u0001-\u0003Ia\u0015\u000e^3sC2\f%oZ;nK:$H+Y4\u0016\u0005\u0015-\u0003C\u0002Cv\t[\u001cyBA\u0007BeJ\f\u00170\u0011:hk6,g\u000e^\u0001\u000e\u0003J\u0014\u0018-_!sOVlWM\u001c;\u0016\u0005\u0015Mcb\u0001B\u0001\u007f\u0005\u0001\u0012I\u001d:bs\u0006\u0013x-^7f]R$\u0016mZ\u000b\u0003\u000b3\u0002b\u0001b;\u0005n\n]$A\u0004(fgR,G-\u0011:hk6,g\u000e^\u0001\u000f\u001d\u0016\u001cH/\u001a3Be\u001e,X.\u001a8u+\t)\tGD\u0002\u0003\u0002M\u000b\u0011CT3ti\u0016$\u0017I]4v[\u0016tG\u000fV1h+\t)9\u0007\u0005\u0004\u0005l\u0012581J\u0001\u000e'\u000e\fG.Y*jO\nKH/Z:\u0011\u0007\t\u0005QoE\u0003v\u000b_\u0012)\u0007\u0005\u0005\u0006r\u0015]4QNB=\u001b\t)\u0019H\u0003\u0003\u0006v\u0005\u0005\u0017a\u0002:v]RLW.Z\u0005\u0005\u000bs*\u0019HA\tBEN$(/Y2u\rVt7\r^5p]F\"\"!b\u001b\u0015\t\reTq\u0010\u0005\b\u0007SB\b\u0019AB7)\u0011)\u0019)\"\"\u0011\r\u0005-GQGB7\u0011%)i!_A\u0001\u0002\u0004\u0019I(\u0001\bB]:|G/\u0019;j_:LeNZ8\u0011\u0007\t\u00051pE\u0002|\u0003\u0013$\"!\"#\u0002\r5\f'o[3s)\u0011\ty0b%\t\u000f\tEQ\u00101\u0001\u0003\u0016\u00051A.\u0019>jYf$B!\"'\u0006>B!!\u0011AA\u0013\u0005Ia\u0015M_=B]:|G/\u0019;j_:LeNZ8\u0014\t\u0005\u0015\u0012q`\u0001\tY\u0006T\u00180\u00138g_B1\u00111ZCR\u0003\u007fLA!\"*\u0002B\nAAHY=oC6,g\b\u0006\u0003\u0006\u001a\u0016%\u0006\"CCP\u0003S!\t\u0019ACQ\u0003\u00191wN]2fI\u0006Qam\u001c:dK\u0012|F%Z9\u0015\t\u0005\u0005X\u0011\u0017\u0005\u000b\u00057\fi#!AA\u0002\tE\u0018a\u00024pe\u000e,G\rI\u0001\u000bM>\u00148-\u001a3J]\u001a|G\u0003BC]\u000bwk!!!\n\t\u0011\rE\u00171\ba\u0001\u0005KA\u0001\"b(\u007f\t\u0003\u0007Q\u0011\u0015\u000b\u0007\u000b\u0003,\t.\"6\u0011\t\t\u0005\u00111\t\u0002\u0018\u000bb$(/\u0019'buf\feN\\8uCRLwN\\%oM>\u001cB!a\u0011\u0006\u001aB1\u00111ZCR\u0007s$b!\"1\u0006L\u00165\u0007\"\u0003C\u0017\u0003\u0013\"\t\u0019ACd\u0011%)y*!\u0013\u0005\u0002\u0004)\t+\u0001\u0006usB,7+_7c_2D\u0001\"b5\u0000\t\u0003\u0007QqY\u0001\u000bY\u0006T\u0018pU=nE>d\u0007\u0002CCP\u007f\u0012\u0005\r!\")\u0015\u0011\u0005}X\u0011\\Cn\u000b;D\u0001B!\u0005\u0002\u0002\u0001\u0007!Q\u0003\u0005\t\u0005?\t\t\u00011\u0001\u0003$!A!qFA\u0001\u0001\u0004\u0011\u0019\u0004\u0006\u0003\u0006b\u0016%\bCBAf\tk)\u0019\u000f\u0005\u0006\u0002L\u0016\u0015(Q\u0003B\u0012\u0005gIA!b:\u0002B\n1A+\u001e9mKNB\u0001\"b;\u0002\u0004\u0001\u0007\u0011q`\u0001\u0005S:4w.\u0001\u0005nW\u001aKG\u000e^3s)\u0019)\t0b>\u0006|R!!\u0011_Cz\u0011!))0!\u0002A\u0002\u0005}\u0018aA1o]\"AQ\u0011`A\u0003\u0001\u0004\u0019I0\u0001\u0005dCR,wm\u001c:z\u0011!)i0!\u0002A\u0002\tE\u0018\u0001\u00053fM\u0006,H\u000e\u001e*fi\u0016tG/[8o\u0005Y\u0019u.\u001c9mKR,\u0017I\u001c8pi\u0006$\u0018n\u001c8J]\u001a|7\u0003BA\u0004\u0003\u007f\fA!\u0019;qA\u00059\u0011m]:pGN\u0004C\u0003\u0003D\u0005\r\u00171iAb\u0004\u0011\t\t\u0005\u0011q\u0001\u0005\t\u0005#\t)\u00021\u0001\u0003\u0016!A!qDA\u000b\u0001\u0004\u0011\u0019\u0003\u0003\u0005\u00030\u0005U\u0001\u0019\u0001B\u001a\u0003\u0011y'/[4\u0002\u0011=\u0014\u0018nZ0%KF$B!!9\u0007\u0018!Q!1\\A\r\u0003\u0003\u0005\rA!\n\u0002\u000b=\u0014\u0018n\u001a\u0011\u0015\t\u0019uaqD\u0007\u0003\u0003\u000fA\u0001b!5\u0002 \u0001\u0007!QE\u0001\u001bG>l\u0007\u000f\\3uK\u0006sgn\u001c;bi&|g\u000eV8TiJLgn\u001a\u000b\u0005\u0005\u007f2)\u0003\u0003\u0005\u0004D\u0005\r\u0002\u0019AA\u0000\u0005)\teN\\8uCRLwN\\\u0001\u000b\u0003:tw\u000e^1uS>t\u0007\u0003\u0002B\u0001\u0003/\u001bB!a&\u00070A!!\u0011\u0001D\u0019\u0013\u00111\u0019$!7\u0003'\u0005sgn\u001c;bi&|g.\u0012=ue\u0006\u001cGo\u001c:\u0015\u0005\u0019-B\u0003\u0003D\u001d\rw1iDb\u0010\u0011\t\t\u0005\u00111\u0013\u0005\t\u0007c\u000bY\n1\u0001\u0003\u0016!A11WAN\u0001\u0004\u0011\u0019\u0003\u0003\u0005\u00046\u0006m\u0005\u0019AB])\u00111\u0019Eb\u0012\u0011\r\u0005-GQ\u0007D#!)\tY-\":\u0003\u0016\t\r2\u0011\u0018\u0005\t\u0005[\u000bi\n1\u0001\u0007:\u0005i\u0011I\u001c8pi\u0006$\u0018n\u001c8UC\u001e,\"A\"\u0014\u0011\r\u0011-HQ^A\u0000\u0003A\tgN\\8uCRLwN\u001c+p)J,W\r\u0006\u0003\u0003&\u0019M\u0003\u0002CC{\u0003C\u0003\rA\"\u000f\u0002!Q\u0014X-\u001a+p\u0003:tw\u000e^1uS>tG\u0003\u0002D\u001d\r3B\u0001Bb\u0017\u0002$\u0002\u0007!QE\u0001\u0005iJ,W-\u0001\u000bV]6\f\u0007\u000f]1cY\u0016\feN\\8uCRLwN\u001c\t\u0005\u0005\u0003\t9K\u0001\u000bV]6\f\u0007\u000f]1cY\u0016\feN\\8uCRLwN\\\n\u0005\u0003O3I\u0001\u0006\u0002\u0007`\t\u0019RI\u001d:p]\u0016|Wo]!o]>$\u0018\r^5p]N!\u00111\u0016D\u0005)\t1i\u0007\u0005\u0003\u0003\u0002\u0005-\u0016a\u0004+ie><h.\u0012=dKB$\u0018n\u001c8\u0011\t\t\u0005\u0011\u0011\u0017\u0002\u0010)\"\u0014xn\u001e8Fq\u000e,\u0007\u000f^5p]N!\u0011\u0011WAe)\t1\t\b\u0006\u0003\u0007|\u0019u\u0004CBAf\tk\u0011)\u0002\u0003\u0005\u0006v\u0006U\u0006\u0019AA\u0000!\u00111\tIb!\u000e\u0005\u0005e\u0016\u0002\u0002DC\u0003s\u00131bU=nE>dG+\u00192mK\u0002")
public interface AnnotationInfos
extends Annotations {
    public AnnotationInfos$UnmappableAnnotArg$ UnmappableAnnotArg();

    public AnnotationInfos$LiteralAnnotArg$ LiteralAnnotArg();

    public AnnotationInfos$ArrayAnnotArg$ ArrayAnnotArg();

    public AnnotationInfos$NestedAnnotArg$ NestedAnnotArg();

    public AnnotationInfos$ScalaSigBytes$ ScalaSigBytes();

    public AnnotationInfos$AnnotationInfo$ AnnotationInfo();

    @Override
    public AnnotationInfos$Annotation$ Annotation();

    public AnnotationInfos$UnmappableAnnotation$ UnmappableAnnotation();

    public AnnotationInfos$ThrownException$ ThrownException();

    public void scala$reflect$internal$AnnotationInfos$_setter_$JavaArgumentTag_$eq(ClassTag<ClassfileAnnotArg> var1);

    public void scala$reflect$internal$AnnotationInfos$_setter_$LiteralArgument_$eq(AnnotationInfos$LiteralAnnotArg$ var1);

    public void scala$reflect$internal$AnnotationInfos$_setter_$LiteralArgumentTag_$eq(ClassTag<LiteralAnnotArg> var1);

    public void scala$reflect$internal$AnnotationInfos$_setter_$ArrayArgument_$eq(AnnotationInfos$ArrayAnnotArg$ var1);

    public void scala$reflect$internal$AnnotationInfos$_setter_$ArrayArgumentTag_$eq(ClassTag<ArrayAnnotArg> var1);

    public void scala$reflect$internal$AnnotationInfos$_setter_$NestedArgument_$eq(AnnotationInfos$NestedAnnotArg$ var1);

    public void scala$reflect$internal$AnnotationInfos$_setter_$NestedArgumentTag_$eq(ClassTag<NestedAnnotArg> var1);

    public void scala$reflect$internal$AnnotationInfos$_setter_$AnnotationTag_$eq(ClassTag<AnnotationInfo> var1);

    public ClassTag<ClassfileAnnotArg> JavaArgumentTag();

    @Override
    public AnnotationInfos$LiteralAnnotArg$ LiteralArgument();

    public ClassTag<LiteralAnnotArg> LiteralArgumentTag();

    @Override
    public AnnotationInfos$ArrayAnnotArg$ ArrayArgument();

    public ClassTag<ArrayAnnotArg> ArrayArgumentTag();

    @Override
    public AnnotationInfos$NestedAnnotArg$ NestedArgument();

    public ClassTag<NestedAnnotArg> NestedArgumentTag();

    public static /* synthetic */ String completeAnnotationToString$(AnnotationInfos $this, AnnotationInfo annInfo) {
        return $this.completeAnnotationToString(annInfo);
    }

    default public String completeAnnotationToString(AnnotationInfo annInfo) {
        String s_args = !annInfo.args().isEmpty() ? annInfo.args().mkString("(", ", ", ")") : "";
        String s_assocs = !annInfo.assocs().isEmpty() ? ((TraversableOnce)annInfo.assocs().map((Function1<Tuple2, String> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 == null) {
                throw new MatchError((Object)null);
            }
            Names.Name x = (Names.Name)x0$1._1();
            ClassfileAnnotArg y = (ClassfileAnnotArg)x0$1._2();
            String string = new StringBuilder(0).append(Predef$any2stringadd$.MODULE$.$plus$extension(Predef$.MODULE$.any2stringadd(x), " = ")).append(y).toString();
            return string;
        }, List$.MODULE$.canBuildFrom())).mkString("(", ", ", ")") : "";
        return new StringBuilder(0).append(annInfo.atp()).append(s_args).append(s_assocs).toString();
    }

    public ClassTag<AnnotationInfo> AnnotationTag();

    public static /* synthetic */ Trees.Tree annotationToTree$(AnnotationInfos $this, AnnotationInfo ann) {
        return $this.annotationToTree(ann);
    }

    default public Trees.Tree annotationToTree(AnnotationInfo ann) {
        Trees.Select ctorSelection = new Trees.Select((SymbolTable)this, new Trees.New((SymbolTable)this, ((Trees)((Object)this)).TypeTree(ann.atp())), ((StdNames)((Object)this)).nme().CONSTRUCTOR());
        return new Trees.Apply((SymbolTable)this, ctorSelection, this.reverseEngineerArgs$1(ann)).setType(ann.atp());
    }

    public static /* synthetic */ AnnotationInfo treeToAnnotation$(AnnotationInfos $this, Trees.Tree tree) {
        return $this.treeToAnnotation(tree);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public AnnotationInfo treeToAnnotation(Trees.Tree tree) {
        AnnotationInfo annotationInfo;
        Types.Type atp;
        if (!(tree instanceof Trees.Apply)) throw new Exception("unexpected tree shape: only q\"new $annType(..$args)\" is supported");
        Trees.Apply apply2 = (Trees.Apply)tree;
        Trees.Tree tree2 = apply2.fun();
        List<Trees.Tree> args2 = apply2.args();
        if (!(tree2 instanceof Trees.Select)) throw new Exception("unexpected tree shape: only q\"new $annType(..$args)\" is supported");
        Trees.Select select = (Trees.Select)tree2;
        Trees.Tree tree3 = select.qualifier();
        Names.Name name = select.name();
        if (!(tree3 instanceof Trees.New)) throw new Exception("unexpected tree shape: only q\"new $annType(..$args)\" is supported");
        Trees.Tree tpt = ((Trees.New)tree3).tpt();
        Names.TermName termName = ((StdNames)((Object)this)).nme().CONSTRUCTOR();
        if (termName == null) {
            if (name != null) {
                throw new Exception("unexpected tree shape: only q\"new $annType(..$args)\" is supported");
            }
        } else if (!termName.equals(name)) throw new Exception("unexpected tree shape: only q\"new $annType(..$args)\" is supported");
        if ((atp = tpt.tpe()) != null && atp.typeSymbol().isNonBottomSubClass(((Definitions)((Object)this)).definitions().StaticAnnotationClass())) {
            annotationInfo = this.AnnotationInfo().apply(atp, args2, Nil$.MODULE$);
            return annotationInfo;
        } else {
            if (atp == null) throw new Exception(new StringBuilder(102).append("unexpected annotation type ").append(atp).append(": only subclasses of StaticAnnotation and ClassfileAnnotation are supported").toString());
            if (!atp.typeSymbol().isNonBottomSubClass(((Definitions)((Object)this)).definitions().ClassfileAnnotationClass())) throw new Exception(new StringBuilder(102).append("unexpected annotation type ").append(atp).append(": only subclasses of StaticAnnotation and ClassfileAnnotation are supported").toString());
            annotationInfo = this.AnnotationInfo().apply(atp, Nil$.MODULE$, this.encodeJavaArgs$1(args2));
        }
        return annotationInfo;
    }

    private Trees.Tree reverseEngineerArg$1(ClassfileAnnotArg jarg2) {
        Trees.Tree tree;
        if (jarg2 instanceof LiteralAnnotArg) {
            Constants.Constant constant = ((LiteralAnnotArg)jarg2).const();
            Types.Type tpe = constant.tag() == 1 ? ((Definitions)((Object)this)).definitions().UnitTpe() : ((Types)((Object)this)).ConstantType().apply(constant);
            tree = new Trees.Literal((SymbolTable)this, constant).setType(tpe);
        } else if (jarg2 instanceof ArrayAnnotArg) {
            ClassfileAnnotArg[] jargs = ((ArrayAnnotArg)jarg2).args();
            Trees.Tree[] args2 = (Trees.Tree[])TraversableLike.map$(new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])jargs)), (Function1<ClassfileAnnotArg, Trees.Tree> & java.io.Serializable & Serializable)jarg -> this.reverseEngineerArg$1((ClassfileAnnotArg)jarg), Array$.MODULE$.canBuildFrom(((Trees)((Object)this)).TreeTag()));
            tree = new Trees.Apply((SymbolTable)this, ((Trees)((Object)this)).Ident(((Definitions)((Object)this)).definitions().ArrayModule()), new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])args2)).toList());
        } else {
            AnnotationInfo ann;
            tree = jarg2 instanceof NestedAnnotArg && (ann = ((NestedAnnotArg)jarg2).annInfo()) != null ? this.annotationToTree(ann) : ((Trees)((Object)this)).EmptyTree();
        }
        return tree;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private List reverseEngineerArgs$2(List jargs) {
        void var2_10;
        if (jargs instanceof $colon$colon) {
            $colon$colon $colon$colon = ($colon$colon)jargs;
            Tuple2 tuple2 = (Tuple2)$colon$colon.head();
            List rest = $colon$colon.tl$access$1();
            if (tuple2 != null) {
                Names.Name name = (Names.Name)tuple2._1();
                ClassfileAnnotArg jarg = (ClassfileAnnotArg)tuple2._2();
                Trees.AssignOrNamedArg assignOrNamedArg = new Trees.AssignOrNamedArg((SymbolTable)this, new Trees.Ident((SymbolTable)this, name), this.reverseEngineerArg$1(jarg));
                List<Trees.AssignOrNamedArg> list = this.reverseEngineerArgs$2(rest).$colon$colon(assignOrNamedArg);
                return var2_10;
            }
        }
        if (!((Object)Nil$.MODULE$).equals(jargs)) throw new MatchError(jargs);
        Nil$ nil$ = Nil$.MODULE$;
        return var2_10;
    }

    private List reverseEngineerArgs$1(AnnotationInfo ann$1) {
        if (ann$1.javaArgs().isEmpty()) {
            return ann$1.scalaArgs();
        }
        return this.reverseEngineerArgs$2(ann$1.javaArgs().toList());
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private ClassfileAnnotArg encodeJavaArg$1(Trees.Tree arg2) {
        void var2_8;
        boolean bl = false;
        Trees.Apply apply2 = null;
        if (arg2 instanceof Trees.Literal) {
            Constants.Constant constant = ((Trees.Literal)arg2).value();
            LiteralAnnotArg literalAnnotArg = new LiteralAnnotArg((SymbolTable)this, constant);
            return var2_8;
        }
        if (arg2 instanceof Trees.Apply) {
            bl = true;
            apply2 = (Trees.Apply)arg2;
            Trees.Tree tree = apply2.fun();
            List<Trees.Tree> args2 = apply2.args();
            Symbols.ModuleSymbol moduleSymbol = ((Definitions)((Object)this)).definitions().ArrayModule();
            if (!(moduleSymbol != null ? !moduleSymbol.equals(tree) : tree != null)) {
                ArrayAnnotArg arrayAnnotArg = new ArrayAnnotArg((SymbolTable)this, (ClassfileAnnotArg[])((TraversableOnce)args2.map((Function1<Trees.Tree, ClassfileAnnotArg> & java.io.Serializable & Serializable)arg -> this.encodeJavaArg$1((Trees.Tree)arg), List$.MODULE$.canBuildFrom())).toArray(this.JavaArgumentTag()));
                return var2_8;
            }
        }
        if (!bl) throw new Exception(new StringBuilder(86).append("unexpected java argument shape ").append(arg2).append(": literals, arrays and nested annotations are supported").toString());
        Trees.Tree tree = apply2.fun();
        if (!(tree instanceof Trees.Select)) throw new Exception(new StringBuilder(86).append("unexpected java argument shape ").append(arg2).append(": literals, arrays and nested annotations are supported").toString());
        Trees.Select select = (Trees.Select)tree;
        Trees.Tree tree2 = select.qualifier();
        Names.Name name = select.name();
        if (!(tree2 instanceof Trees.New)) throw new Exception(new StringBuilder(86).append("unexpected java argument shape ").append(arg2).append(": literals, arrays and nested annotations are supported").toString());
        Names.TermName termName = ((StdNames)((Object)this)).nme().CONSTRUCTOR();
        if (termName == null) {
            if (name != null) {
                throw new Exception(new StringBuilder(86).append("unexpected java argument shape ").append(arg2).append(": literals, arrays and nested annotations are supported").toString());
            }
        } else if (!termName.equals(name)) throw new Exception(new StringBuilder(86).append("unexpected java argument shape ").append(arg2).append(": literals, arrays and nested annotations are supported").toString());
        NestedAnnotArg nestedAnnotArg = new NestedAnnotArg((SymbolTable)this, this.treeToAnnotation(arg2));
        return var2_8;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private List encodeJavaArgs$1(List args2) {
        void var2_13;
        boolean bl = false;
        $colon$colon $colon$colon = null;
        if (args2 instanceof $colon$colon) {
            bl = true;
            $colon$colon = ($colon$colon)args2;
            Trees.Tree tree = (Trees.Tree)$colon$colon.head();
            List rest = $colon$colon.tl$access$1();
            if (tree instanceof Trees.AssignOrNamedArg) {
                Trees.AssignOrNamedArg assignOrNamedArg = (Trees.AssignOrNamedArg)tree;
                Trees.Tree tree2 = assignOrNamedArg.lhs();
                Trees.Tree arg = assignOrNamedArg.rhs();
                if (tree2 instanceof Trees.Ident) {
                    Names.Name name = ((Trees.Ident)tree2).name();
                    Tuple2<Names.Name, ClassfileAnnotArg> tuple2 = new Tuple2<Names.Name, ClassfileAnnotArg>(name, this.encodeJavaArg$1(arg));
                    List<Tuple2<Names.Name, ClassfileAnnotArg>> list = this.encodeJavaArgs$1(rest).$colon$colon(tuple2);
                    return var2_13;
                }
            }
        }
        if (bl) {
            Trees.Tree arg = (Trees.Tree)$colon$colon.head();
            throw new Exception(new StringBuilder(74).append("unexpected java argument shape ").append(arg).append(": only AssignOrNamedArg trees are supported").toString());
        }
        if (!((Object)Nil$.MODULE$).equals(args2)) throw new MatchError(args2);
        Nil$ nil$ = Nil$.MODULE$;
        return var2_13;
    }

    public static void $init$(AnnotationInfos $this) {
        $this.scala$reflect$internal$AnnotationInfos$_setter_$JavaArgumentTag_$eq(ClassTag$.MODULE$.apply(ClassfileAnnotArg.class));
        $this.scala$reflect$internal$AnnotationInfos$_setter_$LiteralArgument_$eq($this.LiteralAnnotArg());
        $this.scala$reflect$internal$AnnotationInfos$_setter_$LiteralArgumentTag_$eq(ClassTag$.MODULE$.apply(LiteralAnnotArg.class));
        $this.scala$reflect$internal$AnnotationInfos$_setter_$ArrayArgument_$eq($this.ArrayAnnotArg());
        $this.scala$reflect$internal$AnnotationInfos$_setter_$ArrayArgumentTag_$eq(ClassTag$.MODULE$.apply(ArrayAnnotArg.class));
        $this.scala$reflect$internal$AnnotationInfos$_setter_$NestedArgument_$eq($this.NestedAnnotArg());
        $this.scala$reflect$internal$AnnotationInfos$_setter_$NestedArgumentTag_$eq(ClassTag$.MODULE$.apply(NestedAnnotArg.class));
        $this.scala$reflect$internal$AnnotationInfos$_setter_$AnnotationTag_$eq(ClassTag$.MODULE$.apply(AnnotationInfo.class));
    }

    public interface Annotatable<Self> {
        public List<AnnotationInfo> annotations();

        public Self setAnnotations(List<AnnotationInfo> var1);

        public Self withAnnotations(List<AnnotationInfo> var1);

        public Self filterAnnotations(Function1<AnnotationInfo, Object> var1);

        public Self withoutAnnotations();

        public static /* synthetic */ List staticAnnotations$(Annotatable $this) {
            return $this.staticAnnotations();
        }

        default public List<AnnotationInfo> staticAnnotations() {
            return (List)this.annotations().filter((Function1<AnnotationInfo, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(x$1.isStatic()));
        }

        public static /* synthetic */ Object addThrowsAnnotation$(Annotatable $this, Symbols.Symbol throwableSym) {
            return $this.addThrowsAnnotation(throwableSym);
        }

        default public Self addThrowsAnnotation(Symbols.Symbol throwableSym) {
            Types.Type type;
            if (throwableSym.isMonomorphicType()) {
                type = throwableSym.tpe();
            } else {
                ((SymbolTable)this.scala$reflect$internal$AnnotationInfos$Annotatable$$$outer()).debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(62).append("Encountered polymorphic exception `").append(throwableSym.fullName()).append("` while parsing class file.").toString());
                type = ((Types)((Object)this.scala$reflect$internal$AnnotationInfos$Annotatable$$$outer())).existentialAbstraction(throwableSym.typeParams(), throwableSym.tpe());
            }
            Types.Type throwableTpe = type;
            return this.withAnnotation(this.scala$reflect$internal$AnnotationInfos$Annotatable$$$outer().AnnotationInfo().apply(((Types)((Object)this.scala$reflect$internal$AnnotationInfos$Annotatable$$$outer())).appliedType((Symbols.Symbol)((Definitions)((Object)this.scala$reflect$internal$AnnotationInfos$Annotatable$$$outer())).definitions().ThrowsClass(), Nil$.MODULE$.$colon$colon(throwableTpe)), new $colon$colon<Nothing$>((Nothing$)((Object)new Trees.Literal((SymbolTable)this.scala$reflect$internal$AnnotationInfos$Annotatable$$$outer(), new Constants.Constant((SymbolTable)this.scala$reflect$internal$AnnotationInfos$Annotatable$$$outer(), throwableTpe))), Nil$.MODULE$), Nil$.MODULE$));
        }

        public static /* synthetic */ boolean hasAnnotation$(Annotatable $this, Symbols.Symbol cls) {
            return $this.hasAnnotation(cls);
        }

        default public boolean hasAnnotation(Symbols.Symbol cls) {
            return this.dropOtherAnnotations(this.annotations(), cls) != Nil$.MODULE$;
        }

        public static /* synthetic */ Option getAnnotation$(Annotatable $this, Symbols.Symbol cls) {
            return $this.getAnnotation(cls);
        }

        default public Option<AnnotationInfo> getAnnotation(Symbols.Symbol cls) {
            Option option;
            List<AnnotationInfo> list = this.dropOtherAnnotations(this.annotations(), cls);
            if (list instanceof $colon$colon) {
                AnnotationInfo ann = (AnnotationInfo)(($colon$colon)list).head();
                option = new Some<AnnotationInfo>(ann);
            } else {
                option = None$.MODULE$;
            }
            return option;
        }

        public static /* synthetic */ Object removeAnnotation$(Annotatable $this, Symbols.Symbol cls) {
            return $this.removeAnnotation(cls);
        }

        default public Self removeAnnotation(Symbols.Symbol cls) {
            return this.filterAnnotations((Function1<AnnotationInfo, Object> & java.io.Serializable & Serializable)ann -> BoxesRunTime.boxToBoolean(Annotatable.$anonfun$removeAnnotation$1(cls, ann)));
        }

        public static /* synthetic */ Object withAnnotation$(Annotatable $this, AnnotationInfo annot) {
            return $this.withAnnotation(annot);
        }

        default public Self withAnnotation(AnnotationInfo annot) {
            return this.withAnnotations(new $colon$colon<Nothing$>((Nothing$)((Object)annot), Nil$.MODULE$));
        }

        private List<AnnotationInfo> dropOtherAnnotations(List<AnnotationInfo> anns, Symbols.Symbol cls) {
            List list;
            block4: {
                while (anns instanceof $colon$colon) {
                    $colon$colon $colon$colon = ($colon$colon)anns;
                    AnnotationInfo ann = (AnnotationInfo)$colon$colon.head();
                    List rest = $colon$colon.tl$access$1();
                    if (!ann.matches(cls)) {
                        anns = rest;
                        continue;
                    }
                    list = anns;
                    break block4;
                }
                if (((Object)Nil$.MODULE$).equals(anns)) {
                    list = Nil$.MODULE$;
                } else {
                    throw new MatchError(anns);
                }
            }
            return list;
        }

        public /* synthetic */ AnnotationInfos scala$reflect$internal$AnnotationInfos$Annotatable$$$outer();

        public static /* synthetic */ boolean $anonfun$removeAnnotation$1(Symbols.Symbol cls$1, AnnotationInfo ann) {
            return !ann.matches(cls$1);
        }

        public static void $init$(Annotatable $this) {
        }
    }

    public static abstract class AnnotationInfo
    implements Annotations.AnnotationApi {
        private boolean isTrivial;
        private Position rawpos;
        private volatile boolean bitmap$0;
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public Trees.TreeApi tree() {
            return Annotations.AnnotationApi.tree$(this);
        }

        public abstract Types.Type atp();

        public abstract List<Trees.Tree> args();

        public abstract List<Tuple2<Names.Name, ClassfileAnnotArg>> assocs();

        @Override
        public Types.Type tpe() {
            return this.atp();
        }

        public List<Trees.Tree> scalaArgs() {
            return this.args();
        }

        public ListMap<Names.Name, ClassfileAnnotArg> javaArgs() {
            return (ListMap)ListMap$.MODULE$.apply(this.assocs());
        }

        public abstract Trees.Tree original();

        public abstract AnnotationInfo setOriginal(Trees.Tree var1);

        private boolean isTrivial$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.isTrivial = this.atp().isTrivial() && !this.hasArgWhich((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x$4 -> BoxesRunTime.boxToBoolean(AnnotationInfo.$anonfun$isTrivial$1(x$4)));
                    this.bitmap$0 = true;
                }
            }
            return this.isTrivial;
        }

        public boolean isTrivial() {
            if (!this.bitmap$0) {
                return this.isTrivial$lzycompute();
            }
            return this.isTrivial;
        }

        private Position rawpos() {
            return this.rawpos;
        }

        private void rawpos_$eq(Position x$1) {
            this.rawpos = x$1;
        }

        public Position pos() {
            return this.rawpos();
        }

        public AnnotationInfo setPos(Position pos) {
            this.rawpos_$eq(pos);
            return this;
        }

        public void completeInfo() {
        }

        public Symbols.Symbol symbol() {
            return this.atp().typeSymbol();
        }

        public List<AnnotationInfo> metaAnnotations() {
            Types.Type type = this.atp();
            List list = type instanceof Types.AnnotatedType ? ((Types.AnnotatedType)type).annotations() : Nil$.MODULE$;
            return list;
        }

        public List<Symbols.Symbol> defaultTargets() {
            return (List)((TraversableLike)this.symbol().initialize().annotations().map((Function1<AnnotationInfo, Symbols.Symbol> & java.io.Serializable & Serializable)x$5 -> x$5.symbol(), List$.MODULE$.canBuildFrom())).filter((Function1<Symbols.Symbol, Object> & java.io.Serializable & Serializable)sym -> BoxesRunTime.boxToBoolean(AnnotationInfo.$anonfun$defaultTargets$2(this, sym)));
        }

        public boolean matches(Symbols.Symbol clazz) {
            return !(this.symbol() instanceof Symbols.StubSymbol) && this.symbol().isNonBottomSubClass(clazz);
        }

        public boolean hasArgWhich(Function1<Trees.Tree, Object> p) {
            boolean bl;
            block3: {
                List<Trees.Tree> list = this.args();
                if (list == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = list;
                while (!exists_these.isEmpty()) {
                    if (((Trees.Tree)exists_these.head()).exists(p)) {
                        bl = true;
                        break block3;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl = false;
            }
            return bl;
        }

        public boolean isErroneous() {
            block9: {
                block8: {
                    boolean bl;
                    block7: {
                        if (this.atp().isErroneous()) break block8;
                        List<Trees.Tree> list = this.args();
                        if (list == null) {
                            throw null;
                        }
                        LinearSeqOptimized exists_these = list;
                        while (!exists_these.isEmpty()) {
                            if (((Trees.Tree)exists_these.head()).isErroneous()) {
                                bl = true;
                                break block7;
                            }
                            exists_these = (LinearSeqOptimized)exists_these.tail();
                        }
                        bl = false;
                    }
                    if (!bl) break block9;
                }
                return true;
            }
            return false;
        }

        public boolean isStatic() {
            return this.symbol().isNonBottomSubClass(this.scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer().definitions().StaticAnnotationClass());
        }

        public boolean refsSymbol(Symbols.Symbol sym) {
            return this.hasArgWhich((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x$8 -> BoxesRunTime.boxToBoolean(AnnotationInfo.$anonfun$refsSymbol$1(sym, x$8)));
        }

        public Option<String> stringArg(int index) {
            Option<Constants.Constant> option = this.constantAtIndex(index);
            if (option == null) {
                throw null;
            }
            Option<Constants.Constant> map_this = option;
            Option option2 = map_this.isEmpty() ? None$.MODULE$ : new Some<String>(map_this.get().stringValue());
            return option2;
        }

        public Option<Object> intArg(int index) {
            Option<Constants.Constant> option = this.constantAtIndex(index);
            if (option == null) {
                throw null;
            }
            Option<Constants.Constant> map_this = option;
            Option option2 = map_this.isEmpty() ? None$.MODULE$ : new Some<Integer>(BoxesRunTime.boxToInteger(map_this.get().intValue()));
            return option2;
        }

        public Option<Object> booleanArg(int index) {
            Option<Constants.Constant> option = this.constantAtIndex(index);
            if (option == null) {
                throw null;
            }
            Option<Constants.Constant> map_this = option;
            Option option2 = map_this.isEmpty() ? None$.MODULE$ : new Some<Boolean>(BoxesRunTime.boxToBoolean(map_this.get().booleanValue()));
            return option2;
        }

        /*
         * WARNING - void declaration
         */
        public Option<Names.TermName> symbolArg(int index) {
            void collect_pf;
            Option<Trees.Tree> option = this.argAtIndex(index);
            Serializable serializable = new Serializable(this){
                public static final long serialVersionUID = 0L;
                private final /* synthetic */ AnnotationInfo $outer;

                /*
                 * WARNING - void declaration
                 * Enabled aggressive block sorting
                 */
                public final <A1 extends Trees.Tree, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                    void var3_13;
                    if (x1 instanceof Trees.Apply) {
                        Trees.Apply apply2 = (Trees.Apply)x1;
                        Trees.Tree fun = apply2.fun();
                        List<Trees.Tree> list = apply2.args();
                        if (list instanceof $colon$colon) {
                            $colon$colon $colon$colon = ($colon$colon)list;
                            Trees.Tree tree = (Trees.Tree)$colon$colon.head();
                            List<B> list2 = $colon$colon.tl$access$1();
                            if (tree instanceof Trees.Literal) {
                                Constants.Constant str = ((Trees.Literal)tree).value();
                                if (((Object)Nil$.MODULE$).equals(list2)) {
                                    Symbols.Symbol symbol = fun.symbol();
                                    Symbols.TermSymbol termSymbol = this.$outer.scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer().definitions().Symbol_apply();
                                    if (!(symbol != null ? !symbol.equals(termSymbol) : termSymbol != null)) {
                                        Names.TermName termName = this.$outer.scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer().newTermName(str.stringValue());
                                        return var3_13;
                                    }
                                }
                            }
                        }
                    }
                    B1 B1 = function1.apply(x1);
                    return var3_13;
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                public final boolean isDefinedAt(Trees.Tree x1) {
                    if (!(x1 instanceof Trees.Apply)) return false;
                    Trees.Apply apply2 = (Trees.Apply)x1;
                    Trees.Tree fun = apply2.fun();
                    List<Trees.Tree> list = apply2.args();
                    if (!(list instanceof $colon$colon)) return false;
                    $colon$colon $colon$colon = ($colon$colon)list;
                    Trees.Tree tree = (Trees.Tree)$colon$colon.head();
                    List<B> list2 = $colon$colon.tl$access$1();
                    if (!(tree instanceof Trees.Literal)) return false;
                    if (!((Object)Nil$.MODULE$).equals(list2)) return false;
                    Symbols.Symbol symbol = fun.symbol();
                    Symbols.TermSymbol termSymbol = this.$outer.scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer().definitions().Symbol_apply();
                    if (symbol != null) {
                        if (!symbol.equals(termSymbol)) return false;
                        return true;
                    }
                    if (termSymbol == null) return true;
                    return false;
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                }
            };
            if (option == null) {
                throw null;
            }
            Option<Trees.Tree> collect_this = option;
            Option option2 = !collect_this.isEmpty() ? collect_pf.lift().apply(collect_this.get()) : None$.MODULE$;
            return option2;
        }

        /*
         * WARNING - void declaration
         */
        public Option<Constants.Constant> constantAtIndex(int index) {
            void collect_pf;
            Option<Trees.Tree> option = this.argAtIndex(index);
            Serializable serializable = new Serializable(null){
                public static final long serialVersionUID = 0L;

                public final <A1 extends Trees.Tree, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                    Constants.Constant constant = x1 instanceof Trees.Literal ? ((Trees.Literal)x1).value() : function1.apply(x1);
                    return (B1)constant;
                }

                public final boolean isDefinedAt(Trees.Tree x1) {
                    boolean bl = x1 instanceof Trees.Literal;
                    return bl;
                }
            };
            if (option == null) {
                throw null;
            }
            Option<Trees.Tree> collect_this = option;
            Option option2 = !collect_this.isEmpty() ? collect_pf.lift().apply(collect_this.get()) : None$.MODULE$;
            return option2;
        }

        public Option<Trees.Tree> argAtIndex(int index) {
            if (index < this.args().size()) {
                return new Some<Trees.Tree>(this.args().apply(index));
            }
            return None$.MODULE$;
        }

        public AnnotationInfo transformArgs(Function1<List<Trees.Tree>, List<Trees.Tree>> f) {
            return new CompleteAnnotationInfo(this.scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer(), this.atp(), f.apply(this.args()), this.assocs());
        }

        public int hashCode() {
            return Statics.anyHash(this.atp()) + Statics.anyHash(this.args()) + Statics.anyHash(this.assocs());
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean equals(Object other) {
            if (!(other instanceof AnnotationInfo)) return false;
            if (((AnnotationInfo)other).scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer() != this.scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer()) return false;
            AnnotationInfo annotationInfo = (AnnotationInfo)other;
            Types.Type type = this.atp();
            Types.Type type2 = annotationInfo.atp();
            if (type == null) {
                if (type2 != null) {
                    return false;
                }
            } else if (!type.equals(type2)) return false;
            List<Trees.Tree> list = this.args();
            List<Trees.Tree> list2 = annotationInfo.args();
            if (list == null) {
                if (list2 != null) {
                    return false;
                }
            } else if (!((Object)list).equals(list2)) return false;
            List<Tuple2<Names.Name, ClassfileAnnotArg>> list3 = this.assocs();
            List<Tuple2<Names.Name, ClassfileAnnotArg>> list4 = annotationInfo.assocs();
            if (list3 == null) {
                if (list4 == null) return true;
                return false;
            } else {
                if (!((Object)list3).equals(list4)) return false;
                return true;
            }
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer() {
            return this.$outer;
        }

        @Override
        public /* synthetic */ Annotations scala$reflect$api$Annotations$AnnotationApi$$$outer() {
            return this.scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer();
        }

        public static final /* synthetic */ boolean $anonfun$isTrivial$1(Trees.Tree x$4) {
            return x$4 instanceof Trees.This;
        }

        public static final /* synthetic */ boolean $anonfun$defaultTargets$2(AnnotationInfo $this, Symbols.Symbol sym) {
            return $this.scala$reflect$internal$AnnotationInfos$AnnotationInfo$$$outer().definitions().isMetaAnnotation(sym);
        }

        public static final /* synthetic */ boolean $anonfun$hasArgWhich$1(Function1 p$1, Trees.Tree x$6) {
            return x$6.exists(p$1);
        }

        public static final /* synthetic */ boolean $anonfun$refsSymbol$1(Symbols.Symbol sym$1, Trees.Tree x$8) {
            Symbols.Symbol symbol = x$8.symbol();
            return !(symbol != null ? !symbol.equals(sym$1) : sym$1 != null);
        }

        public AnnotationInfo(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Annotations.AnnotationApi.$init$(this);
            this.rawpos = $outer.NoPosition();
        }

        public static final /* synthetic */ Object $anonfun$hasArgWhich$1$adapted(Function1 p$1, Trees.Tree x$6) {
            return BoxesRunTime.boxToBoolean(x$6.exists(p$1));
        }

        public static final /* synthetic */ Object $anonfun$isErroneous$1$adapted(Trees.Tree x$7) {
            return BoxesRunTime.boxToBoolean(x$7.isErroneous());
        }

        public static final /* synthetic */ Object $anonfun$intArg$1$adapted(Constants.Constant x$10) {
            return BoxesRunTime.boxToInteger(x$10.intValue());
        }

        public static final /* synthetic */ Object $anonfun$booleanArg$1$adapted(Constants.Constant x$11) {
            return BoxesRunTime.boxToBoolean(x$11.booleanValue());
        }
    }

    public class ArrayAnnotArg
    extends ClassfileAnnotArg
    implements Annotations.ArrayArgumentApi,
    Serializable {
        private final ClassfileAnnotArg[] args;

        public ClassfileAnnotArg[] args() {
            return this.args;
        }

        public String toString() {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])this.args())).mkString("[", ", ", "]");
        }

        public ArrayAnnotArg copy(ClassfileAnnotArg[] args2) {
            return new ArrayAnnotArg(this.scala$reflect$internal$AnnotationInfos$ArrayAnnotArg$$$outer(), args2);
        }

        public ClassfileAnnotArg[] copy$default$1() {
            return this.args();
        }

        @Override
        public String productPrefix() {
            return "ArrayAnnotArg";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.args();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof ArrayAnnotArg;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof ArrayAnnotArg && ((ArrayAnnotArg)x$1).scala$reflect$internal$AnnotationInfos$ArrayAnnotArg$$$outer() == this.scala$reflect$internal$AnnotationInfos$ArrayAnnotArg$$$outer();
                    if (!bl) break block3;
                    ArrayAnnotArg arrayAnnotArg = (ArrayAnnotArg)x$1;
                    if (!(this.args() == arrayAnnotArg.args() && arrayAnnotArg.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$ArrayAnnotArg$$$outer() {
            return this.$outer;
        }

        public ArrayAnnotArg(SymbolTable $outer, ClassfileAnnotArg[] args2) {
            this.args = args2;
            super($outer);
        }
    }

    public static abstract class ClassfileAnnotArg
    implements Product,
    Annotations.JavaArgumentApi {
        public final /* synthetic */ SymbolTable $outer;

        @Override
        public Iterator<Object> productIterator() {
            return Product.productIterator$(this);
        }

        @Override
        public String productPrefix() {
            return Product.productPrefix$(this);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$ClassfileAnnotArg$$$outer() {
            return this.$outer;
        }

        public ClassfileAnnotArg(SymbolTable $outer) {
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
            Product.$init$(this);
        }
    }

    public class CompleteAnnotationInfo
    extends AnnotationInfo {
        private final Types.Type atp;
        private final List<Trees.Tree> args;
        private final List<Tuple2<Names.Name, ClassfileAnnotArg>> assocs;
        private Trees.Tree orig;

        @Override
        public Types.Type atp() {
            return this.atp;
        }

        @Override
        public List<Trees.Tree> args() {
            return this.args;
        }

        @Override
        public List<Tuple2<Names.Name, ClassfileAnnotArg>> assocs() {
            return this.assocs;
        }

        private Trees.Tree orig() {
            return this.orig;
        }

        private void orig_$eq(Trees.Tree x$1) {
            this.orig = x$1;
        }

        @Override
        public Trees.Tree original() {
            return this.orig();
        }

        @Override
        public CompleteAnnotationInfo setOriginal(Trees.Tree t) {
            this.orig_$eq(t);
            this.setPos(t.pos());
            return this;
        }

        public String toString() {
            return this.scala$reflect$internal$AnnotationInfos$CompleteAnnotationInfo$$$outer().completeAnnotationToString(this);
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$CompleteAnnotationInfo$$$outer() {
            return this.$outer;
        }

        /*
         * WARNING - void declaration
         */
        public CompleteAnnotationInfo(SymbolTable $outer, Types.Type atp, List<Trees.Tree> args2, List<Tuple2<Names.Name, ClassfileAnnotArg>> assocs) {
            void assert_assertion;
            boolean bl;
            this.atp = atp;
            this.args = args2;
            this.assocs = assocs;
            super($outer);
            boolean bl2 = bl = args2.isEmpty() || assocs.isEmpty();
            if ($outer == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw $outer.throwAssertionError(this.atp());
            }
            this.orig = $outer.EmptyTree();
        }
    }

    public class ErroneousAnnotation
    extends CompleteAnnotationInfo {
        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$ErroneousAnnotation$$$outer() {
            return this.$outer;
        }

        public ErroneousAnnotation(SymbolTable $outer) {
            super($outer, $outer.ErrorType(), Nil$.MODULE$, Nil$.MODULE$);
        }
    }

    public final class ExtraLazyAnnotationInfo
    extends LazyAnnotationInfo {
        private Symbols.Symbol typeSymbol;
        private Function0<Symbols.Symbol> sym;
        private volatile boolean bitmap$0;

        private Symbols.Symbol typeSymbol$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.typeSymbol = this.sym.apply();
                    this.bitmap$0 = true;
                }
            }
            this.sym = null;
            return this.typeSymbol;
        }

        private Symbols.Symbol typeSymbol() {
            if (!this.bitmap$0) {
                return this.typeSymbol$lzycompute();
            }
            return this.typeSymbol;
        }

        @Override
        public Symbols.Symbol symbol() {
            return this.typeSymbol();
        }

        public ExtraLazyAnnotationInfo(SymbolTable $outer, Function0<Symbols.Symbol> sym, Function0<AnnotationInfo> lazyInfo) {
            this.sym = sym;
            super($outer, lazyInfo);
        }
    }

    public class LazyAnnotationInfo
    extends AnnotationInfo {
        private AnnotationInfo forcedInfo;
        private Function0<AnnotationInfo> lazyInfo;
        private boolean forced;
        private volatile boolean bitmap$0;

        private boolean forced() {
            return this.forced;
        }

        private void forced_$eq(boolean x$1) {
            this.forced = x$1;
        }

        private AnnotationInfo forcedInfo$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    AnnotationInfo annotationInfo;
                    try {
                        annotationInfo = this.lazyInfo.apply();
                    }
                    finally {
                        this.forced_$eq(true);
                    }
                    this.forcedInfo = annotationInfo;
                    this.bitmap$0 = true;
                }
            }
            this.lazyInfo = null;
            return this.forcedInfo;
        }

        private AnnotationInfo forcedInfo() {
            if (!this.bitmap$0) {
                return this.forcedInfo$lzycompute();
            }
            return this.forcedInfo;
        }

        @Override
        public Types.Type atp() {
            return this.forcedInfo().atp();
        }

        @Override
        public List<Trees.Tree> args() {
            return this.forcedInfo().args();
        }

        @Override
        public List<Tuple2<Names.Name, ClassfileAnnotArg>> assocs() {
            return this.forcedInfo().assocs();
        }

        @Override
        public Trees.Tree original() {
            return this.forcedInfo().original();
        }

        @Override
        public LazyAnnotationInfo setOriginal(Trees.Tree t) {
            this.forcedInfo().setOriginal(t);
            return this;
        }

        public String toString() {
            if (this.forced()) {
                return this.forcedInfo().toString();
            }
            return "@<?>";
        }

        @Override
        public Position pos() {
            if (this.forced()) {
                return this.forcedInfo().pos();
            }
            return this.scala$reflect$internal$AnnotationInfos$LazyAnnotationInfo$$$outer().NoPosition();
        }

        @Override
        public void completeInfo() {
            this.forcedInfo();
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$LazyAnnotationInfo$$$outer() {
            return this.$outer;
        }

        public LazyAnnotationInfo(SymbolTable $outer, Function0<AnnotationInfo> lazyInfo) {
            this.lazyInfo = lazyInfo;
            super($outer);
            this.forced = false;
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public class LiteralAnnotArg
    extends ClassfileAnnotArg
    implements Annotations.LiteralArgumentApi,
    Serializable {
        private final Constants.Constant const;

        public Constants.Constant const() {
            return this.const;
        }

        @Override
        public Constants.Constant value() {
            return this.const();
        }

        public String toString() {
            return this.const().escapedStringValue();
        }

        public LiteralAnnotArg copy(Constants.Constant constant) {
            return new LiteralAnnotArg(this.scala$reflect$internal$AnnotationInfos$LiteralAnnotArg$$$outer(), constant);
        }

        public Constants.Constant copy$default$1() {
            return this.const();
        }

        @Override
        public String productPrefix() {
            return "LiteralAnnotArg";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.const();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof LiteralAnnotArg;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof LiteralAnnotArg && ((LiteralAnnotArg)x$1).scala$reflect$internal$AnnotationInfos$LiteralAnnotArg$$$outer() == this.scala$reflect$internal$AnnotationInfos$LiteralAnnotArg$$$outer();
                    if (!bl) break block3;
                    LiteralAnnotArg literalAnnotArg = (LiteralAnnotArg)x$1;
                    Constants.Constant constant = this.const();
                    Constants.Constant constant2 = literalAnnotArg.const();
                    if (!(!(constant != null ? !((Object)constant).equals(constant2) : constant2 != null) && literalAnnotArg.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$LiteralAnnotArg$$$outer() {
            return this.$outer;
        }

        public LiteralAnnotArg(SymbolTable $outer, Constants.Constant constant) {
            this.const = constant;
            super($outer);
        }
    }

    public class NestedAnnotArg
    extends ClassfileAnnotArg
    implements Annotations.NestedArgumentApi,
    Serializable {
        private final AnnotationInfo annInfo;

        public AnnotationInfo annInfo() {
            return this.annInfo;
        }

        @Override
        public AnnotationInfo annotation() {
            return this.annInfo();
        }

        public String toString() {
            return this.annInfo().toString();
        }

        public NestedAnnotArg copy(AnnotationInfo annInfo) {
            return new NestedAnnotArg(this.scala$reflect$internal$AnnotationInfos$NestedAnnotArg$$$outer(), annInfo);
        }

        public AnnotationInfo copy$default$1() {
            return this.annInfo();
        }

        @Override
        public String productPrefix() {
            return "NestedAnnotArg";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.annInfo();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof NestedAnnotArg;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof NestedAnnotArg && ((NestedAnnotArg)x$1).scala$reflect$internal$AnnotationInfos$NestedAnnotArg$$$outer() == this.scala$reflect$internal$AnnotationInfos$NestedAnnotArg$$$outer();
                    if (!bl) break block3;
                    NestedAnnotArg nestedAnnotArg = (NestedAnnotArg)x$1;
                    AnnotationInfo annotationInfo = this.annInfo();
                    AnnotationInfo annotationInfo2 = nestedAnnotArg.annInfo();
                    if (!(!(annotationInfo != null ? !((Object)annotationInfo).equals(annotationInfo2) : annotationInfo2 != null) && nestedAnnotArg.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$NestedAnnotArg$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ List $anonfun$new$1(NestedAnnotArg $this) {
            return $this.annInfo().args();
        }

        /*
         * WARNING - void declaration
         */
        public NestedAnnotArg(SymbolTable $outer, AnnotationInfo annInfo) {
            void assert_assertion;
            this.annInfo = annInfo;
            super($outer);
            boolean bl = annInfo.args().isEmpty();
            if ($outer == null) {
                throw null;
            }
            if (assert_assertion == false) {
                throw $outer.throwAssertionError(NestedAnnotArg.$anonfun$new$1(this));
            }
        }
    }

    public class ScalaSigBytes
    extends ClassfileAnnotArg
    implements Serializable {
        private byte[] sevenBitsMayBeZero;
        private final byte[] bytes;
        private volatile boolean bitmap$0;

        public byte[] bytes() {
            return this.bytes;
        }

        public String toString() {
            return new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])TraversableLike.map$(new ArrayOps.ofByte(Predef$.MODULE$.byteArrayOps(this.bytes())), (Function1<Object, String> & java.io.Serializable & Serializable)object -> ScalaSigBytes.$anonfun$toString$1(BoxesRunTime.unboxToByte(object)), Array$.MODULE$.canBuildFrom(ClassTag$.MODULE$.apply(String.class))))).mkString("[ ", " ", " ]");
        }

        private byte[] sevenBitsMayBeZero$lzycompute() {
            synchronized (this) {
                if (!this.bitmap$0) {
                    this.sevenBitsMayBeZero = this.mapToNextModSevenBits(ByteCodecs$.MODULE$.encode8to7(this.bytes()));
                    this.bitmap$0 = true;
                }
            }
            return this.sevenBitsMayBeZero;
        }

        public byte[] sevenBitsMayBeZero() {
            if (!this.bitmap$0) {
                return this.sevenBitsMayBeZero$lzycompute();
            }
            return this.sevenBitsMayBeZero;
        }

        public boolean fitsInOneString() {
            int numZeros = 0;
            for (int i = 0; i < this.sevenBitsMayBeZero().length; ++i) {
                if (this.sevenBitsMayBeZero()[i] != 0) continue;
                ++numZeros;
            }
            return this.sevenBitsMayBeZero().length + numZeros <= 65535;
        }

        public Types.Type sigAnnot() {
            if (this.fitsInOneString()) {
                return this.scala$reflect$internal$AnnotationInfos$ScalaSigBytes$$$outer().definitions().ScalaSignatureAnnotation().tpe();
            }
            return this.scala$reflect$internal$AnnotationInfos$ScalaSigBytes$$$outer().definitions().ScalaLongSignatureAnnotation().tpe();
        }

        private byte[] mapToNextModSevenBits(byte[] src) {
            int srclen = src.length;
            for (int i = 0; i < srclen; ++i) {
                byte in = src[i];
                src[i] = in == 127 ? (byte)0 : (byte)(in + 1);
            }
            return src;
        }

        public ScalaSigBytes copy(byte[] bytes) {
            return new ScalaSigBytes(this.scala$reflect$internal$AnnotationInfos$ScalaSigBytes$$$outer(), bytes);
        }

        public byte[] copy$default$1() {
            return this.bytes();
        }

        @Override
        public String productPrefix() {
            return "ScalaSigBytes";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.bytes();
                }
            }
            throw new IndexOutOfBoundsException(Integer.toString(x$1));
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof ScalaSigBytes;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof ScalaSigBytes && ((ScalaSigBytes)x$1).scala$reflect$internal$AnnotationInfos$ScalaSigBytes$$$outer() == this.scala$reflect$internal$AnnotationInfos$ScalaSigBytes$$$outer();
                    if (!bl) break block3;
                    ScalaSigBytes scalaSigBytes = (ScalaSigBytes)x$1;
                    if (!(this.bytes() == scalaSigBytes.bytes() && scalaSigBytes.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public /* synthetic */ SymbolTable scala$reflect$internal$AnnotationInfos$ScalaSigBytes$$$outer() {
            return this.$outer;
        }

        public static final /* synthetic */ String $anonfun$toString$1(byte by) {
            int n = by & 0xFF;
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return RichInt$.MODULE$.toHexString$extension(n);
        }

        public ScalaSigBytes(SymbolTable $outer, byte[] bytes) {
            this.bytes = bytes;
            super($outer);
        }
    }
}

