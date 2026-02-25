/*
 * Decompiled with CFR 0.152.
 */
package wowchat;

import wowchat.common.CommonConnectionCallback;
import wowchat.common.Global$;
import wowchat.common.WowChatConfig$;
import wowchat.discord.Discord;
import wowchat.discord.GuildOnlineListPublisher;

public final class WoWChat {
    public static void main(String[] stringArray) {
        String string = stringArray != null && stringArray.length > 0 && stringArray[0] != null && !stringArray[0].isEmpty() ? stringArray[0] : "wowchat.conf";
        try {
            System.setProperty("wowchat.configFile", string);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        Global$.MODULE$.config_$eq(WowChatConfig$.MODULE$.apply(string));
        CommonConnectionCallback commonConnectionCallback = (CommonConnectionCallback)WoWChat.newInstance("wowchat.WoWChat$$anon$1");
        CommonConnectionCallback commonConnectionCallback2 = (CommonConnectionCallback)WoWChat.newInstance("wowchat.WoWChat$$anon$4", CommonConnectionCallback.class, commonConnectionCallback);
        Global$.MODULE$.discord_$eq(new Discord(commonConnectionCallback2));
        GuildOnlineListPublisher.init();
    }

    private static Object newInstance(String string, Class<?> clazz, Object object) {
        try {
            Class<?> clazz2 = Class.forName(string);
            return clazz2.getDeclaredConstructor(clazz).newInstance(object);
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to instantiate " + string, throwable);
        }
    }

    private static Object newInstance(String string) {
        try {
            Class<?> clazz = Class.forName(string);
            return clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to instantiate " + string, throwable);
        }
    }
}

