package com.medallia.digital.mobilesdk;

import android.os.Handler;
import com.medallia.digital.mobilesdk.AnalyticsBridge;
import com.medallia.digital.mobilesdk.C3615m3;
import com.medallia.digital.mobilesdk.C3706r3;
import com.medallia.digital.mobilesdk.C3717s2;
import com.medallia.digital.mobilesdk.MDExternalError;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.medallia.digital.mobilesdk.f0 */
class C3510f0 {

    /* renamed from: g */
    private static final long f1105g = 7000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MDResultCallback f1106a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C3517g f1107b;

    /* renamed from: c */
    private Handler f1108c;

    /* renamed from: d */
    private C3666p3 f1109d;

    /* renamed from: e */
    private boolean f1110e;

    /* renamed from: f */
    private boolean f1111f;

    /* renamed from: com.medallia.digital.mobilesdk.f0$a */
    class C3511a implements C3795y1 {

        /* renamed from: a */
        final /* synthetic */ ConfigurationContract f1112a;

        C3511a(ConfigurationContract configurationContract) {
            this.f1112a = configurationContract;
        }

        /* renamed from: a */
        public void mo55373a() {
            C3510f0.this.m738a();
            C3510f0.this.m739a(new MDExternalError(MDExternalError.ExternalError.FORM_NOT_EXISTS_OR_NOT_PUBLISH), C3510f0.this.f1106a);
        }

        public void onSuccess() {
            if (C3510f0.this.m750b(this.f1112a)) {
                C3510f0.this.m738a();
                C3510f0.this.m751c();
                return;
            }
            C3510f0 f0Var = C3510f0.this;
            f0Var.m746a(true, f0Var.f1107b.f1126a, C3510f0.this.f1107b.f1127b, C3510f0.this.f1106a);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.f0$b */
    class C3512b implements C3795y1 {

        /* renamed from: a */
        final /* synthetic */ C3433a2 f1114a;

        C3512b(C3433a2 a2Var) {
            this.f1114a = a2Var;
        }

        /* renamed from: a */
        public void mo55373a() {
            C3490e3.m663c("Preload form failed on promoting = " + this.f1114a.getFormId());
        }

        public void onSuccess() {
            C3552h2.m914h().mo55451b(this.f1114a);
            C3817z5.m2029b().mo55989a(this.f1114a, (C3706r3.C3710d) null, C3706r3.C3711e.preload);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.f0$c */
    class C3513c implements MDResultCallback {

        /* renamed from: a */
        final /* synthetic */ C3433a2 f1116a;

        /* renamed from: b */
        final /* synthetic */ C3615m3.C3635r f1117b;

        /* renamed from: c */
        final /* synthetic */ String f1118c;

        C3513c(C3433a2 a2Var, C3615m3.C3635r rVar, String str) {
            this.f1116a = a2Var;
            this.f1117b = rVar;
            this.f1118c = str;
        }

        public void onError(MDExternalError mDExternalError) {
            if (this.f1117b == C3615m3.C3635r.NOTIFICATION) {
                AnalyticsBridge instance = AnalyticsBridge.getInstance();
                String str = this.f1118c;
                C3433a2 a2Var = this.f1116a;
                instance.reportHandleNotificationEvent(str, a2Var != null ? a2Var.getFormViewType() : FormViewType.none, C3510f0.this.f1107b != null, AnalyticsBridge.C3414c.failure, mDExternalError);
            }
            C3517g unused = C3510f0.this.f1107b = null;
            C3510f0.this.m738a();
            C3510f0 f0Var = C3510f0.this;
            f0Var.m739a(mDExternalError, f0Var.f1106a);
        }

        public void onSuccess() {
            if (this.f1116a != null) {
                C3615m3.C3635r rVar = this.f1117b;
                if (rVar == C3615m3.C3635r.CODE) {
                    AnalyticsBridge.getInstance().reportShowFormEvent(this.f1118c, this.f1116a.getFormViewType(), this.f1116a.mo55193f());
                } else if (rVar == C3615m3.C3635r.NOTIFICATION) {
                    AnalyticsBridge.getInstance().reportHandleNotificationEvent(this.f1118c, this.f1116a.getFormViewType(), C3510f0.this.f1107b != null, AnalyticsBridge.C3414c.f832a, (MDExternalError) null);
                }
            }
            C3517g unused = C3510f0.this.f1107b = null;
            C3510f0.this.m738a();
            C3510f0 f0Var = C3510f0.this;
            f0Var.m740a(f0Var.f1106a);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.f0$d */
    class C3514d extends C3666p3 {
        C3514d() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3510f0.this.f1106a != null) {
                C3510f0.this.m751c();
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.f0$e */
    class C3515e extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ MDResultCallback f1121a;

        /* renamed from: b */
        final /* synthetic */ MDExternalError f1122b;

        C3515e(MDResultCallback mDResultCallback, MDExternalError mDExternalError) {
            this.f1121a = mDResultCallback;
            this.f1122b = mDExternalError;
        }

        /* renamed from: a */
        public void mo55177a() {
            this.f1121a.onError(this.f1122b);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.f0$f */
    class C3516f extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ MDResultCallback f1124a;

        C3516f(MDResultCallback mDResultCallback) {
            this.f1124a = mDResultCallback;
        }

        /* renamed from: a */
        public void mo55177a() {
            this.f1124a.onSuccess();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.f0$g */
    private class C3517g {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public C3615m3.C3635r f1126a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f1127b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Long f1128c;

        private C3517g(C3615m3.C3635r rVar, String str, Long l) {
            this.f1126a = rVar;
            this.f1127b = str;
            this.f1128c = l;
        }

        /* synthetic */ C3517g(C3510f0 f0Var, C3615m3.C3635r rVar, String str, Long l, C3511a aVar) {
            this(rVar, str, l);
        }
    }

    C3510f0() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m738a() {
        try {
            this.f1108c.removeCallbacks(this.f1109d);
            this.f1108c.removeCallbacksAndMessages((Object) null);
            this.f1108c = null;
            this.f1109d = null;
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m739a(MDExternalError mDExternalError, MDResultCallback mDResultCallback) {
        if (mDResultCallback != null) {
            C3561h5.m954c().mo55466b().execute(new C3515e(mDResultCallback, mDExternalError));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m740a(MDResultCallback mDResultCallback) {
        if (mDResultCallback != null) {
            C3561h5.m954c().mo55466b().execute(new C3516f(mDResultCallback));
        }
    }

    /* renamed from: a */
    private void m741a(C3433a2 a2Var) {
        if (a2Var != null) {
            C3552h2.m914h().mo55445a(a2Var.getFormId(), (C3795y1) new C3512b(a2Var));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m746a(boolean z, C3615m3.C3635r rVar, String str, MDResultCallback mDResultCallback) {
        try {
            this.f1106a = mDResultCallback;
            if (mDResultCallback == null) {
                C3490e3.m666f("Missing listener, however, method will run regardless");
            }
            if (!z) {
                m749b();
            }
            C3433a2 b = C3552h2.m914h().mo55450b(str);
            if (this.f1110e) {
                if (C3552h2.m914h().mo55460f()) {
                    if (C3461c3.m562g().mo55272d()) {
                        MDExternalError mDExternalError = new MDExternalError(MDExternalError.ExternalError.APP_IS_IN_BG);
                        if (rVar == C3615m3.C3635r.NOTIFICATION) {
                            AnalyticsBridge.getInstance().reportHandleNotificationEvent(str, b != null ? b.getFormViewType() : FormViewType.none, this.f1107b != null, AnalyticsBridge.C3414c.failure, mDExternalError);
                        }
                        m739a(mDExternalError, mDResultCallback);
                        return;
                    } else if (b == null || C3552h2.m914h().mo55447a(b) || rVar != C3615m3.C3635r.NOTIFICATION) {
                        C3552h2.m914h().mo55444a(str, (MDResultCallback) new C3513c(b, rVar, str));
                        return;
                    } else {
                        this.f1107b = null;
                        m738a();
                        m739a(new MDExternalError(MDExternalError.ExternalError.FORM_INCORRECT_INVITATION_TYPE), this.f1106a);
                        return;
                    }
                }
            }
            this.f1107b = new C3517g(this, rVar, str, Long.valueOf(System.currentTimeMillis()), (C3511a) null);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* renamed from: b */
    private void m749b() {
        if (this.f1108c != null) {
            m738a();
        }
        this.f1108c = new Handler();
        this.f1109d = new C3514d();
        this.f1108c.postDelayed(this.f1109d, f1105g);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r7 = r7.getSdkConfiguration().getMedalliaDigitalBrain().getFormDisplayTimeout();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m750b(com.medallia.digital.mobilesdk.ConfigurationContract r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0042
            com.medallia.digital.mobilesdk.f0$g r1 = r6.f1107b
            if (r1 == 0) goto L_0x0042
            com.medallia.digital.mobilesdk.SDKConfigurationContract r1 = r7.getSdkConfiguration()
            if (r1 == 0) goto L_0x0042
            com.medallia.digital.mobilesdk.SDKConfigurationContract r1 = r7.getSdkConfiguration()
            com.medallia.digital.mobilesdk.MedalliaDigitalBrainConfigurationContract r1 = r1.getMedalliaDigitalBrain()
            if (r1 == 0) goto L_0x0042
            com.medallia.digital.mobilesdk.SDKConfigurationContract r7 = r7.getSdkConfiguration()
            com.medallia.digital.mobilesdk.MedalliaDigitalBrainConfigurationContract r7 = r7.getMedalliaDigitalBrain()
            java.lang.Long r7 = r7.getFormDisplayTimeout()
            if (r7 == 0) goto L_0x0042
            long r1 = r7.longValue()
            r3 = 7000(0x1b58, double:3.4585E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0042
            long r1 = r7.longValue()
            com.medallia.digital.mobilesdk.f0$g r7 = r6.f1107b
            java.lang.Long r7 = r7.f1128c
            long r3 = r7.longValue()
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0042
            r0 = 1
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3510f0.m750b(com.medallia.digital.mobilesdk.ConfigurationContract):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m751c() {
        this.f1107b = null;
        if (this.f1106a != null) {
            m739a((this.f1111f || this.f1110e) ? new MDExternalError(MDExternalError.ExternalError.FORM_DISPLAY_TIMEOUT) : new MDExternalError(MDExternalError.ExternalError.SDK_NOT_INITIALIZED), this.f1106a);
        }
        C3490e3.m663c("Form Display Timeout");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55369a(ConfigurationContract configurationContract) {
        if (this.f1107b == null) {
            return;
        }
        if (m750b(configurationContract)) {
            m738a();
            m751c();
            return;
        }
        C3552h2.m914h().mo55445a(this.f1107b.f1127b, (C3795y1) new C3511a(configurationContract));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55370a(C3615m3.C3635r rVar, String str, MDResultCallback mDResultCallback) {
        C3702r2.m1571c().mo55769a(rVar == C3615m3.C3635r.CODE ? C3717s2.C3720c.showForm : C3717s2.C3720c.handleNotification);
        m746a(false, rVar, str, mDResultCallback);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55371a(ArrayList<C3433a2> arrayList) {
        if (arrayList != null) {
            Iterator<C3433a2> it = arrayList.iterator();
            while (it.hasNext()) {
                C3433a2 next = it.next();
                if (next.mo55193f()) {
                    C3490e3.m665e("Preload form loaded = " + next.getFormId());
                    m741a(next);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55372a(boolean z, boolean z2) {
        this.f1110e = z;
        this.f1111f = z2;
    }
}
