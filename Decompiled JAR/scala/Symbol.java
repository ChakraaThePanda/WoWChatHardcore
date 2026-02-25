/*
 * Decompiled with CFR 0.152.
 */
package scala;

import java.io.ObjectStreamException;
import scala.Option;
import scala.Serializable;
import scala.Symbol$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001!4Aa\u0004\t\u0003'!A1\u0004\u0001BC\u0002\u0013\u0005A\u0004\u0003\u0005)\u0001\t\u0005\t\u0015!\u0003\u001e\u0011\u0015I\u0003\u0001\"\u0003+\u0011\u0015i\u0003\u0001\"\u0011/\u0011\u0015y\u0003\u0001\"\u00031\u0011\u0015\t\u0005\u0001\"\u0011C\u0011\u00151\u0005\u0001\"\u0011H\u000f\u0015i\u0005\u0003#\u0001O\r\u0015y\u0001\u0003#\u0001P\u0011\u0015I\u0013\u0002\"\u0001T\u0011\u0015!\u0016\u0002\"\u0011V\u0011\u00159\u0016\u0002\"\u0005Y\u0011\u0015Q\u0016\u0002\"\u0005\\\u0011\u001dy\u0013\"!A\u0005\n\u0005\u0014aaU=nE>d'\"A\t\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0019\u0001\u0001\u0006\r\u0011\u0005U1R\"\u0001\t\n\u0005]\u0001\"AB!osJ+g\r\u0005\u0002\u00163%\u0011!\u0004\u0005\u0002\r'\u0016\u0014\u0018.\u00197ju\u0006\u0014G.Z\u0001\u0005]\u0006lW-F\u0001\u001e!\tqRE\u0004\u0002 GA\u0011\u0001\u0005E\u0007\u0002C)\u0011!EE\u0001\u0007yI|w\u000e\u001e \n\u0005\u0011\u0002\u0012A\u0002)sK\u0012,g-\u0003\u0002'O\t11\u000b\u001e:j]\u001eT!\u0001\n\t\u0002\u000b9\fW.\u001a\u0011\u0002\rqJg.\u001b;?)\tYC\u0006\u0005\u0002\u0016\u0001!)1d\u0001a\u0001;\u0005AAo\\*ue&tw\rF\u0001\u001e\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0003E\u0002\"!\u0006\u001a\n\u0005M\u0002\"aA!os\"\u001aQ!\u000e!\u0011\u0007U1\u0004(\u0003\u00028!\t1A\u000f\u001b:poN\u0004\"!\u000f \u000e\u0003iR!a\u000f\u001f\u0002\u0005%|'\"A\u001f\u0002\t)\fg/Y\u0005\u0003\u007fi\u0012Qc\u00142kK\u000e$8\u000b\u001e:fC6,\u0005pY3qi&|gnI\u00019\u0003!A\u0017m\u001d5D_\u0012,G#A\"\u0011\u0005U!\u0015BA#\u0011\u0005\rIe\u000e^\u0001\u0007KF,\u0018\r\\:\u0015\u0005![\u0005CA\u000bJ\u0013\tQ\u0005CA\u0004C_>dW-\u00198\t\u000b1;\u0001\u0019A\u0019\u0002\u000b=$\b.\u001a:\u0002\rMKXNY8m!\t)\u0012bE\u0002\n!b\u0001B!F)\u001eW%\u0011!\u000b\u0005\u0002\u0010+:L\u0017/^3oKN\u001c8)Y2iKR\ta*A\u0003baBd\u0017\u0010\u0006\u0002,-\")1d\u0003a\u0001;\u0005aa/\u00197vK\u001a\u0013x.\\&fsR\u00111&\u0017\u0005\u000671\u0001\r!H\u0001\rW\u0016LhI]8n-\u0006dW/\u001a\u000b\u00039~\u00032!F/\u001e\u0013\tq\u0006C\u0001\u0004PaRLwN\u001c\u0005\u0006A6\u0001\raK\u0001\u0004gflG#\u00012\u0011\u0005\r4W\"\u00013\u000b\u0005\u0015d\u0014\u0001\u00027b]\u001eL!a\u001a3\u0003\r=\u0013'.Z2u\u0001")
public final class Symbol
implements Serializable {
    private final String name;

    public static Symbol apply(String string) {
        return Symbol$.MODULE$.apply(string);
    }

    public static Option unapply(Object object) {
        return Symbol$.MODULE$.unapply(object);
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        return new StringBuilder(1).append("'").append(this.name()).toString();
    }

    private Object readResolve() throws ObjectStreamException {
        return Symbol$.MODULE$.apply(this.name());
    }

    public int hashCode() {
        return this.name().hashCode();
    }

    public boolean equals(Object other) {
        return this == other;
    }

    public Symbol(String name) {
        this.name = name;
    }
}

