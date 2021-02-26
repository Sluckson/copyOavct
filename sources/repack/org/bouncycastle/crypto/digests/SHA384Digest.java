package repack.org.bouncycastle.crypto.digests;

import repack.org.bouncycastle.crypto.util.Pack;

public class SHA384Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 48;

    public String getAlgorithmName() {
        return "SHA-384";
    }

    public int getDigestSize() {
        return 48;
    }

    public SHA384Digest() {
    }

    public SHA384Digest(SHA384Digest sHA384Digest) {
        super(sHA384Digest);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.longToBigEndian(this.f5939H1, bArr, i);
        Pack.longToBigEndian(this.f5940H2, bArr, i + 8);
        Pack.longToBigEndian(this.f5941H3, bArr, i + 16);
        Pack.longToBigEndian(this.f5942H4, bArr, i + 24);
        Pack.longToBigEndian(this.f5943H5, bArr, i + 32);
        Pack.longToBigEndian(this.f5944H6, bArr, i + 40);
        reset();
        return 48;
    }

    public void reset() {
        super.reset();
        this.f5939H1 = -3766243637369397544L;
        this.f5940H2 = 7105036623409894663L;
        this.f5941H3 = -7973340178411365097L;
        this.f5942H4 = 1526699215303891257L;
        this.f5943H5 = 7436329637833083697L;
        this.f5944H6 = -8163818279084223215L;
        this.f5945H7 = -2662702644619276377L;
        this.f5946H8 = 5167115440072839076L;
    }
}
