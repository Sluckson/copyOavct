package com.iaai.android.bdt.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/login/GenerateOTPResponse;", "", "Error", "", "RowsAffected", "", "Success", "", "(Ljava/lang/String;IZ)V", "getError", "()Ljava/lang/String;", "getRowsAffected", "()I", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: GenerateOTPResponse.kt */
public final class GenerateOTPResponse {
    @NotNull
    private final String Error;
    private final int RowsAffected;
    private final boolean Success;

    @NotNull
    public static /* synthetic */ GenerateOTPResponse copy$default(GenerateOTPResponse generateOTPResponse, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = generateOTPResponse.Error;
        }
        if ((i2 & 2) != 0) {
            i = generateOTPResponse.RowsAffected;
        }
        if ((i2 & 4) != 0) {
            z = generateOTPResponse.Success;
        }
        return generateOTPResponse.copy(str, i, z);
    }

    @NotNull
    public final String component1() {
        return this.Error;
    }

    public final int component2() {
        return this.RowsAffected;
    }

    public final boolean component3() {
        return this.Success;
    }

    @NotNull
    public final GenerateOTPResponse copy(@NotNull String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        return new GenerateOTPResponse(str, i, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof GenerateOTPResponse) {
                GenerateOTPResponse generateOTPResponse = (GenerateOTPResponse) obj;
                if (Intrinsics.areEqual((Object) this.Error, (Object) generateOTPResponse.Error)) {
                    if (this.RowsAffected == generateOTPResponse.RowsAffected) {
                        if (this.Success == generateOTPResponse.Success) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.Error;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.RowsAffected).hashCode()) * 31;
        boolean z = this.Success;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "GenerateOTPResponse(Error=" + this.Error + ", RowsAffected=" + this.RowsAffected + ", Success=" + this.Success + ")";
    }

    public GenerateOTPResponse(@NotNull String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        this.Error = str;
        this.RowsAffected = i;
        this.Success = z;
    }

    @NotNull
    public final String getError() {
        return this.Error;
    }

    public final int getRowsAffected() {
        return this.RowsAffected;
    }

    public final boolean getSuccess() {
        return this.Success;
    }
}
