package repack.org.bouncycastle.crypto.engines;

import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.StreamCipher;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

public class VMPCEngine implements StreamCipher {

    /* renamed from: P */
    protected byte[] f6128P = null;

    /* renamed from: n */
    protected byte f6129n = 0;

    /* renamed from: s */
    protected byte f6130s = 0;
    protected byte[] workingIV;
    protected byte[] workingKey;

    public String getAlgorithmName() {
        return "VMPC";
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                this.workingIV = parametersWithIV.getIV();
                byte[] bArr = this.workingIV;
                if (bArr == null || bArr.length < 1 || bArr.length > 768) {
                    throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
                }
                this.workingKey = keyParameter.getKey();
                initKey(this.workingKey, this.workingIV);
                return;
            }
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    /* access modifiers changed from: protected */
    public void initKey(byte[] bArr, byte[] bArr2) {
        this.f6130s = 0;
        this.f6128P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f6128P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f6128P;
            int i3 = i2 & 255;
            this.f6130s = bArr3[(this.f6130s + bArr3[i3] + bArr[i2 % bArr.length]) & 255];
            byte b = bArr3[i3];
            byte b2 = this.f6130s;
            bArr3[i3] = bArr3[b2 & 255];
            bArr3[b2 & 255] = b;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f6128P;
            int i5 = i4 & 255;
            this.f6130s = bArr4[(this.f6130s + bArr4[i5] + bArr2[i4 % bArr2.length]) & 255];
            byte b3 = bArr4[i5];
            byte b4 = this.f6130s;
            bArr4[i5] = bArr4[b4 & 255];
            bArr4[b4 & 255] = b3;
        }
        this.f6129n = 0;
    }

    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr3 = this.f6128P;
                byte b = this.f6130s;
                byte b2 = this.f6129n;
                this.f6130s = bArr3[(b + bArr3[b2 & 255]) & 255];
                byte b3 = this.f6130s;
                byte b4 = bArr3[(bArr3[bArr3[b3 & 255] & 255] + 1) & 255];
                byte b5 = bArr3[b2 & 255];
                bArr3[b2 & 255] = bArr3[b3 & 255];
                bArr3[b3 & 255] = b5;
                this.f6129n = (byte) ((b2 + 1) & 255);
                bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ b4);
            }
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    public void reset() {
        initKey(this.workingKey, this.workingIV);
    }

    public byte returnByte(byte b) {
        byte[] bArr = this.f6128P;
        byte b2 = this.f6130s;
        byte b3 = this.f6129n;
        this.f6130s = bArr[(b2 + bArr[b3 & 255]) & 255];
        byte b4 = this.f6130s;
        byte b5 = bArr[(bArr[bArr[b4 & 255] & 255] + 1) & 255];
        byte b6 = bArr[b3 & 255];
        bArr[b3 & 255] = bArr[b4 & 255];
        bArr[b4 & 255] = b6;
        this.f6129n = (byte) ((b3 + 1) & 255);
        return (byte) (b ^ b5);
    }
}
