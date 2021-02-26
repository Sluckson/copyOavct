package com.iaai.android.bdt.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/login/FCMTokenRequest;", "", "DeviceType", "", "TokenID", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceType", "()Ljava/lang/String;", "getTokenID", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FCMTokenRequest.kt */
public final class FCMTokenRequest {
    @NotNull
    private final String DeviceType;
    @NotNull
    private final String TokenID;

    @NotNull
    public static /* synthetic */ FCMTokenRequest copy$default(FCMTokenRequest fCMTokenRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fCMTokenRequest.DeviceType;
        }
        if ((i & 2) != 0) {
            str2 = fCMTokenRequest.TokenID;
        }
        return fCMTokenRequest.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.DeviceType;
    }

    @NotNull
    public final String component2() {
        return this.TokenID;
    }

    @NotNull
    public final FCMTokenRequest copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "DeviceType");
        Intrinsics.checkParameterIsNotNull(str2, "TokenID");
        return new FCMTokenRequest(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FCMTokenRequest)) {
            return false;
        }
        FCMTokenRequest fCMTokenRequest = (FCMTokenRequest) obj;
        return Intrinsics.areEqual((Object) this.DeviceType, (Object) fCMTokenRequest.DeviceType) && Intrinsics.areEqual((Object) this.TokenID, (Object) fCMTokenRequest.TokenID);
    }

    public int hashCode() {
        String str = this.DeviceType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.TokenID;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "FCMTokenRequest(DeviceType=" + this.DeviceType + ", TokenID=" + this.TokenID + ")";
    }

    public FCMTokenRequest(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "DeviceType");
        Intrinsics.checkParameterIsNotNull(str2, "TokenID");
        this.DeviceType = str;
        this.TokenID = str2;
    }

    @NotNull
    public final String getDeviceType() {
        return this.DeviceType;
    }

    @NotNull
    public final String getTokenID() {
        return this.TokenID;
    }
}
