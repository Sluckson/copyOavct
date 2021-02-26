package com.iaai.android.bdt.feature.productDetail.vehicleimage;

import android.view.View;
import com.iaai.android.bdt.utils.NonHDImagesMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/vehicleimage/NonHDFullImagesActivity$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/CustomImageClickListener;", "onImageViewClick", "", "v", "Landroid/view/View;", "itemPosition", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: NonHDFullImagesActivity.kt */
public final class NonHDFullImagesActivity$initializeRecycler$1 implements CustomImageClickListener {
    final /* synthetic */ NonHDFullImagesActivity this$0;

    NonHDFullImagesActivity$initializeRecycler$1(NonHDFullImagesActivity nonHDFullImagesActivity) {
        this.this$0 = nonHDFullImagesActivity;
    }

    public void onImageViewClick(@NotNull View view, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.position = num != null ? num.intValue() : 0;
        this.this$0.mode = NonHDImagesMode.DEFAULT;
        this.this$0.updateUI();
    }
}
