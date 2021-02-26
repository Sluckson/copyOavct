package com.iaai.android.bdt.feature.account.watchlist;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "view", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
final class PreSaleListFragment$onActivityCreated$4 implements TextView.OnEditorActionListener {
    final /* synthetic */ PreSaleListFragment this$0;

    PreSaleListFragment$onActivityCreated$4(PreSaleListFragment preSaleListFragment) {
        this.this$0 = preSaleListFragment;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.this$0.hideSoftKeyboard();
        if (i != 2 && i != 6) {
            return false;
        }
        try {
            PreSaleListFragment preSaleListFragment = this.this$0;
            EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etVinSearch);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etVinSearch");
            preSaleListFragment.mKeywordSearch = editText.getText().toString();
            if (TextUtils.isEmpty(this.this$0.mKeywordSearch)) {
                return true;
            }
            this.this$0.fetchWatchList();
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }
}
