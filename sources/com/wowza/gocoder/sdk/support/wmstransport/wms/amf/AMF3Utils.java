package com.wowza.gocoder.sdk.support.wmstransport.wms.amf;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: GoCoderSDK */
public class AMF3Utils {
    public static final String TAG = "AMF3Utils";

    public static Date deserializeDate(ByteBuffer byteBuffer) {
        double doubleValue = new Double(byteBuffer.getDouble()).doubleValue();
        Date date = new Date();
        date.setTime((long) doubleValue);
        return date;
    }

    public static int serializeDate(DataOutputStream dataOutputStream, Date date) {
        try {
            dataOutputStream.write(1);
            dataOutputStream.writeDouble((double) date.getTime());
            return 9;
        } catch (Exception e) {
            e.printStackTrace();
            return 9;
        }
    }

    public static int deserializeInt(ByteBuffer byteBuffer) {
        boolean z;
        int i;
        int i2 = 0;
        byte b = 0;
        while (i2 < 4) {
            try {
                byte b2 = byteBuffer.get();
                if (i2 < 3) {
                    i = b << 7;
                    z = (b2 & 128) == 128;
                    b2 = (byte) (b2 & Byte.MAX_VALUE);
                } else {
                    i = b << 8;
                    z = false;
                }
                b = i | (b2 & 255);
                if (!z) {
                    break;
                }
                i2++;
            } catch (Exception e) {
                e.printStackTrace();
                return b;
            }
        }
        return (b & 268435456) == 268435456 ? -268435456 | b : b;
    }

    public static int serializeInt(DataOutputStream dataOutputStream, int i) {
        int i2 = 4;
        if (i == 0) {
            try {
                dataOutputStream.write(0);
            } catch (Exception e) {
                e = e;
                i2 = 1;
            }
        } else if (i > 0) {
            if ((-2097152 & i) != 0) {
                try {
                    byte[] bArr = new byte[4];
                    bArr[0] = (byte) ((i >> 22) & 127);
                    bArr[0] = (byte) (bArr[0] | 128);
                    bArr[1] = (byte) ((i >> 15) & 127);
                    bArr[1] = (byte) (bArr[1] | 128);
                    bArr[2] = (byte) ((i >> 8) & 127);
                    bArr[2] = (byte) (bArr[2] | 128);
                    bArr[3] = (byte) (i & 255);
                    dataOutputStream.write(bArr);
                    return 4;
                } catch (Exception e2) {
                    e = e2;
                }
            } else if ((i & -16384) != 0) {
                try {
                    byte[] bArr2 = new byte[3];
                    bArr2[0] = (byte) ((i >> 14) & 127);
                    bArr2[0] = (byte) (bArr2[0] | 128);
                    bArr2[1] = (byte) ((i >> 7) & 127);
                    bArr2[1] = (byte) (bArr2[1] | 128);
                    bArr2[2] = (byte) (i & 127);
                    dataOutputStream.write(bArr2);
                    return 3;
                } catch (Exception e3) {
                    e = e3;
                    i2 = 3;
                    e.printStackTrace();
                    return i2;
                }
            } else if ((i & -128) != 0) {
                try {
                    dataOutputStream.write((((byte) (i >> 7)) & Byte.MAX_VALUE) | 128);
                    dataOutputStream.write(i & 127);
                    return 2;
                } catch (Exception e4) {
                    e = e4;
                    i2 = 2;
                    e.printStackTrace();
                    return i2;
                }
            } else {
                dataOutputStream.write(i & 127);
            }
        } else if (i < 0) {
            byte[] bArr3 = new byte[4];
            bArr3[0] = (byte) ((i >> 22) & 127);
            bArr3[0] = (byte) (bArr3[0] | 128);
            bArr3[1] = (byte) ((i >> 15) & 127);
            bArr3[1] = (byte) (bArr3[1] | 128);
            bArr3[2] = (byte) ((i >> 8) & 127);
            bArr3[2] = (byte) (bArr3[2] | 128);
            bArr3[3] = (byte) (i & 255);
            dataOutputStream.write(bArr3);
            return 4;
        }
        return 1;
    }

    public static String deserializeString(ByteBuffer byteBuffer, AMFDataContextDeserialize aMFDataContextDeserialize) throws IOException {
        int deserializeInt = deserializeInt(byteBuffer);
        if ((deserializeInt & 1) == 0) {
            return aMFDataContextDeserialize.getString(deserializeInt >> 1);
        }
        int i = deserializeInt >> 1;
        if (i <= 0) {
            return "";
        }
        String deserializeString = deserializeString(byteBuffer, i);
        aMFDataContextDeserialize.addString(deserializeString);
        return deserializeString;
    }

    public static String deserializeString(ByteBuffer byteBuffer) throws IOException {
        int deserializeInt = deserializeInt(byteBuffer);
        return deserializeInt > 0 ? deserializeString(byteBuffer, deserializeInt) : "";
    }

    public static String deserializeString(ByteBuffer byteBuffer, int i) throws IOException {
        int i2;
        int i3;
        int i4;
        if (i <= 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        char[] cArr = new char[i];
        byteBuffer.get(bArr, 0, i);
        int i5 = 0;
        int i6 = 0;
        while (i2 < i) {
            byte b = bArr[i2] & 255;
            if (b > Byte.MAX_VALUE) {
                break;
            }
            i5 = i2 + 1;
            cArr[i3] = (char) b;
            i6 = i3 + 1;
        }
        while (i2 < i) {
            byte b2 = bArr[i2] & 255;
            switch (b2 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    i2++;
                    cArr[i3] = (char) b2;
                    i3++;
                    continue;
                case 12:
                case 13:
                    i2 += 2;
                    if (i2 <= i) {
                        byte b3 = bArr[i2 - 1];
                        if ((b3 & 192) == 128) {
                            i4 = i3 + 1;
                            cArr[i3] = (char) (((b2 & Ascii.f275US) << 6) | (b3 & 63));
                            break;
                        } else {
                            throw new UTFDataFormatException("malformed input around byte " + i2);
                        }
                    } else {
                        throw new UTFDataFormatException("malformed input: partial character at end");
                    }
                case 14:
                    i2 += 3;
                    if (i2 <= i) {
                        byte b4 = bArr[i2 - 2];
                        int i7 = i2 - 1;
                        byte b5 = bArr[i7];
                        if ((b4 & 192) == 128 && (b5 & 192) == 128) {
                            i4 = i3 + 1;
                            cArr[i3] = (char) (((b2 & 15) << 12) | ((b4 & 63) << 6) | ((b5 & 63) << 0));
                            break;
                        } else {
                            throw new UTFDataFormatException("malformed input around byte " + i7);
                        }
                    } else {
                        throw new UTFDataFormatException("malformed input: partial character at end");
                    }
                    break;
                default:
                    throw new UTFDataFormatException("malformed input around byte " + i2);
            }
            i3 = i4;
        }
        return new String(cArr, 0, i3);
    }

    public static void serializeZeroLengthString(DataOutputStream dataOutputStream) {
        serializeInt(dataOutputStream, 1);
    }

    public static int serializeStringNoLength(DataOutputStream dataOutputStream, String str) throws IOException {
        int i;
        int i2;
        int length = str.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            i3 = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i3 + 3 : i3 + 2 : i3 + 1;
        }
        if (i3 <= 65535) {
            byte[] bArr = new byte[i3];
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                char charAt2 = str.charAt(i5);
                if (charAt2 < 1 || charAt2 > 127) {
                    break;
                }
                bArr[i] = (byte) charAt2;
                i5++;
                i6 = i + 1;
            }
            while (i5 < length) {
                char charAt3 = str.charAt(i5);
                if (charAt3 >= 1 && charAt3 <= 127) {
                    i2 = i + 1;
                    bArr[i] = (byte) charAt3;
                } else if (charAt3 > 2047) {
                    int i7 = i + 1;
                    bArr[i] = (byte) (((charAt3 >> 12) & 15) | 224);
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) (((charAt3 >> 6) & 63) | 128);
                    i2 = i8 + 1;
                    bArr[i8] = (byte) (((charAt3 >> 0) & 63) | 128);
                } else {
                    int i9 = i + 1;
                    bArr[i] = (byte) (((charAt3 >> 6) & 31) | PsExtractor.AUDIO_STREAM);
                    i = i9 + 1;
                    bArr[i9] = (byte) (((charAt3 >> 0) & 63) | 128);
                    i5++;
                }
                i = i2;
                i5++;
            }
            dataOutputStream.write(bArr, 0, i3);
            return i3;
        }
        throw new UTFDataFormatException("encoded string too long: " + i3 + " bytes");
    }

    public static int serializeString(DataOutputStream dataOutputStream, String str) throws IOException {
        int i;
        int i2;
        int length = str.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            i3 = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i3 + 3 : i3 + 2 : i3 + 1;
        }
        if (i3 <= 65535) {
            byte[] bArr = new byte[i3];
            int serializeInt = serializeInt(dataOutputStream, (i3 << 1) + 1);
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                char charAt2 = str.charAt(i5);
                if (charAt2 < 1 || charAt2 > 127) {
                    break;
                }
                bArr[i] = (byte) charAt2;
                i5++;
                i6 = i + 1;
            }
            while (i5 < length) {
                char charAt3 = str.charAt(i5);
                if (charAt3 >= 1 && charAt3 <= 127) {
                    i2 = i + 1;
                    bArr[i] = (byte) charAt3;
                } else if (charAt3 > 2047) {
                    int i7 = i + 1;
                    bArr[i] = (byte) (((charAt3 >> 12) & 15) | 224);
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) (((charAt3 >> 6) & 63) | 128);
                    i2 = i8 + 1;
                    bArr[i8] = (byte) (((charAt3 >> 0) & 63) | 128);
                } else {
                    int i9 = i + 1;
                    bArr[i] = (byte) (((charAt3 >> 6) & 31) | PsExtractor.AUDIO_STREAM);
                    i = i9 + 1;
                    bArr[i9] = (byte) (((charAt3 >> 0) & 63) | 128);
                    i5++;
                }
                i = i2;
                i5++;
            }
            dataOutputStream.write(bArr, 0, i3);
            return i3 + serializeInt;
        }
        throw new UTFDataFormatException("encoded string too long: " + i3 + " bytes");
    }
}
