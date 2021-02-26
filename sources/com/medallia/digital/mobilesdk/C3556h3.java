package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.medallia.digital.mobilesdk.C3527g0;

/* renamed from: com.medallia.digital.mobilesdk.h3 */
class C3556h3 extends C3443b0 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MDInterceptListener f1257a;

    /* renamed from: b */
    private BroadcastReceiver f1258b = new C3557a();

    /* renamed from: com.medallia.digital.mobilesdk.h3$a */
    class C3557a extends BroadcastReceiver {
        C3557a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && C3556h3.this.mo55225a().equals(intent.getAction())) {
                try {
                    String stringExtra = intent.getStringExtra("com.medallia.digital.mobilesdk.extra_id");
                    long longExtra = intent.getLongExtra("com.medallia.digital.mobilesdk.extra_timestamp", 0);
                    C3717s2 s2Var = (C3717s2) intent.getParcelableExtra("com.medallia.digital.mobilesdk.extra_reason");
                    String stringExtra2 = intent.getStringExtra("com.medallia.digital.mobilesdk.extra_invite_type");
                    MDEngagementType mDEngagementType = (MDEngagementType) intent.getSerializableExtra("com.medallia.digital.mobilesdk.extra_engagement_type");
                    C3527g0.C3534d.C3535a aVar = (C3527g0.C3534d.C3535a) intent.getSerializableExtra("com.medallia.digital.mobilesdk.extra_intercept_command");
                    if (C3556h3.this.f1257a != null) {
                        if (C3527g0.C3534d.C3535a.interceptAccepted == aVar) {
                            C3556h3.this.f1257a.onInterceptAccepted(longExtra, stringExtra, mDEngagementType);
                        } else if (C3527g0.C3534d.C3535a.interceptDeclined == aVar) {
                            C3556h3.this.f1257a.onInterceptDeclined(longExtra, stringExtra, mDEngagementType);
                        } else if (C3527g0.C3534d.C3535a.interceptDeferred == aVar) {
                            C3556h3.this.f1257a.onInterceptDeferred(longExtra, stringExtra, s2Var.mo55797a(), mDEngagementType);
                        } else if (C3527g0.C3534d.C3535a.interceptDisplayed == aVar) {
                            C3556h3.this.f1257a.onInterceptDisplayed(longExtra, stringExtra, mDEngagementType);
                        }
                    }
                    C3556h3.this.m944a(aVar, stringExtra, stringExtra2, mDEngagementType, s2Var);
                } catch (Exception e) {
                    C3490e3.m663c(e.getMessage());
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.h3$b */
    class C3558b extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ C3527g0.C3534d.C3535a f1260a;

        /* renamed from: b */
        final /* synthetic */ String f1261b;

        /* renamed from: c */
        final /* synthetic */ String f1262c;

        /* renamed from: d */
        final /* synthetic */ MDEngagementType f1263d;

        /* renamed from: e */
        final /* synthetic */ C3717s2 f1264e;

        C3558b(C3527g0.C3534d.C3535a aVar, String str, String str2, MDEngagementType mDEngagementType, C3717s2 s2Var) {
            this.f1260a = aVar;
            this.f1261b = str;
            this.f1262c = str2;
            this.f1263d = mDEngagementType;
            this.f1264e = s2Var;
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3556h3.this.f1257a != null) {
                AnalyticsBridge.getInstance().reportSetInterceptCallbackEvent(this.f1260a.name(), this.f1261b, this.f1262c, this.f1263d.toString(), this.f1264e);
            }
        }
    }

    C3556h3() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m944a(C3527g0.C3534d.C3535a aVar, String str, String str2, MDEngagementType mDEngagementType, C3717s2 s2Var) {
        C3561h5.m954c().mo55465a().execute(new C3558b(aVar, str, str2, mDEngagementType, s2Var));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55225a() {
        return "com.medallia.digital.mobilesdk.intercept_action";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55226a(Object obj) {
        if (this.f1257a != null && obj == null) {
            mo55230e();
        }
        if (obj instanceof MDInterceptListener) {
            this.f1257a = (MDInterceptListener) obj;
        }
        mo55229d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo55227b() {
        return this.f1257a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public BroadcastReceiver mo55228c() {
        return this.f1258b;
    }
}
