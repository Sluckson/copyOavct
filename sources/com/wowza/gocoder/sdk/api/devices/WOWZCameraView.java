package com.wowza.gocoder.sdk.api.devices;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.wowza.gocoder.sdk.android.C4216R;
import com.wowza.gocoder.sdk.api.WowzaGoCoder;
import com.wowza.gocoder.sdk.api.android.graphics.WOWZTextManager;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.gles.Texture2dProgram;
import com.wowza.gocoder.sdk.api.graphics.WOWZColor;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.render.WOWZRenderAPI;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.support.p035b.C4275c;
import com.wowza.gocoder.sdk.support.p039f.C4297a;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: GoCoderSDK */
public class WOWZCameraView extends SurfaceView implements ComponentCallbacks, SurfaceHolder.Callback, WOWZBroadcastAPI.AdaptiveBroadcaster, WOWZBroadcastAPI.VideoBroadcaster {
    protected static final int DEFAULT_CAMERA_DIRECTION = 0;
    protected static final WOWZSize DEFAULT_FRAME_SIZE = new WOWZSize(WOWZMediaConfig.DEFAULT_VIDEO_FRAME_WIDTH, WOWZMediaConfig.DEFAULT_VIDEO_FRAME_HEIGHT);
    protected static final int DEFAULT_SCALE_MODE = 2;
    public static final int EXTENSION_BLACK_AND_WHITE = 2;
    public static final int EXTENSION_DEFAULT = 0;
    public static final int EXTENSION_MIRROR = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f3709a = "WOWZCameraView";

    /* renamed from: b */
    private final Object f3710b = new Object();

    /* renamed from: c */
    private C4297a f3711c;

    /* renamed from: d */
    private ArrayList<WOWZRenderAPI.VideoFrameRenderer> f3712d;

    /* renamed from: e */
    private ArrayList<WOWZRenderAPI.VideoFrameListener> f3713e;

    /* renamed from: f */
    private boolean f3714f;

    /* renamed from: g */
    private WOWZRenderAPI.VideoViewConfig f3715g;

    /* renamed from: h */
    private WOWZMediaConfig f3716h;

    /* renamed from: i */
    private WOWZColor f3717i;

    /* renamed from: j */
    private Texture2dProgram.ProgramType f3718j;

    /* renamed from: k */
    private OrientationEventListener f3719k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f3720l;

    /* renamed from: m */
    private PreviewStatusListener f3721m = null;
    protected WOWZCamera mActiveCamera;
    protected WOWZCamera[] mCameras;
    protected Context mContext;
    protected int mDefaultCameraDirection;
    protected WOWZStatus mPreviewStatus;
    protected C4275c mSurfaceBroadcaster;

    /* renamed from: n */
    private PreviewStatusListener f3722n = null;

    /* compiled from: GoCoderSDK */
    public interface PreviewStatusListener {
        void onWZCameraPreviewError(WOWZCamera wOWZCamera, WOWZError wOWZError);

        void onWZCameraPreviewStarted(WOWZCamera wOWZCamera, WOWZSize wOWZSize, int i);

        void onWZCameraPreviewStopped(int i);
    }

    public WOWZBroadcastAPI.VideoBroadcaster getBroadcaster() {
        return this;
    }

    public static int getNumberOfDeviceCameras(Context context) {
        return WOWZCamera.getNumberOfDeviceCameras(context);
    }

    public static WOWZCamera[] getDeviceCameras(Context context) {
        return WOWZCamera.getDeviceCameras(context);
    }

    public static WOWZCamera[] getAvailableDeviceCameras(Context context) {
        return WOWZCamera.getAvailableDeviceCameras(context);
    }

    public static String getCameraInfo(Context context) {
        return WOWZCamera.getCameraInfo(context);
    }

    public int getDeviceOrientation() {
        return WOWZDeviceUtils.getDeviceOrientation(this.mContext);
    }

    public void setPreviewStatusListener(PreviewStatusListener previewStatusListener) {
        synchronized (this) {
            this.f3722n = previewStatusListener;
        }
    }

    public void setPreviewReadyListener(PreviewStatusListener previewStatusListener) {
        setPreviewStatusListener(previewStatusListener);
    }

    /* JADX INFO: finally extract failed */
    public WOWZCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WOWZSize wOWZSize = DEFAULT_FRAME_SIZE;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4216R.styleable.WOWZCameraView, 0, 0);
        try {
            int i = obtainStyledAttributes.getInt(C4216R.styleable.WOWZCameraView_defaultCamera, 0);
            if (!(i == 0 || i == 1)) {
                i = 0;
            }
            int i2 = obtainStyledAttributes.getInt(C4216R.styleable.WOWZCameraView_frameSizePreset, 3);
            if (i2 >= 0 && i2 < WOWZMediaConfig.PRESET_CONFIGS.length) {
                wOWZSize = WOWZMediaConfig.PRESET_CONFIGS[i2].getVideoFrameSize();
            }
            int i3 = obtainStyledAttributes.getInt(C4216R.styleable.WOWZCameraView_scaleMode, 2);
            if (!(i3 == 1 || i3 == 2)) {
                i3 = 2;
            }
            obtainStyledAttributes.recycle();
            m3608a(context, i, wOWZSize, i3);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public WOWZCameraView(Context context) {
        super(context);
        this.mContext = context;
        m3608a(context, 0, DEFAULT_FRAME_SIZE, 2);
    }

    /* renamed from: a */
    private void m3608a(Context context, int i, WOWZSize wOWZSize, int i2) {
        this.mContext = context;
        this.mPreviewStatus = new WOWZStatus(0);
        this.f3718j = Texture2dProgram.ProgramType.TEXTURE_EXT;
        this.f3715g = new WOWZRenderAPI.VideoViewConfig(this.mContext);
        this.f3714f = true;
        this.f3715g.setScaleMode(i2);
        this.f3715g.setViewSize(new WOWZSize(getWidth(), getHeight()));
        this.f3715g.setSurfaceSize(new WOWZSize(getWidth(), getHeight()));
        this.f3715g.setClientFrameSize(new WOWZSize(wOWZSize));
        this.f3715g.setActiveFrameSize(new WOWZSize(wOWZSize));
        this.f3716h = new WOWZMediaConfig();
        this.f3716h.setVideoFrameSize(wOWZSize);
        this.f3716h.setVideoRotation(WOWZDeviceUtils.getDeviceRotation(this.mContext));
        this.mActiveCamera = null;
        this.mCameras = new WOWZCamera[0];
        this.mDefaultCameraDirection = i;
        this.f3711c = new C4297a();
        this.mSurfaceBroadcaster = new C4275c();
        this.mSurfaceBroadcaster.mo59046a((WOWZRenderAPI.VideoFrameRenderer) this.f3711c);
        this.f3712d = new ArrayList<>();
        this.f3713e = new ArrayList<>();
        this.f3717i = new WOWZColor(WOWZColor.BLACK);
        this.f3720l = 0;
        registerFrameRenderer(WOWZTextManager.getInstance());
        registerFrameListener(this.mSurfaceBroadcaster);
        getHolder().addCallback(this);
    }

    public WOWZStatus getPreviewStatus() {
        return new WOWZStatus(this.mPreviewStatus);
    }

    public WOWZStatus getStatus() {
        return getPreviewStatus();
    }

    public synchronized boolean isPreviewing() {
        return this.mPreviewStatus.isRunning();
    }

    public synchronized boolean isPreviewReady() {
        return isPreviewing() && this.mActiveCamera != null && this.mActiveCamera.isPreviewing();
    }

    public synchronized boolean isPreviewPaused() {
        return this.mPreviewStatus.isPaused();
    }

    public synchronized boolean isPaused() {
        return isPreviewPaused();
    }

    public WOWZColor getVideoBackgroundColor() {
        return this.f3717i;
    }

    public void setVideoBackgroundColor(WOWZColor wOWZColor) {
        this.f3717i.set(wOWZColor);
        C4297a aVar = this.f3711c;
        if (aVar != null) {
            aVar.mo59206a(this.f3717i);
        }
    }

    public WOWZMediaConfig getVideoSourceConfig() {
        int deviceRotation = WOWZDeviceUtils.getDeviceRotation(this.mContext);
        WOWZSize asPortrait = WOWZMediaConfig.isPortraitRotation(deviceRotation) ? this.f3715g.getActiveFrameSize().asPortrait() : this.f3715g.getActiveFrameSize().asLandscape();
        this.f3716h.setVideoRotation(deviceRotation);
        this.f3716h.setVideoFramerate(this.f3715g.getFramerate());
        this.f3716h.setVideoFrameSize(asPortrait);
        return this.f3716h;
    }

    public void setVideoEnabled(boolean z) {
        if (z != isVideoEnabled()) {
            C4275c cVar = this.mSurfaceBroadcaster;
            if (cVar != null) {
                cVar.setVideoEnabled(z);
            }
            if (z == isPreviewing()) {
                return;
            }
            if (z) {
                startPreview();
            } else {
                stopPreview();
            }
        }
    }

    public boolean isVideoEnabled() {
        return this.mSurfaceBroadcaster.isVideoEnabled();
    }

    public void setVideoPaused(boolean z) {
        this.f3711c.mo59208a(z);
    }

    public boolean isVideoPaused() {
        return this.f3711c.mo59217g();
    }

    public WOWZBroadcastConfig getBroadcastConfig() {
        C4275c cVar = this.mSurfaceBroadcaster;
        if (cVar != null) {
            return cVar.getBroadcastConfig();
        }
        return null;
    }

    public WOWZStatus getBroadcasterStatus() {
        C4275c cVar = this.mSurfaceBroadcaster;
        if (cVar != null) {
            return cVar.getBroadcasterStatus();
        }
        return null;
    }

    public WOWZStatus prepareForBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig) {
        C4275c cVar = this.mSurfaceBroadcaster;
        if (cVar != null) {
            return cVar.prepareForBroadcast(wOWZBroadcastConfig);
        }
        return null;
    }

    public WOWZStatus startBroadcasting() {
        C4275c cVar = this.mSurfaceBroadcaster;
        if (cVar != null) {
            return cVar.startBroadcasting();
        }
        return null;
    }

    public WOWZStatus stopBroadcasting() {
        C4275c cVar = this.mSurfaceBroadcaster;
        if (cVar != null) {
            cVar.stopBroadcasting();
        }
        if (isVideoPaused()) {
            this.mSurfaceBroadcaster.setVideoPaused(false);
            C4297a aVar = this.f3711c;
            if (aVar != null) {
                aVar.mo59208a(false);
            }
            startPreview();
        }
        return getBroadcasterStatus();
    }

    public void changeAdaptiveBitrate(int i) {
        this.mSurfaceBroadcaster.changeAdaptiveBitrate(i);
    }

    public int getAdaptiveBitrate() {
        return this.mSurfaceBroadcaster.getAdaptiveBitrate();
    }

    public void changeAdaptiveFramerate(int i) {
        this.mSurfaceBroadcaster.changeAdaptiveFramerate(i);
    }

    public int getAdaptiveFramerate() {
        return this.mSurfaceBroadcaster.getAdaptiveFramerate();
    }

    public synchronized WOWZCamera startPreview(WOWZMediaConfig wOWZMediaConfig, PreviewStatusListener previewStatusListener) {
        if (!WowzaGoCoder.isInitialized()) {
            this.mPreviewStatus.setError(new WOWZPlatformError(49));
            WOWZLog.error(f3709a, this.mPreviewStatus.getLastError());
            return null;
        } else if (this.f3711c.mo59203a().getLastError() != null) {
            WOWZLog.debug(f3709a, "WOWZPREVIEW: !mVideoViewRenderer.getRendererStatus()");
            WOWZLog.error(f3709a, "WOWZPREVIEW: The camera preview display cannot be started because an error occurred starting the renderer.");
            return null;
        } else {
            this.f3711c.mo59208a(false);
            this.mPreviewStatus.clearLastError();
            this.f3721m = previewStatusListener;
            if (wOWZMediaConfig != null) {
                setCameraConfig(wOWZMediaConfig);
            }
            if (this.mPreviewStatus.isRunning()) {
                return this.mActiveCamera;
            }
            this.mPreviewStatus.setState(1);
            if (this.f3719k != null && (this.f3719k instanceof OrientationEventListener)) {
                this.f3719k.disable();
                this.f3719k = null;
            }
            this.f3719k = new OrientationEventListener(this.mContext, 3) {
                public void onOrientationChanged(int i) {
                    try {
                        Display display = WOWZCameraView.this.getDisplay();
                        if (display != null) {
                            int rotation = display.getRotation();
                            if ((rotation == 1 || rotation == 3) && rotation != WOWZCameraView.this.f3720l) {
                                WOWZCameraView.this.doConfigChange();
                                int unused = WOWZCameraView.this.f3720l = rotation;
                            } else if ((rotation == 0 || rotation == 2) && rotation != WOWZCameraView.this.f3720l) {
                                WOWZCameraView.this.doConfigChange();
                                int unused2 = WOWZCameraView.this.f3720l = rotation;
                            }
                        }
                    } catch (Exception e) {
                        WOWZLog.error(WOWZCameraView.f3709a, e.getMessage());
                    }
                }
            };
            if (this.f3719k.canDetectOrientation()) {
                this.f3719k.enable();
            } else {
                this.f3719k.disable();
            }
            this.mContext.registerComponentCallbacks(this);
            if (this.mActiveCamera == null) {
                this.mActiveCamera = m3611c();
                if (this.mActiveCamera == null) {
                    this.mPreviewStatus.setState(0);
                    return null;
                }
            }
            if (this.f3711c.mo59212b()) {
                WOWZError a = m3606a(this.f3711c.mo59213c());
                if (a == null) {
                    this.mPreviewStatus.setState(3);
                } else {
                    this.mPreviewStatus.setError(a);
                    this.mPreviewStatus.setState(0);
                }
                if (previewStatusListener != null) {
                    if (a == null) {
                        previewStatusListener.onWZCameraPreviewStarted(this.mActiveCamera, this.f3715g.getActiveFrameSize(), this.f3715g.getFramerate());
                    } else {
                        previewStatusListener.onWZCameraPreviewError(this.mActiveCamera, a);
                    }
                }
            }
            return this.mActiveCamera;
        }
    }

    public synchronized WOWZCamera startPreview(PreviewStatusListener previewStatusListener) {
        return startPreview((WOWZMediaConfig) null, previewStatusListener);
    }

    public synchronized WOWZCamera startPreview(WOWZMediaConfig wOWZMediaConfig) {
        return startPreview(wOWZMediaConfig, this.f3722n);
    }

    public synchronized WOWZCamera startPreview() {
        return startPreview((WOWZMediaConfig) null, this.f3722n);
    }

    public synchronized WOWZCamera stopPreview(PreviewStatusListener previewStatusListener) {
        if (this.mActiveCamera != null && isPreviewing()) {
            this.f3711c.mo59208a(true);
            this.mContext.unregisterComponentCallbacks(this);
            this.mActiveCamera.stopPreview();
            this.mPreviewStatus.setState(0);
            if (previewStatusListener != null) {
                previewStatusListener.onWZCameraPreviewStopped(this.mActiveCamera.getCameraId());
            }
        }
        return this.mActiveCamera;
    }

    public synchronized WOWZCamera stopPreview() {
        return stopPreview(this.f3722n);
    }

    public void clearView() {
        this.f3711c.mo59219i();
    }

    /* renamed from: a */
    private WOWZError m3606a(SurfaceTexture surfaceTexture) {
        this.mActiveCamera.setSurfaceTexture(surfaceTexture);
        WOWZLog.debug("DUPLE startupCamera " + this.f3715g.getFramerate());
        if (!this.mActiveCamera.startPreview(this.mContext, this.f3715g.getScaleMode() == 2 ? this.f3715g.getViewSize().asLandscape() : this.f3715g.getClientFrameSize(), this.f3715g.getClientFrameSize(), this.f3715g.getFramerate())) {
            return this.mActiveCamera.getLastError();
        }
        this.f3715g.getActiveFrameSize().set(this.mActiveCamera.getFrameSize());
        return null;
    }

    /* renamed from: a */
    private void m3609a(WOWZSize wOWZSize) {
        WOWZCamera wOWZCamera = this.mActiveCamera;
        if (wOWZCamera != null) {
            wOWZCamera.pausePreview();
            clearView();
            if (wOWZSize != null) {
                this.mActiveCamera.setFrameSize(wOWZSize);
            }
            this.mActiveCamera.continuePreview();
        }
        this.f3715g.setActiveFrameSize(wOWZSize);
    }

    public void setSurfaceExtension(int i) {
        Texture2dProgram.ProgramType programType = Texture2dProgram.ProgramType.TEXTURE_EXT;
        if (i == 1) {
            programType = Texture2dProgram.ProgramType.TEXTURE_EXT_MIRROR;
        } else if (i == 2) {
            programType = Texture2dProgram.ProgramType.TEXTURE_EXT_BW;
        }
        this.f3718j = programType;
    }

    public void setCameraConfig(WOWZMediaConfig wOWZMediaConfig) {
        WOWZMediaConfig wOWZMediaConfig2 = new WOWZMediaConfig(wOWZMediaConfig);
        WOWZLog.debug("DUPLE setCameraConfig " + wOWZMediaConfig2.getVideoFramerate());
        if (this.mActiveCamera != null && isPreviewing()) {
            this.mActiveCamera.setFrameSize(wOWZMediaConfig.getVideoFrameSize());
            wOWZMediaConfig2.setVideoFrameSize(this.mActiveCamera.getFrameSize());
            this.mActiveCamera.setFramerate(wOWZMediaConfig2.getVideoFramerate());
        }
        setFrameSize(wOWZMediaConfig2.getVideoFrameSize());
        setFramerate(wOWZMediaConfig2.getVideoFramerate());
    }

    public int getScaleMode() {
        return this.f3715g.getScaleMode();
    }

    public void setScaleMode(int i) {
        if (this.f3715g.getScaleMode() != i) {
            this.f3715g.setScaleMode(i);
            requestLayout();
        }
    }

    public WOWZSize getFrameSize() {
        return this.f3715g.getClientFrameSize();
    }

    public WOWZSize getActiveFrameSize() {
        return this.f3715g.getActiveFrameSize();
    }

    public WOWZSize setFrameSize(int i, int i2) {
        WOWZSize asLandscape = new WOWZSize(i, i2).asLandscape();
        if (asLandscape.equals(this.f3715g.getClientFrameSize())) {
            return asLandscape;
        }
        this.f3715g.getClientFrameSize().set(i, i2);
        if (!isLaidOut()) {
            return asLandscape;
        }
        if (this.f3715g.getScaleMode() != 1) {
            synchronized (this.f3710b) {
                m3610b();
            }
        } else if (!asLandscape.equalsAspect(this.f3715g.getViewSize())) {
            requestLayout();
        }
        this.f3711c.mo59207a(this.f3715g);
        return asLandscape;
    }

    public WOWZSize setFrameSize(WOWZSize wOWZSize) {
        return setFrameSize(wOWZSize.getWidth(), wOWZSize.getHeight());
    }

    /* renamed from: b */
    private WOWZSize m3610b() {
        if (this.mActiveCamera != null) {
            WOWZSize activeFrameSize = this.f3715g.getActiveFrameSize();
            WOWZSize optimalPreviewSize = this.mActiveCamera.getOptimalPreviewSize((this.f3715g.getScaleMode() == 2 ? this.f3715g.getViewSize() : this.f3715g.getClientFrameSize()).asLandscape(), this.f3715g.getClientFrameSize().asLandscape());
            if (optimalPreviewSize == null || (activeFrameSize != null && activeFrameSize.equals(optimalPreviewSize))) {
                return activeFrameSize;
            }
            this.f3715g.getActiveFrameSize().set(optimalPreviewSize);
            this.mActiveCamera.setFrameSize(optimalPreviewSize);
            this.f3716h.setVideoFrameSize(optimalPreviewSize);
        }
        return this.f3715g.getActiveFrameSize();
    }

    public int getFramerate() {
        return this.f3715g.getFramerate();
    }

    public int setFramerate(int i) {
        WOWZCamera wOWZCamera = this.mActiveCamera;
        if (wOWZCamera != null) {
            wOWZCamera.setFramerate(i);
        }
        this.f3715g.setFramerate(i);
        this.f3711c.mo59207a(this.f3715g);
        return getFramerate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        synchronized (this.f3710b) {
            if (this.f3714f) {
                m3610b();
                this.f3714f = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int resolveSize = resolveSize(getSuggestedMinimumWidth(), i);
        int resolveSize2 = resolveSize(getSuggestedMinimumHeight(), i2);
        double d = (double) (((float) resolveSize) / ((float) resolveSize2));
        double aspectRatio = (double) (WOWZSize.isPortrait(resolveSize, resolveSize2) ? this.f3715g.getClientFrameSize().asPortrait() : this.f3715g.getClientFrameSize()).aspectRatio();
        if (this.f3715g.getScaleMode() == 1 && aspectRatio != d) {
            double d2 = (aspectRatio / d) - 1.0d;
            if (Math.abs(d2) > 0.01d) {
                if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    resolveSize2 = (int) (((double) resolveSize) / aspectRatio);
                } else {
                    resolveSize = (int) (((double) resolveSize2) * aspectRatio);
                }
            }
        }
        synchronized (this.f3710b) {
            if (!(this.f3715g.getViewSize().width == resolveSize && this.f3715g.getViewSize().height == resolveSize2)) {
                this.f3715g.getViewSize().set(resolveSize, resolveSize2);
                this.f3714f = true;
            }
        }
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    public WOWZCamera[] getCameras() {
        if (this.mCameras.length == 0) {
            this.mCameras = WOWZCamera.getAvailableDeviceCameras(this.mContext);
        }
        return this.mCameras;
    }

    /* renamed from: c */
    private WOWZCamera m3611c() {
        int d = m3612d();
        if (d == -1) {
            return null;
        }
        return getCameraById(d);
    }

    /* renamed from: d */
    private int m3612d() {
        int i;
        WOWZCamera[] cameras = getCameras();
        int i2 = 0;
        while (true) {
            if (i2 >= cameras.length) {
                i = -1;
                break;
            } else if (cameras[i2].getDirection() == this.mDefaultCameraDirection) {
                i = cameras[i2].getCameraId();
                break;
            } else {
                i2++;
            }
        }
        if (i != -1) {
            return i;
        }
        WOWZCamera wOWZCamera = this.mActiveCamera;
        if (wOWZCamera != null) {
            return wOWZCamera.getCameraId();
        }
        WOWZCamera[] wOWZCameraArr = this.mCameras;
        return wOWZCameraArr.length > 0 ? wOWZCameraArr[0].getCameraId() : i;
    }

    public WOWZCamera getCamera() {
        if (this.mActiveCamera == null) {
            this.mActiveCamera = m3611c();
        }
        return this.mActiveCamera;
    }

    public WOWZCamera getCameraById(int i) {
        for (WOWZCamera wOWZCamera : getCameras()) {
            if (wOWZCamera.getCameraId() == i) {
                return wOWZCamera;
            }
        }
        return null;
    }

    public WOWZCamera getCameraByDirection(int i) {
        for (WOWZCamera wOWZCamera : getCameras()) {
            if (wOWZCamera.getDirection() == i) {
                return wOWZCamera;
            }
        }
        return null;
    }

    public WOWZCamera getOtherCamera() {
        int otherCameraId = getOtherCameraId();
        if (otherCameraId == -1) {
            return null;
        }
        return getCameraById(otherCameraId);
    }

    public int getOtherCameraId() {
        WOWZCamera[] cameras = getCameras();
        if (this.mActiveCamera != null && cameras.length == 1) {
            return -1;
        }
        if (this.mActiveCamera == null && cameras.length > 0) {
            return cameras[0].getCameraId();
        }
        for (WOWZCamera wOWZCamera : cameras) {
            if (wOWZCamera.getCameraId() != this.mActiveCamera.getCameraId()) {
                return wOWZCamera.getCameraId();
            }
        }
        return -1;
    }

    public WOWZCamera setCamera(int i) {
        WOWZCamera wOWZCamera = this.mActiveCamera;
        if (wOWZCamera != null && i == wOWZCamera.getCameraId()) {
            return this.mActiveCamera;
        }
        WOWZCamera wOWZCamera2 = this.mActiveCamera;
        if (wOWZCamera2 != null) {
            wOWZCamera2.stopPreview();
        }
        WOWZCamera[] cameras = getCameras();
        int length = cameras.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            WOWZCamera wOWZCamera3 = cameras[i2];
            if (wOWZCamera3.getCameraId() == i) {
                this.mActiveCamera = wOWZCamera3;
                break;
            }
            i2++;
        }
        WOWZCamera wOWZCamera4 = this.mActiveCamera;
        if (!(wOWZCamera4 == null || wOWZCamera4.getCameraId() == i)) {
            WOWZLog.error(f3709a, "The specified camera ID was invalid or the camera could not be accessed.");
        }
        if (this.mActiveCamera != null && isPreviewing()) {
            this.f3711c.mo59211b(this.f3718j);
            m3606a(this.f3711c.mo59213c());
        }
        return this.mActiveCamera;
    }

    public WOWZCamera setCamera(WOWZCamera wOWZCamera) {
        if (wOWZCamera != null) {
            return setCamera(wOWZCamera.getCameraId());
        }
        return null;
    }

    public WOWZCamera setCameraByDirection(int i) {
        WOWZCamera cameraByDirection = getCameraByDirection(i);
        if (cameraByDirection != null) {
            return setCamera(cameraByDirection.getCameraId());
        }
        return null;
    }

    public synchronized WOWZCamera switchCamera() {
        if (isSwitchCameraAvailable()) {
            setCamera(getOtherCamera());
        }
        return this.mActiveCamera;
    }

    public boolean isSwitchCameraAvailable(WOWZSize wOWZSize) {
        WOWZCamera otherCamera;
        if (this.mCameras.length < 2 || this.mActiveCamera == null || (otherCamera = getOtherCamera()) == null) {
            return false;
        }
        if (wOWZSize == null) {
            getFrameSize();
        }
        boolean contains = Arrays.asList(otherCamera.getSupportedFrameSizes()).contains(getFrameSize());
        if (!WowzaGoCoder.getInstance().isStreaming()) {
            return true;
        }
        if (!WowzaGoCoder.getInstance().getConfig().isVideoEnabled()) {
            return false;
        }
        return contains;
    }

    public boolean isSwitchCameraAvailable(WOWZMediaConfig wOWZMediaConfig) {
        return isSwitchCameraAvailable(wOWZMediaConfig.getVideoFrameSize());
    }

    public boolean isSwitchCameraAvailable() {
        return isSwitchCameraAvailable(getFrameSize());
    }

    public void doConfigChange() {
        WOWZCamera wOWZCamera = this.mActiveCamera;
        if (wOWZCamera != null && wOWZCamera.isPreviewing()) {
            this.mActiveCamera.autoDetectOrientation(this.mContext);
        }
        int deviceRotation = WOWZDeviceUtils.getDeviceRotation(this.mContext);
        this.f3715g.setSurfaceRotation(deviceRotation);
        this.f3716h.setVideoRotation(deviceRotation);
    }

    public void onConfigurationChanged(Configuration configuration) {
        WOWZLog.debug("onConfigurationChanged: " + configuration.toString());
        doConfigChange();
    }

    public void onLowMemory() {
        WOWZLog.warn(f3709a, "Low memory notification received.");
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        synchronized (this.f3710b) {
            this.f3715g.getSurfaceSize().set(surfaceFrame.width(), surfaceFrame.height());
        }
        if (this.f3711c.mo59212b()) {
            this.f3711c.mo59218h();
        }
        this.f3711c.mo59207a(this.f3715g);
        this.f3711c.mo59205a(surfaceHolder.getSurface());
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        String str = f3709a;
        WOWZLog.debug(str, "SURFACE_CHANGED size=" + i2 + "x" + i3 + " :: " + this.f3718j);
        synchronized (this.f3710b) {
            this.f3715g.getSurfaceSize().set(i2, i3);
        }
        this.f3711c.mo59207a(this.f3715g);
        if (!this.f3711c.mo59212b()) {
            WOWZStatus a = this.f3711c.mo59204a(this.f3718j);
            if (this.mPreviewStatus.isStarting()) {
                if (!a.isRunning()) {
                    this.mPreviewStatus.setError(a.getLastError());
                    this.mPreviewStatus.setState(0);
                    PreviewStatusListener previewStatusListener = this.f3721m;
                    if (previewStatusListener != null) {
                        previewStatusListener.onWZCameraPreviewError(this.mActiveCamera, a.getLastError());
                    }
                } else {
                    WOWZError a2 = m3606a(this.f3711c.mo59213c());
                    if (a2 == null) {
                        this.mPreviewStatus.setState(3);
                    } else {
                        this.mPreviewStatus.setError(a2);
                        this.mPreviewStatus.setState(0);
                    }
                    if (this.f3721m != null) {
                        if (this.mPreviewStatus.isRunning()) {
                            this.f3721m.onWZCameraPreviewStarted(this.mActiveCamera, this.f3715g.getActiveFrameSize(), this.f3715g.getFramerate());
                        } else {
                            this.f3721m.onWZCameraPreviewError(this.mActiveCamera, a2);
                        }
                    }
                }
                this.f3721m = null;
            }
        }
    }

    public synchronized void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f3711c.mo59218h();
    }

    public void onPause() {
        synchronized (this.f3710b) {
            if (this.mPreviewStatus.isRunning()) {
                stopPreview();
                this.mPreviewStatus.setState(5);
            }
            this.f3711c.mo59218h();
        }
    }

    public void onResume() {
        synchronized (this.f3710b) {
            if (this.mPreviewStatus.isPaused()) {
                startPreview();
            }
        }
    }

    public WOWZSize getScreenSize() {
        return this.f3711c.mo59215e() != null ? this.f3711c.mo59215e() : new WOWZSize(getWidth(), getHeight());
    }

    public synchronized void registerFrameRenderer(WOWZRenderAPI.VideoFrameRenderer videoFrameRenderer) {
        if (!this.f3712d.contains(videoFrameRenderer)) {
            this.f3712d.add(0, videoFrameRenderer);
            this.f3711c.mo59210a((WOWZRenderAPI.VideoFrameRenderer[]) this.f3712d.toArray(new WOWZRenderAPI.VideoFrameRenderer[this.f3712d.size()]));
        }
    }

    public synchronized void unregisterFrameRenderer(WOWZRenderAPI.VideoFrameRenderer videoFrameRenderer) {
        if (this.f3712d.contains(videoFrameRenderer)) {
            this.f3712d.remove(videoFrameRenderer);
            this.f3711c.mo59210a((WOWZRenderAPI.VideoFrameRenderer[]) this.f3712d.toArray(new WOWZRenderAPI.VideoFrameRenderer[this.f3712d.size()]));
        }
    }

    public synchronized void registerFrameListener(WOWZRenderAPI.VideoFrameListener videoFrameListener) {
        if (!this.f3713e.contains(videoFrameListener)) {
            this.f3713e.add(0, videoFrameListener);
            this.f3711c.mo59209a((WOWZRenderAPI.VideoFrameListener[]) this.f3713e.toArray(new WOWZRenderAPI.VideoFrameListener[this.f3713e.size()]));
        }
    }

    public synchronized void unregisterFrameListener(WOWZRenderAPI.VideoFrameListener videoFrameListener) {
        if (this.f3713e.contains(videoFrameListener)) {
            this.f3713e.remove(videoFrameListener);
            this.f3711c.mo59209a((WOWZRenderAPI.VideoFrameListener[]) this.f3713e.toArray(new WOWZRenderAPI.VideoFrameListener[this.f3713e.size()]));
        }
    }
}
