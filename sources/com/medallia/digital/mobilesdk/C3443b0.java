package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* renamed from: com.medallia.digital.mobilesdk.b0 */
abstract class C3443b0 {
    C3443b0() {
    }

    /* renamed from: a */
    private void m485a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        mo55230e();
        C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55540a(broadcastReceiver, intentFilter);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo55225a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo55226a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Object mo55227b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract BroadcastReceiver mo55228c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo55229d() {
        if (C3595k3.m1060d().mo55513b() != null) {
            m485a(mo55228c(), new IntentFilter(mo55225a()));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo55230e() {
        try {
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55539a(mo55228c());
        } catch (Exception e) {
            C3490e3.m666f(e.getMessage());
        }
    }
}
