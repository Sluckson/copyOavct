package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class NewSearchInput implements Parcelable {
    public static final Parcelable.Creator<NewSearchInput> CREATOR = new Parcelable.Creator<NewSearchInput>() {
        public NewSearchInput createFromParcel(Parcel parcel) {
            return new NewSearchInput(parcel);
        }

        public NewSearchInput[] newArray(int i) {
            return new NewSearchInput[i];
        }
    };
    @SerializedName("CountOfVehicles")
    public int CountOfVehicles;
    @SerializedName("Keyword")
    public String Keyword;
    @SerializedName("Latitude")
    public String Latitude;
    @SerializedName("Longitude")
    public String Longitude;
    @SerializedName("Scope")
    public String Scope;
    @SerializedName("SortAscending")
    public boolean SortAscending;
    @SerializedName("SortField")
    public String SortField;
    @SerializedName("StartIndex")
    public int StartIndex;
    @SerializedName("TimeZoneID")
    public int TimeZoneID;
    @SerializedName("RequestedApp")
    public int requestedApp;
    @SerializedName("SelectedRefiners")
    public ArrayList<NewSelectedRefiners> selectedRefiners;
    @SerializedName("SortRule")
    public ArrayList<SortRule> sortRule;

    public int describeContents() {
        return 0;
    }

    public NewSearchInput(Parcel parcel) {
        try {
            this.CountOfVehicles = parcel.readInt();
            this.Keyword = parcel.readString();
            this.Latitude = parcel.readString();
            this.Longitude = parcel.readString();
            this.Scope = parcel.readString();
            this.SortAscending = parcel.readByte() != 0;
            this.SortField = parcel.readString();
            this.StartIndex = parcel.readInt();
            this.TimeZoneID = parcel.readInt();
            this.requestedApp = parcel.readInt();
            this.sortRule = parcel.createTypedArrayList(SortRule.CREATOR);
            this.selectedRefiners = parcel.createTypedArrayList(NewSelectedRefiners.CREATOR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NewSearchInput() {
        this.selectedRefiners = new ArrayList<>();
        this.sortRule = new ArrayList<>();
    }

    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.CountOfVehicles);
            parcel.writeString(this.Keyword);
            parcel.writeString(this.Latitude);
            parcel.writeString(this.Longitude);
            parcel.writeString(this.Scope);
            parcel.writeByte((byte) (this.SortAscending ? 1 : 0));
            parcel.writeString(this.SortField);
            parcel.writeInt(this.StartIndex);
            parcel.writeInt(this.TimeZoneID);
            parcel.writeInt(this.requestedApp);
            parcel.writeTypedList(this.sortRule);
            parcel.writeTypedList(this.selectedRefiners);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
