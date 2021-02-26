package repack.org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class ExtendedKeyUsage extends ASN1Encodable {
    ASN1Sequence seq;
    Hashtable usageTable = new Hashtable();

    public static ExtendedKeyUsage getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static ExtendedKeyUsage getInstance(Object obj) {
        if (obj instanceof ExtendedKeyUsage) {
            return (ExtendedKeyUsage) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ExtendedKeyUsage((ASN1Sequence) obj);
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        throw new IllegalArgumentException("Invalid ExtendedKeyUsage: " + obj.getClass().getName());
    }

    public ExtendedKeyUsage(KeyPurposeId keyPurposeId) {
        this.seq = new DERSequence((DEREncodable) keyPurposeId);
        this.usageTable.put(keyPurposeId, keyPurposeId);
    }

    public ExtendedKeyUsage(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            Object nextElement = objects.nextElement();
            if (nextElement instanceof DERObjectIdentifier) {
                this.usageTable.put(nextElement, nextElement);
            } else {
                throw new IllegalArgumentException("Only DERObjectIdentifiers allowed in ExtendedKeyUsage.");
            }
        }
    }

    public ExtendedKeyUsage(Vector vector) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            DERObject dERObject = (DERObject) elements.nextElement();
            aSN1EncodableVector.add(dERObject);
            this.usageTable.put(dERObject, dERObject);
        }
        this.seq = new DERSequence(aSN1EncodableVector);
    }

    public boolean hasKeyPurposeId(KeyPurposeId keyPurposeId) {
        return this.usageTable.get(keyPurposeId) != null;
    }

    public Vector getUsages() {
        Vector vector = new Vector();
        Enumeration elements = this.usageTable.elements();
        while (elements.hasMoreElements()) {
            vector.addElement(elements.nextElement());
        }
        return vector;
    }

    public int size() {
        return this.usageTable.size();
    }

    public DERObject toASN1Object() {
        return this.seq;
    }
}
