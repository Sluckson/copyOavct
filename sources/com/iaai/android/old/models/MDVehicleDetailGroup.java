package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonProperty;

public class MDVehicleDetailGroup implements Parcelable {
    public static final Parcelable.Creator<MDVehicleDetailGroup> CREATOR = new Parcelable.Creator<MDVehicleDetailGroup>() {
        public MDVehicleDetailGroup createFromParcel(Parcel parcel) {
            return new MDVehicleDetailGroup(parcel);
        }

        public MDVehicleDetailGroup[] newArray(int i) {
            return new MDVehicleDetailGroup[i];
        }
    };
    @JsonProperty("DeepZoomImages")
    public DZImageURLKeyData[] DeepZoomImages;
    @JsonProperty("Action")
    public MDVehicleDetailItem[] action_value;
    @JsonProperty("CheckinAttributes")
    public MDVehicleDetailItem[] checkin_attributes;
    @JsonProperty("ConditionCheck")
    public MDVehicleDetailItem[] conditioncheck_value;
    @JsonProperty("Features")
    public MDVehicleDetailItem[] features_value;
    @JsonProperty("FullImages")
    public ArrayList<String> fullImages_value;
    @JsonProperty("Header")
    public MDVehicleDetailItem[] header_value;
    @JsonProperty("Icons")
    public MDVehicleDetailItem[] icons_value;
    @JsonProperty("Lights")
    public Lights lights;
    @JsonProperty("Location")
    public MDVehicleDetailItem[] location_value;
    @JsonProperty("Recipts")
    public ArrayList<String> recipts_value;
    @JsonProperty("Reports")
    public MDVehicleDetailItem[] reports_value;
    @JsonProperty("SaleInfo")
    public MDVehicleDetailItem[] saleinfo_value;
    @JsonProperty("ThumbnailImages")
    public ArrayList<String> thumbnailimages_value;
    @JsonProperty("Vehicle")
    public MDVehicleDetailItem[] vehicle_value;

    public int describeContents() {
        return 0;
    }

    public MDVehicleDetailGroup() {
    }

    public MDVehicleDetailGroup(Parcel parcel) {
        this.action_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        this.conditioncheck_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        this.features_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        this.header_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        this.icons_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        this.location_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        this.saleinfo_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        this.vehicle_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        this.thumbnailimages_value = new ArrayList<>();
        this.fullImages_value = new ArrayList<>();
        this.recipts_value = new ArrayList<>();
        this.header_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        parcel.readStringList(this.thumbnailimages_value);
        parcel.readStringList(this.fullImages_value);
        parcel.readStringList(this.recipts_value);
        this.reports_value = (MDVehicleDetailItem[]) parcel.createTypedArray(MDVehicleDetailItem.CREATOR);
        try {
            this.lights = (Lights) parcel.readParcelable(Lights.class.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception in lights", e.getMessage());
        }
        this.DeepZoomImages = (DZImageURLKeyData[]) parcel.createTypedArray(DZImageURLKeyData.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.action_value, 0);
        parcel.writeTypedArray(this.conditioncheck_value, 0);
        parcel.writeTypedArray(this.features_value, 0);
        parcel.writeTypedArray(this.header_value, 0);
        parcel.writeTypedArray(this.icons_value, 0);
        parcel.writeTypedArray(this.location_value, 0);
        parcel.writeTypedArray(this.saleinfo_value, 0);
        parcel.writeTypedArray(this.vehicle_value, 0);
        parcel.writeStringList(this.thumbnailimages_value);
        parcel.writeStringList(this.fullImages_value);
        parcel.writeStringList(this.recipts_value);
        parcel.writeTypedArray(this.reports_value, 0);
        parcel.writeParcelable(this.lights, 0);
        parcel.writeTypedArray(this.DeepZoomImages, 0);
    }
}
