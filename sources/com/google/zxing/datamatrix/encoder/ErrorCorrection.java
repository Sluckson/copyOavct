package com.google.zxing.datamatrix.encoder;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.google.android.exoplayer2.extractor.p008ts.TsExtractor;
import com.lowagie.text.Jpeg;
import com.lowagie.text.pdf.codec.TIFFConstants;
import com.lowagie.text.pdf.codec.wmf.MetaDo;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c;
import com.wowza.gocoder.sdk.support.wse.jni.wmstransport.WMSTransport;
import p052cz.msebera.android.httpclient.HttpStatus;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

public final class ErrorCorrection {
    private static final int[] ALOG = new int[255];
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, PsExtractor.VIDEO_STREAM_MASK, 92, TIFFConstants.TIFFTAG_SUBFILETYPE}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, HttpStatus.SC_RESET_CONTENT, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA, 213, 97, 178, 100, 242}, new int[]{156, 97, PsExtractor.AUDIO_STREAM, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, TIFFConstants.TIFFTAG_SUBFILETYPE, 225, 48, 90, 188}, new int[]{15, 195, C4317c.f4528X, 9, 233, 71, 168, 2, 188, 160, 153, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 253, 79, 108, 82, 27, 174, 186, TsExtractor.TS_STREAM_TYPE_AC4}, new int[]{52, 190, 88, HttpStatus.SC_RESET_CONTENT, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, TsExtractor.TS_STREAM_TYPE_AC4, TIFFConstants.TIFFTAG_SUBFILETYPE, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 162, 181, 102, 120, 84, 179, WMSTransport.SESSIONSTATE_CONNECT_REJECTED, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, MetaDo.META_CREATEPALETTE, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, Jpeg.M_APP2, 5, 9, 5}, new int[]{245, 132, TsExtractor.TS_STREAM_TYPE_AC4, 223, 96, 32, 117, 22, Jpeg.M_APPE, 133, Jpeg.M_APPE, 231, HttpStatus.SC_RESET_CONTENT, 188, 237, 87, 191, 106, 16, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 118, 23, 37, 90, 170, HttpStatus.SC_RESET_CONTENT, 131, 88, 120, 100, 66, 138, 186, PsExtractor.VIDEO_STREAM_MASK, 82, 44, 176, 87, 187, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, Jpeg.M_APPE, 12, 17, WMSTransport.SESSIONSTATE_CONNECT_REJECTED, 208, 100, 29, 175, 170, 230, PsExtractor.AUDIO_STREAM, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 218, 234, 117, 203, 29, 232, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, Jpeg.M_APPE, 22, 150, 201, 117, 62, HttpStatus.SC_MULTI_STATUS, 164, 13, 137, 245, 127, 67, MetaDo.META_CREATEPALETTE, 28, 155, 43, 203, 107, 233, 53, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 46}, new int[]{242, 93, 169, 50, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, WMSTransport.SESSIONSTATE_CONNECT_REDIRECT, 39, 118, 202, 188, 201, PsExtractor.PRIVATE_STREAM_1, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 108, 196, 37, 185, 112, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 230, 245, 63, 197, 190, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, 185, 221, 175, 64, 114, 71, 161, 44, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 6, 27, 218, 51, 63, 87, 10, 40, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, HttpStatus.SC_NO_CONTENT}, new int[]{WMSTransport.SESSIONSTATE_CONNECT_REJECTED, 228, 173, 89, 251, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 159, 56, 89, 33, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, C4317c.f4528X, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, 153, 185, 202, 167, 179, 25, WMSTransport.SESSIONSTATE_CONNECT_REJECTED, 232, 96, WMSTransport.SESSIONSTATE_CONNECT_REDIRECT, 231, 136, 223, 239, 181, 241, 59, 52, TsExtractor.TS_STREAM_TYPE_AC4, 25, 49, 232, 211, PsExtractor.PRIVATE_STREAM_1, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[] LOG = new int[256];
    private static final int MODULO_VALUE = 301;

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() == symbolInfo.getDataCapacity()) {
            StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
            sb.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i = 0;
                while (i < interleavedBlockCount) {
                    int i2 = i + 1;
                    iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                    iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                    iArr3[i] = 0;
                    if (i > 0) {
                        iArr3[i] = iArr3[i - 1] + iArr[i];
                    }
                    i = i2;
                }
                for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i3]);
                    for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                        sb2.append(str.charAt(i4));
                    }
                    String createECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                    int i5 = i3;
                    int i6 = 0;
                    while (i5 < iArr2[i3] * interleavedBlockCount) {
                        sb.setCharAt(symbolInfo.getDataCapacity() + i5, createECCBlock.charAt(i6));
                        i5 += interleavedBlockCount;
                        i6++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            } else if (iArr[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            int[] iArr2 = FACTORS[i4];
            char[] cArr = new char[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                cArr[i5] = 0;
            }
            for (int i6 = i; i6 < i + i2; i6++) {
                int i7 = i3 - 1;
                char charAt = cArr[i7] ^ charSequence.charAt(i6);
                while (i7 > 0) {
                    if (charAt == 0 || iArr2[i7] == 0) {
                        cArr[i7] = cArr[i7 - 1];
                    } else {
                        char c = cArr[i7 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i7] = (char) (c ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i7]]) % 255]);
                    }
                    i7--;
                }
                if (charAt == 0 || iArr2[0] == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % 255];
                }
            }
            char[] cArr2 = new char[i3];
            for (int i8 = 0; i8 < i3; i8++) {
                cArr2[i8] = cArr[(i3 - i8) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
    }
}
