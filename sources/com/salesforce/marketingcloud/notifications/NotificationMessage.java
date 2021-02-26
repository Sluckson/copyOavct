package com.salesforce.marketingcloud.notifications;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.notifications.C$$AutoValue_NotificationMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AutoValue
public abstract class NotificationMessage implements Parcelable {

    /* renamed from: a */
    private static final String f3289a = "_m";

    /* renamed from: b */
    private static final String f3290b = "title";

    /* renamed from: c */
    private static final String f3291c = "subtitle";

    /* renamed from: d */
    private static final String f3292d = "alert";

    /* renamed from: e */
    private static final String f3293e = "sound";

    /* renamed from: f */
    private static final String f3294f = "_mediaUrl";

    /* renamed from: g */
    private static final String f3295g = "_mediaAlt";

    /* renamed from: h */
    private static final String f3296h = "_x";

    /* renamed from: i */
    private static final String f3297i = "_od";

    /* renamed from: j */
    private static final List<String> f3298j;

    /* renamed from: k */
    private static final String f3299k = "default";

    /* renamed from: l */
    private static final String f3300l = "none";

    @MCKeep
    public enum Sound {
        CUSTOM,
        DEFAULT,
        NONE
    }

    @MCKeep
    public enum Trigger {
        PUSH,
        GEOFENCE,
        BEACON
    }

    @MCKeep
    public enum Type {
        OPEN_DIRECT,
        CLOUD_PAGE,
        OTHER
    }

    @AutoValue.Builder
    /* renamed from: com.salesforce.marketingcloud.notifications.NotificationMessage$a */
    static abstract class C4104a {
        C4104a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract Sound mo56849a();

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C4104a mo56850a(int i);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C4104a mo56851a(Sound sound);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C4104a mo56852a(Trigger trigger);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C4104a mo56853a(Type type);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C4104a mo56854a(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C4104a mo56855a(Map<String, String> map);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C4104a mo56856b(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C4104a mo56857b(Map<String, String> map);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract String mo56858b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract C4104a mo56859c(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract NotificationMessage mo56860c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract C4104a mo56861d(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public NotificationMessage mo56880d() {
            if (mo56849a() == Sound.CUSTOM && mo56858b() == null) {
                mo56851a(Sound.DEFAULT);
            }
            return mo56860c();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public abstract C4104a mo56862e(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public abstract C4104a mo56863f(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public abstract C4104a mo56864g(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public abstract C4104a mo56865h(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public abstract C4104a mo56866i(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public abstract C4104a mo56867j(String str);
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f3289a);
        arrayList.add("title");
        arrayList.add(f3291c);
        arrayList.add("alert");
        arrayList.add("sound");
        arrayList.add(f3294f);
        arrayList.add(f3295g);
        arrayList.add(f3296h);
        arrayList.add(f3297i);
        arrayList.add("_mt");
        arrayList.add("_h");
        arrayList.add("_r");
        f3298j = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static C4104a m3247a() {
        return new C$$AutoValue_NotificationMessage.C4103a().mo56850a(-1);
    }

    /* renamed from: a */
    private static C4104a m3248a(C4104a aVar, String str) {
        Sound sound;
        if (str == null || "none".equalsIgnoreCase(str)) {
            sound = Sound.NONE;
        } else if ("default".equalsIgnoreCase(str)) {
            sound = Sound.DEFAULT;
        } else {
            aVar.mo56851a(Sound.CUSTOM).mo56861d(str);
            return aVar;
        }
        aVar.mo56851a(sound);
        return aVar;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static NotificationMessage m3249a(@NonNull Message message, @NonNull Region region) {
        C4104a g;
        Type type;
        Map emptyMap = Collections.emptyMap();
        if (message.customKeys() != null) {
            emptyMap = new HashMap(message.customKeys());
        }
        C4104a j = m3247a().mo56852a(message.messageType() == 5 ? Trigger.BEACON : Trigger.GEOFENCE).mo56854a(message.mo56608id()).mo56856b(region.mo56647id()).mo56862e(message.title()).mo56859c(message.alert()).mo56855a((Map<String, String>) emptyMap).mo56867j(message.custom());
        if (message.media() != null) {
            j.mo56865h(message.media().url());
            j.mo56866i(message.media().altText());
        }
        C4104a a = m3248a(j, message.sound());
        if (message.url() != null) {
            g = a.mo56864g(message.url());
            type = Type.CLOUD_PAGE;
        } else if (message.openDirect() != null) {
            g = a.mo56864g(message.openDirect());
            type = Type.OPEN_DIRECT;
        } else {
            a.mo56853a(Type.OTHER);
            return a.mo56880d();
        }
        g.mo56853a(type);
        return a.mo56880d();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static NotificationMessage m3250a(@NonNull Map<String, String> map) {
        C4104a g;
        Type type;
        Map map2 = null;
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (!f3298j.contains(str) && !str.startsWith("google.")) {
                if (map2 == null) {
                    map2 = new ArrayMap();
                }
                map2.put(str, next.getValue());
            }
        }
        C4104a b = m3247a().mo56852a(Trigger.PUSH).mo56854a(map.get(f3289a)).mo56862e(map.get("title")).mo56863f(map.get(f3291c)).mo56859c(map.get("alert")).mo56865h(map.get(f3294f)).mo56866i(map.get(f3295g)).mo56857b((Map<String, String>) new HashMap(map));
        if (map2 == null) {
            map2 = Collections.emptyMap();
        }
        C4104a a = m3248a(b.mo56855a((Map<String, String>) map2), map.get("sound"));
        if (map.containsKey(f3296h)) {
            g = a.mo56864g(map.get(f3296h));
            type = Type.CLOUD_PAGE;
        } else if (map.containsKey(f3297i)) {
            g = a.mo56864g(map.get(f3297i));
            type = Type.OPEN_DIRECT;
        } else {
            a.mo56853a(Type.OTHER);
            return a.mo56880d();
        }
        g.mo56853a(type);
        return a.mo56880d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract NotificationMessage mo56879a(int i);

    @NonNull
    @MCKeep
    public abstract String alert();

    @Nullable
    @MCKeep
    public abstract String custom();

    @NonNull
    @MCKeep
    public abstract Map<String, String> customKeys();

    @NonNull
    @MCKeep
    /* renamed from: id */
    public abstract String mo56835id();

    @Nullable
    @MCKeep
    public abstract String mediaAltText();

    @Nullable
    @MCKeep
    public abstract String mediaUrl();

    @MCKeep
    public abstract int notificationId();

    @Nullable
    @MCKeep
    public abstract Map<String, String> payload();

    @Nullable
    @MCKeep
    public abstract String regionId();

    @NonNull
    @MCKeep
    public abstract Sound sound();

    @Nullable
    @MCKeep
    public abstract String soundName();

    @Nullable
    @MCKeep
    public abstract String subTitle();

    @Nullable
    @MCKeep
    public abstract String title();

    @NonNull
    @MCKeep
    public abstract Trigger trigger();

    @NonNull
    @MCKeep
    public abstract Type type();

    @Nullable
    @MCKeep
    public abstract String url();
}
