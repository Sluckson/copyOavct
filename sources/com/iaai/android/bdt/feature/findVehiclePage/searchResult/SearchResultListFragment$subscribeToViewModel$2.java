package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "vehicleTotalCount", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultListFragment.kt */
final class SearchResultListFragment$subscribeToViewModel$2<T> implements Observer<Integer> {
    final /* synthetic */ SearchResultListFragment this$0;

    SearchResultListFragment$subscribeToViewModel$2(SearchResultListFragment searchResultListFragment) {
        this.this$0 = searchResultListFragment;
    }

    public final void onChanged(Integer num) {
        Log.e("TEST", "search success");
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.SEARCH_SUCCESS, (Bundle) null, this.this$0.getSessionManager());
        SearchResultListFragment searchResultListFragment = this.this$0;
        if (num == null) {
            Intrinsics.throwNpe();
        }
        searchResultListFragment.totalCount = num.intValue();
        this.this$0.setToolBarTitle();
        SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).notifyDataSetChanged();
    }
}
