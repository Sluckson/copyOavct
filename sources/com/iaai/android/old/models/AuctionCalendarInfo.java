package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.JsonSerializer;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class AuctionCalendarInfo implements Parcelable {
    public static final Parcelable.Creator<AuctionCalendarInfo> CREATOR = new Parcelable.Creator<AuctionCalendarInfo>() {
        public AuctionCalendarInfo createFromParcel(Parcel parcel) {
            return new AuctionCalendarInfo(parcel);
        }

        public AuctionCalendarInfo[] newArray(int i) {
            return new AuctionCalendarInfo[i];
        }
    };
    @JsonProperty("AuctionCount")
    public int auctionCount;
    @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
    @JsonProperty("AuctionDate")
    public Date auctionDate;
    @JsonProperty("HasAnnouncement")
    public boolean hasAnnouncement;
    @JsonProperty("HasPublicAuction")
    public boolean hasPublicAuction;

    public int describeContents() {
        return 0;
    }

    public AuctionCalendarInfo() {
    }

    public AuctionCalendarInfo(Parcel parcel) {
        this.auctionCount = parcel.readInt();
        this.auctionDate = ParcelUtils.readDate(parcel);
        this.hasAnnouncement = ParcelUtils.readBoolean(parcel);
        this.hasPublicAuction = ParcelUtils.readBoolean(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.auctionCount);
        ParcelUtils.writeDate(parcel, this.auctionDate);
        ParcelUtils.writeBoolean(parcel, this.hasAnnouncement);
        ParcelUtils.writeBoolean(parcel, this.hasPublicAuction);
    }
}
