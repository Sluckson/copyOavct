package com.iaai.android.bdt.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b7\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010/\u001a\u00020\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"JÄ\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\nHÖ\u0001J\t\u0010@\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\r\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b&\u0010\"R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b(\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001c¨\u0006A"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/login/BDTLoginResponse;", "", "IsLicensedBusinessAccount", "", "EnableInteract", "IsPublic", "IsTempPassword", "StatusCode", "", "buyerEmployeeId", "", "buyerId", "fName", "isAFC", "lName", "lbsBrokerBidderIndicator", "lbsParentIndicator", "message", "owner", "userID", "zipCode", "(ZZZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getEnableInteract", "()Z", "getIsLicensedBusinessAccount", "getIsPublic", "getIsTempPassword", "getStatusCode", "()Ljava/lang/String;", "getBuyerEmployeeId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBuyerId", "getFName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLName", "getLbsBrokerBidderIndicator", "getLbsParentIndicator", "getMessage", "getOwner", "getUserID", "getZipCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZZZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/iaai/android/bdt/model/login/BDTLoginResponse;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTLoginResponse.kt */
public final class BDTLoginResponse {
    private final boolean EnableInteract;
    private final boolean IsLicensedBusinessAccount;
    private final boolean IsPublic;
    private final boolean IsTempPassword;
    @Nullable
    private final String StatusCode;
    @Nullable
    private final Integer buyerEmployeeId;
    @Nullable
    private final Integer buyerId;
    @Nullable
    private final String fName;
    @Nullable
    private final Boolean isAFC;
    @Nullable
    private final String lName;
    @Nullable
    private final Boolean lbsBrokerBidderIndicator;
    @Nullable
    private final Boolean lbsParentIndicator;
    @NotNull
    private final String message;
    @Nullable
    private final Boolean owner;
    @Nullable
    private final String userID;
    @Nullable
    private final String zipCode;

    @NotNull
    public static /* synthetic */ BDTLoginResponse copy$default(BDTLoginResponse bDTLoginResponse, boolean z, boolean z2, boolean z3, boolean z4, String str, Integer num, Integer num2, String str2, Boolean bool, String str3, Boolean bool2, Boolean bool3, String str4, Boolean bool4, String str5, String str6, int i, Object obj) {
        BDTLoginResponse bDTLoginResponse2 = bDTLoginResponse;
        int i2 = i;
        return bDTLoginResponse.copy((i2 & 1) != 0 ? bDTLoginResponse2.IsLicensedBusinessAccount : z, (i2 & 2) != 0 ? bDTLoginResponse2.EnableInteract : z2, (i2 & 4) != 0 ? bDTLoginResponse2.IsPublic : z3, (i2 & 8) != 0 ? bDTLoginResponse2.IsTempPassword : z4, (i2 & 16) != 0 ? bDTLoginResponse2.StatusCode : str, (i2 & 32) != 0 ? bDTLoginResponse2.buyerEmployeeId : num, (i2 & 64) != 0 ? bDTLoginResponse2.buyerId : num2, (i2 & 128) != 0 ? bDTLoginResponse2.fName : str2, (i2 & 256) != 0 ? bDTLoginResponse2.isAFC : bool, (i2 & 512) != 0 ? bDTLoginResponse2.lName : str3, (i2 & 1024) != 0 ? bDTLoginResponse2.lbsBrokerBidderIndicator : bool2, (i2 & 2048) != 0 ? bDTLoginResponse2.lbsParentIndicator : bool3, (i2 & 4096) != 0 ? bDTLoginResponse2.message : str4, (i2 & 8192) != 0 ? bDTLoginResponse2.owner : bool4, (i2 & 16384) != 0 ? bDTLoginResponse2.userID : str5, (i2 & 32768) != 0 ? bDTLoginResponse2.zipCode : str6);
    }

    public final boolean component1() {
        return this.IsLicensedBusinessAccount;
    }

    @Nullable
    public final String component10() {
        return this.lName;
    }

    @Nullable
    public final Boolean component11() {
        return this.lbsBrokerBidderIndicator;
    }

    @Nullable
    public final Boolean component12() {
        return this.lbsParentIndicator;
    }

    @NotNull
    public final String component13() {
        return this.message;
    }

    @Nullable
    public final Boolean component14() {
        return this.owner;
    }

    @Nullable
    public final String component15() {
        return this.userID;
    }

    @Nullable
    public final String component16() {
        return this.zipCode;
    }

    public final boolean component2() {
        return this.EnableInteract;
    }

    public final boolean component3() {
        return this.IsPublic;
    }

    public final boolean component4() {
        return this.IsTempPassword;
    }

    @Nullable
    public final String component5() {
        return this.StatusCode;
    }

    @Nullable
    public final Integer component6() {
        return this.buyerEmployeeId;
    }

    @Nullable
    public final Integer component7() {
        return this.buyerId;
    }

    @Nullable
    public final String component8() {
        return this.fName;
    }

    @Nullable
    public final Boolean component9() {
        return this.isAFC;
    }

    @NotNull
    public final BDTLoginResponse copy(boolean z, boolean z2, boolean z3, boolean z4, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable Boolean bool2, @Nullable Boolean bool3, @NotNull String str4, @Nullable Boolean bool4, @Nullable String str5, @Nullable String str6) {
        boolean z5 = z;
        Intrinsics.checkParameterIsNotNull(str4, "message");
        return new BDTLoginResponse(z, z2, z3, z4, str, num, num2, str2, bool, str3, bool2, bool3, str4, bool4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BDTLoginResponse) {
                BDTLoginResponse bDTLoginResponse = (BDTLoginResponse) obj;
                if (this.IsLicensedBusinessAccount == bDTLoginResponse.IsLicensedBusinessAccount) {
                    if (this.EnableInteract == bDTLoginResponse.EnableInteract) {
                        if (this.IsPublic == bDTLoginResponse.IsPublic) {
                            if (!(this.IsTempPassword == bDTLoginResponse.IsTempPassword) || !Intrinsics.areEqual((Object) this.StatusCode, (Object) bDTLoginResponse.StatusCode) || !Intrinsics.areEqual((Object) this.buyerEmployeeId, (Object) bDTLoginResponse.buyerEmployeeId) || !Intrinsics.areEqual((Object) this.buyerId, (Object) bDTLoginResponse.buyerId) || !Intrinsics.areEqual((Object) this.fName, (Object) bDTLoginResponse.fName) || !Intrinsics.areEqual((Object) this.isAFC, (Object) bDTLoginResponse.isAFC) || !Intrinsics.areEqual((Object) this.lName, (Object) bDTLoginResponse.lName) || !Intrinsics.areEqual((Object) this.lbsBrokerBidderIndicator, (Object) bDTLoginResponse.lbsBrokerBidderIndicator) || !Intrinsics.areEqual((Object) this.lbsParentIndicator, (Object) bDTLoginResponse.lbsParentIndicator) || !Intrinsics.areEqual((Object) this.message, (Object) bDTLoginResponse.message) || !Intrinsics.areEqual((Object) this.owner, (Object) bDTLoginResponse.owner) || !Intrinsics.areEqual((Object) this.userID, (Object) bDTLoginResponse.userID) || !Intrinsics.areEqual((Object) this.zipCode, (Object) bDTLoginResponse.zipCode)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.IsLicensedBusinessAccount;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.EnableInteract;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.IsPublic;
        if (z4) {
            z4 = true;
        }
        int i3 = (i2 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.IsTempPassword;
        if (!z5) {
            z2 = z5;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        String str = this.StatusCode;
        int i5 = 0;
        int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.buyerEmployeeId;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.buyerId;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.fName;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.isAFC;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str3 = this.lName;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool2 = this.lbsBrokerBidderIndicator;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.lbsParentIndicator;
        int hashCode8 = (hashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str4 = this.message;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool4 = this.owner;
        int hashCode10 = (hashCode9 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        String str5 = this.userID;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.zipCode;
        if (str6 != null) {
            i5 = str6.hashCode();
        }
        return hashCode11 + i5;
    }

    @NotNull
    public String toString() {
        return "BDTLoginResponse(IsLicensedBusinessAccount=" + this.IsLicensedBusinessAccount + ", EnableInteract=" + this.EnableInteract + ", IsPublic=" + this.IsPublic + ", IsTempPassword=" + this.IsTempPassword + ", StatusCode=" + this.StatusCode + ", buyerEmployeeId=" + this.buyerEmployeeId + ", buyerId=" + this.buyerId + ", fName=" + this.fName + ", isAFC=" + this.isAFC + ", lName=" + this.lName + ", lbsBrokerBidderIndicator=" + this.lbsBrokerBidderIndicator + ", lbsParentIndicator=" + this.lbsParentIndicator + ", message=" + this.message + ", owner=" + this.owner + ", userID=" + this.userID + ", zipCode=" + this.zipCode + ")";
    }

    public BDTLoginResponse(boolean z, boolean z2, boolean z3, boolean z4, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable Boolean bool2, @Nullable Boolean bool3, @NotNull String str4, @Nullable Boolean bool4, @Nullable String str5, @Nullable String str6) {
        String str7 = str4;
        Intrinsics.checkParameterIsNotNull(str7, "message");
        this.IsLicensedBusinessAccount = z;
        this.EnableInteract = z2;
        this.IsPublic = z3;
        this.IsTempPassword = z4;
        this.StatusCode = str;
        this.buyerEmployeeId = num;
        this.buyerId = num2;
        this.fName = str2;
        this.isAFC = bool;
        this.lName = str3;
        this.lbsBrokerBidderIndicator = bool2;
        this.lbsParentIndicator = bool3;
        this.message = str7;
        this.owner = bool4;
        this.userID = str5;
        this.zipCode = str6;
    }

    public final boolean getIsLicensedBusinessAccount() {
        return this.IsLicensedBusinessAccount;
    }

    public final boolean getEnableInteract() {
        return this.EnableInteract;
    }

    public final boolean getIsPublic() {
        return this.IsPublic;
    }

    public final boolean getIsTempPassword() {
        return this.IsTempPassword;
    }

    @Nullable
    public final String getStatusCode() {
        return this.StatusCode;
    }

    @Nullable
    public final Integer getBuyerEmployeeId() {
        return this.buyerEmployeeId;
    }

    @Nullable
    public final Integer getBuyerId() {
        return this.buyerId;
    }

    @Nullable
    public final String getFName() {
        return this.fName;
    }

    @Nullable
    public final Boolean isAFC() {
        return this.isAFC;
    }

    @Nullable
    public final String getLName() {
        return this.lName;
    }

    @Nullable
    public final Boolean getLbsBrokerBidderIndicator() {
        return this.lbsBrokerBidderIndicator;
    }

    @Nullable
    public final Boolean getLbsParentIndicator() {
        return this.lbsParentIndicator;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getOwner() {
        return this.owner;
    }

    @Nullable
    public final String getUserID() {
        return this.userID;
    }

    @Nullable
    public final String getZipCode() {
        return this.zipCode;
    }
}
