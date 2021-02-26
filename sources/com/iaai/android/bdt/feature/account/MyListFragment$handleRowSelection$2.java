package com.iaai.android.bdt.feature.account;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import com.iaai.android.old.activities.SSORegistrationActivity;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MyListFragment.kt */
final class MyListFragment$handleRowSelection$2 implements View.OnClickListener {
    final /* synthetic */ MyListFragment this$0;

    MyListFragment$handleRowSelection$2(MyListFragment myListFragment) {
        this.this$0 = myListFragment;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(MyListFragment.access$getBaseActivity$p(this.this$0), SSORegistrationActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        BDTDashboardResponse bdtDashboardResponse = this.this$0.getBdtDashboardResponse();
        intent.putExtra(Constants.EXTRA_SSO_URL, bdtDashboardResponse != null ? bdtDashboardResponse.getUpgradeLink() : null);
        this.this$0.startActivity(intent);
    }
}
