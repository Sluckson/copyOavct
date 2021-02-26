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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, mo66933d2 = {"Lcom/iaai/android/bdt/model/filter/FilterData;", "Landroid/os/Parcelable;", "filterUIType", "", "displayText", "", "count", "filterValues", "", "Lcom/iaai/android/bdt/model/filter/FilterValues;", "filterId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisplayText", "()Ljava/lang/String;", "getFilterId", "getFilterUIType", "getFilterValues", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)Lcom/iaai/android/bdt/model/filter/FilterData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: FilterData.kt */
public final class FilterData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("count")
    @Nullable
    private final Integer count;
    @SerializedName("displayText")
    @Nullable
    private final String displayText;
    @SerializedName("filterId")
    @Nullable
    private final String filterId;
    @SerializedName("filterUIType")
    @Nullable
    private final Integer filterUIType;
    @SerializedName("filterValues")
    @Nullable
    private final List<FilterValues> filterValues;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString = parcel.readString();
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((FilterValues) FilterValues.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return new FilterData(valueOf, readString, valueOf2, arrayList, parcel.readString());
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new FilterData[i];
        }
    }

    @NotNull
    public static /* synthetic */ FilterData copy$default(FilterData filterData, Integer num, String str, Integer num2, List<FilterValues> list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = filterData.filterUIType;
        }
        if ((i & 2) != 0) {
            str = filterData.displayText;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            num2 = filterData.count;
        }
        Integer num3 = num2;
        if ((i & 8) != 0) {
            list = filterData.filterValues;
        }
        List<FilterValues> list2 = list;
        if ((i & 16) != 0) {
            str2 = filterData.filterId;
        }
        return filterData.copy(num, str3, num3, list2, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.filterUIType;
    }

    @Nullable
    public final String component2() {
        return this.displayText;
    }

    @Nullable
    public final Integer component3() {
        return this.count;
    }

    @Nullable
    public final List<FilterValues> component4() {
        return this.filterValues;
    }

    @Nullable
    public final String component5() {
        return this.filterId;
    }

    @NotNull
    public final FilterData copy(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable List<FilterValues> list, @Nullable String str2) {
        return new FilterData(num, str, num2, list, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterData)) {
            return false;
        }
        FilterData filterData = (FilterData) obj;
        return Intrinsics.areEqual((Object) this.filterUIType, (Object) filterData.filterUIType) && Intrinsics.areEqual((Object) this.displayText, (Object) filterData.displayText) && Intrinsics.areEqual((Object) this.count, (Object) filterData.count) && Intrinsics.areEqual((Object) this.filterValues, (Object) filterData.filterValues) && Intrinsics.areEqual((Object) this.filterId, (Object) filterData.filterId);
    }

    public int hashCode() {
        Integer num = this.filterUIType;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.displayText;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.count;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<FilterValues> list = this.filterValues;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.filterId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        return "FilterData(filterUIType=" + this.filterUIType + ", displayText=" + this.displayText + ", count=" + this.count + ", filterValues=" + this.filterValues + ", filterId=" + this.filterId + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Integer num = this.filterUIType;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.displayText);
        Integer num2 = this.count;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        List<FilterValues> list = this.filterValues;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (FilterValues writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.filterId);
    }

    public FilterData(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable List<FilterValues> list, @Nullable String str2) {
        this.filterUIType = num;
        this.displayText = str;
        this.count = num2;
        this.filterValues = list;
        this.filterId = str2;
    }

    @Nullable
    public final Integer getFilterUIType() {
        return this.filterUIType;
    }

    @Nullable
    public final String getDisplayText() {
        return this.displayText;
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    @Nullable
    public final List<FilterValues> getFilterValues() {
        return this.filterValues;
    }

    @Nullable
    public final String getFilterId() {
        return this.filterId;
    }
}
