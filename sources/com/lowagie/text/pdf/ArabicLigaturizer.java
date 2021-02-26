package com.lowagie.text.pdf;

public class ArabicLigaturizer {
    private static final char ALEF = 'ا';
    private static final char ALEFHAMZA = 'أ';
    private static final char ALEFHAMZABELOW = 'إ';
    private static final char ALEFMADDA = 'آ';
    private static final char ALEFMAKSURA = 'ى';
    private static final char DAMMA = 'ُ';
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGITS_MASK = 224;
    private static final int DIGITS_RESERVED = 160;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final int DIGIT_TYPE_MASK = 256;
    private static final char FARSIYEH = 'ی';
    private static final char FATHA = 'َ';
    private static final char HAMZA = 'ء';
    private static final char HAMZAABOVE = 'ٔ';
    private static final char HAMZABELOW = 'ٕ';
    private static final char KASRA = 'ِ';
    private static final char LAM = 'ل';
    private static final char LAM_ALEF = 'ﻻ';
    private static final char LAM_ALEFHAMZA = 'ﻷ';
    private static final char LAM_ALEFHAMZABELOW = 'ﻹ';
    private static final char LAM_ALEFMADDA = 'ﻵ';
    private static final char MADDA = 'ٓ';
    private static final char SHADDA = 'ّ';
    private static final char TATWEEL = 'ـ';
    private static final char WAW = 'و';
    private static final char WAWHAMZA = 'ؤ';
    private static final char YEH = 'ي';
    private static final char YEHHAMZA = 'ئ';
    private static final char ZWJ = '‍';
    public static final int ar_composedtashkeel = 4;
    public static final int ar_lig = 8;
    public static final int ar_nothing = 0;
    public static final int ar_novowel = 1;
    private static final char[][] chartable = {new char[]{HAMZA, 65152}, new char[]{ALEFMADDA, 65153, 65154}, new char[]{ALEFHAMZA, 65155, 65156}, new char[]{WAWHAMZA, 65157, 65158}, new char[]{ALEFHAMZABELOW, 65159, 65160}, new char[]{YEHHAMZA, 65161, 65162, 65163, 65164}, new char[]{ALEF, 65165, 65166}, new char[]{1576, 65167, 65168, 65169, 65170}, new char[]{1577, 65171, 65172}, new char[]{1578, 65173, 65174, 65175, 65176}, new char[]{1579, 65177, 65178, 65179, 65180}, new char[]{1580, 65181, 65182, 65183, 65184}, new char[]{1581, 65185, 65186, 65187, 65188}, new char[]{1582, 65189, 65190, 65191, 65192}, new char[]{1583, 65193, 65194}, new char[]{1584, 65195, 65196}, new char[]{1585, 65197, 65198}, new char[]{1586, 65199, 65200}, new char[]{1587, 65201, 65202, 65203, 65204}, new char[]{1588, 65205, 65206, 65207, 65208}, new char[]{1589, 65209, 65210, 65211, 65212}, new char[]{1590, 65213, 65214, 65215, 65216}, new char[]{1591, 65217, 65218, 65219, 65220}, new char[]{1592, 65221, 65222, 65223, 65224}, new char[]{1593, 65225, 65226, 65227, 65228}, new char[]{1594, 65229, 65230, 65231, 65232}, new char[]{TATWEEL, TATWEEL, TATWEEL, TATWEEL, TATWEEL}, new char[]{1601, 65233, 65234, 65235, 65236}, new char[]{1602, 65237, 65238, 65239, 65240}, new char[]{1603, 65241, 65242, 65243, 65244}, new char[]{LAM, 65245, 65246, 65247, 65248}, new char[]{1605, 65249, 65250, 65251, 65252}, new char[]{1606, 65253, 65254, 65255, 65256}, new char[]{1607, 65257, 65258, 65259, 65260}, new char[]{WAW, 65261, 65262}, new char[]{ALEFMAKSURA, 65263, 65264, 64488, 64489}, new char[]{YEH, 65265, 65266, 65267, 65268}, new char[]{1649, 64336, 64337}, new char[]{1657, 64358, 64359, 64360, 64361}, new char[]{1658, 64350, 64351, 64352, 64353}, new char[]{1659, 64338, 64339, 64340, 64341}, new char[]{1662, 64342, 64343, 64344, 64345}, new char[]{1663, 64354, 64355, 64356, 64357}, new char[]{1664, 64346, 64347, 64348, 64349}, new char[]{1667, 64374, 64375, 64376, 64377}, new char[]{1668, 64370, 64371, 64372, 64373}, new char[]{1670, 64378, 64379, 64380, 64381}, new char[]{1671, 64382, 64383, 64384, 64385}, new char[]{1672, 64392, 64393}, new char[]{1676, 64388, 64389}, new char[]{1677, 64386, 64387}, new char[]{1678, 64390, 64391}, new char[]{1681, 64396, 64397}, new char[]{1688, 64394, 64395}, new char[]{1700, 64362, 64363, 64364, 64365}, new char[]{1702, 64366, 64367, 64368, 64369}, new char[]{1705, 64398, 64399, 64400, 64401}, new char[]{1709, 64467, 64468, 64469, 64470}, new char[]{1711, 64402, 64403, 64404, 64405}, new char[]{1713, 64410, 64411, 64412, 64413}, new char[]{1715, 64406, 64407, 64408, 64409}, new char[]{1722, 64414, 64415}, new char[]{1723, 64416, 64417, 64418, 64419}, new char[]{1726, 64426, 64427, 64428, 64429}, new char[]{1728, 64420, 64421}, new char[]{1729, 64422, 64423, 64424, 64425}, new char[]{1733, 64480, 64481}, new char[]{1734, 64473, 64474}, new char[]{1735, 64471, 64472}, new char[]{1736, 64475, 64476}, new char[]{1737, 64482, 64483}, new char[]{1739, 64478, 64479}, new char[]{FARSIYEH, 64508, 64509, 64510, 64511}, new char[]{1744, 64484, 64485, 64486, 64487}, new char[]{1746, 64430, 64431}, new char[]{1747, 64432, 64433}};

    static boolean isVowel(char c) {
        return (c >= 1611 && c <= 1621) || c == 1648;
    }

    static char charshape(char c, int i) {
        if (c < 1569 || c > 1747) {
            return (c < 65269 || c > 65275) ? c : (char) (c + i);
        }
        int length = chartable.length - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (i2 + length) / 2;
            char[][] cArr = chartable;
            if (c == cArr[i3][0]) {
                return cArr[i3][i + 1];
            }
            if (c < cArr[i3][0]) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return c;
    }

    static int shapecount(char c) {
        if (c >= 1569 && c <= 1747 && !isVowel(c)) {
            int length = chartable.length - 1;
            int i = 0;
            while (i <= length) {
                int i2 = (i + length) / 2;
                char[][] cArr = chartable;
                if (c == cArr[i2][0]) {
                    return cArr[i2].length - 1;
                }
                if (c < cArr[i2][0]) {
                    length = i2 - 1;
                } else {
                    i = i2 + 1;
                }
            }
        } else if (c == 8205) {
            return 4;
        }
        return 1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int ligature(char r12, com.lowagie.text.pdf.ArabicLigaturizer.charstruct r13) {
        /*
            char r0 = r13.basechar
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = isVowel(r12)
            r2 = 65273(0xfef9, float:9.1467E-41)
            r3 = 65271(0xfef7, float:9.1464E-41)
            r4 = 1573(0x625, float:2.204E-42)
            r5 = 1571(0x623, float:2.201E-42)
            r6 = 1570(0x622, float:2.2E-42)
            r7 = 65275(0xfefb, float:9.147E-41)
            r8 = 1575(0x627, float:2.207E-42)
            r9 = 1
            r10 = 2
            if (r0 == 0) goto L_0x007c
            char r0 = r13.vowel
            r11 = 1617(0x651, float:2.266E-42)
            if (r0 == 0) goto L_0x0029
            if (r12 == r11) goto L_0x0029
            r0 = 2
            goto L_0x002a
        L_0x0029:
            r0 = 1
        L_0x002a:
            switch(r12) {
                case 1617: goto L_0x006b;
                case 1618: goto L_0x002d;
                case 1619: goto L_0x0063;
                case 1620: goto L_0x0041;
                case 1621: goto L_0x0030;
                default: goto L_0x002d;
            }
        L_0x002d:
            r13.vowel = r12
            goto L_0x0073
        L_0x0030:
            char r12 = r13.basechar
            if (r12 == r8) goto L_0x003e
            if (r12 == r7) goto L_0x003b
            r12 = 1621(0x655, float:2.272E-42)
            r13.mark1 = r12
            goto L_0x0073
        L_0x003b:
            r13.basechar = r2
            goto L_0x0074
        L_0x003e:
            r13.basechar = r4
            goto L_0x0074
        L_0x0041:
            char r12 = r13.basechar
            if (r12 == r8) goto L_0x0060
            r1 = 1740(0x6cc, float:2.438E-42)
            if (r12 == r1) goto L_0x005b
            if (r12 == r7) goto L_0x0058
            switch(r12) {
                case 1608: goto L_0x0053;
                case 1609: goto L_0x005b;
                case 1610: goto L_0x005b;
                default: goto L_0x004e;
            }
        L_0x004e:
            r12 = 1620(0x654, float:2.27E-42)
            r13.mark1 = r12
            goto L_0x0073
        L_0x0053:
            r12 = 1572(0x624, float:2.203E-42)
            r13.basechar = r12
            goto L_0x0074
        L_0x0058:
            r13.basechar = r3
            goto L_0x0074
        L_0x005b:
            r12 = 1574(0x626, float:2.206E-42)
            r13.basechar = r12
            goto L_0x0074
        L_0x0060:
            r13.basechar = r5
            goto L_0x0074
        L_0x0063:
            char r12 = r13.basechar
            if (r12 == r8) goto L_0x0068
            goto L_0x0073
        L_0x0068:
            r13.basechar = r6
            goto L_0x0074
        L_0x006b:
            char r12 = r13.mark1
            if (r12 != 0) goto L_0x0072
            r13.mark1 = r11
            goto L_0x0073
        L_0x0072:
            return r1
        L_0x0073:
            r10 = r0
        L_0x0074:
            if (r10 != r9) goto L_0x007b
            int r12 = r13.lignum
            int r12 = r12 + r9
            r13.lignum = r12
        L_0x007b:
            return r10
        L_0x007c:
            char r0 = r13.vowel
            if (r0 == 0) goto L_0x0081
            return r1
        L_0x0081:
            char r0 = r13.basechar
            r11 = 3
            if (r0 == 0) goto L_0x00ae
            r9 = 1604(0x644, float:2.248E-42)
            if (r0 == r9) goto L_0x008c
            r11 = 0
            goto L_0x00b7
        L_0x008c:
            if (r12 == r6) goto L_0x00a4
            if (r12 == r5) goto L_0x009f
            if (r12 == r4) goto L_0x009a
            if (r12 == r8) goto L_0x0095
            goto L_0x00ac
        L_0x0095:
            r13.basechar = r7
            r13.numshapes = r10
            goto L_0x00b7
        L_0x009a:
            r13.basechar = r2
            r13.numshapes = r10
            goto L_0x00b7
        L_0x009f:
            r13.basechar = r3
            r13.numshapes = r10
            goto L_0x00b7
        L_0x00a4:
            r12 = 65269(0xfef5, float:9.1461E-41)
            r13.basechar = r12
            r13.numshapes = r10
            r1 = 3
        L_0x00ac:
            r11 = r1
            goto L_0x00b7
        L_0x00ae:
            r13.basechar = r12
            int r12 = shapecount(r12)
            r13.numshapes = r12
            r11 = 1
        L_0x00b7:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.ArabicLigaturizer.ligature(char, com.lowagie.text.pdf.ArabicLigaturizer$charstruct):int");
    }

    static void copycstostring(StringBuffer stringBuffer, charstruct charstruct2, int i) {
        if (charstruct2.basechar != 0) {
            stringBuffer.append(charstruct2.basechar);
            charstruct2.lignum--;
            if (charstruct2.mark1 != 0) {
                if ((i & 1) == 0) {
                    stringBuffer.append(charstruct2.mark1);
                    charstruct2.lignum--;
                } else {
                    charstruct2.lignum--;
                }
            }
            if (charstruct2.vowel == 0) {
                return;
            }
            if ((i & 1) == 0) {
                stringBuffer.append(charstruct2.vowel);
                charstruct2.lignum--;
                return;
            }
            charstruct2.lignum--;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r5 = 64610;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        r5 = 64609;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        r5 = 64608;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void doublelig(java.lang.StringBuffer r10, int r11) {
        /*
            int r0 = r10.length()
            r1 = 0
            r2 = 1
            r3 = r0
            r4 = 0
        L_0x0008:
            if (r2 < r0) goto L_0x000e
            r10.setLength(r3)
            return
        L_0x000e:
            r5 = r11 & 4
            r6 = 64610(0xfc62, float:9.0538E-41)
            r7 = 64609(0xfc61, float:9.0536E-41)
            r8 = 64608(0xfc60, float:9.0535E-41)
            if (r5 == 0) goto L_0x0053
            char r5 = r10.charAt(r4)
            r9 = 1617(0x651, float:2.266E-42)
            switch(r5) {
                case 1614: goto L_0x0049;
                case 1615: goto L_0x003f;
                case 1616: goto L_0x0035;
                case 1617: goto L_0x0025;
                default: goto L_0x0024;
            }
        L_0x0024:
            goto L_0x0053
        L_0x0025:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 1612: goto L_0x0031;
                case 1613: goto L_0x002d;
                case 1614: goto L_0x004f;
                case 1615: goto L_0x0045;
                case 1616: goto L_0x003b;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x0053
        L_0x002d:
            r5 = 64607(0xfc5f, float:9.0534E-41)
            goto L_0x0054
        L_0x0031:
            r5 = 64606(0xfc5e, float:9.0532E-41)
            goto L_0x0054
        L_0x0035:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0053
        L_0x003b:
            r5 = 64610(0xfc62, float:9.0538E-41)
            goto L_0x0054
        L_0x003f:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0053
        L_0x0045:
            r5 = 64609(0xfc61, float:9.0536E-41)
            goto L_0x0054
        L_0x0049:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0053
        L_0x004f:
            r5 = 64608(0xfc60, float:9.0535E-41)
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0121
            char r6 = r10.charAt(r4)
            r7 = 65192(0xfea8, float:9.1353E-41)
            r8 = 65188(0xfea4, float:9.1348E-41)
            r9 = 65184(0xfea0, float:9.1342E-41)
            switch(r6) {
                case 65169: goto L_0x010b;
                case 65175: goto L_0x00f4;
                case 65235: goto L_0x00e6;
                case 65247: goto L_0x00bc;
                case 65251: goto L_0x009f;
                case 65255: goto L_0x0084;
                case 65256: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x0121
        L_0x006a:
            char r6 = r10.charAt(r2)
            r7 = 65198(0xfeae, float:9.1362E-41)
            if (r6 == r7) goto L_0x007f
            r7 = 65200(0xfeb0, float:9.1365E-41)
            if (r6 == r7) goto L_0x007a
            goto L_0x0121
        L_0x007a:
            r5 = 64651(0xfc8b, float:9.0595E-41)
            goto L_0x0121
        L_0x007f:
            r5 = 64650(0xfc8a, float:9.0594E-41)
            goto L_0x0121
        L_0x0084:
            char r6 = r10.charAt(r2)
            if (r6 == r9) goto L_0x009a
            if (r6 == r8) goto L_0x0095
            if (r6 == r7) goto L_0x0090
            goto L_0x0121
        L_0x0090:
            r5 = 64724(0xfcd4, float:9.0698E-41)
            goto L_0x0121
        L_0x0095:
            r5 = 64723(0xfcd3, float:9.0696E-41)
            goto L_0x0121
        L_0x009a:
            r5 = 64722(0xfcd2, float:9.0695E-41)
            goto L_0x0121
        L_0x009f:
            char r6 = r10.charAt(r2)
            switch(r6) {
                case 65184: goto L_0x00b7;
                case 65188: goto L_0x00b2;
                case 65192: goto L_0x00ad;
                case 65252: goto L_0x00a8;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            goto L_0x0121
        L_0x00a8:
            r5 = 64721(0xfcd1, float:9.0693E-41)
            goto L_0x0121
        L_0x00ad:
            r5 = 64720(0xfcd0, float:9.0692E-41)
            goto L_0x0121
        L_0x00b2:
            r5 = 64719(0xfccf, float:9.069E-41)
            goto L_0x0121
        L_0x00b7:
            r5 = 64718(0xfcce, float:9.0689E-41)
            goto L_0x0121
        L_0x00bc:
            char r6 = r10.charAt(r2)
            switch(r6) {
                case 65182: goto L_0x00e2;
                case 65184: goto L_0x00de;
                case 65186: goto L_0x00da;
                case 65188: goto L_0x00d6;
                case 65190: goto L_0x00d2;
                case 65192: goto L_0x00ce;
                case 65250: goto L_0x00ca;
                case 65252: goto L_0x00c5;
                default: goto L_0x00c3;
            }
        L_0x00c3:
            goto L_0x0121
        L_0x00c5:
            r5 = 64716(0xfccc, float:9.0686E-41)
            goto L_0x0121
        L_0x00ca:
            r5 = 64578(0xfc42, float:9.0493E-41)
            goto L_0x0121
        L_0x00ce:
            r5 = 64715(0xfccb, float:9.0685E-41)
            goto L_0x0121
        L_0x00d2:
            r5 = 64577(0xfc41, float:9.0492E-41)
            goto L_0x0121
        L_0x00d6:
            r5 = 64714(0xfcca, float:9.0684E-41)
            goto L_0x0121
        L_0x00da:
            r5 = 64576(0xfc40, float:9.049E-41)
            goto L_0x0121
        L_0x00de:
            r5 = 64713(0xfcc9, float:9.0682E-41)
            goto L_0x0121
        L_0x00e2:
            r5 = 64575(0xfc3f, float:9.0489E-41)
            goto L_0x0121
        L_0x00e6:
            char r6 = r10.charAt(r2)
            r7 = 65266(0xfef2, float:9.1457E-41)
            if (r6 == r7) goto L_0x00f0
            goto L_0x0121
        L_0x00f0:
            r5 = 64562(0xfc32, float:9.047E-41)
            goto L_0x0121
        L_0x00f4:
            char r6 = r10.charAt(r2)
            if (r6 == r9) goto L_0x0107
            if (r6 == r8) goto L_0x0103
            if (r6 == r7) goto L_0x00ff
            goto L_0x0121
        L_0x00ff:
            r5 = 64675(0xfca3, float:9.0629E-41)
            goto L_0x0121
        L_0x0103:
            r5 = 64674(0xfca2, float:9.0628E-41)
            goto L_0x0121
        L_0x0107:
            r5 = 64673(0xfca1, float:9.0626E-41)
            goto L_0x0121
        L_0x010b:
            char r6 = r10.charAt(r2)
            if (r6 == r9) goto L_0x011e
            if (r6 == r8) goto L_0x011a
            if (r6 == r7) goto L_0x0116
            goto L_0x0121
        L_0x0116:
            r5 = 64670(0xfc9e, float:9.0622E-41)
            goto L_0x0121
        L_0x011a:
            r5 = 64669(0xfc9d, float:9.062E-41)
            goto L_0x0121
        L_0x011e:
            r5 = 64668(0xfc9c, float:9.0619E-41)
        L_0x0121:
            if (r5 == 0) goto L_0x0129
            r10.setCharAt(r4, r5)
            int r3 = r3 + -1
            goto L_0x0132
        L_0x0129:
            int r4 = r4 + 1
            char r5 = r10.charAt(r2)
            r10.setCharAt(r4, r5)
        L_0x0132:
            int r2 = r2 + 1
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.ArabicLigaturizer.doublelig(java.lang.StringBuffer, int):void");
    }

    static boolean connects_to_left(charstruct charstruct2) {
        return charstruct2.numshapes > 2;
    }

    static void shape(char[] cArr, StringBuffer stringBuffer, int i) {
        charstruct charstruct2 = new charstruct();
        charstruct charstruct3 = new charstruct();
        charstruct charstruct4 = charstruct2;
        int i2 = 0;
        while (i2 < cArr.length) {
            int i3 = i2 + 1;
            char c = cArr[i2];
            if (ligature(c, charstruct3) == 0) {
                int shapecount = shapecount(c);
                int i4 = shapecount == 1 ? 0 : 2;
                if (connects_to_left(charstruct4)) {
                    i4++;
                }
                charstruct3.basechar = charshape(charstruct3.basechar, i4 % charstruct3.numshapes);
                copycstostring(stringBuffer, charstruct4, i);
                charstruct charstruct5 = new charstruct();
                charstruct5.basechar = c;
                charstruct5.numshapes = shapecount;
                charstruct5.lignum++;
                i2 = i3;
                charstruct charstruct6 = charstruct5;
                charstruct4 = charstruct3;
                charstruct3 = charstruct6;
            } else {
                i2 = i3;
            }
        }
        charstruct3.basechar = charshape(charstruct3.basechar, (connects_to_left(charstruct4) ? 1 : 0) % charstruct3.numshapes);
        copycstostring(stringBuffer, charstruct4, i);
        copycstostring(stringBuffer, charstruct3, i);
    }

    static int arabic_shape(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, int i5) {
        char[] cArr3 = new char[i2];
        for (int i6 = (i2 + i) - 1; i6 >= i; i6--) {
            cArr3[i6 - i] = cArr[i6];
        }
        StringBuffer stringBuffer = new StringBuffer(i2);
        shape(cArr3, stringBuffer, i5);
        if ((i5 & 12) != 0) {
            doublelig(stringBuffer, i5);
        }
        System.arraycopy(stringBuffer.toString().toCharArray(), 0, cArr2, i3, stringBuffer.length());
        return stringBuffer.length();
    }

    static void processNumbers(char[] cArr, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = i3 & 224;
        if (i5 != 0) {
            int i6 = i3 & 256;
            char c = i6 != 0 ? i6 != 256 ? '0' : 1776 : 1632;
            if (i5 == 32) {
                int i7 = c - '0';
                while (i < i4) {
                    char c2 = cArr[i];
                    if (c2 <= '9' && c2 >= '0') {
                        cArr[i] = (char) (cArr[i] + i7);
                    }
                    i++;
                }
            } else if (i5 == 64) {
                char c3 = (char) (c + 9);
                int i8 = '0' - c;
                while (i < i4) {
                    char c4 = cArr[i];
                    if (c4 <= c3 && c4 >= c) {
                        cArr[i] = (char) (cArr[i] + i8);
                    }
                    i++;
                }
            } else if (i5 == 96) {
                shapeToArabicDigitsWithContext(cArr, 0, i2, c, false);
            } else if (i5 == 128) {
                shapeToArabicDigitsWithContext(cArr, 0, i2, c, true);
            }
        }
    }

    static void shapeToArabicDigitsWithContext(char[] cArr, int i, int i2, char c, boolean z) {
        char c2 = (char) (c - '0');
        int i3 = i2 + i;
        while (i < i3) {
            char c3 = cArr[i];
            byte direction = BidiOrder.getDirection(c3);
            if (direction != 0) {
                if (direction != 8) {
                    if (direction != 3) {
                        if (direction == 4) {
                            z = true;
                        }
                    }
                } else if (z && c3 <= '9') {
                    cArr[i] = (char) (c3 + c2);
                }
                i++;
            }
            z = false;
            i++;
        }
    }

    static class charstruct {
        char basechar;
        int lignum;
        char mark1;
        int numshapes = 1;
        char vowel;

        charstruct() {
        }
    }
}
