package com.salesforce.marketingcloud.messages.geofence;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.location.C4050e;
import com.salesforce.marketingcloud.location.C4058h;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.C4079e;
import com.salesforce.marketingcloud.messages.C4080f;
import com.salesforce.marketingcloud.messages.C4083g;
import com.salesforce.marketingcloud.messages.Message;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p021c.C3953g;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p022d.C4017i;
import com.salesforce.marketingcloud.p022d.C4018j;
import com.salesforce.marketingcloud.p022d.C4019k;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.messages.geofence.b */
public final class C4085b implements C3949f.C3951a, C4050e, C4080f {

    /* renamed from: a */
    private static final String f3107a = C4039h.m2810a((Class<?>) C4085b.class);

    /* renamed from: b */
    private final C4058h f3108b;

    /* renamed from: c */
    private final C4016h f3109c;

    /* renamed from: d */
    private final C3872b f3110d;

    /* renamed from: e */
    private final C3949f f3111e;

    /* renamed from: f */
    private final C4080f.C4081a f3112f;

    /* renamed from: g */
    private C4080f.C4082b f3113g;

    /* renamed from: h */
    private AtomicBoolean f3114h = new AtomicBoolean(false);

    public C4085b(@NonNull C4016h hVar, @NonNull C4058h hVar2, @NonNull C3872b bVar, @NonNull C3949f fVar, @NonNull C4080f.C4081a aVar) {
        this.f3109c = (C4016h) C4028g.m2762a(hVar, "Storage was null");
        this.f3108b = (C4058h) C4028g.m2762a(hVar2, "LocationManager was null");
        this.f3110d = (C3872b) C4028g.m2762a(bVar, "AlarmScheduler was null");
        this.f3111e = (C3949f) C4028g.m2762a(fVar, "RequestManager was null");
        this.f3112f = (C4080f.C4081a) C4028g.m2762a(aVar, "RegionMessageHandler is null");
        fVar.mo56415a(C3944d.GEOFENCE_MESSAGE, (C3949f.C3951a) this);
    }

    /* renamed from: a */
    public static void m3060a(C4016h hVar, C4058h hVar2, C3872b bVar, C3949f fVar, boolean z) {
        List<String> b = hVar.mo56538j().mo56500b(1);
        if (!b.isEmpty()) {
            hVar2.mo56574a((String[]) b.toArray(new String[b.size()]));
        }
        if (z) {
            hVar.mo56539k().mo56503a(1);
            hVar.mo56538j().mo56492a(1);
            C4017i i = hVar.mo56537i();
            i.mo56486a(3);
            i.mo56486a(4);
        }
        fVar.mo56414a(C3944d.GEOFENCE_MESSAGE);
        bVar.mo56213c(C3848a.C3850a.FETCH_FENCE_MESSAGES, C3848a.C3850a.FETCH_FENCE_MESSAGES_DAILY);
    }

    /* renamed from: a */
    public void mo56714a() {
        if (this.f3114h.get()) {
            C4039h.m2817a(f3107a, "Attempt to monitor fences from DB ignored, because they're already monitored.", new Object[0]);
        }
        C4039h.m2817a(f3107a, "monitorStoredRegions", new Object[0]);
        try {
            List<Region> a = this.f3109c.mo56538j().mo56497a(1, this.f3109c.mo56524a());
            if (!a.isEmpty()) {
                for (Region c : a) {
                    this.f3108b.mo56573a(c.mo56688c());
                }
            }
        } catch (Exception e) {
            C4039h.m2830e(f3107a, e, "Unable to monitor stored geofence regions.", new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo56578a(int i, @Nullable String str) {
        C4039h.m2820b(f3107a, "Region error %d - %s", Integer.valueOf(i), str);
    }

    /* renamed from: a */
    public void mo56262a(C3946e eVar, C3953g gVar) {
        if (gVar.mo56419h()) {
            try {
                mo56726a(GeofenceMessageResponse.m3058b(new JSONObject(gVar.mo56359a())));
            } catch (Exception e) {
                C4039h.m2830e(f3107a, e, "Error parsing response.", new Object[0]);
                this.f3110d.mo56211b(C3848a.C3850a.FETCH_FENCE_MESSAGES);
            }
        } else {
            C4039h.m2823c(f3107a, "Request failed: %d - %s", Integer.valueOf(gVar.mo56361c()), gVar.mo56360b());
            this.f3110d.mo56211b(C3848a.C3850a.FETCH_FENCE_MESSAGES);
        }
    }

    /* renamed from: a */
    public void mo56715a(LatLon latLon, String str, MarketingCloudConfig marketingCloudConfig, C4080f.C4082b bVar) {
        this.f3113g = bVar;
        try {
            this.f3111e.mo56416a(C3944d.GEOFENCE_MESSAGE.mo56404a(marketingCloudConfig, C3944d.m2385a(marketingCloudConfig.applicationId(), str, latLon)));
        } catch (Exception e) {
            C4039h.m2830e(f3107a, e, "Failed to update geofence messages", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo56726a(GeofenceMessageResponse geofenceMessageResponse) {
        C4039h.m2823c(f3107a, "Geofence message request contained %d regions", Integer.valueOf(geofenceMessageResponse.fences().size()));
        this.f3110d.mo56214d(C3848a.C3850a.FETCH_FENCE_MESSAGES, C3848a.C3850a.FETCH_FENCE_MESSAGES_DAILY);
        this.f3110d.mo56211b(C3848a.C3850a.FETCH_FENCE_MESSAGES_DAILY);
        C4080f.C4082b bVar = this.f3113g;
        if (bVar != null) {
            bVar.mo56721a(geofenceMessageResponse);
        }
        C4018j k = this.f3109c.mo56539k();
        k.mo56503a(1);
        C4019k j = this.f3109c.mo56538j();
        List<String> b = j.mo56500b(1);
        j.mo56492a(1);
        C4017i i = this.f3109c.mo56537i();
        C4022a a = this.f3109c.mo56524a();
        if (!geofenceMessageResponse.fences().isEmpty()) {
            ArrayList<Region> arrayList = new ArrayList<>();
            for (Region next : geofenceMessageResponse.fences()) {
                try {
                    for (Message next2 : next.messages()) {
                        C4079e.m3043a(next2, i, a);
                        i.mo56490a(next2, a);
                        k.mo56505a(C4083g.m3054a(next.mo56647id(), next2.mo56608id()));
                    }
                    if (!b.remove(next.mo56647id())) {
                        arrayList.add(next);
                    }
                    j.mo56498a(next, a);
                } catch (Exception e) {
                    C4039h.m2830e(f3107a, e, "Unable to start monitoring geofence region: %s", next.mo56647id());
                }
            }
            for (Region c : arrayList) {
                this.f3108b.mo56573a(c.mo56688c());
            }
        }
        if (!b.isEmpty()) {
            this.f3108b.mo56574a((String[]) b.toArray(new String[b.size()]));
        }
        this.f3114h.set(true);
    }

    /* renamed from: a */
    public void mo56579a(@NonNull String str, int i) {
        C4039h.m2817a(f3107a, "Geofence (%s - %s) was tripped.", str, Integer.valueOf(i));
        if (i == 4) {
            C4039h.m2817a(f3107a, "Dwell transition ignore for %s", str);
            return;
        }
        try {
            Region a = this.f3109c.mo56538j().mo56496a(str, this.f3109c.mo56524a());
            if (a == null) {
                C4039h.m2823c(f3107a, "Removing stale geofence from being monitored.", new Object[0]);
                this.f3108b.mo56574a(str);
                return;
            }
            if (i == 1) {
                this.f3112f.mo56718a(a);
            } else {
                this.f3112f.mo56720b(a);
            }
            List<C4083g> a2 = this.f3109c.mo56539k().mo56504a(str);
            if (!a2.isEmpty()) {
                C4017i i2 = this.f3109c.mo56537i();
                C4022a a3 = this.f3109c.mo56524a();
                for (C4083g b : a2) {
                    Message a4 = i2.mo56489a(b.mo56710b(), a3);
                    if ((i == 1 && a4.messageType() == 3) || (i == 2 && a4.messageType() == 4)) {
                        this.f3112f.mo56719a(a, a4);
                    }
                }
                return;
            }
            C4039h.m2817a(f3107a, "No regionMessages found for %s", str);
        } catch (Exception e) {
            C4039h.m2830e(f3107a, e, "Geofence (%s - %d) was tripped, but failed to check for associated message", str, Integer.valueOf(i));
        }
    }

    /* renamed from: b */
    public void mo56716b() {
        this.f3108b.mo56571a((C4050e) this);
    }

    /* renamed from: c */
    public void mo56717c() {
        C4058h hVar = this.f3108b;
        if (hVar != null) {
            hVar.mo56575b((C4050e) this);
            C4016h hVar2 = this.f3109c;
            if (hVar2 != null) {
                List<String> b = hVar2.mo56538j().mo56500b(1);
                if (!b.isEmpty()) {
                    this.f3108b.mo56574a((String[]) b.toArray(new String[b.size()]));
                }
                this.f3109c.mo56539k().mo56503a(1);
                this.f3109c.mo56538j().mo56492a(1);
            }
        }
        this.f3114h.set(false);
    }

    /* renamed from: d */
    public boolean mo56727d() {
        return this.f3108b.mo56595d();
    }
}
