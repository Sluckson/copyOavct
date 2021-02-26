package com.iaai.android.bdt.feature.account.tobepickedup;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpResponse;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToPickedUpAccountActivity.kt */
final class ToPickedUpAccountActivity$subscribeToViewModel$1<T> implements Observer<ToBePickedUpResponse> {
    final /* synthetic */ ToPickedUpAccountActivity this$0;

    ToPickedUpAccountActivity$subscribeToViewModel$1(ToPickedUpAccountActivity toPickedUpAccountActivity) {
        this.this$0 = toPickedUpAccountActivity;
    }

    public final void onChanged(ToBePickedUpResponse toBePickedUpResponse) {
        List<ToBePickedUpVehiclesModel> vehicleArrayList;
        Log.e("Error", "subscribeToViewModel");
        ArrayList arrayList = new ArrayList();
        if (!(toBePickedUpResponse == null || (vehicleArrayList = toBePickedUpResponse.getVehicleArrayList()) == null)) {
            for (ToBePickedUpVehiclesModel itemId : vehicleArrayList) {
                arrayList.add(String.valueOf(itemId.getItemId()));
            }
        }
        ToPickedUpAccountActivity.access$getOnNextPageLoad$p(this.this$0).OnNextSlotOfItemID(arrayList);
    }
}
