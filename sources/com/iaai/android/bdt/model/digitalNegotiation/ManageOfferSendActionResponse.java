package com.iaai.android.bdt.model.digitalNegotiation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u0006+"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionResponse;", "", "action", "", "negotiationid", "ExternalAuctionId", "ExternalAuctionItemid", "Amount", "", "errormsg", "isSuccess", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "getAmount", "()J", "setAmount", "(J)V", "getExternalAuctionId", "()Ljava/lang/String;", "setExternalAuctionId", "(Ljava/lang/String;)V", "getExternalAuctionItemid", "setExternalAuctionItemid", "getAction", "setAction", "getErrormsg", "setErrormsg", "()I", "getNegotiationid", "setNegotiationid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferSendActionResponse.kt */
public final class ManageOfferSendActionResponse {
    private long Amount;
    @NotNull
    private String ExternalAuctionId;
    @NotNull
    private String ExternalAuctionItemid;
    @NotNull
    private String action;
    @NotNull
    private String errormsg;
    private final int isSuccess;
    @NotNull
    private String negotiationid;

    @NotNull
    public static /* synthetic */ ManageOfferSendActionResponse copy$default(ManageOfferSendActionResponse manageOfferSendActionResponse, String str, String str2, String str3, String str4, long j, String str5, int i, int i2, Object obj) {
        ManageOfferSendActionResponse manageOfferSendActionResponse2 = manageOfferSendActionResponse;
        return manageOfferSendActionResponse.copy((i2 & 1) != 0 ? manageOfferSendActionResponse2.action : str, (i2 & 2) != 0 ? manageOfferSendActionResponse2.negotiationid : str2, (i2 & 4) != 0 ? manageOfferSendActionResponse2.ExternalAuctionId : str3, (i2 & 8) != 0 ? manageOfferSendActionResponse2.ExternalAuctionItemid : str4, (i2 & 16) != 0 ? manageOfferSendActionResponse2.Amount : j, (i2 & 32) != 0 ? manageOfferSendActionResponse2.errormsg : str5, (i2 & 64) != 0 ? manageOfferSendActionResponse2.isSuccess : i);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final String component2() {
        return this.negotiationid;
    }

    @NotNull
    public final String component3() {
        return this.ExternalAuctionId;
    }

    @NotNull
    public final String component4() {
        return this.ExternalAuctionItemid;
    }

    public final long component5() {
        return this.Amount;
    }

    @NotNull
    public final String component6() {
        return this.errormsg;
    }

    public final int component7() {
        return this.isSuccess;
    }

    @NotNull
    public final ManageOfferSendActionResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j, @NotNull String str5, int i) {
        Intrinsics.checkParameterIsNotNull(str, "action");
        Intrinsics.checkParameterIsNotNull(str2, "negotiationid");
        Intrinsics.checkParameterIsNotNull(str3, "ExternalAuctionId");
        Intrinsics.checkParameterIsNotNull(str4, "ExternalAuctionItemid");
        String str6 = str5;
        Intrinsics.checkParameterIsNotNull(str6, "errormsg");
        return new ManageOfferSendActionResponse(str, str2, str3, str4, j, str6, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ManageOfferSendActionResponse) {
                ManageOfferSendActionResponse manageOfferSendActionResponse = (ManageOfferSendActionResponse) obj;
                if (Intrinsics.areEqual((Object) this.action, (Object) manageOfferSendActionResponse.action) && Intrinsics.areEqual((Object) this.negotiationid, (Object) manageOfferSendActionResponse.negotiationid) && Intrinsics.areEqual((Object) this.ExternalAuctionId, (Object) manageOfferSendActionResponse.ExternalAuctionId) && Intrinsics.areEqual((Object) this.ExternalAuctionItemid, (Object) manageOfferSendActionResponse.ExternalAuctionItemid)) {
                    if ((this.Amount == manageOfferSendActionResponse.Amount) && Intrinsics.areEqual((Object) this.errormsg, (Object) manageOfferSendActionResponse.errormsg)) {
                        if (this.isSuccess == manageOfferSendActionResponse.isSuccess) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.action;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.negotiationid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ExternalAuctionId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ExternalAuctionItemid;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Long.valueOf(this.Amount).hashCode()) * 31;
        String str5 = this.errormsg;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((hashCode4 + i) * 31) + Integer.valueOf(this.isSuccess).hashCode();
    }

    @NotNull
    public String toString() {
        return "ManageOfferSendActionResponse(action=" + this.action + ", negotiationid=" + this.negotiationid + ", ExternalAuctionId=" + this.ExternalAuctionId + ", ExternalAuctionItemid=" + this.ExternalAuctionItemid + ", Amount=" + this.Amount + ", errormsg=" + this.errormsg + ", isSuccess=" + this.isSuccess + ")";
    }

    public ManageOfferSendActionResponse(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j, @NotNull String str5, int i) {
        Intrinsics.checkParameterIsNotNull(str, "action");
        Intrinsics.checkParameterIsNotNull(str2, "negotiationid");
        Intrinsics.checkParameterIsNotNull(str3, "ExternalAuctionId");
        Intrinsics.checkParameterIsNotNull(str4, "ExternalAuctionItemid");
        Intrinsics.checkParameterIsNotNull(str5, "errormsg");
        this.action = str;
        this.negotiationid = str2;
        this.ExternalAuctionId = str3;
        this.ExternalAuctionItemid = str4;
        this.Amount = j;
        this.errormsg = str5;
        this.isSuccess = i;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    public final void setAction(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.action = str;
    }

    @NotNull
    public final String getNegotiationid() {
        return this.negotiationid;
    }

    public final void setNegotiationid(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.negotiationid = str;
    }

    @NotNull
    public final String getExternalAuctionId() {
        return this.ExternalAuctionId;
    }

    public final void setExternalAuctionId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.ExternalAuctionId = str;
    }

    @NotNull
    public final String getExternalAuctionItemid() {
        return this.ExternalAuctionItemid;
    }

    public final void setExternalAuctionItemid(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.ExternalAuctionItemid = str;
    }

    public final long getAmount() {
        return this.Amount;
    }

    public final void setAmount(long j) {
        this.Amount = j;
    }

    @NotNull
    public final String getErrormsg() {
        return this.errormsg;
    }

    public final void setErrormsg(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errormsg = str;
    }

    public final int isSuccess() {
        return this.isSuccess;
    }
}
