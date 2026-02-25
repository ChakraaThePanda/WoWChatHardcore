/*
 * Decompiled with CFR 0.152.
 */
package scala.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import scala.Function0;
import scala.Predef$;
import scala.Serializable;
import scala.collection.Iterable;
import scala.collection.Iterator;
import scala.io.BufferedSource;
import scala.io.Codec;
import scala.io.Codec$;
import scala.io.Source;
import scala.runtime.BoxedUnit;
import scala.runtime.java8.JFunction0$mcV$sp;

public final class Source$ {
    public static Source$ MODULE$;
    private final int DefaultBufSize;

    static {
        new Source$();
    }

    public int DefaultBufSize() {
        return this.DefaultBufSize;
    }

    public BufferedSource stdin() {
        return this.fromInputStream(System.in, Codec$.MODULE$.fallbackSystemCodec());
    }

    public Source fromIterable(Iterable<Object> iterable) {
        return new Source(iterable){
            private final Iterator<Object> iter;

            public Iterator<Object> iter() {
                return this.iter;
            }
            {
                this.iter = iterable$1.iterator();
            }
        }.withReset((Function0<Source> & java.io.Serializable & Serializable)() -> MODULE$.fromIterable(iterable));
    }

    public Source fromChar(char c) {
        return this.fromIterable(Predef$.MODULE$.wrapCharArray(new char[]{c}));
    }

    public Source fromChars(char[] chars) {
        return this.fromIterable(Predef$.MODULE$.wrapCharArray(chars));
    }

    public Source fromString(String s) {
        return this.fromIterable(Predef$.MODULE$.wrapString(s));
    }

    public BufferedSource fromFile(String name, Codec codec) {
        return this.fromFile(new File(name), codec);
    }

    public BufferedSource fromFile(String name, String enc) {
        return this.fromFile(name, Codec$.MODULE$.apply(enc));
    }

    public BufferedSource fromFile(URI uri, Codec codec) {
        return this.fromFile(new File(uri), codec);
    }

    public BufferedSource fromFile(URI uri, String enc) {
        return this.fromFile(uri, Codec$.MODULE$.apply(enc));
    }

    public BufferedSource fromFile(File file, Codec codec) {
        return this.fromFile(file, this.DefaultBufSize(), codec);
    }

    public BufferedSource fromFile(File file, String enc) {
        return this.fromFile(file, Codec$.MODULE$.apply(enc));
    }

    public BufferedSource fromFile(File file, String enc, int bufferSize) {
        return this.fromFile(file, bufferSize, Codec$.MODULE$.apply(enc));
    }

    /*
     * WARNING - void declaration
     */
    public BufferedSource fromFile(File file, int bufferSize, Codec codec) {
        void createBufferedSource_close;
        FileInputStream inputStream2 = new FileInputStream(file);
        JFunction0$mcV$sp & Serializable intersect = (JFunction0$mcV$sp & Serializable)() -> inputStream2.close();
        Function0<BufferedSource> & java.io.Serializable & Serializable createBufferedSource_reset = (Function0<BufferedSource> & java.io.Serializable & Serializable)() -> MODULE$.fromFile(file, bufferSize, codec);
        Function0<BufferedSource> & java.io.Serializable & Serializable createBufferedSource_resetFn = createBufferedSource_reset == null ? () -> Source$.$anonfun$createBufferedSource$1(inputStream2, bufferSize, null, (Function0)createBufferedSource_close, codec) : createBufferedSource_reset;
        return (BufferedSource)((BufferedSource)new BufferedSource(inputStream2, bufferSize, codec).withReset((Function0<Source>)createBufferedSource_resetFn).withClose((Function0<BoxedUnit>)createBufferedSource_close)).withDescription(new StringBuilder(5).append("file:").append(file.getAbsolutePath()).toString());
    }

    public Source fromBytes(byte[] bytes, Codec codec) {
        return this.fromString(new String(bytes, codec.name()));
    }

    public Source fromBytes(byte[] bytes, String enc) {
        return this.fromBytes(bytes, Codec$.MODULE$.apply(enc));
    }

    public Source fromRawBytes(byte[] bytes) {
        return this.fromString(new String(bytes, Codec$.MODULE$.ISO8859().name()));
    }

    public BufferedSource fromURI(URI uri, Codec codec) {
        return this.fromFile(new File(uri), codec);
    }

    public BufferedSource fromURL(String s, String enc) {
        return this.fromURL(s, Codec$.MODULE$.apply(enc));
    }

    public BufferedSource fromURL(String s, Codec codec) {
        return this.fromURL(new URL(s), codec);
    }

    public BufferedSource fromURL(URL url, String enc) {
        return this.fromURL(url, Codec$.MODULE$.apply(enc));
    }

    public BufferedSource fromURL(URL url, Codec codec) {
        return this.fromInputStream(url.openStream(), codec);
    }

    public BufferedSource createBufferedSource(InputStream inputStream2, int bufferSize, Function0<Source> reset, Function0<BoxedUnit> close, Codec codec) {
        Function0<BufferedSource> & java.io.Serializable & Serializable resetFn = reset == null ? () -> Source$.$anonfun$createBufferedSource$1(inputStream2, bufferSize, null, close, codec) : reset;
        return (BufferedSource)new BufferedSource(inputStream2, bufferSize, codec).withReset((Function0<Source>)resetFn).withClose(close);
    }

    public int createBufferedSource$default$2() {
        return this.DefaultBufSize();
    }

    public Function0<Source> createBufferedSource$default$3() {
        return null;
    }

    public Function0<BoxedUnit> createBufferedSource$default$4() {
        return null;
    }

    public BufferedSource fromInputStream(InputStream is, String enc) {
        return this.fromInputStream(is, Codec$.MODULE$.apply(enc));
    }

    public BufferedSource fromInputStream(InputStream is, Codec codec) {
        Function0<BufferedSource> & java.io.Serializable & Serializable x$2 = (Function0<BufferedSource> & java.io.Serializable & Serializable)() -> MODULE$.fromInputStream(is, codec);
        JFunction0$mcV$sp & Serializable x$3 = (JFunction0$mcV$sp & Serializable)() -> is.close();
        int x$4 = this.createBufferedSource$default$2();
        Function0<BufferedSource> & java.io.Serializable & Serializable createBufferedSource_resetFn = x$2 == null ? () -> Source$.$anonfun$createBufferedSource$1(is, x$4, null, x$3, codec) : x$2;
        return (BufferedSource)new BufferedSource(is, x$4, codec).withReset((Function0<Source>)createBufferedSource_resetFn).withClose(x$3);
    }

    public BufferedSource fromResource(String resource, ClassLoader classLoader, Codec codec) {
        return this.fromInputStream(classLoader.getResourceAsStream(resource), codec);
    }

    public ClassLoader fromResource$default$2() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static final /* synthetic */ BufferedSource $anonfun$createBufferedSource$1(InputStream inputStream$2, int bufferSize$2, Function0 reset$1, Function0 close$1, Codec codec$2) {
        if (MODULE$ == null) {
            throw null;
        }
        Function0<BufferedSource> & java.io.Serializable & Serializable createBufferedSource_resetFn = reset$1 == null ? () -> Source$.$anonfun$createBufferedSource$1(inputStream$2, bufferSize$2, null, close$1, codec$2) : reset$1;
        return (BufferedSource)new BufferedSource(inputStream$2, bufferSize$2, codec$2).withReset((Function0<Source>)createBufferedSource_resetFn).withClose(close$1);
    }

    private Source$() {
        MODULE$ = this;
        this.DefaultBufSize = 2048;
    }
}

