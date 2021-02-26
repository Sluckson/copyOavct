package com.lowagie.text.pdf;

import com.lowagie.text.xml.simpleparser.IanaEncodings;
import com.lowagie.text.xml.simpleparser.SimpleXMLDocHandler;
import com.lowagie.text.xml.simpleparser.SimpleXMLParser;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public final class SimpleBookmark implements SimpleXMLDocHandler {
    private Stack attr = new Stack();
    private ArrayList topList;

    public void endDocument() {
    }

    public void startDocument() {
    }

    private SimpleBookmark() {
    }

    private static List bookmarkDepth(PdfReader pdfReader, PdfDictionary pdfDictionary, IntHashtable intHashtable) {
        ArrayList arrayList = new ArrayList();
        while (pdfDictionary != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Title", ((PdfString) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TITLE))).toUnicodeString());
            PdfArray pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.f652C));
            if (pdfArray != null && pdfArray.size() == 3) {
                ByteBuffer byteBuffer = new ByteBuffer();
                byteBuffer.append(pdfArray.getAsNumber(0).floatValue()).append(' ');
                byteBuffer.append(pdfArray.getAsNumber(1).floatValue()).append(' ');
                byteBuffer.append(pdfArray.getAsNumber(2).floatValue());
                hashMap.put("Color", PdfEncodings.convertToString(byteBuffer.toByteArray(), (String) null));
            }
            PdfNumber pdfNumber = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.f673F));
            if (pdfNumber != null) {
                int intValue = pdfNumber.intValue();
                String str = "";
                if ((intValue & 1) != 0) {
                    str = str + "italic ";
                }
                if ((intValue & 2) != 0) {
                    str = String.valueOf(str) + "bold ";
                }
                String trim = str.trim();
                if (trim.length() != 0) {
                    hashMap.put("Style", trim);
                }
            }
            PdfNumber pdfNumber2 = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.COUNT));
            if (pdfNumber2 != null && pdfNumber2.intValue() < 0) {
                hashMap.put("Open", PdfBoolean.FALSE);
            }
            try {
                PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.DEST));
                if (pdfObjectRelease != null) {
                    mapGotoBookmark(hashMap, pdfObjectRelease, intHashtable);
                } else {
                    PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.f641A));
                    if (pdfDictionary2 != null) {
                        if (PdfName.GOTO.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f719S)))) {
                            PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f661D));
                            if (pdfObjectRelease2 != null) {
                                mapGotoBookmark(hashMap, pdfObjectRelease2, intHashtable);
                            }
                        } else if (PdfName.URI.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f719S)))) {
                            hashMap.put("Action", "URI");
                            hashMap.put("URI", ((PdfString) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.URI))).toUnicodeString());
                        } else if (PdfName.GOTOR.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f719S)))) {
                            PdfObject pdfObjectRelease3 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f661D));
                            if (pdfObjectRelease3 != null) {
                                if (pdfObjectRelease3.isString()) {
                                    hashMap.put("Named", pdfObjectRelease3.toString());
                                } else if (pdfObjectRelease3.isName()) {
                                    hashMap.put("NamedN", PdfName.decodeName(pdfObjectRelease3.toString()));
                                } else if (pdfObjectRelease3.isArray()) {
                                    PdfArray pdfArray2 = (PdfArray) pdfObjectRelease3;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append(pdfArray2.getPdfObject(0).toString());
                                    stringBuffer.append(' ');
                                    stringBuffer.append(pdfArray2.getPdfObject(1).toString());
                                    for (int i = 2; i < pdfArray2.size(); i++) {
                                        stringBuffer.append(' ');
                                        stringBuffer.append(pdfArray2.getPdfObject(i).toString());
                                    }
                                    hashMap.put("Page", stringBuffer.toString());
                                }
                            }
                            hashMap.put("Action", "GoToR");
                            PdfObject pdfObjectRelease4 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f673F));
                            if (pdfObjectRelease4 != null) {
                                if (pdfObjectRelease4.isString()) {
                                    hashMap.put("File", ((PdfString) pdfObjectRelease4).toUnicodeString());
                                } else if (pdfObjectRelease4.isDictionary()) {
                                    PdfObject pdfObject = PdfReader.getPdfObject(((PdfDictionary) pdfObjectRelease4).get(PdfName.f673F));
                                    if (pdfObject.isString()) {
                                        hashMap.put("File", ((PdfString) pdfObject).toUnicodeString());
                                    }
                                }
                            }
                            PdfObject pdfObjectRelease5 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.NEWWINDOW));
                            if (pdfObjectRelease5 != null) {
                                hashMap.put("NewWindow", pdfObjectRelease5.toString());
                            }
                        } else if (PdfName.LAUNCH.equals(PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f719S)))) {
                            hashMap.put("Action", "Launch");
                            PdfObject pdfObjectRelease6 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f673F));
                            if (pdfObjectRelease6 == null) {
                                pdfObjectRelease6 = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.WIN));
                            }
                            if (pdfObjectRelease6 != null) {
                                if (pdfObjectRelease6.isString()) {
                                    hashMap.put("File", ((PdfString) pdfObjectRelease6).toUnicodeString());
                                } else if (pdfObjectRelease6.isDictionary()) {
                                    PdfObject pdfObjectRelease7 = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease6).get(PdfName.f673F));
                                    if (pdfObjectRelease7.isString()) {
                                        hashMap.put("File", ((PdfString) pdfObjectRelease7).toUnicodeString());
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIRST));
            if (pdfDictionary3 != null) {
                hashMap.put("Kids", bookmarkDepth(pdfReader, pdfDictionary3, intHashtable));
            }
            arrayList.add(hashMap);
            pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.NEXT));
        }
        return arrayList;
    }

    private static void mapGotoBookmark(HashMap hashMap, PdfObject pdfObject, IntHashtable intHashtable) {
        if (pdfObject.isString()) {
            hashMap.put("Named", pdfObject.toString());
        } else if (pdfObject.isName()) {
            hashMap.put("Named", PdfName.decodeName(pdfObject.toString()));
        } else if (pdfObject.isArray()) {
            hashMap.put("Page", makeBookmarkParam((PdfArray) pdfObject, intHashtable));
        }
        hashMap.put("Action", "GoTo");
    }

    private static String makeBookmarkParam(PdfArray pdfArray, IntHashtable intHashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        PdfObject pdfObject = pdfArray.getPdfObject(0);
        if (pdfObject.isNumber()) {
            stringBuffer.append(((PdfNumber) pdfObject).intValue() + 1);
        } else {
            stringBuffer.append(intHashtable.get(getNumber((PdfIndirectReference) pdfObject)));
        }
        stringBuffer.append(' ');
        stringBuffer.append(pdfArray.getPdfObject(1).toString().substring(1));
        for (int i = 2; i < pdfArray.size(); i++) {
            stringBuffer.append(' ');
            stringBuffer.append(pdfArray.getPdfObject(i).toString());
        }
        return stringBuffer.toString();
    }

    private static int getNumber(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease((PdfObject) pdfIndirectReference);
        if (pdfDictionary.contains(PdfName.TYPE) && pdfDictionary.get(PdfName.TYPE).equals(PdfName.PAGES) && pdfDictionary.contains(PdfName.KIDS)) {
            pdfIndirectReference = (PdfIndirectReference) ((PdfArray) pdfDictionary.get(PdfName.KIDS)).getPdfObject(0);
        }
        return pdfIndirectReference.getNumber();
    }

    public static List getBookmark(PdfReader pdfReader) {
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.OUTLINES));
        if (pdfObjectRelease == null || !pdfObjectRelease.isDictionary()) {
            return null;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObjectRelease;
        IntHashtable intHashtable = new IntHashtable();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), i);
            pdfReader.releasePage(i);
        }
        return bookmarkDepth(pdfReader, (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIRST)), intHashtable);
    }

    public static void eliminatePages(List list, int[] iArr) {
        String str;
        int i;
        if (list != null) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                HashMap hashMap = (HashMap) listIterator.next();
                boolean z = false;
                if ("GoTo".equals(hashMap.get("Action")) && (str = (String) hashMap.get("Page")) != null) {
                    String trim = str.trim();
                    int indexOf = trim.indexOf(32);
                    if (indexOf < 0) {
                        i = Integer.parseInt(trim);
                    } else {
                        i = Integer.parseInt(trim.substring(0, indexOf));
                    }
                    int length = iArr.length & -2;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (i >= iArr[i2] && i <= iArr[i2 + 1]) {
                                z = true;
                                break;
                            }
                            i2 += 2;
                        } else {
                            break;
                        }
                    }
                }
                List list2 = (List) hashMap.get("Kids");
                if (list2 != null) {
                    eliminatePages(list2, iArr);
                    if (list2.isEmpty()) {
                        hashMap.remove("Kids");
                        list2 = null;
                    }
                }
                if (z) {
                    if (list2 == null) {
                        listIterator.remove();
                    } else {
                        hashMap.remove("Action");
                        hashMap.remove("Page");
                        hashMap.remove("Named");
                    }
                }
            }
        }
    }

    public static void shiftPageNumbers(List list, int i, int[] iArr) {
        String str;
        int i2;
        if (list != null) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                HashMap hashMap = (HashMap) listIterator.next();
                if ("GoTo".equals(hashMap.get("Action")) && (str = (String) hashMap.get("Page")) != null) {
                    String trim = str.trim();
                    int indexOf = trim.indexOf(32);
                    if (indexOf < 0) {
                        i2 = Integer.parseInt(trim);
                    } else {
                        i2 = Integer.parseInt(trim.substring(0, indexOf));
                    }
                    boolean z = true;
                    if (iArr != null) {
                        int length = iArr.length & -2;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                if (i2 >= iArr[i3] && i2 <= iArr[i3 + 1]) {
                                    break;
                                }
                                i3 += 2;
                            } else {
                                z = false;
                                break;
                            }
                        }
                    }
                    if (z) {
                        if (indexOf < 0) {
                            trim = Integer.toString(i2 + i);
                        } else {
                            trim = String.valueOf(i2 + i) + trim.substring(indexOf);
                        }
                    }
                    hashMap.put("Page", trim);
                }
                List list2 = (List) hashMap.get("Kids");
                if (list2 != null) {
                    shiftPageNumbers(list2, i, iArr);
                }
            }
        }
    }

    static void createOutlineAction(PdfDictionary pdfDictionary, HashMap hashMap, PdfWriter pdfWriter, boolean z) {
        String str;
        PdfDictionary pdfDictionary2 = pdfDictionary;
        HashMap hashMap2 = hashMap;
        try {
            String str2 = (String) hashMap2.get("Action");
            int i = 0;
            if ("GoTo".equals(str2)) {
                String str3 = (String) hashMap2.get("Named");
                if (str3 == null) {
                    String str4 = (String) hashMap2.get("Page");
                    if (str4 != null) {
                        PdfArray pdfArray = new PdfArray();
                        StringTokenizer stringTokenizer = new StringTokenizer(str4);
                        pdfArray.add((PdfObject) pdfWriter.getPageReference(Integer.parseInt(stringTokenizer.nextToken())));
                        if (!stringTokenizer.hasMoreTokens()) {
                            pdfArray.add((PdfObject) PdfName.XYZ);
                            pdfArray.add(new float[]{0.0f, 10000.0f, 0.0f});
                        } else {
                            String nextToken = stringTokenizer.nextToken();
                            if (nextToken.startsWith("/")) {
                                nextToken = nextToken.substring(1);
                            }
                            pdfArray.add((PdfObject) new PdfName(nextToken));
                            while (true) {
                                if (i >= 4) {
                                    break;
                                } else if (!stringTokenizer.hasMoreTokens()) {
                                    break;
                                } else {
                                    String nextToken2 = stringTokenizer.nextToken();
                                    if (nextToken2.equals("null")) {
                                        pdfArray.add((PdfObject) PdfNull.PDFNULL);
                                    } else {
                                        pdfArray.add((PdfObject) new PdfNumber(nextToken2));
                                    }
                                    i++;
                                }
                            }
                        }
                        pdfDictionary2.put(PdfName.DEST, pdfArray);
                    }
                } else if (z) {
                    pdfDictionary2.put(PdfName.DEST, new PdfName(str3));
                } else {
                    pdfDictionary2.put(PdfName.DEST, new PdfString(str3, (String) null));
                }
            } else if ("GoToR".equals(str2)) {
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                String str5 = (String) hashMap2.get("Named");
                if (str5 != null) {
                    pdfDictionary3.put(PdfName.f661D, new PdfString(str5, (String) null));
                } else {
                    String str6 = (String) hashMap2.get("NamedN");
                    if (str6 != null) {
                        pdfDictionary3.put(PdfName.f661D, new PdfName(str6));
                    } else {
                        String str7 = (String) hashMap2.get("Page");
                        if (str7 != null) {
                            PdfArray pdfArray2 = new PdfArray();
                            StringTokenizer stringTokenizer2 = new StringTokenizer(str7);
                            pdfArray2.add((PdfObject) new PdfNumber(stringTokenizer2.nextToken()));
                            if (!stringTokenizer2.hasMoreTokens()) {
                                pdfArray2.add((PdfObject) PdfName.XYZ);
                                pdfArray2.add(new float[]{0.0f, 10000.0f, 0.0f});
                            } else {
                                String nextToken3 = stringTokenizer2.nextToken();
                                if (nextToken3.startsWith("/")) {
                                    nextToken3 = nextToken3.substring(1);
                                }
                                pdfArray2.add((PdfObject) new PdfName(nextToken3));
                                while (true) {
                                    if (i >= 4) {
                                        break;
                                    } else if (!stringTokenizer2.hasMoreTokens()) {
                                        break;
                                    } else {
                                        String nextToken4 = stringTokenizer2.nextToken();
                                        if (nextToken4.equals("null")) {
                                            pdfArray2.add((PdfObject) PdfNull.PDFNULL);
                                        } else {
                                            pdfArray2.add((PdfObject) new PdfNumber(nextToken4));
                                        }
                                        i++;
                                    }
                                }
                            }
                            pdfDictionary3.put(PdfName.f661D, pdfArray2);
                        }
                    }
                }
                String str8 = (String) hashMap2.get("File");
                if (pdfDictionary3.size() > 0 && str8 != null) {
                    pdfDictionary3.put(PdfName.f719S, PdfName.GOTOR);
                    pdfDictionary3.put(PdfName.f673F, new PdfString(str8));
                    String str9 = (String) hashMap2.get("NewWindow");
                    if (str9 != null) {
                        if (str9.equals("true")) {
                            pdfDictionary3.put(PdfName.NEWWINDOW, PdfBoolean.PDFTRUE);
                        } else if (str9.equals(PdfBoolean.FALSE)) {
                            pdfDictionary3.put(PdfName.NEWWINDOW, PdfBoolean.PDFFALSE);
                        }
                    }
                    pdfDictionary2.put(PdfName.f641A, pdfDictionary3);
                }
            } else if ("URI".equals(str2)) {
                String str10 = (String) hashMap2.get("URI");
                if (str10 != null) {
                    PdfDictionary pdfDictionary4 = new PdfDictionary();
                    pdfDictionary4.put(PdfName.f719S, PdfName.URI);
                    pdfDictionary4.put(PdfName.URI, new PdfString(str10));
                    pdfDictionary2.put(PdfName.f641A, pdfDictionary4);
                }
            } else if ("Launch".equals(str2) && (str = (String) hashMap2.get("File")) != null) {
                PdfDictionary pdfDictionary5 = new PdfDictionary();
                pdfDictionary5.put(PdfName.f719S, PdfName.LAUNCH);
                pdfDictionary5.put(PdfName.f673F, new PdfString(str));
                pdfDictionary2.put(PdfName.f641A, pdfDictionary5);
            }
        } catch (Exception unused) {
        }
    }

    public static Object[] iterateOutlines(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, List list, boolean z) throws IOException {
        PdfWriter pdfWriter2 = pdfWriter;
        boolean z2 = z;
        PdfIndirectReference[] pdfIndirectReferenceArr = new PdfIndirectReference[list.size()];
        char c = 0;
        int i = 0;
        while (i < pdfIndirectReferenceArr.length) {
            PdfIndirectReference pdfIndirectReference2 = pdfIndirectReference;
            pdfIndirectReferenceArr[i] = pdfWriter.getPdfIndirectReference();
            i++;
            c = 0;
        }
        ListIterator listIterator = list.listIterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (!listIterator.hasNext()) {
                Object[] objArr = new Object[3];
                objArr[c] = pdfIndirectReferenceArr[c];
                objArr[1] = pdfIndirectReferenceArr[pdfIndirectReferenceArr.length - 1];
                objArr[2] = new Integer(i2);
                return objArr;
            }
            HashMap hashMap = (HashMap) listIterator.next();
            Object[] objArr2 = null;
            List list2 = (List) hashMap.get("Kids");
            if (list2 != null && !list2.isEmpty()) {
                objArr2 = iterateOutlines(pdfWriter2, pdfIndirectReferenceArr[i3], list2, z2);
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            i2++;
            if (objArr2 != null) {
                pdfDictionary.put(PdfName.FIRST, (PdfIndirectReference) objArr2[c]);
                pdfDictionary.put(PdfName.LAST, (PdfIndirectReference) objArr2[1]);
                int intValue = ((Integer) objArr2[2]).intValue();
                if (PdfBoolean.FALSE.equals(hashMap.get("Open"))) {
                    pdfDictionary.put(PdfName.COUNT, new PdfNumber(-intValue));
                } else {
                    pdfDictionary.put(PdfName.COUNT, new PdfNumber(intValue));
                    i2 += intValue;
                }
            }
            pdfDictionary.put(PdfName.PARENT, pdfIndirectReference);
            if (i3 > 0) {
                pdfDictionary.put(PdfName.PREV, pdfIndirectReferenceArr[i3 - 1]);
            }
            if (i3 < pdfIndirectReferenceArr.length - 1) {
                pdfDictionary.put(PdfName.NEXT, pdfIndirectReferenceArr[i3 + 1]);
            }
            pdfDictionary.put(PdfName.TITLE, new PdfString((String) hashMap.get("Title"), PdfObject.TEXT_UNICODE));
            String str = (String) hashMap.get("Color");
            if (str != null) {
                try {
                    PdfArray pdfArray = new PdfArray();
                    StringTokenizer stringTokenizer = new StringTokenizer(str);
                    for (int i5 = 0; i5 < 3; i5++) {
                        float parseFloat = Float.parseFloat(stringTokenizer.nextToken());
                        if (parseFloat < 0.0f) {
                            parseFloat = 0.0f;
                        }
                        if (parseFloat > 1.0f) {
                            parseFloat = 1.0f;
                        }
                        pdfArray.add((PdfObject) new PdfNumber(parseFloat));
                    }
                    pdfDictionary.put(PdfName.f652C, pdfArray);
                } catch (Exception unused) {
                }
            }
            String str2 = (String) hashMap.get("Style");
            if (str2 != null) {
                String lowerCase = str2.toLowerCase();
                if (lowerCase.indexOf("italic") < 0) {
                    i4 = 0;
                }
                if (lowerCase.indexOf("bold") >= 0) {
                    i4 |= 2;
                }
                if (i4 != 0) {
                    pdfDictionary.put(PdfName.f673F, new PdfNumber(i4));
                }
            }
            createOutlineAction(pdfDictionary, hashMap, pdfWriter2, z2);
            pdfWriter2.addToBody((PdfObject) pdfDictionary, pdfIndirectReferenceArr[i3]);
            i3++;
            c = 0;
        }
    }

    public static void exportToXMLNode(List list, Writer writer, int i, boolean z) throws IOException {
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = String.valueOf(str) + "  ";
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            writer.write(str);
            writer.write("<Title ");
            String str2 = null;
            List list2 = null;
            for (Map.Entry entry : ((HashMap) it.next()).entrySet()) {
                String str3 = (String) entry.getKey();
                if (str3.equals("Title")) {
                    str2 = (String) entry.getValue();
                } else if (str3.equals("Kids")) {
                    list2 = (List) entry.getValue();
                } else {
                    writer.write(str3);
                    writer.write("=\"");
                    String str4 = (String) entry.getValue();
                    if (str3.equals("Named") || str3.equals("NamedN")) {
                        str4 = SimpleNamedDestination.escapeBinaryString(str4);
                    }
                    writer.write(SimpleXMLParser.escapeXML(str4, z));
                    writer.write("\" ");
                }
            }
            writer.write(">");
            if (str2 == null) {
                str2 = "";
            }
            writer.write(SimpleXMLParser.escapeXML(str2, z));
            if (list2 != null) {
                writer.write("\n");
                exportToXMLNode(list2, writer, i + 1, z);
                writer.write(str);
            }
            writer.write("</Title>\n");
        }
    }

    public static void exportToXML(List list, OutputStream outputStream, String str, boolean z) throws IOException {
        exportToXML(list, (Writer) new BufferedWriter(new OutputStreamWriter(outputStream, IanaEncodings.getJavaEncoding(str))), str, z);
    }

    public static void exportToXML(List list, Writer writer, String str, boolean z) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"");
        writer.write(SimpleXMLParser.escapeXML(str, z));
        writer.write("\"?>\n<Bookmark>\n");
        exportToXMLNode(list, writer, 1, z);
        writer.write("</Bookmark>\n");
        writer.flush();
    }

    public static List importFromXML(InputStream inputStream) throws IOException {
        SimpleBookmark simpleBookmark = new SimpleBookmark();
        SimpleXMLParser.parse((SimpleXMLDocHandler) simpleBookmark, inputStream);
        return simpleBookmark.topList;
    }

    public static List importFromXML(Reader reader) throws IOException {
        SimpleBookmark simpleBookmark = new SimpleBookmark();
        SimpleXMLParser.parse((SimpleXMLDocHandler) simpleBookmark, reader);
        return simpleBookmark.topList;
    }

    public void endElement(String str) {
        if (str.equals("Bookmark")) {
            if (!this.attr.isEmpty()) {
                throw new RuntimeException("Bookmark end tag out of place.");
            }
        } else if (str.equals("Title")) {
            HashMap hashMap = (HashMap) this.attr.pop();
            hashMap.put("Title", ((String) hashMap.get("Title")).trim());
            String str2 = (String) hashMap.get("Named");
            if (str2 != null) {
                hashMap.put("Named", SimpleNamedDestination.unEscapeBinaryString(str2));
            }
            String str3 = (String) hashMap.get("NamedN");
            if (str3 != null) {
                hashMap.put("NamedN", SimpleNamedDestination.unEscapeBinaryString(str3));
            }
            if (this.attr.isEmpty()) {
                this.topList.add(hashMap);
                return;
            }
            HashMap hashMap2 = (HashMap) this.attr.peek();
            List list = (List) hashMap2.get("Kids");
            if (list == null) {
                list = new ArrayList();
                hashMap2.put("Kids", list);
            }
            list.add(hashMap);
        } else {
            throw new RuntimeException("Invalid end tag - " + str);
        }
    }

    public void startElement(String str, HashMap hashMap) {
        if (this.topList == null) {
            if (str.equals("Bookmark")) {
                this.topList = new ArrayList();
                return;
            }
            throw new RuntimeException("Root element is not Bookmark: " + str);
        } else if (str.equals("Title")) {
            HashMap hashMap2 = new HashMap(hashMap);
            hashMap2.put("Title", "");
            hashMap2.remove("Kids");
            this.attr.push(hashMap2);
        } else {
            throw new RuntimeException("Tag " + str + " not allowed.");
        }
    }

    public void text(String str) {
        if (!this.attr.isEmpty()) {
            HashMap hashMap = (HashMap) this.attr.peek();
            hashMap.put("Title", String.valueOf((String) hashMap.get("Title")) + str);
        }
    }
}
