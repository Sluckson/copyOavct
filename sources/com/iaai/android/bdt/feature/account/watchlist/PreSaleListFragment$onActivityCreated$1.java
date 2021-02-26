package com.iaai.android.bdt.feature.account.watchlist;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
final class PreSaleListFragment$onActivityCreated$1 implements View.OnClickListener {
    final /* synthetic */ PreSaleListFragment this$0;

    PreSaleListFragment$onActivityCreated$1(PreSaleListFragment preSaleListFragment) {
        this.this$0 = preSaleListFragment;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etVinSearch);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etVinSearch");
        Editable text = editText.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "etVinSearch.text");
        if (text.length() > 0) {
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etVinSearch)).setText("");
            EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etVinSearch);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "etVinSearch");
            editText2.getText().clear();
            this.this$0.mKeywordSearch = "";
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivSearchClear);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivSearchClear");
            imageView.setVisibility(8);
            this.this$0.hideSoftKeyboard();
            this.this$0.initializeRecycler();
            this.this$0.fetchWatchList();
        }
    }
}
