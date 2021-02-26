package com.iaai.android.bdt.feature.myAccount.toBePaid;

import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/TempRequestBody;", "", "pageNumber", "", "count", "paymentMethod", "", "sortBy", "sortAsc", "onlymyitems", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCount", "()I", "getOnlymyitems", "()Ljava/lang/String;", "getPageNumber", "getPaymentMethod", "getSortAsc", "getSortBy", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: TempRequestBody.kt */
public final class TempRequestBody {
    private final int count;
    @NotNull
    private final String onlymyitems;
    private final int pageNumber;
    @NotNull
    private final String paymentMethod;
    @NotNull
    private final String sortAsc;
    @NotNull
    private final String sortBy;

    @NotNull
    public static /* synthetic */ TempRequestBody copy$default(TempRequestBody tempRequestBody, int i, int i2, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tempRequestBody.pageNumber;
        }
        if ((i3 & 2) != 0) {
            i2 = tempRequestBody.count;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = tempRequestBody.paymentMethod;
        }
        String str5 = str;
        if ((i3 & 8) != 0) {
            str2 = tempRequestBody.sortBy;
        }
        String str6 = str2;
        if ((i3 & 16) != 0) {
            str3 = tempRequestBody.sortAsc;
        }
        String str7 = str3;
        if ((i3 & 32) != 0) {
            str4 = tempRequestBody.onlymyitems;
        }
        return tempRequestBody.copy(i, i4, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.pageNumber;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final String component3() {
        return this.paymentMethod;
    }

    @NotNull
    public final String component4() {
        return this.sortBy;
    }

    @NotNull
    public final String component5() {
        return this.sortAsc;
    }

    @NotNull
    public final String component6() {
        return this.onlymyitems;
    }

    @NotNull
    public final TempRequestBody copy(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "paymentMethod");
        Intrinsics.checkParameterIsNotNull(str2, Constants_MVVM.EXTRA_SORT_BY);
        Intrinsics.checkParameterIsNotNull(str3, "sortAsc");
        Intrinsics.checkParameterIsNotNull(str4, "onlymyitems");
        return new TempRequestBody(i, i2, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof TempRequestBody) {
                TempRequestBody tempRequestBody = (TempRequestBody) obj;
                if (this.pageNumber == tempRequestBody.pageNumber) {
                    if (!(this.count == tempRequestBody.count) || !Intrinsics.areEqual((Object) this.paymentMethod, (Object) tempRequestBody.paymentMethod) || !Intrinsics.areEqual((Object) this.sortBy, (Object) tempRequestBody.sortBy) || !Intrinsics.areEqual((Object) this.sortAsc, (Object) tempRequestBody.sortAsc) || !Intrinsics.areEqual((Object) this.onlymyitems, (Object) tempRequestBody.onlymyitems)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = ((Integer.valueOf(this.pageNumber).hashCode() * 31) + Integer.valueOf(this.count).hashCode()) * 31;
        String str = this.paymentMethod;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.sortBy;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.sortAsc;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.onlymyitems;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        return "TempRequestBody(pageNumber=" + this.pageNumber + ", count=" + this.count + ", paymentMethod=" + this.paymentMethod + ", sortBy=" + this.sortBy + ", sortAsc=" + this.sortAsc + ", onlymyitems=" + this.onlymyitems + ")";
    }

    public TempRequestBody(int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "paymentMethod");
        Intrinsics.checkParameterIsNotNull(str2, Constants_MVVM.EXTRA_SORT_BY);
        Intrinsics.checkParameterIsNotNull(str3, "sortAsc");
        Intrinsics.checkParameterIsNotNull(str4, "onlymyitems");
        this.pageNumber = i;
        this.count = i2;
        this.paymentMethod = str;
        this.sortBy = str2;
        this.sortAsc = str3;
        this.onlymyitems = str4;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @NotNull
    public final String getSortBy() {
        return this.sortBy;
    }

    @NotNull
    public final String getSortAsc() {
        return this.sortAsc;
    }

    @NotNull
    public final String getOnlymyitems() {
        return this.onlymyitems;
    }
}
