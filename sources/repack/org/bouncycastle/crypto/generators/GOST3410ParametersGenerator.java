package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.params.GOST3410Parameters;
import repack.org.bouncycastle.crypto.params.GOST3410ValidationParameters;

public class GOST3410ParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private SecureRandom init_random;
    private int size;
    private int typeproc;

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.size = i;
        this.typeproc = i2;
        this.init_random = secureRandom;
    }

    private int procedure_A(int i, int i2, BigInteger[] bigIntegerArr, int i3) {
        int i4;
        BigInteger[] bigIntegerArr2;
        int i5;
        BigInteger bigInteger;
        int i6;
        int i7 = i;
        while (true) {
            if (i7 >= 0 && i7 <= 65536) {
                break;
            }
            i7 = this.init_random.nextInt() / 32768;
        }
        int i8 = i2;
        while (true) {
            i4 = 1;
            if (i8 >= 0 && i8 <= 65536 && i8 / 2 != 0) {
                break;
            }
            i8 = (this.init_random.nextInt() / 32768) + 1;
        }
        BigInteger bigInteger2 = new BigInteger(Integer.toString(i8));
        BigInteger bigInteger3 = new BigInteger("19381");
        int i9 = 0;
        BigInteger[] bigIntegerArr3 = {new BigInteger(Integer.toString(i7))};
        int[] iArr = {i3};
        int i10 = 0;
        int i11 = 0;
        while (iArr[i10] >= 17) {
            int[] iArr2 = new int[(iArr.length + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            i11 = i10 + 1;
            iArr[i11] = iArr[i10] / 2;
            i10 = i11;
            bigInteger3 = bigInteger3;
            i4 = 1;
            i9 = 0;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i11 + 1)];
        bigIntegerArr4[i11] = new BigInteger("8003", 16);
        int i12 = i11 - 1;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = iArr[i12] / 16;
            while (true) {
                BigInteger[] bigIntegerArr5 = new BigInteger[bigIntegerArr3.length];
                System.arraycopy(bigIntegerArr3, i9, bigIntegerArr5, i9, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i14 + 1)];
                System.arraycopy(bigIntegerArr5, i9, bigIntegerArr2, i9, bigIntegerArr5.length);
                int i15 = 0;
                while (i15 < i14) {
                    int i16 = i11;
                    BigInteger bigInteger4 = bigInteger3;
                    int i17 = i14;
                    int i18 = i15 + 1;
                    bigIntegerArr2[i18] = bigIntegerArr2[i15].multiply(bigInteger4).add(bigInteger2).mod(TWO.pow(16));
                    i15 = i18;
                    bigInteger3 = bigInteger4;
                    i4 = 1;
                    i9 = 0;
                    i11 = i16;
                }
                BigInteger bigInteger5 = new BigInteger("0");
                int i19 = 0;
                while (i19 < i14) {
                    int i20 = i14;
                    bigInteger5 = bigInteger5.add(bigIntegerArr2[i19].multiply(TWO.pow(i19 * 16)));
                    i19++;
                    i11 = i11;
                    bigInteger3 = bigInteger3;
                    i4 = 1;
                    i9 = 0;
                }
                bigIntegerArr2[i9] = bigIntegerArr2[i14];
                int i21 = i12 + 1;
                BigInteger add = TWO.pow(iArr[i12] - i4).divide(bigIntegerArr4[i21]).add(TWO.pow(iArr[i12] - 1).multiply(bigInteger5).divide(bigIntegerArr4[i21].multiply(TWO.pow(i14 * 16))));
                if (add.mod(TWO).compareTo(ONE) == 0) {
                    add = add.add(ONE);
                }
                BigInteger bigInteger6 = add;
                int i22 = 0;
                while (true) {
                    i5 = i11;
                    bigInteger = bigInteger3;
                    long j = (long) i22;
                    bigIntegerArr4[i12] = bigIntegerArr4[i21].multiply(bigInteger6.add(BigInteger.valueOf(j))).add(ONE);
                    i6 = i14;
                    if (bigIntegerArr4[i12].compareTo(TWO.pow(iArr[i12])) != 1) {
                        if (TWO.modPow(bigIntegerArr4[i21].multiply(bigInteger6.add(BigInteger.valueOf(j))), bigIntegerArr4[i12]).compareTo(ONE) == 0 && TWO.modPow(bigInteger6.add(BigInteger.valueOf(j)), bigIntegerArr4[i12]).compareTo(ONE) != 0) {
                            break;
                        }
                        i22 += 2;
                        i11 = i5;
                        bigInteger3 = bigInteger;
                        i14 = i6;
                    } else {
                        break;
                    }
                }
                i11 = i5;
                bigInteger3 = bigInteger;
                bigIntegerArr3 = bigIntegerArr2;
                i14 = i6;
                i4 = 1;
                i9 = 0;
            }
            i12--;
            if (i12 >= 0) {
                i13++;
                i11 = i5;
                bigInteger3 = bigInteger;
                bigIntegerArr3 = bigIntegerArr2;
                i4 = 1;
                i9 = 0;
            } else {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                return bigIntegerArr2[0].intValue();
            }
        }
        return bigIntegerArr3[i9].intValue();
    }

    private long procedure_Aa(long j, long j2, BigInteger[] bigIntegerArr, int i) {
        int i2;
        BigInteger[] bigIntegerArr2;
        int i3;
        int i4;
        long j3 = j;
        while (true) {
            if (j3 >= 0 && j3 <= 4294967296L) {
                break;
            }
            j3 = (long) (this.init_random.nextInt() * 2);
        }
        long j4 = j2;
        while (true) {
            i2 = 1;
            if (j4 >= 0 && j4 <= 4294967296L && j4 / 2 != 0) {
                break;
            }
            j4 = (long) ((this.init_random.nextInt() * 2) + 1);
        }
        BigInteger bigInteger = new BigInteger(Long.toString(j4));
        BigInteger bigInteger2 = new BigInteger("97781173");
        int i5 = 0;
        BigInteger[] bigIntegerArr3 = {new BigInteger(Long.toString(j3))};
        int[] iArr = {i};
        int i6 = 0;
        int i7 = 0;
        while (iArr[i6] >= 33) {
            int[] iArr2 = new int[(iArr.length + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            i7 = i6 + 1;
            iArr[i7] = iArr[i6] / 2;
            i6 = i7;
            i2 = 1;
            i5 = 0;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i7 + 1)];
        bigIntegerArr4[i7] = new BigInteger("8000000B", 16);
        int i8 = i7 - 1;
        int i9 = 0;
        while (i9 < i7) {
            int i10 = iArr[i8] / 32;
            while (true) {
                BigInteger[] bigIntegerArr5 = new BigInteger[bigIntegerArr3.length];
                System.arraycopy(bigIntegerArr3, i5, bigIntegerArr5, i5, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i10 + 1)];
                System.arraycopy(bigIntegerArr5, i5, bigIntegerArr2, i5, bigIntegerArr5.length);
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = i7;
                    int i13 = i10;
                    int i14 = i11 + 1;
                    bigIntegerArr2[i14] = bigIntegerArr2[i11].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(32));
                    i11 = i14;
                    i2 = 1;
                    i5 = 0;
                    i7 = i12;
                }
                BigInteger bigInteger3 = new BigInteger("0");
                int i15 = 0;
                while (i15 < i10) {
                    int i16 = i10;
                    bigInteger3 = bigInteger3.add(bigIntegerArr2[i15].multiply(TWO.pow(i15 * 32)));
                    i15++;
                    i7 = i7;
                    i2 = 1;
                    i5 = 0;
                }
                bigIntegerArr2[i5] = bigIntegerArr2[i10];
                int i17 = i8 + 1;
                BigInteger add = TWO.pow(iArr[i8] - i2).divide(bigIntegerArr4[i17]).add(TWO.pow(iArr[i8] - 1).multiply(bigInteger3).divide(bigIntegerArr4[i17].multiply(TWO.pow(i10 * 32))));
                if (add.mod(TWO).compareTo(ONE) == 0) {
                    add = add.add(ONE);
                }
                BigInteger bigInteger4 = add;
                int i18 = 0;
                while (true) {
                    long j5 = (long) i18;
                    i3 = i7;
                    bigIntegerArr4[i8] = bigIntegerArr4[i17].multiply(bigInteger4.add(BigInteger.valueOf(j5))).add(ONE);
                    i4 = i10;
                    if (bigIntegerArr4[i8].compareTo(TWO.pow(iArr[i8])) != 1) {
                        if (TWO.modPow(bigIntegerArr4[i17].multiply(bigInteger4.add(BigInteger.valueOf(j5))), bigIntegerArr4[i8]).compareTo(ONE) == 0 && TWO.modPow(bigInteger4.add(BigInteger.valueOf(j5)), bigIntegerArr4[i8]).compareTo(ONE) != 0) {
                            break;
                        }
                        i18 += 2;
                        i7 = i3;
                        i10 = i4;
                    } else {
                        break;
                    }
                }
                i7 = i3;
                i10 = i4;
                bigIntegerArr3 = bigIntegerArr2;
                i2 = 1;
                i5 = 0;
            }
            i8--;
            if (i8 >= 0) {
                i9++;
                i7 = i3;
                bigIntegerArr3 = bigIntegerArr2;
                i2 = 1;
                i5 = 0;
            } else {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                return bigIntegerArr2[0].longValue();
            }
        }
        return bigIntegerArr3[i5].longValue();
    }

    private void procedure_B(int i, int i2, BigInteger[] bigIntegerArr) {
        int i3 = i;
        while (true) {
            if (i3 >= 0 && i3 <= 65536) {
                break;
            }
            i3 = this.init_random.nextInt() / 32768;
        }
        int i4 = i2;
        while (true) {
            if (i4 >= 0 && i4 <= 65536 && i4 / 2 != 0) {
                break;
            }
            i4 = (this.init_random.nextInt() / 32768) + 1;
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Integer.toString(i4));
        BigInteger bigInteger2 = new BigInteger("19381");
        int procedure_A = procedure_A(i3, i4, bigIntegerArr2, 256);
        BigInteger bigInteger3 = bigIntegerArr2[0];
        int procedure_A2 = procedure_A(procedure_A, i4, bigIntegerArr2, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr3 = new BigInteger[65];
        bigIntegerArr3[0] = new BigInteger(Integer.toString(procedure_A2));
        while (true) {
            int i5 = 0;
            while (i5 < 64) {
                int i6 = i5 + 1;
                bigIntegerArr3[i6] = bigIntegerArr3[i5].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(16));
                i5 = i6;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i7 = 0; i7 < 64; i7++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr3[i7].multiply(TWO.pow(i7 * 16)));
            }
            bigIntegerArr3[0] = bigIntegerArr3[64];
            int i8 = 1024;
            BigInteger add = TWO.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(TWO.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(TWO.pow(1024))));
            if (add.mod(TWO).compareTo(ONE) == 0) {
                add = add.add(ONE);
            }
            BigInteger bigInteger6 = add;
            int i9 = 0;
            while (true) {
                long j = (long) i9;
                BigInteger add2 = bigInteger3.multiply(bigInteger4).multiply(bigInteger6.add(BigInteger.valueOf(j))).add(ONE);
                if (add2.compareTo(TWO.pow(i8)) != 1) {
                    if (TWO.modPow(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.add(BigInteger.valueOf(j))), add2).compareTo(ONE) != 0 || TWO.modPow(bigInteger3.multiply(bigInteger6.add(BigInteger.valueOf(j))), add2).compareTo(ONE) == 0) {
                        i9 += 2;
                        i8 = 1024;
                    } else {
                        bigIntegerArr[0] = add2;
                        bigIntegerArr[1] = bigInteger3;
                        return;
                    }
                }
            }
        }
    }

    private void procedure_Bb(long j, long j2, BigInteger[] bigIntegerArr) {
        long j3 = j;
        while (true) {
            if (j3 >= 0 && j3 <= 4294967296L) {
                break;
            }
            j3 = (long) (this.init_random.nextInt() * 2);
        }
        long j4 = j2;
        while (true) {
            if (j4 >= 0 && j4 <= 4294967296L && j4 / 2 != 0) {
                break;
            }
            j4 = (long) ((this.init_random.nextInt() * 2) + 1);
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Long.toString(j4));
        BigInteger bigInteger2 = new BigInteger("97781173");
        long j5 = j4;
        BigInteger[] bigIntegerArr3 = bigIntegerArr2;
        long procedure_Aa = procedure_Aa(j3, j5, bigIntegerArr3, 256);
        BigInteger bigInteger3 = bigIntegerArr2[0];
        long procedure_Aa2 = procedure_Aa(procedure_Aa, j5, bigIntegerArr3, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr4 = new BigInteger[33];
        bigIntegerArr4[0] = new BigInteger(Long.toString(procedure_Aa2));
        while (true) {
            int i = 0;
            while (i < 32) {
                int i2 = i + 1;
                bigIntegerArr4[i2] = bigIntegerArr4[i].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(32));
                i = i2;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i3 = 0; i3 < 32; i3++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr4[i3].multiply(TWO.pow(i3 * 32)));
            }
            bigIntegerArr4[0] = bigIntegerArr4[32];
            int i4 = 1024;
            BigInteger add = TWO.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(TWO.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(TWO.pow(1024))));
            if (add.mod(TWO).compareTo(ONE) == 0) {
                add = add.add(ONE);
            }
            BigInteger bigInteger6 = add;
            int i5 = 0;
            while (true) {
                long j6 = (long) i5;
                BigInteger add2 = bigInteger3.multiply(bigInteger4).multiply(bigInteger6.add(BigInteger.valueOf(j6))).add(ONE);
                if (add2.compareTo(TWO.pow(i4)) != 1) {
                    if (TWO.modPow(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.add(BigInteger.valueOf(j6))), add2).compareTo(ONE) != 0 || TWO.modPow(bigInteger3.multiply(bigInteger6.add(BigInteger.valueOf(j6))), add2).compareTo(ONE) == 0) {
                        i5 += 2;
                        i4 = 1024;
                    } else {
                        bigIntegerArr[0] = add2;
                        bigIntegerArr[1] = bigInteger3;
                        return;
                    }
                }
            }
        }
    }

    private BigInteger procedure_C(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger subtract = bigInteger.subtract(ONE);
        BigInteger divide = subtract.divide(bigInteger2);
        int bitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigInteger3 = new BigInteger(bitLength, this.init_random);
            if (bigInteger3.compareTo(ONE) > 0 && bigInteger3.compareTo(subtract) < 0) {
                BigInteger modPow = bigInteger3.modPow(divide, bigInteger);
                if (modPow.compareTo(ONE) != 0) {
                    return modPow;
                }
            }
        }
    }

    public GOST3410Parameters generateParameters() {
        BigInteger[] bigIntegerArr = new BigInteger[2];
        if (this.typeproc == 1) {
            int nextInt = this.init_random.nextInt();
            int nextInt2 = this.init_random.nextInt();
            int i = this.size;
            if (i == 512) {
                procedure_A(nextInt, nextInt2, bigIntegerArr, 512);
            } else if (i == 1024) {
                procedure_B(nextInt, nextInt2, bigIntegerArr);
            } else {
                throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
            }
            BigInteger bigInteger = bigIntegerArr[0];
            BigInteger bigInteger2 = bigIntegerArr[1];
            return new GOST3410Parameters(bigInteger, bigInteger2, procedure_C(bigInteger, bigInteger2), new GOST3410ValidationParameters(nextInt, nextInt2));
        }
        long nextLong = this.init_random.nextLong();
        long nextLong2 = this.init_random.nextLong();
        int i2 = this.size;
        if (i2 == 512) {
            procedure_Aa(nextLong, nextLong2, bigIntegerArr, 512);
        } else if (i2 == 1024) {
            procedure_Bb(nextLong, nextLong2, bigIntegerArr);
        } else {
            throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
        }
        BigInteger bigInteger3 = bigIntegerArr[0];
        BigInteger bigInteger4 = bigIntegerArr[1];
        return new GOST3410Parameters(bigInteger3, bigInteger4, procedure_C(bigInteger3, bigInteger4), new GOST3410ValidationParameters(nextLong, nextLong2));
    }
}
