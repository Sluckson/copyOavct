package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class LocationInfo implements Parcelable {
    public static final Parcelable.Creator<LocationInfo> CREATOR = new Parcelable.Creator<LocationInfo>() {
        public LocationInfo createFromParcel(Parcel parcel) {
            return new LocationInfo(parcel);
        }

        public LocationInfo[] newArray(int i) {
            return new LocationInfo[i];
        }
    };
    @SerializedName("branchCity")
    public String branchCity;
    @SerializedName("branchCode")
    public String branchCode;
    @SerializedName("branchDistanceRank")
    public String branchDistanceRank;
    @SerializedName("branchFax")
    public String branchFax;
    @SerializedName("branchImage")
    public String branchImage;
    @SerializedName("branchName")
    public String branchName;
    @SerializedName("branchNextAuction")
    public String branchNextAuction;
    @SerializedName("branchNextAuctionDate")
    public String branchNextAuctionDate;
    @SerializedName("branchPhone")
    public String branchPhone;
    @SerializedName("branchState")
    public String branchState;
    @SerializedName("branchState_Display")
    public String branchState_Display;
    @SerializedName("branchStreet")
    public String branchStreet;
    @SerializedName("branch_IBid_ind")
    public String branch_IBid_ind;
    @SerializedName("branch_Lat_Lang_Value")
    public String branch_Lat_Lang_Value;
    @SerializedName("branch_Lat_Value")
    public String branch_Lat_Value;
    @SerializedName("branch_Long_Value")
    public String branch_Long_Value;
    @SerializedName("branch_Public_Ind")
    public String branch_Public_Ind;
    @SerializedName("branchmanageremail")
    public String branchmanageremail;
    @SerializedName("sortBy")
    public String sortBy;
    @SerializedName("sortOrder")
    public String sortOrder;
    @SerializedName("state_Full_Name")
    public String state_Full_Name;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.branchCity);
        parcel.writeString(this.branchCode);
        parcel.writeString(this.branchNextAuction);
        parcel.writeString(this.branchNextAuctionDate);
        parcel.writeString(this.branchDistanceRank);
        parcel.writeString(this.branchFax);
        parcel.writeString(this.branchImage);
        parcel.writeString(this.branchmanageremail);
        parcel.writeString(this.branchName);
        parcel.writeString(this.branchPhone);
        parcel.writeString(this.branchState);
        parcel.writeString(this.branchState_Display);
        parcel.writeString(this.branchStreet);
        parcel.writeString(this.branch_IBid_ind);
        parcel.writeString(this.branch_Lat_Lang_Value);
        parcel.writeString(this.branch_Lat_Value);
        parcel.writeString(this.branch_Long_Value);
        parcel.writeString(this.branch_Public_Ind);
        parcel.writeString(this.sortBy);
        parcel.writeString(this.sortOrder);
        parcel.writeString(this.state_Full_Name);
    }

    private LocationInfo(Parcel parcel) {
        this.branchCity = parcel.readString();
        this.branchCode = parcel.readString();
        this.branchNextAuction = parcel.readString();
        this.branchNextAuctionDate = parcel.readString();
        this.branchDistanceRank = parcel.readString();
        this.branchFax = parcel.readString();
        this.branchImage = parcel.readString();
        this.branchmanageremail = parcel.readString();
        this.branchName = parcel.readString();
        this.branchPhone = parcel.readString();
        this.branchState = parcel.readString();
        this.branchState_Display = parcel.readString();
        this.branchStreet = parcel.readString();
        this.branch_IBid_ind = parcel.readString();
        this.branch_Lat_Lang_Value = parcel.readString();
        this.branch_Lat_Value = parcel.readString();
        this.branch_Long_Value = parcel.readString();
        this.branch_Public_Ind = parcel.readString();
        this.sortBy = parcel.readString();
        this.sortOrder = parcel.readString();
        this.state_Full_Name = parcel.readString();
    }
}
