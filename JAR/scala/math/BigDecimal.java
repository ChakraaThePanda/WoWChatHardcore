/*
 * Decompiled with CFR 0.152.
 */
package scala.math;

import java.math.MathContext;
import scala.Array$;
import scala.Enumeration;
import scala.Function0;
import scala.Function1;
import scala.MatchError;
import scala.None$;
import scala.Option;
import scala.Predef$;
import scala.Serializable;
import scala.Some;
import scala.Tuple2;
import scala.collection.SeqLike;
import scala.collection.immutable.NumericRange;
import scala.collection.immutable.Range$BigDecimal$;
import scala.math.BigDecimal$;
import scala.math.BigInt;
import scala.math.Ordered;
import scala.math.ScalaNumber;
import scala.math.ScalaNumericAnyConversions;
import scala.math.ScalaNumericConversions;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxedUnit;
import scala.runtime.BoxesRunTime;
import scala.runtime.RichDouble$;
import scala.runtime.RichFloat$;
import scala.runtime.Statics;
import scala.util.hashing.MurmurHash3$;

@ScalaSignature(bytes="\u0006\u0001\u0015%q\u0001CA\u0019\u0003gA\t!!\u0010\u0007\u0011\u0005\u0005\u00131\u0007E\u0001\u0003\u0007Bq!a\u0015\u0002\t\u0003\t)\u0006C\u0005\u0002X\u0005\u0011\r\u0011\"\u0004\u0002Z!A\u0011qL\u0001!\u0002\u001b\tY\u0006C\u0005\u0002b\u0005\u0011\r\u0011\"\u0004\u0002d!A\u0011\u0011N\u0001!\u0002\u001b\t)\u0007C\u0005\u0002l\u0005\u0011\r\u0011\"\u0004\u0002n!A\u00111O\u0001!\u0002\u001b\ty\u0007C\u0005\u0002v\u0005\u0011\r\u0011\"\u0003\u0002x!A\u0011qP\u0001!\u0002\u0013\tI\bC\u0005\u0002\u0002\u0006\u0011\r\u0011\"\u0003\u0002x!A\u00111Q\u0001!\u0002\u0013\tI\bC\u0005\u0002\u0006\u0006\u0011\r\u0011\"\u0001\u0002\b\"A\u0011qS\u0001!\u0002\u0013\tI\t\u0003\u0006\u0002\u001a\u0006A)\u0019!C\u0005\u00037;qAa3\u0002\u0011\u0003\u0011iMB\u0004\u0003R\u0006A\tAa5\t\u000f\u0005M\u0013\u0003\"\u0001\u0003\\\u00161!\u0011[\t\u0001\u0005;D\u0011B!:\u0012\u0005\u0004%\tAa:\t\u0011\t%\u0018\u0003)A\u0005\u0005;D\u0011Ba;\u0012\u0005\u0004%\tAa:\t\u0011\t5\u0018\u0003)A\u0005\u0005;D\u0011Ba<\u0012\u0005\u0004%\tAa:\t\u0011\tE\u0018\u0003)A\u0005\u0005;D\u0011Ba=\u0012\u0005\u0004%\tAa:\t\u0011\tU\u0018\u0003)A\u0005\u0005;D\u0011Ba>\u0012\u0005\u0004%\tAa:\t\u0011\te\u0018\u0003)A\u0005\u0005;D\u0011Ba?\u0012\u0005\u0004%\tAa:\t\u0011\tu\u0018\u0003)A\u0005\u0005;D\u0011Ba@\u0012\u0005\u0004%\tAa:\t\u0011\r\u0005\u0011\u0003)A\u0005\u0005;D\u0011ba\u0001\u0012\u0005\u0004%\tAa:\t\u0011\r\u0015\u0011\u0003)A\u0005\u0005;Dqaa7\u0002\t\u0003\u0019i\u000eC\u0004\u0004\\\u0006!\ta!:\t\u000f\rm\u0017\u0001\"\u0001\u0004j\"911\\\u0001\u0005\u0002\rE\bbBBn\u0003\u0011\u00051Q\u001f\u0005\b\u00077\fA\u0011AB\u007f\u0011\u001d\u0019Y.\u0001C\u0001\t\u0003Aq\u0001\"\u0003\u0002\t\u0003!Y\u0001C\u0004\u0005\n\u0005!\t\u0001\"\u0005\t\u000f\u0011U\u0011\u0001\"\u0001\u0005\u0018!9AQC\u0001\u0005\u0002\u0011u\u0001b\u0002C\u000b\u0003\u0011\u0005A\u0011\u0005\u0005\b\t+\tA\u0011\u0001C\u0014\u0011\u001d!)\"\u0001C\u0001\tWAq\u0001\"\u0006\u0002\t\u0003!\t\u0004C\u0004\u0005:\u0005!\t\u0001b\u000f\t\u000f\u0011e\u0012\u0001\"\u0001\u0005@!9A\u0011H\u0001\u0005\u0002\u0011-\u0003b\u0002C\u001d\u0003\u0011\u0005A\u0011\u000b\u0005\b\ts\tA\u0011\u0001C.\u0011\u001d\u0011\t,\u0001C\u0001\tGBqA!-\u0002\t\u0003!I\u0007C\u0004\u00032\u0006!\t\u0001b\u001c\t\u000f\tE\u0016\u0001\"\u0001\u0005t!9!\u0011W\u0001\u0005\u0002\u0011e\u0004b\u0002BY\u0003\u0011\u0005A\u0011\u0011\u0005\b\u0005c\u000bA\u0011\u0001CE\u0011\u001d\u0011\t,\u0001C\u0001\t\u001bCqA!-\u0002\t\u0003!\u0019\nC\u0004\u00032\u0006!\t\u0001\"(\t\u000f\tE\u0016\u0001\"\u0001\u0005&\"9!\u0011W\u0001\u0005\u0002\u0011%\u0006b\u0002BY\u0003\u0011\u0005Aq\u0016\u0005\b\u0005c\u000bA\u0011\u0001CZ\u0011\u001d\u0011\t,\u0001C\u0001\tsCqA!-\u0002\t\u0003!i\fC\u0004\u00032\u0006!\t\u0001b1\t\u000f\tE\u0016\u0001\"\u0001\u0005J\"9!\u0011W\u0001\u0005\u0002\u0011E\u0007b\u0002BY\u0003\u0011\u0005AQ\u001b\u0005\b\tC\fA1\u0001Cr\u0011\u001d!9/\u0001C\u0002\tSDq\u0001\"<\u0002\t\u0007!y\u000fC\u0004\u0005t\u0006!\u0019\u0001\">\t\u0013\u0011e\u0018!!A\u0005\n\u0011mhaBA!\u0003g\u0011\u0011Q\u0015\u0005\u000b\u0003s\u000b&Q1A\u0005\u0002\u0005m\u0006BCAa#\n\u0005\t\u0015!\u0003\u0002>\"Q\u00111Y)\u0003\u0006\u0004%\t!a\"\t\u0015\u0005\u0015\u0017K!A!\u0002\u0013\tI\tC\u0004\u0002TE#\t!a2\t\u000f\u0005M\u0013\u000b\"\u0001\u0002N\"I\u0011\u0011[)A\u0002\u00135\u0011q\u000f\u0005\n\u0003'\f\u0006\u0019!C\u0007\u0003+D\u0001\"!9RA\u00036\u0011\u0011\u0010\u0005\b\u0003G\fFQBAs\u0011\u001d\t9/\u0015C!\u0003SDq!a;R\t\u0003\ni\u000fC\u0004\u0002\u0000F#\tE!\u0001\t\u000f\t\r\u0011\u000b\"\u0011\u0003\u0002!9!QA)\u0005B\t\u0005\u0001b\u0002B\u0004#\u0012\u0005#\u0011\u0001\u0005\b\u0005\u0013\tF\u0011\u0001B\u0001\u0011\u001d\u0011Y!\u0015C\u0001\u0005\u0003AqA!\bR\t\u0003\u0011\t\u0001C\u0004\u0003&E#\tA!\u0001\t\u000f\t\u001d\u0012\u000b\"\u0001\u0003\u0002!9!\u0011F)\u0005\u0002\t\u0005\u0001b\u0002B\u0016#\u0012\u0005!\u0011\u0001\u0005\b\u0005[\tF\u0011\u0001B\u0001\u0011\u001d\u0011y#\u0015C\u0001\u0005\u0003AqA!\rR\t\u0013\u0011\u0019\u0004C\u0004\u0003@E#\tA!\u0011\t\u000f\t\r\u0013\u000b\"\u0001\u0003F!9\u00111^)\u0005\u0002\t\u001d\u0003b\u0002B&#\u0012\u0005!Q\n\u0005\b\u0005#\nF\u0011\u0001B*\u0011\u001d\u00119&\u0015C\u0001\u00053BqA!\u0018R\t\u0003\u0011y\u0006C\u0004\u0003dE#\tA!\u001a\t\u000f\t%\u0014\u000b\"\u0001\u0003l!9!QO)\u0005\u0002\t]\u0004b\u0002B>#\u0012\u0005!Q\u0010\u0005\b\u0005\u0003\u000bF\u0011\u0001BB\u0011\u001d\u00119)\u0015C\u0001\u0005\u0013CqA!$R\t\u0003\u0011y\tC\u0004\u0003\u0014F#\tA!&\t\u000f\tm\u0015\u000b\"\u0001\u0003\u001e\"9!qT)\u0005\u0002\tu\u0005b\u0002BQ#\u0012\u0005\u0011q\u000f\u0005\b\u0005G\u000bF\u0011AA<\u0011\u001d\u0011)+\u0015C\u0001\u0005OCqAa+R\t\u0003\u0011i\nC\u0004\u0003.F#\t!a\u001e\t\u000f\t=\u0016\u000b\"\u0001\u0003\u001e\"9!\u0011W)\u0005\u0002\tM\u0006b\u0002B\\#\u0012\u0005!\u0011\u0018\u0005\b\u0005o\u000bF\u0011\u0001B_\u0011\u001d\u00199!\u0015C!\u0007\u0013Aqa!\u0005R\t\u0003\u001a\u0019\u0002C\u0004\u0004\u001cE#\ta!\b\t\u000f\r\u0015\u0012\u000b\"\u0001\u0002j\"91qE)\u0005\u0002\r%\u0002bBB\u0019#\u0012\u000511\u0007\u0005\b\u0007w\tF\u0011AB\u001f\u0011\u001d\u0019)%\u0015C\u0001\u0007\u000fBqa!\u0013R\t\u0003\u0019Y\u0005C\u0004\u0004NE#\t!a\u001e\t\u000f\r=\u0013\u000b\"\u0001\u0004R!911K)\u0005\u0002\rU\u0003bBB*#\u0012\u00051\u0011\u0012\u0005\b\u0007/\u000bF\u0011ABM\u0011\u001d\u00199*\u0015C\u0001\u0007KCqa!,R\t\u0003\u0019y\u000bC\u0004\u00048F#\ta!/\t\u000f\r\u0005\u0017\u000b\"\u0011\u0004D\u0006Q!)[4EK\u000eLW.\u00197\u000b\t\u0005U\u0012qG\u0001\u0005[\u0006$\bN\u0003\u0002\u0002:\u0005)1oY1mC\u000e\u0001\u0001cAA \u00035\u0011\u00111\u0007\u0002\u000b\u0005&<G)Z2j[\u0006d7#B\u0001\u0002F\u00055\u0003\u0003BA$\u0003\u0013j!!a\u000e\n\t\u0005-\u0013q\u0007\u0002\u0007\u0003:L(+\u001a4\u0011\t\u0005\u001d\u0013qJ\u0005\u0005\u0003#\n9D\u0001\u0007TKJL\u0017\r\\5{C\ndW-\u0001\u0004=S:LGO\u0010\u000b\u0003\u0003{\t\u0001#\\1yS6,X\u000eS1tQN\u001b\u0017\r\\3\u0016\u0005\u0005msBAA/;\t\u0019b)A\tnCbLW.^7ICND7kY1mK\u0002\n1\u0003[1tQ\u000e{G-\u001a(pi\u000e{W\u000e];uK\u0012,\"!!\u001a\u0010\u0005\u0005\u001dT\u0004B/QS>\tA\u0003[1tQ\u000e{G-\u001a(pi\u000e{W\u000e];uK\u0012\u0004\u0013a\u00033fG&\u0014$-\u001b8bef,\"!a\u001c\u0010\u0005\u0005E\u0004\u0005\u0003!\u000b'?K\u0011p):\u0002\u0019\u0011,7-\u001b\u001acS:\f'/\u001f\u0011\u0002\u00135LgnQ1dQ\u0016$WCAA=!\u0011\t9%a\u001f\n\t\u0005u\u0014q\u0007\u0002\u0004\u0013:$\u0018AC7j]\u000e\u000b7\r[3eA\u0005IQ.\u0019=DC\u000eDW\rZ\u0001\u000b[\u0006D8)Y2iK\u0012\u0004\u0013A\u00053fM\u0006,H\u000e^'bi\"\u001cuN\u001c;fqR,\"!!#\u0011\t\u0005-\u00151S\u0007\u0003\u0003\u001bSA!!\u000e\u0002\u0010*\u0011\u0011\u0011S\u0001\u0005U\u00064\u0018-\u0003\u0003\u0002\u0016\u00065%aC'bi\"\u001cuN\u001c;fqR\f1\u0003Z3gCVdG/T1uQ\u000e{g\u000e^3yi\u0002\nQaY1dQ\u0016,\"!!(\u0011\r\u0005\u001d\u0013qTAR\u0013\u0011\t\t+a\u000e\u0003\u000b\u0005\u0013(/Y=\u0011\u0007\u0005}\u0012kE\u0005R\u0003O\u000bi+!\u0014\u00024B!\u0011qHAU\u0013\u0011\tY+a\r\u0003\u0017M\u001b\u0017\r\\1Ok6\u0014WM\u001d\t\u0005\u0003\u007f\ty+\u0003\u0003\u00022\u0006M\"aF*dC2\fg*^7fe&\u001c7i\u001c8wKJ\u001c\u0018n\u001c8t!\u0019\ty$!.\u0002$&!\u0011qWA\u001a\u0005\u001dy%\u000fZ3sK\u0012\f!BY5h\t\u0016\u001c\u0017.\\1m+\t\ti\f\u0005\u0003\u0002\f\u0006}\u0016\u0002BA!\u0003\u001b\u000b1BY5h\t\u0016\u001c\u0017.\\1mA\u0005\u0011QnY\u0001\u0004[\u000e\u0004CCBAR\u0003\u0013\fY\rC\u0004\u0002:Z\u0003\r!!0\t\u000f\u0005\rg\u000b1\u0001\u0002\nR!\u00111UAh\u0011\u001d\tIl\u0016a\u0001\u0003{\u000b\u0001cY8naV$X\r\u001a%bg\"\u001cu\u000eZ3\u0002)\r|W\u000e];uK\u0012D\u0015m\u001d5D_\u0012,w\fJ3r)\u0011\t9.!8\u0011\t\u0005\u001d\u0013\u0011\\\u0005\u0005\u00037\f9D\u0001\u0003V]&$\b\"CAp3\u0006\u0005\t\u0019AA=\u0003\rAH%M\u0001\u0012G>l\u0007/\u001e;fI\"\u000b7\u000f[\"pI\u0016\u0004\u0013aD2p[B,H/\u001a%bg\"\u001cu\u000eZ3\u0015\u0005\u0005]\u0017\u0001\u00035bg\"\u001cu\u000eZ3\u0015\u0005\u0005e\u0014AB3rk\u0006d7\u000f\u0006\u0003\u0002p\u0006U\b\u0003BA$\u0003cLA!a=\u00028\t9!i\\8mK\u0006t\u0007bBA|;\u0002\u0007\u0011\u0011`\u0001\u0005i\"\fG\u000f\u0005\u0003\u0002H\u0005m\u0018\u0002BA\u007f\u0003o\u00111!\u00118z\u0003-I7OV1mS\u0012\u0014\u0015\u0010^3\u0016\u0005\u0005=\u0018\u0001D5t-\u0006d\u0017\u000eZ*i_J$\u0018aC5t-\u0006d\u0017\u000eZ\"iCJ\f!\"[:WC2LG-\u00138u\u0003-I7OV1mS\u0012duN\\4\u0002\u0019%\u001ch+\u00197jI\u001acw.\u0019;)\u000f\r\u0014yA!\u0006\u0003\u001aA!\u0011q\tB\t\u0013\u0011\u0011\u0019\"a\u000e\u0003\u0015\u0011,\u0007O]3dCR,G-\t\u0002\u0003\u0018\u00059w\u000b[1uA\r|gn\u001d;jiV$Xm\u001d\u0011wC2LG-\u001b;zA%\u001c\b%\u001e8dY\u0016\f'O\f\u0011Vg\u0016\u0004\u0003-[:Fq\u0006\u001cGO\u00127pCR\u0004G\u0006\t1jg\nKg.\u0019:z\r2|\u0017\r\u001e1-A=\u0014\b\u0005Y5t\t\u0016\u001c\u0017.\\1m\r2|\u0017\r\u001e1!S:\u001cH/Z1e]\u0005\u0012!1D\u0001\u0007e9\n\u0014G\f\u0019\u0002\u001b%\u001ch+\u00197jI\u0012{WO\u00197fQ\u001d!'q\u0002B\u0011\u00053\t#Aa\t\u0002IZ\u000bG.\u001b3jif\u0004\u0003.Y:!I&\u001cH/\u001b8di\u0002jW-\u00198j]\u001e\u001ch\u0006I+tK\u0002\u0002\u0017n]#yC\u000e$Hi\\;cY\u0016\u0004G\u0006\t1jg\nKg.\u0019:z\t>,(\r\\3aY\u0001z'\u000f\t1jg\u0012+7-[7bY\u0012{WO\u00197fA\u0002Jgn\u001d;fC\u0012t\u0013aD5t\t\u0016\u001c\u0017.\\1m\t>,(\r\\3\u0002\u001d%\u001cH)Z2j[\u0006dg\t\\8bi\u0006q\u0011n\u001d\"j]\u0006\u0014\u0018\u0010R8vE2,\u0017!D5t\u0005&t\u0017M]=GY>\fG/A\u0007jg\u0016C\u0018m\u0019;E_V\u0014G.Z\u0001\rSN,\u00050Y2u\r2|\u0017\r^\u0001\u0016]>\f%/\u001b;i[\u0016$\u0018nY#yG\u0016\u0004H/[8o)\u0011\tyO!\u000e\t\u0011\t]2\u000e\"a\u0001\u0005s\tAAY8esB1\u0011q\tB\u001e\u0003/LAA!\u0010\u00028\tAAHY=oC6,g(A\u0004jg^Cw\u000e\\3\u0015\u0005\u0005=\u0018AC;oI\u0016\u0014H._5oOR\u0011\u0011Q\u0018\u000b\u0005\u0003_\u0014I\u0005C\u0004\u0002x:\u0004\r!a)\u0002\u000f\r|W\u000e]1sKR!\u0011\u0011\u0010B(\u0011\u001d\t9p\u001ca\u0001\u0003G\u000bQ\u0001\n9mkN$B!a)\u0003V!9\u0011q\u001f9A\u0002\u0005\r\u0016A\u0002\u0013nS:,8\u000f\u0006\u0003\u0002$\nm\u0003bBA|c\u0002\u0007\u00111U\u0001\u0007IQLW.Z:\u0015\t\u0005\r&\u0011\r\u0005\b\u0003o\u0014\b\u0019AAR\u0003\u0011!C-\u001b<\u0015\t\u0005\r&q\r\u0005\b\u0003o\u001c\b\u0019AAR\u00031!C-\u001b<%a\u0016\u00148-\u001a8u)\u0011\u0011iGa\u001d\u0011\u0011\u0005\u001d#qNAR\u0003GKAA!\u001d\u00028\t1A+\u001e9mKJBq!a>u\u0001\u0004\t\u0019+\u0001\u0003rk>$H\u0003BAR\u0005sBq!a>v\u0001\u0004\t\u0019+A\u0002nS:$B!a)\u0003\u0000!9\u0011q\u001f<A\u0002\u0005\r\u0016aA7bqR!\u00111\u0015BC\u0011\u001d\t9p\u001ea\u0001\u0003G\u000b\u0011B]3nC&tG-\u001a:\u0015\t\u0005\r&1\u0012\u0005\b\u0003oD\b\u0019AAR\u0003!!\u0003/\u001a:dK:$H\u0003BAR\u0005#Cq!a>z\u0001\u0004\t\u0019+A\u0002q_^$B!a)\u0003\u0018\"9!\u0011\u0014>A\u0002\u0005e\u0014!\u00018\u0002\u0019Ut\u0017M]=`I5Lg.^:\u0016\u0005\u0005\r\u0016aA1cg\u000611/[4ok6\f\u0011\u0002\u001d:fG&\u001c\u0018n\u001c8\u0002\u000bI|WO\u001c3\u0015\t\u0005\r&\u0011\u0016\u0005\b\u0003\u0007|\b\u0019AAE\u0003\u001d\u0011x.\u001e8eK\u0012\fQa]2bY\u0016\f1!\u001e7q\u0003\u0015\t\u0007\u000f\u001d7z)\u0011\t\u0019K!.\t\u0011\u0005\r\u0017q\u0001a\u0001\u0003\u0013\u000b\u0001b]3u'\u000e\fG.\u001a\u000b\u0005\u0003G\u0013Y\f\u0003\u0005\u0003.\u0006%\u0001\u0019AA=)\u0019\t\u0019Ka0\u0003B\"A!QVA\u0006\u0001\u0004\tI\b\u0003\u0005\u0003D\u0006-\u0001\u0019\u0001Bc\u0003\u0011iw\u000eZ3\u0011\u0007\t\u001d7CD\u0002\u0003JBq1!a\u0010\u0001\u00031\u0011v.\u001e8eS:<Wj\u001c3f!\r\u0011y-E\u0007\u0002\u0003\ta!k\\;oI&tw-T8eKN\u0019\u0011C!6\u0011\t\u0005\u001d#q[\u0005\u0005\u00053\f9DA\u0006F]VlWM]1uS>tGC\u0001Bg!\u0011\u0011yN!9\u000e\u0003EIAAa9\u0003X\n)a+\u00197vK\u0006\u0011Q\u000bU\u000b\u0003\u0005;\f1!\u0016)!\u0003\u0011!uj\u0016(\u0002\u000b\u0011{uK\u0014\u0011\u0002\u000f\r+\u0015\nT%O\u000f\u0006A1)R%M\u0013:;\u0005%A\u0003G\u0019>{%+\u0001\u0004G\u0019>{%\u000bI\u0001\b\u0011\u0006ceiX+Q\u0003!A\u0015\t\u0014$`+B\u0003\u0013!\u0003%B\u0019\u001a{FiT,O\u0003)A\u0015\t\u0014$`\t>;f\nI\u0001\n\u0011\u0006ceiX#W\u000b:\u000b!\u0002S!M\r~+e+\u0012(!\u0003-)fJT#D\u000bN\u001b\u0016IU-\u0002\u0019Use*R\"F'N\u000b%+\u0017\u0011\u0002\u0013\tLH/\u001a,bYV,GCAB\u0006!\u0011\t9e!\u0004\n\t\r=\u0011q\u0007\u0002\u0005\u0005f$X-\u0001\u0006tQ>\u0014HOV1mk\u0016$\"a!\u0006\u0011\t\u0005\u001d3qC\u0005\u0005\u00073\t9DA\u0003TQ>\u0014H/A\u0005dQ\u0006\u0014h+\u00197vKV\u00111q\u0004\t\u0005\u0003\u000f\u001a\t#\u0003\u0003\u0004$\u0005]\"\u0001B\"iCJ\f\u0001\"\u001b8u-\u0006dW/Z\u0001\nY>twMV1mk\u0016$\"aa\u000b\u0011\t\u0005\u001d3QF\u0005\u0005\u0007_\t9D\u0001\u0003M_:<\u0017A\u00034m_\u0006$h+\u00197vKR\u00111Q\u0007\t\u0005\u0003\u000f\u001a9$\u0003\u0003\u0004:\u0005]\"!\u0002$m_\u0006$\u0018a\u00033pk\ndWMV1mk\u0016$\"aa\u0010\u0011\t\u0005\u001d3\u0011I\u0005\u0005\u0007\u0007\n9D\u0001\u0004E_V\u0014G.Z\u0001\fi>\u0014\u0015\u0010^3Fq\u0006\u001cG/\u0006\u0002\u0004\f\u0005aAo\\*i_J$X\t_1diV\u00111QC\u0001\u000bi>Le\u000e^#yC\u000e$\u0018a\u0003;p\u0019>tw-\u0012=bGR,\"aa\u000b\u0002\u000bUtG/\u001b7\u0015\t\r]3Q\u0011\t\t\u00073\u001a9'a)\u0004v9!11LB1\u001d\u0011\t9e!\u0018\n\t\r}\u0013qG\u0001\ba\u0006\u001c7.Y4f\u0013\u0011\u0019\u0019g!\u001a\u0002\u000bI\u000bgnZ3\u000b\t\r}\u0013qG\u0005\u0005\u0007S\u001aYGA\u0004QCJ$\u0018.\u00197\u000b\t\r\r4Q\u000e\u0006\u0005\u0007_\u001a\t(A\u0005j[6,H/\u00192mK*!11OA\u001c\u0003)\u0019w\u000e\u001c7fGRLwN\u001c\t\u0007\u0007o\u001ay(a)\u000f\t\re41P\u0007\u0003\u0007[JAa! \u0004n\u0005aa*^7fe&\u001c'+\u00198hK&!1\u0011QBB\u0005%)\u0005p\u00197vg&4XM\u0003\u0003\u0004~\r5\u0004\u0002CBD\u0003G\u0001\r!a)\u0002\u0007\u0015tG\r\u0006\u0004\u0004\f\u000eE51\u0013\t\u0007\u0007o\u001ayh!$\u0011\t\rm3qR\u0005\u0005\u0003\u0003\u001a)\u0007\u0003\u0005\u0004\b\u0006\u0015\u0002\u0019AAR\u0011!\u0019)*!\nA\u0002\u0005\r\u0016\u0001B:uKB\f!\u0001^8\u0015\t\rm51\u0015\t\t\u00073\u001a9'a)\u0004\u001eB11qOBP\u0003GKAa!)\u0004\u0004\nI\u0011J\\2mkNLg/\u001a\u0005\t\u0007\u000f\u000b9\u00031\u0001\u0002$R11qUBU\u0007W\u0003baa\u001e\u0004 \u000e5\u0005\u0002CBD\u0003S\u0001\r!a)\t\u0011\rU\u0015\u0011\u0006a\u0001\u0003G\u000b\u0001\u0002^8CS\u001eLe\u000e\u001e\u000b\u0003\u0007c\u0003B!a\u0010\u00044&!1QWA\u001a\u0005\u0019\u0011\u0015nZ%oi\u0006iAo\u001c\"jO&sG/\u0012=bGR$\"aa/\u0011\r\u0005\u001d3QXBY\u0013\u0011\u0019y,a\u000e\u0003\r=\u0003H/[8o\u0003!!xn\u0015;sS:<GCABc!\u0011\u00199m!6\u000f\t\r%7\u0011\u001b\t\u0005\u0007\u0017\f9$\u0004\u0002\u0004N*!1qZA\u001e\u0003\u0019a$o\\8u}%!11[A\u001c\u0003\u0019\u0001&/\u001a3fM&!1q[Bm\u0005\u0019\u0019FO]5oO*!11[A\u001c\u0003\u001d!WmY5nC2$b!a)\u0004`\u000e\r\bbBBqI\u0001\u00071qH\u0001\u0002I\"9\u00111\u0019\u0013A\u0002\u0005%E\u0003BAR\u0007ODqa!9&\u0001\u0004\u0019y\u0004\u0006\u0004\u0002$\u000e-8q\u001e\u0005\b\u0007[4\u0003\u0019AB\u001b\u0003\u00051\u0007bBAbM\u0001\u0007\u0011\u0011\u0012\u000b\u0005\u0003G\u001b\u0019\u0010C\u0004\u0004n\u001e\u0002\ra!\u000e\u0015\r\u0005\r6q_B~\u0011\u001d\u0019I\u0010\u000ba\u0001\u0007W\t\u0011\u0001\u001c\u0005\b\u0003\u0007D\u0003\u0019AAE)\u0011\t\u0019ka@\t\u000f\re\u0018\u00061\u0001\u0004,Q1\u00111\u0015C\u0002\t\u000fAq\u0001\"\u0002+\u0001\u0004\ti,\u0001\u0002cI\"9\u00111\u0019\u0016A\u0002\u0005%\u0015A\u00022j]\u0006\u0014\u0018\u0010\u0006\u0004\u0002$\u00125Aq\u0002\u0005\b\u0007C\\\u0003\u0019AB \u0011\u001d\t\u0019m\u000ba\u0001\u0003\u0013#B!a)\u0005\u0014!91\u0011\u001d\u0017A\u0002\r}\u0012!B3yC\u000e$H\u0003BAR\t3Aq\u0001b\u0007.\u0001\u0004\ti,\u0001\u0003sKB\u0014H\u0003BAR\t?Aqa!9/\u0001\u0004\u0019y\u0004\u0006\u0003\u0002$\u0012\r\u0002b\u0002C\u0013_\u0001\u00071\u0011W\u0001\u0003E&$B!a)\u0005*!91\u0011 \u0019A\u0002\r-B\u0003BAR\t[Aq\u0001b\f2\u0001\u0004\u0019)-A\u0001t)\u0011\t\u0019\u000bb\r\t\u000f\u0011U\"\u00071\u0001\u00058\u0005\u00111m\u001d\t\u0007\u0003\u000f\nyja\b\u0002\u000fY\fG.^3PMR!\u00111\u0015C\u001f\u0011\u001d\u0019\to\ra\u0001\u0007\u007f!b!a)\u0005B\u0011\r\u0003bBBqi\u0001\u00071q\b\u0005\b\u0003\u0007$\u0004\u0019AAEQ\u001d!$q\u0002C$\u00053\t#\u0001\"\u0013\u0002\u0003\u001bi\u0015\r\u001e5D_:$X\r\u001f;!SN\u0004cn\u001c;!CB\u0004H.[3eAQ|\u0007\u0005R8vE2,7\u000fI5oAY\fG.^3PM:\u0002Sk]3!\u0005&<G)Z2j[\u0006dg\u0006Z3dS6\fG\u000e\t;pAU\u001cX\r\t:pk:$\u0017N\\4-A=\u0014\bE[1wC:j\u0017\r\u001e5/\u0005&<G)Z2j[\u0006dgF^1mk\u0016|e\r\t;pA\u00054x.\u001b3!SRtC\u0003BAR\t\u001bBq\u0001b\u00146\u0001\u0004\u0019Y#A\u0001y)\u0011\t\u0019\u000bb\u0015\t\u000f\r5h\u00071\u0001\u00046!:aGa\u0004\u0005X\te\u0011E\u0001C-\u0003a3En\\1uA\u0005\u0014x-^7f]R\u001c\b\u0005^8!m\u0006dW/Z(gA5\f\u0017\u0010\t8pi\u0002\"w\u000eI<iCR\u0004\u0013p\\;!o&\u001c\bN\f\u0011Vg\u0016\u0004C-Z2j[\u0006d\u0007e\u001c:!m\u0006dW/Z(gQ\u0019tCo\u001c#pk\ndW-\u000b\u0018\u0015\r\u0005\rFQ\fC0\u0011\u001d\u0019io\u000ea\u0001\u0007kAq!a18\u0001\u0004\tI\tK\u00048\u0005\u001f!9F!\u0007\u0015\t\u0005\rFQ\r\u0005\b\tOB\u0004\u0019AA=\u0003\u0005IGCBAR\tW\"i\u0007C\u0004\u0005he\u0002\r!!\u001f\t\u000f\u0005\r\u0017\b1\u0001\u0002\nR!\u00111\u0015C9\u0011\u001d\u0019IP\u000fa\u0001\u0007W!b!a)\u0005v\u0011]\u0004bBB}w\u0001\u000711\u0006\u0005\b\u0003\u0007\\\u0004\u0019AAE)\u0019\t\u0019\u000bb\u001f\u0005\u0000!9AQ\u0010\u001fA\u0002\r-\u0012aC;og\u000e\fG.\u001a3WC2DqA!,=\u0001\u0004\tI\b\u0006\u0005\u0002$\u0012\rEQ\u0011CD\u0011\u001d!i(\u0010a\u0001\u0007WAqA!,>\u0001\u0004\tI\bC\u0004\u0002Dv\u0002\r!!#\u0015\t\u0005\rF1\u0012\u0005\b\u0007Ct\u0004\u0019AB )\u0019\t\u0019\u000bb$\u0005\u0012\"91\u0011] A\u0002\r}\u0002bBAb\u007f\u0001\u0007\u0011\u0011\u0012\u000b\u0005\u0003G#)\nC\u0004\u0005P\u0001\u0003\ra!\u000e)\u000f\u0001\u0013y\u0001\"'\u0003\u001a\u0005\u0012A1T\u0001\u0002@QCW\r\t3fM\u0006,H\u000e\u001e\u0011d_:4XM]:j_:\u0004cM]8nA\u0019cw.\u0019;![\u0006L\bE\\8uA\u0011|\u0007e\u001e5bi\u0002Jx.\u001e\u0011xC:$h\u0006I+tK\u0002\u0012\u0015n\u001a#fG&l\u0017\r\u001c\u0018eK\u000eLW.\u00197!M>\u0014\b%\u0019\u0011TiJLgn\u001a\u0011sKB\u0014Xm]3oi\u0006$\u0018n\u001c8-A=\u0014\b%\u001a=qY&\u001c\u0017\u000e\u001e7zA\r|gN^3si\u0002\"\b.\u001a\u0011GY>\fG\u000fI<ji\"\u0004c\u0006^8E_V\u0014G.\u001a\u0018\u0015\r\u0005\rFq\u0014CQ\u0011\u001d!y%\u0011a\u0001\u0007kAq!a1B\u0001\u0004\tI\tK\u0004B\u0005\u001f!IJ!\u0007\u0015\t\u0005\rFq\u0015\u0005\b\t\u001f\u0012\u0005\u0019\u0001C\u001c)\u0019\t\u0019\u000bb+\u0005.\"9AqJ\"A\u0002\u0011]\u0002bBAb\u0007\u0002\u0007\u0011\u0011\u0012\u000b\u0005\u0003G#\t\fC\u0004\u0005P\u0011\u0003\ra!2\u0015\r\u0005\rFQ\u0017C\\\u0011\u001d!y%\u0012a\u0001\u0007\u000bDq!a1F\u0001\u0004\tI\t\u0006\u0003\u0002$\u0012m\u0006b\u0002C(\r\u0002\u00071\u0011\u0017\u000b\u0007\u0003G#y\f\"1\t\u000f\u0011=s\t1\u0001\u00042\"9\u00111Y$A\u0002\u0005%ECBAR\t\u000b$9\rC\u0004\u0005~!\u0003\ra!-\t\u000f\t5\u0006\n1\u0001\u0002zQA\u00111\u0015Cf\t\u001b$y\rC\u0004\u0005~%\u0003\ra!-\t\u000f\t5\u0016\n1\u0001\u0002z!9\u00111Y%A\u0002\u0005%E\u0003BAR\t'Dq\u0001\"\u0002K\u0001\u0004\ti\f\u0006\u0004\u0002$\u0012]G\u0011\u001c\u0005\b\t\u000bY\u0005\u0019AA_\u0011\u001d\t\u0019m\u0013a\u0001\u0003\u0013Csa\u0013B\b\t;\u0014I\"\t\u0002\u0005`\u0006\t\u0019\u0006\u00165jg\u0002jW\r\u001e5pI\u0002\n\u0007\u000f]3beN\u0004Co\u001c\u0011s_VtG\rI1!U\u00064\u0018ML7bi\"t#)[4EK\u000eLW.\u00197!EV$\b%Y2uk\u0006dG.\u001f\u0011e_\u0016\u001chn\n;/AU\u001bX\r\t8fo\u0002\u0012\u0015n\u001a#fG&l\u0017\r\u001c\u0015cI2\u0002SnY\u0015!S:\u001cH/Z1eA\u0019|'\u000f\t8pAI|WO\u001c3j]\u001ed\u0003e\u001c:!\u0005&<G)Z2j[\u0006dg\u0006Z3dS6\fG\u000e\u000b2eY\u0001j7-\u000b\u0011g_J\u0004#o\\;oI&twML\u0001\u000fS:$(GY5h\t\u0016\u001c\u0017.\\1m)\u0011\t\u0019\u000b\":\t\u000f\u0011\u001dD\n1\u0001\u0002z\u0005yAn\u001c8he\tLw\rR3dS6\fG\u000e\u0006\u0003\u0002$\u0012-\bbBB}\u001b\u0002\u000711F\u0001\u0012I>,(\r\\33E&<G)Z2j[\u0006dG\u0003BAR\tcDqa!9O\u0001\u0004\u0019y$A\rkCZ\f')[4EK\u000eLW.\u001973E&<G)Z2j[\u0006dG\u0003BAR\toDq\u0001b\u0014P\u0001\u0004\ti,A\u0006sK\u0006$'+Z:pYZ,GC\u0001C\u007f!\u0011!y0\"\u0002\u000e\u0005\u0015\u0005!\u0002BC\u0002\u0003\u001f\u000bA\u0001\\1oO&!QqAC\u0001\u0005\u0019y%M[3di\u0002")
public final class BigDecimal
extends ScalaNumber
implements ScalaNumericConversions,
Serializable,
Ordered<BigDecimal> {
    private final java.math.BigDecimal bigDecimal;
    private final MathContext mc;
    private int computedHashCode;

    public static BigDecimal javaBigDecimal2bigDecimal(java.math.BigDecimal bigDecimal) {
        return BigDecimal$.MODULE$.javaBigDecimal2bigDecimal(bigDecimal);
    }

    public static BigDecimal double2bigDecimal(double d) {
        return BigDecimal$.MODULE$.double2bigDecimal(d);
    }

    public static BigDecimal long2bigDecimal(long l) {
        return BigDecimal$.MODULE$.long2bigDecimal(l);
    }

    public static BigDecimal int2bigDecimal(int n) {
        return BigDecimal$.MODULE$.int2bigDecimal(n);
    }

    public static BigDecimal valueOf(float f, MathContext mathContext) {
        return BigDecimal$.MODULE$.valueOf(f, mathContext);
    }

    public static BigDecimal valueOf(float f) {
        return BigDecimal$.MODULE$.valueOf(f);
    }

    public static BigDecimal valueOf(long l) {
        return BigDecimal$.MODULE$.valueOf(l);
    }

    public static BigDecimal valueOf(double d, MathContext mathContext) {
        return BigDecimal$.MODULE$.valueOf(d, mathContext);
    }

    public static BigDecimal valueOf(double d) {
        return BigDecimal$.MODULE$.valueOf(d);
    }

    public static BigDecimal exact(char[] cArray) {
        return BigDecimal$.MODULE$.exact(cArray);
    }

    public static BigDecimal exact(String string) {
        return BigDecimal$.MODULE$.exact(string);
    }

    public static BigDecimal exact(long l) {
        return BigDecimal$.MODULE$.exact(l);
    }

    public static BigDecimal exact(BigInt bigInt) {
        return BigDecimal$.MODULE$.exact(bigInt);
    }

    public static BigDecimal exact(double d) {
        return BigDecimal$.MODULE$.exact(d);
    }

    public static BigDecimal exact(java.math.BigDecimal bigDecimal) {
        return BigDecimal$.MODULE$.exact(bigDecimal);
    }

    public static BigDecimal binary(double d) {
        return BigDecimal$.MODULE$.binary(d);
    }

    public static BigDecimal binary(double d, MathContext mathContext) {
        return BigDecimal$.MODULE$.binary(d, mathContext);
    }

    public static BigDecimal decimal(java.math.BigDecimal bigDecimal, MathContext mathContext) {
        return BigDecimal$.MODULE$.decimal(bigDecimal, mathContext);
    }

    public static BigDecimal decimal(long l) {
        return BigDecimal$.MODULE$.decimal(l);
    }

    public static BigDecimal decimal(long l, MathContext mathContext) {
        return BigDecimal$.MODULE$.decimal(l, mathContext);
    }

    public static BigDecimal decimal(float f) {
        return BigDecimal$.MODULE$.decimal(f);
    }

    public static BigDecimal decimal(float f, MathContext mathContext) {
        return BigDecimal$.MODULE$.decimal(f, mathContext);
    }

    public static BigDecimal decimal(double d) {
        return BigDecimal$.MODULE$.decimal(d);
    }

    public static BigDecimal decimal(double d, MathContext mathContext) {
        return BigDecimal$.MODULE$.decimal(d, mathContext);
    }

    public static MathContext defaultMathContext() {
        return BigDecimal$.MODULE$.defaultMathContext();
    }

    @Override
    public boolean $less(Object that) {
        return Ordered.$less$(this, that);
    }

    @Override
    public boolean $greater(Object that) {
        return Ordered.$greater$(this, that);
    }

    @Override
    public boolean $less$eq(Object that) {
        return Ordered.$less$eq$(this, that);
    }

    @Override
    public boolean $greater$eq(Object that) {
        return Ordered.$greater$eq$(this, that);
    }

    @Override
    public int compareTo(Object that) {
        return Ordered.compareTo$(this, that);
    }

    @Override
    public char toChar() {
        return ScalaNumericAnyConversions.toChar$(this);
    }

    @Override
    public byte toByte() {
        return ScalaNumericAnyConversions.toByte$(this);
    }

    @Override
    public short toShort() {
        return ScalaNumericAnyConversions.toShort$(this);
    }

    @Override
    public int toInt() {
        return ScalaNumericAnyConversions.toInt$(this);
    }

    @Override
    public long toLong() {
        return ScalaNumericAnyConversions.toLong$(this);
    }

    @Override
    public float toFloat() {
        return ScalaNumericAnyConversions.toFloat$(this);
    }

    @Override
    public double toDouble() {
        return ScalaNumericAnyConversions.toDouble$(this);
    }

    @Override
    public int unifiedPrimitiveHashcode() {
        return ScalaNumericAnyConversions.unifiedPrimitiveHashcode$(this);
    }

    @Override
    public boolean unifiedPrimitiveEquals(Object x) {
        return ScalaNumericAnyConversions.unifiedPrimitiveEquals$(this, x);
    }

    public java.math.BigDecimal bigDecimal() {
        return this.bigDecimal;
    }

    public MathContext mc() {
        return this.mc;
    }

    private final int computedHashCode() {
        return this.computedHashCode;
    }

    private final void computedHashCode_$eq(int x$1) {
        this.computedHashCode = x$1;
    }

    private final void computeHashCode() {
        int n;
        if (this.isWhole() && this.precision() - this.scale() < 4934) {
            n = this.toBigInt().hashCode();
        } else if (this.isDecimalDouble()) {
            n = Statics.doubleHash(this.doubleValue());
        } else {
            java.math.BigDecimal temp = this.bigDecimal().stripTrailingZeros();
            n = MurmurHash3$.MODULE$.mixLast(temp.scaleByPowerOfTen(temp.scale()).toBigInteger().hashCode(), temp.scale());
        }
        this.computedHashCode_$eq(n);
    }

    public int hashCode() {
        if (this.computedHashCode() == 1565550863) {
            this.computeHashCode();
        }
        return this.computedHashCode();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object that) {
        if (that instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal)that;
            return this.equals(bigDecimal);
        }
        if (that instanceof BigInt) {
            BigInt bigInt = (BigInt)that;
            if (!((double)bigInt.bitLength() > (double)(this.precision() - this.scale() - 2) * 3.3219280948873626)) return false;
            if (!this.toBigIntExact().exists((Function1<BigInt, Object> & java.io.Serializable & Serializable)x$1 -> BoxesRunTime.boxToBoolean(bigInt.equals(x$1)))) return false;
            return true;
        }
        if (that instanceof Double) {
            double d = BoxesRunTime.unboxToDouble(that);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (RichDouble$.MODULE$.isInfinity$extension(d)) return false;
            double d2 = this.toDouble();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (RichDouble$.MODULE$.isInfinity$extension(d2)) return false;
            if (d2 != d) return false;
            if (!this.equals(BigDecimal$.MODULE$.decimal(d2))) return false;
            return true;
        }
        if (that instanceof Float) {
            float f = BoxesRunTime.unboxToFloat(that);
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (RichFloat$.MODULE$.isInfinity$extension(f)) return false;
            float f2 = this.toFloat();
            if (Predef$.MODULE$ == null) {
                throw null;
            }
            if (RichFloat$.MODULE$.isInfinity$extension(f2)) return false;
            if (f2 != f) return false;
            if (!this.equals(BigDecimal$.MODULE$.decimal((double)f2))) return false;
            return true;
        }
        if (!this.isValidLong()) return false;
        if (!this.unifiedPrimitiveEquals(that)) return false;
        return true;
    }

    @Override
    public boolean isValidByte() {
        try {
            this.toByteExact();
            return true;
        }
        catch (ArithmeticException arithmeticException) {
            return false;
        }
    }

    @Override
    public boolean isValidShort() {
        try {
            this.toShortExact();
            return true;
        }
        catch (ArithmeticException arithmeticException) {
            return false;
        }
    }

    @Override
    public boolean isValidChar() {
        return this.isValidInt() && this.toIntExact() >= 0 && this.toIntExact() <= 65535;
    }

    @Override
    public boolean isValidInt() {
        try {
            this.toIntExact();
            return true;
        }
        catch (ArithmeticException arithmeticException) {
            return false;
        }
    }

    public boolean isValidLong() {
        try {
            this.toLongExact();
            return true;
        }
        catch (ArithmeticException arithmeticException) {
            return false;
        }
    }

    public boolean isValidFloat() {
        float f = this.toFloat();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return !RichFloat$.MODULE$.isInfinity$extension(f) && this.bigDecimal().compareTo(new java.math.BigDecimal(f)) == 0;
    }

    public boolean isValidDouble() {
        double d = this.toDouble();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return !RichDouble$.MODULE$.isInfinity$extension(d) && this.bigDecimal().compareTo(new java.math.BigDecimal(d)) == 0;
    }

    public boolean isDecimalDouble() {
        double d = this.toDouble();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return !RichDouble$.MODULE$.isInfinity$extension(d) && this.equals(BigDecimal$.MODULE$.decimal(d));
    }

    public boolean isDecimalFloat() {
        float f = this.toFloat();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return !RichFloat$.MODULE$.isInfinity$extension(f) && this.equals(BigDecimal$.MODULE$.decimal(f));
    }

    public boolean isBinaryDouble() {
        double d = this.toDouble();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return !RichDouble$.MODULE$.isInfinity$extension(d) && this.equals(BigDecimal$.MODULE$.binary(d, this.mc()));
    }

    public boolean isBinaryFloat() {
        float f = this.toFloat();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return !RichFloat$.MODULE$.isInfinity$extension(f) && this.equals(BigDecimal$.MODULE$.binary(f, this.mc()));
    }

    public boolean isExactDouble() {
        double d = this.toDouble();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return !RichDouble$.MODULE$.isInfinity$extension(d) && this.equals(BigDecimal$.MODULE$.exact(d));
    }

    public boolean isExactFloat() {
        float f = this.toFloat();
        if (Predef$.MODULE$ == null) {
            throw null;
        }
        return !RichFloat$.MODULE$.isInfinity$extension(f) && this.equals(BigDecimal$.MODULE$.exact(f));
    }

    private boolean noArithmeticException(Function0<BoxedUnit> body) {
        try {
            body.apply$mcV$sp();
            return true;
        }
        catch (ArithmeticException arithmeticException) {
            return false;
        }
    }

    @Override
    public boolean isWhole() {
        return this.scale() <= 0 || this.bigDecimal().stripTrailingZeros().scale() <= 0;
    }

    @Override
    public java.math.BigDecimal underlying() {
        return this.bigDecimal();
    }

    public boolean equals(BigDecimal that) {
        return this.compare(that) == 0;
    }

    @Override
    public int compare(BigDecimal that) {
        return this.bigDecimal().compareTo(that.bigDecimal());
    }

    public BigDecimal $plus(BigDecimal that) {
        return new BigDecimal(this.bigDecimal().add(that.bigDecimal()), this.mc());
    }

    public BigDecimal $minus(BigDecimal that) {
        return new BigDecimal(this.bigDecimal().subtract(that.bigDecimal()), this.mc());
    }

    public BigDecimal $times(BigDecimal that) {
        return new BigDecimal(this.bigDecimal().multiply(that.bigDecimal(), this.mc()), this.mc());
    }

    public BigDecimal $div(BigDecimal that) {
        return new BigDecimal(this.bigDecimal().divide(that.bigDecimal(), this.mc()), this.mc());
    }

    public Tuple2<BigDecimal, BigDecimal> $div$percent(BigDecimal that) {
        java.math.BigDecimal[] bigDecimalArray = this.bigDecimal().divideAndRemainder(that.bigDecimal());
        Option option = Array$.MODULE$.unapplySeq(bigDecimalArray);
        if (option.isEmpty() || option.get() == null || ((SeqLike)option.get()).lengthCompare(2) != 0) {
            throw new MatchError(bigDecimalArray);
        }
        java.math.BigDecimal q = (java.math.BigDecimal)((SeqLike)option.get()).apply(0);
        java.math.BigDecimal r = (java.math.BigDecimal)((SeqLike)option.get()).apply(1);
        Tuple2<BigDecimal, BigDecimal> tuple2 = new Tuple2<BigDecimal, BigDecimal>(new BigDecimal(q, this.mc()), new BigDecimal(r, this.mc()));
        return tuple2;
    }

    public BigDecimal quot(BigDecimal that) {
        return new BigDecimal(this.bigDecimal().divideToIntegralValue(that.bigDecimal()), this.mc());
    }

    public BigDecimal min(BigDecimal that) {
        int n = this.compare(that);
        switch (n) {
            default: 
        }
        if (n <= 0) {
            return this;
        }
        return that;
    }

    public BigDecimal max(BigDecimal that) {
        int n = this.compare(that);
        switch (n) {
            default: 
        }
        if (n >= 0) {
            return this;
        }
        return that;
    }

    public BigDecimal remainder(BigDecimal that) {
        return new BigDecimal(this.bigDecimal().remainder(that.bigDecimal()), this.mc());
    }

    public BigDecimal $percent(BigDecimal that) {
        return this.remainder(that);
    }

    public BigDecimal pow(int n) {
        return new BigDecimal(this.bigDecimal().pow(n, this.mc()), this.mc());
    }

    public BigDecimal unary_$minus() {
        return new BigDecimal(this.bigDecimal().negate(), this.mc());
    }

    public BigDecimal abs() {
        if (this.signum() < 0) {
            return this.unary_$minus();
        }
        return this;
    }

    public int signum() {
        return this.bigDecimal().signum();
    }

    public int precision() {
        return this.bigDecimal().precision();
    }

    public BigDecimal round(MathContext mc) {
        java.math.BigDecimal r = this.bigDecimal().round(mc);
        if (r == this.bigDecimal()) {
            return this;
        }
        return new BigDecimal(r, this.mc());
    }

    public BigDecimal rounded() {
        java.math.BigDecimal r = this.bigDecimal().round(this.mc());
        if (r == this.bigDecimal()) {
            return this;
        }
        return new BigDecimal(r, this.mc());
    }

    public int scale() {
        return this.bigDecimal().scale();
    }

    public BigDecimal ulp() {
        return new BigDecimal(this.bigDecimal().ulp(), this.mc());
    }

    public BigDecimal apply(MathContext mc) {
        return new BigDecimal(this.bigDecimal().round(mc), mc);
    }

    public BigDecimal setScale(int scale) {
        if (this.scale() == scale) {
            return this;
        }
        return new BigDecimal(this.bigDecimal().setScale(scale), this.mc());
    }

    public BigDecimal setScale(int scale, Enumeration.Value mode) {
        if (this.scale() == scale) {
            return this;
        }
        return new BigDecimal(this.bigDecimal().setScale(scale, mode.id()), this.mc());
    }

    @Override
    public byte byteValue() {
        return (byte)this.intValue();
    }

    @Override
    public short shortValue() {
        return (short)this.intValue();
    }

    public char charValue() {
        return (char)this.intValue();
    }

    @Override
    public int intValue() {
        return this.bigDecimal().intValue();
    }

    @Override
    public long longValue() {
        return this.bigDecimal().longValue();
    }

    @Override
    public float floatValue() {
        return this.bigDecimal().floatValue();
    }

    @Override
    public double doubleValue() {
        return this.bigDecimal().doubleValue();
    }

    public byte toByteExact() {
        return this.bigDecimal().byteValueExact();
    }

    public short toShortExact() {
        return this.bigDecimal().shortValueExact();
    }

    public int toIntExact() {
        return this.bigDecimal().intValueExact();
    }

    public long toLongExact() {
        return this.bigDecimal().longValueExact();
    }

    public Function1<BigDecimal, NumericRange.Exclusive<BigDecimal>> until(BigDecimal end) {
        return (Function1<BigDecimal, NumericRange.Exclusive> & java.io.Serializable & Serializable)x$2 -> this.until(end, (BigDecimal)x$2);
    }

    public NumericRange.Exclusive<BigDecimal> until(BigDecimal end, BigDecimal step) {
        return Range$BigDecimal$.MODULE$.apply(this, end, step);
    }

    public Function1<BigDecimal, NumericRange.Inclusive<BigDecimal>> to(BigDecimal end) {
        return (Function1<BigDecimal, NumericRange.Inclusive> & java.io.Serializable & Serializable)x$3 -> this.to(end, (BigDecimal)x$3);
    }

    public NumericRange.Inclusive<BigDecimal> to(BigDecimal end, BigDecimal step) {
        return Range$BigDecimal$.MODULE$.inclusive(this, end, step);
    }

    public BigInt toBigInt() {
        return new BigInt(this.bigDecimal().toBigInteger());
    }

    public Option<BigInt> toBigIntExact() {
        if (this.isWhole()) {
            try {
                return new Some<BigInt>(new BigInt(this.bigDecimal().toBigIntegerExact()));
            }
            catch (ArithmeticException arithmeticException) {
                return None$.MODULE$;
            }
        }
        return None$.MODULE$;
    }

    public String toString() {
        return this.bigDecimal().toString();
    }

    public BigDecimal(java.math.BigDecimal bigDecimal, MathContext mc) {
        this.bigDecimal = bigDecimal;
        this.mc = mc;
        ScalaNumericAnyConversions.$init$(this);
        Ordered.$init$(this);
        if (bigDecimal == null) {
            throw new IllegalArgumentException("null value for BigDecimal");
        }
        if (mc == null) {
            throw new IllegalArgumentException("null MathContext for BigDecimal");
        }
        this.computedHashCode = 1565550863;
    }

    public BigDecimal(java.math.BigDecimal bigDecimal) {
        this(bigDecimal, BigDecimal$.MODULE$.defaultMathContext());
    }
}

