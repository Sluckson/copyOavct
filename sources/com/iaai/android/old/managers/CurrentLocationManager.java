package com.iaai.android.old.managers;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.IDisposable;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import roboguice.util.C5058Ln;

@Singleton
public class CurrentLocationManager {
    private static final int LOCATION_CHECK_TIMEOUT = 30000;
    final IaaiApplication application;
    private volatile Location currentLocation;
    Dialog dialog;
    private CurrentLocationListener gpsLocationListener;
    private IntentFilter intentFilter;
    private boolean isFromNewScreen = false;
    private boolean isRunning = false;
    private CurrentLocationListener networkLocationListener;
    Timer timer;

    @Inject
    private CurrentLocationManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        init();
    }

    private void init() {
        this.currentLocation = getLastKnownLocation();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r1.getTime() > r0.getTime()) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.location.Location getLastKnownLocation() {
        /*
            r7 = this;
            java.lang.String r0 = "network"
            java.lang.String r1 = "gps"
            com.iaai.android.IaaiApplication r2 = r7.application
            java.lang.String r3 = "location"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.location.LocationManager r2 = (android.location.LocationManager) r2
            r3 = 0
            boolean r4 = r2.isProviderEnabled(r1)     // Catch:{ Exception -> 0x001a }
            if (r4 == 0) goto L_0x001a
            android.location.Location r1 = r2.getLastKnownLocation(r1)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r1 = r3
        L_0x001b:
            boolean r4 = r2.isProviderEnabled(r0)     // Catch:{ Exception -> 0x0026 }
            if (r4 == 0) goto L_0x0026
            android.location.Location r0 = r2.getLastKnownLocation(r0)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0027
        L_0x0026:
            r0 = r3
        L_0x0027:
            if (r1 == 0) goto L_0x0038
            if (r0 == 0) goto L_0x0038
            long r2 = r1.getTime()
            long r4 = r0.getTime()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x003e
            goto L_0x003a
        L_0x0038:
            if (r1 == 0) goto L_0x003c
        L_0x003a:
            r3 = r1
            goto L_0x003f
        L_0x003c:
            if (r0 == 0) goto L_0x003f
        L_0x003e:
            r3 = r0
        L_0x003f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.managers.CurrentLocationManager.getLastKnownLocation():android.location.Location");
    }

    public synchronized void refreshCurrentLocation(Activity activity) {
        boolean z;
        boolean z2;
        if (!this.isRunning) {
            this.isRunning = true;
            this.isFromNewScreen = false;
            LocationManager locationManager = (LocationManager) this.application.getSystemService("location");
            try {
                z = locationManager.isProviderEnabled("gps");
            } catch (Exception unused) {
                z = false;
            }
            try {
                z2 = locationManager.isProviderEnabled("network");
            } catch (Exception unused2) {
                z2 = false;
            }
            C5058Ln.m4829d("isGpsEnabled[%s] isNetworkEnabled[%s]", Boolean.toString(z), Boolean.toString(z2));
            if (z || z2) {
                if (z) {
                    this.gpsLocationListener = new CurrentLocationListener(activity);
                    locationManager.requestLocationUpdates("gps", 0, 0.0f, this.gpsLocationListener);
                } else {
                    this.gpsLocationListener = null;
                }
                if (z2) {
                    this.networkLocationListener = new CurrentLocationListener(activity);
                    locationManager.requestLocationUpdates("network", 0, 0.0f, this.networkLocationListener);
                } else {
                    this.networkLocationListener = null;
                }
                ActivityHelper.showProgressDialog(activity, activity.getResources().getString(C2723R.string.msg_finding_your_location), new OnFindLocationCancelListener(activity, this));
                this.timer = new Timer();
                this.timer.schedule(new TimeoutTimerTask(activity, this), 30000);
                return;
            }
            this.isRunning = false;
            broadcastCurrentLocationNotAvailable(activity);
        }
    }

    public synchronized void refreshCurrentLocation(Activity activity, boolean z) {
        boolean z2;
        boolean z3;
        if (!this.isRunning) {
            this.isRunning = true;
            this.isFromNewScreen = z;
            LocationManager locationManager = (LocationManager) this.application.getSystemService("location");
            try {
                z2 = locationManager.isProviderEnabled("gps");
            } catch (Exception unused) {
                z2 = false;
            }
            try {
                z3 = locationManager.isProviderEnabled("network");
            } catch (Exception unused2) {
                z3 = false;
            }
            C5058Ln.m4829d("isGpsEnabled[%s] isNetworkEnabled[%s]", Boolean.toString(z2), Boolean.toString(z3));
            if (z2 || z3) {
                if (z2) {
                    this.gpsLocationListener = new CurrentLocationListener(activity);
                    locationManager.requestLocationUpdates("gps", 0, 0.0f, this.gpsLocationListener);
                } else {
                    this.gpsLocationListener = null;
                }
                if (z3) {
                    this.networkLocationListener = new CurrentLocationListener(activity);
                    locationManager.requestLocationUpdates("network", 0, 0.0f, this.networkLocationListener);
                } else {
                    this.networkLocationListener = null;
                }
                this.dialog = MDActivityHelper.showLocationProgressDialog(activity, activity.getResources().getString(C2723R.string.msg_finding_your_location), new OnFindLocationCancelListener(activity, this));
                this.timer = new Timer();
                this.timer.schedule(new TimeoutTimerTask(activity, this), 30000);
                return;
            }
            this.isRunning = false;
            broadcastCurrentLocationNotAvailable(activity);
        }
    }

    public Location getLastRecordedLocation() {
        return this.currentLocation;
    }

    /* access modifiers changed from: package-private */
    public synchronized void broadcastCurrentLocation(Activity activity, Location location) {
        try {
            if (this.currentLocation == null || (location != null && location.getTime() > this.currentLocation.getTime())) {
                this.currentLocation = location;
            }
            clearTimer();
            clearLocationListener("gps");
            clearLocationListener("network");
            this.isRunning = false;
            if (!this.isFromNewScreen || this.dialog == null) {
                ActivityHelper.dismissDialog(activity);
            } else {
                this.dialog.dismiss();
            }
            Intent intent = new Intent(Constants.INTENT_CURRENT_LOCATION_UPDATE);
            intent.putExtra("location", location);
            this.application.sendBroadcast(intent);
        } catch (Throwable th) {
            this.isRunning = false;
            if (!this.isFromNewScreen || this.dialog == null) {
                ActivityHelper.dismissDialog(activity);
            } else {
                this.dialog.dismiss();
            }
            throw th;
        }
    }

    private void clearTimer() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
    }

    private void clearLocationListener(String str) {
        CurrentLocationListener currentLocationListener;
        LocationManager locationManager = (LocationManager) this.application.getSystemService("location");
        if ("gps".equals(str)) {
            CurrentLocationListener currentLocationListener2 = this.gpsLocationListener;
            if (currentLocationListener2 != null) {
                locationManager.removeUpdates(currentLocationListener2);
                this.gpsLocationListener.dispose();
                this.gpsLocationListener = null;
            }
        } else if ("network".equals(str) && (currentLocationListener = this.networkLocationListener) != null) {
            locationManager.removeUpdates(currentLocationListener);
            this.networkLocationListener.dispose();
            this.networkLocationListener = null;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void handleCurrentLocationNotAvailable(Activity activity, String str) {
        if (str == null) {
            clearLocationListener("gps");
            clearLocationListener("network");
        } else {
            if ("gps".equals(str)) {
                CurrentLocationListener currentLocationListener = this.gpsLocationListener;
            } else {
                CurrentLocationListener currentLocationListener2 = this.networkLocationListener;
            }
            clearLocationListener(str);
        }
        if (this.gpsLocationListener == null && this.networkLocationListener == null) {
            clearTimer();
            this.isRunning = false;
            broadcastCurrentLocationNotAvailable(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void broadcastCurrentLocationNotAvailable(Activity activity) {
        ActivityHelper.dismissDialog(activity);
        this.application.sendBroadcast(new Intent(Constants.INTENT_CURRENT_LOCATION_NOT_AVAILABLE));
    }

    public IntentFilter getBroadcastIntentFilter() {
        if (this.intentFilter == null) {
            this.intentFilter = new IntentFilter();
            this.intentFilter.addAction(Constants.INTENT_CURRENT_LOCATION_UPDATE);
            this.intentFilter.addAction(Constants.INTENT_CURRENT_LOCATION_NOT_AVAILABLE);
        }
        return this.intentFilter;
    }

    static class OnFindLocationCancelListener implements DialogInterface.OnCancelListener {
        private final WeakReference<Activity> activityRef;
        private final WeakReference<CurrentLocationManager> currentLocationManagerRef;

        public OnFindLocationCancelListener(Activity activity, CurrentLocationManager currentLocationManager) {
            this.activityRef = new WeakReference<>(activity);
            this.currentLocationManagerRef = new WeakReference<>(currentLocationManager);
        }

        public void onCancel(DialogInterface dialogInterface) {
            CurrentLocationManager currentLocationManager;
            WeakReference<CurrentLocationManager> weakReference = this.currentLocationManagerRef;
            if (weakReference == null) {
                currentLocationManager = null;
            } else {
                currentLocationManager = (CurrentLocationManager) weakReference.get();
            }
            if (currentLocationManager != null) {
                currentLocationManager.broadcastCurrentLocationNotAvailable((Activity) this.activityRef.get());
            }
        }
    }

    static class TimeoutTimerTask extends TimerTask {
        private final WeakReference<Activity> activityRef;
        private final WeakReference<CurrentLocationManager> currentLocationManagerRef;

        public TimeoutTimerTask(Activity activity, CurrentLocationManager currentLocationManager) {
            this.activityRef = new WeakReference<>(activity);
            this.currentLocationManagerRef = new WeakReference<>(currentLocationManager);
        }

        public void run() {
            CurrentLocationManager currentLocationManager;
            WeakReference<CurrentLocationManager> weakReference = this.currentLocationManagerRef;
            if (weakReference == null) {
                currentLocationManager = null;
            } else {
                currentLocationManager = (CurrentLocationManager) weakReference.get();
            }
            if (currentLocationManager != null) {
                currentLocationManager.handleCurrentLocationNotAvailable((Activity) this.activityRef.get(), (String) null);
            }
        }
    }

    class CurrentLocationListener implements LocationListener, IDisposable {
        private final WeakReference<Activity> activityRef;

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public CurrentLocationListener(Activity activity) {
            this.activityRef = new WeakReference<>(activity);
        }

        public Activity getContext() {
            WeakReference<Activity> weakReference = this.activityRef;
            if (weakReference == null) {
                return null;
            }
            return (Activity) weakReference.get();
        }

        public void onLocationChanged(Location location) {
            CurrentLocationManager.this.broadcastCurrentLocation(getContext(), location);
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0 || i == 1) {
                CurrentLocationManager.this.handleCurrentLocationNotAvailable(getContext(), str);
            }
        }

        public void dispose() {
            WeakReference<Activity> weakReference = this.activityRef;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
    }
}
