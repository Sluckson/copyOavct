package repack.org.bouncycastle.math.p070ec;

import java.math.BigInteger;
import repack.org.bouncycastle.util.Arrays;

/* renamed from: repack.org.bouncycastle.math.ec.IntArray */
class IntArray {
    private int[] m_ints;

    public IntArray(int i) {
        this.m_ints = new int[i];
    }

    public IntArray(int[] iArr) {
        this.m_ints = iArr;
    }

    public IntArray(BigInteger bigInteger) {
        this(bigInteger, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IntArray(java.math.BigInteger r7, int r8) {
        /*
            r6 = this;
            r6.<init>()
            int r0 = r7.signum()
            r1 = -1
            if (r0 == r1) goto L_0x006f
            java.math.BigInteger r0 = repack.org.bouncycastle.math.p070ec.ECConstants.ZERO
            boolean r0 = r7.equals(r0)
            r1 = 1
            if (r0 == 0) goto L_0x0018
            int[] r7 = new int[r1]
            r6.m_ints = r7
            return
        L_0x0018:
            byte[] r7 = r7.toByteArray()
            int r0 = r7.length
            r2 = 0
            byte r3 = r7[r2]
            if (r3 != 0) goto L_0x0026
            int r0 = r0 + -1
            r3 = 1
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            int r4 = r0 + 3
            r5 = 4
            int r4 = r4 / r5
            if (r4 >= r8) goto L_0x0032
            int[] r8 = new int[r8]
            r6.m_ints = r8
            goto L_0x0036
        L_0x0032:
            int[] r8 = new int[r4]
            r6.m_ints = r8
        L_0x0036:
            int r4 = r4 - r1
            int r0 = r0 % r5
            int r0 = r0 + r3
            if (r3 >= r0) goto L_0x0051
            r8 = 0
        L_0x003c:
            if (r3 < r0) goto L_0x0045
            int[] r0 = r6.m_ints
            int r1 = r4 + -1
            r0[r4] = r8
            goto L_0x0052
        L_0x0045:
            int r8 = r8 << 8
            byte r1 = r7[r3]
            if (r1 >= 0) goto L_0x004d
            int r1 = r1 + 256
        L_0x004d:
            r8 = r8 | r1
            int r3 = r3 + 1
            goto L_0x003c
        L_0x0051:
            r1 = r4
        L_0x0052:
            if (r1 >= 0) goto L_0x0055
            return
        L_0x0055:
            r8 = 0
            r0 = 0
        L_0x0057:
            if (r8 < r5) goto L_0x0060
            int[] r8 = r6.m_ints
            r8[r1] = r0
            int r1 = r1 + -1
            goto L_0x0052
        L_0x0060:
            int r0 = r0 << 8
            int r4 = r3 + 1
            byte r3 = r7[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r3 + 256
        L_0x006a:
            r0 = r0 | r3
            int r8 = r8 + 1
            r3 = r4
            goto L_0x0057
        L_0x006f:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Only positive Integers allowed"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.math.p070ec.IntArray.<init>(java.math.BigInteger, int):void");
    }

    public boolean isZero() {
        int[] iArr = this.m_ints;
        if (iArr.length == 0) {
            return true;
        }
        if (iArr[0] == 0 && getUsedLength() == 0) {
            return true;
        }
        return false;
    }

    public int getUsedLength() {
        int[] iArr = this.m_ints;
        int length = iArr.length;
        if (length < 1) {
            return 0;
        }
        if (iArr[0] != 0) {
            do {
                length--;
            } while (this.m_ints[length] == 0);
            return length + 1;
        }
        do {
            length--;
            if (this.m_ints[length] != 0) {
                return length + 1;
            }
        } while (length > 0);
        return 0;
    }

    public int bitLength() {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return 0;
        }
        int i = usedLength - 1;
        int i2 = this.m_ints[i];
        int i3 = (i << 5) + 1;
        if ((-65536 & i2) != 0) {
            if ((-16777216 & i2) != 0) {
                i3 += 24;
                i2 >>>= 24;
            } else {
                i3 += 16;
                i2 >>>= 16;
            }
        } else if (i2 > 255) {
            i3 += 8;
            i2 >>>= 8;
        }
        while (i2 != 1) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    private int[] resizedInts(int i) {
        int[] iArr = new int[i];
        int length = this.m_ints.length;
        if (length < i) {
            i = length;
        }
        System.arraycopy(this.m_ints, 0, iArr, 0, i);
        return iArr;
    }

    public BigInteger toBigInteger() {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return ECConstants.ZERO;
        }
        int i = usedLength - 1;
        int i2 = this.m_ints[i];
        byte[] bArr = new byte[4];
        boolean z = false;
        int i3 = 0;
        for (int i4 = 3; i4 >= 0; i4--) {
            byte b = (byte) (i2 >>> (i4 * 8));
            if (z || b != 0) {
                bArr[i3] = b;
                i3++;
                z = true;
            }
        }
        byte[] bArr2 = new byte[((i * 4) + i3)];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i5] = bArr[i5];
        }
        for (int i6 = usedLength - 2; i6 >= 0; i6--) {
            int i7 = 3;
            while (i7 >= 0) {
                bArr2[i3] = (byte) (this.m_ints[i6] >>> (i7 * 8));
                i7--;
                i3++;
            }
        }
        return new BigInteger(1, bArr2);
    }

    public void shiftLeft() {
        int usedLength = getUsedLength();
        if (usedLength != 0) {
            int[] iArr = this.m_ints;
            if (iArr[usedLength - 1] < 0 && (usedLength = usedLength + 1) > iArr.length) {
                this.m_ints = resizedInts(iArr.length + 1);
            }
            int i = 0;
            boolean z = false;
            while (i < usedLength) {
                boolean z2 = this.m_ints[i] < 0;
                int[] iArr2 = this.m_ints;
                iArr2[i] = iArr2[i] << 1;
                if (z) {
                    iArr2[i] = iArr2[i] | 1;
                }
                i++;
                z = z2;
            }
        }
    }

    public IntArray shiftLeft(int i) {
        int usedLength = getUsedLength();
        if (usedLength == 0 || i == 0) {
            return this;
        }
        if (i <= 31) {
            int[] iArr = new int[(usedLength + 1)];
            int i2 = 32 - i;
            iArr[0] = this.m_ints[0] << i;
            for (int i3 = 1; i3 < usedLength; i3++) {
                int[] iArr2 = this.m_ints;
                iArr[i3] = (iArr2[i3 - 1] >>> i2) | (iArr2[i3] << i);
            }
            iArr[usedLength] = this.m_ints[usedLength - 1] >>> i2;
            return new IntArray(iArr);
        }
        throw new IllegalArgumentException("shiftLeft() for max 31 bits , " + i + "bit shift is not possible");
    }

    public void addShifted(IntArray intArray, int i) {
        int usedLength = intArray.getUsedLength();
        int i2 = usedLength + i;
        if (i2 > this.m_ints.length) {
            this.m_ints = resizedInts(i2);
        }
        for (int i3 = 0; i3 < usedLength; i3++) {
            int[] iArr = this.m_ints;
            int i4 = i3 + i;
            iArr[i4] = iArr[i4] ^ intArray.m_ints[i3];
        }
    }

    public int getLength() {
        return this.m_ints.length;
    }

    public boolean testBit(int i) {
        return ((1 << (i & 31)) & this.m_ints[i >> 5]) != 0;
    }

    public void flipBit(int i) {
        int i2 = i >> 5;
        int[] iArr = this.m_ints;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public void setBit(int i) {
        int i2 = i >> 5;
        int[] iArr = this.m_ints;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public IntArray multiply(IntArray intArray, int i) {
        int i2 = (i + 31) >> 5;
        if (this.m_ints.length < i2) {
            this.m_ints = resizedInts(i2);
        }
        int i3 = 1;
        IntArray intArray2 = new IntArray(intArray.resizedInts(intArray.getLength() + 1));
        IntArray intArray3 = new IntArray(((i + i) + 31) >> 5);
        for (int i4 = 0; i4 < 32; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                if ((this.m_ints[i5] & i3) != 0) {
                    intArray3.addShifted(intArray2, i5);
                }
            }
            i3 <<= 1;
            intArray2.shiftLeft();
        }
        return intArray3;
    }

    public void reduce(int i, int[] iArr) {
        for (int i2 = (i + i) - 2; i2 >= i; i2--) {
            if (testBit(i2)) {
                int i3 = i2 - i;
                flipBit(i3);
                flipBit(i2);
                int length = iArr.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    flipBit(iArr[length] + i3);
                }
            }
        }
        this.m_ints = resizedInts((i + 31) >> 5);
    }

    public IntArray square(int i) {
        int[] iArr = new int[16];
        iArr[1] = 1;
        iArr[2] = 4;
        iArr[3] = 5;
        iArr[4] = 16;
        iArr[5] = 17;
        iArr[6] = 20;
        iArr[7] = 21;
        iArr[8] = 64;
        iArr[9] = 65;
        iArr[10] = 68;
        iArr[11] = 69;
        iArr[12] = 80;
        iArr[13] = 81;
        iArr[14] = 84;
        iArr[15] = 85;
        int i2 = (i + 31) >> 5;
        if (this.m_ints.length < i2) {
            this.m_ints = resizedInts(i2);
        }
        IntArray intArray = new IntArray(i2 + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < 4; i5++) {
                i4 = (i4 >>> 8) | (iArr[(this.m_ints[i3] >>> (i5 * 4)) & 15] << 24);
            }
            int i6 = i3 + i3;
            intArray.m_ints[i6] = i4;
            int i7 = this.m_ints[i3] >>> 16;
            int i8 = 0;
            for (int i9 = 0; i9 < 4; i9++) {
                i8 = (i8 >>> 8) | (iArr[(i7 >>> (i9 * 4)) & 15] << 24);
            }
            intArray.m_ints[i6 + 1] = i8;
        }
        return intArray;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntArray)) {
            return false;
        }
        IntArray intArray = (IntArray) obj;
        int usedLength = getUsedLength();
        if (intArray.getUsedLength() != usedLength) {
            return false;
        }
        for (int i = 0; i < usedLength; i++) {
            if (this.m_ints[i] != intArray.m_ints[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int usedLength = getUsedLength();
        int i = 1;
        for (int i2 = 0; i2 < usedLength; i2++) {
            i = (i * 31) + this.m_ints[i2];
        }
        return i;
    }

    public Object clone() {
        return new IntArray(Arrays.clone(this.m_ints));
    }

    public String toString() {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return "0";
        }
        StringBuffer stringBuffer = new StringBuffer(Integer.toBinaryString(this.m_ints[usedLength - 1]));
        for (int i = usedLength - 2; i >= 0; i--) {
            String binaryString = Integer.toBinaryString(this.m_ints[i]);
            for (int length = binaryString.length(); length < 8; length++) {
                binaryString = "0" + binaryString;
            }
            stringBuffer.append(binaryString);
        }
        return stringBuffer.toString();
    }
}
