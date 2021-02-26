package repack.org.bouncycastle.asn1.smime;

import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.cms.Attribute;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.cms.RecipientKeyIdentifier;

public class SMIMEEncryptionKeyPreferenceAttribute extends Attribute {
    public SMIMEEncryptionKeyPreferenceAttribute(IssuerAndSerialNumber issuerAndSerialNumber) {
        super(SMIMEAttributes.encrypKeyPref, new DERSet((DEREncodable) new DERTaggedObject(false, 0, issuerAndSerialNumber)));
    }

    public SMIMEEncryptionKeyPreferenceAttribute(RecipientKeyIdentifier recipientKeyIdentifier) {
        super(SMIMEAttributes.encrypKeyPref, new DERSet((DEREncodable) new DERTaggedObject(false, 1, recipientKeyIdentifier)));
    }

    public SMIMEEncryptionKeyPreferenceAttribute(ASN1OctetString aSN1OctetString) {
        super(SMIMEAttributes.encrypKeyPref, new DERSet((DEREncodable) new DERTaggedObject(false, 2, aSN1OctetString)));
    }
}
