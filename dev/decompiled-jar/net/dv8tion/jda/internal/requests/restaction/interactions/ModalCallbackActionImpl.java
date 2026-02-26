/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.requests.restaction.interactions;

import java.util.function.BooleanSupplier;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.callbacks.IModalCallback;
import net.dv8tion.jda.api.interactions.modals.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.InteractionCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.interactions.InteractionImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.InteractionCallbackImpl;
import okhttp3.RequestBody;

public class ModalCallbackActionImpl
extends InteractionCallbackImpl<Void>
implements ModalCallbackAction {
    private final Modal modal;

    public ModalCallbackActionImpl(IModalCallback interaction, Modal modal) {
        super((InteractionImpl)((Object)interaction));
        this.modal = modal;
    }

    @Override
    protected RequestBody finalizeData() {
        return this.getRequestBody(DataObject.empty().put("type", InteractionCallbackAction.ResponseType.MODAL.getRaw()).put("data", this.modal));
    }

    @Override
    @Nonnull
    public ModalCallbackAction setCheck(BooleanSupplier checks) {
        return (ModalCallbackAction)super.setCheck(checks);
    }

    @Override
    @Nonnull
    public ModalCallbackAction deadline(long timestamp) {
        return (ModalCallbackAction)super.deadline(timestamp);
    }
}

