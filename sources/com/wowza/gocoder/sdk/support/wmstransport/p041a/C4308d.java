package com.wowza.gocoder.sdk.support.wmstransport.p041a;

import androidx.core.view.ViewCompat;
import com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFPacket;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.a.d */
/* compiled from: GoCoderSDK */
public class C4308d {

    /* renamed from: a */
    public static final String f4419a = "FLVUtils";

    /* renamed from: b */
    public static final int f4420b = 0;

    /* renamed from: c */
    public static final int f4421c = 1;

    /* renamed from: d */
    public static final int f4422d = 2;

    /* renamed from: e */
    public static final int f4423e = 3;

    /* renamed from: f */
    public static final int f4424f = 4;

    /* renamed from: g */
    public static final int f4425g = 11;

    /* renamed from: h */
    public static final int f4426h = 13;

    /* renamed from: i */
    public static final int f4427i = 5;

    /* renamed from: j */
    public static final int f4428j = 0;

    /* renamed from: k */
    public static final int f4429k = 1;

    /* renamed from: l */
    public static final int f4430l = 3;

    /* renamed from: m */
    public static final int f4431m = 2;

    /* renamed from: n */
    public static final int f4432n = 0;

    /* renamed from: o */
    public static final int f4433o = 1;

    /* renamed from: p */
    public static final int f4434p = 2;

    /* renamed from: a */
    public static int m4295a(byte b) {
        return (b >> 4) & 3;
    }

    /* renamed from: a */
    public static String m4298a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "U" : "B" : "P" : "I";
    }

    /* renamed from: d */
    public static int m4305d(int i) {
        return (i >> 4) & 3;
    }

    /* renamed from: e */
    public static int m4307e(int i) {
        return (i >> 4) & 15;
    }

    /* renamed from: f */
    public static int m4309f(int i) {
        return i & 15;
    }

    /* renamed from: b */
    public static String m4302b(int i) {
        String str = "UNKNOWN[" + i + "]";
        if (i == 15) {
            return "MP3_8";
        }
        switch (i) {
            case 0:
                return "PCM_BE";
            case 1:
                return "AC3";
            case 2:
                return "MP3";
            case 3:
                return "PCM_LE";
            case 4:
                return "NELLYMOSER_16MONO";
            case 5:
                return "NELLYMOSER_8MONO";
            case 6:
                return "NELLYMOSER";
            case 7:
                return "G711_ALAW";
            case 8:
                return "G711_MULAW";
            case 9:
                return "VORBIS";
            case 10:
                return "AAC";
            case 11:
                return "SPEEX";
            default:
                return str;
        }
    }

    /* renamed from: c */
    public static String m4304c(int i) {
        String str = "UNKNOWN[" + i + "]";
        switch (i) {
            case 2:
                return "SPARK";
            case 3:
                return "SCREEN";
            case 4:
                return "VP6";
            case 5:
                return "VP6A";
            case 6:
                return "SCREEN2";
            case 7:
                return "H264";
            case 8:
                return "VP8";
            case 9:
                return "H263";
            case 10:
                return "MPEG4";
            case 11:
                return "MPEG2";
            default:
                return str;
        }
    }

    /* renamed from: a */
    public static boolean m4299a(int[] iArr) {
        if (iArr[0] != 9) {
            return false;
        }
        boolean z = m4305d(iArr[3]) == 1;
        if (z) {
            int i = iArr[4] & 255;
            if (m4309f(iArr[3]) == 7 && i != 1) {
                return false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static int m4296a(AMFPacket aMFPacket) {
        if (aMFPacket.getType() != 9 || aMFPacket.getSize() < 5) {
            return 0;
        }
        byte[] data = aMFPacket.getData();
        int f = m4309f((int) data[0]);
        if (f == 7 || f == 11 || f == 10 || f == 8) {
            return m4297a(data);
        }
        return 0;
    }

    /* renamed from: b */
    public static int m4300b(AMFPacket aMFPacket) {
        if (aMFPacket.getType() == 9 && aMFPacket.getSize() >= 1) {
            return m4305d(aMFPacket.getFirstByte());
        }
        return 2;
    }

    /* renamed from: c */
    public static int m4303c(AMFPacket aMFPacket) {
        if (aMFPacket.getType() == 9 && aMFPacket.getSize() >= 1) {
            return m4309f(aMFPacket.getFirstByte());
        }
        return -1;
    }

    /* renamed from: d */
    public static int m4306d(AMFPacket aMFPacket) {
        if (aMFPacket.getType() == 8 && aMFPacket.getSize() >= 1) {
            return m4307e(aMFPacket.getFirstByte());
        }
        return -1;
    }

    /* renamed from: e */
    public static boolean m4308e(AMFPacket aMFPacket) {
        if (aMFPacket.getType() == 8 && aMFPacket.getSize() >= 2) {
            int firstByte = aMFPacket.getFirstByte();
            int secondByte = aMFPacket.getSecondByte();
            int e = m4307e(firstByte);
            if ((e == 10 || e == 9) && secondByte == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m4310f(AMFPacket aMFPacket) {
        if (aMFPacket.getType() == 9 && aMFPacket.getSize() >= 2) {
            int firstByte = aMFPacket.getFirstByte();
            int secondByte = aMFPacket.getSecondByte();
            int f = m4309f(firstByte);
            if ((f == 7 || f == 10 || f == 11 || f == 8) && secondByte == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m4311g(AMFPacket aMFPacket) {
        if (aMFPacket.getType() != 9 || aMFPacket.getSize() < 2) {
            return false;
        }
        int firstByte = aMFPacket.getFirstByte();
        boolean z = m4305d(firstByte) == 1;
        if (z) {
            int secondByte = aMFPacket.getSecondByte();
            if (m4309f(firstByte) == 7 && secondByte != 1) {
                return false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static int m4301b(int[] iArr) {
        return (iArr[3] >> 4) & 3;
    }

    /* renamed from: a */
    public static int m4297a(byte[] bArr) {
        if (bArr.length < 5) {
            return 0;
        }
        int f = m4309f((int) bArr[0]);
        if (f != 7 && f != 11 && f != 10 && f != 8) {
            return 0;
        }
        int d = C4307c.m4292d(bArr, 2, 3);
        return (d & 8388608) == 8388608 ? d | ViewCompat.MEASURED_STATE_MASK : d;
    }
}
