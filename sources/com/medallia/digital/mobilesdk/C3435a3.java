package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.a3 */
class C3435a3 extends C3603l1<Long> {

    /* renamed from: h */
    protected static final String f899h = "com.medallia.digital.mobilesdk.LastDeclineTimestampCollectorFilter";

    /* renamed from: i */
    protected static final String f900i = "com.medallia.digital.mobilesdk.LastDeclineTimestampCollector";

    /* renamed from: g */
    private BroadcastReceiver f901g = new C3436a();

    /* renamed from: com.medallia.digital.mobilesdk.a3$a */
    class C3436a extends BroadcastReceiver {
        C3436a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra(C3435a3.f900i)) {
                C3435a3.this.mo55525a(Long.valueOf(intent.getLongExtra(C3435a3.f900i, 0)));
                C3490e3.m661b(String.format(Locale.US, "Collectors > Last decline timestamp : %d", new Object[]{C3435a3.this.mo55504f()}));
            }
        }
    }

    protected C3435a3(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1729E;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(this.f901g, new IntentFilter(f899h));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(this.f901g);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
