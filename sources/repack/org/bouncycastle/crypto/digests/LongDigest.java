package repack.org.bouncycastle.crypto.digests;

import repack.org.bouncycastle.crypto.ExtendedDigest;
import repack.org.bouncycastle.crypto.util.Pack;

public abstract class LongDigest implements ExtendedDigest {
    private static final int BYTE_LENGTH = 128;

    /* renamed from: K */
    static final long[] f5938K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* renamed from: H1 */
    protected long f5939H1;

    /* renamed from: H2 */
    protected long f5940H2;

    /* renamed from: H3 */
    protected long f5941H3;

    /* renamed from: H4 */
    protected long f5942H4;

    /* renamed from: H5 */
    protected long f5943H5;

    /* renamed from: H6 */
    protected long f5944H6;

    /* renamed from: H7 */
    protected long f5945H7;

    /* renamed from: H8 */
    protected long f5946H8;

    /* renamed from: W */
    private long[] f5947W;
    private long byteCount1;
    private long byteCount2;
    private int wOff;
    private byte[] xBuf;
    private int xBufOff;

    /* renamed from: Ch */
    private long m4764Ch(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    private long Maj(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    private long Sigma0(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    private long Sigma1(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    private long Sum0(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    private long Sum1(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    public int getByteLength() {
        return 128;
    }

    protected LongDigest() {
        this.f5947W = new long[80];
        this.xBuf = new byte[8];
        this.xBufOff = 0;
        reset();
    }

    protected LongDigest(LongDigest longDigest) {
        this.f5947W = new long[80];
        this.xBuf = new byte[longDigest.xBuf.length];
        byte[] bArr = longDigest.xBuf;
        System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
        this.xBufOff = longDigest.xBufOff;
        this.byteCount1 = longDigest.byteCount1;
        this.byteCount2 = longDigest.byteCount2;
        this.f5939H1 = longDigest.f5939H1;
        this.f5940H2 = longDigest.f5940H2;
        this.f5941H3 = longDigest.f5941H3;
        this.f5942H4 = longDigest.f5942H4;
        this.f5943H5 = longDigest.f5943H5;
        this.f5944H6 = longDigest.f5944H6;
        this.f5945H7 = longDigest.f5945H7;
        this.f5946H8 = longDigest.f5946H8;
        long[] jArr = longDigest.f5947W;
        System.arraycopy(jArr, 0, this.f5947W, 0, jArr.length);
        this.wOff = longDigest.wOff;
    }

    public void update(byte b) {
        byte[] bArr = this.xBuf;
        int i = this.xBufOff;
        this.xBufOff = i + 1;
        bArr[i] = b;
        if (this.xBufOff == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount1++;
    }

    public void update(byte[] bArr, int i, int i2) {
        while (this.xBufOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.xBuf.length) {
            processWord(bArr, i);
            byte[] bArr2 = this.xBuf;
            i += bArr2.length;
            i2 -= bArr2.length;
            this.byteCount1 += (long) bArr2.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }

    public void finish() {
        adjustByteCounts();
        long j = this.byteCount1 << 3;
        long j2 = this.byteCount2;
        update(Byte.MIN_VALUE);
        while (this.xBufOff != 0) {
            update((byte) 0);
        }
        processLength(j, j2);
        processBlock();
    }

    public void reset() {
        this.byteCount1 = 0;
        this.byteCount2 = 0;
        int i = 0;
        this.xBufOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.wOff = 0;
        while (true) {
            long[] jArr = this.f5947W;
            if (i != jArr.length) {
                jArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        this.f5947W[this.wOff] = Pack.bigEndianToLong(bArr, i);
        int i2 = this.wOff + 1;
        this.wOff = i2;
        if (i2 == 16) {
            processBlock();
        }
    }

    private void adjustByteCounts() {
        long j = this.byteCount1;
        if (j > 2305843009213693951L) {
            this.byteCount2 += j >>> 61;
            this.byteCount1 = j & 2305843009213693951L;
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j, long j2) {
        if (this.wOff > 14) {
            processBlock();
        }
        long[] jArr = this.f5947W;
        jArr[14] = j2;
        jArr[15] = j;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        adjustByteCounts();
        for (int i = 16; i <= 79; i++) {
            long[] jArr = this.f5947W;
            long Sigma1 = Sigma1(jArr[i - 2]);
            long[] jArr2 = this.f5947W;
            jArr[i] = Sigma1 + jArr2[i - 7] + Sigma0(jArr2[i - 15]) + this.f5947W[i - 16];
        }
        long j = this.f5939H1;
        long j2 = this.f5940H2;
        long j3 = this.f5941H3;
        long j4 = this.f5942H4;
        long j5 = this.f5943H5;
        long j6 = this.f5944H6;
        int i2 = 0;
        long j7 = j2;
        long j8 = j3;
        long j9 = j4;
        long j10 = j;
        long j11 = this.f5945H7;
        long j12 = j6;
        int i3 = 0;
        int i4 = 0;
        long j13 = j5;
        long j14 = this.f5946H8;
        while (i3 < 10) {
            int i5 = i4 + 1;
            long Sum1 = j14 + Sum1(j13) + m4764Ch(j13, j12, j11) + f5938K[i4] + this.f5947W[i4];
            long j15 = j10;
            long j16 = j15;
            long Sum0 = Sum1 + Sum0(j15) + Maj(j15, j7, j8);
            long j17 = j9 + Sum1;
            long j18 = j17;
            int i6 = i5 + 1;
            long Sum12 = j11 + Sum1(j17) + m4764Ch(j17, j13, j12) + f5938K[i5] + this.f5947W[i5];
            long j19 = Sum0;
            long j20 = j8 + Sum12;
            long Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, j16, j7);
            long Sum13 = Sum1(j20);
            long j21 = j20;
            long j22 = Sum02;
            int i7 = i6 + 1;
            long Ch = j12 + Sum13 + m4764Ch(j20, j18, j13) + f5938K[i6] + this.f5947W[i6];
            long j23 = j7 + Ch;
            int i8 = i3;
            long j24 = j23;
            long Sum03 = Ch + Sum0(j22) + Maj(j22, j19, j16);
            long Sum14 = Sum1(j24);
            long j25 = j24;
            long j26 = Sum03;
            int i9 = i7 + 1;
            long Ch2 = j13 + Sum14 + m4764Ch(j24, j21, j18) + f5938K[i7] + this.f5947W[i7];
            long j27 = j22;
            long j28 = j22;
            long j29 = j16 + Ch2;
            long Sum04 = Ch2 + Sum0(j26) + Maj(j26, j27, j19);
            int i10 = i9 + 1;
            long Sum15 = j18 + Sum1(j29) + m4764Ch(j29, j25, j21) + f5938K[i9] + this.f5947W[i9];
            long j30 = j26;
            long j31 = j26;
            long j32 = j19 + Sum15;
            long Sum05 = Sum15 + Sum0(Sum04) + Maj(Sum04, j30, j28);
            long j33 = j29;
            long j34 = j29;
            long j35 = Sum05;
            int i11 = i10 + 1;
            long Sum16 = j21 + Sum1(j32) + m4764Ch(j32, j33, j25) + f5938K[i10] + this.f5947W[i10];
            long j36 = j28 + Sum16;
            long j37 = j32;
            long j38 = j32;
            long Sum06 = Sum16 + Sum0(j35) + Maj(j35, Sum04, j31);
            int i12 = i11 + 1;
            long Sum17 = j25 + Sum1(j36) + m4764Ch(j36, j37, j34) + f5938K[i11] + this.f5947W[i11];
            long j39 = j31 + Sum17;
            long j40 = j35;
            long j41 = j35;
            long j42 = j39;
            long Sum07 = Sum17 + Sum0(Sum06) + Maj(Sum06, j40, Sum04);
            long Sum18 = Sum1(j42);
            long j43 = j42;
            long j44 = Sum07;
            long Ch3 = j34 + Sum18 + m4764Ch(j42, j36, j38) + f5938K[i12] + this.f5947W[i12];
            long j45 = Sum04 + Ch3;
            j10 = Ch3 + Sum0(j44) + Maj(j44, Sum06, j41);
            j8 = Sum06;
            j12 = j43;
            i4 = i12 + 1;
            i3 = i8 + 1;
            j7 = j44;
            j11 = j36;
            i2 = 0;
            j13 = j45;
            j14 = j38;
            j9 = j41;
        }
        this.f5939H1 += j10;
        this.f5940H2 += j7;
        this.f5941H3 += j8;
        this.f5942H4 += j9;
        this.f5943H5 += j13;
        this.f5944H6 += j12;
        this.f5945H7 += j11;
        this.f5946H8 += j14;
        this.wOff = i2;
        while (i2 < 16) {
            this.f5947W[i2] = 0;
            i2++;
        }
    }
}
