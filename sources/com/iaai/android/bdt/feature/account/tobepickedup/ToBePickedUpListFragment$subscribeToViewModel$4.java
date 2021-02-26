package com.iaai.android.bdt.feature.account.tobepickedup;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "reposne", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpFragment.kt */
final class ToBePickedUpListFragment$subscribeToViewModel$4<T> implements Observer<ToBePickedUpResponse> {
    final /* synthetic */ ToBePickedUpListFragment this$0;

    ToBePickedUpListFragment$subscribeToViewModel$4(ToBePickedUpListFragment toBePickedUpListFragment) {
        this.this$0 = toBePickedUpListFragment;
    }

    public final void onChanged(ToBePickedUpResponse toBePickedUpResponse) {
        if (toBePickedUpResponse != null) {
            this.this$0.setDashBoardCountAtSharePreference(toBePickedUpResponse.getTotalCount());
            this.this$0.setToolbarCount(toBePickedUpResponse.getTotalCount());
        }
    }
}
