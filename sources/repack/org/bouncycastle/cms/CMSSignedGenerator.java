package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import repack.org.bouncycastle.asn1.cms.SignerIdentifier;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.AttributeCertificate;
import repack.org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import repack.org.bouncycastle.util.Selector;
import repack.org.bouncycastle.util.Store;
import repack.org.bouncycastle.x509.X509AttributeCertificate;
import repack.org.bouncycastle.x509.X509Store;

public class CMSSignedGenerator {
    public static final String DATA = CMSObjectIdentifiers.data.getId();
    public static final String DIGEST_GOST3411 = CryptoProObjectIdentifiers.gostR3411.getId();
    public static final String DIGEST_MD5 = PKCSObjectIdentifiers.md5.getId();
    public static final String DIGEST_RIPEMD128 = TeleTrusTObjectIdentifiers.ripemd128.getId();
    public static final String DIGEST_RIPEMD160 = TeleTrusTObjectIdentifiers.ripemd160.getId();
    public static final String DIGEST_RIPEMD256 = TeleTrusTObjectIdentifiers.ripemd256.getId();
    public static final String DIGEST_SHA1 = OIWObjectIdentifiers.idSHA1.getId();
    public static final String DIGEST_SHA224 = NISTObjectIdentifiers.id_sha224.getId();
    public static final String DIGEST_SHA256 = NISTObjectIdentifiers.id_sha256.getId();
    public static final String DIGEST_SHA384 = NISTObjectIdentifiers.id_sha384.getId();
    public static final String DIGEST_SHA512 = NISTObjectIdentifiers.id_sha512.getId();
    private static final Map EC_ALGORITHMS = new HashMap();
    public static final String ENCRYPTION_DSA = X9ObjectIdentifiers.id_dsa_with_sha1.getId();
    public static final String ENCRYPTION_ECDSA = X9ObjectIdentifiers.ecdsa_with_SHA1.getId();
    private static final String ENCRYPTION_ECDSA_WITH_SHA1 = X9ObjectIdentifiers.ecdsa_with_SHA1.getId();
    private static final String ENCRYPTION_ECDSA_WITH_SHA224 = X9ObjectIdentifiers.ecdsa_with_SHA224.getId();
    private static final String ENCRYPTION_ECDSA_WITH_SHA256 = X9ObjectIdentifiers.ecdsa_with_SHA256.getId();
    private static final String ENCRYPTION_ECDSA_WITH_SHA384 = X9ObjectIdentifiers.ecdsa_with_SHA384.getId();
    private static final String ENCRYPTION_ECDSA_WITH_SHA512 = X9ObjectIdentifiers.ecdsa_with_SHA512.getId();
    public static final String ENCRYPTION_ECGOST3410 = CryptoProObjectIdentifiers.gostR3410_2001.getId();
    public static final String ENCRYPTION_GOST3410 = CryptoProObjectIdentifiers.gostR3410_94.getId();
    public static final String ENCRYPTION_RSA = PKCSObjectIdentifiers.rsaEncryption.getId();
    public static final String ENCRYPTION_RSA_PSS = PKCSObjectIdentifiers.id_RSASSA_PSS.getId();
    private static final Set NO_PARAMS = new HashSet();
    protected List _signers;
    protected List certs;
    protected List crls;
    protected Map digests;
    protected final SecureRandom rand;
    protected List signerGens;

    static {
        NO_PARAMS.add(ENCRYPTION_DSA);
        NO_PARAMS.add(ENCRYPTION_ECDSA);
        NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA1);
        NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA224);
        NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA256);
        NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA384);
        NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA512);
        EC_ALGORITHMS.put(DIGEST_SHA1, ENCRYPTION_ECDSA_WITH_SHA1);
        EC_ALGORITHMS.put(DIGEST_SHA224, ENCRYPTION_ECDSA_WITH_SHA224);
        EC_ALGORITHMS.put(DIGEST_SHA256, ENCRYPTION_ECDSA_WITH_SHA256);
        EC_ALGORITHMS.put(DIGEST_SHA384, ENCRYPTION_ECDSA_WITH_SHA384);
        EC_ALGORITHMS.put(DIGEST_SHA512, ENCRYPTION_ECDSA_WITH_SHA512);
    }

    protected CMSSignedGenerator() {
        this(new SecureRandom());
    }

    protected CMSSignedGenerator(SecureRandom secureRandom) {
        this.certs = new ArrayList();
        this.crls = new ArrayList();
        this._signers = new ArrayList();
        this.signerGens = new ArrayList();
        this.digests = new HashMap();
        this.rand = secureRandom;
    }

    /* access modifiers changed from: protected */
    public String getEncOID(PrivateKey privateKey, String str) {
        if ((privateKey instanceof RSAPrivateKey) || "RSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
            return ENCRYPTION_RSA;
        }
        if ((privateKey instanceof DSAPrivateKey) || "DSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
            String str2 = ENCRYPTION_DSA;
            if (str.equals(DIGEST_SHA1)) {
                return str2;
            }
            throw new IllegalArgumentException("can't mix DSA with anything but SHA1");
        } else if ("ECDSA".equalsIgnoreCase(privateKey.getAlgorithm()) || "EC".equalsIgnoreCase(privateKey.getAlgorithm())) {
            String str3 = (String) EC_ALGORITHMS.get(str);
            if (str3 != null) {
                return str3;
            }
            throw new IllegalArgumentException("can't mix ECDSA with anything but SHA family digests");
        } else if ((privateKey instanceof GOST3410PrivateKey) || "GOST3410".equalsIgnoreCase(privateKey.getAlgorithm())) {
            return ENCRYPTION_GOST3410;
        } else {
            if ("ECGOST3410".equalsIgnoreCase(privateKey.getAlgorithm())) {
                return ENCRYPTION_ECGOST3410;
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public AlgorithmIdentifier getEncAlgorithmIdentifier(String str, Signature signature) throws IOException {
        if (NO_PARAMS.contains(str)) {
            return new AlgorithmIdentifier(new DERObjectIdentifier(str));
        }
        if (!str.equals(ENCRYPTION_RSA_PSS)) {
            return new AlgorithmIdentifier(new DERObjectIdentifier(str), new DERNull());
        }
        return new AlgorithmIdentifier(new DERObjectIdentifier(str), ASN1Object.fromByteArray(signature.getParameters().getEncoded()));
    }

    /* access modifiers changed from: protected */
    public Map getBaseParameters(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(CMSAttributeTableGenerator.CONTENT_TYPE, dERObjectIdentifier);
        hashMap.put(CMSAttributeTableGenerator.DIGEST_ALGORITHM_IDENTIFIER, algorithmIdentifier);
        hashMap.put(CMSAttributeTableGenerator.DIGEST, bArr.clone());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public ASN1Set getAttributeSet(AttributeTable attributeTable) {
        if (attributeTable != null) {
            return new DERSet(attributeTable.toASN1EncodableVector());
        }
        return null;
    }

    public void addCertificatesAndCRLs(CertStore certStore) throws CertStoreException, CMSException {
        this.certs.addAll(CMSUtils.getCertificatesFromStore(certStore));
        this.crls.addAll(CMSUtils.getCRLsFromStore(certStore));
    }

    public void addCertificates(Store store) throws CMSException {
        this.certs.addAll(CMSUtils.getCertificatesFromStore(store));
    }

    public void addCRLs(Store store) throws CMSException {
        this.crls.addAll(CMSUtils.getCRLsFromStore(store));
    }

    public void addAttributeCertificates(Store store) throws CMSException {
        this.certs.addAll(CMSUtils.getAttributeCertificatesFromStore(store));
    }

    public void addAttributeCertificates(X509Store x509Store) throws CMSException {
        try {
            for (X509AttributeCertificate encoded : x509Store.getMatches((Selector) null)) {
                this.certs.add(new DERTaggedObject(false, 2, AttributeCertificate.getInstance(ASN1Object.fromByteArray(encoded.getEncoded()))));
            }
        } catch (IllegalArgumentException e) {
            throw new CMSException("error processing attribute certs", e);
        } catch (IOException e2) {
            throw new CMSException("error processing attribute certs", e2);
        }
    }

    public void addSigners(SignerInformationStore signerInformationStore) {
        for (Object add : signerInformationStore.getSigners()) {
            this._signers.add(add);
        }
    }

    public void addSignerInfoGenerator(SignerInfoGenerator signerInfoGenerator) {
        this.signerGens.add(signerInfoGenerator);
    }

    public Map getGeneratedDigests() {
        return new HashMap(this.digests);
    }

    static SignerIdentifier getSignerIdentifier(X509Certificate x509Certificate) {
        return new SignerIdentifier(CMSUtils.getIssuerAndSerialNumber(x509Certificate));
    }

    static SignerIdentifier getSignerIdentifier(byte[] bArr) {
        return new SignerIdentifier((ASN1OctetString) new DEROctetString(bArr));
    }
}
