package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Refiner implements Parcelable {
    public static final Parcelable.Creator<Refiner> CREATOR = new Parcelable.Creator<Refiner>() {
        public Refiner createFromParcel(Parcel parcel) {
            return new Refiner(parcel);
        }

        public Refiner[] newArray(int i) {
            return new Refiner[i];
        }
    };
    public String refinerDisplayName;
    public String refinerName;
    @JsonProperty("refinervalues")
    public List<RefinerValue> refinerValues;
    @JsonIgnore
    public RefinerValue selectedValue;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        RefinerValue refinerValue = this.selectedValue;
        if (refinerValue == null) {
            return this.refinerDisplayName;
        }
        return String.format("%s : %s", new Object[]{this.refinerDisplayName, refinerValue.value});
    }

    public Refiner(Parcel parcel) {
        this.refinerDisplayName = parcel.readString();
        this.refinerName = parcel.readString();
        parcel.readTypedList(this.refinerValues, RefinerValue.CREATOR);
        this.selectedValue = (RefinerValue) parcel.readParcelable(RefinerValue.class.getClassLoader());
    }

    public Refiner() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.refinerDisplayName);
        parcel.writeString(this.refinerName);
        parcel.writeTypedList(this.refinerValues);
        parcel.writeParcelable(this.selectedValue, 0);
    }
}
