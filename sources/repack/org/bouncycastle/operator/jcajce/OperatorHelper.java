package repack.org.bouncycastle.operator.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.jcajce.JcaJceHelper;

class OperatorHelper {
    private static final Map asymmetricWrapperAlgNames = new HashMap();
    private static final Map oids = new HashMap();
    private static final Map symmetricWrapperAlgNames = new HashMap();
    private JcaJceHelper helper;

    static {
        oids.put(new DERObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        oids.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
        oids.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        oids.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        oids.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        oids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
        oids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
        oids.put(new DERObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        oids.put(new DERObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        oids.put(new DERObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        oids.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        oids.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        oids.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        oids.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
        oids.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
        asymmetricWrapperAlgNames.put(new ASN1ObjectIdentifier(PKCSObjectIdentifiers.rsaEncryption.getId()), "RSA/ECB/PKCS1Padding");
        symmetricWrapperAlgNames.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, "DESEDEWrap");
        symmetricWrapperAlgNames.put(NISTObjectIdentifiers.id_aes128_wrap, "AESWrap");
        symmetricWrapperAlgNames.put(NISTObjectIdentifiers.id_aes192_wrap, "AESWrap");
        symmetricWrapperAlgNames.put(NISTObjectIdentifiers.id_aes256_wrap, "AESWrap");
        symmetricWrapperAlgNames.put(NTTObjectIdentifiers.id_camellia128_wrap, "CamilliaWrap");
        symmetricWrapperAlgNames.put(NTTObjectIdentifiers.id_camellia192_wrap, "CamilliaWrap");
        symmetricWrapperAlgNames.put(NTTObjectIdentifiers.id_camellia256_wrap, "CamilliaWrap");
        symmetricWrapperAlgNames.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap, "SEEDWrap");
    }

    OperatorHelper(JcaJceHelper jcaJceHelper) {
        this.helper = jcaJceHelper;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.Cipher createAsymmetricWrapper(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4) throws repack.org.bouncycastle.operator.OperatorCreationException {
        /*
            r3 = this;
            java.util.Map r0 = asymmetricWrapperAlgNames     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            repack.org.bouncycastle.jcajce.JcaJceHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.Cipher r4 = r1.createCipher(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            repack.org.bouncycastle.jcajce.JcaJceHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.Cipher r4 = r0.createCipher(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            repack.org.bouncycastle.operator.OperatorCreationException r0 = new repack.org.bouncycastle.operator.OperatorCreationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "cannot create cipher: "
            r1.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.operator.jcajce.OperatorHelper.createAsymmetricWrapper(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier):javax.crypto.Cipher");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.Cipher createSymmetricWrapper(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r4) throws repack.org.bouncycastle.operator.OperatorCreationException {
        /*
            r3 = this;
            java.util.Map r0 = symmetricWrapperAlgNames     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ GeneralSecurityException -> 0x001c }
            if (r0 == 0) goto L_0x0011
            repack.org.bouncycastle.jcajce.JcaJceHelper r1 = r3.helper     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            javax.crypto.Cipher r4 = r1.createCipher(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0011 }
            return r4
        L_0x0011:
            repack.org.bouncycastle.jcajce.JcaJceHelper r0 = r3.helper     // Catch:{ GeneralSecurityException -> 0x001c }
            java.lang.String r4 = r4.getId()     // Catch:{ GeneralSecurityException -> 0x001c }
            javax.crypto.Cipher r4 = r0.createCipher(r4)     // Catch:{ GeneralSecurityException -> 0x001c }
            return r4
        L_0x001c:
            r4 = move-exception
            repack.org.bouncycastle.operator.OperatorCreationException r0 = new repack.org.bouncycastle.operator.OperatorCreationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "cannot create cipher: "
            r1.<init>(r2)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.operator.jcajce.OperatorHelper.createSymmetricWrapper(repack.org.bouncycastle.asn1.ASN1ObjectIdentifier):javax.crypto.Cipher");
    }

    /* access modifiers changed from: package-private */
    public MessageDigest createDigest(AlgorithmIdentifier algorithmIdentifier) throws GeneralSecurityException {
        try {
            return this.helper.createDigest(getSignatureName(algorithmIdentifier));
        } catch (NoSuchAlgorithmException e) {
            if (oids.get(algorithmIdentifier.getAlgorithm()) != null) {
                return this.helper.createDigest((String) oids.get(algorithmIdentifier.getAlgorithm()));
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public Signature createSignature(AlgorithmIdentifier algorithmIdentifier) throws GeneralSecurityException {
        try {
            return this.helper.createSignature(getSignatureName(algorithmIdentifier));
        } catch (NoSuchAlgorithmException e) {
            if (oids.get(algorithmIdentifier.getAlgorithm()) != null) {
                return this.helper.createSignature((String) oids.get(algorithmIdentifier.getAlgorithm()));
            }
            throw e;
        }
    }

    public Signature createRawSignature(AlgorithmIdentifier algorithmIdentifier) {
        try {
            String signatureName = getSignatureName(algorithmIdentifier);
            return this.helper.createSignature("NONE" + signatureName.substring(signatureName.indexOf("WITH")));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        DEREncodable parameters = algorithmIdentifier.getParameters();
        if (parameters != null && !DERNull.INSTANCE.equals(parameters) && algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            return String.valueOf(getDigestAlgName(RSASSAPSSparams.getInstance(parameters).getHashAlgorithm().getAlgorithm())) + "withRSAandMGF1";
        } else if (oids.containsKey(algorithmIdentifier.getAlgorithm())) {
            return (String) oids.get(algorithmIdentifier.getAlgorithm());
        } else {
            return algorithmIdentifier.getAlgorithm().getId();
        }
    }

    private static String getDigestAlgName(DERObjectIdentifier dERObjectIdentifier) {
        if (PKCSObjectIdentifiers.md5.equals(dERObjectIdentifier)) {
            return "MD5";
        }
        if (OIWObjectIdentifiers.idSHA1.equals(dERObjectIdentifier)) {
            return "SHA1";
        }
        if (NISTObjectIdentifiers.id_sha224.equals(dERObjectIdentifier)) {
            return "SHA224";
        }
        if (NISTObjectIdentifiers.id_sha256.equals(dERObjectIdentifier)) {
            return "SHA256";
        }
        if (NISTObjectIdentifiers.id_sha384.equals(dERObjectIdentifier)) {
            return "SHA384";
        }
        if (NISTObjectIdentifiers.id_sha512.equals(dERObjectIdentifier)) {
            return "SHA512";
        }
        if (TeleTrusTObjectIdentifiers.ripemd128.equals(dERObjectIdentifier)) {
            return "RIPEMD128";
        }
        if (TeleTrusTObjectIdentifiers.ripemd160.equals(dERObjectIdentifier)) {
            return "RIPEMD160";
        }
        if (TeleTrusTObjectIdentifiers.ripemd256.equals(dERObjectIdentifier)) {
            return "RIPEMD256";
        }
        if (CryptoProObjectIdentifiers.gostR3411.equals(dERObjectIdentifier)) {
            return "GOST3411";
        }
        return dERObjectIdentifier.getId();
    }

    public X509Certificate convertCertificate(X509CertificateHolder x509CertificateHolder) throws CertificateException {
        try {
            return (X509Certificate) this.helper.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(x509CertificateHolder.getEncoded()));
        } catch (IOException e) {
            throw new OpCertificateException("cannot get encoded form of certificate: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new OpCertificateException("cannot create certificate factory: " + e2.getMessage(), e2);
        } catch (NoSuchProviderException e3) {
            throw new OpCertificateException("cannot find factory provider: " + e3.getMessage(), e3);
        }
    }

    private static class OpCertificateException extends CertificateException {
        private Throwable cause;

        public OpCertificateException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }
}
