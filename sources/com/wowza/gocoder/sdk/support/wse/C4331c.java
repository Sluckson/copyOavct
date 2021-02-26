package com.wowza.gocoder.sdk.support.wse;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.common.base.Ascii;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataEvent;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.data.WOWZDataScope;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZStreamingError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c;
import org.apache.http.util.ByteArrayBuffer;

/* renamed from: com.wowza.gocoder.sdk.support.wse.c */
/* compiled from: GoCoderSDK */
public final class C4331c extends C4329a implements WOWZSinkAPI.StreamingAudioSink, WOWZSinkAPI.StreamingVideoSink {

    /* renamed from: i */
    private static final String f4684i = "c";

    /* renamed from: j */
    private static final int f4685j = 5000;

    /* renamed from: h */
    protected boolean f4686h = false;

    /* renamed from: k */
    private final Object f4687k = new Object();

    /* renamed from: l */
    private final Object f4688l = new Object();

    /* renamed from: m */
    private HandlerThread f4689m;

    /* renamed from: n */
    private Handler f4690n;

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59605a(int i) {
        super.mo59605a(i);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59606a(WOWZDataEvent.ResultCallback resultCallback) {
        super.mo59606a(resultCallback);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59607a(WOWZDataScope wOWZDataScope, String str, WOWZDataMap wOWZDataMap, WOWZDataEvent.ResultCallback resultCallback) {
        super.mo59607a(wOWZDataScope, str, wOWZDataMap, resultCallback);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59608a(String str, WOWZDataEvent.EventListener eventListener) {
        super.mo59608a(str, eventListener);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ int mo59610b() {
        return super.mo59610b();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo59611b(String str, WOWZDataEvent.EventListener eventListener) {
        super.mo59611b(str, eventListener);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ WOWZStatus mo59613d() {
        return super.mo59613d();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ WOWZBroadcastConfig mo59614e() {
        return super.mo59614e();
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo59615f() {
        super.mo59615f();
    }

    public /* bridge */ /* synthetic */ boolean isAudioEnabled() {
        return super.isAudioEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isAudioPaused() {
        return super.isAudioPaused();
    }

    public /* bridge */ /* synthetic */ boolean isVideoEnabled() {
        return super.isVideoEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isVideoPaused() {
        return super.isVideoPaused();
    }

    public /* bridge */ /* synthetic */ void setAudioEnabled(boolean z) {
        super.setAudioEnabled(z);
    }

    public /* bridge */ /* synthetic */ void setAudioPaused(boolean z) {
        super.setAudioPaused(z);
    }

    public /* bridge */ /* synthetic */ void setVideoEnabled(boolean z) {
        super.setVideoEnabled(z);
    }

    public /* bridge */ /* synthetic */ void setVideoPaused(boolean z) {
        super.setVideoPaused(z);
    }

    public WOWZStatus getBroadcasterStatus() {
        return this.f4677c;
    }

    public WOWZStatus getStatus() {
        return getBroadcasterStatus();
    }

    public WOWZBroadcastConfig getBroadcastConfig() {
        return this.f4676b;
    }

    public WOWZStatus prepareForBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f4677c.clearLastError();
        this.f4677c.setState(1);
        WOWZLog.debug("***** [FPS]StreamPublisher " + wOWZBroadcastConfig.getVideoFramerate());
        this.f4676b.set(wOWZBroadcastConfig);
        this.f4675a.mo59637a(this.f4676b);
        this.f4686h = false;
        mo59609a(false);
        this.f4675a.mo59647b(wOWZBroadcastConfig.isVideoEnabled());
        if (this.f4675a.mo59654e(0) == 1) {
            this.f4677c.setError(this.f4675a.mo59635a(true));
            this.f4677c.setState(0);
            WOWZLog.error(f4684i, this.f4677c.getLastError());
        } else {
            mo59609a(true);
            this.f4677c.setState(2);
        }
        return this.f4677c;
    }

    public WOWZStatus startBroadcasting() {
        WOWZBroadcastConfig broadcastConfig = getBroadcastConfig();
        WOWZLog.debug("***** [FPS]StreamPublisher4 " + broadcastConfig.getVideoFramerate());
        this.f4675a.mo59637a(broadcastConfig);
        if (this.f4675a.mo59658h()) {
            this.f4677c.setState(3);
            synchronized (this.f4688l) {
                this.f4689m = new HandlerThread("WZStreamPublisher");
                this.f4689m.start();
                this.f4690n = new Handler(this.f4689m.getLooper());
            }
        }
        return this.f4677c;
    }

    public WOWZStatus stopBroadcasting() {
        this.f4677c.setState(4);
        synchronized (this.f4688l) {
            if (this.f4690n != null) {
                this.f4690n.removeCallbacksAndMessages((Object) null);
            }
            if (this.f4689m != null) {
                this.f4689m.quitSafely();
            }
            this.f4689m = null;
            this.f4690n = null;
        }
        this.f4675a.mo59661k();
        mo59609a(false);
        this.f4677c.clearLastError();
        this.f4677c.setState(0);
        return this.f4677c;
    }

    public void onParameterSets(byte[] bArr, byte[] bArr2) {
        synchronized (this.f4687k) {
            this.f4675a.mo59641a(bArr, bArr2);
        }
    }

    public void onVideoConfigFrame(byte[] bArr, int i) {
        int d;
        if (mo59612c() && !this.f4679e && bArr != null && i != 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(0);
            byte[] i2 = C4317c.m4415i(bArr2, 0, bArr2.length);
            byte[] bArr3 = null;
            int i3 = 0;
            while (i3 < i2.length && (d = C4307c.m4292d(i2, i3, 4)) >= 0) {
                int i4 = i3 + 4;
                byte b = i2[i4] & Ascii.f275US;
                if (b != 7) {
                    if (b == 8) {
                        byteArrayBuffer.append(i2, i4, d);
                    }
                } else if (bArr3 == null) {
                    bArr3 = new byte[d];
                    System.arraycopy(i2, i4, bArr3, 0, d);
                }
                i3 += d + 4;
            }
            synchronized (this.f4687k) {
                this.f4675a.mo59641a(bArr3, byteArrayBuffer.toByteArray());
            }
        }
    }

    public void onVideoFrame(long j, byte[] bArr, int i) {
        if (mo59612c() && !this.f4679e) {
            WOWZBroadcastAPI.BroadcastErrorCallback errorCallback = this.f4676b.getErrorCallback();
            try {
                this.f4677c.clearLastError();
                synchronized (this.f4687k) {
                    if (this.f4675a.mo59632a(j, bArr, i, 5000) != 0) {
                        this.f4677c.setError(this.f4675a.mo59648c());
                        mo59609a(false);
                        if (errorCallback != null) {
                            errorCallback.onBroadcastError(this.f4677c.getLastError());
                        }
                    }
                }
            } catch (Exception e) {
                this.f4677c.setError(new WOWZError(WOWZStreamingError.ERROR_CLASS, 14, e));
                mo59609a(false);
                if (errorCallback != null) {
                    errorCallback.onBroadcastError(this.f4677c.getLastError());
                }
            }
            if (this.f4677c.getLastError() != null) {
                WOWZLog.error(f4684i, this.f4677c.getLastError());
            }
        }
    }

    public void onAudioFrame(long j, byte[] bArr, int i) {
        if (mo59612c() && !this.f4681g) {
            WOWZBroadcastAPI.BroadcastErrorCallback errorCallback = this.f4676b.getErrorCallback();
            try {
                synchronized (this.f4687k) {
                    this.f4677c.clearLastError();
                    if (this.f4675a.mo59643b(j, bArr, i, 5000) != 0) {
                        this.f4677c.setError(this.f4675a.mo59648c());
                        mo59609a(false);
                        if (errorCallback != null) {
                            errorCallback.onBroadcastError(this.f4677c.getLastError());
                        }
                    }
                }
            } catch (Exception e) {
                this.f4677c.setError(new WOWZError(WOWZStreamingError.ERROR_CLASS, 15, e));
                mo59609a(false);
                if (errorCallback != null) {
                    errorCallback.onBroadcastError(this.f4677c.getLastError());
                }
            }
            if (this.f4677c.getLastError() != null) {
                WOWZLog.error(f4684i, this.f4677c.getLastError());
            }
        }
    }

    public Handler getVideoSinkHandler() {
        Handler handler;
        synchronized (this.f4688l) {
            handler = this.f4690n;
        }
        return handler;
    }

    public Handler getAudioSinkHandler() {
        Handler handler;
        synchronized (this.f4688l) {
            handler = this.f4690n;
        }
        return handler;
    }
}
