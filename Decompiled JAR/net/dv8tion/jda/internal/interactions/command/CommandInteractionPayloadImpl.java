/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.command;

import gnu.trove.map.TLongObjectMap;
import gnu.trove.map.hash.TLongObjectHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.entities.EntityBuilder;
import net.dv8tion.jda.internal.entities.MemberImpl;
import net.dv8tion.jda.internal.entities.UserImpl;
import net.dv8tion.jda.internal.interactions.InteractionImpl;

public class CommandInteractionPayloadImpl
extends InteractionImpl
implements CommandInteractionPayload {
    private final long commandId;
    private final List<OptionMapping> options = new ArrayList<OptionMapping>();
    private final TLongObjectMap<Object> resolved = new TLongObjectHashMap<Object>();
    private final String name;
    private final boolean isGuildCommand;
    private String subcommand;
    private String group;
    private final Command.Type type;

    public CommandInteractionPayloadImpl(JDAImpl jda, DataObject data) {
        super(jda, data);
        DataObject commandData = data.getObject("data");
        this.commandId = commandData.getUnsignedLong("id");
        this.name = commandData.getString("name");
        this.type = Command.Type.fromId(commandData.getInt("type", 1));
        this.isGuildCommand = !commandData.isNull("guild_id");
        DataArray options = commandData.optArray("options").orElseGet(DataArray::empty);
        DataObject resolveJson = commandData.optObject("resolved").orElseGet(DataObject::empty);
        if (options.length() == 1) {
            DataObject option = options.getObject(0);
            switch (OptionType.fromKey(option.getInt("type"))) {
                case SUB_COMMAND_GROUP: {
                    this.group = option.getString("name");
                    options = option.getArray("options");
                    option = options.getObject(0);
                }
                case SUB_COMMAND: {
                    this.subcommand = option.getString("name");
                    options = option.optArray("options").orElseGet(DataArray::empty);
                }
            }
        }
        this.parseResolved(jda, resolveJson);
        this.parseOptions(options);
    }

    private void parseOptions(DataArray options) {
        options.stream(DataArray::getObject).map(json -> new OptionMapping((DataObject)json, this.resolved, this.getJDA(), this.getGuild())).forEach(this.options::add);
    }

    private void parseResolved(JDAImpl jda, DataObject resolveJson) {
        EntityBuilder entityBuilder = jda.getEntityBuilder();
        resolveJson.optObject("users").ifPresent(users -> users.keys().forEach(userId -> {
            DataObject userJson = users.getObject((String)userId);
            UserImpl userArg = entityBuilder.createUser(userJson);
            this.resolved.put(userArg.getIdLong(), userArg);
        }));
        resolveJson.optObject("attachments").ifPresent(attachments -> attachments.keys().forEach(id -> {
            DataObject json = attachments.getObject((String)id);
            Message.Attachment file = entityBuilder.createMessageAttachment(json);
            this.resolved.put(file.getIdLong(), file);
        }));
        if (this.guild != null) {
            resolveJson.optObject("members").ifPresent(members -> {
                DataObject users = resolveJson.getObject("users");
                members.keys().forEach(memberId -> {
                    DataObject memberJson = members.getObject((String)memberId);
                    memberJson.put("user", users.getObject((String)memberId));
                    Member optionMember = this.interactionEntityBuilder.createMember(this.guild, memberJson);
                    if (this.member instanceof MemberImpl) {
                        entityBuilder.updateMemberCache((MemberImpl)optionMember);
                    }
                    this.resolved.put(optionMember.getIdLong(), optionMember);
                });
            });
            resolveJson.optObject("roles").ifPresent(roles -> roles.keys().stream().map(roleId -> {
                if (!this.guild.isDetached()) {
                    return this.guild.getRoleById((String)roleId);
                }
                return this.interactionEntityBuilder.createRole(this.guild, roles.getObject((String)roleId));
            }).filter(Objects::nonNull).forEach(role -> this.resolved.put(role.getIdLong(), role)));
            resolveJson.optObject("channels").ifPresent(channels -> channels.keys().forEach(id -> {
                GuildChannel channelObj = jda.getGuildChannelById((String)id);
                DataObject channelJson = channels.getObject((String)id);
                if (channelObj != null) {
                    this.resolved.put(channelObj.getIdLong(), channelObj);
                } else if (ChannelType.fromId(channelJson.getInt("type")).isThread()) {
                    this.resolved.put(Long.parseUnsignedLong(id), this.interactionEntityBuilder.createThreadChannel(this.guild, channelJson));
                } else {
                    this.resolved.put(Long.parseUnsignedLong(id), this.interactionEntityBuilder.createGuildChannel(this.guild, channelJson));
                }
            }));
        }
    }

    @Override
    @Nullable
    public MessageChannelUnion getChannel() {
        return (MessageChannelUnion)super.getChannel();
    }

    @Override
    @Nonnull
    public Command.Type getCommandType() {
        return this.type;
    }

    @Override
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override
    public String getSubcommandName() {
        return this.subcommand;
    }

    @Override
    public String getSubcommandGroup() {
        return this.group;
    }

    @Override
    public long getCommandIdLong() {
        return this.commandId;
    }

    @Override
    public boolean isGuildCommand() {
        return this.isGuildCommand;
    }

    @Override
    @Nonnull
    public List<OptionMapping> getOptions() {
        return this.options;
    }
}

