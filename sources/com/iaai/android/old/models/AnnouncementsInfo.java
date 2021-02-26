package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.codehaus.jackson.annotate.JsonProperty;

public class AnnouncementsInfo implements Parcelable {
    public static final Parcelable.Creator<AnnouncementsInfo> CREATOR = new Parcelable.Creator<AnnouncementsInfo>() {
        public AnnouncementsInfo createFromParcel(Parcel parcel) {
            return new AnnouncementsInfo(parcel);
        }

        public AnnouncementsInfo[] newArray(int i) {
            return new AnnouncementsInfo[i];
        }
    };
    @JsonProperty("AnnouncementTypeDescription")
    public String announcementTypeDescription;
    @JsonProperty("AnnouncementTypeId")
    public int announcementTypeId;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("DisplayOrder")
    public int displayOrder;
    @JsonProperty("SalvageId")
    public int salvageId;

    public int describeContents() {
        return 0;
    }

    public AnnouncementsInfo() {
    }

    public AnnouncementsInfo(Parcel parcel) {
        this.announcementTypeDescription = parcel.readString();
        this.announcementTypeId = parcel.readInt();
        this.description = parcel.readString();
        this.displayOrder = parcel.readInt();
        this.salvageId = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.announcementTypeDescription);
        parcel.writeInt(this.announcementTypeId);
        parcel.writeString(this.description);
        parcel.writeInt(this.displayOrder);
        parcel.writeInt(this.salvageId);
    }
}
