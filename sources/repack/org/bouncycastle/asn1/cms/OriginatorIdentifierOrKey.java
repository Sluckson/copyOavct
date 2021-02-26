package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.SubjectKeyIdentifier;

public class OriginatorIdentifierOrKey extends ASN1Encodable implements ASN1Choice {

    /* renamed from: id */
    private DEREncodable f5831id;

    public OriginatorIdentifierOrKey(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f5831id = issuerAndSerialNumber;
    }

    public OriginatorIdentifierOrKey(ASN1OctetString aSN1OctetString) {
        this(new SubjectKeyIdentifier(aSN1OctetString));
    }

    public OriginatorIdentifierOrKey(SubjectKeyIdentifier subjectKeyIdentifier) {
        this.f5831id = new DERTaggedObject(false, 0, subjectKeyIdentifier);
    }

    public OriginatorIdentifierOrKey(OriginatorPublicKey originatorPublicKey) {
        this.f5831id = new DERTaggedObject(false, 1, originatorPublicKey);
    }

    public OriginatorIdentifierOrKey(DERObject dERObject) {
        this.f5831id = dERObject;
    }

    public static OriginatorIdentifierOrKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException("Can't implicitly tag OriginatorIdentifierOrKey");
    }

    public static OriginatorIdentifierOrKey getInstance(Object obj) {
        if (obj == null || (obj instanceof OriginatorIdentifierOrKey)) {
            return (OriginatorIdentifierOrKey) obj;
        }
        if (obj instanceof IssuerAndSerialNumber) {
            return new OriginatorIdentifierOrKey((IssuerAndSerialNumber) obj);
        }
        if (obj instanceof SubjectKeyIdentifier) {
            return new OriginatorIdentifierOrKey((SubjectKeyIdentifier) obj);
        }
        if (obj instanceof OriginatorPublicKey) {
            return new OriginatorIdentifierOrKey((OriginatorPublicKey) obj);
        }
        if (obj instanceof ASN1TaggedObject) {
            return new OriginatorIdentifierOrKey((DERObject) (ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("Invalid OriginatorIdentifierOrKey: " + obj.getClass().getName());
    }

    public DEREncodable getId() {
        return this.f5831id;
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        DEREncodable dEREncodable = this.f5831id;
        if (dEREncodable instanceof IssuerAndSerialNumber) {
            return (IssuerAndSerialNumber) dEREncodable;
        }
        return null;
    }

    public SubjectKeyIdentifier getSubjectKeyIdentifier() {
        DEREncodable dEREncodable = this.f5831id;
        if (!(dEREncodable instanceof ASN1TaggedObject) || ((ASN1TaggedObject) dEREncodable).getTagNo() != 0) {
            return null;
        }
        return SubjectKeyIdentifier.getInstance((ASN1TaggedObject) this.f5831id, false);
    }

    public OriginatorPublicKey getOriginatorKey() {
        DEREncodable dEREncodable = this.f5831id;
        if (!(dEREncodable instanceof ASN1TaggedObject) || ((ASN1TaggedObject) dEREncodable).getTagNo() != 1) {
            return null;
        }
        return OriginatorPublicKey.getInstance((ASN1TaggedObject) this.f5831id, false);
    }

    public DERObject toASN1Object() {
        return this.f5831id.getDERObject();
    }
}
