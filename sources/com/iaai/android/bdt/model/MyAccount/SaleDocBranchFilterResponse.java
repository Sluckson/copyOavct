package com.iaai.android.bdt.model.MyAccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/SaleDocBranchFilterResponse;", "", "BranchCode", "", "BranchName", "", "BranchItemCount", "(ILjava/lang/String;I)V", "getBranchCode", "()I", "getBranchItemCount", "getBranchName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocBranchFilterResponse.kt */
public final class SaleDocBranchFilterResponse {
    private final int BranchCode;
    private final int BranchItemCount;
    @NotNull
    private final String BranchName;

    @NotNull
    public static /* synthetic */ SaleDocBranchFilterResponse copy$default(SaleDocBranchFilterResponse saleDocBranchFilterResponse, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = saleDocBranchFilterResponse.BranchCode;
        }
        if ((i3 & 2) != 0) {
            str = saleDocBranchFilterResponse.BranchName;
        }
        if ((i3 & 4) != 0) {
            i2 = saleDocBranchFilterResponse.BranchItemCount;
        }
        return saleDocBranchFilterResponse.copy(i, str, i2);
    }

    public final int component1() {
        return this.BranchCode;
    }

    @NotNull
    public final String component2() {
        return this.BranchName;
    }

    public final int component3() {
        return this.BranchItemCount;
    }

    @NotNull
    public final SaleDocBranchFilterResponse copy(int i, @NotNull String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "BranchName");
        return new SaleDocBranchFilterResponse(i, str, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SaleDocBranchFilterResponse) {
                SaleDocBranchFilterResponse saleDocBranchFilterResponse = (SaleDocBranchFilterResponse) obj;
                if ((this.BranchCode == saleDocBranchFilterResponse.BranchCode) && Intrinsics.areEqual((Object) this.BranchName, (Object) saleDocBranchFilterResponse.BranchName)) {
                    if (this.BranchItemCount == saleDocBranchFilterResponse.BranchItemCount) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.BranchCode).hashCode() * 31;
        String str = this.BranchName;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.valueOf(this.BranchItemCount).hashCode();
    }

    @NotNull
    public String toString() {
        return "SaleDocBranchFilterResponse(BranchCode=" + this.BranchCode + ", BranchName=" + this.BranchName + ", BranchItemCount=" + this.BranchItemCount + ")";
    }

    public SaleDocBranchFilterResponse(int i, @NotNull String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "BranchName");
        this.BranchCode = i;
        this.BranchName = str;
        this.BranchItemCount = i2;
    }

    public final int getBranchCode() {
        return this.BranchCode;
    }

    @NotNull
    public final String getBranchName() {
        return this.BranchName;
    }

    public final int getBranchItemCount() {
        return this.BranchItemCount;
    }
}
