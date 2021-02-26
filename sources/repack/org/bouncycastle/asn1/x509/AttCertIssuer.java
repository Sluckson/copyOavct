package repack.org.bouncycastle.asn1.x509;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class AttCertIssuer extends ASN1Encodable implements ASN1Choice {
    DERObject choiceObj;
    ASN1Encodable obj;

    public static AttCertIssuer getInstance(Object obj2) {
        if (obj2 instanceof AttCertIssuer) {
            return (AttCertIssuer) obj2;
        }
        if (obj2 instanceof V2Form) {
            return new AttCertIssuer(V2Form.getInstance(obj2));
        }
        if (obj2 instanceof GeneralNames) {
            return new AttCertIssuer((GeneralNames) obj2);
        }
        if (obj2 instanceof ASN1TaggedObject) {
            return new AttCertIssuer(V2Form.getInstance((ASN1TaggedObject) obj2, false));
        }
        if (obj2 instanceof ASN1Sequence) {
            return new AttCertIssuer(GeneralNames.getInstance(obj2));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj2.getClass().getName());
    }

    public static AttCertIssuer getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public AttCertIssuer(GeneralNames generalNames) {
        this.obj = generalNames;
        this.choiceObj = this.obj.getDERObject();
    }

    public AttCertIssuer(V2Form v2Form) {
        this.obj = v2Form;
        this.choiceObj = new DERTaggedObject(false, 0, this.obj);
    }

    public ASN1Encodable getIssuer() {
        return this.obj;
    }

    public DERObject toASN1Object() {
        return this.choiceObj;
    }
}
