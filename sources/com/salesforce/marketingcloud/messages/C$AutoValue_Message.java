package com.salesforce.marketingcloud.messages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.messages.Message;
import java.util.Date;
import java.util.Map;

/* renamed from: com.salesforce.marketingcloud.messages.$AutoValue_Message  reason: invalid class name */
abstract class C$AutoValue_Message extends Message {

    /* renamed from: f */
    private final String f3017f;

    /* renamed from: g */
    private final String f3018g;

    /* renamed from: h */
    private final String f3019h;

    /* renamed from: i */
    private final String f3020i;

    /* renamed from: j */
    private final Message.Media f3021j;

    /* renamed from: k */
    private final Date f3022k;

    /* renamed from: l */
    private final Date f3023l;

    /* renamed from: m */
    private final int f3024m;

    /* renamed from: n */
    private final int f3025n;

    /* renamed from: o */
    private final String f3026o;

    /* renamed from: p */
    private final int f3027p;

    /* renamed from: q */
    private final int f3028q;

    /* renamed from: r */
    private final int f3029r;

    /* renamed from: s */
    private final boolean f3030s;

    /* renamed from: t */
    private final int f3031t;

    /* renamed from: u */
    private final int f3032u;

    /* renamed from: v */
    private final String f3033v;

    /* renamed from: w */
    private final Map<String, String> f3034w;

    /* renamed from: x */
    private final String f3035x;

    /* renamed from: com.salesforce.marketingcloud.messages.$AutoValue_Message$a */
    static final class C4066a extends Message.C4068a {

        /* renamed from: a */
        private String f3036a;

        /* renamed from: b */
        private String f3037b;

        /* renamed from: c */
        private String f3038c;

        /* renamed from: d */
        private String f3039d;

        /* renamed from: e */
        private Message.Media f3040e;

        /* renamed from: f */
        private Date f3041f;

        /* renamed from: g */
        private Date f3042g;

        /* renamed from: h */
        private Integer f3043h;

        /* renamed from: i */
        private Integer f3044i;

        /* renamed from: j */
        private String f3045j;

        /* renamed from: k */
        private Integer f3046k;

        /* renamed from: l */
        private Integer f3047l;

        /* renamed from: m */
        private Integer f3048m;

        /* renamed from: n */
        private Boolean f3049n;

        /* renamed from: o */
        private Integer f3050o;

        /* renamed from: p */
        private Integer f3051p;

        /* renamed from: q */
        private String f3052q;

        /* renamed from: r */
        private Map<String, String> f3053r;

        /* renamed from: s */
        private String f3054s;

        C4066a() {
        }

        /* renamed from: a */
        public Message.C4068a mo56623a(int i) {
            this.f3043h = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public Message.C4068a mo56624a(Message.Media media) {
            this.f3040e = media;
            return this;
        }

        /* renamed from: a */
        public Message.C4068a mo56625a(String str) {
            if (str != null) {
                this.f3036a = str;
                return this;
            }
            throw new NullPointerException("Null id");
        }

        /* renamed from: a */
        public Message.C4068a mo56626a(Date date) {
            this.f3041f = date;
            return this;
        }

        /* renamed from: a */
        public Message.C4068a mo56627a(Map<String, String> map) {
            this.f3053r = map;
            return this;
        }

        /* renamed from: a */
        public Message.C4068a mo56628a(boolean z) {
            this.f3049n = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: a */
        public Message mo56629a() {
            String str = "";
            if (this.f3036a == null) {
                str = str + " id";
            }
            if (this.f3038c == null) {
                str = str + " alert";
            }
            if (this.f3043h == null) {
                str = str + " messageType";
            }
            if (this.f3044i == null) {
                str = str + " contentType";
            }
            if (this.f3046k == null) {
                str = str + " messagesPerPeriod";
            }
            if (this.f3047l == null) {
                str = str + " numberOfPeriods";
            }
            if (this.f3048m == null) {
                str = str + " periodType";
            }
            if (this.f3049n == null) {
                str = str + " isRollingPeriod";
            }
            if (this.f3050o == null) {
                str = str + " messageLimit";
            }
            if (this.f3051p == null) {
                str = str + " proximity";
            }
            if (str.isEmpty()) {
                return new C4075a(this.f3036a, this.f3037b, this.f3038c, this.f3039d, this.f3040e, this.f3041f, this.f3042g, this.f3043h.intValue(), this.f3044i.intValue(), this.f3045j, this.f3046k.intValue(), this.f3047l.intValue(), this.f3048m.intValue(), this.f3049n.booleanValue(), this.f3050o.intValue(), this.f3051p.intValue(), this.f3052q, this.f3053r, this.f3054s);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* renamed from: b */
        public Message.C4068a mo56630b(int i) {
            this.f3044i = Integer.valueOf(i);
            return this;
        }

        /* renamed from: b */
        public Message.C4068a mo56631b(String str) {
            this.f3037b = str;
            return this;
        }

        /* renamed from: b */
        public Message.C4068a mo56632b(Date date) {
            this.f3042g = date;
            return this;
        }

        /* renamed from: c */
        public Message.C4068a mo56633c(int i) {
            this.f3046k = Integer.valueOf(i);
            return this;
        }

        /* renamed from: c */
        public Message.C4068a mo56634c(String str) {
            if (str != null) {
                this.f3038c = str;
                return this;
            }
            throw new NullPointerException("Null alert");
        }

        /* renamed from: d */
        public Message.C4068a mo56635d(int i) {
            this.f3047l = Integer.valueOf(i);
            return this;
        }

        /* renamed from: d */
        public Message.C4068a mo56636d(String str) {
            this.f3039d = str;
            return this;
        }

        /* renamed from: e */
        public Message.C4068a mo56637e(int i) {
            this.f3048m = Integer.valueOf(i);
            return this;
        }

        /* renamed from: e */
        public Message.C4068a mo56638e(String str) {
            this.f3045j = str;
            return this;
        }

        /* renamed from: f */
        public Message.C4068a mo56639f(int i) {
            this.f3050o = Integer.valueOf(i);
            return this;
        }

        /* renamed from: f */
        public Message.C4068a mo56640f(String str) {
            this.f3052q = str;
            return this;
        }

        /* renamed from: g */
        public Message.C4068a mo56641g(int i) {
            this.f3051p = Integer.valueOf(i);
            return this;
        }

        /* renamed from: g */
        public Message.C4068a mo56642g(String str) {
            this.f3054s = str;
            return this;
        }
    }

    C$AutoValue_Message(String str, @Nullable String str2, String str3, @Nullable String str4, @Nullable Message.Media media, @Nullable Date date, @Nullable Date date2, int i, int i2, @Nullable String str5, int i3, int i4, int i5, boolean z, int i6, int i7, @Nullable String str6, @Nullable Map<String, String> map, @Nullable String str7) {
        String str8 = str;
        String str9 = str3;
        if (str8 != null) {
            this.f3017f = str8;
            this.f3018g = str2;
            if (str9 != null) {
                this.f3019h = str9;
                this.f3020i = str4;
                this.f3021j = media;
                this.f3022k = date;
                this.f3023l = date2;
                this.f3024m = i;
                this.f3025n = i2;
                this.f3026o = str5;
                this.f3027p = i3;
                this.f3028q = i4;
                this.f3029r = i5;
                this.f3030s = z;
                this.f3031t = i6;
                this.f3032u = i7;
                this.f3033v = str6;
                this.f3034w = map;
                this.f3035x = str7;
                return;
            }
            throw new NullPointerException("Null alert");
        }
        throw new NullPointerException("Null id");
    }

    @NonNull
    @MCKeep
    public String alert() {
        return this.f3019h;
    }

    @MCKeep
    public int contentType() {
        return this.f3025n;
    }

    @Nullable
    @MCKeep
    public String custom() {
        return this.f3035x;
    }

    @Nullable
    @MCKeep
    public Map<String, String> customKeys() {
        return this.f3034w;
    }

    @Nullable
    @MCKeep
    public Date endDateUtc() {
        return this.f3023l;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Message.Media media;
        Date date;
        Date date2;
        String str3;
        String str4;
        Map<String, String> map;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        if (this.f3017f.equals(message.mo56608id()) && ((str = this.f3018g) != null ? str.equals(message.title()) : message.title() == null) && this.f3019h.equals(message.alert()) && ((str2 = this.f3020i) != null ? str2.equals(message.sound()) : message.sound() == null) && ((media = this.f3021j) != null ? media.equals(message.media()) : message.media() == null) && ((date = this.f3022k) != null ? date.equals(message.startDateUtc()) : message.startDateUtc() == null) && ((date2 = this.f3023l) != null ? date2.equals(message.endDateUtc()) : message.endDateUtc() == null) && this.f3024m == message.messageType() && this.f3025n == message.contentType() && ((str3 = this.f3026o) != null ? str3.equals(message.url()) : message.url() == null) && this.f3027p == message.messagesPerPeriod() && this.f3028q == message.numberOfPeriods() && this.f3029r == message.periodType() && this.f3030s == message.isRollingPeriod() && this.f3031t == message.messageLimit() && this.f3032u == message.proximity() && ((str4 = this.f3033v) != null ? str4.equals(message.openDirect()) : message.openDirect() == null) && ((map = this.f3034w) != null ? map.equals(message.customKeys()) : message.customKeys() == null)) {
            String str5 = this.f3035x;
            if (str5 == null) {
                if (message.custom() == null) {
                    return true;
                }
            } else if (str5.equals(message.custom())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f3017f.hashCode() ^ 1000003) * 1000003;
        String str = this.f3018g;
        int i = 0;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f3019h.hashCode()) * 1000003;
        String str2 = this.f3020i;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Message.Media media = this.f3021j;
        int hashCode4 = (hashCode3 ^ (media == null ? 0 : media.hashCode())) * 1000003;
        Date date = this.f3022k;
        int hashCode5 = (hashCode4 ^ (date == null ? 0 : date.hashCode())) * 1000003;
        Date date2 = this.f3023l;
        int hashCode6 = (((((hashCode5 ^ (date2 == null ? 0 : date2.hashCode())) * 1000003) ^ this.f3024m) * 1000003) ^ this.f3025n) * 1000003;
        String str3 = this.f3026o;
        int hashCode7 = (((((((((((((hashCode6 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f3027p) * 1000003) ^ this.f3028q) * 1000003) ^ this.f3029r) * 1000003) ^ (this.f3030s ? 1231 : 1237)) * 1000003) ^ this.f3031t) * 1000003) ^ this.f3032u) * 1000003;
        String str4 = this.f3033v;
        int hashCode8 = (hashCode7 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Map<String, String> map = this.f3034w;
        int hashCode9 = (hashCode8 ^ (map == null ? 0 : map.hashCode())) * 1000003;
        String str5 = this.f3035x;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode9 ^ i;
    }

    @NonNull
    @MCKeep
    /* renamed from: id */
    public String mo56608id() {
        return this.f3017f;
    }

    @MCKeep
    public boolean isRollingPeriod() {
        return this.f3030s;
    }

    @Nullable
    @MCKeep
    public Message.Media media() {
        return this.f3021j;
    }

    @MCKeep
    public int messageLimit() {
        return this.f3031t;
    }

    @MCKeep
    public int messageType() {
        return this.f3024m;
    }

    @MCKeep
    public int messagesPerPeriod() {
        return this.f3027p;
    }

    @MCKeep
    public int numberOfPeriods() {
        return this.f3028q;
    }

    @Nullable
    @MCKeep
    public String openDirect() {
        return this.f3033v;
    }

    @MCKeep
    public int periodType() {
        return this.f3029r;
    }

    @MCKeep
    public int proximity() {
        return this.f3032u;
    }

    @Nullable
    @MCKeep
    public String sound() {
        return this.f3020i;
    }

    @Nullable
    @MCKeep
    public Date startDateUtc() {
        return this.f3022k;
    }

    @Nullable
    @MCKeep
    public String title() {
        return this.f3018g;
    }

    public String toString() {
        return "Message{id=" + this.f3017f + ", title=" + this.f3018g + ", alert=" + this.f3019h + ", sound=" + this.f3020i + ", media=" + this.f3021j + ", startDateUtc=" + this.f3022k + ", endDateUtc=" + this.f3023l + ", messageType=" + this.f3024m + ", contentType=" + this.f3025n + ", url=" + this.f3026o + ", messagesPerPeriod=" + this.f3027p + ", numberOfPeriods=" + this.f3028q + ", periodType=" + this.f3029r + ", isRollingPeriod=" + this.f3030s + ", messageLimit=" + this.f3031t + ", proximity=" + this.f3032u + ", openDirect=" + this.f3033v + ", customKeys=" + this.f3034w + ", custom=" + this.f3035x + "}";
    }

    @Nullable
    @MCKeep
    public String url() {
        return this.f3026o;
    }
}
