package com.iaai.android.bdt.model.MyAccount;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/PickUpModel;", "", "OwnerPickup", "Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;", "RepresentativePickup", "", "(Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;Ljava/util/List;)V", "getOwnerPickup", "()Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;", "getRepresentativePickup", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PickUpModel.kt */
public final class PickUpModel {
    @NotNull
    private final ManageBranchModel OwnerPickup;
    @NotNull
    private final List<ManageBranchModel> RepresentativePickup;

    @NotNull
    public static /* synthetic */ PickUpModel copy$default(PickUpModel pickUpModel, ManageBranchModel manageBranchModel, List<ManageBranchModel> list, int i, Object obj) {
        if ((i & 1) != 0) {
            manageBranchModel = pickUpModel.OwnerPickup;
        }
        if ((i & 2) != 0) {
            list = pickUpModel.RepresentativePickup;
        }
        return pickUpModel.copy(manageBranchModel, list);
    }

    @NotNull
    public final ManageBranchModel component1() {
        return this.OwnerPickup;
    }

    @NotNull
    public final List<ManageBranchModel> component2() {
        return this.RepresentativePickup;
    }

    @NotNull
    public final PickUpModel copy(@NotNull ManageBranchModel manageBranchModel, @NotNull List<ManageBranchModel> list) {
        Intrinsics.checkParameterIsNotNull(manageBranchModel, "OwnerPickup");
        Intrinsics.checkParameterIsNotNull(list, "RepresentativePickup");
        return new PickUpModel(manageBranchModel, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickUpModel)) {
            return false;
        }
        PickUpModel pickUpModel = (PickUpModel) obj;
        return Intrinsics.areEqual((Object) this.OwnerPickup, (Object) pickUpModel.OwnerPickup) && Intrinsics.areEqual((Object) this.RepresentativePickup, (Object) pickUpModel.RepresentativePickup);
    }

    public int hashCode() {
        ManageBranchModel manageBranchModel = this.OwnerPickup;
        int i = 0;
        int hashCode = (manageBranchModel != null ? manageBranchModel.hashCode() : 0) * 31;
        List<ManageBranchModel> list = this.RepresentativePickup;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "PickUpModel(OwnerPickup=" + this.OwnerPickup + ", RepresentativePickup=" + this.RepresentativePickup + ")";
    }

    public PickUpModel(@NotNull ManageBranchModel manageBranchModel, @NotNull List<ManageBranchModel> list) {
        Intrinsics.checkParameterIsNotNull(manageBranchModel, "OwnerPickup");
        Intrinsics.checkParameterIsNotNull(list, "RepresentativePickup");
        this.OwnerPickup = manageBranchModel;
        this.RepresentativePickup = list;
    }

    @NotNull
    public final ManageBranchModel getOwnerPickup() {
        return this.OwnerPickup;
    }

    @NotNull
    public final List<ManageBranchModel> getRepresentativePickup() {
        return this.RepresentativePickup;
    }
}
