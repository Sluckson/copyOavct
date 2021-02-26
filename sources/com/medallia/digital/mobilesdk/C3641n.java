package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.n */
class C3641n extends C3603l1<Long> {

    /* renamed from: h */
    protected static final String f1509h = "com.medallia.digital.mobilesdk.AppRatingLastAcceptedTimestampCollectorFilter";

    /* renamed from: i */
    protected static final String f1510i = "com.medallia.digital.mobilesdk.AppRatingLastAcceptedTimestampCollector";

    /* renamed from: g */
    private BroadcastReceiver f1511g = new C3642a();

    /* renamed from: com.medallia.digital.mobilesdk.n$a */
    class C3642a extends BroadcastReceiver {
        C3642a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra(C3641n.f1510i)) {
                C3641n.this.mo55525a(Long.valueOf(intent.getLongExtra(C3641n.f1510i, 0)));
                C3490e3.m661b(String.format(Locale.US, "Collectors > App Rating Last accepted timestamp : %d", new Object[]{C3641n.this.mo55504f()}));
            }
        }
    }

    protected C3641n(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1744T;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(this.f1511g, new IntentFilter(f1509h));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(this.f1511g);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
