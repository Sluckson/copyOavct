package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;

public class EmptyPost implements Parcelable {
    public static final Parcelable.Creator<EmptyPost> CREATOR = new Parcelable.Creator<EmptyPost>() {
        public EmptyPost createFromParcel(Parcel parcel) {
            return new EmptyPost(parcel);
        }

        public EmptyPost[] newArray(int i) {
            return new EmptyPost[i];
        }
    };
    public static final EmptyPost INSTANCE = new EmptyPost();
    public String dummy;

    public int describeContents() {
        return 0;
    }

    public EmptyPost() {
    }

    public EmptyPost(Parcel parcel) {
        this.dummy = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dummy);
    }
}
