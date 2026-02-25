/*
 * Decompiled with CFR 0.152.
 */
package com.typesafe.scalalogging;

import com.typesafe.scalalogging.LoggerMacro$;
import org.slf4j.Marker;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Exprs;
import scala.reflect.api.Trees;
import scala.reflect.macros.blackbox.Context;
import scala.runtime.BoxedUnit;

@ScalaSignature(bytes="\u0006\u0001\u0011}sAB\u0015+\u0011\u0003Q\u0003G\u0002\u00043U!\u0005!f\r\u0005\u0006u\u0005!\t\u0001P\u0003\u0005{\u0005\u0001a\bC\u0003Q\u0003\u0011\u0005\u0011\u000bC\u0003v\u0003\u0011\u0005a\u000fC\u0004\u0002\u0016\u0005!\t!a\u0006\t\u000f\u0005e\u0012\u0001\"\u0001\u0002<!9\u0011\u0011M\u0001\u0005\u0002\u0005\r\u0004bBA>\u0003\u0011\u0005\u0011Q\u0010\u0005\b\u0003/\u000bA\u0011AAM\u0011\u001d\t\t,\u0001C\u0001\u0003gCq!a1\u0002\t\u0003\t)\rC\u0004\u0002Z\u0006!\t!a7\t\u000f\u0005E\u0018\u0001\"\u0001\u0002t\"9!qA\u0001\u0005\u0002\t%\u0001b\u0002B\u0011\u0003\u0011\u0005!1\u0005\u0005\b\u0005{\tA\u0011\u0001B \u0011\u001d\u0011y%\u0001C\u0001\u0005#BqA!\u0019\u0002\t\u0003\u0011\u0019\u0007C\u0004\u0003x\u0005!\tA!\u001f\t\u000f\t=\u0015\u0001\"\u0001\u0003\u0012\"9!QU\u0001\u0005\u0002\t\u001d\u0006b\u0002B`\u0003\u0011\u0005!\u0011\u0019\u0005\b\u00057\fA\u0011\u0001Bo\u0011\u001d\u0011i/\u0001C\u0001\u0005_DqAa@\u0002\t\u0003\u0019\t\u0001C\u0004\u0004\u0016\u0005!\taa\u0006\t\u000f\r5\u0012\u0001\"\u0001\u00040!911I\u0001\u0005\u0002\r\u0015\u0003bBB/\u0003\u0011\u00051q\f\u0005\b\u0007s\nA\u0011AB>\u0011\u001d\u0019Y)\u0001C\u0001\u0007\u001bCqa!(\u0002\t\u0003\u0019y\nC\u0004\u00044\u0006!\ta!.\t\u000f\r-\u0017\u0001\"\u0001\u0004N\"91\u0011]\u0001\u0005\u0002\r\r\bbBB~\u0003\u0011\u00051Q \u0005\b\t/\tA\u0011\u0001C\r\u0011\u001d!I#\u0001C\u0005\tWAq\u0001b\u0013\u0002\t\u0013!i%A\u0006M_\u001e<WM]'bGJ|'BA\u0016-\u00031\u00198-\u00197bY><w-\u001b8h\u0015\tic&\u0001\u0005usB,7/\u00194f\u0015\u0005y\u0013aA2p[B\u0011\u0011'A\u0007\u0002U\tYAj\\4hKJl\u0015m\u0019:p'\t\tA\u0007\u0005\u00026q5\taGC\u00018\u0003\u0015\u00198-\u00197b\u0013\tIdG\u0001\u0004B]f\u0014VMZ\u0001\u0007y%t\u0017\u000e\u001e \u0004\u0001Q\t\u0001GA\u0007M_\u001e<WM]\"p]R,\u0007\u0010\u001e\n\u0003\u007f\u00053A\u0001Q\u0001\u0001}\taAH]3gS:,W.\u001a8u}A\u0011!)S\u0007\u0002\u0007*\u0011A)R\u0001\tE2\f7m\u001b2pq*\u0011aiR\u0001\u0007[\u0006\u001c'o\\:\u000b\u0005!3\u0014a\u0002:fM2,7\r^\u0005\u0003\u0015\u000e\u0013qaQ8oi\u0016DH/\u0002\u0003M\u007f\u0001j%A\u0003)sK\u001aL\u0007\u0010V=qKB\u0011\u0011GT\u0005\u0003\u001f*\u0012a\u0001T8hO\u0016\u0014\u0018\u0001D3se>\u0014X*Z:tC\u001e,GC\u0001*X)\t\u00196\r\u0005\u0002U;:\u0011Qk\u0017\b\u0003-^c\u0001\u0001C\u0003Y\t\u0001\u0007\u0011,A\u0001d!\tQ6!D\u0001\u0002\u0013\ta\u0016*\u0001\u0005v]&4XM]:f\u0013\tqvL\u0001\u0003Ue\u0016,\u0017B\u00011b\u0005\u0015!&/Z3t\u0015\t\u0011w)A\u0002ba&DQ\u0001\u001a\u0003A\u0002\u0015\fq!\\3tg\u0006<W\rE\u0002VM*L!a\u001a5\u0003\t\u0015C\bO]\u0005\u0003S\u0016\u0013q!\u00117jCN,7\u000f\u0005\u0002le:\u0011A\u000e\u001d\t\u0003[Zj\u0011A\u001c\u0006\u0003_n\na\u0001\u0010:p_Rt\u0014BA97\u0003\u0019\u0001&/\u001a3fM&\u00111\u000f\u001e\u0002\u0007'R\u0014\u0018N\\4\u000b\u0005E4\u0014!E3se>\u0014X*Z:tC\u001e,7)Y;tKR\u0011qo\u001f\u000b\u0004qrt\bCA=^\u001d\tQ8L\u0004\u0002Ww\")\u0001,\u0002a\u00013\")A-\u0002a\u0001{B\u0019!P\u001a6\t\r},\u0001\u0019AA\u0001\u0003\u0015\u0019\u0017-^:f!\u0011Qh-a\u0001\u0011\t\u0005\u0015\u0011q\u0002\b\u0005\u0003\u000f\tYAD\u0002n\u0003\u0013I\u0011aN\u0005\u0004\u0003\u001b1\u0014a\u00029bG.\fw-Z\u0005\u0005\u0003#\t\u0019BA\u0005UQJ|w/\u00192mK*\u0019\u0011Q\u0002\u001c\u0002!\u0015\u0014(o\u001c:NKN\u001c\u0018mZ3Be\u001e\u001cH\u0003BA\r\u0003C!b!a\u0007\u0002$\u0005\u001d\u0002cAA\u000f;:\u0019\u0011qD.\u000f\u0007Y\u000b\t\u0003C\u0003Y\r\u0001\u0007\u0011\f\u0003\u0004e\r\u0001\u0007\u0011Q\u0005\t\u0005\u0003?1'\u000eC\u0004\u0002*\u0019\u0001\r!a\u000b\u0002\t\u0005\u0014xm\u001d\t\u0006k\u00055\u0012\u0011G\u0005\u0004\u0003_1$A\u0003\u001fsKB,\u0017\r^3e}A)\u0011q\u00044\u00024A\u0019Q'!\u000e\n\u0007\u0005]bGA\u0002B]f\f!#\u001a:s_JlUm]:bO\u0016l\u0015M]6feR!\u0011QHA#)\u0019\ty$a\u0012\u0002^A\u0019\u0011\u0011I/\u000f\u0007\u0005\r3LD\u0002W\u0003\u000bBQ\u0001W\u0004A\u0002eCq!!\u0013\b\u0001\u0004\tY%\u0001\u0004nCJ\\WM\u001d\t\u0006\u0003\u00072\u0017Q\n\t\u0005\u0003\u001f\nI&\u0004\u0002\u0002R)!\u00111KA+\u0003\u0015\u0019HN\u001a\u001bk\u0015\t\t9&A\u0002pe\u001eLA!a\u0017\u0002R\t1Q*\u0019:lKJDa\u0001Z\u0004A\u0002\u0005}\u0003\u0003BA\"M*\fq#\u001a:s_JlUm]:bO\u0016\u001c\u0015-^:f\u001b\u0006\u00148.\u001a:\u0015\t\u0005\u0015\u0014Q\u000e\u000b\t\u0003O\ny'a\u001d\u0002xA\u0019\u0011\u0011N/\u000f\u0007\u0005-4LD\u0002W\u0003[BQ\u0001\u0017\u0005A\u0002eCq!!\u0013\t\u0001\u0004\t\t\bE\u0003\u0002l\u0019\fi\u0005\u0003\u0004e\u0011\u0001\u0007\u0011Q\u000f\t\u0005\u0003W2'\u000e\u0003\u0004\u0000\u0011\u0001\u0007\u0011\u0011\u0010\t\u0006\u0003W2\u00171A\u0001\u0017KJ\u0014xN]'fgN\fw-Z!sONl\u0015M]6feR!\u0011qPAD)!\t\t)!#\u0002\u000e\u0006E\u0005cAAB;:\u0019\u0011QQ.\u000f\u0007Y\u000b9\tC\u0003Y\u0013\u0001\u0007\u0011\fC\u0004\u0002J%\u0001\r!a#\u0011\u000b\u0005\u0015e-!\u0014\t\r\u0011L\u0001\u0019AAH!\u0011\t)I\u001a6\t\u000f\u0005%\u0012\u00021\u0001\u0002\u0014B)Q'!\f\u0002\u0016B)\u0011Q\u00114\u00024\u0005IQM\u001d:pe\u000e{G-\u001a\u000b\u0005\u00037\u000b\u0019\u000b\u0006\u0003\u0002\u001e\u0006\u0015\u0006cAAP;:\u0019\u0011\u0011U.\u000f\u0007Y\u000b\u0019\u000bC\u0003Y\u0015\u0001\u0007\u0011\fC\u0004\u0002(*\u0001\r!!+\u0002\t\t|G-\u001f\t\u0006\u0003C3\u00171\u0016\t\u0004k\u00055\u0016bAAXm\t!QK\\5u\u0003-9\u0018M\u001d8NKN\u001c\u0018mZ3\u0015\t\u0005U\u0016Q\u0018\u000b\u0005\u0003o\u000by\fE\u0002\u0002:vs1!a/\\\u001d\r1\u0016Q\u0018\u0005\u00061.\u0001\r!\u0017\u0005\u0007I.\u0001\r!!1\u0011\t\u0005mfM[\u0001\u0011o\u0006\u0014h.T3tg\u0006<WmQ1vg\u0016$B!a2\u0002PR1\u0011\u0011ZAi\u0003+\u00042!a3^\u001d\r\tim\u0017\b\u0004-\u0006=\u0007\"\u0002-\r\u0001\u0004I\u0006B\u00023\r\u0001\u0004\t\u0019\u000e\u0005\u0003\u0002N\u001aT\u0007BB@\r\u0001\u0004\t9\u000eE\u0003\u0002N\u001a\f\u0019!A\bxCJtW*Z:tC\u001e,\u0017I]4t)\u0011\ti.!:\u0015\r\u0005}\u0017q]Av!\r\t\t/\u0018\b\u0004\u0003G\\fb\u0001,\u0002f\")\u0001,\u0004a\u00013\"1A-\u0004a\u0001\u0003S\u0004B!a9gU\"9\u0011\u0011F\u0007A\u0002\u00055\b#B\u001b\u0002.\u0005=\b#BArM\u0006M\u0012!E<be:lUm]:bO\u0016l\u0015M]6feR!\u0011Q_A\u007f)\u0019\t90a@\u0003\u0004A\u0019\u0011\u0011`/\u000f\u0007\u0005m8LD\u0002W\u0003{DQ\u0001\u0017\bA\u0002eCq!!\u0013\u000f\u0001\u0004\u0011\t\u0001E\u0003\u0002|\u001a\fi\u0005\u0003\u0004e\u001d\u0001\u0007!Q\u0001\t\u0005\u0003w4'.\u0001\fxCJtW*Z:tC\u001e,7)Y;tK6\u000b'o[3s)\u0011\u0011YAa\u0005\u0015\u0011\t5!Q\u0003B\r\u0005;\u00012Aa\u0004^\u001d\r\u0011\tb\u0017\b\u0004-\nM\u0001\"\u0002-\u0010\u0001\u0004I\u0006bBA%\u001f\u0001\u0007!q\u0003\t\u0006\u0005#1\u0017Q\n\u0005\u0007I>\u0001\rAa\u0007\u0011\t\tEaM\u001b\u0005\u0007\u007f>\u0001\rAa\b\u0011\u000b\tEa-a\u0001\u0002+]\f'O\\'fgN\fw-Z!sONl\u0015M]6feR!!Q\u0005B\u0017)!\u00119Ca\f\u00034\t]\u0002c\u0001B\u0015;:\u0019!1F.\u000f\u0007Y\u0013i\u0003C\u0003Y!\u0001\u0007\u0011\fC\u0004\u0002JA\u0001\rA!\r\u0011\u000b\t-b-!\u0014\t\r\u0011\u0004\u0002\u0019\u0001B\u001b!\u0011\u0011YC\u001a6\t\u000f\u0005%\u0002\u00031\u0001\u0003:A)Q'!\f\u0003<A)!1\u00064\u00024\u0005Aq/\u0019:o\u0007>$W\r\u0006\u0003\u0003B\t%C\u0003\u0002B\"\u0005\u0017\u00022A!\u0012^\u001d\r\u00119e\u0017\b\u0004-\n%\u0003\"\u0002-\u0012\u0001\u0004I\u0006bBAT#\u0001\u0007!Q\n\t\u0006\u0005\u000f2\u00171V\u0001\fS:4w.T3tg\u0006<W\r\u0006\u0003\u0003T\tmC\u0003\u0002B+\u0005;\u00022Aa\u0016^\u001d\r\u0011If\u0017\b\u0004-\nm\u0003\"\u0002-\u0013\u0001\u0004I\u0006B\u00023\u0013\u0001\u0004\u0011y\u0006\u0005\u0003\u0003Z\u0019T\u0017\u0001E5oM>lUm]:bO\u0016\u001c\u0015-^:f)\u0011\u0011)G!\u001c\u0015\r\t\u001d$q\u000eB:!\r\u0011I'\u0018\b\u0004\u0005WZfb\u0001,\u0003n!)\u0001l\u0005a\u00013\"1Am\u0005a\u0001\u0005c\u0002BAa\u001bgU\"1qp\u0005a\u0001\u0005k\u0002RAa\u001bg\u0003\u0007\tq\"\u001b8g_6+7o]1hK\u0006\u0013xm\u001d\u000b\u0005\u0005w\u0012\u0019\t\u0006\u0004\u0003~\t\u0015%\u0011\u0012\t\u0004\u0005\u007fjfb\u0001BA7:\u0019aKa!\t\u000ba#\u0002\u0019A-\t\r\u0011$\u0002\u0019\u0001BD!\u0011\u0011\tI\u001a6\t\u000f\u0005%B\u00031\u0001\u0003\fB)Q'!\f\u0003\u000eB)!\u0011\u00114\u00024\u0005\t\u0012N\u001c4p\u001b\u0016\u001c8/Y4f\u001b\u0006\u00148.\u001a:\u0015\t\tM%1\u0014\u000b\u0007\u0005+\u0013iJ!)\u0011\u0007\t]ULD\u0002\u0003\u001ans1A\u0016BN\u0011\u0015AV\u00031\u0001Z\u0011\u001d\tI%\u0006a\u0001\u0005?\u0003RA!'g\u0003\u001bBa\u0001Z\u000bA\u0002\t\r\u0006\u0003\u0002BMM*\fa#\u001b8g_6+7o]1hK\u000e\u000bWo]3NCJ\\WM\u001d\u000b\u0005\u0005S\u0013\t\f\u0006\u0005\u0003,\nM&q\u0017B^!\r\u0011i+\u0018\b\u0004\u0005_[fb\u0001,\u00032\")\u0001L\u0006a\u00013\"9\u0011\u0011\n\fA\u0002\tU\u0006#\u0002BXM\u00065\u0003B\u00023\u0017\u0001\u0004\u0011I\f\u0005\u0003\u00030\u001aT\u0007BB@\u0017\u0001\u0004\u0011i\fE\u0003\u00030\u001a\f\u0019!A\u000bj]\u001a|W*Z:tC\u001e,\u0017I]4t\u001b\u0006\u00148.\u001a:\u0015\t\t\r'1\u001a\u000b\t\u0005\u000b\u0014iM!5\u0003VB\u0019!qY/\u000f\u0007\t%7LD\u0002W\u0005\u0017DQ\u0001W\fA\u0002eCq!!\u0013\u0018\u0001\u0004\u0011y\rE\u0003\u0003J\u001a\fi\u0005\u0003\u0004e/\u0001\u0007!1\u001b\t\u0005\u0005\u00134'\u000eC\u0004\u0002*]\u0001\rAa6\u0011\u000bU\niC!7\u0011\u000b\t%g-a\r\u0002\u0011%tgm\\\"pI\u0016$BAa8\u0003hR!!\u0011\u001dBu!\r\u0011\u0019/\u0018\b\u0004\u0005K\\fb\u0001,\u0003h\")\u0001\f\u0007a\u00013\"9\u0011q\u0015\rA\u0002\t-\b#\u0002BsM\u0006-\u0016\u0001\u00043fEV<W*Z:tC\u001e,G\u0003\u0002By\u0005s$BAa=\u0003|B\u0019!Q_/\u000f\u0007\t]8LD\u0002W\u0005sDQ\u0001W\rA\u0002eCa\u0001Z\rA\u0002\tu\b\u0003\u0002B|M*\f\u0011\u0003Z3ck\u001elUm]:bO\u0016\u001c\u0015-^:f)\u0011\u0019\u0019aa\u0003\u0015\r\r\u00151QBB\t!\r\u00199!\u0018\b\u0004\u0007\u0013Yfb\u0001,\u0004\f!)\u0001L\u0007a\u00013\"1AM\u0007a\u0001\u0007\u001f\u0001Ba!\u0003gU\"1qP\u0007a\u0001\u0007'\u0001Ra!\u0003g\u0003\u0007\t\u0001\u0003Z3ck\u001elUm]:bO\u0016\f%oZ:\u0015\t\re1\u0011\u0005\u000b\u0007\u00077\u0019\u0019ca\n\u0011\u0007\ruQLD\u0002\u0004 ms1AVB\u0011\u0011\u0015A6\u00041\u0001Z\u0011\u0019!7\u00041\u0001\u0004&A!1q\u00044k\u0011\u001d\tIc\u0007a\u0001\u0007S\u0001R!NA\u0017\u0007W\u0001Raa\bg\u0003g\t!\u0003Z3ck\u001elUm]:bO\u0016l\u0015M]6feR!1\u0011GB\u001d)\u0019\u0019\u0019da\u000f\u0004@A\u00191QG/\u000f\u0007\r]2LD\u0002W\u0007sAQ\u0001\u0017\u000fA\u0002eCq!!\u0013\u001d\u0001\u0004\u0019i\u0004E\u0003\u00048\u0019\fi\u0005\u0003\u0004e9\u0001\u00071\u0011\t\t\u0005\u0007o1'.A\feK\n,x-T3tg\u0006<WmQ1vg\u0016l\u0015M]6feR!1qIB()!\u0019Ie!\u0015\u0004V\re\u0003cAB&;:\u00191QJ.\u000f\u0007Y\u001by\u0005C\u0003Y;\u0001\u0007\u0011\fC\u0004\u0002Ju\u0001\raa\u0015\u0011\u000b\r5c-!\u0014\t\r\u0011l\u0002\u0019AB,!\u0011\u0019iE\u001a6\t\r}l\u0002\u0019AB.!\u0015\u0019iEZA\u0002\u0003Y!WMY;h\u001b\u0016\u001c8/Y4f\u0003J<7/T1sW\u0016\u0014H\u0003BB1\u0007S\"\u0002ba\u0019\u0004l\r=41\u000f\t\u0004\u0007KjfbAB47:\u0019ak!\u001b\t\u000bas\u0002\u0019A-\t\u000f\u0005%c\u00041\u0001\u0004nA)1q\r4\u0002N!1AM\ba\u0001\u0007c\u0002Baa\u001agU\"9\u0011\u0011\u0006\u0010A\u0002\rU\u0004#B\u001b\u0002.\r]\u0004#BB4M\u0006M\u0012!\u00033fEV<7i\u001c3f)\u0011\u0019ih!\"\u0015\t\r}4q\u0011\t\u0004\u0007\u0003kfbABB7:\u0019ak!\"\t\u000ba{\u0002\u0019A-\t\u000f\u0005\u001dv\u00041\u0001\u0004\nB)11\u00114\u0002,\u0006aAO]1dK6+7o]1hKR!1qRBL)\u0011\u0019\tj!'\u0011\u0007\rMULD\u0002\u0004\u0016ns1AVBL\u0011\u0015A\u0006\u00051\u0001Z\u0011\u0019!\u0007\u00051\u0001\u0004\u001cB!1Q\u00134k\u0003E!(/Y2f\u001b\u0016\u001c8/Y4f\u0007\u0006,8/\u001a\u000b\u0005\u0007C\u001bI\u000b\u0006\u0004\u0004$\u000e-6q\u0016\t\u0004\u0007KkfbABT7:\u0019ak!+\t\u000ba\u000b\u0003\u0019A-\t\r\u0011\f\u0003\u0019ABW!\u0011\u00199K\u001a6\t\r}\f\u0003\u0019ABY!\u0015\u00199KZA\u0002\u0003A!(/Y2f\u001b\u0016\u001c8/Y4f\u0003J<7\u000f\u0006\u0003\u00048\u000e}FCBB]\u0007\u0003\u001c)\rE\u0002\u0004<vs1a!0\\\u001d\r16q\u0018\u0005\u00061\n\u0002\r!\u0017\u0005\u0007I\n\u0002\raa1\u0011\t\rufM\u001b\u0005\b\u0003S\u0011\u0003\u0019ABd!\u0015)\u0014QFBe!\u0015\u0019iLZA\u001a\u0003I!(/Y2f\u001b\u0016\u001c8/Y4f\u001b\u0006\u00148.\u001a:\u0015\t\r=7q\u001b\u000b\u0007\u0007#\u001cIn!8\u0011\u0007\rMWLD\u0002\u0004Vns1AVBl\u0011\u0015A6\u00051\u0001Z\u0011\u001d\tIe\ta\u0001\u00077\u0004Ra!6g\u0003\u001bBa\u0001Z\u0012A\u0002\r}\u0007\u0003BBkM*\fq\u0003\u001e:bG\u0016lUm]:bO\u0016\u001c\u0015-^:f\u001b\u0006\u00148.\u001a:\u0015\t\r\u00158Q\u001e\u000b\t\u0007O\u001cyoa=\u0004xB\u00191\u0011^/\u000f\u0007\r-8LD\u0002W\u0007[DQ\u0001\u0017\u0013A\u0002eCq!!\u0013%\u0001\u0004\u0019\t\u0010E\u0003\u0004l\u001a\fi\u0005\u0003\u0004eI\u0001\u00071Q\u001f\t\u0005\u0007W4'\u000e\u0003\u0004\u0000I\u0001\u00071\u0011 \t\u0006\u0007W4\u00171A\u0001\u0017iJ\f7-Z'fgN\fw-Z!sONl\u0015M]6feR!1q C\u0004)!!\t\u0001\"\u0003\u0005\u000e\u0011E\u0001c\u0001C\u0002;:\u0019AQA.\u000f\u0007Y#9\u0001C\u0003YK\u0001\u0007\u0011\fC\u0004\u0002J\u0015\u0002\r\u0001b\u0003\u0011\u000b\u0011\u0015a-!\u0014\t\r\u0011,\u0003\u0019\u0001C\b!\u0011!)A\u001a6\t\u000f\u0005%R\u00051\u0001\u0005\u0014A)Q'!\f\u0005\u0016A)AQ\u00014\u00024\u0005IAO]1dK\u000e{G-\u001a\u000b\u0005\t7!\u0019\u0003\u0006\u0003\u0005\u001e\u0011\u0015\u0002c\u0001C\u0010;:\u0019A\u0011E.\u000f\u0007Y#\u0019\u0003C\u0003YM\u0001\u0007\u0011\fC\u0004\u0002(\u001a\u0002\r\u0001b\n\u0011\u000b\u0011\u0005b-a+\u0002=\u0011,7m\u001c8tiJ,8\r^%oi\u0016\u0014\bo\u001c7bi\u0016$W*Z:tC\u001e,G\u0003\u0002C\u0017\ts!B\u0001b\f\u0005JA9Q\u0007\"\r\u00056\u0011m\u0012b\u0001C\u001am\t1A+\u001e9mKJ\u0002B\u0001b\u000egU:\u0019a\u000b\"\u000f\t\u000ba;\u0003\u0019A-\u0011\r\u0011uB1\tC$\u001b\t!yDC\u0002\u0005BY\n!bY8mY\u0016\u001cG/[8o\u0013\u0011!)\u0005b\u0010\u0003\u0007M+\u0017\u000fE\u0003\u00058\u0019\f\u0019\u0004\u0003\u0004eO\u0001\u0007AQG\u0001\u000bM>\u0014X.\u0019;Be\u001e\u001cH\u0003\u0002C(\t/\"B\u0001\"\u0015\u0005ZA1AQ\bC\"\t'\u0002B\u0001\"\u0016gi9\u0019a\u000bb\u0016\t\u000baC\u0003\u0019A-\t\u000f\u0005%\u0002\u00061\u0001\u0005\\A)Q'!\f\u0005^A)AQ\u000b4\u00024\u0001")
public final class LoggerMacro {
    public static Trees.TreeApi traceCode(Context context, Exprs.Expr<BoxedUnit> expr) {
        return LoggerMacro$.MODULE$.traceCode(context, expr);
    }

    public static Trees.TreeApi traceMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.traceMessageArgsMarker(context, expr, expr2, seq);
    }

    public static Trees.TreeApi traceMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3) {
        return LoggerMacro$.MODULE$.traceMessageCauseMarker(context, expr, expr2, expr3);
    }

    public static Trees.TreeApi traceMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2) {
        return LoggerMacro$.MODULE$.traceMessageMarker(context, expr, expr2);
    }

    public static Trees.TreeApi traceMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.traceMessageArgs(context, expr, seq);
    }

    public static Trees.TreeApi traceMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2) {
        return LoggerMacro$.MODULE$.traceMessageCause(context, expr, expr2);
    }

    public static Trees.TreeApi traceMessage(Context context, Exprs.Expr<String> expr) {
        return LoggerMacro$.MODULE$.traceMessage(context, expr);
    }

    public static Trees.TreeApi debugCode(Context context, Exprs.Expr<BoxedUnit> expr) {
        return LoggerMacro$.MODULE$.debugCode(context, expr);
    }

    public static Trees.TreeApi debugMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.debugMessageArgsMarker(context, expr, expr2, seq);
    }

    public static Trees.TreeApi debugMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3) {
        return LoggerMacro$.MODULE$.debugMessageCauseMarker(context, expr, expr2, expr3);
    }

    public static Trees.TreeApi debugMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2) {
        return LoggerMacro$.MODULE$.debugMessageMarker(context, expr, expr2);
    }

    public static Trees.TreeApi debugMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.debugMessageArgs(context, expr, seq);
    }

    public static Trees.TreeApi debugMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2) {
        return LoggerMacro$.MODULE$.debugMessageCause(context, expr, expr2);
    }

    public static Trees.TreeApi debugMessage(Context context, Exprs.Expr<String> expr) {
        return LoggerMacro$.MODULE$.debugMessage(context, expr);
    }

    public static Trees.TreeApi infoCode(Context context, Exprs.Expr<BoxedUnit> expr) {
        return LoggerMacro$.MODULE$.infoCode(context, expr);
    }

    public static Trees.TreeApi infoMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.infoMessageArgsMarker(context, expr, expr2, seq);
    }

    public static Trees.TreeApi infoMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3) {
        return LoggerMacro$.MODULE$.infoMessageCauseMarker(context, expr, expr2, expr3);
    }

    public static Trees.TreeApi infoMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2) {
        return LoggerMacro$.MODULE$.infoMessageMarker(context, expr, expr2);
    }

    public static Trees.TreeApi infoMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.infoMessageArgs(context, expr, seq);
    }

    public static Trees.TreeApi infoMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2) {
        return LoggerMacro$.MODULE$.infoMessageCause(context, expr, expr2);
    }

    public static Trees.TreeApi infoMessage(Context context, Exprs.Expr<String> expr) {
        return LoggerMacro$.MODULE$.infoMessage(context, expr);
    }

    public static Trees.TreeApi warnCode(Context context, Exprs.Expr<BoxedUnit> expr) {
        return LoggerMacro$.MODULE$.warnCode(context, expr);
    }

    public static Trees.TreeApi warnMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.warnMessageArgsMarker(context, expr, expr2, seq);
    }

    public static Trees.TreeApi warnMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3) {
        return LoggerMacro$.MODULE$.warnMessageCauseMarker(context, expr, expr2, expr3);
    }

    public static Trees.TreeApi warnMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2) {
        return LoggerMacro$.MODULE$.warnMessageMarker(context, expr, expr2);
    }

    public static Trees.TreeApi warnMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.warnMessageArgs(context, expr, seq);
    }

    public static Trees.TreeApi warnMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2) {
        return LoggerMacro$.MODULE$.warnMessageCause(context, expr, expr2);
    }

    public static Trees.TreeApi warnMessage(Context context, Exprs.Expr<String> expr) {
        return LoggerMacro$.MODULE$.warnMessage(context, expr);
    }

    public static Trees.TreeApi errorCode(Context context, Exprs.Expr<BoxedUnit> expr) {
        return LoggerMacro$.MODULE$.errorCode(context, expr);
    }

    public static Trees.TreeApi errorMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.errorMessageArgsMarker(context, expr, expr2, seq);
    }

    public static Trees.TreeApi errorMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3) {
        return LoggerMacro$.MODULE$.errorMessageCauseMarker(context, expr, expr2, expr3);
    }

    public static Trees.TreeApi errorMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2) {
        return LoggerMacro$.MODULE$.errorMessageMarker(context, expr, expr2);
    }

    public static Trees.TreeApi errorMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq) {
        return LoggerMacro$.MODULE$.errorMessageArgs(context, expr, seq);
    }

    public static Trees.TreeApi errorMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2) {
        return LoggerMacro$.MODULE$.errorMessageCause(context, expr, expr2);
    }

    public static Trees.TreeApi errorMessage(Context context, Exprs.Expr<String> expr) {
        return LoggerMacro$.MODULE$.errorMessage(context, expr);
    }
}

