/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.bootstrap.AbstractBootstrap;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import scala.Enumeration;
import scala.Function0;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Some;
import scala.Unit$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.util.Try$;
import wowchat.common.Global$;
import wowchat.common.IdleStateCallback;
import wowchat.common.WowChatConfig$;
import wowchat.common.WowExpansion$;
import wowchat.realm.RealmConnectionCallback;
import wowchat.realm.RealmPacketDecoder;
import wowchat.realm.RealmPacketEncoder;
import wowchat.realm.RealmPacketHandler;
import wowchat.realm.RealmPacketHandlerTBC;

@ScalaSignature(bytes="\u0006\u0001}2Aa\u0002\u0005\u0001\u001b!Aa\u0004\u0001B\u0001B\u0003%q\u0004C\u0003$\u0001\u0011\u0005A\u0005C\u0004(\u0001\u0001\u0007I\u0011\u0002\u0015\t\u000fU\u0002\u0001\u0019!C\u0005m!1A\b\u0001Q!\n%BQ!\u0010\u0001\u0005\u0002y\u0012aBU3bY6\u001cuN\u001c8fGR|'O\u0003\u0002\n\u0015\u0005)!/Z1m[*\t1\"A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001M\u0019\u0001A\u0004\u000b\u0011\u0005=\u0011R\"\u0001\t\u000b\u0003E\tQa]2bY\u0006L!a\u0005\t\u0003\r\u0005s\u0017PU3g!\t)B$D\u0001\u0017\u0015\t9\u0002$\u0001\u0007tG\u0006d\u0017\r\\8hO&twM\u0003\u0002\u001a5\u0005AA/\u001f9fg\u00064WMC\u0001\u001c\u0003\r\u0019w.\\\u0005\u0003;Y\u0011Qb\u0015;sS\u000e$Hj\\4hS:<\u0017a\u0006:fC2l7i\u001c8oK\u000e$\u0018n\u001c8DC2d'-Y2l!\t\u0001\u0013%D\u0001\t\u0013\t\u0011\u0003BA\fSK\u0006dWnQ8o]\u0016\u001cG/[8o\u0007\u0006dGNY1dW\u00061A(\u001b8jiz\"\"!\n\u0014\u0011\u0005\u0001\u0002\u0001\"\u0002\u0010\u0003\u0001\u0004y\u0012aB2iC:tW\r\\\u000b\u0002SA\u0019qB\u000b\u0017\n\u0005-\u0002\"AB(qi&|g\u000e\u0005\u0002.g5\taF\u0003\u0002(_)\u0011\u0001'M\u0001\u0006]\u0016$H/\u001f\u0006\u0002e\u0005\u0011\u0011n\\\u0005\u0003i9\u0012qa\u00115b]:,G.A\u0006dQ\u0006tg.\u001a7`I\u0015\fHCA\u001c;!\ty\u0001(\u0003\u0002:!\t!QK\\5u\u0011\u001dYD!!AA\u0002%\n1\u0001\u001f\u00132\u0003!\u0019\u0007.\u00198oK2\u0004\u0013aB2p]:,7\r^\u000b\u0002o\u0001")
public class RealmConnector
implements StrictLogging {
    public final RealmConnectionCallback wowchat$realm$RealmConnector$$realmConnectionCallback;
    private Option<Channel> channel;
    private final Logger logger;

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    private Option<Channel> channel() {
        return this.channel;
    }

    private void channel_$eq(Option<Channel> x$1) {
        this.channel = x$1;
    }

    public void connect() {
        BoxedUnit boxedUnit;
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Connecting to realm server {}:{}", new Object[]{Global$.MODULE$.config().wow().realmlist().host(), BoxesRunTime.boxToInteger(Global$.MODULE$.config().wow().realmlist().port())});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        Bootstrap bootstrap = new Bootstrap();
        ((Bootstrap)((AbstractBootstrap)((AbstractBootstrap)((AbstractBootstrap)bootstrap.group(Global$.MODULE$.group())).channel(NioSocketChannel.class)).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, (Integer)Predef$.MODULE$.int2Integer(10000))).option(ChannelOption.SO_KEEPALIVE, (Boolean)Predef$.MODULE$.boolean2Boolean(true))).remoteAddress(new InetSocketAddress(Global$.MODULE$.config().wow().realmlist().host(), Global$.MODULE$.config().wow().realmlist().port())).handler(new ChannelInitializer<SocketChannel>(this){
            private final /* synthetic */ RealmConnector $outer;

            public void initChannel(SocketChannel socketChannel) throws Exception {
                Enumeration.Value value = WowChatConfig$.MODULE$.getExpansion();
                Enumeration.Value value2 = WowExpansion$.MODULE$.Vanilla();
                RealmPacketHandler handler = !(value != null ? !((Object)value).equals(value2) : value2 != null) ? new RealmPacketHandler(this.$outer.wowchat$realm$RealmConnector$$realmConnectionCallback) : new RealmPacketHandlerTBC(this.$outer.wowchat$realm$RealmConnector$$realmConnectionCallback);
                socketChannel.pipeline().addLast(new IdleStateHandler(60, 120, 0), new IdleStateCallback(), new RealmPacketDecoder(), new RealmPacketEncoder(), handler);
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
            }
        });
        this.channel_$eq(new Some<Channel>(bootstrap.connect().addListener((GenericFutureListener<? extends Future<? super Void>>)((GenericFutureListener<Future>)future -> Try$.MODULE$.apply((Function0<Object> & Serializable & scala.Serializable)() -> future.get(10L, TimeUnit.SECONDS)).fold((Function1<Throwable, Object> & Serializable & scala.Serializable)throwable -> {
            RealmConnector.$anonfun$connect$3(this, throwable);
            return BoxedUnit.UNIT;
        }, (Function1<Object, Unit$> & Serializable & scala.Serializable)x$1 -> Unit$.MODULE$))).channel()));
    }

    public static final /* synthetic */ void $anonfun$connect$3(RealmConnector $this, Throwable throwable) {
        BoxedUnit boxedUnit;
        if ($this.logger().underlying().isErrorEnabled()) {
            $this.logger().underlying().error("Failed to connect to realm server! {}", new Object[]{throwable.getMessage()});
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        $this.wowchat$realm$RealmConnector$$realmConnectionCallback.disconnected();
    }

    public RealmConnector(RealmConnectionCallback realmConnectionCallback) {
        this.wowchat$realm$RealmConnector$$realmConnectionCallback = realmConnectionCallback;
        StrictLogging.$init$(this);
        this.channel = None$.MODULE$;
    }
}

