/*
 * Decompiled with CFR 0.152.
 */
package scala.compat;

import scala.compat.Platform$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001\u0005-q!\u0002\b\u0010\u0011\u0003!b!\u0002\f\u0010\u0011\u00039\u0002\"\u0002\u000f\u0002\t\u0003iR\u0001\u0002\u0010\u0002\u0001})AAJ\u0001\u0001O!)A&\u0001C\u0001[!)!)\u0001C\u0001\u0007\")q,\u0001C\u0001A\")q-\u0001C\u0001Q\"9A/\u0001b\u0001\n\u0003)\bB\u0002=\u0002A\u0003%a\u000fC\u0003z\u0003\u0011\u0005!\u0010\u0003\u0004\u0000\u0003\u0011\u0005\u0011\u0011\u0001\u0005\b\u0003\u000b\tA\u0011AA\u0004\u0003!\u0001F.\u0019;g_Jl'B\u0001\t\u0012\u0003\u0019\u0019w.\u001c9bi*\t!#A\u0003tG\u0006d\u0017m\u0001\u0001\u0011\u0005U\tQ\"A\b\u0003\u0011Ac\u0017\r\u001e4pe6\u001c\"!\u0001\r\u0011\u0005eQR\"A\t\n\u0005m\t\"AB!osJ+g-\u0001\u0004=S:LGO\u0010\u000b\u0002)\t\u00112\u000b^1dW>3XM\u001d4m_^,%O]8s!\t\u0001S%D\u0001\"\u0015\t\u00113%\u0001\u0003mC:<'\"\u0001\u0013\u0002\t)\fg/Y\u0005\u0003=\u0005\u0012qdQ8oGV\u0014(/\u001a8u\u001b>$\u0017NZ5dCRLwN\\#yG\u0016\u0004H/[8o!\tA3&D\u0001*\u0015\tQ3%\u0001\u0003vi&d\u0017B\u0001\u0014*\u0003%\t'O]1zG>\u0004\u0018\u0010\u0006\u0004/cMB$\b\u0010\t\u00033=J!\u0001M\t\u0003\tUs\u0017\u000e\u001e\u0005\u0006e\u0015\u0001\r\u0001G\u0001\u0004gJ\u001c\u0007\"\u0002\u001b\u0006\u0001\u0004)\u0014AB:sGB{7\u000f\u0005\u0002\u001am%\u0011q'\u0005\u0002\u0004\u0013:$\b\"B\u001d\u0006\u0001\u0004A\u0012\u0001\u00023fgRDQaO\u0003A\u0002U\nq\u0001Z3tiB{7\u000fC\u0003>\u000b\u0001\u0007Q'\u0001\u0004mK:<G\u000f\u001b\u0015\u0003\u000b}\u0002\"!\u0007!\n\u0005\u0005\u000b\"AB5oY&tW-A\u0006de\u0016\fG/Z!se\u0006LHc\u0001\rE;\")QI\u0002a\u0001\r\u0006IQ\r\\3n\u00072\f7o\u001d\u0019\u0003\u000fR\u00032\u0001S(S\u001d\tIU\n\u0005\u0002K#5\t1J\u0003\u0002M'\u00051AH]8pizJ!AT\t\u0002\rA\u0013X\rZ3g\u0013\t\u0001\u0016KA\u0003DY\u0006\u001c8O\u0003\u0002O#A\u00111\u000b\u0016\u0007\u0001\t%)F)!A\u0001\u0002\u000b\u0005aKA\u0002`IE\n\"a\u0016.\u0011\u0005eA\u0016BA-\u0012\u0005\u001dqu\u000e\u001e5j]\u001e\u0004\"!G.\n\u0005q\u000b\"aA!os\")QH\u0002a\u0001k!\u0012aaP\u0001\u000bCJ\u0014\u0018-_2mK\u0006\u0014HC\u0001\u0018b\u0011\u0015\u0011w\u00011\u0001d\u0003\r\t'O\u001d\t\u00043\u0011,\u0014BA3\u0012\u0005\u0015\t%O]1zQ\t9q(A\bhKR\u001cE.Y:t\r>\u0014h*Y7f)\tIg\u000e\r\u0002kYB\u0019\u0001jT6\u0011\u0005McG!C7\t\u0003\u0003\u0005\tQ!\u0001W\u0005\ryFE\r\u0005\u0006_\"\u0001\r\u0001]\u0001\u0005]\u0006lW\r\u0005\u0002Ic&\u0011!/\u0015\u0002\u0007'R\u0014\u0018N\\4)\u0005!y\u0014aA#P\u0019V\ta\u000f\u0005\u0002!o&\u0011!/I\u0001\u0005\u000b>c\u0005%A\u0006dkJ\u0014XM\u001c;US6,W#A>\u0011\u0005ea\u0018BA?\u0012\u0005\u0011auN\\4)\u0005-y\u0014AD2pY2,7\r^$be\n\fw-\u001a\u000b\u0002]!\u0012AbP\u0001\u0013I\u00164\u0017-\u001e7u\u0007\"\f'o]3u\u001d\u0006lW-F\u0001qQ\tiq\b")
public final class Platform {
    public static String defaultCharsetName() {
        return Platform$.MODULE$.defaultCharsetName();
    }

    public static void collectGarbage() {
        Platform$.MODULE$.collectGarbage();
    }

    public static long currentTime() {
        return Platform$.MODULE$.currentTime();
    }

    public static String EOL() {
        return Platform$.MODULE$.EOL();
    }

    public static Class<?> getClassForName(String string) {
        return Platform$.MODULE$.getClassForName(string);
    }

    public static void arrayclear(int[] nArray) {
        Platform$.MODULE$.arrayclear(nArray);
    }

    public static Object createArray(Class<?> clazz, int n) {
        return Platform$.MODULE$.createArray(clazz, n);
    }

    public static void arraycopy(Object object, int n, Object object2, int n2, int n3) {
        Platform$.MODULE$.arraycopy(object, n, object2, n2, n3);
    }
}

