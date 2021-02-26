package repack.org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Encodable {

    /* renamed from: a */
    DERInteger f5834a;

    /* renamed from: b */
    DERInteger f5835b;

    /* renamed from: p */
    DERInteger f5836p;

    /* renamed from: q */
    DERInteger f5837q;

    /* renamed from: x */
    DERInteger f5838x;

    /* renamed from: y */
    DERInteger f5839y;

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.f5834a = new DERInteger(bigInteger);
        this.f5835b = new DERInteger(bigInteger2);
        this.f5836p = new DERInteger(bigInteger3);
        this.f5837q = new DERInteger(bigInteger4);
        this.f5838x = new DERInteger(i);
        this.f5839y = new DERInteger(bigInteger5);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f5834a = (DERInteger) objects.nextElement();
        this.f5835b = (DERInteger) objects.nextElement();
        this.f5836p = (DERInteger) objects.nextElement();
        this.f5837q = (DERInteger) objects.nextElement();
        this.f5838x = (DERInteger) objects.nextElement();
        this.f5839y = (DERInteger) objects.nextElement();
    }

    public BigInteger getP() {
        return this.f5836p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f5837q.getPositiveValue();
    }

    public BigInteger getA() {
        return this.f5834a.getPositiveValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5834a);
        aSN1EncodableVector.add(this.f5835b);
        aSN1EncodableVector.add(this.f5836p);
        aSN1EncodableVector.add(this.f5837q);
        aSN1EncodableVector.add(this.f5838x);
        aSN1EncodableVector.add(this.f5839y);
        return new DERSequence(aSN1EncodableVector);
    }
}
