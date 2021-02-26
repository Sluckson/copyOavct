package com.iaai.android.bdt.model.digitalNegotiation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0012JX\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017¨\u0006-"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionRequestBody;", "", "action", "", "negotiationid", "ExternalAuctionId", "ExternalAuctionItemid", "Amount", "", "StockNumber", "BranchCode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;)V", "getAmount", "()J", "setAmount", "(J)V", "getBranchCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExternalAuctionId", "()Ljava/lang/String;", "setExternalAuctionId", "(Ljava/lang/String;)V", "getExternalAuctionItemid", "setExternalAuctionItemid", "getStockNumber", "getAction", "setAction", "getNegotiationid", "setNegotiationid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionRequestBody;", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferSendActionRequestBody.kt */
public final class ManageOfferSendActionRequestBody {
    private long Amount;
    @Nullable
    private final Integer BranchCode;
    @NotNull
    private String ExternalAuctionId;
    @NotNull
    private String ExternalAuctionItemid;
    @Nullable
    private final String StockNumber;
    @NotNull
    private String action;
    @NotNull
    private String negotiationid;

    @NotNull
    public static /* synthetic */ ManageOfferSendActionRequestBody copy$default(ManageOfferSendActionRequestBody manageOfferSendActionRequestBody, String str, String str2, String str3, String str4, long j, String str5, Integer num, int i, Object obj) {
        ManageOfferSendActionRequestBody manageOfferSendActionRequestBody2 = manageOfferSendActionRequestBody;
        return manageOfferSendActionRequestBody.copy((i & 1) != 0 ? manageOfferSendActionRequestBody2.action : str, (i & 2) != 0 ? manageOfferSendActionRequestBody2.negotiationid : str2, (i & 4) != 0 ? manageOfferSendActionRequestBody2.ExternalAuctionId : str3, (i & 8) != 0 ? manageOfferSendActionRequestBody2.ExternalAuctionItemid : str4, (i & 16) != 0 ? manageOfferSendActionRequestBody2.Amount : j, (i & 32) != 0 ? manageOfferSendActionRequestBody2.StockNumber : str5, (i & 64) != 0 ? manageOfferSendActionRequestBody2.BranchCode : num);
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

    @Nullable
    public final String component6() {
        return this.StockNumber;
    }

    @Nullable
    public final Integer component7() {
        return this.BranchCode;
    }

    @NotNull
    public final ManageOfferSendActionRequestBody copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j, @Nullable String str5, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "action");
        Intrinsics.checkParameterIsNotNull(str2, "negotiationid");
        Intrinsics.checkParameterIsNotNull(str3, "ExternalAuctionId");
        Intrinsics.checkParameterIsNotNull(str4, "ExternalAuctionItemid");
        return new ManageOfferSendActionRequestBody(str, str2, str3, str4, j, str5, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ManageOfferSendActionRequestBody) {
                ManageOfferSendActionRequestBody manageOfferSendActionRequestBody = (ManageOfferSendActionRequestBody) obj;
                if (Intrinsics.areEqual((Object) this.action, (Object) manageOfferSendActionRequestBody.action) && Intrinsics.areEqual((Object) this.negotiationid, (Object) manageOfferSendActionRequestBody.negotiationid) && Intrinsics.areEqual((Object) this.ExternalAuctionId, (Object) manageOfferSendActionRequestBody.ExternalAuctionId) && Intrinsics.areEqual((Object) this.ExternalAuctionItemid, (Object) manageOfferSendActionRequestBody.ExternalAuctionItemid)) {
                    if (!(this.Amount == manageOfferSendActionRequestBody.Amount) || !Intrinsics.areEqual((Object) this.StockNumber, (Object) manageOfferSendActionRequestBody.StockNumber) || !Intrinsics.areEqual((Object) this.BranchCode, (Object) manageOfferSendActionRequestBody.BranchCode)) {
                        return false;
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
        String str5 = this.StockNumber;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.BranchCode;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        return "ManageOfferSendActionRequestBody(action=" + this.action + ", negotiationid=" + this.negotiationid + ", ExternalAuctionId=" + this.ExternalAuctionId + ", ExternalAuctionItemid=" + this.ExternalAuctionItemid + ", Amount=" + this.Amount + ", StockNumber=" + this.StockNumber + ", BranchCode=" + this.BranchCode + ")";
    }

    public ManageOfferSendActionRequestBody(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j, @Nullable String str5, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "action");
        Intrinsics.checkParameterIsNotNull(str2, "negotiationid");
        Intrinsics.checkParameterIsNotNull(str3, "ExternalAuctionId");
        Intrinsics.checkParameterIsNotNull(str4, "ExternalAuctionItemid");
        this.action = str;
        this.negotiationid = str2;
        this.ExternalAuctionId = str3;
        this.ExternalAuctionItemid = str4;
        this.Amount = j;
        this.StockNumber = str5;
        this.BranchCode = num;
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

    @Nullable
    public final String getStockNumber() {
        return this.StockNumber;
    }

    @Nullable
    public final Integer getBranchCode() {
        return this.BranchCode;
    }
}
