package repack.org.bouncycastle.asn1.p065x9;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.math.p070ec.ECCurve;

/* renamed from: repack.org.bouncycastle.asn1.x9.X9Curve */
public class X9Curve extends ASN1Encodable implements X9ObjectIdentifiers {
    private ECCurve curve;
    private DERObjectIdentifier fieldIdentifier = null;
    private byte[] seed;

    public X9Curve(ECCurve eCCurve) {
        this.curve = eCCurve;
        this.seed = null;
        setFieldIdentifier();
    }

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.curve = eCCurve;
        this.seed = bArr;
        setFieldIdentifier();
    }

    public X9Curve(X9FieldID x9FieldID, ASN1Sequence aSN1Sequence) {
        int i;
        int i2;
        int i3;
        this.fieldIdentifier = x9FieldID.getIdentifier();
        if (this.fieldIdentifier.equals(prime_field)) {
            BigInteger value = ((DERInteger) x9FieldID.getParameters()).getValue();
            this.curve = new ECCurve.C5028Fp(value, new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        } else if (this.fieldIdentifier.equals(characteristic_two_field)) {
            DERSequence dERSequence = (DERSequence) x9FieldID.getParameters();
            int intValue = ((DERInteger) dERSequence.getObjectAt(0)).getValue().intValue();
            if (((DERObjectIdentifier) dERSequence.getObjectAt(1)).equals(tpBasis)) {
                i = ((DERInteger) dERSequence.getObjectAt(2)).getValue().intValue();
                i3 = 0;
                i2 = 0;
            } else {
                DERSequence dERSequence2 = (DERSequence) dERSequence.getObjectAt(2);
                int intValue2 = ((DERInteger) dERSequence2.getObjectAt(0)).getValue().intValue();
                int intValue3 = ((DERInteger) dERSequence2.getObjectAt(1)).getValue().intValue();
                i2 = ((DERInteger) dERSequence2.getObjectAt(2)).getValue().intValue();
                i = intValue2;
                i3 = intValue3;
            }
            int i4 = intValue;
            int i5 = i;
            int i6 = i3;
            int i7 = i2;
            this.curve = new ECCurve.F2m(i4, i5, i6, i7, new X9FieldElement(i4, i5, i6, i7, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(i4, i5, i6, i7, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        }
        if (aSN1Sequence.size() == 3) {
            this.seed = ((DERBitString) aSN1Sequence.getObjectAt(2)).getBytes();
        }
    }

    private void setFieldIdentifier() {
        ECCurve eCCurve = this.curve;
        if (eCCurve instanceof ECCurve.C5028Fp) {
            this.fieldIdentifier = prime_field;
        } else if (eCCurve instanceof ECCurve.F2m) {
            this.fieldIdentifier = characteristic_two_field;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.fieldIdentifier.equals(prime_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).getDERObject());
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getB()).getDERObject());
        } else if (this.fieldIdentifier.equals(characteristic_two_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).getDERObject());
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getB()).getDERObject());
        }
        byte[] bArr = this.seed;
        if (bArr != null) {
            aSN1EncodableVector.add(new DERBitString(bArr));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
