package com.iaai.android.bdt.feature.productDetail;

import android.app.Application;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$initializeUI$16 implements View.OnClickListener {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$initializeUI$16(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onClick(View view) {
        BaseActivity access$getBaseActivity$p = this.this$0.baseActivity;
        if (access$getBaseActivity$p == null) {
            Intrinsics.throwNpe();
        }
        Application application = access$getBaseActivity$p.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        if (!IAASharedPreference.getVinDetailsViewLessPreferencesMVVM(application.getApplicationContext()).booleanValue()) {
            BaseActivity access$getBaseActivity$p2 = this.this$0.baseActivity;
            if (access$getBaseActivity$p2 == null) {
                Intrinsics.throwNpe();
            }
            Application application2 = access$getBaseActivity$p2.getApplication();
            Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
            IAASharedPreference.setVinDetailsViewLessPreferencesMVVM(application2.getApplicationContext(), true);
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.txtVinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(textView, "txtVinViewMore");
            textView.setText(this.this$0.getString(C2723R.string.lbl_view_less));
            ((ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ic_vin_view_more)).setImageDrawable(this.this$0.getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
            ProductDetailFragment.access$getVininfoAdapter$p(this.this$0).notifyDataSetChanged();
            ProductDetailFragment.access$getPartsInfoAdapter$p(this.this$0).notifyDataSetChanged();
            return;
        }
        BaseActivity access$getBaseActivity$p3 = this.this$0.baseActivity;
        if (access$getBaseActivity$p3 == null) {
            Intrinsics.throwNpe();
        }
        Application application3 = access$getBaseActivity$p3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application3, "baseActivity!!.application");
        IAASharedPreference.setVinDetailsViewLessPreferencesMVVM(application3.getApplicationContext(), false);
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.txtVinViewMore);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "txtVinViewMore");
        textView2.setText(this.this$0.getString(C2723R.string.lbl_view_more));
        ((ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ic_vin_view_more)).setImageDrawable(this.this$0.getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
        ProductDetailFragment.access$getVininfoAdapter$p(this.this$0).notifyDataSetChanged();
        ProductDetailFragment.access$getPartsInfoAdapter$p(this.this$0).notifyDataSetChanged();
    }
}
