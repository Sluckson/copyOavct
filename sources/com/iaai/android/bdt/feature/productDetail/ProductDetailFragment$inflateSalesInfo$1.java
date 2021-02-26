package com.iaai.android.bdt.feature.productDetail;

import android.content.Intent;
import android.view.View;
import com.iaai.android.old.activities.MDLocationDetailActivity;
import com.iaai.android.old.fragments.MDLocationDetailFragment;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$inflateSalesInfo$1 implements View.OnClickListener {
    final /* synthetic */ int $branchCode;
    final /* synthetic */ String $value;
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$inflateSalesInfo$1(ProductDetailFragment productDetailFragment, int i, String str) {
        this.this$0 = productDetailFragment;
        this.$branchCode = i;
        this.$value = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0.getContext(), MDLocationDetailActivity.class);
        intent.putExtra("item_id", "" + this.$branchCode);
        intent.putExtra(MDLocationDetailFragment.ARG_BRANCH_NAME, this.$value);
        this.this$0.startActivity(intent);
    }
}
