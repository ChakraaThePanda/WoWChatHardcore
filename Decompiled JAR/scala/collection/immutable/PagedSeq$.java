/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import scala.Function1;
import scala.Function3;
import scala.Predef$;
import scala.Serializable;
import scala.collection.Iterator;
import scala.collection.immutable.Iterable;
import scala.collection.immutable.PagedSeq;
import scala.io.Source;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;
import scala.runtime.BooleanRef;
import scala.runtime.BoxesRunTime;
import scala.runtime.ObjectRef;
import scala.runtime.RichInt$;
import scala.runtime.ScalaRunTime$;

public final class PagedSeq$ {
    public static PagedSeq$ MODULE$;

    static {
        new PagedSeq$();
    }

    public final int UndeterminedEnd() {
        return Integer.MAX_VALUE;
    }

    public <T> PagedSeq<T> fromIterator(Iterator<T> source2, ClassTag<T> evidence$1) {
        return new PagedSeq<T>((Function3<Object, Object, Object, Object> & java.io.Serializable & Serializable)(data, start, len) -> BoxesRunTime.boxToInteger(PagedSeq$.$anonfun$fromIterator$1(source2, data, BoxesRunTime.unboxToInt(start), BoxesRunTime.unboxToInt(len))), evidence$1);
    }

    public <T> PagedSeq<T> fromIterable(Iterable<T> source2, ClassTag<T> evidence$2) {
        return this.fromIterator(source2.iterator(), evidence$2);
    }

    public PagedSeq<Object> fromStrings(Iterator<String> source2) {
        ObjectRef<String> current = ObjectRef.create("");
        return new PagedSeq<Object>((Function3<Object, Object, Object, Object>)(Function3<char[], Object, Object, Object> & java.io.Serializable & Serializable)(x$1, x$2, x$3) -> BoxesRunTime.boxToInteger(this.more$1(x$1, BoxesRunTime.unboxToInt(x$2), BoxesRunTime.unboxToInt(x$3), current, source2)), ClassTag$.MODULE$.Char());
    }

    public PagedSeq<Object> fromStrings(Iterable<String> source2) {
        return this.fromStrings(source2.iterator());
    }

    public PagedSeq<Object> fromLines(Iterator<String> source2) {
        BooleanRef isFirst = BooleanRef.create(true);
        return this.fromStrings(source2.map((Function1<String, String> & java.io.Serializable & Serializable)line -> {
            if (isFirst$1.elem) {
                isFirst$1.elem = false;
                return line;
            }
            return new StringBuilder(1).append("\n").append((String)line).toString();
        }));
    }

    public PagedSeq<Object> fromLines(Iterable<String> source2) {
        return this.fromLines(source2.iterator());
    }

    public PagedSeq<Object> fromReader(Reader source2) {
        return new PagedSeq<Object>((Function3<Object, Object, Object, Object>)(Function3<char[], Object, Object, Object> & java.io.Serializable & Serializable)(x$4, x$5, x$6) -> BoxesRunTime.boxToInteger(source2.read(x$4, BoxesRunTime.unboxToInt(x$5), BoxesRunTime.unboxToInt(x$6))), ClassTag$.MODULE$.Char());
    }

    public PagedSeq<Object> fromFile(File source2) {
        return this.fromReader(new FileReader(source2));
    }

    public PagedSeq<Object> fromFile(String source2) {
        return this.fromFile(new File(source2));
    }

    public PagedSeq<Object> fromSource(Source source2) {
        return this.fromLines(source2.getLines());
    }

    public static final /* synthetic */ int $anonfun$fromIterator$1(Iterator source$1, Object data, int start, int len) {
        int i;
        for (i = 0; i < len && source$1.hasNext(); ++i) {
            ScalaRunTime$.MODULE$.array_update(data, start + i, source$1.next());
        }
        if (i == 0) {
            return -1;
        }
        return i;
    }

    private final int more$1(char[] data, int start, int len, ObjectRef current$1, Iterator source$2) {
        while (true) {
            if (((String)current$1.elem).length() != 0) {
                int n = ((String)current$1.elem).length();
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                int cnt = RichInt$.MODULE$.min$extension(n, len);
                ((String)current$1.elem).getChars(0, cnt, data, start);
                current$1.elem = ((String)current$1.elem).substring(cnt);
                if (cnt == len) {
                    return cnt;
                }
                int n2 = this.more$1(data, start + cnt, len - cnt, current$1, source$2);
                if (Predef$.MODULE$ == null) {
                    throw null;
                }
                return RichInt$.MODULE$.max$extension(n2, 0) + cnt;
            }
            if (!source$2.hasNext()) break;
            current$1.elem = (String)source$2.next();
        }
        return -1;
    }

    private PagedSeq$() {
        MODULE$ = this;
    }
}

