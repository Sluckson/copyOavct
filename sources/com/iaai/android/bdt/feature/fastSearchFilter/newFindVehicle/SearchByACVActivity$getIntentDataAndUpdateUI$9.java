package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import com.iaai.android.bdt.utils.BDTUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByACVActivity.kt */
final class SearchByACVActivity$getIntentDataAndUpdateUI$9 implements View.OnClickListener {
    final /* synthetic */ SearchByACVActivity this$0;

    SearchByACVActivity$getIntentDataAndUpdateUI$9(SearchByACVActivity searchByACVActivity) {
        this.this$0 = searchByACVActivity;
    }

    public final void onClick(View view) {
        SearchByACVActivity searchByACVActivity = this.this$0;
        EditText editText = (EditText) searchByACVActivity._$_findCachedViewById(C2723R.C2726id.etStart);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etStart");
        searchByACVActivity.setMinInputValue(String_ExtensionKt.resetFormattedString(editText.getText().toString()));
        SearchByACVActivity searchByACVActivity2 = this.this$0;
        EditText editText2 = (EditText) searchByACVActivity2._$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etEnd");
        searchByACVActivity2.setMaxInputValue(String_ExtensionKt.resetFormattedString(editText2.getText().toString()));
        SearchByACVActivity searchByACVActivity3 = this.this$0;
        searchByACVActivity3.setSlValue(searchByACVActivity3.getSlValue().copy(Integer.valueOf(this.this$0.getMinInputValue()), Integer.valueOf(this.this$0.getMaxInputValue())));
        if (this.this$0.getSlValue().getFirst().intValue() >= this.this$0.getSlValue().getSecond().intValue()) {
            SearchByACVActivity searchByACVActivity4 = this.this$0;
            StringBuilder sb = new StringBuilder();
            sb.append(this.this$0.getSlValue().getSecond().intValue());
            sb.append('-');
            sb.append(this.this$0.getSlValue().getFirst().intValue());
            searchByACVActivity4.updateListOnSelectItemForSlider(searchByACVActivity4.parentPosition, this.this$0.getFacetName() + " $" + BDTUtils.INSTANCE.getFormattedNumber(this.this$0.getSlValue().getSecond().intValue()) + "-$" + BDTUtils.INSTANCE.getFormattedNumber(this.this$0.getSlValue().getFirst().intValue()), sb.toString());
        } else {
            SearchByACVActivity searchByACVActivity5 = this.this$0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.this$0.getSlValue().getFirst().intValue());
            sb2.append('-');
            sb2.append(this.this$0.getSlValue().getSecond().intValue());
            searchByACVActivity5.updateListOnSelectItemForSlider(searchByACVActivity5.parentPosition, this.this$0.getFacetName() + " $" + BDTUtils.INSTANCE.getFormattedNumber(this.this$0.getSlValue().getFirst().intValue()) + "-$" + BDTUtils.INSTANCE.getFormattedNumber(this.this$0.getSlValue().getSecond().intValue()), sb2.toString());
        }
        this.this$0.hideKeyboard();
        this.this$0.setResult(-1, new Intent());
        this.this$0.finish();
    }
}
