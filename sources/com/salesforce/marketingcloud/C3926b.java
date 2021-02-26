package com.salesforce.marketingcloud;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;

/* renamed from: com.salesforce.marketingcloud.b */
final class C3926b extends MarketingCloudConfig {

    /* renamed from: a */
    private final String f2421a;

    /* renamed from: b */
    private final String f2422b;

    /* renamed from: c */
    private final String f2423c;

    /* renamed from: d */
    private final String f2424d;

    /* renamed from: e */
    private final String f2425e;

    /* renamed from: f */
    private final String f2426f;

    /* renamed from: g */
    private final String f2427g;

    /* renamed from: h */
    private final String f2428h;

    /* renamed from: i */
    private final boolean f2429i;

    /* renamed from: j */
    private final boolean f2430j;

    /* renamed from: k */
    private final boolean f2431k;

    /* renamed from: l */
    private final boolean f2432l;

    /* renamed from: m */
    private final boolean f2433m;

    /* renamed from: n */
    private final boolean f2434n;

    /* renamed from: o */
    private final NotificationCustomizationOptions f2435o;

    /* renamed from: com.salesforce.marketingcloud.b$a */
    static final class C3928a extends MarketingCloudConfig.Builder {

        /* renamed from: a */
        private String f2436a;

        /* renamed from: b */
        private String f2437b;

        /* renamed from: c */
        private String f2438c;

        /* renamed from: d */
        private String f2439d;

        /* renamed from: e */
        private String f2440e;

        /* renamed from: f */
        private String f2441f;

        /* renamed from: g */
        private String f2442g;

        /* renamed from: h */
        private String f2443h;

        /* renamed from: i */
        private Boolean f2444i;

        /* renamed from: j */
        private Boolean f2445j;

        /* renamed from: k */
        private Boolean f2446k;

        /* renamed from: l */
        private Boolean f2447l;

        /* renamed from: m */
        private Boolean f2448m;

        /* renamed from: n */
        private Boolean f2449n;

        /* renamed from: o */
        private NotificationCustomizationOptions f2450o;

        C3928a() {
        }

        private C3928a(MarketingCloudConfig marketingCloudConfig) {
            this.f2436a = marketingCloudConfig.appPackageName();
            this.f2437b = marketingCloudConfig.appVersionName();
            this.f2438c = marketingCloudConfig.applicationId();
            this.f2439d = marketingCloudConfig.accessToken();
            this.f2440e = marketingCloudConfig.senderId();
            this.f2441f = marketingCloudConfig.marketingCloudServerUrl();
            this.f2442g = marketingCloudConfig.mid();
            this.f2443h = marketingCloudConfig.predictiveIntelligenceServerUrl();
            this.f2444i = Boolean.valueOf(marketingCloudConfig.analyticsEnabled());
            this.f2445j = Boolean.valueOf(marketingCloudConfig.piAnalyticsEnabled());
            this.f2446k = Boolean.valueOf(marketingCloudConfig.geofencingEnabled());
            this.f2447l = Boolean.valueOf(marketingCloudConfig.proximityEnabled());
            this.f2448m = Boolean.valueOf(marketingCloudConfig.inboxEnabled());
            this.f2449n = Boolean.valueOf(marketingCloudConfig.markMessageReadOnInboxNotificationOpen());
            this.f2450o = marketingCloudConfig.notificationCustomizationOptions();
        }

        /* access modifiers changed from: package-private */
        public MarketingCloudConfig autoBuild() {
            String str = "";
            if (this.f2436a == null) {
                str = str + " appPackageName";
            }
            if (this.f2437b == null) {
                str = str + " appVersionName";
            }
            if (this.f2438c == null) {
                str = str + " applicationId";
            }
            if (this.f2439d == null) {
                str = str + " accessToken";
            }
            if (this.f2441f == null) {
                str = str + " marketingCloudServerUrl";
            }
            if (this.f2444i == null) {
                str = str + " analyticsEnabled";
            }
            if (this.f2445j == null) {
                str = str + " piAnalyticsEnabled";
            }
            if (this.f2446k == null) {
                str = str + " geofencingEnabled";
            }
            if (this.f2447l == null) {
                str = str + " proximityEnabled";
            }
            if (this.f2448m == null) {
                str = str + " inboxEnabled";
            }
            if (this.f2449n == null) {
                str = str + " markMessageReadOnInboxNotificationOpen";
            }
            if (this.f2450o == null) {
                str = str + " notificationCustomizationOptions";
            }
            if (str.isEmpty()) {
                return new C3926b(this.f2436a, this.f2437b, this.f2438c, this.f2439d, this.f2440e, this.f2441f, this.f2442g, this.f2443h, this.f2444i.booleanValue(), this.f2445j.booleanValue(), this.f2446k.booleanValue(), this.f2447l.booleanValue(), this.f2448m.booleanValue(), this.f2449n.booleanValue(), this.f2450o);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public String mid() {
            return this.f2442g;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public String predictiveIntelligenceServerUrl() {
            return this.f2443h;
        }

        public MarketingCloudConfig.Builder setAccessToken(String str) {
            if (str != null) {
                this.f2439d = str;
                return this;
            }
            throw new NullPointerException("Null accessToken");
        }

        public MarketingCloudConfig.Builder setAnalyticsEnabled(boolean z) {
            this.f2444i = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        public MarketingCloudConfig.Builder setAppPackageName(String str) {
            if (str != null) {
                this.f2436a = str;
                return this;
            }
            throw new NullPointerException("Null appPackageName");
        }

        /* access modifiers changed from: package-private */
        public MarketingCloudConfig.Builder setAppVersionName(String str) {
            if (str != null) {
                this.f2437b = str;
                return this;
            }
            throw new NullPointerException("Null appVersionName");
        }

        public MarketingCloudConfig.Builder setApplicationId(String str) {
            if (str != null) {
                this.f2438c = str;
                return this;
            }
            throw new NullPointerException("Null applicationId");
        }

        public MarketingCloudConfig.Builder setGeofencingEnabled(boolean z) {
            this.f2446k = Boolean.valueOf(z);
            return this;
        }

        public MarketingCloudConfig.Builder setInboxEnabled(boolean z) {
            this.f2448m = Boolean.valueOf(z);
            return this;
        }

        public MarketingCloudConfig.Builder setMarkMessageReadOnInboxNotificationOpen(boolean z) {
            this.f2449n = Boolean.valueOf(z);
            return this;
        }

        public MarketingCloudConfig.Builder setMarketingCloudServerUrl(String str) {
            if (str != null) {
                this.f2441f = str;
                return this;
            }
            throw new NullPointerException("Null marketingCloudServerUrl");
        }

        public MarketingCloudConfig.Builder setMid(String str) {
            this.f2442g = str;
            return this;
        }

        public MarketingCloudConfig.Builder setNotificationCustomizationOptions(NotificationCustomizationOptions notificationCustomizationOptions) {
            if (notificationCustomizationOptions != null) {
                this.f2450o = notificationCustomizationOptions;
                return this;
            }
            throw new NullPointerException("Null notificationCustomizationOptions");
        }

        public MarketingCloudConfig.Builder setPiAnalyticsEnabled(boolean z) {
            this.f2445j = Boolean.valueOf(z);
            return this;
        }

        /* access modifiers changed from: package-private */
        public MarketingCloudConfig.Builder setPredictiveIntelligenceServerUrl(@Nullable String str) {
            this.f2443h = str;
            return this;
        }

        public MarketingCloudConfig.Builder setProximityEnabled(boolean z) {
            this.f2447l = Boolean.valueOf(z);
            return this;
        }

        public MarketingCloudConfig.Builder setSenderId(String str) {
            this.f2440e = str;
            return this;
        }
    }

    private C3926b(String str, String str2, String str3, String str4, @Nullable String str5, String str6, @Nullable String str7, @Nullable String str8, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, NotificationCustomizationOptions notificationCustomizationOptions) {
        this.f2421a = str;
        this.f2422b = str2;
        this.f2423c = str3;
        this.f2424d = str4;
        this.f2425e = str5;
        this.f2426f = str6;
        this.f2427g = str7;
        this.f2428h = str8;
        this.f2429i = z;
        this.f2430j = z2;
        this.f2431k = z3;
        this.f2432l = z4;
        this.f2433m = z5;
        this.f2434n = z6;
        this.f2435o = notificationCustomizationOptions;
    }

    @NonNull
    public String accessToken() {
        return this.f2424d;
    }

    public boolean analyticsEnabled() {
        return this.f2429i;
    }

    @NonNull
    public String appPackageName() {
        return this.f2421a;
    }

    @NonNull
    public String appVersionName() {
        return this.f2422b;
    }

    @NonNull
    public String applicationId() {
        return this.f2423c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        r1 = r4.f2425e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        r1 = r4.f2427g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        r1 = r4.f2428h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.salesforce.marketingcloud.MarketingCloudConfig
            r2 = 0
            if (r1 == 0) goto L_0x00c5
            com.salesforce.marketingcloud.MarketingCloudConfig r5 = (com.salesforce.marketingcloud.MarketingCloudConfig) r5
            java.lang.String r1 = r4.f2421a
            java.lang.String r3 = r5.appPackageName()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = r4.f2422b
            java.lang.String r3 = r5.appVersionName()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = r4.f2423c
            java.lang.String r3 = r5.applicationId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = r4.f2424d
            java.lang.String r3 = r5.accessToken()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = r4.f2425e
            if (r1 != 0) goto L_0x0046
            java.lang.String r1 = r5.senderId()
            if (r1 != 0) goto L_0x00c3
            goto L_0x0050
        L_0x0046:
            java.lang.String r3 = r5.senderId()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c3
        L_0x0050:
            java.lang.String r1 = r4.f2426f
            java.lang.String r3 = r5.marketingCloudServerUrl()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c3
            java.lang.String r1 = r4.f2427g
            if (r1 != 0) goto L_0x0067
            java.lang.String r1 = r5.mid()
            if (r1 != 0) goto L_0x00c3
            goto L_0x0071
        L_0x0067:
            java.lang.String r3 = r5.mid()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c3
        L_0x0071:
            java.lang.String r1 = r4.f2428h
            if (r1 != 0) goto L_0x007c
            java.lang.String r1 = r5.predictiveIntelligenceServerUrl()
            if (r1 != 0) goto L_0x00c3
            goto L_0x0086
        L_0x007c:
            java.lang.String r3 = r5.predictiveIntelligenceServerUrl()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c3
        L_0x0086:
            boolean r1 = r4.f2429i
            boolean r3 = r5.analyticsEnabled()
            if (r1 != r3) goto L_0x00c3
            boolean r1 = r4.f2430j
            boolean r3 = r5.piAnalyticsEnabled()
            if (r1 != r3) goto L_0x00c3
            boolean r1 = r4.f2431k
            boolean r3 = r5.geofencingEnabled()
            if (r1 != r3) goto L_0x00c3
            boolean r1 = r4.f2432l
            boolean r3 = r5.proximityEnabled()
            if (r1 != r3) goto L_0x00c3
            boolean r1 = r4.f2433m
            boolean r3 = r5.inboxEnabled()
            if (r1 != r3) goto L_0x00c3
            boolean r1 = r4.f2434n
            boolean r3 = r5.markMessageReadOnInboxNotificationOpen()
            if (r1 != r3) goto L_0x00c3
            com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions r1 = r4.f2435o
            com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions r5 = r5.notificationCustomizationOptions()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r0 = 0
        L_0x00c4:
            return r0
        L_0x00c5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.C3926b.equals(java.lang.Object):boolean");
    }

    public boolean geofencingEnabled() {
        return this.f2431k;
    }

    public int hashCode() {
        int hashCode = (((((((this.f2421a.hashCode() ^ 1000003) * 1000003) ^ this.f2422b.hashCode()) * 1000003) ^ this.f2423c.hashCode()) * 1000003) ^ this.f2424d.hashCode()) * 1000003;
        String str = this.f2425e;
        int i = 0;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f2426f.hashCode()) * 1000003;
        String str2 = this.f2427g;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2428h;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode3 ^ i) * 1000003;
        int i3 = 1231;
        int i4 = (((((((((i2 ^ (this.f2429i ? 1231 : 1237)) * 1000003) ^ (this.f2430j ? 1231 : 1237)) * 1000003) ^ (this.f2431k ? 1231 : 1237)) * 1000003) ^ (this.f2432l ? 1231 : 1237)) * 1000003) ^ (this.f2433m ? 1231 : 1237)) * 1000003;
        if (!this.f2434n) {
            i3 = 1237;
        }
        return ((i4 ^ i3) * 1000003) ^ this.f2435o.hashCode();
    }

    public boolean inboxEnabled() {
        return this.f2433m;
    }

    public boolean markMessageReadOnInboxNotificationOpen() {
        return this.f2434n;
    }

    @NonNull
    public String marketingCloudServerUrl() {
        return this.f2426f;
    }

    @Nullable
    public String mid() {
        return this.f2427g;
    }

    @NonNull
    public NotificationCustomizationOptions notificationCustomizationOptions() {
        return this.f2435o;
    }

    public boolean piAnalyticsEnabled() {
        return this.f2430j;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String predictiveIntelligenceServerUrl() {
        return this.f2428h;
    }

    public boolean proximityEnabled() {
        return this.f2432l;
    }

    @Nullable
    public String senderId() {
        return this.f2425e;
    }

    public MarketingCloudConfig.Builder toBuilder() {
        return new C3928a(this);
    }

    public String toString() {
        return "MarketingCloudConfig{appPackageName=" + this.f2421a + ", appVersionName=" + this.f2422b + ", applicationId=" + this.f2423c + ", accessToken=" + this.f2424d + ", senderId=" + this.f2425e + ", marketingCloudServerUrl=" + this.f2426f + ", mid=" + this.f2427g + ", predictiveIntelligenceServerUrl=" + this.f2428h + ", analyticsEnabled=" + this.f2429i + ", piAnalyticsEnabled=" + this.f2430j + ", geofencingEnabled=" + this.f2431k + ", proximityEnabled=" + this.f2432l + ", inboxEnabled=" + this.f2433m + ", markMessageReadOnInboxNotificationOpen=" + this.f2434n + ", notificationCustomizationOptions=" + this.f2435o + "}";
    }
}
