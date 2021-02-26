package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.medallia.digital.mobilesdk.c3 */
class C3461c3 implements Application.ActivityLifecycleCallbacks, C3713r5 {

    /* renamed from: m */
    private static C3461c3 f950m;

    /* renamed from: a */
    private int f951a = 0;

    /* renamed from: b */
    private long f952b;

    /* renamed from: c */
    private long f953c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f954d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList<C3468g> f955e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<C3469h> f956f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<C3467f> f957g = new ArrayList<>();

    /* renamed from: h */
    private Integer f958h;

    /* renamed from: i */
    private String f959i;

    /* renamed from: j */
    private ComponentCallbacks2 f960j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f961k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<Activity> f962l = new ArrayList();

    /* renamed from: com.medallia.digital.mobilesdk.c3$a */
    class C3462a implements ComponentCallbacks2 {
        C3462a() {
        }

        public void onConfigurationChanged(Configuration configuration) {
            int i = C3595k3.m1060d().mo55513b().getResources().getConfiguration().orientation;
            if ((i == 1 || i == 2) && !C3461c3.this.f954d && C3461c3.this.f962l.size() > 0) {
                boolean unused = C3461c3.this.f961k = true;
                C3461c3.this.m563h();
            }
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.c3$b */
    class C3463b extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ long f964a;

        C3463b(long j) {
            this.f964a = j;
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3461c3.this.f955e != null) {
                Iterator it = C3461c3.this.f955e.iterator();
                while (it.hasNext()) {
                    C3468g gVar = (C3468g) it.next();
                    if (gVar != null) {
                        gVar.mo55286a(this.f964a);
                    }
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.c3$c */
    class C3464c extends C3666p3 {
        C3464c() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3461c3.this.f956f != null) {
                Iterator it = C3461c3.this.f956f.iterator();
                while (it.hasNext()) {
                    C3469h hVar = (C3469h) it.next();
                    if (hVar != null) {
                        hVar.onBackground();
                    }
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.c3$d */
    class C3465d extends C3666p3 {
        C3465d() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3461c3.this.f956f != null) {
                Iterator it = C3461c3.this.f956f.iterator();
                while (it.hasNext()) {
                    C3469h hVar = (C3469h) it.next();
                    if (hVar != null) {
                        hVar.onForeground();
                    }
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.c3$e */
    class C3466e extends C3666p3 {
        C3466e() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3461c3.this.f957g != null) {
                Iterator it = C3461c3.this.f957g.iterator();
                while (it.hasNext()) {
                    C3467f fVar = (C3467f) it.next();
                    if (fVar != null) {
                        fVar.mo55285b();
                    }
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.c3$f */
    protected interface C3467f {
        /* renamed from: a */
        void mo55284a();

        /* renamed from: b */
        void mo55285b();
    }

    /* renamed from: com.medallia.digital.mobilesdk.c3$g */
    protected interface C3468g {
        /* renamed from: a */
        void mo55286a(long j);
    }

    /* renamed from: com.medallia.digital.mobilesdk.c3$h */
    protected interface C3469h {
        void onBackground();

        void onForeground();
    }

    private C3461c3() {
        m566k();
    }

    /* renamed from: a */
    private void m552a(long j) {
        C3561h5.m954c().mo55465a().execute(new C3463b(j));
    }

    /* renamed from: b */
    private void m556b(Activity activity) {
        if (this.f954d) {
            this.f954d = false;
            C3595k3.m1058a(activity.getApplication());
            m552a(mo55261a().longValue());
            m565j();
            this.f953c = System.currentTimeMillis();
            this.f952b = 0;
            C3490e3.m661b("Application is in foreground");
        }
    }

    /* renamed from: f */
    private String m560f() {
        return this.f959i;
    }

    /* renamed from: g */
    public static C3461c3 m562g() {
        if (f950m == null) {
            f950m = new C3461c3();
        }
        return f950m;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m563h() {
        C3561h5.m954c().mo55465a().execute(new C3466e());
    }

    /* renamed from: i */
    private void m564i() {
        C3561h5.m954c().mo55465a().execute(new C3464c());
    }

    /* renamed from: j */
    private void m565j() {
        C3561h5.m954c().mo55465a().execute(new C3465d());
    }

    /* renamed from: k */
    private void m566k() {
        try {
            C3595k3.m1060d().mo55511a().registerActivityLifecycleCallbacks(this);
            m567l();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* renamed from: l */
    private void m567l() {
        this.f960j = new C3462a();
        C3595k3.m1060d().mo55513b().registerComponentCallbacks(this.f960j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Long mo55261a() {
        if (this.f952b == 0) {
            return 0L;
        }
        return Long.valueOf(System.currentTimeMillis() - this.f952b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55262a(Activity activity) {
        if (activity != null && this.f958h == null) {
            this.f951a++;
            this.f959i = activity.getClass().getName();
            this.f958h = Integer.valueOf(activity.hashCode());
            this.f962l.add(activity);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55263a(C3467f fVar) {
        ArrayList<C3467f> arrayList = this.f957g;
        if (arrayList != null && fVar != null) {
            arrayList.add(fVar);
        }
    }

    /* renamed from: a */
    public void mo55264a(C3468g gVar) {
        ArrayList<C3468g> arrayList = this.f955e;
        if (arrayList != null && gVar != null) {
            arrayList.add(gVar);
        }
    }

    /* renamed from: a */
    public void mo55265a(C3469h hVar) {
        if (hVar != null) {
            try {
                if (this.f956f != null) {
                    if (!this.f956f.contains(hVar)) {
                        this.f956f.add(hVar);
                    }
                }
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55266a(String str) {
        String f = m560f();
        List<Activity> list = this.f962l;
        if (list != null && !list.isEmpty()) {
            f = this.f962l.get(0).getClass().getName();
        }
        return f != null && f.equals(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Long mo55267b() {
        if (this.f953c == 0) {
            return 0L;
        }
        return Long.valueOf(System.currentTimeMillis() - this.f953c);
    }

    /* renamed from: b */
    public void mo55268b(C3467f fVar) {
        ArrayList<C3467f> arrayList = this.f957g;
        if (arrayList != null && fVar != null) {
            arrayList.remove(fVar);
        }
    }

    /* renamed from: b */
    public void mo55269b(C3468g gVar) {
        ArrayList<C3468g> arrayList = this.f955e;
        if (arrayList != null && gVar != null) {
            arrayList.remove(gVar);
        }
    }

    /* renamed from: b */
    public void mo55270b(C3469h hVar) {
        if (hVar != null) {
            try {
                if (this.f956f != null) {
                    this.f956f.remove(hVar);
                }
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo55271c() {
        return mo55266a("com.medallia.digital.mobilesdk.MedalliaFullFormActivity") || mo55266a("com.medallia.digital.mobilesdk.MedalliaModalFormActivity");
    }

    public void clearAndDisconnect() {
        ArrayList<C3469h> arrayList = this.f956f;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<C3468g> arrayList2 = this.f955e;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        mo55273e();
        f950m = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo55272d() {
        return this.f954d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo55273e() {
        try {
            C3595k3.m1060d().mo55511a().unregisterActivityLifecycleCallbacks(this);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f959i = activity.getClass().getName();
        this.f958h = Integer.valueOf(activity.hashCode());
        this.f951a++;
        if (this.f951a == 1) {
            m556b(activity);
        }
        C3595k3.m1060d().mo55512a((Context) activity);
        this.f961k = false;
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f962l.remove(activity);
        if (!this.f962l.isEmpty()) {
            C3595k3.m1060d().mo55512a((Context) this.f962l.get(0));
            m563h();
        }
    }

    public void onActivityResumed(Activity activity) {
        try {
            this.f962l.add(activity);
            m563h();
            this.f959i = activity.getClass().getName();
            this.f958h = Integer.valueOf(activity.hashCode());
            Context baseContext = C3595k3.m1060d().mo55514c().getBaseContext();
            if (baseContext != null && !baseContext.getClass().getName().equals(this.f959i)) {
                C3595k3.m1060d().mo55512a((Context) activity);
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        Integer num = this.f958h;
        if (num == null || num.intValue() != activity.hashCode() || this.f951a < 1) {
            this.f959i = activity.getClass().getName();
            this.f958h = Integer.valueOf(activity.hashCode());
            this.f951a++;
            if (this.f951a == 1 && (!this.f961k || !activity.isChangingConfigurations())) {
                m556b(activity);
            }
            this.f961k = false;
            C3595k3.m1060d().mo55512a((Context) activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        try {
            this.f951a--;
            if (this.f951a == 0) {
                this.f954d = true;
            }
            if (this.f954d && (!this.f961k || !activity.isChangingConfigurations())) {
                C3595k3.m1060d().mo55512a((Context) null);
                m564i();
                this.f952b = System.currentTimeMillis();
                this.f953c = 0;
                C3490e3.m661b("Application is in background");
            }
            if (this.f957g != null && this.f962l.size() == 0) {
                Iterator<C3467f> it = this.f957g.iterator();
                while (it.hasNext()) {
                    C3467f next = it.next();
                    if (next != null) {
                        next.mo55284a();
                    }
                }
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
