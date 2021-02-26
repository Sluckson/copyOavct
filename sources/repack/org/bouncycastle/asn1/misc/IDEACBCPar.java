package repack.org.bouncycastle.asn1.misc;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;

public class IDEACBCPar extends ASN1Encodable {

    /* renamed from: iv */
    ASN1OctetString f5845iv;

    public static IDEACBCPar getInstance(Object obj) {
        if (obj instanceof IDEACBCPar) {
            return (IDEACBCPar) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new IDEACBCPar((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in IDEACBCPar factory");
    }

    public IDEACBCPar(byte[] bArr) {
        this.f5845iv = new DEROctetString(bArr);
    }

    public IDEACBCPar(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1) {
            this.f5845iv = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        } else {
            this.f5845iv = null;
        }
    }

    public byte[] getIV() {
        ASN1OctetString aSN1OctetString = this.f5845iv;
        if (aSN1OctetString != null) {
            return aSN1OctetString.getOctets();
        }
        return null;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1OctetString aSN1OctetString = this.f5845iv;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(aSN1OctetString);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
