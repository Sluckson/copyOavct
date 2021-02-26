package com.iaai.android.bdt.utils.binding;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, mo66933d2 = {"loadImage", "", "view", "Landroid/widget/ImageView;", "url", "", "app_productionRelease"}, mo66934k = 2, mo66935mv = {1, 1, 13})
/* compiled from: DataBindingAdapter.kt */
public final class DataBindingAdapterKt {
    @BindingAdapter({"android:src"})
    public static final void loadImage(@NotNull ImageView imageView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(imageView, "view");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Glide.with((View) imageView).load(str).apply(new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation)).into(imageView);
    }
}
