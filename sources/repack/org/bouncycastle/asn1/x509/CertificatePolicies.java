package repack.org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class CertificatePolicies extends ASN1Encodable {
    static final DERObjectIdentifier anyPolicy = new DERObjectIdentifier("2.5.29.32.0");
    Vector policies;

    public static CertificatePolicies getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static CertificatePolicies getInstance(Object obj) {
        if (obj instanceof CertificatePolicies) {
            return (CertificatePolicies) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertificatePolicies((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public CertificatePolicies(ASN1Sequence aSN1Sequence) {
        this.policies = new Vector();
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            this.policies.addElement(ASN1Sequence.getInstance(objects.nextElement()).getObjectAt(0));
        }
    }

    public CertificatePolicies(DERObjectIdentifier dERObjectIdentifier) {
        this.policies = new Vector();
        this.policies.addElement(dERObjectIdentifier);
    }

    public CertificatePolicies(String str) {
        this(new DERObjectIdentifier(str));
    }

    public void addPolicy(String str) {
        this.policies.addElement(new DERObjectIdentifier(str));
    }

    public String getPolicy(int i) {
        if (this.policies.size() > i) {
            return ((DERObjectIdentifier) this.policies.elementAt(i)).getId();
        }
        return null;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i < this.policies.size(); i++) {
            aSN1EncodableVector.add(new DERSequence((DEREncodable) (DERObjectIdentifier) this.policies.elementAt(i)));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String str = null;
        for (int i = 0; i < this.policies.size(); i++) {
            if (str != null) {
                str = String.valueOf(str) + ", ";
            }
            str = String.valueOf(str) + ((DERObjectIdentifier) this.policies.elementAt(i)).getId();
        }
        return "CertificatePolicies: " + str;
    }
}
