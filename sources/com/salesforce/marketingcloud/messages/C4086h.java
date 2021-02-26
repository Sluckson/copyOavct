package com.salesforce.marketingcloud.messages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import com.salesforce.marketingcloud.C3956d;
import com.salesforce.marketingcloud.C4037f;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.location.C4050e;
import com.salesforce.marketingcloud.location.C4057g;
import com.salesforce.marketingcloud.location.C4058h;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.C4080f;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.geofence.C4085b;
import com.salesforce.marketingcloud.messages.geofence.GeofenceMessageResponse;
import com.salesforce.marketingcloud.messages.proximity.C4098b;
import com.salesforce.marketingcloud.messages.proximity.ProximityMessageResponse;
import com.salesforce.marketingcloud.notifications.C4108c;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3930b;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p022d.C4019k;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4026e;
import com.salesforce.marketingcloud.p027e.C4028g;
import com.salesforce.marketingcloud.proximity.C4124g;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.messages.h */
public class C4086h implements C3872b.C3874a, C3930b, C4037f, C4050e, C4057g, RegionMessageManager, C4080f.C4081a, C4080f.C4082b {
    @VisibleForTesting

    /* renamed from: a */
    static final String f3115a = "et_geo_enabled_key";
    @VisibleForTesting

    /* renamed from: b */
    static final String f3116b = "et_proximity_enabled_key";
    @VisibleForTesting

    /* renamed from: c */
    static final int f3117c = 5000;

    /* renamed from: d */
    static final String f3118d = C4039h.m2810a((Class<?>) C4086h.class);

    /* renamed from: e */
    private final C3872b f3119e;

    /* renamed from: f */
    private final C4058h f3120f;

    /* renamed from: g */
    private final C4124g f3121g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C4016h f3122h;

    /* renamed from: i */
    private final MarketingCloudConfig f3123i;

    /* renamed from: j */
    private final String f3124j;

    /* renamed from: k */
    private final Context f3125k;

    /* renamed from: l */
    private final C4108c f3126l;

    /* renamed from: m */
    private final C3931c f3127m;

    /* renamed from: n */
    private final C3949f f3128n;

    /* renamed from: o */
    private final Set<RegionMessageManager.GeofenceMessageResponseListener> f3129o = new ArraySet();

    /* renamed from: p */
    private final Set<RegionMessageManager.ProximityMessageResponseListener> f3130p = new ArraySet();

    /* renamed from: q */
    private final Set<RegionMessageManager.RegionTransitionEventListener> f3131q = new ArraySet();

    /* renamed from: r */
    private final AtomicBoolean f3132r = new AtomicBoolean(false);

    /* renamed from: s */
    private C4085b f3133s;

    /* renamed from: t */
    private C4098b f3134t;

    /* renamed from: com.salesforce.marketingcloud.messages.h$2 */
    static /* synthetic */ class C40882 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3137a = new int[C3848a.C3850a.values().length];

        /* renamed from: b */
        static final /* synthetic */ int[] f3138b = new int[C3929a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        static {
            /*
                com.salesforce.marketingcloud.b.a[] r0 = com.salesforce.marketingcloud.p020b.C3929a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3138b = r0
                r0 = 1
                int[] r1 = f3138b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.marketingcloud.b.a r2 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_DEVICE_BOOT_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f3138b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.marketingcloud.b.a r3 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_APP_PACKAGE_REPLACED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f3138b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.salesforce.marketingcloud.b.a r4 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_DEVICE_SHUTDOWN     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f3138b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.salesforce.marketingcloud.b.a r5 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_APP_FOREGROUNDED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                com.salesforce.marketingcloud.a.a$a[] r4 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f3137a = r4
                int[] r4 = f3137a     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.salesforce.marketingcloud.a.a$a r5 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.FETCH_FENCE_MESSAGES     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.salesforce.marketingcloud.a.a$a r4 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.FETCH_FENCE_MESSAGES_DAILY     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.salesforce.marketingcloud.a.a$a r1 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.FETCH_BEACON_MESSAGES     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x0066 }
                com.salesforce.marketingcloud.a.a$a r1 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.FETCH_BEACON_MESSAGES_DAILY     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.C4086h.C40882.<clinit>():void");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public C4086h(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @NonNull C4016h hVar, @NonNull String str, @NonNull C4058h hVar2, @NonNull C4124g gVar, @NonNull C3931c cVar, @NonNull C3872b bVar, @NonNull C3949f fVar, @NonNull C4108c cVar2, RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        this.f3125k = (Context) C4028g.m2762a(context, "Context was null");
        this.f3122h = (C4016h) C4028g.m2762a(hVar, "Storage was null");
        this.f3120f = (C4058h) C4028g.m2762a(hVar2, "LocationManager was null");
        this.f3121g = (C4124g) C4028g.m2762a(gVar, "ProximityManager was null");
        this.f3126l = (C4108c) C4028g.m2762a(cVar2, "NotificationManager was null");
        this.f3119e = (C3872b) C4028g.m2762a(bVar, "AlarmScheduler was null");
        this.f3127m = (C3931c) C4028g.m2762a(cVar, "BehaviorManager was null");
        this.f3128n = (C3949f) C4028g.m2762a(fVar, "RequestManager was null");
        this.f3124j = (String) C4028g.m2762a(str, "DeviceId was null");
        this.f3123i = (MarketingCloudConfig) C4028g.m2762a(marketingCloudConfig, "MarketingCloudConfig was null");
        this.f3131q.add(C4028g.m2762a(regionTransitionEventListener, "RegionAnalyticEventListener is null."));
    }

    /* renamed from: a */
    private void m3071a(int i, Region region) {
        synchronized (this.f3131q) {
            if (!this.f3131q.isEmpty()) {
                for (RegionMessageManager.RegionTransitionEventListener next : this.f3131q) {
                    if (next != null) {
                        try {
                            next.onTransitionEvent(i, region);
                        } catch (Exception e) {
                            C4039h.m2830e(f3118d, e, "%s threw an exception while processing the region (%s) transition (%d)", next.getClass().getName(), region.mo56647id(), Integer.valueOf(i));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m3072a(LatLon latLon) {
        C4085b bVar;
        if (!isGeofenceMessagingEnabled() || (bVar = this.f3133s) == null || latLon == null) {
            C4039h.m2820b(f3118d, "Tried to update geofence messages, but was not enabled.", new Object[0]);
        } else {
            bVar.mo56715a(latLon, this.f3124j, this.f3123i, this);
        }
    }

    /* renamed from: a */
    private void m3073a(LatLon latLon, int i) {
        if (m3085h()) {
            try {
                Region.C4072b bVar = new Region.C4072b(latLon, i);
                this.f3122h.mo56538j().mo56498a((Region) bVar, this.f3122h.mo56524a());
                this.f3120f.mo56573a(bVar.mo56688c());
            } catch (Exception e) {
                C4039h.m2830e(f3118d, e, "Unable to set magic region", new Object[0]);
            }
        }
    }

    /* renamed from: b */
    private void m3074b(LatLon latLon) {
        C4098b bVar;
        if (!isProximityMessagingEnabled() || (bVar = this.f3134t) == null || latLon == null) {
            C4039h.m2820b(f3118d, "Tried to update proximity messages, but was not enabled.", new Object[0]);
        } else {
            bVar.mo56715a(latLon, this.f3124j, this.f3123i, this);
        }
    }

    /* renamed from: b */
    private void m3075b(MessageResponse messageResponse) {
        if (messageResponse instanceof GeofenceMessageResponse) {
            synchronized (this.f3129o) {
                if (!this.f3129o.isEmpty()) {
                    for (RegionMessageManager.GeofenceMessageResponseListener next : this.f3129o) {
                        if (next != null) {
                            try {
                                next.onGeofenceMessageResponse((GeofenceMessageResponse) messageResponse);
                            } catch (Exception e) {
                                C4039h.m2830e(f3118d, e, "%s threw an exception while processing the geofence response", next.getClass().getName());
                            }
                        }
                    }
                }
            }
        } else if (messageResponse instanceof ProximityMessageResponse) {
            synchronized (this.f3130p) {
                if (!this.f3130p.isEmpty()) {
                    for (RegionMessageManager.ProximityMessageResponseListener next2 : this.f3130p) {
                        if (next2 != null) {
                            try {
                                next2.onProximityMessageResponse((ProximityMessageResponse) messageResponse);
                            } catch (Exception e2) {
                                C4039h.m2830e(f3118d, e2, "%s threw an exception while processing the proximity response", next2.getClass().getName());
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m3076b(boolean z) {
        if (!m3078c(z)) {
            return false;
        }
        C4039h.m2817a(f3118d, "Enabling proximity messaging.", new Object[0]);
        if (!z) {
            C4016h hVar = this.f3122h;
            if (hVar != null) {
                hVar.mo56532e().edit().putBoolean(f3116b, true).apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, true);
            C3931c.m2333a(this.f3125k, C3929a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, bundle);
        } else {
            this.f3134t.mo56714a();
        }
        this.f3134t.mo56716b();
        return m3079d();
    }

    /* renamed from: c */
    private void m3077c() {
        disableProximityMessaging();
        disableGeofenceMessaging();
    }

    /* renamed from: c */
    private boolean m3078c(boolean z) {
        C4098b bVar;
        if (!z && isProximityMessagingEnabled()) {
            C4039h.m2820b(f3118d, "Proximity messaging is already enabled.", new Object[0]);
            return false;
        } else if (!this.f3123i.proximityEnabled() || (bVar = this.f3134t) == null) {
            C4039h.m2820b(f3118d, "Proximity messaging was not enabled while configuring the SDK.  Messaging will not be enabled.", new Object[0]);
            return false;
        } else if (!bVar.mo56814d() || !this.f3120f.mo56595d()) {
            C4039h.m2820b(f3118d, "Proximity messaging was not enabled due to device limitation.", new Object[0]);
            return false;
        } else if (m3085h()) {
            return true;
        } else {
            C4039h.m2820b(f3118d, "Missing %s", "android.permission.ACCESS_FINE_LOCATION");
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: d */
    private boolean m3079d() {
        if (this.f3133s == null && this.f3134t == null) {
            return false;
        }
        if (this.f3132r.compareAndSet(false, true)) {
            try {
                this.f3120f.mo56572a((C4057g) this);
            } catch (Exception e) {
                C4039h.m2830e(f3118d, e, "Unable to request location update", new Object[0]);
                m3077c();
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private synchronized boolean m3080d(boolean z) {
        if (!m3082e(z)) {
            return false;
        }
        C4039h.m2817a(f3118d, "Enabling geofence messaging", new Object[0]);
        if (!z) {
            if (this.f3122h != null) {
                this.f3122h.mo56532e().edit().putBoolean(f3115a, true).apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, true);
            C3931c.m2333a(this.f3125k, C3929a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, bundle);
        }
        this.f3133s.mo56716b();
        return m3079d();
    }

    /* renamed from: e */
    private void m3081e() {
        C4016h hVar = this.f3122h;
        if (hVar != null) {
            m3072a(hVar.mo56536h().mo56484a(this.f3122h.mo56524a()));
        }
    }

    /* renamed from: e */
    private boolean m3082e(boolean z) {
        C4085b bVar;
        if (!z && isGeofenceMessagingEnabled()) {
            C4039h.m2820b(f3118d, "Geofence messaging is already enabled", new Object[0]);
            return false;
        } else if (!this.f3123i.geofencingEnabled() || (bVar = this.f3133s) == null) {
            C4039h.m2820b(f3118d, "Geofence was not enabled while configuring the SDK.  Messaging will not be enabled", new Object[0]);
            return false;
        } else if (!bVar.mo56727d()) {
            C4039h.m2820b(f3118d, "Geofence messaging was not enabled due to device limitation.", new Object[0]);
            return false;
        } else if (m3085h()) {
            return true;
        } else {
            C4039h.m2820b(f3118d, "Missing %s", "android.permission.ACCESS_FINE_LOCATION");
            return false;
        }
    }

    /* renamed from: f */
    private void m3083f() {
        C4016h hVar = this.f3122h;
        if (hVar != null) {
            m3074b(hVar.mo56536h().mo56484a(this.f3122h.mo56524a()));
        }
    }

    /* renamed from: g */
    private void m3084g() {
        if (isGeofenceMessagingEnabled() && m3082e(true)) {
            this.f3133s.mo56714a();
        }
        if (isProximityMessagingEnabled() && m3078c(true)) {
            this.f3134t.mo56714a();
        }
    }

    /* renamed from: h */
    private boolean m3085h() {
        Context context = this.f3125k;
        if (context == null) {
            return false;
        }
        return C4026e.m2757a(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    @Nullable
    /* renamed from: a */
    public final JSONObject mo56200a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("geofenceMessagingEnabled", isGeofenceMessagingEnabled());
            jSONObject.put("proximityMessagingEnabled", isProximityMessagingEnabled());
            C4019k j = this.f3122h.mo56538j();
            if (j != null) {
                jSONObject.put("geofence_regions", j.mo56497a(1, this.f3122h.mo56524a()));
                jSONObject.put("proximity_regions", j.mo56497a(3, this.f3122h.mo56524a()));
            }
        } catch (Exception e) {
            C4039h.m2821b(f3118d, e, "Error creating RegionMessageManager state.", new Object[0]);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public final synchronized void mo56338a(int i) {
        if (C3956d.m2459b(i, 32)) {
            disableGeofenceMessaging();
            this.f3133s = null;
            C4085b.m3060a(this.f3122h, this.f3120f, this.f3119e, this.f3128n, C3956d.m2460c(i, 32));
            this.f3119e.mo56206a(C3848a.C3850a.FETCH_FENCE_MESSAGES, C3848a.C3850a.FETCH_FENCE_MESSAGES_DAILY);
        } else if (this.f3133s == null && this.f3123i.geofencingEnabled()) {
            mo56729b((InitializationStatus.C3832a) null);
        }
        if (C3956d.m2459b(i, 64)) {
            disableProximityMessaging();
            this.f3134t = null;
            C4098b.m3189a(this.f3122h, this.f3121g, this.f3119e, this.f3128n, C3956d.m2460c(i, 64));
            this.f3119e.mo56206a(C3848a.C3850a.FETCH_BEACON_MESSAGES, C3848a.C3850a.FETCH_BEACON_MESSAGES_DAILY);
        } else if (this.f3134t == null && this.f3123i.proximityEnabled()) {
            mo56728a((InitializationStatus.C3832a) null);
        }
        if (C3956d.m2459b(i, 96)) {
            this.f3120f.mo56575b((C4050e) this);
            this.f3120f.mo56576b((C4057g) this);
            this.f3127m.mo56345a((C3930b) this);
            this.f3122h.mo56536h().mo56483a();
        } else {
            this.f3127m.mo56346a((C3930b) this, (EnumSet<C3929a>) EnumSet.of(C3929a.BEHAVIOR_DEVICE_BOOT_COMPLETE, C3929a.BEHAVIOR_APP_PACKAGE_REPLACED, C3929a.BEHAVIOR_DEVICE_SHUTDOWN, C3929a.BEHAVIOR_APP_FOREGROUNDED));
            this.f3120f.mo56571a((C4050e) this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56578a(int i, @Nullable String str) {
        C4039h.m2820b(f3118d, "Region error %d - %s", Integer.valueOf(i), str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56593a(Location location) {
        this.f3132r.set(false);
        if (location != null) {
            try {
                LatLon a = LatLon.m2843a(location.getLatitude(), location.getLongitude());
                this.f3122h.mo56536h().mo56485a(a, this.f3122h.mo56524a());
                m3073a(a, 5000);
                m3072a(a);
                m3074b(a);
            } catch (Exception e) {
                C4039h.m2830e(f3118d, e, "Unable to make geofence message request after location update", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56728a(@Nullable InitializationStatus.C3832a aVar) {
        this.f3134t = new C4098b(this.f3122h, this.f3121g, this.f3119e, this.f3128n, this);
        this.f3119e.mo56203a((C3872b.C3874a) this, C3848a.C3850a.FETCH_BEACON_MESSAGES, C3848a.C3850a.FETCH_BEACON_MESSAGES_DAILY);
        if (isProximityMessagingEnabled()) {
            if (!m3076b(true)) {
                disableProximityMessaging();
            }
            aVar.mo56110e(!m3085h());
        }
    }

    /* renamed from: a */
    public final synchronized void mo56339a(@NonNull InitializationStatus.C3832a aVar, int i) {
        if (!C3956d.m2457a(i, 32) || !this.f3123i.geofencingEnabled()) {
            this.f3133s = null;
        } else {
            mo56729b(aVar);
        }
        if (!C3956d.m2457a(i, 64) || !this.f3123i.proximityEnabled()) {
            this.f3134t = null;
        } else {
            mo56728a(aVar);
        }
        if (!(this.f3133s == null && this.f3134t == null)) {
            this.f3127m.mo56346a((C3930b) this, (EnumSet<C3929a>) EnumSet.of(C3929a.BEHAVIOR_DEVICE_BOOT_COMPLETE, C3929a.BEHAVIOR_APP_PACKAGE_REPLACED, C3929a.BEHAVIOR_DEVICE_SHUTDOWN, C3929a.BEHAVIOR_APP_FOREGROUNDED));
            this.f3120f.mo56571a((C4050e) this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56216a(@NonNull C3848a.C3850a aVar) {
        int i = C40882.f3137a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            m3081e();
        } else if (i == 3 || i == 4) {
            m3083f();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56204a(@NonNull C3929a aVar, @NonNull Bundle bundle) {
        if (aVar != null) {
            int i = C40882.f3138b[aVar.ordinal()];
            if (i == 1) {
                this.f3122h.mo56538j().mo56491a();
            } else if (i != 2) {
                if (i == 3) {
                    this.f3122h.mo56538j().mo56491a();
                    return;
                } else if (i == 4) {
                    m3081e();
                    m3083f();
                    return;
                } else {
                    return;
                }
            }
            m3084g();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56721a(MessageResponse messageResponse) {
        if (messageResponse != null) {
            m3075b(messageResponse);
            C4022a a = this.f3122h.mo56524a();
            Region a2 = this.f3122h.mo56538j().mo56495a(a);
            if (a2 != null) {
                try {
                    if (messageResponse.refreshRadius() == a2.radius()) {
                        return;
                    }
                } catch (Exception e) {
                    C4039h.m2830e(f3118d, e, "Failed to updated radius for magic region.", new Object[0]);
                    return;
                }
            }
            Region.C4072b bVar = new Region.C4072b(messageResponse.refreshCenter(), messageResponse.refreshRadius());
            this.f3122h.mo56538j().mo56498a((Region) bVar, a);
            this.f3120f.mo56573a(bVar.mo56688c());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void mo56718a(Region region) {
        m3071a(1, region);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56719a(Region region, final Message message) {
        if (region != null && message != null) {
            C4039h.m2817a(f3118d, "showMessage(%s, %s)", region.mo56647id(), message.mo56608id());
            NotificationMessage a = NotificationMessage.m3249a(message, region);
            if (a != null && C4079e.m3044a(message, this.f3122h)) {
                try {
                    C4079e.m3045b(message, this.f3122h);
                    this.f3126l.mo56887a(a, (C4108c.C4110a) new C4108c.C4110a() {
                        /* renamed from: a */
                        public void mo56730a(int i) {
                            if (i != -1) {
                                try {
                                    message.mo56667a(i);
                                    C4086h.this.f3122h.mo56537i().mo56490a(message, C4086h.this.f3122h.mo56524a());
                                } catch (Exception e) {
                                    C4039h.m2830e(C4086h.f3118d, e, "Unable to update message id with notification id.", new Object[0]);
                                }
                            }
                        }
                    });
                } catch (Exception e) {
                    C4039h.m2830e(f3118d, e, "Failed to show message", new Object[0]);
                }
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56579a(@NonNull String str, int i) {
        if (i == 2 && Region.C4072b.f3088a.equals(str)) {
            C4039h.m2817a(f3118d, "MagicRegion exited", new Object[0]);
            if (m3085h()) {
                this.f3120f.mo56572a((C4057g) this);
                return;
            }
            C4039h.m2820b(f3118d, "MagicRegion exited, but was missing location permission.", new Object[0]);
            m3077c();
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
    }

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return "RegionMessageManager";
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public final void mo56594b(int i) {
        C4039h.m2820b(f3118d, "onLocationError(%d)", Integer.valueOf(i));
        this.f3132r.set(false);
        m3077c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56729b(@Nullable InitializationStatus.C3832a aVar) {
        this.f3133s = new C4085b(this.f3122h, this.f3120f, this.f3119e, this.f3128n, this);
        this.f3119e.mo56203a((C3872b.C3874a) this, C3848a.C3850a.FETCH_FENCE_MESSAGES, C3848a.C3850a.FETCH_FENCE_MESSAGES_DAILY);
        if (isGeofenceMessagingEnabled()) {
            if (!m3080d(true)) {
                disableGeofenceMessaging();
            }
            if (aVar != null) {
                aVar.mo56110e(!m3085h());
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public void mo56720b(Region region) {
        m3071a(2, region);
    }

    public final synchronized void disableGeofenceMessaging() {
        C4039h.m2820b(f3118d, "Diabling geofence messaging", new Object[0]);
        if (isGeofenceMessagingEnabled()) {
            if (this.f3122h != null) {
                this.f3122h.mo56532e().edit().putBoolean(f3115a, false).apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, false);
            C3931c.m2333a(this.f3125k, C3929a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, bundle);
            if (this.f3133s != null) {
                this.f3133s.mo56717c();
            }
        }
    }

    public final synchronized void disableProximityMessaging() {
        C4039h.m2820b(f3118d, "Diabling proximity messaging", new Object[0]);
        if (isProximityMessagingEnabled()) {
            if (this.f3122h != null) {
                this.f3122h.mo56532e().edit().putBoolean(f3116b, false).apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED, false);
            C3931c.m2333a(this.f3125k, C3929a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, bundle);
            if (this.f3134t != null) {
                this.f3134t.mo56717c();
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public final synchronized boolean enableGeofenceMessaging() {
        return m3080d(false);
    }

    @SuppressLint({"MissingPermission"})
    public final synchronized boolean enableProximityMessaging() {
        return m3076b(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r3.f3122h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isGeofenceMessagingEnabled() {
        /*
            r3 = this;
            com.salesforce.marketingcloud.MarketingCloudConfig r0 = r3.f3123i
            boolean r0 = r0.geofencingEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            com.salesforce.marketingcloud.d.h r0 = r3.f3122h
            if (r0 == 0) goto L_0x001a
            android.content.SharedPreferences r0 = r0.mo56532e()
            java.lang.String r2 = "et_geo_enabled_key"
            boolean r0 = r0.getBoolean(r2, r1)
            if (r0 == 0) goto L_0x001a
            r1 = 1
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.C4086h.isGeofenceMessagingEnabled():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r3.f3122h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isProximityMessagingEnabled() {
        /*
            r3 = this;
            com.salesforce.marketingcloud.MarketingCloudConfig r0 = r3.f3123i
            boolean r0 = r0.proximityEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            com.salesforce.marketingcloud.d.h r0 = r3.f3122h
            if (r0 == 0) goto L_0x001a
            android.content.SharedPreferences r0 = r0.mo56532e()
            java.lang.String r2 = "et_proximity_enabled_key"
            boolean r0 = r0.getBoolean(r2, r1)
            if (r0 == 0) goto L_0x001a
            r1 = 1
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.C4086h.isProximityMessagingEnabled():boolean");
    }

    public final void registerGeofenceMessageResponseListener(@NonNull RegionMessageManager.GeofenceMessageResponseListener geofenceMessageResponseListener) {
        if (geofenceMessageResponseListener != null) {
            synchronized (this.f3129o) {
                this.f3129o.add(geofenceMessageResponseListener);
            }
        }
    }

    public final void registerProximityMessageResponseListener(@NonNull RegionMessageManager.ProximityMessageResponseListener proximityMessageResponseListener) {
        if (proximityMessageResponseListener != null) {
            synchronized (this.f3130p) {
                this.f3130p.add(proximityMessageResponseListener);
            }
        }
    }

    public final void registerRegionTransitionEventListener(@NonNull RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        if (regionTransitionEventListener != null) {
            synchronized (this.f3131q) {
                this.f3131q.add(regionTransitionEventListener);
            }
        }
    }

    public final void unregisterGeofenceMessageResponseListener(@NonNull RegionMessageManager.GeofenceMessageResponseListener geofenceMessageResponseListener) {
        synchronized (this.f3129o) {
            this.f3129o.remove(geofenceMessageResponseListener);
        }
    }

    public final void unregisterProximityMessageResponseListener(@NonNull RegionMessageManager.ProximityMessageResponseListener proximityMessageResponseListener) {
        synchronized (this.f3130p) {
            this.f3130p.remove(proximityMessageResponseListener);
        }
    }

    public final void unregisterRegionTransitionEventListener(@NonNull RegionMessageManager.RegionTransitionEventListener regionTransitionEventListener) {
        synchronized (this.f3131q) {
            this.f3131q.remove(regionTransitionEventListener);
        }
    }
}
