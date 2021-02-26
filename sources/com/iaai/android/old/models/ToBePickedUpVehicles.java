package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class ToBePickedUpVehicles implements Parcelable {
    public static final Parcelable.Creator<ToBePickedUpVehicles> CREATOR = new Parcelable.Creator<ToBePickedUpVehicles>() {
        public ToBePickedUpVehicles createFromParcel(Parcel parcel) {
            return new ToBePickedUpVehicles(parcel);
        }

        public ToBePickedUpVehicles[] newArray(int i) {
            return new ToBePickedUpVehicles[i];
        }
    };
    @SerializedName("ActionDate")
    public String actionDate;
    @SerializedName("BranchCity")
    public String branchCity;
    @SerializedName("Branchname")
    public String branchName;
    @SerializedName("BranchNumber")
    public String branchNumber;
    @SerializedName("BranchState")
    public String branchState;
    @SerializedName("BranchStreet")
    public String branchStreet;
    @SerializedName("BranchZip")
    public String branchZip;
    @SerializedName("feesAndTax")
    public String feesAndTax;
    @SerializedName("ImageURL")
    public String imageUrl;
    @SerializedName("Itemid")
    public String itemId;
    @SerializedName("Lane_ItemNumber")
    public String laneItemNumber;
    @SerializedName("Make")
    public String make;
    @SerializedName("Model")
    public String model;
    @SerializedName("Notes")
    public String notes;
    @SerializedName("Offsite_Sale_Indicator")
    public String offsiteSaleIndicator;
    @SerializedName("Pin")
    public String pin;
    @SerializedName("PullOutQualified")
    public String pullOutQualified;
    @SerializedName("PullOutRequestID")
    public String pullOutRequestID;
    @SerializedName("Salvage")
    public String salvage;
    @SerializedName("SalvageFeeIndicator")
    public String salvageFeeIndicator;
    @SerializedName("StockNumber")
    public String stockNumber;
    @SerializedName("titileHandlingInstructions")
    public String titileHandlingInstructions;
    @SerializedName("Title")
    public String title;
    @SerializedName("VIN")
    public String vin;
    @SerializedName("Year")
    public String year;
    @SerializedName("YearMakeModel")
    public String yearMakeModel;

    public int describeContents() {
        return 0;
    }

    public ToBePickedUpVehicles() {
    }

    public ToBePickedUpVehicles(Parcel parcel) {
        this.actionDate = parcel.readString();
        this.branchName = parcel.readString();
        this.itemId = parcel.readString();
        this.branchNumber = parcel.readString();
        this.laneItemNumber = parcel.readString();
        this.offsiteSaleIndicator = parcel.readString();
        this.salvage = parcel.readString();
        this.stockNumber = parcel.readString();
        this.make = parcel.readString();
        this.model = parcel.readString();
        this.year = parcel.readString();
        this.yearMakeModel = parcel.readString();
        this.imageUrl = parcel.readString();
        this.vin = parcel.readString();
        this.pin = parcel.readString();
        this.feesAndTax = parcel.readString();
        this.pullOutRequestID = parcel.readString();
        this.titileHandlingInstructions = parcel.readString();
        this.branchCity = parcel.readString();
        this.branchState = parcel.readString();
        this.branchStreet = parcel.readString();
        this.branchZip = parcel.readString();
        this.pullOutQualified = parcel.readString();
        this.salvageFeeIndicator = parcel.readString();
        this.notes = parcel.readString();
        this.title = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionDate);
        parcel.writeString(this.branchName);
        parcel.writeString(this.itemId);
        parcel.writeString(this.branchNumber);
        parcel.writeString(this.laneItemNumber);
        parcel.writeString(this.offsiteSaleIndicator);
        parcel.writeString(this.salvage);
        parcel.writeString(this.stockNumber);
        parcel.writeString(this.make);
        parcel.writeString(this.model);
        parcel.writeString(this.year);
        parcel.writeString(this.yearMakeModel);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.vin);
        parcel.writeString(this.pin);
        parcel.writeString(this.feesAndTax);
        parcel.writeString(this.pullOutRequestID);
        parcel.writeString(this.titileHandlingInstructions);
        parcel.writeString(this.branchCity);
        parcel.writeString(this.branchState);
        parcel.writeString(this.branchStreet);
        parcel.writeString(this.branchZip);
        parcel.writeString(this.pullOutQualified);
        parcel.writeString(this.salvageFeeIndicator);
        parcel.writeString(this.notes);
        parcel.writeString(this.title);
    }

    public String toString() {
        return this.yearMakeModel;
    }
}
