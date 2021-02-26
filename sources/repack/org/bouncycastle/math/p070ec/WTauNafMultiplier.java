package repack.org.bouncycastle.math.p070ec;

import java.math.BigInteger;
import repack.org.bouncycastle.math.p070ec.ECCurve;
import repack.org.bouncycastle.math.p070ec.ECPoint;

/* renamed from: repack.org.bouncycastle.math.ec.WTauNafMultiplier */
class WTauNafMultiplier implements ECMultiplier {
    WTauNafMultiplier() {
    }

    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        if (eCPoint instanceof ECPoint.F2m) {
            ECPoint.F2m f2m = (ECPoint.F2m) eCPoint;
            ECCurve.F2m f2m2 = (ECCurve.F2m) f2m.getCurve();
            int m = f2m2.getM();
            byte byteValue = f2m2.getA().toBigInteger().byteValue();
            byte mu = f2m2.getMu();
            byte b = byteValue;
            return multiplyWTnaf(f2m, Tnaf.partModReduction(bigInteger, m, b, f2m2.getSi(), mu, (byte) 10), preCompInfo, b, mu);
        }
        throw new IllegalArgumentException("Only ECPoint.F2m can be used in WTauNafMultiplier");
    }

    private ECPoint.F2m multiplyWTnaf(ECPoint.F2m f2m, ZTauElement zTauElement, PreCompInfo preCompInfo, byte b, byte b2) {
        ZTauElement[] zTauElementArr;
        if (b == 0) {
            zTauElementArr = Tnaf.alpha0;
        } else {
            zTauElementArr = Tnaf.alpha1;
        }
        BigInteger tw = Tnaf.getTw(b2, 4);
        return multiplyFromWTnaf(f2m, Tnaf.tauAdicWNaf(b2, zTauElement, (byte) 4, BigInteger.valueOf(16), tw, zTauElementArr), preCompInfo);
    }

    private static ECPoint.F2m multiplyFromWTnaf(ECPoint.F2m f2m, byte[] bArr, PreCompInfo preCompInfo) {
        ECPoint.F2m[] f2mArr;
        byte byteValue = ((ECCurve.F2m) f2m.getCurve()).getA().toBigInteger().byteValue();
        if (preCompInfo == null || !(preCompInfo instanceof WTauNafPreCompInfo)) {
            f2mArr = Tnaf.getPreComp(f2m, byteValue);
            f2m.setPreCompInfo(new WTauNafPreCompInfo(f2mArr));
        } else {
            f2mArr = ((WTauNafPreCompInfo) preCompInfo).getPreComp();
        }
        ECPoint.F2m f2m2 = (ECPoint.F2m) f2m.getCurve().getInfinity();
        for (int length = bArr.length - 1; length >= 0; length--) {
            f2m2 = Tnaf.tau(f2m2);
            if (bArr[length] != 0) {
                if (bArr[length] > 0) {
                    f2m2 = f2m2.addSimple(f2mArr[bArr[length]]);
                } else {
                    f2m2 = f2m2.subtractSimple(f2mArr[-bArr[length]]);
                }
            }
        }
        return f2m2;
    }
}
