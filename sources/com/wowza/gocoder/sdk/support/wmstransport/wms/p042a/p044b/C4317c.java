package com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lowagie.text.DocWriter;
import com.lowagie.text.pdf.ByteBuffer;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4306b;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4310f;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4311g;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4312h;
import com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p048b.p049a.C4326a;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p050c.C4327a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.a.b.c */
/* compiled from: GoCoderSDK */
public class C4317c {

    /* renamed from: A */
    public static final int f4505A = 2;

    /* renamed from: B */
    public static final int f4506B = 3;

    /* renamed from: C */
    public static final int f4507C = 4;

    /* renamed from: D */
    public static final int f4508D = 5;

    /* renamed from: E */
    public static final int f4509E = 6;

    /* renamed from: F */
    public static final int f4510F = 7;

    /* renamed from: G */
    public static final int f4511G = 8;

    /* renamed from: H */
    public static final int f4512H = 9;

    /* renamed from: I */
    public static final int f4513I = 10;

    /* renamed from: J */
    public static final int f4514J = 11;

    /* renamed from: K */
    public static final int f4515K = 12;

    /* renamed from: L */
    public static final int f4516L = 13;

    /* renamed from: M */
    public static final int f4517M = 14;

    /* renamed from: N */
    public static final int f4518N = 15;

    /* renamed from: O */
    public static final int f4519O = 16;

    /* renamed from: P */
    public static final int f4520P = 17;

    /* renamed from: Q */
    public static final int f4521Q = 18;

    /* renamed from: R */
    public static final int f4522R = 66;

    /* renamed from: S */
    public static final int f4523S = 77;

    /* renamed from: T */
    public static final int f4524T = 88;

    /* renamed from: U */
    public static final int f4525U = 100;

    /* renamed from: V */
    public static final int f4526V = 110;

    /* renamed from: W */
    public static final int f4527W = 122;

    /* renamed from: X */
    public static final int f4528X = 244;

    /* renamed from: Y */
    public static final int f4529Y = 44;

    /* renamed from: Z */
    public static final int[] f4530Z = {66, 77, 88, 100, 110, 122, f4528X, 44};

    /* renamed from: a */
    public static final String f4531a = "H264Utils";

    /* renamed from: aa */
    public static final int[] f4532aa = {10, 27, 11, 12, 13, 20, 21, 22, 30, 31, 32, 40, 41, 42, 50, 51, 52};

    /* renamed from: b */
    public static final String f4533b = "avc1";

    /* renamed from: c */
    public static final String f4534c = "avcC";

    /* renamed from: d */
    public static final int[][] f4535d = {new int[]{10, 1485, 64}, new int[]{11, 3000, PsExtractor.AUDIO_STREAM}, new int[]{12, 6000, 384}, new int[]{13, 11880, 768}, new int[]{20, 11880, 2000}, new int[]{21, 19800, 4000}, new int[]{22, 20250, 4000}, new int[]{30, 40500, 10000}, new int[]{31, 108000, 14000}, new int[]{32, 216000, 20000}, new int[]{40, 245760, 20000}, new int[]{41, 245760, 50000}, new int[]{42, 522240, 50000}, new int[]{50, 589824, 135000}, new int[]{51, 983040, 240000}, new int[]{52, 2073600, 240000}};

    /* renamed from: e */
    public static final int f4536e = 4;

    /* renamed from: f */
    public static final int[][] f4537f = {new int[]{0, 1}, new int[]{1, 1}, new int[]{12, 11}, new int[]{10, 11}, new int[]{16, 11}, new int[]{40, 33}, new int[]{24, 11}, new int[]{20, 11}, new int[]{32, 11}, new int[]{80, 33}, new int[]{18, 11}, new int[]{15, 11}, new int[]{64, 33}, new int[]{160, 99}, new int[]{4, 3}, new int[]{3, 2}, new int[]{2, 1}};

    /* renamed from: g */
    public static final byte[][] f4538g = {new byte[]{6, 13, 20, Ascii.f266FS, 13, 20, Ascii.f266FS, 32, 20, Ascii.f266FS, 32, 37, Ascii.f266FS, 32, 37, 42}, new byte[]{10, 14, 20, Ascii.CAN, 14, 20, Ascii.CAN, Ascii.ESC, 20, Ascii.CAN, Ascii.ESC, Ascii.f271RS, Ascii.CAN, Ascii.ESC, Ascii.f271RS, 34}};

    /* renamed from: h */
    public static final byte[][] f4539h = {new byte[]{6, 10, 13, 16, 18, Ascii.ETB, Ascii.f264EM, Ascii.ESC, 10, 11, 16, 18, Ascii.ETB, Ascii.f264EM, Ascii.ESC, Ascii.f267GS, 13, 16, 18, Ascii.ETB, Ascii.f264EM, Ascii.ESC, Ascii.f267GS, Ascii.f275US, 16, 18, Ascii.ETB, Ascii.f264EM, Ascii.ESC, Ascii.f267GS, Ascii.f275US, AMFData.DATA_TYPE_BYTEARRAY, 18, Ascii.ETB, Ascii.f264EM, Ascii.ESC, Ascii.f267GS, Ascii.f275US, AMFData.DATA_TYPE_BYTEARRAY, 36, Ascii.ETB, Ascii.f264EM, Ascii.ESC, Ascii.f267GS, Ascii.f275US, AMFData.DATA_TYPE_BYTEARRAY, 36, 38, Ascii.f264EM, Ascii.ESC, Ascii.f267GS, Ascii.f275US, AMFData.DATA_TYPE_BYTEARRAY, 36, 38, 40, Ascii.ESC, Ascii.f267GS, Ascii.f275US, AMFData.DATA_TYPE_BYTEARRAY, 36, 38, 40, 42}, new byte[]{9, 13, 15, 17, 19, Ascii.NAK, 22, Ascii.CAN, 13, 13, 17, 19, Ascii.NAK, 22, Ascii.CAN, Ascii.f264EM, 15, 17, 19, Ascii.NAK, 22, Ascii.CAN, Ascii.f264EM, Ascii.ESC, 17, 19, Ascii.NAK, 22, Ascii.CAN, Ascii.f264EM, Ascii.ESC, Ascii.f266FS, 19, Ascii.NAK, 22, Ascii.CAN, Ascii.f264EM, Ascii.ESC, Ascii.f266FS, Ascii.f271RS, Ascii.NAK, 22, Ascii.CAN, Ascii.f264EM, Ascii.ESC, Ascii.f266FS, Ascii.f271RS, 32, 22, Ascii.CAN, Ascii.f264EM, Ascii.ESC, Ascii.f266FS, Ascii.f271RS, 32, AMFData.DATA_TYPE_BYTEARRAY, Ascii.CAN, Ascii.f264EM, Ascii.ESC, Ascii.f266FS, Ascii.f271RS, 32, AMFData.DATA_TYPE_BYTEARRAY, 35}};

    /* renamed from: i */
    public static final byte[] f4540i = {0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15};

    /* renamed from: j */
    public static final byte[] f4541j = {0, 1, 8, 16, 9, 2, 3, 10, 17, Ascii.CAN, 32, Ascii.f264EM, 18, 11, 4, 5, 12, 19, Ascii.SUB, AMFData.DATA_TYPE_BYTEARRAY, 40, ByteBuffer.ZERO, 41, 34, Ascii.ESC, 20, 13, 6, 7, 14, Ascii.NAK, Ascii.f266FS, 35, 42, 49, 56, 57, 50, 43, 36, Ascii.f267GS, 22, 15, Ascii.ETB, Ascii.f271RS, 37, 44, 51, 58, 59, 52, 45, 38, Ascii.f275US, 39, 46, 53, DocWriter.f570LT, DocWriter.EQUALS, 54, DocWriter.FORWARD, 55, DocWriter.f569GT, 63};

    /* renamed from: k */
    public static final int f4542k = 1;

    /* renamed from: l */
    public static final int f4543l = 2;

    /* renamed from: m */
    public static final int f4544m = 3;

    /* renamed from: n */
    public static final int f4545n = 4;

    /* renamed from: o */
    public static final int f4546o = 5;

    /* renamed from: p */
    public static final int f4547p = 6;

    /* renamed from: q */
    public static final int f4548q = 7;

    /* renamed from: r */
    public static final int f4549r = 8;

    /* renamed from: s */
    public static final int f4550s = 9;

    /* renamed from: t */
    public static final int f4551t = 10;

    /* renamed from: u */
    public static final int f4552u = 11;

    /* renamed from: v */
    public static final int f4553v = 12;

    /* renamed from: w */
    public static final int f4554w = 13;

    /* renamed from: x */
    public static final int f4555x = 19;

    /* renamed from: y */
    public static final int f4556y = 0;

    /* renamed from: z */
    public static final int f4557z = 1;

    /* renamed from: f */
    public static String m4410f(int i) {
        if (i == 19) {
            return "NAL_TYPE_AUX_SLICE";
        }
        switch (i) {
            case 1:
                return "NAL_TYPE_SLICE";
            case 2:
                return "NAL_TYPE_SLICE_DPA";
            case 3:
                return "NAL_TYPE_SLICE_DPB";
            case 4:
                return "NAL_TYPE_SLICE_DPC";
            case 5:
                return "NAL_TYPE_SLICE_IDR";
            case 6:
                return "NAL_TYPE_SEI";
            case 7:
                return "NAL_TYPE_SPS";
            case 8:
                return "NAL_TYPE_PPS";
            case 9:
                return "NAL_TYPE_AUD";
            case 10:
                return "NAL_TYPE_END_SEQUENCE";
            case 11:
                return "NAL_TYPE_END_STREAM";
            case 12:
                return "NAL_TYPE_FILLER_DATA";
            case 13:
                return "NAL_TYPE_SPS_EXT";
            default:
                return "unknown";
        }
    }

    /* renamed from: g */
    public static String m4412g(int i) {
        switch (i) {
            case 0:
                return "SEI_TYPE_BUFFERING_PERIOD";
            case 1:
                return "SEI_TYPE_PIC_TIMING";
            case 2:
                return "SEI_TYPE_PAN_SCAN_RECT";
            case 3:
                return "SEI_TYPE_FILLER";
            case 4:
                return "SEI_TYPE_USER_DATA_T35";
            case 5:
                return "SEI_TYPE_USER_DATA_UNREGISTERED";
            case 6:
                return "SEI_TYPE_RECOVERY_POINT";
            case 7:
                return "SEI_TYPE_DEC_REF_PIC_MARKING_REPETITION";
            case 8:
                return "SEI_TYPE_SPARE_PIC";
            case 9:
                return "SEI_TYPE_SCENE_INFO";
            case 10:
                return "SEI_TYPE_SUB_SEQ_INFO";
            case 11:
                return "SEI_TYPE_SUB_SEQ_LAYER_CHARACTERISTICS";
            case 12:
                return "SEI_TYPE_SUB_SEQ_CHARACTERISTICS";
            case 13:
                return "SEI_TYPE_FULL_FRAME_FREEZE";
            case 14:
                return "SEI_TYPE_FULL_FRAME_FREEZE_RELEASE";
            case 15:
                return "SEI_TYPE_FULL_FRAME_SNAPSHOT";
            case 16:
                return "SEI_TYPE_PROGRESSIVE_REFINEMENT_START";
            case 17:
                return "SEI_TYPE_PROGRESSIVE_REFINEMENT_END";
            case 18:
                return "SEI_TYPE_MOTION_SLICE_GROUP_SET";
            default:
                return "unknown";
        }
    }

    /* renamed from: a */
    public static C4315a m4386a(byte[] bArr) {
        return m4387a(bArr, 0);
    }

    /* renamed from: a */
    public static String m4388a(int i) {
        return i == 27 ? "1b" : (i / 10) + "." + (i % 10);
    }

    /* renamed from: b */
    public static boolean m4399b(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f4530Z;
            if (i2 < iArr.length && iArr[i2] != i) {
                i2++;
            }
        }
        if (i2 != f4530Z.length) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m4402c(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f4532aa;
            if (i2 < iArr.length && iArr[i2] != i) {
                i2++;
            }
        }
        if (i2 != f4532aa.length) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static String m4405d(int i) {
        String str = "" + i;
        if (i == 44) {
            return "CAVLC 4:4:4 Intra";
        }
        if (i == 66) {
            return "Baseline";
        }
        if (i == 77) {
            return "Main";
        }
        if (i == 88) {
            return "Extended";
        }
        if (i == 100) {
            return "High";
        }
        if (i == 110) {
            return "High 10 or High 10 Intra";
        }
        if (i != 122) {
            return i != 244 ? str : "High 4:4:4 predictive or High 4:4:4 Intra";
        }
        return "High 4:2:2 or High 4:2:2 Intra";
    }

    /* renamed from: a */
    public static byte[] m4395a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        byte[] bArr3 = new byte[(i2 * 2)];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        System.arraycopy(bArr, i, bArr3, 0, i2);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i3 + 2;
            if (i5 >= i2) {
                break;
            }
            if ((bArr2[i5] & 255) > 3) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                bArr3[i4] = bArr2[i3];
                i4 = i6 + 1;
                i3 = i7 + 1;
                bArr3[i6] = bArr2[i7];
            } else if (bArr2[i3] == 0 && bArr2[i3 + 1] == 0 && bArr2[i5] == 3) {
                int i8 = i4 + 1;
                bArr3[i4] = 0;
                i4 = i8 + 1;
                bArr3[i8] = 0;
                i3 += 3;
            }
            bArr3[i4] = bArr2[i3];
            i4++;
            i3++;
        }
        while (i3 < i2) {
            bArr3[i4] = bArr2[i3];
            i4++;
            i3++;
        }
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr3, 0, bArr4, 0, i4);
        return bArr4;
    }

    /* renamed from: b */
    public static boolean m4400b(byte[] bArr, int i, int i2) {
        for (int i3 = 2; i3 < i2; i3 += 3) {
            int i4 = i + i3;
            if ((bArr[i4] & 255) <= 3) {
                if (i3 + 2 < i2 && bArr[i4 + 0] == 0 && bArr[i4 + 1] == 0 && (bArr[i4 + 2] & 255) <= 3) {
                    return true;
                }
                if (i3 + 1 < i2 && bArr[i4 - 1] == 0 && bArr[i4 + 0] == 0 && (bArr[i4 + 1] & 255) <= 3) {
                    return true;
                }
                if (i3 + 0 < i2 && bArr[i4 - 2] == 0 && bArr[i4 - 1] == 0 && (bArr[i4 + 0] & 255) <= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static byte[] m4403c(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 * 2)];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i3 + 2;
            if (i5 >= i2) {
                break;
            }
            int i6 = i + i3;
            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && (bArr[i6 + 2] & 255) <= 3) {
                int i7 = i4 + 1;
                bArr2[i4] = 0;
                int i8 = i7 + 1;
                bArr2[i7] = 0;
                bArr2[i8] = 3;
                i4 = i8 + 1;
                i3 = i5;
            } else {
                i3++;
                bArr2[i4] = bArr[i6];
                i4++;
            }
        }
        while (i3 < i2) {
            bArr2[i4] = bArr[i3 + i];
            i4++;
            i3++;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    /* renamed from: a */
    public static C4315a m4387a(byte[] bArr, int i) {
        C4315a aVar = new C4315a();
        int i2 = i + 6;
        try {
            aVar.f4477b = (bArr[i + 4] & 3) + 1;
            C4306b bVar = new C4306b(m4395a(bArr, i2 + 2, C4307c.m4292d(bArr, i2, 2)));
            bVar.mo59253a(8);
            aVar.f4476a = bVar.mo59257c(8);
            bVar.mo59253a(4);
            bVar.mo59253a(4);
            aVar.f4478c = bVar.mo59257c(8);
            aVar.f4479d = bVar.mo59262f();
            if (aVar.f4476a >= 100) {
                aVar.f4480e = bVar.mo59262f();
                aVar.f4481f = 0;
                if (aVar.f4480e == 3) {
                    aVar.f4481f = bVar.mo59257c(1);
                }
                aVar.f4482g = bVar.mo59262f();
                aVar.f4483h = bVar.mo59262f();
                aVar.f4484i = bVar.mo59257c(1);
                aVar.f4485j = bVar.mo59257c(1);
                if (aVar.f4485j == 1) {
                    m4389a(bVar, 16, f4538g[0]);
                    m4389a(bVar, 16, f4538g[0]);
                    m4389a(bVar, 16, f4538g[0]);
                    m4389a(bVar, 16, f4538g[1]);
                    m4389a(bVar, 16, f4538g[1]);
                    m4389a(bVar, 16, f4538g[1]);
                    if (aVar.f4476a >= 100) {
                        m4389a(bVar, 64, f4539h[0]);
                        m4389a(bVar, 64, f4539h[1]);
                    }
                }
            }
            aVar.f4486k = bVar.mo59262f() + 4;
            aVar.f4487l = bVar.mo59262f();
            aVar.f4488m = 0;
            if (aVar.f4487l == 0) {
                aVar.f4488m = bVar.mo59262f() + 4;
            } else if (aVar.f4487l == 1) {
                aVar.f4489n = bVar.mo59257c(1);
                aVar.f4490o = bVar.mo59260e();
                aVar.f4491p = bVar.mo59260e();
                aVar.f4492q = bVar.mo59262f();
                aVar.f4493r = new int[aVar.f4492q];
                for (int i3 = 0; i3 < aVar.f4492q; i3++) {
                    aVar.f4493r[i3] = bVar.mo59260e();
                }
            } else {
                int i4 = aVar.f4487l;
            }
            aVar.f4494s = bVar.mo59262f();
            aVar.f4495t = bVar.mo59257c(1);
            aVar.f4496u = bVar.mo59262f() + 1;
            aVar.f4497v = bVar.mo59262f() + 1;
            aVar.f4498w = bVar.mo59257c(1);
            aVar.f4499x = 0;
            if (aVar.f4498w == 0) {
                aVar.f4499x = bVar.mo59257c(1);
            }
            aVar.f4500y = aVar.f4496u;
            aVar.f4501z = aVar.f4497v * (2 - aVar.f4498w);
            aVar.f4454A = bVar.mo59257c(1);
            aVar.f4455B = bVar.mo59257c(1);
            aVar.f4456C = 0;
            aVar.f4457D = 0;
            aVar.f4458E = 0;
            aVar.f4459F = 0;
            if (aVar.f4455B != 0) {
                aVar.f4456C = bVar.mo59262f();
                aVar.f4457D = bVar.mo59262f();
                aVar.f4458E = bVar.mo59262f();
                aVar.f4459F = bVar.mo59262f();
            }
            aVar.f4460G = bVar.mo59257c(1);
            if (aVar.f4460G != 0) {
                aVar.f4468O = 0;
                aVar.f4469P = 0;
                aVar.f4470Q = 0;
                aVar.f4471R = bVar.mo59257c(1);
                if (aVar.f4471R != 0) {
                    aVar.f4470Q = bVar.mo59257c(8);
                    if (aVar.f4470Q == 255) {
                        aVar.f4468O = bVar.mo59257c(16);
                        aVar.f4469P = bVar.mo59257c(16);
                    } else if (aVar.f4470Q < f4537f.length) {
                        aVar.f4468O = f4537f[aVar.f4470Q][0];
                        aVar.f4469P = f4537f[aVar.f4470Q][1];
                    }
                }
                if (bVar.mo59257c(1) != 0) {
                    bVar.mo59257c(1);
                }
                aVar.f4461H = bVar.mo59257c(1);
                if (aVar.f4461H != 0) {
                    aVar.f4462I = bVar.mo59257c(3);
                    aVar.f4463J = bVar.mo59257c(1);
                    if (bVar.mo59257c(1) != 0) {
                        bVar.mo59257c(8);
                        bVar.mo59257c(8);
                        bVar.mo59257c(8);
                    }
                }
                if (bVar.mo59257c(1) != 0) {
                    bVar.mo59262f();
                    bVar.mo59262f();
                }
                if (bVar.mo59257c(1) != 0) {
                    aVar.f4464K = bVar.mo59261e(32);
                    aVar.f4465L = bVar.mo59261e(32);
                    aVar.f4466M = bVar.mo59257c(1);
                    if (aVar.f4464K > 0 && aVar.f4465L > 0) {
                        aVar.f4467N = ((double) Math.round(((double) (aVar.f4465L * 100)) / ((double) (aVar.f4464K * 2)))) / 100.0d;
                    }
                }
            }
            aVar.f4472S = 0;
            aVar.f4473T = (aVar.f4496u * 16) - ((aVar.f4456C + aVar.f4457D) * 2);
            if (aVar.f4498w != 0) {
                aVar.f4472S = (aVar.f4501z * 16) - ((aVar.f4458E + aVar.f4459F) * 2);
            } else {
                aVar.f4472S = (aVar.f4501z * 16) - ((aVar.f4458E + aVar.f4459F) * 4);
            }
            aVar.f4474U = aVar.f4472S;
            aVar.f4475V = aVar.f4473T;
            if (aVar.f4468O <= 0 || aVar.f4469P <= 0) {
                return aVar;
            }
            aVar.f4475V = (aVar.f4473T * aVar.f4468O) / aVar.f4469P;
            return aVar;
        } catch (Exception e) {
            WOWZLog.error(f4531a, "An exception occurred decoding the video stream codec config", (Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    static void m4389a(C4306b bVar, int i, byte[] bArr) {
        byte[] bArr2 = i == 16 ? f4540i : f4541j;
        if (bVar.mo59257c(1) == 1) {
            int i2 = 0;
            byte b = 8;
            byte b2 = 8;
            while (i2 < i) {
                if (b != 0) {
                    b = (bVar.mo59260e() + b2) & 255;
                }
                if (i2 != 0 || b != 0) {
                    byte b3 = bArr2[i2];
                    if (b != 0) {
                        b2 = b;
                    }
                    b2 = (byte) b2;
                    bArr[b3] = b2;
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    public static C4316b m4404d(byte[] bArr, int i, int i2) {
        C4316b bVar = new C4316b();
        if (4 > i2) {
            return bVar;
        }
        try {
            bVar.f4504c = new byte[3];
            System.arraycopy(bArr, i + 1, bVar.f4504c, 0, bVar.f4504c.length);
            int length = bVar.f4504c.length + 1 + 2;
            int i3 = length + 2;
            if (i3 > i2) {
                return bVar;
            }
            int d = C4307c.m4292d(bArr, length + i, 2);
            if (d <= 0) {
                return bVar;
            }
            if (d > i2 - i3) {
                return bVar;
            }
            bVar.f4502a = new byte[d];
            System.arraycopy(bArr, i + i3, bVar.f4502a, 0, bVar.f4502a.length);
            int length2 = i3 + bVar.f4502a.length;
            int i4 = length2 + 1;
            if (i4 > i2) {
                return bVar;
            }
            int d2 = C4307c.m4292d(bArr, length2 + i, 1);
            int i5 = i4;
            int i6 = 0;
            while (i6 < d2) {
                int i7 = i5 + 2;
                if (i7 > i2) {
                    return bVar;
                }
                int d3 = C4307c.m4292d(bArr, i5 + i, 2);
                if (d3 <= 0) {
                    return bVar;
                }
                if (d3 > i2 - i7) {
                    return bVar;
                }
                byte[] bArr2 = new byte[d3];
                System.arraycopy(bArr, i + i7, bArr2, 0, bArr2.length);
                int length3 = i7 + bArr2.length;
                bVar.mo59314a(bArr2);
                i6++;
                i5 = length3;
            }
            return bVar;
        } catch (Exception e) {
            WOWZLog.error(f4531a, "An exception occurred parsing the video stream codec config", (Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m4397a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        do {
            int i8 = i6 + i3;
            if (i8 > i2) {
                break;
            }
            int d = C4307c.m4292d(bArr, i + i6, i3);
            if (d <= 0 || i8 + d > i2) {
                return null;
            }
            i7++;
            i6 += d + i3;
        } while (i6 < i2);
        if (i7 <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[((i2 - (i3 * i7)) + (i7 * i4))];
        int i9 = 0;
        do {
            int i10 = i5 + i3;
            if (i10 > i2) {
                break;
            }
            int d2 = C4307c.m4292d(bArr, i5 + i, i3);
            C4307c.m4271a(d2, bArr2, i9, i4);
            int i11 = i9 + i4;
            System.arraycopy(bArr, i + i10, bArr2, i11, d2);
            i9 = i11 + d2;
            i5 = d2 + i10;
        } while (i5 < i2);
        return bArr2;
    }

    /* renamed from: a */
    public static C4312h m4385a(byte[] bArr, int i, int i2, int i3, C4316b bVar) {
        int i4;
        byte b;
        int d;
        int i5;
        byte[] bArr2 = bArr;
        int i6 = i2;
        int i7 = i3;
        C4316b bVar2 = bVar;
        C4312h hVar = new C4312h();
        int i8 = 4;
        byte[] bArr3 = new byte[4];
        bArr3[3] = 1;
        int i9 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            int i10 = i9 + 4;
            if (i10 > i6 || (d = C4307c.m4292d(bArr2, i + i9, i8)) <= 0 || (i5 = i10 + d) > i6) {
                break;
            }
            int i11 = i + i10;
            byte b2 = bArr2[i11] & Ascii.f275US;
            if (b2 == 7) {
                z3 = true;
            } else if (b2 == 8) {
                z = true;
            } else if (b2 == 9) {
                z2 = true;
            }
            hVar.mo59275a((C4310f) new C4311g(bArr3, 0, bArr3.length));
            hVar.mo59275a((C4310f) new C4311g(bArr2, i11, d));
            int length = bArr3.length;
            if (i5 >= i6) {
                break;
            }
            i9 = i5;
            i8 = 4;
        }
        if (z2) {
            i4 = 2;
            b = 1;
        } else if (z2) {
            b = 1;
            i4 = 0;
        } else {
            byte[] bArr4 = new byte[6];
            bArr4[3] = 1;
            bArr4[4] = 9;
            if (i7 == 1) {
                bArr4[5] = 16;
            } else if (i7 == 3) {
                bArr4[5] = 80;
            } else {
                bArr4[5] = ByteBuffer.ZERO;
            }
            hVar.mo59273a(0, new C4311g(bArr4, 0, bArr4.length));
            int length2 = bArr4.length;
            b = 1;
            i4 = 1;
        }
        if (i7 == b && (!z || !z2)) {
            if (i7 == b && !z3 && bVar2 != null && bVar2.f4502a != null) {
                byte[] bArr5 = new byte[4];
                bArr5[3] = b;
                hVar.mo59273a(i4, new C4311g(bArr5, 0, bArr5.length));
                int i12 = i4 + 1;
                hVar.mo59273a(i12, new C4311g(bVar2.f4502a, 0, bVar2.f4502a.length));
                b = 1;
                i4 = i12 + 1;
                int length3 = bVar2.f4502a.length;
                int length4 = bArr5.length;
            }
            if (i7 == b && !z && bVar2 != null && bVar2.f4503b != null) {
                for (byte[] next : bVar2.f4503b) {
                    byte[] bArr6 = new byte[4];
                    bArr6[3] = 1;
                    hVar.mo59273a(i4, new C4311g(bArr6, 0, bArr6.length));
                    int i13 = i4 + 1;
                    hVar.mo59273a(i13, new C4311g(next, 0, next.length));
                    i4 = i13 + 1;
                    int length5 = next.length;
                    int length6 = bArr6.length;
                }
            }
        }
        return hVar;
    }

    /* renamed from: a */
    public static final byte[] m4393a(C4326a aVar) {
        if (aVar.f4614a == null || aVar.f4615b == null) {
            return null;
        }
        return C4327a.m4495b(aVar.f4614a, aVar.f4615b, (byte[]) null);
    }

    /* renamed from: a */
    public static final byte[] m4394a(C4326a aVar, byte[] bArr) {
        if (aVar.f4614a == null || aVar.f4615b == null) {
            return null;
        }
        return C4327a.m4495b(aVar.f4614a, aVar.f4615b, bArr);
    }

    /* renamed from: a */
    public static final byte[] m4396a(byte[] bArr, int i, int i2, int i3) {
        byte b;
        int i4 = 0;
        boolean z = false;
        do {
            int i5 = i + i4;
            int d = C4307c.m4292d(bArr, i5, 4);
            if (d < 0 || i4 + d + 4 > i2) {
                break;
            }
            if ((b = bArr[i5 + 4] & Ascii.f275US) == 8 ? d == i2 - (i4 + 4) : b == 9 && d == i2 - (i4 + 4)) {
                z = true;
            }
            if (z) {
                break;
            }
            i4 += d + 4;
        } while (i4 < i2);
        if (!z) {
            return bArr;
        }
        if (i3 == 4) {
            int i6 = i4;
            while (i4 < i2 - 4) {
                int i7 = i + i4;
                if (bArr[i7 + 0] == 0 && bArr[i7 + 1] == 0 && bArr[i7 + 2] == 0 && bArr[i7 + 3] == 1) {
                    C4307c.m4271a((i4 - i6) - 4, bArr, i6 + i, 4);
                    i6 = i4;
                }
                i4++;
            }
            C4307c.m4271a((i2 - i6) - 4, bArr, i + i6, 4);
            return bArr;
        } else if (i3 != 3) {
            return bArr;
        } else {
            ArrayList<int[]> arrayList = new ArrayList<>();
            int i8 = i4 + 1;
            int i9 = i8;
            int i10 = 0;
            while (i8 < i2 - 3) {
                int i11 = i + i8;
                if (bArr[i11 + 0] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 1) {
                    i10++;
                    arrayList.add(new int[]{i9 + 3, (i8 - i9) - 3});
                    i9 = i8;
                }
                i8++;
            }
            arrayList.add(new int[]{i9 + 3, (i2 - i9) - 3});
            byte[] bArr2 = new byte[(i2 + i + i10)];
            System.arraycopy(bArr, 0, bArr2, 0, i + i4);
            for (int[] iArr : arrayList) {
                C4307c.m4271a(iArr[1], bArr2, i + i4, 4);
                int i12 = i4 + 4;
                System.arraycopy(bArr, iArr[0] + i, bArr2, i + i12, iArr[1]);
                i4 = i12 + iArr[1];
            }
            return bArr2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r0[r7] == 80) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008e, code lost:
        if (r3 != 6) goto L_0x0091;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096 A[LOOP:0: B:1:0x000a->B:44:0x0096, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0095 A[EDGE_INSN: B:46:0x0095->B:43:0x0095 ?: BREAK  , SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int m4398b(byte[] r16, int r17, int r18, int r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = 0
            r4 = 2
            r5 = 0
            r6 = 2
        L_0x000a:
            int r7 = r17 + r5
            int r8 = com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c.m4292d(r0, r7, r2)
            if (r8 >= 0) goto L_0x0014
            goto L_0x0095
        L_0x0014:
            int r9 = r5 + r8
            int r9 = r9 + r2
            if (r9 <= r1) goto L_0x001b
            goto L_0x0095
        L_0x001b:
            int r7 = r7 + r2
            byte r9 = r0[r7]
            r9 = r9 & 31
            r10 = 7
            r11 = 3
            r12 = 1
            if (r9 == r12) goto L_0x0048
            r13 = 5
            if (r9 == r13) goto L_0x0046
            if (r9 == r10) goto L_0x0091
            r10 = 8
            if (r9 == r10) goto L_0x0091
            r10 = 9
            if (r9 == r10) goto L_0x0033
            goto L_0x0091
        L_0x0033:
            if (r8 < r4) goto L_0x0091
            int r7 = r7 + 1
            byte r9 = r0[r7]
            r10 = 16
            if (r9 != r10) goto L_0x003e
            goto L_0x0046
        L_0x003e:
            byte r7 = r0[r7]
            r9 = 80
            if (r7 != r9) goto L_0x0091
        L_0x0044:
            r6 = 3
            goto L_0x0091
        L_0x0046:
            r6 = 1
            goto L_0x0091
        L_0x0048:
            r9 = 20
            byte[] r13 = new byte[r9]
            byte[] r9 = new byte[r9]
            int r14 = r13.length
            int r15 = r8 + -1
            if (r14 <= r15) goto L_0x0054
            r14 = r15
        L_0x0054:
            int r7 = r7 + 1
            java.lang.System.arraycopy(r0, r7, r13, r3, r14)
            r7 = 0
            r15 = 0
        L_0x005b:
            if (r7 >= r14) goto L_0x007a
            if (r7 < r4) goto L_0x0070
            byte r3 = r13[r7]
            if (r3 != r11) goto L_0x0070
            int r3 = r7 + -1
            byte r3 = r13[r3]
            if (r3 != 0) goto L_0x0070
            int r3 = r7 + -2
            byte r3 = r13[r3]
            if (r3 != 0) goto L_0x0070
            goto L_0x0076
        L_0x0070:
            byte r3 = r13[r7]
            r9[r15] = r3
            int r15 = r15 + 1
        L_0x0076:
            int r7 = r7 + 1
            r3 = 0
            goto L_0x005b
        L_0x007a:
            com.wowza.gocoder.sdk.support.wmstransport.a.b r3 = new com.wowza.gocoder.sdk.support.wmstransport.a.b
            r3.<init>(r9, r15)
            r3.mo59262f()
            int r3 = r3.mo59262f()
            if (r3 == r4) goto L_0x0046
            if (r3 != r10) goto L_0x008b
            goto L_0x0046
        L_0x008b:
            if (r3 == r12) goto L_0x0044
            r7 = 6
            if (r3 != r7) goto L_0x0091
            goto L_0x0044
        L_0x0091:
            int r8 = r8 + r2
            int r5 = r5 + r8
            if (r5 < r1) goto L_0x0096
        L_0x0095:
            return r6
        L_0x0096:
            r3 = 0
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c.m4398b(byte[], int, int, int):int");
    }

    /* renamed from: e */
    public static final C4326a m4407e(byte[] bArr, int i, int i2) {
        C4326a aVar = null;
        int i3 = 0;
        do {
            int i4 = i + i3;
            int d = C4307c.m4292d(bArr, i4, 4);
            if (d >= 0 && i3 + d + 4 <= i2) {
                int i5 = i4 + 4;
                byte b = bArr[i5] & Ascii.f275US;
                if (b == 7) {
                    if (aVar == null) {
                        aVar = new C4326a();
                    }
                    aVar.f4614a = new byte[d];
                    System.arraycopy(bArr, i5, aVar.f4614a, 0, d);
                } else if (b == 8) {
                    if (aVar == null) {
                        aVar = new C4326a();
                    }
                    if (aVar.f4615b == null) {
                        aVar.f4615b = new ArrayList();
                    }
                    byte[] bArr2 = new byte[d];
                    System.arraycopy(bArr, i5, bArr2, 0, d);
                    aVar.f4615b.add(bArr2);
                }
                i3 += d + 4;
            }
        } while (i3 < i2);
        return aVar;
    }

    /* renamed from: a */
    public static final byte[] m4392a(C4316b bVar) {
        int i;
        int length = (bVar.f4502a != null ? bVar.f4502a.length + 4 : 0) + 0;
        if (bVar.f4503b != null) {
            for (byte[] length2 : bVar.f4503b) {
                length += length2.length + 4;
            }
        }
        byte[] bArr = new byte[length];
        if (bVar.f4502a != null) {
            bArr[3] = 1;
            System.arraycopy(bVar.f4502a, 0, bArr, 4, bVar.f4502a.length);
            i = bVar.f4502a.length + 4;
        } else {
            i = 0;
        }
        if (bVar.f4503b != null) {
            for (byte[] next : bVar.f4503b) {
                bArr[i + 3] = 1;
                int i2 = i + 4;
                System.arraycopy(next, 0, bArr, i2, next.length);
                i = i2 + next.length;
            }
        }
        return bArr;
    }

    /* renamed from: e */
    public static String m4408e(int i) {
        "" + i;
        switch (i) {
            case 1:
                return "SLICE";
            case 2:
                return "DPA";
            case 3:
                return "DPB";
            case 4:
                return "DPC";
            case 5:
                return "IDR_SLICE";
            case 6:
                return "SEI";
            case 7:
                return "SPS";
            case 8:
                return "PPS";
            case 9:
                return "AUD";
            case 10:
                return "END_SEQUENCE";
            case 11:
                return "END_STREAM";
            case 12:
                return "FILLER_DATA";
            default:
                if (i < 13 || i > 23) {
                    return "UNDEFINED[" + i + "]";
                }
                return "EXTENDED[" + i + "]";
        }
    }

    /* renamed from: a */
    public static final void m4390a(byte[] bArr, int i, int i2, List<C4310f> list) {
        m4391a(bArr, i, i2, list, 4);
    }

    /* renamed from: a */
    public static final void m4391a(byte[] bArr, int i, int i2, List<C4310f> list, int i3) {
        int i4 = 0;
        do {
            int i5 = i + i4;
            int d = C4307c.m4292d(bArr, i5, i3);
            if (d >= 0 && i4 + d + i3 <= i2) {
                int i6 = i5 + i3;
                if ((bArr[i6] & Ascii.f275US) == 6 && i4 + i3 + d <= i2) {
                    byte[] bArr2 = new byte[d];
                    System.arraycopy(bArr, i6, bArr2, 0, d);
                    list.add(new C4311g(bArr2, 0, bArr2.length));
                }
                i4 += d + i3;
            } else {
                return;
            }
        } while (i4 < i2);
    }

    /* renamed from: f */
    public static final void m4411f(byte[] bArr, int i, int i2) {
        m4401c(bArr, i, i2, 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        if (r0[r8] == 80) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00dc, code lost:
        if (r3 != 6) goto L_0x00e1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fe A[LOOP:0: B:1:0x0020->B:47:0x00fe, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e5 A[EDGE_INSN: B:48:0x00e5->B:45:0x00e5 ?: BREAK  , SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4401c(byte[] r16, int r17, int r18, int r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "debugNALUnits: start: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "H264Utils"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r4, r3)
            r3 = 0
            r5 = 2
            r6 = 0
            r7 = 2
        L_0x0020:
            int r8 = r17 + r6
            int r9 = com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c.m4292d(r0, r8, r2)
            if (r9 >= 0) goto L_0x002a
            goto L_0x00e5
        L_0x002a:
            int r10 = r6 + r9
            int r10 = r10 + r2
            if (r10 <= r1) goto L_0x0031
            goto L_0x00e5
        L_0x0031:
            int r8 = r8 + r2
            byte r10 = r0[r8]
            r10 = r10 & 31
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "debugNALUnits:   nalType["
            r11.append(r12)
            java.lang.String r12 = m4408e(r10)
            r11.append(r12)
            java.lang.String r12 = "]: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r4, r11)
            r11 = 7
            r12 = 3
            r13 = 1
            if (r10 == r13) goto L_0x0080
            r14 = 5
            if (r10 == r14) goto L_0x007e
            if (r10 == r11) goto L_0x00e1
            r11 = 8
            if (r10 == r11) goto L_0x00e1
            r11 = 9
            if (r10 == r11) goto L_0x006a
            goto L_0x00e1
        L_0x006a:
            if (r9 < r5) goto L_0x00e1
            int r8 = r8 + 1
            byte r10 = r0[r8]
            r11 = 16
            if (r10 != r11) goto L_0x0075
            goto L_0x007e
        L_0x0075:
            byte r8 = r0[r8]
            r10 = 80
            if (r8 != r10) goto L_0x00e1
        L_0x007b:
            r7 = 3
            goto L_0x00e1
        L_0x007e:
            r7 = 1
            goto L_0x00e1
        L_0x0080:
            r10 = 20
            byte[] r14 = new byte[r10]
            byte[] r10 = new byte[r10]
            int r15 = r14.length
            int r13 = r9 + -1
            if (r15 <= r13) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r13 = r15
        L_0x008d:
            int r8 = r8 + 1
            java.lang.System.arraycopy(r0, r8, r14, r3, r13)
            r8 = 0
            r15 = 0
        L_0x0094:
            if (r8 >= r13) goto L_0x00b3
            if (r8 < r5) goto L_0x00a9
            byte r3 = r14[r8]
            if (r3 != r12) goto L_0x00a9
            int r3 = r8 + -1
            byte r3 = r14[r3]
            if (r3 != 0) goto L_0x00a9
            int r3 = r8 + -2
            byte r3 = r14[r3]
            if (r3 != 0) goto L_0x00a9
            goto L_0x00af
        L_0x00a9:
            byte r3 = r14[r8]
            r10[r15] = r3
            int r15 = r15 + 1
        L_0x00af:
            int r8 = r8 + 1
            r3 = 0
            goto L_0x0094
        L_0x00b3:
            com.wowza.gocoder.sdk.support.wmstransport.a.b r3 = new com.wowza.gocoder.sdk.support.wmstransport.a.b
            r3.<init>(r10, r15)
            r3.mo59262f()
            int r3 = r3.mo59262f()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "debugNALUnits:     sliceType: "
            r8.append(r10)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r4, r8)
            if (r3 == r5) goto L_0x00df
            if (r3 != r11) goto L_0x00d8
            goto L_0x00df
        L_0x00d8:
            r8 = 1
            if (r3 == r8) goto L_0x007b
            r8 = 6
            if (r3 != r8) goto L_0x00e1
            goto L_0x007b
        L_0x00df:
            r8 = 1
            goto L_0x007e
        L_0x00e1:
            int r9 = r9 + r2
            int r6 = r6 + r9
            if (r6 < r1) goto L_0x00fe
        L_0x00e5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "debugNALUnits: frameType: "
            r0.append(r1)
            java.lang.String r1 = com.wowza.gocoder.sdk.support.wmstransport.p041a.C4308d.m4298a((int) r7)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r4, r0)
            return
        L_0x00fe:
            r3 = 0
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c.m4401c(byte[], int, int, int):void");
    }

    /* renamed from: g */
    public static final void m4413g(byte[] bArr, int i, int i2) {
        m4411f(bArr, i, i2);
    }

    /* renamed from: d */
    public static final void m4406d(byte[] bArr, int i, int i2, int i3) {
        m4401c(bArr, i, i2, i3);
    }

    /* renamed from: a */
    public static int m4384a(int i, int i2, double d, int i3) {
        double d2 = (double) (((i + 15) / 16) * ((i2 + 15) / 16));
        if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d = 29.97d;
        }
        int i4 = (int) (d2 * d);
        int i5 = 0;
        while (true) {
            int[][] iArr = f4535d;
            if (i5 >= iArr.length || i4 <= iArr[i5][1]) {
                int[][] iArr2 = f4535d;
            } else {
                i5++;
            }
        }
        int[][] iArr22 = f4535d;
        if (i5 >= iArr22.length) {
            i5 = iArr22.length - 1;
        }
        int i6 = 0;
        while (true) {
            int[][] iArr3 = f4535d;
            if (i6 >= iArr3.length || i3 <= iArr3[i6][2] * 1024) {
                int[][] iArr4 = f4535d;
            } else {
                i6++;
            }
        }
        int[][] iArr42 = f4535d;
        if (i6 >= iArr42.length) {
            i6 = iArr42.length - 1;
        }
        if (i6 <= i5) {
            i6 = i5;
        }
        return f4535d[i6][0];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r5 = false;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m4414h(byte[] r9, int r10, int r11) {
        /*
            r0 = -1
            r1 = 0
            r0 = 0
            r2 = -1
        L_0x0004:
            int r3 = r11 + -4
            r4 = 4
            if (r0 >= r3) goto L_0x004b
            int r3 = r10 + r0
            byte r3 = r9[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r5 = 1
            if (r3 > r5) goto L_0x0049
            r6 = r0
            r3 = 0
        L_0x0014:
            r7 = 3
            if (r3 > r7) goto L_0x003a
            int r7 = r10 + r6
            int r8 = r7 + 0
            byte r8 = r9[r8]
            if (r8 != 0) goto L_0x0032
            int r8 = r7 + 1
            byte r8 = r9[r8]
            if (r8 != 0) goto L_0x0032
            int r8 = r7 + 2
            byte r8 = r9[r8]
            if (r8 != 0) goto L_0x0032
            int r7 = r7 + 3
            byte r7 = r9[r7]
            if (r7 != r5) goto L_0x0032
            goto L_0x003b
        L_0x0032:
            if (r6 != 0) goto L_0x0035
            goto L_0x003a
        L_0x0035:
            int r6 = r6 + -1
            int r3 = r3 + 1
            goto L_0x0014
        L_0x003a:
            r5 = 0
        L_0x003b:
            if (r5 != 0) goto L_0x003e
            goto L_0x0049
        L_0x003e:
            if (r2 < 0) goto L_0x0047
            int r0 = r6 - r2
            int r0 = r0 - r4
            int r2 = r2 + r10
            com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c.m4271a((int) r0, (byte[]) r9, (int) r2, (int) r4)
        L_0x0047:
            r0 = r6
            r2 = r0
        L_0x0049:
            int r0 = r0 + r4
            goto L_0x0004
        L_0x004b:
            if (r2 < 0) goto L_0x0053
            int r11 = r11 - r2
            int r11 = r11 - r4
            int r10 = r10 + r2
            com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c.m4271a((int) r11, (byte[]) r9, (int) r10, (int) r4)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c.m4414h(byte[], int, int):void");
    }

    /* renamed from: i */
    public static byte[] m4415i(byte[] bArr, int i, int i2) {
        int i3;
        byte b;
        ArrayList<C4311g> arrayList = new ArrayList<>();
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        while (true) {
            if (i5 >= i2 - 3) {
                i5 = i6;
                break;
            }
            int i8 = i + i5;
            int i9 = i8 + 0;
            if (bArr[i9] == 0 && bArr[i8 + 1] == 0 && bArr[i8 + 2] == 0 && bArr[i8 + 3] == 1) {
                i3 = 4;
            } else {
                i3 = (bArr[i9] == 0 && bArr[i8 + 1] == 0 && bArr[i8 + 2] == 1) ? 3 : 0;
            }
            if (i3 > 0) {
                if (i6 >= 0) {
                    int i10 = i5 - i6;
                    arrayList.add(new C4311g(bArr, i6 + i, i10));
                    i7 += i10 + 4;
                }
                i5 += i3;
                if (i5 < i2 && ((b = bArr[i5] & Ascii.f275US) == 5 || b == 1)) {
                    break;
                }
                i6 = i5;
            }
            i5++;
        }
        if (i5 >= 0) {
            int i11 = i2 - i5;
            arrayList.add(new C4311g(bArr, i + i5, i11));
            i7 += i11 + 4;
        }
        byte[] bArr2 = new byte[i7];
        for (C4311g gVar : arrayList) {
            C4307c.m4271a(gVar.mo59269c(), bArr2, i4, 4);
            int i12 = i4 + 4;
            System.arraycopy(gVar.mo59266a(), gVar.mo59267b(), bArr2, i12, gVar.mo59269c());
            i4 = i12 + gVar.mo59269c();
        }
        return bArr2;
    }

    /* renamed from: j */
    public static void m4416j(byte[] bArr, int i, int i2) {
        m4409e(bArr, i, i2, 4);
    }

    /* renamed from: e */
    public static void m4409e(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        do {
            int i5 = i + i4;
            int d = C4307c.m4292d(bArr, i5, i3);
            if (d >= 0 && i4 + d + i3 <= i2) {
                C4307c.m4271a(1, bArr, i5, i3);
                i4 += d + i3;
            } else {
                return;
            }
        } while (i4 < i2);
    }
}
