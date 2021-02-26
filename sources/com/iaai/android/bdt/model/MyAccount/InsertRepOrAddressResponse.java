package com.iaai.android.bdt.model.MyAccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressResponse;", "", "Success", "", "Error", "", "(ZLjava/lang/String;)V", "getError", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddressResponse.kt */
public final class InsertRepOrAddressResponse {
    @NotNull
    private final String Error;
    private final boolean Success;

    @NotNull
    public static /* synthetic */ InsertRepOrAddressResponse copy$default(InsertRepOrAddressResponse insertRepOrAddressResponse, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = insertRepOrAddressResponse.Success;
        }
        if ((i & 2) != 0) {
            str = insertRepOrAddressResponse.Error;
        }
        return insertRepOrAddressResponse.copy(z, str);
    }

    public final boolean component1() {
        return this.Success;
    }

    @NotNull
    public final String component2() {
        return this.Error;
    }

    @NotNull
    public final InsertRepOrAddressResponse copy(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        return new InsertRepOrAddressResponse(z, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof InsertRepOrAddressResponse) {
                InsertRepOrAddressResponse insertRepOrAddressResponse = (InsertRepOrAddressResponse) obj;
                if (!(this.Success == insertRepOrAddressResponse.Success) || !Intrinsics.areEqual((Object) this.Error, (Object) insertRepOrAddressResponse.Error)) {
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
        String str = this.Error;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "InsertRepOrAddressResponse(Success=" + this.Success + ", Error=" + this.Error + ")";
    }

    public InsertRepOrAddressResponse(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        this.Success = z;
        this.Error = str;
    }

    public final boolean getSuccess() {
        return this.Success;
    }

    @NotNull
    public final String getError() {
        return this.Error;
    }
}
