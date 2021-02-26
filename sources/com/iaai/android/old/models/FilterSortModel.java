package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class FilterSortModel implements Parcelable {
    public static final Parcelable.Creator<FilterSortModel> CREATOR = new Parcelable.Creator<FilterSortModel>() {
        public FilterSortModel createFromParcel(Parcel parcel) {
            return new FilterSortModel(parcel);
        }

        public FilterSortModel[] newArray(int i) {
            return new FilterSortModel[i];
        }
    };
    @SerializedName("auctiondate")
    public String auctiondate;
    @SerializedName("branchcode")
    public int branchcode;
    @SerializedName("cultureCode")
    public String cultureCode;
    @SerializedName("deviceType")
    public String deviceType;
    @SerializedName("deviceVersion")
    public String deviceVersion;
    @SerializedName("direction")
    public String direction;
    @SerializedName("end")
    public int end;
    @SerializedName("endYear")
    public String endYear;
    @SerializedName("lane")
    public String lane;
    @SerializedName("pagesize")
    public int pagesize;
    @SerializedName("sortcolumn")
    public String sortcolumn;
    @SerializedName("start")
    public int start;
    @SerializedName("startYear")
    public String startYear;
    @SerializedName("userid")
    public String userid;
    @SerializedName("vehicleType")
    public String vehicleType;

    public int describeContents() {
        return 0;
    }

    public FilterSortModel() {
    }

    public FilterSortModel(Parcel parcel) {
        this.branchcode = parcel.readInt();
        this.auctiondate = parcel.readString();
        this.start = parcel.readInt();
        this.end = parcel.readInt();
        this.sortcolumn = parcel.readString();
        this.pagesize = parcel.readInt();
        this.direction = parcel.readString();
        this.vehicleType = parcel.readString();
        this.lane = parcel.readString();
        this.cultureCode = parcel.readString();
        this.deviceType = parcel.readString();
        this.startYear = parcel.readString();
        this.endYear = parcel.readString();
        this.userid = parcel.readString();
        this.deviceVersion = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.branchcode);
        parcel.writeString(this.auctiondate);
        parcel.writeInt(this.start);
        parcel.writeInt(this.end);
        parcel.writeString(this.sortcolumn);
        parcel.writeInt(this.pagesize);
        parcel.writeString(this.direction);
        parcel.writeString(this.vehicleType);
        parcel.writeString(this.lane);
        parcel.writeString(this.cultureCode);
        parcel.writeString(this.deviceType);
        parcel.writeString(this.startYear);
        parcel.writeString(this.endYear);
        parcel.writeString(this.userid);
        parcel.writeString(this.deviceType);
    }
}
