package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import org.codehaus.jackson.annotate.JsonProperty;

public class PrefSetting implements Parcelable {
    public static final Parcelable.Creator<PrefSetting> CREATOR = new Parcelable.Creator<PrefSetting>() {
        public PrefSetting createFromParcel(Parcel parcel) {
            return new PrefSetting(parcel);
        }

        public PrefSetting[] newArray(int i) {
            return new PrefSetting[i];
        }
    };
    @JsonProperty("settingKey")
    public String key;
    @JsonProperty("settingType")
    public String type;
    @JsonProperty("settingValue")
    public String value;

    public int describeContents() {
        return 0;
    }

    public PrefSetting() {
    }

    public PrefSetting(String str, String str2, boolean z) {
        this.key = str;
        this.type = str2;
        this.value = z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
    }

    public PrefSetting(Parcel parcel) {
        this.key = parcel.readString();
        this.type = parcel.readString();
        this.value = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.type);
        parcel.writeString(this.value);
    }
}
