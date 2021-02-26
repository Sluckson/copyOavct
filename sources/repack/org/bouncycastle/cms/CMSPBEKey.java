package repack.org.bouncycastle.cms;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEParameterSpec;

public abstract class CMSPBEKey implements PBEKey {
    private int iterationCount;
    private char[] password;
    private byte[] salt;

    public String getAlgorithm() {
        return "PKCS5S2";
    }

    public byte[] getEncoded() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] getEncoded(String str);

    public String getFormat() {
        return "RAW";
    }

    protected static PBEParameterSpec getParamSpec(AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        try {
            return (PBEParameterSpec) algorithmParameters.getParameterSpec(PBEParameterSpec.class);
        } catch (InvalidParameterSpecException e) {
            throw new InvalidAlgorithmParameterException("cannot process PBE spec: " + e.getMessage());
        }
    }

    public CMSPBEKey(char[] cArr, byte[] bArr, int i) {
        this.password = cArr;
        this.salt = bArr;
        this.iterationCount = i;
    }

    public CMSPBEKey(char[] cArr, PBEParameterSpec pBEParameterSpec) {
        this(cArr, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
    }

    public char[] getPassword() {
        return this.password;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }
}
