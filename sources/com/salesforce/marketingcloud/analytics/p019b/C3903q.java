package com.salesforce.marketingcloud.analytics.p019b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.b.q */
final class C3903q extends C3895m {

    /* renamed from: w */
    private static final String f2335w = "";

    /* renamed from: x */
    private static final String f2336x = C4039h.m2810a((Class<?>) C3903q.class);

    /* renamed from: A */
    private String f2337A;

    /* renamed from: B */
    private String f2338B;

    /* renamed from: C */
    private Date f2339C;

    /* renamed from: y */
    private String f2340y;

    /* renamed from: z */
    private String f2341z;

    C3903q(@Size(min = 1) @NonNull String str, String str2, String str3, String str4, Date date) {
        this.f2337A = mo56294a("url", str, true);
        this.f2338B = mo56294a("title", str2, false);
        this.f2340y = mo56294a("item", str3, false);
        this.f2341z = mo56294a(FirebaseAnalytics.Event.SEARCH, str4, false);
        this.f2339C = date;
    }

    /* renamed from: a */
    public String mo56263a() {
        return "track_view";
    }

    @Nullable
    /* renamed from: a_ */
    public JSONObject mo56289a_() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api_endpoint", mo56263a());
            if (this.f2339C != null) {
                jSONObject.put("timestamp", C4029h.m2766a(this.f2339C));
            }
            if (!TextUtils.isEmpty(this.f2337A)) {
                jSONObject.put("url", this.f2337A);
            }
            if (!TextUtils.isEmpty(this.f2340y)) {
                jSONObject.put("item", this.f2340y);
            }
            if (!TextUtils.isEmpty(this.f2341z)) {
                jSONObject.put(FirebaseAnalytics.Event.SEARCH, this.f2341z);
            }
            if (!TextUtils.isEmpty(this.f2338B)) {
                jSONObject.put("title", this.f2338B);
            }
            return jSONObject;
        } catch (JSONException e) {
            C4039h.m2830e(f2336x, e, "Failed to convert our object to JSON.", new Object[0]);
            return null;
        }
    }

    /* renamed from: b */
    public String mo56264b() {
        return "";
    }

    /* renamed from: c */
    public Date mo56265c() {
        return this.f2339C;
    }

    /* renamed from: e */
    public int mo56293e() {
        return C3910d.f2395q;
    }
}
