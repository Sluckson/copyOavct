package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class SignerIdentifier extends ASN1Encodable implements ASN1Choice {

    /* renamed from: id */
    private DEREncodable f5833id;

    public SignerIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f5833id = issuerAndSerialNumber;
    }

    public SignerIdentifier(ASN1OctetString aSN1OctetString) {
        this.f5833id = new DERTaggedObject(false, 0, aSN1OctetString);
    }

    public SignerIdentifier(DERObject dERObject) {
        this.f5833id = dERObject;
    }

    public static SignerIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof SignerIdentifier)) {
            return (SignerIdentifier) obj;
        }
        if (obj instanceof IssuerAndSerialNumber) {
            return new SignerIdentifier((IssuerAndSerialNumber) obj);
        }
        if (obj instanceof ASN1OctetString) {
            return new SignerIdentifier((ASN1OctetString) obj);
        }
        if (obj instanceof DERObject) {
            return new SignerIdentifier((DERObject) obj);
        }
        throw new IllegalArgumentException("Illegal object in SignerIdentifier: " + obj.getClass().getName());
    }

    public boolean isTagged() {
        return this.f5833id instanceof ASN1TaggedObject;
    }

    public DEREncodable getId() {
        DEREncodable dEREncodable = this.f5833id;
        return dEREncodable instanceof ASN1TaggedObject ? ASN1OctetString.getInstance((ASN1TaggedObject) dEREncodable, false) : dEREncodable;
    }

    public DERObject toASN1Object() {
        return this.f5833id.getDERObject();
    }
}
