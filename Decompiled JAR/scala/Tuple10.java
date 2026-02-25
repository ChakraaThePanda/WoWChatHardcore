/*
 * Decompiled with CFR 0.152.
 */
package scala;

import scala.Option;
import scala.Product;
import scala.Product10;
import scala.Serializable;
import scala.Tuple10$;
import scala.collection.Iterator;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.runtime.ScalaRunTime$;

@ScalaSignature(bytes="\u0006\u0001\r%d\u0001\u0002\u00180\u0005JB\u0001b\u001a\u0001\u0003\u0016\u0004%\t\u0001\u001b\u0005\tS\u0002\u0011\t\u0012)A\u0005w!A!\u000e\u0001BK\u0002\u0013\u00051\u000e\u0003\u0005m\u0001\tE\t\u0015!\u0003G\u0011!i\u0007A!f\u0001\n\u0003q\u0007\u0002C8\u0001\u0005#\u0005\u000b\u0011B%\t\u0011A\u0004!Q3A\u0005\u0002ED\u0001B\u001d\u0001\u0003\u0012\u0003\u0006I\u0001\u0014\u0005\tg\u0002\u0011)\u001a!C\u0001i\"AQ\u000f\u0001B\tB\u0003%q\n\u0003\u0005w\u0001\tU\r\u0011\"\u0001x\u0011!A\bA!E!\u0002\u0013\u0011\u0006\u0002C=\u0001\u0005+\u0007I\u0011\u0001>\t\u0011m\u0004!\u0011#Q\u0001\nUC\u0001\u0002 \u0001\u0003\u0016\u0004%\t! \u0005\t}\u0002\u0011\t\u0012)A\u00051\"Iq\u0010\u0001BK\u0002\u0013\u0005\u0011\u0011\u0001\u0005\n\u0003\u0007\u0001!\u0011#Q\u0001\nmC!\"!\u0002\u0001\u0005+\u0007I\u0011AA\u0004\u0011%\tI\u0001\u0001B\tB\u0003%a\fC\u0004\u0002\f\u0001!\t!!\u0004\t\u000f\u0005\u0015\u0002\u0001\"\u0011\u0002(!I\u0011\u0011\b\u0001\u0002\u0002\u0013\u0005\u00111\b\u0005\n\u0003{\u0002\u0011\u0013!C\u0001\u0003\u007fB\u0011\"a+\u0001#\u0003%\t!!,\t\u0013\u0005\u001d\u0007!%A\u0005\u0002\u0005%\u0007\"CAr\u0001E\u0005I\u0011AAs\u0011%\ty\u0010AI\u0001\n\u0003\u0011\t\u0001C\u0005\u0003\u001c\u0001\t\n\u0011\"\u0001\u0003\u001e!I!q\u0007\u0001\u0012\u0002\u0013\u0005!\u0011\b\u0005\n\u0005'\u0002\u0011\u0013!C\u0001\u0005+B\u0011Ba\u001c\u0001#\u0003%\tA!\u001d\t\u0013\t-\u0005!%A\u0005\u0002\t5\u0005\"\u0003BT\u0001\u0005\u0005I\u0011\tBU\u0011%\u0011Y\u000bAA\u0001\n\u0003\u0012i\u000bC\u0005\u0003<\u0002\t\t\u0011\"\u0001\u0003>\"I!\u0011\u001a\u0001\u0002\u0002\u0013\u0005#1\u001a\u0005\n\u0005'\u0004\u0011\u0011!C!\u0005+<\u0011B!70\u0003\u0003E\tAa7\u0007\u00119z\u0013\u0011!E\u0001\u0005;Dq!a\u0003)\t\u0003\u0011y\u000eC\u0005\u0002&!\n\t\u0011\"\u0012\u0002(!I!\u0011\u001d\u0015\u0002\u0002\u0013\u0005%1\u001d\u0005\n\u0007KA\u0013\u0011!CA\u0007OA\u0011ba\u0018)\u0003\u0003%Ia!\u0019\u0003\u000fQ+\b\u000f\\32a)\t\u0001'A\u0003tG\u0006d\u0017m\u0001\u0001\u0016\u0017MjtIS'Q'ZKFlX\n\u0006\u0001QB\u0014\r\u001a\t\u0003kYj\u0011aL\u0005\u0003o=\u0012a!\u00118z%\u00164\u0007\u0003D\u001b:w\u0019KEj\u0014*V1ns\u0016B\u0001\u001e0\u0005%\u0001&o\u001c3vGR\f\u0004\u0007\u0005\u0002={1\u0001AA\u0002 \u0001\t\u000b\u0007qH\u0001\u0002UcE\u0011\u0001i\u0011\t\u0003k\u0005K!AQ\u0018\u0003\u000f9{G\u000f[5oOB\u0011Q\u0007R\u0005\u0003\u000b>\u00121!\u00118z!\tat\t\u0002\u0004I\u0001\u0011\u0015\ra\u0010\u0002\u0003)J\u0002\"\u0001\u0010&\u0005\r-\u0003AQ1\u0001@\u0005\t!6\u0007\u0005\u0002=\u001b\u00121a\n\u0001CC\u0002}\u0012!\u0001\u0016\u001b\u0011\u0005q\u0002FAB)\u0001\t\u000b\u0007qH\u0001\u0002UkA\u0011Ah\u0015\u0003\u0007)\u0002!)\u0019A \u0003\u0005Q3\u0004C\u0001\u001fW\t\u00199\u0006\u0001\"b\u0001\u007f\t\u0011Ak\u000e\t\u0003ye#aA\u0017\u0001\u0005\u0006\u0004y$A\u0001+9!\taD\f\u0002\u0004^\u0001\u0011\u0015\ra\u0010\u0002\u0003)f\u0002\"\u0001P0\u0005\r\u0001\u0004AQ1\u0001@\u0005\r!\u0016\u0007\r\t\u0003k\tL!aY\u0018\u0003\u000fA\u0013x\u000eZ;diB\u0011Q'Z\u0005\u0003M>\u0012AbU3sS\u0006d\u0017N_1cY\u0016\f!aX\u0019\u0016\u0003m\n1aX\u0019!\u0003\ty&'F\u0001G\u0003\ry&\u0007I\u0001\u0003?N*\u0012!S\u0001\u0004?N\u0002\u0013AA05+\u0005a\u0015aA05A\u0005\u0011q,N\u000b\u0002\u001f\u0006\u0019q,\u000e\u0011\u0002\u0005}3T#\u0001*\u0002\u0007}3\u0004%\u0001\u0002`oU\tQ+A\u0002`o\u0001\n!a\u0018\u001d\u0016\u0003a\u000b1a\u0018\u001d!\u0003\ty\u0016(F\u0001\\\u0003\ry\u0016\bI\u0001\u0004?F\u0002T#\u00010\u0002\t}\u000b\u0004\u0007I\u0001\u0007y%t\u0017\u000e\u001e \u0015-\u0005=\u0011\u0011CA\n\u0003+\t9\"!\u0007\u0002\u001c\u0005u\u0011qDA\u0011\u0003G\u0001B\"\u000e\u0001<\r&cuJU+Y7zCQaZ\u000bA\u0002mBQA[\u000bA\u0002\u0019CQ!\\\u000bA\u0002%CQ\u0001]\u000bA\u00021CQa]\u000bA\u0002=CQA^\u000bA\u0002ICQ!_\u000bA\u0002UCQ\u0001`\u000bA\u0002aCQa`\u000bA\u0002mCa!!\u0002\u0016\u0001\u0004q\u0016\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0005\u0005%\u0002\u0003BA\u0016\u0003ki!!!\f\u000b\t\u0005=\u0012\u0011G\u0001\u0005Y\u0006twM\u0003\u0002\u00024\u0005!!.\u0019<b\u0013\u0011\t9$!\f\u0003\rM#(/\u001b8h\u0003\u0011\u0019w\u000e]=\u0016-\u0005u\u00121IA$\u0003\u0017\ny%a\u0015\u0002X\u0005m\u0013qLA2\u0003O\"b#a\u0010\u0002j\u0005-\u0014QNA8\u0003c\n\u0019(!\u001e\u0002x\u0005e\u00141\u0010\t\u0017k\u0001\t\t%!\u0012\u0002J\u00055\u0013\u0011KA+\u00033\ni&!\u0019\u0002fA\u0019A(a\u0011\u0005\u000by:\"\u0019A \u0011\u0007q\n9\u0005B\u0003I/\t\u0007q\bE\u0002=\u0003\u0017\"QaS\fC\u0002}\u00022\u0001PA(\t\u0015quC1\u0001@!\ra\u00141\u000b\u0003\u0006#^\u0011\ra\u0010\t\u0004y\u0005]C!\u0002+\u0018\u0005\u0004y\u0004c\u0001\u001f\u0002\\\u0011)qk\u0006b\u0001\u007fA\u0019A(a\u0018\u0005\u000bi;\"\u0019A \u0011\u0007q\n\u0019\u0007B\u0003^/\t\u0007q\bE\u0002=\u0003O\"Q\u0001Y\fC\u0002}B\u0001bZ\f\u0011\u0002\u0003\u0007\u0011\u0011\t\u0005\tU^\u0001\n\u00111\u0001\u0002F!AQn\u0006I\u0001\u0002\u0004\tI\u0005\u0003\u0005q/A\u0005\t\u0019AA'\u0011!\u0019x\u0003%AA\u0002\u0005E\u0003\u0002\u0003<\u0018!\u0003\u0005\r!!\u0016\t\u0011e<\u0002\u0013!a\u0001\u00033B\u0001\u0002`\f\u0011\u0002\u0003\u0007\u0011Q\f\u0005\t\u007f^\u0001\n\u00111\u0001\u0002b!I\u0011QA\f\u0011\u0002\u0003\u0007\u0011QM\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+Y\t\t)a&\u0002\u001a\u0006m\u0015QTAP\u0003C\u000b\u0019+!*\u0002(\u0006%VCAABU\rY\u0014QQ\u0016\u0003\u0003\u000f\u0003B!!#\u0002\u00146\u0011\u00111\u0012\u0006\u0005\u0003\u001b\u000by)A\u0005v]\u000eDWmY6fI*\u0019\u0011\u0011S\u0018\u0002\u0015\u0005tgn\u001c;bi&|g.\u0003\u0003\u0002\u0016\u0006-%!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\u0012)a\b\u0007b\u0001\u007f\u0011)\u0001\n\u0007b\u0001\u007f\u0011)1\n\u0007b\u0001\u007f\u0011)a\n\u0007b\u0001\u007f\u0011)\u0011\u000b\u0007b\u0001\u007f\u0011)A\u000b\u0007b\u0001\u007f\u0011)q\u000b\u0007b\u0001\u007f\u0011)!\f\u0007b\u0001\u007f\u0011)Q\f\u0007b\u0001\u007f\u0011)\u0001\r\u0007b\u0001\u007f\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u0012TCFAX\u0003g\u000b),a.\u0002:\u0006m\u0016QXA`\u0003\u0003\f\u0019-!2\u0016\u0005\u0005E&f\u0001$\u0002\u0006\u0012)a(\u0007b\u0001\u007f\u0011)\u0001*\u0007b\u0001\u007f\u0011)1*\u0007b\u0001\u007f\u0011)a*\u0007b\u0001\u007f\u0011)\u0011+\u0007b\u0001\u007f\u0011)A+\u0007b\u0001\u007f\u0011)q+\u0007b\u0001\u007f\u0011)!,\u0007b\u0001\u007f\u0011)Q,\u0007b\u0001\u007f\u0011)\u0001-\u0007b\u0001\u007f\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\u001aTCFAf\u0003\u001f\f\t.a5\u0002V\u0006]\u0017\u0011\\An\u0003;\fy.!9\u0016\u0005\u00055'fA%\u0002\u0006\u0012)aH\u0007b\u0001\u007f\u0011)\u0001J\u0007b\u0001\u007f\u0011)1J\u0007b\u0001\u007f\u0011)aJ\u0007b\u0001\u007f\u0011)\u0011K\u0007b\u0001\u007f\u0011)AK\u0007b\u0001\u007f\u0011)qK\u0007b\u0001\u007f\u0011)!L\u0007b\u0001\u007f\u0011)QL\u0007b\u0001\u007f\u0011)\u0001M\u0007b\u0001\u007f\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012\"TCFAt\u0003W\fi/a<\u0002r\u0006M\u0018Q_A|\u0003s\fY0!@\u0016\u0005\u0005%(f\u0001'\u0002\u0006\u0012)ah\u0007b\u0001\u007f\u0011)\u0001j\u0007b\u0001\u007f\u0011)1j\u0007b\u0001\u007f\u0011)aj\u0007b\u0001\u007f\u0011)\u0011k\u0007b\u0001\u007f\u0011)Ak\u0007b\u0001\u007f\u0011)qk\u0007b\u0001\u007f\u0011)!l\u0007b\u0001\u007f\u0011)Ql\u0007b\u0001\u007f\u0011)\u0001m\u0007b\u0001\u007f\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012*TC\u0006B\u0002\u0005\u000f\u0011IAa\u0003\u0003\u000e\t=!\u0011\u0003B\n\u0005+\u00119B!\u0007\u0016\u0005\t\u0015!fA(\u0002\u0006\u0012)a\b\bb\u0001\u007f\u0011)\u0001\n\bb\u0001\u007f\u0011)1\n\bb\u0001\u007f\u0011)a\n\bb\u0001\u007f\u0011)\u0011\u000b\bb\u0001\u007f\u0011)A\u000b\bb\u0001\u007f\u0011)q\u000b\bb\u0001\u007f\u0011)!\f\bb\u0001\u007f\u0011)Q\f\bb\u0001\u007f\u0011)\u0001\r\bb\u0001\u007f\u0005q1m\u001c9zI\u0011,g-Y;mi\u00122TC\u0006B\u0010\u0005G\u0011)Ca\n\u0003*\t-\"Q\u0006B\u0018\u0005c\u0011\u0019D!\u000e\u0016\u0005\t\u0005\"f\u0001*\u0002\u0006\u0012)a(\bb\u0001\u007f\u0011)\u0001*\bb\u0001\u007f\u0011)1*\bb\u0001\u007f\u0011)a*\bb\u0001\u007f\u0011)\u0011+\bb\u0001\u007f\u0011)A+\bb\u0001\u007f\u0011)q+\bb\u0001\u007f\u0011)!,\bb\u0001\u007f\u0011)Q,\bb\u0001\u007f\u0011)\u0001-\bb\u0001\u007f\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012:TC\u0006B\u001e\u0005\u007f\u0011\tEa\u0011\u0003F\t\u001d#\u0011\nB&\u0005\u001b\u0012yE!\u0015\u0016\u0005\tu\"fA+\u0002\u0006\u0012)aH\bb\u0001\u007f\u0011)\u0001J\bb\u0001\u007f\u0011)1J\bb\u0001\u007f\u0011)aJ\bb\u0001\u007f\u0011)\u0011K\bb\u0001\u007f\u0011)AK\bb\u0001\u007f\u0011)qK\bb\u0001\u007f\u0011)!L\bb\u0001\u007f\u0011)QL\bb\u0001\u007f\u0011)\u0001M\bb\u0001\u007f\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012BTC\u0006B,\u00057\u0012iFa\u0018\u0003b\t\r$Q\rB4\u0005S\u0012YG!\u001c\u0016\u0005\te#f\u0001-\u0002\u0006\u0012)ah\bb\u0001\u007f\u0011)\u0001j\bb\u0001\u007f\u0011)1j\bb\u0001\u007f\u0011)aj\bb\u0001\u007f\u0011)\u0011k\bb\u0001\u007f\u0011)Ak\bb\u0001\u007f\u0011)qk\bb\u0001\u007f\u0011)!l\bb\u0001\u007f\u0011)Ql\bb\u0001\u007f\u0011)\u0001m\bb\u0001\u007f\u0005q1m\u001c9zI\u0011,g-Y;mi\u0012JTC\u0006B:\u0005o\u0012IHa\u001f\u0003~\t}$\u0011\u0011BB\u0005\u000b\u00139I!#\u0016\u0005\tU$fA.\u0002\u0006\u0012)a\b\tb\u0001\u007f\u0011)\u0001\n\tb\u0001\u007f\u0011)1\n\tb\u0001\u007f\u0011)a\n\tb\u0001\u007f\u0011)\u0011\u000b\tb\u0001\u007f\u0011)A\u000b\tb\u0001\u007f\u0011)q\u000b\tb\u0001\u007f\u0011)!\f\tb\u0001\u007f\u0011)Q\f\tb\u0001\u007f\u0011)\u0001\r\tb\u0001\u007f\u0005y1m\u001c9zI\u0011,g-Y;mi\u0012\n\u0004'\u0006\f\u0003\u0010\nM%Q\u0013BL\u00053\u0013YJ!(\u0003 \n\u0005&1\u0015BS+\t\u0011\tJK\u0002_\u0003\u000b#QAP\u0011C\u0002}\"Q\u0001S\u0011C\u0002}\"QaS\u0011C\u0002}\"QAT\u0011C\u0002}\"Q!U\u0011C\u0002}\"Q\u0001V\u0011C\u0002}\"QaV\u0011C\u0002}\"QAW\u0011C\u0002}\"Q!X\u0011C\u0002}\"Q\u0001Y\u0011C\u0002}\nQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&DXCAA\u0015\u0003=\u0001(o\u001c3vGRLE/\u001a:bi>\u0014XC\u0001BX!\u0015\u0011\tLa.D\u001b\t\u0011\u0019LC\u0002\u00036>\n!bY8mY\u0016\u001cG/[8o\u0013\u0011\u0011ILa-\u0003\u0011%#XM]1u_J\f\u0001bY1o\u000bF,\u0018\r\u001c\u000b\u0005\u0005\u007f\u0013)\rE\u00026\u0005\u0003L1Aa10\u0005\u001d\u0011un\u001c7fC:D\u0001Ba2%\u0003\u0003\u0005\raQ\u0001\u0004q\u0012\n\u0014\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\t5\u0007cA\u001b\u0003P&\u0019!\u0011[\u0018\u0003\u0007%sG/\u0001\u0004fcV\fGn\u001d\u000b\u0005\u0005\u007f\u00139\u000e\u0003\u0005\u0003H\u001a\n\t\u00111\u0001D\u0003\u001d!V\u000f\u001d7fcA\u0002\"!\u000e\u0015\u0014\u0007!\"D\r\u0006\u0002\u0003\\\u0006)\u0011\r\u001d9msV1\"Q\u001dBv\u0005_\u0014\u0019Pa>\u0003|\n}81AB\u0004\u0007\u0017\u0019y\u0001\u0006\f\u0003h\u000eE11CB\u000b\u0007/\u0019Iba\u0007\u0004\u001e\r}1\u0011EB\u0012!Y)\u0004A!;\u0003n\nE(Q\u001fB}\u0005{\u001c\ta!\u0002\u0004\n\r5\u0001c\u0001\u001f\u0003l\u0012)ah\u000bb\u0001\u007fA\u0019AHa<\u0005\u000b![#\u0019A \u0011\u0007q\u0012\u0019\u0010B\u0003LW\t\u0007q\bE\u0002=\u0005o$QAT\u0016C\u0002}\u00022\u0001\u0010B~\t\u0015\t6F1\u0001@!\ra$q \u0003\u0006).\u0012\ra\u0010\t\u0004y\r\rA!B,,\u0005\u0004y\u0004c\u0001\u001f\u0004\b\u0011)!l\u000bb\u0001\u007fA\u0019Aha\u0003\u0005\u000bu[#\u0019A \u0011\u0007q\u001ay\u0001B\u0003aW\t\u0007q\b\u0003\u0004hW\u0001\u0007!\u0011\u001e\u0005\u0007U.\u0002\rA!<\t\r5\\\u0003\u0019\u0001By\u0011\u0019\u00018\u00061\u0001\u0003v\"11o\u000ba\u0001\u0005sDaA^\u0016A\u0002\tu\bBB=,\u0001\u0004\u0019\t\u0001\u0003\u0004}W\u0001\u00071Q\u0001\u0005\u0007\u007f.\u0002\ra!\u0003\t\u000f\u0005\u00151\u00061\u0001\u0004\u000e\u00059QO\\1qa2LXCFB\u0015\u0007k\u0019Id!\u0010\u0004B\r\u00153\u0011JB'\u0007#\u001a)f!\u0017\u0015\t\r-21\f\t\u0006k\r52\u0011G\u0005\u0004\u0007_y#AB(qi&|g\u000e\u0005\f6\u0001\rM2qGB\u001e\u0007\u007f\u0019\u0019ea\u0012\u0004L\r=31KB,!\ra4Q\u0007\u0003\u0006}1\u0012\ra\u0010\t\u0004y\reB!\u0002%-\u0005\u0004y\u0004c\u0001\u001f\u0004>\u0011)1\n\fb\u0001\u007fA\u0019Ah!\u0011\u0005\u000b9c#\u0019A \u0011\u0007q\u001a)\u0005B\u0003RY\t\u0007q\bE\u0002=\u0007\u0013\"Q\u0001\u0016\u0017C\u0002}\u00022\u0001PB'\t\u00159FF1\u0001@!\ra4\u0011\u000b\u0003\u000652\u0012\ra\u0010\t\u0004y\rUC!B/-\u0005\u0004y\u0004c\u0001\u001f\u0004Z\u0011)\u0001\r\fb\u0001\u007f!I1Q\f\u0017\u0002\u0002\u0003\u00071\u0011G\u0001\u0004q\u0012\u0002\u0014a\u0003:fC\u0012\u0014Vm]8mm\u0016$\"aa\u0019\u0011\t\u0005-2QM\u0005\u0005\u0007O\niC\u0001\u0004PE*,7\r\u001e")
public final class Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>
implements Product10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>,
Serializable {
    private final T1 _1;
    private final T2 _2;
    private final T3 _3;
    private final T4 _4;
    private final T5 _5;
    private final T6 _6;
    private final T7 _7;
    private final T8 _8;
    private final T9 _9;
    private final T10 _10;

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Option<Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> unapply(Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> tuple10) {
        return Tuple10$.MODULE$.unapply(tuple10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> apply(T1 T1, T2 T2, T3 T3, T4 T4, T5 T5, T6 T6, T7 T7, T8 T8, T9 T9, T10 T10) {
        return Tuple10$.MODULE$.apply(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10);
    }

    @Override
    public int productArity() {
        return Product10.productArity$(this);
    }

    @Override
    public Object productElement(int n) throws IndexOutOfBoundsException {
        return Product10.productElement$(this, n);
    }

    @Override
    public T1 _1() {
        return this._1;
    }

    @Override
    public T2 _2() {
        return this._2;
    }

    @Override
    public T3 _3() {
        return this._3;
    }

    @Override
    public T4 _4() {
        return this._4;
    }

    @Override
    public T5 _5() {
        return this._5;
    }

    @Override
    public T6 _6() {
        return this._6;
    }

    @Override
    public T7 _7() {
        return this._7;
    }

    @Override
    public T8 _8() {
        return this._8;
    }

    @Override
    public T9 _9() {
        return this._9;
    }

    @Override
    public T10 _10() {
        return this._10;
    }

    public String toString() {
        return new StringBuilder(11).append("(").append(this._1()).append(",").append(this._2()).append(",").append(this._3()).append(",").append(this._4()).append(",").append(this._5()).append(",").append(this._6()).append(",").append(this._7()).append(",").append(this._8()).append(",").append(this._9()).append(",").append(this._10()).append(")").toString();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> copy(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9, T10 _10) {
        return new Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10);
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T1 copy$default$1() {
        return this._1();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T10 copy$default$10() {
        return this._10();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T2 copy$default$2() {
        return this._2();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T3 copy$default$3() {
        return this._3();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T4 copy$default$4() {
        return this._4();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T5 copy$default$5() {
        return this._5();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T6 copy$default$6() {
        return this._6();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T7 copy$default$7() {
        return this._7();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T8 copy$default$8() {
        return this._8();
    }

    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> T9 copy$default$9() {
        return this._9();
    }

    @Override
    public String productPrefix() {
        return "Tuple10";
    }

    @Override
    public Iterator<Object> productIterator() {
        return ScalaRunTime$.MODULE$.typedProductIterator(this);
    }

    @Override
    public boolean canEqual(Object x$1) {
        return x$1 instanceof Tuple10;
    }

    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode(this);
    }

    @Override
    public boolean equals(Object x$1) {
        block3: {
            block2: {
                if (this == x$1) break block2;
                boolean bl = x$1 instanceof Tuple10;
                if (!bl) break block3;
                Tuple10 tuple10 = (Tuple10)x$1;
                if (!(BoxesRunTime.equals(this._1(), tuple10._1()) && BoxesRunTime.equals(this._2(), tuple10._2()) && BoxesRunTime.equals(this._3(), tuple10._3()) && BoxesRunTime.equals(this._4(), tuple10._4()) && BoxesRunTime.equals(this._5(), tuple10._5()) && BoxesRunTime.equals(this._6(), tuple10._6()) && BoxesRunTime.equals(this._7(), tuple10._7()) && BoxesRunTime.equals(this._8(), tuple10._8()) && BoxesRunTime.equals(this._9(), tuple10._9()) && BoxesRunTime.equals(this._10(), tuple10._10()))) break block3;
            }
            return true;
        }
        return false;
    }

    public Tuple10(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6, T7 _7, T8 _8, T9 _9, T10 _10) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        this._8 = _8;
        this._9 = _9;
        this._10 = _10;
        Product.$init$(this);
        Product10.$init$(this);
    }
}

