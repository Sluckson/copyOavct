package com.medallia.digital.mobilesdk;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;

/* renamed from: com.medallia.digital.mobilesdk.k3 */
class C3595k3 implements C3713r5 {

    /* renamed from: c */
    private static C3595k3 f1376c;

    /* renamed from: a */
    private Application f1377a;

    /* renamed from: b */
    private MutableContextWrapper f1378b;

    C3595k3() {
    }

    /* renamed from: a */
    protected static void m1058a(Application application) {
        m1060d().m1059b(application);
    }

    /* renamed from: b */
    private void m1059b(Application application) {
        if (this.f1377a == null) {
            this.f1377a = application;
            this.f1378b = application == null ? null : new MutableContextWrapper(application.getApplicationContext());
        }
    }

    /* renamed from: d */
    protected static C3595k3 m1060d() {
        if (f1376c == null) {
            f1376c = new C3595k3();
        }
        return f1376c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Application mo55511a() {
        return this.f1377a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55512a(Context context) {
        MutableContextWrapper mutableContextWrapper = this.f1378b;
        if (context == null) {
            Application application = this.f1377a;
            context = application != null ? application.getApplicationContext() : null;
        }
        mutableContextWrapper.setBaseContext(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Context mo55513b() {
        Application application = this.f1377a;
        if (application != null) {
            return application.getApplicationContext();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public MutableContextWrapper mo55514c() {
        return this.f1378b;
    }

    public void clearAndDisconnect() {
        f1376c = null;
        this.f1378b = null;
        this.f1377a = null;
    }
}
