package repack.org.bouncycastle.crypto.modes;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

public class GOFBBlockCipher implements BlockCipher {

    /* renamed from: C1 */
    static final int f6157C1 = 16843012;

    /* renamed from: C2 */
    static final int f6158C2 = 16843009;

    /* renamed from: IV */
    private byte[] f6159IV;

    /* renamed from: N3 */
    int f6160N3;

    /* renamed from: N4 */
    int f6161N4;
    private final int blockSize;
    private final BlockCipher cipher;
    boolean firstStep = true;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public GOFBBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.blockSize = blockCipher.getBlockSize();
        if (this.blockSize == 8) {
            this.f6159IV = new byte[blockCipher.getBlockSize()];
            this.ofbV = new byte[blockCipher.getBlockSize()];
            this.ofbOutV = new byte[blockCipher.getBlockSize()];
            return;
        }
        throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.firstStep = true;
        this.f6160N3 = 0;
        this.f6161N4 = 0;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.f6159IV;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
                int i = 0;
                while (true) {
                    byte[] bArr2 = this.f6159IV;
                    if (i >= bArr2.length - iv.length) {
                        break;
                    }
                    bArr2[i] = 0;
                    i++;
                }
            } else {
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
            }
            reset();
            this.cipher.init(true, parametersWithIV.getParameters());
            return;
        }
        reset();
        this.cipher.init(true, cipherParameters);
    }

    public String getAlgorithmName() {
        return String.valueOf(this.cipher.getAlgorithmName()) + "/GCTR";
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            if (this.firstStep) {
                this.firstStep = false;
                this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
                this.f6160N3 = bytesToint(this.ofbOutV, 0);
                this.f6161N4 = bytesToint(this.ofbOutV, 4);
            }
            this.f6160N3 += f6158C2;
            this.f6161N4 += f6157C1;
            intTobytes(this.f6160N3, this.ofbV, 0);
            intTobytes(this.f6161N4, this.ofbV, 4);
            this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
            int i4 = 0;
            while (true) {
                int i5 = this.blockSize;
                if (i4 >= i5) {
                    byte[] bArr3 = this.ofbV;
                    System.arraycopy(bArr3, i5, bArr3, 0, bArr3.length - i5);
                    byte[] bArr4 = this.ofbOutV;
                    byte[] bArr5 = this.ofbV;
                    int length = bArr5.length;
                    int i6 = this.blockSize;
                    System.arraycopy(bArr4, 0, bArr5, length - i6, i6);
                    return this.blockSize;
                }
                bArr2[i2 + i4] = (byte) (this.ofbOutV[i4] ^ bArr[i + i4]);
                i4++;
            }
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    public void reset() {
        byte[] bArr = this.f6159IV;
        System.arraycopy(bArr, 0, this.ofbV, 0, bArr.length);
        this.cipher.reset();
    }

    private int bytesToint(byte[] bArr, int i) {
        return ((bArr[i + 3] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr[i + 2] << 16) & 16711680) + ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[i] & 255);
    }

    private void intTobytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }
}
