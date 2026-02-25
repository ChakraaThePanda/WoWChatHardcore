/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.Enumeration;
import scala.Function1;
import scala.Predef$;
import scala.Predef$ArrowAssoc$;
import scala.Serializable;
import scala.Tuple2;
import scala.collection.immutable.Map;
import scala.collection.immutable.StringOps;
import scala.io.Codec$;
import scala.io.Source$;
import scala.runtime.BoxesRunTime;
import wowchat.common.WowChatConfig$;
import wowchat.common.WowExpansion$;

public final class GameResources$ {
    public static GameResources$ MODULE$;
    private Map<Object, String> AREA;
    private Map<Object, String> ACHIEVEMENT;
    private volatile byte bitmap$0;

    static {
        new GameResources$();
    }

    private Map<Object, String> AREA$lzycompute() {
        GameResources$ gameResources$ = this;
        synchronized (gameResources$) {
            if ((byte)(this.bitmap$0 & 1) == 0) {
                boolean bl;
                Enumeration.Value value = WowChatConfig$.MODULE$.getExpansion();
                Enumeration.Value value2 = WowExpansion$.MODULE$.Vanilla();
                Enumeration.Value value3 = value;
                if (!(value2 != null ? !((Object)value2).equals(value3) : value3 != null)) {
                    bl = true;
                } else {
                    Enumeration.Value value4 = WowExpansion$.MODULE$.TBC();
                    Enumeration.Value value5 = value;
                    if (!(value4 != null ? !((Object)value4).equals(value5) : value5 != null)) {
                        bl = true;
                    } else {
                        Enumeration.Value value6 = WowExpansion$.MODULE$.WotLK();
                        Enumeration.Value value7 = value;
                        bl = !(value6 != null ? !((Object)value6).equals(value7) : value7 != null);
                    }
                }
                String string = bl ? "pre_cata_areas.csv" : "post_cata_areas.csv";
                this.AREA = this.readIDNameFile(string);
                this.bitmap$0 = (byte)(this.bitmap$0 | 1);
            }
        }
        return this.AREA;
    }

    public Map<Object, String> AREA() {
        return (byte)(this.bitmap$0 & 1) == 0 ? this.AREA$lzycompute() : this.AREA;
    }

    private Map<Object, String> ACHIEVEMENT$lzycompute() {
        GameResources$ gameResources$ = this;
        synchronized (gameResources$) {
            if ((byte)(this.bitmap$0 & 2) == 0) {
                this.ACHIEVEMENT = this.readIDNameFile("achievements.csv");
                this.bitmap$0 = (byte)(this.bitmap$0 | 2);
            }
        }
        return this.ACHIEVEMENT;
    }

    public Map<Object, String> ACHIEVEMENT() {
        return (byte)(this.bitmap$0 & 2) == 0 ? this.ACHIEVEMENT$lzycompute() : this.ACHIEVEMENT;
    }

    private Map<Object, String> readIDNameFile(String file) {
        return Source$.MODULE$.fromResource(file, Source$.MODULE$.fromResource$default$2(), Codec$.MODULE$.fallbackSystemCodec()).getLines().map((Function1<String, Tuple2> & java.io.Serializable & Serializable)str -> {
            String[] splt = str.split(",", 2);
            return Predef$ArrowAssoc$.MODULE$.$minus$greater$extension(Predef$.MODULE$.ArrowAssoc(BoxesRunTime.boxToInteger(new StringOps(Predef$.MODULE$.augmentString(splt[0])).toInt())), splt[1]);
        }).toMap(Predef$.MODULE$.$conforms());
    }

    private GameResources$() {
        MODULE$ = this;
    }
}

