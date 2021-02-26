package com.salesforce.marketingcloud.messages.proximity;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Region;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.messages.proximity.$AutoValue_ProximityMessageResponse  reason: invalid class name */
abstract class C$AutoValue_ProximityMessageResponse extends ProximityMessageResponse {

    /* renamed from: a */
    private final LatLon f3218a;

    /* renamed from: b */
    private final int f3219b;

    /* renamed from: c */
    private final List<Region> f3220c;

    C$AutoValue_ProximityMessageResponse(LatLon latLon, int i, List<Region> list) {
        if (latLon != null) {
            this.f3218a = latLon;
            this.f3219b = i;
            if (list != null) {
                this.f3220c = list;
                return;
            }
            throw new NullPointerException("Null beacons");
        }
        throw new NullPointerException("Null refreshCenter");
    }

    @NonNull
    @MCKeep
    public List<Region> beacons() {
        return this.f3220c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProximityMessageResponse)) {
            return false;
        }
        ProximityMessageResponse proximityMessageResponse = (ProximityMessageResponse) obj;
        return this.f3218a.equals(proximityMessageResponse.refreshCenter()) && this.f3219b == proximityMessageResponse.refreshRadius() && this.f3220c.equals(proximityMessageResponse.beacons());
    }

    public int hashCode() {
        return ((((this.f3218a.hashCode() ^ 1000003) * 1000003) ^ this.f3219b) * 1000003) ^ this.f3220c.hashCode();
    }

    @NonNull
    public LatLon refreshCenter() {
        return this.f3218a;
    }

    public int refreshRadius() {
        return this.f3219b;
    }

    public String toString() {
        return "ProximityMessageResponse{refreshCenter=" + this.f3218a + ", refreshRadius=" + this.f3219b + ", beacons=" + this.f3220c + "}";
    }
}
