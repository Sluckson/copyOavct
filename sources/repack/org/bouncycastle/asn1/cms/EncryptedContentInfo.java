package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.BERSequence;
import repack.org.bouncycastle.asn1.BERTaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedContentInfo extends ASN1Encodable {
    private AlgorithmIdentifier contentEncryptionAlgorithm;
    private DERObjectIdentifier contentType;
    private ASN1OctetString encryptedContent;

    public EncryptedContentInfo(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        this.contentType = dERObjectIdentifier;
        this.contentEncryptionAlgorithm = algorithmIdentifier;
        this.encryptedContent = aSN1OctetString;
    }

    public EncryptedContentInfo(ASN1Sequence aSN1Sequence) {
        this.contentType = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.encryptedContent = ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(2), false);
        }
    }

    public static EncryptedContentInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof EncryptedContentInfo)) {
            return (EncryptedContentInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new EncryptedContentInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid EncryptedContentInfo: " + obj.getClass().getName());
    }

    public DERObjectIdentifier getContentType() {
        return this.contentType;
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this.contentEncryptionAlgorithm;
    }

    public ASN1OctetString getEncryptedContent() {
        return this.encryptedContent;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.contentType);
        aSN1EncodableVector.add(this.contentEncryptionAlgorithm);
        ASN1OctetString aSN1OctetString = this.encryptedContent;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(new BERTaggedObject(false, 0, aSN1OctetString));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
