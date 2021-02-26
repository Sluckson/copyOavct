package com.iaai.android.bdt.feature.account.watchlist;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment$onActivityCreated$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
public final class PreSaleListFragment$onActivityCreated$3 implements TextWatcher {
    final /* synthetic */ PreSaleListFragment this$0;

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    PreSaleListFragment$onActivityCreated$3(PreSaleListFragment preSaleListFragment) {
        this.this$0 = preSaleListFragment;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        if (editable == null) {
            Intrinsics.throwNpe();
        }
        if (editable.length() > 0) {
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivSearchClear);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivSearchClear");
            imageView.setVisibility(0);
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etVinSearch)).requestFocus();
            this.this$0.showSoftKeyboard();
            return;
        }
        ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivSearchClear);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivSearchClear");
        imageView2.setVisibility(8);
    }
}
