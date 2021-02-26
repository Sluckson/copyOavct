package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;

public class SimilarStocks implements Parcelable {
    public static final Parcelable.Creator<SimilarStocks> CREATOR = new Parcelable.Creator<SimilarStocks>() {
        public SimilarStocks createFromParcel(Parcel parcel) {
            return new SimilarStocks(parcel);
        }

        public SimilarStocks[] newArray(int i) {
            return new SimilarStocks[i];
        }
    };
    @JsonIgnore
    public int branchCode;
    @JsonProperty("BranchName")
    public String branchName;
    @JsonProperty("RecommendedItemId")
    public String itemId;
    @JsonProperty("Make")
    public String make;
    @JsonProperty("Model")
    public String model;
    @JsonProperty("StockNo")
    public String stockNo;
    @JsonProperty("ThumbNailUrl")
    public String thumbNailUrl;
    @JsonProperty("Year")
    public String year;

    public int describeContents() {
        return 0;
    }

    public SimilarStocks() {
    }

    public SimilarStocks(Parcel parcel) {
        this.branchCode = parcel.readInt();
        this.branchName = parcel.readString();
        this.make = parcel.readString();
        this.model = parcel.readString();
        this.itemId = parcel.readString();
        this.stockNo = parcel.readString();
        this.thumbNailUrl = parcel.readString();
        this.year = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.branchCode);
        parcel.writeString(this.branchName);
        parcel.writeString(this.make);
        parcel.writeString(this.model);
        parcel.writeString(this.itemId);
        parcel.writeString(this.stockNo);
        parcel.writeString(this.thumbNailUrl);
        parcel.writeString(this.year);
    }

    @JsonSetter("BranchCode")
    public void setbranchCode(int i) {
        this.branchCode = i;
    }

    @JsonSetter("BranchName")
    public void setbranchName(String str) {
        this.branchName = str;
    }

    @JsonSetter("Make")
    public void setmake(String str) {
        this.make = str;
    }

    @JsonSetter("Model")
    public void setmodel(String str) {
        this.model = str;
    }

    @JsonSetter("RecommendedItemId")
    public void setitemId(String str) {
        this.itemId = str;
    }

    @JsonSetter("StockNo")
    public void setstockNo(String str) {
        this.stockNo = str;
    }

    @JsonSetter("ThumbNailUrl")
    public void setthumbNailUrl(String str) {
        this.thumbNailUrl = str;
    }

    @JsonSetter("Year")
    public void setyear(String str) {
        this.year = str;
    }
}
