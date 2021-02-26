package com.iaai.android.bdt.model.auctionSalesList;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R:\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(\u0018\u00010'j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(\u0018\u0001`)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\b¨\u00064"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;", "", "()V", "auctionDate", "", "getAuctionDate", "()Ljava/lang/String;", "setAuctionDate", "(Ljava/lang/String;)V", "auctionDetails", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;", "getAuctionDetails", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;", "setAuctionDetails", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;)V", "branchName", "getBranchName", "setBranchName", "errorMessage", "getErrorMessage", "setErrorMessage", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "getErrorType", "()Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "setErrorType", "(Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;)V", "filterCount", "", "getFilterCount", "()I", "setFilterCount", "(I)V", "isError", "", "()Z", "setError", "(Z)V", "selectedRefinerHashMap", "Ljava/util/LinkedHashMap;", "Lcom/iaai/android/bdt/model/fastSearch/SelectedRefinerV2;", "Lkotlin/collections/LinkedHashMap;", "getSelectedRefinerHashMap", "()Ljava/util/LinkedHashMap;", "setSelectedRefinerHashMap", "(Ljava/util/LinkedHashMap;)V", "timeZone", "getTimeZone", "setTimeZone", "vehicalCount", "getVehicalCount", "setVehicalCount", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListHeader.kt */
public final class AuctionSalesListHeader {
    @NotNull
    public String auctionDate;
    @Nullable
    private AuctionDetails auctionDetails;
    @NotNull
    public String branchName;
    @NotNull
    public String errorMessage;
    @NotNull
    public BaseFragment.ErrorType errorType;
    private int filterCount;
    private boolean isError;
    @Nullable
    private LinkedHashMap<String, SelectedRefinerV2> selectedRefinerHashMap;
    @NotNull
    public String timeZone;
    @NotNull
    public String vehicalCount;

    public final int getFilterCount() {
        return this.filterCount;
    }

    public final void setFilterCount(int i) {
        this.filterCount = i;
    }

    @NotNull
    public final String getBranchName() {
        String str = this.branchName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("branchName");
        }
        return str;
    }

    public final void setBranchName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.branchName = str;
    }

    @NotNull
    public final String getVehicalCount() {
        String str = this.vehicalCount;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicalCount");
        }
        return str;
    }

    public final void setVehicalCount(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.vehicalCount = str;
    }

    @NotNull
    public final String getAuctionDate() {
        String str = this.auctionDate;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDate");
        }
        return str;
    }

    public final void setAuctionDate(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.auctionDate = str;
    }

    @NotNull
    public final String getTimeZone() {
        String str = this.timeZone;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        }
        return str;
    }

    public final void setTimeZone(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.timeZone = str;
    }

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

    @Nullable
    public final AuctionDetails getAuctionDetails() {
        return this.auctionDetails;
    }

    public final void setAuctionDetails(@Nullable AuctionDetails auctionDetails2) {
        this.auctionDetails = auctionDetails2;
    }

    @Nullable
    public final LinkedHashMap<String, SelectedRefinerV2> getSelectedRefinerHashMap() {
        return this.selectedRefinerHashMap;
    }

    public final void setSelectedRefinerHashMap(@Nullable LinkedHashMap<String, SelectedRefinerV2> linkedHashMap) {
        this.selectedRefinerHashMap = linkedHashMap;
    }
}
