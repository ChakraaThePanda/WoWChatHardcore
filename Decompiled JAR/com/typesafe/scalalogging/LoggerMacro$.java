/*
 * Decompiled with CFR 0.152.
 */
package com.typesafe.scalalogging;

import com.typesafe.scalalogging.LoggerMacro$;
import java.io.Serializable;
import java.lang.invoke.CallSite;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.slf4j.Marker;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Some;
import scala.StringContext$;
import scala.Tuple2;
import scala.collection.GenTraversableOnce;
import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.TraversableLike;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Set$;
import scala.reflect.api.Constants;
import scala.reflect.api.Exprs;
import scala.reflect.api.Names;
import scala.reflect.api.Trees;
import scala.reflect.internal.SymbolTable;
import scala.reflect.internal.Trees;
import scala.reflect.macros.Universe;
import scala.reflect.macros.blackbox.Context;
import scala.runtime.BoxedUnit;
import scala.runtime.Nothing$;
import scala.runtime.ScalaRunTime$;
import scala.runtime.StructuralCallSite;

public final class LoggerMacro$ {
    public static LoggerMacro$ MODULE$;

    static {
        new LoggerMacro$();
    }

    public Trees.TreeApi errorMessage(Context c, Exprs.Expr<String> message) {
        Exprs.Expr<String> expr = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.errorMessageArgs(c, messageFormat2, args3);
    }

    public Trees.TreeApi errorMessageCause(Context c, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<String> expr = message;
        Exprs.Expr<Throwable> expr2 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isErrorEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("error")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi errorMessageArgs(Context c, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<String> expr = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isErrorEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("error")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isErrorEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("error")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$11 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$11), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi errorMessageMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr2);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.errorMessageArgsMarker(c, expr, messageFormat2, args3);
    }

    public Trees.TreeApi errorMessageCauseMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Exprs.Expr<Throwable> expr3 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isErrorEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("error")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr3)), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi errorMessageArgsMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isErrorEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("error")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isErrorEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("error")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$)).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$15 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$15), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi errorCode(Context c, Exprs.Expr<BoxedUnit> body) {
        Exprs.Expr<BoxedUnit> expr = body;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isErrorEnabled")), c.universe().Liftable().liftExpr().apply(expr), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi warnMessage(Context c, Exprs.Expr<String> message) {
        Exprs.Expr<String> expr = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.warnMessageArgs(c, messageFormat2, args3);
    }

    public Trees.TreeApi warnMessageCause(Context c, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<String> expr = message;
        Exprs.Expr<Throwable> expr2 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isWarnEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("warn")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi warnMessageArgs(Context c, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<String> expr = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isWarnEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("warn")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isWarnEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("warn")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$11 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$11), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi warnMessageMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr2);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.warnMessageArgsMarker(c, expr, messageFormat2, args3);
    }

    public Trees.TreeApi warnMessageCauseMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Exprs.Expr<Throwable> expr3 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isWarnEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("warn")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr3)), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi warnMessageArgsMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isWarnEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("warn")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isWarnEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("warn")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$)).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$15 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$15), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi warnCode(Context c, Exprs.Expr<BoxedUnit> body) {
        Exprs.Expr<BoxedUnit> expr = body;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isWarnEnabled")), c.universe().Liftable().liftExpr().apply(expr), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi infoMessage(Context c, Exprs.Expr<String> message) {
        Exprs.Expr<String> expr = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.infoMessageArgs(c, messageFormat2, args3);
    }

    public Trees.TreeApi infoMessageCause(Context c, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<String> expr = message;
        Exprs.Expr<Throwable> expr2 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isInfoEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("info")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi infoMessageArgs(Context c, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<String> expr = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isInfoEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("info")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isInfoEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("info")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$11 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$11), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi infoMessageMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr2);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.infoMessageArgsMarker(c, expr, messageFormat2, args3);
    }

    public Trees.TreeApi infoMessageCauseMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Exprs.Expr<Throwable> expr3 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isInfoEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("info")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr3)), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi infoMessageArgsMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isInfoEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("info")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isInfoEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("info")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$)).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$15 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$15), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi infoCode(Context c, Exprs.Expr<BoxedUnit> body) {
        Exprs.Expr<BoxedUnit> expr = body;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isInfoEnabled")), c.universe().Liftable().liftExpr().apply(expr), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi debugMessage(Context c, Exprs.Expr<String> message) {
        Exprs.Expr<String> expr = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.debugMessageArgs(c, messageFormat2, args3);
    }

    public Trees.TreeApi debugMessageCause(Context c, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<String> expr = message;
        Exprs.Expr<Throwable> expr2 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isDebugEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("debug")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi debugMessageArgs(Context c, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<String> expr = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isDebugEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("debug")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isDebugEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("debug")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$11 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$11), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi debugMessageMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr2);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.debugMessageArgsMarker(c, expr, messageFormat2, args3);
    }

    public Trees.TreeApi debugMessageCauseMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Exprs.Expr<Throwable> expr3 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isDebugEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("debug")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr3)), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi debugMessageArgsMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isDebugEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("debug")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isDebugEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("debug")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$)).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$15 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$15), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi debugCode(Context c, Exprs.Expr<BoxedUnit> body) {
        Exprs.Expr<BoxedUnit> expr = body;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isDebugEnabled")), c.universe().Liftable().liftExpr().apply(expr), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi traceMessage(Context c, Exprs.Expr<String> message) {
        Exprs.Expr<String> expr = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.traceMessageArgs(c, messageFormat2, args3);
    }

    public Trees.TreeApi traceMessageCause(Context c, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<String> expr = message;
        Exprs.Expr<Throwable> expr2 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isTraceEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("trace")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi traceMessageArgs(Context c, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<String> expr = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isTraceEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("trace")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isTraceEnabled")), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("trace")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$11 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$11), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi traceMessageMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple2 = this.deconstructInterpolatedMessage(c, expr2);
        if (tuple2 == null) {
            throw new MatchError(tuple2);
        }
        Exprs.Expr<String> messageFormat = tuple2._1();
        Seq<Exprs.Expr<Object>> args2 = tuple2._2();
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple22 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(messageFormat, args2);
        Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> tuple23 = tuple22;
        Exprs.Expr<String> messageFormat2 = tuple23._1();
        Seq<Exprs.Expr<Object>> args3 = tuple23._2();
        return this.traceMessageArgsMarker(c, expr, messageFormat2, args3);
    }

    public Trees.TreeApi traceMessageCauseMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Exprs.Expr<Throwable> cause) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Exprs.Expr<Throwable> expr3 = cause;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isTraceEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("trace")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr3)), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi traceMessageArgsMarker(Context c, Exprs.Expr<Marker> marker, Exprs.Expr<String> message, Seq<Exprs.Expr<Object>> args2) {
        Exprs.Expr<Marker> expr = marker;
        Exprs.Expr<String> expr2 = message;
        Seq<Exprs.Expr<Object>> seq = args2;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        Seq<Exprs.Expr<Object>> anyRefArgs = this.formatArgs(c, seq);
        return seq.length() == 2 ? c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isTraceEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("trace")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Typed().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TermName().apply("Array")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.head())), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(anyRefArgs.apply(true))), Nil$.MODULE$))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticTypeIdent().apply(c.universe().TypeName().apply("_*")))), Nil$.MODULE$)))), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$)) : c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isTraceEnabled")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), Nil$.MODULE$)), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("trace")), new $colon$colon<Nothing$>((Nothing$)((Object)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr)), (List<Nothing$>)new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().Liftable().liftExpr().apply(expr2)), Nil$.MODULE$)).$plus$plus((GenTraversableOnce<Nothing$>)anyRefArgs.toList().map((Function1<Exprs.Expr, Trees.TreeApi> & Serializable & scala.Serializable)fresh$macro$15 -> c.universe().Liftable().liftExpr().apply((Exprs.Expr)fresh$macro$15), List$.MODULE$.canBuildFrom()), List$.MODULE$.canBuildFrom())), Nil$.MODULE$)), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    public Trees.TreeApi traceCode(Context c, Exprs.Expr<BoxedUnit> body) {
        Exprs.Expr<BoxedUnit> expr = body;
        Trees.SelectApi underlying = c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply(c.prefix()), c.universe().TermName().apply("underlying"));
        return c.universe().If().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(underlying, c.universe().TermName().apply("isTraceEnabled")), c.universe().Liftable().liftExpr().apply(expr), c.universe().internal().reificationSupport().SyntacticBlock().apply(Nil$.MODULE$));
    }

    private Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>> deconstructInterpolatedMessage(Context c, Exprs.Expr<String> message) {
        Tuple2<Exprs.Expr<Object>, Seq<Exprs.Expr<Object>>> tuple2;
        Exprs.Expr<String> expr = message;
        Universe u = c.universe();
        SymbolTable uInternal = (SymbolTable)u;
        Trees.TreeApi tree = (Trees.TreeApi)((TraversableLike)((Trees.Tree)expr.tree()).attachments().all().collect(new scala.Serializable(){
            public static final long serialVersionUID = 0L;

            public static Method reflMethod$Method1(Class x$1) {
                CallSite methodCache1 = StructuralCallSite.bootstrap("apply", ()Ljava/lang/Object;);
                Method method1 = ((StructuralCallSite)((Object)methodCache1)).find(x$1);
                if (method1 != null) {
                    return method1;
                }
                method1 = ScalaRunTime$.MODULE$.ensureAccessible(x$1.getMethod("expandee", ((StructuralCallSite)((Object)methodCache1)).parameterTypes()));
                ((StructuralCallSite)((Object)methodCache1)).add(x$1, method1);
                return method1;
            }

            public final <A1, B1> B1 applyOrElse(A1 x1, Function1<A1, B1> function1) {
                Object object;
                A1 A1 = x1;
                String string = A1.getClass().getSimpleName();
                String string2 = "MacroExpansionAttachment";
                if (!(string != null ? !string.equals(string2) : string2 != null)) {
                    Object object2;
                    A1 qual1 = A1;
                    try {
                        object2 = anonfun.1.reflMethod$Method1(qual1.getClass()).invoke(qual1, new Object[0]);
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        throw invocationTargetException.getCause();
                    }
                    object = (Trees.Tree)object2;
                } else {
                    object = function1.apply(x1);
                }
                return object;
            }

            public final boolean isDefinedAt(Object x1) {
                Object object = x1;
                String string = object.getClass().getSimpleName();
                String string2 = "MacroExpansionAttachment";
                boolean bl = !(string != null ? !string.equals(string2) : string2 != null);
                return bl;
            }
        }, Set$.MODULE$.canBuildFrom())).headOption().getOrElse((Function0<Trees.TreeApi> & Serializable & scala.Serializable)() -> expr.tree());
        Trees.TreeApi treeApi = tree;
        Option<Tuple2<List<Trees.TreeApi>, List<Trees.TreeApi>>> option = new Object(u){
            private final Universe u$1;

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             */
            public Option<Tuple2<List<Trees.TreeApi>, List<Trees.TreeApi>>> unapply(Object tree) {
                void var2_57;
                Object object = tree;
                Option<Trees.TreeApi> option = this.u$1.TreeTag().unapply(object);
                if (!option.isEmpty()) {
                    Trees.TreeApi treeApi = option.get();
                    Some<Tuple2<Trees.TreeApi, List<List<Trees.TreeApi>>>> some = this.u$1.internal().reificationSupport().SyntacticApplied().unapply(treeApi);
                    if (!some.isEmpty()) {
                        Trees.TreeApi treeApi2 = some.get()._1();
                        List<List<Trees.TreeApi>> list = some.get()._2();
                        Option<Trees.TreeApi> option2 = this.u$1.TreeTag().unapply(treeApi2);
                        if (!option2.isEmpty()) {
                            Trees.TreeApi treeApi3 = option2.get();
                            Option<Tuple2<Trees.TreeApi, Names.TermNameApi>> option3 = this.u$1.internal().reificationSupport().SyntacticSelectTerm().unapply(treeApi3);
                            if (!option3.isEmpty()) {
                                Trees.TreeApi treeApi4 = option3.get()._1();
                                Names.TermNameApi termNameApi = option3.get()._2();
                                Option<Trees.TreeApi> option4 = this.u$1.TreeTag().unapply(treeApi4);
                                if (!option4.isEmpty()) {
                                    Trees.TreeApi treeApi5 = option4.get();
                                    Some<Tuple2<Trees.TreeApi, List<List<Trees.TreeApi>>>> some2 = this.u$1.internal().reificationSupport().SyntacticApplied().unapply(treeApi5);
                                    if (!some2.isEmpty()) {
                                        Trees.TreeApi treeApi6 = some2.get()._1();
                                        List<List<Trees.TreeApi>> list2 = some2.get()._2();
                                        Option<Trees.TreeApi> option5 = this.u$1.TreeTag().unapply(treeApi6);
                                        if (!option5.isEmpty()) {
                                            Trees.TreeApi treeApi7 = option5.get();
                                            Option<Tuple2<Trees.TreeApi, Names.TermNameApi>> option6 = this.u$1.internal().reificationSupport().SyntacticSelectTerm().unapply(treeApi7);
                                            if (!option6.isEmpty()) {
                                                Trees.TreeApi treeApi8 = option6.get()._1();
                                                Names.TermNameApi termNameApi2 = option6.get()._2();
                                                Option<Trees.TreeApi> option7 = this.u$1.TreeTag().unapply(treeApi8);
                                                if (!option7.isEmpty()) {
                                                    Trees.TreeApi treeApi9 = option7.get();
                                                    Option<Tuple2<Trees.TreeApi, Names.TermNameApi>> option8 = this.u$1.internal().reificationSupport().SyntacticSelectTerm().unapply(treeApi9);
                                                    if (!option8.isEmpty()) {
                                                        Trees.TreeApi treeApi10 = option8.get()._1();
                                                        Names.TermNameApi termNameApi3 = option8.get()._2();
                                                        Option<Trees.IdentApi> option9 = this.u$1.IdentTag().unapply(treeApi10);
                                                        if (!option9.isEmpty()) {
                                                            Trees.IdentApi identApi = option9.get();
                                                            Option<Tuple2<Names.TermNameApi, Object>> option10 = this.u$1.internal().reificationSupport().SyntacticTermIdent().unapply(identApi);
                                                            if (!option10.isEmpty()) {
                                                                Names.TermNameApi termNameApi4 = option10.get()._1();
                                                                boolean bl = option10.get()._2$mcZ$sp();
                                                                Option<Names.TermNameApi> option11 = this.u$1.TermNameTag().unapply(termNameApi4);
                                                                if (!option11.isEmpty()) {
                                                                    Option<Names.TermNameApi> option12;
                                                                    String string;
                                                                    Names.TermNameApi termNameApi5 = option11.get();
                                                                    Option<String> option13 = this.u$1.TermName().unapply(termNameApi5);
                                                                    if (!option13.isEmpty() && "scala".equals(string = option13.get()) && !bl && !(option12 = this.u$1.TermNameTag().unapply(termNameApi3)).isEmpty()) {
                                                                        Option<Names.TermNameApi> option14;
                                                                        String string2;
                                                                        Names.TermNameApi termNameApi6 = option12.get();
                                                                        Option<String> option15 = this.u$1.TermName().unapply(termNameApi6);
                                                                        if (!option15.isEmpty() && "StringContext".equals(string2 = option15.get()) && !(option14 = this.u$1.TermNameTag().unapply(termNameApi2)).isEmpty()) {
                                                                            String string3;
                                                                            Names.TermNameApi termNameApi7 = option14.get();
                                                                            Option<String> option16 = this.u$1.TermName().unapply(termNameApi7);
                                                                            if (!option16.isEmpty() && "apply".equals(string3 = option16.get()) && list2 instanceof $colon$colon) {
                                                                                Option<Names.TermNameApi> option17;
                                                                                $colon$colon $colon$colon = ($colon$colon)list2;
                                                                                List qq$macro$1 = (List)$colon$colon.head();
                                                                                List<B> list3 = $colon$colon.tl$access$1();
                                                                                if (((Object)Nil$.MODULE$).equals(list3) && !(option17 = this.u$1.TermNameTag().unapply(termNameApi)).isEmpty()) {
                                                                                    String string4;
                                                                                    Names.TermNameApi termNameApi8 = option17.get();
                                                                                    Option<String> option18 = this.u$1.TermName().unapply(termNameApi8);
                                                                                    if (!option18.isEmpty() && "s".equals(string4 = option18.get()) && list instanceof $colon$colon) {
                                                                                        $colon$colon $colon$colon2 = ($colon$colon)list;
                                                                                        List qq$macro$2 = (List)$colon$colon2.head();
                                                                                        List<B> list4 = $colon$colon2.tl$access$1();
                                                                                        if (((Object)Nil$.MODULE$).equals(list4)) {
                                                                                            Some<Tuple2<List, List>> some3 = new Some<Tuple2<List, List>>(new Tuple2<List, List>(qq$macro$1, qq$macro$2));
                                                                                            return var2_57;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                None$ none$ = None$.MODULE$;
                return var2_57;
            }
            {
                this.u$1 = u$1;
            }
        }.unapply(treeApi);
        if (!option.isEmpty()) {
            List<Trees.TreeApi> parts = option.get()._1();
            List<Trees.TreeApi> args2 = option.get()._2();
            String format = parts.iterator().map((Function1<Trees.TreeApi, String> & Serializable & scala.Serializable)x0$1 -> {
                String string;
                Object str;
                block3: {
                    Trees.TreeApi treeApi;
                    block2: {
                        treeApi = x0$1;
                        Option<Trees.LiteralApi> option = u.LiteralTag().unapply(treeApi);
                        if (option.isEmpty()) break block2;
                        Trees.LiteralApi literalApi = option.get();
                        Option<Constants.ConstantApi> option2 = u.Literal().unapply(literalApi);
                        if (option2.isEmpty()) break block2;
                        Constants.ConstantApi constantApi = option2.get();
                        Option<Constants.ConstantApi> option3 = u.ConstantTag().unapply(constantApi);
                        if (option3.isEmpty()) break block2;
                        Constants.ConstantApi constantApi2 = option3.get();
                        Option<Object> option4 = u.Constant().unapply(constantApi2);
                        if (!option4.isEmpty() && (str = option4.get()) instanceof String) break block3;
                    }
                    throw new MatchError(treeApi);
                }
                String string2 = string = (String)str;
                return string2;
            }).map((Function1<String, String> & Serializable & scala.Serializable)str -> StringContext$.MODULE$.processEscapes((String)str)).map((Function1<String, String> & Serializable & scala.Serializable)str -> args2.nonEmpty() ? str.replace("{}", "\\{}") : str).mkString("{}");
            List formatArgs = args2.map((Function1<Trees.TreeApi, Exprs.Expr> & Serializable & scala.Serializable)t -> c.Expr((Trees.TreeApi)t, c.universe().WeakTypeTag().Any()), List$.MODULE$.canBuildFrom());
            tuple2 = new Tuple2(c.Expr(u.Liftable().liftString().apply(format), c.universe().WeakTypeTag().Nothing()), formatArgs);
        } else {
            tuple2 = new Tuple2<Exprs.Expr<String>, Seq<Exprs.Expr<Object>>>(expr, Nil$.MODULE$);
        }
        return tuple2;
    }

    private Seq<Exprs.Expr<Object>> formatArgs(Context c, Seq<Exprs.Expr<Object>> args2) {
        Seq<Exprs.Expr<Object>> seq = args2;
        return seq.map((Function1<Exprs.Expr, Exprs.Expr> & Serializable & scala.Serializable)arg -> c.Expr(arg.tree().tpe().$less$colon$less(c.universe().weakTypeOf(c.universe().WeakTypeTag().AnyRef())) ? arg.tree() : c.universe().internal().reificationSupport().SyntacticTypeApplied().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().Liftable().liftExpr().apply((Exprs.Expr)arg), c.universe().TermName().apply("asInstanceOf")), new $colon$colon<Nothing$>((Nothing$)((Object)c.universe().internal().reificationSupport().SyntacticSelectType().apply(c.universe().internal().reificationSupport().SyntacticSelectTerm().apply(c.universe().internal().reificationSupport().SyntacticTermIdent().apply(c.universe().TermName().apply("_root_"), false), c.universe().TermName().apply("scala")), c.universe().TypeName().apply("AnyRef"))), Nil$.MODULE$)), c.universe().WeakTypeTag().AnyRef()), Seq$.MODULE$.canBuildFrom());
    }

    private LoggerMacro$() {
        MODULE$ = this;
    }
}

