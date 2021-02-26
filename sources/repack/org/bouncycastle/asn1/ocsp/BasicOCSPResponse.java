package repack.org.bouncycastle.asn1.ocsp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class BasicOCSPResponse extends ASN1Encodable {
    private ASN1Sequence certs;
    private DERBitString signature;
    private AlgorithmIdentifier signatureAlgorithm;
    private ResponseData tbsResponseData;

    public BasicOCSPResponse(ResponseData responseData, AlgorithmIdentifier algorithmIdentifier, DERBitString dERBitString, ASN1Sequence aSN1Sequence) {
        this.tbsResponseData = responseData;
        this.signatureAlgorithm = algorithmIdentifier;
        this.signature = dERBitString;
        this.certs = aSN1Sequence;
    }

    public BasicOCSPResponse(ASN1Sequence aSN1Sequence) {
        this.tbsResponseData = ResponseData.getInstance(aSN1Sequence.getObjectAt(0));
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.signature = (DERBitString) aSN1Sequence.getObjectAt(2);
        if (aSN1Sequence.size() > 3) {
            this.certs = ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(3), true);
        }
    }

    public static BasicOCSPResponse getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static BasicOCSPResponse getInstance(Object obj) {
        if (obj == null || (obj instanceof BasicOCSPResponse)) {
            return (BasicOCSPResponse) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new BasicOCSPResponse((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public ResponseData getTbsResponseData() {
        return this.tbsResponseData;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public DERBitString getSignature() {
        return this.signature;
    }

    public ASN1Sequence getCerts() {
        return this.certs;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.tbsResponseData);
        aSN1EncodableVector.add(this.signatureAlgorithm);
        aSN1EncodableVector.add(this.signature);
        ASN1Sequence aSN1Sequence = this.certs;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, aSN1Sequence));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
