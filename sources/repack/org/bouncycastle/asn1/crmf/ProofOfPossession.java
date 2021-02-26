package repack.org.bouncycastle.asn1.crmf;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class ProofOfPossession extends ASN1Encodable implements ASN1Choice {
    public static final int TYPE_KEY_AGREEMENT = 3;
    public static final int TYPE_KEY_ENCIPHERMENT = 2;
    public static final int TYPE_RA_VERIFIED = 0;
    public static final int TYPE_SIGNING_KEY = 1;
    private ASN1Encodable obj;
    private int tagNo;

    private ProofOfPossession(ASN1TaggedObject aSN1TaggedObject) {
        this.tagNo = aSN1TaggedObject.getTagNo();
        int i = this.tagNo;
        if (i == 0) {
            this.obj = DERNull.INSTANCE;
        } else if (i == 1) {
            this.obj = POPOSigningKey.getInstance(aSN1TaggedObject, false);
        } else if (i == 2 || i == 3) {
            this.obj = POPOPrivKey.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag: " + this.tagNo);
        }
    }

    public static ProofOfPossession getInstance(Object obj2) {
        if (obj2 instanceof ProofOfPossession) {
            return (ProofOfPossession) obj2;
        }
        if (obj2 instanceof ASN1TaggedObject) {
            return new ProofOfPossession((ASN1TaggedObject) obj2);
        }
        throw new IllegalArgumentException("Invalid object: " + obj2.getClass().getName());
    }

    public ProofOfPossession() {
        this.tagNo = 0;
        this.obj = DERNull.INSTANCE;
    }

    public ProofOfPossession(POPOSigningKey pOPOSigningKey) {
        this.tagNo = 1;
        this.obj = pOPOSigningKey;
    }

    public ProofOfPossession(int i, POPOPrivKey pOPOPrivKey) {
        this.tagNo = i;
        this.obj = pOPOPrivKey;
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Encodable getObject() {
        return this.obj;
    }

    public DERObject toASN1Object() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}
