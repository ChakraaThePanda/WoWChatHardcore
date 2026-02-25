/*
 * Decompiled with CFR 0.152.
 */
package scala.reflect.runtime;

import java.util.concurrent.atomic.AtomicInteger;
import scala.Function0;
import scala.Serializable;
import scala.collection.immutable.List;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.reflect.internal.AnnotationInfos;
import scala.reflect.internal.Flags$;
import scala.reflect.internal.Names;
import scala.reflect.internal.Symbols;
import scala.reflect.internal.Types;
import scala.reflect.internal.util.Position;
import scala.reflect.runtime.Gil;
import scala.reflect.runtime.SymbolTable;
import scala.reflect.runtime.ThreadLocalStorage;

@ScalaSignature(bytes="\u0006\u0001\rEhAC&M!\u0003\r\tA\u0014*\u0004l\")Q\f\u0001C\u0001?\"A1\r\u0001EC\u0002\u0013%A\rC\u0003r\u0001\u0011E#\u000f\u0003\u0005w\u0001!\u0015\r\u0011\"\u0003e\u0011\u0015y\b\u0001\"\u0015s\u0011)\t\u0019\u0001\u0001EC\u0002\u0013%\u0011Q\u0001\u0005\b\u0003O\u0001A\u0011IA\u0015\u0011\u001d\tY\u0003\u0001C!\u0003[Aq!a\r\u0001\t\u0003\n)\u0004C\u0004\u0002L\u0001!\t%!\u0014\t\u0013\u0005U\u0005!%A\u0005\u0002\u0005]\u0005\"CAW\u0001E\u0005I\u0011AAX\u0011\u001d\t\u0019\f\u0001C!\u0003kC\u0011\"!3\u0001#\u0003%\t!a&\t\u0013\u0005-\u0007!%A\u0005\u0002\u0005=\u0006bBAg\u0001\u0011E\u0013q\u001a\u0004\n\u0003/\u0004\u0001\u0013aA\u0001\u00033DQ!X\t\u0005\u0002}Cq!a7\u0012\t\u0003\ni\u000eC\u0004\u0002pF!)%!=\t\u000f\u0005M\u0018\u0003\"\u0011\u0002v\"I!qB\tAB\u0013%!\u0011\u0003\u0005\n\u00057\t\u0002\u0019)C\u0005\u0005;A\u0011Ba\t\u0012\u0001\u0004&IA!\n\t\u0013\t%\u0012\u00031Q\u0005\n\t-\u0002b\u0002B\u0018#\u0011\u0005#\u0011\u0007\u0005\b\u0005s\tB\u0011\tB\u001e\u0011\u001d\u0011i$\u0005C\u0003\u0005\u007fAqA!\u0019\u0012\t\u000b\u0012\u0019\u0007C\u0004\u0003hE!\tE!\u001b\t\u000f\tU\u0014\u0003\"\u0011\u0003x!9!1Q\t\u0005B\t]\u0004b\u0002BC#\u0011\u0005#\u0011\u0003\u0005\b\u0005\u000f\u000bB\u0011\tB<\u0011\u001d\u0011I)\u0005C!\u0005\u0017CqA!%\u0012\t\u0003\u00129\bC\u0004\u0003\u0014F!\tE!&\t\u000f\te\u0015\u0003\"\u0011\u0003\u0016\"9!1T\t\u0005R\tu\u0005b\u0002B]#\u0011E#1\u0018\u0005\b\u0005\u0013\fB\u0011\u000bBf\u0011\u001d\u0011Y.\u0005C)\u0005;DqA!:\u0012\t#\u00129\u000fC\u0004\u0003vF!\tFa>\t\u000f\r\u0015\u0011\u0003\"\u0015\u0004\b!911C\t\u0005R\rU\u0001bBB\u0011#\u0011E31\u0005\u0005\b\u0007c\tB\u0011KB\u001a\u0011\u001d\u0019Y$\u0005C)\u0007{Aqa!\u0012\u0012\t#\u001a9\u0005C\u0004\u0004dE!\tf!\u001a\t\u001d\rE\u0014\u0003%A\u0002\u0002\u0003%I!!=\u0004t!q1QO\t\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0002v\u000e]\u0004BDB=#A\u0005\u0019\u0011!A\u0005\n\rm4q\u0010\u0005\u000f\u0007\u0003\u000b\u0002\u0013aA\u0001\u0002\u0013%!\u0011NBB\u00119\u0019))\u0005I\u0001\u0004\u0003\u0005I\u0011\u0002B<\u0007\u000fCab!#\u0012!\u0003\r\t\u0011!C\u0005\u0005o\u001aY\t\u0003\b\u0004\u000eF\u0001\n1!A\u0001\n\u0013\u0011\tba$\t\u001d\rE\u0015\u0003%A\u0002\u0002\u0003%IAa\u001e\u0004\u0014\"q1\u0011T\t\u0011\u0002\u0007\u0005\t\u0011\"\u0003\u0004\u001c\u000e}\u0005BDBQ#A\u0005\u0019\u0011!A\u0005\n\t]41\u0015\u0005\u000f\u0007K\u000b\u0002\u0013aA\u0001\u0002\u0013%!QSBT\u00119\u0019I+\u0005I\u0001\u0004\u0003\u0005I\u0011\u0002BK\u0007W3\u0011ba\u0016\u0001!\u0003\r\na!\u0017\u0007\u0013\r5\u0006\u0001%A\u0012\u0002\r=f!CBY\u0001A\u0005\u0019\u0013ABZ\r%\u0019)\f\u0001I\u0001\u0004\u0003\u00199\fC\u0003^\u0007\u0012\u0005q\f\u0003\u0006\u0004@\u000eC)\u0019!C\u0005\u0007\u0003Dqaa4D\t\u0003\u00129\b\u0003\b\u0004R\u000e\u0003\n1!A\u0001\n\u0013\u00119ha5\u0007\u0013\rU\u0007\u0001%A\u0012\u0002\r]g!CBn\u0001A\u0005\u0019\u0013ABo\u00119\u0019\t\u000f\u0001I\u0001\u0004\u0003\u0005I\u0011BBr\u0007S\u00141cU=oG\"\u0014xN\\5{K\u0012\u001c\u00160\u001c2pYNT!!\u0014(\u0002\u000fI,h\u000e^5nK*\u0011q\nU\u0001\be\u00164G.Z2u\u0015\u0005\t\u0016!B:dC2\f7c\u0001\u0001T/B\u0011A+V\u0007\u0002!&\u0011a\u000b\u0015\u0002\u0007\u0003:L(+\u001a4\u0011\u0005a[V\"A-\u000b\u0005is\u0015\u0001C5oi\u0016\u0014h.\u00197\n\u0005qK&aB*z[\n|Gn]\u0001\u0007I%t\u0017\u000e\u001e\u0013\u0004\u0001Q\t\u0001\r\u0005\u0002UC&\u0011!\r\u0015\u0002\u0005+:LG/A\u0005bi>l\u0017nY%egV\tQ\r\u0005\u0002g_6\tqM\u0003\u0002iS\u00061\u0011\r^8nS\u000eT!A[6\u0002\u0015\r|gnY;se\u0016tGO\u0003\u0002m[\u0006!Q\u000f^5m\u0015\u0005q\u0017\u0001\u00026bm\u0006L!\u0001]4\u0003\u001b\u0005#x.\\5d\u0013:$XmZ3s\u0003\u0019qW\r\u001f;JIR\t1\u000f\u0005\u0002Ui&\u0011Q\u000f\u0015\u0002\u0004\u0013:$\u0018\u0001F1u_6L7-\u0012=jgR,g\u000e^5bY&#7\u000f\u000b\u0003\u0005qnl\bC\u0001+z\u0013\tQ\bK\u0001\u0006eKB\u0014XmY1uK\u0012\f\u0013\u0001`\u0001&\u000f2|'-\u00197!KbL7\u000f^3oi&\fG\u000eI%Eg\u0002rw\u000e\t7p]\u001e,'\u000fI;tK\u0012\f\u0013A`\u0001\u0007e9\n$GL\u0019\u0002#9,\u0007\u0010^#ySN$XM\u001c;jC2LE\r\u000b\u0003\u0006qnl\u0018aD0sK\u000e,(o]5p]R\u000b'\r\\3\u0016\u0005\u0005\u001d\u0001CBA\u0005\u0003\u0017\t\t\"D\u0001\u0001\u0013\u0011\ti!a\u0004\u0003%QC'/Z1e\u0019>\u001c\u0017\r\\*u_J\fw-Z\u0005\u0004\u0003\u001ba\u0005cBA\n\u0003;\t\tc]\u0007\u0003\u0003+QA!a\u0006\u0002\u001a\u0005I\u0011.\\7vi\u0006\u0014G.\u001a\u0006\u0004\u00037\u0001\u0016AC2pY2,7\r^5p]&!\u0011qDA\u000b\u0005\ri\u0015\r\u001d\t\u0005\u0003\u0013\t\u0019#C\u0002\u0002&m\u0013aaU=nE>d\u0017A\u0004:fGV\u00148/[8o)\u0006\u0014G.Z\u000b\u0003\u0003#\t!C]3dkJ\u001c\u0018n\u001c8UC\ndWm\u0018\u0013fcR\u0019\u0001-a\f\t\u000f\u0005E\u0002\u00021\u0001\u0002\u0012\u0005)a/\u00197vK\u0006!2m\u001c8oK\u000e$Xj\u001c3vY\u0016$vn\u00117bgN$b!a\u000e\u0002>\u0005\u0005\u0003\u0003BA\u0005\u0003sI1!a\u000f\\\u00051iu\u000eZ;mKNKXNY8m\u0011\u001d\ty$\u0003a\u0001\u0003o\t\u0011!\u001c\u0005\b\u0003\u0007J\u0001\u0019AA#\u0003-iw\u000eZ;mK\u000ec\u0017m]:\u0011\t\u0005%\u0011qI\u0005\u0004\u0003\u0013Z&aC\"mCN\u001c8+_7c_2\f\u0011C\\3x\rJ,W\rV3s[NKXNY8m))\ty%!\u0016\u0002d\u0005E\u00141\u0010\t\u0005\u0003\u0013\t\t&C\u0002\u0002Tm\u0013aB\u0012:fKR+'/\\*z[\n|G\u000eC\u0004\u0002X)\u0001\r!!\u0017\u0002\t9\fW.\u001a\t\u0005\u0003\u0013\tY&\u0003\u0003\u0002^\u0005}#\u0001\u0003+fe6t\u0015-\\3\n\u0007\u0005\u0005\u0014LA\u0003OC6,7\u000f\u0003\u0005\u00022)!\t\u0019AA3!\u0015!\u0016qMA6\u0013\r\tI\u0007\u0015\u0002\ty\tLh.Y7f}A\u0019A+!\u001c\n\u0007\u0005=\u0004KA\u0002B]fD\u0011\"a\u001d\u000b!\u0003\u0005\r!!\u001e\u0002\u000b\u0019d\u0017mZ:\u0011\u0007Q\u000b9(C\u0002\u0002zA\u0013A\u0001T8oO\"I\u0011Q\u0010\u0006\u0011\u0002\u0003\u0007\u0011qP\u0001\u0007_JLw-\u001b8\u0011\t\u0005\u0005\u0015q\u0012\b\u0005\u0003\u0007\u000bY\tE\u0002\u0002\u0006Bk!!a\"\u000b\u0007\u0005%e,\u0001\u0004=e>|GOP\u0005\u0004\u0003\u001b\u0003\u0016A\u0002)sK\u0012,g-\u0003\u0003\u0002\u0012\u0006M%AB*ue&twMC\u0002\u0002\u000eB\u000b1D\\3x\rJ,W\rV3s[NKXNY8mI\u0011,g-Y;mi\u0012\u001aTCAAMU\u0011\t)(a',\u0005\u0005u\u0005\u0003BAP\u0003Sk!!!)\u000b\t\u0005\r\u0016QU\u0001\nk:\u001c\u0007.Z2lK\u0012T1!a*Q\u0003)\tgN\\8uCRLwN\\\u0005\u0005\u0003W\u000b\tKA\tv]\u000eDWmY6fIZ\u000b'/[1oG\u0016\f1D\\3x\rJ,W\rV3s[NKXNY8mI\u0011,g-Y;mi\u0012\"TCAAYU\u0011\ty(a'\u0002#9,wO\u0012:fKRK\b/Z*z[\n|G\u000e\u0006\u0005\u00028\u0006u\u0016QYAd!\u0011\tI!!/\n\u0007\u0005m6L\u0001\bGe\u0016,G+\u001f9f'fl'm\u001c7\t\u000f\u0005]S\u00021\u0001\u0002@B!\u0011\u0011BAa\u0013\u0011\t\u0019-a\u0018\u0003\u0011QK\b/\u001a(b[\u0016D\u0011\"a\u001d\u000e!\u0003\u0005\r!!\u001e\t\u0013\u0005uT\u0002%AA\u0002\u0005}\u0014a\u00078fo\u001a\u0013X-\u001a+za\u0016\u001c\u00160\u001c2pY\u0012\"WMZ1vYR$#'A\u000eoK^4%/Z3UsB,7+_7c_2$C-\u001a4bk2$HeM\u0001\r[\u0006\\WMT8Ts6\u0014w\u000e\\\u000b\u0003\u0003#\u0004B!!\u0003\u0002T&\u0019\u0011Q[.\u0003\u00119{7+_7c_2\u0014!cU=oG\"\u0014xN\\5{K\u0012\u001c\u00160\u001c2pYN\u0019\u0011#!\t\u0002\u0019%\u001cH\u000b\u001b:fC\u0012\u001c\u0018MZ3\u0015\t\u0005}\u0017Q\u001d\t\u0004)\u0006\u0005\u0018bAAr!\n9!i\\8mK\u0006t\u0007bBAt'\u0001\u0007\u0011\u0011^\u0001\baV\u0014\bo\\:f!\u0011\tI!a;\n\u0007\u000558LA\u0005Ts6\u0014w\u000e\\(qg\u0006i\u0001O]5wCR,w+\u001b;iS:,\"!!\t\u0002\u0017\u0005tgn\u001c;bi&|gn]\u000b\u0003\u0003o\u0004b!!?\u0002\u0000\n\u0015ab\u0001+\u0002|&\u0019\u0011Q )\u0002\u000fA\f7m[1hK&!!\u0011\u0001B\u0002\u0005\u0011a\u0015n\u001d;\u000b\u0007\u0005u\b\u000b\u0005\u0003\u0002\n\t\u001d\u0011\u0002\u0002B\u0005\u0005\u0017\u0011a\"\u00118o_R\fG/[8o\u0013:4w.C\u0002\u0003\u000ee\u0013q\"\u00118o_R\fG/[8o\u0013:4wn]\u0001\r?&t\u0017\u000e^5bY&TX\rZ\u000b\u0003\u0003?D3A\u0006B\u000b!\r!&qC\u0005\u0004\u00053\u0001&\u0001\u0003<pY\u0006$\u0018\u000e\\3\u0002!}Kg.\u001b;jC2L'0\u001a3`I\u0015\fHc\u00011\u0003 !I!\u0011E\f\u0002\u0002\u0003\u0007\u0011q\\\u0001\u0004q\u0012\n\u0014aE0j]&$\u0018.\u00197ju\u0006$\u0018n\u001c8NCN\\WCAA;Q\rA\"QC\u0001\u0018?&t\u0017\u000e^5bY&T\u0018\r^5p]6\u000b7o[0%KF$2\u0001\u0019B\u0017\u0011%\u0011\t#GA\u0001\u0002\u0004\t)(\u0001\nnCJ\\g\t\\1hg\u000e{W\u000e\u001d7fi\u0016$G\u0003\u0002B\u001a\u0005ki\u0011!\u0005\u0005\b\u0005oQ\u0002\u0019AA;\u0003\u0011i\u0017m]6\u0002!5\f'o[!mY\u000e{W\u000e\u001d7fi\u0016$GC\u0001B\u001a\u0003y9\u0017\u000e\\*z]\u000eD'o\u001c8ju\u0016$\u0017J\u001a(piRC'/Z1eg\u00064W-\u0006\u0003\u0003B\t\u001dC\u0003\u0002B\"\u0005'\u0002BA!\u0012\u0003H1\u0001Aa\u0002B%9\t\u0007!1\n\u0002\u0002)F!!QJA6!\r!&qJ\u0005\u0004\u0005#\u0002&a\u0002(pi\"Lgn\u001a\u0005\t\u0005+bB\u00111\u0001\u0003X\u0005!!m\u001c3z!\u0015!\u0016q\rB\"Q\ra\"1\f\t\u0004)\nu\u0013b\u0001B0!\n1\u0011N\u001c7j]\u0016\fqaZ3u\r2\fw\r\u0006\u0003\u0002v\t\u0015\u0004b\u0002B\u001c;\u0001\u0007\u0011QO\u0001\bm\u0006d\u0017\u000e\u001a+p+\t\u0011Y\u0007\u0005\u0003\u0002\n\t5\u0014\u0002\u0002B8\u0005c\u0012a\u0001U3sS>$\u0017b\u0001B:3\nY1+_7c_2$\u0016M\u00197f\u0003\u0011IgNZ8\u0016\u0005\te\u0004\u0003BA\u0005\u0005wJAA! \u0003\u0000\t!A+\u001f9f\u0013\r\u0011\t)\u0017\u0002\u0006)f\u0004Xm]\u0001\be\u0006<\u0018J\u001c4p\u0003\u0019)\u00070[:ug\u0006iA/\u001f9f'&<g.\u0019;ve\u0016\fq\u0002^=qKNKwM\\1ukJ,\u0017J\u001c\u000b\u0005\u0005s\u0012i\tC\u0004\u0003\u0010\u000e\u0002\rA!\u001f\u0002\tMLG/Z\u0001\u0010if\u0004XmQ8ogR\u0014Xo\u0019;pe\u0006QA/\u001f9f!\u0006\u0014\u0018-\\:\u0016\u0005\t]\u0005CBA}\u0003\u007f\f\t#\u0001\tv]N\fg-\u001a+za\u0016\u0004\u0016M]1ng\u0006A2M]3bi\u0016\f%m\u001d;sC\u000e$H+\u001f9f'fl'm\u001c7\u0015\u0011\t}%Q\u0015BT\u0005k\u0003B!!\u0003\u0003\"&\u0019!1U.\u0003%\u0005\u00137\u000f\u001e:bGR$\u0016\u0010]3Ts6\u0014w\u000e\u001c\u0005\b\u0003/:\u0003\u0019AA`\u0011\u001d\u0011Ik\na\u0001\u0005W\u000b1\u0001]8t!\u0011\tIA!,\n\t\t=&\u0011\u0017\u0002\t!>\u001c\u0018\u000e^5p]&\u0019!1W-\u0003\u0013A{7/\u001b;j_:\u001c\bb\u0002B\\O\u0001\u0007\u0011QO\u0001\t]\u0016<h\t\\1hg\u0006)2M]3bi\u0016\fE.[1t)f\u0004XmU=nE>dG\u0003\u0003B_\u0005\u0007\u0014)Ma2\u0011\t\u0005%!qX\u0005\u0004\u0005\u0003\\&aD!mS\u0006\u001cH+\u001f9f'fl'm\u001c7\t\u000f\u0005]\u0003\u00061\u0001\u0002@\"9!\u0011\u0016\u0015A\u0002\t-\u0006b\u0002B\\Q\u0001\u0007\u0011QO\u0001\u0017GJ,\u0017\r^3UsB,7k[8mK6\u001c\u00160\u001c2pYRQ!Q\u001aBj\u0005+\u00149N!7\u0011\t\u0005%!qZ\u0005\u0004\u0005#\\&A\u0003+za\u0016\u001c6n\u001c7f[\"9\u0011qK\u0015A\u0002\u0005}\u0006BBA?S\u0001\u00071\u000bC\u0004\u0003*&\u0002\rAa+\t\u000f\t]\u0016\u00061\u0001\u0002v\u0005\t2M]3bi\u0016\u001cE.Y:t'fl'm\u001c7\u0015\u0011\u0005\u0015#q\u001cBq\u0005GDq!a\u0016+\u0001\u0004\ty\fC\u0004\u0003**\u0002\rAa+\t\u000f\t]&\u00061\u0001\u0002v\u000592M]3bi\u0016lu\u000eZ;mK\u000ec\u0017m]:Ts6\u0014w\u000e\u001c\u000b\t\u0005S\u0014yO!=\u0003tB!\u0011\u0011\u0002Bv\u0013\r\u0011io\u0017\u0002\u0012\u001b>$W\u000f\\3DY\u0006\u001c8oU=nE>d\u0007bBA,W\u0001\u0007\u0011q\u0018\u0005\b\u0005S[\u0003\u0019\u0001BV\u0011\u001d\u00119l\u000ba\u0001\u0003k\n\u0001d\u0019:fCR,\u0007+Y2lC\u001e,7\t\\1tgNKXNY8m)!\u0011IPa@\u0004\u0002\r\r\u0001\u0003BA\u0005\u0005wL1A!@\\\u0005I\u0001\u0016mY6bO\u0016\u001cE.Y:t'fl'm\u001c7\t\u000f\u0005]C\u00061\u0001\u0002@\"9!\u0011\u0016\u0017A\u0002\t-\u0006b\u0002B\\Y\u0001\u0007\u0011QO\u0001\u001cGJ,\u0017\r^3SK\u001aLg.Z7f]R\u001cE.Y:t'fl'm\u001c7\u0015\r\r%1qBB\t!\u0011\tIaa\u0003\n\u0007\r51LA\u000bSK\u001aLg.Z7f]R\u001cE.Y:t'fl'm\u001c7\t\u000f\t%V\u00061\u0001\u0003,\"9!qW\u0017A\u0002\u0005U\u0014AH2sK\u0006$X\rU1dW\u0006<Wm\u00142kK\u000e$8\t\\1tgNKXNY8m)\u0019\u00199b!\b\u0004 A!\u0011\u0011BB\r\u0013\r\u0019Yb\u0017\u0002\u0019!\u0006\u001c7.Y4f\u001f\nTWm\u0019;DY\u0006\u001c8oU=nE>d\u0007b\u0002BU]\u0001\u0007!1\u0016\u0005\b\u0005os\u0003\u0019AA;\u0003I\u0019'/Z1uK6+G\u000f[8e'fl'm\u001c7\u0015\u0011\r\u001521FB\u0017\u0007_\u0001B!!\u0003\u0004(%\u00191\u0011F.\u0003\u00195+G\u000f[8e'fl'm\u001c7\t\u000f\u0005]s\u00061\u0001\u0002Z!9!\u0011V\u0018A\u0002\t-\u0006b\u0002B\\_\u0001\u0007\u0011QO\u0001\u0013GJ,\u0017\r^3N_\u0012,H.Z*z[\n|G\u000e\u0006\u0005\u00028\rU2qGB\u001d\u0011\u001d\t9\u0006\ra\u0001\u00033BqA!+1\u0001\u0004\u0011Y\u000bC\u0004\u00038B\u0002\r!!\u001e\u0002'\r\u0014X-\u0019;f!\u0006\u001c7.Y4f'fl'm\u001c7\u0015\u0011\u0005]2qHB!\u0007\u0007Bq!a\u00162\u0001\u0004\tI\u0006C\u0004\u0003*F\u0002\rAa+\t\u000f\t]\u0016\u00071\u0001\u0002v\u0005Q2M]3bi\u00164\u0016\r\\;f!\u0006\u0014\u0018-\\3uKJ\u001c\u00160\u001c2pYRA1\u0011JB/\u0007?\u001a\tG\u0005\u0004\u0004L\r=3Q\u000b\u0004\u0007\u0007\u001b\u0012\u0004a!\u0013\u0003\u0019q\u0012XMZ5oK6,g\u000e\u001e \u0011\t\u0005%1\u0011K\u0005\u0004\u0007'Z&A\u0003+fe6\u001c\u00160\u001c2pYB\u0019\u0011\u0011\u0002!\u0003-MKhn\u00195s_:L'0\u001a3UKJl7+_7c_2\u001cR\u0001QA\u0011\u00077\u00022!!\u0003\u0012\u0011\u001d\t9F\ra\u0001\u00033BqA!+3\u0001\u0004\u0011Y\u000bC\u0004\u00038J\u0002\r!!\u001e\u0002/\r\u0014X-\u0019;f-\u0006dW/Z'f[\n,'oU=nE>dG\u0003CB4\u0007W\u001aiga\u001c\u0013\r\r%4qJB+\r\u0019\u0019ie\r\u0001\u0004h!9\u0011qK\u001aA\u0002\u0005e\u0003b\u0002BUg\u0001\u0007!1\u0016\u0005\b\u0005o\u001b\u0004\u0019AA;\u0003M\u0019X\u000f]3sIA\u0014\u0018N^1uK^KG\u000f[5o\u0013\u0011\ty/a\t\u0002#M,\b/\u001a:%C:tw\u000e^1uS>t7/\u0003\u0003\u0002t\u0006\r\u0012!D:va\u0016\u0014HeZ3u\r2\fw\r\u0006\u0003\u0002v\ru\u0004b\u0002B\u001cm\u0001\u0007\u0011QO\u0005\u0005\u0005C\n\u0019#A\u0007tkB,'\u000f\n<bY&$Gk\\\u0005\u0005\u0005O\n\u0019#\u0001\u0006tkB,'\u000fJ5oM>LAA!\u001e\u0002$\u0005i1/\u001e9fe\u0012\u0012\u0018m^%oM>LAAa!\u0002$\u0005a1/\u001e9fe\u0012*\u00070[:ug&!!QQA\u0012\u0003M\u0019X\u000f]3sIQL\b/Z*jO:\fG/\u001e:f\u0013\u0011\u00119i!&\n\u0007\r]5L\u0001\u000bTs6\u0014w\u000e\\\"p]R,\u0007\u0010^!qS&k\u0007\u000f\\\u0001\u0016gV\u0004XM\u001d\u0013usB,7+[4oCR,(/Z%o)\u0011\u0011Ih!(\t\u000f\t=E\b1\u0001\u0003z%!!\u0011RBK\u0003U\u0019X\u000f]3sIQL\b/Z\"p]N$(/^2u_JLAA!%\u0002$\u0005\u00012/\u001e9fe\u0012\"\u0018\u0010]3QCJ\fWn]\u0005\u0005\u0005'\u000b\u0019#\u0001\ftkB,'\u000fJ;og\u00064W\rV=qKB\u000b'/Y7t\u0013\u0011\u0011I*a\t\u00031MKhn\u00195s_:L'0\u001a3NKRDw\u000eZ*z[\n|GnE\u0003B\u0007K\u0019)F\u0001\rTs:\u001c\u0007N]8oSj,G-T8ek2,7+_7c_2\u001cRAQA\u001c\u0007+\u0012acU=oG\"\u0014xN\\5{K\u0012$\u0016\u0010]3Ts6\u0014w\u000e\\\n\u0006\u0007\u000ee61\f\t\u0005\u0003\u0013\u0019Y,C\u0002\u0004>n\u0013!\u0002V=qKNKXNY8m\u0003\u001d!\b/\u001a'pG.,\"aa1\u0011\t\r\u001571Z\u0007\u0003\u0007\u000fT1a!3n\u0003\u0011a\u0017M\\4\n\t\r57q\u0019\u0002\u0007\u001f\nTWm\u0019;\u0002\u0015Q\u0004Xm\u0018\u0013uS6,7/\u0001\ttkB,'\u000f\n;qK~#C/[7fg&!1qZB^\u0005]\u0019\u0016P\\2ie>t\u0017N_3e\u00072\f7o]*z[\n|GnE\u0003I\u0003\u000b\u001aI\u000eE\u0002\u0002\n\r\u0013QdU=oG\"\u0014xN\\5{K\u0012lu\u000eZ;mK\u000ec\u0017m]:Ts6\u0014w\u000e\\\n\u0006\u0013\n%8q\u001c\t\u0004\u0003\u0013A\u0015AG:va\u0016\u0014HeY8o]\u0016\u001cG/T8ek2,Gk\\\"mCN\u001cHCBA\u001c\u0007K\u001c9\u000fC\u0004\u0002@)\u0003\r!a\u000e\t\u000f\u0005\r#\n1\u0001\u0002F%\u0019\u00111G.\u0011\t\r58q^\u0007\u0002\u0019&\u0019!1\u000f'")
public interface SynchronizedSymbols
extends Symbols {
    public /* synthetic */ Symbols.ModuleSymbol scala$reflect$runtime$SynchronizedSymbols$$super$connectModuleToClass(Symbols.ModuleSymbol var1, Symbols.ClassSymbol var2);

    public static /* synthetic */ AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicIds$(SynchronizedSymbols $this) {
        return $this.scala$reflect$runtime$SynchronizedSymbols$$atomicIds();
    }

    default public AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicIds() {
        return new AtomicInteger(0);
    }

    public static /* synthetic */ int nextId$(SynchronizedSymbols $this) {
        return $this.nextId();
    }

    @Override
    default public int nextId() {
        return this.scala$reflect$runtime$SynchronizedSymbols$$atomicIds().incrementAndGet();
    }

    public static /* synthetic */ AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds$(SynchronizedSymbols $this) {
        return $this.scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds();
    }

    default public AtomicInteger scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds() {
        return new AtomicInteger(0);
    }

    public static /* synthetic */ int nextExistentialId$(SynchronizedSymbols $this) {
        return $this.nextExistentialId();
    }

    @Override
    default public int nextExistentialId() {
        return this.scala$reflect$runtime$SynchronizedSymbols$$atomicExistentialIds().incrementAndGet();
    }

    public static /* synthetic */ ThreadLocalStorage.ThreadLocalStorage scala$reflect$runtime$SynchronizedSymbols$$_recursionTable$(SynchronizedSymbols $this) {
        return $this.scala$reflect$runtime$SynchronizedSymbols$$_recursionTable();
    }

    default public ThreadLocalStorage.ThreadLocalStorage<Map<Symbols.Symbol, Object>> scala$reflect$runtime$SynchronizedSymbols$$_recursionTable() {
        Function0<Map> & java.io.Serializable & Serializable mkThreadLocalStorage_x = (Function0<Map> & java.io.Serializable & Serializable)() -> Map$.MODULE$.empty();
        ThreadLocalStorage mkThreadLocalStorage_this = (ThreadLocalStorage)((Object)this);
        return new ThreadLocalStorage.MyThreadLocalStorage<Map<Symbols.Symbol, Object>>((SymbolTable)mkThreadLocalStorage_this, mkThreadLocalStorage_x);
    }

    public static /* synthetic */ Map recursionTable$(SynchronizedSymbols $this) {
        return $this.recursionTable();
    }

    @Override
    default public Map<Symbols.Symbol, Object> recursionTable() {
        return this.scala$reflect$runtime$SynchronizedSymbols$$_recursionTable().get();
    }

    public static /* synthetic */ void recursionTable_$eq$(SynchronizedSymbols $this, Map value) {
        $this.recursionTable_$eq(value);
    }

    @Override
    default public void recursionTable_$eq(Map<Symbols.Symbol, Object> value) {
        this.scala$reflect$runtime$SynchronizedSymbols$$_recursionTable().set(value);
    }

    public static /* synthetic */ Symbols.ModuleSymbol connectModuleToClass$(SynchronizedSymbols $this, Symbols.ModuleSymbol m, Symbols.ClassSymbol moduleClass) {
        return $this.connectModuleToClass(m, moduleClass);
    }

    @Override
    default public Symbols.ModuleSymbol connectModuleToClass(Symbols.ModuleSymbol m, Symbols.ClassSymbol moduleClass) {
        Symbols.ModuleSymbol moduleSymbol;
        Gil gilSynchronized_this = (Gil)((Object)this);
        if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
            return this.scala$reflect$runtime$SynchronizedSymbols$$super$connectModuleToClass(m, moduleClass);
        }
        try {
            gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
            moduleSymbol = this.scala$reflect$runtime$SynchronizedSymbols$$super$connectModuleToClass(m, moduleClass);
        }
        finally {
            gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
        }
        return moduleSymbol;
    }

    public static /* synthetic */ Symbols.FreeTermSymbol newFreeTermSymbol$(SynchronizedSymbols $this, Names.TermName name, Function0 value, long flags, String origin) {
        return $this.newFreeTermSymbol(name, value, flags, origin);
    }

    @Override
    default public Symbols.FreeTermSymbol newFreeTermSymbol(Names.TermName name, Function0<Object> value, long flags, String origin) {
        return (Symbols.FreeTermSymbol)((Symbols.Symbol)((Object)new SynchronizedTermSymbol((SymbolTable)this, name, value, origin){
            private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
            private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
            private final /* synthetic */ SymbolTable $outer;

            public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                return super.privateWithin();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                return super.annotations();
            }

            public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                return super.getFlag(mask);
            }

            public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                return super.validTo();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                return super.info();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                return super.rawInfo();
            }

            public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                return super.exists();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                return super.typeSignature();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                return super.typeSignatureIn(site);
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                return super.typeConstructor();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                return super.typeParams();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                return super.unsafeTypeParams();
            }

            public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                return SynchronizedSymbol.isThreadsafe$(this, purpose);
            }

            public final Symbols.Symbol privateWithin() {
                return SynchronizedSymbol.privateWithin$(this);
            }

            public List<AnnotationInfos.AnnotationInfo> annotations() {
                return SynchronizedSymbol.annotations$(this);
            }

            public SynchronizedSymbol markFlagsCompleted(long mask) {
                return SynchronizedSymbol.markFlagsCompleted$(this, mask);
            }

            public SynchronizedSymbol markAllCompleted() {
                return SynchronizedSymbol.markAllCompleted$(this);
            }

            public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
            }

            public final long getFlag(long mask) {
                return SynchronizedSymbol.getFlag$(this, mask);
            }

            public int validTo() {
                return SynchronizedSymbol.validTo$(this);
            }

            public Types.Type info() {
                return SynchronizedSymbol.info$(this);
            }

            public Types.Type rawInfo() {
                return SynchronizedSymbol.rawInfo$(this);
            }

            public boolean exists() {
                return SynchronizedSymbol.exists$(this);
            }

            public Types.Type typeSignature() {
                return SynchronizedSymbol.typeSignature$(this);
            }

            public Types.Type typeSignatureIn(Types.Type site) {
                return SynchronizedSymbol.typeSignatureIn$(this, site);
            }

            public Types.Type typeConstructor() {
                return SynchronizedSymbol.typeConstructor$(this);
            }

            public List<Symbols.Symbol> typeParams() {
                return SynchronizedSymbol.typeParams$(this);
            }

            public List<Symbols.Symbol> unsafeTypeParams() {
                return SynchronizedSymbol.unsafeTypeParams$(this);
            }

            public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
            }

            public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
            }

            public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
            }

            public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
            }

            public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
            }

            public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
            }

            public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
            }

            public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
            }

            public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
            }

            public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super((scala.reflect.internal.SymbolTable)((Object)$outer), name$1, value$1, origin$1);
                SynchronizedSymbol.$init$(this);
            }
        })).initFlags(flags);
    }

    public static /* synthetic */ long newFreeTermSymbol$default$3$(SynchronizedSymbols $this) {
        return $this.newFreeTermSymbol$default$3();
    }

    @Override
    default public long newFreeTermSymbol$default$3() {
        return 0L;
    }

    public static /* synthetic */ String newFreeTermSymbol$default$4$(SynchronizedSymbols $this) {
        return $this.newFreeTermSymbol$default$4();
    }

    default public String newFreeTermSymbol$default$4() {
        return null;
    }

    public static /* synthetic */ Symbols.FreeTypeSymbol newFreeTypeSymbol$(SynchronizedSymbols $this, Names.TypeName name, long flags, String origin) {
        return $this.newFreeTypeSymbol(name, flags, origin);
    }

    @Override
    default public Symbols.FreeTypeSymbol newFreeTypeSymbol(Names.TypeName name, long flags, String origin) {
        return (Symbols.FreeTypeSymbol)((Symbols.Symbol)((Object)new SynchronizedTypeSymbol((SymbolTable)this, name, origin){
            private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
            private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
            private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
            private volatile boolean bitmap$0;
            private final /* synthetic */ SymbolTable $outer;

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                return super.tpe_$times();
            }

            public Types.Type tpe_$times() {
                return SynchronizedTypeSymbol.tpe_$times$(this);
            }

            public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                return super.privateWithin();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                return super.annotations();
            }

            public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                return super.getFlag(mask);
            }

            public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                return super.validTo();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                return super.info();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                return super.rawInfo();
            }

            public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                return super.exists();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                return super.typeSignature();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                return super.typeSignatureIn(site);
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                return super.typeConstructor();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                return super.typeParams();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                return super.unsafeTypeParams();
            }

            public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                return SynchronizedSymbol.isThreadsafe$(this, purpose);
            }

            public final Symbols.Symbol privateWithin() {
                return SynchronizedSymbol.privateWithin$(this);
            }

            public List<AnnotationInfos.AnnotationInfo> annotations() {
                return SynchronizedSymbol.annotations$(this);
            }

            public SynchronizedSymbol markFlagsCompleted(long mask) {
                return SynchronizedSymbol.markFlagsCompleted$(this, mask);
            }

            public SynchronizedSymbol markAllCompleted() {
                return SynchronizedSymbol.markAllCompleted$(this);
            }

            public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
            }

            public final long getFlag(long mask) {
                return SynchronizedSymbol.getFlag$(this, mask);
            }

            public int validTo() {
                return SynchronizedSymbol.validTo$(this);
            }

            public Types.Type info() {
                return SynchronizedSymbol.info$(this);
            }

            public Types.Type rawInfo() {
                return SynchronizedSymbol.rawInfo$(this);
            }

            public boolean exists() {
                return SynchronizedSymbol.exists$(this);
            }

            public Types.Type typeSignature() {
                return SynchronizedSymbol.typeSignature$(this);
            }

            public Types.Type typeSignatureIn(Types.Type site) {
                return SynchronizedSymbol.typeSignatureIn$(this, site);
            }

            public Types.Type typeConstructor() {
                return SynchronizedSymbol.typeConstructor$(this);
            }

            public List<Symbols.Symbol> typeParams() {
                return SynchronizedSymbol.typeParams$(this);
            }

            public List<Symbols.Symbol> unsafeTypeParams() {
                return SynchronizedSymbol.unsafeTypeParams$(this);
            }

            public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
            }

            public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
            }

            public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
            }

            public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
            }

            public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
            }

            private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                synchronized (this) {
                    if (!this.bitmap$0) {
                        this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                        this.bitmap$0 = true;
                    }
                }
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
            }

            public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                if (!this.bitmap$0) {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                }
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
            }

            public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
            }

            public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
            }

            public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
            }

            public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
            }

            public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                return this.$outer;
            }

            public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super((scala.reflect.internal.SymbolTable)((Object)$outer), name$2, origin$2);
                SynchronizedSymbol.$init$(this);
                SynchronizedTypeSymbol.$init$(this);
            }
        })).initFlags(flags);
    }

    public static /* synthetic */ long newFreeTypeSymbol$default$2$(SynchronizedSymbols $this) {
        return $this.newFreeTypeSymbol$default$2();
    }

    @Override
    default public long newFreeTypeSymbol$default$2() {
        return 0L;
    }

    public static /* synthetic */ String newFreeTypeSymbol$default$3$(SynchronizedSymbols $this) {
        return $this.newFreeTypeSymbol$default$3();
    }

    default public String newFreeTypeSymbol$default$3() {
        return null;
    }

    public static /* synthetic */ Symbols.NoSymbol makeNoSymbol$(SynchronizedSymbols $this) {
        return $this.makeNoSymbol();
    }

    @Override
    default public Symbols.NoSymbol makeNoSymbol() {
        return new SynchronizedSymbol((SymbolTable)this){
            private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
            private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
            private final /* synthetic */ SymbolTable $outer;

            public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                return super.privateWithin();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                return super.annotations();
            }

            public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                return super.getFlag(mask);
            }

            public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                return super.validTo();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                return super.info();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                return super.rawInfo();
            }

            public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                return super.exists();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                return super.typeSignature();
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                return super.typeSignatureIn(site);
            }

            public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                return super.typeConstructor();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                return super.typeParams();
            }

            public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                return super.unsafeTypeParams();
            }

            public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                return SynchronizedSymbol.isThreadsafe$(this, purpose);
            }

            public final Symbols.Symbol privateWithin() {
                return SynchronizedSymbol.privateWithin$(this);
            }

            public List<AnnotationInfos.AnnotationInfo> annotations() {
                return SynchronizedSymbol.annotations$(this);
            }

            public SynchronizedSymbol markFlagsCompleted(long mask) {
                return SynchronizedSymbol.markFlagsCompleted$(this, mask);
            }

            public SynchronizedSymbol markAllCompleted() {
                return SynchronizedSymbol.markAllCompleted$(this);
            }

            public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
            }

            public final long getFlag(long mask) {
                return SynchronizedSymbol.getFlag$(this, mask);
            }

            public int validTo() {
                return SynchronizedSymbol.validTo$(this);
            }

            public Types.Type info() {
                return SynchronizedSymbol.info$(this);
            }

            public Types.Type rawInfo() {
                return SynchronizedSymbol.rawInfo$(this);
            }

            public boolean exists() {
                return SynchronizedSymbol.exists$(this);
            }

            public Types.Type typeSignature() {
                return SynchronizedSymbol.typeSignature$(this);
            }

            public Types.Type typeSignatureIn(Types.Type site) {
                return SynchronizedSymbol.typeSignatureIn$(this, site);
            }

            public Types.Type typeConstructor() {
                return SynchronizedSymbol.typeConstructor$(this);
            }

            public List<Symbols.Symbol> typeParams() {
                return SynchronizedSymbol.typeParams$(this);
            }

            public List<Symbols.Symbol> unsafeTypeParams() {
                return SynchronizedSymbol.unsafeTypeParams$(this);
            }

            public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
            }

            public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
            }

            public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
            }

            public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
            }

            public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
            }

            public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
            }

            public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
            }

            public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
            }

            public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
            }

            public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
            }

            public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
            }

            public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
            }

            public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                return this.$outer;
            }
            {
                if ($outer == null) {
                    throw null;
                }
                this.$outer = $outer;
                super((scala.reflect.internal.SymbolTable)((Object)$outer));
                SynchronizedSymbol.$init$(this);
            }
        };
    }

    public static void $init$(SynchronizedSymbols $this) {
    }

    public interface SynchronizedClassSymbol
    extends SynchronizedTypeSymbol {
    }

    public interface SynchronizedMethodSymbol
    extends SynchronizedTermSymbol {
    }

    public interface SynchronizedModuleClassSymbol
    extends SynchronizedClassSymbol {
    }

    public interface SynchronizedModuleSymbol
    extends SynchronizedTermSymbol {
    }

    public interface SynchronizedSymbol {
        public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin();

        public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations();

        public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long var1);

        public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo();

        public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info();

        public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo();

        public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists();

        public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature();

        public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type var1);

        public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor();

        public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams();

        public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams();

        public static /* synthetic */ boolean isThreadsafe$(SynchronizedSymbol $this, Symbols.SymbolOps purpose) {
            return $this.isThreadsafe(purpose);
        }

        default public boolean isThreadsafe(Symbols.SymbolOps purpose) {
            if (((SymbolTable)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()).isCompilerUniverse()) {
                return false;
            }
            if (this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized()) {
                return true;
            }
            return purpose.isFlagRelated() && (this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() & purpose.mask() & Flags$.MODULE$.TopLevelPickledFlags()) == 0L;
        }

        public static /* synthetic */ Symbols.Symbol privateWithin$(SynchronizedSymbol $this) {
            return $this.privateWithin();
        }

        default public Symbols.Symbol privateWithin() {
            if (!((SymbolTable)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()).isCompilerUniverse() && !this.isThreadsafe(this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer().AllOps())) {
                ((Symbols.Symbol)((Object)this)).initialize();
            }
            return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin();
        }

        public static /* synthetic */ List annotations$(SynchronizedSymbol $this) {
            return $this.annotations();
        }

        default public List<AnnotationInfos.AnnotationInfo> annotations() {
            if (!((SymbolTable)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()).isCompilerUniverse() && !this.isThreadsafe(this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer().AllOps())) {
                ((Symbols.Symbol)((Object)this)).initialize();
            }
            return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations();
        }

        public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized();

        public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean var1);

        public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask();

        public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long var1);

        public static /* synthetic */ SynchronizedSymbol markFlagsCompleted$(SynchronizedSymbol $this, long mask) {
            return $this.markFlagsCompleted(mask);
        }

        default public SynchronizedSymbol markFlagsCompleted(long mask) {
            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() & (mask ^ 0xFFFFFFFFFFFFFFFFL));
            return this;
        }

        public static /* synthetic */ SynchronizedSymbol markAllCompleted$(SynchronizedSymbol $this) {
            return $this.markAllCompleted();
        }

        default public SynchronizedSymbol markAllCompleted() {
            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(0L);
            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(true);
            return this;
        }

        public static /* synthetic */ Object gilSynchronizedIfNotThreadsafe$(SynchronizedSymbol $this, Function0 body) {
            return $this.gilSynchronizedIfNotThreadsafe(body);
        }

        default public <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
            T t;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronized_this).isCompilerUniverse()) {
                return body.apply();
            }
            try {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                t = body.apply();
            }
            finally {
                gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return t;
        }

        public static /* synthetic */ long getFlag$(SynchronizedSymbol $this, long mask) {
            return $this.getFlag(mask);
        }

        default public long getFlag(long mask) {
            if (!((SymbolTable)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()).isCompilerUniverse() && !this.isThreadsafe(this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer().FlagOps(mask))) {
                ((Symbols.Symbol)((Object)this)).initialize();
            }
            return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(mask);
        }

        public static /* synthetic */ int validTo$(SynchronizedSymbol $this) {
            return $this.validTo();
        }

        default public int validTo() {
            int n;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo();
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                n = this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo();
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return n;
        }

        public static /* synthetic */ Types.Type info$(SynchronizedSymbol $this) {
            return $this.info();
        }

        default public Types.Type info() {
            Types.Type type;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info();
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                type = this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info();
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return type;
        }

        public static /* synthetic */ Types.Type rawInfo$(SynchronizedSymbol $this) {
            return $this.rawInfo();
        }

        default public Types.Type rawInfo() {
            Types.Type type;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo();
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                type = this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo();
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return type;
        }

        public static /* synthetic */ boolean exists$(SynchronizedSymbol $this) {
            return $this.exists();
        }

        default public boolean exists() {
            boolean bl;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists();
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                bl = this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists();
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return bl;
        }

        public static /* synthetic */ Types.Type typeSignature$(SynchronizedSymbol $this) {
            return $this.typeSignature();
        }

        default public Types.Type typeSignature() {
            Types.Type type;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature();
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                type = this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature();
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return type;
        }

        public static /* synthetic */ Types.Type typeSignatureIn$(SynchronizedSymbol $this, Types.Type site) {
            return $this.typeSignatureIn(site);
        }

        default public Types.Type typeSignatureIn(Types.Type site) {
            Types.Type type;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(site);
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                type = this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(site);
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return type;
        }

        public static /* synthetic */ Types.Type typeConstructor$(SynchronizedSymbol $this) {
            return $this.typeConstructor();
        }

        default public Types.Type typeConstructor() {
            Types.Type type;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor();
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                type = this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor();
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return type;
        }

        public static /* synthetic */ List typeParams$(SynchronizedSymbol $this) {
            return $this.typeParams();
        }

        default public List<Symbols.Symbol> typeParams() {
            List list;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return SynchronizedSymbol.$anonfun$typeParams$1(this);
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                list = SynchronizedSymbol.$anonfun$typeParams$1(this);
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return list;
        }

        public static /* synthetic */ List unsafeTypeParams$(SynchronizedSymbol $this) {
            return $this.unsafeTypeParams();
        }

        default public List<Symbols.Symbol> unsafeTypeParams() {
            List list;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return SynchronizedSymbol.$anonfun$unsafeTypeParams$1(this);
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                list = SynchronizedSymbol.$anonfun$unsafeTypeParams$1(this);
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return list;
        }

        public static /* synthetic */ Symbols.AbstractTypeSymbol createAbstractTypeSymbol$(SynchronizedSymbol $this, Names.TypeName name, Position pos, long newFlags) {
            return $this.createAbstractTypeSymbol(name, pos, newFlags);
        }

        default public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
            return (Symbols.AbstractTypeSymbol)((Symbols.Symbol)((Object)new SynchronizedTypeSymbol(this, pos, name){
                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                    return super.tpe_$times();
                }

                public Types.Type tpe_$times() {
                    return SynchronizedTypeSymbol.tpe_$times$(this);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                    if (!this.bitmap$0) {
                        return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$1, name$3);
                    SynchronizedSymbol.$init$(this);
                    SynchronizedTypeSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.AliasTypeSymbol createAliasTypeSymbol$(SynchronizedSymbol $this, Names.TypeName name, Position pos, long newFlags) {
            return $this.createAliasTypeSymbol(name, pos, newFlags);
        }

        default public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
            return (Symbols.AliasTypeSymbol)((Symbols.Symbol)((Object)new SynchronizedTypeSymbol(this, pos, name){
                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                    return super.tpe_$times();
                }

                public Types.Type tpe_$times() {
                    return SynchronizedTypeSymbol.tpe_$times$(this);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                    if (!this.bitmap$0) {
                        return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$2, name$4);
                    SynchronizedSymbol.$init$(this);
                    SynchronizedTypeSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.TypeSkolem createTypeSkolemSymbol$(SynchronizedSymbol $this, Names.TypeName name, Object origin, Position pos, long newFlags) {
            return $this.createTypeSkolemSymbol(name, origin, pos, newFlags);
        }

        default public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
            return (Symbols.TypeSkolem)((Symbols.Symbol)((Object)new SynchronizedTypeSymbol(this, pos, name, origin){
                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                    return super.tpe_$times();
                }

                public Types.Type tpe_$times() {
                    return SynchronizedTypeSymbol.tpe_$times$(this);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                    if (!this.bitmap$0) {
                        return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$3, name$5, origin$3);
                    SynchronizedSymbol.$init$(this);
                    SynchronizedTypeSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.ClassSymbol createClassSymbol$(SynchronizedSymbol $this, Names.TypeName name, Position pos, long newFlags) {
            return $this.createClassSymbol(name, pos, newFlags);
        }

        default public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
            return (Symbols.ClassSymbol)((Symbols.Symbol)((Object)new SynchronizedClassSymbol(this, pos, name){
                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                    return super.tpe_$times();
                }

                public Types.Type tpe_$times() {
                    return SynchronizedTypeSymbol.tpe_$times$(this);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                    if (!this.bitmap$0) {
                        return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$4, name$6);
                    SynchronizedSymbol.$init$(this);
                    SynchronizedTypeSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.ModuleClassSymbol createModuleClassSymbol$(SynchronizedSymbol $this, Names.TypeName name, Position pos, long newFlags) {
            return $this.createModuleClassSymbol(name, pos, newFlags);
        }

        default public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
            return (Symbols.ModuleClassSymbol)((Symbols.Symbol)((Object)new SynchronizedModuleClassSymbol(this, pos, name){
                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                    return super.tpe_$times();
                }

                public Types.Type tpe_$times() {
                    return SynchronizedTypeSymbol.tpe_$times$(this);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                    if (!this.bitmap$0) {
                        return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$5, name$7);
                    SynchronizedSymbol.$init$(this);
                    SynchronizedTypeSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.PackageClassSymbol createPackageClassSymbol$(SynchronizedSymbol $this, Names.TypeName name, Position pos, long newFlags) {
            return $this.createPackageClassSymbol(name, pos, newFlags);
        }

        default public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
            return (Symbols.PackageClassSymbol)((Symbols.Symbol)((Object)new SynchronizedModuleClassSymbol(this, pos, name){
                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                    return super.tpe_$times();
                }

                public Types.Type tpe_$times() {
                    return SynchronizedTypeSymbol.tpe_$times$(this);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                    if (!this.bitmap$0) {
                        return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$6, name$8);
                    SynchronizedSymbol.$init$(this);
                    SynchronizedTypeSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.RefinementClassSymbol createRefinementClassSymbol$(SynchronizedSymbol $this, Position pos, long newFlags) {
            return $this.createRefinementClassSymbol(pos, newFlags);
        }

        default public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
            return (Symbols.RefinementClassSymbol)((Symbols.Symbol)((Object)new SynchronizedClassSymbol(this, pos){
                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                    return super.tpe_$times();
                }

                public Types.Type tpe_$times() {
                    return SynchronizedTypeSymbol.tpe_$times$(this);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                    if (!this.bitmap$0) {
                        return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$7);
                    SynchronizedSymbol.$init$(this);
                    SynchronizedTypeSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol$(SynchronizedSymbol $this, Position pos, long newFlags) {
            return $this.createPackageObjectClassSymbol(pos, newFlags);
        }

        default public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
            return (Symbols.PackageObjectClassSymbol)((Symbols.Symbol)((Object)new SynchronizedClassSymbol(this, pos){
                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private volatile boolean bitmap$0;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times() {
                    return super.tpe_$times();
                }

                public Types.Type tpe_$times() {
                    return SynchronizedTypeSymbol.tpe_$times$(this);
                }

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                private Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute() {
                    synchronized (this) {
                        if (!this.bitmap$0) {
                            this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock = SynchronizedTypeSymbol.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(this);
                            this.bitmap$0 = true;
                        }
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
                    if (!this.bitmap$0) {
                        return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$lzycompute();
                    }
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock;
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$8);
                    SynchronizedSymbol.$init$(this);
                    SynchronizedTypeSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.MethodSymbol createMethodSymbol$(SynchronizedSymbol $this, Names.TermName name, Position pos, long newFlags) {
            return $this.createMethodSymbol(name, pos, newFlags);
        }

        default public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
            return (Symbols.MethodSymbol)((Symbols.Symbol)((Object)new SynchronizedMethodSymbol(this, pos, name){
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$9, name$9);
                    SynchronizedSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.ModuleSymbol createModuleSymbol$(SynchronizedSymbol $this, Names.TermName name, Position pos, long newFlags) {
            return $this.createModuleSymbol(name, pos, newFlags);
        }

        default public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
            return (Symbols.ModuleSymbol)((Symbols.Symbol)((Object)new SynchronizedTermSymbol(this, pos, name){
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$10, name$10);
                    SynchronizedSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.ModuleSymbol createPackageSymbol$(SynchronizedSymbol $this, Names.TermName name, Position pos, long newFlags) {
            return $this.createPackageSymbol(name, pos, newFlags);
        }

        default public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
            return this.createModuleSymbol(name, pos, newFlags);
        }

        public static /* synthetic */ Symbols.TermSymbol createValueParameterSymbol$(SynchronizedSymbol $this, Names.TermName name, Position pos, long newFlags) {
            return $this.createValueParameterSymbol(name, pos, newFlags);
        }

        default public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
            return (Symbols.TermSymbol)((Symbols.Symbol)((Object)new SynchronizedTermSymbol(this, pos, name){
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$11, name$11);
                    SynchronizedSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public static /* synthetic */ Symbols.TermSymbol createValueMemberSymbol$(SynchronizedSymbol $this, Names.TermName name, Position pos, long newFlags) {
            return $this.createValueMemberSymbol(name, pos, newFlags);
        }

        default public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
            return (Symbols.TermSymbol)((Symbols.Symbol)((Object)new SynchronizedTermSymbol(this, pos, name){
                private volatile boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                private volatile long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                private final /* synthetic */ SynchronizedSymbol $outer;

                public /* synthetic */ Symbols.Symbol scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$privateWithin() {
                    return super.privateWithin();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$annotations() {
                    return super.annotations();
                }

                public /* synthetic */ long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$getFlag(long mask) {
                    return super.getFlag(mask);
                }

                public /* synthetic */ int scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$validTo() {
                    return super.validTo();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$info() {
                    return super.info();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$rawInfo() {
                    return super.rawInfo();
                }

                public /* synthetic */ boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$exists() {
                    return super.exists();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignature() {
                    return super.typeSignature();
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeSignatureIn(Types.Type site) {
                    return super.typeSignatureIn(site);
                }

                public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeConstructor() {
                    return super.typeConstructor();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams() {
                    return super.typeParams();
                }

                public /* synthetic */ List scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams() {
                    return super.unsafeTypeParams();
                }

                public boolean isThreadsafe(Symbols.SymbolOps purpose) {
                    return SynchronizedSymbol.isThreadsafe$(this, purpose);
                }

                public final Symbols.Symbol privateWithin() {
                    return SynchronizedSymbol.privateWithin$(this);
                }

                public List<AnnotationInfos.AnnotationInfo> annotations() {
                    return SynchronizedSymbol.annotations$(this);
                }

                public SynchronizedSymbol markFlagsCompleted(long mask) {
                    return SynchronizedSymbol.markFlagsCompleted$(this, mask);
                }

                public SynchronizedSymbol markAllCompleted() {
                    return SynchronizedSymbol.markAllCompleted$(this);
                }

                public final <T> T gilSynchronizedIfNotThreadsafe(Function0<T> body) {
                    return (T)SynchronizedSymbol.gilSynchronizedIfNotThreadsafe$(this, body);
                }

                public final long getFlag(long mask) {
                    return SynchronizedSymbol.getFlag$(this, mask);
                }

                public int validTo() {
                    return SynchronizedSymbol.validTo$(this);
                }

                public Types.Type info() {
                    return SynchronizedSymbol.info$(this);
                }

                public Types.Type rawInfo() {
                    return SynchronizedSymbol.rawInfo$(this);
                }

                public boolean exists() {
                    return SynchronizedSymbol.exists$(this);
                }

                public Types.Type typeSignature() {
                    return SynchronizedSymbol.typeSignature$(this);
                }

                public Types.Type typeSignatureIn(Types.Type site) {
                    return SynchronizedSymbol.typeSignatureIn$(this, site);
                }

                public Types.Type typeConstructor() {
                    return SynchronizedSymbol.typeConstructor$(this);
                }

                public List<Symbols.Symbol> typeParams() {
                    return SynchronizedSymbol.typeParams$(this);
                }

                public List<Symbols.Symbol> unsafeTypeParams() {
                    return SynchronizedSymbol.unsafeTypeParams$(this);
                }

                public Symbols.AbstractTypeSymbol createAbstractTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAbstractTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.AliasTypeSymbol createAliasTypeSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createAliasTypeSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TypeSkolem createTypeSkolemSymbol(Names.TypeName name, Object origin, Position pos, long newFlags) {
                    return SynchronizedSymbol.createTypeSkolemSymbol$(this, name, origin, pos, newFlags);
                }

                public Symbols.ClassSymbol createClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleClassSymbol createModuleClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.PackageClassSymbol createPackageClassSymbol(Names.TypeName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageClassSymbol$(this, name, pos, newFlags);
                }

                public Symbols.RefinementClassSymbol createRefinementClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createRefinementClassSymbol$(this, pos, newFlags);
                }

                public Symbols.PackageObjectClassSymbol createPackageObjectClassSymbol(Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageObjectClassSymbol$(this, pos, newFlags);
                }

                public Symbols.MethodSymbol createMethodSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createMethodSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createModuleSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createModuleSymbol$(this, name, pos, newFlags);
                }

                public Symbols.ModuleSymbol createPackageSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createPackageSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueParameterSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueParameterSymbol$(this, name, pos, newFlags);
                }

                public Symbols.TermSymbol createValueMemberSymbol(Names.TermName name, Position pos, long newFlags) {
                    return SynchronizedSymbol.createValueMemberSymbol$(this, name, pos, newFlags);
                }

                public boolean scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(boolean x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized = x$1;
                }

                public long scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask() {
                    return this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask;
                }

                public void scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(long x$1) {
                    this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask = x$1;
                }

                public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer() {
                    return this.$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();
                }
                {
                    if ($outer == null) {
                        throw null;
                    }
                    this.$outer = $outer;
                    super((scala.reflect.internal.SymbolTable)((Object)$outer.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()), (Symbols.Symbol)((Object)$outer), pos$12, name$12);
                    SynchronizedSymbol.$init$(this);
                }
            })).initFlags(newFlags);
        }

        public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer();

        private List completeTypeParams$1() {
            if (((Symbols.Symbol)((Object)this)).isMonomorphicType()) {
                return Nil$.MODULE$;
            }
            this.rawInfo().load((Symbols.Symbol)((Object)this));
            if (this.validTo() == 0) {
                this.rawInfo().load((Symbols.Symbol)((Object)this));
            }
            return this.rawInfo().typeParams();
        }

        public static /* synthetic */ List $anonfun$typeParams$1(SynchronizedSymbol $this) {
            if (((SymbolTable)$this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()).isCompilerUniverse()) {
                return $this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$typeParams();
            }
            if ($this.validTo() != 0) {
                return $this.rawInfo().typeParams();
            }
            return $this.completeTypeParams$1();
        }

        public static /* synthetic */ List $anonfun$unsafeTypeParams$1(SynchronizedSymbol $this) {
            if (((SymbolTable)$this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer()).isCompilerUniverse()) {
                return $this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$super$unsafeTypeParams();
            }
            if (((Symbols.Symbol)((Object)$this)).isMonomorphicType()) {
                return Nil$.MODULE$;
            }
            return $this.rawInfo().typeParams();
        }

        public static void $init$(SynchronizedSymbol $this) {
            $this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initialized_$eq(false);
            $this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$_initializationMask_$eq(Flags$.MODULE$.TopLevelPickledFlags());
        }
    }

    public interface SynchronizedTermSymbol
    extends SynchronizedSymbol {
    }

    public interface SynchronizedTypeSymbol
    extends SynchronizedSymbol {
        public /* synthetic */ Types.Type scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times();

        public static /* synthetic */ Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock$(SynchronizedTypeSymbol $this) {
            return $this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock();
        }

        default public Object scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock() {
            return new Object();
        }

        public static /* synthetic */ Types.Type tpe_$times$(SynchronizedTypeSymbol $this) {
            return $this.tpe_$times();
        }

        default public Types.Type tpe_$times() {
            Types.Type type;
            Gil gil = (Gil)((Object)this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedSymbol$$$outer());
            if (gil == null) {
                throw null;
            }
            Gil gilSynchronizedIfNotThreadsafe_gilSynchronized_this = gil;
            if (((SymbolTable)gilSynchronizedIfNotThreadsafe_gilSynchronized_this).isCompilerUniverse()) {
                return SynchronizedTypeSymbol.$anonfun$tpe_$times$1(this);
            }
            try {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().lock();
                type = SynchronizedTypeSymbol.$anonfun$tpe_$times$1(this);
            }
            finally {
                gilSynchronizedIfNotThreadsafe_gilSynchronized_this.scala$reflect$runtime$Gil$$gil().unlock();
            }
            return type;
        }

        public /* synthetic */ SynchronizedSymbols scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$$outer();

        public static /* synthetic */ Types.Type $anonfun$tpe_$times$1(SynchronizedTypeSymbol $this) {
            Object object = $this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$tpeLock();
            synchronized (object) {
                Types.Type type = $this.scala$reflect$runtime$SynchronizedSymbols$SynchronizedTypeSymbol$$super$tpe_$times();
                return type;
            }
        }

        public static void $init$(SynchronizedTypeSymbol $this) {
        }
    }
}

