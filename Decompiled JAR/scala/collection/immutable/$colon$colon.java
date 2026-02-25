/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.collection.Iterator;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\u0005\rd\u0001\u0002\r\u001a\u0005\u0002B\u0001\u0002\u000f\u0001\u0003\u0016\u0004%\t%\u000f\u0005\tu\u0001\u0011\t\u0012)A\u0005M!I1\b\u0001BA\u0002\u0013\u0005Q\u0004\u0010\u0005\n{\u0001\u0011\t\u0019!C\u0001;yB\u0001\u0002\u0012\u0001\u0003\u0012\u0003\u0006KA\t\u0005\u0006\u000b\u0002!\tA\u0012\u0005\u0006\u0015\u0002!\t\u0005\u0010\u0005\u0006\u0017\u0002!\t\u0005\u0014\u0005\b!\u0002\t\t\u0011\"\u0001R\u0011\u001dI\u0006!%A\u0005\u0002iCqa\u001a\u0001\u0012\u0002\u0013\u0005\u0001\u000eC\u0004m\u0001%\u0005I\u0011\u0001\u001f\t\u000f5\u0004\u0011\u0011!C!]\"9q\u000fAA\u0001\n\u0003A\bb\u0002?\u0001\u0003\u0003%\t! \u0005\t\u007f\u0002\t\t\u0011\"\u0011\u0002\u0002\u001dI\u0011qC\r\u0002\u0002#\u0005\u0011\u0011\u0004\u0004\t1e\t\t\u0011#\u0001\u0002\u001c!1QI\u0005C\u0001\u0003GA\u0011\"!\n\u0013\u0003\u0003%)%a\n\t\u0013\u0005%\"#!A\u0005\u0002\u0006-\u0002\"CA\u001e%\u0005\u0005I\u0011QA\u001f\u0011%\tIFEA\u0001\n\u0013\tYF\u0001\u0007%G>dwN\u001c\u0013d_2|gN\u0003\u0002\u001b7\u0005I\u0011.\\7vi\u0006\u0014G.\u001a\u0006\u00039u\t!bY8mY\u0016\u001cG/[8o\u0015\u0005q\u0012!B:dC2\f7\u0001A\u000b\u0003C!\u001aB\u0001\u0001\u00123kA\u00191\u0005\n\u0014\u000e\u0003eI!!J\r\u0003\t1K7\u000f\u001e\t\u0003O!b\u0001\u0001B\u0003*\u0001\t\u0007!FA\u0001C#\tYs\u0006\u0005\u0002-[5\tQ$\u0003\u0002/;\t9aj\u001c;iS:<\u0007C\u0001\u00171\u0013\t\tTDA\u0002B]f\u0004\"\u0001L\u001a\n\u0005Qj\"a\u0002)s_\u0012,8\r\u001e\t\u0003YYJ!aN\u000f\u0003\u0019M+'/[1mSj\f'\r\\3\u0002\t!,\u0017\rZ\u000b\u0002M\u0005)\u0001.Z1eA\u0005\u0011A\u000f\\\u000b\u0002E\u00051A\u000f\\0%KF$\"a\u0010\"\u0011\u00051\u0002\u0015BA!\u001e\u0005\u0011)f.\u001b;\t\u000f\r#\u0011\u0011!a\u0001E\u0005\u0019\u0001\u0010J\u0019\u0002\u0007Qd\u0007%\u0001\u0004=S:LGO\u0010\u000b\u0004\u000f\"K\u0005cA\u0012\u0001M!)\u0001H\u0002a\u0001M!)1H\u0002a\u0001E\u0005!A/Y5m\u0003\u001dI7/R7qif,\u0012!\u0014\t\u0003Y9K!aT\u000f\u0003\u000f\t{w\u000e\\3b]\u0006!1m\u001c9z+\t\u0011V\u000bF\u0002T-^\u00032a\t\u0001U!\t9S\u000bB\u0003*\u0013\t\u0007!\u0006C\u00049\u0013A\u0005\t\u0019\u0001+\t\u000fmJ\u0001\u0013!a\u00011B\u00191\u0005\n+\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%cU\u00111LZ\u000b\u00029*\u0012a%X\u0016\u0002=B\u0011q\fZ\u0007\u0002A*\u0011\u0011MY\u0001\nk:\u001c\u0007.Z2lK\u0012T!aY\u000f\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002fA\n\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\u0005\u000b%R!\u0019\u0001\u0016\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\fW\u000f\u001c;%eU\u0011\u0011n[\u000b\u0002U*\u0012!%\u0018\u0003\u0006S-\u0011\rAK\u0001\fi2$\u0013mY2fgN$\u0013'A\u0007qe>$Wo\u0019;Qe\u00164\u0017\u000e_\u000b\u0002_B\u0011\u0001/^\u0007\u0002c*\u0011!o]\u0001\u0005Y\u0006twMC\u0001u\u0003\u0011Q\u0017M^1\n\u0005Y\f(AB*ue&tw-\u0001\u0007qe>$Wo\u0019;Be&$\u00180F\u0001z!\ta#0\u0003\u0002|;\t\u0019\u0011J\u001c;\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR\u0011qF \u0005\b\u0007>\t\t\u00111\u0001z\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XCAA\u0002!\u0015\t)!a\u00020\u001b\u0005Y\u0012bAA\u00057\tA\u0011\n^3sCR|'\u000fK\u0004\u0001\u0003\u001b\t\u0019\"!\u0006\u0011\u00071\ny!C\u0002\u0002\u0012u\u0011\u0001cU3sS\u0006dg+\u001a:tS>tW+\u0013#\u0002\u000bY\fG.^3\u001f\u0011\u001d\u0019\u0012Uq7.Go\rA\u0002J2pY>tGeY8m_:\u0004\"a\t\n\u0014\tI\ti\"\u000e\t\u0004Y\u0005}\u0011bAA\u0011;\t1\u0011I\\=SK\u001a$\"!!\u0007\u0002\u0011Q|7\u000b\u001e:j]\u001e$\u0012a\\\u0001\u0006CB\u0004H._\u000b\u0005\u0003[\t\u0019\u0004\u0006\u0004\u00020\u0005U\u0012q\u0007\t\u0005G\u0001\t\t\u0004E\u0002(\u0003g!Q!K\u000bC\u0002)Ba\u0001O\u000bA\u0002\u0005E\u0002BB\u001e\u0016\u0001\u0004\tI\u0004\u0005\u0003$I\u0005E\u0012aB;oCB\u0004H._\u000b\u0005\u0003\u007f\ty\u0005\u0006\u0003\u0002B\u0005M\u0003#\u0002\u0017\u0002D\u0005\u001d\u0013bAA#;\t1q\n\u001d;j_:\u0004r\u0001LA%\u0003\u001b\n\t&C\u0002\u0002Lu\u0011a\u0001V;qY\u0016\u0014\u0004cA\u0014\u0002P\u0011)\u0011F\u0006b\u0001UA!1\u0005JA'\u0011%\t)FFA\u0001\u0002\u0004\t9&A\u0002yIA\u0002Ba\t\u0001\u0002N\u0005Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\ti\u0006E\u0002q\u0003?J1!!\u0019r\u0005\u0019y%M[3di\u0002")
public final class $colon$colon<B>
extends List<B> {
    public static final long serialVersionUID = 509929039250432923L;
    private final B head;
    private List<B> tl;

    public List<B> tl$access$1() {
        return this.tl;
    }

    @Override
    public B head() {
        return this.head;
    }

    public List<B> tl() {
        return this.tl;
    }

    public void tl_$eq(List<B> x$1) {
        this.tl = x$1;
    }

    @Override
    public List<B> tail() {
        return this.tl();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public <B> $colon$colon<B> copy(B head, List<B> tl) {
        return new $colon$colon<B>(head, tl);
    }

    public <B> B copy$default$1() {
        return this.head();
    }

    public <B> List<B> copy$default$2() {
        return this.tl();
    }

    @Override
    public String productPrefix() {
        return "::";
    }

    @Override
    public int productArity() {
        return 2;
    }

    @Override
    public Object productElement(int x$1) {
        switch (x$1) {
            case 0: {
                return this.head();
            }
            case 1: {
                return this.tl$access$1();
            }
        }
        throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    public $colon$colon(B head, List<B> tl) {
        this.head = head;
        this.tl = tl;
    }
}

