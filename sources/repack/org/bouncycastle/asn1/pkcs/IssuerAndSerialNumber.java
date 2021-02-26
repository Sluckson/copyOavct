package repack.org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.X509Name;

public class IssuerAndSerialNumber extends ASN1Encodable {
    DERInteger certSerialNumber;
    X509Name name;

    public static IssuerAndSerialNumber getInstance(Object obj) {
        if (obj instanceof IssuerAndSerialNumber) {
            return (IssuerAndSerialNumber) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new IssuerAndSerialNumber((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public IssuerAndSerialNumber(ASN1Sequence aSN1Sequence) {
        this.name = X509Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.certSerialNumber = (DERInteger) aSN1Sequence.getObjectAt(1);
    }

    public IssuerAndSerialNumber(X509Name x509Name, BigInteger bigInteger) {
        this.name = x509Name;
        this.certSerialNumber = new DERInteger(bigInteger);
    }

    public IssuerAndSerialNumber(X509Name x509Name, DERInteger dERInteger) {
        this.name = x509Name;
        this.certSerialNumber = dERInteger;
    }

    public X509Name getName() {
        return this.name;
    }

    public DERInteger getCertificateSerialNumber() {
        return this.certSerialNumber;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.name);
        aSN1EncodableVector.add(this.certSerialNumber);
        return new DERSequence(aSN1EncodableVector);
    }
}
