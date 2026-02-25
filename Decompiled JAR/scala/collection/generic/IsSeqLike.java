/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.Function1;
import scala.collection.SeqLike;
import scala.collection.generic.IsSeqLike$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001y3q!\u0003\u0006\u0011\u0002G\u0005\u0011\u0003B\u0003\u0018\u0001\t\u0005\u0001\u0004C\u0004 \u0001\t\u0007i\u0011\u0001\u0011\b\u000b9R\u0001\u0012A\u0018\u0007\u000b%Q\u0001\u0012A\u0019\t\u000bI\"A\u0011A\u001a\t\u000fQ\"!\u0019!C\u0002k!1\u0011\n\u0002Q\u0001\nYBQA\u0013\u0003\u0005\u0004-\u0013\u0011\"S:TKFd\u0015n[3\u000b\u0005-a\u0011aB4f]\u0016\u0014\u0018n\u0019\u0006\u0003\u001b9\t!bY8mY\u0016\u001cG/[8o\u0015\u0005y\u0011!B:dC2\f7\u0001A\u000b\u0003%\u0019\u001a\"\u0001A\n\u0011\u0005Q)R\"\u0001\b\n\u0005Yq!AB!osJ+gMA\u0001B#\tIB\u0004\u0005\u0002\u00155%\u00111D\u0004\u0002\b\u001d>$\b.\u001b8h!\t!R$\u0003\u0002\u001f\u001d\t\u0019\u0011I\\=\u0002\u0015\r|gN^3sg&|g.F\u0001\"!\u0011!\"\u0005\n\u0015\n\u0005\rr!!\u0003$v]\u000e$\u0018n\u001c82!\t)c\u0005\u0004\u0001\u0005\u000b\u001d\u0002!\u0019\u0001\r\u0003\tI+\u0007O\u001d\t\u0005S)bC%D\u0001\r\u0013\tYCBA\u0004TKFd\u0015n[3\u0011\u00055\nQ\"\u0001\u0001\u0002\u0013%\u001b8+Z9MS.,\u0007C\u0001\u0019\u0005\u001b\u0005Q1C\u0001\u0003\u0014\u0003\u0019a\u0014N\\5u}Q\tq&\u0001\u0006tiJLgn\u001a*faJ,\u0012A\u000e\n\u0003oe2A\u0001\u000f\u0003\u0001m\taAH]3gS:,W.\u001a8u}A\u0019\u0001\u0007\u0001\u001e\u0011\u0005m\u0012eB\u0001\u001fA!\tid\"D\u0001?\u0015\ty\u0004#\u0001\u0004=e>|GOP\u0005\u0003\u0003:\ta\u0001\u0015:fI\u00164\u0017BA\"E\u0005\u0019\u0019FO]5oO*\u0011\u0011ID\u0003\u0005/]\u0002c\t\u0005\u0002\u0015\u000f&\u0011\u0001J\u0004\u0002\u0005\u0007\"\f'/A\u0006tiJLgn\u001a*faJ\u0004\u0013aC:fc2K7.\u001a*faJ,2\u0001T)X)\ti%L\u0005\u0002O\u001f\u001a!\u0001\b\u0002\u0001N!\r\u0001\u0004\u0001\u0015\t\u0004KE3F!\u0002*\t\u0005\u0004\u0019&!A\"\u0016\u0005a!F!B+R\u0005\u0004A\"!A0\u0011\u0005\u0015:F!\u0002-\t\u0005\u0004A\"AA!1\u000b\u00119b\n\u0001,\t\u000bmC\u00019\u0001/\u0002\t\r|gN\u001e\t\u0005)\t\u0002V\f\u0005\u0003*UY\u0003\u0006")
public interface IsSeqLike<Repr> {
    public static <C, A0> IsSeqLike<C> seqLikeRepr(Function1<C, SeqLike<A0, C>> function1) {
        if (IsSeqLike$.MODULE$ == null) {
            throw null;
        }
        return new IsSeqLike<C>(function1){
            private final Function1<C, SeqLike<A0, C>> conversion;

            public Function1<C, SeqLike<A0, C>> conversion() {
                return this.conversion;
            }
            {
                this.conversion = conv$1;
            }
        };
    }

    public static IsSeqLike<String> stringRepr() {
        return IsSeqLike$.MODULE$.stringRepr();
    }

    public Function1<Repr, SeqLike<Object, Repr>> conversion();
}

