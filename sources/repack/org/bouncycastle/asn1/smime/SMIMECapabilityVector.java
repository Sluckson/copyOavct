package repack.org.bouncycastle.asn1.smime;

import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class SMIMECapabilityVector {
    private ASN1EncodableVector capabilities = new ASN1EncodableVector();

    public void addCapability(DERObjectIdentifier dERObjectIdentifier) {
        this.capabilities.add(new DERSequence((DEREncodable) dERObjectIdentifier));
    }

    public void addCapability(DERObjectIdentifier dERObjectIdentifier, int i) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(dERObjectIdentifier);
        aSN1EncodableVector.add(new DERInteger(i));
        this.capabilities.add(new DERSequence(aSN1EncodableVector));
    }

    public void addCapability(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(dERObjectIdentifier);
        aSN1EncodableVector.add(dEREncodable);
        this.capabilities.add(new DERSequence(aSN1EncodableVector));
    }

    public ASN1EncodableVector toASN1EncodableVector() {
        return this.capabilities;
    }
}
