/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import scala.MatchError;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.JMethodOrConstructor$;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001i4AAD\b\u0001-!A1\u0004\u0001BC\u0002\u0013\u0005A\u0004\u0003\u0005-\u0001\t\u0005\t\u0015!\u0003\u001e\u0011\u0015i\u0003\u0001\"\u0001/\u0011\u0015!\u0004\u0001\"\u00016\u0011\u0015I\u0004\u0001\"\u0001;\u0011\u0015\u0019\u0006\u0001\"\u0001U\u0011\u0015I\u0006\u0001\"\u0001[\u0011\u0015\u0019\u0007\u0001\"\u0001e\u000f\u0015)w\u0002#\u0001g\r\u0015qq\u0002#\u0001h\u0011\u0015i#\u0002\"\u0001i\u0011\u0015I'\u0002b\u0001k\u0011\u0015\u0001(\u0002b\u0001r\u0005QQU*\u001a;i_\u0012|%oQ8ogR\u0014Xo\u0019;pe*\u0011\u0001#E\u0001\tS:$XM\u001d8bY*\u0011!cE\u0001\be\u00164G.Z2u\u0015\u0005!\u0012!B:dC2\f7\u0001A\n\u0003\u0001]\u0001\"\u0001G\r\u000e\u0003MI!AG\n\u0003\r\u0005s\u0017PU3g\u0003\u0019iW-\u001c2feV\tQDE\u0002\u001fA%2Aa\b\u0001\u0001;\taAH]3gS:,W.\u001a8u}A\u0011\u0011eJ\u0007\u0002E)\u0011!c\t\u0006\u0003I\u0015\nA\u0001\\1oO*\ta%\u0001\u0003kCZ\f\u0017B\u0001\u0015#\u0005\u0019iU-\u001c2feB\u0011\u0011EK\u0005\u0003W\t\u0012\u0001#\u00118o_R\fG/\u001a3FY\u0016lWM\u001c;\u0002\u000f5,WNY3sA\u00051A(\u001b8jiz\"\"aL\u0019\u0011\u0005A\u0002Q\"A\b\t\u000bm\u0019\u0001\u0019\u0001\u001a\u0013\u0007M\u0002\u0013F\u0002\u0003 \u0001\u0001\u0011\u0014!C5t-\u0006\u0014\u0018I]4t+\u00051\u0004C\u0001\r8\u0013\tA4CA\u0004C_>dW-\u00198\u0002\u0015QL\b/\u001a)be\u0006l7/F\u0001<a\ta\u0014\tE\u0002\u0019{}J!AP\n\u0003\u000b\u0005\u0013(/Y=\u0011\u0005\u0001\u000bE\u0002\u0001\u0003\n\u0005\u0016\t\t\u0011!A\u0003\u0002\r\u00131a\u0018\u00132#\t!u\t\u0005\u0002\u0019\u000b&\u0011ai\u0005\u0002\b\u001d>$\b.\u001b8ha\tAE\nE\u0002\"\u0013.K!A\u0013\u0012\u0003\u0019QK\b/\u001a,be&\f'\r\\3\u0011\u0005\u0001cE!C'O\u0003\u0003\u0005\tQ!\u0001P\u0005\ryFE\r\u0003\n\u0005\u0016\t\t1!A\u0003\u0002\r\u000b\"\u0001\u0012)\u0011\u0005a\t\u0016B\u0001*\u0014\u0005\r\te._\u0001\u000ba\u0006\u0014\u0018-\u001c+za\u0016\u001cX#A+\u0011\u0007aid\u000b\u0005\u0002\"/&\u0011\u0001L\t\u0002\u0005)f\u0004X-\u0001\tqCJ\fW.\u00118o_R\fG/[8ogV\t1\fE\u0002\u0019{q\u00032\u0001G\u001f^!\tq\u0016-D\u0001`\u0015\t\u00017%\u0001\u0006b]:|G/\u0019;j_:L!AY0\u0003\u0015\u0005sgn\u001c;bi&|g.\u0001\u0006sKN,H\u000e\u001e+za\u0016,\u0012AV\u0001\u0015\u00156+G\u000f[8e\u001fJ\u001cuN\\:ueV\u001cGo\u001c:\u0011\u0005AR1C\u0001\u0006\u0018)\u00051\u0017\u0001\u00057jMRlU\r\u001e5pIR{'*\\8d)\ty3\u000eC\u0003m\u0019\u0001\u0007Q.A\u0001n!\t\tc.\u0003\u0002pE\t1Q*\u001a;i_\u0012\fQ\u0003\\5gi\u000e{gn\u001d;sk\u000e$xN\u001d+p\u00156|7\r\u0006\u00020e\")A.\u0004a\u0001gB\u0012A\u000f\u001f\t\u0004CU<\u0018B\u0001<#\u0005-\u0019uN\\:ueV\u001cGo\u001c:\u0011\u0005\u0001CH!C=s\u0003\u0003\u0005\tQ!\u0001P\u0005\ryFe\r")
public class JMethodOrConstructor {
    private final Member member;

    public static JMethodOrConstructor liftConstructorToJmoc(Constructor<?> constructor) {
        return JMethodOrConstructor$.MODULE$.liftConstructorToJmoc(constructor);
    }

    public static JMethodOrConstructor liftMethodToJmoc(Method method) {
        return JMethodOrConstructor$.MODULE$.liftMethodToJmoc(method);
    }

    public Member member() {
        return this.member;
    }

    public boolean isVarArgs() {
        boolean bl;
        Member member = this.member();
        if (member instanceof Method) {
            bl = ((Method)member).isVarArgs();
        } else if (member instanceof Constructor) {
            bl = ((Constructor)member).isVarArgs();
        } else {
            throw new MatchError(member);
        }
        return bl;
    }

    public TypeVariable[] typeParams() {
        TypeVariable[] typeVariableArray;
        Member member = this.member();
        if (member instanceof Method) {
            typeVariableArray = ((Method)member).getTypeParameters();
        } else if (member instanceof Constructor) {
            typeVariableArray = ((Constructor)member).getTypeParameters();
        } else {
            throw new MatchError(member);
        }
        return typeVariableArray;
    }

    public Type[] paramTypes() {
        Type[] typeArray;
        Member member = this.member();
        if (member instanceof Method) {
            typeArray = ((Method)member).getGenericParameterTypes();
        } else if (member instanceof Constructor) {
            typeArray = ((Constructor)member).getGenericParameterTypes();
        } else {
            throw new MatchError(member);
        }
        return typeArray;
    }

    public Annotation[][] paramAnnotations() {
        Annotation[][] annotationArray;
        Member member = this.member();
        if (member instanceof Method) {
            annotationArray = ((Method)member).getParameterAnnotations();
        } else if (member instanceof Constructor) {
            annotationArray = ((Constructor)member).getParameterAnnotations();
        } else {
            throw new MatchError(member);
        }
        return annotationArray;
    }

    public Type resultType() {
        Class<Void> clazz;
        Member member = this.member();
        if (member instanceof Method) {
            clazz = ((Method)member).getGenericReturnType();
        } else if (member instanceof Constructor) {
            clazz = BoxedUnit.TYPE;
        } else {
            throw new MatchError(member);
        }
        return clazz;
    }

    public JMethodOrConstructor(Member member) {
        this.member = member;
    }
}

