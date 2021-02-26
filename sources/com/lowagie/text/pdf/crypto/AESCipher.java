package com.lowagie.text.pdf.crypto;

import repack.org.bouncycastle.crypto.engines.AESFastEngine;
import repack.org.bouncycastle.crypto.modes.CBCBlockCipher;
import repack.org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

public class AESCipher {

    /* renamed from: bp */
    private PaddedBufferedBlockCipher f793bp = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESFastEngine()));

    public AESCipher(boolean z, byte[] bArr, byte[] bArr2) {
        this.f793bp.init(z, new ParametersWithIV(new KeyParameter(bArr), bArr2));
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        int updateOutputSize = this.f793bp.getUpdateOutputSize(i2);
        byte[] bArr2 = updateOutputSize > 0 ? new byte[updateOutputSize] : null;
        this.f793bp.processBytes(bArr, i, i2, bArr2, 0);
        return bArr2;
    }

    public byte[] doFinal() {
        byte[] bArr = new byte[this.f793bp.getOutputSize(0)];
        try {
            int doFinal = this.f793bp.doFinal(bArr, 0);
            if (doFinal != bArr.length) {
                byte[] bArr2 = new byte[doFinal];
                System.arraycopy(bArr, 0, bArr2, 0, doFinal);
                return bArr2;
            }
        } catch (Exception unused) {
        }
        return bArr;
    }
}
