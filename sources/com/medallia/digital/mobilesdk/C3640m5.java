package com.medallia.digital.mobilesdk;

/* renamed from: com.medallia.digital.mobilesdk.m5 */
enum C3640m5 {
    Fade("fade"),
    SlideDown("slideDown"),
    SlideUp("slideUp"),
    SlideLeft("slideLeft"),
    SlideRight("slideRight"),
    f1506g("none");
    

    /* renamed from: a */
    private String f1508a;

    private C3640m5(String str) {
        this.f1508a = str;
    }

    /* renamed from: a */
    protected static C3640m5 m1268a(String str) {
        if (str == null) {
            return Fade;
        }
        for (C3640m5 m5Var : values()) {
            if (m5Var.mo55598a().equals(str)) {
                return m5Var;
            }
        }
        C3490e3.m666f("Unsupported transition type");
        return Fade;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55598a() {
        return this.f1508a;
    }
}
