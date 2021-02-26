package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class PopularRefinerCategories implements Parcelable {
    public static final Parcelable.Creator<PopularRefinerCategories> CREATOR = new Parcelable.Creator<PopularRefinerCategories>() {
        public PopularRefinerCategories createFromParcel(Parcel parcel) {
            return new PopularRefinerCategories(parcel);
        }

        public PopularRefinerCategories[] newArray(int i) {
            return new PopularRefinerCategories[i];
        }
    };
    @SerializedName("ActualValue")
    public String ActualValue;
    @SerializedName("DisplayValue")
    public String DisplayValue;
    @SerializedName("Order")
    public int Order;

    public int describeContents() {
        return 0;
    }

    protected PopularRefinerCategories(Parcel parcel) {
        this.ActualValue = parcel.readString();
        this.DisplayValue = parcel.readString();
        this.Order = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ActualValue);
        parcel.writeString(this.DisplayValue);
        parcel.writeInt(this.Order);
    }

    public PopularRefinerCategories() {
    }
}
