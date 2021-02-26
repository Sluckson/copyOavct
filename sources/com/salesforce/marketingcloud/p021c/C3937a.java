package com.salesforce.marketingcloud.p021c;

import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.p021c.C3953g;
import java.util.List;
import java.util.Map;

/* renamed from: com.salesforce.marketingcloud.c.a */
abstract class C3937a extends C3953g {

    /* renamed from: a */
    private final String f2490a;

    /* renamed from: b */
    private final String f2491b;

    /* renamed from: c */
    private final int f2492c;

    /* renamed from: d */
    private final long f2493d;

    /* renamed from: e */
    private final long f2494e;

    /* renamed from: f */
    private final Map<String, List<String>> f2495f;

    /* renamed from: com.salesforce.marketingcloud.c.a$a */
    static final class C3938a extends C3953g.C3954a {

        /* renamed from: a */
        private String f2496a;

        /* renamed from: b */
        private String f2497b;

        /* renamed from: c */
        private Integer f2498c;

        /* renamed from: d */
        private Long f2499d;

        /* renamed from: e */
        private Long f2500e;

        /* renamed from: f */
        private Map<String, List<String>> f2501f;

        C3938a() {
        }

        /* renamed from: a */
        public C3953g.C3954a mo56368a(int i) {
            this.f2498c = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public C3953g.C3954a mo56369a(long j) {
            this.f2499d = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C3953g.C3954a mo56370a(String str) {
            this.f2496a = str;
            return this;
        }

        /* renamed from: a */
        public C3953g.C3954a mo56371a(Map<String, List<String>> map) {
            this.f2501f = map;
            return this;
        }

        /* renamed from: a */
        public C3953g mo56372a() {
            String str = "";
            if (this.f2498c == null) {
                str = str + " code";
            }
            if (this.f2499d == null) {
                str = str + " startTimeMillis";
            }
            if (this.f2500e == null) {
                str = str + " endTimeMillis";
            }
            if (str.isEmpty()) {
                return new C3942c(this.f2496a, this.f2497b, this.f2498c.intValue(), this.f2499d.longValue(), this.f2500e.longValue(), this.f2501f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* renamed from: b */
        public C3953g.C3954a mo56373b(long j) {
            this.f2500e = Long.valueOf(j);
            return this;
        }

        /* renamed from: b */
        public C3953g.C3954a mo56374b(String str) {
            this.f2497b = str;
            return this;
        }
    }

    C3937a(@Nullable String str, @Nullable String str2, int i, long j, long j2, @Nullable Map<String, List<String>> map) {
        this.f2490a = str;
        this.f2491b = str2;
        this.f2492c = i;
        this.f2493d = j;
        this.f2494e = j2;
        this.f2495f = map;
    }

    @Nullable
    /* renamed from: a */
    public String mo56359a() {
        return this.f2490a;
    }

    @Nullable
    /* renamed from: b */
    public String mo56360b() {
        return this.f2491b;
    }

    /* renamed from: c */
    public int mo56361c() {
        return this.f2492c;
    }

    /* renamed from: d */
    public long mo56362d() {
        return this.f2493d;
    }

    /* renamed from: e */
    public long mo56363e() {
        return this.f2494e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3953g)) {
            return false;
        }
        C3953g gVar = (C3953g) obj;
        String str = this.f2490a;
        if (str != null ? str.equals(gVar.mo56359a()) : gVar.mo56359a() == null) {
            String str2 = this.f2491b;
            if (str2 != null ? str2.equals(gVar.mo56360b()) : gVar.mo56360b() == null) {
                if (this.f2492c == gVar.mo56361c() && this.f2493d == gVar.mo56362d() && this.f2494e == gVar.mo56363e()) {
                    Map<String, List<String>> map = this.f2495f;
                    if (map == null) {
                        if (gVar.mo56365f() == null) {
                            return true;
                        }
                    } else if (map.equals(gVar.mo56365f())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: f */
    public Map<String, List<String>> mo56365f() {
        return this.f2495f;
    }

    public int hashCode() {
        String str = this.f2490a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f2491b;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        long j = this.f2493d;
        long j2 = this.f2494e;
        int i2 = (((((((hashCode ^ hashCode2) * 1000003) ^ this.f2492c) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        Map<String, List<String>> map = this.f2495f;
        if (map != null) {
            i = map.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        return "Response{body=" + this.f2490a + ", message=" + this.f2491b + ", code=" + this.f2492c + ", startTimeMillis=" + this.f2493d + ", endTimeMillis=" + this.f2494e + ", headers=" + this.f2495f + "}";
    }
}
