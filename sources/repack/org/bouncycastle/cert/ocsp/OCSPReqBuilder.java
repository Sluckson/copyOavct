package repack.org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.ocsp.OCSPRequest;
import repack.org.bouncycastle.asn1.ocsp.Request;
import repack.org.bouncycastle.asn1.ocsp.Signature;
import repack.org.bouncycastle.asn1.ocsp.TBSRequest;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.ContentSigner;

public class OCSPReqBuilder {
    private List list = new ArrayList();
    private X509Extensions requestExtensions = null;
    private GeneralName requestorName = null;

    private class RequestObject {
        CertificateID certId;
        X509Extensions extensions;

        public RequestObject(CertificateID certificateID, X509Extensions x509Extensions) {
            this.certId = certificateID;
            this.extensions = x509Extensions;
        }

        public Request toRequest() throws Exception {
            return new Request(this.certId.toASN1Object(), this.extensions);
        }
    }

    public OCSPReqBuilder addRequest(CertificateID certificateID) {
        this.list.add(new RequestObject(certificateID, (X509Extensions) null));
        return this;
    }

    public OCSPReqBuilder addRequest(CertificateID certificateID, X509Extensions x509Extensions) {
        this.list.add(new RequestObject(certificateID, x509Extensions));
        return this;
    }

    public OCSPReqBuilder setRequestorName(X500Name x500Name) {
        this.requestorName = new GeneralName(4, (ASN1Encodable) x500Name);
        return this;
    }

    public OCSPReqBuilder setRequestorName(GeneralName generalName) {
        this.requestorName = generalName;
        return this;
    }

    public OCSPReqBuilder setRequestExtensions(X509Extensions x509Extensions) {
        this.requestExtensions = x509Extensions;
        return this;
    }

    private OCSPReq generateRequest(ContentSigner contentSigner, X509CertificateHolder[] x509CertificateHolderArr) throws OCSPException {
        Signature signature;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (RequestObject request : this.list) {
            try {
                aSN1EncodableVector.add(request.toRequest());
            } catch (Exception e) {
                throw new OCSPException("exception creating Request", e);
            }
        }
        TBSRequest tBSRequest = new TBSRequest(this.requestorName, new DERSequence(aSN1EncodableVector), this.requestExtensions);
        if (contentSigner == null) {
            signature = null;
        } else if (this.requestorName != null) {
            try {
                OutputStream outputStream = contentSigner.getOutputStream();
                outputStream.write(tBSRequest.getDEREncoded());
                outputStream.close();
                DERBitString dERBitString = new DERBitString(contentSigner.getSignature());
                AlgorithmIdentifier algorithmIdentifier = contentSigner.getAlgorithmIdentifier();
                if (x509CertificateHolderArr == null || x509CertificateHolderArr.length <= 0) {
                    signature = new Signature(algorithmIdentifier, dERBitString);
                } else {
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    for (int i = 0; i != x509CertificateHolderArr.length; i++) {
                        aSN1EncodableVector2.add(x509CertificateHolderArr[i].toASN1Structure());
                    }
                    signature = new Signature(algorithmIdentifier, dERBitString, new DERSequence(aSN1EncodableVector2));
                }
            } catch (Exception e2) {
                throw new OCSPException("exception processing TBSRequest: " + e2, e2);
            }
        } else {
            throw new OCSPException("requestorName must be specified if request is signed.");
        }
        return new OCSPReq(new OCSPRequest(tBSRequest, signature));
    }

    public OCSPReq build() throws OCSPException {
        return generateRequest((ContentSigner) null, (X509CertificateHolder[]) null);
    }

    public OCSPReq build(ContentSigner contentSigner, X509CertificateHolder[] x509CertificateHolderArr) throws OCSPException, IllegalArgumentException {
        if (contentSigner != null) {
            return generateRequest(contentSigner, x509CertificateHolderArr);
        }
        throw new IllegalArgumentException("no signer specified");
    }
}
