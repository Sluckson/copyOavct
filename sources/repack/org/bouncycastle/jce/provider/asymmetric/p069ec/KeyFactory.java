package repack.org.bouncycastle.jce.provider.asymmetric.p069ec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import repack.org.bouncycastle.jce.provider.JCEECPrivateKey;
import repack.org.bouncycastle.jce.provider.JCEECPublicKey;
import repack.org.bouncycastle.jce.provider.JDKKeyFactory;
import repack.org.bouncycastle.jce.spec.ECPrivateKeySpec;
import repack.org.bouncycastle.jce.spec.ECPublicKeySpec;

/* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyFactory */
public class KeyFactory extends JDKKeyFactory {
    String algorithm;

    KeyFactory(String str) {
        this.algorithm = str;
    }

    /* access modifiers changed from: protected */
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return new JCEECPrivateKey(this.algorithm, (JCEECPrivateKey) JDKKeyFactory.createPrivateKeyFromDERStream(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else if (keySpec instanceof ECPrivateKeySpec) {
            return new JCEECPrivateKey(this.algorithm, (ECPrivateKeySpec) keySpec);
        } else {
            throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
        }
    }

    /* access modifiers changed from: protected */
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return new JCEECPublicKey(this.algorithm, (JCEECPublicKey) JDKKeyFactory.createPublicKeyFromDERStream(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else if (keySpec instanceof ECPublicKeySpec) {
            return new JCEECPublicKey(this.algorithm, (ECPublicKeySpec) keySpec);
        } else {
            throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyFactory$EC */
    public static class C5026EC extends KeyFactory {
        public C5026EC() {
            super("EC");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyFactory$ECDSA */
    public static class ECDSA extends KeyFactory {
        public ECDSA() {
            super("ECDSA");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyFactory$ECGOST3410 */
    public static class ECGOST3410 extends KeyFactory {
        public ECGOST3410() {
            super("ECGOST3410");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyFactory$ECDH */
    public static class ECDH extends KeyFactory {
        public ECDH() {
            super("ECDH");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyFactory$ECDHC */
    public static class ECDHC extends KeyFactory {
        public ECDHC() {
            super("ECDHC");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyFactory$ECMQV */
    public static class ECMQV extends KeyFactory {
        public ECMQV() {
            super("ECMQV");
        }
    }
}
