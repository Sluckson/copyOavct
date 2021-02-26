package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.pdf.XfaForm;
import com.lowagie.text.pdf.codec.Base64;
import harmony.java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.w3c.dom.Node;

public class AcroFields {
    public static final int DA_COLOR = 2;
    public static final int DA_FONT = 0;
    public static final int DA_SIZE = 1;
    public static final int FIELD_TYPE_CHECKBOX = 2;
    public static final int FIELD_TYPE_COMBO = 6;
    public static final int FIELD_TYPE_LIST = 5;
    public static final int FIELD_TYPE_NONE = 0;
    public static final int FIELD_TYPE_PUSHBUTTON = 1;
    public static final int FIELD_TYPE_RADIOBUTTON = 3;
    public static final int FIELD_TYPE_SIGNATURE = 7;
    public static final int FIELD_TYPE_TEXT = 4;
    private static final PdfName[] buttonRemove = {PdfName.f695MK, PdfName.f673F, PdfName.f675FF, PdfName.f714Q, PdfName.f651BS, PdfName.BORDER};
    private static final HashMap stdFieldFontNames = new HashMap();
    private boolean append;
    private HashMap extensionFonts = new HashMap();
    private float extraMarginLeft;
    private float extraMarginTop;
    private Map fieldCache;
    HashMap fields;
    private boolean generateAppearances = true;
    private boolean lastWasString;
    private HashMap localFonts = new HashMap();
    PdfReader reader;
    private HashMap sigNames;
    private ArrayList substitutionFonts;
    private int topFirst;
    private int totalRevisions;
    PdfWriter writer;
    private XfaForm xfa;

    AcroFields(PdfReader pdfReader, PdfWriter pdfWriter) {
        this.reader = pdfReader;
        this.writer = pdfWriter;
        try {
            this.xfa = new XfaForm(pdfReader);
            if (pdfWriter instanceof PdfStamperImp) {
                this.append = ((PdfStamperImp) pdfWriter).isAppend();
            }
            fill();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void fill() {
        PdfArray pdfArray;
        int i;
        this.fields = new HashMap();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(this.reader.getCatalog().get(PdfName.ACROFORM));
        if (pdfDictionary != null && (pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIELDS))) != null && pdfArray.size() != 0) {
            int i2 = 1;
            int i3 = 1;
            while (true) {
                if (i3 > this.reader.getNumberOfPages()) {
                    break;
                }
                PdfDictionary pageNRelease = this.reader.getPageNRelease(i3);
                PdfArray pdfArray2 = (PdfArray) PdfReader.getPdfObjectRelease(pageNRelease.get(PdfName.ANNOTS), pageNRelease);
                if (pdfArray2 != null) {
                    for (int i4 = 0; i4 < pdfArray2.size(); i4++) {
                        PdfDictionary asDict = pdfArray2.getAsDict(i4);
                        if (asDict == null) {
                            PdfReader.releaseLastXrefPartial(pdfArray2.getAsIndirectObject(i4));
                        } else if (!PdfName.WIDGET.equals(asDict.getAsName(PdfName.SUBTYPE))) {
                            PdfReader.releaseLastXrefPartial(pdfArray2.getAsIndirectObject(i4));
                        } else {
                            PdfDictionary pdfDictionary2 = new PdfDictionary();
                            pdfDictionary2.putAll(asDict);
                            String str = "";
                            PdfObject pdfObject = null;
                            PdfDictionary pdfDictionary3 = null;
                            PdfDictionary pdfDictionary4 = asDict;
                            while (pdfDictionary4 != null) {
                                pdfDictionary2.mergeDifferent(pdfDictionary4);
                                PdfString asString = pdfDictionary4.getAsString(PdfName.f723T);
                                if (asString != null) {
                                    str = String.valueOf(asString.toUnicodeString()) + "." + str;
                                }
                                if (pdfObject == null && pdfDictionary4.get(PdfName.f736V) != null) {
                                    pdfObject = PdfReader.getPdfObjectRelease(pdfDictionary4.get(PdfName.f736V));
                                }
                                if (pdfDictionary3 == null && asString != null) {
                                    if (pdfDictionary4.get(PdfName.f736V) == null && pdfObject != null) {
                                        pdfDictionary4.put(PdfName.f736V, pdfObject);
                                    }
                                    pdfDictionary3 = pdfDictionary4;
                                }
                                pdfDictionary4 = pdfDictionary4.getAsDict(PdfName.PARENT);
                                i2 = 1;
                            }
                            if (str.length() > 0) {
                                str = str.substring(0, str.length() - i2);
                            }
                            Item item = (Item) this.fields.get(str);
                            if (item == null) {
                                item = new Item();
                                this.fields.put(str, item);
                            }
                            if (pdfDictionary3 == null) {
                                item.addValue(asDict);
                            } else {
                                item.addValue(pdfDictionary3);
                            }
                            item.addWidget(asDict);
                            item.addWidgetRef(pdfArray2.getAsIndirectObject(i4));
                            if (pdfDictionary != null) {
                                pdfDictionary2.mergeDifferent(pdfDictionary);
                            }
                            item.addMerged(pdfDictionary2);
                            item.addPage(i3);
                            item.addTabOrder(i4);
                        }
                    }
                }
                i3++;
            }
            PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.SIGFLAGS);
            if (asNumber != null && (asNumber.intValue() & i2) == i2) {
                for (i = 0; i < pdfArray.size(); i++) {
                    PdfDictionary asDict2 = pdfArray.getAsDict(i);
                    if (asDict2 == null) {
                        PdfReader.releaseLastXrefPartial(pdfArray.getAsIndirectObject(i));
                    } else if (!PdfName.WIDGET.equals(asDict2.getAsName(PdfName.SUBTYPE))) {
                        PdfReader.releaseLastXrefPartial(pdfArray.getAsIndirectObject(i));
                    } else if (((PdfArray) PdfReader.getPdfObjectRelease(asDict2.get(PdfName.KIDS))) == null) {
                        PdfDictionary pdfDictionary5 = new PdfDictionary();
                        pdfDictionary5.putAll(asDict2);
                        PdfString asString2 = asDict2.getAsString(PdfName.f723T);
                        if (asString2 != null) {
                            String unicodeString = asString2.toUnicodeString();
                            if (!this.fields.containsKey(unicodeString)) {
                                Item item2 = new Item();
                                this.fields.put(unicodeString, item2);
                                item2.addValue(pdfDictionary5);
                                item2.addWidget(pdfDictionary5);
                                item2.addWidgetRef(pdfArray.getAsIndirectObject(i));
                                item2.addMerged(pdfDictionary5);
                                item2.addPage(-1);
                                item2.addTabOrder(-1);
                            }
                        }
                    }
                }
            }
        }
    }

    public String[] getAppearanceStates(String str) {
        PdfDictionary asDict;
        Item item = (Item) this.fields.get(str);
        if (item == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        PdfDictionary value = item.getValue(0);
        PdfString asString = value.getAsString(PdfName.OPT);
        if (asString != null) {
            hashMap.put(asString.toUnicodeString(), (Object) null);
        } else {
            PdfArray asArray = value.getAsArray(PdfName.OPT);
            if (asArray != null) {
                for (int i = 0; i < asArray.size(); i++) {
                    PdfString asString2 = asArray.getAsString(i);
                    if (asString2 != null) {
                        hashMap.put(asString2.toUnicodeString(), (Object) null);
                    }
                }
            }
        }
        for (int i2 = 0; i2 < item.size(); i2++) {
            PdfDictionary asDict2 = item.getWidget(i2).getAsDict(PdfName.f644AP);
            if (!(asDict2 == null || (asDict = asDict2.getAsDict(PdfName.f696N)) == null)) {
                for (PdfName pdfName : asDict.getKeys()) {
                    hashMap.put(PdfName.decodeName(pdfName.toString()), (Object) null);
                }
            }
        }
        return (String[]) hashMap.keySet().toArray(new String[hashMap.size()]);
    }

    private String[] getListOption(String str, int i) {
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return null;
        }
        PdfArray asArray = fieldItem.getMerged(0).getAsArray(PdfName.OPT);
        if (asArray == null) {
            return null;
        }
        String[] strArr = new String[asArray.size()];
        for (int i2 = 0; i2 < asArray.size(); i2++) {
            PdfObject directObject = asArray.getDirectObject(i2);
            try {
                if (directObject.isArray()) {
                    directObject = ((PdfArray) directObject).getDirectObject(i);
                }
                if (directObject.isString()) {
                    strArr[i2] = ((PdfString) directObject).toUnicodeString();
                } else {
                    strArr[i2] = directObject.toString();
                }
            } catch (Exception unused) {
                strArr[i2] = "";
            }
        }
        return strArr;
    }

    public String[] getListOptionExport(String str) {
        return getListOption(str, 0);
    }

    public String[] getListOptionDisplay(String str) {
        return getListOption(str, 1);
    }

    public boolean setListOption(String str, String[] strArr, String[] strArr2) {
        int i = 0;
        if (strArr == null && strArr2 == null) {
            return false;
        }
        if (strArr == null || strArr2 == null || strArr.length == strArr2.length) {
            int fieldType = getFieldType(str);
            if (fieldType != 6 && fieldType != 5) {
                return false;
            }
            Item item = (Item) this.fields.get(str);
            String[] strArr3 = null;
            if (strArr == null && strArr2 != null) {
                strArr3 = strArr2;
            } else if (strArr != null && strArr2 == null) {
                strArr3 = strArr;
            }
            PdfArray pdfArray = new PdfArray();
            if (strArr3 != null) {
                while (i < strArr3.length) {
                    pdfArray.add((PdfObject) new PdfString(strArr3[i], PdfObject.TEXT_UNICODE));
                    i++;
                }
            } else {
                while (i < strArr.length) {
                    PdfArray pdfArray2 = new PdfArray();
                    pdfArray2.add((PdfObject) new PdfString(strArr[i], PdfObject.TEXT_UNICODE));
                    pdfArray2.add((PdfObject) new PdfString(strArr2[i], PdfObject.TEXT_UNICODE));
                    pdfArray.add((PdfObject) pdfArray2);
                    i++;
                }
            }
            item.writeToAll(PdfName.OPT, pdfArray, 5);
            return true;
        }
        throw new IllegalArgumentException("The export and the display array must have the same size.");
    }

    public int getFieldType(String str) {
        PdfDictionary merged;
        PdfName asName;
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null || (asName = merged.getAsName(PdfName.f678FT)) == null) {
            return 0;
        }
        PdfNumber asNumber = (merged = fieldItem.getMerged(0)).getAsNumber(PdfName.f675FF);
        int intValue = asNumber != null ? asNumber.intValue() : 0;
        if (PdfName.BTN.equals(asName)) {
            if ((65536 & intValue) != 0) {
                return 1;
            }
            return (intValue & 32768) != 0 ? 3 : 2;
        } else if (PdfName.f732TX.equals(asName)) {
            return 4;
        } else {
            if (PdfName.f657CH.equals(asName)) {
                return (intValue & 131072) != 0 ? 6 : 5;
            }
            if (PdfName.SIG.equals(asName)) {
                return 7;
            }
            return 0;
        }
    }

    public void exportAsFdf(FdfWriter fdfWriter) {
        for (Map.Entry entry : this.fields.entrySet()) {
            String str = (String) entry.getKey();
            if (((Item) entry.getValue()).getMerged(0).get(PdfName.f736V) != null) {
                String field = getField(str);
                if (this.lastWasString) {
                    fdfWriter.setFieldAsString(str, field);
                } else {
                    fdfWriter.setFieldAsName(str, field);
                }
            }
        }
    }

    public boolean renameField(String str, String str2) {
        Item item;
        int lastIndexOf = str.lastIndexOf(46) + 1;
        int lastIndexOf2 = str2.lastIndexOf(46) + 1;
        if (lastIndexOf != lastIndexOf2 || !str.substring(0, lastIndexOf).equals(str2.substring(0, lastIndexOf2)) || this.fields.containsKey(str2) || (item = (Item) this.fields.get(str)) == null) {
            return false;
        }
        String substring = str2.substring(lastIndexOf2);
        item.writeToAll(PdfName.f723T, new PdfString(substring, PdfObject.TEXT_UNICODE), 5);
        item.markUsed(this, 4);
        this.fields.remove(str);
        this.fields.put(substring, item);
        return true;
    }

    public static Object[] splitDAelements(String str) {
        try {
            PRTokeniser pRTokeniser = new PRTokeniser(PdfEncodings.convertToBytes(str, (String) null));
            ArrayList arrayList = new ArrayList();
            Object[] objArr = new Object[3];
            while (pRTokeniser.nextToken()) {
                if (pRTokeniser.getTokenType() != 4) {
                    if (pRTokeniser.getTokenType() == 10) {
                        String stringValue = pRTokeniser.getStringValue();
                        if (stringValue.equals("Tf")) {
                            if (arrayList.size() >= 2) {
                                objArr[0] = arrayList.get(arrayList.size() - 2);
                                objArr[1] = new Float((String) arrayList.get(arrayList.size() - 1));
                            }
                        } else if (stringValue.equals("g")) {
                            if (arrayList.size() >= 1) {
                                float floatValue = new Float((String) arrayList.get(arrayList.size() - 1)).floatValue();
                                if (floatValue != 0.0f) {
                                    objArr[2] = new GrayColor(floatValue);
                                }
                            }
                        } else if (stringValue.equals("rg")) {
                            if (arrayList.size() >= 3) {
                                objArr[2] = new Color(new Float((String) arrayList.get(arrayList.size() - 3)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 2)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 1)).floatValue());
                            }
                        } else if (stringValue.equals("k") && arrayList.size() >= 4) {
                            objArr[2] = new CMYKColor(new Float((String) arrayList.get(arrayList.size() - 4)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 3)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 2)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 1)).floatValue());
                        }
                        arrayList.clear();
                    } else {
                        arrayList.add(pRTokeniser.getStringValue());
                    }
                }
            }
            return objArr;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX WARNING: type inference failed for: r4v32, types: [com.lowagie.text.pdf.PdfObject] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decodeGenericDictionary(com.lowagie.text.pdf.PdfDictionary r14, com.lowagie.text.pdf.BaseField r15) throws java.io.IOException, com.lowagie.text.DocumentException {
        /*
            r13 = this;
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f662DA
            com.lowagie.text.pdf.PdfString r0 = r14.getAsString(r0)
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x00fd
            java.lang.String r0 = r0.toUnicodeString()
            java.lang.Object[] r0 = splitDAelements(r0)
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0022
            r4 = r0[r3]
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r15.setFontSize(r4)
        L_0x0022:
            r4 = r0[r1]
            if (r4 == 0) goto L_0x002d
            r4 = r0[r1]
            harmony.java.awt.Color r4 = (harmony.java.awt.Color) r4
            r15.setTextColor(r4)
        L_0x002d:
            r4 = r0[r2]
            if (r4 == 0) goto L_0x00fd
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.f667DR
            com.lowagie.text.pdf.PdfDictionary r4 = r14.getAsDict(r4)
            if (r4 == 0) goto L_0x00fd
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.FONT
            com.lowagie.text.pdf.PdfDictionary r4 = r4.getAsDict(r5)
            if (r4 == 0) goto L_0x00fd
            com.lowagie.text.pdf.PdfName r5 = new com.lowagie.text.pdf.PdfName
            r6 = r0[r2]
            java.lang.String r6 = (java.lang.String) r6
            r5.<init>((java.lang.String) r6)
            com.lowagie.text.pdf.PdfObject r4 = r4.get(r5)
            if (r4 == 0) goto L_0x00cf
            int r5 = r4.type()
            r6 = 10
            if (r5 != r6) goto L_0x00cf
            r0 = r4
            com.lowagie.text.pdf.PRIndirectReference r0 = (com.lowagie.text.pdf.PRIndirectReference) r0
            com.lowagie.text.pdf.DocumentFont r5 = new com.lowagie.text.pdf.DocumentFont
            r5.<init>(r0)
            r15.setFont(r5)
            java.lang.Integer r5 = new java.lang.Integer
            int r0 = r0.getNumber()
            r5.<init>(r0)
            java.util.HashMap r0 = r13.extensionFonts
            java.lang.Object r0 = r0.get(r5)
            com.lowagie.text.pdf.BaseFont r0 = (com.lowagie.text.pdf.BaseFont) r0
            if (r0 != 0) goto L_0x00c4
            java.util.HashMap r6 = r13.extensionFonts
            boolean r6 = r6.containsKey(r5)
            if (r6 != 0) goto L_0x00c4
            com.lowagie.text.pdf.PdfObject r4 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r4)
            com.lowagie.text.pdf.PdfDictionary r4 = (com.lowagie.text.pdf.PdfDictionary) r4
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.FONTDESCRIPTOR
            com.lowagie.text.pdf.PdfDictionary r4 = r4.getAsDict(r6)
            if (r4 == 0) goto L_0x00c4
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.FONTFILE2
            com.lowagie.text.pdf.PdfObject r6 = r4.get(r6)
            com.lowagie.text.pdf.PdfObject r6 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r6)
            com.lowagie.text.pdf.PRStream r6 = (com.lowagie.text.pdf.PRStream) r6
            if (r6 != 0) goto L_0x00a7
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.FONTFILE3
            com.lowagie.text.pdf.PdfObject r4 = r4.get(r6)
            com.lowagie.text.pdf.PdfObject r4 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r4)
            r6 = r4
            com.lowagie.text.pdf.PRStream r6 = (com.lowagie.text.pdf.PRStream) r6
        L_0x00a7:
            if (r6 != 0) goto L_0x00b0
            java.util.HashMap r4 = r13.extensionFonts
            r6 = 0
            r4.put(r5, r6)
            goto L_0x00c4
        L_0x00b0:
            java.lang.String r7 = "font.ttf"
            java.lang.String r8 = "Identity-H"
            r9 = 1
            r10 = 0
            byte[] r11 = com.lowagie.text.pdf.PdfReader.getStreamBytes(r6)     // Catch:{ Exception -> 0x00bf }
            r12 = 0
            com.lowagie.text.pdf.BaseFont r0 = com.lowagie.text.pdf.BaseFont.createFont(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00bf }
        L_0x00bf:
            java.util.HashMap r4 = r13.extensionFonts
            r4.put(r5, r0)
        L_0x00c4:
            boolean r4 = r15 instanceof com.lowagie.text.pdf.TextField
            if (r4 == 0) goto L_0x00fd
            r4 = r15
            com.lowagie.text.pdf.TextField r4 = (com.lowagie.text.pdf.TextField) r4
            r4.setExtensionFont(r0)
            goto L_0x00fd
        L_0x00cf:
            java.util.HashMap r4 = r13.localFonts
            r5 = r0[r2]
            java.lang.Object r4 = r4.get(r5)
            com.lowagie.text.pdf.BaseFont r4 = (com.lowagie.text.pdf.BaseFont) r4
            if (r4 != 0) goto L_0x00fa
            java.util.HashMap r4 = stdFieldFontNames
            r0 = r0[r2]
            java.lang.Object r0 = r4.get(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 == 0) goto L_0x00fd
            java.lang.String r4 = "winansi"
            int r5 = r0.length     // Catch:{ Exception -> 0x00f8 }
            if (r5 <= r3) goto L_0x00ee
            r4 = r0[r3]     // Catch:{ Exception -> 0x00f8 }
        L_0x00ee:
            r0 = r0[r2]     // Catch:{ Exception -> 0x00f8 }
            com.lowagie.text.pdf.BaseFont r0 = com.lowagie.text.pdf.BaseFont.createFont(r0, r4, r2)     // Catch:{ Exception -> 0x00f8 }
            r15.setFont(r0)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00fd
        L_0x00f8:
            goto L_0x00fd
        L_0x00fa:
            r15.setFont(r4)
        L_0x00fd:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f695MK
            com.lowagie.text.pdf.PdfDictionary r0 = r14.getAsDict(r0)
            if (r0 == 0) goto L_0x0135
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.f647BC
            com.lowagie.text.pdf.PdfArray r4 = r0.getAsArray(r4)
            harmony.java.awt.Color r4 = r13.getMKColor(r4)
            r15.setBorderColor(r4)
            if (r4 == 0) goto L_0x0119
            r4 = 1065353216(0x3f800000, float:1.0)
            r15.setBorderWidth(r4)
        L_0x0119:
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.f648BG
            com.lowagie.text.pdf.PdfArray r4 = r0.getAsArray(r4)
            harmony.java.awt.Color r4 = r13.getMKColor(r4)
            r15.setBackgroundColor(r4)
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.f715R
            com.lowagie.text.pdf.PdfNumber r0 = r0.getAsNumber(r4)
            if (r0 == 0) goto L_0x0135
            int r0 = r0.intValue()
            r15.setRotation(r0)
        L_0x0135:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f673F
            com.lowagie.text.pdf.PdfNumber r0 = r14.getAsNumber(r0)
            r15.setVisibility(r1)
            r4 = 3
            if (r0 == 0) goto L_0x0160
            int r0 = r0.intValue()
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0151
            r6 = r0 & 2
            if (r6 == 0) goto L_0x0151
            r15.setVisibility(r3)
            goto L_0x0160
        L_0x0151:
            if (r5 == 0) goto L_0x015b
            r0 = r0 & 32
            if (r0 == 0) goto L_0x015b
            r15.setVisibility(r4)
            goto L_0x0160
        L_0x015b:
            if (r5 == 0) goto L_0x0160
            r15.setVisibility(r2)
        L_0x0160:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f675FF
            com.lowagie.text.pdf.PdfNumber r0 = r14.getAsNumber(r0)
            if (r0 == 0) goto L_0x016d
            int r0 = r0.intValue()
            goto L_0x016e
        L_0x016d:
            r0 = 0
        L_0x016e:
            r15.setOptions(r0)
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r5
            if (r0 == 0) goto L_0x0185
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.MAXLEN
            com.lowagie.text.pdf.PdfNumber r0 = r14.getAsNumber(r0)
            if (r0 == 0) goto L_0x0182
            int r2 = r0.intValue()
        L_0x0182:
            r15.setMaxCharacterLength(r2)
        L_0x0185:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f714Q
            com.lowagie.text.pdf.PdfNumber r0 = r14.getAsNumber(r0)
            if (r0 == 0) goto L_0x01a0
            int r2 = r0.intValue()
            if (r2 != r3) goto L_0x0197
            r15.setAlignment(r3)
            goto L_0x01a0
        L_0x0197:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x01a0
            r15.setAlignment(r1)
        L_0x01a0:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f651BS
            com.lowagie.text.pdf.PdfDictionary r0 = r14.getAsDict(r0)
            r2 = 4
            if (r0 == 0) goto L_0x01ee
            com.lowagie.text.pdf.PdfName r14 = com.lowagie.text.pdf.PdfName.f738W
            com.lowagie.text.pdf.PdfNumber r14 = r0.getAsNumber(r14)
            if (r14 == 0) goto L_0x01b8
            float r14 = r14.floatValue()
            r15.setBorderWidth(r14)
        L_0x01b8:
            com.lowagie.text.pdf.PdfName r14 = com.lowagie.text.pdf.PdfName.f719S
            com.lowagie.text.pdf.PdfName r14 = r0.getAsName(r14)
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f661D
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x01ca
            r15.setBorderStyle(r3)
            goto L_0x0210
        L_0x01ca:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f646B
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x01d6
            r15.setBorderStyle(r1)
            goto L_0x0210
        L_0x01d6:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f686I
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x01e2
            r15.setBorderStyle(r4)
            goto L_0x0210
        L_0x01e2:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.f733U
            boolean r14 = r0.equals(r14)
            if (r14 == 0) goto L_0x0210
            r15.setBorderStyle(r2)
            goto L_0x0210
        L_0x01ee:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.BORDER
            com.lowagie.text.pdf.PdfArray r14 = r14.getAsArray(r0)
            if (r14 == 0) goto L_0x0210
            int r0 = r14.size()
            if (r0 < r4) goto L_0x0207
            com.lowagie.text.pdf.PdfNumber r0 = r14.getAsNumber(r1)
            float r0 = r0.floatValue()
            r15.setBorderWidth(r0)
        L_0x0207:
            int r14 = r14.size()
            if (r14 < r2) goto L_0x0210
            r15.setBorderStyle(r3)
        L_0x0210:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.AcroFields.decodeGenericDictionary(com.lowagie.text.pdf.PdfDictionary, com.lowagie.text.pdf.BaseField):void");
    }

    /* access modifiers changed from: package-private */
    public PdfAppearance getAppearance(PdfDictionary pdfDictionary, String str, String str2) throws IOException, DocumentException {
        TextField textField;
        int i = 0;
        this.topFirst = 0;
        Map map = this.fieldCache;
        if (map == null || !map.containsKey(str2)) {
            TextField textField2 = new TextField(this.writer, (Rectangle) null, (String) null);
            textField2.setExtraMargin(this.extraMarginLeft, this.extraMarginTop);
            textField2.setBorderWidth(0.0f);
            textField2.setSubstitutionFonts(this.substitutionFonts);
            decodeGenericDictionary(pdfDictionary, textField2);
            Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.RECT));
            if (textField2.getRotation() == 90 || textField2.getRotation() == 270) {
                normalizedRectangle = normalizedRectangle.rotate();
            }
            textField2.setBox(normalizedRectangle);
            Map map2 = this.fieldCache;
            if (map2 != null) {
                map2.put(str2, textField2);
            }
            textField = textField2;
        } else {
            textField = (TextField) this.fieldCache.get(str2);
            textField.setWriter(this.writer);
        }
        PdfName asName = pdfDictionary.getAsName(PdfName.f678FT);
        if (PdfName.f732TX.equals(asName)) {
            textField.setText(str);
            return textField.getAppearance();
        } else if (PdfName.f657CH.equals(asName)) {
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.OPT);
            PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.f675FF);
            int intValue = (asNumber != null ? asNumber.intValue() : 0) & 131072;
            if (intValue == 0 || asArray != null) {
                if (asArray != null) {
                    String[] strArr = new String[asArray.size()];
                    String[] strArr2 = new String[asArray.size()];
                    for (int i2 = 0; i2 < asArray.size(); i2++) {
                        PdfObject pdfObject = asArray.getPdfObject(i2);
                        if (pdfObject.isString()) {
                            String unicodeString = ((PdfString) pdfObject).toUnicodeString();
                            strArr2[i2] = unicodeString;
                            strArr[i2] = unicodeString;
                        } else {
                            PdfArray pdfArray = (PdfArray) pdfObject;
                            strArr2[i2] = pdfArray.getAsString(0).toUnicodeString();
                            strArr[i2] = pdfArray.getAsString(1).toUnicodeString();
                        }
                    }
                    if (intValue != 0) {
                        while (true) {
                            if (i >= strArr.length) {
                                break;
                            } else if (str.equals(strArr2[i])) {
                                str = strArr[i];
                                break;
                            } else {
                                i++;
                            }
                        }
                        textField.setText(str);
                        return textField.getAppearance();
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= strArr2.length) {
                            i3 = 0;
                            break;
                        } else if (str.equals(strArr2[i3])) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    textField.setChoices(strArr);
                    textField.setChoiceExports(strArr2);
                    textField.setChoiceSelection(i3);
                }
                PdfAppearance listAppearance = textField.getListAppearance();
                this.topFirst = textField.getTopFirst();
                return listAppearance;
            }
            textField.setText(str);
            return textField.getAppearance();
        } else {
            throw new DocumentException("An appearance was requested without a variable text field.");
        }
    }

    /* access modifiers changed from: package-private */
    public Color getMKColor(PdfArray pdfArray) {
        if (pdfArray == null) {
            return null;
        }
        int size = pdfArray.size();
        if (size == 1) {
            return new GrayColor(pdfArray.getAsNumber(0).floatValue());
        }
        if (size == 3) {
            return new Color(ExtendedColor.normalize(pdfArray.getAsNumber(0).floatValue()), ExtendedColor.normalize(pdfArray.getAsNumber(1).floatValue()), ExtendedColor.normalize(pdfArray.getAsNumber(2).floatValue()));
        }
        if (size != 4) {
            return null;
        }
        return new CMYKColor(pdfArray.getAsNumber(0).floatValue(), pdfArray.getAsNumber(1).floatValue(), pdfArray.getAsNumber(2).floatValue(), pdfArray.getAsNumber(3).floatValue());
    }

    public String getField(String str) {
        if (this.xfa.isXfaPresent()) {
            String findFieldName = this.xfa.findFieldName(str, this);
            if (findFieldName == null) {
                return null;
            }
            return XfaForm.getNodeText(this.xfa.findDatasetsNode(XfaForm.Xml2Som.getShortName(findFieldName)));
        }
        Item item = (Item) this.fields.get(str);
        if (item == null) {
            return null;
        }
        this.lastWasString = false;
        PdfDictionary merged = item.getMerged(0);
        PdfObject pdfObject = PdfReader.getPdfObject(merged.get(PdfName.f736V));
        String str2 = "";
        if (pdfObject == null) {
            return str2;
        }
        if (pdfObject instanceof PRStream) {
            try {
                return new String(PdfReader.getStreamBytes((PRStream) pdfObject));
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            if (PdfName.BTN.equals(merged.getAsName(PdfName.f678FT))) {
                PdfNumber asNumber = merged.getAsNumber(PdfName.f675FF);
                if (((asNumber != null ? asNumber.intValue() : 0) & 65536) != 0) {
                    return str2;
                }
                if (pdfObject instanceof PdfName) {
                    str2 = PdfName.decodeName(pdfObject.toString());
                } else if (pdfObject instanceof PdfString) {
                    str2 = ((PdfString) pdfObject).toUnicodeString();
                }
                PdfArray asArray = item.getValue(0).getAsArray(PdfName.OPT);
                if (asArray == null) {
                    return str2;
                }
                try {
                    str2 = asArray.getAsString(Integer.parseInt(str2)).toUnicodeString();
                    this.lastWasString = true;
                    return str2;
                } catch (Exception unused) {
                    return str2;
                }
            } else if (!(pdfObject instanceof PdfString)) {
                return pdfObject instanceof PdfName ? PdfName.decodeName(pdfObject.toString()) : str2;
            } else {
                this.lastWasString = true;
                return ((PdfString) pdfObject).toUnicodeString();
            }
        }
    }

    public String[] getListSelection(String str) {
        String[] strArr;
        PdfArray asArray;
        String field = getField(str);
        int i = 0;
        if (field == null) {
            strArr = new String[0];
        } else {
            strArr = new String[]{field};
        }
        Item item = (Item) this.fields.get(str);
        if (item == null || (asArray = item.getMerged(0).getAsArray(PdfName.f686I)) == null) {
            return strArr;
        }
        String[] strArr2 = new String[asArray.size()];
        String[] listOptionExport = getListOptionExport(str);
        ListIterator listIterator = asArray.listIterator();
        while (listIterator.hasNext()) {
            strArr2[i] = listOptionExport[((PdfNumber) listIterator.next()).intValue()];
            i++;
        }
        return strArr2;
    }

    public boolean setFieldProperty(String str, String str2, Object obj, int[] iArr) {
        PdfString asString;
        PdfString asString2;
        FontDetails fontDetails;
        String str3 = str2;
        if (this.writer != null) {
            try {
                Item item = (Item) this.fields.get(str);
                if (item == null) {
                    return false;
                }
                InstHit instHit = new InstHit(iArr);
                if (str3.equalsIgnoreCase("textfont")) {
                    for (int i = 0; i < item.size(); i++) {
                        if (instHit.isHit(i)) {
                            PdfDictionary merged = item.getMerged(i);
                            PdfString asString3 = merged.getAsString(PdfName.f662DA);
                            PdfDictionary asDict = merged.getAsDict(PdfName.f667DR);
                            if (!(asString3 == null || asDict == null)) {
                                Object[] splitDAelements = splitDAelements(asString3.toUnicodeString());
                                PdfAppearance pdfAppearance = new PdfAppearance();
                                if (splitDAelements[0] != null) {
                                    BaseFont baseFont = (BaseFont) obj;
                                    PdfName pdfName = (PdfName) PdfAppearance.stdFieldFontNames.get(baseFont.getPostscriptFontName());
                                    if (pdfName == null) {
                                        pdfName = new PdfName(baseFont.getPostscriptFontName());
                                    }
                                    PdfDictionary asDict2 = asDict.getAsDict(PdfName.FONT);
                                    if (asDict2 == null) {
                                        asDict2 = new PdfDictionary();
                                        asDict.put(PdfName.FONT, asDict2);
                                    }
                                    PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) asDict2.get(pdfName);
                                    PdfDictionary asDict3 = this.reader.getCatalog().getAsDict(PdfName.ACROFORM);
                                    markUsed(asDict3);
                                    PdfDictionary asDict4 = asDict3.getAsDict(PdfName.f667DR);
                                    if (asDict4 == null) {
                                        asDict4 = new PdfDictionary();
                                        asDict3.put(PdfName.f667DR, asDict4);
                                    }
                                    markUsed(asDict4);
                                    PdfDictionary asDict5 = asDict4.getAsDict(PdfName.FONT);
                                    if (asDict5 == null) {
                                        asDict5 = new PdfDictionary();
                                        asDict4.put(PdfName.FONT, asDict5);
                                    }
                                    markUsed(asDict5);
                                    PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) asDict5.get(pdfName);
                                    if (pdfIndirectReference2 != null) {
                                        if (pdfIndirectReference == null) {
                                            asDict2.put(pdfName, pdfIndirectReference2);
                                        }
                                    } else if (pdfIndirectReference == null) {
                                        if (baseFont.getFontType() == 4) {
                                            fontDetails = new FontDetails((PdfName) null, ((DocumentFont) baseFont).getIndirectReference(), baseFont);
                                        } else {
                                            baseFont.setSubset(false);
                                            fontDetails = this.writer.addSimple(baseFont);
                                            this.localFonts.put(pdfName.toString().substring(1), baseFont);
                                        }
                                        asDict5.put(pdfName, fontDetails.getIndirectReference());
                                        asDict2.put(pdfName, fontDetails.getIndirectReference());
                                    }
                                    pdfAppearance.getInternalBuffer().append(pdfName.getBytes()).append(' ').append(((Float) splitDAelements[1]).floatValue()).append(" Tf ");
                                    if (splitDAelements[2] != null) {
                                        pdfAppearance.setColorFill((Color) splitDAelements[2]);
                                    }
                                    PdfString pdfString = new PdfString(pdfAppearance.toString());
                                    item.getMerged(i).put(PdfName.f662DA, pdfString);
                                    item.getWidget(i).put(PdfName.f662DA, pdfString);
                                    markUsed(item.getWidget(i));
                                }
                            }
                        }
                    }
                } else if (str3.equalsIgnoreCase("textcolor")) {
                    for (int i2 = 0; i2 < item.size(); i2++) {
                        if (instHit.isHit(i2) && (asString2 = item.getMerged(i2).getAsString(PdfName.f662DA)) != null) {
                            Object[] splitDAelements2 = splitDAelements(asString2.toUnicodeString());
                            PdfAppearance pdfAppearance2 = new PdfAppearance();
                            if (splitDAelements2[0] != null) {
                                pdfAppearance2.getInternalBuffer().append(new PdfName((String) splitDAelements2[0]).getBytes()).append(' ').append(((Float) splitDAelements2[1]).floatValue()).append(" Tf ");
                                pdfAppearance2.setColorFill((Color) obj);
                                PdfString pdfString2 = new PdfString(pdfAppearance2.toString());
                                item.getMerged(i2).put(PdfName.f662DA, pdfString2);
                                item.getWidget(i2).put(PdfName.f662DA, pdfString2);
                                markUsed(item.getWidget(i2));
                            }
                        }
                    }
                } else if (str3.equalsIgnoreCase("textsize")) {
                    for (int i3 = 0; i3 < item.size(); i3++) {
                        if (instHit.isHit(i3) && (asString = item.getMerged(i3).getAsString(PdfName.f662DA)) != null) {
                            Object[] splitDAelements3 = splitDAelements(asString.toUnicodeString());
                            PdfAppearance pdfAppearance3 = new PdfAppearance();
                            if (splitDAelements3[0] != null) {
                                pdfAppearance3.getInternalBuffer().append(new PdfName((String) splitDAelements3[0]).getBytes()).append(' ').append(((Float) obj).floatValue()).append(" Tf ");
                                if (splitDAelements3[2] != null) {
                                    pdfAppearance3.setColorFill((Color) splitDAelements3[2]);
                                }
                                PdfString pdfString3 = new PdfString(pdfAppearance3.toString());
                                item.getMerged(i3).put(PdfName.f662DA, pdfString3);
                                item.getWidget(i3).put(PdfName.f662DA, pdfString3);
                                markUsed(item.getWidget(i3));
                            }
                        }
                    }
                } else {
                    if (!str3.equalsIgnoreCase(HtmlTags.BACKGROUNDCOLOR)) {
                        if (!str3.equalsIgnoreCase("bordercolor")) {
                            return false;
                        }
                    }
                    PdfName pdfName2 = str3.equalsIgnoreCase(HtmlTags.BACKGROUNDCOLOR) ? PdfName.f648BG : PdfName.f647BC;
                    for (int i4 = 0; i4 < item.size(); i4++) {
                        if (instHit.isHit(i4)) {
                            PdfDictionary asDict6 = item.getMerged(i4).getAsDict(PdfName.f695MK);
                            if (asDict6 != null) {
                                markUsed(asDict6);
                            } else if (obj == null) {
                                return true;
                            } else {
                                asDict6 = new PdfDictionary();
                                item.getMerged(i4).put(PdfName.f695MK, asDict6);
                                item.getWidget(i4).put(PdfName.f695MK, asDict6);
                                markUsed(item.getWidget(i4));
                            }
                            if (obj == null) {
                                asDict6.remove(pdfName2);
                            } else {
                                asDict6.put(pdfName2, PdfFormField.getMKColor((Color) obj));
                            }
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new RuntimeException("This AcroFields instance is read-only.");
        }
    }

    public boolean setFieldProperty(String str, String str2, int i, int[] iArr) {
        if (this.writer != null) {
            Item item = (Item) this.fields.get(str);
            int i2 = 0;
            if (item == null) {
                return false;
            }
            InstHit instHit = new InstHit(iArr);
            if (str2.equalsIgnoreCase("flags")) {
                PdfNumber pdfNumber = new PdfNumber(i);
                while (i2 < item.size()) {
                    if (instHit.isHit(i2)) {
                        item.getMerged(i2).put(PdfName.f673F, pdfNumber);
                        item.getWidget(i2).put(PdfName.f673F, pdfNumber);
                        markUsed(item.getWidget(i2));
                    }
                    i2++;
                }
                return true;
            } else if (str2.equalsIgnoreCase("setflags")) {
                for (int i3 = 0; i3 < item.size(); i3++) {
                    if (instHit.isHit(i3)) {
                        PdfNumber asNumber = item.getWidget(i3).getAsNumber(PdfName.f673F);
                        PdfNumber pdfNumber2 = new PdfNumber((asNumber != null ? asNumber.intValue() : 0) | i);
                        item.getMerged(i3).put(PdfName.f673F, pdfNumber2);
                        item.getWidget(i3).put(PdfName.f673F, pdfNumber2);
                        markUsed(item.getWidget(i3));
                    }
                }
                return true;
            } else if (str2.equalsIgnoreCase("clrflags")) {
                for (int i4 = 0; i4 < item.size(); i4++) {
                    if (instHit.isHit(i4)) {
                        PdfDictionary widget = item.getWidget(i4);
                        PdfNumber asNumber2 = widget.getAsNumber(PdfName.f673F);
                        PdfNumber pdfNumber3 = new PdfNumber((asNumber2 != null ? asNumber2.intValue() : 0) & (~i));
                        item.getMerged(i4).put(PdfName.f673F, pdfNumber3);
                        widget.put(PdfName.f673F, pdfNumber3);
                        markUsed(widget);
                    }
                }
                return true;
            } else if (str2.equalsIgnoreCase("fflags")) {
                PdfNumber pdfNumber4 = new PdfNumber(i);
                while (i2 < item.size()) {
                    if (instHit.isHit(i2)) {
                        item.getMerged(i2).put(PdfName.f675FF, pdfNumber4);
                        item.getValue(i2).put(PdfName.f675FF, pdfNumber4);
                        markUsed(item.getValue(i2));
                    }
                    i2++;
                }
                return true;
            } else if (str2.equalsIgnoreCase("setfflags")) {
                for (int i5 = 0; i5 < item.size(); i5++) {
                    if (instHit.isHit(i5)) {
                        PdfDictionary value = item.getValue(i5);
                        PdfNumber asNumber3 = value.getAsNumber(PdfName.f675FF);
                        PdfNumber pdfNumber5 = new PdfNumber((asNumber3 != null ? asNumber3.intValue() : 0) | i);
                        item.getMerged(i5).put(PdfName.f675FF, pdfNumber5);
                        value.put(PdfName.f675FF, pdfNumber5);
                        markUsed(value);
                    }
                }
                return true;
            } else if (!str2.equalsIgnoreCase("clrfflags")) {
                return false;
            } else {
                for (int i6 = 0; i6 < item.size(); i6++) {
                    if (instHit.isHit(i6)) {
                        PdfDictionary value2 = item.getValue(i6);
                        PdfNumber asNumber4 = value2.getAsNumber(PdfName.f675FF);
                        PdfNumber pdfNumber6 = new PdfNumber((asNumber4 != null ? asNumber4.intValue() : 0) & (~i));
                        item.getMerged(i6).put(PdfName.f675FF, pdfNumber6);
                        value2.put(PdfName.f675FF, pdfNumber6);
                        markUsed(value2);
                    }
                }
                return true;
            }
        } else {
            throw new RuntimeException("This AcroFields instance is read-only.");
        }
    }

    public void mergeXfaData(Node node) throws IOException, DocumentException {
        XfaForm.Xml2SomDatasets xml2SomDatasets = new XfaForm.Xml2SomDatasets(node);
        Iterator it = xml2SomDatasets.getOrder().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            setField(str, XfaForm.getNodeText((Node) xml2SomDatasets.getName2Node().get(str)));
        }
    }

    public void setFields(FdfReader fdfReader) throws IOException, DocumentException {
        for (String str : fdfReader.getFields().keySet()) {
            String fieldValue = fdfReader.getFieldValue(str);
            if (fieldValue != null) {
                setField(str, fieldValue);
            }
        }
    }

    public void setFields(XfdfReader xfdfReader) throws IOException, DocumentException {
        for (String str : xfdfReader.getFields().keySet()) {
            String fieldValue = xfdfReader.getFieldValue(str);
            if (fieldValue != null) {
                setField(str, fieldValue);
            }
            List listValues = xfdfReader.getListValues(str);
            if (listValues != null) {
                setListSelection(fieldValue, (String[]) listValues.toArray(new String[listValues.size()]));
            }
        }
    }

    public boolean regenerateField(String str) throws IOException, DocumentException {
        String field = getField(str);
        return setField(str, field, field);
    }

    public boolean setField(String str, String str2) throws IOException, DocumentException {
        return setField(str, str2, (String) null);
    }

    public boolean setField(String str, String str2, String str3) throws IOException, DocumentException {
        PdfName pdfName;
        PdfName pdfName2;
        if (this.writer != null) {
            int i = 0;
            if (this.xfa.isXfaPresent()) {
                str = this.xfa.findFieldName(str, this);
                if (str == null) {
                    return false;
                }
                String shortName = XfaForm.Xml2Som.getShortName(str);
                Node findDatasetsNode = this.xfa.findDatasetsNode(shortName);
                if (findDatasetsNode == null) {
                    findDatasetsNode = this.xfa.getDatasetsSom().insertNode(this.xfa.getDatasetsNode(), shortName);
                }
                this.xfa.setNodeText(findDatasetsNode, str2);
            }
            Item item = (Item) this.fields.get(str);
            if (item == null) {
                return false;
            }
            PdfDictionary merged = item.getMerged(0);
            PdfName asName = merged.getAsName(PdfName.f678FT);
            if (PdfName.f732TX.equals(asName)) {
                PdfNumber asNumber = merged.getAsNumber(PdfName.MAXLEN);
                int intValue = asNumber != null ? asNumber.intValue() : 0;
                if (intValue > 0) {
                    str2 = str2.substring(0, Math.min(intValue, str2.length()));
                }
            }
            if (str3 == null) {
                str3 = str2;
            }
            if (PdfName.f732TX.equals(asName) || PdfName.f657CH.equals(asName)) {
                PdfString pdfString = new PdfString(str2, PdfObject.TEXT_UNICODE);
                while (i < item.size()) {
                    PdfDictionary value = item.getValue(i);
                    value.put(PdfName.f736V, pdfString);
                    value.remove(PdfName.f686I);
                    markUsed(value);
                    PdfDictionary merged2 = item.getMerged(i);
                    merged2.remove(PdfName.f686I);
                    merged2.put(PdfName.f736V, pdfString);
                    PdfDictionary widget = item.getWidget(i);
                    if (this.generateAppearances) {
                        PdfAppearance appearance = getAppearance(merged2, str3, str);
                        if (PdfName.f657CH.equals(asName)) {
                            PdfNumber pdfNumber = new PdfNumber(this.topFirst);
                            widget.put(PdfName.f727TI, pdfNumber);
                            merged2.put(PdfName.f727TI, pdfNumber);
                        }
                        PdfDictionary asDict = widget.getAsDict(PdfName.f644AP);
                        if (asDict == null) {
                            asDict = new PdfDictionary();
                            widget.put(PdfName.f644AP, asDict);
                            merged2.put(PdfName.f644AP, asDict);
                        }
                        asDict.put(PdfName.f696N, appearance.getIndirectReference());
                        this.writer.releaseTemplate(appearance);
                    } else {
                        widget.remove(PdfName.f644AP);
                        merged2.remove(PdfName.f644AP);
                    }
                    markUsed(widget);
                    i++;
                }
                return true;
            } else if (!PdfName.BTN.equals(asName)) {
                return false;
            } else {
                PdfNumber asNumber2 = item.getMerged(0).getAsNumber(PdfName.f675FF);
                if (((asNumber2 != null ? asNumber2.intValue() : 0) & 65536) != 0) {
                    try {
                        Image instance = Image.getInstance(Base64.decode(str2));
                        PushbuttonField newPushbuttonFromField = getNewPushbuttonFromField(str);
                        newPushbuttonFromField.setImage(instance);
                        replacePushbuttonField(str, newPushbuttonFromField.getField());
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                } else {
                    PdfName pdfName3 = new PdfName(str2);
                    ArrayList arrayList = new ArrayList();
                    PdfArray asArray = item.getValue(0).getAsArray(PdfName.OPT);
                    if (asArray != null) {
                        for (int i2 = 0; i2 < asArray.size(); i2++) {
                            PdfString asString = asArray.getAsString(i2);
                            if (asString != null) {
                                arrayList.add(asString.toUnicodeString());
                            } else {
                                arrayList.add((Object) null);
                            }
                        }
                    }
                    int indexOf = arrayList.indexOf(str2);
                    if (indexOf >= 0) {
                        pdfName2 = new PdfName(String.valueOf(indexOf));
                        pdfName = pdfName2;
                    } else {
                        pdfName = pdfName3;
                        pdfName2 = null;
                    }
                    while (i < item.size()) {
                        PdfDictionary merged3 = item.getMerged(i);
                        PdfDictionary widget2 = item.getWidget(i);
                        PdfDictionary value2 = item.getValue(i);
                        markUsed(item.getValue(i));
                        if (pdfName2 != null) {
                            PdfString pdfString2 = new PdfString(str2, PdfObject.TEXT_UNICODE);
                            value2.put(PdfName.f736V, pdfString2);
                            merged3.put(PdfName.f736V, pdfString2);
                        } else {
                            value2.put(PdfName.f736V, pdfName3);
                            merged3.put(PdfName.f736V, pdfName3);
                        }
                        markUsed(widget2);
                        if (isInAP(widget2, pdfName)) {
                            merged3.put(PdfName.f645AS, pdfName);
                            widget2.put(PdfName.f645AS, pdfName);
                        } else {
                            merged3.put(PdfName.f645AS, PdfName.Off);
                            widget2.put(PdfName.f645AS, PdfName.Off);
                        }
                        i++;
                    }
                    return true;
                }
            }
        } else {
            throw new DocumentException("This AcroFields instance is read-only.");
        }
    }

    public boolean setListSelection(String str, String[] strArr) throws IOException, DocumentException {
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return false;
        }
        if (!PdfName.f657CH.equals(fieldItem.getMerged(0).getAsName(PdfName.f678FT))) {
            return false;
        }
        String[] listOptionExport = getListOptionExport(str);
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < strArr.length; i++) {
            for (int i2 = 0; i2 < listOptionExport.length; i2++) {
                if (listOptionExport[i2].equals(strArr[i])) {
                    pdfArray.add((PdfObject) new PdfNumber(i2));
                }
            }
        }
        fieldItem.writeToAll(PdfName.f686I, pdfArray, 5);
        fieldItem.writeToAll(PdfName.f736V, (PdfObject) null, 5);
        fieldItem.writeToAll(PdfName.f644AP, (PdfObject) null, 3);
        fieldItem.markUsed(this, 6);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isInAP(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfDictionary asDict;
        PdfDictionary asDict2 = pdfDictionary.getAsDict(PdfName.f644AP);
        if (asDict2 == null || (asDict = asDict2.getAsDict(PdfName.f696N)) == null || asDict.get(pdfName) == null) {
            return false;
        }
        return true;
    }

    public HashMap getFields() {
        return this.fields;
    }

    public Item getFieldItem(String str) {
        if (!this.xfa.isXfaPresent() || (str = this.xfa.findFieldName(str, this)) != null) {
            return (Item) this.fields.get(str);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r1.xfa.findFieldName(r2, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTranslatedFieldName(java.lang.String r2) {
        /*
            r1 = this;
            com.lowagie.text.pdf.XfaForm r0 = r1.xfa
            boolean r0 = r0.isXfaPresent()
            if (r0 == 0) goto L_0x0011
            com.lowagie.text.pdf.XfaForm r0 = r1.xfa
            java.lang.String r0 = r0.findFieldName(r2, r1)
            if (r0 == 0) goto L_0x0011
            r2 = r0
        L_0x0011:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.AcroFields.getTranslatedFieldName(java.lang.String):java.lang.String");
    }

    public float[] getFieldPositions(String str) {
        int i;
        int i2;
        Rectangle rectangle;
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return null;
        }
        float[] fArr = new float[(fieldItem.size() * 5)];
        int i3 = 0;
        for (int i4 = 0; i4 < fieldItem.size(); i4++) {
            try {
                PdfArray asArray = fieldItem.getWidget(i4).getAsArray(PdfName.RECT);
                if (asArray != null) {
                    Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(asArray);
                    int intValue = fieldItem.getPage(i4).intValue();
                    int pageRotation = this.reader.getPageRotation(intValue);
                    i = i3 + 1;
                    try {
                        fArr[i3] = (float) intValue;
                        if (pageRotation != 0) {
                            Rectangle pageSize = this.reader.getPageSize(intValue);
                            if (pageRotation == 90) {
                                rectangle = new Rectangle(normalizedRectangle.getBottom(), pageSize.getRight() - normalizedRectangle.getLeft(), normalizedRectangle.getTop(), pageSize.getRight() - normalizedRectangle.getRight());
                            } else if (pageRotation == 180) {
                                rectangle = new Rectangle(pageSize.getRight() - normalizedRectangle.getLeft(), pageSize.getTop() - normalizedRectangle.getBottom(), pageSize.getRight() - normalizedRectangle.getRight(), pageSize.getTop() - normalizedRectangle.getTop());
                            } else if (pageRotation != 270) {
                                normalizedRectangle.normalize();
                            } else {
                                rectangle = new Rectangle(pageSize.getTop() - normalizedRectangle.getBottom(), normalizedRectangle.getLeft(), pageSize.getTop() - normalizedRectangle.getTop(), normalizedRectangle.getRight());
                            }
                            normalizedRectangle = rectangle;
                            normalizedRectangle.normalize();
                        }
                        i3 = i + 1;
                        fArr[i] = normalizedRectangle.getLeft();
                        i2 = i3 + 1;
                    } catch (Exception unused) {
                        i3 = i;
                    }
                    try {
                        fArr[i3] = normalizedRectangle.getBottom();
                        i3 = i2 + 1;
                        fArr[i2] = normalizedRectangle.getRight();
                        i2 = i3 + 1;
                        fArr[i3] = normalizedRectangle.getTop();
                        i3 = i2;
                    } catch (Exception unused2) {
                        i = i2;
                        i3 = i;
                    }
                }
            } catch (Exception unused3) {
                i = i3;
                i3 = i;
            }
        }
        if (i3 >= fArr.length) {
            return fArr;
        }
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, 0, fArr2, 0, i3);
        return fArr2;
    }

    private int removeRefFromArray(PdfArray pdfArray, PdfObject pdfObject) {
        if (pdfObject == null || !pdfObject.isIndirect()) {
            return pdfArray.size();
        }
        PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfObject;
        int i = 0;
        while (i < pdfArray.size()) {
            PdfObject pdfObject2 = pdfArray.getPdfObject(i);
            if (pdfObject2.isIndirect() && ((PdfIndirectReference) pdfObject2).getNumber() == pdfIndirectReference.getNumber()) {
                pdfArray.remove(i);
                i--;
            }
            i++;
        }
        return pdfArray.size();
    }

    public boolean removeFieldsFromPage(int i) {
        if (i < 1) {
            return false;
        }
        String[] strArr = new String[this.fields.size()];
        this.fields.keySet().toArray(strArr);
        boolean z = false;
        for (String removeField : strArr) {
            z = z || removeField(removeField, i);
        }
        return z;
    }

    public boolean removeField(String str, int i) {
        PdfDictionary pdfDictionary;
        PdfArray asArray;
        PdfIndirectReference asIndirectObject;
        Item fieldItem = getFieldItem(str);
        int i2 = 0;
        if (fieldItem == null || (pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(this.reader.getCatalog().get(PdfName.ACROFORM), this.reader.getCatalog())) == null || (asArray = pdfDictionary.getAsArray(PdfName.FIELDS)) == null) {
            return false;
        }
        while (i2 < fieldItem.size()) {
            int intValue = fieldItem.getPage(i2).intValue();
            if (i == -1 || i == intValue) {
                PdfIndirectReference widgetRef = fieldItem.getWidgetRef(i2);
                PdfDictionary widget = fieldItem.getWidget(i2);
                PdfDictionary pageN = this.reader.getPageN(intValue);
                PdfArray asArray2 = pageN.getAsArray(PdfName.ANNOTS);
                if (asArray2 != null) {
                    if (removeRefFromArray(asArray2, widgetRef) == 0) {
                        pageN.remove(PdfName.ANNOTS);
                        markUsed(pageN);
                    } else {
                        markUsed(asArray2);
                    }
                }
                PdfReader.killIndirect(widgetRef);
                while (true) {
                    asIndirectObject = widget.getAsIndirectObject(PdfName.PARENT);
                    if (asIndirectObject == null) {
                        break;
                    }
                    widget = widget.getAsDict(PdfName.PARENT);
                    if (removeRefFromArray(widget.getAsArray(PdfName.KIDS), widgetRef) != 0) {
                        break;
                    }
                    PdfReader.killIndirect(asIndirectObject);
                    widgetRef = asIndirectObject;
                }
                if (asIndirectObject == null) {
                    removeRefFromArray(asArray, widgetRef);
                    markUsed(asArray);
                }
                if (i != -1) {
                    fieldItem.remove(i2);
                    i2--;
                }
            }
            i2++;
        }
        if (i == -1 || fieldItem.size() == 0) {
            this.fields.remove(str);
        }
        return true;
    }

    public boolean removeField(String str) {
        return removeField(str, -1);
    }

    public boolean isGenerateAppearances() {
        return this.generateAppearances;
    }

    public void setGenerateAppearances(boolean z) {
        this.generateAppearances = z;
        PdfDictionary asDict = this.reader.getCatalog().getAsDict(PdfName.ACROFORM);
        if (z) {
            asDict.remove(PdfName.NEEDAPPEARANCES);
        } else {
            asDict.put(PdfName.NEEDAPPEARANCES, PdfBoolean.PDFTRUE);
        }
    }

    public static class Item {
        public static final int WRITE_MERGED = 1;
        public static final int WRITE_VALUE = 4;
        public static final int WRITE_WIDGET = 2;
        public ArrayList merged = new ArrayList();
        public ArrayList page = new ArrayList();
        public ArrayList tabOrder = new ArrayList();
        public ArrayList values = new ArrayList();
        public ArrayList widget_refs = new ArrayList();
        public ArrayList widgets = new ArrayList();

        public void writeToAll(PdfName pdfName, PdfObject pdfObject, int i) {
            if ((i & 1) != 0) {
                for (int i2 = 0; i2 < this.merged.size(); i2++) {
                    getMerged(i2).put(pdfName, pdfObject);
                }
            }
            if ((i & 2) != 0) {
                for (int i3 = 0; i3 < this.widgets.size(); i3++) {
                    getWidget(i3).put(pdfName, pdfObject);
                }
            }
            if ((i & 4) != 0) {
                for (int i4 = 0; i4 < this.values.size(); i4++) {
                    getValue(i4).put(pdfName, pdfObject);
                }
            }
        }

        public void markUsed(AcroFields acroFields, int i) {
            if ((i & 4) != 0) {
                for (int i2 = 0; i2 < size(); i2++) {
                    acroFields.markUsed(getValue(i2));
                }
            }
            if ((i & 2) != 0) {
                for (int i3 = 0; i3 < size(); i3++) {
                    acroFields.markUsed(getWidget(i3));
                }
            }
        }

        public int size() {
            return this.values.size();
        }

        /* access modifiers changed from: package-private */
        public void remove(int i) {
            this.values.remove(i);
            this.widgets.remove(i);
            this.widget_refs.remove(i);
            this.merged.remove(i);
            this.page.remove(i);
            this.tabOrder.remove(i);
        }

        public PdfDictionary getValue(int i) {
            return (PdfDictionary) this.values.get(i);
        }

        /* access modifiers changed from: package-private */
        public void addValue(PdfDictionary pdfDictionary) {
            this.values.add(pdfDictionary);
        }

        public PdfDictionary getWidget(int i) {
            return (PdfDictionary) this.widgets.get(i);
        }

        /* access modifiers changed from: package-private */
        public void addWidget(PdfDictionary pdfDictionary) {
            this.widgets.add(pdfDictionary);
        }

        public PdfIndirectReference getWidgetRef(int i) {
            return (PdfIndirectReference) this.widget_refs.get(i);
        }

        /* access modifiers changed from: package-private */
        public void addWidgetRef(PdfIndirectReference pdfIndirectReference) {
            this.widget_refs.add(pdfIndirectReference);
        }

        public PdfDictionary getMerged(int i) {
            return (PdfDictionary) this.merged.get(i);
        }

        /* access modifiers changed from: package-private */
        public void addMerged(PdfDictionary pdfDictionary) {
            this.merged.add(pdfDictionary);
        }

        public Integer getPage(int i) {
            return (Integer) this.page.get(i);
        }

        /* access modifiers changed from: package-private */
        public void addPage(int i) {
            this.page.add(new Integer(i));
        }

        /* access modifiers changed from: package-private */
        public void forcePage(int i, int i2) {
            this.page.set(i, new Integer(i2));
        }

        public Integer getTabOrder(int i) {
            return (Integer) this.tabOrder.get(i);
        }

        /* access modifiers changed from: package-private */
        public void addTabOrder(int i) {
            this.tabOrder.add(new Integer(i));
        }
    }

    private static class InstHit {
        IntHashtable hits;

        public InstHit(int[] iArr) {
            if (iArr != null) {
                this.hits = new IntHashtable();
                for (int put : iArr) {
                    this.hits.put(put, 1);
                }
            }
        }

        public boolean isHit(int i) {
            IntHashtable intHashtable = this.hits;
            if (intHashtable == null) {
                return true;
            }
            return intHashtable.containsKey(i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList getSignatureNames() {
        /*
            r9 = this;
            java.util.HashMap r0 = r9.sigNames
            if (r0 == 0) goto L_0x000e
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r0 = r0.keySet()
            r1.<init>(r0)
            return r1
        L_0x000e:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r9.sigNames = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap r1 = r9.fields
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0024:
            boolean r2 = r1.hasNext()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x008e
            com.lowagie.text.pdf.AcroFields$SorterComparator r1 = new com.lowagie.text.pdf.AcroFields$SorterComparator
            r2 = 0
            r1.<init>(r2)
            java.util.Collections.sort(r0, r1)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0082
            int r1 = r0.size()
            int r1 = r1 - r4
            java.lang.Object r1 = r0.get(r1)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r1 = r1[r4]
            int[] r1 = (int[]) r1
            r1 = r1[r3]
            com.lowagie.text.pdf.PdfReader r2 = r9.reader
            int r2 = r2.getFileLength()
            if (r1 != r2) goto L_0x005b
            int r1 = r0.size()
            r9.totalRevisions = r1
            goto L_0x0062
        L_0x005b:
            int r1 = r0.size()
            int r1 = r1 + r4
            r9.totalRevisions = r1
        L_0x0062:
            r1 = 0
        L_0x0063:
            int r2 = r0.size()
            if (r1 < r2) goto L_0x006a
            goto L_0x0082
        L_0x006a:
            java.lang.Object r2 = r0.get(r1)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r5 = r2[r3]
            java.lang.String r5 = (java.lang.String) r5
            r2 = r2[r4]
            int[] r2 = (int[]) r2
            int r1 = r1 + 1
            r2[r4] = r1
            java.util.HashMap r6 = r9.sigNames
            r6.put(r5, r2)
            goto L_0x0063
        L_0x0082:
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.HashMap r1 = r9.sigNames
            java.util.Set r1 = r1.keySet()
            r0.<init>(r1)
            return r0
        L_0x008e:
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r5 = r2.getValue()
            com.lowagie.text.pdf.AcroFields$Item r5 = (com.lowagie.text.pdf.AcroFields.Item) r5
            com.lowagie.text.pdf.PdfDictionary r5 = r5.getMerged(r3)
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.SIG
            com.lowagie.text.pdf.PdfName r7 = com.lowagie.text.pdf.PdfName.f678FT
            com.lowagie.text.pdf.PdfObject r7 = r5.get(r7)
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00ae
            goto L_0x0024
        L_0x00ae:
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.f736V
            com.lowagie.text.pdf.PdfDictionary r5 = r5.getAsDict(r6)
            if (r5 != 0) goto L_0x00b8
            goto L_0x0024
        L_0x00b8:
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.CONTENTS
            com.lowagie.text.pdf.PdfString r6 = r5.getAsString(r6)
            if (r6 != 0) goto L_0x00c2
            goto L_0x0024
        L_0x00c2:
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.BYTERANGE
            com.lowagie.text.pdf.PdfArray r5 = r5.getAsArray(r6)
            if (r5 != 0) goto L_0x00cc
            goto L_0x0024
        L_0x00cc:
            int r6 = r5.size()
            r7 = 2
            if (r6 >= r7) goto L_0x00d5
            goto L_0x0024
        L_0x00d5:
            int r8 = r6 + -1
            com.lowagie.text.pdf.PdfNumber r8 = r5.getAsNumber(r8)
            int r8 = r8.intValue()
            int r6 = r6 + -2
            com.lowagie.text.pdf.PdfNumber r5 = r5.getAsNumber(r6)
            int r5 = r5.intValue()
            int r8 = r8 + r5
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Object r2 = r2.getKey()
            r5[r3] = r2
            int[] r2 = new int[r7]
            r2[r3] = r8
            r5[r4] = r2
            r0.add(r5)
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.AcroFields.getSignatureNames():java.util.ArrayList");
    }

    public ArrayList getBlankSignatureNames() {
        getSignatureNames();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.fields.entrySet()) {
            if (PdfName.SIG.equals(((Item) entry.getValue()).getMerged(0).getAsName(PdfName.f678FT)) && !this.sigNames.containsKey(entry.getKey())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public PdfDictionary getSignatureDictionary(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (!this.sigNames.containsKey(translatedFieldName)) {
            return null;
        }
        return ((Item) this.fields.get(translatedFieldName)).getMerged(0).getAsDict(PdfName.f736V);
    }

    public boolean signatureCoversWholeDocument(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (this.sigNames.containsKey(translatedFieldName) && ((int[]) this.sigNames.get(translatedFieldName))[0] == this.reader.getFileLength()) {
            return true;
        }
        return false;
    }

    public PdfPKCS7 verifySignature(String str) {
        return verifySignature(str, (String) null);
    }

    public PdfPKCS7 verifySignature(String str, String str2) {
        PdfPKCS7 pdfPKCS7;
        PdfDictionary signatureDictionary = getSignatureDictionary(str);
        if (signatureDictionary == null) {
            return null;
        }
        try {
            PdfName asName = signatureDictionary.getAsName(PdfName.SUBFILTER);
            PdfString asString = signatureDictionary.getAsString(PdfName.CONTENTS);
            if (asName.equals(PdfName.ADBE_X509_RSA_SHA1)) {
                pdfPKCS7 = new PdfPKCS7(asString.getOriginalBytes(), signatureDictionary.getAsString(PdfName.CERT).getBytes(), str2);
            } else {
                pdfPKCS7 = new PdfPKCS7(asString.getOriginalBytes(), str2);
            }
            updateByteRange(pdfPKCS7, signatureDictionary);
            PdfString asString2 = signatureDictionary.getAsString(PdfName.f694M);
            if (asString2 != null) {
                pdfPKCS7.setSignDate(PdfDate.decode(asString2.toString()));
            }
            PdfObject pdfObject = PdfReader.getPdfObject(signatureDictionary.get(PdfName.NAME));
            if (pdfObject != null) {
                if (pdfObject.isString()) {
                    pdfPKCS7.setSignName(((PdfString) pdfObject).toUnicodeString());
                } else if (pdfObject.isName()) {
                    pdfPKCS7.setSignName(PdfName.decodeName(pdfObject.toString()));
                }
            }
            PdfString asString3 = signatureDictionary.getAsString(PdfName.REASON);
            if (asString3 != null) {
                pdfPKCS7.setReason(asString3.toUnicodeString());
            }
            PdfString asString4 = signatureDictionary.getAsString(PdfName.LOCATION);
            if (asString4 != null) {
                pdfPKCS7.setLocation(asString4.toUnicodeString());
            }
            return pdfPKCS7;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private void updateByteRange(PdfPKCS7 pdfPKCS7, PdfDictionary pdfDictionary) {
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.BYTERANGE);
        RandomAccessFileOrArray safeFile = this.reader.getSafeFile();
        try {
            safeFile.reOpen();
            byte[] bArr = new byte[8192];
            int i = 0;
            while (i < asArray.size()) {
                int intValue = asArray.getAsNumber(i).intValue();
                int i2 = i + 1;
                int intValue2 = asArray.getAsNumber(i2).intValue();
                safeFile.seek(intValue);
                while (true) {
                    if (intValue2 <= 0) {
                        break;
                    }
                    int read = safeFile.read(bArr, 0, Math.min(intValue2, bArr.length));
                    if (read <= 0) {
                        break;
                    }
                    intValue2 -= read;
                    pdfPKCS7.update(bArr, 0, read);
                }
                i = i2 + 1;
            }
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        } catch (Throwable th) {
            try {
                safeFile.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void markUsed(PdfObject pdfObject) {
        if (this.append) {
            ((PdfStamperImp) this.writer).markUsed(pdfObject);
        }
    }

    public int getTotalRevisions() {
        getSignatureNames();
        return this.totalRevisions;
    }

    public int getRevision(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (!this.sigNames.containsKey(translatedFieldName)) {
            return 0;
        }
        return ((int[]) this.sigNames.get(translatedFieldName))[1];
    }

    public InputStream extractRevision(String str) throws IOException {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (!this.sigNames.containsKey(translatedFieldName)) {
            return null;
        }
        int i = ((int[]) this.sigNames.get(translatedFieldName))[0];
        RandomAccessFileOrArray safeFile = this.reader.getSafeFile();
        safeFile.reOpen();
        safeFile.seek(0);
        return new RevisionStream(safeFile, i, (RevisionStream) null);
    }

    public Map getFieldCache() {
        return this.fieldCache;
    }

    public void setFieldCache(Map map) {
        this.fieldCache = map;
    }

    public void setExtraMargin(float f, float f2) {
        this.extraMarginLeft = f;
        this.extraMarginTop = f2;
    }

    public void addSubstitutionFont(BaseFont baseFont) {
        if (this.substitutionFonts == null) {
            this.substitutionFonts = new ArrayList();
        }
        this.substitutionFonts.add(baseFont);
    }

    static {
        stdFieldFontNames.put("CoBO", new String[]{"Courier-BoldOblique"});
        stdFieldFontNames.put("CoBo", new String[]{"Courier-Bold"});
        stdFieldFontNames.put("CoOb", new String[]{"Courier-Oblique"});
        stdFieldFontNames.put("Cour", new String[]{"Courier"});
        stdFieldFontNames.put("HeBO", new String[]{"Helvetica-BoldOblique"});
        stdFieldFontNames.put("HeBo", new String[]{"Helvetica-Bold"});
        stdFieldFontNames.put("HeOb", new String[]{"Helvetica-Oblique"});
        stdFieldFontNames.put("Helv", new String[]{"Helvetica"});
        stdFieldFontNames.put("Symb", new String[]{"Symbol"});
        stdFieldFontNames.put("TiBI", new String[]{"Times-BoldItalic"});
        stdFieldFontNames.put("TiBo", new String[]{"Times-Bold"});
        stdFieldFontNames.put("TiIt", new String[]{"Times-Italic"});
        stdFieldFontNames.put("TiRo", new String[]{"Times-Roman"});
        stdFieldFontNames.put("ZaDb", new String[]{"ZapfDingbats"});
        stdFieldFontNames.put("HySm", new String[]{AsianFontMapper.KoreanFont_SMyeongJo, AsianFontMapper.KoreanEncoding_H});
        stdFieldFontNames.put("HyGo", new String[]{AsianFontMapper.KoreanFont_GoThic, AsianFontMapper.KoreanEncoding_H});
        stdFieldFontNames.put("KaGo", new String[]{AsianFontMapper.JapaneseFont_Go, AsianFontMapper.KoreanEncoding_H});
        stdFieldFontNames.put("KaMi", new String[]{AsianFontMapper.JapaneseFont_Min, AsianFontMapper.JapaneseEncoding_H});
        stdFieldFontNames.put("MHei", new String[]{AsianFontMapper.ChineseTraditionalFont_MHei, AsianFontMapper.ChineseTraditionalEncoding_H});
        stdFieldFontNames.put("MSun", new String[]{AsianFontMapper.ChineseTraditionalFont_MSung, AsianFontMapper.ChineseTraditionalEncoding_H});
        stdFieldFontNames.put("STSo", new String[]{AsianFontMapper.ChineseSimplifiedFont, AsianFontMapper.ChineseSimplifiedEncoding_H});
    }

    private static class RevisionStream extends InputStream {

        /* renamed from: b */
        private byte[] f609b;
        private boolean closed;
        private int length;
        private RandomAccessFileOrArray raf;
        private int rangePosition;

        private RevisionStream(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
            this.f609b = new byte[1];
            this.rangePosition = 0;
            this.raf = randomAccessFileOrArray;
            this.length = i;
        }

        /* synthetic */ RevisionStream(RandomAccessFileOrArray randomAccessFileOrArray, int i, RevisionStream revisionStream) {
            this(randomAccessFileOrArray, i);
        }

        public int read() throws IOException {
            if (read(this.f609b) != 1) {
                return -1;
            }
            return this.f609b[0] & 255;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (bArr == null) {
                throw new NullPointerException();
            } else if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            } else if (i2 == 0) {
                return 0;
            } else {
                int i4 = this.rangePosition;
                int i5 = this.length;
                if (i4 >= i5) {
                    close();
                    return -1;
                }
                int min = Math.min(i2, i5 - i4);
                this.raf.readFully(bArr, i, min);
                this.rangePosition += min;
                return min;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.raf.close();
                this.closed = true;
            }
        }
    }

    private static class SorterComparator implements Comparator {
        private SorterComparator() {
        }

        /* synthetic */ SorterComparator(SorterComparator sorterComparator) {
            this();
        }

        public int compare(Object obj, Object obj2) {
            return ((int[]) ((Object[]) obj)[1])[0] - ((int[]) ((Object[]) obj2)[1])[0];
        }
    }

    public ArrayList getSubstitutionFonts() {
        return this.substitutionFonts;
    }

    public void setSubstitutionFonts(ArrayList arrayList) {
        this.substitutionFonts = arrayList;
    }

    public XfaForm getXfa() {
        return this.xfa;
    }

    public PushbuttonField getNewPushbuttonFromField(String str) {
        return getNewPushbuttonFromField(str, 0);
    }

    public PushbuttonField getNewPushbuttonFromField(String str, int i) {
        int i2;
        try {
            if (getFieldType(str) != 1) {
                return null;
            }
            Item fieldItem = getFieldItem(str);
            if (i >= fieldItem.size()) {
                return null;
            }
            int i3 = i * 5;
            float[] fieldPositions = getFieldPositions(str);
            PushbuttonField pushbuttonField = new PushbuttonField(this.writer, new Rectangle(fieldPositions[i3 + 1], fieldPositions[i3 + 2], fieldPositions[i3 + 3], fieldPositions[i3 + 4]), (String) null);
            PdfDictionary merged = fieldItem.getMerged(i);
            decodeGenericDictionary(merged, pushbuttonField);
            PdfDictionary asDict = merged.getAsDict(PdfName.f695MK);
            if (asDict != null) {
                PdfString asString = asDict.getAsString(PdfName.f655CA);
                if (asString != null) {
                    pushbuttonField.setText(asString.toUnicodeString());
                }
                PdfNumber asNumber = asDict.getAsNumber(PdfName.f730TP);
                if (asNumber != null) {
                    pushbuttonField.setLayout(asNumber.intValue() + 1);
                }
                PdfDictionary asDict2 = asDict.getAsDict(PdfName.f688IF);
                if (asDict2 != null) {
                    PdfName asName = asDict2.getAsName(PdfName.f722SW);
                    if (asName != null) {
                        if (asName.equals(PdfName.f646B)) {
                            i2 = 3;
                        } else if (asName.equals(PdfName.f719S)) {
                            i2 = 4;
                        } else {
                            i2 = asName.equals(PdfName.f696N) ? 2 : 1;
                        }
                        pushbuttonField.setScaleIcon(i2);
                    }
                    PdfName asName2 = asDict2.getAsName(PdfName.f719S);
                    if (asName2 != null && asName2.equals(PdfName.f641A)) {
                        pushbuttonField.setProportionalIcon(false);
                    }
                    PdfArray asArray = asDict2.getAsArray(PdfName.f641A);
                    if (asArray != null && asArray.size() == 2) {
                        float floatValue = asArray.getAsNumber(0).floatValue();
                        float floatValue2 = asArray.getAsNumber(1).floatValue();
                        pushbuttonField.setIconHorizontalAdjustment(floatValue);
                        pushbuttonField.setIconVerticalAdjustment(floatValue2);
                    }
                    PdfBoolean asBoolean = asDict2.getAsBoolean(PdfName.f674FB);
                    if (asBoolean != null && asBoolean.booleanValue()) {
                        pushbuttonField.setIconFitToBounds(true);
                    }
                }
                PdfObject pdfObject = asDict.get(PdfName.f686I);
                if (pdfObject != null && pdfObject.isIndirect()) {
                    pushbuttonField.setIconReference((PRIndirectReference) pdfObject);
                }
            }
            return pushbuttonField;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean replacePushbuttonField(String str, PdfFormField pdfFormField) {
        return replacePushbuttonField(str, pdfFormField, 0);
    }

    public boolean replacePushbuttonField(String str, PdfFormField pdfFormField, int i) {
        int i2 = 0;
        if (getFieldType(str) != 1) {
            return false;
        }
        Item fieldItem = getFieldItem(str);
        if (i >= fieldItem.size()) {
            return false;
        }
        PdfDictionary merged = fieldItem.getMerged(i);
        PdfDictionary value = fieldItem.getValue(i);
        PdfDictionary widget = fieldItem.getWidget(i);
        while (true) {
            PdfName[] pdfNameArr = buttonRemove;
            if (i2 >= pdfNameArr.length) {
                break;
            }
            merged.remove(pdfNameArr[i2]);
            value.remove(buttonRemove[i2]);
            widget.remove(buttonRemove[i2]);
            i2++;
        }
        for (PdfName pdfName : pdfFormField.getKeys()) {
            if (!pdfName.equals(PdfName.f723T) && !pdfName.equals(PdfName.RECT)) {
                if (pdfName.equals(PdfName.f675FF)) {
                    value.put(pdfName, pdfFormField.get(pdfName));
                } else {
                    widget.put(pdfName, pdfFormField.get(pdfName));
                }
                merged.put(pdfName, pdfFormField.get(pdfName));
            }
        }
        return true;
    }
}
