/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.managers;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.emoji.ApplicationEmoji;
import net.dv8tion.jda.api.managers.ApplicationEmojiManager;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.managers.ManagerBase;
import net.dv8tion.jda.internal.utils.Checks;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

public class ApplicationEmojiManagerImpl
extends ManagerBase<ApplicationEmojiManager>
implements ApplicationEmojiManager {
    protected final ApplicationEmoji emoji;
    protected String name;

    public ApplicationEmojiManagerImpl(ApplicationEmoji emoji) {
        super(emoji.getJDA(), Route.Applications.MODIFY_APPLICATION_EMOJI.compile(emoji.getJDA().getSelfUser().getApplicationId(), emoji.getId()));
        this.emoji = emoji;
    }

    @Override
    @NotNull
    public ApplicationEmoji getEmoji() {
        return this.emoji;
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationEmojiManagerImpl reset(long fields) {
        super.reset(fields);
        if ((fields & 1L) == 1L) {
            this.name = null;
        }
        return this;
    }

    @Override
    @Nonnull
    @CheckReturnValue
    public ApplicationEmojiManagerImpl reset(long ... fields) {
        super.reset(fields);
        return this;
    }

    @Override
    @NotNull
    public ApplicationEmojiManager setName(@NotNull String name) {
        Checks.inRange(name, 2, 32, "Emoji name");
        Checks.matches(name, Checks.ALPHANUMERIC_WITH_DASH, "Emoji name");
        this.name = name;
        this.set |= 1L;
        return this;
    }

    @Override
    protected RequestBody finalizeData() {
        DataObject object = DataObject.empty();
        if (this.shouldUpdate(1L)) {
            object.put("name", this.name);
        }
        this.reset();
        return this.getRequestBody(object);
    }
}

