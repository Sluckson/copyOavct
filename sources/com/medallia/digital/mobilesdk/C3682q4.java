package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.q4 */
class C3682q4 extends C3677q1<C3683a> {

    /* renamed from: com.medallia.digital.mobilesdk.q4$a */
    enum C3683a {
        V1("V1"),
        V2("V2"),
        Unspecified("Unspecified");

        private C3683a(String str) {
            mo55734a(str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3683a mo55734a(String str) {
            if (str == null || str.isEmpty()) {
                return Unspecified;
            }
            String upperCase = str.toUpperCase();
            char c = 65535;
            int hashCode = upperCase.hashCode();
            if (hashCode != 2715) {
                if (hashCode == 2716 && upperCase.equals("V2")) {
                    c = 1;
                }
            } else if (upperCase.equals("V1")) {
                c = 0;
            }
            return c != 0 ? c != 1 ? Unspecified : V2 : V1;
        }
    }

    C3682q4(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55525a(C3683a aVar) {
        super.mo55525a(aVar);
        C3490e3.m661b(String.format(Locale.US, "Collectors > set SDK Analytics Version : %s", new Object[]{aVar.toString()}));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1745U;
    }
}
