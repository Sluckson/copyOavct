package com.lowagie.text.pdf;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.google.android.exoplayer2.extractor.p008ts.TsExtractor;
import com.google.common.primitives.SignedBytes;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;
import com.lowagie.text.Jpeg;
import com.lowagie.text.pdf.codec.CCITTG4Encoder;
import com.lowagie.text.pdf.codec.TIFFConstants;
import com.lowagie.text.pdf.codec.wmf.MetaDo;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c;
import com.wowza.gocoder.sdk.support.wse.jni.wmstransport.WMSTransport;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Hashtable;
import p052cz.msebera.android.httpclient.HttpStatus;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

public class BarcodeDatamatrix {
    public static final int DM_ASCII = 1;
    public static final int DM_AUTO = 0;
    public static final int DM_B256 = 4;
    public static final int DM_C40 = 2;
    public static final int DM_EDIFACT = 6;
    public static final int DM_ERROR_EXTENSION = 5;
    public static final int DM_ERROR_INVALID_SQUARE = 3;
    public static final int DM_ERROR_TEXT_TOO_BIG = 1;
    public static final int DM_EXTENSION = 32;
    public static final int DM_NO_ERROR = 0;
    public static final int DM_RAW = 7;
    public static final int DM_TEST = 64;
    public static final int DM_TEXT = 3;
    public static final int DM_X21 = 5;
    private static final DmParams[] dmSizes = {new DmParams(10, 10, 10, 10, 3, 3, 5), new DmParams(12, 12, 12, 12, 5, 5, 7), new DmParams(8, 18, 8, 18, 5, 5, 7), new DmParams(14, 14, 14, 14, 8, 8, 10), new DmParams(8, 32, 8, 16, 10, 10, 11), new DmParams(16, 16, 16, 16, 12, 12, 12), new DmParams(12, 26, 12, 26, 16, 16, 14), new DmParams(18, 18, 18, 18, 18, 18, 14), new DmParams(20, 20, 20, 20, 22, 22, 18), new DmParams(12, 36, 12, 18, 22, 22, 18), new DmParams(22, 22, 22, 22, 30, 30, 20), new DmParams(16, 36, 16, 18, 32, 32, 24), new DmParams(24, 24, 24, 24, 36, 36, 24), new DmParams(26, 26, 26, 26, 44, 44, 28), new DmParams(16, 48, 16, 24, 49, 49, 28), new DmParams(32, 32, 16, 16, 62, 62, 36), new DmParams(36, 36, 18, 18, 86, 86, 42), new DmParams(40, 40, 20, 20, 114, 114, 48), new DmParams(44, 44, 22, 22, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 56), new DmParams(48, 48, 24, 24, 174, 174, 68), new DmParams(52, 52, 26, 26, HttpStatus.SC_NO_CONTENT, 102, 42), new DmParams(64, 64, 16, 16, TIFFConstants.TIFFTAG_MINSAMPLEVALUE, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 56), new DmParams(72, 72, 18, 18, 368, 92, 36), new DmParams(80, 80, 20, 20, 456, 114, 48), new DmParams(88, 88, 22, 22, 576, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 56), new DmParams(96, 96, 24, 24, 696, 174, 68), new DmParams(104, 104, 26, 26, 816, 136, 56), new DmParams(120, 120, 20, 20, 1050, 175, 68), new DmParams(132, 132, 22, 22, 1304, 163, 62), new DmParams(CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 24, 24, 1558, 156, 62)};
    private static final String x12 = "\r*> 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int extOut;
    private int height;
    private byte[] image;
    private int options;
    private short[] place;
    private int width;

    /* renamed from: ws */
    private int f612ws;

    private static boolean isDigit(int i) {
        return i >= 48 && i <= 57;
    }

    private void setBit(int i, int i2, int i3) {
        byte[] bArr = this.image;
        int i4 = (i2 * i3) + (i / 8);
        bArr[i4] = (byte) (((byte) (128 >> (i & 7))) | bArr[i4]);
    }

    private void draw(byte[] bArr, int i, DmParams dmParams) {
        int i2;
        int i3 = ((dmParams.width + (this.f612ws * 2)) + 7) / 8;
        Arrays.fill(this.image, (byte) 0);
        int i4 = this.f612ws;
        while (true) {
            int i5 = dmParams.height;
            int i6 = this.f612ws;
            if (i4 >= i5 + i6) {
                break;
            }
            while (i6 < dmParams.width + this.f612ws) {
                setBit(i6, i4, i3);
                i6 += 2;
            }
            i4 += dmParams.heightSection;
        }
        int i7 = (dmParams.heightSection - 1) + this.f612ws;
        while (true) {
            int i8 = dmParams.height;
            i2 = this.f612ws;
            if (i7 >= i8 + i2) {
                break;
            }
            while (i2 < dmParams.width + this.f612ws) {
                setBit(i2, i7, i3);
                i2++;
            }
            i7 += dmParams.heightSection;
        }
        int i9 = i2;
        while (true) {
            int i10 = dmParams.width;
            int i11 = this.f612ws;
            if (i9 >= i10 + i11) {
                break;
            }
            while (i11 < dmParams.height + this.f612ws) {
                setBit(i9, i11, i3);
                i11++;
            }
            i9 += dmParams.widthSection;
        }
        int i12 = (dmParams.widthSection - 1) + this.f612ws;
        while (true) {
            int i13 = dmParams.width;
            int i14 = this.f612ws;
            if (i12 >= i13 + i14) {
                break;
            }
            for (int i15 = i14 + 1; i15 < dmParams.height + this.f612ws; i15 += 2) {
                setBit(i12, i15, i3);
            }
            i12 += dmParams.widthSection;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < dmParams.height) {
            for (int i18 = 1; i18 < dmParams.heightSection - 1; i18++) {
                int i19 = 0;
                while (i19 < dmParams.width) {
                    int i20 = i17;
                    int i21 = 1;
                    while (i21 < dmParams.widthSection - 1) {
                        int i22 = i20 + 1;
                        short s = this.place[i20];
                        if (s != 1) {
                            if (s > 1) {
                                if (((128 >> (s % 8)) & bArr[(s / 8) - 1] & 255) == 0) {
                                }
                            }
                            i21++;
                            i20 = i22;
                        }
                        int i23 = this.f612ws;
                        setBit(i21 + i19 + i23, i18 + i16 + i23, i3);
                        i21++;
                        i20 = i22;
                    }
                    i19 += dmParams.widthSection;
                    i17 = i20;
                }
            }
            i16 += dmParams.heightSection;
        }
    }

    private static void makePadding(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            int i3 = i + 1;
            bArr[i] = -127;
            while (true) {
                i2--;
                if (i2 > 0) {
                    int i4 = i3 + 1;
                    int i5 = ((i4 * CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA) % 253) + 129 + 1;
                    if (i5 > 254) {
                        i5 -= 254;
                    }
                    bArr[i3] = (byte) i5;
                    i3 = i4;
                } else {
                    return;
                }
            }
        }
    }

    private static int asciiEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i2 + i;
        int i6 = i4 + i3;
        int i7 = i3;
        while (i < i5) {
            if (i7 >= i6) {
                return -1;
            }
            int i8 = i + 1;
            byte b = bArr[i] & 255;
            if (!isDigit(b) || i8 >= i5 || !isDigit(bArr[i8] & 255)) {
                if (b > Byte.MAX_VALUE) {
                    int i9 = i7 + 1;
                    if (i9 >= i6) {
                        return -1;
                    }
                    bArr2[i7] = -21;
                    i7 = i9 + 1;
                    bArr2[i9] = (byte) ((b - 128) + 1);
                } else {
                    bArr2[i7] = (byte) (b + 1);
                    i7++;
                }
                i = i8;
            } else {
                bArr2[i7] = (byte) (((((b - 48) * 10) + (bArr[i8] & 255)) - 48) + TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                i7++;
                i = i8 + 1;
            }
        }
        return i7 - i3;
    }

    private static int b256Encodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 250 && i2 + 2 > i4) {
            return -1;
        }
        if (i2 >= 250 && i2 + 3 > i4) {
            return -1;
        }
        bArr2[i3] = -25;
        if (i2 < 250) {
            bArr2[i3 + 1] = (byte) i2;
            i5 = 2;
        } else {
            bArr2[i3 + 1] = (byte) ((i2 / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249);
            bArr2[i3 + 2] = (byte) (i2 % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            i5 = 3;
        }
        System.arraycopy(bArr, i, bArr2, i5 + i3, i2);
        int i6 = i5 + i2 + i3;
        int i7 = i3 + 1;
        while (i7 < i6) {
            int i8 = i7 + 1;
            int i9 = (bArr2[i7] & 255) + ((i8 * CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA) % 255) + 1;
            if (i9 > 255) {
                i9 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr2[i7] = (byte) i9;
            i7 = i8;
        }
        return i6 - i3;
    }

    private static int X12Encodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte b;
        int i5 = 0;
        if (i2 == 0) {
            return 0;
        }
        byte[] bArr3 = new byte[i2];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            b = 100;
            if (i6 >= i2) {
                break;
            }
            int indexOf = x12.indexOf((char) bArr[i6 + i]);
            if (indexOf >= 0) {
                bArr3[i6] = (byte) indexOf;
                i7++;
            } else {
                bArr3[i6] = 100;
                if (i7 >= 6) {
                    i7 -= (i7 / 3) * 3;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    bArr3[(i6 - i8) - 1] = 100;
                }
                i7 = 0;
            }
            i6++;
        }
        if (i7 >= 6) {
            i7 -= (i7 / 3) * 3;
        }
        int i9 = i7;
        for (int i10 = 0; i10 < i9; i10++) {
            bArr3[(i6 - i10) - 1] = 100;
        }
        int i11 = 0;
        while (i5 < i2) {
            byte b2 = bArr3[i5];
            if (i11 >= i4) {
                break;
            }
            if (b2 < 40) {
                if (i5 == 0 || (i5 > 0 && bArr3[i5 - 1] > 40)) {
                    bArr2[i11 + i3] = -18;
                    i11++;
                }
                if (i11 + 2 > i4) {
                    break;
                }
                i5 += 2;
                int i12 = (bArr3[i5] * SignedBytes.MAX_POWER_OF_TWO) + (bArr3[i5 + 1] * 40) + bArr3[i5] + 1;
                int i13 = i11 + 1;
                bArr2[i11 + i3] = (byte) (i12 / 256);
                i11 = i13 + 1;
                bArr2[i13 + i3] = (byte) i12;
            } else {
                if (i5 > 0 && bArr3[i5 - 1] < 40) {
                    bArr2[i11 + i3] = -2;
                    i11++;
                }
                int i14 = bArr[i5 + i] & 255;
                if (i14 > 127) {
                    bArr2[i11 + i3] = -21;
                    i14 -= 128;
                    i11++;
                }
                if (i11 >= i4) {
                    break;
                }
                bArr2[i11 + i3] = (byte) (i14 + 1);
                i11++;
            }
            i5++;
        }
        if (i2 > 0) {
            b = bArr3[i2 - 1];
        }
        if (i5 != i2) {
            return -1;
        }
        if (b < 40 && i11 >= i4) {
            return -1;
        }
        if (b >= 40) {
            return i11;
        }
        int i15 = i11 + 1;
        bArr2[i3 + i11] = -2;
        return i15;
    }

    private static int EdifactEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6 = i2;
        int i7 = i4;
        if (i6 == 0) {
            return 0;
        }
        int i8 = 0;
        boolean z = true;
        int i9 = 0;
        int i10 = 18;
        int i11 = 0;
        while (i8 < i6) {
            int i12 = bArr[i8 + i] & 255;
            int i13 = i12 & 224;
            if ((i13 == 64 || i13 == 32) && i12 != 95) {
                if (z) {
                    int i14 = i11 + 1;
                    if (i14 > i7) {
                        break;
                    }
                    bArr2[i3 + i11] = -16;
                    i11 = i14;
                    z = false;
                }
                i9 |= (i12 & 63) << i10;
                if (i10 != 0) {
                    i10 -= 6;
                } else if (i11 + 3 > i7) {
                    break;
                } else {
                    int i15 = i11 + 1;
                    bArr2[i3 + i11] = (byte) (i9 >> 16);
                    int i16 = i15 + 1;
                    bArr2[i3 + i15] = (byte) (i9 >> 8);
                    bArr2[i3 + i16] = (byte) i9;
                    i11 = i16 + 1;
                    i9 = 0;
                    i10 = 18;
                }
            } else {
                if (!z) {
                    i9 |= 31 << i10;
                    if ((3 - (i10 / 8)) + i11 > i7) {
                        break;
                    }
                    int i17 = i11 + 1;
                    bArr2[i3 + i11] = (byte) (i9 >> 16);
                    if (i10 <= 12) {
                        bArr2[i3 + i17] = (byte) (i9 >> 8);
                        i17++;
                    }
                    if (i10 <= 6) {
                        bArr2[i3 + i17] = (byte) i9;
                        i17++;
                    }
                    i11 = i17;
                    z = true;
                    i9 = 0;
                    i10 = 18;
                }
                if (i12 > 127) {
                    if (i11 >= i7) {
                        break;
                    }
                    bArr2[i3 + i11] = -21;
                    i12 -= 128;
                    i11++;
                }
                if (i11 >= i7) {
                    break;
                }
                bArr2[i3 + i11] = (byte) (i12 + 1);
                i11++;
            }
            i8++;
        }
        if (i8 != i6) {
            return -1;
        }
        if (z) {
            return i11;
        }
        int i18 = (31 << i10) | i9;
        if ((3 - (i10 / 8)) + i11 > i7) {
            return -1;
        }
        int i19 = i11 + 1;
        bArr2[i3 + i11] = (byte) (i18 >> 16);
        if (i10 <= 12) {
            bArr2[i3 + i19] = (byte) (i18 >> 8);
            i5 = i19 + 1;
        } else {
            i5 = i19;
        }
        if (i10 > 6) {
            return i5;
        }
        bArr2[i3 + i5] = (byte) i18;
        return i5 + 1;
    }

    private static int C40OrTextEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        String str;
        String str2;
        int i5;
        int i6;
        int i7 = i2;
        if (i7 == 0) {
            return 0;
        }
        if (z) {
            bArr2[i3 + 0] = -26;
        } else {
            bArr2[i3 + 0] = -17;
        }
        if (z) {
            str2 = " 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            str = "`abcdefghijklmnopqrstuvwxyz{|}~";
        } else {
            str2 = " 0123456789abcdefghijklmnopqrstuvwxyz";
            str = "`ABCDEFGHIJKLMNOPQRSTUVWXYZ{|}~";
        }
        int[] iArr = new int[((i7 * 4) + 10)];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i8 < i7) {
            if (i9 % 3 == 0) {
                i10 = i8;
                i11 = i9;
            }
            int i12 = i8 + 1;
            int i13 = bArr[i8 + i] & 255;
            if (i13 > 127) {
                i13 -= 128;
                int i14 = i9 + 1;
                iArr[i9] = 1;
                i9 = i14 + 1;
                iArr[i14] = 30;
            }
            char c = (char) i13;
            int indexOf = str2.indexOf(c);
            if (indexOf >= 0) {
                iArr[i9] = indexOf + 3;
                i9++;
            } else if (i13 < 32) {
                int i15 = i9 + 1;
                iArr[i9] = 0;
                i9 = i15 + 1;
                iArr[i15] = i13;
            } else {
                int indexOf2 = "!\"#$%&'()*+,-./:;<=>?@[\\]^_".indexOf(c);
                if (indexOf2 >= 0) {
                    int i16 = i9 + 1;
                    iArr[i9] = 1;
                    i9 = i16 + 1;
                    iArr[i16] = indexOf2;
                } else {
                    int indexOf3 = str.indexOf(c);
                    if (indexOf3 >= 0) {
                        int i17 = i9 + 1;
                        iArr[i9] = 2;
                        i9 = i17 + 1;
                        iArr[i17] = indexOf3;
                    }
                }
            }
            i8 = i12;
        }
        if (i9 % 3 != 0) {
            i5 = i10;
            i6 = i11;
        } else {
            i5 = i8;
            i6 = i9;
        }
        if ((i6 / 3) * 2 > i4 - 2) {
            return -1;
        }
        int i18 = 1;
        for (int i19 = 0; i19 < i6; i19 += 3) {
            int i20 = (iArr[i19] * 1600) + (iArr[i19 + 1] * 40) + iArr[i19 + 2] + 1;
            int i21 = i18 + 1;
            bArr2[i3 + i18] = (byte) (i20 / 256);
            i18 = i21 + 1;
            bArr2[i3 + i21] = (byte) i20;
        }
        int i22 = i18 + 1;
        bArr2[i18] = -2;
        int asciiEncodation = asciiEncodation(bArr, i5, i7 - i5, bArr2, i22, i4 - i22);
        return asciiEncodation < 0 ? asciiEncodation : i22 + asciiEncodation;
    }

    private static int getEncodation(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, boolean z) {
        int i6 = i2;
        int i7 = i4;
        int[] iArr = new int[6];
        if (i7 < 0) {
            return -1;
        }
        int i8 = i5 & 7;
        if (i8 == 0) {
            iArr[0] = asciiEncodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[0] >= 0) {
                return iArr[0];
            }
            iArr[1] = C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
            if (z && iArr[1] >= 0) {
                return iArr[1];
            }
            iArr[2] = C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
            if (z && iArr[2] >= 0) {
                return iArr[2];
            }
            iArr[3] = b256Encodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[3] >= 0) {
                return iArr[3];
            }
            iArr[4] = X12Encodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[4] >= 0) {
                return iArr[4];
            }
            iArr[5] = EdifactEncodation(bArr, i, i2, bArr2, i3, i4);
            if (z && iArr[5] >= 0) {
                return iArr[5];
            }
            if (iArr[0] < 0 && iArr[1] < 0 && iArr[2] < 0 && iArr[3] < 0 && iArr[4] < 0 && iArr[5] < 0) {
                return -1;
            }
            int i9 = 0;
            int i10 = 99999;
            for (int i11 = 0; i11 < 6; i11++) {
                if (iArr[i11] >= 0 && iArr[i11] < i10) {
                    i10 = iArr[i11];
                    i9 = i11;
                }
            }
            if (i9 == 0) {
                return asciiEncodation(bArr, i, i2, bArr2, i3, i4);
            }
            if (i9 == 1) {
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
            }
            if (i9 == 2) {
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
            }
            if (i9 == 3) {
                return b256Encodation(bArr, i, i2, bArr2, i3, i4);
            }
            if (i9 == 4) {
                return X12Encodation(bArr, i, i2, bArr2, i3, i4);
            }
            return i10;
        }
        switch (i8) {
            case 1:
                byte[] bArr3 = bArr;
                int i12 = i;
                byte[] bArr4 = bArr2;
                int i13 = i3;
                return asciiEncodation(bArr, i, i2, bArr2, i3, i4);
            case 2:
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, true);
            case 3:
                return C40OrTextEncodation(bArr, i, i2, bArr2, i3, i4, false);
            case 4:
                byte[] bArr5 = bArr;
                int i14 = i;
                byte[] bArr6 = bArr2;
                int i15 = i3;
                return b256Encodation(bArr, i, i2, bArr2, i3, i4);
            case 5:
                byte[] bArr7 = bArr;
                int i16 = i;
                byte[] bArr8 = bArr2;
                int i17 = i3;
                return X12Encodation(bArr, i, i2, bArr2, i3, i4);
            case 6:
                byte[] bArr9 = bArr;
                int i18 = i;
                byte[] bArr10 = bArr2;
                int i19 = i3;
                return EdifactEncodation(bArr, i, i2, bArr2, i3, i4);
            case 7:
                if (i6 > i7) {
                    return -1;
                }
                byte[] bArr11 = bArr;
                int i20 = i;
                System.arraycopy(bArr, i, bArr2, i3, i6);
                return i6;
            default:
                return -1;
        }
    }

    private static int getNumber(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + 1;
            byte b = bArr[i] & 255;
            if (b < 48 || b > 57) {
                return -1;
            }
            i4 = ((i4 * 10) + b) - 48;
            i3++;
            i = i5;
        }
        return i4;
    }

    private int processExtensions(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        int number;
        int number2;
        int i4 = 0;
        if ((this.options & 32) == 0) {
            return 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (i4 < i2 && i5 <= 20) {
            int i7 = i4 + 1;
            byte b = bArr[i4 + i] & 255;
            i5++;
            if (b == 46) {
                this.extOut = i7;
                return i6;
            } else if (b != 109) {
                if (b != 112) {
                    if (b == 115) {
                        if (i5 == 1 && i7 + 9 <= i2 && (number = getNumber(bArr, i + i7, 2)) > 0 && number <= 16) {
                            int i8 = i7 + 2;
                            int number3 = getNumber(bArr, i + i8, 2);
                            if (number3 > 1 && number3 <= 16) {
                                int i9 = i8 + 2;
                                int number4 = getNumber(bArr, i + i9, 5);
                                if (number4 >= 0 && number < 64516) {
                                    int i10 = i9 + 5;
                                    int i11 = i6 + 1;
                                    bArr2[i6] = -23;
                                    int i12 = i11 + 1;
                                    bArr2[i11] = (byte) (((number - 1) << 4) | (17 - number3));
                                    int i13 = i12 + 1;
                                    bArr2[i12] = (byte) ((number4 / TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                                    i6 = i13 + 1;
                                    bArr2[i13] = (byte) ((number4 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                                    i4 = i10;
                                }
                            }
                        }
                        return -1;
                    } else if (b == 101) {
                        i4 = i7 + 6;
                        if (i4 > i2 || (number2 = getNumber(bArr, i7 + i, 6)) < 0) {
                            return -1;
                        }
                        int i14 = i6 + 1;
                        bArr2[i6] = -15;
                        if (number2 < 127) {
                            i6 = i14 + 1;
                            bArr2[i14] = (byte) (number2 + 1);
                        } else if (number2 < 16383) {
                            int i15 = i14 + 1;
                            int i16 = number2 - 127;
                            bArr2[i14] = (byte) ((i16 / TIFFConstants.TIFFTAG_SUBFILETYPE) + 128);
                            bArr2[i15] = (byte) ((i16 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                            i6 = i15 + 1;
                        } else {
                            int i17 = i14 + 1;
                            int i18 = number2 - 16383;
                            bArr2[i14] = (byte) ((i18 / 64516) + PsExtractor.AUDIO_STREAM);
                            int i19 = i17 + 1;
                            bArr2[i17] = (byte) (((i18 / TIFFConstants.TIFFTAG_SUBFILETYPE) % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                            i6 = i19 + 1;
                            bArr2[i19] = (byte) ((i18 % TIFFConstants.TIFFTAG_SUBFILETYPE) + 1);
                        }
                    } else if (b == 102) {
                        if (i5 != 1 && (i5 != 2 || (bArr[i] != 115 && bArr[i] != 109))) {
                            return -1;
                        }
                        i3 = i6 + 1;
                        bArr2[i6] = -24;
                        i6 = i3;
                    }
                } else if (i5 != 1) {
                    return -1;
                } else {
                    i3 = i6 + 1;
                    bArr2[i6] = -22;
                    i6 = i3;
                }
                i4 = i7;
            } else if (i5 != 1 || (i4 = i7 + 1) > i2) {
                return -1;
            } else {
                byte b2 = bArr[i7 + i] & 255;
                if (b2 != 53 && b2 != 53) {
                    return -1;
                }
                int i20 = i6 + 1;
                bArr2[i6] = -22;
                i6 = i20 + 1;
                bArr2[i20] = (byte) (b2 == 53 ? 236 : 237);
            }
        }
        return -1;
    }

    public int generate(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("iso-8859-1");
        return generate(bytes, 0, bytes.length);
    }

    public int generate(byte[] bArr, int i, int i2) {
        DmParams dmParams;
        int i3;
        int i4 = i;
        int i5 = i2;
        byte[] bArr2 = new byte[2500];
        this.extOut = 0;
        int processExtensions = processExtensions(bArr, i4, i5, bArr2);
        if (processExtensions < 0) {
            return 5;
        }
        if (this.height == 0 || this.width == 0) {
            DmParams[] dmParamsArr = dmSizes;
            DmParams dmParams2 = dmParamsArr[dmParamsArr.length - 1];
            int i6 = this.extOut;
            int encodation = getEncodation(bArr, i4 + i6, i5 - i6, bArr2, processExtensions, dmParams2.dataSize - processExtensions, this.options, false);
            if (encodation < 0) {
                return 1;
            }
            i3 = encodation + processExtensions;
            int i7 = 0;
            while (true) {
                DmParams[] dmParamsArr2 = dmSizes;
                if (i7 < dmParamsArr2.length && dmParamsArr2[i7].dataSize < i3) {
                    i7++;
                }
            }
            dmParams = dmSizes[i7];
            this.height = dmParams.height;
            this.width = dmParams.width;
        } else {
            int i8 = 0;
            while (true) {
                DmParams[] dmParamsArr3 = dmSizes;
                if (i8 < dmParamsArr3.length && !(this.height == dmParamsArr3[i8].height && this.width == dmSizes[i8].width)) {
                    i8++;
                }
            }
            DmParams[] dmParamsArr4 = dmSizes;
            if (i8 == dmParamsArr4.length) {
                return 3;
            }
            dmParams = dmParamsArr4[i8];
            int i9 = this.extOut;
            int encodation2 = getEncodation(bArr, i4 + i9, i5 - i9, bArr2, processExtensions, dmParams.dataSize - processExtensions, this.options, true);
            if (encodation2 < 0) {
                return 1;
            }
            i3 = encodation2 + processExtensions;
        }
        if ((this.options & 64) != 0) {
            return 0;
        }
        this.image = new byte[((((dmParams.width + (this.f612ws * 2)) + 7) / 8) * (dmParams.height + (this.f612ws * 2)))];
        makePadding(bArr2, i3, dmParams.dataSize - i3);
        this.place = Placement.doPlacement(dmParams.height - ((dmParams.height / dmParams.heightSection) * 2), dmParams.width - ((dmParams.width / dmParams.widthSection) * 2));
        int i10 = dmParams.dataSize + (((dmParams.dataSize + 2) / dmParams.dataBlock) * dmParams.errorBlock);
        ReedSolomon.generateECC(bArr2, dmParams.dataSize, dmParams.dataBlock, dmParams.errorBlock);
        draw(bArr2, i10, dmParams);
        return 0;
    }

    public Image createImage() throws BadElementException {
        byte[] bArr = this.image;
        if (bArr == null) {
            return null;
        }
        int i = this.width;
        int i2 = this.f612ws;
        byte[] compress = CCITTG4Encoder.compress(bArr, i + (i2 * 2), this.height + (i2 * 2));
        int i3 = this.width;
        int i4 = this.f612ws;
        return Image.getInstance(i3 + (i4 * 2), this.height + (i4 * 2), false, 256, 0, compress, (int[]) null);
    }

    private static class DmParams {
        int dataBlock;
        int dataSize;
        int errorBlock;
        int height;
        int heightSection;
        int width;
        int widthSection;

        DmParams(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.height = i;
            this.width = i2;
            this.heightSection = i3;
            this.widthSection = i4;
            this.dataSize = i5;
            this.dataBlock = i6;
            this.errorBlock = i7;
        }
    }

    public byte[] getImage() {
        return this.image;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getWs() {
        return this.f612ws;
    }

    public void setWs(int i) {
        this.f612ws = i;
    }

    public int getOptions() {
        return this.options;
    }

    public void setOptions(int i) {
        this.options = i;
    }

    static class Placement {
        private static final Hashtable cache = new Hashtable();
        private short[] array;
        private int ncol;
        private int nrow;

        private Placement() {
        }

        static short[] doPlacement(int i, int i2) {
            Integer num = new Integer((i * 1000) + i2);
            short[] sArr = (short[]) cache.get(num);
            if (sArr != null) {
                return sArr;
            }
            Placement placement = new Placement();
            placement.nrow = i;
            placement.ncol = i2;
            placement.array = new short[(i * i2)];
            placement.ecc200();
            cache.put(num, placement.array);
            return placement.array;
        }

        private void module(int i, int i2, int i3, int i4) {
            if (i < 0) {
                int i5 = this.nrow;
                i += i5;
                i2 += 4 - ((i5 + 4) % 8);
            }
            if (i2 < 0) {
                int i6 = this.ncol;
                i2 += i6;
                i += 4 - ((i6 + 4) % 8);
            }
            this.array[(i * this.ncol) + i2] = (short) ((i3 * 8) + i4);
        }

        private void utah(int i, int i2, int i3) {
            int i4 = i - 2;
            int i5 = i2 - 2;
            module(i4, i5, i3, 0);
            int i6 = i2 - 1;
            module(i4, i6, i3, 1);
            int i7 = i - 1;
            module(i7, i5, i3, 2);
            module(i7, i6, i3, 3);
            module(i7, i2, i3, 4);
            module(i, i5, i3, 5);
            module(i, i6, i3, 6);
            module(i, i2, i3, 7);
        }

        private void corner1(int i) {
            module(this.nrow - 1, 0, i, 0);
            module(this.nrow - 1, 1, i, 1);
            module(this.nrow - 1, 2, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 1, i, 5);
            module(2, this.ncol - 1, i, 6);
            module(3, this.ncol - 1, i, 7);
        }

        private void corner2(int i) {
            module(this.nrow - 3, 0, i, 0);
            module(this.nrow - 2, 0, i, 1);
            module(this.nrow - 1, 0, i, 2);
            module(0, this.ncol - 4, i, 3);
            module(0, this.ncol - 3, i, 4);
            module(0, this.ncol - 2, i, 5);
            module(0, this.ncol - 1, i, 6);
            module(1, this.ncol - 1, i, 7);
        }

        private void corner3(int i) {
            module(this.nrow - 3, 0, i, 0);
            module(this.nrow - 2, 0, i, 1);
            module(this.nrow - 1, 0, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 1, i, 5);
            module(2, this.ncol - 1, i, 6);
            module(3, this.ncol - 1, i, 7);
        }

        private void corner4(int i) {
            module(this.nrow - 1, 0, i, 0);
            module(this.nrow - 1, this.ncol - 1, i, 1);
            module(0, this.ncol - 3, i, 2);
            module(0, this.ncol - 2, i, 3);
            module(0, this.ncol - 1, i, 4);
            module(1, this.ncol - 3, i, 5);
            module(1, this.ncol - 2, i, 6);
            module(1, this.ncol - 1, i, 7);
        }

        private void ecc200() {
            int i;
            int i2;
            Arrays.fill(this.array, 0);
            int i3 = 4;
            int i4 = 0;
            int i5 = 1;
            while (true) {
                if (i3 == this.nrow && i4 == 0) {
                    corner1(i5);
                    i5++;
                }
                if (i3 == this.nrow - 2 && i4 == 0 && this.ncol % 4 != 0) {
                    corner2(i5);
                    i5++;
                }
                if (i3 == this.nrow - 2 && i4 == 0 && this.ncol % 8 == 4) {
                    corner3(i5);
                    i5++;
                }
                if (i3 == this.nrow + 4 && i4 == 2 && this.ncol % 8 == 0) {
                    corner4(i5);
                    i5++;
                }
                do {
                    if (i3 < this.nrow && i4 >= 0 && this.array[(this.ncol * i3) + i4] == 0) {
                        utah(i3, i4, i5);
                        i5++;
                    }
                    i3 -= 2;
                    i4 += 2;
                    if (i3 < 0 || i4 >= this.ncol) {
                        int i6 = i3 + 1;
                        int i7 = i4 + 3;
                    }
                    utah(i3, i4, i5);
                    i5++;
                    i3 -= 2;
                    i4 += 2;
                    break;
                } while (i4 >= this.ncol);
                int i62 = i3 + 1;
                int i72 = i4 + 3;
                do {
                    if (i62 >= 0) {
                        int i8 = this.ncol;
                        if (i72 < i8 && this.array[(i8 * i62) + i72] == 0) {
                            utah(i62, i72, i5);
                            i5++;
                        }
                    }
                    i62 += 2;
                    i72 -= 2;
                    if (i62 >= this.nrow) {
                        break;
                    }
                } while (i72 >= 0);
                i3 = i62 + 3;
                i4 = i72 + 1;
                i = this.nrow;
                if (i3 >= i && i4 >= (i2 = this.ncol)) {
                    break;
                }
            }
            short[] sArr = this.array;
            if (sArr[(i * i2) - 1] == 0) {
                sArr[((i * i2) - i2) - 2] = 1;
                sArr[(i * i2) - 1] = 1;
            }
        }
    }

    static class ReedSolomon {
        private static final int[] alog = {1, 2, 4, 8, 16, 32, 64, 128, 45, 90, 180, 69, 138, 57, 114, 228, 229, 231, 227, 235, 251, 219, 155, 27, 54, 108, 216, 157, 23, 46, 92, 184, 93, 186, 89, 178, 73, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 9, 18, 36, 72, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 13, 26, 52, 104, 208, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA, 55, 110, WMSTransport.SESSIONSTATE_CONNECT_REJECTED, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 7, 14, 28, 56, 112, 224, 237, MetaDo.META_CREATEPALETTE, 195, 171, 123, 246, 193, 175, 115, 230, 225, 239, 243, 203, 187, 91, 182, 65, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 41, 82, 164, 101, 202, 185, 95, 190, 81, 162, 105, WMSTransport.SESSIONSTATE_CONNECT_REDIRECT, 137, 63, 126, 252, 213, 135, 35, 70, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 53, 106, 212, 133, 39, 78, 156, 21, 42, 84, 168, 125, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 217, 159, 19, 38, 76, 152, 29, 58, 116, 232, 253, 215, 131, 43, 86, TsExtractor.TS_STREAM_TYPE_AC4, 117, 234, 249, 223, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 11, 22, 44, 88, 176, 77, 154, 25, 50, 100, 200, PsExtractor.PRIVATE_STREAM_1, 87, 174, 113, Jpeg.M_APP2, 233, 255, 211, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, 59, 118, 236, 245, 199, 163, 107, 214, 129, 47, 94, 188, 85, 170, 121, 242, 201, 191, 83, 166, 97, 194, 169, 127, TIFFConstants.TIFFTAG_SUBFILETYPE, 209, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 51, 102, HttpStatus.SC_NO_CONTENT, 181, 71, CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA, 49, 98, 196, 165, 103, HttpStatus.SC_PARTIAL_CONTENT, 177, 79, 158, 17, 34, 68, 136, 61, 122, C4317c.f4528X, 197, 167, 99, 198, 161, 111, 222, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 15, 30, 60, 120, PsExtractor.VIDEO_STREAM_MASK, HttpStatus.SC_RESET_CONTENT, 183, 67, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 33, 66, 132, 37, 74, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, 5, 10, 20, 40, 80, 160, 109, 218, 153, 31, 62, 124, 248, 221, 151, 3, 6, 12, 24, 48, 96, PsExtractor.AUDIO_STREAM, 173, 119, Jpeg.M_APPE, 241, HttpStatus.SC_MULTI_STATUS, 179, 75, 150, 1};
        private static final int[] log;
        private static final int[] poly10 = {28, 24, 185, 166, 223, 248, 116, 255, 110, 61};
        private static final int[] poly11 = {175, 138, HttpStatus.SC_RESET_CONTENT, 12, 194, 168, 39, 245, 60, 97, 120};
        private static final int[] poly12 = {41, 153, 158, 91, 61, 42, CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA, 213, 97, 178, 100, 242};
        private static final int[] poly14 = {156, 97, PsExtractor.AUDIO_STREAM, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185};
        private static final int[] poly18 = {83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, TIFFConstants.TIFFTAG_SUBFILETYPE, 225, 48, 90, 188};
        private static final int[] poly20 = {15, 195, C4317c.f4528X, 9, 233, 71, 168, 2, 188, 160, 153, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 253, 79, 108, 82, 27, 174, 186, TsExtractor.TS_STREAM_TYPE_AC4};
        private static final int[] poly24 = {52, 190, 88, HttpStatus.SC_RESET_CONTENT, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, TsExtractor.TS_STREAM_TYPE_AC4, TIFFConstants.TIFFTAG_SUBFILETYPE, 124, 12, 181, 184, 96, 50, 193};
        private static final int[] poly28 = {211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA, 136, 120, 151, 233, 168, 93, 255};
        private static final int[] poly36 = {245, 127, 242, 218, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 162, 181, 102, 120, 84, 179, WMSTransport.SESSIONSTATE_CONNECT_REJECTED, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112};
        private static final int[] poly42 = {77, 193, 137, 31, 19, 38, 22, 153, MetaDo.META_CREATEPALETTE, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, Jpeg.M_APP2, 5, 9, 5};
        private static final int[] poly48 = {245, 132, TsExtractor.TS_STREAM_TYPE_AC4, 223, 96, 32, 117, 22, Jpeg.M_APPE, 133, Jpeg.M_APPE, 231, HttpStatus.SC_RESET_CONTENT, 188, 237, 87, 191, 106, 16, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 118, 23, 37, 90, 170, HttpStatus.SC_RESET_CONTENT, 131, 88, 120, 100, 66, 138, 186, PsExtractor.VIDEO_STREAM_MASK, 82, 44, 176, 87, 187, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 160, 175, 69, 213, 92, 253, 225, 19};
        private static final int[] poly5 = {228, 48, 15, 111, 62};
        private static final int[] poly56 = {175, 9, 223, Jpeg.M_APPE, 12, 17, WMSTransport.SESSIONSTATE_CONNECT_REJECTED, 208, 100, 29, 175, 170, 230, PsExtractor.AUDIO_STREAM, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 218, 234, 117, 203, 29, 232, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, Jpeg.M_APPE, 22, 150, 201, 117, 62, HttpStatus.SC_MULTI_STATUS, 164, 13, 137, 245, 127, 67, MetaDo.META_CREATEPALETTE, 28, 155, 43, 203, 107, 233, 53, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 46};
        private static final int[] poly62 = {242, 93, 169, 50, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, WMSTransport.SESSIONSTATE_CONNECT_REDIRECT, 39, 118, 202, 188, 201, PsExtractor.PRIVATE_STREAM_1, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 108, 196, 37, 185, 112, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 230, 245, 63, 197, 190, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, 185, 221, 175, 64, 114, 71, 161, 44, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 6, 27, 218, 51, 63, 87, 10, 40, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, HttpStatus.SC_NO_CONTENT};
        private static final int[] poly68 = {WMSTransport.SESSIONSTATE_CONNECT_REJECTED, 228, 173, 89, 251, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 159, 56, 89, 33, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, C4317c.f4528X, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, 153, 185, 202, 167, 179, 25, WMSTransport.SESSIONSTATE_CONNECT_REJECTED, 232, 96, WMSTransport.SESSIONSTATE_CONNECT_REDIRECT, 231, 136, 223, 239, 181, 241, 59, 52, TsExtractor.TS_STREAM_TYPE_AC4, 25, 49, 232, 211, PsExtractor.PRIVATE_STREAM_1, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186};
        private static final int[] poly7 = {23, 68, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, PsExtractor.VIDEO_STREAM_MASK, 92, TIFFConstants.TIFFTAG_SUBFILETYPE};

        ReedSolomon() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: int[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        static {
            /*
                r0 = 256(0x100, float:3.59E-43)
                int[] r0 = new int[r0]
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                r0[r1] = r2
                r1 = 2
                r2 = 1
                r0[r1] = r2
                r1 = 3
                r2 = 240(0xf0, float:3.36E-43)
                r0[r1] = r2
                r1 = 4
                r2 = 2
                r0[r1] = r2
                r1 = 5
                r2 = 225(0xe1, float:3.15E-43)
                r0[r1] = r2
                r2 = 6
                r3 = 241(0xf1, float:3.38E-43)
                r0[r2] = r3
                r2 = 7
                r3 = 53
                r0[r2] = r3
                r3 = 8
                r4 = 3
                r0[r3] = r4
                r3 = 9
                r4 = 38
                r0[r3] = r4
                r3 = 10
                r4 = 226(0xe2, float:3.17E-43)
                r0[r3] = r4
                r4 = 11
                r5 = 133(0x85, float:1.86E-43)
                r0[r4] = r5
                r5 = 12
                r6 = 242(0xf2, float:3.39E-43)
                r0[r5] = r6
                r6 = 13
                r7 = 43
                r0[r6] = r7
                r6 = 14
                r7 = 54
                r0[r6] = r7
                r7 = 15
                r8 = 210(0xd2, float:2.94E-43)
                r0[r7] = r8
                r7 = 16
                r8 = 4
                r0[r7] = r8
                r7 = 17
                r8 = 195(0xc3, float:2.73E-43)
                r0[r7] = r8
                r7 = 18
                r8 = 39
                r0[r7] = r8
                r8 = 19
                r9 = 114(0x72, float:1.6E-43)
                r0[r8] = r9
                r8 = 20
                r9 = 227(0xe3, float:3.18E-43)
                r0[r8] = r9
                r9 = 21
                r10 = 106(0x6a, float:1.49E-43)
                r0[r9] = r10
                r9 = 22
                r10 = 134(0x86, float:1.88E-43)
                r0[r9] = r10
                r9 = 28
                r10 = 23
                r0[r10] = r9
                r10 = 24
                r11 = 243(0xf3, float:3.4E-43)
                r0[r10] = r11
                r11 = 25
                r12 = 140(0x8c, float:1.96E-43)
                r0[r11] = r12
                r11 = 26
                r12 = 44
                r0[r11] = r12
                r11 = 27
                r12 = 23
                r0[r11] = r12
                r11 = 55
                r0[r9] = r11
                r11 = 29
                r12 = 118(0x76, float:1.65E-43)
                r0[r11] = r12
                r11 = 30
                r12 = 211(0xd3, float:2.96E-43)
                r0[r11] = r12
                r11 = 31
                r12 = 234(0xea, float:3.28E-43)
                r0[r11] = r12
                r11 = 32
                r0[r11] = r1
                r11 = 33
                r12 = 219(0xdb, float:3.07E-43)
                r0[r11] = r12
                r11 = 34
                r12 = 196(0xc4, float:2.75E-43)
                r0[r11] = r12
                r11 = 35
                r12 = 96
                r0[r11] = r12
                r11 = 36
                r12 = 40
                r0[r11] = r12
                r12 = 37
                r13 = 222(0xde, float:3.11E-43)
                r0[r12] = r13
                r12 = 38
                r13 = 115(0x73, float:1.61E-43)
                r0[r12] = r13
                r12 = 39
                r13 = 103(0x67, float:1.44E-43)
                r0[r12] = r13
                r12 = 40
                r13 = 228(0xe4, float:3.2E-43)
                r0[r12] = r13
                r12 = 41
                r13 = 78
                r0[r12] = r13
                r12 = 42
                r13 = 107(0x6b, float:1.5E-43)
                r0[r12] = r13
                r13 = 43
                r14 = 125(0x7d, float:1.75E-43)
                r0[r13] = r14
                r13 = 44
                r14 = 135(0x87, float:1.89E-43)
                r0[r13] = r14
                r13 = 45
                r14 = 8
                r0[r13] = r14
                r13 = 46
                r14 = 29
                r0[r13] = r14
                r13 = 47
                r14 = 162(0xa2, float:2.27E-43)
                r0[r13] = r14
                r13 = 48
                r14 = 244(0xf4, float:3.42E-43)
                r0[r13] = r14
                r14 = 49
                r15 = 186(0xba, float:2.6E-43)
                r0[r14] = r15
                r14 = 50
                r15 = 141(0x8d, float:1.98E-43)
                r0[r14] = r15
                r14 = 51
                r15 = 180(0xb4, float:2.52E-43)
                r0[r14] = r15
                r14 = 52
                r15 = 45
                r0[r14] = r15
                r14 = 53
                r15 = 99
                r0[r14] = r15
                r14 = 54
                r0[r14] = r10
                r14 = 55
                r15 = 49
                r0[r14] = r15
                r14 = 56
                r0[r14] = r14
                r15 = 57
                r16 = 13
                r0[r15] = r16
                r15 = 58
                r16 = 119(0x77, float:1.67E-43)
                r0[r15] = r16
                r15 = 59
                r16 = 153(0x99, float:2.14E-43)
                r0[r15] = r16
                r15 = 60
                r16 = 212(0xd4, float:2.97E-43)
                r0[r15] = r16
                r15 = 61
                r16 = 199(0xc7, float:2.79E-43)
                r0[r15] = r16
                r15 = 62
                r16 = 235(0xeb, float:3.3E-43)
                r0[r15] = r16
                r16 = 63
                r17 = 91
                r0[r16] = r17
                r16 = 64
                r17 = 6
                r0[r16] = r17
                r16 = 65
                r17 = 76
                r0[r16] = r17
                r16 = 66
                r17 = 220(0xdc, float:3.08E-43)
                r0[r16] = r17
                r16 = 67
                r17 = 217(0xd9, float:3.04E-43)
                r0[r16] = r17
                r16 = 68
                r17 = 197(0xc5, float:2.76E-43)
                r0[r16] = r17
                r16 = 69
                r0[r16] = r4
                r16 = 70
                r17 = 97
                r0[r16] = r17
                r16 = 71
                r17 = 184(0xb8, float:2.58E-43)
                r0[r16] = r17
                r16 = 72
                r17 = 41
                r0[r16] = r17
                r16 = 73
                r0[r16] = r11
                r16 = 74
                r17 = 223(0xdf, float:3.12E-43)
                r0[r16] = r17
                r16 = 75
                r17 = 253(0xfd, float:3.55E-43)
                r0[r16] = r17
                r16 = 76
                r17 = 116(0x74, float:1.63E-43)
                r0[r16] = r17
                r16 = 77
                r17 = 138(0x8a, float:1.93E-43)
                r0[r16] = r17
                r16 = 78
                r17 = 104(0x68, float:1.46E-43)
                r0[r16] = r17
                r16 = 79
                r17 = 193(0xc1, float:2.7E-43)
                r0[r16] = r17
                r16 = 80
                r17 = 229(0xe5, float:3.21E-43)
                r0[r16] = r17
                r16 = 81
                r17 = 86
                r0[r16] = r17
                r16 = 82
                r17 = 79
                r0[r16] = r17
                r16 = 83
                r17 = 171(0xab, float:2.4E-43)
                r0[r16] = r17
                r16 = 84
                r17 = 108(0x6c, float:1.51E-43)
                r0[r16] = r17
                r16 = 85
                r17 = 165(0xa5, float:2.31E-43)
                r0[r16] = r17
                r16 = 86
                r17 = 126(0x7e, float:1.77E-43)
                r0[r16] = r17
                r16 = 87
                r17 = 145(0x91, float:2.03E-43)
                r0[r16] = r17
                r16 = 88
                r17 = 136(0x88, float:1.9E-43)
                r0[r16] = r17
                r16 = 89
                r17 = 34
                r0[r16] = r17
                r16 = 90
                r17 = 9
                r0[r16] = r17
                r16 = 91
                r17 = 74
                r0[r16] = r17
                r16 = 92
                r17 = 30
                r0[r16] = r17
                r16 = 93
                r17 = 32
                r0[r16] = r17
                r16 = 94
                r17 = 163(0xa3, float:2.28E-43)
                r0[r16] = r17
                r16 = 95
                r17 = 84
                r0[r16] = r17
                r16 = 96
                r17 = 245(0xf5, float:3.43E-43)
                r0[r16] = r17
                r16 = 97
                r17 = 173(0xad, float:2.42E-43)
                r0[r16] = r17
                r16 = 98
                r17 = 187(0xbb, float:2.62E-43)
                r0[r16] = r17
                r16 = 99
                r17 = 204(0xcc, float:2.86E-43)
                r0[r16] = r17
                r16 = 100
                r17 = 142(0x8e, float:1.99E-43)
                r0[r16] = r17
                r16 = 101(0x65, float:1.42E-43)
                r17 = 81
                r0[r16] = r17
                r16 = 102(0x66, float:1.43E-43)
                r17 = 181(0xb5, float:2.54E-43)
                r0[r16] = r17
                r16 = 103(0x67, float:1.44E-43)
                r17 = 190(0xbe, float:2.66E-43)
                r0[r16] = r17
                r16 = 104(0x68, float:1.46E-43)
                r17 = 46
                r0[r16] = r17
                r16 = 105(0x69, float:1.47E-43)
                r17 = 88
                r0[r16] = r17
                r16 = 106(0x6a, float:1.49E-43)
                r17 = 100
                r0[r16] = r17
                r16 = 107(0x6b, float:1.5E-43)
                r17 = 159(0x9f, float:2.23E-43)
                r0[r16] = r17
                r16 = 108(0x6c, float:1.51E-43)
                r17 = 25
                r0[r16] = r17
                r16 = 109(0x6d, float:1.53E-43)
                r17 = 231(0xe7, float:3.24E-43)
                r0[r16] = r17
                r16 = 110(0x6e, float:1.54E-43)
                r17 = 50
                r0[r16] = r17
                r16 = 111(0x6f, float:1.56E-43)
                r17 = 207(0xcf, float:2.9E-43)
                r0[r16] = r17
                r16 = 112(0x70, float:1.57E-43)
                r17 = 57
                r0[r16] = r17
                r16 = 113(0x71, float:1.58E-43)
                r17 = 147(0x93, float:2.06E-43)
                r0[r16] = r17
                r16 = 114(0x72, float:1.6E-43)
                r0[r16] = r6
                r16 = 115(0x73, float:1.61E-43)
                r17 = 67
                r0[r16] = r17
                r16 = 116(0x74, float:1.63E-43)
                r17 = 120(0x78, float:1.68E-43)
                r0[r16] = r17
                r16 = 117(0x75, float:1.64E-43)
                r17 = 128(0x80, float:1.794E-43)
                r0[r16] = r17
                r16 = 118(0x76, float:1.65E-43)
                r17 = 154(0x9a, float:2.16E-43)
                r0[r16] = r17
                r16 = 119(0x77, float:1.67E-43)
                r17 = 248(0xf8, float:3.48E-43)
                r0[r16] = r17
                r16 = 120(0x78, float:1.68E-43)
                r17 = 213(0xd5, float:2.98E-43)
                r0[r16] = r17
                r16 = 121(0x79, float:1.7E-43)
                r17 = 167(0xa7, float:2.34E-43)
                r0[r16] = r17
                r16 = 122(0x7a, float:1.71E-43)
                r17 = 200(0xc8, float:2.8E-43)
                r0[r16] = r17
                r16 = 123(0x7b, float:1.72E-43)
                r17 = 63
                r0[r16] = r17
                r16 = 124(0x7c, float:1.74E-43)
                r17 = 236(0xec, float:3.31E-43)
                r0[r16] = r17
                r16 = 125(0x7d, float:1.75E-43)
                r17 = 110(0x6e, float:1.54E-43)
                r0[r16] = r17
                r16 = 126(0x7e, float:1.77E-43)
                r17 = 92
                r0[r16] = r17
                r16 = 127(0x7f, float:1.78E-43)
                r17 = 176(0xb0, float:2.47E-43)
                r0[r16] = r17
                r16 = 128(0x80, float:1.794E-43)
                r0[r16] = r2
                r16 = 129(0x81, float:1.81E-43)
                r17 = 161(0xa1, float:2.26E-43)
                r0[r16] = r17
                r16 = 130(0x82, float:1.82E-43)
                r17 = 77
                r0[r16] = r17
                r16 = 131(0x83, float:1.84E-43)
                r17 = 124(0x7c, float:1.74E-43)
                r0[r16] = r17
                r16 = 132(0x84, float:1.85E-43)
                r17 = 221(0xdd, float:3.1E-43)
                r0[r16] = r17
                r16 = 133(0x85, float:1.86E-43)
                r17 = 102(0x66, float:1.43E-43)
                r0[r16] = r17
                r16 = 134(0x86, float:1.88E-43)
                r17 = 218(0xda, float:3.05E-43)
                r0[r16] = r17
                r16 = 135(0x87, float:1.89E-43)
                r17 = 95
                r0[r16] = r17
                r16 = 136(0x88, float:1.9E-43)
                r17 = 198(0xc6, float:2.77E-43)
                r0[r16] = r17
                r16 = 137(0x89, float:1.92E-43)
                r17 = 90
                r0[r16] = r17
                r16 = 138(0x8a, float:1.93E-43)
                r0[r16] = r5
                r16 = 139(0x8b, float:1.95E-43)
                r17 = 152(0x98, float:2.13E-43)
                r0[r16] = r17
                r16 = 140(0x8c, float:1.96E-43)
                r17 = 98
                r0[r16] = r17
                r16 = 141(0x8d, float:1.98E-43)
                r0[r16] = r13
                r16 = 142(0x8e, float:1.99E-43)
                r17 = 185(0xb9, float:2.59E-43)
                r0[r16] = r17
                r16 = 143(0x8f, float:2.0E-43)
                r17 = 179(0xb3, float:2.51E-43)
                r0[r16] = r17
                r16 = 144(0x90, float:2.02E-43)
                r0[r16] = r12
                r16 = 145(0x91, float:2.03E-43)
                r17 = 209(0xd1, float:2.93E-43)
                r0[r16] = r17
                r16 = 146(0x92, float:2.05E-43)
                r17 = 37
                r0[r16] = r17
                r16 = 147(0x93, float:2.06E-43)
                r17 = 132(0x84, float:1.85E-43)
                r0[r16] = r17
                r16 = 148(0x94, float:2.07E-43)
                r17 = 224(0xe0, float:3.14E-43)
                r0[r16] = r17
                r16 = 149(0x95, float:2.09E-43)
                r17 = 52
                r0[r16] = r17
                r16 = 150(0x96, float:2.1E-43)
                r17 = 254(0xfe, float:3.56E-43)
                r0[r16] = r17
                r16 = 151(0x97, float:2.12E-43)
                r17 = 239(0xef, float:3.35E-43)
                r0[r16] = r17
                r16 = 152(0x98, float:2.13E-43)
                r17 = 117(0x75, float:1.64E-43)
                r0[r16] = r17
                r16 = 153(0x99, float:2.14E-43)
                r17 = 233(0xe9, float:3.27E-43)
                r0[r16] = r17
                r16 = 154(0x9a, float:2.16E-43)
                r17 = 139(0x8b, float:1.95E-43)
                r0[r16] = r17
                r16 = 155(0x9b, float:2.17E-43)
                r17 = 22
                r0[r16] = r17
                r16 = 156(0x9c, float:2.19E-43)
                r17 = 105(0x69, float:1.47E-43)
                r0[r16] = r17
                r16 = 157(0x9d, float:2.2E-43)
                r17 = 27
                r0[r16] = r17
                r16 = 158(0x9e, float:2.21E-43)
                r17 = 194(0xc2, float:2.72E-43)
                r0[r16] = r17
                r16 = 159(0x9f, float:2.23E-43)
                r17 = 113(0x71, float:1.58E-43)
                r0[r16] = r17
                r16 = 160(0xa0, float:2.24E-43)
                r17 = 230(0xe6, float:3.22E-43)
                r0[r16] = r17
                r16 = 161(0xa1, float:2.26E-43)
                r17 = 206(0xce, float:2.89E-43)
                r0[r16] = r17
                r16 = 162(0xa2, float:2.27E-43)
                r17 = 87
                r0[r16] = r17
                r16 = 163(0xa3, float:2.28E-43)
                r17 = 158(0x9e, float:2.21E-43)
                r0[r16] = r17
                r16 = 164(0xa4, float:2.3E-43)
                r17 = 80
                r0[r16] = r17
                r16 = 165(0xa5, float:2.31E-43)
                r17 = 189(0xbd, float:2.65E-43)
                r0[r16] = r17
                r16 = 166(0xa6, float:2.33E-43)
                r17 = 172(0xac, float:2.41E-43)
                r0[r16] = r17
                r16 = 167(0xa7, float:2.34E-43)
                r17 = 203(0xcb, float:2.84E-43)
                r0[r16] = r17
                r16 = 168(0xa8, float:2.35E-43)
                r17 = 109(0x6d, float:1.53E-43)
                r0[r16] = r17
                r16 = 169(0xa9, float:2.37E-43)
                r17 = 175(0xaf, float:2.45E-43)
                r0[r16] = r17
                r16 = 170(0xaa, float:2.38E-43)
                r17 = 166(0xa6, float:2.33E-43)
                r0[r16] = r17
                r16 = 171(0xab, float:2.4E-43)
                r0[r16] = r15
                r16 = 172(0xac, float:2.41E-43)
                r17 = 127(0x7f, float:1.78E-43)
                r0[r16] = r17
                r16 = 173(0xad, float:2.42E-43)
                r17 = 247(0xf7, float:3.46E-43)
                r0[r16] = r17
                r16 = 174(0xae, float:2.44E-43)
                r17 = 146(0x92, float:2.05E-43)
                r0[r16] = r17
                r16 = 175(0xaf, float:2.45E-43)
                r17 = 66
                r0[r16] = r17
                r16 = 176(0xb0, float:2.47E-43)
                r17 = 137(0x89, float:1.92E-43)
                r0[r16] = r17
                r16 = 177(0xb1, float:2.48E-43)
                r17 = 192(0xc0, float:2.69E-43)
                r0[r16] = r17
                r16 = 178(0xb2, float:2.5E-43)
                r17 = 35
                r0[r16] = r17
                r16 = 179(0xb3, float:2.51E-43)
                r17 = 252(0xfc, float:3.53E-43)
                r0[r16] = r17
                r16 = 180(0xb4, float:2.52E-43)
                r0[r16] = r3
                r16 = 181(0xb5, float:2.54E-43)
                r17 = 183(0xb7, float:2.56E-43)
                r0[r16] = r17
                r16 = 182(0xb6, float:2.55E-43)
                r17 = 75
                r0[r16] = r17
                r16 = 183(0xb7, float:2.56E-43)
                r17 = 216(0xd8, float:3.03E-43)
                r0[r16] = r17
                r16 = 184(0xb8, float:2.58E-43)
                r17 = 31
                r0[r16] = r17
                r16 = 185(0xb9, float:2.59E-43)
                r17 = 83
                r0[r16] = r17
                r16 = 186(0xba, float:2.6E-43)
                r17 = 33
                r0[r16] = r17
                r16 = 187(0xbb, float:2.62E-43)
                r17 = 73
                r0[r16] = r17
                r16 = 188(0xbc, float:2.63E-43)
                r17 = 164(0xa4, float:2.3E-43)
                r0[r16] = r17
                r16 = 189(0xbd, float:2.65E-43)
                r17 = 144(0x90, float:2.02E-43)
                r0[r16] = r17
                r16 = 190(0xbe, float:2.66E-43)
                r17 = 85
                r0[r16] = r17
                r16 = 191(0xbf, float:2.68E-43)
                r17 = 170(0xaa, float:2.38E-43)
                r0[r16] = r17
                r16 = 192(0xc0, float:2.69E-43)
                r17 = 246(0xf6, float:3.45E-43)
                r0[r16] = r17
                r16 = 193(0xc1, float:2.7E-43)
                r17 = 65
                r0[r16] = r17
                r16 = 194(0xc2, float:2.72E-43)
                r17 = 174(0xae, float:2.44E-43)
                r0[r16] = r17
                r16 = 195(0xc3, float:2.73E-43)
                r17 = 61
                r0[r16] = r17
                r16 = 196(0xc4, float:2.75E-43)
                r17 = 188(0xbc, float:2.63E-43)
                r0[r16] = r17
                r16 = 197(0xc5, float:2.76E-43)
                r17 = 202(0xca, float:2.83E-43)
                r0[r16] = r17
                r16 = 198(0xc6, float:2.77E-43)
                r17 = 205(0xcd, float:2.87E-43)
                r0[r16] = r17
                r16 = 199(0xc7, float:2.79E-43)
                r17 = 157(0x9d, float:2.2E-43)
                r0[r16] = r17
                r16 = 200(0xc8, float:2.8E-43)
                r17 = 143(0x8f, float:2.0E-43)
                r0[r16] = r17
                r16 = 201(0xc9, float:2.82E-43)
                r17 = 169(0xa9, float:2.37E-43)
                r0[r16] = r17
                r16 = 202(0xca, float:2.83E-43)
                r17 = 82
                r0[r16] = r17
                r16 = 203(0xcb, float:2.84E-43)
                r17 = 72
                r0[r16] = r17
                r16 = 204(0xcc, float:2.86E-43)
                r17 = 182(0xb6, float:2.55E-43)
                r0[r16] = r17
                r16 = 205(0xcd, float:2.87E-43)
                r17 = 215(0xd7, float:3.01E-43)
                r0[r16] = r17
                r16 = 206(0xce, float:2.89E-43)
                r17 = 191(0xbf, float:2.68E-43)
                r0[r16] = r17
                r16 = 207(0xcf, float:2.9E-43)
                r17 = 251(0xfb, float:3.52E-43)
                r0[r16] = r17
                r16 = 208(0xd0, float:2.91E-43)
                r17 = 47
                r0[r16] = r17
                r16 = 209(0xd1, float:2.93E-43)
                r17 = 178(0xb2, float:2.5E-43)
                r0[r16] = r17
                r16 = 210(0xd2, float:2.94E-43)
                r17 = 89
                r0[r16] = r17
                r16 = 211(0xd3, float:2.96E-43)
                r17 = 151(0x97, float:2.12E-43)
                r0[r16] = r17
                r16 = 212(0xd4, float:2.97E-43)
                r17 = 101(0x65, float:1.42E-43)
                r0[r16] = r17
                r16 = 213(0xd5, float:2.98E-43)
                r17 = 94
                r0[r16] = r17
                r16 = 214(0xd6, float:3.0E-43)
                r17 = 160(0xa0, float:2.24E-43)
                r0[r16] = r17
                r16 = 215(0xd7, float:3.01E-43)
                r17 = 123(0x7b, float:1.72E-43)
                r0[r16] = r17
                r16 = 216(0xd8, float:3.03E-43)
                r17 = 26
                r0[r16] = r17
                r16 = 217(0xd9, float:3.04E-43)
                r17 = 112(0x70, float:1.57E-43)
                r0[r16] = r17
                r16 = 218(0xda, float:3.05E-43)
                r17 = 232(0xe8, float:3.25E-43)
                r0[r16] = r17
                r16 = 219(0xdb, float:3.07E-43)
                r17 = 21
                r0[r16] = r17
                r16 = 220(0xdc, float:3.08E-43)
                r17 = 51
                r0[r16] = r17
                r16 = 221(0xdd, float:3.1E-43)
                r17 = 238(0xee, float:3.34E-43)
                r0[r16] = r17
                r16 = 222(0xde, float:3.11E-43)
                r17 = 208(0xd0, float:2.91E-43)
                r0[r16] = r17
                r16 = 223(0xdf, float:3.12E-43)
                r17 = 131(0x83, float:1.84E-43)
                r0[r16] = r17
                r16 = 224(0xe0, float:3.14E-43)
                r17 = 58
                r0[r16] = r17
                r16 = 225(0xe1, float:3.15E-43)
                r17 = 69
                r0[r16] = r17
                r16 = 226(0xe2, float:3.17E-43)
                r17 = 148(0x94, float:2.07E-43)
                r0[r16] = r17
                r16 = 227(0xe3, float:3.18E-43)
                r0[r16] = r7
                r16 = 228(0xe4, float:3.2E-43)
                r17 = 15
                r0[r16] = r17
                r16 = 229(0xe5, float:3.21E-43)
                r17 = 16
                r0[r16] = r17
                r16 = 230(0xe6, float:3.22E-43)
                r17 = 68
                r0[r16] = r17
                r16 = 231(0xe7, float:3.24E-43)
                r17 = 17
                r0[r16] = r17
                r16 = 232(0xe8, float:3.25E-43)
                r17 = 121(0x79, float:1.7E-43)
                r0[r16] = r17
                r16 = 233(0xe9, float:3.27E-43)
                r17 = 149(0x95, float:2.09E-43)
                r0[r16] = r17
                r16 = 234(0xea, float:3.28E-43)
                r17 = 129(0x81, float:1.81E-43)
                r0[r16] = r17
                r16 = 235(0xeb, float:3.3E-43)
                r17 = 19
                r0[r16] = r17
                r16 = 236(0xec, float:3.31E-43)
                r17 = 155(0x9b, float:2.17E-43)
                r0[r16] = r17
                r16 = 237(0xed, float:3.32E-43)
                r17 = 59
                r0[r16] = r17
                r16 = 238(0xee, float:3.34E-43)
                r17 = 249(0xf9, float:3.49E-43)
                r0[r16] = r17
                r16 = 239(0xef, float:3.35E-43)
                r17 = 70
                r0[r16] = r17
                r16 = 240(0xf0, float:3.36E-43)
                r17 = 214(0xd6, float:3.0E-43)
                r0[r16] = r17
                r16 = 241(0xf1, float:3.38E-43)
                r17 = 250(0xfa, float:3.5E-43)
                r0[r16] = r17
                r16 = 242(0xf2, float:3.39E-43)
                r17 = 168(0xa8, float:2.35E-43)
                r0[r16] = r17
                r16 = 243(0xf3, float:3.4E-43)
                r17 = 71
                r0[r16] = r17
                r16 = 244(0xf4, float:3.42E-43)
                r17 = 201(0xc9, float:2.82E-43)
                r0[r16] = r17
                r16 = 245(0xf5, float:3.43E-43)
                r17 = 156(0x9c, float:2.19E-43)
                r0[r16] = r17
                r16 = 246(0xf6, float:3.45E-43)
                r17 = 64
                r0[r16] = r17
                r16 = 247(0xf7, float:3.46E-43)
                r17 = 60
                r0[r16] = r17
                r16 = 248(0xf8, float:3.48E-43)
                r17 = 237(0xed, float:3.32E-43)
                r0[r16] = r17
                r16 = 249(0xf9, float:3.49E-43)
                r17 = 130(0x82, float:1.82E-43)
                r0[r16] = r17
                r16 = 250(0xfa, float:3.5E-43)
                r17 = 111(0x6f, float:1.56E-43)
                r0[r16] = r17
                r16 = 251(0xfb, float:3.52E-43)
                r0[r16] = r8
                r16 = 252(0xfc, float:3.53E-43)
                r17 = 93
                r0[r16] = r17
                r16 = 253(0xfd, float:3.55E-43)
                r17 = 122(0x7a, float:1.71E-43)
                r0[r16] = r17
                r16 = 254(0xfe, float:3.56E-43)
                r17 = 177(0xb1, float:2.48E-43)
                r0[r16] = r17
                r16 = 255(0xff, float:3.57E-43)
                r17 = 150(0x96, float:2.1E-43)
                r0[r16] = r17
                log = r0
                r0 = 256(0x100, float:3.59E-43)
                int[] r0 = new int[r0]
                r0 = {1, 2, 4, 8, 16, 32, 64, 128, 45, 90, 180, 69, 138, 57, 114, 228, 229, 231, 227, 235, 251, 219, 155, 27, 54, 108, 216, 157, 23, 46, 92, 184, 93, 186, 89, 178, 73, 146, 9, 18, 36, 72, 144, 13, 26, 52, 104, 208, 141, 55, 110, 220, 149, 7, 14, 28, 56, 112, 224, 237, 247, 195, 171, 123, 246, 193, 175, 115, 230, 225, 239, 243, 203, 187, 91, 182, 65, 130, 41, 82, 164, 101, 202, 185, 95, 190, 81, 162, 105, 210, 137, 63, 126, 252, 213, 135, 35, 70, 140, 53, 106, 212, 133, 39, 78, 156, 21, 42, 84, 168, 125, 250, 217, 159, 19, 38, 76, 152, 29, 58, 116, 232, 253, 215, 131, 43, 86, 172, 117, 234, 249, 223, 147, 11, 22, 44, 88, 176, 77, 154, 25, 50, 100, 200, 189, 87, 174, 113, 226, 233, 255, 211, 139, 59, 118, 236, 245, 199, 163, 107, 214, 129, 47, 94, 188, 85, 170, 121, 242, 201, 191, 83, 166, 97, 194, 169, 127, 254, 209, 143, 51, 102, 204, 181, 71, 142, 49, 98, 196, 165, 103, 206, 177, 79, 158, 17, 34, 68, 136, 61, 122, 244, 197, 167, 99, 198, 161, 111, 222, 145, 15, 30, 60, 120, 240, 205, 183, 67, 134, 33, 66, 132, 37, 74, 148, 5, 10, 20, 40, 80, 160, 109, 218, 153, 31, 62, 124, 248, 221, 151, 3, 6, 12, 24, 48, 96, 192, 173, 119, 238, 241, 207, 179, 75, 150, 1} // fill-array
                alog = r0
                int[] r0 = new int[r1]
                r0 = {228, 48, 15, 111, 62} // fill-array
                poly5 = r0
                int[] r0 = new int[r2]
                r0 = {23, 68, 144, 134, 240, 92, 254} // fill-array
                poly7 = r0
                int[] r0 = new int[r3]
                r0 = {28, 24, 185, 166, 223, 248, 116, 255, 110, 61} // fill-array
                poly10 = r0
                int[] r0 = new int[r4]
                r0 = {175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120} // fill-array
                poly11 = r0
                int[] r0 = new int[r5]
                r0 = {41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242} // fill-array
                poly12 = r0
                int[] r0 = new int[r6]
                r0 = {156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185} // fill-array
                poly14 = r0
                int[] r0 = new int[r7]
                r0 = {83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188} // fill-array
                poly18 = r0
                int[] r0 = new int[r8]
                r0 = {15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172} // fill-array
                poly20 = r0
                int[] r0 = new int[r10]
                r0 = {52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193} // fill-array
                poly24 = r0
                int[] r0 = new int[r9]
                r0 = {211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255} // fill-array
                poly28 = r0
                int[] r0 = new int[r11]
                r0 = {245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112} // fill-array
                poly36 = r0
                int[] r0 = new int[r12]
                r0 = {77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5} // fill-array
                poly42 = r0
                int[] r0 = new int[r13]
                r0 = {245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19} // fill-array
                poly48 = r0
                int[] r0 = new int[r14]
                r0 = {175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46} // fill-array
                poly56 = r0
                int[] r0 = new int[r15]
                r0 = {242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204} // fill-array
                poly62 = r0
                r0 = 68
                int[] r0 = new int[r0]
                r0 = {220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186} // fill-array
                poly68 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.BarcodeDatamatrix.ReedSolomon.<clinit>():void");
        }

        private static int[] getPoly(int i) {
            switch (i) {
                case 5:
                    return poly5;
                case 7:
                    return poly7;
                case 10:
                    return poly10;
                case 11:
                    return poly11;
                case 12:
                    return poly12;
                case 14:
                    return poly14;
                case 18:
                    return poly18;
                case 20:
                    return poly20;
                case 24:
                    return poly24;
                case 28:
                    return poly28;
                case 36:
                    return poly36;
                case 42:
                    return poly42;
                case 48:
                    return poly48;
                case 56:
                    return poly56;
                case 62:
                    return poly62;
                case 68:
                    return poly68;
                default:
                    return null;
            }
        }

        private static void reedSolomonBlock(byte[] bArr, int i, byte[] bArr2, int i2, int[] iArr) {
            byte b;
            for (int i3 = 0; i3 <= i2; i3++) {
                bArr2[i3] = 0;
            }
            for (int i4 = 0; i4 < i; i4++) {
                byte b2 = (bArr2[0] ^ bArr[i4]) & 255;
                int i5 = 0;
                while (i5 < i2) {
                    int i6 = i5 + 1;
                    byte b3 = bArr2[i6];
                    if (b2 == 0) {
                        b = 0;
                    } else {
                        int[] iArr2 = alog;
                        int[] iArr3 = log;
                        b = (byte) iArr2[(iArr3[b2] + iArr3[iArr[(i2 - i5) - 1]]) % 255];
                    }
                    bArr2[i5] = (byte) (b3 ^ b);
                    i5 = i6;
                }
            }
        }

        static void generateECC(byte[] bArr, int i, int i2, int i3) {
            int i4 = (i + 2) / i2;
            byte[] bArr2 = new byte[256];
            byte[] bArr3 = new byte[256];
            int[] poly = getPoly(i3);
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5;
                int i7 = 0;
                while (i6 < i) {
                    bArr2[i7] = bArr[i6];
                    i6 += i4;
                    i7++;
                }
                reedSolomonBlock(bArr2, i7, bArr3, i3, poly);
                int i8 = i5;
                int i9 = 0;
                while (i8 < i3 * i4) {
                    bArr[i + i8] = bArr3[i9];
                    i8 += i4;
                    i9++;
                }
            }
        }
    }
}
