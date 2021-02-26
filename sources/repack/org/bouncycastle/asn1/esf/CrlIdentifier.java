package repack.org.bouncycastle.asn1.esf;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERUTCTime;
import repack.org.bouncycastle.asn1.x500.X500Name;

public class CrlIdentifier extends ASN1Encodable {
    private DERUTCTime crlIssuedTime;
    private X500Name crlIssuer;
    private DERInteger crlNumber;

    public static CrlIdentifier getInstance(Object obj) {
        if (obj instanceof CrlIdentifier) {
            return (CrlIdentifier) obj;
        }
        if (obj != null) {
            return new CrlIdentifier(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance");
    }

    private CrlIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 3) {
            throw new IllegalArgumentException();
        }
        this.crlIssuer = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.crlIssuedTime = DERUTCTime.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.crlNumber = DERInteger.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public CrlIdentifier(X500Name x500Name, DERUTCTime dERUTCTime) {
        this(x500Name, dERUTCTime, (BigInteger) null);
    }

    public CrlIdentifier(X500Name x500Name, DERUTCTime dERUTCTime, BigInteger bigInteger) {
        this.crlIssuer = x500Name;
        this.crlIssuedTime = dERUTCTime;
        if (bigInteger != null) {
            this.crlNumber = new DERInteger(bigInteger);
        }
    }

    public X500Name getCrlIssuer() {
        return this.crlIssuer;
    }

    public DERUTCTime getCrlIssuedTime() {
        return this.crlIssuedTime;
    }

    public BigInteger getCrlNumber() {
        DERInteger dERInteger = this.crlNumber;
        if (dERInteger == null) {
            return null;
        }
        return dERInteger.getValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.crlIssuer.toASN1Object());
        aSN1EncodableVector.add(this.crlIssuedTime);
        DERInteger dERInteger = this.crlNumber;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
