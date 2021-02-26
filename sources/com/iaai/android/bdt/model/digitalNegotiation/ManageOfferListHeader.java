package com.iaai.android.bdt.model.digitalNegotiation;

import com.iaai.android.bdt.base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferListHeader;", "", "()V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "getErrorType", "()Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "setErrorType", "(Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;)V", "isError", "", "()Z", "setError", "(Z)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListHeader.kt */
public final class ManageOfferListHeader {
    @NotNull
    public String errorMessage;
    @NotNull
    public BaseFragment.ErrorType errorType;
    private boolean isError;

    @NotNull
    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorMessage");
        }
        return str;
    }

    public final void setErrorMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errorMessage = str;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final void setError(boolean z) {
        this.isError = z;
    }

    @NotNull
    public final BaseFragment.ErrorType getErrorType() {
        BaseFragment.ErrorType errorType2 = this.errorType;
        if (errorType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorType");
        }
        return errorType2;
    }

    public final void setErrorType(@NotNull BaseFragment.ErrorType errorType2) {
        Intrinsics.checkParameterIsNotNull(errorType2, "<set-?>");
        this.errorType = errorType2;
    }
}
