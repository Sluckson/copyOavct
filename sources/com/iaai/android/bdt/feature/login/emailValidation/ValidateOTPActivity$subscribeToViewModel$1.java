package com.iaai.android.bdt.feature.login.emailValidation;

import android.app.Dialog;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.model.login.GenerateOTPResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/login/GenerateOTPResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ValidateOTPActivity.kt */
final class ValidateOTPActivity$subscribeToViewModel$1<T> implements Observer<GenerateOTPResponse> {
    final /* synthetic */ ValidateOTPActivity this$0;

    ValidateOTPActivity$subscribeToViewModel$1(ValidateOTPActivity validateOTPActivity) {
        this.this$0 = validateOTPActivity;
    }

    public final void onChanged(GenerateOTPResponse generateOTPResponse) {
        String tag = this.this$0.getTAG();
        Log.e(tag, "Validate OTP: " + generateOTPResponse.getSuccess());
        if (generateOTPResponse.getSuccess()) {
            this.this$0.setResult(-1);
            this.this$0.finish();
            return;
        }
        ValidateOTPActivity validateOTPActivity = this.this$0;
        String string = validateOTPActivity.getResources().getString(C2723R.string.txt_verification_failed);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st….txt_verification_failed)");
        String string2 = this.this$0.getResources().getString(C2723R.string.msg_verification_failed);
        Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.st….msg_verification_failed)");
        Dialog showAlert = Activity_ExtensionKt.showAlert(validateOTPActivity, string, string2);
        if (showAlert != null) {
            showAlert.show();
        }
    }
}
