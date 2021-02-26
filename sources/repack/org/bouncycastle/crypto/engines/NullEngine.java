package repack.org.bouncycastle.crypto.engines;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;

public class NullEngine implements BlockCipher {
    protected static final int BLOCK_SIZE = 1;
    private boolean initialised;

    public String getAlgorithmName() {
        return "Null";
    }

    public int getBlockSize() {
        return 1;
    }

    public void reset() {
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.initialised = true;
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        if (!this.initialised) {
            throw new IllegalStateException("Null engine not initialised");
        } else if (i + 1 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 1 <= bArr2.length) {
            for (int i3 = 0; i3 < 1; i3++) {
                bArr2[i2 + i3] = bArr[i + i3];
            }
            return 1;
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }
}
