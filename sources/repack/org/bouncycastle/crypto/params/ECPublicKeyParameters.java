package repack.org.bouncycastle.crypto.params;

import repack.org.bouncycastle.math.p070ec.ECPoint;

public class ECPublicKeyParameters extends ECKeyParameters {

    /* renamed from: Q */
    ECPoint f6189Q;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.f6189Q = eCPoint;
    }

    public ECPoint getQ() {
        return this.f6189Q;
    }
}
