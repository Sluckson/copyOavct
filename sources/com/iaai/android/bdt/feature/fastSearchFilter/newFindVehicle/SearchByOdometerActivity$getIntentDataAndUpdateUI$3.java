package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.widget.EditText;
import com.google.android.material.slider.RangeSlider;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, mo66933d2 = {"<anonymous>", "", "rangeSlider", "Lcom/google/android/material/slider/RangeSlider;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "onValueChange"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByOdometerActivity.kt */
final class SearchByOdometerActivity$getIntentDataAndUpdateUI$3 implements RangeSlider.OnChangeListener {
    final /* synthetic */ SearchByOdometerActivity this$0;

    SearchByOdometerActivity$getIntentDataAndUpdateUI$3(SearchByOdometerActivity searchByOdometerActivity) {
        this.this$0 = searchByOdometerActivity;
    }

    public final void onValueChange(@NotNull RangeSlider rangeSlider, float f, boolean z) {
        Intrinsics.checkParameterIsNotNull(rangeSlider, "rangeSlider");
        if (!this.this$0.isFromEdit) {
            this.this$0.setSelectFilterEnabled(true);
            Float f2 = rangeSlider.getValues().get(0);
            Intrinsics.checkExpressionValueIsNotNull(f2, "rangeSlider.values[0]");
            int round = Math.round(f2.floatValue());
            Float f3 = rangeSlider.getValues().get(1);
            Intrinsics.checkExpressionValueIsNotNull(f3, "rangeSlider.values[1]");
            int round2 = Math.round(f3.floatValue());
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart)).setText(String.valueOf(round));
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etEnd)).setText(String.valueOf(round2));
            SearchByOdometerActivity searchByOdometerActivity = this.this$0;
            searchByOdometerActivity.setSlValue(searchByOdometerActivity.getSlValue().copy(Integer.valueOf(round), Integer.valueOf(round2)));
        }
    }
}
