package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3474d0;
import com.medallia.digital.mobilesdk.C3667p4;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.a5 */
class C3438a5 extends C3474d0<String> {

    /* renamed from: com.medallia.digital.mobilesdk.a5$a */
    class C3439a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ String f903a;

        C3439a(String str) {
            this.f903a = str;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3490e3.m661b("Status: " + C3438a5.this.mo55301c());
            if (C3438a5.this.mo55300b() != null) {
                try {
                    C3438a5.this.mo55300b().mo55242a(new C3609l4(C3438a5.this.mo55301c(), this.f903a));
                } catch (Exception e) {
                    C3490e3.m663c(e.getMessage());
                }
            }
        }
    }

    protected C3438a5(C3474d0.C3478d dVar, String str, HashMap<String, String> hashMap, JSONObject jSONObject, int i, C3667p4.C3668a aVar) {
        super(dVar, str, hashMap, jSONObject, i, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String m467a(InputStream inputStream) {
        try {
            return C3802y5.m1953a(inputStream).toString("UTF-8");
        } catch (Exception unused) {
            mo55298a(-44);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55210a(String str) {
        C3561h5.m954c().mo55465a().execute(new C3439a(str));
    }
}
