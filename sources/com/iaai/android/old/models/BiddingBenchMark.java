package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;

public class BiddingBenchMark implements Parcelable {
    @JsonProperty("ErrorCode")
    public String errorCode;
    @JsonProperty("InfographContent")
    public String infographContent;
    @JsonProperty("InfographicDate")
    public String infographicDate;
    @JsonProperty("InfographicMonth")
    public String infographicMonth;
    @JsonProperty("InfographicURL")
    public String infographicURL;
    @JsonProperty("isBiddingBenchMark")
    public boolean isBiddingBenchMark;
    @JsonProperty("ReferenceID")
    public String referenceID;
    @JsonProperty("similarStocks")
    public List<SimilarStocks> similarVehicles;

    public int describeContents() {
        return 0;
    }

    public BiddingBenchMark() {
    }

    public BiddingBenchMark(Parcel parcel) {
        this.errorCode = parcel.readString();
        this.infographContent = parcel.readString();
        this.infographicDate = parcel.readString();
        this.infographicMonth = parcel.readString();
        this.infographicURL = parcel.readString();
        this.referenceID = parcel.readString();
        this.isBiddingBenchMark = ParcelUtils.readBoolean(parcel);
        parcel.readTypedList(this.similarVehicles, SimilarStocks.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.errorCode);
        parcel.writeString(this.infographContent);
        parcel.writeString(this.infographicDate);
        parcel.writeString(this.infographicMonth);
        parcel.writeString(this.infographicURL);
        parcel.writeString(this.referenceID);
        ParcelUtils.writeBoolean(parcel, this.isBiddingBenchMark);
        parcel.writeTypedList(this.similarVehicles);
    }

    @JsonSetter("ErrorCode")
    public void setbranchCode(String str) {
        this.errorCode = str;
    }

    @JsonSetter("InfographContent")
    public void setbranchName(String str) {
        this.infographContent = str;
    }

    @JsonSetter("InfographicDate")
    public void setmake(String str) {
        this.infographicDate = str;
    }

    @JsonSetter("infographicMonth")
    public void setmodel(String str) {
        this.infographicMonth = str;
    }

    @JsonSetter("InfographicURL")
    public void setitemId(String str) {
        this.infographicURL = str;
    }

    @JsonSetter("ReferenceID")
    public void setstockNo(String str) {
        this.referenceID = str;
    }

    @JsonSetter("isBiddingBenchMark")
    public void setthumbNailUrl(Boolean bool) {
        this.isBiddingBenchMark = bool.booleanValue();
    }

    @JsonSetter("similarStocks")
    public void setyear(List<SimilarStocks> list) {
        this.similarVehicles = list;
    }
}
