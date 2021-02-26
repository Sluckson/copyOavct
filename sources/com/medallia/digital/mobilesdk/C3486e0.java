package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.e0 */
class C3486e0 extends C3603l1<Integer> {

    /* renamed from: g */
    private BroadcastReceiver f1030g = new C3487a();

    /* renamed from: com.medallia.digital.mobilesdk.e0$a */
    class C3487a extends BroadcastReceiver {
        C3487a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra(FirebaseAnalytics.Param.LEVEL)) {
                C3486e0.this.mo55525a(Integer.valueOf(intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0)));
                C3490e3.m661b(String.format(Locale.US, "Collectors > Battery percentage : %d", new Object[]{C3486e0.this.mo55504f()}));
            }
        }
    }

    protected C3486e0(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1727C;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Integer m649j() {
        return (Integer) mo55504f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        C3595k3.m1060d().mo55513b().registerReceiver(this.f1030g, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3595k3.m1060d().mo55513b().unregisterReceiver(this.f1030g);
        } catch (IllegalArgumentException e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
