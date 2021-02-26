package com.iaai.android.bdt.model.productDetail.chromeSection;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/chromeSection/ChromeData;", "", "FactOptionsData", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/FactOptionsData;", "GenEquipmentData", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/GenEquipmentData;", "StanEquipmentData", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/StanEquipmentData;", "TechSpecsData", "", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/TechSpecsData;", "(Lcom/iaai/android/bdt/model/productDetail/chromeSection/FactOptionsData;Lcom/iaai/android/bdt/model/productDetail/chromeSection/GenEquipmentData;Lcom/iaai/android/bdt/model/productDetail/chromeSection/StanEquipmentData;Ljava/util/List;)V", "getFactOptionsData", "()Lcom/iaai/android/bdt/model/productDetail/chromeSection/FactOptionsData;", "getGenEquipmentData", "()Lcom/iaai/android/bdt/model/productDetail/chromeSection/GenEquipmentData;", "getStanEquipmentData", "()Lcom/iaai/android/bdt/model/productDetail/chromeSection/StanEquipmentData;", "getTechSpecsData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ChromeData.kt */
public final class ChromeData {
    @NotNull
    private final FactOptionsData FactOptionsData;
    @NotNull
    private final GenEquipmentData GenEquipmentData;
    @NotNull
    private final StanEquipmentData StanEquipmentData;
    @NotNull
    private final List<TechSpecsData> TechSpecsData;

    @NotNull
    public static /* synthetic */ ChromeData copy$default(ChromeData chromeData, FactOptionsData factOptionsData, GenEquipmentData genEquipmentData, StanEquipmentData stanEquipmentData, List<TechSpecsData> list, int i, Object obj) {
        if ((i & 1) != 0) {
            factOptionsData = chromeData.FactOptionsData;
        }
        if ((i & 2) != 0) {
            genEquipmentData = chromeData.GenEquipmentData;
        }
        if ((i & 4) != 0) {
            stanEquipmentData = chromeData.StanEquipmentData;
        }
        if ((i & 8) != 0) {
            list = chromeData.TechSpecsData;
        }
        return chromeData.copy(factOptionsData, genEquipmentData, stanEquipmentData, list);
    }

    @NotNull
    public final FactOptionsData component1() {
        return this.FactOptionsData;
    }

    @NotNull
    public final GenEquipmentData component2() {
        return this.GenEquipmentData;
    }

    @NotNull
    public final StanEquipmentData component3() {
        return this.StanEquipmentData;
    }

    @NotNull
    public final List<TechSpecsData> component4() {
        return this.TechSpecsData;
    }

    @NotNull
    public final ChromeData copy(@NotNull FactOptionsData factOptionsData, @NotNull GenEquipmentData genEquipmentData, @NotNull StanEquipmentData stanEquipmentData, @NotNull List<TechSpecsData> list) {
        Intrinsics.checkParameterIsNotNull(factOptionsData, "FactOptionsData");
        Intrinsics.checkParameterIsNotNull(genEquipmentData, "GenEquipmentData");
        Intrinsics.checkParameterIsNotNull(stanEquipmentData, "StanEquipmentData");
        Intrinsics.checkParameterIsNotNull(list, "TechSpecsData");
        return new ChromeData(factOptionsData, genEquipmentData, stanEquipmentData, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChromeData)) {
            return false;
        }
        ChromeData chromeData = (ChromeData) obj;
        return Intrinsics.areEqual((Object) this.FactOptionsData, (Object) chromeData.FactOptionsData) && Intrinsics.areEqual((Object) this.GenEquipmentData, (Object) chromeData.GenEquipmentData) && Intrinsics.areEqual((Object) this.StanEquipmentData, (Object) chromeData.StanEquipmentData) && Intrinsics.areEqual((Object) this.TechSpecsData, (Object) chromeData.TechSpecsData);
    }

    public int hashCode() {
        FactOptionsData factOptionsData = this.FactOptionsData;
        int i = 0;
        int hashCode = (factOptionsData != null ? factOptionsData.hashCode() : 0) * 31;
        GenEquipmentData genEquipmentData = this.GenEquipmentData;
        int hashCode2 = (hashCode + (genEquipmentData != null ? genEquipmentData.hashCode() : 0)) * 31;
        StanEquipmentData stanEquipmentData = this.StanEquipmentData;
        int hashCode3 = (hashCode2 + (stanEquipmentData != null ? stanEquipmentData.hashCode() : 0)) * 31;
        List<TechSpecsData> list = this.TechSpecsData;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "ChromeData(FactOptionsData=" + this.FactOptionsData + ", GenEquipmentData=" + this.GenEquipmentData + ", StanEquipmentData=" + this.StanEquipmentData + ", TechSpecsData=" + this.TechSpecsData + ")";
    }

    public ChromeData(@NotNull FactOptionsData factOptionsData, @NotNull GenEquipmentData genEquipmentData, @NotNull StanEquipmentData stanEquipmentData, @NotNull List<TechSpecsData> list) {
        Intrinsics.checkParameterIsNotNull(factOptionsData, "FactOptionsData");
        Intrinsics.checkParameterIsNotNull(genEquipmentData, "GenEquipmentData");
        Intrinsics.checkParameterIsNotNull(stanEquipmentData, "StanEquipmentData");
        Intrinsics.checkParameterIsNotNull(list, "TechSpecsData");
        this.FactOptionsData = factOptionsData;
        this.GenEquipmentData = genEquipmentData;
        this.StanEquipmentData = stanEquipmentData;
        this.TechSpecsData = list;
    }

    @NotNull
    public final FactOptionsData getFactOptionsData() {
        return this.FactOptionsData;
    }

    @NotNull
    public final GenEquipmentData getGenEquipmentData() {
        return this.GenEquipmentData;
    }

    @NotNull
    public final StanEquipmentData getStanEquipmentData() {
        return this.StanEquipmentData;
    }

    @NotNull
    public final List<TechSpecsData> getTechSpecsData() {
        return this.TechSpecsData;
    }
}
