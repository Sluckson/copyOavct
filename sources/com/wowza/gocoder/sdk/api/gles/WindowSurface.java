package com.wowza.gocoder.sdk.api.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* compiled from: GoCoderSDK */
public class WindowSurface extends EglSurfaceBase {

    /* renamed from: a */
    private Surface f3811a;

    /* renamed from: b */
    private boolean f3812b;

    public WindowSurface(EglCore eglCore, Surface surface, boolean z) {
        super(eglCore);
        createWindowSurface(surface);
        this.f3811a = surface;
        this.f3812b = z;
    }

    public WindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        super(eglCore);
        createWindowSurface(surfaceTexture);
    }

    public void release() {
        releaseEglSurface();
        Surface surface = this.f3811a;
        if (surface != null) {
            if (this.f3812b) {
                surface.release();
            }
            this.f3811a = null;
        }
    }

    public void recreate(EglCore eglCore) {
        Surface surface = this.f3811a;
        if (surface != null) {
            this.mEglCore = eglCore;
            createWindowSurface(surface);
            return;
        }
        throw new RuntimeException("Not yet implemented for SurfaceTexture.");
    }
}
