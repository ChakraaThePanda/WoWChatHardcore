/*
 * Decompiled with CFR 0.152.
 */
package net.dv8tion.jda.internal.interactions.modal;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.modals.Modal;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.api.utils.data.SerializableData;
import net.dv8tion.jda.internal.utils.EntityString;
import net.dv8tion.jda.internal.utils.Helpers;

public class ModalImpl
implements Modal {
    private final String id;
    private final String title;
    private final List<LayoutComponent> components;

    public ModalImpl(DataObject object) {
        this.id = object.getString("custom_id");
        this.title = object.getString("title");
        this.components = object.optArray("components").orElseGet(DataArray::empty).stream(DataArray::getObject).map(ActionRow::fromData).collect(Helpers.toUnmodifiableList());
    }

    public ModalImpl(String id, String title, List<LayoutComponent> components) {
        this.id = id;
        this.title = title;
        this.components = Collections.unmodifiableList(components);
    }

    @Override
    @Nonnull
    public String getId() {
        return this.id;
    }

    @Override
    @Nonnull
    public String getTitle() {
        return this.title;
    }

    @Override
    @Nonnull
    public List<LayoutComponent> getComponents() {
        return this.components;
    }

    @Override
    @Nonnull
    public DataObject toData() {
        DataObject object = DataObject.empty().put("custom_id", this.id).put("title", this.title);
        object.put("components", DataArray.fromCollection(this.components.stream().map(SerializableData::toData).collect(Collectors.toList())));
        return object;
    }

    public String toString() {
        return new EntityString(this).addMetadata("id", this.id).addMetadata("title", this.title).toString();
    }
}

