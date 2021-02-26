package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import android.util.Log;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchActivity.kt */
final class SavedSearchActivity$subscribeToViewModel$1<T> implements Observer<ArrayList<SavedSearchListResponse>> {
    final /* synthetic */ SavedSearchActivity this$0;

    SavedSearchActivity$subscribeToViewModel$1(SavedSearchActivity savedSearchActivity) {
        this.this$0 = savedSearchActivity;
    }

    public final void onChanged(ArrayList<SavedSearchListResponse> arrayList) {
        this.this$0.showLoadingIndicator(false);
        Log.d("SavedSearchResponse--->", "Success");
        if (arrayList.size() == 0) {
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llEmptySavedSearch);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llEmptySavedSearch);
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        SavedSearchAdapter access$getSavedSearchAdapter$p = SavedSearchActivity.access$getSavedSearchAdapter$p(this.this$0);
        Intrinsics.checkExpressionValueIsNotNull(arrayList, "it");
        access$getSavedSearchAdapter$p.setItemsList(arrayList);
        SavedSearchActivity.access$getSavedSearchAdapter$p(this.this$0).notifyDataSetChanged();
    }
}
