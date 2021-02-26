package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.View;
import android.widget.EditText;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByACVActivity.kt */
final class SearchByACVActivity$getIntentDataAndUpdateUI$11 implements View.OnClickListener {
    final /* synthetic */ SearchByACVActivity this$0;

    SearchByACVActivity$getIntentDataAndUpdateUI$11(SearchByACVActivity searchByACVActivity) {
        this.this$0 = searchByACVActivity;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etEnd");
        editText.getText().clear();
        SearchByACVActivity searchByACVActivity = this.this$0;
        searchByACVActivity.setMaxInputValue((int) searchByACVActivity.maxValue);
        this.this$0.setSelectFilterEnabled(false);
    }
}
