package com.lowagie.text.pdf;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.lowagie.text.ExceptionConverter;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Vector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.jce.provider.BouncyCastleProvider;
import repack.org.bouncycastle.ocsp.BasicOCSPResp;
import repack.org.bouncycastle.ocsp.CertificateID;
import repack.org.bouncycastle.ocsp.CertificateStatus;
import repack.org.bouncycastle.ocsp.OCSPException;
import repack.org.bouncycastle.ocsp.OCSPReq;
import repack.org.bouncycastle.ocsp.OCSPReqGenerator;
import repack.org.bouncycastle.ocsp.OCSPResp;
import repack.org.bouncycastle.ocsp.RevokedStatus;
import repack.org.bouncycastle.ocsp.SingleResp;

public class OcspClientBouncyCastle implements OcspClient {
    private X509Certificate checkCert;
    private X509Certificate rootCert;
    private String url;

    public OcspClientBouncyCastle(X509Certificate x509Certificate, X509Certificate x509Certificate2, String str) {
        this.checkCert = x509Certificate;
        this.rootCert = x509Certificate2;
        this.url = str;
    }

    private static OCSPReq generateOCSPRequest(X509Certificate x509Certificate, BigInteger bigInteger) throws OCSPException, IOException {
        Security.addProvider(new BouncyCastleProvider());
        CertificateID certificateID = new CertificateID(CertificateID.HASH_SHA1, x509Certificate, bigInteger);
        OCSPReqGenerator oCSPReqGenerator = new OCSPReqGenerator();
        oCSPReqGenerator.addRequest(certificateID);
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        vector.add(OCSPObjectIdentifiers.id_pkix_ocsp_nonce);
        vector2.add(new X509Extension(false, (ASN1OctetString) new DEROctetString(new DEROctetString(PdfEncryption.createDocumentId()).getEncoded())));
        oCSPReqGenerator.setRequestExtensions(new X509Extensions(vector, vector2));
        return oCSPReqGenerator.generate();
    }

    public byte[] getEncoded() {
        try {
            byte[] encoded = generateOCSPRequest(this.rootCert, this.checkCert.getSerialNumber()).getEncoded();
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.url).openConnection()));
            httpURLConnection.setRequestProperty("Content-Type", "application/ocsp-request");
            httpURLConnection.setRequestProperty("Accept", "application/ocsp-response");
            httpURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
            dataOutputStream.write(encoded);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() / 100 == 2) {
                OCSPResp oCSPResp = new OCSPResp((InputStream) httpURLConnection.getContent());
                if (oCSPResp.getStatus() == 0) {
                    BasicOCSPResp basicOCSPResp = (BasicOCSPResp) oCSPResp.getResponseObject();
                    if (basicOCSPResp == null) {
                        return null;
                    }
                    SingleResp[] responses = basicOCSPResp.getResponses();
                    if (responses.length != 1) {
                        return null;
                    }
                    Object certStatus = responses[0].getCertStatus();
                    if (certStatus == CertificateStatus.GOOD) {
                        return basicOCSPResp.getEncoded();
                    }
                    if (certStatus instanceof RevokedStatus) {
                        throw new IOException("OCSP Status is revoked!");
                    }
                    throw new IOException("OCSP Status is unknown!");
                }
                throw new IOException("Invalid status: " + oCSPResp.getStatus());
            }
            throw new IOException("Invalid HTTP response");
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
