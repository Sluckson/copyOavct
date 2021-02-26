package com.iaai.android.bdt.model.productDetail.chromeSection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/chromeSection/HeaderValue;", "", "Measurement", "", "TitleName", "Value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMeasurement", "()Ljava/lang/String;", "getTitleName", "getValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: HeaderValue.kt */
public final class HeaderValue {
    @NotNull
    private final String Measurement;
    @NotNull
    private final String TitleName;
    @NotNull
    private final String Value;

    @NotNull
    public static /* synthetic */ HeaderValue copy$default(HeaderValue headerValue, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerValue.Measurement;
        }
        if ((i & 2) != 0) {
            str2 = headerValue.TitleName;
        }
        if ((i & 4) != 0) {
            str3 = headerValue.Value;
        }
        return headerValue.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.Measurement;
    }

    @NotNull
    public final String component2() {
        return this.TitleName;
    }

    @NotNull
    public final String component3() {
        return this.Value;
    }

    @NotNull
    public final HeaderValue copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "Measurement");
        Intrinsics.checkParameterIsNotNull(str2, "TitleName");
        Intrinsics.checkParameterIsNotNull(str3, "Value");
        return new HeaderValue(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderValue)) {
            return false;
        }
        HeaderValue headerValue = (HeaderValue) obj;
        return Intrinsics.areEqual((Object) this.Measurement, (Object) headerValue.Measurement) && Intrinsics.areEqual((Object) this.TitleName, (Object) headerValue.TitleName) && Intrinsics.areEqual((Object) this.Value, (Object) headerValue.Value);
    }

    public int hashCode() {
        String str = this.Measurement;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.TitleName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Value;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "HeaderValue(Measurement=" + this.Measurement + ", TitleName=" + this.TitleName + ", Value=" + this.Value + ")";
    }

    public HeaderValue(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "Measurement");
        Intrinsics.checkParameterIsNotNull(str2, "TitleName");
        Intrinsics.checkParameterIsNotNull(str3, "Value");
        this.Measurement = str;
        this.TitleName = str2;
        this.Value = str3;
    }

    @NotNull
    public final String getMeasurement() {
        return this.Measurement;
    }

    @NotNull
    public final String getTitleName() {
        return this.TitleName;
    }

    @NotNull
    public final String getValue() {
        return this.Value;
    }
}
