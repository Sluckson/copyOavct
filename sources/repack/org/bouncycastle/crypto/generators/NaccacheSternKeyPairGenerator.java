package repack.org.bouncycastle.crypto.generators;

import com.lowagie.text.pdf.codec.TIFFConstants;
import com.lowagie.text.pdf.codec.wmf.MetaDo;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import p052cz.msebera.android.httpclient.HttpStatus;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import repack.org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, TIFFConstants.TIFFTAG_DOCUMENTNAME, TIFFConstants.TIFFTAG_MAKE, TIFFConstants.TIFFTAG_SAMPLESPERPIXEL, TIFFConstants.TIFFTAG_MAXSAMPLEVALUE, TIFFConstants.TIFFTAG_YRESOLUTION, TIFFConstants.TIFFTAG_GROUP4OPTIONS, 307, 311, MetaDo.META_RESIZEPALETTE, TIFFConstants.TIFFTAG_PREDICTOR, 331, TIFFConstants.TIFFTAG_TARGETPRINTER, TIFFConstants.TIFFTAG_JPEGTABLES, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, HttpStatus.SC_CONFLICT, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, HttpStatus.SC_SERVICE_UNAVAILABLE, 509, 521, MetaDo.META_SETWINDOWORG, 541, 547, 557};
    private NaccacheSternKeyGenerationParameters param;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger generatePrime;
        BigInteger add;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger generatePrime2;
        BigInteger add2;
        int i;
        long j;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        boolean z;
        BigInteger bigInteger7;
        BigInteger bigInteger8;
        BigInteger bigInteger9;
        int i2;
        int i3;
        boolean z2;
        BigInteger bigInteger10;
        int strength = this.param.getStrength();
        SecureRandom random = this.param.getRandom();
        int certainty = this.param.getCertainty();
        boolean isDebug = this.param.isDebug();
        if (isDebug) {
            System.out.println("Fetching first " + this.param.getCntSmallPrimes() + " primes.");
        }
        Vector permuteList = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), random);
        BigInteger bigInteger11 = ONE;
        BigInteger bigInteger12 = bigInteger11;
        int i4 = 0;
        while (i4 < permuteList.size() / 2) {
            SecureRandom secureRandom = random;
            int i5 = certainty;
            boolean z3 = isDebug;
            bigInteger12 = bigInteger12.multiply((BigInteger) permuteList.elementAt(i4));
            i4++;
            strength = strength;
        }
        int size = permuteList.size() / 2;
        while (size < permuteList.size()) {
            SecureRandom secureRandom2 = random;
            int i6 = certainty;
            boolean z4 = isDebug;
            bigInteger11 = bigInteger11.multiply((BigInteger) permuteList.elementAt(size));
            size++;
            strength = strength;
        }
        BigInteger multiply = bigInteger12.multiply(bigInteger11);
        int bitLength = (((strength - multiply.bitLength()) - 48) / 2) + 1;
        BigInteger generatePrime3 = generatePrime(bitLength, certainty, random);
        BigInteger generatePrime4 = generatePrime(bitLength, certainty, random);
        if (isDebug) {
            System.out.println("generating p and q");
        }
        BigInteger shiftLeft = generatePrime3.multiply(bigInteger12).shiftLeft(1);
        BigInteger shiftLeft2 = generatePrime4.multiply(bigInteger11).shiftLeft(1);
        long j2 = 0;
        long j3 = 0;
        while (true) {
            j3++;
            generatePrime = generatePrime(24, certainty, random);
            add = generatePrime.multiply(shiftLeft).add(ONE);
            if (!add.isProbablePrime(certainty)) {
                bigInteger2 = shiftLeft;
                bigInteger = shiftLeft2;
            } else {
                while (true) {
                    do {
                        generatePrime2 = generatePrime(24, certainty, random);
                    } while (generatePrime.equals(generatePrime2));
                    bigInteger2 = shiftLeft;
                    add2 = generatePrime2.multiply(shiftLeft2).add(ONE);
                    if (add2.isProbablePrime(certainty)) {
                        break;
                    }
                    BigInteger bigInteger13 = multiply;
                    BigInteger bigInteger14 = add;
                    shiftLeft = bigInteger2;
                    multiply = bigInteger13;
                }
                bigInteger = shiftLeft2;
                if (multiply.gcd(generatePrime.multiply(generatePrime2)).equals(ONE)) {
                    if (add.multiply(add2).bitLength() >= strength) {
                        break;
                    } else if (isDebug) {
                        System.out.println("key size too small. Should be " + strength + " but is actually " + add.multiply(add2).bitLength());
                    }
                } else {
                    continue;
                }
            }
            shiftLeft = bigInteger2;
            shiftLeft2 = bigInteger;
        }
        if (isDebug) {
            i = strength;
            System.out.println("needed " + j3 + " tries to generate p and q.");
        } else {
            i = strength;
        }
        BigInteger multiply2 = add.multiply(add2);
        BigInteger multiply3 = add.subtract(ONE).multiply(add2.subtract(ONE));
        if (isDebug) {
            System.out.println("generating g");
        }
        while (true) {
            SecureRandom secureRandom3 = random;
            int i7 = certainty;
            j = j2;
            int i8 = 0;
            Vector vector = new Vector();
            while (i8 != permuteList.size()) {
                BigInteger bigInteger15 = generatePrime2;
                long j4 = j;
                Vector vector2 = vector;
                BigInteger bigInteger16 = multiply;
                BigInteger bigInteger17 = add;
                BigInteger bigInteger18 = bigInteger16;
                BigInteger divide = multiply3.divide((BigInteger) permuteList.elementAt(i8));
                while (true) {
                    j4++;
                    bigInteger9 = bigInteger18;
                    i2 = i;
                    i3 = i7;
                    z2 = isDebug;
                    bigInteger8 = new BigInteger(i2, i3, secureRandom3);
                    bigInteger10 = multiply2;
                    if (!bigInteger8.modPow(divide, multiply2).equals(ONE)) {
                        break;
                    }
                    isDebug = z2;
                    multiply2 = bigInteger10;
                    i7 = i3;
                    i = i2;
                    bigInteger18 = bigInteger9;
                }
                vector2.addElement(bigInteger8);
                i8++;
                vector = vector2;
                j = j4;
                isDebug = z2;
                multiply2 = bigInteger10;
                generatePrime2 = bigInteger15;
                i7 = i3;
                i = i2;
                add = bigInteger17;
                multiply = bigInteger9;
            }
            bigInteger3 = add2;
            bigInteger4 = ONE;
            int i9 = 0;
            while (i9 < permuteList.size()) {
                BigInteger bigInteger19 = bigInteger3;
                BigInteger bigInteger20 = generatePrime2;
                Vector vector3 = vector;
                BigInteger bigInteger21 = multiply;
                BigInteger bigInteger22 = add;
                BigInteger bigInteger23 = bigInteger21;
                bigInteger4 = bigInteger4.multiply(((BigInteger) vector3.elementAt(i9)).modPow(bigInteger23.divide((BigInteger) permuteList.elementAt(i9)), multiply2)).mod(multiply2);
                i9++;
                vector = vector3;
                j = j;
                generatePrime2 = bigInteger20;
                bigInteger3 = bigInteger19;
                BigInteger bigInteger24 = bigInteger22;
                multiply = bigInteger23;
                add = bigInteger24;
            }
            int i10 = 0;
            while (true) {
                if (i10 >= permuteList.size()) {
                    bigInteger5 = add;
                    bigInteger6 = multiply;
                    z = false;
                    break;
                }
                bigInteger5 = add;
                if (bigInteger4.modPow(multiply3.divide((BigInteger) permuteList.elementAt(i10)), multiply2).equals(ONE)) {
                    if (isDebug) {
                        bigInteger6 = multiply;
                        System.out.println("g has order phi(n)/" + permuteList.elementAt(i10) + "\n g: " + bigInteger4);
                    } else {
                        bigInteger6 = multiply;
                    }
                    z = true;
                } else {
                    BigInteger bigInteger25 = bigInteger3;
                    i10++;
                    multiply = multiply;
                    add = bigInteger5;
                }
            }
            if (!z) {
                if (!bigInteger4.modPow(multiply3.divide(BigInteger.valueOf(4)), multiply2).equals(ONE)) {
                    if (!bigInteger4.modPow(multiply3.divide(generatePrime), multiply2).equals(ONE)) {
                        if (!bigInteger4.modPow(multiply3.divide(generatePrime2), multiply2).equals(ONE)) {
                            if (!bigInteger4.modPow(multiply3.divide(generatePrime3), multiply2).equals(ONE)) {
                                if (!bigInteger4.modPow(multiply3.divide(generatePrime4), multiply2).equals(ONE)) {
                                    break;
                                } else if (isDebug) {
                                    System.out.println("g has order phi(n)/b\n g: " + bigInteger4);
                                }
                            } else if (isDebug) {
                                System.out.println("g has order phi(n)/a\n g: " + bigInteger4);
                            }
                        } else if (isDebug) {
                            System.out.println("g has order phi(n)/q'\n g: " + bigInteger4);
                        }
                    } else if (isDebug) {
                        System.out.println("g has order phi(n)/p'\n g: " + bigInteger4);
                    }
                } else if (isDebug) {
                    System.out.println("g has order phi(n)/4\n g:" + bigInteger4);
                }
            }
            j2 = j;
            random = secureRandom3;
            certainty = i7;
            add2 = bigInteger3;
            add = bigInteger5;
            multiply = bigInteger6;
        }
        if (isDebug) {
            System.out.println("needed " + j + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            System.out.println("smallPrimes: " + permuteList);
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder("sigma:...... ");
            bigInteger7 = bigInteger6;
            sb.append(bigInteger7);
            sb.append(" (");
            sb.append(bigInteger7.bitLength());
            sb.append(" bits)");
            printStream.println(sb.toString());
            System.out.println("a:.......... " + generatePrime3);
            System.out.println("b:.......... " + generatePrime4);
            System.out.println("p':......... " + generatePrime);
            System.out.println("q':......... " + generatePrime2);
            System.out.println("p:.......... " + bigInteger5);
            System.out.println("q:.......... " + bigInteger3);
            System.out.println("n:.......... " + multiply2);
            System.out.println("phi(n):..... " + multiply3);
            System.out.println("g:.......... " + bigInteger4);
            System.out.println();
        } else {
            bigInteger7 = bigInteger6;
        }
        return new AsymmetricCipherKeyPair(new NaccacheSternKeyParameters(false, bigInteger4, multiply2, bigInteger7.bitLength()), new NaccacheSternPrivateKeyParameters(bigInteger4, multiply2, bigInteger7.bitLength(), permuteList, multiply3));
    }

    private static BigInteger generatePrime(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigInteger = new BigInteger(i, i2, secureRandom);
        while (bigInteger.bitLength() != i) {
            bigInteger = new BigInteger(i, i2, secureRandom);
        }
        return bigInteger;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            vector3.addElement(vector.elementAt(i));
        }
        vector2.addElement(vector3.elementAt(0));
        vector3.removeElementAt(0);
        while (vector3.size() != 0) {
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
            vector3.removeElementAt(0);
        }
        return vector2;
    }

    private static int getInt(SecureRandom secureRandom, int i) {
        int nextInt;
        int i2;
        if (((-i) & i) == i) {
            return (int) ((((long) i) * ((long) (secureRandom.nextInt() & Integer.MAX_VALUE))) >> 31);
        }
        do {
            nextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i2 = nextInt % i;
        } while ((nextInt - i2) + (i - 1) < 0);
        return i2;
    }

    private static Vector findFirstPrimes(int i) {
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 != i; i2++) {
            vector.addElement(BigInteger.valueOf((long) smallPrimes[i2]));
        }
        return vector;
    }
}
