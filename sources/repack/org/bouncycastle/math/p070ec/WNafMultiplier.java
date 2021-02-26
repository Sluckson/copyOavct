package repack.org.bouncycastle.math.p070ec;

import java.math.BigInteger;

/* renamed from: repack.org.bouncycastle.math.ec.WNafMultiplier */
class WNafMultiplier implements ECMultiplier {
    WNafMultiplier() {
    }

    public byte[] windowNaf(byte b, BigInteger bigInteger) {
        byte[] bArr = new byte[(bigInteger.bitLength() + 1)];
        short s = (short) (1 << b);
        BigInteger valueOf = BigInteger.valueOf((long) s);
        int i = 0;
        int i2 = 0;
        while (bigInteger.signum() > 0) {
            if (bigInteger.testBit(0)) {
                BigInteger mod = bigInteger.mod(valueOf);
                if (mod.testBit(b - 1)) {
                    bArr[i2] = (byte) (mod.intValue() - s);
                } else {
                    bArr[i2] = (byte) mod.intValue();
                }
                bigInteger = bigInteger.subtract(BigInteger.valueOf((long) bArr[i2]));
                i = i2;
            } else {
                bArr[i2] = 0;
            }
            bigInteger = bigInteger.shiftRight(1);
            i2++;
        }
        int i3 = i + 1;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }

    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        WNafPreCompInfo wNafPreCompInfo;
        int i;
        int i2;
        if (preCompInfo == null || !(preCompInfo instanceof WNafPreCompInfo)) {
            wNafPreCompInfo = new WNafPreCompInfo();
        } else {
            wNafPreCompInfo = (WNafPreCompInfo) preCompInfo;
        }
        int bitLength = bigInteger.bitLength();
        byte b = 8;
        if (bitLength < 13) {
            i = 1;
            b = 2;
        } else if (bitLength < 41) {
            b = 3;
            i = 2;
        } else if (bitLength < 121) {
            i = 4;
            b = 4;
        } else if (bitLength < 337) {
            i = 8;
            b = 5;
        } else if (bitLength < 897) {
            b = 6;
            i = 16;
        } else if (bitLength < 2305) {
            b = 7;
            i = 32;
        } else {
            i = 127;
        }
        ECPoint[] preComp = wNafPreCompInfo.getPreComp();
        ECPoint twiceP = wNafPreCompInfo.getTwiceP();
        if (preComp == null) {
            preComp = new ECPoint[]{eCPoint};
            i2 = 1;
        } else {
            i2 = preComp.length;
        }
        if (twiceP == null) {
            twiceP = eCPoint.twice();
        }
        if (i2 < i) {
            ECPoint[] eCPointArr = new ECPoint[i];
            System.arraycopy(preComp, 0, eCPointArr, 0, i2);
            while (i2 < i) {
                eCPointArr[i2] = twiceP.add(eCPointArr[i2 - 1]);
                i2++;
            }
            preComp = eCPointArr;
        }
        byte[] windowNaf = windowNaf(b, bigInteger);
        int length = windowNaf.length;
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        for (int i3 = length - 1; i3 >= 0; i3--) {
            infinity = infinity.twice();
            if (windowNaf[i3] != 0) {
                if (windowNaf[i3] > 0) {
                    infinity = infinity.add(preComp[(windowNaf[i3] - 1) / 2]);
                } else {
                    infinity = infinity.subtract(preComp[((-windowNaf[i3]) - 1) / 2]);
                }
            }
        }
        wNafPreCompInfo.setPreComp(preComp);
        wNafPreCompInfo.setTwiceP(twiceP);
        eCPoint.setPreCompInfo(wNafPreCompInfo);
        return infinity;
    }
}
