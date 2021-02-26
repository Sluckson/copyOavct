package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class BranchYardHours implements Parcelable {
    public static final Parcelable.Creator<BranchYardHours> CREATOR = new Parcelable.Creator<BranchYardHours>() {
        public BranchYardHours createFromParcel(Parcel parcel) {
            return new BranchYardHours(parcel);
        }

        public BranchYardHours[] newArray(int i) {
            return new BranchYardHours[i];
        }
    };
    @SerializedName("DayNumber")
    public String dayNumber;
    @SerializedName("OfficeDays")
    public String officeDays;
    @SerializedName("OfficeHours")
    public String officeHours;

    public int describeContents() {
        return 0;
    }

    public BranchYardHours() {
    }

    public BranchYardHours(Parcel parcel) {
        this.dayNumber = parcel.readString();
        this.officeDays = parcel.readString();
        this.officeHours = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dayNumber);
        parcel.writeString(this.officeDays);
        parcel.writeString(this.officeHours);
    }
}
