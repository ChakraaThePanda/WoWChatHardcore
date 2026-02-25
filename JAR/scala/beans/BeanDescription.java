/*
 * Decompiled with CFR 0.152.
 */
package scala.beans;

import scala.annotation.Annotation;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\u0006\u000152A\u0001B\u0003\u0001\u0015!A\u0011\u0003\u0001BC\u0002\u0013\u0005!\u0003\u0003\u0005\u001f\u0001\t\u0005\t\u0015!\u0003\u0014\u0011\u0015y\u0002\u0001\"\u0001!\u0005=\u0011U-\u00198EKN\u001c'/\u001b9uS>t'B\u0001\u0004\b\u0003\u0015\u0011W-\u00198t\u0015\u0005A\u0011!B:dC2\f7\u0001A\n\u0003\u0001-\u0001\"\u0001D\b\u000e\u00035Q!AD\u0004\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0002\u0011\u001b\tQ\u0011I\u001c8pi\u0006$\u0018n\u001c8\u0002\u0017\u0011,7o\u0019:jaRLwN\\\u000b\u0002'A\u0011Ac\u0007\b\u0003+e\u0001\"AF\u0004\u000e\u0003]Q!\u0001G\u0005\u0002\rq\u0012xn\u001c;?\u0013\tQr!\u0001\u0004Qe\u0016$WMZ\u0005\u00039u\u0011aa\u0015;sS:<'B\u0001\u000e\b\u00031!Wm]2sSB$\u0018n\u001c8!\u0003\u0019a\u0014N\\5u}Q\u0011\u0011e\t\t\u0003E\u0001i\u0011!\u0002\u0005\u0006#\r\u0001\ra\u0005\u0015\u0005\u0001\u0015J3\u0006\u0005\u0002'O5\tq!\u0003\u0002)\u000f\tQA-\u001a9sK\u000e\fG/\u001a3\"\u0003)\n\u0011\b\u001e5fA\u001d,g.\u001a:bi&|g\u000eI8gA\t+\u0017M\\%oM>\u00043\r\\1tg\u0016\u001c\b%[:!]>\u0004Cn\u001c8hKJ\u00043/\u001e9q_J$X\rZ\u0011\u0002Y\u00051!GL\u00193]U\u0002")
public class BeanDescription
extends Annotation {
    private final String description;

    public String description() {
        return this.description;
    }

    public BeanDescription(String description) {
        this.description = description;
    }
}

