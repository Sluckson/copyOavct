package repack.org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class GeneralSubtree extends ASN1Encodable {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private GeneralName base;
    private DERInteger maximum;
    private DERInteger minimum;

    public GeneralSubtree(ASN1Sequence aSN1Sequence) {
        this.base = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        int size = aSN1Sequence.size();
        if (size == 1) {
            return;
        }
        if (size == 2) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.minimum = DERInteger.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.maximum = DERInteger.getInstance(instance, false);
            } else {
                throw new IllegalArgumentException("Bad tag number: " + instance.getTagNo());
            }
        } else if (size == 3) {
            ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            if (instance2.getTagNo() == 0) {
                this.minimum = DERInteger.getInstance(instance2, false);
                ASN1TaggedObject instance3 = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2));
                if (instance3.getTagNo() == 1) {
                    this.maximum = DERInteger.getInstance(instance3, false);
                    return;
                }
                throw new IllegalArgumentException("Bad tag number for 'maximum': " + instance3.getTagNo());
            }
            throw new IllegalArgumentException("Bad tag number for 'minimum': " + instance2.getTagNo());
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
    }

    public GeneralSubtree(GeneralName generalName, BigInteger bigInteger, BigInteger bigInteger2) {
        this.base = generalName;
        if (bigInteger2 != null) {
            this.maximum = new DERInteger(bigInteger2);
        }
        if (bigInteger == null) {
            this.minimum = null;
        } else {
            this.minimum = new DERInteger(bigInteger);
        }
    }

    public GeneralSubtree(GeneralName generalName) {
        this(generalName, (BigInteger) null, (BigInteger) null);
    }

    public static GeneralSubtree getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralSubtree(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static GeneralSubtree getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof GeneralSubtree) {
            return (GeneralSubtree) obj;
        }
        return new GeneralSubtree(ASN1Sequence.getInstance(obj));
    }

    public GeneralName getBase() {
        return this.base;
    }

    public BigInteger getMinimum() {
        DERInteger dERInteger = this.minimum;
        if (dERInteger == null) {
            return ZERO;
        }
        return dERInteger.getValue();
    }

    public BigInteger getMaximum() {
        DERInteger dERInteger = this.maximum;
        if (dERInteger == null) {
            return null;
        }
        return dERInteger.getValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.base);
        DERInteger dERInteger = this.minimum;
        if (dERInteger != null && !dERInteger.getValue().equals(ZERO)) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.minimum));
        }
        DERInteger dERInteger2 = this.maximum;
        if (dERInteger2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, dERInteger2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
