package com.salesforce.marketingcloud;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.InitializationStatus;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.a */
final class C3845a extends InitializationStatus {

    /* renamed from: a */
    private final InitializationStatus.Status f2188a;

    /* renamed from: b */
    private final Throwable f2189b;

    /* renamed from: c */
    private final boolean f2190c;

    /* renamed from: d */
    private final int f2191d;

    /* renamed from: e */
    private final String f2192e;

    /* renamed from: f */
    private final boolean f2193f;

    /* renamed from: g */
    private final boolean f2194g;

    /* renamed from: h */
    private final boolean f2195h;

    /* renamed from: i */
    private final boolean f2196i;

    /* renamed from: j */
    private final boolean f2197j;

    /* renamed from: k */
    private final List<String> f2198k;

    /* renamed from: com.salesforce.marketingcloud.a$a */
    static final class C3847a extends InitializationStatus.C3832a {

        /* renamed from: a */
        private InitializationStatus.Status f2199a;

        /* renamed from: b */
        private Throwable f2200b;

        /* renamed from: c */
        private Boolean f2201c;

        /* renamed from: d */
        private Integer f2202d;

        /* renamed from: e */
        private String f2203e;

        /* renamed from: f */
        private Boolean f2204f;

        /* renamed from: g */
        private Boolean f2205g;

        /* renamed from: h */
        private Boolean f2206h;

        /* renamed from: i */
        private Boolean f2207i;

        /* renamed from: j */
        private Boolean f2208j;

        /* renamed from: k */
        private List<String> f2209k;

        C3847a() {
        }

        /* renamed from: a */
        public InitializationStatus.C3832a mo56095a(int i) {
            this.f2202d = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public InitializationStatus.C3832a mo56096a(InitializationStatus.Status status) {
            if (status != null) {
                this.f2199a = status;
                return this;
            }
            throw new NullPointerException("Null status");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public InitializationStatus.C3832a mo56098a(String str) {
            this.f2203e = str;
            return this;
        }

        /* renamed from: a */
        public InitializationStatus.C3832a mo56099a(Throwable th) {
            this.f2200b = th;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public InitializationStatus.C3832a mo56100a(List<String> list) {
            if (list != null) {
                this.f2209k = list;
                return this;
            }
            throw new NullPointerException("Null initializedComponents");
        }

        /* renamed from: a */
        public InitializationStatus.C3832a mo56101a(boolean z) {
            this.f2201c = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: a */
        public Throwable mo56102a() {
            return this.f2200b;
        }

        /* renamed from: b */
        public InitializationStatus.C3832a mo56104b(boolean z) {
            this.f2204f = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: b */
        public boolean mo56105b() {
            Boolean bool = this.f2201c;
            if (bool != null) {
                return bool.booleanValue();
            }
            throw new IllegalStateException("Property \"locationsError\" has not been set");
        }

        /* renamed from: c */
        public int mo56106c() {
            Integer num = this.f2202d;
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalStateException("Property \"playServicesStatus\" has not been set");
        }

        /* renamed from: c */
        public InitializationStatus.C3832a mo56107c(boolean z) {
            this.f2205g = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: d */
        public InitializationStatus.C3832a mo56108d(boolean z) {
            this.f2206h = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo56109d() {
            Boolean bool = this.f2205g;
            if (bool != null) {
                return bool.booleanValue();
            }
            throw new IllegalStateException("Property \"storageError\" has not been set");
        }

        /* renamed from: e */
        public InitializationStatus.C3832a mo56110e(boolean z) {
            this.f2207i = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: e */
        public boolean mo56111e() {
            Boolean bool = this.f2206h;
            if (bool != null) {
                return bool.booleanValue();
            }
            throw new IllegalStateException("Property \"proximityError\" has not been set");
        }

        /* renamed from: f */
        public InitializationStatus.C3832a mo56112f(boolean z) {
            this.f2208j = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public boolean mo56113f() {
            Boolean bool = this.f2207i;
            if (bool != null) {
                return bool.booleanValue();
            }
            throw new IllegalStateException("Property \"messagingPermissionError\" has not been set");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public boolean mo56114g() {
            Boolean bool = this.f2208j;
            if (bool != null) {
                return bool.booleanValue();
            }
            throw new IllegalStateException("Property \"sslProviderEnablementError\" has not been set");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public InitializationStatus mo56115h() {
            String str = "";
            if (this.f2199a == null) {
                str = str + " status";
            }
            if (this.f2201c == null) {
                str = str + " locationsError";
            }
            if (this.f2202d == null) {
                str = str + " playServicesStatus";
            }
            if (this.f2204f == null) {
                str = str + " encryptionChanged";
            }
            if (this.f2205g == null) {
                str = str + " storageError";
            }
            if (this.f2206h == null) {
                str = str + " proximityError";
            }
            if (this.f2207i == null) {
                str = str + " messagingPermissionError";
            }
            if (this.f2208j == null) {
                str = str + " sslProviderEnablementError";
            }
            if (this.f2209k == null) {
                str = str + " initializedComponents";
            }
            if (str.isEmpty()) {
                return new C3845a(this.f2199a, this.f2200b, this.f2201c.booleanValue(), this.f2202d.intValue(), this.f2203e, this.f2204f.booleanValue(), this.f2205g.booleanValue(), this.f2206h.booleanValue(), this.f2207i.booleanValue(), this.f2208j.booleanValue(), this.f2209k);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private C3845a(InitializationStatus.Status status, @Nullable Throwable th, boolean z, int i, @Nullable String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, List<String> list) {
        this.f2188a = status;
        this.f2189b = th;
        this.f2190c = z;
        this.f2191d = i;
        this.f2192e = str;
        this.f2193f = z2;
        this.f2194g = z3;
        this.f2195h = z4;
        this.f2196i = z5;
        this.f2197j = z6;
        this.f2198k = list;
    }

    public boolean encryptionChanged() {
        return this.f2193f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r1 = r4.f2192e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.f2189b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.salesforce.marketingcloud.InitializationStatus
            r2 = 0
            if (r1 == 0) goto L_0x0088
            com.salesforce.marketingcloud.InitializationStatus r5 = (com.salesforce.marketingcloud.InitializationStatus) r5
            com.salesforce.marketingcloud.InitializationStatus$Status r1 = r4.f2188a
            com.salesforce.marketingcloud.InitializationStatus$Status r3 = r5.status()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0086
            java.lang.Throwable r1 = r4.f2189b
            if (r1 != 0) goto L_0x0022
            java.lang.Throwable r1 = r5.unrecoverableException()
            if (r1 != 0) goto L_0x0086
            goto L_0x002c
        L_0x0022:
            java.lang.Throwable r3 = r5.unrecoverableException()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0086
        L_0x002c:
            boolean r1 = r4.f2190c
            boolean r3 = r5.locationsError()
            if (r1 != r3) goto L_0x0086
            int r1 = r4.f2191d
            int r3 = r5.playServicesStatus()
            if (r1 != r3) goto L_0x0086
            java.lang.String r1 = r4.f2192e
            if (r1 != 0) goto L_0x0047
            java.lang.String r1 = r5.playServicesMessage()
            if (r1 != 0) goto L_0x0086
            goto L_0x0051
        L_0x0047:
            java.lang.String r3 = r5.playServicesMessage()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0086
        L_0x0051:
            boolean r1 = r4.f2193f
            boolean r3 = r5.encryptionChanged()
            if (r1 != r3) goto L_0x0086
            boolean r1 = r4.f2194g
            boolean r3 = r5.storageError()
            if (r1 != r3) goto L_0x0086
            boolean r1 = r4.f2195h
            boolean r3 = r5.proximityError()
            if (r1 != r3) goto L_0x0086
            boolean r1 = r4.f2196i
            boolean r3 = r5.messagingPermissionError()
            if (r1 != r3) goto L_0x0086
            boolean r1 = r4.f2197j
            boolean r3 = r5.sslProviderEnablementError()
            if (r1 != r3) goto L_0x0086
            java.util.List<java.lang.String> r1 = r4.f2198k
            java.util.List r5 = r5.initializedComponents()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r0 = 0
        L_0x0087:
            return r0
        L_0x0088:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.C3845a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (this.f2188a.hashCode() ^ 1000003) * 1000003;
        Throwable th = this.f2189b;
        int i = 0;
        int i2 = 1231;
        int hashCode2 = (((((hashCode ^ (th == null ? 0 : th.hashCode())) * 1000003) ^ (this.f2190c ? 1231 : 1237)) * 1000003) ^ this.f2191d) * 1000003;
        String str = this.f2192e;
        if (str != null) {
            i = str.hashCode();
        }
        int i3 = (((((((((hashCode2 ^ i) * 1000003) ^ (this.f2193f ? 1231 : 1237)) * 1000003) ^ (this.f2194g ? 1231 : 1237)) * 1000003) ^ (this.f2195h ? 1231 : 1237)) * 1000003) ^ (this.f2196i ? 1231 : 1237)) * 1000003;
        if (!this.f2197j) {
            i2 = 1237;
        }
        return ((i3 ^ i2) * 1000003) ^ this.f2198k.hashCode();
    }

    @NonNull
    public List<String> initializedComponents() {
        return this.f2198k;
    }

    public boolean locationsError() {
        return this.f2190c;
    }

    public boolean messagingPermissionError() {
        return this.f2196i;
    }

    @Nullable
    public String playServicesMessage() {
        return this.f2192e;
    }

    public int playServicesStatus() {
        return this.f2191d;
    }

    public boolean proximityError() {
        return this.f2195h;
    }

    public boolean sslProviderEnablementError() {
        return this.f2197j;
    }

    @NonNull
    public InitializationStatus.Status status() {
        return this.f2188a;
    }

    public boolean storageError() {
        return this.f2194g;
    }

    public String toString() {
        return "InitializationStatus{status=" + this.f2188a + ", unrecoverableException=" + this.f2189b + ", locationsError=" + this.f2190c + ", playServicesStatus=" + this.f2191d + ", playServicesMessage=" + this.f2192e + ", encryptionChanged=" + this.f2193f + ", storageError=" + this.f2194g + ", proximityError=" + this.f2195h + ", messagingPermissionError=" + this.f2196i + ", sslProviderEnablementError=" + this.f2197j + ", initializedComponents=" + this.f2198k + "}";
    }

    @Nullable
    public Throwable unrecoverableException() {
        return this.f2189b;
    }
}
