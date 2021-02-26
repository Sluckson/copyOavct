package com.iaai.android.bdt.feature.productDetail;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$setOnClickListeners$2 implements View.OnClickListener {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$setOnClickListeners$2(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onClick(View view) {
        Intent intent;
        String string = this.this$0.getString(C2723R.string.visit_impact_url_ca);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.visit_impact_url_ca)");
        String string2 = this.this$0.getString(C2723R.string.visit_impact_url_uk);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.visit_impact_url_uk)");
        Intent intent2 = null;
        if (Intrinsics.areEqual((Object) this.this$0.tenantCode, (Object) "CA")) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(string2));
        }
        this.this$0.startActivity(intent);
    }
}
