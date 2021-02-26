package repack.org.bouncycastle.cert.ocsp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1OutputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ocsp.OCSPRequest;
import repack.org.bouncycastle.asn1.ocsp.Request;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.cert.CertIOException;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;

public class OCSPReq {
    private static final X509CertificateHolder[] EMPTY_CERTS = new X509CertificateHolder[0];
    private X509Extensions extensions;
    private OCSPRequest req;

    public OCSPReq(OCSPRequest oCSPRequest) {
        this.req = oCSPRequest;
        this.extensions = oCSPRequest.getTbsRequest().getRequestExtensions();
    }

    public OCSPReq(byte[] bArr) throws IOException {
        this(new ASN1InputStream(bArr));
    }

    private OCSPReq(ASN1InputStream aSN1InputStream) throws IOException {
        try {
            this.req = OCSPRequest.getInstance(aSN1InputStream.readObject());
            this.extensions = this.req.getTbsRequest().getRequestExtensions();
        } catch (IllegalArgumentException e) {
            throw new CertIOException("malformed request: " + e.getMessage(), e);
        } catch (ClassCastException e2) {
            throw new CertIOException("malformed request: " + e2.getMessage(), e2);
        }
    }

    public int getVersion() {
        return this.req.getTbsRequest().getVersion().getValue().intValue() + 1;
    }

    public GeneralName getRequestorName() {
        return GeneralName.getInstance(this.req.getTbsRequest().getRequestorName());
    }

    public Req[] getRequestList() {
        ASN1Sequence requestList = this.req.getTbsRequest().getRequestList();
        Req[] reqArr = new Req[requestList.size()];
        for (int i = 0; i != reqArr.length; i++) {
            reqArr[i] = new Req(Request.getInstance(requestList.getObjectAt(i)));
        }
        return reqArr;
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public X509Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X509Extensions x509Extensions = this.extensions;
        if (x509Extensions != null) {
            return x509Extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return OCSPUtils.getExtensionOIDs(this.extensions);
    }

    public Set getCriticalExtensionOIDs() {
        return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
    }

    public Set getNonCriticalExtensionOIDs() {
        return OCSPUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public ASN1ObjectIdentifier getSignatureAlgOID() {
        if (!isSigned()) {
            return null;
        }
        return this.req.getOptionalSignature().getSignatureAlgorithm().getAlgorithm();
    }

    public byte[] getSignature() {
        if (!isSigned()) {
            return null;
        }
        return this.req.getOptionalSignature().getSignature().getBytes();
    }

    public X509CertificateHolder[] getCerts() {
        if (this.req.getOptionalSignature() == null) {
            return EMPTY_CERTS;
        }
        ASN1Sequence certs = this.req.getOptionalSignature().getCerts();
        if (certs == null) {
            return EMPTY_CERTS;
        }
        X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[certs.size()];
        for (int i = 0; i != x509CertificateHolderArr.length; i++) {
            x509CertificateHolderArr[i] = new X509CertificateHolder(X509CertificateStructure.getInstance(certs.getObjectAt(i)));
        }
        return x509CertificateHolderArr;
    }

    public boolean isSigned() {
        return this.req.getOptionalSignature() != null;
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws OCSPException {
        if (isSigned()) {
            try {
                ContentVerifier contentVerifier = contentVerifierProvider.get(this.req.getOptionalSignature().getSignatureAlgorithm());
                contentVerifier.getOutputStream().write(this.req.getTbsRequest().getDEREncoded());
                return contentVerifier.verify(getSignature());
            } catch (Exception e) {
                throw new OCSPException("exception processing signature: " + e, e);
            }
        } else {
            throw new OCSPException("attempt to verify signature on unsigned object");
        }
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ASN1OutputStream(byteArrayOutputStream).writeObject(this.req);
        return byteArrayOutputStream.toByteArray();
    }
}
