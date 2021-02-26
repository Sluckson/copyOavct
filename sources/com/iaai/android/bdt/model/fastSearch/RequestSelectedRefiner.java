package com.iaai.android.bdt.model.fastSearch;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/RequestSelectedRefiner;", "Landroid/os/Parcelable;", "RefinerTypeValue", "", "RefinerValue", "", "(Ljava/lang/String;Ljava/util/List;)V", "getRefinerTypeValue", "()Ljava/lang/String;", "getRefinerValue", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: RequestSelectedRefiner.kt */
public final class RequestSelectedRefiner implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String RefinerTypeValue;
    @NotNull
    private final List<String> RefinerValue;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new RequestSelectedRefiner(parcel.readString(), parcel.createStringArrayList());
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new RequestSelectedRefiner[i];
        }
    }

    @NotNull
    public static /* synthetic */ RequestSelectedRefiner copy$default(RequestSelectedRefiner requestSelectedRefiner, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestSelectedRefiner.RefinerTypeValue;
        }
        if ((i & 2) != 0) {
            list = requestSelectedRefiner.RefinerValue;
        }
        return requestSelectedRefiner.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.RefinerTypeValue;
    }

    @NotNull
    public final List<String> component2() {
        return this.RefinerValue;
    }

    @NotNull
    public final RequestSelectedRefiner copy(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, "RefinerTypeValue");
        Intrinsics.checkParameterIsNotNull(list, "RefinerValue");
        return new RequestSelectedRefiner(str, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestSelectedRefiner)) {
            return false;
        }
        RequestSelectedRefiner requestSelectedRefiner = (RequestSelectedRefiner) obj;
        return Intrinsics.areEqual((Object) this.RefinerTypeValue, (Object) requestSelectedRefiner.RefinerTypeValue) && Intrinsics.areEqual((Object) this.RefinerValue, (Object) requestSelectedRefiner.RefinerValue);
    }

    public int hashCode() {
        String str = this.RefinerTypeValue;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.RefinerValue;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "RequestSelectedRefiner(RefinerTypeValue=" + this.RefinerTypeValue + ", RefinerValue=" + this.RefinerValue + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.RefinerTypeValue);
        parcel.writeStringList(this.RefinerValue);
    }

    public RequestSelectedRefiner(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, "RefinerTypeValue");
        Intrinsics.checkParameterIsNotNull(list, "RefinerValue");
        this.RefinerTypeValue = str;
        this.RefinerValue = list;
    }

    @NotNull
    public final String getRefinerTypeValue() {
        return this.RefinerTypeValue;
    }

    @NotNull
    public final List<String> getRefinerValue() {
        return this.RefinerValue;
    }
}
