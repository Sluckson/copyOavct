package com.iaai.android.bdt.feature.auctionSalesList;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.NewDateHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterSalesListActivity.kt */
final class FilterSalesListActivity$viewClickListener$12 implements View.OnClickListener {
    final /* synthetic */ FilterSalesListActivity this$0;

    FilterSalesListActivity$viewClickListener$12(FilterSalesListActivity filterSalesListActivity) {
        this.this$0 = filterSalesListActivity;
    }

    public final void onClick(View view) {
        this.this$0.isClearFilter = true;
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.et_start_year);
        Intrinsics.checkExpressionValueIsNotNull(textView, "et_start_year");
        textView.setHint("1900");
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.et_end_year);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "et_end_year");
        textView2.setHint(NewDateHelper.INSTANCE.getCurrentYear());
        TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.et_start_year);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "et_start_year");
        textView3.setText("");
        TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.et_end_year);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "et_end_year");
        textView4.setText("");
        this.this$0.lossTypeSelector(0);
        FilterSalesListActivity.access$getLaneAdapter$p(this.this$0).setSelected_position(0);
        this.this$0.setLane("");
        this.this$0.lossType = "";
        FilterSalesListActivity.access$getLaneAdapter$p(this.this$0).notifyDataSetChanged();
        TextView textView5 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_yearCount);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "tv_yearCount");
        textView5.setVisibility(8);
        TextView textView6 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_LaneCount);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "tv_LaneCount");
        textView6.setVisibility(8);
        TextView textView7 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_LossTypeCount);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "tv_LossTypeCount");
        textView7.setVisibility(8);
        TextView textView8 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvClearfilterSales);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "tvClearfilterSales");
        textView8.setVisibility(8);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cl_clearFilter_container);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cl_clearFilter_container");
        constraintLayout.setVisibility(8);
    }
}
