/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function0;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.Tuple3;
import scala.collection.AbstractSeq;
import scala.collection.AbstractTraversable;
import scala.collection.GenTraversable;
import scala.collection.LinearSeqOptimized;
import scala.collection.generic.GenericCompanion;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.Constants;
import scala.reflect.internal.Names;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.TreeInfo$Applied$;
import scala.reflect.internal.TreeInfo$DynamicApplication$;
import scala.reflect.internal.TreeInfo$DynamicApplicationNamed$;
import scala.reflect.internal.TreeInfo$DynamicUpdate$;
import scala.reflect.internal.TreeInfo$IsFalse$;
import scala.reflect.internal.TreeInfo$IsTrue$;
import scala.reflect.internal.TreeInfo$MacroImplReference$;
import scala.reflect.internal.TreeInfo$StripCast$;
import scala.reflect.internal.TreeInfo$Unapplied$;
import scala.reflect.internal.TreeInfo$WildcardStarArg$;
import scala.reflect.internal.Trees;
import scala.reflect.internal.Trees$EmptyTree$;
import scala.reflect.internal.Types;
import scala.reflect.internal.Types$NoPrefix$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001\u0015-b\u0001CA\r\u00037\t\t!!\u000b\t\u000f\u0005M\u0002\u0001\"\u0001\u00026!I\u00111\b\u0001C\u0002\u001b\u0005\u0011Q\b\u0005\b\u0003\u000b\u0002A\u0011AA$\u0011\u001d\t\t\u0007\u0001C\u0001\u0003GBq!a\u001a\u0001\t\u0003\tI\u0007C\u0004\u0002p\u0001!\t!!\u001d\t\u000f\u0005U\u0004\u0001\"\u0001\u0002x!9\u0011q\u0010\u0001\u0005\u0002\u0005\u0005\u0005bBAD\u0001\u0011%\u0011\u0011\u0012\u0005\b\u00033\u0003A\u0011BAN\u0011\u001d\tY\u000b\u0001C\u0005\u0003[Cq!!-\u0001\t\u0003\t\u0019\fC\u0004\u0002<\u0002!I!!0\t\u000f\u0005%\u0007\u0001\"\u0001\u0002L\"9\u0011q\u001a\u0001\u0005\u0002\u0005E\u0007bBAk\u0001\u0011\u0005\u0011q\u001b\u0005\b\u00037\u0004A\u0011AAo\u0011\u001d\t\t\u000f\u0001C\u0001\u0003GDq!a:\u0001\t\u0003\tI\u000fC\u0004\u0002n\u0002!\t!a<\t\u000f\t=\u0002\u0001\"\u0001\u00032!9!1\t\u0001\u0005\u0002\t\u0015\u0003b\u0002B%\u0001\u0011\u0005!1\n\u0005\b\u0005\u001f\u0002A\u0011\u0001B)\u0011\u001d\u0011)\u0006\u0001C\u0001\u0005/BqAa\u001a\u0001\t\u0003\u0011I\u0007C\u0004\u0003n\u0001!\tAa\u001c\t\u000f\tM\u0004\u0001\"\u0001\u0003v!9!\u0011\u0010\u0001\u0005\u0002\tm\u0004b\u0002B@\u0001\u0011\u0005!\u0011Q\u0004\b\u0005\u000b\u0003\u0001\u0012\u0001BD\r\u001d\u0011I\t\u0001E\u0001\u0005\u0017Cq!a\r!\t\u0003\u0011i\tC\u0004\u0003\u0010\u0002\"\tA!%\t\u000f\tm\u0005\u0001\"\u0001\u0003\u001e\"9!\u0011\u0015\u0001\u0005\u0002\t\r\u0006b\u0002BT\u0001\u0011\u0005!\u0011\u0016\u0005\b\u0005_\u0003A\u0011\u0001BY\u0011%\u0011)\f\u0001C\u0001\u00037\u00119\fC\u0005\u0003<\u0002!\t!a\u0007\u0003>\"I!q\u001b\u0001\u0005\u0002\u0005m!\u0011\u001c\u0005\n\u0005K\u0004A\u0011AA\u000e\u0005ODqAa<\u0001\t\u0003\u0011\t\u0010C\u0004\u0003x\u0002!\tA!?\t\u000f\tu\b\u0001\"\u0001\u0003\u0000\"91Q\u0001\u0001\u0005\u0002\r\u001d\u0001bBB\u0006\u0001\u0011\u00051Q\u0002\u0005\b\u0007#\u0001A\u0011AB\n\u0011\u001d\u00199\u0002\u0001C\u0001\u00073Aqaa\b\u0001\t\u0003\u0019\t\u0003C\u0004\u0004&\u0001!\taa\n\t\u000f\r-\u0002\u0001\"\u0001\u0004.!91Q\b\u0001\u0005\u0002\r}\u0002bBB#\u0001\u0011\u00051q\t\u0005\b\u0007\u0017\u0002A\u0011AB'\u000f\u001d\u0019\t\u0006\u0001E\u0001\u0007'2qa!\u0016\u0001\u0011\u0003\u00199\u0006C\u0004\u00024e\"\ta!\u0017\t\u000f\t=\u0015\b\"\u0001\u0004\\!91Q\r\u0001\u0005\u0002\r\u001d\u0004bBB:\u0001\u0011\u00051Q\u000f\u0005\b\u0007w\u0002A\u0011AB?\u0011\u001d\u0019\t\t\u0001C\u0001\u0007\u0007Cqaa\"\u0001\t\u0003\u0019I\tC\u0004\u0004\u0016\u0002!Iaa&\t\u000f\rm\u0005\u0001\"\u0001\u0004\u001e\"91\u0011\u0015\u0001\u0005\u0002\r\r\u0006bBBT\u0001\u0011\u00051\u0011\u0016\u0005\b\u0007[\u0003A\u0011ABX\u0011\u001d\u0019\u0019\f\u0001C\u0005\u0007kCqa!/\u0001\t\u0003\u0019Y\fC\u0004\u0004@\u0002!\ta!1\t\u000f\r\u0015\u0007\u0001\"\u0001\u0004H\"91Q\u001a\u0001\u0005\u0002\r=\u0007bBBj\u0001\u0011\u00051Q\u001b\u0005\b\u0007?\u0004A\u0011ABq\u0011%\u0019)\u000f\u0001b\u0001\n\u000b\u00199\u000f\u0003\u0005\u0004n\u0002\u0001\u000bQBBu\u0011\u001d\u0019y\u000f\u0001C\u0001\u0007cDqa!>\u0001\t\u0003\u00199\u0010C\u0004\u0004|\u0002!\ta!@\u0007\r\u0011\u0005\u0001A\u0001C\u0002\u0011)\t\tF\u0015BC\u0002\u0013\u0005AQ\u0001\u0005\u000b\t\u000f\u0011&\u0011!Q\u0001\n\u0005M\u0003bBA\u001a%\u0012\u0005A\u0011\u0002\u0005\b\t\u001f\u0011F\u0011\u0001C\u0003\u0011\u001d!\tB\u0015C\u0001\t\u000bAq\u0001b\u0005S\t\u0003!)\u0002C\u0004\u0005\u0018I#\t\u0001\"\u0007\t\u000f\u0011u\u0001\u0001\"\u0002\u0005 !9A1\u0005\u0001\u0005\u0006\u0011\u0015ra\u0002C\u001c\u0001!\u0005A\u0011\b\u0004\b\t\u0003\u0001\u0001\u0012\u0001C\u001e\u0011\u001d\t\u0019$\u0018C\u0001\t{Aq\u0001b\u0010^\t\u0003!\t\u0005C\u0004\u0003\u0010v#\t\u0001\"\u0012\t\u000f\t=U\f\"\u0001\u0005T!9Aq\u000b\u0001\u0005\u0002\u0011esa\u0002C1\u0001!\u0005A1\r\u0004\b\tK\u0002\u0001\u0012\u0001C4\u0011\u001d\t\u0019\u0004\u001aC\u0001\tSBqAa$e\t\u0003!Y\u0007C\u0004\u0005p\u0001!\t\u0001\"\u001d\t\u000f\u0011]\u0004\u0001\"\u0001\u0005z!9AQ\u0010\u0001\u0005\u0002\u0011}da\u0002CB\u0001\u0005\u0005AQ\u0011\u0005\b\u0003gQG\u0011\u0001CE\u0011\u001d!\u0019J\u001bD\t\t+CqAa$k\t\u0003!IjB\u0004\u0005\u001e\u0002A\t\u0001b(\u0007\u000f\u0011\u0005\u0006\u0001#\u0001\u0005$\"9\u00111G8\u0005\u0002\u0011\u001d\u0006b\u0002CJ_\u0012EA\u0011V\u0004\b\t[\u0003\u0001\u0012\u0001CX\r\u001d!\t\f\u0001E\u0001\tgCq!a\rt\t\u0003!)\fC\u0004\u0005\u0014N$\t\u0002b.\t\u000f\u0011m\u0006\u0001\"\u0001\u0005>\u001a1A\u0011\u0019\u0001\u0001\t\u0007D!\u0002\"2x\u0005\u0003\u0005\u000b\u0011\u0002Cd\u0011\u001d\t\u0019d\u001eC\u0001\t\u001bDqAa$x\t\u0003!\u0019nB\u0004\u0005`\u0002A\t\u0001\"9\u0007\u000f\u0011\r\b\u0001#\u0001\u0005f\"9\u00111\u0007?\u0005\u0002\u0011\u001dxa\u0002Cu\u0001!\u0005A1\u001e\u0004\b\t[\u0004\u0001\u0012\u0001Cx\u0011\u001d\t\u0019d C\u0001\tc<q\u0001b=\u0001\u0011\u0003!)PB\u0004\u0005x\u0002A\t\u0001\"?\t\u0011\u0005M\u0012Q\u0001C\u0001\tw<q\u0001\"@\u0001\u0011\u0003!yPB\u0004\u0006\u0002\u0001A\t!b\u0001\t\u0011\u0005M\u00121\u0002C\u0001\u000b\u000bA\u0001\"b\u0002\u0002\f\u0011%Q\u0011\u0002\u0005\t\u0005\u001f\u000bY\u0001\"\u0001\u0006\u000e!9Q\u0011\u0004\u0001\u0005\u0002\u0015m\u0001bBC\u0010\u0001\u0011\u0005Q\u0011\u0005\u0005\b\u000bK\u0001A\u0011AC\u0014\u0005!!&/Z3J]\u001a|'\u0002BA\u000f\u0003?\t\u0001\"\u001b8uKJt\u0017\r\u001c\u0006\u0005\u0003C\t\u0019#A\u0004sK\u001adWm\u0019;\u000b\u0005\u0005\u0015\u0012!B:dC2\f7\u0001A\n\u0004\u0001\u0005-\u0002\u0003BA\u0017\u0003_i!!a\t\n\t\u0005E\u00121\u0005\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\t\t9\u0004E\u0002\u0002:\u0001i!!a\u0007\u0002\r\u001ddwNY1m+\t\ty\u0004\u0005\u0003\u0002:\u0005\u0005\u0013\u0002BA\"\u00037\u00111bU=nE>dG+\u00192mK\u00061\u0012n\u001d#fG2\f'/\u0019;j_:|%\u000fV=qK\u0012+g\r\u0006\u0003\u0002J\u0005=\u0003\u0003BA\u0017\u0003\u0017JA!!\u0014\u0002$\t9!i\\8mK\u0006t\u0007bBA)\u0007\u0001\u0007\u00111K\u0001\u0005iJ,W\r\u0005\u0003\u0002V\u0005ecbAA,\u00055\t\u0001!\u0003\u0003\u0002\\\u0005u#\u0001\u0002+sK\u0016LA!a\u0018\u0002\u001c\t)AK]3fg\u0006\t\u0012n]%oi\u0016\u0014h-Y2f\u001b\u0016l'-\u001a:\u0015\t\u0005%\u0013Q\r\u0005\b\u0003#\"\u0001\u0019AA*\u0003aI7oQ8ogR\u0014Xo\u0019;pe^KG\u000f\u001b#fM\u0006,H\u000e\u001e\u000b\u0005\u0003\u0013\nY\u0007C\u0004\u0002n\u0015\u0001\r!a\u0015\u0002\u0003Q\f\u0011\"[:QkJ,G)\u001a4\u0015\t\u0005%\u00131\u000f\u0005\b\u0003#2\u0001\u0019AA*\u0003\u0019I7\u000fU1uQR1\u0011\u0011JA=\u0003wBq!!\u0015\b\u0001\u0004\t\u0019\u0006C\u0004\u0002~\u001d\u0001\r!!\u0013\u0002\u001b\u0005dGn\\<W_2\fG/\u001b7f\u0003II7o\u0015;bE2,\u0017\nZ3oi&4\u0017.\u001a:\u0015\r\u0005%\u00131QAC\u0011\u001d\t\t\u0006\u0003a\u0001\u0003'Bq!! \t\u0001\u0004\tI%A\u0003ts6|5\u000e\u0006\u0003\u0002J\u0005-\u0005bBAG\u0013\u0001\u0007\u0011qR\u0001\u0004gfl\u0007\u0003BA+\u0003#KA!a%\u0002\u0016\n11+_7c_2LA!a&\u0002\u001c\t91+_7c_2\u001c\u0018A\u0002;za\u0016|5\u000e\u0006\u0003\u0002J\u0005u\u0005bBAP\u0015\u0001\u0007\u0011\u0011U\u0001\u0003iB\u0004B!!\u0016\u0002$&!\u0011QUAT\u0005\u0011!\u0016\u0010]3\n\t\u0005%\u00161\u0004\u0002\u0006)f\u0004Xm]\u0001\u0012SN,fn\u00195fG.,Gm\u0015;bE2,G\u0003BA%\u0003_Cq!!$\f\u0001\u0004\ty)\u0001\tjgN#\u0018M\u00197f\u001b\u0016l'-\u001a:PMRA\u0011\u0011JA[\u0003o\u000bI\fC\u0004\u0002\u000e2\u0001\r!a$\t\u000f\u0005EC\u00021\u0001\u0002T!9\u0011Q\u0010\u0007A\u0002\u0005%\u0013!D5t'R\f'\r\\3JI\u0016tG\u000f\u0006\u0004\u0002J\u0005}\u0016q\u0019\u0005\b\u0003#j\u0001\u0019AAa!\u0011\t)&a1\n\t\u0005\u0015\u0017Q\f\u0002\u0006\u0013\u0012,g\u000e\u001e\u0005\b\u0003{j\u0001\u0019AA%\u0003=A\u0017m\u001d,pY\u0006$\u0018\u000e\\3UsB,G\u0003BA%\u0003\u001bDq!!\u0015\u000f\u0001\u0004\t\u0019&A\nbI6LGo\u001d+za\u0016\u001cV\r\\3di&|g\u000e\u0006\u0003\u0002J\u0005M\u0007bBA)\u001f\u0001\u0007\u00111K\u0001\u001aSN\u001cF/\u00192mK&#WM\u001c;jM&,'\u000fU1ui\u0016\u0014h\u000e\u0006\u0003\u0002J\u0005e\u0007bBA)!\u0001\u0007\u00111K\u0001\u0017SN\fV/\u00197jM&,'oU1gKR{W\t\\5eKR!\u0011\u0011JAp\u0011\u001d\t\t&\u0005a\u0001\u0003'\n!#[:FqB\u00148+\u00194f)>Le\u000e\\5oKR!\u0011\u0011JAs\u0011\u001d\t\tF\u0005a\u0001\u0003'\nA$[:QkJ,W\t\u001f9s\r>\u0014x+\u0019:oS:<\u0007+\u001e:q_N,7\u000f\u0006\u0003\u0002J\u0005-\bbBA)'\u0001\u0007\u00111K\u0001\u0017[\u0006\u0004X*\u001a;i_\u0012\u0004\u0016M]1ng\u0006sG-\u0011:hgV!\u0011\u0011\u001fB\u0004)\u0019\t\u0019Pa\t\u0003*Q!\u0011Q\u001fB\r!\u0019\t90!@\u0003\u00049!\u0011QFA}\u0013\u0011\tY0a\t\u0002\u000fA\f7m[1hK&!\u0011q B\u0001\u0005\u0011a\u0015n\u001d;\u000b\t\u0005m\u00181\u0005\t\u0005\u0005\u000b\u00119\u0001\u0004\u0001\u0005\u000f\t%AC1\u0001\u0003\f\t\t!+\u0005\u0003\u0003\u000e\tM\u0001\u0003BA\u0017\u0005\u001fIAA!\u0005\u0002$\t9aj\u001c;iS:<\u0007\u0003BA\u0017\u0005+IAAa\u0006\u0002$\t\u0019\u0011I\\=\t\u000f\tmA\u00031\u0001\u0003\u001e\u0005\ta\r\u0005\u0006\u0002.\t}\u0011qRA*\u0005\u0007IAA!\t\u0002$\tIa)\u001e8di&|gN\r\u0005\b\u0005K!\u0002\u0019\u0001B\u0014\u0003\u0019\u0001\u0018M]1ngB1\u0011q_A\u007f\u0003\u001fCqAa\u000b\u0015\u0001\u0004\u0011i#\u0001\u0003be\u001e\u001c\bCBA|\u0003{\f\u0019&\u0001\rg_J,\u0017m\u00195NKRDw\u000e\u001a)be\u0006l\u0017I\u001c3Be\u001e$bAa\r\u0003@\t\u0005C\u0003BA%\u0005kAqAa\u0007\u0016\u0001\u0004\u00119\u0004\u0005\u0006\u0002.\t}\u0011qRA*\u0005s\u0001B!!\f\u0003<%!!QHA\u0012\u0005\u0011)f.\u001b;\t\u000f\t\u0015R\u00031\u0001\u0003(!9!1F\u000bA\u0002\t5\u0012AG5t\rVt7\r^5p]6K7o]5oOB\u000b'/Y7UsB,G\u0003BA%\u0005\u000fBq!!\u0015\u0017\u0001\u0004\t\u0019&\u0001\bnCf\u0014UMV1s\u000f\u0016$H/\u001a:\u0015\t\u0005%#Q\n\u0005\b\u0003\u001b;\u0002\u0019AAH\u0003II7OV1sS\u0006\u0014G.Z(s\u000f\u0016$H/\u001a:\u0015\t\u0005%#1\u000b\u0005\b\u0003#B\u0002\u0019AA*\u0003)qwNR5fY\u00124uN\u001d\u000b\u0007\u0003\u0013\u0012IFa\u0019\t\u000f\tm\u0013\u00041\u0001\u0003^\u0005\u0011a\u000f\u001a\t\u0005\u0003+\u0012y&\u0003\u0003\u0003b\u0005u#A\u0002,bY\u0012+g\rC\u0004\u0003fe\u0001\r!a$\u0002\u000b=<h.\u001a:\u0002\u001f%\u001cH)\u001a4bk2$x)\u001a;uKJ$B!!\u0013\u0003l!9\u0011\u0011\u000b\u000eA\u0002\u0005M\u0013\u0001E5t'\u0016dgmQ8ogR\u00148)\u00197m)\u0011\tIE!\u001d\t\u000f\u0005E3\u00041\u0001\u0002T\u0005\t\u0012n]*va\u0016\u00148i\u001c8tiJ\u001c\u0015\r\u001c7\u0015\t\u0005%#q\u000f\u0005\b\u0003#b\u0002\u0019AA*\u0003Q\u0019HO]5q\u001d\u0006lW\rZ!qa2L(\t\\8dWR!\u00111\u000bB?\u0011\u001d\t\t&\ba\u0001\u0003'\n\u0011b\u001d;sSB\u001c\u0015m\u001d;\u0015\t\u0005M#1\u0011\u0005\b\u0003#r\u0002\u0019AA*\u0003%\u0019FO]5q\u0007\u0006\u001cH\u000fE\u0002\u0002X\u0001\u0012\u0011b\u0015;sSB\u001c\u0015m\u001d;\u0014\u0007\u0001\nY\u0003\u0006\u0002\u0003\b\u00069QO\\1qa2LH\u0003\u0002BJ\u00053\u0003b!!\f\u0003\u0016\u0006M\u0013\u0002\u0002BL\u0003G\u0011AaU8nK\"9\u0011\u0011\u000b\u0012A\u0002\u0005M\u0013aF5t'\u0016dgm\u0014:TkB,'oQ8ogR\u00148)\u00197m)\u0011\tIEa(\t\u000f\u0005E3\u00051\u0001\u0002T\u0005\u0001\u0012n\u001d,beB\u000bG\u000f^3s]\u0012+W\r\u001d\u000b\u0005\u0003\u0013\u0012)\u000bC\u0004\u0002R\u0011\u0002\r!a\u0015\u0002\u0019%\u001ch+\u0019:QCR$XM\u001d8\u0015\t\u0005%#1\u0016\u0005\b\u0005[+\u0003\u0019AA*\u0003\r\u0001\u0018\r^\u0001\u0010SNd\u0015\u000e^3sC2\u001cFO]5oOR!\u0011\u0011\nBZ\u0011\u001d\tiG\na\u0001\u0003'\nQ\u0003Z3uK\u000e$H+\u001f9fG\",7m[3e)J,W\r\u0006\u0003\u0002J\te\u0006bBA)O\u0001\u0007\u00111K\u0001\u0017k:$\u0018\u0010]3dQ\u0016\u001c7.\u001a3UK6\u0004HNQ8esR!!q\u0018Bg!\u0019\u0011\tMa3\u0002T5\u0011!1\u0019\u0006\u0005\u0005\u000b\u00149-A\u0005j[6,H/\u00192mK*!!\u0011ZA\u0012\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0003\u007f\u0014\u0019\rC\u0004\u0003P\"\u0002\rA!5\u0002\u000bQ,W\u000e\u001d7\u0011\t\u0005U#1[\u0005\u0005\u0005+\fiF\u0001\u0005UK6\u0004H.\u0019;f\u0003Y)h\u000e^=qK\u000eDWmY6fI\ncwnY6C_\u0012LH\u0003\u0002B`\u00057DqA!8*\u0001\u0004\u0011y.A\u0003cY>\u001c7\u000e\u0005\u0003\u0002V\t\u0005\u0018\u0002\u0002Br\u0003;\u0012QA\u00117pG.\fQ#\u001e8usB,7\r[3dW\u0016$GK]3f\u0005>$\u0017\u0010\u0006\u0004\u0003@\n%(1\u001e\u0005\b\u0003#R\u0003\u0019AA*\u0011\u001d\u0011iO\u000ba\u0001\u0005[\tQ\u0001\u001e2pIf\f\u0001CZ5sgR\u001cuN\\:ueV\u001cGo\u001c:\u0015\t\u0005M#1\u001f\u0005\b\u0005k\\\u0003\u0019\u0001B\u0017\u0003\u0015\u0019H/\u0019;t\u0003Q1\u0017N]:u\u0007>t7\u000f\u001e:vGR|'/\u0011:hgR!!Q\u0006B~\u0011\u001d\u0011)\u0010\fa\u0001\u0005[\ta\u0002\u001d:f'V\u0004XM\u001d$jK2$7\u000f\u0006\u0003\u0004\u0002\r\r\u0001CBA|\u0003{\u0014i\u0006C\u0004\u0003v6\u0002\rA!\f\u00021!\f7/\u00168usB,G\r\u0015:f'V\u0004XM\u001d$jK2$7\u000f\u0006\u0003\u0002J\r%\u0001b\u0002B{]\u0001\u0007!QF\u0001\u000bSN,\u0015M\u001d7z\t\u00164G\u0003BA%\u0007\u001fAq!!\u00150\u0001\u0004\t\u0019&A\u0007jg\u0016\u000b'\u000f\\=WC2$UM\u001a\u000b\u0005\u0003\u0013\u001a)\u0002C\u0004\u0002RA\u0002\r!a\u0015\u0002'%\u001c(+\u001a9fCR,G\rU1sC6$\u0016\u0010]3\u0015\t\u0005%31\u0004\u0005\b\u0007;\t\u0004\u0019AA*\u0003\r!\b\u000f^\u0001\u0012SN\u0014\u0015PT1nKB\u000b'/Y7UsB,G\u0003BA%\u0007GAqa!\b3\u0001\u0004\t\u0019&A\rbgNLwM\\7f]R$v.T1zE\u0016t\u0015-\\3e\u0003J<G\u0003BA*\u0007SAq!!\u00154\u0001\u0004\t\u0019&A\u0006jg2+g\r^!tg>\u001cG\u0003BA%\u0007_Aqa!\r5\u0001\u0004\u0019\u0019$\u0001\u0005pa\u0016\u0014\u0018\r^8s!\u0011\t)f!\u000e\n\t\r]2\u0011\b\u0002\u0005\u001d\u0006lW-\u0003\u0003\u0004<\u0005m!!\u0002(b[\u0016\u001c\u0018AE5t'^LGo\u00195B]:|G/\u0019;j_:$B!!\u0013\u0004B!911I\u001bA\u0002\u0005\u0005\u0016a\u0001;qK\u0006aQ.Y=CKRK\b/\u001a)biR!\u0011\u0011JB%\u0011\u001d\t\tF\u000ea\u0001\u0003'\n\u0011#[:XS2$7-\u0019:e'R\f'/\u0011:h)\u0011\tIea\u0014\t\u000f\u0005Es\u00071\u0001\u0002T\u0005yq+\u001b7eG\u0006\u0014Hm\u0015;be\u0006\u0013x\rE\u0002\u0002Xe\u0012qbV5mI\u000e\f'\u000fZ*uCJ\f%oZ\n\u0004s\u0005-BCAB*)\u0011\u0019ifa\u0019\u0011\r\u000552qLA*\u0013\u0011\u0019\t'a\t\u0003\r=\u0003H/[8o\u0011\u001d\t\tf\u000fa\u0001\u0003'\na\u0002^=qKB\u000b'/Y7fi\u0016\u00148\u000f\u0006\u0003\u0004j\rE\u0004CBA|\u0003{\u001cY\u0007\u0005\u0003\u0002V\r5\u0014\u0002BB8\u0003;\u0012q\u0001V=qK\u0012+g\rC\u0004\u0002Rq\u0002\r!a\u0015\u0002+%\u001cx+\u001b7eG\u0006\u0014Hm\u0015;be\u0006\u0013x\rT5tiR!\u0011\u0011JB<\u0011\u001d\u0019I(\u0010a\u0001\u0005[\tQ\u0001\u001e:fKN\fQ\"[:XS2$7-\u0019:e\u0003J<G\u0003BA%\u0007\u007fBq!!\u0015?\u0001\u0004\t\u0019&\u0001\njg^KG\u000eZ2be\u0012\u001cF/\u0019:UsB,G\u0003BA%\u0007\u000bCq!!\u0015@\u0001\u0004\t\u0019&A\u0007jg\u0012+g-Y;mi\u000e\u000b7/\u001a\u000b\u0005\u0003\u0013\u001aY\tC\u0004\u0004\u000e\u0002\u0003\raa$\u0002\t\r$WM\u001a\t\u0005\u0003+\u001a\t*\u0003\u0003\u0004\u0014\u0006u#aB\"bg\u0016$UMZ\u0001\fQ\u0006\u001chj\\*z[\n|G\u000e\u0006\u0003\u0002J\re\u0005bBA7\u0003\u0002\u0007\u00111K\u0001\u0017SN\u001c\u0016P\u001c;iKRL7\rR3gCVdGoQ1tKR!\u0011\u0011JBP\u0011\u001d\u0019iI\u0011a\u0001\u0007\u001f\u000b\u0001cY1uG\",7\u000f\u00165s_^\f'\r\\3\u0015\t\u0005%3Q\u0015\u0005\b\u0007\u001b\u001b\u0005\u0019ABH\u0003=I7oU=oi\",G/[2DCN,G\u0003BA%\u0007WCqa!$E\u0001\u0004\u0019y)A\u0006jg\u000e\u000bGo\u00195DCN,G\u0003BA%\u0007cCqa!$F\u0001\u0004\u0019y)A\tjgNKW\u000e\u001d7f)\"\u0014xn^1cY\u0016$B!!\u0013\u00048\"9\u0011q\u0014$A\u0002\u0005\u0005\u0016!D5t\u000fV\f'\u000fZ3e\u0007\u0006\u001cX\r\u0006\u0003\u0002J\ru\u0006bBBG\u000f\u0002\u00071qR\u0001\u0011SN\u001cV-];f]\u000e,g+\u00197vK\u0012$B!!\u0013\u0004D\"9\u0011\u0011\u000b%A\u0002\u0005M\u0013AB;oE&tG\r\u0006\u0003\u0002T\r%\u0007bBBf\u0013\u0002\u0007\u00111K\u0001\u0002q\u00061\u0011n]*uCJ$B!!\u0013\u0004R\"911\u001a&A\u0002\u0005M\u0013!F3gM\u0016\u001cG/\u001b<f!\u0006$H/\u001a:o\u0003JLG/\u001f\u000b\u0005\u0007/\u001ci\u000e\u0005\u0003\u0002.\re\u0017\u0002BBn\u0003G\u00111!\u00138u\u0011\u001d\u0011Yc\u0013a\u0001\u0005[\tAC\u001a7biR,g.\u001a3QCR$XM\u001d8Be\u001e\u001cH\u0003\u0002B\u0017\u0007GDqAa\u000bM\u0001\u0004\u0011i#\u0001\tT3:#\u0006jX\"B'\u0016{f\tT!H'V\u00111\u0011^\b\u0003\u0007Wl2\u0001\t\u0005\u0001\u0003E\u0019\u0016L\u0014+I?\u000e\u000b5+R0G\u0019\u0006;5\u000bI\u0001\u0012SN\u001c\u0016P\u001c;i\u0007\u0006\u001cXmU=nE>dG\u0003BA%\u0007gDq!!$P\u0001\u0004\ty)\u0001\niCN\u001c\u0016P\u001c;i\u0007\u0006\u001cXmU=nE>dG\u0003BA%\u0007sDq!!\u001cQ\u0001\u0004\t\u0019&\u0001\u0006jgR\u0013\u0018-\u001b;SK\u001a$B!!\u0013\u0004\u0000\"9\u0011\u0011K)A\u0002\u0005M#aB!qa2LW\rZ\n\u0004%\u0006-RCAA*\u0003\u0015!(/Z3!)\u0011!Y\u0001\"\u0004\u0011\u0007\u0005]#\u000bC\u0004\u0002RU\u0003\r!a\u0015\u0002\r\r\fG\u000e\\3f\u0003\u0011\u0019wN]3\u0002\u000bQ\f'oZ:\u0016\u0005\t5\u0012!B1sON\u001cXC\u0001C\u000e!\u0019\t90!@\u0003.\u0005qA-[:tK\u000e$\u0018\t\u001d9mS\u0016$G\u0003\u0002C\u0006\tCAq!!\u0015[\u0001\u0004\t\u0019&A\u0006eSN\u001cXm\u0019;D_J,G\u0003BA*\tOAq!!\u0015\\\u0001\u0004\t\u0019\u0006K\u0002\\\tW\u0001B\u0001\"\f\u000545\u0011Aq\u0006\u0006\u0005\tc\t\u0019#\u0001\u0006b]:|G/\u0019;j_:LA\u0001\"\u000e\u00050\t9A/Y5me\u0016\u001c\u0017aB!qa2LW\r\u001a\t\u0004\u0003/j6cA/\u0002,Q\u0011A\u0011H\u0001\u0006CB\u0004H.\u001f\u000b\u0005\t\u0017!\u0019\u0005C\u0004\u0002R}\u0003\r!a\u0015\u0015\t\u0011\u001dCq\n\t\u0007\u0003[\u0019y\u0006\"\u0013\u0011\u0015\u00055B1JA*\u0005[!Y\"\u0003\u0003\u0005N\u0005\r\"A\u0002+va2,7\u0007C\u0004\u0005R\u0001\u0004\r\u0001b\u0003\u0002\u000f\u0005\u0004\b\u000f\\5fIR!Aq\tC+\u0011\u001d\t\t&\u0019a\u0001\u0003'\n\u0011DZ5sgR$UMZ5oKN\u001cE.Y:t\u001fJ|%M[3diR1\u0011\u0011\nC.\t;Bqa!\u001fc\u0001\u0004\u0011i\u0003C\u0004\u0005`\t\u0004\raa\r\u0002\t9\fW.Z\u0001\n+:\f\u0007\u000f\u001d7jK\u0012\u00042!a\u0016e\u0005%)f.\u00199qY&,GmE\u0002e\u0003W!\"\u0001b\u0019\u0015\t\ruCQ\u000e\u0005\b\u0003#2\u0007\u0019AA*\u0003Uqw\u000e\u0015:fI\u00164\u0017*\u001c9peR4uN]+oSR$B!!\u0013\u0005t!9AQO4A\u0002\u0005M\u0013\u0001\u00022pIf\fA\"[:BEN$\u0016\u0010]3EK\u001a$B!!\u0013\u0005|!9\u0011\u0011\u000b5A\u0002\u0005M\u0013AD5t\u00032L\u0017m\u001d+za\u0016$UM\u001a\u000b\u0005\u0003\u0013\"\t\tC\u0004\u0002R%\u0004\r!a\u0015\u0003!M+W\r\u00165s_V<\u0007N\u00117pG.\u001cX\u0003\u0002CD\t\u001f\u001b2A[A\u0016)\t!Y\tE\u0003\u0002X)$i\t\u0005\u0003\u0003\u0006\u0011=Ea\u0002CIU\n\u0007!1\u0002\u0002\u0002)\u0006YQO\\1qa2L\u0018*\u001c9m)\u0011!i\tb&\t\u000f\r-G\u000e1\u0001\u0002TQ!AQ\u0012CN\u0011\u001d\u0019Y-\u001ca\u0001\u0003'\na!S:UeV,\u0007cAA,_\n1\u0011j\u001d+sk\u0016\u001c2a\u001cCS!\u0015\t9F[A%)\t!y\n\u0006\u0003\u0002J\u0011-\u0006bBBfc\u0002\u0007\u00111K\u0001\b\u0013N4\u0015\r\\:f!\r\t9f\u001d\u0002\b\u0013N4\u0015\r\\:f'\r\u0019HQ\u0015\u000b\u0003\t_#B!!\u0013\u0005:\"911Z;A\u0002\u0005M\u0013AE5t\u0003B\u0004H.\u001f#z]\u0006l\u0017n\u0019(b[\u0016$B!!\u0013\u0005@\"9Aq\f<A\u0002\rM\"a\u0007#z]\u0006l\u0017nY!qa2L7-\u0019;j_:,\u0005\u0010\u001e:bGR|'oE\u0002x\u0003W\t\u0001B\\1nKR+7\u000f\u001e\t\t\u0003[!Ima\r\u0002J%!A1ZA\u0012\u0005%1UO\\2uS>t\u0017\u0007\u0006\u0003\u0005P\u0012E\u0007cAA,o\"9AQY=A\u0002\u0011\u001dG\u0003\u0002Ck\t;\u0004b!!\f\u0004`\u0011]\u0007\u0003CA\u0017\t3\f\u0019Fa\u0005\n\t\u0011m\u00171\u0005\u0002\u0007)V\u0004H.\u001a\u001a\t\u000f\u0005E#\u00101\u0001\u0002T\u0005iA)\u001f8b[&\u001cW\u000b\u001d3bi\u0016\u00042!a\u0016}\u00055!\u0015P\\1nS\u000e,\u0006\u000fZ1uKN\u0019A\u0010b4\u0015\u0005\u0011\u0005\u0018A\u0005#z]\u0006l\u0017nY!qa2L7-\u0019;j_:\u00042!a\u0016\u0000\u0005I!\u0015P\\1nS\u000e\f\u0005\u000f\u001d7jG\u0006$\u0018n\u001c8\u0014\u0007}$y\r\u0006\u0002\u0005l\u00069B)\u001f8b[&\u001c\u0017\t\u001d9mS\u000e\fG/[8o\u001d\u0006lW\r\u001a\t\u0005\u0003/\n)AA\fEs:\fW.[2BaBd\u0017nY1uS>tg*Y7fIN!\u0011Q\u0001Ch)\t!)0\u0001\nNC\u000e\u0014x.S7qYJ+g-\u001a:f]\u000e,\u0007\u0003BA,\u0003\u0017\u0011!#T1de>LU\u000e\u001d7SK\u001a,'/\u001a8dKN!\u00111BA\u0016)\t!y0A\u0004sK\u001a\u0004\u0016M\u001d;\u0015\t\u0005MS1\u0002\u0005\t\u0003#\ny\u00011\u0001\u0002TQ!QqBC\f!\u0019\tica\u0018\u0006\u0012Aq\u0011QFC\n\u0003\u0013\nI%a$\u0002\u0010\n5\u0012\u0002BC\u000b\u0003G\u0011a\u0001V;qY\u0016,\u0004\u0002CA)\u0003#\u0001\r!a\u0015\u0002'%\u001ch*\u001e7mCJL\u0018J\u001c<pG\u0006$\u0018n\u001c8\u0015\t\u0005%SQ\u0004\u0005\t\u0003#\n\u0019\u00021\u0001\u0002T\u0005\u0011\u0012n]'bGJ|\u0017\t\u001d9mS\u000e\fG/[8o)\u0011\tI%b\t\t\u0011\u0005E\u0013Q\u0003a\u0001\u0003'\n\u0011$[:NC\u000e\u0014x.\u00119qY&\u001c\u0017\r^5p]>\u0013(\t\\8dWR!\u0011\u0011JC\u0015\u0011!\t\t&a\u0006A\u0002\u0005M\u0003")
public abstract class TreeInfo {
    private volatile TreeInfo$StripCast$ StripCast$module;
    private volatile TreeInfo$WildcardStarArg$ WildcardStarArg$module;
    private volatile TreeInfo$Applied$ Applied$module;
    private volatile TreeInfo$Unapplied$ Unapplied$module;
    private volatile TreeInfo$IsTrue$ IsTrue$module;
    private volatile TreeInfo$IsFalse$ IsFalse$module;
    private volatile TreeInfo$DynamicUpdate$ DynamicUpdate$module;
    private volatile TreeInfo$DynamicApplication$ DynamicApplication$module;
    private volatile TreeInfo$DynamicApplicationNamed$ DynamicApplicationNamed$module;
    private volatile TreeInfo$MacroImplReference$ MacroImplReference$module;

    public TreeInfo$StripCast$ StripCast() {
        if (this.StripCast$module == null) {
            this.StripCast$lzycompute$1();
        }
        return this.StripCast$module;
    }

    public TreeInfo$WildcardStarArg$ WildcardStarArg() {
        if (this.WildcardStarArg$module == null) {
            this.WildcardStarArg$lzycompute$1();
        }
        return this.WildcardStarArg$module;
    }

    public TreeInfo$Applied$ Applied() {
        if (this.Applied$module == null) {
            this.Applied$lzycompute$1();
        }
        return this.Applied$module;
    }

    public TreeInfo$Unapplied$ Unapplied() {
        if (this.Unapplied$module == null) {
            this.Unapplied$lzycompute$1();
        }
        return this.Unapplied$module;
    }

    public TreeInfo$IsTrue$ IsTrue() {
        if (this.IsTrue$module == null) {
            this.IsTrue$lzycompute$1();
        }
        return this.IsTrue$module;
    }

    public TreeInfo$IsFalse$ IsFalse() {
        if (this.IsFalse$module == null) {
            this.IsFalse$lzycompute$1();
        }
        return this.IsFalse$module;
    }

    public TreeInfo$DynamicUpdate$ DynamicUpdate() {
        if (this.DynamicUpdate$module == null) {
            this.DynamicUpdate$lzycompute$1();
        }
        return this.DynamicUpdate$module;
    }

    public TreeInfo$DynamicApplication$ DynamicApplication() {
        if (this.DynamicApplication$module == null) {
            this.DynamicApplication$lzycompute$1();
        }
        return this.DynamicApplication$module;
    }

    public TreeInfo$DynamicApplicationNamed$ DynamicApplicationNamed() {
        if (this.DynamicApplicationNamed$module == null) {
            this.DynamicApplicationNamed$lzycompute$1();
        }
        return this.DynamicApplicationNamed$module;
    }

    public TreeInfo$MacroImplReference$ MacroImplReference() {
        if (this.MacroImplReference$module == null) {
            this.MacroImplReference$lzycompute$1();
        }
        return this.MacroImplReference$module;
    }

    public abstract SymbolTable global();

    public boolean isDeclarationOrTypeDef(Trees.Tree tree) {
        boolean bl = tree instanceof Trees.ValOrDefDef ? ((Trees.ValOrDefDef)tree).rhs() == this.global().EmptyTree() : tree instanceof Trees.TypeDef;
        return bl;
    }

    public boolean isInterfaceMember(Trees.Tree tree) {
        boolean bl = ((Object)this.global().EmptyTree()).equals(tree) ? true : (tree instanceof Trees.Import ? true : (tree instanceof Trees.TypeDef ? true : (tree instanceof Trees.DefDef ? ((Trees.DefDef)tree).mods().isDeferred() : (tree instanceof Trees.ValDef ? ((Trees.ValDef)tree).mods().isDeferred() : false))));
        return bl;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isConstructorWithDefault(Trees.Tree t) {
        void var7_7;
        if (!(t instanceof Trees.DefDef)) return false;
        Trees.DefDef defDef = (Trees.DefDef)t;
        Names.TermName termName = defDef.name();
        List<List<Trees.ValDef>> vparamss = defDef.vparamss();
        Names.TermName termName2 = this.global().nme().CONSTRUCTOR();
        if (termName2 == null) {
            if (termName != null) {
                return false;
            }
        } else if (!termName2.equals(termName)) return false;
        Function1<Trees.ValDef, Object> & java.io.Serializable & Serializable intersect = (Function1<Trees.ValDef, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$isConstructorWithDefault$1(x$1));
        if (this.global() == null) {
            throw null;
        }
        if (vparamss == null) {
            throw null;
        }
        List<List<Trees.ValDef>> list = vparamss;
        while (!var7_7.isEmpty()) {
            void var10_10;
            List list2 = (List)var7_7.head();
            if (list2 == null) {
                throw null;
            }
            List list3 = list2;
            while (!var10_10.isEmpty()) {
                void mexists_p;
                if (BoxesRunTime.unboxToBoolean(mexists_p.apply(var10_10.head()))) {
                    return true;
                }
                LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var10_10.tail();
            }
            boolean bl = false;
            if (bl) {
                return true;
            }
            LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var7_7.tail();
        }
        return false;
    }

    public boolean isPureDef(Trees.Tree tree) {
        boolean bl;
        boolean bl2 = ((Object)this.global().EmptyTree()).equals(tree) ? true : (tree instanceof Trees.ClassDef ? true : (tree instanceof Trees.TypeDef ? true : (tree instanceof Trees.Import ? true : tree instanceof Trees.DefDef)));
        if (bl2) {
            bl = true;
        } else if (tree instanceof Trees.ValDef) {
            Trees.ValDef valDef = (Trees.ValDef)tree;
            Trees.Modifiers mods = valDef.mods();
            Trees.Tree rhs = valDef.rhs();
            bl = !mods.isMutable() && this.isExprSafeToInline(rhs);
        } else {
            bl = false;
        }
        return bl;
    }

    public boolean isPath(Trees.Tree tree, boolean allowVolatile) {
        boolean bl;
        boolean bl2 = ((Object)this.global().EmptyTree()).equals(tree) ? true : tree instanceof Trees.Literal;
        if (bl2) {
            bl = true;
        } else {
            boolean bl3 = tree instanceof Trees.This ? true : tree instanceof Trees.Super;
            bl = bl3 ? this.symOk(tree.symbol()) : this.isStableIdentifier(tree, allowVolatile);
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isStableIdentifier(Trees.Tree tree, boolean allowVolatile) {
        Trees.Tree tree2;
        if (tree instanceof Trees.Ident) {
            Trees.Ident ident = (Trees.Ident)tree;
            return this.isStableIdent(ident, allowVolatile);
        }
        if (tree instanceof Trees.Select) {
            Trees.Tree qual = ((Trees.Select)tree).qualifier();
            if (!this.isStableMemberOf(tree.symbol(), qual, allowVolatile)) return false;
            if (!this.isPath(qual, allowVolatile)) return false;
            return true;
        }
        if (tree instanceof Trees.Apply && (tree2 = ((Trees.Apply)tree).fun()) instanceof Trees.Select) {
            Trees.Select select = (Trees.Select)tree2;
            Trees.Tree free = select.qualifier();
            Names.Name name = select.name();
            if (free instanceof Trees.Ident) {
                Trees.Ident ident = (Trees.Ident)free;
                Names.TermName termName = this.global().nme().apply();
                if (!(termName != null ? !termName.equals(name) : name != null) && ident.symbol().name().endsWith(this.global().nme().REIFY_FREE_VALUE_SUFFIX())) {
                    if (!ident.symbol().hasStableFlag()) return false;
                    if (!this.isPath(ident, allowVolatile)) return false;
                    return true;
                }
            }
        }
        if (!(tree instanceof Trees.Literal)) return false;
        return true;
    }

    private boolean symOk(Symbols.Symbol sym) {
        return sym != null && !sym.isError() && !sym.equals(this.global().NoSymbol());
    }

    private boolean typeOk(Types.Type tp) {
        return tp != null && !tp.isError();
    }

    private boolean isUncheckedStable(Symbols.Symbol sym) {
        return sym.isTerm() && sym.hasAnnotation(this.global().definitions().uncheckedStableClass());
    }

    public boolean isStableMemberOf(Symbols.Symbol sym, Trees.Tree tree, boolean allowVolatile) {
        return !(!this.symOk(sym) || sym.isTerm() && (!sym.isStable() && !this.isUncheckedStable(sym) || !allowVolatile && sym.hasVolatileType()) || !this.typeOk(tree.tpe()) || !allowVolatile && this.hasVolatileType(tree) || this.global().definitions().isByNameParamType(tree.tpe()));
    }

    private boolean isStableIdent(Trees.Ident tree, boolean allowVolatile) {
        return !(!this.symOk(tree.symbol()) || !tree.symbol().isStable() && !this.isUncheckedStable(tree.symbol()) || this.global().definitions().isByNameParamType(tree.tpe()) || this.global().definitions().isByName(tree.symbol()) || !allowVolatile && tree.symbol().hasVolatileType());
    }

    public boolean hasVolatileType(Trees.Tree tree) {
        return this.symOk(tree.symbol()) && tree.tpe().isVolatile() && !this.isUncheckedStable(tree.symbol());
    }

    public boolean admitsTypeSelection(Trees.Tree tree) {
        return this.isPath(tree, false);
    }

    public boolean isStableIdentifierPattern(Trees.Tree tree) {
        return this.isStableIdentifier(tree, true);
    }

    public boolean isQualifierSafeToElide(Trees.Tree tree) {
        return this.isExprSafeToInline(tree);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isExprSafeToInline(Trees.Tree tree) {
        void var26_27;
        boolean bl = false;
        Trees.Select select = null;
        boolean bl2 = false;
        Trees.Apply apply2 = null;
        if (((Object)this.global().EmptyTree()).equals(tree)) {
            return true;
        }
        if (tree instanceof Trees.This) {
            return true;
        }
        if (tree instanceof Trees.Super) {
            return true;
        }
        if (tree instanceof Trees.Literal) {
            return true;
        }
        boolean bl3 = false;
        if (bl3) {
            return true;
        }
        if (tree instanceof Trees.Ident) {
            return tree.symbol().isStable();
        }
        if (tree instanceof Trees.Select) {
            bl = true;
            select = (Trees.Select)tree;
            Trees.Tree tree2 = select.qualifier();
            Names.Name name = select.name();
            if (tree2 instanceof Trees.Literal) {
                Constants.Constant constant = ((Trees.Literal)tree2).value();
                if (!constant.isAnyVal()) return false;
                Symbols.Symbol symbol = constant.tpe().member(name);
                Symbols.NoSymbol noSymbol = this.global().NoSymbol();
                if (symbol == null) {
                    if (noSymbol == null) return false;
                    return true;
                } else if (symbol.equals(noSymbol)) return false;
                return true;
            }
        }
        if (bl) {
            Trees.Tree qual = select.qualifier();
            if (!tree.symbol().isStable()) return false;
            if (!this.isExprSafeToInline(qual)) return false;
            return true;
        }
        if (tree instanceof Trees.TypeApply) {
            Trees.Tree fn = ((Trees.TypeApply)tree).fun();
            return this.isExprSafeToInline(fn);
        }
        if (tree instanceof Trees.Apply) {
            bl2 = true;
            apply2 = (Trees.Apply)tree;
            Trees.Tree tree3 = apply2.fun();
            if (tree3 instanceof Trees.Select) {
                Trees.Select select2 = (Trees.Select)tree3;
                Trees.Tree free = select2.qualifier();
                Names.Name name = select2.name();
                if (free instanceof Trees.Ident) {
                    Trees.Ident ident = (Trees.Ident)free;
                    Names.TermName termName = this.global().nme().apply();
                    if (!(termName != null ? !termName.equals(name) : name != null) && ident.symbol().name().endsWith(this.global().nme().REIFY_FREE_VALUE_SUFFIX())) {
                        if (!ident.symbol().hasStableFlag()) return false;
                        if (!this.isExprSafeToInline(ident)) return false;
                        return true;
                    }
                }
            }
        }
        if (bl2) {
            Trees.Tree fn = apply2.fun();
            List<Trees.Tree> list = apply2.args();
            Some<List<Trees.Tree>> some = List$.MODULE$.unapplySeq(list);
            if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
                if (fn.symbol() == null) return false;
                if (!fn.symbol().isMethod()) return false;
                if (fn.symbol().isLazy()) return false;
                if (!this.isExprSafeToInline(fn)) return false;
                return true;
            }
        }
        if (tree instanceof Trees.Typed) {
            Trees.Tree expr = ((Trees.Typed)tree).expr();
            return this.isExprSafeToInline(expr);
        }
        if (!(tree instanceof Trees.Block)) return false;
        Trees.Block block = (Trees.Block)tree;
        List<Trees.Tree> stats = block.stats();
        Trees.Tree expr = block.expr();
        if (stats == null) {
            throw null;
        }
        List<Trees.Tree> list = stats;
        while (!var26_27.isEmpty()) {
            Trees.Tree tree4 = (Trees.Tree)var26_27.head();
            if (!this.isPureDef(tree4)) {
                return false;
            }
            LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var26_27.tail();
        }
        boolean bl4 = true;
        if (!bl4) return false;
        if (!this.isExprSafeToInline(expr)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isPureExprForWarningPurposes(Trees.Tree tree) {
        boolean bl;
        Constants.Constant constant;
        if (tree instanceof Trees.Typed) {
            Trees.Tree expr = ((Trees.Typed)tree).expr();
            return this.isPureExprForWarningPurposes(expr);
        }
        if (((Object)this.global().EmptyTree()).equals(tree)) {
            return false;
        }
        if (tree instanceof Trees.Literal && (constant = ((Trees.Literal)tree).value()) != null) {
            Object object = constant.value();
            BoxedUnit boxedUnit = BoxedUnit.UNIT;
            if (boxedUnit == null) {
                if (object == null) return false;
            } else if (((Object)boxedUnit).equals(object)) {
                return false;
            }
        }
        if (bl = false) {
            return false;
        }
        if (tree.isErrorTyped()) return false;
        if (!this.isExprSafeToInline(tree)) {
            if (!this.isWarnableRefTree$1(tree)) return false;
        }
        if (!this.isWarnableSymbol$1(tree)) return false;
        return true;
    }

    public <R> List<R> mapMethodParamsAndArgs(List<Symbols.Symbol> params, List<Trees.Tree> args2, Function2<Symbols.Symbol, Trees.Tree, R> f) {
        Builder b = List$.MODULE$.newBuilder();
        this.foreachMethodParamAndArg(params, args2, (Function2<Symbols.Symbol, Trees.Tree, BoxedUnit>)(Function2<Symbols.Symbol, Trees.Tree, Object> & java.io.Serializable & Serializable)(param2, arg) -> {
            b.$plus$eq(f.apply((Symbols.Symbol)param2, (Trees.Tree)arg));
            return BoxedUnit.UNIT;
        });
        return b.result();
    }

    /*
     * WARNING - void declaration
     */
    public boolean foreachMethodParamAndArg(List<Symbols.Symbol> params, List<Trees.Tree> args2, Function2<Symbols.Symbol, Trees.Tree, BoxedUnit> f) {
        int alen;
        int plen = params.length();
        if (plen == (alen = args2.length())) {
            if (this.global() == null) {
                throw null;
            }
            List foreach2_ys1 = params;
            List foreach2_ys2 = args2;
            while (!foreach2_ys1.isEmpty() && !foreach2_ys2.isEmpty()) {
                f.apply(foreach2_ys1.head(), foreach2_ys2.head());
                foreach2_ys1 = (List)foreach2_ys1.tail();
                foreach2_ys2 = (List)foreach2_ys2.tail();
            }
        } else {
            if (params.isEmpty()) {
                return this.fail$1(params, args2);
            }
            if (this.global().definitions().isVarArgsList(params)) {
                int plenInit = plen - 1;
                if (alen == plenInit) {
                    if (alen == 0) {
                    } else {
                        void foreach2_xs1;
                        List list = (List)params.init();
                        if (this.global() == null) {
                            throw null;
                        }
                        List foreach2_ys1 = foreach2_xs1;
                        List foreach2_ys2 = args2;
                        while (!foreach2_ys1.isEmpty() && !foreach2_ys2.isEmpty()) {
                            f.apply((Symbols.Symbol)foreach2_ys1.head(), (Trees.Tree)foreach2_ys2.head());
                            foreach2_ys1 = (List)foreach2_ys1.tail();
                            foreach2_ys2 = (List)foreach2_ys2.tail();
                        }
                    }
                } else {
                    void foreach2_xs1;
                    int fill_n;
                    void foreach2_xs2;
                    void foreach2_xs12;
                    if (alen < plenInit) {
                        return this.fail$1(params, args2);
                    }
                    Object object = args2.take(plenInit);
                    List list = (List)params.init();
                    if (this.global() == null) {
                        throw null;
                    }
                    List foreach2_ys1 = foreach2_xs12;
                    List foreach2_ys2 = foreach2_xs2;
                    while (!foreach2_ys1.isEmpty() && !foreach2_ys2.isEmpty()) {
                        f.apply((Symbols.Symbol)foreach2_ys1.head(), (Trees.Tree)foreach2_ys2.head());
                        foreach2_ys1 = (List)foreach2_ys1.tail();
                        foreach2_ys2 = (List)foreach2_ys2.tail();
                    }
                    Object remainingArgs = args2.drop(plenInit);
                    SymbolTable symbolTable = this.global();
                    List$ list$ = List$.MODULE$;
                    int n = ((AbstractSeq)remainingArgs).size();
                    if (list$ == null) {
                        throw null;
                    }
                    Builder fill_b = ((GenericCompanion)list$).newBuilder();
                    fill_b.sizeHint(fill_n);
                    for (int fill_i = 0; fill_i < fill_n; ++fill_i) {
                        fill_b.$plus$eq(TreeInfo.$anonfun$foreachMethodParamAndArg$2(params));
                    }
                    List list2 = (List)((GenTraversable)fill_b.result());
                    if (symbolTable == null) {
                        throw null;
                    }
                    List foreach2_ys12 = foreach2_xs1;
                    Object foreach2_ys22 = remainingArgs;
                    while (!foreach2_ys12.isEmpty() && !((List)foreach2_ys22).isEmpty()) {
                        f.apply((Symbols.Symbol)foreach2_ys12.head(), (Trees.Tree)((List)foreach2_ys22).head());
                        foreach2_ys12 = (List)foreach2_ys12.tail();
                        foreach2_ys22 = (List)((AbstractTraversable)foreach2_ys22).tail();
                    }
                }
            } else {
                return this.fail$1(params, args2);
            }
        }
        return true;
    }

    public boolean isFunctionMissingParamType(Trees.Tree tree) {
        boolean bl;
        if (tree instanceof Trees.Function) {
            boolean bl2;
            block5: {
                List<Trees.ValDef> vparams = ((Trees.Function)tree).vparams();
                if (vparams == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = vparams;
                while (!exists_these.isEmpty()) {
                    if (TreeInfo.$anonfun$isFunctionMissingParamType$1((Trees.ValDef)exists_these.head())) {
                        bl2 = true;
                        break block5;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl2 = false;
            }
            bl = bl2;
        } else {
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean mayBeVarGetter(Symbols.Symbol sym) {
        Types.Type mt;
        boolean bl = false;
        Types.PolyType polyType = null;
        Types.Type type = sym.info();
        if (type instanceof Types.NullaryMethodType) {
            if (!sym.owner().isClass()) return false;
            if (sym.isStable()) return false;
            return true;
        }
        if (type instanceof Types.PolyType) {
            bl = true;
            polyType = (Types.PolyType)type;
            if (polyType.resultType() instanceof Types.NullaryMethodType) {
                if (!sym.owner().isClass()) return false;
                if (sym.isStable()) return false;
                return true;
            }
        }
        if (bl && (mt = polyType.resultType()) instanceof Types.MethodType) {
            if (!((Types.MethodType)mt).isImplicit()) return false;
            if (!sym.owner().isClass()) return false;
            if (sym.isStable()) return false;
            return true;
        }
        if (!(type instanceof Types.MethodType)) return false;
        if (!((Types.MethodType)type).isImplicit()) return false;
        if (!sym.owner().isClass()) return false;
        if (sym.isStable()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isVariableOrGetter(Trees.Tree tree) {
        if (tree instanceof Trees.Ident) {
            return TreeInfo.isVar$1(tree);
        }
        if (tree instanceof Trees.Select) {
            Trees.Tree qual = ((Trees.Select)tree).qualifier();
            if (TreeInfo.isVar$1(tree)) return true;
            if (!this.mayBeVarGetter(TreeInfo.sym$1(tree))) return false;
            Symbols.Symbol symbol = qual.tpe().member(TreeInfo.sym$1(tree).setterName());
            Symbols.NoSymbol noSymbol = this.global().NoSymbol();
            if (symbol == null) {
                if (noSymbol == null) return false;
                return true;
            } else if (symbol.equals(noSymbol)) return false;
            return true;
        }
        Option<Tuple3<Trees.Tree, List<Trees.Tree>, List<List<Trees.Tree>>>> option = this.Applied().unapply(tree);
        if (option.isEmpty()) return false;
        Trees.Tree tree2 = option.get()._1();
        if (!(tree2 instanceof Trees.Select)) return false;
        Trees.Select select = (Trees.Select)tree2;
        Trees.Tree qual = select.qualifier();
        Names.Name name = select.name();
        Names.TermName termName = this.global().nme().apply();
        if (termName == null) {
            if (name != null) {
                return false;
            }
        } else if (!termName.equals(name)) return false;
        Symbols.Symbol symbol = qual.tpe().member(this.global().nme().update());
        Symbols.NoSymbol noSymbol = this.global().NoSymbol();
        if (symbol == null) {
            if (noSymbol == null) return false;
            return true;
        } else if (symbol.equals(noSymbol)) return false;
        return true;
    }

    public boolean noFieldFor(Trees.ValDef vd, Symbols.Symbol owner) {
        return vd.mods().isDeferred() || vd.mods().isLazy() || owner.isTrait() && !vd.mods().hasFlag(0x2000000000L);
    }

    public boolean isDefaultGetter(Trees.Tree tree) {
        return tree.symbol() != null && tree.symbol().isDefaultGetter();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isSelfConstrCall(Trees.Tree tree) {
        Trees.Tree tree2 = this.dissectCore(tree);
        if (tree2 instanceof Trees.Ident) {
            Names.Name name = ((Trees.Ident)tree2).name();
            Names.TermName termName = this.global().nme().CONSTRUCTOR();
            if (termName == null) {
                if (name == null) return true;
            } else if (termName.equals(name)) {
                return true;
            }
        }
        if (!(tree2 instanceof Trees.Select)) return false;
        Trees.Select select = (Trees.Select)tree2;
        Trees.Tree tree3 = select.qualifier();
        Names.Name name = select.name();
        if (!(tree3 instanceof Trees.This)) return false;
        Names.TermName termName = this.global().nme().CONSTRUCTOR();
        if (termName != null) {
            if (!termName.equals(name)) return false;
            return true;
        }
        if (name == null) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isSuperConstrCall(Trees.Tree tree) {
        Trees.Tree tree2 = this.dissectCore(tree);
        if (!(tree2 instanceof Trees.Select)) return false;
        Trees.Select select = (Trees.Select)tree2;
        Trees.Tree tree3 = select.qualifier();
        Names.Name name = select.name();
        if (!(tree3 instanceof Trees.Super)) return false;
        Names.TermName termName = this.global().nme().CONSTRUCTOR();
        if (termName != null) {
            if (!termName.equals(name)) return false;
            return true;
        }
        if (name == null) return true;
        return false;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Trees.Tree stripNamedApplyBlock(Trees.Tree tree) {
        boolean bl;
        Trees.Tree expr;
        block3: {
            void var6_6;
            if (!(tree instanceof Trees.Block)) return tree;
            Trees.Block block = (Trees.Block)tree;
            List<Trees.Tree> stats = block.stats();
            expr = block.expr();
            if (stats == null) {
                throw null;
            }
            List<Trees.Tree> list = stats;
            while (!var6_6.isEmpty()) {
                if (!TreeInfo.$anonfun$stripNamedApplyBlock$1((Trees.Tree)var6_6.head())) {
                    bl = false;
                    break block3;
                }
                LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var6_6.tail();
            }
            bl = true;
        }
        if (!bl) return tree;
        return expr;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Trees.Tree stripCast(Trees.Tree tree) {
        Trees.Tree sel;
        if (tree instanceof Trees.TypeApply && (sel = ((Trees.TypeApply)tree).fun()) instanceof Trees.Select) {
            Trees.Select select = (Trees.Select)sel;
            Trees.Tree inner = select.qualifier();
            if (this.global().definitions().isCastSymbol(select.symbol())) {
                return this.stripCast(inner);
            }
        }
        if (!(tree instanceof Trees.Apply)) return tree;
        Trees.Apply apply2 = (Trees.Apply)tree;
        Trees.Tree tree2 = apply2.fun();
        List<Trees.Tree> list = apply2.args();
        if (!(tree2 instanceof Trees.TypeApply)) return tree;
        Trees.Tree sel2 = ((Trees.TypeApply)tree2).fun();
        if (!(sel2 instanceof Trees.Select)) return tree;
        Trees.Select select = (Trees.Select)sel2;
        Trees.Tree inner = select.qualifier();
        if (!((Object)Nil$.MODULE$).equals(list)) return tree;
        if (!this.global().definitions().isCastSymbol(select.symbol())) return tree;
        return this.stripCast(inner);
    }

    public boolean isSelfOrSuperConstrCall(Trees.Tree tree) {
        Trees.Tree tree1 = this.stripNamedApplyBlock(tree);
        return this.isSelfConstrCall(tree1) || this.isSuperConstrCall(tree1);
    }

    public boolean isVarPatternDeep(Trees.Tree tree) {
        boolean bl = tree instanceof Trees.Ident ? true : this.isVarPatternDeep0$1(tree);
        return bl;
    }

    public boolean isVarPattern(Trees.Tree pat) {
        Trees.Ident ident;
        boolean bl = pat instanceof Trees.Ident ? !(ident = (Trees.Ident)pat).isBackquoted() && this.global().nme().isVariableName(ident.name()) : false;
        return bl;
    }

    public boolean isLiteralString(Trees.Tree t) {
        Constants.Constant constant;
        boolean bl = t instanceof Trees.Literal && (constant = ((Trees.Literal)t).value()) != null && constant.value() instanceof String;
        return bl;
    }

    public boolean detectTypecheckedTree(Trees.Tree tree) {
        return tree.hasExistingSymbol() || tree.exists((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$detectTypecheckedTree$1(x0$1)));
    }

    public List<Trees.Tree> untypecheckedTemplBody(Trees.Template templ) {
        return this.untypecheckedTreeBody(templ, templ.body());
    }

    public List<Trees.Tree> untypecheckedBlockBody(Trees.Block block) {
        return this.untypecheckedTreeBody(block, block.stats());
    }

    public List<Trees.Tree> untypecheckedTreeBody(Trees.Tree tree, List<Trees.Tree> tbody) {
        if (this.detectTypecheckedTree(tree)) {
            return this.recoverBody$1(this.filterBody$1(tbody, tbody), tbody);
        }
        return tbody;
    }

    public Trees.Tree firstConstructor(List<Trees.Tree> stats) {
        Option option;
        block4: {
            if (stats == null) {
                throw null;
            }
            LinearSeqOptimized find_these = stats;
            while (!find_these.isEmpty()) {
                Trees.Tree tree = (Trees.Tree)find_these.head();
                if (TreeInfo.$anonfun$firstConstructor$1(this, tree)) {
                    option = new Some(find_these.head());
                    break block4;
                }
                find_these = (LinearSeqOptimized)find_these.tail();
            }
            option = None$.MODULE$;
        }
        if (option == null) {
            throw null;
        }
        Trees$EmptyTree$ trees$EmptyTree$ = ((Option)option).isEmpty() ? TreeInfo.$anonfun$firstConstructor$2(this) : ((Option)option).get();
        return trees$EmptyTree$;
    }

    public List<Trees.Tree> firstConstructorArgs(List<Trees.Tree> stats) {
        List<List<Trees.ValDef>> list;
        Trees.Tree tree = this.firstConstructor(stats);
        List list2 = tree instanceof Trees.DefDef && (list = ((Trees.DefDef)tree).vparamss()) instanceof $colon$colon ? (List)(($colon$colon)list).head() : Nil$.MODULE$;
        return list2;
    }

    public List<Trees.ValDef> preSuperFields(List<Trees.Tree> stats) {
        return stats.collect(new Serializable(this){
            public static final long serialVersionUID = 0L;
            private final /* synthetic */ TreeInfo $outer;

            public final <A1 extends Trees.Tree, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                Trees.ValDef valDef;
                Object object = x1 instanceof Trees.ValDef && this.$outer.isEarlyValDef(valDef = (Trees.ValDef)x1) ? valDef : function1.apply(x1);
                return object;
            }

            public final boolean isDefinedAt(Trees.Tree x1) {
                Trees.ValDef valDef;
                boolean bl = x1 instanceof Trees.ValDef && this.$outer.isEarlyValDef(valDef = (Trees.ValDef)x1);
                return bl;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        }, List$.MODULE$.canBuildFrom());
    }

    public boolean hasUntypedPreSuperFields(List<Trees.Tree> stats) {
        boolean bl;
        block3: {
            List<Trees.ValDef> list = this.preSuperFields(stats);
            if (list == null) {
                throw null;
            }
            LinearSeqOptimized exists_these = list;
            while (!exists_these.isEmpty()) {
                if (TreeInfo.$anonfun$hasUntypedPreSuperFields$1((Trees.ValDef)exists_these.head())) {
                    bl = true;
                    break block3;
                }
                exists_these = (LinearSeqOptimized)exists_these.tail();
            }
            bl = false;
        }
        return bl;
    }

    public boolean isEarlyDef(Trees.Tree tree) {
        boolean bl = tree instanceof Trees.TypeDef ? ((Trees.TypeDef)tree).mods().hasFlag(0x2000000000L) : (tree instanceof Trees.ValDef ? ((Trees.ValDef)tree).mods().hasFlag(0x2000000000L) : false);
        return bl;
    }

    public boolean isEarlyValDef(Trees.Tree tree) {
        boolean bl = tree instanceof Trees.ValDef ? ((Trees.ValDef)tree).mods().hasFlag(0x2000000000L) : false;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isRepeatedParamType(Trees.Tree tpt) {
        boolean bl = false;
        Trees.AppliedTypeTree appliedTypeTree = null;
        if (tpt instanceof Trees.TypeTree) {
            return this.global().definitions().isRepeatedParamType(tpt.tpe());
        }
        if (tpt instanceof Trees.AppliedTypeTree) {
            bl = true;
            appliedTypeTree = (Trees.AppliedTypeTree)tpt;
            Trees.Tree tree = appliedTypeTree.tpt();
            if (tree instanceof Trees.Select) {
                Names.Name name = ((Trees.Select)tree).name();
                Names.TypeName typeName = this.global().tpnme().REPEATED_PARAM_CLASS_NAME();
                if (typeName == null) {
                    if (name == null) return true;
                } else if (typeName.equals(name)) {
                    return true;
                }
            }
        }
        if (!bl) return false;
        Trees.Tree tree = appliedTypeTree.tpt();
        if (!(tree instanceof Trees.Select)) return false;
        Names.Name name = ((Trees.Select)tree).name();
        Names.TypeName typeName = this.global().tpnme().JAVA_REPEATED_PARAM_CLASS_NAME();
        if (typeName != null) {
            if (!typeName.equals(name)) return false;
            return true;
        }
        if (name == null) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isByNameParamType(Trees.Tree tpt) {
        if (tpt instanceof Trees.TypeTree) {
            return this.global().definitions().isByNameParamType(tpt.tpe());
        }
        if (!(tpt instanceof Trees.AppliedTypeTree)) return false;
        Trees.Tree tree = ((Trees.AppliedTypeTree)tpt).tpt();
        if (!(tree instanceof Trees.Select)) return false;
        Names.Name name = ((Trees.Select)tree).name();
        Names.TypeName typeName = this.global().tpnme().BYNAME_PARAM_CLASS_NAME();
        if (typeName != null) {
            if (!typeName.equals(name)) return false;
            return true;
        }
        if (name == null) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Trees.Tree assignmentToMaybeNamedArg(Trees.Tree tree) {
        if (!(tree instanceof Trees.Assign)) return tree;
        Trees.Assign assign = (Trees.Assign)tree;
        Trees.Tree id = assign.lhs();
        Trees.Tree rhs = assign.rhs();
        if (!(id instanceof Trees.Ident)) return tree;
        Trees.Ident ident = (Trees.Ident)id;
        return this.global().atPos(assign.pos(), new Trees.AssignOrNamedArg(this.global(), ident, rhs));
    }

    public boolean isLeftAssoc(Names.Name operator) {
        return operator.nonEmpty() && operator.endChar() != ':';
    }

    public boolean isSwitchAnnotation(Types.Type tpe) {
        return tpe.hasAnnotation(this.global().definitions().SwitchClass());
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean mayBeTypePat(Trees.Tree tree) {
        Trees.Template template;
        if (tree instanceof Trees.CompoundTypeTree && (template = ((Trees.CompoundTypeTree)tree).templ()) != null) {
            List<Trees.Tree> tps = template.parents();
            List<Trees.Tree> list = template.body();
            if (((Object)Nil$.MODULE$).equals(list)) {
                void var11_6;
                if (tps == null) {
                    throw null;
                }
                List<Trees.Tree> list2 = tps;
                while (!var11_6.isEmpty()) {
                    Trees.Tree tree2 = (Trees.Tree)var11_6.head();
                    if (this.mayBeTypePat(tree2)) {
                        return true;
                    }
                    LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var11_6.tail();
                }
                return false;
            }
        }
        if (tree instanceof Trees.Annotated) {
            Trees.Tree tp = ((Trees.Annotated)tree).arg();
            return this.mayBeTypePat(tp);
        }
        if (tree instanceof Trees.AppliedTypeTree) {
            void var13_16;
            Trees.AppliedTypeTree appliedTypeTree = (Trees.AppliedTypeTree)tree;
            Trees.Tree constr = appliedTypeTree.tpt();
            List<Trees.Tree> args2 = appliedTypeTree.args();
            if (this.mayBeTypePat(constr)) return true;
            if (args2 == null) {
                throw null;
            }
            List<Trees.Tree> list = args2;
            while (!var13_16.isEmpty()) {
                if (TreeInfo.$anonfun$mayBeTypePat$2((Trees.Tree)var13_16.head())) {
                    return true;
                }
                LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var13_16.tail();
            }
            return false;
        }
        if (!(tree instanceof Trees.SelectFromTypeTree)) return false;
        Trees.Tree tp = ((Trees.SelectFromTypeTree)tree).qualifier();
        return this.mayBeTypePat(tp);
    }

    public boolean isWildcardStarArg(Trees.Tree tree) {
        boolean bl = !this.WildcardStarArg().unapply(tree).isEmpty();
        return bl;
    }

    public List<Trees.TypeDef> typeParameters(Trees.Tree tree) {
        List list = tree instanceof Trees.DefDef ? ((Trees.DefDef)tree).tparams() : (tree instanceof Trees.ClassDef ? ((Trees.ClassDef)tree).tparams() : (tree instanceof Trees.TypeDef ? ((Trees.TypeDef)tree).tparams() : Nil$.MODULE$));
        return list;
    }

    public boolean isWildcardStarArgList(List<Trees.Tree> trees) {
        return trees.nonEmpty() && this.isWildcardStarArg(trees.last());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isWildcardArg(Trees.Tree tree) {
        Trees.Tree tree2 = this.unbind(tree);
        if (!(tree2 instanceof Trees.Ident)) return false;
        Names.Name name = ((Trees.Ident)tree2).name();
        Names.Name name2 = this.global().nme().WILDCARD();
        if (name2 != null) {
            if (!name2.equals(name)) return false;
            return true;
        }
        if (name == null) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isWildcardStarType(Trees.Tree tree) {
        if (!(tree instanceof Trees.Ident)) return false;
        Names.Name name = ((Trees.Ident)tree).name();
        Names.TypeName typeName = this.global().tpnme().WILDCARD_STAR();
        if (typeName != null) {
            if (!typeName.equals(name)) return false;
            return true;
        }
        if (name == null) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isDefaultCase(Trees.CaseDef cdef) {
        if (cdef == null) return false;
        Trees.Tree pat = cdef.pat();
        Trees.Tree tree = cdef.guard();
        if (!((Object)this.global().EmptyTree()).equals(tree)) return false;
        return this.isWildcardArg(pat);
    }

    private boolean hasNoSymbol(Trees.Tree t) {
        block3: {
            block2: {
                if (t.symbol() == null) break block2;
                Symbols.Symbol symbol = t.symbol();
                Symbols.NoSymbol noSymbol = this.global().NoSymbol();
                if (symbol != null ? !symbol.equals(noSymbol) : noSymbol != null) break block3;
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isSyntheticDefaultCase(Trees.CaseDef cdef) {
        if (cdef == null) return false;
        Trees.Tree tree = cdef.pat();
        Trees.Tree tree2 = cdef.guard();
        if (!(tree instanceof Trees.Bind)) return false;
        Names.Name name = ((Trees.Bind)tree).name();
        Names.TermName termName = this.global().nme().DEFAULT_CASE();
        if (termName == null) {
            if (name != null) {
                return false;
            }
        } else if (!termName.equals(name)) return false;
        if (!((Object)this.global().EmptyTree()).equals(tree2)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean catchesThrowable(Trees.CaseDef cdef) {
        if (!cdef.guard().isEmpty()) return false;
        boolean bl = false;
        Trees.Ident ident = null;
        Trees.Tree tree = this.unbind(cdef.pat());
        if (tree instanceof Trees.Ident) {
            bl = true;
            ident = (Trees.Ident)tree;
            Names.Name name = ident.name();
            Names.Name name2 = this.global().nme().WILDCARD();
            if (name2 == null) {
                if (name == null) return true;
            } else if (name2.equals(name)) {
                return true;
            }
        }
        if (!bl) return false;
        boolean bl2 = this.hasNoSymbol(ident);
        if (!bl2) return false;
        return true;
    }

    public boolean isSyntheticCase(Trees.CaseDef cdef) {
        return cdef.pat().exists((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(bl = x0$1 instanceof Trees.DefTree ? ((Trees.DefTree)x0$1).symbol().isSynthetic() : false));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isCatchCase(Trees.CaseDef cdef) {
        if (cdef != null) {
            Trees.Tree tree = cdef.pat();
            Trees.Tree tree2 = cdef.guard();
            if (tree instanceof Trees.Typed) {
                Trees.Typed typed = (Trees.Typed)tree;
                Trees.Tree tree3 = typed.expr();
                Trees.Tree tpt = typed.tpt();
                if (tree3 instanceof Trees.Ident) {
                    Names.Name name = ((Trees.Ident)tree3).name();
                    Names.Name name2 = this.global().nme().WILDCARD();
                    if (!(name2 != null ? !name2.equals(name) : name != null) && ((Object)this.global().EmptyTree()).equals(tree2)) {
                        return this.isSimpleThrowable(tpt.tpe());
                    }
                }
            }
        }
        if (cdef == null) return this.isDefaultCase(cdef);
        Trees.Tree tree = cdef.pat();
        Trees.Tree tree4 = cdef.guard();
        if (!(tree instanceof Trees.Bind)) return this.isDefaultCase(cdef);
        Trees.Tree tree5 = ((Trees.Bind)tree).body();
        if (!(tree5 instanceof Trees.Typed)) return this.isDefaultCase(cdef);
        Trees.Typed typed = (Trees.Typed)tree5;
        Trees.Tree tree6 = typed.expr();
        Trees.Tree tpt = typed.tpt();
        if (!(tree6 instanceof Trees.Ident)) return this.isDefaultCase(cdef);
        Names.Name name = ((Trees.Ident)tree6).name();
        Names.Name name3 = this.global().nme().WILDCARD();
        if (name3 == null) {
            if (name != null) {
                return this.isDefaultCase(cdef);
            }
        } else if (!name3.equals(name)) return this.isDefaultCase(cdef);
        if (!((Object)this.global().EmptyTree()).equals(tree4)) return this.isDefaultCase(cdef);
        return this.isSimpleThrowable(tpt.tpe());
    }

    private boolean isSimpleThrowable(Types.Type tp) {
        boolean bl;
        if (tp instanceof Types.TypeRef) {
            Types.TypeRef typeRef = (Types.TypeRef)tp;
            Types.Type pre = typeRef.pre();
            Symbols.Symbol sym = typeRef.sym();
            Types.Type type = pre;
            Types$NoPrefix$ types$NoPrefix$ = this.global().NoPrefix();
            bl = !((type == null ? types$NoPrefix$ != null : !type.equals(types$NoPrefix$)) && !pre.widen().typeSymbol().isStatic() || !sym.isNonBottomSubClass(this.global().definitions().ThrowableClass()) || sym.isTrait());
        } else {
            bl = false;
        }
        return bl;
    }

    public boolean isGuardedCase(Trees.CaseDef cdef) {
        Trees.Tree tree = cdef.guard();
        Trees$EmptyTree$ trees$EmptyTree$ = this.global().EmptyTree();
        return tree == null ? trees$EmptyTree$ != null : !((Object)tree).equals(trees$EmptyTree$);
    }

    public boolean isSequenceValued(Trees.Tree tree) {
        boolean bl;
        Trees.Tree tree2 = this.unbind(tree);
        if (tree2 instanceof Trees.Alternative) {
            boolean bl2;
            block5: {
                List<Trees.Tree> ts = ((Trees.Alternative)tree2).trees();
                if (ts == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = ts;
                while (!exists_these.isEmpty()) {
                    Trees.Tree tree3 = (Trees.Tree)exists_these.head();
                    if (this.isSequenceValued(tree3)) {
                        bl2 = true;
                        break block5;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl2 = false;
            }
            bl = bl2;
        } else {
            boolean bl3 = tree2 instanceof Trees.ArrayValue ? true : tree2 instanceof Trees.Star;
            bl = bl3;
        }
        return bl;
    }

    public Trees.Tree unbind(Trees.Tree x) {
        Trees.Tree tree;
        if (x instanceof Trees.Bind) {
            Trees.Tree y = ((Trees.Bind)x).body();
            tree = this.unbind(y);
        } else {
            tree = x;
        }
        return tree;
    }

    public boolean isStar(Trees.Tree x) {
        boolean bl = this.unbind(x) instanceof Trees.Star;
        return bl;
    }

    public int effectivePatternArity(List<Trees.Tree> args2) {
        return this.flattenedPatternArgs(args2).length();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public List<Trees.Tree> flattenedPatternArgs(List<Trees.Tree> args2) {
        List<Trees.Tree> list = args2.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)x -> this.unbind((Trees.Tree)x), List$.MODULE$.canBuildFrom());
        if (!(list instanceof $colon$colon)) return list;
        $colon$colon $colon$colon = ($colon$colon)list;
        Trees.Tree tree = (Trees.Tree)$colon$colon.head();
        List list2 = $colon$colon.tl$access$1();
        Option<List<Trees.Tree>> option = this.global().build().SyntacticTuple().unapply(tree);
        if (option.isEmpty()) return list;
        List<Trees.Tree> xs = option.get();
        if (!((Object)Nil$.MODULE$).equals(list2)) return list;
        return xs;
    }

    public final int SYNTH_CASE_FLAGS() {
        return 0x200800;
    }

    public boolean isSynthCaseSymbol(Symbols.Symbol sym) {
        return sym.hasAllFlags(0x200800L);
    }

    public boolean hasSynthCaseSymbol(Trees.Tree t) {
        return t.symbol() != null && this.isSynthCaseSymbol(t.symbol());
    }

    public boolean isTraitRef(Trees.Tree tree) {
        Symbols.Symbol sym;
        Symbols.Symbol symbol = sym = tree.tpe() != null ? tree.tpe().typeSymbol() : null;
        return sym != null && sym.initialize().isTrait();
    }

    public final Applied dissectApplied(Trees.Tree tree) {
        return new Applied(this, tree);
    }

    public final Trees.Tree dissectCore(Trees.Tree tree) {
        while (true) {
            if (tree instanceof Trees.TypeApply) {
                tree = ((Trees.TypeApply)tree).fun();
                continue;
            }
            if (!(tree instanceof Trees.Apply)) break;
            tree = ((Trees.Apply)tree).fun();
        }
        return tree;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean firstDefinesClassOrObject(List<Trees.Tree> trees, Names.Name name) {
        Trees.Tree tree;
        Trees.Tree tree2;
        boolean bl = false;
        $colon$colon $colon$colon = null;
        if (trees instanceof $colon$colon) {
            bl = true;
            $colon$colon = ($colon$colon)trees;
            Trees.Tree tree3 = (Trees.Tree)$colon$colon.head();
            List<Trees.Tree> xs = $colon$colon.tl$access$1();
            if (tree3 instanceof Trees.Import) {
                return this.firstDefinesClassOrObject(xs, name);
            }
        }
        if (bl && (tree2 = (Trees.Tree)$colon$colon.head()) instanceof Trees.Annotated) {
            Trees.Tree tree1 = ((Trees.Annotated)tree2).arg();
            return this.firstDefinesClassOrObject(new $colon$colon<Nothing$>((Nothing$)((Object)tree1), Nil$.MODULE$), name);
        }
        if (bl && (tree = (Trees.Tree)$colon$colon.head()) instanceof Trees.ModuleDef) {
            Names.TermName termName = ((Trees.ModuleDef)tree).name();
            Names.Name name2 = name;
            if (name2 == null) {
                if (termName == null) return true;
            } else if (name2.equals(termName)) {
                return true;
            }
        }
        if (!bl) return false;
        Trees.Tree tree4 = (Trees.Tree)$colon$colon.head();
        if (!(tree4 instanceof Trees.ClassDef)) return false;
        Names.TypeName typeName = ((Trees.ClassDef)tree4).name();
        Names.Name name3 = name;
        if (name3 != null) {
            if (!name3.equals(typeName)) return false;
            return true;
        }
        if (typeName == null) return true;
        return false;
    }

    public boolean noPredefImportForUnit(Trees.Tree body) {
        return this.isUnitInScala$1(body, this.global().nme().Predef()) || this.isLeadingPredefImport$1(body);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isAbsTypeDef(Trees.Tree tree) {
        boolean bl = false;
        Trees.TypeDef typeDef = null;
        if (tree instanceof Trees.TypeDef) {
            bl = true;
            typeDef = (Trees.TypeDef)tree;
            if (typeDef.rhs() instanceof Trees.TypeBoundsTree) {
                return true;
            }
        }
        if (!bl) return false;
        return typeDef.rhs().tpe() instanceof Types.TypeBounds;
    }

    public boolean isAliasTypeDef(Trees.Tree tree) {
        boolean bl = tree instanceof Trees.TypeDef ? !this.isAbsTypeDef(tree) : false;
        return bl;
    }

    public boolean isApplyDynamicName(Names.Name name) {
        block3: {
            block2: {
                Names.Name name2 = name;
                Names.TermName termName = this.global().nme().updateDynamic();
                if (!(name2 == null ? termName != null : !name2.equals(termName))) break block2;
                Names.Name name3 = name;
                Names.TermName termName2 = this.global().nme().selectDynamic();
                if (!(name3 == null ? termName2 != null : !name3.equals(termName2))) break block2;
                Names.Name name4 = name;
                Names.TermName termName3 = this.global().nme().applyDynamic();
                if (!(name4 == null ? termName3 != null : !name4.equals(termName3))) break block2;
                Names.Name name5 = name;
                Names.TermName termName4 = this.global().nme().applyDynamicNamed();
                if (name5 != null ? !name5.equals(termName4) : termName4 != null) break block3;
            }
            return true;
        }
        return false;
    }

    public boolean isNullaryInvocation(Trees.Tree tree) {
        if (tree.symbol() != null && tree.symbol().isMethod()) {
            boolean bl;
            if (tree instanceof Trees.TypeApply) {
                Trees.Tree fun = ((Trees.TypeApply)tree).fun();
                bl = this.isNullaryInvocation(fun);
            } else {
                bl = tree instanceof Trees.RefTree;
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }

    public boolean isMacroApplication(Trees.Tree tree) {
        Symbols.Symbol sym;
        return !tree.isDef() && (sym = tree.symbol()) != null && sym.isTermMacro() && !sym.isErroneous();
    }

    public boolean isMacroApplicationOrBlock(Trees.Tree tree) {
        boolean bl;
        if (tree instanceof Trees.Block) {
            Trees.Tree expr = ((Trees.Block)tree).expr();
            bl = this.isMacroApplicationOrBlock(expr);
        } else {
            bl = this.isMacroApplication(tree);
        }
        return bl;
    }

    private final void StripCast$lzycompute$1() {
        synchronized (this) {
            if (this.StripCast$module == null) {
                this.StripCast$module = new TreeInfo$StripCast$(this);
            }
            return;
        }
    }

    private final void WildcardStarArg$lzycompute$1() {
        synchronized (this) {
            if (this.WildcardStarArg$module == null) {
                this.WildcardStarArg$module = new TreeInfo$WildcardStarArg$(this);
            }
            return;
        }
    }

    private final void Applied$lzycompute$1() {
        synchronized (this) {
            if (this.Applied$module == null) {
                this.Applied$module = new TreeInfo$Applied$(this);
            }
            return;
        }
    }

    private final void Unapplied$lzycompute$1() {
        synchronized (this) {
            if (this.Unapplied$module == null) {
                this.Unapplied$module = new TreeInfo$Unapplied$(this);
            }
            return;
        }
    }

    private final void IsTrue$lzycompute$1() {
        synchronized (this) {
            if (this.IsTrue$module == null) {
                this.IsTrue$module = new TreeInfo$IsTrue$(this);
            }
            return;
        }
    }

    private final void IsFalse$lzycompute$1() {
        synchronized (this) {
            if (this.IsFalse$module == null) {
                this.IsFalse$module = new TreeInfo$IsFalse$(this);
            }
            return;
        }
    }

    private final void DynamicUpdate$lzycompute$1() {
        synchronized (this) {
            if (this.DynamicUpdate$module == null) {
                this.DynamicUpdate$module = new TreeInfo$DynamicUpdate$(this);
            }
            return;
        }
    }

    private final void DynamicApplication$lzycompute$1() {
        synchronized (this) {
            if (this.DynamicApplication$module == null) {
                this.DynamicApplication$module = new TreeInfo$DynamicApplication$(this);
            }
            return;
        }
    }

    private final void DynamicApplicationNamed$lzycompute$1() {
        synchronized (this) {
            if (this.DynamicApplicationNamed$module == null) {
                this.DynamicApplicationNamed$module = new TreeInfo$DynamicApplicationNamed$(this);
            }
            return;
        }
    }

    private final void MacroImplReference$lzycompute$1() {
        synchronized (this) {
            if (this.MacroImplReference$module == null) {
                this.MacroImplReference$module = new TreeInfo$MacroImplReference$(this);
            }
            return;
        }
    }

    public static final /* synthetic */ boolean $anonfun$isConstructorWithDefault$1(Trees.ValDef x$1) {
        return x$1.mods().hasDefault();
    }

    private final boolean isWarnableRefTree$1(Trees.Tree tree$1) {
        Trees.RefTree refTree;
        boolean bl = tree$1 instanceof Trees.RefTree ? this.isExprSafeToInline((refTree = (Trees.RefTree)((Object)tree$1)).qualifier()) && ((Trees.SymTree)((Object)refTree)).symbol() != null && ((Trees.SymTree)((Object)refTree)).symbol().isAccessor() : false;
        return bl;
    }

    private final boolean isWarnableSymbol$1(Trees.Tree tree$1) {
        Symbols.Symbol sym = tree$1.symbol();
        if (sym == null || !sym.isModule() && !sym.isLazy() && !this.global().definitions().isByNameParamType(sym.tpe_$times())) {
            return true;
        }
        this.global().debuglog((Function0<String> & java.io.Serializable & Serializable)() -> new StringBuilder(60).append("'Pure' but side-effecting expression in statement position: ").append(tree$1).toString());
        return false;
    }

    public static final /* synthetic */ void $anonfun$mapMethodParamsAndArgs$1(Builder b$1, Function2 f$1, Symbols.Symbol param2, Trees.Tree arg) {
        b$1.$plus$eq(f$1.apply(param2, arg));
    }

    private final boolean fail$1(List params$1, List args$1) {
        this.global().devWarning((Function0<String> & java.io.Serializable & Serializable)() -> {
            String string = new StringBuilder(110).append("|Mismatch trying to zip method parameters and argument list:\n            |  params = ").append(params$1).append("\n            |    args = ").append(args$1).toString();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            return new StringOps(string).stripMargin();
        });
        return false;
    }

    public static final /* synthetic */ Symbols.Symbol $anonfun$foreachMethodParamAndArg$2(List params$1) {
        return (Symbols.Symbol)params$1.last();
    }

    public static final /* synthetic */ boolean $anonfun$isFunctionMissingParamType$1(Trees.ValDef x$2) {
        return x$2.tpt().isEmpty();
    }

    private static final Symbols.Symbol sym$1(Trees.Tree tree$2) {
        return tree$2.symbol();
    }

    private static final boolean isVar$1(Trees.Tree tree$2) {
        return TreeInfo.sym$1(tree$2).isVariable();
    }

    public static final /* synthetic */ boolean $anonfun$stripNamedApplyBlock$1(Trees.Tree x$3) {
        return x$3 instanceof Trees.ValDef;
    }

    private final boolean isVarPatternDeep0$1(Trees.Tree tree) {
        while (tree instanceof Trees.Bind) {
            tree = ((Trees.Bind)tree).body();
        }
        boolean bl = tree instanceof Trees.Ident ? this.isVarPattern(tree) : false;
        return bl;
    }

    public static final /* synthetic */ boolean $anonfun$detectTypecheckedTree$1(Trees.Tree x0$1) {
        Trees.DefDef defDef;
        boolean bl = x0$1 instanceof Trees.DefDef ? (defDef = (Trees.DefDef)x0$1).mods().hasAccessorFlag() || defDef.mods().isSynthetic() : (x0$1 instanceof Trees.MemberDef ? ((Trees.MemberDef)x0$1).hasExistingSymbol() : false);
        return bl;
    }

    public static final /* synthetic */ boolean $anonfun$untypecheckedTreeBody$2(TreeInfo $this, Trees.DefDef x4$1, Trees.Tree x0$2) {
        boolean bl;
        if (x0$2 instanceof Trees.ValDef) {
            Trees.ValDef valDef = (Trees.ValDef)x0$2;
            Names.TermName termName = x4$1.name();
            Names.TermName termName2 = $this.global().TermNameOps(valDef.name()).dropLocal();
            bl = !(termName != null ? !termName.equals(termName2) : termName2 != null);
        } else {
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ boolean $anonfun$untypecheckedTreeBody$1(TreeInfo $this, List tbody$1, Trees.Tree x0$1) {
        Trees.DefDef defDef;
        if (x0$1 instanceof Trees.ValDef) {
            return true;
        }
        if (x0$1 instanceof Trees.TypeDef) {
            return true;
        }
        boolean bl = false;
        if (bl) {
            return true;
        }
        if (x0$1 instanceof Trees.DefDef && (defDef = (Trees.DefDef)x0$1).mods().hasAccessorFlag()) {
            void var6_7;
            if ($this.global().nme().isSetterName(defDef.name())) return false;
            if (tbody$1 == null) {
                throw null;
            }
            List list = tbody$1;
            while (!var6_7.isEmpty()) {
                Trees.Tree tree = (Trees.Tree)var6_7.head();
                if (TreeInfo.$anonfun$untypecheckedTreeBody$2($this, defDef, tree)) {
                    return false;
                }
                LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var6_7.tail();
            }
            return true;
        }
        if (!(x0$1 instanceof Trees.MemberDef)) return true;
        if (((Trees.MemberDef)x0$1).mods().isSynthetic()) return false;
        return true;
    }

    private final List filterBody$1(List body, List tbody$1) {
        return (List)body.filter((Function1<Trees.Tree, Object> & java.io.Serializable & Serializable)x0$1 -> BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$untypecheckedTreeBody$1(this, tbody$1, x0$1)));
    }

    private static final Trees.Tree lazyValDefRhs$1(Trees.Tree body) {
        Trees.Tree tree;
        List<Trees.Tree> list;
        Some<List<Trees.Tree>> some;
        Trees.Tree tree2 = body instanceof Trees.Block && !(some = List$.MODULE$.unapplySeq(list = ((Trees.Block)body).stats())).isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0 && (tree = (Trees.Tree)((LinearSeqOptimized)some.get()).apply(0)) instanceof Trees.Assign ? ((Trees.Assign)tree).rhs() : body;
        return tree2;
    }

    public static final /* synthetic */ boolean $anonfun$untypecheckedTreeBody$4(TreeInfo $this, Names.TermName vname$1, Trees.Tree x0$2) {
        boolean bl;
        if (x0$2 instanceof Trees.DefDef) {
            Names.TermName termName = ((Trees.DefDef)x0$2).name();
            Names.TermName termName2 = $this.global().TermNameOps(vname$1).dropLocal();
            bl = !(termName != null ? !termName.equals(termName2) : termName2 != null);
        } else {
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ Trees.ValDef $anonfun$untypecheckedTreeBody$5(TreeInfo $this, Trees.Modifiers vmods$1, Trees.Tree vrhs$1, Trees.ValDef x2$1, Trees.Tree dd) {
        void var8_8;
        void var7_7;
        void var6_6;
        if (!(dd instanceof Trees.DefDef)) {
            throw new MatchError(dd);
        }
        Trees.DefDef defDef = (Trees.DefDef)dd;
        Trees.Modifiers dmods = defDef.mods();
        Names.TermName dname = defDef.name();
        Trees.Tree drhs = defDef.rhs();
        void dmods2 = var6_6;
        void dname2 = var7_7;
        void drhs2 = var8_8;
        int defDefMask = 524823;
        Trees.Modifiers vdMods = vmods$1.$amp$tilde(defDefMask).$bar(dmods2.$amp(defDefMask).flags());
        Trees.Tree vdRhs = vmods$1.isLazy() ? TreeInfo.lazyValDefRhs$1((Trees.Tree)drhs2) : vrhs$1;
        Trees.Tree x$5 = $this.global().copyValDef$default$4(x2$1);
        return $this.global().copyValDef(x2$1, vdMods, (Names.Name)dname2, x$5, vdRhs);
    }

    private final List recoverBody$1(List body, List tbody$1) {
        return body.map((Function1<Trees.Tree, Trees.Tree> & java.io.Serializable & Serializable)x0$1 -> {
            if (x0$1 instanceof Trees.ValDef) {
                Trees.ValDef valDef = (Trees.ValDef)x0$1;
                Trees.Modifiers vmods = valDef.mods();
                Names.TermName vname = valDef.name();
                Trees.Tree vrhs = valDef.rhs();
                if (this.global().nme().isLocalName(vname)) {
                    void var17_20;
                    void var16_16;
                    void var15_13;
                    block11: {
                        void var14_8;
                        if (tbody$1 == null) {
                            throw null;
                        }
                        List list = tbody$1;
                        while (!var14_8.isEmpty()) {
                            Trees.Tree tree = (Trees.Tree)var14_8.head();
                            if (TreeInfo.$anonfun$untypecheckedTreeBody$4(this, vname, tree)) {
                                Some some = new Some(var14_8.head());
                                break block11;
                            }
                            LinearSeqOptimized linearSeqOptimized = (LinearSeqOptimized)var14_8.tail();
                        }
                        None$ none$ = None$.MODULE$;
                    }
                    if (var15_13 == null) {
                        throw null;
                    }
                    if (var15_13.isEmpty()) {
                        None$ none$ = None$.MODULE$;
                    } else {
                        Trees.Tree tree = (Trees.Tree)var15_13.get();
                        Some<Trees.ValDef> some = new Some<Trees.ValDef>(TreeInfo.$anonfun$untypecheckedTreeBody$5(this, vmods, vrhs, valDef, tree));
                    }
                    if (var16_16 == null) {
                        throw null;
                    }
                    if (var16_16.isEmpty()) {
                        Trees.ValDef valDef2 = valDef;
                        return (Trees.Tree)var17_20;
                    } else {
                        Object a = var16_16.get();
                    }
                    return (Trees.Tree)var17_20;
                }
            }
            if (!(x0$1 instanceof Trees.DefDef)) return x0$1;
            Trees.DefDef defDef = (Trees.DefDef)x0$1;
            Trees.Modifiers mods = defDef.mods();
            Names.TermName name = defDef.name();
            Trees.Tree tpt = defDef.tpt();
            Trees.Tree rhs = defDef.rhs();
            if (!mods.hasAccessorFlag()) return x0$1;
            Trees.Modifiers vdMods = (!mods.hasStableFlag() ? mods.$bar(4096) : mods.$amp$tilde(0x400000L)).$amp$tilde(0x8000000L);
            return new Trees.ValDef(this.global(), vdMods, name, tpt, rhs);
        }, List$.MODULE$.canBuildFrom());
    }

    public static final /* synthetic */ boolean $anonfun$firstConstructor$1(TreeInfo $this, Trees.Tree x0$1) {
        boolean bl;
        if (x0$1 instanceof Trees.DefDef) {
            Trees.DefDef defDef = (Trees.DefDef)x0$1;
            bl = $this.global().nme().isConstructorName(defDef.name());
        } else {
            bl = false;
        }
        return bl;
    }

    public static final /* synthetic */ Trees$EmptyTree$ $anonfun$firstConstructor$2(TreeInfo $this) {
        return $this.global().EmptyTree();
    }

    public static final /* synthetic */ boolean $anonfun$hasUntypedPreSuperFields$1(Trees.ValDef x$5) {
        return x$5.tpt().isEmpty();
    }

    public static final /* synthetic */ boolean $anonfun$mayBeTypePat$2(Trees.Tree x$6) {
        return x$6 instanceof Trees.Bind;
    }

    private final boolean isLeadingPredefImport$1(Trees.Tree defn) {
        boolean bl;
        if (defn instanceof Trees.PackageDef) {
            boolean bl2;
            block7: {
                List<Trees.Tree> defs1 = ((Trees.PackageDef)defn).stats();
                if (defs1 == null) {
                    throw null;
                }
                LinearSeqOptimized exists_these = defs1;
                while (!exists_these.isEmpty()) {
                    Trees.Tree tree = (Trees.Tree)exists_these.head();
                    if (this.isLeadingPredefImport$1(tree)) {
                        bl2 = true;
                        break block7;
                    }
                    exists_these = (LinearSeqOptimized)exists_these.tail();
                }
                bl2 = false;
            }
            bl = bl2;
        } else if (defn instanceof Trees.Import) {
            Trees.Tree expr = ((Trees.Import)defn).expr();
            bl = this.global().isReferenceToPredef(expr);
        } else {
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isUnitInScala$1(Trees.Tree tree, Names.Name name) {
        if (!(tree instanceof Trees.PackageDef)) return false;
        Trees.PackageDef packageDef = (Trees.PackageDef)tree;
        Trees.RefTree refTree = packageDef.pid();
        List<Trees.Tree> defs = packageDef.stats();
        if (!(refTree instanceof Trees.Ident)) return false;
        Names.Name name2 = ((Trees.Ident)refTree).name();
        Names.TermName termName = this.global().nme().scala_();
        if (termName != null) {
            if (!termName.equals(name2)) return false;
            return this.firstDefinesClassOrObject(defs, name);
        }
        if (name2 == null) return this.firstDefinesClassOrObject(defs, name);
        return false;
    }

    public static final /* synthetic */ Object $anonfun$isExprSafeToInline$1$adapted(TreeInfo $this, Trees.Tree tree) {
        return BoxesRunTime.boxToBoolean($this.isPureDef(tree));
    }

    public static final /* synthetic */ Object $anonfun$isFunctionMissingParamType$1$adapted(Trees.ValDef x$2) {
        return BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$isFunctionMissingParamType$1(x$2));
    }

    public static final /* synthetic */ Object $anonfun$stripNamedApplyBlock$1$adapted(Trees.Tree x$3) {
        return BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$stripNamedApplyBlock$1(x$3));
    }

    public static final /* synthetic */ Object $anonfun$firstConstructor$1$adapted(TreeInfo $this, Trees.Tree x0$1) {
        return BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$firstConstructor$1($this, x0$1));
    }

    public static final /* synthetic */ Object $anonfun$hasUntypedPreSuperFields$1$adapted(Trees.ValDef x$5) {
        return BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$hasUntypedPreSuperFields$1(x$5));
    }

    public static final /* synthetic */ Object $anonfun$mayBeTypePat$1$adapted(TreeInfo $this, Trees.Tree tree) {
        return BoxesRunTime.boxToBoolean($this.mayBeTypePat(tree));
    }

    public static final /* synthetic */ Object $anonfun$mayBeTypePat$2$adapted(Trees.Tree x$6) {
        return BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$mayBeTypePat$2(x$6));
    }

    public static final /* synthetic */ Object $anonfun$isSequenceValued$1$adapted(TreeInfo $this, Trees.Tree tree) {
        return BoxesRunTime.boxToBoolean($this.isSequenceValued(tree));
    }

    public static final /* synthetic */ Object $anonfun$untypecheckedTreeBody$2$adapted(TreeInfo $this, Trees.DefDef x4$1, Trees.Tree x0$2) {
        return BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$untypecheckedTreeBody$2($this, x4$1, x0$2));
    }

    public static final /* synthetic */ Object $anonfun$untypecheckedTreeBody$4$adapted(TreeInfo $this, Names.TermName vname$1, Trees.Tree x0$2) {
        return BoxesRunTime.boxToBoolean(TreeInfo.$anonfun$untypecheckedTreeBody$4($this, vname$1, x0$2));
    }

    public static final /* synthetic */ Object $anonfun$noPredefImportForUnit$1$adapted(TreeInfo $this, Trees.Tree defn) {
        return BoxesRunTime.boxToBoolean($this.isLeadingPredefImport$1(defn));
    }

    public final class Applied {
        private final Trees.Tree tree;

        public Trees.Tree tree() {
            return this.tree;
        }

        public Trees.Tree callee() {
            return this.loop$1(this.tree());
        }

        public Trees.Tree core() {
            Trees.Tree tree = this.callee();
            Trees.Tree tree2 = tree instanceof Trees.TypeApply ? ((Trees.TypeApply)tree).fun() : (tree instanceof Trees.AppliedTypeTree ? ((Trees.AppliedTypeTree)tree).tpt() : tree);
            return tree2;
        }

        public List<Trees.Tree> targs() {
            Trees.Tree tree = this.callee();
            List list = tree instanceof Trees.TypeApply ? ((Trees.TypeApply)tree).args() : (tree instanceof Trees.AppliedTypeTree ? ((Trees.AppliedTypeTree)tree).args() : Nil$.MODULE$);
            return list;
        }

        public List<List<Trees.Tree>> argss() {
            return Applied.loop$2(this.tree());
        }

        private final Trees.Tree loop$1(Trees.Tree tree) {
            while (tree instanceof Trees.Apply) {
                tree = ((Trees.Apply)tree).fun();
            }
            return tree;
        }

        private static final List loop$2(Trees.Tree tree) {
            List list;
            if (tree instanceof Trees.Apply) {
                Trees.Apply apply2 = (Trees.Apply)tree;
                Trees.Tree fn = apply2.fun();
                List<Trees.Tree> args2 = apply2.args();
                list = Applied.loop$2(fn).$colon$plus(args2, List$.MODULE$.canBuildFrom());
            } else {
                list = Nil$.MODULE$;
            }
            return list;
        }

        public Applied(TreeInfo $outer, Trees.Tree tree) {
            this.tree = tree;
        }
    }

    public class DynamicApplicationExtractor {
        private final Function1<Names.Name, Object> nameTest;
        public final /* synthetic */ TreeInfo $outer;

        /*
         * WARNING - void declaration
         * Enabled aggressive block sorting
         */
        public Option<Tuple2<Trees.Tree, Object>> unapply(Trees.Tree tree) {
            void var2_18;
            boolean bl = false;
            Trees.Apply apply2 = null;
            if (tree instanceof Trees.Apply) {
                Trees.Tree tree2;
                bl = true;
                apply2 = (Trees.Apply)tree;
                Trees.Tree tree3 = apply2.fun();
                List<Trees.Tree> list = apply2.args();
                if (tree3 instanceof Trees.TypeApply && (tree2 = ((Trees.TypeApply)tree3).fun()) instanceof Trees.Select) {
                    Constants.Constant constant;
                    Trees.Tree tree4;
                    Trees.Select select = (Trees.Select)tree2;
                    Trees.Tree qual = select.qualifier();
                    Names.Name oper = select.name();
                    Some<List<Trees.Tree>> some = List$.MODULE$.unapplySeq(list);
                    if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0 && (tree4 = (Trees.Tree)((LinearSeqOptimized)some.get()).apply(0)) instanceof Trees.Literal && (constant = ((Trees.Literal)tree4).value()) != null) {
                        Object name = constant.value();
                        if (BoxesRunTime.unboxToBoolean(this.nameTest.apply(oper))) {
                            Some<Tuple2<Trees.Tree, Object>> some2 = new Some<Tuple2<Trees.Tree, Object>>(new Tuple2<Trees.Tree, Object>(qual, name));
                            return var2_18;
                        }
                    }
                }
            }
            if (bl) {
                Trees.Tree tree5 = apply2.fun();
                List<Trees.Tree> list = apply2.args();
                if (tree5 instanceof Trees.Select) {
                    Constants.Constant constant;
                    Trees.Tree tree6;
                    Trees.Select select = (Trees.Select)tree5;
                    Trees.Tree qual = select.qualifier();
                    Names.Name oper = select.name();
                    Some<List<Trees.Tree>> some = List$.MODULE$.unapplySeq(list);
                    if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0 && (tree6 = (Trees.Tree)((LinearSeqOptimized)some.get()).apply(0)) instanceof Trees.Literal && (constant = ((Trees.Literal)tree6).value()) != null) {
                        Object name = constant.value();
                        if (BoxesRunTime.unboxToBoolean(this.nameTest.apply(oper))) {
                            Some<Tuple2<Trees.Tree, Object>> some3 = new Some<Tuple2<Trees.Tree, Object>>(new Tuple2<Trees.Tree, Object>(qual, name));
                            return var2_18;
                        }
                    }
                }
            }
            if (bl) {
                Trees.Tree tree7 = apply2.fun();
                List<Trees.Tree> list = apply2.args();
                if (tree7 instanceof Trees.Ident) {
                    Constants.Constant constant;
                    Trees.Tree tree8;
                    Names.Name oper = ((Trees.Ident)tree7).name();
                    Some<List<Trees.Tree>> some = List$.MODULE$.unapplySeq(list);
                    if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(1) == 0 && (tree8 = (Trees.Tree)((LinearSeqOptimized)some.get()).apply(0)) instanceof Trees.Literal && (constant = ((Trees.Literal)tree8).value()) != null) {
                        Object name = constant.value();
                        if (BoxesRunTime.unboxToBoolean(this.nameTest.apply(oper))) {
                            Some<Tuple2<Trees$EmptyTree$, Object>> some4 = new Some<Tuple2<Trees$EmptyTree$, Object>>(new Tuple2<Trees$EmptyTree$, Object>(this.scala$reflect$internal$TreeInfo$DynamicApplicationExtractor$$$outer().global().EmptyTree(), name));
                            return var2_18;
                        }
                    }
                }
            }
            None$ none$ = None$.MODULE$;
            return var2_18;
        }

        public /* synthetic */ TreeInfo scala$reflect$internal$TreeInfo$DynamicApplicationExtractor$$$outer() {
            return this.$outer;
        }

        public DynamicApplicationExtractor(TreeInfo $outer, Function1<Names.Name, Object> nameTest) {
            this.nameTest = nameTest;
            if ($outer == null) {
                throw null;
            }
            this.$outer = $outer;
        }
    }

    public abstract class SeeThroughBlocks<T> {
        public abstract T unapplyImpl(Trees.Tree var1);

        /*
         * Enabled aggressive block sorting
         */
        public T unapply(Trees.Tree x) {
            T t;
            if (x instanceof Trees.Block) {
                Trees.Block block = (Trees.Block)x;
                List<Trees.Tree> list = block.stats();
                Trees.Tree expr = block.expr();
                if (((Object)Nil$.MODULE$).equals(list)) {
                    t = this.unapply(expr);
                    return t;
                }
            }
            t = this.unapplyImpl(x);
            return t;
        }

        public /* synthetic */ TreeInfo scala$reflect$internal$TreeInfo$SeeThroughBlocks$$$outer() {
            return TreeInfo.this;
        }

        public SeeThroughBlocks() {
            if (TreeInfo.this == null) {
                throw null;
            }
        }
    }
}

