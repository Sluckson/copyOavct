package com.iaai.android.bdt.feature.productDetail;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.iaai.android.C2723R;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$loadFindParts$1 implements View.OnClickListener {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$loadFindParts$1(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.this$0.getString(C2723R.string.find_parts_base_url));
        ProductDetailFragment productDetailFragment = this.this$0;
        sb.append(productDetailFragment.getString(C2723R.string.find_part_url, productDetailFragment.make, this.this$0.model, this.this$0.year));
        this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
    }
}
