package repack.org.bouncycastle.asn1.ocsp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class TBSRequest extends ASN1Encodable {

    /* renamed from: V1 */
    private static final DERInteger f5847V1 = new DERInteger(0);
    X509Extensions requestExtensions;
    ASN1Sequence requestList;
    GeneralName requestorName;
    DERInteger version;
    boolean versionSet;

    public TBSRequest(GeneralName generalName, ASN1Sequence aSN1Sequence, X509Extensions x509Extensions) {
        this.version = f5847V1;
        this.requestorName = generalName;
        this.requestList = aSN1Sequence;
        this.requestExtensions = x509Extensions;
    }

    public TBSRequest(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject)) {
            this.version = f5847V1;
        } else if (((ASN1TaggedObject) aSN1Sequence.getObjectAt(0)).getTagNo() == 0) {
            this.versionSet = true;
            this.version = DERInteger.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i = 1;
        } else {
            this.version = f5847V1;
        }
        if (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
            this.requestorName = GeneralName.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i), true);
            i++;
        }
        int i2 = i + 1;
        this.requestList = (ASN1Sequence) aSN1Sequence.getObjectAt(i);
        if (aSN1Sequence.size() == i2 + 1) {
            this.requestExtensions = X509Extensions.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i2), true);
        }
    }

    public static TBSRequest getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static TBSRequest getInstance(Object obj) {
        if (obj == null || (obj instanceof TBSRequest)) {
            return (TBSRequest) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new TBSRequest((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public DERInteger getVersion() {
        return this.version;
    }

    public GeneralName getRequestorName() {
        return this.requestorName;
    }

    public ASN1Sequence getRequestList() {
        return this.requestList;
    }

    public X509Extensions getRequestExtensions() {
        return this.requestExtensions;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.version.equals(f5847V1) || this.versionSet) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.version));
        }
        GeneralName generalName = this.requestorName;
        if (generalName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, generalName));
        }
        aSN1EncodableVector.add(this.requestList);
        X509Extensions x509Extensions = this.requestExtensions;
        if (x509Extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, x509Extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
