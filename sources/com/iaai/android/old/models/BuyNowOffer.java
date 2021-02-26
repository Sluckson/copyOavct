package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class BuyNowOffer {
    @SerializedName("BuyNowOfferClosingTime")
    public String BuyNowOfferClosingTime;
    @SerializedName("BuyNowOfferCount")
    public int BuyNowOfferCount;
    @SerializedName("MaxBidAwardMessage")
    public String MaxBidAwardMessage;
    @SerializedName("PaymentDate")
    public String PaymentDate;
    @SerializedName("PickUpDate")
    public String PickUpDate;
    @SerializedName("lstTimedVehices")
    public BuyNowOfferVehicleList[] buyNowOfferList;
    @SerializedName("lstBranch")
    public ArrayList<String> listBranch;
    @SerializedName("lstCATEvents")
    public ArrayList<String> listCatEvent;
    @SerializedName("lstMake")
    public ArrayList<String> listMake;
}
