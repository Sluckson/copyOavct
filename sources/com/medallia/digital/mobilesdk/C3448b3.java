package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.b3 */
class C3448b3 extends C3603l1<Long> {

    /* renamed from: h */
    protected static final String f928h = "com.medallia.digital.mobilesdk.LastSubmitTimestampCollectorFilter";

    /* renamed from: i */
    protected static final String f929i = "com.medallia.digital.mobilesdk.LastSubmitTimestampCollector";

    /* renamed from: g */
    private BroadcastReceiver f930g = new C3449a();

    /* renamed from: com.medallia.digital.mobilesdk.b3$a */
    class C3449a extends BroadcastReceiver {
        C3449a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra(C3448b3.f929i)) {
                C3448b3.this.mo55525a(Long.valueOf(intent.getLongExtra(C3448b3.f929i, 0)));
                C3490e3.m661b(String.format(Locale.US, "Collectors > Last submit timestamp : %d", new Object[]{C3448b3.this.mo55504f()}));
            }
        }
    }

    protected C3448b3(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1730F;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(this.f930g, new IntentFilter(f928h));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(this.f930g);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
