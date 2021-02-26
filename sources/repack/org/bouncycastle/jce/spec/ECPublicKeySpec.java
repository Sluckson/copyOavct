package repack.org.bouncycastle.jce.spec;

import repack.org.bouncycastle.math.p070ec.ECPoint;

public class ECPublicKeySpec extends ECKeySpec {

    /* renamed from: q */
    private ECPoint f6254q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f6254q = eCPoint;
    }

    public ECPoint getQ() {
        return this.f6254q;
    }
}
