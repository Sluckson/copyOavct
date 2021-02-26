package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class FitCenter extends BitmapTransformation {

    /* renamed from: ID */
    private static final String f114ID = "com.bumptech.glide.load.resource.bitmap.FitCenter";
    private static final byte[] ID_BYTES = f114ID.getBytes(CHARSET);

    public FitCenter() {
    }

    @Deprecated
    public FitCenter(Context context) {
        this();
    }

    @Deprecated
    public FitCenter(BitmapPool bitmapPool) {
        this();
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.fitCenter(bitmapPool, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    public int hashCode() {
        return f114ID.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
