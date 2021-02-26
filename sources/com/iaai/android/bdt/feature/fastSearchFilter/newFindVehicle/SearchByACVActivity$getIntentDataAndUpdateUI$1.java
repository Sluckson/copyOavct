package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.widget.EditText;
import com.google.android.material.slider.RangeSlider;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, mo66933d2 = {"<anonymous>", "", "rangeSlider", "Lcom/google/android/material/slider/RangeSlider;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "onValueChange"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByACVActivity.kt */
final class SearchByACVActivity$getIntentDataAndUpdateUI$1 implements RangeSlider.OnChangeListener {
    final /* synthetic */ SearchByACVActivity this$0;

    SearchByACVActivity$getIntentDataAndUpdateUI$1(SearchByACVActivity searchByACVActivity) {
        this.this$0 = searchByACVActivity;
    }

    public final void onValueChange(@NotNull RangeSlider rangeSlider, float f, boolean z) {
        Intrinsics.checkParameterIsNotNull(rangeSlider, "rangeSlider");
        if (!this.this$0.isFromEdit) {
            this.this$0.setSelectFilterEnabled(true);
            if (!Intrinsics.areEqual(this.this$0.getSliderStartVal(), rangeSlider.getValues().get(0))) {
                Float f2 = rangeSlider.getValues().get(0);
                Intrinsics.checkExpressionValueIsNotNull(f2, "rangeSlider.values[0]");
                int round = Math.round(f2.floatValue());
                ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart)).setText(Typography.dollar + String_ExtensionKt.getFormattedString(String.valueOf(round)));
                SearchByACVActivity searchByACVActivity = this.this$0;
                searchByACVActivity.setSlValue(Pair.copy$default(searchByACVActivity.getSlValue(), Integer.valueOf(round), (Object) null, 2, (Object) null));
                SearchByACVActivity searchByACVActivity2 = this.this$0;
                Float f3 = rangeSlider.getValues().get(0);
                Intrinsics.checkExpressionValueIsNotNull(f3, "rangeSlider.values[0]");
                searchByACVActivity2.setSliderStartVal(f3.floatValue());
            }
            if (!Intrinsics.areEqual(this.this$0.getSliderEndVal(), rangeSlider.getValues().get(1))) {
                Float f4 = rangeSlider.getValues().get(1);
                Intrinsics.checkExpressionValueIsNotNull(f4, "rangeSlider.values[1]");
                int round2 = Math.round(f4.floatValue());
                ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etEnd)).setText(Typography.dollar + String_ExtensionKt.getFormattedString(String.valueOf(round2)));
                SearchByACVActivity searchByACVActivity3 = this.this$0;
                searchByACVActivity3.setSlValue(Pair.copy$default(searchByACVActivity3.getSlValue(), (Object) null, Integer.valueOf(round2), 1, (Object) null));
                SearchByACVActivity searchByACVActivity4 = this.this$0;
                Float f5 = rangeSlider.getValues().get(1);
                Intrinsics.checkExpressionValueIsNotNull(f5, "rangeSlider.values[1]");
                searchByACVActivity4.setSliderEndVal(f5.floatValue());
            }
        }
    }
}
