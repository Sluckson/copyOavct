package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.y4 */
class C3800y4 extends C3603l1<Integer> {

    /* renamed from: g */
    private BroadcastReceiver f2063g = new C3801a();

    /* renamed from: com.medallia.digital.mobilesdk.y4$a */
    class C3801a extends BroadcastReceiver {
        C3801a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra("com.medallia.digital.mobilesdk.SESSION_NUMBER_VALUE")) {
                C3800y4.this.mo55525a(Integer.valueOf(intent.getIntExtra("com.medallia.digital.mobilesdk.SESSION_NUMBER_VALUE", 0)));
                C3490e3.m661b(String.format(Locale.US, "New session created, number : %d", new Object[]{C3800y4.this.mo55504f()}));
            }
        }
    }

    protected C3800y4(C3612m0 m0Var) {
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
        C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(this.f2063g, new IntentFilter("com.medallia.digital.mobilesdk.SESSION_STARTED"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(this.f2063g);
        } catch (IllegalArgumentException e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
