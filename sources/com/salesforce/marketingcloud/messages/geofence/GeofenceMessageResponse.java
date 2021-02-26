package com.salesforce.marketingcloud.messages.geofence;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.MessageResponse;
import com.salesforce.marketingcloud.messages.Region;
import java.util.List;
import org.json.JSONObject;

@AutoValue
public abstract class GeofenceMessageResponse extends MessageResponse {
    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.TESTS})
    /* renamed from: a */
    public static GeofenceMessageResponse m3057a(LatLon latLon, int i, List<Region> list) {
        return new C4084a(latLon, i, list);
    }

    /* renamed from: b */
    static GeofenceMessageResponse m3058b(JSONObject jSONObject) {
        return C4084a.m3059a(jSONObject);
    }

    @NonNull
    @MCKeep
    public abstract List<Region> fences();
}
