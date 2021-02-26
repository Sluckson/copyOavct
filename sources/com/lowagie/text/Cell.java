package com.lowagie.text;

import com.lowagie.text.pdf.PdfPCell;
import java.util.ArrayList;
import java.util.Iterator;

public class Cell extends Rectangle implements TextElementArray {
    protected ArrayList arrayList;
    protected int colspan;
    protected boolean groupChange;
    protected boolean header;
    protected int horizontalAlignment;
    float leading;
    protected int maxLines;
    protected boolean percentage;
    protected int rowspan;
    String showTruncation;
    protected boolean useAscender;
    protected boolean useBorderPadding;
    protected boolean useDescender;
    protected int verticalAlignment;
    protected float width;

    public int type() {
        return 20;
    }

    public Cell() {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.arrayList = null;
        this.horizontalAlignment = -1;
        this.verticalAlignment = -1;
        this.percentage = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.leading = Float.NaN;
        this.maxLines = Integer.MAX_VALUE;
        this.useAscender = false;
        this.useDescender = false;
        this.groupChange = true;
        setBorder(-1);
        setBorderWidth(0.5f);
        this.arrayList = new ArrayList();
    }

    public Cell(boolean z) {
        this();
        this.arrayList.add(new Paragraph(0.0f));
    }

    public Cell(String str) {
        this();
        try {
            addElement(new Paragraph(str));
        } catch (BadElementException unused) {
        }
    }

    public Cell(Element element) throws BadElementException {
        this();
        if (element instanceof Phrase) {
            setLeading(((Phrase) element).getLeading());
        }
        addElement(element);
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public ArrayList getChunks() {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll(((Element) it.next()).getChunks());
        }
        return arrayList2;
    }

    public int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public void setHorizontalAlignment(int i) {
        this.horizontalAlignment = i;
    }

    public void setHorizontalAlignment(String str) {
        setHorizontalAlignment(ElementTags.alignmentValue(str));
    }

    public int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public void setVerticalAlignment(int i) {
        this.verticalAlignment = i;
    }

    public void setVerticalAlignment(String str) {
        setVerticalAlignment(ElementTags.alignmentValue(str));
    }

    public void setWidth(float f) {
        this.width = f;
    }

    public void setWidth(String str) {
        if (str.endsWith("%")) {
            str = str.substring(0, str.length() - 1);
            this.percentage = true;
        }
        this.width = (float) Integer.parseInt(str);
    }

    public float getWidth() {
        return this.width;
    }

    public String getWidthAsString() {
        String valueOf = String.valueOf(this.width);
        if (valueOf.endsWith(".0")) {
            valueOf = valueOf.substring(0, valueOf.length() - 2);
        }
        if (!this.percentage) {
            return valueOf;
        }
        return String.valueOf(valueOf) + "%";
    }

    public void setColspan(int i) {
        this.colspan = i;
    }

    public int getColspan() {
        return this.colspan;
    }

    public void setRowspan(int i) {
        this.rowspan = i;
    }

    public int getRowspan() {
        return this.rowspan;
    }

    public void setLeading(float f) {
        this.leading = f;
    }

    public float getLeading() {
        if (Float.isNaN(this.leading)) {
            return 16.0f;
        }
        return this.leading;
    }

    public void setHeader(boolean z) {
        this.header = z;
    }

    public boolean isHeader() {
        return this.header;
    }

    public void setMaxLines(int i) {
        this.maxLines = i;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setShowTruncation(String str) {
        this.showTruncation = str;
    }

    public String getShowTruncation() {
        return this.showTruncation;
    }

    public void setUseAscender(boolean z) {
        this.useAscender = z;
    }

    public boolean isUseAscender() {
        return this.useAscender;
    }

    public void setUseDescender(boolean z) {
        this.useDescender = z;
    }

    public boolean isUseDescender() {
        return this.useDescender;
    }

    public void setUseBorderPadding(boolean z) {
        this.useBorderPadding = z;
    }

    public boolean isUseBorderPadding() {
        return this.useBorderPadding;
    }

    public boolean getGroupChange() {
        return this.groupChange;
    }

    public void setGroupChange(boolean z) {
        this.groupChange = z;
    }

    public int size() {
        return this.arrayList.size();
    }

    public Iterator getElements() {
        return this.arrayList.iterator();
    }

    public void clear() {
        this.arrayList.clear();
    }

    public boolean isEmpty() {
        int size = size();
        if (size == 0) {
            return true;
        }
        if (size != 1) {
            return false;
        }
        Element element = (Element) this.arrayList.get(0);
        int type = element.type();
        if (type == 14) {
            return ((List) element).isEmpty();
        }
        if (type != 17) {
            switch (type) {
                case 10:
                    return ((Chunk) element).isEmpty();
                case 11:
                case 12:
                    break;
                default:
                    return false;
            }
        }
        return ((Phrase) element).isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void fill() {
        if (size() == 0) {
            this.arrayList.add(new Paragraph(0.0f));
        }
    }

    public boolean isTable() {
        return size() == 1 && ((Element) this.arrayList.get(0)).type() == 22;
    }

    public void addElement(Element element) throws BadElementException {
        if (isTable()) {
            Table table = (Table) this.arrayList.get(0);
            Cell cell = new Cell(element);
            cell.setBorder(0);
            cell.setColspan(table.getColumns());
            table.addCell(cell);
            return;
        }
        switch (element.type()) {
            case 10:
                if (!((Chunk) element).isEmpty()) {
                    this.arrayList.add(element);
                    return;
                }
                return;
            case 11:
            case 12:
            case 17:
                Phrase phrase = (Phrase) element;
                if (Float.isNaN(this.leading)) {
                    setLeading(phrase.getLeading());
                }
                if (!phrase.isEmpty()) {
                    this.arrayList.add(element);
                    return;
                }
                return;
            case 14:
                List list = (List) element;
                if (Float.isNaN(this.leading)) {
                    setLeading(list.getTotalLeading());
                }
                if (!list.isEmpty()) {
                    this.arrayList.add(element);
                    return;
                }
                return;
            case 15:
            case 20:
            case 21:
                throw new BadElementException("You can't add listitems, rows or cells to a cell.");
            case 22:
                Table table2 = new Table(3);
                float[] fArr = new float[3];
                Table table3 = (Table) element;
                fArr[1] = table3.getWidth();
                int alignment = table3.getAlignment();
                if (alignment == 0) {
                    fArr[0] = 0.0f;
                    fArr[2] = 100.0f - fArr[1];
                } else if (alignment == 1) {
                    fArr[0] = (100.0f - fArr[1]) / 2.0f;
                    fArr[2] = fArr[0];
                } else if (alignment == 2) {
                    fArr[0] = 100.0f - fArr[1];
                    fArr[2] = 0.0f;
                }
                table2.setWidths(fArr);
                if (this.arrayList.isEmpty()) {
                    table2.addCell(getDummyCell());
                } else {
                    Cell cell2 = new Cell();
                    cell2.setBorder(0);
                    cell2.setColspan(3);
                    Iterator it = this.arrayList.iterator();
                    while (it.hasNext()) {
                        cell2.add(it.next());
                    }
                    table2.addCell(cell2);
                }
                Cell cell3 = new Cell();
                cell3.setBorder(0);
                table2.addCell(cell3);
                table2.insertTable(table3);
                Cell cell4 = new Cell();
                cell4.setBorder(0);
                table2.addCell(cell4);
                table2.addCell(getDummyCell());
                clear();
                this.arrayList.add(table2);
                return;
            default:
                this.arrayList.add(element);
                return;
        }
    }

    public boolean add(Object obj) {
        try {
            addElement((Element) obj);
            return true;
        } catch (ClassCastException unused) {
            throw new ClassCastException("You can only add objects that implement the Element interface.");
        } catch (BadElementException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    private static Cell getDummyCell() {
        Cell cell = new Cell(true);
        cell.setColspan(3);
        cell.setBorder(0);
        return cell;
    }

    public PdfPCell createPdfPCell() throws BadElementException {
        boolean z = true;
        if (this.rowspan > 1) {
            throw new BadElementException("PdfPCells can't have a rowspan > 1");
        } else if (isTable()) {
            return new PdfPCell(((Table) this.arrayList.get(0)).createPdfPTable());
        } else {
            PdfPCell pdfPCell = new PdfPCell();
            pdfPCell.setVerticalAlignment(this.verticalAlignment);
            pdfPCell.setHorizontalAlignment(this.horizontalAlignment);
            pdfPCell.setColspan(this.colspan);
            pdfPCell.setUseBorderPadding(this.useBorderPadding);
            pdfPCell.setUseDescender(this.useDescender);
            pdfPCell.setLeading(getLeading(), 0.0f);
            pdfPCell.cloneNonPositionParameters(this);
            if (getMaxLines() != 1) {
                z = false;
            }
            pdfPCell.setNoWrap(z);
            Iterator elements = getElements();
            while (elements.hasNext()) {
                Element element = (Element) elements.next();
                if (element.type() == 11 || element.type() == 12) {
                    Paragraph paragraph = new Paragraph((Phrase) element);
                    paragraph.setAlignment(this.horizontalAlignment);
                    element = paragraph;
                }
                pdfPCell.addElement(element);
            }
            return pdfPCell;
        }
    }

    public float getTop() {
        throw new UnsupportedOperationException("Dimensions of a Cell can't be calculated. See the FAQ.");
    }

    public float getBottom() {
        throw new UnsupportedOperationException("Dimensions of a Cell can't be calculated. See the FAQ.");
    }

    public float getLeft() {
        throw new UnsupportedOperationException("Dimensions of a Cell can't be calculated. See the FAQ.");
    }

    public float getRight() {
        throw new UnsupportedOperationException("Dimensions of a Cell can't be calculated. See the FAQ.");
    }

    public float top(int i) {
        throw new UnsupportedOperationException("Dimensions of a Cell can't be calculated. See the FAQ.");
    }

    public float bottom(int i) {
        throw new UnsupportedOperationException("Dimensions of a Cell can't be calculated. See the FAQ.");
    }

    public float left(int i) {
        throw new UnsupportedOperationException("Dimensions of a Cell can't be calculated. See the FAQ.");
    }

    public float right(int i) {
        throw new UnsupportedOperationException("Dimensions of a Cell can't be calculated. See the FAQ.");
    }

    public void setTop(int i) {
        throw new UnsupportedOperationException("Dimensions of a Cell are attributed automagically. See the FAQ.");
    }

    public void setBottom(int i) {
        throw new UnsupportedOperationException("Dimensions of a Cell are attributed automagically. See the FAQ.");
    }

    public void setLeft(int i) {
        throw new UnsupportedOperationException("Dimensions of a Cell are attributed automagically. See the FAQ.");
    }

    public void setRight(int i) {
        throw new UnsupportedOperationException("Dimensions of a Cell are attributed automagically. See the FAQ.");
    }
}
