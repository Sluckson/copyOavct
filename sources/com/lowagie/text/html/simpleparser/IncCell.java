package com.lowagie.text.html.simpleparser;

import com.lowagie.text.Element;
import com.lowagie.text.ElementListener;
import com.lowagie.text.Phrase;
import com.lowagie.text.TextElementArray;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.html.Markup;
import com.lowagie.text.pdf.PdfPCell;
import java.util.ArrayList;

public class IncCell implements TextElementArray {
    private PdfPCell cell = new PdfPCell((Phrase) null);
    private ArrayList chunks = new ArrayList();

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public boolean process(ElementListener elementListener) {
        return true;
    }

    public int type() {
        return 30;
    }

    public IncCell(String str, ChainedProperties chainedProperties) {
        String property = chainedProperties.getProperty("colspan");
        if (property != null) {
            this.cell.setColspan(Integer.parseInt(property));
        }
        String property2 = chainedProperties.getProperty("align");
        if (str.equals(HtmlTags.HEADERCELL)) {
            this.cell.setHorizontalAlignment(1);
        }
        if (property2 != null) {
            if ("center".equalsIgnoreCase(property2)) {
                this.cell.setHorizontalAlignment(1);
            } else if ("right".equalsIgnoreCase(property2)) {
                this.cell.setHorizontalAlignment(2);
            } else if ("left".equalsIgnoreCase(property2)) {
                this.cell.setHorizontalAlignment(0);
            } else if (Markup.CSS_VALUE_TEXTALIGNJUSTIFY.equalsIgnoreCase(property2)) {
                this.cell.setHorizontalAlignment(3);
            }
        }
        String property3 = chainedProperties.getProperty(HtmlTags.VERTICALALIGN);
        this.cell.setVerticalAlignment(5);
        if (property3 != null) {
            if ("top".equalsIgnoreCase(property3)) {
                this.cell.setVerticalAlignment(4);
            } else if ("bottom".equalsIgnoreCase(property3)) {
                this.cell.setVerticalAlignment(6);
            }
        }
        String property4 = chainedProperties.getProperty(HtmlTags.BORDERWIDTH);
        this.cell.setBorderWidth(property4 != null ? Float.parseFloat(property4) : 0.0f);
        String property5 = chainedProperties.getProperty("cellpadding");
        if (property5 != null) {
            this.cell.setPadding(Float.parseFloat(property5));
        }
        this.cell.setUseDescender(true);
        this.cell.setBackgroundColor(Markup.decodeColor(chainedProperties.getProperty(HtmlTags.BACKGROUNDCOLOR)));
    }

    public boolean add(Object obj) {
        if (!(obj instanceof Element)) {
            return false;
        }
        this.cell.addElement((Element) obj);
        return true;
    }

    public ArrayList getChunks() {
        return this.chunks;
    }

    public PdfPCell getCell() {
        return this.cell;
    }
}
