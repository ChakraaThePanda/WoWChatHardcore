/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import scala.Function0;
import scala.Function1;
import scala.Serializable;
import scala.collection.Iterator;
import scala.io.BufferedSource;
import scala.io.Codec;
import scala.reflect.io.Streamable;

public final class Streamable$ {
    public static Streamable$ MODULE$;

    static {
        new Streamable$();
    }

    public <T extends Closeable, U> U closing(T stream, Function1<T, U> f) {
        U u;
        try {
            u = f.apply(stream);
        }
        finally {
            stream.close();
        }
        return u;
    }

    public byte[] bytes(Function0<InputStream> is) {
        return new Streamable.Bytes(is){
            private final Function0 is$1;

            public long length() {
                return Streamable.Bytes.length$(this);
            }

            public BufferedInputStream bufferedInput() {
                return Streamable.Bytes.bufferedInput$(this);
            }

            public Iterator<Object> bytes() {
                return Streamable.Bytes.bytes$(this);
            }

            public Iterator<Object> bytesAsInts() {
                return Streamable.Bytes.bytesAsInts$(this);
            }

            public byte[] toByteArray() {
                return Streamable.Bytes.toByteArray$(this);
            }

            public InputStream inputStream() {
                return (InputStream)this.is$1.apply();
            }
            {
                this.is$1 = is$1;
                Streamable.Bytes.$init$(this);
            }
        }.toByteArray();
    }

    public String slurp(Function0<InputStream> is, Codec codec) {
        return new Streamable.Chars(is){
            private final Function0 is$2;

            public Codec creationCodec() {
                return Streamable.Chars.creationCodec$(this);
            }

            public BufferedSource chars(Codec codec) {
                return Streamable.Chars.chars$(this, codec);
            }

            public Iterator<String> lines() {
                return Streamable.Chars.lines$(this);
            }

            public Iterator<String> lines(Codec codec) {
                return Streamable.Chars.lines$(this, codec);
            }

            public InputStreamReader reader(Codec codec) {
                return Streamable.Chars.reader$(this, codec);
            }

            public BufferedReader bufferedReader() {
                return Streamable.Chars.bufferedReader$(this);
            }

            public BufferedReader bufferedReader(Codec codec) {
                return Streamable.Chars.bufferedReader$(this, codec);
            }

            public <T> T applyReader(Function1<BufferedReader, T> f) {
                return (T)Streamable.Chars.applyReader$(this, f);
            }

            public String slurp() {
                return Streamable.Chars.slurp$(this);
            }

            public String slurp(Codec codec) {
                return Streamable.Chars.slurp$(this, codec);
            }

            public long length() {
                return Streamable.Bytes.length$(this);
            }

            public BufferedInputStream bufferedInput() {
                return Streamable.Bytes.bufferedInput$(this);
            }

            public Iterator<Object> bytes() {
                return Streamable.Bytes.bytes$(this);
            }

            public Iterator<Object> bytesAsInts() {
                return Streamable.Bytes.bytesAsInts$(this);
            }

            public byte[] toByteArray() {
                return Streamable.Bytes.toByteArray$(this);
            }

            public InputStream inputStream() {
                return (InputStream)this.is$2.apply();
            }
            {
                this.is$2 = is$2;
                Streamable.Bytes.$init$(this);
                Streamable.Chars.$init$(this);
            }
        }.slurp(codec);
    }

    public String slurp(URL url, Codec codec) {
        Function0<InputStream> & java.io.Serializable & Serializable slurp_is = (Function0<InputStream> & java.io.Serializable & Serializable)() -> url.openStream();
        return new /* invalid duplicate definition of identical inner class */.slurp(codec);
    }

    private Streamable$() {
        MODULE$ = this;
    }
}

