package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import com.google.android.material.slider.RangeSlider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/SearchByACVActivity$getIntentDataAndUpdateUI$2", "Lcom/google/android/material/slider/RangeSlider$OnSliderTouchListener;", "onStartTrackingTouch", "", "slider", "Lcom/google/android/material/slider/RangeSlider;", "onStopTrackingTouch", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchByACVActivity.kt */
public final class SearchByACVActivity$getIntentDataAndUpdateUI$2 implements RangeSlider.OnSliderTouchListener {
    final /* synthetic */ SearchByACVActivity this$0;

    SearchByACVActivity$getIntentDataAndUpdateUI$2(SearchByACVActivity searchByACVActivity) {
        this.this$0 = searchByACVActivity;
    }

    public void onStartTrackingTouch(@NotNull RangeSlider rangeSlider) {
        Intrinsics.checkParameterIsNotNull(rangeSlider, "slider");
        this.this$0.isFromEdit = false;
    }

    public void onStopTrackingTouch(@NotNull RangeSlider rangeSlider) {
        Intrinsics.checkParameterIsNotNull(rangeSlider, "slider");
        this.this$0.isFromEdit = false;
    }
}
