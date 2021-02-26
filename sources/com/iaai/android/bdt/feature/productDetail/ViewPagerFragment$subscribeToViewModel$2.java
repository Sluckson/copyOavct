package com.iaai.android.bdt.feature.productDetail;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/fastSearch/FastSearchResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ViewPagerFragment.kt */
final class ViewPagerFragment$subscribeToViewModel$2<T> implements Observer<FastSearchResponse> {
    final /* synthetic */ ViewPagerFragment this$0;

    ViewPagerFragment$subscribeToViewModel$2(ViewPagerFragment viewPagerFragment) {
        this.this$0 = viewPagerFragment;
    }

    public final void onChanged(FastSearchResponse fastSearchResponse) {
        List<Vehicle> vehicles;
        Log.e("MESSAGE", "subscribeToViewModel");
        ArrayList arrayList = new ArrayList();
        if (!(fastSearchResponse == null || (vehicles = fastSearchResponse.getVehicles()) == null)) {
            for (Vehicle itemId : vehicles) {
                arrayList.add(String.valueOf(itemId.getItemId()));
            }
        }
        this.this$0.OnNextSlotOfItemID(arrayList);
    }
}
