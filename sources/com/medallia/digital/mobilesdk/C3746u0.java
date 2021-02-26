package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.u0 */
public class C3746u0 extends C3603l1<Integer> {

    /* renamed from: h */
    static final String f1911h = "com.medallia.digital.mobilesdk.CSATCollector";

    /* renamed from: i */
    static final String f1912i = "com.medallia.digital.mobilesdk.CSATCollectorFilter";

    /* renamed from: g */
    private BroadcastReceiver f1913g = new C3747a();

    /* renamed from: com.medallia.digital.mobilesdk.u0$a */
    class C3747a extends BroadcastReceiver {
        C3747a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra(C3746u0.f1911h)) {
                C3746u0.this.mo55525a(Integer.valueOf(intent.getIntExtra(C3746u0.f1911h, -1)));
                C3490e3.m661b(String.format(Locale.US, "Collectors > CSAT : %S", new Object[]{C3746u0.this.mo55504f()}));
            }
        }
    }

    protected C3746u0(C3612m0 m0Var) {
        super(m0Var);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo55532a(C3643n0 n0Var) {
        super.mo55532a(n0Var);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ String mo55526b() {
        return super.mo55526b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1741Q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(this.f1913g, new IntentFilter(f1912i));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(this.f1913g);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
