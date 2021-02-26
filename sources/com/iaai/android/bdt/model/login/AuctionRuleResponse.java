package com.iaai.android.bdt.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/model/login/AuctionRuleResponse;", "", "AcceptAuctionRules", "", "AcceptTermsOfUse", "Isguest", "Url", "", "temppassword", "userid", "", "(ZZZLjava/lang/String;Ljava/lang/String;I)V", "getAcceptAuctionRules", "()Z", "getAcceptTermsOfUse", "getIsguest", "getUrl", "()Ljava/lang/String;", "getTemppassword", "getUserid", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionRuleResponse.kt */
public final class AuctionRuleResponse {
    private final boolean AcceptAuctionRules;
    private final boolean AcceptTermsOfUse;
    private final boolean Isguest;
    @NotNull
    private final String Url;
    @NotNull
    private final String temppassword;
    private final int userid;

    @NotNull
    public static /* synthetic */ AuctionRuleResponse copy$default(AuctionRuleResponse auctionRuleResponse, boolean z, boolean z2, boolean z3, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = auctionRuleResponse.AcceptAuctionRules;
        }
        if ((i2 & 2) != 0) {
            z2 = auctionRuleResponse.AcceptTermsOfUse;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            z3 = auctionRuleResponse.Isguest;
        }
        boolean z5 = z3;
        if ((i2 & 8) != 0) {
            str = auctionRuleResponse.Url;
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            str2 = auctionRuleResponse.temppassword;
        }
        String str4 = str2;
        if ((i2 & 32) != 0) {
            i = auctionRuleResponse.userid;
        }
        return auctionRuleResponse.copy(z, z4, z5, str3, str4, i);
    }

    public final boolean component1() {
        return this.AcceptAuctionRules;
    }

    public final boolean component2() {
        return this.AcceptTermsOfUse;
    }

    public final boolean component3() {
        return this.Isguest;
    }

    @NotNull
    public final String component4() {
        return this.Url;
    }

    @NotNull
    public final String component5() {
        return this.temppassword;
    }

    public final int component6() {
        return this.userid;
    }

    @NotNull
    public final AuctionRuleResponse copy(boolean z, boolean z2, boolean z3, @NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "Url");
        Intrinsics.checkParameterIsNotNull(str2, "temppassword");
        return new AuctionRuleResponse(z, z2, z3, str, str2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AuctionRuleResponse) {
                AuctionRuleResponse auctionRuleResponse = (AuctionRuleResponse) obj;
                if (this.AcceptAuctionRules == auctionRuleResponse.AcceptAuctionRules) {
                    if (this.AcceptTermsOfUse == auctionRuleResponse.AcceptTermsOfUse) {
                        if ((this.Isguest == auctionRuleResponse.Isguest) && Intrinsics.areEqual((Object) this.Url, (Object) auctionRuleResponse.Url) && Intrinsics.areEqual((Object) this.temppassword, (Object) auctionRuleResponse.temppassword)) {
                            if (this.userid == auctionRuleResponse.userid) {
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
        boolean z = this.AcceptAuctionRules;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.AcceptTermsOfUse;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.Isguest;
        if (!z4) {
            z2 = z4;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        String str = this.Url;
        int i4 = 0;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.temppassword;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return ((hashCode + i4) * 31) + Integer.valueOf(this.userid).hashCode();
    }

    @NotNull
    public String toString() {
        return "AuctionRuleResponse(AcceptAuctionRules=" + this.AcceptAuctionRules + ", AcceptTermsOfUse=" + this.AcceptTermsOfUse + ", Isguest=" + this.Isguest + ", Url=" + this.Url + ", temppassword=" + this.temppassword + ", userid=" + this.userid + ")";
    }

    public AuctionRuleResponse(boolean z, boolean z2, boolean z3, @NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "Url");
        Intrinsics.checkParameterIsNotNull(str2, "temppassword");
        this.AcceptAuctionRules = z;
        this.AcceptTermsOfUse = z2;
        this.Isguest = z3;
        this.Url = str;
        this.temppassword = str2;
        this.userid = i;
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

    @NotNull
    public final String getUrl() {
        return this.Url;
    }

    @NotNull
    public final String getTemppassword() {
        return this.temppassword;
    }

    public final int getUserid() {
        return this.userid;
    }
}
