package repack.org.bouncycastle.crypto.tls;

public class TlsNullCipher implements TlsCipher {
    public byte[] encodePlaintext(short s, byte[] bArr, int i, int i2) {
        return copyData(bArr, i, i2);
    }

    public byte[] decodeCiphertext(short s, byte[] bArr, int i, int i2) {
        return copyData(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public byte[] copyData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
