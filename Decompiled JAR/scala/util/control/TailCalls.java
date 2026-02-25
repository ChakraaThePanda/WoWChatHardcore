/*
 * Decompiled with CFR 0.152.
 */
package scala.util.control;

import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import scala.util.Either;
import scala.util.Left;
import scala.util.control.TailCalls$;

@ScalaSignature(bytes="\u0006\u0001\r5r!B'O\u0011\u0003)f!B,O\u0011\u0003A\u0006\"B/\u0002\t\u0003qf!B0\u0002\u0003\u0003\u0001\u0007\"B/\u0004\t\u0003\u0011\u0007\"\u00029\u0004\t\u000b\t\b\"\u0002?\u0004\t\u000bi\bbBA\u0005\u0007\u0011\u0015\u00111\u0002\u0005\b\u0003_\u0019AQAA\u0019\r\u0019\t)$\u0001%\u00028!Q\u0011QJ\u0005\u0003\u0016\u0004%\t!a\u0014\t\u0015\u0005M\u0013B!E!\u0002\u0013\t\t\u0006\u0003\u0004^\u0013\u0011\u0005\u0011Q\u000b\u0005\n\u00037J\u0011\u0011!C\u0001\u0003;B\u0011\"!\u001c\n#\u0003%\t!a\u001c\t\u0013\u0005\u0015\u0015\"!A\u0005B\u0005\u001d\u0005\"CAM\u0013\u0005\u0005I\u0011AAN\u0011%\t\u0019+CA\u0001\n\u0003\t)\u000bC\u0005\u0002,&\t\t\u0011\"\u0011\u0002.\"I\u00111X\u0005\u0002\u0002\u0013\u0005\u0011Q\u0018\u0005\n\u0003\u000fL\u0011\u0011!C!\u0003\u0013D\u0011\"a3\n\u0003\u0003%\t%!4\t\u0013\u0005=\u0017\"!A\u0005B\u0005Ew!CAk\u0003\u0005\u0005\t\u0012CAl\r%\t)$AA\u0001\u0012#\tI\u000e\u0003\u0004^1\u0011\u0005\u00111\u001c\u0005\n\u0003\u0017D\u0012\u0011!C#\u0003\u001bD\u0011\"!8\u0019\u0003\u0003%\t)a8\t\u0013\u0005=\b$!A\u0005\u0002\u0006E\b\"\u0003B\u00051\u0005\u0005I\u0011\u0002B\u0006\r\u0019\u0011\u0019\"\u0001%\u0003\u0016!Q!q\u0004\u0010\u0003\u0016\u0004%\tA!\t\t\u0015\t\rbD!E!\u0002\u0013\u0011Y\u0002\u0003\u0004^=\u0011\u0005!Q\u0005\u0005\n\u00037r\u0012\u0011!C\u0001\u0005WA\u0011\"!\u001c\u001f#\u0003%\tAa\u000e\t\u0013\u0005\u0015e$!A\u0005B\u0005\u001d\u0005\"CAM=\u0005\u0005I\u0011AAN\u0011%\t\u0019KHA\u0001\n\u0003\u0011y\u0004C\u0005\u0002,z\t\t\u0011\"\u0011\u0002.\"I\u00111\u0018\u0010\u0002\u0002\u0013\u0005!1\t\u0005\n\u0003\u000ft\u0012\u0011!C!\u0003\u0013D\u0011\"a3\u001f\u0003\u0003%\t%!4\t\u0013\u0005=g$!A\u0005B\t\u001ds!\u0003B&\u0003\u0005\u0005\t\u0012\u0003B'\r%\u0011\u0019\"AA\u0001\u0012#\u0011y\u0005\u0003\u0004^[\u0011\u0005!\u0011\u000b\u0005\n\u0003\u0017l\u0013\u0011!C#\u0003\u001bD\u0011\"!8.\u0003\u0003%\tIa\u0015\t\u0013\u0005=X&!A\u0005\u0002\n}\u0003\"\u0003B\u0005[\u0005\u0005I\u0011\u0002B\u0006\r\u0019\u0011i'\u0001%\u0003p!Q!\u0011P\u001a\u0003\u0016\u0004%\tAa\u001f\t\u0015\t\r5G!E!\u0002\u0013\u0011i\bC\u0005yg\tU\r\u0011\"\u0001\u0003\u0006\"Q!\u0011R\u001a\u0003\u0012\u0003\u0006IAa\"\t\ru\u001bD\u0011\u0001BF\u0011%\tYfMA\u0001\n\u0003\u0011\u0019\nC\u0005\u0002nM\n\n\u0011\"\u0001\u0003,\"I!QW\u001a\u0012\u0002\u0013\u0005!q\u0017\u0005\n\u0003\u000b\u001b\u0014\u0011!C!\u0003\u000fC\u0011\"!'4\u0003\u0003%\t!a'\t\u0013\u0005\r6'!A\u0005\u0002\t\u0005\u0007\"CAVg\u0005\u0005I\u0011IAW\u0011%\tYlMA\u0001\n\u0003\u0011)\rC\u0005\u0002HN\n\t\u0011\"\u0011\u0002J\"I\u00111Z\u001a\u0002\u0002\u0013\u0005\u0013Q\u001a\u0005\n\u0003\u001f\u001c\u0014\u0011!C!\u0005\u0013<\u0011B!4\u0002\u0003\u0003E\tBa4\u0007\u0013\t5\u0014!!A\t\u0012\tE\u0007BB/F\t\u0003\u0011\u0019\u000eC\u0005\u0002L\u0016\u000b\t\u0011\"\u0012\u0002N\"I\u0011Q\\#\u0002\u0002\u0013\u0005%Q\u001b\u0005\n\u0003_,\u0015\u0011!CA\u0005[D\u0011B!\u0003F\u0003\u0003%IAa\u0003\t\u000f\r-\u0011\u0001\"\u0001\u0004\u000e!91qD\u0001\u0005\u0002\r\u0005\u0012!\u0003+bS2\u001c\u0015\r\u001c7t\u0015\ty\u0005+A\u0004d_:$(o\u001c7\u000b\u0005E\u0013\u0016\u0001B;uS2T\u0011aU\u0001\u0006g\u000e\fG.Y\u0002\u0001!\t1\u0016!D\u0001O\u0005%!\u0016-\u001b7DC2d7o\u0005\u0002\u00023B\u0011!lW\u0007\u0002%&\u0011AL\u0015\u0002\u0007\u0003:L(+\u001a4\u0002\rqJg.\u001b;?)\u0005)&a\u0002+bS2\u0014VmY\u000b\u0003C\u001e\u001c\"aA-\u0015\u0003\r\u00042\u0001Z\u0002f\u001b\u0005\t\u0001C\u00014h\u0019\u0001!a\u0001[\u0002\u0005\u0006\u0004I'!A!\u0012\u0005)l\u0007C\u0001.l\u0013\ta'KA\u0004O_RD\u0017N\\4\u0011\u0005is\u0017BA8S\u0005\r\te._\u0001\u0004[\u0006\u0004XC\u0001:v)\t\u0019x\u000fE\u0002e\u0007Q\u0004\"AZ;\u0005\u000bY,!\u0019A5\u0003\u0003\tCQ\u0001_\u0003A\u0002e\f\u0011A\u001a\t\u00055j,G/\u0003\u0002|%\nIa)\u001e8di&|g.M\u0001\bM2\fG/T1q+\rq\u00181\u0001\u000b\u0004\u007f\u0006\u0015\u0001\u0003\u00023\u0004\u0003\u0003\u00012AZA\u0002\t\u00151hA1\u0001j\u0011\u0019Ah\u00011\u0001\u0002\bA!!L_3\u0000\u0003\u0019\u0011Xm];nKV\u0011\u0011Q\u0002\t\b\u0003\u001f\t)\"a\u0007f\u001d\rQ\u0016\u0011C\u0005\u0004\u0003'\u0011\u0016a\u00029bG.\fw-Z\u0005\u0005\u0003/\tIB\u0001\u0004FSRDWM\u001d\u0006\u0004\u0003'\u0011\u0006\u0003\u0002.\u0002\u001e\rL1!a\bS\u0005%1UO\\2uS>t\u0007\u0007K\u0002\b\u0003G\u0001B!!\n\u0002,5\u0011\u0011q\u0005\u0006\u0004\u0003S\u0011\u0016AC1o]>$\u0018\r^5p]&!\u0011QFA\u0014\u0005\u001d!\u0018-\u001b7sK\u000e\faA]3tk2$X#A3)\u0007!\t\u0019C\u0001\u0003DC2dW\u0003BA\u001d\u0003\u007f\u0019r!CA\u001e\u0003\u0003\n9\u0005\u0005\u0003e\u0007\u0005u\u0002c\u00014\u0002@\u0011)\u0001.\u0003b\u0001SB\u0019!,a\u0011\n\u0007\u0005\u0015#KA\u0004Qe>$Wo\u0019;\u0011\u0007i\u000bI%C\u0002\u0002LI\u0013AbU3sS\u0006d\u0017N_1cY\u0016\fAA]3tiV\u0011\u0011\u0011\u000b\t\u00065\u0006u\u00111H\u0001\u0006e\u0016\u001cH\u000f\t\u000b\u0005\u0003/\nI\u0006\u0005\u0003e\u0013\u0005u\u0002bBA'\u0019\u0001\u0007\u0011\u0011K\u0001\u0005G>\u0004\u00180\u0006\u0003\u0002`\u0005\u0015D\u0003BA1\u0003O\u0002B\u0001Z\u0005\u0002dA\u0019a-!\u001a\u0005\u000b!l!\u0019A5\t\u0013\u00055S\u0002%AA\u0002\u0005%\u0004#\u0002.\u0002\u001e\u0005-\u0004\u0003\u00023\u0004\u0003G\nabY8qs\u0012\"WMZ1vYR$\u0013'\u0006\u0003\u0002r\u0005\rUCAA:U\u0011\t\t&!\u001e,\u0005\u0005]\u0004\u0003BA=\u0003\u007fj!!a\u001f\u000b\t\u0005u\u0014qE\u0001\nk:\u001c\u0007.Z2lK\u0012LA!!!\u0002|\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0005\u000b!t!\u0019A5\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\t\tI\t\u0005\u0003\u0002\f\u0006UUBAAG\u0015\u0011\ty)!%\u0002\t1\fgn\u001a\u0006\u0003\u0003'\u000bAA[1wC&!\u0011qSAG\u0005\u0019\u0019FO]5oO\u0006a\u0001O]8ek\u000e$\u0018I]5usV\u0011\u0011Q\u0014\t\u00045\u0006}\u0015bAAQ%\n\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR\u0019Q.a*\t\u0013\u0005%\u0016#!AA\u0002\u0005u\u0015a\u0001=%c\u0005y\u0001O]8ek\u000e$\u0018\n^3sCR|'/\u0006\u0002\u00020B)\u0011\u0011WA\\[6\u0011\u00111\u0017\u0006\u0004\u0003k\u0013\u0016AC2pY2,7\r^5p]&!\u0011\u0011XAZ\u0005!IE/\u001a:bi>\u0014\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\t\u0005}\u0016Q\u0019\t\u00045\u0006\u0005\u0017bAAb%\n9!i\\8mK\u0006t\u0007\u0002CAU'\u0005\u0005\t\u0019A7\u0002\u0011!\f7\u000f[\"pI\u0016$\"!!(\u0002\u0011Q|7\u000b\u001e:j]\u001e$\"!!#\u0002\r\u0015\fX/\u00197t)\u0011\ty,a5\t\u0011\u0005%f#!AA\u00025\fAaQ1mYB\u0011A\rG\n\u00051e\u000b9\u0005\u0006\u0002\u0002X\u0006)\u0011\r\u001d9msV!\u0011\u0011]At)\u0011\t\u0019/!;\u0011\t\u0011L\u0011Q\u001d\t\u0004M\u0006\u001dH!\u00025\u001c\u0005\u0004I\u0007bBA'7\u0001\u0007\u00111\u001e\t\u00065\u0006u\u0011Q\u001e\t\u0005I\u000e\t)/A\u0004v]\u0006\u0004\b\u000f\\=\u0016\t\u0005M(\u0011\u0001\u000b\u0005\u0003k\u0014\u0019\u0001E\u0003[\u0003o\fY0C\u0002\u0002zJ\u0013aa\u00149uS>t\u0007#\u0002.\u0002\u001e\u0005u\b\u0003\u00023\u0004\u0003\u007f\u00042A\u001aB\u0001\t\u0015AGD1\u0001j\u0011%\u0011)\u0001HA\u0001\u0002\u0004\u00119!A\u0002yIA\u0002B\u0001Z\u0005\u0002\u0000\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\u0011i\u0001\u0005\u0003\u0002\f\n=\u0011\u0002\u0002B\t\u0003\u001b\u0013aa\u00142kK\u000e$(\u0001\u0002#p]\u0016,BAa\u0006\u0003\u001eM9aD!\u0007\u0002B\u0005\u001d\u0003\u0003\u00023\u0004\u00057\u00012A\u001aB\u000f\t\u0015AgD1\u0001j\u0003\u00151\u0018\r\\;f+\t\u0011Y\"\u0001\u0004wC2,X\r\t\u000b\u0005\u0005O\u0011I\u0003\u0005\u0003e=\tm\u0001b\u0002B\u0010C\u0001\u0007!1D\u000b\u0005\u0005[\u0011\u0019\u0004\u0006\u0003\u00030\tU\u0002\u0003\u00023\u001f\u0005c\u00012A\u001aB\u001a\t\u0015A'E1\u0001j\u0011%\u0011yB\tI\u0001\u0002\u0004\u0011\t$\u0006\u0003\u0003:\tuRC\u0001B\u001eU\u0011\u0011Y\"!\u001e\u0005\u000b!\u001c#\u0019A5\u0015\u00075\u0014\t\u0005C\u0005\u0002*\u001a\n\t\u00111\u0001\u0002\u001eR!\u0011q\u0018B#\u0011!\tI\u000bKA\u0001\u0002\u0004iG\u0003BA`\u0005\u0013B\u0001\"!+,\u0003\u0003\u0005\r!\\\u0001\u0005\t>tW\r\u0005\u0002e[M!Q&WA$)\t\u0011i%\u0006\u0003\u0003V\tmC\u0003\u0002B,\u0005;\u0002B\u0001\u001a\u0010\u0003ZA\u0019aMa\u0017\u0005\u000b!\u0004$\u0019A5\t\u000f\t}\u0001\u00071\u0001\u0003ZU!!\u0011\rB4)\u0011\u0011\u0019G!\u001b\u0011\u000bi\u000b9P!\u001a\u0011\u0007\u0019\u00149\u0007B\u0003ic\t\u0007\u0011\u000eC\u0005\u0003\u0006E\n\t\u00111\u0001\u0003lA!AM\bB3\u0005\u0011\u0019uN\u001c;\u0016\r\tE$\u0011\u0011B<'\u001d\u0019$1OA!\u0003\u000f\u0002B\u0001Z\u0002\u0003vA\u0019aMa\u001e\u0005\u000bY\u001c$\u0019A5\u0002\u0003\u0005,\"A! \u0011\t\u0011\u001c!q\u0010\t\u0004M\n\u0005E!\u000254\u0005\u0004I\u0017AA1!+\t\u00119\t\u0005\u0004[u\n}$1O\u0001\u0003M\u0002\"bA!$\u0003\u0010\nE\u0005C\u000234\u0005\u007f\u0012)\bC\u0004\u0003za\u0002\rA! \t\raD\u0004\u0019\u0001BD+\u0019\u0011)Ja'\u0003 R1!q\u0013BQ\u0005K\u0003b\u0001Z\u001a\u0003\u001a\nu\u0005c\u00014\u0003\u001c\u0012)\u0001.\u000fb\u0001SB\u0019aMa(\u0005\u000bYL$\u0019A5\t\u0013\te\u0014\b%AA\u0002\t\r\u0006\u0003\u00023\u0004\u00053C\u0001\u0002_\u001d\u0011\u0002\u0003\u0007!q\u0015\t\u00075j\u0014IJ!+\u0011\t\u0011\u001c!QT\u000b\u0007\u0005[\u0013\tLa-\u0016\u0005\t=&\u0006\u0002B?\u0003k\"Q\u0001\u001b\u001eC\u0002%$QA\u001e\u001eC\u0002%\fabY8qs\u0012\"WMZ1vYR$#'\u0006\u0004\u0003:\nu&qX\u000b\u0003\u0005wSCAa\"\u0002v\u0011)\u0001n\u000fb\u0001S\u0012)ao\u000fb\u0001SR\u0019QNa1\t\u0013\u0005%f(!AA\u0002\u0005uE\u0003BA`\u0005\u000fD\u0001\"!+A\u0003\u0003\u0005\r!\u001c\u000b\u0005\u0003\u007f\u0013Y\r\u0003\u0005\u0002*\u000e\u000b\t\u00111\u0001n\u0003\u0011\u0019uN\u001c;\u0011\u0005\u0011,5\u0003B#Z\u0003\u000f\"\"Aa4\u0016\r\t]'Q\u001cBq)\u0019\u0011INa9\u0003hB1Am\rBn\u0005?\u00042A\u001aBo\t\u0015A\u0007J1\u0001j!\r1'\u0011\u001d\u0003\u0006m\"\u0013\r!\u001b\u0005\b\u0005sB\u0005\u0019\u0001Bs!\u0011!7Aa7\t\raD\u0005\u0019\u0001Bu!\u0019Q&Pa7\u0003lB!Am\u0001Bp+\u0019\u0011yO!@\u0004\u0006Q!!\u0011_B\u0004!\u0015Q\u0016q\u001fBz!\u001dQ&Q\u001fB}\u0005\u007fL1Aa>S\u0005\u0019!V\u000f\u001d7feA!Am\u0001B~!\r1'Q \u0003\u0006Q&\u0013\r!\u001b\t\u00075j\u0014Yp!\u0001\u0011\t\u0011\u001c11\u0001\t\u0004M\u000e\u0015A!\u0002<J\u0005\u0004I\u0007\"\u0003B\u0003\u0013\u0006\u0005\t\u0019AB\u0005!\u0019!7Ga?\u0004\u0004\u0005AA/Y5mG\u0006dG.\u0006\u0003\u0004\u0010\rUA\u0003BB\t\u0007/\u0001B\u0001Z\u0002\u0004\u0014A\u0019am!\u0006\u0005\u000b!\\%\u0019A5\t\u0011\u000553\n\"a\u0001\u00073\u0001RAWB\u000e\u0007#I1a!\bS\u0005!a$-\u001f8b[\u0016t\u0014\u0001\u00023p]\u0016,Baa\t\u0004*Q!1QEB\u0016!\u0011!7aa\n\u0011\u0007\u0019\u001cI\u0003B\u0003i\u0019\n\u0007\u0011\u000eC\u0004\u000201\u0003\raa\n")
public final class TailCalls {
    public static <A> TailRec<A> done(A a) {
        return TailCalls$.MODULE$.done(a);
    }

    public static <A> TailRec<A> tailcall(Function0<TailRec<A>> function0) {
        return TailCalls$.MODULE$.tailcall(function0);
    }

    public static class Call<A>
    extends TailRec<A>
    implements Product,
    Serializable {
        private final Function0<TailRec<A>> rest;

        public Function0<TailRec<A>> rest() {
            return this.rest;
        }

        public <A> Call<A> copy(Function0<TailRec<A>> rest) {
            return new Call<A>(rest);
        }

        public <A> Function0<TailRec<A>> copy$default$1() {
            return this.rest();
        }

        @Override
        public String productPrefix() {
            return "Call";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.rest();
                }
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof Call;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof Call;
                    if (!bl) break block3;
                    Call call = (Call)x$1;
                    Function0<TailRec<A>> function0 = this.rest();
                    Function0<TailRec<A>> function02 = call.rest();
                    if (!(!(function0 != null ? !function0.equals(function02) : function02 != null) && call.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public Call(Function0<TailRec<A>> rest) {
            this.rest = rest;
            Product.$init$(this);
        }
    }

    public static class Cont<A, B>
    extends TailRec<B>
    implements Product,
    Serializable {
        private final TailRec<A> a;
        private final Function1<A, TailRec<B>> f;

        public TailRec<A> a() {
            return this.a;
        }

        public Function1<A, TailRec<B>> f() {
            return this.f;
        }

        public <A, B> Cont<A, B> copy(TailRec<A> a, Function1<A, TailRec<B>> f) {
            return new Cont<A, B>(a, f);
        }

        public <A, B> TailRec<A> copy$default$1() {
            return this.a();
        }

        public <A, B> Function1<A, TailRec<B>> copy$default$2() {
            return this.f();
        }

        @Override
        public String productPrefix() {
            return "Cont";
        }

        @Override
        public int productArity() {
            return 2;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.a();
                }
                case 1: {
                    return this.f();
                }
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof Cont;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public boolean equals(Object x$1) {
            if (this == x$1) return true;
            if (!(x$1 instanceof Cont)) return false;
            boolean bl = true;
            if (!bl) return false;
            Cont cont = (Cont)x$1;
            TailRec<A> tailRec = this.a();
            TailRec<A> tailRec2 = cont.a();
            if (tailRec == null) {
                if (tailRec2 != null) {
                    return false;
                }
            } else if (!tailRec.equals(tailRec2)) return false;
            Function1<A, TailRec<B>> function1 = this.f();
            Function1<A, TailRec<B>> function12 = cont.f();
            if (function1 == null) {
                if (function12 != null) {
                    return false;
                }
            } else if (!function1.equals(function12)) return false;
            if (!cont.canEqual(this)) return false;
            return true;
        }

        public Cont(TailRec<A> a, Function1<A, TailRec<B>> f) {
            this.a = a;
            this.f = f;
            Product.$init$(this);
        }
    }

    public static class Done<A>
    extends TailRec<A>
    implements Product,
    Serializable {
        private final A value;

        public A value() {
            return this.value;
        }

        public <A> Done<A> copy(A value) {
            return new Done<A>(value);
        }

        public <A> A copy$default$1() {
            return this.value();
        }

        @Override
        public String productPrefix() {
            return "Done";
        }

        @Override
        public int productArity() {
            return 1;
        }

        @Override
        public Object productElement(int x$1) {
            switch (x$1) {
                case 0: {
                    return this.value();
                }
            }
            throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
        }

        @Override
        public Iterator<Object> productIterator() {
            return ScalaRunTime$.MODULE$.typedProductIterator(this);
        }

        @Override
        public boolean canEqual(Object x$1) {
            return x$1 instanceof Done;
        }

        public int hashCode() {
            return ScalaRunTime$.MODULE$._hashCode(this);
        }

        public String toString() {
            return ScalaRunTime$.MODULE$._toString(this);
        }

        @Override
        public boolean equals(Object x$1) {
            block3: {
                block2: {
                    if (this == x$1) break block2;
                    boolean bl = x$1 instanceof Done;
                    if (!bl) break block3;
                    Done done = (Done)x$1;
                    if (!(BoxesRunTime.equals(this.value(), done.value()) && done.canEqual(this))) break block3;
                }
                return true;
            }
            return false;
        }

        public Done(A value) {
            this.value = value;
            Product.$init$(this);
        }
    }

    public static abstract class TailRec<A> {
        public final <B> TailRec<B> map(Function1<A, B> f) {
            TailRec tailRec;
            Function1<Object, Call> & java.io.Serializable & Serializable flatMap_f = (Function1<Object, Call> & java.io.Serializable & Serializable)a -> new Call((Function0<Done> & java.io.Serializable & Serializable)() -> new Done(f.apply(a)));
            if (this instanceof Done) {
                Object flatMap_a = ((Done)this).value();
                tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
            } else if (this instanceof Call) {
                Call call = (Call)this;
                tailRec = new Cont(call, flatMap_f);
            } else if (this instanceof Cont) {
                Cont cont = (Cont)this;
                tailRec = new Cont(cont.a(), (Function1<Object, TailRec> & java.io.Serializable & Serializable)x -> {
                    TailRec tailRec;
                    TailRec tailRec2 = cont.f().apply(x);
                    if (tailRec2 == null) {
                        throw null;
                    }
                    TailRec flatMap_this = tailRec2;
                    if (flatMap_this instanceof Done) {
                        Object flatMap_a = ((Done)flatMap_this).value();
                        tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
                    } else if (flatMap_this instanceof Call) {
                        Call call = (Call)flatMap_this;
                        tailRec = new Cont(call, f);
                    } else if (flatMap_this instanceof Cont) {
                        Cont cont = (Cont)flatMap_this;
                        tailRec = new Cont(cont.a(), arg_0 -> TailRec.$anonfun$flatMap$2(cont, f, arg_0));
                    } else {
                        throw new MatchError(flatMap_this);
                    }
                    return tailRec;
                });
            } else {
                throw new MatchError(this);
            }
            return tailRec;
        }

        public final <B> TailRec<B> flatMap(Function1<A, TailRec<B>> f) {
            TailRec tailRec;
            if (this instanceof Done) {
                Object a = ((Done)this).value();
                tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
            } else if (this instanceof Call) {
                Call call = (Call)this;
                tailRec = new Cont<A, B>(call, f);
            } else if (this instanceof Cont) {
                Cont cont = (Cont)this;
                tailRec = new Cont(cont.a(), (Function1<Object, TailRec> & java.io.Serializable & Serializable)x -> {
                    TailRec tailRec;
                    TailRec tailRec2 = cont.f().apply(x);
                    if (tailRec2 == null) {
                        throw null;
                    }
                    TailRec flatMap_this = tailRec2;
                    if (flatMap_this instanceof Done) {
                        Object flatMap_a = ((Done)flatMap_this).value();
                        tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
                    } else if (flatMap_this instanceof Call) {
                        Call call = (Call)flatMap_this;
                        tailRec = new Cont(call, f);
                    } else if (flatMap_this instanceof Cont) {
                        Cont cont = (Cont)flatMap_this;
                        tailRec = new Cont(cont.a(), arg_0 -> TailRec.$anonfun$flatMap$2(cont, f, arg_0));
                    } else {
                        throw new MatchError(flatMap_this);
                    }
                    return tailRec;
                });
            } else {
                throw new MatchError(this);
            }
            return tailRec;
        }

        /*
         * WARNING - void declaration
         */
        public final Either<Function0<TailRec<A>>, A> resume() {
            Either either;
            block11: {
                block12: {
                    Function1 f;
                    TailRec a;
                    block13: {
                        while (true) {
                            TailRec tailRec;
                            void flatMap_f;
                            TailRec this_;
                            if (this_ instanceof Done) {
                                Object a2 = ((Done)this_).value();
                                either = package$.MODULE$.Right().apply(a2);
                                break block11;
                            }
                            if (this_ instanceof Call) {
                                Function0 k = ((Call)this_).rest();
                                either = package$.MODULE$.Left().apply(k);
                                break block11;
                            }
                            if (!(this_ instanceof Cont)) break block12;
                            Cont cont = (Cont)this_;
                            a = cont.a();
                            f = cont.f();
                            if (a instanceof Done) {
                                Object v = ((Done)a).value();
                                this_ = f.apply(v);
                                continue;
                            }
                            if (a instanceof Call) break block13;
                            if (!(a instanceof Cont)) break;
                            Cont cont2 = (Cont)a;
                            TailRec b = cont2.a();
                            Function1 g = cont2.f();
                            Function1<Object, TailRec> & java.io.Serializable & Serializable intersect = (Function1<Object, TailRec> & java.io.Serializable & Serializable)x2 -> {
                                TailRec tailRec;
                                TailRec tailRec2 = (TailRec)g.apply(x2);
                                if (tailRec2 == null) {
                                    throw null;
                                }
                                TailRec flatMap_this = tailRec2;
                                if (flatMap_this instanceof Done) {
                                    Object flatMap_a = ((Done)flatMap_this).value();
                                    tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
                                } else if (flatMap_this instanceof Call) {
                                    Call call = (Call)flatMap_this;
                                    tailRec = new Cont(call, f);
                                } else if (flatMap_this instanceof Cont) {
                                    Cont cont = (Cont)flatMap_this;
                                    tailRec = new Cont(cont.a(), (Function1<Object, TailRec> & java.io.Serializable & Serializable)x -> {
                                        TailRec tailRec;
                                        TailRec tailRec2 = cont.f().apply(x);
                                        if (tailRec2 == null) {
                                            throw null;
                                        }
                                        TailRec flatMap_this = tailRec2;
                                        if (flatMap_this instanceof Done) {
                                            Object flatMap_a = ((Done)flatMap_this).value();
                                            tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
                                        } else if (flatMap_this instanceof Call) {
                                            Call call = (Call)flatMap_this;
                                            tailRec = new Cont(call, f);
                                        } else if (flatMap_this instanceof Cont) {
                                            Cont cont = (Cont)flatMap_this;
                                            tailRec = new Cont(cont.a(), arg_0 -> TailRec.$anonfun$flatMap$2(cont, f, arg_0));
                                        } else {
                                            throw new MatchError(flatMap_this);
                                        }
                                        return tailRec;
                                    });
                                } else {
                                    throw new MatchError(flatMap_this);
                                }
                                return tailRec;
                            };
                            if (b == null) {
                                throw null;
                            }
                            if (b instanceof Done) {
                                Object flatMap_a = ((Done)b).value();
                                tailRec = new Call(() -> TailRec.$anonfun$flatMap$1((Function1)flatMap_f, flatMap_a));
                            } else if (b instanceof Call) {
                                Call call = (Call)b;
                                tailRec = new Cont(call, flatMap_f);
                            } else if (b instanceof Cont) {
                                Cont cont3 = (Cont)b;
                                tailRec = new Cont(cont3.a(), arg_0 -> TailRec.$anonfun$flatMap$2(cont3, (Function1)flatMap_f, arg_0));
                            } else {
                                throw new MatchError(b);
                            }
                            this_ = tailRec;
                        }
                        throw new MatchError(a);
                    }
                    Function0 k = ((Call)a).rest();
                    Left left = package$.MODULE$.Left().apply((Function0<TailRec> & java.io.Serializable & Serializable)() -> {
                        TailRec tailRec;
                        TailRec tailRec2 = (TailRec)k.apply();
                        if (tailRec2 == null) {
                            throw null;
                        }
                        TailRec flatMap_this = tailRec2;
                        if (flatMap_this instanceof Done) {
                            Object flatMap_a = ((Done)flatMap_this).value();
                            tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
                        } else if (flatMap_this instanceof Call) {
                            Call call = (Call)flatMap_this;
                            tailRec = new Cont(call, f);
                        } else if (flatMap_this instanceof Cont) {
                            Cont cont = (Cont)flatMap_this;
                            tailRec = new Cont(cont.a(), (Function1<Object, TailRec> & java.io.Serializable & Serializable)x -> {
                                TailRec tailRec;
                                TailRec tailRec2 = cont.f().apply(x);
                                if (tailRec2 == null) {
                                    throw null;
                                }
                                TailRec flatMap_this = tailRec2;
                                if (flatMap_this instanceof Done) {
                                    Object flatMap_a = ((Done)flatMap_this).value();
                                    tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
                                } else if (flatMap_this instanceof Call) {
                                    Call call = (Call)flatMap_this;
                                    tailRec = new Cont(call, f);
                                } else if (flatMap_this instanceof Cont) {
                                    Cont cont = (Cont)flatMap_this;
                                    tailRec = new Cont(cont.a(), arg_0 -> TailRec.$anonfun$flatMap$2(cont, f, arg_0));
                                } else {
                                    throw new MatchError(flatMap_this);
                                }
                                return tailRec;
                            });
                        } else {
                            throw new MatchError(flatMap_this);
                        }
                        return tailRec;
                    });
                    either = left;
                    break block11;
                }
                throw new MatchError(this_);
            }
            return either;
        }

        /*
         * WARNING - void declaration
         */
        public final A result() {
            block11: {
                block12: {
                    TailRec a;
                    while (true) {
                        TailRec tailRec;
                        void flatMap_f;
                        TailRec<Object> this_;
                        if (this_ instanceof Done) break block11;
                        if (this_ instanceof Call) {
                            this_ = ((Call)this_).rest().apply();
                            continue;
                        }
                        if (!(this_ instanceof Cont)) break block12;
                        Cont cont = (Cont)this_;
                        a = cont.a();
                        Function1 f = cont.f();
                        if (a instanceof Done) {
                            Object v = ((Done)a).value();
                            this_ = f.apply(v);
                            continue;
                        }
                        if (a instanceof Call) {
                            this_ = ((Call)a).rest().apply().flatMap(f);
                            continue;
                        }
                        if (!(a instanceof Cont)) break;
                        Cont cont2 = (Cont)a;
                        TailRec b = cont2.a();
                        Function1 g = cont2.f();
                        Function1<Object, TailRec> & java.io.Serializable & Serializable intersect = (Function1<Object, TailRec> & java.io.Serializable & Serializable)x2 -> {
                            TailRec tailRec;
                            TailRec tailRec2 = (TailRec)g.apply(x2);
                            if (tailRec2 == null) {
                                throw null;
                            }
                            TailRec flatMap_this = tailRec2;
                            if (flatMap_this instanceof Done) {
                                Object flatMap_a = ((Done)flatMap_this).value();
                                tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
                            } else if (flatMap_this instanceof Call) {
                                Call call = (Call)flatMap_this;
                                tailRec = new Cont(call, f);
                            } else if (flatMap_this instanceof Cont) {
                                Cont cont = (Cont)flatMap_this;
                                tailRec = new Cont(cont.a(), (Function1<Object, TailRec> & java.io.Serializable & Serializable)x -> {
                                    TailRec tailRec;
                                    TailRec tailRec2 = cont.f().apply(x);
                                    if (tailRec2 == null) {
                                        throw null;
                                    }
                                    TailRec flatMap_this = tailRec2;
                                    if (flatMap_this instanceof Done) {
                                        Object flatMap_a = ((Done)flatMap_this).value();
                                        tailRec = new Call((Function0<TailRec> & java.io.Serializable & Serializable)() -> (TailRec)f.apply(flatMap_a));
                                    } else if (flatMap_this instanceof Call) {
                                        Call call = (Call)flatMap_this;
                                        tailRec = new Cont(call, f);
                                    } else if (flatMap_this instanceof Cont) {
                                        Cont cont = (Cont)flatMap_this;
                                        tailRec = new Cont(cont.a(), arg_0 -> TailRec.$anonfun$flatMap$2(cont, f, arg_0));
                                    } else {
                                        throw new MatchError(flatMap_this);
                                    }
                                    return tailRec;
                                });
                            } else {
                                throw new MatchError(flatMap_this);
                            }
                            return tailRec;
                        };
                        if (b == null) {
                            throw null;
                        }
                        if (b instanceof Done) {
                            Object flatMap_a = ((Done)b).value();
                            tailRec = new Call(() -> TailRec.$anonfun$flatMap$1((Function1)flatMap_f, flatMap_a));
                        } else if (b instanceof Call) {
                            Call call = (Call)b;
                            tailRec = new Cont(call, flatMap_f);
                        } else if (b instanceof Cont) {
                            Cont cont3 = (Cont)b;
                            tailRec = new Cont(cont3.a(), arg_0 -> TailRec.$anonfun$flatMap$2(cont3, (Function1)flatMap_f, arg_0));
                        } else {
                            throw new MatchError(b);
                        }
                        this_ = tailRec;
                    }
                    throw new MatchError(a);
                }
                throw new MatchError(this_);
            }
            Object a = ((Done)this_).value();
            return a;
        }
    }
}

