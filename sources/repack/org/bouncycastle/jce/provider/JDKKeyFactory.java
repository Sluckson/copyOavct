package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import repack.org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import repack.org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;
import repack.org.bouncycastle.jce.spec.ElGamalPublicKeySpec;
import repack.org.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import repack.org.bouncycastle.jce.spec.GOST3410PublicKeySpec;

public abstract class JDKKeyFactory extends KeyFactorySpi {
    protected boolean elGamalFactory = false;

    public static class X509 extends JDKKeyFactory {
    }

    /* access modifiers changed from: protected */
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return createPrivateKeyFromDERStream(((PKCS8EncodedKeySpec) keySpec).getEncoded());
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
        }
    }

    /* access modifiers changed from: protected */
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return createPublicKeyFromDERStream(((X509EncodedKeySpec) keySpec).getEncoded());
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
        }
    }

    /* access modifiers changed from: protected */
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals("PKCS#8")) {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals("X.509")) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(RSAPublicKeySpec.class) && (key instanceof RSAPublicKey)) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) key;
            return new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        } else if (cls.isAssignableFrom(RSAPrivateKeySpec.class) && (key instanceof RSAPrivateKey)) {
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) key;
            return new RSAPrivateKeySpec(rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
        } else if (cls.isAssignableFrom(RSAPrivateCrtKeySpec.class) && (key instanceof RSAPrivateCrtKey)) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
            return new RSAPrivateCrtKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
        } else if (cls.isAssignableFrom(DHPrivateKeySpec.class) && (key instanceof DHPrivateKey)) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            return new DHPrivateKeySpec(dHPrivateKey.getX(), dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
        } else if (!cls.isAssignableFrom(DHPublicKeySpec.class) || !(key instanceof DHPublicKey)) {
            throw new RuntimeException("not implemented yet " + key + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + cls);
        } else {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            return new DHPublicKeySpec(dHPublicKey.getY(), dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
        }
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof RSAPublicKey) {
            return new JCERSAPublicKey((RSAPublicKey) key);
        }
        if (key instanceof RSAPrivateCrtKey) {
            return new JCERSAPrivateCrtKey((RSAPrivateCrtKey) key);
        }
        if (key instanceof RSAPrivateKey) {
            return new JCERSAPrivateKey((RSAPrivateKey) key);
        }
        if (key instanceof DHPublicKey) {
            if (this.elGamalFactory) {
                return new JCEElGamalPublicKey((DHPublicKey) key);
            }
            return new JCEDHPublicKey((DHPublicKey) key);
        } else if (key instanceof DHPrivateKey) {
            if (this.elGamalFactory) {
                return new JCEElGamalPrivateKey((DHPrivateKey) key);
            }
            return new JCEDHPrivateKey((DHPrivateKey) key);
        } else if (key instanceof DSAPublicKey) {
            return new JDKDSAPublicKey((DSAPublicKey) key);
        } else {
            if (key instanceof DSAPrivateKey) {
                return new JDKDSAPrivateKey((DSAPrivateKey) key);
            }
            if (key instanceof ElGamalPublicKey) {
                return new JCEElGamalPublicKey((ElGamalPublicKey) key);
            }
            if (key instanceof ElGamalPrivateKey) {
                return new JCEElGamalPrivateKey((ElGamalPrivateKey) key);
            }
            throw new InvalidKeyException("key type unknown");
        }
    }

    public static PublicKey createPublicKeyFromDERStream(byte[] bArr) throws IOException {
        return createPublicKeyFromPublicKeyInfo(new SubjectPublicKeyInfo((ASN1Sequence) ASN1Object.fromByteArray(bArr)));
    }

    static PublicKey createPublicKeyFromPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        DERObjectIdentifier objectId = subjectPublicKeyInfo.getAlgorithmId().getObjectId();
        if (RSAUtil.isRsaOid(objectId)) {
            return new JCERSAPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            return new JCEDHPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.dhpublicnumber)) {
            return new JCEDHPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
            return new JCEElGamalPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.id_dsa)) {
            return new JDKDSAPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(OIWObjectIdentifiers.dsaWithSHA1)) {
            return new JDKDSAPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            return new JCEECPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_94)) {
            return new JDKGOST3410PublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
            return new JCEECPublicKey(subjectPublicKeyInfo);
        }
        throw new RuntimeException("algorithm identifier " + objectId + " in key not recognised");
    }

    protected static PrivateKey createPrivateKeyFromDERStream(byte[] bArr) throws IOException {
        return createPrivateKeyFromPrivateKeyInfo(new PrivateKeyInfo((ASN1Sequence) ASN1Object.fromByteArray(bArr)));
    }

    static PrivateKey createPrivateKeyFromPrivateKeyInfo(PrivateKeyInfo privateKeyInfo) {
        DERObjectIdentifier objectId = privateKeyInfo.getAlgorithmId().getObjectId();
        if (RSAUtil.isRsaOid(objectId)) {
            return new JCERSAPrivateCrtKey(privateKeyInfo);
        }
        if (objectId.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            return new JCEDHPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.dhpublicnumber)) {
            return new JCEDHPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
            return new JCEElGamalPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.id_dsa)) {
            return new JDKDSAPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            return new JCEECPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_94)) {
            return new JDKGOST3410PrivateKey(privateKeyInfo);
        }
        if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
            return new JCEECPrivateKey(privateKeyInfo);
        }
        throw new RuntimeException("algorithm identifier " + objectId + " in key not recognised");
    }

    public static class RSA extends JDKKeyFactory {
        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
            throw new java.security.spec.InvalidKeySpecException(r4.toString());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
            return new repack.org.bouncycastle.jce.provider.JCERSAPrivateCrtKey(new repack.org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure((repack.org.bouncycastle.asn1.ASN1Sequence) repack.org.bouncycastle.asn1.ASN1Object.fromByteArray(((java.security.spec.PKCS8EncodedKeySpec) r4).getEncoded())));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0010 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.security.PrivateKey engineGeneratePrivate(java.security.spec.KeySpec r4) throws java.security.spec.InvalidKeySpecException {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.security.spec.PKCS8EncodedKeySpec
                if (r0 == 0) goto L_0x0032
                r0 = r4
                java.security.spec.PKCS8EncodedKeySpec r0 = (java.security.spec.PKCS8EncodedKeySpec) r0     // Catch:{ Exception -> 0x0010 }
                byte[] r0 = r0.getEncoded()     // Catch:{ Exception -> 0x0010 }
                java.security.PrivateKey r4 = repack.org.bouncycastle.jce.provider.JDKKeyFactory.createPrivateKeyFromDERStream(r0)     // Catch:{ Exception -> 0x0010 }
                return r4
            L_0x0010:
                repack.org.bouncycastle.jce.provider.JCERSAPrivateCrtKey r0 = new repack.org.bouncycastle.jce.provider.JCERSAPrivateCrtKey     // Catch:{ Exception -> 0x0027 }
                repack.org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure r1 = new repack.org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure     // Catch:{ Exception -> 0x0027 }
                java.security.spec.PKCS8EncodedKeySpec r4 = (java.security.spec.PKCS8EncodedKeySpec) r4     // Catch:{ Exception -> 0x0027 }
                byte[] r4 = r4.getEncoded()     // Catch:{ Exception -> 0x0027 }
                repack.org.bouncycastle.asn1.ASN1Object r4 = repack.org.bouncycastle.asn1.ASN1Object.fromByteArray(r4)     // Catch:{ Exception -> 0x0027 }
                repack.org.bouncycastle.asn1.ASN1Sequence r4 = (repack.org.bouncycastle.asn1.ASN1Sequence) r4     // Catch:{ Exception -> 0x0027 }
                r1.<init>(r4)     // Catch:{ Exception -> 0x0027 }
                r0.<init>((repack.org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure) r1)     // Catch:{ Exception -> 0x0027 }
                return r0
            L_0x0027:
                r4 = move-exception
                java.security.spec.InvalidKeySpecException r0 = new java.security.spec.InvalidKeySpecException
                java.lang.String r4 = r4.toString()
                r0.<init>(r4)
                throw r0
            L_0x0032:
                boolean r0 = r4 instanceof java.security.spec.RSAPrivateCrtKeySpec
                if (r0 == 0) goto L_0x003e
                repack.org.bouncycastle.jce.provider.JCERSAPrivateCrtKey r0 = new repack.org.bouncycastle.jce.provider.JCERSAPrivateCrtKey
                java.security.spec.RSAPrivateCrtKeySpec r4 = (java.security.spec.RSAPrivateCrtKeySpec) r4
                r0.<init>((java.security.spec.RSAPrivateCrtKeySpec) r4)
                return r0
            L_0x003e:
                boolean r0 = r4 instanceof java.security.spec.RSAPrivateKeySpec
                if (r0 == 0) goto L_0x004a
                repack.org.bouncycastle.jce.provider.JCERSAPrivateKey r0 = new repack.org.bouncycastle.jce.provider.JCERSAPrivateKey
                java.security.spec.RSAPrivateKeySpec r4 = (java.security.spec.RSAPrivateKeySpec) r4
                r0.<init>((java.security.spec.RSAPrivateKeySpec) r4)
                return r0
            L_0x004a:
                java.security.spec.InvalidKeySpecException r0 = new java.security.spec.InvalidKeySpecException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Unknown KeySpec type: "
                r1.<init>(r2)
                java.lang.Class r4 = r4.getClass()
                java.lang.String r4 = r4.getName()
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.JDKKeyFactory.RSA.engineGeneratePrivate(java.security.spec.KeySpec):java.security.PrivateKey");
        }

        /* access modifiers changed from: protected */
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof RSAPublicKeySpec) {
                return new JCERSAPublicKey((RSAPublicKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.JDKKeyFactory$DH */
    public static class C5022DH extends JDKKeyFactory {
        /* access modifiers changed from: protected */
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof DHPrivateKeySpec) {
                return new JCEDHPrivateKey((DHPrivateKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePrivate(keySpec);
        }

        /* access modifiers changed from: protected */
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof DHPublicKeySpec) {
                return new JCEDHPublicKey((DHPublicKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    public static class DSA extends JDKKeyFactory {
        /* access modifiers changed from: protected */
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof DSAPrivateKeySpec) {
                return new JDKDSAPrivateKey((DSAPrivateKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePrivate(keySpec);
        }

        /* access modifiers changed from: protected */
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof DSAPublicKeySpec) {
                return new JDKDSAPublicKey((DSAPublicKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    public static class GOST3410 extends JDKKeyFactory {
        /* access modifiers changed from: protected */
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof GOST3410PrivateKeySpec) {
                return new JDKGOST3410PrivateKey((GOST3410PrivateKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePrivate(keySpec);
        }

        /* access modifiers changed from: protected */
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof GOST3410PublicKeySpec) {
                return new JDKGOST3410PublicKey((GOST3410PublicKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    public static class ElGamal extends JDKKeyFactory {
        public ElGamal() {
            this.elGamalFactory = true;
        }

        /* access modifiers changed from: protected */
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof ElGamalPrivateKeySpec) {
                return new JCEElGamalPrivateKey((ElGamalPrivateKeySpec) keySpec);
            }
            if (keySpec instanceof DHPrivateKeySpec) {
                return new JCEElGamalPrivateKey((DHPrivateKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePrivate(keySpec);
        }

        /* access modifiers changed from: protected */
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof ElGamalPublicKeySpec) {
                return new JCEElGamalPublicKey((ElGamalPublicKeySpec) keySpec);
            }
            if (keySpec instanceof DHPublicKeySpec) {
                return new JCEElGamalPublicKey((DHPublicKeySpec) keySpec);
            }
            return JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }
}
