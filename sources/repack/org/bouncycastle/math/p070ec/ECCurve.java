package repack.org.bouncycastle.math.p070ec;

import java.math.BigInteger;
import java.util.Random;
import repack.org.bouncycastle.math.p070ec.ECFieldElement;
import repack.org.bouncycastle.math.p070ec.ECPoint;

/* renamed from: repack.org.bouncycastle.math.ec.ECCurve */
public abstract class ECCurve {

    /* renamed from: a */
    ECFieldElement f6271a;

    /* renamed from: b */
    ECFieldElement f6272b;

    public abstract ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z);

    public abstract ECPoint decodePoint(byte[] bArr);

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public ECFieldElement getA() {
        return this.f6271a;
    }

    public ECFieldElement getB() {
        return this.f6272b;
    }

    /* renamed from: repack.org.bouncycastle.math.ec.ECCurve$Fp */
    public static class C5028Fp extends ECCurve {
        ECPoint.C5030Fp infinity = new ECPoint.C5030Fp(this, (ECFieldElement) null, (ECFieldElement) null);

        /* renamed from: q */
        BigInteger f6281q;

        public C5028Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.f6281q = bigInteger;
            this.f6271a = fromBigInteger(bigInteger2);
            this.f6272b = fromBigInteger(bigInteger3);
        }

        public BigInteger getQ() {
            return this.f6281q;
        }

        public int getFieldSize() {
            return this.f6281q.bitLength();
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.C5029Fp(this.f6281q, bigInteger);
        }

        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            return new ECPoint.C5030Fp(this, fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
        }

        public ECPoint decodePoint(byte[] bArr) {
            ECPoint.C5030Fp fp;
            byte b = bArr[0];
            if (b != 0) {
                if (b == 2 || b == 3) {
                    boolean z = bArr[0] & true;
                    byte[] bArr2 = new byte[(bArr.length - 1)];
                    System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                    ECFieldElement.C5029Fp fp2 = new ECFieldElement.C5029Fp(this.f6281q, new BigInteger(1, bArr2));
                    ECFieldElement sqrt = fp2.multiply(fp2.square().add(this.f6271a)).add(this.f6272b).sqrt();
                    if (sqrt != null) {
                        if (sqrt.toBigInteger().testBit(0) == z) {
                            fp = new ECPoint.C5030Fp(this, fp2, sqrt, true);
                        } else {
                            BigInteger bigInteger = this.f6281q;
                            fp = new ECPoint.C5030Fp(this, fp2, new ECFieldElement.C5029Fp(bigInteger, bigInteger.subtract(sqrt.toBigInteger())), true);
                        }
                        return fp;
                    }
                    throw new RuntimeException("Invalid point compression");
                } else if (b == 4 || b == 6 || b == 7) {
                    byte[] bArr3 = new byte[((bArr.length - 1) / 2)];
                    byte[] bArr4 = new byte[((bArr.length - 1) / 2)];
                    System.arraycopy(bArr, 1, bArr3, 0, bArr3.length);
                    System.arraycopy(bArr, bArr3.length + 1, bArr4, 0, bArr4.length);
                    return new ECPoint.C5030Fp(this, new ECFieldElement.C5029Fp(this.f6281q, new BigInteger(1, bArr3)), new ECFieldElement.C5029Fp(this.f6281q, new BigInteger(1, bArr4)));
                } else {
                    throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(bArr[0], 16));
                }
            } else if (bArr.length <= 1) {
                return getInfinity();
            } else {
                throw new RuntimeException("Invalid point encoding");
            }
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C5028Fp)) {
                return false;
            }
            C5028Fp fp = (C5028Fp) obj;
            return this.f6281q.equals(fp.f6281q) && this.f6271a.equals(fp.f6271a) && this.f6272b.equals(fp.f6272b);
        }

        public int hashCode() {
            return (this.f6271a.hashCode() ^ this.f6272b.hashCode()) ^ this.f6281q.hashCode();
        }
    }

    /* renamed from: repack.org.bouncycastle.math.ec.ECCurve$F2m */
    public static class F2m extends ECCurve {

        /* renamed from: h */
        private BigInteger f6273h;
        private ECPoint.F2m infinity;

        /* renamed from: k1 */
        private int f6274k1;

        /* renamed from: k2 */
        private int f6275k2;

        /* renamed from: k3 */
        private int f6276k3;

        /* renamed from: m */
        private int f6277m;

        /* renamed from: mu */
        private byte f6278mu;

        /* renamed from: n */
        private BigInteger f6279n;

        /* renamed from: si */
        private BigInteger[] f6280si;

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this.f6278mu = 0;
            this.f6280si = null;
            this.f6277m = i;
            this.f6274k1 = i2;
            this.f6275k2 = i3;
            this.f6276k3 = i4;
            this.f6279n = bigInteger3;
            this.f6273h = bigInteger4;
            if (i2 != 0) {
                if (i3 == 0) {
                    if (i4 != 0) {
                        throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                    }
                } else if (i3 <= i2) {
                    throw new IllegalArgumentException("k2 must be > k1");
                } else if (i4 <= i3) {
                    throw new IllegalArgumentException("k3 must be > k2");
                }
                this.f6271a = fromBigInteger(bigInteger);
                this.f6272b = fromBigInteger(bigInteger2);
                this.infinity = new ECPoint.F2m(this, (ECFieldElement) null, (ECFieldElement) null);
                return;
            }
            throw new IllegalArgumentException("k1 must be > 0");
        }

        public int getFieldSize() {
            return this.f6277m;
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.f6277m, this.f6274k1, this.f6275k2, this.f6276k3, bigInteger);
        }

        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            return new ECPoint.F2m(this, fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
        }

        public ECPoint decodePoint(byte[] bArr) {
            byte[] bArr2 = bArr;
            byte b = bArr2[0];
            if (b != 0) {
                if (b == 2 || b == 3) {
                    byte[] bArr3 = new byte[(bArr2.length - 1)];
                    System.arraycopy(bArr2, 1, bArr3, 0, bArr3.length);
                    if (bArr2[0] == 2) {
                        return decompressPoint(bArr3, 0);
                    }
                    return decompressPoint(bArr3, 1);
                } else if (b == 4 || b == 6 || b == 7) {
                    byte[] bArr4 = new byte[((bArr2.length - 1) / 2)];
                    byte[] bArr5 = new byte[((bArr2.length - 1) / 2)];
                    System.arraycopy(bArr2, 1, bArr4, 0, bArr4.length);
                    System.arraycopy(bArr2, bArr4.length + 1, bArr5, 0, bArr5.length);
                    return new ECPoint.F2m(this, new ECFieldElement.F2m(this.f6277m, this.f6274k1, this.f6275k2, this.f6276k3, new BigInteger(1, bArr4)), new ECFieldElement.F2m(this.f6277m, this.f6274k1, this.f6275k2, this.f6276k3, new BigInteger(1, bArr5)), false);
                } else {
                    throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(bArr2[0], 16));
                }
            } else if (bArr2.length <= 1) {
                return getInfinity();
            } else {
                throw new RuntimeException("Invalid point encoding");
            }
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public boolean isKoblitz() {
            if (this.f6279n == null || this.f6273h == null) {
                return false;
            }
            return (this.f6271a.toBigInteger().equals(ECConstants.ZERO) || this.f6271a.toBigInteger().equals(ECConstants.ONE)) && this.f6272b.toBigInteger().equals(ECConstants.ONE);
        }

        /* access modifiers changed from: package-private */
        public synchronized byte getMu() {
            if (this.f6278mu == 0) {
                this.f6278mu = Tnaf.getMu(this);
            }
            return this.f6278mu;
        }

        /* access modifiers changed from: package-private */
        public synchronized BigInteger[] getSi() {
            if (this.f6280si == null) {
                this.f6280si = Tnaf.getSi(this);
            }
            return this.f6280si;
        }

        private ECPoint decompressPoint(byte[] bArr, int i) {
            ECFieldElement eCFieldElement;
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(this.f6277m, this.f6274k1, this.f6275k2, this.f6276k3, new BigInteger(1, bArr));
            boolean equals = f2m.toBigInteger().equals(ECConstants.ZERO);
            if (equals) {
                eCFieldElement = (ECFieldElement.F2m) this.f6272b;
                for (int i2 = 0; i2 < this.f6277m - 1; i2++) {
                    eCFieldElement = eCFieldElement.square();
                }
            } else {
                ECFieldElement solveQuadradicEquation = solveQuadradicEquation(f2m.add(this.f6271a).add(this.f6272b.multiply(f2m.square().invert())));
                if (solveQuadradicEquation != null) {
                    if (solveQuadradicEquation.toBigInteger().testBit(0) != i) {
                        solveQuadradicEquation = solveQuadradicEquation.add(new ECFieldElement.F2m(this.f6277m, this.f6274k1, this.f6275k2, this.f6276k3, ECConstants.ONE));
                    }
                    eCFieldElement = f2m.multiply(solveQuadradicEquation);
                } else {
                    throw new RuntimeException("Invalid point compression");
                }
            }
            return new ECPoint.F2m(this, f2m, eCFieldElement);
        }

        private ECFieldElement solveQuadradicEquation(ECFieldElement eCFieldElement) {
            ECFieldElement eCFieldElement2;
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(this.f6277m, this.f6274k1, this.f6275k2, this.f6276k3, ECConstants.ZERO);
            if (eCFieldElement.toBigInteger().equals(ECConstants.ZERO)) {
                return f2m;
            }
            Random random = new Random();
            do {
                int i = this.f6277m;
                ECFieldElement.F2m f2m2 = new ECFieldElement.F2m(i, this.f6274k1, this.f6275k2, this.f6276k3, new BigInteger(i, random));
                ECFieldElement eCFieldElement3 = eCFieldElement;
                eCFieldElement2 = f2m;
                for (int i2 = 1; i2 <= this.f6277m - 1; i2++) {
                    ECFieldElement square = eCFieldElement3.square();
                    eCFieldElement2 = eCFieldElement2.square().add(square.multiply(f2m2));
                    eCFieldElement3 = square.add(eCFieldElement);
                }
                if (!eCFieldElement3.toBigInteger().equals(ECConstants.ZERO)) {
                    return null;
                }
            } while (eCFieldElement2.square().add(eCFieldElement2).toBigInteger().equals(ECConstants.ZERO));
            return eCFieldElement2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.f6277m == f2m.f6277m && this.f6274k1 == f2m.f6274k1 && this.f6275k2 == f2m.f6275k2 && this.f6276k3 == f2m.f6276k3 && this.f6271a.equals(f2m.f6271a) && this.f6272b.equals(f2m.f6272b);
        }

        public int hashCode() {
            return ((((this.f6271a.hashCode() ^ this.f6272b.hashCode()) ^ this.f6277m) ^ this.f6274k1) ^ this.f6275k2) ^ this.f6276k3;
        }

        public int getM() {
            return this.f6277m;
        }

        public boolean isTrinomial() {
            return this.f6275k2 == 0 && this.f6276k3 == 0;
        }

        public int getK1() {
            return this.f6274k1;
        }

        public int getK2() {
            return this.f6275k2;
        }

        public int getK3() {
            return this.f6276k3;
        }

        public BigInteger getN() {
            return this.f6279n;
        }

        public BigInteger getH() {
            return this.f6273h;
        }
    }
}
