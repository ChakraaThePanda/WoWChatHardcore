/*
 * Decompiled with CFR 0.152.
 */
package com.vdurmont.emoji;

import com.vdurmont.emoji.Emoji;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class EmojiLoader {
    private EmojiLoader() {
    }

    public static List<Emoji> loadEmojis(InputStream stream) throws IOException {
        JSONArray emojisJSON = new JSONArray(EmojiLoader.inputStreamToString(stream));
        ArrayList<Emoji> emojis = new ArrayList<Emoji>(emojisJSON.length());
        for (int i = 0; i < emojisJSON.length(); ++i) {
            Emoji emoji = EmojiLoader.buildEmojiFromJSON(emojisJSON.getJSONObject(i));
            if (emoji == null) continue;
            emojis.add(emoji);
        }
        return emojis;
    }

    private static String inputStreamToString(InputStream stream) throws IOException {
        String read;
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(stream, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while ((read = br.readLine()) != null) {
            sb.append(read);
        }
        br.close();
        return sb.toString();
    }

    protected static Emoji buildEmojiFromJSON(JSONObject json) throws UnsupportedEncodingException {
        if (!json.has("emoji")) {
            return null;
        }
        byte[] bytes = json.getString("emoji").getBytes("UTF-8");
        String description = null;
        if (json.has("description")) {
            description = json.getString("description");
        }
        boolean supportsFitzpatrick = false;
        if (json.has("supports_fitzpatrick")) {
            supportsFitzpatrick = json.getBoolean("supports_fitzpatrick");
        }
        List<String> aliases = EmojiLoader.jsonArrayToStringList(json.getJSONArray("aliases"));
        List<String> tags = EmojiLoader.jsonArrayToStringList(json.getJSONArray("tags"));
        return new Emoji(description, supportsFitzpatrick, aliases, tags, bytes);
    }

    private static List<String> jsonArrayToStringList(JSONArray array) {
        ArrayList<String> strings = new ArrayList<String>(array.length());
        for (int i = 0; i < array.length(); ++i) {
            strings.add(array.getString(i));
        }
        return strings;
    }
}

