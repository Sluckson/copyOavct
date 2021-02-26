package com.wowza.gocoder.sdk.support.p029a.p030a.p031a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.android.gms.gcm.Task;

/* renamed from: com.wowza.gocoder.sdk.support.a.a.a.d */
/* compiled from: GoCoderSDK */
public class C4265d {
    /* renamed from: a */
    public static int m3742a(Context context, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        return m3743a(BitmapFactory.decodeResource(context.getResources(), i, options));
    }

    /* renamed from: a */
    public static int m3743a(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9729);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            bitmap.recycle();
        }
        if (iArr[0] != 0) {
            return iArr[0];
        }
        throw new RuntimeException("Error loading texture.");
    }
}
