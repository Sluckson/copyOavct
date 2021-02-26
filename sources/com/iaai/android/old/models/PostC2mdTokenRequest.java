package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.codehaus.jackson.annotate.JsonProperty;

public class PostC2mdTokenRequest implements Parcelable {
    public static final Parcelable.Creator<PostC2mdTokenRequest> CREATOR = new Parcelable.Creator<PostC2mdTokenRequest>() {
        public PostC2mdTokenRequest createFromParcel(Parcel parcel) {
            return new PostC2mdTokenRequest(parcel);
        }

        public PostC2mdTokenRequest[] newArray(int i) {
            return new PostC2mdTokenRequest[i];
        }
    };
    @JsonProperty("TokenID")
    public String c2mdToken;
    @JsonProperty("DeviceType")
    public String deviceType;

    public int describeContents() {
        return 0;
    }

    public PostC2mdTokenRequest() {
        this("");
    }

    public PostC2mdTokenRequest(String str) {
        this.c2mdToken = str;
        this.deviceType = "Android";
    }

    public PostC2mdTokenRequest(Parcel parcel) {
        this.c2mdToken = parcel.readString();
        this.deviceType = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c2mdToken);
        parcel.writeString(this.deviceType);
    }
}
