package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.medallia.digital.mobilesdk.C3527g0;

/* renamed from: com.medallia.digital.mobilesdk.f3 */
public class C3520f3 extends C3443b0 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MDFeedbackListener f1130a;

    /* renamed from: b */
    private BroadcastReceiver f1131b = new C3521a();

    /* renamed from: com.medallia.digital.mobilesdk.f3$a */
    class C3521a extends BroadcastReceiver {
        C3521a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.medallia.digital.mobilesdk.feedback_action".equals(intent.getAction())) {
                long longExtra = intent.getLongExtra("com.medallia.digital.mobilesdk.extra_timestamp", 0);
                String stringExtra = intent.getStringExtra("com.medallia.digital.mobilesdk.extra_form_id");
                FormTriggerType formTriggerType = (FormTriggerType) intent.getSerializableExtra("com.medallia.digital.mobilesdk.extra_form_trigger_type");
                C3527g0.C3531c.C3532a aVar = (C3527g0.C3531c.C3532a) intent.getSerializableExtra("com.medallia.digital.mobilesdk.extra_option");
                String stringExtra2 = intent.getStringExtra("com.medallia.digital.mobilesdk.extra_feedback_payload");
                String stringExtra3 = intent.getStringExtra("com.medallia.digital.mobilesdk.extra_feedback_id");
                if (aVar == C3527g0.C3531c.C3532a.feedbackPayload && C3520f3.this.f1130a != null) {
                    C3520f3.this.f1130a.onFeedbackSubmitted(stringExtra3, longExtra, stringExtra2);
                }
                if (C3520f3.this.f1130a != null) {
                    AnalyticsBridge.getInstance().reportSetFeedbackCallbackEvent(aVar.name(), stringExtra, formTriggerType, stringExtra3);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55225a() {
        return "com.medallia.digital.mobilesdk.feedback_action";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55226a(Object obj) {
        if (this.f1130a != null && obj == null) {
            mo55230e();
        }
        if (obj instanceof MDFeedbackListener) {
            this.f1130a = (MDFeedbackListener) obj;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo55227b() {
        return this.f1130a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public BroadcastReceiver mo55228c() {
        return this.f1131b;
    }
}
