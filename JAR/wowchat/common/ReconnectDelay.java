/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001Y2Aa\u0002\u0005\u0001\u001b!)a\u0004\u0001C\u0001?!9!\u0005\u0001a\u0001\n\u0013\u0019\u0003b\u0002\u0016\u0001\u0001\u0004%Ia\u000b\u0005\u0007c\u0001\u0001\u000b\u0015\u0002\u0013\t\u000bI\u0002A\u0011A\u001a\t\u000bQ\u0002A\u0011A\u001b\u0003\u001dI+7m\u001c8oK\u000e$H)\u001a7bs*\u0011\u0011BC\u0001\u0007G>lWn\u001c8\u000b\u0003-\tqa^8xG\"\fGo\u0001\u0001\u0014\u0007\u0001qA\u0003\u0005\u0002\u0010%5\t\u0001CC\u0001\u0012\u0003\u0015\u00198-\u00197b\u0013\t\u0019\u0002C\u0001\u0004B]f\u0014VM\u001a\t\u0003+qi\u0011A\u0006\u0006\u0003/a\tAb]2bY\u0006dwnZ4j]\u001eT!!\u0007\u000e\u0002\u0011QL\b/Z:bM\u0016T\u0011aG\u0001\u0004G>l\u0017BA\u000f\u0017\u00055\u0019FO]5di2{wmZ5oO\u00061A(\u001b8jiz\"\u0012\u0001\t\t\u0003C\u0001i\u0011\u0001C\u0001\u000fe\u0016\u001cwN\u001c8fGR$U\r\\1z+\u0005!\u0003cA\b&O%\u0011a\u0005\u0005\u0002\u0007\u001fB$\u0018n\u001c8\u0011\u0005=A\u0013BA\u0015\u0011\u0005\rIe\u000e^\u0001\u0013e\u0016\u001cwN\u001c8fGR$U\r\\1z?\u0012*\u0017\u000f\u0006\u0002-_A\u0011q\"L\u0005\u0003]A\u0011A!\u00168ji\"9\u0001gAA\u0001\u0002\u0004!\u0013a\u0001=%c\u0005y!/Z2p]:,7\r\u001e#fY\u0006L\b%A\u0003sKN,G/F\u0001-\u0003\u001d9W\r\u001e(fqR,\u0012a\n")
public class ReconnectDelay
implements StrictLogging {
    private Option<Object> reconnectDelay;
    private final Logger logger;

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    private Option<Object> reconnectDelay() {
        return this.reconnectDelay;
    }

    private void reconnectDelay_$eq(Option<Object> x$1) {
        this.reconnectDelay = x$1;
    }

    public void reset() {
        this.reconnectDelay_$eq(None$.MODULE$);
    }

    /*
     * WARNING - void declaration
     */
    public synchronized int getNext() {
        void var1_1;
        BoxedUnit boxedUnit;
        this.reconnectDelay_$eq(new Some<Object>(BoxesRunTime.boxToInteger(10)));
        int result2 = BoxesRunTime.unboxToInt(this.reconnectDelay().get());
        if (this.logger().underlying().isDebugEnabled()) {
            this.logger().underlying().debug("GET RECONNECT DELAY {}", new Object[]{BoxesRunTime.boxToInteger(result2)});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        return (int)var1_1;
    }

    public ReconnectDelay() {
        StrictLogging.$init$(this);
        this.reconnectDelay = None$.MODULE$;
    }
}

