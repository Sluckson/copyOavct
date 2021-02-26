package repack.org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class DHParameter extends ASN1Encodable {

    /* renamed from: g */
    DERInteger f5850g;

    /* renamed from: l */
    DERInteger f5851l;

    /* renamed from: p */
    DERInteger f5852p;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f5852p = new DERInteger(bigInteger);
        this.f5850g = new DERInteger(bigInteger2);
        if (i != 0) {
            this.f5851l = new DERInteger(i);
        } else {
            this.f5851l = null;
        }
    }

    public DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f5852p = (DERInteger) objects.nextElement();
        this.f5850g = (DERInteger) objects.nextElement();
        if (objects.hasMoreElements()) {
            this.f5851l = (DERInteger) objects.nextElement();
        } else {
            this.f5851l = null;
        }
    }

    public BigInteger getP() {
        return this.f5852p.getPositiveValue();
    }

    public BigInteger getG() {
        return this.f5850g.getPositiveValue();
    }

    public BigInteger getL() {
        DERInteger dERInteger = this.f5851l;
        if (dERInteger == null) {
            return null;
        }
        return dERInteger.getPositiveValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5852p);
        aSN1EncodableVector.add(this.f5850g);
        if (getL() != null) {
            aSN1EncodableVector.add(this.f5851l);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
