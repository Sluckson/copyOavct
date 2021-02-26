package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class PostSettingsRequest implements Parcelable {
    public static final Parcelable.Creator<PostSettingsRequest> CREATOR = new Parcelable.Creator<PostSettingsRequest>() {
        public PostSettingsRequest createFromParcel(Parcel parcel) {
            return new PostSettingsRequest(parcel);
        }

        public PostSettingsRequest[] newArray(int i) {
            return new PostSettingsRequest[i];
        }
    };
    public ArrayList<PrefSetting> settings;
    public String token;
    public String userId;

    public int describeContents() {
        return 0;
    }

    public PostSettingsRequest() {
    }

    public PostSettingsRequest(String str, String str2, ArrayList<PrefSetting> arrayList) {
        this.userId = str;
        this.token = str2;
        this.settings = arrayList;
    }

    public PostSettingsRequest(Parcel parcel) {
        this.userId = parcel.readString();
        this.token = parcel.readString();
        this.settings = parcel.createTypedArrayList(PrefSetting.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.token);
        parcel.writeTypedList(this.settings);
    }
}
