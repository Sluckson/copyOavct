package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PBMParameter extends ASN1Encodable {
    private DERInteger iterationCount;
    private AlgorithmIdentifier mac;
    private AlgorithmIdentifier owf;
    private ASN1OctetString salt;

    private PBMParameter(ASN1Sequence aSN1Sequence) {
        this.salt = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.owf = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.iterationCount = DERInteger.getInstance(aSN1Sequence.getObjectAt(2));
        this.mac = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public static PBMParameter getInstance(Object obj) {
        if (obj instanceof PBMParameter) {
            return (PBMParameter) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PBMParameter((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public PBMParameter(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, int i, AlgorithmIdentifier algorithmIdentifier2) {
        this((ASN1OctetString) new DEROctetString(bArr), algorithmIdentifier, new DERInteger(i), algorithmIdentifier2);
    }

    public PBMParameter(ASN1OctetString aSN1OctetString, AlgorithmIdentifier algorithmIdentifier, DERInteger dERInteger, AlgorithmIdentifier algorithmIdentifier2) {
        this.salt = aSN1OctetString;
        this.owf = algorithmIdentifier;
        this.iterationCount = dERInteger;
        this.mac = algorithmIdentifier2;
    }

    public ASN1OctetString getSalt() {
        return this.salt;
    }

    public AlgorithmIdentifier getOwf() {
        return this.owf;
    }

    public DERInteger getIterationCount() {
        return this.iterationCount;
    }

    public AlgorithmIdentifier getMac() {
        return this.mac;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.salt);
        aSN1EncodableVector.add(this.owf);
        aSN1EncodableVector.add(this.iterationCount);
        aSN1EncodableVector.add(this.mac);
        return new DERSequence(aSN1EncodableVector);
    }
}
