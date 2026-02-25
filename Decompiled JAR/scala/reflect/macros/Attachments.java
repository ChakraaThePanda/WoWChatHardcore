/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.macros;

import scala.Function1;
import scala.Option;
import scala.collection.immutable.Set;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.macros.Attachments$;
import scala.reflect.macros.NonemptyAttachments;
import scala.reflect.macros.SingleAttachment;
import scala.reflect.package$;

@ScalaSignature(bytes="\u0006\u0001\u0005\u0005d!\u0002\u000b\u0016\u0003\u0003a\u0002\"B\u0011\u0001\t\u0003\u0011C!B\u0013\u0001\u0005\u00031\u0003\"B\u0017\u0001\r\u0003q\u0003\"B\u0019\u0001\r\u0003\u0011\u0004\"B\u001d\u0001\r\u0003Q\u0004\"\u0002$\u0001\t\u00139\u0005\"B/\u0001\t\u0003q\u0006\"\u00025\u0001\t\u0003I\u0007\"\u00029\u0001\t\u0003\t\b\"\u0002@\u0001\t\u0003y\bbBA\n\u0001\u0011\u0015\u0011Q\u0003\u0005\b\u0003K\u0001AQAA\u0014\u0011\u001d\t9\u0004\u0001C\u0003\u0003sAq!a\u0010\u0001\r\u0003\t\teB\u0004\u0002DUAI!!\u0012\u0007\rQ)\u0002\u0012BA$\u0011\u0019\t\u0003\u0003\"\u0001\u0002J!I\u00111\n\tC\u0002\u0013%\u0011Q\n\u0005\t\u0003?\u0002\u0002\u0015!\u0003\u0002P\tY\u0011\t\u001e;bG\"lWM\u001c;t\u0015\t1r#\u0001\u0004nC\u000e\u0014xn\u001d\u0006\u00031e\tqA]3gY\u0016\u001cGOC\u0001\u001b\u0003\u0015\u00198-\u00197b\u0007\u0001\u0019\"\u0001A\u000f\u0011\u0005yyR\"A\r\n\u0005\u0001J\"AB!osJ+g-\u0001\u0004=S:LGO\u0010\u000b\u0002GA\u0011A\u0005A\u0007\u0002+\t\u0019\u0001k\\:\u0012\u0005\u001dR\u0003C\u0001\u0010)\u0013\tI\u0013D\u0001\u0003Ok2d\u0007C\u0001\u0010,\u0013\ta\u0013DA\u0002B]f\f1\u0001]8t+\u0005y\u0003C\u0001\u0019\u0003\u001b\u0005\u0001\u0011aB<ji\"\u0004vn\u001d\u000b\u0003g]\u0012\"\u0001N\u0012\u0007\tU\u0002\u0001a\r\u0002\ryI,g-\u001b8f[\u0016tGOP\u0003\u0005KQ\u0002s\u0006C\u00039\t\u0001\u0007q&\u0001\u0004oK^\u0004vn]\u0001\u0004C2dW#A\u001e\u0011\u0007q\u001a%F\u0004\u0002>\u0003B\u0011a(G\u0007\u0002\u007f)\u0011\u0001iG\u0001\u0007yI|w\u000e\u001e \n\u0005\tK\u0012A\u0002)sK\u0012,g-\u0003\u0002E\u000b\n\u00191+\u001a;\u000b\u0005\tK\u0012AC7bi\u000eDWm\u001d+bOV\u0011\u0001j\u0016\u000b\u0003\u0013>\u0003BA\b&+\u0019&\u00111*\u0007\u0002\n\rVt7\r^5p]F\u0002\"AH'\n\u00059K\"a\u0002\"p_2,\u0017M\u001c\u0005\b!\u001a\t\t\u0011q\u0001R\u0003))g/\u001b3f]\u000e,G%\r\t\u0004%N+V\"A\f\n\u0005Q;\"\u0001C\"mCN\u001cH+Y4\u0011\u0005Y;F\u0002\u0001\u0003\u00061\u001a\u0011\r!\u0017\u0002\u0002)F\u0011!L\u000b\t\u0003=mK!\u0001X\r\u0003\u000f9{G\u000f[5oO\u0006\u0019q-\u001a;\u0016\u0005}#GC\u00011f!\rq\u0012mY\u0005\u0003Ef\u0011aa\u00149uS>t\u0007C\u0001,e\t\u0015AvA1\u0001Z\u0011\u001d1w!!AA\u0004\u001d\f!\"\u001a<jI\u0016t7-\u001a\u00133!\r\u00116kY\u0001\tG>tG/Y5ogV\u0011!n\u001c\u000b\u0003\u0019.Dq\u0001\u001c\u0005\u0002\u0002\u0003\u000fQ.\u0001\u0006fm&$WM\\2fIM\u00022AU*o!\t1v\u000eB\u0003Y\u0011\t\u0007\u0011,\u0001\u0004va\u0012\fG/Z\u000b\u0003en$\"a\u001d?\u0015\u0005Q<(CA;$\r\u0011)\u0004\u0001\u0001;\u0006\t\u0015*\be\f\u0005\bq&\t\t\u0011q\u0001z\u0003))g/\u001b3f]\u000e,G\u0005\u000e\t\u0004%NS\bC\u0001,|\t\u0015A\u0016B1\u0001Z\u0011\u0015i\u0018\u00021\u0001{\u0003)\tG\u000f^1dQ6,g\u000e^\u0001\u0007e\u0016lwN^3\u0016\t\u0005\u0005\u0011\u0011\u0003\u000b\u0005\u0003\u0007\tIAE\u0002\u0002\u0006\r2Q!\u000e\u0001\u0001\u0003\u0007)Q!JA\u0003A=B\u0011\"a\u0003\u000b\u0003\u0003\u0005\u001d!!\u0004\u0002\u0015\u00154\u0018\u000eZ3oG\u0016$S\u0007\u0005\u0003S'\u0006=\u0001c\u0001,\u0002\u0012\u0011)\u0001L\u0003b\u00013\u0006i!/Z7pm\u0016,E.Z7f]R,B!a\u0006\u0002$Q!\u0011\u0011DA\u0010%\r\tYb\t\u0004\u0006k\u0001\u0001\u0011\u0011D\u0003\u0006K\u0005m\u0001e\f\u0005\u0007{.\u0001\r!!\t\u0011\u0007Y\u000b\u0019\u0003B\u0003Y\u0017\t\u0007\u0011,\u0001\u0006bI\u0012,E.Z7f]R,B!!\u000b\u00026Q!\u00111FA\u0019%\r\tic\t\u0004\u0006k\u0001\u0001\u00111F\u0003\u0006K\u00055\u0002e\f\u0005\u0007{2\u0001\r!a\r\u0011\u0007Y\u000b)\u0004B\u0003Y\u0019\t\u0007\u0011,A\bd_:$\u0018-\u001b8t\u000b2,W.\u001a8u)\ra\u00151\b\u0005\u0007\u0003{i\u0001\u0019\u0001\u0016\u0002\u000f\u0015dW-\\3oi\u00069\u0011n]#naRLX#\u0001'\u0002\u0017\u0005#H/Y2i[\u0016tGo\u001d\t\u0003IA\u0019\"\u0001E\u000f\u0015\u0005\u0005\u0015\u0013aD7bi\u000eDWm\u001d+bO\u000e\u000b7\r[3\u0016\u0005\u0005=\u0003#BA)\u00037JUBAA*\u0015\u0011\t)&a\u0016\u0002\t1\fgn\u001a\u0006\u0003\u00033\nAA[1wC&!\u0011QLA*\u0005)\u0019E.Y:t-\u0006dW/Z\u0001\u0011[\u0006$8\r[3t)\u0006<7)Y2iK\u0002\u0002")
public abstract class Attachments {
    public abstract Object pos();

    public abstract Attachments withPos(Object var1);

    public abstract Set<Object> all();

    private <T> Function1<Object, Object> matchesTag(ClassTag<T> evidence$1) {
        return Attachments$.MODULE$.scala$reflect$macros$Attachments$$matchesTagCache().get(package$.MODULE$.classTag(evidence$1).runtimeClass());
    }

    public <T> Option<T> get(ClassTag<T> evidence$2) {
        return this.all().find(this.matchesTag(evidence$2));
    }

    public <T> boolean contains(ClassTag<T> evidence$3) {
        return !this.isEmpty() && this.all().exists(this.matchesTag(evidence$3));
    }

    public <T> Attachments update(T attachment, ClassTag<T> evidence$4) {
        return new NonemptyAttachments<Object>(this.pos(), (Set)this.remove(evidence$4).all().$plus(attachment));
    }

    public <T> Attachments remove(ClassTag<T> evidence$5) {
        if (!this.all().exists(this.matchesTag(evidence$5))) {
            return this;
        }
        Set newAll = (Set)this.all().filterNot(this.matchesTag(evidence$5));
        if (newAll.isEmpty()) {
            return (Attachments)this.pos();
        }
        if (newAll.size() == 1) {
            return new SingleAttachment<Object>(this.pos(), newAll.head());
        }
        return new NonemptyAttachments<Object>(this.pos(), newAll);
    }

    public final <T> Attachments removeElement(T attachment) {
        Set newAll = (Set)this.all().$minus(attachment);
        if (newAll == this.all()) {
            return this;
        }
        if (newAll.isEmpty()) {
            return (Attachments)this.pos();
        }
        return new NonemptyAttachments<Object>(this.pos(), newAll);
    }

    public final <T> Attachments addElement(T attachment) {
        Set newAll = (Set)this.all().$plus(attachment);
        if (newAll == this.all()) {
            return this;
        }
        return new NonemptyAttachments<Object>(this.pos(), newAll);
    }

    public final boolean containsElement(Object element) {
        return this.all().contains(element);
    }

    public abstract boolean isEmpty();
}

