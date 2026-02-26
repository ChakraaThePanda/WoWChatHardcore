/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.api.interactions.commands;

import net.dv8tion.jda.api.interactions.callbacks.IModalCallback;
import net.dv8tion.jda.api.interactions.callbacks.IPremiumRequiredReplyCallback;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import net.dv8tion.jda.api.interactions.commands.CommandInteractionPayload;

public interface CommandInteraction
extends IReplyCallback,
CommandInteractionPayload,
IModalCallback,
IPremiumRequiredReplyCallback {
}

