/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001Q2Aa\u0001\u0003\u0001\u0013!)a\u0004\u0001C\u0001?!)!\u0005\u0001C!G\t\t\u0012\n\u001a7f'R\fG/Z\"bY2\u0014\u0017mY6\u000b\u0005\u00151\u0011AB2p[6|gNC\u0001\b\u0003\u001d9xn^2iCR\u001c\u0001aE\u0002\u0001\u0015Q\u0001\"a\u0003\n\u000e\u00031Q!!\u0004\b\u0002\u000f\rD\u0017M\u001c8fY*\u0011q\u0002E\u0001\u0006]\u0016$H/\u001f\u0006\u0002#\u0005\u0011\u0011n\\\u0005\u0003'1\u0011Ad\u00115b]:,G.\u00138c_VtG\rS1oI2,'/\u00113baR,'\u000f\u0005\u0002\u001695\taC\u0003\u0002\u00181\u0005a1oY1mC2|wmZ5oO*\u0011\u0011DG\u0001\tif\u0004Xm]1gK*\t1$A\u0002d_6L!!\b\f\u0003\u001bM#(/[2u\u0019><w-\u001b8h\u0003\u0019a\u0014N\\5u}Q\t\u0001\u0005\u0005\u0002\"\u00015\tA!\u0001\nvg\u0016\u0014XI^3oiR\u0013\u0018nZ4fe\u0016$Gc\u0001\u0013+_A\u0011Q\u0005K\u0007\u0002M)\tq%A\u0003tG\u0006d\u0017-\u0003\u0002*M\t!QK\\5u\u0011\u0015Y#\u00011\u0001-\u0003\r\u0019G\u000f\u001f\t\u0003\u00175J!A\f\u0007\u0003+\rC\u0017M\u001c8fY\"\u000bg\u000e\u001a7fe\u000e{g\u000e^3yi\")\u0001G\u0001a\u0001c\u0005\u0019QM\u001e;\u0011\u0005\u0015\u0012\u0014BA\u001a'\u0005\r\te.\u001f")
public class IdleStateCallback
extends ChannelInboundHandlerAdapter
implements StrictLogging {
    private final Logger logger;

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        Object object;
        Object object2 = evt;
        if (object2 instanceof IdleStateEvent) {
            BoxedUnit boxedUnit;
            IdleStateEvent idleStateEvent = (IdleStateEvent)object2;
            IdleState idleState = idleStateEvent.state();
            String string = ((Object)((Object)IdleState.READER_IDLE)).equals((Object)idleState) ? "reader" : (((Object)((Object)IdleState.WRITER_IDLE)).equals((Object)idleState) ? "writer" : "all");
            String idler = string;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Network state for {} marked as idle!", new Object[]{idler});
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
            object = ctx.close();
        } else {
            object = BoxedUnit.UNIT;
        }
        super.userEventTriggered(ctx, evt);
    }

    public IdleStateCallback() {
        StrictLogging.$init$(this);
    }
}

