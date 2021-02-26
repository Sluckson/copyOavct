package com.lowagie.text.factories;

import com.lowagie.text.Anchor;
import com.lowagie.text.Annotation;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.ChapterAutoNumber;
import com.lowagie.text.Chunk;
import com.lowagie.text.ElementTags;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Section;
import com.lowagie.text.Utilities;
import com.lowagie.text.html.Markup;
import harmony.java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class ElementFactory {
    public static Chunk getChunk(Properties properties) {
        Chunk chunk = new Chunk();
        chunk.setFont(FontFactory.getFont(properties));
        String property = properties.getProperty(ElementTags.ITEXT);
        if (property != null) {
            chunk.append(property);
        }
        String property2 = properties.getProperty(ElementTags.LOCALGOTO);
        if (property2 != null) {
            chunk.setLocalGoto(property2);
        }
        String property3 = properties.getProperty(ElementTags.REMOTEGOTO);
        if (property3 != null) {
            String property4 = properties.getProperty("page");
            if (property4 != null) {
                chunk.setRemoteGoto(property3, Integer.parseInt(property4));
            } else {
                String property5 = properties.getProperty("destination");
                if (property5 != null) {
                    chunk.setRemoteGoto(property3, property5);
                }
            }
        }
        String property6 = properties.getProperty(ElementTags.LOCALDESTINATION);
        if (property6 != null) {
            chunk.setLocalDestination(property6);
        }
        String property7 = properties.getProperty(ElementTags.SUBSUPSCRIPT);
        if (property7 != null) {
            chunk.setTextRise(Float.parseFloat(String.valueOf(property7) + "f"));
        }
        String property8 = properties.getProperty(Markup.CSS_KEY_VERTICALALIGN);
        if (property8 != null && property8.endsWith("%")) {
            chunk.setTextRise((Float.parseFloat(String.valueOf(property8.substring(0, property8.length() - 1)) + "f") / 100.0f) * chunk.getFont().getSize());
        }
        String property9 = properties.getProperty(ElementTags.GENERICTAG);
        if (property9 != null) {
            chunk.setGenericTag(property9);
        }
        String property10 = properties.getProperty(ElementTags.BACKGROUNDCOLOR);
        if (property10 != null) {
            chunk.setBackground(Markup.decodeColor(property10));
        }
        return chunk;
    }

    public static Phrase getPhrase(Properties properties) {
        Phrase phrase = new Phrase();
        phrase.setFont(FontFactory.getFont(properties));
        String property = properties.getProperty(ElementTags.LEADING);
        if (property != null) {
            phrase.setLeading(Float.parseFloat(String.valueOf(property) + "f"));
        }
        String property2 = properties.getProperty(Markup.CSS_KEY_LINEHEIGHT);
        if (property2 != null) {
            phrase.setLeading(Markup.parseLength(property2, 12.0f));
        }
        String property3 = properties.getProperty(ElementTags.ITEXT);
        if (property3 != null) {
            Chunk chunk = new Chunk(property3);
            String property4 = properties.getProperty(ElementTags.GENERICTAG);
            if (property4 != null) {
                chunk.setGenericTag(property4);
            }
            phrase.add(chunk);
        }
        return phrase;
    }

    public static Anchor getAnchor(Properties properties) {
        Anchor anchor = new Anchor(getPhrase(properties));
        String property = properties.getProperty("name");
        if (property != null) {
            anchor.setName(property);
        }
        String str = (String) properties.remove(ElementTags.REFERENCE);
        if (str != null) {
            anchor.setReference(str);
        }
        return anchor;
    }

    public static Paragraph getParagraph(Properties properties) {
        Paragraph paragraph = new Paragraph(getPhrase(properties));
        String property = properties.getProperty("align");
        if (property != null) {
            paragraph.setAlignment(property);
        }
        String property2 = properties.getProperty(ElementTags.INDENTATIONLEFT);
        if (property2 != null) {
            paragraph.setIndentationLeft(Float.parseFloat(String.valueOf(property2) + "f"));
        }
        String property3 = properties.getProperty(ElementTags.INDENTATIONRIGHT);
        if (property3 != null) {
            paragraph.setIndentationRight(Float.parseFloat(String.valueOf(property3) + "f"));
        }
        return paragraph;
    }

    public static ListItem getListItem(Properties properties) {
        return new ListItem((Phrase) getParagraph(properties));
    }

    public static List getList(Properties properties) {
        List list = new List();
        list.setNumbered(Utilities.checkTrueOrFalse(properties, ElementTags.NUMBERED));
        list.setLettered(Utilities.checkTrueOrFalse(properties, ElementTags.LETTERED));
        list.setLowercase(Utilities.checkTrueOrFalse(properties, ElementTags.LOWERCASE));
        list.setAutoindent(Utilities.checkTrueOrFalse(properties, ElementTags.AUTO_INDENT_ITEMS));
        list.setAlignindent(Utilities.checkTrueOrFalse(properties, ElementTags.ALIGN_INDENTATION_ITEMS));
        String property = properties.getProperty(ElementTags.FIRST);
        if (property != null) {
            char charAt = property.charAt(0);
            if (Character.isLetter(charAt)) {
                list.setFirst(charAt);
            } else {
                list.setFirst(Integer.parseInt(property));
            }
        }
        String property2 = properties.getProperty(ElementTags.LISTSYMBOL);
        if (property2 != null) {
            list.setListSymbol(new Chunk(property2, FontFactory.getFont(properties)));
        }
        String property3 = properties.getProperty(ElementTags.INDENTATIONLEFT);
        if (property3 != null) {
            list.setIndentationLeft(Float.parseFloat(String.valueOf(property3) + "f"));
        }
        String property4 = properties.getProperty(ElementTags.INDENTATIONRIGHT);
        if (property4 != null) {
            list.setIndentationRight(Float.parseFloat(String.valueOf(property4) + "f"));
        }
        String property5 = properties.getProperty(ElementTags.SYMBOLINDENT);
        if (property5 != null) {
            list.setSymbolIndent(Float.parseFloat(property5));
        }
        return list;
    }

    public static Cell getCell(Properties properties) {
        Cell cell = new Cell();
        cell.setHorizontalAlignment(properties.getProperty(ElementTags.HORIZONTALALIGN));
        cell.setVerticalAlignment(properties.getProperty(ElementTags.VERTICALALIGN));
        String property = properties.getProperty("width");
        if (property != null) {
            cell.setWidth(property);
        }
        String property2 = properties.getProperty("colspan");
        if (property2 != null) {
            cell.setColspan(Integer.parseInt(property2));
        }
        String property3 = properties.getProperty("rowspan");
        if (property3 != null) {
            cell.setRowspan(Integer.parseInt(property3));
        }
        String property4 = properties.getProperty(ElementTags.LEADING);
        if (property4 != null) {
            cell.setLeading(Float.parseFloat(String.valueOf(property4) + "f"));
        }
        cell.setHeader(Utilities.checkTrueOrFalse(properties, "header"));
        if (Utilities.checkTrueOrFalse(properties, "nowrap")) {
            cell.setMaxLines(1);
        }
        setRectangleProperties(cell, properties);
        return cell;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x006f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.lowagie.text.Table getTable(java.util.Properties r9) {
        /*
            java.lang.String r0 = "widths"
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ BadElementException -> 0x0166 }
            r1 = 0
            r2 = 1
            java.lang.String r3 = "f"
            if (r0 == 0) goto L_0x005f
            java.util.StringTokenizer r4 = new java.util.StringTokenizer     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r5 = ";"
            r4.<init>(r0, r5)     // Catch:{ BadElementException -> 0x0166 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ BadElementException -> 0x0166 }
            r0.<init>()     // Catch:{ BadElementException -> 0x0166 }
        L_0x0018:
            boolean r5 = r4.hasMoreTokens()     // Catch:{ BadElementException -> 0x0166 }
            if (r5 != 0) goto L_0x0057
            com.lowagie.text.Table r4 = new com.lowagie.text.Table     // Catch:{ BadElementException -> 0x0166 }
            int r5 = r0.size()     // Catch:{ BadElementException -> 0x0166 }
            r4.<init>((int) r5)     // Catch:{ BadElementException -> 0x0166 }
            int r5 = r4.getColumns()     // Catch:{ BadElementException -> 0x0166 }
            float[] r5 = new float[r5]     // Catch:{ BadElementException -> 0x0166 }
            r6 = 0
        L_0x002e:
            int r7 = r0.size()     // Catch:{ BadElementException -> 0x0166 }
            if (r6 < r7) goto L_0x0038
            r4.setWidths((float[]) r5)     // Catch:{ BadElementException -> 0x0166 }
            goto L_0x0074
        L_0x0038:
            java.lang.Object r7 = r0.get(r6)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ BadElementException -> 0x0166 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ BadElementException -> 0x0166 }
            r8.<init>(r7)     // Catch:{ BadElementException -> 0x0166 }
            r8.append(r3)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r7 = r8.toString()     // Catch:{ BadElementException -> 0x0166 }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ BadElementException -> 0x0166 }
            r5[r6] = r7     // Catch:{ BadElementException -> 0x0166 }
            int r6 = r6 + 1
            goto L_0x002e
        L_0x0057:
            java.lang.String r5 = r4.nextToken()     // Catch:{ BadElementException -> 0x0166 }
            r0.add(r5)     // Catch:{ BadElementException -> 0x0166 }
            goto L_0x0018
        L_0x005f:
            java.lang.String r0 = "columns"
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ BadElementException -> 0x0166 }
            com.lowagie.text.Table r4 = new com.lowagie.text.Table     // Catch:{ Exception -> 0x006f }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x006f }
            r4.<init>((int) r0)     // Catch:{ Exception -> 0x006f }
            goto L_0x0074
        L_0x006f:
            com.lowagie.text.Table r4 = new com.lowagie.text.Table     // Catch:{ BadElementException -> 0x0166 }
            r4.<init>((int) r2)     // Catch:{ BadElementException -> 0x0166 }
        L_0x0074:
            r0 = 15
            r4.setBorder(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5 = 1065353216(0x3f800000, float:1.0)
            r4.setBorderWidth(r5)     // Catch:{ BadElementException -> 0x0166 }
            com.lowagie.text.Cell r5 = r4.getDefaultCell()     // Catch:{ BadElementException -> 0x0166 }
            r5.setBorder(r0)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = "lastHeaderRow"
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ BadElementException -> 0x0166 }
            if (r0 == 0) goto L_0x0094
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setLastHeaderRow(r0)     // Catch:{ BadElementException -> 0x0166 }
        L_0x0094:
            java.lang.String r0 = "align"
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ BadElementException -> 0x0166 }
            if (r0 == 0) goto L_0x009f
            r4.setAlignment((java.lang.String) r0)     // Catch:{ BadElementException -> 0x0166 }
        L_0x009f:
            java.lang.String r0 = "cellspacing"
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ BadElementException -> 0x0166 }
            if (r0 == 0) goto L_0x00be
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5.<init>(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5.append(r3)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = r5.toString()     // Catch:{ BadElementException -> 0x0166 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setSpacing(r0)     // Catch:{ BadElementException -> 0x0166 }
        L_0x00be:
            java.lang.String r0 = "cellpadding"
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ BadElementException -> 0x0166 }
            if (r0 == 0) goto L_0x00dd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5.<init>(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5.append(r3)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = r5.toString()     // Catch:{ BadElementException -> 0x0166 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setPadding(r0)     // Catch:{ BadElementException -> 0x0166 }
        L_0x00dd:
            java.lang.String r0 = "offset"
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ BadElementException -> 0x0166 }
            if (r0 == 0) goto L_0x00fc
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5.<init>(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5.append(r3)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = r5.toString()     // Catch:{ BadElementException -> 0x0166 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setOffset(r0)     // Catch:{ BadElementException -> 0x0166 }
        L_0x00fc:
            java.lang.String r0 = "width"
            java.lang.String r0 = r9.getProperty(r0)     // Catch:{ BadElementException -> 0x0166 }
            if (r0 == 0) goto L_0x0147
            java.lang.String r5 = "%"
            boolean r5 = r0.endsWith(r5)     // Catch:{ BadElementException -> 0x0166 }
            if (r5 == 0) goto L_0x012d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ BadElementException -> 0x0166 }
            int r6 = r0.length()     // Catch:{ BadElementException -> 0x0166 }
            int r6 = r6 - r2
            java.lang.String r0 = r0.substring(r1, r6)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5.<init>(r0)     // Catch:{ BadElementException -> 0x0166 }
            r5.append(r3)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = r5.toString()     // Catch:{ BadElementException -> 0x0166 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setWidth(r0)     // Catch:{ BadElementException -> 0x0166 }
            goto L_0x0147
        L_0x012d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ BadElementException -> 0x0166 }
            r1.<init>(r0)     // Catch:{ BadElementException -> 0x0166 }
            r1.append(r3)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = r1.toString()     // Catch:{ BadElementException -> 0x0166 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setWidth(r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setLocked(r2)     // Catch:{ BadElementException -> 0x0166 }
        L_0x0147:
            java.lang.String r0 = "tablefitspage"
            boolean r0 = com.lowagie.text.Utilities.checkTrueOrFalse(r9, r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setTableFitsPage(r0)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = "cellsfitpage"
            boolean r0 = com.lowagie.text.Utilities.checkTrueOrFalse(r9, r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setCellsFitPage(r0)     // Catch:{ BadElementException -> 0x0166 }
            java.lang.String r0 = "convert2pdfp"
            boolean r0 = com.lowagie.text.Utilities.checkTrueOrFalse(r9, r0)     // Catch:{ BadElementException -> 0x0166 }
            r4.setConvert2pdfptable(r0)     // Catch:{ BadElementException -> 0x0166 }
            setRectangleProperties(r4, r9)     // Catch:{ BadElementException -> 0x0166 }
            return r4
        L_0x0166:
            r9 = move-exception
            com.lowagie.text.ExceptionConverter r0 = new com.lowagie.text.ExceptionConverter
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.factories.ElementFactory.getTable(java.util.Properties):com.lowagie.text.Table");
    }

    private static void setRectangleProperties(Rectangle rectangle, Properties properties) {
        String property = properties.getProperty(ElementTags.BORDERWIDTH);
        if (property != null) {
            rectangle.setBorderWidth(Float.parseFloat(String.valueOf(property) + "f"));
        }
        int i = 0;
        int i2 = Utilities.checkTrueOrFalse(properties, "left") ? 4 : 0;
        if (Utilities.checkTrueOrFalse(properties, "right")) {
            i2 |= 8;
        }
        if (Utilities.checkTrueOrFalse(properties, "top")) {
            i2 |= 1;
        }
        if (Utilities.checkTrueOrFalse(properties, "bottom")) {
            i2 |= 2;
        }
        rectangle.setBorder(i2);
        String property2 = properties.getProperty(ElementTags.RED);
        String property3 = properties.getProperty(ElementTags.GREEN);
        String property4 = properties.getProperty(ElementTags.BLUE);
        if (property2 == null && property3 == null && property4 == null) {
            rectangle.setBorderColor(Markup.decodeColor(properties.getProperty("bordercolor")));
        } else {
            rectangle.setBorderColor(new Color(property2 != null ? Integer.parseInt(property2) : 0, property3 != null ? Integer.parseInt(property3) : 0, property4 != null ? Integer.parseInt(property4) : 0));
        }
        String str = (String) properties.remove(ElementTags.BGRED);
        String str2 = (String) properties.remove(ElementTags.BGGREEN);
        String str3 = (String) properties.remove(ElementTags.BGBLUE);
        String property5 = properties.getProperty(ElementTags.BACKGROUNDCOLOR);
        if (str != null || str2 != null || str3 != null) {
            int parseInt = str != null ? Integer.parseInt(str) : 0;
            int parseInt2 = str2 != null ? Integer.parseInt(str2) : 0;
            if (str3 != null) {
                i = Integer.parseInt(str3);
            }
            rectangle.setBackgroundColor(new Color(parseInt, parseInt2, i));
        } else if (property5 != null) {
            rectangle.setBackgroundColor(Markup.decodeColor(property5));
        } else {
            String property6 = properties.getProperty(ElementTags.GRAYFILL);
            if (property6 != null) {
                rectangle.setGrayFill(Float.parseFloat(String.valueOf(property6) + "f"));
            }
        }
    }

    public static ChapterAutoNumber getChapter(Properties properties) {
        ChapterAutoNumber chapterAutoNumber = new ChapterAutoNumber("");
        setSectionParameters(chapterAutoNumber, properties);
        return chapterAutoNumber;
    }

    public static Section getSection(Section section, Properties properties) {
        Section addSection = section.addSection("");
        setSectionParameters(addSection, properties);
        return addSection;
    }

    private static void setSectionParameters(Section section, Properties properties) {
        String property = properties.getProperty(ElementTags.NUMBERDEPTH);
        if (property != null) {
            section.setNumberDepth(Integer.parseInt(property));
        }
        String property2 = properties.getProperty(ElementTags.INDENT);
        if (property2 != null) {
            section.setIndentation(Float.parseFloat(String.valueOf(property2) + "f"));
        }
        String property3 = properties.getProperty(ElementTags.INDENTATIONLEFT);
        if (property3 != null) {
            section.setIndentationLeft(Float.parseFloat(String.valueOf(property3) + "f"));
        }
        String property4 = properties.getProperty(ElementTags.INDENTATIONRIGHT);
        if (property4 != null) {
            section.setIndentationRight(Float.parseFloat(String.valueOf(property4) + "f"));
        }
    }

    public static Image getImage(Properties properties) throws BadElementException, MalformedURLException, IOException {
        String property = properties.getProperty("url");
        if (property != null) {
            Image instance = Image.getInstance(property);
            String property2 = properties.getProperty("align");
            int i = 0;
            if (property2 != null && !"Left".equalsIgnoreCase(property2)) {
                if ("Right".equalsIgnoreCase(property2)) {
                    i = 2;
                } else if ("Middle".equalsIgnoreCase(property2)) {
                    i = 1;
                }
            }
            if ("true".equalsIgnoreCase(properties.getProperty(ElementTags.UNDERLYING))) {
                i |= 8;
            }
            if ("true".equalsIgnoreCase(properties.getProperty(ElementTags.TEXTWRAP))) {
                i |= 4;
            }
            instance.setAlignment(i);
            String property3 = properties.getProperty("alt");
            if (property3 != null) {
                instance.setAlt(property3);
            }
            String property4 = properties.getProperty(ElementTags.ABSOLUTEX);
            String property5 = properties.getProperty(ElementTags.ABSOLUTEY);
            if (!(property4 == null || property5 == null)) {
                float parseFloat = Float.parseFloat(String.valueOf(property4) + "f");
                instance.setAbsolutePosition(parseFloat, Float.parseFloat(String.valueOf(property5) + "f"));
            }
            String property6 = properties.getProperty(ElementTags.PLAINWIDTH);
            if (property6 != null) {
                instance.scaleAbsoluteWidth(Float.parseFloat(String.valueOf(property6) + "f"));
            }
            String property7 = properties.getProperty(ElementTags.PLAINHEIGHT);
            if (property7 != null) {
                instance.scaleAbsoluteHeight(Float.parseFloat(String.valueOf(property7) + "f"));
            }
            String property8 = properties.getProperty(ElementTags.ROTATION);
            if (property8 != null) {
                instance.setRotation(Float.parseFloat(String.valueOf(property8) + "f"));
            }
            return instance;
        }
        throw new MalformedURLException("The URL of the image is missing.");
    }

    public static Annotation getAnnotation(Properties properties) {
        float f;
        float f2;
        float f3;
        float f4;
        String property = properties.getProperty("llx");
        if (property != null) {
            f = Float.parseFloat(String.valueOf(property) + "f");
        } else {
            f = 0.0f;
        }
        String property2 = properties.getProperty("lly");
        if (property2 != null) {
            f2 = Float.parseFloat(String.valueOf(property2) + "f");
        } else {
            f2 = 0.0f;
        }
        String property3 = properties.getProperty("urx");
        if (property3 != null) {
            f3 = Float.parseFloat(String.valueOf(property3) + "f");
        } else {
            f3 = 0.0f;
        }
        String property4 = properties.getProperty("ury");
        if (property4 != null) {
            f4 = Float.parseFloat(String.valueOf(property4) + "f");
        } else {
            f4 = 0.0f;
        }
        String property5 = properties.getProperty("title");
        String property6 = properties.getProperty("content");
        if (property5 != null || property6 != null) {
            return new Annotation(property5, property6, f, f2, f3, f4);
        }
        String property7 = properties.getProperty("url");
        if (property7 != null) {
            return new Annotation(f, f2, f3, f4, property7);
        }
        String property8 = properties.getProperty("named");
        if (property8 != null) {
            return new Annotation(f, f2, f3, f4, Integer.parseInt(property8));
        }
        String property9 = properties.getProperty("file");
        String property10 = properties.getProperty("destination");
        String str = (String) properties.remove("page");
        if (property9 != null) {
            if (property10 != null) {
                return new Annotation(f, f2, f3, f4, property9, property10);
            }
            if (str != null) {
                return new Annotation(f, f2, f3, f4, property9, Integer.parseInt(str));
            }
        }
        return new Annotation("", "", f, f2, f3, f4);
    }
}
