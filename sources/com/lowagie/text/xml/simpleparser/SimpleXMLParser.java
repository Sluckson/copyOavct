package com.lowagie.text.xml.simpleparser;

import com.lowagie.text.xml.xmp.XmpWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Stack;

public final class SimpleXMLParser {
    private static final int ATTRIBUTE_EQUAL = 13;
    private static final int ATTRIBUTE_KEY = 12;
    private static final int ATTRIBUTE_VALUE = 14;
    private static final int CDATA = 7;
    private static final int COMMENT = 8;
    private static final int ENTITY = 10;
    private static final int EXAMIN_TAG = 3;
    private static final int IN_CLOSETAG = 5;

    /* renamed from: PI */
    private static final int f810PI = 9;
    private static final int QUOTE = 11;
    private static final int SINGLE_TAG = 6;
    private static final int TAG_ENCOUNTERED = 2;
    private static final int TAG_EXAMINED = 4;
    private static final int TEXT = 1;
    private static final int UNKNOWN = 0;
    String attributekey = null;
    HashMap attributes = null;
    String attributevalue = null;
    int character = 0;
    int columns = 0;
    SimpleXMLDocHandlerComment comment;
    SimpleXMLDocHandler doc;
    StringBuffer entity = new StringBuffer();
    boolean eol = false;
    boolean html;
    int lines = 1;
    int nested = 0;
    boolean nowhite = false;
    int previousCharacter = -1;
    int quoteCharacter = 34;
    Stack stack;
    int state;
    String tag = null;
    StringBuffer text = new StringBuffer();

    private SimpleXMLParser(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, boolean z) {
        this.doc = simpleXMLDocHandler;
        this.comment = simpleXMLDocHandlerComment;
        this.html = z;
        this.stack = new Stack();
        this.state = z ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0012, code lost:
        continue;
     */
    /* renamed from: go */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m393go(java.io.Reader r15) throws java.io.IOException {
        /*
            r14 = this;
            boolean r0 = r15 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0007
            java.io.BufferedReader r15 = (java.io.BufferedReader) r15
            goto L_0x000d
        L_0x0007:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r0.<init>(r15)
            r15 = r0
        L_0x000d:
            com.lowagie.text.xml.simpleparser.SimpleXMLDocHandler r0 = r14.doc
            r0.startDocument()
        L_0x0012:
            int r0 = r14.previousCharacter
            r1 = -1
            if (r0 != r1) goto L_0x001e
            int r0 = r15.read()
            r14.character = r0
            goto L_0x0022
        L_0x001e:
            r14.character = r0
            r14.previousCharacter = r1
        L_0x0022:
            int r0 = r14.character
            r2 = 1
            if (r0 != r1) goto L_0x0040
            boolean r15 = r14.html
            if (r15 == 0) goto L_0x003a
            if (r15 == 0) goto L_0x0034
            int r15 = r14.state
            if (r15 != r2) goto L_0x0034
            r14.flush()
        L_0x0034:
            com.lowagie.text.xml.simpleparser.SimpleXMLDocHandler r15 = r14.doc
            r15.endDocument()
            goto L_0x003f
        L_0x003a:
            java.lang.String r15 = "Missing end tag"
            r14.throwException(r15)
        L_0x003f:
            return
        L_0x0040:
            r1 = 10
            r3 = 0
            if (r0 != r1) goto L_0x004c
            boolean r0 = r14.eol
            if (r0 == 0) goto L_0x004c
            r14.eol = r3
            goto L_0x0012
        L_0x004c:
            boolean r0 = r14.eol
            r4 = 13
            if (r0 == 0) goto L_0x0055
            r14.eol = r3
            goto L_0x0074
        L_0x0055:
            int r0 = r14.character
            if (r0 != r1) goto L_0x0061
            int r0 = r14.lines
            int r0 = r0 + r2
            r14.lines = r0
            r14.columns = r3
            goto L_0x0074
        L_0x0061:
            if (r0 != r4) goto L_0x006f
            r14.eol = r2
            r14.character = r1
            int r0 = r14.lines
            int r0 = r0 + r2
            r14.lines = r0
            r14.columns = r3
            goto L_0x0074
        L_0x006f:
            int r0 = r14.columns
            int r0 = r0 + r2
            r14.columns = r0
        L_0x0074:
            int r0 = r14.state
            r5 = 61
            r6 = 60
            r7 = 4
            r8 = 6
            r9 = 38
            r10 = 2
            r11 = 47
            r12 = 32
            r13 = 62
            switch(r0) {
                case 0: goto L_0x0469;
                case 1: goto L_0x0428;
                case 2: goto L_0x0404;
                case 3: goto L_0x037b;
                case 4: goto L_0x034e;
                case 5: goto L_0x0322;
                case 6: goto L_0x02e4;
                case 7: goto L_0x02b3;
                case 8: goto L_0x0282;
                case 9: goto L_0x0270;
                case 10: goto L_0x01ed;
                case 11: goto L_0x0170;
                case 12: goto L_0x0130;
                case 13: goto L_0x00d9;
                case 14: goto L_0x0089;
                default: goto L_0x0088;
            }
        L_0x0088:
            goto L_0x0012
        L_0x0089:
            int r0 = r14.character
            r1 = 34
            if (r0 == r1) goto L_0x00cf
            r1 = 39
            if (r0 != r1) goto L_0x0094
            goto L_0x00cf
        L_0x0094:
            char r0 = (char) r0
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 != 0) goto L_0x0012
            boolean r0 = r14.html
            if (r0 == 0) goto L_0x00b4
            int r0 = r14.character
            if (r0 != r13) goto L_0x00b4
            r14.flush()
            r14.processTag(r2)
            r14.initTag()
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x00b4:
            boolean r0 = r14.html
            if (r0 == 0) goto L_0x00c8
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            r14.quoteCharacter = r12
            r0 = 11
            r14.state = r0
            goto L_0x0012
        L_0x00c8:
            java.lang.String r0 = "Error in attribute processing"
            r14.throwException(r0)
            goto L_0x0012
        L_0x00cf:
            int r0 = r14.character
            r14.quoteCharacter = r0
            r0 = 11
            r14.state = r0
            goto L_0x0012
        L_0x00d9:
            int r0 = r14.character
            if (r0 != r5) goto L_0x00e3
            r0 = 14
            r14.state = r0
            goto L_0x0012
        L_0x00e3:
            char r0 = (char) r0
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 != 0) goto L_0x0012
            boolean r0 = r14.html
            if (r0 == 0) goto L_0x0105
            int r0 = r14.character
            if (r0 != r13) goto L_0x0105
            java.lang.StringBuffer r0 = r14.text
            r0.setLength(r3)
            r14.processTag(r2)
            r14.initTag()
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x0105:
            boolean r0 = r14.html
            if (r0 == 0) goto L_0x0114
            int r0 = r14.character
            if (r0 != r11) goto L_0x0114
            r14.flush()
            r14.state = r8
            goto L_0x0012
        L_0x0114:
            boolean r0 = r14.html
            if (r0 == 0) goto L_0x0129
            r14.flush()
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            r0 = 12
            r14.state = r0
            goto L_0x0012
        L_0x0129:
            java.lang.String r0 = "Error in attribute processing."
            r14.throwException(r0)
            goto L_0x0012
        L_0x0130:
            int r0 = r14.character
            char r0 = (char) r0
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x0140
            r14.flush()
            r14.state = r4
            goto L_0x0012
        L_0x0140:
            int r0 = r14.character
            if (r0 != r5) goto L_0x014d
            r14.flush()
            r0 = 14
            r14.state = r0
            goto L_0x0012
        L_0x014d:
            boolean r1 = r14.html
            if (r1 == 0) goto L_0x0166
            if (r0 != r13) goto L_0x0166
            java.lang.StringBuffer r0 = r14.text
            r0.setLength(r3)
            r14.processTag(r2)
            r14.initTag()
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x0166:
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0012
        L_0x0170:
            boolean r0 = r14.html
            if (r0 == 0) goto L_0x018d
            int r0 = r14.quoteCharacter
            if (r0 != r12) goto L_0x018d
            int r0 = r14.character
            if (r0 != r13) goto L_0x018d
            r14.flush()
            r14.processTag(r2)
            r14.initTag()
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x018d:
            boolean r0 = r14.html
            if (r0 == 0) goto L_0x01a5
            int r0 = r14.quoteCharacter
            if (r0 != r12) goto L_0x01a5
            int r0 = r14.character
            char r0 = (char) r0
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x01a5
            r14.flush()
            r14.state = r7
            goto L_0x0012
        L_0x01a5:
            boolean r0 = r14.html
            if (r0 == 0) goto L_0x01b7
            int r0 = r14.quoteCharacter
            if (r0 != r12) goto L_0x01b7
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0012
        L_0x01b7:
            int r0 = r14.character
            int r2 = r14.quoteCharacter
            if (r0 != r2) goto L_0x01c4
            r14.flush()
            r14.state = r7
            goto L_0x0012
        L_0x01c4:
            java.lang.String r2 = " \r\n\t"
            int r0 = r2.indexOf(r0)
            if (r0 < 0) goto L_0x01d3
            java.lang.StringBuffer r0 = r14.text
            r0.append(r12)
            goto L_0x0012
        L_0x01d3:
            int r0 = r14.character
            if (r0 != r9) goto L_0x01e5
            int r0 = r14.state
            r14.saveState(r0)
            r14.state = r1
            java.lang.StringBuffer r0 = r14.entity
            r0.setLength(r3)
            goto L_0x0012
        L_0x01e5:
            java.lang.StringBuffer r1 = r14.text
            char r0 = (char) r0
            r1.append(r0)
            goto L_0x0012
        L_0x01ed:
            int r0 = r14.character
            r1 = 59
            if (r0 != r1) goto L_0x021e
            int r0 = r14.restoreState()
            r14.state = r0
            java.lang.StringBuffer r0 = r14.entity
            java.lang.String r0 = r0.toString()
            java.lang.StringBuffer r2 = r14.entity
            r2.setLength(r3)
            char r2 = com.lowagie.text.xml.simpleparser.EntitiesToUnicode.decodeEntity(r0)
            if (r2 != 0) goto L_0x0217
            java.lang.StringBuffer r2 = r14.text
            r2.append(r9)
            r2.append(r0)
            r2.append(r1)
            goto L_0x0012
        L_0x0217:
            java.lang.StringBuffer r0 = r14.text
            r0.append(r2)
            goto L_0x0012
        L_0x021e:
            r1 = 35
            if (r0 == r1) goto L_0x023e
            r1 = 48
            if (r0 < r1) goto L_0x022a
            r1 = 57
            if (r0 <= r1) goto L_0x023e
        L_0x022a:
            int r0 = r14.character
            r1 = 97
            if (r0 < r1) goto L_0x0234
            r1 = 122(0x7a, float:1.71E-43)
            if (r0 <= r1) goto L_0x023e
        L_0x0234:
            int r0 = r14.character
            r1 = 65
            if (r0 < r1) goto L_0x0247
            r1 = 90
            if (r0 > r1) goto L_0x0247
        L_0x023e:
            java.lang.StringBuffer r0 = r14.entity
            int r0 = r0.length()
            r1 = 7
            if (r0 < r1) goto L_0x0266
        L_0x0247:
            int r0 = r14.restoreState()
            r14.state = r0
            int r0 = r14.character
            r14.previousCharacter = r0
            java.lang.StringBuffer r0 = r14.text
            r0.append(r9)
            java.lang.StringBuffer r1 = r14.entity
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.StringBuffer r0 = r14.entity
            r0.setLength(r3)
            goto L_0x0012
        L_0x0266:
            java.lang.StringBuffer r0 = r14.entity
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0012
        L_0x0270:
            int r0 = r14.character
            if (r0 != r13) goto L_0x0012
            int r0 = r14.restoreState()
            r14.state = r0
            int r0 = r14.state
            if (r0 != r2) goto L_0x0012
            r14.state = r3
            goto L_0x0012
        L_0x0282:
            int r0 = r14.character
            if (r0 != r13) goto L_0x02a9
            java.lang.StringBuffer r0 = r14.text
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "--"
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto L_0x02a9
            java.lang.StringBuffer r0 = r14.text
            int r1 = r0.length()
            int r1 = r1 - r10
            r0.setLength(r1)
            r14.flush()
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x02a9:
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0012
        L_0x02b3:
            int r0 = r14.character
            if (r0 != r13) goto L_0x02da
            java.lang.StringBuffer r0 = r14.text
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "]]"
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto L_0x02da
            java.lang.StringBuffer r0 = r14.text
            int r1 = r0.length()
            int r1 = r1 - r10
            r0.setLength(r1)
            r14.flush()
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x02da:
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0012
        L_0x02e4:
            int r0 = r14.character
            if (r0 == r13) goto L_0x0300
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Expected > for tag: <"
            r0.<init>(r1)
            java.lang.String r1 = r14.tag
            r0.append(r1)
            java.lang.String r1 = "/>"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.throwException(r0)
        L_0x0300:
            r14.doTag()
            r14.processTag(r2)
            r14.processTag(r3)
            r14.initTag()
            boolean r0 = r14.html
            if (r0 != 0) goto L_0x031a
            int r0 = r14.nested
            if (r0 != 0) goto L_0x031a
            com.lowagie.text.xml.simpleparser.SimpleXMLDocHandler r15 = r14.doc
            r15.endDocument()
            return
        L_0x031a:
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x0322:
            int r0 = r14.character
            if (r0 != r13) goto L_0x033d
            r14.doTag()
            r14.processTag(r3)
            boolean r0 = r14.html
            if (r0 != 0) goto L_0x0335
            int r0 = r14.nested
            if (r0 != 0) goto L_0x0335
            return
        L_0x0335:
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x033d:
            char r0 = (char) r0
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 != 0) goto L_0x0012
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0012
        L_0x034e:
            int r0 = r14.character
            if (r0 != r13) goto L_0x0360
            r14.processTag(r2)
            r14.initTag()
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x0360:
            if (r0 != r11) goto L_0x0366
            r14.state = r8
            goto L_0x0012
        L_0x0366:
            char r0 = (char) r0
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 != 0) goto L_0x0012
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            r0 = 12
            r14.state = r0
            goto L_0x0012
        L_0x037b:
            int r0 = r14.character
            if (r0 != r13) goto L_0x0390
            r14.doTag()
            r14.processTag(r2)
            r14.initTag()
            int r0 = r14.restoreState()
            r14.state = r0
            goto L_0x0012
        L_0x0390:
            if (r0 != r11) goto L_0x0396
            r14.state = r8
            goto L_0x0012
        L_0x0396:
            r1 = 45
            if (r0 != r1) goto L_0x03b1
            java.lang.StringBuffer r0 = r14.text
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "!-"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x03b1
            r14.flush()
            r0 = 8
            r14.state = r0
            goto L_0x0012
        L_0x03b1:
            int r0 = r14.character
            r1 = 91
            if (r0 != r1) goto L_0x03cd
            java.lang.StringBuffer r0 = r14.text
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "![CDATA"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x03cd
            r14.flush()
            r0 = 7
            r14.state = r0
            goto L_0x0012
        L_0x03cd:
            int r0 = r14.character
            r1 = 69
            if (r0 != r1) goto L_0x03ea
            java.lang.StringBuffer r0 = r14.text
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "!DOCTYP"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x03ea
            r14.flush()
            r0 = 9
            r14.state = r0
            goto L_0x0012
        L_0x03ea:
            int r0 = r14.character
            char r0 = (char) r0
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x03fa
            r14.doTag()
            r14.state = r7
            goto L_0x0012
        L_0x03fa:
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0012
        L_0x0404:
            r14.initTag()
            int r0 = r14.character
            if (r0 != r11) goto L_0x0410
            r0 = 5
            r14.state = r0
            goto L_0x0012
        L_0x0410:
            r1 = 63
            if (r0 != r1) goto L_0x041d
            r14.restoreState()
            r0 = 9
            r14.state = r0
            goto L_0x0012
        L_0x041d:
            java.lang.StringBuffer r1 = r14.text
            char r0 = (char) r0
            r1.append(r0)
            r0 = 3
            r14.state = r0
            goto L_0x0012
        L_0x0428:
            int r4 = r14.character
            if (r4 != r6) goto L_0x0438
            r14.flush()
            int r0 = r14.state
            r14.saveState(r0)
            r14.state = r10
            goto L_0x0012
        L_0x0438:
            if (r4 != r9) goto L_0x0446
            r14.saveState(r0)
            java.lang.StringBuffer r0 = r14.entity
            r0.setLength(r3)
            r14.state = r1
            goto L_0x0012
        L_0x0446:
            char r0 = (char) r4
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x045d
            boolean r0 = r14.nowhite
            if (r0 == 0) goto L_0x0459
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
        L_0x0459:
            r14.nowhite = r3
            goto L_0x0012
        L_0x045d:
            java.lang.StringBuffer r0 = r14.text
            int r1 = r14.character
            char r1 = (char) r1
            r0.append(r1)
            r14.nowhite = r2
            goto L_0x0012
        L_0x0469:
            int r0 = r14.character
            if (r0 != r6) goto L_0x0012
            r14.saveState(r2)
            r14.state = r10
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.xml.simpleparser.SimpleXMLParser.m393go(java.io.Reader):void");
    }

    private int restoreState() {
        if (!this.stack.empty()) {
            return ((Integer) this.stack.pop()).intValue();
        }
        return 0;
    }

    private void saveState(int i) {
        this.stack.push(new Integer(i));
    }

    private void flush() {
        int i = this.state;
        if (i != 1) {
            if (i != 14) {
                if (i != 7) {
                    if (i == 8) {
                        SimpleXMLDocHandlerComment simpleXMLDocHandlerComment = this.comment;
                        if (simpleXMLDocHandlerComment != null) {
                            simpleXMLDocHandlerComment.comment(this.text.toString());
                        }
                    } else if (i != 11) {
                        if (i == 12) {
                            this.attributekey = this.text.toString();
                            if (this.html) {
                                this.attributekey = this.attributekey.toLowerCase();
                            }
                        }
                    }
                    this.text.setLength(0);
                }
            }
            this.attributevalue = this.text.toString();
            this.attributes.put(this.attributekey, this.attributevalue);
            this.text.setLength(0);
        }
        if (this.text.length() > 0) {
            this.doc.text(this.text.toString());
        }
        this.text.setLength(0);
    }

    private void initTag() {
        this.tag = null;
        this.attributes = new HashMap();
    }

    private void doTag() {
        if (this.tag == null) {
            this.tag = this.text.toString();
        }
        if (this.html) {
            this.tag = this.tag.toLowerCase();
        }
        this.text.setLength(0);
    }

    private void processTag(boolean z) {
        if (z) {
            this.nested++;
            this.doc.startElement(this.tag, this.attributes);
            return;
        }
        this.nested--;
        this.doc.endElement(this.tag);
    }

    private void throwException(String str) throws IOException {
        throw new IOException(String.valueOf(str) + " near line " + this.lines + ", column " + this.columns);
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, Reader reader, boolean z) throws IOException {
        new SimpleXMLParser(simpleXMLDocHandler, simpleXMLDocHandlerComment, z).m393go(reader);
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, InputStream inputStream) throws IOException {
        String declaredEncoding;
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr) == 4) {
            String encodingName = getEncodingName(bArr);
            String str = null;
            if (encodingName.equals("UTF-8")) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = inputStream.read();
                    if (!(read == -1 || read == 62)) {
                        stringBuffer.append((char) read);
                    }
                }
                str = stringBuffer.toString();
            } else if (encodingName.equals("CP037")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read2 = inputStream.read();
                    if (!(read2 == -1 || read2 == 110)) {
                        byteArrayOutputStream.write(read2);
                    }
                }
                str = new String(byteArrayOutputStream.toByteArray(), "CP037");
            }
            if (!(str == null || (declaredEncoding = getDeclaredEncoding(str)) == null)) {
                encodingName = declaredEncoding;
            }
            parse(simpleXMLDocHandler, (Reader) new InputStreamReader(inputStream, IanaEncodings.getJavaEncoding(encodingName)));
            return;
        }
        throw new IOException("Insufficient length.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getDeclaredEncoding(java.lang.String r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "encoding"
            int r1 = r5.indexOf(r1)
            if (r1 >= 0) goto L_0x000d
            return r0
        L_0x000d:
            r2 = 34
            int r3 = r5.indexOf(r2, r1)
            r4 = 39
            int r1 = r5.indexOf(r4, r1)
            if (r3 != r1) goto L_0x001c
            return r0
        L_0x001c:
            if (r3 >= 0) goto L_0x0020
            if (r1 > 0) goto L_0x0024
        L_0x0020:
            if (r1 <= 0) goto L_0x0032
            if (r1 >= r3) goto L_0x0032
        L_0x0024:
            int r1 = r1 + 1
            int r2 = r5.indexOf(r4, r1)
            if (r2 >= 0) goto L_0x002d
            return r0
        L_0x002d:
            java.lang.String r5 = r5.substring(r1, r2)
            return r5
        L_0x0032:
            if (r1 >= 0) goto L_0x0036
            if (r3 > 0) goto L_0x003a
        L_0x0036:
            if (r3 <= 0) goto L_0x0048
            if (r3 >= r1) goto L_0x0048
        L_0x003a:
            int r3 = r3 + 1
            int r1 = r5.indexOf(r2, r3)
            if (r1 >= 0) goto L_0x0043
            return r0
        L_0x0043:
            java.lang.String r5 = r5.substring(r3, r1)
            return r5
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.xml.simpleparser.SimpleXMLParser.getDeclaredEncoding(java.lang.String):java.lang.String");
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, Reader reader) throws IOException {
        parse(simpleXMLDocHandler, (SimpleXMLDocHandlerComment) null, reader, false);
    }

    public static String escapeXML(String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c == '\"') {
                stringBuffer.append("&quot;");
            } else if (c == '<') {
                stringBuffer.append("&lt;");
            } else if (c == '>') {
                stringBuffer.append("&gt;");
            } else if (c == '&') {
                stringBuffer.append("&amp;");
            } else if (c == '\'') {
                stringBuffer.append("&apos;");
            } else if (c == 9 || c == 10 || c == 13 || ((c >= ' ' && c <= 55295) || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535)))) {
                if (!z || c <= 127) {
                    stringBuffer.append((char) c);
                } else {
                    stringBuffer.append("&#");
                    stringBuffer.append(c);
                    stringBuffer.append(';');
                }
            }
        }
        return stringBuffer.toString();
    }

    private static String getEncodingName(byte[] bArr) {
        byte b = bArr[0] & 255;
        byte b2 = bArr[1] & 255;
        if (b == 254 && b2 == 255) {
            return XmpWriter.UTF16BE;
        }
        if (b == 255 && b2 == 254) {
            return "UTF-16LE";
        }
        byte b3 = bArr[2] & 255;
        if (b == 239 && b2 == 187 && b3 == 191) {
            return "UTF-8";
        }
        byte b4 = bArr[3] & 255;
        if (b == 0 && b2 == 0 && b3 == 0 && b4 == 60) {
            return "ISO-10646-UCS-4";
        }
        if (b == 60 && b2 == 0 && b3 == 0 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 0 && b3 == 60 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 60 && b3 == 0 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 60 && b3 == 0 && b4 == 63) {
            return XmpWriter.UTF16BE;
        }
        if (b == 60 && b2 == 0 && b3 == 63 && b4 == 0) {
            return "UTF-16LE";
        }
        if (b == 76 && b2 == 111 && b3 == 167 && b4 == 148) {
            return "CP037";
        }
        return "UTF-8";
    }
}
