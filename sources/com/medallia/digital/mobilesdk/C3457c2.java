package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3433a2;
import com.medallia.digital.mobilesdk.C3649n4;
import com.medallia.digital.mobilesdk.C3792y;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.medallia.digital.mobilesdk.c2 */
class C3457c2 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3433a2 f941a;

    /* renamed from: b */
    private C3519f2 f942b;

    /* renamed from: c */
    protected boolean f943c;

    /* renamed from: d */
    protected ArrayList<ResourceContract> f944d = new ArrayList<>();

    /* renamed from: e */
    private long f945e;

    /* renamed from: com.medallia.digital.mobilesdk.c2$a */
    class C3458a implements C3660o4<C3525f5> {
        C3458a() {
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55257a(C3525f5 f5Var) {
            C3457c2 c2Var = C3457c2.this;
            c2Var.f943c = false;
            c2Var.f941a.mo55185a(f5Var.mo55378a());
            C3457c2 c2Var2 = C3457c2.this;
            c2Var2.m533a(c2Var2.f941a);
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3457c2 c2Var = C3457c2.this;
            c2Var.f943c = false;
            c2Var.m533a(c2Var.f941a);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.c2$b */
    class C3459b implements C3660o4<File> {

        /* renamed from: a */
        final /* synthetic */ C3660o4 f947a;

        C3459b(C3660o4 o4Var) {
            this.f947a = o4Var;
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3490e3.m661b(C3457c2.this.f941a.mo55190d() + " download failed");
            C3457c2.this.f941a.mo55184a(C3433a2.C3434a.FAILED);
            this.f947a.mo55256a(j3Var);
        }

        /* renamed from: a */
        public void mo55257a(File file) {
            if (file != null) {
                C3490e3.m661b(C3457c2.this.f941a.mo55190d() + " downloaded download complete");
                C3525f5 f5Var = new C3525f5(file.getAbsolutePath(), C3457c2.this.f941a.mo55190d());
                C3782x0.m1872d().mo55912b((C3792y) f5Var);
                this.f947a.mo55257a(f5Var);
                return;
            }
            C3490e3.m661b(C3457c2.this.f941a.mo55190d() + " download failed");
            C3457c2.this.f941a.mo55184a(C3433a2.C3434a.FAILED);
            this.f947a.mo55256a((C3586j3) null);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.c2$c */
    class C3460c implements C3649n4.C3651b {
        C3460c() {
        }

        /* renamed from: a */
        public void mo55259a(ResourceContract resourceContract) {
            C3457c2.this.f944d.remove(resourceContract);
            int i = 0;
            while (true) {
                if (i >= C3457c2.this.f941a.mo55187b().size()) {
                    break;
                } else if (C3457c2.this.f941a.mo55187b().get(i).getRemoteUrl().equals(resourceContract.getRemoteUrl())) {
                    C3457c2.this.f941a.mo55187b().set(i, resourceContract);
                    break;
                } else {
                    i++;
                }
            }
            C3457c2 c2Var = C3457c2.this;
            c2Var.m533a(c2Var.f941a);
        }

        /* renamed from: b */
        public void mo55260b(ResourceContract resourceContract) {
            C3457c2.this.f944d.remove(resourceContract);
            C3457c2.this.f941a.mo55184a(C3433a2.C3434a.FAILED);
            C3457c2 c2Var = C3457c2.this;
            c2Var.m533a(c2Var.f941a);
        }
    }

    protected C3457c2(C3433a2 a2Var, C3519f2 f2Var) {
        this.f941a = a2Var;
        this.f942b = f2Var;
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    /* renamed from: a */
    public void m533a(C3433a2 a2Var) {
        if (!mo55253c()) {
            if (a2Var.mo55182a() != C3433a2.C3434a.FAILED) {
                a2Var.mo55184a(C3433a2.C3434a.AVAILABLE);
            }
            C3782x0.m1872d().mo55915c((C3792y) a2Var);
            C3519f2 f2Var = this.f942b;
            if (f2Var != null) {
                f2Var.mo55375a(a2Var);
            }
            C3490e3.m661b("Form: " + a2Var.getFormId() + " was preloaded");
            AnalyticsBridge.getInstance().reportPreloadMechanismEvent(this.f945e, System.currentTimeMillis(), a2Var.getFormId(), a2Var.mo55182a());
        }
    }

    /* renamed from: d */
    private void m535d() {
        this.f945e = System.currentTimeMillis();
        if (this.f941a.mo55182a() == C3433a2.C3434a.AVAILABLE) {
            C3519f2 f2Var = this.f942b;
            if (f2Var != null) {
                f2Var.mo55375a(this.f941a);
                return;
            }
            return;
        }
        this.f941a.mo55184a(C3433a2.C3434a.IN_PROGRESS);
        boolean z = true;
        C3525f5 f5Var = (C3525f5) C3782x0.m1872d().mo55911b(C3792y.C3793a.Template, this.f941a.mo55190d());
        boolean z2 = f5Var == null || !this.f941a.mo55190d().equals(f5Var.mo55380b()) || !this.f941a.mo55189c().equals(f5Var.mo55378a());
        if (TextUtils.isEmpty(this.f941a.mo55190d()) || !z2) {
            z = false;
        }
        this.f943c = z;
        if (mo55252b() || z2) {
            mo55250a((C3660o4<C3525f5>) new C3458a());
        } else {
            m533a(this.f941a);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public C3433a2 mo55248a(SDKConfigurationFormContract sDKConfigurationFormContract) {
        if (sDKConfigurationFormContract == null) {
            return null;
        }
        return (C3433a2) C3782x0.m1872d().mo55911b(C3792y.C3793a.FormData, sDKConfigurationFormContract.getFormId());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55249a() {
        m535d();
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55250a(C3660o4<C3525f5> o4Var) {
        C3525f5 f5Var = (C3525f5) C3782x0.m1872d().mo55911b(C3792y.C3793a.Template, this.f941a.mo55190d());
        if (f5Var != null) {
            o4Var.mo55257a(f5Var);
        } else {
            C3646n3.m1337m().mo55668a(this.f941a.mo55190d(), this.f941a.mo55189c(), new C3459b(o4Var));
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55251a(List<ResourceContract> list) {
        new C3649n4(list, new C3460c());
    }

    @VisibleForTesting
    /* renamed from: b */
    public boolean mo55252b() {
        if (this.f941a.mo55187b() == null || this.f941a.mo55187b().size() == 0) {
            return false;
        }
        for (ResourceContract next : this.f941a.mo55187b()) {
            next.setFormId(this.f941a.getFormId());
            this.f944d.add(next);
        }
        if (this.f944d.size() == 0) {
            return true;
        }
        mo55251a((List<ResourceContract>) this.f944d);
        return true;
    }

    @VisibleForTesting
    /* renamed from: c */
    public boolean mo55253c() {
        return this.f943c || this.f944d.size() > 0;
    }
}
