package com.salesforce.marketingcloud.messages.proximity;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.messages.MessageResponse;
import com.salesforce.marketingcloud.messages.Region;
import java.util.List;
import org.json.JSONObject;

@AutoValue
public abstract class ProximityMessageResponse extends MessageResponse {
    /* renamed from: b */
    static ProximityMessageResponse m3187b(JSONObject jSONObject) {
        return C4097a.m3188a(jSONObject);
    }

    @NonNull
    @MCKeep
    public abstract List<Region> beacons();
}
