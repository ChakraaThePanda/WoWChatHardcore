/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.Traversable;
import scala.collection.generic.GenericClassTagCompanion;
import scala.collection.generic.HasNewBuilder;
import scala.collection.mutable.Builder;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005%aaB\u0004\t!\u0003\r\ta\u0004\u0005\u0006u\u0001!\ta\u000f\u0005\b\u007f\u0001\u0011\rUb\u0005A\u0011\u00159\u0005A\"\u0001I\u0011\u0015i\u0005\u0001\"\u0001O\u0011\u0015a\u0006\u0001\"\u0001^\u0011\u0015i\u0007\u0001\"\u0001o\u0005\t:UM\\3sS\u000e\u001cE.Y:t)\u0006<GK]1wKJ\u001c\u0018M\u00197f)\u0016l\u0007\u000f\\1uK*\u0011\u0011BC\u0001\bO\u0016tWM]5d\u0015\tYA\"\u0001\u0006d_2dWm\u0019;j_:T\u0011!D\u0001\u0006g\u000e\fG.Y\u0002\u0001+\r\u00012DJ\n\u0004\u0001E)\u0002C\u0001\n\u0014\u001b\u0005a\u0011B\u0001\u000b\r\u0005\u0019\te.\u001f*fMB!acF\r%\u001b\u0005A\u0011B\u0001\r\t\u00055A\u0015m\u001d(fo\n+\u0018\u000e\u001c3feB\u0011!d\u0007\u0007\u0001\t\u0019a\u0002\u0001\"b\u0001;\t\t\u0011)\u0005\u0002\u001fCA\u0011!cH\u0005\u0003A1\u0011qAT8uQ&tw\r\u0005\u0002\u0013E%\u00111\u0005\u0004\u0002\u0004\u0003:L(FA\u00132!\rQb%\u0007\u0003\u0007O\u0001!)\u0019\u0001\u0015\u0003\u0005\r\u001bUCA\u00150#\tq\"\u0006E\u0002,Y9j\u0011AC\u0005\u0003[)\u00111\u0002\u0016:bm\u0016\u00148/\u00192mKB\u0011!d\f\u0003\u0006a\u0019\u0012\r!\b\u0002\u00021.\n!\u0007\u0005\u00024q5\tAG\u0003\u00026m\u0005IQO\\2iK\u000e\\W\r\u001a\u0006\u0003o1\t!\"\u00198o_R\fG/[8o\u0013\tIDGA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\fa\u0001J5oSR$C#\u0001\u001f\u0011\u0005Ii\u0014B\u0001 \r\u0005\u0011)f.\u001b;\u0002\u0007Q\fw-F\u0001B!\r\u0011U)G\u0007\u0002\u0007*\u0011A\tD\u0001\be\u00164G.Z2u\u0013\t15I\u0001\u0005DY\u0006\u001c8\u000fV1h\u0003E\u0019G.Y:t)\u0006<7i\\7qC:LwN\\\u000b\u0002\u0013B\u0019aC\u0013'\n\u0005-C!\u0001G$f]\u0016\u0014\u0018nY\"mCN\u001cH+Y4D_6\u0004\u0018M\\5p]B\u0011!DJ\u0001\u0017O\u0016tWM]5d\u00072\f7o\u001d+bO\n+\u0018\u000e\u001c3feV\u0011qj\u0016\u000b\u0003!j\u0003B!\u0015+W36\t!K\u0003\u0002T\u0015\u00059Q.\u001e;bE2,\u0017BA+S\u0005\u001d\u0011U/\u001b7eKJ\u0004\"AG,\u0005\u000ba#!\u0019A\u000f\u0003\u0003\t\u00032A\u0007\u0014W\u0011\u0015yD\u0001q\u0001\\!\r\u0011UIV\u0001\u0017G2\f7o]'b]&4Wm\u001d;D_6\u0004\u0018M\\5p]V\ta\fE\u0002`E2s!A\u00061\n\u0005\u0005D\u0011a\u00029bG.\fw-Z\u0005\u0003G\u0012\u0014QdR3oKJL7m\u00117bgNl\u0015M\\5gKN$8i\\7qC:LwN\u001c\u0006\u0003C\"AC!\u00024jWB\u0011!cZ\u0005\u0003Q2\u0011!\u0002Z3qe\u0016\u001c\u0017\r^3eC\u0005Q\u0017!H;tK\u0002\u001aG.Y:t)\u0006<7i\\7qC:LwN\u001c\u0011j]N$X-\u00193\"\u00031\faA\r\u00182a9\u0002\u0014aG4f]\u0016\u0014\u0018nY\"mCN\u001cX*\u00198jM\u0016\u001cHOQ;jY\u0012,'/\u0006\u0002peR\u0011\u0001\u000f\u001e\t\u0005#R\u000b8\u000f\u0005\u0002\u001be\u0012)\u0001L\u0002b\u0001;A\u0019!DJ9\t\u000bU4\u00019\u0001<\u0002\u00115\fg.\u001b4fgR\u00042a\u001e@r\u001d\tAH\u0010\u0005\u0002z\u00195\t!P\u0003\u0002|\u001d\u00051AH]8pizJ!! \u0007\u0002\rA\u0013X\rZ3g\u0013\ry\u0018\u0011\u0001\u0002\u000e\u00072\f7o]'b]&4Wm\u001d;\u000b\u0005ud\u0001&\u0002\u0004g\u0003\u000bY\u0017EAA\u0004\u0003\t*8/\u001a\u0011hK:,'/[2DY\u0006\u001c8\u000fV1h\u0005VLG\u000eZ3sA%t7\u000f^3bI\u0002")
public interface GenericClassTagTraversableTemplate<A, CC extends Traversable<Object>>
extends HasNewBuilder<A, CC> {
    public ClassTag<A> tag();

    public GenericClassTagCompanion<CC> classTagCompanion();

    public static /* synthetic */ Builder genericClassTagBuilder$(GenericClassTagTraversableTemplate $this, ClassTag tag) {
        return $this.genericClassTagBuilder(tag);
    }

    default public <B> Builder<B, CC> genericClassTagBuilder(ClassTag<B> tag) {
        return this.classTagCompanion().newBuilder(tag);
    }

    public static /* synthetic */ GenericClassTagCompanion classManifestCompanion$(GenericClassTagTraversableTemplate $this) {
        return $this.classManifestCompanion();
    }

    default public GenericClassTagCompanion<CC> classManifestCompanion() {
        return this.classTagCompanion();
    }

    public static /* synthetic */ Builder genericClassManifestBuilder$(GenericClassTagTraversableTemplate $this, ClassTag manifest) {
        return $this.genericClassManifestBuilder(manifest);
    }

    default public <B> Builder<B, CC> genericClassManifestBuilder(ClassTag<B> manifest) {
        return this.genericClassTagBuilder(manifest);
    }

    public static void $init$(GenericClassTagTraversableTemplate $this) {
    }
}

