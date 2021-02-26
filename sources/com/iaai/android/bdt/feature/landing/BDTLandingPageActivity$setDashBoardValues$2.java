package com.iaai.android.bdt.feature.landing;

import android.content.Intent;
import android.view.View;
import com.iaai.android.old.activities.MDToBePaidListActivity;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLandingPageActivity.kt */
final class BDTLandingPageActivity$setDashBoardValues$2 implements View.OnClickListener {
    final /* synthetic */ BDTLandingPageActivity this$0;

    BDTLandingPageActivity$setDashBoardValues$2(BDTLandingPageActivity bDTLandingPageActivity) {
        this.this$0 = bDTLandingPageActivity;
    }

    public final void onClick(View view) {
        boolean z = !this.this$0.getSessionManager().isCurrentSessionUserOwner();
        Intent intent = new Intent(this.this$0, MDToBePaidListActivity.class);
        if (this.this$0.dashBoardDetails != null) {
            intent.putExtra(Constants.WATCHING_SIZE, this.this$0.getDashBoardDetails().getCountofvehicles());
            intent.putExtra(Constants.EXTRA_AWARD_PENDING_COUNT, this.this$0.getDashBoardDetails().getTotalCurrentBids());
            intent.putExtra(Constants.EXTRA_TOBPAID_TOTAL_DUE, UiUtils.formatCurrency(this.this$0.getDashBoardDetails().getTotaltobePaid(), true));
            intent.putExtra(Constants.EXTRA_TOBPAID_AW_AMOUNT, UiUtils.formatCurrency(this.this$0.getDashBoardDetails().getTotalAwardPending(), true));
        }
        intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, "0");
        this.this$0.startActivity(intent);
    }
}
