package com.iaai.android.bdt.model.MyAccount;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 52\u00020\u0001:\u00015B]\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010'\u001a\u00020\u000bHÆ\u0003Jx\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0013\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u001a\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00066"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "Landroid/os/Parcelable;", "BranchName", "", "BranchCode", "", "AssignedToName", "AssignedToCode", "AssignedToState", "VehicleCount", "IsChecked", "", "BranchPriority", "isSelected", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)V", "getAssignedToCode", "()Ljava/lang/String;", "getAssignedToName", "getAssignedToState", "getBranchCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBranchName", "getBranchPriority", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIsChecked", "getVehicleCount", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: BranchModel.kt */
public final class BranchModel implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<BranchModel> DIFF_CALLBACK = new BranchModel$Companion$DIFF_CALLBACK$1();
    @Nullable
    private final String AssignedToCode;
    @Nullable
    private final String AssignedToName;
    @Nullable
    private final String AssignedToState;
    @Nullable
    private final Integer BranchCode;
    @Nullable
    private final String BranchName;
    @Nullable
    private final Boolean BranchPriority;
    @Nullable
    private final Boolean IsChecked;
    @Nullable
    private final Integer VehicleCount;
    private boolean isSelected;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            String readString = parcel.readString();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            boolean z = false;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                bool2 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool2 = null;
            }
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new BranchModel(readString, valueOf, readString2, readString3, readString4, valueOf2, bool, bool2, z);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new BranchModel[i];
        }
    }

    @NotNull
    public static /* synthetic */ BranchModel copy$default(BranchModel branchModel, String str, Integer num, String str2, String str3, String str4, Integer num2, Boolean bool, Boolean bool2, boolean z, int i, Object obj) {
        BranchModel branchModel2 = branchModel;
        int i2 = i;
        return branchModel.copy((i2 & 1) != 0 ? branchModel2.BranchName : str, (i2 & 2) != 0 ? branchModel2.BranchCode : num, (i2 & 4) != 0 ? branchModel2.AssignedToName : str2, (i2 & 8) != 0 ? branchModel2.AssignedToCode : str3, (i2 & 16) != 0 ? branchModel2.AssignedToState : str4, (i2 & 32) != 0 ? branchModel2.VehicleCount : num2, (i2 & 64) != 0 ? branchModel2.IsChecked : bool, (i2 & 128) != 0 ? branchModel2.BranchPriority : bool2, (i2 & 256) != 0 ? branchModel2.isSelected : z);
    }

    @Nullable
    public final String component1() {
        return this.BranchName;
    }

    @Nullable
    public final Integer component2() {
        return this.BranchCode;
    }

    @Nullable
    public final String component3() {
        return this.AssignedToName;
    }

    @Nullable
    public final String component4() {
        return this.AssignedToCode;
    }

    @Nullable
    public final String component5() {
        return this.AssignedToState;
    }

    @Nullable
    public final Integer component6() {
        return this.VehicleCount;
    }

    @Nullable
    public final Boolean component7() {
        return this.IsChecked;
    }

    @Nullable
    public final Boolean component8() {
        return this.BranchPriority;
    }

    public final boolean component9() {
        return this.isSelected;
    }

    @NotNull
    public final BranchModel copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num2, @Nullable Boolean bool, @Nullable Boolean bool2, boolean z) {
        return new BranchModel(str, num, str2, str3, str4, num2, bool, bool2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BranchModel) {
                BranchModel branchModel = (BranchModel) obj;
                if (Intrinsics.areEqual((Object) this.BranchName, (Object) branchModel.BranchName) && Intrinsics.areEqual((Object) this.BranchCode, (Object) branchModel.BranchCode) && Intrinsics.areEqual((Object) this.AssignedToName, (Object) branchModel.AssignedToName) && Intrinsics.areEqual((Object) this.AssignedToCode, (Object) branchModel.AssignedToCode) && Intrinsics.areEqual((Object) this.AssignedToState, (Object) branchModel.AssignedToState) && Intrinsics.areEqual((Object) this.VehicleCount, (Object) branchModel.VehicleCount) && Intrinsics.areEqual((Object) this.IsChecked, (Object) branchModel.IsChecked) && Intrinsics.areEqual((Object) this.BranchPriority, (Object) branchModel.BranchPriority)) {
                    if (this.isSelected == branchModel.isSelected) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.BranchName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.BranchCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.AssignedToName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.AssignedToCode;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.AssignedToState;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num2 = this.VehicleCount;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Boolean bool = this.IsChecked;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.BranchPriority;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        int i2 = (hashCode7 + i) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "BranchModel(BranchName=" + this.BranchName + ", BranchCode=" + this.BranchCode + ", AssignedToName=" + this.AssignedToName + ", AssignedToCode=" + this.AssignedToCode + ", AssignedToState=" + this.AssignedToState + ", VehicleCount=" + this.VehicleCount + ", IsChecked=" + this.IsChecked + ", BranchPriority=" + this.BranchPriority + ", isSelected=" + this.isSelected + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.BranchName);
        Integer num = this.BranchCode;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.AssignedToName);
        parcel.writeString(this.AssignedToCode);
        parcel.writeString(this.AssignedToState);
        Integer num2 = this.VehicleCount;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.IsChecked;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.BranchPriority;
        if (bool2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public BranchModel(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num2, @Nullable Boolean bool, @Nullable Boolean bool2, boolean z) {
        this.BranchName = str;
        this.BranchCode = num;
        this.AssignedToName = str2;
        this.AssignedToCode = str3;
        this.AssignedToState = str4;
        this.VehicleCount = num2;
        this.IsChecked = bool;
        this.BranchPriority = bool2;
        this.isSelected = z;
    }

    @Nullable
    public final String getBranchName() {
        return this.BranchName;
    }

    @Nullable
    public final Integer getBranchCode() {
        return this.BranchCode;
    }

    @Nullable
    public final String getAssignedToName() {
        return this.AssignedToName;
    }

    @Nullable
    public final String getAssignedToCode() {
        return this.AssignedToCode;
    }

    @Nullable
    public final String getAssignedToState() {
        return this.AssignedToState;
    }

    @Nullable
    public final Integer getVehicleCount() {
        return this.VehicleCount;
    }

    @Nullable
    public final Boolean getIsChecked() {
        return this.IsChecked;
    }

    @Nullable
    public final Boolean getBranchPriority() {
        return this.BranchPriority;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/BranchModel$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDIFF_CALLBACK", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BranchModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<BranchModel> getDIFF_CALLBACK() {
            return BranchModel.DIFF_CALLBACK;
        }

        public final void setDIFF_CALLBACK(@NotNull DiffUtil.ItemCallback<BranchModel> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            BranchModel.DIFF_CALLBACK = itemCallback;
        }
    }
}
