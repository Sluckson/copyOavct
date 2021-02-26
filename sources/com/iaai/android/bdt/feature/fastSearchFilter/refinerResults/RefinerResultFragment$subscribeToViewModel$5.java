package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "watchListResponse", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultFragment.kt */
final class RefinerResultFragment$subscribeToViewModel$5<T> implements Observer<UpdateWatchListResponse> {
    final /* synthetic */ RefinerResultFragment this$0;

    RefinerResultFragment$subscribeToViewModel$5(RefinerResultFragment refinerResultFragment) {
        this.this$0 = refinerResultFragment;
    }

    public final void onChanged(UpdateWatchListResponse updateWatchListResponse) {
        if (updateWatchListResponse != null && this.this$0.isAdded()) {
            if (Intrinsics.areEqual((Object) this.this$0.action, (Object) "add")) {
                RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).setWatchingData(true, this.this$0.itemIdWatch);
                RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).notifyItemChanged(this.this$0.indexToUpdate);
            } else if (Intrinsics.areEqual((Object) this.this$0.action, (Object) "delete")) {
                RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).setWatchingData(false, this.this$0.itemIdWatch);
                RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).notifyItemChanged(this.this$0.indexToUpdate);
            }
        }
    }
}
