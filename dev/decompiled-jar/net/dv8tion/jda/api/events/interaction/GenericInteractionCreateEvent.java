/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.events.interaction;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Entitlement;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.IntegrationOwners;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionContextType;

public class GenericInteractionCreateEvent
extends Event
implements Interaction {
    private final Interaction interaction;

    public GenericInteractionCreateEvent(@Nonnull JDA api2, long responseNumber, @Nonnull Interaction interaction) {
        super(api2, responseNumber);
        this.interaction = interaction;
    }

    @Nonnull
    public Interaction getInteraction() {
        return this.interaction;
    }

    @Override
    @Nonnull
    public String getToken() {
        return this.interaction.getToken();
    }

    @Override
    public int getTypeRaw() {
        return this.interaction.getTypeRaw();
    }

    @Override
    @Nullable
    public Guild getGuild() {
        return this.interaction.getGuild();
    }

    @Override
    @Nullable
    public Channel getChannel() {
        return this.interaction.getChannel();
    }

    @Override
    public long getChannelIdLong() {
        return this.interaction.getChannelIdLong();
    }

    @Override
    @Nonnull
    public DiscordLocale getUserLocale() {
        return this.interaction.getUserLocale();
    }

    @Override
    @Nonnull
    public DiscordLocale getGuildLocale() {
        return this.interaction.getGuildLocale();
    }

    @Override
    @Nonnull
    public InteractionContextType getContext() {
        return this.interaction.getContext();
    }

    @Override
    @Nonnull
    public IntegrationOwners getIntegrationOwners() {
        return this.interaction.getIntegrationOwners();
    }

    @Override
    @Nullable
    public Member getMember() {
        return this.interaction.getMember();
    }

    @Override
    @Nonnull
    public User getUser() {
        return this.interaction.getUser();
    }

    @Override
    @Nonnull
    public List<Entitlement> getEntitlements() {
        return this.interaction.getEntitlements();
    }

    @Override
    public long getIdLong() {
        return this.interaction.getIdLong();
    }

    @Override
    public boolean isAcknowledged() {
        return this.interaction.isAcknowledged();
    }
}

