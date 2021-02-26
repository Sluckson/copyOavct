package com.salesforce.marketingcloud.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.salesforce.marketingcloud.C4039h;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* renamed from: com.salesforce.marketingcloud.location.f */
class C4051f {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f2975b = C4039h.m2810a((Class<?>) C4051f.class);

    /* renamed from: a */
    GoogleApiClient f2976a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Set<C4056a> f2977c;

    /* renamed from: d */
    private final Context f2978d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f2979e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f2980f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f2981g;

    /* renamed from: com.salesforce.marketingcloud.location.f$a */
    interface C4056a {
        /* renamed from: a */
        void mo56591a();

        /* renamed from: a */
        void mo56592a(int i);
    }

    C4051f(Context context) {
        this.f2978d = context;
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        this.f2980f = instance.isGooglePlayServicesAvailable(context);
        this.f2981g = instance.getErrorString(this.f2980f);
        int i = this.f2980f;
        if (i == 0 || instance.isUserResolvableError(i)) {
            this.f2977c = new ArraySet();
        } else {
            int i2 = this.f2980f;
            throw new C4059i(i2, instance.getErrorString(i2));
        }
    }

    /* renamed from: a */
    private static Geofence m2880a(@NonNull C4047d dVar) {
        int i = 1;
        if ((dVar.mo56567e() & 1) != 1) {
            i = 0;
        }
        if ((dVar.mo56567e() & 2) == 2) {
            i |= 2;
        }
        if ((dVar.mo56567e() & 4) == 4) {
            i |= 4;
        }
        return new Geofence.Builder().setRequestId(dVar.mo56563a()).setCircularRegion(dVar.mo56565c(), dVar.mo56566d(), dVar.mo56564b()).setTransitionTypes(i).setExpirationDuration(-1).build();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo56580a() {
        return this.f2980f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56581a(@NonNull C4056a aVar) {
        if (aVar != null) {
            C4039h.m2817a(f2975b, "GoogleApiClient connection request ...", new Object[0]);
            GoogleApiClient googleApiClient = this.f2976a;
            if (googleApiClient == null) {
                synchronized (this.f2977c) {
                    this.f2977c.add(aVar);
                }
                this.f2976a = new GoogleApiClient.Builder(this.f2978d).addApi(LocationServices.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    public void onConnected(@Nullable Bundle bundle) {
                        C4039h.m2817a(C4051f.f2975b, "GoogleApiClient onConnected()", new Object[0]);
                        int unused = C4051f.this.f2980f = 0;
                        String unused2 = C4051f.this.f2981g = "SUCCESS";
                        synchronized (C4051f.this.f2977c) {
                            for (C4056a aVar : C4051f.this.f2977c) {
                                if (aVar != null) {
                                    aVar.mo56591a();
                                }
                            }
                            C4051f.this.f2977c.clear();
                        }
                    }

                    public void onConnectionSuspended(int i) {
                        String g = C4051f.f2975b;
                        Object[] objArr = new Object[1];
                        objArr[0] = i == 2 ? "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED";
                        C4039h.m2817a(g, "onConnectionSuspended(%s)", objArr);
                    }
                }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        C4039h.m2817a(C4051f.f2975b, "Failed to connect to play service. %s", connectionResult.toString());
                        int unused = C4051f.this.f2980f = connectionResult.getErrorCode();
                        String unused2 = C4051f.this.f2981g = connectionResult.getErrorMessage();
                        synchronized (C4051f.this.f2977c) {
                            for (C4056a aVar : C4051f.this.f2977c) {
                                if (aVar != null) {
                                    aVar.mo56592a(C4051f.this.f2980f);
                                }
                            }
                            C4051f.this.f2977c.clear();
                        }
                    }
                }).build();
                this.f2976a.connect();
            } else if (googleApiClient.isConnected()) {
                C4039h.m2817a(f2975b, "Already connected.", new Object[0]);
                if (aVar != null) {
                    aVar.mo56591a();
                }
            } else if (this.f2976a.isConnecting()) {
                C4039h.m2817a(f2975b, "Already connecting. Adding %s to list to be notified when complete", aVar.getClass().getSimpleName());
                synchronized (this.f2977c) {
                    this.f2977c.add(aVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* renamed from: a */
    public void mo56582a(C4047d... dVarArr) {
        if (dVarArr == null || dVarArr.length == 0) {
            C4039h.m2817a(f2975b, "No GeofenceRegions provided", new Object[0]);
            return;
        }
        GoogleApiClient googleApiClient = this.f2976a;
        if (googleApiClient == null || !googleApiClient.isConnected()) {
            C4039h.m2817a(f2975b, "Not connected.  Call connect and wait for response.", new Object[0]);
            return;
        }
        PendingIntent c = LocationReceiver.m2855c(this.f2978d);
        GeofencingRequest.Builder initialTrigger = new GeofencingRequest.Builder().setInitialTrigger(1);
        for (C4047d dVar : dVarArr) {
            C4039h.m2817a(f2975b, "Adding %s to geofence request", dVar.mo56563a());
            initialTrigger.addGeofence(m2880a(dVar));
        }
        try {
            LocationServices.GeofencingApi.addGeofences(this.f2976a, initialTrigger.build(), c).setResultCallback(new ResultCallback<Status>() {
                /* renamed from: a */
                public void onResult(@NonNull Status status) {
                    C4039h.m2817a(C4051f.f2975b, "GeofencingApi result: %s", status);
                }
            });
        } catch (SecurityException e) {
            C4039h.m2830e(f2975b, e, "ACCESS_FINE_LOCATION needed to request location.", new Object[0]);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56583a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            C4039h.m2817a(f2975b, "No GeofenceRegions provided", new Object[0]);
            return;
        }
        GoogleApiClient googleApiClient = this.f2976a;
        if (googleApiClient == null || !googleApiClient.isConnected()) {
            C4039h.m2817a(f2975b, "Not connected.  Call connect and wait for response.", new Object[0]);
        } else {
            LocationServices.GeofencingApi.removeGeofences(this.f2976a, (List<String>) Arrays.asList(strArr));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo56584b() {
        return this.f2981g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo56585c() {
        return this.f2980f == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo56586d() {
        GoogleApiClient googleApiClient = this.f2976a;
        if (googleApiClient != null && googleApiClient.isConnected()) {
            this.f2977c.clear();
            this.f2976a.disconnect();
        }
    }

    /* access modifiers changed from: package-private */
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* renamed from: e */
    public void mo56587e() {
        GoogleApiClient googleApiClient = this.f2976a;
        if (googleApiClient == null || !googleApiClient.isConnected()) {
            C4039h.m2817a(f2975b, "Not Connected.  Call connect and wait for response.", new Object[0]);
            return;
        }
        synchronized (this) {
            if (this.f2979e) {
                C4039h.m2817a(f2975b, "Request already being made.", new Object[0]);
                return;
            }
            this.f2979e = true;
            try {
                LocationServices.FusedLocationApi.requestLocationUpdates(this.f2976a, LocationRequest.create().setNumUpdates(1).setPriority(100), LocationReceiver.m2854b(this.f2978d)).setResultCallback(new ResultCallback<Status>() {
                    /* renamed from: a */
                    public void onResult(@NonNull Status status) {
                        C4039h.m2817a(C4051f.f2975b, "FusedLocationApi result: %s", status);
                        boolean unused = C4051f.this.f2979e = false;
                    }
                });
            } catch (SecurityException e) {
                C4039h.m2830e(f2975b, e, "ACCESS_FINE_LOCATION needed to request location.", new Object[0]);
                this.f2979e = false;
                throw e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo56588f() {
        GoogleApiClient googleApiClient = this.f2976a;
        if (googleApiClient == null || !googleApiClient.isConnected()) {
            C4039h.m2817a(f2975b, "Not connected.  Call connect and wait for response.", new Object[0]);
        } else {
            LocationServices.GeofencingApi.removeGeofences(this.f2976a, LocationReceiver.m2855c(this.f2978d));
        }
    }
}
