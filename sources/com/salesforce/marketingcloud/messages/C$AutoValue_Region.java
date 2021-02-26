package com.salesforce.marketingcloud.messages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Region;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.messages.$AutoValue_Region  reason: invalid class name */
abstract class C$AutoValue_Region extends Region {

    /* renamed from: a */
    private final String f3055a;

    /* renamed from: b */
    private final LatLon f3056b;

    /* renamed from: c */
    private final int f3057c;

    /* renamed from: d */
    private final String f3058d;

    /* renamed from: e */
    private final int f3059e;

    /* renamed from: f */
    private final int f3060f;

    /* renamed from: g */
    private final int f3061g;

    /* renamed from: h */
    private final String f3062h;

    /* renamed from: i */
    private final String f3063i;

    /* renamed from: j */
    private final List<Message> f3064j;

    /* renamed from: com.salesforce.marketingcloud.messages.$AutoValue_Region$a */
    static final class C4067a extends Region.C4071a {

        /* renamed from: a */
        private String f3065a;

        /* renamed from: b */
        private LatLon f3066b;

        /* renamed from: c */
        private Integer f3067c;

        /* renamed from: d */
        private String f3068d;

        /* renamed from: e */
        private Integer f3069e;

        /* renamed from: f */
        private Integer f3070f;

        /* renamed from: g */
        private Integer f3071g;

        /* renamed from: h */
        private String f3072h;

        /* renamed from: i */
        private String f3073i;

        /* renamed from: j */
        private List<Message> f3074j;

        C4067a() {
        }

        /* renamed from: a */
        public Region.C4071a mo56656a(int i) {
            this.f3067c = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public Region.C4071a mo56657a(LatLon latLon) {
            if (latLon != null) {
                this.f3066b = latLon;
                return this;
            }
            throw new NullPointerException("Null center");
        }

        /* renamed from: a */
        public Region.C4071a mo56658a(String str) {
            if (str != null) {
                this.f3065a = str;
                return this;
            }
            throw new NullPointerException("Null id");
        }

        /* renamed from: a */
        public Region.C4071a mo56659a(List<Message> list) {
            if (list != null) {
                this.f3074j = list;
                return this;
            }
            throw new NullPointerException("Null messages");
        }

        /* renamed from: a */
        public Region mo56660a() {
            String str = "";
            if (this.f3065a == null) {
                str = str + " id";
            }
            if (this.f3066b == null) {
                str = str + " center";
            }
            if (this.f3067c == null) {
                str = str + " radius";
            }
            if (this.f3069e == null) {
                str = str + " major";
            }
            if (this.f3070f == null) {
                str = str + " minor";
            }
            if (this.f3071g == null) {
                str = str + " regionType";
            }
            if (this.f3074j == null) {
                str = str + " messages";
            }
            if (str.isEmpty()) {
                return new C4077c(this.f3065a, this.f3066b, this.f3067c.intValue(), this.f3068d, this.f3069e.intValue(), this.f3070f.intValue(), this.f3071g.intValue(), this.f3072h, this.f3073i, this.f3074j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* renamed from: b */
        public Region.C4071a mo56661b(int i) {
            this.f3069e = Integer.valueOf(i);
            return this;
        }

        /* renamed from: b */
        public Region.C4071a mo56662b(String str) {
            this.f3068d = str;
            return this;
        }

        /* renamed from: c */
        public Region.C4071a mo56663c(int i) {
            this.f3070f = Integer.valueOf(i);
            return this;
        }

        /* renamed from: c */
        public Region.C4071a mo56664c(String str) {
            this.f3072h = str;
            return this;
        }

        /* renamed from: d */
        public Region.C4071a mo56665d(int i) {
            this.f3071g = Integer.valueOf(i);
            return this;
        }

        /* renamed from: d */
        public Region.C4071a mo56666d(String str) {
            this.f3073i = str;
            return this;
        }
    }

    C$AutoValue_Region(String str, LatLon latLon, int i, @Nullable String str2, int i2, int i3, int i4, @Nullable String str3, @Nullable String str4, List<Message> list) {
        if (str != null) {
            this.f3055a = str;
            if (latLon != null) {
                this.f3056b = latLon;
                this.f3057c = i;
                this.f3058d = str2;
                this.f3059e = i2;
                this.f3060f = i3;
                this.f3061g = i4;
                this.f3062h = str3;
                this.f3063i = str4;
                if (list != null) {
                    this.f3064j = list;
                    return;
                }
                throw new NullPointerException("Null messages");
            }
            throw new NullPointerException("Null center");
        }
        throw new NullPointerException("Null id");
    }

    @NonNull
    @MCKeep
    public LatLon center() {
        return this.f3056b;
    }

    @Nullable
    @MCKeep
    public String description() {
        return this.f3063i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        r1 = r4.f3058d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        r1 = r4.f3062h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
        r1 = r4.f3063i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.salesforce.marketingcloud.messages.Region
            r2 = 0
            if (r1 == 0) goto L_0x0091
            com.salesforce.marketingcloud.messages.Region r5 = (com.salesforce.marketingcloud.messages.Region) r5
            java.lang.String r1 = r4.f3055a
            java.lang.String r3 = r5.mo56647id()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008f
            com.salesforce.marketingcloud.location.LatLon r1 = r4.f3056b
            com.salesforce.marketingcloud.location.LatLon r3 = r5.center()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008f
            int r1 = r4.f3057c
            int r3 = r5.radius()
            if (r1 != r3) goto L_0x008f
            java.lang.String r1 = r4.f3058d
            if (r1 != 0) goto L_0x0036
            java.lang.String r1 = r5.proximityUuid()
            if (r1 != 0) goto L_0x008f
            goto L_0x0040
        L_0x0036:
            java.lang.String r3 = r5.proximityUuid()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008f
        L_0x0040:
            int r1 = r4.f3059e
            int r3 = r5.major()
            if (r1 != r3) goto L_0x008f
            int r1 = r4.f3060f
            int r3 = r5.minor()
            if (r1 != r3) goto L_0x008f
            int r1 = r4.f3061g
            int r3 = r5.regionType()
            if (r1 != r3) goto L_0x008f
            java.lang.String r1 = r4.f3062h
            if (r1 != 0) goto L_0x0063
            java.lang.String r1 = r5.name()
            if (r1 != 0) goto L_0x008f
            goto L_0x006d
        L_0x0063:
            java.lang.String r3 = r5.name()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008f
        L_0x006d:
            java.lang.String r1 = r4.f3063i
            if (r1 != 0) goto L_0x0078
            java.lang.String r1 = r5.description()
            if (r1 != 0) goto L_0x008f
            goto L_0x0082
        L_0x0078:
            java.lang.String r3 = r5.description()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008f
        L_0x0082:
            java.util.List<com.salesforce.marketingcloud.messages.Message> r1 = r4.f3064j
            java.util.List r5 = r5.messages()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r0 = 0
        L_0x0090:
            return r0
        L_0x0091:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.C$AutoValue_Region.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (((((this.f3055a.hashCode() ^ 1000003) * 1000003) ^ this.f3056b.hashCode()) * 1000003) ^ this.f3057c) * 1000003;
        String str = this.f3058d;
        int i = 0;
        int hashCode2 = (((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f3059e) * 1000003) ^ this.f3060f) * 1000003) ^ this.f3061g) * 1000003;
        String str2 = this.f3062h;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f3063i;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode3 ^ i) * 1000003) ^ this.f3064j.hashCode();
    }

    @NonNull
    @MCKeep
    /* renamed from: id */
    public String mo56647id() {
        return this.f3055a;
    }

    @MCKeep
    public int major() {
        return this.f3059e;
    }

    @NonNull
    @MCKeep
    public List<Message> messages() {
        return this.f3064j;
    }

    @MCKeep
    public int minor() {
        return this.f3060f;
    }

    @Nullable
    @MCKeep
    public String name() {
        return this.f3062h;
    }

    @Nullable
    @MCKeep
    public String proximityUuid() {
        return this.f3058d;
    }

    @MCKeep
    public int radius() {
        return this.f3057c;
    }

    @MCKeep
    public int regionType() {
        return this.f3061g;
    }

    public String toString() {
        return "Region{id=" + this.f3055a + ", center=" + this.f3056b + ", radius=" + this.f3057c + ", proximityUuid=" + this.f3058d + ", major=" + this.f3059e + ", minor=" + this.f3060f + ", regionType=" + this.f3061g + ", name=" + this.f3062h + ", description=" + this.f3063i + ", messages=" + this.f3064j + "}";
    }
}
