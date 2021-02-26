package com.salesforce.marketingcloud.proximity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.powersave.BackgroundPowerSaver;

/* renamed from: com.salesforce.marketingcloud.proximity.b */
class C4115b implements BeaconConsumer, MonitorNotifier {
    @VisibleForTesting

    /* renamed from: a */
    static final String f3331a = "m:0-3=4c000215,i:4-19,i:20-21,i:22-23,p:24-24";

    /* renamed from: c */
    private static final String f3332c = C4039h.m2810a((Class<?>) C4115b.class);
    @VisibleForTesting

    /* renamed from: b */
    final Map<String, Region> f3333b = new ArrayMap();

    /* renamed from: d */
    private final BeaconManager f3334d;

    /* renamed from: e */
    private final Context f3335e;

    /* renamed from: f */
    private final List<C4122e> f3336f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final LocalBroadcastManager f3337g;

    /* renamed from: h */
    private boolean f3338h;

    /* renamed from: i */
    private boolean f3339i;

    /* renamed from: j */
    private BackgroundPowerSaver f3340j;

    /* renamed from: k */
    private Intent f3341k;

    C4115b(Context context) {
        this.f3335e = context;
        this.f3337g = LocalBroadcastManager.getInstance(context);
        this.f3334d = BeaconManager.getInstanceForApplication(context);
        this.f3334d.setEnableScheduledScanJobs(true);
        this.f3334d.getBeaconParsers().add(new BeaconParser("iBeacon").setBeaconLayout(f3331a));
        this.f3334d.setBackgroundScanPeriod(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        this.f3334d.setBackgroundBetweenScanPeriod(10000);
        this.f3334d.addMonitorNotifier(this);
    }

    /* renamed from: a */
    private static C4122e m3315a(Region region) {
        try {
            return C4122e.m3338a(region.getUniqueId(), region.getId1().toString(), region.getId2().toInt(), region.getId3().toInt());
        } catch (Exception e) {
            C4039h.m2830e(f3332c, e, "Unable to convert Region to BeaconRegion", new Object[0]);
            return null;
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static Region m3316a(C4122e eVar) {
        return new Region(eVar.mo56901a(), Identifier.fromUuid(UUID.fromString(eVar.mo56902b())), Identifier.fromInt(eVar.mo56903c()), Identifier.fromInt(eVar.mo56904d()));
    }

    /* renamed from: b */
    private void m3317b() {
        this.f3339i = true;
        this.f3334d.bind(this);
        C4039h.m2820b(f3332c, "Waiting for BeaconService connection", new Object[0]);
    }

    /* renamed from: b */
    private void m3318b(Region region) {
        try {
            this.f3334d.stopMonitoringBeaconsInRegion(region);
        } catch (Exception e) {
            C4039h.m2821b(f3332c, e, "Failed to stop monitoring %s", region);
        }
    }

    /* renamed from: c */
    private void m3319c() {
        C4039h.m2817a(f3332c, "monitorNewRegions", new Object[0]);
        List<C4122e> list = this.f3336f;
        if (list != null && !list.isEmpty()) {
            for (C4122e next : this.f3336f) {
                try {
                    if (!this.f3333b.containsKey(next.mo56901a())) {
                        Region a = m3316a(next);
                        this.f3333b.put(next.mo56901a(), a);
                        C4039h.m2817a(f3332c, "Now monitoring [%s]", next.toString());
                        this.f3334d.startMonitoringBeaconsInRegion(a);
                    } else {
                        C4039h.m2817a(f3332c, "Region [%s] already monitored by SDK", next);
                    }
                } catch (RemoteException e) {
                    C4039h.m2830e(f3332c, e, "Unable to monitor region [%s]", next.toString());
                }
            }
            this.f3336f.clear();
        }
    }

    /* renamed from: d */
    private void m3320d() {
        C4039h.m2817a(f3332c, "clearAllMonitoredRegions", new Object[0]);
        if (!this.f3333b.isEmpty()) {
            C4039h.m2817a(f3332c, "Stop monitoring %d BeaconRegions", Integer.valueOf(this.f3333b.size()));
            for (Region next : this.f3333b.values()) {
                if (next != null) {
                    m3318b(next);
                }
            }
            this.f3333b.clear();
        }
    }

    /* renamed from: a */
    public void mo56908a() {
        C4039h.m2820b(f3332c, "stopMonitoring()", new Object[0]);
        synchronized (this.f3336f) {
            if (this.f3338h) {
                m3320d();
                this.f3334d.unbind(this);
                this.f3334d.removeMonitorNotifier(this);
                if (this.f3340j != null) {
                    ((Application) this.f3335e.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f3340j);
                }
                this.f3338h = false;
            } else {
                this.f3336f.clear();
            }
        }
    }

    /* renamed from: a */
    public void mo56909a(@NonNull List<C4122e> list) {
        C4039h.m2820b(f3332c, "unmonitorBeaconRegions() - [%d regions]", Integer.valueOf(list.size()));
        if (!list.isEmpty()) {
            for (C4122e next : list) {
                this.f3333b.remove(next.mo56901a());
                m3318b(m3316a(next));
            }
        }
    }

    /* renamed from: b */
    public void mo56910b(@NonNull List<C4122e> list) {
        C4039h.m2820b(f3332c, "monitorBeaconRegions() - [%d regions]", Integer.valueOf(list.size()));
        if (!list.isEmpty()) {
            synchronized (this.f3336f) {
                this.f3336f.clear();
                this.f3336f.addAll(list);
                if (this.f3338h) {
                    m3319c();
                } else {
                    C4039h.m2817a(f3332c, "Not yet connected.  Will register Beacons once complete.", new Object[0]);
                    if (!this.f3339i) {
                        m3317b();
                    }
                }
            }
        }
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        this.f3341k = intent;
        this.f3335e.startService(intent);
        return this.f3335e.bindService(intent, serviceConnection, i);
    }

    public void didDetermineStateForRegion(int i, Region region) {
        C4039h.m2817a(f3332c, "didDetermineStateForRegion(%d, %s)", Integer.valueOf(i), region);
        if (MarketingCloudSdk.isReady() || MarketingCloudSdk.isInitializing()) {
            final Intent putExtra = new Intent(i == 1 ? C4124g.f3353a : C4124g.f3354b).putExtra(C4124g.f3355c, m3315a(region));
            if (MarketingCloudSdk.isReady()) {
                this.f3337g.sendBroadcast(putExtra);
            } else {
                MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() {
                    public void ready(@NonNull MarketingCloudSdk marketingCloudSdk) {
                        C4115b.this.f3337g.sendBroadcast(putExtra);
                    }
                });
            }
        } else {
            C4039h.m2826d(f3332c, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
        }
    }

    public void didEnterRegion(Region region) {
        C4039h.m2817a(f3332c, "didEnterRegion(%s)", region);
    }

    public void didExitRegion(Region region) {
        C4039h.m2817a(f3332c, "didExitRegion(%s)", region);
    }

    public Context getApplicationContext() {
        return this.f3335e;
    }

    public void onBeaconServiceConnect() {
        C4039h.m2820b(f3332c, "onBeaconServiceConnect", new Object[0]);
        synchronized (this.f3336f) {
            this.f3340j = new BackgroundPowerSaver(this.f3335e);
            this.f3334d.addMonitorNotifier(this);
            this.f3338h = true;
            this.f3339i = false;
            m3319c();
        }
    }

    public void unbindService(ServiceConnection serviceConnection) {
        this.f3335e.unbindService(serviceConnection);
        this.f3335e.stopService(this.f3341k);
        this.f3338h = false;
        this.f3339i = false;
    }
}
