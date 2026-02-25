/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;
import scala.Enumeration$ValueOrdering$;
import scala.Enumeration$ValueSet$;
import scala.reflect.ScalaSignature;
import wowchat.common.Platform$;

@ScalaSignature(bytes="\u0006\u0001Q:Q!\u0003\u0006\t\u0002=1Q!\u0005\u0006\t\u0002IAQ!G\u0001\u0005\u0002i)A!E\u0001\u00017!9q$\u0001b\u0001\n\u0003\u0001\u0003BB\u0011\u0002A\u0003%1\u0004C\u0004#\u0003\t\u0007I\u0011\u0001\u0011\t\r\r\n\u0001\u0015!\u0003\u001c\u0011\u0015!\u0013\u0001\"\u0001&\u0003!\u0001F.\u0019;g_Jl'BA\u0006\r\u0003\u0019\u0019w.\\7p]*\tQ\"A\u0004x_^\u001c\u0007.\u0019;\u0004\u0001A\u0011\u0001#A\u0007\u0002\u0015\tA\u0001\u000b\\1uM>\u0014Xn\u0005\u0002\u0002'A\u0011AcF\u0007\u0002+)\ta#A\u0003tG\u0006d\u0017-\u0003\u0002\u0019+\tYQI\\;nKJ\fG/[8o\u0003\u0019a\u0014N\\5u}Q\tq\u0002\u0005\u0002\u001d;5\t\u0011!\u0003\u0002\u001f/\t)a+\u00197vK\u00069q+\u001b8e_^\u001cX#A\u000e\u0002\u0011]Kg\u000eZ8xg\u0002\n1!T1d\u0003\u0011i\u0015m\u0019\u0011\u0002\u000fY\fG.^3PMR\u0011ae\n\t\u00039\rAQ\u0001\u000b\u0005A\u0002%\n\u0001\u0002\u001d7bi\u001a|'/\u001c\t\u0003UEr!aK\u0018\u0011\u00051*R\"A\u0017\u000b\u00059r\u0011A\u0002\u001fs_>$h(\u0003\u00021+\u00051\u0001K]3eK\u001aL!AM\u001a\u0003\rM#(/\u001b8h\u0015\t\u0001T\u0003")
public final class Platform {
    public static Enumeration.Value valueOf(String string) {
        return Platform$.MODULE$.valueOf(string);
    }

    public static Enumeration.Value Mac() {
        return Platform$.MODULE$.Mac();
    }

    public static Enumeration.Value Windows() {
        return Platform$.MODULE$.Windows();
    }

    public static Enumeration$ValueSet$ ValueSet() {
        return Platform$.MODULE$.ValueSet();
    }

    public static Enumeration$ValueOrdering$ ValueOrdering() {
        return Platform$.MODULE$.ValueOrdering();
    }

    public static Enumeration.Value withName(String string) {
        return Platform$.MODULE$.withName(string);
    }

    public static Enumeration.Value apply(int n) {
        return Platform$.MODULE$.apply(n);
    }

    public static int maxId() {
        return Platform$.MODULE$.maxId();
    }

    public static Enumeration.ValueSet values() {
        return Platform$.MODULE$.values();
    }

    public static String toString() {
        return Platform$.MODULE$.toString();
    }
}

