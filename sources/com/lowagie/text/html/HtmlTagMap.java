package com.lowagie.text.html;

import com.lowagie.text.ElementTags;
import com.lowagie.text.pdf.PdfBoolean;
import java.util.HashMap;

public class HtmlTagMap extends HashMap {
    private static final long serialVersionUID = 5287430058473705350L;

    public HtmlTagMap() {
        HtmlPeer htmlPeer = new HtmlPeer(ElementTags.ITEXT, HtmlTags.HTML);
        put(htmlPeer.getAlias(), htmlPeer);
        HtmlPeer htmlPeer2 = new HtmlPeer(ElementTags.PHRASE, "span");
        put(htmlPeer2.getAlias(), htmlPeer2);
        HtmlPeer htmlPeer3 = new HtmlPeer(ElementTags.CHUNK, "font");
        htmlPeer3.addAlias("font", "face");
        htmlPeer3.addAlias(ElementTags.SIZE, HtmlTags.SIZE);
        htmlPeer3.addAlias("color", "color");
        put(htmlPeer3.getAlias(), htmlPeer3);
        HtmlPeer htmlPeer4 = new HtmlPeer(ElementTags.ANCHOR, HtmlTags.ANCHOR);
        htmlPeer4.addAlias("name", "name");
        htmlPeer4.addAlias(ElementTags.REFERENCE, "href");
        put(htmlPeer4.getAlias(), htmlPeer4);
        HtmlPeer htmlPeer5 = new HtmlPeer(ElementTags.PARAGRAPH, "p");
        htmlPeer5.addAlias("align", "align");
        put(htmlPeer5.getAlias(), htmlPeer5);
        HtmlPeer htmlPeer6 = new HtmlPeer(ElementTags.PARAGRAPH, "div");
        htmlPeer6.addAlias("align", "align");
        put(htmlPeer6.getAlias(), htmlPeer6);
        HtmlPeer htmlPeer7 = new HtmlPeer(ElementTags.PARAGRAPH, HtmlTags.f605H[0]);
        htmlPeer7.addValue(ElementTags.SIZE, "20");
        put(htmlPeer7.getAlias(), htmlPeer7);
        HtmlPeer htmlPeer8 = new HtmlPeer(ElementTags.PARAGRAPH, HtmlTags.f605H[1]);
        htmlPeer8.addValue(ElementTags.SIZE, "18");
        put(htmlPeer8.getAlias(), htmlPeer8);
        HtmlPeer htmlPeer9 = new HtmlPeer(ElementTags.PARAGRAPH, HtmlTags.f605H[2]);
        htmlPeer9.addValue(ElementTags.SIZE, "16");
        put(htmlPeer9.getAlias(), htmlPeer9);
        HtmlPeer htmlPeer10 = new HtmlPeer(ElementTags.PARAGRAPH, HtmlTags.f605H[3]);
        htmlPeer10.addValue(ElementTags.SIZE, "14");
        put(htmlPeer10.getAlias(), htmlPeer10);
        HtmlPeer htmlPeer11 = new HtmlPeer(ElementTags.PARAGRAPH, HtmlTags.f605H[4]);
        htmlPeer11.addValue(ElementTags.SIZE, "12");
        put(htmlPeer11.getAlias(), htmlPeer11);
        HtmlPeer htmlPeer12 = new HtmlPeer(ElementTags.PARAGRAPH, HtmlTags.f605H[5]);
        htmlPeer12.addValue(ElementTags.SIZE, "10");
        put(htmlPeer12.getAlias(), htmlPeer12);
        HtmlPeer htmlPeer13 = new HtmlPeer(ElementTags.LIST, HtmlTags.ORDEREDLIST);
        htmlPeer13.addValue(ElementTags.NUMBERED, "true");
        htmlPeer13.addValue(ElementTags.SYMBOLINDENT, "20");
        put(htmlPeer13.getAlias(), htmlPeer13);
        HtmlPeer htmlPeer14 = new HtmlPeer(ElementTags.LIST, HtmlTags.UNORDEREDLIST);
        htmlPeer14.addValue(ElementTags.NUMBERED, PdfBoolean.FALSE);
        htmlPeer14.addValue(ElementTags.SYMBOLINDENT, "20");
        put(htmlPeer14.getAlias(), htmlPeer14);
        HtmlPeer htmlPeer15 = new HtmlPeer(ElementTags.LISTITEM, HtmlTags.LISTITEM);
        put(htmlPeer15.getAlias(), htmlPeer15);
        HtmlPeer htmlPeer16 = new HtmlPeer(ElementTags.PHRASE, HtmlTags.f606I);
        htmlPeer16.addValue(ElementTags.STYLE, "italic");
        put(htmlPeer16.getAlias(), htmlPeer16);
        HtmlPeer htmlPeer17 = new HtmlPeer(ElementTags.PHRASE, HtmlTags.f604EM);
        htmlPeer17.addValue(ElementTags.STYLE, "italic");
        put(htmlPeer17.getAlias(), htmlPeer17);
        HtmlPeer htmlPeer18 = new HtmlPeer(ElementTags.PHRASE, HtmlTags.f603B);
        htmlPeer18.addValue(ElementTags.STYLE, "bold");
        put(htmlPeer18.getAlias(), htmlPeer18);
        HtmlPeer htmlPeer19 = new HtmlPeer(ElementTags.PHRASE, HtmlTags.STRONG);
        htmlPeer19.addValue(ElementTags.STYLE, "bold");
        put(htmlPeer19.getAlias(), htmlPeer19);
        HtmlPeer htmlPeer20 = new HtmlPeer(ElementTags.PHRASE, HtmlTags.f607S);
        htmlPeer20.addValue(ElementTags.STYLE, Markup.CSS_VALUE_LINETHROUGH);
        put(htmlPeer20.getAlias(), htmlPeer20);
        HtmlPeer htmlPeer21 = new HtmlPeer(ElementTags.PHRASE, HtmlTags.CODE);
        htmlPeer21.addValue("font", "Courier");
        put(htmlPeer21.getAlias(), htmlPeer21);
        HtmlPeer htmlPeer22 = new HtmlPeer(ElementTags.PHRASE, HtmlTags.VAR);
        htmlPeer22.addValue("font", "Courier");
        htmlPeer22.addValue(ElementTags.STYLE, "italic");
        put(htmlPeer22.getAlias(), htmlPeer22);
        HtmlPeer htmlPeer23 = new HtmlPeer(ElementTags.PHRASE, HtmlTags.f608U);
        htmlPeer23.addValue(ElementTags.STYLE, "underline");
        put(htmlPeer23.getAlias(), htmlPeer23);
        HtmlPeer htmlPeer24 = new HtmlPeer(ElementTags.CHUNK, HtmlTags.SUP);
        htmlPeer24.addValue(ElementTags.SUBSUPSCRIPT, "6.0");
        put(htmlPeer24.getAlias(), htmlPeer24);
        HtmlPeer htmlPeer25 = new HtmlPeer(ElementTags.CHUNK, HtmlTags.SUB);
        htmlPeer25.addValue(ElementTags.SUBSUPSCRIPT, "-6.0");
        put(htmlPeer25.getAlias(), htmlPeer25);
        HtmlPeer htmlPeer26 = new HtmlPeer(ElementTags.HORIZONTALRULE, HtmlTags.HORIZONTALRULE);
        put(htmlPeer26.getAlias(), htmlPeer26);
        HtmlPeer htmlPeer27 = new HtmlPeer("table", "table");
        htmlPeer27.addAlias("width", "width");
        htmlPeer27.addAlias(ElementTags.BACKGROUNDCOLOR, HtmlTags.BACKGROUNDCOLOR);
        htmlPeer27.addAlias("bordercolor", "bordercolor");
        htmlPeer27.addAlias(ElementTags.COLUMNS, HtmlTags.COLUMNS);
        htmlPeer27.addAlias("cellpadding", "cellpadding");
        htmlPeer27.addAlias("cellspacing", "cellspacing");
        htmlPeer27.addAlias(ElementTags.BORDERWIDTH, HtmlTags.BORDERWIDTH);
        htmlPeer27.addAlias("align", "align");
        put(htmlPeer27.getAlias(), htmlPeer27);
        HtmlPeer htmlPeer28 = new HtmlPeer(ElementTags.ROW, HtmlTags.ROW);
        put(htmlPeer28.getAlias(), htmlPeer28);
        HtmlPeer htmlPeer29 = new HtmlPeer(ElementTags.CELL, HtmlTags.CELL);
        htmlPeer29.addAlias("width", "width");
        htmlPeer29.addAlias(ElementTags.BACKGROUNDCOLOR, HtmlTags.BACKGROUNDCOLOR);
        htmlPeer29.addAlias("bordercolor", "bordercolor");
        htmlPeer29.addAlias("colspan", "colspan");
        htmlPeer29.addAlias("rowspan", "rowspan");
        htmlPeer29.addAlias("nowrap", "nowrap");
        htmlPeer29.addAlias(ElementTags.HORIZONTALALIGN, "align");
        htmlPeer29.addAlias(ElementTags.VERTICALALIGN, HtmlTags.VERTICALALIGN);
        htmlPeer29.addValue("header", PdfBoolean.FALSE);
        put(htmlPeer29.getAlias(), htmlPeer29);
        HtmlPeer htmlPeer30 = new HtmlPeer(ElementTags.CELL, HtmlTags.HEADERCELL);
        htmlPeer30.addAlias("width", "width");
        htmlPeer30.addAlias(ElementTags.BACKGROUNDCOLOR, HtmlTags.BACKGROUNDCOLOR);
        htmlPeer30.addAlias("bordercolor", "bordercolor");
        htmlPeer30.addAlias("colspan", "colspan");
        htmlPeer30.addAlias("rowspan", "rowspan");
        htmlPeer30.addAlias("nowrap", "nowrap");
        htmlPeer30.addAlias(ElementTags.HORIZONTALALIGN, "align");
        htmlPeer30.addAlias(ElementTags.VERTICALALIGN, HtmlTags.VERTICALALIGN);
        htmlPeer30.addValue("header", "true");
        put(htmlPeer30.getAlias(), htmlPeer30);
        HtmlPeer htmlPeer31 = new HtmlPeer("image", HtmlTags.IMAGE);
        htmlPeer31.addAlias("url", "src");
        htmlPeer31.addAlias("alt", "alt");
        htmlPeer31.addAlias(ElementTags.PLAINWIDTH, "width");
        htmlPeer31.addAlias(ElementTags.PLAINHEIGHT, "height");
        put(htmlPeer31.getAlias(), htmlPeer31);
        HtmlPeer htmlPeer32 = new HtmlPeer(ElementTags.NEWLINE, "br");
        put(htmlPeer32.getAlias(), htmlPeer32);
    }

    public static boolean isHtml(String str) {
        return HtmlTags.HTML.equalsIgnoreCase(str);
    }

    public static boolean isHead(String str) {
        return "head".equalsIgnoreCase(str);
    }

    public static boolean isMeta(String str) {
        return HtmlTags.META.equalsIgnoreCase(str);
    }

    public static boolean isLink(String str) {
        return "link".equalsIgnoreCase(str);
    }

    public static boolean isTitle(String str) {
        return "title".equalsIgnoreCase(str);
    }

    public static boolean isBody(String str) {
        return "body".equalsIgnoreCase(str);
    }

    public static boolean isSpecialTag(String str) {
        return isHtml(str) || isHead(str) || isMeta(str) || isLink(str) || isBody(str);
    }
}
