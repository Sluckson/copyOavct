package com.lowagie.text.pdf;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DEROutputStream;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.cms.EncryptedContentInfo;
import repack.org.bouncycastle.asn1.cms.EnvelopedData;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import repack.org.bouncycastle.asn1.cms.OriginatorInfo;
import repack.org.bouncycastle.asn1.cms.RecipientIdentifier;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.TBSCertificateStructure;

public class PdfPublicKeySecurityHandler {
    static final int SEED_LENGTH = 20;
    private ArrayList recipients = null;
    private byte[] seed = new byte[20];

    public PdfPublicKeySecurityHandler() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(PsExtractor.AUDIO_STREAM, new SecureRandom());
            System.arraycopy(instance.generateKey().getEncoded(), 0, this.seed, 0, 20);
        } catch (NoSuchAlgorithmException unused) {
            this.seed = SecureRandom.getSeed(20);
        }
        this.recipients = new ArrayList();
    }

    public static byte[] unescapedString(byte[] bArr) throws BadPdfFormatException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        if (bArr[0] == 40 || bArr[bArr.length - 1] == 41) {
            while (i < bArr.length) {
                if (bArr[i] == 92) {
                    i++;
                    byte b = bArr[i];
                    if (b == 40) {
                        byteArrayOutputStream.write(40);
                    } else if (b == 41) {
                        byteArrayOutputStream.write(41);
                    } else if (b == 92) {
                        byteArrayOutputStream.write(92);
                    } else if (b == 98) {
                        byteArrayOutputStream.write(8);
                    } else if (b == 102) {
                        byteArrayOutputStream.write(12);
                    } else if (b == 110) {
                        byteArrayOutputStream.write(10);
                    } else if (b == 114) {
                        byteArrayOutputStream.write(13);
                    } else if (b == 116) {
                        byteArrayOutputStream.write(9);
                    }
                } else {
                    byteArrayOutputStream.write(bArr[i]);
                }
                i++;
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new BadPdfFormatException("Expect '(' and ')' at begin and end of the string.");
    }

    public void addRecipient(PdfPublicKeyRecipient pdfPublicKeyRecipient) {
        this.recipients.add(pdfPublicKeyRecipient);
    }

    /* access modifiers changed from: protected */
    public byte[] getSeed() {
        return (byte[]) this.seed.clone();
    }

    public int getRecipientsSize() {
        return this.recipients.size();
    }

    public byte[] getEncodedRecipient(int i) throws IOException, GeneralSecurityException {
        PdfPublicKeyRecipient pdfPublicKeyRecipient = (PdfPublicKeyRecipient) this.recipients.get(i);
        byte[] cms = pdfPublicKeyRecipient.getCms();
        if (cms != null) {
            return cms;
        }
        Certificate certificate = pdfPublicKeyRecipient.getCertificate();
        int permission = ((pdfPublicKeyRecipient.getPermission() | -3904) & -4) + 1;
        byte[] bArr = new byte[24];
        System.arraycopy(this.seed, 0, bArr, 0, 20);
        bArr[20] = (byte) (permission >> 24);
        bArr[21] = (byte) (permission >> 16);
        bArr[22] = (byte) (permission >> 8);
        bArr[23] = (byte) permission;
        DERObject createDERForRecipient = createDERForRecipient(bArr, (X509Certificate) certificate);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DEROutputStream(byteArrayOutputStream).writeObject(createDERForRecipient);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        pdfPublicKeyRecipient.setCms(byteArray);
        return byteArray;
    }

    public PdfArray getEncodedRecipients() throws IOException, GeneralSecurityException {
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < this.recipients.size(); i++) {
            try {
                pdfArray.add((PdfObject) new PdfLiteral(PdfContentByte.escapeString(getEncodedRecipient(i))));
            } catch (IOException | GeneralSecurityException unused) {
                pdfArray = null;
            }
        }
        return pdfArray;
    }

    private DERObject createDERForRecipient(byte[] bArr, X509Certificate x509Certificate) throws IOException, GeneralSecurityException {
        AlgorithmParameters generateParameters = AlgorithmParameterGenerator.getInstance("1.2.840.113549.3.2").generateParameters();
        DERObject readObject = new ASN1InputStream((InputStream) new ByteArrayInputStream(generateParameters.getEncoded("ASN.1"))).readObject();
        KeyGenerator instance = KeyGenerator.getInstance("1.2.840.113549.3.2");
        instance.init(128);
        SecretKey generateKey = instance.generateKey();
        Cipher instance2 = Cipher.getInstance("1.2.840.113549.3.2");
        instance2.init(1, generateKey, generateParameters);
        DEROctetString dEROctetString = new DEROctetString(instance2.doFinal(bArr));
        return new ContentInfo(PKCSObjectIdentifiers.envelopedData, new EnvelopedData((OriginatorInfo) null, new DERSet((DEREncodable) new RecipientInfo(computeRecipientInfo(x509Certificate, generateKey.getEncoded()))), new EncryptedContentInfo(PKCSObjectIdentifiers.data, new AlgorithmIdentifier(new DERObjectIdentifier("1.2.840.113549.3.2"), readObject), dEROctetString), (ASN1Set) null)).getDERObject();
    }

    private KeyTransRecipientInfo computeRecipientInfo(X509Certificate x509Certificate, byte[] bArr) throws GeneralSecurityException, IOException {
        TBSCertificateStructure instance = TBSCertificateStructure.getInstance(new ASN1InputStream((InputStream) new ByteArrayInputStream(x509Certificate.getTBSCertificate())).readObject());
        AlgorithmIdentifier algorithmId = instance.getSubjectPublicKeyInfo().getAlgorithmId();
        IssuerAndSerialNumber issuerAndSerialNumber = new IssuerAndSerialNumber(instance.getIssuer(), instance.getSerialNumber().getValue());
        Cipher instance2 = Cipher.getInstance(algorithmId.getObjectId().getId());
        instance2.init(1, x509Certificate);
        return new KeyTransRecipientInfo(new RecipientIdentifier(issuerAndSerialNumber), algorithmId, new DEROctetString(instance2.doFinal(bArr)));
    }
}
