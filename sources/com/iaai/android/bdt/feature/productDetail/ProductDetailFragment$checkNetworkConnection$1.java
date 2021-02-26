package com.iaai.android.bdt.feature.productDetail;

import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "status", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$checkNetworkConnection$1<T> implements Observer<Boolean> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$checkNetworkConnection$1(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(Boolean bool) {
        if (bool != null && bool.booleanValue() && ((LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.emptyRecyclerView)) != null) {
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
            linearLayout.setVisibility(8);
            this.this$0.fetchProductDetail();
        }
    }
}
