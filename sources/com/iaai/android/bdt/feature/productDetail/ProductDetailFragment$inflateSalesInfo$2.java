package com.iaai.android.bdt.feature.productDetail;

import android.app.Dialog;
import android.view.View;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$inflateSalesInfo$2 implements View.OnClickListener {
    final /* synthetic */ String $remoteSaleInfoText;
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$inflateSalesInfo$2(ProductDetailFragment productDetailFragment, String str) {
        this.this$0 = productDetailFragment;
        this.$remoteSaleInfoText = str;
    }

    public final void onClick(View view) {
        BaseActivity access$getBaseActivity$p = this.this$0.baseActivity;
        if (access$getBaseActivity$p == null) {
            Intrinsics.throwNpe();
        }
        Dialog showToolTipHtml = Activity_ExtensionKt.showToolTipHtml(access$getBaseActivity$p, this.$remoteSaleInfoText);
        if (showToolTipHtml != null) {
            showToolTipHtml.show();
        }
    }
}
