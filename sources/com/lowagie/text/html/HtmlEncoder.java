package com.lowagie.text.html;

import harmony.java.awt.Color;

public final class HtmlEncoder {
    private static final String[] htmlCode = new String[256];

    public static String getAlignment(int i) {
        switch (i) {
            case 0:
                return "Left";
            case 1:
                return "Center";
            case 2:
                return "Right";
            case 3:
            case 8:
                return "Justify";
            case 4:
                return "Top";
            case 5:
                return "Middle";
            case 6:
                return "Bottom";
            case 7:
                return "Baseline";
            default:
                return "";
        }
    }

    static {
        int i;
        int i2;
        for (int i3 = 0; i3 < 10; i3++) {
            String[] strArr = htmlCode;
            strArr[i3] = "&#00" + i3 + ";";
        }
        int i4 = 10;
        while (true) {
            i = 32;
            if (i4 >= 32) {
                break;
            }
            String[] strArr2 = htmlCode;
            strArr2[i4] = "&#0" + i4 + ";";
            i4++;
        }
        while (true) {
            if (i >= 128) {
                break;
            }
            htmlCode[i] = String.valueOf((char) i);
            i++;
        }
        String[] strArr3 = htmlCode;
        strArr3[9] = "\t";
        strArr3[10] = "<br />\n";
        strArr3[34] = "&quot;";
        strArr3[38] = "&amp;";
        strArr3[60] = "&lt;";
        strArr3[62] = "&gt;";
        for (i2 = 128; i2 < 256; i2++) {
            String[] strArr4 = htmlCode;
            strArr4[i2] = "&#" + i2 + ";";
        }
    }

    private HtmlEncoder() {
    }

    public static String encode(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < 256) {
                stringBuffer.append(htmlCode[charAt]);
            } else {
                stringBuffer.append("&#");
                stringBuffer.append(charAt);
                stringBuffer.append(';');
            }
        }
        return stringBuffer.toString();
    }

    public static String encode(Color color) {
        StringBuffer stringBuffer = new StringBuffer("#");
        if (color.getRed() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(color.getRed(), 16));
        if (color.getGreen() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(color.getGreen(), 16));
        if (color.getBlue() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(color.getBlue(), 16));
        return stringBuffer.toString();
    }
}
