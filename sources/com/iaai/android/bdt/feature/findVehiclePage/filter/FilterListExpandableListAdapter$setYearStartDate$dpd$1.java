package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/DatePicker;", "kotlin.jvm.PlatformType", "selyear", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "onDateSet"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterListExpandableListAdapter.kt */
final class FilterListExpandableListAdapter$setYearStartDate$dpd$1 implements DatePickerDialog.OnDateSetListener {
    final /* synthetic */ int $childPos;
    final /* synthetic */ String $endYear;
    final /* synthetic */ TextView $etFilterStartYear;
    final /* synthetic */ int $groupPos;
    final /* synthetic */ Ref.IntRef $year;
    final /* synthetic */ FilterListExpandableListAdapter this$0;

    FilterListExpandableListAdapter$setYearStartDate$dpd$1(FilterListExpandableListAdapter filterListExpandableListAdapter, Ref.IntRef intRef, TextView textView, String str, int i, int i2) {
        this.this$0 = filterListExpandableListAdapter;
        this.$year = intRef;
        this.$etFilterStartYear = textView;
        this.$endYear = str;
        this.$groupPos = i;
        this.$childPos = i2;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        Ref.IntRef intRef = this.$year;
        intRef.element = i;
        this.$etFilterStartYear.setText(String.valueOf(intRef.element));
        boolean z = true;
        if (!(this.$endYear.length() == 0)) {
            CharSequence text = this.$etFilterStartYear.getText();
            Intrinsics.checkExpressionValueIsNotNull(text, "etFilterStartYear.text");
            if (text.length() != 0) {
                z = false;
            }
            if (!z) {
                String str = this.$etFilterStartYear.getText() + '-' + this.$endYear;
                FilterListExpandableListAdapter.updateListOnSelectItem$default(this.this$0, this.$groupPos, this.$childPos, str, 0, 8, (Object) null);
                this.this$0.getOnItemClickListener().onChildItemClick(this.$groupPos, this.$childPos, str);
            }
        }
    }
}
