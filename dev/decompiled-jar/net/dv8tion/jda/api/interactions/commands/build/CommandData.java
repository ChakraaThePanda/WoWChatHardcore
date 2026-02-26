/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.UnmodifiableView
 */
package net.dv8tion.jda.api.interactions.commands.build;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import net.dv8tion.jda.annotations.ReplaceWith;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.interactions.commands.localization.LocalizationFunction;
import net.dv8tion.jda.api.interactions.commands.localization.LocalizationMap;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.SerializableData;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.Helpers;
import net.dv8tion.jda.internal.utils.localization.LocalizationUtils;
import org.jetbrains.annotations.UnmodifiableView;

public interface CommandData
extends SerializableData {
    public static final int MAX_NAME_LENGTH = 32;
    public static final int MAX_DESCRIPTION_LENGTH = 100;
    public static final int MAX_OPTIONS = 25;

    @Nonnull
    public CommandData setLocalizationFunction(@Nonnull LocalizationFunction var1);

    @Nonnull
    public CommandData setName(@Nonnull String var1);

    @Nonnull
    public CommandData setNameLocalization(@Nonnull DiscordLocale var1, @Nonnull String var2);

    @Nonnull
    public CommandData setNameLocalizations(@Nonnull Map<DiscordLocale, String> var1);

    @Nonnull
    public CommandData setDefaultPermissions(@Nonnull DefaultMemberPermissions var1);

    @Nonnull
    @Deprecated
    @ReplaceWith(value="setContexts(InteractionContextType.GUILD)")
    public CommandData setGuildOnly(boolean var1);

    @Nonnull
    default public CommandData setContexts(InteractionContextType ... contexts) {
        Checks.notEmpty((Object[])contexts, "Contexts");
        return this.setContexts(Arrays.asList(contexts));
    }

    @Nonnull
    public CommandData setContexts(@Nonnull Collection<InteractionContextType> var1);

    @Nonnull
    default public CommandData setIntegrationTypes(IntegrationType ... integrationTypes) {
        Checks.notEmpty((Object[])integrationTypes, "Integration types");
        return this.setIntegrationTypes(Arrays.asList(integrationTypes));
    }

    @Nonnull
    public CommandData setIntegrationTypes(@Nonnull Collection<IntegrationType> var1);

    @Nonnull
    public CommandData setNSFW(boolean var1);

    @Nonnull
    public String getName();

    @Nonnull
    public LocalizationMap getNameLocalizations();

    @Nonnull
    public Command.Type getType();

    @Nonnull
    public DefaultMemberPermissions getDefaultPermissions();

    @Deprecated
    @ReplaceWith(value="getContexts().equals(EnumSet.of(InteractionContextType.GUILD))")
    public boolean isGuildOnly();

    @Nonnull
    public @UnmodifiableView Set<InteractionContextType> getContexts();

    @Nonnull
    public @UnmodifiableView Set<IntegrationType> getIntegrationTypes();

    public boolean isNSFW();

    @Nonnull
    public static CommandData fromCommand(@Nonnull Command command) {
        Checks.notNull(command, "Command");
        if (command.getType() != Command.Type.SLASH) {
            CommandDataImpl data = new CommandDataImpl(command.getType(), command.getName());
            return ((CommandDataImpl)((CommandDataImpl)((CommandDataImpl)data.setDefaultPermissions(command.getDefaultPermissions()).setContexts(command.getContexts())).setIntegrationTypes(command.getIntegrationTypes())).setNSFW(command.isNSFW()).setNameLocalizations((Map)command.getNameLocalizations().toMap())).setDescriptionLocalizations((Map)command.getDescriptionLocalizations().toMap());
        }
        return SlashCommandData.fromCommand(command);
    }

    @Nonnull
    public static CommandData fromData(@Nonnull DataObject object) {
        Checks.notNull(object, "DataObject");
        String name = object.getString("name");
        Command.Type commandType = Command.Type.fromId(object.getInt("type", 1));
        if (commandType != Command.Type.SLASH) {
            CommandDataImpl data = new CommandDataImpl(commandType, name);
            if (!object.isNull("default_member_permissions")) {
                long defaultPermissions = object.getLong("default_member_permissions");
                data.setDefaultPermissions(defaultPermissions == 0L ? DefaultMemberPermissions.DISABLED : DefaultMemberPermissions.enabledFor(defaultPermissions));
            }
            if (!object.isNull("contexts")) {
                data.setContexts(object.getArray("contexts").stream(DataArray::getString).map(InteractionContextType::fromKey).collect(Helpers.toUnmodifiableEnumSet(InteractionContextType.class)));
            } else if (!object.isNull("dm_permission")) {
                data.setGuildOnly(!object.getBoolean("dm_permission"));
            } else {
                data.setContexts((Collection)Helpers.unmodifiableEnumSet((Enum)InteractionContextType.GUILD, (Enum[])new InteractionContextType[]{InteractionContextType.BOT_DM}));
            }
            if (!object.isNull("integration_types")) {
                data.setIntegrationTypes(object.getArray("integration_types").stream(DataArray::getString).map(IntegrationType::fromKey).collect(Helpers.toUnmodifiableEnumSet(IntegrationType.class)));
            } else {
                data.setIntegrationTypes((Collection)Helpers.unmodifiableEnumSet((Enum)IntegrationType.GUILD_INSTALL, (Enum[])new IntegrationType[0]));
            }
            data.setNSFW(object.getBoolean("nsfw"));
            data.setNameLocalizations((Map)LocalizationUtils.mapFromProperty(object, "name_localizations"));
            data.setDescriptionLocalizations((Map)LocalizationUtils.mapFromProperty(object, "description_localizations"));
            return data;
        }
        return SlashCommandData.fromData(object);
    }
}

