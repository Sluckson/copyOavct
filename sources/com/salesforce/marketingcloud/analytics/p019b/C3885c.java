package com.salesforce.marketingcloud.analytics.p019b;

import com.salesforce.marketingcloud.analytics.p019b.C3896n;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.analytics.b.c */
abstract class C3885c extends C3896n.C3897a {

    /* renamed from: a */
    private final boolean f2287a;

    /* renamed from: b */
    private final List<String> f2288b;

    C3885c(boolean z, List<String> list) {
        this.f2287a = z;
        if (list != null) {
            this.f2288b = list;
            return;
        }
        throw new NullPointerException("Null objectIds");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo56273a() {
        return this.f2287a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<String> mo56274b() {
        return this.f2288b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3896n.C3897a)) {
            return false;
        }
        C3896n.C3897a aVar = (C3896n.C3897a) obj;
        return this.f2287a == aVar.mo56273a() && this.f2288b.equals(aVar.mo56274b());
    }

    public int hashCode() {
        return (((this.f2287a ? 1231 : 1237) ^ 1000003) * 1000003) ^ this.f2288b.hashCode();
    }

    public String toString() {
        return "EventDetails{openFromPush=" + this.f2287a + ", objectIds=" + this.f2288b + "}";
    }
}
