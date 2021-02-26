package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.o */
class C3654o extends C3603l1<Long> {

    /* renamed from: h */
    protected static final String f1593h = "com.medallia.digital.mobilesdk.AppRatingLastDeclineTimestampCollectorFilter";

    /* renamed from: i */
    protected static final String f1594i = "com.medallia.digital.mobilesdk.AppRatingLastDeclineTimestampCollector";

    /* renamed from: g */
    private BroadcastReceiver f1595g = new C3655a();

    /* renamed from: com.medallia.digital.mobilesdk.o$a */
    class C3655a extends BroadcastReceiver {
        C3655a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra(C3654o.f1594i)) {
                C3654o.this.mo55525a(Long.valueOf(intent.getLongExtra(C3654o.f1594i, 0)));
                C3490e3.m661b(String.format(Locale.US, "Collectors > App Rating Last decline timestamp : %d", new Object[]{C3654o.this.mo55504f()}));
            }
        }
    }

    protected C3654o(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1742R;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(this.f1595g, new IntentFilter(f1593h));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(this.f1595g);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
