package com.iaai.android.bdt.model.productDetail.biddingInfo;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J_\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006)"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInformation;", "Ljava/io/Serializable;", "Title", "", "ToolTip", "DisplayConditionReport", "DisplayInstaVinReport", "", "DisplayPremiumReport", "PartsInfoExist", "ConditionInfo", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInfo;", "EnableInteractFeature", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/util/List;Z)V", "getConditionInfo", "()Ljava/util/List;", "getDisplayConditionReport", "()Ljava/lang/String;", "getDisplayInstaVinReport", "()Z", "getDisplayPremiumReport", "getEnableInteractFeature", "getPartsInfoExist", "getTitle", "getToolTip", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ConditionInformation.kt */
public final class ConditionInformation implements Serializable {
    @NotNull
    private final List<ConditionInfo> ConditionInfo;
    @NotNull
    private final String DisplayConditionReport;
    private final boolean DisplayInstaVinReport;
    private final boolean DisplayPremiumReport;
    private final boolean EnableInteractFeature;
    private final boolean PartsInfoExist;
    @NotNull
    private final String Title;
    @NotNull
    private final String ToolTip;

    @NotNull
    public static /* synthetic */ ConditionInformation copy$default(ConditionInformation conditionInformation, String str, String str2, String str3, boolean z, boolean z2, boolean z3, List list, boolean z4, int i, Object obj) {
        ConditionInformation conditionInformation2 = conditionInformation;
        int i2 = i;
        return conditionInformation.copy((i2 & 1) != 0 ? conditionInformation2.Title : str, (i2 & 2) != 0 ? conditionInformation2.ToolTip : str2, (i2 & 4) != 0 ? conditionInformation2.DisplayConditionReport : str3, (i2 & 8) != 0 ? conditionInformation2.DisplayInstaVinReport : z, (i2 & 16) != 0 ? conditionInformation2.DisplayPremiumReport : z2, (i2 & 32) != 0 ? conditionInformation2.PartsInfoExist : z3, (i2 & 64) != 0 ? conditionInformation2.ConditionInfo : list, (i2 & 128) != 0 ? conditionInformation2.EnableInteractFeature : z4);
    }

    @NotNull
    public final String component1() {
        return this.Title;
    }

    @NotNull
    public final String component2() {
        return this.ToolTip;
    }

    @NotNull
    public final String component3() {
        return this.DisplayConditionReport;
    }

    public final boolean component4() {
        return this.DisplayInstaVinReport;
    }

    public final boolean component5() {
        return this.DisplayPremiumReport;
    }

    public final boolean component6() {
        return this.PartsInfoExist;
    }

    @NotNull
    public final List<ConditionInfo> component7() {
        return this.ConditionInfo;
    }

    public final boolean component8() {
        return this.EnableInteractFeature;
    }

    @NotNull
    public final ConditionInformation copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, boolean z2, boolean z3, @NotNull List<ConditionInfo> list, boolean z4) {
        Intrinsics.checkParameterIsNotNull(str, "Title");
        Intrinsics.checkParameterIsNotNull(str2, "ToolTip");
        Intrinsics.checkParameterIsNotNull(str3, "DisplayConditionReport");
        List<ConditionInfo> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "ConditionInfo");
        return new ConditionInformation(str, str2, str3, z, z2, z3, list2, z4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ConditionInformation) {
                ConditionInformation conditionInformation = (ConditionInformation) obj;
                if (Intrinsics.areEqual((Object) this.Title, (Object) conditionInformation.Title) && Intrinsics.areEqual((Object) this.ToolTip, (Object) conditionInformation.ToolTip) && Intrinsics.areEqual((Object) this.DisplayConditionReport, (Object) conditionInformation.DisplayConditionReport)) {
                    if (this.DisplayInstaVinReport == conditionInformation.DisplayInstaVinReport) {
                        if (this.DisplayPremiumReport == conditionInformation.DisplayPremiumReport) {
                            if ((this.PartsInfoExist == conditionInformation.PartsInfoExist) && Intrinsics.areEqual((Object) this.ConditionInfo, (Object) conditionInformation.ConditionInfo)) {
                                if (this.EnableInteractFeature == conditionInformation.EnableInteractFeature) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.Title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ToolTip;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.DisplayConditionReport;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.DisplayInstaVinReport;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.DisplayPremiumReport;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.PartsInfoExist;
        if (z3) {
            z3 = true;
        }
        int i4 = (i3 + (z3 ? 1 : 0)) * 31;
        List<ConditionInfo> list = this.ConditionInfo;
        if (list != null) {
            i = list.hashCode();
        }
        int i5 = (i4 + i) * 31;
        boolean z4 = this.EnableInteractFeature;
        if (z4) {
            z4 = true;
        }
        return i5 + (z4 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "ConditionInformation(Title=" + this.Title + ", ToolTip=" + this.ToolTip + ", DisplayConditionReport=" + this.DisplayConditionReport + ", DisplayInstaVinReport=" + this.DisplayInstaVinReport + ", DisplayPremiumReport=" + this.DisplayPremiumReport + ", PartsInfoExist=" + this.PartsInfoExist + ", ConditionInfo=" + this.ConditionInfo + ", EnableInteractFeature=" + this.EnableInteractFeature + ")";
    }

    public ConditionInformation(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, boolean z2, boolean z3, @NotNull List<ConditionInfo> list, boolean z4) {
        Intrinsics.checkParameterIsNotNull(str, "Title");
        Intrinsics.checkParameterIsNotNull(str2, "ToolTip");
        Intrinsics.checkParameterIsNotNull(str3, "DisplayConditionReport");
        Intrinsics.checkParameterIsNotNull(list, "ConditionInfo");
        this.Title = str;
        this.ToolTip = str2;
        this.DisplayConditionReport = str3;
        this.DisplayInstaVinReport = z;
        this.DisplayPremiumReport = z2;
        this.PartsInfoExist = z3;
        this.ConditionInfo = list;
        this.EnableInteractFeature = z4;
    }

    @NotNull
    public final String getTitle() {
        return this.Title;
    }

    @NotNull
    public final String getToolTip() {
        return this.ToolTip;
    }

    @NotNull
    public final String getDisplayConditionReport() {
        return this.DisplayConditionReport;
    }

    public final boolean getDisplayInstaVinReport() {
        return this.DisplayInstaVinReport;
    }

    public final boolean getDisplayPremiumReport() {
        return this.DisplayPremiumReport;
    }

    public final boolean getPartsInfoExist() {
        return this.PartsInfoExist;
    }

    @NotNull
    public final List<ConditionInfo> getConditionInfo() {
        return this.ConditionInfo;
    }

    public final boolean getEnableInteractFeature() {
        return this.EnableInteractFeature;
    }
}
