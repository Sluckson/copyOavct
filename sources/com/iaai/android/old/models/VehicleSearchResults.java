package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.List;

public class VehicleSearchResults implements Parcelable {
    public static final Parcelable.Creator<VehicleSearchResults> CREATOR = new Parcelable.Creator<VehicleSearchResults>() {
        public VehicleSearchResults createFromParcel(Parcel parcel) {
            return new VehicleSearchResults(parcel);
        }

        public VehicleSearchResults[] newArray(int i) {
            return new VehicleSearchResults[i];
        }
    };
    public SearchInputParams SearchInput;
    @SerializedName("SortAscending")
    public boolean SortAscending;
    @SerializedName("SortField")
    public String SortField;
    @SerializedName("TotalVehicleCount")
    public int TotalVehicleCount;
    @SerializedName("Vehicles")
    public List<SearchVehicle> Vehicles;
    @SerializedName("error")
    public String error;

    public int describeContents() {
        return 0;
    }

    protected VehicleSearchResults(Parcel parcel) {
        this.TotalVehicleCount = parcel.readInt();
        this.SortField = parcel.readString();
        this.SortAscending = ParcelUtils.readBoolean(parcel);
        this.error = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.TotalVehicleCount);
        parcel.writeString(this.SortField);
        ParcelUtils.writeBoolean(parcel, this.SortAscending);
        parcel.writeString(this.error);
    }
}
