package repack.org.bouncycastle.pkcs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.pkcs.Attribute;
import repack.org.bouncycastle.asn1.pkcs.CertificationRequest;
import repack.org.bouncycastle.asn1.pkcs.CertificationRequestInfo;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;

public class PKCS10CertificationRequestHolder {
    private static Attribute[] EMPTY_ARRAY = new Attribute[0];
    private CertificationRequest certificationRequest;

    private static CertificationRequest parseBytes(byte[] bArr) throws IOException {
        try {
            return CertificationRequest.getInstance(ASN1Object.fromByteArray(bArr));
        } catch (ClassCastException e) {
            throw new PKCSIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new PKCSIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    public PKCS10CertificationRequestHolder(CertificationRequest certificationRequest2) {
        this.certificationRequest = certificationRequest2;
    }

    public PKCS10CertificationRequestHolder(byte[] bArr) throws IOException {
        this(parseBytes(bArr));
    }

    public CertificationRequest toASN1Structure() {
        return this.certificationRequest;
    }

    public X500Name getSubject() {
        return X500Name.getInstance(this.certificationRequest.getCertificationRequestInfo().getSubject());
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.certificationRequest.getSignatureAlgorithm();
    }

    public byte[] getSignature() {
        return this.certificationRequest.getSignature().getBytes();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.certificationRequest.getCertificationRequestInfo().getSubjectPublicKeyInfo();
    }

    public Attribute[] getAttributes() {
        ASN1Set attributes = this.certificationRequest.getCertificationRequestInfo().getAttributes();
        if (attributes == null) {
            return EMPTY_ARRAY;
        }
        Attribute[] attributeArr = new Attribute[attributes.size()];
        for (int i = 0; i != attributes.size(); i++) {
            attributeArr[i] = Attribute.getInstance(attributes.getObjectAt(i));
        }
        return attributeArr;
    }

    public Attribute[] getAttributes(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ASN1Set attributes = this.certificationRequest.getCertificationRequestInfo().getAttributes();
        if (attributes == null) {
            return EMPTY_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != attributes.size(); i++) {
            Attribute instance = Attribute.getInstance(attributes.getObjectAt(i));
            if (instance.getAttrType().equals(aSN1ObjectIdentifier)) {
                arrayList.add(instance);
            }
        }
        if (arrayList.size() == 0) {
            return EMPTY_ARRAY;
        }
        return (Attribute[]) arrayList.toArray(new Attribute[arrayList.size()]);
    }

    public byte[] getEncoded() throws IOException {
        return this.certificationRequest.getEncoded();
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws PKCSException {
        CertificationRequestInfo certificationRequestInfo = this.certificationRequest.getCertificationRequestInfo();
        try {
            ContentVerifier contentVerifier = contentVerifierProvider.get(this.certificationRequest.getSignatureAlgorithm());
            OutputStream outputStream = contentVerifier.getOutputStream();
            outputStream.write(certificationRequestInfo.getDEREncoded());
            outputStream.close();
            return contentVerifier.verify(this.certificationRequest.getSignature().getBytes());
        } catch (Exception e) {
            throw new PKCSException("unable to process signature: " + e.getMessage(), e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PKCS10CertificationRequestHolder)) {
            return false;
        }
        return toASN1Structure().equals(((PKCS10CertificationRequestHolder) obj).toASN1Structure());
    }

    public int hashCode() {
        return toASN1Structure().hashCode();
    }
}
