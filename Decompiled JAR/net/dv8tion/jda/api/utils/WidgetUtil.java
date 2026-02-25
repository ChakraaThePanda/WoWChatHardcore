/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Widget;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.requests.RestConfig;
import net.dv8tion.jda.api.utils.MiscUtil;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.WidgetImpl;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.Helpers;
import net.dv8tion.jda.internal.utils.IOUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class WidgetUtil {
    public static final String WIDGET_PNG = "https://discord.com/api/v10/guilds/%s/widget.png?style=%s";
    public static final String WIDGET_URL = "https://discord.com/api/v10/guilds/%s/widget.json";
    public static final String WIDGET_HTML = "<iframe src=\"https://discord.com/widget?id=%s&theme=%s\" width=\"%d\" height=\"%d\" allowtransparency=\"true\" frameborder=\"0\"></iframe>";

    @Nonnull
    public static String getWidgetBanner(@Nonnull Guild guild, @Nonnull BannerType type) {
        Checks.notNull(guild, "Guild");
        return WidgetUtil.getWidgetBanner(guild.getId(), type);
    }

    @Nonnull
    public static String getWidgetBanner(@Nonnull String guildId, @Nonnull BannerType type) {
        Checks.notNull(guildId, "GuildId");
        Checks.notNull((Object)type, "BannerType");
        return String.format(WIDGET_PNG, guildId, type.name().toLowerCase());
    }

    @Nonnull
    public static String getPremadeWidgetHtml(@Nonnull Guild guild, @Nonnull WidgetTheme theme, int width, int height) {
        Checks.notNull(guild, "Guild");
        return WidgetUtil.getPremadeWidgetHtml(guild.getId(), theme, width, height);
    }

    @Nonnull
    public static String getPremadeWidgetHtml(@Nonnull String guildId, @Nonnull WidgetTheme theme, int width, int height) {
        Checks.notNull(guildId, "GuildId");
        Checks.notNull((Object)theme, "WidgetTheme");
        Checks.notNegative(width, "Width");
        Checks.notNegative(height, "Height");
        return Helpers.format(WIDGET_HTML, guildId, theme.name().toLowerCase(), width, height);
    }

    @Nullable
    public static Widget getWidget(@Nonnull String guildId) throws RateLimitedException {
        return WidgetUtil.getWidget(MiscUtil.parseSnowflake(guildId));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Nullable
    public static Widget getWidget(long guildId) throws RateLimitedException {
        Checks.notNull(guildId, "GuildId");
        client = new OkHttpClient.Builder().build();
        request = new Request.Builder().url(String.format("https://discord.com/api/v10/guilds/%s/widget.json", new Object[]{guildId})).method("GET", null).header("user-agent", RestConfig.USER_AGENT).header("accept-encoding", "gzip").build();
        try {
            response = client.newCall(request).execute();
            try {
                code = response.code();
                data = IOUtil.getBody(response);
                switch (code) {
                    case 200: {
                        stream = data;
                        try {
                            var9_14 = new WidgetImpl(DataObject.fromJson(stream));
                            if (stream == null) ** GOTO lbl28
                        }
                        catch (Throwable var9_15) {
                            try {
                                if (stream != null) {
                                    try {
                                        stream.close();
                                    }
                                    catch (Throwable var10_16) {
                                        var9_15.addSuppressed(var10_16);
                                    }
                                }
                                throw var9_15;
                            }
                            catch (IOException e) {
                                throw new UncheckedIOException(e);
                            }
                        }
                        stream.close();
lbl28:
                        // 2 sources

                        return var9_14;
                    }
                    case 400: 
                    case 404: {
                        e = null;
                        return e;
                    }
                    case 403: {
                        e = new WidgetImpl(guildId);
                        return e;
                    }
                    case 429: {
                        try {
                            stream = data;
                            try {
                                retryAfter = DataObject.fromJson(stream).getLong("retry_after");
                            }
                            finally {
                                if (stream != null) {
                                    stream.close();
                                }
                            }
                        }
                        catch (Exception e) {
                            retryAfter = 0L;
                        }
                        throw new RateLimitedException("https://discord.com/api/v10/guilds/%s/widget.json", retryAfter);
                    }
                }
                throw new IllegalStateException("An unknown status was returned: " + code + " " + response.message());
            }
            finally {
                if (response != null) {
                    response.close();
                }
            }
        }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static enum BannerType {
        SHIELD,
        BANNER1,
        BANNER2,
        BANNER3,
        BANNER4;

    }

    public static enum WidgetTheme {
        LIGHT,
        DARK;

    }
}

