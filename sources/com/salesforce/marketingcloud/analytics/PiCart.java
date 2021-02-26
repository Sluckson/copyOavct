package com.salesforce.marketingcloud.analytics;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MCKeep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
public abstract class PiCart implements Parcelable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f2265a = C4039h.m2810a((Class<?>) PiCart.class);

    /* renamed from: com.salesforce.marketingcloud.analytics.PiCart$a */
    static class C3876a implements JsonTypeAdapter<List<PiCartItem>> {
        C3876a() {
        }

        /* renamed from: a */
        public List<PiCartItem> mo56247b(JSONObject jSONObject, String str) {
            return null;
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, List<PiCartItem> list) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!list.isEmpty()) {
                    for (PiCartItem a : list) {
                        jSONArray.put(a.mo56248a());
                    }
                }
                jSONObject.put(str, jSONArray);
            } catch (JSONException e) {
                C4039h.m2830e(PiCart.f2265a, e, "Failed to convert List<PiCartItem> into JSONArray for PiCart payload.", new Object[0]);
            }
        }
    }

    @NonNull
    @MCKeep
    public static PiCart create(@NonNull List<PiCartItem> list) {
        return new C3914f(new ArrayList(list));
    }

    @NonNull
    /* renamed from: a */
    public abstract JSONObject mo56243a();

    @NonNull
    @MCKeep
    public abstract List<PiCartItem> cartItems();
}
