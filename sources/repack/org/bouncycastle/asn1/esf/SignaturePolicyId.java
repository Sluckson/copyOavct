package repack.org.bouncycastle.asn1.esf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class SignaturePolicyId extends ASN1Encodable {
    private OtherHashAlgAndValue sigPolicyHash;
    private DERObjectIdentifier sigPolicyId;
    private SigPolicyQualifiers sigPolicyQualifiers;

    public static SignaturePolicyId getInstance(Object obj) {
        if (obj == null || (obj instanceof SignaturePolicyId)) {
            return (SignaturePolicyId) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SignaturePolicyId((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Unknown object in 'SignaturePolicyId' factory : " + obj.getClass().getName() + ".");
    }

    public SignaturePolicyId(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2 || aSN1Sequence.size() == 3) {
            this.sigPolicyId = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.sigPolicyHash = OtherHashAlgAndValue.getInstance(aSN1Sequence.getObjectAt(1));
            if (aSN1Sequence.size() == 3) {
                this.sigPolicyQualifiers = SigPolicyQualifiers.getInstance(aSN1Sequence.getObjectAt(2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public SignaturePolicyId(DERObjectIdentifier dERObjectIdentifier, OtherHashAlgAndValue otherHashAlgAndValue) {
        this(dERObjectIdentifier, otherHashAlgAndValue, (SigPolicyQualifiers) null);
    }

    public SignaturePolicyId(DERObjectIdentifier dERObjectIdentifier, OtherHashAlgAndValue otherHashAlgAndValue, SigPolicyQualifiers sigPolicyQualifiers2) {
        this.sigPolicyId = dERObjectIdentifier;
        this.sigPolicyHash = otherHashAlgAndValue;
        this.sigPolicyQualifiers = sigPolicyQualifiers2;
    }

    public ASN1ObjectIdentifier getSigPolicyId() {
        return new ASN1ObjectIdentifier(this.sigPolicyId.getId());
    }

    public OtherHashAlgAndValue getSigPolicyHash() {
        return this.sigPolicyHash;
    }

    public SigPolicyQualifiers getSigPolicyQualifiers() {
        return this.sigPolicyQualifiers;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.sigPolicyId);
        aSN1EncodableVector.add(this.sigPolicyHash);
        SigPolicyQualifiers sigPolicyQualifiers2 = this.sigPolicyQualifiers;
        if (sigPolicyQualifiers2 != null) {
            aSN1EncodableVector.add(sigPolicyQualifiers2);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
