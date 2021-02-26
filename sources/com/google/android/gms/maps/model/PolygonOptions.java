package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "PolygonOptionsCreator")
@SafeParcelable.Reserved({1})
public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getFillColor", mo18230id = 6)
    private int fillColor;
    @SafeParcelable.Field(getter = "getStrokeColor", mo18230id = 5)
    private int strokeColor;
    @SafeParcelable.Field(getter = "getStrokeWidth", mo18230id = 4)
    private float zzcr;
    @SafeParcelable.Field(getter = "getZIndex", mo18230id = 7)
    private float zzcs;
    @SafeParcelable.Field(getter = "isVisible", mo18230id = 8)
    private boolean zzct;
    @SafeParcelable.Field(getter = "isClickable", mo18230id = 10)
    private boolean zzcu;
    @SafeParcelable.Field(getter = "getStrokePattern", mo18230id = 12)
    @Nullable
    private List<PatternItem> zzcv;
    @SafeParcelable.Field(getter = "getPoints", mo18230id = 2)
    private final List<LatLng> zzdx;
    @SafeParcelable.Field(getter = "getHolesForParcel", mo18230id = 3, type = "java.util.List")
    private final List<List<LatLng>> zzdy;
    @SafeParcelable.Field(getter = "isGeodesic", mo18230id = 9)
    private boolean zzdz;
    @SafeParcelable.Field(getter = "getStrokeJointType", mo18230id = 11)
    private int zzea;

    public PolygonOptions() {
        this.zzcr = 10.0f;
        this.strokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzea = 0;
        this.zzcv = null;
        this.zzdx = new ArrayList();
        this.zzdy = new ArrayList();
    }

    @SafeParcelable.Constructor
    PolygonOptions(@SafeParcelable.Param(mo18233id = 2) List<LatLng> list, @SafeParcelable.Param(mo18233id = 3) List list2, @SafeParcelable.Param(mo18233id = 4) float f, @SafeParcelable.Param(mo18233id = 5) int i, @SafeParcelable.Param(mo18233id = 6) int i2, @SafeParcelable.Param(mo18233id = 7) float f2, @SafeParcelable.Param(mo18233id = 8) boolean z, @SafeParcelable.Param(mo18233id = 9) boolean z2, @SafeParcelable.Param(mo18233id = 10) boolean z3, @SafeParcelable.Param(mo18233id = 11) int i3, @SafeParcelable.Param(mo18233id = 12) @Nullable List<PatternItem> list3) {
        this.zzcr = 10.0f;
        this.strokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.fillColor = 0;
        this.zzcs = 0.0f;
        this.zzct = true;
        this.zzdz = false;
        this.zzcu = false;
        this.zzea = 0;
        this.zzcv = null;
        this.zzdx = list;
        this.zzdy = list2;
        this.zzcr = f;
        this.strokeColor = i;
        this.fillColor = i2;
        this.zzcs = f2;
        this.zzct = z;
        this.zzdz = z2;
        this.zzcu = z3;
        this.zzea = i3;
        this.zzcv = list3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getPoints(), false);
        SafeParcelWriter.writeList(parcel, 3, this.zzdy, false);
        SafeParcelWriter.writeFloat(parcel, 4, getStrokeWidth());
        SafeParcelWriter.writeInt(parcel, 5, getStrokeColor());
        SafeParcelWriter.writeInt(parcel, 6, getFillColor());
        SafeParcelWriter.writeFloat(parcel, 7, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 8, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 9, isGeodesic());
        SafeParcelWriter.writeBoolean(parcel, 10, isClickable());
        SafeParcelWriter.writeInt(parcel, 11, getStrokeJointType());
        SafeParcelWriter.writeTypedList(parcel, 12, getStrokePattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final PolygonOptions add(LatLng latLng) {
        this.zzdx.add(latLng);
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        this.zzdx.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.zzdx.add(add);
        }
        return this;
    }

    public final PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.zzdy.add(arrayList);
        return this;
    }

    public final PolygonOptions strokeWidth(float f) {
        this.zzcr = f;
        return this;
    }

    public final PolygonOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final PolygonOptions strokeJointType(int i) {
        this.zzea = i;
        return this;
    }

    public final PolygonOptions strokePattern(@Nullable List<PatternItem> list) {
        this.zzcv = list;
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final PolygonOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final PolygonOptions geodesic(boolean z) {
        this.zzdz = z;
        return this;
    }

    public final PolygonOptions clickable(boolean z) {
        this.zzcu = z;
        return this;
    }

    public final List<LatLng> getPoints() {
        return this.zzdx;
    }

    public final List<List<LatLng>> getHoles() {
        return this.zzdy;
    }

    public final float getStrokeWidth() {
        return this.zzcr;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeJointType() {
        return this.zzea;
    }

    @Nullable
    public final List<PatternItem> getStrokePattern() {
        return this.zzcv;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final boolean isGeodesic() {
        return this.zzdz;
    }

    public final boolean isClickable() {
        return this.zzcu;
    }
}
