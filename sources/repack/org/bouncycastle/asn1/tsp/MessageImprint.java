package repack.org.bouncycastle.asn1.tsp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class MessageImprint extends ASN1Encodable {
    AlgorithmIdentifier hashAlgorithm;
    byte[] hashedMessage;

    public static MessageImprint getInstance(Object obj) {
        if (obj == null || (obj instanceof MessageImprint)) {
            return (MessageImprint) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new MessageImprint((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Bad object in factory.");
    }

    public MessageImprint(ASN1Sequence aSN1Sequence) {
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.hashedMessage = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
    }

    public MessageImprint(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.hashAlgorithm = algorithmIdentifier;
        this.hashedMessage = bArr;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getHashedMessage() {
        return this.hashedMessage;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.hashAlgorithm);
        aSN1EncodableVector.add(new DEROctetString(this.hashedMessage));
        return new DERSequence(aSN1EncodableVector);
    }
}
