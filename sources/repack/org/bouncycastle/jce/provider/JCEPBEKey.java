package repack.org.bouncycastle.jce.provider;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.PBEParametersGenerator;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

public class JCEPBEKey implements PBEKey {
    String algorithm;
    int digest;
    int ivSize;
    int keySize;
    DERObjectIdentifier oid;
    CipherParameters param;
    PBEKeySpec pbeKeySpec;
    boolean tryWrong = false;
    int type;

    public String getFormat() {
        return "RAW";
    }

    public JCEPBEKey(String str, DERObjectIdentifier dERObjectIdentifier, int i, int i2, int i3, int i4, PBEKeySpec pBEKeySpec, CipherParameters cipherParameters) {
        this.algorithm = str;
        this.oid = dERObjectIdentifier;
        this.type = i;
        this.digest = i2;
        this.keySize = i3;
        this.ivSize = i4;
        this.pbeKeySpec = pBEKeySpec;
        this.param = cipherParameters;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        KeyParameter keyParameter;
        CipherParameters cipherParameters = this.param;
        if (cipherParameters != null) {
            if (cipherParameters instanceof ParametersWithIV) {
                keyParameter = (KeyParameter) ((ParametersWithIV) cipherParameters).getParameters();
            } else {
                keyParameter = (KeyParameter) cipherParameters;
            }
            return keyParameter.getKey();
        } else if (this.type == 2) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(this.pbeKeySpec.getPassword());
        } else {
            return PBEParametersGenerator.PKCS5PasswordToBytes(this.pbeKeySpec.getPassword());
        }
    }

    /* access modifiers changed from: package-private */
    public int getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public int getDigest() {
        return this.digest;
    }

    /* access modifiers changed from: package-private */
    public int getKeySize() {
        return this.keySize;
    }

    /* access modifiers changed from: package-private */
    public int getIvSize() {
        return this.ivSize;
    }

    /* access modifiers changed from: package-private */
    public CipherParameters getParam() {
        return this.param;
    }

    public char[] getPassword() {
        return this.pbeKeySpec.getPassword();
    }

    public byte[] getSalt() {
        return this.pbeKeySpec.getSalt();
    }

    public int getIterationCount() {
        return this.pbeKeySpec.getIterationCount();
    }

    public DERObjectIdentifier getOID() {
        return this.oid;
    }

    /* access modifiers changed from: package-private */
    public void setTryWrongPKCS12Zero(boolean z) {
        this.tryWrong = z;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldTryWrongPKCS12() {
        return this.tryWrong;
    }
}
