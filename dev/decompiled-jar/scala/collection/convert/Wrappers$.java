/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.convert;

import scala.Serializable;
import scala.collection.convert.Wrappers;
import scala.collection.convert.Wrappers$DictionaryWrapper$;
import scala.collection.convert.Wrappers$IterableWrapper$;
import scala.collection.convert.Wrappers$IteratorWrapper$;
import scala.collection.convert.Wrappers$JCollectionWrapper$;
import scala.collection.convert.Wrappers$JConcurrentMapWrapper$;
import scala.collection.convert.Wrappers$JDictionaryWrapper$;
import scala.collection.convert.Wrappers$JEnumerationWrapper$;
import scala.collection.convert.Wrappers$JIterableWrapper$;
import scala.collection.convert.Wrappers$JIteratorWrapper$;
import scala.collection.convert.Wrappers$JListWrapper$;
import scala.collection.convert.Wrappers$JMapWrapper$;
import scala.collection.convert.Wrappers$JPropertiesWrapper$;
import scala.collection.convert.Wrappers$JSetWrapper$;
import scala.collection.convert.Wrappers$MutableBufferWrapper$;
import scala.collection.convert.Wrappers$MutableMapWrapper$;
import scala.collection.convert.Wrappers$MutableSeqWrapper$;
import scala.collection.convert.Wrappers$MutableSetWrapper$;
import scala.collection.convert.Wrappers$SeqWrapper$;

public final class Wrappers$
implements Wrappers,
Serializable {
    public static Wrappers$ MODULE$;
    public static final long serialVersionUID = -5857859809262781311L;
    private volatile Wrappers$IteratorWrapper$ IteratorWrapper$module;
    private volatile Wrappers$JIteratorWrapper$ JIteratorWrapper$module;
    private volatile Wrappers$JEnumerationWrapper$ JEnumerationWrapper$module;
    private volatile Wrappers$IterableWrapper$ IterableWrapper$module;
    private volatile Wrappers$JIterableWrapper$ JIterableWrapper$module;
    private volatile Wrappers$JCollectionWrapper$ JCollectionWrapper$module;
    private volatile Wrappers$SeqWrapper$ SeqWrapper$module;
    private volatile Wrappers$MutableSeqWrapper$ MutableSeqWrapper$module;
    private volatile Wrappers$MutableBufferWrapper$ MutableBufferWrapper$module;
    private volatile Wrappers$JListWrapper$ JListWrapper$module;
    private volatile Wrappers$MutableSetWrapper$ MutableSetWrapper$module;
    private volatile Wrappers$JSetWrapper$ JSetWrapper$module;
    private volatile Wrappers$MutableMapWrapper$ MutableMapWrapper$module;
    private volatile Wrappers$JMapWrapper$ JMapWrapper$module;
    private volatile Wrappers$JConcurrentMapWrapper$ JConcurrentMapWrapper$module;
    private volatile Wrappers$DictionaryWrapper$ DictionaryWrapper$module;
    private volatile Wrappers$JDictionaryWrapper$ JDictionaryWrapper$module;
    private volatile Wrappers$JPropertiesWrapper$ JPropertiesWrapper$module;

    static {
        new Wrappers$();
    }

    @Override
    public Wrappers$IteratorWrapper$ IteratorWrapper() {
        if (this.IteratorWrapper$module == null) {
            this.IteratorWrapper$lzycompute$1();
        }
        return this.IteratorWrapper$module;
    }

    @Override
    public Wrappers$JIteratorWrapper$ JIteratorWrapper() {
        if (this.JIteratorWrapper$module == null) {
            this.JIteratorWrapper$lzycompute$1();
        }
        return this.JIteratorWrapper$module;
    }

    @Override
    public Wrappers$JEnumerationWrapper$ JEnumerationWrapper() {
        if (this.JEnumerationWrapper$module == null) {
            this.JEnumerationWrapper$lzycompute$1();
        }
        return this.JEnumerationWrapper$module;
    }

    @Override
    public Wrappers$IterableWrapper$ IterableWrapper() {
        if (this.IterableWrapper$module == null) {
            this.IterableWrapper$lzycompute$1();
        }
        return this.IterableWrapper$module;
    }

    @Override
    public Wrappers$JIterableWrapper$ JIterableWrapper() {
        if (this.JIterableWrapper$module == null) {
            this.JIterableWrapper$lzycompute$1();
        }
        return this.JIterableWrapper$module;
    }

    @Override
    public Wrappers$JCollectionWrapper$ JCollectionWrapper() {
        if (this.JCollectionWrapper$module == null) {
            this.JCollectionWrapper$lzycompute$1();
        }
        return this.JCollectionWrapper$module;
    }

    @Override
    public Wrappers$SeqWrapper$ SeqWrapper() {
        if (this.SeqWrapper$module == null) {
            this.SeqWrapper$lzycompute$1();
        }
        return this.SeqWrapper$module;
    }

    @Override
    public Wrappers$MutableSeqWrapper$ MutableSeqWrapper() {
        if (this.MutableSeqWrapper$module == null) {
            this.MutableSeqWrapper$lzycompute$1();
        }
        return this.MutableSeqWrapper$module;
    }

    @Override
    public Wrappers$MutableBufferWrapper$ MutableBufferWrapper() {
        if (this.MutableBufferWrapper$module == null) {
            this.MutableBufferWrapper$lzycompute$1();
        }
        return this.MutableBufferWrapper$module;
    }

    @Override
    public Wrappers$JListWrapper$ JListWrapper() {
        if (this.JListWrapper$module == null) {
            this.JListWrapper$lzycompute$1();
        }
        return this.JListWrapper$module;
    }

    @Override
    public Wrappers$MutableSetWrapper$ MutableSetWrapper() {
        if (this.MutableSetWrapper$module == null) {
            this.MutableSetWrapper$lzycompute$1();
        }
        return this.MutableSetWrapper$module;
    }

    @Override
    public Wrappers$JSetWrapper$ JSetWrapper() {
        if (this.JSetWrapper$module == null) {
            this.JSetWrapper$lzycompute$1();
        }
        return this.JSetWrapper$module;
    }

    @Override
    public Wrappers$MutableMapWrapper$ MutableMapWrapper() {
        if (this.MutableMapWrapper$module == null) {
            this.MutableMapWrapper$lzycompute$1();
        }
        return this.MutableMapWrapper$module;
    }

    @Override
    public Wrappers$JMapWrapper$ JMapWrapper() {
        if (this.JMapWrapper$module == null) {
            this.JMapWrapper$lzycompute$1();
        }
        return this.JMapWrapper$module;
    }

    @Override
    public Wrappers$JConcurrentMapWrapper$ JConcurrentMapWrapper() {
        if (this.JConcurrentMapWrapper$module == null) {
            this.JConcurrentMapWrapper$lzycompute$1();
        }
        return this.JConcurrentMapWrapper$module;
    }

    @Override
    public Wrappers$DictionaryWrapper$ DictionaryWrapper() {
        if (this.DictionaryWrapper$module == null) {
            this.DictionaryWrapper$lzycompute$1();
        }
        return this.DictionaryWrapper$module;
    }

    @Override
    public Wrappers$JDictionaryWrapper$ JDictionaryWrapper() {
        if (this.JDictionaryWrapper$module == null) {
            this.JDictionaryWrapper$lzycompute$1();
        }
        return this.JDictionaryWrapper$module;
    }

    @Override
    public Wrappers$JPropertiesWrapper$ JPropertiesWrapper() {
        if (this.JPropertiesWrapper$module == null) {
            this.JPropertiesWrapper$lzycompute$1();
        }
        return this.JPropertiesWrapper$module;
    }

    private Object readResolve() {
        return MODULE$;
    }

    private final void IteratorWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.IteratorWrapper$module == null) {
                this.IteratorWrapper$module = new Wrappers$IteratorWrapper$(this);
            }
            return;
        }
    }

    private final void JIteratorWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JIteratorWrapper$module == null) {
                this.JIteratorWrapper$module = new Wrappers$JIteratorWrapper$(this);
            }
            return;
        }
    }

    private final void JEnumerationWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JEnumerationWrapper$module == null) {
                this.JEnumerationWrapper$module = new Wrappers$JEnumerationWrapper$(this);
            }
            return;
        }
    }

    private final void IterableWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.IterableWrapper$module == null) {
                this.IterableWrapper$module = new Wrappers$IterableWrapper$(this);
            }
            return;
        }
    }

    private final void JIterableWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JIterableWrapper$module == null) {
                this.JIterableWrapper$module = new Wrappers$JIterableWrapper$(this);
            }
            return;
        }
    }

    private final void JCollectionWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JCollectionWrapper$module == null) {
                this.JCollectionWrapper$module = new Wrappers$JCollectionWrapper$(this);
            }
            return;
        }
    }

    private final void SeqWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.SeqWrapper$module == null) {
                this.SeqWrapper$module = new Wrappers$SeqWrapper$(this);
            }
            return;
        }
    }

    private final void MutableSeqWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.MutableSeqWrapper$module == null) {
                this.MutableSeqWrapper$module = new Wrappers$MutableSeqWrapper$(this);
            }
            return;
        }
    }

    private final void MutableBufferWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.MutableBufferWrapper$module == null) {
                this.MutableBufferWrapper$module = new Wrappers$MutableBufferWrapper$(this);
            }
            return;
        }
    }

    private final void JListWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JListWrapper$module == null) {
                this.JListWrapper$module = new Wrappers$JListWrapper$(this);
            }
            return;
        }
    }

    private final void MutableSetWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.MutableSetWrapper$module == null) {
                this.MutableSetWrapper$module = new Wrappers$MutableSetWrapper$(this);
            }
            return;
        }
    }

    private final void JSetWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JSetWrapper$module == null) {
                this.JSetWrapper$module = new Wrappers$JSetWrapper$(this);
            }
            return;
        }
    }

    private final void MutableMapWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.MutableMapWrapper$module == null) {
                this.MutableMapWrapper$module = new Wrappers$MutableMapWrapper$(this);
            }
            return;
        }
    }

    private final void JMapWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JMapWrapper$module == null) {
                this.JMapWrapper$module = new Wrappers$JMapWrapper$(this);
            }
            return;
        }
    }

    private final void JConcurrentMapWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JConcurrentMapWrapper$module == null) {
                this.JConcurrentMapWrapper$module = new Wrappers$JConcurrentMapWrapper$(this);
            }
            return;
        }
    }

    private final void DictionaryWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.DictionaryWrapper$module == null) {
                this.DictionaryWrapper$module = new Wrappers$DictionaryWrapper$(this);
            }
            return;
        }
    }

    private final void JDictionaryWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JDictionaryWrapper$module == null) {
                this.JDictionaryWrapper$module = new Wrappers$JDictionaryWrapper$(this);
            }
            return;
        }
    }

    private final void JPropertiesWrapper$lzycompute$1() {
        synchronized (this) {
            if (this.JPropertiesWrapper$module == null) {
                this.JPropertiesWrapper$module = new Wrappers$JPropertiesWrapper$(this);
            }
            return;
        }
    }

    private Wrappers$() {
        MODULE$ = this;
        Wrappers.$init$(this);
    }
}

