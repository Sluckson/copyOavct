package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.digests.SHA256Digest;
import repack.org.bouncycastle.crypto.params.DSAParameters;
import repack.org.bouncycastle.crypto.params.DSAValidationParameters;
import repack.org.bouncycastle.util.Arrays;
import repack.org.bouncycastle.util.BigIntegers;

public class DSAParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    /* renamed from: L */
    private int f6134L;

    /* renamed from: N */
    private int f6135N;
    private int certainty;
    private SecureRandom random;

    private static int getDefaultN(int i) {
        return i > 1024 ? 256 : 160;
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        init(i, getDefaultN(i), i2, secureRandom);
    }

    private void init(int i, int i2, int i3, SecureRandom secureRandom) {
        this.f6134L = i;
        this.f6135N = i2;
        this.certainty = i3;
        this.random = secureRandom;
    }

    public DSAParameters generateParameters() {
        if (this.f6134L > 1024) {
            return generateParameters_FIPS186_3();
        }
        return generateParameters_FIPS186_2();
    }

    private DSAParameters generateParameters_FIPS186_2() {
        byte[] bArr = new byte[20];
        byte[] bArr2 = new byte[20];
        byte[] bArr3 = new byte[20];
        byte[] bArr4 = new byte[20];
        SHA1Digest sHA1Digest = new SHA1Digest();
        int i = this.f6134L;
        int i2 = (i - 1) / 160;
        byte[] bArr5 = new byte[(i / 8)];
        while (true) {
            this.random.nextBytes(bArr);
            hash(sHA1Digest, bArr, bArr2);
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            inc(bArr3);
            hash(sHA1Digest, bArr3, bArr3);
            for (int i3 = 0; i3 != bArr4.length; i3++) {
                bArr4[i3] = (byte) (bArr2[i3] ^ bArr3[i3]);
            }
            bArr4[0] = (byte) (bArr4[0] | Byte.MIN_VALUE);
            bArr4[19] = (byte) (bArr4[19] | 1);
            BigInteger bigInteger = new BigInteger(1, bArr4);
            if (bigInteger.isProbablePrime(this.certainty)) {
                byte[] clone = Arrays.clone(bArr);
                inc(clone);
                for (int i4 = 0; i4 < 4096; i4++) {
                    int i5 = 0;
                    while (i5 < i2) {
                        inc(clone);
                        hash(sHA1Digest, clone, bArr2);
                        i5++;
                        System.arraycopy(bArr2, 0, bArr5, bArr5.length - (bArr2.length * i5), bArr2.length);
                    }
                    inc(clone);
                    hash(sHA1Digest, clone, bArr2);
                    System.arraycopy(bArr2, bArr2.length - (bArr5.length - (bArr2.length * i2)), bArr5, 0, bArr5.length - (bArr2.length * i2));
                    bArr5[0] = (byte) (bArr5[0] | Byte.MIN_VALUE);
                    BigInteger bigInteger2 = new BigInteger(1, bArr5);
                    BigInteger subtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(ONE));
                    if (subtract.bitLength() == this.f6134L && subtract.isProbablePrime(this.certainty)) {
                        return new DSAParameters(subtract, bigInteger, calculateGenerator_FIPS186_2(subtract, bigInteger, this.random), new DSAValidationParameters(bArr, i4));
                    }
                }
                continue;
            }
        }
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger divide = bigInteger.subtract(ONE).divide(bigInteger2);
        BigInteger subtract = bigInteger.subtract(TWO);
        do {
            modPow = BigIntegers.createRandomInRange(TWO, subtract, secureRandom).modPow(divide, bigInteger);
        } while (modPow.bitLength() <= 1);
        return modPow;
    }

    private DSAParameters generateParameters_FIPS186_3() {
        SHA256Digest sHA256Digest = new SHA256Digest();
        int digestSize = sHA256Digest.getDigestSize() * 8;
        byte[] bArr = new byte[(this.f6135N / 8)];
        int i = this.f6134L;
        int i2 = (i - 1) / digestSize;
        int i3 = 1;
        int i4 = (i - 1) % digestSize;
        byte[] bArr2 = new byte[sHA256Digest.getDigestSize()];
        while (true) {
            this.random.nextBytes(bArr);
            hash(sHA256Digest, bArr, bArr2);
            BigInteger mod = new BigInteger(i3, bArr2).mod(ONE.shiftLeft(this.f6135N - i3));
            BigInteger subtract = ONE.shiftLeft(this.f6135N - i3).add(mod).add(ONE).subtract(mod.mod(TWO));
            if (subtract.isProbablePrime(this.certainty)) {
                byte[] clone = Arrays.clone(bArr);
                int i5 = this.f6134L * 4;
                for (int i6 = 0; i6 < i5; i6++) {
                    BigInteger bigInteger = ZERO;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 <= i2) {
                        inc(clone);
                        hash(sHA256Digest, clone, bArr2);
                        BigInteger bigInteger2 = new BigInteger(i3, bArr2);
                        if (i7 == i2) {
                            bigInteger2 = bigInteger2.mod(ONE.shiftLeft(i4));
                        }
                        bigInteger = bigInteger.add(bigInteger2.shiftLeft(i8));
                        i7++;
                        i8 += digestSize;
                        i3 = 1;
                    }
                    BigInteger add = bigInteger.add(ONE.shiftLeft(this.f6134L - i3));
                    BigInteger subtract2 = add.subtract(add.mod(subtract.shiftLeft(i3)).subtract(ONE));
                    if (subtract2.bitLength() == this.f6134L && subtract2.isProbablePrime(this.certainty)) {
                        return new DSAParameters(subtract2, subtract, calculateGenerator_FIPS186_3_Unverifiable(subtract2, subtract, this.random), new DSAValidationParameters(bArr, i6));
                    }
                }
                continue;
            }
        }
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return calculateGenerator_FIPS186_2(bigInteger, bigInteger2, secureRandom);
    }

    private static void hash(Digest digest, byte[] bArr, byte[] bArr2) {
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, 0);
    }

    private static void inc(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b = (byte) ((bArr[length] + 1) & 255);
            bArr[length] = b;
            if (b == 0) {
                length--;
            } else {
                return;
            }
        }
    }
}
