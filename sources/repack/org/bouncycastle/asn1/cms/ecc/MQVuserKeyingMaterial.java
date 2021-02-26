package repack.org.bouncycastle.asn1.cms.ecc;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.cms.OriginatorPublicKey;

public class MQVuserKeyingMaterial extends ASN1Encodable {
    private ASN1OctetString addedukm;
    private OriginatorPublicKey ephemeralPublicKey;

    public MQVuserKeyingMaterial(OriginatorPublicKey originatorPublicKey, ASN1OctetString aSN1OctetString) {
        this.ephemeralPublicKey = originatorPublicKey;
        this.addedukm = aSN1OctetString;
    }

    private MQVuserKeyingMaterial(ASN1Sequence aSN1Sequence) {
        this.ephemeralPublicKey = OriginatorPublicKey.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.addedukm = ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
        }
    }

    public static MQVuserKeyingMaterial getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static MQVuserKeyingMaterial getInstance(Object obj) {
        if (obj == null || (obj instanceof MQVuserKeyingMaterial)) {
            return (MQVuserKeyingMaterial) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new MQVuserKeyingMaterial((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid MQVuserKeyingMaterial: " + obj.getClass().getName());
    }

    public OriginatorPublicKey getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public ASN1OctetString getAddedukm() {
        return this.addedukm;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.ephemeralPublicKey);
        ASN1OctetString aSN1OctetString = this.addedukm;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, aSN1OctetString));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
