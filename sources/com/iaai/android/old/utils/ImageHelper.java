package com.iaai.android.old.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ImageHelper {
    public static boolean recycle(ImageView imageView) {
        Drawable drawable;
        Bitmap bitmap;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return false;
        }
        drawable.setCallback((Drawable.Callback) null);
        if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled()) {
            return false;
        }
        imageView.setImageBitmap((Bitmap) null);
        bitmap.recycle();
        return true;
    }
}
