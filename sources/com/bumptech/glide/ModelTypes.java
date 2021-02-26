package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

interface ModelTypes<T> {
    @CheckResult
    T load(@Nullable Bitmap bitmap);

    @CheckResult
    T load(@Nullable Drawable drawable);

    @CheckResult
    T load(@Nullable Uri uri);

    @CheckResult
    T load(@Nullable File file);

    @CheckResult
    T load(@RawRes @DrawableRes @Nullable Integer num);

    @CheckResult
    T load(@Nullable Object obj);

    @CheckResult
    T load(@Nullable String str);

    @CheckResult
    @Deprecated
    T load(@Nullable URL url);

    @CheckResult
    T load(@Nullable byte[] bArr);
}
