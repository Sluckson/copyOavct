package repack.org.bouncycastle.asn1.p065x9;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

/* renamed from: repack.org.bouncycastle.asn1.x9.DHDomainParameters */
public class DHDomainParameters extends ASN1Encodable {

    /* renamed from: g */
    private DERInteger f5889g;

    /* renamed from: j */
    private DERInteger f5890j;

    /* renamed from: p */
    private DERInteger f5891p;

    /* renamed from: q */
    private DERInteger f5892q;
    private DHValidationParms validationParms;

    public static DHDomainParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static DHDomainParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof DHDomainParameters)) {
            return (DHDomainParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DHDomainParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid DHDomainParameters: " + obj.getClass().getName());
    }

    public DHDomainParameters(DERInteger dERInteger, DERInteger dERInteger2, DERInteger dERInteger3, DERInteger dERInteger4, DHValidationParms dHValidationParms) {
        if (dERInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        } else if (dERInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        } else if (dERInteger3 != null) {
            this.f5891p = dERInteger;
            this.f5889g = dERInteger2;
            this.f5892q = dERInteger3;
            this.f5890j = dERInteger4;
            this.validationParms = dHValidationParms;
        } else {
            throw new IllegalArgumentException("'q' cannot be null");
        }
    }

    private DHDomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.f5891p = DERInteger.getInstance(objects.nextElement());
        this.f5889g = DERInteger.getInstance(objects.nextElement());
        this.f5892q = DERInteger.getInstance(objects.nextElement());
        DEREncodable next = getNext(objects);
        if (next != null && (next instanceof DERInteger)) {
            this.f5890j = DERInteger.getInstance(next);
            next = getNext(objects);
        }
        if (next != null) {
            this.validationParms = DHValidationParms.getInstance(next.getDERObject());
        }
    }

    private static DEREncodable getNext(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (DEREncodable) enumeration.nextElement();
        }
        return null;
    }

    public DERInteger getP() {
        return this.f5891p;
    }

    public DERInteger getG() {
        return this.f5889g;
    }

    public DERInteger getQ() {
        return this.f5892q;
    }

    public DERInteger getJ() {
        return this.f5890j;
    }

    public DHValidationParms getValidationParms() {
        return this.validationParms;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.f5891p);
        aSN1EncodableVector.add(this.f5889g);
        aSN1EncodableVector.add(this.f5892q);
        DERInteger dERInteger = this.f5890j;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        DHValidationParms dHValidationParms = this.validationParms;
        if (dHValidationParms != null) {
            aSN1EncodableVector.add(dHValidationParms);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
