package com.medallia.digital.mobilesdk;

import android.graphics.Point;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.g1 */
class C3538g1 extends C3493e4<String> {
    protected C3538g1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m848o() {
        Point e = this.f1041g.mo55604e();
        if (e == null) {
            e = new Point();
        }
        return String.format(Locale.US, "%d*%d", new Object[]{Integer.valueOf(e.x), Integer.valueOf(e.y)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1750d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m851j() {
        String o = m848o();
        C3490e3.m661b(String.format("Collectors > Resolution: %s", new Object[]{o}));
        return o;
    }
}
