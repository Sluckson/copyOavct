package com.google.android.exoplayer2.p009ui.spherical;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.exoplayer2.ui.spherical.CanvasRenderer */
public final class CanvasRenderer {
    private static final int COORDS_PER_VERTEX = 5;
    private static final float DISTANCE_UNIT = 1.0f;
    private static final String[] FRAGMENT_SHADER_CODE = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};
    private static final float HALF_PI = 1.5707964f;
    private static final int POSITION_COORDS_PER_VERTEX = 3;
    private static final int TEXTURE_COORDS_PER_VERTEX = 2;
    private static final int VERTEX_COUNT = 4;
    private static final String[] VERTEX_SHADER_CODE = {"uniform mat4 uMvpMatrix;", "attribute vec3 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * vec4(aPosition, 1);", "  vTexCoords = aTexCoords;", "}"};
    private static final int VERTEX_STRIDE_BYTES = 20;
    private static final float WIDTH_UNIT = 0.8f;
    private static final float X_UNIT = -0.4f;
    private static final float Y_UNIT = -0.3f;
    private Surface displaySurface;
    private SurfaceTexture displaySurfaceTexture;
    private int height;
    private float heightUnit;
    private int mvpMatrixHandle;
    private int positionHandle;
    private int program = 0;
    private final AtomicBoolean surfaceDirty = new AtomicBoolean();
    private int textureCoordsHandle;
    private int textureHandle;
    private int textureId;
    private final FloatBuffer vertexBuffer = GlUtil.createBuffer(20);
    private int width;

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.heightUnit = (((float) i2) * WIDTH_UNIT) / ((float) i);
        float[] fArr = new float[20];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 2) {
            int i5 = i4;
            int i6 = 0;
            while (i6 < 2) {
                int i7 = i5 + 1;
                float f = (float) i6;
                fArr[i5] = (f * WIDTH_UNIT) + X_UNIT;
                int i8 = i7 + 1;
                fArr[i7] = (this.heightUnit * ((float) i3)) + Y_UNIT;
                int i9 = i8 + 1;
                fArr[i8] = -1.0f;
                int i10 = i9 + 1;
                fArr[i9] = f;
                fArr[i10] = (float) (1 - i3);
                i6++;
                i5 = i10 + 1;
            }
            i3++;
            i4 = i5;
        }
        this.vertexBuffer.position(0);
        this.vertexBuffer.put(fArr);
    }

    @Nullable
    public Canvas lockCanvas() {
        Surface surface = this.displaySurface;
        if (surface == null) {
            return null;
        }
        return surface.lockCanvas((Rect) null);
    }

    public void unlockCanvasAndPost(@Nullable Canvas canvas) {
        Surface surface;
        if (canvas != null && (surface = this.displaySurface) != null) {
            surface.unlockCanvasAndPost(canvas);
        }
    }

    public void init() {
        if (this.program == 0) {
            this.program = GlUtil.compileProgram(VERTEX_SHADER_CODE, FRAGMENT_SHADER_CODE);
            this.mvpMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMvpMatrix");
            this.positionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
            this.textureCoordsHandle = GLES20.glGetAttribLocation(this.program, "aTexCoords");
            this.textureHandle = GLES20.glGetUniformLocation(this.program, "uTexture");
            this.textureId = GlUtil.createExternalTexture();
            GlUtil.checkGlError();
            this.displaySurfaceTexture = new SurfaceTexture(this.textureId);
            this.displaySurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    CanvasRenderer.this.lambda$init$0$CanvasRenderer(surfaceTexture);
                }
            });
            this.displaySurfaceTexture.setDefaultBufferSize(this.width, this.height);
            this.displaySurface = new Surface(this.displaySurfaceTexture);
        }
    }

    public /* synthetic */ void lambda$init$0$CanvasRenderer(SurfaceTexture surfaceTexture) {
        this.surfaceDirty.set(true);
    }

    public void draw(float[] fArr) {
        if (this.displaySurfaceTexture != null) {
            GLES20.glUseProgram(this.program);
            GlUtil.checkGlError();
            GLES20.glEnableVertexAttribArray(this.positionHandle);
            GLES20.glEnableVertexAttribArray(this.textureCoordsHandle);
            GlUtil.checkGlError();
            GLES20.glUniformMatrix4fv(this.mvpMatrixHandle, 1, false, fArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, this.textureId);
            GLES20.glUniform1i(this.textureHandle, 0);
            GlUtil.checkGlError();
            this.vertexBuffer.position(0);
            GLES20.glVertexAttribPointer(this.positionHandle, 3, 5126, false, 20, this.vertexBuffer);
            GlUtil.checkGlError();
            this.vertexBuffer.position(3);
            GLES20.glVertexAttribPointer(this.textureCoordsHandle, 2, 5126, false, 20, this.vertexBuffer);
            GlUtil.checkGlError();
            if (this.surfaceDirty.compareAndSet(true, false)) {
                this.displaySurfaceTexture.updateTexImage();
            }
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
            GLES20.glDisableVertexAttribArray(this.positionHandle);
            GLES20.glDisableVertexAttribArray(this.textureCoordsHandle);
        }
    }

    public void shutdown() {
        int i = this.program;
        if (i != 0) {
            GLES20.glDeleteProgram(i);
            GLES20.glDeleteTextures(1, new int[]{this.textureId}, 0);
        }
        SurfaceTexture surfaceTexture = this.displaySurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        Surface surface = this.displaySurface;
        if (surface != null) {
            surface.release();
        }
    }

    @Nullable
    public PointF translateClick(float f, float f2) {
        return internalTranslateClick(f, f2, X_UNIT, Y_UNIT, WIDTH_UNIT, this.heightUnit, this.width, this.height);
    }

    @Nullable
    static PointF internalTranslateClick(float f, float f2, float f3, float f4, float f5, float f6, int i, int i2) {
        if (f < HALF_PI && f > -1.5707964f && f2 < HALF_PI && f2 > -1.5707964f) {
            double tan = (Math.tan((double) f) * 1.0d) - ((double) f3);
            double tan2 = (Math.tan((double) f2) * 1.0d) - ((double) f4);
            if (tan >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d = (double) f5;
                if (tan <= d && tan2 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    double d2 = (double) f6;
                    if (tan2 <= d2) {
                        double d3 = (double) i;
                        double d4 = (double) i2;
                        return new PointF((float) (d3 - ((tan * d3) / d)), (float) (d4 - ((tan2 * d4) / d2)));
                    }
                }
            }
        }
        return null;
    }
}
