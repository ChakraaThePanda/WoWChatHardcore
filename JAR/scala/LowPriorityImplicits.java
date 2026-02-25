/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.collection.generic.CanBuildFrom;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.IndexedSeq$;
import scala.collection.immutable.WrappedString;
import scala.collection.mutable.Builder;
import scala.collection.mutable.WrappedArray;
import scala.collection.mutable.WrappedArray$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u0005%hA\u0002\r\u001a\u0003\u0003I2\u0004C\u0003!\u0001\u0011\u0005!\u0005C\u0003%\u0001\u0011\rQ\u0005C\u00036\u0001\u0011\ra\u0007C\u0003@\u0001\u0011\r\u0001\tC\u0003J\u0001\u0011\r!\nC\u0003U\u0001\u0011\rQ\u000bC\u0003_\u0001\u0011\rq\fC\u0003i\u0001\u0011\r\u0011\u000eC\u0003s\u0001\u0011\r1\u000fC\u0003}\u0001\u0011\rQ\u0010C\u0004\u00020\u0001!\u0019!!\r\t\u000f\u0005\u0005\u0003\u0001b\u0001\u0002D!9\u00111\n\u0001\u0005\u0004\u00055\u0003bBA+\u0001\u0011\r\u0011q\u000b\u0005\b\u0003?\u0002A1AA1\u0011\u001d\tI\u0007\u0001C\u0002\u0003WBq!a\u001d\u0001\t\u0007\t)\bC\u0004\u0002~\u0001!\u0019!a \t\u000f\u0005\u001d\u0005\u0001b\u0001\u0002\n\"9\u0011\u0011\u0013\u0001\u0005\u0004\u0005M\u0005bBAQ\u0001\u0011\r\u00111\u0015\u0005\b\u0003\u000b\u0004A1AAd\u0011\u001d\ti\r\u0001C\u0002\u0003\u001f\u0014A\u0003T8x!JLwN]5us&k\u0007\u000f\\5dSR\u001c(\"\u0001\u000e\u0002\u000bM\u001c\u0017\r\\1\u0014\u0005\u0001a\u0002CA\u000f\u001f\u001b\u0005I\u0012BA\u0010\u001a\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\u001a\u0001\u0001F\u0001$!\ti\u0002!A\u0006csR,wK]1qa\u0016\u0014HC\u0001\u0014-!\t9#&D\u0001)\u0015\tI\u0013$A\u0004sk:$\u0018.\\3\n\u0005-B#\u0001\u0003*jG\"\u0014\u0015\u0010^3\t\u000b5\u0012\u0001\u0019\u0001\u0018\u0002\u0003a\u0004\"!H\u0018\n\u0005AJ\"\u0001\u0002\"zi\u0016D#A\u0001\u001a\u0011\u0005u\u0019\u0014B\u0001\u001b\u001a\u0005\u0019Ig\u000e\\5oK\u0006a1\u000f[8si^\u0013\u0018\r\u001d9feR\u0011qG\u000f\t\u0003OaJ!!\u000f\u0015\u0003\u0013IK7\r[*i_J$\b\"B\u0017\u0004\u0001\u0004Y\u0004CA\u000f=\u0013\ti\u0014DA\u0003TQ>\u0014H\u000f\u000b\u0002\u0004e\u0005Q\u0011N\u001c;Xe\u0006\u0004\b/\u001a:\u0015\u0005\u0005#\u0005CA\u0014C\u0013\t\u0019\u0005FA\u0004SS\u000eD\u0017J\u001c;\t\u000b5\"\u0001\u0019A#\u0011\u0005u1\u0015BA$\u001a\u0005\rIe\u000e\u001e\u0015\u0003\tI\n1b\u00195be^\u0013\u0018\r\u001d9feR\u00111J\u0014\t\u0003O1K!!\u0014\u0015\u0003\u0011IK7\r[\"iCJDQaT\u0003A\u0002A\u000b\u0011a\u0019\t\u0003;EK!AU\r\u0003\t\rC\u0017M\u001d\u0015\u0003\u000bI\n1\u0002\\8oO^\u0013\u0018\r\u001d9feR\u0011a+\u0017\t\u0003O]K!\u0001\u0017\u0015\u0003\u0011IK7\r\u001b'p]\u001eDQ!\f\u0004A\u0002i\u0003\"!H.\n\u0005qK\"\u0001\u0002'p]\u001eD#A\u0002\u001a\u0002\u0019\u0019dw.\u0019;Xe\u0006\u0004\b/\u001a:\u0015\u0005\u0001\u001c\u0007CA\u0014b\u0013\t\u0011\u0007FA\u0005SS\u000eDg\t\\8bi\")Qf\u0002a\u0001IB\u0011Q$Z\u0005\u0003Mf\u0011QA\u00127pCRD#a\u0002\u001a\u0002\u001b\u0011|WO\u00197f/J\f\u0007\u000f]3s)\tQW\u000e\u0005\u0002(W&\u0011A\u000e\u000b\u0002\u000b%&\u001c\u0007\u000eR8vE2,\u0007\"B\u0017\t\u0001\u0004q\u0007CA\u000fp\u0013\t\u0001\u0018D\u0001\u0004E_V\u0014G.\u001a\u0015\u0003\u0011I\naBY8pY\u0016\fgn\u0016:baB,'\u000f\u0006\u0002uoB\u0011q%^\u0005\u0003m\"\u00121BU5dQ\n{w\u000e\\3b]\")Q&\u0003a\u0001qB\u0011Q$_\u0005\u0003uf\u0011qAQ8pY\u0016\fg\u000e\u000b\u0002\ne\u0005\u0001r-\u001a8fe&\u001cwK]1q\u0003J\u0014\u0018-_\u000b\u0004}\u0006MAcA@\u0002&A1\u0011\u0011AA\u0006\u0003\u001fi!!a\u0001\u000b\t\u0005\u0015\u0011qA\u0001\b[V$\u0018M\u00197f\u0015\r\tI!G\u0001\u000bG>dG.Z2uS>t\u0017\u0002BA\u0007\u0003\u0007\u0011Ab\u0016:baB,G-\u0011:sCf\u0004B!!\u0005\u0002\u00141\u0001AaBA\u000b\u0015\t\u0007\u0011q\u0003\u0002\u0002)F!\u0011\u0011DA\u0010!\ri\u00121D\u0005\u0004\u0003;I\"a\u0002(pi\"Lgn\u001a\t\u0004;\u0005\u0005\u0012bAA\u00123\t\u0019\u0011I\\=\t\u000f\u0005\u001d\"\u00021\u0001\u0002*\u0005\u0011\u0001p\u001d\t\u0006;\u0005-\u0012qB\u0005\u0004\u0003[I\"!B!se\u0006L\u0018\u0001D<sCB\u0014VMZ!se\u0006LX\u0003BA\u001a\u0003s!B!!\u000e\u0002>A1\u0011\u0011AA\u0006\u0003o\u0001B!!\u0005\u0002:\u00119\u0011QC\u0006C\u0002\u0005m\u0012cAA\r9!9\u0011qE\u0006A\u0002\u0005}\u0002#B\u000f\u0002,\u0005]\u0012\u0001D<sCBLe\u000e^!se\u0006LH\u0003BA#\u0003\u000f\u0002R!!\u0001\u0002\f\u0015Cq!a\n\r\u0001\u0004\tI\u0005\u0005\u0003\u001e\u0003W)\u0015aD<sCB$u.\u001e2mK\u0006\u0013(/Y=\u0015\t\u0005=\u0013\u0011\u000b\t\u0006\u0003\u0003\tYA\u001c\u0005\b\u0003Oi\u0001\u0019AA*!\u0011i\u00121\u00068\u0002\u001b]\u0014\u0018\r\u001d'p]\u001e\f%O]1z)\u0011\tI&a\u0017\u0011\u000b\u0005\u0005\u00111\u0002.\t\u000f\u0005\u001db\u00021\u0001\u0002^A!Q$a\u000b[\u000399(/\u00199GY>\fG/\u0011:sCf$B!a\u0019\u0002fA)\u0011\u0011AA\u0006I\"9\u0011qE\bA\u0002\u0005\u001d\u0004\u0003B\u000f\u0002,\u0011\fQb\u001e:ba\u000eC\u0017M]!se\u0006LH\u0003BA7\u0003_\u0002R!!\u0001\u0002\fACq!a\n\u0011\u0001\u0004\t\t\b\u0005\u0003\u001e\u0003W\u0001\u0016!D<sCB\u0014\u0015\u0010^3BeJ\f\u0017\u0010\u0006\u0003\u0002x\u0005e\u0004#BA\u0001\u0003\u0017q\u0003bBA\u0014#\u0001\u0007\u00111\u0010\t\u0005;\u0005-b&\u0001\bxe\u0006\u00048\u000b[8si\u0006\u0013(/Y=\u0015\t\u0005\u0005\u00151\u0011\t\u0006\u0003\u0003\tYa\u000f\u0005\b\u0003O\u0011\u0002\u0019AAC!\u0011i\u00121F\u001e\u0002!]\u0014\u0018\r\u001d\"p_2,\u0017M\\!se\u0006LH\u0003BAF\u0003\u001b\u0003R!!\u0001\u0002\faDq!a\n\u0014\u0001\u0004\ty\t\u0005\u0003\u001e\u0003WA\u0018!D<sCB,f.\u001b;BeJ\f\u0017\u0010\u0006\u0003\u0002\u0016\u0006u\u0005CBA\u0001\u0003\u0017\t9\nE\u0002\u001e\u00033K1!a'\u001a\u0005\u0011)f.\u001b;\t\u000f\u0005\u001dB\u00031\u0001\u0002 B)Q$a\u000b\u0002\u0018\u0006QqO]1q'R\u0014\u0018N\\4\u0015\t\u0005\u0015\u0016\u0011\u0017\t\u0005\u0003O\u000bi+\u0004\u0002\u0002**!\u00111VA\u0004\u0003%IW.\\;uC\ndW-\u0003\u0003\u00020\u0006%&!D,sCB\u0004X\rZ*ue&tw\rC\u0004\u00024V\u0001\r!!.\u0002\u0003M\u0004B!a.\u0002B6\u0011\u0011\u0011\u0018\u0006\u0005\u0003w\u000bi,\u0001\u0003mC:<'BAA`\u0003\u0011Q\u0017M^1\n\t\u0005\r\u0017\u0011\u0018\u0002\u0007'R\u0014\u0018N\\4\u0002\u0019UtwO]1q'R\u0014\u0018N\\4\u0015\t\u0005U\u0016\u0011\u001a\u0005\b\u0003\u00174\u0002\u0019AAS\u0003\t98/\u0001\u000egC2d'-Y2l'R\u0014\u0018N\\4DC:\u0014U/\u001b7e\rJ|W.\u0006\u0003\u0002R\u0006\u0005XCAAj!)\t).a7\u00026\u0006}\u00171]\u0007\u0003\u0003/TA!!7\u0002\b\u00059q-\u001a8fe&\u001c\u0017\u0002BAo\u0003/\u0014AbQ1o\u0005VLG\u000e\u001a$s_6\u0004B!!\u0005\u0002b\u00129\u0011QC\fC\u0002\u0005]\u0001CBAT\u0003K\fy.\u0003\u0003\u0002h\u0006%&AC%oI\u0016DX\rZ*fc\u0002")
public abstract class LowPriorityImplicits {
    public byte byteWrapper(byte x) {
        return x;
    }

    public short shortWrapper(short x) {
        return x;
    }

    public int intWrapper(int x) {
        return x;
    }

    public char charWrapper(char c) {
        return c;
    }

    public long longWrapper(long x) {
        return x;
    }

    public float floatWrapper(float x) {
        return x;
    }

    public double doubleWrapper(double x) {
        return x;
    }

    public boolean booleanWrapper(boolean x) {
        return x;
    }

    public <T> WrappedArray<T> genericWrapArray(Object xs) {
        if (xs == null) {
            return null;
        }
        return WrappedArray$.MODULE$.make(xs);
    }

    public <T> WrappedArray<T> wrapRefArray(T[] xs) {
        if (xs == null) {
            return null;
        }
        if (xs.length == 0) {
            return WrappedArray$.MODULE$.empty();
        }
        return new WrappedArray.ofRef<T>(xs);
    }

    public WrappedArray<Object> wrapIntArray(int[] xs) {
        if (xs != null) {
            return new WrappedArray.ofInt(xs);
        }
        return null;
    }

    public WrappedArray<Object> wrapDoubleArray(double[] xs) {
        if (xs != null) {
            return new WrappedArray.ofDouble(xs);
        }
        return null;
    }

    public WrappedArray<Object> wrapLongArray(long[] xs) {
        if (xs != null) {
            return new WrappedArray.ofLong(xs);
        }
        return null;
    }

    public WrappedArray<Object> wrapFloatArray(float[] xs) {
        if (xs != null) {
            return new WrappedArray.ofFloat(xs);
        }
        return null;
    }

    public WrappedArray<Object> wrapCharArray(char[] xs) {
        if (xs != null) {
            return new WrappedArray.ofChar(xs);
        }
        return null;
    }

    public WrappedArray<Object> wrapByteArray(byte[] xs) {
        if (xs != null) {
            return new WrappedArray.ofByte(xs);
        }
        return null;
    }

    public WrappedArray<Object> wrapShortArray(short[] xs) {
        if (xs != null) {
            return new WrappedArray.ofShort(xs);
        }
        return null;
    }

    public WrappedArray<Object> wrapBooleanArray(boolean[] xs) {
        if (xs != null) {
            return new WrappedArray.ofBoolean(xs);
        }
        return null;
    }

    public WrappedArray<BoxedUnit> wrapUnitArray(BoxedUnit[] xs) {
        if (xs != null) {
            return new WrappedArray.ofUnit(xs);
        }
        return null;
    }

    public WrappedString wrapString(String s) {
        if (s != null) {
            return new WrappedString(s);
        }
        return null;
    }

    public String unwrapString(WrappedString ws) {
        if (ws != null) {
            return ws.self();
        }
        return null;
    }

    public <T> CanBuildFrom<String, T, IndexedSeq<T>> fallbackStringCanBuildFrom() {
        return new CanBuildFrom<String, T, IndexedSeq<T>>(null){

            public Builder<T, IndexedSeq<T>> apply(String from) {
                return IndexedSeq$.MODULE$.newBuilder();
            }

            public Builder<T, IndexedSeq<T>> apply() {
                return IndexedSeq$.MODULE$.newBuilder();
            }
        };
    }
}

