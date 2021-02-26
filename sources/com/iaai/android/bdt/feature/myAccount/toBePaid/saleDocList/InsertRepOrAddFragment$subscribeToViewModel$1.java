package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.MyAccount.SaleDocCountryStateModel;
import com.iaai.android.bdt.model.MyAccount.SaleDocCountryStateParentModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocCountryStateParentModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddFragment.kt */
final class InsertRepOrAddFragment$subscribeToViewModel$1<T> implements Observer<SaleDocCountryStateParentModel> {
    final /* synthetic */ InsertRepOrAddFragment this$0;

    InsertRepOrAddFragment$subscribeToViewModel$1(InsertRepOrAddFragment insertRepOrAddFragment) {
        this.this$0 = insertRepOrAddFragment;
    }

    public final void onChanged(SaleDocCountryStateParentModel saleDocCountryStateParentModel) {
        this.this$0.countryMainList = saleDocCountryStateParentModel.getValue();
        List access$getCountryMainList$p = this.this$0.countryMainList;
        if (access$getCountryMainList$p.size() > 1) {
            CollectionsKt.sortWith(access$getCountryMainList$p, new C2752xb03ebb6e());
        }
        InsertRepOrAddFragment insertRepOrAddFragment = this.this$0;
        Collection arrayList = new ArrayList();
        for (Object next : saleDocCountryStateParentModel.getValue()) {
            if (Intrinsics.areEqual((Object) ((SaleDocCountryStateModel) next).getCountryCode(), (Object) "US")) {
                arrayList.add(next);
            }
        }
        insertRepOrAddFragment.filterStateList = (ArrayList) ((List) arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (SaleDocCountryStateModel stateName : this.this$0.filterStateList) {
            arrayList2.add(stateName.getStateName());
        }
        this.this$0.updateStateSpinner(arrayList2);
        if (this.this$0.deliveryMethod == DeliveryMethod.FED_EX) {
            ArrayList arrayList3 = new ArrayList();
            int i = 0;
            int i2 = 0;
            for (SaleDocCountryStateModel saleDocCountryStateModel : this.this$0.countryMainList) {
                if (Intrinsics.areEqual((Object) saleDocCountryStateModel.getCountryCode(), (Object) "US")) {
                    i = i2 - 1;
                }
                if (!arrayList3.contains(saleDocCountryStateModel.getCountryName())) {
                    i2++;
                    arrayList3.add(saleDocCountryStateModel.getCountryName());
                    this.this$0.countryFilteredList.add(saleDocCountryStateModel);
                }
            }
            this.this$0.updateCountrySpinner(arrayList3, i);
        }
    }
}
