/*
 * Decompiled with CFR 0.152.
 */
package scala.concurrent.impl;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import scala.Function1;
import scala.Function2;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.PartialFunction;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.concurrent.CanAwait;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import scala.concurrent.Future$InternalCallbackExecutor$;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.Duration$;
import scala.concurrent.duration.FiniteDuration;
import scala.concurrent.impl.CallbackRunnable;
import scala.concurrent.impl.Promise$;
import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.util.Failure;
import scala.util.Try;
import scala.util.control.NonFatal$;

@ScalaSignature(bytes="\u0006\u0001\u00115f\u0001C%K!\u0003\r\t\u0001\u0014)\t\u000b!\u0004A\u0011A5\t\u000b5\u0004A\u0011\u00018\t\u000bA\u0004A\u0011I9\t\u000f\u0005M\u0001\u0001\"\u0011\u0002\u0016!9\u0011q\u0005\u0001\u0005B\u0005%r\u0001CA!\u0015\"\u0005A*a\u0011\u0007\u000f%S\u0005\u0012\u0001'\u0002H!9\u0011\u0011J\u0004\u0005\u0002\u0005-\u0003bBA'\u000f\u0011%\u0011q\n\u0005\b\u0003;:A\u0011BA0\r\u0019\tyh\u0002\u0004\u0002\u0002\"9\u0011\u0011J\u0006\u0005\u0002\u0005\u0005\u0006bBAT\u0017\u0011E\u0013\u0011\u0016\u0005\b\u0003k[A\u0011KA\\\u0011\u001d\t\u0019m\u0003C!\u0003\u000b4a!!3\b\u0001\u0005-\u0007bBA%!\u0011\u0005\u0011\u0011\u001d\u0005\b\u0003K\u0004B\u0011BAq\u0011!\t)\u000f\u0005Q\u0005\u000e\u0005\u001d\bb\u0002B\u0003!\u0011%!q\u0001\u0005\b\u0005\u0017\u0001BQ\u0003B\u0007\u0011\u001d\u0011y\u0002\u0005C\u0003\u0005CAqA!\u0017\u0011\t\u000b\u0011Y\u0006C\u0004\u0003pA!\tA!\u001d\t\u000f\tm\u0004\u0003\"\u0003\u0003r!9!q\u0010\t\u0005F\t\u0005\u0005b\u0002BB!\u0011%!\u0011\u0011\u0005\b\u0005\u000f\u0003BQ\u0001BE\u0011\u001d\u0011i\t\u0005C\u0005\u0005\u001fCqAa)\u0011\t\u000b\u0011)\u000bC\u0004\u0003:B!IAa/\t\u0011\t\r\u0007\u0003\"\u0006M\u0005\u000bDqAa3\u0011\t\u0013\u0011imB\u0004\u0003T\u001eA\tA!6\u0007\u000f\t]w\u0001#\u0001\u0003Z\"9\u0011\u0011J\u0012\u0005\u0002\tmg!\u0003BoGA\u0005\u001b\u0011\u0006Bp\u0011\u0015AW\u0005\"\u0001j\u0011\u001d\u0011I&\nD\u0001\u0005SDqAa\u001c&\t\u0003\u0012i\u000fC\u0004\u0003\u0000\u0015\"\tE!!\t\u000f\t\u001dU\u0005\"\u0011\u0003r\"9!1U\u0013\u0005B\tU\bb\u0002B\u0010K\u0011\u00053Q\u0001\u0005\b\u00053*C\u0011IB\b\r!!id\tQ\u0001\u000e\u0011}\u0002B\u0003B-]\t\u0015\r\u0011\"\u0001\u0005J!Q1q\u0006\u0018\u0003\u0002\u0003\u0006I\u0001b\u0013\t\u000f\u0005%c\u0006\"\u0001\u0005R!9Aq\u000b\u0018\u0005B\u0011e\u0003bBB.]\u0011\u00053Q\f\u0005\b\tSrC\u0011\tC6\u0011\u001d!yH\fC!\t\u0003Cq\u0001\"\u0005/\t\u0003\"\u0019J\u0002\u0005\u0004\u001a\r\u0002\u000bQBB\u000e\u0011)\u0011If\u000eBC\u0002\u0013\u00051q\u0005\u0005\u000b\u0007_9$\u0011!Q\u0001\n\r%\u0002bBA%o\u0011\u00051\u0011\u0007\u0005\t\u0007o9\u0004\u0015\"\u0004\u0004:!911I\u001c\u0005B\r\u0015\u0003bBB.o\u0011\u00053Q\f\u0005\b\u0007C:D\u0011IB2\u0011\u001d\u0019\u0019h\u000eC!\u0007kBqaa\"8\t\u0003\u001aI\tC\u0004\u0004\u001c^\"\te!(\t\u000f\rEv\u0007\"\u0011\u00044\"91\u0011Y\u001c\u0005B\r\r\u0007bBBko\u0011\u00053q\u001b\u0005\b\u0007[<D\u0011IBx\u0011\u001d!\tb\u000eC!\t'Aq\u0001\"\t8\t\u0003\"\u0019\u0003C\u0004\u0002D\u000e\"\t\u0001b(\u0003\u000fA\u0013x.\\5tK*\u00111\nT\u0001\u0005S6\u0004HN\u0003\u0002N\u001d\u0006Q1m\u001c8dkJ\u0014XM\u001c;\u000b\u0003=\u000bQa]2bY\u0006,\"!U.\u0014\t\u0001\u0011f+\u001a\t\u0003'Rk\u0011AT\u0005\u0003+:\u0013a!\u00118z%\u00164\u0007cA,Y36\tA*\u0003\u0002J\u0019B\u0011!l\u0017\u0007\u0001\t\u0015a\u0006A1\u0001_\u0005\u0005!6\u0001A\t\u0003?\n\u0004\"a\u00151\n\u0005\u0005t%a\u0002(pi\"Lgn\u001a\t\u0003'\u000eL!\u0001\u001a(\u0003\u0007\u0005s\u0017\u0010E\u0002XMfK!a\u001a'\u0003\r\u0019+H/\u001e:f\u0003\u0019!\u0013N\\5uIQ\t!\u000e\u0005\u0002TW&\u0011AN\u0014\u0002\u0005+:LG/\u0001\u0004gkR,(/Z\u000b\u0002_6\t\u0001!A\u0005ue\u0006t7OZ8s[V\u0011!O\u001e\u000b\u0003gv$\"\u0001\u001e=\u0011\u0007]3W\u000f\u0005\u0002[m\u0012)qo\u0001b\u0001=\n\t1\u000bC\u0003z\u0007\u0001\u000f!0\u0001\u0005fq\u0016\u001cW\u000f^8s!\t960\u0003\u0002}\u0019\n\u0001R\t_3dkRLwN\\\"p]R,\u0007\u0010\u001e\u0005\u0006}\u000e\u0001\ra`\u0001\u0002MB91+!\u0001\u0002\u0006\u0005E\u0011bAA\u0002\u001d\nIa)\u001e8di&|g.\r\t\u0006\u0003\u000f\ti!W\u0007\u0003\u0003\u0013Q1!a\u0003O\u0003\u0011)H/\u001b7\n\t\u0005=\u0011\u0011\u0002\u0002\u0004)JL\b#BA\u0004\u0003\u001b)\u0018!\u0004;sC:\u001chm\u001c:n/&$\b.\u0006\u0003\u0002\u0018\u0005}A\u0003BA\r\u0003G!B!a\u0007\u0002\"A!qKZA\u000f!\rQ\u0016q\u0004\u0003\u0006o\u0012\u0011\rA\u0018\u0005\u0006s\u0012\u0001\u001dA\u001f\u0005\u0007}\u0012\u0001\r!!\n\u0011\u000fM\u000b\t!!\u0002\u0002\u001c\u0005AAo\\*ue&tw\r\u0006\u0002\u0002,A!\u0011QFA\u001e\u001d\u0011\ty#a\u000e\u0011\u0007\u0005Eb*\u0004\u0002\u00024)\u0019\u0011QG/\u0002\rq\u0012xn\u001c;?\u0013\r\tIDT\u0001\u0007!J,G-\u001a4\n\t\u0005u\u0012q\b\u0002\u0007'R\u0014\u0018N\\4\u000b\u0007\u0005eb*A\u0004Qe>l\u0017n]3\u0011\u0007\u0005\u0015s!D\u0001K'\t9!+\u0001\u0004=S:LGO\u0010\u000b\u0003\u0003\u0007\n!B]3t_24X\r\u0016:z+\u0011\t\t&a\u0016\u0015\t\u0005M\u0013\u0011\f\t\u0007\u0003\u000f\ti!!\u0016\u0011\u0007i\u000b9\u0006B\u0003]\u0013\t\u0007a\fC\u0004\u0002\\%\u0001\r!a\u0015\u0002\rM|WO]2f\u0003!\u0011Xm]8mm\u0016\u0014X\u0003BA1\u0003O\"B!a\u0019\u0002jA1\u0011qAA\u0007\u0003K\u00022AWA4\t\u0015a&B1\u0001_\u0011\u001d\tYG\u0003a\u0001\u0003[\n\u0011\u0002\u001e5s_^\f'\r\\3\u0011\t\u0005=\u0014\u0011\u0010\b\u0005\u0003c\n)H\u0004\u0003\u00022\u0005M\u0014\"A(\n\u0007\u0005]d*A\u0004qC\u000e\\\u0017mZ3\n\t\u0005m\u0014Q\u0010\u0002\n)\"\u0014xn^1cY\u0016T1!a\u001eO\u0005=\u0019u.\u001c9mKRLwN\u001c'bi\u000eDW\u0003BAB\u0003?\u001bRaCAC\u00033\u0003B!a\"\u0002\u00166\u0011\u0011\u0011\u0012\u0006\u0005\u0003\u0017\u000bi)A\u0003m_\u000e\\7OC\u0002N\u0003\u001fSA!a\u0003\u0002\u0012*\u0011\u00111S\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002\u0018\u0006%%AG!cgR\u0014\u0018m\u0019;Rk\u0016,X\rZ*z]\u000eD'o\u001c8ju\u0016\u0014\bCB*\u0002\u0002\u0005m%\u000e\u0005\u0004\u0002\b\u00055\u0011Q\u0014\t\u00045\u0006}E!\u0002/\f\u0005\u0004qFCAAR!\u0015\t)kCAO\u001b\u00059\u0011\u0001\u0005;ss\u0006\u001b\u0017/^5sKNC\u0017M]3e)\u0011\tY+!-\u0011\u0007M\u000bi+C\u0002\u00020:\u00131!\u00138u\u0011\u001d\t\u0019,\u0004a\u0001\u0003W\u000bq![4o_J,G-\u0001\tuef\u0014V\r\\3bg\u0016\u001c\u0006.\u0019:fIR!\u0011\u0011XA`!\r\u0019\u00161X\u0005\u0004\u0003{s%a\u0002\"p_2,\u0017M\u001c\u0005\b\u0003\u0003t\u0001\u0019AAV\u0003\u0019IwM\\8sK\u0006)\u0011\r\u001d9msR\u0019!.a2\t\u000f\u0005Mv\u00021\u0001\u0002\u001c\nqA)\u001a4bk2$\bK]8nSN,W\u0003BAg\u0003?\u001cR\u0001EAh\u00037\u0004R!!5\u0002XJk!!a5\u000b\t\u0005U\u0017QR\u0001\u0007CR|W.[2\n\t\u0005e\u00171\u001b\u0002\u0010\u0003R|W.[2SK\u001a,'/\u001a8dKB)\u0011Q\t\u0001\u0002^B\u0019!,a8\u0005\u000bq\u0003\"\u0019\u00010\u0015\u0005\u0005\r\b#BAS!\u0005u\u0017AD2p[B\u0014Xm]:fIJ{w\u000e\u001e\u000b\u0005\u0003G\fI\u000fC\u0004\u0002lN\u0001\r!!<\u0002\r1Lgn[3ea\u0011\ty/a=\u0011\u000b\u0005\u0015\u0006#!=\u0011\u0007i\u000b\u0019\u0010B\u0006\u0002v\u0006%\u0018\u0011!A\u0001\u0006\u0003q&aA0%c!\u001a1#!?\u0011\t\u0005m(\u0011A\u0007\u0003\u0003{T1!a@O\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0005\u0007\tiPA\u0004uC&d'/Z2\u0002\tI|w\u000e^\u000b\u0003\u0003GD3\u0001FA}\u0003!!(/_!xC&$H\u0003BA]\u0005\u001fAqA!\u0005\u0016\u0001\u0004\u0011\u0019\"\u0001\u0004bi6{7\u000f\u001e\t\u0005\u0005+\u0011Y\"\u0004\u0002\u0003\u0018)\u0019!\u0011\u0004'\u0002\u0011\u0011,(/\u0019;j_:LAA!\b\u0003\u0018\tAA)\u001e:bi&|g.A\u0003sK\u0006$\u0017\u0010\u0006\u0003\u0003$\tEB\u0003\u0002B\u0013\u0005Oi\u0011\u0001\u0005\u0005\b\u0005S1\u00029\u0001B\u0016\u0003\u0019\u0001XM]7jiB\u0019qK!\f\n\u0007\t=BJ\u0001\u0005DC:\fu/Y5u\u0011\u001d\u0011\tB\u0006a\u0001\u0005'ASA\u0006B\u001b\u0005\u0003\u0002Ra\u0015B\u001c\u0005wI1A!\u000fO\u0005\u0019!\bN]8xgB!\u0011q\u000eB\u001f\u0013\u0011\u0011y$! \u0003)%sG/\u001a:skB$X\rZ#yG\u0016\u0004H/[8oG\t\u0011Y\u0004K\u0003\u0017\u0005\u000b\u00129\u0006E\u0003T\u0005o\u00119\u0005\u0005\u0003\u0003J\tEc\u0002\u0002B&\u0005\u001frA!!\u001d\u0003N%\u0011QJT\u0005\u0004\u0003ob\u0015\u0002\u0002B*\u0005+\u0012\u0001\u0003V5nK>,H/\u0012=dKB$\u0018n\u001c8\u000b\u0007\u0005]Dj\t\u0002\u0003H\u00051!/Z:vYR$BA!\u0018\u0003bQ!\u0011Q\u001cB0\u0011\u001d\u0011Ic\u0006a\u0002\u0005WAqA!\u0005\u0018\u0001\u0004\u0011\u0019\u0002K\u0003\u0018\u0005K\u0012i\u0007E\u0003T\u0005o\u00119\u0007\u0005\u0003\u0002p\t%\u0014\u0002\u0002B6\u0003{\u0012\u0011\"\u0012=dKB$\u0018n\u001c8$\u0005\t\u001d\u0014!\u0002<bYV,WC\u0001B:!\u0015\u0019&Q\u000fB=\u0013\r\u00119H\u0014\u0002\u0007\u001fB$\u0018n\u001c8\u0011\r\u0005\u001d\u0011QBAo\u0003\u00191\u0018\r\\;fa!\u001a\u0011$!?\u0002\u0017%\u001c8i\\7qY\u0016$X\rZ\u000b\u0003\u0003s\u000bA\"[:D_6\u0004H.\u001a;fIBB3aGA}\u0003-!(/_\"p[BdW\r^3\u0015\t\u0005e&1\u0012\u0005\b\u0005_b\u0002\u0019\u0001B=\u0003i!(/_\"p[BdW\r^3B]\u0012<U\r\u001e'jgR,g.\u001a:t)\u0011\u0011\tJ!(\u0011\r\u0005=$1\u0013BL\u0013\u0011\u0011)*! \u0003\t1K7\u000f\u001e\t\u0007\u0003\u000b\u0012I*!8\n\u0007\tm%J\u0001\tDC2d'-Y2l%Vtg.\u00192mK\"9!qT\u000fA\u0002\te\u0014!\u0001<)\u0007u\tI0\u0001\u0006p]\u000e{W\u000e\u001d7fi\u0016,BAa*\u00036R!!\u0011\u0016BW)\rQ'1\u0016\u0005\u0006sz\u0001\u001dA\u001f\u0005\b\u0005_s\u0002\u0019\u0001BY\u0003\u00111WO\\2\u0011\u000fM\u000b\tA!\u001f\u00034B\u0019!L!.\u0005\r\t]fD1\u0001_\u0005\u0005)\u0016!\u00063jgB\fGo\u00195Pe\u0006#GmQ1mY\n\f7m\u001b\u000b\u0004U\nu\u0006b\u0002B`?\u0001\u0007!qS\u0001\teVtg.\u00192mK\"\u001aq$!?\u0002\u00151Lgn\u001b*p_R|e\rF\u0002k\u0005\u000fDqA!3!\u0001\u0004\t\u0019/\u0001\u0004uCJ<W\r^\u0001\u0005Y&t7\u000eF\u0002k\u0005\u001fDqA!3\"\u0001\u0004\t\u0019\u000fK\u0002\"\u0003s\f1bS3qiB\u0013x.\\5tKB\u0019\u0011QU\u0012\u0003\u0017-+\u0007\u000f\u001e)s_6L7/Z\n\u0003GI#\"A!6\u0003\t-+\u0007\u000f^\u000b\u0005\u0005C\u00149o\u0005\u0003&%\n\r\b#BA#\u0001\t\u0015\bc\u0001.\u0003h\u0012)A,\nb\u0001=V\u0011!1\u001e\t\u0007\u0003\u000f\tiA!:\u0016\u0005\t=\b#B*\u0003v\t-H\u0003BA]\u0005gDqAa\u001c+\u0001\u0004\u0011Y/\u0006\u0003\u0003x\u000e\rA\u0003\u0002B}\u0005{$2A\u001bB~\u0011\u0015I8\u0006q\u0001{\u0011\u001d\u0011yk\u000ba\u0001\u0005\u007f\u0004raUA\u0001\u0005W\u001c\t\u0001E\u0002[\u0007\u0007!aAa.,\u0005\u0004qF\u0003BB\u0004\u0007\u001b!Ba!\u0003\u0004\f5\tQ\u0005C\u0004\u0003*1\u0002\u001dAa\u000b\t\u000f\tEA\u00061\u0001\u0003\u0014Q!1\u0011CB\u000b)\u0011\u0011)oa\u0005\t\u000f\t%R\u0006q\u0001\u0003,!9!\u0011C\u0017A\u0002\tM\u0011fA\u00138]\t1a)Y5mK\u0012,Ba!\b\u0004&M!qGUB\u0010!\u0015\u0019\t#JB\u0012\u001b\u0005\u0019\u0003c\u0001.\u0004&\u0011)Al\u000eb\u0001=V\u00111\u0011\u0006\t\u0007\u0003\u000f\u0019Yca\t\n\t\r5\u0012\u0011\u0002\u0002\b\r\u0006LG.\u001e:f\u0003\u001d\u0011Xm];mi\u0002\"Baa\r\u00046A)1\u0011E\u001c\u0004$!9!\u0011\f\u001eA\u0002\r%\u0012A\u0002;iSN\f5/\u0006\u0003\u0004<\r\u0005SCAB\u001f!\u00119fma\u0010\u0011\u0007i\u001b\t\u0005B\u0003xw\t\u0007a,A\u0005p]N+8mY3tgV!1qIB-)\u0011\u0019Ie!\u0014\u0015\u0007)\u001cY\u0005C\u0003zy\u0001\u000f!\u0010C\u0004\u0004Pq\u0002\ra!\u0015\u0002\u0005A4\u0007cB*\u0004T\r\r2qK\u0005\u0004\u0007+r%a\u0004)beRL\u0017\r\u001c$v]\u000e$\u0018n\u001c8\u0011\u0007i\u001bI\u0006\u0002\u0004\u00038r\u0012\rAX\u0001\u0007M\u0006LG.\u001a3\u0016\u0005\r}\u0003\u0003B,g\u0003[\nqAZ8sK\u0006\u001c\u0007.\u0006\u0003\u0004f\rED\u0003BB4\u0007W\"2A[B5\u0011\u0015Ih\bq\u0001{\u0011\u0019qh\b1\u0001\u0004nA91+!\u0001\u0004$\r=\u0004c\u0001.\u0004r\u00111!q\u0017 C\u0002y\u000b1!\\1q+\u0011\u00199ha \u0015\t\re41\u0011\u000b\u0005\u0007w\u001a\t\t\u0005\u0003XM\u000eu\u0004c\u0001.\u0004\u0000\u0011)qo\u0010b\u0001=\")\u0011p\u0010a\u0002u\"1ap\u0010a\u0001\u0007\u000b\u0003raUA\u0001\u0007G\u0019i(A\u0004gY\u0006$X*\u00199\u0016\t\r-51\u0013\u000b\u0005\u0007\u001b\u001b9\n\u0006\u0003\u0004\u0010\u000eU\u0005\u0003B,g\u0007#\u00032AWBJ\t\u00159\bI1\u0001_\u0011\u0015I\b\tq\u0001{\u0011\u0019q\b\t1\u0001\u0004\u001aB91+!\u0001\u0004$\r=\u0015a\u00024mCR$XM\\\u000b\u0005\u0007?\u001b)\u000b\u0006\u0003\u0004\"\u000e\u001d\u0006\u0003B,g\u0007G\u00032AWBS\t\u00159\u0018I1\u0001_\u0011\u001d\u0019I+\u0011a\u0002\u0007W\u000b!!\u001a<\u0011\u0011\u000552QVB\u0012\u0007CKAaa,\u0002@\t\u0001B\u0005\\3tg\u0012\u001aw\u000e\\8oI1,7o]\u0001\u0007M&dG/\u001a:\u0015\t\rU61\u0018\u000b\u0005\u0007o\u001bI\f\u0005\u0003XM\u000e\r\u0002\"B=C\u0001\bQ\bbBB_\u0005\u0002\u00071qX\u0001\u0002aB91+!\u0001\u0004$\u0005e\u0016aB2pY2,7\r^\u000b\u0005\u0007\u000b\u001ci\r\u0006\u0003\u0004H\u000eEG\u0003BBe\u0007\u001f\u0004Ba\u00164\u0004LB\u0019!l!4\u0005\u000b]\u001c%\u0019\u00010\t\u000be\u001c\u00059\u0001>\t\u000f\r=3\t1\u0001\u0004TB91ka\u0015\u0004$\r-\u0017a\u0001>jaV!1\u0011\\Bs)\u0011\u0019Yna:\u0011\t]37Q\u001c\t\b'\u000e}71EBr\u0013\r\u0019\tO\u0014\u0002\u0007)V\u0004H.\u001a\u001a\u0011\u0007i\u001b)\u000f\u0002\u0004\u00038\u0012\u0013\rA\u0018\u0005\b\u0007S$\u0005\u0019ABv\u0003\u0011!\b.\u0019;\u0011\t]371]\u0001\bu&\u0004x+\u001b;i+\u0019\u0019\t\u0010b\u0003\u0004|R!11\u001fC\u0007)\u0011\u0019)\u0010\"\u0001\u0015\t\r]8q \t\u0005/\u001a\u001cI\u0010E\u0002[\u0007w$aa!@F\u0005\u0004q&!\u0001*\t\u000be,\u00059\u0001>\t\ry,\u0005\u0019\u0001C\u0002!%\u0019FQAB\u0012\t\u0013\u0019I0C\u0002\u0005\b9\u0013\u0011BR;oGRLwN\u001c\u001a\u0011\u0007i#Y\u0001\u0002\u0004\u00038\u0016\u0013\rA\u0018\u0005\b\u0007S,\u0005\u0019\u0001C\b!\u00119f\r\"\u0003\u0002\u0015\u0019\fG\u000e\u001c2bG.$v.\u0006\u0003\u0005\u0016\u0011mA\u0003\u0002C\f\t?\u0001Ba\u00164\u0005\u001aA\u0019!\fb\u0007\u0005\u000f\t]fI1\u0001\u0005\u001eE\u001911\u00052\t\u000f\r%h\t1\u0001\u0005\u0018\u0005)Q.\u00199U_V!AQ\u0005C\u0016)\u0011!9\u0003\"\f\u0011\t]3G\u0011\u0006\t\u00045\u0012-B!B<H\u0005\u0004q\u0006b\u0002C\u0018\u000f\u0002\u000fA\u0011G\u0001\u0004i\u0006<\u0007C\u0002C\u001a\ts!I#\u0004\u0002\u00056)\u0019Aq\u0007(\u0002\u000fI,g\r\\3di&!A1\bC\u001b\u0005!\u0019E.Y:t)\u0006<'AC*vG\u000e,7o\u001d4vYV!A\u0011\tC$'\u0011q#\u000bb\u0011\u0011\u000b\r\u0005R\u0005\"\u0012\u0011\u0007i#9\u0005B\u0003]]\t\u0007a,\u0006\u0002\u0005LA1\u0011q\u0001C'\t\u000bJA\u0001b\u0014\u0002\n\t91+^2dKN\u001cH\u0003\u0002C*\t+\u0002Ra!\t/\t\u000bBqA!\u00172\u0001\u0004!Y%A\u0005p]\u001a\u000b\u0017\u000e\\;sKV!A1\fC4)\u0011!i\u0006\"\u0019\u0015\u0007)$y\u0006C\u0003ze\u0001\u000f!\u0010C\u0004\u0004PI\u0002\r\u0001b\u0019\u0011\u000fM\u001b\u0019&!\u001c\u0005fA\u0019!\fb\u001a\u0005\r\t]&G1\u0001_\u0003\u001d\u0011XmY8wKJ,B\u0001\"\u001c\u0005vQ!Aq\u000eC>)\u0011!\t\b\"\u001f\u0011\t]3G1\u000f\t\u00045\u0012UDa\u0002B\\i\t\u0007AqO\t\u0004\t\u000b\u0012\u0007\"B=5\u0001\bQ\bbBB(i\u0001\u0007AQ\u0010\t\b'\u000eM\u0013Q\u000eC:\u0003-\u0011XmY8wKJ<\u0016\u000e\u001e5\u0016\t\u0011\rE1\u0012\u000b\u0005\t\u000b#y\t\u0006\u0003\u0005\b\u00125\u0005\u0003B,g\t\u0013\u00032A\u0017CF\t\u001d\u00119,\u000eb\u0001\toBQ!_\u001bA\u0004iDqaa\u00146\u0001\u0004!\t\nE\u0004T\u0007'\ni\u0007b\"\u0016\t\u0011UE1\u0014\u000b\u0005\t/#i\n\u0005\u0003XM\u0012e\u0005c\u0001.\u0005\u001c\u00129!q\u0017\u001cC\u0002\u0011]\u0004bBBum\u0001\u0007AqS\u000b\u0005\tC#9\u000b\u0006\u0003\u0005$\u0012%\u0006\u0003B,Y\tK\u00032A\u0017CT\t\u0015a\u0006J1\u0001_\u0011\u001d\u0011I\u0006\u0013a\u0001\tW\u0003b!a\u0002\u0002\u000e\u0011\u0015\u0006")
public interface Promise<T>
extends scala.concurrent.Promise<T>,
Future<T> {
    @Override
    default public Promise<T> future() {
        return this;
    }

    @Override
    default public <S> Future<S> transform(Function1<Try<T>, Try<S>> f, ExecutionContext executor) {
        DefaultPromise p = new DefaultPromise();
        this.onComplete((Function1<Try, DefaultPromise> & java.io.Serializable & Serializable)result2 -> (DefaultPromise)p.complete(Promise.liftedTree1$1(f, result2)), executor);
        return p.future();
    }

    @Override
    default public <S> Future<S> transformWith(Function1<Try<T>, Future<S>> f, ExecutionContext executor) {
        DefaultPromise p = new DefaultPromise();
        this.onComplete((Function1<Try, Object> & java.io.Serializable & Serializable)v -> {
            try {
                Object object;
                Future future = (Future)f.apply((Try)v);
                if (future == this) {
                    object = p.complete(v);
                } else if (future instanceof DefaultPromise) {
                    ((DefaultPromise)future).linkRootOf(p);
                    object = BoxedUnit.UNIT;
                } else {
                    object = p.completeWith(future);
                }
                return object;
            }
            catch (Throwable throwable) {
                Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
                if (option.isEmpty()) {
                    throw throwable;
                }
                Throwable t = option.get();
                scala.concurrent.Promise promise = p.failure(t);
                return promise;
            }
        }, executor);
        return p.future();
    }

    default public String toString() {
        String string;
        Option option = this.value();
        if (option instanceof Some) {
            Try result2 = (Try)((Some)option).value();
            string = new StringBuilder(8).append("Future(").append(result2).append(")").toString();
        } else if (None$.MODULE$.equals(option)) {
            string = "Future(<not completed>)";
        } else {
            throw new MatchError(option);
        }
        return string;
    }

    private static /* synthetic */ Try liftedTree1$1(Function1 f$1, Try result$1) {
        try {
            return (Try)f$1.apply(result$1);
        }
        catch (Throwable throwable) {
            Option<Throwable> option = NonFatal$.MODULE$.unapply(throwable);
            if (option.isEmpty()) {
                throw throwable;
            }
            Throwable t = option.get();
            Failure failure = new Failure(t);
            return failure;
        }
    }

    public static void $init$(Promise $this) {
    }

    public static final class CompletionLatch<T>
    extends AbstractQueuedSynchronizer
    implements Function1<Try<T>, BoxedUnit> {
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
        public <A> Function1<A, BoxedUnit> compose(Function1<A, Try<T>> g) {
            return Function1.compose$(this, g);
        }

        @Override
        public <A> Function1<Try<T>, A> andThen(Function1<BoxedUnit, A> g) {
            return Function1.andThen$(this, g);
        }

        @Override
        public String toString() {
            return Function1.toString$(this);
        }

        @Override
        public int tryAcquireShared(int ignored) {
            if (this.getState() != 0) {
                return 1;
            }
            return -1;
        }

        @Override
        public boolean tryReleaseShared(int ignore) {
            this.setState(1);
            return true;
        }

        @Override
        public void apply(Try<T> ignored) {
            this.releaseShared(1);
        }
    }

    public static class DefaultPromise<T>
    extends AtomicReference<Object>
    implements Promise<T> {
        @Override
        public Promise<T> future() {
            return ((Promise)this).future();
        }

        @Override
        public <S> Future<S> transform(Function1<Try<T>, Try<S>> f, ExecutionContext executor) {
            return ((Promise)this).transform(f, executor);
        }

        @Override
        public <S> Future<S> transformWith(Function1<Try<T>, Future<S>> f, ExecutionContext executor) {
            return ((Promise)this).transformWith(f, executor);
        }

        @Override
        public String toString() {
            return ((Promise)this).toString();
        }

        @Override
        public <U> void onSuccess(PartialFunction<T, U> pf, ExecutionContext executor) {
            Future.onSuccess$(this, pf, executor);
        }

        @Override
        public <U> void onFailure(PartialFunction<Throwable, U> pf, ExecutionContext executor) {
            Future.onFailure$(this, pf, executor);
        }

        @Override
        public Future<Throwable> failed() {
            return Future.failed$(this);
        }

        @Override
        public <U> void foreach(Function1<T, U> f, ExecutionContext executor) {
            Future.foreach$(this, f, executor);
        }

        @Override
        public <S> Future<S> transform(Function1<T, S> s, Function1<Throwable, Throwable> f, ExecutionContext executor) {
            return Future.transform$(this, s, f, executor);
        }

        @Override
        public <S> Future<S> map(Function1<T, S> f, ExecutionContext executor) {
            return Future.map$(this, f, executor);
        }

        @Override
        public <S> Future<S> flatMap(Function1<T, Future<S>> f, ExecutionContext executor) {
            return Future.flatMap$(this, f, executor);
        }

        @Override
        public <S> Future<S> flatten(Predef$.less.colon.less<T, Future<S>> ev) {
            return Future.flatten$(this, ev);
        }

        @Override
        public Future<T> filter(Function1<T, Object> p, ExecutionContext executor) {
            return Future.filter$(this, p, executor);
        }

        @Override
        public final Future<T> withFilter(Function1<T, Object> p, ExecutionContext executor) {
            return Future.withFilter$(this, p, executor);
        }

        @Override
        public <S> Future<S> collect(PartialFunction<T, S> pf, ExecutionContext executor) {
            return Future.collect$(this, pf, executor);
        }

        @Override
        public <U> Future<U> recover(PartialFunction<Throwable, U> pf, ExecutionContext executor) {
            return Future.recover$(this, pf, executor);
        }

        @Override
        public <U> Future<U> recoverWith(PartialFunction<Throwable, Future<U>> pf, ExecutionContext executor) {
            return Future.recoverWith$(this, pf, executor);
        }

        @Override
        public <U> Future<Tuple2<T, U>> zip(Future<U> that) {
            return Future.zip$(this, that);
        }

        @Override
        public <U, R> Future<R> zipWith(Future<U> that, Function2<T, U, R> f, ExecutionContext executor) {
            return Future.zipWith$(this, that, f, executor);
        }

        @Override
        public <U> Future<U> fallbackTo(Future<U> that) {
            return Future.fallbackTo$(this, that);
        }

        @Override
        public <S> Future<S> mapTo(ClassTag<S> tag) {
            return Future.mapTo$(this, tag);
        }

        @Override
        public <U> Future<T> andThen(PartialFunction<Try<T>, U> pf, ExecutionContext executor) {
            return Future.andThen$(this, pf, executor);
        }

        @Override
        public scala.concurrent.Promise<T> complete(Try<T> result2) {
            return scala.concurrent.Promise.complete$(this, result2);
        }

        @Override
        public final scala.concurrent.Promise<T> completeWith(Future<T> other) {
            return scala.concurrent.Promise.completeWith$(this, other);
        }

        @Override
        public final scala.concurrent.Promise<T> tryCompleteWith(Future<T> other) {
            return scala.concurrent.Promise.tryCompleteWith$(this, other);
        }

        @Override
        public scala.concurrent.Promise<T> success(T value) {
            return scala.concurrent.Promise.success$(this, value);
        }

        @Override
        public boolean trySuccess(T value) {
            return scala.concurrent.Promise.trySuccess$(this, value);
        }

        @Override
        public scala.concurrent.Promise<T> failure(Throwable cause) {
            return scala.concurrent.Promise.failure$(this, cause);
        }

        @Override
        public boolean tryFailure(Throwable cause) {
            return scala.concurrent.Promise.tryFailure$(this, cause);
        }

        private DefaultPromise<T> compressedRoot() {
            DefaultPromise<T> defaultPromise;
            Object v = this.get();
            if (v instanceof DefaultPromise) {
                DefaultPromise defaultPromise2 = (DefaultPromise)v;
                defaultPromise = this.compressedRoot(defaultPromise2);
            } else {
                defaultPromise = this;
            }
            return defaultPromise;
        }

        private final DefaultPromise<T> compressedRoot(DefaultPromise<?> linked) {
            while (true) {
                DefaultPromise<?> target;
                if (linked == (target = super.root())) {
                    return target;
                }
                if (this.compareAndSet(linked, target)) {
                    return target;
                }
                Object v = this.get();
                if (!(v instanceof DefaultPromise)) break;
                linked = (DefaultPromise)v;
            }
            return this;
        }

        private DefaultPromise<T> root() {
            Object v;
            while ((v = this_.get()) instanceof DefaultPromise) {
                DefaultPromise this_ = (DefaultPromise)v;
            }
            return this_;
        }

        public final boolean tryAwait(Duration atMost) {
            if (!this.isCompleted()) {
                if (atMost == Duration$.MODULE$.Undefined()) {
                    throw new IllegalArgumentException("cannot wait for Undefined period");
                }
                Duration.Infinite infinite = Duration$.MODULE$.Inf();
                if (!(infinite != null ? !infinite.equals(atMost) : atMost != null)) {
                    CompletionLatch l = new CompletionLatch();
                    this.onComplete(l, Future$InternalCallbackExecutor$.MODULE$);
                    l.acquireSharedInterruptibly(1);
                } else {
                    Duration.Infinite infinite2 = Duration$.MODULE$.MinusInf();
                    if (infinite2 == null ? atMost != null : !infinite2.equals(atMost)) {
                        if (atMost instanceof FiniteDuration) {
                            FiniteDuration finiteDuration = (FiniteDuration)atMost;
                            if (finiteDuration.$greater(Duration$.MODULE$.Zero())) {
                                CompletionLatch l = new CompletionLatch();
                                this.onComplete(l, Future$InternalCallbackExecutor$.MODULE$);
                                l.tryAcquireSharedNanos(1, finiteDuration.toNanos());
                            }
                        } else {
                            throw new MatchError(atMost);
                        }
                    }
                }
                return this.isCompleted();
            }
            return true;
        }

        @Override
        public final DefaultPromise<T> ready(Duration atMost, CanAwait permit) throws TimeoutException, InterruptedException {
            if (this.tryAwait(atMost)) {
                return this;
            }
            throw new TimeoutException(new StringBuilder(26).append("Futures timed out after [").append(atMost).append("]").toString());
        }

        @Override
        public final T result(Duration atMost, CanAwait permit) throws Exception {
            return ((DefaultPromise)this.ready(atMost, permit)).value().get().get();
        }

        @Override
        public Option<Try<T>> value() {
            return this.value0();
        }

        private Option<Try<T>> value0() {
            Option option;
            block2: {
                while (true) {
                    Object v;
                    if ((v = this_.get()) instanceof Try) {
                        Try try_ = (Try)v;
                        option = new Some<Try>(try_);
                        break block2;
                    }
                    if (!(v instanceof DefaultPromise)) break;
                    DefaultPromise defaultPromise = (DefaultPromise)v;
                    DefaultPromise<T> this_ = this_.compressedRoot(defaultPromise);
                }
                option = None$.MODULE$;
            }
            return option;
        }

        @Override
        public final boolean isCompleted() {
            return this.isCompleted0();
        }

        private boolean isCompleted0() {
            boolean bl;
            block2: {
                while (true) {
                    Object v;
                    if ((v = this_.get()) instanceof Try) {
                        bl = true;
                        break block2;
                    }
                    if (!(v instanceof DefaultPromise)) break;
                    DefaultPromise defaultPromise = (DefaultPromise)v;
                    DefaultPromise<T> this_ = this_.compressedRoot(defaultPromise);
                }
                bl = false;
            }
            return bl;
        }

        @Override
        public final boolean tryComplete(Try<T> value) {
            boolean bl;
            Try<T> resolved = Promise$.MODULE$.scala$concurrent$impl$Promise$$resolveTry(value);
            List list = this.tryCompleteAndGetListeners(resolved);
            if (list == null) {
                bl = false;
            } else if (list.isEmpty()) {
                bl = true;
            } else {
                List foreach_these = list;
                while (!foreach_these.isEmpty()) {
                    CallbackRunnable<T> callbackRunnable = foreach_these.head();
                    DefaultPromise.$anonfun$tryComplete$1$adapted(resolved, callbackRunnable);
                    foreach_these = (List)foreach_these.tail();
                }
                bl = true;
            }
            return bl;
        }

        private List<CallbackRunnable<T>> tryCompleteAndGetListeners(Try<T> v) {
            List list;
            block3: {
                while (true) {
                    Object v2;
                    if ((v2 = this_.get()) instanceof List) {
                        List list2 = (List)v2;
                        if (!this_.compareAndSet(list2, v)) {
                            continue;
                        }
                        list = list2;
                        break block3;
                    }
                    if (!(v2 instanceof DefaultPromise)) break;
                    DefaultPromise defaultPromise = (DefaultPromise)v2;
                    DefaultPromise<T> this_ = this_.compressedRoot(defaultPromise);
                }
                list = null;
            }
            return list;
        }

        @Override
        public final <U> void onComplete(Function1<Try<T>, U> func, ExecutionContext executor) {
            this.dispatchOrAddCallback(new CallbackRunnable(executor.prepare(), func));
        }

        private void dispatchOrAddCallback(CallbackRunnable<T> runnable2) {
            Object v;
            block3: {
                while (true) {
                    if ((v = this_.get()) instanceof Try) {
                        Try try_ = (Try)v;
                        runnable2.executeWithValue(try_);
                        return;
                    }
                    if (v instanceof DefaultPromise) {
                        DefaultPromise defaultPromise = (DefaultPromise)v;
                        DefaultPromise<T> this_ = this_.compressedRoot(defaultPromise);
                        continue;
                    }
                    if (!(v instanceof List)) break block3;
                    List list = (List)v;
                    if (this_.compareAndSet(list, list.$colon$colon(runnable2))) break;
                }
                return;
            }
            throw new MatchError(v);
        }

        public final void linkRootOf(DefaultPromise<T> target) {
            this.link(super.compressedRoot());
        }

        private void link(DefaultPromise<T> target) {
            while (this_ != target) {
                List list;
                Object v = this_.get();
                if (v instanceof Try) {
                    Try try_ = (Try)v;
                    if (target.tryComplete(try_)) break;
                    throw new IllegalStateException("Cannot link completed promises together");
                }
                if (v instanceof DefaultPromise) {
                    DefaultPromise defaultPromise = (DefaultPromise)v;
                    DefaultPromise<T> this_ = this_.compressedRoot(defaultPromise);
                    continue;
                }
                if (!(v instanceof List) || !this_.compareAndSet(list = (List)v, target)) continue;
                if (!list.nonEmpty()) break;
                List foreach_these = list;
                while (!foreach_these.isEmpty()) {
                    CallbackRunnable callbackRunnable = (CallbackRunnable)foreach_these.head();
                    DefaultPromise.$anonfun$link$1$adapted(target, callbackRunnable);
                    foreach_these = (List)foreach_these.tail();
                }
                break;
            }
        }

        public DefaultPromise() {
            super(Nil$.MODULE$);
            scala.concurrent.Promise.$init$(this);
            Future.$init$(this);
            Promise.$init$(this);
        }

        public static final /* synthetic */ Object $anonfun$tryComplete$1$adapted(Try resolved$1, CallbackRunnable r) {
            r.executeWithValue(resolved$1);
            return BoxedUnit.UNIT;
        }

        public static final /* synthetic */ Object $anonfun$link$1$adapted(DefaultPromise target$1, CallbackRunnable x$2) {
            target$1.dispatchOrAddCallback(x$2);
            return BoxedUnit.UNIT;
        }
    }
}

