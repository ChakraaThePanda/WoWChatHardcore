/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.api;

import scala.reflect.ClassTag;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Annotations;
import scala.reflect.api.Constants;
import scala.reflect.api.Mirror;
import scala.reflect.api.Names;
import scala.reflect.api.Position;
import scala.reflect.api.Scopes;
import scala.reflect.api.Symbols;
import scala.reflect.api.Trees;
import scala.reflect.api.Types;

@ScalaSignature(bytes="\u0006\u0001\u0015uc!C/_!\u0003\r\n!ZC+\u0011\u001dQ\u0007A1A\u0007\u0004-DqA\u001e\u0001C\u0002\u001b\rq\u000fC\u0004}\u0001\t\u0007i1A?\t\u0013\u0005\u0015\u0001A1A\u0007\u0004\u0005\u001d\u0001\"CA\t\u0001\t\u0007i1AA\n\u0011%\ti\u0002\u0001b\u0001\u000e\u0007\ty\u0002C\u0005\u0002*\u0001\u0011\rQb\u0001\u0002,!I\u0011Q\u0007\u0001C\u0002\u001b\r\u0011q\u0007\u0005\n\u0003\u0003\u0002!\u0019!D\u0002\u0003\u0007B\u0011\"!\u0014\u0001\u0005\u00045\u0019!a\u0014\t\u0013\u0005e\u0003A1A\u0007\u0004\u0005m\u0003\"CA3\u0001\t\u0007i1AA4\u0011%\t\t\b\u0001b\u0001\u000e\u0007\t\u0019\bC\u0005\u0002~\u0001\u0011\rQb\u0001\u0002\u0000!I\u0011\u0011\u0012\u0001C\u0002\u001b\r\u00111\u0012\u0005\n\u0003+\u0003!\u0019!D\u0002\u0003/C\u0011\"!)\u0001\u0005\u00045\u0019!a)\t\u0013\u00055\u0006A1A\u0007\u0004\u0005=\u0006\"CA_\u0001\t\u0007i1AA`\u0011%\tI\r\u0001b\u0001\u000e\u0007\tY\rC\u0005\u0002V\u0002\u0011\rQb\u0001\u0002X\"I\u0011Q\u001d\u0001C\u0002\u001b\r\u0011q\u001d\u0005\n\u0003c\u0004!\u0019!D\u0002\u0003gD\u0011B!\u0001\u0001\u0005\u00045\u0019Aa\u0001\t\u0013\t5\u0001A1A\u0007\u0004\t=\u0001\"\u0003B\r\u0001\t\u0007i1\u0001B\u000e\u0011%\u0011)\u0003\u0001b\u0001\u000e\u0007\u00119\u0003C\u0005\u00032\u0001\u0011\rQb\u0001\u00034!I!\u0011\t\u0001C\u0002\u001b\r!1\t\u0005\n\u0005\u001b\u0002!\u0019!D\u0002\u0005\u001fB\u0011B!\u0017\u0001\u0005\u00045\u0019Aa\u0017\t\u0013\t\u0015\u0004A1A\u0007\u0004\t\u001d\u0004\"\u0003B9\u0001\t\u0007i1\u0001B:\u0011%\u0011i\b\u0001b\u0001\u000e\u0007\u0011y\bC\u0005\u0003\u000e\u0002\u0011\rQb\u0001\u0003\u0010\"I!Q\u0014\u0001C\u0002\u001b\r!q\u0014\u0005\n\u0005[\u0003!\u0019!D\u0002\u0005_C\u0011B!0\u0001\u0005\u00045\u0019Aa0\t\u0013\t%\u0007A1A\u0007\u0004\t-\u0007\"\u0003Bk\u0001\t\u0007i1\u0001Bl\u0011%\u0011\t\u000f\u0001b\u0001\u000e\u0007\u0011\u0019\u000fC\u0005\u0003n\u0002\u0011\rQb\u0001\u0003p\"I!\u0011 \u0001C\u0002\u001b\r!1 \u0005\n\u0007\u000b\u0001!\u0019!D\u0002\u0007\u000fA\u0011b!\u0005\u0001\u0005\u00045\u0019aa\u0005\t\u0013\ru\u0001A1A\u0007\u0004\r}\u0001\"CB\u0015\u0001\t\u0007i1AB\u0016\u0011%\u0019)\u0004\u0001b\u0001\u000e\u0007\u00199\u0004C\u0005\u0004B\u0001\u0011\rQb\u0001\u0004D!I1Q\n\u0001C\u0002\u001b\r1q\n\u0005\n\u00073\u0002!\u0019!D\u0002\u00077B\u0011b!\u001a\u0001\u0005\u00045\u0019aa\u001a\t\u0013\rE\u0004A1A\u0007\u0004\rM\u0004\"CB?\u0001\t\u0007i1AB@\u0011%\u0019I\t\u0001b\u0001\u000e\u0007\u0019Y\tC\u0005\u0004\u0016\u0002\u0011\rQb\u0001\u0004\u0018\"I1\u0011\u0015\u0001C\u0002\u001b\r11\u0015\u0005\n\u0007[\u0003!\u0019!D\u0002\u0007_C\u0011b!/\u0001\u0005\u00045\u0019aa/\t\u0013\r\u0015\u0007A1A\u0007\u0004\r\u001d\u0007\"CBi\u0001\t\u0007i1ABj\u0011%\u0019i\u000e\u0001b\u0001\u000e\u0007\u0019y\u000eC\u0005\u0004j\u0002\u0011\rQb\u0001\u0004l\"I1Q\u001f\u0001C\u0002\u001b\r1q\u001f\u0005\n\t\u0003\u0001!\u0019!D\u0002\t\u0007A\u0011\u0002\"\u0004\u0001\u0005\u00045\u0019\u0001b\u0004\t\u0013\u0011e\u0001A1A\u0007\u0004\u0011m\u0001\"\u0003C\u0013\u0001\t\u0007i1\u0001C\u0014\u0011%!\t\u0004\u0001b\u0001\u000e\u0007!\u0019\u0004C\u0005\u0005>\u0001\u0011\rQb\u0001\u0005@!IA\u0011\n\u0001C\u0002\u001b\rA1\n\u0005\n\t+\u0002!\u0019!D\u0002\t/B\u0011\u0002\"\u0019\u0001\u0005\u00045\u0019\u0001b\u0019\t\u0013\u00115\u0004A1A\u0007\u0004\u0011=\u0004\"\u0003C=\u0001\t\u0007i1\u0001C>\u0011%!)\t\u0001b\u0001\u000e\u0007!9\tC\u0005\u0005\u0012\u0002\u0011\rQb\u0001\u0005\u0014\"IAQ\u0014\u0001C\u0002\u001b\rAq\u0014\u0005\n\tS\u0003!\u0019!D\u0002\tWC\u0011\u0002\".\u0001\u0005\u00045\u0019\u0001b.\t\u0013\u0011\u0005\u0007A1A\u0007\u0004\u0011\r\u0007\"\u0003Cg\u0001\t\u0007i1\u0001Ch\u0011%!I\u000e\u0001b\u0001\u000e\u0007!Y\u000eC\u0005\u0005f\u0002\u0011\rQb\u0001\u0005h\"IA\u0011\u001f\u0001C\u0002\u001b\rA1\u001f\u0005\n\t{\u0004!\u0019!D\u0002\t\u007fD\u0011\"\"\u0003\u0001\u0005\u00045\u0019!b\u0003\t\u0013\u0015U\u0001A1A\u0007\u0004\u0015]\u0001\"CC\u0011\u0001\t\u0007i1AC\u0012\u0011%)i\u0003\u0001b\u0001\u000e\u0007)y\u0003C\u0005\u0006:\u0001\u0011\rQb\u0001\u0006<!IQ\u0011\n\u0001C\u0002\u001b\rQ1\n\u0002\r\u00136\u0004H.[2jiR\u000bwm\u001d\u0006\u0003?\u0002\f1!\u00199j\u0015\t\t'-A\u0004sK\u001adWm\u0019;\u000b\u0003\r\fQa]2bY\u0006\u001c\u0001a\u0005\u0002\u0001MB\u0011q\r[\u0007\u0002E&\u0011\u0011N\u0019\u0002\u0007\u0003:L(+\u001a4\u0002!\u0005sgn\u001c;bi\u0016$G+\u001f9f)\u0006<W#\u00017\u0011\u00075t\u0007/D\u0001a\u0013\ty\u0007M\u0001\u0005DY\u0006\u001c8\u000fV1h!\t\t(/D\u0001\u0001\u0013\t\u0019HOA\u0007B]:|G/\u0019;fIRK\b/Z\u0005\u0003kz\u0013Q\u0001V=qKN\faCQ8v]\u0012,GmV5mI\u000e\f'\u000f\u001a+za\u0016$\u0016mZ\u000b\u0002qB\u0019QN\\=\u0011\u0005ET\u0018BA>u\u0005M\u0011u.\u001e8eK\u0012<\u0016\u000e\u001c3dCJ$G+\u001f9f\u0003A\u0019E.Y:t\u0013:4w\u000eV=qKR\u000bw-F\u0001\u007f!\rign \t\u0004c\u0006\u0005\u0011bAA\u0002i\ni1\t\\1tg&sgm\u001c+za\u0016\fqbQ8na>,h\u000e\u001a+za\u0016$\u0016mZ\u000b\u0003\u0003\u0013\u0001B!\u001c8\u0002\fA\u0019\u0011/!\u0004\n\u0007\u0005=AO\u0001\u0007D_6\u0004x.\u001e8e)f\u0004X-A\bD_:\u001cH/\u00198u)f\u0004X\rV1h+\t\t)\u0002\u0005\u0003n]\u0006]\u0001cA9\u0002\u001a%\u0019\u00111\u0004;\u0003\u0019\r{gn\u001d;b]R$\u0016\u0010]3\u0002%\u0015C\u0018n\u001d;f]RL\u0017\r\u001c+za\u0016$\u0016mZ\u000b\u0003\u0003C\u0001B!\u001c8\u0002$A\u0019\u0011/!\n\n\u0007\u0005\u001dBOA\bFq&\u001cH/\u001a8uS\u0006dG+\u001f9f\u00035iU\r\u001e5pIRK\b/\u001a+bOV\u0011\u0011Q\u0006\t\u0005[:\fy\u0003E\u0002r\u0003cI1!a\ru\u0005)iU\r\u001e5pIRK\b/Z\u0001\u0015\u001dVdG.\u0019:z\u001b\u0016$\bn\u001c3UsB,G+Y4\u0016\u0005\u0005e\u0002\u0003B7o\u0003w\u00012!]A\u001f\u0013\r\ty\u0004\u001e\u0002\u0012\u001dVdG.\u0019:z\u001b\u0016$\bn\u001c3UsB,\u0017a\u0003)pYf$\u0016\u0010]3UC\u001e,\"!!\u0012\u0011\t5t\u0017q\t\t\u0004c\u0006%\u0013bAA&i\nA\u0001k\u001c7z)f\u0004X-\u0001\bSK\u001aLg.\u001a3UsB,G+Y4\u0016\u0005\u0005E\u0003\u0003B7o\u0003'\u00022!]A+\u0013\r\t9\u0006\u001e\u0002\f%\u00164\u0017N\\3e)f\u0004X-A\u0007TS:<G.\u001a+za\u0016$\u0016mZ\u000b\u0003\u0003;\u0002B!\u001c8\u0002`A\u0019\u0011/!\u0019\n\u0007\u0005\rDO\u0001\u0006TS:<G.\u001a+za\u0016\f\u0001cU5oO2,Go\u001c8UsB,G+Y4\u0016\u0005\u0005%\u0004\u0003B7o\u0003W\u00022!]A7\u0013\r\ty\u0007\u001e\u0002\u000e'&tw\r\\3u_:$\u0016\u0010]3\u0002\u0019M+\b/\u001a:UsB,G+Y4\u0016\u0005\u0005U\u0004\u0003B7o\u0003o\u00022!]A=\u0013\r\tY\b\u001e\u0002\n'V\u0004XM\u001d+za\u0016\f1\u0002\u00165jgRK\b/\u001a+bOV\u0011\u0011\u0011\u0011\t\u0005[:\f\u0019\tE\u0002r\u0003\u000bK1!a\"u\u0005!!\u0006.[:UsB,\u0017!\u0004+za\u0016\u0014u.\u001e8egR\u000bw-\u0006\u0002\u0002\u000eB!QN\\AH!\r\t\u0018\u0011S\u0005\u0004\u0003'#(A\u0003+za\u0016\u0014u.\u001e8eg\u0006QA+\u001f9f%\u00164G+Y4\u0016\u0005\u0005e\u0005\u0003B7o\u00037\u00032!]AO\u0013\r\ty\n\u001e\u0002\b)f\u0004XMU3g\u0003!!\u0016\u0010]3UC\u001e<WCAAS!\u0011ig.a*\u0011\u0007E\fI+C\u0002\u0002,R\u0014A\u0001V=qK\u00069a*Y7f)\u0006<WCAAY!\u0011ig.a-\u0011\u0007E\f),\u0003\u0003\u00028\u0006e&\u0001\u0002(b[\u0016L1!a/_\u0005\u0015q\u0015-\\3t\u0003-!VM]7OC6,G+Y4\u0016\u0005\u0005\u0005\u0007\u0003B7o\u0003\u0007\u00042!]Ac\u0013\u0011\t9-!/\u0003\u0011Q+'/\u001c(b[\u0016\f1\u0002V=qK:\u000bW.\u001a+bOV\u0011\u0011Q\u001a\t\u0005[:\fy\rE\u0002r\u0003#LA!a5\u0002:\nAA+\u001f9f\u001d\u0006lW-\u0001\u0005TG>\u0004X\rV1h+\t\tI\u000e\u0005\u0003n]\u0006m\u0007cA9\u0002^&!\u0011q\\Aq\u0005\u0015\u00196m\u001c9f\u0013\r\t\u0019O\u0018\u0002\u0007'\u000e|\u0007/Z:\u0002\u001d5+WNY3s'\u000e|\u0007/\u001a+bOV\u0011\u0011\u0011\u001e\t\u0005[:\fY\u000fE\u0002r\u0003[LA!a<\u0002b\nYQ*Z7cKJ\u001c6m\u001c9f\u00035\teN\\8uCRLwN\u001c+bOV\u0011\u0011Q\u001f\t\u0005[:\f9\u0010E\u0002r\u0003sLA!a?\u0002~\nQ\u0011I\u001c8pi\u0006$\u0018n\u001c8\n\u0007\u0005}hLA\u0006B]:|G/\u0019;j_:\u001c\u0018a\u0004&bm\u0006\f%oZ;nK:$H+Y4\u0016\u0005\t\u0015\u0001\u0003B7o\u0005\u000f\u00012!\u001dB\u0005\u0013\u0011\u0011Y!!@\u0003\u0019)\u000bg/Y!sOVlWM\u001c;\u0002%1KG/\u001a:bY\u0006\u0013x-^7f]R$\u0016mZ\u000b\u0003\u0005#\u0001B!\u001c8\u0003\u0014A\u0019\u0011O!\u0006\n\t\t]\u0011Q \u0002\u0010\u0019&$XM]1m\u0003J<W/\\3oi\u0006\u0001\u0012I\u001d:bs\u0006\u0013x-^7f]R$\u0016mZ\u000b\u0003\u0005;\u0001B!\u001c8\u0003 A\u0019\u0011O!\t\n\t\t\r\u0012Q \u0002\u000e\u0003J\u0014\u0018-_!sOVlWM\u001c;\u0002#9+7\u000f^3e\u0003J<W/\\3oiR\u000bw-\u0006\u0002\u0003*A!QN\u001cB\u0016!\r\t(QF\u0005\u0005\u0005_\tiP\u0001\bOKN$X\rZ!sOVlWM\u001c;\u0002\u001bQ+'/\\*z[\n|G\u000eV1h+\t\u0011)\u0004\u0005\u0003n]\n]\u0002cA9\u0003:%!!1\bB\u001f\u0005)!VM]7Ts6\u0014w\u000e\\\u0005\u0004\u0005\u007fq&aB*z[\n|Gn]\u0001\u0010\u001b\u0016$\bn\u001c3Ts6\u0014w\u000e\u001c+bOV\u0011!Q\t\t\u0005[:\u00149\u0005E\u0002r\u0005\u0013JAAa\u0013\u0003>\taQ*\u001a;i_\u0012\u001c\u00160\u001c2pY\u0006I1+_7c_2$\u0016mZ\u000b\u0003\u0005#\u0002B!\u001c8\u0003TA\u0019\u0011O!\u0016\n\t\t]#Q\b\u0002\u0007'fl'm\u001c7\u0002\u001bQK\b/Z*z[\n|G\u000eV1h+\t\u0011i\u0006\u0005\u0003n]\n}\u0003cA9\u0003b%!!1\rB\u001f\u0005)!\u0016\u0010]3Ts6\u0014w\u000e\\\u0001\u0010\u001b>$W\u000f\\3Ts6\u0014w\u000e\u001c+bOV\u0011!\u0011\u000e\t\u0005[:\u0014Y\u0007E\u0002r\u0005[JAAa\u001c\u0003>\taQj\u001c3vY\u0016\u001c\u00160\u001c2pY\u0006q1\t\\1tgNKXNY8m)\u0006<WC\u0001B;!\u0011igNa\u001e\u0011\u0007E\u0014I(\u0003\u0003\u0003|\tu\"aC\"mCN\u001c8+_7c_2\f1\u0002U8tSRLwN\u001c+bOV\u0011!\u0011\u0011\t\u0005[:\u0014\u0019\tE\u0002r\u0005\u000bKAAa\"\u0003\n\nA\u0001k\\:ji&|g.C\u0002\u0003\fz\u0013\u0011\u0002U8tSRLwN\\:\u0002\u0017\r{gn\u001d;b]R$\u0016mZ\u000b\u0003\u0005#\u0003B!\u001c8\u0003\u0014B\u0019\u0011O!&\n\t\t]%\u0011\u0014\u0002\t\u0007>t7\u000f^1oi&\u0019!1\u00140\u0003\u0013\r{gn\u001d;b]R\u001c\u0018A\u0003$mC\u001e\u001cV\r\u001e+bOV\u0011!\u0011\u0015\t\u0005[:\u0014\u0019\u000bE\u0002r\u0005KKAAa*\u0003*\n9a\t\\1h'\u0016$\u0018b\u0001BV=\nAa\t\\1h'\u0016$8/\u0001\u0007N_\u0012Lg-[3sgR\u000bw-\u0006\u0002\u00032B!QN\u001cBZ!\r\t(QW\u0005\u0005\u0005o\u0013ILA\u0005N_\u0012Lg-[3sg&\u0019!1\u00180\u0003\u000bQ\u0013X-Z:\u0002\u001d\u0005cG/\u001a:oCRLg/\u001a+bOV\u0011!\u0011\u0019\t\u0005[:\u0014\u0019\rE\u0002r\u0005\u000bLAAa2\u0003:\nY\u0011\t\u001c;fe:\fG/\u001b<f\u00031\teN\\8uCR,G\rV1h+\t\u0011i\r\u0005\u0003n]\n=\u0007cA9\u0003R&!!1\u001bB]\u0005%\teN\\8uCR,G-\u0001\nBaBd\u0017.\u001a3UsB,GK]3f)\u0006<WC\u0001Bm!\u0011igNa7\u0011\u0007E\u0014i.\u0003\u0003\u0003`\ne&aD!qa2LW\r\u001a+za\u0016$&/Z3\u0002\u0011\u0005\u0003\b\u000f\\=UC\u001e,\"A!:\u0011\t5t'q\u001d\t\u0004c\n%\u0018\u0002\u0002Bv\u0005s\u0013Q!\u00119qYf\f1#Q:tS\u001etwJ\u001d(b[\u0016$\u0017I]4UC\u001e,\"A!=\u0011\t5t'1\u001f\t\u0004c\nU\u0018\u0002\u0002B|\u0005s\u0013\u0001#Q:tS\u001etwJ\u001d(b[\u0016$\u0017I]4\u0002\u0013\u0005\u001b8/[4o)\u0006<WC\u0001B\u007f!\u0011igNa@\u0011\u0007E\u001c\t!\u0003\u0003\u0004\u0004\te&AB!tg&<g.A\u0004CS:$G+Y4\u0016\u0005\r%\u0001\u0003B7o\u0007\u0017\u00012!]B\u0007\u0013\u0011\u0019yA!/\u0003\t\tKg\u000eZ\u0001\t\u00052|7m\u001b+bOV\u00111Q\u0003\t\u0005[:\u001c9\u0002E\u0002r\u00073IAaa\u0007\u0003:\n)!\t\\8dW\u0006Q1)Y:f\t\u00164G+Y4\u0016\u0005\r\u0005\u0002\u0003B7o\u0007G\u00012!]B\u0013\u0013\u0011\u00199C!/\u0003\u000f\r\u000b7/\u001a#fM\u0006Y1\t\\1tg\u0012+g\rV1h+\t\u0019i\u0003\u0005\u0003n]\u000e=\u0002cA9\u00042%!11\u0007B]\u0005!\u0019E.Y:t\t\u00164\u0017aE\"p[B|WO\u001c3UsB,GK]3f)\u0006<WCAB\u001d!\u0011igna\u000f\u0011\u0007E\u001ci$\u0003\u0003\u0004@\te&\u0001E\"p[B|WO\u001c3UsB,GK]3f\u0003%!UM\u001a#fMR\u000bw-\u0006\u0002\u0004FA!QN\\B$!\r\t8\u0011J\u0005\u0005\u0007\u0017\u0012IL\u0001\u0004EK\u001a$UMZ\u0001\u000b\t\u00164GK]3f)\u0006<WCAB)!\u0011igna\u0015\u0011\u0007E\u001c)&\u0003\u0003\u0004X\te&a\u0002#fMR\u0013X-Z\u0001\u0017\u000bbL7\u000f^3oi&\fG\u000eV=qKR\u0013X-\u001a+bOV\u00111Q\f\t\u0005[:\u001cy\u0006E\u0002r\u0007CJAaa\u0019\u0003:\n\u0019R\t_5ti\u0016tG/[1m)f\u0004X\r\u0016:fK\u0006Ya)\u001e8di&|g\u000eV1h+\t\u0019I\u0007\u0005\u0003n]\u000e-\u0004cA9\u0004n%!1q\u000eB]\u0005!1UO\\2uS>t\u0017aD$f]\u0016\u0014\u0018nY!qa2LH+Y4\u0016\u0005\rU\u0004\u0003B7o\u0007o\u00022!]B=\u0013\u0011\u0019YH!/\u0003\u0019\u001d+g.\u001a:jG\u0006\u0003\b\u000f\\=\u0002\u0011%#WM\u001c;UC\u001e,\"a!!\u0011\t5t71\u0011\t\u0004c\u000e\u0015\u0015\u0002BBD\u0005s\u0013Q!\u00133f]R\fQ!\u00134UC\u001e,\"a!$\u0011\t5t7q\u0012\t\u0004c\u000eE\u0015\u0002BBJ\u0005s\u0013!!\u00134\u0002\u0015%k\u0007\u000f\u001c#fMR\u000bw-\u0006\u0002\u0004\u001aB!QN\\BN!\r\t8QT\u0005\u0005\u0007?\u0013ILA\u0004J[BdG)\u001a4\u0002#%k\u0007o\u001c:u'\u0016dWm\u0019;peR\u000bw-\u0006\u0002\u0004&B!QN\\BT!\r\t8\u0011V\u0005\u0005\u0007W\u0013IL\u0001\bJ[B|'\u000f^*fY\u0016\u001cGo\u001c:\u0002\u0013%k\u0007o\u001c:u)\u0006<WCABY!\u0011igna-\u0011\u0007E\u001c),\u0003\u0003\u00048\ne&AB%na>\u0014H/A\u0006MC\n,G\u000eR3g)\u0006<WCAB_!\u0011igna0\u0011\u0007E\u001c\t-\u0003\u0003\u0004D\ne&\u0001\u0003'bE\u0016dG)\u001a4\u0002\u00151KG/\u001a:bYR\u000bw-\u0006\u0002\u0004JB!QN\\Bf!\r\t8QZ\u0005\u0005\u0007\u001f\u0014ILA\u0004MSR,'/\u00197\u0002\u00115\u000bGo\u00195UC\u001e,\"a!6\u0011\t5t7q\u001b\t\u0004c\u000ee\u0017\u0002BBn\u0005s\u0013Q!T1uG\"\fA\"T3nE\u0016\u0014H)\u001a4UC\u001e,\"a!9\u0011\t5t71\u001d\t\u0004c\u000e\u0015\u0018\u0002BBt\u0005s\u0013\u0011\"T3nE\u0016\u0014H)\u001a4\u0002\u00195{G-\u001e7f\t\u00164G+Y4\u0016\u0005\r5\b\u0003B7o\u0007_\u00042!]By\u0013\u0011\u0019\u0019P!/\u0003\u00135{G-\u001e7f\t\u00164\u0017a\u0003(b[\u0016$&/Z3UC\u001e,\"a!?\u0011\t5t71 \t\u0004c\u000eu\u0018\u0002BB\u0000\u0005s\u0013\u0001BT1nKR\u0013X-Z\u0001\u0007\u001d\u0016<H+Y4\u0016\u0005\u0011\u0015\u0001\u0003B7o\t\u000f\u00012!\u001dC\u0005\u0013\u0011!YA!/\u0003\u00079+w/A\u0007QC\u000e\\\u0017mZ3EK\u001a$\u0016mZ\u000b\u0003\t#\u0001B!\u001c8\u0005\u0014A\u0019\u0011\u000f\"\u0006\n\t\u0011]!\u0011\u0018\u0002\u000b!\u0006\u001c7.Y4f\t\u00164\u0017A\u0003*fMR\u0013X-\u001a+bOV\u0011AQ\u0004\t\u0005[:$y\u0002E\u0002r\tCIA\u0001b\t\u0003:\n9!+\u001a4Ue\u0016,\u0017!\u0003*fiV\u0014h\u000eV1h+\t!I\u0003\u0005\u0003n]\u0012-\u0002cA9\u0005.%!Aq\u0006B]\u0005\u0019\u0011V\r^;s]\u0006)2+\u001a7fGR4%o\\7UsB,GK]3f)\u0006<WC\u0001C\u001b!\u0011ig\u000eb\u000e\u0011\u0007E$I$\u0003\u0003\u0005<\te&AE*fY\u0016\u001cGO\u0012:p[RK\b/\u001a+sK\u0016\f\u0011bU3mK\u000e$H+Y4\u0016\u0005\u0011\u0005\u0003\u0003B7o\t\u0007\u00022!\u001dC#\u0013\u0011!9E!/\u0003\rM+G.Z2u\u0003Q\u0019\u0016N\\4mKR|g\u000eV=qKR\u0013X-\u001a+bOV\u0011AQ\n\t\u0005[:$y\u0005E\u0002r\t#JA\u0001b\u0015\u0003:\n\t2+\u001b8hY\u0016$xN\u001c+za\u0016$&/Z3\u0002\u000fM#\u0018M\u001d+bOV\u0011A\u0011\f\t\u0005[:$Y\u0006E\u0002r\t;JA\u0001b\u0018\u0003:\n!1\u000b^1s\u0003!\u0019V\u000f]3s)\u0006<WC\u0001C3!\u0011ig\u000eb\u001a\u0011\u0007E$I'\u0003\u0003\u0005l\te&!B*va\u0016\u0014\u0018AC*z[R\u0013X-\u001a+bOV\u0011A\u0011\u000f\t\u0005[:$\u0019\bE\u0002r\tkJA\u0001b\u001e\u0003:\n91+_7Ue\u0016,\u0017a\u0003+f[Bd\u0017\r^3UC\u001e,\"\u0001\" \u0011\t5tGq\u0010\t\u0004c\u0012\u0005\u0015\u0002\u0002CB\u0005s\u0013\u0001\u0002V3na2\fG/Z\u0001\f)\u0016\u0014X\u000e\u0016:fKR\u000bw-\u0006\u0002\u0005\nB!QN\u001cCF!\r\tHQR\u0005\u0005\t\u001f\u0013IL\u0001\u0005UKJlGK]3f\u0003\u001d!\u0006.[:UC\u001e,\"\u0001\"&\u0011\t5tGq\u0013\t\u0004c\u0012e\u0015\u0002\u0002CN\u0005s\u0013A\u0001\u00165jg\u0006AA\u000b\u001b:poR\u000bw-\u0006\u0002\u0005\"B!QN\u001cCR!\r\tHQU\u0005\u0005\tO\u0013ILA\u0003UQJ|w/A\u0004Ue\u0016,G+Y4\u0016\u0005\u00115\u0006\u0003B7o\t_\u00032!\u001dCY\u0013\u0011!\u0019L!/\u0003\tQ\u0013X-Z\u0001\u0007)JLH+Y4\u0016\u0005\u0011e\u0006\u0003B7o\tw\u00032!\u001dC_\u0013\u0011!yL!/\u0003\u0007Q\u0013\u00180\u0001\u0006UsB$&/Z3UC\u001e,\"\u0001\"2\u0011\t5tGq\u0019\t\u0004c\u0012%\u0017\u0002\u0002Cf\u0005s\u0013q\u0001V=q)J,W-\u0001\u0007UsB,\u0017\t\u001d9msR\u000bw-\u0006\u0002\u0005RB!QN\u001cCj!\r\tHQ[\u0005\u0005\t/\u0014ILA\u0005UsB,\u0017\t\u001d9ms\u0006\tB+\u001f9f\u0005>,h\u000eZ:Ue\u0016,G+Y4\u0016\u0005\u0011u\u0007\u0003B7o\t?\u00042!\u001dCq\u0013\u0011!\u0019O!/\u0003\u001dQK\b/\u001a\"pk:$7\u000f\u0016:fK\u0006QA+\u001f9f\t\u00164G+Y4\u0016\u0005\u0011%\b\u0003B7o\tW\u00042!\u001dCw\u0013\u0011!yO!/\u0003\u000fQK\b/\u001a#fM\u0006YA+\u001f9f)J,W\rV1h+\t!)\u0010\u0005\u0003n]\u0012]\bcA9\u0005z&!A1 B]\u0005!!\u0016\u0010]3Ue\u0016,\u0017\u0001\u0003+za\u0016$G+Y4\u0016\u0005\u0015\u0005\u0001\u0003B7o\u000b\u0007\u00012!]C\u0003\u0013\u0011)9A!/\u0003\u000bQK\b/\u001a3\u0002\u0015Us\u0017\t\u001d9msR\u000bw-\u0006\u0002\u0006\u000eA!QN\\C\b!\r\tX\u0011C\u0005\u0005\u000b'\u0011ILA\u0004V]\u0006\u0003\b\u000f\\=\u0002\u0013Y\u000bG\u000eR3g)\u0006<WCAC\r!\u0011ig.b\u0007\u0011\u0007E,i\"\u0003\u0003\u0006 \te&A\u0002,bY\u0012+g-\u0001\bWC2|%\u000fR3g\t\u00164G+Y4\u0016\u0005\u0015\u0015\u0002\u0003B7o\u000bO\u00012!]C\u0015\u0013\u0011)YC!/\u0003\u0017Y\u000bGn\u0014:EK\u001a$UMZ\u0001\u000e)J,WmQ8qS\u0016\u0014H+Y4\u0016\u0005\u0015E\u0002\u0003B7o\u000bg\u00012!]C\u001b\u0013\u0011)9D!/\u0003\u0015Q\u0013X-Z\"pa&,'/A\bSk:$\u0018.\\3DY\u0006\u001c8\u000fV1h+\t)i\u0004\u0005\u0003n]\u0016}\u0002cA9\u0006B%!Q1IC#\u00051\u0011VO\u001c;j[\u0016\u001cE.Y:t\u0013\r)9E\u0018\u0002\b\u001b&\u0014(o\u001c:t\u0003%i\u0015N\u001d:peR\u000bw-\u0006\u0002\u0006NA!QN\\C(!\r\tX\u0011K\u0005\u0005\u000b'*)E\u0001\u0004NSJ\u0014xN\u001d\t\u0005\u000b/*I&D\u0001_\u0013\r)YF\u0018\u0002\t+:Lg/\u001a:tK\u0002")
public interface ImplicitTags {
    public ClassTag<Types.AnnotatedTypeApi> AnnotatedTypeTag();

    public ClassTag<Types.BoundedWildcardTypeApi> BoundedWildcardTypeTag();

    public ClassTag<Types.ClassInfoTypeApi> ClassInfoTypeTag();

    public ClassTag<Types.CompoundTypeApi> CompoundTypeTag();

    public ClassTag<Types.ConstantTypeApi> ConstantTypeTag();

    public ClassTag<Types.ExistentialTypeApi> ExistentialTypeTag();

    public ClassTag<Types.MethodTypeApi> MethodTypeTag();

    public ClassTag<Types.NullaryMethodTypeApi> NullaryMethodTypeTag();

    public ClassTag<Types.PolyTypeApi> PolyTypeTag();

    public ClassTag<Types.RefinedTypeApi> RefinedTypeTag();

    public ClassTag<Types.SingleTypeApi> SingleTypeTag();

    public ClassTag<Types.SingletonTypeApi> SingletonTypeTag();

    public ClassTag<Types.SuperTypeApi> SuperTypeTag();

    public ClassTag<Types.ThisTypeApi> ThisTypeTag();

    public ClassTag<Types.TypeBoundsApi> TypeBoundsTag();

    public ClassTag<Types.TypeRefApi> TypeRefTag();

    public ClassTag<Types.TypeApi> TypeTagg();

    public ClassTag<Names.NameApi> NameTag();

    public ClassTag<Names.TermNameApi> TermNameTag();

    public ClassTag<Names.TypeNameApi> TypeNameTag();

    public ClassTag<Scopes.ScopeApi> ScopeTag();

    public ClassTag<Scopes.MemberScopeApi> MemberScopeTag();

    public ClassTag<Annotations.AnnotationApi> AnnotationTag();

    public ClassTag<Annotations.JavaArgumentApi> JavaArgumentTag();

    public ClassTag<Annotations.LiteralArgumentApi> LiteralArgumentTag();

    public ClassTag<Annotations.ArrayArgumentApi> ArrayArgumentTag();

    public ClassTag<Annotations.NestedArgumentApi> NestedArgumentTag();

    public ClassTag<Symbols.TermSymbolApi> TermSymbolTag();

    public ClassTag<Symbols.MethodSymbolApi> MethodSymbolTag();

    public ClassTag<Symbols.SymbolApi> SymbolTag();

    public ClassTag<Symbols.TypeSymbolApi> TypeSymbolTag();

    public ClassTag<Symbols.ModuleSymbolApi> ModuleSymbolTag();

    public ClassTag<Symbols.ClassSymbolApi> ClassSymbolTag();

    public ClassTag<Position> PositionTag();

    public ClassTag<Constants.ConstantApi> ConstantTag();

    public ClassTag<Object> FlagSetTag();

    public ClassTag<Trees.ModifiersApi> ModifiersTag();

    public ClassTag<Trees.AlternativeApi> AlternativeTag();

    public ClassTag<Trees.AnnotatedApi> AnnotatedTag();

    public ClassTag<Trees.AppliedTypeTreeApi> AppliedTypeTreeTag();

    public ClassTag<Trees.ApplyApi> ApplyTag();

    public ClassTag<Trees.AssignOrNamedArgApi> AssignOrNamedArgTag();

    public ClassTag<Trees.AssignApi> AssignTag();

    public ClassTag<Trees.BindApi> BindTag();

    public ClassTag<Trees.BlockApi> BlockTag();

    public ClassTag<Trees.CaseDefApi> CaseDefTag();

    public ClassTag<Trees.ClassDefApi> ClassDefTag();

    public ClassTag<Trees.CompoundTypeTreeApi> CompoundTypeTreeTag();

    public ClassTag<Trees.DefDefApi> DefDefTag();

    public ClassTag<Trees.DefTreeApi> DefTreeTag();

    public ClassTag<Trees.ExistentialTypeTreeApi> ExistentialTypeTreeTag();

    public ClassTag<Trees.FunctionApi> FunctionTag();

    public ClassTag<Trees.GenericApplyApi> GenericApplyTag();

    public ClassTag<Trees.IdentApi> IdentTag();

    public ClassTag<Trees.IfApi> IfTag();

    public ClassTag<Trees.ImplDefApi> ImplDefTag();

    public ClassTag<Trees.ImportSelectorApi> ImportSelectorTag();

    public ClassTag<Trees.ImportApi> ImportTag();

    public ClassTag<Trees.LabelDefApi> LabelDefTag();

    public ClassTag<Trees.LiteralApi> LiteralTag();

    public ClassTag<Trees.MatchApi> MatchTag();

    public ClassTag<Trees.MemberDefApi> MemberDefTag();

    public ClassTag<Trees.ModuleDefApi> ModuleDefTag();

    public ClassTag<Trees.NameTreeApi> NameTreeTag();

    public ClassTag<Trees.NewApi> NewTag();

    public ClassTag<Trees.PackageDefApi> PackageDefTag();

    public ClassTag<Trees.RefTreeApi> RefTreeTag();

    public ClassTag<Trees.ReturnApi> ReturnTag();

    public ClassTag<Trees.SelectFromTypeTreeApi> SelectFromTypeTreeTag();

    public ClassTag<Trees.SelectApi> SelectTag();

    public ClassTag<Trees.SingletonTypeTreeApi> SingletonTypeTreeTag();

    public ClassTag<Trees.StarApi> StarTag();

    public ClassTag<Trees.SuperApi> SuperTag();

    public ClassTag<Trees.SymTreeApi> SymTreeTag();

    public ClassTag<Trees.TemplateApi> TemplateTag();

    public ClassTag<Trees.TermTreeApi> TermTreeTag();

    public ClassTag<Trees.ThisApi> ThisTag();

    public ClassTag<Trees.ThrowApi> ThrowTag();

    public ClassTag<Trees.TreeApi> TreeTag();

    public ClassTag<Trees.TryApi> TryTag();

    public ClassTag<Trees.TypTreeApi> TypTreeTag();

    public ClassTag<Trees.TypeApplyApi> TypeApplyTag();

    public ClassTag<Trees.TypeBoundsTreeApi> TypeBoundsTreeTag();

    public ClassTag<Trees.TypeDefApi> TypeDefTag();

    public ClassTag<Trees.TypeTreeApi> TypeTreeTag();

    public ClassTag<Trees.TypedApi> TypedTag();

    public ClassTag<Trees.UnApplyApi> UnApplyTag();

    public ClassTag<Trees.ValDefApi> ValDefTag();

    public ClassTag<Trees.ValOrDefDefApi> ValOrDefDefTag();

    public ClassTag<Trees.TreeCopierOps> TreeCopierTag();

    public ClassTag<Object> RuntimeClassTag();

    public ClassTag<Mirror> MirrorTag();
}

