package com.wowza.gocoder.sdk.api.broadcast;

import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.status.WOWZState;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.support.p036c.C4277a;

/* compiled from: GoCoderSDK */
public class WOWZH264Broadcaster extends C4277a implements WOWZBroadcastAPI.VideoBroadcaster {

    /* renamed from: a */
    private static final String f3580a = "WOWZH264Broadcaster";

    /* renamed from: b */
    private WOWZBroadcastConfig f3581b;

    /* renamed from: c */
    private WOWZStatus f3582c = new WOWZStatus(0);

    /* renamed from: d */
    private boolean f3583d;

    /* renamed from: e */
    private boolean f3584e;

    /* renamed from: f */
    private WOWZMediaConfig f3585f = new WOWZMediaConfig();

    public WOWZH264Broadcaster() {
        m3512a();
    }

    /* renamed from: a */
    private void m3512a() {
        this.f3581b = null;
        this.f3583d = true;
        this.f3584e = false;
    }

    public WOWZMediaConfig getVideoSourceConfig() {
        return this.f3585f;
    }

    public WOWZBroadcastConfig getBroadcastConfig() {
        return this.f3581b;
    }

    public WOWZStatus getBroadcasterStatus() {
        return this.f3582c;
    }

    public WOWZStatus getStatus() {
        return getBroadcasterStatus();
    }

    public boolean isVideoPaused() {
        return this.f3584e;
    }

    public void setVideoPaused(boolean z) {
        this.f3584e = z;
    }

    public boolean isVideoEnabled() {
        return this.f3583d;
    }

    public void setVideoEnabled(boolean z) {
        this.f3583d = z;
    }

    public WOWZStatus prepareForBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f3582c.clearLastError();
        if (!this.f3582c.isIdle()) {
            WOWZStatus wOWZStatus = this.f3582c;
            wOWZStatus.setError(new WOWZError("The WOWZH264Broadcaster was in the " + WOWZState.toLabel(this.f3582c.getState()) + " state at broadcast prep (expected IDLE)."));
            WOWZLog.error(f3580a, this.f3582c.getLastError());
            this.f3582c.setState(0);
            return this.f3582c;
        }
        this.f3581b = new WOWZBroadcastConfig(wOWZBroadcastConfig);
        this.f3582c.setState(1);
        this.f3582c.set(prepareEncoder(wOWZBroadcastConfig));
        return this.f3582c;
    }

    public WOWZStatus startBroadcasting() {
        if (!this.f3582c.isReady()) {
            WOWZStatus wOWZStatus = this.f3582c;
            wOWZStatus.setError(new WOWZError("The WOWZH264Broadcaster was in the " + WOWZState.toLabel(this.f3582c.getState()) + " state at broadcast start (expected READY)."));
            WOWZLog.error(f3580a, this.f3582c.getLastError());
            this.f3582c.setState(0);
            return this.f3582c;
        }
        this.f3582c.set(startEncoding());
        return this.f3582c;
    }

    public WOWZStatus stopBroadcasting() {
        if (!this.f3582c.isRunning() && !this.f3582c.isPaused()) {
            WOWZLog.warn(f3580a, "The WOWZH264Broadcaster was in the " + WOWZState.toLabel(this.f3582c.getState()) + " state at broadcast stop (expected RUNNING).");
        }
        this.f3582c.set(stopEncoding());
        this.f3581b = null;
        return this.f3582c;
    }
}
