package repack.org.bouncycastle.asn1.p065x9;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.math.p070ec.ECCurve;
import repack.org.bouncycastle.math.p070ec.ECPoint;

/* renamed from: repack.org.bouncycastle.asn1.x9.X9ECPoint */
public class X9ECPoint extends ASN1Encodable {

    /* renamed from: p */
    ECPoint f5897p;

    public X9ECPoint(ECPoint eCPoint) {
        this.f5897p = eCPoint;
    }

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this.f5897p = eCCurve.decodePoint(aSN1OctetString.getOctets());
    }

    public ECPoint getPoint() {
        return this.f5897p;
    }

    public DERObject toASN1Object() {
        return new DEROctetString(this.f5897p.getEncoded());
    }
}
