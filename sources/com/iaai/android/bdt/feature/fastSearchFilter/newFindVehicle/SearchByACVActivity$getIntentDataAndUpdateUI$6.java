package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByACVActivity.kt */
final class SearchByACVActivity$getIntentDataAndUpdateUI$6 implements View.OnFocusChangeListener {
    final /* synthetic */ SearchByACVActivity this$0;

    SearchByACVActivity$getIntentDataAndUpdateUI$6(SearchByACVActivity searchByACVActivity) {
        this.this$0 = searchByACVActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        boolean z2 = false;
        boolean z3 = true;
        if (!z) {
            this.this$0.isFromEdit = true;
            EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etEnd);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etEnd");
            Editable text = editText.getText();
            Intrinsics.checkExpressionValueIsNotNull(text, "etEnd.text");
            if (text.length() > 0) {
                z2 = true;
            }
            if (z2) {
                this.this$0.setSelectFilterEnabled(true);
                SearchByACVActivity searchByACVActivity = this.this$0;
                EditText editText2 = (EditText) searchByACVActivity._$_findCachedViewById(C2723R.C2726id.etEnd);
                Intrinsics.checkExpressionValueIsNotNull(editText2, "etEnd");
                searchByACVActivity.setMaxInputValue(String_ExtensionKt.resetFormattedString(editText2.getText().toString()));
                SearchByACVActivity searchByACVActivity2 = this.this$0;
                searchByACVActivity2.setSlValue(Pair.copy$default(searchByACVActivity2.getSlValue(), (Object) null, Integer.valueOf(this.this$0.getMaxInputValue()), 1, (Object) null));
                this.this$0.sliderEditTextUpdate();
                return;
            }
            return;
        }
        EditText editText3 = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "etEnd");
        if (editText3.getText().toString().length() <= 0) {
            z3 = false;
        }
        if (z3) {
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel2);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivCancel2");
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel2);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivCancel2");
        imageView2.setVisibility(8);
    }
}
