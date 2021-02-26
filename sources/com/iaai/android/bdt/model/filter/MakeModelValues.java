package com.iaai.android.bdt.model.filter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0006HÆ\u0003JR\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020\tHÖ\u0001J\u0013\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\tHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00008\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r¨\u0006."}, mo66933d2 = {"Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "Landroid/os/Parcelable;", "displayText", "", "valuesId", "isMake", "", "makeInfo", "filterCount", "", "isSelected", "(Ljava/lang/String;Ljava/lang/String;ZLcom/iaai/android/bdt/model/filter/MakeModelValues;Ljava/lang/Integer;Z)V", "getDisplayText", "()Ljava/lang/String;", "setDisplayText", "(Ljava/lang/String;)V", "getFilterCount", "()Ljava/lang/Integer;", "setFilterCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Z", "setSelected", "(Z)V", "getMakeInfo", "()Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "getValuesId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLcom/iaai/android/bdt/model/filter/MakeModelValues;Ljava/lang/Integer;Z)Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: MakeModelValues.kt */
public final class MakeModelValues implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("displayText")
    @Nullable
    private String displayText;
    @SerializedName("filterCount")
    @Nullable
    private Integer filterCount;
    @SerializedName("isMake")
    private final boolean isMake;
    @SerializedName("isSelected")
    private boolean isSelected;
    @SerializedName("makeInfo")
    @Nullable
    private final MakeModelValues makeInfo;
    @SerializedName("valuesId")
    @Nullable
    private final String valuesId;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            Integer num = null;
            MakeModelValues makeModelValues = parcel.readInt() != 0 ? (MakeModelValues) MakeModelValues.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new MakeModelValues(readString, readString2, z, makeModelValues, num, parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new MakeModelValues[i];
        }
    }

    @NotNull
    public static /* synthetic */ MakeModelValues copy$default(MakeModelValues makeModelValues, String str, String str2, boolean z, MakeModelValues makeModelValues2, Integer num, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = makeModelValues.displayText;
        }
        if ((i & 2) != 0) {
            str2 = makeModelValues.valuesId;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = makeModelValues.isMake;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            makeModelValues2 = makeModelValues.makeInfo;
        }
        MakeModelValues makeModelValues3 = makeModelValues2;
        if ((i & 16) != 0) {
            num = makeModelValues.filterCount;
        }
        Integer num2 = num;
        if ((i & 32) != 0) {
            z2 = makeModelValues.isSelected;
        }
        return makeModelValues.copy(str, str3, z3, makeModelValues3, num2, z2);
    }

    @Nullable
    public final String component1() {
        return this.displayText;
    }

    @Nullable
    public final String component2() {
        return this.valuesId;
    }

    public final boolean component3() {
        return this.isMake;
    }

    @Nullable
    public final MakeModelValues component4() {
        return this.makeInfo;
    }

    @Nullable
    public final Integer component5() {
        return this.filterCount;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    @NotNull
    public final MakeModelValues copy(@Nullable String str, @Nullable String str2, boolean z, @Nullable MakeModelValues makeModelValues, @Nullable Integer num, boolean z2) {
        return new MakeModelValues(str, str2, z, makeModelValues, num, z2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MakeModelValues) {
                MakeModelValues makeModelValues = (MakeModelValues) obj;
                if (Intrinsics.areEqual((Object) this.displayText, (Object) makeModelValues.displayText) && Intrinsics.areEqual((Object) this.valuesId, (Object) makeModelValues.valuesId)) {
                    if ((this.isMake == makeModelValues.isMake) && Intrinsics.areEqual((Object) this.makeInfo, (Object) makeModelValues.makeInfo) && Intrinsics.areEqual((Object) this.filterCount, (Object) makeModelValues.filterCount)) {
                        if (this.isSelected == makeModelValues.isSelected) {
                            return true;
                        }
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
        String str2 = this.valuesId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isMake;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        MakeModelValues makeModelValues = this.makeInfo;
        int hashCode3 = (i2 + (makeModelValues != null ? makeModelValues.hashCode() : 0)) * 31;
        Integer num = this.filterCount;
        if (num != null) {
            i = num.hashCode();
        }
        int i3 = (hashCode3 + i) * 31;
        boolean z2 = this.isSelected;
        if (z2) {
            z2 = true;
        }
        return i3 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "MakeModelValues(displayText=" + this.displayText + ", valuesId=" + this.valuesId + ", isMake=" + this.isMake + ", makeInfo=" + this.makeInfo + ", filterCount=" + this.filterCount + ", isSelected=" + this.isSelected + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.displayText);
        parcel.writeString(this.valuesId);
        parcel.writeInt(this.isMake ? 1 : 0);
        MakeModelValues makeModelValues = this.makeInfo;
        if (makeModelValues != null) {
            parcel.writeInt(1);
            makeModelValues.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.filterCount;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public MakeModelValues(@Nullable String str, @Nullable String str2, boolean z, @Nullable MakeModelValues makeModelValues, @Nullable Integer num, boolean z2) {
        this.displayText = str;
        this.valuesId = str2;
        this.isMake = z;
        this.makeInfo = makeModelValues;
        this.filterCount = num;
        this.isSelected = z2;
    }

    @Nullable
    public final String getDisplayText() {
        return this.displayText;
    }

    public final void setDisplayText(@Nullable String str) {
        this.displayText = str;
    }

    @Nullable
    public final String getValuesId() {
        return this.valuesId;
    }

    public final boolean isMake() {
        return this.isMake;
    }

    @Nullable
    public final MakeModelValues getMakeInfo() {
        return this.makeInfo;
    }

    @Nullable
    public final Integer getFilterCount() {
        return this.filterCount;
    }

    public final void setFilterCount(@Nullable Integer num) {
        this.filterCount = num;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
