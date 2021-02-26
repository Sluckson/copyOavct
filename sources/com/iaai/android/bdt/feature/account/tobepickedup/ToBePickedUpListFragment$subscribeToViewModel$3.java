package com.iaai.android.bdt.feature.account.tobepickedup;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "notUsed", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpFragment.kt */
final class ToBePickedUpListFragment$subscribeToViewModel$3<T> implements Observer<Integer> {
    final /* synthetic */ ToBePickedUpListFragment this$0;

    ToBePickedUpListFragment$subscribeToViewModel$3(ToBePickedUpListFragment toBePickedUpListFragment) {
        this.this$0 = toBePickedUpListFragment;
    }

    public final void onChanged(Integer num) {
        ((RecyclerView) this.this$0._$_findCachedViewById(C2723R.C2726id.rvWatchList)).scrollToPosition(0);
        ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
        this.this$0.showLoadingIndicator(false);
    }
}
