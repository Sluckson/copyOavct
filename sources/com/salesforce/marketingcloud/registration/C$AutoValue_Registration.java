package com.salesforce.marketingcloud.registration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.registration.Registration;
import java.util.Map;
import java.util.Set;

/* renamed from: com.salesforce.marketingcloud.registration.$AutoValue_Registration  reason: invalid class name */
abstract class C$AutoValue_Registration extends Registration {

    /* renamed from: a */
    private final String f3358a;

    /* renamed from: b */
    private final String f3359b;

    /* renamed from: c */
    private final String f3360c;

    /* renamed from: d */
    private final String f3361d;

    /* renamed from: e */
    private final String f3362e;

    /* renamed from: f */
    private final boolean f3363f;

    /* renamed from: g */
    private final boolean f3364g;

    /* renamed from: h */
    private final boolean f3365h;

    /* renamed from: i */
    private final String f3366i;

    /* renamed from: j */
    private final boolean f3367j;

    /* renamed from: k */
    private final int f3368k;

    /* renamed from: l */
    private final String f3369l;

    /* renamed from: m */
    private final String f3370m;

    /* renamed from: n */
    private final String f3371n;

    /* renamed from: o */
    private final String f3372o;

    /* renamed from: p */
    private final String f3373p;

    /* renamed from: q */
    private final Set<String> f3374q;

    /* renamed from: r */
    private final Map<String, String> f3375r;

    /* renamed from: com.salesforce.marketingcloud.registration.$AutoValue_Registration$a */
    static final class C4127a extends Registration.C4128a {

        /* renamed from: a */
        private String f3376a;

        /* renamed from: b */
        private String f3377b;

        /* renamed from: c */
        private String f3378c;

        /* renamed from: d */
        private String f3379d;

        /* renamed from: e */
        private String f3380e;

        /* renamed from: f */
        private Boolean f3381f;

        /* renamed from: g */
        private Boolean f3382g;

        /* renamed from: h */
        private Boolean f3383h;

        /* renamed from: i */
        private String f3384i;

        /* renamed from: j */
        private Boolean f3385j;

        /* renamed from: k */
        private Integer f3386k;

        /* renamed from: l */
        private String f3387l;

        /* renamed from: m */
        private String f3388m;

        /* renamed from: n */
        private String f3389n;

        /* renamed from: o */
        private String f3390o;

        /* renamed from: p */
        private String f3391p;

        /* renamed from: q */
        private Set<String> f3392q;

        /* renamed from: r */
        private Map<String, String> f3393r;

        C4127a() {
        }

        private C4127a(Registration registration) {
            this.f3376a = registration.signedString();
            this.f3377b = registration.deviceId();
            this.f3378c = registration.systemToken();
            this.f3379d = registration.sdkVersion();
            this.f3380e = registration.appVersion();
            this.f3381f = Boolean.valueOf(registration.dst());
            this.f3382g = Boolean.valueOf(registration.locationEnabled());
            this.f3383h = Boolean.valueOf(registration.proximityEnabled());
            this.f3384i = registration.platformVersion();
            this.f3385j = Boolean.valueOf(registration.pushEnabled());
            this.f3386k = Integer.valueOf(registration.timeZone());
            this.f3387l = registration.contactKey();
            this.f3388m = registration.platform();
            this.f3389n = registration.hwid();
            this.f3390o = registration.appId();
            this.f3391p = registration.locale();
            this.f3392q = registration.tags();
            this.f3393r = registration.attributes();
        }

        /* renamed from: a */
        public Registration.C4128a mo56955a(int i) {
            this.f3386k = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public Registration.C4128a mo56956a(String str) {
            this.f3376a = str;
            return this;
        }

        /* renamed from: a */
        public Registration.C4128a mo56957a(Map<String, String> map) {
            if (map != null) {
                this.f3393r = map;
                return this;
            }
            throw new NullPointerException("Null attributes");
        }

        /* renamed from: a */
        public Registration.C4128a mo56958a(Set<String> set) {
            if (set != null) {
                this.f3392q = set;
                return this;
            }
            throw new NullPointerException("Null tags");
        }

        /* renamed from: a */
        public Registration.C4128a mo56959a(boolean z) {
            this.f3381f = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Registration mo56960a() {
            String str = "";
            if (this.f3377b == null) {
                str = str + " deviceId";
            }
            if (this.f3379d == null) {
                str = str + " sdkVersion";
            }
            if (this.f3380e == null) {
                str = str + " appVersion";
            }
            if (this.f3381f == null) {
                str = str + " dst";
            }
            if (this.f3382g == null) {
                str = str + " locationEnabled";
            }
            if (this.f3383h == null) {
                str = str + " proximityEnabled";
            }
            if (this.f3384i == null) {
                str = str + " platformVersion";
            }
            if (this.f3385j == null) {
                str = str + " pushEnabled";
            }
            if (this.f3386k == null) {
                str = str + " timeZone";
            }
            if (this.f3388m == null) {
                str = str + " platform";
            }
            if (this.f3389n == null) {
                str = str + " hwid";
            }
            if (this.f3390o == null) {
                str = str + " appId";
            }
            if (this.f3391p == null) {
                str = str + " locale";
            }
            if (this.f3392q == null) {
                str = str + " tags";
            }
            if (this.f3393r == null) {
                str = str + " attributes";
            }
            if (str.isEmpty()) {
                return new C4130b(this.f3376a, this.f3377b, this.f3378c, this.f3379d, this.f3380e, this.f3381f.booleanValue(), this.f3382g.booleanValue(), this.f3383h.booleanValue(), this.f3384i, this.f3385j.booleanValue(), this.f3386k.intValue(), this.f3387l, this.f3388m, this.f3389n, this.f3390o, this.f3391p, this.f3392q, this.f3393r);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* renamed from: b */
        public Registration.C4128a mo56961b(String str) {
            if (str != null) {
                this.f3377b = str;
                return this;
            }
            throw new NullPointerException("Null deviceId");
        }

        /* renamed from: b */
        public Registration.C4128a mo56962b(boolean z) {
            this.f3382g = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: c */
        public Registration.C4128a mo56963c(String str) {
            this.f3378c = str;
            return this;
        }

        /* renamed from: c */
        public Registration.C4128a mo56964c(boolean z) {
            this.f3383h = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: d */
        public Registration.C4128a mo56965d(String str) {
            if (str != null) {
                this.f3379d = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        /* renamed from: d */
        public Registration.C4128a mo56966d(boolean z) {
            this.f3385j = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: e */
        public Registration.C4128a mo56967e(String str) {
            if (str != null) {
                this.f3380e = str;
                return this;
            }
            throw new NullPointerException("Null appVersion");
        }

        /* renamed from: f */
        public Registration.C4128a mo56968f(String str) {
            if (str != null) {
                this.f3384i = str;
                return this;
            }
            throw new NullPointerException("Null platformVersion");
        }

        /* renamed from: g */
        public Registration.C4128a mo56969g(String str) {
            this.f3387l = str;
            return this;
        }

        /* renamed from: h */
        public Registration.C4128a mo56970h(String str) {
            if (str != null) {
                this.f3388m = str;
                return this;
            }
            throw new NullPointerException("Null platform");
        }

        /* renamed from: i */
        public Registration.C4128a mo56971i(String str) {
            if (str != null) {
                this.f3389n = str;
                return this;
            }
            throw new NullPointerException("Null hwid");
        }

        /* renamed from: j */
        public Registration.C4128a mo56972j(String str) {
            if (str != null) {
                this.f3390o = str;
                return this;
            }
            throw new NullPointerException("Null appId");
        }

        /* renamed from: k */
        public Registration.C4128a mo56973k(String str) {
            if (str != null) {
                this.f3391p = str;
                return this;
            }
            throw new NullPointerException("Null locale");
        }
    }

    C$AutoValue_Registration(@Nullable String str, String str2, @Nullable String str3, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, boolean z4, int i, @Nullable String str7, String str8, String str9, String str10, String str11, Set<String> set, Map<String, String> map) {
        String str12 = str2;
        String str13 = str4;
        String str14 = str5;
        String str15 = str6;
        String str16 = str8;
        String str17 = str9;
        String str18 = str10;
        String str19 = str11;
        Set<String> set2 = set;
        Map<String, String> map2 = map;
        this.f3358a = str;
        if (str12 != null) {
            this.f3359b = str12;
            this.f3360c = str3;
            if (str13 != null) {
                this.f3361d = str13;
                if (str14 != null) {
                    this.f3362e = str14;
                    this.f3363f = z;
                    this.f3364g = z2;
                    this.f3365h = z3;
                    if (str15 != null) {
                        this.f3366i = str15;
                        this.f3367j = z4;
                        this.f3368k = i;
                        this.f3369l = str7;
                        if (str16 != null) {
                            this.f3370m = str16;
                            if (str17 != null) {
                                this.f3371n = str17;
                                if (str18 != null) {
                                    this.f3372o = str18;
                                    if (str19 != null) {
                                        this.f3373p = str19;
                                        if (set2 != null) {
                                            this.f3374q = set2;
                                            if (map2 != null) {
                                                this.f3375r = map2;
                                                return;
                                            }
                                            throw new NullPointerException("Null attributes");
                                        }
                                        throw new NullPointerException("Null tags");
                                    }
                                    throw new NullPointerException("Null locale");
                                }
                                throw new NullPointerException("Null appId");
                            }
                            throw new NullPointerException("Null hwid");
                        }
                        throw new NullPointerException("Null platform");
                    }
                    throw new NullPointerException("Null platformVersion");
                }
                throw new NullPointerException("Null appVersion");
            }
            throw new NullPointerException("Null sdkVersion");
        }
        throw new NullPointerException("Null deviceId");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Registration.C4128a mo56933a() {
        return new C4127a(this);
    }

    @NonNull
    @MCKeep
    public String appId() {
        return this.f3372o;
    }

    @NonNull
    @MCKeep
    public String appVersion() {
        return this.f3362e;
    }

    @NonNull
    @MCKeep
    public Map<String, String> attributes() {
        return this.f3375r;
    }

    @Nullable
    @MCKeep
    public String contactKey() {
        return this.f3369l;
    }

    @NonNull
    @MCKeep
    public String deviceId() {
        return this.f3359b;
    }

    @MCKeep
    public boolean dst() {
        return this.f3363f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r1 = r4.f3360c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008d, code lost:
        r1 = r4.f3369l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.salesforce.marketingcloud.registration.Registration
            r2 = 0
            if (r1 == 0) goto L_0x00ed
            com.salesforce.marketingcloud.registration.Registration r5 = (com.salesforce.marketingcloud.registration.Registration) r5
            java.lang.String r1 = r4.f3358a
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = r5.signedString()
            if (r1 != 0) goto L_0x00eb
            goto L_0x0020
        L_0x0016:
            java.lang.String r3 = r5.signedString()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
        L_0x0020:
            java.lang.String r1 = r4.f3359b
            java.lang.String r3 = r5.deviceId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = r4.f3360c
            if (r1 != 0) goto L_0x0037
            java.lang.String r1 = r5.systemToken()
            if (r1 != 0) goto L_0x00eb
            goto L_0x0041
        L_0x0037:
            java.lang.String r3 = r5.systemToken()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
        L_0x0041:
            java.lang.String r1 = r4.f3361d
            java.lang.String r3 = r5.sdkVersion()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = r4.f3362e
            java.lang.String r3 = r5.appVersion()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            boolean r1 = r4.f3363f
            boolean r3 = r5.dst()
            if (r1 != r3) goto L_0x00eb
            boolean r1 = r4.f3364g
            boolean r3 = r5.locationEnabled()
            if (r1 != r3) goto L_0x00eb
            boolean r1 = r4.f3365h
            boolean r3 = r5.proximityEnabled()
            if (r1 != r3) goto L_0x00eb
            java.lang.String r1 = r4.f3366i
            java.lang.String r3 = r5.platformVersion()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            boolean r1 = r4.f3367j
            boolean r3 = r5.pushEnabled()
            if (r1 != r3) goto L_0x00eb
            int r1 = r4.f3368k
            int r3 = r5.timeZone()
            if (r1 != r3) goto L_0x00eb
            java.lang.String r1 = r4.f3369l
            if (r1 != 0) goto L_0x0098
            java.lang.String r1 = r5.contactKey()
            if (r1 != 0) goto L_0x00eb
            goto L_0x00a2
        L_0x0098:
            java.lang.String r3 = r5.contactKey()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
        L_0x00a2:
            java.lang.String r1 = r4.f3370m
            java.lang.String r3 = r5.platform()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = r4.f3371n
            java.lang.String r3 = r5.hwid()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = r4.f3372o
            java.lang.String r3 = r5.appId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = r4.f3373p
            java.lang.String r3 = r5.locale()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            java.util.Set<java.lang.String> r1 = r4.f3374q
            java.util.Set r3 = r5.tags()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00eb
            java.util.Map<java.lang.String, java.lang.String> r1 = r4.f3375r
            java.util.Map r5 = r5.attributes()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r0 = 0
        L_0x00ec:
            return r0
        L_0x00ed:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.registration.C$AutoValue_Registration.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f3358a;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f3359b.hashCode()) * 1000003;
        String str2 = this.f3360c;
        int i2 = 1231;
        int hashCode2 = (((((((((((((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.f3361d.hashCode()) * 1000003) ^ this.f3362e.hashCode()) * 1000003) ^ (this.f3363f ? 1231 : 1237)) * 1000003) ^ (this.f3364g ? 1231 : 1237)) * 1000003) ^ (this.f3365h ? 1231 : 1237)) * 1000003) ^ this.f3366i.hashCode()) * 1000003;
        if (!this.f3367j) {
            i2 = 1237;
        }
        int i3 = (((hashCode2 ^ i2) * 1000003) ^ this.f3368k) * 1000003;
        String str3 = this.f3369l;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((((((((((i3 ^ i) * 1000003) ^ this.f3370m.hashCode()) * 1000003) ^ this.f3371n.hashCode()) * 1000003) ^ this.f3372o.hashCode()) * 1000003) ^ this.f3373p.hashCode()) * 1000003) ^ this.f3374q.hashCode()) * 1000003) ^ this.f3375r.hashCode();
    }

    @NonNull
    @MCKeep
    public String hwid() {
        return this.f3371n;
    }

    @NonNull
    @MCKeep
    public String locale() {
        return this.f3373p;
    }

    @MCKeep
    public boolean locationEnabled() {
        return this.f3364g;
    }

    @NonNull
    @MCKeep
    public String platform() {
        return this.f3370m;
    }

    @NonNull
    @MCKeep
    public String platformVersion() {
        return this.f3366i;
    }

    @MCKeep
    public boolean proximityEnabled() {
        return this.f3365h;
    }

    @MCKeep
    public boolean pushEnabled() {
        return this.f3367j;
    }

    @NonNull
    @MCKeep
    public String sdkVersion() {
        return this.f3361d;
    }

    @Nullable
    @MCKeep
    public String signedString() {
        return this.f3358a;
    }

    @Nullable
    @MCKeep
    public String systemToken() {
        return this.f3360c;
    }

    @NonNull
    @MCKeep
    public Set<String> tags() {
        return this.f3374q;
    }

    @MCKeep
    public int timeZone() {
        return this.f3368k;
    }

    public String toString() {
        return "Registration{signedString=" + this.f3358a + ", deviceId=" + this.f3359b + ", systemToken=" + this.f3360c + ", sdkVersion=" + this.f3361d + ", appVersion=" + this.f3362e + ", dst=" + this.f3363f + ", locationEnabled=" + this.f3364g + ", proximityEnabled=" + this.f3365h + ", platformVersion=" + this.f3366i + ", pushEnabled=" + this.f3367j + ", timeZone=" + this.f3368k + ", contactKey=" + this.f3369l + ", platform=" + this.f3370m + ", hwid=" + this.f3371n + ", appId=" + this.f3372o + ", locale=" + this.f3373p + ", tags=" + this.f3374q + ", attributes=" + this.f3375r + "}";
    }
}
