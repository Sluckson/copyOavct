package repack.org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.BERSequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class EnvelopedData extends ASN1Encodable {
    private EncryptedContentInfo encryptedContentInfo;
    private OriginatorInfo originatorInfo;
    private ASN1Set recipientInfos;
    private ASN1Set unprotectedAttrs;
    private DERInteger version;

    public EnvelopedData(OriginatorInfo originatorInfo2, ASN1Set aSN1Set, EncryptedContentInfo encryptedContentInfo2, ASN1Set aSN1Set2) {
        if (originatorInfo2 == null && aSN1Set2 == null) {
            this.version = new DERInteger(0);
            Enumeration objects = aSN1Set.getObjects();
            while (true) {
                if (objects.hasMoreElements()) {
                    if (!RecipientInfo.getInstance(objects.nextElement()).getVersion().equals(this.version)) {
                        this.version = new DERInteger(2);
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            this.version = new DERInteger(2);
        }
        this.originatorInfo = originatorInfo2;
        this.recipientInfos = aSN1Set;
        this.encryptedContentInfo = encryptedContentInfo2;
        this.unprotectedAttrs = aSN1Set2;
    }

    public EnvelopedData(ASN1Sequence aSN1Sequence) {
        this.version = (DERInteger) aSN1Sequence.getObjectAt(0);
        DEREncodable objectAt = aSN1Sequence.getObjectAt(1);
        int i = 2;
        if (objectAt instanceof ASN1TaggedObject) {
            this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject) objectAt, false);
            objectAt = aSN1Sequence.getObjectAt(2);
            i = 3;
        }
        this.recipientInfos = ASN1Set.getInstance(objectAt);
        int i2 = i + 1;
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(i));
        if (aSN1Sequence.size() > i2) {
            this.unprotectedAttrs = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i2), false);
        }
    }

    public static EnvelopedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static EnvelopedData getInstance(Object obj) {
        if (obj == null || (obj instanceof EnvelopedData)) {
            return (EnvelopedData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new EnvelopedData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid EnvelopedData: " + obj.getClass().getName());
    }

    public DERInteger getVersion() {
        return this.version;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public ASN1Set getRecipientInfos() {
        return this.recipientInfos;
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
        OriginatorInfo originatorInfo2 = this.originatorInfo;
        if (originatorInfo2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, originatorInfo2));
        }
        aSN1EncodableVector.add(this.recipientInfos);
        aSN1EncodableVector.add(this.encryptedContentInfo);
        ASN1Set aSN1Set = this.unprotectedAttrs;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Set));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
