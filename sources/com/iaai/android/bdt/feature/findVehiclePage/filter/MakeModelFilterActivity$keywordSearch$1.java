package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelFilterActivity.kt */
final class MakeModelFilterActivity$keywordSearch$1 implements TextView.OnEditorActionListener {
    final /* synthetic */ MakeModelFilterActivity this$0;

    MakeModelFilterActivity$keywordSearch$1(MakeModelFilterActivity makeModelFilterActivity) {
        this.this$0 = makeModelFilterActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etMakeModelFilterSearch);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etMakeModelFilterSearch");
        Editable text = editText.getText();
        if (text != null) {
            this.this$0.getSearchInfo((SpannableStringBuilder) text);
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.text.SpannableStringBuilder");
    }
}
