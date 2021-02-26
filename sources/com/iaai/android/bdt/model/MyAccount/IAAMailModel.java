package com.iaai.android.bdt.model.MyAccount;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/IAAMailModel;", "", "IaaFedEx", "Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;", "RegularMail", "BuyerFedex", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;Ljava/util/ArrayList;)V", "getBuyerFedex", "()Ljava/util/ArrayList;", "getIaaFedEx", "()Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;", "getRegularMail", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: IAAMailModel.kt */
public final class IAAMailModel {
    @NotNull
    private final ArrayList<ManageBranchModel> BuyerFedex;
    @NotNull
    private final ManageBranchModel IaaFedEx;
    @NotNull
    private final ManageBranchModel RegularMail;

    @NotNull
    public static /* synthetic */ IAAMailModel copy$default(IAAMailModel iAAMailModel, ManageBranchModel manageBranchModel, ManageBranchModel manageBranchModel2, ArrayList<ManageBranchModel> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            manageBranchModel = iAAMailModel.IaaFedEx;
        }
        if ((i & 2) != 0) {
            manageBranchModel2 = iAAMailModel.RegularMail;
        }
        if ((i & 4) != 0) {
            arrayList = iAAMailModel.BuyerFedex;
        }
        return iAAMailModel.copy(manageBranchModel, manageBranchModel2, arrayList);
    }

    @NotNull
    public final ManageBranchModel component1() {
        return this.IaaFedEx;
    }

    @NotNull
    public final ManageBranchModel component2() {
        return this.RegularMail;
    }

    @NotNull
    public final ArrayList<ManageBranchModel> component3() {
        return this.BuyerFedex;
    }

    @NotNull
    public final IAAMailModel copy(@NotNull ManageBranchModel manageBranchModel, @NotNull ManageBranchModel manageBranchModel2, @NotNull ArrayList<ManageBranchModel> arrayList) {
        Intrinsics.checkParameterIsNotNull(manageBranchModel, "IaaFedEx");
        Intrinsics.checkParameterIsNotNull(manageBranchModel2, "RegularMail");
        Intrinsics.checkParameterIsNotNull(arrayList, "BuyerFedex");
        return new IAAMailModel(manageBranchModel, manageBranchModel2, arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IAAMailModel)) {
            return false;
        }
        IAAMailModel iAAMailModel = (IAAMailModel) obj;
        return Intrinsics.areEqual((Object) this.IaaFedEx, (Object) iAAMailModel.IaaFedEx) && Intrinsics.areEqual((Object) this.RegularMail, (Object) iAAMailModel.RegularMail) && Intrinsics.areEqual((Object) this.BuyerFedex, (Object) iAAMailModel.BuyerFedex);
    }

    public int hashCode() {
        ManageBranchModel manageBranchModel = this.IaaFedEx;
        int i = 0;
        int hashCode = (manageBranchModel != null ? manageBranchModel.hashCode() : 0) * 31;
        ManageBranchModel manageBranchModel2 = this.RegularMail;
        int hashCode2 = (hashCode + (manageBranchModel2 != null ? manageBranchModel2.hashCode() : 0)) * 31;
        ArrayList<ManageBranchModel> arrayList = this.BuyerFedex;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "IAAMailModel(IaaFedEx=" + this.IaaFedEx + ", RegularMail=" + this.RegularMail + ", BuyerFedex=" + this.BuyerFedex + ")";
    }

    public IAAMailModel(@NotNull ManageBranchModel manageBranchModel, @NotNull ManageBranchModel manageBranchModel2, @NotNull ArrayList<ManageBranchModel> arrayList) {
        Intrinsics.checkParameterIsNotNull(manageBranchModel, "IaaFedEx");
        Intrinsics.checkParameterIsNotNull(manageBranchModel2, "RegularMail");
        Intrinsics.checkParameterIsNotNull(arrayList, "BuyerFedex");
        this.IaaFedEx = manageBranchModel;
        this.RegularMail = manageBranchModel2;
        this.BuyerFedex = arrayList;
    }

    @NotNull
    public final ManageBranchModel getIaaFedEx() {
        return this.IaaFedEx;
    }

    @NotNull
    public final ManageBranchModel getRegularMail() {
        return this.RegularMail;
    }

    @NotNull
    public final ArrayList<ManageBranchModel> getBuyerFedex() {
        return this.BuyerFedex;
    }
}
