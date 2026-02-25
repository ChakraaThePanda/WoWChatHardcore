/*
 * Decompiled with CFR 0.152.
 */
package com.typesafe.scalalogging;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.Logger$;
import org.slf4j.LoggerFactory;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001u1qa\u0001\u0003\u0011\u0002\u0007\u00051\u0002C\u0003\u0013\u0001\u0011\u00051\u0003C\u0004\u0018\u0001\t\u0007I\u0011\u0003\r\u0003\u001bM#(/[2u\u0019><w-\u001b8h\u0015\t)a!\u0001\u0007tG\u0006d\u0017\r\\8hO&twM\u0003\u0002\b\u0011\u0005AA/\u001f9fg\u00064WMC\u0001\n\u0003\r\u0019w.\\\u0002\u0001'\t\u0001A\u0002\u0005\u0002\u000e!5\taBC\u0001\u0010\u0003\u0015\u00198-\u00197b\u0013\t\tbB\u0001\u0004B]f\u0014VMZ\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0015\u0003Q\u0001\"!D\u000b\n\u0005Yq!\u0001B+oSR\fa\u0001\\8hO\u0016\u0014X#A\r\u0011\u0005iYR\"\u0001\u0003\n\u0005q!!A\u0002'pO\u001e,'\u000f")
public interface StrictLogging {
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger var1);

    public Logger logger();

    public static void $init$(StrictLogging $this) {
        $this.com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger$.MODULE$.apply(LoggerFactory.getLogger($this.getClass().getName())));
    }
}

