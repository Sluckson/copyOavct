package com.medallia.digital.mobilesdk;

import android.os.Build;
import android.text.TextUtils;
import com.medallia.digital.mobilesdk.C3697r0;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.medallia.digital.mobilesdk.f1 */
class C3518f1 extends C3493e4<String> {
    protected C3518f1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: a */
    private String m766a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (!z || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            } else {
                sb.append(Character.toUpperCase(c));
                z = false;
            }
        }
        return sb.toString();
    }

    /* renamed from: o */
    private String m767o() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str2.startsWith(str)) {
            return m766a(str2);
        }
        return m766a(str) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1749c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m770j() {
        String o = m767o();
        C3490e3.m661b(String.format("Collectors > Model: %s", new Object[]{o}));
        return o;
    }
}
