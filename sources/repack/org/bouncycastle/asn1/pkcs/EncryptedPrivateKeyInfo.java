package repack.org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedPrivateKeyInfo extends ASN1Encodable {
    private AlgorithmIdentifier algId;
    private ASN1OctetString data;

    public EncryptedPrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(objects.nextElement());
        this.data = (ASN1OctetString) objects.nextElement();
    }

    public EncryptedPrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.algId = algorithmIdentifier;
        this.data = new DEROctetString(bArr);
    }

    public static EncryptedPrivateKeyInfo getInstance(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedPrivateKeyInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new EncryptedPrivateKeyInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return this.algId;
    }

    public byte[] getEncryptedData() {
        return this.data.getOctets();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.algId);
        aSN1EncodableVector.add(this.data);
        return new DERSequence(aSN1EncodableVector);
    }
}
