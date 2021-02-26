package com.lowagie.text.pdf;

import com.lowagie.text.xml.simpleparser.SimpleXMLDocHandler;
import com.lowagie.text.xml.simpleparser.SimpleXMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class XfdfReader implements SimpleXMLDocHandler {
    private Stack fieldNames = new Stack();
    private Stack fieldValues = new Stack();
    HashMap fields;
    String fileSpec;
    private boolean foundRoot = false;
    protected HashMap listFields;

    public void endDocument() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[SYNTHETIC, Splitter:B:12:0x0027] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XfdfReader(java.lang.String r3) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.foundRoot = r0
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r2.fieldNames = r0
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r2.fieldValues = r0
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0024 }
            r1.<init>(r3)     // Catch:{ all -> 0x0024 }
            com.lowagie.text.xml.simpleparser.SimpleXMLParser.parse((com.lowagie.text.xml.simpleparser.SimpleXMLDocHandler) r2, (java.io.InputStream) r1)     // Catch:{ all -> 0x0021 }
            r1.close()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            return
        L_0x0021:
            r3 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0024:
            r3 = move-exception
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.XfdfReader.<init>(java.lang.String):void");
    }

    public XfdfReader(byte[] bArr) throws IOException {
        SimpleXMLParser.parse((SimpleXMLDocHandler) this, (InputStream) new ByteArrayInputStream(bArr));
    }

    public HashMap getFields() {
        return this.fields;
    }

    public String getField(String str) {
        return (String) this.fields.get(str);
    }

    public String getFieldValue(String str) {
        String str2 = (String) this.fields.get(str);
        if (str2 == null) {
            return null;
        }
        return str2;
    }

    public List getListValues(String str) {
        return (List) this.listFields.get(str);
    }

    public String getFileSpec() {
        return this.fileSpec;
    }

    public void startElement(String str, HashMap hashMap) {
        if (!this.foundRoot) {
            if (str.equals("xfdf")) {
                this.foundRoot = true;
            } else {
                throw new RuntimeException("Root element is not Bookmark.");
            }
        }
        if (str.equals("xfdf")) {
            return;
        }
        if (str.equals("f")) {
            this.fileSpec = (String) hashMap.get("href");
        } else if (str.equals("fields")) {
            this.fields = new HashMap();
            this.listFields = new HashMap();
        } else if (str.equals("field")) {
            this.fieldNames.push((String) hashMap.get("name"));
        } else if (str.equals("value")) {
            this.fieldValues.push("");
        }
    }

    public void endElement(String str) {
        if (str.equals("value")) {
            String str2 = "";
            for (int i = 0; i < this.fieldNames.size(); i++) {
                str2 = String.valueOf(str2) + "." + ((String) this.fieldNames.elementAt(i));
            }
            if (str2.startsWith(".")) {
                str2 = str2.substring(1);
            }
            String str3 = (String) this.fieldValues.pop();
            String str4 = (String) this.fields.put(str2, str3);
            if (str4 != null) {
                List list = (List) this.listFields.get(str2);
                if (list == null) {
                    list = new ArrayList();
                    list.add(str4);
                }
                list.add(str3);
                this.listFields.put(str2, list);
            }
        } else if (str.equals("field") && !this.fieldNames.isEmpty()) {
            this.fieldNames.pop();
        }
    }

    public void startDocument() {
        this.fileSpec = "";
    }

    public void text(String str) {
        if (!this.fieldNames.isEmpty() && !this.fieldValues.isEmpty()) {
            this.fieldValues.push(String.valueOf((String) this.fieldValues.pop()) + str);
        }
    }
}
