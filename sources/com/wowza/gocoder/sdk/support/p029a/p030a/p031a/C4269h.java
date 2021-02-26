package com.wowza.gocoder.sdk.support.p029a.p030a.p031a;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* renamed from: com.wowza.gocoder.sdk.support.a.a.a.h */
/* compiled from: GoCoderSDK */
public class C4269h {

    /* renamed from: a */
    static final int f3990a = 2;

    /* renamed from: b */
    static final int f3991b = 3;

    /* renamed from: c */
    static final int f3992c = 4;

    /* renamed from: d */
    static final int f3993d = 2;

    /* renamed from: e */
    static final int f3994e = 3;

    /* renamed from: f */
    static final int f3995f = 2;

    /* renamed from: o */
    private static final int f3996o = 1;

    /* renamed from: p */
    private static final String f3997p = "Vertices";

    /* renamed from: g */
    public final int f3998g = 2;

    /* renamed from: h */
    public final int f3999h = ((this.f3998g + 2) + 1);

    /* renamed from: i */
    public final int f4000i = (this.f3999h * 4);

    /* renamed from: j */
    final IntBuffer f4001j;

    /* renamed from: k */
    final ShortBuffer f4002k;

    /* renamed from: l */
    public int f4003l;

    /* renamed from: m */
    public int f4004m;

    /* renamed from: n */
    final int[] f4005n;

    /* renamed from: q */
    private int f4006q;

    /* renamed from: r */
    private int f4007r;

    /* renamed from: s */
    private int f4008s;

    public C4269h(int i, int i2) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f4000i * i);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f4001j = allocateDirect.asIntBuffer();
        if (i2 > 0) {
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(i2 * 2);
            allocateDirect2.order(ByteOrder.nativeOrder());
            this.f4002k = allocateDirect2.asShortBuffer();
        } else {
            this.f4002k = null;
        }
        this.f4003l = 0;
        this.f4004m = 0;
        this.f4005n = new int[((i * this.f4000i) / 4)];
        this.f4006q = C4260a.A_TexCoordinate.mo58976a();
        this.f4008s = C4260a.A_MVPMatrixIndex.mo58976a();
        this.f4007r = C4260a.A_Position.mo58976a();
    }

    /* renamed from: a */
    public void mo59019a(float[] fArr, int i, int i2) {
        this.f4001j.clear();
        int i3 = i + i2;
        int i4 = 0;
        while (i < i3) {
            this.f4005n[i4] = Float.floatToRawIntBits(fArr[i]);
            i++;
            i4++;
        }
        this.f4001j.put(this.f4005n, 0, i2);
        this.f4001j.flip();
        this.f4003l = i2 / this.f3999h;
    }

    /* renamed from: a */
    public void mo59020a(short[] sArr, int i, int i2) {
        this.f4002k.clear();
        this.f4002k.put(sArr, i, i2);
        this.f4002k.flip();
        this.f4004m = i2;
    }

    /* renamed from: a */
    public void mo59017a() {
        this.f4001j.position(0);
        GLES20.glVertexAttribPointer(this.f4007r, this.f3998g, 5126, false, this.f4000i, this.f4001j);
        GLES20.glEnableVertexAttribArray(this.f4007r);
        this.f4001j.position(this.f3998g);
        GLES20.glVertexAttribPointer(this.f4006q, 2, 5126, false, this.f4000i, this.f4001j);
        GLES20.glEnableVertexAttribArray(this.f4006q);
        this.f4001j.position(this.f3998g + 2);
        GLES20.glVertexAttribPointer(this.f4008s, 1, 5126, false, this.f4000i, this.f4001j);
        GLES20.glEnableVertexAttribArray(this.f4008s);
    }

    /* renamed from: a */
    public void mo59018a(int i, int i2, int i3) {
        ShortBuffer shortBuffer = this.f4002k;
        if (shortBuffer != null) {
            shortBuffer.position(i2);
            GLES20.glDrawElements(i, i3, 5123, this.f4002k);
            return;
        }
        GLES20.glDrawArrays(i, i2, i3);
    }

    /* renamed from: b */
    public void mo59021b() {
        GLES20.glDisableVertexAttribArray(this.f4006q);
    }
}
