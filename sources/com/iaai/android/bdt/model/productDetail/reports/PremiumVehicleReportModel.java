package com.iaai.android.bdt.model.productDetail.reports;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/reports/PremiumVehicleReportModel;", "", "FilePath", "", "HtmlContent", "StatusCode", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getFilePath", "()Ljava/lang/String;", "getHtmlContent", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PremiumVehicleReportModel.kt */
public final class PremiumVehicleReportModel {
    @NotNull
    private final String FilePath;
    @NotNull
    private final String HtmlContent;
    private final int StatusCode;

    @NotNull
    public static /* synthetic */ PremiumVehicleReportModel copy$default(PremiumVehicleReportModel premiumVehicleReportModel, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = premiumVehicleReportModel.FilePath;
        }
        if ((i2 & 2) != 0) {
            str2 = premiumVehicleReportModel.HtmlContent;
        }
        if ((i2 & 4) != 0) {
            i = premiumVehicleReportModel.StatusCode;
        }
        return premiumVehicleReportModel.copy(str, str2, i);
    }

    @NotNull
    public final String component1() {
        return this.FilePath;
    }

    @NotNull
    public final String component2() {
        return this.HtmlContent;
    }

    public final int component3() {
        return this.StatusCode;
    }

    @NotNull
    public final PremiumVehicleReportModel copy(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "FilePath");
        Intrinsics.checkParameterIsNotNull(str2, "HtmlContent");
        return new PremiumVehicleReportModel(str, str2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PremiumVehicleReportModel) {
                PremiumVehicleReportModel premiumVehicleReportModel = (PremiumVehicleReportModel) obj;
                if (Intrinsics.areEqual((Object) this.FilePath, (Object) premiumVehicleReportModel.FilePath) && Intrinsics.areEqual((Object) this.HtmlContent, (Object) premiumVehicleReportModel.HtmlContent)) {
                    if (this.StatusCode == premiumVehicleReportModel.StatusCode) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.FilePath;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.HtmlContent;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + Integer.valueOf(this.StatusCode).hashCode();
    }

    @NotNull
    public String toString() {
        return "PremiumVehicleReportModel(FilePath=" + this.FilePath + ", HtmlContent=" + this.HtmlContent + ", StatusCode=" + this.StatusCode + ")";
    }

    public PremiumVehicleReportModel(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "FilePath");
        Intrinsics.checkParameterIsNotNull(str2, "HtmlContent");
        this.FilePath = str;
        this.HtmlContent = str2;
        this.StatusCode = i;
    }

    @NotNull
    public final String getFilePath() {
        return this.FilePath;
    }

    @NotNull
    public final String getHtmlContent() {
        return this.HtmlContent;
    }

    public final int getStatusCode() {
        return this.StatusCode;
    }
}
