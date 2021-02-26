package com.iaai.android.bdt.feature.productDetail;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.p016ui.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$17<T> implements Observer<String> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$17(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(String str) {
        if (this.this$0.isAdded() && this.this$0.isViewAvalibale) {
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llTimedAuctionSection");
            linearLayout.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cd_bno_offer);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "cd_bno_offer");
            relativeLayout.setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "con_bno_main_layout");
            constraintLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cd_bno_nosale);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "cd_bno_nosale");
            relativeLayout2.setVisibility(0);
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_bno_nosale_currentbid);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_bno_nosale_currentbid");
            textView.setText(UiUtils.formatCurrencyFromString(this.this$0.preBidCurrentBid, false));
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_bno_nosale_maxbid);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_bno_nosale_maxbid");
            textView2.setText(this.this$0.formattedMyMax);
        }
    }
}
