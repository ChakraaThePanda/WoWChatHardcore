/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.codec.xml;

import io.netty.handler.codec.xml.XmlAttribute;
import io.netty.handler.codec.xml.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class XmlElementStart
extends XmlElement {
    private final List<XmlAttribute> attributes = new ArrayList<XmlAttribute>();

    public XmlElementStart(String name, String namespace, String prefix) {
        super(name, namespace, prefix);
    }

    public List<XmlAttribute> attributes() {
        return this.attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        XmlElementStart that = (XmlElementStart)o;
        return this.attributes.equals(that.attributes);
    }

    @Override
    public int hashCode() {
        int result2 = super.hashCode();
        result2 = 31 * result2 + this.attributes.hashCode();
        return result2;
    }

    @Override
    public String toString() {
        return "XmlElementStart{attributes=" + this.attributes + super.toString() + "} ";
    }
}

