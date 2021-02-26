package repack.org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.TBSCertificateStructure;
import repack.org.bouncycastle.asn1.x509.Time;
import repack.org.bouncycastle.asn1.x509.V1TBSCertificateGenerator;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509Name;
import repack.org.bouncycastle.jce.X509Principal;
import repack.org.bouncycastle.jce.provider.X509CertificateObject;

public class X509V1CertificateGenerator {
    private AlgorithmIdentifier sigAlgId;
    private DERObjectIdentifier sigOID;
    private String signatureAlgorithm;
    private V1TBSCertificateGenerator tbsGen = new V1TBSCertificateGenerator();

    public void reset() {
        this.tbsGen = new V1TBSCertificateGenerator();
    }

    public void setSerialNumber(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) > 0) {
            this.tbsGen.setSerialNumber(new DERInteger(bigInteger));
            return;
        }
        throw new IllegalArgumentException("serial number must be a positive integer");
    }

    public void setIssuerDN(X500Principal x500Principal) {
        try {
            this.tbsGen.setIssuer((X509Name) new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("can't process principal: " + e);
        }
    }

    public void setIssuerDN(X509Name x509Name) {
        this.tbsGen.setIssuer(x509Name);
    }

    public void setNotBefore(Date date) {
        this.tbsGen.setStartDate(new Time(date));
    }

    public void setNotAfter(Date date) {
        this.tbsGen.setEndDate(new Time(date));
    }

    public void setSubjectDN(X500Principal x500Principal) {
        try {
            this.tbsGen.setSubject((X509Name) new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("can't process principal: " + e);
        }
    }

    public void setSubjectDN(X509Name x509Name) {
        this.tbsGen.setSubject(x509Name);
    }

    public void setPublicKey(PublicKey publicKey) {
        try {
            this.tbsGen.setSubjectPublicKeyInfo(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream((InputStream) new ByteArrayInputStream(publicKey.getEncoded())).readObject()));
        } catch (Exception e) {
            throw new IllegalArgumentException("unable to process key - " + e.toString());
        }
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
        try {
            this.sigOID = X509Util.getAlgorithmOID(str);
            this.sigAlgId = X509Util.getSigAlgID(this.sigOID, str);
            this.tbsGen.setSignature(this.sigAlgId);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509Certificate(privateKey, "BC", (SecureRandom) null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, SecureRandom secureRandom) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509Certificate(privateKey, "BC", secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, String str) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        return generateX509Certificate(privateKey, str, (SecureRandom) null);
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        try {
            return generate(privateKey, str, secureRandom);
        } catch (NoSuchProviderException e) {
            throw e;
        } catch (SignatureException e2) {
            throw e2;
        } catch (InvalidKeyException e3) {
            throw e3;
        } catch (GeneralSecurityException e4) {
            throw new SecurityException("exception: " + e4);
        }
    }

    public X509Certificate generate(PrivateKey privateKey) throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, (SecureRandom) null);
    }

    public X509Certificate generate(PrivateKey privateKey, SecureRandom secureRandom) throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertificateStructure generateTBSCertificate = this.tbsGen.generateTBSCertificate();
        try {
            return generateJcaObject(generateTBSCertificate, X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, privateKey, secureRandom, generateTBSCertificate));
        } catch (IOException e) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e);
        }
    }

    public X509Certificate generate(PrivateKey privateKey, String str) throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, str, (SecureRandom) null);
    }

    public X509Certificate generate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertificateStructure generateTBSCertificate = this.tbsGen.generateTBSCertificate();
        try {
            return generateJcaObject(generateTBSCertificate, X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, str, privateKey, secureRandom, generateTBSCertificate));
        } catch (IOException e) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e);
        }
    }

    private X509Certificate generateJcaObject(TBSCertificateStructure tBSCertificateStructure, byte[] bArr) throws CertificateEncodingException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(tBSCertificateStructure);
        aSN1EncodableVector.add(this.sigAlgId);
        aSN1EncodableVector.add(new DERBitString(bArr));
        try {
            return new X509CertificateObject(new X509CertificateStructure(new DERSequence(aSN1EncodableVector)));
        } catch (CertificateParsingException e) {
            throw new ExtCertificateEncodingException("exception producing certificate object", e);
        }
    }

    public Iterator getSignatureAlgNames() {
        return X509Util.getAlgNames();
    }
}
