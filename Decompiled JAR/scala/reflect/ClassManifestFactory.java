/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect;

import scala.Option;
import scala.collection.Seq;
import scala.collection.immutable.List;
import scala.collection.mutable.ArrayBuilder;
import scala.collection.mutable.WrappedArray;
import scala.reflect.AnyValManifest;
import scala.reflect.ClassManifestDeprecatedApis;
import scala.reflect.ClassManifestFactory$;
import scala.reflect.ClassTag;
import scala.reflect.Manifest;
import scala.reflect.OptManifest;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.runtime.Null$;

@ScalaSignature(bytes="\u0006\u0001\rur!B\u00193\u0011\u00039d!B\u001d3\u0011\u0003Q\u0004\"B \u0002\t\u0003\u0001\u0005bB!\u0002\u0005\u0004%\tA\u0011\u0005\u0007\u0013\u0006\u0001\u000b\u0011B\"\t\u000f)\u000b!\u0019!C\u0001\u0017\"1\u0001+\u0001Q\u0001\n1Cq!U\u0001C\u0002\u0013\u0005!\u000b\u0003\u0004X\u0003\u0001\u0006Ia\u0015\u0005\b1\u0006\u0011\r\u0011\"\u0001Z\u0011\u0019q\u0016\u0001)A\u00055\"9q,\u0001b\u0001\n\u0003\u0001\u0007BB3\u0002A\u0003%\u0011\rC\u0004g\u0003\t\u0007I\u0011A4\t\r1\f\u0001\u0015!\u0003i\u0011\u001di\u0017A1A\u0005\u00029Daa]\u0001!\u0002\u0013y\u0007b\u0002;\u0002\u0005\u0004%\t!\u001e\u0005\u0007u\u0006\u0001\u000b\u0011\u0002<\t\u000fm\f!\u0019!C\u0001y\"9\u00111A\u0001!\u0002\u0013i\b\"CA\u0003\u0003\t\u0007I\u0011AA\u0004\u0011!\t)\"\u0001Q\u0001\n\u0005%\u0001\"CA\f\u0003\t\u0007I\u0011AA\r\u0011!\ti#\u0001Q\u0001\n\u0005m\u0001\"CA\u0018\u0003\t\u0007I\u0011AA\u0019\u0011!\tY$\u0001Q\u0001\n\u0005M\u0002\"CA\u001f\u0003\t\u0007I\u0011AA \u0011!\tI%\u0001Q\u0001\n\u0005\u0005\u0003\"CA&\u0003\t\u0007I\u0011AA'\u0011!\t9&\u0001Q\u0001\n\u0005=\u0003bBA-\u0003\u0011\u0005\u00111\f\u0005\b\u0003\u0003\u000bA\u0011AAB\u0011\u001d\t\u0019*\u0001C\u0001\u0003+Cq!a%\u0002\t\u0003\tY\u000bC\u0004\u0002\u0014\u0006!\t!a:\t\u000f\te\u0011\u0001\"\u0001\u0003\u001c\u00191!\u0011H\u0001\u0005\u0005wA!\"a=&\u0005\u0003\u0005\u000b\u0011\u0002B#\u0011)\u0011y%\nB\u0001B\u0003%!\u0011\u000b\u0005\u000b\u0003s*#\u0011!Q\u0001\n\t\u001d\u0004BCAkK\t\u0005\t\u0015!\u0003\u0003r!1q(\nC\u0001\u0005{BqA!*&\t\u0003\u00129\u000bC\u0005\u00032\u0016\u0012\r\u0011\"\u0011\u00034\"A!\u0011Y\u0013!\u0002\u0013\u0011)\fC\u0004\u0003D\u0016\"\tE!2\t\u000f\tU\u0017\u0001\"\u0001\u0003X\"9!Q[\u0001\u0005\u0002\r%\u0011\u0001F\"mCN\u001cX*\u00198jM\u0016\u001cHOR1di>\u0014\u0018P\u0003\u00024i\u00059!/\u001a4mK\u000e$(\"A\u001b\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001A\u0011\u0001(A\u0007\u0002e\t!2\t\\1tg6\u000bg.\u001b4fgR4\u0015m\u0019;pef\u001c\"!A\u001e\u0011\u0005qjT\"\u0001\u001b\n\u0005y\"$AB!osJ+g-\u0001\u0004=S:LGO\u0010\u000b\u0002o\u0005!!)\u001f;f+\u0005\u0019\u0005c\u0001\u001dE\r&\u0011QI\r\u0002\u000f\u0003:Lh+\u00197NC:Lg-Z:u!\tat)\u0003\u0002Ii\t!!)\u001f;f\u0003\u0015\u0011\u0015\u0010^3!\u0003\u0015\u0019\u0006n\u001c:u+\u0005a\u0005c\u0001\u001dE\u001bB\u0011AHT\u0005\u0003\u001fR\u0012Qa\u00155peR\faa\u00155peR\u0004\u0013\u0001B\"iCJ,\u0012a\u0015\t\u0004q\u0011#\u0006C\u0001\u001fV\u0013\t1FG\u0001\u0003DQ\u0006\u0014\u0018!B\"iCJ\u0004\u0013aA%oiV\t!\fE\u00029\tn\u0003\"\u0001\u0010/\n\u0005u#$aA%oi\u0006!\u0011J\u001c;!\u0003\u0011auN\\4\u0016\u0003\u0005\u00042\u0001\u000f#c!\ta4-\u0003\u0002ei\t!Aj\u001c8h\u0003\u0015auN\\4!\u0003\u00151En\\1u+\u0005A\u0007c\u0001\u001dESB\u0011AH[\u0005\u0003WR\u0012QA\u00127pCR\faA\u00127pCR\u0004\u0013A\u0002#pk\ndW-F\u0001p!\rAD\t\u001d\t\u0003yEL!A\u001d\u001b\u0003\r\u0011{WO\u00197f\u0003\u001d!u.\u001e2mK\u0002\nqAQ8pY\u0016\fg.F\u0001w!\rADi\u001e\t\u0003yaL!!\u001f\u001b\u0003\u000f\t{w\u000e\\3b]\u0006A!i\\8mK\u0006t\u0007%\u0001\u0003V]&$X#A?\u0011\u0007a\"e\u0010\u0005\u0002=\u007f&\u0019\u0011\u0011\u0001\u001b\u0003\tUs\u0017\u000e^\u0001\u0006+:LG\u000fI\u0001\u0004\u0003:LXCAA\u0005!\u0015A\u00141BA\b\u0013\r\tiA\r\u0002\t\u001b\u0006t\u0017NZ3tiB\u0019A(!\u0005\n\u0007\u0005MAGA\u0002B]f\fA!\u00118zA\u00051qJ\u00196fGR,\"!a\u0007\u0011\u000ba\nY!!\b\u0011\t\u0005}\u0011\u0011F\u0007\u0003\u0003CQA!a\t\u0002&\u0005!A.\u00198h\u0015\t\t9#\u0001\u0003kCZ\f\u0017\u0002BA\u0016\u0003C\u0011aa\u00142kK\u000e$\u0018aB(cU\u0016\u001cG\u000fI\u0001\u0007\u0003:Lh+\u00197\u0016\u0005\u0005M\u0002#\u0002\u001d\u0002\f\u0005U\u0002c\u0001\u001f\u00028%\u0019\u0011\u0011\b\u001b\u0003\r\u0005s\u0017PV1m\u0003\u001d\te.\u001f,bY\u0002\nqAT8uQ&tw-\u0006\u0002\u0002BA)\u0001(a\u0003\u0002DA\u0019A(!\u0012\n\u0007\u0005\u001dCGA\u0004O_RD\u0017N\\4\u0002\u00119{G\u000f[5oO\u0002\nAAT;mYV\u0011\u0011q\n\t\u0006q\u0005-\u0011\u0011\u000b\t\u0004y\u0005M\u0013bAA+i\t!a*\u001e7m\u0003\u0015qU\u000f\u001c7!\u0003%1'o\\7DY\u0006\u001c8/\u0006\u0003\u0002^\u0005ED\u0003BA0\u0003o\u0002b!!\u0019\u0002h\u00055db\u0001\u001d\u0002d%\u0019\u0011Q\r\u001a\u0002\u000fA\f7m[1hK&!\u0011\u0011NA6\u00055\u0019E.Y:t\u001b\u0006t\u0017NZ3ti*\u0019\u0011Q\r\u001a\u0011\t\u0005=\u0014\u0011\u000f\u0007\u0001\t\u001d\t\u0019h\bb\u0001\u0003k\u0012\u0011\u0001V\t\u0005\u0003\u0007\ny\u0001C\u0004\u0002z}\u0001\r!a\u001f\u0002\u000b\rd\u0017M\u001f>\u0011\r\u0005}\u0011QPA7\u0013\u0011\ty(!\t\u0003\u000b\rc\u0017m]:\u0002\u0015MLgn\u001a7f)f\u0004X-\u0006\u0003\u0002\u0006\u0006-E\u0003BAD\u0003\u001f\u0003R\u0001OA\u0006\u0003\u0013\u0003B!a\u001c\u0002\f\u00129\u00111\u000f\u0011C\u0002\u00055\u0015cAA\"w!1\u0011\u0011\u0013\u0011A\u0002m\nQA^1mk\u0016\f\u0011b\u00197bgN$\u0016\u0010]3\u0016\t\u0005]\u0015Q\u0014\u000b\u0005\u00033\u000by\n\u0005\u0004\u0002b\u0005\u001d\u00141\u0014\t\u0005\u0003_\ni\nB\u0004\u0002t\u0005\u0012\r!!\u001e\t\u000f\u0005e\u0014\u00051\u0001\u0002\"B\"\u00111UAT!\u0019\ty\"! \u0002&B!\u0011qNAT\t1\tI+a(\u0002\u0002\u0003\u0005)\u0011AA;\u0005\u0011yF%M\u001a\u0016\t\u00055\u00161\u0017\u000b\t\u0003_\u000b),!1\u0002TB1\u0011\u0011MA4\u0003c\u0003B!a\u001c\u00024\u00129\u00111\u000f\u0012C\u0002\u0005U\u0004bBA=E\u0001\u0007\u0011q\u0017\u0019\u0005\u0003s\u000bi\f\u0005\u0004\u0002 \u0005u\u00141\u0018\t\u0005\u0003_\ni\f\u0002\u0007\u0002@\u0006U\u0016\u0011!A\u0001\u0006\u0003\t)H\u0001\u0003`IE\"\u0004bBAbE\u0001\u0007\u0011QY\u0001\u0005CJ<\u0017\u0007\r\u0003\u0002H\u0006=\u0007#\u0002\u001d\u0002J\u00065\u0017bAAfe\tYq\n\u001d;NC:Lg-Z:u!\u0011\ty'a4\u0005\u0019\u0005E\u0017\u0011YA\u0001\u0002\u0003\u0015\t!!\u001e\u0003\t}#\u0013'\u000e\u0005\b\u0003+\u0014\u0003\u0019AAl\u0003\u0011\t'oZ:\u0011\u000bq\nI.!8\n\u0007\u0005mGG\u0001\u0006=e\u0016\u0004X-\u0019;fIz\u0002D!a8\u0002dB)\u0001(!3\u0002bB!\u0011qNAr\t1\t)/a5\u0002\u0002\u0003\u0005)\u0011AA;\u0005\u0011yF%\r\u001c\u0016\t\u0005%\u0018q\u001e\u000b\t\u0003W\f\t0a@\u0003\fA1\u0011\u0011MA4\u0003[\u0004B!a\u001c\u0002p\u00129\u00111O\u0012C\u0002\u0005U\u0004bBAzG\u0001\u0007\u0011Q_\u0001\u0007aJ,g-\u001b=1\t\u0005]\u00181 \t\u0006q\u0005%\u0017\u0011 \t\u0005\u0003_\nY\u0010\u0002\u0007\u0002~\u0006E\u0018\u0011!A\u0001\u0006\u0003\t)H\u0001\u0003`IE:\u0004bBA=G\u0001\u0007!\u0011\u0001\u0019\u0005\u0005\u0007\u00119\u0001\u0005\u0004\u0002 \u0005u$Q\u0001\t\u0005\u0003_\u00129\u0001\u0002\u0007\u0003\n\u0005}\u0018\u0011!A\u0001\u0006\u0003\t)H\u0001\u0003`IEB\u0004bBAkG\u0001\u0007!Q\u0002\t\u0006y\u0005e'q\u0002\u0019\u0005\u0005#\u0011)\u0002E\u00039\u0003\u0013\u0014\u0019\u0002\u0005\u0003\u0002p\tUA\u0001\u0004B\f\u0005\u0017\t\t\u0011!A\u0003\u0002\u0005U$\u0001B0%ce\n\u0011\"\u0019:sCf$\u0016\u0010]3\u0016\t\tu!\u0011\u0006\u000b\u0005\u0005?\u0011Y\u0003\u0005\u0004\u0002b\u0005\u001d$\u0011\u0005\t\u0006y\t\r\"qE\u0005\u0004\u0005K!$!B!se\u0006L\b\u0003BA8\u0005S!q!a\u001d%\u0005\u0004\t)\bC\u0004\u0003.\u0011\u0002\rAa\f\u0002\u0007\u0005\u0014x\r\r\u0003\u00032\tU\u0002#\u0002\u001d\u0002J\nM\u0002\u0003BA8\u0005k!ABa\u000e\u0003,\u0005\u0005\t\u0011!B\u0001\u0003k\u0012Aa\u0018\u00133a\tI\u0012IY:ue\u0006\u001cG\u000fV=qK\u000ec\u0017m]:NC:Lg-Z:u+\u0011\u0011iDa\u0011\u0014\t\u0015Z$q\b\t\u0007\u0003C\n9G!\u0011\u0011\t\u0005=$1\t\u0003\b\u0003g*#\u0019AA;a\u0011\u00119Ea\u0013\u0011\u000ba\nIM!\u0013\u0011\t\u0005=$1\n\u0003\f\u0005\u001b2\u0013\u0011!A\u0001\u0006\u0003\t)H\u0001\u0003`II\n\u0014\u0001\u00028b[\u0016\u0004BAa\u0015\u0003b9!!Q\u000bB/!\r\u00119\u0006N\u0007\u0003\u00053R1Aa\u00177\u0003\u0019a$o\\8u}%\u0019!q\f\u001b\u0002\rA\u0013X\rZ3g\u0013\u0011\u0011\u0019G!\u001a\u0003\rM#(/\u001b8h\u0015\r\u0011y\u0006\u000e\u0019\u0005\u0005S\u0012i\u0007\u0005\u0004\u0002 \u0005u$1\u000e\t\u0005\u0003_\u0012i\u0007B\u0006\u0003p!\n\t\u0011!A\u0003\u0002\u0005U$\u0001B0%eI\u0002R\u0001PAm\u0005g\u0002DA!\u001e\u0003zA)\u0001(!3\u0003xA!\u0011q\u000eB=\t-\u0011Y(KA\u0001\u0002\u0003\u0015\t!!\u001e\u0003\t}##g\r\u000b\u000b\u0005\u007f\u0012\u0019I!$\u0003\u0010\ne\u0005#\u0002BAK\t\u0005S\"A\u0001\t\u000f\u0005M(\u00061\u0001\u0003\u0006B\"!q\u0011BF!\u0015A\u0014\u0011\u001aBE!\u0011\tyGa#\u0005\u0019\t5#1QA\u0001\u0002\u0003\u0015\t!!\u001e\t\u000f\t=#\u00061\u0001\u0003R!9\u0011\u0011\u0010\u0016A\u0002\tE\u0005\u0007\u0002BJ\u0005/\u0003b!a\b\u0002~\tU\u0005\u0003BA8\u0005/#ABa\u001c\u0003\u0010\u0006\u0005\t\u0011!B\u0001\u0003kBq!!6+\u0001\u0004\u0011Y\nE\u0003=\u00033\u0014i\n\r\u0003\u0003 \n\r\u0006#\u0002\u001d\u0002J\n\u0005\u0006\u0003BA8\u0005G#ABa\u001f\u0003\u001a\u0006\u0005\t\u0011!B\u0001\u0003k\nAB];oi&lWm\u00117bgN,\"A!+1\t\t-&q\u0016\t\u0007\u0003?\tiH!,\u0011\t\u0005=$q\u0016\u0003\f\u0005_Z\u0013\u0011!A\u0001\u0006\u0003\t)(A\u0007usB,\u0017I]4v[\u0016tGo]\u000b\u0003\u0005k\u0003bAa.\u0003<\nMdb\u0001\u001f\u0003:&\u0019\u0011Q\r\u001b\n\t\tu&q\u0018\u0002\u0005\u0019&\u001cHOC\u0002\u0002fQ\na\u0002^=qK\u0006\u0013x-^7f]R\u001c\b%\u0001\u0005u_N#(/\u001b8h)\t\u00119\r\u0005\u0003\u0002 \t%\u0017\u0002\u0002B2\u0003CAs!\nBg\u0003#\u0013\u0019\u000eE\u0002=\u0005\u001fL1A!55\u0005A\u0019VM]5bYZ+'o]5p]VKEIH\u0001\u0002\u00031\t'm\u001d;sC\u000e$H+\u001f9f+\u0011\u0011INa8\u0015\u0015\tm'\u0011\u001dBw\u0005_\u0014Y\u0010\u0005\u0004\u0002b\u0005\u001d$Q\u001c\t\u0005\u0003_\u0012y\u000eB\u0004\u0002t=\u0012\r!!\u001e\t\u000f\u0005Mx\u00061\u0001\u0003dB\"!Q\u001dBu!\u0015A\u0014\u0011\u001aBt!\u0011\tyG!;\u0005\u0019\t-(\u0011]A\u0001\u0002\u0003\u0015\t!!\u001e\u0003\t}##\u0007\u000e\u0005\b\u0005\u001fz\u0003\u0019\u0001B)\u0011\u001d\tIh\fa\u0001\u0005c\u0004DAa=\u0003xB1\u0011qDA?\u0005k\u0004B!a\u001c\u0003x\u0012a!\u0011 Bx\u0003\u0003\u0005\tQ!\u0001\u0002v\t!q\f\n\u001a6\u0011\u001d\t)n\fa\u0001\u0005{\u0004R\u0001PAm\u0005\u007f\u0004Da!\u0001\u0004\u0006A)\u0001(!3\u0004\u0004A!\u0011qNB\u0003\t1\u00199Aa?\u0002\u0002\u0003\u0005)\u0011AA;\u0005\u0011yFE\r\u001c\u0016\t\r-1\u0011\u0003\u000b\u000b\u0007\u001b\u0019\u0019ba\b\u0004\"\r=\u0002CBA1\u0003O\u001ay\u0001\u0005\u0003\u0002p\rEAaBA:a\t\u0007\u0011Q\u000f\u0005\b\u0003g\u0004\u0004\u0019AB\u000ba\u0011\u00199ba\u0007\u0011\u000ba\nIm!\u0007\u0011\t\u0005=41\u0004\u0003\r\u0007;\u0019\u0019\"!A\u0001\u0002\u000b\u0005\u0011Q\u000f\u0002\u0005?\u0012\u0012t\u0007C\u0004\u0003PA\u0002\rA!\u0015\t\u000f\r\r\u0002\u00071\u0001\u0004&\u0005QQ\u000f\u001d9fe\n|WO\u001c31\t\r\u001d21\u0006\t\u0007\u0003C\n9g!\u000b\u0011\t\u0005=41\u0006\u0003\r\u0007[\u0019\t#!A\u0001\u0002\u000b\u0005\u0011Q\u000f\u0002\u0005?\u0012\u0012\u0004\bC\u0004\u0002VB\u0002\ra!\r\u0011\u000bq\nIna\r1\t\rU2\u0011\b\t\u0006q\u0005%7q\u0007\t\u0005\u0003_\u001aI\u0004\u0002\u0007\u0004<\r=\u0012\u0011!A\u0001\u0006\u0003\t)H\u0001\u0003`IIJ\u0004")
public final class ClassManifestFactory {
    public static <T> ClassTag<T> abstractType(OptManifest<?> optManifest, String string, ClassTag<?> classTag, Seq<OptManifest<?>> seq) {
        return ClassManifestFactory$.MODULE$.abstractType(optManifest, string, classTag, seq);
    }

    public static <T> ClassTag<T> abstractType(OptManifest<?> optManifest, String string, Class<?> clazz, Seq<OptManifest<?>> seq) {
        return ClassManifestFactory$.MODULE$.abstractType(optManifest, string, clazz, seq);
    }

    public static <T> ClassTag<Object> arrayType(OptManifest<?> optManifest) {
        return ClassManifestFactory$.MODULE$.arrayType(optManifest);
    }

    public static <T> ClassTag<T> classType(OptManifest<?> optManifest, Class<?> clazz, Seq<OptManifest<?>> seq) {
        return ClassManifestFactory$.MODULE$.classType(optManifest, clazz, seq);
    }

    public static <T> ClassTag<T> classType(Class<?> clazz, OptManifest<?> optManifest, Seq<OptManifest<?>> seq) {
        return ClassManifestFactory$.MODULE$.classType(clazz, optManifest, seq);
    }

    public static <T> ClassTag<T> classType(Class<?> clazz) {
        return ClassManifestFactory$.MODULE$.classType(clazz);
    }

    public static <T> Manifest<T> singleType(Object object) {
        return ClassManifestFactory$.MODULE$.singleType(object);
    }

    public static <T> ClassTag<T> fromClass(Class<T> clazz) {
        return ClassManifestFactory$.MODULE$.fromClass(clazz);
    }

    public static Manifest<Null$> Null() {
        return ClassManifestFactory$.MODULE$.Null();
    }

    public static Manifest<Nothing$> Nothing() {
        return ClassManifestFactory$.MODULE$.Nothing();
    }

    public static Manifest<Object> AnyVal() {
        return ClassManifestFactory$.MODULE$.AnyVal();
    }

    public static Manifest<Object> Object() {
        return ClassManifestFactory$.MODULE$.Object();
    }

    public static Manifest<Object> Any() {
        return ClassManifestFactory$.MODULE$.Any();
    }

    public static AnyValManifest<BoxedUnit> Unit() {
        return ClassManifestFactory$.MODULE$.Unit();
    }

    public static AnyValManifest<Object> Boolean() {
        return ClassManifestFactory$.MODULE$.Boolean();
    }

    public static AnyValManifest<Object> Double() {
        return ClassManifestFactory$.MODULE$.Double();
    }

    public static AnyValManifest<Object> Float() {
        return ClassManifestFactory$.MODULE$.Float();
    }

    public static AnyValManifest<Object> Long() {
        return ClassManifestFactory$.MODULE$.Long();
    }

    public static AnyValManifest<Object> Int() {
        return ClassManifestFactory$.MODULE$.Int();
    }

    public static AnyValManifest<Object> Char() {
        return ClassManifestFactory$.MODULE$.Char();
    }

    public static AnyValManifest<Object> Short() {
        return ClassManifestFactory$.MODULE$.Short();
    }

    public static AnyValManifest<Object> Byte() {
        return ClassManifestFactory$.MODULE$.Byte();
    }

    public static class AbstractTypeClassManifest<T>
    implements ClassTag<T> {
        public static final long serialVersionUID = 1L;
        private final OptManifest<?> prefix;
        private final String name;
        private final Class<?> clazz;
        private final List<OptManifest<?>> typeArguments;

        @Override
        public ClassTag<Object> wrap() {
            return ClassTag.wrap$(this);
        }

        @Override
        public Object newArray(int len) {
            return ClassTag.newArray$(this, len);
        }

        @Override
        public Option<T> unapply(Object x) {
            return ClassTag.unapply$(this, x);
        }

        @Override
        public boolean canEqual(Object x) {
            return ClassTag.canEqual$(this, x);
        }

        @Override
        public boolean equals(Object x) {
            return ClassTag.equals$(this, x);
        }

        @Override
        public int hashCode() {
            return ClassTag.hashCode$(this);
        }

        @Override
        public Class<?> erasure() {
            return ClassManifestDeprecatedApis.erasure$(this);
        }

        @Override
        public boolean $less$colon$less(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$less$colon$less$(this, that);
        }

        @Override
        public boolean $greater$colon$greater(ClassTag<?> that) {
            return ClassManifestDeprecatedApis.$greater$colon$greater$(this, that);
        }

        @Override
        public <T> Class<Object> arrayClass(Class<?> tp) {
            return ClassManifestDeprecatedApis.arrayClass$(this, tp);
        }

        @Override
        public ClassTag<Object> arrayManifest() {
            return ClassManifestDeprecatedApis.arrayManifest$(this);
        }

        @Override
        public Object[] newArray2(int len) {
            return ClassManifestDeprecatedApis.newArray2$(this, len);
        }

        @Override
        public Object[][] newArray3(int len) {
            return ClassManifestDeprecatedApis.newArray3$(this, len);
        }

        @Override
        public Object[][][] newArray4(int len) {
            return ClassManifestDeprecatedApis.newArray4$(this, len);
        }

        @Override
        public Object[][][][] newArray5(int len) {
            return ClassManifestDeprecatedApis.newArray5$(this, len);
        }

        @Override
        public WrappedArray<T> newWrappedArray(int len) {
            return ClassManifestDeprecatedApis.newWrappedArray$(this, len);
        }

        @Override
        public ArrayBuilder<T> newArrayBuilder() {
            return ClassManifestDeprecatedApis.newArrayBuilder$(this);
        }

        @Override
        public String argString() {
            return ClassManifestDeprecatedApis.argString$(this);
        }

        @Override
        public Class<?> runtimeClass() {
            return this.clazz;
        }

        @Override
        public List<OptManifest<?>> typeArguments() {
            return this.typeArguments;
        }

        @Override
        public String toString() {
            return new StringBuilder(1).append(this.prefix.toString()).append("#").append(this.name).append(this.argString()).toString();
        }

        public AbstractTypeClassManifest(OptManifest<?> prefix, String name, Class<?> clazz, Seq<OptManifest<?>> args2) {
            this.prefix = prefix;
            this.name = name;
            this.clazz = clazz;
            ClassManifestDeprecatedApis.$init$(this);
            ClassTag.$init$(this);
            this.typeArguments = args2.toList();
        }
    }
}

