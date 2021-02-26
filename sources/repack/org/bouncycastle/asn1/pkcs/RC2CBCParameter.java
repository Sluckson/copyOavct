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

public class RC2CBCParameter extends ASN1Encodable {

    /* renamed from: iv */
    ASN1OctetString f5854iv;
    DERInteger version;

    public static RC2CBCParameter getInstance(Object obj) {
        if (obj instanceof ASN1Sequence) {
            return new RC2CBCParameter((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in RC2CBCParameter factory");
    }

    public RC2CBCParameter(byte[] bArr) {
        this.version = null;
        this.f5854iv = new DEROctetString(bArr);
    }

    public RC2CBCParameter(int i, byte[] bArr) {
        this.version = new DERInteger(i);
        this.f5854iv = new DEROctetString(bArr);
    }

    public RC2CBCParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1) {
            this.version = null;
            this.f5854iv = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
            return;
        }
        this.version = (DERInteger) aSN1Sequence.getObjectAt(0);
        this.f5854iv = (ASN1OctetString) aSN1Sequence.getObjectAt(1);
    }

    public BigInteger getRC2ParameterVersion() {
        DERInteger dERInteger = this.version;
        if (dERInteger == null) {
            return null;
        }
        return dERInteger.getValue();
    }

    public byte[] getIV() {
        return this.f5854iv.getOctets();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERInteger dERInteger = this.version;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        aSN1EncodableVector.add(this.f5854iv);
        return new DERSequence(aSN1EncodableVector);
    }
}
