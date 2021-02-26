package com.salesforce.marketingcloud.messages;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.location.C4047d;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.C$AutoValue_Region;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
public abstract class Region implements Comparable<Region> {
    @MCKeep
    public static final int REGION_TYPE_FENCE = 1;
    @MCKeep
    public static final int REGION_TYPE_PROXIMITY = 3;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f3086a = C4039h.m2810a((Class<?>) Region.class);

    /* renamed from: b */
    private boolean f3087b;

    @MCKeep
    @Retention(RetentionPolicy.SOURCE)
    public @interface RegionType {
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @AutoValue.Builder
    /* renamed from: com.salesforce.marketingcloud.messages.Region$a */
    public static abstract class C4071a {
        /* renamed from: a */
        public abstract C4071a mo56656a(int i);

        /* renamed from: a */
        public abstract C4071a mo56657a(LatLon latLon);

        /* renamed from: a */
        public abstract C4071a mo56658a(String str);

        /* renamed from: a */
        public abstract C4071a mo56659a(List<Message> list);

        /* renamed from: a */
        public abstract Region mo56660a();

        /* renamed from: b */
        public abstract C4071a mo56661b(int i);

        /* renamed from: b */
        public abstract C4071a mo56662b(String str);

        /* renamed from: c */
        public abstract C4071a mo56663c(int i);

        /* renamed from: c */
        public abstract C4071a mo56664c(String str);

        /* renamed from: d */
        public abstract C4071a mo56665d(int i);

        /* renamed from: d */
        public abstract C4071a mo56666d(String str);
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: com.salesforce.marketingcloud.messages.Region$b */
    public static final class C4072b extends Region {

        /* renamed from: a */
        public static final String f3088a = "~~m@g1c_f3nc3~~";

        /* renamed from: b */
        private static final double f3089b = 0.8d;

        /* renamed from: c */
        private final LatLon f3090c;

        /* renamed from: d */
        private final int f3091d;

        public C4072b(LatLon latLon, int i) {
            this.f3090c = latLon;
            this.f3091d = i;
        }

        /* renamed from: c */
        public C4047d mo56688c() {
            return C4047d.m2871a(mo56647id(), (float) (((double) radius()) * f3089b), center().latitude(), center().longitude(), 2);
        }

        @NonNull
        public LatLon center() {
            return this.f3090c;
        }

        public /* synthetic */ int compareTo(@NonNull Object obj) {
            return Region.super.compareTo((Region) obj);
        }

        @Nullable
        public String description() {
            return "MagicFence";
        }

        @NonNull
        /* renamed from: id */
        public String mo56647id() {
            return f3088a;
        }

        public int major() {
            return 0;
        }

        @NonNull
        public List<Message> messages() {
            return Collections.emptyList();
        }

        public int minor() {
            return 0;
        }

        @Nullable
        public String name() {
            return "MagicFence";
        }

        @Nullable
        public String proximityUuid() {
            return null;
        }

        public int radius() {
            return this.f3091d;
        }

        public int regionType() {
            return -1;
        }
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: com.salesforce.marketingcloud.messages.Region$c */
    public static class C4073c implements JsonTypeAdapter<List<Region>> {
        /* renamed from: a */
        public final List<Region> mo56247b(JSONObject jSONObject, String str) {
            List<Region> emptyList = Collections.emptyList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                if (length <= 0) {
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < length) {
                    try {
                        arrayList.add(Region.m3013a(jSONArray.getJSONObject(i)));
                        i++;
                    } catch (JSONException e) {
                        e = e;
                        emptyList = arrayList;
                        C4039h.m2830e(Region.f3086a, e, "Unable to read regions from json payload", new Object[0]);
                        return emptyList;
                    }
                }
                return arrayList;
            } catch (JSONException e2) {
                e = e2;
                C4039h.m2830e(Region.f3086a, e, "Unable to read regions from json payload", new Object[0]);
                return emptyList;
            }
        }

        /* renamed from: a */
        public final void mo56245a(JSONObject jSONObject, String str, List<Region> list) {
        }
    }

    /* renamed from: a */
    private static int m3011a(int i) {
        if (i < 100) {
            return 100;
        }
        return i;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static C4071a m3012a() {
        return new C$AutoValue_Region.C4067a().mo56659a((List<Message>) Collections.emptyList());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static Region m3013a(JSONObject jSONObject) {
        return C4077c.m3039a(jSONObject);
    }

    /* renamed from: a */
    public int compareTo(@NonNull Region region) {
        return mo56647id().compareTo(region.mo56647id());
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void mo56686a(boolean z) {
        this.f3087b = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public boolean mo56687b() {
        return this.f3087b;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: c */
    public C4047d mo56688c() {
        return C4047d.m2871a(mo56647id(), (float) m3011a(radius()), center().latitude(), center().longitude(), 3);
    }

    @NonNull
    @MCKeep
    public abstract LatLon center();

    @Nullable
    @MCKeep
    public abstract String description();

    @NonNull
    @MCKeep
    /* renamed from: id */
    public abstract String mo56647id();

    @MCKeep
    public abstract int major();

    @NonNull
    @MCKeep
    public abstract List<Message> messages();

    @MCKeep
    public abstract int minor();

    @Nullable
    @MCKeep
    public abstract String name();

    @Nullable
    @MCKeep
    public abstract String proximityUuid();

    @MCKeep
    public abstract int radius();

    @MCKeep
    public abstract int regionType();
}
