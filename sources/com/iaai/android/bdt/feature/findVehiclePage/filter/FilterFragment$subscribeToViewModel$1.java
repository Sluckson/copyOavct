package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "fastSearchresponse", "Lcom/iaai/android/bdt/model/fastSearch/FastSearchResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
final class FilterFragment$subscribeToViewModel$1<T> implements Observer<FastSearchResponse> {
    final /* synthetic */ FilterFragment this$0;

    FilterFragment$subscribeToViewModel$1(FilterFragment filterFragment) {
        this.this$0 = filterFragment;
    }

    public final void onChanged(FastSearchResponse fastSearchResponse) {
        if (this.this$0.isFromVinScan) {
            r0 = null;
            this.this$0.isFromVinScan = false;
            this.this$0.scanValue = "";
            if (fastSearchResponse.getTotalVehicleCount() == 0) {
                FilterFragment filterFragment = this.this$0;
                String string = filterFragment.getString(C2723R.string.no_result_found);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.no_result_found)");
                filterFragment.showErrorMSGPopUp(string);
            } else {
                List<Vehicle> vehicles = fastSearchResponse.getVehicles();
                if (vehicles != null) {
                    for (Vehicle vehicle : vehicles) {
                    }
                }
                if (vehicle != null) {
                    this.this$0.navigateToProductDetailPage(vehicle);
                }
            }
        } else {
            Gson gson = new Gson();
            if (fastSearchResponse.getRefiners() != null) {
                FilterFragment filterFragment2 = this.this$0;
                String json = gson.toJson((Object) fastSearchResponse.getRefiners());
                Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(fastSearchresponse.Refiners)");
                filterFragment2.refinerJSON = json;
            }
            IAASharedPreference.setRefinerJson(this.this$0.getActivity(), this.this$0.refinerJSON);
            IAASharedPreference.setRefinerTimeStamp(this.this$0.getActivity(), System.currentTimeMillis());
            this.this$0.setFilterUI();
            this.this$0.showLoadingIndicator(false);
            if (!this.this$0.isFromFilterPage) {
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_applyfilter);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tv_applyfilter");
                textView.setText(this.this$0.getResources().getString(C2723R.string.see_results, new Object[]{BDTUtils.INSTANCE.getCountDisplay(fastSearchResponse.getTotalVehicleCount())}));
            }
            IaaiApplication.loadRefinerFirstTime = false;
        }
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
        linearLayout.setVisibility(8);
        Log.e("fastSearchListResult", "refinerList: " + this.this$0.refinerJSON);
    }
}
