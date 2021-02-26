package com.medallia.digital.mobilesdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.medallia.digital.mobilesdk.C3429a1;
import com.medallia.digital.mobilesdk.C3717s2;

/* renamed from: com.medallia.digital.mobilesdk.r */
class C3687r implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a */
    private final CharSequence f1689a;

    /* renamed from: b */
    private C3429a1 f1690b;

    /* renamed from: c */
    private C3781x f1691c;

    /* renamed from: d */
    private Activity f1692d;

    /* renamed from: e */
    private ViewGroup f1693e = null;

    /* renamed from: f */
    private Animation f1694f;

    /* renamed from: g */
    private Animation f1695g;

    /* renamed from: h */
    private C3714s f1696h;

    /* renamed from: i */
    private C3804z0 f1697i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f1698j;

    /* renamed from: k */
    private Handler f1699k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f1700l;

    /* renamed from: m */
    private boolean f1701m;

    /* renamed from: com.medallia.digital.mobilesdk.r$a */
    class C3688a extends C3666p3 {
        C3688a() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (!(C3687r.this.mo55745k() == null || C3687r.this.mo55745k().getParent() == null)) {
                ((ViewGroup) C3687r.this.mo55745k().getParent()).removeView(C3687r.this.mo55745k());
            }
            C3687r.this.m1504B();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r$b */
    class C3689b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C3714s f1703a;

        C3689b(C3714s sVar) {
            this.f1703a = sVar;
        }

        public void onClick(View view) {
            C3687r rVar = C3687r.this;
            rVar.m1518a(this.f1703a, new C3717s2(rVar.mo55743i(), C3717s2.C3719b.buttonClicked, C3687r.this.mo55745k().mo55840b()));
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r$c */
    class C3690c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C3714s f1705a;

        C3690c(C3714s sVar) {
            this.f1705a = sVar;
        }

        public void onClick(View view) {
            C3687r.this.m1517a(this.f1705a);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r$d */
    class C3691d extends C3725t {

        /* renamed from: q */
        final /* synthetic */ C3714s f1707q;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C3691d(C3429a1.C3432c cVar, boolean z, C3714s sVar) {
            super(cVar, z);
            this.f1707q = sVar;
        }

        /* renamed from: a */
        public void mo55758a() {
            C3687r.this.m1517a(this.f1707q);
        }

        /* renamed from: b */
        public void mo55759b() {
            boolean unused = C3687r.this.f1698j = true;
        }

        /* renamed from: c */
        public void mo55760c() {
            if (C3687r.this.mo55742h().f874b == C3429a1.C3432c.BOTTOM) {
                C3714s sVar = this.f1707q;
                if (sVar != null) {
                    sVar.mo55787a(new C3717s2(C3687r.this.mo55743i(), C3717s2.C3719b.swipeDown, C3687r.this.mo55745k().mo55840b()));
                }
                C3687r.this.m1511a(C3695h.DOWN);
            }
        }

        /* renamed from: d */
        public void mo55761d() {
            C3714s sVar = this.f1707q;
            if (sVar != null) {
                sVar.mo55787a(new C3717s2(C3687r.this.mo55743i(), C3717s2.C3719b.swipeLeft, C3687r.this.mo55745k().mo55840b()));
            }
            C3687r.this.m1511a(C3695h.LEFT);
        }

        /* renamed from: e */
        public void mo55762e() {
            C3714s sVar = this.f1707q;
            if (sVar != null) {
                sVar.mo55787a(new C3717s2(C3687r.this.mo55743i(), C3717s2.C3719b.swipeRight, C3687r.this.mo55745k().mo55840b()));
            }
            C3687r.this.m1511a(C3695h.RIGHT);
        }

        /* renamed from: f */
        public void mo55763f() {
            if (C3687r.this.mo55742h().f874b == C3429a1.C3432c.TOP) {
                C3714s sVar = this.f1707q;
                if (sVar != null) {
                    sVar.mo55787a(new C3717s2(C3687r.this.mo55743i(), C3717s2.C3719b.swipeUp, C3687r.this.mo55745k().mo55840b()));
                }
                C3687r.this.m1511a(C3695h.UP);
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r$e */
    class C3692e implements Runnable {
        C3692e() {
        }

        public void run() {
            if (!C3687r.this.f1698j) {
                C3687r.this.m1512a(C3696i.REMOVE_BANNER);
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r$f */
    class C3693f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ View f1710a;

        C3693f(View view) {
            this.f1710a = view;
        }

        @TargetApi(16)
        public void onGlobalLayout() {
            long j;
            this.f1710a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (C3687r.this.m1530u() != null) {
                long j2 = 0;
                if (C3687r.this.f1700l == 0) {
                    this.f1710a.startAnimation(C3687r.this.m1530u());
                    j = C3687r.this.m1530u().getDuration();
                } else {
                    j = 0;
                }
                if (-1 != C3687r.this.mo55742h().f873a) {
                    if (C3687r.this.f1700l == 0) {
                        long unused = C3687r.this.f1700l = System.currentTimeMillis();
                    } else {
                        j2 = System.currentTimeMillis() - C3687r.this.f1700l;
                    }
                    if (!C3687r.this.mo55745k().mo55841c()) {
                        C3687r rVar = C3687r.this;
                        rVar.m1508a((rVar.mo55742h().f873a - j2) + j);
                    }
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r$g */
    static /* synthetic */ class C3694g {

        /* renamed from: a */
        static final /* synthetic */ int[] f1712a = new int[C3695h.values().length];

        /* renamed from: b */
        static final /* synthetic */ int[] f1713b = new int[C3696i.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        static {
            /*
                com.medallia.digital.mobilesdk.r$i[] r0 = com.medallia.digital.mobilesdk.C3687r.C3696i.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1713b = r0
                r0 = 1
                int[] r1 = f1713b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.r$i r2 = com.medallia.digital.mobilesdk.C3687r.C3696i.DISPLAY_BANNER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f1713b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.r$i r3 = com.medallia.digital.mobilesdk.C3687r.C3696i.ADD_BANNER_TO_VIEW     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f1713b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.medallia.digital.mobilesdk.r$i r4 = com.medallia.digital.mobilesdk.C3687r.C3696i.REMOVE_BANNER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.medallia.digital.mobilesdk.r$h[] r3 = com.medallia.digital.mobilesdk.C3687r.C3695h.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f1712a = r3
                int[] r3 = f1712a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.medallia.digital.mobilesdk.r$h r4 = com.medallia.digital.mobilesdk.C3687r.C3695h.UP     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f1712a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.medallia.digital.mobilesdk.r$h r3 = com.medallia.digital.mobilesdk.C3687r.C3695h.LEFT     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f1712a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.medallia.digital.mobilesdk.r$h r1 = com.medallia.digital.mobilesdk.C3687r.C3695h.RIGHT     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r0 = f1712a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.medallia.digital.mobilesdk.r$h r1 = com.medallia.digital.mobilesdk.C3687r.C3695h.DOWN     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3687r.C3694g.<clinit>():void");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r$h */
    enum C3695h {
        UP,
        LEFT,
        RIGHT,
        DOWN;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Animation mo55766a(C3687r rVar) {
            int i = C3694g.f1712a[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? rVar.m1534y() : rVar.m1531v() : rVar.m1533x() : rVar.m1532w() : rVar.m1534y();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r$i */
    enum C3696i {
        DISPLAY_BANNER,
        ADD_BANNER_TO_VIEW,
        REMOVE_BANNER
    }

    private C3687r(long j, boolean z, Activity activity, C3781x xVar, C3429a1 a1Var, C3714s sVar) {
        this.f1700l = j;
        this.f1698j = z;
        this.f1692d = activity;
        this.f1691c = xVar;
        this.f1701m = xVar.mo55840b();
        this.f1690b = a1Var == null ? C3429a1.f872e : a1Var;
        this.f1689a = null;
        this.f1696h = sVar;
        this.f1697i = new C3804z0();
    }

    /* renamed from: A */
    private void m1503A() {
        C3781x k = mo55745k();
        ViewGroup viewGroup = this.f1693e;
        k.measure(View.MeasureSpec.makeMeasureSpec(viewGroup != null ? viewGroup.getMeasuredWidth() : this.f1692d.getWindow().getDecorView().getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public void m1504B() {
        ViewGroup viewGroup;
        if (mo55752p() && (viewGroup = (ViewGroup) mo55745k().getParent()) != null) {
            viewGroup.removeView(mo55745k());
        }
    }

    /* renamed from: a */
    static C3687r m1507a(long j, boolean z, Activity activity, C3781x xVar, C3429a1 a1Var, C3714s sVar) {
        return new C3687r(j, z, activity, xVar, a1Var, sVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1508a(long j) {
        this.f1699k = new Handler();
        this.f1699k.postDelayed(new C3692e(), j);
    }

    /* renamed from: a */
    protected static void m1509a(Activity activity, C3781x xVar, C3429a1 a1Var, C3714s sVar) {
        m1507a(0, false, activity, xVar, a1Var, sVar).mo55754r();
    }

    /* renamed from: a */
    private void m1510a(ViewGroup.MarginLayoutParams marginLayoutParams, Activity activity) {
        try {
            C3490e3.m661b("activity = " + activity.getClass().getSimpleName());
            Window window = activity.getWindow();
            boolean z = true;
            int i = 0;
            boolean z2 = (window.getAttributes().flags & 1024) != 0;
            if (Build.VERSION.SDK_INT < 19 || (window.getAttributes().flags & 67108864) == 0) {
                z = false;
            }
            if (z2 || z) {
                int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (identifier > 0) {
                    i = activity.getResources().getDimensionPixelSize(identifier);
                }
                C3490e3.m661b("activity = status is transparent = " + i);
                marginLayoutParams.topMargin = i;
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1511a(C3695h hVar) {
        C3781x k = mo55745k();
        if (k != null) {
            k.startAnimation(hVar.mo55766a(this));
            ViewGroup viewGroup = (ViewGroup) k.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(k);
            }
            mo55736b();
            mo55738d();
            mo55737c();
            mo55735a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1512a(C3696i iVar) {
        int i = C3694g.f1713b[iVar.ordinal()];
        if (i == 1) {
            m1529t();
        } else if (i == 2) {
            m1528s();
        } else if (i == 3) {
            if (mo55740f() != null) {
                mo55740f().mo55788b(new C3717s2(mo55743i(), C3717s2.C3720c.timeoutPassed, mo55745k().mo55840b()));
            }
            m1511a(mo55742h().f874b == C3429a1.C3432c.BOTTOM ? C3695h.DOWN : C3695h.UP);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1517a(C3714s sVar) {
        if (sVar != null) {
            sVar.mo55789c(new C3717s2(mo55743i(), mo55745k().mo55840b()));
        }
        m1511a(mo55742h().f874b == C3429a1.C3432c.BOTTOM ? C3695h.DOWN : C3695h.UP);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1518a(C3714s sVar, C3717s2 s2Var) {
        if (sVar != null) {
            sVar.mo55787a(s2Var);
        }
        m1511a(mo55742h().f874b == C3429a1.C3432c.BOTTOM ? C3695h.DOWN : C3695h.UP);
    }

    /* renamed from: s */
    private void m1528s() {
        if (!mo55752p()) {
            C3781x k = mo55745k();
            if (k.getParent() == null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) k.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new FrameLayout.LayoutParams(-1, -2);
                }
                Activity e = mo55739e();
                if (e != null && !e.isFinishing()) {
                    if (mo55742h().f874b == C3429a1.C3432c.TOP) {
                        layoutParams.gravity = 48;
                        m1510a((ViewGroup.MarginLayoutParams) layoutParams, e);
                    } else if (mo55742h().f874b == C3429a1.C3432c.BOTTOM) {
                        layoutParams.gravity = 80;
                    }
                    if (e.getWindow() != null) {
                        e.getWindow().addContentView(k, layoutParams);
                    }
                } else {
                    return;
                }
            }
            k.requestLayout();
            ViewTreeObserver viewTreeObserver = k.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new C3693f(k));
            }
        }
    }

    /* renamed from: t */
    private void m1529t() {
        if (mo55739e() != null && mo55745k() != null && !mo55752p()) {
            C3714s f = mo55740f();
            if (mo55745k().mo55840b() && mo55745k().mo55843e() != null) {
                mo55745k().mo55843e().setOnClickListener(new C3689b(f));
            }
            if (mo55745k().mo55840b() && mo55745k().mo55844f() != null) {
                mo55745k().mo55844f().setOnClickListener(new C3690c(f));
            }
            mo55745k().setOnTouchListener(new C3691d(mo55742h().f874b, !mo55745k().mo55840b(), f));
            m1512a(C3696i.ADD_BANNER_TO_VIEW);
            if (mo55740f() != null) {
                mo55740f().mo55785a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public Animation m1530u() {
        if (this.f1694f == null && this.f1692d != null) {
            m1503A();
            this.f1694f = this.f1690b.f874b == C3429a1.C3432c.BOTTOM ? this.f1697i.mo55949b((View) mo55745k()) : this.f1697i.mo55948a((View) mo55745k());
        }
        return this.f1694f;
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public Animation m1531v() {
        if (this.f1695g == null && this.f1692d != null) {
            this.f1695g = this.f1697i.mo55950c(mo55745k());
        }
        return this.f1695g;
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public Animation m1532w() {
        if (this.f1692d != null) {
            this.f1695g = this.f1697i.mo55951d(mo55745k());
        }
        return this.f1695g;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public Animation m1533x() {
        if (this.f1692d != null) {
            this.f1695g = this.f1697i.mo55952e(mo55745k());
        }
        return this.f1695g;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public Animation m1534y() {
        if (this.f1695g == null && this.f1692d != null) {
            this.f1695g = this.f1697i.mo55953f(mo55745k());
        }
        return this.f1695g;
    }

    /* renamed from: z */
    private boolean m1535z() {
        C3781x xVar = this.f1691c;
        return (xVar == null || xVar.getParent() == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55735a() {
        try {
            Activity e = mo55739e();
            if (e == null) {
                e = (Activity) C3595k3.m1060d().mo55514c().getBaseContext();
            }
            e.runOnUiThread(new C3688a());
            if (this.f1699k != null) {
                this.f1699k.removeCallbacksAndMessages((Object) null);
                this.f1699k = null;
            }
            this.f1696h = null;
        } catch (Exception e2) {
            C3490e3.m663c(e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo55736b() {
        this.f1692d = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo55737c() {
        this.f1696h = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo55738d() {
        this.f1693e = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Activity mo55739e() {
        return this.f1692d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C3714s mo55740f() {
        return this.f1696h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public long mo55741g() {
        return this.f1700l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C3429a1 mo55742h() {
        return this.f1690b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C3717s2.C3721d mo55743i() {
        if (mo55745k() == null) {
            return null;
        }
        if (mo55745k().mo55841c()) {
            return C3717s2.C3721d.StickyByConfiguration;
        }
        if (mo55749o()) {
            return C3717s2.C3721d.StickyByGesture;
        }
        if (!mo55745k().mo55841c()) {
            return C3717s2.C3721d.f1846a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public CharSequence mo55744j() {
        return this.f1689a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public C3781x mo55745k() {
        return this.f1691c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public ViewGroup mo55746l() {
        return this.f1693e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo55747m() {
        m1511a(mo55742h().f874b == C3429a1.C3432c.BOTTOM ? C3695h.DOWN : C3695h.UP);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo55748n() {
        return this.f1701m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean mo55749o() {
        return this.f1698j;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean mo55752p() {
        return this.f1692d != null && m1535z();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo55753q() {
        if (mo55745k() == null) {
            return false;
        }
        mo55745k().mo55842d();
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void mo55754r() {
        m1529t();
    }

    public String toString() {
        return "Banner{text=" + this.f1689a + ", configuration=" + this.f1690b + ", customView=" + this.f1691c + ", activity=" + this.f1692d + ", viewGroup=" + this.f1693e + ", inAnimation=" + this.f1694f + ", outAnimation=" + this.f1695g + ", bannerCallbacks=" + this.f1696h + '}';
    }
}
