package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.util.Log;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.model.saveSearch.SaveSearchResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/saveSearch/SaveSearchResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
final class FastSearchFilterFragment$subscribeToViewModel$6<T> implements Observer<SaveSearchResponse> {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$subscribeToViewModel$6(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public final void onChanged(SaveSearchResponse saveSearchResponse) {
        Log.d("saveSearchSuccess", "Success");
        IaaiApplication.isSavedSearch = true;
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvSaveSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvSaveSearch");
        textView.setText(this.this$0.getResources().getString(C2723R.string.lbl_search_saved));
        this.this$0.disableSavedSearch();
    }
}
