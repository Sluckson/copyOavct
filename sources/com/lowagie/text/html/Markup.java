package com.lowagie.text.html;

import harmony.java.awt.Color;
import java.util.Properties;
import java.util.StringTokenizer;

public class Markup {
    public static final String CSS_KEY_BGCOLOR = "background-color";
    public static final String CSS_KEY_BORDERCOLOR = "border-color";
    public static final String CSS_KEY_BORDERWIDTH = "border-width";
    public static final String CSS_KEY_BORDERWIDTHBOTTOM = "border-bottom-width";
    public static final String CSS_KEY_BORDERWIDTHLEFT = "border-left-width";
    public static final String CSS_KEY_BORDERWIDTHRIGHT = "border-right-width";
    public static final String CSS_KEY_BORDERWIDTHTOP = "border-top-width";
    public static final String CSS_KEY_COLOR = "color";
    public static final String CSS_KEY_DISPLAY = "display";
    public static final String CSS_KEY_FONTFAMILY = "font-family";
    public static final String CSS_KEY_FONTSIZE = "font-size";
    public static final String CSS_KEY_FONTSTYLE = "font-style";
    public static final String CSS_KEY_FONTWEIGHT = "font-weight";
    public static final String CSS_KEY_LINEHEIGHT = "line-height";
    public static final String CSS_KEY_MARGIN = "margin";
    public static final String CSS_KEY_MARGINBOTTOM = "margin-bottom";
    public static final String CSS_KEY_MARGINLEFT = "margin-left";
    public static final String CSS_KEY_MARGINRIGHT = "margin-right";
    public static final String CSS_KEY_MARGINTOP = "margin-top";
    public static final String CSS_KEY_PADDING = "padding";
    public static final String CSS_KEY_PADDINGBOTTOM = "padding-bottom";
    public static final String CSS_KEY_PADDINGLEFT = "padding-left";
    public static final String CSS_KEY_PADDINGRIGHT = "padding-right";
    public static final String CSS_KEY_PADDINGTOP = "padding-top";
    public static final String CSS_KEY_PAGE_BREAK_AFTER = "page-break-after";
    public static final String CSS_KEY_PAGE_BREAK_BEFORE = "page-break-before";
    public static final String CSS_KEY_TEXTALIGN = "text-align";
    public static final String CSS_KEY_TEXTDECORATION = "text-decoration";
    public static final String CSS_KEY_VERTICALALIGN = "vertical-align";
    public static final String CSS_KEY_VISIBILITY = "visibility";
    public static final String CSS_VALUE_ALWAYS = "always";
    public static final String CSS_VALUE_BLOCK = "block";
    public static final String CSS_VALUE_BOLD = "bold";
    public static final String CSS_VALUE_HIDDEN = "hidden";
    public static final String CSS_VALUE_INLINE = "inline";
    public static final String CSS_VALUE_ITALIC = "italic";
    public static final String CSS_VALUE_LINETHROUGH = "line-through";
    public static final String CSS_VALUE_LISTITEM = "list-item";
    public static final String CSS_VALUE_NONE = "none";
    public static final String CSS_VALUE_NORMAL = "normal";
    public static final String CSS_VALUE_OBLIQUE = "oblique";
    public static final String CSS_VALUE_TABLE = "table";
    public static final String CSS_VALUE_TABLECELL = "table-cell";
    public static final String CSS_VALUE_TABLEROW = "table-row";
    public static final String CSS_VALUE_TEXTALIGNCENTER = "center";
    public static final String CSS_VALUE_TEXTALIGNJUSTIFY = "justify";
    public static final String CSS_VALUE_TEXTALIGNLEFT = "left";
    public static final String CSS_VALUE_TEXTALIGNRIGHT = "right";
    public static final String CSS_VALUE_UNDERLINE = "underline";
    public static final float DEFAULT_FONT_SIZE = 12.0f;
    public static final String HTML_ATTR_CSS_CLASS = "class";
    public static final String HTML_ATTR_CSS_ID = "id";
    public static final String HTML_ATTR_HEIGHT = "height";
    public static final String HTML_ATTR_HREF = "href";
    public static final String HTML_ATTR_REL = "rel";
    public static final String HTML_ATTR_STYLE = "style";
    public static final String HTML_ATTR_STYLESHEET = "stylesheet";
    public static final String HTML_ATTR_TYPE = "type";
    public static final String HTML_ATTR_WIDTH = "width";
    public static final String HTML_TAG_BODY = "body";
    public static final String HTML_TAG_DIV = "div";
    public static final String HTML_TAG_LINK = "link";
    public static final String HTML_TAG_SPAN = "span";
    public static final String HTML_VALUE_CSS = "text/css";
    public static final String HTML_VALUE_JAVASCRIPT = "text/javascript";
    public static final String ITEXT_TAG = "tag";

    public static float parseLength(String str) {
        int length = str.length();
        boolean z = true;
        int i = 0;
        while (z && i < length) {
            switch (str.charAt(i)) {
                case '+':
                case '-':
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i++;
                    break;
                default:
                    z = false;
                    break;
            }
        }
        if (i == 0) {
            return 0.0f;
        }
        if (i == length) {
            return Float.parseFloat(String.valueOf(str) + "f");
        }
        float parseFloat = Float.parseFloat(String.valueOf(str.substring(0, i)) + "f");
        String substring = str.substring(i);
        if (substring.startsWith("in")) {
            return parseFloat * 72.0f;
        }
        if (substring.startsWith("cm")) {
            return (parseFloat / 2.54f) * 72.0f;
        }
        if (substring.startsWith("mm")) {
            return (parseFloat / 25.4f) * 72.0f;
        }
        return substring.startsWith("pc") ? parseFloat * 12.0f : parseFloat;
    }

    public static float parseLength(String str, float f) {
        if (str == null) {
            return 0.0f;
        }
        int length = str.length();
        boolean z = true;
        int i = 0;
        while (z && i < length) {
            switch (str.charAt(i)) {
                case '+':
                case '-':
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i++;
                    break;
                default:
                    z = false;
                    break;
            }
        }
        if (i == 0) {
            return 0.0f;
        }
        if (i == length) {
            return Float.parseFloat(String.valueOf(str) + "f");
        }
        float parseFloat = Float.parseFloat(String.valueOf(str.substring(0, i)) + "f");
        String substring = str.substring(i);
        if (substring.startsWith("in")) {
            return parseFloat * 72.0f;
        }
        if (substring.startsWith("cm")) {
            return (parseFloat / 2.54f) * 72.0f;
        }
        if (substring.startsWith("mm")) {
            return (parseFloat / 25.4f) * 72.0f;
        }
        if (substring.startsWith("pc")) {
            return parseFloat * 12.0f;
        }
        if (substring.startsWith(HtmlTags.f604EM)) {
            return parseFloat * f;
        }
        return substring.startsWith("ex") ? (parseFloat * f) / 2.0f : parseFloat;
    }

    public static Color decodeColor(String str) {
        if (str == null) {
            return null;
        }
        try {
            return WebColors.getRGBColor(str.toLowerCase().trim());
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static Properties parseAttributes(String str) {
        Properties properties = new Properties();
        if (str == null) {
            return properties;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), ":");
            if (stringTokenizer2.hasMoreTokens()) {
                String trim = stringTokenizer2.nextToken().trim();
                if (stringTokenizer2.hasMoreTokens()) {
                    String trim2 = stringTokenizer2.nextToken().trim();
                    if (trim2.startsWith("\"")) {
                        trim2 = trim2.substring(1);
                    }
                    if (trim2.endsWith("\"")) {
                        trim2 = trim2.substring(0, trim2.length() - 1);
                    }
                    properties.setProperty(trim.toLowerCase(), trim2);
                }
            }
        }
        return properties;
    }

    public static String removeComment(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str3.length();
        int i = 0;
        int indexOf = str.indexOf(str2, 0);
        while (indexOf > -1) {
            stringBuffer.append(str.substring(i, indexOf));
            i = str.indexOf(str3, indexOf) + length;
            indexOf = str.indexOf(str2, i);
        }
        stringBuffer.append(str.substring(i));
        return stringBuffer.toString();
    }
}
