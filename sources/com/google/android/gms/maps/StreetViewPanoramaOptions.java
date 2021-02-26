package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

@SafeParcelable.Class(creator = "StreetViewPanoramaOptionsCreator")
@SafeParcelable.Reserved({1})
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzai();
    @SafeParcelable.Field(getter = "getPanoramaId", mo18230id = 3)
    private String panoId;
    @SafeParcelable.Field(getter = "getPosition", mo18230id = 4)
    private LatLng position;
    @SafeParcelable.Field(getter = "getUseViewLifecycleInFragmentForParcel", mo18230id = 10, type = "byte")
    private Boolean zzak;
    @SafeParcelable.Field(getter = "getZoomGesturesEnabledForParcel", mo18230id = 7, type = "byte")
    private Boolean zzap = true;
    @SafeParcelable.Field(getter = "getStreetViewPanoramaCamera", mo18230id = 2)
    private StreetViewPanoramaCamera zzbx;
    @SafeParcelable.Field(getter = "getRadius", mo18230id = 5)
    private Integer zzby;
    @SafeParcelable.Field(getter = "getUserNavigationEnabledForParcel", mo18230id = 6, type = "byte")
    private Boolean zzbz = true;
    @SafeParcelable.Field(getter = "getPanningGesturesEnabledForParcel", mo18230id = 8, type = "byte")
    private Boolean zzca = true;
    @SafeParcelable.Field(getter = "getStreetNamesEnabledForParcel", mo18230id = 9, type = "byte")
    private Boolean zzcb = true;
    @SafeParcelable.Field(getter = "getSource", mo18230id = 11)
    private StreetViewSource zzcc = StreetViewSource.DEFAULT;

    @SafeParcelable.Constructor
    StreetViewPanoramaOptions(@SafeParcelable.Param(mo18233id = 2) StreetViewPanoramaCamera streetViewPanoramaCamera, @SafeParcelable.Param(mo18233id = 3) String str, @SafeParcelable.Param(mo18233id = 4) LatLng latLng, @SafeParcelable.Param(mo18233id = 5) Integer num, @SafeParcelable.Param(mo18233id = 6) byte b, @SafeParcelable.Param(mo18233id = 7) byte b2, @SafeParcelable.Param(mo18233id = 8) byte b3, @SafeParcelable.Param(mo18233id = 9) byte b4, @SafeParcelable.Param(mo18233id = 10) byte b5, @SafeParcelable.Param(mo18233id = 11) StreetViewSource streetViewSource) {
        this.zzbx = streetViewPanoramaCamera;
        this.position = latLng;
        this.zzby = num;
        this.panoId = str;
        this.zzbz = zza.zza(b);
        this.zzap = zza.zza(b2);
        this.zzca = zza.zza(b3);
        this.zzcb = zza.zza(b4);
        this.zzak = zza.zza(b5);
        this.zzcc = streetViewSource;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStreetViewPanoramaCamera(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getPanoramaId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getPosition(), i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, getRadius(), false);
        SafeParcelWriter.writeByte(parcel, 6, zza.zza(this.zzbz));
        SafeParcelWriter.writeByte(parcel, 7, zza.zza(this.zzap));
        SafeParcelWriter.writeByte(parcel, 8, zza.zza(this.zzca));
        SafeParcelWriter.writeByte(parcel, 9, zza.zza(this.zzcb));
        SafeParcelWriter.writeByte(parcel, 10, zza.zza(this.zzak));
        SafeParcelWriter.writeParcelable(parcel, 11, getSource(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public StreetViewPanoramaOptions() {
    }

    public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zzbx = streetViewPanoramaCamera;
        return this;
    }

    public final StreetViewPanoramaOptions panoramaId(String str) {
        this.panoId = str;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng) {
        this.position = latLng;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.position = latLng;
        this.zzby = num;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, Integer num, StreetViewSource streetViewSource) {
        this.position = latLng;
        this.zzby = num;
        this.zzcc = streetViewSource;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, StreetViewSource streetViewSource) {
        this.position = latLng;
        this.zzcc = streetViewSource;
        return this;
    }

    public final StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.zzbz = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.zzap = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.zzca = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.zzcb = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.zzak = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzbx;
    }

    public final LatLng getPosition() {
        return this.position;
    }

    public final Integer getRadius() {
        return this.zzby;
    }

    public final StreetViewSource getSource() {
        return this.zzcc;
    }

    public final String getPanoramaId() {
        return this.panoId;
    }

    public final Boolean getUserNavigationEnabled() {
        return this.zzbz;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.zzap;
    }

    public final Boolean getPanningGesturesEnabled() {
        return this.zzca;
    }

    public final Boolean getStreetNamesEnabled() {
        return this.zzcb;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.zzak;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("PanoramaId", this.panoId).add("Position", this.position).add("Radius", this.zzby).add("Source", this.zzcc).add("StreetViewPanoramaCamera", this.zzbx).add("UserNavigationEnabled", this.zzbz).add("ZoomGesturesEnabled", this.zzap).add("PanningGesturesEnabled", this.zzca).add("StreetNamesEnabled", this.zzcb).add("UseViewLifecycleInFragment", this.zzak).toString();
    }
}
