package com.lowagie.text.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.exceptions.BadPasswordException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfDocument;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

class PdfCopyFieldsImp extends PdfWriter {
    protected static final HashMap fieldKeys = new HashMap();
    private static final PdfName iTextTag = new PdfName("_iTextTag_");
    protected static final HashMap widgetKeys = new HashMap();
    private static final Integer zero = new Integer(0);
    private ArrayList calculationOrder;
    private ArrayList calculationOrderRefs;
    boolean closing;
    HashMap fieldTree;
    ArrayList fields;
    RandomAccessFileOrArray file;
    PdfDictionary form;
    private boolean hasSignature;

    /* renamed from: nd */
    Document f636nd;
    ArrayList pageDics;
    ArrayList pageRefs;
    HashMap pages2intrefs;
    ArrayList readers;
    HashMap readers2intrefs;
    PdfDictionary resources;
    private HashMap tabOrder;
    HashMap visited;

    static {
        Integer num = new Integer(1);
        widgetKeys.put(PdfName.SUBTYPE, num);
        widgetKeys.put(PdfName.CONTENTS, num);
        widgetKeys.put(PdfName.RECT, num);
        widgetKeys.put(PdfName.f702NM, num);
        widgetKeys.put(PdfName.f694M, num);
        widgetKeys.put(PdfName.f673F, num);
        widgetKeys.put(PdfName.f651BS, num);
        widgetKeys.put(PdfName.BORDER, num);
        widgetKeys.put(PdfName.f644AP, num);
        widgetKeys.put(PdfName.f645AS, num);
        widgetKeys.put(PdfName.f652C, num);
        widgetKeys.put(PdfName.f641A, num);
        widgetKeys.put(PdfName.STRUCTPARENT, num);
        widgetKeys.put(PdfName.f704OC, num);
        widgetKeys.put(PdfName.f679H, num);
        widgetKeys.put(PdfName.f695MK, num);
        widgetKeys.put(PdfName.f662DA, num);
        widgetKeys.put(PdfName.f714Q, num);
        fieldKeys.put(PdfName.f642AA, num);
        fieldKeys.put(PdfName.f678FT, num);
        fieldKeys.put(PdfName.f731TU, num);
        fieldKeys.put(PdfName.f729TM, num);
        fieldKeys.put(PdfName.f675FF, num);
        fieldKeys.put(PdfName.f736V, num);
        fieldKeys.put(PdfName.f669DV, num);
        fieldKeys.put(PdfName.f668DS, num);
        fieldKeys.put(PdfName.f718RV, num);
        fieldKeys.put(PdfName.OPT, num);
        fieldKeys.put(PdfName.MAXLEN, num);
        fieldKeys.put(PdfName.f727TI, num);
        fieldKeys.put(PdfName.f686I, num);
        fieldKeys.put(PdfName.LOCK, num);
        fieldKeys.put(PdfName.f721SV, num);
    }

    PdfCopyFieldsImp(OutputStream outputStream) throws DocumentException {
        this(outputStream, 0);
    }

    PdfCopyFieldsImp(OutputStream outputStream, char c) throws DocumentException {
        super(new PdfDocument(), outputStream);
        this.readers = new ArrayList();
        this.readers2intrefs = new HashMap();
        this.pages2intrefs = new HashMap();
        this.visited = new HashMap();
        this.fields = new ArrayList();
        this.fieldTree = new HashMap();
        this.pageRefs = new ArrayList();
        this.pageDics = new ArrayList();
        this.resources = new PdfDictionary();
        this.closing = false;
        this.calculationOrder = new ArrayList();
        this.pdf.addWriter(this);
        if (c != 0) {
            super.setPdfVersion(c);
        }
        this.f636nd = new Document();
        this.f636nd.addDocListener(this.pdf);
    }

    /* access modifiers changed from: package-private */
    public void addDocument(PdfReader pdfReader, List list) throws DocumentException, IOException {
        if (this.readers2intrefs.containsKey(pdfReader) || !pdfReader.isTampered()) {
            PdfReader pdfReader2 = new PdfReader(pdfReader);
            pdfReader2.selectPages(list);
            if (pdfReader2.getNumberOfPages() != 0) {
                pdfReader2.setTampered(false);
                addDocument(pdfReader2);
                return;
            }
            return;
        }
        throw new DocumentException("The document was reused.");
    }

    /* access modifiers changed from: package-private */
    public void addDocument(PdfReader pdfReader) throws DocumentException, IOException {
        if (pdfReader.isOpenedWithFullPermissions()) {
            openDoc();
            if (this.readers2intrefs.containsKey(pdfReader)) {
                pdfReader = new PdfReader(pdfReader);
            } else if (!pdfReader.isTampered()) {
                pdfReader.consolidateNamedDestinations();
                pdfReader.setTampered(true);
            } else {
                throw new DocumentException("The document was reused.");
            }
            pdfReader.shuffleSubsetNames();
            this.readers2intrefs.put(pdfReader, new IntHashtable());
            this.readers.add(pdfReader);
            int numberOfPages = pdfReader.getNumberOfPages();
            IntHashtable intHashtable = new IntHashtable();
            for (int i = 1; i <= numberOfPages; i++) {
                intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), 1);
                pdfReader.releasePage(i);
            }
            this.pages2intrefs.put(pdfReader, intHashtable);
            this.visited.put(pdfReader, new IntHashtable());
            this.fields.add(pdfReader.getAcroFields());
            updateCalculationOrder(pdfReader);
            return;
        }
        throw new BadPasswordException("PdfReader not opened with owner password");
    }

    private static String getCOName(PdfReader pdfReader, PRIndirectReference pRIndirectReference) {
        PdfObject pdfObject;
        String str = "";
        while (pRIndirectReference != null && (pdfObject = PdfReader.getPdfObject((PdfObject) pRIndirectReference)) != null && pdfObject.type() == 6) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            PdfString asString = pdfDictionary.getAsString(PdfName.f723T);
            if (asString != null) {
                str = String.valueOf(asString.toUnicodeString()) + "." + str;
            }
            pRIndirectReference = (PRIndirectReference) pdfDictionary.get(PdfName.PARENT);
        }
        return str.endsWith(".") ? str.substring(0, str.length() - 1) : str;
    }

    /* access modifiers changed from: protected */
    public void updateCalculationOrder(PdfReader pdfReader) {
        PdfArray asArray;
        PdfDictionary asDict = pdfReader.getCatalog().getAsDict(PdfName.ACROFORM);
        if (asDict != null && (asArray = asDict.getAsArray(PdfName.f659CO)) != null && asArray.size() != 0) {
            AcroFields acroFields = pdfReader.getAcroFields();
            for (int i = 0; i < asArray.size(); i++) {
                PdfObject pdfObject = asArray.getPdfObject(i);
                if (pdfObject != null && pdfObject.isIndirect()) {
                    String cOName = getCOName(pdfReader, (PRIndirectReference) pdfObject);
                    if (acroFields.getFieldItem(cOName) != null) {
                        String str = "." + cOName;
                        if (!this.calculationOrder.contains(str)) {
                            this.calculationOrder.add(str);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void propagate(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        if (pdfObject != null && !(pdfObject instanceof PdfIndirectReference)) {
            int type = pdfObject.type();
            if (type == 5) {
                ListIterator listIterator = ((PdfArray) pdfObject).listIterator();
                while (listIterator.hasNext()) {
                    PdfObject pdfObject2 = (PdfObject) listIterator.next();
                    if (pdfObject2 == null || !pdfObject2.isIndirect()) {
                        propagate(pdfObject2, (PdfIndirectReference) null, z);
                    } else {
                        PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject2;
                        if (!isVisited(pRIndirectReference) && !isPage(pRIndirectReference)) {
                            propagate(PdfReader.getPdfObjectRelease((PdfObject) pRIndirectReference), getNewReference(pRIndirectReference), z);
                        }
                    }
                }
            } else if (type == 6 || type == 7) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                for (PdfName pdfName : pdfDictionary.getKeys()) {
                    if (!z || (!pdfName.equals(PdfName.PARENT) && !pdfName.equals(PdfName.KIDS))) {
                        PdfObject pdfObject3 = pdfDictionary.get(pdfName);
                        if (pdfObject3 == null || !pdfObject3.isIndirect()) {
                            propagate(pdfObject3, (PdfIndirectReference) null, z);
                        } else {
                            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfObject3;
                            if (!setVisited(pRIndirectReference2) && !isPage(pRIndirectReference2)) {
                                propagate(PdfReader.getPdfObjectRelease((PdfObject) pRIndirectReference2), getNewReference(pRIndirectReference2), z);
                            }
                        }
                    }
                }
            } else if (type == 10) {
                throw new RuntimeException("Reference pointing to reference.");
            }
        }
    }

    private void adjustTabOrder(PdfArray pdfArray, PdfIndirectReference pdfIndirectReference, PdfNumber pdfNumber) {
        int intValue = pdfNumber.intValue();
        ArrayList arrayList = (ArrayList) this.tabOrder.get(pdfArray);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            int size = pdfArray.size() - 1;
            for (int i = 0; i < size; i++) {
                arrayList2.add(zero);
            }
            arrayList2.add(new Integer(intValue));
            this.tabOrder.put(pdfArray, arrayList2);
            pdfArray.add((PdfObject) pdfIndirectReference);
            return;
        }
        int size2 = arrayList.size() - 1;
        int i2 = size2;
        while (true) {
            if (i2 < 0) {
                break;
            } else if (((Integer) arrayList.get(i2)).intValue() <= intValue) {
                int i3 = i2 + 1;
                arrayList.add(i3, new Integer(intValue));
                pdfArray.add(i3, pdfIndirectReference);
                size2 = -2;
                break;
            } else {
                i2--;
            }
        }
        if (size2 != -2) {
            arrayList.add(0, new Integer(intValue));
            pdfArray.add(0, pdfIndirectReference);
        }
    }

    /* access modifiers changed from: protected */
    public PdfArray branchForm(HashMap hashMap, PdfIndirectReference pdfIndirectReference, String str) throws IOException {
        PdfIndirectReference pdfIndirectReference2 = pdfIndirectReference;
        PdfArray pdfArray = new PdfArray();
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            PdfIndirectReference pdfIndirectReference3 = getPdfIndirectReference();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfIndirectReference2 != null) {
                pdfDictionary.put(PdfName.PARENT, pdfIndirectReference2);
            }
            pdfDictionary.put(PdfName.f723T, new PdfString(str2, PdfObject.TEXT_UNICODE));
            String str3 = String.valueOf(str) + "." + str2;
            int indexOf = this.calculationOrder.indexOf(str3);
            if (indexOf >= 0) {
                this.calculationOrderRefs.set(indexOf, pdfIndirectReference3);
            }
            if (value instanceof HashMap) {
                pdfDictionary.put(PdfName.KIDS, branchForm((HashMap) value, pdfIndirectReference3, str3));
                pdfArray.add((PdfObject) pdfIndirectReference3);
                addToBody((PdfObject) pdfDictionary, pdfIndirectReference3);
            } else {
                ArrayList arrayList = (ArrayList) value;
                pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(0));
                if (arrayList.size() == 3) {
                    pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(2));
                    PdfDictionary pdfDictionary2 = (PdfDictionary) this.pageDics.get(((Integer) arrayList.get(1)).intValue() - 1);
                    PdfArray asArray = pdfDictionary2.getAsArray(PdfName.ANNOTS);
                    if (asArray == null) {
                        asArray = new PdfArray();
                        pdfDictionary2.put(PdfName.ANNOTS, asArray);
                    }
                    pdfDictionary.remove(iTextTag);
                    adjustTabOrder(asArray, pdfIndirectReference3, (PdfNumber) pdfDictionary.get(iTextTag));
                } else {
                    PdfArray pdfArray2 = new PdfArray();
                    for (int i = 1; i < arrayList.size(); i += 2) {
                        PdfDictionary pdfDictionary3 = (PdfDictionary) this.pageDics.get(((Integer) arrayList.get(i)).intValue() - 1);
                        PdfArray asArray2 = pdfDictionary3.getAsArray(PdfName.ANNOTS);
                        if (asArray2 == null) {
                            asArray2 = new PdfArray();
                            pdfDictionary3.put(PdfName.ANNOTS, asArray2);
                        }
                        PdfDictionary pdfDictionary4 = new PdfDictionary();
                        pdfDictionary4.merge((PdfDictionary) arrayList.get(i + 1));
                        pdfDictionary4.put(PdfName.PARENT, pdfIndirectReference3);
                        pdfDictionary4.remove(iTextTag);
                        PdfIndirectReference indirectReference = addToBody(pdfDictionary4).getIndirectReference();
                        adjustTabOrder(asArray2, indirectReference, (PdfNumber) pdfDictionary4.get(iTextTag));
                        pdfArray2.add((PdfObject) indirectReference);
                        propagate(pdfDictionary4, (PdfIndirectReference) null, false);
                    }
                    pdfDictionary.put(PdfName.KIDS, pdfArray2);
                }
                pdfArray.add((PdfObject) pdfIndirectReference3);
                addToBody((PdfObject) pdfDictionary, pdfIndirectReference3);
                propagate(pdfDictionary, (PdfIndirectReference) null, false);
            }
        }
        return pdfArray;
    }

    /* access modifiers changed from: protected */
    public void createAcroForms() throws IOException {
        if (!this.fieldTree.isEmpty()) {
            this.form = new PdfDictionary();
            this.form.put(PdfName.f667DR, this.resources);
            propagate(this.resources, (PdfIndirectReference) null, false);
            this.form.put(PdfName.f662DA, new PdfString("/Helv 0 Tf 0 g "));
            this.tabOrder = new HashMap();
            this.calculationOrderRefs = new ArrayList(this.calculationOrder);
            this.form.put(PdfName.FIELDS, branchForm(this.fieldTree, (PdfIndirectReference) null, ""));
            if (this.hasSignature) {
                this.form.put(PdfName.SIGFLAGS, new PdfNumber(3));
            }
            PdfArray pdfArray = new PdfArray();
            for (int i = 0; i < this.calculationOrderRefs.size(); i++) {
                Object obj = this.calculationOrderRefs.get(i);
                if (obj instanceof PdfIndirectReference) {
                    pdfArray.add((PdfObject) (PdfIndirectReference) obj);
                }
            }
            if (pdfArray.size() > 0) {
                this.form.put(PdfName.f659CO, pdfArray);
            }
        }
    }

    public void close() {
        if (this.closing) {
            super.close();
            return;
        }
        this.closing = true;
        try {
            closeIt();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public void closeIt() throws IOException {
        for (int i = 0; i < this.readers.size(); i++) {
            ((PdfReader) this.readers.get(i)).removeFields();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.readers.size()) {
                break;
            }
            PdfReader pdfReader = (PdfReader) this.readers.get(i2);
            for (int i3 = 1; i3 <= pdfReader.getNumberOfPages(); i3++) {
                this.pageRefs.add(getNewReference(pdfReader.getPageOrigRef(i3)));
                this.pageDics.add(pdfReader.getPageN(i3));
            }
            i2++;
        }
        mergeFields();
        createAcroForms();
        for (int i4 = 0; i4 < this.readers.size(); i4++) {
            PdfReader pdfReader2 = (PdfReader) this.readers.get(i4);
            for (int i5 = 1; i5 <= pdfReader2.getNumberOfPages(); i5++) {
                PdfDictionary pageN = pdfReader2.getPageN(i5);
                PdfIndirectReference newReference = getNewReference(pdfReader2.getPageOrigRef(i5));
                pageN.put(PdfName.PARENT, this.root.addPageRef(newReference));
                propagate(pageN, newReference, false);
            }
        }
        for (Map.Entry entry : this.readers2intrefs.entrySet()) {
            PdfReader pdfReader3 = (PdfReader) entry.getKey();
            try {
                this.file = pdfReader3.getSafeFile();
                this.file.reOpen();
                IntHashtable intHashtable = (IntHashtable) entry.getValue();
                int[] orderedKeys = intHashtable.toOrderedKeys();
                for (int i6 = 0; i6 < orderedKeys.length; i6++) {
                    addToBody(PdfReader.getPdfObjectRelease((PdfObject) new PRIndirectReference(pdfReader3, orderedKeys[i6])), intHashtable.get(orderedKeys[i6]));
                }
            } finally {
                try {
                    this.file.close();
                    pdfReader3.close();
                } catch (Exception unused) {
                }
            }
        }
        this.pdf.close();
    }

    /* access modifiers changed from: package-private */
    public void addPageOffsetToField(HashMap hashMap, int i) {
        if (i != 0) {
            for (AcroFields.Item item : hashMap.values()) {
                for (int i2 = 0; i2 < item.size(); i2++) {
                    item.forcePage(i2, item.getPage(i2).intValue() + i);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void createWidgets(ArrayList arrayList, AcroFields.Item item) {
        for (int i = 0; i < item.size(); i++) {
            arrayList.add(item.getPage(i));
            PdfDictionary merged = item.getMerged(i);
            PdfObject pdfObject = merged.get(PdfName.f667DR);
            if (pdfObject != null) {
                PdfFormField.mergeResources(this.resources, (PdfDictionary) PdfReader.getPdfObject(pdfObject));
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            for (PdfName pdfName : merged.getKeys()) {
                if (widgetKeys.containsKey(pdfName)) {
                    pdfDictionary.put(pdfName, merged.get(pdfName));
                }
            }
            pdfDictionary.put(iTextTag, new PdfNumber(item.getTabOrder(i).intValue() + 1));
            arrayList.add(pdfDictionary);
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeField(String str, AcroFields.Item item) {
        HashMap hashMap = this.fieldTree;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (stringTokenizer.hasMoreTokens()) {
            while (true) {
                String nextToken = stringTokenizer.nextToken();
                Object obj = hashMap.get(nextToken);
                if (stringTokenizer.hasMoreTokens()) {
                    if (obj == null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap.put(nextToken, hashMap2);
                        hashMap = hashMap2;
                    } else if (obj instanceof HashMap) {
                        hashMap = (HashMap) obj;
                    } else {
                        return;
                    }
                } else if (!(obj instanceof HashMap)) {
                    int i = 0;
                    PdfDictionary merged = item.getMerged(0);
                    if (obj == null) {
                        PdfDictionary pdfDictionary = new PdfDictionary();
                        if (PdfName.SIG.equals(merged.get(PdfName.f678FT))) {
                            this.hasSignature = true;
                        }
                        for (PdfName pdfName : merged.getKeys()) {
                            if (fieldKeys.containsKey(pdfName)) {
                                pdfDictionary.put(pdfName, merged.get(pdfName));
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(pdfDictionary);
                        createWidgets(arrayList, item);
                        hashMap.put(nextToken, arrayList);
                        return;
                    }
                    ArrayList arrayList2 = (ArrayList) obj;
                    PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList2.get(0);
                    PdfName pdfName2 = (PdfName) pdfDictionary2.get(PdfName.f678FT);
                    PdfName pdfName3 = (PdfName) merged.get(PdfName.f678FT);
                    if (pdfName2 != null && pdfName2.equals(pdfName3)) {
                        PdfObject pdfObject = pdfDictionary2.get(PdfName.f675FF);
                        int intValue = (pdfObject == null || !pdfObject.isNumber()) ? 0 : ((PdfNumber) pdfObject).intValue();
                        PdfObject pdfObject2 = merged.get(PdfName.f675FF);
                        if (pdfObject2 != null && pdfObject2.isNumber()) {
                            i = ((PdfNumber) pdfObject2).intValue();
                        }
                        if (pdfName2.equals(PdfName.BTN)) {
                            int i2 = intValue ^ i;
                            if ((i2 & 65536) == 0) {
                                if ((intValue & 65536) == 0 && (32768 & i2) != 0) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (pdfName2.equals(PdfName.f657CH) && ((intValue ^ i) & 131072) != 0) {
                            return;
                        }
                        createWidgets(arrayList2, item);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeWithMaster(HashMap hashMap) {
        for (Map.Entry entry : hashMap.entrySet()) {
            mergeField((String) entry.getKey(), (AcroFields.Item) entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeFields() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.size(); i2++) {
            HashMap fields2 = ((AcroFields) this.fields.get(i2)).getFields();
            addPageOffsetToField(fields2, i);
            mergeWithMaster(fields2);
            i += ((PdfReader) this.readers.get(i2)).getNumberOfPages();
        }
    }

    public PdfIndirectReference getPageReference(int i) {
        return (PdfIndirectReference) this.pageRefs.get(i - 1);
    }

    /* access modifiers changed from: protected */
    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        try {
            PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
            if (this.form != null) {
                catalog.put(PdfName.ACROFORM, addToBody(this.form).getIndirectReference());
            }
            return catalog;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference getNewReference(PRIndirectReference pRIndirectReference) {
        return new PdfIndirectReference(0, getNewObjectNumber(pRIndirectReference.getReader(), pRIndirectReference.getNumber(), 0));
    }

    /* access modifiers changed from: protected */
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        IntHashtable intHashtable = (IntHashtable) this.readers2intrefs.get(pdfReader);
        int i3 = intHashtable.get(i);
        if (i3 != 0) {
            return i3;
        }
        int indirectReferenceNumber = getIndirectReferenceNumber();
        intHashtable.put(i, indirectReferenceNumber);
        return indirectReferenceNumber;
    }

    /* access modifiers changed from: protected */
    public boolean setVisited(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = (IntHashtable) this.visited.get(pRIndirectReference.getReader());
        if (intHashtable == null || intHashtable.put(pRIndirectReference.getNumber(), 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isVisited(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = (IntHashtable) this.visited.get(pRIndirectReference.getReader());
        if (intHashtable != null) {
            return intHashtable.containsKey(pRIndirectReference.getNumber());
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isVisited(PdfReader pdfReader, int i, int i2) {
        return ((IntHashtable) this.readers2intrefs.get(pdfReader)).containsKey(i);
    }

    /* access modifiers changed from: protected */
    public boolean isPage(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = (IntHashtable) this.pages2intrefs.get(pRIndirectReference.getReader());
        if (intHashtable != null) {
            return intHashtable.containsKey(pRIndirectReference.getNumber());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        return this.file;
    }

    public void openDoc() {
        if (!this.f636nd.isOpen()) {
            this.f636nd.open();
        }
    }
}
