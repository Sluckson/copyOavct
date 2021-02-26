package com.iaai.android.bdt.feature.productDetail.costCalculator;

import android.view.View;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorFragment.kt */
final class CostCalculatorFragment$onActivityCreated$3 implements View.OnClickListener {
    final /* synthetic */ CostCalculatorFragment this$0;

    CostCalculatorFragment$onActivityCreated$3(CostCalculatorFragment costCalculatorFragment) {
        this.this$0 = costCalculatorFragment;
    }

    public final void onClick(View view) {
        AppUtils.hideSoftkeyBoard(CostCalculatorFragment.access$getBaseActivity$p(this.this$0), view);
        IAASharedPreference.setEstimateCostValue(CostCalculatorFragment.access$getBaseActivity$p(this.this$0), this.this$0.bidAmount, this.this$0.itemId);
        this.this$0.checkNetworkConnection();
    }
}
