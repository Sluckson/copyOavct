package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.medallia.digital.mobilesdk.C3527g0;

/* renamed from: com.medallia.digital.mobilesdk.g3 */
class C3540g3 extends C3443b0 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MDFormListenerV2 f1211a;

    /* renamed from: b */
    private BroadcastReceiver f1212b = new C3541a();

    /* renamed from: com.medallia.digital.mobilesdk.g3$a */
    class C3541a extends BroadcastReceiver {
        C3541a() {
        }

        public void onReceive(Context context, Intent intent) {
            long j;
            C3527g0.C3531c.C3532a aVar;
            Intent intent2 = intent;
            if (intent2 != null && "com.medallia.digital.mobilesdk.form_action".equals(intent.getAction())) {
                try {
                    long longExtra = intent2.getLongExtra("com.medallia.digital.mobilesdk.extra_timestamp", 0);
                    String stringExtra = intent2.getStringExtra("com.medallia.digital.mobilesdk.extra_form_id");
                    FormViewType formViewType = (FormViewType) intent2.getSerializableExtra("com.medallia.digital.mobilesdk.extra_form_view_type");
                    if (formViewType == null) {
                        formViewType = FormViewType.none;
                    }
                    FormViewType formViewType2 = formViewType;
                    FormTriggerType formTriggerType = (FormTriggerType) intent2.getSerializableExtra("com.medallia.digital.mobilesdk.extra_form_trigger_type");
                    long longExtra2 = intent2.getLongExtra("com.medallia.digital.mobilesdk.extra_form_time_to_display", 0);
                    C3527g0.C3531c.C3532a aVar2 = (C3527g0.C3531c.C3532a) intent2.getSerializableExtra("com.medallia.digital.mobilesdk.extra_option");
                    String stringExtra2 = intent2.getStringExtra("com.medallia.digital.mobilesdk.extra_form_url");
                    if (C3540g3.this.f1211a != null) {
                        if (aVar2 == C3527g0.C3531c.C3532a.formSubmitted) {
                            C3540g3.this.f1211a.onFormSubmitted(longExtra, stringExtra, formTriggerType);
                        } else if (aVar2 == C3527g0.C3531c.C3532a.formDismissed) {
                            C3540g3.this.f1211a.onFormDismissed(longExtra, stringExtra, formTriggerType);
                        } else if (aVar2 == C3527g0.C3531c.C3532a.formClosed) {
                            C3540g3.this.f1211a.onFormClosed(longExtra, stringExtra, formTriggerType);
                        } else if (aVar2 == C3527g0.C3531c.C3532a.formDisplayed) {
                            C3540g3.this.f1211a.onFormDisplayed(longExtra, stringExtra, formTriggerType);
                        } else {
                            if (aVar2 == C3527g0.C3531c.C3532a.formBlockedUrl) {
                                j = longExtra2;
                                aVar = aVar2;
                                C3540g3.this.f1211a.onFormLinkSelected(longExtra, stringExtra, formTriggerType, stringExtra2, true);
                            } else {
                                j = longExtra2;
                                aVar = aVar2;
                                if (aVar == C3527g0.C3531c.C3532a.formLinkSelected) {
                                    C3540g3.this.f1211a.onFormLinkSelected(longExtra, stringExtra, formTriggerType, stringExtra2, false);
                                }
                            }
                            C3540g3.this.m855a(aVar, stringExtra, formTriggerType, formViewType2, longExtra, j);
                        }
                    }
                    j = longExtra2;
                    aVar = aVar2;
                    C3540g3.this.m855a(aVar, stringExtra, formTriggerType, formViewType2, longExtra, j);
                } catch (Exception e) {
                    C3490e3.m663c(e.getMessage());
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.g3$b */
    class C3542b extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ C3527g0.C3531c.C3532a f1214a;

        /* renamed from: b */
        final /* synthetic */ String f1215b;

        /* renamed from: c */
        final /* synthetic */ FormTriggerType f1216c;

        /* renamed from: d */
        final /* synthetic */ long f1217d;

        /* renamed from: e */
        final /* synthetic */ FormViewType f1218e;

        /* renamed from: f */
        final /* synthetic */ long f1219f;

        C3542b(C3527g0.C3531c.C3532a aVar, String str, FormTriggerType formTriggerType, long j, FormViewType formViewType, long j2) {
            this.f1214a = aVar;
            this.f1215b = str;
            this.f1216c = formTriggerType;
            this.f1217d = j;
            this.f1218e = formViewType;
            this.f1219f = j2;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3527g0.C3531c.C3532a aVar = this.f1214a;
            if (aVar == C3527g0.C3531c.C3532a.formSubmitted) {
                AnalyticsBridge.getInstance().reportFormSubmittedEvent(this.f1215b, this.f1216c, this.f1217d, this.f1218e);
            } else if (aVar == C3527g0.C3531c.C3532a.formDismissed) {
                AnalyticsBridge.getInstance().reportFormDismissedEvent(this.f1215b, this.f1216c, this.f1218e);
            } else if (aVar == C3527g0.C3531c.C3532a.formClosed) {
                AnalyticsBridge.getInstance().reportFormClosedEvent(this.f1215b, this.f1216c, this.f1218e);
            } else if (aVar == C3527g0.C3531c.C3532a.formDisplayed) {
                AnalyticsBridge.getInstance().reportFormDisplayedEvent(this.f1215b, this.f1216c, this.f1218e, this.f1219f);
            }
            if (C3540g3.this.f1211a != null) {
                AnalyticsBridge.getInstance().reportSetFormCallbackEvent(this.f1214a.name(), this.f1215b, this.f1216c);
            }
        }
    }

    C3540g3() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m855a(C3527g0.C3531c.C3532a aVar, String str, FormTriggerType formTriggerType, FormViewType formViewType, long j, long j2) {
        C3561h5.m954c().mo55465a().execute(new C3542b(aVar, str, formTriggerType, j, formViewType, j2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55225a() {
        return "com.medallia.digital.mobilesdk.form_action";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55226a(Object obj) {
        if (this.f1211a != null && obj == null) {
            mo55230e();
        }
        if (obj instanceof MDFormListenerV2) {
            this.f1211a = (MDFormListenerV2) obj;
        }
        mo55229d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo55227b() {
        return this.f1211a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public BroadcastReceiver mo55228c() {
        return this.f1212b;
    }
}
