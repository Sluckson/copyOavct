package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchMoreFilterActivity.kt */
final class FastSearchMoreFilterActivity$getIntentDataAndUpdateUI$4 implements View.OnClickListener {
    final /* synthetic */ FastSearchMoreFilterActivity this$0;

    FastSearchMoreFilterActivity$getIntentDataAndUpdateUI$4(FastSearchMoreFilterActivity fastSearchMoreFilterActivity) {
        this.this$0 = fastSearchMoreFilterActivity;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etSubFilterSearch);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etSubFilterSearch");
        editText.getText().clear();
        FastSearchMoreFilterActivity.access$getFastSearchMoreFilterAdapter$p(this.this$0).facetXXData(FastSearchMoreFilterActivity.access$getFacetXX$p(this.this$0), this.this$0.facetType, this.this$0.parentPosition);
        FastSearchMoreFilterActivity.access$getFastSearchMoreFilterAdapter$p(this.this$0).notifyDataSetChanged();
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "ivCancel");
        imageView.setVisibility(8);
    }
}
