package com.iaai.android.bdt.feature.auctionSalesList;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iaai.android.bdt.feature.auctionSalesList.SortAdapter;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SortAdapter.kt */
final class SortAdapter$ViewHolderHeader$bind$1 implements View.OnClickListener {
    final /* synthetic */ SortAdapter.ViewHolderHeader this$0;

    SortAdapter$ViewHolderHeader$bind$1(SortAdapter.ViewHolderHeader viewHolderHeader) {
        this.this$0 = viewHolderHeader;
    }

    public final void onClick(View view) {
        TextView textView = this.this$0.getBinding().locationSort;
        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.locationSort");
        textView.setSelected(true);
        RelativeLayout relativeLayout = this.this$0.getBinding().rlZipCodeMain;
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "binding.rlZipCodeMain");
        relativeLayout.setSelected(false);
        SortAdapter.access$getOnItemClickListener$p(this.this$0.this$0).onItemClick(new SortOptionData(Constants_MVVM.SORT_MY_LOCATION_KEY, "", "0", true), 0);
    }
}
