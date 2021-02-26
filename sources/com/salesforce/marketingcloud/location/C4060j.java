package com.salesforce.marketingcloud.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.location.C4051f;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.location.j */
class C4060j extends C4058h {

    /* renamed from: m */
    final C4051f f3000m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Set<C4057g> f3001n = new ArraySet();

    /* renamed from: o */
    private final Set<C4050e> f3002o = new ArraySet();

    /* renamed from: p */
    private MarketingCloudConfig f3003p;

    /* renamed from: q */
    private int f3004q;

    /* renamed from: r */
    private int f3005r;

    /* renamed from: s */
    private String f3006s;

    /* renamed from: t */
    private int f3007t;

    /* renamed from: u */
    private Context f3008u;

    /* renamed from: v */
    private BroadcastReceiver f3009v;

    /* renamed from: com.salesforce.marketingcloud.location.j$a */
    private class C4065a extends BroadcastReceiver {
        private C4065a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x009f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r7, android.content.Intent r8) {
            /*
                r6 = this;
                r7 = 0
                if (r8 != 0) goto L_0x000d
                java.lang.String r8 = com.salesforce.marketingcloud.location.C4058h.f2989d
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.String r0 = "Received null intent"
                com.salesforce.marketingcloud.C4039h.m2817a((java.lang.String) r8, (java.lang.String) r0, (java.lang.Object[]) r7)
                return
            L_0x000d:
                java.lang.String r0 = r8.getAction()
                if (r0 != 0) goto L_0x001d
                java.lang.String r8 = com.salesforce.marketingcloud.location.C4058h.f2989d
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.String r0 = "Received null action"
                com.salesforce.marketingcloud.C4039h.m2817a((java.lang.String) r8, (java.lang.String) r0, (java.lang.Object[]) r7)
                return
            L_0x001d:
                int r1 = r0.hashCode()
                r2 = -284548713(0xffffffffef0a2197, float:-4.274954E28)
                r3 = 2
                r4 = 1
                r5 = -1
                if (r1 == r2) goto L_0x0048
                r2 = 557677285(0x213d7ae5, float:6.419834E-19)
                if (r1 == r2) goto L_0x003e
                r2 = 557783927(0x213f1b77, float:6.4749667E-19)
                if (r1 == r2) goto L_0x0034
                goto L_0x0052
            L_0x0034:
                java.lang.String r1 = "com.salesforce.marketingcloud.location.GEOFENCE_EVENT"
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0052
                r1 = 1
                goto L_0x0053
            L_0x003e:
                java.lang.String r1 = "com.salesforce.marketingcloud.location.GEOFENCE_ERROR"
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0052
                r1 = 2
                goto L_0x0053
            L_0x0048:
                java.lang.String r1 = "com.salesforce.marketingcloud.location.LOCATION_UPDATE"
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0052
                r1 = 0
                goto L_0x0053
            L_0x0052:
                r1 = -1
            L_0x0053:
                if (r1 == 0) goto L_0x009f
                if (r1 == r4) goto L_0x007b
                if (r1 == r3) goto L_0x0065
                java.lang.String r8 = com.salesforce.marketingcloud.location.C4058h.f2989d
                java.lang.Object[] r1 = new java.lang.Object[r4]
                r1[r7] = r0
                java.lang.String r7 = "Received unknown action: %s"
                com.salesforce.marketingcloud.C4039h.m2820b(r8, r7, r1)
                goto L_0x00b5
            L_0x0065:
                java.lang.String r7 = "extra_error_code"
                int r7 = r8.getIntExtra(r7, r5)
                java.lang.String r0 = "extra_error_message"
                java.lang.String r8 = r8.getStringExtra(r0)
                if (r7 == r5) goto L_0x00b5
                if (r8 == 0) goto L_0x00b5
                com.salesforce.marketingcloud.location.j r0 = com.salesforce.marketingcloud.location.C4060j.this
                r0.mo56597b((int) r7, (java.lang.String) r8)
                goto L_0x00b5
            L_0x007b:
                java.lang.String r0 = "extra_transition"
                int r0 = r8.getIntExtra(r0, r5)
                if (r0 != r5) goto L_0x0084
                return
            L_0x0084:
                java.lang.String r1 = com.salesforce.marketingcloud.location.C4058h.f2989d
                java.lang.Object[] r2 = new java.lang.Object[r4]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
                r2[r7] = r3
                java.lang.String r7 = "Received geofence transition %d"
                com.salesforce.marketingcloud.C4039h.m2820b(r1, r7, r2)
                com.salesforce.marketingcloud.location.j r7 = com.salesforce.marketingcloud.location.C4060j.this
                java.lang.String r1 = "extra_fence_ids"
                java.util.ArrayList r8 = r8.getStringArrayListExtra(r1)
                r7.mo56598b((int) r0, (java.util.List<java.lang.String>) r8)
                goto L_0x00b5
            L_0x009f:
                java.lang.String r0 = com.salesforce.marketingcloud.location.C4058h.f2989d
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.String r1 = "Received location update."
                com.salesforce.marketingcloud.C4039h.m2820b(r0, r1, r7)
                com.salesforce.marketingcloud.location.j r7 = com.salesforce.marketingcloud.location.C4060j.this
                java.lang.String r0 = "extra_location"
                android.os.Parcelable r8 = r8.getParcelableExtra(r0)
                android.location.Location r8 = (android.location.Location) r8
                r7.mo56599b((android.location.Location) r8)
            L_0x00b5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.location.C4060j.C4065a.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    C4060j(@NonNull Context context, MarketingCloudConfig marketingCloudConfig) {
        this.f3008u = context;
        this.f3000m = new C4051f(context);
        this.f3003p = marketingCloudConfig;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    C4060j(Context context, C4051f fVar) {
        this.f3008u = context;
        this.f3000m = fVar;
    }

    /* renamed from: a */
    public JSONObject mo56200a() {
        JSONObject a = m2905a(this.f3003p, this.f3000m.mo56580a(), this.f3000m.mo56584b());
        try {
            a.put("locationRequests", this.f3004q);
            a.put("locationsReceived", this.f3005r);
            a.put("lastLocationRequester", this.f3006s);
            a.put("geofenceEvents", this.f3007t);
            a.put("geofenceListeners", this.f3002o.size());
        } catch (JSONException e) {
            C4039h.m2830e(f2989d, e, "Error creating state for RealLocationManager.", new Object[0]);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo56202a(@NonNull InitializationStatus.C3832a aVar) {
        this.f3009v = new C4065a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.salesforce.marketingcloud.location.LOCATION_UPDATE");
        intentFilter.addAction("com.salesforce.marketingcloud.location.GEOFENCE_EVENT");
        intentFilter.addAction("com.salesforce.marketingcloud.location.GEOFENCE_ERROR");
        LocalBroadcastManager.getInstance(this.f3008u).registerReceiver(this.f3009v, intentFilter);
        aVar.mo56095a(this.f3000m.mo56580a());
        aVar.mo56103b(this.f3000m.mo56584b());
        aVar.mo56101a(!this.f3000m.mo56585c());
    }

    /* renamed from: a */
    public void mo56571a(@NonNull C4050e eVar) {
        C4039h.m2817a(f2989d, "registerForGeofenceRegionEvents(%s)", eVar.getClass().getName());
        if (eVar != null) {
            synchronized (this.f3002o) {
                this.f3002o.add(eVar);
            }
        }
    }

    /* renamed from: a */
    public void mo56572a(@NonNull C4057g gVar) {
        boolean z;
        if (gVar != null) {
            synchronized (this.f3001n) {
                z = this.f3001n.add(gVar) && this.f3001n.size() == 1;
            }
            if (z) {
                this.f3004q++;
                this.f3006s = gVar.getClass().getName();
                this.f3000m.mo56581a((C4051f.C4056a) new C4051f.C4056a() {
                    /* renamed from: a */
                    public void mo56591a() {
                        C4060j.this.f3000m.mo56587e();
                    }

                    /* renamed from: a */
                    public void mo56592a(int i) {
                        C4039h.m2820b(C4058h.f2989d, "Failed to connect to GmsLocationProvider for location update. [%d]", Integer.valueOf(i));
                        synchronized (C4060j.this.f3001n) {
                            for (C4057g gVar : C4060j.this.f3001n) {
                                if (gVar != null) {
                                    gVar.mo56594b(i);
                                }
                            }
                            C4060j.this.f3001n.clear();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
        C4051f fVar = this.f3000m;
        if (fVar != null) {
            if (z) {
                fVar.mo56588f();
            }
            this.f3000m.mo56586d();
        }
        Context context = this.f3008u;
        if (context != null && this.f3009v != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f3009v);
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* renamed from: a */
    public void mo56573a(final C4047d... dVarArr) {
        if (dVarArr == null || dVarArr.length == 0) {
            C4039h.m2820b(f2989d, "monitorGeofences - No geofenceRegions provided.", new Object[0]);
            return;
        }
        C4039h.m2817a(f2989d, "Monitoring %s fence(s).", Integer.valueOf(dVarArr.length));
        this.f3000m.mo56581a((C4051f.C4056a) new C4051f.C4056a() {
            /* renamed from: a */
            public void mo56591a() {
                C4060j.this.f3000m.mo56582a(dVarArr);
            }

            /* renamed from: a */
            public void mo56592a(int i) {
                C4039h.m2820b(C4058h.f2989d, "Failed to connect to GmsLocationProvider for Geofence monitoring. [%d]", Integer.valueOf(i));
            }
        });
    }

    /* renamed from: a */
    public void mo56574a(final String... strArr) {
        if (strArr == null || strArr.length == 0) {
            C4039h.m2823c(f2989d, "unmonitorGeofences - No geofenceRegionIds provided.", new Object[0]);
        } else {
            this.f3000m.mo56581a((C4051f.C4056a) new C4051f.C4056a() {
                /* renamed from: a */
                public void mo56591a() {
                    C4060j.this.f3000m.mo56583a(strArr);
                }

                /* renamed from: a */
                public void mo56592a(int i) {
                    C4039h.m2820b(C4058h.f2989d, "Failed to connect to GmsLocationProvider unmonitor Geofences. [%d]", Integer.valueOf(i));
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public void mo56597b(int i, String str) {
        synchronized (this.f3002o) {
            if (!this.f3002o.isEmpty()) {
                for (C4050e next : this.f3002o) {
                    if (next != null) {
                        next.mo56578a(i, str);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public void mo56598b(int i, @NonNull List<String> list) {
        C4039h.m2817a(f2989d, "onGeofenceRegionEvent", new Object[0]);
        if (list == null || list.isEmpty()) {
            C4039h.m2823c(f2989d, "No fenceIds were provided.", new Object[0]);
            return;
        }
        this.f3007t++;
        synchronized (this.f3002o) {
            if (!this.f3002o.isEmpty()) {
                for (C4050e next : this.f3002o) {
                    if (next != null) {
                        for (String next2 : list) {
                            C4039h.m2820b(f2989d, "Notifiying %s of geofence [%s] region event [d]", next.getClass().getName(), next2, Integer.valueOf(i));
                            next.mo56579a(next2, i);
                        }
                    }
                }
            } else {
                C4039h.m2823c(f2989d, "Geofence region event occured with no one listening.", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public void mo56599b(Location location) {
        if (location != null) {
            this.f3005r++;
            synchronized (this.f3001n) {
                if (!this.f3001n.isEmpty()) {
                    for (C4057g next : this.f3001n) {
                        if (next != null) {
                            next.mo56593a(location);
                        }
                    }
                    this.f3001n.clear();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo56575b(@NonNull C4050e eVar) {
        if (eVar != null) {
            synchronized (this.f3002o) {
                this.f3002o.remove(eVar);
            }
        }
    }

    /* renamed from: b */
    public void mo56576b(@NonNull C4057g gVar) {
        synchronized (this.f3001n) {
            this.f3001n.remove(gVar);
        }
    }

    /* renamed from: c */
    public void mo56577c() {
        this.f3000m.mo56581a((C4051f.C4056a) new C4051f.C4056a() {
            /* renamed from: a */
            public void mo56591a() {
                C4060j.this.f3000m.mo56588f();
            }

            /* renamed from: a */
            public void mo56592a(int i) {
                C4039h.m2820b(C4058h.f2989d, "Failed to connect to GmsLocationProvider unmonitor Geofences. [%d]", Integer.valueOf(i));
            }
        });
    }

    /* renamed from: d */
    public boolean mo56595d() {
        return this.f3000m.mo56585c();
    }
}
