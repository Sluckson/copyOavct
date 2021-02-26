package repack.org.bouncycastle.openssl;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import repack.org.bouncycastle.asn1.x509.DSAParameter;
import repack.org.bouncycastle.jce.PKCS10CertificationRequest;
import repack.org.bouncycastle.util.Strings;
import repack.org.bouncycastle.util.encoders.Hex;
import repack.org.bouncycastle.util.p072io.pem.PemGenerationException;
import repack.org.bouncycastle.util.p072io.pem.PemHeader;
import repack.org.bouncycastle.util.p072io.pem.PemObject;
import repack.org.bouncycastle.util.p072io.pem.PemObjectGenerator;
import repack.org.bouncycastle.x509.X509AttributeCertificate;
import repack.org.bouncycastle.x509.X509V2AttributeCertificate;

public class MiscPEMGenerator implements PemObjectGenerator {
    private String algorithm;
    private Object obj;
    private char[] password;
    private Provider provider;
    private SecureRandom random;

    public MiscPEMGenerator(Object obj2) {
        this.obj = obj2;
    }

    public MiscPEMGenerator(Object obj2, String str, char[] cArr, SecureRandom secureRandom, Provider provider2) {
        this.obj = obj2;
        this.algorithm = str;
        this.password = cArr;
        this.random = secureRandom;
        this.provider = provider2;
    }

    public MiscPEMGenerator(Object obj2, String str, char[] cArr, SecureRandom secureRandom, String str2) throws NoSuchProviderException {
        this.obj = obj2;
        this.algorithm = str;
        this.password = cArr;
        this.random = secureRandom;
        if (str2 != null) {
            this.provider = Security.getProvider(str2);
            if (this.provider == null) {
                throw new NoSuchProviderException("cannot find provider: " + str2);
            }
        }
    }

    private PemObject createPemObject(Object obj2) throws IOException {
        byte[] bArr;
        String str;
        if (obj2 instanceof PemObject) {
            return (PemObject) obj2;
        }
        if (obj2 instanceof PemObjectGenerator) {
            return ((PemObjectGenerator) obj2).generate();
        }
        if (obj2 instanceof X509Certificate) {
            try {
                bArr = ((X509Certificate) obj2).getEncoded();
                str = "CERTIFICATE";
            } catch (CertificateEncodingException e) {
                throw new PemGenerationException("Cannot encode object: " + e.toString());
            }
        } else if (obj2 instanceof X509CRL) {
            try {
                bArr = ((X509CRL) obj2).getEncoded();
                str = "X509 CRL";
            } catch (CRLException e2) {
                throw new PemGenerationException("Cannot encode object: " + e2.toString());
            }
        } else if (obj2 instanceof KeyPair) {
            return createPemObject(((KeyPair) obj2).getPrivate());
        } else {
            if (obj2 instanceof PrivateKey) {
                PrivateKeyInfo privateKeyInfo = new PrivateKeyInfo((ASN1Sequence) ASN1Object.fromByteArray(((Key) obj2).getEncoded()));
                if (obj2 instanceof RSAPrivateKey) {
                    bArr = privateKeyInfo.getPrivateKey().getEncoded();
                    str = "RSA PRIVATE KEY";
                } else if (obj2 instanceof DSAPrivateKey) {
                    DSAParameter instance = DSAParameter.getInstance(privateKeyInfo.getAlgorithmId().getParameters());
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    aSN1EncodableVector.add(new DERInteger(0));
                    aSN1EncodableVector.add(new DERInteger(instance.getP()));
                    aSN1EncodableVector.add(new DERInteger(instance.getQ()));
                    aSN1EncodableVector.add(new DERInteger(instance.getG()));
                    BigInteger x = ((DSAPrivateKey) obj2).getX();
                    aSN1EncodableVector.add(new DERInteger(instance.getG().modPow(x, instance.getP())));
                    aSN1EncodableVector.add(new DERInteger(x));
                    bArr = new DERSequence(aSN1EncodableVector).getEncoded();
                    str = "DSA PRIVATE KEY";
                } else if (((PrivateKey) obj2).getAlgorithm().equals("ECDSA")) {
                    bArr = privateKeyInfo.getPrivateKey().getEncoded();
                    str = "EC PRIVATE KEY";
                } else {
                    throw new IOException("Cannot identify private key");
                }
            } else if (obj2 instanceof PublicKey) {
                bArr = ((PublicKey) obj2).getEncoded();
                str = "PUBLIC KEY";
            } else if (obj2 instanceof X509AttributeCertificate) {
                bArr = ((X509V2AttributeCertificate) obj2).getEncoded();
                str = "ATTRIBUTE CERTIFICATE";
            } else if (obj2 instanceof PKCS10CertificationRequest) {
                bArr = ((PKCS10CertificationRequest) obj2).getEncoded();
                str = "CERTIFICATE REQUEST";
            } else if (obj2 instanceof ContentInfo) {
                bArr = ((ContentInfo) obj2).getEncoded();
                str = "PKCS7";
            } else {
                throw new PemGenerationException("unknown object passed - can't encode.");
            }
        }
        return new PemObject(str, bArr);
    }

    private String getHexEncoded(byte[] bArr) throws IOException {
        byte[] encode = Hex.encode(bArr);
        char[] cArr = new char[encode.length];
        for (int i = 0; i != encode.length; i++) {
            cArr[i] = (char) encode[i];
        }
        return new String(cArr);
    }

    private PemObject createPemObject(Object obj2, String str, char[] cArr, SecureRandom secureRandom) throws IOException {
        byte[] bArr;
        String str2;
        byte[] encoded;
        if (obj2 instanceof KeyPair) {
            return createPemObject(((KeyPair) obj2).getPrivate(), str, cArr, secureRandom);
        }
        if (obj2 instanceof RSAPrivateCrtKey) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj2;
            encoded = new RSAPrivateKeyStructure(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient()).getEncoded();
            str2 = "RSA PRIVATE KEY";
        } else if (obj2 instanceof DSAPrivateKey) {
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) obj2;
            DSAParams params = dSAPrivateKey.getParams();
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(new DERInteger(0));
            aSN1EncodableVector.add(new DERInteger(params.getP()));
            aSN1EncodableVector.add(new DERInteger(params.getQ()));
            aSN1EncodableVector.add(new DERInteger(params.getG()));
            BigInteger x = dSAPrivateKey.getX();
            aSN1EncodableVector.add(new DERInteger(params.getG().modPow(x, params.getP())));
            aSN1EncodableVector.add(new DERInteger(x));
            encoded = new DERSequence(aSN1EncodableVector).getEncoded();
            str2 = "DSA PRIVATE KEY";
        } else {
            if (obj2 instanceof PrivateKey) {
                PrivateKey privateKey = (PrivateKey) obj2;
                if ("ECDSA".equals(privateKey.getAlgorithm())) {
                    encoded = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(privateKey.getEncoded())).getPrivateKey().getEncoded();
                    str2 = "EC PRIVATE KEY";
                }
            }
            str2 = null;
            bArr = null;
            if (str2 != null || bArr == null) {
                throw new IllegalArgumentException("Object type not supported: " + obj2.getClass().getName());
            }
            String upperCase = Strings.toUpperCase(str);
            if (upperCase.equals("DESEDE")) {
                upperCase = "DES-EDE3-CBC";
            }
            byte[] bArr2 = new byte[(upperCase.startsWith("AES-") ? 16 : 8)];
            secureRandom.nextBytes(bArr2);
            byte[] crypt = PEMUtilities.crypt(true, this.provider, bArr, cArr, upperCase, bArr2);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
            arrayList.add(new PemHeader("DEK-Info", String.valueOf(upperCase) + "," + getHexEncoded(bArr2)));
            return new PemObject(str2, arrayList, crypt);
        }
        bArr = encoded;
        if (str2 != null) {
        }
        throw new IllegalArgumentException("Object type not supported: " + obj2.getClass().getName());
    }

    public PemObject generate() throws PemGenerationException {
        try {
            if (this.algorithm != null) {
                return createPemObject(this.obj, this.algorithm, this.password, this.random);
            }
            return createPemObject(this.obj);
        } catch (IOException e) {
            throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        }
    }
}
