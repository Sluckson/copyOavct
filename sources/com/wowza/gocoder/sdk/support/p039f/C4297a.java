package com.wowza.gocoder.sdk.support.p039f;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.core.view.ViewCompat;
import com.wowza.gocoder.sdk.api.android.WOWZAndroid;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.geometry.WOWZCropDimensions;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.gles.Drawable2d;
import com.wowza.gocoder.sdk.api.gles.EglCore;
import com.wowza.gocoder.sdk.api.gles.FullFrameRect;
import com.wowza.gocoder.sdk.api.gles.Sprite2d;
import com.wowza.gocoder.sdk.api.gles.Texture2dProgram;
import com.wowza.gocoder.sdk.api.gles.WindowSurface;
import com.wowza.gocoder.sdk.api.graphics.WOWZColor;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.render.WOWZRenderAPI;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.support.licensing.LicenseManager;
import com.wowza.gocoder.sdk.support.p029a.p033b.C4270a;
import java.lang.ref.WeakReference;

/* renamed from: com.wowza.gocoder.sdk.support.f.a */
/* compiled from: GoCoderSDK */
public class C4297a implements SurfaceTexture.OnFrameAvailableListener, WOWZRenderAPI.VideoFrameRenderer {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4313a = "a";

    /* renamed from: A */
    private boolean f4314A;

    /* renamed from: B */
    private WOWZColor f4315B;

    /* renamed from: C */
    private boolean f4316C;

    /* renamed from: D */
    private C4270a f4317D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public WOWZStatus f4318E = new WOWZStatus(0);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile C4299a f4319b = null;

    /* renamed from: c */
    private final Object f4320c = new Object();

    /* renamed from: d */
    private final Object f4321d = new Object();

    /* renamed from: e */
    private boolean f4322e = false;

    /* renamed from: f */
    private Surface f4323f;

    /* renamed from: g */
    private EglCore f4324g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public FullFrameRect f4325h;

    /* renamed from: i */
    private WindowSurface f4326i;

    /* renamed from: j */
    private SurfaceTexture f4327j;

    /* renamed from: k */
    private float[] f4328k = new float[16];

    /* renamed from: l */
    private int f4329l;

    /* renamed from: m */
    private Texture2dProgram.ProgramType f4330m = Texture2dProgram.ProgramType.TEXTURE_EXT;

    /* renamed from: n */
    private WOWZGLES.EglEnv f4331n;

    /* renamed from: o */
    private WOWZRenderAPI.VideoRendererConfig f4332o = new WOWZRenderAPI.VideoRendererConfig();

    /* renamed from: p */
    private WOWZRenderAPI.VideoFrameRenderer[] f4333p = new WOWZRenderAPI.VideoFrameRenderer[0];

    /* renamed from: q */
    private WOWZRenderAPI.VideoFrameListener[] f4334q = new WOWZRenderAPI.VideoFrameListener[0];

    /* renamed from: r */
    private Sprite2d f4335r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Texture2dProgram f4336s;

    /* renamed from: t */
    private WOWZSize f4337t;

    /* renamed from: u */
    private WOWZSize f4338u;

    /* renamed from: v */
    private WOWZSize f4339v;

    /* renamed from: w */
    private WOWZSize f4340w;

    /* renamed from: x */
    private WOWZCropDimensions f4341x;

    /* renamed from: y */
    private int f4342y;

    /* renamed from: z */
    private int f4343z;

    public boolean isWZVideoFrameRendererActive() {
        return true;
    }

    public void onWZVideoFrameRendererInit(WOWZGLES.EglEnv eglEnv) {
    }

    public void onWZVideoFrameRendererRelease(WOWZGLES.EglEnv eglEnv) {
    }

    public C4297a() {
        C4270a aVar = null;
        Matrix.setIdentityM(this.f4328k, 0);
        this.f4337t = new WOWZSize();
        this.f4339v = new WOWZSize();
        this.f4338u = new WOWZSize();
        this.f4340w = new WOWZSize();
        this.f4323f = null;
        this.f4331n = null;
        this.f4324g = null;
        this.f4325h = null;
        this.f4326i = null;
        this.f4327j = null;
        this.f4329l = -1;
        this.f4342y = -1;
        this.f4343z = -1;
        this.f4314A = true;
        this.f4341x = null;
        this.f4335r = null;
        this.f4336s = null;
        this.f4315B = WOWZAndroid.ColorToWZColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4316C = false;
        this.f4317D = LicenseManager.getInstance().isEvaluation() ? new C4270a() : aVar;
    }

    /* renamed from: a */
    public WOWZStatus mo59203a() {
        WOWZStatus wOWZStatus;
        synchronized (this.f4320c) {
            wOWZStatus = this.f4318E;
        }
        return wOWZStatus;
    }

    /* renamed from: b */
    public boolean mo59212b() {
        return this.f4318E.isRunning();
    }

    /* renamed from: c */
    public SurfaceTexture mo59213c() {
        SurfaceTexture surfaceTexture;
        synchronized (this.f4320c) {
            surfaceTexture = this.f4327j;
        }
        return surfaceTexture;
    }

    /* renamed from: d */
    public WOWZGLES.EglEnv mo59214d() {
        WOWZGLES.EglEnv eglEnv;
        synchronized (this.f4320c) {
            eglEnv = this.f4331n;
        }
        return eglEnv;
    }

    /* renamed from: e */
    public WOWZSize mo59215e() {
        WOWZSize eglViewportSize;
        synchronized (this.f4320c) {
            eglViewportSize = this.f4332o != null ? this.f4332o.getEglViewportSize() : null;
        }
        return eglViewportSize;
    }

    /* renamed from: a */
    public void mo59207a(WOWZRenderAPI.VideoViewConfig videoViewConfig) {
        if (this.f4319b != null) {
            this.f4319b.mo59227a(videoViewConfig);
        } else {
            m4165b(videoViewConfig);
        }
    }

    /* renamed from: f */
    public WOWZRenderAPI.VideoViewConfig mo59216f() {
        WOWZRenderAPI.VideoRendererConfig videoRendererConfig;
        synchronized (this.f4320c) {
            videoRendererConfig = this.f4332o;
        }
        return videoRendererConfig;
    }

    /* renamed from: a */
    public void mo59205a(Surface surface) {
        if (this.f4319b != null) {
            this.f4319b.mo59224a(surface);
        } else {
            m4163b(surface);
        }
    }

    /* renamed from: a */
    public void mo59210a(WOWZRenderAPI.VideoFrameRenderer[] videoFrameRendererArr) {
        if (this.f4319b != null) {
            this.f4319b.mo59230a(videoFrameRendererArr);
        } else {
            m4169b(videoFrameRendererArr);
        }
    }

    /* renamed from: a */
    public void mo59209a(WOWZRenderAPI.VideoFrameListener[] videoFrameListenerArr) {
        if (this.f4319b != null) {
            this.f4319b.mo59229a(videoFrameListenerArr);
        } else {
            m4168b(videoFrameListenerArr);
        }
    }

    /* renamed from: a */
    public void mo59206a(WOWZColor wOWZColor) {
        if (this.f4319b != null) {
            this.f4319b.mo59226a(wOWZColor);
        } else {
            m4164b(wOWZColor);
        }
    }

    /* renamed from: g */
    public boolean mo59217g() {
        return this.f4316C;
    }

    /* renamed from: a */
    public void mo59208a(boolean z) {
        if (this.f4319b != null) {
            this.f4319b.mo59228a(z);
        } else {
            m4167b(z);
        }
    }

    /* renamed from: a */
    public WOWZStatus mo59204a(final Texture2dProgram.ProgramType programType) {
        this.f4318E.clearLastError();
        this.f4318E.setState(1);
        WOWZLog.debug(f4313a, "startRenderer - STARTING");
        new Thread(new Runnable() {
            public void run() {
                WOWZError a = C4297a.this.m4170c(programType);
                if (a != null) {
                    WOWZLog.error(C4297a.f4313a, a);
                    C4297a.this.f4318E.setError(a);
                } else {
                    Looper.prepare();
                    C4297a aVar = C4297a.this;
                    C4299a unused = aVar.f4319b = new C4299a(aVar);
                    C4297a.this.f4318E.setState(3);
                    Looper.loop();
                }
                C4297a.this.m4177l();
                C4299a unused2 = C4297a.this.f4319b = null;
                C4297a.this.f4318E.setState(0);
            }
        }, f4313a).start();
        this.f4318E.waitForState(3);
        return this.f4318E;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public WOWZError m4170c(Texture2dProgram.ProgramType programType) {
        if (this.f4323f == null) {
            return new WOWZError("An attempt was made to start the video renderer before the rendering surface has been set");
        }
        try {
            this.f4330m = programType;
            this.f4324g = new EglCore((EGLContext) null, 1);
            this.f4326i = new WindowSurface(this.f4324g, this.f4323f, false);
            this.f4326i.makeCurrent();
            this.f4325h = new FullFrameRect(new Texture2dProgram(programType));
            this.f4336s = this.f4325h.getProgram();
            this.f4329l = this.f4336s.createTextureObject();
            this.f4335r = new Sprite2d(new Drawable2d(Drawable2d.Prefab.RECTANGLE));
            this.f4335r.setTexture(this.f4329l);
            this.f4327j = new SurfaceTexture(this.f4329l);
            this.f4331n = new WOWZGLES.EglEnv(EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentContext(), EGL14.eglGetCurrentSurface(12377));
            for (WOWZRenderAPI.VideoFrameRenderer onWZVideoFrameRendererInit : this.f4333p) {
                onWZVideoFrameRendererInit.onWZVideoFrameRendererInit(this.f4331n);
            }
            if (this.f4317D != null) {
                this.f4317D.onWZVideoFrameRendererInit(this.f4331n);
            }
            for (WOWZRenderAPI.VideoFrameListener onWZVideoFrameListenerInit : this.f4334q) {
                onWZVideoFrameListenerInit.onWZVideoFrameListenerInit(this.f4331n);
            }
            this.f4314A = true;
            this.f4327j.setOnFrameAvailableListener(this);
            return null;
        } catch (Exception e) {
            WOWZError wOWZError = new WOWZError(f4313a, e);
            WOWZLog.error(f4313a, (Throwable) e);
            return wOWZError;
        }
    }

    /* renamed from: h */
    public void mo59218h() {
        if (this.f4318E.isRunning()) {
            this.f4319b.mo59232c();
            this.f4318E.waitForState(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m4177l() {
        for (WOWZRenderAPI.VideoFrameRenderer onWZVideoFrameRendererRelease : this.f4333p) {
            onWZVideoFrameRendererRelease.onWZVideoFrameRendererRelease(this.f4331n);
        }
        C4270a aVar = this.f4317D;
        if (aVar != null) {
            aVar.onWZVideoFrameRendererRelease(this.f4331n);
            this.f4317D = null;
        }
        for (WOWZRenderAPI.VideoFrameListener onWZVideoFrameListenerRelease : this.f4334q) {
            onWZVideoFrameListenerRelease.onWZVideoFrameListenerRelease(this.f4331n);
        }
        WindowSurface windowSurface = this.f4326i;
        if (windowSurface != null) {
            windowSurface.release();
            this.f4326i = null;
        }
        FullFrameRect fullFrameRect = this.f4325h;
        if (fullFrameRect != null) {
            fullFrameRect.release(true);
            this.f4325h = null;
        }
        SurfaceTexture surfaceTexture = this.f4327j;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f4327j = null;
        }
        EglCore eglCore = this.f4324g;
        if (eglCore != null) {
            eglCore.makeNothingCurrent();
            this.f4324g.release();
            this.f4324g = null;
        }
        this.f4329l = -1;
        this.f4331n = null;
        this.f4322e = false;
    }

    /* renamed from: i */
    public void mo59219i() {
        if (this.f4319b != null) {
            this.f4319b.mo59231b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m4165b(WOWZRenderAPI.VideoViewConfig videoViewConfig) {
        synchronized (this.f4320c) {
            this.f4332o.set(videoViewConfig);
        }
        if (this.f4318E.isRunning()) {
            this.f4314A = true;
            m4178m();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4163b(Surface surface) {
        synchronized (this.f4320c) {
            this.f4323f = surface;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4168b(WOWZRenderAPI.VideoFrameListener[] videoFrameListenerArr) {
        synchronized (this.f4320c) {
            this.f4334q = videoFrameListenerArr;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4164b(WOWZColor wOWZColor) {
        synchronized (this.f4320c) {
            this.f4315B.set(wOWZColor);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4169b(WOWZRenderAPI.VideoFrameRenderer[] videoFrameRendererArr) {
        synchronized (this.f4320c) {
            this.f4333p = videoFrameRendererArr;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4167b(boolean z) {
        synchronized (this.f4320c) {
            this.f4316C = z;
        }
    }

    /* renamed from: m */
    private void m4178m() {
        m4182q();
        WOWZRenderAPI.VideoRendererConfig videoRendererConfig = this.f4332o;
        videoRendererConfig.setEglSurfaceRotation(WOWZGLES.surfaceToEGLRotation(videoRendererConfig.getSurfaceRotation()));
        boolean z = this.f4332o.getEglSurfaceRotation() == 90 || this.f4332o.getEglSurfaceRotation() == 270;
        this.f4332o.getCropDimensions().setScaleMode(this.f4332o.getScaleMode());
        this.f4332o.getCropDimensions().setSrcSize(z ? this.f4332o.getActiveFrameSize().asPortrait() : this.f4332o.getActiveFrameSize().asLandscape());
        this.f4332o.getCropDimensions().setDestSize(this.f4332o.getSurfaceSize());
        this.f4332o.getEglViewportSize().set(this.f4332o.getSurfaceSize());
        if (this.f4332o.getScaleMode() == 2) {
            double aspectRatio = (double) this.f4332o.getCropDimensions().getSrcSize().aspectRatio();
            double aspectRatio2 = (double) this.f4332o.getCropDimensions().getDestSize().aspectRatio();
            double abs = Math.abs(aspectRatio2 - aspectRatio);
            if (aspectRatio2 != aspectRatio && abs > 0.01d) {
                this.f4332o.getEglViewportSize().set(this.f4332o.getCropDimensions().getScaledSize());
            }
        }
        m4183r();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m4179n() {
        if (this.f4326i != null) {
            m4182q();
            GLES20.glViewport(0, 0, this.f4332o.getSurfaceSize().width, this.f4332o.getSurfaceSize().height);
            GLES20.glClearColor(this.f4315B.red, this.f4315B.green, this.f4315B.blue, this.f4315B.alpha);
            GLES20.glClear(16384);
            this.f4326i.swapBuffers();
            m4183r();
        }
    }

    /* renamed from: b */
    public void mo59211b(Texture2dProgram.ProgramType programType) {
        if (this.f4330m != programType) {
            this.f4330m = programType;
            m4182q();
            try {
                WOWZLog.debug(f4313a, "Restarting renderer to ensure new programtype takes place.");
                this.f4319b.mo59225a(programType);
            } catch (Exception e) {
                WOWZLog.error(f4313a, (Throwable) e);
            }
            m4183r();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m4180o() {
        Looper.myLooper().quitSafely();
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.f4318E.isRunning()) {
            mo59220j();
        }
    }

    /* renamed from: j */
    public void mo59220j() {
        this.f4319b.mo59223a();
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m4181p() {
        m4182q();
        this.f4327j.getTransformMatrix(this.f4328k);
        this.f4327j.updateTexImage();
        GLES20.glViewport(0, 0, this.f4332o.getSurfaceSize().width, this.f4332o.getSurfaceSize().height);
        if (this.f4316C) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        } else {
            GLES20.glClearColor(this.f4315B.red, this.f4315B.green, this.f4315B.blue, this.f4315B.alpha);
        }
        GLES20.glClear(16384);
        if (!this.f4316C) {
            this.f4325h.drawFrame(this.f4329l, this.f4328k);
            for (WOWZRenderAPI.VideoFrameRenderer videoFrameRenderer : this.f4333p) {
                if (videoFrameRenderer.isWZVideoFrameRendererActive()) {
                    videoFrameRenderer.onWZVideoFrameRendererDraw(this.f4331n, this.f4332o.getSurfaceSize(), this.f4332o.getSurfaceRotation());
                }
            }
        }
        C4270a aVar = this.f4317D;
        if (aVar != null) {
            aVar.onWZVideoFrameRendererDraw(this.f4331n, this.f4332o.getSurfaceSize(), this.f4332o.getSurfaceRotation());
        }
        for (WOWZRenderAPI.VideoFrameListener videoFrameListener : this.f4334q) {
            if (videoFrameListener.isWZVideoFrameListenerActive()) {
                videoFrameListener.onWZVideoFrameListenerFrameAvailable(this.f4331n, this.f4332o.getSurfaceSize(), this.f4332o.getSurfaceRotation(), this.f4327j.getTimestamp());
            }
        }
        this.f4326i.swapBuffers();
        m4183r();
    }

    public synchronized void onWZVideoFrameRendererDraw(WOWZGLES.EglEnv eglEnv, WOWZSize wOWZSize, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        boolean z2;
        m4182q();
        int surfaceRotation = this.f4332o.getSurfaceRotation();
        this.f4337t.set(this.f4332o.getActiveFrameSize());
        this.f4338u.set(wOWZSize);
        if (WOWZMediaConfig.isPortraitRotation(surfaceRotation)) {
            this.f4337t.invert();
        }
        boolean z3 = true;
        if (!this.f4314A) {
            if (this.f4339v.equals(this.f4337t) && this.f4340w.equals(this.f4338u) && this.f4342y == surfaceRotation) {
                if (this.f4343z == i) {
                    z2 = false;
                    this.f4314A = z2;
                }
            }
            z2 = true;
            this.f4314A = z2;
        }
        this.f4339v.set(this.f4337t);
        this.f4340w.set(this.f4338u);
        this.f4342y = surfaceRotation;
        this.f4343z = i;
        int rotationToOrientation = WOWZMediaConfig.rotationToOrientation(i);
        boolean z4 = (WOWZMediaConfig.isPortraitRotation(surfaceRotation) && WOWZMediaConfig.isPortraitRotation(i)) || (WOWZMediaConfig.isLandscapeRotation(surfaceRotation) && WOWZMediaConfig.isLandscapeRotation(i));
        int i8 = this.f4338u.width;
        int i9 = this.f4338u.height;
        if (this.f4337t.equals(this.f4338u)) {
            i2 = i9;
            z = false;
            i5 = 0;
            z3 = false;
            i3 = i8;
            i4 = 0;
        } else if (z4) {
            if (this.f4314A) {
                if (this.f4341x == null) {
                    this.f4341x = new WOWZCropDimensions(this.f4337t, this.f4338u);
                } else {
                    this.f4341x.setSrcSize(this.f4337t);
                    this.f4341x.setDestSize(this.f4338u);
                }
            }
            int i10 = this.f4341x.getOffset().f3734x;
            int i11 = this.f4341x.getOffset().f3735y;
            int i12 = this.f4341x.getScaledSize().width;
            i2 = this.f4341x.getScaledSize().height;
            i3 = i12;
            i4 = i11;
            i5 = i10;
            z = false;
        } else {
            if (WOWZMediaConfig.isLandscape(rotationToOrientation)) {
                float f = ((float) this.f4338u.height) * (((float) this.f4338u.height) / ((float) this.f4338u.width));
                i7 = Math.round((((float) this.f4338u.width) - f) / 2.0f);
                i8 = (int) f;
                i6 = 0;
            } else {
                float f2 = ((float) this.f4338u.width) * (((float) this.f4338u.width) / ((float) this.f4338u.height));
                i9 = (int) f2;
                i6 = Math.round((((float) this.f4338u.height) - f2) / 2.0f);
                i7 = 0;
            }
            i2 = i9;
            i3 = i8;
            i4 = i6;
            i5 = i7;
            z = true;
        }
        if (z) {
            GLES20.glScissor(0, 0, this.f4338u.width, this.f4338u.height);
            GLES20.glEnable(3089);
            if (this.f4316C) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            } else {
                GLES20.glClearColor(this.f4315B.red, this.f4315B.green, this.f4315B.blue, this.f4315B.alpha);
            }
            GLES20.glClear(16384);
        }
        GLES20.glViewport(i5, i4, i3, i2);
        if (!this.f4316C) {
            this.f4325h.drawFrame(this.f4329l, this.f4328k);
        }
        if (z) {
            GLES20.glDisable(3089);
        }
        if (z3) {
            GLES20.glViewport(0, 0, this.f4338u.width, this.f4338u.height);
        }
        if (!this.f4316C) {
            for (WOWZRenderAPI.VideoFrameRenderer videoFrameRenderer : this.f4333p) {
                if (videoFrameRenderer.isWZVideoFrameRendererActive()) {
                    videoFrameRenderer.onWZVideoFrameRendererDraw(eglEnv, wOWZSize, i);
                }
            }
        }
        m4183r();
    }

    /* renamed from: q */
    private boolean m4182q() {
        synchronized (this.f4321d) {
            while (this.f4322e) {
                try {
                    this.f4321d.wait();
                } catch (InterruptedException unused) {
                    return false;
                }
            }
            this.f4322e = true;
        }
        return true;
    }

    /* renamed from: r */
    private void m4183r() {
        synchronized (this.f4321d) {
            this.f4322e = false;
            this.f4321d.notifyAll();
        }
    }

    /* renamed from: com.wowza.gocoder.sdk.support.f.a$a */
    /* compiled from: GoCoderSDK */
    private static class C4299a extends Handler {

        /* renamed from: a */
        private static final String f4346a = "a";

        /* renamed from: b */
        private static final int f4347b = 1;

        /* renamed from: c */
        private static final int f4348c = 2;

        /* renamed from: d */
        private static final int f4349d = 3;

        /* renamed from: e */
        private static final int f4350e = 4;

        /* renamed from: f */
        private static final int f4351f = 5;

        /* renamed from: g */
        private static final int f4352g = 6;

        /* renamed from: h */
        private static final int f4353h = 7;

        /* renamed from: i */
        private static final int f4354i = 9;

        /* renamed from: j */
        private static final int f4355j = 8;

        /* renamed from: k */
        private static final int f4356k = 10;

        /* renamed from: l */
        private WeakReference<C4297a> f4357l;

        C4299a(C4297a aVar) {
            this.f4357l = new WeakReference<>(aVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo59224a(Surface surface) {
            sendMessage(obtainMessage(1, surface));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo59223a() {
            sendMessage(obtainMessage(3));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo59231b() {
            sendMessage(obtainMessage(2));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo59227a(WOWZRenderAPI.VideoViewConfig videoViewConfig) {
            sendMessage(obtainMessage(4, videoViewConfig));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo59229a(WOWZRenderAPI.VideoFrameListener[] videoFrameListenerArr) {
            sendMessage(obtainMessage(6, videoFrameListenerArr));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo59230a(WOWZRenderAPI.VideoFrameRenderer[] videoFrameRendererArr) {
            sendMessage(obtainMessage(5, videoFrameRendererArr));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo59226a(WOWZColor wOWZColor) {
            sendMessage(obtainMessage(8, wOWZColor));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo59228a(boolean z) {
            sendMessage(obtainMessage(10, z ? 1 : 0, 0));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo59232c() {
            sendMessage(obtainMessage(7));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo59225a(Texture2dProgram.ProgramType programType) {
            sendMessage(obtainMessage(9, programType));
        }

        public void handleMessage(Message message) {
            C4297a aVar = (C4297a) this.f4357l.get();
            if (aVar == null) {
                WOWZLog.error(f4346a, "The reference to the VideoViewRenderer instance is null");
                return;
            }
            switch (message.what) {
                case 1:
                    aVar.m4163b((Surface) message.obj);
                    return;
                case 2:
                    aVar.m4179n();
                    return;
                case 3:
                    aVar.m4181p();
                    return;
                case 4:
                    aVar.m4165b((WOWZRenderAPI.VideoViewConfig) message.obj);
                    return;
                case 5:
                    aVar.m4169b((WOWZRenderAPI.VideoFrameRenderer[]) message.obj);
                    return;
                case 6:
                    aVar.m4168b((WOWZRenderAPI.VideoFrameListener[]) message.obj);
                    return;
                case 7:
                    aVar.m4180o();
                    return;
                case 8:
                    aVar.m4164b((WOWZColor) message.obj);
                    return;
                case 9:
                    Texture2dProgram unused = aVar.f4336s = new Texture2dProgram((Texture2dProgram.ProgramType) message.obj);
                    aVar.f4325h.changeProgram(aVar.f4336s);
                    return;
                case 10:
                    boolean z = true;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    aVar.m4167b(z);
                    return;
                default:
                    return;
            }
        }
    }
}
