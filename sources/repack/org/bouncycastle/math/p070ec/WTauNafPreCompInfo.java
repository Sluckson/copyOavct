package repack.org.bouncycastle.math.p070ec;

import repack.org.bouncycastle.math.p070ec.ECPoint;

/* renamed from: repack.org.bouncycastle.math.ec.WTauNafPreCompInfo */
class WTauNafPreCompInfo implements PreCompInfo {
    private ECPoint.F2m[] preComp = null;

    WTauNafPreCompInfo(ECPoint.F2m[] f2mArr) {
        this.preComp = f2mArr;
    }

    /* access modifiers changed from: protected */
    public ECPoint.F2m[] getPreComp() {
        return this.preComp;
    }
}
