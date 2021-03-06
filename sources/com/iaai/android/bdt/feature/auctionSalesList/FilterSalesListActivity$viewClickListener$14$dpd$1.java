package com.iaai.android.bdt.feature.auctionSalesList;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/DatePicker;", "kotlin.jvm.PlatformType", "selyear", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "onDateSet"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterSalesListActivity.kt */
final class FilterSalesListActivity$viewClickListener$14$dpd$1 implements DatePickerDialog.OnDateSetListener {
    final /* synthetic */ Ref.IntRef $year;
    final /* synthetic */ FilterSalesListActivity$viewClickListener$14 this$0;

    FilterSalesListActivity$viewClickListener$14$dpd$1(FilterSalesListActivity$viewClickListener$14 filterSalesListActivity$viewClickListener$14, Ref.IntRef intRef) {
        this.this$0 = filterSalesListActivity$viewClickListener$14;
        this.$year = intRef;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.$year.element = i;
        TextView textView = (TextView) this.this$0.this$0._$_findCachedViewById(C2723R.C2726id.et_end_year);
        Intrinsics.checkExpressionValueIsNotNull(textView, "et_end_year");
        textView.setText(String.valueOf(this.$year.element));
        TextView textView2 = (TextView) this.this$0.this$0._$_findCachedViewById(C2723R.C2726id.tv_year_error);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_year_error");
        if (textView2.getVisibility() == 0) {
            TextView textView3 = (TextView) this.this$0.this$0._$_findCachedViewById(C2723R.C2726id.tv_year_error);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_year_error");
            textView3.setVisibility(8);
        }
        if (this.this$0.this$0.startYear == 0) {
            TextView textView4 = (TextView) this.this$0.this$0._$_findCachedViewById(C2723R.C2726id.tv_yearCount);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_yearCount");
            textView4.setVisibility(8);
        } else {
            TextView textView5 = (TextView) this.this$0.this$0._$_findCachedViewById(C2723R.C2726id.tv_yearCount);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "tv_yearCount");
            textView5.setVisibility(0);
        }
        this.this$0.this$0.endYear = this.$year.element;
    }
}
