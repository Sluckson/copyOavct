package com.iaai.android.bdt.feature.productDetail.prebid;

import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.lifecycle.Observer;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreBidFragment.kt */
final class PreBidFragment$subscribeToViewModel$3<T> implements Observer<String> {
    final /* synthetic */ PreBidFragment this$0;

    PreBidFragment$subscribeToViewModel$3(PreBidFragment preBidFragment) {
        this.this$0 = preBidFragment;
    }

    public final void onChanged(String str) {
        if (this.this$0.isAdded()) {
            ScrollView scrollView = (ScrollView) this.this$0._$_findCachedViewById(C2723R.C2726id.pre_bid_review_and_confirm_layout);
            Intrinsics.checkExpressionValueIsNotNull(scrollView, "pre_bid_review_and_confirm_layout");
            scrollView.setVisibility(8);
            ScrollView scrollView2 = (ScrollView) this.this$0._$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_layout);
            Intrinsics.checkExpressionValueIsNotNull(scrollView2, "pre_bid_submitted_layout");
            scrollView2.setVisibility(8);
            FrameLayout frameLayout = (FrameLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.place_pre_bid_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(frameLayout, "place_pre_bid_main_layout");
            frameLayout.setVisibility(0);
            TextInputLayout textInputLayout = (TextInputLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.txt_max_bid_layout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "txt_max_bid_layout");
            textInputLayout.setErrorEnabled(true);
            TextInputLayout textInputLayout2 = (TextInputLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.txt_max_bid_layout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "txt_max_bid_layout");
            textInputLayout2.setError(str);
        }
    }
}
