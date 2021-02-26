package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import com.medallia.digital.mobilesdk.C3815z4;
import java.util.Locale;
import java.util.UUID;

/* renamed from: com.medallia.digital.mobilesdk.d1 */
class C3479d1 extends C3493e4<String> {
    protected C3479d1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m625o() {
        C3815z4 j = this.f1041g.mo55609j();
        if (j == null) {
            C3490e3.m663c("Storage is null");
            return null;
        }
        String a = j.mo55975a(C3815z4.C3816a.DEVICE_ID, (String) null);
        if (a != null) {
            return a;
        }
        String uuid = UUID.randomUUID().toString();
        j.mo55984b(C3815z4.C3816a.DEVICE_ID, uuid);
        return uuid;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1764r;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m628j() {
        String o = m625o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Device id : %s", new Object[]{o}));
        return o;
    }
}
