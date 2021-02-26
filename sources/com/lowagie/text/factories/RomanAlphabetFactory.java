package com.lowagie.text.factories;

public class RomanAlphabetFactory {
    public static final String getString(int i) {
        if (i >= 1) {
            int i2 = i - 1;
            int i3 = 0;
            int i4 = 26;
            int i5 = 1;
            while (true) {
                int i6 = i4 + i3;
                if (i2 < i6) {
                    break;
                }
                i5++;
                i4 *= 26;
                i3 = i6;
            }
            int i7 = i2 - i3;
            char[] cArr = new char[i5];
            while (i5 > 0) {
                i5--;
                cArr[i5] = (char) ((i7 % 26) + 97);
                i7 /= 26;
            }
            return new String(cArr);
        }
        throw new NumberFormatException("You can't translate a negative number into an alphabetical value.");
    }

    public static final String getLowerCaseString(int i) {
        return getString(i);
    }

    public static final String getUpperCaseString(int i) {
        return getString(i).toUpperCase();
    }

    public static final String getString(int i, boolean z) {
        if (z) {
            return getLowerCaseString(i);
        }
        return getUpperCaseString(i);
    }

    public static void main(String[] strArr) {
        for (int i = 1; i < 32000; i++) {
            System.out.println(getString(i));
        }
    }
}
