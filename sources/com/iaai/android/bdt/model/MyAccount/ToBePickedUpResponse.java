package com.iaai.android.bdt.model.MyAccount;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpResponse;", "", "()V", "ShowMyVehicles", "", "getShowMyVehicles", "()Z", "setShowMyVehicles", "(Z)V", "TotalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "branchEnabledForPullout", "getBranchEnabledForPullout", "setBranchEnabledForPullout", "vehicleArrayList", "", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "getVehicleArrayList", "()Ljava/util/List;", "setVehicleArrayList", "(Ljava/util/List;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpResponse.kt */
public final class ToBePickedUpResponse {
    @SerializedName("ShowMyVehicles")
    private boolean ShowMyVehicles;
    @SerializedName("totalcount")
    private int TotalCount;
    @SerializedName("BranchEnabledForPullout")
    private boolean branchEnabledForPullout;
    @SerializedName("list")
    @Nullable
    private List<ToBePickedUpVehiclesModel> vehicleArrayList;

    @Nullable
    public final List<ToBePickedUpVehiclesModel> getVehicleArrayList() {
        return this.vehicleArrayList;
    }

    public final void setVehicleArrayList(@Nullable List<ToBePickedUpVehiclesModel> list) {
        this.vehicleArrayList = list;
    }

    public final boolean getBranchEnabledForPullout() {
        return this.branchEnabledForPullout;
    }

    public final void setBranchEnabledForPullout(boolean z) {
        this.branchEnabledForPullout = z;
    }

    public final boolean getShowMyVehicles() {
        return this.ShowMyVehicles;
    }

    public final void setShowMyVehicles(boolean z) {
        this.ShowMyVehicles = z;
    }

    public final int getTotalCount() {
        return this.TotalCount;
    }

    public final void setTotalCount(int i) {
        this.TotalCount = i;
    }
}
