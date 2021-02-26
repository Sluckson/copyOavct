package com.iaai.android.bdt.feature.auctionSalesList;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.auctionSalesList.SortAdapter;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SortAdapter.kt */
final class SortAdapter$ViewHolderHeader$bind$2 implements View.OnClickListener {
    final /* synthetic */ SortAdapter.ViewHolderHeader this$0;

    SortAdapter$ViewHolderHeader$bind$2(SortAdapter.ViewHolderHeader viewHolderHeader) {
        this.this$0 = viewHolderHeader;
    }

    public final void onClick(View view) {
        if ((this.this$0.enteredZip.length() > 0) && !this.this$0.this$0.isEditAvailable) {
            RelativeLayout relativeLayout = this.this$0.getBinding().rlZipCodeMain;
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "binding.rlZipCodeMain");
            relativeLayout.setSelected(true);
            TextView textView = this.this$0.getBinding().locationSort;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.locationSort");
            textView.setSelected(false);
            this.this$0.getBinding().tvSortZip.setTextColor(this.this$0.this$0.getMContext().getResources().getColor(C2723R.C2724color.bdt_white));
            this.this$0.getBinding().tvZipCodeLabel.setTextColor(this.this$0.this$0.getMContext().getResources().getColor(C2723R.C2724color.bdt_white));
            SortAdapter.access$getOnItemClickListener$p(this.this$0.this$0).onItemClick(new SortOptionData(Constants_MVVM.SORT_ZIPCODE_KEY, this.this$0.enteredZip, "0", true), 0);
        }
    }
}
