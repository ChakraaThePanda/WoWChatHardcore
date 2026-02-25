/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectInteraction;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.interactions.component.SelectMenuInteractionImpl;

public class StringSelectInteractionImpl
extends SelectMenuInteractionImpl<String, StringSelectMenu>
implements StringSelectInteraction {
    private final List<String> values;

    public StringSelectInteractionImpl(JDAImpl jda, DataObject data) {
        super(jda, StringSelectMenu.class, data);
        this.values = Collections.unmodifiableList(this.parseValues(data.getObject("data")));
    }

    protected List<String> parseValues(DataObject data) {
        return data.optArray("values").map(arr -> arr.stream(DataArray::getString).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    @Nonnull
    public List<String> getValues() {
        return this.values;
    }
}

