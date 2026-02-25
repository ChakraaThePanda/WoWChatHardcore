/*
 * Decompiled with CFR 0.152.
 */
package wowchat.realm;

import scala.None$;
import scala.Option;
import scala.Serializable;
import scala.Some;
import scala.Tuple3;
import scala.runtime.AbstractFunction3;
import scala.runtime.BoxesRunTime;
import wowchat.realm.RealmList;

public final class RealmList$
extends AbstractFunction3<String, String, Object, RealmList>
implements Serializable {
    public static RealmList$ MODULE$;

    static {
        new RealmList$();
    }

    @Override
    public final String toString() {
        return "RealmList";
    }

    @Override
    public RealmList apply(String name, String address, byte realmId) {
        return new RealmList(name, address, realmId);
    }

    public Option<Tuple3<String, String, Object>> unapply(RealmList x$0) {
        return x$0 == null ? None$.MODULE$ : new Some<Tuple3<String, String, Byte>>(new Tuple3<String, String, Byte>(x$0.name(), x$0.address(), BoxesRunTime.boxToByte(x$0.realmId())));
    }

    private Object readResolve() {
        return MODULE$;
    }

    private RealmList$() {
        MODULE$ = this;
    }
}

