package com.iaai.android.bdt.feature.productDetail.costCalculator;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.costCalculator.CostCalculatorResponse;
import com.iaai.android.bdt.model.productDetail.costCalculator.CostList;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/productDetail/costCalculator/CostCalculatorResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorFragment.kt */
final class CostCalculatorFragment$subscribeToViewModel$2<T> implements Observer<CostCalculatorResponse> {
    final /* synthetic */ CostCalculatorFragment this$0;

    CostCalculatorFragment$subscribeToViewModel$2(CostCalculatorFragment costCalculatorFragment) {
        this.this$0 = costCalculatorFragment;
    }

    public final void onChanged(CostCalculatorResponse costCalculatorResponse) {
        List<CostList> list;
        if (this.this$0.isAdded()) {
            String access$getTAG$p = this.this$0.TAG;
            Log.e(access$getTAG$p, "CostCalculator: " + costCalculatorResponse + ')');
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_cost_value);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_cost_value");
            String str = null;
            textView.setText(costCalculatorResponse != null ? costCalculatorResponse.getStrEstimatedFinalCost() : null);
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvValueTotalCost);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvValueTotalCost");
            textView2.setText(costCalculatorResponse != null ? costCalculatorResponse.getStrEstimatedFinalCost() : null);
            Context access$getBaseActivity$p = CostCalculatorFragment.access$getBaseActivity$p(this.this$0);
            if (costCalculatorResponse != null) {
                str = costCalculatorResponse.getStrEstimatedFinalCost();
            }
            IAASharedPreference.setEstimateFinalCostValue(access$getBaseActivity$p, str, this.this$0.itemId);
            CostCalculatorFragment costCalculatorFragment = this.this$0;
            if (costCalculatorResponse == null || (list = costCalculatorResponse.getCostList()) == null) {
                list = CollectionsKt.emptyList();
            }
            costCalculatorFragment.updateCostBreakDownUI(list);
        }
    }
}
