package repack.org.bouncycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Encodable {

    /* renamed from: g */
    DERInteger f5848g;

    /* renamed from: p */
    DERInteger f5849p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f5849p = new DERInteger(bigInteger);
        this.f5848g = new DERInteger(bigInteger2);
    }

    public ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f5849p = (DERInteger) objects.nextElement();
        this.f5848g = (DERInteger) objects.nextElement();
    }

    public BigInteger getP() {
        return this.f5849p.getPositiveValue();
    }

    public BigInteger getG() {
        return this.f5848g.getPositiveValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5849p);
        aSN1EncodableVector.add(this.f5848g);
        return new DERSequence(aSN1EncodableVector);
    }
}
