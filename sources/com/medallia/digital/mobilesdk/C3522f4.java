package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.f4 */
class C3522f4 extends C3603l1<String> {

    /* renamed from: g */
    private BroadcastReceiver f1133g = new C3523a();

    /* renamed from: com.medallia.digital.mobilesdk.f4$a */
    class C3523a extends BroadcastReceiver {
        C3523a() {
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("status", -1);
            C3522f4 f4Var = C3522f4.this;
            f4Var.mo55525a(f4Var.m777a(intExtra).toString());
            C3490e3.m661b(String.format(Locale.US, "Collectors > Power type : %s", new Object[]{C3522f4.this.mo55504f()}));
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.f4$b */
    enum C3524b {
        Unplugged,
        Charging,
        Full,
        f1138d
    }

    protected C3522f4(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C3524b m777a(int i) {
        return i == 2 ? C3524b.Charging : i == 5 ? C3524b.Full : (i == 3 || i == 4) ? C3524b.Unplugged : C3524b.f1138d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1725A;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m781j() {
        return (String) mo55504f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            C3595k3.m1060d().mo55513b().registerReceiver(this.f1133g, intentFilter);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3595k3.m1060d().mo55513b().unregisterReceiver(this.f1133g);
        } catch (IllegalArgumentException e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
