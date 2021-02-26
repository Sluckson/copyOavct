package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByDistanceActivity.kt */
final class SearchByDistanceActivity$getIntentDataAndUpdateUI$4 implements View.OnClickListener {
    final /* synthetic */ SearchByDistanceActivity this$0;

    SearchByDistanceActivity$getIntentDataAndUpdateUI$4(SearchByDistanceActivity searchByDistanceActivity) {
        this.this$0 = searchByDistanceActivity;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etPostalValue);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etPostalValue");
        editText.getText().clear();
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "ivCancel");
        imageView.setVisibility(8);
        this.this$0.setSelectFilterEnabled(false);
    }
}
