package com.wowza.gocoder.sdk.api.broadcast;

import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataEvent;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.data.WOWZDataScope;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZSDKError;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.monitor.WOWZStreamingStat;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.api.status.WOWZStatusCallback;
import com.wowza.gocoder.sdk.support.licensing.LicenseManager;
import com.wowza.gocoder.sdk.support.p035b.C4272a;
import com.wowza.gocoder.sdk.support.p035b.C4273b;
import com.wowza.gocoder.sdk.support.p037d.C4280a;
import com.wowza.gocoder.sdk.support.wse.C4331c;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: GoCoderSDK */
public class WOWZBroadcast {
    public static boolean LOG_STAT_SAMPLES = false;
    public static boolean LOG_STAT_SUMMARY = false;
    public static boolean LOG_WOWZ_MESSAGES = false;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f3557a = "WOWZBroadcast";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WOWZStatusCallback f3558b = null;

    /* renamed from: c */
    private C4331c f3559c = new C4331c();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C4280a f3560d = new C4280a();

    /* renamed from: e */
    private C4272a f3561e = new C4272a();

    /* renamed from: f */
    private HashMap<String, ArrayList<WOWZDataEvent.EventListener>> f3562f = new HashMap<>();
    protected WOWZBroadcastConfig mBroadcastConfig = new WOWZBroadcastConfig();
    protected WOWZStatus mBroadcastStatus = new WOWZStatus(0);
    protected long mDuration = 0;
    protected Date mEndTime = null;
    protected Date mStartTime = null;

    public WOWZStatus startBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig, WOWZStatusCallback wOWZStatusCallback) {
        if (!LicenseManager.getInstance().canDoPublishing()) {
            this.mBroadcastStatus.setError(new WOWZError("Invalid license exception."));
            wOWZStatusCallback.onWZError(this.mBroadcastStatus);
            return this.mBroadcastStatus;
        } else if (!this.mBroadcastStatus.isIdle()) {
            this.mBroadcastStatus.setError(new WOWZSDKError(64));
            return this.mBroadcastStatus;
        } else {
            if (wOWZStatusCallback == null) {
                wOWZStatusCallback = new WOWZStatusCallback() {
                    public void onWZError(WOWZStatus wOWZStatus) {
                    }

                    public void onWZStatus(WOWZStatus wOWZStatus) {
                    }
                };
            }
            this.f3558b = wOWZStatusCallback;
            this.mBroadcastConfig.set(wOWZBroadcastConfig);
            WOWZLog.debug("***** [FPS]WOWZBroadcast " + wOWZBroadcastConfig.getVideoFramerate());
            WOWZBroadcastAPI.VideoBroadcaster videoBroadcaster = this.mBroadcastConfig.getVideoBroadcaster();
            if (videoBroadcaster != null) {
                WOWZMediaConfig videoSourceConfig = videoBroadcaster.getVideoSourceConfig();
                WOWZSize videoFrameSize = videoSourceConfig.getVideoFrameSize();
                int videoRotation = videoSourceConfig.getVideoRotation();
                boolean z = videoFrameSize.isPortrait() || WOWZMediaConfig.isPortraitRotation(videoRotation);
                videoSourceConfig.setVideoFrameSize(z ? videoFrameSize.asPortrait() : videoFrameSize.asLandscape());
                if (z) {
                    if (!WOWZMediaConfig.isPortraitRotation(videoRotation)) {
                        videoSourceConfig.setVideoRotation(90);
                    }
                } else if (!WOWZMediaConfig.isLandscapeRotation(videoRotation)) {
                    videoSourceConfig.setVideoRotation(0);
                }
                int orientationBehavior = this.mBroadcastConfig.getOrientationBehavior();
                int videoRotation2 = orientationBehavior != 1 ? orientationBehavior != 2 ? videoSourceConfig.getVideoRotation() : 90 : 0;
                this.mBroadcastConfig.setVideoRotation(videoRotation2);
                WOWZBroadcastConfig wOWZBroadcastConfig2 = this.mBroadcastConfig;
                if (wOWZBroadcastConfig2 != null) {
                    WOWZSize videoFrameSize2 = wOWZBroadcastConfig2.getVideoFrameSize();
                    this.mBroadcastConfig.setVideoFrameSize(WOWZMediaConfig.isPortraitRotation(videoRotation2) ? videoFrameSize2.asPortrait() : videoFrameSize2.asLandscape());
                }
            } else {
                this.mBroadcastConfig.setVideoEnabled(false);
            }
            if (this.mBroadcastConfig.getAudioBroadcaster() == null) {
                this.mBroadcastConfig.setAudioEnabled(false);
            }
            this.mBroadcastConfig.setStreamingMonitor(this.f3560d);
            this.mBroadcastConfig.registerVideoSink(this.f3559c);
            this.mBroadcastConfig.registerAudioSink(this.f3559c);
            if (C4272a.m3758a(this.mBroadcastConfig)) {
                this.f3561e.mo59033a(this.mBroadcastConfig.getVideoBroadcaster());
                this.mBroadcastConfig.setVideoBroadcaster(this.f3561e);
            }
            this.mBroadcastConfig.setErrorCallback(new WOWZBroadcastAPI.BroadcastErrorCallback() {
                public void onBroadcastError(WOWZError wOWZError) {
                    if (WOWZBroadcast.this.mBroadcastStatus.isRunning()) {
                        String a = WOWZBroadcast.f3557a;
                        WOWZLog.error(a, "A broadcast component reported the following during the broadcast, so it will stop\n" + wOWZError.toString());
                        WOWZStatus wOWZStatus = new WOWZStatus(4, wOWZError);
                        WOWZBroadcast.this.f3558b.onWZError(wOWZStatus);
                        WOWZBroadcast.this.mBroadcastStatus.set(wOWZStatus);
                    }
                }
            });
            this.mEndTime = null;
            this.mStartTime = new Date();
            this.mDuration = 0;
            this.mBroadcastStatus.clearLastError();
            new Thread(new Runnable() {
                public void run() {
                    WOWZBroadcast.this.mBroadcastStatus.setState(1);
                    WOWZBroadcast.this.f3558b.onWZStatus(new WOWZStatus(WOWZBroadcast.this.mBroadcastStatus));
                    WOWZLog.debug("***** [FPS]WOWZBroadcast2 " + WOWZBroadcast.this.mBroadcastConfig.getVideoFramerate());
                    WOWZBroadcast.this.mBroadcastStatus.set(C4273b.m3777a(WOWZBroadcast.this.mBroadcastConfig));
                    if (WOWZBroadcast.this.mBroadcastStatus.getState() == 2) {
                        WOWZBroadcast.this.m3499b();
                        WOWZBroadcast.this.f3558b.onWZStatus(WOWZBroadcast.this.mBroadcastStatus);
                        WOWZBroadcast.this.f3560d.mo59084b();
                        WOWZLog.debug("***** [FPS]WOWZBroadcast3 " + WOWZBroadcast.this.mBroadcastConfig.getVideoFramerate());
                        WOWZBroadcast.this.mBroadcastStatus.set(C4273b.m3780b(WOWZBroadcast.this.mBroadcastConfig));
                        if (WOWZBroadcast.this.mBroadcastStatus.getState() == 3) {
                            WOWZBroadcast.this.f3558b.onWZStatus(new WOWZStatus(WOWZBroadcast.this.mBroadcastStatus));
                            WOWZBroadcast.this.mBroadcastStatus.waitForState(4);
                        } else {
                            WOWZLog.warn(WOWZBroadcast.f3557a, "Ending the broadcast session due to an error that occurred during the transition from ready to running.");
                            WOWZBroadcast.this.mBroadcastStatus.setState(4);
                        }
                    } else {
                        WOWZLog.warn(WOWZBroadcast.f3557a, "Ending the broadcast session due to an error that occurred during the transition from idle to ready.");
                        WOWZBroadcast.this.mBroadcastStatus.setState(4);
                    }
                    if (WOWZBroadcast.this.mBroadcastStatus.getLastError() != null) {
                        WOWZBroadcast.this.f3558b.onWZError(new WOWZStatus(WOWZBroadcast.this.mBroadcastStatus));
                        WOWZBroadcast.this.mBroadcastStatus.clearLastError();
                    }
                    WOWZBroadcast.this.f3558b.onWZStatus(new WOWZStatus(WOWZBroadcast.this.mBroadcastStatus));
                    C4273b.m3781c(WOWZBroadcast.this.mBroadcastConfig);
                    if (WOWZBroadcast.this.f3560d.mo59089c()) {
                        WOWZBroadcast.this.f3560d.mo59091d();
                    }
                    WOWZBroadcast.this.m3502c();
                    WOWZBroadcast.this.mBroadcastStatus.setState(0);
                    WOWZBroadcast.this.f3558b.onWZStatus(new WOWZStatus(WOWZBroadcast.this.mBroadcastStatus));
                }
            }, f3557a).start();
            return new WOWZStatus(this.mBroadcastStatus);
        }
    }

    public WOWZStatus startBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig) {
        return startBroadcast(wOWZBroadcastConfig, (WOWZStatusCallback) null);
    }

    public WOWZStatus endBroadcast() {
        if (this.mBroadcastStatus.isRunning()) {
            this.mEndTime = new Date();
            this.mDuration = this.mEndTime.getTime() - this.mStartTime.getTime();
            this.mBroadcastStatus.setAndWaitForState(4, 0);
        }
        if (C4272a.m3758a(this.mBroadcastConfig)) {
            this.mBroadcastConfig.setVideoBroadcaster(this.f3561e.mo59031a());
        }
        return new WOWZStatus(this.mBroadcastStatus);
    }

    public WOWZStatus endBroadcast(WOWZStatusCallback wOWZStatusCallback) {
        this.f3558b = wOWZStatusCallback;
        return endBroadcast();
    }

    public WOWZStreamingStat getBroadcastStatistics() {
        return this.f3560d.mo59092e();
    }

    public boolean isABRActivated() {
        return this.f3561e.mo59037b();
    }

    public void setABRActivated(boolean z) {
        this.f3561e.mo59035a(z);
    }

    public void registerAdaptiveFrameRateListener(WOWZBroadcastAPI.AdaptiveChangeListener adaptiveChangeListener) {
        this.f3561e.mo59032a(adaptiveChangeListener);
    }

    public void registerAdaptiveBitRateListener(WOWZBroadcastAPI.AdaptiveChangeListener adaptiveChangeListener) {
        this.f3561e.mo59036b(adaptiveChangeListener);
    }

    public void unregisterAdaptiveBitRateListener(WOWZBroadcastAPI.AdaptiveChangeListener adaptiveChangeListener) {
        this.f3561e.mo59041d(adaptiveChangeListener);
    }

    public void unregisterAdaptiveFrameRateListener(WOWZBroadcastAPI.AdaptiveChangeListener adaptiveChangeListener) {
        this.f3561e.mo59039c(adaptiveChangeListener);
    }

    public WOWZStatusCallback getStatusCallback() {
        return this.f3558b;
    }

    public void setStatusCallback(WOWZStatusCallback wOWZStatusCallback) {
        this.f3558b = wOWZStatusCallback;
    }

    public void setLogLevel(int i) {
        this.f3559c.mo59605a(i);
    }

    public int getLogLevel() {
        return this.f3559c.mo59610b();
    }

    public WOWZStatus getStatus() {
        return new WOWZStatus(this.mBroadcastStatus);
    }

    public WOWZStatus getBroadcastStatus() {
        return new WOWZStatus(this.mBroadcastStatus);
    }

    public WOWZBroadcastConfig getBroadcastConfig() {
        return new WOWZBroadcastConfig(this.mBroadcastConfig);
    }

    public void sendDataEvent(WOWZDataScope wOWZDataScope, String str, WOWZDataMap wOWZDataMap, WOWZDataEvent.ResultCallback resultCallback) {
        this.f3559c.mo59607a(wOWZDataScope, str, wOWZDataMap, resultCallback);
    }

    public void sendDataEvent(WOWZDataScope wOWZDataScope, String str, WOWZDataEvent.ResultCallback resultCallback) {
        sendDataEvent(wOWZDataScope, str, (WOWZDataMap) null, resultCallback);
    }

    public void sendDataEvent(WOWZDataScope wOWZDataScope, String str, WOWZDataMap wOWZDataMap) {
        sendDataEvent(wOWZDataScope, str, wOWZDataMap, (WOWZDataEvent.ResultCallback) null);
    }

    public void sendDataEvent(WOWZDataScope wOWZDataScope, String str) {
        sendDataEvent(wOWZDataScope, str, (WOWZDataMap) null, (WOWZDataEvent.ResultCallback) null);
    }

    public void registerDataEventListener(String str, WOWZDataEvent.EventListener eventListener) {
        if (!this.f3562f.containsKey(str)) {
            this.f3562f.put(str, new ArrayList());
        }
        if (!this.f3562f.get(str).contains(eventListener)) {
            this.f3562f.get(str).add(eventListener);
        }
        if (this.mBroadcastStatus.isRunning()) {
            this.f3559c.mo59608a(str, eventListener);
        }
    }

    public void unregisterDataEventListener(String str, WOWZDataEvent.EventListener eventListener) {
        if (this.f3562f.containsKey(str) && this.f3562f.get(str).contains(eventListener)) {
            this.f3562f.get(str).remove(eventListener);
            if (this.f3562f.get(str).size() == 0) {
                this.f3562f.remove(str);
            }
        }
        if (this.mBroadcastStatus.isRunning()) {
            this.f3559c.mo59611b(str, eventListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3499b() {
        for (String next : this.f3562f.keySet()) {
            Iterator it = this.f3562f.get(next).iterator();
            while (it.hasNext()) {
                this.f3559c.mo59608a(next, (WOWZDataEvent.EventListener) it.next());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m3502c() {
        this.f3559c.mo59615f();
    }

    public void sendPingRequest(WOWZDataEvent.ResultCallback resultCallback) {
        if (this.mBroadcastStatus.isRunning()) {
            this.f3559c.mo59606a(resultCallback);
        }
    }
}
