package com.lowagie.text.pdf.hyphenation;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.xml.simpleparser.SimpleXMLDocHandler;
import com.lowagie.text.xml.simpleparser.SimpleXMLParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SimplePatternParser implements SimpleXMLDocHandler, PatternConsumer {
    static final int ELEM_CLASSES = 1;
    static final int ELEM_EXCEPTIONS = 2;
    static final int ELEM_HYPHEN = 4;
    static final int ELEM_PATTERNS = 3;
    PatternConsumer consumer;
    int currElement;
    ArrayList exception;
    char hyphenChar = '-';
    SimpleXMLParser parser;
    StringBuffer token = new StringBuffer();

    public void endDocument() {
    }

    public void startDocument() {
    }

    public void parse(InputStream inputStream, PatternConsumer patternConsumer) {
        this.consumer = patternConsumer;
        try {
            SimpleXMLParser.parse((SimpleXMLDocHandler) this, inputStream);
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
    }

    protected static String getPattern(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public ArrayList normalizeException(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof String) {
                String str = (String) obj;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (charAt != this.hyphenChar) {
                        stringBuffer.append(charAt);
                    } else {
                        arrayList2.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        arrayList2.add(new Hyphen(new String(new char[]{this.hyphenChar}), (String) null, (String) null));
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList2.add(stringBuffer.toString());
                }
            } else {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: protected */
    public String getExceptionWord(ArrayList arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof String) {
                stringBuffer.append((String) obj);
            } else {
                Hyphen hyphen = (Hyphen) obj;
                if (hyphen.noBreak != null) {
                    stringBuffer.append(hyphen.noBreak);
                }
            }
        }
        return stringBuffer.toString();
    }

    protected static String getInterletterValues(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = String.valueOf(str) + HtmlTags.ANCHOR;
        int length = str2.length();
        int i = 0;
        while (i < length) {
            char charAt = str2.charAt(i);
            if (Character.isDigit(charAt)) {
                stringBuffer.append(charAt);
                i++;
            } else {
                stringBuffer.append('0');
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public void endElement(String str) {
        if (this.token.length() > 0) {
            String stringBuffer = this.token.toString();
            int i = this.currElement;
            if (i == 1) {
                this.consumer.addClass(stringBuffer);
            } else if (i == 2) {
                this.exception.add(stringBuffer);
                this.exception = normalizeException(this.exception);
                this.consumer.addException(getExceptionWord(this.exception), (ArrayList) this.exception.clone());
            } else if (i == 3) {
                this.consumer.addPattern(getPattern(stringBuffer), getInterletterValues(stringBuffer));
            }
            if (this.currElement != 4) {
                this.token.setLength(0);
            }
        }
        if (this.currElement == 4) {
            this.currElement = 2;
        } else {
            this.currElement = 0;
        }
    }

    public void startElement(String str, HashMap hashMap) {
        if (str.equals("hyphen-char")) {
            String str2 = (String) hashMap.get("value");
            if (str2 != null && str2.length() == 1) {
                this.hyphenChar = str2.charAt(0);
            }
        } else if (str.equals("classes")) {
            this.currElement = 1;
        } else if (str.equals("patterns")) {
            this.currElement = 3;
        } else if (str.equals("exceptions")) {
            this.currElement = 2;
            this.exception = new ArrayList();
        } else if (str.equals("hyphen")) {
            if (this.token.length() > 0) {
                this.exception.add(this.token.toString());
            }
            this.exception.add(new Hyphen((String) hashMap.get(HtmlTags.PRE), (String) hashMap.get("no"), (String) hashMap.get("post")));
            this.currElement = 4;
        }
        this.token.setLength(0);
    }

    public void text(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int i = this.currElement;
            if (i == 1) {
                this.consumer.addClass(nextToken);
            } else if (i == 2) {
                this.exception.add(nextToken);
                this.exception = normalizeException(this.exception);
                this.consumer.addException(getExceptionWord(this.exception), (ArrayList) this.exception.clone());
                this.exception.clear();
            } else if (i == 3) {
                this.consumer.addPattern(getPattern(nextToken), getInterletterValues(nextToken));
            }
        }
    }

    public void addClass(String str) {
        PrintStream printStream = System.out;
        printStream.println("class: " + str);
    }

    public void addException(String str, ArrayList arrayList) {
        PrintStream printStream = System.out;
        printStream.println("exception: " + str + " : " + arrayList.toString());
    }

    public void addPattern(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println("pattern: " + str + " : " + str2);
    }

    public static void main(String[] strArr) throws Exception {
        try {
            if (strArr.length > 0) {
                SimplePatternParser simplePatternParser = new SimplePatternParser();
                simplePatternParser.parse(new FileInputStream(strArr[0]), simplePatternParser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
