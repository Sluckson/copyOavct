package com.lowagie.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.lowagie.text.ExceptionConverter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1OutputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DEREnumerated;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.DERString;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.DERUTCTime;
import repack.org.bouncycastle.asn1.cms.Attribute;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import repack.org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.jce.provider.X509CRLParser;
import repack.org.bouncycastle.jce.provider.X509CertParser;
import repack.org.bouncycastle.ocsp.BasicOCSPResp;
import repack.org.bouncycastle.ocsp.CertificateID;
import repack.org.bouncycastle.tsp.TimeStampToken;

public class PdfPKCS7 {
    private static final String ID_ADBE_REVOCATION = "1.2.840.113583.1.1.8";
    private static final String ID_CONTENT_TYPE = "1.2.840.113549.1.9.3";
    private static final String ID_DSA = "1.2.840.10040.4.1";
    private static final String ID_MESSAGE_DIGEST = "1.2.840.113549.1.9.4";
    private static final String ID_PKCS7_DATA = "1.2.840.113549.1.7.1";
    private static final String ID_PKCS7_SIGNED_DATA = "1.2.840.113549.1.7.2";
    private static final String ID_RSA = "1.2.840.113549.1.1.1";
    private static final String ID_SIGNING_TIME = "1.2.840.113549.1.9.5";
    private static final HashMap algorithmNames = new HashMap();
    private static final HashMap allowedDigests = new HashMap();
    private static final HashMap digestNames = new HashMap();
    private byte[] RSAdata;
    private BasicOCSPResp basicResp;
    private Collection certs;
    private Collection crls;
    private byte[] digest;
    private String digestAlgorithm;
    private byte[] digestAttr;
    private String digestEncryptionAlgorithm;
    private Set digestalgos;
    private byte[] externalDigest;
    private byte[] externalRSAdata;
    private String location;
    private MessageDigest messageDigest;
    private transient PrivateKey privKey;
    private String provider;
    private String reason;
    private Signature sig;
    private byte[] sigAttr;
    private X509Certificate signCert;
    private Collection signCerts;
    private Calendar signDate;
    private String signName;
    private int signerversion;
    private TimeStampToken timeStampToken;
    private boolean verified;
    private boolean verifyResult;
    private int version;

    static {
        digestNames.put("1.2.840.113549.2.5", "MD5");
        digestNames.put("1.2.840.113549.2.2", "MD2");
        digestNames.put(CertificateID.HASH_SHA1, "SHA1");
        digestNames.put("2.16.840.1.101.3.4.2.4", "SHA224");
        digestNames.put("2.16.840.1.101.3.4.2.1", "SHA256");
        digestNames.put("2.16.840.1.101.3.4.2.2", "SHA384");
        digestNames.put("2.16.840.1.101.3.4.2.3", "SHA512");
        digestNames.put("1.3.36.3.2.2", "RIPEMD128");
        digestNames.put("1.3.36.3.2.1", "RIPEMD160");
        digestNames.put("1.3.36.3.2.3", "RIPEMD256");
        digestNames.put("1.2.840.113549.1.1.4", "MD5");
        digestNames.put("1.2.840.113549.1.1.2", "MD2");
        digestNames.put("1.2.840.113549.1.1.5", "SHA1");
        digestNames.put("1.2.840.113549.1.1.14", "SHA224");
        digestNames.put("1.2.840.113549.1.1.11", "SHA256");
        digestNames.put("1.2.840.113549.1.1.12", "SHA384");
        digestNames.put("1.2.840.113549.1.1.13", "SHA512");
        digestNames.put("1.2.840.113549.2.5", "MD5");
        digestNames.put("1.2.840.113549.2.2", "MD2");
        digestNames.put("1.2.840.10040.4.3", "SHA1");
        digestNames.put("2.16.840.1.101.3.4.3.1", "SHA224");
        digestNames.put("2.16.840.1.101.3.4.3.2", "SHA256");
        digestNames.put("2.16.840.1.101.3.4.3.3", "SHA384");
        digestNames.put("2.16.840.1.101.3.4.3.4", "SHA512");
        digestNames.put("1.3.36.3.3.1.3", "RIPEMD128");
        digestNames.put("1.3.36.3.3.1.2", "RIPEMD160");
        digestNames.put("1.3.36.3.3.1.4", "RIPEMD256");
        algorithmNames.put(ID_RSA, "RSA");
        algorithmNames.put(ID_DSA, "DSA");
        algorithmNames.put("1.2.840.113549.1.1.2", "RSA");
        algorithmNames.put("1.2.840.113549.1.1.4", "RSA");
        algorithmNames.put("1.2.840.113549.1.1.5", "RSA");
        algorithmNames.put("1.2.840.113549.1.1.14", "RSA");
        algorithmNames.put("1.2.840.113549.1.1.11", "RSA");
        algorithmNames.put("1.2.840.113549.1.1.12", "RSA");
        algorithmNames.put("1.2.840.113549.1.1.13", "RSA");
        algorithmNames.put("1.2.840.10040.4.3", "DSA");
        algorithmNames.put("2.16.840.1.101.3.4.3.1", "DSA");
        algorithmNames.put("2.16.840.1.101.3.4.3.2", "DSA");
        algorithmNames.put("1.3.36.3.3.1.3", "RSA");
        algorithmNames.put("1.3.36.3.3.1.2", "RSA");
        algorithmNames.put("1.3.36.3.3.1.4", "RSA");
        allowedDigests.put("MD5", "1.2.840.113549.2.5");
        allowedDigests.put("MD2", "1.2.840.113549.2.2");
        allowedDigests.put("SHA1", CertificateID.HASH_SHA1);
        allowedDigests.put("SHA224", "2.16.840.1.101.3.4.2.4");
        allowedDigests.put("SHA256", "2.16.840.1.101.3.4.2.1");
        allowedDigests.put("SHA384", "2.16.840.1.101.3.4.2.2");
        allowedDigests.put("SHA512", "2.16.840.1.101.3.4.2.3");
        allowedDigests.put("MD-5", "1.2.840.113549.2.5");
        allowedDigests.put("MD-2", "1.2.840.113549.2.2");
        allowedDigests.put("SHA-1", CertificateID.HASH_SHA1);
        allowedDigests.put("SHA-224", "2.16.840.1.101.3.4.2.4");
        allowedDigests.put("SHA-256", "2.16.840.1.101.3.4.2.1");
        allowedDigests.put("SHA-384", "2.16.840.1.101.3.4.2.2");
        allowedDigests.put("SHA-512", "2.16.840.1.101.3.4.2.3");
        allowedDigests.put("RIPEMD128", "1.3.36.3.2.2");
        allowedDigests.put("RIPEMD-128", "1.3.36.3.2.2");
        allowedDigests.put("RIPEMD160", "1.3.36.3.2.1");
        allowedDigests.put("RIPEMD-160", "1.3.36.3.2.1");
        allowedDigests.put("RIPEMD256", "1.3.36.3.2.3");
        allowedDigests.put("RIPEMD-256", "1.3.36.3.2.3");
    }

    public static String getDigest(String str) {
        String str2 = (String) digestNames.get(str);
        return str2 == null ? str : str2;
    }

    public static String getAlgorithm(String str) {
        String str2 = (String) algorithmNames.get(str);
        return str2 == null ? str : str2;
    }

    public TimeStampToken getTimeStampToken() {
        return this.timeStampToken;
    }

    public Calendar getTimeStampDate() {
        if (this.timeStampToken == null) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.timeStampToken.getTimeStampInfo().getGenTime());
        return gregorianCalendar;
    }

    public PdfPKCS7(byte[] bArr, byte[] bArr2, String str) {
        try {
            this.provider = str;
            X509CertParser x509CertParser = new X509CertParser();
            x509CertParser.engineInit(new ByteArrayInputStream(bArr2));
            this.certs = x509CertParser.engineReadAll();
            this.signCerts = this.certs;
            this.signCert = (X509Certificate) this.certs.iterator().next();
            this.crls = new ArrayList();
            this.digest = ((DEROctetString) new ASN1InputStream((InputStream) new ByteArrayInputStream(bArr)).readObject()).getOctets();
            if (str == null) {
                this.sig = Signature.getInstance("SHA1withRSA");
            } else {
                this.sig = Signature.getInstance("SHA1withRSA", str);
            }
            this.sig.initVerify(this.signCert.getPublicKey());
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public BasicOCSPResp getOcsp() {
        return this.basicResp;
    }

    private void findOcsp(ASN1Sequence aSN1Sequence) throws IOException {
        boolean z;
        this.basicResp = null;
        do {
            z = false;
            if (!(aSN1Sequence.getObjectAt(0) instanceof DERObjectIdentifier) || !((DERObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic.getId())) {
                int i = 0;
                while (true) {
                    if (i >= aSN1Sequence.size()) {
                        z = true;
                        continue;
                        break;
                    } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1Sequence) {
                        aSN1Sequence = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
                        continue;
                        break;
                    } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
                        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
                        if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
                            aSN1Sequence = (ASN1Sequence) aSN1TaggedObject.getObject();
                            continue;
                        } else {
                            return;
                        }
                    } else {
                        i++;
                    }
                }
            } else {
                this.basicResp = new BasicOCSPResp(BasicOCSPResponse.getInstance(new ASN1InputStream(((DEROctetString) aSN1Sequence.getObjectAt(1)).getOctets()).readObject()));
                return;
            }
        } while (!z);
    }

    public PdfPKCS7(byte[] bArr, String str) {
        Attribute attribute;
        try {
            this.provider = str;
            DERObject readObject = new ASN1InputStream((InputStream) new ByteArrayInputStream(bArr)).readObject();
            if (readObject instanceof ASN1Sequence) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) readObject;
                if (((DERObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId().equals(ID_PKCS7_SIGNED_DATA)) {
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) ((DERTaggedObject) aSN1Sequence.getObjectAt(1)).getObject();
                    this.version = ((DERInteger) aSN1Sequence2.getObjectAt(0)).getValue().intValue();
                    this.digestalgos = new HashSet();
                    Enumeration objects = ((ASN1Set) aSN1Sequence2.getObjectAt(1)).getObjects();
                    while (objects.hasMoreElements()) {
                        this.digestalgos.add(((DERObjectIdentifier) ((ASN1Sequence) objects.nextElement()).getObjectAt(0)).getId());
                    }
                    X509CertParser x509CertParser = new X509CertParser();
                    x509CertParser.engineInit(new ByteArrayInputStream(bArr));
                    this.certs = x509CertParser.engineReadAll();
                    X509CRLParser x509CRLParser = new X509CRLParser();
                    x509CRLParser.engineInit(new ByteArrayInputStream(bArr));
                    this.crls = x509CRLParser.engineReadAll();
                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.getObjectAt(2);
                    if (aSN1Sequence3.size() > 1) {
                        this.RSAdata = ((DEROctetString) ((DERTaggedObject) aSN1Sequence3.getObjectAt(1)).getObject()).getOctets();
                    }
                    int i = 3;
                    int i2 = 3;
                    while (aSN1Sequence2.getObjectAt(i2) instanceof DERTaggedObject) {
                        i2++;
                    }
                    ASN1Set aSN1Set = (ASN1Set) aSN1Sequence2.getObjectAt(i2);
                    if (aSN1Set.size() == 1) {
                        ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Set.getObjectAt(0);
                        this.signerversion = ((DERInteger) aSN1Sequence4.getObjectAt(0)).getValue().intValue();
                        BigInteger value = ((DERInteger) ((ASN1Sequence) aSN1Sequence4.getObjectAt(1)).getObjectAt(1)).getValue();
                        Iterator it = this.certs.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                X509Certificate x509Certificate = (X509Certificate) it.next();
                                if (value.equals(x509Certificate.getSerialNumber())) {
                                    this.signCert = x509Certificate;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (this.signCert != null) {
                            signCertificateChain();
                            this.digestAlgorithm = ((DERObjectIdentifier) ((ASN1Sequence) aSN1Sequence4.getObjectAt(2)).getObjectAt(0)).getId();
                            if (aSN1Sequence4.getObjectAt(3) instanceof ASN1TaggedObject) {
                                ASN1Set instance = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence4.getObjectAt(3), false);
                                this.sigAttr = instance.getEncoded(ASN1Encodable.DER);
                                for (int i3 = 0; i3 < instance.size(); i3++) {
                                    ASN1Sequence aSN1Sequence5 = (ASN1Sequence) instance.getObjectAt(i3);
                                    if (((DERObjectIdentifier) aSN1Sequence5.getObjectAt(0)).getId().equals(ID_MESSAGE_DIGEST)) {
                                        this.digestAttr = ((DEROctetString) ((ASN1Set) aSN1Sequence5.getObjectAt(1)).getObjectAt(0)).getOctets();
                                    } else if (((DERObjectIdentifier) aSN1Sequence5.getObjectAt(0)).getId().equals(ID_ADBE_REVOCATION)) {
                                        ASN1Sequence aSN1Sequence6 = (ASN1Sequence) ((ASN1Set) aSN1Sequence5.getObjectAt(1)).getObjectAt(0);
                                        for (int i4 = 0; i4 < aSN1Sequence6.size(); i4++) {
                                            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence6.getObjectAt(i4);
                                            if (aSN1TaggedObject.getTagNo() == 1) {
                                                findOcsp((ASN1Sequence) aSN1TaggedObject.getObject());
                                            }
                                        }
                                    }
                                }
                                if (this.digestAttr != null) {
                                    i = 4;
                                } else {
                                    throw new IllegalArgumentException("Authenticated attribute is missing the digest.");
                                }
                            }
                            int i5 = i + 1;
                            this.digestEncryptionAlgorithm = ((DERObjectIdentifier) ((ASN1Sequence) aSN1Sequence4.getObjectAt(i)).getObjectAt(0)).getId();
                            int i6 = i5 + 1;
                            this.digest = ((DEROctetString) aSN1Sequence4.getObjectAt(i5)).getOctets();
                            if (i6 < aSN1Sequence4.size() && (aSN1Sequence4.getObjectAt(i6) instanceof DERTaggedObject) && (attribute = new AttributeTable(ASN1Set.getInstance((DERTaggedObject) aSN1Sequence4.getObjectAt(i6), false)).get(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken)) != null) {
                                this.timeStampToken = new TimeStampToken(new ContentInfo(ASN1Sequence.getInstance(attribute.getAttrValues().getObjectAt(0))));
                            }
                            if (!(this.RSAdata == null && this.digestAttr == null)) {
                                if (str != null) {
                                    if (!str.startsWith("SunPKCS11")) {
                                        this.messageDigest = MessageDigest.getInstance(getHashAlgorithm(), str);
                                    }
                                }
                                this.messageDigest = MessageDigest.getInstance(getHashAlgorithm());
                            }
                            if (str == null) {
                                this.sig = Signature.getInstance(getDigestAlgorithm());
                            } else {
                                this.sig = Signature.getInstance(getDigestAlgorithm(), str);
                            }
                            this.sig.initVerify(this.signCert.getPublicKey());
                            return;
                        }
                        throw new IllegalArgumentException("Can't find signing certificate with serial " + value.toString(16));
                    }
                    throw new IllegalArgumentException("This PKCS#7 object has multiple SignerInfos - only one is supported at this time");
                }
                throw new IllegalArgumentException("Not a valid PKCS#7 object - not signed data");
            }
            throw new IllegalArgumentException("Not a valid PKCS#7 object - not a sequence");
        } catch (IOException unused) {
            throw new IllegalArgumentException("can't decode PKCS7SignedData object");
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfPKCS7(PrivateKey privateKey, Certificate[] certificateArr, CRL[] crlArr, String str, String str2, boolean z) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException {
        this.privKey = privateKey;
        this.provider = str2;
        this.digestAlgorithm = (String) allowedDigests.get(str.toUpperCase());
        if (this.digestAlgorithm != null) {
            this.signerversion = 1;
            this.version = 1;
            this.certs = new ArrayList();
            this.crls = new ArrayList();
            this.digestalgos = new HashSet();
            this.digestalgos.add(this.digestAlgorithm);
            this.signCert = certificateArr[0];
            for (Certificate add : certificateArr) {
                this.certs.add(add);
            }
            if (crlArr != null) {
                for (CRL add2 : crlArr) {
                    this.crls.add(add2);
                }
            }
            if (privateKey != null) {
                this.digestEncryptionAlgorithm = privateKey.getAlgorithm();
                if (this.digestEncryptionAlgorithm.equals("RSA")) {
                    this.digestEncryptionAlgorithm = ID_RSA;
                } else if (this.digestEncryptionAlgorithm.equals("DSA")) {
                    this.digestEncryptionAlgorithm = ID_DSA;
                } else {
                    throw new NoSuchAlgorithmException("Unknown Key Algorithm " + this.digestEncryptionAlgorithm);
                }
            }
            if (z) {
                this.RSAdata = new byte[0];
                if (str2 == null || str2.startsWith("SunPKCS11")) {
                    this.messageDigest = MessageDigest.getInstance(getHashAlgorithm());
                } else {
                    this.messageDigest = MessageDigest.getInstance(getHashAlgorithm(), str2);
                }
            }
            if (privateKey != null) {
                if (str2 == null) {
                    this.sig = Signature.getInstance(getDigestAlgorithm());
                } else {
                    this.sig = Signature.getInstance(getDigestAlgorithm(), str2);
                }
                this.sig.initSign(privateKey);
                return;
            }
            return;
        }
        throw new NoSuchAlgorithmException("Unknown Hash Algorithm " + str);
    }

    public void update(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.RSAdata == null && this.digestAttr == null) {
            this.sig.update(bArr, i, i2);
        } else {
            this.messageDigest.update(bArr, i, i2);
        }
    }

    public boolean verify() throws SignatureException {
        if (this.verified) {
            return this.verifyResult;
        }
        byte[] bArr = this.sigAttr;
        if (bArr != null) {
            this.sig.update(bArr);
            if (this.RSAdata != null) {
                this.messageDigest.update(this.messageDigest.digest());
            }
            this.verifyResult = Arrays.equals(this.messageDigest.digest(), this.digestAttr) && this.sig.verify(this.digest);
        } else {
            if (this.RSAdata != null) {
                this.sig.update(this.messageDigest.digest());
            }
            this.verifyResult = this.sig.verify(this.digest);
        }
        this.verified = true;
        return this.verifyResult;
    }

    public boolean verifyTimestampImprint() throws NoSuchAlgorithmException {
        TimeStampToken timeStampToken2 = this.timeStampToken;
        if (timeStampToken2 == null) {
            return false;
        }
        return Arrays.equals(MessageDigest.getInstance("SHA-1").digest(this.digest), timeStampToken2.getTimeStampInfo().toTSTInfo().getMessageImprint().getHashedMessage());
    }

    public Certificate[] getCertificates() {
        Collection collection = this.certs;
        return (X509Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public Certificate[] getSignCertificateChain() {
        Collection collection = this.signCerts;
        return (X509Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    private void signCertificateChain() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.signCert);
        ArrayList arrayList2 = new ArrayList(this.certs);
        int i = 0;
        while (i < arrayList2.size()) {
            if (this.signCert.getSerialNumber().equals(((X509Certificate) arrayList2.get(i)).getSerialNumber())) {
                arrayList2.remove(i);
                i--;
            }
            i++;
        }
        while (true) {
            boolean z2 = true;
            while (true) {
                if (!z2) {
                    this.signCerts = arrayList;
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
                int i2 = 0;
                z = false;
                while (true) {
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    try {
                        if (this.provider == null) {
                            x509Certificate.verify(((X509Certificate) arrayList2.get(i2)).getPublicKey());
                        } else {
                            x509Certificate.verify(((X509Certificate) arrayList2.get(i2)).getPublicKey(), this.provider);
                        }
                        try {
                            arrayList.add(arrayList2.get(i2));
                            arrayList2.remove(i2);
                        } catch (Exception unused) {
                            z = true;
                        }
                    } catch (Exception unused2) {
                    }
                    i2++;
                }
                z2 = z;
            }
        }
    }

    public Collection getCRLs() {
        return this.crls;
    }

    public X509Certificate getSigningCertificate() {
        return this.signCert;
    }

    public int getVersion() {
        return this.version;
    }

    public int getSigningInfoVersion() {
        return this.signerversion;
    }

    public String getDigestAlgorithm() {
        String algorithm = getAlgorithm(this.digestEncryptionAlgorithm);
        if (algorithm == null) {
            algorithm = this.digestEncryptionAlgorithm;
        }
        return String.valueOf(getHashAlgorithm()) + "with" + algorithm;
    }

    public String getHashAlgorithm() {
        return getDigest(this.digestAlgorithm);
    }

    public static KeyStore loadCacertsKeyStore() {
        return loadCacertsKeyStore((String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.KeyStore loadCacertsKeyStore(java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "java.home"
            java.lang.String r1 = java.lang.System.getProperty(r1)
            java.lang.String r2 = "lib"
            r0.<init>(r1, r2)
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "security"
            r1.<init>(r0, r2)
            java.io.File r0 = new java.io.File
            java.lang.String r2 = "cacerts"
            r0.<init>(r1, r2)
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003d }
            r2.<init>(r0)     // Catch:{ Exception -> 0x003d }
            java.lang.String r0 = "JKS"
            if (r3 != 0) goto L_0x002a
            java.security.KeyStore r3 = java.security.KeyStore.getInstance(r0)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            goto L_0x002e
        L_0x002a:
            java.security.KeyStore r3 = java.security.KeyStore.getInstance(r0, r3)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
        L_0x002e:
            r3.load(r2, r1)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r2.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            return r3
        L_0x0035:
            r3 = move-exception
            r1 = r2
            goto L_0x0044
        L_0x0038:
            r3 = move-exception
            r1 = r2
            goto L_0x003e
        L_0x003b:
            r3 = move-exception
            goto L_0x0044
        L_0x003d:
            r3 = move-exception
        L_0x003e:
            com.lowagie.text.ExceptionConverter r0 = new com.lowagie.text.ExceptionConverter     // Catch:{ all -> 0x003b }
            r0.<init>(r3)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x0044:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ Exception -> 0x0049 }
        L_0x0049:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfPKCS7.loadCacertsKeyStore(java.lang.String):java.security.KeyStore");
    }

    public static String verifyCertificate(X509Certificate x509Certificate, Collection collection, Calendar calendar) {
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        if (x509Certificate.hasUnsupportedCriticalExtension()) {
            return "Has unsupported critical extension";
        }
        try {
            x509Certificate.checkValidity(calendar.getTime());
            if (collection == null) {
                return null;
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (((CRL) it.next()).isRevoked(x509Certificate)) {
                    return "Certificate revoked";
                }
            }
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static Object[] verifyCertificates(Certificate[] certificateArr, KeyStore keyStore, Collection collection, Calendar calendar) {
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        for (int i = 0; i < certificateArr.length; i++) {
            X509Certificate x509Certificate = certificateArr[i];
            String verifyCertificate = verifyCertificate(x509Certificate, collection, calendar);
            if (verifyCertificate != null) {
                return new Object[]{x509Certificate, verifyCertificate};
            }
            try {
                Enumeration<String> aliases = keyStore.aliases();
                while (aliases.hasMoreElements()) {
                    try {
                        String nextElement = aliases.nextElement();
                        if (keyStore.isCertificateEntry(nextElement)) {
                            X509Certificate x509Certificate2 = (X509Certificate) keyStore.getCertificate(nextElement);
                            if (verifyCertificate(x509Certificate2, collection, calendar) == null) {
                                x509Certificate.verify(x509Certificate2.getPublicKey());
                                return null;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
            }
            int i2 = 0;
            while (i2 < certificateArr.length) {
                if (i2 != i) {
                    try {
                        x509Certificate.verify(certificateArr[i2].getPublicKey());
                        break;
                    } catch (Exception unused3) {
                        continue;
                    }
                }
                i2++;
            }
            if (i2 == certificateArr.length) {
                return new Object[]{x509Certificate, "Cannot be verified against the KeyStore or the certificate chain"};
            }
        }
        Object[] objArr = new Object[2];
        objArr[1] = "Invalid state. Possible circular certificate chain";
        return objArr;
    }

    public static boolean verifyOcspCertificates(BasicOCSPResp basicOCSPResp, KeyStore keyStore, String str) {
        if (str == null) {
            str = "BC";
        }
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                try {
                    String nextElement = aliases.nextElement();
                    if (keyStore.isCertificateEntry(nextElement)) {
                        if (basicOCSPResp.verify(((X509Certificate) keyStore.getCertificate(nextElement)).getPublicKey(), str)) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean verifyTimestampCertificates(TimeStampToken timeStampToken2, KeyStore keyStore, String str) {
        if (str == null) {
            str = "BC";
        }
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                try {
                    String nextElement = aliases.nextElement();
                    if (keyStore.isCertificateEntry(nextElement)) {
                        timeStampToken2.validate((X509Certificate) keyStore.getCertificate(nextElement), str);
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static String getOCSPURL(X509Certificate x509Certificate) throws CertificateParsingException {
        try {
            DERObject extensionValue = getExtensionValue(x509Certificate, X509Extensions.AuthorityInfoAccess.getId());
            if (extensionValue == null) {
                return null;
            }
            ASN1Sequence aSN1Sequence = (ASN1Sequence) extensionValue;
            for (int i = 0; i < aSN1Sequence.size(); i++) {
                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(i);
                if (aSN1Sequence2.size() == 2) {
                    if ((aSN1Sequence2.getObjectAt(0) instanceof DERObjectIdentifier) && ((DERObjectIdentifier) aSN1Sequence2.getObjectAt(0)).getId().equals(OCSPObjectIdentifiers.pkix_ocsp)) {
                        String stringFromGeneralName = getStringFromGeneralName((DERObject) aSN1Sequence2.getObjectAt(1));
                        return stringFromGeneralName == null ? "" : stringFromGeneralName;
                    }
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public boolean isRevocationValid() {
        if (this.basicResp == null || this.signCerts.size() < 2) {
            return false;
        }
        try {
            return new CertificateID(CertificateID.HASH_SHA1, ((X509Certificate[]) getSignCertificateChain())[1], getSigningCertificate().getSerialNumber()).equals(this.basicResp.getResponses()[0].getCertID());
        } catch (Exception unused) {
            return false;
        }
    }

    private static DERObject getExtensionValue(X509Certificate x509Certificate, String str) throws IOException {
        byte[] extensionValue = x509Certificate.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return new ASN1InputStream((InputStream) new ByteArrayInputStream(((ASN1OctetString) new ASN1InputStream((InputStream) new ByteArrayInputStream(extensionValue)).readObject()).getOctets())).readObject();
    }

    private static String getStringFromGeneralName(DERObject dERObject) throws IOException {
        return new String(ASN1OctetString.getInstance((DERTaggedObject) dERObject, false).getOctets(), "ISO-8859-1");
    }

    private static DERObject getIssuer(byte[] bArr) {
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream((InputStream) new ByteArrayInputStream(bArr)).readObject();
            return (DERObject) aSN1Sequence.getObjectAt(aSN1Sequence.getObjectAt(0) instanceof DERTaggedObject ? 3 : 2);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    private static DERObject getSubject(byte[] bArr) {
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream((InputStream) new ByteArrayInputStream(bArr)).readObject();
            return (DERObject) aSN1Sequence.getObjectAt(aSN1Sequence.getObjectAt(0) instanceof DERTaggedObject ? 5 : 4);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static X509Name getIssuerFields(X509Certificate x509Certificate) {
        try {
            return new X509Name((ASN1Sequence) getIssuer(x509Certificate.getTBSCertificate()));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static X509Name getSubjectFields(X509Certificate x509Certificate) {
        try {
            return new X509Name((ASN1Sequence) getSubject(x509Certificate.getTBSCertificate()));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public byte[] getEncodedPKCS1() {
        try {
            if (this.externalDigest != null) {
                this.digest = this.externalDigest;
            } else {
                this.digest = this.sig.sign();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DEROctetString(this.digest));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void setExternalDigest(byte[] bArr, byte[] bArr2, String str) {
        this.externalDigest = bArr;
        this.externalRSAdata = bArr2;
        if (str == null) {
            return;
        }
        if (str.equals("RSA")) {
            this.digestEncryptionAlgorithm = ID_RSA;
        } else if (str.equals("DSA")) {
            this.digestEncryptionAlgorithm = ID_DSA;
        } else {
            throw new ExceptionConverter(new NoSuchAlgorithmException("Unknown Key Algorithm " + str));
        }
    }

    public byte[] getEncodedPKCS7() {
        return getEncodedPKCS7((byte[]) null, (Calendar) null, (TSAClient) null, (byte[]) null);
    }

    public byte[] getEncodedPKCS7(byte[] bArr, Calendar calendar) {
        return getEncodedPKCS7(bArr, calendar, (TSAClient) null, (byte[]) null);
    }

    public byte[] getEncodedPKCS7(byte[] bArr, Calendar calendar, TSAClient tSAClient, byte[] bArr2) {
        byte[] timeStampToken2;
        ASN1EncodableVector buildUnauthenticatedAttributes;
        try {
            if (this.externalDigest != null) {
                this.digest = this.externalDigest;
                if (this.RSAdata != null) {
                    this.RSAdata = this.externalRSAdata;
                }
            } else if (this.externalRSAdata == null || this.RSAdata == null) {
                if (this.RSAdata != null) {
                    this.RSAdata = this.messageDigest.digest();
                    this.sig.update(this.RSAdata);
                }
                this.digest = this.sig.sign();
            } else {
                this.RSAdata = this.externalRSAdata;
                this.sig.update(this.RSAdata);
                this.digest = this.sig.sign();
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (String dERObjectIdentifier : this.digestalgos) {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                aSN1EncodableVector2.add(new DERObjectIdentifier(dERObjectIdentifier));
                aSN1EncodableVector2.add(DERNull.INSTANCE);
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            }
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new DERObjectIdentifier(ID_PKCS7_DATA));
            if (this.RSAdata != null) {
                aSN1EncodableVector3.add(new DERTaggedObject(0, new DEROctetString(this.RSAdata)));
            }
            DERSequence dERSequence = new DERSequence(aSN1EncodableVector3);
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            for (X509Certificate encoded : this.certs) {
                aSN1EncodableVector4.add(new ASN1InputStream((InputStream) new ByteArrayInputStream(encoded.getEncoded())).readObject());
            }
            DERSet dERSet = new DERSet(aSN1EncodableVector4);
            ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
            aSN1EncodableVector5.add(new DERInteger(this.signerversion));
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            aSN1EncodableVector6.add(getIssuer(this.signCert.getTBSCertificate()));
            aSN1EncodableVector6.add(new DERInteger(this.signCert.getSerialNumber()));
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector6));
            ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
            aSN1EncodableVector7.add(new DERObjectIdentifier(this.digestAlgorithm));
            aSN1EncodableVector7.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector7));
            if (!(bArr == null || calendar == null)) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 0, getAuthenticatedAttributeSet(bArr, calendar, bArr2)));
            }
            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
            aSN1EncodableVector8.add(new DERObjectIdentifier(this.digestEncryptionAlgorithm));
            aSN1EncodableVector8.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector8));
            aSN1EncodableVector5.add(new DEROctetString(this.digest));
            if (!(tSAClient == null || (timeStampToken2 = tSAClient.getTimeStampToken(this, MessageDigest.getInstance("SHA-1").digest(this.digest))) == null || (buildUnauthenticatedAttributes = buildUnauthenticatedAttributes(timeStampToken2)) == null)) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 1, new DERSet(buildUnauthenticatedAttributes)));
            }
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
            aSN1EncodableVector9.add(new DERInteger(this.version));
            aSN1EncodableVector9.add(new DERSet(aSN1EncodableVector));
            aSN1EncodableVector9.add(dERSequence);
            aSN1EncodableVector9.add(new DERTaggedObject(false, 0, dERSet));
            if (!this.crls.isEmpty()) {
                ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                for (X509CRL encoded2 : this.crls) {
                    aSN1EncodableVector10.add(new ASN1InputStream((InputStream) new ByteArrayInputStream(encoded2.getEncoded())).readObject());
                }
                aSN1EncodableVector9.add(new DERTaggedObject(false, 1, new DERSet(aSN1EncodableVector10)));
            }
            aSN1EncodableVector9.add(new DERSet((DEREncodable) new DERSequence(aSN1EncodableVector5)));
            ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
            aSN1EncodableVector11.add(new DERObjectIdentifier(ID_PKCS7_SIGNED_DATA));
            aSN1EncodableVector11.add(new DERTaggedObject(0, new DERSequence(aSN1EncodableVector9)));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DERSequence(aSN1EncodableVector11));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private ASN1EncodableVector buildUnauthenticatedAttributes(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream((InputStream) new ByteArrayInputStream(bArr));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(new DERObjectIdentifier("1.2.840.113549.1.9.16.2.14"));
        aSN1EncodableVector2.add(new DERSet((DEREncodable) (ASN1Sequence) aSN1InputStream.readObject()));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        return aSN1EncodableVector;
    }

    public byte[] getAuthenticatedAttributeBytes(byte[] bArr, Calendar calendar, byte[] bArr2) {
        try {
            return getAuthenticatedAttributeSet(bArr, calendar, bArr2).getEncoded(ASN1Encodable.DER);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private DERSet getAuthenticatedAttributeSet(byte[] bArr, Calendar calendar, byte[] bArr2) {
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new DERObjectIdentifier(ID_CONTENT_TYPE));
            aSN1EncodableVector2.add(new DERSet((DEREncodable) new DERObjectIdentifier(ID_PKCS7_DATA)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new DERObjectIdentifier(ID_SIGNING_TIME));
            aSN1EncodableVector3.add(new DERSet((DEREncodable) new DERUTCTime(calendar.getTime())));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            aSN1EncodableVector4.add(new DERObjectIdentifier(ID_MESSAGE_DIGEST));
            aSN1EncodableVector4.add(new DERSet((DEREncodable) new DEROctetString(bArr)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
            if (bArr2 != null) {
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                aSN1EncodableVector5.add(new DERObjectIdentifier(ID_ADBE_REVOCATION));
                DEROctetString dEROctetString = new DEROctetString(bArr2);
                ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
                ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                aSN1EncodableVector7.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
                aSN1EncodableVector7.add(dEROctetString);
                DEREnumerated dEREnumerated = new DEREnumerated(0);
                ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                aSN1EncodableVector8.add(dEREnumerated);
                aSN1EncodableVector8.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector7)));
                aSN1EncodableVector6.add(new DERSequence(aSN1EncodableVector8));
                aSN1EncodableVector5.add(new DERSet((DEREncodable) new DERSequence((DEREncodable) new DERTaggedObject(true, 1, new DERSequence(aSN1EncodableVector6)))));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector5));
            } else if (!this.crls.isEmpty()) {
                ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                aSN1EncodableVector9.add(new DERObjectIdentifier(ID_ADBE_REVOCATION));
                ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                for (X509CRL encoded : this.crls) {
                    aSN1EncodableVector10.add(new ASN1InputStream((InputStream) new ByteArrayInputStream(encoded.getEncoded())).readObject());
                }
                aSN1EncodableVector9.add(new DERSet((DEREncodable) new DERSequence((DEREncodable) new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector10)))));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector9));
            }
            return new DERSet(aSN1EncodableVector);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public Calendar getSignDate() {
        return this.signDate;
    }

    public void setSignDate(Calendar calendar) {
        this.signDate = calendar;
    }

    public String getSignName() {
        return this.signName;
    }

    public void setSignName(String str) {
        this.signName = str;
    }

    public static class X509Name {

        /* renamed from: C */
        public static final DERObjectIdentifier f748C = new DERObjectIdentifier("2.5.4.6");

        /* renamed from: CN */
        public static final DERObjectIdentifier f749CN = new DERObjectIdentifier("2.5.4.3");

        /* renamed from: DC */
        public static final DERObjectIdentifier f750DC = new DERObjectIdentifier("0.9.2342.19200300.100.1.25");
        public static HashMap DefaultSymbols = new HashMap();

        /* renamed from: E */
        public static final DERObjectIdentifier f751E = EmailAddress;
        public static final DERObjectIdentifier EmailAddress = new DERObjectIdentifier("1.2.840.113549.1.9.1");
        public static final DERObjectIdentifier GENERATION = new DERObjectIdentifier("2.5.4.44");
        public static final DERObjectIdentifier GIVENNAME = new DERObjectIdentifier("2.5.4.42");
        public static final DERObjectIdentifier INITIALS = new DERObjectIdentifier("2.5.4.43");

        /* renamed from: L */
        public static final DERObjectIdentifier f752L = new DERObjectIdentifier("2.5.4.7");

        /* renamed from: O */
        public static final DERObjectIdentifier f753O = new DERObjectIdentifier("2.5.4.10");

        /* renamed from: OU */
        public static final DERObjectIdentifier f754OU = new DERObjectIdentifier("2.5.4.11");

        /* renamed from: SN */
        public static final DERObjectIdentifier f755SN = new DERObjectIdentifier("2.5.4.5");

        /* renamed from: ST */
        public static final DERObjectIdentifier f756ST = new DERObjectIdentifier("2.5.4.8");
        public static final DERObjectIdentifier SURNAME = new DERObjectIdentifier("2.5.4.4");

        /* renamed from: T */
        public static final DERObjectIdentifier f757T = new DERObjectIdentifier("2.5.4.12");
        public static final DERObjectIdentifier UID = new DERObjectIdentifier("0.9.2342.19200300.100.1.1");
        public static final DERObjectIdentifier UNIQUE_IDENTIFIER = new DERObjectIdentifier("2.5.4.45");
        public HashMap values = new HashMap();

        static {
            DefaultSymbols.put(f748C, "C");
            DefaultSymbols.put(f753O, "O");
            DefaultSymbols.put(f757T, ExifInterface.GPS_DIRECTION_TRUE);
            DefaultSymbols.put(f754OU, "OU");
            DefaultSymbols.put(f749CN, "CN");
            DefaultSymbols.put(f752L, "L");
            DefaultSymbols.put(f756ST, "ST");
            DefaultSymbols.put(f755SN, "SN");
            DefaultSymbols.put(EmailAddress, ExifInterface.LONGITUDE_EAST);
            DefaultSymbols.put(f750DC, "DC");
            DefaultSymbols.put(UID, "UID");
            DefaultSymbols.put(SURNAME, "SURNAME");
            DefaultSymbols.put(GIVENNAME, "GIVENNAME");
            DefaultSymbols.put(INITIALS, "INITIALS");
            DefaultSymbols.put(GENERATION, "GENERATION");
        }

        public X509Name(ASN1Sequence aSN1Sequence) {
            Enumeration objects = aSN1Sequence.getObjects();
            while (objects.hasMoreElements()) {
                ASN1Set aSN1Set = (ASN1Set) objects.nextElement();
                for (int i = 0; i < aSN1Set.size(); i++) {
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Set.getObjectAt(i);
                    String str = (String) DefaultSymbols.get(aSN1Sequence2.getObjectAt(0));
                    if (str != null) {
                        ArrayList arrayList = (ArrayList) this.values.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.values.put(str, arrayList);
                        }
                        arrayList.add(((DERString) aSN1Sequence2.getObjectAt(1)).getString());
                    }
                }
            }
        }

        public X509Name(String str) {
            X509NameTokenizer x509NameTokenizer = new X509NameTokenizer(str);
            while (x509NameTokenizer.hasMoreTokens()) {
                String nextToken = x509NameTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf != -1) {
                    String upperCase = nextToken.substring(0, indexOf).toUpperCase();
                    String substring = nextToken.substring(indexOf + 1);
                    ArrayList arrayList = (ArrayList) this.values.get(upperCase);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        this.values.put(upperCase, arrayList);
                    }
                    arrayList.add(substring);
                } else {
                    throw new IllegalArgumentException("badly formated directory string");
                }
            }
        }

        public String getField(String str) {
            ArrayList arrayList = (ArrayList) this.values.get(str);
            if (arrayList == null) {
                return null;
            }
            return (String) arrayList.get(0);
        }

        public ArrayList getFieldArray(String str) {
            ArrayList arrayList = (ArrayList) this.values.get(str);
            if (arrayList == null) {
                return null;
            }
            return arrayList;
        }

        public HashMap getFields() {
            return this.values;
        }

        public String toString() {
            return this.values.toString();
        }
    }

    public static class X509NameTokenizer {
        private StringBuffer buf = new StringBuffer();
        private int index;
        private String oid;

        public X509NameTokenizer(String str) {
            this.oid = str;
            this.index = -1;
        }

        public boolean hasMoreTokens() {
            return this.index != this.oid.length();
        }

        public String nextToken() {
            if (this.index == this.oid.length()) {
                return null;
            }
            int i = this.index + 1;
            this.buf.setLength(0);
            boolean z = false;
            boolean z2 = false;
            while (i != this.oid.length()) {
                char charAt = this.oid.charAt(i);
                if (charAt == '\"') {
                    if (!z) {
                        z2 = !z2;
                    } else {
                        this.buf.append(charAt);
                    }
                } else if (z || z2) {
                    this.buf.append(charAt);
                } else {
                    if (charAt == '\\') {
                        z = true;
                    } else if (charAt == ',') {
                        break;
                    } else {
                        this.buf.append(charAt);
                    }
                    i++;
                }
                z = false;
                i++;
            }
            this.index = i;
            return this.buf.toString().trim();
        }
    }
}
