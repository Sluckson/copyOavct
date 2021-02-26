package com.wowza.gocoder.sdk.api.gles;

/* compiled from: GoCoderSDK */
public class OffscreenSurface extends EglSurfaceBase {
    public OffscreenSurface(EglCore eglCore, int i, int i2) {
        super(eglCore);
        createOffscreenSurface(i, i2);
    }

    public void release() {
        releaseEglSurface();
    }
}
