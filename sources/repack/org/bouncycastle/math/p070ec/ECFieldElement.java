package repack.org.bouncycastle.math.p070ec;

import java.math.BigInteger;
import java.util.Random;

/* renamed from: repack.org.bouncycastle.math.ec.ECFieldElement */
public abstract class ECFieldElement implements ECConstants {
    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(2);
    }

    /* renamed from: repack.org.bouncycastle.math.ec.ECFieldElement$Fp */
    public static class C5029Fp extends ECFieldElement {

        /* renamed from: q */
        BigInteger f6288q;

        /* renamed from: x */
        BigInteger f6289x;

        public String getFieldName() {
            return "Fp";
        }

        public C5029Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this.f6289x = bigInteger2;
            if (bigInteger2.compareTo(bigInteger) < 0) {
                this.f6288q = bigInteger;
                return;
            }
            throw new IllegalArgumentException("x value too large in field element");
        }

        public BigInteger toBigInteger() {
            return this.f6289x;
        }

        public int getFieldSize() {
            return this.f6288q.bitLength();
        }

        public BigInteger getQ() {
            return this.f6288q;
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new C5029Fp(this.f6288q, this.f6289x.add(eCFieldElement.toBigInteger()).mod(this.f6288q));
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new C5029Fp(this.f6288q, this.f6289x.subtract(eCFieldElement.toBigInteger()).mod(this.f6288q));
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new C5029Fp(this.f6288q, this.f6289x.multiply(eCFieldElement.toBigInteger()).mod(this.f6288q));
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new C5029Fp(this.f6288q, this.f6289x.multiply(eCFieldElement.toBigInteger().modInverse(this.f6288q)).mod(this.f6288q));
        }

        public ECFieldElement negate() {
            return new C5029Fp(this.f6288q, this.f6289x.negate().mod(this.f6288q));
        }

        public ECFieldElement square() {
            BigInteger bigInteger = this.f6288q;
            BigInteger bigInteger2 = this.f6289x;
            return new C5029Fp(bigInteger, bigInteger2.multiply(bigInteger2).mod(this.f6288q));
        }

        public ECFieldElement invert() {
            BigInteger bigInteger = this.f6288q;
            return new C5029Fp(bigInteger, this.f6289x.modInverse(bigInteger));
        }

        public ECFieldElement sqrt() {
            if (!this.f6288q.testBit(0)) {
                throw new RuntimeException("not done yet");
            } else if (this.f6288q.testBit(1)) {
                BigInteger bigInteger = this.f6288q;
                C5029Fp fp = new C5029Fp(bigInteger, this.f6289x.modPow(bigInteger.shiftRight(2).add(ECConstants.ONE), this.f6288q));
                if (fp.square().equals(this)) {
                    return fp;
                }
                return null;
            } else {
                BigInteger subtract = this.f6288q.subtract(ECConstants.ONE);
                BigInteger shiftRight = subtract.shiftRight(1);
                if (!this.f6289x.modPow(shiftRight, this.f6288q).equals(ECConstants.ONE)) {
                    return null;
                }
                BigInteger add = subtract.shiftRight(2).shiftLeft(1).add(ECConstants.ONE);
                BigInteger bigInteger2 = this.f6289x;
                BigInteger mod = bigInteger2.shiftLeft(2).mod(this.f6288q);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger3 = new BigInteger(this.f6288q.bitLength(), random);
                    if (bigInteger3.compareTo(this.f6288q) < 0 && bigInteger3.multiply(bigInteger3).subtract(mod).modPow(shiftRight, this.f6288q).equals(subtract)) {
                        BigInteger[] lucasSequence = lucasSequence(this.f6288q, bigInteger3, bigInteger2, add);
                        BigInteger bigInteger4 = lucasSequence[0];
                        BigInteger bigInteger5 = lucasSequence[1];
                        if (bigInteger5.multiply(bigInteger5).mod(this.f6288q).equals(mod)) {
                            if (bigInteger5.testBit(0)) {
                                bigInteger5 = bigInteger5.add(this.f6288q);
                            }
                            return new C5029Fp(this.f6288q, bigInteger5.shiftRight(1));
                        } else if (!bigInteger4.equals(ECConstants.ONE) && !bigInteger4.equals(subtract)) {
                            return null;
                        }
                    }
                }
            }
        }

        private static BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            int bitLength = bigInteger4.bitLength();
            int lowestSetBit = bigInteger4.getLowestSetBit();
            BigInteger bigInteger5 = ECConstants.ONE;
            BigInteger bigInteger6 = ECConstants.TWO;
            BigInteger bigInteger7 = ECConstants.ONE;
            BigInteger bigInteger8 = ECConstants.ONE;
            BigInteger bigInteger9 = bigInteger2;
            for (int i = bitLength - 1; i >= lowestSetBit + 1; i--) {
                bigInteger7 = bigInteger7.multiply(bigInteger8).mod(bigInteger);
                if (bigInteger4.testBit(i)) {
                    bigInteger8 = bigInteger7.multiply(bigInteger3).mod(bigInteger);
                    bigInteger5 = bigInteger5.multiply(bigInteger9).mod(bigInteger);
                    bigInteger6 = bigInteger9.multiply(bigInteger6).subtract(bigInteger2.multiply(bigInteger7)).mod(bigInteger);
                    bigInteger9 = bigInteger9.multiply(bigInteger9).subtract(bigInteger8.shiftLeft(1)).mod(bigInteger);
                } else {
                    bigInteger5 = bigInteger5.multiply(bigInteger6).subtract(bigInteger7).mod(bigInteger);
                    BigInteger mod = bigInteger9.multiply(bigInteger6).subtract(bigInteger2.multiply(bigInteger7)).mod(bigInteger);
                    bigInteger6 = bigInteger6.multiply(bigInteger6).subtract(bigInteger7.shiftLeft(1)).mod(bigInteger);
                    bigInteger9 = mod;
                    bigInteger8 = bigInteger7;
                }
            }
            BigInteger mod2 = bigInteger7.multiply(bigInteger8).mod(bigInteger);
            BigInteger mod3 = mod2.multiply(bigInteger3).mod(bigInteger);
            BigInteger mod4 = bigInteger5.multiply(bigInteger6).subtract(mod2).mod(bigInteger);
            BigInteger mod5 = bigInteger9.multiply(bigInteger6).subtract(bigInteger2.multiply(mod2)).mod(bigInteger);
            BigInteger mod6 = mod2.multiply(mod3).mod(bigInteger);
            BigInteger bigInteger10 = mod5;
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                mod4 = mod4.multiply(bigInteger10).mod(bigInteger);
                bigInteger10 = bigInteger10.multiply(bigInteger10).subtract(mod6.shiftLeft(1)).mod(bigInteger);
                mod6 = mod6.multiply(mod6).mod(bigInteger);
            }
            return new BigInteger[]{mod4, bigInteger10};
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C5029Fp)) {
                return false;
            }
            C5029Fp fp = (C5029Fp) obj;
            return this.f6288q.equals(fp.f6288q) && this.f6289x.equals(fp.f6289x);
        }

        public int hashCode() {
            return this.f6288q.hashCode() ^ this.f6289x.hashCode();
        }
    }

    /* renamed from: repack.org.bouncycastle.math.ec.ECFieldElement$F2m */
    public static class F2m extends ECFieldElement {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;

        /* renamed from: k1 */
        private int f6282k1;

        /* renamed from: k2 */
        private int f6283k2;

        /* renamed from: k3 */
        private int f6284k3;

        /* renamed from: m */
        private int f6285m;
        private int representation;

        /* renamed from: t */
        private int f6286t;

        /* renamed from: x */
        private IntArray f6287x;

        public String getFieldName() {
            return "F2m";
        }

        public ECFieldElement negate() {
            return this;
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            this.f6286t = (i + 31) >> 5;
            this.f6287x = new IntArray(bigInteger, this.f6286t);
            if (i3 == 0 && i4 == 0) {
                this.representation = 2;
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                this.representation = 3;
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            if (bigInteger.signum() >= 0) {
                this.f6285m = i;
                this.f6282k1 = i2;
                this.f6283k2 = i3;
                this.f6284k3 = i4;
                return;
            }
            throw new IllegalArgumentException("x value cannot be negative");
        }

        public F2m(int i, int i2, BigInteger bigInteger) {
            this(i, i2, 0, 0, bigInteger);
        }

        private F2m(int i, int i2, int i3, int i4, IntArray intArray) {
            this.f6286t = (i + 31) >> 5;
            this.f6287x = intArray;
            this.f6285m = i;
            this.f6282k1 = i2;
            this.f6283k2 = i3;
            this.f6284k3 = i4;
            if (i3 == 0 && i4 == 0) {
                this.representation = 2;
            } else {
                this.representation = 3;
            }
        }

        public BigInteger toBigInteger() {
            return this.f6287x.toBigInteger();
        }

        public int getFieldSize() {
            return this.f6285m;
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (!(eCFieldElement instanceof F2m) || !(eCFieldElement2 instanceof F2m)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            F2m f2m = (F2m) eCFieldElement;
            F2m f2m2 = (F2m) eCFieldElement2;
            if (f2m.f6285m != f2m2.f6285m || f2m.f6282k1 != f2m2.f6282k1 || f2m.f6283k2 != f2m2.f6283k2 || f2m.f6284k3 != f2m2.f6284k3) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            } else if (f2m.representation != f2m2.representation) {
                throw new IllegalArgumentException("One of the field elements are not elements has incorrect representation");
            }
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            IntArray intArray = (IntArray) this.f6287x.clone();
            intArray.addShifted(((F2m) eCFieldElement).f6287x, 0);
            return new F2m(this.f6285m, this.f6282k1, this.f6283k2, this.f6284k3, intArray);
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            IntArray multiply = this.f6287x.multiply(((F2m) eCFieldElement).f6287x, this.f6285m);
            multiply.reduce(this.f6285m, new int[]{this.f6282k1, this.f6283k2, this.f6284k3});
            return new F2m(this.f6285m, this.f6282k1, this.f6283k2, this.f6284k3, multiply);
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public ECFieldElement square() {
            IntArray square = this.f6287x.square(this.f6285m);
            square.reduce(this.f6285m, new int[]{this.f6282k1, this.f6283k2, this.f6284k3});
            return new F2m(this.f6285m, this.f6282k1, this.f6283k2, this.f6284k3, square);
        }

        public ECFieldElement invert() {
            IntArray intArray = (IntArray) this.f6287x.clone();
            IntArray intArray2 = new IntArray(this.f6286t);
            intArray2.setBit(this.f6285m);
            intArray2.setBit(0);
            intArray2.setBit(this.f6282k1);
            if (this.representation == 3) {
                intArray2.setBit(this.f6283k2);
                intArray2.setBit(this.f6284k3);
            }
            IntArray intArray3 = new IntArray(this.f6286t);
            intArray3.setBit(0);
            IntArray intArray4 = new IntArray(this.f6286t);
            while (!intArray.isZero()) {
                int bitLength = intArray.bitLength() - intArray2.bitLength();
                if (bitLength < 0) {
                    bitLength = -bitLength;
                    IntArray intArray5 = intArray2;
                    intArray2 = intArray;
                    intArray = intArray5;
                    IntArray intArray6 = intArray4;
                    intArray4 = intArray3;
                    intArray3 = intArray6;
                }
                int i = bitLength >> 5;
                int i2 = bitLength & 31;
                intArray.addShifted(intArray2.shiftLeft(i2), i);
                intArray3.addShifted(intArray4.shiftLeft(i2), i);
            }
            return new F2m(this.f6285m, this.f6282k1, this.f6283k2, this.f6284k3, intArray4);
        }

        public ECFieldElement sqrt() {
            throw new RuntimeException("Not implemented");
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int getM() {
            return this.f6285m;
        }

        public int getK1() {
            return this.f6282k1;
        }

        public int getK2() {
            return this.f6283k2;
        }

        public int getK3() {
            return this.f6284k3;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.f6285m == f2m.f6285m && this.f6282k1 == f2m.f6282k1 && this.f6283k2 == f2m.f6283k2 && this.f6284k3 == f2m.f6284k3 && this.representation == f2m.representation && this.f6287x.equals(f2m.f6287x);
        }

        public int hashCode() {
            return (((this.f6287x.hashCode() ^ this.f6285m) ^ this.f6282k1) ^ this.f6283k2) ^ this.f6284k3;
        }
    }
}
