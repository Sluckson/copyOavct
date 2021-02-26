package com.wowza.gocoder.sdk.api;

import android.content.Context;
import com.wowza.gocoder.sdk.api.android.graphics.WOWZTextManager;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcast;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.codec.WOWZCodecUtils;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZStreamConfig;
import com.wowza.gocoder.sdk.api.configuration.WowzaConfig;
import com.wowza.gocoder.sdk.api.devices.WOWZAudioDevice;
import com.wowza.gocoder.sdk.api.devices.WOWZCameraView;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.errors.WOWZSDKError;
import com.wowza.gocoder.sdk.api.logging.WOWZAndroidLogger;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.api.status.WOWZStatusCallback;
import com.wowza.gocoder.sdk.support.licensing.LicenseManager;
import com.wowza.gocoder.sdk.support.p029a.C4259a;

/* compiled from: GoCoderSDK */
public final class WowzaGoCoder {
    public static final String ENCODER_INFO = WOWZCodecUtils.getCodecInfo();
    public static final String OPENGLES_INFO = WOWZGLES.getEglInfo();
    public static final String PLATFORM_INFO = WOWZPlatformInfo.getInstance().toString();
    public static final String SDK_VERSION = WOWZVersionInfo.getInstance().toVerboseString();

    /* renamed from: a */
    private static final String f3470a = "WowzaGoCoder";

    /* renamed from: b */
    private static volatile WowzaGoCoder f3471b = new WowzaGoCoder();

    /* renamed from: c */
    private boolean f3472c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WOWZStatus f3473d;

    /* renamed from: e */
    private WOWZBroadcast f3474e;

    /* renamed from: f */
    private WOWZBroadcastConfig f3475f;

    /* renamed from: g */
    private WowzaConfig f3476g;

    /* renamed from: h */
    private WOWZCameraView f3477h;

    /* renamed from: i */
    private WOWZAudioDevice f3478i;

    public static WowzaGoCoder getInstance() {
        return f3471b;
    }

    public static WOWZVersionInfo getVersionInfo() {
        return WOWZVersionInfo.getInstance();
    }

    public static boolean isInitialized() {
        return f3471b.f3472c;
    }

    public static boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean hasPermissions(Context context, String[] strArr) {
        for (String hasPermission : strArr) {
            if (!hasPermission(context, hasPermission)) {
                return false;
            }
        }
        return true;
    }

    public static WOWZError getLastError() {
        return f3471b.getStatus().getLastError();
    }

    public static WowzaGoCoder init(Context context, String str) {
        if (f3471b.f3472c) {
            return f3471b;
        }
        C4259a.m3700a(context.getPackageName(), str);
        f3471b.f3473d.setError(LicenseManager.getInstance().getLicensingError());
        if (f3471b.f3473d.getLastError() != null) {
            return null;
        }
        f3471b.f3472c = true;
        WOWZTextManager.getInstance().init(context);
        return f3471b;
    }

    WowzaGoCoder() {
        this.f3472c = false;
        this.f3472c = false;
        try {
            WOWZError.registerErrors(WOWZPlatformError.ERROR_CLASS);
            if (WOWZLog.getLogger() == null) {
                WOWZLog.registerLogger(WOWZAndroidLogger.getInstance());
            }
            this.f3473d = new WOWZStatus();
            this.f3476g = new WowzaConfig(WOWZMediaConfig.FRAME_SIZE_640x480);
            this.f3474e = new WOWZBroadcast();
            this.f3475f = new WOWZBroadcastConfig();
            this.f3477h = null;
            this.f3478i = null;
        } catch (Exception e) {
            WOWZLog.error(new WOWZSDKError(3).getErrorDescription());
            throw new RuntimeException(e);
        }
    }

    public final WOWZStatus getStatus() {
        return new WOWZStatus(this.f3473d);
    }

    public final WowzaConfig getConfig() {
        return new WowzaConfig(this.f3476g);
    }

    public final void setConfig(WowzaConfig wowzaConfig, boolean z) {
        if (isStreaming()) {
            WOWZLog.error(f3470a, "The configuration can't be updated while streaming is active.");
            return;
        }
        this.f3476g.set(wowzaConfig);
        WOWZCameraView wOWZCameraView = this.f3477h;
        if (wOWZCameraView != null && z) {
            wOWZCameraView.setCameraConfig(this.f3476g);
        }
    }

    public final void setConfig(WowzaConfig wowzaConfig) {
        setConfig(wowzaConfig, false);
    }

    public final void setConfig(WOWZMediaConfig wOWZMediaConfig, boolean z) {
        if (isStreaming()) {
            WOWZLog.error(f3470a, "The configuration can't be updated while streaming is active.");
            return;
        }
        this.f3476g.set(wOWZMediaConfig);
        WOWZCameraView wOWZCameraView = this.f3477h;
        if (wOWZCameraView != null && z) {
            wOWZCameraView.setCameraConfig(this.f3476g);
        }
    }

    public final void setConfig(WOWZMediaConfig wOWZMediaConfig) {
        setConfig(wOWZMediaConfig, false);
    }

    public WOWZBroadcastConfig getDefaultBroadcastConfig() {
        return new WOWZBroadcastConfig(this.f3475f);
    }

    public final void setCameraView(WOWZCameraView wOWZCameraView) {
        if (isStreaming()) {
            WOWZLog.error(f3470a, "The camera view can't be set while streaming is active.");
            return;
        }
        WOWZCameraView wOWZCameraView2 = this.f3477h;
        if (wOWZCameraView2 != null && wOWZCameraView2.isPreviewing()) {
            this.f3477h.stopPreview();
        }
        this.f3477h = wOWZCameraView;
        this.f3475f.setVideoBroadcaster(this.f3477h.getBroadcaster());
    }

    public final WOWZCameraView getCameraView() {
        return this.f3477h;
    }

    public final void startCameraPreview(WOWZMediaConfig wOWZMediaConfig) {
        if (this.f3477h == null) {
            WOWZLog.error(f3470a, "A view hasn't been specified for the camera preview.");
        } else if (isStreaming()) {
            WOWZLog.error(f3470a, "The camera preview can't be started while streaming is active.");
        } else if (!this.f3477h.isPreviewing()) {
            if (wOWZMediaConfig != null) {
                this.f3477h.setCameraConfig(wOWZMediaConfig);
            }
            this.f3477h.startPreview();
        }
    }

    public final void startCameraPreview() {
        startCameraPreview((WOWZMediaConfig) null);
    }

    public final void stopCameraPreview() {
        WOWZCameraView wOWZCameraView = this.f3477h;
        if (wOWZCameraView != null && wOWZCameraView.isPreviewing()) {
            if (isStreaming()) {
                WOWZLog.error(f3470a, "The camera preview can't be stopped while streaming is active.");
            } else {
                this.f3477h.stopPreview();
            }
        }
    }

    public final WOWZAudioDevice getAudioDevice() {
        m3471a();
        return this.f3478i;
    }

    public final WOWZAudioDevice getDefaultAudioDevice() {
        m3471a();
        return this.f3478i;
    }

    public final void muteAudio() {
        WOWZAudioDevice wOWZAudioDevice = this.f3478i;
        if (wOWZAudioDevice != null && !wOWZAudioDevice.isMuted()) {
            this.f3478i.setMuted(true);
        }
    }

    public final void unmuteAudio() {
        WOWZAudioDevice wOWZAudioDevice = this.f3478i;
        if (wOWZAudioDevice != null && wOWZAudioDevice.isMuted()) {
            this.f3478i.setMuted(false);
        }
    }

    public boolean isMuted() {
        WOWZAudioDevice wOWZAudioDevice = this.f3478i;
        return wOWZAudioDevice != null && wOWZAudioDevice.isMuted();
    }

    public final boolean isStreaming() {
        return this.f3474e.getStatus().isRunning();
    }

    public final void startStreaming(final WOWZStatusCallback wOWZStatusCallback) {
        if (isStreaming()) {
            WOWZLog.error(f3470a, "A live streaming broadcast is already active.");
            return;
        }
        this.f3475f.set((WOWZStreamConfig) this.f3476g);
        if (this.f3475f.isAudioEnabled() && this.f3475f.getAudioBroadcaster() == null) {
            m3471a();
        }
        this.f3474e.startBroadcast(this.f3475f, new WOWZStatusCallback() {
            public void onWZStatus(WOWZStatus wOWZStatus) {
                WowzaGoCoder.this.f3473d.set(wOWZStatus);
                WOWZStatusCallback wOWZStatusCallback = wOWZStatusCallback;
                if (wOWZStatusCallback != null) {
                    wOWZStatusCallback.onWZStatus(wOWZStatus);
                }
            }

            public void onWZError(WOWZStatus wOWZStatus) {
                WowzaGoCoder.this.f3473d.set(wOWZStatus);
                WOWZStatusCallback wOWZStatusCallback = wOWZStatusCallback;
                if (wOWZStatusCallback != null) {
                    wOWZStatusCallback.onWZError(wOWZStatus);
                }
            }
        });
    }

    public final void startStreaming(WowzaConfig wowzaConfig, WOWZStatusCallback wOWZStatusCallback) {
        setConfig(wowzaConfig);
        startStreaming(wOWZStatusCallback);
    }

    public final void startStreaming(WOWZMediaConfig wOWZMediaConfig, WOWZStatusCallback wOWZStatusCallback) {
        setConfig(wOWZMediaConfig);
        startStreaming(wOWZStatusCallback);
    }

    public final void endStreaming(final WOWZStatusCallback wOWZStatusCallback) {
        if (!isStreaming()) {
            WOWZLog.error(f3470a, "There is no active live streaming broadcast.");
            return;
        }
        this.f3474e.endBroadcast(new WOWZStatusCallback() {
            public void onWZStatus(WOWZStatus wOWZStatus) {
                WowzaGoCoder.this.f3473d.set(wOWZStatus);
                WOWZStatusCallback wOWZStatusCallback = wOWZStatusCallback;
                if (wOWZStatusCallback != null) {
                    wOWZStatusCallback.onWZStatus(wOWZStatus);
                }
            }

            public void onWZError(WOWZStatus wOWZStatus) {
                WowzaGoCoder.this.f3473d.set(wOWZStatus);
                WOWZStatusCallback wOWZStatusCallback = wOWZStatusCallback;
                if (wOWZStatusCallback != null) {
                    wOWZStatusCallback.onWZError(wOWZStatus);
                }
            }
        });
    }

    public final void endStreaming() {
        endStreaming((WOWZStatusCallback) null);
    }

    /* renamed from: a */
    private void m3471a() {
        if (this.f3478i == null) {
            this.f3478i = new WOWZAudioDevice();
        }
        this.f3475f.setAudioBroadcaster(f3471b.f3478i);
    }
}
