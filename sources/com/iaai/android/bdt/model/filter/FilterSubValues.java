package com.iaai.android.bdt.model.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/filter/FilterSubValues;", "Landroid/os/Parcelable;", "displayText", "", "valuesId", "count", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisplayText", "()Ljava/lang/String;", "getValuesId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/filter/FilterSubValues;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: FilterSubValues.kt */
public final class FilterSubValues implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("count")
    @Nullable
    private final Integer count;
    @SerializedName("displayText")
    @Nullable
    private final String displayText;
    @SerializedName("valuesId")
    @Nullable
    private final String valuesId;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new FilterSubValues(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new FilterSubValues[i];
        }
    }

    @NotNull
    public static /* synthetic */ FilterSubValues copy$default(FilterSubValues filterSubValues, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filterSubValues.displayText;
        }
        if ((i & 2) != 0) {
            str2 = filterSubValues.valuesId;
        }
        if ((i & 4) != 0) {
            num = filterSubValues.count;
        }
        return filterSubValues.copy(str, str2, num);
    }

    @Nullable
    public final String component1() {
        return this.displayText;
    }

    @Nullable
    public final String component2() {
        return this.valuesId;
    }

    @Nullable
    public final Integer component3() {
        return this.count;
    }

    @NotNull
    public final FilterSubValues copy(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        return new FilterSubValues(str, str2, num);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterSubValues)) {
            return false;
        }
        FilterSubValues filterSubValues = (FilterSubValues) obj;
        return Intrinsics.areEqual((Object) this.displayText, (Object) filterSubValues.displayText) && Intrinsics.areEqual((Object) this.valuesId, (Object) filterSubValues.valuesId) && Intrinsics.areEqual((Object) this.count, (Object) filterSubValues.count);
    }

    public int hashCode() {
        String str = this.displayText;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.valuesId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.count;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "FilterSubValues(displayText=" + this.displayText + ", valuesId=" + this.valuesId + ", count=" + this.count + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.displayText);
        parcel.writeString(this.valuesId);
        Integer num = this.count;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    public FilterSubValues(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.displayText = str;
        this.valuesId = str2;
        this.count = num;
    }

    @Nullable
    public final String getDisplayText() {
        return this.displayText;
    }

    @Nullable
    public final String getValuesId() {
        return this.valuesId;
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }
}
