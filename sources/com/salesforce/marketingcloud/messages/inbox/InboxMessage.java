package com.salesforce.marketingcloud.messages.inbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.messages.inbox.C$AutoValue_InboxMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
public abstract class InboxMessage {

    /* renamed from: a */
    public static final int f3169a = 8;

    /* renamed from: b */
    public static final int f3170b = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: c */
    public static final int f3171c = 1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f3172d = C4039h.m2810a((Class<?>) InboxMessage.class);

    /* renamed from: e */
    private static final String f3173e = "_sid";

    /* renamed from: f */
    private static final String f3174f = "timestamp";

    /* renamed from: g */
    private static final String f3175g = "_mt";

    /* renamed from: h */
    private static final String f3176h = "_m";

    /* renamed from: i */
    private static final String f3177i = "custom";

    /* renamed from: j */
    private static final String f3178j = "_r";

    /* renamed from: k */
    private static final String f3179k = "_h";

    /* renamed from: l */
    private static final String f3180l = "title";

    /* renamed from: m */
    private static final String f3181m = "subtitle";

    /* renamed from: n */
    private static final String f3182n = "alert";

    /* renamed from: o */
    private static final String f3183o = "sound";

    /* renamed from: p */
    private static final String f3184p = "_mediaUrl";

    /* renamed from: q */
    private static final String f3185q = "_mediaAlt";

    /* renamed from: r */
    private static final String f3186r = "_x";

    /* renamed from: s */
    private static final String f3187s = "_od";

    /* renamed from: t */
    private static final List<String> f3188t;

    /* renamed from: u */
    private boolean f3189u;

    /* renamed from: v */
    private boolean f3190v;

    @AutoValue
    @MCKeep
    public static abstract class Media {
        @SuppressLint({"UnknownNullness"})
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Media create(String str, String str2) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                return new C4093b(str, str2);
            }
            throw new IllegalStateException("Invalid media provided.");
        }

        @Nullable
        public abstract String altText();

        @Nullable
        public abstract String url();
    }

    @SuppressLint({"UnknownNullness"})
    @AutoValue.Builder
    /* renamed from: com.salesforce.marketingcloud.messages.inbox.InboxMessage$a */
    public static abstract class C4090a {
        /* renamed from: a */
        public abstract C4090a mo56749a(int i);

        /* renamed from: a */
        public abstract C4090a mo56750a(Media media);

        /* renamed from: a */
        public abstract C4090a mo56751a(String str);

        /* renamed from: a */
        public abstract C4090a mo56752a(Date date);

        /* renamed from: a */
        public abstract C4090a mo56753a(Map<String, String> map);

        /* renamed from: a */
        public abstract InboxMessage mo56754a();

        /* renamed from: b */
        public abstract C4090a mo56755b(int i);

        /* renamed from: b */
        public abstract C4090a mo56756b(String str);

        /* renamed from: b */
        public abstract C4090a mo56757b(Date date);

        /* renamed from: c */
        public abstract C4090a mo56758c(String str);

        /* renamed from: d */
        public abstract C4090a mo56759d(String str);

        /* renamed from: e */
        public abstract C4090a mo56760e(String str);

        /* renamed from: f */
        public abstract C4090a mo56761f(String str);

        /* renamed from: g */
        public abstract C4090a mo56762g(String str);

        /* renamed from: h */
        public abstract C4090a mo56763h(String str);

        /* renamed from: i */
        public abstract C4090a mo56764i(String str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: com.salesforce.marketingcloud.messages.inbox.InboxMessage$b */
    static class C4091b implements JsonTypeAdapter<Media> {
        C4091b() {
        }

        /* renamed from: a */
        public Media mo56247b(JSONObject jSONObject, String str) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject == null) {
                return null;
            }
            try {
                return Media.create(optJSONObject.optString("androidUrl"), optJSONObject.optString("alt"));
            } catch (Exception e) {
                C4039h.m2830e(InboxMessage.f3172d, e, "Unable to create media object from json: ", optJSONObject);
                return null;
            }
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, Media media) {
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f3176h);
        arrayList.add("title");
        arrayList.add(f3181m);
        arrayList.add("alert");
        arrayList.add("sound");
        arrayList.add(f3184p);
        arrayList.add(f3185q);
        arrayList.add(f3186r);
        arrayList.add(f3187s);
        arrayList.add(f3175g);
        arrayList.add(f3179k);
        arrayList.add(f3178j);
        arrayList.add(f3173e);
        arrayList.add("timestamp");
        arrayList.add("custom");
        f3188t = Collections.unmodifiableList(arrayList);
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static InboxMessage m3125a(@NonNull Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            if (!f3188t.contains(str) && !str.startsWith("google.")) {
                hashMap.put(str, bundle.getString(str));
            }
        }
        Media media = null;
        String string = bundle.getString(f3184p);
        String string2 = bundle.getString(f3185q);
        if (!TextUtils.isEmpty(string)) {
            media = Media.create(string, string2);
        }
        C4090a i = m3127e().mo56763h(bundle.getString(f3176h)).mo56760e(bundle.getString("title")).mo56761f(bundle.getString("alert")).mo56755b(2).mo56749a(8).mo56753a((Map<String, String>) hashMap).mo56759d(bundle.getString("custom")).mo56762g(bundle.getString("sound")).mo56751a(bundle.getString(f3178j)).mo56756b(bundle.getString(f3179k)).mo56764i(bundle.getString(f3186r));
        if (media != null) {
            i.mo56750a(media);
        }
        return i.mo56754a();
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public static InboxMessage m3126b(JSONObject jSONObject) {
        return C4092a.m3156a(jSONObject);
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: e */
    public static C4090a m3127e() {
        return new C$AutoValue_InboxMessage.C4089a();
    }

    @Nullable
    /* renamed from: a */
    public abstract String mo56731a();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56765a(boolean z) {
        this.f3189u = z;
    }

    @Nullable
    @MCKeep
    public abstract String alert();

    @Nullable
    /* renamed from: b */
    public abstract String mo56733b();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public final void mo56766b(boolean z) {
        this.f3190v = z;
    }

    /* renamed from: c */
    public abstract int mo56734c();

    @Nullable
    @MCKeep
    public abstract String custom();

    @Nullable
    @MCKeep
    public abstract Map<String, String> customKeys();

    /* renamed from: d */
    public abstract int mo56737d();

    @SuppressLint({"KotlinPropertyAccess"})
    @MCKeep
    public final boolean deleted() {
        return this.f3190v;
    }

    @Nullable
    @MCKeep
    public abstract Date endDateUtc();

    @NonNull
    @MCKeep
    /* renamed from: id */
    public abstract String mo56741id();

    @Nullable
    @MCKeep
    public abstract Media media();

    @SuppressLint({"KotlinPropertyAccess"})
    @MCKeep
    public final boolean read() {
        return this.f3189u;
    }

    @Nullable
    @MCKeep
    public abstract String sound();

    @Nullable
    @MCKeep
    public abstract Date startDateUtc();

    @Nullable
    @MCKeep
    public abstract String subject();

    @Nullable
    @MCKeep
    public abstract String title();

    @NonNull
    @MCKeep
    public abstract String url();
}
