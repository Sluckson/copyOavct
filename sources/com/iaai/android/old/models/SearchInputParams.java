package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.List;

public class SearchInputParams implements Parcelable {
    public static final Parcelable.Creator<SearchInputParams> CREATOR = new Parcelable.Creator<SearchInputParams>() {
        public SearchInputParams createFromParcel(Parcel parcel) {
            return new SearchInputParams(parcel);
        }

        public SearchInputParams[] newArray(int i) {
            return new SearchInputParams[i];
        }
    };
    @SerializedName("CountOfVehicles")
    public int CountOfVehicles;
    @SerializedName("Keyword")
    public String Keyword;
    @SerializedName("Latitude")
    public double Latitude;
    @SerializedName("Longitude")
    public double Longitude;
    @SerializedName("Scope")
    public String Scope;
    @SerializedName("NewSelectedRefiners")
    public List<SelectedRefiner> SelectedRefiners;
    @SerializedName("SortAscending")
    public boolean SortAscending;
    @SerializedName("SortField")
    public String SortField;
    @SerializedName("StartIndex")
    public int StartIndex;

    public int describeContents() {
        return 0;
    }

    public SearchInputParams() {
    }

    public SearchInputParams(Parcel parcel) {
        this.Keyword = parcel.readString();
        this.Latitude = parcel.readDouble();
        this.Longitude = parcel.readDouble();
        this.SortField = parcel.readString();
        this.SortAscending = ParcelUtils.readBoolean(parcel);
        this.StartIndex = parcel.readInt();
        this.CountOfVehicles = parcel.readInt();
        this.Scope = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Keyword);
        parcel.writeDouble(this.Latitude);
        parcel.writeDouble(this.Longitude);
        parcel.writeString(this.SortField);
        ParcelUtils.writeBoolean(parcel, this.SortAscending);
        parcel.writeInt(this.StartIndex);
        parcel.writeInt(this.CountOfVehicles);
        parcel.writeString(this.Scope);
    }
}
