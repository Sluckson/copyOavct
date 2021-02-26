package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import java.io.ByteArrayOutputStream;
import java.security.PrivateKey;
import java.security.cert.CRL;
import java.security.cert.Certificate;

public abstract class PdfSigGenericPKCS extends PdfSignature {
    private String digestEncryptionAlgorithm;
    private byte[] externalDigest;
    private byte[] externalRSAdata;
    protected String hashAlgorithm;
    protected String name;
    protected PdfPKCS7 pkcs;
    protected String provider = null;

    public PdfSigGenericPKCS(PdfName pdfName, PdfName pdfName2) {
        super(pdfName, pdfName2);
    }

    public void setSignInfo(PrivateKey privateKey, Certificate[] certificateArr, CRL[] crlArr) {
        try {
            this.pkcs = new PdfPKCS7(privateKey, certificateArr, crlArr, this.hashAlgorithm, this.provider, PdfName.ADBE_PKCS7_SHA1.equals(get(PdfName.SUBFILTER)));
            this.pkcs.setExternalDigest(this.externalDigest, this.externalRSAdata, this.digestEncryptionAlgorithm);
            if (PdfName.ADBE_X509_RSA_SHA1.equals(get(PdfName.SUBFILTER))) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (Certificate encoded : certificateArr) {
                    byteArrayOutputStream.write(encoded.getEncoded());
                }
                byteArrayOutputStream.close();
                setCert(byteArrayOutputStream.toByteArray());
                setContents(this.pkcs.getEncodedPKCS1());
            } else {
                setContents(this.pkcs.getEncodedPKCS7());
            }
            this.name = PdfPKCS7.getSubjectFields(this.pkcs.getSigningCertificate()).getField("CN");
            if (this.name != null) {
                put(PdfName.NAME, new PdfString(this.name, PdfObject.TEXT_UNICODE));
            }
            this.pkcs = new PdfPKCS7(privateKey, certificateArr, crlArr, this.hashAlgorithm, this.provider, PdfName.ADBE_PKCS7_SHA1.equals(get(PdfName.SUBFILTER)));
            this.pkcs.setExternalDigest(this.externalDigest, this.externalRSAdata, this.digestEncryptionAlgorithm);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void setExternalDigest(byte[] bArr, byte[] bArr2, String str) {
        this.externalDigest = bArr;
        this.externalRSAdata = bArr2;
        this.digestEncryptionAlgorithm = str;
    }

    public String getName() {
        return this.name;
    }

    public PdfPKCS7 getSigner() {
        return this.pkcs;
    }

    public byte[] getSignerContents() {
        if (PdfName.ADBE_X509_RSA_SHA1.equals(get(PdfName.SUBFILTER))) {
            return this.pkcs.getEncodedPKCS1();
        }
        return this.pkcs.getEncodedPKCS7();
    }

    public static class VeriSign extends PdfSigGenericPKCS {
        public VeriSign() {
            super(PdfName.VERISIGN_PPKVS, PdfName.ADBE_PKCS7_DETACHED);
            this.hashAlgorithm = "MD5";
            put(PdfName.f715R, new PdfNumber(65537));
        }

        public VeriSign(String str) {
            this();
            this.provider = str;
        }
    }

    public static class PPKLite extends PdfSigGenericPKCS {
        public PPKLite() {
            super(PdfName.ADOBE_PPKLITE, PdfName.ADBE_X509_RSA_SHA1);
            this.hashAlgorithm = "SHA1";
            put(PdfName.f715R, new PdfNumber(65541));
        }

        public PPKLite(String str) {
            this();
            this.provider = str;
        }
    }

    public static class PPKMS extends PdfSigGenericPKCS {
        public PPKMS() {
            super(PdfName.ADOBE_PPKMS, PdfName.ADBE_PKCS7_SHA1);
            this.hashAlgorithm = "SHA1";
        }

        public PPKMS(String str) {
            this();
            this.provider = str;
        }
    }
}
