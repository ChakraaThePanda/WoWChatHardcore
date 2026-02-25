/*
 * Decompiled with CFR 0.152.
 */
package com.typesafe.scalalogging;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.Logger$;
import org.slf4j.LoggerFactory;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u00052qa\u0001\u0003\u0011\u0002\u0007\u00051\u0002C\u0003\u0013\u0001\u0011\u00051\u0003\u0003\u0005\u0018\u0001!\u0015\r\u0011\"\u0005\u0019\u0005-a\u0015M_=M_\u001e<\u0017N\\4\u000b\u0005\u00151\u0011\u0001D:dC2\fGn\\4hS:<'BA\u0004\t\u0003!!\u0018\u0010]3tC\u001a,'\"A\u0005\u0002\u0007\r|Wn\u0001\u0001\u0014\u0005\u0001a\u0001CA\u0007\u0011\u001b\u0005q!\"A\b\u0002\u000bM\u001c\u0017\r\\1\n\u0005Eq!AB!osJ+g-\u0001\u0004%S:LG\u000f\n\u000b\u0002)A\u0011Q\"F\u0005\u0003-9\u0011A!\u00168ji\u00061An\\4hKJ,\u0012!\u0007\t\u00035mi\u0011\u0001B\u0005\u00039\u0011\u0011a\u0001T8hO\u0016\u0014\bF\u0001\u0002\u001f!\tiq$\u0003\u0002!\u001d\tIAO]1og&,g\u000e\u001e")
public interface LazyLogging {
    public static /* synthetic */ Logger logger$(LazyLogging $this) {
        return $this.logger();
    }

    default public Logger logger() {
        return Logger$.MODULE$.apply(LoggerFactory.getLogger(this.getClass().getName()));
    }

    public static void $init$(LazyLogging $this) {
    }
}

