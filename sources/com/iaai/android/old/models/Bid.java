package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import java.math.BigDecimal;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Bid implements Parcelable {
    public static final Parcelable.Creator<Bid> CREATOR = new Parcelable.Creator<Bid>() {
        public Bid createFromParcel(Parcel parcel) {
            return new Bid(parcel);
        }

        public Bid[] newArray(int i) {
            return new Bid[i];
        }
    };
    @JsonIgnore
    public BigDecimal currentBidAmount;
    @JsonProperty("MaxBid")
    public BigDecimal maxBidAmount;

    public int describeContents() {
        return 0;
    }

    public Bid() {
    }

    public Bid(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        this.currentBidAmount = bigDecimal;
        this.maxBidAmount = bigDecimal2;
    }

    public Bid(Parcel parcel) {
        this.currentBidAmount = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
        this.maxBidAmount = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
    }

    @JsonProperty("CurrentBid")
    public String getCurrentBidAmountString() {
        BigDecimal bigDecimal = this.currentBidAmount;
        if (bigDecimal == null) {
            bigDecimal = BigDecimal.ZERO;
        }
        return bigDecimal.toString();
    }

    @JsonProperty("CurrentBid")
    public void setCurrentBidAmountString(String str) {
        this.currentBidAmount = ParcelUtils.toBigDecimal(str);
    }

    @JsonIgnore
    public String getMaxBidAmountString() {
        BigDecimal bigDecimal = this.maxBidAmount;
        if (bigDecimal == null) {
            bigDecimal = BigDecimal.ZERO;
        }
        return bigDecimal.toString();
    }

    public void setMaxBidAmountString(String str) {
        this.maxBidAmount = ParcelUtils.toBigDecimal(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.currentBidAmount);
        parcel.writeValue(this.maxBidAmount);
    }
}
