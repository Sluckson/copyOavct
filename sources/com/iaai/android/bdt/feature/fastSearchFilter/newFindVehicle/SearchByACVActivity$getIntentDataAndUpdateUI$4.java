package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchByACVActivity.kt */
final class SearchByACVActivity$getIntentDataAndUpdateUI$4 implements TextView.OnEditorActionListener {
    final /* synthetic */ SearchByACVActivity this$0;

    SearchByACVActivity$getIntentDataAndUpdateUI$4(SearchByACVActivity searchByACVActivity) {
        this.this$0 = searchByACVActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i != 6) {
            return false;
        }
        this.this$0.isFromEdit = true;
        this.this$0.hideKeyboard();
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etEnd");
        Editable text = editText.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "etEnd.text");
        if (text.length() > 0) {
            z = true;
        }
        if (z) {
            EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etEnd);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "etEnd");
            if (editText2.getText().length() > 1) {
                this.this$0.setSelectFilterEnabled(true);
                SearchByACVActivity searchByACVActivity = this.this$0;
                EditText editText3 = (EditText) searchByACVActivity._$_findCachedViewById(C2723R.C2726id.etEnd);
                Intrinsics.checkExpressionValueIsNotNull(editText3, "etEnd");
                searchByACVActivity.setMaxInputValue(String_ExtensionKt.resetFormattedString(editText3.getText().toString()));
                SearchByACVActivity searchByACVActivity2 = this.this$0;
                searchByACVActivity2.setSlValue(Pair.copy$default(searchByACVActivity2.getSlValue(), (Object) null, Integer.valueOf(this.this$0.getMaxInputValue()), 1, (Object) null));
                this.this$0.sliderEditTextUpdate();
            }
        }
        return true;
    }
}
