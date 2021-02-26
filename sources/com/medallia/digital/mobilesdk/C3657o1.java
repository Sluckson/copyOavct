package com.medallia.digital.mobilesdk;

import android.os.Build;
import android.os.StatFs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.o1 */
class C3657o1 extends C3493e4<String> {
    protected C3657o1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private double m1379o() {
        if (C3488e1.m654a()) {
            StatFs f = this.f1041g.mo55605f();
            return Build.VERSION.SDK_INT >= 18 ? (double) (f.getFreeBlocksLong() * f.getBlockSizeLong()) : (double) (f.getAvailableBlocks() * f.getBlockSize());
        }
        C3490e3.m663c("External memory is not available");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1755i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1382j() {
        double o = m1379o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > External drive fee space: %.2f%%", new Object[]{Double.valueOf(o)}));
        return C3488e1.m655b(o);
    }
}
