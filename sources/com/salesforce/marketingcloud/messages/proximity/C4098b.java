package com.salesforce.marketingcloud.messages.proximity;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
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
import com.salesforce.marketingcloud.proximity.C4122e;
import com.salesforce.marketingcloud.proximity.C4124g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.messages.proximity.b */
public final class C4098b implements C3949f.C3951a, C4080f, C4124g.C4125a {

    /* renamed from: a */
    private static final String f3223a = C4039h.m2810a((Class<?>) C4098b.class);

    /* renamed from: b */
    private final C4016h f3224b;

    /* renamed from: c */
    private final C4124g f3225c;

    /* renamed from: d */
    private final C3872b f3226d;

    /* renamed from: e */
    private final C3949f f3227e;

    /* renamed from: f */
    private final C4080f.C4081a f3228f;

    /* renamed from: g */
    private C4080f.C4082b f3229g;

    public C4098b(@NonNull C4016h hVar, @NonNull C4124g gVar, @NonNull C3872b bVar, @NonNull C3949f fVar, @NonNull C4080f.C4081a aVar) {
        this.f3224b = (C4016h) C4028g.m2762a(hVar, "Storage was null");
        this.f3225c = (C4124g) C4028g.m2762a(gVar, "ProximityManager was null");
        this.f3226d = (C3872b) C4028g.m2762a(bVar, "AlarmScheduler was null");
        this.f3227e = (C3949f) C4028g.m2762a(fVar, "RequestManager was null");
        this.f3228f = (C4080f.C4081a) C4028g.m2762a(aVar, "RegionMessageHandler is null");
        fVar.mo56415a(C3944d.PROXIMITY_MESSAGES, (C3949f.C3951a) this);
    }

    /* renamed from: a */
    public static void m3189a(C4016h hVar, C4124g gVar, C3872b bVar, C3949f fVar, boolean z) {
        gVar.mo56925d();
        if (z) {
            hVar.mo56539k().mo56503a(3);
            hVar.mo56538j().mo56492a(3);
            hVar.mo56537i().mo56486a(5);
        }
        fVar.mo56414a(C3944d.PROXIMITY_MESSAGES);
        bVar.mo56213c(C3848a.C3850a.FETCH_BEACON_MESSAGES, C3848a.C3850a.FETCH_BEACON_MESSAGES_DAILY);
    }

    /* renamed from: a */
    public void mo56714a() {
        C4039h.m2823c(f3223a, "monitorStoredRegions", new Object[0]);
        try {
            List<Region> a = this.f3224b.mo56538j().mo56497a(3, this.f3224b.mo56524a());
            if (!a.isEmpty()) {
                ArrayList arrayList = new ArrayList(a.size());
                for (Region a2 : a) {
                    arrayList.add(C4122e.m3337a(a2));
                }
                this.f3225c.mo56923b((List<C4122e>) arrayList);
            }
        } catch (Exception unused) {
            C4039h.m2829e(f3223a, "Unable to monitor stored proximity regions.", new Object[0]);
        }
    }

    /* renamed from: a */
    public void mo56262a(C3946e eVar, C3953g gVar) {
        if (gVar.mo56419h()) {
            try {
                mo56811a(ProximityMessageResponse.m3187b(new JSONObject(gVar.mo56359a())));
            } catch (Exception e) {
                C4039h.m2830e(f3223a, e, "Error parsing response.", new Object[0]);
                this.f3226d.mo56211b(C3848a.C3850a.FETCH_BEACON_MESSAGES);
            }
        } else {
            C4039h.m2823c(f3223a, "Request failed: %d - %s", Integer.valueOf(gVar.mo56361c()), gVar.mo56360b());
            this.f3226d.mo56211b(C3848a.C3850a.FETCH_BEACON_MESSAGES);
        }
    }

    /* renamed from: a */
    public void mo56715a(LatLon latLon, String str, MarketingCloudConfig marketingCloudConfig, C4080f.C4082b bVar) {
        this.f3229g = bVar;
        try {
            this.f3227e.mo56416a(C3944d.PROXIMITY_MESSAGES.mo56404a(marketingCloudConfig, C3944d.m2385a(marketingCloudConfig.applicationId(), str, latLon)));
        } catch (Exception e) {
            C4039h.m2830e(f3223a, e, "Failed to update proximity messages", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo56811a(ProximityMessageResponse proximityMessageResponse) {
        C4039h.m2823c(f3223a, "Proximity message request contained %d regions", Integer.valueOf(proximityMessageResponse.beacons().size()));
        this.f3226d.mo56214d(C3848a.C3850a.FETCH_BEACON_MESSAGES, C3848a.C3850a.FETCH_BEACON_MESSAGES_DAILY);
        this.f3226d.mo56211b(C3848a.C3850a.FETCH_BEACON_MESSAGES_DAILY);
        C4080f.C4082b bVar = this.f3229g;
        if (bVar != null) {
            bVar.mo56721a(proximityMessageResponse);
        }
        C4018j k = this.f3224b.mo56539k();
        k.mo56503a(3);
        C4022a a = this.f3224b.mo56524a();
        C4019k j = this.f3224b.mo56538j();
        List<Region> a2 = j.mo56497a(3, this.f3224b.mo56524a());
        if (!a2.isEmpty()) {
            Collections.sort(a2);
        }
        j.mo56492a(3);
        C4017i i = this.f3224b.mo56537i();
        if (!proximityMessageResponse.beacons().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Region next : proximityMessageResponse.beacons()) {
                try {
                    for (Message next2 : next.messages()) {
                        C4079e.m3043a(next2, i, a);
                        i.mo56490a(next2, a);
                        k.mo56505a(C4083g.m3054a(next.mo56647id(), next2.mo56608id()));
                    }
                    int binarySearch = Collections.binarySearch(a2, next);
                    if (binarySearch >= 0) {
                        next.mo56686a(a2.remove(binarySearch).mo56687b());
                    }
                    j.mo56498a(next, a);
                    arrayList.add(C4122e.m3337a(next));
                } catch (Exception e) {
                    C4039h.m2830e(f3223a, e, "Unable to start monitoring proximity region: %s", next.mo56647id());
                }
            }
            this.f3225c.mo56923b((List<C4122e>) arrayList);
        }
        if (!a2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(a2.size());
            for (Region a3 : a2) {
                arrayList2.add(C4122e.m3337a(a3));
            }
            this.f3225c.mo56920a((List<C4122e>) arrayList2);
        }
    }

    /* renamed from: a */
    public void mo56812a(@NonNull C4122e eVar) {
        C4039h.m2817a(f3223a, "Proximity region (%s) entered.", eVar.mo56901a());
        try {
            C4019k j = this.f3224b.mo56538j();
            Region a = j.mo56496a(eVar.mo56901a(), this.f3224b.mo56524a());
            if (a == null) {
                C4039h.m2820b(f3223a, "BeaconRegion [%s] did not have matching Region in storage.", eVar);
            } else if (!a.mo56687b()) {
                C4039h.m2817a(f3223a, "Region [%s] was entered.  Will attempt to show associated message.", a.mo56647id());
                a.mo56686a(true);
                j.mo56494a(a.mo56647id(), true);
                this.f3228f.mo56718a(a);
                List<C4083g> a2 = this.f3224b.mo56539k().mo56504a(a.mo56647id());
                if (!a2.isEmpty()) {
                    C4017i i = this.f3224b.mo56537i();
                    C4022a a3 = this.f3224b.mo56524a();
                    for (C4083g b : a2) {
                        this.f3228f.mo56719a(a, i.mo56489a(b.mo56710b(), a3));
                    }
                }
            } else {
                C4039h.m2820b(f3223a, "Ignoring entry event.  Already inside Region [%s]", a);
            }
        } catch (Exception e) {
            C4039h.m2830e(f3223a, e, "Proximity region (%s) was entered, but failed to check for associated message", eVar.mo56901a());
        }
    }

    /* renamed from: b */
    public void mo56716b() {
        this.f3225c.mo56919a((C4124g.C4125a) this);
    }

    /* renamed from: b */
    public void mo56813b(@NonNull C4122e eVar) {
        C4039h.m2817a(f3223a, "Proximity region (%s) exited.", eVar.mo56901a());
        C4019k j = this.f3224b.mo56538j();
        Region a = this.f3224b.mo56538j().mo56496a(eVar.mo56901a(), this.f3224b.mo56524a());
        if (a == null) {
            C4039h.m2820b(f3223a, "BeaconRegion [%s] did not have matching Region in storage.", eVar);
        } else if (a.mo56687b()) {
            a.mo56686a(false);
            this.f3228f.mo56720b(a);
            j.mo56494a(a.mo56647id(), false);
        } else {
            C4039h.m2820b(f3223a, "Ignoring exit event.  Was not inside BeaconRegion [%s]", eVar);
        }
    }

    /* renamed from: c */
    public void mo56717c() {
        this.f3225c.mo56925d();
        this.f3225c.mo56922b((C4124g.C4125a) this);
        C4019k j = this.f3224b.mo56538j();
        j.mo56491a();
        this.f3224b.mo56539k().mo56503a(3);
        j.mo56492a(3);
    }

    /* renamed from: d */
    public boolean mo56814d() {
        return this.f3225c.mo56924c();
    }
}
