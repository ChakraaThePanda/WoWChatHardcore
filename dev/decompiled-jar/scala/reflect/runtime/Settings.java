/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import scala.Option;
import scala.collection.immutable.List;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.settings.MutableSettings;

@ScalaSignature(bytes="\u0006\u0001\u00055f!\u0002&L\u00015\u000b\u0006\"\u0002.\u0001\t\u0003afaB0\u0001!\u0003\r\n\u0001\u0019\u0004\u0005S\u0002\u0001!\u000e\u0003\u0005m\u0007\t\u0005\t\u0015!\u0003n\u0011\u0015Q6\u0001\"\u0001q\u000b\u0011\u00198\u0001A7\t\u000fQ\u001c\u0001\u0019!C\tk\"9ao\u0001a\u0001\n#9\bBB?\u0004A\u0003&Q\u000eC\u0003\u007f\u0007\u0011\u0005SOB\u0003\u0000\u0001\u0001\t\t\u0001C\u0005m\u0017\t\u0005\t\u0015!\u0003\u0002\u0004!1!l\u0003C\u0001\u0003\u0013)Qa]\u0006\u0001\u0003\u0007A\u0001\u0002^\u0006A\u0002\u0013E\u0011q\u0002\u0005\tm.\u0001\r\u0011\"\u0005\u0002\u0012!9Qp\u0003Q!\n\u0005\r\u0001B\u0002@\f\t\u0003\nyA\u0002\u0004\u0002\u0016\u0001\u0001\u0011q\u0003\u0005\u000b\u00033\u0019\"\u0011!Q\u0001\n\u0005m\u0001B\u0002.\u0014\t\u0003\ty$B\u0003t'\u0001\tY\u0002\u0003\u0005u'\u0001\u0007I\u0011CA#\u0011!18\u00031A\u0005\u0012\u0005\u001d\u0003bB?\u0014A\u0003&\u00111\u0004\u0005\u0007}N!\t%!\u0012\t\u0013\u0005-\u0003A1A\u0005\u0002\u00055\u0003bBA(\u0001\u0001\u0006I!\u001d\u0005\n\u0003#\u0002!\u0019!C\u0001\u0003\u001bBq!a\u0015\u0001A\u0003%\u0011\u000fC\u0005\u0002V\u0001\u0011\r\u0011\"\u0001\u0002N!9\u0011q\u000b\u0001!\u0002\u0013\t\b\"CA-\u0001\t\u0007I\u0011AA'\u0011\u001d\tY\u0006\u0001Q\u0001\nED\u0011\"!\u0018\u0001\u0005\u0004%\t!!\u0014\t\u000f\u0005}\u0003\u0001)A\u0005c\"I\u0011\u0011\r\u0001C\u0002\u0013\u0005\u0011Q\n\u0005\b\u0003G\u0002\u0001\u0015!\u0003r\u0011%\t)\u0007\u0001b\u0001\n\u0003\ti\u0005C\u0004\u0002h\u0001\u0001\u000b\u0011B9\t\u0013\u0005%\u0004A1A\u0005\u0002\u00055\u0003bBA6\u0001\u0001\u0006I!\u001d\u0005\n\u0003[\u0002!\u0019!C\u0001\u0003\u001bBq!a\u001c\u0001A\u0003%\u0011\u000fC\u0005\u0002r\u0001\u0011\r\u0011\"\u0001\u0002N!9\u00111\u000f\u0001!\u0002\u0013\t\b\"CA;\u0001\t\u0007I\u0011AA'\u0011\u001d\t9\b\u0001Q\u0001\nED\u0011\"!\u001f\u0001\u0005\u0004%\t!!\u0014\t\u000f\u0005m\u0004\u0001)A\u0005c\"I\u0011Q\u0010\u0001C\u0002\u0013\u0005\u0011Q\n\u0005\b\u0003\u007f\u0002\u0001\u0015!\u0003r\u0011%\t\t\t\u0001b\u0001\n\u0003\ti\u0005C\u0004\u0002\u0004\u0002\u0001\u000b\u0011B9\t\u0013\u0005\u0015\u0005A1A\u0005\u0002\u00055\u0003bBAD\u0001\u0001\u0006I!\u001d\u0005\n\u0003\u0013\u0003!\u0019!C\u0001\u0003\u001bBq!a#\u0001A\u0003%\u0011\u000fC\u0005\u0002\u000e\u0002\u0011\r\u0011\"\u0001\u0002N!9\u0011q\u0012\u0001!\u0002\u0013\t\b\"CAI\u0001\t\u0007I\u0011AA'\u0011\u001d\t\u0019\n\u0001Q\u0001\nED\u0011\"!&\u0001\u0005\u0004%\t!!\u0014\t\u000f\u0005]\u0005\u0001)A\u0005c\"I\u0011\u0011\u0014\u0001C\u0002\u0013\u0005\u0011Q\n\u0005\b\u00037\u0003\u0001\u0015!\u0003r\u0011%\ti\n\u0001b\u0001\n\u0003\ty\n\u0003\u0005\u0002\"\u0002\u0001\u000b\u0011BA\u0006\u0011%\t\u0019\u000b\u0001b\u0001\n\u0003\ty\n\u0003\u0005\u0002&\u0002\u0001\u000b\u0011BA\u0006\u0011\u0019\t9\u000b\u0001C\u0001k\"1\u0011\u0011\u0016\u0001\u0005\u0002UDq!a+\u0001\t\u0003yUO\u0001\u0005TKR$\u0018N\\4t\u0015\taU*A\u0004sk:$\u0018.\\3\u000b\u00059{\u0015a\u0002:fM2,7\r\u001e\u0006\u0002!\u0006)1oY1mCN\u0011\u0001A\u0015\t\u0003'bk\u0011\u0001\u0016\u0006\u0003+Z\u000b\u0001b]3ui&twm\u001d\u0006\u0003/6\u000b\u0001\"\u001b8uKJt\u0017\r\\\u0005\u00033R\u0013q\"T;uC\ndWmU3ui&twm]\u0001\u0007y%t\u0017\u000e\u001e \u0004\u0001Q\tQ\f\u0005\u0002_\u00015\t1JA\u0004TKR$\u0018N\\4\u0014\u0007\t\tW\r\u0005\u0002cG6\tq*\u0003\u0002e\u001f\n1\u0011I\\=SK\u001a\u0004\"AZ4\u000e\u0003\u0001I!\u0001\u001b-\u0003\u0019M+G\u000f^5oOZ\u000bG.^3\u0003\u001d\t{w\u000e\\3b]N+G\u000f^5oON\u00191!Y6\u0011\u0005\u0019\u0014\u0011!\u0001=\u0011\u0005\tt\u0017BA8P\u0005\u001d\u0011un\u001c7fC:$\"!\u001d:\u0011\u0005\u0019\u001c\u0001\"\u00027\u0006\u0001\u0004i'!\u0001+\u0002\u0003Y,\u0012!\\\u0001\u0006m~#S-\u001d\u000b\u0003qn\u0004\"AY=\n\u0005i|%\u0001B+oSRDq\u0001 \u0005\u0002\u0002\u0003\u0007Q.A\u0002yIE\n!A\u001e\u0011\u0002\u000bY\fG.^3\u0003\u0015%sGoU3ui&twmE\u0002\fC.\u00042AYA\u0003\u0013\r\t9a\u0014\u0002\u0004\u0013:$H\u0003BA\u0006\u0003\u001b\u0001\"AZ\u0006\t\r1l\u0001\u0019AA\u0002+\t\t\u0019\u0001F\u0002y\u0003'A\u0001\u0002 \t\u0002\u0002\u0003\u0007\u00111\u0001\u0002\u0013\u001bVdG/[*ue&twmU3ui&twmE\u0002\u0014C.\f!\u0001_:\u0011\r\u0005u\u00111EA\u0015\u001d\r\u0011\u0017qD\u0005\u0004\u0003Cy\u0015a\u00029bG.\fw-Z\u0005\u0005\u0003K\t9C\u0001\u0003MSN$(bAA\u0011\u001fB!\u00111FA\u001d\u001d\u0011\ti#!\u000e\u0011\u0007\u0005=r*\u0004\u0002\u00022)\u0019\u00111G.\u0002\rq\u0012xn\u001c;?\u0013\r\t9dT\u0001\u0007!J,G-\u001a4\n\t\u0005m\u0012Q\b\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005]r\n\u0006\u0003\u0002B\u0005\r\u0003C\u00014\u0014\u0011\u001d\tI\"\u0006a\u0001\u00037)\"!a\u0007\u0015\u0007a\fI\u0005\u0003\u0005}1\u0005\u0005\t\u0019AA\u000e\u0003\u0015\t7/\u001f8d+\u0005\t\u0018AB1ts:\u001c\u0007%A\u0007YKb\u0004XM]5nK:$\u0018\r\\\u0001\u000f1\u0016D\b/\u001a:j[\u0016tG/\u00197!\u0003%Af-\u001e7m\u0019V\u00147/\u0001\u0006YMVdG\u000eT;cg\u0002\n\u0011\u0003\u00178p!\u0006$X.\u0019;B]\u0006d\u0017p]5t\u0003IAfn\u001c)bi6\fG/\u00118bYf\u001c\u0018n\u001d\u0011\u0002\u001fM$(/[2u\u0013:4WM]3oG\u0016\f\u0001c\u001d;sS\u000e$\u0018J\u001c4fe\u0016t7-\u001a\u0011\u0002\u0013a\u0003(/\u001b8ua>\u001c\u0018A\u0003-qe&tG\u000f]8tA\u0005I\u0011\f]8tI\u0016\u0014WoZ\u0001\u000b3B|7\u000fZ3ck\u001e\u0004\u0013!C-sC:<W\r]8t\u0003)I&/\u00198hKB|7\u000fI\u0001\u000f3NDwn^:z[><h.\u001a:t\u0003=I6\u000f[8xgflwn\u001e8feN\u0004\u0013!D-tQ><8/_7lS:$7/\u0001\bZg\"|wo]=nW&tGm\u001d\u0011\u0002\u0017\t\u0014X-Y6Ds\u000edWm]\u0001\rEJ,\u0017m[\"zG2,7\u000fI\u0001\u0006I\u0016\u0014WoZ\u0001\u0007I\u0016\u0014Wo\u001a\u0011\u0002\u0013\u0011,g/\u001a7pa\u0016\u0014\u0018A\u00033fm\u0016dw\u000e]3sA\u0005aQ\r\u001f9mC&tG/\u001f9fg\u0006iQ\r\u001f9mC&tG/\u001f9fg\u0002\nqb\u001c<feJLG-Z(cU\u0016\u001cGo]\u0001\u0011_Z,'O]5eK>\u0013'.Z2ug\u0002\n!\u0002\u001d:j]R$\u0018\u0010]3t\u0003-\u0001(/\u001b8uif\u0004Xm\u001d\u0011\u0002\rUt\u0017.]5e\u0003\u001d)h.[9jI\u0002\nqA^3sE>\u001cX-\u0001\u0005wKJ\u0014wn]3!\u0003MI\u0006/\u0019:uS\u0006dWK\\5gS\u000e\fG/[8o\u0003QI\u0006/\u0019:uS\u0006dWK\\5gS\u000e\fG/[8oA\u0005Y\u0011L^5siB\fG/\\1u\u00031If/\u001b:ua\u0006$X.\u0019;!\u0003)I&/Z2veNLwN\\\u000b\u0003\u0003\u0017\t1\"\u0017:fGV\u00148/[8oA\u0005\u0001R.\u0019=DY\u0006\u001c8OZ5mK:\u000bW.Z\u0001\u0012[\u0006D8\t\\1tg\u001aLG.\u001a(b[\u0016\u0004\u0013AC5t'\u000e\fG.\u0019\u001a2c\u0005Q\u0011n]*dC2\f''\r\u001a\u0002\u0015%\u001c8kY1mCJ\n4\u0007")
public class Settings
extends MutableSettings {
    private final BooleanSetting async = new BooleanSetting(false);
    private final BooleanSetting Xexperimental = new BooleanSetting(false);
    private final BooleanSetting XfullLubs = new BooleanSetting(false);
    private final BooleanSetting XnoPatmatAnalysis = new BooleanSetting(false);
    private final BooleanSetting strictInference = new BooleanSetting(false);
    private final BooleanSetting Xprintpos = new BooleanSetting(false);
    private final BooleanSetting Yposdebug = new BooleanSetting(false);
    private final BooleanSetting Yrangepos = new BooleanSetting(false);
    private final BooleanSetting Yshowsymowners = new BooleanSetting(false);
    private final BooleanSetting Yshowsymkinds = new BooleanSetting(false);
    private final BooleanSetting breakCycles = new BooleanSetting(false);
    private final BooleanSetting debug = new BooleanSetting(false);
    private final BooleanSetting developer = new BooleanSetting(false);
    private final BooleanSetting explaintypes = new BooleanSetting(false);
    private final BooleanSetting overrideObjects = new BooleanSetting(false);
    private final BooleanSetting printtypes = new BooleanSetting(false);
    private final BooleanSetting uniqid = new BooleanSetting(false);
    private final BooleanSetting verbose = new BooleanSetting(false);
    private final BooleanSetting YpartialUnification = new BooleanSetting(false);
    private final BooleanSetting Yvirtpatmat = new BooleanSetting(false);
    private final IntSetting Yrecursion = new IntSetting(0);
    private final IntSetting maxClassfileName = new IntSetting(255);

    @Override
    public BooleanSetting async() {
        return this.async;
    }

    @Override
    public BooleanSetting Xexperimental() {
        return this.Xexperimental;
    }

    @Override
    public BooleanSetting XfullLubs() {
        return this.XfullLubs;
    }

    @Override
    public BooleanSetting XnoPatmatAnalysis() {
        return this.XnoPatmatAnalysis;
    }

    @Override
    public BooleanSetting strictInference() {
        return this.strictInference;
    }

    @Override
    public BooleanSetting Xprintpos() {
        return this.Xprintpos;
    }

    @Override
    public BooleanSetting Yposdebug() {
        return this.Yposdebug;
    }

    @Override
    public BooleanSetting Yrangepos() {
        return this.Yrangepos;
    }

    @Override
    public BooleanSetting Yshowsymowners() {
        return this.Yshowsymowners;
    }

    @Override
    public BooleanSetting Yshowsymkinds() {
        return this.Yshowsymkinds;
    }

    @Override
    public BooleanSetting breakCycles() {
        return this.breakCycles;
    }

    @Override
    public BooleanSetting debug() {
        return this.debug;
    }

    @Override
    public BooleanSetting developer() {
        return this.developer;
    }

    @Override
    public BooleanSetting explaintypes() {
        return this.explaintypes;
    }

    @Override
    public BooleanSetting overrideObjects() {
        return this.overrideObjects;
    }

    @Override
    public BooleanSetting printtypes() {
        return this.printtypes;
    }

    @Override
    public BooleanSetting uniqid() {
        return this.uniqid;
    }

    @Override
    public BooleanSetting verbose() {
        return this.verbose;
    }

    @Override
    public BooleanSetting YpartialUnification() {
        return this.YpartialUnification;
    }

    @Override
    public BooleanSetting Yvirtpatmat() {
        return this.Yvirtpatmat;
    }

    @Override
    public IntSetting Yrecursion() {
        return this.Yrecursion;
    }

    @Override
    public IntSetting maxClassfileName() {
        return this.maxClassfileName;
    }

    @Override
    public boolean isScala211() {
        return true;
    }

    @Override
    public boolean isScala212() {
        return true;
    }

    @Override
    public boolean isScala213() {
        return false;
    }

    public class BooleanSetting
    implements Setting {
        private boolean v;
        private boolean setByUser;

        @Override
        public void postSetHook() {
            MutableSettings.SettingValue.postSetHook$(this);
        }

        @Override
        public boolean isDefault() {
            return MutableSettings.SettingValue.isDefault$(this);
        }

        @Override
        public boolean isSetByUser() {
            return MutableSettings.SettingValue.isSetByUser$(this);
        }

        @Override
        public void value_$eq(Object arg) {
            MutableSettings.SettingValue.value_$eq$(this, arg);
        }

        @Override
        public Option<Object> valueSetByUser() {
            return MutableSettings.SettingValue.valueSetByUser$(this);
        }

        @Override
        public boolean setByUser() {
            return this.setByUser;
        }

        @Override
        public void setByUser_$eq(boolean x$1) {
            this.setByUser = x$1;
        }

        public boolean v() {
            return this.v;
        }

        public void v_$eq(boolean x$1) {
            this.v = x$1;
        }

        public boolean value() {
            return this.v();
        }

        public /* synthetic */ Settings scala$reflect$runtime$Settings$BooleanSetting$$$outer() {
            return Settings.this;
        }

        @Override
        public /* synthetic */ MutableSettings scala$reflect$internal$settings$MutableSettings$SettingValue$$$outer() {
            return this.scala$reflect$runtime$Settings$BooleanSetting$$$outer();
        }

        public BooleanSetting(boolean x) {
            if (Settings.this == null) {
                throw null;
            }
            MutableSettings.SettingValue.$init$(this);
            this.v = x;
        }
    }

    public class IntSetting
    implements Setting {
        private int v;
        private boolean setByUser;

        @Override
        public void postSetHook() {
            MutableSettings.SettingValue.postSetHook$(this);
        }

        @Override
        public boolean isDefault() {
            return MutableSettings.SettingValue.isDefault$(this);
        }

        @Override
        public boolean isSetByUser() {
            return MutableSettings.SettingValue.isSetByUser$(this);
        }

        @Override
        public void value_$eq(Object arg) {
            MutableSettings.SettingValue.value_$eq$(this, arg);
        }

        @Override
        public Option<Object> valueSetByUser() {
            return MutableSettings.SettingValue.valueSetByUser$(this);
        }

        @Override
        public boolean setByUser() {
            return this.setByUser;
        }

        @Override
        public void setByUser_$eq(boolean x$1) {
            this.setByUser = x$1;
        }

        public int v() {
            return this.v;
        }

        public void v_$eq(int x$1) {
            this.v = x$1;
        }

        public int value() {
            return this.v();
        }

        public /* synthetic */ Settings scala$reflect$runtime$Settings$IntSetting$$$outer() {
            return Settings.this;
        }

        @Override
        public /* synthetic */ MutableSettings scala$reflect$internal$settings$MutableSettings$SettingValue$$$outer() {
            return this.scala$reflect$runtime$Settings$IntSetting$$$outer();
        }

        public IntSetting(int x) {
            if (Settings.this == null) {
                throw null;
            }
            MutableSettings.SettingValue.$init$(this);
            this.v = x;
        }
    }

    public class MultiStringSetting
    implements Setting {
        private List<String> v;
        private boolean setByUser;

        @Override
        public void postSetHook() {
            MutableSettings.SettingValue.postSetHook$(this);
        }

        @Override
        public boolean isDefault() {
            return MutableSettings.SettingValue.isDefault$(this);
        }

        @Override
        public boolean isSetByUser() {
            return MutableSettings.SettingValue.isSetByUser$(this);
        }

        @Override
        public void value_$eq(Object arg) {
            MutableSettings.SettingValue.value_$eq$(this, arg);
        }

        @Override
        public Option<Object> valueSetByUser() {
            return MutableSettings.SettingValue.valueSetByUser$(this);
        }

        @Override
        public boolean setByUser() {
            return this.setByUser;
        }

        @Override
        public void setByUser_$eq(boolean x$1) {
            this.setByUser = x$1;
        }

        @Override
        public List<String> v() {
            return this.v;
        }

        public void v_$eq(List<String> x$1) {
            this.v = x$1;
        }

        @Override
        public List<String> value() {
            return this.v();
        }

        public /* synthetic */ Settings scala$reflect$runtime$Settings$MultiStringSetting$$$outer() {
            return Settings.this;
        }

        @Override
        public /* synthetic */ MutableSettings scala$reflect$internal$settings$MutableSettings$SettingValue$$$outer() {
            return this.scala$reflect$runtime$Settings$MultiStringSetting$$$outer();
        }

        public MultiStringSetting(List<String> xs) {
            if (Settings.this == null) {
                throw null;
            }
            MutableSettings.SettingValue.$init$(this);
            this.v = xs;
        }
    }

    public interface Setting
    extends MutableSettings.SettingValue {
    }
}

