package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Intent;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentActivity.kt */
final class BDTPaymentActivity$initializeUI$1 implements View.OnClickListener {
    final /* synthetic */ NavController $navController;
    final /* synthetic */ BDTPaymentActivity this$0;

    BDTPaymentActivity$initializeUI$1(BDTPaymentActivity bDTPaymentActivity, NavController navController) {
        this.this$0 = bDTPaymentActivity;
        this.$navController = navController;
    }

    public final void onClick(View view) {
        NavDestination currentDestination = this.$navController.getCurrentDestination();
        if (currentDestination == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(currentDestination, "navController.currentDestination!!");
        if (currentDestination.getId() == C2723R.C2726id.toBeConfirmationFragment) {
            Intent intent = new Intent();
            intent.putExtra(Constants_MVVM.IS_FROM_CLOSE_FROM_CONFIRMATION, true);
            this.this$0.setResult(-1, intent);
            this.this$0.finish();
            return;
        }
        this.this$0.onBackPressed();
    }
}
