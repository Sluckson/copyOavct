package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByOdometerActivity.kt */
final class SearchByOdometerActivity$getIntentDataAndUpdateUI$11 implements View.OnClickListener {
    final /* synthetic */ SearchByOdometerActivity this$0;

    SearchByOdometerActivity$getIntentDataAndUpdateUI$11(SearchByOdometerActivity searchByOdometerActivity) {
        this.this$0 = searchByOdometerActivity;
    }

    public final void onClick(View view) {
        SearchByOdometerActivity searchByOdometerActivity = this.this$0;
        Pair<Integer, Integer> slValue = searchByOdometerActivity.getSlValue();
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etStart");
        Integer valueOf = Integer.valueOf(Integer.parseInt(editText.getText().toString()));
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etEnd");
        searchByOdometerActivity.setSlValue(slValue.copy(valueOf, Integer.valueOf(Integer.parseInt(editText2.getText().toString()))));
        if (this.this$0.getSlValue().getFirst().intValue() >= this.this$0.getSlValue().getSecond().intValue()) {
            SearchByOdometerActivity searchByOdometerActivity2 = this.this$0;
            int access$getParentPosition$p = searchByOdometerActivity2.parentPosition;
            StringBuilder sb = new StringBuilder();
            sb.append(this.this$0.getSlValue().getSecond().intValue());
            sb.append('-');
            sb.append(this.this$0.getSlValue().getFirst().intValue());
            searchByOdometerActivity2.updateListOnSelectItemForSlider(access$getParentPosition$p, sb.toString());
        } else {
            SearchByOdometerActivity searchByOdometerActivity3 = this.this$0;
            int access$getParentPosition$p2 = searchByOdometerActivity3.parentPosition;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.this$0.getSlValue().getFirst().intValue());
            sb2.append('-');
            sb2.append(this.this$0.getSlValue().getSecond().intValue());
            searchByOdometerActivity3.updateListOnSelectItemForSlider(access$getParentPosition$p2, sb2.toString());
        }
        this.this$0.hideKeyboard();
        this.this$0.setResult(-1, new Intent());
        this.this$0.finish();
    }
}
