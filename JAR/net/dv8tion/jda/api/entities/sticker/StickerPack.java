/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.entities.sticker;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.sticker.StandardSticker;
import net.dv8tion.jda.api.utils.ImageProxy;
import org.jetbrains.annotations.Unmodifiable;

public interface StickerPack
extends ISnowflake {
    public static final String BANNER_URL = "https://cdn.discordapp.com/app-assets/710982414301790216/store/%s.%s";

    @Nonnull
    public @Unmodifiable List<StandardSticker> getStickers();

    @Nonnull
    public String getName();

    @Nonnull
    public String getDescription();

    public long getCoverIdLong();

    @Nullable
    default public String getCoverId() {
        long id = this.getCoverIdLong();
        return id == 0L ? null : Long.toUnsignedString(id);
    }

    @Nullable
    default public StandardSticker getCoverSticker() {
        long id = this.getCoverIdLong();
        if (id == 0L) {
            return null;
        }
        return this.getStickers().stream().filter(s -> s.getIdLong() == id).findFirst().orElse(null);
    }

    public long getBannerIdLong();

    @Nullable
    default public String getBannerId() {
        long id = this.getBannerIdLong();
        return id == 0L ? null : Long.toUnsignedString(id);
    }

    @Nullable
    default public String getBannerUrl() {
        String bannerId = this.getBannerId();
        return bannerId == null ? null : String.format(BANNER_URL, bannerId, "png");
    }

    @Nullable
    default public ImageProxy getBanner() {
        String url = this.getBannerUrl();
        return url == null ? null : new ImageProxy(url);
    }

    public long getSkuIdLong();

    @Nullable
    default public String getSkuId() {
        long id = this.getSkuIdLong();
        return id == 0L ? null : Long.toUnsignedString(id);
    }
}

