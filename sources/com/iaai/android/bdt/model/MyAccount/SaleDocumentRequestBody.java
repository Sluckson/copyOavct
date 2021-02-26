package com.iaai.android.bdt.model.MyAccount;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003JU\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006%"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentRequestBody;", "", "selectedSalvageSaleIds", "", "", "titleStatus", "pageNumber", "", "itemsPerPage", "sortColumn", "sortAscending", "", "branchcode", "(Ljava/util/List;Ljava/lang/String;IILjava/lang/String;ZI)V", "getBranchcode", "()I", "getItemsPerPage", "getPageNumber", "getSelectedSalvageSaleIds", "()Ljava/util/List;", "getSortAscending", "()Z", "getSortColumn", "()Ljava/lang/String;", "getTitleStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocumentRequestBody.kt */
public final class SaleDocumentRequestBody {
    private final int branchcode;
    private final int itemsPerPage;
    private final int pageNumber;
    @NotNull
    private final List<String> selectedSalvageSaleIds;
    private final boolean sortAscending;
    @NotNull
    private final String sortColumn;
    @NotNull
    private final String titleStatus;

    @NotNull
    public static /* synthetic */ SaleDocumentRequestBody copy$default(SaleDocumentRequestBody saleDocumentRequestBody, List<String> list, String str, int i, int i2, String str2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = saleDocumentRequestBody.selectedSalvageSaleIds;
        }
        if ((i4 & 2) != 0) {
            str = saleDocumentRequestBody.titleStatus;
        }
        String str3 = str;
        if ((i4 & 4) != 0) {
            i = saleDocumentRequestBody.pageNumber;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = saleDocumentRequestBody.itemsPerPage;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            str2 = saleDocumentRequestBody.sortColumn;
        }
        String str4 = str2;
        if ((i4 & 32) != 0) {
            z = saleDocumentRequestBody.sortAscending;
        }
        boolean z2 = z;
        if ((i4 & 64) != 0) {
            i3 = saleDocumentRequestBody.branchcode;
        }
        return saleDocumentRequestBody.copy(list, str3, i5, i6, str4, z2, i3);
    }

    @NotNull
    public final List<String> component1() {
        return this.selectedSalvageSaleIds;
    }

    @NotNull
    public final String component2() {
        return this.titleStatus;
    }

    public final int component3() {
        return this.pageNumber;
    }

    public final int component4() {
        return this.itemsPerPage;
    }

    @NotNull
    public final String component5() {
        return this.sortColumn;
    }

    public final boolean component6() {
        return this.sortAscending;
    }

    public final int component7() {
        return this.branchcode;
    }

    @NotNull
    public final SaleDocumentRequestBody copy(@NotNull List<String> list, @NotNull String str, int i, int i2, @NotNull String str2, boolean z, int i3) {
        Intrinsics.checkParameterIsNotNull(list, "selectedSalvageSaleIds");
        Intrinsics.checkParameterIsNotNull(str, "titleStatus");
        Intrinsics.checkParameterIsNotNull(str2, "sortColumn");
        return new SaleDocumentRequestBody(list, str, i, i2, str2, z, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SaleDocumentRequestBody) {
                SaleDocumentRequestBody saleDocumentRequestBody = (SaleDocumentRequestBody) obj;
                if (Intrinsics.areEqual((Object) this.selectedSalvageSaleIds, (Object) saleDocumentRequestBody.selectedSalvageSaleIds) && Intrinsics.areEqual((Object) this.titleStatus, (Object) saleDocumentRequestBody.titleStatus)) {
                    if (this.pageNumber == saleDocumentRequestBody.pageNumber) {
                        if ((this.itemsPerPage == saleDocumentRequestBody.itemsPerPage) && Intrinsics.areEqual((Object) this.sortColumn, (Object) saleDocumentRequestBody.sortColumn)) {
                            if (this.sortAscending == saleDocumentRequestBody.sortAscending) {
                                if (this.branchcode == saleDocumentRequestBody.branchcode) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        List<String> list = this.selectedSalvageSaleIds;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.titleStatus;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.valueOf(this.pageNumber).hashCode()) * 31) + Integer.valueOf(this.itemsPerPage).hashCode()) * 31;
        String str2 = this.sortColumn;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.sortAscending;
        if (z) {
            z = true;
        }
        return ((i2 + (z ? 1 : 0)) * 31) + Integer.valueOf(this.branchcode).hashCode();
    }

    @NotNull
    public String toString() {
        return "SaleDocumentRequestBody(selectedSalvageSaleIds=" + this.selectedSalvageSaleIds + ", titleStatus=" + this.titleStatus + ", pageNumber=" + this.pageNumber + ", itemsPerPage=" + this.itemsPerPage + ", sortColumn=" + this.sortColumn + ", sortAscending=" + this.sortAscending + ", branchcode=" + this.branchcode + ")";
    }

    public SaleDocumentRequestBody(@NotNull List<String> list, @NotNull String str, int i, int i2, @NotNull String str2, boolean z, int i3) {
        Intrinsics.checkParameterIsNotNull(list, "selectedSalvageSaleIds");
        Intrinsics.checkParameterIsNotNull(str, "titleStatus");
        Intrinsics.checkParameterIsNotNull(str2, "sortColumn");
        this.selectedSalvageSaleIds = list;
        this.titleStatus = str;
        this.pageNumber = i;
        this.itemsPerPage = i2;
        this.sortColumn = str2;
        this.sortAscending = z;
        this.branchcode = i3;
    }

    @NotNull
    public final List<String> getSelectedSalvageSaleIds() {
        return this.selectedSalvageSaleIds;
    }

    @NotNull
    public final String getTitleStatus() {
        return this.titleStatus;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getItemsPerPage() {
        return this.itemsPerPage;
    }

    @NotNull
    public final String getSortColumn() {
        return this.sortColumn;
    }

    public final boolean getSortAscending() {
        return this.sortAscending;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaleDocumentRequestBody(List list, String str, int i, int i2, String str2, boolean z, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, i, i2, str2, z, (i4 & 64) != 0 ? 0 : i3);
    }

    public final int getBranchcode() {
        return this.branchcode;
    }
}
