package repack.org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.BERConstructedOctetString;
import repack.org.bouncycastle.asn1.BEROutputStream;
import repack.org.bouncycastle.asn1.DERBMPString;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.pkcs.AuthenticatedSafe;
import repack.org.bouncycastle.asn1.pkcs.CertBag;
import repack.org.bouncycastle.asn1.pkcs.ContentInfo;
import repack.org.bouncycastle.asn1.pkcs.EncryptedData;
import repack.org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import repack.org.bouncycastle.asn1.pkcs.MacData;
import repack.org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.Pfx;
import repack.org.bouncycastle.asn1.pkcs.SafeBag;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.DigestInfo;
import repack.org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import repack.org.bouncycastle.jce.interfaces.BCKeyStore;
import repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import repack.org.bouncycastle.util.Arrays;
import repack.org.bouncycastle.util.Strings;

public class JDKPKCS12KeyStore extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    static final int CERTIFICATE = 1;
    static final int KEY = 2;
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 1024;
    static final int NULL = 0;
    private static final int SALT_SIZE = 20;
    static final int SEALED = 4;
    static final int SECRET = 3;
    /* access modifiers changed from: private */
    public static final Provider bcProvider = new BouncyCastleProvider();
    private DERObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;
    private IgnoresCaseHashtable certs = new IgnoresCaseHashtable((IgnoresCaseHashtable) null);
    private Hashtable chainCerts = new Hashtable();
    private DERObjectIdentifier keyAlgorithm;
    private Hashtable keyCerts = new Hashtable();
    private IgnoresCaseHashtable keys = new IgnoresCaseHashtable((IgnoresCaseHashtable) null);
    private Hashtable localIds = new Hashtable();
    protected SecureRandom random = new SecureRandom();

    private class CertId {

        /* renamed from: id */
        byte[] f6241id;

        CertId(PublicKey publicKey) {
            this.f6241id = JDKPKCS12KeyStore.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        CertId(byte[] bArr) {
            this.f6241id = bArr;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f6241id);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CertId)) {
                return false;
            }
            return Arrays.areEqual(this.f6241id, ((CertId) obj).f6241id);
        }
    }

    public JDKPKCS12KeyStore(Provider provider, DERObjectIdentifier dERObjectIdentifier, DERObjectIdentifier dERObjectIdentifier2) {
        this.keyAlgorithm = dERObjectIdentifier;
        this.certAlgorithm = dERObjectIdentifier2;
        if (provider != null) {
            try {
                this.certFact = CertificateFactory.getInstance("X.509", provider);
            } catch (Exception e) {
                throw new IllegalArgumentException("can't create cert factory - " + e.toString());
            }
        } else {
            this.certFact = CertificateFactory.getInstance("X.509");
        }
    }

    /* access modifiers changed from: private */
    public SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            return new SubjectKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) ASN1Object.fromByteArray(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys2 = this.certs.keys();
        while (keys2.hasMoreElements()) {
            hashtable.put(keys2.nextElement(), "cert");
        }
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            String str = (String) keys3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    public boolean engineContainsAlias(String str) {
        return (this.certs.get(str) == null && this.keys.get(str) == null) ? false : true;
    }

    public void engineDeleteEntry(String str) throws KeyStoreException {
        Key key = (Key) this.keys.remove(str);
        Certificate certificate = (Certificate) this.certs.remove(str);
        if (certificate != null) {
            this.chainCerts.remove(new CertId(certificate.getPublicKey()));
        }
        if (key != null) {
            String str2 = (String) this.localIds.remove(str);
            if (str2 != null) {
                certificate = (Certificate) this.keyCerts.remove(str2);
            }
            if (certificate != null) {
                this.chainCerts.remove(new CertId(certificate.getPublicKey()));
            }
        }
        if (certificate == null && key == null) {
            throw new KeyStoreException("no such entry as " + str);
        }
    }

    public Certificate engineGetCertificate(String str) {
        if (str != null) {
            Certificate certificate = (Certificate) this.certs.get(str);
            if (certificate != null) {
                return certificate;
            }
            String str2 = (String) this.localIds.get(str);
            if (str2 != null) {
                return (Certificate) this.keyCerts.get(str2);
            }
            return (Certificate) this.keyCerts.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getCertificate.");
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.certs.elements();
        Enumeration keys2 = this.certs.keys();
        while (elements.hasMoreElements()) {
            String str = (String) keys2.nextElement();
            if (((Certificate) elements.nextElement()).equals(certificate)) {
                return str;
            }
        }
        Enumeration elements2 = this.keyCerts.elements();
        Enumeration keys3 = this.keyCerts.keys();
        while (elements2.hasMoreElements()) {
            String str2 = (String) keys3.nextElement();
            if (((Certificate) elements2.nextElement()).equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x00c9
            boolean r0 = r8.engineIsKeyEntry(r9)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.security.cert.Certificate r9 = r8.engineGetCertificate(r9)
            if (r9 == 0) goto L_0x00c8
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
        L_0x0015:
            if (r9 != 0) goto L_0x002d
            int r9 = r0.size()
            java.security.cert.Certificate[] r2 = new java.security.cert.Certificate[r9]
            r9 = 0
        L_0x001e:
            int r1 = r2.length
            if (r9 != r1) goto L_0x0022
            return r2
        L_0x0022:
            java.lang.Object r1 = r0.elementAt(r9)
            java.security.cert.Certificate r1 = (java.security.cert.Certificate) r1
            r2[r9] = r1
            int r9 = r9 + 1
            goto L_0x001e
        L_0x002d:
            r2 = r9
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r3 = repack.org.bouncycastle.asn1.x509.X509Extensions.AuthorityKeyIdentifier
            java.lang.String r3 = r3.getId()
            byte[] r3 = r2.getExtensionValue(r3)
            if (r3 == 0) goto L_0x007e
            repack.org.bouncycastle.asn1.ASN1InputStream r4 = new repack.org.bouncycastle.asn1.ASN1InputStream     // Catch:{ IOException -> 0x0073 }
            r4.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0073 }
            repack.org.bouncycastle.asn1.DERObject r3 = r4.readObject()     // Catch:{ IOException -> 0x0073 }
            repack.org.bouncycastle.asn1.ASN1OctetString r3 = (repack.org.bouncycastle.asn1.ASN1OctetString) r3     // Catch:{ IOException -> 0x0073 }
            byte[] r3 = r3.getOctets()     // Catch:{ IOException -> 0x0073 }
            repack.org.bouncycastle.asn1.ASN1InputStream r4 = new repack.org.bouncycastle.asn1.ASN1InputStream     // Catch:{ IOException -> 0x0073 }
            r4.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0073 }
            repack.org.bouncycastle.asn1.x509.AuthorityKeyIdentifier r3 = new repack.org.bouncycastle.asn1.x509.AuthorityKeyIdentifier     // Catch:{ IOException -> 0x0073 }
            repack.org.bouncycastle.asn1.DERObject r4 = r4.readObject()     // Catch:{ IOException -> 0x0073 }
            repack.org.bouncycastle.asn1.ASN1Sequence r4 = (repack.org.bouncycastle.asn1.ASN1Sequence) r4     // Catch:{ IOException -> 0x0073 }
            r3.<init>((repack.org.bouncycastle.asn1.ASN1Sequence) r4)     // Catch:{ IOException -> 0x0073 }
            byte[] r4 = r3.getKeyIdentifier()     // Catch:{ IOException -> 0x0073 }
            if (r4 == 0) goto L_0x007e
            java.util.Hashtable r4 = r8.chainCerts     // Catch:{ IOException -> 0x0073 }
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$CertId r5 = new repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$CertId     // Catch:{ IOException -> 0x0073 }
            byte[] r3 = r3.getKeyIdentifier()     // Catch:{ IOException -> 0x0073 }
            r5.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0073 }
            java.lang.Object r3 = r4.get(r5)     // Catch:{ IOException -> 0x0073 }
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3     // Catch:{ IOException -> 0x0073 }
            goto L_0x007f
        L_0x0073:
            r9 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x007e:
            r3 = r1
        L_0x007f:
            if (r3 != 0) goto L_0x00bd
            java.security.Principal r4 = r2.getIssuerDN()
            java.security.Principal r5 = r2.getSubjectDN()
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00bd
            java.util.Hashtable r5 = r8.chainCerts
            java.util.Enumeration r5 = r5.keys()
        L_0x0095:
            boolean r6 = r5.hasMoreElements()
            if (r6 != 0) goto L_0x009c
            goto L_0x00bd
        L_0x009c:
            java.util.Hashtable r6 = r8.chainCerts
            java.lang.Object r7 = r5.nextElement()
            java.lang.Object r6 = r6.get(r7)
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6
            java.security.Principal r7 = r6.getSubjectDN()
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0095
            java.security.PublicKey r7 = r6.getPublicKey()     // Catch:{ Exception -> 0x00bb }
            r2.verify(r7)     // Catch:{ Exception -> 0x00bb }
            r3 = r6
            goto L_0x00bd
        L_0x00bb:
            goto L_0x0095
        L_0x00bd:
            r0.addElement(r9)
            if (r3 == r9) goto L_0x00c5
            r9 = r3
            goto L_0x0015
        L_0x00c5:
            r9 = r1
            goto L_0x0015
        L_0x00c8:
            return r1
        L_0x00c9:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "null alias passed to getCertificateChain."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore.engineGetCertificateChain(java.lang.String):java.security.cert.Certificate[]");
    }

    public Date engineGetCreationDate(String str) {
        return new Date();
    }

    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (str != null) {
            return (Key) this.keys.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    public boolean engineIsCertificateEntry(String str) {
        return this.certs.get(str) != null && this.keys.get(str) == null;
    }

    public boolean engineIsKeyEntry(String str) {
        return this.keys.get(str) != null;
    }

    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.keys.get(str) == null) {
            this.certs.put(str, certificate);
            this.chainCerts.put(new CertId(certificate.getPublicKey()), certificate);
            return;
        }
        throw new KeyStoreException("There is a key entry with the name " + str + ".");
    }

    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        if (!(key instanceof PrivateKey) || certificateArr != null) {
            if (this.keys.get(str) != null) {
                engineDeleteEntry(str);
            }
            this.keys.put(str, key);
            this.certs.put(str, certificateArr[0]);
            for (int i = 0; i != certificateArr.length; i++) {
                this.chainCerts.put(new CertId(certificateArr[i].getPublicKey()), certificateArr[i]);
            }
            return;
        }
        throw new KeyStoreException("no certificate chain for private key");
    }

    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys2 = this.certs.keys();
        while (keys2.hasMoreElements()) {
            hashtable.put(keys2.nextElement(), "cert");
        }
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            String str = (String) keys3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    /* access modifiers changed from: protected */
    public PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) throws IOException {
        String id = algorithmIdentifier.getObjectId().getId();
        PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams((ASN1Sequence) algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory instance = SecretKeyFactory.getInstance(id, bcProvider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            SecretKey generateSecret = instance.generateSecret(pBEKeySpec);
            ((JCEPBEKey) generateSecret).setTryWrongPKCS12Zero(z);
            Cipher instance2 = Cipher.getInstance(id, bcProvider);
            instance2.init(4, generateSecret, pBEParameterSpec);
            return (PrivateKey) instance2.unwrap(bArr, "", 2);
        } catch (Exception e) {
            throw new IOException("exception unwrapping private key - " + e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) throws IOException {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory instance = SecretKeyFactory.getInstance(str, bcProvider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher instance2 = Cipher.getInstance(str, bcProvider);
            instance2.init(3, instance.generateSecret(pBEKeySpec), pBEParameterSpec);
            return instance2.wrap(key);
        } catch (Exception e) {
            throw new IOException("exception encrypting data - " + e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) throws IOException {
        String id = algorithmIdentifier.getObjectId().getId();
        PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams((ASN1Sequence) algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory instance = SecretKeyFactory.getInstance(id, bcProvider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            JCEPBEKey jCEPBEKey = (JCEPBEKey) instance.generateSecret(pBEKeySpec);
            jCEPBEKey.setTryWrongPKCS12Zero(z2);
            Cipher instance2 = Cipher.getInstance(id, bcProvider);
            instance2.init(z ? 1 : 2, jCEPBEKey, pBEParameterSpec);
            return instance2.doFinal(bArr);
        } catch (Exception e) {
            throw new IOException("exception decrypting data - " + e.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: repack.org.bouncycastle.asn1.DERObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: repack.org.bouncycastle.asn1.DERObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v9, resolved type: repack.org.bouncycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v10, resolved type: repack.org.bouncycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v26, resolved type: repack.org.bouncycastle.asn1.DERObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v11, resolved type: repack.org.bouncycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v33, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v12, resolved type: repack.org.bouncycastle.asn1.ASN1OctetString} */
    /* JADX WARNING: type inference failed for: r5v11, types: [repack.org.bouncycastle.asn1.DERObject, repack.org.bouncycastle.asn1.DEREncodable, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e1  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineLoad(java.io.InputStream r21, char[] r22) throws java.io.IOException {
        /*
            r20 = this;
            r7 = r20
            r0 = r21
            r8 = r22
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            if (r8 == 0) goto L_0x05c9
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            r1.<init>(r0)
            r0 = 10
            r1.mark(r0)
            int r0 = r1.read()
            r2 = 48
            if (r0 != r2) goto L_0x05c1
            r1.reset()
            repack.org.bouncycastle.asn1.ASN1InputStream r0 = new repack.org.bouncycastle.asn1.ASN1InputStream
            r0.<init>((java.io.InputStream) r1)
            repack.org.bouncycastle.asn1.DERObject r0 = r0.readObject()
            repack.org.bouncycastle.asn1.ASN1Sequence r0 = (repack.org.bouncycastle.asn1.ASN1Sequence) r0
            repack.org.bouncycastle.asn1.pkcs.Pfx r1 = new repack.org.bouncycastle.asn1.pkcs.Pfx
            r1.<init>(r0)
            repack.org.bouncycastle.asn1.pkcs.ContentInfo r6 = r1.getAuthSafe()
            java.util.Vector r9 = new java.util.Vector
            r9.<init>()
            repack.org.bouncycastle.asn1.pkcs.MacData r0 = r1.getMacData()
            r10 = 1
            r11 = 0
            if (r0 == 0) goto L_0x00c1
            repack.org.bouncycastle.asn1.pkcs.MacData r0 = r1.getMacData()
            repack.org.bouncycastle.asn1.x509.DigestInfo r12 = r0.getMac()
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r13 = r12.getAlgorithmId()
            byte[] r14 = r0.getSalt()
            java.math.BigInteger r0 = r0.getIterationCount()
            int r15 = r0.intValue()
            repack.org.bouncycastle.asn1.DEREncodable r0 = r6.getContent()
            repack.org.bouncycastle.asn1.ASN1OctetString r0 = (repack.org.bouncycastle.asn1.ASN1OctetString) r0
            byte[] r16 = r0.getOctets()
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = r13.getObjectId()     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            r4 = 0
            r1 = r14
            r2 = r15
            r3 = r22
            r5 = r16
            byte[] r0 = calculatePbeMac(r0, r1, r2, r3, r4, r5)     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            byte[] r12 = r12.getDigest()     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            boolean r0 = repack.org.bouncycastle.util.Arrays.constantTimeAreEqual(r0, r12)     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            if (r0 != 0) goto L_0x00c1
            int r0 = r8.length     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            java.lang.String r5 = "PKCS12 key store mac invalid - wrong password or corrupted file."
            if (r0 > 0) goto L_0x009f
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = r13.getObjectId()     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            r4 = 1
            r1 = r14
            r2 = r15
            r3 = r22
            r13 = r5
            r5 = r16
            byte[] r0 = calculatePbeMac(r0, r1, r2, r3, r4, r5)     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            boolean r0 = repack.org.bouncycastle.util.Arrays.constantTimeAreEqual(r0, r12)     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            if (r0 == 0) goto L_0x0099
            r0 = 1
            goto L_0x00c2
        L_0x0099:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            r0.<init>(r13)     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            throw r0     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
        L_0x009f:
            r13 = r5
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            r0.<init>(r13)     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
            throw r0     // Catch:{ IOException -> 0x00bf, Exception -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "error constructing MAC: "
            r2.<init>(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00bf:
            r0 = move-exception
            throw r0
        L_0x00c1:
            r0 = 0
        L_0x00c2:
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r1 = new repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable
            r12 = 0
            r1.<init>(r12)
            r7.keys = r1
            java.util.Hashtable r1 = new java.util.Hashtable
            r1.<init>()
            r7.localIds = r1
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r6.getContentType()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = data
            boolean r1 = r1.equals(r2)
            java.lang.String r13 = "unmarked"
            java.lang.String r14 = "attempt to add existing attribute with different value"
            if (r1 == 0) goto L_0x047e
            repack.org.bouncycastle.asn1.ASN1InputStream r1 = new repack.org.bouncycastle.asn1.ASN1InputStream
            repack.org.bouncycastle.asn1.DEREncodable r2 = r6.getContent()
            repack.org.bouncycastle.asn1.ASN1OctetString r2 = (repack.org.bouncycastle.asn1.ASN1OctetString) r2
            byte[] r2 = r2.getOctets()
            r1.<init>((byte[]) r2)
            repack.org.bouncycastle.asn1.pkcs.AuthenticatedSafe r2 = new repack.org.bouncycastle.asn1.pkcs.AuthenticatedSafe
            repack.org.bouncycastle.asn1.DERObject r1 = r1.readObject()
            repack.org.bouncycastle.asn1.ASN1Sequence r1 = (repack.org.bouncycastle.asn1.ASN1Sequence) r1
            r2.<init>((repack.org.bouncycastle.asn1.ASN1Sequence) r1)
            repack.org.bouncycastle.asn1.pkcs.ContentInfo[] r15 = r2.getContentInfo()
            r6 = 0
            r16 = 0
        L_0x0102:
            int r1 = r15.length
            if (r6 != r1) goto L_0x0107
            goto L_0x0480
        L_0x0107:
            r1 = r15[r6]
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r1.getContentType()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = data
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0248
            repack.org.bouncycastle.asn1.ASN1InputStream r1 = new repack.org.bouncycastle.asn1.ASN1InputStream
            r2 = r15[r6]
            repack.org.bouncycastle.asn1.DEREncodable r2 = r2.getContent()
            repack.org.bouncycastle.asn1.ASN1OctetString r2 = (repack.org.bouncycastle.asn1.ASN1OctetString) r2
            byte[] r2 = r2.getOctets()
            r1.<init>((byte[]) r2)
            repack.org.bouncycastle.asn1.DERObject r1 = r1.readObject()
            repack.org.bouncycastle.asn1.ASN1Sequence r1 = (repack.org.bouncycastle.asn1.ASN1Sequence) r1
            r2 = 0
        L_0x012d:
            int r3 = r1.size()
            if (r2 != r3) goto L_0x0138
            r17 = r0
            r11 = r6
            goto L_0x0475
        L_0x0138:
            repack.org.bouncycastle.asn1.pkcs.SafeBag r3 = new repack.org.bouncycastle.asn1.pkcs.SafeBag
            repack.org.bouncycastle.asn1.DEREncodable r4 = r1.getObjectAt(r2)
            repack.org.bouncycastle.asn1.ASN1Sequence r4 = (repack.org.bouncycastle.asn1.ASN1Sequence) r4
            r3.<init>(r4)
            repack.org.bouncycastle.asn1.DERObjectIdentifier r4 = r3.getBagId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = pkcs8ShroudedKeyBag
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0211
            repack.org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo r4 = new repack.org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo
            repack.org.bouncycastle.asn1.DERObject r5 = r3.getBagValue()
            repack.org.bouncycastle.asn1.ASN1Sequence r5 = (repack.org.bouncycastle.asn1.ASN1Sequence) r5
            r4.<init>(r5)
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r5 = r4.getEncryptionAlgorithm()
            byte[] r4 = r4.getEncryptedData()
            java.security.PrivateKey r4 = r7.unwrapKey(r5, r4, r8, r0)
            r5 = r4
            repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r5 = (repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r5
            repack.org.bouncycastle.asn1.ASN1Set r17 = r3.getBagAttributes()
            if (r17 == 0) goto L_0x01e9
            repack.org.bouncycastle.asn1.ASN1Set r3 = r3.getBagAttributes()
            java.util.Enumeration r3 = r3.getObjects()
            r17 = r12
            r18 = r17
        L_0x017b:
            boolean r19 = r3.hasMoreElements()
            if (r19 != 0) goto L_0x0184
            r3 = r17
            goto L_0x01ec
        L_0x0184:
            java.lang.Object r19 = r3.nextElement()
            r12 = r19
            repack.org.bouncycastle.asn1.ASN1Sequence r12 = (repack.org.bouncycastle.asn1.ASN1Sequence) r12
            repack.org.bouncycastle.asn1.DEREncodable r19 = r12.getObjectAt(r11)
            r11 = r19
            repack.org.bouncycastle.asn1.DERObjectIdentifier r11 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r11
            repack.org.bouncycastle.asn1.DEREncodable r12 = r12.getObjectAt(r10)
            repack.org.bouncycastle.asn1.ASN1Set r12 = (repack.org.bouncycastle.asn1.ASN1Set) r12
            int r19 = r12.size()
            if (r19 <= 0) goto L_0x01c2
            r10 = 0
            repack.org.bouncycastle.asn1.DEREncodable r12 = r12.getObjectAt(r10)
            repack.org.bouncycastle.asn1.DERObject r12 = (repack.org.bouncycastle.asn1.DERObject) r12
            repack.org.bouncycastle.asn1.DEREncodable r10 = r5.getBagAttribute(r11)
            if (r10 == 0) goto L_0x01be
            repack.org.bouncycastle.asn1.DERObject r10 = r10.getDERObject()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x01b8
            goto L_0x01c3
        L_0x01b8:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r14)
            throw r0
        L_0x01be:
            r5.setBagAttribute(r11, r12)
            goto L_0x01c3
        L_0x01c2:
            r12 = 0
        L_0x01c3:
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r10 = pkcs_9_at_friendlyName
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x01d9
            repack.org.bouncycastle.asn1.DERBMPString r12 = (repack.org.bouncycastle.asn1.DERBMPString) r12
            java.lang.String r10 = r12.getString()
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r11 = r7.keys
            r11.put(r10, r4)
            r17 = r10
            goto L_0x01e5
        L_0x01d9:
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r10 = pkcs_9_at_localKeyId
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x01e5
            r18 = r12
            repack.org.bouncycastle.asn1.ASN1OctetString r18 = (repack.org.bouncycastle.asn1.ASN1OctetString) r18
        L_0x01e5:
            r10 = 1
            r11 = 0
            r12 = 0
            goto L_0x017b
        L_0x01e9:
            r3 = 0
            r18 = 0
        L_0x01ec:
            if (r18 == 0) goto L_0x0209
            java.lang.String r5 = new java.lang.String
            byte[] r10 = r18.getOctets()
            byte[] r10 = repack.org.bouncycastle.util.encoders.Hex.encode(r10)
            r5.<init>(r10)
            if (r3 != 0) goto L_0x0203
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r3 = r7.keys
            r3.put(r5, r4)
            goto L_0x0241
        L_0x0203:
            java.util.Hashtable r4 = r7.localIds
            r4.put(r3, r5)
            goto L_0x0241
        L_0x0209:
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r3 = r7.keys
            r3.put(r13, r4)
            r16 = 1
            goto L_0x0241
        L_0x0211:
            repack.org.bouncycastle.asn1.DERObjectIdentifier r4 = r3.getBagId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = certBag
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0221
            r9.addElement(r3)
            goto L_0x0241
        L_0x0221:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r10 = "extra in data "
            r5.<init>(r10)
            repack.org.bouncycastle.asn1.DERObjectIdentifier r10 = r3.getBagId()
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            r4.println(r5)
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.String r3 = repack.org.bouncycastle.asn1.util.ASN1Dump.dumpAsString(r3)
            r4.println(r3)
        L_0x0241:
            int r2 = r2 + 1
            r10 = 1
            r11 = 0
            r12 = 0
            goto L_0x012d
        L_0x0248:
            r1 = r15[r6]
            repack.org.bouncycastle.asn1.DERObjectIdentifier r1 = r1.getContentType()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = encryptedData
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x043a
            repack.org.bouncycastle.asn1.pkcs.EncryptedData r1 = new repack.org.bouncycastle.asn1.pkcs.EncryptedData
            r2 = r15[r6]
            repack.org.bouncycastle.asn1.DEREncodable r2 = r2.getContent()
            repack.org.bouncycastle.asn1.ASN1Sequence r2 = (repack.org.bouncycastle.asn1.ASN1Sequence) r2
            r1.<init>(r2)
            r2 = 0
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r3 = r1.getEncryptionAlgorithm()
            repack.org.bouncycastle.asn1.ASN1OctetString r1 = r1.getContent()
            byte[] r10 = r1.getOctets()
            r1 = r20
            r4 = r22
            r5 = r0
            r11 = r6
            r6 = r10
            byte[] r1 = r1.cryptData(r2, r3, r4, r5, r6)
            repack.org.bouncycastle.asn1.ASN1Object r1 = repack.org.bouncycastle.asn1.ASN1Object.fromByteArray(r1)
            repack.org.bouncycastle.asn1.ASN1Sequence r1 = (repack.org.bouncycastle.asn1.ASN1Sequence) r1
            r2 = 0
        L_0x0282:
            int r3 = r1.size()
            if (r2 != r3) goto L_0x028c
            r17 = r0
            goto L_0x0475
        L_0x028c:
            repack.org.bouncycastle.asn1.pkcs.SafeBag r3 = new repack.org.bouncycastle.asn1.pkcs.SafeBag
            repack.org.bouncycastle.asn1.DEREncodable r4 = r1.getObjectAt(r2)
            repack.org.bouncycastle.asn1.ASN1Sequence r4 = (repack.org.bouncycastle.asn1.ASN1Sequence) r4
            r3.<init>(r4)
            repack.org.bouncycastle.asn1.DERObjectIdentifier r4 = r3.getBagId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = certBag
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x02ac
            r9.addElement(r3)
        L_0x02a6:
            r17 = r0
            r18 = r1
            goto L_0x0432
        L_0x02ac:
            repack.org.bouncycastle.asn1.DERObjectIdentifier r4 = r3.getBagId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = pkcs8ShroudedKeyBag
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0366
            repack.org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo r4 = new repack.org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo
            repack.org.bouncycastle.asn1.DERObject r5 = r3.getBagValue()
            repack.org.bouncycastle.asn1.ASN1Sequence r5 = (repack.org.bouncycastle.asn1.ASN1Sequence) r5
            r4.<init>(r5)
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r5 = r4.getEncryptionAlgorithm()
            byte[] r4 = r4.getEncryptedData()
            java.security.PrivateKey r4 = r7.unwrapKey(r5, r4, r8, r0)
            r5 = r4
            repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r5 = (repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r5
            repack.org.bouncycastle.asn1.ASN1Set r3 = r3.getBagAttributes()
            java.util.Enumeration r6 = r3.getObjects()
            r3 = 0
            r12 = 0
        L_0x02dc:
            boolean r10 = r6.hasMoreElements()
            if (r10 != 0) goto L_0x02fd
            java.lang.String r5 = new java.lang.String
            byte[] r6 = r12.getOctets()
            byte[] r6 = repack.org.bouncycastle.util.encoders.Hex.encode(r6)
            r5.<init>(r6)
            if (r3 != 0) goto L_0x02f7
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r3 = r7.keys
            r3.put(r5, r4)
            goto L_0x02a6
        L_0x02f7:
            java.util.Hashtable r4 = r7.localIds
            r4.put(r3, r5)
            goto L_0x02a6
        L_0x02fd:
            java.lang.Object r10 = r6.nextElement()
            repack.org.bouncycastle.asn1.ASN1Sequence r10 = (repack.org.bouncycastle.asn1.ASN1Sequence) r10
            r17 = r0
            r0 = 0
            repack.org.bouncycastle.asn1.DEREncodable r18 = r10.getObjectAt(r0)
            r0 = r18
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r0
            r18 = r1
            r1 = 1
            repack.org.bouncycastle.asn1.DEREncodable r10 = r10.getObjectAt(r1)
            repack.org.bouncycastle.asn1.ASN1Set r10 = (repack.org.bouncycastle.asn1.ASN1Set) r10
            int r1 = r10.size()
            if (r1 <= 0) goto L_0x0340
            r1 = 0
            repack.org.bouncycastle.asn1.DEREncodable r10 = r10.getObjectAt(r1)
            r1 = r10
            repack.org.bouncycastle.asn1.DERObject r1 = (repack.org.bouncycastle.asn1.DERObject) r1
            repack.org.bouncycastle.asn1.DEREncodable r10 = r5.getBagAttribute(r0)
            if (r10 == 0) goto L_0x033c
            repack.org.bouncycastle.asn1.DERObject r10 = r10.getDERObject()
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0336
            goto L_0x0341
        L_0x0336:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r14)
            throw r0
        L_0x033c:
            r5.setBagAttribute(r0, r1)
            goto L_0x0341
        L_0x0340:
            r1 = 0
        L_0x0341:
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r10 = pkcs_9_at_friendlyName
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0355
            repack.org.bouncycastle.asn1.DERBMPString r1 = (repack.org.bouncycastle.asn1.DERBMPString) r1
            java.lang.String r3 = r1.getString()
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r0 = r7.keys
            r0.put(r3, r4)
            goto L_0x0360
        L_0x0355:
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r10 = pkcs_9_at_localKeyId
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0360
            r12 = r1
            repack.org.bouncycastle.asn1.ASN1OctetString r12 = (repack.org.bouncycastle.asn1.ASN1OctetString) r12
        L_0x0360:
            r0 = r17
            r1 = r18
            goto L_0x02dc
        L_0x0366:
            r17 = r0
            r18 = r1
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = r3.getBagId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = keyBag
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0412
            repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo r0 = new repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo
            repack.org.bouncycastle.asn1.DERObject r1 = r3.getBagValue()
            repack.org.bouncycastle.asn1.ASN1Sequence r1 = (repack.org.bouncycastle.asn1.ASN1Sequence) r1
            r0.<init>(r1)
            java.security.PrivateKey r0 = repack.org.bouncycastle.jce.provider.JDKKeyFactory.createPrivateKeyFromPrivateKeyInfo(r0)
            r1 = r0
            repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r1 = (repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r1
            repack.org.bouncycastle.asn1.ASN1Set r3 = r3.getBagAttributes()
            java.util.Enumeration r4 = r3.getObjects()
            r3 = 0
            r12 = 0
        L_0x0392:
            boolean r5 = r4.hasMoreElements()
            if (r5 != 0) goto L_0x03b5
            java.lang.String r1 = new java.lang.String
            byte[] r4 = r12.getOctets()
            byte[] r4 = repack.org.bouncycastle.util.encoders.Hex.encode(r4)
            r1.<init>(r4)
            if (r3 != 0) goto L_0x03ae
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r3 = r7.keys
            r3.put(r1, r0)
            goto L_0x0432
        L_0x03ae:
            java.util.Hashtable r0 = r7.localIds
            r0.put(r3, r1)
            goto L_0x0432
        L_0x03b5:
            java.lang.Object r5 = r4.nextElement()
            repack.org.bouncycastle.asn1.ASN1Sequence r5 = (repack.org.bouncycastle.asn1.ASN1Sequence) r5
            r6 = 0
            repack.org.bouncycastle.asn1.DEREncodable r10 = r5.getObjectAt(r6)
            repack.org.bouncycastle.asn1.DERObjectIdentifier r10 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r10
            r6 = 1
            repack.org.bouncycastle.asn1.DEREncodable r5 = r5.getObjectAt(r6)
            repack.org.bouncycastle.asn1.ASN1Set r5 = (repack.org.bouncycastle.asn1.ASN1Set) r5
            int r6 = r5.size()
            if (r6 <= 0) goto L_0x03f1
            r6 = 0
            repack.org.bouncycastle.asn1.DEREncodable r5 = r5.getObjectAt(r6)
            repack.org.bouncycastle.asn1.DERObject r5 = (repack.org.bouncycastle.asn1.DERObject) r5
            repack.org.bouncycastle.asn1.DEREncodable r6 = r1.getBagAttribute(r10)
            if (r6 == 0) goto L_0x03ed
            repack.org.bouncycastle.asn1.DERObject r6 = r6.getDERObject()
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x03e7
            goto L_0x03f2
        L_0x03e7:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r14)
            throw r0
        L_0x03ed:
            r1.setBagAttribute(r10, r5)
            goto L_0x03f2
        L_0x03f1:
            r5 = 0
        L_0x03f2:
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r6 = pkcs_9_at_friendlyName
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x0406
            repack.org.bouncycastle.asn1.DERBMPString r5 = (repack.org.bouncycastle.asn1.DERBMPString) r5
            java.lang.String r3 = r5.getString()
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r5 = r7.keys
            r5.put(r3, r0)
            goto L_0x0392
        L_0x0406:
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r6 = pkcs_9_at_localKeyId
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x0392
            r12 = r5
            repack.org.bouncycastle.asn1.ASN1OctetString r12 = (repack.org.bouncycastle.asn1.ASN1OctetString) r12
            goto L_0x0392
        L_0x0412:
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "extra in encryptedData "
            r1.<init>(r4)
            repack.org.bouncycastle.asn1.DERObjectIdentifier r4 = r3.getBagId()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = repack.org.bouncycastle.asn1.util.ASN1Dump.dumpAsString(r3)
            r0.println(r1)
        L_0x0432:
            int r2 = r2 + 1
            r0 = r17
            r1 = r18
            goto L_0x0282
        L_0x043a:
            r17 = r0
            r11 = r6
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "extra "
            r1.<init>(r2)
            r3 = r15[r11]
            repack.org.bouncycastle.asn1.DERObjectIdentifier r3 = r3.getContentType()
            java.lang.String r3 = r3.getId()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            r2 = r15[r11]
            repack.org.bouncycastle.asn1.DEREncodable r2 = r2.getContent()
            java.lang.String r2 = repack.org.bouncycastle.asn1.util.ASN1Dump.dumpAsString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
        L_0x0475:
            int r6 = r11 + 1
            r0 = r17
            r10 = 1
            r11 = 0
            r12 = 0
            goto L_0x0102
        L_0x047e:
            r16 = 0
        L_0x0480:
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r0 = new repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable
            r1 = 0
            r0.<init>(r1)
            r7.certs = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r7.chainCerts = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r7.keyCerts = r0
            r0 = 0
        L_0x0497:
            int r2 = r9.size()
            if (r0 != r2) goto L_0x049e
            return
        L_0x049e:
            java.lang.Object r2 = r9.elementAt(r0)
            repack.org.bouncycastle.asn1.pkcs.SafeBag r2 = (repack.org.bouncycastle.asn1.pkcs.SafeBag) r2
            repack.org.bouncycastle.asn1.pkcs.CertBag r3 = new repack.org.bouncycastle.asn1.pkcs.CertBag
            repack.org.bouncycastle.asn1.DERObject r4 = r2.getBagValue()
            repack.org.bouncycastle.asn1.ASN1Sequence r4 = (repack.org.bouncycastle.asn1.ASN1Sequence) r4
            r3.<init>(r4)
            repack.org.bouncycastle.asn1.DERObjectIdentifier r4 = r3.getCertId()
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = x509Certificate
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x05a9
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x059e }
            repack.org.bouncycastle.asn1.DERObject r3 = r3.getCertValue()     // Catch:{ Exception -> 0x059e }
            repack.org.bouncycastle.asn1.ASN1OctetString r3 = (repack.org.bouncycastle.asn1.ASN1OctetString) r3     // Catch:{ Exception -> 0x059e }
            byte[] r3 = r3.getOctets()     // Catch:{ Exception -> 0x059e }
            r4.<init>(r3)     // Catch:{ Exception -> 0x059e }
            java.security.cert.CertificateFactory r3 = r7.certFact     // Catch:{ Exception -> 0x059e }
            java.security.cert.Certificate r3 = r3.generateCertificate(r4)     // Catch:{ Exception -> 0x059e }
            repack.org.bouncycastle.asn1.ASN1Set r4 = r2.getBagAttributes()
            if (r4 == 0) goto L_0x053f
            repack.org.bouncycastle.asn1.ASN1Set r2 = r2.getBagAttributes()
            java.util.Enumeration r2 = r2.getObjects()
            r4 = r1
            r12 = r4
        L_0x04e0:
            boolean r5 = r2.hasMoreElements()
            if (r5 != 0) goto L_0x04e9
            r6 = 0
            r10 = 1
            goto L_0x0543
        L_0x04e9:
            java.lang.Object r5 = r2.nextElement()
            repack.org.bouncycastle.asn1.ASN1Sequence r5 = (repack.org.bouncycastle.asn1.ASN1Sequence) r5
            r6 = 0
            repack.org.bouncycastle.asn1.DEREncodable r8 = r5.getObjectAt(r6)
            repack.org.bouncycastle.asn1.DERObjectIdentifier r8 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r8
            r10 = 1
            repack.org.bouncycastle.asn1.DEREncodable r5 = r5.getObjectAt(r10)
            repack.org.bouncycastle.asn1.ASN1Set r5 = (repack.org.bouncycastle.asn1.ASN1Set) r5
            repack.org.bouncycastle.asn1.DEREncodable r5 = r5.getObjectAt(r6)
            repack.org.bouncycastle.asn1.DERObject r5 = (repack.org.bouncycastle.asn1.DERObject) r5
            boolean r11 = r3 instanceof repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
            if (r11 == 0) goto L_0x0524
            r11 = r3
            repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r11 = (repack.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r11
            repack.org.bouncycastle.asn1.DEREncodable r15 = r11.getBagAttribute(r8)
            if (r15 == 0) goto L_0x0521
            repack.org.bouncycastle.asn1.DERObject r11 = r15.getDERObject()
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x051b
            goto L_0x0524
        L_0x051b:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r14)
            throw r0
        L_0x0521:
            r11.setBagAttribute(r8, r5)
        L_0x0524:
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r11 = pkcs_9_at_friendlyName
            boolean r11 = r8.equals(r11)
            if (r11 == 0) goto L_0x0533
            repack.org.bouncycastle.asn1.DERBMPString r5 = (repack.org.bouncycastle.asn1.DERBMPString) r5
            java.lang.String r4 = r5.getString()
            goto L_0x04e0
        L_0x0533:
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r11 = pkcs_9_at_localKeyId
            boolean r8 = r8.equals(r11)
            if (r8 == 0) goto L_0x04e0
            r12 = r5
            repack.org.bouncycastle.asn1.ASN1OctetString r12 = (repack.org.bouncycastle.asn1.ASN1OctetString) r12
            goto L_0x04e0
        L_0x053f:
            r6 = 0
            r10 = 1
            r4 = r1
            r12 = r4
        L_0x0543:
            java.util.Hashtable r2 = r7.chainCerts
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$CertId r5 = new repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$CertId
            java.security.PublicKey r8 = r3.getPublicKey()
            r5.<init>((java.security.PublicKey) r8)
            r2.put(r5, r3)
            if (r16 == 0) goto L_0x057f
            java.util.Hashtable r2 = r7.keyCerts
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x059a
            java.lang.String r2 = new java.lang.String
            java.security.PublicKey r4 = r3.getPublicKey()
            repack.org.bouncycastle.asn1.x509.SubjectKeyIdentifier r4 = r7.createSubjectKeyId(r4)
            byte[] r4 = r4.getKeyIdentifier()
            byte[] r4 = repack.org.bouncycastle.util.encoders.Hex.encode(r4)
            r2.<init>(r4)
            java.util.Hashtable r4 = r7.keyCerts
            r4.put(r2, r3)
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r3 = r7.keys
            java.lang.Object r4 = r3.remove(r13)
            r3.put(r2, r4)
            goto L_0x059a
        L_0x057f:
            if (r12 == 0) goto L_0x0593
            java.lang.String r2 = new java.lang.String
            byte[] r5 = r12.getOctets()
            byte[] r5 = repack.org.bouncycastle.util.encoders.Hex.encode(r5)
            r2.<init>(r5)
            java.util.Hashtable r5 = r7.keyCerts
            r5.put(r2, r3)
        L_0x0593:
            if (r4 == 0) goto L_0x059a
            repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore$IgnoresCaseHashtable r2 = r7.certs
            r2.put(r4, r3)
        L_0x059a:
            int r0 = r0 + 1
            goto L_0x0497
        L_0x059e:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x05a9:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported certificate type: "
            r1.<init>(r2)
            repack.org.bouncycastle.asn1.DERObjectIdentifier r2 = r3.getCertId()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x05c1:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "stream does not represent a PKCS12 key store"
            r0.<init>(r1)
            throw r0
        L_0x05c9:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "No password supplied for PKCS#12 KeyStore."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.JDKPKCS12KeyStore.engineLoad(java.io.InputStream, char[]):void");
    }

    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        int i;
        int i2;
        char c;
        char c2;
        Enumeration enumeration;
        boolean z;
        Enumeration enumeration2;
        boolean z2;
        boolean z3;
        char[] cArr2 = cArr;
        if (cArr2 != null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            Enumeration keys2 = this.keys.keys();
            while (true) {
                i = 1024;
                i2 = 20;
                c = 1;
                c2 = 0;
                if (!keys2.hasMoreElements()) {
                    break;
                }
                byte[] bArr = new byte[20];
                this.random.nextBytes(bArr);
                String str = (String) keys2.nextElement();
                PrivateKey privateKey = (PrivateKey) this.keys.get(str);
                PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams(bArr, 1024);
                EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(this.keyAlgorithm, pKCS12PBEParams.getDERObject()), wrapKey(this.keyAlgorithm.getId(), privateKey, pKCS12PBEParams, cArr2));
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                if (privateKey instanceof PKCS12BagAttributeCarrier) {
                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) privateKey;
                    DERBMPString dERBMPString = (DERBMPString) pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_friendlyName);
                    if (dERBMPString == null || !dERBMPString.getString().equals(str)) {
                        pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str));
                    }
                    if (pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                        pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_localKeyId, createSubjectKeyId(engineGetCertificate(str).getPublicKey()));
                    }
                    Enumeration bagAttributeKeys = pKCS12BagAttributeCarrier.getBagAttributeKeys();
                    boolean z4 = false;
                    while (bagAttributeKeys.hasMoreElements()) {
                        DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) bagAttributeKeys.nextElement();
                        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                        aSN1EncodableVector3.add(dERObjectIdentifier);
                        aSN1EncodableVector3.add(new DERSet(pKCS12BagAttributeCarrier.getBagAttribute(dERObjectIdentifier)));
                        aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector3));
                        z4 = true;
                    }
                    z3 = z4;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                    Certificate engineGetCertificate = engineGetCertificate(str);
                    aSN1EncodableVector4.add(pkcs_9_at_localKeyId);
                    aSN1EncodableVector4.add(new DERSet((DEREncodable) createSubjectKeyId(engineGetCertificate.getPublicKey())));
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector4));
                    ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                    aSN1EncodableVector5.add(pkcs_9_at_friendlyName);
                    aSN1EncodableVector5.add(new DERSet((DEREncodable) new DERBMPString(str)));
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector5));
                }
                aSN1EncodableVector.add(new SafeBag(pkcs8ShroudedKeyBag, encryptedPrivateKeyInfo.getDERObject(), new DERSet(aSN1EncodableVector2)));
            }
            BERConstructedOctetString bERConstructedOctetString = new BERConstructedOctetString(new DERSequence(aSN1EncodableVector).getDEREncoded());
            byte[] bArr2 = new byte[20];
            this.random.nextBytes(bArr2);
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(this.certAlgorithm, new PKCS12PBEParams(bArr2, 1024).getDERObject());
            Hashtable hashtable = new Hashtable();
            Enumeration keys3 = this.keys.keys();
            while (keys3.hasMoreElements()) {
                try {
                    String str2 = (String) keys3.nextElement();
                    Certificate engineGetCertificate2 = engineGetCertificate(str2);
                    CertBag certBag = new CertBag(x509Certificate, new DEROctetString(engineGetCertificate2.getEncoded()));
                    ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                    if (engineGetCertificate2 instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) engineGetCertificate2;
                        DERBMPString dERBMPString2 = (DERBMPString) pKCS12BagAttributeCarrier2.getBagAttribute(pkcs_9_at_friendlyName);
                        if (dERBMPString2 == null || !dERBMPString2.getString().equals(str2)) {
                            pKCS12BagAttributeCarrier2.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str2));
                        }
                        if (pKCS12BagAttributeCarrier2.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                            pKCS12BagAttributeCarrier2.setBagAttribute(pkcs_9_at_localKeyId, createSubjectKeyId(engineGetCertificate2.getPublicKey()));
                        }
                        Enumeration bagAttributeKeys2 = pKCS12BagAttributeCarrier2.getBagAttributeKeys();
                        z2 = false;
                        while (bagAttributeKeys2.hasMoreElements()) {
                            DERObjectIdentifier dERObjectIdentifier2 = (DERObjectIdentifier) bagAttributeKeys2.nextElement();
                            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                            aSN1EncodableVector8.add(dERObjectIdentifier2);
                            aSN1EncodableVector8.add(new DERSet(pKCS12BagAttributeCarrier2.getBagAttribute(dERObjectIdentifier2)));
                            aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector8));
                            keys3 = keys3;
                            z2 = true;
                        }
                        enumeration2 = keys3;
                    } else {
                        enumeration2 = keys3;
                        z2 = false;
                    }
                    if (!z2) {
                        ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                        aSN1EncodableVector9.add(pkcs_9_at_localKeyId);
                        aSN1EncodableVector9.add(new DERSet((DEREncodable) createSubjectKeyId(engineGetCertificate2.getPublicKey())));
                        aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector9));
                        ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                        aSN1EncodableVector10.add(pkcs_9_at_friendlyName);
                        aSN1EncodableVector10.add(new DERSet((DEREncodable) new DERBMPString(str2)));
                        aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector10));
                    }
                    aSN1EncodableVector6.add(new SafeBag(certBag, certBag.getDERObject(), new DERSet(aSN1EncodableVector7)));
                    hashtable.put(engineGetCertificate2, engineGetCertificate2);
                    keys3 = enumeration2;
                    i = 1024;
                    i2 = 20;
                    c = 1;
                    c2 = 0;
                } catch (CertificateEncodingException e) {
                    throw new IOException("Error encoding certificate: " + e.toString());
                }
            }
            Enumeration keys4 = this.certs.keys();
            while (keys4.hasMoreElements()) {
                OutputStream outputStream2 = outputStream;
                try {
                    String str3 = (String) keys4.nextElement();
                    Certificate certificate = (Certificate) this.certs.get(str3);
                    if (this.keys.get(str3) == null) {
                        CertBag certBag2 = new CertBag(x509Certificate, new DEROctetString(certificate.getEncoded()));
                        ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                        if (certificate instanceof PKCS12BagAttributeCarrier) {
                            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) certificate;
                            DERBMPString dERBMPString3 = (DERBMPString) pKCS12BagAttributeCarrier3.getBagAttribute(pkcs_9_at_friendlyName);
                            if (dERBMPString3 == null || !dERBMPString3.getString().equals(str3)) {
                                pKCS12BagAttributeCarrier3.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str3));
                            }
                            Enumeration bagAttributeKeys3 = pKCS12BagAttributeCarrier3.getBagAttributeKeys();
                            z = false;
                            while (bagAttributeKeys3.hasMoreElements()) {
                                Enumeration enumeration3 = keys4;
                                DERObjectIdentifier dERObjectIdentifier3 = (DERObjectIdentifier) bagAttributeKeys3.nextElement();
                                if (dERObjectIdentifier3.equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                    OutputStream outputStream3 = outputStream;
                                    keys4 = enumeration3;
                                } else {
                                    ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                                    aSN1EncodableVector12.add(dERObjectIdentifier3);
                                    aSN1EncodableVector12.add(new DERSet(pKCS12BagAttributeCarrier3.getBagAttribute(dERObjectIdentifier3)));
                                    aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector12));
                                    OutputStream outputStream4 = outputStream;
                                    keys4 = enumeration3;
                                    z = true;
                                }
                            }
                            enumeration = keys4;
                        } else {
                            enumeration = keys4;
                            z = false;
                        }
                        if (!z) {
                            ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
                            aSN1EncodableVector13.add(pkcs_9_at_friendlyName);
                            aSN1EncodableVector13.add(new DERSet((DEREncodable) new DERBMPString(str3)));
                            aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector13));
                        }
                        aSN1EncodableVector6.add(new SafeBag(certBag, certBag2.getDERObject(), new DERSet(aSN1EncodableVector11)));
                        hashtable.put(certificate, certificate);
                        keys4 = enumeration;
                    }
                    i = 1024;
                    i2 = 20;
                    c = 1;
                    c2 = 0;
                } catch (CertificateEncodingException e2) {
                    throw new IOException("Error encoding certificate: " + e2.toString());
                }
            }
            Enumeration keys5 = this.chainCerts.keys();
            while (keys5.hasMoreElements()) {
                OutputStream outputStream5 = outputStream;
                try {
                    Certificate certificate2 = (Certificate) this.chainCerts.get((CertId) keys5.nextElement());
                    if (hashtable.get(certificate2) == null) {
                        CertBag certBag3 = new CertBag(x509Certificate, new DEROctetString(certificate2.getEncoded()));
                        ASN1EncodableVector aSN1EncodableVector14 = new ASN1EncodableVector();
                        if (certificate2 instanceof PKCS12BagAttributeCarrier) {
                            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier4 = (PKCS12BagAttributeCarrier) certificate2;
                            Enumeration bagAttributeKeys4 = pKCS12BagAttributeCarrier4.getBagAttributeKeys();
                            while (bagAttributeKeys4.hasMoreElements()) {
                                DERObjectIdentifier dERObjectIdentifier4 = (DERObjectIdentifier) bagAttributeKeys4.nextElement();
                                if (!dERObjectIdentifier4.equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                    ASN1EncodableVector aSN1EncodableVector15 = new ASN1EncodableVector();
                                    aSN1EncodableVector15.add(dERObjectIdentifier4);
                                    aSN1EncodableVector15.add(new DERSet(pKCS12BagAttributeCarrier4.getBagAttribute(dERObjectIdentifier4)));
                                    aSN1EncodableVector14.add(new DERSequence(aSN1EncodableVector15));
                                }
                            }
                        }
                        aSN1EncodableVector6.add(new SafeBag(certBag, certBag3.getDERObject(), new DERSet(aSN1EncodableVector14)));
                        i = 1024;
                        i2 = 20;
                        c = 1;
                        c2 = 0;
                    }
                } catch (CertificateEncodingException e3) {
                    throw new IOException("Error encoding certificate: " + e3.toString());
                }
            }
            EncryptedData encryptedData = new EncryptedData(data, algorithmIdentifier, new BERConstructedOctetString(cryptData(true, algorithmIdentifier, cArr, false, new DERSequence(aSN1EncodableVector6).getDEREncoded())));
            ContentInfo[] contentInfoArr = new ContentInfo[2];
            contentInfoArr[c2] = new ContentInfo(data, bERConstructedOctetString);
            contentInfoArr[c] = new ContentInfo(encryptedData, encryptedData.getDERObject());
            AuthenticatedSafe authenticatedSafe = new AuthenticatedSafe(contentInfoArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new BEROutputStream(byteArrayOutputStream).writeObject(authenticatedSafe);
            ContentInfo contentInfo = new ContentInfo(data, new BERConstructedOctetString(byteArrayOutputStream.toByteArray()));
            byte[] bArr3 = new byte[i2];
            this.random.nextBytes(bArr3);
            try {
                new BEROutputStream(outputStream).writeObject(new Pfx(contentInfo, new MacData(new DigestInfo(new AlgorithmIdentifier(id_SHA1, new DERNull()), calculatePbeMac(id_SHA1, bArr3, 1024, cArr, false, ((ASN1OctetString) contentInfo.getContent()).getOctets())), bArr3, i)));
            } catch (Exception e4) {
                throw new IOException("error constructing MAC: " + e4.toString());
            }
        } else {
            throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
        }
    }

    private static byte[] calculatePbeMac(DERObjectIdentifier dERObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) throws Exception {
        SecretKeyFactory instance = SecretKeyFactory.getInstance(dERObjectIdentifier.getId(), bcProvider);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        JCEPBEKey jCEPBEKey = (JCEPBEKey) instance.generateSecret(new PBEKeySpec(cArr));
        jCEPBEKey.setTryWrongPKCS12Zero(z);
        Mac instance2 = Mac.getInstance(dERObjectIdentifier.getId(), bcProvider);
        instance2.init(jCEPBEKey, pBEParameterSpec);
        instance2.update(bArr2);
        return instance2.doFinal();
    }

    public static class BCPKCS12KeyStore extends JDKPKCS12KeyStore {
        public BCPKCS12KeyStore() {
            super(JDKPKCS12KeyStore.bcProvider, pbeWithSHAAnd3_KeyTripleDES_CBC, pbewithSHAAnd40BitRC2_CBC);
        }
    }

    public static class BCPKCS12KeyStore3DES extends JDKPKCS12KeyStore {
        public BCPKCS12KeyStore3DES() {
            super(JDKPKCS12KeyStore.bcProvider, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    public static class DefPKCS12KeyStore extends JDKPKCS12KeyStore {
        public DefPKCS12KeyStore() {
            super((Provider) null, pbeWithSHAAnd3_KeyTripleDES_CBC, pbewithSHAAnd40BitRC2_CBC);
        }
    }

    public static class DefPKCS12KeyStore3DES extends JDKPKCS12KeyStore {
        public DefPKCS12KeyStore3DES() {
            super((Provider) null, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    private static class IgnoresCaseHashtable {
        private Hashtable keys;
        private Hashtable orig;

        private IgnoresCaseHashtable() {
            this.orig = new Hashtable();
            this.keys = new Hashtable();
        }

        /* synthetic */ IgnoresCaseHashtable(IgnoresCaseHashtable ignoresCaseHashtable) {
            this();
        }

        public void put(String str, Object obj) {
            String lowerCase = Strings.toLowerCase(str);
            String str2 = (String) this.keys.get(lowerCase);
            if (str2 != null) {
                this.orig.remove(str2);
            }
            this.keys.put(lowerCase, str);
            this.orig.put(str, obj);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public Object remove(String str) {
            String str2 = (String) this.keys.remove(Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.remove(str2);
        }

        public Object get(String str) {
            String str2 = (String) this.keys.get(Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.get(str2);
        }

        public Enumeration elements() {
            return this.orig.elements();
        }
    }
}
