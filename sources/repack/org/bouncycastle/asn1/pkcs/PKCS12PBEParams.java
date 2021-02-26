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

public class PKCS12PBEParams extends ASN1Encodable {
    DERInteger iterations;

    /* renamed from: iv */
    ASN1OctetString f5853iv;

    public PKCS12PBEParams(byte[] bArr, int i) {
        this.f5853iv = new DEROctetString(bArr);
        this.iterations = new DERInteger(i);
    }

    public PKCS12PBEParams(ASN1Sequence aSN1Sequence) {
        this.f5853iv = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.iterations = (DERInteger) aSN1Sequence.getObjectAt(1);
    }

    public static PKCS12PBEParams getInstance(Object obj) {
        if (obj instanceof PKCS12PBEParams) {
            return (PKCS12PBEParams) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PKCS12PBEParams((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public BigInteger getIterations() {
        return this.iterations.getValue();
    }

    public byte[] getIV() {
        return this.f5853iv.getOctets();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5853iv);
        aSN1EncodableVector.add(this.iterations);
        return new DERSequence(aSN1EncodableVector);
    }
}
