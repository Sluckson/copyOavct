package repack.org.bouncycastle.asn1.p065x9;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

/* renamed from: repack.org.bouncycastle.asn1.x9.X9FieldID */
public class X9FieldID extends ASN1Encodable implements X9ObjectIdentifiers {

    /* renamed from: id */
    private DERObjectIdentifier f5899id;
    private DERObject parameters;

    public X9FieldID(BigInteger bigInteger) {
        this.f5899id = prime_field;
        this.parameters = new DERInteger(bigInteger);
    }

    public X9FieldID(int i, int i2, int i3, int i4) {
        this.f5899id = characteristic_two_field;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(i));
        if (i3 == 0) {
            aSN1EncodableVector.add(tpBasis);
            aSN1EncodableVector.add(new DERInteger(i2));
        } else {
            aSN1EncodableVector.add(ppBasis);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new DERInteger(i2));
            aSN1EncodableVector2.add(new DERInteger(i3));
            aSN1EncodableVector2.add(new DERInteger(i4));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        this.parameters = new DERSequence(aSN1EncodableVector);
    }

    public X9FieldID(ASN1Sequence aSN1Sequence) {
        this.f5899id = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.parameters = (DERObject) aSN1Sequence.getObjectAt(1);
    }

    public DERObjectIdentifier getIdentifier() {
        return this.f5899id;
    }

    public DERObject getParameters() {
        return this.parameters;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5899id);
        aSN1EncodableVector.add(this.parameters);
        return new DERSequence(aSN1EncodableVector);
    }
}
