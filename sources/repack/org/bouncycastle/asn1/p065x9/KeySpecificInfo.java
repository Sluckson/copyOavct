package repack.org.bouncycastle.asn1.p065x9;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

/* renamed from: repack.org.bouncycastle.asn1.x9.KeySpecificInfo */
public class KeySpecificInfo extends ASN1Encodable {
    private DERObjectIdentifier algorithm;
    private ASN1OctetString counter;

    public KeySpecificInfo(DERObjectIdentifier dERObjectIdentifier, ASN1OctetString aSN1OctetString) {
        this.algorithm = dERObjectIdentifier;
        this.counter = aSN1OctetString;
    }

    public KeySpecificInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.algorithm = (DERObjectIdentifier) objects.nextElement();
        this.counter = (ASN1OctetString) objects.nextElement();
    }

    public DERObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public ASN1OctetString getCounter() {
        return this.counter;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.algorithm);
        aSN1EncodableVector.add(this.counter);
        return new DERSequence(aSN1EncodableVector);
    }
}
