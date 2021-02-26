package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.res.Resources;
import android.util.Log;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.BDTUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
final class FilterFragment$subscribeToViewModelToCount$1<T> implements Observer<Integer> {
    final /* synthetic */ FilterFragment this$0;

    FilterFragment$subscribeToViewModelToCount$1(FilterFragment filterFragment) {
        this.this$0 = filterFragment;
    }

    public final void onChanged(Integer num) {
        Log.e("fastSearchResultCount", "Count: " + num);
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_applyfilter);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_applyfilter");
        Resources resources = this.this$0.getResources();
        BDTUtils bDTUtils = BDTUtils.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(num, "it");
        textView.setText(resources.getString(C2723R.string.see_results, new Object[]{bDTUtils.getCountDisplay(num.intValue())}));
    }
}
