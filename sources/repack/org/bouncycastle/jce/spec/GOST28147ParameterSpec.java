package repack.org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import repack.org.bouncycastle.crypto.engines.GOST28147Engine;

public class GOST28147ParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: iv */
    private byte[] f6259iv;
    private byte[] sBox;

    public GOST28147ParameterSpec(byte[] bArr) {
        this.f6259iv = null;
        this.sBox = null;
        this.sBox = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.sBox, 0, bArr.length);
    }

    public GOST28147ParameterSpec(byte[] bArr, byte[] bArr2) {
        this(bArr);
        this.f6259iv = new byte[bArr2.length];
        System.arraycopy(bArr2, 0, this.f6259iv, 0, bArr2.length);
    }

    public GOST28147ParameterSpec(String str) {
        this.f6259iv = null;
        this.sBox = null;
        this.sBox = GOST28147Engine.getSBox(str);
    }

    public GOST28147ParameterSpec(String str, byte[] bArr) {
        this(str);
        this.f6259iv = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f6259iv, 0, bArr.length);
    }

    public byte[] getSbox() {
        return this.sBox;
    }

    public byte[] getIV() {
        byte[] bArr = this.f6259iv;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }
}
