package repack.org.bouncycastle.asn1.tsp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class Accuracy extends ASN1Encodable {
    protected static final int MAX_MICROS = 999;
    protected static final int MAX_MILLIS = 999;
    protected static final int MIN_MICROS = 1;
    protected static final int MIN_MILLIS = 1;
    DERInteger micros;
    DERInteger millis;
    DERInteger seconds;

    protected Accuracy() {
    }

    public Accuracy(DERInteger dERInteger, DERInteger dERInteger2, DERInteger dERInteger3) {
        this.seconds = dERInteger;
        if (dERInteger2 == null || (dERInteger2.getValue().intValue() >= 1 && dERInteger2.getValue().intValue() <= 999)) {
            this.millis = dERInteger2;
            if (dERInteger3 == null || (dERInteger3.getValue().intValue() >= 1 && dERInteger3.getValue().intValue() <= 999)) {
                this.micros = dERInteger3;
                return;
            }
            throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
        }
        throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
    }

    public Accuracy(ASN1Sequence aSN1Sequence) {
        this.seconds = null;
        this.millis = null;
        this.micros = null;
        for (int i = 0; i < aSN1Sequence.size(); i++) {
            if (aSN1Sequence.getObjectAt(i) instanceof DERInteger) {
                this.seconds = (DERInteger) aSN1Sequence.getObjectAt(i);
            } else if (!(aSN1Sequence.getObjectAt(i) instanceof DERTaggedObject)) {
                continue;
            } else {
                DERTaggedObject dERTaggedObject = (DERTaggedObject) aSN1Sequence.getObjectAt(i);
                int tagNo = dERTaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.millis = DERInteger.getInstance(dERTaggedObject, false);
                    if (this.millis.getValue().intValue() < 1 || this.millis.getValue().intValue() > 999) {
                        throw new IllegalArgumentException("Invalid millis field : not in (1..999).");
                    }
                } else if (tagNo == 1) {
                    this.micros = DERInteger.getInstance(dERTaggedObject, false);
                    if (this.micros.getValue().intValue() < 1 || this.micros.getValue().intValue() > 999) {
                        throw new IllegalArgumentException("Invalid micros field : not in (1..999).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalig tag number");
                }
            }
        }
    }

    public static Accuracy getInstance(Object obj) {
        if (obj == null || (obj instanceof Accuracy)) {
            return (Accuracy) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new Accuracy((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Unknown object in 'Accuracy' factory : " + obj.getClass().getName() + ".");
    }

    public DERInteger getSeconds() {
        return this.seconds;
    }

    public DERInteger getMillis() {
        return this.millis;
    }

    public DERInteger getMicros() {
        return this.micros;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERInteger dERInteger = this.seconds;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        DERInteger dERInteger2 = this.millis;
        if (dERInteger2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, dERInteger2));
        }
        DERInteger dERInteger3 = this.micros;
        if (dERInteger3 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, dERInteger3));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
