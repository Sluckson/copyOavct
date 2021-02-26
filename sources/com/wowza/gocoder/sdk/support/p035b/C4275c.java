package com.wowza.gocoder.sdk.support.p035b;

import android.opengl.EGLContext;
import android.opengl.Matrix;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.broadcast.WOWZH264Broadcaster;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.render.WOWZRenderAPI;

/* renamed from: com.wowza.gocoder.sdk.support.b.c */
/* compiled from: GoCoderSDK */
public class C4275c extends WOWZH264Broadcaster implements WOWZRenderAPI.VideoFrameListener {

    /* renamed from: a */
    private static final String f4071a = "c";

    /* renamed from: b */
    private final Object f4072b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f4073c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f4074d;

    /* renamed from: e */
    private float[] f4075e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f4076f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WOWZRenderAPI.VideoFrameRenderer f4077g;

    /* renamed from: h */
    private EGLContext f4078h;

    public C4275c() {
        this.f4072b = new Object();
        this.f4073c = new Object();
        this.f4075e = new float[16];
        this.f4078h = null;
        m3787a();
    }

    public C4275c(WOWZRenderAPI.VideoFrameRenderer videoFrameRenderer) {
        this();
        mo59046a(videoFrameRenderer);
    }

    /* renamed from: a */
    private void m3787a() {
        Matrix.setIdentityM(this.f4075e, 0);
        this.f4076f = 0;
        this.f4077g = null;
        this.f4074d = false;
    }

    /* renamed from: a */
    public void mo59046a(WOWZRenderAPI.VideoFrameRenderer videoFrameRenderer) {
        synchronized (this.f4072b) {
            this.f4077g = videoFrameRenderer;
        }
    }

    /* renamed from: b */
    public void mo59047b(WOWZRenderAPI.VideoFrameRenderer videoFrameRenderer) {
        mo59046a(videoFrameRenderer);
    }

    /* access modifiers changed from: protected */
    public void onPrepareEncoder(WOWZBroadcastConfig wOWZBroadcastConfig) {
        super.onPrepareEncoder(wOWZBroadcastConfig);
        if (getEncoderStatus().isReady()) {
            initEncoderGL(this.f4078h, getEncoderInputSurface());
        }
    }

    public boolean isWZVideoFrameListenerActive() {
        return getBroadcasterStatus().isRunning() && getEncoderStatus().isRunning();
    }

    public void onWZVideoFrameListenerInit(WOWZGLES.EglEnv eglEnv) {
        startEncoderThread();
        this.f4078h = eglEnv.getEglContext();
    }

    public void onWZVideoFrameListenerFrameAvailable(WOWZGLES.EglEnv eglEnv, WOWZSize wOWZSize, int i, final long j) {
        if (getEncoderStatus().isRunning()) {
            if (!getBroadcasterStatus().isRunning()) {
                IllegalStateException illegalStateException = new IllegalStateException("Attempt to encode surface contents without an active broadcast");
                WOWZLog.error(f4071a, (Throwable) illegalStateException);
                throw illegalStateException;
            } else if (this.f4077g == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("A video frame renderer has not been specified");
                WOWZLog.error(f4071a, (Throwable) illegalArgumentException);
                throw illegalArgumentException;
            } else if (hasFrameRateIntervalElapsed()) {
                getStreamingMonitor().mo59085b(0);
                drainEncoder();
                getVideoSourceConfig().setVideoFrameSize(wOWZSize);
                getVideoSourceConfig().setVideoRotation(i);
                getEncoderConfig().setVideoRotation(i);
                runOnEncoderThread(new Runnable() {
                    public void run() {
                        if (C4275c.this.getEncoderStatus().isRunning()) {
                            synchronized (C4275c.this.f4073c) {
                                boolean unused = C4275c.this.f4074d = true;
                            }
                            C4275c.this.f4077g.onWZVideoFrameRendererDraw(C4275c.this.getEncoderEglEnv(), C4275c.this.getEncoderConfig().getVideoFrameSize(), C4275c.this.getEncoderConfig().getVideoRotation());
                            if (C4275c.this.f4076f == 0) {
                                long unused2 = C4275c.this.f4076f = j;
                            }
                            C4275c.this.onEncodeInputSurfaceContents(j - C4275c.this.f4076f);
                            synchronized (C4275c.this.f4073c) {
                                boolean unused3 = C4275c.this.f4074d = false;
                                C4275c.this.f4073c.notifyAll();
                            }
                        }
                    }
                });
            } else {
                getStreamingMonitor().mo59085b(3);
            }
        }
    }

    public void onWZVideoFrameListenerRelease(WOWZGLES.EglEnv eglEnv) {
        m3790b();
        shutdownEncoderThread();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:13:0x0003, LOOP_START, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3790b() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f4073c
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r2.f4074d     // Catch:{ all -> 0x000f }
            if (r1 == 0) goto L_0x000d
            java.lang.Object r1 = r2.f4073c     // Catch:{ InterruptedException -> 0x0003 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0003 }
            goto L_0x0003
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p035b.C4275c.m3790b():void");
    }
}
