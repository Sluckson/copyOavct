package com.iaai.android.bdt.feature.login.emailValidation;

import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.model.login.GenerateOTPResponse;
import com.iaai.android.bdt.utils.ActivityRequestCode;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/login/GenerateOTPResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: EmailConfirmationActivity.kt */
final class EmailConfirmationActivity$subscribeToViewModel$1<T> implements Observer<GenerateOTPResponse> {
    final /* synthetic */ EmailConfirmationActivity this$0;

    EmailConfirmationActivity$subscribeToViewModel$1(EmailConfirmationActivity emailConfirmationActivity) {
        this.this$0 = emailConfirmationActivity;
    }

    public final void onChanged(GenerateOTPResponse generateOTPResponse) {
        String tag = this.this$0.getTAG();
        Log.e(tag, "Email Confirmation: " + generateOTPResponse.getSuccess());
        if (generateOTPResponse.getSuccess()) {
            Intent intent = new Intent(this.this$0, ValidateOTPActivity.class);
            intent.putExtra("userID", this.this$0.userId);
            intent.putExtra(Constants_MVVM.EXTRA_EMAIL_ID, this.this$0.email);
            intent.putExtra(Constants_MVVM.EXTRA_NEW_LOGIN_ID, this.this$0.newID);
            this.this$0.startActivityForResult(intent, ActivityRequestCode.FROM_EMAIL_CONFIRMATION_TO_VALIDATE_OTP.getValue());
            return;
        }
        EmailConfirmationActivity emailConfirmationActivity = this.this$0;
        String string = emailConfirmationActivity.getResources().getString(C2723R.string.txt_invalid_email);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.txt_invalid_email)");
        Dialog showAlert = Activity_ExtensionKt.showAlert(emailConfirmationActivity, string, generateOTPResponse.getError());
        if (showAlert != null) {
            showAlert.show();
        }
    }
}
