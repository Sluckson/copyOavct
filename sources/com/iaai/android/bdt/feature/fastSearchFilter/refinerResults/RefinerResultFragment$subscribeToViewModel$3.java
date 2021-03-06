package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.utils.NetworkState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "networkState", "Lcom/iaai/android/bdt/utils/NetworkState;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultFragment.kt */
final class RefinerResultFragment$subscribeToViewModel$3<T> implements Observer<NetworkState> {
    final /* synthetic */ RefinerResultFragment this$0;

    RefinerResultFragment$subscribeToViewModel$3(RefinerResultFragment refinerResultFragment) {
        this.this$0 = refinerResultFragment;
    }

    public final void onChanged(NetworkState networkState) {
        Intrinsics.checkExpressionValueIsNotNull(networkState, "networkState");
        if (networkState.getStatus() == NetworkState.Status.FAILED) {
            this.this$0.addHeaderOnResultList(true, BaseFragment.ErrorType.NO_STOCKS);
        }
    }
}
