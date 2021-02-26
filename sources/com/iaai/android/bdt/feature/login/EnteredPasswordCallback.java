package com.iaai.android.bdt.feature.login;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/EnteredPasswordCallback;", "", "getPassword", "", "password", "", "onDialogClose", "onForgotPassword", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PromptPasswordDialog.kt */
public interface EnteredPasswordCallback {
    void getPassword(@NotNull String str);

    void onDialogClose();

    void onForgotPassword();
}
