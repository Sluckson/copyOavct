package com.iaai.android.bdt.model.MyAccount;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefResponse;", "", "Pickup", "Lcom/iaai/android/bdt/model/MyAccount/PickUpModel;", "Mail", "Lcom/iaai/android/bdt/model/MyAccount/IAAMailModel;", "Branches", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "Lkotlin/collections/ArrayList;", "(Lcom/iaai/android/bdt/model/MyAccount/PickUpModel;Lcom/iaai/android/bdt/model/MyAccount/IAAMailModel;Ljava/util/ArrayList;)V", "getBranches", "()Ljava/util/ArrayList;", "getMail", "()Lcom/iaai/android/bdt/model/MyAccount/IAAMailModel;", "getPickup", "()Lcom/iaai/android/bdt/model/MyAccount/PickUpModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageBranchPrefResponse.kt */
public final class ManageBranchPrefResponse {
    @NotNull
    private final ArrayList<BranchModel> Branches;
    @NotNull
    private final IAAMailModel Mail;
    @NotNull
    private final PickUpModel Pickup;

    @NotNull
    public static /* synthetic */ ManageBranchPrefResponse copy$default(ManageBranchPrefResponse manageBranchPrefResponse, PickUpModel pickUpModel, IAAMailModel iAAMailModel, ArrayList<BranchModel> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            pickUpModel = manageBranchPrefResponse.Pickup;
        }
        if ((i & 2) != 0) {
            iAAMailModel = manageBranchPrefResponse.Mail;
        }
        if ((i & 4) != 0) {
            arrayList = manageBranchPrefResponse.Branches;
        }
        return manageBranchPrefResponse.copy(pickUpModel, iAAMailModel, arrayList);
    }

    @NotNull
    public final PickUpModel component1() {
        return this.Pickup;
    }

    @NotNull
    public final IAAMailModel component2() {
        return this.Mail;
    }

    @NotNull
    public final ArrayList<BranchModel> component3() {
        return this.Branches;
    }

    @NotNull
    public final ManageBranchPrefResponse copy(@NotNull PickUpModel pickUpModel, @NotNull IAAMailModel iAAMailModel, @NotNull ArrayList<BranchModel> arrayList) {
        Intrinsics.checkParameterIsNotNull(pickUpModel, "Pickup");
        Intrinsics.checkParameterIsNotNull(iAAMailModel, "Mail");
        Intrinsics.checkParameterIsNotNull(arrayList, "Branches");
        return new ManageBranchPrefResponse(pickUpModel, iAAMailModel, arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ManageBranchPrefResponse)) {
            return false;
        }
        ManageBranchPrefResponse manageBranchPrefResponse = (ManageBranchPrefResponse) obj;
        return Intrinsics.areEqual((Object) this.Pickup, (Object) manageBranchPrefResponse.Pickup) && Intrinsics.areEqual((Object) this.Mail, (Object) manageBranchPrefResponse.Mail) && Intrinsics.areEqual((Object) this.Branches, (Object) manageBranchPrefResponse.Branches);
    }

    public int hashCode() {
        PickUpModel pickUpModel = this.Pickup;
        int i = 0;
        int hashCode = (pickUpModel != null ? pickUpModel.hashCode() : 0) * 31;
        IAAMailModel iAAMailModel = this.Mail;
        int hashCode2 = (hashCode + (iAAMailModel != null ? iAAMailModel.hashCode() : 0)) * 31;
        ArrayList<BranchModel> arrayList = this.Branches;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "ManageBranchPrefResponse(Pickup=" + this.Pickup + ", Mail=" + this.Mail + ", Branches=" + this.Branches + ")";
    }

    public ManageBranchPrefResponse(@NotNull PickUpModel pickUpModel, @NotNull IAAMailModel iAAMailModel, @NotNull ArrayList<BranchModel> arrayList) {
        Intrinsics.checkParameterIsNotNull(pickUpModel, "Pickup");
        Intrinsics.checkParameterIsNotNull(iAAMailModel, "Mail");
        Intrinsics.checkParameterIsNotNull(arrayList, "Branches");
        this.Pickup = pickUpModel;
        this.Mail = iAAMailModel;
        this.Branches = arrayList;
    }

    @NotNull
    public final PickUpModel getPickup() {
        return this.Pickup;
    }

    @NotNull
    public final IAAMailModel getMail() {
        return this.Mail;
    }

    @NotNull
    public final ArrayList<BranchModel> getBranches() {
        return this.Branches;
    }
}
