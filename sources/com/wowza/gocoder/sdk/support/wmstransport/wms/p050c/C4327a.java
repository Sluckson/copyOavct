package com.wowza.gocoder.sdk.support.wmstransport.wms.p050c;

import java.util.List;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.c.a */
/* compiled from: GoCoderSDK */
public class C4327a {
    /* renamed from: a */
    public static byte[] m4494a(byte[] bArr, List<byte[]> list, byte[] bArr2) {
        byte[] b = m4495b(bArr, list, bArr2);
        if (b == null) {
            return null;
        }
        byte[] bArr3 = new byte[(b.length + 5)];
        bArr3[0] = (byte) 23;
        bArr3[1] = 1;
        bArr3[2] = 0;
        bArr3[3] = 0;
        bArr3[4] = 0;
        System.arraycopy(b, 0, bArr3, 5, b.length);
        return bArr3;
    }

    /* renamed from: b */
    public static byte[] m4495b(byte[] bArr, List<byte[]> list, byte[] bArr2) {
        boolean z;
        int length = bArr.length + 8 + 1;
        for (byte[] length2 : list) {
            length += length2.length + 2;
        }
        byte[] bArr3 = new byte[length];
        bArr3[0] = 1;
        if (bArr2 == null || bArr2.length < 3) {
            z = false;
        } else {
            bArr3[1] = bArr2[0];
            bArr3[2] = bArr2[1];
            bArr3[3] = bArr2[2];
            z = true;
        }
        if (!z) {
            bArr3[1] = bArr[1];
            bArr3[2] = bArr[2];
            bArr3[3] = bArr[3];
        }
        bArr3[4] = -1;
        bArr3[5] = -31;
        bArr3[6] = (byte) ((bArr.length >> 8) & 255);
        bArr3[7] = (byte) ((bArr.length >> 0) & 255);
        System.arraycopy(bArr, 0, bArr3, 8, bArr.length);
        bArr3[bArr.length + 8] = (byte) (list.size() & 255);
        int length3 = bArr.length + 9;
        for (byte[] next : list) {
            bArr3[length3 + 0] = (byte) ((next.length >> 8) & 255);
            bArr3[length3 + 1] = (byte) ((next.length >> 0) & 255);
            System.arraycopy(next, 0, bArr3, length3 + 2, next.length);
            length3 += next.length + 2;
        }
        return bArr3;
    }
}
