/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.requests.restaction;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.annotations.ReplaceWith;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.internal.utils.Checks;

public interface CommandEditAction
extends RestAction<Command> {
    @Nonnull
    @CheckReturnValue
    public CommandEditAction setCheck(@Nullable BooleanSupplier var1);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction addCheck(@Nonnull BooleanSupplier var1);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction timeout(long var1, @Nonnull TimeUnit var3);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction deadline(long var1);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction apply(@Nonnull CommandData var1);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction setName(@Nullable String var1);

    @Nonnull
    @Deprecated
    @ReplaceWith(value="setContexts(InteractionContextType.GUILD)")
    @CheckReturnValue
    public CommandEditAction setGuildOnly(boolean var1);

    @Nonnull
    @CheckReturnValue
    default public CommandEditAction setContexts(InteractionContextType ... contexts) {
        return this.setContexts(Arrays.asList(contexts));
    }

    @Nonnull
    @CheckReturnValue
    public CommandEditAction setContexts(@Nonnull Collection<InteractionContextType> var1);

    @Nonnull
    @CheckReturnValue
    default public CommandEditAction setIntegrationTypes(IntegrationType ... integrationTypes) {
        return this.setIntegrationTypes(Arrays.asList(integrationTypes));
    }

    @Nonnull
    @CheckReturnValue
    public CommandEditAction setIntegrationTypes(@Nonnull Collection<IntegrationType> var1);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction setNSFW(boolean var1);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction setDefaultPermissions(@Nonnull DefaultMemberPermissions var1);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction setDescription(@Nullable String var1);

    @Nonnull
    @CheckReturnValue
    public CommandEditAction clearOptions();

    @Nonnull
    @CheckReturnValue
    public CommandEditAction addOptions(OptionData ... var1);

    @Nonnull
    @CheckReturnValue
    default public CommandEditAction addOptions(@Nonnull Collection<? extends OptionData> options) {
        Checks.noneNull(options, "Options");
        return this.addOptions(options.toArray(new OptionData[0]));
    }

    @Nonnull
    @CheckReturnValue
    default public CommandEditAction addOption(@Nonnull OptionType type, @Nonnull String name, @Nonnull String description, boolean required) {
        return this.addOptions(new OptionData(type, name, description).setRequired(required));
    }

    @Nonnull
    @CheckReturnValue
    default public CommandEditAction addOption(@Nonnull OptionType type, @Nonnull String name, @Nonnull String description) {
        return this.addOption(type, name, description, false);
    }

    @Nonnull
    @CheckReturnValue
    public CommandEditAction addSubcommands(SubcommandData ... var1);

    @Nonnull
    @CheckReturnValue
    default public CommandEditAction addSubcommands(@Nonnull Collection<? extends SubcommandData> subcommands) {
        Checks.noneNull(subcommands, "Subcommands");
        return this.addSubcommands(subcommands.toArray(new SubcommandData[0]));
    }

    @Nonnull
    @CheckReturnValue
    public CommandEditAction addSubcommandGroups(SubcommandGroupData ... var1);

    @Nonnull
    @CheckReturnValue
    default public CommandEditAction addSubcommandGroups(@Nonnull Collection<? extends SubcommandGroupData> groups2) {
        Checks.noneNull(groups2, "SubcommandGroups");
        return this.addSubcommandGroups(groups2.toArray(new SubcommandGroupData[0]));
    }
}

