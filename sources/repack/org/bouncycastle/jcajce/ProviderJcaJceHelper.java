package repack.org.bouncycastle.jcajce;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import repack.org.bouncycastle.operator.SymmetricKeyUnwrapper;
import repack.org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;
import repack.org.bouncycastle.operator.jcajce.JceSymmetricKeyUnwrapper;

public class ProviderJcaJceHelper implements JcaJceHelper {
    private final Provider provider;

    public ProviderJcaJceHelper(Provider provider2) {
        this.provider = provider2;
    }

    public Cipher createCipher(String str) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance(str, this.provider);
    }

    public Mac createMac(String str) throws NoSuchAlgorithmException {
        return Mac.getInstance(str, this.provider);
    }

    public KeyAgreement createKeyAgreement(String str) throws NoSuchAlgorithmException {
        return KeyAgreement.getInstance(str, this.provider);
    }

    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameterGenerator.getInstance(str, this.provider);
    }

    public AlgorithmParameters createAlgorithmParameters(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameters.getInstance(str, this.provider);
    }

    public KeyGenerator createKeyGenerator(String str) throws NoSuchAlgorithmException {
        return KeyGenerator.getInstance(str, this.provider);
    }

    public KeyFactory createKeyFactory(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str, this.provider);
    }

    public KeyPairGenerator createKeyPairGenerator(String str) throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance(str, this.provider);
    }

    public MessageDigest createDigest(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str, this.provider);
    }

    public Signature createSignature(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str, this.provider);
    }

    public CertificateFactory createCertificateFactory(String str) throws NoSuchAlgorithmException, CertificateException {
        return CertificateFactory.getInstance(str, this.provider);
    }

    public AsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return new JceAsymmetricKeyUnwrapper(algorithmIdentifier, privateKey).setProvider(this.provider);
    }

    public SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey) {
        return new JceSymmetricKeyUnwrapper(algorithmIdentifier, secretKey).setProvider(this.provider);
    }
}
