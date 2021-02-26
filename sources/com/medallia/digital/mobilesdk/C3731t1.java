package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3792y;

/* renamed from: com.medallia.digital.mobilesdk.t1 */
class C3731t1 extends C3792y {

    /* renamed from: g */
    private static final int f1879g = 31;

    /* renamed from: a */
    private String f1880a;

    /* renamed from: b */
    private String f1881b;

    /* renamed from: c */
    private String f1882c;

    /* renamed from: d */
    private FormTriggerType f1883d;

    /* renamed from: e */
    private long f1884e;

    /* renamed from: f */
    private int f1885f;

    C3731t1(String str, String str2, String str3, FormTriggerType formTriggerType, long j, int i) {
        this.f1880a = str;
        this.f1881b = str2;
        this.f1882c = str3;
        this.f1883d = formTriggerType;
        this.f1884e = j;
        this.f1885f = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55815a() {
        return this.f1880a;
    }

    /* renamed from: a */
    public void mo55816a(String str) {
        this.f1880a = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo55817b() {
        return this.f1881b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public FormTriggerType mo55818c() {
        return this.f1883d;
    }

    /* renamed from: d */
    public int mo55819d() {
        return this.f1885f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public long mo55820e() {
        return this.f1884e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3731t1.class != obj.getClass()) {
            return false;
        }
        C3731t1 t1Var = (C3731t1) obj;
        String str = this.f1880a;
        if (str == null ? t1Var.f1880a != null : !str.equals(t1Var.f1880a)) {
            return false;
        }
        String str2 = this.f1881b;
        if (str2 == null ? t1Var.f1881b != null : !str2.equals(t1Var.f1881b)) {
            return false;
        }
        String str3 = this.f1882c;
        if (str3 == null ? t1Var.f1882c == null : str3.equals(t1Var.f1882c)) {
            return this.f1884e == t1Var.f1884e && this.f1885f == t1Var.f1885f && this.f1883d.ordinal() == t1Var.f1883d.ordinal();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo55822f() {
        this.f1885f++;
    }

    /* access modifiers changed from: protected */
    public C3792y.C3793a getDataTableObjectType() {
        return C3792y.C3793a.Feedback;
    }

    /* access modifiers changed from: protected */
    public String getFormId() {
        return this.f1882c;
    }

    public int hashCode() {
        String str = this.f1882c;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1880a;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f1881b;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f1882c;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.f1883d.hashCode();
    }
}
