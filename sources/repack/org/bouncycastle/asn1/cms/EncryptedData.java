package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.BERSequence;
import repack.org.bouncycastle.asn1.BERTaggedObject;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;

public class EncryptedData extends ASN1Encodable {
    private EncryptedContentInfo encryptedContentInfo;
    private ASN1Set unprotectedAttrs;
    private DERInteger version;

    public static EncryptedData getInstance(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new EncryptedData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid EncryptedData: " + obj.getClass().getName());
    }

    public EncryptedData(EncryptedContentInfo encryptedContentInfo2) {
        this(encryptedContentInfo2, (ASN1Set) null);
    }

    public EncryptedData(EncryptedContentInfo encryptedContentInfo2, ASN1Set aSN1Set) {
        this.version = new DERInteger(aSN1Set == null ? 0 : 2);
        this.encryptedContentInfo = encryptedContentInfo2;
        this.unprotectedAttrs = aSN1Set;
    }

    private EncryptedData(ASN1Sequence aSN1Sequence) {
        this.version = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() == 3) {
            this.unprotectedAttrs = ASN1Set.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public DERInteger getVersion() {
        return this.version;
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.encryptedContentInfo);
        ASN1Set aSN1Set = this.unprotectedAttrs;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new BERTaggedObject(false, 1, aSN1Set));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
