package repack.org.bouncycastle.asn1.esf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class CommitmentTypeIndication extends ASN1Encodable {
    private DERObjectIdentifier commitmentTypeId;
    private ASN1Sequence commitmentTypeQualifier;

    public CommitmentTypeIndication(ASN1Sequence aSN1Sequence) {
        this.commitmentTypeId = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        if (aSN1Sequence.size() > 1) {
            this.commitmentTypeQualifier = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
        }
    }

    public CommitmentTypeIndication(DERObjectIdentifier dERObjectIdentifier) {
        this.commitmentTypeId = dERObjectIdentifier;
    }

    public CommitmentTypeIndication(DERObjectIdentifier dERObjectIdentifier, ASN1Sequence aSN1Sequence) {
        this.commitmentTypeId = dERObjectIdentifier;
        this.commitmentTypeQualifier = aSN1Sequence;
    }

    public static CommitmentTypeIndication getInstance(Object obj) {
        if (obj == null || (obj instanceof CommitmentTypeIndication)) {
            return (CommitmentTypeIndication) obj;
        }
        return new CommitmentTypeIndication(ASN1Sequence.getInstance(obj));
    }

    public DERObjectIdentifier getCommitmentTypeId() {
        return this.commitmentTypeId;
    }

    public ASN1Sequence getCommitmentTypeQualifier() {
        return this.commitmentTypeQualifier;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.commitmentTypeId);
        ASN1Sequence aSN1Sequence = this.commitmentTypeQualifier;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
