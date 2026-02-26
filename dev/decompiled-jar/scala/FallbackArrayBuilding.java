/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Predef;
import scala.collection.generic.CanBuildFrom;
import scala.collection.mutable.ArraySeq;
import scala.collection.mutable.ArraySeq$;
import scala.collection.mutable.Builder;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001}2Aa\u0001\u0003\u0001\u000f!)A\u0002\u0001C\u0001\u001b!)q\u0002\u0001C\u0002!\t)b)\u00197mE\u0006\u001c7.\u0011:sCf\u0014U/\u001b7eS:<'\"A\u0003\u0002\u000bM\u001c\u0017\r\\1\u0004\u0001M\u0011\u0001\u0001\u0003\t\u0003\u0013)i\u0011\u0001B\u0005\u0003\u0017\u0011\u0011a!\u00118z%\u00164\u0017A\u0002\u001fj]&$h\bF\u0001\u000f!\tI\u0001!\u0001\u000bgC2d'-Y2l\u0007\u0006t')^5mI\u001a\u0013x.\\\u000b\u0003#)\"\"A\u0005\u001a\u0011\u000bMA\"$\u000b\u0017\u000e\u0003QQ!!\u0006\f\u0002\u000f\u001d,g.\u001a:jG*\u0011q\u0003B\u0001\u000bG>dG.Z2uS>t\u0017BA\r\u0015\u00051\u0019\u0015M\u001c\"vS2$gI]8na\tY\u0002\u0005E\u0002\n9yI!!\b\u0003\u0003\u000b\u0005\u0013(/Y=\u0011\u0005}\u0001C\u0002\u0001\u0003\nC\t\t\t\u0011!A\u0003\u0002\t\u00121a\u0018\u00132#\t\u0019c\u0005\u0005\u0002\nI%\u0011Q\u0005\u0002\u0002\b\u001d>$\b.\u001b8h!\tIq%\u0003\u0002)\t\t\u0019\u0011I\\=\u0011\u0005}QC!B\u0016\u0003\u0005\u0004\u0011#!\u0001+\u0011\u00075\u0002\u0014&D\u0001/\u0015\tyc#A\u0004nkR\f'\r\\3\n\u0005Er#\u0001C!se\u0006L8+Z9\t\u000bM\u0012\u00019\u0001\u001b\u0002\u00035\u0004\"!\u000e\u001f\u000f\u0005YR\u0004CA\u001c\u0005\u001b\u0005A$BA\u001d\u0007\u0003\u0019a$o\\8u}%\u00111\bB\u0001\u0007!J,G-\u001a4\n\u0005ur$!\u0004#v[6L\u0018*\u001c9mS\u000eLGO\u0003\u0002<\t\u0001")
public class FallbackArrayBuilding {
    public <T> CanBuildFrom<Object, T, ArraySeq<T>> fallbackCanBuildFrom(Predef.DummyImplicit m) {
        return new CanBuildFrom<Object, T, ArraySeq<T>>(null){

            public Builder<T, ArraySeq<T>> apply(Object from) {
                return ArraySeq$.MODULE$.newBuilder();
            }

            public Builder<T, ArraySeq<T>> apply() {
                return ArraySeq$.MODULE$.newBuilder();
            }
        };
    }
}

