package com.iaai.android.bdt.feature.productDetail;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.productDetail.buyNowOffer.BDTBuyNowOfferResult;
import com.iaai.android.old.utils.p016ui.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "bdtBuyNowOfferResult", "Lcom/iaai/android/bdt/model/productDetail/buyNowOffer/BDTBuyNowOfferResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$15<T> implements Observer<BDTBuyNowOfferResult> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$15(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(BDTBuyNowOfferResult bDTBuyNowOfferResult) {
        if (bDTBuyNowOfferResult != null && this.this$0.isAdded() && this.this$0.isViewAvalibale) {
            if (!StringsKt.equals(bDTBuyNowOfferResult.getBIDLIMITCODE(), "0", true) || !StringsKt.equals(bDTBuyNowOfferResult.getWCBCODE(), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, true)) {
                Context context = this.this$0.getContext();
                if (context != null) {
                    Context_ExtensionKt.showToast(context, bDTBuyNowOfferResult.getERRORMESSAGE());
                    return;
                }
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llTimedAuctionSection");
            linearLayout.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cd_bno_offer);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "cd_bno_offer");
            relativeLayout.setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "con_bno_main_layout");
            constraintLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.cd_bno_won);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "cd_bno_won");
            relativeLayout2.setVisibility(0);
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_bno_won_offer_amont);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_bno_won_offer_amont");
            textView.setText(UiUtils.formatCurrencyFromString(String.valueOf(this.this$0.buyNowOfferAmount), true));
            this.this$0.sendFireBaseEventBuyNowOfferSuccess();
        }
    }
}
