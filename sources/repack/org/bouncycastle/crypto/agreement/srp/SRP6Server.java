package repack.org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Digest;

public class SRP6Server {

    /* renamed from: A */
    protected BigInteger f5916A;

    /* renamed from: B */
    protected BigInteger f5917B;

    /* renamed from: N */
    protected BigInteger f5918N;

    /* renamed from: S */
    protected BigInteger f5919S;

    /* renamed from: b */
    protected BigInteger f5920b;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f5921g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f5922u;

    /* renamed from: v */
    protected BigInteger f5923v;

    public void init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest2, SecureRandom secureRandom) {
        this.f5918N = bigInteger;
        this.f5921g = bigInteger2;
        this.f5923v = bigInteger3;
        this.random = secureRandom;
        this.digest = digest2;
    }

    public BigInteger generateServerCredentials() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f5918N, this.f5921g);
        this.f5920b = selectPrivateValue();
        this.f5917B = calculateK.multiply(this.f5923v).mod(this.f5918N).add(this.f5921g.modPow(this.f5920b, this.f5918N)).mod(this.f5918N);
        return this.f5917B;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        this.f5916A = SRP6Util.validatePublicValue(this.f5918N, bigInteger);
        this.f5922u = SRP6Util.calculateU(this.digest, this.f5918N, this.f5916A, this.f5917B);
        this.f5919S = calculateS();
        return this.f5919S;
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f5918N, this.f5921g, this.random);
    }

    private BigInteger calculateS() {
        return this.f5923v.modPow(this.f5922u, this.f5918N).multiply(this.f5916A).mod(this.f5918N).modPow(this.f5920b, this.f5918N);
    }
}
