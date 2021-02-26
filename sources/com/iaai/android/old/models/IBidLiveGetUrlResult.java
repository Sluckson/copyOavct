package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import org.codehaus.jackson.annotate.JsonProperty;

public class IBidLiveGetUrlResult implements Parcelable {
    public static final Parcelable.Creator<IBidLiveGetUrlResult> CREATOR = new Parcelable.Creator<IBidLiveGetUrlResult>() {
        public IBidLiveGetUrlResult createFromParcel(Parcel parcel) {
            return new IBidLiveGetUrlResult(parcel);
        }

        public IBidLiveGetUrlResult[] newArray(int i) {
            return new IBidLiveGetUrlResult[i];
        }
    };
    @JsonProperty("NFInd")
    public boolean NFInd;
    @JsonProperty("errormessage")
    public String message;
    public String url;

    public int describeContents() {
        return 0;
    }

    public IBidLiveGetUrlResult() {
    }

    public IBidLiveGetUrlResult(Parcel parcel) {
        this.url = parcel.readString();
        this.message = parcel.readString();
        this.NFInd = ParcelUtils.readBoolean(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.message);
        ParcelUtils.writeBoolean(parcel, this.NFInd);
    }
}
