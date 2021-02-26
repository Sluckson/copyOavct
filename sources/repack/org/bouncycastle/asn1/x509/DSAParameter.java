package repack.org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class DSAParameter extends ASN1Encodable {

    /* renamed from: g */
    DERInteger f5874g;

    /* renamed from: p */
    DERInteger f5875p;

    /* renamed from: q */
    DERInteger f5876q;

    public static DSAParameter getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static DSAParameter getInstance(Object obj) {
        if (obj == null || (obj instanceof DSAParameter)) {
            return (DSAParameter) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DSAParameter((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid DSAParameter: " + obj.getClass().getName());
    }

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f5875p = new DERInteger(bigInteger);
        this.f5876q = new DERInteger(bigInteger2);
        this.f5874g = new DERInteger(bigInteger3);
    }

    public DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.f5875p = DERInteger.getInstance(objects.nextElement());
            this.f5876q = DERInteger.getInstance(objects.nextElement());
            this.f5874g = DERInteger.getInstance(objects.nextElement());
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public BigInteger getP() {
        return this.f5875p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f5876q.getPositiveValue();
    }

    public BigInteger getG() {
        return this.f5874g.getPositiveValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5875p);
        aSN1EncodableVector.add(this.f5876q);
        aSN1EncodableVector.add(this.f5874g);
        return new DERSequence(aSN1EncodableVector);
    }
}
