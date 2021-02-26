package repack.org.bouncycastle.jcajce;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
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

public class DefaultJcaJceHelper implements JcaJceHelper {
    public Cipher createCipher(String str) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance(str);
    }

    public Mac createMac(String str) throws NoSuchAlgorithmException {
        return Mac.getInstance(str);
    }

    public KeyAgreement createKeyAgreement(String str) throws NoSuchAlgorithmException {
        return KeyAgreement.getInstance(str);
    }

    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameterGenerator.getInstance(str);
    }

    public AlgorithmParameters createAlgorithmParameters(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameters.getInstance(str);
    }

    public KeyGenerator createKeyGenerator(String str) throws NoSuchAlgorithmException {
        return KeyGenerator.getInstance(str);
    }

    public KeyFactory createKeyFactory(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str);
    }

    public KeyPairGenerator createKeyPairGenerator(String str) throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance(str);
    }

    public MessageDigest createDigest(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str);
    }

    public Signature createSignature(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str);
    }

    public CertificateFactory createCertificateFactory(String str) throws NoSuchAlgorithmException, CertificateException {
        return CertificateFactory.getInstance(str);
    }

    public AsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return new JceAsymmetricKeyUnwrapper(algorithmIdentifier, privateKey);
    }

    public SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey) {
        return new JceSymmetricKeyUnwrapper(algorithmIdentifier, secretKey);
    }
}
