package com.salesforce.marketingcloud.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.location.c */
final class C4046c extends C4058h {

    /* renamed from: m */
    private final JSONObject f2967m;

    /* renamed from: n */
    private final Boolean f2968n;

    /* renamed from: o */
    private final Exception f2969o;

    /* renamed from: p */
    private final boolean f2970p;

    /* renamed from: q */
    private final boolean f2971q;

    C4046c(MarketingCloudConfig marketingCloudConfig, Boolean bool, boolean z, Exception exc) {
        this.f2970p = marketingCloudConfig.geofencingEnabled();
        this.f2971q = marketingCloudConfig.proximityEnabled();
        this.f2968n = bool;
        this.f2969o = exc;
        this.f2967m = m2906a(marketingCloudConfig, bool, z, exc);
    }

    @Nullable
    /* renamed from: a */
    public JSONObject mo56200a() {
        return this.f2967m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo56202a(@NonNull InitializationStatus.C3832a aVar) {
        if (this.f2970p || this.f2971q) {
            aVar.mo56101a(true);
            Exception exc = this.f2969o;
            if (exc != null) {
                aVar.mo56103b(exc.getMessage());
                Exception exc2 = this.f2969o;
                if (exc2 instanceof C4059i) {
                    aVar.mo56095a(((C4059i) exc2).mo56596a());
                    return;
                }
                return;
            }
            Boolean bool = this.f2968n;
            if (bool != null && !bool.booleanValue()) {
                aVar.mo56103b(C4058h.f2987b);
                return;
            }
            return;
        }
        aVar.mo56101a(false);
    }

    /* renamed from: a */
    public void mo56571a(C4050e eVar) {
        C4039h.m2826d(f2989d, "LocationManager unavailable. registerForGeofenceRegionEvents ignored", new Object[0]);
    }

    /* renamed from: a */
    public void mo56572a(C4057g gVar) {
        C4039h.m2826d(f2989d, "LocationManager unavailable. registerForLocationUpdate ignored", new Object[0]);
    }

    /* renamed from: a */
    public void mo56573a(C4047d... dVarArr) {
        C4039h.m2826d(f2989d, "LocationManager unavailable. monitorGeofences ignored", new Object[0]);
    }

    /* renamed from: a */
    public void mo56574a(String... strArr) {
        C4039h.m2826d(f2989d, "LocationManager unavailable. unmonitorGeofences ignored", new Object[0]);
    }

    /* renamed from: b */
    public void mo56575b(C4050e eVar) {
        C4039h.m2826d(f2989d, "LocationManager unavailable. unregisterForGeofenceRegionEvents ignored", new Object[0]);
    }

    /* renamed from: b */
    public void mo56576b(C4057g gVar) {
        C4039h.m2826d(f2989d, "LocationManager unavailable. unregisterForLocationUpdate ignored", new Object[0]);
    }

    /* renamed from: c */
    public void mo56577c() {
        C4039h.m2826d(f2989d, "LocationManager unavailable. unmonitorAllGeofences ignored", new Object[0]);
    }
}
