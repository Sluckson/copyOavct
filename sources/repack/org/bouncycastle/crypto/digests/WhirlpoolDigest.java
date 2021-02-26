package repack.org.bouncycastle.crypto.digests;

import repack.org.bouncycastle.crypto.ExtendedDigest;
import repack.org.bouncycastle.util.Arrays;

public final class WhirlpoolDigest implements ExtendedDigest {
    private static final int BITCOUNT_ARRAY_SIZE = 32;
    private static final int BYTE_LENGTH = 64;

    /* renamed from: C0 */
    private static final long[] f6031C0 = new long[256];

    /* renamed from: C1 */
    private static final long[] f6032C1 = new long[256];

    /* renamed from: C2 */
    private static final long[] f6033C2 = new long[256];

    /* renamed from: C3 */
    private static final long[] f6034C3 = new long[256];

    /* renamed from: C4 */
    private static final long[] f6035C4 = new long[256];

    /* renamed from: C5 */
    private static final long[] f6036C5 = new long[256];

    /* renamed from: C6 */
    private static final long[] f6037C6 = new long[256];

    /* renamed from: C7 */
    private static final long[] f6038C7 = new long[256];
    private static final int DIGEST_LENGTH_BYTES = 64;
    private static final short[] EIGHT = new short[32];
    private static final int REDUCTION_POLYNOMIAL = 285;
    private static final int ROUNDS = 10;
    private static final int[] SBOX;

    /* renamed from: _K */
    private long[] f6039_K = new long[8];

    /* renamed from: _L */
    private long[] f6040_L = new long[8];
    private short[] _bitCount = new short[32];
    private long[] _block = new long[8];
    private byte[] _buffer = new byte[64];
    private int _bufferPos = 0;
    private long[] _hash = new long[8];
    private final long[] _rc = new long[11];
    private long[] _state = new long[8];

    private int maskWithReductionPolynomial(int i) {
        return ((long) i) >= 256 ? i ^ 285 : i;
    }

    private long packIntoLong(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return (((((((((long) i2) << 48) ^ (((long) i) << 56)) ^ (((long) i3) << 40)) ^ (((long) i4) << 32)) ^ (((long) i5) << 24)) ^ (((long) i6) << 16)) ^ (((long) i7) << 8)) ^ ((long) i8);
    }

    public String getAlgorithmName() {
        return "Whirlpool";
    }

    public int getByteLength() {
        return 64;
    }

    public int getDigestSize() {
        return 64;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: int[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 256(0x100, float:3.59E-43)
            int[] r1 = new int[r0]
            r2 = 24
            r3 = 0
            r1[r3] = r2
            r3 = 35
            r4 = 1
            r1[r4] = r3
            r5 = 198(0xc6, float:2.77E-43)
            r6 = 2
            r1[r6] = r5
            r7 = 232(0xe8, float:3.25E-43)
            r8 = 3
            r1[r8] = r7
            r9 = 135(0x87, float:1.89E-43)
            r10 = 4
            r1[r10] = r9
            r11 = 184(0xb8, float:2.58E-43)
            r12 = 5
            r1[r12] = r11
            r13 = 6
            r1[r13] = r4
            r4 = 7
            r13 = 79
            r1[r4] = r13
            r4 = 8
            r13 = 54
            r1[r4] = r13
            r13 = 9
            r14 = 166(0xa6, float:2.33E-43)
            r1[r13] = r14
            r13 = 10
            r14 = 210(0xd2, float:2.94E-43)
            r1[r13] = r14
            r13 = 11
            r14 = 245(0xf5, float:3.43E-43)
            r1[r13] = r14
            r13 = 12
            r14 = 121(0x79, float:1.7E-43)
            r1[r13] = r14
            r13 = 13
            r14 = 111(0x6f, float:1.56E-43)
            r1[r13] = r14
            r13 = 14
            r14 = 145(0x91, float:2.03E-43)
            r1[r13] = r14
            r13 = 15
            r14 = 82
            r1[r13] = r14
            r13 = 16
            r14 = 96
            r1[r13] = r14
            r13 = 17
            r14 = 188(0xbc, float:2.63E-43)
            r1[r13] = r14
            r13 = 18
            r14 = 155(0x9b, float:2.17E-43)
            r1[r13] = r14
            r13 = 19
            r14 = 142(0x8e, float:1.99E-43)
            r1[r13] = r14
            r13 = 20
            r14 = 163(0xa3, float:2.28E-43)
            r1[r13] = r14
            r13 = 21
            r14 = 12
            r1[r13] = r14
            r13 = 22
            r14 = 123(0x7b, float:1.72E-43)
            r1[r13] = r14
            r13 = 23
            r14 = 53
            r1[r13] = r14
            r13 = 29
            r1[r2] = r13
            r2 = 25
            r13 = 224(0xe0, float:3.14E-43)
            r1[r2] = r13
            r2 = 26
            r13 = 215(0xd7, float:3.01E-43)
            r1[r2] = r13
            r2 = 27
            r13 = 194(0xc2, float:2.72E-43)
            r1[r2] = r13
            r2 = 28
            r13 = 46
            r1[r2] = r13
            r2 = 29
            r13 = 75
            r1[r2] = r13
            r2 = 30
            r13 = 254(0xfe, float:3.56E-43)
            r1[r2] = r13
            r2 = 31
            r13 = 87
            r1[r2] = r13
            r13 = 32
            r14 = 21
            r1[r13] = r14
            r14 = 33
            r15 = 119(0x77, float:1.67E-43)
            r1[r14] = r15
            r14 = 34
            r15 = 55
            r1[r14] = r15
            r14 = 229(0xe5, float:3.21E-43)
            r1[r3] = r14
            r3 = 36
            r14 = 159(0x9f, float:2.23E-43)
            r1[r3] = r14
            r3 = 37
            r14 = 240(0xf0, float:3.36E-43)
            r1[r3] = r14
            r3 = 38
            r14 = 74
            r1[r3] = r14
            r3 = 39
            r14 = 218(0xda, float:3.05E-43)
            r1[r3] = r14
            r3 = 40
            r14 = 88
            r1[r3] = r14
            r3 = 41
            r14 = 201(0xc9, float:2.82E-43)
            r1[r3] = r14
            r3 = 42
            r14 = 41
            r1[r3] = r14
            r3 = 43
            r14 = 10
            r1[r3] = r14
            r3 = 44
            r14 = 177(0xb1, float:2.48E-43)
            r1[r3] = r14
            r3 = 45
            r14 = 160(0xa0, float:2.24E-43)
            r1[r3] = r14
            r3 = 46
            r14 = 107(0x6b, float:1.5E-43)
            r1[r3] = r14
            r3 = 47
            r14 = 133(0x85, float:1.86E-43)
            r1[r3] = r14
            r3 = 48
            r14 = 189(0xbd, float:2.65E-43)
            r1[r3] = r14
            r3 = 49
            r14 = 93
            r1[r3] = r14
            r3 = 50
            r14 = 16
            r1[r3] = r14
            r3 = 51
            r14 = 244(0xf4, float:3.42E-43)
            r1[r3] = r14
            r3 = 52
            r14 = 203(0xcb, float:2.84E-43)
            r1[r3] = r14
            r3 = 53
            r14 = 62
            r1[r3] = r14
            r3 = 54
            r1[r3] = r12
            r3 = 55
            r12 = 103(0x67, float:1.44E-43)
            r1[r3] = r12
            r3 = 56
            r12 = 228(0xe4, float:3.2E-43)
            r1[r3] = r12
            r3 = 57
            r12 = 39
            r1[r3] = r12
            r3 = 58
            r12 = 65
            r1[r3] = r12
            r3 = 59
            r12 = 139(0x8b, float:1.95E-43)
            r1[r3] = r12
            r3 = 60
            r12 = 167(0xa7, float:2.34E-43)
            r1[r3] = r12
            r3 = 61
            r12 = 125(0x7d, float:1.75E-43)
            r1[r3] = r12
            r3 = 62
            r12 = 149(0x95, float:2.09E-43)
            r1[r3] = r12
            r3 = 63
            r12 = 216(0xd8, float:3.03E-43)
            r1[r3] = r12
            r3 = 64
            r12 = 251(0xfb, float:3.52E-43)
            r1[r3] = r12
            r3 = 65
            r12 = 238(0xee, float:3.34E-43)
            r1[r3] = r12
            r3 = 66
            r12 = 124(0x7c, float:1.74E-43)
            r1[r3] = r12
            r3 = 67
            r12 = 102(0x66, float:1.43E-43)
            r1[r3] = r12
            r3 = 68
            r12 = 221(0xdd, float:3.1E-43)
            r1[r3] = r12
            r3 = 69
            r12 = 23
            r1[r3] = r12
            r3 = 70
            r12 = 71
            r1[r3] = r12
            r3 = 71
            r12 = 158(0x9e, float:2.21E-43)
            r1[r3] = r12
            r3 = 72
            r12 = 202(0xca, float:2.83E-43)
            r1[r3] = r12
            r3 = 73
            r12 = 45
            r1[r3] = r12
            r3 = 74
            r12 = 191(0xbf, float:2.68E-43)
            r1[r3] = r12
            r3 = 75
            r12 = 7
            r1[r3] = r12
            r3 = 76
            r12 = 173(0xad, float:2.42E-43)
            r1[r3] = r12
            r3 = 77
            r12 = 90
            r1[r3] = r12
            r3 = 78
            r12 = 131(0x83, float:1.84E-43)
            r1[r3] = r12
            r3 = 79
            r12 = 51
            r1[r3] = r12
            r3 = 80
            r12 = 99
            r1[r3] = r12
            r3 = 81
            r1[r3] = r6
            r3 = 82
            r6 = 170(0xaa, float:2.38E-43)
            r1[r3] = r6
            r3 = 83
            r6 = 113(0x71, float:1.58E-43)
            r1[r3] = r6
            r3 = 84
            r6 = 200(0xc8, float:2.8E-43)
            r1[r3] = r6
            r3 = 85
            r6 = 25
            r1[r3] = r6
            r3 = 86
            r6 = 73
            r1[r3] = r6
            r3 = 87
            r6 = 217(0xd9, float:3.04E-43)
            r1[r3] = r6
            r3 = 88
            r6 = 242(0xf2, float:3.39E-43)
            r1[r3] = r6
            r3 = 89
            r6 = 227(0xe3, float:3.18E-43)
            r1[r3] = r6
            r3 = 90
            r6 = 91
            r1[r3] = r6
            r3 = 91
            r6 = 136(0x88, float:1.9E-43)
            r1[r3] = r6
            r3 = 92
            r6 = 154(0x9a, float:2.16E-43)
            r1[r3] = r6
            r3 = 93
            r6 = 38
            r1[r3] = r6
            r3 = 94
            r6 = 50
            r1[r3] = r6
            r3 = 95
            r6 = 176(0xb0, float:2.47E-43)
            r1[r3] = r6
            r3 = 96
            r6 = 233(0xe9, float:3.27E-43)
            r1[r3] = r6
            r3 = 97
            r6 = 15
            r1[r3] = r6
            r3 = 98
            r6 = 213(0xd5, float:2.98E-43)
            r1[r3] = r6
            r3 = 99
            r6 = 128(0x80, float:1.794E-43)
            r1[r3] = r6
            r3 = 100
            r6 = 190(0xbe, float:2.66E-43)
            r1[r3] = r6
            r3 = 101(0x65, float:1.42E-43)
            r6 = 205(0xcd, float:2.87E-43)
            r1[r3] = r6
            r3 = 102(0x66, float:1.43E-43)
            r6 = 52
            r1[r3] = r6
            r3 = 103(0x67, float:1.44E-43)
            r6 = 72
            r1[r3] = r6
            r3 = 104(0x68, float:1.46E-43)
            r6 = 255(0xff, float:3.57E-43)
            r1[r3] = r6
            r3 = 105(0x69, float:1.47E-43)
            r6 = 122(0x7a, float:1.71E-43)
            r1[r3] = r6
            r3 = 106(0x6a, float:1.49E-43)
            r6 = 144(0x90, float:2.02E-43)
            r1[r3] = r6
            r3 = 107(0x6b, float:1.5E-43)
            r6 = 95
            r1[r3] = r6
            r3 = 108(0x6c, float:1.51E-43)
            r1[r3] = r13
            r3 = 109(0x6d, float:1.53E-43)
            r6 = 104(0x68, float:1.46E-43)
            r1[r3] = r6
            r3 = 110(0x6e, float:1.54E-43)
            r6 = 26
            r1[r3] = r6
            r3 = 111(0x6f, float:1.56E-43)
            r6 = 174(0xae, float:2.44E-43)
            r1[r3] = r6
            r3 = 112(0x70, float:1.57E-43)
            r6 = 180(0xb4, float:2.52E-43)
            r1[r3] = r6
            r3 = 113(0x71, float:1.58E-43)
            r6 = 84
            r1[r3] = r6
            r3 = 114(0x72, float:1.6E-43)
            r6 = 147(0x93, float:2.06E-43)
            r1[r3] = r6
            r3 = 115(0x73, float:1.61E-43)
            r6 = 34
            r1[r3] = r6
            r3 = 116(0x74, float:1.63E-43)
            r6 = 100
            r1[r3] = r6
            r3 = 117(0x75, float:1.64E-43)
            r6 = 241(0xf1, float:3.38E-43)
            r1[r3] = r6
            r3 = 118(0x76, float:1.65E-43)
            r6 = 115(0x73, float:1.61E-43)
            r1[r3] = r6
            r3 = 119(0x77, float:1.67E-43)
            r6 = 18
            r1[r3] = r6
            r3 = 120(0x78, float:1.68E-43)
            r6 = 64
            r1[r3] = r6
            r3 = 121(0x79, float:1.7E-43)
            r1[r3] = r4
            r3 = 122(0x7a, float:1.71E-43)
            r6 = 195(0xc3, float:2.73E-43)
            r1[r3] = r6
            r3 = 123(0x7b, float:1.72E-43)
            r6 = 236(0xec, float:3.31E-43)
            r1[r3] = r6
            r3 = 124(0x7c, float:1.74E-43)
            r6 = 219(0xdb, float:3.07E-43)
            r1[r3] = r6
            r3 = 125(0x7d, float:1.75E-43)
            r6 = 161(0xa1, float:2.26E-43)
            r1[r3] = r6
            r3 = 126(0x7e, float:1.77E-43)
            r6 = 141(0x8d, float:1.98E-43)
            r1[r3] = r6
            r3 = 127(0x7f, float:1.78E-43)
            r6 = 61
            r1[r3] = r6
            r3 = 128(0x80, float:1.794E-43)
            r6 = 151(0x97, float:2.12E-43)
            r1[r3] = r6
            r3 = 130(0x82, float:1.82E-43)
            r6 = 207(0xcf, float:2.9E-43)
            r1[r3] = r6
            r3 = 131(0x83, float:1.84E-43)
            r6 = 43
            r1[r3] = r6
            r3 = 132(0x84, float:1.85E-43)
            r6 = 118(0x76, float:1.65E-43)
            r1[r3] = r6
            r3 = 133(0x85, float:1.86E-43)
            r6 = 130(0x82, float:1.82E-43)
            r1[r3] = r6
            r3 = 134(0x86, float:1.88E-43)
            r6 = 214(0xd6, float:3.0E-43)
            r1[r3] = r6
            r3 = 27
            r1[r9] = r3
            r3 = 136(0x88, float:1.9E-43)
            r6 = 181(0xb5, float:2.54E-43)
            r1[r3] = r6
            r3 = 137(0x89, float:1.92E-43)
            r6 = 175(0xaf, float:2.45E-43)
            r1[r3] = r6
            r3 = 138(0x8a, float:1.93E-43)
            r6 = 106(0x6a, float:1.49E-43)
            r1[r3] = r6
            r3 = 139(0x8b, float:1.95E-43)
            r6 = 80
            r1[r3] = r6
            r3 = 140(0x8c, float:1.96E-43)
            r6 = 69
            r1[r3] = r6
            r3 = 141(0x8d, float:1.98E-43)
            r6 = 243(0xf3, float:3.4E-43)
            r1[r3] = r6
            r3 = 142(0x8e, float:1.99E-43)
            r6 = 48
            r1[r3] = r6
            r3 = 143(0x8f, float:2.0E-43)
            r6 = 239(0xef, float:3.35E-43)
            r1[r3] = r6
            r3 = 144(0x90, float:2.02E-43)
            r6 = 63
            r1[r3] = r6
            r3 = 145(0x91, float:2.03E-43)
            r6 = 85
            r1[r3] = r6
            r3 = 146(0x92, float:2.05E-43)
            r6 = 162(0xa2, float:2.27E-43)
            r1[r3] = r6
            r3 = 147(0x93, float:2.06E-43)
            r6 = 234(0xea, float:3.28E-43)
            r1[r3] = r6
            r3 = 148(0x94, float:2.07E-43)
            r6 = 101(0x65, float:1.42E-43)
            r1[r3] = r6
            r3 = 149(0x95, float:2.09E-43)
            r6 = 186(0xba, float:2.6E-43)
            r1[r3] = r6
            r3 = 150(0x96, float:2.1E-43)
            r6 = 47
            r1[r3] = r6
            r3 = 151(0x97, float:2.12E-43)
            r6 = 192(0xc0, float:2.69E-43)
            r1[r3] = r6
            r3 = 152(0x98, float:2.13E-43)
            r6 = 222(0xde, float:3.11E-43)
            r1[r3] = r6
            r3 = 153(0x99, float:2.14E-43)
            r6 = 28
            r1[r3] = r6
            r3 = 154(0x9a, float:2.16E-43)
            r6 = 253(0xfd, float:3.55E-43)
            r1[r3] = r6
            r3 = 155(0x9b, float:2.17E-43)
            r6 = 77
            r1[r3] = r6
            r3 = 156(0x9c, float:2.19E-43)
            r6 = 146(0x92, float:2.05E-43)
            r1[r3] = r6
            r3 = 157(0x9d, float:2.2E-43)
            r6 = 117(0x75, float:1.64E-43)
            r1[r3] = r6
            r3 = 158(0x9e, float:2.21E-43)
            r6 = 6
            r1[r3] = r6
            r3 = 159(0x9f, float:2.23E-43)
            r6 = 138(0x8a, float:1.93E-43)
            r1[r3] = r6
            r3 = 160(0xa0, float:2.24E-43)
            r6 = 178(0xb2, float:2.5E-43)
            r1[r3] = r6
            r3 = 161(0xa1, float:2.26E-43)
            r6 = 230(0xe6, float:3.22E-43)
            r1[r3] = r6
            r3 = 162(0xa2, float:2.27E-43)
            r6 = 14
            r1[r3] = r6
            r3 = 163(0xa3, float:2.28E-43)
            r1[r3] = r2
            r3 = 164(0xa4, float:2.3E-43)
            r6 = 98
            r1[r3] = r6
            r3 = 165(0xa5, float:2.31E-43)
            r6 = 212(0xd4, float:2.97E-43)
            r1[r3] = r6
            r3 = 166(0xa6, float:2.33E-43)
            r6 = 168(0xa8, float:2.35E-43)
            r1[r3] = r6
            r3 = 167(0xa7, float:2.34E-43)
            r6 = 150(0x96, float:2.1E-43)
            r1[r3] = r6
            r3 = 168(0xa8, float:2.35E-43)
            r6 = 249(0xf9, float:3.49E-43)
            r1[r3] = r6
            r3 = 169(0xa9, float:2.37E-43)
            r6 = 197(0xc5, float:2.76E-43)
            r1[r3] = r6
            r3 = 170(0xaa, float:2.38E-43)
            r6 = 37
            r1[r3] = r6
            r3 = 171(0xab, float:2.4E-43)
            r6 = 89
            r1[r3] = r6
            r3 = 172(0xac, float:2.41E-43)
            r6 = 132(0x84, float:1.85E-43)
            r1[r3] = r6
            r3 = 173(0xad, float:2.42E-43)
            r6 = 114(0x72, float:1.6E-43)
            r1[r3] = r6
            r3 = 174(0xae, float:2.44E-43)
            r6 = 57
            r1[r3] = r6
            r3 = 175(0xaf, float:2.45E-43)
            r6 = 76
            r1[r3] = r6
            r3 = 176(0xb0, float:2.47E-43)
            r6 = 94
            r1[r3] = r6
            r3 = 177(0xb1, float:2.48E-43)
            r6 = 120(0x78, float:1.68E-43)
            r1[r3] = r6
            r3 = 178(0xb2, float:2.5E-43)
            r6 = 56
            r1[r3] = r6
            r3 = 179(0xb3, float:2.51E-43)
            r6 = 140(0x8c, float:1.96E-43)
            r1[r3] = r6
            r3 = 180(0xb4, float:2.52E-43)
            r6 = 209(0xd1, float:2.93E-43)
            r1[r3] = r6
            r3 = 181(0xb5, float:2.54E-43)
            r6 = 165(0xa5, float:2.31E-43)
            r1[r3] = r6
            r3 = 182(0xb6, float:2.55E-43)
            r6 = 226(0xe2, float:3.17E-43)
            r1[r3] = r6
            r3 = 183(0xb7, float:2.56E-43)
            r6 = 97
            r1[r3] = r6
            r3 = 179(0xb3, float:2.51E-43)
            r1[r11] = r3
            r3 = 185(0xb9, float:2.59E-43)
            r6 = 33
            r1[r3] = r6
            r3 = 186(0xba, float:2.6E-43)
            r6 = 156(0x9c, float:2.19E-43)
            r1[r3] = r6
            r3 = 187(0xbb, float:2.62E-43)
            r6 = 30
            r1[r3] = r6
            r3 = 188(0xbc, float:2.63E-43)
            r6 = 67
            r1[r3] = r6
            r3 = 189(0xbd, float:2.65E-43)
            r6 = 199(0xc7, float:2.79E-43)
            r1[r3] = r6
            r3 = 190(0xbe, float:2.66E-43)
            r6 = 252(0xfc, float:3.53E-43)
            r1[r3] = r6
            r3 = 191(0xbf, float:2.68E-43)
            r1[r3] = r10
            r3 = 192(0xc0, float:2.69E-43)
            r6 = 81
            r1[r3] = r6
            r3 = 193(0xc1, float:2.7E-43)
            r6 = 153(0x99, float:2.14E-43)
            r1[r3] = r6
            r3 = 194(0xc2, float:2.72E-43)
            r6 = 109(0x6d, float:1.53E-43)
            r1[r3] = r6
            r3 = 195(0xc3, float:2.73E-43)
            r6 = 13
            r1[r3] = r6
            r3 = 196(0xc4, float:2.75E-43)
            r6 = 250(0xfa, float:3.5E-43)
            r1[r3] = r6
            r3 = 197(0xc5, float:2.76E-43)
            r6 = 223(0xdf, float:3.12E-43)
            r1[r3] = r6
            r3 = 126(0x7e, float:1.77E-43)
            r1[r5] = r3
            r3 = 199(0xc7, float:2.79E-43)
            r5 = 36
            r1[r3] = r5
            r3 = 200(0xc8, float:2.8E-43)
            r5 = 59
            r1[r3] = r5
            r3 = 201(0xc9, float:2.82E-43)
            r5 = 171(0xab, float:2.4E-43)
            r1[r3] = r5
            r3 = 202(0xca, float:2.83E-43)
            r5 = 206(0xce, float:2.89E-43)
            r1[r3] = r5
            r3 = 203(0xcb, float:2.84E-43)
            r5 = 17
            r1[r3] = r5
            r3 = 204(0xcc, float:2.86E-43)
            r5 = 143(0x8f, float:2.0E-43)
            r1[r3] = r5
            r3 = 205(0xcd, float:2.87E-43)
            r5 = 78
            r1[r3] = r5
            r3 = 206(0xce, float:2.89E-43)
            r5 = 183(0xb7, float:2.56E-43)
            r1[r3] = r5
            r3 = 207(0xcf, float:2.9E-43)
            r5 = 235(0xeb, float:3.3E-43)
            r1[r3] = r5
            r3 = 208(0xd0, float:2.91E-43)
            r5 = 60
            r1[r3] = r5
            r3 = 209(0xd1, float:2.93E-43)
            r5 = 129(0x81, float:1.81E-43)
            r1[r3] = r5
            r3 = 210(0xd2, float:2.94E-43)
            r5 = 148(0x94, float:2.07E-43)
            r1[r3] = r5
            r3 = 211(0xd3, float:2.96E-43)
            r5 = 247(0xf7, float:3.46E-43)
            r1[r3] = r5
            r3 = 212(0xd4, float:2.97E-43)
            r5 = 185(0xb9, float:2.59E-43)
            r1[r3] = r5
            r3 = 213(0xd5, float:2.98E-43)
            r5 = 19
            r1[r3] = r5
            r3 = 214(0xd6, float:3.0E-43)
            r5 = 44
            r1[r3] = r5
            r3 = 215(0xd7, float:3.01E-43)
            r5 = 211(0xd3, float:2.96E-43)
            r1[r3] = r5
            r3 = 216(0xd8, float:3.03E-43)
            r5 = 231(0xe7, float:3.24E-43)
            r1[r3] = r5
            r3 = 217(0xd9, float:3.04E-43)
            r5 = 110(0x6e, float:1.54E-43)
            r1[r3] = r5
            r3 = 218(0xda, float:3.05E-43)
            r5 = 196(0xc4, float:2.75E-43)
            r1[r3] = r5
            r3 = 219(0xdb, float:3.07E-43)
            r1[r3] = r8
            r3 = 220(0xdc, float:3.08E-43)
            r5 = 86
            r1[r3] = r5
            r3 = 221(0xdd, float:3.1E-43)
            r5 = 68
            r1[r3] = r5
            r3 = 222(0xde, float:3.11E-43)
            r5 = 127(0x7f, float:1.78E-43)
            r1[r3] = r5
            r3 = 223(0xdf, float:3.12E-43)
            r5 = 169(0xa9, float:2.37E-43)
            r1[r3] = r5
            r3 = 224(0xe0, float:3.14E-43)
            r5 = 42
            r1[r3] = r5
            r3 = 225(0xe1, float:3.15E-43)
            r5 = 187(0xbb, float:2.62E-43)
            r1[r3] = r5
            r3 = 226(0xe2, float:3.17E-43)
            r5 = 193(0xc1, float:2.7E-43)
            r1[r3] = r5
            r3 = 227(0xe3, float:3.18E-43)
            r5 = 83
            r1[r3] = r5
            r3 = 228(0xe4, float:3.2E-43)
            r5 = 220(0xdc, float:3.08E-43)
            r1[r3] = r5
            r3 = 229(0xe5, float:3.21E-43)
            r5 = 11
            r1[r3] = r5
            r3 = 230(0xe6, float:3.22E-43)
            r5 = 157(0x9d, float:2.2E-43)
            r1[r3] = r5
            r3 = 231(0xe7, float:3.24E-43)
            r5 = 108(0x6c, float:1.51E-43)
            r1[r3] = r5
            r3 = 49
            r1[r7] = r3
            r3 = 233(0xe9, float:3.27E-43)
            r5 = 116(0x74, float:1.63E-43)
            r1[r3] = r5
            r3 = 234(0xea, float:3.28E-43)
            r5 = 246(0xf6, float:3.45E-43)
            r1[r3] = r5
            r3 = 235(0xeb, float:3.3E-43)
            r5 = 70
            r1[r3] = r5
            r3 = 236(0xec, float:3.31E-43)
            r5 = 172(0xac, float:2.41E-43)
            r1[r3] = r5
            r3 = 237(0xed, float:3.32E-43)
            r5 = 137(0x89, float:1.92E-43)
            r1[r3] = r5
            r3 = 238(0xee, float:3.34E-43)
            r5 = 20
            r1[r3] = r5
            r3 = 239(0xef, float:3.35E-43)
            r5 = 225(0xe1, float:3.15E-43)
            r1[r3] = r5
            r3 = 240(0xf0, float:3.36E-43)
            r5 = 22
            r1[r3] = r5
            r3 = 241(0xf1, float:3.38E-43)
            r5 = 58
            r1[r3] = r5
            r3 = 242(0xf2, float:3.39E-43)
            r5 = 105(0x69, float:1.47E-43)
            r1[r3] = r5
            r3 = 243(0xf3, float:3.4E-43)
            r5 = 9
            r1[r3] = r5
            r3 = 244(0xf4, float:3.42E-43)
            r5 = 112(0x70, float:1.57E-43)
            r1[r3] = r5
            r3 = 245(0xf5, float:3.43E-43)
            r5 = 182(0xb6, float:2.55E-43)
            r1[r3] = r5
            r3 = 246(0xf6, float:3.45E-43)
            r5 = 208(0xd0, float:2.91E-43)
            r1[r3] = r5
            r3 = 247(0xf7, float:3.46E-43)
            r5 = 237(0xed, float:3.32E-43)
            r1[r3] = r5
            r3 = 248(0xf8, float:3.48E-43)
            r5 = 204(0xcc, float:2.86E-43)
            r1[r3] = r5
            r3 = 249(0xf9, float:3.49E-43)
            r5 = 66
            r1[r3] = r5
            r3 = 250(0xfa, float:3.5E-43)
            r5 = 152(0x98, float:2.13E-43)
            r1[r3] = r5
            r3 = 251(0xfb, float:3.52E-43)
            r5 = 164(0xa4, float:2.3E-43)
            r1[r3] = r5
            r3 = 252(0xfc, float:3.53E-43)
            r5 = 40
            r1[r3] = r5
            r3 = 253(0xfd, float:3.55E-43)
            r5 = 92
            r1[r3] = r5
            r3 = 254(0xfe, float:3.56E-43)
            r5 = 248(0xf8, float:3.48E-43)
            r1[r3] = r5
            r3 = 255(0xff, float:3.57E-43)
            r5 = 134(0x86, float:1.88E-43)
            r1[r3] = r5
            SBOX = r1
            long[] r1 = new long[r0]
            f6031C0 = r1
            long[] r1 = new long[r0]
            f6032C1 = r1
            long[] r1 = new long[r0]
            f6033C2 = r1
            long[] r1 = new long[r0]
            f6034C3 = r1
            long[] r1 = new long[r0]
            f6035C4 = r1
            long[] r1 = new long[r0]
            f6036C5 = r1
            long[] r1 = new long[r0]
            f6037C6 = r1
            long[] r0 = new long[r0]
            f6038C7 = r0
            short[] r0 = new short[r13]
            EIGHT = r0
            short[] r0 = EIGHT
            r0[r2] = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.crypto.digests.WhirlpoolDigest.<clinit>():void");
    }

    public WhirlpoolDigest() {
        for (int i = 0; i < 256; i++) {
            int i2 = SBOX[i];
            int maskWithReductionPolynomial = maskWithReductionPolynomial(i2 << 1);
            int maskWithReductionPolynomial2 = maskWithReductionPolynomial(maskWithReductionPolynomial << 1);
            int i3 = maskWithReductionPolynomial2 ^ i2;
            int maskWithReductionPolynomial3 = maskWithReductionPolynomial(maskWithReductionPolynomial2 << 1);
            int i4 = maskWithReductionPolynomial3 ^ i2;
            int i5 = i2;
            f6031C0[i] = packIntoLong(i2, i5, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4);
            int i6 = i2;
            f6032C1[i] = packIntoLong(i4, i5, i6, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial);
            int i7 = i2;
            f6033C2[i] = packIntoLong(maskWithReductionPolynomial, i4, i6, i7, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3);
            int i8 = i2;
            f6034C3[i] = packIntoLong(i3, maskWithReductionPolynomial, i4, i7, i8, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3);
            int i9 = i2;
            f6035C4[i] = packIntoLong(maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i8, i9, maskWithReductionPolynomial2, i2);
            int i10 = i2;
            f6036C5[i] = packIntoLong(i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i9, i10, maskWithReductionPolynomial2);
            int i11 = i2;
            f6037C6[i] = packIntoLong(maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i10, i11);
            f6038C7[i] = packIntoLong(i2, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i11);
        }
        this._rc[0] = 0;
        for (int i12 = 1; i12 <= 10; i12++) {
            int i13 = (i12 - 1) * 8;
            this._rc[i12] = (((((((f6031C0[i13] & -72057594037927936L) ^ (f6032C1[i13 + 1] & 71776119061217280L)) ^ (f6033C2[i13 + 2] & 280375465082880L)) ^ (f6034C3[i13 + 3] & 1095216660480L)) ^ (f6035C4[i13 + 4] & 4278190080L)) ^ (f6036C5[i13 + 5] & 16711680)) ^ (f6037C6[i13 + 6] & 65280)) ^ (f6038C7[i13 + 7] & 255);
        }
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        long[] jArr = whirlpoolDigest._rc;
        long[] jArr2 = this._rc;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = whirlpoolDigest._buffer;
        byte[] bArr2 = this._buffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this._bufferPos = whirlpoolDigest._bufferPos;
        short[] sArr = whirlpoolDigest._bitCount;
        short[] sArr2 = this._bitCount;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = whirlpoolDigest._hash;
        long[] jArr4 = this._hash;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = whirlpoolDigest.f6039_K;
        long[] jArr6 = this.f6039_K;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = whirlpoolDigest.f6040_L;
        long[] jArr8 = this.f6040_L;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = whirlpoolDigest._block;
        long[] jArr10 = this._block;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = whirlpoolDigest._state;
        long[] jArr12 = this._state;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        for (int i2 = 0; i2 < 8; i2++) {
            convertLongToByteArray(this._hash[i2], bArr, (i2 * 8) + i);
        }
        reset();
        return getDigestSize();
    }

    public void reset() {
        this._bufferPos = 0;
        Arrays.fill(this._bitCount, 0);
        Arrays.fill(this._buffer, (byte) 0);
        Arrays.fill(this._hash, 0);
        Arrays.fill(this.f6039_K, 0);
        Arrays.fill(this.f6040_L, 0);
        Arrays.fill(this._block, 0);
        Arrays.fill(this._state, 0);
    }

    private void processFilledBuffer(byte[] bArr, int i) {
        for (int i2 = 0; i2 < this._state.length; i2++) {
            this._block[i2] = bytesToLongFromBuffer(this._buffer, i2 * 8);
        }
        processBlock();
        this._bufferPos = 0;
        Arrays.fill(this._buffer, (byte) 0);
    }

    private long bytesToLongFromBuffer(byte[] bArr, int i) {
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i + 0]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    private void convertLongToByteArray(long j, byte[] bArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i + i2] = (byte) ((int) ((j >> (56 - (i2 * 8))) & 255));
        }
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        int i;
        int i2 = 0;
        while (true) {
            i = 8;
            if (i2 >= 8) {
                break;
            }
            long[] jArr = this._state;
            long j = this._block[i2];
            long[] jArr2 = this.f6039_K;
            long j2 = this._hash[i2];
            jArr2[i2] = j2;
            jArr[i2] = j ^ j2;
            i2++;
        }
        int i3 = 1;
        while (i3 <= 10) {
            int i4 = 0;
            while (i4 < i) {
                int i5 = i3;
                long[] jArr3 = this.f6040_L;
                jArr3[i4] = 0;
                long j3 = jArr3[i4];
                long[] jArr4 = f6031C0;
                long[] jArr5 = this.f6039_K;
                jArr3[i4] = j3 ^ jArr4[((int) (jArr5[(i4 + 0) & 7] >>> 56)) & 255];
                jArr3[i4] = jArr3[i4] ^ f6032C1[((int) (jArr5[(i4 - 1) & 7] >>> 48)) & 255];
                jArr3[i4] = jArr3[i4] ^ f6033C2[((int) (jArr5[(i4 - 2) & 7] >>> 40)) & 255];
                jArr3[i4] = jArr3[i4] ^ f6034C3[((int) (jArr5[(i4 - 3) & 7] >>> 32)) & 255];
                jArr3[i4] = jArr3[i4] ^ f6035C4[((int) (jArr5[(i4 - 4) & 7] >>> 24)) & 255];
                jArr3[i4] = jArr3[i4] ^ f6036C5[((int) (jArr5[(i4 - 5) & 7] >>> 16)) & 255];
                jArr3[i4] = jArr3[i4] ^ f6037C6[((int) (jArr5[(i4 - 6) & 7] >>> 8)) & 255];
                jArr3[i4] = jArr3[i4] ^ f6038C7[((int) jArr5[(i4 - 7) & 7]) & 255];
                i4++;
                i3 = i5;
                i = 8;
            }
            long[] jArr6 = this.f6040_L;
            long[] jArr7 = this.f6039_K;
            System.arraycopy(jArr6, 0, jArr7, 0, jArr7.length);
            long[] jArr8 = this.f6039_K;
            jArr8[0] = jArr8[0] ^ this._rc[i3];
            int i6 = 0;
            while (i6 < i) {
                long[] jArr9 = this.f6040_L;
                jArr9[i6] = this.f6039_K[i6];
                long j4 = jArr9[i6];
                long[] jArr10 = f6031C0;
                long[] jArr11 = this._state;
                jArr9[i6] = jArr10[((int) (jArr11[(i6 + 0) & 7] >>> 56)) & 255] ^ j4;
                jArr9[i6] = jArr9[i6] ^ f6032C1[((int) (jArr11[(i6 - 1) & 7] >>> 48)) & 255];
                jArr9[i6] = jArr9[i6] ^ f6033C2[((int) (jArr11[(i6 - 2) & 7] >>> 40)) & 255];
                jArr9[i6] = jArr9[i6] ^ f6034C3[((int) (jArr11[(i6 - 3) & 7] >>> 32)) & 255];
                jArr9[i6] = jArr9[i6] ^ f6035C4[((int) (jArr11[(i6 - 4) & 7] >>> 24)) & 255];
                jArr9[i6] = jArr9[i6] ^ f6036C5[((int) (jArr11[(i6 - 5) & 7] >>> 16)) & 255];
                jArr9[i6] = jArr9[i6] ^ f6037C6[((int) (jArr11[(i6 - 6) & 7] >>> 8)) & 255];
                jArr9[i6] = jArr9[i6] ^ f6038C7[((int) jArr11[(i6 - 7) & 7]) & 255];
                i6++;
                i3 = i3;
                i = 8;
            }
            long[] jArr12 = this.f6040_L;
            long[] jArr13 = this._state;
            System.arraycopy(jArr12, 0, jArr13, 0, jArr13.length);
            i3++;
        }
        for (int i7 = 0; i7 < i; i7++) {
            long[] jArr14 = this._hash;
            jArr14[i7] = jArr14[i7] ^ (this._state[i7] ^ this._block[i7]);
        }
    }

    public void update(byte b) {
        byte[] bArr = this._buffer;
        int i = this._bufferPos;
        bArr[i] = b;
        this._bufferPos = i + 1;
        if (this._bufferPos == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        increment();
    }

    private void increment() {
        int i = 0;
        for (int length = this._bitCount.length - 1; length >= 0; length--) {
            short[] sArr = this._bitCount;
            int i2 = (sArr[length] & 255) + EIGHT[length] + i;
            i = i2 >>> 8;
            sArr[length] = (short) (i2 & 255);
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }

    private void finish() {
        byte[] copyBitLength = copyBitLength();
        byte[] bArr = this._buffer;
        int i = this._bufferPos;
        this._bufferPos = i + 1;
        bArr[i] = (byte) (bArr[i] | 128);
        if (this._bufferPos == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        if (this._bufferPos > 32) {
            while (this._bufferPos != 0) {
                update((byte) 0);
            }
        }
        while (this._bufferPos <= 32) {
            update((byte) 0);
        }
        System.arraycopy(copyBitLength, 0, this._buffer, 32, copyBitLength.length);
        processFilledBuffer(this._buffer, 0);
    }

    private byte[] copyBitLength() {
        byte[] bArr = new byte[32];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (this._bitCount[i] & 255);
        }
        return bArr;
    }
}
