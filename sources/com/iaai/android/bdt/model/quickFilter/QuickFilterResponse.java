package com.iaai.android.bdt.model.quickFilter;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "Landroid/os/Parcelable;", "ActualValue", "", "DisplayValue", "Order", "", "Type", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getActualValue", "()Ljava/lang/String;", "getDisplayValue", "setDisplayValue", "(Ljava/lang/String;)V", "getOrder", "()I", "getType", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: QuickFilterResponse.kt */
public final class QuickFilterResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String ActualValue;
    @NotNull
    private String DisplayValue;
    private final int Order;
    @NotNull
    private final String Type;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new QuickFilterResponse(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new QuickFilterResponse[i];
        }
    }

    @NotNull
    public static /* synthetic */ QuickFilterResponse copy$default(QuickFilterResponse quickFilterResponse, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = quickFilterResponse.ActualValue;
        }
        if ((i2 & 2) != 0) {
            str2 = quickFilterResponse.DisplayValue;
        }
        if ((i2 & 4) != 0) {
            i = quickFilterResponse.Order;
        }
        if ((i2 & 8) != 0) {
            str3 = quickFilterResponse.Type;
        }
        return quickFilterResponse.copy(str, str2, i, str3);
    }

    @NotNull
    public final String component1() {
        return this.ActualValue;
    }

    @NotNull
    public final String component2() {
        return this.DisplayValue;
    }

    public final int component3() {
        return this.Order;
    }

    @NotNull
    public final String component4() {
        return this.Type;
    }

    @NotNull
    public final QuickFilterResponse copy(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "ActualValue");
        Intrinsics.checkParameterIsNotNull(str2, "DisplayValue");
        Intrinsics.checkParameterIsNotNull(str3, "Type");
        return new QuickFilterResponse(str, str2, i, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof QuickFilterResponse) {
                QuickFilterResponse quickFilterResponse = (QuickFilterResponse) obj;
                if (Intrinsics.areEqual((Object) this.ActualValue, (Object) quickFilterResponse.ActualValue) && Intrinsics.areEqual((Object) this.DisplayValue, (Object) quickFilterResponse.DisplayValue)) {
                    if (!(this.Order == quickFilterResponse.Order) || !Intrinsics.areEqual((Object) this.Type, (Object) quickFilterResponse.Type)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ActualValue;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.DisplayValue;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.valueOf(this.Order).hashCode()) * 31;
        String str3 = this.Type;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "QuickFilterResponse(ActualValue=" + this.ActualValue + ", DisplayValue=" + this.DisplayValue + ", Order=" + this.Order + ", Type=" + this.Type + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.ActualValue);
        parcel.writeString(this.DisplayValue);
        parcel.writeInt(this.Order);
        parcel.writeString(this.Type);
    }

    public QuickFilterResponse(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "ActualValue");
        Intrinsics.checkParameterIsNotNull(str2, "DisplayValue");
        Intrinsics.checkParameterIsNotNull(str3, "Type");
        this.ActualValue = str;
        this.DisplayValue = str2;
        this.Order = i;
        this.Type = str3;
    }

    @NotNull
    public final String getActualValue() {
        return this.ActualValue;
    }

    @NotNull
    public final String getDisplayValue() {
        return this.DisplayValue;
    }

    public final void setDisplayValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.DisplayValue = str;
    }

    public final int getOrder() {
        return this.Order;
    }

    @NotNull
    public final String getType() {
        return this.Type;
    }
}
