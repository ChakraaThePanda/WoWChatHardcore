/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities.mixin;

import java.time.OffsetDateTime;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.RoleIcon;
import net.dv8tion.jda.api.requests.restaction.RoleAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.entities.detached.mixin.IDetachableEntityMixin;
import net.dv8tion.jda.internal.utils.Checks;

public interface RoleMixin<T extends RoleMixin<T>>
extends Role,
IDetachableEntityMixin {
    @Override
    @Nonnull
    default public RoleAction createCopy(@Nonnull Guild guild) {
        Checks.notNull(guild, "Guild");
        return guild.createRole().setColor(this.getColorRaw()).setHoisted(this.isHoisted()).setMentionable(this.isMentionable()).setName(this.getName()).setPermissions(this.getPermissionsRaw()).setIcon(this.getIcon() == null ? null : this.getIcon().getEmoji());
    }

    @Override
    default public int compareTo(@Nonnull Role r) {
        if (this == r) {
            return 0;
        }
        if (this.getGuild().getIdLong() != r.getGuild().getIdLong()) {
            throw new IllegalArgumentException("Cannot compare roles that aren't from the same guild!");
        }
        if (this.getPositionRaw() != r.getPositionRaw()) {
            return this.getPositionRaw() - r.getPositionRaw();
        }
        OffsetDateTime thisTime = this.getTimeCreated();
        OffsetDateTime rTime = r.getTimeCreated();
        return rTime.compareTo(thisTime);
    }

    public T setName(String var1);

    public T setColor(int var1);

    public T setManaged(boolean var1);

    public T setHoisted(boolean var1);

    public T setMentionable(boolean var1);

    public T setRawPermissions(long var1);

    public T setRawPosition(int var1);

    public T setTags(DataObject var1);

    public T setIcon(RoleIcon var1);
}

