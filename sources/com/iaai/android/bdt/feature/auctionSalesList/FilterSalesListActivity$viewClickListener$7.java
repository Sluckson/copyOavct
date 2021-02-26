package com.iaai.android.bdt.feature.auctionSalesList;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterSalesListActivity.kt */
final class FilterSalesListActivity$viewClickListener$7 implements View.OnClickListener {
    final /* synthetic */ FilterSalesListActivity this$0;

    FilterSalesListActivity$viewClickListener$7(FilterSalesListActivity filterSalesListActivity) {
        this.this$0 = filterSalesListActivity;
    }

    public final void onClick(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cl_year_container);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cl_year_container");
        if (constraintLayout.getVisibility() == 0) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cl_year_container);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "cl_year_container");
            constraintLayout2.setVisibility(8);
            ((ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.iv_arrow_down)).setImageResource(C2723R.C2725drawable.ic_chevron_right);
            return;
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cl_year_container);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "cl_year_container");
        constraintLayout3.setVisibility(0);
        ((ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.iv_arrow_down)).setImageResource(C2723R.C2725drawable.ic_view_down);
        ((ConstraintLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cl_year_container)).startAnimation(AnimationUtils.loadAnimation(this.this$0.getApplicationContext(), C2723R.anim.animation_slide_down));
    }
}
