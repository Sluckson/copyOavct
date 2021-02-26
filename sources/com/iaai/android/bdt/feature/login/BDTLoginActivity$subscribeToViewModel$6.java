package com.iaai.android.bdt.feature.login;

import android.content.Intent;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.feature.login.emailValidation.EmailConfirmationActivity;
import com.iaai.android.bdt.utils.ActivityRequestCode;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLoginActivity.kt */
final class BDTLoginActivity$subscribeToViewModel$6<T> implements Observer<Boolean> {
    final /* synthetic */ BDTLoginActivity this$0;

    BDTLoginActivity$subscribeToViewModel$6(BDTLoginActivity bDTLoginActivity) {
        this.this$0 = bDTLoginActivity;
    }

    public final void onChanged(Boolean bool) {
        String tag = this.this$0.getTAG();
        Log.e(tag, "valid email success: " + bool);
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        if (bool.booleanValue()) {
            SessionManager sessionManager = this.this$0.getSessionManager();
            BDTLoginActivity bDTLoginActivity = this.this$0;
            sessionManager.setLoginResponseOnSuccess(bDTLoginActivity, BDTLoginActivity.access$getLoginResponse$p(bDTLoginActivity), this.this$0.getUsername(), this.this$0.getPassword());
            if (!IAASharedPreference.getTncFlagFromPrefs(this.this$0)) {
                Intent intent = new Intent(this.this$0, BDTTermsOfUseActivity.class);
                intent.putExtra("come_from", TermsOfUseOrigin.FROM_LOGIN.getValue());
                this.this$0.startActivityForResult(intent, ActivityRequestCode.FROM_LOGIN_TO_TERMS_AND_CONDITIONS.getValue());
                return;
            }
            this.this$0.getViewModel().getTermsOfUseAuctionRule(this.this$0.getUsername(), this.this$0.getPassword());
            return;
        }
        Intent intent2 = new Intent(this.this$0, EmailConfirmationActivity.class);
        intent2.putExtra("userID", this.this$0.getUserId());
        intent2.putExtra(Constants_MVVM.EXTRA_EMAIL_ID, this.this$0.getUsername());
        this.this$0.startActivityForResult(intent2, ActivityRequestCode.FROM_LOGIN_TO_EMAIL_CONFIRMATION.getValue());
    }
}
