package com.wowza.gocoder.sdk.api.render;

import android.content.Context;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.devices.WOWZDeviceUtils;
import com.wowza.gocoder.sdk.api.geometry.WOWZCropDimensions;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;

/* compiled from: GoCoderSDK */
public abstract class WOWZRenderAPI {

    /* renamed from: a */
    private static final String f3901a = "WOWZRenderAPI";

    /* compiled from: GoCoderSDK */
    public interface VideoFrameListener {
        boolean isWZVideoFrameListenerActive();

        void onWZVideoFrameListenerFrameAvailable(WOWZGLES.EglEnv eglEnv, WOWZSize wOWZSize, int i, long j);

        void onWZVideoFrameListenerInit(WOWZGLES.EglEnv eglEnv);

        void onWZVideoFrameListenerRelease(WOWZGLES.EglEnv eglEnv);
    }

    /* compiled from: GoCoderSDK */
    public interface VideoFrameRenderer {
        boolean isWZVideoFrameRendererActive();

        void onWZVideoFrameRendererDraw(WOWZGLES.EglEnv eglEnv, WOWZSize wOWZSize, int i);

        void onWZVideoFrameRendererInit(WOWZGLES.EglEnv eglEnv);

        void onWZVideoFrameRendererRelease(WOWZGLES.EglEnv eglEnv);
    }

    /* compiled from: GoCoderSDK */
    public static class VideoViewConfig {
        protected WOWZSize activeFrameSize;
        protected WOWZSize clientFrameSize;
        protected int framerate;
        protected int scaleMode;
        protected int surfaceRotation;
        protected WOWZSize surfaceSize;
        protected WOWZSize viewSize;

        public VideoViewConfig() {
            this.scaleMode = 2;
            this.viewSize = new WOWZSize();
            this.surfaceSize = new WOWZSize(this.viewSize);
            this.surfaceRotation = 0;
            this.clientFrameSize = new WOWZSize(WOWZMediaConfig.DEFAULT_VIDEO_FRAME_SIZE);
            this.activeFrameSize = new WOWZSize(this.clientFrameSize);
            this.framerate = 30;
        }

        public VideoViewConfig(Context context) {
            this();
            this.surfaceRotation = WOWZDeviceUtils.getDeviceRotation(context);
        }

        public VideoViewConfig(VideoViewConfig videoViewConfig) {
            this();
            set(videoViewConfig);
        }

        public void set(VideoViewConfig videoViewConfig) {
            this.scaleMode = videoViewConfig.scaleMode;
            this.surfaceRotation = videoViewConfig.surfaceRotation;
            this.framerate = videoViewConfig.framerate;
            this.viewSize.set(videoViewConfig.viewSize);
            this.surfaceSize.set(videoViewConfig.surfaceSize);
            this.activeFrameSize.set(videoViewConfig.activeFrameSize);
            this.clientFrameSize.set(videoViewConfig.clientFrameSize);
        }

        public WOWZSize getActiveFrameSize() {
            return this.activeFrameSize;
        }

        public void setActiveFrameSize(WOWZSize wOWZSize) {
            this.activeFrameSize = wOWZSize;
        }

        public WOWZSize getClientFrameSize() {
            return this.clientFrameSize;
        }

        public void setClientFrameSize(WOWZSize wOWZSize) {
            this.clientFrameSize = wOWZSize;
        }

        public int getFramerate() {
            return this.framerate;
        }

        public void setFramerate(int i) {
            this.framerate = i;
        }

        public int getScaleMode() {
            return this.scaleMode;
        }

        public void setScaleMode(int i) {
            this.scaleMode = i;
        }

        public int getSurfaceRotation() {
            return this.surfaceRotation;
        }

        public void setSurfaceRotation(int i) {
            this.surfaceRotation = i;
        }

        public WOWZSize getSurfaceSize() {
            return this.surfaceSize;
        }

        public void setSurfaceSize(WOWZSize wOWZSize) {
            this.surfaceSize = wOWZSize;
        }

        public WOWZSize getViewSize() {
            return this.viewSize;
        }

        public void setViewSize(WOWZSize wOWZSize) {
            this.viewSize = wOWZSize;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuilder sb = new StringBuilder();
            sb.append("scaleMode           : ");
            sb.append(this.scaleMode == 2 ? "FILL_VIEW" : "RESIZE_TO_ASPECT");
            stringBuffer.append(sb.toString());
            stringBuffer.append("\nviewSize            : " + this.viewSize.toString() + " (" + this.viewSize.aspectRatioLabel() + ")");
            stringBuffer.append("\nsurfaceSize         : " + this.surfaceSize.toString() + " (" + this.surfaceSize.aspectRatioLabel() + ")");
            stringBuffer.append("\nclientFrameSize     : " + this.clientFrameSize.toString() + " (" + this.clientFrameSize.aspectRatioLabel() + ")");
            stringBuffer.append("\nactiveFrameSize     : " + this.activeFrameSize.toString() + " (" + this.activeFrameSize.aspectRatioLabel() + ")");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\nsurfaceRotation     : ");
            sb2.append(this.surfaceRotation);
            stringBuffer.append(sb2.toString());
            return stringBuffer.toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof VideoViewConfig)) {
                return false;
            }
            VideoViewConfig videoViewConfig = (VideoViewConfig) obj;
            if (this.scaleMode != videoViewConfig.scaleMode || this.framerate != videoViewConfig.framerate || this.surfaceRotation != videoViewConfig.surfaceRotation || !this.viewSize.equals(videoViewConfig.viewSize) || !this.activeFrameSize.equals(videoViewConfig.activeFrameSize) || !this.clientFrameSize.equals(videoViewConfig.clientFrameSize) || !this.activeFrameSize.equals(videoViewConfig.activeFrameSize)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: GoCoderSDK */
    public static class VideoRendererConfig extends VideoViewConfig {

        /* renamed from: a */
        private int f3902a;

        /* renamed from: b */
        private WOWZSize f3903b;

        /* renamed from: c */
        private WOWZCropDimensions f3904c;

        public VideoRendererConfig() {
            this.f3902a = 0;
            this.f3904c = new WOWZCropDimensions();
            this.f3903b = new WOWZSize(0, 0);
        }

        public VideoRendererConfig(VideoRendererConfig videoRendererConfig) {
            this();
            set(videoRendererConfig);
        }

        public VideoRendererConfig(VideoViewConfig videoViewConfig) {
            this();
            set(videoViewConfig);
        }

        public void set(VideoRendererConfig videoRendererConfig) {
            super.set(videoRendererConfig);
        }

        public void set(VideoViewConfig videoViewConfig) {
            super.set(videoViewConfig);
        }

        public WOWZCropDimensions getCropDimensions() {
            return this.f3904c;
        }

        public WOWZSize getEglViewportSize() {
            return this.f3903b;
        }

        public int getEglSurfaceRotation() {
            return this.f3902a;
        }

        public void setEglSurfaceRotation(int i) {
            this.f3902a = i;
        }

        public String toString() {
            return super.toString() + "\n---\neglViewportSize     : " + this.f3903b.toString() + " (" + this.f3903b.aspectRatioLabel() + ")\neglSurfaceRotation  : " + this.f3902a + "\n\ncropDimensions : \n----------------\n" + this.f3904c.toString() + "\n----------------";
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof VideoRendererConfig) || !super.equals(obj)) {
                return false;
            }
            VideoRendererConfig videoRendererConfig = (VideoRendererConfig) obj;
            if (this.f3902a != videoRendererConfig.f3902a || !this.f3903b.equals(videoRendererConfig.f3903b) || !this.f3904c.equals(videoRendererConfig.f3904c)) {
                return false;
            }
            return true;
        }
    }
}
