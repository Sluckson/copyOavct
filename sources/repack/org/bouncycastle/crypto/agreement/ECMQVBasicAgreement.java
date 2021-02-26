package repack.org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.BasicAgreement;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.MQVPrivateParameters;
import repack.org.bouncycastle.crypto.params.MQVPublicParameters;
import repack.org.bouncycastle.math.p070ec.ECAlgorithms;
import repack.org.bouncycastle.math.p070ec.ECConstants;
import repack.org.bouncycastle.math.p070ec.ECPoint;

public class ECMQVBasicAgreement implements BasicAgreement {
    MQVPrivateParameters privParams;

    public void init(CipherParameters cipherParameters) {
        this.privParams = (MQVPrivateParameters) cipherParameters;
    }

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
        ECPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
        return calculateMqvAgreement(staticPrivateKey.getParameters(), staticPrivateKey, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey()).getX().toBigInteger();
    }

    private ECPoint calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        ECPoint eCPoint;
        BigInteger n = eCDomainParameters.getN();
        int bitLength = (n.bitLength() + 1) / 2;
        BigInteger shiftLeft = ECConstants.ONE.shiftLeft(bitLength);
        if (eCPublicKeyParameters == null) {
            eCPoint = eCDomainParameters.getG().multiply(eCPrivateKeyParameters2.getD());
        } else {
            eCPoint = eCPublicKeyParameters.getQ();
        }
        BigInteger mod = eCPrivateKeyParameters.getD().multiply(eCPoint.getX().toBigInteger().mod(shiftLeft).setBit(bitLength)).mod(n).add(eCPrivateKeyParameters2.getD()).mod(n);
        BigInteger bit = eCPublicKeyParameters3.getQ().getX().toBigInteger().mod(shiftLeft).setBit(bitLength);
        BigInteger mod2 = eCDomainParameters.getH().multiply(mod).mod(n);
        ECPoint sumOfTwoMultiplies = ECAlgorithms.sumOfTwoMultiplies(eCPublicKeyParameters2.getQ(), bit.multiply(mod2).mod(n), eCPublicKeyParameters3.getQ(), mod2);
        if (!sumOfTwoMultiplies.isInfinity()) {
            return sumOfTwoMultiplies;
        }
        throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
    }
}
