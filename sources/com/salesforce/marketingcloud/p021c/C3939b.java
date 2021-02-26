package com.salesforce.marketingcloud.p021c;

import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.p021c.C3946e;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.c.b */
final class C3939b extends C3946e {

    /* renamed from: e */
    private final String f2502e;

    /* renamed from: f */
    private final String f2503f;

    /* renamed from: g */
    private final long f2504g;

    /* renamed from: h */
    private final String f2505h;

    /* renamed from: i */
    private final boolean f2506i;

    /* renamed from: j */
    private final String f2507j;

    /* renamed from: k */
    private final List<String> f2508k;

    /* renamed from: l */
    private final C3944d f2509l;

    /* renamed from: com.salesforce.marketingcloud.c.b$a */
    static final class C3941a extends C3946e.C3947a {

        /* renamed from: a */
        private String f2510a;

        /* renamed from: b */
        private String f2511b;

        /* renamed from: c */
        private Long f2512c;

        /* renamed from: d */
        private String f2513d;

        /* renamed from: e */
        private Boolean f2514e;

        /* renamed from: f */
        private String f2515f;

        /* renamed from: g */
        private List<String> f2516g;

        /* renamed from: h */
        private C3944d f2517h;

        C3941a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3946e.C3947a mo56386a(long j) {
            this.f2512c = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C3946e.C3947a mo56387a(C3944d dVar) {
            if (dVar != null) {
                this.f2517h = dVar;
                return this;
            }
            throw new NullPointerException("Null requestId");
        }

        /* renamed from: a */
        public C3946e.C3947a mo56388a(String str) {
            if (str != null) {
                this.f2510a = str;
                return this;
            }
            throw new NullPointerException("Null method");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3946e.C3947a mo56389a(List<String> list) {
            if (list != null) {
                this.f2516g = list;
                return this;
            }
            throw new NullPointerException("Null headers");
        }

        /* renamed from: a */
        public C3946e.C3947a mo56390a(boolean z) {
            this.f2514e = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: a */
        public String mo56391a() {
            return this.f2511b;
        }

        /* renamed from: b */
        public C3946e.C3947a mo56392b(String str) {
            this.f2511b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C3946e mo56393b() {
            String str = "";
            if (this.f2510a == null) {
                str = str + " method";
            }
            if (this.f2512c == null) {
                str = str + " connectionTimeout";
            }
            if (this.f2513d == null) {
                str = str + " contentType";
            }
            if (this.f2514e == null) {
                str = str + " gzipRequest";
            }
            if (this.f2515f == null) {
                str = str + " url";
            }
            if (this.f2516g == null) {
                str = str + " headers";
            }
            if (this.f2517h == null) {
                str = str + " requestId";
            }
            if (str.isEmpty()) {
                return new C3939b(this.f2510a, this.f2511b, this.f2512c.longValue(), this.f2513d, this.f2514e.booleanValue(), this.f2515f, this.f2516g, this.f2517h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* renamed from: c */
        public C3946e.C3947a mo56394c(String str) {
            if (str != null) {
                this.f2513d = str;
                return this;
            }
            throw new NullPointerException("Null contentType");
        }

        /* renamed from: d */
        public C3946e.C3947a mo56395d(String str) {
            if (str != null) {
                this.f2515f = str;
                return this;
            }
            throw new NullPointerException("Null url");
        }
    }

    private C3939b(String str, @Nullable String str2, long j, String str3, boolean z, String str4, List<String> list, C3944d dVar) {
        this.f2502e = str;
        this.f2503f = str2;
        this.f2504g = j;
        this.f2505h = str3;
        this.f2506i = z;
        this.f2507j = str4;
        this.f2508k = list;
        this.f2509l = dVar;
    }

    /* renamed from: a */
    public String mo56375a() {
        return this.f2502e;
    }

    @Nullable
    /* renamed from: b */
    public String mo56376b() {
        return this.f2503f;
    }

    /* renamed from: c */
    public long mo56377c() {
        return this.f2504g;
    }

    /* renamed from: d */
    public String mo56378d() {
        return this.f2505h;
    }

    /* renamed from: e */
    public boolean mo56379e() {
        return this.f2506i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r7.f2503f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.salesforce.marketingcloud.p021c.C3946e
            r2 = 0
            if (r1 == 0) goto L_0x0071
            com.salesforce.marketingcloud.c.e r8 = (com.salesforce.marketingcloud.p021c.C3946e) r8
            java.lang.String r1 = r7.f2502e
            java.lang.String r3 = r8.mo56375a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x006f
            java.lang.String r1 = r7.f2503f
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = r8.mo56376b()
            if (r1 != 0) goto L_0x006f
            goto L_0x002c
        L_0x0022:
            java.lang.String r3 = r8.mo56376b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x006f
        L_0x002c:
            long r3 = r7.f2504g
            long r5 = r8.mo56377c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x006f
            java.lang.String r1 = r7.f2505h
            java.lang.String r3 = r8.mo56378d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x006f
            boolean r1 = r7.f2506i
            boolean r3 = r8.mo56379e()
            if (r1 != r3) goto L_0x006f
            java.lang.String r1 = r7.f2507j
            java.lang.String r3 = r8.mo56381f()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x006f
            java.util.List<java.lang.String> r1 = r7.f2508k
            java.util.List r3 = r8.mo56382g()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x006f
            com.salesforce.marketingcloud.c.d r1 = r7.f2509l
            com.salesforce.marketingcloud.c.d r8 = r8.mo56383h()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            return r0
        L_0x0071:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.p021c.C3939b.equals(java.lang.Object):boolean");
    }

    /* renamed from: f */
    public String mo56381f() {
        return this.f2507j;
    }

    /* renamed from: g */
    public List<String> mo56382g() {
        return this.f2508k;
    }

    /* renamed from: h */
    public C3944d mo56383h() {
        return this.f2509l;
    }

    public int hashCode() {
        int hashCode = (this.f2502e.hashCode() ^ 1000003) * 1000003;
        String str = this.f2503f;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j = this.f2504g;
        return ((((((((((((hashCode ^ hashCode2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f2505h.hashCode()) * 1000003) ^ (this.f2506i ? 1231 : 1237)) * 1000003) ^ this.f2507j.hashCode()) * 1000003) ^ this.f2508k.hashCode()) * 1000003) ^ this.f2509l.hashCode();
    }

    public String toString() {
        return "Request{method=" + this.f2502e + ", requestBody=" + this.f2503f + ", connectionTimeout=" + this.f2504g + ", contentType=" + this.f2505h + ", gzipRequest=" + this.f2506i + ", url=" + this.f2507j + ", headers=" + this.f2508k + ", requestId=" + this.f2509l + "}";
    }
}
