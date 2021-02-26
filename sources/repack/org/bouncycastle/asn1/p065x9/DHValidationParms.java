package repack.org.bouncycastle.asn1.p065x9;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

/* renamed from: repack.org.bouncycastle.asn1.x9.DHValidationParms */
public class DHValidationParms extends ASN1Encodable {
    private DERInteger pgenCounter;
    private DERBitString seed;

    public static DHValidationParms getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static DHValidationParms getInstance(Object obj) {
        if (obj == null || (obj instanceof DHDomainParameters)) {
            return (DHValidationParms) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DHValidationParms((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid DHValidationParms: " + obj.getClass().getName());
    }

    public DHValidationParms(DERBitString dERBitString, DERInteger dERInteger) {
        if (dERBitString == null) {
            throw new IllegalArgumentException("'seed' cannot be null");
        } else if (dERInteger != null) {
            this.seed = dERBitString;
            this.pgenCounter = dERInteger;
        } else {
            throw new IllegalArgumentException("'pgenCounter' cannot be null");
        }
    }

    private DHValidationParms(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.seed = DERBitString.getInstance(aSN1Sequence.getObjectAt(0));
            this.pgenCounter = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public DERBitString getSeed() {
        return this.seed;
    }

    public DERInteger getPgenCounter() {
        return this.pgenCounter;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.seed);
        aSN1EncodableVector.add(this.pgenCounter);
        return new DERSequence(aSN1EncodableVector);
    }
}
