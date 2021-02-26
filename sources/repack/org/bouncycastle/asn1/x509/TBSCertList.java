package repack.org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.DERUTCTime;

public class TBSCertList extends ASN1Encodable {
    X509Extensions crlExtensions;
    X509Name issuer;
    Time nextUpdate;
    ASN1Sequence revokedCertificates;
    ASN1Sequence seq;
    AlgorithmIdentifier signature;
    Time thisUpdate;
    DERInteger version;

    public static class CRLEntry extends ASN1Encodable {
        X509Extensions crlEntryExtensions;
        Time revocationDate;
        ASN1Sequence seq;
        DERInteger userCertificate;

        public CRLEntry(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 3) {
                throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
            }
            this.seq = aSN1Sequence;
            this.userCertificate = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
            this.revocationDate = Time.getInstance(aSN1Sequence.getObjectAt(1));
        }

        public DERInteger getUserCertificate() {
            return this.userCertificate;
        }

        public Time getRevocationDate() {
            return this.revocationDate;
        }

        public X509Extensions getExtensions() {
            if (this.crlEntryExtensions == null && this.seq.size() == 3) {
                this.crlEntryExtensions = X509Extensions.getInstance(this.seq.getObjectAt(2));
            }
            return this.crlEntryExtensions;
        }

        public DERObject toASN1Object() {
            return this.seq;
        }
    }

    private class RevokedCertificatesEnumeration implements Enumeration {

        /* renamed from: en */
        private final Enumeration f5877en;

        RevokedCertificatesEnumeration(Enumeration enumeration) {
            this.f5877en = enumeration;
        }

        public boolean hasMoreElements() {
            return this.f5877en.hasMoreElements();
        }

        public Object nextElement() {
            return new CRLEntry(ASN1Sequence.getInstance(this.f5877en.nextElement()));
        }
    }

    private class EmptyEnumeration implements Enumeration {
        public boolean hasMoreElements() {
            return false;
        }

        public Object nextElement() {
            return null;
        }

        private EmptyEnumeration() {
        }

        /* synthetic */ EmptyEnumeration(TBSCertList tBSCertList, EmptyEnumeration emptyEnumeration) {
            this();
        }
    }

    public static TBSCertList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static TBSCertList getInstance(Object obj) {
        if (obj instanceof TBSCertList) {
            return (TBSCertList) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new TBSCertList((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public TBSCertList(ASN1Sequence aSN1Sequence) {
        int i;
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 7) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.seq = aSN1Sequence;
        int i2 = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof DERInteger) {
            this.version = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
            i2 = 1;
        } else {
            this.version = new DERInteger(0);
        }
        int i3 = i2 + 1;
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i2));
        int i4 = i3 + 1;
        this.issuer = X509Name.getInstance(aSN1Sequence.getObjectAt(i3));
        int i5 = i4 + 1;
        this.thisUpdate = Time.getInstance(aSN1Sequence.getObjectAt(i4));
        if (i5 >= aSN1Sequence.size() || (!(aSN1Sequence.getObjectAt(i5) instanceof DERUTCTime) && !(aSN1Sequence.getObjectAt(i5) instanceof DERGeneralizedTime) && !(aSN1Sequence.getObjectAt(i5) instanceof Time))) {
            i = i5;
        } else {
            i = i5 + 1;
            this.nextUpdate = Time.getInstance(aSN1Sequence.getObjectAt(i5));
        }
        if (i < aSN1Sequence.size() && !(aSN1Sequence.getObjectAt(i) instanceof DERTaggedObject)) {
            this.revokedCertificates = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (i < aSN1Sequence.size() && (aSN1Sequence.getObjectAt(i) instanceof DERTaggedObject)) {
            this.crlExtensions = X509Extensions.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }

    public int getVersion() {
        return this.version.getValue().intValue() + 1;
    }

    public DERInteger getVersionNumber() {
        return this.version;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public X509Name getIssuer() {
        return this.issuer;
    }

    public Time getThisUpdate() {
        return this.thisUpdate;
    }

    public Time getNextUpdate() {
        return this.nextUpdate;
    }

    public CRLEntry[] getRevokedCertificates() {
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        if (aSN1Sequence == null) {
            return new CRLEntry[0];
        }
        CRLEntry[] cRLEntryArr = new CRLEntry[aSN1Sequence.size()];
        for (int i = 0; i < cRLEntryArr.length; i++) {
            cRLEntryArr[i] = new CRLEntry(ASN1Sequence.getInstance(this.revokedCertificates.getObjectAt(i)));
        }
        return cRLEntryArr;
    }

    public Enumeration getRevokedCertificateEnumeration() {
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        if (aSN1Sequence == null) {
            return new EmptyEnumeration(this, (EmptyEnumeration) null);
        }
        return new RevokedCertificatesEnumeration(aSN1Sequence.getObjects());
    }

    public X509Extensions getExtensions() {
        return this.crlExtensions;
    }

    public DERObject toASN1Object() {
        return this.seq;
    }
}
