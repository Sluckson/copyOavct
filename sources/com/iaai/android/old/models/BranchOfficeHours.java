package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class BranchOfficeHours implements Parcelable {
    public static final Parcelable.Creator<BranchOfficeHours> CREATOR = new Parcelable.Creator<BranchOfficeHours>() {
        public BranchOfficeHours createFromParcel(Parcel parcel) {
            return new BranchOfficeHours(parcel);
        }

        public BranchOfficeHours[] newArray(int i) {
            return new BranchOfficeHours[i];
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

    public BranchOfficeHours() {
    }

    public BranchOfficeHours(Parcel parcel) {
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
