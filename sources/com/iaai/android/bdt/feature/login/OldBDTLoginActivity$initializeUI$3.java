package com.iaai.android.bdt.feature.login;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: OldBDTLoginActivity.kt */
final class OldBDTLoginActivity$initializeUI$3 implements View.OnClickListener {
    final /* synthetic */ OldBDTLoginActivity this$0;

    OldBDTLoginActivity$initializeUI$3(OldBDTLoginActivity oldBDTLoginActivity) {
        this.this$0 = oldBDTLoginActivity;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etUserName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etUserName");
        Editable text = editText.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "etUserName.text");
        if (text.length() > 0) {
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etUserName)).setText("");
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivClear);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivClear");
            imageView.setVisibility(8);
        }
    }
}
