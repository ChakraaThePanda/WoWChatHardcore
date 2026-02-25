/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Function1;
import scala.Option;
import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.immutable.Map;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;
import wowchat.common.GuildConfig$;
import wowchat.common.GuildNotificationConfig;

@ScalaSignature(bytes="\u0006\u0001\u0005\u001db\u0001B\u000b\u0017\u0001nA\u0001\u0002\u000b\u0001\u0003\u0016\u0004%\t!\u000b\u0005\ty\u0001\u0011\t\u0012)A\u0005U!)Q\b\u0001C\u0001}!9\u0011\tAA\u0001\n\u0003\u0011\u0005b\u0002#\u0001#\u0003%\t!\u0012\u0005\b!\u0002\t\t\u0011\"\u0011R\u0011\u001dI\u0006!!A\u0005\u0002iCqA\u0018\u0001\u0002\u0002\u0013\u0005q\fC\u0004f\u0001\u0005\u0005I\u0011\t4\t\u000f5\u0004\u0011\u0011!C\u0001]\"91\u000fAA\u0001\n\u0003\"\bbB;\u0001\u0003\u0003%\tE\u001e\u0005\bo\u0002\t\t\u0011\"\u0011y\u000f\u001dQh#!A\t\u0002m4q!\u0006\f\u0002\u0002#\u0005A\u0010\u0003\u0004>\u001f\u0011\u0005\u0011q\u0001\u0005\bk>\t\t\u0011\"\u0012w\u0011%\tIaDA\u0001\n\u0003\u000bY\u0001C\u0005\u0002\u0010=\t\t\u0011\"!\u0002\u0012!I\u0011QD\b\u0002\u0002\u0013%\u0011q\u0004\u0002\f\u000fVLG\u000eZ\"p]\u001aLwM\u0003\u0002\u00181\u000511m\\7n_:T\u0011!G\u0001\bo><8\r[1u\u0007\u0001\u0019B\u0001\u0001\u000f#KA\u0011Q\u0004I\u0007\u0002=)\tq$A\u0003tG\u0006d\u0017-\u0003\u0002\"=\t1\u0011I\\=SK\u001a\u0004\"!H\u0012\n\u0005\u0011r\"a\u0002)s_\u0012,8\r\u001e\t\u0003;\u0019J!a\n\u0010\u0003\u0019M+'/[1mSj\f'\r\\3\u0002'9|G/\u001b4jG\u0006$\u0018n\u001c8D_:4\u0017nZ:\u0016\u0003)\u0002Ba\u000b\u001a6q9\u0011A\u0006\r\t\u0003[yi\u0011A\f\u0006\u0003_i\ta\u0001\u0010:p_Rt\u0014BA\u0019\u001f\u0003\u0019\u0001&/\u001a3fM&\u00111\u0007\u000e\u0002\u0004\u001b\u0006\u0004(BA\u0019\u001f!\tYc'\u0003\u00028i\t11\u000b\u001e:j]\u001e\u0004\"!\u000f\u001e\u000e\u0003YI!a\u000f\f\u0003/\u001d+\u0018\u000e\u001c3O_RLg-[2bi&|gnQ8oM&<\u0017\u0001\u00068pi&4\u0017nY1uS>t7i\u001c8gS\u001e\u001c\b%\u0001\u0004=S:LGO\u0010\u000b\u0003\u007f\u0001\u0003\"!\u000f\u0001\t\u000b!\u001a\u0001\u0019\u0001\u0016\u0002\t\r|\u0007/\u001f\u000b\u0003\u007f\rCq\u0001\u000b\u0003\u0011\u0002\u0003\u0007!&\u0001\bd_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0003\u0019S#AK$,\u0003!\u0003\"!\u0013(\u000e\u0003)S!a\u0013'\u0002\u0013Ut7\r[3dW\u0016$'BA'\u001f\u0003)\tgN\\8uCRLwN\\\u0005\u0003\u001f*\u0013\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\t!\u000b\u0005\u0002T16\tAK\u0003\u0002V-\u0006!A.\u00198h\u0015\u00059\u0016\u0001\u00026bm\u0006L!a\u000e+\u0002\u0019A\u0014x\u000eZ;di\u0006\u0013\u0018\u000e^=\u0016\u0003m\u0003\"!\b/\n\u0005us\"aA%oi\u0006q\u0001O]8ek\u000e$X\t\\3nK:$HC\u00011d!\ti\u0012-\u0003\u0002c=\t\u0019\u0011I\\=\t\u000f\u0011D\u0011\u0011!a\u00017\u0006\u0019\u0001\u0010J\u0019\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\u0012a\u001a\t\u0004Q.\u0004W\"A5\u000b\u0005)t\u0012AC2pY2,7\r^5p]&\u0011A.\u001b\u0002\t\u0013R,'/\u0019;pe\u0006A1-\u00198FcV\fG\u000e\u0006\u0002peB\u0011Q\u0004]\u0005\u0003cz\u0011qAQ8pY\u0016\fg\u000eC\u0004e\u0015\u0005\u0005\t\u0019\u00011\u0002\u0011!\f7\u000f[\"pI\u0016$\u0012aW\u0001\ti>\u001cFO]5oOR\t!+\u0001\u0004fcV\fGn\u001d\u000b\u0003_fDq\u0001Z\u0007\u0002\u0002\u0003\u0007\u0001-A\u0006Hk&dGmQ8oM&<\u0007CA\u001d\u0010'\ryQ0\n\t\u0006}\u0006\r!fP\u0007\u0002\u007f*\u0019\u0011\u0011\u0001\u0010\u0002\u000fI,h\u000e^5nK&\u0019\u0011QA@\u0003#\u0005\u00137\u000f\u001e:bGR4UO\\2uS>t\u0017\u0007F\u0001|\u0003\u0015\t\u0007\u000f\u001d7z)\ry\u0014Q\u0002\u0005\u0006QI\u0001\rAK\u0001\bk:\f\u0007\u000f\u001d7z)\u0011\t\u0019\"!\u0007\u0011\tu\t)BK\u0005\u0004\u0003/q\"AB(qi&|g\u000e\u0003\u0005\u0002\u001cM\t\t\u00111\u0001@\u0003\rAH\u0005M\u0001\fe\u0016\fGMU3t_24X\r\u0006\u0002\u0002\"A\u00191+a\t\n\u0007\u0005\u0015BK\u0001\u0004PE*,7\r\u001e")
public class GuildConfig
implements Product,
Serializable {
    private final Map<String, GuildNotificationConfig> notificationConfigs;

    public static Option<Map<String, GuildNotificationConfig>> unapply(GuildConfig guildConfig) {
        return GuildConfig$.MODULE$.unapply(guildConfig);
    }

    public static GuildConfig apply(Map<String, GuildNotificationConfig> map) {
        return GuildConfig$.MODULE$.apply(map);
    }

    public static <A> Function1<Map<String, GuildNotificationConfig>, A> andThen(Function1<GuildConfig, A> function1) {
        return GuildConfig$.MODULE$.andThen(function1);
    }

    public static <A> Function1<A, GuildConfig> compose(Function1<A, Map<String, GuildNotificationConfig>> function1) {
        return GuildConfig$.MODULE$.compose(function1);
    }

    public Map<String, GuildNotificationConfig> notificationConfigs() {
        return this.notificationConfigs;
    }

    public GuildConfig copy(Map<String, GuildNotificationConfig> notificationConfigs) {
        return new GuildConfig(notificationConfigs);
    }

    public Map<String, GuildNotificationConfig> copy$default$1() {
        return this.notificationConfigs();
    }

    @Override
    public String productPrefix() {
        return "GuildConfig";
    }

    @Override
    public int productArity() {
        return 1;
    }

    @Override
    public Object productElement(int x$1) {
        int n = x$1;
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IndexOutOfBoundsException(((Object)BoxesRunTime.boxToInteger(x$1)).toString());
            }
        }
        return this.notificationConfigs();
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof GuildConfig;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    public String toString() {
        return ScalaRunTime$.MODULE$._toString(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean equals(Object x$1) {
        if (this == x$1) return true;
        Object object = x$1;
        if (!(object instanceof GuildConfig)) return false;
        boolean bl = true;
        if (!bl) return false;
        GuildConfig guildConfig = (GuildConfig)x$1;
        Map<String, GuildNotificationConfig> map = this.notificationConfigs();
        Map<String, GuildNotificationConfig> map2 = guildConfig.notificationConfigs();
        if (map == null) {
            if (map2 != null) {
                return false;
            }
        } else if (!map.equals(map2)) return false;
        if (!guildConfig.canEqual(this)) return false;
        return true;
    }

    public GuildConfig(Map<String, GuildNotificationConfig> notificationConfigs) {
        this.notificationConfigs = notificationConfigs;
        Product.$init$(this);
    }
}

