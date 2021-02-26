package com.lowagie.text.pdf;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.lowagie.text.pdf.codec.Base64;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import p052cz.msebera.android.httpclient.entity.mime.MIME;
import repack.org.bouncycastle.asn1.cmp.PKIFailureInfo;
import repack.org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import repack.org.bouncycastle.tsp.TimeStampRequest;
import repack.org.bouncycastle.tsp.TimeStampRequestGenerator;
import repack.org.bouncycastle.tsp.TimeStampResponse;
import repack.org.bouncycastle.tsp.TimeStampToken;

public class TSAClientBouncyCastle implements TSAClient {
    protected int tokSzEstimate;
    protected String tsaPassword;
    protected String tsaURL;
    protected String tsaUsername;

    public TSAClientBouncyCastle(String str) {
        this(str, (String) null, (String) null, 4096);
    }

    public TSAClientBouncyCastle(String str, String str2, String str3) {
        this(str, str2, str3, 4096);
    }

    public TSAClientBouncyCastle(String str, String str2, String str3, int i) {
        this.tsaURL = str;
        this.tsaUsername = str2;
        this.tsaPassword = str3;
        this.tokSzEstimate = i;
    }

    public int getTokenSizeEstimate() {
        return this.tokSzEstimate;
    }

    public byte[] getTimeStampToken(PdfPKCS7 pdfPKCS7, byte[] bArr) throws Exception {
        return getTimeStampToken(bArr);
    }

    /* access modifiers changed from: protected */
    public byte[] getTimeStampToken(byte[] bArr) throws Exception {
        int i;
        try {
            TimeStampRequestGenerator timeStampRequestGenerator = new TimeStampRequestGenerator();
            timeStampRequestGenerator.setCertReq(true);
            TimeStampRequest generate = timeStampRequestGenerator.generate(X509ObjectIdentifiers.id_SHA1.getId(), bArr, BigInteger.valueOf(System.currentTimeMillis()));
            TimeStampResponse timeStampResponse = new TimeStampResponse(getTSAResponse(generate.getEncoded()));
            timeStampResponse.validate(generate);
            PKIFailureInfo failInfo = timeStampResponse.getFailInfo();
            if (failInfo == null) {
                i = 0;
            } else {
                i = failInfo.intValue();
            }
            if (i == 0) {
                TimeStampToken timeStampToken = timeStampResponse.getTimeStampToken();
                if (timeStampToken != null) {
                    timeStampToken.getTimeStampInfo();
                    byte[] encoded = timeStampToken.getEncoded();
                    System.currentTimeMillis();
                    this.tokSzEstimate = encoded.length + 32;
                    return encoded;
                }
                throw new Exception("TSA '" + this.tsaURL + "' failed to return time stamp token: " + timeStampResponse.getStatusString());
            }
            throw new Exception("Invalid TSA '" + this.tsaURL + "' response, code " + i);
        } catch (Exception e) {
            throw e;
        } catch (Throwable th) {
            throw new Exception("Failed to get TSA response from '" + this.tsaURL + "'", th);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getTSAResponse(byte[] bArr) throws Exception {
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.tsaURL).openConnection());
        uRLConnection.setDoInput(true);
        uRLConnection.setDoOutput(true);
        uRLConnection.setUseCaches(false);
        uRLConnection.setRequestProperty("Content-Type", "application/timestamp-query");
        uRLConnection.setRequestProperty(MIME.CONTENT_TRANSFER_ENC, MIME.ENC_BINARY);
        String str = this.tsaUsername;
        if (str != null && !str.equals("")) {
            String str2 = String.valueOf(this.tsaUsername) + ":" + this.tsaPassword;
            uRLConnection.setRequestProperty("Authorization", "Basic " + new String(Base64.encodeBytes(str2.getBytes())));
        }
        OutputStream outputStream = uRLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        InputStream inputStream = uRLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr2, 0, bArr2.length);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String contentEncoding = uRLConnection.getContentEncoding();
        return (contentEncoding == null || !contentEncoding.equalsIgnoreCase("base64")) ? byteArray : Base64.decode(new String(byteArray));
    }
}
