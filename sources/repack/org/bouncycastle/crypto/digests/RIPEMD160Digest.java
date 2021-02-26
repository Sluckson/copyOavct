package repack.org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;

public class RIPEMD160Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 20;

    /* renamed from: H0 */
    private int f5967H0;

    /* renamed from: H1 */
    private int f5968H1;

    /* renamed from: H2 */
    private int f5969H2;

    /* renamed from: H3 */
    private int f5970H3;

    /* renamed from: H4 */
    private int f5971H4;

    /* renamed from: X */
    private int[] f5972X = new int[16];
    private int xOff;

    /* renamed from: RL */
    private int m4781RL(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: f1 */
    private int m4782f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m4783f2(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: f3 */
    private int m4784f3(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: f4 */
    private int m4785f4(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: f5 */
    private int m4786f5(int i, int i2, int i3) {
        return i ^ (i2 | (~i3));
    }

    public String getAlgorithmName() {
        return "RIPEMD160";
    }

    public int getDigestSize() {
        return 20;
    }

    public RIPEMD160Digest() {
        reset();
    }

    public RIPEMD160Digest(RIPEMD160Digest rIPEMD160Digest) {
        super(rIPEMD160Digest);
        this.f5967H0 = rIPEMD160Digest.f5967H0;
        this.f5968H1 = rIPEMD160Digest.f5968H1;
        this.f5969H2 = rIPEMD160Digest.f5969H2;
        this.f5970H3 = rIPEMD160Digest.f5970H3;
        this.f5971H4 = rIPEMD160Digest.f5971H4;
        int[] iArr = rIPEMD160Digest.f5972X;
        System.arraycopy(iArr, 0, this.f5972X, 0, iArr.length);
        this.xOff = rIPEMD160Digest.xOff;
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f5972X;
        int i2 = this.xOff;
        this.xOff = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        if (this.xOff == 16) {
            processBlock();
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f5972X;
        iArr[14] = (int) (-1 & j);
        iArr[15] = (int) (j >>> 32);
    }

    private void unpackWord(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.f5967H0, bArr, i);
        unpackWord(this.f5968H1, bArr, i + 4);
        unpackWord(this.f5969H2, bArr, i + 8);
        unpackWord(this.f5970H3, bArr, i + 12);
        unpackWord(this.f5971H4, bArr, i + 16);
        reset();
        return 20;
    }

    public void reset() {
        super.reset();
        this.f5967H0 = 1732584193;
        this.f5968H1 = -271733879;
        this.f5969H2 = -1732584194;
        this.f5970H3 = 271733878;
        this.f5971H4 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5972X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        int i = this.f5967H0;
        int i2 = this.f5968H1;
        int i3 = this.f5969H2;
        int i4 = this.f5970H3;
        int i5 = this.f5971H4;
        int RL = m4781RL(m4782f1(i2, i3, i4) + i + this.f5972X[0], 11) + i5;
        int RL2 = m4781RL(i3, 10);
        int RL3 = m4781RL(m4782f1(RL, i2, RL2) + i5 + this.f5972X[1], 14) + i4;
        int RL4 = m4781RL(i2, 10);
        int RL5 = m4781RL(m4782f1(RL3, RL, RL4) + i4 + this.f5972X[2], 15) + RL2;
        int RL6 = m4781RL(RL, 10);
        int RL7 = m4781RL(RL2 + m4782f1(RL5, RL3, RL6) + this.f5972X[3], 12) + RL4;
        int RL8 = m4781RL(RL3, 10);
        int RL9 = m4781RL(RL4 + m4782f1(RL7, RL5, RL8) + this.f5972X[4], 5) + RL6;
        int RL10 = m4781RL(RL5, 10);
        int RL11 = m4781RL(RL6 + m4782f1(RL9, RL7, RL10) + this.f5972X[5], 8) + RL8;
        int RL12 = m4781RL(RL7, 10);
        int RL13 = m4781RL(RL8 + m4782f1(RL11, RL9, RL12) + this.f5972X[6], 7) + RL10;
        int RL14 = m4781RL(RL9, 10);
        int RL15 = m4781RL(RL10 + m4782f1(RL13, RL11, RL14) + this.f5972X[7], 9) + RL12;
        int RL16 = m4781RL(RL11, 10);
        int RL17 = m4781RL(RL12 + m4782f1(RL15, RL13, RL16) + this.f5972X[8], 11) + RL14;
        int RL18 = m4781RL(RL13, 10);
        int RL19 = m4781RL(RL14 + m4782f1(RL17, RL15, RL18) + this.f5972X[9], 13) + RL16;
        int RL20 = m4781RL(RL15, 10);
        int RL21 = m4781RL(RL16 + m4782f1(RL19, RL17, RL20) + this.f5972X[10], 14) + RL18;
        int RL22 = m4781RL(RL17, 10);
        int RL23 = m4781RL(RL18 + m4782f1(RL21, RL19, RL22) + this.f5972X[11], 15) + RL20;
        int RL24 = m4781RL(RL19, 10);
        int RL25 = m4781RL(RL20 + m4782f1(RL23, RL21, RL24) + this.f5972X[12], 6) + RL22;
        int RL26 = m4781RL(RL21, 10);
        int RL27 = m4781RL(RL22 + m4782f1(RL25, RL23, RL26) + this.f5972X[13], 7) + RL24;
        int RL28 = m4781RL(RL23, 10);
        int RL29 = m4781RL(RL24 + m4782f1(RL27, RL25, RL28) + this.f5972X[14], 9) + RL26;
        int RL30 = m4781RL(RL25, 10);
        int RL31 = m4781RL(RL26 + m4782f1(RL29, RL27, RL30) + this.f5972X[15], 8) + RL28;
        int RL32 = m4781RL(RL27, 10);
        int RL33 = m4781RL(i + m4786f5(i2, i3, i4) + this.f5972X[5] + 1352829926, 8) + i5;
        int RL34 = m4781RL(i3, 10);
        int RL35 = m4781RL(i5 + m4786f5(RL33, i2, RL34) + this.f5972X[14] + 1352829926, 9) + i4;
        int RL36 = m4781RL(i2, 10);
        int RL37 = m4781RL(i4 + m4786f5(RL35, RL33, RL36) + this.f5972X[7] + 1352829926, 9) + RL34;
        int RL38 = m4781RL(RL33, 10);
        int RL39 = m4781RL(RL34 + m4786f5(RL37, RL35, RL38) + this.f5972X[0] + 1352829926, 11) + RL36;
        int RL40 = m4781RL(RL35, 10);
        int RL41 = m4781RL(RL36 + m4786f5(RL39, RL37, RL40) + this.f5972X[9] + 1352829926, 13) + RL38;
        int RL42 = m4781RL(RL37, 10);
        int RL43 = m4781RL(RL38 + m4786f5(RL41, RL39, RL42) + this.f5972X[2] + 1352829926, 15) + RL40;
        int RL44 = m4781RL(RL39, 10);
        int RL45 = m4781RL(RL40 + m4786f5(RL43, RL41, RL44) + this.f5972X[11] + 1352829926, 15) + RL42;
        int RL46 = m4781RL(RL41, 10);
        int RL47 = m4781RL(RL42 + m4786f5(RL45, RL43, RL46) + this.f5972X[4] + 1352829926, 5) + RL44;
        int RL48 = m4781RL(RL43, 10);
        int RL49 = m4781RL(RL44 + m4786f5(RL47, RL45, RL48) + this.f5972X[13] + 1352829926, 7) + RL46;
        int RL50 = m4781RL(RL45, 10);
        int RL51 = m4781RL(RL46 + m4786f5(RL49, RL47, RL50) + this.f5972X[6] + 1352829926, 7) + RL48;
        int RL52 = m4781RL(RL47, 10);
        int RL53 = m4781RL(RL48 + m4786f5(RL51, RL49, RL52) + this.f5972X[15] + 1352829926, 8) + RL50;
        int RL54 = m4781RL(RL49, 10);
        int RL55 = m4781RL(RL50 + m4786f5(RL53, RL51, RL54) + this.f5972X[8] + 1352829926, 11) + RL52;
        int RL56 = m4781RL(RL51, 10);
        int RL57 = m4781RL(RL52 + m4786f5(RL55, RL53, RL56) + this.f5972X[1] + 1352829926, 14) + RL54;
        int RL58 = m4781RL(RL53, 10);
        int RL59 = m4781RL(RL54 + m4786f5(RL57, RL55, RL58) + this.f5972X[10] + 1352829926, 14) + RL56;
        int RL60 = m4781RL(RL55, 10);
        int RL61 = m4781RL(RL56 + m4786f5(RL59, RL57, RL60) + this.f5972X[3] + 1352829926, 12) + RL58;
        int RL62 = m4781RL(RL57, 10);
        int RL63 = m4781RL(RL58 + m4786f5(RL61, RL59, RL62) + this.f5972X[12] + 1352829926, 6) + RL60;
        int RL64 = m4781RL(RL59, 10);
        int RL65 = m4781RL(RL28 + m4783f2(RL31, RL29, RL32) + this.f5972X[7] + 1518500249, 7) + RL30;
        int RL66 = m4781RL(RL29, 10);
        int RL67 = m4781RL(RL30 + m4783f2(RL65, RL31, RL66) + this.f5972X[4] + 1518500249, 6) + RL32;
        int RL68 = m4781RL(RL31, 10);
        int RL69 = m4781RL(RL32 + m4783f2(RL67, RL65, RL68) + this.f5972X[13] + 1518500249, 8) + RL66;
        int RL70 = m4781RL(RL65, 10);
        int RL71 = m4781RL(RL66 + m4783f2(RL69, RL67, RL70) + this.f5972X[1] + 1518500249, 13) + RL68;
        int RL72 = m4781RL(RL67, 10);
        int RL73 = m4781RL(RL68 + m4783f2(RL71, RL69, RL72) + this.f5972X[10] + 1518500249, 11) + RL70;
        int RL74 = m4781RL(RL69, 10);
        int RL75 = m4781RL(RL70 + m4783f2(RL73, RL71, RL74) + this.f5972X[6] + 1518500249, 9) + RL72;
        int RL76 = m4781RL(RL71, 10);
        int RL77 = m4781RL(RL72 + m4783f2(RL75, RL73, RL76) + this.f5972X[15] + 1518500249, 7) + RL74;
        int RL78 = m4781RL(RL73, 10);
        int RL79 = m4781RL(RL74 + m4783f2(RL77, RL75, RL78) + this.f5972X[3] + 1518500249, 15) + RL76;
        int RL80 = m4781RL(RL75, 10);
        int RL81 = m4781RL(RL76 + m4783f2(RL79, RL77, RL80) + this.f5972X[12] + 1518500249, 7) + RL78;
        int RL82 = m4781RL(RL77, 10);
        int RL83 = m4781RL(RL78 + m4783f2(RL81, RL79, RL82) + this.f5972X[0] + 1518500249, 12) + RL80;
        int RL84 = m4781RL(RL79, 10);
        int RL85 = m4781RL(RL80 + m4783f2(RL83, RL81, RL84) + this.f5972X[9] + 1518500249, 15) + RL82;
        int RL86 = m4781RL(RL81, 10);
        int RL87 = m4781RL(RL82 + m4783f2(RL85, RL83, RL86) + this.f5972X[5] + 1518500249, 9) + RL84;
        int RL88 = m4781RL(RL83, 10);
        int RL89 = m4781RL(RL84 + m4783f2(RL87, RL85, RL88) + this.f5972X[2] + 1518500249, 11) + RL86;
        int RL90 = m4781RL(RL85, 10);
        int RL91 = m4781RL(RL86 + m4783f2(RL89, RL87, RL90) + this.f5972X[14] + 1518500249, 7) + RL88;
        int RL92 = m4781RL(RL87, 10);
        int RL93 = m4781RL(RL88 + m4783f2(RL91, RL89, RL92) + this.f5972X[11] + 1518500249, 13) + RL90;
        int RL94 = m4781RL(RL89, 10);
        int RL95 = m4781RL(RL90 + m4783f2(RL93, RL91, RL94) + this.f5972X[8] + 1518500249, 12) + RL92;
        int RL96 = m4781RL(RL91, 10);
        int RL97 = m4781RL(RL60 + m4785f4(RL63, RL61, RL64) + this.f5972X[6] + 1548603684, 9) + RL62;
        int RL98 = m4781RL(RL61, 10);
        int RL99 = m4781RL(RL62 + m4785f4(RL97, RL63, RL98) + this.f5972X[11] + 1548603684, 13) + RL64;
        int RL100 = m4781RL(RL63, 10);
        int RL101 = m4781RL(RL64 + m4785f4(RL99, RL97, RL100) + this.f5972X[3] + 1548603684, 15) + RL98;
        int RL102 = m4781RL(RL97, 10);
        int RL103 = m4781RL(RL98 + m4785f4(RL101, RL99, RL102) + this.f5972X[7] + 1548603684, 7) + RL100;
        int RL104 = m4781RL(RL99, 10);
        int RL105 = m4781RL(RL100 + m4785f4(RL103, RL101, RL104) + this.f5972X[0] + 1548603684, 12) + RL102;
        int RL106 = m4781RL(RL101, 10);
        int RL107 = m4781RL(RL102 + m4785f4(RL105, RL103, RL106) + this.f5972X[13] + 1548603684, 8) + RL104;
        int RL108 = m4781RL(RL103, 10);
        int RL109 = m4781RL(RL104 + m4785f4(RL107, RL105, RL108) + this.f5972X[5] + 1548603684, 9) + RL106;
        int RL110 = m4781RL(RL105, 10);
        int RL111 = m4781RL(RL106 + m4785f4(RL109, RL107, RL110) + this.f5972X[10] + 1548603684, 11) + RL108;
        int RL112 = m4781RL(RL107, 10);
        int RL113 = m4781RL(RL108 + m4785f4(RL111, RL109, RL112) + this.f5972X[14] + 1548603684, 7) + RL110;
        int RL114 = m4781RL(RL109, 10);
        int RL115 = m4781RL(RL110 + m4785f4(RL113, RL111, RL114) + this.f5972X[15] + 1548603684, 7) + RL112;
        int RL116 = m4781RL(RL111, 10);
        int RL117 = m4781RL(RL112 + m4785f4(RL115, RL113, RL116) + this.f5972X[8] + 1548603684, 12) + RL114;
        int RL118 = m4781RL(RL113, 10);
        int RL119 = m4781RL(RL114 + m4785f4(RL117, RL115, RL118) + this.f5972X[12] + 1548603684, 7) + RL116;
        int RL120 = m4781RL(RL115, 10);
        int RL121 = m4781RL(RL116 + m4785f4(RL119, RL117, RL120) + this.f5972X[4] + 1548603684, 6) + RL118;
        int RL122 = m4781RL(RL117, 10);
        int RL123 = m4781RL(RL118 + m4785f4(RL121, RL119, RL122) + this.f5972X[9] + 1548603684, 15) + RL120;
        int RL124 = m4781RL(RL119, 10);
        int RL125 = m4781RL(RL120 + m4785f4(RL123, RL121, RL124) + this.f5972X[1] + 1548603684, 13) + RL122;
        int RL126 = m4781RL(RL121, 10);
        int RL127 = m4781RL(RL122 + m4785f4(RL125, RL123, RL126) + this.f5972X[2] + 1548603684, 11) + RL124;
        int RL128 = m4781RL(RL123, 10);
        int RL129 = m4781RL(RL92 + m4784f3(RL95, RL93, RL96) + this.f5972X[3] + 1859775393, 11) + RL94;
        int RL130 = m4781RL(RL93, 10);
        int RL131 = m4781RL(RL94 + m4784f3(RL129, RL95, RL130) + this.f5972X[10] + 1859775393, 13) + RL96;
        int RL132 = m4781RL(RL95, 10);
        int RL133 = m4781RL(RL96 + m4784f3(RL131, RL129, RL132) + this.f5972X[14] + 1859775393, 6) + RL130;
        int RL134 = m4781RL(RL129, 10);
        int RL135 = m4781RL(RL130 + m4784f3(RL133, RL131, RL134) + this.f5972X[4] + 1859775393, 7) + RL132;
        int RL136 = m4781RL(RL131, 10);
        int RL137 = m4781RL(RL132 + m4784f3(RL135, RL133, RL136) + this.f5972X[9] + 1859775393, 14) + RL134;
        int RL138 = m4781RL(RL133, 10);
        int RL139 = m4781RL(RL134 + m4784f3(RL137, RL135, RL138) + this.f5972X[15] + 1859775393, 9) + RL136;
        int RL140 = m4781RL(RL135, 10);
        int RL141 = m4781RL(RL136 + m4784f3(RL139, RL137, RL140) + this.f5972X[8] + 1859775393, 13) + RL138;
        int RL142 = m4781RL(RL137, 10);
        int RL143 = m4781RL(RL138 + m4784f3(RL141, RL139, RL142) + this.f5972X[1] + 1859775393, 15) + RL140;
        int RL144 = m4781RL(RL139, 10);
        int RL145 = m4781RL(RL140 + m4784f3(RL143, RL141, RL144) + this.f5972X[2] + 1859775393, 14) + RL142;
        int RL146 = m4781RL(RL141, 10);
        int RL147 = m4781RL(RL142 + m4784f3(RL145, RL143, RL146) + this.f5972X[7] + 1859775393, 8) + RL144;
        int RL148 = m4781RL(RL143, 10);
        int RL149 = m4781RL(RL144 + m4784f3(RL147, RL145, RL148) + this.f5972X[0] + 1859775393, 13) + RL146;
        int RL150 = m4781RL(RL145, 10);
        int RL151 = m4781RL(RL146 + m4784f3(RL149, RL147, RL150) + this.f5972X[6] + 1859775393, 6) + RL148;
        int RL152 = m4781RL(RL147, 10);
        int RL153 = m4781RL(RL148 + m4784f3(RL151, RL149, RL152) + this.f5972X[13] + 1859775393, 5) + RL150;
        int RL154 = m4781RL(RL149, 10);
        int RL155 = m4781RL(RL150 + m4784f3(RL153, RL151, RL154) + this.f5972X[11] + 1859775393, 12) + RL152;
        int RL156 = m4781RL(RL151, 10);
        int RL157 = m4781RL(RL152 + m4784f3(RL155, RL153, RL156) + this.f5972X[5] + 1859775393, 7) + RL154;
        int RL158 = m4781RL(RL153, 10);
        int RL159 = m4781RL(RL154 + m4784f3(RL157, RL155, RL158) + this.f5972X[12] + 1859775393, 5) + RL156;
        int RL160 = m4781RL(RL155, 10);
        int RL161 = m4781RL(RL124 + m4784f3(RL127, RL125, RL128) + this.f5972X[15] + 1836072691, 9) + RL126;
        int RL162 = m4781RL(RL125, 10);
        int RL163 = m4781RL(RL126 + m4784f3(RL161, RL127, RL162) + this.f5972X[5] + 1836072691, 7) + RL128;
        int RL164 = m4781RL(RL127, 10);
        int RL165 = m4781RL(RL128 + m4784f3(RL163, RL161, RL164) + this.f5972X[1] + 1836072691, 15) + RL162;
        int RL166 = m4781RL(RL161, 10);
        int RL167 = m4781RL(RL162 + m4784f3(RL165, RL163, RL166) + this.f5972X[3] + 1836072691, 11) + RL164;
        int RL168 = m4781RL(RL163, 10);
        int RL169 = m4781RL(RL164 + m4784f3(RL167, RL165, RL168) + this.f5972X[7] + 1836072691, 8) + RL166;
        int RL170 = m4781RL(RL165, 10);
        int RL171 = m4781RL(RL166 + m4784f3(RL169, RL167, RL170) + this.f5972X[14] + 1836072691, 6) + RL168;
        int RL172 = m4781RL(RL167, 10);
        int RL173 = m4781RL(RL168 + m4784f3(RL171, RL169, RL172) + this.f5972X[6] + 1836072691, 6) + RL170;
        int RL174 = m4781RL(RL169, 10);
        int RL175 = m4781RL(RL170 + m4784f3(RL173, RL171, RL174) + this.f5972X[9] + 1836072691, 14) + RL172;
        int RL176 = m4781RL(RL171, 10);
        int RL177 = m4781RL(RL172 + m4784f3(RL175, RL173, RL176) + this.f5972X[11] + 1836072691, 12) + RL174;
        int RL178 = m4781RL(RL173, 10);
        int RL179 = m4781RL(RL174 + m4784f3(RL177, RL175, RL178) + this.f5972X[8] + 1836072691, 13) + RL176;
        int RL180 = m4781RL(RL175, 10);
        int RL181 = m4781RL(RL176 + m4784f3(RL179, RL177, RL180) + this.f5972X[12] + 1836072691, 5) + RL178;
        int RL182 = m4781RL(RL177, 10);
        int RL183 = m4781RL(RL178 + m4784f3(RL181, RL179, RL182) + this.f5972X[2] + 1836072691, 14) + RL180;
        int RL184 = m4781RL(RL179, 10);
        int RL185 = m4781RL(RL180 + m4784f3(RL183, RL181, RL184) + this.f5972X[10] + 1836072691, 13) + RL182;
        int RL186 = m4781RL(RL181, 10);
        int RL187 = m4781RL(RL182 + m4784f3(RL185, RL183, RL186) + this.f5972X[0] + 1836072691, 13) + RL184;
        int RL188 = m4781RL(RL183, 10);
        int RL189 = m4781RL(RL184 + m4784f3(RL187, RL185, RL188) + this.f5972X[4] + 1836072691, 7) + RL186;
        int RL190 = m4781RL(RL185, 10);
        int RL191 = m4781RL(RL186 + m4784f3(RL189, RL187, RL190) + this.f5972X[13] + 1836072691, 5) + RL188;
        int RL192 = m4781RL(RL187, 10);
        int RL193 = m4781RL(((RL156 + m4785f4(RL159, RL157, RL160)) + this.f5972X[1]) - 1894007588, 11) + RL158;
        int RL194 = m4781RL(RL157, 10);
        int RL195 = m4781RL(((RL158 + m4785f4(RL193, RL159, RL194)) + this.f5972X[9]) - 1894007588, 12) + RL160;
        int RL196 = m4781RL(RL159, 10);
        int RL197 = m4781RL(((RL160 + m4785f4(RL195, RL193, RL196)) + this.f5972X[11]) - 1894007588, 14) + RL194;
        int RL198 = m4781RL(RL193, 10);
        int RL199 = m4781RL(((RL194 + m4785f4(RL197, RL195, RL198)) + this.f5972X[10]) - 1894007588, 15) + RL196;
        int RL200 = m4781RL(RL195, 10);
        int RL201 = m4781RL(((RL196 + m4785f4(RL199, RL197, RL200)) + this.f5972X[0]) - 1894007588, 14) + RL198;
        int RL202 = m4781RL(RL197, 10);
        int RL203 = m4781RL(((RL198 + m4785f4(RL201, RL199, RL202)) + this.f5972X[8]) - 1894007588, 15) + RL200;
        int RL204 = m4781RL(RL199, 10);
        int RL205 = m4781RL(((RL200 + m4785f4(RL203, RL201, RL204)) + this.f5972X[12]) - 1894007588, 9) + RL202;
        int RL206 = m4781RL(RL201, 10);
        int RL207 = m4781RL(((RL202 + m4785f4(RL205, RL203, RL206)) + this.f5972X[4]) - 1894007588, 8) + RL204;
        int RL208 = m4781RL(RL203, 10);
        int RL209 = m4781RL(((RL204 + m4785f4(RL207, RL205, RL208)) + this.f5972X[13]) - 1894007588, 9) + RL206;
        int RL210 = m4781RL(RL205, 10);
        int RL211 = m4781RL(((RL206 + m4785f4(RL209, RL207, RL210)) + this.f5972X[3]) - 1894007588, 14) + RL208;
        int RL212 = m4781RL(RL207, 10);
        int RL213 = m4781RL(((RL208 + m4785f4(RL211, RL209, RL212)) + this.f5972X[7]) - 1894007588, 5) + RL210;
        int RL214 = m4781RL(RL209, 10);
        int RL215 = m4781RL(((RL210 + m4785f4(RL213, RL211, RL214)) + this.f5972X[15]) - 1894007588, 6) + RL212;
        int RL216 = m4781RL(RL211, 10);
        int RL217 = m4781RL(((RL212 + m4785f4(RL215, RL213, RL216)) + this.f5972X[14]) - 1894007588, 8) + RL214;
        int RL218 = m4781RL(RL213, 10);
        int RL219 = m4781RL(((RL214 + m4785f4(RL217, RL215, RL218)) + this.f5972X[5]) - 1894007588, 6) + RL216;
        int RL220 = m4781RL(RL215, 10);
        int RL221 = m4781RL(((RL216 + m4785f4(RL219, RL217, RL220)) + this.f5972X[6]) - 1894007588, 5) + RL218;
        int RL222 = m4781RL(RL217, 10);
        int RL223 = m4781RL(((RL218 + m4785f4(RL221, RL219, RL222)) + this.f5972X[2]) - 1894007588, 12) + RL220;
        int RL224 = m4781RL(RL219, 10);
        int RL225 = m4781RL(RL188 + m4783f2(RL191, RL189, RL192) + this.f5972X[8] + 2053994217, 15) + RL190;
        int RL226 = m4781RL(RL189, 10);
        int RL227 = m4781RL(RL190 + m4783f2(RL225, RL191, RL226) + this.f5972X[6] + 2053994217, 5) + RL192;
        int RL228 = m4781RL(RL191, 10);
        int RL229 = m4781RL(RL192 + m4783f2(RL227, RL225, RL228) + this.f5972X[4] + 2053994217, 8) + RL226;
        int RL230 = m4781RL(RL225, 10);
        int RL231 = m4781RL(RL226 + m4783f2(RL229, RL227, RL230) + this.f5972X[1] + 2053994217, 11) + RL228;
        int RL232 = m4781RL(RL227, 10);
        int RL233 = m4781RL(RL228 + m4783f2(RL231, RL229, RL232) + this.f5972X[3] + 2053994217, 14) + RL230;
        int RL234 = m4781RL(RL229, 10);
        int RL235 = m4781RL(RL230 + m4783f2(RL233, RL231, RL234) + this.f5972X[11] + 2053994217, 14) + RL232;
        int RL236 = m4781RL(RL231, 10);
        int RL237 = m4781RL(RL232 + m4783f2(RL235, RL233, RL236) + this.f5972X[15] + 2053994217, 6) + RL234;
        int RL238 = m4781RL(RL233, 10);
        int RL239 = m4781RL(RL234 + m4783f2(RL237, RL235, RL238) + this.f5972X[0] + 2053994217, 14) + RL236;
        int RL240 = m4781RL(RL235, 10);
        int RL241 = m4781RL(RL236 + m4783f2(RL239, RL237, RL240) + this.f5972X[5] + 2053994217, 6) + RL238;
        int RL242 = m4781RL(RL237, 10);
        int RL243 = m4781RL(RL238 + m4783f2(RL241, RL239, RL242) + this.f5972X[12] + 2053994217, 9) + RL240;
        int RL244 = m4781RL(RL239, 10);
        int RL245 = m4781RL(RL240 + m4783f2(RL243, RL241, RL244) + this.f5972X[2] + 2053994217, 12) + RL242;
        int RL246 = m4781RL(RL241, 10);
        int RL247 = m4781RL(RL242 + m4783f2(RL245, RL243, RL246) + this.f5972X[13] + 2053994217, 9) + RL244;
        int RL248 = m4781RL(RL243, 10);
        int RL249 = m4781RL(RL244 + m4783f2(RL247, RL245, RL248) + this.f5972X[9] + 2053994217, 12) + RL246;
        int RL250 = m4781RL(RL245, 10);
        int RL251 = m4781RL(RL246 + m4783f2(RL249, RL247, RL250) + this.f5972X[7] + 2053994217, 5) + RL248;
        int RL252 = m4781RL(RL247, 10);
        int RL253 = m4781RL(RL248 + m4783f2(RL251, RL249, RL252) + this.f5972X[10] + 2053994217, 15) + RL250;
        int RL254 = m4781RL(RL249, 10);
        int RL255 = m4781RL(RL250 + m4783f2(RL253, RL251, RL254) + this.f5972X[14] + 2053994217, 8) + RL252;
        int RL256 = m4781RL(RL251, 10);
        int RL257 = m4781RL(((RL220 + m4786f5(RL223, RL221, RL224)) + this.f5972X[4]) - 1454113458, 9) + RL222;
        int RL258 = m4781RL(RL221, 10);
        int RL259 = m4781RL(((RL222 + m4786f5(RL257, RL223, RL258)) + this.f5972X[0]) - 1454113458, 15) + RL224;
        int RL260 = m4781RL(RL223, 10);
        int RL261 = m4781RL(((RL224 + m4786f5(RL259, RL257, RL260)) + this.f5972X[5]) - 1454113458, 5) + RL258;
        int RL262 = m4781RL(RL257, 10);
        int RL263 = m4781RL(((RL258 + m4786f5(RL261, RL259, RL262)) + this.f5972X[9]) - 1454113458, 11) + RL260;
        int RL264 = m4781RL(RL259, 10);
        int RL265 = m4781RL(((RL260 + m4786f5(RL263, RL261, RL264)) + this.f5972X[7]) - 1454113458, 6) + RL262;
        int RL266 = m4781RL(RL261, 10);
        int RL267 = m4781RL(((RL262 + m4786f5(RL265, RL263, RL266)) + this.f5972X[12]) - 1454113458, 8) + RL264;
        int RL268 = m4781RL(RL263, 10);
        int RL269 = m4781RL(((RL264 + m4786f5(RL267, RL265, RL268)) + this.f5972X[2]) - 1454113458, 13) + RL266;
        int RL270 = m4781RL(RL265, 10);
        int RL271 = m4781RL(((RL266 + m4786f5(RL269, RL267, RL270)) + this.f5972X[10]) - 1454113458, 12) + RL268;
        int RL272 = m4781RL(RL267, 10);
        int RL273 = m4781RL(((RL268 + m4786f5(RL271, RL269, RL272)) + this.f5972X[14]) - 1454113458, 5) + RL270;
        int RL274 = m4781RL(RL269, 10);
        int RL275 = m4781RL(((RL270 + m4786f5(RL273, RL271, RL274)) + this.f5972X[1]) - 1454113458, 12) + RL272;
        int RL276 = m4781RL(RL271, 10);
        int RL277 = m4781RL(((RL272 + m4786f5(RL275, RL273, RL276)) + this.f5972X[3]) - 1454113458, 13) + RL274;
        int RL278 = m4781RL(RL273, 10);
        int RL279 = m4781RL(((RL274 + m4786f5(RL277, RL275, RL278)) + this.f5972X[8]) - 1454113458, 14) + RL276;
        int RL280 = m4781RL(RL275, 10);
        int RL281 = m4781RL(((RL276 + m4786f5(RL279, RL277, RL280)) + this.f5972X[11]) - 1454113458, 11) + RL278;
        int RL282 = m4781RL(RL277, 10);
        int RL283 = m4781RL(((RL278 + m4786f5(RL281, RL279, RL282)) + this.f5972X[6]) - 1454113458, 8) + RL280;
        int RL284 = m4781RL(RL279, 10);
        int RL285 = m4781RL(((RL280 + m4786f5(RL283, RL281, RL284)) + this.f5972X[15]) - 1454113458, 5) + RL282;
        int RL286 = m4781RL(RL281, 10);
        int RL287 = m4781RL(RL283, 10);
        int RL288 = m4781RL(RL252 + m4782f1(RL255, RL253, RL256) + this.f5972X[12], 8) + RL254;
        int RL289 = m4781RL(RL253, 10);
        int RL290 = m4781RL(RL254 + m4782f1(RL288, RL255, RL289) + this.f5972X[15], 5) + RL256;
        int RL291 = m4781RL(RL255, 10);
        int RL292 = m4781RL(RL256 + m4782f1(RL290, RL288, RL291) + this.f5972X[10], 12) + RL289;
        int RL293 = m4781RL(RL288, 10);
        int RL294 = m4781RL(RL289 + m4782f1(RL292, RL290, RL293) + this.f5972X[4], 9) + RL291;
        int RL295 = m4781RL(RL290, 10);
        int RL296 = m4781RL(RL291 + m4782f1(RL294, RL292, RL295) + this.f5972X[1], 12) + RL293;
        int RL297 = m4781RL(RL292, 10);
        int RL298 = m4781RL(RL293 + m4782f1(RL296, RL294, RL297) + this.f5972X[5], 5) + RL295;
        int RL299 = m4781RL(RL294, 10);
        int RL300 = m4781RL(RL295 + m4782f1(RL298, RL296, RL299) + this.f5972X[8], 14) + RL297;
        int RL301 = m4781RL(RL296, 10);
        int RL302 = m4781RL(RL297 + m4782f1(RL300, RL298, RL301) + this.f5972X[7], 6) + RL299;
        int RL303 = m4781RL(RL298, 10);
        int RL304 = m4781RL(RL299 + m4782f1(RL302, RL300, RL303) + this.f5972X[6], 8) + RL301;
        int RL305 = m4781RL(RL300, 10);
        int RL306 = m4781RL(RL301 + m4782f1(RL304, RL302, RL305) + this.f5972X[2], 13) + RL303;
        int RL307 = m4781RL(RL302, 10);
        int RL308 = m4781RL(RL303 + m4782f1(RL306, RL304, RL307) + this.f5972X[13], 6) + RL305;
        int RL309 = m4781RL(RL304, 10);
        int RL310 = m4781RL(RL305 + m4782f1(RL308, RL306, RL309) + this.f5972X[14], 5) + RL307;
        int RL311 = m4781RL(RL306, 10);
        int RL312 = m4781RL(RL307 + m4782f1(RL310, RL308, RL311) + this.f5972X[0], 15) + RL309;
        int RL313 = m4781RL(RL308, 10);
        int RL314 = m4781RL(RL309 + m4782f1(RL312, RL310, RL313) + this.f5972X[3], 13) + RL311;
        int RL315 = m4781RL(RL310, 10);
        int RL316 = m4781RL(RL311 + m4782f1(RL314, RL312, RL315) + this.f5972X[9], 11) + RL313;
        int RL317 = m4781RL(RL312, 10);
        int RL318 = m4781RL(RL313 + m4782f1(RL316, RL314, RL317) + this.f5972X[11], 11) + RL315;
        this.f5968H1 = this.f5969H2 + RL287 + RL317;
        this.f5969H2 = this.f5970H3 + RL286 + RL315;
        this.f5970H3 = this.f5971H4 + RL284 + RL318;
        this.f5971H4 = this.f5967H0 + m4781RL(((RL282 + m4786f5(RL285, RL283, RL286)) + this.f5972X[13]) - 1454113458, 6) + RL284 + RL316;
        this.f5967H0 = m4781RL(RL314, 10) + RL285 + this.f5968H1;
        int i6 = 0;
        this.xOff = 0;
        while (true) {
            int[] iArr = this.f5972X;
            if (i6 != iArr.length) {
                iArr[i6] = 0;
                i6++;
            } else {
                return;
            }
        }
    }
}
