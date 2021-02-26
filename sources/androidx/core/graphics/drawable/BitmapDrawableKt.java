package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¨\u0006\u0005"}, mo66933d2 = {"toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Bitmap;", "resources", "Landroid/content/res/Resources;", "core-ktx_release"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: BitmapDrawable.kt */
public final class BitmapDrawableKt {
    @NotNull
    public static final BitmapDrawable toDrawable(@NotNull Bitmap bitmap, @NotNull Resources resources) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$toDrawable");
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
