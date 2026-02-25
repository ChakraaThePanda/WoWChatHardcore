/*
 * Decompiled with CFR 0.152.
 */
package scala.collection.immutable;

import scala.MatchError;
import scala.math.package$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;

@ScalaSignature(bytes="\u0006\u0001\u0005ec\u0001\u0003\u0010 !\u0003\r\taH\u0013\t\u000b-\u0002A\u0011A\u0017\t\u0015E\u0002\u0001\u0019!a\u0001\n\u0003y\"\u0007\u0003\u00067\u0001\u0001\u0007\t\u0019!C\u0001?]B!B\u000f\u0001A\u0002\u0003\u0007I\u0011A\u0010<\u0011)y\u0004\u00011AA\u0002\u0013\u0005q\u0004\u0011\u0005\u000b\u0005\u0002\u0001\r\u00111A\u0005\u0002}Y\u0004BC\"\u0001\u0001\u0004\u0005\r\u0011\"\u0001 \t\"Qa\t\u0001a\u0001\u0002\u0004%\taH\u001e\t\u0015\u001d\u0003\u0001\u0019!a\u0001\n\u0003y\u0002\n\u0003\u0006K\u0001\u0001\u0007\t\u0019!C\u0001?mB!b\u0013\u0001A\u0002\u0003\u0007I\u0011A\u0010M\u0011)q\u0005\u00011AA\u0002\u0013\u0005qd\u000f\u0005\u000b\u001f\u0002\u0001\r\u00111A\u0005\u0002}\u0001\u0006B\u0003*\u0001\u0001\u0004\u0005\r\u0011\"\u0001 w!Q1\u000b\u0001a\u0001\u0002\u0004%\ta\b+\t\rY\u0003AQA\u0010X\u0011\u00191\u0006\u0001\"\u0002 Q\"1q\u000e\u0001C\u0003?ADa\u0001\u001f\u0001\u0005\u0006}I\bB\u0002?\u0001\t\u000byR\u0010\u0003\u0005\u0002\u0002\u0001!)aHA\u0002\u0011!\tI\u0001\u0001C\u0003?\u0005-\u0001\u0002CA\t\u0001\u0011\u0015q$a\u0005\t\u0011\u0005m\u0001\u0001\"\u0002 \u0003;A\u0001\"!\t\u0001\t\u000by\u00121\u0005\u0005\t\u0003W\u0001AQA\u0010\u0002.!A\u0011q\u0007\u0001\u0005\u0006}\tI\u0004\u0003\u0005\u0002F\u0001!)aHA$\u0011!\ty\u0005\u0001C\u0003?\u0005E#!\u0004,fGR|'\u000fU8j]R,'O\u0003\u0002!C\u0005I\u0011.\\7vi\u0006\u0014G.\u001a\u0006\u0003E\r\n!bY8mY\u0016\u001cG/[8o\u0015\u0005!\u0013!B:dC2\fWC\u0001\u0014s'\t\u0001q\u0005\u0005\u0002)S5\t1%\u0003\u0002+G\t1\u0011I\\=SK\u001a\fa\u0001J5oSR$3\u0001\u0001\u000b\u0002]A\u0011\u0001fL\u0005\u0003a\r\u0012A!\u00168ji\u0006)A-\u001a9uQV\t1\u0007\u0005\u0002)i%\u0011Qg\t\u0002\u0004\u0013:$\u0018!\u00033faRDw\fJ3r)\tq\u0003\bC\u0004:\u0007\u0005\u0005\t\u0019A\u001a\u0002\u0007a$\u0013'\u0001\u0005eSN\u0004H.Y=1+\u0005a\u0004c\u0001\u0015>O%\u0011ah\t\u0002\u0006\u0003J\u0014\u0018-_\u0001\rI&\u001c\b\u000f\\1za}#S-\u001d\u000b\u0003]\u0005Cq!O\u0003\u0002\u0002\u0003\u0007A(\u0001\u0005eSN\u0004H.Y=2\u00031!\u0017n\u001d9mCf\ft\fJ3r)\tqS\tC\u0004:\u000f\u0005\u0005\t\u0019\u0001\u001f\u0002\u0011\u0011L7\u000f\u001d7bsJ\nA\u0002Z5ta2\f\u0017PM0%KF$\"AL%\t\u000feJ\u0011\u0011!a\u0001y\u0005AA-[:qY\u0006L8'\u0001\u0007eSN\u0004H.Y=4?\u0012*\u0017\u000f\u0006\u0002/\u001b\"9\u0011hCA\u0001\u0002\u0004a\u0014\u0001\u00033jgBd\u0017-\u001f\u001b\u0002\u0019\u0011L7\u000f\u001d7bsRzF%Z9\u0015\u00059\n\u0006bB\u001d\u000e\u0003\u0003\u0005\r\u0001P\u0001\tI&\u001c\b\u000f\\1zk\u0005aA-[:qY\u0006LXg\u0018\u0013fcR\u0011a&\u0016\u0005\bs=\t\t\u00111\u0001=\u0003!Ig.\u001b;Ge>lWC\u0001-`)\tq\u0013\fC\u0003[!\u0001\u00071,\u0001\u0003uQ\u0006$\bc\u0001/\u0001;6\tq\u0004\u0005\u0002_?2\u0001A!\u00021\u0011\u0005\u0004\t'!A+\u0012\u0005\t,\u0007C\u0001\u0015d\u0013\t!7EA\u0004O_RD\u0017N\\4\u0011\u0005!2\u0017BA4$\u0005\r\te._\u000b\u0003S6$2A\f6o\u0011\u0015Q\u0016\u00031\u0001l!\ra\u0006\u0001\u001c\t\u0003=6$Q\u0001Y\tC\u0002\u0005DQ!M\tA\u0002M\nqaZ3u\u000b2,W\u000eF\u0002riZ\u0004\"A\u0018:\u0005\u000bM\u0004!\u0019A1\u0003\u0003QCQ!\u001e\nA\u0002M\nQ!\u001b8eKbDQa\u001e\nA\u0002M\n1\u0001_8s\u0003\u001d9w\u000e^8Q_N$2A\f>|\u0011\u0015)8\u00031\u00014\u0011\u001598\u00031\u00014\u0003I9w\u000e^8OKb$(\t\\8dWN#\u0018M\u001d;\u0015\u00079rx\u0010C\u0003v)\u0001\u00071\u0007C\u0003x)\u0001\u00071'\u0001\u000eh_R|g*\u001a=u\u00052|7m[*uCJ$xK]5uC\ndW\rF\u0003/\u0003\u000b\t9\u0001C\u0003v+\u0001\u00071\u0007C\u0003x+\u0001\u00071'\u0001\u0004d_BLxJ\u001a\u000b\u0004y\u00055\u0001BBA\b-\u0001\u0007A(A\u0001b\u0003=qW\u000f\u001c7TY>$\u0018I\u001c3D_BLH#\u0002\u001f\u0002\u0016\u0005e\u0001BBA\f/\u0001\u0007A(A\u0003beJ\f\u0017\u0010C\u0003v/\u0001\u00071'A\u0005ti\u0006\u0014\u0017\u000e\\5{KR\u0019a&a\b\t\u000bUD\u0002\u0019A\u001a\u0002!\u001d|Go\u001c)pg^\u0013\u0018\u000e^1cY\u0016\u0004D#\u0002\u0018\u0002&\u0005%\u0002BBA\u00143\u0001\u00071'\u0001\u0005oK^Le\u000eZ3y\u0011\u00159\u0018\u00041\u00014\u0003A9w\u000e^8Q_N<&/\u001b;bE2,\u0017\u0007F\u0004/\u0003_\t\u0019$!\u000e\t\r\u0005E\"\u00041\u00014\u0003!yG\u000eZ%oI\u0016D\bBBA\u00145\u0001\u00071\u0007C\u0003x5\u0001\u00071'A\u0005d_BL(+\u00198hKR9A(a\u000f\u0002>\u0005\u0005\u0003BBA\f7\u0001\u0007A\b\u0003\u0004\u0002@m\u0001\raM\u0001\b_2$G*\u001a4u\u0011\u0019\t\u0019e\u0007a\u0001g\u00059a.Z<MK\u001a$\u0018!F4pi>4%/Z:i!>\u001cxK]5uC\ndW\r\r\u000b\b]\u0005%\u00131JA'\u0011\u0019\t\t\u0004\ba\u0001g!1\u0011q\u0005\u000fA\u0002MBQa\u001e\u000fA\u0002M\nQcZ8u_\u001a\u0013Xm\u001d5Q_N<&/\u001b;bE2,\u0017\u0007F\u0004/\u0003'\n)&a\u0016\t\r\u0005ER\u00041\u00014\u0011\u0019\t9#\ba\u0001g!)q/\ba\u0001g\u0001")
public interface VectorPointer<T> {
    public int depth();

    public void depth_$eq(int var1);

    public Object[] display0();

    public void display0_$eq(Object[] var1);

    public Object[] display1();

    public void display1_$eq(Object[] var1);

    public Object[] display2();

    public void display2_$eq(Object[] var1);

    public Object[] display3();

    public void display3_$eq(Object[] var1);

    public Object[] display4();

    public void display4_$eq(Object[] var1);

    public Object[] display5();

    public void display5_$eq(Object[] var1);

    public static /* synthetic */ void initFrom$(VectorPointer $this, VectorPointer that) {
        $this.initFrom(that);
    }

    default public <U> void initFrom(VectorPointer<U> that) {
        this.initFrom(that, that.depth());
    }

    public static /* synthetic */ void initFrom$(VectorPointer $this, VectorPointer that, int depth) {
        $this.initFrom(that, depth);
    }

    default public <U> void initFrom(VectorPointer<U> that, int depth) {
        this.depth_$eq(depth);
        int n = depth - 1;
        switch (n) {
            case -1: {
                return;
            }
            case 0: {
                this.display0_$eq(that.display0());
                return;
            }
            case 1: {
                this.display1_$eq(that.display1());
                this.display0_$eq(that.display0());
                return;
            }
            case 2: {
                this.display2_$eq(that.display2());
                this.display1_$eq(that.display1());
                this.display0_$eq(that.display0());
                return;
            }
            case 3: {
                this.display3_$eq(that.display3());
                this.display2_$eq(that.display2());
                this.display1_$eq(that.display1());
                this.display0_$eq(that.display0());
                return;
            }
            case 4: {
                this.display4_$eq(that.display4());
                this.display3_$eq(that.display3());
                this.display2_$eq(that.display2());
                this.display1_$eq(that.display1());
                this.display0_$eq(that.display0());
                return;
            }
            case 5: {
                this.display5_$eq(that.display5());
                this.display4_$eq(that.display4());
                this.display3_$eq(that.display3());
                this.display2_$eq(that.display2());
                this.display1_$eq(that.display1());
                this.display0_$eq(that.display0());
                return;
            }
        }
        throw new MatchError(BoxesRunTime.boxToInteger(n));
    }

    public static /* synthetic */ Object getElem$(VectorPointer $this, int index, int xor) {
        return $this.getElem(index, xor);
    }

    default public T getElem(int index, int xor) {
        if (xor < 32) {
            return (T)this.display0()[index & 0x1F];
        }
        if (xor < 1024) {
            return (T)((Object[])this.display1()[index >>> 5 & 0x1F])[index & 0x1F];
        }
        if (xor < 32768) {
            return (T)((Object[])((Object[])this.display2()[index >>> 10 & 0x1F])[index >>> 5 & 0x1F])[index & 0x1F];
        }
        if (xor < 0x100000) {
            return (T)((Object[])((Object[])((Object[])this.display3()[index >>> 15 & 0x1F])[index >>> 10 & 0x1F])[index >>> 5 & 0x1F])[index & 0x1F];
        }
        if (xor < 0x2000000) {
            return (T)((Object[])((Object[])((Object[])((Object[])this.display4()[index >>> 20 & 0x1F])[index >>> 15 & 0x1F])[index >>> 10 & 0x1F])[index >>> 5 & 0x1F])[index & 0x1F];
        }
        if (xor < 0x40000000) {
            return (T)((Object[])((Object[])((Object[])((Object[])((Object[])this.display5()[index >>> 25 & 0x1F])[index >>> 20 & 0x1F])[index >>> 15 & 0x1F])[index >>> 10 & 0x1F])[index >>> 5 & 0x1F])[index & 0x1F];
        }
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ void gotoPos$(VectorPointer $this, int index, int xor) {
        $this.gotoPos(index, xor);
    }

    default public void gotoPos(int index, int xor) {
        if (xor >= 32) {
            if (xor < 1024) {
                this.display0_$eq((Object[])this.display1()[index >>> 5 & 0x1F]);
                return;
            }
            if (xor < 32768) {
                this.display1_$eq((Object[])this.display2()[index >>> 10 & 0x1F]);
                this.display0_$eq((Object[])this.display1()[index >>> 5 & 0x1F]);
                return;
            }
            if (xor < 0x100000) {
                this.display2_$eq((Object[])this.display3()[index >>> 15 & 0x1F]);
                this.display1_$eq((Object[])this.display2()[index >>> 10 & 0x1F]);
                this.display0_$eq((Object[])this.display1()[index >>> 5 & 0x1F]);
                return;
            }
            if (xor < 0x2000000) {
                this.display3_$eq((Object[])this.display4()[index >>> 20 & 0x1F]);
                this.display2_$eq((Object[])this.display3()[index >>> 15 & 0x1F]);
                this.display1_$eq((Object[])this.display2()[index >>> 10 & 0x1F]);
                this.display0_$eq((Object[])this.display1()[index >>> 5 & 0x1F]);
                return;
            }
            if (xor < 0x40000000) {
                this.display4_$eq((Object[])this.display5()[index >>> 25 & 0x1F]);
                this.display3_$eq((Object[])this.display4()[index >>> 20 & 0x1F]);
                this.display2_$eq((Object[])this.display3()[index >>> 15 & 0x1F]);
                this.display1_$eq((Object[])this.display2()[index >>> 10 & 0x1F]);
                this.display0_$eq((Object[])this.display1()[index >>> 5 & 0x1F]);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public static /* synthetic */ void gotoNextBlockStart$(VectorPointer $this, int index, int xor) {
        $this.gotoNextBlockStart(index, xor);
    }

    default public void gotoNextBlockStart(int index, int xor) {
        if (xor < 1024) {
            this.display0_$eq((Object[])this.display1()[index >>> 5 & 0x1F]);
            return;
        }
        if (xor < 32768) {
            this.display1_$eq((Object[])this.display2()[index >>> 10 & 0x1F]);
            this.display0_$eq((Object[])this.display1()[0]);
            return;
        }
        if (xor < 0x100000) {
            this.display2_$eq((Object[])this.display3()[index >>> 15 & 0x1F]);
            this.display1_$eq((Object[])this.display2()[0]);
            this.display0_$eq((Object[])this.display1()[0]);
            return;
        }
        if (xor < 0x2000000) {
            this.display3_$eq((Object[])this.display4()[index >>> 20 & 0x1F]);
            this.display2_$eq((Object[])this.display3()[0]);
            this.display1_$eq((Object[])this.display2()[0]);
            this.display0_$eq((Object[])this.display1()[0]);
            return;
        }
        if (xor < 0x40000000) {
            this.display4_$eq((Object[])this.display5()[index >>> 25 & 0x1F]);
            this.display3_$eq((Object[])this.display4()[0]);
            this.display2_$eq((Object[])this.display3()[0]);
            this.display1_$eq((Object[])this.display2()[0]);
            this.display0_$eq((Object[])this.display1()[0]);
            return;
        }
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ void gotoNextBlockStartWritable$(VectorPointer $this, int index, int xor) {
        $this.gotoNextBlockStartWritable(index, xor);
    }

    default public void gotoNextBlockStartWritable(int index, int xor) {
        if (xor < 1024) {
            if (this.depth() == 1) {
                this.display1_$eq(new Object[32]);
                this.display1()[0] = this.display0();
                this.depth_$eq(this.depth() + 1);
            }
            this.display0_$eq(new Object[32]);
            this.display1()[index >>> 5 & 0x1F] = this.display0();
            return;
        }
        if (xor < 32768) {
            if (this.depth() == 2) {
                this.display2_$eq(new Object[32]);
                this.display2()[0] = this.display1();
                this.depth_$eq(this.depth() + 1);
            }
            this.display0_$eq(new Object[32]);
            this.display1_$eq(new Object[32]);
            this.display1()[index >>> 5 & 0x1F] = this.display0();
            this.display2()[index >>> 10 & 0x1F] = this.display1();
            return;
        }
        if (xor < 0x100000) {
            if (this.depth() == 3) {
                this.display3_$eq(new Object[32]);
                this.display3()[0] = this.display2();
                this.depth_$eq(this.depth() + 1);
            }
            this.display0_$eq(new Object[32]);
            this.display1_$eq(new Object[32]);
            this.display2_$eq(new Object[32]);
            this.display1()[index >>> 5 & 0x1F] = this.display0();
            this.display2()[index >>> 10 & 0x1F] = this.display1();
            this.display3()[index >>> 15 & 0x1F] = this.display2();
            return;
        }
        if (xor < 0x2000000) {
            if (this.depth() == 4) {
                this.display4_$eq(new Object[32]);
                this.display4()[0] = this.display3();
                this.depth_$eq(this.depth() + 1);
            }
            this.display0_$eq(new Object[32]);
            this.display1_$eq(new Object[32]);
            this.display2_$eq(new Object[32]);
            this.display3_$eq(new Object[32]);
            this.display1()[index >>> 5 & 0x1F] = this.display0();
            this.display2()[index >>> 10 & 0x1F] = this.display1();
            this.display3()[index >>> 15 & 0x1F] = this.display2();
            this.display4()[index >>> 20 & 0x1F] = this.display3();
            return;
        }
        if (xor < 0x40000000) {
            if (this.depth() == 5) {
                this.display5_$eq(new Object[32]);
                this.display5()[0] = this.display4();
                this.depth_$eq(this.depth() + 1);
            }
            this.display0_$eq(new Object[32]);
            this.display1_$eq(new Object[32]);
            this.display2_$eq(new Object[32]);
            this.display3_$eq(new Object[32]);
            this.display4_$eq(new Object[32]);
            this.display1()[index >>> 5 & 0x1F] = this.display0();
            this.display2()[index >>> 10 & 0x1F] = this.display1();
            this.display3()[index >>> 15 & 0x1F] = this.display2();
            this.display4()[index >>> 20 & 0x1F] = this.display3();
            this.display5()[index >>> 25 & 0x1F] = this.display4();
            return;
        }
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ Object[] copyOf$(VectorPointer $this, Object[] a) {
        return $this.copyOf(a);
    }

    /*
     * WARNING - void declaration
     */
    default public Object[] copyOf(Object[] a) {
        void var2_2;
        Object[] copy = new Object[a.length];
        System.arraycopy(a, 0, copy, 0, a.length);
        return var2_2;
    }

    public static /* synthetic */ Object[] nullSlotAndCopy$(VectorPointer $this, Object[] array, int index) {
        return $this.nullSlotAndCopy(array, index);
    }

    default public Object[] nullSlotAndCopy(Object[] array, int index) {
        Object x = array[index];
        array[index] = null;
        return this.copyOf((Object[])x);
    }

    public static /* synthetic */ void stabilize$(VectorPointer $this, int index) {
        $this.stabilize(index);
    }

    default public void stabilize(int index) {
        int n = this.depth() - 1;
        switch (n) {
            case 5: {
                this.display5_$eq(this.copyOf(this.display5()));
                this.display4_$eq(this.copyOf(this.display4()));
                this.display3_$eq(this.copyOf(this.display3()));
                this.display2_$eq(this.copyOf(this.display2()));
                this.display1_$eq(this.copyOf(this.display1()));
                this.display5()[index >>> 25 & 0x1F] = this.display4();
                this.display4()[index >>> 20 & 0x1F] = this.display3();
                this.display3()[index >>> 15 & 0x1F] = this.display2();
                this.display2()[index >>> 10 & 0x1F] = this.display1();
                this.display1()[index >>> 5 & 0x1F] = this.display0();
                return;
            }
            case 4: {
                this.display4_$eq(this.copyOf(this.display4()));
                this.display3_$eq(this.copyOf(this.display3()));
                this.display2_$eq(this.copyOf(this.display2()));
                this.display1_$eq(this.copyOf(this.display1()));
                this.display4()[index >>> 20 & 0x1F] = this.display3();
                this.display3()[index >>> 15 & 0x1F] = this.display2();
                this.display2()[index >>> 10 & 0x1F] = this.display1();
                this.display1()[index >>> 5 & 0x1F] = this.display0();
                return;
            }
            case 3: {
                this.display3_$eq(this.copyOf(this.display3()));
                this.display2_$eq(this.copyOf(this.display2()));
                this.display1_$eq(this.copyOf(this.display1()));
                this.display3()[index >>> 15 & 0x1F] = this.display2();
                this.display2()[index >>> 10 & 0x1F] = this.display1();
                this.display1()[index >>> 5 & 0x1F] = this.display0();
                return;
            }
            case 2: {
                this.display2_$eq(this.copyOf(this.display2()));
                this.display1_$eq(this.copyOf(this.display1()));
                this.display2()[index >>> 10 & 0x1F] = this.display1();
                this.display1()[index >>> 5 & 0x1F] = this.display0();
                return;
            }
            case 1: {
                this.display1_$eq(this.copyOf(this.display1()));
                this.display1()[index >>> 5 & 0x1F] = this.display0();
                return;
            }
            case 0: {
                return;
            }
        }
        throw new MatchError(BoxesRunTime.boxToInteger(n));
    }

    public static /* synthetic */ void gotoPosWritable0$(VectorPointer $this, int newIndex, int xor) {
        $this.gotoPosWritable0(newIndex, xor);
    }

    default public void gotoPosWritable0(int newIndex, int xor) {
        int n = this.depth() - 1;
        switch (n) {
            case 5: {
                this.display5_$eq(this.copyOf(this.display5()));
                this.display4_$eq(this.nullSlotAndCopy(this.display5(), newIndex >>> 25 & 0x1F));
                this.display3_$eq(this.nullSlotAndCopy(this.display4(), newIndex >>> 20 & 0x1F));
                this.display2_$eq(this.nullSlotAndCopy(this.display3(), newIndex >>> 15 & 0x1F));
                this.display1_$eq(this.nullSlotAndCopy(this.display2(), newIndex >>> 10 & 0x1F));
                this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
                return;
            }
            case 4: {
                this.display4_$eq(this.copyOf(this.display4()));
                this.display3_$eq(this.nullSlotAndCopy(this.display4(), newIndex >>> 20 & 0x1F));
                this.display2_$eq(this.nullSlotAndCopy(this.display3(), newIndex >>> 15 & 0x1F));
                this.display1_$eq(this.nullSlotAndCopy(this.display2(), newIndex >>> 10 & 0x1F));
                this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
                return;
            }
            case 3: {
                this.display3_$eq(this.copyOf(this.display3()));
                this.display2_$eq(this.nullSlotAndCopy(this.display3(), newIndex >>> 15 & 0x1F));
                this.display1_$eq(this.nullSlotAndCopy(this.display2(), newIndex >>> 10 & 0x1F));
                this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
                return;
            }
            case 2: {
                this.display2_$eq(this.copyOf(this.display2()));
                this.display1_$eq(this.nullSlotAndCopy(this.display2(), newIndex >>> 10 & 0x1F));
                this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
                return;
            }
            case 1: {
                this.display1_$eq(this.copyOf(this.display1()));
                this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
                return;
            }
            case 0: {
                this.display0_$eq(this.copyOf(this.display0()));
                return;
            }
        }
        throw new MatchError(BoxesRunTime.boxToInteger(n));
    }

    public static /* synthetic */ void gotoPosWritable1$(VectorPointer $this, int oldIndex, int newIndex, int xor) {
        $this.gotoPosWritable1(oldIndex, newIndex, xor);
    }

    default public void gotoPosWritable1(int oldIndex, int newIndex, int xor) {
        if (xor < 32) {
            this.display0_$eq(this.copyOf(this.display0()));
            return;
        }
        if (xor < 1024) {
            this.display1_$eq(this.copyOf(this.display1()));
            this.display1()[oldIndex >>> 5 & 0x1F] = this.display0();
            this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
            return;
        }
        if (xor < 32768) {
            this.display1_$eq(this.copyOf(this.display1()));
            this.display2_$eq(this.copyOf(this.display2()));
            this.display1()[oldIndex >>> 5 & 0x1F] = this.display0();
            this.display2()[oldIndex >>> 10 & 0x1F] = this.display1();
            this.display1_$eq(this.nullSlotAndCopy(this.display2(), newIndex >>> 10 & 0x1F));
            this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
            return;
        }
        if (xor < 0x100000) {
            this.display1_$eq(this.copyOf(this.display1()));
            this.display2_$eq(this.copyOf(this.display2()));
            this.display3_$eq(this.copyOf(this.display3()));
            this.display1()[oldIndex >>> 5 & 0x1F] = this.display0();
            this.display2()[oldIndex >>> 10 & 0x1F] = this.display1();
            this.display3()[oldIndex >>> 15 & 0x1F] = this.display2();
            this.display2_$eq(this.nullSlotAndCopy(this.display3(), newIndex >>> 15 & 0x1F));
            this.display1_$eq(this.nullSlotAndCopy(this.display2(), newIndex >>> 10 & 0x1F));
            this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
            return;
        }
        if (xor < 0x2000000) {
            this.display1_$eq(this.copyOf(this.display1()));
            this.display2_$eq(this.copyOf(this.display2()));
            this.display3_$eq(this.copyOf(this.display3()));
            this.display4_$eq(this.copyOf(this.display4()));
            this.display1()[oldIndex >>> 5 & 0x1F] = this.display0();
            this.display2()[oldIndex >>> 10 & 0x1F] = this.display1();
            this.display3()[oldIndex >>> 15 & 0x1F] = this.display2();
            this.display4()[oldIndex >>> 20 & 0x1F] = this.display3();
            this.display3_$eq(this.nullSlotAndCopy(this.display4(), newIndex >>> 20 & 0x1F));
            this.display2_$eq(this.nullSlotAndCopy(this.display3(), newIndex >>> 15 & 0x1F));
            this.display1_$eq(this.nullSlotAndCopy(this.display2(), newIndex >>> 10 & 0x1F));
            this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
            return;
        }
        if (xor < 0x40000000) {
            this.display1_$eq(this.copyOf(this.display1()));
            this.display2_$eq(this.copyOf(this.display2()));
            this.display3_$eq(this.copyOf(this.display3()));
            this.display4_$eq(this.copyOf(this.display4()));
            this.display5_$eq(this.copyOf(this.display5()));
            this.display1()[oldIndex >>> 5 & 0x1F] = this.display0();
            this.display2()[oldIndex >>> 10 & 0x1F] = this.display1();
            this.display3()[oldIndex >>> 15 & 0x1F] = this.display2();
            this.display4()[oldIndex >>> 20 & 0x1F] = this.display3();
            this.display5()[oldIndex >>> 25 & 0x1F] = this.display4();
            this.display4_$eq(this.nullSlotAndCopy(this.display5(), newIndex >>> 25 & 0x1F));
            this.display3_$eq(this.nullSlotAndCopy(this.display4(), newIndex >>> 20 & 0x1F));
            this.display2_$eq(this.nullSlotAndCopy(this.display3(), newIndex >>> 15 & 0x1F));
            this.display1_$eq(this.nullSlotAndCopy(this.display2(), newIndex >>> 10 & 0x1F));
            this.display0_$eq(this.nullSlotAndCopy(this.display1(), newIndex >>> 5 & 0x1F));
            return;
        }
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ Object[] copyRange$(VectorPointer $this, Object[] array, int oldLeft, int newLeft) {
        return $this.copyRange(array, oldLeft, newLeft);
    }

    default public Object[] copyRange(Object[] array, int oldLeft, int newLeft) {
        Object[] elems = new Object[32];
        System.arraycopy(array, oldLeft, elems, newLeft, 32 - package$.MODULE$.max(newLeft, oldLeft));
        return elems;
    }

    public static /* synthetic */ void gotoFreshPosWritable0$(VectorPointer $this, int oldIndex, int newIndex, int xor) {
        $this.gotoFreshPosWritable0(oldIndex, newIndex, xor);
    }

    default public void gotoFreshPosWritable0(int oldIndex, int newIndex, int xor) {
        if (xor >= 32) {
            if (xor < 1024) {
                if (this.depth() == 1) {
                    this.display1_$eq(new Object[32]);
                    this.display1()[oldIndex >>> 5 & 0x1F] = this.display0();
                    this.depth_$eq(this.depth() + 1);
                }
                this.display0_$eq(new Object[32]);
                return;
            }
            if (xor < 32768) {
                if (this.depth() == 2) {
                    this.display2_$eq(new Object[32]);
                    this.display2()[oldIndex >>> 10 & 0x1F] = this.display1();
                    this.depth_$eq(this.depth() + 1);
                }
                this.display1_$eq((Object[])this.display2()[newIndex >>> 10 & 0x1F]);
                if (this.display1() == null) {
                    this.display1_$eq(new Object[32]);
                }
                this.display0_$eq(new Object[32]);
                return;
            }
            if (xor < 0x100000) {
                if (this.depth() == 3) {
                    this.display3_$eq(new Object[32]);
                    this.display3()[oldIndex >>> 15 & 0x1F] = this.display2();
                    this.depth_$eq(this.depth() + 1);
                }
                this.display2_$eq((Object[])this.display3()[newIndex >>> 15 & 0x1F]);
                if (this.display2() == null) {
                    this.display2_$eq(new Object[32]);
                }
                this.display1_$eq((Object[])this.display2()[newIndex >>> 10 & 0x1F]);
                if (this.display1() == null) {
                    this.display1_$eq(new Object[32]);
                }
                this.display0_$eq(new Object[32]);
                return;
            }
            if (xor < 0x2000000) {
                if (this.depth() == 4) {
                    this.display4_$eq(new Object[32]);
                    this.display4()[oldIndex >>> 20 & 0x1F] = this.display3();
                    this.depth_$eq(this.depth() + 1);
                }
                this.display3_$eq((Object[])this.display4()[newIndex >>> 20 & 0x1F]);
                if (this.display3() == null) {
                    this.display3_$eq(new Object[32]);
                }
                this.display2_$eq((Object[])this.display3()[newIndex >>> 15 & 0x1F]);
                if (this.display2() == null) {
                    this.display2_$eq(new Object[32]);
                }
                this.display1_$eq((Object[])this.display2()[newIndex >>> 10 & 0x1F]);
                if (this.display1() == null) {
                    this.display1_$eq(new Object[32]);
                }
                this.display0_$eq(new Object[32]);
                return;
            }
            if (xor < 0x40000000) {
                if (this.depth() == 5) {
                    this.display5_$eq(new Object[32]);
                    this.display5()[oldIndex >>> 25 & 0x1F] = this.display4();
                    this.depth_$eq(this.depth() + 1);
                }
                this.display4_$eq((Object[])this.display5()[newIndex >>> 25 & 0x1F]);
                if (this.display4() == null) {
                    this.display4_$eq(new Object[32]);
                }
                this.display3_$eq((Object[])this.display4()[newIndex >>> 20 & 0x1F]);
                if (this.display3() == null) {
                    this.display3_$eq(new Object[32]);
                }
                this.display2_$eq((Object[])this.display3()[newIndex >>> 15 & 0x1F]);
                if (this.display2() == null) {
                    this.display2_$eq(new Object[32]);
                }
                this.display1_$eq((Object[])this.display2()[newIndex >>> 10 & 0x1F]);
                if (this.display1() == null) {
                    this.display1_$eq(new Object[32]);
                }
                this.display0_$eq(new Object[32]);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public static /* synthetic */ void gotoFreshPosWritable1$(VectorPointer $this, int oldIndex, int newIndex, int xor) {
        $this.gotoFreshPosWritable1(oldIndex, newIndex, xor);
    }

    default public void gotoFreshPosWritable1(int oldIndex, int newIndex, int xor) {
        this.stabilize(oldIndex);
        this.gotoFreshPosWritable0(oldIndex, newIndex, xor);
    }

    public static void $init$(VectorPointer $this) {
    }
}

