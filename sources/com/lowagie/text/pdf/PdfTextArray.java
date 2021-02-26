package com.lowagie.text.pdf;

import java.util.ArrayList;

public class PdfTextArray {
    ArrayList arrayList = new ArrayList();
    private Float lastNum;
    private String lastStr;

    public PdfTextArray(String str) {
        add(str);
    }

    public PdfTextArray() {
    }

    public void add(PdfNumber pdfNumber) {
        add((float) pdfNumber.doubleValue());
    }

    public void add(float f) {
        if (f != 0.0f) {
            Float f2 = this.lastNum;
            if (f2 != null) {
                this.lastNum = new Float(f + f2.floatValue());
                if (this.lastNum.floatValue() != 0.0f) {
                    replaceLast(this.lastNum);
                } else {
                    ArrayList arrayList2 = this.arrayList;
                    arrayList2.remove(arrayList2.size() - 1);
                }
            } else {
                this.lastNum = new Float(f);
                this.arrayList.add(this.lastNum);
            }
            this.lastStr = null;
        }
    }

    public void add(String str) {
        if (str.length() > 0) {
            String str2 = this.lastStr;
            if (str2 != null) {
                this.lastStr = String.valueOf(str2) + str;
                replaceLast(this.lastStr);
            } else {
                this.lastStr = str;
                this.arrayList.add(this.lastStr);
            }
            this.lastNum = null;
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList getArrayList() {
        return this.arrayList;
    }

    private void replaceLast(Object obj) {
        ArrayList arrayList2 = this.arrayList;
        arrayList2.set(arrayList2.size() - 1, obj);
    }
}
