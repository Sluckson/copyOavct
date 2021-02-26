package com.lowagie.text;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import harmony.java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleCell extends Rectangle implements PdfPCellEvent, TextElementArray {
    public static final boolean CELL = false;
    public static final boolean ROW = true;
    private boolean cellgroup = false;
    private int colspan = 1;
    private ArrayList content = new ArrayList();
    private int horizontalAlignment = -1;
    private float padding_bottom = Float.NaN;
    private float padding_left = Float.NaN;
    private float padding_right = Float.NaN;
    private float padding_top = Float.NaN;
    private float spacing_bottom = Float.NaN;
    private float spacing_left = Float.NaN;
    private float spacing_right = Float.NaN;
    private float spacing_top = Float.NaN;
    protected boolean useAscender = false;
    protected boolean useBorderPadding;
    protected boolean useDescender = false;
    private int verticalAlignment = -1;
    private float width = 0.0f;
    private float widthpercentage = 0.0f;

    public int type() {
        return 20;
    }

    public SimpleCell(boolean z) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.cellgroup = z;
        setBorder(15);
    }

    public void addElement(Element element) throws BadElementException {
        if (this.cellgroup) {
            if (!(element instanceof SimpleCell)) {
                throw new BadElementException("You can only add cells to rows, no objects of type " + element.getClass().getName());
            } else if (!((SimpleCell) element).isCellgroup()) {
                this.content.add(element);
            } else {
                throw new BadElementException("You can't add one row to another row.");
            }
        } else if (element.type() == 12 || element.type() == 11 || element.type() == 17 || element.type() == 10 || element.type() == 14 || element.type() == 50 || element.type() == 32 || element.type() == 33 || element.type() == 36 || element.type() == 34 || element.type() == 35) {
            this.content.add(element);
        } else {
            throw new BadElementException("You can't add an element of type " + element.getClass().getName() + " to a SimpleCell.");
        }
    }

    public Cell createCell(SimpleCell simpleCell) throws BadElementException {
        Cell cell = new Cell();
        cell.cloneNonPositionParameters(simpleCell);
        cell.softCloneNonPositionParameters(this);
        cell.setColspan(this.colspan);
        cell.setHorizontalAlignment(this.horizontalAlignment);
        cell.setVerticalAlignment(this.verticalAlignment);
        cell.setUseAscender(this.useAscender);
        cell.setUseBorderPadding(this.useBorderPadding);
        cell.setUseDescender(this.useDescender);
        Iterator it = this.content.iterator();
        while (it.hasNext()) {
            cell.addElement((Element) it.next());
        }
        return cell;
    }

    public PdfPCell createPdfPCell(SimpleCell simpleCell) {
        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBorder(0);
        SimpleCell simpleCell2 = new SimpleCell(false);
        simpleCell2.setSpacing_left(this.spacing_left);
        simpleCell2.setSpacing_right(this.spacing_right);
        simpleCell2.setSpacing_top(this.spacing_top);
        simpleCell2.setSpacing_bottom(this.spacing_bottom);
        simpleCell2.cloneNonPositionParameters(simpleCell);
        simpleCell2.softCloneNonPositionParameters(this);
        pdfPCell.setCellEvent(simpleCell2);
        pdfPCell.setHorizontalAlignment(simpleCell.horizontalAlignment);
        pdfPCell.setVerticalAlignment(simpleCell.verticalAlignment);
        pdfPCell.setUseAscender(simpleCell.useAscender);
        pdfPCell.setUseBorderPadding(simpleCell.useBorderPadding);
        pdfPCell.setUseDescender(simpleCell.useDescender);
        pdfPCell.setColspan(this.colspan);
        int i = this.horizontalAlignment;
        if (i != -1) {
            pdfPCell.setHorizontalAlignment(i);
        }
        int i2 = this.verticalAlignment;
        if (i2 != -1) {
            pdfPCell.setVerticalAlignment(i2);
        }
        boolean z = this.useAscender;
        if (z) {
            pdfPCell.setUseAscender(z);
        }
        boolean z2 = this.useBorderPadding;
        if (z2) {
            pdfPCell.setUseBorderPadding(z2);
        }
        boolean z3 = this.useDescender;
        if (z3) {
            pdfPCell.setUseDescender(z3);
        }
        float f = this.spacing_left;
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        float f2 = this.spacing_right;
        if (Float.isNaN(f2)) {
            f2 = 0.0f;
        }
        float f3 = this.spacing_top;
        if (Float.isNaN(f3)) {
            f3 = 0.0f;
        }
        float f4 = this.spacing_bottom;
        if (Float.isNaN(f4)) {
            f4 = 0.0f;
        }
        float f5 = this.padding_left;
        if (Float.isNaN(f5)) {
            f5 = 0.0f;
        }
        pdfPCell.setPaddingLeft(f5 + f);
        float f6 = this.padding_right;
        if (Float.isNaN(f6)) {
            f6 = 0.0f;
        }
        pdfPCell.setPaddingRight(f6 + f2);
        float f7 = this.padding_top;
        if (Float.isNaN(f7)) {
            f7 = 0.0f;
        }
        pdfPCell.setPaddingTop(f7 + f3);
        float f8 = this.padding_bottom;
        if (Float.isNaN(f8)) {
            f8 = 0.0f;
        }
        pdfPCell.setPaddingBottom(f8 + f4);
        Iterator it = this.content.iterator();
        while (it.hasNext()) {
            pdfPCell.addElement((Element) it.next());
        }
        return pdfPCell;
    }

    public void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr) {
        float f = this.spacing_left;
        float f2 = 0.0f;
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        float f3 = this.spacing_right;
        if (Float.isNaN(f3)) {
            f3 = 0.0f;
        }
        float f4 = this.spacing_top;
        if (Float.isNaN(f4)) {
            f4 = 0.0f;
        }
        float f5 = this.spacing_bottom;
        if (!Float.isNaN(f5)) {
            f2 = f5;
        }
        Rectangle rectangle2 = new Rectangle(rectangle.getLeft(f), rectangle.getBottom(f2), rectangle.getRight(f3), rectangle.getTop(f4));
        rectangle2.cloneNonPositionParameters(this);
        pdfContentByteArr[1].rectangle(rectangle2);
        rectangle2.setBackgroundColor((Color) null);
        pdfContentByteArr[2].rectangle(rectangle2);
    }

    public void setPadding(float f) {
        if (Float.isNaN(this.padding_right)) {
            setPadding_right(f);
        }
        if (Float.isNaN(this.padding_left)) {
            setPadding_left(f);
        }
        if (Float.isNaN(this.padding_top)) {
            setPadding_top(f);
        }
        if (Float.isNaN(this.padding_bottom)) {
            setPadding_bottom(f);
        }
    }

    public int getColspan() {
        return this.colspan;
    }

    public void setColspan(int i) {
        if (i > 0) {
            this.colspan = i;
        }
    }

    public float getPadding_bottom() {
        return this.padding_bottom;
    }

    public void setPadding_bottom(float f) {
        this.padding_bottom = f;
    }

    public float getPadding_left() {
        return this.padding_left;
    }

    public void setPadding_left(float f) {
        this.padding_left = f;
    }

    public float getPadding_right() {
        return this.padding_right;
    }

    public void setPadding_right(float f) {
        this.padding_right = f;
    }

    public float getPadding_top() {
        return this.padding_top;
    }

    public void setPadding_top(float f) {
        this.padding_top = f;
    }

    public float getSpacing_left() {
        return this.spacing_left;
    }

    public float getSpacing_right() {
        return this.spacing_right;
    }

    public float getSpacing_top() {
        return this.spacing_top;
    }

    public float getSpacing_bottom() {
        return this.spacing_bottom;
    }

    public void setSpacing(float f) {
        this.spacing_left = f;
        this.spacing_right = f;
        this.spacing_top = f;
        this.spacing_bottom = f;
    }

    public void setSpacing_left(float f) {
        this.spacing_left = f;
    }

    public void setSpacing_right(float f) {
        this.spacing_right = f;
    }

    public void setSpacing_top(float f) {
        this.spacing_top = f;
    }

    public void setSpacing_bottom(float f) {
        this.spacing_bottom = f;
    }

    public boolean isCellgroup() {
        return this.cellgroup;
    }

    public void setCellgroup(boolean z) {
        this.cellgroup = z;
    }

    public int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public void setHorizontalAlignment(int i) {
        this.horizontalAlignment = i;
    }

    public int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public void setVerticalAlignment(int i) {
        this.verticalAlignment = i;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float f) {
        this.width = f;
    }

    public float getWidthpercentage() {
        return this.widthpercentage;
    }

    public void setWidthpercentage(float f) {
        this.widthpercentage = f;
    }

    public boolean isUseAscender() {
        return this.useAscender;
    }

    public void setUseAscender(boolean z) {
        this.useAscender = z;
    }

    public boolean isUseBorderPadding() {
        return this.useBorderPadding;
    }

    public void setUseBorderPadding(boolean z) {
        this.useBorderPadding = z;
    }

    public boolean isUseDescender() {
        return this.useDescender;
    }

    public void setUseDescender(boolean z) {
        this.useDescender = z;
    }

    /* access modifiers changed from: package-private */
    public ArrayList getContent() {
        return this.content;
    }

    public boolean add(Object obj) {
        try {
            addElement((Element) obj);
            return true;
        } catch (ClassCastException unused) {
            return false;
        } catch (BadElementException e) {
            throw new ExceptionConverter(e);
        }
    }
}
