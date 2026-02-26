/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.collection.immutable.Set;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.macros.Attachments;
import scala.reflect.macros.NonemptyAttachments;

@ScalaSignature(bytes="\u0006\u0001q4AAD\b\u0007-!AA\u0004\u0001BC\u0002\u0013\u0005S\u0004\u0003\u0005+\u0001\t\u0005\t\u0015!\u0003\u001f\u0011!Y\u0003A!b\u0001\n\u0003a\u0003\u0002C\u0017\u0001\u0005\u0003\u0005\u000b\u0011B\u0014\t\u000b9\u0002A\u0011A\u0018\u0006\tM\u0002\u0001A\b\u0005\u0006i\u0001!\t!\u000e\u0005\u0006w\u0001!\t\u0005\u0010\u0005\u0006\u0001\u0002!\t%\u0011\u0005\u0006\u0015\u0002!\te\u0013\u0005\u00065\u0002!\te\u0017\u0005\u0006I\u0002!\t%\u001a\u0005\u0006e\u0002!\te\u001d\u0002\u0011'&tw\r\\3BiR\f7\r[7f]RT!\u0001E\t\u0002\r5\f7M]8t\u0015\t\u00112#A\u0004sK\u001adWm\u0019;\u000b\u0003Q\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u0018AM\u0011\u0001\u0001\u0007\t\u00033ii\u0011aD\u0005\u00037=\u00111\"\u0011;uC\u000eDW.\u001a8ug\u0006\u0019\u0001o\\:\u0016\u0003y\u0001\"a\b\u0011\r\u0001\u0011)\u0011\u0005\u0001b\u0001E\t\t\u0001+\u0005\u0002$OA\u0011A%J\u0007\u0002'%\u0011ae\u0005\u0002\u0005\u001dVdG\u000e\u0005\u0002%Q%\u0011\u0011f\u0005\u0002\u0004\u0003:L\u0018\u0001\u00029pg\u0002\n1!\u0019;u+\u00059\u0013\u0001B1ui\u0002\na\u0001P5oSRtDc\u0001\u00192eA\u0019\u0011\u0004\u0001\u0010\t\u000bq)\u0001\u0019\u0001\u0010\t\u000b-*\u0001\u0019A\u0014\u0003\u0007A{7/A\u0004xSRD\u0007k\\:\u0015\u0005YJ\u0004cA\r\u0001oA\u0011\u0001HB\u0007\u0002\u0001!)!h\u0002a\u0001o\u00051a.Z<Q_N\fq![:F[B$\u00180F\u0001>!\t!c(\u0003\u0002@'\t9!i\\8mK\u0006t\u0017aA1mYV\t!\tE\u0002D\u0011\u001ej\u0011\u0001\u0012\u0006\u0003\u000b\u001a\u000b\u0011\"[7nkR\f'\r\\3\u000b\u0005\u001d\u001b\u0012AC2pY2,7\r^5p]&\u0011\u0011\n\u0012\u0002\u0004'\u0016$\u0018\u0001C2p]R\f\u0017N\\:\u0016\u00051#FCA\u001fN\u0011\u0015q%\u0002q\u0001P\u0003\t!H\u000fE\u0002Q#Nk\u0011!E\u0005\u0003%F\u0011\u0001b\u00117bgN$\u0016m\u001a\t\u0003?Q#Q!\u0016\u0006C\u0002Y\u0013\u0011\u0001V\t\u0003/\u001e\u0002\"\u0001\n-\n\u0005e\u001b\"a\u0002(pi\"LgnZ\u0001\u0004O\u0016$XC\u0001/b)\ti&\rE\u0002%=\u0002L!aX\n\u0003\r=\u0003H/[8o!\ty\u0012\rB\u0003V\u0017\t\u0007a\u000bC\u0003O\u0017\u0001\u000f1\rE\u0002Q#\u0002\fa!\u001e9eCR,WC\u00014p)\t9\u0007\u000f\u0006\u0002iYJ\u0011\u0011\u000e\u0007\u0004\u0005U\u0002\u0001\u0001N\u0001\u0007=e\u00164\u0017N\\3nK:$h(\u0002\u00034S\u00029\u0004\"\u0002(\r\u0001\bi\u0007c\u0001)R]B\u0011qd\u001c\u0003\u0006+2\u0011\rA\u0016\u0005\u0006c2\u0001\rA\\\u0001\u0007]\u0016<\u0018\t\u001e;\u0002\rI,Wn\u001c<f+\t!8\u0010\u0006\u0002vqJ\u0011a\u000f\u0007\u0004\u0005U\u0002\u0001Q/\u0002\u00034m\u00029\u0004\"\u0002(\u000e\u0001\bI\bc\u0001)RuB\u0011qd\u001f\u0003\u0006+6\u0011\rA\u0016")
public final class SingleAttachment<P>
extends Attachments {
    private final P pos;
    private final Object att;

    public P pos() {
        return this.pos;
    }

    public Object att() {
        return this.att;
    }

    public SingleAttachment<P> withPos(P newPos) {
        return new SingleAttachment<P>(newPos, this.att());
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Set<Object> all() {
        return (Set)Predef$.MODULE$.Set().empty().$plus(this.att());
    }

    @Override
    public <T> boolean contains(ClassTag<T> tt) {
        return tt.runtimeClass().isInstance(this.att());
    }

    @Override
    public <T> Option<T> get(ClassTag<T> tt) {
        if (this.contains(tt)) {
            return new Some<Object>(this.att());
        }
        return None$.MODULE$;
    }

    @Override
    public <T> Attachments update(T newAtt, ClassTag<T> tt) {
        if (this.contains(tt)) {
            return new SingleAttachment<P>(this.pos(), newAtt);
        }
        return new NonemptyAttachments<P>(this.pos(), (Set)Predef$.MODULE$.Set().empty().$plus(this.att()).$plus(newAtt));
    }

    @Override
    public <T> Attachments remove(ClassTag<T> tt) {
        if (this.contains(tt)) {
            return (Attachments)this.pos();
        }
        return this;
    }

    public SingleAttachment(P pos, Object att) {
        this.pos = pos;
        this.att = att;
    }
}

