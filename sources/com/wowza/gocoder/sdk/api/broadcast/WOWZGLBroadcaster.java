package com.wowza.gocoder.sdk.api.broadcast;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.render.WOWZRenderAPI;

/* compiled from: GoCoderSDK */
public class WOWZGLBroadcaster extends WOWZH264Broadcaster {

    /* renamed from: a */
    private static final String f3570a = "WOWZGLBroadcaster";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f3571b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f3572c;

    /* renamed from: d */
    private EGLContext f3573d;

    /* renamed from: e */
    private EGLSurface f3574e;

    /* renamed from: f */
    private long f3575f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f3576g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WOWZRenderAPI.VideoFrameRenderer f3577h;

    public WOWZGLBroadcaster(EGLContext eGLContext, EGLSurface eGLSurface) {
        this.f3571b = new Object();
        this.f3572c = false;
        this.f3573d = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        this.f3574e = eGLSurface == null ? EGL14.EGL_NO_SURFACE : eGLSurface;
        this.f3575f = 0;
        this.f3577h = null;
    }

    public WOWZGLBroadcaster(EGLContext eGLContext) {
        this(eGLContext, EGL14.EGL_NO_SURFACE);
    }

    public WOWZGLBroadcaster() {
        this(EGL14.EGL_NO_CONTEXT, EGL14.EGL_NO_SURFACE);
    }

    public WOWZRenderAPI.VideoFrameRenderer getVideoFrameRenderer() {
        return this.f3577h;
    }

    public void setVideoFrameRenderer(WOWZRenderAPI.VideoFrameRenderer videoFrameRenderer) {
        this.f3577h = videoFrameRenderer;
    }

    public EGLContext getEglContext() {
        return this.f3573d;
    }

    public void setEglContext(EGLContext eGLContext) {
        if (getBroadcasterStatus().isIdle()) {
            if (eGLContext == null) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            this.f3573d = eGLContext;
            return;
        }
        WOWZLog.error(f3570a, "The EGLContext cannot be set unless the broadcaster is idle.");
    }

    public EGLSurface getEglSurface() {
        return this.f3574e;
    }

    public void setEglSurface(EGLSurface eGLSurface) {
        if (getBroadcasterStatus().isIdle()) {
            if (eGLSurface == null) {
                eGLSurface = EGL14.EGL_NO_SURFACE;
            }
            this.f3574e = eGLSurface;
            return;
        }
        WOWZLog.error(f3570a, "The source Surface cannot be set unless the broadcaster is idle.");
    }

    public EGLSurface generateEglSuface(Surface surface) {
        if (this.f3573d == EGL14.EGL_NO_CONTEXT) {
            WOWZLog.error(f3570a, "An invalid EGLContext was specified.");
            return EGL14.EGL_NO_SURFACE;
        }
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        WOWZGLES.checkForEglError("eglGetDisplay");
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            WOWZLog.error(f3570a, "Could not get current EGLDisplay.");
            return EGL14.EGL_NO_SURFACE;
        }
        EGLConfig eglContextConfig = WOWZGLES.getEglContextConfig(eglGetDisplay, this.f3573d);
        if (eglContextConfig == null) {
            WOWZLog.error(f3570a, "Could not get EGLConfig.");
            return EGL14.EGL_NO_SURFACE;
        }
        this.f3574e = WOWZGLES.createEglWindowSurface(surface, eglGetDisplay, eglContextConfig);
        return this.f3574e;
    }

    public void onFrameAvailable(final long j) {
        if (getEncoderStatus().isRunning()) {
            if (!getBroadcasterStatus().isRunning()) {
                WOWZLog.error(f3570a, "Attempt to broadcast surface contents without an active broadcast.");
            } else if (this.f3577h == null) {
                WOWZLog.error(f3570a, "A video frame renderer is not specified.");
            } else if (!getStatus().isRunning()) {
                WOWZLog.error(f3570a, "onFrameAvailable() called but the broadcaster is not running.");
            } else if (hasFrameRateIntervalElapsed()) {
                drainEncoder();
                runOnEncoderThread(new Runnable() {
                    public void run() {
                        if (WOWZGLBroadcaster.this.getEncoderStatus().isRunning()) {
                            synchronized (WOWZGLBroadcaster.this.f3571b) {
                                boolean unused = WOWZGLBroadcaster.this.f3572c = true;
                            }
                            WOWZGLBroadcaster.this.f3577h.onWZVideoFrameRendererDraw(WOWZGLBroadcaster.this.getEncoderEglEnv(), WOWZGLBroadcaster.this.getEncoderConfig().getVideoFrameSize(), WOWZGLBroadcaster.this.getEncoderConfig().getVideoRotation());
                            if (WOWZGLBroadcaster.this.f3576g == 0) {
                                long unused2 = WOWZGLBroadcaster.this.f3576g = j;
                            }
                            WOWZGLBroadcaster.this.onEncodeInputSurfaceContents(j - WOWZGLBroadcaster.this.f3576g);
                            synchronized (WOWZGLBroadcaster.this.f3571b) {
                                boolean unused3 = WOWZGLBroadcaster.this.f3572c = false;
                                WOWZGLBroadcaster.this.f3571b.notifyAll();
                            }
                        }
                    }
                });
                m3506a();
            }
        }
    }

    public void onFrameAvailable() {
        onFrameAvailable(System.nanoTime() - this.f3575f);
    }

    public void setFrameSize(int i, int i2) {
        synchronized (this) {
            getVideoSourceConfig().setVideoFrameSize(i, i2);
        }
    }

    public void setFrameRotation(int i) {
        synchronized (this) {
            getVideoSourceConfig().setVideoRotation(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onPrepareEncoder(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f3575f = System.nanoTime();
        this.f3576g = 0;
        super.onPrepareEncoder(wOWZBroadcastConfig);
        if (getEncoderStatus().isReady()) {
            initEncoderGL(this.f3573d, getEncoderInputSurface());
            this.f3577h.onWZVideoFrameRendererInit(getEncoderEglEnv());
        }
    }

    /* access modifiers changed from: protected */
    public void onStopEncoding() {
        if (getEncoderEglEnv() != null) {
            this.f3577h.onWZVideoFrameRendererRelease(getEncoderEglEnv());
        }
        super.onStopEncoding();
        this.f3575f = 0;
        this.f3576g = 0;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:13:0x0003, LOOP_START, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3506a() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f3571b
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r2.f3572c     // Catch:{ all -> 0x000f }
            if (r1 == 0) goto L_0x000d
            java.lang.Object r1 = r2.f3571b     // Catch:{ InterruptedException -> 0x0003 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.broadcast.WOWZGLBroadcaster.m3506a():void");
    }
}
