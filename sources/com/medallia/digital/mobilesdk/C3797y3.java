package com.medallia.digital.mobilesdk;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.y3 */
class C3797y3 extends C3603l1<C3799b> {

    /* renamed from: g */
    private ComponentCallbacks2 f2054g;

    /* renamed from: com.medallia.digital.mobilesdk.y3$a */
    class C3798a implements ComponentCallbacks2 {
        C3798a() {
        }

        public void onConfigurationChanged(Configuration configuration) {
            C3797y3 y3Var;
            C3799b bVar;
            int i = C3595k3.m1060d().mo55513b().getResources().getConfiguration().orientation;
            if (i == 1 || i == 2) {
                y3Var = C3797y3.this;
                bVar = y3Var.m1941n();
            } else {
                y3Var = C3797y3.this;
                bVar = C3799b.f2060f;
            }
            y3Var.mo55525a(bVar);
            C3490e3.m661b(String.format(Locale.US, "Collectors > Orientation : %s", new Object[]{((C3799b) C3797y3.this.mo55504f()).toString()}));
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.y3$b */
    enum C3799b {
        Portrait(0),
        PortraitUpsidedown(2),
        LandscapeLeft(1),
        LendscapeRight(3),
        f2060f(-1);
        

        /* renamed from: a */
        private final int f2062a;

        private C3799b(int i) {
            this.f2062a = i;
        }

        /* renamed from: a */
        static C3799b m1948a(int i) {
            for (C3799b bVar : values()) {
                if (bVar.mo55933a() == i) {
                    return bVar;
                }
            }
            return f2060f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo55933a() {
            return this.f2062a;
        }
    }

    protected C3797y3(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public C3799b m1941n() {
        return C3595k3.m1060d().mo55513b().getSystemService("window") != null ? C3799b.m1948a(((WindowManager) C3595k3.m1060d().mo55513b().getSystemService("window")).getDefaultDisplay().getRotation()) : C3799b.f2060f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1728D;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public C3799b m1944j() {
        return m1941n();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo55533k() {
        super.mo55533k();
        if (mo55504f() != null) {
            C3490e3.m661b(String.format(Locale.US, "Collectors > Orientation : %s", new Object[]{((C3799b) mo55504f()).toString()}));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            this.f2054g = new C3798a();
            C3595k3.m1060d().mo55513b().registerComponentCallbacks(this.f2054g);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            if (this.f2054g != null) {
                C3595k3.m1060d().mo55513b().unregisterComponentCallbacks(this.f2054g);
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
