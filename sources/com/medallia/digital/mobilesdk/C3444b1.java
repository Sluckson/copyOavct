package com.medallia.digital.mobilesdk;

import android.os.Build;
import android.os.StatFs;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.b1 */
class C3444b1 extends C3493e4<String> {
    protected C3444b1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private double m492o() {
        StatFs d = this.f1041g.mo55603d();
        return Build.VERSION.SDK_INT >= 18 ? (double) (d.getFreeBlocksLong() * d.getBlockSizeLong()) : (double) (d.getAvailableBlocks() * d.getBlockSize());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1747a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m495j() {
        double o = m492o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Device free memory: %f", new Object[]{Double.valueOf(o)}));
        return C3488e1.m655b(o);
    }
}
