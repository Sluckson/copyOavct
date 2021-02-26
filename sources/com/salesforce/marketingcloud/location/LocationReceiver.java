package com.salesforce.marketingcloud.location;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationResult;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.p027e.C4026e;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UnknownNullness"})
public class LocationReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f2959a = "com.salesforce.marketingcloud.LOCATION_UPDATE";

    /* renamed from: b */
    private static final String f2960b = "com.salesforce.marketingcloud.GEOFENCE_TRIGGERED";

    /* renamed from: c */
    private static final String f2961c = C4039h.m2810a((Class<?>) LocationReceiver.class);

    /* renamed from: a */
    private static int m2850a(int i) {
        if (i == 1) {
            return 1;
        }
        int i2 = 2;
        if (i != 2) {
            i2 = 4;
            if (i != 4) {
                C4039h.m2817a(f2961c, "Unknown geofence transition %d", Integer.valueOf(i));
                return -1;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static void m2851a(Context context, GeofencingEvent geofencingEvent) {
        LocalBroadcastManager instance;
        Intent a;
        if (geofencingEvent == null) {
            C4039h.m2817a(f2961c, "Geofencing event was null.", new Object[0]);
            return;
        }
        if (geofencingEvent.hasError()) {
            String statusCodeString = GeofenceStatusCodes.getStatusCodeString(geofencingEvent.getErrorCode());
            C4039h.m2820b(f2961c, "Geofencing event contained error: %s", statusCodeString);
            instance = LocalBroadcastManager.getInstance(context);
            a = C4058h.m2901a(geofencingEvent.getErrorCode(), statusCodeString);
        } else if (geofencingEvent.getTriggeringGeofences() == null || geofencingEvent.getTriggeringGeofences().isEmpty()) {
            C4039h.m2820b(f2961c, "GeofencingEvent without triggering geofences.", new Object[0]);
            return;
        } else {
            int geofenceTransition = geofencingEvent.getGeofenceTransition();
            C4039h.m2817a(f2961c, "Geofencing event transition: %d", Integer.valueOf(geofenceTransition));
            m2850a(geofenceTransition);
            ArrayList arrayList = new ArrayList();
            for (Geofence next : geofencingEvent.getTriggeringGeofences()) {
                C4039h.m2817a(f2961c, "Triggered fence id: %s", next.getRequestId());
                arrayList.add(next.getRequestId());
            }
            instance = LocalBroadcastManager.getInstance(context);
            a = C4058h.m2902a(m2850a(geofenceTransition), (List<String>) arrayList);
        }
        instance.sendBroadcast(a);
    }

    /* renamed from: a */
    private static void m2852a(Context context, LocationResult locationResult) {
        if (locationResult == null) {
            C4039h.m2817a(f2961c, "LocationResult was null.", new Object[0]);
            return;
        }
        Location lastLocation = locationResult.getLastLocation();
        if (lastLocation == null) {
            C4039h.m2817a(f2961c, "LastLocation was null.", new Object[0]);
        } else {
            LocalBroadcastManager.getInstance(context).sendBroadcast(C4058h.m2903a(lastLocation));
        }
    }

    /* renamed from: a */
    static boolean m2853a(Context context) {
        return C4026e.m2759b(context.getPackageManager(), new Intent(context, LocationReceiver.class));
    }

    /* renamed from: b */
    static PendingIntent m2854b(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent(context, LocationReceiver.class).setAction(f2959a), 134217728);
    }

    /* renamed from: c */
    static PendingIntent m2855c(Context context) {
        return PendingIntent.getBroadcast(context, 1, new Intent(context, LocationReceiver.class).setAction(f2960b), 134217728);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            C4039h.m2817a(f2961c, "onReceive - %s", intent.getAction());
            if (!MarketingCloudSdk.isReady() && !MarketingCloudSdk.isInitializing()) {
                C4039h.m2826d(f2961c, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
            } else if (MarketingCloudSdk.getInstance() != null) {
                String action = intent.getAction();
                char c = 65535;
                int hashCode = action.hashCode();
                if (hashCode != 22603061) {
                    if (hashCode == 1768321718 && action.equals(f2959a)) {
                        c = 0;
                    }
                } else if (action.equals(f2960b)) {
                    c = 1;
                }
                if (c == 0) {
                    m2852a(context, LocationResult.extractResult(intent));
                } else if (c == 1) {
                    m2851a(context, GeofencingEvent.fromIntent(intent));
                }
            }
        }
    }
}
