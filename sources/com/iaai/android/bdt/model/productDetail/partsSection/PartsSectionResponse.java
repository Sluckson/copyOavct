package com.iaai.android.bdt.model.productDetail.partsSection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "", "InterchangeDescription", "", "InterchangeNumber", "PartName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInterchangeDescription", "()Ljava/lang/String;", "getInterchangeNumber", "getPartName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PartsSectionResponse.kt */
public final class PartsSectionResponse {
    @NotNull
    private final String InterchangeDescription;
    @NotNull
    private final String InterchangeNumber;
    @NotNull
    private final String PartName;

    @NotNull
    public static /* synthetic */ PartsSectionResponse copy$default(PartsSectionResponse partsSectionResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = partsSectionResponse.InterchangeDescription;
        }
        if ((i & 2) != 0) {
            str2 = partsSectionResponse.InterchangeNumber;
        }
        if ((i & 4) != 0) {
            str3 = partsSectionResponse.PartName;
        }
        return partsSectionResponse.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.InterchangeDescription;
    }

    @NotNull
    public final String component2() {
        return this.InterchangeNumber;
    }

    @NotNull
    public final String component3() {
        return this.PartName;
    }

    @NotNull
    public final PartsSectionResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "InterchangeDescription");
        Intrinsics.checkParameterIsNotNull(str2, "InterchangeNumber");
        Intrinsics.checkParameterIsNotNull(str3, "PartName");
        return new PartsSectionResponse(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartsSectionResponse)) {
            return false;
        }
        PartsSectionResponse partsSectionResponse = (PartsSectionResponse) obj;
        return Intrinsics.areEqual((Object) this.InterchangeDescription, (Object) partsSectionResponse.InterchangeDescription) && Intrinsics.areEqual((Object) this.InterchangeNumber, (Object) partsSectionResponse.InterchangeNumber) && Intrinsics.areEqual((Object) this.PartName, (Object) partsSectionResponse.PartName);
    }

    public int hashCode() {
        String str = this.InterchangeDescription;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.InterchangeNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.PartName;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "PartsSectionResponse(InterchangeDescription=" + this.InterchangeDescription + ", InterchangeNumber=" + this.InterchangeNumber + ", PartName=" + this.PartName + ")";
    }

    public PartsSectionResponse(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "InterchangeDescription");
        Intrinsics.checkParameterIsNotNull(str2, "InterchangeNumber");
        Intrinsics.checkParameterIsNotNull(str3, "PartName");
        this.InterchangeDescription = str;
        this.InterchangeNumber = str2;
        this.PartName = str3;
    }

    @NotNull
    public final String getInterchangeDescription() {
        return this.InterchangeDescription;
    }

    @NotNull
    public final String getInterchangeNumber() {
        return this.InterchangeNumber;
    }

    @NotNull
    public final String getPartName() {
        return this.PartName;
    }
}
