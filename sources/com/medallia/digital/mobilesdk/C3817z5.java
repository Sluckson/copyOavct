package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.os.Build;
import com.medallia.digital.mobilesdk.C3706r3;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.z5 */
class C3817z5 {

    /* renamed from: e */
    private static C3817z5 f2128e;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3706r3.C3711e f2129a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HashMap<C3706r3.C3711e, C3706r3> f2130b = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ConfigurationContract f2131c;

    /* renamed from: d */
    private long f2132d;

    /* renamed from: com.medallia.digital.mobilesdk.z5$a */
    class C3818a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ C3706r3.C3711e f2133a;

        /* renamed from: b */
        final /* synthetic */ C3433a2 f2134b;

        /* renamed from: c */
        final /* synthetic */ C3706r3.C3710d f2135c;

        C3818a(C3706r3.C3711e eVar, C3433a2 a2Var, C3706r3.C3710d dVar) {
            this.f2133a = eVar;
            this.f2134b = a2Var;
            this.f2135c = dVar;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3706r3 r3Var = (C3706r3) C3817z5.this.f2130b.get(this.f2133a);
            if (r3Var == null || this.f2133a != C3706r3.C3711e.preload || r3Var.mo55771a() == null || !r3Var.mo55771a().equals(this.f2134b)) {
                if (r3Var != null) {
                    C3817z5.this.mo55990a(this.f2133a);
                }
                if (C3461c3.m562g().mo55271c()) {
                    C3817z5 z5Var = C3817z5.this;
                    z5Var.mo55990a(z5Var.f2129a);
                }
                C3706r3 a = C3817z5.this.m2025a(this.f2133a, this.f2134b);
                a.mo55772a(C3817z5.this.f2131c);
                C3817z5.this.f2130b.put(this.f2133a, a);
                a.mo55773a(this.f2135c);
            }
        }
    }

    private C3817z5() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C3706r3 m2025a(C3706r3.C3711e eVar, C3433a2 a2Var) {
        this.f2129a = eVar;
        MutableContextWrapper c = C3595k3.m1060d().mo55514c();
        long j = 1 + this.f2132d;
        this.f2132d = j;
        C3706r3 r3Var = new C3706r3(c, eVar, a2Var, j);
        r3Var.loadUrl("about:blank");
        return r3Var;
    }

    /* renamed from: b */
    protected static C3817z5 m2029b() {
        if (f2128e == null) {
            f2128e = new C3817z5();
        }
        return f2128e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HashMap<C3706r3.C3711e, C3706r3> mo55987a() {
        return this.f2130b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55988a(ConfigurationContract configurationContract) {
        this.f2131c = configurationContract;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55989a(C3433a2 a2Var, C3706r3.C3710d dVar, C3706r3.C3711e eVar) {
        try {
            ((Activity) C3595k3.m1060d().mo55514c().getBaseContext()).runOnUiThread(new C3818a(eVar, a2Var, dVar));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55990a(C3706r3.C3711e eVar) {
        HashMap<C3706r3.C3711e, C3706r3> hashMap = this.f2130b;
        if (hashMap != null && eVar != C3706r3.C3711e.preload) {
            mo55991a(hashMap.get(eVar));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55991a(C3706r3 r3Var) {
        C3706r3 r3Var2;
        if (r3Var != null && !r3Var.mo55780h() && (r3Var2 = this.f2130b.get(r3Var.mo55779g())) != null && r3Var2.mo55778f() == r3Var.mo55778f()) {
            r3Var2.removeJavascriptInterface("NebulaAndroid");
            r3Var2.loadUrl("about:blank");
            r3Var2.stopLoading();
            if (Build.VERSION.SDK_INT < 19) {
                r3Var2.freeMemory();
            }
            r3Var2.clearHistory();
            r3Var2.removeAllViews();
            r3Var2.destroyDrawingCache();
            r3Var2.destroy();
            this.f2130b.remove(r3Var.mo55779g());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3706r3 mo55992b(C3706r3.C3711e eVar) {
        return this.f2130b.get(eVar);
    }
}
