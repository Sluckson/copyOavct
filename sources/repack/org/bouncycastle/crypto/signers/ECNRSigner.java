package repack.org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DSA;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import repack.org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.ECKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.math.p070ec.ECAlgorithms;
import repack.org.bouncycastle.math.p070ec.ECConstants;

public class ECNRSigner implements DSA {
    private boolean forSigning;
    private ECKeyParameters key;
    private SecureRandom random;

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        if (!z) {
            this.key = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            this.key = (ECPrivateKeyParameters) parametersWithRandom.getParameters();
        } else {
            this.random = new SecureRandom();
            this.key = (ECPrivateKeyParameters) cipherParameters;
        }
    }

    public BigInteger[] generateSignature(byte[] bArr) {
        AsymmetricCipherKeyPair generateKeyPair;
        BigInteger mod;
        if (this.forSigning) {
            BigInteger n = ((ECPrivateKeyParameters) this.key).getParameters().getN();
            int bitLength = n.bitLength();
            BigInteger bigInteger = new BigInteger(1, bArr);
            int bitLength2 = bigInteger.bitLength();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.key;
            if (bitLength2 <= bitLength) {
                do {
                    ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                    eCKeyPairGenerator.init(new ECKeyGenerationParameters(eCPrivateKeyParameters.getParameters(), this.random));
                    generateKeyPair = eCKeyPairGenerator.generateKeyPair();
                    mod = ((ECPublicKeyParameters) generateKeyPair.getPublic()).getQ().getX().toBigInteger().add(bigInteger).mod(n);
                } while (mod.equals(ECConstants.ZERO));
                return new BigInteger[]{mod, ((ECPrivateKeyParameters) generateKeyPair.getPrivate()).getD().subtract(mod.multiply(eCPrivateKeyParameters.getD())).mod(n)};
            }
            throw new DataLengthException("input too large for ECNR key.");
        }
        throw new IllegalStateException("not initialised for signing");
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (!this.forSigning) {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) this.key;
            BigInteger n = eCPublicKeyParameters.getParameters().getN();
            int bitLength = n.bitLength();
            BigInteger bigInteger3 = new BigInteger(1, bArr);
            if (bigInteger3.bitLength() > bitLength) {
                throw new DataLengthException("input too large for ECNR key.");
            } else if (bigInteger.compareTo(ECConstants.ONE) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(ECConstants.ZERO) < 0 || bigInteger2.compareTo(n) >= 0) {
                return false;
            } else {
                return bigInteger.subtract(ECAlgorithms.sumOfTwoMultiplies(eCPublicKeyParameters.getParameters().getG(), bigInteger2, eCPublicKeyParameters.getQ(), bigInteger).getX().toBigInteger()).mod(n).equals(bigInteger3);
            }
        } else {
            throw new IllegalStateException("not initialised for verifying");
        }
    }
}
