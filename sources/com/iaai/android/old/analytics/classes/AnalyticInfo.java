package com.iaai.android.old.analytics.classes;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.analytics.AnalyticsContract;

public class AnalyticInfo implements Parcelable {
    public static final Parcelable.Creator<AnalyticInfo> CREATOR = new Parcelable.Creator<AnalyticInfo>() {
        public AnalyticInfo createFromParcel(Parcel parcel) {
            return new AnalyticInfo(parcel);
        }

        public AnalyticInfo[] newArray(int i) {
            return new AnalyticInfo[i];
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

    public AnalyticInfo() {
    }

    public AnalyticInfo(Parcel parcel) {
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

    public AnalyticInfo(int i, int i2, int i3, int i4, long j, String str) {
        this.UserID = i;
        this.BranchNumber = i2;
        this.StockNumber = i3;
        this.AnalyticsTypeID = i4;
        this.unixtimestamp = Long.valueOf(j / 1000);
        this.LaneNumber = str;
        this.DeviceVersion = Build.VERSION.RELEASE;
        this.DeviceType = "Android ";
        this.beaconMajor = "0";
        this.beaconMinor = "0";
    }

    public AnalyticInfo(int i, int i2, int i3, int i4, long j, String str, String str2, String str3) {
        this.UserID = i;
        this.BranchNumber = i2;
        this.StockNumber = i3;
        this.AnalyticsTypeID = i4;
        this.unixtimestamp = Long.valueOf(j / 1000);
        this.LaneNumber = str;
        this.DeviceVersion = Build.VERSION.RELEASE;
        this.DeviceType = "Android ";
        this.beaconMajor = str2;
        this.beaconMinor = str3;
    }

    public AnalyticInfo(Cursor cursor) {
        this.mAnalyticsID = 0;
        this.UserID = 0;
        this.BranchNumber = 0;
        this.StockNumber = 0;
        this.AnalyticsTypeID = 0;
        this.unixtimestamp = 0L;
        this.DeviceType = null;
        this.LaneNumber = null;
        this.beaconMajor = "0";
        this.beaconMinor = "0";
        if (cursor != null && !cursor.isAfterLast()) {
            int columnIndex = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_ANALYTICS_ID);
            if (!(columnIndex == -1 || cursor.getString(columnIndex) == null)) {
                this.mAnalyticsID = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_USER_ID);
            if (!(columnIndex2 == -1 || cursor.getString(columnIndex2) == null)) {
                this.UserID = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_BRANCH_NO);
            if (!(columnIndex3 == -1 || cursor.getString(columnIndex3) == null)) {
                this.BranchNumber = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_STOCK_NO);
            if (!(columnIndex4 == -1 || cursor.getString(columnIndex4) == null)) {
                this.StockNumber = cursor.getInt(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("AnalyticsTypeID");
            if (!(columnIndex5 == -1 || cursor.getString(columnIndex5) == null)) {
                this.AnalyticsTypeID = cursor.getInt(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_UTC_DATE);
            if (!(columnIndex6 == -1 || cursor.getString(columnIndex6) == null)) {
                this.unixtimestamp = Long.valueOf(cursor.getLong(columnIndex6));
            }
            int columnIndex7 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_OS_VERSION);
            if (!(columnIndex7 == -1 || cursor.getString(columnIndex7) == null)) {
                this.DeviceType = cursor.getString(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_LANE_NO);
            if (!(columnIndex8 == -1 || cursor.getString(columnIndex8) == null)) {
                this.LaneNumber = cursor.getString(columnIndex8);
            }
            int columnIndex9 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_DEVICE_MODEL_NO);
            if (!(columnIndex9 == -1 || cursor.getString(columnIndex9) == null)) {
                this.DeviceVersion = cursor.getString(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_BEACON_MAJOR);
            if (!(columnIndex10 == -1 || cursor.getString(columnIndex10) == null)) {
                this.beaconMajor = cursor.getString(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex(AnalyticsContract.Analytics.COLUMN_NAME_BEACON_MINOR);
            if (columnIndex11 != -1 && cursor.getString(columnIndex11) != null) {
                this.beaconMinor = cursor.getString(columnIndex11);
            }
        }
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_USER_ID, Integer.valueOf(this.UserID));
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_BRANCH_NO, Integer.valueOf(this.BranchNumber));
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_STOCK_NO, Integer.valueOf(this.StockNumber));
        contentValues.put("AnalyticsTypeID", Integer.valueOf(this.AnalyticsTypeID));
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_UTC_DATE, this.unixtimestamp);
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_OS_VERSION, this.DeviceType);
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_LANE_NO, this.LaneNumber);
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_DEVICE_MODEL_NO, this.DeviceVersion);
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_BEACON_MAJOR, this.beaconMajor);
        contentValues.put(AnalyticsContract.Analytics.COLUMN_NAME_BEACON_MINOR, this.beaconMinor);
        return contentValues;
    }

    public String getLaneNumber() {
        return this.LaneNumber;
    }

    public void setLaneNumber(String str) {
        this.LaneNumber = str;
    }

    public String getOSVersion() {
        return this.DeviceType;
    }

    public void setOSVersion(String str) {
        this.DeviceType = str;
    }

    public Long getUTCDateTime() {
        return this.unixtimestamp;
    }

    public void setUTCDateTime(Long l) {
        this.unixtimestamp = l;
    }

    public int getStockNumber() {
        return this.StockNumber;
    }

    public void setStockNumber(int i) {
        this.StockNumber = i;
    }

    public int getBranchNumber() {
        return this.BranchNumber;
    }

    public void setBranchNumber(int i) {
        this.BranchNumber = i;
    }

    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int i) {
        this.UserID = i;
    }

    public int getAnalyticsID() {
        return this.mAnalyticsID;
    }

    public void setAnalyticsID(int i) {
        this.mAnalyticsID = i;
    }

    public int getAnalyticsTypeID() {
        return this.AnalyticsTypeID;
    }

    public void setAnalyticsTypeID(int i) {
        this.AnalyticsTypeID = i;
    }

    public String getDeviceModel() {
        return this.DeviceVersion;
    }

    public void setDeviceModel(String str) {
        this.DeviceVersion = str;
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
