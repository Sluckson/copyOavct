package repack.org.bouncycastle.asn1.x509;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class PolicyInformation extends ASN1Encodable {
    private DERObjectIdentifier policyIdentifier;
    private ASN1Sequence policyQualifiers;

    public PolicyInformation(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.policyIdentifier = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.policyQualifiers = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public PolicyInformation(DERObjectIdentifier dERObjectIdentifier) {
        this.policyIdentifier = dERObjectIdentifier;
    }

    public PolicyInformation(DERObjectIdentifier dERObjectIdentifier, ASN1Sequence aSN1Sequence) {
        this.policyIdentifier = dERObjectIdentifier;
        this.policyQualifiers = aSN1Sequence;
    }

    public static PolicyInformation getInstance(Object obj) {
        if (obj == null || (obj instanceof PolicyInformation)) {
            return (PolicyInformation) obj;
        }
        return new PolicyInformation(ASN1Sequence.getInstance(obj));
    }

    public DERObjectIdentifier getPolicyIdentifier() {
        return this.policyIdentifier;
    }

    public ASN1Sequence getPolicyQualifiers() {
        return this.policyQualifiers;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.policyIdentifier);
        ASN1Sequence aSN1Sequence = this.policyQualifiers;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
