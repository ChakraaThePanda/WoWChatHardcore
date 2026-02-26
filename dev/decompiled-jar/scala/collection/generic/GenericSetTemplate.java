/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.generic;

import scala.collection.GenSet;
import scala.collection.generic.GenericTraversableTemplate;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001Q2qa\u0001\u0003\u0011\u0002\u0007\u00051\u0002C\u0003-\u0001\u0011\u0005Q\u0006C\u00032\u0001\u0011\u0005!G\u0001\nHK:,'/[2TKR$V-\u001c9mCR,'BA\u0003\u0007\u0003\u001d9WM\\3sS\u000eT!a\u0002\u0005\u0002\u0015\r|G\u000e\\3di&|gNC\u0001\n\u0003\u0015\u00198-\u00197b\u0007\u0001)2\u0001D\f\"'\r\u0001Q\"\u0005\t\u0003\u001d=i\u0011\u0001C\u0005\u0003!!\u0011a!\u00118z%\u00164\u0007\u0003\u0002\n\u0014+\u0001j\u0011\u0001B\u0005\u0003)\u0011\u0011!dR3oKJL7\r\u0016:bm\u0016\u00148/\u00192mKR+W\u000e\u001d7bi\u0016\u0004\"AF\f\r\u0001\u0011)\u0001\u0004\u0001b\u00013\t\t\u0011)\u0005\u0002\u001b;A\u0011abG\u0005\u00039!\u0011qAT8uQ&tw\r\u0005\u0002\u000f=%\u0011q\u0004\u0003\u0002\u0004\u0003:L\bC\u0001\f\"\t\u0019\u0011\u0003\u0001\"b\u0001G\t\u00111iQ\u000b\u0003I)\n\"AG\u0013\u0011\u0007\u0019:\u0013&D\u0001\u0007\u0013\tAcA\u0001\u0004HK:\u001cV\r\u001e\t\u0003-)\"QaK\u0011C\u0002e\u0011\u0011\u0001W\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u00039\u0002\"AD\u0018\n\u0005AB!\u0001B+oSR\fQ!Z7qif,\u0012a\r\t\u0004-\u0005*\u0002")
public interface GenericSetTemplate<A, CC extends GenSet<Object>>
extends GenericTraversableTemplate<A, CC> {
    public static /* synthetic */ GenSet empty$(GenericSetTemplate $this) {
        return $this.empty();
    }

    default public CC empty() {
        return (CC)((GenSet)this.companion().empty());
    }

    public static void $init$(GenericSetTemplate $this) {
    }
}

