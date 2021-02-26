package com.salesforce.marketingcloud.analytics.p019b;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.C4039h;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
/* renamed from: com.salesforce.marketingcloud.analytics.b.n */
abstract class C3896n extends C3895m {
    /* access modifiers changed from: private */

    /* renamed from: w */
    public static final String f2332w = C4039h.m2810a((Class<?>) C3896n.class);

    @AutoValue
    /* renamed from: com.salesforce.marketingcloud.analytics.b.n$a */
    static abstract class C3897a {
        C3897a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract boolean mo56273a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract List<String> mo56274b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract JSONObject mo56290c();
    }

    /* renamed from: com.salesforce.marketingcloud.analytics.b.n$b */
    static class C3898b implements JsonTypeAdapter<C3897a> {
        C3898b() {
        }

        /* renamed from: a */
        public C3897a mo56247b(JSONObject jSONObject, String str) {
            return null;
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, C3897a aVar) {
            try {
                jSONObject.put(str, aVar.mo56290c());
            } catch (JSONException e) {
                C4039h.m2830e(C3896n.f2332w, e, "Failed to convert ObjectIds into JSONArray for PiOpenEvent payload.", new Object[0]);
            }
        }
    }

    C3896n() {
    }

    /* renamed from: a */
    public static C3896n m2216a(@NonNull Date date, boolean z, @NonNull List<String> list) {
        return new C3889g("track_event", FirebaseAnalytics.Event.APP_OPEN, date, new C3890h(z, list));
    }

    /* renamed from: a_ */
    public abstract JSONObject mo56289a_();

    /* renamed from: d */
    public abstract C3897a mo56269d();

    /* renamed from: e */
    public int mo56293e() {
        return 0;
    }
}
