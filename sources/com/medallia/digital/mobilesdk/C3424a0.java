package com.medallia.digital.mobilesdk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.medallia.digital.mobilesdk.C3527g0;
import com.medallia.digital.mobilesdk.C3706r3;
import com.medallia.digital.mobilesdk.C3805z1;

/* renamed from: com.medallia.digital.mobilesdk.a0 */
abstract class C3424a0 extends AppCompatActivity implements C3805z1.C3812g, C3706r3.C3710d {

    /* renamed from: a */
    protected C3433a2 f857a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f858b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f859c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f860d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C3706r3 f861e;

    /* renamed from: f */
    private long f862f;

    /* renamed from: g */
    private Handler f863g = new Handler();

    /* renamed from: h */
    private C3666p3 f864h = new C3425a();

    /* renamed from: com.medallia.digital.mobilesdk.a0$a */
    class C3425a extends C3666p3 {
        C3425a() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (!C3424a0.this.f861e.mo55781i() && !C3424a0.this.isFinishing()) {
                AnalyticsBridge.getInstance().reportFormLoadSpinnerEvent(C3424a0.this.f857a.getFormId(), Long.valueOf(C3424a0.this.f860d), C3424a0.this.f857a.getFormViewType(), C3424a0.this.f857a.getFormType());
                C3424a0.this.m424a(true);
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.a0$b */
    class C3426b extends C3666p3 {
        C3426b() {
        }

        /* renamed from: a */
        public void mo55177a() {
            boolean unused = C3424a0.this.f858b = false;
            C3424a0.this.mo55176e();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.a0$c */
    class C3427c extends C3666p3 {
        C3427c() {
        }

        /* renamed from: a */
        public void mo55177a() {
            C3424a0.this.m424a(false);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.a0$d */
    class C3428d extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ C3424a0 f868a;

        C3428d(C3424a0 a0Var) {
            this.f868a = a0Var;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3424a0.this.f861e.mo55774a((C3805z1.C3812g) this.f868a);
            C3424a0.this.f861e.mo55776b((C3706r3.C3710d) this.f868a);
            if (C3424a0.this.f861e.mo55781i()) {
                C3424a0.this.m424a(false);
            }
            C3424a0.this.f861e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (C3424a0.this.f861e.getParent() != null) {
                ((ViewGroup) C3424a0.this.f861e.getParent()).removeView(C3424a0.this.f861e);
            }
            ((RelativeLayout) C3424a0.this.findViewById(C3417R.C3420id.medallia_form_webview_layout)).addView(C3424a0.this.f861e);
            if (C3424a0.this.f861e.mo55781i()) {
                boolean unused = C3424a0.this.f859c = true;
                C3527g0.C3531c.m843a(C3527g0.C3531c.C3532a.formDisplayed, C3424a0.this.f857a.getFormId(), C3424a0.this.f857a.getFormType(), C3424a0.this.f857a.getFormViewType(), 0);
            }
        }
    }

    C3424a0() {
    }

    /* renamed from: a */
    private C3706r3.C3711e m421a(C3433a2 a2Var, boolean z) {
        return a2Var.mo55193f() ? C3706r3.C3711e.preload : z ? C3706r3.C3711e.showForm : C3706r3.C3711e.invitationProducer;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m424a(boolean z) {
        findViewById(C3417R.C3420id.medallia_progress_bar).setVisibility(z ? 0 : 8);
    }

    /* renamed from: g */
    private void m428g() {
        runOnUiThread(new C3428d(this));
    }

    /* renamed from: h */
    private void m429h() {
        if (this.f857a != null) {
            C3490e3.m665e("FormId: " + this.f857a.getFormId() + " close was called");
            if (this.f861e != null) {
                ((RelativeLayout) findViewById(C3417R.C3420id.medallia_form_webview_layout)).removeView(this.f861e);
                if (this.f861e.getParent() != null) {
                    ((ViewGroup) this.f861e.getParent()).removeView(this.f861e);
                }
                C3817z5.m2029b().mo55991a(this.f861e);
            }
            if (!this.f859c) {
                C3527g0.C3531c.m843a(C3527g0.C3531c.C3532a.formDisplayed, this.f857a.getFormId(), this.f857a.getFormType(), this.f857a.getFormViewType(), -1);
            }
            if (this.f858b) {
                C3527g0.C3531c.m843a(C3527g0.C3531c.C3532a.formDismissed, this.f857a.getFormId(), this.f857a.getFormType(), this.f857a.getFormViewType(), 0);
            }
            C3527g0.C3531c.m843a(C3527g0.C3531c.C3532a.formClosed, this.f857a.getFormId(), this.f857a.getFormType(), this.f857a.getFormViewType(), -1);
        }
    }

    /* renamed from: a */
    public void mo55094a() {
        runOnUiThread(new C3427c());
    }

    /* renamed from: b */
    public void mo55095b() {
        if (!this.f859c) {
            this.f859c = true;
            C3527g0.C3531c.m843a(C3527g0.C3531c.C3532a.formDisplayed, this.f857a.getFormId(), this.f857a.getFormType(), this.f857a.getFormViewType(), System.currentTimeMillis() - this.f862f);
        }
    }

    /* renamed from: c */
    public void mo55096c() {
    }

    /* renamed from: d */
    public void mo55097d() {
        runOnUiThread(new C3426b());
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo55176e() {
        C3666p3 p3Var;
        Handler handler = this.f863g;
        if (!(handler == null || (p3Var = this.f864h) == null)) {
            handler.removeCallbacks(p3Var);
            this.f863g.removeCallbacksAndMessages((Object) null);
            this.f863g = null;
            this.f864h = null;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract void mo55098f();

    public void finish() {
        super.finish();
        C3539g2 b = C3652n5.m1375b(this.f857a.mo55191e());
        overridePendingTransition(b.mo55432a(), b.mo55433b());
    }

    public void onBackPressed() {
        super.onBackPressed();
        mo55176e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("com.medallia.digital.mobilesdk.form_data")) {
            mo55176e();
            return;
        }
        this.f862f = System.currentTimeMillis();
        this.f857a = (C3433a2) intent.getSerializableExtra("com.medallia.digital.mobilesdk.form_data");
        boolean booleanExtra = intent.getBooleanExtra("com.medallia.digital.mobilesdk.is_show_form", false);
        this.f861e = C3817z5.m2029b().mo55992b(m421a(this.f857a, booleanExtra));
        boolean booleanExtra2 = intent.getBooleanExtra("com.medallia.digital.mobilesdk.vuln_enabled", true);
        this.f860d = intent.getLongExtra("com.medallia.digital.mobilesdk.spinner_delay", C3712r4.f1818d.longValue());
        if (booleanExtra) {
            this.f863g.postDelayed(this.f864h, this.f860d);
        }
        setRequestedOrientation(intent.getBooleanExtra("com.medallia.digital.mobilesdk.inherit_orientation", false) ? 3 : 10);
        if (booleanExtra2 && getWindow() != null) {
            getWindow().addFlags(8192);
        }
        C3539g2 a = C3652n5.m1374a(this.f857a.mo55191e());
        overridePendingTransition(a.mo55432a(), a.mo55433b());
        super.onCreate(bundle);
        mo55098f();
        m428g();
    }

    public void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            m429h();
            C3706r3 r3Var = this.f861e;
            if (r3Var != null && r3Var.mo55780h()) {
                this.f861e.mo55782j();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C3706r3 r3Var = this.f861e;
        if (r3Var != null) {
            r3Var.mo55774a((C3805z1.C3812g) null);
            this.f861e.mo55776b((C3706r3.C3710d) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C3706r3 r3Var = this.f861e;
        if (r3Var != null) {
            r3Var.mo55774a((C3805z1.C3812g) this);
            this.f861e.mo55776b((C3706r3.C3710d) this);
        }
    }
}
