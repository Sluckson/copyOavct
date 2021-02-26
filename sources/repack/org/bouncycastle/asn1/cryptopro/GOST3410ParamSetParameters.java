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

public class GOST3410ParamSetParameters extends ASN1Encodable {

    /* renamed from: a */
    DERInteger f5841a;
    int keySize;

    /* renamed from: p */
    DERInteger f5842p;

    /* renamed from: q */
    DERInteger f5843q;

    public static GOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static GOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof GOST3410ParamSetParameters)) {
            return (GOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new GOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public GOST3410ParamSetParameters(int i, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.keySize = i;
        this.f5842p = new DERInteger(bigInteger);
        this.f5843q = new DERInteger(bigInteger2);
        this.f5841a = new DERInteger(bigInteger3);
    }

    public GOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.keySize = ((DERInteger) objects.nextElement()).getValue().intValue();
        this.f5842p = (DERInteger) objects.nextElement();
        this.f5843q = (DERInteger) objects.nextElement();
        this.f5841a = (DERInteger) objects.nextElement();
    }

    public int getLKeySize() {
        return this.keySize;
    }

    public int getKeySize() {
        return this.keySize;
    }

    public BigInteger getP() {
        return this.f5842p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f5843q.getPositiveValue();
    }

    public BigInteger getA() {
        return this.f5841a.getPositiveValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(this.keySize));
        aSN1EncodableVector.add(this.f5842p);
        aSN1EncodableVector.add(this.f5843q);
        aSN1EncodableVector.add(this.f5841a);
        return new DERSequence(aSN1EncodableVector);
    }
}
