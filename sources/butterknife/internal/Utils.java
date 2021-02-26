package butterknife.internal;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Array;
import java.util.List;

public final class Utils {
    private static final boolean HAS_SUPPORT_V4 = hasSupportV4();

    private static boolean hasSupportV4() {
        try {
            Class.forName("androidx.core.graphics.drawable.DrawableCompat");
            return true;
        } catch (ClassNotFoundException | VerifyError unused) {
            return false;
        }
    }

    public static Drawable getTintedDrawable(Resources resources, Resources.Theme theme, @DrawableRes int i, @AttrRes int i2) {
        if (HAS_SUPPORT_V4) {
            return SupportV4.getTintedDrawable(resources, theme, i, i2);
        }
        throw new RuntimeException("Android support-v4 library is required for @BindDrawable with tint.");
    }

    public static int getColor(Resources resources, Resources.Theme theme, @ColorRes int i) {
        if (Build.VERSION.SDK_INT < 23) {
            return resources.getColor(i);
        }
        return resources.getColor(i, theme);
    }

    public static ColorStateList getColorStateList(Resources resources, Resources.Theme theme, @ColorRes int i) {
        if (Build.VERSION.SDK_INT < 23) {
            return resources.getColorStateList(i);
        }
        return resources.getColorStateList(i, theme);
    }

    public static Drawable getDrawable(Resources resources, Resources.Theme theme, @DrawableRes int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return resources.getDrawable(i);
        }
        return resources.getDrawable(i, theme);
    }

    @SafeVarargs
    public static <T> T[] arrayOf(T... tArr) {
        return filterNull(tArr);
    }

    @SafeVarargs
    public static <T> List<T> listOf(T... tArr) {
        return new ImmutableList(filterNull(tArr));
    }

    private static <T> T[] filterNull(T[] tArr) {
        int i = 0;
        for (T t : tArr) {
            if (t != null) {
                tArr[i] = t;
                i++;
            }
        }
        if (i == r0) {
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
        System.arraycopy(tArr, 0, tArr2, 0, i);
        return tArr2;
    }

    static class SupportV4 {
        private static final TypedValue OUT_VALUE = new TypedValue();

        SupportV4() {
        }

        static Drawable getTintedDrawable(Resources resources, Resources.Theme theme, @DrawableRes int i, @AttrRes int i2) {
            if (theme.resolveAttribute(i2, OUT_VALUE, true)) {
                Drawable wrap = DrawableCompat.wrap(Utils.getDrawable(resources, theme, i).mutate());
                DrawableCompat.setTint(wrap, Utils.getColor(resources, theme, OUT_VALUE.resourceId));
                return wrap;
            }
            throw new Resources.NotFoundException("Required tint color attribute with name " + resources.getResourceEntryName(i2) + " and attribute ID " + i2 + " was not found.");
        }
    }

    private Utils() {
        throw new AssertionError("No instances.");
    }
}
