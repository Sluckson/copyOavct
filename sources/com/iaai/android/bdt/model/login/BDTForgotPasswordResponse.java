package com.iaai.android.bdt.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/login/BDTForgotPasswordResponse;", "", "Success", "", "Url", "", "errorMessage", "(ZLjava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getUrl", "()Ljava/lang/String;", "getErrorMessage", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTForgotPasswordResponse.kt */
public final class BDTForgotPasswordResponse {
    private final boolean Success;
    @NotNull
    private final String Url;
    @NotNull
    private final String errorMessage;

    @NotNull
    public static /* synthetic */ BDTForgotPasswordResponse copy$default(BDTForgotPasswordResponse bDTForgotPasswordResponse, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bDTForgotPasswordResponse.Success;
        }
        if ((i & 2) != 0) {
            str = bDTForgotPasswordResponse.Url;
        }
        if ((i & 4) != 0) {
            str2 = bDTForgotPasswordResponse.errorMessage;
        }
        return bDTForgotPasswordResponse.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.Success;
    }

    @NotNull
    public final String component2() {
        return this.Url;
    }

    @NotNull
    public final String component3() {
        return this.errorMessage;
    }

    @NotNull
    public final BDTForgotPasswordResponse copy(boolean z, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "Url");
        Intrinsics.checkParameterIsNotNull(str2, "errorMessage");
        return new BDTForgotPasswordResponse(z, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BDTForgotPasswordResponse) {
                BDTForgotPasswordResponse bDTForgotPasswordResponse = (BDTForgotPasswordResponse) obj;
                if (!(this.Success == bDTForgotPasswordResponse.Success) || !Intrinsics.areEqual((Object) this.Url, (Object) bDTForgotPasswordResponse.Url) || !Intrinsics.areEqual((Object) this.errorMessage, (Object) bDTForgotPasswordResponse.errorMessage)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.Success;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.Url;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.errorMessage;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        return "BDTForgotPasswordResponse(Success=" + this.Success + ", Url=" + this.Url + ", errorMessage=" + this.errorMessage + ")";
    }

    public BDTForgotPasswordResponse(boolean z, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "Url");
        Intrinsics.checkParameterIsNotNull(str2, "errorMessage");
        this.Success = z;
        this.Url = str;
        this.errorMessage = str2;
    }

    public final boolean getSuccess() {
        return this.Success;
    }

    @NotNull
    public final String getUrl() {
        return this.Url;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
