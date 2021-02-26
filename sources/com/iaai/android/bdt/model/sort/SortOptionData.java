package com.iaai.android.bdt.model.sort;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011¨\u0006#"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/sort/SortOptionData;", "Landroid/os/Parcelable;", "displayText", "", "sortKey", "sortDirection", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDisplayText", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "getSortDirection", "getSortKey", "setSortKey", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: SortOptionData.kt */
public final class SortOptionData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String displayText;
    private boolean isSelected;
    @NotNull
    private final String sortDirection;
    @NotNull
    private String sortKey;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new SortOptionData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new SortOptionData[i];
        }
    }

    @NotNull
    public static /* synthetic */ SortOptionData copy$default(SortOptionData sortOptionData, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sortOptionData.displayText;
        }
        if ((i & 2) != 0) {
            str2 = sortOptionData.sortKey;
        }
        if ((i & 4) != 0) {
            str3 = sortOptionData.sortDirection;
        }
        if ((i & 8) != 0) {
            z = sortOptionData.isSelected;
        }
        return sortOptionData.copy(str, str2, str3, z);
    }

    @NotNull
    public final String component1() {
        return this.displayText;
    }

    @NotNull
    public final String component2() {
        return this.sortKey;
    }

    @NotNull
    public final String component3() {
        return this.sortDirection;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    @NotNull
    public final SortOptionData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "displayText");
        Intrinsics.checkParameterIsNotNull(str2, "sortKey");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_SORT_DIRECTION);
        return new SortOptionData(str, str2, str3, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SortOptionData) {
                SortOptionData sortOptionData = (SortOptionData) obj;
                if (Intrinsics.areEqual((Object) this.displayText, (Object) sortOptionData.displayText) && Intrinsics.areEqual((Object) this.sortKey, (Object) sortOptionData.sortKey) && Intrinsics.areEqual((Object) this.sortDirection, (Object) sortOptionData.sortDirection)) {
                    if (this.isSelected == sortOptionData.isSelected) {
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
        String str2 = this.sortKey;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.sortDirection;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "SortOptionData(displayText=" + this.displayText + ", sortKey=" + this.sortKey + ", sortDirection=" + this.sortDirection + ", isSelected=" + this.isSelected + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.displayText);
        parcel.writeString(this.sortKey);
        parcel.writeString(this.sortDirection);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public SortOptionData(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "displayText");
        Intrinsics.checkParameterIsNotNull(str2, "sortKey");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_SORT_DIRECTION);
        this.displayText = str;
        this.sortKey = str2;
        this.sortDirection = str3;
        this.isSelected = z;
    }

    @NotNull
    public final String getDisplayText() {
        return this.displayText;
    }

    @NotNull
    public final String getSortKey() {
        return this.sortKey;
    }

    public final void setSortKey(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.sortKey = str;
    }

    @NotNull
    public final String getSortDirection() {
        return this.sortDirection;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
