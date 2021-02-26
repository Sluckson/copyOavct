package com.lowagie.text.pdf;

import com.lowagie.text.pdf.crypto.AESCipher;
import com.lowagie.text.pdf.crypto.ARCFOUREncryption;

public class StandardDecryption {
    private static final int AES_128 = 4;
    private boolean aes;
    protected ARCFOUREncryption arcfour;
    protected AESCipher cipher;
    private boolean initiated;

    /* renamed from: iv */
    private byte[] f764iv = new byte[16];
    private int ivptr;
    private byte[] key;

    public StandardDecryption(byte[] bArr, int i, int i2, int i3) {
        this.aes = i3 == 4;
        if (this.aes) {
            this.key = new byte[i2];
            System.arraycopy(bArr, i, this.key, 0, i2);
            return;
        }
        this.arcfour = new ARCFOUREncryption();
        this.arcfour.prepareARCFOURKey(bArr, i, i2);
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        if (!this.aes) {
            byte[] bArr2 = new byte[i2];
            this.arcfour.encryptARCFOUR(bArr, i, i2, bArr2, 0);
            return bArr2;
        } else if (this.initiated) {
            return this.cipher.update(bArr, i, i2);
        } else {
            int min = Math.min(this.f764iv.length - this.ivptr, i2);
            System.arraycopy(bArr, i, this.f764iv, this.ivptr, min);
            int i3 = i + min;
            int i4 = i2 - min;
            this.ivptr += min;
            int i5 = this.ivptr;
            byte[] bArr3 = this.f764iv;
            if (i5 != bArr3.length) {
                return null;
            }
            this.cipher = new AESCipher(false, this.key, bArr3);
            this.initiated = true;
            if (i4 > 0) {
                return this.cipher.update(bArr, i3, i4);
            }
            return null;
        }
    }

    public byte[] finish() {
        if (this.aes) {
            return this.cipher.doFinal();
        }
        return null;
    }
}
