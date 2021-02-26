package repack.org.bouncycastle.asn1.misc;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;

public class CAST5CBCParameters extends ASN1Encodable {

    /* renamed from: iv */
    ASN1OctetString f5844iv;
    DERInteger keyLength;

    public static CAST5CBCParameters getInstance(Object obj) {
        if (obj instanceof CAST5CBCParameters) {
            return (CAST5CBCParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CAST5CBCParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in CAST5CBCParameter factory");
    }

    public CAST5CBCParameters(byte[] bArr, int i) {
        this.f5844iv = new DEROctetString(bArr);
        this.keyLength = new DERInteger(i);
    }

    public CAST5CBCParameters(ASN1Sequence aSN1Sequence) {
        this.f5844iv = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.keyLength = (DERInteger) aSN1Sequence.getObjectAt(1);
    }

    public byte[] getIV() {
        return this.f5844iv.getOctets();
    }

    public int getKeyLength() {
        return this.keyLength.getValue().intValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5844iv);
        aSN1EncodableVector.add(this.keyLength);
        return new DERSequence(aSN1EncodableVector);
    }
}
