/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.command;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.localization.LocalizationMap;
import net.dv8tion.jda.api.interactions.commands.privileges.IntegrationPrivilege;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.Route;
import net.dv8tion.jda.api.requests.restaction.CommandEditAction;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.requests.RestActionImpl;
import net.dv8tion.jda.internal.requests.restaction.CommandEditActionImpl;
import net.dv8tion.jda.internal.utils.Checks;
import net.dv8tion.jda.internal.utils.EntityString;
import net.dv8tion.jda.internal.utils.Helpers;
import net.dv8tion.jda.internal.utils.localization.LocalizationUtils;

public class CommandImpl
implements Command {
    public static final EnumSet<OptionType> OPTIONS = EnumSet.complementOf(EnumSet.of(OptionType.SUB_COMMAND, OptionType.SUB_COMMAND_GROUP));
    public static final Predicate<DataObject> OPTION_TEST = it -> OPTIONS.contains((Object)OptionType.fromKey(it.getInt("type")));
    public static final Predicate<DataObject> SUBCOMMAND_TEST = it -> OptionType.fromKey(it.getInt("type")) == OptionType.SUB_COMMAND;
    public static final Predicate<DataObject> GROUP_TEST = it -> OptionType.fromKey(it.getInt("type")) == OptionType.SUB_COMMAND_GROUP;
    private final JDAImpl api;
    private final Guild guild;
    private final String name;
    private final String description;
    private final LocalizationMap nameLocalizations;
    private final LocalizationMap descriptionLocalizations;
    private final List<Command.Option> options;
    private final List<Command.SubcommandGroup> groups;
    private final List<Command.Subcommand> subcommands;
    private final long id;
    private final long guildId;
    private final long applicationId;
    private final long version;
    private final boolean nsfw;
    private final Set<InteractionContextType> contexts;
    private final Set<IntegrationType> integrationTypes;
    private final Command.Type type;
    private final DefaultMemberPermissions defaultMemberPermissions;

    public CommandImpl(JDAImpl api2, Guild guild, DataObject json) {
        boolean dmPermission;
        this.api = api2;
        this.guild = guild;
        this.name = json.getString("name");
        this.nameLocalizations = LocalizationUtils.unmodifiableFromProperty(json, "name_localizations");
        this.description = json.getString("description", "");
        this.descriptionLocalizations = LocalizationUtils.unmodifiableFromProperty(json, "description_localizations");
        this.type = Command.Type.fromId(json.getInt("type", 1));
        this.id = json.getUnsignedLong("id");
        this.guildId = guild != null ? guild.getIdLong() : 0L;
        this.applicationId = json.getUnsignedLong("application_id", api2.getSelfUser().getApplicationIdLong());
        this.options = CommandImpl.parseOptions(json, OPTION_TEST, Command.Option::new);
        this.groups = CommandImpl.parseOptions(json, GROUP_TEST, o -> new Command.SubcommandGroup(this, (DataObject)o));
        this.subcommands = CommandImpl.parseOptions(json, SUBCOMMAND_TEST, o -> new Command.Subcommand(this, (DataObject)o));
        this.version = json.getUnsignedLong("version", this.id);
        DefaultMemberPermissions defaultMemberPermissions = this.defaultMemberPermissions = json.isNull("default_member_permissions") ? DefaultMemberPermissions.ENABLED : DefaultMemberPermissions.enabledFor(json.getLong("default_member_permissions"));
        this.contexts = !json.isNull("contexts") ? json.getArray("contexts").stream(DataArray::getString).map(InteractionContextType::fromKey).collect(Helpers.toUnmodifiableEnumSet(InteractionContextType.class)) : (this.guildId != 0L ? Helpers.unmodifiableEnumSet((Enum)InteractionContextType.GUILD, (Enum[])new InteractionContextType[0]) : ((dmPermission = json.getBoolean("dm_permission", true)) ? Helpers.unmodifiableEnumSet((Enum)InteractionContextType.GUILD, (Enum[])new InteractionContextType[]{InteractionContextType.BOT_DM}) : Helpers.unmodifiableEnumSet((Enum)InteractionContextType.GUILD, (Enum[])new InteractionContextType[0])));
        this.integrationTypes = !json.isNull("integration_types") ? json.getArray("integration_types").stream(DataArray::getString).map(IntegrationType::fromKey).collect(Helpers.toUnmodifiableEnumSet(IntegrationType.class)) : Helpers.unmodifiableEnumSet((Enum)IntegrationType.GUILD_INSTALL, (Enum[])new IntegrationType[0]);
        this.nsfw = json.getBoolean("nsfw");
    }

    public static <T> List<T> parseOptions(DataObject json, Predicate<DataObject> test, Function<DataObject, T> transform) {
        return json.optArray("options").map(arr -> arr.stream(DataArray::getObject).filter(test).map(transform).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    @Nonnull
    public RestAction<Void> delete() {
        this.checkSelfUser("Cannot delete a command from another bot!");
        String appId = this.getJDA().getSelfUser().getApplicationId();
        Route.CompiledRoute route = this.guildId != 0L ? Route.Interactions.DELETE_GUILD_COMMAND.compile(appId, Long.toUnsignedString(this.guildId), this.getId()) : Route.Interactions.DELETE_COMMAND.compile(appId, this.getId());
        return new RestActionImpl<Void>(this.api, route);
    }

    @Override
    @Nonnull
    public CommandEditAction editCommand() {
        this.checkSelfUser("Cannot edit a command from another bot!");
        return this.guild == null ? new CommandEditActionImpl((JDA)this.api, this.type, this.getId()) : new CommandEditActionImpl(this.guild, this.type, this.getId());
    }

    @Override
    @Nonnull
    public RestAction<List<IntegrationPrivilege>> retrievePrivileges(@Nonnull Guild guild) {
        this.checkSelfUser("Cannot retrieve privileges for a command from another bot!");
        Checks.notNull(guild, "Guild");
        return guild.retrieveIntegrationPrivilegesById(this.id);
    }

    @Override
    @Nonnull
    public JDA getJDA() {
        return this.api;
    }

    @Override
    @Nonnull
    public Command.Type getType() {
        return this.type;
    }

    @Override
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override
    @Nonnull
    public LocalizationMap getNameLocalizations() {
        return this.nameLocalizations;
    }

    @Override
    @Nonnull
    public String getFullCommandName() {
        return this.name;
    }

    @Override
    @Nonnull
    public String getDescription() {
        return this.description;
    }

    @Override
    @Nonnull
    public LocalizationMap getDescriptionLocalizations() {
        return this.descriptionLocalizations;
    }

    @Override
    @Nonnull
    public List<Command.Option> getOptions() {
        return this.options;
    }

    @Override
    @Nonnull
    public List<Command.Subcommand> getSubcommands() {
        return this.subcommands;
    }

    @Override
    @Nonnull
    public List<Command.SubcommandGroup> getSubcommandGroups() {
        return this.groups;
    }

    @Override
    public long getApplicationIdLong() {
        return this.applicationId;
    }

    @Override
    public long getVersion() {
        return this.version;
    }

    @Override
    @Nonnull
    public DefaultMemberPermissions getDefaultPermissions() {
        return this.defaultMemberPermissions;
    }

    @Override
    public boolean isGuildOnly() {
        return this.contexts.size() == 1 && this.contexts.contains((Object)InteractionContextType.GUILD);
    }

    @Override
    @Nonnull
    public EnumSet<InteractionContextType> getContexts() {
        return Helpers.copyEnumSet(InteractionContextType.class, this.contexts);
    }

    @Override
    @Nonnull
    public EnumSet<IntegrationType> getIntegrationTypes() {
        return Helpers.copyEnumSet(IntegrationType.class, this.integrationTypes);
    }

    @Override
    public boolean isNSFW() {
        return this.nsfw;
    }

    @Override
    public long getIdLong() {
        return this.id;
    }

    @Override
    @Nonnull
    public String getAsMention() {
        if (this.getType() != Command.Type.SLASH) {
            throw new IllegalStateException("Only slash commands can be mentioned");
        }
        return Command.super.getAsMention();
    }

    public String toString() {
        return new EntityString(this).setType(this.getType()).setName(this.getName()).toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Command)) {
            return false;
        }
        return this.id == ((Command)obj).getIdLong();
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    private void checkSelfUser(String s) {
        if (this.applicationId != this.api.getSelfUser().getApplicationIdLong()) {
            throw new IllegalStateException(s);
        }
    }
}

