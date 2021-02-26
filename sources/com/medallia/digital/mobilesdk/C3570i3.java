package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.medallia.digital.mobilesdk.i3 */
class C3570i3 extends C3443b0 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3765v5 f1287a;

    /* renamed from: b */
    private BroadcastReceiver f1288b = new C3571a();

    /* renamed from: com.medallia.digital.mobilesdk.i3$a */
    class C3571a extends BroadcastReceiver {

        /* renamed from: com.medallia.digital.mobilesdk.i3$a$a */
        class C3572a extends C3666p3 {

            /* renamed from: a */
            final /* synthetic */ Intent f1290a;

            C3572a(Intent intent) {
                this.f1290a = intent;
            }

            /* renamed from: a */
            public void mo55177a() {
                Intent intent = this.f1290a;
                if (intent != null && "com.medallia.digital.mobilesdk.sync_userjourney_action".equals(intent.getAction()) && C3570i3.this.f1287a != null) {
                    C3570i3.this.f1287a.mo55562a();
                }
            }
        }

        C3571a() {
        }

        public void onReceive(Context context, Intent intent) {
            C3561h5.m954c().mo55465a().execute(new C3572a(intent));
        }
    }

    C3570i3() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55225a() {
        return "com.medallia.digital.mobilesdk.sync_userjourney_action";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55226a(Object obj) {
        if (this.f1287a != null && obj == null) {
            mo55230e();
        }
        if (obj instanceof C3765v5) {
            this.f1287a = (C3765v5) obj;
        }
        mo55229d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo55227b() {
        return this.f1287a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public BroadcastReceiver mo55228c() {
        return this.f1288b;
    }
}
