package com.iaai.android.bdt.feature.auctionMainPage;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.findVehiclePage.SearchPanelFindVehicleActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListFragment.kt */
final class AuctionMainListFragment$handleKeywordSearch$1 implements View.OnClickListener {
    final /* synthetic */ AuctionMainListFragment this$0;

    AuctionMainListFragment$handleKeywordSearch$1(AuctionMainListFragment auctionMainListFragment) {
        this.this$0 = auctionMainListFragment;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0.getActivity(), SearchPanelFindVehicleActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_IS_AUCTION_SEARCH, true);
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etSearch);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etSearch");
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, editText.getText().toString());
        this.this$0.startActivityForResult(intent, 104);
    }
}
