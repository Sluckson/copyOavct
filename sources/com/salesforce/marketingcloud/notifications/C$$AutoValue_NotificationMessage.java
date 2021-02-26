package com.salesforce.marketingcloud.notifications;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.Map;

/* renamed from: com.salesforce.marketingcloud.notifications.$$AutoValue_NotificationMessage  reason: invalid class name */
abstract class C$$AutoValue_NotificationMessage extends NotificationMessage {

    /* renamed from: a */
    private final String f3255a;

    /* renamed from: b */
    private final String f3256b;

    /* renamed from: c */
    private final int f3257c;

    /* renamed from: d */
    private final String f3258d;

    /* renamed from: e */
    private final NotificationMessage.Sound f3259e;

    /* renamed from: f */
    private final String f3260f;

    /* renamed from: g */
    private final String f3261g;

    /* renamed from: h */
    private final String f3262h;

    /* renamed from: i */
    private final NotificationMessage.Type f3263i;

    /* renamed from: j */
    private final NotificationMessage.Trigger f3264j;

    /* renamed from: k */
    private final String f3265k;

    /* renamed from: l */
    private final String f3266l;

    /* renamed from: m */
    private final String f3267m;

    /* renamed from: n */
    private final Map<String, String> f3268n;

    /* renamed from: o */
    private final String f3269o;

    /* renamed from: p */
    private final Map<String, String> f3270p;

    /* renamed from: com.salesforce.marketingcloud.notifications.$$AutoValue_NotificationMessage$a */
    static final class C4103a extends NotificationMessage.C4104a {

        /* renamed from: a */
        private String f3271a;

        /* renamed from: b */
        private String f3272b;

        /* renamed from: c */
        private Integer f3273c;

        /* renamed from: d */
        private String f3274d;

        /* renamed from: e */
        private NotificationMessage.Sound f3275e;

        /* renamed from: f */
        private String f3276f;

        /* renamed from: g */
        private String f3277g;

        /* renamed from: h */
        private String f3278h;

        /* renamed from: i */
        private NotificationMessage.Type f3279i;

        /* renamed from: j */
        private NotificationMessage.Trigger f3280j;

        /* renamed from: k */
        private String f3281k;

        /* renamed from: l */
        private String f3282l;

        /* renamed from: m */
        private String f3283m;

        /* renamed from: n */
        private Map<String, String> f3284n;

        /* renamed from: o */
        private String f3285o;

        /* renamed from: p */
        private Map<String, String> f3286p;

        C4103a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public NotificationMessage.Sound mo56849a() {
            NotificationMessage.Sound sound = this.f3275e;
            if (sound != null) {
                return sound;
            }
            throw new IllegalStateException("Property \"sound\" has not been set");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public NotificationMessage.C4104a mo56850a(int i) {
            this.f3273c = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public NotificationMessage.C4104a mo56851a(NotificationMessage.Sound sound) {
            if (sound != null) {
                this.f3275e = sound;
                return this;
            }
            throw new NullPointerException("Null sound");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public NotificationMessage.C4104a mo56852a(NotificationMessage.Trigger trigger) {
            if (trigger != null) {
                this.f3280j = trigger;
                return this;
            }
            throw new NullPointerException("Null trigger");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public NotificationMessage.C4104a mo56853a(NotificationMessage.Type type) {
            if (type != null) {
                this.f3279i = type;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public NotificationMessage.C4104a mo56854a(String str) {
            if (str != null) {
                this.f3271a = str;
                return this;
            }
            throw new NullPointerException("Null id");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public NotificationMessage.C4104a mo56855a(Map<String, String> map) {
            if (map != null) {
                this.f3284n = map;
                return this;
            }
            throw new NullPointerException("Null customKeys");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public NotificationMessage.C4104a mo56856b(String str) {
            this.f3272b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public NotificationMessage.C4104a mo56857b(Map<String, String> map) {
            this.f3286p = map;
            return this;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: b */
        public String mo56858b() {
            return this.f3276f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public NotificationMessage.C4104a mo56859c(String str) {
            if (str != null) {
                this.f3274d = str;
                return this;
            }
            throw new NullPointerException("Null alert");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public NotificationMessage mo56860c() {
            String str = "";
            if (this.f3271a == null) {
                str = str + " id";
            }
            if (this.f3273c == null) {
                str = str + " notificationId";
            }
            if (this.f3274d == null) {
                str = str + " alert";
            }
            if (this.f3275e == null) {
                str = str + " sound";
            }
            if (this.f3279i == null) {
                str = str + " type";
            }
            if (this.f3280j == null) {
                str = str + " trigger";
            }
            if (this.f3284n == null) {
                str = str + " customKeys";
            }
            if (str.isEmpty()) {
                return new C4106b(this.f3271a, this.f3272b, this.f3273c.intValue(), this.f3274d, this.f3275e, this.f3276f, this.f3277g, this.f3278h, this.f3279i, this.f3280j, this.f3281k, this.f3282l, this.f3283m, this.f3284n, this.f3285o, this.f3286p);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public NotificationMessage.C4104a mo56861d(String str) {
            this.f3276f = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public NotificationMessage.C4104a mo56862e(String str) {
            this.f3277g = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public NotificationMessage.C4104a mo56863f(String str) {
            this.f3278h = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public NotificationMessage.C4104a mo56864g(String str) {
            this.f3281k = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public NotificationMessage.C4104a mo56865h(String str) {
            this.f3282l = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public NotificationMessage.C4104a mo56866i(String str) {
            this.f3283m = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public NotificationMessage.C4104a mo56867j(String str) {
            this.f3285o = str;
            return this;
        }
    }

    C$$AutoValue_NotificationMessage(String str, @Nullable String str2, int i, String str3, NotificationMessage.Sound sound, @Nullable String str4, @Nullable String str5, @Nullable String str6, NotificationMessage.Type type, NotificationMessage.Trigger trigger, @Nullable String str7, @Nullable String str8, @Nullable String str9, Map<String, String> map, @Nullable String str10, @Nullable Map<String, String> map2) {
        String str11 = str;
        String str12 = str3;
        NotificationMessage.Sound sound2 = sound;
        NotificationMessage.Type type2 = type;
        NotificationMessage.Trigger trigger2 = trigger;
        Map<String, String> map3 = map;
        if (str11 != null) {
            this.f3255a = str11;
            this.f3256b = str2;
            this.f3257c = i;
            if (str12 != null) {
                this.f3258d = str12;
                if (sound2 != null) {
                    this.f3259e = sound2;
                    this.f3260f = str4;
                    this.f3261g = str5;
                    this.f3262h = str6;
                    if (type2 != null) {
                        this.f3263i = type2;
                        if (trigger2 != null) {
                            this.f3264j = trigger2;
                            this.f3265k = str7;
                            this.f3266l = str8;
                            this.f3267m = str9;
                            if (map3 != null) {
                                this.f3268n = map3;
                                this.f3269o = str10;
                                this.f3270p = map2;
                                return;
                            }
                            throw new NullPointerException("Null customKeys");
                        }
                        throw new NullPointerException("Null trigger");
                    }
                    throw new NullPointerException("Null type");
                }
                throw new NullPointerException("Null sound");
            }
            throw new NullPointerException("Null alert");
        }
        throw new NullPointerException("Null id");
    }

    @NonNull
    @MCKeep
    public String alert() {
        return this.f3258d;
    }

    @Nullable
    @MCKeep
    public String custom() {
        return this.f3269o;
    }

    @NonNull
    @MCKeep
    public Map<String, String> customKeys() {
        return this.f3268n;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NotificationMessage)) {
            return false;
        }
        NotificationMessage notificationMessage = (NotificationMessage) obj;
        if (this.f3255a.equals(notificationMessage.mo56835id()) && ((str = this.f3256b) != null ? str.equals(notificationMessage.regionId()) : notificationMessage.regionId() == null) && this.f3257c == notificationMessage.notificationId() && this.f3258d.equals(notificationMessage.alert()) && this.f3259e.equals(notificationMessage.sound()) && ((str2 = this.f3260f) != null ? str2.equals(notificationMessage.soundName()) : notificationMessage.soundName() == null) && ((str3 = this.f3261g) != null ? str3.equals(notificationMessage.title()) : notificationMessage.title() == null) && ((str4 = this.f3262h) != null ? str4.equals(notificationMessage.subTitle()) : notificationMessage.subTitle() == null) && this.f3263i.equals(notificationMessage.type()) && this.f3264j.equals(notificationMessage.trigger()) && ((str5 = this.f3265k) != null ? str5.equals(notificationMessage.url()) : notificationMessage.url() == null) && ((str6 = this.f3266l) != null ? str6.equals(notificationMessage.mediaUrl()) : notificationMessage.mediaUrl() == null) && ((str7 = this.f3267m) != null ? str7.equals(notificationMessage.mediaAltText()) : notificationMessage.mediaAltText() == null) && this.f3268n.equals(notificationMessage.customKeys()) && ((str8 = this.f3269o) != null ? str8.equals(notificationMessage.custom()) : notificationMessage.custom() == null)) {
            Map<String, String> map = this.f3270p;
            if (map == null) {
                if (notificationMessage.payload() == null) {
                    return true;
                }
            } else if (map.equals(notificationMessage.payload())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f3255a.hashCode() ^ 1000003) * 1000003;
        String str = this.f3256b;
        int i = 0;
        int hashCode2 = (((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f3257c) * 1000003) ^ this.f3258d.hashCode()) * 1000003) ^ this.f3259e.hashCode()) * 1000003;
        String str2 = this.f3260f;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f3261g;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f3262h;
        int hashCode5 = (((((hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003) ^ this.f3263i.hashCode()) * 1000003) ^ this.f3264j.hashCode()) * 1000003;
        String str5 = this.f3265k;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f3266l;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f3267m;
        int hashCode8 = (((hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003) ^ this.f3268n.hashCode()) * 1000003;
        String str8 = this.f3269o;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Map<String, String> map = this.f3270p;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode9 ^ i;
    }

    @NonNull
    @MCKeep
    /* renamed from: id */
    public String mo56835id() {
        return this.f3255a;
    }

    @Nullable
    @MCKeep
    public String mediaAltText() {
        return this.f3267m;
    }

    @Nullable
    @MCKeep
    public String mediaUrl() {
        return this.f3266l;
    }

    @MCKeep
    public int notificationId() {
        return this.f3257c;
    }

    @Nullable
    @MCKeep
    public Map<String, String> payload() {
        return this.f3270p;
    }

    @Nullable
    @MCKeep
    public String regionId() {
        return this.f3256b;
    }

    @NonNull
    @MCKeep
    public NotificationMessage.Sound sound() {
        return this.f3259e;
    }

    @Nullable
    @MCKeep
    public String soundName() {
        return this.f3260f;
    }

    @Nullable
    @MCKeep
    public String subTitle() {
        return this.f3262h;
    }

    @Nullable
    @MCKeep
    public String title() {
        return this.f3261g;
    }

    public String toString() {
        return "NotificationMessage{id=" + this.f3255a + ", regionId=" + this.f3256b + ", notificationId=" + this.f3257c + ", alert=" + this.f3258d + ", sound=" + this.f3259e + ", soundName=" + this.f3260f + ", title=" + this.f3261g + ", subTitle=" + this.f3262h + ", type=" + this.f3263i + ", trigger=" + this.f3264j + ", url=" + this.f3265k + ", mediaUrl=" + this.f3266l + ", mediaAltText=" + this.f3267m + ", customKeys=" + this.f3268n + ", custom=" + this.f3269o + ", payload=" + this.f3270p + "}";
    }

    @NonNull
    @MCKeep
    public NotificationMessage.Trigger trigger() {
        return this.f3264j;
    }

    @NonNull
    @MCKeep
    public NotificationMessage.Type type() {
        return this.f3263i;
    }

    @Nullable
    @MCKeep
    public String url() {
        return this.f3265k;
    }
}
