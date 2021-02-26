package com.iaai.android.old.analytics.classes;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.analytics.AnalyticUtils;

public class AnalyticInfoParcelable implements Parcelable {
    public static final Parcelable.Creator<AnalyticInfoParcelable> CREATOR = new Parcelable.Creator<AnalyticInfoParcelable>() {
        public AnalyticInfoParcelable createFromParcel(Parcel parcel) {
            return new AnalyticInfoParcelable(parcel);
        }

        public AnalyticInfoParcelable[] newArray(int i) {
            return new AnalyticInfoParcelable[i];
        }
    };
    @SerializedName("AnalyticsTypeID")
    public int AnalyticsTypeID;
    @SerializedName("BranchNumber")
    public int BranchNumber;
    @SerializedName("DeviceType")
    public String DeviceType;
    @SerializedName("DeviceVersion")
    public String DeviceVersion;
    @SerializedName("LaneNumber")
    public String LaneNumber;
    @SerializedName("StockNumber")
    public int StockNumber;
    @SerializedName("UserID")
    public int UserID;
    @SerializedName("Major")
    public String beaconMajor;
    @SerializedName("Minor")
    public String beaconMinor;
    public int mAnalyticsID;
    @SerializedName("unixtimestamp")
    public Long unixtimestamp;

    public int describeContents() {
        return 0;
    }

    public AnalyticInfoParcelable() {
    }

    public AnalyticInfoParcelable(Parcel parcel) {
        this.UserID = parcel.readInt();
        this.BranchNumber = parcel.readInt();
        this.StockNumber = parcel.readInt();
        this.AnalyticsTypeID = parcel.readInt();
        this.unixtimestamp = Long.valueOf(parcel.readLong());
        this.LaneNumber = parcel.readString();
        this.DeviceVersion = parcel.readString();
        this.DeviceType = parcel.readString();
        this.beaconMajor = parcel.readString();
        this.beaconMinor = parcel.readString();
    }

    public AnalyticInfoParcelable(int i, int i2, int i3, int i4, long j, String str) {
        this.UserID = i;
        this.BranchNumber = i2;
        this.StockNumber = i3;
        this.AnalyticsTypeID = i4;
        this.unixtimestamp = Long.valueOf(j / 1000);
        this.LaneNumber = str;
        this.DeviceVersion = AnalyticUtils.getDeviceName();
        this.DeviceType = "Android " + Build.VERSION.RELEASE;
        this.beaconMajor = "0";
        this.beaconMinor = "0";
    }

    public AnalyticInfoParcelable(int i, int i2, int i3, int i4, long j, String str, String str2, String str3) {
        this.UserID = i;
        this.BranchNumber = i2;
        this.StockNumber = i3;
        this.AnalyticsTypeID = i4;
        this.unixtimestamp = Long.valueOf(j / 1000);
        this.LaneNumber = str;
        this.DeviceVersion = AnalyticUtils.getDeviceName();
        this.DeviceType = "Android " + Build.VERSION.RELEASE;
        this.beaconMajor = str2;
        this.beaconMinor = str3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.UserID);
        parcel.writeInt(this.BranchNumber);
        parcel.writeInt(this.StockNumber);
        parcel.writeInt(this.AnalyticsTypeID);
        parcel.writeLong(this.unixtimestamp.longValue());
        parcel.writeString(this.LaneNumber);
        parcel.writeString(this.DeviceVersion);
        parcel.writeString(this.DeviceType);
        parcel.writeString(this.beaconMajor);
        parcel.writeString(this.beaconMinor);
    }
}
