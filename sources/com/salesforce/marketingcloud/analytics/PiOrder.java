package com.salesforce.marketingcloud.analytics;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MCKeep;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
public abstract class PiOrder implements Parcelable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f2266a = C4039h.m2810a((Class<?>) PiOrder.class);

    /* renamed from: com.salesforce.marketingcloud.analytics.PiOrder$a */
    static class C3877a implements JsonTypeAdapter<PiCart> {
        C3877a() {
        }

        /* renamed from: a */
        public PiCart mo56247b(JSONObject jSONObject, String str) {
            return null;
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, PiCart piCart) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (PiCartItem a : piCart.cartItems()) {
                    jSONArray.put(a.mo56248a());
                }
                jSONObject.put(str, jSONArray);
            } catch (JSONException e) {
                C4039h.m2830e(PiOrder.f2266a, e, "Failed to add our PiCart to the Order.", new Object[0]);
            }
        }
    }

    @NonNull
    @MCKeep
    public static PiOrder create(@NonNull PiCart piCart, @NonNull String str, double d, double d2) {
        return new C3918h(piCart, str, d, d2);
    }

    @NonNull
    /* renamed from: a */
    public abstract JSONObject mo56249a();

    @NonNull
    @MCKeep
    public abstract PiCart cart();

    @MCKeep
    public abstract double discount();

    @NonNull
    @MCKeep
    public abstract String orderNumber();

    @MCKeep
    public abstract double shipping();
}
