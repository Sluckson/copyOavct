package com.iaai.android.bdt.feature.auctionSalesList;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterSalesListActivity.kt */
final class FilterSalesListActivity$viewClickListener$13 implements View.OnClickListener {
    final /* synthetic */ FilterSalesListActivity this$0;

    FilterSalesListActivity$viewClickListener$13(FilterSalesListActivity filterSalesListActivity) {
        this.this$0 = filterSalesListActivity;
    }

    public final void onClick(View view) {
        Calendar instance = Calendar.getInstance();
        instance.add(1, -10);
        int i = instance.get(5);
        int i2 = instance.get(2);
        Ref.IntRef intRef = new Ref.IntRef();
        String startYearFilterPreferencesMVVM = IAASharedPreference.getStartYearFilterPreferencesMVVM(this.this$0.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(startYearFilterPreferencesMVVM, "IAASharedPreference.getS…sMVVM(applicationContext)");
        if (!(startYearFilterPreferencesMVVM.length() == 0) || this.this$0.startYear != 0) {
            intRef.element = this.this$0.startYear;
        } else {
            intRef.element = instance.get(1);
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.this$0, 16973939, new FilterSalesListActivity$viewClickListener$13$dpd$1(this, intRef), intRef.element, i2, i);
        DatePicker datePicker = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker, "dpd.datePicker");
        datePicker.setMaxDate(new Date().getTime());
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(this.this$0.getResources().getColor(C2723R.C2724color.bdt_transparent)));
        datePickerDialog.show();
        DatePicker datePicker2 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker2, "dpd.datePicker");
        datePicker2.setDescendantFocusability(393216);
        DatePicker datePicker3 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker3, "picker");
        datePicker3.setCalendarViewShown(false);
        NumberPicker numberPicker = (NumberPicker) datePicker3.findViewById(Resources.getSystem().getIdentifier("day", "id", "android"));
        NumberPicker numberPicker2 = (NumberPicker) datePicker3.findViewById(Resources.getSystem().getIdentifier("month", "id", "android"));
        if (numberPicker != null && numberPicker2 != null) {
            numberPicker.setVisibility(8);
            numberPicker2.setVisibility(8);
        }
    }
}
