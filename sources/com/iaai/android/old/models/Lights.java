package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.codehaus.jackson.annotate.JsonProperty;

public class Lights implements Parcelable {
    public static final Parcelable.Creator<Lights> CREATOR = new Parcelable.Creator<Lights>() {
        public Lights createFromParcel(Parcel parcel) {
            return new Lights(parcel);
        }

        public Lights[] newArray(int i) {
            return new Lights[i];
        }
    };
    @JsonProperty("Announcements")
    public AnnouncementsInfo[] announcementsInfoArrayList;
    @JsonProperty("lights")
    public LightDetails lightDetails;

    public int describeContents() {
        return 0;
    }

    public Lights() {
    }

    public Lights(Parcel parcel) {
        try {
            this.lightDetails = (LightDetails) parcel.readParcelable(LightDetails.class.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception in Lights", e.getMessage());
        }
        this.announcementsInfoArrayList = (AnnouncementsInfo[]) parcel.createTypedArray(AnnouncementsInfo.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.lightDetails, 0);
        parcel.writeTypedArray(this.announcementsInfoArrayList, 0);
    }
}
