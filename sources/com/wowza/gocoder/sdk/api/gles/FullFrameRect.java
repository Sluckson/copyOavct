package com.wowza.gocoder.sdk.api.gles;

import com.wowza.gocoder.sdk.api.gles.Drawable2d;

/* compiled from: GoCoderSDK */
public class FullFrameRect {

    /* renamed from: a */
    private final Drawable2d f3774a = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);

    /* renamed from: b */
    private Texture2dProgram f3775b;

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        this.f3775b = texture2dProgram;
    }

    public void release(boolean z) {
        Texture2dProgram texture2dProgram = this.f3775b;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.release();
            }
            this.f3775b = null;
        }
    }

    public Texture2dProgram getProgram() {
        return this.f3775b;
    }

    public void changeProgram(Texture2dProgram texture2dProgram) {
        this.f3775b.release();
        this.f3775b = texture2dProgram;
    }

    public int createTextureObject() {
        return this.f3775b.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        this.f3775b.draw(GlUtil.IDENTITY_MATRIX, this.f3774a.getVertexArray(), 0, this.f3774a.getVertexCount(), this.f3774a.getCoordsPerVertex(), this.f3774a.getVertexStride(), fArr, this.f3774a.getTexCoordArray(), i, this.f3774a.getTexCoordStride());
    }
}
