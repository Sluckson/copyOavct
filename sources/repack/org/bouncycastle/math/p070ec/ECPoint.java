package repack.org.bouncycastle.math.p070ec;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.p065x9.X9IntegerConverter;
import repack.org.bouncycastle.math.p070ec.ECCurve;
import repack.org.bouncycastle.math.p070ec.ECFieldElement;

/* renamed from: repack.org.bouncycastle.math.ec.ECPoint */
public abstract class ECPoint {
    /* access modifiers changed from: private */
    public static X9IntegerConverter converter = new X9IntegerConverter();
    ECCurve curve;
    protected ECMultiplier multiplier = null;
    protected PreCompInfo preCompInfo = null;
    protected boolean withCompression;

    /* renamed from: x */
    ECFieldElement f6290x;

    /* renamed from: y */
    ECFieldElement f6291y;

    public abstract ECPoint add(ECPoint eCPoint);

    public abstract byte[] getEncoded();

    public abstract ECPoint negate();

    public abstract ECPoint subtract(ECPoint eCPoint);

    public abstract ECPoint twice();

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this.curve = eCCurve;
        this.f6290x = eCFieldElement;
        this.f6291y = eCFieldElement2;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECFieldElement getX() {
        return this.f6290x;
    }

    public ECFieldElement getY() {
        return this.f6291y;
    }

    public boolean isInfinity() {
        return this.f6290x == null && this.f6291y == null;
    }

    public boolean isCompressed() {
        return this.withCompression;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ECPoint)) {
            return false;
        }
        ECPoint eCPoint = (ECPoint) obj;
        if (isInfinity()) {
            return eCPoint.isInfinity();
        }
        return this.f6290x.equals(eCPoint.f6290x) && this.f6291y.equals(eCPoint.f6291y);
    }

    public int hashCode() {
        if (isInfinity()) {
            return 0;
        }
        return this.f6290x.hashCode() ^ this.f6291y.hashCode();
    }

    /* access modifiers changed from: package-private */
    public void setPreCompInfo(PreCompInfo preCompInfo2) {
        this.preCompInfo = preCompInfo2;
    }

    /* access modifiers changed from: package-private */
    public synchronized void assertECMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = new FpNafMultiplier();
        }
    }

    public ECPoint multiply(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("The multiplicator cannot be negative");
        } else if (isInfinity()) {
            return this;
        } else {
            if (bigInteger.signum() == 0) {
                return this.curve.getInfinity();
            }
            assertECMultiplier();
            return this.multiplier.multiply(this, bigInteger, this.preCompInfo);
        }
    }

    /* renamed from: repack.org.bouncycastle.math.ec.ECPoint$Fp */
    public static class C5030Fp extends ECPoint {
        public C5030Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public C5030Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null || eCFieldElement2 != null) && (eCFieldElement != null || eCFieldElement2 == null)) {
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        public byte[] getEncoded() {
            if (isInfinity()) {
                return new byte[1];
            }
            int byteLength = ECPoint.converter.getByteLength(this.f6290x);
            if (this.withCompression) {
                byte b = getY().toBigInteger().testBit(0) ? (byte) 3 : 2;
                byte[] integerToBytes = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
                byte[] bArr = new byte[(integerToBytes.length + 1)];
                bArr[0] = b;
                System.arraycopy(integerToBytes, 0, bArr, 1, integerToBytes.length);
                return bArr;
            }
            byte[] integerToBytes2 = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
            byte[] integerToBytes3 = ECPoint.converter.integerToBytes(getY().toBigInteger(), byteLength);
            byte[] bArr2 = new byte[(integerToBytes2.length + integerToBytes3.length + 1)];
            bArr2[0] = 4;
            System.arraycopy(integerToBytes2, 0, bArr2, 1, integerToBytes2.length);
            System.arraycopy(integerToBytes3, 0, bArr2, integerToBytes2.length + 1, integerToBytes3.length);
            return bArr2;
        }

        public ECPoint add(ECPoint eCPoint) {
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            if (!this.f6290x.equals(eCPoint.f6290x)) {
                ECFieldElement divide = eCPoint.f6291y.subtract(this.f6291y).divide(eCPoint.f6290x.subtract(this.f6290x));
                ECFieldElement subtract = divide.square().subtract(this.f6290x).subtract(eCPoint.f6290x);
                return new C5030Fp(this.curve, subtract, divide.multiply(this.f6290x.subtract(subtract)).subtract(this.f6291y));
            } else if (this.f6291y.equals(eCPoint.f6291y)) {
                return twice();
            } else {
                return this.curve.getInfinity();
            }
        }

        public ECPoint twice() {
            if (isInfinity()) {
                return this;
            }
            if (this.f6291y.toBigInteger().signum() == 0) {
                return this.curve.getInfinity();
            }
            ECFieldElement fromBigInteger = this.curve.fromBigInteger(BigInteger.valueOf(2));
            ECFieldElement divide = this.f6290x.square().multiply(this.curve.fromBigInteger(BigInteger.valueOf(3))).add(this.curve.f6271a).divide(this.f6291y.multiply(fromBigInteger));
            ECFieldElement subtract = divide.square().subtract(this.f6290x.multiply(fromBigInteger));
            return new C5030Fp(this.curve, subtract, divide.multiply(this.f6290x.subtract(subtract)).subtract(this.f6291y), this.withCompression);
        }

        public ECPoint subtract(ECPoint eCPoint) {
            if (eCPoint.isInfinity()) {
                return this;
            }
            return add(eCPoint.negate());
        }

        public ECPoint negate() {
            return new C5030Fp(this.curve, this.f6290x, this.f6291y.negate(), this.withCompression);
        }

        /* access modifiers changed from: package-private */
        public synchronized void assertECMultiplier() {
            if (this.multiplier == null) {
                this.multiplier = new WNafMultiplier();
            }
        }
    }

    /* renamed from: repack.org.bouncycastle.math.ec.ECPoint$F2m */
    public static class F2m extends ECPoint {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null || eCFieldElement2 != null) && (eCFieldElement != null || eCFieldElement2 == null)) {
                if (eCFieldElement != null) {
                    ECFieldElement.F2m.checkFieldElements(this.f6290x, this.f6291y);
                    if (eCCurve != null) {
                        ECFieldElement.F2m.checkFieldElements(this.f6290x, this.curve.getA());
                    }
                }
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        public byte[] getEncoded() {
            if (isInfinity()) {
                return new byte[1];
            }
            int byteLength = ECPoint.converter.getByteLength(this.f6290x);
            byte[] integerToBytes = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
            if (this.withCompression) {
                byte[] bArr = new byte[(byteLength + 1)];
                bArr[0] = 2;
                if (!getX().toBigInteger().equals(ECConstants.ZERO) && getY().multiply(getX().invert()).toBigInteger().testBit(0)) {
                    bArr[0] = 3;
                }
                System.arraycopy(integerToBytes, 0, bArr, 1, byteLength);
                return bArr;
            }
            byte[] integerToBytes2 = ECPoint.converter.integerToBytes(getY().toBigInteger(), byteLength);
            byte[] bArr2 = new byte[(byteLength + byteLength + 1)];
            bArr2[0] = 4;
            System.arraycopy(integerToBytes, 0, bArr2, 1, byteLength);
            System.arraycopy(integerToBytes2, 0, bArr2, byteLength + 1, byteLength);
            return bArr2;
        }

        private static void checkPoints(ECPoint eCPoint, ECPoint eCPoint2) {
            if (!eCPoint.curve.equals(eCPoint2.curve)) {
                throw new IllegalArgumentException("Only points on the same curve can be added or subtracted");
            }
        }

        public ECPoint add(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return addSimple((F2m) eCPoint);
        }

        public F2m addSimple(F2m f2m) {
            if (isInfinity()) {
                return f2m;
            }
            if (f2m.isInfinity()) {
                return this;
            }
            ECFieldElement.F2m f2m2 = (ECFieldElement.F2m) f2m.getX();
            ECFieldElement.F2m f2m3 = (ECFieldElement.F2m) f2m.getY();
            if (!this.f6290x.equals(f2m2)) {
                ECFieldElement.F2m f2m4 = (ECFieldElement.F2m) this.f6291y.add(f2m3).divide(this.f6290x.add(f2m2));
                ECFieldElement.F2m f2m5 = (ECFieldElement.F2m) f2m4.square().add(f2m4).add(this.f6290x).add(f2m2).add(this.curve.getA());
                return new F2m(this.curve, f2m5, (ECFieldElement.F2m) f2m4.multiply(this.f6290x.add(f2m5)).add(f2m5).add(this.f6291y), this.withCompression);
            } else if (this.f6291y.equals(f2m3)) {
                return (F2m) twice();
            } else {
                return (F2m) this.curve.getInfinity();
            }
        }

        public ECPoint subtract(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return subtractSimple((F2m) eCPoint);
        }

        public F2m subtractSimple(F2m f2m) {
            if (f2m.isInfinity()) {
                return this;
            }
            return addSimple((F2m) f2m.negate());
        }

        public ECPoint twice() {
            if (isInfinity()) {
                return this;
            }
            if (this.f6290x.toBigInteger().signum() == 0) {
                return this.curve.getInfinity();
            }
            ECFieldElement.F2m f2m = (ECFieldElement.F2m) this.f6290x.add(this.f6291y.divide(this.f6290x));
            ECFieldElement.F2m f2m2 = (ECFieldElement.F2m) f2m.square().add(f2m).add(this.curve.getA());
            ECFieldElement fromBigInteger = this.curve.fromBigInteger(ECConstants.ONE);
            return new F2m(this.curve, f2m2, (ECFieldElement.F2m) this.f6290x.square().add(f2m2.multiply(f2m.add(fromBigInteger))), this.withCompression);
        }

        public ECPoint negate() {
            return new F2m(this.curve, getX(), getY().add(getX()), this.withCompression);
        }

        /* access modifiers changed from: package-private */
        public synchronized void assertECMultiplier() {
            if (this.multiplier == null) {
                if (((ECCurve.F2m) this.curve).isKoblitz()) {
                    this.multiplier = new WTauNafMultiplier();
                } else {
                    this.multiplier = new WNafMultiplier();
                }
            }
        }
    }
}
