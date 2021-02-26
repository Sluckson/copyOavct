package repack.org.bouncycastle.asn1.pkcs;

import java.io.IOException;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PrivateKeyInfo extends ASN1Encodable {
    private AlgorithmIdentifier algId;
    private ASN1Set attributes;
    private DERObject privKey;

    public static PrivateKeyInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static PrivateKeyInfo getInstance(Object obj) {
        if (obj instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new PrivateKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, DERObject dERObject) {
        this(algorithmIdentifier, dERObject, (ASN1Set) null);
    }

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, DERObject dERObject, ASN1Set aSN1Set) {
        this.privKey = dERObject;
        this.algId = algorithmIdentifier;
        this.attributes = aSN1Set;
    }

    public PrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        if (((DERInteger) objects.nextElement()).getValue().intValue() == 0) {
            this.algId = new AlgorithmIdentifier((ASN1Sequence) objects.nextElement());
            try {
                this.privKey = new ASN1InputStream(((ASN1OctetString) objects.nextElement()).getOctets()).readObject();
                if (objects.hasMoreElements()) {
                    this.attributes = ASN1Set.getInstance((ASN1TaggedObject) objects.nextElement(), false);
                }
            } catch (IOException unused) {
                throw new IllegalArgumentException("Error recoverying private key from sequence");
            }
        } else {
            throw new IllegalArgumentException("wrong version for private key info");
        }
    }

    public AlgorithmIdentifier getAlgorithmId() {
        return this.algId;
    }

    public DERObject getPrivateKey() {
        return this.privKey;
    }

    public ASN1Set getAttributes() {
        return this.attributes;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(0));
        aSN1EncodableVector.add(this.algId);
        aSN1EncodableVector.add(new DEROctetString((DEREncodable) this.privKey));
        ASN1Set aSN1Set = this.attributes;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
