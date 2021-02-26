package repack.org.bouncycastle.asn1.crmf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERUTF8String;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.x509.GeneralName;

public class EncKeyWithID extends ASN1Encodable {
    private final ASN1Encodable identifier;
    private final PrivateKeyInfo privKeyInfo;

    public static EncKeyWithID getInstance(Object obj) {
        if (obj instanceof EncKeyWithID) {
            return (EncKeyWithID) obj;
        }
        if (obj != null) {
            return new EncKeyWithID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private EncKeyWithID(ASN1Sequence aSN1Sequence) {
        this.privKeyInfo = PrivateKeyInfo.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() <= 1) {
            this.identifier = null;
        } else if (!(aSN1Sequence.getObjectAt(1) instanceof DERUTF8String)) {
            this.identifier = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            this.identifier = (ASN1Encodable) aSN1Sequence.getObjectAt(1);
        }
    }

    public EncKeyWithID(PrivateKeyInfo privateKeyInfo) {
        this.privKeyInfo = privateKeyInfo;
        this.identifier = null;
    }

    public EncKeyWithID(PrivateKeyInfo privateKeyInfo, DERUTF8String dERUTF8String) {
        this.privKeyInfo = privateKeyInfo;
        this.identifier = dERUTF8String;
    }

    public EncKeyWithID(PrivateKeyInfo privateKeyInfo, GeneralName generalName) {
        this.privKeyInfo = privateKeyInfo;
        this.identifier = generalName;
    }

    public PrivateKeyInfo getPrivateKey() {
        return this.privKeyInfo;
    }

    public boolean hasIdentifier() {
        return this.identifier != null;
    }

    public boolean isIdentifierUTF8String() {
        return this.identifier instanceof DERUTF8String;
    }

    public ASN1Encodable getIdentifier() {
        return this.identifier;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.privKeyInfo);
        ASN1Encodable aSN1Encodable = this.identifier;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(aSN1Encodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
