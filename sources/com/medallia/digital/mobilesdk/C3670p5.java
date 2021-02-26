package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import com.medallia.digital.mobilesdk.C3667p4;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.p5 */
class C3670p5 {

    /* renamed from: a */
    private C3667p4 f1627a;

    /* renamed from: b */
    private String f1628b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C3667p4.C3668a f1629c;

    /* renamed from: com.medallia.digital.mobilesdk.p5$a */
    class C3671a implements C3667p4.C3668a {
        C3671a() {
        }

        /* renamed from: a */
        public void mo55240a() {
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            if (C3670p5.this.f1629c != null) {
                C3670p5.this.f1629c.mo55241a(j4Var);
            }
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            if (C3670p5.this.f1629c != null) {
                C3670p5.this.f1629c.mo55242a(l4Var);
            }
        }
    }

    C3670p5(C3667p4 p4Var, String str) {
        this.f1627a = p4Var;
        this.f1628b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55705a(C3667p4.C3668a aVar) {
        this.f1629c = aVar;
        if (TextUtils.isEmpty(this.f1628b)) {
            C3667p4.C3668a aVar2 = this.f1629c;
            if (aVar2 != null) {
                aVar2.mo55241a((C3588j4) null);
                return;
            }
            return;
        }
        this.f1627a.mo55698a(this.f1628b, (HashMap<String, String>) null, (HashMap<String, String>) null, new C3671a());
    }
}
