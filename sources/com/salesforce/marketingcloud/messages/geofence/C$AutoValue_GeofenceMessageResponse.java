package com.salesforce.marketingcloud.messages.geofence;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Region;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.messages.geofence.$AutoValue_GeofenceMessageResponse  reason: invalid class name */
abstract class C$AutoValue_GeofenceMessageResponse extends GeofenceMessageResponse {

    /* renamed from: a */
    private final LatLon f3102a;

    /* renamed from: b */
    private final int f3103b;

    /* renamed from: c */
    private final List<Region> f3104c;

    C$AutoValue_GeofenceMessageResponse(LatLon latLon, int i, List<Region> list) {
        if (latLon != null) {
            this.f3102a = latLon;
            this.f3103b = i;
            if (list != null) {
                this.f3104c = list;
                return;
            }
            throw new NullPointerException("Null fences");
        }
        throw new NullPointerException("Null refreshCenter");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeofenceMessageResponse)) {
            return false;
        }
        GeofenceMessageResponse geofenceMessageResponse = (GeofenceMessageResponse) obj;
        return this.f3102a.equals(geofenceMessageResponse.refreshCenter()) && this.f3103b == geofenceMessageResponse.refreshRadius() && this.f3104c.equals(geofenceMessageResponse.fences());
    }

    @NonNull
    @MCKeep
    public List<Region> fences() {
        return this.f3104c;
    }

    public int hashCode() {
        return ((((this.f3102a.hashCode() ^ 1000003) * 1000003) ^ this.f3103b) * 1000003) ^ this.f3104c.hashCode();
    }

    @NonNull
    public LatLon refreshCenter() {
        return this.f3102a;
    }

    public int refreshRadius() {
        return this.f3103b;
    }

    public String toString() {
        return "GeofenceMessageResponse{refreshCenter=" + this.f3102a + ", refreshRadius=" + this.f3103b + ", fences=" + this.f3104c + "}";
    }
}
