package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.codehaus.jackson.annotate.JsonProperty;

public class LightDetails implements Parcelable {
    public static final Parcelable.Creator<LightDetails> CREATOR = new Parcelable.Creator<LightDetails>() {
        public LightDetails createFromParcel(Parcel parcel) {
            return new LightDetails(parcel);
        }

        public LightDetails[] newArray(int i) {
            return new LightDetails[i];
        }
    };
    @JsonProperty("BlueInd")
    public String BlueInd;
    @JsonProperty("CustomAnnouncement")
    public String CustomAnnouncement;
    @JsonProperty("GreenInd")
    public String GreenInd;
    @JsonProperty("RedInd")
    public String RedInd;
    @JsonProperty("SalvageId")
    public int SalvageId;
    @JsonProperty("SalvageLightId")
    public int SalvageLightId;
    @JsonProperty("YellowInd")
    public String YellowInd;

    public int describeContents() {
        return 0;
    }

    public LightDetails() {
    }

    public LightDetails(Parcel parcel) {
        this.BlueInd = parcel.readString();
        this.CustomAnnouncement = parcel.readString();
        this.GreenInd = parcel.readString();
        this.RedInd = parcel.readString();
        this.SalvageId = parcel.readInt();
        this.SalvageLightId = parcel.readInt();
        this.YellowInd = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.BlueInd);
        parcel.writeString(this.CustomAnnouncement);
        parcel.writeString(this.GreenInd);
        parcel.writeString(this.RedInd);
        parcel.writeInt(this.SalvageId);
        parcel.writeInt(this.SalvageLightId);
        parcel.writeString(this.YellowInd);
    }
}
