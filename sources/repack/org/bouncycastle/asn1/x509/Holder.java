package repack.org.bouncycastle.asn1.x509;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class Holder extends ASN1Encodable {
    IssuerSerial baseCertificateID;
    GeneralNames entityName;
    ObjectDigestInfo objectDigestInfo;
    private int version = 1;

    public static Holder getInstance(Object obj) {
        if (obj instanceof Holder) {
            return (Holder) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new Holder((ASN1Sequence) obj);
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Holder((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public Holder(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.baseCertificateID = IssuerSerial.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 1) {
            this.entityName = GeneralNames.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag in Holder");
        }
        this.version = 0;
    }

    public Holder(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() <= 3) {
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                int tagNo = instance.getTagNo();
                if (tagNo == 0) {
                    this.baseCertificateID = IssuerSerial.getInstance(instance, false);
                } else if (tagNo == 1) {
                    this.entityName = GeneralNames.getInstance(instance, false);
                } else if (tagNo == 2) {
                    this.objectDigestInfo = ObjectDigestInfo.getInstance(instance, false);
                } else {
                    throw new IllegalArgumentException("unknown tag in Holder");
                }
            }
            this.version = 1;
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public Holder(IssuerSerial issuerSerial) {
        this.baseCertificateID = issuerSerial;
    }

    public Holder(IssuerSerial issuerSerial, int i) {
        this.baseCertificateID = issuerSerial;
        this.version = i;
    }

    public int getVersion() {
        return this.version;
    }

    public Holder(GeneralNames generalNames) {
        this.entityName = generalNames;
    }

    public Holder(GeneralNames generalNames, int i) {
        this.entityName = generalNames;
        this.version = i;
    }

    public Holder(ObjectDigestInfo objectDigestInfo2) {
        this.objectDigestInfo = objectDigestInfo2;
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getEntityName() {
        return this.entityName;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.objectDigestInfo;
    }

    public DERObject toASN1Object() {
        if (this.version == 1) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            IssuerSerial issuerSerial = this.baseCertificateID;
            if (issuerSerial != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, 0, issuerSerial));
            }
            GeneralNames generalNames = this.entityName;
            if (generalNames != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, 1, generalNames));
            }
            ObjectDigestInfo objectDigestInfo2 = this.objectDigestInfo;
            if (objectDigestInfo2 != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, 2, objectDigestInfo2));
            }
            return new DERSequence(aSN1EncodableVector);
        }
        GeneralNames generalNames2 = this.entityName;
        if (generalNames2 != null) {
            return new DERTaggedObject(false, 1, generalNames2);
        }
        return new DERTaggedObject(false, 0, this.baseCertificateID);
    }
}
