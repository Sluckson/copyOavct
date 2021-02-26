package com.iaai.android.bdt.feature.account;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "onRefresh"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTMyAccountActivity.kt */
final class BDTMyAccountActivity$onCreate$2 implements SwipeRefreshLayout.OnRefreshListener {
    final /* synthetic */ BDTMyAccountActivity this$0;

    BDTMyAccountActivity$onCreate$2(BDTMyAccountActivity bDTMyAccountActivity) {
        this.this$0 = bDTMyAccountActivity;
    }

    public final void onRefresh() {
        this.this$0.isPullToRefresh = true;
        this.this$0.showLoadingIndicator(false);
        this.this$0.loadDashboardData();
    }
}
