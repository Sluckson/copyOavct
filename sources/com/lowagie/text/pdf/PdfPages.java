package com.lowagie.text.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import java.io.IOException;
import java.util.ArrayList;

public class PdfPages {
    private int leafSize = 10;
    private ArrayList pages = new ArrayList();
    private ArrayList parents = new ArrayList();
    private PdfIndirectReference topParent;
    private PdfWriter writer;

    PdfPages(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    /* access modifiers changed from: package-private */
    public void addPage(PdfDictionary pdfDictionary) {
        try {
            if (this.pages.size() % this.leafSize == 0) {
                this.parents.add(this.writer.getPdfIndirectReference());
            }
            pdfDictionary.put(PdfName.PARENT, (PdfIndirectReference) this.parents.get(this.parents.size() - 1));
            PdfIndirectReference currentPage = this.writer.getCurrentPage();
            this.writer.addToBody((PdfObject) pdfDictionary, currentPage);
            this.pages.add(currentPage);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference addPageRef(PdfIndirectReference pdfIndirectReference) {
        try {
            if (this.pages.size() % this.leafSize == 0) {
                this.parents.add(this.writer.getPdfIndirectReference());
            }
            this.pages.add(pdfIndirectReference);
            return (PdfIndirectReference) this.parents.get(this.parents.size() - 1);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference writePageTree() throws IOException {
        int i;
        int i2;
        if (!this.pages.isEmpty()) {
            ArrayList arrayList = this.parents;
            ArrayList arrayList2 = this.pages;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList;
            int i3 = 1;
            while (true) {
                int i4 = this.leafSize;
                i3 *= i4;
                int size = arrayList2.size();
                int i5 = this.leafSize;
                int i6 = size % i5;
                if (i6 == 0) {
                    i6 = i5;
                }
                for (int i7 = 0; i7 < arrayList4.size(); i7++) {
                    if (i7 == arrayList4.size() - 1) {
                        i2 = this.pages.size() % i3;
                        if (i2 == 0) {
                            i2 = i3;
                        }
                        i = i6;
                    } else {
                        i2 = i3;
                        i = i4;
                    }
                    PdfDictionary pdfDictionary = new PdfDictionary(PdfName.PAGES);
                    pdfDictionary.put(PdfName.COUNT, new PdfNumber(i2));
                    PdfArray pdfArray = new PdfArray();
                    int i8 = i7 * i4;
                    pdfArray.getArrayList().addAll(arrayList2.subList(i8, i + i8));
                    pdfDictionary.put(PdfName.KIDS, pdfArray);
                    if (arrayList4.size() > 1) {
                        if (i7 % this.leafSize == 0) {
                            arrayList3.add(this.writer.getPdfIndirectReference());
                        }
                        pdfDictionary.put(PdfName.PARENT, (PdfIndirectReference) arrayList3.get(i7 / this.leafSize));
                    } else {
                        pdfDictionary.put(PdfName.ITXT, new PdfString(Document.getRelease()));
                    }
                    this.writer.addToBody((PdfObject) pdfDictionary, (PdfIndirectReference) arrayList4.get(i7));
                }
                if (arrayList4.size() == 1) {
                    this.topParent = (PdfIndirectReference) arrayList4.get(0);
                    return this.topParent;
                }
                ArrayList arrayList5 = arrayList3;
                arrayList3 = new ArrayList();
                arrayList2 = arrayList4;
                arrayList4 = arrayList5;
            }
        } else {
            throw new IOException("The document has no pages.");
        }
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getTopParent() {
        return this.topParent;
    }

    /* access modifiers changed from: package-private */
    public void setLinearMode(PdfIndirectReference pdfIndirectReference) {
        if (this.parents.size() <= 1) {
            if (pdfIndirectReference != null) {
                this.topParent = pdfIndirectReference;
                this.parents.clear();
                this.parents.add(pdfIndirectReference);
            }
            this.leafSize = 10000000;
            return;
        }
        throw new RuntimeException("Linear page mode can only be called with a single parent.");
    }

    /* access modifiers changed from: package-private */
    public void addPage(PdfIndirectReference pdfIndirectReference) {
        this.pages.add(pdfIndirectReference);
    }

    /* access modifiers changed from: package-private */
    public int reorderPages(int[] iArr) throws DocumentException {
        if (iArr == null) {
            return this.pages.size();
        }
        if (this.parents.size() > 1) {
            throw new DocumentException("Page reordering requires a single parent in the page tree. Call PdfWriter.setLinearMode() after open.");
        } else if (iArr.length == this.pages.size()) {
            int size = this.pages.size();
            boolean[] zArr = new boolean[size];
            int i = 0;
            while (i < size) {
                int i2 = iArr[i];
                if (i2 < 1 || i2 > size) {
                    throw new DocumentException("Page reordering requires pages between 1 and " + size + ". Found " + i2 + ".");
                }
                int i3 = i2 - 1;
                if (!zArr[i3]) {
                    zArr[i3] = true;
                    i++;
                } else {
                    throw new DocumentException("Page reordering requires no page repetition. Page " + i2 + " is repeated.");
                }
            }
            Object[] array = this.pages.toArray();
            for (int i4 = 0; i4 < size; i4++) {
                this.pages.set(i4, array[iArr[i4] - 1]);
            }
            return size;
        } else {
            throw new DocumentException("Page reordering requires an array with the same size as the number of pages.");
        }
    }
}
