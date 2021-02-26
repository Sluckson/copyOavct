package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.pdf.crypto.AESCipher;
import com.lowagie.text.pdf.crypto.ARCFOUREncryption;
import com.lowagie.text.pdf.crypto.IVGenerator;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEncryption extends OutputStream {
    private static final int AES_128 = 4;
    private boolean aes;
    protected ARCFOUREncryption arcfour;
    protected AESCipher cipher;
    private boolean finished;
    protected OutputStream out;

    /* renamed from: sb */
    private byte[] f634sb;

    public OutputStreamEncryption(OutputStream outputStream, byte[] bArr, int i, int i2, int i3) {
        this.f634sb = new byte[1];
        try {
            this.out = outputStream;
            this.aes = i3 == 4;
            if (this.aes) {
                byte[] iv = IVGenerator.getIV();
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                this.cipher = new AESCipher(true, bArr2, iv);
                write(iv);
                return;
            }
            this.arcfour = new ARCFOUREncryption();
            this.arcfour.prepareARCFOURKey(bArr, i, i2);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public OutputStreamEncryption(OutputStream outputStream, byte[] bArr, int i) {
        this(outputStream, bArr, 0, bArr.length, i);
    }

    public void close() throws IOException {
        finish();
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.f634sb;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.aes) {
            byte[] update = this.cipher.update(bArr, i, i2);
            if (update != null && update.length != 0) {
                this.out.write(update, 0, update.length);
                return;
            }
            return;
        }
        byte[] bArr2 = new byte[Math.min(i2, 4192)];
        while (i2 > 0) {
            int min = Math.min(i2, bArr2.length);
            this.arcfour.encryptARCFOUR(bArr, i, min, bArr2, 0);
            this.out.write(bArr2, 0, min);
            i2 -= min;
            i += min;
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            this.finished = true;
            if (this.aes) {
                try {
                    byte[] doFinal = this.cipher.doFinal();
                    this.out.write(doFinal, 0, doFinal.length);
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            }
        }
    }
}
