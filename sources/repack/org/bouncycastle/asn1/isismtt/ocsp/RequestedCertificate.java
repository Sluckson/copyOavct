package repack.org.bouncycastle.asn1.isismtt.ocsp;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;

public class RequestedCertificate extends ASN1Encodable implements ASN1Choice {
    public static final int attributeCertificate = 1;
    public static final int certificate = -1;
    public static final int publicKeyCertificate = 0;
    private byte[] attributeCert;
    private X509CertificateStructure cert;
    private byte[] publicKeyCert;

    public static RequestedCertificate getInstance(Object obj) {
        if (obj == null || (obj instanceof RequestedCertificate)) {
            return (RequestedCertificate) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RequestedCertificate(X509CertificateStructure.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            return new RequestedCertificate((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static RequestedCertificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    private RequestedCertificate(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.publicKeyCert = ASN1OctetString.getInstance(aSN1TaggedObject, true).getOctets();
        } else if (aSN1TaggedObject.getTagNo() == 1) {
            this.attributeCert = ASN1OctetString.getInstance(aSN1TaggedObject, true).getOctets();
        } else {
            throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
        }
    }

    public RequestedCertificate(X509CertificateStructure x509CertificateStructure) {
        this.cert = x509CertificateStructure;
    }

    public RequestedCertificate(int i, byte[] bArr) {
        this((ASN1TaggedObject) new DERTaggedObject(i, new DEROctetString(bArr)));
    }

    public int getType() {
        if (this.cert != null) {
            return -1;
        }
        return this.publicKeyCert != null ? 0 : 1;
    }

    public byte[] getCertificateBytes() {
        X509CertificateStructure x509CertificateStructure = this.cert;
        if (x509CertificateStructure != null) {
            try {
                return x509CertificateStructure.getEncoded();
            } catch (IOException e) {
                throw new IllegalStateException("can't decode certificate: " + e);
            }
        } else {
            byte[] bArr = this.publicKeyCert;
            if (bArr != null) {
                return bArr;
            }
            return this.attributeCert;
        }
    }

    public DERObject toASN1Object() {
        byte[] bArr = this.publicKeyCert;
        if (bArr != null) {
            return new DERTaggedObject(0, new DEROctetString(bArr));
        }
        byte[] bArr2 = this.attributeCert;
        if (bArr2 != null) {
            return new DERTaggedObject(1, new DEROctetString(bArr2));
        }
        return this.cert.getDERObject();
    }
}
