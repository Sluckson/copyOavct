package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i) {
        return getDrawable(context, i, (Resources.Theme) null);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context, i);
            }
        } catch (NoClassDefFoundError unused) {
            shouldCallAppCompatResources = false;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context.getTheme();
        }
        return loadDrawableV4(context, i, theme);
    }

    private static Drawable loadDrawableV7(Context context, @DrawableRes int i) {
        return AppCompatResources.getDrawable(context, i);
    }

    private static Drawable loadDrawableV4(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }
}
