/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.modal;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.interactions.modals.ModalInteraction;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.interactions.DeferrableInteractionImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.MessageEditCallbackActionImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.ReplyCallbackActionImpl;

public class ModalInteractionImpl
extends DeferrableInteractionImpl
implements ModalInteraction {
    private final String modalId;
    private final List<ModalMapping> mappings;
    private final Message message;

    public ModalInteractionImpl(JDAImpl api2, DataObject object) {
        super(api2, object);
        DataObject data = object.getObject("data");
        this.modalId = data.getString("custom_id");
        this.mappings = data.optArray("components").orElseGet(DataArray::empty).stream(DataArray::getObject).map(dataObject -> dataObject.getArray("components")).flatMap(dataArray -> dataArray.stream(DataArray::getObject)).map(ModalMapping::new).collect(Collectors.toList());
        this.message = object.optObject("message").map(o -> api2.getEntityBuilder().createMessageWithChannel((DataObject)o, this.getMessageChannel(), false)).orElse(null);
    }

    @Override
    @Nonnull
    public String getModalId() {
        return this.modalId;
    }

    @Override
    @Nonnull
    public List<ModalMapping> getValues() {
        return Collections.unmodifiableList(this.mappings);
    }

    @Override
    public Message getMessage() {
        return this.message;
    }

    @Override
    @Nonnull
    public ReplyCallbackAction deferReply() {
        return new ReplyCallbackActionImpl(this.hook);
    }

    @Override
    @Nonnull
    public MessageEditCallbackAction deferEdit() {
        return new MessageEditCallbackActionImpl(this.hook);
    }

    @Override
    @Nonnull
    public MessageChannelUnion getChannel() {
        return (MessageChannelUnion)super.getChannel();
    }
}

