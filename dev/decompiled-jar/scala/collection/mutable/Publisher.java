/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.mutable;

import scala.Function1;
import scala.Serializable;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashSet;
import scala.collection.mutable.MultiMap;
import scala.collection.mutable.Set;
import scala.collection.mutable.Subscriber;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001A4q\u0001E\t\u0011\u0002\u0007\u0005\u0001\u0004C\u0003\u001f\u0001\u0011\u0005q\u0004B\u0003$\u0001\t\u0005A%\u0002\u00033\u0001\u0001\u0019T\u0001\u0002\u001d\u0001\u0001eBqa\u0010\u0001C\u0002\u0013E\u0001\tC\u0004B\u0001\t\u0007I\u0011\u0002\"\t\u000fE\u0003!\u0019!C\u0005%\")a\u000b\u0001C\u0001/\")a\u000b\u0001C\u00015\")a\f\u0001C\u0001?\")\u0011\r\u0001C\u0001E\")A\r\u0001C\u0001K\")q\r\u0001C\u0001?!)\u0001\u000e\u0001C\tS\")A\u000e\u0001C![\nI\u0001+\u001e2mSNDWM\u001d\u0006\u0003%M\tq!\\;uC\ndWM\u0003\u0002\u0015+\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\u000b\u0003Y\tQa]2bY\u0006\u001c\u0001!\u0006\u0002\u001aYM\u0011\u0001A\u0007\t\u00037qi\u0011!F\u0005\u0003;U\u0011a!\u00118z%\u00164\u0017A\u0002\u0013j]&$H\u0005F\u0001!!\tY\u0012%\u0003\u0002#+\t!QK\\5u\u0005\r\u0001VOY\t\u0003K!\u0002\"a\u0007\u0014\n\u0005\u001d*\"a\u0002(pi\"Lgn\u001a\t\u0004S\u0001QS\"A\t\u0011\u0005-bC\u0002\u0001\u0003\u0006[\u0001\u0011\rA\f\u0002\u0004\u000bZ$\u0018CA\u00130!\tY\u0002'\u0003\u00022+\t\u0019\u0011I\\=\u0003\u0007M+(\r\u0005\u0003*i)2\u0014BA\u001b\u0012\u0005)\u0019VOY:de&\u0014WM\u001d\t\u0003o\ti\u0011\u0001\u0001\u0002\u0007\r&dG/\u001a:\u0011\tmQ$\u0006P\u0005\u0003wU\u0011\u0011BR;oGRLwN\\\u0019\u0011\u0005mi\u0014B\u0001 \u0016\u0005\u001d\u0011un\u001c7fC:\fAa]3mMV\ta'A\u0004gS2$XM]:\u0016\u0003\r\u00132\u0001\u0012$O\r\u0011)e\u0001A\"\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\t%:\u0015JS\u0005\u0003\u0011F\u0011q\u0001S1tQ6\u000b\u0007\u000f\u0005\u00028\u0007A\u0019\u0011fS'\n\u00051\u000b\"aA*fiB\u0011q\u0007\u0002\t\u0005S=KU*\u0003\u0002Q#\tAQ*\u001e7uS6\u000b\u0007/A\u0005tkN\u0004XM\u001c3fIV\t1\u000bE\u0002*)&K!!V\t\u0003\u000f!\u000b7\u000f[*fi\u0006I1/\u001e2tGJL'-\u001a\u000b\u0003AaCQ!\u0017\u0005A\u0002%\u000b1a];c)\r\u00013\f\u0018\u0005\u00063&\u0001\r!\u0013\u0005\u0006;&\u0001\r!T\u0001\u0007M&dG/\u001a:\u0002'M,8\u000f]3oIN+(m]2sSB$\u0018n\u001c8\u0015\u0005\u0001\u0002\u0007\"B-\u000b\u0001\u0004I\u0015\u0001F1di&4\u0018\r^3Tk\n\u001c8M]5qi&|g\u000e\u0006\u0002!G\")\u0011l\u0003a\u0001\u0013\u0006\u0011\"/Z7pm\u0016\u001cVOY:de&\u0004H/[8o)\t\u0001c\rC\u0003Z\u0019\u0001\u0007\u0011*A\nsK6|g/Z*vEN\u001c'/\u001b9uS>t7/A\u0004qk\nd\u0017n\u001d5\u0015\u0005\u0001R\u0007\"B6\u000f\u0001\u0004Q\u0013!B3wK:$\u0018AB3rk\u0006d7\u000f\u0006\u0002=]\")qn\u0004a\u0001_\u0005\u0019qN\u00196")
public interface Publisher<Evt> {
    public void scala$collection$mutable$Publisher$_setter_$self_$eq(Publisher var1);

    public void scala$collection$mutable$Publisher$_setter_$scala$collection$mutable$Publisher$$filters_$eq(HashMap<Subscriber<Evt, Publisher>, Set<Function1<Evt, Object>>> var1);

    public void scala$collection$mutable$Publisher$_setter_$scala$collection$mutable$Publisher$$suspended_$eq(HashSet<Subscriber<Evt, Publisher>> var1);

    public Publisher self();

    public HashMap<Subscriber<Evt, Publisher>, Set<Function1<Evt, Object>>> scala$collection$mutable$Publisher$$filters();

    public HashSet<Subscriber<Evt, Publisher>> scala$collection$mutable$Publisher$$suspended();

    public static /* synthetic */ void subscribe$(Publisher $this, Subscriber sub) {
        $this.subscribe(sub);
    }

    default public void subscribe(Subscriber<Evt, Publisher> sub) {
        this.subscribe(sub, (Function1<Object, Object> & java.io.Serializable & Serializable)event -> BoxesRunTime.boxToBoolean(Publisher.$anonfun$subscribe$1(event)));
    }

    public static /* synthetic */ void subscribe$(Publisher $this, Subscriber sub, Function1 filter) {
        $this.subscribe(sub, filter);
    }

    default public void subscribe(Subscriber<Evt, Publisher> sub, Function1<Evt, Object> filter) {
        ((MultiMap)((Object)this.scala$collection$mutable$Publisher$$filters())).addBinding(sub, filter);
    }

    public static /* synthetic */ void suspendSubscription$(Publisher $this, Subscriber sub) {
        $this.suspendSubscription(sub);
    }

    default public void suspendSubscription(Subscriber<Evt, Publisher> sub) {
        this.scala$collection$mutable$Publisher$$suspended().$plus$eq((Object)sub);
    }

    public static /* synthetic */ void activateSubscription$(Publisher $this, Subscriber sub) {
        $this.activateSubscription(sub);
    }

    default public void activateSubscription(Subscriber<Evt, Publisher> sub) {
        this.scala$collection$mutable$Publisher$$suspended().$minus$eq((Object)sub);
    }

    public static /* synthetic */ void removeSubscription$(Publisher $this, Subscriber sub) {
        $this.removeSubscription(sub);
    }

    default public void removeSubscription(Subscriber<Evt, Publisher> sub) {
        this.scala$collection$mutable$Publisher$$filters().$minus$eq((Object)sub);
    }

    public static /* synthetic */ void removeSubscriptions$(Publisher $this) {
        $this.removeSubscriptions();
    }

    default public void removeSubscriptions() {
        this.scala$collection$mutable$Publisher$$filters().clear();
    }

    public static /* synthetic */ void publish$(Publisher $this, Object event) {
        $this.publish(event);
    }

    default public void publish(Evt event) {
        this.scala$collection$mutable$Publisher$$filters().keys().foreach((Function1<Subscriber, Object> & java.io.Serializable & Serializable)sub -> {
            Publisher.$anonfun$publish$1(this, event, sub);
            return BoxedUnit.UNIT;
        });
    }

    public static /* synthetic */ boolean equals$(Publisher $this, Object obj) {
        return $this.equals(obj);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    default public boolean equals(Object obj) {
        if (!(obj instanceof Publisher)) return false;
        Publisher publisher = (Publisher)obj;
        HashMap<Subscriber<Evt, Publisher>, Set<Function1<Evt, Object>>> hashMap = this.scala$collection$mutable$Publisher$$filters();
        HashMap<Subscriber<Evt, Publisher>, Set<Function1<Evt, Object>>> hashMap2 = publisher.scala$collection$mutable$Publisher$$filters();
        if (hashMap == null) {
            if (hashMap2 != null) {
                return false;
            }
        } else if (!((Object)hashMap).equals(hashMap2)) return false;
        HashSet<Subscriber<Evt, Publisher>> hashSet = this.scala$collection$mutable$Publisher$$suspended();
        HashSet<Subscriber<Evt, Publisher>> hashSet2 = publisher.scala$collection$mutable$Publisher$$suspended();
        if (hashSet == null) {
            if (hashSet2 == null) return true;
            return false;
        } else {
            if (!((Object)hashSet).equals(hashSet2)) return false;
            return true;
        }
    }

    public static /* synthetic */ boolean $anonfun$subscribe$1(Object event) {
        return true;
    }

    public static /* synthetic */ boolean $anonfun$publish$2(Object event$1, Function1 p) {
        return BoxesRunTime.unboxToBoolean(p.apply(event$1));
    }

    public static /* synthetic */ void $anonfun$publish$1(Publisher $this, Object event$1, Subscriber sub) {
        if (!$this.scala$collection$mutable$Publisher$$suspended().contains(sub) && ((MultiMap)((Object)$this.scala$collection$mutable$Publisher$$filters())).entryExists(sub, (Function1<Function1, Object> & java.io.Serializable & Serializable)p -> BoxesRunTime.boxToBoolean(Publisher.$anonfun$publish$2(event$1, p)))) {
            sub.notify($this.self(), event$1);
        }
    }

    public static void $init$(Publisher $this) {
        $this.scala$collection$mutable$Publisher$_setter_$self_$eq($this);
        $this.scala$collection$mutable$Publisher$_setter_$scala$collection$mutable$Publisher$$filters_$eq((HashMap)((Object)new MultiMap<Subscriber<Evt, Publisher>, Function1<Evt, Object>>(null){

            public Set<Function1<Evt, Object>> makeSet() {
                return MultiMap.makeSet$(this);
            }

            public MultiMap addBinding(Object key, Object value) {
                return MultiMap.addBinding$(this, key, value);
            }

            public MultiMap removeBinding(Object key, Object value) {
                return MultiMap.removeBinding$(this, key, value);
            }

            public boolean entryExists(Object key, Function1 p) {
                return MultiMap.entryExists$(this, key, p);
            }
            {
                MultiMap.$init$(this);
            }
        }));
        $this.scala$collection$mutable$Publisher$_setter_$scala$collection$mutable$Publisher$$suspended_$eq(new HashSet());
    }
}

