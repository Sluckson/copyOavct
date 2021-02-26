package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3792y;

/* renamed from: com.medallia.digital.mobilesdk.f5 */
class C3525f5 extends C3792y {

    /* renamed from: c */
    private static final int f1140c = 31;

    /* renamed from: a */
    private String f1141a;

    /* renamed from: b */
    private String f1142b;

    protected C3525f5(String str, String str2) {
        this.f1142b = str;
        this.f1141a = str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55378a() {
        return this.f1142b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55379a(String str) {
        this.f1142b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo55380b() {
        return this.f1141a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55381b(String str) {
        this.f1141a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3525f5.class != obj.getClass()) {
            return false;
        }
        C3525f5 f5Var = (C3525f5) obj;
        String str = this.f1141a;
        if (str == null ? f5Var.f1141a != null : !str.equals(f5Var.f1141a)) {
            return false;
        }
        String str2 = this.f1142b;
        return str2 != null ? str2.equals(f5Var.f1142b) : f5Var.f1142b == null;
    }

    /* access modifiers changed from: protected */
    public C3792y.C3793a getDataTableObjectType() {
        return C3792y.C3793a.Template;
    }

    public int hashCode() {
        String str = this.f1141a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1142b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
