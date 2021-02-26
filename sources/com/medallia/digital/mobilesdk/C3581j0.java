package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3646n3;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.j0 */
abstract class C3581j0<T> {

    /* renamed from: a */
    protected C3667p4 f1313a;

    /* renamed from: b */
    protected C3592k0 f1314b;

    /* renamed from: c */
    protected C3672q f1315c;

    /* renamed from: d */
    protected C3660o4<T> f1316d;

    /* renamed from: e */
    private boolean f1317e = true;

    /* renamed from: f */
    private int f1318f;

    /* renamed from: com.medallia.digital.mobilesdk.j0$a */
    class C3582a implements C3660o4<Void> {
        C3582a() {
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3581j0.this.f1316d.mo55256a(j3Var);
        }

        /* renamed from: a */
        public void mo55257a(Void voidR) {
            C3581j0.this.mo55238b();
        }
    }

    C3581j0(C3667p4 p4Var, C3592k0 k0Var, C3660o4<T> o4Var) {
        this.f1313a = p4Var;
        this.f1314b = k0Var == null ? new C3592k0() : k0Var;
        this.f1315c = new C3672q(p4Var);
        this.f1316d = o4Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C3586j3 mo55237a(C3588j4 j4Var);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HashMap<String, String> mo55493a(C3646n3.C3648b bVar) {
        return this.f1315c.mo55706a(bVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55494a() {
        this.f1315c.mo55707a((C3660o4<Void>) new C3582a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55495a(boolean z) {
        this.f1317e = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo55238b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55496b(C3588j4 j4Var) {
        int i;
        if (j4Var.mo55503b() != 401 || (i = this.f1318f) >= 2) {
            C3660o4<T> o4Var = this.f1316d;
            if (o4Var != null) {
                o4Var.mo55256a(mo55237a(j4Var));
                return;
            }
            return;
        }
        this.f1318f = i + 1;
        mo55494a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo55497c() {
        if (!this.f1317e) {
            mo55238b();
        } else {
            mo55494a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract C3586j3 mo55239d();
}
