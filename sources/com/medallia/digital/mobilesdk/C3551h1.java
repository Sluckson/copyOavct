package com.medallia.digital.mobilesdk;

import android.os.Build;
import android.os.StatFs;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.h1 */
class C3551h1 extends C3493e4<Long> {

    /* renamed from: k */
    private static final int f1237k = 100;

    protected C3551h1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private long m897o() {
        long j;
        long j2;
        StatFs d = this.f1041g.mo55603d();
        if (d != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = d.getBlockCountLong() * d.getBlockSizeLong();
                j = d.getAvailableBlocksLong() * d.getBlockSizeLong();
            } else {
                j2 = (long) (d.getBlockCount() * d.getBlockSize());
                j = (long) (d.getAvailableBlocks() * d.getBlockSize());
            }
            long j3 = j2 - j;
            if (j3 != 0) {
                return (long) ((((double) j3) / ((double) j2)) * 100.0d);
            }
        }
        C3490e3.m663c("StatFs is null");
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1751e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Long m900j() {
        long o = m897o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Device free memory: %d", new Object[]{Long.valueOf(o)}));
        return Long.valueOf(o);
    }
}
