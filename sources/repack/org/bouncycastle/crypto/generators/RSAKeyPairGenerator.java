package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;
import repack.org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private RSAKeyGenerationParameters param;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (RSAKeyGenerationParameters) keyGenerationParameters;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger multiply;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        int strength = this.param.getStrength();
        int i = (strength + 1) / 2;
        int i2 = strength - i;
        int i3 = strength / 3;
        BigInteger publicExponent = this.param.getPublicExponent();
        while (true) {
            bigInteger = new BigInteger(i, 1, this.param.getRandom());
            if (!bigInteger.mod(publicExponent).equals(ONE) && bigInteger.isProbablePrime(this.param.getCertainty()) && publicExponent.gcd(bigInteger.subtract(ONE)).equals(ONE)) {
                break;
            }
        }
        while (true) {
            bigInteger2 = new BigInteger(i2, 1, this.param.getRandom());
            if (bigInteger2.subtract(bigInteger).abs().bitLength() >= i3 && !bigInteger2.mod(publicExponent).equals(ONE) && bigInteger2.isProbablePrime(this.param.getCertainty()) && publicExponent.gcd(bigInteger2.subtract(ONE)).equals(ONE)) {
                multiply = bigInteger.multiply(bigInteger2);
                if (multiply.bitLength() == this.param.getStrength()) {
                    break;
                }
                bigInteger = bigInteger.max(bigInteger2);
            }
        }
        if (bigInteger.compareTo(bigInteger2) < 0) {
            bigInteger4 = bigInteger2;
            bigInteger3 = bigInteger;
        } else {
            bigInteger3 = bigInteger2;
            bigInteger4 = bigInteger;
        }
        BigInteger subtract = bigInteger4.subtract(ONE);
        BigInteger subtract2 = bigInteger3.subtract(ONE);
        BigInteger modInverse = publicExponent.modInverse(subtract.multiply(subtract2));
        return new AsymmetricCipherKeyPair(new RSAKeyParameters(false, multiply, publicExponent), new RSAPrivateCrtKeyParameters(multiply, publicExponent, modInverse, bigInteger4, bigInteger3, modInverse.remainder(subtract), modInverse.remainder(subtract2), bigInteger3.modInverse(bigInteger4)));
    }
}
