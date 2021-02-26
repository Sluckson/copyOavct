package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.Comparator;

public class RefinersForDisplay implements Parcelable, Comparator<RefinersForDisplay> {
    public static final Parcelable.Creator<RefinersForDisplay> CREATOR = new Parcelable.Creator<RefinersForDisplay>() {
        public RefinersForDisplay createFromParcel(Parcel parcel) {
            return new RefinersForDisplay(parcel);
        }

        public RefinersForDisplay[] newArray(int i) {
            return new RefinersForDisplay[i];
        }
    };
    private String RefinerTypeValue;
    private String RefinerValue;
    private boolean isRefinerSelected;
    public String refiner_display_value;

    public int describeContents() {
        return 0;
    }

    public RefinersForDisplay(String str, String str2, boolean z) {
        this.RefinerTypeValue = str;
        this.RefinerValue = str2;
        this.isRefinerSelected = z;
    }

    public RefinersForDisplay(String str, String str2, boolean z, String str3) {
        this.RefinerTypeValue = str;
        this.RefinerValue = str2;
        this.isRefinerSelected = z;
        this.refiner_display_value = str3;
    }

    public RefinersForDisplay() {
    }

    public String getRefinerTypeValue() {
        return this.RefinerTypeValue;
    }

    public void setRefinerTypeValue(String str) {
        this.RefinerTypeValue = str;
    }

    public String getRefinerValue() {
        return this.RefinerValue;
    }

    public void setRefinerValue(String str) {
        this.RefinerValue = str;
    }

    public boolean isRefinerSelected() {
        return this.isRefinerSelected;
    }

    public void setRefinerSelected(boolean z) {
        this.isRefinerSelected = z;
    }

    protected RefinersForDisplay(Parcel parcel) {
        this.RefinerTypeValue = parcel.readString();
        this.RefinerValue = parcel.readString();
        this.isRefinerSelected = ParcelUtils.readBoolean(parcel);
        this.refiner_display_value = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.RefinerTypeValue);
        parcel.writeString(this.RefinerValue);
        ParcelUtils.writeBoolean(parcel, this.isRefinerSelected);
        parcel.writeString(this.refiner_display_value);
    }

    public int compare(RefinersForDisplay refinersForDisplay, RefinersForDisplay refinersForDisplay2) {
        return Boolean.valueOf(refinersForDisplay2.isRefinerSelected).compareTo(Boolean.valueOf(refinersForDisplay.isRefinerSelected));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RefinersForDisplay)) {
            return super.equals(obj);
        }
        RefinersForDisplay refinersForDisplay = (RefinersForDisplay) obj;
        return this.RefinerValue.equalsIgnoreCase(refinersForDisplay.RefinerValue) && this.isRefinerSelected == refinersForDisplay.isRefinerSelected;
    }

    public int hashCode() {
        String str = this.RefinerValue;
        return (str != null ? str.hashCode() : 0) * 17;
    }
}
