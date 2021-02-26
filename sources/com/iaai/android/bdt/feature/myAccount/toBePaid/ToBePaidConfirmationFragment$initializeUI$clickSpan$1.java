package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.utilsActivity.WebViewActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.activities.ContactUsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo66933d2 = {"com/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidConfirmationFragment$initializeUI$clickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidConfirmationFragment.kt */
public final class ToBePaidConfirmationFragment$initializeUI$clickSpan$1 extends ClickableSpan {
    final /* synthetic */ ToBePaidConfirmationFragment this$0;

    ToBePaidConfirmationFragment$initializeUI$clickSpan$1(ToBePaidConfirmationFragment toBePaidConfirmationFragment) {
        this.this$0 = toBePaidConfirmationFragment;
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "widget");
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getBorkerCommunityFlag()) {
            String string = this.this$0.getString(C2723R.string.url_broker_community_buyer_Service, Constants_MVVM.EXTRA_ENGLISH_CODE);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.url_b…_MVVM.EXTRA_ENGLISH_CODE)");
            if (Intrinsics.areEqual((Object) Utils.getLanguage(), (Object) Constants_MVVM.EXTRA_SPANISH_CODE)) {
                string = this.this$0.getString(C2723R.string.url_broker_community_buyer_Service, Constants_MVVM.EXTRA_SPANISH_CODE);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.url_b…_MVVM.EXTRA_SPANISH_CODE)");
            }
            String str = this.this$0.getString(C2723R.string.base_broker_community_url) + string;
            Intent intent = new Intent(this.this$0.getContext(), WebViewActivity.class);
            intent.putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, str);
            intent.putExtra(Constants_MVVM.EXTRA_BROKER_TITLE, "Buyer Services");
            this.this$0.startActivity(intent);
            return;
        }
        this.this$0.startActivity(new Intent(this.this$0.getContext(), ContactUsActivity.class));
    }
}
