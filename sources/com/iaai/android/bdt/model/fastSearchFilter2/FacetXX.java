package com.iaai.android.bdt.model.fastSearchFilter2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "Landroid/os/Parcelable;", "Count", "", "Value", "", "RefinerValue", "isSelected", "", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getCount", "()I", "getRefinerValue", "()Ljava/lang/String;", "setRefinerValue", "(Ljava/lang/String;)V", "getValue", "setValue", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: FacetXX.kt */
public final class FacetXX implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final int Count;
    @Nullable
    private String RefinerValue;
    @NotNull
    private String Value;
    private boolean isSelected;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new FacetXX(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new FacetXX[i];
        }
    }

    @NotNull
    public static /* synthetic */ FacetXX copy$default(FacetXX facetXX, int i, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = facetXX.Count;
        }
        if ((i2 & 2) != 0) {
            str = facetXX.Value;
        }
        if ((i2 & 4) != 0) {
            str2 = facetXX.RefinerValue;
        }
        if ((i2 & 8) != 0) {
            z = facetXX.isSelected;
        }
        return facetXX.copy(i, str, str2, z);
    }

    public final int component1() {
        return this.Count;
    }

    @NotNull
    public final String component2() {
        return this.Value;
    }

    @Nullable
    public final String component3() {
        return this.RefinerValue;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    @NotNull
    public final FacetXX copy(int i, @NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "Value");
        return new FacetXX(i, str, str2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FacetXX) {
                FacetXX facetXX = (FacetXX) obj;
                if ((this.Count == facetXX.Count) && Intrinsics.areEqual((Object) this.Value, (Object) facetXX.Value) && Intrinsics.areEqual((Object) this.RefinerValue, (Object) facetXX.RefinerValue)) {
                    if (this.isSelected == facetXX.isSelected) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.Count).hashCode() * 31;
        String str = this.Value;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.RefinerValue;
        if (str2 != null) {
            i = str2.hashCode();
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
        return "FacetXX(Count=" + this.Count + ", Value=" + this.Value + ", RefinerValue=" + this.RefinerValue + ", isSelected=" + this.isSelected + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.Count);
        parcel.writeString(this.Value);
        parcel.writeString(this.RefinerValue);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public FacetXX(int i, @NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "Value");
        this.Count = i;
        this.Value = str;
        this.RefinerValue = str2;
        this.isSelected = z;
    }

    public final int getCount() {
        return this.Count;
    }

    @NotNull
    public final String getValue() {
        return this.Value;
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.Value = str;
    }

    @Nullable
    public final String getRefinerValue() {
        return this.RefinerValue;
    }

    public final void setRefinerValue(@Nullable String str) {
        this.RefinerValue = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
