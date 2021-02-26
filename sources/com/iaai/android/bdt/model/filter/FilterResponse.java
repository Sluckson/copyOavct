package com.iaai.android.bdt.model.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fHÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/filter/FilterResponse;", "Landroid/os/Parcelable;", "filterData", "", "Lcom/iaai/android/bdt/model/filter/FilterData;", "(Ljava/util/List;)V", "getFilterData", "()Ljava/util/List;", "setFilterData", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: FilterResponse.kt */
public final class FilterResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("FilterData")
    @NotNull
    private List<FilterData> filterData;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((FilterData) FilterData.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new FilterResponse(arrayList);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new FilterResponse[i];
        }
    }

    @NotNull
    public static /* synthetic */ FilterResponse copy$default(FilterResponse filterResponse, List<FilterData> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = filterResponse.filterData;
        }
        return filterResponse.copy(list);
    }

    @NotNull
    public final List<FilterData> component1() {
        return this.filterData;
    }

    @NotNull
    public final FilterResponse copy(@NotNull List<FilterData> list) {
        Intrinsics.checkParameterIsNotNull(list, "filterData");
        return new FilterResponse(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof FilterResponse) && Intrinsics.areEqual((Object) this.filterData, (Object) ((FilterResponse) obj).filterData);
        }
        return true;
    }

    public int hashCode() {
        List<FilterData> list = this.filterData;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "FilterResponse(filterData=" + this.filterData + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        List<FilterData> list = this.filterData;
        parcel.writeInt(list.size());
        for (FilterData writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public FilterResponse(@NotNull List<FilterData> list) {
        Intrinsics.checkParameterIsNotNull(list, "filterData");
        this.filterData = list;
    }

    @NotNull
    public final List<FilterData> getFilterData() {
        return this.filterData;
    }

    public final void setFilterData(@NotNull List<FilterData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.filterData = list;
    }
}
