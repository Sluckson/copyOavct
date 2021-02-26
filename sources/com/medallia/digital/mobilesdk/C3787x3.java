package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.x3 */
public class C3787x3 extends C3603l1<Integer> {

    /* renamed from: h */
    static final String f2038h = "com.medallia.digital.mobilesdk.NPSCollector";

    /* renamed from: i */
    static final String f2039i = "com.medallia.digital.mobilesdk.NPSCollectorFilter";

    /* renamed from: g */
    private BroadcastReceiver f2040g = new C3788a();

    /* renamed from: com.medallia.digital.mobilesdk.x3$a */
    class C3788a extends BroadcastReceiver {
        C3788a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra(C3787x3.f2038h)) {
                C3787x3.this.mo55525a(Integer.valueOf(intent.getIntExtra(C3787x3.f2038h, -1)));
                C3490e3.m661b(String.format(Locale.US, "Collectors > NPS : %S", new Object[]{C3787x3.this.mo55504f()}));
            }
        }
    }

    protected C3787x3(C3612m0 m0Var) {
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
        return C3697r0.C3698a.f1740P;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(this.f2040g, new IntentFilter(f2039i));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(this.f2040g);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
