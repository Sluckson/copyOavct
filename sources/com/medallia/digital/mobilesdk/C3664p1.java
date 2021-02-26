package com.medallia.digital.mobilesdk;

import android.os.Build;
import android.os.StatFs;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.p1 */
class C3664p1 extends C3493e4<Long> {
    protected C3664p1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private long m1415o() {
        long j;
        long j2;
        if (C3488e1.m654a()) {
            StatFs f = this.f1041g.mo55605f();
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = f.getBlockCountLong() * f.getBlockSizeLong();
                j = f.getAvailableBlocksLong() * f.getBlockSizeLong();
            } else {
                j2 = (long) (f.getBlockCount() * f.getBlockSize());
                j = (long) (f.getAvailableBlocks() * f.getBlockSize());
            }
            return C3488e1.m653a((double) (j2 - j));
        }
        C3490e3.m663c("External memory is not available");
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1754h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Long m1418j() {
        long o = m1415o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > External drive user space: %d", new Object[]{Long.valueOf(o)}));
        return Long.valueOf(o);
    }
}
