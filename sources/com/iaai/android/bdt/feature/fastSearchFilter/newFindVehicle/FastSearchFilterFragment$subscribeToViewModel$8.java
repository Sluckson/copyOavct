package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
final class FastSearchFilterFragment$subscribeToViewModel$8<T> implements Observer<ArrayList<SavedSearchListResponse>> {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$subscribeToViewModel$8(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public final void onChanged(ArrayList<SavedSearchListResponse> arrayList) {
        boolean z = false;
        this.this$0.showLoadingIndicator(false);
        Log.d("SavedSearchResponse--->", "Success");
        this.this$0.searchList = arrayList;
        CharSequence currentSessionBuyerId = this.this$0.getSessionManager().getCurrentSessionBuyerId();
        if (currentSessionBuyerId == null || currentSessionBuyerId.length() == 0) {
            z = true;
        }
        if (z || !StringsKt.equals(this.this$0.getSessionManager().getCurrentSessionBuyerId(), "0", true)) {
            this.this$0.showSaveSearchDialog();
            return;
        }
        List access$getSearchList$p = this.this$0.searchList;
        if (access$getSearchList$p == null) {
            Intrinsics.throwNpe();
        }
        if (access$getSearchList$p.size() < 20) {
            this.this$0.showSaveSearchDialog();
        } else {
            this.this$0.showGuestSaveSearchAlertDialog();
        }
    }
}
