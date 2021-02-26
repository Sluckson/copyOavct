package com.iaai.android.old.utils.p016ui.touchgallery;

import android.graphics.Bitmap;
import android.support.p000v4.media.session.PlaybackStateCompat;
import androidx.collection.LruCache;
import com.android.volley.toolbox.ImageLoader;

/* renamed from: com.iaai.android.old.utils.ui.touchgallery.LruBitmapCache */
public class LruBitmapCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    public static int getDefaultLruCacheSize() {
        return ((int) (Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / 8;
    }

    public LruBitmapCache() {
        this(getDefaultLruCacheSize());
    }

    public LruBitmapCache(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(String str, Bitmap bitmap) {
        return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
    }

    public Bitmap getBitmap(String str) {
        return (Bitmap) get(str);
    }

    public void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }
}
