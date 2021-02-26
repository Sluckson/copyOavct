package repack.org.bouncycastle.crypto.digests;

import repack.org.bouncycastle.crypto.util.Pack;

public class SHA512Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 64;

    public String getAlgorithmName() {
        return "SHA-512";
    }

    public int getDigestSize() {
        return 64;
    }

    public SHA512Digest() {
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.longToBigEndian(this.f5939H1, bArr, i);
        Pack.longToBigEndian(this.f5940H2, bArr, i + 8);
        Pack.longToBigEndian(this.f5941H3, bArr, i + 16);
        Pack.longToBigEndian(this.f5942H4, bArr, i + 24);
        Pack.longToBigEndian(this.f5943H5, bArr, i + 32);
        Pack.longToBigEndian(this.f5944H6, bArr, i + 40);
        Pack.longToBigEndian(this.f5945H7, bArr, i + 48);
        Pack.longToBigEndian(this.f5946H8, bArr, i + 56);
        reset();
        return 64;
    }

    public void reset() {
        super.reset();
        this.f5939H1 = 7640891576956012808L;
        this.f5940H2 = -4942790177534073029L;
        this.f5941H3 = 4354685564936845355L;
        this.f5942H4 = -6534734903238641935L;
        this.f5943H5 = 5840696475078001361L;
        this.f5944H6 = -7276294671716946913L;
        this.f5945H7 = 2270897969802886507L;
        this.f5946H8 = 6620516959819538809L;
    }
}
