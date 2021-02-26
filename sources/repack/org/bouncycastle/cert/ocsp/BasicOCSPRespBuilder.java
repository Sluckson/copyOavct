package repack.org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import repack.org.bouncycastle.asn1.ocsp.CertStatus;
import repack.org.bouncycastle.asn1.ocsp.ResponseData;
import repack.org.bouncycastle.asn1.ocsp.RevokedInfo;
import repack.org.bouncycastle.asn1.ocsp.SingleResponse;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.CRLReason;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.ContentSigner;
import repack.org.bouncycastle.operator.DigestCalculator;

public class BasicOCSPRespBuilder {
    private List list = new ArrayList();
    private RespID responderID;
    private X509Extensions responseExtensions = null;

    private class ResponseObject {
        CertificateID certId;
        CertStatus certStatus;
        X509Extensions extensions;
        DERGeneralizedTime nextUpdate;
        DERGeneralizedTime thisUpdate;

        public ResponseObject(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2, X509Extensions x509Extensions) {
            this.certId = certificateID;
            if (certificateStatus == null) {
                this.certStatus = new CertStatus();
            } else if (certificateStatus instanceof UnknownStatus) {
                this.certStatus = new CertStatus(2, new DERNull());
            } else {
                RevokedStatus revokedStatus = (RevokedStatus) certificateStatus;
                if (revokedStatus.hasRevocationReason()) {
                    this.certStatus = new CertStatus(new RevokedInfo(new DERGeneralizedTime(revokedStatus.getRevocationTime()), new CRLReason(revokedStatus.getRevocationReason())));
                } else {
                    this.certStatus = new CertStatus(new RevokedInfo(new DERGeneralizedTime(revokedStatus.getRevocationTime()), (CRLReason) null));
                }
            }
            this.thisUpdate = new DERGeneralizedTime(date);
            if (date2 != null) {
                this.nextUpdate = new DERGeneralizedTime(date2);
            } else {
                this.nextUpdate = null;
            }
            this.extensions = x509Extensions;
        }

        public SingleResponse toResponse() throws Exception {
            return new SingleResponse(this.certId.toASN1Object(), this.certStatus, this.thisUpdate, this.nextUpdate, this.extensions);
        }
    }

    public BasicOCSPRespBuilder(RespID respID) {
        this.responderID = respID;
    }

    public BasicOCSPRespBuilder(SubjectPublicKeyInfo subjectPublicKeyInfo, DigestCalculator digestCalculator) throws OCSPException {
        this.responderID = new RespID(subjectPublicKeyInfo, digestCalculator);
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), (Date) null, (X509Extensions) null));
        return this;
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), (Date) null, x509Extensions));
        return this;
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), date, x509Extensions));
        return this;
    }

    public BasicOCSPRespBuilder addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, date, date2, x509Extensions));
        return this;
    }

    public BasicOCSPRespBuilder setResponseExtensions(X509Extensions x509Extensions) {
        this.responseExtensions = x509Extensions;
        return this;
    }

    public BasicOCSPResp build(ContentSigner contentSigner, X509CertificateHolder[] x509CertificateHolderArr, Date date) throws OCSPException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (ResponseObject response : this.list) {
            try {
                aSN1EncodableVector.add(response.toResponse());
            } catch (Exception e) {
                throw new OCSPException("exception creating Request", e);
            }
        }
        ResponseData responseData = new ResponseData(this.responderID.toASN1Object(), new DERGeneralizedTime(date), new DERSequence(aSN1EncodableVector), this.responseExtensions);
        try {
            OutputStream outputStream = contentSigner.getOutputStream();
            outputStream.write(responseData.getEncoded(ASN1Encodable.DER));
            outputStream.close();
            DERBitString dERBitString = new DERBitString(contentSigner.getSignature());
            AlgorithmIdentifier algorithmIdentifier = contentSigner.getAlgorithmIdentifier();
            DERSequence dERSequence = null;
            if (x509CertificateHolderArr != null && x509CertificateHolderArr.length > 0) {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                for (int i = 0; i != x509CertificateHolderArr.length; i++) {
                    aSN1EncodableVector2.add(x509CertificateHolderArr[i].toASN1Structure());
                }
                dERSequence = new DERSequence(aSN1EncodableVector2);
            }
            return new BasicOCSPResp(new BasicOCSPResponse(responseData, algorithmIdentifier, dERBitString, dERSequence));
        } catch (Exception e2) {
            throw new OCSPException("exception processing TBSRequest: " + e2.getMessage(), e2);
        }
    }
}
