/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Unmodifiable
 */
package net.dv8tion.jda.api.interactions.commands.build;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;
import net.dv8tion.jda.api.interactions.commands.localization.LocalizationFunction;
import net.dv8tion.jda.api.interactions.commands.localization.LocalizationMap;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.Helpers;
import net.dv8tion.jda.internal.utils.localization.LocalizationUtils;
import org.jetbrains.annotations.Unmodifiable;

public interface SlashCommandData
extends CommandData {
    @Override
    @Nonnull
    public SlashCommandData setLocalizationFunction(@Nonnull LocalizationFunction var1);

    @Override
    @Nonnull
    public SlashCommandData setName(@Nonnull String var1);

    @Override
    @Nonnull
    public SlashCommandData setNameLocalization(@Nonnull DiscordLocale var1, @Nonnull String var2);

    @Override
    @Nonnull
    public SlashCommandData setNameLocalizations(@Nonnull Map<DiscordLocale, String> var1);

    @Override
    @Nonnull
    public SlashCommandData setDefaultPermissions(@Nonnull DefaultMemberPermissions var1);

    @Override
    @Nonnull
    @Deprecated
    public SlashCommandData setGuildOnly(boolean var1);

    @Override
    @Nonnull
    default public SlashCommandData setContexts(InteractionContextType ... contexts) {
        return (SlashCommandData)CommandData.super.setContexts(contexts);
    }

    @Override
    @Nonnull
    public SlashCommandData setContexts(@Nonnull Collection<InteractionContextType> var1);

    @Override
    @Nonnull
    default public SlashCommandData setIntegrationTypes(IntegrationType ... integrationTypes) {
        return (SlashCommandData)CommandData.super.setIntegrationTypes(integrationTypes);
    }

    @Override
    @Nonnull
    public SlashCommandData setIntegrationTypes(@Nonnull Collection<IntegrationType> var1);

    @Override
    @Nonnull
    public SlashCommandData setNSFW(boolean var1);

    @Nonnull
    public SlashCommandData setDescription(@Nonnull String var1);

    @Nonnull
    public SlashCommandData setDescriptionLocalization(@Nonnull DiscordLocale var1, @Nonnull String var2);

    @Nonnull
    public SlashCommandData setDescriptionLocalizations(@Nonnull Map<DiscordLocale, String> var1);

    @Nonnull
    public String getDescription();

    @Nonnull
    public LocalizationMap getDescriptionLocalizations();

    public boolean removeOptions(@Nonnull Predicate<? super OptionData> var1);

    default public boolean removeOptionByName(@Nonnull String name) {
        return this.removeOptions(option -> option.getName().equals(name));
    }

    public boolean removeSubcommands(@Nonnull Predicate<? super SubcommandData> var1);

    default public boolean removeSubcommandByName(@Nonnull String name) {
        return this.removeSubcommands(subcommand -> subcommand.getName().equals(name));
    }

    public boolean removeSubcommandGroups(@Nonnull Predicate<? super SubcommandGroupData> var1);

    default public boolean removeSubcommandGroupByName(@Nonnull String name) {
        return this.removeSubcommandGroups(group -> group.getName().equals(name));
    }

    @Nonnull
    public @Unmodifiable List<SubcommandData> getSubcommands();

    @Nonnull
    public @Unmodifiable List<SubcommandGroupData> getSubcommandGroups();

    @Nonnull
    public @Unmodifiable List<OptionData> getOptions();

    @Nonnull
    public SlashCommandData addOptions(OptionData ... var1);

    @Nonnull
    default public SlashCommandData addOptions(@Nonnull Collection<? extends OptionData> options) {
        Checks.noneNull(options, "Option");
        return this.addOptions(options.toArray(new OptionData[0]));
    }

    @Nonnull
    default public SlashCommandData addOption(@Nonnull OptionType type, @Nonnull String name, @Nonnull String description, boolean required, boolean autoComplete) {
        return this.addOptions(new OptionData(type, name, description).setRequired(required).setAutoComplete(autoComplete));
    }

    @Nonnull
    default public SlashCommandData addOption(@Nonnull OptionType type, @Nonnull String name, @Nonnull String description, boolean required) {
        return this.addOption(type, name, description, required, false);
    }

    @Nonnull
    default public SlashCommandData addOption(@Nonnull OptionType type, @Nonnull String name, @Nonnull String description) {
        return this.addOption(type, name, description, false);
    }

    @Nonnull
    public SlashCommandData addSubcommands(SubcommandData ... var1);

    @Nonnull
    default public SlashCommandData addSubcommands(@Nonnull Collection<? extends SubcommandData> subcommands) {
        Checks.noneNull(subcommands, "Subcommands");
        return this.addSubcommands(subcommands.toArray(new SubcommandData[0]));
    }

    @Nonnull
    public SlashCommandData addSubcommandGroups(SubcommandGroupData ... var1);

    @Nonnull
    default public SlashCommandData addSubcommandGroups(@Nonnull Collection<? extends SubcommandGroupData> groups2) {
        Checks.noneNull(groups2, "SubcommandGroups");
        return this.addSubcommandGroups(groups2.toArray(new SubcommandGroupData[0]));
    }

    @Nonnull
    public static SlashCommandData fromCommand(@Nonnull Command command) {
        Checks.notNull(command, "Command");
        if (command.getType() != Command.Type.SLASH) {
            throw new IllegalArgumentException("Cannot convert command of type " + (Object)((Object)command.getType()) + " to SlashCommandData!");
        }
        CommandDataImpl data = new CommandDataImpl(command.getName(), command.getDescription());
        data.setContexts(command.getContexts());
        data.setIntegrationTypes(command.getIntegrationTypes());
        data.setNSFW(command.isNSFW());
        data.setDefaultPermissions(command.getDefaultPermissions());
        data.setNameLocalizations((Map)command.getNameLocalizations().toMap());
        data.setDescriptionLocalizations((Map)command.getDescriptionLocalizations().toMap());
        command.getOptions().stream().map(OptionData::fromOption).forEach(xva$0 -> data.addOptions((OptionData)xva$0));
        command.getSubcommands().stream().map(SubcommandData::fromSubcommand).forEach(xva$0 -> data.addSubcommands((SubcommandData)xva$0));
        command.getSubcommandGroups().stream().map(SubcommandGroupData::fromGroup).forEach(xva$0 -> data.addSubcommandGroups((SubcommandGroupData)xva$0));
        return data;
    }

    @Nonnull
    public static SlashCommandData fromData(@Nonnull DataObject object) {
        Checks.notNull(object, "DataObject");
        String name = object.getString("name");
        Command.Type commandType = Command.Type.fromId(object.getInt("type", 1));
        if (commandType != Command.Type.SLASH) {
            throw new IllegalArgumentException("Cannot convert command of type " + (Object)((Object)commandType) + " to SlashCommandData!");
        }
        String description = object.getString("description");
        DataArray options = object.optArray("options").orElseGet(DataArray::empty);
        CommandDataImpl command = new CommandDataImpl(name, description);
        if (!object.isNull("contexts")) {
            command.setContexts(object.getArray("contexts").stream(DataArray::getString).map(InteractionContextType::fromKey).collect(Helpers.toUnmodifiableEnumSet(InteractionContextType.class)));
        } else if (!object.isNull("dm_permission")) {
            command.setGuildOnly(!object.getBoolean("dm_permission"));
        } else {
            command.setContexts((Collection)Helpers.unmodifiableEnumSet((Enum)InteractionContextType.GUILD, (Enum[])new InteractionContextType[]{InteractionContextType.BOT_DM}));
        }
        if (!object.isNull("integration_types")) {
            command.setIntegrationTypes(object.getArray("integration_types").stream(DataArray::getString).map(IntegrationType::fromKey).collect(Helpers.toUnmodifiableEnumSet(IntegrationType.class)));
        } else {
            command.setIntegrationTypes((Collection)Helpers.unmodifiableEnumSet((Enum)IntegrationType.GUILD_INSTALL, (Enum[])new IntegrationType[0]));
        }
        command.setNSFW(object.getBoolean("nsfw"));
        command.setDefaultPermissions(object.isNull("default_member_permissions") ? DefaultMemberPermissions.ENABLED : DefaultMemberPermissions.enabledFor(object.getLong("default_member_permissions")));
        command.setNameLocalizations((Map)LocalizationUtils.mapFromProperty(object, "name_localizations"));
        command.setDescriptionLocalizations((Map)LocalizationUtils.mapFromProperty(object, "description_localizations"));
        options.stream(DataArray::getObject).forEach(opt -> {
            OptionType type = OptionType.fromKey(opt.getInt("type"));
            switch (type) {
                case SUB_COMMAND: {
                    command.addSubcommands(SubcommandData.fromData(opt));
                    break;
                }
                case SUB_COMMAND_GROUP: {
                    command.addSubcommandGroups(SubcommandGroupData.fromData(opt));
                    break;
                }
                default: {
                    command.addOptions(OptionData.fromData(opt));
                }
            }
        });
        return command;
    }
}

