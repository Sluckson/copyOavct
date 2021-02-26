package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

@SafeParcelable.Class(creator = "GoogleMapOptionsCreator")
@SafeParcelable.Reserved({1})
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzaa();
    @SafeParcelable.Field(getter = "getMapType", mo18230id = 4)
    private int mapType = -1;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZOrderOnTopForParcel", mo18230id = 2, type = "byte")
    private Boolean zzaj;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getUseViewLifecycleInFragmentForParcel", mo18230id = 3, type = "byte")
    private Boolean zzak;
    @SafeParcelable.Field(getter = "getCamera", mo18230id = 5)
    private CameraPosition zzal;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZoomControlsEnabledForParcel", mo18230id = 6, type = "byte")
    private Boolean zzam;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getCompassEnabledForParcel", mo18230id = 7, type = "byte")
    private Boolean zzan;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getScrollGesturesEnabledForParcel", mo18230id = 8, type = "byte")
    private Boolean zzao;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZoomGesturesEnabledForParcel", mo18230id = 9, type = "byte")
    private Boolean zzap;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getTiltGesturesEnabledForParcel", mo18230id = 10, type = "byte")
    private Boolean zzaq;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getRotateGesturesEnabledForParcel", mo18230id = 11, type = "byte")
    private Boolean zzar;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getLiteModeForParcel", mo18230id = 12, type = "byte")
    private Boolean zzas;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getMapToolbarEnabledForParcel", mo18230id = 14, type = "byte")
    private Boolean zzat;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getAmbientEnabledForParcel", mo18230id = 15, type = "byte")
    private Boolean zzau;
    @SafeParcelable.Field(getter = "getMinZoomPreference", mo18230id = 16)
    private Float zzav = null;
    @SafeParcelable.Field(getter = "getMaxZoomPreference", mo18230id = 17)
    private Float zzaw = null;
    @SafeParcelable.Field(getter = "getLatLngBoundsForCameraTarget", mo18230id = 18)
    private LatLngBounds zzax = null;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getScrollGesturesEnabledDuringRotateOrZoomForParcel", mo18230id = 19, type = "byte")
    private Boolean zzay;

    @SafeParcelable.Constructor
    GoogleMapOptions(@SafeParcelable.Param(mo18233id = 2) byte b, @SafeParcelable.Param(mo18233id = 3) byte b2, @SafeParcelable.Param(mo18233id = 4) int i, @SafeParcelable.Param(mo18233id = 5) CameraPosition cameraPosition, @SafeParcelable.Param(mo18233id = 6) byte b3, @SafeParcelable.Param(mo18233id = 7) byte b4, @SafeParcelable.Param(mo18233id = 8) byte b5, @SafeParcelable.Param(mo18233id = 9) byte b6, @SafeParcelable.Param(mo18233id = 10) byte b7, @SafeParcelable.Param(mo18233id = 11) byte b8, @SafeParcelable.Param(mo18233id = 12) byte b9, @SafeParcelable.Param(mo18233id = 14) byte b10, @SafeParcelable.Param(mo18233id = 15) byte b11, @SafeParcelable.Param(mo18233id = 16) Float f, @SafeParcelable.Param(mo18233id = 17) Float f2, @SafeParcelable.Param(mo18233id = 18) LatLngBounds latLngBounds, @SafeParcelable.Param(mo18233id = 19) byte b12) {
        this.zzaj = zza.zza(b);
        this.zzak = zza.zza(b2);
        this.mapType = i;
        this.zzal = cameraPosition;
        this.zzam = zza.zza(b3);
        this.zzan = zza.zza(b4);
        this.zzao = zza.zza(b5);
        this.zzap = zza.zza(b6);
        this.zzaq = zza.zza(b7);
        this.zzar = zza.zza(b8);
        this.zzas = zza.zza(b9);
        this.zzat = zza.zza(b10);
        this.zzau = zza.zza(b11);
        this.zzav = f;
        this.zzaw = f2;
        this.zzax = latLngBounds;
        this.zzay = zza.zza(b12);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, zza.zza(this.zzaj));
        SafeParcelWriter.writeByte(parcel, 3, zza.zza(this.zzak));
        SafeParcelWriter.writeInt(parcel, 4, getMapType());
        SafeParcelWriter.writeParcelable(parcel, 5, getCamera(), i, false);
        SafeParcelWriter.writeByte(parcel, 6, zza.zza(this.zzam));
        SafeParcelWriter.writeByte(parcel, 7, zza.zza(this.zzan));
        SafeParcelWriter.writeByte(parcel, 8, zza.zza(this.zzao));
        SafeParcelWriter.writeByte(parcel, 9, zza.zza(this.zzap));
        SafeParcelWriter.writeByte(parcel, 10, zza.zza(this.zzaq));
        SafeParcelWriter.writeByte(parcel, 11, zza.zza(this.zzar));
        SafeParcelWriter.writeByte(parcel, 12, zza.zza(this.zzas));
        SafeParcelWriter.writeByte(parcel, 14, zza.zza(this.zzat));
        SafeParcelWriter.writeByte(parcel, 15, zza.zza(this.zzau));
        SafeParcelWriter.writeFloatObject(parcel, 16, getMinZoomPreference(), false);
        SafeParcelWriter.writeFloatObject(parcel, 17, getMaxZoomPreference(), false);
        SafeParcelWriter.writeParcelable(parcel, 18, getLatLngBoundsForCameraTarget(), i, false);
        SafeParcelWriter.writeByte(parcel, 19, zza.zza(this.zzay));
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public GoogleMapOptions() {
    }

    public final GoogleMapOptions zOrderOnTop(boolean z) {
        this.zzaj = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzak = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions mapType(int i) {
        this.mapType = i;
        return this;
    }

    public final GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzal = cameraPosition;
        return this;
    }

    public final GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zzam = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions compassEnabled(boolean z) {
        this.zzan = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzao = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzap = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzaq = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzar = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean z) {
        this.zzay = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions liteMode(boolean z) {
        this.zzas = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzat = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions ambientEnabled(boolean z) {
        this.zzau = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions minZoomPreference(float f) {
        this.zzav = Float.valueOf(f);
        return this;
    }

    public final GoogleMapOptions maxZoomPreference(float f) {
        this.zzaw = Float.valueOf(f);
        return this;
    }

    public final GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.zzax = latLngBounds;
        return this;
    }

    public final Boolean getZOrderOnTop() {
        return this.zzaj;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.zzak;
    }

    public final int getMapType() {
        return this.mapType;
    }

    public final CameraPosition getCamera() {
        return this.zzal;
    }

    public final Boolean getZoomControlsEnabled() {
        return this.zzam;
    }

    public final Boolean getCompassEnabled() {
        return this.zzan;
    }

    public final Boolean getScrollGesturesEnabled() {
        return this.zzao;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.zzap;
    }

    public final Boolean getTiltGesturesEnabled() {
        return this.zzaq;
    }

    public final Boolean getRotateGesturesEnabled() {
        return this.zzar;
    }

    public final Boolean getScrollGesturesEnabledDuringRotateOrZoom() {
        return this.zzay;
    }

    public final Boolean getLiteMode() {
        return this.zzas;
    }

    public final Boolean getMapToolbarEnabled() {
        return this.zzat;
    }

    public final Boolean getAmbientEnabled() {
        return this.zzau;
    }

    public final Float getMinZoomPreference() {
        return this.zzav;
    }

    public final Float getMaxZoomPreference() {
        return this.zzaw;
    }

    public final LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.zzax;
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C1297R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C1297R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom)) {
            googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom, true));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(C1297R.styleable.MapAttrs_ambientEnabled, false));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.minZoomPreference(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.maxZoomPreference(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.latLngBoundsForCameraTarget(zza(context, attributeSet));
        googleMapOptions.camera(zzb(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public static LatLngBounds zza(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C1297R.styleable.MapAttrs);
        Float valueOf = obtainAttributes.hasValue(C1297R.styleable.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float valueOf2 = obtainAttributes.hasValue(C1297R.styleable.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float valueOf3 = obtainAttributes.hasValue(C1297R.styleable.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float valueOf4 = obtainAttributes.hasValue(C1297R.styleable.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        obtainAttributes.recycle();
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    public static CameraPosition zzb(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C1297R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(C1297R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(C1297R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_cameraZoom)) {
            builder.zoom(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_cameraBearing)) {
            builder.bearing(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(C1297R.styleable.MapAttrs_cameraTilt)) {
            builder.tilt(obtainAttributes.getFloat(C1297R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        obtainAttributes.recycle();
        return builder.build();
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.mapType)).add("LiteMode", this.zzas).add("Camera", this.zzal).add("CompassEnabled", this.zzan).add("ZoomControlsEnabled", this.zzam).add("ScrollGesturesEnabled", this.zzao).add("ZoomGesturesEnabled", this.zzap).add("TiltGesturesEnabled", this.zzaq).add("RotateGesturesEnabled", this.zzar).add("ScrollGesturesEnabledDuringRotateOrZoom", this.zzay).add("MapToolbarEnabled", this.zzat).add("AmbientEnabled", this.zzau).add("MinZoomPreference", this.zzav).add("MaxZoomPreference", this.zzaw).add("LatLngBoundsForCameraTarget", this.zzax).add("ZOrderOnTop", this.zzaj).add("UseViewLifecycleInFragment", this.zzak).toString();
    }
}
