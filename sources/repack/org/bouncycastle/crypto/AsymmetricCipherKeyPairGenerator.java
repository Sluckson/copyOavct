package repack.org.bouncycastle.crypto;

public interface AsymmetricCipherKeyPairGenerator {
    AsymmetricCipherKeyPair generateKeyPair();

    void init(KeyGenerationParameters keyGenerationParameters);
}
