/*
 * Decompiled with CFR 0.152.
 */
package com.typesafe.scalalogging;

import com.typesafe.scalalogging.LoggerTakingImplicitMacro$;
import org.slf4j.Marker;
import scala.collection.Seq;
import scala.reflect.ScalaSignature;
import scala.reflect.api.Exprs;
import scala.reflect.api.Trees;
import scala.reflect.macros.blackbox.Context;

@ScalaSignature(bytes="\u0006\u0001\u00155tA\u0002\u0012$\u0011\u0003\u0019\u0013F\u0002\u0004,G!\u00051\u0005\f\u0005\u0006g\u0005!\t!N\u0003\u0005m\u0005\u0001q\u0007C\u0003V\u0003\u0011\u0005a\u000bC\u0004\u0002\u0002\u0005!\t!a\u0001\t\u000f\u0005e\u0012\u0001\"\u0001\u0002<!9\u0011QM\u0001\u0005\u0002\u0005\u001d\u0004bBAN\u0003\u0011\u0005\u0011Q\u0014\u0005\b\u0003\u0007\fA\u0011AAc\u0011\u001d\ti/\u0001C\u0001\u0003_DqA!\u0004\u0002\t\u0003\u0011y\u0001C\u0004\u00032\u0005!\tAa\r\t\u000f\t]\u0013\u0001\"\u0001\u0003Z!9!1P\u0001\u0005\u0002\tu\u0004b\u0002BR\u0003\u0011\u0005!Q\u0015\u0005\b\u0005\u001b\fA\u0011\u0001Bh\u0011\u001d\u0011i/\u0001C\u0001\u0005_Dqa!\u0005\u0002\t\u0003\u0019\u0019\u0002C\u0004\u00048\u0005!\ta!\u000f\t\u000f\rm\u0013\u0001\"\u0001\u0004^!911Q\u0001\u0005\u0002\r\u0015\u0005bBBW\u0003\u0011\u00051q\u0016\u0005\b\u0007\u001b\fA\u0011ABh\u0011\u001d\u0019\t0\u0001C\u0001\u0007gDq\u0001b\u0006\u0002\t\u0003!I\u0002C\u0004\u0005<\u0005!\t\u0001\"\u0010\t\u000f\u0011\r\u0014\u0001\"\u0001\u0005f!9AQR\u0001\u0005\u0002\u0011=\u0005b\u0002CW\u0003\u0011\u0005Aq\u0016\u0005\b\t#\fA\u0011\u0001Cj\u0011\u001d!90\u0001C\u0001\tsDq!b\u0007\u0002\t\u0003)i\u0002C\u0004\u0006D\u0005!\t!\"\u0012\u000231{wmZ3s)\u0006\\\u0017N\\4J[Bd\u0017nY5u\u001b\u0006\u001c'o\u001c\u0006\u0003I\u0015\nAb]2bY\u0006dwnZ4j]\u001eT!AJ\u0014\u0002\u0011QL\b/Z:bM\u0016T\u0011\u0001K\u0001\u0004G>l\u0007C\u0001\u0016\u0002\u001b\u0005\u0019#!\u0007'pO\u001e,'\u000fV1lS:<\u0017*\u001c9mS\u000eLG/T1de>\u001c\"!A\u0017\u0011\u00059\nT\"A\u0018\u000b\u0003A\nQa]2bY\u0006L!AM\u0018\u0003\r\u0005s\u0017PU3g\u0003\u0019a\u0014N\\5u}\r\u0001A#A\u0015\u0003\u001b1{wmZ3s\u0007>tG/\u001a=u+\tADJ\u0005\u0002:w\u0019!!(\u0001\u00019\u00051a$/\u001a4j]\u0016lWM\u001c;?!\ta4)D\u0001>\u0015\tqt(\u0001\u0005cY\u0006\u001c7NY8y\u0015\t\u0001\u0015)\u0001\u0004nC\u000e\u0014xn\u001d\u0006\u0003\u0005>\nqA]3gY\u0016\u001cG/\u0003\u0002E{\t91i\u001c8uKb$X\u0001\u0002$:A\u001d\u0013!\u0002\u0015:fM&DH+\u001f9f!\rQ\u0003JS\u0005\u0003\u0013\u000e\u0012A\u0003T8hO\u0016\u0014H+Y6j]\u001eLU\u000e\u001d7jG&$\bCA&M\u0019\u0001!Q!T\u0002C\u00029\u0013\u0011!Q\t\u0003\u001fJ\u0003\"A\f)\n\u0005E{#a\u0002(pi\"Lgn\u001a\t\u0003]MK!\u0001V\u0018\u0003\u0007\u0005s\u00170\u0001\u0007feJ|'/T3tg\u0006<W-\u0006\u0002XER\u0011\u0001,\u0018\u000b\u00033J$\"AW6\u0011\u0005m+gB\u0001/d\u001d\tYU\fC\u0003_\t\u0001\u0007q,A\u0001d!\r\u00017!Y\u0007\u0002\u0003A\u00111J\u0019\u0003\u0006\u001b\u0012\u0011\rAT\u0005\u0003I\u000e\u000b\u0001\"\u001e8jm\u0016\u00148/Z\u0005\u0003M\u001e\u0014A\u0001\u0016:fK&\u0011\u0001.\u001b\u0002\u0006)J,Wm\u001d\u0006\u0003U\u0006\u000b1!\u00199j\u0011\u0015aG\u00011\u0001n\u0003\u0005\t\u0007c\u0001/oC&\u0011q\u000e\u001d\u0002\u0005\u000bb\u0004(/\u0003\u0002r\u007f\t9\u0011\t\\5bg\u0016\u001c\b\"B:\u0005\u0001\u0004!\u0018aB7fgN\fw-\u001a\t\u00049:,\bC\u0001<~\u001d\t98\u0010\u0005\u0002y_5\t\u0011P\u0003\u0002{i\u00051AH]8pizJ!\u0001`\u0018\u0002\rA\u0013X\rZ3g\u0013\tqxP\u0001\u0004TiJLgn\u001a\u0006\u0003y>\n\u0011#\u001a:s_JlUm]:bO\u0016\u001c\u0015-^:f+\u0011\t)!a\u0006\u0015\t\u0005\u001d\u0011\u0011\u0003\u000b\u0007\u0003\u0013\ti\"!\t\u0015\t\u0005-\u0011\u0011\u0004\t\u0004\u0003\u001b)gbAA\bG:\u00191*!\u0005\t\ry+\u0001\u0019AA\n!\u0011\u00017!!\u0006\u0011\u0007-\u000b9\u0002B\u0003N\u000b\t\u0007a\n\u0003\u0004m\u000b\u0001\u0007\u00111\u0004\t\u0006\u0003\u001fq\u0017Q\u0003\u0005\u0007g\u0016\u0001\r!a\b\u0011\t\u0005=a.\u001e\u0005\b\u0003G)\u0001\u0019AA\u0013\u0003\u0015\u0019\u0017-^:f!\u0015\tyA\\A\u0014!\u0011\tI#a\r\u000f\t\u0005-\u0012q\u0006\b\u0004q\u00065\u0012\"\u0001\u0019\n\u0007\u0005Er&A\u0004qC\u000e\\\u0017mZ3\n\t\u0005U\u0012q\u0007\u0002\n)\"\u0014xn^1cY\u0016T1!!\r0\u0003A)'O]8s\u001b\u0016\u001c8/Y4f\u0003J<7/\u0006\u0003\u0002>\u0005=C\u0003BA \u0003\u0013\"b!!\u0011\u0002V\u0005eC\u0003BA\"\u0003#\u00022!!\u0012f\u001d\r\t9e\u0019\b\u0004\u0017\u0006%\u0003B\u00020\u0007\u0001\u0004\tY\u0005\u0005\u0003a\u0007\u00055\u0003cA&\u0002P\u0011)QJ\u0002b\u0001\u001d\"1AN\u0002a\u0001\u0003'\u0002R!a\u0012o\u0003\u001bBaa\u001d\u0004A\u0002\u0005]\u0003\u0003BA$]VDq!a\u0017\u0007\u0001\u0004\ti&\u0001\u0003be\u001e\u001c\b#\u0002\u0018\u0002`\u0005\r\u0014bAA1_\tQAH]3qK\u0006$X\r\u001a \u0011\t\u0005\u001dcNU\u0001\u0013KJ\u0014xN]'fgN\fw-Z'be.,'/\u0006\u0003\u0002j\u0005mD\u0003BA6\u0003k\"b!!\u001c\u0002\u0002\u0006]E\u0003BA8\u0003{\u00022!!\u001df\u001d\r\t\u0019h\u0019\b\u0004\u0017\u0006U\u0004B\u00020\b\u0001\u0004\t9\b\u0005\u0003a\u0007\u0005e\u0004cA&\u0002|\u0011)Qj\u0002b\u0001\u001d\"1An\u0002a\u0001\u0003\u007f\u0002R!a\u001do\u0003sBq!a!\b\u0001\u0004\t))\u0001\u0004nCJ\\WM\u001d\t\u0006\u0003gr\u0017q\u0011\t\u0005\u0003\u0013\u000b\u0019*\u0004\u0002\u0002\f*!\u0011QRAH\u0003\u0015\u0019HN\u001a\u001bk\u0015\t\t\t*A\u0002pe\u001eLA!!&\u0002\f\n1Q*\u0019:lKJDaa]\u0004A\u0002\u0005e\u0005\u0003BA:]V\fq#\u001a:s_JlUm]:bO\u0016\u001c\u0015-^:f\u001b\u0006\u00148.\u001a:\u0016\t\u0005}\u0015\u0011\u0017\u000b\u0005\u0003C\u000bY\u000b\u0006\u0005\u0002$\u0006]\u00161XA`)\u0011\t)+a-\u0011\u0007\u0005\u001dVMD\u0002\u0002*\u000et1aSAV\u0011\u0019q\u0006\u00021\u0001\u0002.B!\u0001mAAX!\rY\u0015\u0011\u0017\u0003\u0006\u001b\"\u0011\rA\u0014\u0005\u0007Y\"\u0001\r!!.\u0011\u000b\u0005%f.a,\t\u000f\u0005\r\u0005\u00021\u0001\u0002:B)\u0011\u0011\u00168\u0002\b\"11\u000f\u0003a\u0001\u0003{\u0003B!!+ok\"9\u00111\u0005\u0005A\u0002\u0005\u0005\u0007#BAU]\u0006\u001d\u0012AF3se>\u0014X*Z:tC\u001e,\u0017I]4t\u001b\u0006\u00148.\u001a:\u0016\t\u0005\u001d\u0017\u0011\u001c\u000b\u0005\u0003\u0013\f\u0019\u000e\u0006\u0005\u0002L\u0006}\u00171]At)\u0011\ti-a7\u0011\u0007\u0005=WMD\u0002\u0002R\u000et1aSAj\u0011\u0019q\u0016\u00021\u0001\u0002VB!\u0001mAAl!\rY\u0015\u0011\u001c\u0003\u0006\u001b&\u0011\rA\u0014\u0005\u0007Y&\u0001\r!!8\u0011\u000b\u0005Eg.a6\t\u000f\u0005\r\u0015\u00021\u0001\u0002bB)\u0011\u0011\u001b8\u0002\b\"11/\u0003a\u0001\u0003K\u0004B!!5ok\"9\u00111L\u0005A\u0002\u0005%\b#\u0002\u0018\u0002`\u0005-\b\u0003BAi]J\u000b1b^1s]6+7o]1hKV!\u0011\u0011\u001fB\u0002)\u0011\t\u00190!@\u0015\t\u0005U(\u0011\u0002\u000b\u0005\u0003o\u0014)\u0001E\u0002\u0002z\u0016t1!a?d\u001d\rY\u0015Q \u0005\u0007=*\u0001\r!a@\u0011\t\u0001\u001c!\u0011\u0001\t\u0004\u0017\n\rA!B'\u000b\u0005\u0004q\u0005B\u00027\u000b\u0001\u0004\u00119\u0001E\u0003\u0002|:\u0014\t\u0001\u0003\u0004t\u0015\u0001\u0007!1\u0002\t\u0005\u0003wtW/\u0001\txCJtW*Z:tC\u001e,7)Y;tKV!!\u0011\u0003B\u0012)\u0011\u0011\u0019B!\b\u0015\r\tU!\u0011\u0006B\u0017)\u0011\u00119B!\n\u0011\u0007\teQMD\u0002\u0003\u001c\rt1a\u0013B\u000f\u0011\u0019q6\u00021\u0001\u0003 A!\u0001m\u0001B\u0011!\rY%1\u0005\u0003\u0006\u001b.\u0011\rA\u0014\u0005\u0007Y.\u0001\rAa\n\u0011\u000b\tmaN!\t\t\rM\\\u0001\u0019\u0001B\u0016!\u0011\u0011YB\\;\t\u000f\u0005\r2\u00021\u0001\u00030A)!1\u00048\u0002(\u0005yq/\u0019:o\u001b\u0016\u001c8/Y4f\u0003J<7/\u0006\u0003\u00036\t\u001dC\u0003\u0002B\u001c\u0005\u0003\"bA!\u000f\u0003N\tEC\u0003\u0002B\u001e\u0005\u0013\u00022A!\u0010f\u001d\r\u0011yd\u0019\b\u0004\u0017\n\u0005\u0003B\u00020\r\u0001\u0004\u0011\u0019\u0005\u0005\u0003a\u0007\t\u0015\u0003cA&\u0003H\u0011)Q\n\u0004b\u0001\u001d\"1A\u000e\u0004a\u0001\u0005\u0017\u0002RAa\u0010o\u0005\u000bBaa\u001d\u0007A\u0002\t=\u0003\u0003\u0002B ]VDq!a\u0017\r\u0001\u0004\u0011\u0019\u0006E\u0003/\u0003?\u0012)\u0006\u0005\u0003\u0003@9\u0014\u0016!E<be:lUm]:bO\u0016l\u0015M]6feV!!1\fB7)\u0011\u0011iFa\u001a\u0015\r\t}#1\u000fB<)\u0011\u0011\tGa\u001c\u0011\u0007\t\rTMD\u0002\u0003f\rt1a\u0013B4\u0011\u0019qV\u00021\u0001\u0003jA!\u0001m\u0001B6!\rY%Q\u000e\u0003\u0006\u001b6\u0011\rA\u0014\u0005\u0007Y6\u0001\rA!\u001d\u0011\u000b\t\u0015dNa\u001b\t\u000f\u0005\rU\u00021\u0001\u0003vA)!Q\r8\u0002\b\"11/\u0004a\u0001\u0005s\u0002BA!\u001aok\u00061r/\u0019:o\u001b\u0016\u001c8/Y4f\u0007\u0006,8/Z'be.,'/\u0006\u0003\u0003\u0000\tEE\u0003\u0002BA\u0005\u0017#\u0002Ba!\u0003\u0018\nm%q\u0014\u000b\u0005\u0005\u000b\u0013\u0019\nE\u0002\u0003\b\u0016t1A!#d\u001d\rY%1\u0012\u0005\u0007=:\u0001\rA!$\u0011\t\u0001\u001c!q\u0012\t\u0004\u0017\nEE!B'\u000f\u0005\u0004q\u0005B\u00027\u000f\u0001\u0004\u0011)\nE\u0003\u0003\n:\u0014y\tC\u0004\u0002\u0004:\u0001\rA!'\u0011\u000b\t%e.a\"\t\rMt\u0001\u0019\u0001BO!\u0011\u0011II\\;\t\u000f\u0005\rb\u00021\u0001\u0003\"B)!\u0011\u00128\u0002(\u0005)r/\u0019:o\u001b\u0016\u001c8/Y4f\u0003J<7/T1sW\u0016\u0014X\u0003\u0002BT\u0005s#BA!+\u00034RA!1\u0016B`\u0005\u0007\u00149\r\u0006\u0003\u0003.\nm\u0006c\u0001BXK:\u0019!\u0011W2\u000f\u0007-\u0013\u0019\f\u0003\u0004_\u001f\u0001\u0007!Q\u0017\t\u0005A\u000e\u00119\fE\u0002L\u0005s#Q!T\bC\u00029Ca\u0001\\\bA\u0002\tu\u0006#\u0002BY]\n]\u0006bBAB\u001f\u0001\u0007!\u0011\u0019\t\u0006\u0005cs\u0017q\u0011\u0005\u0007g>\u0001\rA!2\u0011\t\tEf.\u001e\u0005\b\u00037z\u0001\u0019\u0001Be!\u0015q\u0013q\fBf!\u0011\u0011\tL\u001c*\u0002\u0017%tgm\\'fgN\fw-Z\u000b\u0005\u0005#\u0014\u0019\u000f\u0006\u0003\u0003T\nuG\u0003\u0002Bk\u0005S$BAa6\u0003fB\u0019!\u0011\\3\u000f\u0007\tm7MD\u0002L\u0005;DaA\u0018\tA\u0002\t}\u0007\u0003\u00021\u0004\u0005C\u00042a\u0013Br\t\u0015i\u0005C1\u0001O\u0011\u0019a\u0007\u00031\u0001\u0003hB)!1\u001c8\u0003b\"11\u000f\u0005a\u0001\u0005W\u0004BAa7ok\u0006\u0001\u0012N\u001c4p\u001b\u0016\u001c8/Y4f\u0007\u0006,8/Z\u000b\u0005\u0005c\u001c\u0019\u0001\u0006\u0003\u0003t\nuHC\u0002B{\u0007\u0013\u0019i\u0001\u0006\u0003\u0003x\u000e\u0015\u0001c\u0001B}K:\u0019!1`2\u000f\u0007-\u0013i\u0010\u0003\u0004_#\u0001\u0007!q \t\u0005A\u000e\u0019\t\u0001E\u0002L\u0007\u0007!Q!T\tC\u00029Ca\u0001\\\tA\u0002\r\u001d\u0001#\u0002B~]\u000e\u0005\u0001BB:\u0012\u0001\u0004\u0019Y\u0001\u0005\u0003\u0003|:,\bbBA\u0012#\u0001\u00071q\u0002\t\u0006\u0005wt\u0017qE\u0001\u0010S:4w.T3tg\u0006<W-\u0011:hgV!1QCB\u0014)\u0011\u00199b!\t\u0015\r\re1QFB\u0019)\u0011\u0019Yb!\u000b\u0011\u0007\ruQMD\u0002\u0004 \rt1aSB\u0011\u0011\u0019q&\u00031\u0001\u0004$A!\u0001mAB\u0013!\rY5q\u0005\u0003\u0006\u001bJ\u0011\rA\u0014\u0005\u0007YJ\u0001\raa\u000b\u0011\u000b\r}an!\n\t\rM\u0014\u0002\u0019AB\u0018!\u0011\u0019yB\\;\t\u000f\u0005m#\u00031\u0001\u00044A)a&a\u0018\u00046A!1q\u00048S\u0003EIgNZ8NKN\u001c\u0018mZ3NCJ\\WM]\u000b\u0005\u0007w\u0019i\u0005\u0006\u0003\u0004>\r\u001dCCBB \u0007'\u001a9\u0006\u0006\u0003\u0004B\r=\u0003cAB\"K:\u00191QI2\u000f\u0007-\u001b9\u0005\u0003\u0004_'\u0001\u00071\u0011\n\t\u0005A\u000e\u0019Y\u0005E\u0002L\u0007\u001b\"Q!T\nC\u00029Ca\u0001\\\nA\u0002\rE\u0003#BB#]\u000e-\u0003bBAB'\u0001\u00071Q\u000b\t\u0006\u0007\u000br\u0017q\u0011\u0005\u0007gN\u0001\ra!\u0017\u0011\t\r\u0015c.^\u0001\u0017S:4w.T3tg\u0006<WmQ1vg\u0016l\u0015M]6feV!1qLB9)\u0011\u0019\tga\u001b\u0015\u0011\r\r4qOB>\u0007\u007f\"Ba!\u001a\u0004tA\u00191qM3\u000f\u0007\r%4MD\u0002L\u0007WBaA\u0018\u000bA\u0002\r5\u0004\u0003\u00021\u0004\u0007_\u00022aSB9\t\u0015iEC1\u0001O\u0011\u0019aG\u00031\u0001\u0004vA)1\u0011\u000e8\u0004p!9\u00111\u0011\u000bA\u0002\re\u0004#BB5]\u0006\u001d\u0005BB:\u0015\u0001\u0004\u0019i\b\u0005\u0003\u0004j9,\bbBA\u0012)\u0001\u00071\u0011\u0011\t\u0006\u0007Sr\u0017qE\u0001\u0016S:4w.T3tg\u0006<W-\u0011:hg6\u000b'o[3s+\u0011\u00199i!'\u0015\t\r%51\u0013\u000b\t\u0007\u0017\u001byja)\u0004(R!1QRBN!\r\u0019y)\u001a\b\u0004\u0007#\u001bgbA&\u0004\u0014\"1a,\u0006a\u0001\u0007+\u0003B\u0001Y\u0002\u0004\u0018B\u00191j!'\u0005\u000b5+\"\u0019\u0001(\t\r1,\u0002\u0019ABO!\u0015\u0019\tJ\\BL\u0011\u001d\t\u0019)\u0006a\u0001\u0007C\u0003Ra!%o\u0003\u000fCaa]\u000bA\u0002\r\u0015\u0006\u0003BBI]VDq!a\u0017\u0016\u0001\u0004\u0019I\u000bE\u0003/\u0003?\u001aY\u000b\u0005\u0003\u0004\u0012:\u0014\u0016\u0001\u00043fEV<W*Z:tC\u001e,W\u0003BBY\u0007\u0007$Baa-\u0004>R!1QWBe)\u0011\u00199l!2\u0011\u0007\reVMD\u0002\u0004<\u000et1aSB_\u0011\u0019qf\u00031\u0001\u0004@B!\u0001mABa!\rY51\u0019\u0003\u0006\u001bZ\u0011\rA\u0014\u0005\u0007YZ\u0001\raa2\u0011\u000b\rmfn!1\t\rM4\u0002\u0019ABf!\u0011\u0019YL\\;\u0002#\u0011,'-^4NKN\u001c\u0018mZ3DCV\u001cX-\u0006\u0003\u0004R\u000e\rH\u0003BBj\u0007;$ba!6\u0004j\u000e5H\u0003BBl\u0007K\u00042a!7f\u001d\r\u0019Yn\u0019\b\u0004\u0017\u000eu\u0007B\u00020\u0018\u0001\u0004\u0019y\u000e\u0005\u0003a\u0007\r\u0005\bcA&\u0004d\u0012)Qj\u0006b\u0001\u001d\"1An\u0006a\u0001\u0007O\u0004Raa7o\u0007CDaa]\fA\u0002\r-\b\u0003BBn]VDq!a\t\u0018\u0001\u0004\u0019y\u000fE\u0003\u0004\\:\f9#\u0001\teK\n,x-T3tg\u0006<W-\u0011:hgV!1Q\u001fC\u0004)\u0011\u00199\u0010\"\u0001\u0015\r\reHQ\u0002C\t)\u0011\u0019Y\u0010\"\u0003\u0011\u0007\ruXMD\u0002\u0004\u0000\u000et1a\u0013C\u0001\u0011\u0019q\u0006\u00041\u0001\u0005\u0004A!\u0001m\u0001C\u0003!\rYEq\u0001\u0003\u0006\u001bb\u0011\rA\u0014\u0005\u0007Yb\u0001\r\u0001b\u0003\u0011\u000b\r}h\u000e\"\u0002\t\rMD\u0002\u0019\u0001C\b!\u0011\u0019yP\\;\t\u000f\u0005m\u0003\u00041\u0001\u0005\u0014A)a&a\u0018\u0005\u0016A!1q 8S\u0003I!WMY;h\u001b\u0016\u001c8/Y4f\u001b\u0006\u00148.\u001a:\u0016\t\u0011mAQ\u0006\u000b\u0005\t;!9\u0003\u0006\u0004\u0005 \u0011MBq\u0007\u000b\u0005\tC!y\u0003E\u0002\u0005$\u0015t1\u0001\"\nd\u001d\rYEq\u0005\u0005\u0007=f\u0001\r\u0001\"\u000b\u0011\t\u0001\u001cA1\u0006\t\u0004\u0017\u00125B!B'\u001a\u0005\u0004q\u0005B\u00027\u001a\u0001\u0004!\t\u0004E\u0003\u0005&9$Y\u0003C\u0004\u0002\u0004f\u0001\r\u0001\"\u000e\u0011\u000b\u0011\u0015b.a\"\t\rML\u0002\u0019\u0001C\u001d!\u0011!)C\\;\u0002/\u0011,'-^4NKN\u001c\u0018mZ3DCV\u001cX-T1sW\u0016\u0014X\u0003\u0002C \t#\"B\u0001\"\u0011\u0005LQAA1\tC,\t7\"y\u0006\u0006\u0003\u0005F\u0011M\u0003c\u0001C$K:\u0019A\u0011J2\u000f\u0007-#Y\u0005\u0003\u0004_5\u0001\u0007AQ\n\t\u0005A\u000e!y\u0005E\u0002L\t#\"Q!\u0014\u000eC\u00029Ca\u0001\u001c\u000eA\u0002\u0011U\u0003#\u0002C%]\u0012=\u0003bBAB5\u0001\u0007A\u0011\f\t\u0006\t\u0013r\u0017q\u0011\u0005\u0007gj\u0001\r\u0001\"\u0018\u0011\t\u0011%c.\u001e\u0005\b\u0003GQ\u0002\u0019\u0001C1!\u0015!IE\\A\u0014\u0003Y!WMY;h\u001b\u0016\u001c8/Y4f\u0003J<7/T1sW\u0016\u0014X\u0003\u0002C4\ts\"B\u0001\"\u001b\u0005tQAA1\u000eC@\t\u0007#9\t\u0006\u0003\u0005n\u0011m\u0004c\u0001C8K:\u0019A\u0011O2\u000f\u0007-#\u0019\b\u0003\u0004_7\u0001\u0007AQ\u000f\t\u0005A\u000e!9\bE\u0002L\ts\"Q!T\u000eC\u00029Ca\u0001\\\u000eA\u0002\u0011u\u0004#\u0002C9]\u0012]\u0004bBAB7\u0001\u0007A\u0011\u0011\t\u0006\tcr\u0017q\u0011\u0005\u0007gn\u0001\r\u0001\"\"\u0011\t\u0011Ed.\u001e\u0005\b\u00037Z\u0002\u0019\u0001CE!\u0015q\u0013q\fCF!\u0011!\tH\u001c*\u0002\u0019Q\u0014\u0018mY3NKN\u001c\u0018mZ3\u0016\t\u0011EE1\u0015\u000b\u0005\t'#i\n\u0006\u0003\u0005\u0016\u0012%F\u0003\u0002CL\tK\u00032\u0001\"'f\u001d\r!Yj\u0019\b\u0004\u0017\u0012u\u0005B\u00020\u001d\u0001\u0004!y\n\u0005\u0003a\u0007\u0011\u0005\u0006cA&\u0005$\u0012)Q\n\bb\u0001\u001d\"1A\u000e\ba\u0001\tO\u0003R\u0001b'o\tCCaa\u001d\u000fA\u0002\u0011-\u0006\u0003\u0002CN]V\f\u0011\u0003\u001e:bG\u0016lUm]:bO\u0016\u001c\u0015-^:f+\u0011!\t\fb1\u0015\t\u0011MFQ\u0018\u000b\u0007\tk#I\r\"4\u0015\t\u0011]FQ\u0019\t\u0004\ts+gb\u0001C^G:\u00191\n\"0\t\ryk\u0002\u0019\u0001C`!\u0011\u00017\u0001\"1\u0011\u0007-#\u0019\rB\u0003N;\t\u0007a\n\u0003\u0004m;\u0001\u0007Aq\u0019\t\u0006\twsG\u0011\u0019\u0005\u0007gv\u0001\r\u0001b3\u0011\t\u0011mf.\u001e\u0005\b\u0003Gi\u0002\u0019\u0001Ch!\u0015!YL\\A\u0014\u0003A!(/Y2f\u001b\u0016\u001c8/Y4f\u0003J<7/\u0006\u0003\u0005V\u0012\u001dH\u0003\u0002Cl\tC$b\u0001\"7\u0005n\u0012EH\u0003\u0002Cn\tS\u00042\u0001\"8f\u001d\r!yn\u0019\b\u0004\u0017\u0012\u0005\bB\u00020\u001f\u0001\u0004!\u0019\u000f\u0005\u0003a\u0007\u0011\u0015\bcA&\u0005h\u0012)QJ\bb\u0001\u001d\"1AN\ba\u0001\tW\u0004R\u0001b8o\tKDaa\u001d\u0010A\u0002\u0011=\b\u0003\u0002Cp]VDq!a\u0017\u001f\u0001\u0004!\u0019\u0010E\u0003/\u0003?\")\u0010\u0005\u0003\u0005`:\u0014\u0016A\u0005;sC\u000e,W*Z:tC\u001e,W*\u0019:lKJ,B\u0001b?\u0006\u000eQ!AQ`C\u0004)\u0019!y0b\u0005\u0006\u0018Q!Q\u0011AC\b!\r)\u0019!\u001a\b\u0004\u000b\u000b\u0019gbA&\u0006\b!1al\ba\u0001\u000b\u0013\u0001B\u0001Y\u0002\u0006\fA\u00191*\"\u0004\u0005\u000b5{\"\u0019\u0001(\t\r1|\u0002\u0019AC\t!\u0015))A\\C\u0006\u0011\u001d\t\u0019i\ba\u0001\u000b+\u0001R!\"\u0002o\u0003\u000fCaa]\u0010A\u0002\u0015e\u0001\u0003BC\u0003]V\fq\u0003\u001e:bG\u0016lUm]:bO\u0016\u001c\u0015-^:f\u001b\u0006\u00148.\u001a:\u0016\t\u0015}Q\u0011\u0007\u000b\u0005\u000bC)Y\u0003\u0006\u0005\u0006$\u0015]R1HC )\u0011))#b\r\u0011\u0007\u0015\u001dRMD\u0002\u0006*\rt1aSC\u0016\u0011\u0019q\u0006\u00051\u0001\u0006.A!\u0001mAC\u0018!\rYU\u0011\u0007\u0003\u0006\u001b\u0002\u0012\rA\u0014\u0005\u0007Y\u0002\u0002\r!\"\u000e\u0011\u000b\u0015%b.b\f\t\u000f\u0005\r\u0005\u00051\u0001\u0006:A)Q\u0011\u00068\u0002\b\"11\u000f\ta\u0001\u000b{\u0001B!\"\u000bok\"9\u00111\u0005\u0011A\u0002\u0015\u0005\u0003#BC\u0015]\u0006\u001d\u0012A\u0006;sC\u000e,W*Z:tC\u001e,\u0017I]4t\u001b\u0006\u00148.\u001a:\u0016\t\u0015\u001dS\u0011\f\u000b\u0005\u000b\u0013*\u0019\u0006\u0006\u0005\u0006L\u0015}S1MC4)\u0011)i%b\u0017\u0011\u0007\u0015=SMD\u0002\u0006R\rt1aSC*\u0011\u0019q\u0016\u00051\u0001\u0006VA!\u0001mAC,!\rYU\u0011\f\u0003\u0006\u001b\u0006\u0012\rA\u0014\u0005\u0007Y\u0006\u0002\r!\"\u0018\u0011\u000b\u0015Ec.b\u0016\t\u000f\u0005\r\u0015\u00051\u0001\u0006bA)Q\u0011\u000b8\u0002\b\"11/\ta\u0001\u000bK\u0002B!\"\u0015ok\"9\u00111L\u0011A\u0002\u0015%\u0004#\u0002\u0018\u0002`\u0015-\u0004\u0003BC)]J\u0003")
public final class LoggerTakingImplicitMacro {
    public static <A> Trees.TreeApi traceMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.traceMessageArgsMarker(context, expr, expr2, seq, expr3);
    }

    public static <A> Trees.TreeApi traceMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3, Exprs.Expr<A> expr4) {
        return LoggerTakingImplicitMacro$.MODULE$.traceMessageCauseMarker(context, expr, expr2, expr3, expr4);
    }

    public static <A> Trees.TreeApi traceMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.traceMessageMarker(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi traceMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.traceMessageArgs(context, expr, seq, expr2);
    }

    public static <A> Trees.TreeApi traceMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.traceMessageCause(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi traceMessage(Context context, Exprs.Expr<String> expr, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.traceMessage(context, expr, expr2);
    }

    public static <A> Trees.TreeApi debugMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.debugMessageArgsMarker(context, expr, expr2, seq, expr3);
    }

    public static <A> Trees.TreeApi debugMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3, Exprs.Expr<A> expr4) {
        return LoggerTakingImplicitMacro$.MODULE$.debugMessageCauseMarker(context, expr, expr2, expr3, expr4);
    }

    public static <A> Trees.TreeApi debugMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.debugMessageMarker(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi debugMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.debugMessageArgs(context, expr, seq, expr2);
    }

    public static <A> Trees.TreeApi debugMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.debugMessageCause(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi debugMessage(Context context, Exprs.Expr<String> expr, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.debugMessage(context, expr, expr2);
    }

    public static <A> Trees.TreeApi infoMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.infoMessageArgsMarker(context, expr, expr2, seq, expr3);
    }

    public static <A> Trees.TreeApi infoMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3, Exprs.Expr<A> expr4) {
        return LoggerTakingImplicitMacro$.MODULE$.infoMessageCauseMarker(context, expr, expr2, expr3, expr4);
    }

    public static <A> Trees.TreeApi infoMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.infoMessageMarker(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi infoMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.infoMessageArgs(context, expr, seq, expr2);
    }

    public static <A> Trees.TreeApi infoMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.infoMessageCause(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi infoMessage(Context context, Exprs.Expr<String> expr, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.infoMessage(context, expr, expr2);
    }

    public static <A> Trees.TreeApi warnMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.warnMessageArgsMarker(context, expr, expr2, seq, expr3);
    }

    public static <A> Trees.TreeApi warnMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3, Exprs.Expr<A> expr4) {
        return LoggerTakingImplicitMacro$.MODULE$.warnMessageCauseMarker(context, expr, expr2, expr3, expr4);
    }

    public static <A> Trees.TreeApi warnMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.warnMessageMarker(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi warnMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.warnMessageArgs(context, expr, seq, expr2);
    }

    public static <A> Trees.TreeApi warnMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.warnMessageCause(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi warnMessage(Context context, Exprs.Expr<String> expr, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.warnMessage(context, expr, expr2);
    }

    public static <A> Trees.TreeApi errorMessageArgsMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.errorMessageArgsMarker(context, expr, expr2, seq, expr3);
    }

    public static <A> Trees.TreeApi errorMessageCauseMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<Throwable> expr3, Exprs.Expr<A> expr4) {
        return LoggerTakingImplicitMacro$.MODULE$.errorMessageCauseMarker(context, expr, expr2, expr3, expr4);
    }

    public static <A> Trees.TreeApi errorMessageMarker(Context context, Exprs.Expr<Marker> expr, Exprs.Expr<String> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.errorMessageMarker(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi errorMessageArgs(Context context, Exprs.Expr<String> expr, Seq<Exprs.Expr<Object>> seq, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.errorMessageArgs(context, expr, seq, expr2);
    }

    public static <A> Trees.TreeApi errorMessageCause(Context context, Exprs.Expr<String> expr, Exprs.Expr<Throwable> expr2, Exprs.Expr<A> expr3) {
        return LoggerTakingImplicitMacro$.MODULE$.errorMessageCause(context, expr, expr2, expr3);
    }

    public static <A> Trees.TreeApi errorMessage(Context context, Exprs.Expr<String> expr, Exprs.Expr<A> expr2) {
        return LoggerTakingImplicitMacro$.MODULE$.errorMessage(context, expr, expr2);
    }
}

