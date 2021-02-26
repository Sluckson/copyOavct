package repack.org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.DigestInfo;

public class MacData extends ASN1Encodable {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    DigestInfo digInfo;
    BigInteger iterationCount;
    byte[] salt;

    public static MacData getInstance(Object obj) {
        if (obj instanceof MacData) {
            return (MacData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new MacData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public MacData(ASN1Sequence aSN1Sequence) {
        this.digInfo = DigestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.salt = ((ASN1OctetString) aSN1Sequence.getObjectAt(1)).getOctets();
        if (aSN1Sequence.size() == 3) {
            this.iterationCount = ((DERInteger) aSN1Sequence.getObjectAt(2)).getValue();
        } else {
            this.iterationCount = ONE;
        }
    }

    public MacData(DigestInfo digestInfo, byte[] bArr, int i) {
        this.digInfo = digestInfo;
        this.salt = bArr;
        this.iterationCount = BigInteger.valueOf((long) i);
    }

    public DigestInfo getMac() {
        return this.digInfo;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public BigInteger getIterationCount() {
        return this.iterationCount;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.digInfo);
        aSN1EncodableVector.add(new DEROctetString(this.salt));
        if (!this.iterationCount.equals(ONE)) {
            aSN1EncodableVector.add(new DERInteger(this.iterationCount));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
