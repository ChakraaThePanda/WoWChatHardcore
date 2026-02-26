/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal.util;

import scala.Function1;
import scala.Serializable;
import scala.collection.IterableLike;
import scala.collection.Seq;
import scala.reflect.io.AbstractFile;
import scala.runtime.BoxedUnit;
import scala.runtime.NonLocalReturnControl;
import scala.runtime.ObjectRef;

public final class AbstractFileClassLoader$ {
    public static AbstractFileClassLoader$ MODULE$;

    static {
        new AbstractFileClassLoader$();
    }

    public final AbstractFile lookupPath(AbstractFile base, Seq<String> pathParts, boolean directory) {
        Object object = new Object();
        try {
            ObjectRef<AbstractFile> file = ObjectRef.create(base);
            ((IterableLike)pathParts.init()).foreach((Function1<String, Object> & java.io.Serializable & Serializable)dirPart -> {
                AbstractFileClassLoader$.$anonfun$lookupPath$1(file, object, dirPart);
                return BoxedUnit.UNIT;
            });
            return ((AbstractFile)file.elem).lookupName((String)pathParts.last(), directory);
        }
        catch (NonLocalReturnControl ex) {
            if (ex.key() == object) {
                return (AbstractFile)ex.value();
            }
            throw ex;
        }
    }

    public static final /* synthetic */ void $anonfun$lookupPath$1(ObjectRef file$1, Object nonLocalReturnKey1$1, String dirPart) {
        file$1.elem = ((AbstractFile)file$1.elem).lookupName(dirPart, true);
        if ((AbstractFile)file$1.elem == null) {
            throw new NonLocalReturnControl<Object>(nonLocalReturnKey1$1, null);
        }
    }

    private AbstractFileClassLoader$() {
        MODULE$ = this;
    }
}

