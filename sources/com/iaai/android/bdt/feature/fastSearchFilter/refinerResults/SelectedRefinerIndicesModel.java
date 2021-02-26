package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/SelectedRefinerIndicesModel;", "Landroid/os/Parcelable;", "tabPosition", "", "parentPosition", "childPosition", "(III)V", "getChildPosition", "()I", "setChildPosition", "(I)V", "getParentPosition", "setParentPosition", "getTabPosition", "setTabPosition", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: SelectedRefinerIndicesModel.kt */
public final class SelectedRefinerIndicesModel implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private int childPosition;
    private int parentPosition;
    private int tabPosition;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new SelectedRefinerIndicesModel(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new SelectedRefinerIndicesModel[i];
        }
    }

    @NotNull
    public static /* synthetic */ SelectedRefinerIndicesModel copy$default(SelectedRefinerIndicesModel selectedRefinerIndicesModel, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = selectedRefinerIndicesModel.tabPosition;
        }
        if ((i4 & 2) != 0) {
            i2 = selectedRefinerIndicesModel.parentPosition;
        }
        if ((i4 & 4) != 0) {
            i3 = selectedRefinerIndicesModel.childPosition;
        }
        return selectedRefinerIndicesModel.copy(i, i2, i3);
    }

    public final int component1() {
        return this.tabPosition;
    }

    public final int component2() {
        return this.parentPosition;
    }

    public final int component3() {
        return this.childPosition;
    }

    @NotNull
    public final SelectedRefinerIndicesModel copy(int i, int i2, int i3) {
        return new SelectedRefinerIndicesModel(i, i2, i3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SelectedRefinerIndicesModel) {
                SelectedRefinerIndicesModel selectedRefinerIndicesModel = (SelectedRefinerIndicesModel) obj;
                if (this.tabPosition == selectedRefinerIndicesModel.tabPosition) {
                    if (this.parentPosition == selectedRefinerIndicesModel.parentPosition) {
                        if (this.childPosition == selectedRefinerIndicesModel.childPosition) {
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
        return (((Integer.valueOf(this.tabPosition).hashCode() * 31) + Integer.valueOf(this.parentPosition).hashCode()) * 31) + Integer.valueOf(this.childPosition).hashCode();
    }

    @NotNull
    public String toString() {
        return "SelectedRefinerIndicesModel(tabPosition=" + this.tabPosition + ", parentPosition=" + this.parentPosition + ", childPosition=" + this.childPosition + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.tabPosition);
        parcel.writeInt(this.parentPosition);
        parcel.writeInt(this.childPosition);
    }

    public SelectedRefinerIndicesModel(int i, int i2, int i3) {
        this.tabPosition = i;
        this.parentPosition = i2;
        this.childPosition = i3;
    }

    public final int getTabPosition() {
        return this.tabPosition;
    }

    public final void setTabPosition(int i) {
        this.tabPosition = i;
    }

    public final int getParentPosition() {
        return this.parentPosition;
    }

    public final void setParentPosition(int i) {
        this.parentPosition = i;
    }

    public final int getChildPosition() {
        return this.childPosition;
    }

    public final void setChildPosition(int i) {
        this.childPosition = i;
    }
}
