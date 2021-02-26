package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FilterSelect implements Parcelable {
    public static final Parcelable.Creator<FilterSelect> CREATOR = new Parcelable.Creator<FilterSelect>() {
        public FilterSelect createFromParcel(Parcel parcel) {
            return new FilterSelect(parcel);
        }

        public FilterSelect[] newArray(int i) {
            return new FilterSelect[i];
        }
    };
    private int resID;
    public String sel_isSelected;
    public String sel_label;
    public String value;

    public int describeContents() {
        return 0;
    }

    public String getSel_label() {
        return this.sel_label;
    }

    public void setSel_label(String str) {
        this.sel_label = str;
    }

    public String getSel_isSelected() {
        return this.sel_isSelected;
    }

    public void setSel_isSelected(String str) {
        this.sel_isSelected = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public int getResID() {
        return this.resID;
    }

    public void setResID(int i) {
        this.resID = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sel_label);
        parcel.writeString(this.sel_isSelected);
        parcel.writeString(this.value);
        parcel.writeInt(this.resID);
    }

    public FilterSelect() {
    }

    public FilterSelect(Parcel parcel) {
        this.sel_label = parcel.readString();
        this.sel_isSelected = parcel.readString();
        this.value = parcel.readString();
        this.resID = parcel.readInt();
    }
}
