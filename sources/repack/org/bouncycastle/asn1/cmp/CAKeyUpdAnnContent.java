package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class CAKeyUpdAnnContent extends ASN1Encodable {
    private CMPCertificate newWithNew;
    private CMPCertificate newWithOld;
    private CMPCertificate oldWithNew;

    private CAKeyUpdAnnContent(ASN1Sequence aSN1Sequence) {
        this.oldWithNew = CMPCertificate.getInstance(aSN1Sequence.getObjectAt(0));
        this.newWithOld = CMPCertificate.getInstance(aSN1Sequence.getObjectAt(1));
        this.newWithNew = CMPCertificate.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static CAKeyUpdAnnContent getInstance(Object obj) {
        if (obj instanceof CAKeyUpdAnnContent) {
            return (CAKeyUpdAnnContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CAKeyUpdAnnContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CMPCertificate getOldWithNew() {
        return this.oldWithNew;
    }

    public CMPCertificate getNewWithOld() {
        return this.newWithOld;
    }

    public CMPCertificate getNewWithNew() {
        return this.newWithNew;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.oldWithNew);
        aSN1EncodableVector.add(this.newWithOld);
        aSN1EncodableVector.add(this.newWithNew);
        return new DERSequence(aSN1EncodableVector);
    }
}