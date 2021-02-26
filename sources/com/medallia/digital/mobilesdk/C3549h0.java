package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3474d0;
import com.medallia.digital.mobilesdk.C3667p4;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.h0 */
class C3549h0 extends C3474d0<byte[]> {

    /* renamed from: com.medallia.digital.mobilesdk.h0$a */
    class C3550a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ byte[] f1235a;

        C3550a(byte[] bArr) {
            this.f1235a = bArr;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3490e3.m661b("Status: " + C3549h0.this.mo55301c());
            if (C3549h0.this.mo55300b() != null) {
                try {
                    C3549h0.this.mo55300b().mo55242a(new C3609l4(C3549h0.this.mo55301c(), this.f1235a));
                } catch (Exception e) {
                    C3490e3.m663c(e.getMessage());
                }
            }
        }
    }

    protected C3549h0(C3474d0.C3478d dVar, String str, HashMap<String, String> hashMap, int i, C3667p4.C3668a aVar) {
        super(dVar, str, hashMap, (JSONObject) null, i, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55210a(byte[] bArr) {
        C3561h5.m954c().mo55465a().execute(new C3550a(bArr));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public byte[] m895a(InputStream inputStream) {
        try {
            return C3802y5.m1953a(inputStream).toByteArray();
        } catch (Exception unused) {
            mo55298a(-44);
            return null;
        }
    }
}
