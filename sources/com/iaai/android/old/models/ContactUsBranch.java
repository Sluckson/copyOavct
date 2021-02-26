package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class ContactUsBranch implements Parcelable {
    public static final Parcelable.Creator<ContactUsBranch> CREATOR = new Parcelable.Creator<ContactUsBranch>() {
        public ContactUsBranch createFromParcel(Parcel parcel) {
            return new ContactUsBranch(parcel);
        }

        public ContactUsBranch[] newArray(int i) {
            return new ContactUsBranch[i];
        }
    };
    @SerializedName("branchCity")
    public String city;
    @SerializedName("branchCode")
    public String code;
    @SerializedName("branchDistanceRank")
    public String distanceRank;
    @SerializedName("branchFax")
    public String fax;
    @SerializedName("branch_IBid_ind")
    public String iBidIndicator;
    @SerializedName("branch_Lat_Lang_Value")
    public String latLangValue;
    @SerializedName("branch_Lat_Value")
    public String latValue;
    @SerializedName("branch_Long_Value")
    public String longValue;
    @SerializedName("branchmanageremail")
    public String managerEmail;
    @SerializedName("branchName")
    public String name;
    @SerializedName("branchPhone")
    public String phone;
    @SerializedName("branch_Public_Ind")
    public String publicIndicator;
    @SerializedName("branchState")
    public String state;
    @SerializedName("branchState_Display")
    public String stateDisplay;
    @SerializedName("branchStreet")
    public String street;

    public int describeContents() {
        return 0;
    }

    public ContactUsBranch(Parcel parcel) {
        this.city = parcel.readString();
        this.code = parcel.readString();
        this.distanceRank = parcel.readString();
        this.fax = parcel.readString();
        this.name = parcel.readString();
        this.phone = parcel.readString();
        this.state = parcel.readString();
        this.stateDisplay = parcel.readString();
        this.street = parcel.readString();
        this.iBidIndicator = parcel.readString();
        this.latLangValue = parcel.readString();
        this.latValue = parcel.readString();
        this.longValue = parcel.readString();
        this.publicIndicator = parcel.readString();
        this.managerEmail = parcel.readString();
    }

    public ContactUsBranch() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.city);
        parcel.writeString(this.code);
        parcel.writeString(this.distanceRank);
        parcel.writeString(this.fax);
        parcel.writeString(this.name);
        parcel.writeString(this.phone);
        parcel.writeString(this.state);
        parcel.writeString(this.stateDisplay);
        parcel.writeString(this.street);
        parcel.writeString(this.iBidIndicator);
        parcel.writeString(this.latLangValue);
        parcel.writeString(this.latValue);
        parcel.writeString(this.longValue);
        parcel.writeString(this.publicIndicator);
        parcel.writeString(this.managerEmail);
    }
}
