package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterListExpandableListAdapter.kt */
final class FilterListExpandableListAdapter$getChildView$2 implements View.OnClickListener {
    final /* synthetic */ TextView $etFilterEndYear;
    final /* synthetic */ TextView $etFilterStartYear;
    final /* synthetic */ int $expandedListPosition;
    final /* synthetic */ int $listPosition;
    final /* synthetic */ FilterListExpandableListAdapter this$0;

    FilterListExpandableListAdapter$getChildView$2(FilterListExpandableListAdapter filterListExpandableListAdapter, TextView textView, int i, int i2, TextView textView2) {
        this.this$0 = filterListExpandableListAdapter;
        this.$etFilterStartYear = textView;
        this.$listPosition = i;
        this.$expandedListPosition = i2;
        this.$etFilterEndYear = textView2;
    }

    public final void onClick(View view) {
        FilterListExpandableListAdapter filterListExpandableListAdapter = this.this$0;
        TextView textView = this.$etFilterStartYear;
        Intrinsics.checkExpressionValueIsNotNull(textView, "etFilterStartYear");
        int i = this.$listPosition;
        int i2 = this.$expandedListPosition;
        TextView textView2 = this.$etFilterEndYear;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "etFilterEndYear");
        CharSequence text = textView2.getText();
        if (text != null) {
            filterListExpandableListAdapter.setYearStartDate(textView, i, i2, (String) text);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
}
