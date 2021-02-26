package repack.org.bouncycastle.openssl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateFactory;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import repack.org.bouncycastle.asn1.pkcs.EncryptionScheme;
import repack.org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import repack.org.bouncycastle.asn1.pkcs.PBEParameter;
import repack.org.bouncycastle.asn1.pkcs.PBES2Parameters;
import repack.org.bouncycastle.asn1.pkcs.PBKDF2Params;
import repack.org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.sec.ECPrivateKeyStructure;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.RSAPublicKeyStructure;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.jce.ECNamedCurveTable;
import repack.org.bouncycastle.jce.PKCS10CertificationRequest;
import repack.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import repack.org.bouncycastle.util.encoders.Hex;
import repack.org.bouncycastle.util.p072io.pem.PemHeader;
import repack.org.bouncycastle.util.p072io.pem.PemObject;
import repack.org.bouncycastle.util.p072io.pem.PemObjectParser;
import repack.org.bouncycastle.util.p072io.pem.PemReader;
import repack.org.bouncycastle.x509.X509V2AttributeCertificate;

public class PEMReader extends PemReader {
    /* access modifiers changed from: private */
    public PasswordFinder pFinder;
    private final Map parsers;

    public PEMReader(Reader reader) {
        this(reader, (PasswordFinder) null, "BC");
    }

    public PEMReader(Reader reader, PasswordFinder passwordFinder) {
        this(reader, passwordFinder, "BC");
    }

    public PEMReader(Reader reader, PasswordFinder passwordFinder, String str) {
        this(reader, passwordFinder, str, str);
    }

    public PEMReader(Reader reader, PasswordFinder passwordFinder, String str, String str2) {
        super(reader);
        this.parsers = new HashMap();
        this.pFinder = passwordFinder;
        this.parsers.put("CERTIFICATE REQUEST", new PKCS10CertificationRequestParser(this, (PKCS10CertificationRequestParser) null));
        this.parsers.put("NEW CERTIFICATE REQUEST", new PKCS10CertificationRequestParser(this, (PKCS10CertificationRequestParser) null));
        this.parsers.put("CERTIFICATE", new X509CertificateParser(str2));
        this.parsers.put("X509 CERTIFICATE", new X509CertificateParser(str2));
        this.parsers.put("X509 CRL", new X509CRLParser(str2));
        this.parsers.put("PKCS7", new PKCS7Parser(this, (PKCS7Parser) null));
        this.parsers.put("ATTRIBUTE CERTIFICATE", new X509AttributeCertificateParser(this, (X509AttributeCertificateParser) null));
        this.parsers.put("EC PARAMETERS", new ECNamedCurveSpecParser(this, (ECNamedCurveSpecParser) null));
        this.parsers.put("PUBLIC KEY", new PublicKeyParser(str2));
        this.parsers.put("RSA PUBLIC KEY", new RSAPublicKeyParser(str2));
        this.parsers.put("RSA PRIVATE KEY", new RSAKeyPairParser(str2));
        this.parsers.put("DSA PRIVATE KEY", new DSAKeyPairParser(str2));
        this.parsers.put("EC PRIVATE KEY", new ECDSAKeyPairParser(str2));
        this.parsers.put("ENCRYPTED PRIVATE KEY", new EncryptedPrivateKeyParser(str, str2));
        this.parsers.put("PRIVATE KEY", new PrivateKeyParser(str2));
    }

    public Object readObject() throws IOException {
        PemObject readPemObject = readPemObject();
        if (readPemObject == null) {
            return null;
        }
        String type = readPemObject.getType();
        if (this.parsers.containsKey(type)) {
            return ((PemObjectParser) this.parsers.get(type)).parseObject(readPemObject);
        }
        throw new IOException("unrecognised object: " + type);
    }

    private abstract class KeyPairParser implements PemObjectParser {
        protected String provider;

        public KeyPairParser(String str) {
            this.provider = str;
        }

        /* access modifiers changed from: protected */
        public ASN1Sequence readKeyPair(PemObject pemObject) throws IOException {
            boolean z = false;
            String str = null;
            for (PemHeader pemHeader : pemObject.getHeaders()) {
                if (pemHeader.getName().equals("Proc-Type") && pemHeader.getValue().equals("4,ENCRYPTED")) {
                    z = true;
                } else if (pemHeader.getName().equals("DEK-Info")) {
                    str = pemHeader.getValue();
                }
            }
            byte[] content = pemObject.getContent();
            if (z) {
                if (PEMReader.this.pFinder != null) {
                    char[] password = PEMReader.this.pFinder.getPassword();
                    if (password != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
                        content = PEMUtilities.crypt(false, this.provider, content, password, stringTokenizer.nextToken(), Hex.decode(stringTokenizer.nextToken()));
                    } else {
                        throw new PasswordException("Password is null, but a password is required");
                    }
                } else {
                    throw new PasswordException("No password finder specified, but a password is required");
                }
            }
            try {
                return (ASN1Sequence) ASN1Object.fromByteArray(content);
            } catch (IOException e) {
                if (z) {
                    throw new PEMException("exception decoding - please check password and data.", e);
                }
                throw new PEMException(e.getMessage(), e);
            } catch (ClassCastException e2) {
                if (z) {
                    throw new PEMException("exception decoding - please check password and data.", e2);
                }
                throw new PEMException(e2.getMessage(), e2);
            }
        }
    }

    private class DSAKeyPairParser extends KeyPairParser {
        public DSAKeyPairParser(String str) {
            super(str);
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                ASN1Sequence readKeyPair = readKeyPair(pemObject);
                if (readKeyPair.size() == 6) {
                    DERInteger dERInteger = (DERInteger) readKeyPair.getObjectAt(1);
                    DERInteger dERInteger2 = (DERInteger) readKeyPair.getObjectAt(2);
                    DERInteger dERInteger3 = (DERInteger) readKeyPair.getObjectAt(3);
                    DSAPrivateKeySpec dSAPrivateKeySpec = new DSAPrivateKeySpec(((DERInteger) readKeyPair.getObjectAt(5)).getValue(), dERInteger.getValue(), dERInteger2.getValue(), dERInteger3.getValue());
                    DSAPublicKeySpec dSAPublicKeySpec = new DSAPublicKeySpec(((DERInteger) readKeyPair.getObjectAt(4)).getValue(), dERInteger.getValue(), dERInteger2.getValue(), dERInteger3.getValue());
                    KeyFactory instance = KeyFactory.getInstance("DSA", this.provider);
                    return new KeyPair(instance.generatePublic(dSAPublicKeySpec), instance.generatePrivate(dSAPrivateKeySpec));
                }
                throw new PEMException("malformed sequence in DSA private key");
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("problem creating DSA private key: " + e2.toString(), e2);
            }
        }
    }

    private class ECDSAKeyPairParser extends KeyPairParser {
        public ECDSAKeyPairParser(String str) {
            super(str);
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                ECPrivateKeyStructure eCPrivateKeyStructure = new ECPrivateKeyStructure(readKeyPair(pemObject));
                AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, eCPrivateKeyStructure.getParameters());
                PrivateKeyInfo privateKeyInfo = new PrivateKeyInfo(algorithmIdentifier, eCPrivateKeyStructure.getDERObject());
                SubjectPublicKeyInfo subjectPublicKeyInfo = new SubjectPublicKeyInfo(algorithmIdentifier, eCPrivateKeyStructure.getPublicKey().getBytes());
                PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyInfo.getEncoded());
                X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded());
                KeyFactory instance = KeyFactory.getInstance("ECDSA", this.provider);
                return new KeyPair(instance.generatePublic(x509EncodedKeySpec), instance.generatePrivate(pKCS8EncodedKeySpec));
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("problem creating EC private key: " + e2.toString(), e2);
            }
        }
    }

    private class RSAKeyPairParser extends KeyPairParser {
        public RSAKeyPairParser(String str) {
            super(str);
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                ASN1Sequence readKeyPair = readKeyPair(pemObject);
                if (readKeyPair.size() == 9) {
                    DERInteger dERInteger = (DERInteger) readKeyPair.getObjectAt(1);
                    DERInteger dERInteger2 = (DERInteger) readKeyPair.getObjectAt(2);
                    RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec(dERInteger.getValue(), dERInteger2.getValue());
                    RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec = new RSAPrivateCrtKeySpec(dERInteger.getValue(), dERInteger2.getValue(), ((DERInteger) readKeyPair.getObjectAt(3)).getValue(), ((DERInteger) readKeyPair.getObjectAt(4)).getValue(), ((DERInteger) readKeyPair.getObjectAt(5)).getValue(), ((DERInteger) readKeyPair.getObjectAt(6)).getValue(), ((DERInteger) readKeyPair.getObjectAt(7)).getValue(), ((DERInteger) readKeyPair.getObjectAt(8)).getValue());
                    try {
                        KeyFactory instance = KeyFactory.getInstance("RSA", this.provider);
                        return new KeyPair(instance.generatePublic(rSAPublicKeySpec), instance.generatePrivate(rSAPrivateCrtKeySpec));
                    } catch (IOException e) {
                        e = e;
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        throw new PEMException("problem creating RSA private key: " + e.toString(), e);
                    }
                } else {
                    throw new PEMException("malformed sequence in RSA private key");
                }
            } catch (IOException e3) {
                e = e3;
                throw e;
            } catch (Exception e4) {
                e = e4;
                throw new PEMException("problem creating RSA private key: " + e.toString(), e);
            }
        }
    }

    private class PublicKeyParser implements PemObjectParser {
        private String provider;

        public PublicKeyParser(String str) {
            this.provider = str;
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(pemObject.getContent());
            String[] strArr = {"DSA", "RSA"};
            int i = 0;
            while (i < strArr.length) {
                try {
                    return KeyFactory.getInstance(strArr[i], this.provider).generatePublic(x509EncodedKeySpec);
                } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
                    i++;
                } catch (NoSuchProviderException unused2) {
                    throw new RuntimeException("can't find provider " + this.provider);
                }
            }
            return null;
        }
    }

    private class RSAPublicKeyParser implements PemObjectParser {
        private String provider;

        public RSAPublicKeyParser(String str) {
            this.provider = str;
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                RSAPublicKeyStructure rSAPublicKeyStructure = new RSAPublicKeyStructure((ASN1Sequence) new ASN1InputStream(pemObject.getContent()).readObject());
                return KeyFactory.getInstance("RSA", this.provider).generatePublic(new RSAPublicKeySpec(rSAPublicKeyStructure.getModulus(), rSAPublicKeyStructure.getPublicExponent()));
            } catch (IOException e) {
                throw e;
            } catch (NoSuchProviderException unused) {
                throw new IOException("can't find provider " + this.provider);
            } catch (Exception e2) {
                throw new PEMException("problem extracting key: " + e2.toString(), e2);
            }
        }
    }

    private class X509CertificateParser implements PemObjectParser {
        private String provider;

        public X509CertificateParser(String str) {
            this.provider = str;
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return CertificateFactory.getInstance("X.509", this.provider).generateCertificate(new ByteArrayInputStream(pemObject.getContent()));
            } catch (Exception e) {
                throw new PEMException("problem parsing cert: " + e.toString(), e);
            }
        }
    }

    private class X509CRLParser implements PemObjectParser {
        private String provider;

        public X509CRLParser(String str) {
            this.provider = str;
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return CertificateFactory.getInstance("X.509", this.provider).generateCRL(new ByteArrayInputStream(pemObject.getContent()));
            } catch (Exception e) {
                throw new PEMException("problem parsing cert: " + e.toString(), e);
            }
        }
    }

    private class PKCS10CertificationRequestParser implements PemObjectParser {
        private PKCS10CertificationRequestParser() {
        }

        /* synthetic */ PKCS10CertificationRequestParser(PEMReader pEMReader, PKCS10CertificationRequestParser pKCS10CertificationRequestParser) {
            this();
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return new PKCS10CertificationRequest(pemObject.getContent());
            } catch (Exception e) {
                throw new PEMException("problem parsing certrequest: " + e.toString(), e);
            }
        }
    }

    private class PKCS7Parser implements PemObjectParser {
        private PKCS7Parser() {
        }

        /* synthetic */ PKCS7Parser(PEMReader pEMReader, PKCS7Parser pKCS7Parser) {
            this();
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return ContentInfo.getInstance(new ASN1InputStream(pemObject.getContent()).readObject());
            } catch (Exception e) {
                throw new PEMException("problem parsing PKCS7 object: " + e.toString(), e);
            }
        }
    }

    private class X509AttributeCertificateParser implements PemObjectParser {
        private X509AttributeCertificateParser() {
        }

        /* synthetic */ X509AttributeCertificateParser(PEMReader pEMReader, X509AttributeCertificateParser x509AttributeCertificateParser) {
            this();
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            return new X509V2AttributeCertificate(pemObject.getContent());
        }
    }

    private class ECNamedCurveSpecParser implements PemObjectParser {
        private ECNamedCurveSpecParser() {
        }

        /* synthetic */ ECNamedCurveSpecParser(PEMReader pEMReader, ECNamedCurveSpecParser eCNamedCurveSpecParser) {
            this();
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec(((DERObjectIdentifier) ASN1Object.fromByteArray(pemObject.getContent())).getId());
                if (parameterSpec != null) {
                    return parameterSpec;
                }
                throw new IOException("object ID not found in EC curve table");
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("exception extracting EC named curve: " + e2.toString());
            }
        }
    }

    private class EncryptedPrivateKeyParser implements PemObjectParser {
        private String asymProvider;
        private String symProvider;

        public EncryptedPrivateKeyParser(String str, String str2) {
            this.symProvider = str;
            this.asymProvider = str2;
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                EncryptedPrivateKeyInfo instance = EncryptedPrivateKeyInfo.getInstance(ASN1Object.fromByteArray(pemObject.getContent()));
                AlgorithmIdentifier encryptionAlgorithm = instance.getEncryptionAlgorithm();
                if (PEMReader.this.pFinder == null) {
                    throw new PEMException("no PasswordFinder specified");
                } else if (PEMUtilities.isPKCS5Scheme2(encryptionAlgorithm.getAlgorithm())) {
                    PBES2Parameters instance2 = PBES2Parameters.getInstance(encryptionAlgorithm.getParameters());
                    KeyDerivationFunc keyDerivationFunc = instance2.getKeyDerivationFunc();
                    EncryptionScheme encryptionScheme = instance2.getEncryptionScheme();
                    PBKDF2Params pBKDF2Params = (PBKDF2Params) keyDerivationFunc.getParameters();
                    int intValue = pBKDF2Params.getIterationCount().intValue();
                    byte[] salt = pBKDF2Params.getSalt();
                    String id = encryptionScheme.getAlgorithm().getId();
                    SecretKey generateSecretKeyForPKCS5Scheme2 = PEMUtilities.generateSecretKeyForPKCS5Scheme2(id, PEMReader.this.pFinder.getPassword(), salt, intValue);
                    Cipher instance3 = Cipher.getInstance(id, this.symProvider);
                    AlgorithmParameters instance4 = AlgorithmParameters.getInstance(id, this.symProvider);
                    instance4.init(encryptionScheme.getParameters().getDERObject().getEncoded());
                    instance3.init(2, generateSecretKeyForPKCS5Scheme2, instance4);
                    PrivateKeyInfo instance5 = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(instance3.doFinal(instance.getEncryptedData())));
                    return KeyFactory.getInstance(instance5.getAlgorithmId().getAlgorithm().getId(), this.asymProvider).generatePrivate(new PKCS8EncodedKeySpec(instance5.getEncoded()));
                } else if (PEMUtilities.isPKCS12(encryptionAlgorithm.getAlgorithm())) {
                    PKCS12PBEParams instance6 = PKCS12PBEParams.getInstance(encryptionAlgorithm.getParameters());
                    String id2 = encryptionAlgorithm.getAlgorithm().getId();
                    PBEKeySpec pBEKeySpec = new PBEKeySpec(PEMReader.this.pFinder.getPassword());
                    SecretKeyFactory instance7 = SecretKeyFactory.getInstance(id2, this.symProvider);
                    PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(instance6.getIV(), instance6.getIterations().intValue());
                    Cipher instance8 = Cipher.getInstance(id2, this.symProvider);
                    instance8.init(2, instance7.generateSecret(pBEKeySpec), pBEParameterSpec);
                    PrivateKeyInfo instance9 = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(instance8.doFinal(instance.getEncryptedData())));
                    return KeyFactory.getInstance(instance9.getAlgorithmId().getAlgorithm().getId(), this.asymProvider).generatePrivate(new PKCS8EncodedKeySpec(instance9.getEncoded()));
                } else if (PEMUtilities.isPKCS5Scheme1(encryptionAlgorithm.getAlgorithm())) {
                    PBEParameter instance10 = PBEParameter.getInstance(encryptionAlgorithm.getParameters());
                    String id3 = encryptionAlgorithm.getAlgorithm().getId();
                    PBEKeySpec pBEKeySpec2 = new PBEKeySpec(PEMReader.this.pFinder.getPassword());
                    SecretKeyFactory instance11 = SecretKeyFactory.getInstance(id3, this.symProvider);
                    PBEParameterSpec pBEParameterSpec2 = new PBEParameterSpec(instance10.getSalt(), instance10.getIterationCount().intValue());
                    Cipher instance12 = Cipher.getInstance(id3, this.symProvider);
                    instance12.init(2, instance11.generateSecret(pBEKeySpec2), pBEParameterSpec2);
                    PrivateKeyInfo instance13 = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(instance12.doFinal(instance.getEncryptedData())));
                    return KeyFactory.getInstance(instance13.getAlgorithmId().getAlgorithm().getId(), this.asymProvider).generatePrivate(new PKCS8EncodedKeySpec(instance13.getEncoded()));
                } else {
                    throw new PEMException("Unknown algorithm: " + encryptionAlgorithm.getAlgorithm());
                }
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("problem parsing ENCRYPTED PRIVATE KEY: " + e2.toString(), e2);
            }
        }
    }

    private class PrivateKeyParser implements PemObjectParser {
        private String provider;

        public PrivateKeyParser(String str) {
            this.provider = str;
        }

        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                PrivateKeyInfo instance = PrivateKeyInfo.getInstance(ASN1Object.fromByteArray(pemObject.getContent()));
                return KeyFactory.getInstance(instance.getAlgorithmId().getAlgorithm().getId(), this.provider).generatePrivate(new PKCS8EncodedKeySpec(pemObject.getContent()));
            } catch (Exception e) {
                throw new PEMException("problem parsing PRIVATE KEY: " + e.toString(), e);
            }
        }
    }
}
