/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.entities.channel;

import java.util.EnumSet;
import java.util.Formatter;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.channel.ChannelFlag;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.detached.IDetachableEntity;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.MiscUtil;

public interface Channel
extends IMentionable,
IDetachableEntity {
    public static final int MAX_NAME_LENGTH = 100;

    @Nonnull
    default public EnumSet<ChannelFlag> getFlags() {
        return EnumSet.noneOf(ChannelFlag.class);
    }

    @Nonnull
    public String getName();

    @Nonnull
    public ChannelType getType();

    @Nonnull
    public JDA getJDA();

    @Nonnull
    @CheckReturnValue
    public RestAction<Void> delete();

    @Override
    @Nonnull
    default public String getAsMention() {
        return "<#" + this.getId() + '>';
    }

    @Override
    default public void formatTo(Formatter formatter, int flags, int width, int precision) {
        boolean alt;
        boolean leftJustified = (flags & 1) == 1;
        boolean upper = (flags & 2) == 2;
        boolean bl = alt = (flags & 4) == 4;
        String out = alt ? "#" + (upper ? this.getName().toUpperCase(formatter.locale()) : this.getName()) : this.getAsMention();
        MiscUtil.appendTo(formatter, width, precision, leftJustified, out);
    }
}

