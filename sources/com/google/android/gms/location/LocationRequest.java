package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({1000})
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzab();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_PRIORITY", mo18230id = 1)
    private int priority;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_EXPIRE_AT", mo18230id = 5)
    private long zzaf;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_INTERVAL", mo18230id = 2)
    private long zzaw;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_FASTEST_INTERVAL", mo18230id = 3)
    private long zzax;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_EXPLICIT_FASTEST_INTERVAL", mo18230id = 4)
    private boolean zzay;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_SMALLEST_DISPLACEMENT", mo18230id = 7)
    private float zzaz;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_MAX_WAIT_TIME", mo18230id = 8)
    private long zzba;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_NUM_UPDATES", mo18230id = 6)
    private int zzx;

    public LocationRequest() {
        this.priority = 102;
        this.zzaw = 3600000;
        this.zzax = 600000;
        this.zzay = false;
        this.zzaf = Long.MAX_VALUE;
        this.zzx = Integer.MAX_VALUE;
        this.zzaz = 0.0f;
        this.zzba = 0;
    }

    @SafeParcelable.Constructor
    LocationRequest(@SafeParcelable.Param(mo18233id = 1) int i, @SafeParcelable.Param(mo18233id = 2) long j, @SafeParcelable.Param(mo18233id = 3) long j2, @SafeParcelable.Param(mo18233id = 4) boolean z, @SafeParcelable.Param(mo18233id = 5) long j3, @SafeParcelable.Param(mo18233id = 6) int i2, @SafeParcelable.Param(mo18233id = 7) float f, @SafeParcelable.Param(mo18233id = 8) long j4) {
        this.priority = i;
        this.zzaw = j;
        this.zzax = j2;
        this.zzay = z;
        this.zzaf = j3;
        this.zzx = i2;
        this.zzaz = f;
        this.zzba = j4;
    }

    @VisibleForTesting
    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zza(long j) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("invalid interval: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.priority == locationRequest.priority && this.zzaw == locationRequest.zzaw && this.zzax == locationRequest.zzax && this.zzay == locationRequest.zzay && this.zzaf == locationRequest.zzaf && this.zzx == locationRequest.zzx && this.zzaz == locationRequest.zzaz && getMaxWaitTime() == locationRequest.getMaxWaitTime();
    }

    public final long getExpirationTime() {
        return this.zzaf;
    }

    public final long getFastestInterval() {
        return this.zzax;
    }

    public final long getInterval() {
        return this.zzaw;
    }

    public final long getMaxWaitTime() {
        long j = this.zzba;
        long j2 = this.zzaw;
        return j < j2 ? j2 : j;
    }

    public final int getNumUpdates() {
        return this.zzx;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final float getSmallestDisplacement() {
        return this.zzaz;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.priority), Long.valueOf(this.zzaw), Float.valueOf(this.zzaz), Long.valueOf(this.zzba));
    }

    public final boolean isFastestIntervalExplicitlySet() {
        return this.zzay;
    }

    public final LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.zzaf = Long.MAX_VALUE;
        } else {
            this.zzaf = j + elapsedRealtime;
        }
        if (this.zzaf < 0) {
            this.zzaf = 0;
        }
        return this;
    }

    @VisibleForTesting
    public final LocationRequest setExpirationTime(long j) {
        this.zzaf = j;
        if (this.zzaf < 0) {
            this.zzaf = 0;
        }
        return this;
    }

    public final LocationRequest setFastestInterval(long j) {
        zza(j);
        this.zzay = true;
        this.zzax = j;
        return this;
    }

    public final LocationRequest setInterval(long j) {
        zza(j);
        this.zzaw = j;
        if (!this.zzay) {
            this.zzax = (long) (((double) this.zzaw) / 6.0d);
        }
        return this;
    }

    @VisibleForTesting
    public final LocationRequest setMaxWaitTime(long j) {
        zza(j);
        this.zzba = j;
        return this;
    }

    @VisibleForTesting
    public final LocationRequest setNumUpdates(int i) {
        if (i > 0) {
            this.zzx = i;
            return this;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("invalid numUpdates: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    @VisibleForTesting
    public final LocationRequest setPriority(int i) {
        if (i == 100 || i == 102 || i == 104 || i == 105) {
            this.priority = i;
            return this;
        }
        StringBuilder sb = new StringBuilder(28);
        sb.append("invalid quality: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    @VisibleForTesting
    public final LocationRequest setSmallestDisplacement(float f) {
        if (f >= 0.0f) {
            this.zzaz = f;
            return this;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("invalid displacement: ");
        sb.append(f);
        throw new IllegalArgumentException(sb.toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i = this.priority;
        sb.append(i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.priority != 105) {
            sb.append(" requested=");
            sb.append(this.zzaw);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzax);
        sb.append("ms");
        if (this.zzba > this.zzaw) {
            sb.append(" maxWait=");
            sb.append(this.zzba);
            sb.append("ms");
        }
        if (this.zzaz > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.zzaz);
            sb.append("m");
        }
        long j = this.zzaf;
        if (j != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.zzx != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.zzx);
        }
        sb.append(']');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.priority);
        SafeParcelWriter.writeLong(parcel, 2, this.zzaw);
        SafeParcelWriter.writeLong(parcel, 3, this.zzax);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzay);
        SafeParcelWriter.writeLong(parcel, 5, this.zzaf);
        SafeParcelWriter.writeInt(parcel, 6, this.zzx);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzaz);
        SafeParcelWriter.writeLong(parcel, 8, this.zzba);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
