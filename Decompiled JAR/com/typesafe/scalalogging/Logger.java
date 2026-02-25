/*
 * Decompiled with CFR 0.152.
 */
package com.typesafe.scalalogging;

import com.typesafe.scalalogging.CanLog;
import com.typesafe.scalalogging.Logger$;
import com.typesafe.scalalogging.LoggerImpl;
import com.typesafe.scalalogging.LoggerTakingImplicit;
import scala.Serializable;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005Us!\u0002\t\u0012\u0011\u0003Ab!\u0002\u000e\u0012\u0011\u0003Y\u0002\"B\u0013\u0002\t\u00031\u0003\"B\u0014\u0002\t\u0003A\u0003\"B!\u0002\t\u0003\u0011\u0005\"B\u0014\u0002\t\u0003I\u0006\"B!\u0002\t\u00039\u0007\"B\u0014\u0002\t\u0003\u0001\b\"B!\u0002\t\u0003Q\bBB\u0014\u0002\t\u0003\t\t\u0002\u0003\u0004B\u0003\u0011\u0005\u00111\u0006\u0005\n\u0003\u0003\n\u0011\u0011!C\u0005\u0003\u00072AAG\t\u0003U!Aa\u0006\u0004BC\u0002\u0013\u0005q\u0006\u0003\u00058\u0019\t\u0005\t\u0015!\u00031\u0011\u0019)C\u0002\"\u0001\u0012q\u00051Aj\\4hKJT!AE\n\u0002\u0019M\u001c\u0017\r\\1m_\u001e<\u0017N\\4\u000b\u0005Q)\u0012\u0001\u0003;za\u0016\u001c\u0018MZ3\u000b\u0003Y\t1aY8n\u0007\u0001\u0001\"!G\u0001\u000e\u0003E\u0011a\u0001T8hO\u0016\u00148cA\u0001\u001dEA\u0011Q\u0004I\u0007\u0002=)\tq$A\u0003tG\u0006d\u0017-\u0003\u0002\"=\t1\u0011I\\=SK\u001a\u0004\"!H\u0012\n\u0005\u0011r\"\u0001D*fe&\fG.\u001b>bE2,\u0017A\u0002\u001fj]&$h\bF\u0001\u0019\u0003\u0015\t\u0007\u000f\u001d7z)\tI\u0003\t\u0005\u0002\u001a\u0019M\u0019Ab\u000b\u0012\u0011\u0005ea\u0013BA\u0017\u0012\u0005)aunZ4fe&k\u0007\u000f\\\u0001\u000bk:$WM\u001d7zS:<W#\u0001\u0019\u0011\u0005E2T\"\u0001\u001a\u000b\u0005M\"\u0014!B:mMRR'\"A\u001b\u0002\u0007=\u0014x-\u0003\u0002\u001be\u0005YQO\u001c3fe2L\u0018N\\4!)\tI\u0013\bC\u0003/\u001f\u0001\u0007\u0001\u0007\u000b\u0003\rwyz\u0004CA\u000f=\u0013\tidD\u0001\tTKJL\u0017\r\u001c,feNLwN\\+J\t\u0006)a/\u00197vKz!\u0001%\u0006\u0003\"\u0011\u0015q3\u00011\u00011\u00039!\u0018m[5oO&k\u0007\u000f\\5dSR,\"a\u0011&\u0015\u0005\u0011CFCA#T!\rIb\tS\u0005\u0003\u000fF\u0011A\u0003T8hO\u0016\u0014H+Y6j]\u001eLU\u000e\u001d7jG&$\bCA%K\u0019\u0001!Qa\u0013\u0003C\u00021\u0013\u0011!Q\t\u0003\u001bB\u0003\"!\b(\n\u0005=s\"a\u0002(pi\"Lgn\u001a\t\u0003;EK!A\u0015\u0010\u0003\u0007\u0005s\u0017\u0010C\u0003U\t\u0001\u000fQ+\u0001\u0002fmB\u0019\u0011D\u0016%\n\u0005]\u000b\"AB\"b]2{w\rC\u0003/\t\u0001\u0007\u0001\u0007\u0006\u0002*5\")1,\u0002a\u00019\u0006!a.Y7f!\tiFM\u0004\u0002_EB\u0011qLH\u0007\u0002A*\u0011\u0011mF\u0001\u0007yI|w\u000e\u001e \n\u0005\rt\u0012A\u0002)sK\u0012,g-\u0003\u0002fM\n11\u000b\u001e:j]\u001eT!a\u0019\u0010\u0016\u0005!dGCA5p)\tQW\u000eE\u0002\u001a\r.\u0004\"!\u00137\u0005\u000b-3!\u0019\u0001'\t\u000bQ3\u00019\u00018\u0011\u0007e16\u000eC\u0003\\\r\u0001\u0007A\f\u0006\u0002*c\")!o\u0002a\u0001g\u0006)1\r\\1{uB\u0012A\u000f\u001f\t\u0004;V<\u0018B\u0001<g\u0005\u0015\u0019E.Y:t!\tI\u0005\u0010B\u0005zc\u0006\u0005\t\u0011!B\u0001\u0019\n\u0019q\fJ\u0019\u0016\u0005m|Hc\u0001?\u0002\u0006Q\u0019Q0!\u0001\u0011\u0007e1e\u0010\u0005\u0002J\u007f\u0012)1\n\u0003b\u0001\u0019\"1A\u000b\u0003a\u0002\u0003\u0007\u00012!\u0007,\u007f\u0011\u0019\u0011\b\u00021\u0001\u0002\bA\"\u0011\u0011BA\u0007!\u0011iV/a\u0003\u0011\u0007%\u000bi\u0001B\u0006\u0002\u0010\u0005\u0015\u0011\u0011!A\u0001\u0006\u0003a%aA0%eU!\u00111CA\u0014)\rI\u0013Q\u0003\u0005\b\u0003/I\u00019AA\r\u0003\t\u0019G\u000f\u0005\u0004\u0002\u001c\u0005\u0005\u0012QE\u0007\u0003\u0003;Q1!a\b\u001f\u0003\u001d\u0011XM\u001a7fGRLA!a\t\u0002\u001e\tA1\t\\1tgR\u000bw\rE\u0002J\u0003O!a!!\u000b\n\u0005\u0004a%!\u0001+\u0016\r\u00055\u00121HA\u001a)\u0019\ty#!\u000e\u0002>A!\u0011DRA\u0019!\rI\u00151\u0007\u0003\u0006\u0017*\u0011\r\u0001\u0014\u0005\b\u0003/Q\u00019AA\u001c!\u0019\tY\"!\t\u0002:A\u0019\u0011*a\u000f\u0005\r\u0005%\"B1\u0001M\u0011\u0019!&\u0002q\u0001\u0002@A!\u0011DVA\u0019\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0005\u0015\u0003\u0003BA$\u0003#j!!!\u0013\u000b\t\u0005-\u0013QJ\u0001\u0005Y\u0006twM\u0003\u0002\u0002P\u0005!!.\u0019<b\u0013\u0011\t\u0019&!\u0013\u0003\r=\u0013'.Z2u\u0001")
public final class Logger
extends LoggerImpl
implements Serializable {
    public static final long serialVersionUID = 538248225L;
    private final org.slf4j.Logger underlying;

    public static <T, A> LoggerTakingImplicit<A> takingImplicit(ClassTag<T> classTag, CanLog<A> canLog) {
        return Logger$.MODULE$.takingImplicit(classTag, canLog);
    }

    public static <T> Logger apply(ClassTag<T> classTag) {
        return Logger$.MODULE$.apply(classTag);
    }

    public static <A> LoggerTakingImplicit<A> takingImplicit(Class<?> clazz, CanLog<A> canLog) {
        return Logger$.MODULE$.takingImplicit(clazz, canLog);
    }

    public static Logger apply(Class<?> clazz) {
        return Logger$.MODULE$.apply(clazz);
    }

    public static <A> LoggerTakingImplicit<A> takingImplicit(String string, CanLog<A> canLog) {
        return Logger$.MODULE$.takingImplicit(string, canLog);
    }

    public static Logger apply(String string) {
        return Logger$.MODULE$.apply(string);
    }

    public static <A> LoggerTakingImplicit<A> takingImplicit(org.slf4j.Logger logger, CanLog<A> canLog) {
        return Logger$.MODULE$.takingImplicit(logger, canLog);
    }

    public static Logger apply(org.slf4j.Logger logger) {
        return Logger$.MODULE$.apply(logger);
    }

    public org.slf4j.Logger underlying() {
        return this.underlying;
    }

    public Logger(org.slf4j.Logger underlying) {
        this.underlying = underlying;
    }
}

