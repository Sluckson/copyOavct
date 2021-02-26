package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.JsonSerializer;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class BidHistory implements Parcelable {
    public static final Parcelable.Creator<BidHistory> CREATOR = new Parcelable.Creator<BidHistory>() {
        public BidHistory createFromParcel(Parcel parcel) {
            return new BidHistory(parcel);
        }

        public BidHistory[] newArray(int i) {
            return new BidHistory[i];
        }
    };
    @JsonProperty("_amount")
    public int amount;
    @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
    @JsonProperty("_date")
    public Date date;
    @JsonProperty("_UserName")
    public String username;

    public int describeContents() {
        return 0;
    }

    public BidHistory() {
    }

    public BidHistory(Parcel parcel) {
        this.username = parcel.readString();
        this.amount = parcel.readInt();
        this.date = ParcelUtils.readDate(parcel);
    }

    public boolean isPlacedByCurrentUser() {
        return "You".equals(this.username);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.amount);
        ParcelUtils.writeDate(parcel, this.date);
    }
}
