package repack.org.bouncycastle.crypto.agreement.kdf;

import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.crypto.DerivationParameters;

public class DHKDFParameters implements DerivationParameters {
    private final DERObjectIdentifier algorithm;
    private final byte[] extraInfo;
    private final int keySize;

    /* renamed from: z */
    private final byte[] f5905z;

    public DHKDFParameters(DERObjectIdentifier dERObjectIdentifier, int i, byte[] bArr) {
        this.algorithm = dERObjectIdentifier;
        this.keySize = i;
        this.f5905z = bArr;
        this.extraInfo = null;
    }

    public DHKDFParameters(DERObjectIdentifier dERObjectIdentifier, int i, byte[] bArr, byte[] bArr2) {
        this.algorithm = dERObjectIdentifier;
        this.keySize = i;
        this.f5905z = bArr;
        this.extraInfo = bArr2;
    }

    public DERObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public int getKeySize() {
        return this.keySize;
    }

    public byte[] getZ() {
        return this.f5905z;
    }

    public byte[] getExtraInfo() {
        return this.extraInfo;
    }
}
