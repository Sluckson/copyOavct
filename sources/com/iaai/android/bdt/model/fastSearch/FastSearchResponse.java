package com.iaai.android.bdt.model.fastSearch;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001B[\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0002\u0010\u0012J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003Jo\u0010(\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\fHÆ\u0001J\u0013\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000eHÖ\u0001J\t\u0010,\u001a\u00020\fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001b¨\u0006-"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/FastSearchResponse;", "", "Breadcrumbs", "", "Lcom/iaai/android/bdt/model/fastSearch/BreadcrumbsArray;", "Refiners", "Lcom/iaai/android/bdt/model/fastSearch/Refiner;", "SearchInput", "Lcom/iaai/android/bdt/model/fastSearch/SearchInput;", "SortAscending", "", "SortField", "", "TotalVehicleCount", "", "Vehicles", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "error", "(Ljava/util/List;Ljava/util/List;Lcom/iaai/android/bdt/model/fastSearch/SearchInput;ZLjava/lang/String;ILjava/util/List;Ljava/lang/String;)V", "getBreadcrumbs", "()Ljava/util/List;", "getRefiners", "getSearchInput", "()Lcom/iaai/android/bdt/model/fastSearch/SearchInput;", "getSortAscending", "()Z", "getSortField", "()Ljava/lang/String;", "getTotalVehicleCount", "()I", "getVehicles", "getError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchResponse.kt */
public final class FastSearchResponse {
    @NotNull
    private final List<BreadcrumbsArray> Breadcrumbs;
    @Nullable
    private final List<Refiner> Refiners;
    @NotNull
    private final SearchInput SearchInput;
    private final boolean SortAscending;
    @NotNull
    private final String SortField;
    private final int TotalVehicleCount;
    @Nullable
    private final List<Vehicle> Vehicles;
    @NotNull
    private final String error;

    @NotNull
    public static /* synthetic */ FastSearchResponse copy$default(FastSearchResponse fastSearchResponse, List list, List list2, SearchInput searchInput, boolean z, String str, int i, List list3, String str2, int i2, Object obj) {
        FastSearchResponse fastSearchResponse2 = fastSearchResponse;
        int i3 = i2;
        return fastSearchResponse.copy((i3 & 1) != 0 ? fastSearchResponse2.Breadcrumbs : list, (i3 & 2) != 0 ? fastSearchResponse2.Refiners : list2, (i3 & 4) != 0 ? fastSearchResponse2.SearchInput : searchInput, (i3 & 8) != 0 ? fastSearchResponse2.SortAscending : z, (i3 & 16) != 0 ? fastSearchResponse2.SortField : str, (i3 & 32) != 0 ? fastSearchResponse2.TotalVehicleCount : i, (i3 & 64) != 0 ? fastSearchResponse2.Vehicles : list3, (i3 & 128) != 0 ? fastSearchResponse2.error : str2);
    }

    @NotNull
    public final List<BreadcrumbsArray> component1() {
        return this.Breadcrumbs;
    }

    @Nullable
    public final List<Refiner> component2() {
        return this.Refiners;
    }

    @NotNull
    public final SearchInput component3() {
        return this.SearchInput;
    }

    public final boolean component4() {
        return this.SortAscending;
    }

    @NotNull
    public final String component5() {
        return this.SortField;
    }

    public final int component6() {
        return this.TotalVehicleCount;
    }

    @Nullable
    public final List<Vehicle> component7() {
        return this.Vehicles;
    }

    @NotNull
    public final String component8() {
        return this.error;
    }

    @NotNull
    public final FastSearchResponse copy(@NotNull List<BreadcrumbsArray> list, @Nullable List<Refiner> list2, @NotNull SearchInput searchInput, boolean z, @NotNull String str, int i, @Nullable List<Vehicle> list3, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(list, "Breadcrumbs");
        Intrinsics.checkParameterIsNotNull(searchInput, "SearchInput");
        Intrinsics.checkParameterIsNotNull(str, "SortField");
        String str3 = str2;
        Intrinsics.checkParameterIsNotNull(str3, "error");
        return new FastSearchResponse(list, list2, searchInput, z, str, i, list3, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FastSearchResponse) {
                FastSearchResponse fastSearchResponse = (FastSearchResponse) obj;
                if (Intrinsics.areEqual((Object) this.Breadcrumbs, (Object) fastSearchResponse.Breadcrumbs) && Intrinsics.areEqual((Object) this.Refiners, (Object) fastSearchResponse.Refiners) && Intrinsics.areEqual((Object) this.SearchInput, (Object) fastSearchResponse.SearchInput)) {
                    if ((this.SortAscending == fastSearchResponse.SortAscending) && Intrinsics.areEqual((Object) this.SortField, (Object) fastSearchResponse.SortField)) {
                        if (!(this.TotalVehicleCount == fastSearchResponse.TotalVehicleCount) || !Intrinsics.areEqual((Object) this.Vehicles, (Object) fastSearchResponse.Vehicles) || !Intrinsics.areEqual((Object) this.error, (Object) fastSearchResponse.error)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        List<BreadcrumbsArray> list = this.Breadcrumbs;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Refiner> list2 = this.Refiners;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        SearchInput searchInput = this.SearchInput;
        int hashCode3 = (hashCode2 + (searchInput != null ? searchInput.hashCode() : 0)) * 31;
        boolean z = this.SortAscending;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str = this.SortField;
        int hashCode4 = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + Integer.valueOf(this.TotalVehicleCount).hashCode()) * 31;
        List<Vehicle> list3 = this.Vehicles;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str2 = this.error;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        return "FastSearchResponse(Breadcrumbs=" + this.Breadcrumbs + ", Refiners=" + this.Refiners + ", SearchInput=" + this.SearchInput + ", SortAscending=" + this.SortAscending + ", SortField=" + this.SortField + ", TotalVehicleCount=" + this.TotalVehicleCount + ", Vehicles=" + this.Vehicles + ", error=" + this.error + ")";
    }

    public FastSearchResponse(@NotNull List<BreadcrumbsArray> list, @Nullable List<Refiner> list2, @NotNull SearchInput searchInput, boolean z, @NotNull String str, int i, @Nullable List<Vehicle> list3, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(list, "Breadcrumbs");
        Intrinsics.checkParameterIsNotNull(searchInput, "SearchInput");
        Intrinsics.checkParameterIsNotNull(str, "SortField");
        Intrinsics.checkParameterIsNotNull(str2, "error");
        this.Breadcrumbs = list;
        this.Refiners = list2;
        this.SearchInput = searchInput;
        this.SortAscending = z;
        this.SortField = str;
        this.TotalVehicleCount = i;
        this.Vehicles = list3;
        this.error = str2;
    }

    @NotNull
    public final List<BreadcrumbsArray> getBreadcrumbs() {
        return this.Breadcrumbs;
    }

    @Nullable
    public final List<Refiner> getRefiners() {
        return this.Refiners;
    }

    @NotNull
    public final SearchInput getSearchInput() {
        return this.SearchInput;
    }

    public final boolean getSortAscending() {
        return this.SortAscending;
    }

    @NotNull
    public final String getSortField() {
        return this.SortField;
    }

    public final int getTotalVehicleCount() {
        return this.TotalVehicleCount;
    }

    @Nullable
    public final List<Vehicle> getVehicles() {
        return this.Vehicles;
    }

    @NotNull
    public final String getError() {
        return this.error;
    }
}
