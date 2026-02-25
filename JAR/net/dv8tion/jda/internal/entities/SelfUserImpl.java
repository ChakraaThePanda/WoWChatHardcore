/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.entities;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.managers.AccountManager;
import net.dv8tion.jda.api.requests.restaction.CacheRestAction;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.UserImpl;
import net.dv8tion.jda.internal.managers.AccountManagerImpl;

public class SelfUserImpl
extends UserImpl
implements SelfUser {
    private boolean verified;
    private boolean mfaEnabled;
    private long applicationId;

    public SelfUserImpl(long id, JDAImpl api2) {
        super(id, api2);
        this.applicationId = id;
    }

    @Override
    public boolean hasPrivateChannel() {
        return false;
    }

    @Override
    public PrivateChannel getPrivateChannel() {
        throw new UnsupportedOperationException("You cannot get a PrivateChannel with yourself (SelfUser)");
    }

    @Override
    @Nonnull
    public CacheRestAction<PrivateChannel> openPrivateChannel() {
        throw new UnsupportedOperationException("You cannot open a PrivateChannel with yourself (SelfUser)");
    }

    @Override
    public long getApplicationIdLong() {
        return this.applicationId;
    }

    @Override
    public boolean isVerified() {
        return this.verified;
    }

    @Override
    public boolean isMfaEnabled() {
        return this.mfaEnabled;
    }

    @Override
    public long getAllowedFileSize() {
        return 0xA00000L;
    }

    @Override
    @Nonnull
    public AccountManager getManager() {
        return new AccountManagerImpl(this);
    }

    public SelfUserImpl setVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    public SelfUserImpl setMfaEnabled(boolean enabled) {
        this.mfaEnabled = enabled;
        return this;
    }

    public SelfUserImpl setApplicationId(long id) {
        this.applicationId = id;
        return this;
    }

    public static SelfUserImpl copyOf(SelfUserImpl other, JDAImpl jda) {
        SelfUserImpl selfUser = new SelfUserImpl(other.id, jda);
        selfUser.setName(other.name).setGlobalName(other.globalName).setAvatarId(other.avatarId).setDiscriminator(other.getDiscriminatorInt()).setBot(other.bot);
        return selfUser.setVerified(other.verified).setMfaEnabled(other.mfaEnabled).setApplicationId(other.applicationId);
    }
}

