/*
 * Decompiled with CFR 0.152.
 */
package scala.collection;

import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.Builder;
import scala.collection.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.Nothing$;

@ScalaSignature(bytes="\u0006\u0001Q;QAC\u0006\t\u0002A1QAE\u0006\t\u0002MAQ\u0001G\u0001\u0005\u0002eAQAG\u0001\u0005\u0002m1QaN\u0001\u0003\u0017aB\u0001\"\u0011\u0003\u0003\u0006\u0004%\tA\u0011\u0005\t\t\u0012\u0011\t\u0011)A\u0005\u0007\")\u0001\u0004\u0002C\u0001\u000b\")\u0011\n\u0002C\u0001\u0015\")\u0011\n\u0002C\u0001'\u00069\u0001/Y2lC\u001e,'B\u0001\u0007\u000e\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\u0006\u0002\u001d\u0005)1oY1mC\u000e\u0001\u0001CA\t\u0002\u001b\u0005Y!a\u00029bG.\fw-Z\n\u0003\u0003Q\u0001\"!\u0006\f\u000e\u00035I!aF\u0007\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}Q\t\u0001#\u0001\u0005ce\u0016\f7nT;u+\u0011aRe\f\u001a\u0015\u0005u!\u0004#\u0002\u0010\"G9\nT\"A\u0010\u000b\u0005\u0001Z\u0011aB4f]\u0016\u0014\u0018nY\u0005\u0003E}\u0011AbQ1o\u0005VLG\u000e\u001a$s_6\u0004\"\u0001J\u0013\r\u0001\u0011)ae\u0001b\u0001O\t!aI]8n#\tA3\u0006\u0005\u0002\u0016S%\u0011!&\u0004\u0002\b\u001d>$\b.\u001b8h!\t)B&\u0003\u0002.\u001b\t\u0019\u0011I\\=\u0011\u0005\u0011zC!\u0002\u0019\u0004\u0005\u00049#!\u0001+\u0011\u0005\u0011\u0012D!B\u001a\u0004\u0005\u00049#A\u0001+p\u0011\u0015)4\u0001q\u00017\u0003\u0005\u0011\u0007#\u0002\u0010\"Q9\n$aE,sCB\u0004X\rZ\"b]\n+\u0018\u000e\u001c3Ge>lW\u0003B\u001d=}\u0001\u001b2\u0001\u0002\u000b;!\u0015q\u0012eO\u001f@!\t!C\bB\u0003'\t\t\u0007q\u0005\u0005\u0002%}\u0011)\u0001\u0007\u0002b\u0001OA\u0011A\u0005\u0011\u0003\u0006g\u0011\u0011\raJ\u0001\boJ\f\u0007\u000f]3e+\u0005\u0019\u0005#\u0002\u0010\"Quz\u0014\u0001C<sCB\u0004X\r\u001a\u0011\u0015\u0005\u0019C\u0005#B$\u0005wuzT\"A\u0001\t\u000b\u0005;\u0001\u0019A\"\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0005-\u000b\u0006\u0003\u0002'P{}j\u0011!\u0014\u0006\u0003\u001d.\tq!\\;uC\ndW-\u0003\u0002Q\u001b\n9!)^5mI\u0016\u0014\b\"\u0002*\t\u0001\u0004Y\u0014\u0001\u00024s_6$\u0012a\u0013")
public final class package {
    public static <From, T, To> CanBuildFrom<From, T, To> breakOut(CanBuildFrom<Nothing$, T, To> canBuildFrom) {
        return package$.MODULE$.breakOut(canBuildFrom);
    }

    public static final class WrappedCanBuildFrom<From, T, To>
    implements CanBuildFrom<From, T, To> {
        private final CanBuildFrom<Nothing$, T, To> wrapped;

        public CanBuildFrom<Nothing$, T, To> wrapped() {
            return this.wrapped;
        }

        @Override
        public Builder<T, To> apply(From from) {
            return this.wrapped().apply();
        }

        @Override
        public Builder<T, To> apply() {
            return this.wrapped().apply();
        }

        public WrappedCanBuildFrom(CanBuildFrom<Nothing$, T, To> wrapped) {
            this.wrapped = wrapped;
        }
    }
}

