package com.wowza.gocoder.sdk.support.wmstransport.p041a;

import com.google.common.base.Ascii;
import com.lowagie.text.DocWriter;
import com.lowagie.text.pdf.ByteBuffer;
import com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.a.a */
/* compiled from: GoCoderSDK */
public class C4303a {

    /* renamed from: a */
    public static final int f4370a = 0;

    /* renamed from: b */
    public static final int f4371b = 1;

    /* renamed from: c */
    public static final int f4372c = 0;

    /* renamed from: d */
    public static final int f4373d = 2;

    /* renamed from: e */
    public static final int f4374e = 8;

    /* renamed from: f */
    public static final int f4375f = 16;

    /* renamed from: g */
    public static final int f4376g = 32;

    /* renamed from: h */
    private static final int f4377h = 76;

    /* renamed from: i */
    private static final byte f4378i = 61;

    /* renamed from: j */
    private static final byte f4379j = 10;

    /* renamed from: k */
    private static final String f4380k = "UTF-8";

    /* renamed from: l */
    private static final byte f4381l = -5;

    /* renamed from: m */
    private static final byte f4382m = -1;

    /* renamed from: n */
    private static final byte[] f4383n = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, DocWriter.FORWARD};

    /* renamed from: o */
    private static final byte[] f4384o = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f4381l, f4381l, -9, -9, f4381l, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f4381l, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.f569GT, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, DocWriter.f570LT, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.f264EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.f266FS, Ascii.f267GS, Ascii.f271RS, Ascii.f275US, 32, AMFData.DATA_TYPE_BYTEARRAY, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, -9, -9, -9, -9};

    /* renamed from: p */
    private static final byte[] f4385p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: q */
    private static final byte[] f4386q = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f4381l, f4381l, -9, -9, f4381l, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f4381l, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.f569GT, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, DocWriter.f570LT, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.f264EM, -9, -9, -9, -9, 63, -9, Ascii.SUB, Ascii.ESC, Ascii.f266FS, Ascii.f267GS, Ascii.f271RS, Ascii.f275US, 32, AMFData.DATA_TYPE_BYTEARRAY, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, -9, -9, -9, -9};

    /* renamed from: r */
    private static final byte[] f4387r = {45, ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: s */
    private static final byte[] f4388s = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f4381l, f4381l, -9, -9, f4381l, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f4381l, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.f264EM, Ascii.SUB, Ascii.ESC, Ascii.f266FS, Ascii.f267GS, Ascii.f271RS, Ascii.f275US, 32, AMFData.DATA_TYPE_BYTEARRAY, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, DocWriter.f570LT, 61, DocWriter.f569GT, 63, -9, -9, -9, -9};

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final byte[] m4242c(int i) {
        if ((i & 16) == 16) {
            return f4385p;
        }
        if ((i & 32) == 32) {
            return f4387r;
        }
        return f4383n;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final byte[] m4245d(int i) {
        if ((i & 16) == 16) {
            return f4386q;
        }
        if ((i & 32) == 32) {
            return f4388s;
        }
        return f4384o;
    }

    private C4303a() {
    }

    /* renamed from: a */
    public static final void m4226a(String[] strArr) {
        if (strArr.length < 2) {
            m4248g("Not enough arguments.");
            return;
        }
        String str = strArr[0];
        if (str.equals("-es")) {
            m4246e(strArr[1]);
        } else if (str.equals("-ds")) {
            m4247f(strArr[1]);
        } else if (str.equals("-e")) {
            m4236b(strArr[1], strArr[2]);
        } else if (str.equals("-d")) {
            m4241c(strArr[1], strArr[2]);
        } else {
            m4248g("Unknown flag: " + str);
        }
    }

    /* renamed from: g */
    private static final void m4248g(String str) {
        System.err.println(str);
        System.err.println("Usage: java Base64 -e|-d inputfile outputfile");
        System.err.println("       java Base64 -es string");
        System.err.println("       java Base64 -ds string");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m4240b(byte[] bArr, byte[] bArr2, int i, int i2) {
        m4239b(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m4239b(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] c = m4242c(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << Ascii.CAN) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = c[i7 >>> 18];
            bArr2[i3 + 1] = c[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = c[i7 >>> 18];
            bArr2[i3 + 1] = c[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = c[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = c[i7 >>> 18];
            bArr2[i3 + 1] = c[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = c[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = c[i7 & 63];
            return bArr2;
        }
    }

    /* renamed from: a */
    public static String m4220a(Serializable serializable) {
        return m4221a(serializable, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:47|48|49|50|51|52|53|54|55|56|57) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:59|60|61|62|63|64|65|66|67|68|69) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:18|19|20|21|22|23|24|25|26|27|28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0051, code lost:
        return new java.lang.String(r2.toByteArray());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0033 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0036 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0074 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0084 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0087 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x008a */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4221a(java.io.Serializable r5, int r6) {
        /*
            r0 = r6 & 2
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0069, all -> 0x0064 }
            r2.<init>()     // Catch:{ IOException -> 0x0069, all -> 0x0064 }
            com.wowza.gocoder.sdk.support.wmstransport.a.a$b r3 = new com.wowza.gocoder.sdk.support.wmstransport.a.a$b     // Catch:{ IOException -> 0x005f, all -> 0x005b }
            r6 = r6 | 1
            r3.<init>(r2, r6)     // Catch:{ IOException -> 0x005f, all -> 0x005b }
            r6 = 2
            if (r0 != r6) goto L_0x0027
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x002d
        L_0x0020:
            r5 = move-exception
            goto L_0x0081
        L_0x0023:
            r5 = move-exception
            r0 = r6
            r6 = r1
            goto L_0x006e
        L_0x0027:
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r0 = r1
        L_0x002d:
            r6.writeObject(r5)     // Catch:{ IOException -> 0x0052 }
            r6.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            r3.close()     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            r2.close()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0048 }
            byte[] r6 = r2.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x0048 }
            java.lang.String r0 = "UTF-8"
            r5.<init>(r6, r0)     // Catch:{ UnsupportedEncodingException -> 0x0048 }
            return r5
        L_0x0048:
            java.lang.String r5 = new java.lang.String
            byte[] r6 = r2.toByteArray()
            r5.<init>(r6)
            return r5
        L_0x0052:
            r5 = move-exception
            goto L_0x006e
        L_0x0054:
            r5 = move-exception
            r6 = r1
            goto L_0x0081
        L_0x0057:
            r5 = move-exception
            r6 = r1
            r0 = r6
            goto L_0x006e
        L_0x005b:
            r5 = move-exception
            r6 = r1
            r3 = r6
            goto L_0x0081
        L_0x005f:
            r5 = move-exception
            r6 = r1
            r0 = r6
            r3 = r0
            goto L_0x006e
        L_0x0064:
            r5 = move-exception
            r6 = r1
            r2 = r6
            r3 = r2
            goto L_0x0081
        L_0x0069:
            r5 = move-exception
            r6 = r1
            r0 = r6
            r2 = r0
            r3 = r2
        L_0x006e:
            r5.printStackTrace()     // Catch:{ all -> 0x007e }
            r6.close()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r0.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r3.close()     // Catch:{ Exception -> 0x007a }
        L_0x007a:
            r2.close()     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            return r1
        L_0x007e:
            r5 = move-exception
            r1 = r6
            r6 = r0
        L_0x0081:
            r1.close()     // Catch:{ Exception -> 0x0084 }
        L_0x0084:
            r6.close()     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            r3.close()     // Catch:{ Exception -> 0x008a }
        L_0x008a:
            r2.close()     // Catch:{ Exception -> 0x008d }
        L_0x008d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4221a(java.io.Serializable, int):java.lang.String");
    }

    /* renamed from: a */
    public static String m4222a(byte[] bArr) {
        return m4225a(bArr, 0, bArr.length, 0);
    }

    /* renamed from: a */
    public static String m4223a(byte[] bArr, int i) {
        return m4225a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static String m4224a(byte[] bArr, int i, int i2) {
        return m4225a(bArr, i, i2, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.wowza.gocoder.sdk.support.wmstransport.a.a$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.wowza.gocoder.sdk.support.wmstransport.a.a$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: com.wowza.gocoder.sdk.support.wmstransport.a.a$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: com.wowza.gocoder.sdk.support.wmstransport.a.a$b} */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:10|11|12|13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:26|27|37|38|39|40|41|42|43|44|45) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:47|48|49|50|51|52|53|54|55) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0060 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0063 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x006f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4225a(byte[] r18, int r19, int r20, int r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21 & 8
            r3 = r21 & 2
            java.lang.String r8 = "UTF-8"
            r4 = 1
            r5 = 2
            if (r3 != r5) goto L_0x0073
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0056, all -> 0x0052 }
            r3.<init>()     // Catch:{ IOException -> 0x0056, all -> 0x0052 }
            com.wowza.gocoder.sdk.support.wmstransport.a.a$b r5 = new com.wowza.gocoder.sdk.support.wmstransport.a.a$b     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r4 = r21 | 1
            r5.<init>(r3, r4)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            r9 = r18
            r4.write(r9, r0, r1)     // Catch:{ IOException -> 0x0045 }
            r4.close()     // Catch:{ IOException -> 0x0045 }
            r4.close()     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            r5.close()     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            r3.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x003b }
            byte[] r1 = r3.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x003b }
            r0.<init>(r1, r8)     // Catch:{ UnsupportedEncodingException -> 0x003b }
            return r0
        L_0x003b:
            java.lang.String r0 = new java.lang.String
            byte[] r1 = r3.toByteArray()
            r0.<init>(r1)
            return r0
        L_0x0045:
            r0 = move-exception
            goto L_0x005a
        L_0x0047:
            r0 = move-exception
            goto L_0x0069
        L_0x0049:
            r0 = move-exception
            r4 = r2
            goto L_0x005a
        L_0x004c:
            r0 = move-exception
            r5 = r2
            goto L_0x0069
        L_0x004f:
            r0 = move-exception
            r4 = r2
            goto L_0x0059
        L_0x0052:
            r0 = move-exception
            r3 = r2
            r5 = r3
            goto L_0x0069
        L_0x0056:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x0059:
            r5 = r4
        L_0x005a:
            r0.printStackTrace()     // Catch:{ all -> 0x0067 }
            r4.close()     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            r5.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            r3.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            return r2
        L_0x0067:
            r0 = move-exception
            r2 = r4
        L_0x0069:
            r2.close()     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            r5.close()     // Catch:{ Exception -> 0x006f }
        L_0x006f:
            r3.close()     // Catch:{ Exception -> 0x0072 }
        L_0x0072:
            throw r0
        L_0x0073:
            r9 = r18
            if (r2 != 0) goto L_0x0079
            r11 = 1
            goto L_0x007a
        L_0x0079:
            r11 = 0
        L_0x007a:
            int r2 = r1 * 4
            int r2 = r2 / 3
            int r3 = r1 % 3
            r12 = 4
            if (r3 <= 0) goto L_0x0085
            r3 = 4
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            int r3 = r3 + r2
            r13 = 76
            if (r11 == 0) goto L_0x008d
            int r2 = r2 / r13
            goto L_0x008e
        L_0x008d:
            r2 = 0
        L_0x008e:
            int r3 = r3 + r2
            byte[] r14 = new byte[r3]
            int r15 = r1 + -2
            r7 = 0
            r16 = 0
            r17 = 0
        L_0x0098:
            if (r7 >= r15) goto L_0x00c0
            int r3 = r7 + r0
            r4 = 3
            r2 = r18
            r5 = r14
            r6 = r16
            r10 = r7
            r7 = r21
            m4239b(r2, r3, r4, r5, r6, r7)
            int r2 = r17 + 4
            if (r11 == 0) goto L_0x00b9
            if (r2 != r13) goto L_0x00b9
            int r2 = r16 + 4
            r3 = 10
            r14[r2] = r3
            int r16 = r16 + 1
            r17 = 0
            goto L_0x00bb
        L_0x00b9:
            r17 = r2
        L_0x00bb:
            int r7 = r10 + 3
            int r16 = r16 + 4
            goto L_0x0098
        L_0x00c0:
            r10 = r7
            if (r10 >= r1) goto L_0x00d5
            int r2 = r10 + r0
            int r3 = r1 - r10
            r0 = r18
            r1 = r2
            r2 = r3
            r3 = r14
            r4 = r16
            r5 = r21
            m4239b(r0, r1, r2, r3, r4, r5)
            int r16 = r16 + 4
        L_0x00d5:
            r0 = r16
            java.lang.String r1 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x00de }
            r2 = 0
            r1.<init>(r14, r2, r0, r8)     // Catch:{ UnsupportedEncodingException -> 0x00df }
            return r1
        L_0x00de:
            r2 = 0
        L_0x00df:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r14, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4225a(byte[], int, int, int):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m4234b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] d = m4245d(i3);
        int i4 = i + 2;
        if (bArr[i4] == 61) {
            bArr2[i2] = (byte) ((((d[bArr[i + 1]] & 255) << 12) | ((d[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        int i5 = i + 3;
        if (bArr[i5] == 61) {
            int i6 = (d[bArr[i + 1]] & 255) << 12;
            int i7 = ((d[bArr[i4]] & 255) << 6) | i6 | ((d[bArr[i]] & 255) << 18);
            bArr2[i2] = (byte) (i7 >>> 16);
            bArr2[i2 + 1] = (byte) (i7 >>> 8);
            return 2;
        }
        try {
            byte b = ((d[bArr[i]] & 255) << 18) | ((d[bArr[i + 1]] & 255) << 12) | ((d[bArr[i4]] & 255) << 6) | (d[bArr[i5]] & 255);
            bArr2[i2] = (byte) (b >> 16);
            bArr2[i2 + 1] = (byte) (b >> 8);
            bArr2[i2 + 2] = (byte) b;
            return 3;
        } catch (Exception unused) {
            PrintStream printStream = System.out;
            printStream.println("" + bArr[i] + ": " + d[bArr[i]]);
            PrintStream printStream2 = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            int i8 = i + 1;
            sb.append(bArr[i8]);
            sb.append(": ");
            sb.append(d[bArr[i8]]);
            printStream2.println(sb.toString());
            PrintStream printStream3 = System.out;
            printStream3.println("" + bArr[i4] + ": " + d[bArr[i4]]);
            PrintStream printStream4 = System.out;
            printStream4.println("" + bArr[i5] + ": " + d[bArr[i5]]);
            return -1;
        }
    }

    /* renamed from: b */
    public static byte[] m4238b(byte[] bArr, int i, int i2, int i3) {
        byte[] d = m4245d(i3);
        byte[] bArr2 = new byte[((i2 * 3) / 4)];
        byte[] bArr3 = new byte[4];
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i + i2) {
            byte b = (byte) (bArr[i4] & Byte.MAX_VALUE);
            byte b2 = d[b];
            if (b2 >= -5) {
                if (b2 >= -1) {
                    int i7 = i5 + 1;
                    bArr3[i5] = b;
                    if (i7 > 3) {
                        i6 += m4234b(bArr3, 0, bArr2, i6, i3);
                        if (b == 61) {
                            break;
                        }
                        i5 = 0;
                    } else {
                        i5 = i7;
                    }
                }
                i4++;
            } else {
                PrintStream printStream = System.err;
                printStream.println("Bad Base64 input character at " + i4 + ": " + bArr[i4] + "(decimal)");
                return null;
            }
        }
        byte[] bArr4 = new byte[i6];
        System.arraycopy(bArr2, 0, bArr4, 0, i6);
        return bArr4;
    }

    /* renamed from: a */
    public static byte[] m4230a(String str) {
        return m4231a(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:16|17|(3:18|19|(1:21)(1:56))|22|23|24|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:29|30|40|41|42|43|44|45|46) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:32|31|50|51|52|53|27|28|54) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x006b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0071 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0074 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m4231a(java.lang.String r5, int r6) {
        /*
            java.lang.String r0 = "UTF-8"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0007 }
            goto L_0x000b
        L_0x0007:
            byte[] r5 = r5.getBytes()
        L_0x000b:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = m4238b((byte[]) r5, (int) r1, (int) r0, (int) r6)
            if (r5 == 0) goto L_0x0078
            int r6 = r5.length
            r0 = 4
            if (r6 < r0) goto L_0x0078
            byte r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r0 = 1
            byte r0 = r5[r0]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L_0x0078
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x006f, all -> 0x0062 }
            r2.<init>()     // Catch:{ IOException -> 0x006f, all -> 0x0062 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0071, all -> 0x005b }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0071, all -> 0x005b }
        L_0x003e:
            int r0 = r4.read(r6)     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            if (r0 < 0) goto L_0x0048
            r2.write(r6, r1, r0)     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            goto L_0x003e
        L_0x0048:
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x0059, all -> 0x0056 }
            r2.close()     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            r4.close()     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            r3.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x0078
        L_0x0056:
            r5 = move-exception
            r0 = r4
            goto L_0x0065
        L_0x0059:
            r0 = r4
            goto L_0x0071
        L_0x005b:
            r5 = move-exception
            goto L_0x0065
        L_0x005d:
            r5 = move-exception
            r3 = r0
            goto L_0x0065
        L_0x0060:
            r3 = r0
            goto L_0x0071
        L_0x0062:
            r5 = move-exception
            r2 = r0
            r3 = r2
        L_0x0065:
            r2.close()     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            r0.close()     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            r3.close()     // Catch:{ Exception -> 0x006e }
        L_0x006e:
            throw r5
        L_0x006f:
            r2 = r0
            r3 = r2
        L_0x0071:
            r2.close()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r0.close()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0052
        L_0x0078:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4231a(java.lang.String, int):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.io.ObjectInputStream} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.ObjectInputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|31|32|33|34|35) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|(3:1|2|(4:3|4|5|6))|7|8|9|10|27) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x003f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object m4235b(java.lang.String r4) {
        /*
            byte[] r4 = m4230a((java.lang.String) r4)
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x0029, all -> 0x0026 }
            r1.<init>(r4)     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x0029, all -> 0x0026 }
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0023, ClassNotFoundException -> 0x0020, all -> 0x001e }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0023, ClassNotFoundException -> 0x0020, all -> 0x001e }
            java.lang.Object r0 = r4.readObject()     // Catch:{ IOException -> 0x001c, ClassNotFoundException -> 0x001a }
        L_0x0013:
            r1.close()     // Catch:{ Exception -> 0x0016 }
        L_0x0016:
            r4.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x0037
        L_0x001a:
            r2 = move-exception
            goto L_0x002c
        L_0x001c:
            r2 = move-exception
            goto L_0x0033
        L_0x001e:
            r4 = move-exception
            goto L_0x003c
        L_0x0020:
            r2 = move-exception
            r4 = r0
            goto L_0x002c
        L_0x0023:
            r2 = move-exception
            r4 = r0
            goto L_0x0033
        L_0x0026:
            r4 = move-exception
            r1 = r0
            goto L_0x003c
        L_0x0029:
            r2 = move-exception
            r4 = r0
            r1 = r4
        L_0x002c:
            r2.printStackTrace()     // Catch:{ all -> 0x0038 }
            goto L_0x0013
        L_0x0030:
            r2 = move-exception
            r4 = r0
            r1 = r4
        L_0x0033:
            r2.printStackTrace()     // Catch:{ all -> 0x0038 }
            goto L_0x0013
        L_0x0037:
            return r0
        L_0x0038:
            r0 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
        L_0x003c:
            r1.close()     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            r0.close()     // Catch:{ Exception -> 0x0042 }
        L_0x0042:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4235b(java.lang.String):java.lang.Object");
    }

    /* renamed from: a */
    public static boolean m4228a(byte[] bArr, String str) {
        boolean z = true;
        C4305b bVar = null;
        try {
            C4305b bVar2 = new C4305b(new FileOutputStream(str), 1);
            try {
                bVar2.write(bArr);
                try {
                    bVar2.close();
                } catch (Exception unused) {
                }
            } catch (IOException unused2) {
                bVar = bVar2;
                z = false;
                bVar.close();
                return z;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                try {
                    bVar.close();
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (IOException unused4) {
            z = false;
            bVar.close();
            return z;
        } catch (Throwable th2) {
            th = th2;
            bVar.close();
            throw th;
        }
        return z;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0024 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m4227a(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            com.wowza.gocoder.sdk.support.wmstransport.a.a$b r2 = new com.wowza.gocoder.sdk.support.wmstransport.a.a$b     // Catch:{ IOException -> 0x0024, all -> 0x001f }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0024, all -> 0x001f }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0024, all -> 0x001f }
            r2.<init>(r3, r0)     // Catch:{ IOException -> 0x0024, all -> 0x001f }
            java.lang.String r5 = "UTF-8"
            byte[] r4 = r4.getBytes(r5)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
            r2.write(r4)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
            r0 = 1
            r2.close()     // Catch:{ Exception -> 0x0027 }
            goto L_0x0027
        L_0x001a:
            r4 = move-exception
            r1 = r2
            goto L_0x0020
        L_0x001d:
            r1 = r2
            goto L_0x0024
        L_0x001f:
            r4 = move-exception
        L_0x0020:
            r1.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            throw r4
        L_0x0024:
            r1.close()     // Catch:{ Exception -> 0x0027 }
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4227a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.wowza.gocoder.sdk.support.wmstransport.a.a$a} */
    /* JADX WARNING: type inference failed for: r0v0, types: [byte[], com.wowza.gocoder.sdk.support.wmstransport.a.a$a] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m4243c(java.lang.String r7) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0067 }
            r1.<init>(r7)     // Catch:{ IOException -> 0x0067 }
            long r2 = r1.length()     // Catch:{ IOException -> 0x0067 }
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0034
            java.io.PrintStream r2 = java.lang.System.err     // Catch:{ IOException -> 0x0067 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0067 }
            r3.<init>()     // Catch:{ IOException -> 0x0067 }
            java.lang.String r4 = "File is too big for this convenience method ("
            r3.append(r4)     // Catch:{ IOException -> 0x0067 }
            long r4 = r1.length()     // Catch:{ IOException -> 0x0067 }
            r3.append(r4)     // Catch:{ IOException -> 0x0067 }
            java.lang.String r1 = " bytes)."
            r3.append(r1)     // Catch:{ IOException -> 0x0067 }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x0067 }
            r2.println(r1)     // Catch:{ IOException -> 0x0067 }
            r0.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            return r0
        L_0x0034:
            long r2 = r1.length()     // Catch:{ IOException -> 0x0067 }
            int r3 = (int) r2     // Catch:{ IOException -> 0x0067 }
            byte[] r2 = new byte[r3]     // Catch:{ IOException -> 0x0067 }
            com.wowza.gocoder.sdk.support.wmstransport.a.a$a r3 = new com.wowza.gocoder.sdk.support.wmstransport.a.a$a     // Catch:{ IOException -> 0x0067 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0067 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0067 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0067 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0067 }
            r1 = 0
            r3.<init>(r4, r1)     // Catch:{ IOException -> 0x0067 }
            r4 = 0
        L_0x004c:
            r5 = 4096(0x1000, float:5.74E-42)
            int r5 = r3.read(r2, r4, r5)     // Catch:{ IOException -> 0x0062, all -> 0x005f }
            if (r5 < 0) goto L_0x0056
            int r4 = r4 + r5
            goto L_0x004c
        L_0x0056:
            byte[] r0 = new byte[r4]     // Catch:{ IOException -> 0x0062, all -> 0x005f }
            java.lang.System.arraycopy(r2, r1, r0, r1, r4)     // Catch:{ IOException -> 0x0062, all -> 0x005f }
            r3.close()     // Catch:{ Exception -> 0x0082 }
            goto L_0x0082
        L_0x005f:
            r7 = move-exception
            r0 = r3
            goto L_0x0083
        L_0x0062:
            r1 = r0
            r0 = r3
            goto L_0x0068
        L_0x0065:
            r7 = move-exception
            goto L_0x0083
        L_0x0067:
            r1 = r0
        L_0x0068:
            java.io.PrintStream r2 = java.lang.System.err     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r3.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = "Error decoding from file "
            r3.append(r4)     // Catch:{ all -> 0x0065 }
            r3.append(r7)     // Catch:{ all -> 0x0065 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0065 }
            r2.println(r7)     // Catch:{ all -> 0x0065 }
            r0.close()     // Catch:{ Exception -> 0x0081 }
        L_0x0081:
            r0 = r1
        L_0x0082:
            return r0
        L_0x0083:
            r0.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4243c(java.lang.String):byte[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|(3:20|21|29)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        java.lang.System.err.println("Error encoding from file " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0047 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4244d(java.lang.String r7) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r1.<init>(r7)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            long r2 = r1.length()     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            double r2 = (double) r2     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r4 = 4608983858650965606(0x3ff6666666666666, double:1.4)
            double r2 = r2 * r4
            int r2 = (int) r2     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r3 = 40
            int r2 = java.lang.Math.max(r2, r3)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            com.wowza.gocoder.sdk.support.wmstransport.a.a$a r3 = new com.wowza.gocoder.sdk.support.wmstransport.a.a$a     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r1 = 1
            r3.<init>(r4, r1)     // Catch:{ IOException -> 0x0046, all -> 0x0043 }
            r1 = 0
            r4 = 0
        L_0x002d:
            r5 = 4096(0x1000, float:5.74E-42)
            int r5 = r3.read(r2, r4, r5)     // Catch:{ IOException -> 0x0047 }
            if (r5 < 0) goto L_0x0037
            int r4 = r4 + r5
            goto L_0x002d
        L_0x0037:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x0047 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r2, r1, r4, r6)     // Catch:{ IOException -> 0x0047 }
            r3.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            r0 = r5
            goto L_0x0060
        L_0x0043:
            r7 = move-exception
            r3 = r0
            goto L_0x0062
        L_0x0046:
            r3 = r0
        L_0x0047:
            java.io.PrintStream r1 = java.lang.System.err     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r2.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = "Error encoding from file "
            r2.append(r4)     // Catch:{ all -> 0x0061 }
            r2.append(r7)     // Catch:{ all -> 0x0061 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0061 }
            r1.println(r7)     // Catch:{ all -> 0x0061 }
            r3.close()     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            return r0
        L_0x0061:
            r7 = move-exception
        L_0x0062:
            r3.close()     // Catch:{ Exception -> 0x0065 }
        L_0x0065:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4244d(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static void m4236b(String str, String str2) {
        String d = m4244d(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(d.getBytes("US-ASCII"));
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    bufferedOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedOutputStream.close();
                throw th;
            }
            try {
                bufferedOutputStream2.close();
            } catch (Exception unused2) {
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            bufferedOutputStream.close();
        }
    }

    /* renamed from: e */
    public static void m4246e(String str) {
        try {
            String a = m4222a(str.getBytes());
            PrintStream printStream = System.out;
            printStream.println("     in:" + str);
            PrintStream printStream2 = System.out;
            printStream2.println("encoded:" + a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public static void m4247f(String str) {
        try {
            byte[] a = m4230a(str);
            PrintStream printStream = System.out;
            printStream.println("     in:" + str);
            PrintStream printStream2 = System.out;
            printStream2.println("decoded:" + new String(a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m4241c(String str, String str2) {
        byte[] c = m4243c(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(c);
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    bufferedOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedOutputStream.close();
                throw th;
            }
            try {
                bufferedOutputStream2.close();
            } catch (Exception unused2) {
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            bufferedOutputStream.close();
        }
    }

    /* renamed from: com.wowza.gocoder.sdk.support.wmstransport.a.a$a */
    /* compiled from: GoCoderSDK */
    public static class C4304a extends FilterInputStream {

        /* renamed from: a */
        private boolean f4389a;

        /* renamed from: b */
        private int f4390b;

        /* renamed from: c */
        private byte[] f4391c;

        /* renamed from: d */
        private int f4392d;

        /* renamed from: e */
        private int f4393e;

        /* renamed from: f */
        private int f4394f;

        /* renamed from: g */
        private boolean f4395g;

        /* renamed from: h */
        private int f4396h;

        /* renamed from: i */
        private byte[] f4397i;

        /* renamed from: j */
        private byte[] f4398j;

        public C4304a(InputStream inputStream) {
            this(inputStream, 0);
        }

        public C4304a(InputStream inputStream, int i) {
            super(inputStream);
            boolean z = true;
            this.f4395g = (i & 8) != 8;
            this.f4389a = (i & 1) != 1 ? false : z;
            this.f4392d = this.f4389a ? 4 : 3;
            this.f4391c = new byte[this.f4392d];
            this.f4390b = -1;
            this.f4394f = 0;
            this.f4396h = i;
            this.f4397i = C4303a.m4242c(i);
            this.f4398j = C4303a.m4245d(i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0051 A[LOOP:1: B:19:0x003b->B:25:0x0051, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0057 A[EDGE_INSN: B:58:0x0057->B:26:0x0057 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r10 = this;
                int r0 = r10.f4390b
                r1 = -1
                r2 = 0
                if (r0 >= 0) goto L_0x0071
                boolean r0 = r10.f4389a
                r3 = 4
                if (r0 == 0) goto L_0x0038
                r0 = 3
                byte[] r4 = new byte[r0]
                r5 = 0
                r6 = 0
            L_0x0010:
                if (r5 >= r0) goto L_0x0027
                java.io.InputStream r7 = r10.in     // Catch:{ IOException -> 0x0020 }
                int r7 = r7.read()     // Catch:{ IOException -> 0x0020 }
                if (r7 < 0) goto L_0x0023
                byte r7 = (byte) r7     // Catch:{ IOException -> 0x0020 }
                r4[r5] = r7     // Catch:{ IOException -> 0x0020 }
                int r6 = r6 + 1
                goto L_0x0023
            L_0x0020:
                r7 = move-exception
                if (r5 == 0) goto L_0x0026
            L_0x0023:
                int r5 = r5 + 1
                goto L_0x0010
            L_0x0026:
                throw r7
            L_0x0027:
                if (r6 <= 0) goto L_0x0037
                r5 = 0
                byte[] r7 = r10.f4391c
                r8 = 0
                int r9 = r10.f4396h
                byte[] unused = com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4239b(r4, r5, r6, r7, r8, r9)
                r10.f4390b = r2
                r10.f4393e = r3
                goto L_0x0071
            L_0x0037:
                return r1
            L_0x0038:
                byte[] r0 = new byte[r3]
                r4 = 0
            L_0x003b:
                if (r4 >= r3) goto L_0x0057
            L_0x003d:
                java.io.InputStream r5 = r10.in
                int r5 = r5.read()
                if (r5 < 0) goto L_0x004e
                byte[] r6 = r10.f4398j
                r7 = r5 & 127(0x7f, float:1.78E-43)
                byte r6 = r6[r7]
                r7 = -5
                if (r6 <= r7) goto L_0x003d
            L_0x004e:
                if (r5 >= 0) goto L_0x0051
                goto L_0x0057
            L_0x0051:
                byte r5 = (byte) r5
                r0[r4] = r5
                int r4 = r4 + 1
                goto L_0x003b
            L_0x0057:
                if (r4 != r3) goto L_0x0066
                byte[] r3 = r10.f4391c
                int r4 = r10.f4396h
                int r0 = com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.m4234b(r0, r2, r3, r2, r4)
                r10.f4393e = r0
                r10.f4390b = r2
                goto L_0x0071
            L_0x0066:
                if (r4 != 0) goto L_0x0069
                return r1
            L_0x0069:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Improperly padded Base64 input."
                r0.<init>(r1)
                throw r0
            L_0x0071:
                int r0 = r10.f4390b
                if (r0 < 0) goto L_0x00a8
                int r3 = r10.f4393e
                if (r0 < r3) goto L_0x007a
                return r1
            L_0x007a:
                boolean r0 = r10.f4389a
                if (r0 == 0) goto L_0x008d
                boolean r0 = r10.f4395g
                if (r0 == 0) goto L_0x008d
                int r0 = r10.f4394f
                r3 = 76
                if (r0 < r3) goto L_0x008d
                r10.f4394f = r2
                r0 = 10
                return r0
            L_0x008d:
                int r0 = r10.f4394f
                int r0 = r0 + 1
                r10.f4394f = r0
                byte[] r0 = r10.f4391c
                int r2 = r10.f4390b
                int r3 = r2 + 1
                r10.f4390b = r3
                byte r0 = r0[r2]
                int r2 = r10.f4390b
                int r3 = r10.f4392d
                if (r2 < r3) goto L_0x00a5
                r10.f4390b = r1
            L_0x00a5:
                r0 = r0 & 255(0xff, float:3.57E-43)
                return r0
            L_0x00a8:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Error in Base64 code reading stream."
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.p041a.C4303a.C4304a.read():int");
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    /* renamed from: com.wowza.gocoder.sdk.support.wmstransport.a.a$b */
    /* compiled from: GoCoderSDK */
    public static class C4305b extends FilterOutputStream {

        /* renamed from: a */
        private boolean f4399a;

        /* renamed from: b */
        private int f4400b;

        /* renamed from: c */
        private byte[] f4401c;

        /* renamed from: d */
        private int f4402d;

        /* renamed from: e */
        private int f4403e;

        /* renamed from: f */
        private boolean f4404f;

        /* renamed from: g */
        private byte[] f4405g;

        /* renamed from: h */
        private boolean f4406h;

        /* renamed from: i */
        private int f4407i;

        /* renamed from: j */
        private byte[] f4408j;

        /* renamed from: k */
        private byte[] f4409k;

        public C4305b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        public C4305b(OutputStream outputStream, int i) {
            super(outputStream);
            boolean z = true;
            this.f4404f = (i & 8) != 8;
            this.f4399a = (i & 1) != 1 ? false : z;
            this.f4402d = this.f4399a ? 3 : 4;
            this.f4401c = new byte[this.f4402d];
            this.f4400b = 0;
            this.f4403e = 0;
            this.f4406h = false;
            this.f4405g = new byte[4];
            this.f4407i = i;
            this.f4408j = C4303a.m4242c(i);
            this.f4409k = C4303a.m4245d(i);
        }

        public void write(int i) throws IOException {
            if (this.f4406h) {
                this.out.write(i);
            } else if (this.f4399a) {
                byte[] bArr = this.f4401c;
                int i2 = this.f4400b;
                this.f4400b = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.f4400b >= this.f4402d) {
                    this.out.write(C4303a.m4240b(this.f4405g, this.f4401c, this.f4402d, this.f4407i));
                    this.f4403e += 4;
                    if (this.f4404f && this.f4403e >= 76) {
                        this.out.write(10);
                        this.f4403e = 0;
                    }
                    this.f4400b = 0;
                }
            } else {
                byte[] bArr2 = this.f4409k;
                int i3 = i & 127;
                if (bArr2[i3] > -5) {
                    byte[] bArr3 = this.f4401c;
                    int i4 = this.f4400b;
                    this.f4400b = i4 + 1;
                    bArr3[i4] = (byte) i;
                    if (this.f4400b >= this.f4402d) {
                        this.out.write(this.f4405g, 0, C4303a.m4234b(bArr3, 0, this.f4405g, 0, this.f4407i));
                        this.f4400b = 0;
                    }
                } else if (bArr2[i3] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.f4406h) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        /* renamed from: a */
        public void mo59246a() throws IOException {
            if (this.f4400b <= 0) {
                return;
            }
            if (this.f4399a) {
                this.out.write(C4303a.m4240b(this.f4405g, this.f4401c, this.f4400b, this.f4407i));
                this.f4400b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void close() throws IOException {
            mo59246a();
            super.close();
            this.f4401c = null;
            this.out = null;
        }

        /* renamed from: b */
        public void mo59247b() throws IOException {
            mo59246a();
            this.f4406h = true;
        }

        /* renamed from: c */
        public void mo59248c() {
            this.f4406h = false;
        }
    }
}
