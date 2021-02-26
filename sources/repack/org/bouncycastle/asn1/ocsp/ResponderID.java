package repack.org.bouncycastle.asn1.ocsp;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x500.X500Name;

public class ResponderID extends ASN1Encodable implements ASN1Choice {
    private DEREncodable value;

    public ResponderID(ASN1OctetString aSN1OctetString) {
        this.value = aSN1OctetString;
    }

    public ResponderID(X500Name x500Name) {
        this.value = x500Name;
    }

    public static ResponderID getInstance(Object obj) {
        if (obj instanceof ResponderID) {
            return (ResponderID) obj;
        }
        if (obj instanceof DEROctetString) {
            return new ResponderID((ASN1OctetString) (DEROctetString) obj);
        }
        if (!(obj instanceof ASN1TaggedObject)) {
            return new ResponderID(X500Name.getInstance(obj));
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
        if (aSN1TaggedObject.getTagNo() == 1) {
            return new ResponderID(X500Name.getInstance(aSN1TaggedObject, true));
        }
        return new ResponderID(ASN1OctetString.getInstance(aSN1TaggedObject, true));
    }

    public static ResponderID getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public byte[] getKeyHash() {
        DEREncodable dEREncodable = this.value;
        if (dEREncodable instanceof ASN1OctetString) {
            return ((ASN1OctetString) dEREncodable).getOctets();
        }
        return null;
    }

    public X500Name getName() {
        DEREncodable dEREncodable = this.value;
        if (dEREncodable instanceof ASN1OctetString) {
            return null;
        }
        return X500Name.getInstance(dEREncodable);
    }

    public DERObject toASN1Object() {
        DEREncodable dEREncodable = this.value;
        if (dEREncodable instanceof ASN1OctetString) {
            return new DERTaggedObject(true, 2, dEREncodable);
        }
        return new DERTaggedObject(true, 1, dEREncodable);
    }
}
