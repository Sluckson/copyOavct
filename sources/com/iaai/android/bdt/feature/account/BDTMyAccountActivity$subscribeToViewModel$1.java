package com.iaai.android.bdt.feature.account;

import android.util.Log;
import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTMyAccountActivity.kt */
final class BDTMyAccountActivity$subscribeToViewModel$1<T> implements Observer<BDTDashboardResponse> {
    final /* synthetic */ BDTMyAccountActivity this$0;

    BDTMyAccountActivity$subscribeToViewModel$1(BDTMyAccountActivity bDTMyAccountActivity) {
        this.this$0 = bDTMyAccountActivity;
    }

    public final void onChanged(BDTDashboardResponse bDTDashboardResponse) {
        String tag = this.this$0.getTAG();
        Log.e(tag, "dashBoardResponse: " + bDTDashboardResponse);
        BDTMyAccountActivity bDTMyAccountActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(bDTDashboardResponse, "it");
        bDTMyAccountActivity.bdtDashboardResponse = bDTDashboardResponse;
        BDTMyAccountActivity bDTMyAccountActivity2 = this.this$0;
        bDTMyAccountActivity2.updateNewCountFirstTime(BDTMyAccountActivity.access$getBdtDashboardResponse$p(bDTMyAccountActivity2));
        BDTMyAccountActivity bDTMyAccountActivity3 = this.this$0;
        ViewPager viewPager = (ViewPager) bDTMyAccountActivity3._$_findCachedViewById(C2723R.C2726id.viewPager2);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "viewPager2");
        bDTMyAccountActivity3.setupViewPager(viewPager);
        this.this$0.showLoadingIndicator(false);
        if (this.this$0.isPullToRefresh) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.swipe_container);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipe_container");
            swipeRefreshLayout.setRefreshing(false);
            this.this$0.isPullToRefresh = false;
        }
    }
}
