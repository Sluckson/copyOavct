package com.iaai.android.old.analytics.classes;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class AnalyticsDataList implements Parcelable {
    public static final Parcelable.Creator<AnalyticsDataList> CREATOR = new Parcelable.Creator<AnalyticsDataList>() {
        public AnalyticsDataList createFromParcel(Parcel parcel) {
            return new AnalyticsDataList(parcel);
        }

        public AnalyticsDataList[] newArray(int i) {
            return new AnalyticsDataList[i];
        }
    };
    @SerializedName("AnalyticsDataList")
    public ArrayList<AnalyticInfoParcelable> AnalyticsDataList;

    public int describeContents() {
        return 0;
    }

    public AnalyticsDataList(Parcel parcel) {
        this.AnalyticsDataList = parcel.readArrayList(AnalyticsDataList.class.getClassLoader());
    }

    public AnalyticsDataList() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.AnalyticsDataList);
    }
}
