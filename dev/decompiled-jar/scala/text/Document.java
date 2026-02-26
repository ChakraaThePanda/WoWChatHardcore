/*
 * Decompiled with CFR 0.152.
 */
package scala.text;

import java.io.Writer;
import scala.MatchError;
import scala.Some;
import scala.Tuple3;
import scala.collection.LinearSeqOptimized;
import scala.collection.immutable.$colon$colon;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.collection.immutable.Nil$;
import scala.reflect.ScalaSignature;
import scala.runtime.BoxesRunTime;
import scala.text.DocBreak$;
import scala.text.DocCons;
import scala.text.DocGroup;
import scala.text.DocNest;
import scala.text.DocNil$;
import scala.text.DocText;
import scala.text.Document$;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@ScalaSignature(bytes="\u0006\u000194Qa\u0004\t\u0002\u0002UAQA\u0007\u0001\u0005\u0002mAQA\b\u0001\u0005\u0002}AQA\b\u0001\u0005\u0002\tBQa\f\u0001\u0005\u0002ABQa\f\u0001\u0005\u0002IBQ\u0001\u000e\u0001\u0005\u0002U:Q\u0001\u0015\t\t\u0002E3Qa\u0004\t\t\u0002ICQA\u0007\u0005\u0005\u0002MCQ\u0001\u0016\u0005\u0005\u0002UCQ!\u0017\u0005\u0005\u0002iCQ!\u0005\u0005\u0005\u0002yCQ!\u0019\u0005\u0005\u0002\tDQ!\u001a\u0005\u0005\u0002\u0019\u0014\u0001\u0002R8dk6,g\u000e\u001e\u0006\u0003#I\tA\u0001^3yi*\t1#A\u0003tG\u0006d\u0017m\u0001\u0001\u0014\u0005\u00011\u0002CA\f\u0019\u001b\u0005\u0011\u0012BA\r\u0013\u0005\u0019\te.\u001f*fM\u00061A(\u001b8jiz\"\u0012\u0001\b\t\u0003;\u0001i\u0011\u0001E\u0001\rI\r|Gn\u001c8%G>dwN\u001c\u000b\u00039\u0001BQ!\t\u0002A\u0002q\t!\u0001\u001b3\u0015\u0005q\u0019\u0003\"B\u0011\u0004\u0001\u0004!\u0003CA\u0013-\u001d\t1#\u0006\u0005\u0002(%5\t\u0001F\u0003\u0002*)\u00051AH]8pizJ!a\u000b\n\u0002\rA\u0013X\rZ3g\u0013\ticF\u0001\u0004TiJLgn\u001a\u0006\u0003WI\t\u0001\u0003J2pY>tG\u0005Z5wI\r|Gn\u001c8\u0015\u0005q\t\u0004\"B\u0011\u0005\u0001\u0004aBC\u0001\u000f4\u0011\u0015\tS\u00011\u0001%\u0003\u00191wN]7biR\u0019a'\u000f \u0011\u0005]9\u0014B\u0001\u001d\u0013\u0005\u0011)f.\u001b;\t\u000bi2\u0001\u0019A\u001e\u0002\u000b]LG\r\u001e5\u0011\u0005]a\u0014BA\u001f\u0013\u0005\rIe\u000e\u001e\u0005\u0006\u007f\u0019\u0001\r\u0001Q\u0001\u0007oJLG/\u001a:\u0011\u0005\u00053U\"\u0001\"\u000b\u0005\r#\u0015AA5p\u0015\u0005)\u0015\u0001\u00026bm\u0006L!a\u0012\"\u0003\r]\u0013\u0018\u000e^3sQ\u0011\u0001\u0011\n\u0014(\u0011\u0005]Q\u0015BA&\u0013\u0005)!W\r\u001d:fG\u0006$X\rZ\u0011\u0002\u001b\u0006QB\u000f[5tA\rd\u0017m]:!o&dG\u000e\t2fAI,Wn\u001c<fI\u0006\nq*\u0001\u00043]E\nd\u0006M\u0001\t\t>\u001cW/\\3oiB\u0011Q\u0004C\n\u0003\u0011Y!\u0012!U\u0001\u0006K6\u0004H/_\u000b\u0002-:\u0011QdV\u0005\u00031B\ta\u0001R8d\u001d&d\u0017!\u00022sK\u0006\\W#A.\u000f\u0005ua\u0016BA/\u0011\u0003!!un\u0019\"sK\u0006\\GC\u0001\u000f`\u0011\u0015\u0001G\u00021\u0001%\u0003\u0005\u0019\u0018!B4s_V\u0004HC\u0001\u000fd\u0011\u0015!W\u00021\u0001\u001d\u0003\u0005!\u0017\u0001\u00028fgR$2\u0001H4j\u0011\u0015Ag\u00021\u0001<\u0003\u0005I\u0007\"\u00023\u000f\u0001\u0004a\u0002\u0006\u0002\u0005JW:\u000b\u0013\u0001\\\u0001\u001ci\"L7\u000fI8cU\u0016\u001cG\u000fI<jY2\u0004#-\u001a\u0011sK6|g/\u001a3)\t\u001dI5N\u0014")
public abstract class Document {
    public static Document nest(int n, Document document) {
        return Document$.MODULE$.nest(n, document);
    }

    public static Document group(Document document) {
        return Document$.MODULE$.group(document);
    }

    public static Document text(String string) {
        return Document$.MODULE$.text(string);
    }

    public static DocBreak$ break() {
        return Document$.MODULE$.break();
    }

    public static DocNil$ empty() {
        return Document$.MODULE$.empty();
    }

    public Document $colon$colon(Document hd) {
        return new DocCons(hd, this);
    }

    public Document $colon$colon(String hd) {
        return new DocCons(new DocText(hd), this);
    }

    public Document $colon$div$colon(Document hd) {
        DocBreak$ docBreak$ = DocBreak$.MODULE$;
        return this.$colon$colon(docBreak$).$colon$colon(hd);
    }

    public Document $colon$div$colon(String hd) {
        DocBreak$ docBreak$ = DocBreak$.MODULE$;
        return this.$colon$colon(docBreak$).$colon$colon(hd);
    }

    public void format(int width, Writer writer) {
        Tuple3<Integer, Boolean, DocGroup> tuple3 = new Tuple3<Integer, Boolean, DocGroup>(BoxesRunTime.boxToInteger(0), BoxesRunTime.boxToBoolean(false), new DocGroup(this));
        this.fmt$1(0, Nil$.MODULE$.$colon$colon(tuple3), writer, width);
    }

    private final boolean fits$1(int w, List state) {
        boolean bl;
        block18: {
            while (true) {
                Tuple3 tuple3;
                boolean bl2 = false;
                $colon$colon $colon$colon = null;
                if (w < 0) {
                    bl = false;
                    break block18;
                }
                Some<List> some = List$.MODULE$.unapplySeq(state);
                if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
                    bl = true;
                    break block18;
                }
                if (state instanceof $colon$colon) {
                    Document document;
                    bl2 = true;
                    $colon$colon = ($colon$colon)state;
                    Tuple3 tuple32 = (Tuple3)$colon$colon.head();
                    List z = $colon$colon.tl$access$1();
                    if (tuple32 != null && DocNil$.MODULE$.equals(document = (Document)tuple32._3())) {
                        state = z;
                        continue;
                    }
                }
                if (bl2) {
                    Tuple3 tuple33 = (Tuple3)$colon$colon.head();
                    List<Tuple3<Integer, Boolean, Document>> z = $colon$colon.tl$access$1();
                    if (tuple33 != null) {
                        int i = BoxesRunTime.unboxToInt(tuple33._1());
                        boolean b = BoxesRunTime.unboxToBoolean(tuple33._2());
                        Document document = (Document)tuple33._3();
                        if (document instanceof DocCons) {
                            DocCons docCons = (DocCons)document;
                            Document h = docCons.hd();
                            Document t = docCons.tl();
                            Tuple3<Integer, Boolean, Document> tuple34 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i), BoxesRunTime.boxToBoolean(b), h);
                            Tuple3<Integer, Boolean, Document> tuple35 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i), BoxesRunTime.boxToBoolean(b), t);
                            state = z.$colon$colon(tuple35).$colon$colon(tuple34);
                            continue;
                        }
                    }
                }
                if (bl2) {
                    Document document;
                    Tuple3 tuple36 = (Tuple3)$colon$colon.head();
                    List z = $colon$colon.tl$access$1();
                    if (tuple36 != null && (document = (Document)tuple36._3()) instanceof DocText) {
                        String t = ((DocText)document).txt();
                        state = z;
                        w -= t.length();
                        continue;
                    }
                }
                if (bl2) {
                    Tuple3 tuple37 = (Tuple3)$colon$colon.head();
                    List<Tuple3<Integer, Boolean, Document>> z = $colon$colon.tl$access$1();
                    if (tuple37 != null) {
                        int i = BoxesRunTime.unboxToInt(tuple37._1());
                        boolean b = BoxesRunTime.unboxToBoolean(tuple37._2());
                        Document document = (Document)tuple37._3();
                        if (document instanceof DocNest) {
                            DocNest docNest = (DocNest)document;
                            int ii = docNest.indent();
                            Document d = docNest.doc();
                            Tuple3<Integer, Boolean, Document> tuple38 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i + ii), BoxesRunTime.boxToBoolean(b), d);
                            state = z.$colon$colon(tuple38);
                            continue;
                        }
                    }
                }
                if (bl2) {
                    Tuple3 tuple39 = (Tuple3)$colon$colon.head();
                    List z = $colon$colon.tl$access$1();
                    if (tuple39 != null) {
                        boolean bl3 = BoxesRunTime.unboxToBoolean(tuple39._2());
                        Document document = (Document)tuple39._3();
                        if (!bl3 && DocBreak$.MODULE$.equals(document)) {
                            state = z;
                            --w;
                            continue;
                        }
                    }
                }
                if (bl2 && (tuple3 = (Tuple3)$colon$colon.head()) != null) {
                    boolean bl4 = BoxesRunTime.unboxToBoolean(tuple3._2());
                    Document document = (Document)tuple3._3();
                    if (bl4 && DocBreak$.MODULE$.equals(document)) {
                        bl = true;
                        break block18;
                    }
                }
                if (!bl2) break;
                Tuple3 tuple310 = (Tuple3)$colon$colon.head();
                List<Tuple3<Integer, Boolean, Document>> z = $colon$colon.tl$access$1();
                if (tuple310 == null) break;
                int i = BoxesRunTime.unboxToInt(tuple310._1());
                Document document = (Document)tuple310._3();
                if (!(document instanceof DocGroup)) break;
                Document d = ((DocGroup)document).doc();
                Tuple3<Integer, Boolean, Document> tuple311 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i), BoxesRunTime.boxToBoolean(false), d);
                state = z.$colon$colon(tuple311);
            }
            throw new MatchError(state);
        }
        return bl;
    }

    private static final void spaces$1(int n, Writer writer$1) {
        int rem;
        for (rem = n; rem >= 16; rem -= 16) {
            writer$1.write("                ");
        }
        if (rem >= 8) {
            writer$1.write("        ");
            rem -= 8;
        }
        if (rem >= 4) {
            writer$1.write("    ");
            rem -= 4;
        }
        if (rem >= 2) {
            writer$1.write("  ");
            rem -= 2;
        }
        if (rem == 1) {
            writer$1.write(" ");
        }
    }

    private final void fmt$1(int k, List state, Writer writer$1, int width$1) {
        while (true) {
            boolean bl = false;
            $colon$colon $colon$colon = null;
            Some<List> some = List$.MODULE$.unapplySeq(state);
            if (!some.isEmpty() && some.get() != null && ((LinearSeqOptimized)some.get()).lengthCompare(0) == 0) {
                return;
            }
            if (state instanceof $colon$colon) {
                Document document;
                bl = true;
                $colon$colon = ($colon$colon)state;
                Tuple3 tuple3 = (Tuple3)$colon$colon.head();
                List z = $colon$colon.tl$access$1();
                if (tuple3 != null && DocNil$.MODULE$.equals(document = (Document)tuple3._3())) {
                    state = z;
                    continue;
                }
            }
            if (bl) {
                Tuple3 tuple3 = (Tuple3)$colon$colon.head();
                List<Tuple3<Integer, Boolean, Document>> z = $colon$colon.tl$access$1();
                if (tuple3 != null) {
                    int i = BoxesRunTime.unboxToInt(tuple3._1());
                    boolean b = BoxesRunTime.unboxToBoolean(tuple3._2());
                    Document document = (Document)tuple3._3();
                    if (document instanceof DocCons) {
                        DocCons docCons = (DocCons)document;
                        Document h = docCons.hd();
                        Document t = docCons.tl();
                        Tuple3<Integer, Boolean, Document> tuple32 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i), BoxesRunTime.boxToBoolean(b), h);
                        Tuple3<Integer, Boolean, Document> tuple33 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i), BoxesRunTime.boxToBoolean(b), t);
                        state = z.$colon$colon(tuple33).$colon$colon(tuple32);
                        continue;
                    }
                }
            }
            if (bl) {
                Document document;
                Tuple3 tuple3 = (Tuple3)$colon$colon.head();
                List z = $colon$colon.tl$access$1();
                if (tuple3 != null && (document = (Document)tuple3._3()) instanceof DocText) {
                    String t = ((DocText)document).txt();
                    writer$1.write(t);
                    state = z;
                    k += t.length();
                    continue;
                }
            }
            if (bl) {
                Tuple3 tuple3 = (Tuple3)$colon$colon.head();
                List<Tuple3<Integer, Boolean, Document>> z = $colon$colon.tl$access$1();
                if (tuple3 != null) {
                    int i = BoxesRunTime.unboxToInt(tuple3._1());
                    boolean b = BoxesRunTime.unboxToBoolean(tuple3._2());
                    Document document = (Document)tuple3._3();
                    if (document instanceof DocNest) {
                        DocNest docNest = (DocNest)document;
                        int ii = docNest.indent();
                        Document d = docNest.doc();
                        Tuple3<Integer, Boolean, Document> tuple34 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i + ii), BoxesRunTime.boxToBoolean(b), d);
                        state = z.$colon$colon(tuple34);
                        continue;
                    }
                }
            }
            if (bl) {
                Tuple3 tuple3 = (Tuple3)$colon$colon.head();
                List z = $colon$colon.tl$access$1();
                if (tuple3 != null) {
                    int i = BoxesRunTime.unboxToInt(tuple3._1());
                    boolean bl2 = BoxesRunTime.unboxToBoolean(tuple3._2());
                    Document document = (Document)tuple3._3();
                    if (bl2 && DocBreak$.MODULE$.equals(document)) {
                        writer$1.write("\n");
                        Document.spaces$1(i, writer$1);
                        state = z;
                        k = i;
                        continue;
                    }
                }
            }
            if (bl) {
                Tuple3 tuple3 = (Tuple3)$colon$colon.head();
                List z = $colon$colon.tl$access$1();
                if (tuple3 != null) {
                    boolean bl3 = BoxesRunTime.unboxToBoolean(tuple3._2());
                    Document document = (Document)tuple3._3();
                    if (!bl3 && DocBreak$.MODULE$.equals(document)) {
                        writer$1.write(" ");
                        state = z;
                        ++k;
                        continue;
                    }
                }
            }
            if (!bl) break;
            Tuple3 tuple3 = (Tuple3)$colon$colon.head();
            List<Tuple3<Integer, Boolean, Document>> z = $colon$colon.tl$access$1();
            if (tuple3 == null) break;
            int i = BoxesRunTime.unboxToInt(tuple3._1());
            Document document = (Document)tuple3._3();
            if (!(document instanceof DocGroup)) break;
            Document d = ((DocGroup)document).doc();
            Tuple3<Integer, Boolean, Document> tuple35 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i), BoxesRunTime.boxToBoolean(false), d);
            boolean fitsFlat = this.fits$1(width$1 - k, z.$colon$colon(tuple35));
            Tuple3<Integer, Boolean, Document> tuple36 = new Tuple3<Integer, Boolean, Document>(BoxesRunTime.boxToInteger(i), BoxesRunTime.boxToBoolean(!fitsFlat), d);
            state = z.$colon$colon(tuple36);
        }
    }
}

