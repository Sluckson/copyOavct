package com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p043a;

import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import com.google.common.base.Ascii;
import com.lowagie.text.DocWriter;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.a.a.b */
/* compiled from: GoCoderSDK */
public class C4314b {

    /* renamed from: a */
    public static final String f4450a = "AACUtils";

    /* renamed from: b */
    public static final int f4451b = 7;

    /* renamed from: c */
    public static final int[] f4452c = {96000, 88200, WOWZMediaConfig.DEFAULT_AUDIO_BITRATE, 48000, WOWZMediaConfig.DEFAULT_AUDIO_SAMPLE_RATE, 32000, 24000, 22050, 16000, SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES, 11025, 8000, 7350};

    /* renamed from: d */
    public static final int[] f4453d = {0, 1, 2, 3, 4, 5, 6, 8};

    /* renamed from: a */
    public static int m4363a(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f4452c;
            if (i2 >= iArr.length) {
                return 0;
            }
            if (i == iArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    /* renamed from: b */
    public static int m4370b(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f4453d;
            if (i2 >= iArr.length) {
                return 0;
            }
            if (i == iArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    /* renamed from: a */
    public static int m4364a(byte[] bArr, int i, long j) {
        for (int i2 = 0; ((long) i2) < j - 7; i2++) {
            int i3 = i2 + i;
            C4313a a = m4366a(bArr, (long) i3);
            if (a != null && ((long) (a.mo59289b() + i3 + 7)) < j && m4366a(bArr, (long) (a.mo59289b() + i3)) != null) {
                return i3;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m4368a(byte[] bArr, long j, int i, int i2) {
        int i3 = (int) j;
        if ((bArr[i3 + 0] & 255) == 255 && (bArr[i3 + 1] & 240) == 240) {
            int i4 = i3 + 2;
            int i5 = (bArr[i4] & DocWriter.f570LT) >> 2;
            int i6 = ((bArr[i4] & 1) << 2) + (((byte) (bArr[i3 + 3] >> 6)) & 3);
            if (i == i5 && i2 == i6) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public static void m4367a(C4313a aVar, byte[] bArr, int i) {
        int f = aVar.mo59297f();
        int i2 = aVar.mo59302i();
        int g = aVar.mo59299g();
        int b = aVar.mo59289b();
        boolean h = aVar.mo59301h();
        bArr[i + 0] = -1;
        bArr[i + 1] = (byte) ((h ? 1 : 0) + true);
        int i3 = i + 2;
        bArr[i3] = (byte) (((i2 - 1) & 3) << 6);
        bArr[i3] = (byte) (bArr[i3] + ((byte) ((f << 2) & 60)));
        bArr[i3] = (byte) (bArr[i3] + ((byte) ((g >> 2) & 1)));
        int i4 = i + 3;
        bArr[i4] = (byte) ((g & 3) << 6);
        int i5 = i + 5;
        bArr[i5] = (byte) ((b & 7) << 5);
        int i6 = b >> 3;
        bArr[i + 4] = (byte) (i6 & 255);
        bArr[i4] = (byte) (bArr[i4] + ((byte) ((i6 >> 8) & 3)));
        bArr[i5] = (byte) (bArr[i5] + Ascii.f275US);
        int i7 = i + 6;
        bArr[i7] = (byte) 252;
        bArr[i7] = (byte) (bArr[i7] + ((byte) (aVar.mo59293d() & 3)));
    }

    /* renamed from: a */
    public static C4313a m4366a(byte[] bArr, long j) {
        int i = (int) j;
        if ((bArr[i + 0] & 255) == 255) {
            int i2 = i + 1;
            if ((bArr[i2] & 240) == 240) {
                boolean z = (bArr[i2] & 1) == 1;
                int i3 = i + 2;
                int i4 = ((bArr[i3] >> 6) & 3) + 1;
                int i5 = (bArr[i3] & DocWriter.f570LT) >> 2;
                if (i5 >= 0) {
                    int[] iArr = f4452c;
                    if (i5 < iArr.length) {
                        int i6 = iArr[i5];
                        int i7 = i + 3;
                        int i8 = ((1 & bArr[i3]) << 2) + (((byte) (bArr[i7] >> 6)) & 3);
                        if (i8 >= 0) {
                            int[] iArr2 = f4453d;
                            if (i8 < iArr2.length) {
                                int i9 = iArr2[i8];
                                int i10 = ((((bArr[i7] & 3) << 8) + (255 & bArr[i + 4])) << 3) + ((bArr[i + 5] >> 5) & 7);
                                if (i10 > 0) {
                                    C4313a aVar = new C4313a();
                                    aVar.mo59298f(i8);
                                    aVar.mo59292c(i9);
                                    aVar.mo59294d(bArr[i + 6] & 3);
                                    aVar.mo59296e(i5);
                                    aVar.mo59286a(i6);
                                    aVar.mo59290b(i10);
                                    aVar.mo59287a(z);
                                    aVar.mo59300g(i4);
                                    return aVar;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static void m4371b(C4313a aVar, byte[] bArr, int i) {
        int i2 = aVar.mo59302i();
        int f = aVar.mo59297f();
        int g = aVar.mo59299g();
        WOWZLog.debug(f4450a, "encodeAACCodecConfig.ot: " + i2);
        WOWZLog.debug(f4450a, "encodeAACCodecConfig.sr: " + f);
        WOWZLog.debug(f4450a, "encodeAACCodecConfig.ch: " + g);
        int i3 = i + 0;
        bArr[i3] = (byte) (i2 << 3);
        bArr[i3] = (byte) (bArr[i3] + ((byte) (f >> 1)));
        int i4 = i + 1;
        bArr[i4] = (byte) (f << 7);
        bArr[i4] = (byte) (bArr[i4] + ((byte) (g << 3)));
        WOWZLog.debug(f4450a, "encodeAACCodecConfig: " + C4307c.m4268a(bArr));
    }

    /* renamed from: c */
    public static String m4372c(int i) {
        String str = "Unknown[" + i + "]";
        switch (i) {
            case 0:
                return "NULL[0]";
            case 1:
                return "Main";
            case 2:
                return "LC";
            case 3:
                return "SBR";
            case 4:
                return "LongTermPrediction";
            case 5:
                return "HEAACV1";
            case 6:
                return "Scalable";
            case 7:
                return "TwinVQ";
            case 8:
                return "CELP";
            case 9:
                return "HVXC";
            case 10:
                return "Reserved[10]";
            case 11:
                return "Reserved[11]";
            case 12:
                return "TTSI";
            case 13:
                return "Synthetic";
            case 14:
                return "WavetableSynthesis";
            case 15:
                return "GeneralMIDI";
            case 16:
                return "AlgorithmicSynthesisAndAudioFX";
            case 17:
                return "LowComplexityWithErrorRecovery";
            case 18:
                return "Reserved[18]";
            case 19:
                return "LongTermPredictionWithErrorRecover";
            case 20:
                return "ScalableWithErrorRecovery";
            case 21:
                return "TwinVQWithErrorRecovery";
            case 22:
                return "BSACWithErrorRecovery";
            case 23:
                return "LDWithErrorRecovery";
            case 24:
                return "CELPWithErrorRecovery";
            case 25:
                return "HXVCWithErrorRecovery";
            case 26:
                return "HILNWithErrorRecovery";
            case 27:
                return "ParametricWithErrorRecovery";
            case 28:
                return "SSC";
            case 29:
                return "HEAACV2";
            case 30:
                return "MPEGSURROUND";
            case 31:
                return "Reserved[31]";
            case 32:
                return "MPEG1LAYER1";
            case 33:
                return "MPEG1LAYER2";
            case 34:
                return "MPEG1LAYER3";
            default:
                return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p043a.C4313a m4365a(byte[] r5, int r6) {
        /*
            byte r0 = r5[r6]
            r0 = r0 & 248(0xf8, float:3.48E-43)
            int r0 = r0 >> 3
            byte r1 = r5[r6]
            r1 = r1 & 7
            int r1 = r1 << 1
            int r6 = r6 + 1
            byte r2 = r5[r6]
            r2 = r2 & 128(0x80, float:1.794E-43)
            int r2 = r2 >> 7
            r2 = r2 & 1
            int r1 = r1 + r2
            byte r5 = r5[r6]
            r5 = r5 & 127(0x7f, float:1.78E-43)
            int r5 = r5 >> 3
            r6 = 0
            if (r1 < 0) goto L_0x0028
            int[] r2 = f4452c
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0028
            r2 = r2[r1]
            goto L_0x0029
        L_0x0028:
            r2 = 0
        L_0x0029:
            if (r5 < 0) goto L_0x0032
            int[] r3 = f4453d
            int r4 = r3.length
            if (r5 >= r4) goto L_0x0032
            r6 = r3[r5]
        L_0x0032:
            com.wowza.gocoder.sdk.support.wmstransport.wms.a.a.a r3 = new com.wowza.gocoder.sdk.support.wmstransport.wms.a.a.a
            r3.<init>()
            r3.mo59300g(r0)
            r3.mo59298f(r5)
            r3.mo59292c(r6)
            r3.mo59296e(r1)
            r3.mo59286a((int) r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p043a.C4314b.m4365a(byte[], int):com.wowza.gocoder.sdk.support.wmstransport.wms.a.a.a");
    }

    /* renamed from: a */
    public static byte[] m4369a(byte[] bArr, int i, int i2) {
        m4365a(bArr, i);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
