package com.iaai.android.bdt.model.MyAccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/MBRequestBody;", "", "manageBranchPrefRequestBody", "Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefRequestBody;", "(Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefRequestBody;)V", "getManageBranchPrefRequestBody", "()Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefRequestBody;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MBRequestBody.kt */
public final class MBRequestBody {
    @NotNull
    private final ManageBranchPrefRequestBody manageBranchPrefRequestBody;

    @NotNull
    public static /* synthetic */ MBRequestBody copy$default(MBRequestBody mBRequestBody, ManageBranchPrefRequestBody manageBranchPrefRequestBody2, int i, Object obj) {
        if ((i & 1) != 0) {
            manageBranchPrefRequestBody2 = mBRequestBody.manageBranchPrefRequestBody;
        }
        return mBRequestBody.copy(manageBranchPrefRequestBody2);
    }

    @NotNull
    public final ManageBranchPrefRequestBody component1() {
        return this.manageBranchPrefRequestBody;
    }

    @NotNull
    public final MBRequestBody copy(@NotNull ManageBranchPrefRequestBody manageBranchPrefRequestBody2) {
        Intrinsics.checkParameterIsNotNull(manageBranchPrefRequestBody2, "manageBranchPrefRequestBody");
        return new MBRequestBody(manageBranchPrefRequestBody2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof MBRequestBody) && Intrinsics.areEqual((Object) this.manageBranchPrefRequestBody, (Object) ((MBRequestBody) obj).manageBranchPrefRequestBody);
        }
        return true;
    }

    public int hashCode() {
        ManageBranchPrefRequestBody manageBranchPrefRequestBody2 = this.manageBranchPrefRequestBody;
        if (manageBranchPrefRequestBody2 != null) {
            return manageBranchPrefRequestBody2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "MBRequestBody(manageBranchPrefRequestBody=" + this.manageBranchPrefRequestBody + ")";
    }

    public MBRequestBody(@NotNull ManageBranchPrefRequestBody manageBranchPrefRequestBody2) {
        Intrinsics.checkParameterIsNotNull(manageBranchPrefRequestBody2, "manageBranchPrefRequestBody");
        this.manageBranchPrefRequestBody = manageBranchPrefRequestBody2;
    }

    @NotNull
    public final ManageBranchPrefRequestBody getManageBranchPrefRequestBody() {
        return this.manageBranchPrefRequestBody;
    }
}
