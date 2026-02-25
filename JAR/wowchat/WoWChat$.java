/*
 * Decompiled with CFR 0.152.
 */
package wowchat;

import com.typesafe.scalalogging.Logger;
import com.typesafe.scalalogging.StrictLogging;
import io.netty.channel.nio.NioEventLoopGroup;
import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import scala.Function0;
import scala.Function1;
import scala.Predef$;
import scala.collection.immutable.StringOps;
import scala.collection.mutable.ArrayOps;
import scala.io.Codec$;
import scala.io.Source$;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.sys.package$;
import scala.util.matching.Regex;
import wowchat.WoWChat$;
import wowchat.common.CommonConnectionCallback;
import wowchat.common.Global$;
import wowchat.common.ReconnectDelay;
import wowchat.common.WowChatConfig$;
import wowchat.discord.Discord;
import wowchat.game.GameConnector;
import wowchat.realm.RealmConnectionCallback;
import wowchat.realm.RealmConnector;

public final class WoWChat$
implements StrictLogging {
    public static WoWChat$ MODULE$;
    private final String RELEASE;
    private final Logger logger;

    static {
        new WoWChat$();
    }

    @Override
    public Logger logger() {
        return this.logger;
    }

    @Override
    public void com$typesafe$scalalogging$StrictLogging$_setter_$logger_$eq(Logger x$1) {
        this.logger = x$1;
    }

    private String RELEASE() {
        return this.RELEASE;
    }

    public void main(String[] args2) {
        BoxedUnit boxedUnit;
        BoxedUnit boxedUnit2;
        String string;
        BoxedUnit boxedUnit3;
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Running WoWChat - {}", new Object[]{this.RELEASE()});
            boxedUnit3 = BoxedUnit.UNIT;
        } else {
            boxedUnit3 = BoxedUnit.UNIT;
        }
        if (new ArrayOps.ofRef<Object>(Predef$.MODULE$.refArrayOps((Object[])args2)).nonEmpty()) {
            string = args2[0];
        } else {
            BoxedUnit boxedUnit4;
            if (this.logger().underlying().isInfoEnabled()) {
                this.logger().underlying().info("No configuration file supplied. Trying with default wowchat.conf.");
                boxedUnit4 = BoxedUnit.UNIT;
            } else {
                boxedUnit4 = BoxedUnit.UNIT;
            }
            string = "wowchat.conf";
        }
        String confFile = string;
        Global$.MODULE$.config_$eq(WowChatConfig$.MODULE$.apply(confFile));
        try {
            this.checkForNewVersion();
            boxedUnit2 = BoxedUnit.UNIT;
        }
        catch (Exception e) {
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("Failed to check for a new version!", e);
                boxedUnit2 = BoxedUnit.UNIT;
            }
            boxedUnit2 = BoxedUnit.UNIT;
        }
        CommonConnectionCallback gameConnectionController = new CommonConnectionCallback(){
            private final ScheduledExecutorService reconnectExecutor;
            private final ReconnectDelay reconnectDelay;

            public void reconnected() {
                CommonConnectionCallback.reconnected$(this);
            }

            public void error() {
                CommonConnectionCallback.error$(this);
            }

            private ScheduledExecutorService reconnectExecutor() {
                return this.reconnectExecutor;
            }

            private ReconnectDelay reconnectDelay() {
                return this.reconnectDelay;
            }

            public void connect() {
                Global$.MODULE$.group_$eq(new NioEventLoopGroup());
                RealmConnector realmConnector = new RealmConnector(new RealmConnectionCallback(this){
                    private final /* synthetic */ anon.1 $outer;

                    public void success(String host, int port, String realmName, int realmId, byte[] sessionKey) {
                        this.$outer.wowchat$WoWChat$$anon$$gameConnect(host, port, realmName, realmId, sessionKey);
                    }

                    public void disconnected() {
                        this.$outer.wowchat$WoWChat$$anon$$doReconnect();
                    }

                    public void error() {
                        throw package$.MODULE$.exit(1);
                    }
                    {
                        if ($outer == null) {
                            throw null;
                        }
                        this.$outer = $outer;
                    }
                });
                realmConnector.connect();
            }

            public void wowchat$WoWChat$$anon$$gameConnect(String host, int port, String realmName, int realmId, byte[] sessionKey) {
                new GameConnector(host, port, realmName, realmId, sessionKey, this).connect();
            }

            public void connected() {
                this.reconnectDelay().reset();
            }

            public void disconnected() {
                this.wowchat$WoWChat$$anon$$doReconnect();
            }

            public void wowchat$WoWChat$$anon$$doReconnect() {
                BoxedUnit boxedUnit;
                Global$.MODULE$.group().shutdownGracefully();
                Global$.MODULE$.discord().changeRealmStatus("Connecting...");
                int delay = this.reconnectDelay().getNext();
                if (WoWChat$.MODULE$.logger().underlying().isInfoEnabled()) {
                    WoWChat$.MODULE$.logger().underlying().info("Disconnected from server! Reconnecting in {} seconds...", new Object[]{BoxesRunTime.boxToInteger(delay)});
                    boxedUnit = BoxedUnit.UNIT;
                } else {
                    boxedUnit = BoxedUnit.UNIT;
                }
                this.reconnectExecutor().schedule(new Runnable(this){
                    private final /* synthetic */ anon.1 $outer;

                    public void run() {
                        this.$outer.connect();
                    }
                    {
                        if ($outer == null) {
                            throw null;
                        }
                        this.$outer = $outer;
                    }
                }, (long)delay, TimeUnit.SECONDS);
            }
            {
                CommonConnectionCallback.$init$(this);
                this.reconnectExecutor = Executors.newSingleThreadScheduledExecutor();
                this.reconnectDelay = new ReconnectDelay();
            }
        };
        if (this.logger().underlying().isInfoEnabled()) {
            this.logger().underlying().info("Connecting to Discord...");
            boxedUnit = BoxedUnit.UNIT;
        } else {
            boxedUnit = BoxedUnit.UNIT;
        }
        Global$.MODULE$.discord_$eq(new Discord(new CommonConnectionCallback(gameConnectionController){
            private final CommonConnectionCallback gameConnectionController$1;

            public void connect() {
                CommonConnectionCallback.connect$(this);
            }

            public void reconnected() {
                CommonConnectionCallback.reconnected$(this);
            }

            public void disconnected() {
                CommonConnectionCallback.disconnected$(this);
            }

            public void connected() {
                this.gameConnectionController$1.connect();
            }

            public void error() {
                throw package$.MODULE$.exit(1);
            }
            {
                this.gameConnectionController$1 = gameConnectionController$1;
                CommonConnectionCallback.$init$(this);
            }
        }));
    }

    private void checkForNewVersion() {
        block10: {
            BoxedUnit boxedUnit;
            BoxedUnit boxedUnit2;
            BoxedUnit boxedUnit3;
            BoxedUnit boxedUnit4;
            BoxedUnit boxedUnit5;
            String repoTagName;
            String data = Source$.MODULE$.fromURL("https://api.github.com/repos/fjaros/wowchat/releases/latest", Codec$.MODULE$.fallbackSystemCodec()).mkString();
            Regex regex = new StringOps(Predef$.MODULE$.augmentString("\"tag_name\":\"(.+?)\",")).r();
            String string = repoTagName = (String)regex.findFirstMatchIn(data).map((Function1<Regex.Match, String> & Serializable & scala.Serializable)x$1 -> x$1.group(1)).getOrElse((Function0<String> & Serializable & scala.Serializable)() -> "NOT FOUND");
            String string2 = this.RELEASE();
            if (!(string == null ? string2 != null : !string.equals(string2))) break block10;
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("~~~ !!!                YOUR WoWChat VERSION IS OUT OF DATE                !!! ~~~");
                boxedUnit5 = BoxedUnit.UNIT;
            } else {
                boxedUnit5 = BoxedUnit.UNIT;
            }
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("~~~ !!!                     Current Version:  {}                      !!! ~~~", new Object[]{this.RELEASE()});
                boxedUnit4 = BoxedUnit.UNIT;
            } else {
                boxedUnit4 = BoxedUnit.UNIT;
            }
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("~~~ !!!                     Repo    Version:  {}                      !!! ~~~", new Object[]{repoTagName});
                boxedUnit3 = BoxedUnit.UNIT;
            } else {
                boxedUnit3 = BoxedUnit.UNIT;
            }
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("~~~ !!! RUN git pull OR GO TO https://github.com/fjaros/wowchat TO UPDATE !!! ~~~");
                boxedUnit2 = BoxedUnit.UNIT;
            } else {
                boxedUnit2 = BoxedUnit.UNIT;
            }
            if (this.logger().underlying().isErrorEnabled()) {
                this.logger().underlying().error("~~~ !!!                YOUR WoWChat VERSION IS OUT OF DATE                !!! ~~~");
                boxedUnit = BoxedUnit.UNIT;
            } else {
                boxedUnit = BoxedUnit.UNIT;
            }
        }
    }

    private WoWChat$() {
        MODULE$ = this;
        StrictLogging.$init$(this);
        this.RELEASE = "v1.4.0";
    }
}

