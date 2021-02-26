package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSetter;

public class AuctionDate implements Parcelable {
    public static final Parcelable.Creator<AuctionDate> CREATOR = new Parcelable.Creator<AuctionDate>() {
        public AuctionDate createFromParcel(Parcel parcel) {
            return new AuctionDate(parcel);
        }

        public AuctionDate[] newArray(int i) {
            return new AuctionDate[i];
        }
    };
    @JsonIgnore
    public Date date;
    public String display;
    @JsonIgnore
    public String webServiceValue;

    public int describeContents() {
        return 0;
    }

    @JsonSetter("valueforservicecall")
    public void setValueForServiceCall(String str) {
        this.webServiceValue = str;
        this.date = DateHelper.parse(str, Constants.DATE_PATTERN_WEBSERVICE_PARAM);
    }

    public AuctionDate() {
    }

    public AuctionDate(Parcel parcel) {
        this.display = parcel.readString();
        this.date = (Date) parcel.readValue(Date.class.getClassLoader());
        this.webServiceValue = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.display);
        parcel.writeValue(this.date);
        parcel.writeString(this.webServiceValue);
    }
}
