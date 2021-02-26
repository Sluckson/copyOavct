package com.iaai.android.bdt.feature.login.emailValidation;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.login.GenerateOTPResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/login/GenerateOTPResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ValidateOTPActivity.kt */
final class ValidateOTPActivity$subscribeToViewModel$4<T> implements Observer<GenerateOTPResponse> {
    final /* synthetic */ ValidateOTPActivity this$0;

    ValidateOTPActivity$subscribeToViewModel$4(ValidateOTPActivity validateOTPActivity) {
        this.this$0 = validateOTPActivity;
    }

    public final void onChanged(GenerateOTPResponse generateOTPResponse) {
        String tag = this.this$0.getTAG();
        Log.e(tag, "Generate OTP: " + generateOTPResponse.getSuccess());
        if (generateOTPResponse.getSuccess()) {
            ValidateOTPActivity validateOTPActivity = this.this$0;
            String string = validateOTPActivity.getResources().getString(C2723R.string.toast_resend_msg, new Object[]{this.this$0.newID});
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st….toast_resend_msg, newID)");
            Context_ExtensionKt.showToast(validateOTPActivity, string);
            return;
        }
        Context_ExtensionKt.showToast(this.this$0, generateOTPResponse.getError());
    }
}
