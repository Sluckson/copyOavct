package repack.org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.Digest;

public class SRP6VerifierGenerator {

    /* renamed from: N */
    protected BigInteger f5924N;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f5925g;

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2) {
        this.f5924N = bigInteger;
        this.f5925g = bigInteger2;
        this.digest = digest2;
    }

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f5925g.modPow(SRP6Util.calculateX(this.digest, this.f5924N, bArr, bArr2, bArr3), this.f5924N);
    }
}
