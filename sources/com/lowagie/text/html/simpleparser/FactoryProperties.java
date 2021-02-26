package com.lowagie.text.html.simpleparser;

import com.lowagie.text.Chunk;
import com.lowagie.text.ElementTags;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.FontFactoryImp;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.html.Markup;
import com.lowagie.text.pdf.HyphenationAuto;
import com.lowagie.text.pdf.HyphenationEvent;
import harmony.java.awt.Color;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

public class FactoryProperties {
    public static HashMap followTags = new HashMap();
    private FontFactoryImp fontImp = FontFactory.getFontImp();

    public Chunk createChunk(String str, ChainedProperties chainedProperties) {
        Font font = getFont(chainedProperties);
        float size = font.getSize() / 2.0f;
        Chunk chunk = new Chunk(str, font);
        if (chainedProperties.hasProperty(HtmlTags.SUB)) {
            chunk.setTextRise(-size);
        } else if (chainedProperties.hasProperty(HtmlTags.SUP)) {
            chunk.setTextRise(size);
        }
        chunk.setHyphenation(getHyphenation(chainedProperties));
        return chunk;
    }

    private static void setParagraphLeading(Paragraph paragraph, String str) {
        if (str == null) {
            paragraph.setLeading(0.0f, 1.5f);
            return;
        }
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ,");
            float parseFloat = Float.parseFloat(stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                paragraph.setLeading(parseFloat, 0.0f);
            } else {
                paragraph.setLeading(parseFloat, Float.parseFloat(stringTokenizer.nextToken()));
            }
        } catch (Exception unused) {
            paragraph.setLeading(0.0f, 1.5f);
        }
    }

    public static void createParagraph(Paragraph paragraph, ChainedProperties chainedProperties) {
        String property = chainedProperties.getProperty("align");
        if (property != null) {
            if (property.equalsIgnoreCase("center")) {
                paragraph.setAlignment(1);
            } else if (property.equalsIgnoreCase("right")) {
                paragraph.setAlignment(2);
            } else if (property.equalsIgnoreCase(Markup.CSS_VALUE_TEXTALIGNJUSTIFY)) {
                paragraph.setAlignment(3);
            }
        }
        paragraph.setHyphenation(getHyphenation(chainedProperties));
        setParagraphLeading(paragraph, chainedProperties.getProperty(ElementTags.LEADING));
        String property2 = chainedProperties.getProperty("before");
        if (property2 != null) {
            try {
                paragraph.setSpacingBefore(Float.parseFloat(property2));
            } catch (Exception unused) {
            }
        }
        String property3 = chainedProperties.getProperty("after");
        if (property3 != null) {
            try {
                paragraph.setSpacingAfter(Float.parseFloat(property3));
            } catch (Exception unused2) {
            }
        }
        String property4 = chainedProperties.getProperty("extraparaspace");
        if (property4 != null) {
            try {
                paragraph.setExtraParagraphSpace(Float.parseFloat(property4));
            } catch (Exception unused3) {
            }
        }
    }

    public static Paragraph createParagraph(ChainedProperties chainedProperties) {
        Paragraph paragraph = new Paragraph();
        createParagraph(paragraph, chainedProperties);
        return paragraph;
    }

    public static ListItem createListItem(ChainedProperties chainedProperties) {
        ListItem listItem = new ListItem();
        createParagraph(listItem, chainedProperties);
        return listItem;
    }

    public Font getFont(ChainedProperties chainedProperties) {
        String property = chainedProperties.getProperty("face");
        int i = 0;
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                property = stringTokenizer.nextToken().trim();
                if (property.startsWith("\"")) {
                    property = property.substring(1);
                }
                if (property.endsWith("\"")) {
                    property = property.substring(0, property.length() - 1);
                }
                if (this.fontImp.isRegistered(property)) {
                    break;
                }
            }
        }
        String str = property;
        if (chainedProperties.hasProperty(HtmlTags.f606I)) {
            i = 2;
        }
        if (chainedProperties.hasProperty(HtmlTags.f603B)) {
            i |= 1;
        }
        if (chainedProperties.hasProperty(HtmlTags.f608U)) {
            i |= 4;
        }
        int i2 = chainedProperties.hasProperty(HtmlTags.f607S) ? i | 8 : i;
        String property2 = chainedProperties.getProperty(ElementTags.SIZE);
        float parseFloat = property2 != null ? Float.parseFloat(property2) : 12.0f;
        Color decodeColor = Markup.decodeColor(chainedProperties.getProperty("color"));
        String property3 = chainedProperties.getProperty(ElementTags.ENCODING);
        if (property3 == null) {
            property3 = "Cp1252";
        }
        return this.fontImp.getFont(str, property3, true, parseFloat, i2, decodeColor);
    }

    public static HyphenationEvent getHyphenation(ChainedProperties chainedProperties) {
        return getHyphenation(chainedProperties.getProperty("hyphenation"));
    }

    public static HyphenationEvent getHyphenation(HashMap hashMap) {
        return getHyphenation((String) hashMap.get("hyphenation"));
    }

    public static HyphenationEvent getHyphenation(String str) {
        int i;
        if (str == null || str.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf(95);
        int i2 = 2;
        if (indexOf == -1) {
            return new HyphenationAuto(str, (String) null, 2, 2);
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        int indexOf2 = substring2.indexOf(44);
        if (indexOf2 == -1) {
            return new HyphenationAuto(substring, substring2, 2, 2);
        }
        String substring3 = substring2.substring(indexOf2 + 1);
        String substring4 = substring2.substring(0, indexOf2);
        int indexOf3 = substring3.indexOf(44);
        if (indexOf3 == -1) {
            i = Integer.parseInt(substring3);
        } else {
            i = Integer.parseInt(substring3.substring(0, indexOf3));
            i2 = Integer.parseInt(substring3.substring(indexOf3 + 1));
        }
        return new HyphenationAuto(substring, substring4, i, i2);
    }

    public static void insertStyle(HashMap hashMap) {
        String str = (String) hashMap.get("style");
        if (str != null) {
            Properties parseAttributes = Markup.parseAttributes(str);
            for (String str2 : parseAttributes.keySet()) {
                if (str2.equals(Markup.CSS_KEY_FONTFAMILY)) {
                    hashMap.put("face", parseAttributes.getProperty(str2));
                } else if (str2.equals(Markup.CSS_KEY_FONTSIZE)) {
                    hashMap.put(ElementTags.SIZE, String.valueOf(Float.toString(Markup.parseLength(parseAttributes.getProperty(str2)))) + "pt");
                } else if (str2.equals(Markup.CSS_KEY_FONTSTYLE)) {
                    String lowerCase = parseAttributes.getProperty(str2).trim().toLowerCase();
                    if (lowerCase.equals("italic") || lowerCase.equals(Markup.CSS_VALUE_OBLIQUE)) {
                        hashMap.put(HtmlTags.f606I, (Object) null);
                    }
                } else if (str2.equals(Markup.CSS_KEY_FONTWEIGHT)) {
                    String lowerCase2 = parseAttributes.getProperty(str2).trim().toLowerCase();
                    if (lowerCase2.equals("bold") || lowerCase2.equals("700") || lowerCase2.equals("800") || lowerCase2.equals("900")) {
                        hashMap.put(HtmlTags.f603B, (Object) null);
                    }
                } else if (str2.equals(Markup.CSS_KEY_TEXTDECORATION)) {
                    if (parseAttributes.getProperty(str2).trim().toLowerCase().equals("underline")) {
                        hashMap.put(HtmlTags.f608U, (Object) null);
                    }
                } else if (str2.equals("color")) {
                    Color decodeColor = Markup.decodeColor(parseAttributes.getProperty(str2));
                    if (decodeColor != null) {
                        String str3 = "000000" + Integer.toHexString(decodeColor.getRGB());
                        hashMap.put("color", "#" + str3.substring(str3.length() - 6));
                    }
                } else if (str2.equals(Markup.CSS_KEY_LINEHEIGHT)) {
                    String trim = parseAttributes.getProperty(str2).trim();
                    float parseLength = Markup.parseLength(parseAttributes.getProperty(str2));
                    if (trim.endsWith("%")) {
                        hashMap.put(ElementTags.LEADING, "0," + (parseLength / 100.0f));
                    } else if (Markup.CSS_VALUE_NORMAL.equalsIgnoreCase(trim)) {
                        hashMap.put(ElementTags.LEADING, "0,1.5");
                    } else {
                        hashMap.put(ElementTags.LEADING, String.valueOf(parseLength) + ",0");
                    }
                } else if (str2.equals(Markup.CSS_KEY_TEXTALIGN)) {
                    hashMap.put("align", parseAttributes.getProperty(str2).trim().toLowerCase());
                }
            }
        }
    }

    public static void insertStyle(HashMap hashMap, ChainedProperties chainedProperties) {
        String str = (String) hashMap.get("style");
        if (str != null) {
            Properties parseAttributes = Markup.parseAttributes(str);
            for (String str2 : parseAttributes.keySet()) {
                if (str2.equals(Markup.CSS_KEY_FONTFAMILY)) {
                    hashMap.put("face", parseAttributes.getProperty(str2));
                } else if (str2.equals(Markup.CSS_KEY_FONTSIZE)) {
                    float parseLength = Markup.parseLength(chainedProperties.getProperty(ElementTags.SIZE), 12.0f);
                    if (parseLength <= 0.0f) {
                        parseLength = 12.0f;
                    }
                    hashMap.put(ElementTags.SIZE, String.valueOf(Float.toString(Markup.parseLength(parseAttributes.getProperty(str2), parseLength))) + "pt");
                } else if (str2.equals(Markup.CSS_KEY_FONTSTYLE)) {
                    String lowerCase = parseAttributes.getProperty(str2).trim().toLowerCase();
                    if (lowerCase.equals("italic") || lowerCase.equals(Markup.CSS_VALUE_OBLIQUE)) {
                        hashMap.put(HtmlTags.f606I, (Object) null);
                    }
                } else if (str2.equals(Markup.CSS_KEY_FONTWEIGHT)) {
                    String lowerCase2 = parseAttributes.getProperty(str2).trim().toLowerCase();
                    if (lowerCase2.equals("bold") || lowerCase2.equals("700") || lowerCase2.equals("800") || lowerCase2.equals("900")) {
                        hashMap.put(HtmlTags.f603B, (Object) null);
                    }
                } else if (str2.equals(Markup.CSS_KEY_TEXTDECORATION)) {
                    if (parseAttributes.getProperty(str2).trim().toLowerCase().equals("underline")) {
                        hashMap.put(HtmlTags.f608U, (Object) null);
                    }
                } else if (str2.equals("color")) {
                    Color decodeColor = Markup.decodeColor(parseAttributes.getProperty(str2));
                    if (decodeColor != null) {
                        String str3 = "000000" + Integer.toHexString(decodeColor.getRGB());
                        hashMap.put("color", "#" + str3.substring(str3.length() - 6));
                    }
                } else if (str2.equals(Markup.CSS_KEY_LINEHEIGHT)) {
                    String trim = parseAttributes.getProperty(str2).trim();
                    float parseLength2 = Markup.parseLength(chainedProperties.getProperty(ElementTags.SIZE), 12.0f);
                    if (parseLength2 <= 0.0f) {
                        parseLength2 = 12.0f;
                    }
                    float parseLength3 = Markup.parseLength(parseAttributes.getProperty(str2), parseLength2);
                    if (trim.endsWith("%")) {
                        hashMap.put(ElementTags.LEADING, "0," + (parseLength3 / 100.0f));
                        return;
                    } else if (Markup.CSS_VALUE_NORMAL.equalsIgnoreCase(trim)) {
                        hashMap.put(ElementTags.LEADING, "0,1.5");
                        return;
                    } else {
                        hashMap.put(ElementTags.LEADING, String.valueOf(parseLength3) + ",0");
                    }
                } else if (str2.equals(Markup.CSS_KEY_TEXTALIGN)) {
                    hashMap.put("align", parseAttributes.getProperty(str2).trim().toLowerCase());
                } else if (str2.equals(Markup.CSS_KEY_PADDINGLEFT)) {
                    hashMap.put(ElementTags.INDENT, Float.toString(Markup.parseLength(parseAttributes.getProperty(str2).trim().toLowerCase())));
                }
            }
        }
    }

    public FontFactoryImp getFontImp() {
        return this.fontImp;
    }

    public void setFontImp(FontFactoryImp fontFactoryImp) {
        this.fontImp = fontFactoryImp;
    }

    static {
        followTags.put(HtmlTags.f606I, HtmlTags.f606I);
        followTags.put(HtmlTags.f603B, HtmlTags.f603B);
        followTags.put(HtmlTags.f608U, HtmlTags.f608U);
        followTags.put(HtmlTags.SUB, HtmlTags.SUB);
        followTags.put(HtmlTags.SUP, HtmlTags.SUP);
        followTags.put(HtmlTags.f604EM, HtmlTags.f606I);
        followTags.put(HtmlTags.STRONG, HtmlTags.f603B);
        followTags.put(HtmlTags.f607S, HtmlTags.f607S);
        followTags.put("strike", HtmlTags.f607S);
    }
}
