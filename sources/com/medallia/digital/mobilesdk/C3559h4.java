package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.h4 */
class C3559h4 extends C3603l1<Long> {

    /* renamed from: g */
    private BroadcastReceiver f1266g = new C3560a();

    /* renamed from: com.medallia.digital.mobilesdk.h4$a */
    class C3560a extends BroadcastReceiver {
        C3560a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra("com.medallia.digital.mobilesdk.PROPERTY_ID_VALUE")) {
                C3559h4.this.mo55525a(Long.valueOf(intent.getLongExtra("com.medallia.digital.mobilesdk.PROPERTY_ID_VALUE", 0)));
                C3490e3.m661b(String.format(Locale.US, "New propertyId created : %d", new Object[]{C3559h4.this.mo55504f()}));
            }
        }
    }

    protected C3559h4(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1770x;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(this.f1266g, new IntentFilter("com.medallia.digital.mobilesdk.PROPERTY_ID_CHANGE"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(this.f1266g);
        } catch (IllegalArgumentException e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
