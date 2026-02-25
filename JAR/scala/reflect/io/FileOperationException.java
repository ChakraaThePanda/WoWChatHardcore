/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.reflect.io.FileOperationException$;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005b\u0001\u0002\u000b\u0016\u0001rA\u0001b\u000b\u0001\u0003\u0016\u0004%\t\u0001\f\u0005\tq\u0001\u0011\t\u0012)A\u0005[!)\u0011\b\u0001C\u0001u!9a\bAA\u0001\n\u0003y\u0004bB!\u0001#\u0003%\tA\u0011\u0005\b\u001b\u0002\t\t\u0011\"\u0011O\u0011\u001d1\u0006!!A\u0005\u0002]Cqa\u0017\u0001\u0002\u0002\u0013\u0005A\fC\u0004c\u0001\u0005\u0005I\u0011I2\t\u000f)\u0004\u0011\u0011!C\u0001W\"9\u0001\u000fAA\u0001\n\u0003\n\bb\u0002:\u0001\u0003\u0003%\te]\u0004\bkV\t\t\u0011#\u0001w\r\u001d!R#!A\t\u0002]DQ!\u000f\b\u0005\u0002yD\u0001b \b\u0002\u0002\u0013\u0015\u0013\u0011\u0001\u0005\n\u0003\u0007q\u0011\u0011!CA\u0003\u000bA\u0011\"!\u0003\u000f\u0003\u0003%\t)a\u0003\t\u0013\u0005]a\"!A\u0005\n\u0005e!A\u0006$jY\u0016|\u0005/\u001a:bi&|g.\u0012=dKB$\u0018n\u001c8\u000b\u0005Y9\u0012AA5p\u0015\tA\u0012$A\u0004sK\u001adWm\u0019;\u000b\u0003i\tQa]2bY\u0006\u001c\u0001a\u0005\u0003\u0001;\u0015B\u0003C\u0001\u0010#\u001d\ty\u0002%D\u0001\u001a\u0013\t\t\u0013$A\u0004qC\u000e\\\u0017mZ3\n\u0005\r\"#\u0001\u0005*v]RLW.Z#yG\u0016\u0004H/[8o\u0015\t\t\u0013\u0004\u0005\u0002 M%\u0011q%\u0007\u0002\b!J|G-^2u!\ty\u0012&\u0003\u0002+3\ta1+\u001a:jC2L'0\u00192mK\u0006\u0019Qn]4\u0016\u00035\u0002\"AL\u001b\u000f\u0005=\u001a\u0004C\u0001\u0019\u001a\u001b\u0005\t$B\u0001\u001a\u001c\u0003\u0019a$o\\8u}%\u0011A'G\u0001\u0007!J,G-\u001a4\n\u0005Y:$AB*ue&twM\u0003\u000253\u0005!Qn]4!\u0003\u0019a\u0014N\\5u}Q\u00111(\u0010\t\u0003y\u0001i\u0011!\u0006\u0005\u0006W\r\u0001\r!L\u0001\u0005G>\u0004\u0018\u0010\u0006\u0002<\u0001\"91\u0006\u0002I\u0001\u0002\u0004i\u0013AD2paf$C-\u001a4bk2$H%M\u000b\u0002\u0007*\u0012Q\u0006R\u0016\u0002\u000bB\u0011aiS\u0007\u0002\u000f*\u0011\u0001*S\u0001\nk:\u001c\u0007.Z2lK\u0012T!AS\r\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002M\u000f\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0002\u001bA\u0014x\u000eZ;diB\u0013XMZ5y+\u0005y\u0005C\u0001)V\u001b\u0005\t&B\u0001*T\u0003\u0011a\u0017M\\4\u000b\u0003Q\u000bAA[1wC&\u0011a'U\u0001\raJ|G-^2u\u0003JLG/_\u000b\u00021B\u0011q$W\u0005\u00035f\u00111!\u00138u\u00039\u0001(o\u001c3vGR,E.Z7f]R$\"!\u00181\u0011\u0005}q\u0016BA0\u001a\u0005\r\te.\u001f\u0005\bC\"\t\t\u00111\u0001Y\u0003\rAH%M\u0001\u0010aJ|G-^2u\u0013R,'/\u0019;peV\tA\rE\u0002fQvk\u0011A\u001a\u0006\u0003Of\t!bY8mY\u0016\u001cG/[8o\u0013\tIgM\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0003!\u0019\u0017M\\#rk\u0006dGC\u00017p!\tyR.\u0003\u0002o3\t9!i\\8mK\u0006t\u0007bB1\u000b\u0003\u0003\u0005\r!X\u0001\tQ\u0006\u001c\bnQ8eKR\t\u0001,\u0001\u0004fcV\fGn\u001d\u000b\u0003YRDq!\u0019\u0007\u0002\u0002\u0003\u0007Q,\u0001\fGS2,w\n]3sCRLwN\\#yG\u0016\u0004H/[8o!\tadbE\u0002\u000fq\"\u0002B!\u001f?.w5\t!P\u0003\u0002|3\u00059!/\u001e8uS6,\u0017BA?{\u0005E\t%m\u001d;sC\u000e$h)\u001e8di&|g.\r\u000b\u0002m\u0006AAo\\*ue&tw\rF\u0001P\u0003\u0015\t\u0007\u000f\u001d7z)\rY\u0014q\u0001\u0005\u0006WE\u0001\r!L\u0001\bk:\f\u0007\u000f\u001d7z)\u0011\ti!a\u0005\u0011\t}\ty!L\u0005\u0004\u0003#I\"AB(qi&|g\u000e\u0003\u0005\u0002\u0016I\t\t\u00111\u0001<\u0003\rAH\u0005M\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002\u001cA\u0019\u0001+!\b\n\u0007\u0005}\u0011K\u0001\u0004PE*,7\r\u001e")
public class FileOperationException
extends RuntimeException
implements Product,
Serializable {
    private final String msg;

    public static Option<String> unapply(FileOperationException fileOperationException) {
        return FileOperationException$.MODULE$.unapply(fileOperationException);
    }

    public static FileOperationException apply(String string) {
        return FileOperationException$.MODULE$.apply(string);
    }

    public static <A> Function1<String, A> andThen(Function1<FileOperationException, A> function1) {
        FileOperationException$ fileOperationException$ = FileOperationException$.MODULE$;
        if (fileOperationException$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$andThen$1(fileOperationException$, function1, arg_0);
    }

    public static <A> Function1<A, FileOperationException> compose(Function1<A, String> function1) {
        FileOperationException$ fileOperationException$ = FileOperationException$.MODULE$;
        if (fileOperationException$ == null) {
            throw null;
        }
        return arg_0 -> Function1.$anonfun$compose$1(fileOperationException$, function1, arg_0);
    }

    public String msg() {
        return this.msg;
    }

    public FileOperationException copy(String msg) {
        return new FileOperationException(msg);
    }

    public String copy$default$1() {
        return this.msg();
    }

    @Override
    public String productPrefix() {
        return "FileOperationException";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.msg();
            }
        }
        throw new IndexOutOfBoundsException(Integer.toString(x$1));
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof FileOperationException;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof FileOperationException;
                if (!bl) break block3;
                FileOperationException fileOperationException = (FileOperationException)x$1;
                String string = this.msg();
                String string2 = fileOperationException.msg();
                if (!(!(string != null ? !string.equals(string2) : string2 != null) && fileOperationException.canEqual(this))) break block3;
            }
            return true;
        }
        return false;
    }

    public FileOperationException(String msg) {
        this.msg = msg;
        super(msg);
        Product.$init$(this);
    }
}

