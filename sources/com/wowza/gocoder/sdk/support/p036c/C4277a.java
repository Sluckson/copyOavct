package com.wowza.gocoder.sdk.support.p036c;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.codec.WOWZCodecUtils;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.h264.WOWZProfileLevel;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI;
import com.wowza.gocoder.sdk.api.status.WOWZState;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.support.licensing.LicenseManager;
import com.wowza.gocoder.sdk.support.p029a.p033b.C4270a;
import com.wowza.gocoder.sdk.support.p037d.C4280a;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* renamed from: com.wowza.gocoder.sdk.support.c.a */
/* compiled from: GoCoderSDK */
public class C4277a implements WOWZBroadcastAPI.AdaptiveBroadcaster, Runnable {

    /* renamed from: A */
    private static final int f4081A = 1;

    /* renamed from: B */
    private static final int f4082B = 2;

    /* renamed from: C */
    private static final int f4083C = 3;

    /* renamed from: a */
    private static final String f4084a = "a";

    /* renamed from: s */
    private static final int f4085s = 0;

    /* renamed from: t */
    private static final int f4086t = 1;

    /* renamed from: v */
    private static final int f4087v = 0;

    /* renamed from: w */
    private static final int f4088w = 1;

    /* renamed from: x */
    private static final int f4089x = 2;

    /* renamed from: z */
    private static final int f4090z = 0;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public long[] f4091D = new long[4];

    /* renamed from: E */
    private long f4092E;

    /* renamed from: b */
    private final Object f4093b = new Object();

    /* renamed from: c */
    private boolean f4094c = false;

    /* renamed from: d */
    private volatile C4279a f4095d = null;

    /* renamed from: e */
    private final Object f4096e = new Object();

    /* renamed from: f */
    private MediaCodec f4097f;

    /* renamed from: g */
    private MediaFormat f4098g;

    /* renamed from: h */
    private Surface f4099h;

    /* renamed from: i */
    private boolean f4100i;

    /* renamed from: j */
    private MediaCodec.BufferInfo f4101j;

    /* renamed from: k */
    private WOWZStatus f4102k = new WOWZStatus(0);

    /* renamed from: l */
    private WOWZMediaConfig f4103l = new WOWZMediaConfig();

    /* renamed from: m */
    private WOWZSinkAPI.VideoSink[] f4104m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C4280a f4105n;

    /* renamed from: o */
    private C4270a f4106o = null;

    /* renamed from: p */
    private WOWZGLES.EglEnv f4107p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public long f4108q;

    /* renamed from: r */
    private final Object f4109r = new Object();

    /* renamed from: u */
    private int[] f4110u = new int[2];

    /* renamed from: y */
    private int[] f4111y = new int[3];

    public C4277a() {
        if (LicenseManager.getInstance().isEvaluation()) {
            this.f4106o = new C4270a();
        }
        m3800a();
    }

    /* renamed from: a */
    private void m3800a() {
        this.f4097f = null;
        this.f4098g = null;
        this.f4099h = null;
        this.f4100i = false;
        this.f4101j = null;
        this.f4107p = null;
        this.f4103l = null;
        this.f4104m = null;
        this.f4105n = null;
        m3801a(0);
        m3806b(0);
        m3810e();
    }

    public String getMediaCodecName() {
        MediaCodec mediaCodec = this.f4097f;
        return mediaCodec != null ? mediaCodec.getName() : "";
    }

    public String getMediaFormatDescription() {
        return this.f4098g != null ? this.f4097f.getOutputFormat().toString() : "";
    }

    /* access modifiers changed from: protected */
    public WOWZGLES.EglEnv getEncoderEglEnv() {
        WOWZGLES.EglEnv eglEnv;
        synchronized (this.f4096e) {
            eglEnv = this.f4107p;
        }
        return eglEnv;
    }

    public WOWZGLES.EglEnv getEglEnv() {
        WOWZGLES.EglEnv eglEnv;
        synchronized (this.f4096e) {
            eglEnv = this.f4107p;
        }
        return eglEnv;
    }

    public WOWZMediaConfig getEncoderConfig() {
        return this.f4103l;
    }

    public void onFrameSubmittedToEncoder(long j) {
        synchronized (this.f4109r) {
            this.f4091D[2] = j;
        }
    }

    public void onFrameSubmittedToEncoder() {
        synchronized (this.f4109r) {
            this.f4091D[2] = System.currentTimeMillis();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasFrameRateIntervalElapsed() {
        /*
            r8 = this;
            com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig r0 = r8.f4103l
            boolean r0 = r0.isABREnabled()
            r1 = 1
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.Object r0 = r8.f4109r
            monitor-enter(r0)
            long[] r2 = r8.f4091D     // Catch:{ all -> 0x0044 }
            r3 = 2
            r4 = r2[r3]     // Catch:{ all -> 0x0044 }
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0042
            int[] r2 = r8.f4110u     // Catch:{ all -> 0x0044 }
            r2 = r2[r1]     // Catch:{ all -> 0x0044 }
            int[] r4 = r8.f4110u     // Catch:{ all -> 0x0044 }
            r5 = 0
            r4 = r4[r5]     // Catch:{ all -> 0x0044 }
            if (r2 != r4) goto L_0x0024
            goto L_0x0042
        L_0x0024:
            r2 = 1000(0x3e8, float:1.401E-42)
            int[] r4 = r8.f4110u     // Catch:{ all -> 0x0044 }
            r4 = r4[r1]     // Catch:{ all -> 0x0044 }
            int r2 = r2 / r4
            float r2 = (float) r2     // Catch:{ all -> 0x0044 }
            int r2 = java.lang.Math.round(r2)     // Catch:{ all -> 0x0044 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0044 }
            long[] r4 = r8.f4091D     // Catch:{ all -> 0x0044 }
            r3 = r4[r3]     // Catch:{ all -> 0x0044 }
            long r6 = r6 - r3
            long r2 = (long) r2     // Catch:{ all -> 0x0044 }
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return r1
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return r1
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p036c.C4277a.hasFrameRateIntervalElapsed():boolean");
    }

    /* access modifiers changed from: protected */
    public WOWZStatus getEncoderStatus() {
        return this.f4102k;
    }

    /* access modifiers changed from: protected */
    public C4280a getStreamingMonitor() {
        return this.f4105n;
    }

    public Surface getEncoderInputSurface() {
        return this.f4099h;
    }

    /* access modifiers changed from: protected */
    public void startEncoderThread() {
        synchronized (this.f4093b) {
            if (this.f4094c) {
                WOWZLog.warn(f4084a, "The H264Encoder thread is already running");
                return;
            }
            new Thread(this, f4084a).start();
            while (!this.f4094c) {
                try {
                    this.f4093b.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public void run() {
        Looper.prepare();
        synchronized (this.f4093b) {
            this.f4095d = new C4279a(this);
            this.f4094c = true;
            this.f4093b.notify();
        }
        Looper.loop();
        m3805b();
        synchronized (this.f4093b) {
            this.f4094c = false;
            this.f4095d = null;
            this.f4093b.notify();
        }
        this.f4102k.setState(0);
    }

    public void runOnEncoderThread(Runnable runnable) {
        if (this.f4095d != null) {
            this.f4095d.post(runnable);
        }
    }

    public void setSharedContext(EGLContext eGLContext) {
        if (!getEncoderStatus().isRunning()) {
            this.f4095d.m3812a(eGLContext);
        } else {
            WOWZLog.error(f4084a, "Can't set shared EGLContext while the encoder is running");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3802a(EGLContext eGLContext) {
        WOWZGLES.EglEnv eglEnv = this.f4107p;
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        eglEnv.setSharedEglContext(eGLContext);
    }

    /* access modifiers changed from: protected */
    public WOWZStatus prepareEncoder(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.f4102k.clearLastError();
        if (!this.f4102k.isIdle()) {
            WOWZStatus wOWZStatus = this.f4102k;
            wOWZStatus.setError(new WOWZError("The " + f4084a + " was in a " + WOWZState.toLabel(this.f4102k.getState()) + " state at encoder prep (expected IDLE)"));
            WOWZLog.error(f4084a, this.f4102k.getLastError());
            this.f4102k.setState(0);
            return this.f4102k;
        }
        this.f4102k.setState(1);
        if (!this.f4094c) {
            startEncoderThread();
        }
        this.f4095d.m3813a((WOWZMediaConfig) wOWZBroadcastConfig);
        this.f4102k.waitForState(2);
        return this.f4102k;
    }

    /* access modifiers changed from: protected */
    public void onPrepareEncoder(WOWZBroadcastConfig wOWZBroadcastConfig) {
        m3800a();
        this.f4104m = wOWZBroadcastConfig.getVideoSinks();
        this.f4105n = wOWZBroadcastConfig.getStreamingMonitor();
        m3806b(wOWZBroadcastConfig.getVideoBitRate());
        m3801a(wOWZBroadcastConfig.getVideoFramerate());
        MediaCodecInfo[] encodersForType = WOWZCodecUtils.getEncodersForType("video/avc");
        if (encodersForType.length == 0) {
            this.f4102k.setError(new WOWZPlatformError(61));
            WOWZLog.error(f4084a, this.f4102k.getLastError());
            return;
        }
        for (int i = 0; i < encodersForType.length && this.f4097f == null; i++) {
            MediaCodecInfo mediaCodecInfo = encodersForType[i];
            try {
                this.f4097f = MediaCodec.createByCodecName(mediaCodecInfo.getName());
            } catch (Exception e) {
                this.f4102k.setError(new WOWZPlatformError(63, e));
                WOWZLog.warn(f4084a, this.f4102k.getLastError());
                MediaCodec mediaCodec = this.f4097f;
                if (mediaCodec != null) {
                    try {
                        mediaCodec.release();
                    } catch (Exception unused) {
                    }
                }
                this.f4098g = null;
                this.f4097f = null;
            }
            if (this.f4097f != null) {
                this.f4098g = m3799a(mediaCodecInfo, (WOWZMediaConfig) wOWZBroadcastConfig);
                try {
                    this.f4098g.setInteger("frame-rate", wOWZBroadcastConfig.getVideoFramerate());
                    this.f4097f.configure(this.f4098g, (Surface) null, (MediaCrypto) null, 1);
                } catch (Exception e2) {
                    this.f4102k.setError(new WOWZPlatformError(63, e2));
                    WOWZLog.error(f4084a, this.f4102k.getLastError());
                    MediaCodec mediaCodec2 = this.f4097f;
                    if (mediaCodec2 != null) {
                        try {
                            mediaCodec2.release();
                        } catch (Exception unused2) {
                        }
                    }
                    this.f4098g = null;
                    this.f4097f = null;
                }
            } else {
                String str = f4084a;
                WOWZLog.warn(str, "Could not create an H264 MediaCodec encoder using the following codec: " + mediaCodecInfo.getName());
            }
        }
        MediaCodec mediaCodec3 = this.f4097f;
        if (mediaCodec3 == null) {
            this.f4098g = null;
            this.f4102k.setError(new WOWZPlatformError(61));
            WOWZLog.error(f4084a, this.f4102k.getLastError());
            this.f4102k.setState(0);
            return;
        }
        this.f4099h = mediaCodec3.createInputSurface();
        this.f4103l = new WOWZMediaConfig((WOWZMediaConfig) wOWZBroadcastConfig);
        this.f4102k.setState(2);
    }

    /* renamed from: a */
    private MediaFormat m3799a(MediaCodecInfo mediaCodecInfo, WOWZMediaConfig wOWZMediaConfig) {
        MediaCodecInfo.CodecProfileLevel a;
        int videoFrameWidth = wOWZMediaConfig.getVideoFrameWidth();
        int videoFrameHeight = wOWZMediaConfig.getVideoFrameHeight();
        if (mediaCodecInfo.getName().toUpperCase().equals("OMX.TI.DUCATI1.VIDEO.H264E")) {
            videoFrameWidth &= -16;
            String str = f4084a;
            WOWZLog.warn(str, "The width of the encoded frames will be rounded to a multiple of 16 because the H264 encoder detected was " + mediaCodecInfo.getName() + "\nThe encoded frame size will be " + videoFrameWidth + "x" + videoFrameHeight);
        } else if (mediaCodecInfo.getName().toUpperCase().contains("OMX.GOOGLE.H264")) {
            videoFrameWidth &= -16;
            videoFrameHeight &= -16;
            String str2 = f4084a;
            WOWZLog.warn(str2, "The width and height of the encoded frames will be rounded to a multiple of 16 because the H264 encoder detected was " + mediaCodecInfo.getName() + "\nThe encoded frame size will be " + videoFrameWidth + "x" + videoFrameHeight);
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", videoFrameWidth, videoFrameHeight);
        createVideoFormat.setInteger("bitrate", wOWZMediaConfig.getVideoBitRate() * 1000);
        WOWZLog.debug("****[FPS]  H26Encoder KEY_FRAME_RATE :: " + wOWZMediaConfig.getVideoFramerate());
        createVideoFormat.setInteger("capture-rate", wOWZMediaConfig.getVideoFramerate());
        createVideoFormat.setInteger("frame-rate", wOWZMediaConfig.getVideoFramerate());
        createVideoFormat.setInteger("i-frame-interval", WOWZMediaConfig.keyFrameIntervalFramesToSeconds(wOWZMediaConfig.getVideoKeyFrameInterval(), wOWZMediaConfig.getVideoFramerate()));
        createVideoFormat.setInteger("color-format", 2130708361);
        WOWZProfileLevel videoProfileLevel = wOWZMediaConfig.getVideoProfileLevel();
        if (!(videoProfileLevel == null || (a = m3798a(videoProfileLevel, mediaCodecInfo)) == null)) {
            if (videoProfileLevel.getLevel() == 0) {
                createVideoFormat.setInteger(Scopes.PROFILE, a.profile);
            } else {
                createVideoFormat.setInteger(Scopes.PROFILE, a.profile);
                createVideoFormat.setInteger(FirebaseAnalytics.Param.LEVEL, a.level);
            }
        }
        WOWZLog.debug("****[FPS]  H26Encoder mediaFormat :: " + createVideoFormat);
        return createVideoFormat;
    }

    /* renamed from: a */
    private MediaCodecInfo.CodecProfileLevel m3798a(WOWZProfileLevel wOWZProfileLevel, MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo.CodecProfileLevel WZProfileLevelToProfileLevel = WOWZCodecUtils.WZProfileLevelToProfileLevel(wOWZProfileLevel);
        if (WZProfileLevelToProfileLevel == null) {
            return null;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType("video/avc").profileLevels) {
            if (codecProfileLevel.profile == WZProfileLevelToProfileLevel.profile && (wOWZProfileLevel.getLevel() == 0 || codecProfileLevel.level == WZProfileLevelToProfileLevel.level)) {
                return codecProfileLevel;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initEncoderGL(android.opengl.EGLContext r2, android.view.Surface r3) {
        /*
            r1 = this;
            com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES$EglEnv r0 = r1.f4107p
            if (r0 == 0) goto L_0x0007
            r0.release()     // Catch:{ Exception -> 0x0007 }
        L_0x0007:
            com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES$EglEnv r0 = new com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES$EglEnv     // Catch:{ Exception -> 0x0015 }
            r0.<init>((android.opengl.EGLContext) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x0015 }
            r1.f4107p = r0     // Catch:{ Exception -> 0x0015 }
            com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES$EglEnv r2 = r1.f4107p
            boolean r2 = r2.makeCurrent()
            return r2
        L_0x0015:
            r2 = move-exception
            java.lang.String r3 = f4084a
            java.lang.String r0 = "An exception occurred setting up the encoder's OpenGL ES environment"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r2)
            r2 = 0
            r1.f4107p = r2
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p036c.C4277a.initEncoderGL(android.opengl.EGLContext, android.view.Surface):boolean");
    }

    /* access modifiers changed from: protected */
    public void initEncoderGL(Surface surface) {
        initEncoderGL(EGL14.EGL_NO_CONTEXT, surface);
    }

    /* access modifiers changed from: protected */
    public WOWZStatus startEncoding() {
        if (!this.f4102k.isReady()) {
            WOWZStatus wOWZStatus = this.f4102k;
            wOWZStatus.setError(new WOWZError("The " + f4084a + " was in a " + WOWZState.toLabel(this.f4102k.getState()) + " state at encoder start (expected READY)"));
            WOWZLog.error(f4084a, this.f4102k.getLastError());
            this.f4102k.waitForState(0);
            return this.f4102k;
        }
        this.f4095d.m3811a();
        this.f4102k.waitForState(3);
        return this.f4102k;
    }

    /* access modifiers changed from: protected */
    public void onStartEncoding() {
        try {
            this.f4108q = 0;
            if (this.f4107p == null) {
                initEncoderGL(this.f4099h);
            }
            if (!(this.f4107p == null || this.f4106o == null)) {
                this.f4106o.onWZVideoFrameRendererInit(this.f4107p);
            }
            this.f4101j = new MediaCodec.BufferInfo();
            this.f4097f.start();
            this.f4092E = 0;
            this.f4091D[0] = System.currentTimeMillis();
            this.f4102k.setState(3);
        } catch (Exception e) {
            this.f4102k.setError(new WOWZPlatformError(65, e));
            WOWZLog.error(f4084a, this.f4102k.getLastError());
            m3805b();
            this.f4102k.setState(0);
        }
    }

    /* access modifiers changed from: protected */
    public void drainEncoder() {
        if (this.f4102k.isRunning() || !this.f4102k.isStarting()) {
            this.f4095d.m3819b();
            return;
        }
        WOWZStatus wOWZStatus = this.f4102k;
        wOWZStatus.setError(new WOWZError("The H264 encoder was in a " + WOWZState.toLabel(this.f4102k.getState()) + " state at encoder drain (expected RUNNING or STOPPING)"));
        WOWZLog.error(f4084a, this.f4102k.getLastError());
    }

    /* access modifiers changed from: protected */
    public void onDrainEncoder() {
        int i;
        ByteBuffer[] outputBuffers = this.f4097f.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f4097f.dequeueOutputBuffer(this.f4101j, 10000);
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -3) {
                    WOWZLog.warn(f4084a, "Got output buffers changed");
                    outputBuffers = this.f4097f.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f4100i) {
                        WOWZLog.warn(f4084a, "Got output format changed more than once");
                    }
                    this.f4100i = true;
                } else if (dequeueOutputBuffer < 0) {
                    WOWZLog.warn(f4084a, "Unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else if (dequeueOutputBuffer < 0) {
                    continue;
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        WOWZLog.warn(f4084a, "Video encoder encoderOutputBuffers[ " + dequeueOutputBuffer + "] was null");
                        return;
                    }
                    if (this.f4101j.size == 0 || !this.f4102k.isRunning()) {
                        this.f4097f.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else if (!this.f4100i) {
                        WOWZLog.error(f4084a, "Video encoder hasn't started");
                        return;
                    } else {
                        int i2 = this.f4101j.offset + this.f4101j.size;
                        byteBuffer.position(this.f4101j.offset);
                        byteBuffer.limit(i2);
                        byte[] bArr = new byte[i2];
                        byteBuffer.get(bArr, 0, bArr.length);
                        this.f4108q += (long) bArr.length;
                        this.f4097f.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if (this.f4105n.mo59089c()) {
                            this.f4105n.mo59085b(1);
                            this.f4105n.mo59088c(bArr.length);
                            this.f4105n.mo59081a(0, bArr.length);
                        }
                        if ((this.f4101j.flags & 2) == 2) {
                            for (WOWZSinkAPI.VideoSink videoSink : this.f4104m) {
                                if (videoSink instanceof WOWZSinkAPI.StreamingVideoSink) {
                                    ((WOWZSinkAPI.StreamingVideoSink) videoSink).onVideoConfigFrame(bArr, bArr.length);
                                    this.f4108q -= (long) bArr.length;
                                    if (this.f4105n.mo59089c()) {
                                        this.f4105n.mo59085b(2);
                                    }
                                    this.f4091D[3] = System.currentTimeMillis();
                                } else if (videoSink instanceof WOWZSinkAPI.MediaCodecVideoSink) {
                                    ((WOWZSinkAPI.MediaCodecVideoSink) videoSink).onVideoFormat(this.f4097f.getOutputFormat());
                                }
                            }
                        } else {
                            long[] jArr = this.f4091D;
                            if (jArr[1] == 0) {
                                jArr[1] = this.f4101j.presentationTimeUs;
                            }
                            long j = (this.f4101j.presentationTimeUs - this.f4091D[1]) / 1000;
                            if (j != 0 && j <= this.f4092E) {
                                WOWZLog.warn(f4084a, "New timestamp : " + j + ", last timestamp : " + this.f4092E);
                            }
                            this.f4092E = j;
                            WOWZSinkAPI.VideoSink[] videoSinkArr = this.f4104m;
                            int length = videoSinkArr.length;
                            int i3 = 0;
                            while (i3 < length) {
                                WOWZSinkAPI.VideoSink videoSink2 = videoSinkArr[i3];
                                if (videoSink2 instanceof WOWZSinkAPI.StreamingVideoSink) {
                                    final WOWZSinkAPI.StreamingVideoSink streamingVideoSink = (WOWZSinkAPI.StreamingVideoSink) videoSink2;
                                    Handler videoSinkHandler = streamingVideoSink.getVideoSinkHandler();
                                    if (videoSinkHandler != null) {
                                        Handler handler = videoSinkHandler;
                                        C42781 r8 = r1;
                                        final long j2 = j;
                                        i = i3;
                                        final byte[] bArr2 = bArr;
                                        C42781 r1 = new Runnable() {
                                            public void run() {
                                                WOWZSinkAPI.StreamingVideoSink streamingVideoSink = streamingVideoSink;
                                                long j = j2;
                                                byte[] bArr = bArr2;
                                                streamingVideoSink.onVideoFrame(j, bArr, bArr.length);
                                                C4277a aVar = C4277a.this;
                                                long unused = aVar.f4108q = aVar.f4108q - ((long) bArr2.length);
                                                if (C4277a.this.f4105n.mo59089c()) {
                                                    C4277a.this.f4105n.mo59085b(2);
                                                    if (C4277a.this.f4105n.mo59090d(2) > 1) {
                                                        C4277a.this.f4105n.mo59082a(Math.max((System.currentTimeMillis() - C4277a.this.f4091D[0]) - j2, 0));
                                                    }
                                                }
                                                C4277a.this.f4091D[3] = System.currentTimeMillis();
                                            }
                                        };
                                        handler.post(r8);
                                    } else {
                                        i = i3;
                                    }
                                } else {
                                    i = i3;
                                    if (videoSink2 instanceof WOWZSinkAPI.MediaCodecVideoSink) {
                                        ((WOWZSinkAPI.MediaCodecVideoSink) videoSink2).onVideoFrame(j, byteBuffer, this.f4101j);
                                    }
                                }
                                i3 = i + 1;
                            }
                        }
                    }
                    if ((this.f4101j.flags & 4) == 0) {
                        synchronized (this.f4109r) {
                            if (this.f4111y[1] != this.f4111y[2]) {
                                m3809d();
                            }
                        }
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public void flushEncoder() {
        drainEncoder();
    }

    public void encodeInputSurfaceContents(long j) {
        if (this.f4095d != null) {
            this.f4095d.m3818a(Long.valueOf(j));
        }
    }

    public void onEncodeInputSurfaceContents(long j) {
        if (!this.f4102k.isRunning()) {
            WOWZLog.warn(f4084a, "Attempt to encode surface contents without the encoder actively running");
            return;
        }
        C4270a aVar = this.f4106o;
        if (aVar != null) {
            aVar.onWZVideoFrameRendererDraw(this.f4107p, this.f4103l.getVideoFrameSize(), this.f4103l.getVideoRotation());
        }
        if (!this.f4107p.setPresentationTime(j)) {
            WOWZLog.error(f4084a, "An error occurred setting the presentation time on the EGLSurface used for encoding");
        }
        if (!this.f4107p.swapBuffers()) {
            WOWZLog.error(f4084a, "An error occurred swapping the buffers on the EGLSurface used for encoding");
        }
        onFrameSubmittedToEncoder();
    }

    /* access modifiers changed from: protected */
    public WOWZStatus stopEncoding() {
        if (!this.f4102k.isRunning() && !this.f4102k.isPaused()) {
            String str = f4084a;
            WOWZLog.warn(str, "The " + f4084a + " was in a " + WOWZState.toLabel(this.f4102k.getState()) + " state at encoder stop (expected RUNNING or PAUSED)");
        }
        this.f4102k.setState(4);
        if (this.f4095d != null) {
            this.f4095d.removeMessages(3);
            this.f4095d.m3821c();
            this.f4102k.waitForState(0);
        } else {
            m3805b();
            this.f4102k.setState(0);
        }
        return this.f4102k;
    }

    /* access modifiers changed from: protected */
    public void onStopEncoding() {
        MediaCodec mediaCodec;
        if (this.f4102k.isRunning() && (mediaCodec = this.f4097f) != null) {
            mediaCodec.signalEndOfInputStream();
            onDrainEncoder();
        }
        m3805b();
        this.f4102k.setState(0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x000c A[LOOP:0: B:4:0x000c->B:15:0x000c, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shutdownEncoderThread() {
        /*
            r2 = this;
            com.wowza.gocoder.sdk.support.c.a$a r0 = r2.f4095d
            if (r0 == 0) goto L_0x001b
            com.wowza.gocoder.sdk.support.c.a$a r0 = r2.f4095d
            r0.m3823d()
            java.lang.Object r0 = r2.f4093b
            monitor-enter(r0)
        L_0x000c:
            boolean r1 = r2.f4094c     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0016
            java.lang.Object r1 = r2.f4093b     // Catch:{ InterruptedException -> 0x000c }
            r1.wait()     // Catch:{ InterruptedException -> 0x000c }
            goto L_0x000c
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p036c.C4277a.shutdownEncoderThread():void");
    }

    /* access modifiers changed from: protected */
    public void onShutdown() {
        Looper.myLooper().quitSafely();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|13|14|15) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3805b() {
        /*
            r2 = this;
            com.wowza.gocoder.sdk.support.a.b.a r0 = r2.f4106o
            if (r0 == 0) goto L_0x0009
            com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES$EglEnv r1 = r2.f4107p
            r0.onWZVideoFrameRendererRelease(r1)
        L_0x0009:
            r2.m3807c()
            android.view.Surface r0 = r2.f4099h
            r1 = 0
            if (r0 == 0) goto L_0x0016
            r0.release()     // Catch:{ Exception -> 0x0014 }
        L_0x0014:
            r2.f4099h = r1
        L_0x0016:
            android.media.MediaCodec r0 = r2.f4097f
            if (r0 == 0) goto L_0x0024
            r0.stop()     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            android.media.MediaCodec r0 = r2.f4097f     // Catch:{ Exception -> 0x0022 }
            r0.release()     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            r2.f4097f = r1
        L_0x0024:
            r2.f4101j = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p036c.C4277a.m3805b():void");
    }

    /* renamed from: c */
    private void m3807c() {
        WOWZGLES.EglEnv eglEnv = this.f4107p;
        if (eglEnv != null) {
            eglEnv.release();
            this.f4107p = null;
        }
    }

    public int getAdaptiveBitrate() {
        int i;
        synchronized (this.f4109r) {
            i = this.f4111y[2];
        }
        return i;
    }

    public void changeAdaptiveBitrate(int i) {
        if (this.f4103l.isABREnabled()) {
            synchronized (this.f4109r) {
                if (i > 0) {
                    if (i <= this.f4111y[0]) {
                        this.f4111y[1] = i;
                    }
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ABR: Invalid bitrate specified");
                WOWZLog.error(f4084a, (Throwable) illegalArgumentException);
                throw illegalArgumentException;
            }
        }
    }

    /* renamed from: d */
    private void m3809d() {
        int[] iArr = this.f4111y;
        if (iArr[1] != iArr[2]) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", this.f4111y[1] * 1000);
                this.f4097f.setParameters(bundle);
                this.f4111y[2] = this.f4111y[1];
                String str = f4084a;
                WOWZLog.debug(str, "ABR: Changed MediaCodec bitrate to " + this.f4111y[1] + " kbps");
            } catch (IllegalStateException e) {
                int[] iArr2 = this.f4111y;
                iArr2[1] = iArr2[2];
                WOWZLog.error(f4084a, (WOWZError) new WOWZPlatformError(67, (Exception) e));
            }
        }
    }

    public int getAdaptiveFramerate() {
        int i;
        synchronized (this.f4109r) {
            i = this.f4110u[1];
        }
        return i;
    }

    public void changeAdaptiveFramerate(int i) {
        if (this.f4103l.isABREnabled()) {
            synchronized (this.f4109r) {
                if (i > 0) {
                    if (i <= this.f4110u[0]) {
                        this.f4110u[1] = i;
                    }
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ABR: Invalid framerate specified");
                WOWZLog.error(f4084a, (Throwable) illegalArgumentException);
                throw illegalArgumentException;
            }
        }
    }

    /* renamed from: a */
    private void m3801a(int i) {
        WOWZLog.debug("****[FPS] resetFrameRates(" + i + ")");
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4110u;
            if (i2 < iArr.length) {
                iArr[i2] = i;
                i2++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m3806b(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4111y;
            if (i2 < iArr.length) {
                iArr[i2] = i;
                i2++;
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    private void m3810e() {
        int i = 0;
        while (true) {
            long[] jArr = this.f4091D;
            if (i < jArr.length) {
                jArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: com.wowza.gocoder.sdk.support.c.a$a */
    /* compiled from: GoCoderSDK */
    protected static class C4279a extends Handler {

        /* renamed from: a */
        private static final String f4116a = "H264EncoderHandler";

        /* renamed from: b */
        private static final int f4117b = 1;

        /* renamed from: c */
        private static final int f4118c = 2;

        /* renamed from: d */
        private static final int f4119d = 3;

        /* renamed from: e */
        private static final int f4120e = 4;

        /* renamed from: f */
        private static final int f4121f = 5;

        /* renamed from: g */
        private static final int f4122g = 6;

        /* renamed from: h */
        private static final int f4123h = 7;

        /* renamed from: i */
        private WeakReference<C4277a> f4124i;

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3813a(WOWZMediaConfig wOWZMediaConfig) {
            WOWZLog.debug("*****[FPS] sendPrepareEncoder : " + wOWZMediaConfig.getVideoFramerate());
            sendMessage(obtainMessage(1, wOWZMediaConfig));
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3811a() {
            sendMessage(obtainMessage(2));
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m3819b() {
            sendMessage(obtainMessage(3));
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m3821c() {
            sendMessage(obtainMessage(4));
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public void m3823d() {
            sendMessage(obtainMessage(5));
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3812a(EGLContext eGLContext) {
            sendMessage(obtainMessage(6, eGLContext));
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3818a(Long l) {
            sendMessage(obtainMessage(7, l));
        }

        C4279a(C4277a aVar) {
            this.f4124i = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C4277a aVar = (C4277a) this.f4124i.get();
            if (aVar == null) {
                WOWZLog.error(f4116a, "The reference to the H264Encoder instance is null");
                return;
            }
            switch (message.what) {
                case 1:
                    aVar.onPrepareEncoder((WOWZBroadcastConfig) message.obj);
                    return;
                case 2:
                    aVar.onStartEncoding();
                    return;
                case 3:
                    aVar.onDrainEncoder();
                    return;
                case 4:
                    aVar.onStopEncoding();
                    return;
                case 5:
                    aVar.onShutdown();
                    return;
                case 6:
                    aVar.m3802a((EGLContext) message.obj);
                    return;
                case 7:
                    aVar.onEncodeInputSurfaceContents(((Long) message.obj).longValue());
                    return;
                default:
                    return;
            }
        }
    }
}
