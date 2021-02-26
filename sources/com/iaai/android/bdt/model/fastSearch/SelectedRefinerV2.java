package com.iaai.android.bdt.model.fastSearch;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/SelectedRefinerV2;", "Landroid/os/Parcelable;", "RefinerTypeValue", "", "RefinerValue", "", "QuickLink", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getQuickLink", "()Z", "setQuickLink", "(Z)V", "getRefinerTypeValue", "()Ljava/lang/String;", "getRefinerValue", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: SelectedRefinerV2.kt */
public final class SelectedRefinerV2 implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private boolean QuickLink;
    @NotNull
    private final String RefinerTypeValue;
    @NotNull
    private final List<String> RefinerValue;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new SelectedRefinerV2(parcel.readString(), parcel.createStringArrayList(), parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new SelectedRefinerV2[i];
        }
    }

    @NotNull
    public static /* synthetic */ SelectedRefinerV2 copy$default(SelectedRefinerV2 selectedRefinerV2, String str, List<String> list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectedRefinerV2.RefinerTypeValue;
        }
        if ((i & 2) != 0) {
            list = selectedRefinerV2.RefinerValue;
        }
        if ((i & 4) != 0) {
            z = selectedRefinerV2.QuickLink;
        }
        return selectedRefinerV2.copy(str, list, z);
    }

    @NotNull
    public final String component1() {
        return this.RefinerTypeValue;
    }

    @NotNull
    public final List<String> component2() {
        return this.RefinerValue;
    }

    public final boolean component3() {
        return this.QuickLink;
    }

    @NotNull
    public final SelectedRefinerV2 copy(@NotNull String str, @NotNull List<String> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "RefinerTypeValue");
        Intrinsics.checkParameterIsNotNull(list, "RefinerValue");
        return new SelectedRefinerV2(str, list, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SelectedRefinerV2) {
                SelectedRefinerV2 selectedRefinerV2 = (SelectedRefinerV2) obj;
                if (Intrinsics.areEqual((Object) this.RefinerTypeValue, (Object) selectedRefinerV2.RefinerTypeValue) && Intrinsics.areEqual((Object) this.RefinerValue, (Object) selectedRefinerV2.RefinerValue)) {
                    if (this.QuickLink == selectedRefinerV2.QuickLink) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.RefinerTypeValue;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.RefinerValue;
        if (list != null) {
            i = list.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.QuickLink;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "SelectedRefinerV2(RefinerTypeValue=" + this.RefinerTypeValue + ", RefinerValue=" + this.RefinerValue + ", QuickLink=" + this.QuickLink + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.RefinerTypeValue);
        parcel.writeStringList(this.RefinerValue);
        parcel.writeInt(this.QuickLink ? 1 : 0);
    }

    public SelectedRefinerV2(@NotNull String str, @NotNull List<String> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "RefinerTypeValue");
        Intrinsics.checkParameterIsNotNull(list, "RefinerValue");
        this.RefinerTypeValue = str;
        this.RefinerValue = list;
        this.QuickLink = z;
    }

    @NotNull
    public final String getRefinerTypeValue() {
        return this.RefinerTypeValue;
    }

    @NotNull
    public final List<String> getRefinerValue() {
        return this.RefinerValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectedRefinerV2(String str, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? false : z);
    }

    public final boolean getQuickLink() {
        return this.QuickLink;
    }

    public final void setQuickLink(boolean z) {
        this.QuickLink = z;
    }
}
