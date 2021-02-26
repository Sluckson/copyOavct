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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JN\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0019¨\u0006,"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/filter/FilterValues;", "Landroid/os/Parcelable;", "displayText", "", "count", "", "filterSubValues", "", "Lcom/iaai/android/bdt/model/filter/FilterSubValues;", "valuesId", "isSelected", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Z)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisplayText", "()Ljava/lang/String;", "getFilterSubValues", "()Ljava/util/List;", "()Z", "setSelected", "(Z)V", "getValuesId", "setValuesId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Z)Lcom/iaai/android/bdt/model/filter/FilterValues;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: FilterValues.kt */
public final class FilterValues implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("count")
    @Nullable
    private final Integer count;
    @SerializedName("displayText")
    @Nullable
    private final String displayText;
    @SerializedName("filterSubValues")
    @Nullable
    private final List<FilterSubValues> filterSubValues;
    @SerializedName("isSelected")
    private boolean isSelected;
    @SerializedName("valuesId")
    @Nullable
    private String valuesId;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            String readString = parcel.readString();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((FilterSubValues) FilterSubValues.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return new FilterValues(readString, valueOf, arrayList, parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new FilterValues[i];
        }
    }

    @NotNull
    public static /* synthetic */ FilterValues copy$default(FilterValues filterValues, String str, Integer num, List<FilterSubValues> list, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filterValues.displayText;
        }
        if ((i & 2) != 0) {
            num = filterValues.count;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            list = filterValues.filterSubValues;
        }
        List<FilterSubValues> list2 = list;
        if ((i & 8) != 0) {
            str2 = filterValues.valuesId;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            z = filterValues.isSelected;
        }
        return filterValues.copy(str, num2, list2, str3, z);
    }

    @Nullable
    public final String component1() {
        return this.displayText;
    }

    @Nullable
    public final Integer component2() {
        return this.count;
    }

    @Nullable
    public final List<FilterSubValues> component3() {
        return this.filterSubValues;
    }

    @Nullable
    public final String component4() {
        return this.valuesId;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    @NotNull
    public final FilterValues copy(@Nullable String str, @Nullable Integer num, @Nullable List<FilterSubValues> list, @Nullable String str2, boolean z) {
        return new FilterValues(str, num, list, str2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FilterValues) {
                FilterValues filterValues = (FilterValues) obj;
                if (Intrinsics.areEqual((Object) this.displayText, (Object) filterValues.displayText) && Intrinsics.areEqual((Object) this.count, (Object) filterValues.count) && Intrinsics.areEqual((Object) this.filterSubValues, (Object) filterValues.filterSubValues) && Intrinsics.areEqual((Object) this.valuesId, (Object) filterValues.valuesId)) {
                    if (this.isSelected == filterValues.isSelected) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.displayText;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.count;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        List<FilterSubValues> list = this.filterSubValues;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.valuesId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "FilterValues(displayText=" + this.displayText + ", count=" + this.count + ", filterSubValues=" + this.filterSubValues + ", valuesId=" + this.valuesId + ", isSelected=" + this.isSelected + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.displayText);
        Integer num = this.count;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        List<FilterSubValues> list = this.filterSubValues;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (FilterSubValues writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.valuesId);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public FilterValues(@Nullable String str, @Nullable Integer num, @Nullable List<FilterSubValues> list, @Nullable String str2, boolean z) {
        this.displayText = str;
        this.count = num;
        this.filterSubValues = list;
        this.valuesId = str2;
        this.isSelected = z;
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
    public final List<FilterSubValues> getFilterSubValues() {
        return this.filterSubValues;
    }

    @Nullable
    public final String getValuesId() {
        return this.valuesId;
    }

    public final void setValuesId(@Nullable String str) {
        this.valuesId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterValues(String str, Integer num, List list, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num, list, str2, (i & 16) != 0 ? false : z);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
