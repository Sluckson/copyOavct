package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import com.medallia.digital.mobilesdk.C3586j3;

/* renamed from: com.medallia.digital.mobilesdk.l2 */
class C3604l2 implements C3713r5 {

    /* renamed from: c */
    private static C3604l2 f1406c;

    /* renamed from: a */
    private C3580j f1407a;

    /* renamed from: b */
    private C3423a f1408b;

    C3604l2() {
    }

    /* renamed from: c */
    protected static C3604l2 m1115c() {
        if (f1406c == null) {
            f1406c = new C3604l2();
        }
        return f1406c;
    }

    /* renamed from: a */
    public C3423a mo55534a() {
        return this.f1408b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3586j3.C3587a mo55535a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1408b = ModelFactory.getInstance().createAccessToken(str);
            if (this.f1408b == null) {
                return C3586j3.C3587a.ACCESS_TOKEN_PARSE;
            }
            return null;
        }
        this.f1408b = null;
        return C3586j3.C3587a.ACCESS_TOKEN_EMPTY;
    }

    /* renamed from: a */
    public void mo55536a(C3423a aVar) {
        this.f1408b = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55537a(C3580j jVar) {
        this.f1407a = jVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3580j mo55538b() {
        return this.f1407a;
    }

    public void clearAndDisconnect() {
        this.f1407a = null;
        this.f1408b = null;
        f1406c = null;
    }
}
