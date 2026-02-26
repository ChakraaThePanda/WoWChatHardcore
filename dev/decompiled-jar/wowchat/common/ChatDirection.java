/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import scala.Enumeration;
import scala.Enumeration$ValueOrdering$;
import scala.Enumeration$ValueSet$;
import scala.reflect.ScalaSignature;
import wowchat.common.ChatDirection$;

@ScalaSignature(bytes="\u0006\u0001\u001d:QAC\u0006\t\u0002A1QAE\u0006\t\u0002MAQAG\u0001\u0005\u0002m)AAE\u0001\u00019!9\u0001%\u0001b\u0001\n\u0003\t\u0003B\u0002\u0012\u0002A\u0003%A\u0004C\u0004$\u0003\t\u0007I\u0011A\u0011\t\r\u0011\n\u0001\u0015!\u0003\u001d\u0011\u001d)\u0013A1A\u0005\u0002\u0005BaAJ\u0001!\u0002\u0013a\u0012!D\"iCR$\u0015N]3di&|gN\u0003\u0002\r\u001b\u000511m\\7n_:T\u0011AD\u0001\bo><8\r[1u\u0007\u0001\u0001\"!E\u0001\u000e\u0003-\u0011Qb\u00115bi\u0012K'/Z2uS>t7CA\u0001\u0015!\t)\u0002$D\u0001\u0017\u0015\u00059\u0012!B:dC2\f\u0017BA\r\u0017\u0005-)e.^7fe\u0006$\u0018n\u001c8\u0002\rqJg.\u001b;?)\u0005\u0001\u0002CA\u000f\u001f\u001b\u0005\t\u0011BA\u0010\u0019\u0005\u00151\u0016\r\\;f\u0003\u0011\u0011w\u000e\u001e5\u0016\u0003q\tQAY8uQ\u0002\nab^8x?R|w\fZ5tG>\u0014H-A\bx_^|Fo\\0eSN\u001cwN\u001d3!\u00039!\u0017n]2pe\u0012|Fo\\0x_^\fq\u0002Z5tG>\u0014Hm\u0018;p?^|w\u000f\t")
public final class ChatDirection {
    public static Enumeration.Value discord_to_wow() {
        return ChatDirection$.MODULE$.discord_to_wow();
    }

    public static Enumeration.Value wow_to_discord() {
        return ChatDirection$.MODULE$.wow_to_discord();
    }

    public static Enumeration.Value both() {
        return ChatDirection$.MODULE$.both();
    }

    public static Enumeration$ValueSet$ ValueSet() {
        return ChatDirection$.MODULE$.ValueSet();
    }

    public static Enumeration$ValueOrdering$ ValueOrdering() {
        return ChatDirection$.MODULE$.ValueOrdering();
    }

    public static Enumeration.Value withName(String string) {
        return ChatDirection$.MODULE$.withName(string);
    }

    public static Enumeration.Value apply(int n) {
        return ChatDirection$.MODULE$.apply(n);
    }

    public static int maxId() {
        return ChatDirection$.MODULE$.maxId();
    }

    public static Enumeration.ValueSet values() {
        return ChatDirection$.MODULE$.values();
    }

    public static String toString() {
        return ChatDirection$.MODULE$.toString();
    }
}

