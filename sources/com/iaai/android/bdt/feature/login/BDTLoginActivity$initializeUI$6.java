package com.iaai.android.bdt.feature.login;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLoginActivity.kt */
final class BDTLoginActivity$initializeUI$6 implements View.OnClickListener {
    final /* synthetic */ BDTLoginActivity this$0;

    BDTLoginActivity$initializeUI$6(BDTLoginActivity bDTLoginActivity) {
        this.this$0 = bDTLoginActivity;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etUserName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etUserName");
        String obj = editText.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            Intent intent = new Intent(this.this$0, BDTForgotPasswordActivity.class);
            intent.putExtra("username", obj);
            this.this$0.startActivity(intent);
            return;
        }
        BDTLoginActivity bDTLoginActivity = this.this$0;
        String string = bDTLoginActivity.getResources().getString(C2723R.string.lbl_forgot_password);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.lbl_forgot_password)");
        String string2 = this.this$0.getResources().getString(C2723R.string.enter_user_name);
        Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.string.enter_user_name)");
        Dialog showAlert = Activity_ExtensionKt.showAlert(bDTLoginActivity, string, string2);
        if (showAlert != null) {
            showAlert.show();
        }
    }
}
