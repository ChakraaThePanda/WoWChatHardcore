/*
 * Decompiled with CFR 0.152.
 */
package scala.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import scala.Function0;
import scala.Function1;
import scala.Serializable;
import scala.collection.AbstractIterator;
import scala.collection.Iterator;
import scala.collection.Iterator$;
import scala.collection.mutable.StringBuilder;
import scala.io.Codec;
import scala.io.Source;
import scala.io.Source$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.java8.JFunction0$mcI$sp;
import scala.runtime.java8.JFunction1$mcZI$sp;

@ScalaSignature(bytes="\u0006\u0001\u0005Ua\u0001\u0002\u000e\u001c\u0001\u0001B\u0001\"\n\u0001\u0003\u0002\u0003\u0006IA\n\u0005\t[\u0001\u0011\t\u0011)A\u0005]!A!\u0007\u0001BC\u0002\u0013\r1\u0007\u0003\u00058\u0001\t\u0005\t\u0015!\u00035\u0011\u0015A\u0004\u0001\"\u0001:\u0011\u0015A\u0004\u0001\"\u0001@\u0011\u0015\u0019\u0005\u0001\"\u0001E\u0011\u0015A\u0005\u0001\"\u0001J\u0011\u001di\u0005\u00011A\u0005\n9CqA\u0015\u0001A\u0002\u0013%1\u000b\u0003\u0004Z\u0001\u0001\u0006Ka\u0014\u0005\t5\u0002A)\u0019!C\u00057\"AA\f\u0001EC\u0002\u0013\u0005S\fC\u0003h\u0001\u0011%1L\u0002\u0003i\u0001\u0001I\u0007\"\u0002\u001d\u0010\t\u0003I\bb\u0002?\u0010\u0005\u0004%Ia\u0017\u0005\u0007{>\u0001\u000b\u0011\u0002&\t\u000fy|\u0001\u0019!C\u0001\u007f\"I\u0011\u0011A\bA\u0002\u0013\u0005\u00111\u0001\u0005\b\u0003\u000fy\u0001\u0015)\u0003n\u0011\u0019\tIa\u0004C!\u001d\"9\u00111B\b\u0005B\u00055\u0001bBA\b\u0001\u0011\u0005\u0013\u0011\u0003\u0005\u0007\u0003'\u0001A\u0011I@\u0003\u001d\t+hMZ3sK\u0012\u001cv.\u001e:dK*\u0011A$H\u0001\u0003S>T\u0011AH\u0001\u0006g\u000e\fG.Y\u0002\u0001'\t\u0001\u0011\u0005\u0005\u0002#G5\t1$\u0003\u0002%7\t11k\\;sG\u0016\f1\"\u001b8qkR\u001cFO]3b[B\u0011qeK\u0007\u0002Q)\u0011A$\u000b\u0006\u0002U\u0005!!.\u0019<b\u0013\ta\u0003FA\u0006J]B,Ho\u0015;sK\u0006l\u0017A\u00032vM\u001a,'oU5{KB\u0011q\u0006M\u0007\u0002;%\u0011\u0011'\b\u0002\u0004\u0013:$\u0018!B2pI\u0016\u001cW#\u0001\u001b\u0011\u0005\t*\u0014B\u0001\u001c\u001c\u0005\u0015\u0019u\u000eZ3d\u0003\u0019\u0019w\u000eZ3dA\u00051A(\u001b8jiz\"2AO\u001f?)\tYD\b\u0005\u0002#\u0001!)!'\u0002a\u0002i!)Q%\u0002a\u0001M!)Q&\u0002a\u0001]Q\u0011\u0001I\u0011\u000b\u0003w\u0005CQA\r\u0004A\u0004QBQ!\n\u0004A\u0002\u0019\naA]3bI\u0016\u0014H#A#\u0011\u0005\u001d2\u0015BA$)\u0005EIe\u000e];u'R\u0014X-Y7SK\u0006$WM]\u0001\u000fEV4g-\u001a:fIJ+\u0017\rZ3s)\u0005Q\u0005CA\u0014L\u0013\ta\u0005F\u0001\bCk\u001a4WM]3e%\u0016\fG-\u001a:\u0002#\rD\u0017M\u001d*fC\u0012,'o\u0011:fCR,G-F\u0001P!\ty\u0003+\u0003\u0002R;\t9!i\\8mK\u0006t\u0017!F2iCJ\u0014V-\u00193fe\u000e\u0013X-\u0019;fI~#S-\u001d\u000b\u0003)^\u0003\"aL+\n\u0005Yk\"\u0001B+oSRDq\u0001\u0017\u0006\u0002\u0002\u0003\u0007q*A\u0002yIE\n!c\u00195beJ+\u0017\rZ3s\u0007J,\u0017\r^3eA\u0005Q1\r[1s%\u0016\fG-\u001a:\u0016\u0003)\u000bA!\u001b;feV\ta\fE\u0002`E\u0012l\u0011\u0001\u0019\u0006\u0003Cv\t!bY8mY\u0016\u001cG/[8o\u0013\t\u0019\u0007M\u0001\u0005Ji\u0016\u0014\u0018\r^8s!\tyS-\u0003\u0002g;\t!1\t[1s\u00039!WmY1dQ\u0016$'+Z1eKJ\u0014ACQ;gM\u0016\u0014X\r\u001a'j]\u0016LE/\u001a:bi>\u00148cA\bkqB\u0019ql[7\n\u00051\u0004'\u0001E!cgR\u0014\u0018m\u0019;Ji\u0016\u0014\u0018\r^8s!\tqWO\u0004\u0002pgB\u0011\u0001/H\u0007\u0002c*\u0011!oH\u0001\u0007yI|w\u000e\u001e \n\u0005Ql\u0012A\u0002)sK\u0012,g-\u0003\u0002wo\n11\u000b\u001e:j]\u001eT!\u0001^\u000f\u0011\u0007}\u0013W\u000eF\u0001{!\tYx\"D\u0001\u0001\u0003)a\u0017N\\3SK\u0006$WM]\u0001\fY&tWMU3bI\u0016\u0014\b%\u0001\u0005oKb$H*\u001b8f+\u0005i\u0017\u0001\u00048fqRd\u0015N\\3`I\u0015\fHc\u0001+\u0002\u0006!9\u0001\fFA\u0001\u0002\u0004i\u0017!\u00038fqRd\u0015N\\3!\u0003\u001dA\u0017m\u001d(fqR\fAA\\3yiR\tQ.\u0001\u0005hKRd\u0015N\\3t)\u0005A\u0018\u0001C7l'R\u0014\u0018N\\4")
public class BufferedSource
extends Source {
    private BufferedReader charReader;
    private Iterator<Object> iter;
    private final InputStream inputStream;
    private final int bufferSize;
    private final Codec codec;
    private boolean charReaderCreated;
    private volatile byte bitmap$0;

    public Codec codec() {
        return this.codec;
    }

    public InputStreamReader reader() {
        return new InputStreamReader(this.inputStream, this.codec().decoder());
    }

    public BufferedReader bufferedReader() {
        return new BufferedReader(this.reader(), this.bufferSize);
    }

    private boolean charReaderCreated() {
        return this.charReaderCreated;
    }

    private void charReaderCreated_$eq(boolean x$1) {
        this.charReaderCreated = x$1;
    }

    private BufferedReader charReader$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                this.charReaderCreated_$eq(true);
                this.charReader = this.bufferedReader();
                this.bitmap$0 = (byte)(this.bitmap$0 | 1);
            }
        }
        return this.charReader;
    }

    private BufferedReader charReader() {
        if ((byte)(this.bitmap$0 & 1) == 0) {
            return this.charReader$lzycompute();
        }
        return this.charReader;
    }

    /*
     * WARNING - void declaration
     */
    private Iterator<Object> iter$lzycompute() {
        synchronized (this) {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                void continually_elem;
                JFunction0$mcI$sp & Serializable intersect = (JFunction0$mcI$sp & Serializable)() -> this.codec().wrap((JFunction0$mcI$sp & Serializable)() -> this.charReader().read());
                if (Iterator$.MODULE$ == null) {
                    throw null;
                }
                this.iter = new AbstractIterator<A>((Function0)continually_elem){
                    private final Function0 elem$3;

                    public boolean hasNext() {
                        return true;
                    }

                    public A next() {
                        return (A)this.elem$3.apply();
                    }
                    {
                        this.elem$3 = elem$3;
                    }
                }.takeWhile((JFunction1$mcZI$sp & Serializable)(A x$1) -> x$1 != -1).map((Function1<Object, Object> & java.io.Serializable & Serializable)(A x$2) -> BoxesRunTime.boxToCharacter(BufferedSource.$anonfun$iter$4(BoxesRunTime.unboxToInt(x$2))));
                this.bitmap$0 = (byte)(this.bitmap$0 | 2);
            }
        }
        return this.iter;
    }

    @Override
    public Iterator<Object> iter() {
        if ((byte)(this.bitmap$0 & 2) == 0) {
            return this.iter$lzycompute();
        }
        return this.iter;
    }

    public BufferedReader scala$io$BufferedSource$$decachedReader() {
        if (this.charReaderCreated() && this.iter().hasNext()) {
            PushbackReader pb = new PushbackReader(this.charReader());
            pb.unread(BoxesRunTime.unboxToChar(this.iter().next()));
            return new BufferedReader(pb, this.bufferSize);
        }
        return this.charReader();
    }

    @Override
    public Iterator<String> getLines() {
        return new BufferedLineIterator();
    }

    @Override
    public String mkString() {
        BufferedReader allReader = this.scala$io$BufferedSource$$decachedReader();
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[this.bufferSize];
        int n = 0;
        while (n != -1) {
            n = allReader.read(buf);
            if (n <= 0) continue;
            sb.appendAll(buf, 0, n);
        }
        return sb.result();
    }

    public static final /* synthetic */ char $anonfun$iter$4(int x$2) {
        return (char)x$2;
    }

    public BufferedSource(InputStream inputStream2, int bufferSize, Codec codec) {
        this.inputStream = inputStream2;
        this.bufferSize = bufferSize;
        this.codec = codec;
        this.charReaderCreated = false;
    }

    public BufferedSource(InputStream inputStream2, Codec codec) {
        this(inputStream2, Source$.MODULE$.DefaultBufSize(), codec);
    }

    public class BufferedLineIterator
    extends AbstractIterator<String> {
        private final BufferedReader lineReader;
        private String nextLine;

        private BufferedReader lineReader() {
            return this.lineReader;
        }

        public String nextLine() {
            return this.nextLine;
        }

        public void nextLine_$eq(String x$1) {
            this.nextLine = x$1;
        }

        @Override
        public boolean hasNext() {
            if (this.nextLine() == null) {
                this.nextLine_$eq(this.lineReader().readLine());
            }
            return this.nextLine() != null;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public String next() {
            void var1_2;
            String string;
            if (this.nextLine() == null) {
                string = this.lineReader().readLine();
            } else {
                try {
                    string = this.nextLine();
                }
                finally {
                    this.nextLine_$eq(null);
                }
            }
            String result2 = string;
            if (result2 == null) {
                return (String)((Object)Iterator$.MODULE$.empty().next());
            }
            return var1_2;
        }

        public /* synthetic */ BufferedSource scala$io$BufferedSource$BufferedLineIterator$$$outer() {
            return BufferedSource.this;
        }

        public BufferedLineIterator() {
            if (BufferedSource.this == null) {
                throw null;
            }
            this.lineReader = BufferedSource.this.scala$io$BufferedSource$$decachedReader();
            this.nextLine = null;
        }
    }
}

