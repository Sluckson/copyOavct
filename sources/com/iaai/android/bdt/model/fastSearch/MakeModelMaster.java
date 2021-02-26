package com.iaai.android.bdt.model.fastSearch;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J%\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/MakeModelMaster;", "", "Make", "", "Models", "", "(Ljava/lang/String;Ljava/util/List;)V", "getMake", "()Ljava/lang/String;", "getModels", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelMaster.kt */
public final class MakeModelMaster {
    @NotNull
    private final String Make;
    @Nullable
    private final List<String> Models;

    @NotNull
    public static /* synthetic */ MakeModelMaster copy$default(MakeModelMaster makeModelMaster, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = makeModelMaster.Make;
        }
        if ((i & 2) != 0) {
            list = makeModelMaster.Models;
        }
        return makeModelMaster.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.Make;
    }

    @Nullable
    public final List<String> component2() {
        return this.Models;
    }

    @NotNull
    public final MakeModelMaster copy(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, ExifInterface.TAG_MAKE);
        return new MakeModelMaster(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MakeModelMaster)) {
            return false;
        }
        MakeModelMaster makeModelMaster = (MakeModelMaster) obj;
        return Intrinsics.areEqual((Object) this.Make, (Object) makeModelMaster.Make) && Intrinsics.areEqual((Object) this.Models, (Object) makeModelMaster.Models);
    }

    public int hashCode() {
        String str = this.Make;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.Models;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "MakeModelMaster(Make=" + this.Make + ", Models=" + this.Models + ")";
    }

    public MakeModelMaster(@NotNull String str, @Nullable List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, ExifInterface.TAG_MAKE);
        this.Make = str;
        this.Models = list;
    }

    @NotNull
    public final String getMake() {
        return this.Make;
    }

    @Nullable
    public final List<String> getModels() {
        return this.Models;
    }
}
