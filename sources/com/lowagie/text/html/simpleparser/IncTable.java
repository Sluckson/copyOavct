package com.lowagie.text.html.simpleparser;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class IncTable {
    private ArrayList cols;
    private HashMap props = new HashMap();
    private ArrayList rows = new ArrayList();

    public IncTable(HashMap hashMap) {
        this.props.putAll(hashMap);
    }

    public void addCol(PdfPCell pdfPCell) {
        if (this.cols == null) {
            this.cols = new ArrayList();
        }
        this.cols.add(pdfPCell);
    }

    public void addCols(ArrayList arrayList) {
        ArrayList arrayList2 = this.cols;
        if (arrayList2 == null) {
            this.cols = new ArrayList(arrayList);
        } else {
            arrayList2.addAll(arrayList);
        }
    }

    public void endRow() {
        ArrayList arrayList = this.cols;
        if (arrayList != null) {
            Collections.reverse(arrayList);
            this.rows.add(this.cols);
            this.cols = null;
        }
    }

    public ArrayList getRows() {
        return this.rows;
    }

    public PdfPTable buildTable() {
        if (this.rows.isEmpty()) {
            return new PdfPTable(1);
        }
        ArrayList arrayList = (ArrayList) this.rows.get(0);
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            i += ((PdfPCell) arrayList.get(i2)).getColspan();
        }
        PdfPTable pdfPTable = new PdfPTable(i);
        String str = (String) this.props.get("width");
        if (str == null) {
            pdfPTable.setWidthPercentage(100.0f);
        } else if (str.endsWith("%")) {
            pdfPTable.setWidthPercentage(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else {
            pdfPTable.setTotalWidth(Float.parseFloat(str));
            pdfPTable.setLockedWidth(true);
        }
        for (int i3 = 0; i3 < this.rows.size(); i3++) {
            ArrayList arrayList2 = (ArrayList) this.rows.get(i3);
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                pdfPTable.addCell((PdfPCell) arrayList2.get(i4));
            }
        }
        return pdfPTable;
    }
}
