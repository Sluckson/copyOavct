package repack.org.bouncycastle.ocsp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OutputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.ocsp.OCSPRequest;
import repack.org.bouncycastle.asn1.ocsp.Request;
import repack.org.bouncycastle.asn1.ocsp.Signature;
import repack.org.bouncycastle.asn1.ocsp.TBSRequest;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.jce.X509Principal;

public class OCSPReqGenerator {
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

    public void addRequest(CertificateID certificateID) {
        this.list.add(new RequestObject(certificateID, (X509Extensions) null));
    }

    public void addRequest(CertificateID certificateID, X509Extensions x509Extensions) {
        this.list.add(new RequestObject(certificateID, x509Extensions));
    }

    public void setRequestorName(X500Principal x500Principal) {
        try {
            this.requestorName = new GeneralName(4, (ASN1Encodable) new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("cannot encode principal: " + e);
        }
    }

    public void setRequestorName(GeneralName generalName) {
        this.requestorName = generalName;
    }

    public void setRequestExtensions(X509Extensions x509Extensions) {
        this.requestExtensions = x509Extensions;
    }

    private OCSPReq generateRequest(DERObjectIdentifier dERObjectIdentifier, PrivateKey privateKey, X509Certificate[] x509CertificateArr, String str, SecureRandom secureRandom) throws OCSPException, NoSuchProviderException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (RequestObject request : this.list) {
            try {
                aSN1EncodableVector.add(request.toRequest());
            } catch (Exception e) {
                throw new OCSPException("exception creating Request", e);
            }
        }
        TBSRequest tBSRequest = new TBSRequest(this.requestorName, new DERSequence(aSN1EncodableVector), this.requestExtensions);
        Signature signature = null;
        if (dERObjectIdentifier != null) {
            if (this.requestorName != null) {
                try {
                    java.security.Signature createSignatureInstance = OCSPUtil.createSignatureInstance(dERObjectIdentifier.getId(), str);
                    if (secureRandom != null) {
                        createSignatureInstance.initSign(privateKey, secureRandom);
                    } else {
                        createSignatureInstance.initSign(privateKey);
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        new ASN1OutputStream(byteArrayOutputStream).writeObject(tBSRequest);
                        createSignatureInstance.update(byteArrayOutputStream.toByteArray());
                        DERBitString dERBitString = new DERBitString(createSignatureInstance.sign());
                        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(dERObjectIdentifier, new DERNull());
                        if (x509CertificateArr == null || x509CertificateArr.length <= 0) {
                            signature = new Signature(algorithmIdentifier, dERBitString);
                        } else {
                            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                            int i = 0;
                            while (i != x509CertificateArr.length) {
                                try {
                                    aSN1EncodableVector2.add(new X509CertificateStructure((ASN1Sequence) ASN1Object.fromByteArray(x509CertificateArr[i].getEncoded())));
                                    i++;
                                } catch (IOException e2) {
                                    throw new OCSPException("error processing certs", e2);
                                } catch (CertificateEncodingException e3) {
                                    throw new OCSPException("error encoding certs", e3);
                                }
                            }
                            signature = new Signature(algorithmIdentifier, dERBitString, new DERSequence(aSN1EncodableVector2));
                        }
                    } catch (Exception e4) {
                        throw new OCSPException("exception processing TBSRequest: " + e4, e4);
                    }
                } catch (NoSuchProviderException e5) {
                    throw e5;
                } catch (GeneralSecurityException e6) {
                    throw new OCSPException("exception creating signature: " + e6, e6);
                }
            } else {
                throw new OCSPException("requestorName must be specified if request is signed.");
            }
        }
        return new OCSPReq(new OCSPRequest(tBSRequest, signature));
    }

    public OCSPReq generate() throws OCSPException {
        try {
            return generateRequest((DERObjectIdentifier) null, (PrivateKey) null, (X509Certificate[]) null, (String) null, (SecureRandom) null);
        } catch (NoSuchProviderException e) {
            throw new OCSPException("no provider! - " + e, e);
        }
    }

    public OCSPReq generate(String str, PrivateKey privateKey, X509Certificate[] x509CertificateArr, String str2) throws OCSPException, NoSuchProviderException, IllegalArgumentException {
        return generate(str, privateKey, x509CertificateArr, str2, (SecureRandom) null);
    }

    public OCSPReq generate(String str, PrivateKey privateKey, X509Certificate[] x509CertificateArr, String str2, SecureRandom secureRandom) throws OCSPException, NoSuchProviderException, IllegalArgumentException {
        if (str != null) {
            try {
                return generateRequest(OCSPUtil.getAlgorithmOID(str), privateKey, x509CertificateArr, str2, secureRandom);
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException("unknown signing algorithm specified: " + str);
            }
        } else {
            throw new IllegalArgumentException("no signing algorithm specified");
        }
    }

    public Iterator getSignatureAlgNames() {
        return OCSPUtil.getAlgNames();
    }
}
