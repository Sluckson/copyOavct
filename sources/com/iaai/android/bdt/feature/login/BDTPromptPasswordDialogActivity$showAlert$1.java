package com.iaai.android.bdt.feature.login;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/feature/login/BDTPromptPasswordDialogActivity$showAlert$1", "Lcom/iaai/android/bdt/feature/login/EnteredPasswordCallback;", "getPassword", "", "enterPassword", "", "onDialogClose", "onForgotPassword", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTPromptPasswordDialogActivity.kt */
public final class BDTPromptPasswordDialogActivity$showAlert$1 implements EnteredPasswordCallback {
    final /* synthetic */ BDTPromptPasswordDialogActivity this$0;

    BDTPromptPasswordDialogActivity$showAlert$1(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity) {
        this.this$0 = bDTPromptPasswordDialogActivity;
    }

    public void getPassword(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "enterPassword");
        this.this$0.setPassword(str);
        this.this$0.getViewModel().login(this.this$0.getUsername(), this.this$0.getPassword());
    }

    public void onDialogClose() {
        this.this$0.getPromptPasswordDialog().dismiss();
        this.this$0.finish();
    }

    public void onForgotPassword() {
        Intent intent = new Intent(this.this$0, BDTForgotPasswordActivity.class);
        intent.putExtra("username", this.this$0.getUsername());
        this.this$0.startActivity(intent);
    }
}
