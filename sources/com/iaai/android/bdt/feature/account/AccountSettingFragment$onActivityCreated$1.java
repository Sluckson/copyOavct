package com.iaai.android.bdt.feature.account;

import android.content.Context;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.model.medalliainfo.MedalliaFBRemoteConfigModel;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import com.medallia.digital.mobilesdk.MedalliaDigital;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AccountSettingFragment.kt */
final class AccountSettingFragment$onActivityCreated$1 implements View.OnClickListener {
    final /* synthetic */ AccountSettingFragment this$0;

    AccountSettingFragment$onActivityCreated$1(AccountSettingFragment accountSettingFragment) {
        this.this$0 = accountSettingFragment;
    }

    public final void onClick(View view) {
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel = instance.getIAARemoteConfig().getMedalliaFBRemoteConfigModel();
        if (medalliaFBRemoteConfigModel == null) {
            Intrinsics.checkExpressionValueIsNotNull(view, "v");
            Context context = view.getContext();
            BaseActivity access$getBaseActivity$p = AccountSettingFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p != null) {
                AppUtils.showFeedBackDialog(context, (IaaiApplication) access$getBaseActivity$p, (DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer), Constants.LIST_MY_ACCOUNT);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
        } else if (medalliaFBRemoteConfigModel.is_medallia_enabled()) {
            this.this$0.setCustomParameterForMedallia();
            MedalliaDigital.showForm(medalliaFBRemoteConfigModel.getFeedback_form_id(), new AccountSettingFragment$onActivityCreated$1$mdResultCallback$1());
        } else {
            Intrinsics.checkExpressionValueIsNotNull(view, "v");
            Context context2 = view.getContext();
            BaseActivity access$getBaseActivity$p2 = AccountSettingFragment.access$getBaseActivity$p(this.this$0);
            if (access$getBaseActivity$p2 != null) {
                AppUtils.showFeedBackDialog(context2, (IaaiApplication) access$getBaseActivity$p2, (DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer), Constants.LIST_MY_ACCOUNT);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
        }
    }
}
