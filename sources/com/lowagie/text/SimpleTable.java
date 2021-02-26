package com.lowagie.text;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPTableEvent;
import harmony.java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleTable extends Rectangle implements PdfPTableEvent, TextElementArray {
    private int alignment;
    private float cellpadding;
    private float cellspacing;
    private ArrayList content = new ArrayList();
    private float width = 0.0f;
    private float widthpercentage = 0.0f;

    public boolean isNestable() {
        return true;
    }

    public int type() {
        return 22;
    }

    public SimpleTable() {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        setBorder(15);
        setBorderWidth(2.0f);
    }

    public void addElement(SimpleCell simpleCell) throws BadElementException {
        if (simpleCell.isCellgroup()) {
            this.content.add(simpleCell);
            return;
        }
        throw new BadElementException("You can't add cells to a table directly, add them to a row first.");
    }

    public Table createTable() throws BadElementException {
        if (!this.content.isEmpty()) {
            int i = 0;
            Iterator it = ((SimpleCell) this.content.get(0)).getContent().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += ((SimpleCell) it.next()).getColspan();
            }
            float[] fArr = new float[i2];
            float[] fArr2 = new float[i2];
            Table table = new Table(i2);
            table.setAlignment(this.alignment);
            table.setSpacing(this.cellspacing);
            table.setPadding(this.cellpadding);
            table.cloneNonPositionParameters(this);
            Iterator it2 = this.content.iterator();
            while (it2.hasNext()) {
                SimpleCell simpleCell = (SimpleCell) it2.next();
                Iterator it3 = simpleCell.getContent().iterator();
                int i3 = 0;
                while (it3.hasNext()) {
                    SimpleCell simpleCell2 = (SimpleCell) it3.next();
                    table.addCell(simpleCell2.createCell(simpleCell));
                    if (simpleCell2.getColspan() == 1) {
                        if (simpleCell2.getWidth() > 0.0f) {
                            fArr[i3] = simpleCell2.getWidth();
                        }
                        if (simpleCell2.getWidthpercentage() > 0.0f) {
                            fArr2[i3] = simpleCell2.getWidthpercentage();
                        }
                    }
                    i3 += simpleCell2.getColspan();
                }
            }
            int i4 = 0;
            float f = 0.0f;
            while (true) {
                if (i4 >= i2) {
                    break;
                } else if (fArr[i4] == 0.0f) {
                    f = 0.0f;
                    break;
                } else {
                    f += fArr[i4];
                    i4++;
                }
            }
            if (f > 0.0f) {
                table.setWidth(f);
                table.setLocked(true);
                table.setWidths(fArr);
            } else {
                while (true) {
                    if (i >= i2) {
                        break;
                    } else if (fArr2[i] == 0.0f) {
                        f = 0.0f;
                        break;
                    } else {
                        f += fArr2[i];
                        i++;
                    }
                }
                if (f > 0.0f) {
                    table.setWidths(fArr2);
                }
            }
            float f2 = this.width;
            if (f2 > 0.0f) {
                table.setWidth(f2);
                table.setLocked(true);
            } else {
                float f3 = this.widthpercentage;
                if (f3 > 0.0f) {
                    table.setWidth(f3);
                }
            }
            return table;
        }
        throw new BadElementException("Trying to create a table without rows.");
    }

    public PdfPTable createPdfPTable() throws DocumentException {
        if (!this.content.isEmpty()) {
            int i = 0;
            Iterator it = ((SimpleCell) this.content.get(0)).getContent().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += ((SimpleCell) it.next()).getColspan();
            }
            float[] fArr = new float[i2];
            float[] fArr2 = new float[i2];
            PdfPTable pdfPTable = new PdfPTable(i2);
            pdfPTable.setTableEvent(this);
            pdfPTable.setHorizontalAlignment(this.alignment);
            Iterator it2 = this.content.iterator();
            while (it2.hasNext()) {
                SimpleCell simpleCell = (SimpleCell) it2.next();
                Iterator it3 = simpleCell.getContent().iterator();
                int i3 = 0;
                while (it3.hasNext()) {
                    SimpleCell simpleCell2 = (SimpleCell) it3.next();
                    if (Float.isNaN(simpleCell2.getSpacing_left())) {
                        simpleCell2.setSpacing_left(this.cellspacing / 2.0f);
                    }
                    if (Float.isNaN(simpleCell2.getSpacing_right())) {
                        simpleCell2.setSpacing_right(this.cellspacing / 2.0f);
                    }
                    if (Float.isNaN(simpleCell2.getSpacing_top())) {
                        simpleCell2.setSpacing_top(this.cellspacing / 2.0f);
                    }
                    if (Float.isNaN(simpleCell2.getSpacing_bottom())) {
                        simpleCell2.setSpacing_bottom(this.cellspacing / 2.0f);
                    }
                    simpleCell2.setPadding(this.cellpadding);
                    pdfPTable.addCell(simpleCell2.createPdfPCell(simpleCell));
                    if (simpleCell2.getColspan() == 1) {
                        if (simpleCell2.getWidth() > 0.0f) {
                            fArr[i3] = simpleCell2.getWidth();
                        }
                        if (simpleCell2.getWidthpercentage() > 0.0f) {
                            fArr2[i3] = simpleCell2.getWidthpercentage();
                        }
                    }
                    i3 += simpleCell2.getColspan();
                }
            }
            int i4 = 0;
            float f = 0.0f;
            while (true) {
                if (i4 >= i2) {
                    break;
                } else if (fArr[i4] == 0.0f) {
                    f = 0.0f;
                    break;
                } else {
                    f += fArr[i4];
                    i4++;
                }
            }
            if (f > 0.0f) {
                pdfPTable.setTotalWidth(f);
                pdfPTable.setWidths(fArr);
            } else {
                while (true) {
                    if (i >= i2) {
                        break;
                    } else if (fArr2[i] == 0.0f) {
                        f = 0.0f;
                        break;
                    } else {
                        f += fArr2[i];
                        i++;
                    }
                }
                if (f > 0.0f) {
                    pdfPTable.setWidths(fArr2);
                }
            }
            float f2 = this.width;
            if (f2 > 0.0f) {
                pdfPTable.setTotalWidth(f2);
            }
            float f3 = this.widthpercentage;
            if (f3 > 0.0f) {
                pdfPTable.setWidthPercentage(f3);
            }
            return pdfPTable;
        }
        throw new BadElementException("Trying to create a table without rows.");
    }

    public void tableLayout(PdfPTable pdfPTable, float[][] fArr, float[] fArr2, int i, int i2, PdfContentByte[] pdfContentByteArr) {
        float[] fArr3 = fArr[0];
        Rectangle rectangle = new Rectangle(fArr3[0], fArr2[fArr2.length - 1], fArr3[fArr3.length - 1], fArr2[0]);
        rectangle.cloneNonPositionParameters(this);
        int border = rectangle.getBorder();
        rectangle.setBorder(0);
        pdfContentByteArr[1].rectangle(rectangle);
        rectangle.setBorder(border);
        rectangle.setBackgroundColor((Color) null);
        pdfContentByteArr[2].rectangle(rectangle);
    }

    public float getCellpadding() {
        return this.cellpadding;
    }

    public void setCellpadding(float f) {
        this.cellpadding = f;
    }

    public float getCellspacing() {
        return this.cellspacing;
    }

    public void setCellspacing(float f) {
        this.cellspacing = f;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        this.alignment = i;
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

    public boolean add(Object obj) {
        try {
            addElement((SimpleCell) obj);
            return true;
        } catch (ClassCastException unused) {
            return false;
        } catch (BadElementException e) {
            throw new ExceptionConverter(e);
        }
    }
}
