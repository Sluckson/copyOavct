package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class KeyAgreeRecipientIdentifier extends ASN1Encodable implements ASN1Choice {
    private IssuerAndSerialNumber issuerSerial;
    private RecipientKeyIdentifier rKeyID;

    public static KeyAgreeRecipientIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static KeyAgreeRecipientIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof KeyAgreeRecipientIdentifier)) {
            return (KeyAgreeRecipientIdentifier) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new KeyAgreeRecipientIdentifier(IssuerAndSerialNumber.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
            if (aSN1TaggedObject.getTagNo() == 0) {
                return new KeyAgreeRecipientIdentifier(RecipientKeyIdentifier.getInstance(aSN1TaggedObject, false));
            }
        }
        throw new IllegalArgumentException("Invalid KeyAgreeRecipientIdentifier: " + obj.getClass().getName());
    }

    public KeyAgreeRecipientIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.issuerSerial = issuerAndSerialNumber;
        this.rKeyID = null;
    }

    public KeyAgreeRecipientIdentifier(RecipientKeyIdentifier recipientKeyIdentifier) {
        this.issuerSerial = null;
        this.rKeyID = recipientKeyIdentifier;
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return this.issuerSerial;
    }

    public RecipientKeyIdentifier getRKeyID() {
        return this.rKeyID;
    }

    public DERObject toASN1Object() {
        IssuerAndSerialNumber issuerAndSerialNumber = this.issuerSerial;
        if (issuerAndSerialNumber != null) {
            return issuerAndSerialNumber.toASN1Object();
        }
        return new DERTaggedObject(false, 0, this.rKeyID);
    }
}
