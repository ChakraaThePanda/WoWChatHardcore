/*
 * Decompiled with CFR 0.152.
 */
package wowchat.game;

import scala.Option;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u0001]2q!\u0002\u0004\u0011\u0002G\u00051\u0002C\u0003\u0013\u0001\u0019\u00051\u0003C\u0003/\u0001\u0019\u0005q\u0006C\u00032\u0001\u0019\u0005!\u0007C\u00036\u0001\u0019\u0005aG\u0001\nHC6,7i\\7nC:$\u0007*\u00198eY\u0016\u0014(BA\u0004\t\u0003\u00119\u0017-\\3\u000b\u0003%\tqa^8xG\"\fGo\u0001\u0001\u0014\u0005\u0001a\u0001CA\u0007\u0011\u001b\u0005q!\"A\b\u0002\u000bM\u001c\u0017\r\\1\n\u0005Eq!AB!osJ+g-\u0001\ttK:$W*Z:tC\u001e,Gk\\,poR!Ac\u0006\u000f*!\tiQ#\u0003\u0002\u0017\u001d\t!QK\\5u\u0011\u0015A\u0012\u00011\u0001\u001a\u0003\t!\b\u000f\u0005\u0002\u000e5%\u00111D\u0004\u0002\u0005\u0005f$X\rC\u0003\u001e\u0003\u0001\u0007a$A\u0004nKN\u001c\u0018mZ3\u0011\u0005}1cB\u0001\u0011%!\t\tc\"D\u0001#\u0015\t\u0019#\"\u0001\u0004=e>|GOP\u0005\u0003K9\ta\u0001\u0015:fI\u00164\u0017BA\u0014)\u0005\u0019\u0019FO]5oO*\u0011QE\u0004\u0005\u0006U\u0005\u0001\raK\u0001\u0007i\u0006\u0014x-\u001a;\u0011\u00075ac$\u0003\u0002.\u001d\t1q\n\u001d;j_:\f\u0001c]3oI:{G/\u001b4jG\u0006$\u0018n\u001c8\u0015\u0005Q\u0001\u0004\"B\u000f\u0003\u0001\u0004q\u0012!\u00035b]\u0012dWm\u00165p)\tY3\u0007C\u00035\u0007\u0001\u00071&A\u0005be\u001e,X.\u001a8ug\u0006Y\u0001.\u00198eY\u0016<Un\u001c;e)\u0005Y\u0003")
public interface GameCommandHandler {
    public void sendMessageToWow(byte var1, String var2, Option<String> var3);

    public void sendNotification(String var1);

    public Option<String> handleWho(Option<String> var1);

    public Option<String> handleGmotd();
}

