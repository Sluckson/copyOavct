package repack.org.bouncycastle.cms;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import repack.org.bouncycastle.crypto.PBEParametersGenerator;
import repack.org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import repack.org.bouncycastle.crypto.params.KeyParameter;

public class PKCS5Scheme2PBEKey extends CMSPBEKey {
    public PKCS5Scheme2PBEKey(char[] cArr, byte[] bArr, int i) {
        super(cArr, bArr, i);
    }

    public PKCS5Scheme2PBEKey(char[] cArr, AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        super(cArr, getParamSpec(algorithmParameters));
    }

    /* access modifiers changed from: package-private */
    public byte[] getEncoded(String str) {
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator();
        pKCS5S2ParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes(getPassword()), getSalt(), getIterationCount());
        return ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(CMSEnvelopedHelper.INSTANCE.getKeySize(str))).getKey();
    }
}
