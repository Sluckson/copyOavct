package repack.org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Digest;

public class SRP6Client {

    /* renamed from: A */
    protected BigInteger f5908A;

    /* renamed from: B */
    protected BigInteger f5909B;

    /* renamed from: N */
    protected BigInteger f5910N;

    /* renamed from: S */
    protected BigInteger f5911S;

    /* renamed from: a */
    protected BigInteger f5912a;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f5913g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f5914u;

    /* renamed from: x */
    protected BigInteger f5915x;

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2, SecureRandom secureRandom) {
        this.f5910N = bigInteger;
        this.f5913g = bigInteger2;
        this.digest = digest2;
        this.random = secureRandom;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f5915x = SRP6Util.calculateX(this.digest, this.f5910N, bArr, bArr2, bArr3);
        this.f5912a = selectPrivateValue();
        this.f5908A = this.f5913g.modPow(this.f5912a, this.f5910N);
        return this.f5908A;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        this.f5909B = SRP6Util.validatePublicValue(this.f5910N, bigInteger);
        this.f5914u = SRP6Util.calculateU(this.digest, this.f5910N, this.f5908A, this.f5909B);
        this.f5911S = calculateS();
        return this.f5911S;
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f5910N, this.f5913g, this.random);
    }

    private BigInteger calculateS() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f5910N, this.f5913g);
        return this.f5909B.subtract(this.f5913g.modPow(this.f5915x, this.f5910N).multiply(calculateK).mod(this.f5910N)).mod(this.f5910N).modPow(this.f5914u.multiply(this.f5915x).add(this.f5912a), this.f5910N);
    }
}
