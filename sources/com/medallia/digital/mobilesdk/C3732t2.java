package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import com.google.android.exoplayer2.C1119C;
import com.medallia.digital.mobilesdk.AnalyticsBridge;
import com.medallia.digital.mobilesdk.C3429a1;
import com.medallia.digital.mobilesdk.C3527g0;
import com.medallia.digital.mobilesdk.C3706r3;
import com.medallia.digital.mobilesdk.C3717s2;
import com.medallia.digital.mobilesdk.InviteData;

/* renamed from: com.medallia.digital.mobilesdk.t2 */
class C3732t2 {

    /* renamed from: k */
    private static final String f1886k = "https://play.google.com/store/apps/details?id=";

    /* renamed from: a */
    private InviteData f1887a = null;

    /* renamed from: b */
    private String f1888b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MDEngagementType f1889c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AlertDialog f1890d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C3687r f1891e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f1892f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f1893g = false;

    /* renamed from: h */
    private boolean f1894h = false;

    /* renamed from: i */
    private C3611m f1895i;

    /* renamed from: j */
    private boolean f1896j;

    /* renamed from: com.medallia.digital.mobilesdk.t2$a */
    class C3733a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ long f1897a;

        /* renamed from: b */
        final /* synthetic */ BannerData f1898b;

        /* renamed from: com.medallia.digital.mobilesdk.t2$a$a */
        class C3734a extends C3714s {
            C3734a() {
            }

            /* renamed from: a */
            public void mo55785a() {
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo55786a(C3687r rVar) {
            }

            /* renamed from: a */
            public void mo55787a(C3717s2 s2Var) {
                C3732t2.this.m1671b(s2Var);
                C3687r unused = C3732t2.this.f1891e = null;
            }

            /* renamed from: b */
            public void mo55788b(C3717s2 s2Var) {
                C3732t2.this.m1661a(s2Var);
                C3687r unused = C3732t2.this.f1891e = null;
            }

            /* renamed from: c */
            public void mo55789c(C3717s2 s2Var) {
                C3732t2.this.m1674c(s2Var);
                C3687r unused = C3732t2.this.f1891e = null;
            }
        }

        C3733a(long j, BannerData bannerData) {
            this.f1897a = j;
            this.f1898b = bannerData;
        }

        /* renamed from: a */
        public void mo55177a() {
            if (!C3732t2.this.m1665a(this.f1897a)) {
                C3732t2.this.m1678e();
                return;
            }
            C3429a1.C3432c position = C3429a1.C3432c.getPosition(this.f1898b.getPosition());
            C3781x a = new C3766w().mo55879a(position).mo55890g(this.f1898b.getInvitationBody()).mo55892i(this.f1898b.getInvitationTitle()).mo55887d(this.f1898b.getBackgroundColor()).mo55891h(this.f1898b.getTextColor()).mo55880a(this.f1898b.getAcceptButtonBackgroundColor()).mo55883b(this.f1898b.getAcceptButtonText()).mo55888e(this.f1898b.getCloseButtonColor()).mo55884b(this.f1898b.isPartial()).mo55886c(this.f1898b.isSticky()).mo55881a(this.f1898b.isButtonsDisplay()).mo55885c(this.f1898b.getAcceptButtonTextColor()).mo55889f(this.f1898b.getFont()).mo55882a(C3595k3.m1060d().mo55514c().getBaseContext(), this.f1898b.isBannerV2());
            C3732t2 t2Var = C3732t2.this;
            C3687r unused = t2Var.f1891e = C3687r.m1507a(t2Var.f1892f, C3732t2.this.f1893g, (Activity) C3595k3.m1060d().mo55514c().getBaseContext(), a, new C3429a1.C3431b().mo55180a(this.f1898b.getInvitationTimeout()).mo55179a(position).mo55181a(), new C3734a());
            if (!C3732t2.this.m1665a(this.f1897a)) {
                C3732t2.this.m1678e();
                C3687r unused2 = C3732t2.this.f1891e = null;
            } else if (!C3732t2.this.m1665a(this.f1897a)) {
                C3732t2.this.mo55826a((C3717s2.C3720c) null);
            } else {
                C3732t2.this.f1891e.mo55754r();
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.t2$b */
    class C3735b extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ long f1901a;

        /* renamed from: b */
        final /* synthetic */ InviteData f1902b;

        /* renamed from: com.medallia.digital.mobilesdk.t2$b$a */
        class C3736a implements DialogInterface.OnCancelListener {
            C3736a() {
            }

            public void onCancel(DialogInterface dialogInterface) {
                C3732t2.this.m1661a(new C3717s2((C3717s2.C3721d) null, C3717s2.C3720c.androidBackButton, false));
                if (C3732t2.this.f1890d != null && C3732t2.this.f1890d.isShowing()) {
                    C3732t2.this.f1890d.dismiss();
                    AlertDialog unused = C3732t2.this.f1890d = null;
                }
            }
        }

        /* renamed from: com.medallia.digital.mobilesdk.t2$b$b */
        class C3737b implements DialogInterface.OnClickListener {
            C3737b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                C3732t2.this.m1661a(new C3717s2((C3717s2.C3721d) null, C3717s2.C3720c.maybeLater, false));
                if (C3732t2.this.f1890d != null && C3732t2.this.f1890d.isShowing()) {
                    C3732t2.this.f1890d.dismiss();
                    AlertDialog unused = C3732t2.this.f1890d = null;
                }
            }
        }

        /* renamed from: com.medallia.digital.mobilesdk.t2$b$c */
        class C3738c implements DialogInterface.OnClickListener {
            C3738c() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                C3732t2.this.m1671b(new C3717s2((C3717s2.C3721d) null, C3717s2.C3719b.buttonClicked, false));
                if (C3732t2.this.f1890d != null && C3732t2.this.f1890d.isShowing()) {
                    C3732t2.this.f1890d.dismiss();
                    AlertDialog unused = C3732t2.this.f1890d = null;
                }
            }
        }

        /* renamed from: com.medallia.digital.mobilesdk.t2$b$d */
        class C3739d implements DialogInterface.OnClickListener {
            C3739d() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                C3732t2.this.m1674c(new C3717s2((C3717s2.C3721d) null, false));
                if (C3732t2.this.f1890d != null && C3732t2.this.f1890d.isShowing()) {
                    C3732t2.this.f1890d.dismiss();
                    AlertDialog unused = C3732t2.this.f1890d = null;
                }
            }
        }

        C3735b(long j, InviteData inviteData) {
            this.f1901a = j;
            this.f1902b = inviteData;
        }

        /* renamed from: a */
        public void mo55177a() {
            String str;
            String str2;
            int i;
            Context context;
            if (!C3732t2.this.m1665a(this.f1901a)) {
                C3732t2.this.m1678e();
                return;
            }
            if (this.f1902b.getType() == InviteData.C3415a.ALERT) {
                str2 = this.f1902b.getInvitationHeadline();
                str = this.f1902b.getInvitationText();
            } else if (!TextUtils.isEmpty(this.f1902b.getBannerData().getInvitationTitle()) || !TextUtils.isEmpty(this.f1902b.getBannerData().getInvitationBody())) {
                str2 = this.f1902b.getBannerData().getInvitationTitle();
                str = this.f1902b.getBannerData().getInvitationBody();
            } else {
                if (!MDEngagementType.form.equals(C3732t2.this.f1889c)) {
                    str2 = C3595k3.m1060d().mo55513b().getString(C3417R.string.alert_form_default_title);
                    context = C3595k3.m1060d().mo55513b();
                    i = C3417R.string.alert_form_default_message;
                } else {
                    str2 = C3595k3.m1060d().mo55513b().getString(C3417R.string.alert_app_rating_default_title);
                    context = C3595k3.m1060d().mo55513b();
                    i = C3417R.string.alert_app_rating_default_message;
                }
                str = context.getString(i);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(C3595k3.m1060d().mo55514c(), C3417R.C3422style.MedalliaInvitationDialog);
            builder.setTitle((CharSequence) str2).setMessage((CharSequence) str).setPositiveButton((CharSequence) this.f1902b.getProvideButtonText(), (DialogInterface.OnClickListener) new C3739d()).setNegativeButton((CharSequence) this.f1902b.getDeclineButtonText(), (DialogInterface.OnClickListener) new C3738c()).setNeutralButton((CharSequence) this.f1902b.getLaterButtonText(), (DialogInterface.OnClickListener) new C3737b()).setOnCancelListener(new C3736a());
            AlertDialog unused = C3732t2.this.f1890d = builder.create();
            if (!C3732t2.this.m1665a(this.f1901a)) {
                C3732t2.this.m1678e();
                AlertDialog unused2 = C3732t2.this.f1890d = null;
                return;
            }
            if (C3732t2.this.f1890d != null) {
                C3732t2.this.f1890d.show();
            }
            C3732t2.this.m1659a(-1, C3417R.C3420id.invitation_positive);
            C3732t2.this.m1659a(-2, C3417R.C3420id.invitation_negative);
            C3732t2.this.m1659a(-3, C3417R.C3420id.invitation_neutral);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.t2$c */
    class C3740c extends C3666p3 {
        C3740c() {
        }

        /* renamed from: a */
        public void mo55177a() {
            C3817z5.m2029b().mo55990a(C3706r3.C3711e.invitationProducer);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.t2$d */
    static /* synthetic */ class C3741d {

        /* renamed from: a */
        static final /* synthetic */ int[] f1909a = new int[MDEngagementType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.medallia.digital.mobilesdk.MDEngagementType[] r0 = com.medallia.digital.mobilesdk.MDEngagementType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1909a = r0
                int[] r0 = f1909a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.MDEngagementType r1 = com.medallia.digital.mobilesdk.MDEngagementType.appRating     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1909a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.MDEngagementType r1 = com.medallia.digital.mobilesdk.MDEngagementType.form     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3732t2.C3741d.<clinit>():void");
        }
    }

    C3732t2() {
    }

    /* renamed from: a */
    private String m1658a(InviteData inviteData) {
        if (inviteData == null) {
            return null;
        }
        String str = inviteData.getType() != null ? inviteData.getType().toString() : "";
        return (inviteData.getType() != InviteData.C3415a.BANNER || inviteData.getBannerData() == null || !inviteData.getBannerData().isBannerV2()) ? str : "BANNER_V2";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1659a(int i, int i2) {
        Button button = this.f1890d.getButton(i);
        button.setMaxLines(1);
        button.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = GravityCompat.END;
        button.setLayoutParams(layoutParams);
        button.setId(i2);
    }

    /* renamed from: a */
    private void m1660a(long j, String str, Reason reason, AnalyticsBridge.C3414c cVar) {
        AnalyticsBridge.getInstance().reportInterceptMechanismEvent(j, System.currentTimeMillis(), str, reason, cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1661a(C3717s2 s2Var) {
        String a = m1658a(this.f1887a);
        C3527g0.C3534d.m847a(C3527g0.C3534d.C3535a.interceptDeferred, this.f1888b, a, this.f1889c, s2Var);
        int i = C3741d.f1909a[this.f1889c.ordinal()];
        if (i == 1) {
            AnalyticsBridge.getInstance().reportPromptDeferredEvent(this.f1888b, a, s2Var);
        } else if (i == 2) {
            AnalyticsBridge.getInstance().reportInvitationDeferredEvent(this.f1888b, a, s2Var);
            m1678e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1665a(long j) {
        C3687r rVar;
        String str;
        Reason reason;
        if (!C3496e5.m699h().mo55354c()) {
            str = this.f1888b;
            reason = Reason.interceptDisabled;
        } else if (C3461c3.m562g().mo55271c()) {
            str = this.f1888b;
            reason = Reason.formOpened;
        } else {
            AlertDialog alertDialog = this.f1890d;
            if ((alertDialog == null || !alertDialog.isShowing()) && ((rVar = this.f1891e) == null || !rVar.mo55752p())) {
                return true;
            }
            str = this.f1888b;
            reason = Reason.invitationOpened;
        }
        m1660a(j, str, reason, AnalyticsBridge.C3414c.failure);
        return false;
    }

    /* renamed from: a */
    private boolean m1666a(BannerData bannerData, long j) {
        if (bannerData == null || TextUtils.isEmpty(bannerData.getInvitationBody()) || TextUtils.isEmpty(bannerData.getInvitationTitle())) {
            m1660a(j, this.f1888b, Reason.inviteDataMissing, AnalyticsBridge.C3414c.failure);
            return false;
        }
        try {
            ((Activity) C3595k3.m1060d().mo55514c().getBaseContext()).runOnUiThread(new C3733a(j, bannerData));
            return true;
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private boolean m1667a(InviteData inviteData, long j) {
        if (TextUtils.isEmpty(inviteData.getProvideButtonText()) || TextUtils.isEmpty(inviteData.getDeclineButtonText()) || TextUtils.isEmpty(inviteData.getLaterButtonText())) {
            m1660a(j, this.f1888b, Reason.inviteDataMissing, AnalyticsBridge.C3414c.failure);
            return false;
        }
        try {
            ((Activity) C3595k3.m1060d().mo55514c().getBaseContext()).runOnUiThread(new C3735b(j, inviteData));
            return true;
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    private void m1670b(long j) {
        AnalyticsBridge.C3414c cVar;
        Reason reason;
        String str;
        if (this.f1887a == null) {
            str = this.f1888b;
            reason = Reason.inviteDataMissing;
            cVar = AnalyticsBridge.C3414c.failure;
        } else if (C3595k3.m1060d().mo55514c() != null) {
            AlertDialog alertDialog = this.f1890d;
            if (alertDialog == null || !alertDialog.isShowing()) {
                if (this.f1887a.getType() != InviteData.C3415a.ALERT) {
                    if (!((!m1681g() || m1682h()) ? m1666a(this.f1887a.getBannerData(), j) : m1667a(this.f1887a, j))) {
                        return;
                    }
                } else if (!m1667a(this.f1887a, j)) {
                    return;
                }
                if (!this.f1894h) {
                    String a = m1658a(this.f1887a);
                    C3527g0.C3534d.m847a(C3527g0.C3534d.C3535a.interceptDisplayed, this.f1888b, a, this.f1889c, (C3717s2) null);
                    InviteData inviteData = this.f1887a;
                    boolean z = (inviteData == null || inviteData.getBannerData() == null || !this.f1887a.getBannerData().isButtonsDisplay()) ? false : true;
                    InviteData inviteData2 = this.f1887a;
                    C3717s2.C3721d dVar = (inviteData2 == null || inviteData2.getBannerData() == null || !this.f1887a.getBannerData().isSticky()) ? C3717s2.C3721d.f1846a : C3717s2.C3721d.StickyByConfiguration;
                    if (MDEngagementType.form.equals(this.f1889c)) {
                        AnalyticsBridge.getInstance().reportInvitationDisplayedEvent(this.f1888b, a, new C3717s2(dVar, z));
                    } else if (MDEngagementType.appRating.equals(this.f1889c)) {
                        AnalyticsBridge.getInstance().reportPromptDisplayedEvent(this.f1888b, a, new C3717s2(dVar, z));
                    }
                    str = this.f1888b;
                    cVar = AnalyticsBridge.C3414c.f832a;
                    reason = null;
                } else {
                    return;
                }
            } else {
                m1660a(j, this.f1888b, Reason.invitationOpened, AnalyticsBridge.C3414c.failure);
                return;
            }
        } else {
            m1660a(j, this.f1888b, Reason.formInBackground, AnalyticsBridge.C3414c.failure);
            return;
        }
        m1660a(j, str, reason, cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1671b(C3717s2 s2Var) {
        String a = m1658a(this.f1887a);
        C3527g0.C3534d.m847a(C3527g0.C3534d.C3535a.interceptDeclined, this.f1888b, a, this.f1889c, s2Var);
        int i = C3741d.f1909a[this.f1889c.ordinal()];
        if (i == 1) {
            AnalyticsBridge.getInstance().reportPromptDeclinedEvent(this.f1888b, a, s2Var);
            Intent intent = new Intent("com.medallia.digital.mobilesdk.AppRatingLastDeclineTimestampCollectorFilter");
            intent.putExtra("com.medallia.digital.mobilesdk.AppRatingLastDeclineTimestampCollector", System.currentTimeMillis());
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent);
        } else if (i == 2) {
            AnalyticsBridge.getInstance().reportInvitationDeclinedEvent(this.f1888b, a, s2Var);
            Intent intent2 = new Intent("com.medallia.digital.mobilesdk.LastDeclineTimestampCollectorFilter");
            intent2.putExtra("com.medallia.digital.mobilesdk.LastDeclineTimestampCollector", System.currentTimeMillis());
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent2);
            m1678e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1674c(C3717s2 s2Var) {
        String a = m1658a(this.f1887a);
        C3527g0.C3534d.m847a(C3527g0.C3534d.C3535a.interceptAccepted, this.f1888b, a, this.f1889c, s2Var);
        int i = C3741d.f1909a[this.f1889c.ordinal()];
        boolean z = true;
        if (i == 1) {
            AnalyticsBridge.getInstance().reportPromptAcceptedEvent(this.f1888b, a, s2Var);
            Intent intent = new Intent("com.medallia.digital.mobilesdk.AppRatingLastAcceptedTimestampCollectorFilter");
            intent.putExtra("com.medallia.digital.mobilesdk.AppRatingLastAcceptedTimestampCollector", System.currentTimeMillis());
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent);
            Context b = C3595k3.m1060d().mo55513b();
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(C1119C.ENCODING_PCM_MU_LAW);
            String str = f1886k + b.getPackageName();
            C3611m mVar = this.f1895i;
            if (!(mVar == null || mVar.mo55550b() == null)) {
                str = f1886k + this.f1895i.mo55550b();
            }
            intent2.setData(Uri.parse(str));
            b.startActivity(intent2);
        } else if (i == 2) {
            boolean z2 = false;
            ConfigurationContract a2 = C3715s0.m1612b().mo55792a();
            if (!(a2 == null || a2.getSdkConfiguration() == null || a2.getSdkConfiguration().getFormConfigurations() == null)) {
                z = a2.getSdkConfiguration().getFormConfigurations().isVulnEnabled();
                z2 = a2.getSdkConfiguration().getFormConfigurations().isInheritOrientation();
            }
            AnalyticsBridge.getInstance().reportInvitationAcceptedEvent(this.f1888b, a, s2Var);
            Context b2 = C3595k3.m1060d().mo55513b();
            C3433a2 b3 = C3552h2.m914h().mo55450b(this.f1888b);
            Intent intent3 = new Intent(b2, b3.getFormViewType() == FormViewType.modal ? MedalliaModalFormActivity.class : MedalliaFullFormActivity.class);
            intent3.putExtra("com.medallia.digital.mobilesdk.form_data", b3);
            intent3.putExtra("com.medallia.digital.mobilesdk.vuln_enabled", z);
            intent3.putExtra("com.medallia.digital.mobilesdk.inherit_orientation", z2);
            intent3.addFlags(C1119C.ENCODING_PCM_MU_LAW);
            b2.startActivity(intent3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m1678e() {
        C3740c cVar = new C3740c();
        try {
            ((Activity) C3595k3.m1060d().mo55514c().getBaseContext()).runOnUiThread(cVar);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            try {
                C3561h5.m954c().mo55466b().execute(cVar);
            } catch (Exception unused) {
                C3490e3.m663c(e.getMessage());
            }
        }
    }

    /* renamed from: f */
    private C3717s2.C3721d m1680f() {
        C3687r rVar = this.f1891e;
        if (rVar == null) {
            return null;
        }
        return rVar.mo55743i();
    }

    /* renamed from: g */
    private boolean m1681g() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) C3595k3.m1060d().mo55511a().getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    /* renamed from: h */
    private boolean m1682h() {
        ConfigurationContract a = C3715s0.m1612b().mo55792a();
        if (a == null || a.getSdkConfiguration() == null || a.getSdkConfiguration().getMedalliaDigitalBrain() == null) {
            return false;
        }
        return a.getSdkConfiguration().getMedalliaDigitalBrain().getEnableBannerForAccessibility();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55825a() {
        this.f1896j = true;
        try {
            if (this.f1890d != null) {
                if (this.f1890d.isShowing()) {
                    this.f1890d.dismiss();
                }
                this.f1890d = null;
            }
            if (this.f1891e != null && this.f1891e.mo55752p()) {
                this.f1892f = this.f1891e.mo55741g();
                this.f1893g = this.f1891e.mo55749o();
                this.f1891e.mo55735a();
                this.f1891e = null;
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55826a(C3717s2.C3720c cVar) {
        try {
            this.f1894h = false;
            this.f1896j = false;
            if (this.f1890d != null && this.f1890d.isShowing()) {
                this.f1890d.dismiss();
                this.f1890d = null;
                if (cVar != null) {
                    m1661a(new C3717s2((C3717s2.C3721d) null, cVar, false));
                }
            }
            if (this.f1891e != null && this.f1891e.mo55752p()) {
                boolean n = this.f1891e.mo55748n();
                this.f1891e.mo55735a();
                this.f1891e = null;
                if (cVar != null) {
                    m1661a(new C3717s2(m1680f(), cVar, n));
                }
            }
            this.f1892f = 0;
            this.f1893g = false;
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55827a(String str, MDEngagementType mDEngagementType, long j) {
        this.f1894h = true;
        try {
            if (this.f1890d != null) {
                this.f1890d = null;
            }
            if (this.f1891e != null && this.f1891e.mo55752p()) {
                this.f1892f = this.f1891e.mo55741g();
                this.f1893g = this.f1891e.mo55749o();
                this.f1891e.mo55735a();
                this.f1891e = null;
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        mo55829b(str, mDEngagementType, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public MDEngagementType mo55828b() {
        return this.f1889c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55829b(String str, MDEngagementType mDEngagementType, long j) {
        InviteData inviteData;
        this.f1889c = mDEngagementType;
        this.f1888b = str;
        this.f1896j = false;
        int i = C3741d.f1909a[this.f1889c.ordinal()];
        if (i == 1) {
            this.f1895i = C3552h2.m914h().mo55440a(str);
            C3611m mVar = this.f1895i;
            if (mVar != null) {
                inviteData = mVar.mo55551c();
            }
            m1660a(j, (String) null, Reason.inviteDataMissing, AnalyticsBridge.C3414c.failure);
            m1670b(j);
        } else if (i == 2) {
            C3433a2 b = C3552h2.m914h().mo55450b(str);
            if (b != null) {
                inviteData = b.getInviteData();
            }
            m1660a(j, (String) null, Reason.inviteDataMissing, AnalyticsBridge.C3414c.failure);
            m1670b(j);
        } else {
            return;
        }
        this.f1887a = inviteData;
        m1670b(j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo55830c() {
        return this.f1888b;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f1891e;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo55831d() {
        /*
            r1 = this;
            androidx.appcompat.app.AlertDialog r0 = r1.f1890d
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isShowing()
            if (r0 != 0) goto L_0x0018
        L_0x000a:
            com.medallia.digital.mobilesdk.r r0 = r1.f1891e
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.mo55752p()
            if (r0 != 0) goto L_0x0018
        L_0x0014:
            boolean r0 = r1.f1896j
            if (r0 == 0) goto L_0x001a
        L_0x0018:
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3732t2.mo55831d():boolean");
    }
}
