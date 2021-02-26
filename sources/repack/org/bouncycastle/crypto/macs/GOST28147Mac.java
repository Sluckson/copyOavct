package repack.org.bouncycastle.crypto.macs;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.Mac;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithSBox;

public class GOST28147Mac implements Mac {

    /* renamed from: S */
    private byte[] f6140S;
    private int blockSize = 8;
    private byte[] buf;
    private int bufOff;
    private boolean firstStep = true;
    private byte[] mac;
    private int macSize = 4;
    private int[] workingKey = null;

    public String getAlgorithmName() {
        return "GOST28147Mac";
    }

    public GOST28147Mac() {
        byte[] bArr = new byte[128];
        bArr[0] = 9;
        bArr[1] = 6;
        bArr[2] = 3;
        bArr[3] = 2;
        bArr[4] = 8;
        bArr[5] = 11;
        bArr[6] = 1;
        bArr[7] = 7;
        bArr[8] = 10;
        bArr[9] = 4;
        bArr[10] = 14;
        bArr[11] = 15;
        bArr[12] = 12;
        bArr[14] = 13;
        bArr[15] = 5;
        bArr[16] = 3;
        bArr[17] = 7;
        bArr[18] = 14;
        bArr[19] = 9;
        bArr[20] = 8;
        bArr[21] = 10;
        bArr[22] = 15;
        bArr[24] = 5;
        bArr[25] = 2;
        bArr[26] = 6;
        bArr[27] = 12;
        bArr[28] = 11;
        bArr[29] = 4;
        bArr[30] = 13;
        bArr[31] = 1;
        bArr[32] = 14;
        bArr[33] = 4;
        bArr[34] = 6;
        bArr[35] = 2;
        bArr[36] = 11;
        bArr[37] = 3;
        bArr[38] = 13;
        bArr[39] = 8;
        bArr[40] = 12;
        bArr[41] = 15;
        bArr[42] = 5;
        bArr[43] = 10;
        bArr[45] = 7;
        bArr[46] = 1;
        bArr[47] = 9;
        bArr[48] = 14;
        bArr[49] = 7;
        bArr[50] = 10;
        bArr[51] = 12;
        bArr[52] = 13;
        bArr[53] = 1;
        bArr[54] = 3;
        bArr[55] = 9;
        bArr[57] = 2;
        bArr[58] = 11;
        bArr[59] = 4;
        bArr[60] = 15;
        bArr[61] = 8;
        bArr[62] = 5;
        bArr[63] = 6;
        bArr[64] = 11;
        bArr[65] = 5;
        bArr[66] = 1;
        bArr[67] = 9;
        bArr[68] = 8;
        bArr[69] = 13;
        bArr[70] = 15;
        bArr[72] = 14;
        bArr[73] = 4;
        bArr[74] = 2;
        bArr[75] = 3;
        bArr[76] = 12;
        bArr[77] = 7;
        bArr[78] = 10;
        bArr[79] = 6;
        bArr[80] = 3;
        bArr[81] = 10;
        bArr[82] = 13;
        bArr[83] = 12;
        bArr[84] = 1;
        bArr[85] = 2;
        bArr[87] = 11;
        bArr[88] = 7;
        bArr[89] = 5;
        bArr[90] = 9;
        bArr[91] = 4;
        bArr[92] = 8;
        bArr[93] = 15;
        bArr[94] = 14;
        bArr[95] = 6;
        bArr[96] = 1;
        bArr[97] = 13;
        bArr[98] = 2;
        bArr[99] = 9;
        bArr[100] = 7;
        bArr[101] = 10;
        bArr[102] = 6;
        bArr[104] = 8;
        bArr[105] = 12;
        bArr[106] = 4;
        bArr[107] = 5;
        bArr[108] = 15;
        bArr[109] = 3;
        bArr[110] = 11;
        bArr[111] = 14;
        bArr[112] = 11;
        bArr[113] = 10;
        bArr[114] = 15;
        bArr[115] = 5;
        bArr[117] = 12;
        bArr[118] = 14;
        bArr[119] = 8;
        bArr[120] = 6;
        bArr[121] = 2;
        bArr[122] = 3;
        bArr[123] = 9;
        bArr[124] = 1;
        bArr[125] = 7;
        bArr[126] = 13;
        bArr[127] = 4;
        this.f6140S = bArr;
        int i = this.blockSize;
        this.mac = new byte[i];
        this.buf = new byte[i];
        this.bufOff = 0;
    }

    private int[] generateWorkingKey(byte[] bArr) {
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i = 0; i != 8; i++) {
                iArr[i] = bytesToint(bArr, i * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        reset();
        this.buf = new byte[this.blockSize];
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            System.arraycopy(parametersWithSBox.getSBox(), 0, this.f6140S, 0, parametersWithSBox.getSBox().length);
            if (parametersWithSBox.getParameters() != null) {
                this.workingKey = generateWorkingKey(((KeyParameter) parametersWithSBox.getParameters()).getKey());
            }
        } else if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
        } else {
            throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + cipherParameters.getClass().getName());
        }
    }

    public int getMacSize() {
        return this.macSize;
    }

    private int gost28147_mainStep(int i, int i2) {
        int i3 = i2 + i;
        byte[] bArr = this.f6140S;
        int i4 = (bArr[((i3 >> 0) & 15) + 0] << 0) + (bArr[((i3 >> 4) & 15) + 16] << 4) + (bArr[((i3 >> 8) & 15) + 32] << 8) + (bArr[((i3 >> 12) & 15) + 48] << 12) + (bArr[((i3 >> 16) & 15) + 64] << 16) + (bArr[((i3 >> 20) & 15) + 80] << 20) + (bArr[((i3 >> 24) & 15) + 96] << Ascii.CAN) + (bArr[((i3 >> 28) & 15) + 112] << Ascii.f266FS);
        return (i4 << 11) | (i4 >>> 21);
    }

    private void gost28147MacFunc(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int bytesToint = bytesToint(bArr, i);
        int bytesToint2 = bytesToint(bArr, i + 4);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = bytesToint2;
            int i5 = bytesToint;
            int i6 = 0;
            while (i6 < 8) {
                i6++;
                int gost28147_mainStep = i4 ^ gost28147_mainStep(i5, iArr[i6]);
                i4 = i5;
                i5 = gost28147_mainStep;
            }
            i3++;
            bytesToint = i5;
            bytesToint2 = i4;
        }
        intTobytes(bytesToint, bArr2, i2);
        intTobytes(bytesToint2, bArr2, i2 + 4);
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

    private byte[] CM5func(byte[] bArr, int i, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length - i)];
        System.arraycopy(bArr, i, bArr3, 0, bArr2.length);
        for (int i2 = 0; i2 != bArr2.length; i2++) {
            bArr3[i2] = (byte) (bArr3[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    public void update(byte b) throws IllegalStateException {
        int i = this.bufOff;
        byte[] bArr = this.buf;
        if (i == bArr.length) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, this.mac.length);
            if (this.firstStep) {
                this.firstStep = false;
            } else {
                bArr2 = CM5func(this.buf, 0, this.mac);
            }
            gost28147MacFunc(this.workingKey, bArr2, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr3 = this.buf;
        int i2 = this.bufOff;
        this.bufOff = i2 + 1;
        bArr3[i2] = b;
    }

    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        if (i2 >= 0) {
            int i3 = this.blockSize;
            int i4 = this.bufOff;
            int i5 = i3 - i4;
            if (i2 > i5) {
                System.arraycopy(bArr, i, this.buf, i4, i5);
                byte[] bArr2 = this.buf;
                byte[] bArr3 = new byte[bArr2.length];
                System.arraycopy(bArr2, 0, bArr3, 0, this.mac.length);
                if (this.firstStep) {
                    this.firstStep = false;
                } else {
                    bArr3 = CM5func(this.buf, 0, this.mac);
                }
                gost28147MacFunc(this.workingKey, bArr3, 0, this.mac, 0);
                this.bufOff = 0;
                while (true) {
                    i2 -= i5;
                    i += i5;
                    if (i2 <= this.blockSize) {
                        break;
                    }
                    gost28147MacFunc(this.workingKey, CM5func(bArr, i, this.mac), 0, this.mac, 0);
                    i5 = this.blockSize;
                }
            }
            System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
            this.bufOff += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        while (true) {
            int i2 = this.bufOff;
            if (i2 >= this.blockSize) {
                break;
            }
            this.buf[i2] = 0;
            this.bufOff = i2 + 1;
        }
        byte[] bArr2 = this.buf;
        byte[] bArr3 = new byte[bArr2.length];
        System.arraycopy(bArr2, 0, bArr3, 0, this.mac.length);
        if (this.firstStep) {
            this.firstStep = false;
        } else {
            bArr3 = CM5func(this.buf, 0, this.mac);
        }
        gost28147MacFunc(this.workingKey, bArr3, 0, this.mac, 0);
        byte[] bArr4 = this.mac;
        int i3 = this.macSize;
        System.arraycopy(bArr4, (bArr4.length / 2) - i3, bArr, i, i3);
        reset();
        return this.macSize;
    }

    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i >= bArr.length) {
                this.bufOff = 0;
                this.firstStep = true;
                return;
            }
            bArr[i] = 0;
            i++;
        }
    }
}
