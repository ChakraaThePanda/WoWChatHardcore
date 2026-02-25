/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import scala.Function1;
import scala.Predef$;
import scala.collection.immutable.StringOps;
import scala.reflect.internal.Chars$;
import scala.reflect.internal.Precedence;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichInt;

public final class Precedence$
implements Function1<Object, Precedence> {
    public static Precedence$ MODULE$;
    private final String ErrorName;

    static {
        new Precedence$();
    }

    @Override
    public boolean apply$mcZD$sp(double v1) {
        return Function1.apply$mcZD$sp$(this, v1);
    }

    @Override
    public double apply$mcDD$sp(double v1) {
        return Function1.apply$mcDD$sp$(this, v1);
    }

    @Override
    public float apply$mcFD$sp(double v1) {
        return Function1.apply$mcFD$sp$(this, v1);
    }

    @Override
    public int apply$mcID$sp(double v1) {
        return Function1.apply$mcID$sp$(this, v1);
    }

    @Override
    public long apply$mcJD$sp(double v1) {
        return Function1.apply$mcJD$sp$(this, v1);
    }

    @Override
    public void apply$mcVD$sp(double v1) {
        Function1.apply$mcVD$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZF$sp(float v1) {
        return Function1.apply$mcZF$sp$(this, v1);
    }

    @Override
    public double apply$mcDF$sp(float v1) {
        return Function1.apply$mcDF$sp$(this, v1);
    }

    @Override
    public float apply$mcFF$sp(float v1) {
        return Function1.apply$mcFF$sp$(this, v1);
    }

    @Override
    public int apply$mcIF$sp(float v1) {
        return Function1.apply$mcIF$sp$(this, v1);
    }

    @Override
    public long apply$mcJF$sp(float v1) {
        return Function1.apply$mcJF$sp$(this, v1);
    }

    @Override
    public void apply$mcVF$sp(float v1) {
        Function1.apply$mcVF$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZI$sp(int v1) {
        return Function1.apply$mcZI$sp$(this, v1);
    }

    @Override
    public double apply$mcDI$sp(int v1) {
        return Function1.apply$mcDI$sp$(this, v1);
    }

    @Override
    public float apply$mcFI$sp(int v1) {
        return Function1.apply$mcFI$sp$(this, v1);
    }

    @Override
    public int apply$mcII$sp(int v1) {
        return Function1.apply$mcII$sp$(this, v1);
    }

    @Override
    public long apply$mcJI$sp(int v1) {
        return Function1.apply$mcJI$sp$(this, v1);
    }

    @Override
    public void apply$mcVI$sp(int v1) {
        Function1.apply$mcVI$sp$(this, v1);
    }

    @Override
    public boolean apply$mcZJ$sp(long v1) {
        return Function1.apply$mcZJ$sp$(this, v1);
    }

    @Override
    public double apply$mcDJ$sp(long v1) {
        return Function1.apply$mcDJ$sp$(this, v1);
    }

    @Override
    public float apply$mcFJ$sp(long v1) {
        return Function1.apply$mcFJ$sp$(this, v1);
    }

    @Override
    public int apply$mcIJ$sp(long v1) {
        return Function1.apply$mcIJ$sp$(this, v1);
    }

    @Override
    public long apply$mcJJ$sp(long v1) {
        return Function1.apply$mcJJ$sp$(this, v1);
    }

    @Override
    public void apply$mcVJ$sp(long v1) {
        Function1.apply$mcVJ$sp$(this, v1);
    }

    @Override
    public <A> Function1<A, Precedence> compose(Function1<A, Object> g) {
        return Function1.compose$(this, g);
    }

    @Override
    public <A> Function1<Object, A> andThen(Function1<Precedence, A> g) {
        return Function1.andThen$(this, g);
    }

    @Override
    public String toString() {
        return Function1.toString$(this);
    }

    private String ErrorName() {
        return this.ErrorName;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isAssignmentOp(String name) {
        if ("!=".equals(name)) {
            return false;
        }
        if ("<=".equals(name)) {
            return false;
        }
        if (">=".equals(name)) {
            return false;
        }
        if ("".equals(name)) {
            return false;
        }
        boolean bl = false;
        if (bl) {
            return false;
        }
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToChar(new StringOps(name).last()) != '=') return false;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (BoxesRunTime.unboxToChar(new StringOps(name).head()) == '=') return false;
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        if (!Chars$.MODULE$.isOperatorPart(BoxesRunTime.unboxToChar(new StringOps(name).head()))) return false;
        return true;
    }

    private int firstChar(char ch) {
        int n;
        switch (ch) {
            case '|': {
                n = 2;
                break;
            }
            case '^': {
                n = 3;
                break;
            }
            case '&': {
                n = 4;
                break;
            }
            case '!': 
            case '=': {
                n = 5;
                break;
            }
            case '<': 
            case '>': {
                n = 6;
                break;
            }
            case ':': {
                n = 7;
                break;
            }
            case '+': 
            case '-': {
                n = 8;
                break;
            }
            case '%': 
            case '*': 
            case '/': {
                n = 9;
                break;
            }
            default: {
                n = Chars$.MODULE$.isScalaLetter(ch) ? 1 : 10;
            }
        }
        return this.apply(n);
    }

    @Override
    public int apply(int level) {
        return level;
    }

    @Override
    public int apply(String name) {
        boolean bl;
        if ("".equals(name)) {
            bl = true;
        } else {
            String string = this.ErrorName();
            bl = !(string != null ? !string.equals(name) : name != null);
        }
        int n = bl ? this.apply(-1) : (this.isAssignmentOp(name) ? this.apply(0) : this.firstChar(name.charAt(0)));
        return n;
    }

    public final int compare$extension(int $this, int that) {
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return new RichInt($this).compare(BoxesRunTime.boxToInteger(that));
    }

    public final String toString$extension(int $this) {
        return new StringBuilder(12).append("Precedence(").append($this).append(")").toString();
    }

    public final int hashCode$extension(int $this) {
        return Integer.hashCode($this);
    }

    public final boolean equals$extension(int $this, Object x$1) {
        int n;
        boolean bl = x$1 instanceof Precedence;
        return bl && $this == (n = ((Precedence)x$1).level());
    }

    private Precedence$() {
        MODULE$ = this;
        this.ErrorName = "<error>";
    }
}

