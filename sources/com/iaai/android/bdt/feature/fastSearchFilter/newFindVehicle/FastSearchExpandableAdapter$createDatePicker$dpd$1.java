package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/DatePicker;", "kotlin.jvm.PlatformType", "selectedYear", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "onDateSet"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchExpandableAdapter.kt */
final class FastSearchExpandableAdapter$createDatePicker$dpd$1 implements DatePickerDialog.OnDateSetListener {
    final /* synthetic */ int $groupPos;
    final /* synthetic */ boolean $isMin;
    final /* synthetic */ TextView $textView;
    final /* synthetic */ FastSearchExpandableAdapter this$0;

    FastSearchExpandableAdapter$createDatePicker$dpd$1(FastSearchExpandableAdapter fastSearchExpandableAdapter, TextView textView, boolean z, int i) {
        this.this$0 = fastSearchExpandableAdapter;
        this.$textView = textView;
        this.$isMin = z;
        this.$groupPos = i;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.$textView.setText(String.valueOf(i));
        if (this.$isMin) {
            this.this$0.minValYr = i;
        } else {
            this.this$0.maxValYr = i;
        }
        CharSequence text = this.$textView.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "textView.text");
        if (text.length() > 0) {
            FastSearchExpandableAdapter fastSearchExpandableAdapter = this.this$0;
            int i4 = this.$groupPos;
            fastSearchExpandableAdapter.updateListOnSelectItemForSlider(i4, "Year:" + this.this$0.minValYr + '-' + this.this$0.maxValYr);
        }
    }
}
