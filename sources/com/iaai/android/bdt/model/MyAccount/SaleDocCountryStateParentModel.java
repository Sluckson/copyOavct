package com.iaai.android.bdt.model.MyAccount;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/SaleDocCountryStateParentModel;", "", "value", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocCountryStateModel;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getValue", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocCountryStateParentModel.kt */
public final class SaleDocCountryStateParentModel {
    @NotNull
    private final ArrayList<SaleDocCountryStateModel> value;

    @NotNull
    public static /* synthetic */ SaleDocCountryStateParentModel copy$default(SaleDocCountryStateParentModel saleDocCountryStateParentModel, ArrayList<SaleDocCountryStateModel> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = saleDocCountryStateParentModel.value;
        }
        return saleDocCountryStateParentModel.copy(arrayList);
    }

    @NotNull
    public final ArrayList<SaleDocCountryStateModel> component1() {
        return this.value;
    }

    @NotNull
    public final SaleDocCountryStateParentModel copy(@NotNull ArrayList<SaleDocCountryStateModel> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "value");
        return new SaleDocCountryStateParentModel(arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SaleDocCountryStateParentModel) && Intrinsics.areEqual((Object) this.value, (Object) ((SaleDocCountryStateParentModel) obj).value);
        }
        return true;
    }

    public int hashCode() {
        ArrayList<SaleDocCountryStateModel> arrayList = this.value;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "SaleDocCountryStateParentModel(value=" + this.value + ")";
    }

    public SaleDocCountryStateParentModel(@NotNull ArrayList<SaleDocCountryStateModel> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "value");
        this.value = arrayList;
    }

    @NotNull
    public final ArrayList<SaleDocCountryStateModel> getValue() {
        return this.value;
    }
}
