package com.iaai.android.bdt.model.MyAccount;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR&\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R&\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$¨\u0006+"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListResponse;", "", "()V", "BuyNowOfferClosingTime", "", "getBuyNowOfferClosingTime", "()Ljava/lang/String;", "setBuyNowOfferClosingTime", "(Ljava/lang/String;)V", "BuyNowOfferCount", "", "getBuyNowOfferCount", "()I", "setBuyNowOfferCount", "(I)V", "MaxBidAwardMessage", "getMaxBidAwardMessage", "setMaxBidAwardMessage", "PaymentDate", "getPaymentDate", "setPaymentDate", "PickUpDate", "getPickUpDate", "setPickUpDate", "buyNowOfferList", "", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel;", "getBuyNowOfferList", "()Ljava/util/List;", "setBuyNowOfferList", "(Ljava/util/List;)V", "listBranch", "Ljava/util/ArrayList;", "getListBranch", "()Ljava/util/ArrayList;", "setListBranch", "(Ljava/util/ArrayList;)V", "listCatEvent", "getListCatEvent", "setListCatEvent", "listMake", "getListMake", "setListMake", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListResponse.kt */
public final class BuyNowOfferListResponse {
    @SerializedName("BuyNowOfferClosingTime")
    @Nullable
    @Expose
    private String BuyNowOfferClosingTime;
    @SerializedName("BuyNowOfferCount")
    @Expose
    private int BuyNowOfferCount;
    @SerializedName("MaxBidAwardMessage")
    @Nullable
    @Expose
    private String MaxBidAwardMessage;
    @SerializedName("PaymentDate")
    @Nullable
    @Expose
    private String PaymentDate;
    @SerializedName("PickUpDate")
    @Nullable
    @Expose
    private String PickUpDate;
    @Nullable
    @SerializedName("lstTimedVehices")
    @Expose
    private List<BuyNowOfferListModel> buyNowOfferList;
    @Nullable
    @SerializedName("lstBranch")
    @Expose
    private ArrayList<String> listBranch;
    @Nullable
    @SerializedName("lstCATEvents")
    @Expose
    private ArrayList<String> listCatEvent;
    @Nullable
    @SerializedName("lstMake")
    @Expose
    private ArrayList<String> listMake;

    @Nullable
    public final ArrayList<String> getListMake() {
        return this.listMake;
    }

    public final void setListMake(@Nullable ArrayList<String> arrayList) {
        this.listMake = arrayList;
    }

    @Nullable
    public final ArrayList<String> getListBranch() {
        return this.listBranch;
    }

    public final void setListBranch(@Nullable ArrayList<String> arrayList) {
        this.listBranch = arrayList;
    }

    @Nullable
    public final ArrayList<String> getListCatEvent() {
        return this.listCatEvent;
    }

    public final void setListCatEvent(@Nullable ArrayList<String> arrayList) {
        this.listCatEvent = arrayList;
    }

    @Nullable
    public final List<BuyNowOfferListModel> getBuyNowOfferList() {
        return this.buyNowOfferList;
    }

    public final void setBuyNowOfferList(@Nullable List<BuyNowOfferListModel> list) {
        this.buyNowOfferList = list;
    }

    @Nullable
    public final String getPickUpDate() {
        return this.PickUpDate;
    }

    public final void setPickUpDate(@Nullable String str) {
        this.PickUpDate = str;
    }

    @Nullable
    public final String getPaymentDate() {
        return this.PaymentDate;
    }

    public final void setPaymentDate(@Nullable String str) {
        this.PaymentDate = str;
    }

    @Nullable
    public final String getMaxBidAwardMessage() {
        return this.MaxBidAwardMessage;
    }

    public final void setMaxBidAwardMessage(@Nullable String str) {
        this.MaxBidAwardMessage = str;
    }

    @Nullable
    public final String getBuyNowOfferClosingTime() {
        return this.BuyNowOfferClosingTime;
    }

    public final void setBuyNowOfferClosingTime(@Nullable String str) {
        this.BuyNowOfferClosingTime = str;
    }

    public final int getBuyNowOfferCount() {
        return this.BuyNowOfferCount;
    }

    public final void setBuyNowOfferCount(int i) {
        this.BuyNowOfferCount = i;
    }
}
