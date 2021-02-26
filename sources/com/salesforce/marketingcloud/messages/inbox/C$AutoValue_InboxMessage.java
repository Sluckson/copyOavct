package com.salesforce.marketingcloud.messages.inbox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import java.util.Date;
import java.util.Map;

/* renamed from: com.salesforce.marketingcloud.messages.inbox.$AutoValue_InboxMessage  reason: invalid class name */
abstract class C$AutoValue_InboxMessage extends InboxMessage {

    /* renamed from: d */
    private final String f3139d;

    /* renamed from: e */
    private final String f3140e;

    /* renamed from: f */
    private final String f3141f;

    /* renamed from: g */
    private final Map<String, String> f3142g;

    /* renamed from: h */
    private final String f3143h;

    /* renamed from: i */
    private final String f3144i;

    /* renamed from: j */
    private final String f3145j;

    /* renamed from: k */
    private final String f3146k;

    /* renamed from: l */
    private final InboxMessage.Media f3147l;

    /* renamed from: m */
    private final String f3148m;

    /* renamed from: n */
    private final Date f3149n;

    /* renamed from: o */
    private final Date f3150o;

    /* renamed from: p */
    private final int f3151p;

    /* renamed from: q */
    private final int f3152q;

    /* renamed from: r */
    private final String f3153r;

    /* renamed from: com.salesforce.marketingcloud.messages.inbox.$AutoValue_InboxMessage$a */
    static final class C4089a extends InboxMessage.C4090a {

        /* renamed from: a */
        private String f3154a;

        /* renamed from: b */
        private String f3155b;

        /* renamed from: c */
        private String f3156c;

        /* renamed from: d */
        private Map<String, String> f3157d;

        /* renamed from: e */
        private String f3158e;

        /* renamed from: f */
        private String f3159f;

        /* renamed from: g */
        private String f3160g;

        /* renamed from: h */
        private String f3161h;

        /* renamed from: i */
        private InboxMessage.Media f3162i;

        /* renamed from: j */
        private String f3163j;

        /* renamed from: k */
        private Date f3164k;

        /* renamed from: l */
        private Date f3165l;

        /* renamed from: m */
        private Integer f3166m;

        /* renamed from: n */
        private Integer f3167n;

        /* renamed from: o */
        private String f3168o;

        C4089a() {
        }

        /* renamed from: a */
        public InboxMessage.C4090a mo56749a(int i) {
            this.f3166m = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public InboxMessage.C4090a mo56750a(InboxMessage.Media media) {
            this.f3162i = media;
            return this;
        }

        /* renamed from: a */
        public InboxMessage.C4090a mo56751a(String str) {
            this.f3154a = str;
            return this;
        }

        /* renamed from: a */
        public InboxMessage.C4090a mo56752a(Date date) {
            this.f3164k = date;
            return this;
        }

        /* renamed from: a */
        public InboxMessage.C4090a mo56753a(Map<String, String> map) {
            this.f3157d = map;
            return this;
        }

        /* renamed from: a */
        public InboxMessage mo56754a() {
            String str = "";
            if (this.f3163j == null) {
                str = str + " id";
            }
            if (this.f3166m == null) {
                str = str + " messageType";
            }
            if (this.f3167n == null) {
                str = str + " contentType";
            }
            if (this.f3168o == null) {
                str = str + " url";
            }
            if (str.isEmpty()) {
                return new C4092a(this.f3154a, this.f3155b, this.f3156c, this.f3157d, this.f3158e, this.f3159f, this.f3160g, this.f3161h, this.f3162i, this.f3163j, this.f3164k, this.f3165l, this.f3166m.intValue(), this.f3167n.intValue(), this.f3168o);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* renamed from: b */
        public InboxMessage.C4090a mo56755b(int i) {
            this.f3167n = Integer.valueOf(i);
            return this;
        }

        /* renamed from: b */
        public InboxMessage.C4090a mo56756b(String str) {
            this.f3155b = str;
            return this;
        }

        /* renamed from: b */
        public InboxMessage.C4090a mo56757b(Date date) {
            this.f3165l = date;
            return this;
        }

        /* renamed from: c */
        public InboxMessage.C4090a mo56758c(String str) {
            this.f3156c = str;
            return this;
        }

        /* renamed from: d */
        public InboxMessage.C4090a mo56759d(String str) {
            this.f3158e = str;
            return this;
        }

        /* renamed from: e */
        public InboxMessage.C4090a mo56760e(String str) {
            this.f3159f = str;
            return this;
        }

        /* renamed from: f */
        public InboxMessage.C4090a mo56761f(String str) {
            this.f3160g = str;
            return this;
        }

        /* renamed from: g */
        public InboxMessage.C4090a mo56762g(String str) {
            this.f3161h = str;
            return this;
        }

        /* renamed from: h */
        public InboxMessage.C4090a mo56763h(String str) {
            if (str != null) {
                this.f3163j = str;
                return this;
            }
            throw new NullPointerException("Null id");
        }

        /* renamed from: i */
        public InboxMessage.C4090a mo56764i(String str) {
            if (str != null) {
                this.f3168o = str;
                return this;
            }
            throw new NullPointerException("Null url");
        }
    }

    C$AutoValue_InboxMessage(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable InboxMessage.Media media, String str8, @Nullable Date date, @Nullable Date date2, int i, int i2, String str9) {
        this.f3139d = str;
        this.f3140e = str2;
        this.f3141f = str3;
        this.f3142g = map;
        this.f3143h = str4;
        this.f3144i = str5;
        this.f3145j = str6;
        this.f3146k = str7;
        this.f3147l = media;
        if (str8 != null) {
            this.f3148m = str8;
            this.f3149n = date;
            this.f3150o = date2;
            this.f3151p = i;
            this.f3152q = i2;
            if (str9 != null) {
                this.f3153r = str9;
                return;
            }
            throw new NullPointerException("Null url");
        }
        throw new NullPointerException("Null id");
    }

    @Nullable
    /* renamed from: a */
    public String mo56731a() {
        return this.f3139d;
    }

    @Nullable
    @MCKeep
    public String alert() {
        return this.f3145j;
    }

    @Nullable
    /* renamed from: b */
    public String mo56733b() {
        return this.f3140e;
    }

    /* renamed from: c */
    public int mo56734c() {
        return this.f3151p;
    }

    @Nullable
    @MCKeep
    public String custom() {
        return this.f3143h;
    }

    @Nullable
    @MCKeep
    public Map<String, String> customKeys() {
        return this.f3142g;
    }

    /* renamed from: d */
    public int mo56737d() {
        return this.f3152q;
    }

    @Nullable
    @MCKeep
    public Date endDateUtc() {
        return this.f3150o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d4, code lost:
        r1 = r4.f3149n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e9, code lost:
        r1 = r4.f3150o;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.salesforce.marketingcloud.messages.inbox.InboxMessage
            r2 = 0
            if (r1 == 0) goto L_0x011d
            com.salesforce.marketingcloud.messages.inbox.InboxMessage r5 = (com.salesforce.marketingcloud.messages.inbox.InboxMessage) r5
            java.lang.String r1 = r4.f3139d
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = r5.mo56731a()
            if (r1 != 0) goto L_0x011b
            goto L_0x0020
        L_0x0016:
            java.lang.String r3 = r5.mo56731a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x0020:
            java.lang.String r1 = r4.f3140e
            if (r1 != 0) goto L_0x002b
            java.lang.String r1 = r5.mo56733b()
            if (r1 != 0) goto L_0x011b
            goto L_0x0035
        L_0x002b:
            java.lang.String r3 = r5.mo56733b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x0035:
            java.lang.String r1 = r4.f3141f
            if (r1 != 0) goto L_0x0040
            java.lang.String r1 = r5.subject()
            if (r1 != 0) goto L_0x011b
            goto L_0x004a
        L_0x0040:
            java.lang.String r3 = r5.subject()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x004a:
            java.util.Map<java.lang.String, java.lang.String> r1 = r4.f3142g
            if (r1 != 0) goto L_0x0055
            java.util.Map r1 = r5.customKeys()
            if (r1 != 0) goto L_0x011b
            goto L_0x005f
        L_0x0055:
            java.util.Map r3 = r5.customKeys()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x005f:
            java.lang.String r1 = r4.f3143h
            if (r1 != 0) goto L_0x006a
            java.lang.String r1 = r5.custom()
            if (r1 != 0) goto L_0x011b
            goto L_0x0074
        L_0x006a:
            java.lang.String r3 = r5.custom()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x0074:
            java.lang.String r1 = r4.f3144i
            if (r1 != 0) goto L_0x007f
            java.lang.String r1 = r5.title()
            if (r1 != 0) goto L_0x011b
            goto L_0x0089
        L_0x007f:
            java.lang.String r3 = r5.title()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x0089:
            java.lang.String r1 = r4.f3145j
            if (r1 != 0) goto L_0x0094
            java.lang.String r1 = r5.alert()
            if (r1 != 0) goto L_0x011b
            goto L_0x009e
        L_0x0094:
            java.lang.String r3 = r5.alert()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x009e:
            java.lang.String r1 = r4.f3146k
            if (r1 != 0) goto L_0x00a9
            java.lang.String r1 = r5.sound()
            if (r1 != 0) goto L_0x011b
            goto L_0x00b3
        L_0x00a9:
            java.lang.String r3 = r5.sound()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x00b3:
            com.salesforce.marketingcloud.messages.inbox.InboxMessage$Media r1 = r4.f3147l
            if (r1 != 0) goto L_0x00be
            com.salesforce.marketingcloud.messages.inbox.InboxMessage$Media r1 = r5.media()
            if (r1 != 0) goto L_0x011b
            goto L_0x00c8
        L_0x00be:
            com.salesforce.marketingcloud.messages.inbox.InboxMessage$Media r3 = r5.media()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x00c8:
            java.lang.String r1 = r4.f3148m
            java.lang.String r3 = r5.mo56741id()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
            java.util.Date r1 = r4.f3149n
            if (r1 != 0) goto L_0x00df
            java.util.Date r1 = r5.startDateUtc()
            if (r1 != 0) goto L_0x011b
            goto L_0x00e9
        L_0x00df:
            java.util.Date r3 = r5.startDateUtc()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x00e9:
            java.util.Date r1 = r4.f3150o
            if (r1 != 0) goto L_0x00f4
            java.util.Date r1 = r5.endDateUtc()
            if (r1 != 0) goto L_0x011b
            goto L_0x00fe
        L_0x00f4:
            java.util.Date r3 = r5.endDateUtc()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x011b
        L_0x00fe:
            int r1 = r4.f3151p
            int r3 = r5.mo56734c()
            if (r1 != r3) goto L_0x011b
            int r1 = r4.f3152q
            int r3 = r5.mo56737d()
            if (r1 != r3) goto L_0x011b
            java.lang.String r1 = r4.f3153r
            java.lang.String r5 = r5.url()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x011b
            goto L_0x011c
        L_0x011b:
            r0 = 0
        L_0x011c:
            return r0
        L_0x011d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.inbox.C$AutoValue_InboxMessage.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.f3139d;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f3140e;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f3141f;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Map<String, String> map = this.f3142g;
        int hashCode4 = (hashCode3 ^ (map == null ? 0 : map.hashCode())) * 1000003;
        String str4 = this.f3143h;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f3144i;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f3145j;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f3146k;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        InboxMessage.Media media = this.f3147l;
        int hashCode9 = (((hashCode8 ^ (media == null ? 0 : media.hashCode())) * 1000003) ^ this.f3148m.hashCode()) * 1000003;
        Date date = this.f3149n;
        int hashCode10 = (hashCode9 ^ (date == null ? 0 : date.hashCode())) * 1000003;
        Date date2 = this.f3150o;
        if (date2 != null) {
            i = date2.hashCode();
        }
        return ((((((hashCode10 ^ i) * 1000003) ^ this.f3151p) * 1000003) ^ this.f3152q) * 1000003) ^ this.f3153r.hashCode();
    }

    @NonNull
    @MCKeep
    /* renamed from: id */
    public String mo56741id() {
        return this.f3148m;
    }

    @Nullable
    @MCKeep
    public InboxMessage.Media media() {
        return this.f3147l;
    }

    @Nullable
    @MCKeep
    public String sound() {
        return this.f3146k;
    }

    @Nullable
    @MCKeep
    public Date startDateUtc() {
        return this.f3149n;
    }

    @Nullable
    @MCKeep
    public String subject() {
        return this.f3141f;
    }

    @Nullable
    @MCKeep
    public String title() {
        return this.f3144i;
    }

    public String toString() {
        return "InboxMessage{requestId=" + this.f3139d + ", messageHash=" + this.f3140e + ", subject=" + this.f3141f + ", customKeys=" + this.f3142g + ", custom=" + this.f3143h + ", title=" + this.f3144i + ", alert=" + this.f3145j + ", sound=" + this.f3146k + ", media=" + this.f3147l + ", id=" + this.f3148m + ", startDateUtc=" + this.f3149n + ", endDateUtc=" + this.f3150o + ", messageType=" + this.f3151p + ", contentType=" + this.f3152q + ", url=" + this.f3153r + "}";
    }

    @NonNull
    @MCKeep
    public String url() {
        return this.f3153r;
    }
}
