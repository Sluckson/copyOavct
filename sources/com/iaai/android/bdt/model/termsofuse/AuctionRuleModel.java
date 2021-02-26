package com.iaai.android.bdt.model.termsofuse;

import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/termsofuse/AuctionRuleModel;", "", "userid", "", "temppassword", "Url", "AcceptAuctionRules", "", "AcceptTermsOfUse", "Isguest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getAcceptAuctionRules", "()Z", "getAcceptTermsOfUse", "getIsguest", "getUrl", "()Ljava/lang/String;", "getTemppassword", "getUserid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionRuleModel.kt */
public final class AuctionRuleModel {
    private final boolean AcceptAuctionRules;
    private final boolean AcceptTermsOfUse;
    private final boolean Isguest;
    @NotNull
    private final String Url;
    @NotNull
    private final String temppassword;
    @NotNull
    private final String userid;

    @NotNull
    public static /* synthetic */ AuctionRuleModel copy$default(AuctionRuleModel auctionRuleModel, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = auctionRuleModel.userid;
        }
        if ((i & 2) != 0) {
            str2 = auctionRuleModel.temppassword;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = auctionRuleModel.Url;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            z = auctionRuleModel.AcceptAuctionRules;
        }
        boolean z4 = z;
        if ((i & 16) != 0) {
            z2 = auctionRuleModel.AcceptTermsOfUse;
        }
        boolean z5 = z2;
        if ((i & 32) != 0) {
            z3 = auctionRuleModel.Isguest;
        }
        return auctionRuleModel.copy(str, str4, str5, z4, z5, z3);
    }

    @NotNull
    public final String component1() {
        return this.userid;
    }

    @NotNull
    public final String component2() {
        return this.temppassword;
    }

    @NotNull
    public final String component3() {
        return this.Url;
    }

    public final boolean component4() {
        return this.AcceptAuctionRules;
    }

    public final boolean component5() {
        return this.AcceptTermsOfUse;
    }

    public final boolean component6() {
        return this.Isguest;
    }

    @NotNull
    public final AuctionRuleModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_IAAI_USERID);
        Intrinsics.checkParameterIsNotNull(str2, "temppassword");
        Intrinsics.checkParameterIsNotNull(str3, "Url");
        return new AuctionRuleModel(str, str2, str3, z, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AuctionRuleModel) {
                AuctionRuleModel auctionRuleModel = (AuctionRuleModel) obj;
                if (Intrinsics.areEqual((Object) this.userid, (Object) auctionRuleModel.userid) && Intrinsics.areEqual((Object) this.temppassword, (Object) auctionRuleModel.temppassword) && Intrinsics.areEqual((Object) this.Url, (Object) auctionRuleModel.Url)) {
                    if (this.AcceptAuctionRules == auctionRuleModel.AcceptAuctionRules) {
                        if (this.AcceptTermsOfUse == auctionRuleModel.AcceptTermsOfUse) {
                            if (this.Isguest == auctionRuleModel.Isguest) {
                                return true;
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
        String str = this.userid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.temppassword;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Url;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.AcceptAuctionRules;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z2 = this.AcceptTermsOfUse;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.Isguest;
        if (z3) {
            z3 = true;
        }
        return i4 + (z3 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "AuctionRuleModel(userid=" + this.userid + ", temppassword=" + this.temppassword + ", Url=" + this.Url + ", AcceptAuctionRules=" + this.AcceptAuctionRules + ", AcceptTermsOfUse=" + this.AcceptTermsOfUse + ", Isguest=" + this.Isguest + ")";
    }

    public AuctionRuleModel(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_IAAI_USERID);
        Intrinsics.checkParameterIsNotNull(str2, "temppassword");
        Intrinsics.checkParameterIsNotNull(str3, "Url");
        this.userid = str;
        this.temppassword = str2;
        this.Url = str3;
        this.AcceptAuctionRules = z;
        this.AcceptTermsOfUse = z2;
        this.Isguest = z3;
    }

    @NotNull
    public final String getUserid() {
        return this.userid;
    }

    @NotNull
    public final String getTemppassword() {
        return this.temppassword;
    }

    @NotNull
    public final String getUrl() {
        return this.Url;
    }

    public final boolean getAcceptAuctionRules() {
        return this.AcceptAuctionRules;
    }

    public final boolean getAcceptTermsOfUse() {
        return this.AcceptTermsOfUse;
    }

    public final boolean getIsguest() {
        return this.Isguest;
    }
}
