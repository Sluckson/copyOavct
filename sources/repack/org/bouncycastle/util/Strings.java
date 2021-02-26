package repack.org.bouncycastle.util;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.util.Vector;

public final class Strings {
    public static String fromUTF8ByteArray(byte[] bArr) {
        char c;
        int i;
        byte b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            i4++;
            if ((bArr[i3] & 240) == 240) {
                i4++;
                i3 += 4;
            } else if ((bArr[i3] & 224) == 224) {
                i3 += 3;
            } else {
                i3 = (bArr[i3] & 192) == 192 ? i3 + 2 : i3 + 1;
            }
        }
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i2 < bArr.length) {
            if ((bArr[i2] & 240) == 240) {
                int i6 = (((((bArr[i2] & 3) << 18) | ((bArr[i2 + 1] & 63) << 12)) | ((bArr[i2 + 2] & 63) << 6)) | (bArr[i2 + 3] & 63)) - 65536;
                c = (char) ((i6 & 1023) | 56320);
                cArr[i5] = (char) (55296 | (i6 >> 10));
                i2 += 4;
                i5++;
            } else if ((bArr[i2] & 224) == 224) {
                c = (char) (((bArr[i2] & 15) << 12) | ((bArr[i2 + 1] & 63) << 6) | (bArr[i2 + 2] & 63));
                i2 += 3;
            } else {
                if ((bArr[i2] & 208) == 208) {
                    i = (bArr[i2] & Ascii.f275US) << 6;
                    b = bArr[i2 + 1];
                } else if ((bArr[i2] & 192) == 192) {
                    i = (bArr[i2] & Ascii.f275US) << 6;
                    b = bArr[i2 + 1];
                } else {
                    c = (char) (bArr[i2] & 255);
                    i2++;
                }
                c = (char) (i | (b & 63));
                i2 += 2;
            }
            cArr[i5] = c;
            i5++;
        }
        return new String(cArr);
    }

    public static byte[] toUTF8ByteArray(String str) {
        return toUTF8ByteArray(str.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] cArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < cArr.length) {
            char c = cArr[i];
            if (c < 128) {
                byteArrayOutputStream.write(c);
            } else if (c < 2048) {
                byteArrayOutputStream.write((c >> 6) | PsExtractor.AUDIO_STREAM);
                byteArrayOutputStream.write((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                byteArrayOutputStream.write((c >> 12) | 224);
                byteArrayOutputStream.write(((c >> 6) & 63) | 128);
                byteArrayOutputStream.write((c & '?') | 128);
            } else {
                i++;
                if (i < cArr.length) {
                    char c2 = cArr[i];
                    if (c <= 56319) {
                        int i2 = (((c & 1023) << 10) | (c2 & 1023)) + 0;
                        byteArrayOutputStream.write((i2 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        byteArrayOutputStream.write(((i2 >> 12) & 63) | 128);
                        byteArrayOutputStream.write(((i2 >> 6) & 63) | 128);
                        byteArrayOutputStream.write((i2 & 63) | 128);
                    } else {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                } else {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) ((c - 'a') + 65);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) ((c - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static byte[] toByteArray(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static byte[] toByteArray(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static String[] split(String str, char c) {
        Vector vector = new Vector();
        boolean z = true;
        while (z) {
            int indexOf = str.indexOf(c);
            if (indexOf > 0) {
                vector.addElement(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        String[] strArr = new String[vector.size()];
        for (int i = 0; i != strArr.length; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }
}
