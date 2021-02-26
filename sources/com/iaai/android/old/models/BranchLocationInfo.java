package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class BranchLocationInfo implements Parcelable {
    public static final Parcelable.Creator<BranchLocationInfo> CREATOR = new Parcelable.Creator<BranchLocationInfo>() {
        public BranchLocationInfo createFromParcel(Parcel parcel) {
            return new BranchLocationInfo(parcel);
        }

        public BranchLocationInfo[] newArray(int i) {
            return new BranchLocationInfo[i];
        }
    };
    @SerializedName("ErrorCode")
    public String ErrorCode;
    @SerializedName("LocationInfo")
    public List<LocationInfo> branchInfo_array;
    @SerializedName("GroupByState")
    public List<StateInfo> groupByState_array;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.groupByState_array);
        parcel.writeString(this.ErrorCode);
        parcel.writeList(this.branchInfo_array);
    }

    private BranchLocationInfo(Parcel parcel) {
        this.groupByState_array = new ArrayList();
        this.branchInfo_array = new ArrayList();
        parcel.readList(this.groupByState_array, StateInfo.class.getClassLoader());
        this.ErrorCode = parcel.readString();
        parcel.readList(this.branchInfo_array, LocationInfo.class.getClassLoader());
    }
}
