package com.wowza.gocoder.sdk.support.wmstransport.p041a;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.common.base.Ascii;
import com.lowagie.text.html.HtmlTags;
import java.nio.ByteBuffer;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.a.c */
/* compiled from: GoCoderSDK */
public class C4307c {

    /* renamed from: a */
    public static final String[] f4416a = {"0", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", HtmlTags.ANCHOR, HtmlTags.f603B, "c", "d", "e", "f"};

    /* renamed from: b */
    public static final String[] f4417b = {"0", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", HtmlTags.ANCHOR, HtmlTags.f603B, "c", "d", "e", "f", "g", "h", HtmlTags.f606I, "j", "k", "l", "m", "n", "o", "p", "q", "r", HtmlTags.f607S, "t", HtmlTags.f608U, "v", "w", "x", "y", "z"};

    /* renamed from: c */
    private static final int[] f4418c = {0, -1222786812, 1849393673, -651803891, -596245485, 1802224919, -1303542246, 89147166, -1192425434, 267438370, -690582993, 1640713003, 1687882805, -746140367, 178294332, -1111666888, 1893405004, -943271864, 518034245, -1443016127, -1397942945, 464573531, -1030318250, 1972065874, -935978646, 2133579886, -1509057693, 286284391, 339746169, -1554129795, 2054922096, -848929164, -524934248, 1470882460, -1903320687, 965763221, 1019225995, -1948391793, 1392223618, -437885818, 1482369982, -280565062, 912304567, -2122487629, -2077413459, 858844841, -367612508, 1561029792, -1871891756, 661713872, -27873059, 1229681113, 1276851911, -83429437, 572568782, -1791134262, 679492338, -1617036298, 1186707707, -240748033, -185188639, 1139539941, -1697792792, 768638444, 2003863092, -1066580176, 424346685, -1370045127, -1425636825, 471548707, -985858002, 1914749226, -811758062, 2021674774, -1582953445, 381406495, 334203393, -1527362811, 2110785544, -892483316, 128685944, -1330227588, 1771050353, -561130379, -606235797, 1824543343, -1243213470, 50057318, -1085890722, 140205658, -780329641, 1717623891, 1664129869, -735225271, 218831172, -1172907968, -1748589140, 551249064, -100849755, 1323361953, 1269866943, -55746373, 629875638, -1835605326, 791391626, -1741263730, 1091579779, -166859129, -211965543, 1145071773, -1654248560, 712764052, -417483552, 1342207460, -1993984279, 1044117485, 996913395, -1938394633, 1431319290, -498207746, 1609612486, -387088958, 835403471, -2032730165, -2088322859, 882604497, -306365732, 1520499672, -287306647, 1509805421, -2133094816, 935743332, 848693370, -2054436482, 1554877043, -340767881, 1443693647, -518994613, 943097414, -1892989118, -1971650468, 1030144344, -465534379, 1398621009, -1640293083, 690412577, -268394708, 1193106984, 1112348982, -179251150, 745970495, -1687463365, 651564291, -1848912889, 1223530250, -1026546, -90173168, 1304285204, -1801743591, 596005405, 240529393, -1186205963, 1617800696, -680497924, -769643550, 1698556646, -1139037717, 184969455, -1229248553, 27715283, -662657570, 1872585946, 1791828932, -573513024, 83272141, -1276419895, 2123185853, -913244231, 280411316, -1481933392, -1560593746, 367459242, -859785049, 2078112163, -966773093, 1904080799, -1470385006, 524711318, 437662344, -1391725684, 1949151361, -1020235387, -1718580643, 781011801, -139786156, 1085720912, 1172737614, -218411190, 735906887, -1665086141, 561873531, -1772076161, 1329987698, -128204426, -49576344, 1242974060, -1825569695, 606979429, -380921071, 1582717461, -2022696680, 812505116, 893230850, -2111807994, 1527127307, -333718513, 1369871159, -423931341, 1067258174, -2004824006, -1915709660, 986535456, -471132883, 1425462313, 2032576965, -834967359, 387787724, -1610552632, -1521439274, 307064018, -882167841, 2088169179, -1043619357, 1993760999, -1343216662, 418243310, 498968048, -1432328972, 1938171897, -996415747, 167622793, -1092585075, 1741044352, -790889596, -712262502, 1654029726, -1146077549, 212729751, -1324306257, 101544363, -550817114, 1748431778, 1835447484, -629443144, 56440501, -1270810703, 1};

    /* renamed from: a */
    public static String m4268a(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = (str + f4416a[(bArr[i] & 240) >> 4]) + f4416a[bArr[i] & 15];
        }
        return str;
    }

    /* renamed from: a */
    public static String m4269a(byte[] bArr, int i, int i2) {
        String str = "";
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            str = (str + f4416a[(bArr[i4] & 240) >> 4]) + f4416a[bArr[i4] & 15];
        }
        return str;
    }

    /* renamed from: a */
    public static byte[] m4279a(String str) {
        byte[] bArr = null;
        try {
            if (str.length() % 2 == 1) {
                str = "0" + str;
            }
            bArr = new byte[(str.length() / 2)];
            int i = 0;
            int length = str.length();
            while (true) {
                int i2 = i + 2;
                bArr[i / 2] = (byte) (Integer.parseInt(str.substring(i, i2), 16) & 255);
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        } catch (Exception e) {
            System.out.println("BufferUtils.decodeHexString: " + e.toString());
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m4284b(byte[] bArr) {
        return m4285b(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static String m4270a(byte[] bArr, int i, int i2, String str) {
        try {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new String(bArr2, str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m4285b(byte[] bArr, int i, int i2) {
        try {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new String(bArr2, "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static long m4288c(byte[] bArr) {
        return ((((((((((((((((long) (bArr[0] & 255)) | 0) << 8) | ((long) (bArr[1] & 255))) << 8) | ((long) (bArr[2] & 255))) << 8) | ((long) (bArr[3] & 255))) << 8) | ((long) (bArr[4] & 255))) << 8) | ((long) (bArr[5] & 255))) << 8) | ((long) (bArr[6] & 255))) << 8) | ((long) (bArr[7] & 255));
    }

    /* renamed from: a */
    public static long m4266a(byte[] bArr, int i) {
        return ((long) (bArr[i + 7] & 255)) | ((((((((((((((((long) (bArr[i + 0] & 255)) | 0) << 8) | ((long) (bArr[i + 1] & 255))) << 8) | ((long) (bArr[i + 2] & 255))) << 8) | ((long) (bArr[i + 3] & 255))) << 8) | ((long) (bArr[i + 4] & 255))) << 8) | ((long) (bArr[i + 5] & 255))) << 8) | ((long) (bArr[i + 6] & 255))) << 8);
    }

    /* renamed from: c */
    public static long m4289c(byte[] bArr, int i, int i2) {
        return m4267a(bArr, i, i2, false);
    }

    /* renamed from: a */
    public static long m4267a(byte[] bArr, int i, int i2, boolean z) {
        byte b;
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                j <<= 8;
            }
            if (z) {
                b = bArr[(i2 - (i3 + 1)) + i];
            } else {
                b = bArr[i + i3];
            }
            j |= (long) (b & 255);
        }
        return j;
    }

    /* renamed from: d */
    public static int m4291d(byte[] bArr) {
        return (bArr[3] & 255) | (bArr[0] << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    /* renamed from: b */
    public static int m4281b(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (bArr[i + 0] << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: d */
    public static int m4292d(byte[] bArr, int i, int i2) {
        return m4282b(bArr, i, i2, false);
    }

    /* renamed from: b */
    public static int m4282b(byte[] bArr, int i, int i2, boolean z) {
        byte b;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 > 0) {
                i3 <<= 8;
            }
            if (z) {
                b = bArr[(i2 - (i4 + 1)) + i];
            } else {
                b = bArr[i + i4];
            }
            i3 |= b & 255;
        }
        return i3;
    }

    /* renamed from: e */
    public static int m4293e(byte[] bArr) {
        return m4287c(bArr, 0, 2, false);
    }

    /* renamed from: c */
    public static int m4286c(byte[] bArr, int i) {
        return m4287c(bArr, i, 2, false);
    }

    /* renamed from: e */
    public static int m4294e(byte[] bArr, int i, int i2) {
        return m4287c(bArr, i, i2, false);
    }

    /* renamed from: c */
    public static int m4287c(byte[] bArr, int i, int i2, boolean z) {
        byte b;
        short s = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                s = (short) (s << 8);
            }
            if (z) {
                b = bArr[(i2 - (i3 + 1)) + i];
            } else {
                b = bArr[i + i3];
            }
            s = (short) (s | (b & 255));
        }
        return s;
    }

    /* renamed from: a */
    public static byte[] m4275a(int i) {
        return m4276a(i, 4);
    }

    /* renamed from: a */
    public static byte[] m4276a(int i, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < Math.min(i2, 4); i3++) {
            bArr[(i2 - i3) - 1] = (byte) (i & 255);
            i >>= 8;
            if (i == 0) {
                break;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static void m4271a(int i, byte[] bArr, int i2, int i3) {
        m4272a(i, bArr, i2, i3, false);
    }

    /* renamed from: a */
    public static void m4272a(int i, byte[] bArr, int i2, int i3, boolean z) {
        for (int i4 = 0; i4 < Math.min(i3, 4); i4++) {
            bArr[(z ? i4 : i3 - (i4 + 1)) + i2] = (byte) (i & 255);
            i >>= 8;
        }
    }

    /* renamed from: a */
    public static byte[] m4277a(long j) {
        return m4278a(j, 8);
    }

    /* renamed from: a */
    public static byte[] m4278a(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < Math.min(i, 8); i2++) {
            bArr[(i - i2) - 1] = (byte) ((int) (255 & j));
            j >>= 8;
            if (j == 0) {
                break;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static void m4273a(long j, byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < Math.min(i2, 8); i3++) {
            bArr[((i2 - i3) - 1) + i] = (byte) ((int) (255 & j));
            j >>= 8;
        }
    }

    /* renamed from: a */
    public static void m4274a(long j, byte[] bArr, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < Math.min(i2, 8); i3++) {
            bArr[(z ? i3 : i2 - (i3 + 1)) + i] = (byte) ((int) (255 & j));
            j >>= 8;
        }
    }

    /* renamed from: a */
    public static int m4264a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        return m4292d(bArr, 0, 2);
    }

    /* renamed from: b */
    public static int m4280b(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i >> 8) & 16777215;
            i = i5 ^ f4418c[(bArr[i4 + i2] ^ i) & 255];
        }
        return i;
    }

    /* renamed from: a */
    public static int m4265a(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            int length = bArr.length;
            int length2 = bArr2.length;
            if (!(length == 0 || length2 == 0)) {
                int i = 0;
                byte b = bArr2[0];
                int i2 = length - length2;
                while (i <= i2) {
                    int i3 = 1;
                    if (bArr[i] != b) {
                        do {
                            i++;
                            if (i > i2) {
                                break;
                            }
                        } while (bArr[i] == b);
                    }
                    if (i <= i2) {
                        int i4 = i + 1;
                        int i5 = (i4 + length2) - 1;
                        while (i4 < i5 && bArr[i4] == bArr2[i3]) {
                            i4++;
                            i3++;
                        }
                        if (i4 == i5) {
                            return i;
                        }
                    }
                    i++;
                }
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static int m4283b(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < min; i++) {
                if (bArr[i] != bArr2[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static boolean m4290c(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            return true;
        }
        if (bArr == null) {
            return false;
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length2 == 0) {
            return true;
        }
        if (length == 0 || length2 > length) {
            return false;
        }
        for (int i = 0; i < length2; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
