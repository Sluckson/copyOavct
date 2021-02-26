package repack.org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SignerInfo extends ASN1Encodable {
    private ASN1Set authenticatedAttributes;
    private AlgorithmIdentifier digAlgorithm;
    private AlgorithmIdentifier digEncryptionAlgorithm;
    private ASN1OctetString encryptedDigest;
    private SignerIdentifier sid;
    private ASN1Set unauthenticatedAttributes;
    private DERInteger version;

    public static SignerInfo getInstance(Object obj) throws IllegalArgumentException {
        if (obj == null || (obj instanceof SignerInfo)) {
            return (SignerInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SignerInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public SignerInfo(SignerIdentifier signerIdentifier, AlgorithmIdentifier algorithmIdentifier, ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier2, ASN1OctetString aSN1OctetString, ASN1Set aSN1Set2) {
        if (signerIdentifier.isTagged()) {
            this.version = new DERInteger(3);
        } else {
            this.version = new DERInteger(1);
        }
        this.sid = signerIdentifier;
        this.digAlgorithm = algorithmIdentifier;
        this.authenticatedAttributes = aSN1Set;
        this.digEncryptionAlgorithm = algorithmIdentifier2;
        this.encryptedDigest = aSN1OctetString;
        this.unauthenticatedAttributes = aSN1Set2;
    }

    public SignerInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.version = (DERInteger) objects.nextElement();
        this.sid = SignerIdentifier.getInstance(objects.nextElement());
        this.digAlgorithm = AlgorithmIdentifier.getInstance(objects.nextElement());
        Object nextElement = objects.nextElement();
        if (nextElement instanceof ASN1TaggedObject) {
            this.authenticatedAttributes = ASN1Set.getInstance((ASN1TaggedObject) nextElement, false);
            this.digEncryptionAlgorithm = AlgorithmIdentifier.getInstance(objects.nextElement());
        } else {
            this.authenticatedAttributes = null;
            this.digEncryptionAlgorithm = AlgorithmIdentifier.getInstance(nextElement);
        }
        this.encryptedDigest = DEROctetString.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.unauthenticatedAttributes = ASN1Set.getInstance((ASN1TaggedObject) objects.nextElement(), false);
        } else {
            this.unauthenticatedAttributes = null;
        }
    }

    public DERInteger getVersion() {
        return this.version;
    }

    public SignerIdentifier getSID() {
        return this.sid;
    }

    public ASN1Set getAuthenticatedAttributes() {
        return this.authenticatedAttributes;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digAlgorithm;
    }

    public ASN1OctetString getEncryptedDigest() {
        return this.encryptedDigest;
    }

    public AlgorithmIdentifier getDigestEncryptionAlgorithm() {
        return this.digEncryptionAlgorithm;
    }

    public ASN1Set getUnauthenticatedAttributes() {
        return this.unauthenticatedAttributes;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.sid);
        aSN1EncodableVector.add(this.digAlgorithm);
        ASN1Set aSN1Set = this.authenticatedAttributes;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        aSN1EncodableVector.add(this.digEncryptionAlgorithm);
        aSN1EncodableVector.add(this.encryptedDigest);
        ASN1Set aSN1Set2 = this.unauthenticatedAttributes;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Set2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
