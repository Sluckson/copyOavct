package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.MDExternalError;

/* renamed from: com.medallia.digital.mobilesdk.p2 */
class C3665p2 extends MedalliaDigitalError {

    /* renamed from: a */
    private MDExternalError f1614a;

    protected C3665p2(int i, MDExternalError.ExternalError externalError, String str) {
        super(i, str);
        this.f1614a = externalError != null ? new MDExternalError(externalError) : null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MDExternalError mo55691a() {
        return this.f1614a;
    }
}
