package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class RecipientIdentifier extends ASN1Encodable implements ASN1Choice {

    /* renamed from: id */
    private DEREncodable f5832id;

    public RecipientIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f5832id = issuerAndSerialNumber;
    }

    public RecipientIdentifier(ASN1OctetString aSN1OctetString) {
        this.f5832id = new DERTaggedObject(false, 0, aSN1OctetString);
    }

    public RecipientIdentifier(DERObject dERObject) {
        this.f5832id = dERObject;
    }

    public static RecipientIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof RecipientIdentifier)) {
            return (RecipientIdentifier) obj;
        }
        if (obj instanceof IssuerAndSerialNumber) {
            return new RecipientIdentifier((IssuerAndSerialNumber) obj);
        }
        if (obj instanceof ASN1OctetString) {
            return new RecipientIdentifier((ASN1OctetString) obj);
        }
        if (obj instanceof DERObject) {
            return new RecipientIdentifier((DERObject) obj);
        }
        throw new IllegalArgumentException("Illegal object in RecipientIdentifier: " + obj.getClass().getName());
    }

    public boolean isTagged() {
        return this.f5832id instanceof ASN1TaggedObject;
    }

    public DEREncodable getId() {
        DEREncodable dEREncodable = this.f5832id;
        if (dEREncodable instanceof ASN1TaggedObject) {
            return ASN1OctetString.getInstance((ASN1TaggedObject) dEREncodable, false);
        }
        return IssuerAndSerialNumber.getInstance(dEREncodable);
    }

    public DERObject toASN1Object() {
        return this.f5832id.getDERObject();
    }
}
